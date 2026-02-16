package RecursosHumanos;

import Contabilidad.JDBuscarDatosT;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JD_ValidacionN.class */
public class JD_ValidacionN extends JDialog {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JIF_Nomina_Causacion xjif_causacion;
    private JButton JBTExportar;
    private JButton JBTOk;
    private JButton JBTSalir;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;

    public JD_ValidacionN(Frame parent, boolean modal, JIF_Nomina_Causacion xjif_causacion) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        this.xjif_causacion = xjif_causacion;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTOk = new JButton();
        this.JBTSalir = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("VALIDACION PRESUPUESTAL");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTOk.setFont(new Font("Arial", 1, 13));
        this.JBTOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOk.setText("Ok");
        this.JBTOk.addActionListener(new ActionListener() { // from class: RecursosHumanos.JD_ValidacionN.1
            public void actionPerformed(ActionEvent evt) {
                JD_ValidacionN.this.JBTOkActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 13));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: RecursosHumanos.JD_ValidacionN.2
            public void actionPerformed(ActionEvent evt) {
                JD_ValidacionN.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JD_ValidacionN.3
            public void mouseClicked(MouseEvent evt) {
                JD_ValidacionN.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: RecursosHumanos.JD_ValidacionN.4
            public void actionPerformed(ActionEvent evt) {
                JD_ValidacionN.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JBTOk, -2, 400, -2).addGap(10, 10, 10).addComponent(this.JBTSalir, -2, 400, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 407, -2).addGap(30, 30, 30).addComponent(this.JBTExportar, -2, 178, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JSPDetalle, -2, 366, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTOk, -1, -1, 32767).addComponent(this.JBTSalir, -2, 45, -2)).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOkActionPerformed(ActionEvent evt) {
        for (int x = 0; x < this.xjif_causacion.JTB_NNomina.getRowCount(); x++) {
            if (!this.xjif_causacion.xModeloN.getValueAt(x, 10).toString().equals("")) {
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(y, 6).toString()).booleanValue() && this.xmodelo.getValueAt(y, 0).toString().equals(this.xjif_causacion.xModeloN.getValueAt(x, 10).toString())) {
                        this.xjif_causacion.xModeloN.setValueAt(true, x, 26);
                    }
                }
            } else {
                this.xjif_causacion.xModeloN.setValueAt(true, x, 26);
            }
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Rurbo", "VDevengado", "VEmpresa", "Saldo Disponible", "Saldo Actual", "Var"}) { // from class: RecursosHumanos.JD_ValidacionN.5
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void mCargarDatos() {
        this.xsql = " SELECT f.Id, f.Nbre, f.devengado, f.vempresa, g.Saldo_Disponible \n, (g.Saldo_Disponible-(f.devengado+ f.vempresa)) Dif, IF((g.Saldo_Disponible-(f.devengado+ f.vempresa))<=0,0, 1) Var \nFROM (\n\n-- nuevo\nSELECT `pp_rubros`.`Id`, `pp_rubros`.`Nbre`, SUM(d.devengado) devengado, SUM(d.vempresa) vempresa\n\n-- nuevo\nFROM `pp_rubros` INNER JOIN (\nSELECT `rh_nomina_concepto_unidadf`.`RPresupuesto`,\n   SUM(`rh_nomina_liquidacion_detalle`.`VDevengado`) devengado\n    , SUM(`rh_nomina_liquidacion_detalle`.`TValorE`) vempresa\n\nFROM\n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_tipo_persona_cargon` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `rh_unidadf_cargo` \n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n    INNER JOIN  `rh_unidad_funcional` \n        ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`)\n    INNER JOIN  `rh_tipo_cargo` \n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN  `rh_tipo_clasificacion_conceptonomina` \n        ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)  INNER JOIN  `cc_terceros`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_terceros`.`Id`) \n        WHERE rh_nomina_liquidacion.`Id`='" + this.xjif_causacion.xModeloH.getValueAt(this.xjif_causacion.JTB_Historico.getSelectedRow(), 0) + "' AND `rh_nomina_concepto_unidadf`.`RPresupuesto` GROUP BY `rh_nomina_concepto_unidadf`.`RPresupuesto`  ORDER BY `rh_nomina_concepto_unidadf`.`RPresupuesto` \n\n) d ON d.`RPresupuesto`=pp_rubros.`Id` AND pp_rubros.`idEncabezadoRubro`= '" + this.xjif_causacion.xId_PeriodoPresupuestal[this.xjif_causacion.JCBPeriodo_Ppt.getSelectedIndex()][1] + "'\nGROUP BY pp_rubros.`Id`\n) f INNER JOIN  (SELECT  \nr.Id\n,Saldo_Disponible\nFROM pp_rubros r\nINNER JOIN \n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n  ,Reconocimiento_Anterior\n ,Reconocimiento_Actual\n ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n ,Recaudo_Anterior\n ,Recaudo_Actual\n ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n/*Actualizacion con nuevos clase documentos*/ \n/*Disponibilidad CDP*/\n ,(Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)  AS Certificado_Anterior\n ,(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)  AS Certificado_Actual\n ,((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)) Total_Certificados\n/*Compromiso RP*/\n ,(Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior) AS Compromiso_Anterior\n ,(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual) AS Compromiso_Actual\n ,((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual)) Compromiso_Total\n /*Obligacion OP*/\n ,(Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior) AS Obligacion_Anterior\n ,(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual) AS Obligacion_Actual\n ,((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual)) Total_Obligaciones\n /*Pagos PP*/\n ,Pagos_Anterior\n ,Pagos_Actual\n ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n /*Operaciones...*/\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- ((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Sin_Comprometer\n ,(((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n ,(((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual))-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n ,(((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Certificado_sin_Comprometer\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\n-- -------------------------------------------------------------\n,SUM(IFNULL(Adicion_Disponibilidad_Anterior,0)) Adicion_Disponibilidad_Anterior\n,SUM(IFNULL(Adicion_Disponibilidad_Actual,0)) Adicion_Disponibilidad_Actual\n,SUM(IFNULL(Reintegro_Disponibilidad_Anterior,0)) Reintegro_Disponibilidad_Anterior\n,SUM(IFNULL(Reintegro_Disponibilidad_Actual,0)) Reintegro_Disponibilidad_Actual\n,SUM(IFNULL(Adicion_Compromiso_Anterior,0)) Adicion_Compromiso_Anterior\n,SUM(IFNULL(Adicion_Compromiso_Actual,0)) Adicion_Compromiso_Actual\n,SUM(IFNULL(Reintegro_Compromiso_Anterior,0)) Reintegro_Compromiso_Anterior\n,SUM(IFNULL(Reintegro_Compromiso_Actual,0)) Reintegro_Compromiso_Actual\n,SUM(IFNULL(Adicion_Obligacion_Anterior,0)) Adicion_Obligacion_Anterior\n,SUM(IFNULL(Adicion_Obligacion_Actual,0)) Adicion_Obligacion_Actual\n,SUM(IFNULL(Reintegro_Obligacion_Anterior,0)) Reintegro_Obligacion_Anterior\n,SUM(IFNULL(Reintegro_Obligacion_Actual,0)) Reintegro_Obligacion_Actual\n\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Reconocimiento_Anterior\n\n,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Reconocimiento_Actual\n\n,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Recaudo_Anterior\n\n,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Recaudo_Actual\n\n\n,CASE WHEN Id_CD=9  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Disponibilidad_Anterior\n\n,CASE WHEN Id_CD=9  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Disponibilidad_Actual\n\n,CASE WHEN Id_CD=4  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Compromiso_Anterior\n \n ,CASE WHEN Id_CD=4  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Compromiso_Actual\n \n,CASE WHEN Id_CD=5  AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Obligacion_Anterior\n \n,CASE WHEN Id_CD=5  AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Obligacion_Actual \n \n ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Pagos_Anterior\n \n ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Pagos_Actual\n -- -------------------------------------------------------\n /*\n10\tAdicion Disponibilidad\n11\tReintegro Disponibilidad\n12\tAdicion Compromiso\n13\tReintegro Compromiso\n14\tAdicion ObligaciÛn\n15\tReintegro ObligaciÛn\n*/\n ,CASE WHEN Id_CD=10 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=10 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Actual\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Actual\n\n ,CASE WHEN Id_CD=12 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=12 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Actual\n\n ,CASE WHEN Id_CD=13 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=13 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Reintegro_Compromiso_Actual \n    \n ,CASE WHEN Id_CD=14 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=14 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Adicion_Obligacion_Actual\n  \n,CASE WHEN Id_CD=15 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=15 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Actual\n \n\nFROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , pp_movimiento.Id_Periodo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    , @Periodo_Act Periodo_Act\n    \nFROM (SELECT @Periodo_Act:='" + this.xjif_causacion.xId_PeriodoPresupuestal[this.xjif_causacion.JCBPeriodo_Ppt.getSelectedIndex()][0] + "') p,\n    pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE   pp_periodo.Id IN ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n    WHERE Id='" + this.xjif_causacion.xId_PeriodoPresupuestal[this.xjif_causacion.JCBPeriodo_Ppt.getSelectedIndex()][0] + "') pact\n    WHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n    OR pact.Id=pant.id\n         )  \n    AND pp_movimiento.Id_MotivoAnulacion=1 -- AND pp_rubros.`Id`='121100301' \n    AND pp_detalle_movimiento.idEncabezado= '" + this.xjif_causacion.xId_PeriodoPresupuestal[this.xjif_causacion.JCBPeriodo_Ppt.getSelectedIndex()][1] + "'\n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) datos ) datos\nON r.Id=datos.Id_R WHERE r.`idEncabezadoRubro`='" + this.xjif_causacion.xId_PeriodoPresupuestal[this.xjif_causacion.JCBPeriodo_Ppt.getSelectedIndex()][1] + "') g ON (g.Id=f.Id)";
        System.out.println("" + this.xsql);
        ResultSet rs = this.xct.traerRs(this.xsql);
        mCrearTabla();
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 6);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBuscarDatosT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JD_ValidacionN$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!Boolean.valueOf(table.getValueAt(row, 6).toString()).booleanValue()) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
