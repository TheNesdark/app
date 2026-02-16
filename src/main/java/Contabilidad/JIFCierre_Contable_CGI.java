package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFCierre_Contable_CGI.class */
public class JIFCierre_Contable_CGI extends JInternalFrame {
    private String xsql;
    private String[][] xid;
    private String cc_puc;
    private String[] xidtipodoc;
    private String[] xidempresa;
    private String[] xidauxiliar;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private ButtonGroup JBGNorma;
    private JButton JBTExportar;
    private JComboBox JCBPeriodo;
    private JComboBox JCBPucAuxiliar;
    private JComboBox JCBTDocumento;
    private JComboBox JCBTercero;
    private JCheckBox JCHActivo;
    private JDateChooser JDFFechaC;
    private JPanel JPIDConsulta;
    private JPanel JPIDetalle;
    private JRadioButton JRBColgaap;
    private JRadioButton JRBNiif;
    private JScrollPane JSPConceptC;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    private JTextPane JTAConceptoC;
    private JTable JTConsolidado;
    private JTable JTDetalle;
    private JFormattedTextField JTFFVCredito;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String tipo = "0";

    public JIFCierre_Contable_CGI() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v66, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGNorma = new ButtonGroup();
        this.JPIDConsulta = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JSPConceptC = new JScrollPane();
        this.JTAConceptoC = new JTextPane();
        this.JDFFechaC = new JDateChooser();
        this.JRBNiif = new JRadioButton();
        this.JRBColgaap = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPIDetalle = new JPanel();
        this.JCBTDocumento = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JCBPucAuxiliar = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JSPConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        this.JTFFVCredito = new JFormattedTextField();
        this.jPanel2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("PyG");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifcierrecuentascgi");
        this.JPIDConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCierre_Contable_CGI.1
            public void actionPerformed(ActionEvent evt) {
                JIFCierre_Contable_CGI.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JSPConceptC.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPConceptC.setViewportView(this.JTAConceptoC);
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JBGNorma.add(this.JRBNiif);
        this.JRBNiif.setFont(new Font("Arial", 1, 12));
        this.JRBNiif.setText("Niif");
        this.JRBNiif.setToolTipText("");
        this.JRBNiif.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCierre_Contable_CGI.2
            public void actionPerformed(ActionEvent evt) {
                JIFCierre_Contable_CGI.this.JRBNiifActionPerformed(evt);
            }
        });
        this.JBGNorma.add(this.JRBColgaap);
        this.JRBColgaap.setFont(new Font("Arial", 1, 12));
        this.JRBColgaap.setText("colgaap");
        this.JRBColgaap.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCierre_Contable_CGI.3
            public void actionPerformed(ActionEvent evt) {
                JIFCierre_Contable_CGI.this.JRBColgaapActionPerformed(evt);
            }
        });
        GroupLayout JPIDConsultaLayout = new GroupLayout(this.JPIDConsulta);
        this.JPIDConsulta.setLayout(JPIDConsultaLayout);
        JPIDConsultaLayout.setHorizontalGroup(JPIDConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsultaLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBPeriodo, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHActivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPConceptC, -2, 304, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNiif).addComponent(this.JRBColgaap)).addGap(25, 25, 25)));
        JPIDConsultaLayout.setVerticalGroup(JPIDConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsultaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsultaLayout.createSequentialGroup().addComponent(this.JRBNiif).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBColgaap)).addComponent(this.JSPConceptC).addGroup(GroupLayout.Alignment.TRAILING, JPIDConsultaLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo, -2, 50, -2).addComponent(this.JCHActivo))).addComponent(this.JDFFechaC, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JCBTDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPucAuxiliar.setFont(new Font("Arial", 1, 12));
        this.JCBPucAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPucAuxiliar, 0, -1, 32767).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JCBTDocumento, -2, 217, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTercero, 0, 718, 32767))).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTDocumento, -2, 50, -2).addComponent(this.JCBTercero, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPucAuxiliar, -2, 50, -2).addGap(17, 17, 17)));
        this.jTabbedPane1.addTab("DATOS PARA MOVIMIENTO", this.JPIDetalle);
        this.JSPConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO PYG", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTConsolidado.setRowHeight(25);
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(Color.red);
        this.JTConsolidado.setSelectionMode(0);
        this.JSPConsolidado.setViewportView(this.JTConsolidado);
        this.JTFFVCredito.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Utilidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFVCredito.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVCredito.setHorizontalAlignment(4);
        this.JTFFVCredito.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPConsolidado, -1, 709, 32767).addGap(53, 53, 53).addComponent(this.JTFFVCredito, -2, 179, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPConsolidado, -2, 0, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 66, 32767).addComponent(this.JTFFVCredito, -2, 50, -2))).addContainerGap()));
        this.jTabbedPane1.addTab("CONSOLIDADO PYG", this.jPanel1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFCierre_Contable_CGI.4
            public void mouseClicked(MouseEvent evt) {
                JIFCierre_Contable_CGI.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCierre_Contable_CGI.5
            public void actionPerformed(ActionEvent evt) {
                JIFCierre_Contable_CGI.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JTFRuta, -2, 487, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 264, -2).addContainerGap(186, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(51, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(22, 22, 22)));
        this.jTabbedPane1.addTab("EXPORTAR", this.jPanel2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDConsulta, -1, -1, 32767).addComponent(this.JSPDetalle).addComponent(this.jTabbedPane1, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDConsulta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 282, 32767).addGap(33, 33, 33).addComponent(this.jTabbedPane1, -2, 169, -2).addGap(20, 20, 20)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mCargarCombo();
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
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBColgaapActionPerformed(ActionEvent evt) {
        this.tipo = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNiifActionPerformed(ActionEvent evt) {
        this.tipo = "1";
    }

    public void mGrabar() {
        if (Principal.xclase.getXidperiodoc() != -1) {
            if (Principal.xclase.isXestadop()) {
                if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        if (this.JCBTDocumento.getSelectedIndex() != -1) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC,  Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTDocumento.getSelectedIndex()] + "','" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "','" + this.JTAConceptoC.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                                Principal.txtEstado.setText("ACTIVO");
                                this.xct.cerrarConexionBd();
                                ConsultasMySQL xct1 = new ConsultasMySQL();
                                this.xsql = "INSERT IGNORE INTO cc_detalle_documentoc (\n  Id_Documentoc,\n  Id_Puc,\n  TipoCPuc,\n  Id_Tercero,\n  VDebito,\n  VCredito,\n  Concepto\n)\nWITH maestra AS (\nSELECT  `cc_terceros`.`Id` , pucClase.`Tipo`,  `cc_detalle_documentoc`.`Id_Puc` AS `Puc` ,\nROUND(IF(pucClase.`Tipo`=0, (SUM(`cc_detalle_documentoc`.`VDebito`)-SUM(`cc_detalle_documentoc`.`VCredito`)),(SUM(`cc_detalle_documentoc`.`VCredito`)-SUM(`cc_detalle_documentoc`.`VDebito`))),2) valor\n\n  \nFROM\n    `baseserver`.`cc_detalle_documentoc`\n    INNER JOIN `baseserver`.`cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `baseserver`.`cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN `baseserver`.`cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`)\n    INNER JOIN  cc_puc pucClase ON(pucClase.`Id`= MID(`cc_detalle_documentoc`.`Id_Puc`,1,1))\n    INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)   \nWHERE ((`cc_tipo_documentoc`.`Es_Niif` IN(0)\n    OR `cc_puc`.`AplicaNiif` IN(0)) AND (MID(`cc_detalle_documentoc`.`Id_Puc`,1,1) IN(4,5,6,7))\n    AND `cc_documentoc`.`Id_PeriodoC` < " + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + " AND cc_documentoc.`Estado`=1)\nGROUP BY     Puc,  `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta`\nORDER BY  `cc_detalle_documentoc`.`Id_Puc` ASC)\n, consulta AS (\nSELECT \nmaestra.Id, IF(Tipo=0 AND valor<0, 0, IF(Tipo=0 AND valor>0, 1,  IF(Tipo=1 AND valor<0, 1, IF(Tipo=1 AND valor>0, 0, Tipo)))) tipo\n,  IF(IF(Tipo=0 AND valor<0, 0, IF(Tipo=0 AND valor>0, 1 ,  IF(Tipo=1 AND valor<0, 1, IF(Tipo=1 AND valor>0, 0, Tipo))))=0, ABS(maestra.valor), 0) debito\n, IF(IF(Tipo=0 AND valor<0, 0, IF(Tipo=0 AND valor>0, 1,  IF(Tipo=1 AND valor<0, 1, IF(Tipo=1 AND valor>0, 0, Tipo))))=1, ABS(maestra.valor), 0) credito\n, Puc\nFROM maestra  \n--  GROUP BY maestra.Id, maestra.Puc\n)\nSELECT " + Principal.txtNo.getText() + ", consulta.Puc,consulta.tipo,consulta.id,consulta.debito,consulta.credito, '" + this.JTAConceptoC.getText() + "' FROM consulta WHERE consulta.debito<>0 OR consulta.credito<>0";
                                if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
                                    this.xsql = "INSERT IGNORE INTO cc_detalle_documentoc (\n  Id_Documentoc,\n  Id_Puc,\n  TipoCPuc,\n  Id_Tercero,\n  VDebito,\n  VCredito,\n  Concepto\n)\nWITH maestra AS (\nSELECT  `cc_terceros`.`Id` , pucClase.`Tipo`,  `cc_detalle_documentoc`.`Id_Puc` AS `Puc` ,\nROUND(IF(pucClase.`Tipo`=0, (SUM(`cc_detalle_documentoc`.`VDebito`)-SUM(`cc_detalle_documentoc`.`VCredito`)),(SUM(`cc_detalle_documentoc`.`VCredito`)-SUM(`cc_detalle_documentoc`.`VDebito`))),2) valor\n\n  \nFROM\n    `baseserver`.`cc_detalle_documentoc`\n    INNER JOIN `baseserver`.`cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `baseserver`.`cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN `baseserver`.`cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`)\n    INNER JOIN  cc_puc pucClase ON(pucClase.`Id`= MID(`cc_detalle_documentoc`.`Id_Puc`,1,1))\n    INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)   \nWHERE ((`cc_tipo_documentoc`.`Es_Niif` IN( " + this.tipo + ")\n    ) AND (MID(`cc_detalle_documentoc`.`Id_Puc`,1,1) IN(4,5,6,7))\n    AND `cc_documentoc`.`Id_PeriodoC` < " + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + " AND cc_documentoc.`Estado`=1)\nGROUP BY     Puc,  `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta`\nORDER BY  `cc_detalle_documentoc`.`Id_Puc` ASC)\n, consulta AS (\nSELECT \nmaestra.Id, IF(Tipo=0 AND valor<0, 0, IF(Tipo=0 AND valor>0, 1,  IF(Tipo=1 AND valor<0, 1, IF(Tipo=1 AND valor>0, 0, Tipo)))) tipo\n,  IF(IF(Tipo=0 AND valor<0, 0, IF(Tipo=0 AND valor>0, 1 ,  IF(Tipo=1 AND valor<0, 1, IF(Tipo=1 AND valor>0, 0, Tipo))))=0, ABS(maestra.valor), 0) debito\n, IF(IF(Tipo=0 AND valor<0, 0, IF(Tipo=0 AND valor>0, 1,  IF(Tipo=1 AND valor<0, 1, IF(Tipo=1 AND valor>0, 0, Tipo))))=1, ABS(maestra.valor), 0) credito\n, Puc\nFROM maestra  \n--  GROUP BY maestra.Id, maestra.Puc\n)\nSELECT " + Principal.txtNo.getText() + ", consulta.Puc,consulta.tipo,consulta.id,consulta.debito,consulta.credito, '" + this.JTAConceptoC.getText() + "' FROM consulta WHERE consulta.debito<>0 OR consulta.credito<>0";
                                }
                                System.out.println(this.xsql);
                                xct1.ejecutarSQL(this.xsql);
                                xct1.cerrarConexionBd();
                                if (Double.valueOf(this.JTFFVCredito.getValue().toString()).doubleValue() < 0.0d) {
                                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xidauxiliar[this.JCBPucAuxiliar.getSelectedIndex()] + "','0','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "',ABS(" + this.JTFFVCredito.getValue() + "),'0','" + this.JTAConceptoC.getText() + "' )";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                    return;
                                } else {
                                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xidauxiliar[this.JCBPucAuxiliar.getSelectedIndex()] + "','1','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','0',ABS(" + this.JTFFVCredito.getValue() + "),'" + this.JTAConceptoC.getText() + "' )";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                    return;
                                }
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTDocumento.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JDFFechaC.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Existen mas de un periodo abierto, \nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    public void mBuscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            mCargarDatos();
            mCargarDatosC();
            mEliminarFilasCero();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPeriodo.requestFocus();
        }
    }

    public void mNuevo() {
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBTDocumento.removeAllItems();
        this.JCBTercero.removeAllItems();
        this.JCBPucAuxiliar.removeAllItems();
        this.xidtipodoc = this.xct.llenarCombo("SELECT Id, Nbre, NReporte FROM cc_tipo_documentoc WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipodoc, this.JCBTDocumento);
        this.JCBTDocumento.setSelectedIndex(-1);
        this.xidempresa = this.xct.llenarCombo("SELECT `Id`, `RazonSocialCompleta` FROM  `cc_terceros` WHERE (`RazonSocialCompleta` <>'') ORDER BY `RazonSocialCompleta` ASC", this.xidempresa, this.JCBTercero);
        this.JCBTercero.setSelectedIndex(-1);
        this.xidauxiliar = this.xct.llenarCombo("SELECT `Id`  , CONCAT(`Id`,' - ',`Nbre`) AS Puc FROM `cc_puc` WHERE (`Id_Nivel` =5) ORDER BY `Id`", this.xidauxiliar, this.JCBPucAuxiliar);
        this.JCBPucAuxiliar.setSelectedIndex(-1);
        mCargarCombo();
        mCrearModeloDatos();
        mCrearModeloDatosC();
        this.JTFFVCredito.setValue(new Double(0.0d));
        this.JRBColgaap.setSelected(true);
    }

    private void mCargarCombo() {
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE EsCierre=1 and Activo=1 ORDER BY Id DESC; ";
        } else {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE EsCierre=1 and Activo=0  ORDER BY Id DESC; ";
        }
        this.xid = this.xct.llenarComboyLista(this.xsql, this.xid, this.JCBPeriodo, 6);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "Puc", "NPuc", "Debito", "Credito", "Aplica"}) { // from class: Contabilidad.JIFCierre_Contable_CGI.6
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(5);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosC() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Puc", "NPuc", "Valor"}) { // from class: Contabilidad.JIFCierre_Contable_CGI.7
            Class[] types = {String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTConsolidado.setModel(this.xmodelo1);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCargarDatos() {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
            this.xsql = "  SELECT `cc_terceros`.`Id` , `cc_terceros`.`RazonSocialCompleta` , `cc_detalle_documentoc`.`Id_Puc` AS `Puc` , `cc_puc`.`Nbre` \n    , ROUND(IF(pucClase.`Tipo`=0, (SUM(`cc_detalle_documentoc`.`VDebito`)-SUM(`cc_detalle_documentoc`.`VCredito`))\n    ,(SUM(`cc_detalle_documentoc`.`VCredito`)-SUM(`cc_detalle_documentoc`.`VDebito`))),2) valorTotal\nFROM\n    `baseserver`.`cc_detalle_documentoc`\n    INNER JOIN `baseserver`.`cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `baseserver`.`cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN `baseserver`.`cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`)\n    INNER JOIN  cc_puc pucClase ON(pucClase.`Id`= MID(`cc_detalle_documentoc`.`Id_Puc`,1,1))\n    INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)   \nWHERE (`cc_tipo_documentoc`.`Es_Niif` IN(" + this.tipo + ")\n    AND (MID(`cc_detalle_documentoc`.`Id_Puc`,1,1) IN(4,5,6,7))\n    AND `cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND cc_documentoc.`Estado`=1)\nGROUP BY      `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta`, `Puc`\n\nHAVING valorTotal<>0\nORDER BY  `cc_detalle_documentoc`.`Id_Puc` ASC";
        } else {
            this.xsql = "  SELECT `cc_terceros`.`Id` , `cc_terceros`.`RazonSocialCompleta` , `cc_detalle_documentoc`.`Id_Puc` AS `Puc` , `cc_puc`.`Nbre` \n    , ROUND(IF(pucClase.`Tipo`=0, (SUM(`cc_detalle_documentoc`.`VDebito`)-SUM(`cc_detalle_documentoc`.`VCredito`))\n    ,(SUM(`cc_detalle_documentoc`.`VCredito`)-SUM(`cc_detalle_documentoc`.`VDebito`))),2) valorTotal\nFROM\n    `baseserver`.`cc_detalle_documentoc`\n    INNER JOIN `baseserver`.`cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `baseserver`.`cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN `baseserver`.`cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`)\n    INNER JOIN  cc_puc pucClase ON(pucClase.`Id`= MID(`cc_detalle_documentoc`.`Id_Puc`,1,1))\n    INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)   \nWHERE ((`cc_tipo_documentoc`.`Es_Niif` IN(" + this.tipo + ")\n    OR `cc_puc`.`AplicaNiif` IN(" + this.tipo + ")) AND (MID(`cc_detalle_documentoc`.`Id_Puc`,1,1) IN(4,5,6,7,8))\n    AND `cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND cc_documentoc.`Estado`=1)\nGROUP BY      `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta`, `Puc`\n\nHAVING valorTotal<>0\nORDER BY  `cc_detalle_documentoc`.`Id_Puc` ASC";
        }
        System.out.println("Cuenta : " + this.xsql);
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    if (rs.getDouble(5) > 0.0d) {
                        this.xmodelo.setValueAt(0, x, 4);
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 5);
                    } else {
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5) * (-1.0d)), x, 4);
                        this.xmodelo.setValueAt(0, x, 5);
                    }
                    this.xmodelo.setValueAt(true, x, 6);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosC() {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
            this.xsql = "  SELECT    MID(`cc_detalle_documentoc`.`Id_Puc`,1,1) AS idPuc, pucClase.`Nbre`  nombreCuenta  \n    , ROUND(IF(pucClase.`Tipo`=0, (SUM(`cc_detalle_documentoc`.`VDebito`)-SUM(`cc_detalle_documentoc`.`VCredito`))\n    ,(SUM(`cc_detalle_documentoc`.`VCredito`)-SUM(`cc_detalle_documentoc`.`VDebito`))),2) valorTotal\nFROM\n    `baseserver`.`cc_detalle_documentoc`\n    INNER JOIN `baseserver`.`cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `baseserver`.`cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN `baseserver`.`cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`)\n    INNER JOIN  cc_puc pucClase ON(pucClase.`Id`= MID(`cc_detalle_documentoc`.`Id_Puc`,1,1))\n   --  INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)   \nWHERE (`cc_tipo_documentoc`.`Es_Niif` IN(" + this.tipo + ")\n    AND (MID(`cc_detalle_documentoc`.`Id_Puc`,1,1) IN(4,5,6,7,8))\n    AND `cc_documentoc`.`Id_PeriodoC` <" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + " AND cc_documentoc.`Estado`=1)\nGROUP BY      MID(`cc_detalle_documentoc`.`Id_Puc`,1,1)\nHAVING valorTotal<>0\nORDER BY  idPuc ASC";
        } else {
            this.xsql = "  SELECT    MID(`cc_detalle_documentoc`.`Id_Puc`,1,1) AS idPuc, pucClase.`Nbre`  nombreCuenta  \n    , ROUND(IF(pucClase.`Tipo`=0, (SUM(`cc_detalle_documentoc`.`VDebito`)-SUM(`cc_detalle_documentoc`.`VCredito`))\n    ,(SUM(`cc_detalle_documentoc`.`VCredito`)-SUM(`cc_detalle_documentoc`.`VDebito`))),2) valorTotal\nFROM\n    `baseserver`.`cc_detalle_documentoc`\n    INNER JOIN `baseserver`.`cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `baseserver`.`cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN `baseserver`.`cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`)\n    INNER JOIN  cc_puc pucClase ON(pucClase.`Id`= MID(`cc_detalle_documentoc`.`Id_Puc`,1,1))\n   --  INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)   \nWHERE ((`cc_tipo_documentoc`.`Es_Niif` IN(" + this.tipo + ")\n    OR `cc_puc`.`AplicaNiif` IN(" + this.tipo + ")) AND (MID(`cc_detalle_documentoc`.`Id_Puc`,1,1) IN(4,5,6,7,8))\n    AND `cc_documentoc`.`Id_PeriodoC` <" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + " AND cc_documentoc.`Estado`=1)\nGROUP BY      MID(`cc_detalle_documentoc`.`Id_Puc`,1,1)\nHAVING valorTotal<>0\nORDER BY  idPuc ASC";
        }
        System.out.println(this.xsql);
        mCrearModeloDatosC();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        double valorUtilidad = 0.0d;
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                    xvalor += rs.getDouble(3);
                    switch (this.xmodelo1.getValueAt(x, 0).toString()) {
                        case "4":
                            valorUtilidad += rs.getDouble(3);
                            break;
                        case "5":
                            valorUtilidad -= rs.getDouble(3);
                            break;
                        case "6":
                            valorUtilidad -= rs.getDouble(3);
                            break;
                        case "7":
                            valorUtilidad -= rs.getDouble(3);
                            break;
                    }
                    x++;
                }
            }
            double xvalor2 = valorUtilidad;
            this.JTFFVCredito.setValue(Double.valueOf(xvalor2));
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    public void calcularUtilidades() {
        for (int x = 0; x < this.xmodelo1.getRowCount(); x++) {
        }
    }

    private void mEliminarFilasCero() {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue() == 0.0d && Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()).doubleValue() == 0.0d) {
                this.xmodelo.removeRow(x);
            }
        }
    }
}
