package Presupuesto;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.presupuesto.EjecucionPresupuestalDAOImpl;
import com.genoma.plus.dao.presupuesto.EjecucionPresupuestalDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFLibroPresupuestal.class */
public class JIFLibroPresupuestal extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String[][] xPeriodo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Object[] xdatos;
    private EjecucionPresupuestalDAO ejecucionPresupuestalDAO;
    private String xSql;
    private JRadioButton Gastos;
    private JRadioButton Ingresos;
    private JButton JBTExportar;
    private JComboBox JCPeriodo;
    private JSpinner JSAnio;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup Libro;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFLibroPresupuestal() {
        initComponents();
        springStart();
        this.JSAnio.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())));
        mIniciaComponentes();
    }

    private void springStart() {
        this.ejecucionPresupuestalDAO = (EjecucionPresupuestalDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ejecucionPresupuestalDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Libro = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JCPeriodo = new JComboBox();
        this.JSAnio = new JSpinner();
        this.Ingresos = new JRadioButton();
        this.Gastos = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("LIBROS PRESUPUESTALES");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifLibroPresupuestal");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSAnio.setFont(new Font("Arial", 1, 12));
        this.JSAnio.setModel(new SpinnerNumberModel());
        this.JSAnio.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSAnio.addChangeListener(new ChangeListener() { // from class: Presupuesto.JIFLibroPresupuestal.1
            public void stateChanged(ChangeEvent evt) {
                JIFLibroPresupuestal.this.JSAnioStateChanged(evt);
            }
        });
        this.JSAnio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFLibroPresupuestal.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFLibroPresupuestal.this.JSAnioPropertyChange(evt);
            }
        });
        this.Libro.add(this.Ingresos);
        this.Ingresos.setFont(new Font("Arial", 1, 12));
        this.Ingresos.setSelected(true);
        this.Ingresos.setText("Libro Ingresos");
        this.Libro.add(this.Gastos);
        this.Gastos.setFont(new Font("Arial", 1, 12));
        this.Gastos.setText("Libro Gastos");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSAnio, -2, 79, -2).addGap(35, 35, 35).addComponent(this.JCPeriodo, -2, 294, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Ingresos).addComponent(this.Gastos)).addGap(149, 149, 149)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCPeriodo).addComponent(this.JSAnio)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.Ingresos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Gastos))).addGap(5, 5, 5)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFLibroPresupuestal.3
            public void mouseClicked(MouseEvent evt) {
                JIFLibroPresupuestal.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFLibroPresupuestal.4
            public void actionPerformed(ActionEvent evt) {
                JIFLibroPresupuestal.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 539, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 101, 32767).addComponent(this.JBTExportar, -2, 221, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 380, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 56, -2).addComponent(this.JBTExportar, -2, 56, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSAnioStateChanged(ChangeEvent evt) {
        mIniciaComponentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSAnioPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        String xTitulo;
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.Ingresos.isSelected()) {
                xTitulo = this.Ingresos.getText() + " - " + this.JCPeriodo.getSelectedItem() + " de " + this.JSAnio.getValue().toString();
            } else {
                xTitulo = this.Gastos.getText() + " - " + this.JCPeriodo.getSelectedItem() + " de " + this.JSAnio.getValue().toString();
            }
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), xTitulo.toUpperCase());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloLibroIngreso() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"DIA", "MES", "NUMERO", "CLASE", "SIGNO", "VALOR", "TIPO_DOC_SOPORTE", "NUMERO_DOC_SOPORTE", "IDENTIFICACION", "RUBRO", "AFORO_AUMENTO", "AFORO_DISMINUCION", "TOTAL_AFORO", "DERECHOS_CAUSADOS", "DERECHOS_ANULADOS", "EFECTIVO", "DEVOLUCION", "TOTAL_NUMERO", "UTILIZACION_REC_PAPELES", "EMISION_REC_PAPELES", "TOTAL_REC_PAPELES", "RECAUDO_BRUTO", "EJECUCION", "REVERSION", "TOTAL", "AFORO_SIN_EJECUTAR", "PENDIENTE_COBRO", "DESCRIPCION"}) { // from class: Presupuesto.JIFLibroPresupuestal.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(180);
    }

    private void mBuscaIngresos() {
        String sql = "SELECT PART1.DIA\n    , PART1.MES\n    , PART1.NUMERO\n    , PART1.CLASE\n   , PART1.SIGNO\n   , PART1.VALOR\n   , PART1.TipoDocSoporte TIPO_DOC_SOPORTE\n    , PART1.NumeroDocSoporte NUMERO_DOC_SOPORTE\n    , PART1.IDENTIFICACION\n    , PART1.Id_Rubro\n     , IFNULL((EJEC.Presupuesto_Inicial+EJEC.Adicion_Presupuesto),'0') AS AFORO_AUMENTO\n     ,IFNULL(EJEC.Reduccion_Presupuesto,'0') AS AFORO_DISMINUCION\n     , IFNULL(((EJEC.Presupuesto_Inicial+EJEC.Adicion_Presupuesto)-EJEC.Reduccion_Presupuesto),'0') AS TOTAL_AFORO\n     , 0 DERECHOS_CAUSADOS\n     ,0 DERECHO_ANULADOS\n    , IFNULL(EJEC.Recaudo_Total,'0') AS EFECTIVO\n    , 0 DEVOLUCION\n    , IFNULL((EJEC.Recaudo_Total-0),'0') AS TOTAL_NUMERO\n    , 0 UTILIZACION_REC_PAPELES\n    , 0 EMISION_REC_PAPELES\n    , 0 TOTAL_REC_PAPELES\n    , IFNULL(((EJEC.Recaudo_Total-0)+0),'0') RECAUDO_BRUTO\n    , 0 EJECUCION\n    , 0 REVERSION\n    , 0 TOTAL\n    , IFNULL(EJEC.Saldo_por_Ejecutar,'0') AS AFORO_SIN_EJECUTAR\n    , IFNULL(EJEC.Saldo_por_Recaudar,'0') AS PENDIENTE_COBRO\n    , IFNULL(PART1.Observacion,'') AS DESCRIPCION\n    FROM \n(SELECT\n    DATE_FORMAT(`pp_movimiento`.`FechaD`,'%d') AS Dia\n    , DATE_FORMAT(`pp_movimiento`.`FechaD`,'%m') AS Mes\n    , IF(`pp_movimiento`.`NoConcecutivo`=0,pp_detalle_movimiento.`Id`,`pp_movimiento`.`NoConcecutivo`) AS `Numero`\n    , IFNULL(`pp_tipo_documentos`.`Prefijo`,'') AS `Clase`\n   , IF(pp_detalle_movimiento.`Tipo`=0,'2','1') AS Signo\n   , pp_detalle_movimiento.`Valor`\n   , `pp_movimiento`.`DatoResolucion` AS TipoDocSoporte\n    , `pp_movimiento`.`DatoResolucion` AS NumeroDocSoporte\n    , IF(cc_terceros.`Id_TipoIdentificacion`='CC',`cc_terceros`.`No_identificacion`,CONCAT(`cc_terceros`.`No_identificacion`,IF(`cc_terceros`.`Dig_Verificacion`<>'','-',''), `cc_terceros`.`Dig_Verificacion`)) identificacion\n    , pp_detalle_movimiento.`Id_Rubro`\n    ,pp_movimiento.`Observacion`\nFROM\n    `pp_detalle_movimiento`\n    INNER JOIN `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN `cc_terceros` \n        ON (`pp_detalle_movimiento`.`Id_Tercero` = `cc_terceros`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` IN(2,3)\n    AND `pp_detalle_movimiento`.`Estado` =1 AND pp_movimiento.`Id_Periodo`='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][0] + "' AND pp_detalle_movimiento.idEncabezado='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][1] + "')\nORDER BY `pp_tipo_documentos`.`Id_ClaseDoc` ASC,`pp_movimiento`.`FechaD` DESC)PART1\n\nLEFT JOIN \n\n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n  ,Reconocimiento_Anterior\n ,Reconocimiento_Actual\n ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n ,Recaudo_Anterior\n ,Recaudo_Actual\n ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n ,Disponibilidad_Anterior  AS Certificado_Anterior\n ,Disponibilidad_Actual  AS Certificado_Actual\n , (Disponibilidad_Anterior+Disponibilidad_Actual) Total_Certificados\n ,Compromiso_Anterior\n ,Compromiso_Actual\n ,(Compromiso_Anterior+Compromiso_Actual) Compromiso_Total\n ,Obligacion_Anterior\n ,Obligacion_Actual\n ,(Obligacion_Anterior+Obligacion_Actual) Total_Obligaciones\n ,Pagos_Anterior\n ,Pagos_Actual\n ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- (Disponibilidad_Anterior+Disponibilidad_Actual)) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-(Compromiso_Anterior+Compromiso_Actual)) Sin_Comprometer\n ,((Compromiso_Anterior+Compromiso_Actual)-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n ,((Obligacion_Anterior+Obligacion_Actual)-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n ,((Disponibilidad_Anterior+Disponibilidad_Actual)-(Compromiso_Anterior+Compromiso_Actual)) Certificado_sin_Comprometer\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Reconocimiento_Anterior\n\n,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Reconocimiento_Actual\n\n,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Recaudo_Anterior\n\n,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Recaudo_Actual\n\n\n,CASE WHEN Id_CD IN(9,10)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n     WHEN Id_CD IN(11)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor*(-1)\n END Disponibilidad_Anterior\n\n,CASE WHEN Id_CD IN(9,10)  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n     WHEN Id_CD IN(11)  AND Id_Periodo=Periodo_Act  THEN\n     Valor*(-1)\n END Disponibilidad_Actual\n\n,CASE WHEN Id_CD IN(4,12)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n     WHEN Id_CD IN(13)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor*(-1)\n END Compromiso_Anterior\n \n ,CASE WHEN Id_CD IN(4,12)  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n     WHEN Id_CD IN(13)  AND Id_Periodo=Periodo_Act  THEN\n     Valor*(-1)\n END Compromiso_Actual\n \n,CASE WHEN Id_CD IN(5,14)  AND Id_Periodo<>Periodo_Act THEN\n  Valor\n    WHEN Id_CD IN(15)  AND Id_Periodo<>Periodo_Act  THEN\n  Valor*(-1)\n  END Obligacion_Anterior\n \n ,CASE WHEN Id_CD IN(5,14)  AND Id_Periodo=Periodo_Act THEN\n   Valor\n   WHEN Id_CD IN(15)  AND Id_Periodo=Periodo_Act  THEN\n   Valor*(-1)\n END Obligacion_Actual  \n ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Pagos_Anterior\n \n ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Pagos_Actual\n \n     \n FROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , pp_movimiento.Id_Periodo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    , @Periodo_Act Periodo_Act\n    \nFROM (SELECT @Periodo_Act:='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][0] + "') p,\n    pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE pp_detalle_movimiento.idEncabezado='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][1] + "' AND pp_periodo.Id IN ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n\t\t\t\tWHERE Id='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][0] + "' ) pact\n\t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n\t\t\t\tOR pact.Id=pant.id\n\t\t\t      ) \t\n    AND pp_movimiento.Id_MotivoAnulacion=1 \n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) mahoyosdatos\nWHERE TipoRubro='I')EJEC ON (PART1.Id_Rubro=EJEC.Id_R)\n";
        System.out.println("sqlIngresos-->" + sql);
        mCreaModeloLibroIngreso();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 10);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(12)), n, 11);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(13)), n, 12);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(14)), n, 13);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(15)), n, 14);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(16)), n, 15);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(17)), n, 16);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(18)), n, 17);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(19)), n, 18);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(20)), n, 19);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(21)), n, 20);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(22)), n, 21);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(23)), n, 22);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(24)), n, 23);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(25)), n, 24);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(26)), n, 25);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(27)), n, 26);
                    this.xmodelo.setValueAt(xrs.getString(28), n, 27);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLibroPresupuestal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimirInforme(String sql) {
        String xtitulo;
        if (this.Ingresos.isSelected()) {
            xtitulo = "LIBRO PRESUPUESTAL DE INGRESO";
        } else {
            xtitulo = "LIBRO PRESUPUESTAL DE GASTOS";
        }
        String[][] parametros = new String[6][2];
        parametros[0][0] = "Periodo";
        parametros[0][1] = this.JCPeriodo.getSelectedItem().toString();
        parametros[1][0] = "Titulo";
        parametros[1][1] = xtitulo;
        parametros[2][0] = "UsuarioS";
        parametros[2][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[5][0] = "SQL";
        parametros[5][1] = sql;
        if (xtitulo.equals("LIBRO PRESUPUESTAL DE INGRESO")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_Libro_Ingreso_Periodo", parametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_Libro_Egreso_Periodo", parametros);
        }
    }

    private void mBuscaGastos() {
        String sql = "SELECT PART1.DIA\n    , PART1.MES\n    , PART1.NUMERO\n    , PART1.CLASE\n    , PART1.SIGNO\n    , PART1.VALOR\n    , PART1.TipoDocSoporte TIPO_DOC_SOPORTE\n    , PART1.NumeroDocSoporte NUMERO_DOC_SOPORTE\n    , PART1.IDENTIFICACION AS TERCERO\n    , PART1.Id_Rubro\n    , (EJEC.Presupuesto_Inicial+EJEC.Adicion_Presupuesto+EJEC.Traslados_Creditos) AS AUMENTO\n    , (EJEC.Reduccion_Presupuesto+EJEC.Traslados_Debitos) AS DISMINUCION\n    , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) AS TOTAL\n    , 0 CONDICIONADA\n    , 0 LIBERADA\n    , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-0+0 AS APROPIACION_DISPONIBLE\n    , EJEC.Total_Certificados AS CDP_CONSTITUCION\n    , EJEC.Reintegro_Disponibilidad CDP_REVERSION\n    , (EJEC.Total_Certificados+EJEC.Reintegro_Disponibilidad) AS CDP_TOTAL\n    , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-0+0)-(EJEC.Total_Certificados-EJEC.Reintegro_Disponibilidad) AS APROPIACION_VIGENTE_NO_AFECTADA\n    , EJEC.Compromiso_Total AS RP_CONSTITUCION\n    , EJEC.Reintegro_Compromiso AS RP_REVERSION\n    , (EJEC.Compromiso_Total + EJEC.Reintegro_Compromiso) AS RP_TOTAL\n    , ((EJEC.Total_Certificados+EJEC.Reintegro_Disponibilidad)-(EJEC.Compromiso_Total + EJEC.Reintegro_Compromiso)) AS CDP_POR_COMPROMETER\n    , EJEC.Total_Obligaciones AS OBL_CONTRAIDAS\n    , EJEC.Reintegro_Obligacion AS OBL_REVERSION\n    , (EJEC.Total_Obligaciones+EJEC.Reintegro_Obligacion) AS OBL_TOTAL\n    , ((EJEC.Compromiso_Total + EJEC.Reintegro_Compromiso)-(EJEC.Total_Obligaciones-EJEC.Reintegro_Obligacion)) AS RP_POR_OBLIGAR\n    , EJEC.Total_Pagos AS PAG_EJECUCION\n    , 0 PAG_REVERSION\n    , EJEC.Total_Pagos PAG_TOTAL\n    , ((EJEC.Total_Obligaciones+EJEC.Reintegro_Obligacion)-EJEC.Total_Pagos) AS OBLI_POR_PAGAR\n    , IFNULL(PART1.Observacion,'') AS DESCRIPCION\n    FROM \n(SELECT\n    DATE_FORMAT(`pp_movimiento`.`FechaD`,'%d') AS Dia\n    , DATE_FORMAT(`pp_movimiento`.`FechaD`,'%m') AS Mes\n    , IF(`pp_movimiento`.`NoConcecutivo`=0,pp_detalle_movimiento.`Id`,`pp_movimiento`.`NoConcecutivo`) AS `Numero`\n    , IFNULL(`pp_tipo_documentos`.`Prefijo`,'') AS `Clase`\n   , IF(pp_detalle_movimiento.`Tipo`=0,'2','1') AS Signo\n   , pp_detalle_movimiento.`Valor`\n   , `pp_movimiento`.`DatoResolucion` AS TipoDocSoporte\n    , `pp_movimiento`.`DatoResolucion` AS NumeroDocSoporte\n    , IF(cc_terceros.`Id_TipoIdentificacion`='CC',`cc_terceros`.`No_identificacion`,CONCAT(`cc_terceros`.`No_identificacion`,IF(`cc_terceros`.`Dig_Verificacion`<>'','-',''), `cc_terceros`.`Dig_Verificacion`)) identificacion\n    , pp_detalle_movimiento.`Id_Rubro`\n    ,pp_movimiento.`Observacion`\nFROM\n    `pp_detalle_movimiento`\n    INNER JOIN `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN `cc_terceros` \n        ON (`pp_detalle_movimiento`.`Id_Tercero` = `cc_terceros`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` IN(4,5,6,9,10,11,12,13,14,15)\n    AND `pp_detalle_movimiento`.`Estado` =1 AND pp_movimiento.`Id_Periodo`='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][0] + "' AND pp_detalle_movimiento.`idEncabezado`='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][1] + "')\nORDER BY `pp_tipo_documentos`.`Id_ClaseDoc` ASC,`pp_movimiento`.`FechaD` DESC) PART1\n\nLEFT JOIN \n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n  ,Reconocimiento_Anterior\n ,Reconocimiento_Actual\n ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n ,Recaudo_Anterior\n ,Recaudo_Actual\n ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n ,Disponibilidad_Anterior  AS Certificado_Anterior\n ,Disponibilidad_Actual  AS Certificado_Actual\n , Reintegro_Disponibilidad\n , (Disponibilidad_Anterior+Disponibilidad_Actual) Total_Certificados\n ,Compromiso_Anterior\n ,Compromiso_Actual\n ,(Compromiso_Anterior+Compromiso_Actual) Compromiso_Total\n , Reintegro_Compromiso\n ,Obligacion_Anterior\n ,Obligacion_Actual\n ,(Obligacion_Anterior+Obligacion_Actual) Total_Obligaciones\n , Reintegro_Obligacion\n ,Pagos_Anterior\n ,Pagos_Actual\n ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- (Disponibilidad_Anterior+Disponibilidad_Actual)) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-(Compromiso_Anterior+Compromiso_Actual)) Sin_Comprometer\n ,((Compromiso_Anterior+Compromiso_Actual)-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n ,((Obligacion_Anterior+Obligacion_Actual)-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n ,((Disponibilidad_Anterior+Disponibilidad_Actual)-(Compromiso_Anterior+Compromiso_Actual)) Certificado_sin_Comprometer\n\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n,SUM(IFNULL(Reintegro_Disponibilidad,0)) Reintegro_Disponibilidad\n,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n,SUM(IFNULL(Reintegro_Compromiso,0)) Reintegro_Compromiso\n,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n,SUM(IFNULL(Reintegro_Obligacion,0)) Reintegro_Obligacion \n,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\n\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Reconocimiento_Anterior\n\n,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Reconocimiento_Actual\n\n,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Recaudo_Anterior\n\n,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Recaudo_Actual\n\n\n,CASE WHEN Id_CD IN(9,10)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n     -- WHEN Id_CD IN(11)  AND Id_Periodo<>Periodo_Act  THEN\n    -- Valor*(-1)\n END Disponibilidad_Anterior\n\n,CASE WHEN Id_CD IN(9,10)  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n     -- WHEN Id_CD IN(11)  AND Id_Periodo=Periodo_Act  THEN\n     -- Valor*(-1)\n END Disponibilidad_Actual\n\n,CASE WHEN Id_CD IN(11) THEN\n     Valor*(-1)\n END Reintegro_Disponibilidad\n\n,CASE WHEN Id_CD IN(4,12)  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n   --  WHEN Id_CD IN(13)  AND Id_Periodo<>Periodo_Act  THEN\n   --  Valor*(-1)\n END Compromiso_Anterior\n\n ,CASE WHEN Id_CD IN(4,12)  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n    -- WHEN Id_CD IN(13)  AND Id_Periodo=Periodo_Act  THEN\n    -- Valor*(-1)\n END Compromiso_Actual\n \n,CASE WHEN Id_CD IN(13) THEN\n     Valor*(-1)\n END Reintegro_Compromiso\n \n,CASE WHEN Id_CD IN(5,14)  AND Id_Periodo<>Periodo_Act THEN\n  Valor\n    -- WHEN Id_CD IN(15)  AND Id_Periodo<>Periodo_Act  THEN\n  -- Valor*(-1)\n  END Obligacion_Anterior\n \n ,CASE WHEN Id_CD IN(5,14)  AND Id_Periodo=Periodo_Act THEN\n   Valor\n   -- WHEN Id_CD IN(15)  AND Id_Periodo=Periodo_Act  THEN\n   -- Valor*(-1)\n END Obligacion_Actual\n \n ,CASE WHEN Id_CD IN(15) THEN\n     Valor*(-1)\n END Reintegro_Obligacion \n  \n ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Pagos_Anterior\n \n ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Pagos_Actual\n \n\n     \n FROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , pp_movimiento.Id_Periodo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    , @Periodo_Act Periodo_Act\n    \nFROM (SELECT @Periodo_Act:='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][0] + "') p,\n    pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE pp_detalle_movimiento.idEncabezado='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][1] + "' AND pp_periodo.Id IN ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n\t\t\t\tWHERE Id='" + this.xPeriodo[this.JCPeriodo.getSelectedIndex()][0] + "' ) pact\n\t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n\t\t\t\tOR pact.Id=pant.id\n\t\t\t      ) \t\n    AND pp_movimiento.Id_MotivoAnulacion=1 \n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) datos\nWHERE TipoRubro='G')EJEC ON (PART1.Id_Rubro=EJEC.Id_R) ";
        System.out.println("sqlGastos-->" + sql);
        mCreaModeloLibroGasto();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 10);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(12)), n, 11);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(13)), n, 12);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(14)), n, 13);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(15)), n, 14);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(16)), n, 15);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(17)), n, 16);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(18)), n, 17);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(19)), n, 18);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(20)), n, 19);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(21)), n, 20);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(22)), n, 21);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(23)), n, 22);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(24)), n, 23);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(25)), n, 24);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(26)), n, 25);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(27)), n, 26);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(28)), n, 27);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(29)), n, 28);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(30)), n, 29);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(31)), n, 30);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(32)), n, 31);
                    this.xmodelo.setValueAt(xrs.getString(33), n, 32);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLibroPresupuestal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloLibroGasto() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"DIA", "MES", "NUMERO", "CLASE", "SIGNO", "VALOR", "TIPO_DOC_SOPORTE", "NUMERO_DOC_SOPORTE", "TERCERO", "RUBRO", "APR_VIG_AUMENTO", "APR_VIG_DISMINUCION", "TOTAL_APR_VIG", "APR_VIG_CONDICIONADA", "APR_VIG_LIBERADA", "APR_VIG_DISPONIBLE", "CDP_CONSTITUCION", "CDP_REVERSION", "CDP_TOTAL", "APROPIACION_VIGENTE_NO_AFECTADA", "RP_CONSTITUCION", "RP_REVERSION", "RP_TOTAL", "CDP_POR_COMPROMETER", "OBL_CONTRAIDAS", "OBL_REVERSION", "OBL_TOTAL", "RP_POR_OBLIGAR", "PAG_EJECUCION", "PAG_REVERSION", "PAG_TOTAL", "OBLI_POR_PAGAR", "DESCRIPCION"}) { // from class: Presupuesto.JIFLibroPresupuestal.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(180);
    }

    public void buscar() {
        int xControl = 0;
        int i = 1;
        while (true) {
            if (i >= 20) {
                break;
            }
            if (this.ejecucionPresupuestalDAO.existeTable(String.valueOf(i))) {
                i++;
            } else {
                xControl = i;
                break;
            }
        }
        this.ejecucionPresupuestalDAO.executeQueryPTO(String.valueOf(xControl), this.xPeriodo[this.JCPeriodo.getSelectedIndex()][0], this.xPeriodo[this.JCPeriodo.getSelectedIndex()][1]);
        if (this.Ingresos.isSelected()) {
            this.xSql = this.ejecucionPresupuestalDAO.libroPresupuestalIngreso(String.valueOf(xControl), this.xPeriodo[this.JCPeriodo.getSelectedIndex()][0], this.xPeriodo[this.JCPeriodo.getSelectedIndex()][1]);
        } else {
            this.xSql = this.ejecucionPresupuestalDAO.libroPresupuestalGastos(String.valueOf(xControl), this.xPeriodo[this.JCPeriodo.getSelectedIndex()][0], this.xPeriodo[this.JCPeriodo.getSelectedIndex()][1]);
        }
        System.out.println("SQL:" + this.xSql);
        mImprimirInforme(this.xSql);
        this.ejecucionPresupuestalDAO.deleteTemporalTable(String.valueOf(xControl));
    }

    public void mBuscar() {
        if (this.JCPeriodo.getSelectedIndex() > -1) {
            if (this.Ingresos.isSelected()) {
                mBuscaIngresos();
                buscar();
                return;
            } else {
                mBuscaGastos();
                buscar();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCPeriodo.requestFocus();
    }

    private void mIniciaComponentes() {
        System.out.println("Entra a llenar combo");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCPeriodo.removeAllItems();
        this.xPeriodo = this.xct.llenarComboyLista("SELECT `Id` , `Nbre` , `idEncabezado` FROM `pp_periodo` WHERE (DATE_FORMAT(`FechaI`,'%Y') ='" + this.JSAnio.getValue().toString() + "')", this.xPeriodo, this.JCPeriodo, 3);
        this.JCPeriodo.setSelectedIndex(-1);
        System.out.println("sqlCombo-->" + this.JSAnio.getValue().toString());
        this.xct.cerrarConexionBd();
    }
}
