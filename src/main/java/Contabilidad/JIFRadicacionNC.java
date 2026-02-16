package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFRadicacionNC.class */
public class JIFRadicacionNC extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String[] xidunidadfuncional;
    private String[] xidcuentas;
    public String[] xidauxiliar;
    public String[] xidauxiliarxpagar;
    public String[][] xidcentrocosto;
    public String[][] xidempresa;
    public String[][] xidnfactura;
    private JIFConsultarDatos xjifconsultar;
    private claseContabilidad xclases;
    private boolean xlleno;
    private Object[] xdato;
    private JIFLiquidacionRad xjifliquidacionr;
    private String xsql;
    private String xIdObligacion;
    private String xcc_puc;
    private JButton JBTGrabar1;
    private JComboBox JCBCuenta;
    public JComboBox JCBCuentaAuxiliar;
    public JComboBox JCBCuentaAuxiliarPagar;
    public JComboBox JCBEmpresa;
    public JComboBox JCBNFactura;
    private JComboBox JCBUnidadFuncional;
    public JDateChooser JDFFechaR;
    public JLabel JLBId;
    public JLabel JLCodigoDoc1;
    private JPanel JPDatosB;
    private JPanel JPDatospago;
    private JPanel JPIDatosC;
    private JPanel JPIRadicado;
    private JPanel JPValores;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPResultado;
    public JTextPane JTAObservacion;
    public JFormattedTextField JTFFFlete;
    public JFormattedTextField JTFFIva;
    public JFormattedTextField JTFFOtros;
    public JFormattedTextField JTFFSubTotal;
    public JFormattedTextField JTFFTotalFactura;
    private JTextField JTFNNotaCredito;
    private JTextField JTFTercero;
    private JTabbedPane JTPDatos;
    public JTable JTResultado;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private boolean xlleno1 = false;
    private boolean xlleno2 = false;
    private String xidcuentapuc = "0";
    private int xid = 0;

    public JIFRadicacionNC(claseContabilidad xclases) {
        this.xlleno = false;
        initComponents();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_puc = "cc_puc_niif";
        } else {
            this.xcc_puc = "cc_puc";
        }
        this.xclases = xclases;
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.xsql = "SELECT\n   `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta`, `cc_terceros`.`FacTInterna`, `cc_terceros`.`ActivoC`\n    ,  ((ROUND(SUM(`cc_detalle_documentoc`.`VDebito`))-IF( SUM(DISTINCT cc_radicacion_pago.`Valor`) IS NULL, 0, SUM(DISTINCT cc_radicacion_pago.`Valor`) ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD\nFROM\n    `cc_terceros`\n    INNER JOIN `cc_radicacion` \n        ON (`cc_terceros`.`Id` = `cc_radicacion`.`Id_Proveedor`)\n    INNER JOIN `cc_documentoc` \n        ON (`cc_documentoc`.`Id_Radicacion` = `cc_radicacion`.`Id`)\n    INNER JOIN `cc_detalle_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n        LEFT JOIN  `cc_radicacion_pago` ON (cc_radicacion_pago.`Id_Radicacion`= cc_radicacion.`Id`) AND(cc_radicacion_pago.`Estado`=1) \nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_radicacion_notac`.`NoFactura`\n    , `cc_radicacion_notac`.`Id_Proveedor`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\nWHERE (`cc_documentoc`.`Id_TipoComprobante` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`) NCredito ON( `NCredito`.`NoFactura`=cc_radicacion.NoFactura AND `NCredito`.`Id_Proveedor` =cc_radicacion.`Id_Proveedor`)         \n        \nWHERE (`cc_radicacion`.`Estado` =1\n    AND `cc_documentoc`.`Id_TipoComprobante` in(1,21)\n    AND `cc_documentoc`.`Estado` =1)\nGROUP BY cc_terceros.Id \nHAVING VCreditoD>0\nORDER BY cc_terceros.`RazonSocialCompleta` ASC ";
        } else {
            this.xsql = "SELECT\n   `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta`, `cc_terceros`.`FacTInterna`, `cc_terceros`.`ActivoC`\n    ,  ((ROUND(SUM(`cc_detalle_documentoc`.`VDebito`))-IF( SUM(DISTINCT cc_radicacion_pago.`Valor`) IS NULL, 0, SUM(DISTINCT cc_radicacion_pago.`Valor`) ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD\nFROM\n    `cc_terceros`\n    INNER JOIN `cc_radicacion` \n        ON (`cc_terceros`.`Id` = `cc_radicacion`.`Id_Proveedor`)\n    INNER JOIN `cc_documentoc` \n        ON (`cc_documentoc`.`Id_Radicacion` = `cc_radicacion`.`Id`)\n    INNER JOIN `cc_detalle_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n        LEFT JOIN  `cc_radicacion_pago` ON (cc_radicacion_pago.`Id_Radicacion`= cc_radicacion.`Id`) AND(cc_radicacion_pago.`Estado`=1) \nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_radicacion_notac`.`NoFactura`\n    , `cc_radicacion_notac`.`Id_Proveedor`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\nWHERE (`cc_documentoc`.`Id_TipoComprobante` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`) NCredito ON( `NCredito`.`NoFactura`=cc_radicacion.NoFactura AND `NCredito`.`Id_Proveedor` =cc_radicacion.`Id_Proveedor`)         \n        \nWHERE (`cc_radicacion`.`Estado` =1\n    AND `cc_documentoc`.`Id_TipoComprobante` =1\n    AND `cc_documentoc`.`Estado` =1)\nGROUP BY cc_terceros.Id \nHAVING VCreditoD>0\nORDER BY cc_terceros.`RazonSocialCompleta` ASC ";
        }
        this.xidempresa = this.xconsultas.llenarComboyLista(this.xsql, this.xidempresa, this.JCBEmpresa, 4);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xidunidadfuncional = this.xconsultas.llenarCombo("SELECT cc_unidad_funcional.Id, cc_unidad_funcional.Nbre FROM cc_pucxunidad_funcional INNER JOIN cc_unidad_funcional  ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id) WHERE (cc_unidad_funcional.Estado =1)GROUP BY cc_unidad_funcional.Id ORDER BY cc_unidad_funcional.Nbre ASC ", this.xidunidadfuncional, this.JCBUnidadFuncional);
        this.JCBUnidadFuncional.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
        this.xlleno = true;
        mCargarDatos("SELECT cc_radicacion_notac.Id, DATE_FORMAT(cc_radicacion_notac.Fecha,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, cc_radicacion_notac.NoFactura, sum(cc_radicacion_notac.SubTotal+cc_radicacion_notac.Iva+cc_radicacion_notac.Flete+cc_radicacion_notac.Otros) as Total, cc_radicacion_notac.Observacion, cc_radicacion_notac.Id_DocumentoC,cc_radicacion_notac.Estado FROM cc_radicacion_notac INNER JOIN cc_terceros ON (cc_radicacion_notac.Id_Proveedor = cc_terceros.Id) WHERE (cc_radicacion_notac.Estado =1) GROUP BY cc_radicacion_notac.Id ");
    }

    /* JADX WARN: Type inference failed for: r3v127, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIRadicado = new JPanel();
        this.JDFFechaR = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCBNFactura = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JPValores = new JPanel();
        this.JTFFSubTotal = new JFormattedTextField();
        this.JTFFIva = new JFormattedTextField();
        this.JTFFFlete = new JFormattedTextField();
        this.JTFFOtros = new JFormattedTextField();
        this.JTFFTotalFactura = new JFormattedTextField();
        this.JPIDatosC = new JPanel();
        this.JCBUnidadFuncional = new JComboBox();
        this.JCBCuenta = new JComboBox();
        this.JCBCuentaAuxiliar = new JComboBox();
        this.JCBCuentaAuxiliarPagar = new JComboBox();
        this.JBTGrabar1 = new JButton();
        this.JLCodigoDoc1 = new JLabel();
        this.JTFNNotaCredito = new JTextField();
        this.JLBId = new JLabel();
        this.JPDatospago = new JPanel();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPDatosB = new JPanel();
        this.JTFTercero = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("RADICACIÓN NOTA CREDITO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifradicacionnc");
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFRadicacionNC.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRadicacionNC.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIRadicado.setFont(new Font("Arial", 1, 13));
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRadicacionNC.2
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacionNC.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBNFactura.setFont(new Font("Arial", 1, 12));
        this.JCBNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNFactura.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRadicacionNC.3
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacionNC.this.JCBNFacturaItemStateChanged(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setCursor(new Cursor(0));
        this.JTAObservacion.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFRadicacionNC.4
            public void keyPressed(KeyEvent evt) {
                JIFRadicacionNC.this.JTAObservacionKeyPressed(evt);
            }
        });
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JPValores.setBorder(BorderFactory.createTitledBorder((Border) null, "Valores", 0, 0, new Font("Arial", 1, 13), new Color(0, 102, 51)));
        this.JTFFSubTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "SubTotal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSubTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFSubTotal.setHorizontalAlignment(4);
        this.JTFFSubTotal.setFont(new Font("Arial", 1, 13));
        this.JTFFSubTotal.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacionNC.5
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionNC.this.JTFFSubTotalActionPerformed(evt);
            }
        });
        this.JTFFSubTotal.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacionNC.6
            public void focusLost(FocusEvent evt) {
                JIFRadicacionNC.this.JTFFSubTotalFocusLost(evt);
            }
        });
        this.JTFFIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFIva.setHorizontalAlignment(4);
        this.JTFFIva.setFont(new Font("Arial", 1, 13));
        this.JTFFIva.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacionNC.7
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionNC.this.JTFFIvaActionPerformed(evt);
            }
        });
        this.JTFFIva.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacionNC.8
            public void focusLost(FocusEvent evt) {
                JIFRadicacionNC.this.JTFFIvaFocusLost(evt);
            }
        });
        this.JTFFFlete.setBorder(BorderFactory.createTitledBorder((Border) null, "Flete", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFFlete.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFFlete.setHorizontalAlignment(4);
        this.JTFFFlete.setFont(new Font("Arial", 1, 13));
        this.JTFFFlete.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacionNC.9
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionNC.this.JTFFFleteActionPerformed(evt);
            }
        });
        this.JTFFFlete.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacionNC.10
            public void focusLost(FocusEvent evt) {
                JIFRadicacionNC.this.JTFFFleteFocusLost(evt);
            }
        });
        this.JTFFOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFOtros.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFOtros.setHorizontalAlignment(4);
        this.JTFFOtros.setFont(new Font("Arial", 1, 13));
        this.JTFFOtros.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacionNC.11
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionNC.this.JTFFOtrosActionPerformed(evt);
            }
        });
        this.JTFFOtros.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRadicacionNC.12
            public void focusLost(FocusEvent evt) {
                JIFRadicacionNC.this.JTFFOtrosFocusLost(evt);
            }
        });
        this.JTFFTotalFactura.setBackground(new Color(0, 102, 0));
        this.JTFFTotalFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalFactura.setForeground(new Color(255, 255, 255));
        this.JTFFTotalFactura.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalFactura.setHorizontalAlignment(4);
        this.JTFFTotalFactura.setEnabled(false);
        this.JTFFTotalFactura.setFont(new Font("Arial", 1, 24));
        GroupLayout JPValoresLayout = new GroupLayout(this.JPValores);
        this.JPValores.setLayout(JPValoresLayout);
        JPValoresLayout.setHorizontalGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPValoresLayout.createSequentialGroup().addContainerGap().addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFOtros, GroupLayout.Alignment.TRAILING, -1, 142, 32767).addComponent(this.JTFFSubTotal, -1, 142, 32767)).addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPValoresLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFIva, -1, 121, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFlete, -1, 120, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPValoresLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTFFTotalFactura, -2, 214, -2))).addContainerGap()));
        JPValoresLayout.setVerticalGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPValoresLayout.createSequentialGroup().addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSubTotal, -1, 48, 32767).addComponent(this.JTFFIva, -1, 48, 32767).addComponent(this.JTFFFlete, -1, 48, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPValoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFOtros, -1, 48, 32767).addComponent(this.JTFFTotalFactura)).addContainerGap()));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONTABLES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBUnidadFuncional.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadFuncional.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadFuncional.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRadicacionNC.13
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacionNC.this.JCBUnidadFuncionalItemStateChanged(evt);
            }
        });
        this.JCBCuenta.setFont(new Font("Arial", 1, 12));
        this.JCBCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuenta.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRadicacionNC.14
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacionNC.this.JCBCuentaItemStateChanged(evt);
            }
        });
        this.JCBCuentaAuxiliar.setFont(new Font("Arial", 1, 12));
        this.JCBCuentaAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuentaAuxiliarPagar.setFont(new Font("Arial", 1, 12));
        this.JCBCuentaAuxiliarPagar.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Auxiliar por Pagar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGrabar1.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar1.setText("Generar Liquidación");
        this.JBTGrabar1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRadicacionNC.15
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionNC.this.JBTGrabar1ActionPerformed(evt);
            }
        });
        this.JLCodigoDoc1.setFont(new Font("Arial", 1, 14));
        this.JLCodigoDoc1.setForeground(Color.red);
        this.JLCodigoDoc1.setHorizontalAlignment(0);
        this.JLCodigoDoc1.setText("0");
        this.JLCodigoDoc1.setBorder(BorderFactory.createTitledBorder((Border) null, "ID. Compromiso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCBUnidadFuncional, -2, 194, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCuenta, 0, 375, 32767)).addComponent(this.JCBCuentaAuxiliarPagar, 0, -1, 32767)).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBCuentaAuxiliar, -2, 426, -2).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JLCodigoDoc1, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTGrabar1, -2, 208, -2))).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBCuentaAuxiliar, -1, 50, 32767).addComponent(this.JCBUnidadFuncional, -1, 50, 32767).addComponent(this.JCBCuenta)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCBCuentaAuxiliarPagar, -2, 50, -2).addGap(13, 13, 13)).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrabar1, -1, 58, 32767).addComponent(this.JLCodigoDoc1, -1, -1, 32767)).addContainerGap()))));
        this.JTFNNotaCredito.setFont(new Font("Arial", 1, 12));
        this.JTFNNotaCredito.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nota Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBId.setFont(new Font("Arial", 1, 12));
        this.JLBId.setHorizontalAlignment(0);
        this.JLBId.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPIRadicadoLayout = new GroupLayout(this.JPIRadicado);
        this.JPIRadicado.setLayout(JPIRadicadoLayout);
        JPIRadicadoLayout.setHorizontalGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIRadicadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIRadicadoLayout.createSequentialGroup().addComponent(this.JDFFechaR, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNNotaCredito, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, -2, 510, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBNFactura, -2, 142, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBId, -1, -1, 32767)).addGroup(JPIRadicadoLayout.createSequentialGroup().addComponent(this.JSPObservacion, -1, 602, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPValores, -2, -1, -2))).addContainerGap()));
        JPIRadicadoLayout.setVerticalGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRadicadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIRadicadoLayout.createSequentialGroup().addGap(0, 2, 32767).addComponent(this.JDFFechaR, -2, 50, -2)).addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa).addComponent(this.JCBNFactura)).addComponent(this.JTFNNotaCredito).addComponent(this.JLBId, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIRadicadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -1, 165, 32767).addComponent(this.JPValores, -1, -1, 32767)).addGap(32, 32, 32).addComponent(this.JPIDatosC, -2, -1, -2).addGap(25, 25, 25)));
        this.JTPDatos.addTab("DATOS", this.JPIRadicado);
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setForeground(new Color(0, 0, 204));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 255, 204));
        this.JTResultado.setRowHeight(35);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFRadicacionNC.16
            public void mouseClicked(MouseEvent evt) {
                JIFRadicacionNC.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFTercero.setFont(new Font("Arial", 0, 13));
        this.JTFTercero.setHorizontalAlignment(2);
        this.JTFTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTercero.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFRadicacionNC.17
            public void keyTyped(KeyEvent evt) {
                JIFRadicacionNC.this.JTFTerceroKeyTyped(evt);
            }
        });
        GroupLayout JPDatosBLayout = new GroupLayout(this.JPDatosB);
        this.JPDatosB.setLayout(JPDatosBLayout);
        JPDatosBLayout.setHorizontalGroup(JPDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosBLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFTercero, -1, 1011, 32767).addContainerGap()));
        JPDatosBLayout.setVerticalGroup(JPDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosBLayout.createSequentialGroup().addComponent(this.JTFTercero, -2, -1, -2).addContainerGap(15, 32767)));
        GroupLayout JPDatospagoLayout = new GroupLayout(this.JPDatospago);
        this.JPDatospago.setLayout(JPDatospagoLayout);
        JPDatospagoLayout.setHorizontalGroup(JPDatospagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatospagoLayout.createSequentialGroup().addContainerGap().addGroup(JPDatospagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatosB, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPResultado, GroupLayout.Alignment.TRAILING, -1, 1047, 32767)).addContainerGap()));
        JPDatospagoLayout.setVerticalGroup(JPDatospagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatospagoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPResultado, -2, 335, -2).addGap(310, 310, 310)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPDatospago);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 1072, -2).addContainerGap(16, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 495, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSubTotalActionPerformed(ActionEvent evt) {
        this.JTFFSubTotal.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSubTotalFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIvaActionPerformed(ActionEvent evt) {
        this.JTFFIva.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIvaFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFleteActionPerformed(ActionEvent evt) {
        this.JTFFFlete.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFFleteFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFOtrosActionPerformed(ActionEvent evt) {
        this.JTFFOtros.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFOtrosFocusLost(FocusEvent evt) {
        mCalcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            mNuevo();
            mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFuncionalItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadFuncional.getSelectedIndex() != -1) {
            this.JCBCuentaAuxiliar.removeAllItems();
            this.JCBCuenta.removeAllItems();
            String sql = "SELECT cc_puc.Id, concat(cc_puc.Id,'-',cc_puc.Nbre) as Nombre FROM cc_pucxunidad_funcional INNER JOIN cc_puc  ON (cc_pucxunidad_funcional.Id_Puc = cc_puc.Id) WHERE (cc_pucxunidad_funcional.Estado =1 AND cc_pucxunidad_funcional.Id_UnidadFuncional ='" + this.xidunidadfuncional[this.JCBUnidadFuncional.getSelectedIndex()] + "') order by cc_puc.Nbre";
            this.xidcuentas = this.xconsultas.llenarCombo(sql, this.xidcuentas, this.JCBCuenta);
            this.JCBCuenta.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBCuenta.getSelectedIndex() != -1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.JCBCuentaAuxiliar.removeAllItems();
            String sql = "SELECT Id, concat(Id,'-',Nbre)as Nombre FROM " + this.xcc_puc + " WHERE (Id LIKE'" + this.xidcuentas[this.JCBCuenta.getSelectedIndex()] + "%' AND UNivel=1) ORDER BY Nbre ASC ";
            this.xidauxiliar = xct.llenarCombo(sql, this.xidauxiliar, this.JCBCuentaAuxiliar);
            this.JCBCuentaAuxiliar.setSelectedIndex(-1);
            xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        String sql;
        if (this.xlleno && this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("1")) {
                this.JCBCuentaAuxiliar.removeAllItems();
                this.JCBCuenta.removeAllItems();
                this.JCBCuentaAuxiliarPagar.removeAllItems();
                this.JCBUnidadFuncional.setSelectedIndex(-1);
                this.JCBNFactura.removeAllItems();
                ConsultasMySQL xct = new ConsultasMySQL();
                String sql2 = "SELECT cc_cpagarpucxempresa.Id_AuxPuc, CONCAT(cc_cpagarpucxempresa.Id_AuxPuc,'-',cc_puc.Nbre) AS NPuc FROM cc_cpagarpucxempresa INNER JOIN cc_puc ON (cc_cpagarpucxempresa.Id_AuxPuc = cc_puc.Id)  WHERE (cc_cpagarpucxempresa.Estado =1 AND cc_cpagarpucxempresa.Id_Empresa ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') ";
                this.xidauxiliarxpagar = xct.llenarCombo(sql2, this.xidauxiliarxpagar, this.JCBCuentaAuxiliarPagar);
                this.JCBCuentaAuxiliarPagar.setSelectedIndex(-1);
                this.xlleno2 = false;
                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    sql = "SELECT cc_radicacion.NoFactura, cc_radicacion.NoFactura, cc_unidad_funcional.Nbre AS NUnidadF  , \n                         CONCAT(cc_cuentapuc.Id,'-',cc_cuentapuc.Nbre) AS Cuenta,\n                          CONCAT(cc_auxiliar_cuenta.Id,'-' ,cc_auxiliar_cuenta.Nbre) AS CAuxiliar , \n                           CONCAT(cc_radicacion.Id_CuentaAuxPPagar,'-' ,cc_puc.Nbre) AS CAuxiliarPagar, cc_radicacion.`Id_Compromiso` \n    ,  ((ROUND(SUM(`cc_detalle_documentoc`.`VDebito`))-IF( SUM(DISTINCT cc_radicacion_pago.`Valor`) IS NULL, 0, SUM(DISTINCT cc_radicacion_pago.`Valor`) ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD, pp_movimiento.`IdObligacion` \nFROM\n    `cc_terceros`\n    INNER JOIN `cc_radicacion` \n        ON (`cc_terceros`.`Id` = `cc_radicacion`.`Id_Proveedor`)\n    INNER JOIN `cc_documentoc` \n        ON (`cc_documentoc`.`Id_Radicacion` = `cc_radicacion`.`Id`)\n    INNER JOIN `cc_detalle_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n        INNER JOIN cc_puc cc_auxiliar_cuenta ON (cc_auxiliar_cuenta.Id = cc_radicacion.Id_CuentaAuxPuc)\n        INNER JOIN cc_puc cc_cuentapuc ON (cc_radicacion.`Id_Cuenta` = cc_cuentapuc.Id) \n   INNER JOIN cc_unidad_funcional  ON (cc_radicacion.`Id_UnidadF`= cc_unidad_funcional.Id)  \n   INNER JOIN cc_puc  ON (cc_puc.Id = cc_radicacion.Id_CuentaAuxPPagar)     \n   \n        LEFT JOIN  `cc_radicacion_pago` ON (cc_radicacion_pago.`Id_Radicacion`= cc_radicacion.`Id`) AND(cc_radicacion_pago.`Estado`=1) \nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_radicacion_notac`.`NoFactura`\n    , `cc_radicacion_notac`.`Id_Proveedor`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\nWHERE (`cc_documentoc`.`Id_TipoComprobante` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`) NCredito ON( `NCredito`.`NoFactura`=cc_radicacion.NoFactura AND `NCredito`.`Id_Proveedor` =cc_radicacion.`Id_Proveedor`)         \n LEFT JOIN `pp_movimiento` ON(cc_documentoc.`Id`=pp_movimiento.`IdDocContable`)WHERE (cc_radicacion.Id_Proveedor = '" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `cc_radicacion`.`Estado` =1\n    AND `cc_documentoc`.`Id_TipoComprobante` in(1,21)\n    AND `cc_documentoc`.`Estado` =1)\nGROUP BY cc_terceros.Id, `cc_radicacion`.`Id`\nHAVING VCreditoD>0\nORDER BY cc_terceros.`RazonSocialCompleta` ASC ";
                } else {
                    sql = "SELECT cc_radicacion.NoFactura, cc_radicacion.NoFactura, cc_unidad_funcional.Nbre AS NUnidadF  , \n                         CONCAT(cc_cuentapuc.Id,'-',cc_cuentapuc.Nbre) AS Cuenta,\n                          CONCAT(cc_auxiliar_cuenta.Id,'-' ,cc_auxiliar_cuenta.Nbre) AS CAuxiliar , \n                           CONCAT(cc_radicacion.Id_CuentaAuxPPagar,'-' ,cc_puc.Nbre) AS CAuxiliarPagar, cc_radicacion.`Id_Compromiso` \n    ,  ((ROUND(SUM(`cc_detalle_documentoc`.`VDebito`))-IF( SUM(DISTINCT cc_radicacion_pago.`Valor`) IS NULL, 0, SUM(DISTINCT cc_radicacion_pago.`Valor`) ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD, pp_movimiento.`IdObligacion` \nFROM\n    `cc_terceros`\n    INNER JOIN `cc_radicacion` \n        ON (`cc_terceros`.`Id` = `cc_radicacion`.`Id_Proveedor`)\n    INNER JOIN `cc_documentoc` \n        ON (`cc_documentoc`.`Id_Radicacion` = `cc_radicacion`.`Id`)\n    INNER JOIN `cc_detalle_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n        INNER JOIN cc_puc cc_auxiliar_cuenta ON (cc_auxiliar_cuenta.Id = cc_radicacion.Id_CuentaAuxPuc)\n        INNER JOIN cc_puc cc_cuentapuc ON (cc_radicacion.`Id_Cuenta` = cc_cuentapuc.Id) \n   INNER JOIN cc_unidad_funcional  ON (cc_radicacion.`Id_UnidadF`= cc_unidad_funcional.Id)  \n   INNER JOIN cc_puc  ON (cc_puc.Id = cc_radicacion.Id_CuentaAuxPPagar)     \n   \n        LEFT JOIN  `cc_radicacion_pago` ON (cc_radicacion_pago.`Id_Radicacion`= cc_radicacion.`Id`) AND(cc_radicacion_pago.`Estado`=1) \nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_radicacion_notac`.`NoFactura`\n    , `cc_radicacion_notac`.`Id_Proveedor`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\nWHERE (`cc_documentoc`.`Id_TipoComprobante` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`) NCredito ON( `NCredito`.`NoFactura`=cc_radicacion.NoFactura AND `NCredito`.`Id_Proveedor` =cc_radicacion.`Id_Proveedor`)         \n LEFT JOIN `pp_movimiento` ON(cc_documentoc.`Id`=pp_movimiento.`IdDocContable`)WHERE (cc_radicacion.Id_Proveedor = '" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `cc_radicacion`.`Estado` =1\n    AND `cc_documentoc`.`Id_TipoComprobante` =1\n    AND `cc_documentoc`.`Estado` =1)\nGROUP BY cc_terceros.Id, `cc_radicacion`.`Id`\nHAVING VCreditoD>0\nORDER BY cc_terceros.`RazonSocialCompleta` ASC ";
                }
                this.xidnfactura = this.xconsultas.llenarComboyLista(sql, this.xidnfactura, this.JCBNFactura, 9);
                this.JCBNFactura.setSelectedIndex(-1);
                xct.cerrarConexionBd();
                this.xlleno2 = true;
                return;
            }
            mMensajeTercero();
        }
    }

    public String getxIdObligacion() {
        return this.xIdObligacion;
    }

    public void setxIdObligacion(String xIdObligacion) {
        this.xIdObligacion = xIdObligacion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTerceroKeyTyped(KeyEvent evt) {
        if (!this.JTFTercero.getText().isEmpty()) {
            String sql = "SELECT cc_radicacion_notac.Id, DATE_FORMAT(cc_radicacion_notac.Fecha,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, cc_radicacion_notac.NoFactura, sum(cc_radicacion_notac.SubTotal+cc_radicacion_notac.Iva+cc_radicacion_notac.Flete+cc_radicacion_notac.Otros) as Total, cc_radicacion_notac.Observacion, cc_radicacion_notac.Id_DocumentoC,cc_radicacion_notac.Estado FROM cc_radicacion_notac INNER JOIN cc_terceros ON (cc_radicacion_notac.Id_Proveedor = cc_terceros.Id) WHERE (cc_terceros.RazonSocialCompleta like'" + this.JTFTercero.getText() + "%' AND cc_radicacion_notac.Estado =1) GROUP BY cc_radicacion_notac.Id ";
            mCargarDatos(sql);
        } else {
            mCargarDatos("SELECT cc_radicacion_notac.Id, DATE_FORMAT(cc_radicacion_notac.Fecha,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, cc_radicacion_notac.NoFactura, sum(cc_radicacion_notac.SubTotal+cc_radicacion_notac.Iva+cc_radicacion_notac.Flete+cc_radicacion_notac.Otros) as Total, cc_radicacion_notac.Observacion, cc_radicacion_notac.Id_DocumentoC,cc_radicacion_notac.Estado FROM cc_radicacion_notac INNER JOIN cc_terceros ON (cc_radicacion_notac.Id_Proveedor = cc_terceros.Id) WHERE (cc_radicacion_notac.Estado =1) GROUP BY cc_radicacion_notac.Id ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabar1ActionPerformed(ActionEvent evt) {
        if (!this.JLBId.getText().isEmpty()) {
            Principal.xclase.cargarPantalla("Generar Liquidacion Nc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNFacturaItemStateChanged(ItemEvent evt) {
        if (this.xlleno2 && this.JCBNFactura.getSelectedIndex() != -1 && this.JCBNFactura.getItemCount() >= 0) {
            this.JCBCuentaAuxiliar.removeAllItems();
            this.JCBCuenta.removeAllItems();
            this.JCBUnidadFuncional.setSelectedIndex(-1);
            this.JCBCuentaAuxiliarPagar.setSelectedItem(this.xidnfactura[this.JCBNFactura.getSelectedIndex()][4]);
            this.JCBUnidadFuncional.setSelectedItem(this.xidnfactura[this.JCBNFactura.getSelectedIndex()][1]);
            this.JCBCuenta.setSelectedItem(this.xidnfactura[this.JCBNFactura.getSelectedIndex()][2]);
            this.JCBCuentaAuxiliar.setSelectedItem(this.xidnfactura[this.JCBNFactura.getSelectedIndex()][3]);
            this.JLCodigoDoc1.setText(this.xidnfactura[this.JCBNFactura.getSelectedIndex()][5]);
            setxIdObligacion(this.xidnfactura[this.JCBNFactura.getSelectedIndex()][7]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9 || evt.getKeyCode() == 10) {
            this.JTAObservacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    private void mMensajeTercero() {
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Tercero desactivado por no tener movimiento;</p><font face='Arial' color='red' size=4>No se pueder realizar registro.", "VERIFICACIÓN TERCERO", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
    }

    public void mGrabar() {
        if (!this.JLBId.getText().isEmpty()) {
            if (this.xclases.mValidarExistenciaComprobanteContable(this.JLBId.getText()).longValue() == 0) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                }
                return;
            } else {
                mGenerarLiqudiacion();
                return;
            }
        }
        if (this.xclases.getXidperiodoc() != -1 && mValidar()) {
            if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("1")) {
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x2 == 0) {
                    String sql = "insert into cc_radicacion_notac (Fecha, Id_Proveedor, Id_PeriodoC, Id_Compromiso, NoNotaC, NoFactura, SubTotal, Iva, Flete, Otros, Observacion, Id_CuentaAuxPuc, Id_CuentaAuxPPagar, UsuarioS, FechaS) Values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaR.getDate()) + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "','" + this.xclases.getXidperiodoc() + "','" + this.JLCodigoDoc1.getText() + "','" + this.JTFNNotaCredito.getText() + "','" + this.xidnfactura[this.JCBNFactura.getSelectedIndex()][0] + "','" + this.JTFFSubTotal.getValue() + "','" + this.JTFFIva.getValue() + "','" + this.JTFFFlete.getValue() + "','" + this.JTFFOtros.getValue() + "','" + this.JTAObservacion.getText() + "','" + this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()] + "','" + this.xidauxiliarxpagar[this.JCBCuentaAuxiliarPagar.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                    this.JLBId.setText(this.xconsultas.ejecutarSQLId(sql));
                    return;
                }
                return;
            }
            mMensajeTercero();
        }
    }

    private void mGenerarLiqudiacion() {
        long xnc = this.xclases.mValidarExistenciaComprobanteContable(this.JLBId.getText()).longValue();
        if (xnc != 0) {
            int y = JOptionPane.showInternalConfirmDialog(this, "Radicación ya tiene un documento generado, \nDesea visualizarlo? ", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (y == 0) {
                this.xclases.mImprimDocumentoContable("IdC", String.valueOf(xnc), "CC_LiquidacionFactura", "4", "", "");
                return;
            }
            return;
        }
        int y2 = JOptionPane.showInternalConfirmDialog(this, "Desea generar documento el documento contable?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y2 == 0) {
            Principal.xclase.cargarPantalla("Comprobante");
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFFechaR.setDate(this.xmetodos.getFechaActual());
        this.JCBEmpresa.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.JTFNNotaCredito.setText("");
        this.JTFFSubTotal.setValue(new Integer(0));
        this.JTFFIva.setValue(new Integer(0));
        this.JTFFFlete.setValue(new Integer(0));
        this.JTFFOtros.setValue(new Integer(0));
        this.JTFFTotalFactura.setValue(new Integer(0));
        this.xlleno = false;
        this.xlleno1 = false;
        this.JCBNFactura.removeAllItems();
        this.JCBCuentaAuxiliar.removeAllItems();
        this.JCBCuenta.removeAllItems();
        this.JCBUnidadFuncional.setSelectedIndex(-1);
        this.JCBCuentaAuxiliarPagar.removeAllItems();
        this.xlleno = true;
        this.JDFFechaR.requestFocus();
    }

    public void mAnular() {
        if (!this.JLBId.getText().isEmpty() && !this.JLBId.getText().equals("ANULADA")) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String sql = "update cc_radicacion_notac set Estado=0 where id='" + this.JLBId.getText() + "'";
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatos("SELECT cc_radicacion_notac.Id, DATE_FORMAT(cc_radicacion_notac.Fecha,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, cc_radicacion_notac.NoFactura, sum(cc_radicacion_notac.SubTotal+cc_radicacion_notac.Iva+cc_radicacion_notac.Flete+cc_radicacion_notac.Otros) as Total, cc_radicacion_notac.Observacion, cc_radicacion_notac.Id_DocumentoC,cc_radicacion_notac.Estado FROM cc_radicacion_notac INNER JOIN cc_terceros ON (cc_radicacion_notac.Id_Proveedor = cc_terceros.Id) WHERE (cc_radicacion_notac.Estado =1) GROUP BY cc_radicacion_notac.Id ");
            }
        }
    }

    private boolean mValidar() {
        boolean xestado1 = false;
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.JCBNFactura.getSelectedIndex() == -1) {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBNFactura.requestFocus();
            } else if (Double.valueOf(this.JTFFTotalFactura.getValue().toString()).doubleValue() != 0.0d) {
                if (this.JCBCuentaAuxiliar.getSelectedIndex() != -1) {
                    if (this.JCBCuentaAuxiliarPagar.getSelectedIndex() != -1) {
                        xestado1 = true;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la cuenta auxiliar a pagar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBCuentaAuxiliarPagar.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la cuenta auxiliar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTFFSubTotal.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe resgistra valores de factura", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFFSubTotal.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Proveedor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBEmpresa.requestFocus();
        }
        return xestado1;
    }

    private void mCalcularTotal() {
        double total = Double.valueOf(this.JTFFSubTotal.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFFlete.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFIva.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFOtros.getValue().toString()).doubleValue();
        this.JTFFTotalFactura.setValue(Double.valueOf(total));
    }

    public void mBuscar() {
        this.xjifconsultar = new JIFConsultarDatos(this.xclases);
        Principal.cargarPantalla(this.xjifconsultar);
    }

    public void mBuscarDatos(String xid) {
        String sql = "SELECT cc_radicacion_notac.Id, cc_radicacion_notac.Fecha, cc_terceros.RazonSocialCompleta, cc_radicacion_notac.Observacion, cc_radicacion_notac.NoFactura, cc_radicacion_notac.SubTotal, cc_radicacion_notac.Iva, cc_radicacion_notac.Flete, cc_radicacion_notac.Otros, cc_unidad_funcional.Nbre , concat(cc_cuentapuc.Id,'-',cc_cuentapuc.Nbre) as Cuenta, concat(cc_auxiliar_cuenta.Id,'-',cc_auxiliar_cuenta.Nbre) as CuentaAuxiliar, concat(cc_puc.Id,'-',cc_puc.Nbre) as CuentaPagar, if(cc_radicacion_notac.Estado=1,'ACTIVA', 'ANULADA') AS Estado, cc_radicacion_notac.NoNotaC   FROM cc_puc cc_auxiliar_cuenta   INNER JOIN cc_radicacion_notac  ON (cc_auxiliar_cuenta.Id = cc_radicacion_notac.Id_CuentaAuxPuc) INNER JOIN cc_terceros ON (cc_radicacion_notac.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_puc cc_cuentapuc  ON (cc_cuentapuc.Id = MID(cc_auxiliar_cuenta.`Id`, 1,(LENGTH(cc_auxiliar_cuenta.`Id`)-4)) )  INNER JOIN cc_pucxunidad_funcional ON (cc_pucxunidad_funcional.Id_Puc = cc_cuentapuc.Id) INNER JOIN cc_unidad_funcional ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id) INNER JOIN cc_puc ON (cc_puc.Id = cc_radicacion_notac.Id_CuentaAuxPPagar) WHERE (cc_radicacion_notac.Id ='" + xid + "' AND cc_radicacion_notac.Estado =1) ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JLBId.setText(xrs.getString(1));
                Principal.txtEstado.setText(xrs.getString(14));
                this.JDFFechaR.setDate(xrs.getDate(2));
                this.JCBEmpresa.setSelectedItem(xrs.getString(3));
                this.JTAObservacion.setText(xrs.getString(4));
                this.JCBNFactura.setSelectedItem(xrs.getString(5));
                this.JTFFSubTotal.setValue(Double.valueOf(xrs.getDouble(6)));
                this.JTFFIva.setValue(Double.valueOf(xrs.getDouble(7)));
                this.JTFFFlete.setValue(Double.valueOf(xrs.getDouble(8)));
                this.JTFFOtros.setValue(Double.valueOf(xrs.getDouble(9)));
                this.JCBUnidadFuncional.setSelectedItem(xrs.getString(10));
                this.JCBCuenta.setSelectedItem(xrs.getString(11));
                this.JCBCuentaAuxiliar.setSelectedItem(xrs.getString(12));
                this.JCBCuentaAuxiliarPagar.setSelectedItem(xrs.getString(13));
                this.JTFNNotaCredito.setText(xrs.getString(15));
                mCalcularTotal();
            }
            xrs.close();
            xct.cerrarConexionBd();
            this.JTPDatos.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(JIFRadicacionNC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!this.JLBId.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = this.JLBId.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_RadicacionNotaCredito", mparametros);
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Tercero", "N° Factura", "Total", "Observación", "N° Doc", "Estado"}) { // from class: Contabilidad.JIFRadicacionNC.18
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(20);
    }

    private void mCargarDatos(String xsql) {
        mCrearTabla();
        ResultSet rs = this.xconsultas.traerRs(xsql);
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
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(8)), x, 7);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }
}
