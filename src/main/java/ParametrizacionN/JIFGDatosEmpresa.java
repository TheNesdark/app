package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGDatosEmpresa.class */
public class JIFGDatosEmpresa extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelos;
    private String[] xidtipodoc;
    private String[] xidmunicipio;
    private String[] xidmunicipios;
    private Object[] xdatos;
    private Object[] xdatoSS;
    private File xfile;
    private File xfile1;
    private File xfile2;
    private File xfile3;
    private int xecorreo;
    private ButtonGroup JBGFRCaja;
    private ButtonGroup JBGForma;
    private ButtonGroup JBGOpciones;
    private ButtonGroup JBGTipoR;
    private ButtonGroup JBGVisualizacion;
    private JButton JBT_Salir;
    private JComboBox JCBMunicipio;
    private JComboBox JCBMunicipioS;
    private JComboBox JCBTipoIdent;
    private JCheckBox JCHECorreo;
    private JCheckBox JCHEPrincipal;
    private JCheckBox JCHEsEspecial1;
    private JCheckBox JCHEstado;
    private JCheckBox JCHFiltroPP;
    private JCheckBox JCHMContable;
    private JCheckBox JCHPresupuestal;
    private JPanel JDSedes;
    private JPanel JPIDatos;
    private JPanel JPIDatosA;
    private JPanel JPIDatosA1;
    private JPanel JPIFIRCaja;
    private JPanel JPIFVisualizacion;
    private JPanel JPIHistorico;
    private JPanel JPIReporteU;
    private JPanel JPIVisualizacion;
    private JRadioButton JRBFIRCajaN;
    private JRadioButton JRBFIRTirilla;
    private JRadioButton JRBFImpresosa;
    private JRadioButton JRBFVisual;
    private JRadioButton JRBR1;
    private JRadioButton JRBR2;
    private JRadioButton JRBR3;
    private JRadioButton JRBVFacturada;
    private JRadioButton JRBVToda;
    private JScrollPane JSPDetalleNotas;
    private JScrollPane JSPDetalleNotas1;
    private JSpinner JSPDigitoV;
    private JScrollPane JSPDireccion;
    private JScrollPane JSPDireccion1;
    private JScrollPane JSPEsloga;
    private JScrollPane JSPLCertificacionSoat;
    private JScrollPane JSPLOrdenSalida;
    private JSpinner JSPNDiasCC;
    private JSpinner JSPNR256;
    private JScrollPane JSPNotaAnt;
    private JScrollPane JSPPie1;
    private JScrollPane JSPPie2;
    private JScrollPane JSPPie3;
    private JScrollPane JSPPie4;
    private JScrollPane JSPResolucionDian;
    private JTable JTBDetalle;
    private JTable JTBDetalleS;
    private JTextField JTFAdministrador;
    private JTextField JTFCodigo;
    private JTextField JTFCodigoInterfaz;
    private JTextField JTFCodigoOrg;
    private JTextField JTFEmail;
    private JTextField JTFEmailS;
    private JTextField JTFEmailSC;
    private JFormattedTextField JTFFNCitas;
    private JFormattedTextField JTFFNDocumento;
    private JFormattedTextField JTFFRRips;
    private JFormattedTextField JTFFSalarioMinimo;
    private JFormattedTextField JTFFTopeCompra;
    private JTextField JTFFax;
    private JTextField JTFFaxS;
    private JTextField JTFGerente;
    private JTextField JTFIdTercero;
    private JSpinner JTFMinutos;
    private JTextField JTFNCheque;
    private JTextField JTFNombre;
    private JTextField JTFNombres;
    private JTextField JTFPrefijo;
    private JTextField JTFPresidente;
    private JTextField JTFRuta;
    private JTextField JTFRuta1;
    private JTextField JTFRutaInvima;
    private JTextField JTFRutaLogoSS;
    private JTextField JTFRuta_DocCal;
    private JTextField JTFRuta_Img_Grafica;
    private JTextField JTFRuta_SDC;
    private JTextField JTFTelefono;
    private JTextField JTFTelefonoS;
    private JTextField JTFWeb;
    private JTextPane JTLCertificacionSoat;
    private JTextPane JTLOrdenSalida;
    private JTabbedPane JTPDatos;
    private JTextPane JTPDireccion;
    private JTextPane JTPDireccion1;
    private JTextField JTPDireccionS;
    private JTextPane JTPEslogan;
    private JTextPane JTPNotaAnt;
    private JTextPane JTPPie1;
    private JTextPane JTPPie2;
    private JTextPane JTPPie3;
    private JTextPane JTPPie4;
    private JTextPane JTPResolucionDian;
    private JPanel jPanel7;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xesespecial = 0;
    private int xvisualizacion = 0;
    private int xtiporeporte = 0;
    private int xfimpresion = 0;
    private int xfircaja = 0;
    private int xmpresupuesto = 0;
    private int xmcontable = 0;
    private int xFiltroPP = 0;
    private int xestado = 1;
    private int xguardar = 0;
    private int xresolucion = 0;
    private int xprincipal = 1;

    public JIFGDatosEmpresa() {
        initComponents();
        this.xidtipodoc = this.xconsulta.llenarCombo("SELECT Id, Id FROM g_tipoidentificacion WHERE (EsContable =1) order by Nbre ", this.xidtipodoc, this.JCBTipoIdent);
        this.JCBTipoIdent.setSelectedIndex(-1);
        this.xidmunicipio = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_municipio ORDER BY Nbre ASC", this.xidmunicipio, this.JCBMunicipio);
        this.JCBMunicipio.setSelectedIndex(-1);
        this.xidmunicipios = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_municipio ORDER BY Nbre ASC", this.xidmunicipios, this.JCBMunicipioS);
        this.JCBMunicipioS.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mBuscarDatosBd();
        mCargarDatosTabla();
        mCargarDatosTablaS(Principal.txtNo.getText());
    }

    /* JADX WARN: Type inference failed for: r3v270, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v297, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JBGVisualizacion = new ButtonGroup();
        this.JBGTipoR = new ButtonGroup();
        this.JBGForma = new ButtonGroup();
        this.JBGFRCaja = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JCBTipoIdent = new JComboBox();
        this.JTFFNDocumento = new JFormattedTextField();
        this.JSPDigitoV = new JSpinner();
        this.JTFNombre = new JTextField();
        this.JTFCodigoOrg = new JTextField();
        this.JCBMunicipio = new JComboBox();
        this.JTFTelefono = new JTextField();
        this.JTFFax = new JTextField();
        this.JTFEmail = new JTextField();
        this.JTFWeb = new JTextField();
        this.JTFPresidente = new JTextField();
        this.JTFGerente = new JTextField();
        this.JTFAdministrador = new JTextField();
        this.JTFRuta_SDC = new JTextField();
        this.JTFRuta_DocCal = new JTextField();
        this.JTFRuta_Img_Grafica = new JTextField();
        this.JTFEmailSC = new JTextField();
        this.JPIDatosA = new JPanel();
        this.JSPResolucionDian = new JScrollPane();
        this.JTPResolucionDian = new JTextPane();
        this.JSPPie1 = new JScrollPane();
        this.JTPPie1 = new JTextPane();
        this.JSPPie2 = new JScrollPane();
        this.JTPPie2 = new JTextPane();
        this.JTFFTopeCompra = new JFormattedTextField();
        this.JTFFNCitas = new JFormattedTextField();
        this.JTFFRRips = new JFormattedTextField();
        this.JTFFSalarioMinimo = new JFormattedTextField();
        this.JCHFiltroPP = new JCheckBox();
        this.JSPPie3 = new JScrollPane();
        this.JTPPie3 = new JTextPane();
        this.JSPPie4 = new JScrollPane();
        this.JTPPie4 = new JTextPane();
        this.JSPNotaAnt = new JScrollPane();
        this.JTPNotaAnt = new JTextPane();
        this.JTFPrefijo = new JTextField();
        this.JTFNCheque = new JTextField();
        this.JCHEsEspecial1 = new JCheckBox();
        this.JSPLOrdenSalida = new JScrollPane();
        this.JTLOrdenSalida = new JTextPane();
        this.JSPLCertificacionSoat = new JScrollPane();
        this.JTLCertificacionSoat = new JTextPane();
        this.JPIDatosA1 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JTFRuta1 = new JTextField();
        this.JSPNDiasCC = new JSpinner();
        this.JSPDireccion = new JScrollPane();
        this.JTPDireccion = new JTextPane();
        this.JSPDireccion1 = new JScrollPane();
        this.JTPDireccion1 = new JTextPane();
        this.JSPEsloga = new JScrollPane();
        this.JTPEslogan = new JTextPane();
        this.JPIVisualizacion = new JPanel();
        this.JRBVToda = new JRadioButton();
        this.JRBVFacturada = new JRadioButton();
        this.JTFRutaLogoSS = new JTextField();
        this.JCHECorreo = new JCheckBox();
        this.JPIReporteU = new JPanel();
        this.JRBR1 = new JRadioButton();
        this.JRBR2 = new JRadioButton();
        this.JRBR3 = new JRadioButton();
        this.JPIFVisualizacion = new JPanel();
        this.JRBFImpresosa = new JRadioButton();
        this.JRBFVisual = new JRadioButton();
        this.JPIFIRCaja = new JPanel();
        this.JRBFIRCajaN = new JRadioButton();
        this.JRBFIRTirilla = new JRadioButton();
        this.JCHMContable = new JCheckBox();
        this.JCHPresupuestal = new JCheckBox();
        this.JTFIdTercero = new JTextField();
        this.JSPNR256 = new JSpinner();
        this.JTFRutaInvima = new JTextField();
        this.JPIHistorico = new JPanel();
        this.JSPDetalleNotas = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JDSedes = new JPanel();
        this.jPanel7 = new JPanel();
        this.JTFNombres = new JTextField();
        this.JCBMunicipioS = new JComboBox();
        this.JTPDireccionS = new JTextField();
        this.JTFTelefonoS = new JTextField();
        this.JTFFaxS = new JTextField();
        this.JTFEmailS = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEPrincipal = new JCheckBox();
        this.JSPDetalleNotas1 = new JScrollPane();
        this.JTBDetalleS = new JTable();
        this.JBT_Salir = new JButton();
        this.JTFCodigo = new JTextField();
        this.JTFMinutos = new JSpinner();
        this.JTFCodigoInterfaz = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("DATOS EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifdatosempresa");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JCBTipoIdent.setFont(new Font("Arial", 1, 12));
        this.JCBTipoIdent.setBorder(BorderFactory.createTitledBorder((Border) null, "TipoDoc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Doc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDocumento.setFont(new Font("Arial", 1, 12));
        this.JSPDigitoV.setFont(new Font("Arial", 1, 12));
        this.JSPDigitoV.setBorder(BorderFactory.createTitledBorder((Border) null, "DV", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Razón Social", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoOrg.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoOrg.setToolTipText("");
        this.JTFCodigoOrg.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Organismo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTelefono.setFont(new Font("Arial", 1, 12));
        this.JTFTelefono.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTelefono.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.1
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JTFTelefonoActionPerformed(evt);
            }
        });
        this.JTFFax.setFont(new Font("Arial", 1, 12));
        this.JTFFax.setBorder(BorderFactory.createTitledBorder((Border) null, "Fax", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEmail.setFont(new Font("Arial", 1, 12));
        this.JTFEmail.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFWeb.setFont(new Font("Arial", 1, 12));
        this.JTFWeb.setBorder(BorderFactory.createTitledBorder((Border) null, "Web", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPresidente.setFont(new Font("Arial", 1, 12));
        this.JTFPresidente.setBorder(BorderFactory.createTitledBorder((Border) null, "Presidente Junta Directiva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFGerente.setFont(new Font("Arial", 1, 12));
        this.JTFGerente.setBorder(BorderFactory.createTitledBorder((Border) null, "Gerente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAdministrador.setFont(new Font("Arial", 1, 12));
        this.JTFAdministrador.setBorder(BorderFactory.createTitledBorder((Border) null, "Administrador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta_SDC.setFont(new Font("Arial", 1, 12));
        this.JTFRuta_SDC.setText("S:\\");
        this.JTFRuta_SDC.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Documentos Usuario (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta_SDC.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGDatosEmpresa.2
            public void mouseClicked(MouseEvent evt) {
                JIFGDatosEmpresa.this.JTFRuta_SDCMouseClicked(evt);
            }
        });
        this.JTFRuta_DocCal.setFont(new Font("Arial", 1, 12));
        this.JTFRuta_DocCal.setText("S:\\");
        this.JTFRuta_DocCal.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Documentos de Calidad (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta_DocCal.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGDatosEmpresa.3
            public void mouseClicked(MouseEvent evt) {
                JIFGDatosEmpresa.this.JTFRuta_DocCalMouseClicked(evt);
            }
        });
        this.JTFRuta_Img_Grafica.setFont(new Font("Arial", 1, 12));
        this.JTFRuta_Img_Grafica.setText("S:\\");
        this.JTFRuta_Img_Grafica.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Imagenes Graficas (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta_Img_Grafica.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGDatosEmpresa.4
            public void mouseClicked(MouseEvent evt) {
                JIFGDatosEmpresa.this.JTFRuta_Img_GraficaMouseClicked(evt);
            }
        });
        this.JTFEmailSC.setFont(new Font("Arial", 1, 12));
        this.JTFEmailSC.setToolTipText("Correo destinatario del programa de seguridad clinica");
        this.JTFEmailSC.setBorder(BorderFactory.createTitledBorder((Border) null, "Email Seguridad Clinica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEmailSC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.5
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JTFEmailSCActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoIdent, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNDocumento, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDigitoV, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFax, -2, 191, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEmail, -2, 326, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFWeb)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFPresidente, -2, 275, -2).addGap(18, 18, 18).addComponent(this.JTFGerente, -2, 272, -2).addGap(18, 18, 18).addComponent(this.JTFAdministrador)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCodigoOrg, -2, 151, -2).addGap(18, 18, 18).addComponent(this.JCBMunicipio, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JTFTelefono, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEmailSC)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFRuta_SDC, -2, 312, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta_DocCal, -2, 312, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta_Img_Grafica, -1, 261, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoIdent, -1, 50, 32767).addComponent(this.JTFFNDocumento, -2, -1, -2).addComponent(this.JSPDigitoV, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2)).addGap(26, 26, 26).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoOrg, -2, -1, -2).addComponent(this.JCBMunicipio, -1, 50, 32767).addComponent(this.JTFTelefono, -2, -1, -2).addComponent(this.JTFEmailSC, -2, -1, -2)).addGap(29, 29, 29).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFWeb, -2, -1, -2).addComponent(this.JTFFax, -2, -1, -2).addComponent(this.JTFEmail, -2, -1, -2)).addGap(26, 26, 26).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPresidente, -2, -1, -2).addComponent(this.JTFGerente, -2, -1, -2).addComponent(this.JTFAdministrador, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta_SDC, -2, 56, -2).addComponent(this.JTFRuta_DocCal, -2, 56, -2).addComponent(this.JTFRuta_Img_Grafica, -2, 56, -2)).addGap(84, 84, 84)));
        this.JTPDatos.addTab("DATOS", this.JPIDatos);
        this.JSPResolucionDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Resolución Dian", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPResolucionDian.setHorizontalScrollBarPolicy(31);
        this.JSPResolucionDian.setAutoscrolls(true);
        this.JTPResolucionDian.setFont(new Font("Arial", 1, 12));
        this.JSPResolucionDian.setViewportView(this.JTPResolucionDian);
        this.JSPPie1.setBorder(BorderFactory.createTitledBorder((Border) null, "Pie de Página 1 (Factura Dian)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPie1.setAutoscrolls(true);
        this.JTPPie1.setFont(new Font("Arial", 1, 12));
        this.JSPPie1.setViewportView(this.JTPPie1);
        this.JSPPie2.setBorder(BorderFactory.createTitledBorder((Border) null, "Pie de Página 2 (Factura Dian)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPie2.setAutoscrolls(true);
        this.JTPPie2.setFont(new Font("Arial", 1, 12));
        this.JSPPie2.setViewportView(this.JTPPie2);
        this.JTFFTopeCompra.setBorder(BorderFactory.createTitledBorder((Border) null, "Tope de Compra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTopeCompra.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTopeCompra.setHorizontalAlignment(4);
        this.JTFFTopeCompra.setFont(new Font("Arial", 1, 12));
        this.JTFFTopeCompra.setValue(new Integer(0));
        this.JTFFNCitas.setEditable(false);
        this.JTFFNCitas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Citas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNCitas.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFNCitas.setHorizontalAlignment(4);
        this.JTFFNCitas.setFont(new Font("Arial", 1, 12));
        this.JTFFNCitas.setValue(new Integer(0));
        this.JTFFRRips.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Remision Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFRRips.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFRRips.setHorizontalAlignment(4);
        this.JTFFRRips.setFont(new Font("Arial", 1, 12));
        this.JTFFRRips.setValue(new Integer(0));
        this.JTFFSalarioMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Salario Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSalarioMinimo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFSalarioMinimo.setHorizontalAlignment(4);
        this.JTFFSalarioMinimo.setFont(new Font("Arial", 1, 12));
        this.JTFFSalarioMinimo.setValue(new Integer(0));
        this.JCHFiltroPP.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroPP.setForeground(Color.blue);
        this.JCHFiltroPP.setText("Filtro Programa?");
        this.JCHFiltroPP.setToolTipText("Para realizar filtro de patologia por programa");
        this.JCHFiltroPP.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.6
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JCHFiltroPPActionPerformed(evt);
            }
        });
        this.JSPPie3.setBorder(BorderFactory.createTitledBorder((Border) null, "Pie de Página 1  (Citas)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPie3.setAutoscrolls(true);
        this.JTPPie3.setFont(new Font("Arial", 1, 12));
        this.JSPPie3.setViewportView(this.JTPPie3);
        this.JSPPie4.setBorder(BorderFactory.createTitledBorder((Border) null, "Pie de Página 2  (Citas)", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPie4.setAutoscrolls(true);
        this.JTPPie4.setFont(new Font("Arial", 1, 12));
        this.JSPPie4.setViewportView(this.JTPPie4);
        this.JSPNotaAnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Nota Anticipos", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNotaAnt.setAutoscrolls(true);
        this.JTPNotaAnt.setFont(new Font("Arial", 1, 12));
        this.JSPNotaAnt.setViewportView(this.JTPNotaAnt);
        this.JTFPrefijo.setFont(new Font("Arial", 1, 12));
        this.JTFPrefijo.setBorder(BorderFactory.createTitledBorder((Border) null, "Prefijo Dian", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCheque.setFont(new Font("Arial", 1, 12));
        this.JTFNCheque.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cheque", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsEspecial1.setFont(new Font("Arial", 1, 12));
        this.JCHEsEspecial1.setForeground(Color.blue);
        this.JCHEsEspecial1.setSelected(true);
        this.JCHEsEspecial1.setText("Es Especial?");
        this.JCHEsEspecial1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.7
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JCHEsEspecial1ActionPerformed(evt);
            }
        });
        this.JSPLOrdenSalida.setBorder(BorderFactory.createTitledBorder((Border) null, "Informacion Para Ordenes de Salida", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPLOrdenSalida.setAutoscrolls(true);
        this.JTLOrdenSalida.setFont(new Font("Arial", 1, 12));
        this.JSPLOrdenSalida.setViewportView(this.JTLOrdenSalida);
        this.JSPLCertificacionSoat.setBorder(BorderFactory.createTitledBorder((Border) null, "Informacion Para Historias SOAT", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPLCertificacionSoat.setAutoscrolls(true);
        this.JTLCertificacionSoat.setFont(new Font("Arial", 1, 12));
        this.JSPLCertificacionSoat.setViewportView(this.JTLCertificacionSoat);
        GroupLayout JPIDatosALayout = new GroupLayout(this.JPIDatosA);
        this.JPIDatosA.setLayout(JPIDatosALayout);
        JPIDatosALayout.setHorizontalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPPie2, -2, 446, -2).addGroup(GroupLayout.Alignment.LEADING, JPIDatosALayout.createSequentialGroup().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosALayout.createSequentialGroup().addComponent(this.JTFFTopeCompra, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFRRips, -2, 136, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosALayout.createSequentialGroup().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFNCitas, -2, 136, -2).addComponent(this.JCHEsEspecial1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addComponent(this.JCHFiltroPP).addGap(0, 0, 32767)).addComponent(this.JTFPrefijo)))).addGap(18, 18, 18).addComponent(this.JTFFSalarioMinimo, -2, 144, -2).addGap(16, 16, 16)).addComponent(this.JSPResolucionDian, -2, 446, -2)).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNCheque, -2, 144, -2).addComponent(this.JSPLOrdenSalida, -2, 446, -2))).addGap(18, 18, 18).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPPie1, -2, 435, -2).addComponent(this.JSPNotaAnt, GroupLayout.Alignment.TRAILING, -2, 435, -2).addComponent(this.JSPPie4, GroupLayout.Alignment.TRAILING, -2, 435, -2).addComponent(this.JSPPie3, GroupLayout.Alignment.TRAILING, -2, 435, -2).addComponent(this.JSPLCertificacionSoat, -2, 435, -2)).addContainerGap()));
        JPIDatosALayout.setVerticalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosALayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPPie1, -2, 65, -2).addComponent(this.JSPResolucionDian, -2, 66, -2)).addGap(18, 18, 18).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPPie2).addComponent(this.JSPPie3, -2, 65, -2)).addGap(18, 18, 18).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTopeCompra).addComponent(this.JTFFSalarioMinimo).addComponent(this.JTFFRRips)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNCitas).addComponent(this.JTFPrefijo, -2, 57, -2).addComponent(this.JTFNCheque, -2, 57, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltroPP).addComponent(this.JCHEsEspecial1)).addGap(27, 27, 27).addComponent(this.JSPLOrdenSalida, -2, 61, -2)).addGroup(JPIDatosALayout.createSequentialGroup().addComponent(this.JSPPie4, -2, 67, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNotaAnt, -2, 67, -2).addGap(19, 19, 19).addComponent(this.JSPLCertificacionSoat, -2, 61, -2))).addContainerGap()));
        this.JSPLOrdenSalida.getAccessibleContext().setAccessibleName("");
        this.JTPDatos.addTab("ADICIONAL", this.JPIDatosA);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Logo Institucional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGDatosEmpresa.8
            public void mouseClicked(MouseEvent evt) {
                JIFGDatosEmpresa.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta1.setFont(new Font("Arial", 1, 12));
        this.JTFRuta1.setBorder(BorderFactory.createTitledBorder((Border) null, "Logo Certificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta1.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGDatosEmpresa.9
            public void mouseClicked(MouseEvent evt) {
                JIFGDatosEmpresa.this.JTFRuta1MouseClicked(evt);
            }
        });
        this.JSPNDiasCC.setFont(new Font("Arial", 1, 12));
        this.JSPNDiasCC.setModel(new SpinnerNumberModel(30, 30, 180, 1));
        this.JSPNDiasCC.setToolTipText("N° Días de Cambio de Contraseña");
        this.JSPNDiasCC.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Días", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDireccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDireccion.setAutoscrolls(true);
        this.JTPDireccion.setFont(new Font("Arial", 1, 12));
        this.JSPDireccion.setViewportView(this.JTPDireccion);
        this.JSPDireccion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección 1", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDireccion1.setAutoscrolls(true);
        this.JTPDireccion1.setFont(new Font("Arial", 1, 12));
        this.JSPDireccion1.setViewportView(this.JTPDireccion1);
        this.JSPEsloga.setBorder(BorderFactory.createTitledBorder((Border) null, "Eslogan", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEsloga.setAutoscrolls(true);
        this.JTPEslogan.setFont(new Font("Arial", 1, 12));
        this.JSPEsloga.setViewportView(this.JTPEslogan);
        this.JPIVisualizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Visualización Agenda Medica", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGVisualizacion.add(this.JRBVToda);
        this.JRBVToda.setFont(new Font("Arial", 1, 12));
        this.JRBVToda.setSelected(true);
        this.JRBVToda.setText("Toda");
        this.JRBVToda.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.10
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JRBVTodaActionPerformed(evt);
            }
        });
        this.JBGVisualizacion.add(this.JRBVFacturada);
        this.JRBVFacturada.setFont(new Font("Arial", 1, 12));
        this.JRBVFacturada.setText("Facturadas");
        this.JRBVFacturada.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.11
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JRBVFacturadaActionPerformed(evt);
            }
        });
        GroupLayout JPIVisualizacionLayout = new GroupLayout(this.JPIVisualizacion);
        this.JPIVisualizacion.setLayout(JPIVisualizacionLayout);
        JPIVisualizacionLayout.setHorizontalGroup(JPIVisualizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIVisualizacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBVToda).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBVFacturada).addContainerGap()));
        JPIVisualizacionLayout.setVerticalGroup(JPIVisualizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIVisualizacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIVisualizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBVToda).addComponent(this.JRBVFacturada)).addContainerGap(-1, 32767)));
        this.JTFRutaLogoSS.setFont(new Font("Arial", 1, 12));
        this.JTFRutaLogoSS.setBorder(BorderFactory.createTitledBorder((Border) null, "Logo Super Salud", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaLogoSS.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGDatosEmpresa.12
            public void mouseClicked(MouseEvent evt) {
                JIFGDatosEmpresa.this.JTFRutaLogoSSMouseClicked(evt);
            }
        });
        this.JCHECorreo.setFont(new Font("Arial", 1, 12));
        this.JCHECorreo.setText("Enviar Correo?");
        this.JCHECorreo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.13
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JCHECorreoActionPerformed(evt);
            }
        });
        this.JPIReporteU.setBorder(BorderFactory.createTitledBorder((Border) null, "Reporte a Utilizar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipoR.add(this.JRBR1);
        this.JRBR1.setFont(new Font("Arial", 1, 12));
        this.JRBR1.setSelected(true);
        this.JRBR1.setText("R1");
        this.JRBR1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.14
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JRBR1ActionPerformed(evt);
            }
        });
        this.JBGTipoR.add(this.JRBR2);
        this.JRBR2.setFont(new Font("Arial", 1, 12));
        this.JRBR2.setText("R2");
        this.JRBR2.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.15
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JRBR2ActionPerformed(evt);
            }
        });
        this.JBGTipoR.add(this.JRBR3);
        this.JRBR3.setFont(new Font("Arial", 1, 12));
        this.JRBR3.setText("R3");
        this.JRBR3.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.16
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JRBR3ActionPerformed(evt);
            }
        });
        GroupLayout JPIReporteULayout = new GroupLayout(this.JPIReporteU);
        this.JPIReporteU.setLayout(JPIReporteULayout);
        JPIReporteULayout.setHorizontalGroup(JPIReporteULayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIReporteULayout.createSequentialGroup().addContainerGap().addComponent(this.JRBR1).addGap(18, 18, 18).addComponent(this.JRBR2).addGap(18, 18, 18).addComponent(this.JRBR3).addContainerGap(26, 32767)));
        JPIReporteULayout.setVerticalGroup(JPIReporteULayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIReporteULayout.createSequentialGroup().addContainerGap().addGroup(JPIReporteULayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBR1).addComponent(this.JRBR2).addComponent(this.JRBR3)).addContainerGap(-1, 32767)));
        this.JPIFVisualizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGForma.add(this.JRBFImpresosa);
        this.JRBFImpresosa.setFont(new Font("Arial", 1, 12));
        this.JRBFImpresosa.setText("Impresora");
        this.JRBFImpresosa.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.17
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JRBFImpresosaActionPerformed(evt);
            }
        });
        this.JBGForma.add(this.JRBFVisual);
        this.JRBFVisual.setFont(new Font("Arial", 1, 12));
        this.JRBFVisual.setText("Visual");
        this.JRBFVisual.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.18
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JRBFVisualActionPerformed(evt);
            }
        });
        GroupLayout JPIFVisualizacionLayout = new GroupLayout(this.JPIFVisualizacion);
        this.JPIFVisualizacion.setLayout(JPIFVisualizacionLayout);
        JPIFVisualizacionLayout.setHorizontalGroup(JPIFVisualizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFVisualizacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFImpresosa).addGap(18, 18, 18).addComponent(this.JRBFVisual).addContainerGap(-1, 32767)));
        JPIFVisualizacionLayout.setVerticalGroup(JPIFVisualizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFVisualizacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIFVisualizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFImpresosa).addComponent(this.JRBFVisual)).addContainerGap(-1, 32767)));
        this.JPIFIRCaja.setBorder(BorderFactory.createTitledBorder((Border) null, "Impresión Recibo de Caja", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGFRCaja.add(this.JRBFIRCajaN);
        this.JRBFIRCajaN.setFont(new Font("Arial", 1, 12));
        this.JRBFIRCajaN.setSelected(true);
        this.JRBFIRCajaN.setText("Normal");
        this.JRBFIRCajaN.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.19
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JRBFIRCajaNActionPerformed(evt);
            }
        });
        this.JBGFRCaja.add(this.JRBFIRTirilla);
        this.JRBFIRTirilla.setFont(new Font("Arial", 1, 12));
        this.JRBFIRTirilla.setText("Tirilla");
        this.JRBFIRTirilla.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.20
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JRBFIRTirillaActionPerformed(evt);
            }
        });
        GroupLayout JPIFIRCajaLayout = new GroupLayout(this.JPIFIRCaja);
        this.JPIFIRCaja.setLayout(JPIFIRCajaLayout);
        JPIFIRCajaLayout.setHorizontalGroup(JPIFIRCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFIRCajaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFIRCajaN).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBFIRTirilla).addGap(22, 22, 22)));
        JPIFIRCajaLayout.setVerticalGroup(JPIFIRCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFIRCajaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFIRCajaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFIRCajaN).addComponent(this.JRBFIRTirilla)).addContainerGap(-1, 32767)));
        this.JCHMContable.setFont(new Font("Arial", 1, 12));
        this.JCHMContable.setForeground(Color.blue);
        this.JCHMContable.setSelected(true);
        this.JCHMContable.setText("Movimiento Contable?");
        this.JCHMContable.setToolTipText("Genera movimiento contable de ventas por facturacion");
        this.JCHMContable.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.21
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JCHMContableActionPerformed(evt);
            }
        });
        this.JCHPresupuestal.setFont(new Font("Arial", 1, 12));
        this.JCHPresupuestal.setForeground(Color.blue);
        this.JCHPresupuestal.setSelected(true);
        this.JCHPresupuestal.setText("Movimiento Presupuestal?");
        this.JCHPresupuestal.setToolTipText("Genera movimiento a nivel presupuestal");
        this.JCHPresupuestal.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.22
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JCHPresupuestalActionPerformed(evt);
            }
        });
        this.JTFIdTercero.setFont(new Font("Arial", 1, 12));
        this.JTFIdTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNR256.setFont(new Font("Arial", 1, 12));
        this.JSPNR256.setModel(new SpinnerNumberModel(1, 1, 99, 1));
        this.JSPNR256.setToolTipText("Numero de remision de resolucion 256");
        this.JSPNR256.setBorder(BorderFactory.createTitledBorder((Border) null, "NR256", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaInvima.setFont(new Font("Arial", 1, 12));
        this.JTFRutaInvima.setBorder(BorderFactory.createTitledBorder((Border) null, "Pagina Web de Consulta Invima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaInvima.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGDatosEmpresa.23
            public void mouseClicked(MouseEvent evt) {
                JIFGDatosEmpresa.this.JTFRutaInvimaMouseClicked(evt);
            }
        });
        this.JTFRutaInvima.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.24
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JTFRutaInvimaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosA1Layout = new GroupLayout(this.JPIDatosA1);
        this.JPIDatosA1.setLayout(JPIDatosA1Layout);
        JPIDatosA1Layout.setHorizontalGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosA1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosA1Layout.createSequentialGroup().addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPEsloga, GroupLayout.Alignment.LEADING).addComponent(this.JSPDireccion1, GroupLayout.Alignment.LEADING).addComponent(this.JSPDireccion, GroupLayout.Alignment.LEADING, -2, 429, -2)).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosA1Layout.createSequentialGroup().addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosA1Layout.createSequentialGroup().addComponent(this.JSPNDiasCC, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFIdTercero, -2, 104, -2)).addComponent(this.JPIVisualizacion, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHECorreo).addComponent(this.JSPNR256, -2, 87, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta1, GroupLayout.Alignment.TRAILING, -1, 451, 32767).addComponent(this.JTFRutaLogoSS, GroupLayout.Alignment.TRAILING, -1, 451, 32767).addGroup(JPIDatosA1Layout.createSequentialGroup().addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIReporteU, -1, -1, 32767).addComponent(this.JPIFIRCaja, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFVisualizacion, -1, -1, 32767).addComponent(this.JCHMContable).addComponent(this.JCHPresupuestal))).addComponent(this.JTFRutaInvima, GroupLayout.Alignment.TRAILING, -1, 451, 32767)).addGap(47, 47, 47)));
        JPIDatosA1Layout.setVerticalGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosA1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosA1Layout.createSequentialGroup().addComponent(this.JTFRuta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRutaLogoSS, -2, -1, -2)).addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHECorreo, -2, 32, -2).addGroup(JPIDatosA1Layout.createSequentialGroup().addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNDiasCC, -2, 50, -2).addComponent(this.JTFIdTercero, -2, 50, -2).addComponent(this.JSPNR256, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIVisualizacion, -2, -1, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosA1Layout.createSequentialGroup().addComponent(this.JSPDireccion, -2, 67, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDireccion1, -2, 67, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPEsloga, -2, 67, -2)).addGroup(JPIDatosA1Layout.createSequentialGroup().addComponent(this.JTFRutaInvima, -2, -1, -2).addGap(18, 18, 18).addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIFVisualizacion, -1, -1, 32767).addComponent(this.JPIReporteU, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosA1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosA1Layout.createSequentialGroup().addComponent(this.JCHMContable).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHPresupuestal)).addComponent(this.JPIFIRCaja, -1, -1, 32767)))).addGap(49, 49, 49)));
        this.JTPDatos.addTab("ADICIONAL 1", this.JPIDatosA1);
        this.JPIHistorico.setBorder(BorderFactory.createTitledBorder(""));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGDatosEmpresa.25
            public void mouseClicked(MouseEvent evt) {
                JIFGDatosEmpresa.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleNotas.setViewportView(this.JTBDetalle);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleNotas, -1, 919, 32767));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleNotas, -1, 427, 32767));
        this.JTPDatos.addTab("HISTÓRICO", this.JPIHistorico);
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "SEDE POR EMPRESA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFNombres.setFont(new Font("Arial", 1, 12));
        this.JTFNombres.setToolTipText("");
        this.JTFNombres.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipioS.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipioS.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDireccionS.setFont(new Font("Arial", 1, 12));
        this.JTPDireccionS.setBorder(BorderFactory.createTitledBorder((Border) null, "Direccion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTelefonoS.setFont(new Font("Arial", 1, 12));
        this.JTFTelefonoS.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFaxS.setFont(new Font("Arial", 1, 12));
        this.JTFFaxS.setBorder(BorderFactory.createTitledBorder((Border) null, "Fax", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFaxS.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.26
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JTFFaxSActionPerformed(evt);
            }
        });
        this.JTFEmailS.setFont(new Font("Arial", 1, 12));
        this.JTFEmailS.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEmailS.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.27
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JTFEmailSActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.28
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEPrincipal.setFont(new Font("Arial", 1, 12));
        this.JCHEPrincipal.setText("Principal");
        this.JCHEPrincipal.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.29
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JCHEPrincipalActionPerformed(evt);
            }
        });
        this.JSPDetalleNotas1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleS.setSelectionForeground(Color.red);
        this.JTBDetalleS.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGDatosEmpresa.30
            public void mouseClicked(MouseEvent evt) {
                JIFGDatosEmpresa.this.JTBDetalleSMouseClicked(evt);
            }
        });
        this.JSPDetalleNotas1.setViewportView(this.JTBDetalleS);
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBT_Salir.setText("Resolucion");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGDatosEmpresa.31
            public void actionPerformed(ActionEvent evt) {
                JIFGDatosEmpresa.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Organismo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFMinutos.setFont(new Font("Arial", 1, 12));
        this.JTFMinutos.setBorder(BorderFactory.createTitledBorder((Border) null, "Minutos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoInterfaz.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoInterfaz.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Interfaz", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.JBT_Salir, -1, -1, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.JTFNombres, -2, 394, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMunicipioS, -2, 292, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCodigoInterfaz)).addComponent(this.JSPDetalleNotas1, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTPDireccionS, -1, 324, 32767).addComponent(this.JTFEmailS)).addGap(18, 18, 18).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFTelefonoS, -1, 252, 32767).addComponent(this.JTFCodigo)).addGap(18, 18, 18).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFaxS).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.JTFMinutos, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEPrincipal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(0, 0, 32767))))).addGap(58, 58, 58)))));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombres, -2, 50, -2).addComponent(this.JCBMunicipioS).addComponent(this.JTFCodigoInterfaz, -2, 50, -2)).addGap(15, 15, 15).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTPDireccionS, -2, 50, -2).addComponent(this.JTFTelefonoS, -2, 50, -2).addComponent(this.JTFFaxS, -2, 50, -2)).addGap(15, 15, 15).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFMinutos, GroupLayout.Alignment.TRAILING, -2, 41, -2).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFEmailS, -2, 50, -2).addComponent(this.JTFCodigo, -2, 50, -2).addComponent(this.JCHEPrincipal).addComponent(this.JCHEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addComponent(this.JSPDetalleNotas1, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -2, 35, -2).addGap(15, 15, 15)));
        GroupLayout JDSedesLayout = new GroupLayout(this.JDSedes);
        this.JDSedes.setLayout(JDSedesLayout);
        JDSedesLayout.setHorizontalGroup(JDSedesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 923, 32767).addGroup(JDSedesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JDSedesLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel7, -2, 883, -2).addContainerGap(37, 32767))));
        JDSedesLayout.setVerticalGroup(JDSedesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 432, 32767).addGroup(JDSedesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JDSedesLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel7, -2, -1, -2).addContainerGap(-1, 32767))));
        this.JTPDatos.addTab("SEDES", this.JDSedes);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 928, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroPPActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroPP.isSelected()) {
            this.xFiltroPP = 1;
        } else {
            this.xFiltroPP = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmetodos.getDirectorioExportacion());
            FileNameExtensionFilter Imagenes = new FileNameExtensionFilter("Archivos de Imagenes (bmp, jpg, jpeg, png)", new String[]{"bmp", "jpg", "jpeg", "png"});
            xfilec.addChoosableFileFilter(Imagenes);
            xfilec.setAcceptAllFileFilterUsed(false);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                System.out.println(xfile.getPath());
                this.JTFRuta.setText(xfile.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmetodos.getDirectorioExportacion());
            FileNameExtensionFilter Imagenes = new FileNameExtensionFilter("Archivos de Imagenes (bmp, jpg, jpeg, png)", new String[]{"bmp", "jpg", "jpeg", "png"});
            xfilec.addChoosableFileFilter(Imagenes);
            xfilec.setAcceptAllFileFilterUsed(false);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                System.out.println(xfile.getPath());
                this.JTFRuta1.setText(xfile.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVTodaActionPerformed(ActionEvent evt) {
        this.xvisualizacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVFacturadaActionPerformed(ActionEvent evt) {
        this.xvisualizacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaLogoSSMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmetodos.getDirectorioExportacion());
            FileNameExtensionFilter Imagenes = new FileNameExtensionFilter("Archivos de Imagenes (bmp, jpg, jpeg, png)", new String[]{"bmp", "jpg", "jpeg", "png"});
            xfilec.addChoosableFileFilter(Imagenes);
            xfilec.setAcceptAllFileFilterUsed(false);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                System.out.println(xfile.getPath());
                this.JTFRutaLogoSS.setText(xfile.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHECorreoActionPerformed(ActionEvent evt) {
        if (this.JCHECorreo.isSelected()) {
            this.xecorreo = 1;
        } else {
            this.xecorreo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBR1ActionPerformed(ActionEvent evt) {
        this.xtiporeporte = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBR2ActionPerformed(ActionEvent evt) {
        this.xtiporeporte = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBR3ActionPerformed(ActionEvent evt) {
        this.xtiporeporte = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFImpresosaActionPerformed(ActionEvent evt) {
        this.xfimpresion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFVisualActionPerformed(ActionEvent evt) {
        this.xfimpresion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFIRCajaNActionPerformed(ActionEvent evt) {
        this.xfircaja = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFIRTirillaActionPerformed(ActionEvent evt) {
        this.xfircaja = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta_SDCMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\");
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile1 = xfilec.getSelectedFile();
                this.JTFRuta_SDC.setText(this.xmetodos.mTraerUrlBD(this.xfile1.getAbsolutePath() + "\\"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            this.JCBTipoIdent.setSelectedItem(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            this.JTFFNDocumento.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString());
            this.JSPDigitoV.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString()));
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString());
            this.JTPDireccion.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
            this.JTFTelefono.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString());
            this.JTFFax.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).toString());
            this.JTFEmail.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString());
            this.JTFWeb.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 9).toString());
            this.JTFCodigoOrg.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString());
            this.JCBMunicipio.setSelectedItem(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 11).toString());
            this.JTFFTopeCompra.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 12).toString()));
            this.JTFAdministrador.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 13).toString());
            this.JTFGerente.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 14).toString());
            this.JTFPresidente.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 15).toString());
            this.JTFFNCitas.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 16).toString()));
            this.JTPResolucionDian.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 17).toString());
            this.JTPPie1.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 18).toString());
            this.JTPPie2.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 19).toString());
            this.JTFFRRips.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 20).toString()));
            this.JTFFSalarioMinimo.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 21).toString()));
            this.JCHFiltroPP.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 22).toString()).booleanValue());
            if (this.JCHFiltroPP.isSelected()) {
                this.xesespecial = 0;
            } else {
                this.xesespecial = 1;
            }
            this.JTPPie3.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 23).toString());
            this.JTPPie4.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 24).toString());
            this.JTPNotaAnt.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 25).toString());
            this.JTFPrefijo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 26).toString());
            this.JTFRuta.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 27).toString());
            this.JTFRuta1.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 28).toString());
            this.JSPNDiasCC.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 29).toString()));
            this.JTPDireccion1.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 30).toString());
            this.JTPEslogan.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 31).toString());
            this.JTFNCheque.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 32).toString());
            if (0 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 33).toString()))) {
                this.JRBVToda.setSelected(true);
                this.xvisualizacion = 0;
            } else {
                this.JRBVFacturada.setSelected(true);
                this.xvisualizacion = 1;
            }
            this.JTFRutaLogoSS.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 34).toString());
            this.JCHECorreo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 35).toString()).booleanValue());
            if (this.JCHECorreo.isSelected()) {
                this.xecorreo = 1;
            } else {
                this.xecorreo = 0;
            }
            if (0 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 36).toString()))) {
                this.JRBR1.setSelected(true);
                this.xtiporeporte = 0;
            } else if (1 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 36).toString()))) {
                this.JRBR2.setSelected(true);
                this.xtiporeporte = 1;
            } else if (2 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 36).toString()))) {
                this.JRBR3.setSelected(true);
                this.xtiporeporte = 2;
            }
            if (0 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 37).toString()))) {
                this.JRBFImpresosa.setSelected(true);
                this.xfimpresion = 0;
            } else {
                this.JRBFVisual.setSelected(true);
                this.xfimpresion = 1;
            }
            if (0 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 38).toString()))) {
                this.JRBFIRCajaN.setSelected(true);
                this.xfircaja = 0;
            } else {
                this.JRBFIRTirilla.setSelected(true);
                this.xfircaja = 1;
            }
            this.JTFRuta_SDC.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 39).toString());
            this.JCHMContable.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 40).toString()).booleanValue());
            if (this.JCHMContable.isSelected()) {
                this.xmcontable = 1;
            } else {
                this.xmcontable = 0;
            }
            this.JCHPresupuestal.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 41).toString()).booleanValue());
            if (this.JCHPresupuestal.isSelected()) {
                this.xmpresupuesto = 1;
            } else {
                this.xmpresupuesto = 0;
            }
            this.JTFIdTercero.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 42).toString());
            this.JSPNR256.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 43).toString()));
            this.JCHFiltroPP.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 44).toString()).booleanValue());
            if (this.JCHFiltroPP.isSelected()) {
                this.xFiltroPP = 1;
            } else {
                this.xFiltroPP = 0;
            }
            this.JTFRuta_DocCal.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 45).toString());
            this.JTFRuta_Img_Grafica.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 46).toString());
            this.JTFEmailSC.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 47).toString());
            this.JTLOrdenSalida.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 48).toString());
            this.JTLCertificacionSoat.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 49).toString());
            this.JTFRutaInvima.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 50).toString());
            this.JTPDatos.setSelectedIndex(0);
        }
        mCargarDatosTablaS(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMContableActionPerformed(ActionEvent evt) {
        if (this.JCHMContable.isSelected()) {
            this.xmcontable = 1;
        } else {
            this.xmcontable = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPresupuestalActionPerformed(ActionEvent evt) {
        if (this.JCHPresupuestal.isSelected()) {
            this.xmpresupuesto = 1;
        } else {
            this.xmpresupuesto = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsEspecial1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFaxSActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleSMouseClicked(MouseEvent evt) {
        this.JTFNombres.setText(this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 2).toString());
        this.JCBMunicipioS.setSelectedItem(this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 3).toString());
        this.JTPDireccionS.setText(this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 4).toString());
        this.JTFTelefonoS.setText(this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 5).toString());
        this.JTFFaxS.setText(this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 6).toString());
        this.JTFEmailS.setText(this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 7).toString());
        this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 8).toString()).booleanValue());
        this.JTFCodigoInterfaz.setText(this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 12).toString());
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
        this.xguardar = 1;
        this.xresolucion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        if (this.xresolucion == 1) {
            JDResolucionDian dialogAct = new JDResolucionDian(null, true, this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 0).toString());
            dialogAct.setLocationRelativeTo(this);
            dialogAct.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Seleccione Una Sede", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta_DocCalMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\");
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile2 = xfilec.getSelectedFile();
                this.JTFRuta_DocCal.setText(this.xmetodos.mTraerUrlBD(this.xfile2.getAbsolutePath() + "\\"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta_Img_GraficaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\");
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile3 = xfilec.getSelectedFile();
                this.JTFRuta_Img_Grafica.setText(this.xmetodos.mTraerUrlBD(this.xfile3.getAbsolutePath() + "\\"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTelefonoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEmailSCActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaInvimaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaInvimaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEPrincipalActionPerformed(ActionEvent evt) {
        if (this.JCHEPrincipal.isSelected()) {
            this.xprincipal = 1;
        } else {
            this.xprincipal = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEmailSActionPerformed(ActionEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "TIdentificacion", "Identificacion", "DVerificacion", "Empresa", "Direccion", "Telefono", "Fax", "Correo", "Web", "CodigoOrg", "Municipio", "TopMCompra", "Administrador", "Gerente", "Presidente", "NoCita", "ReslDian", "PiePagina1", "PiePagina2", "NoRemRips", "Salariomin", "EsFpz", "PiePaginaCitas", "PiePaginaCitas1", "NotaAnticipos", "Prefijo", "UrlLogo", "UrlLogoC", "NDiasCambio", "Direccion2", "EsLogan", "Ncheque", "VAgenda", "UrlLogoSuperS", "ECorreo", "TIReporte", "FImpresion", "FIRecibo", "UrlDocumentosU", "MContable", "MPresupusto", "Id_gempresa", "NR256", "FiltroPP", "UrlDocCalidad", "UrlImgGrafica", "EmailSC", "OrdenSalida", "CertificadoSOAT", "UrlInvima"}) { // from class: ParametrizacionN.JIFGDatosEmpresa.32
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class, Boolean.class, Boolean.class, Long.class, Integer.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(45).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(47).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(47).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(48).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(48).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(48).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(49).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(49).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(49).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(50).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(50).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(50).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT g_ips.Id, g_ips.Id_TipoIdentificacion, g_ips.Identificacion, g_ips.DigitoVerificacion, g_ips.Nbre, g_ips.Direccion, g_ips.Telefono, g_ips.Fax, g_ips.Correo, g_ips.Web, g_ips.CodigoOrganismo , g_municipio.Nbre, g_ips.TopeMaximoCompra, g_ips.Administrador, g_ips.Gerente, g_ips.Presidente, g_ips.NoCita, g_ips.IdProfesionalUltimaCita, g_ips.ResolucionDian, g_ips.PiePagina1, g_ips.PiePagina2  , g_ips.PCuentasAuditar, g_ips.NoRemisionRips, g_ips.SalarioMinimo, g_ips.EsFpz, PiePaginaCitas, PiePaginaCitas1, NotaAnticipos, Prefijo, UrlLogo, UrlLogoC, NDiasCambio, g_ips.Direccion2, g_ips.EsLogan , g_ips.NCheque  , g_ips.VAgenda, UrlLogoSuperS, g_ips.ECorreo, g_ips.TIReporte, g_ips.FImpresion, g_ips.FIRecibo, g_ips.Url_DocumentosU, g_ips.MContable, g_ips.MPresupuesto, g_ips.Id_gempresa, g_ips.NoRemision256, g_ips.FiltroPP, g_ips.Url_DocCalidad, g_ips.Url_Img_Grafica, g_ips.`EmailSC`, g_ips.`LOrdenSalida`, g_ips.`LCertificacionSoat`, g_ips.`UrlInvima` FROM g_ips INNER JOIN g_municipio ON (g_ips.Id_Municipio = g_municipio.Id)");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(13)), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(23), n, 20);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(24)), n, 21);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(25)), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(26), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(27), n, 24);
                    this.xmodelo.setValueAt(xrs.getString(28), n, 25);
                    this.xmodelo.setValueAt(xrs.getString(29), n, 26);
                    this.xmodelo.setValueAt(xrs.getString(30), n, 27);
                    this.xmodelo.setValueAt(xrs.getString(31), n, 28);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(32)), n, 29);
                    this.xmodelo.setValueAt(xrs.getString(33), n, 30);
                    this.xmodelo.setValueAt(xrs.getString(34), n, 31);
                    this.xmodelo.setValueAt(xrs.getString(35), n, 32);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(36)), n, 33);
                    this.xmodelo.setValueAt(xrs.getString(37), n, 34);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(38)), n, 35);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(39)), n, 36);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(40)), n, 37);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(41)), n, 38);
                    this.xmodelo.setValueAt(xrs.getString(42), n, 39);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(43)), n, 40);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(44)), n, 41);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(45)), n, 42);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(46)), n, 43);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(47)), n, 44);
                    this.xmodelo.setValueAt(xrs.getString(48), n, 45);
                    this.xmodelo.setValueAt(xrs.getString(49), n, 46);
                    this.xmodelo.setValueAt(xrs.getString(50), n, 47);
                    this.xmodelo.setValueAt(xrs.getString("LOrdenSalida"), n, 48);
                    this.xmodelo.setValueAt(xrs.getString("LCertificacionSoat"), n, 49);
                    this.xmodelo.setValueAt(xrs.getString("UrlInvima"), n, 50);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGDatosEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        if (this.JDSedes.requestFocusInWindow()) {
            mNuevoS();
        } else {
            mNuevoE();
        }
    }

    private void mNuevoE() {
        Principal.txtNo.setText("");
        this.JCBTipoIdent.setSelectedIndex(-1);
        this.JTFFNDocumento.setText("");
        this.JSPDigitoV.setValue(new Integer(0));
        this.JTFNombre.setText("");
        this.JTFCodigoOrg.setText("");
        this.JCBMunicipio.setSelectedIndex(-1);
        this.JTFTelefono.setText("");
        this.JTFFax.setText("");
        this.JTFEmail.setText("");
        this.JTFWeb.setText("");
        this.JTFPresidente.setText("");
        this.JTFGerente.setText("");
        this.JTFAdministrador.setText("");
        this.JTFRuta_SDC.setText("");
        this.JTFRuta_DocCal.setText("");
        this.JTFRuta_Img_Grafica.setText("");
        this.JTPResolucionDian.setText("");
        this.JTPPie1.setText("");
        this.JTPPie2.setText("");
        this.JTPPie3.setText("");
        this.JTFFTopeCompra.setText("");
        this.JTFFRRips.setText("");
        this.JTFFSalarioMinimo.setText("");
        this.JTPPie4.setText("");
        this.JTFFNCitas.setValue(0);
        this.JTFPrefijo.setText("");
        this.JTFNCheque.setText("");
        this.JTPNotaAnt.setText("");
        this.JCHFiltroPP.setSelected(false);
        this.xesespecial = 1;
        this.JSPNDiasCC.setValue(new Integer(0));
        this.JCHECorreo.setSelected(false);
        this.xecorreo = 0;
        this.JRBVToda.setSelected(true);
        this.xvisualizacion = 0;
        this.JRBR1.setSelected(true);
        this.xtiporeporte = 0;
        this.JRBFImpresosa.setSelected(true);
        this.xfimpresion = 0;
        this.JRBFIRCajaN.setSelected(true);
        this.xfircaja = 0;
        this.JCHMContable.setSelected(false);
        this.JCHPresupuestal.setSelected(false);
        this.xmcontable = 0;
        this.xmpresupuesto = 0;
        this.JCHFiltroPP.setSelected(false);
        this.xFiltroPP = 0;
        this.JTPDireccion.setText("");
        this.JTPDireccion1.setText("");
        this.JTFRuta.setText("");
        this.JTFRuta1.setText("");
        this.JTFRutaLogoSS.setText("");
        this.JTPEslogan.setText("");
        this.JTFIdTercero.setText("");
        this.JSPNR256.setValue(new Integer(1));
        mCargarDatosTabla();
        this.JTFNombres.setText("");
        this.JCBMunicipioS.setSelectedIndex(-1);
        this.JTPDireccionS.setText("");
        this.JTFTelefonoS.setText("");
        this.JTFFaxS.setText("");
        this.JTFEmailS.setText("");
        this.JTFEmailSC.setText("");
        this.xguardar = 0;
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xprincipal = 1;
        this.xresolucion = 0;
        this.JTLOrdenSalida.setText("");
        this.JTLCertificacionSoat.setText("");
        this.JTFRutaInvima.setText("");
        mCrearModeloDatosS();
    }

    private void mGrabarE() {
        String sql;
        if (this.JCBTipoIdent.getSelectedIndex() != -1) {
            if (!this.JTFFNDocumento.getText().isEmpty()) {
                if (!this.JTFNombre.getText().isEmpty()) {
                    if (!this.JTFCodigoOrg.getText().isEmpty()) {
                        if (this.JCBMunicipio.getSelectedIndex() != -1) {
                            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                if (Principal.txtNo.getText().isEmpty()) {
                                    sql = "Insert into g_ips(Id_TipoIdentificacion, Identificacion, DigitoVerificacion, Nbre, Direccion, Direccion2, Eslogan, Telefono, Fax, Correo, Web, CodigoOrganismo, Id_Municipio  , TopeMaximoCompra, Administrador, Gerente, Presidente, NoCita, Prefijo, ResolucionDian, PiePagina1, PiePagina2, NoRemisionRips, SalarioMinimo, PiePaginaCitas, PiePaginaCitas1, EsFpz, NotaAnticipos, UrlLogo, UrlLogoC,UrlLogoSuperS, NDiasCambio, NCheque, VAgenda, ECorreo, TIReporte, FImpresion, FIRecibo, Url_DocumentosU, MContable, MPresupuesto,Id_gempresa, NoRemision256, FiltroPP, Url_DocCalidad, Url_Img_Grafica, EmailSC, LOrdenSalida, LCertificacionSoat, UrlInvima, Fecha, UsuarioS)  values ('" + this.xidtipodoc[this.JCBTipoIdent.getSelectedIndex()] + "','" + this.JTFFNDocumento.getText() + "','" + this.JSPDigitoV.getValue() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTPDireccion.getText() + "','" + this.JTPDireccion1.getText() + "','" + this.JTPEslogan.getText() + "','" + this.JTFTelefono.getText() + "','" + this.JTFFax.getText() + "','" + this.JTFEmail.getText() + "','" + this.JTFWeb.getText() + "','" + this.JTFCodigoOrg.getText() + "','" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "','" + this.JTFFTopeCompra.getValue() + "','" + this.JTFAdministrador.getText() + "','" + this.JTFGerente.getText() + "','" + this.JTFPresidente.getText() + "','" + this.JTFFNCitas.getValue() + "','" + this.JTFPrefijo.getText() + "','" + this.JTPResolucionDian.getText() + "','" + this.JTPPie1.getText() + "','" + this.JTPPie2.getText() + "','" + this.JTFFRRips.getValue() + "','" + this.JTFFSalarioMinimo.getValue() + "','" + this.JTPPie3.getText() + "','" + this.JTPPie4.getText() + "','" + this.xesespecial + "','" + this.JTPNotaAnt.getText() + "','" + this.JTFRuta.getText() + "','" + this.JTFRuta1.getText() + "','" + this.JTFRutaLogoSS.getText() + "','" + this.JSPNDiasCC.getValue() + "','" + this.JTFNCheque.getText() + "','" + this.xvisualizacion + "','" + this.xecorreo + "','" + this.xtiporeporte + "','" + this.xfimpresion + "','" + this.xfircaja + "','" + this.JTFRuta_SDC.getText() + "','" + this.xmcontable + "','" + this.xmpresupuesto + "','" + this.JTFIdTercero.getText() + "','" + this.JSPNR256.getValue() + "','" + this.xFiltroPP + "','" + this.JTFRuta_DocCal.getText() + "','" + this.JTFRuta_Img_Grafica.getText() + "','" + this.JTFEmailSC.getText() + "','" + this.JTLOrdenSalida.getText() + "','" + this.JTLCertificacionSoat.getText() + "','" + this.JTFRutaInvima.getText() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                } else {
                                    sql = "update g_ips set Id_TipoIdentificacion='" + this.xidtipodoc[this.JCBTipoIdent.getSelectedIndex()] + "',Identificacion='" + this.JTFFNDocumento.getText() + "', DigitoVerificacion='" + this.JSPDigitoV.getValue() + "', Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Direccion='" + this.JTPDireccion.getText() + "', Direccion2='" + this.JTPDireccion1.getText() + "', Eslogan='" + this.JTPEslogan.getText() + "', Telefono='" + this.JTFTelefono.getText() + "', Fax='" + this.JTFFax.getText() + "', Correo='" + this.JTFEmail.getText() + "', Web='" + this.JTFWeb.getText() + "', CodigoOrganismo='" + this.JTFCodigoOrg.getText() + "', Id_Municipio='" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "',TopeMaximoCompra='" + this.JTFFTopeCompra.getValue() + "', Administrador='" + this.JTFAdministrador.getText() + "', Gerente='" + this.JTFGerente.getText() + "', Presidente='" + this.JTFPresidente.getText() + "', NoCita='" + this.JTFFNCitas.getValue() + "', Prefijo='" + this.JTFPrefijo.getText() + "', ResolucionDian='" + this.JTPResolucionDian.getText() + "', PiePagina1='" + this.JTPPie1.getText() + "', PiePagina2='" + this.JTPPie2.getText() + "', NoRemisionRips='" + this.JTFFRRips.getValue() + "', SalarioMinimo='" + this.JTFFSalarioMinimo.getValue() + "', PiePaginaCitas='" + this.JTPPie3.getText() + "', PiePaginaCitas1='" + this.JTPPie4.getText() + "', EsFpz='" + this.xesespecial + "', NotaAnticipos='" + this.JTPNotaAnt.getText() + "', UrlLogo='" + this.xmetodos.mTraerUrlBD(this.JTFRuta.getText()) + "', UrlLogoC='" + this.xmetodos.mTraerUrlBD(this.JTFRuta1.getText()) + "', UrlLogoSuperS='" + this.xmetodos.mTraerUrlBD(this.JTFRutaLogoSS.getText()) + "', NDiasCambio='" + this.JSPNDiasCC.getValue() + "', NCheque='" + this.JTFNCheque.getText() + "', VAgenda='" + this.xvisualizacion + "', ECorreo='" + this.xecorreo + "', TIReporte='" + this.xtiporeporte + "', FImpresion='" + this.xfimpresion + "', FIRecibo='" + this.xfircaja + "', Url_DocumentosU='" + this.xmetodos.mTraerUrlBD(this.JTFRuta_SDC.getText()) + "', MContable='" + this.xmcontable + "', MPresupuesto='" + this.xmpresupuesto + "', Id_gempresa='" + this.JTFIdTercero.getText() + "', NoRemision256='" + this.JSPNR256.getValue() + "', FiltroPP='" + this.xFiltroPP + "', Url_DocCalidad='" + this.xmetodos.mTraerUrlBD(this.JTFRuta_DocCal.getText()) + "', Url_Img_Grafica='" + this.xmetodos.mTraerUrlBD(this.JTFRuta_Img_Grafica.getText()) + "', EmailSC='" + this.JTFEmailSC.getText() + "', LOrdenSalida='" + this.JTLOrdenSalida.getText() + "', LCertificacionSoat='" + this.JTLCertificacionSoat.getText() + "', UrlInvima='" + this.JTFRutaInvima.getText() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "'  WHERE  Id='" + Principal.txtNo.getText() + "'";
                                }
                                this.xconsulta.ejecutarSQL(sql);
                                this.xconsulta.cerrarConexionBd();
                                mCargarDatosTabla();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un municipio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBMunicipio.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El código del organismo no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFCodigoOrg.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La razón social no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNombre.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El documento no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFNDocumento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoIdent.requestFocus();
    }

    private void mBuscarDatosBd() {
        ResultSet xrs = this.xconsulta.traerRs("SELECT g_ips.Id, g_ips.Id_TipoIdentificacion, g_ips.Identificacion, g_ips.DigitoVerificacion, g_ips.Nbre, g_ips.Direccion, g_ips.Telefono, g_ips.Fax, g_ips.Correo, g_ips.Web, g_ips.CodigoOrganismo , g_municipio.Nbre, g_ips.TopeMaximoCompra, g_ips.Administrador, g_ips.Gerente, g_ips.Presidente, g_ips.NoCita, g_ips.IdProfesionalUltimaCita, g_ips.ResolucionDian, g_ips.PiePagina1, g_ips.PiePagina2  , g_ips.PCuentasAuditar, g_ips.NoRemisionRips, g_ips.SalarioMinimo, g_ips.EsFpz, PiePaginaCitas, PiePaginaCitas1, NotaAnticipos, Prefijo, UrlLogo, UrlLogoC, NDiasCambio, g_ips.Direccion2, g_ips.EsLogan, g_ips.NCheque  , g_ips.VAgenda, UrlLogoSuperS, g_ips.ECorreo, g_ips.TIReporte, g_ips.FImpresion, g_ips.FIRecibo, g_ips.Url_DocumentosU, g_ips.MContable, g_ips.MPresupuesto, g_ips.Id_gempresa, g_ips.NoRemision256, g_ips.FiltroPP, g_ips.Url_DocCalidad, g_ips.Url_Img_Grafica, g_ips.EmailSC, g_ips.LOrdenSalida, g_ips.LCertificacionSoat, g_ips.UrlInvima  FROM g_ips INNER JOIN g_municipio ON (g_ips.Id_Municipio = g_municipio.Id)");
        try {
            if (xrs.next()) {
                xrs.first();
                Principal.txtNo.setText(xrs.getString(1));
                this.JCBTipoIdent.setSelectedItem(xrs.getString(2));
                this.JTFFNDocumento.setText(xrs.getString(3));
                this.JSPDigitoV.setValue(Integer.valueOf(xrs.getInt(4)));
                this.JTFNombre.setText(xrs.getString(5));
                this.JTPDireccion.setText(xrs.getString(6));
                this.JTFTelefono.setText(xrs.getString(7));
                this.JTFFax.setText(xrs.getString(8));
                this.JTFEmail.setText(xrs.getString(9));
                this.JTFWeb.setText(xrs.getString(10));
                this.JTFCodigoOrg.setText(xrs.getString(11));
                this.JCBMunicipio.setSelectedItem(xrs.getString(12));
                this.JTFFTopeCompra.setValue(Double.valueOf(xrs.getDouble(13)));
                this.JTFAdministrador.setText(xrs.getString(14));
                this.JTFGerente.setText(xrs.getString(15));
                this.JTFPresidente.setText(xrs.getString(16));
                this.JTFFNCitas.setValue(Double.valueOf(xrs.getDouble(17)));
                this.JTPResolucionDian.setText(xrs.getString(19));
                this.JTPPie1.setText(xrs.getString(20));
                this.JTPPie2.setText(xrs.getString(21));
                this.JTFFRRips.setValue(Double.valueOf(xrs.getDouble(23)));
                this.JTFFSalarioMinimo.setValue(Double.valueOf(xrs.getDouble(24)));
                this.JCHFiltroPP.setSelected(!xrs.getBoolean(25));
                if (this.JCHFiltroPP.isSelected()) {
                    this.xesespecial = 0;
                } else {
                    this.xesespecial = 1;
                }
                this.JTPPie3.setText(xrs.getString(26));
                this.JTPPie4.setText(xrs.getString(27));
                this.JTPNotaAnt.setText(xrs.getString(28));
                this.JTFPrefijo.setText(xrs.getString(29));
                this.JTFRuta.setText(xrs.getString(30));
                this.JTFRuta1.setText(xrs.getString(31));
                this.JSPNDiasCC.setValue(Long.valueOf(xrs.getLong(32)));
                this.JTPDireccion1.setText(xrs.getString(33));
                this.JTPEslogan.setText(xrs.getString(34));
                this.JTFNCheque.setText(xrs.getString(35));
                if (xrs.getInt(36) == 0) {
                    this.JRBVToda.setSelected(true);
                    this.xvisualizacion = 0;
                } else {
                    this.JRBVFacturada.setSelected(true);
                    this.xvisualizacion = 1;
                }
                this.JTFRutaLogoSS.setText(xrs.getString(37));
                this.JCHECorreo.setSelected(xrs.getBoolean(38));
                if (this.JCHECorreo.isSelected()) {
                    this.xecorreo = 1;
                } else {
                    this.xecorreo = 0;
                }
                if (xrs.getInt(39) == 0) {
                    this.JRBR1.setSelected(true);
                    this.xtiporeporte = 0;
                } else if (xrs.getInt(39) == 1) {
                    this.JRBR2.setSelected(true);
                    this.xtiporeporte = 1;
                } else if (xrs.getInt(39) == 2) {
                    this.JRBR3.setSelected(true);
                    this.xtiporeporte = 2;
                }
                if (xrs.getInt(40) == 0) {
                    this.JRBFImpresosa.setSelected(true);
                    this.xfimpresion = 0;
                } else {
                    this.JRBFVisual.setSelected(true);
                    this.xfimpresion = 1;
                }
                if (xrs.getInt(41) == 0) {
                    this.JRBFIRCajaN.setSelected(true);
                    this.xfircaja = 0;
                } else {
                    this.JRBFIRTirilla.setSelected(true);
                    this.xfircaja = 1;
                }
                this.JTFRuta_SDC.setText(this.xmetodos.mTraerUrlBD(xrs.getString("Url_DocumentosU")));
                if (xrs.getInt(43) == 0) {
                    this.JCHMContable.setSelected(false);
                    this.xmcontable = 0;
                } else {
                    this.JCHMContable.setSelected(true);
                    this.xmcontable = 1;
                }
                if (xrs.getInt(44) == 0) {
                    this.JCHPresupuestal.setSelected(false);
                    this.xmpresupuesto = 0;
                } else {
                    this.JCHPresupuestal.setSelected(true);
                    this.xmpresupuesto = 1;
                }
                this.JTFIdTercero.setText(xrs.getString(45));
                this.JSPNR256.setValue(Integer.valueOf(xrs.getInt(46)));
                if (xrs.getInt(47) == 0) {
                    this.JCHFiltroPP.setSelected(false);
                    this.xFiltroPP = 0;
                } else {
                    this.JCHFiltroPP.setSelected(true);
                    this.xFiltroPP = 1;
                }
                this.JTFRuta_DocCal.setText(this.xmetodos.mTraerUrlBD(xrs.getString("Url_DocCalidad")));
                this.JTFRuta_Img_Grafica.setText(this.xmetodos.mTraerUrlBD(xrs.getString("Url_Img_Grafica")));
                this.JTFEmailSC.setText(xrs.getString("EmailSC"));
                this.JTLOrdenSalida.setText(xrs.getString("LOrdenSalida"));
                this.JTLCertificacionSoat.setText(xrs.getString("LCertificacionSoat"));
                this.JTFRutaInvima.setText(xrs.getString("UrlInvima"));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGDatosEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (this.JDSedes.requestFocusInWindow()) {
            mGrabarS();
        } else {
            mGrabarE();
        }
    }

    public void mNuevoS() {
        this.JTFNombres.setText("");
        this.JCBMunicipioS.setSelectedIndex(-1);
        this.JTPDireccionS.setText("");
        this.JTFTelefonoS.setText("");
        this.JTFFaxS.setText("");
        this.JTFEmailS.setText("");
        this.JTFCodigoInterfaz.setText("");
        this.xguardar = 0;
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JCHEPrincipal.setSelected(true);
        this.xprincipal = 1;
        this.xresolucion = 0;
    }

    private void mGrabarS() {
        String sql;
        if (this.JCBMunicipioS.getSelectedIndex() != -1) {
            if (!this.JTFNombres.getText().isEmpty()) {
                if (!this.JTPDireccionS.getText().isEmpty()) {
                    if (!this.JTFTelefonoS.getText().isEmpty()) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            if (this.xguardar == 0) {
                                sql = "INSERT INTO g_sedes (Id_Ips, Nbre,Id_Municipio, Direccion, Telefono, Fax, Correo, EsPrincipal, CodigoOrganismo, minutos,codigoInterfaz,  Estado, UsuarioS) VALUES ('" + Principal.txtNo.getText() + "','" + this.JTFNombres.getText() + "','" + this.xidmunicipios[this.JCBMunicipioS.getSelectedIndex()] + "','" + this.JTPDireccionS.getText().toUpperCase() + "','" + this.JTFTelefonoS.getText() + "','" + this.JTFFaxS.getText() + "','" + this.JTFEmailS.getText() + "','" + this.xprincipal + "','" + this.JTFCodigo.getText() + "','" + this.JTFMinutos.getValue() + "','" + this.JTFCodigoInterfaz.getText() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                            } else {
                                sql = "UPDATE g_sedes  SET  Nbre = '" + this.JTFNombres.getText() + "',  Id_Municipio = '" + this.xidmunicipios[this.JCBMunicipioS.getSelectedIndex()] + "',  Direccion = '" + this.JTPDireccionS.getText().toUpperCase() + "',  Telefono = '" + this.JTFTelefonoS.getText() + "',  Fax = '" + this.JTFFaxS.getText() + "',  Correo = '" + this.JTFEmailS.getText() + "',  EsPrincipal = '" + this.xprincipal + "',  CodigoOrganismo = '" + this.JTFCodigo.getText() + "',  Minutos = '" + this.JTFMinutos.getValue() + "',  codigoInterfaz = '" + this.JTFCodigoInterfaz.getText() + "',  Estado = '" + this.xestado + "',  UsuarioS = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'WHERE Id = '" + this.xmodelos.getValueAt(this.JTBDetalleS.getSelectedRow(), 0).toString() + "';";
                            }
                            this.xconsulta.ejecutarSQL(sql);
                            this.xconsulta.cerrarConexionBd();
                            mNuevoS();
                            mCargarDatosTablaS(Principal.txtNo.getText());
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe digitar Telefono Sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFTelefonoS.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar Direccion Sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPDireccionS.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar Nombre Sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombres.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe Elejir Un Muicipio Sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBMunicipioS.requestFocus();
    }

    private void mCargarDatosTablaS(String xid) {
        try {
            mCrearModeloDatosS();
            String xsql = "SELECT      g_sedes.Id      , g_ips.Id AS IdE      , g_sedes.Nbre      , g_municipio.Nbre AS m      , g_sedes.Direccion      , g_sedes.Telefono      , g_sedes.Fax      , g_sedes.Correo      , g_sedes.Estado      , g_sedes.UsuarioS      , g_sedes.CodigoOrganismo      , g_sedes.minutos      , g_sedes.codigoInterfaz  FROM      g_sedes      LEFT JOIN g_municipio           ON (g_sedes.Id_Municipio = g_municipio.Id)      LEFT JOIN g_ips           ON (g_ips.Id_Municipio = g_municipio.Id) AND (g_sedes.Id_Ips = g_ips.Id)  WHERE (g_sedes.Id_Ips ='" + xid + "');";
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelos.addRow(this.xdatoSS);
                    this.xmodelos.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelos.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelos.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelos.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelos.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelos.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelos.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelos.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelos.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    this.xmodelos.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelos.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelos.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelos.setValueAt(xrs.getString(13), n, 12);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGDatosEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosS() {
        this.xmodelos = new DefaultTableModel(new Object[0], new String[]{"Id", "Idempresa", "Sede", "Municipio", "Direccion", "Telefono", "Fax", "Correo", "Estado", "Id_UsuarioS", "CodigoOrganismo", "minutos", "CodigoInterfaz"}) { // from class: ParametrizacionN.JIFGDatosEmpresa.33
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleS.setModel(this.xmodelos);
        JTable jTable = this.JTBDetalleS;
        JTable jTable2 = this.JTBDetalleS;
        jTable.setAutoResizeMode(0);
        this.JTBDetalleS.doLayout();
        this.JTBDetalleS.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalleS.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalleS.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalleS.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalleS.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalleS.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalleS.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTBDetalleS.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTBDetalleS.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTBDetalleS.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTBDetalleS.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTBDetalleS.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTBDetalleS.getColumnModel().getColumn(12).setPreferredWidth(100);
    }
}
