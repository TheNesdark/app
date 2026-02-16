package Presupuesto;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JtreeTable.MyAbstractTreeTableModel;
import Utilidades.JtreeTable.MyDataModel;
import Utilidades.JtreeTable.MyDataNode;
import Utilidades.JtreeTable.MyTreeTable;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFConsultaRubrosPeriodos.class */
public class JIFConsultaRubrosPeriodos extends JInternalFrame {
    private MyTreeTable myTreeTable;
    private MyAbstractTreeTableModel treeTableModel;
    String sql;
    private String idPeriodo;
    private String[] xid;
    private int filaGridI;
    private int filaGridG;
    private Object[] xdato;
    private DefaultTableModel modeloI;
    private DefaultTableModel modeloG;
    private DefaultTableModel xmodelop;
    private JButton JBTExportar;
    private JButton JBTOk;
    private JPanel JPI_FPeriodos;
    private JScrollPane JSP_FPeriodo;
    private JTable JTB_FPeriodo;
    private JTextField JTFRuta;
    private JYearChooser JYCAno;
    private ButtonGroup Tipo;
    private JTable gridG;
    private JTable gridI;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private Metodos xmt = new Metodos();
    private String xTipoR = "I";
    String xPeriodos = "";
    private int xUltimoN = 0;
    private int xAplicaTercero = 0;
    private Object[] datoI = {"", "", "", 0L, 0L, 0L, 0L, 0L, 0L, 0L};
    private Object[] datoG = {"", "", "", 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L};
    List<MyDataNode> children1 = new ArrayList();
    List<MyDataNode> children2 = new ArrayList();
    List<MyDataNode> children3 = new ArrayList();
    List<MyDataNode> children4 = new ArrayList();
    List<MyDataNode> children5 = new ArrayList();
    List<MyDataNode> children6 = new ArrayList();
    List<MyDataNode> children7 = new ArrayList();
    List<MyDataNode> children8 = new ArrayList();
    List<MyDataNode> children9 = new ArrayList();
    List<MyDataNode> children10 = new ArrayList();
    List<MyDataNode> children12 = new ArrayList();
    List<MyDataNode> children13 = new ArrayList();
    MyDataNode root = null;
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFConsultaRubrosPeriodos() {
        initComponents();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Tipo = new ButtonGroup();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.jScrollPane2 = new JScrollPane();
        this.gridI = new JTable();
        this.jScrollPane3 = new JScrollPane();
        this.gridG = new JTable();
        this.jPanel1 = new JPanel();
        this.JPI_FPeriodos = new JPanel();
        this.JSP_FPeriodo = new JScrollPane();
        this.JTB_FPeriodo = new JTable();
        this.JYCAno = new JYearChooser();
        this.JBTOk = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("RUBROS PRESUPUESTALES POR PERIODOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xConsultaRubrosPer");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFConsultaRubrosPeriodos.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultaRubrosPeriodos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubrosPeriodos.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubrosPeriodos.this.JBTExportarActionPerformed(evt);
            }
        });
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.gridI.setFont(new Font("Arial", 1, 12));
        this.gridI.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridI.setSelectionBackground(Color.white);
        this.gridI.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.gridI);
        this.jTabbedPane1.addTab("INGRESOS", this.jScrollPane2);
        this.gridG.setFont(new Font("Arial", 1, 12));
        this.gridG.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.gridG.setSelectionBackground(Color.white);
        this.gridG.setSelectionForeground(Color.red);
        this.jScrollPane3.setViewportView(this.gridG);
        this.jTabbedPane1.addTab("GASTOS", this.jScrollPane3);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setLayout((LayoutManager) null);
        this.JSP_FPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodos", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTB_FPeriodo.setFont(new Font("Arial", 1, 12));
        this.JTB_FPeriodo.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JSP_FPeriodo.setViewportView(this.JTB_FPeriodo);
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFConsultaRubrosPeriodos.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultaRubrosPeriodos.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JBTOk.setFont(new Font("Arial", 1, 13));
        this.JBTOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOk.setText("Consultar");
        this.JBTOk.addActionListener(new ActionListener() { // from class: Presupuesto.JIFConsultaRubrosPeriodos.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaRubrosPeriodos.this.JBTOkActionPerformed(evt);
            }
        });
        GroupLayout JPI_FPeriodosLayout = new GroupLayout(this.JPI_FPeriodos);
        this.JPI_FPeriodos.setLayout(JPI_FPeriodosLayout);
        JPI_FPeriodosLayout.setHorizontalGroup(JPI_FPeriodosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FPeriodosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JYCAno, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_FPeriodo, -2, 430, -2).addGap(47, 47, 47).addComponent(this.JBTOk, -2, 240, -2).addContainerGap(-1, 32767)));
        JPI_FPeriodosLayout.setVerticalGroup(JPI_FPeriodosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FPeriodosLayout.createSequentialGroup().addGroup(JPI_FPeriodosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FPeriodosLayout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.JBTOk, -2, 40, -2)).addGroup(JPI_FPeriodosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FPeriodosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_FPeriodo, -2, 80, -2).addComponent(this.JYCAno, -2, 55, -2)))).addGap(0, 19, 32767)));
        this.jPanel1.add(this.JPI_FPeriodos);
        this.JPI_FPeriodos.setBounds(6, 19, 850, 110);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 581, -2).addGap(50, 50, 50).addComponent(this.JBTExportar, -2, 221, -2)).addComponent(this.jTabbedPane1, GroupLayout.Alignment.LEADING, -2, 862, -2)).addContainerGap(11, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 863, -2).addContainerGap(-1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(146, 146, 146).addComponent(this.jTabbedPane1, -2, 337, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 56, -2).addComponent(this.JBTExportar, -2, 56, -2)).addContainerGap(36, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 127, -2).addContainerGap(448, 32767))));
        this.jTabbedPane1.getAccessibleContext().setAccessibleName("Ingresos");
        pack();
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
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            if (this.gridI.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String xtitulo = "EJECUCIÓN PRESUPUESTAL DE INGRESOS AÑO " + this.JYCAno.getValue() + " PERIODO(S): " + this.xPeriodos;
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.gridI, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), xtitulo);
                    return;
                }
                return;
            }
            return;
        }
        int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n2 == 0) {
            String xtitulo2 = "EJECUCIÓN PRESUPUESTAL DE GASTOS AÑO " + this.JYCAno.getValue() + " PERIODO(S): " + this.xPeriodos;
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.gridG, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), xtitulo2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarDatos_Periodo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOkActionPerformed(ActionEvent evt) {
        cargar_presupuesto();
    }

    private void mLlenarDatos(String periodos) {
        this.sql = "DROP TABLE IF EXISTS pp_tem_rubros_per;\n";
        this.xct.ejecutarSQL(this.sql);
        this.sql = "CREATE TABLE pp_tem_rubros_per \nSELECT  \nr.Id\n,r.IdPadre\n,r.Nbre\n,r.TipoRubro\n,IFNULL(Presupuesto_Inicial,0) Presupuesto_Inicial\n,IFNULL(Adicion_Presupuesto,0) Adicion_Presupuesto\n,IFNULL(Reduccion_Presupuesto,0) Reduccion_Presupuesto\n,IFNULL(Traslados_Debitos,0) Traslados_Debitos\n,IFNULL(Traslados_Creditos,0) Traslados_Creditos\n,IFNULL(Presupuesto_Definitivo,0) Presupuesto_Definitivo\n,IFNULL(Reconocimiento_Total,0) Reconocimiento_Total\n,IFNULL(Recaudo_Total,0) Recaudo_Total\n,IFNULL(Saldo_por_Ejecutar,0) Saldo_por_Ejecutar\n,IFNULL(Saldo_por_Recaudar,0) Saldo_por_Recaudar\n,IFNULL(Total_Certificados,0) Total_Certificados\n,IFNULL(Compromiso_Total,0) Compromiso_Total\n,IFNULL(Total_Obligaciones,0) Total_Obligaciones\n,IFNULL(Total_Pagos,0) Total_Pagos\n,IFNULL(Saldo_Disponible,0) Saldo_Disponible\n,IFNULL(Sin_Comprometer,0) Sin_Comprometer\n,IFNULL(Compromisos_por_Pagar,0) Compromisos_por_Pagar\n,IFNULL(Cuentas_por_Pagar,0) Cuentas_por_Pagar\n,IFNULL(Certificado_sin_Comprometer,0) Certificado_sin_Comprometer\nFROM pp_rubros r\nLEFT JOIN \n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n ,(Reconocimiento) Reconocimiento_Total\n ,(Recaudo) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento)) Saldo_por_Ejecutar\n , ((Reconocimiento) - (Recaudo)) Saldo_por_Recaudar \n , ((Disponibilidad-Reint_Disponibilidad)) Total_Certificados\n ,(Compromiso) Compromiso_Total\n ,(Obligacion) Total_Obligaciones\n ,(Pagos) Total_Pagos\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- ((Disponibilidad-Reint_Disponibilidad))) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-(Compromiso)) Sin_Comprometer\n ,((Compromiso)-(Pagos)) Compromisos_por_Pagar\n ,((Obligacion)-(Pagos)) Cuentas_por_Pagar\n ,((Disponibilidad)-(Compromiso)) Certificado_sin_Comprometer\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento,0)) Reconocimiento\n,SUM(IFNULL(Recaudo,0)) Recaudo\n,SUM(IFNULL(Disponibilidad,0)) Disponibilidad\n,SUM(IFNULL(Reint_Disponibilidad,0)) Reint_Disponibilidad\n,SUM(IFNULL(Compromiso,0)) Compromiso\n,SUM(IFNULL(Obligacion,0)) Obligacion\n,SUM(IFNULL(Pagos,0)) Pagos\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  THEN\n     Valor\n END Reconocimiento\n \n\n,CASE WHEN Id_CD=3  THEN\n     Valor\n END Recaudo\n\n,CASE WHEN Id_CD IN(9,10)   THEN\n     Valor\n END Disponibilidad\n \n,CASE WHEN Id_CD IN(11)   THEN\n     Valor\n END Reint_Disponibilidad\n\n\n,CASE WHEN Id_CD IN(4,12)  THEN\n     Valor\n   WHEN Id_CD IN(13)  THEN\n     Valor*(-1)\n END Compromiso\n \n, CASE WHEN Id_CD IN(5,14) THEN\n     Valor\n   WHEN Id_CD IN(15)  THEN\n     Valor*(-1)\n END Obligacion ,CASE WHEN Id_CD=6  THEN\n     Valor\n END Pagos\n     \n FROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    \nFROM     pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND  pp_periodo.Id IN ( SELECT Id FROM pp_periodo\n\t\t\t\tWHERE Id IN(" + periodos + ") ) \t\n    AND pp_movimiento.Id_MotivoAnulacion=1 \n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo \n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) datos ) datos\nON r.Id=datos.Id_R WHERE r.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "';";
        this.xct.ejecutarSQL(this.sql);
        this.sql = "UPDATE pp_tem_rubros_per P\n                INNER JOIN\n                (SELECT \n                 A.Id\n                ,SUM(B.Presupuesto_Inicial) Presupuesto_Inicial\n                ,SUM(B.Adicion_Presupuesto) Adicion_Presupuesto\n                ,SUM(B.Reduccion_Presupuesto) Reduccion_Presupuesto\n                ,SUM(B.Traslados_Debitos) Traslados_Debitos\n                ,SUM(B.Traslados_Creditos) Traslados_Creditos\n                ,SUM(B.Presupuesto_Definitivo) Presupuesto_Definitivo\n                ,SUM(B.Reconocimiento_Total) Reconocimiento_Total\n                ,SUM(B.Recaudo_Total) Recaudo_Total\n                ,SUM(B.Saldo_por_Ejecutar) Saldo_por_Ejecutar\n                ,SUM(B.Saldo_por_Recaudar ) Saldo_por_Recaudar\n                ,SUM(B.Total_Certificados) Total_Certificados\n                ,SUM(B.Compromiso_Total) Compromiso_Total\n                ,SUM(B.Total_Obligaciones) Total_Obligaciones\n                ,SUM(B.Total_Pagos) Total_Pagos\n                ,SUM(B.Saldo_Disponible) Saldo_Disponible\n                ,SUM(B.Sin_Comprometer) Sin_Comprometer\n                ,SUM(B.Compromisos_por_Pagar) Compromisos_por_Pagar\n                ,SUM(B.Cuentas_por_Pagar) Cuentas_por_Pagar\n                ,SUM(B.Certificado_sin_Comprometer) Certificado_sin_Comprometer\n                \n                FROM pp_tem_rubros_per A\n                INNER JOIN\n                pp_tem_rubros_per B\n                ON A.Id= B.IdPadre\n                GROUP BY A.Id) A\n                ON P.Id=A.Id\n                SET \tP.Presupuesto_Inicial=A.Presupuesto_Inicial\n                ,\tP.Adicion_Presupuesto\t=\tA.Adicion_Presupuesto\n                ,\tP.Reduccion_Presupuesto\t=\tA.Reduccion_Presupuesto\n                ,\tP.Traslados_Debitos\t=\tA.Traslados_Debitos\n                ,\tP.Traslados_Creditos\t=\tA.Traslados_Creditos\n                ,\tP.Presupuesto_Definitivo\t=\tA.Presupuesto_Definitivo\n                ,\tP.Reconocimiento_Total\t=\tA.Reconocimiento_Total\n                ,\tP.Recaudo_Total\t=\tA.Recaudo_Total\n                ,\tP.Saldo_por_Ejecutar\t=\tA.Saldo_por_Ejecutar\n                ,\tP.Saldo_por_Recaudar \t=\tA.Saldo_por_Recaudar \n                ,\tP.Total_Certificados\t=\tA.Total_Certificados\n                ,\tP.Compromiso_Total\t=\tA.Compromiso_Total\n                ,\tP.Total_Obligaciones\t=\tA.Total_Obligaciones\n                ,\tP.Total_Pagos\t=\tA.Total_Pagos\n                ,\tP.Saldo_Disponible\t=\tA.Saldo_Disponible\n                ,\tP.Sin_Comprometer\t=\tA.Sin_Comprometer\n                ,\tP.Compromisos_por_Pagar\t=\tA.Compromisos_por_Pagar\n                ,\tP.Cuentas_por_Pagar\t=\tA.Cuentas_por_Pagar\n                ,\tP.Certificado_sin_Comprometer\t=\tA.Certificado_sin_Comprometer";
        for (int i = 0; i < 50; i++) {
            this.xct.ejecutarSQL(this.sql);
        }
        this.xct.cerrarConexionBd();
        this.sql = "SELECT * FROM pp_tem_rubros_per";
        this.filaGridI = 0;
        this.filaGridG = 0;
        mCrearGridIngresos();
        mCrearGridGastos();
        ResultSet xrs = this.xct.traerRs(this.sql);
        while (xrs.next()) {
            try {
                if (xrs.getString("TipoRubro").equals("I")) {
                    this.modeloI.addRow(this.datoI);
                    this.modeloI.setValueAt(xrs.getString("Id"), this.filaGridI, 0);
                    this.modeloI.setValueAt(xrs.getString("Nbre"), this.filaGridI, 1);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Inicial")), this.filaGridI, 2);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Adicion_Presupuesto")), this.filaGridI, 3);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Reduccion_Presupuesto")), this.filaGridI, 4);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Definitivo")), this.filaGridI, 5);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Reconocimiento_Total")), this.filaGridI, 6);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Recaudo_Total")), this.filaGridI, 7);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Saldo_por_Ejecutar")), this.filaGridI, 8);
                    this.modeloI.setValueAt(Double.valueOf(xrs.getDouble("Saldo_por_Recaudar")), this.filaGridI, 9);
                    this.filaGridI++;
                } else {
                    this.modeloG.addRow(this.datoG);
                    this.modeloG.setValueAt(xrs.getString("Id"), this.filaGridG, 0);
                    this.modeloG.setValueAt(xrs.getString("Nbre"), this.filaGridG, 1);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Inicial")), this.filaGridG, 2);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Adicion_Presupuesto")), this.filaGridG, 3);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Reduccion_Presupuesto")), this.filaGridG, 4);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Traslados_Debitos")), this.filaGridG, 5);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Traslados_Creditos")), this.filaGridG, 6);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Presupuesto_Definitivo")), this.filaGridG, 7);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Total_Certificados")), this.filaGridG, 8);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Compromiso_Total")), this.filaGridG, 9);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Total_Obligaciones")), this.filaGridG, 10);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Total_Pagos")), this.filaGridG, 11);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Saldo_Disponible")), this.filaGridG, 12);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Sin_Comprometer")), this.filaGridG, 13);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Compromisos_por_Pagar")), this.filaGridG, 14);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Cuentas_por_Pagar")), this.filaGridG, 15);
                    this.modeloG.setValueAt(Double.valueOf(xrs.getDouble("Certificado_sin_Comprometer")), this.filaGridG, 16);
                    this.filaGridG++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        xrs.close();
    }

    private void mCrearGridIngresos() {
        this.modeloI = new DefaultTableModel() { // from class: Presupuesto.JIFConsultaRubrosPeriodos.5
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloI.addColumn("Rubro");
        this.modeloI.addColumn("Nombre Rubro");
        this.modeloI.addColumn("Presupuesto Inicial");
        this.modeloI.addColumn("Adiciones");
        this.modeloI.addColumn("Reducciones");
        this.modeloI.addColumn("Presupuesto Definitivo");
        this.modeloI.addColumn("Total Reconocimientos");
        this.modeloI.addColumn("Acumulado Recaudos");
        this.modeloI.addColumn("Saldo por Ejecutar");
        this.modeloI.addColumn("Saldo por Recaudar");
        JTable jTable = this.gridI;
        JTable jTable2 = this.gridI;
        jTable.setAutoResizeMode(0);
        this.gridI.doLayout();
        this.gridI.setModel(this.modeloI);
        this.gridI.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridI.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.gridI.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.gridI.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.filaGridI = 0;
        this.gridI.setModel(this.modeloI);
    }

    private void mCrearGridGastos() {
        this.modeloG = new DefaultTableModel() { // from class: Presupuesto.JIFConsultaRubrosPeriodos.6
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloG.addColumn("Rubro");
        this.modeloG.addColumn("Nombre Rubro");
        this.modeloG.addColumn("Presupuesto Inicial");
        this.modeloG.addColumn("Adiciones");
        this.modeloG.addColumn("Reducciones");
        this.modeloG.addColumn("Traslados Debitos");
        this.modeloG.addColumn("Traslados Creditos");
        this.modeloG.addColumn("Apropiación Definitiva");
        this.modeloG.addColumn("Total Certificados");
        this.modeloG.addColumn("Total Compromisos");
        this.modeloG.addColumn("Total Obligaciones");
        this.modeloG.addColumn("Total Pagos");
        this.modeloG.addColumn("Saldo Disponible");
        this.modeloG.addColumn("Sin Comprometer");
        this.modeloG.addColumn("Compromisos por Pagar");
        this.modeloG.addColumn("Cuentas por Pagar");
        this.modeloG.addColumn("Certificado sin Comprometer");
        JTable jTable = this.gridG;
        JTable jTable2 = this.gridG;
        jTable.setAutoResizeMode(0);
        this.gridG.doLayout();
        this.gridG.setModel(this.modeloG);
        this.gridG.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.gridG.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.gridG.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.gridG.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.filaGridG = 0;
        this.gridG.setModel(this.modeloG);
    }

    private void mCrearTablaDetalle_P() {
        this.xmodelop = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Seleccionar"}) { // from class: Presupuesto.JIFConsultaRubrosPeriodos.7
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_FPeriodo.setModel(this.xmodelop);
        this.JTB_FPeriodo.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_FPeriodo.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTB_FPeriodo.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCargarDatos_Periodo() {
        String sql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes  FROM pp_periodo WHERE (DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "') ORDER BY Id DESC ";
        mCrearTablaDetalle_P();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelop.addRow(this.xdato);
                    this.xmodelop.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelop.setValueAt(rs.getString(2), x, 1);
                    this.xmodelop.setValueAt(false, x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void cargar_presupuesto() {
        String xcodigopro = "";
        for (int x = 0; x < this.JTB_FPeriodo.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelop.getValueAt(x, 2).toString()).booleanValue()) {
                xcodigopro = xcodigopro + "," + this.xmodelop.getValueAt(x, 0).toString();
                this.xPeriodos += "," + this.xmodelop.getValueAt(x, 1).toString();
            }
        }
        if (xcodigopro.length() > 0) {
            mLlenarDatos(xcodigopro.substring(1, xcodigopro.length()));
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mNuevo() {
        this.xTipoR = "I";
        this.xUltimoN = 0;
        this.xAplicaTercero = 0;
    }

    private void mIniciaJtreeTable() {
        createDataStructure("-1");
        this.treeTableModel = new MyDataModel(createDataStructure());
        this.myTreeTable = new MyTreeTable(this.treeTableModel);
    }

    private List<MyDataNode> createDataStructure(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQL-->" + sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    System.out.println("IdPadre-->" + xrs.getString("IdPadre"));
                    this.children1.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild2(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    System.out.println("children1-->" + this.children1);
                    System.out.println("n-->" + n);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children1;
    }

    private List<MyDataNode> createDataStructureChild2(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQL-->" + sql);
        try {
            if (xrs.next()) {
                this.children2 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    System.out.println("IdPadre-->" + xrs.getString("IdPadre"));
                    this.children2.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild3(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    System.out.println("children2-->" + this.children2);
                    n++;
                }
            } else {
                this.children2 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children2;
    }

    private List<MyDataNode> createDataStructureChild3(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children3 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children3.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild4(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children3 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children3;
    }

    private List<MyDataNode> createDataStructureChild4(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children4 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children4.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild5(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children4 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children4;
    }

    private List<MyDataNode> createDataStructureChild5(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children5 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children5.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild6(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children5 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children5;
    }

    private List<MyDataNode> createDataStructureChild6(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children6 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children6.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild7(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children6 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children6;
    }

    private List<MyDataNode> createDataStructureChild7(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children7 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children7.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild8(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children7 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children7;
    }

    private List<MyDataNode> createDataStructureChild8(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children8 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children8.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild9(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children8 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children8;
    }

    private List<MyDataNode> createDataStructureChild9(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children9 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children9.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), createDataStructureChild10(xrs.getString("IdRubro")), xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children9 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children9;
    }

    private List<MyDataNode> createDataStructureChild10(String x) {
        String sql = "SELECT `Nbre` AS rubrov ,`Cod_Alterno`,`TipoRubro`,IF(`UltNivel`=0,'NO','SI') AS UltNivel,`IdPadre`,`Id` AS IdRubro,IF(`Aplica_Tercero`=0,'NO','SI') AS Aplica_Tercero  FROM `pp_rubros` WHERE IdPadre='" + x + "'  ORDER BY Id ASC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        System.out.println("SQLChild3-->" + sql);
        try {
            if (xrs.next()) {
                this.children10 = new ArrayList();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.children10.add(new MyDataNode(xrs.getString("IdRubro") + " " + xrs.getString("rubrov"), xrs.getString("IdRubro"), xrs.getString("TipoRubro"), xrs.getString("UltNivel"), null, xrs.getString("IdPadre"), xrs.getString("IdRubro"), xrs.getString("Aplica_Tercero")));
                    n++;
                }
            } else {
                this.children10 = null;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultaRubrosPeriodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return this.children10;
    }

    private MyDataNode createDataStructure() {
        this.root = new MyDataNode("Rubros Presupuestales", "", "", "", this.children1, "0", "0", "");
        return this.root;
    }
}
