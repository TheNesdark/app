package Facturacion;

import Acceso.Principal;
import Odontologia.JPAnalisiOclusal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.AEventoecat;
import com.genoma.plus.jpa.entities.AEventoecatSoportedoc;
import com.genoma.plus.jpa.entities.GTipoDocumentoSoporte;
import com.genoma.plus.jpa.service.AEventoecatSoportedocService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
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
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPEventoECat.class */
public class JPEventoECat extends JDialog {
    Metodos xmt;
    ConsultasMySQL xct;
    private String[] xidDpto;
    private String[] xidMpio;
    private String[] xtipoEvento;
    private String[] xidEstadoSeg;
    private String[] xidMarcaVeh;
    private String[] xidtipoVeh;
    private String[] xidAseguradora;
    private String[] xidTDocProp;
    private String[] xidTDocCond;
    private String[] xidTDocProp2;
    private String[] xidTDocProp3;
    private String[] xidDptoProp;
    private String[] xidMpioProp;
    private String[] xidDptoCond;
    private String[] xidMpioCond;
    private String[] xidSoporteDoc;
    private String[] xidTipVehTrans;
    private String[] xidDptoFTrans1;
    private String[] xidMPioFtrans1;
    private String[] xidDptoFTrans2;
    private String[] xidMPioFtrans2;
    private String[] xidTDocFTrans;
    private String[] xidTerceroRecibe;
    private String[] xidtTipoServicio;
    private boolean xlleno;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodeloPersona;
    private DefaultTableModel xmodeloSoporte;
    private DefaultTableModel xmodeloPersonaF;
    private DefaultTableModel xmodeloHistoricoF;
    private Object[] xdato;
    private String xzona;
    private String xzonaTrans;
    private String xzonaFutrans;
    private String xevento;
    private long xAutoridad;
    private long xidCausaExt;
    private long xidCondVict;
    private String xidPersona;
    private String xIngreso;
    private String xSql;
    private String numeroRadicado;
    private String xdoc1;
    private String xdoc2;
    private String agotamiento;
    private File xfile;
    private Object[][] validarLimite;
    private JTextField[] jtextfield;
    private Boolean encotrado;
    private File directorio;
    private final AEventoecatSoportedocService aEventoecatSoportedocService;
    private JButton JBActualizar;
    private JButton JBBuscar;
    private ButtonGroup JBGAutoridad;
    private ButtonGroup JBGFiltroBusq;
    private ButtonGroup JBGZona;
    private ButtonGroup JBGZonaFutran;
    private ButtonGroup JBGZonaTrans;
    private JButton JBGrabar;
    private JButton JBGrabarFutran;
    private JButton JBGrabarTrans;
    private JButton JBSalir;
    private JButton JBSubirArchivo;
    private JComboBox JCBAseguradora;
    private JComboBox JCBDpto;
    private JComboBox JCBDptoCond;
    private JComboBox JCBDptoProp;
    private JComboBox JCBDpto_futran;
    private JComboBox JCBDpto_futran2;
    private JComboBox JCBEstadoSegVeh;
    private JComboBox JCBMarcVeh;
    private JComboBox JCBMpio;
    private JComboBox JCBMpioCond;
    private JComboBox JCBMpioProp;
    private JComboBox JCBMpio_futran;
    private JComboBox JCBMpio_futran2;
    private JComboBox JCBTercero;
    private JComboBox JCBTipDocCond;
    private JComboBox JCBTipDocFutran;
    private JComboBox JCBTipDocP2;
    private JComboBox JCBTipDocP3;
    private JComboBox JCBTipDocPropietario;
    private JComboBox JCBTipServicio;
    private JComboBox JCBTipVeh;
    private JComboBox JCBTipVehTrans;
    private JComboBox JCBTipoDocumentoSoporte;
    private JComboBox JCBTipoEvento;
    private JCheckBox JCHAgotamiento;
    private JCheckBox JCHConductor;
    private JCheckBox JCHDatosUsuario;
    public JDateChooser JDFecha;
    public JDateChooser JDFechaFinPol;
    public JDateChooser JDFechaFurt;
    public JDateChooser JDFechaInicioPol;
    private JLabel JLB_Evento;
    private JLabel JLB_NumeroCon;
    private JPanel JPAccidente;
    private JPanel JPConductor;
    private JPanel JPDatos;
    private JPanel JPDocumentoSoportes;
    private JPanel JPFurtran;
    private JPanel JPHistorico;
    private JPanel JPMovilizacion;
    private JPanel JPPropietario;
    private JPanel JPRecibe;
    private JPanel JPTransporteVeh;
    private JPanel JPVehi2;
    private JPanel JPVehi3;
    private JPanel JPVictima;
    private JPanel JPZona;
    private JPanel JPZona1;
    private JPanel JPZona2;
    private JRadioButton JRBNo;
    private JRadioButton JRBRural2;
    private JRadioButton JRBRuralz;
    private JRadioButton JRBRuralz1;
    private JRadioButton JRBSi;
    private JRadioButton JRBUrbana;
    private JRadioButton JRBUrbana1;
    private JRadioButton JRBUrbana2;
    private JScrollPane JSPDocSoporte;
    private JScrollPane JSPDocSoporte1;
    private JScrollPane JSPDocSoporte2;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPPersonasRegsitradas;
    private JTextArea JTADescripcion;
    private JTextField JTApellido1;
    private JTextField JTApellido1Cond;
    private JTextField JTApellido1Prop;
    private JTextField JTApellido2;
    private JTextField JTApellido2Cond;
    private JTextField JTApellido2Prop;
    private JRadioButton JTBDocumento;
    private JRadioButton JTBDocumento1;
    private JRadioButton JTBPlaca;
    private JTextField JTCodHabilitacion;
    private JTextField JTDesdeTrans;
    private JTextField JTDireccion;
    private JTextField JTDireccionRecogida;
    private JTable JTDocSoporte;
    private JTextField JTFDireccion;
    public JFormattedTextField JTFFHora;
    private JTextField JTFFuncionarioR;
    private JTextField JTFNoDocuFuncionario;
    private JTextField JTFNoPoliza;
    private JTextField JTFPlaca;
    private JTextField JTFPlacaBusqueda;
    private JTextField JTFPlacaTrans;
    private JTextField JTFPlacaVeh2;
    private JTextField JTFPlacaVeh3;
    private JTextField JTFRuta;
    private JTextField JTHastaTrans;
    private JTable JTHistorico;
    private JTextField JTNEmpresa;
    private JTextField JTNoDirecionCond;
    private JTextField JTNoDirecionProp;
    private JTextField JTNoDocBusqueda;
    private JTextField JTNoDocCond;
    private JTextField JTNoDocP2;
    private JTextField JTNoDocP3;
    private JTextField JTNoDocPropietario;
    private JTextField JTNoDocuFutran;
    private JTextField JTNoTelCond;
    private JTextField JTNoTelProp;
    private JTextField JTNom1Cond;
    private JTextField JTNom1Prop;
    private JTextField JTNom2Cond;
    private JTextField JTNom2Prop;
    private JTextField JTNombre1;
    private JTextField JTNombre2;
    private JTextField JTOtroServicio;
    private JTabbedPane JTPEventos;
    private JTabbedPane JTPUbicacion;
    private JTable JTPerFutran;
    private JTable JTPerFutranHistorico;
    private JTable JTPersonas;
    private JTextField JTPlaca;
    private JTextField JTSiras;
    private JTextField JTTel;
    private JCheckBox jCheckBox1;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;

    public JPEventoECat(Frame parent, boolean modal, String xidPersona, long xidCausaExt, long xidCondVict, String xIngreso) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xlleno = false;
        this.xzona = "U";
        this.xzonaTrans = "U";
        this.xzonaFutrans = "U";
        this.xevento = "";
        this.xAutoridad = 0L;
        this.xidCausaExt = 0L;
        this.xidCondVict = 0L;
        this.xidPersona = "";
        this.xIngreso = "";
        this.numeroRadicado = "";
        this.xdoc1 = "";
        this.xdoc2 = "";
        this.agotamiento = "0";
        this.validarLimite = new Object[25][3];
        this.jtextfield = new JTextField[25];
        this.encotrado = false;
        this.aEventoecatSoportedocService = (AEventoecatSoportedocService) Principal.contexto.getBean(AEventoecatSoportedocService.class);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("REGISTRO DE EVENTO");
        setLocationRelativeTo(null);
        this.xidPersona = xidPersona;
        this.xidCausaExt = xidCausaExt;
        this.xidCondVict = xidCondVict;
        this.xIngreso = xIngreso;
        mConsultarFechayHoraIngreso();
        this.JDFechaInicioPol.setDate(this.xmt.getFechaActual());
        this.JDFechaFinPol.setDate(this.xmt.getFechaActual());
        mLlenarCombos();
        this.JTNEmpresa.setText(Principal.informacionIps.getNombreIps());
        this.JTCodHabilitacion.setText(Principal.informacionIps.getCodigoOrganismo());
        this.JTDireccion.setText(Principal.informacionIps.getDireccion1Ips());
        this.JTTel.setText(Principal.informacionIps.getTelefonoIps());
        this.JCBDpto_futran.setSelectedItem(Principal.informacionIps.getNombreDepartamentoIps());
        this.JCBMpio_futran.setSelectedItem(Principal.informacionIps.getNombreMunicipioIps());
        this.JLB_Evento.setVisible(true);
        if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            this.JTPEventos.remove(2);
            this.JCBTipDocFutran.setSelectedItem("NO APLICA");
            this.JCBTipServicio.setSelectedItem("Ambulancia Básica");
            this.JCBTipoEvento.setSelectedItem("Accidente de Tránsito");
        } else {
            this.JTPEventos.setEnabledAt(2, false);
        }
        mBuscarNumeroRadicado();
        this.directorio = new File(this.xmt.mRutaSoporte("JPEventoECat"));
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v450, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v56, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v581, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v634, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGZona = new ButtonGroup();
        this.JBGAutoridad = new ButtonGroup();
        this.JBGZonaTrans = new ButtonGroup();
        this.JBGZonaFutran = new ButtonGroup();
        this.JBGFiltroBusq = new ButtonGroup();
        this.jCheckBox1 = new JCheckBox();
        this.JTPEventos = new JTabbedPane();
        this.JPDatos = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBTipoEvento = new JComboBox();
        this.JCBDpto = new JComboBox();
        this.JCBMpio = new JComboBox();
        this.JPZona = new JPanel();
        this.JRBUrbana = new JRadioButton();
        this.JRBRuralz = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTADescripcion = new JTextArea();
        this.JTFDireccion = new JTextField();
        this.JSPPersonasRegsitradas = new JScrollPane();
        this.JTPersonas = new JTable();
        this.JPDocumentoSoportes = new JPanel();
        this.JTFRuta = new JTextField();
        this.JCBTipoDocumentoSoporte = new JComboBox();
        this.JBSubirArchivo = new JButton();
        this.JSPDocSoporte = new JScrollPane();
        this.JTDocSoporte = new JTable();
        this.JLB_NumeroCon = new JLabel();
        this.JPAccidente = new JPanel();
        this.JPVehi2 = new JPanel();
        this.JTFPlacaVeh2 = new JTextField();
        this.JCBTipDocP2 = new JComboBox();
        this.JTNoDocP2 = new JTextField();
        this.JPVehi3 = new JPanel();
        this.JTFPlacaVeh3 = new JTextField();
        this.JCBTipDocP3 = new JComboBox();
        this.JTNoDocP3 = new JTextField();
        this.JPPropietario = new JPanel();
        this.JCBTipDocPropietario = new JComboBox();
        this.JTNoDocPropietario = new JTextField();
        this.JTApellido1Prop = new JTextField();
        this.JTApellido2Prop = new JTextField();
        this.JTNom1Prop = new JTextField();
        this.JTNom2Prop = new JTextField();
        this.JTNoDirecionProp = new JTextField();
        this.JTNoTelProp = new JTextField();
        this.JCBDptoProp = new JComboBox();
        this.JCBMpioProp = new JComboBox();
        this.JCHConductor = new JCheckBox();
        this.JCHDatosUsuario = new JCheckBox();
        this.JPConductor = new JPanel();
        this.JCBTipDocCond = new JComboBox();
        this.JTNoDocCond = new JTextField();
        this.JTApellido1Cond = new JTextField();
        this.JTApellido2Cond = new JTextField();
        this.JTNom1Cond = new JTextField();
        this.JTNom2Cond = new JTextField();
        this.JTNoDirecionCond = new JTextField();
        this.JTNoTelCond = new JTextField();
        this.JCBDptoCond = new JComboBox();
        this.JCBMpioCond = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JCBEstadoSegVeh = new JComboBox();
        this.JCBMarcVeh = new JComboBox();
        this.JTFPlaca = new JTextField();
        this.JCBTipVeh = new JComboBox();
        this.JCBAseguradora = new JComboBox();
        this.JTFNoPoliza = new JTextField();
        this.JDFechaInicioPol = new JDateChooser();
        this.JDFechaFinPol = new JDateChooser();
        this.jPanel3 = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JTSiras = new JTextField();
        this.JCHAgotamiento = new JCheckBox();
        this.JPMovilizacion = new JPanel();
        this.JTDesdeTrans = new JTextField();
        this.JTHastaTrans = new JTextField();
        this.JPTransporteVeh = new JPanel();
        this.JTFPlacaTrans = new JTextField();
        this.JCBTipVehTrans = new JComboBox();
        this.JPZona1 = new JPanel();
        this.JRBUrbana1 = new JRadioButton();
        this.JRBRuralz1 = new JRadioButton();
        this.JBGrabarTrans = new JButton();
        this.JPFurtran = new JPanel();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel4 = new JPanel();
        this.JCBTipDocFutran = new JComboBox();
        this.JTTel = new JTextField();
        this.JTNoDocuFutran = new JTextField();
        this.JTNombre2 = new JTextField();
        this.JTDireccion = new JTextField();
        this.JTApellido2 = new JTextField();
        this.JTNEmpresa = new JTextField();
        this.JCBDpto_futran = new JComboBox();
        this.JTApellido1 = new JTextField();
        this.JCBTipServicio = new JComboBox();
        this.JCBMpio_futran = new JComboBox();
        this.JSPDocSoporte1 = new JScrollPane();
        this.JTPerFutran = new JTable();
        this.JTPlaca = new JTextField();
        this.JTNombre1 = new JTextField();
        this.JDFechaFurt = new JDateChooser();
        this.JTCodHabilitacion = new JTextField();
        this.JTOtroServicio = new JTextField();
        this.JBGrabarFutran = new JButton();
        this.JTPUbicacion = new JTabbedPane();
        this.JPVictima = new JPanel();
        this.JCBDpto_futran2 = new JComboBox();
        this.JCBMpio_futran2 = new JComboBox();
        this.JPZona2 = new JPanel();
        this.JRBUrbana2 = new JRadioButton();
        this.JRBRural2 = new JRadioButton();
        this.JTDireccionRecogida = new JTextField();
        this.JPRecibe = new JPanel();
        this.JCBTercero = new JComboBox();
        this.JTFFuncionarioR = new JTextField();
        this.JTFNoDocuFuncionario = new JTextField();
        this.jPanel5 = new JPanel();
        this.JSPDocSoporte2 = new JScrollPane();
        this.JTPerFutranHistorico = new JTable();
        this.JPHistorico = new JPanel();
        this.jPanel6 = new JPanel();
        this.JTFPlacaBusqueda = new JTextField();
        this.JTNoDocBusqueda = new JTextField();
        this.JTBPlaca = new JRadioButton();
        this.JTBDocumento = new JRadioButton();
        this.JBBuscar = new JButton();
        this.JTBDocumento1 = new JRadioButton();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JBSalir = new JButton();
        this.JBGrabar = new JButton();
        this.JBActualizar = new JButton();
        this.JLB_Evento = new JLabel();
        this.jCheckBox1.setText("jCheckBox1");
        setDefaultCloseOperation(2);
        this.JTPEventos.setForeground(new Color(0, 107, 0));
        this.JTPEventos.setFont(new Font("Arial", 1, 12));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Tahoma", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Tahoma", 1, 12));
        this.JCBTipoEvento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDpto.setFont(new Font("Arial", 1, 12));
        this.JCBDpto.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDpto.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.1
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBDptoItemStateChanged(evt);
            }
        });
        this.JCBMpio.setFont(new Font("Arial", 1, 12));
        this.JCBMpio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMpio.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.2
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBMpioItemStateChanged(evt);
            }
        });
        this.JPZona.setBorder(BorderFactory.createTitledBorder((Border) null, "Zona", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGZona.add(this.JRBUrbana);
        this.JRBUrbana.setFont(new Font("Arial", 1, 12));
        this.JRBUrbana.setSelected(true);
        this.JRBUrbana.setText("Urbana");
        this.JRBUrbana.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.3
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JRBUrbanaActionPerformed(evt);
            }
        });
        this.JBGZona.add(this.JRBRuralz);
        this.JRBRuralz.setFont(new Font("Arial", 1, 12));
        this.JRBRuralz.setText("Rural");
        this.JRBRuralz.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.4
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JRBRuralzActionPerformed(evt);
            }
        });
        GroupLayout JPZonaLayout = new GroupLayout(this.JPZona);
        this.JPZona.setLayout(JPZonaLayout);
        JPZonaLayout.setHorizontalGroup(JPZonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPZonaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBUrbana).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBRuralz).addContainerGap(-1, 32767)));
        JPZonaLayout.setVerticalGroup(JPZonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPZonaLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPZonaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUrbana).addComponent(this.JRBRuralz))));
        this.JTADescripcion.setColumns(1);
        this.JTADescripcion.setLineWrap(true);
        this.JTADescripcion.setRows(1);
        this.JTADescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTADescripcion.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.5
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTADescripcionKeyTyped(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTADescripcionKeyReleased(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTADescripcion);
        this.JTFDireccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFDireccion.setName("Direccion");
        this.JTFDireccion.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.6
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTFDireccionKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JPEventoECat.this.JTFDireccionKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTFDireccionKeyReleased(evt);
            }
        });
        this.JSPPersonasRegsitradas.setBorder(BorderFactory.createTitledBorder((Border) null, "PERSONAS REGISTRADAS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPersonas.setFont(new Font("Arial", 1, 12));
        this.JTPersonas.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTPersonas.setSelectionBackground(new Color(255, 255, 255));
        this.JTPersonas.setSelectionForeground(new Color(255, 0, 0));
        this.JTPersonas.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPEventoECat.7
            public void mouseClicked(MouseEvent evt) {
                JPEventoECat.this.JTPersonasMouseClicked(evt);
            }
        });
        this.JSPPersonasRegsitradas.setViewportView(this.JTPersonas);
        this.JPDocumentoSoportes.setBorder(BorderFactory.createTitledBorder((Border) null, "DOCUMENTOS ANEXOS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Seleccione Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPEventoECat.8
            public void mouseClicked(MouseEvent evt) {
                JPEventoECat.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JCBTipoDocumentoSoporte.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumentoSoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBSubirArchivo.setFont(new Font("Arial", 1, 12));
        this.JBSubirArchivo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBSubirArchivo.setText("ANEXAR ARCHIVO");
        this.JBSubirArchivo.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.9
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JBSubirArchivoActionPerformed(evt);
            }
        });
        this.JSPDocSoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDocSoporte.setFont(new Font("Arial", 1, 12));
        this.JTDocSoporte.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDocSoporte.setSelectionBackground(new Color(255, 255, 255));
        this.JTDocSoporte.setSelectionForeground(new Color(255, 0, 0));
        this.JTDocSoporte.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPEventoECat.10
            public void mouseClicked(MouseEvent evt) {
                JPEventoECat.this.JTDocSoporteMouseClicked(evt);
            }
        });
        this.JSPDocSoporte.setViewportView(this.JTDocSoporte);
        GroupLayout JPDocumentoSoportesLayout = new GroupLayout(this.JPDocumentoSoportes);
        this.JPDocumentoSoportes.setLayout(JPDocumentoSoportesLayout);
        JPDocumentoSoportesLayout.setHorizontalGroup(JPDocumentoSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDocumentoSoportesLayout.createSequentialGroup().addContainerGap().addGroup(JPDocumentoSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDocumentoSoportesLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 288, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDocumentoSoporte, -2, 288, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSubirArchivo, -2, 262, -2).addGap(80, 80, 80)).addComponent(this.JSPDocSoporte)).addContainerGap()));
        JPDocumentoSoportesLayout.setVerticalGroup(JPDocumentoSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDocumentoSoportesLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPDocumentoSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBSubirArchivo, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(JPDocumentoSoportesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JCBTipoDocumentoSoporte, -2, 50, -2))).addGap(5, 5, 5).addComponent(this.JSPDocSoporte, -2, 61, -2).addContainerGap()));
        this.JLB_NumeroCon.setFont(new Font("Arial", 1, 12));
        this.JLB_NumeroCon.setHorizontalAlignment(0);
        this.JLB_NumeroCon.setText("000000000000");
        this.JLB_NumeroCon.setToolTipText("");
        this.JLB_NumeroCon.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Reclamacion", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addComponent(this.JPDocumentoSoportes, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPPersonasRegsitradas).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFecha, -1, -1, 32767).addComponent(this.JPZona, -1, -1, 32767)).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTFDireccion)).addGroup(JPDatosLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFFHora, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoEvento, -2, 197, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDpto, 0, -1, 32767))).addGap(5, 5, 5).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBMpio, 0, -1, 32767).addComponent(this.JLB_NumeroCon, -1, 206, 32767)))).addGap(10, 10, 10)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFecha, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoEvento, -2, 50, -2).addComponent(this.JCBDpto, -2, 51, -2)).addComponent(this.JTFFHora, GroupLayout.Alignment.TRAILING)).addComponent(this.JCBMpio, GroupLayout.Alignment.TRAILING, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPZona, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDireccion, -2, -1, -2).addComponent(this.JLB_NumeroCon, -2, 45, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPersonasRegsitradas, -2, 189, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPDocumentoSoportes, -2, -1, -2).addContainerGap()));
        this.JTPEventos.addTab("EVENTO", this.JPDatos);
        this.JPVehi2.setBorder(BorderFactory.createTitledBorder((Border) null, "Propietario Vehiculo # 2", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFPlacaVeh2.setFont(new Font("Arial", 1, 12));
        this.JTFPlacaVeh2.setBorder(BorderFactory.createTitledBorder((Border) null, "Placa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFPlacaVeh2.setName("Placa");
        this.JTFPlacaVeh2.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.11
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaVeh2KeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaVeh2KeyTyped(evt);
            }
        });
        this.JCBTipDocP2.setFont(new Font("Arial", 1, 12));
        this.JCBTipDocP2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipDocP2.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.12
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBTipDocP2ItemStateChanged(evt);
            }
        });
        this.JTNoDocP2.setFont(new Font("Arial", 1, 12));
        this.JTNoDocP2.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoDocP2.setName("No. Documento");
        this.JTNoDocP2.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.13
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNoDocP2KeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoDocP2KeyTyped(evt);
            }
        });
        GroupLayout JPVehi2Layout = new GroupLayout(this.JPVehi2);
        this.JPVehi2.setLayout(JPVehi2Layout);
        JPVehi2Layout.setHorizontalGroup(JPVehi2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVehi2Layout.createSequentialGroup().addComponent(this.JTFPlacaVeh2, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipDocP2, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNoDocP2, -2, 128, -2)));
        JPVehi2Layout.setVerticalGroup(JPVehi2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVehi2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPlacaVeh2, -2, 50, -2).addComponent(this.JCBTipDocP2, -2, 50, -2)).addComponent(this.JTNoDocP2, -2, 50, -2));
        this.JPVehi3.setBorder(BorderFactory.createTitledBorder((Border) null, "Propietario Vehiculo # 3", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFPlacaVeh3.setFont(new Font("Arial", 1, 12));
        this.JTFPlacaVeh3.setBorder(BorderFactory.createTitledBorder((Border) null, "Placa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFPlacaVeh3.setName("Placa");
        this.JTFPlacaVeh3.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.14
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaVeh3KeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaVeh3KeyTyped(evt);
            }
        });
        this.JCBTipDocP3.setFont(new Font("Arial", 1, 12));
        this.JCBTipDocP3.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipDocP3.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.15
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBTipDocP3ItemStateChanged(evt);
            }
        });
        this.JTNoDocP3.setFont(new Font("Arial", 1, 12));
        this.JTNoDocP3.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoDocP3.setName("No. Documento");
        this.JTNoDocP3.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.16
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNoDocP3KeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoDocP3KeyTyped(evt);
            }
        });
        GroupLayout JPVehi3Layout = new GroupLayout(this.JPVehi3);
        this.JPVehi3.setLayout(JPVehi3Layout);
        JPVehi3Layout.setHorizontalGroup(JPVehi3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVehi3Layout.createSequentialGroup().addComponent(this.JTFPlacaVeh3, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipDocP3, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNoDocP3, -2, 128, -2)));
        JPVehi3Layout.setVerticalGroup(JPVehi3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVehi3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPlacaVeh3, -2, 50, -2).addComponent(this.JCBTipDocP3, -2, 50, -2)).addComponent(this.JTNoDocP3, -2, 50, -2));
        this.JPPropietario.setBorder(BorderFactory.createTitledBorder((Border) null, "Propietario Vehículo", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBTipDocPropietario.setFont(new Font("Arial", 1, 12));
        this.JCBTipDocPropietario.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTNoDocPropietario.setFont(new Font("Arial", 1, 12));
        this.JTNoDocPropietario.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoDocPropietario.setName("No. Documento");
        this.JTNoDocPropietario.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPEventoECat.17
            public void focusLost(FocusEvent evt) {
                JPEventoECat.this.JTNoDocPropietarioFocusLost(evt);
            }
        });
        this.JTNoDocPropietario.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.18
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoDocPropietarioKeyTyped(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNoDocPropietarioKeyReleased(evt);
            }
        });
        this.JTApellido1Prop.setFont(new Font("Arial", 1, 12));
        this.JTApellido1Prop.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTApellido1Prop.setName("Primer Apellido");
        this.JTApellido1Prop.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.19
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTApellido1PropKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTApellido1PropKeyTyped(evt);
            }
        });
        this.JTApellido2Prop.setFont(new Font("Arial", 1, 12));
        this.JTApellido2Prop.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTApellido2Prop.setName("Segundo Apellido");
        this.JTApellido2Prop.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.20
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTApellido2PropKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTApellido2PropKeyTyped(evt);
            }
        });
        this.JTNom1Prop.setFont(new Font("Arial", 1, 12));
        this.JTNom1Prop.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNom1Prop.setName("Primer Nombre");
        this.JTNom1Prop.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.21
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNom1PropKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNom1PropKeyTyped(evt);
            }
        });
        this.JTNom2Prop.setFont(new Font("Arial", 1, 12));
        this.JTNom2Prop.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNom2Prop.setName("Segundo Nombre");
        this.JTNom2Prop.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.22
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNom2PropKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNom2PropKeyTyped(evt);
            }
        });
        this.JTNoDirecionProp.setFont(new Font("Arial", 1, 12));
        this.JTNoDirecionProp.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoDirecionProp.setName("Dirección");
        this.JTNoDirecionProp.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.23
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNoDirecionPropKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoDirecionPropKeyTyped(evt);
            }
        });
        this.JTNoTelProp.setFont(new Font("Arial", 1, 12));
        this.JTNoTelProp.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoTelProp.setName("Teléfono");
        this.JTNoTelProp.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.24
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNoTelPropKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoTelPropKeyTyped(evt);
            }
        });
        this.JCBDptoProp.setFont(new Font("Arial", 1, 12));
        this.JCBDptoProp.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDptoProp.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.25
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBDptoPropItemStateChanged(evt);
            }
        });
        this.JCBMpioProp.setFont(new Font("Arial", 1, 12));
        this.JCBMpioProp.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHConductor.setFont(new Font("Arial", 1, 12));
        this.JCHConductor.setText("Conducía?");
        this.JCHConductor.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.26
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JCHConductorActionPerformed(evt);
            }
        });
        this.JCHDatosUsuario.setFont(new Font("Arial", 1, 12));
        this.JCHDatosUsuario.setText("Traer datos usuario?");
        this.JCHDatosUsuario.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.27
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JCHDatosUsuarioActionPerformed(evt);
            }
        });
        GroupLayout JPPropietarioLayout = new GroupLayout(this.JPPropietario);
        this.JPPropietario.setLayout(JPPropietarioLayout);
        JPPropietarioLayout.setHorizontalGroup(JPPropietarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPropietarioLayout.createSequentialGroup().addComponent(this.JTNoDirecionProp, -2, 195, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNoTelProp, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDptoProp, -2, 190, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMpioProp, -2, 232, -2).addGap(18, 18, 18).addGroup(JPPropietarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHConductor).addComponent(this.JCHDatosUsuario)).addGap(0, 0, 32767)).addGroup(JPPropietarioLayout.createSequentialGroup().addComponent(this.JCBTipDocPropietario, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNoDocPropietario, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTApellido1Prop, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTApellido2Prop, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNom1Prop, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNom2Prop, -2, 137, -2).addContainerGap(-1, 32767)));
        JPPropietarioLayout.setVerticalGroup(JPPropietarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPropietarioLayout.createSequentialGroup().addGroup(JPPropietarioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipDocPropietario, -2, 50, -2).addComponent(this.JTNoDocPropietario, -2, 50, -2).addComponent(this.JTApellido1Prop, -2, 50, -2).addComponent(this.JTApellido2Prop, -2, 50, -2).addComponent(this.JTNom1Prop, -2, 50, -2).addComponent(this.JTNom2Prop, -2, 50, -2)).addGap(5, 5, 5).addGroup(JPPropietarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPropietarioLayout.createSequentialGroup().addGroup(JPPropietarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPPropietarioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMpioProp, -1, 50, 32767).addComponent(this.JCBDptoProp, -1, 50, 32767)).addComponent(this.JTNoTelProp).addComponent(this.JTNoDirecionProp)).addGap(3, 3, 3)).addGroup(JPPropietarioLayout.createSequentialGroup().addComponent(this.JCHDatosUsuario).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHConductor, -2, 25, -2)))));
        this.JPConductor.setBorder(BorderFactory.createTitledBorder((Border) null, "Conductor Vehículo", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBTipDocCond.setFont(new Font("Arial", 1, 12));
        this.JCBTipDocCond.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTNoDocCond.setFont(new Font("Arial", 1, 12));
        this.JTNoDocCond.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoDocCond.setName("No. Documento");
        this.JTNoDocCond.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPEventoECat.28
            public void focusLost(FocusEvent evt) {
                JPEventoECat.this.JTNoDocCondFocusLost(evt);
            }
        });
        this.JTNoDocCond.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.29
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNoDocCondKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoDocCondKeyTyped(evt);
            }
        });
        this.JTApellido1Cond.setFont(new Font("Arial", 1, 12));
        this.JTApellido1Cond.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTApellido1Cond.setName("Primer Apellido");
        this.JTApellido1Cond.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.30
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTApellido1CondKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTApellido1CondKeyTyped(evt);
            }
        });
        this.JTApellido2Cond.setFont(new Font("Arial", 1, 12));
        this.JTApellido2Cond.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTApellido2Cond.setName("Segundo Apellido");
        this.JTApellido2Cond.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.31
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTApellido2CondKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTApellido2CondKeyTyped(evt);
            }
        });
        this.JTNom1Cond.setFont(new Font("Arial", 1, 12));
        this.JTNom1Cond.setBorder(BorderFactory.createTitledBorder((Border) null, "Primer Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNom1Cond.setName("Primer Nombre");
        this.JTNom1Cond.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.32
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNom1CondKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNom1CondKeyTyped(evt);
            }
        });
        this.JTNom2Cond.setFont(new Font("Arial", 1, 12));
        this.JTNom2Cond.setBorder(BorderFactory.createTitledBorder((Border) null, "Segundo Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNom2Cond.setName("Segundo Nombre");
        this.JTNom2Cond.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.33
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNom2CondKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNom2CondKeyTyped(evt);
            }
        });
        this.JTNoDirecionCond.setFont(new Font("Arial", 1, 12));
        this.JTNoDirecionCond.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoDirecionCond.setName("Dirección");
        this.JTNoDirecionCond.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.34
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNoDirecionCondKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoDirecionCondKeyTyped(evt);
            }
        });
        this.JTNoTelCond.setFont(new Font("Arial", 1, 12));
        this.JTNoTelCond.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoTelCond.setName("Teléfono");
        this.JTNoTelCond.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.35
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTNoTelCondKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoTelCondKeyTyped(evt);
            }
        });
        this.JCBDptoCond.setFont(new Font("Arial", 1, 12));
        this.JCBDptoCond.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDptoCond.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.36
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBDptoCondItemStateChanged(evt);
            }
        });
        this.JCBMpioCond.setFont(new Font("Arial", 1, 12));
        this.JCBMpioCond.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPConductorLayout = new GroupLayout(this.JPConductor);
        this.JPConductor.setLayout(JPConductorLayout);
        JPConductorLayout.setHorizontalGroup(JPConductorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConductorLayout.createSequentialGroup().addGroup(JPConductorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPConductorLayout.createSequentialGroup().addComponent(this.JCBTipDocCond, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNoDocCond, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTApellido1Cond, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTApellido2Cond, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNom1Cond, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNom2Cond, -2, 137, -2)).addGroup(JPConductorLayout.createSequentialGroup().addComponent(this.JTNoDirecionCond, -2, 223, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNoTelCond, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDptoCond, -2, 217, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMpioCond, 0, -1, 32767))).addGap(0, 9, 32767)));
        JPConductorLayout.setVerticalGroup(JPConductorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConductorLayout.createSequentialGroup().addGroup(JPConductorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipDocCond, -2, 50, -2).addComponent(this.JTNoDocCond, -2, 50, -2).addComponent(this.JTApellido1Cond, -2, 50, -2).addComponent(this.JTApellido2Cond, -2, 50, -2).addComponent(this.JTNom1Cond, -2, 50, -2).addComponent(this.JTNom2Cond, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPConductorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTNoDirecionCond).addComponent(this.JTNoTelCond).addComponent(this.JCBDptoCond).addComponent(this.JCBMpioCond)).addGap(3, 3, 3)));
        this.JTApellido1Cond.getAccessibleContext().setAccessibleDescription("");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Vehículo", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBEstadoSegVeh.setFont(new Font("Arial", 1, 12));
        this.JCBEstadoSegVeh.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado del Seguro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEstadoSegVeh.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.37
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBEstadoSegVehItemStateChanged(evt);
            }
        });
        this.JCBMarcVeh.setFont(new Font("Arial", 1, 12));
        this.JCBMarcVeh.setBorder(BorderFactory.createTitledBorder((Border) null, "Marca", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPlaca.setFont(new Font("Arial", 1, 12));
        this.JTFPlaca.setBorder(BorderFactory.createTitledBorder((Border) null, "Placa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFPlaca.setName("Placa");
        this.JTFPlaca.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.38
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaKeyTyped(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaKeyReleased(evt);
            }
        });
        this.JCBTipVeh.setFont(new Font("Arial", 1, 12));
        this.JCBTipVeh.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAseguradora.setFont(new Font("Arial", 1, 12));
        this.JCBAseguradora.setBorder(BorderFactory.createTitledBorder((Border) null, "Aseguradora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoPoliza.setFont(new Font("Arial", 1, 12));
        this.JTFNoPoliza.setBorder(BorderFactory.createTitledBorder((Border) null, "No. póliza", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNoPoliza.setName("No. póliza");
        this.JTFNoPoliza.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.39
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTFNoPolizaKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTFNoPolizaKeyTyped(evt);
            }
        });
        this.JDFechaInicioPol.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaInicioPol.setDateFormatString("dd/MM/yyyy");
        this.JDFechaInicioPol.setFont(new Font("Tahoma", 1, 12));
        this.JDFechaFinPol.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaFinPol.setDateFormatString("dd/MM/yyyy");
        this.JDFechaFinPol.setFont(new Font("Tahoma", 1, 12));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Intervino la Autoridad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGAutoridad.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Sí");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.40
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGAutoridad.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.41
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo))));
        this.JTSiras.setFont(new Font("Arial", 1, 12));
        this.JTSiras.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTSiras.setName("Dirección");
        this.JTSiras.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.42
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTSirasKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTSirasKeyTyped(evt);
            }
        });
        this.JCHAgotamiento.setFont(new Font("Arial", 1, 12));
        this.JCHAgotamiento.setText("Agotamiento Aseguradora ?");
        this.JCHAgotamiento.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.43
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JCHAgotamientoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBEstadoSegVeh, -2, 168, -2).addGap(18, 18, 18).addComponent(this.JCBMarcVeh, -2, 163, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipVeh, -2, 163, -2).addGap(5, 5, 5).addComponent(this.JTFPlaca, -2, 168, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBAseguradora, -2, 163, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNoPoliza, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaInicioPol, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaFinPol, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTSiras, -2, 183, -2))).addGap(12, 12, 12).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.JCHAgotamiento, -1, -1, 32767)).addGap(36, 36, 36)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPlaca, -2, 51, -2).addComponent(this.JCBTipVeh, -2, 51, -2).addComponent(this.JCBMarcVeh, -2, 51, -2).addComponent(this.JCBEstadoSegVeh)).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel3, -2, -1, -2))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNoPoliza).addGap(1, 1, 1)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBAseguradora, -2, 52, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaInicioPol, -2, 50, -2).addComponent(this.JDFechaFinPol, -2, 50, -2)))).addGap(0, 0, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTSiras).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHAgotamiento).addContainerGap(-1, 32767)))));
        GroupLayout JPAccidenteLayout = new GroupLayout(this.JPAccidente);
        this.JPAccidente.setLayout(JPAccidenteLayout);
        JPAccidenteLayout.setHorizontalGroup(JPAccidenteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAccidenteLayout.createSequentialGroup().addComponent(this.JPVehi2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPVehi3, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPAccidenteLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPAccidenteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAccidenteLayout.createSequentialGroup().addComponent(this.JPConductor, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPAccidenteLayout.createSequentialGroup().addGroup(JPAccidenteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPPropietario, -1, -1, 32767)).addContainerGap()))));
        JPAccidenteLayout.setVerticalGroup(JPAccidenteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPAccidenteLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPropietario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPConductor, -2, -1, -2).addGap(5, 5, 5).addGroup(JPAccidenteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPVehi2, -2, -1, -2).addComponent(this.JPVehi3, -2, -1, -2)).addGap(45, 45, 45)));
        this.JTPEventos.addTab("ACCIDENTE", this.JPAccidente);
        this.JTDesdeTrans.setBorder(BorderFactory.createTitledBorder((Border) null, "Transporto la víctima desde", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDesdeTrans.setName("Transporto la víctima desde");
        this.JTDesdeTrans.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.44
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTDesdeTransKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTDesdeTransKeyTyped(evt);
            }
        });
        this.JTHastaTrans.setBorder(BorderFactory.createTitledBorder((Border) null, "Hasta", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTHastaTrans.setName("Hasta");
        this.JTHastaTrans.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.45
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTHastaTransKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTHastaTransKeyTyped(evt);
            }
        });
        this.JPTransporteVeh.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos Vehículo", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFPlacaTrans.setBorder(BorderFactory.createTitledBorder((Border) null, "Placa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFPlacaTrans.setName("Placa");
        this.JTFPlacaTrans.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.46
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaTransKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaTransKeyTyped(evt);
            }
        });
        this.JCBTipVehTrans.setFont(new Font("Arial", 1, 12));
        this.JCBTipVehTrans.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPTransporteVehLayout = new GroupLayout(this.JPTransporteVeh);
        this.JPTransporteVeh.setLayout(JPTransporteVehLayout);
        JPTransporteVehLayout.setHorizontalGroup(JPTransporteVehLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTransporteVehLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFPlacaTrans, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipVehTrans, -2, 231, -2).addContainerGap(-1, 32767)));
        JPTransporteVehLayout.setVerticalGroup(JPTransporteVehLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTransporteVehLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPlacaTrans, -2, 50, -2).addComponent(this.JCBTipVehTrans, -2, 50, -2)));
        this.JPZona1.setBorder(BorderFactory.createTitledBorder((Border) null, "Zona", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGZonaTrans.add(this.JRBUrbana1);
        this.JRBUrbana1.setFont(new Font("Arial", 1, 12));
        this.JRBUrbana1.setSelected(true);
        this.JRBUrbana1.setText("Urbana");
        this.JRBUrbana1.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.47
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JRBUrbana1ActionPerformed(evt);
            }
        });
        this.JBGZonaTrans.add(this.JRBRuralz1);
        this.JRBRuralz1.setFont(new Font("Arial", 1, 12));
        this.JRBRuralz1.setText("Rural");
        this.JRBRuralz1.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.48
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JRBRuralz1ActionPerformed(evt);
            }
        });
        GroupLayout JPZona1Layout = new GroupLayout(this.JPZona1);
        this.JPZona1.setLayout(JPZona1Layout);
        JPZona1Layout.setHorizontalGroup(JPZona1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPZona1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBUrbana1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBRuralz1).addContainerGap(-1, 32767)));
        JPZona1Layout.setVerticalGroup(JPZona1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPZona1Layout.createSequentialGroup().addGroup(JPZona1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUrbana1).addComponent(this.JRBRuralz1)).addGap(0, 3, 32767)));
        this.JBGrabarTrans.setFont(new Font("Arial", 1, 12));
        this.JBGrabarTrans.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabarTrans.setText("GRABAR");
        this.JBGrabarTrans.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.49
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JBGrabarTransActionPerformed(evt);
            }
        });
        GroupLayout JPMovilizacionLayout = new GroupLayout(this.JPMovilizacion);
        this.JPMovilizacion.setLayout(JPMovilizacionLayout);
        JPMovilizacionLayout.setHorizontalGroup(JPMovilizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMovilizacionLayout.createSequentialGroup().addContainerGap().addGroup(JPMovilizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPMovilizacionLayout.createSequentialGroup().addComponent(this.JPTransporteVeh, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPZona1, -2, -1, -2)).addGroup(JPMovilizacionLayout.createSequentialGroup().addComponent(this.JTDesdeTrans, -2, 251, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTHastaTrans))).addGap(35, 35, 35).addComponent(this.JBGrabarTrans, -2, 204, -2).addContainerGap(203, 32767)));
        JPMovilizacionLayout.setVerticalGroup(JPMovilizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMovilizacionLayout.createSequentialGroup().addContainerGap().addGroup(JPMovilizacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBGrabarTrans, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPMovilizacionLayout.createSequentialGroup().addGroup(JPMovilizacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTransporteVeh, -2, -1, -2).addComponent(this.JPZona1, -2, -1, -2)).addGap(14, 14, 14).addGroup(JPMovilizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTDesdeTrans, -2, 50, -2).addComponent(this.JTHastaTrans, -2, 50, -2)))).addContainerGap(375, 32767)));
        this.JTPEventos.addTab("TRANSPORTE", this.JPMovilizacion);
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JCBTipDocFutran.setFont(new Font("Arial", 1, 12));
        this.JCBTipDocFutran.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTTel.setFont(new Font("Arial", 1, 12));
        this.JTTel.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono ó Celular", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTTel.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.50
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTTelKeyTyped(evt);
            }
        });
        this.JTNoDocuFutran.setFont(new Font("Arial", 1, 12));
        this.JTNoDocuFutran.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoDocuFutran.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.51
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoDocuFutranKeyTyped(evt);
            }
        });
        this.JTNombre2.setFont(new Font("Arial", 1, 12));
        this.JTNombre2.setBorder(BorderFactory.createTitledBorder((Border) null, "2do. Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNombre2.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.52
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNombre2KeyTyped(evt);
            }
        });
        this.JTDireccion.setFont(new Font("Arial", 1, 12));
        this.JTDireccion.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p align=\"justify\">Dirección de la empresa o persona que realiza el transporte</p><html>", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDireccion.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.53
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTDireccionKeyTyped(evt);
            }
        });
        this.JTApellido2.setFont(new Font("Arial", 1, 12));
        this.JTApellido2.setBorder(BorderFactory.createTitledBorder((Border) null, "2do. Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTApellido2.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.54
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTApellido2KeyTyped(evt);
            }
        });
        this.JTNEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTNEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Empresa de Transporte Especial Reclamante", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNEmpresa.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.55
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNEmpresaKeyTyped(evt);
            }
        });
        this.JCBDpto_futran.setFont(new Font("Arial", 1, 12));
        this.JCBDpto_futran.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDpto_futran.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.56
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBDpto_futranItemStateChanged(evt);
            }
        });
        this.JTApellido1.setFont(new Font("Arial", 1, 12));
        this.JTApellido1.setBorder(BorderFactory.createTitledBorder((Border) null, "1er Apellido", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTApellido1.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.57
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTApellido1KeyTyped(evt);
            }
        });
        this.JCBTipServicio.setFont(new Font("Arial", 1, 12));
        this.JCBTipServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMpio_futran.setFont(new Font("Arial", 1, 12));
        this.JCBMpio_futran.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDocSoporte1.setBorder(BorderFactory.createTitledBorder((Border) null, "RELACIÓN DE VÍCTIMAS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPerFutran.setFont(new Font("Arial", 1, 12));
        this.JTPerFutran.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTPerFutran.setSelectionBackground(new Color(255, 255, 255));
        this.JTPerFutran.setSelectionForeground(new Color(255, 0, 0));
        this.JTPerFutran.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPEventoECat.58
            public void mouseClicked(MouseEvent evt) {
                JPEventoECat.this.JTPerFutranMouseClicked(evt);
            }
        });
        this.JSPDocSoporte1.setViewportView(this.JTPerFutran);
        this.JTPlaca.setFont(new Font("Arial", 1, 12));
        this.JTPlaca.setBorder(BorderFactory.createTitledBorder((Border) null, "En vehículo con placa No", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPlaca.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.59
            public void keyReleased(KeyEvent evt) {
                JPEventoECat.this.JTPlacaKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTPlacaKeyTyped(evt);
            }
        });
        this.JTNombre1.setFont(new Font("Arial", 1, 12));
        this.JTNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "1er Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNombre1.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.60
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNombre1KeyTyped(evt);
            }
        });
        this.JDFechaFurt.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaFurt.setDateFormatString("dd/MM/yyyy");
        this.JDFechaFurt.setFont(new Font("Tahoma", 1, 12));
        this.JTCodHabilitacion.setFont(new Font("Arial", 1, 12));
        this.JTCodHabilitacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de habilitación Empresa de Transporte Especial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTCodHabilitacion.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.61
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTCodHabilitacionKeyTyped(evt);
            }
        });
        this.JTOtroServicio.setFont(new Font("Arial", 1, 12));
        this.JTOtroServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Otro tipo servicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTOtroServicio.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.62
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTOtroServicioKeyTyped(evt);
            }
        });
        this.JBGrabarFutran.setFont(new Font("Arial", 1, 12));
        this.JBGrabarFutran.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabarFutran.setText("GRABAR FURTRAN");
        this.JBGrabarFutran.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.63
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JBGrabarFutranActionPerformed(evt);
            }
        });
        this.JTPUbicacion.setForeground(new Color(0, 103, 0));
        this.JTPUbicacion.setFont(new Font("Arial", 1, 14));
        this.JPVictima.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBDpto_futran2.setFont(new Font("Arial", 1, 12));
        this.JCBDpto_futran2.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDpto_futran2.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.64
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBDpto_futran2ItemStateChanged(evt);
            }
        });
        this.JCBMpio_futran2.setFont(new Font("Arial", 1, 12));
        this.JCBMpio_futran2.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPZona2.setBorder(BorderFactory.createTitledBorder((Border) null, "Zona", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGZonaFutran.add(this.JRBUrbana2);
        this.JRBUrbana2.setFont(new Font("Arial", 1, 12));
        this.JRBUrbana2.setSelected(true);
        this.JRBUrbana2.setText("Urbana");
        this.JRBUrbana2.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.65
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JRBUrbana2ActionPerformed(evt);
            }
        });
        this.JBGZonaFutran.add(this.JRBRural2);
        this.JRBRural2.setFont(new Font("Arial", 1, 12));
        this.JRBRural2.setText("Rural");
        this.JRBRural2.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.66
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JRBRural2ActionPerformed(evt);
            }
        });
        GroupLayout JPZona2Layout = new GroupLayout(this.JPZona2);
        this.JPZona2.setLayout(JPZona2Layout);
        JPZona2Layout.setHorizontalGroup(JPZona2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPZona2Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBUrbana2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBRural2).addContainerGap(-1, 32767)));
        JPZona2Layout.setVerticalGroup(JPZona2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPZona2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPZona2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUrbana2).addComponent(this.JRBRural2))));
        this.JTDireccionRecogida.setFont(new Font("Arial", 1, 12));
        this.JTDireccionRecogida.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDireccionRecogida.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.67
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTDireccionRecogidaKeyTyped(evt);
            }
        });
        GroupLayout JPVictimaLayout = new GroupLayout(this.JPVictima);
        this.JPVictima.setLayout(JPVictimaLayout);
        JPVictimaLayout.setHorizontalGroup(JPVictimaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVictimaLayout.createSequentialGroup().addComponent(this.JTDireccionRecogida).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDpto_futran2, -2, 201, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMpio_futran2, -2, 264, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPZona2, -2, -1, -2).addContainerGap()));
        JPVictimaLayout.setVerticalGroup(JPVictimaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVictimaLayout.createSequentialGroup().addGroup(JPVictimaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTDireccionRecogida, GroupLayout.Alignment.LEADING).addComponent(this.JCBMpio_futran2, GroupLayout.Alignment.LEADING).addComponent(this.JPZona2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBDpto_futran2)).addGap(10, 10, 10)));
        this.JTPUbicacion.addTab("UBICACION VICTIMA", this.JPVictima);
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa Destino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addItemListener(new ItemListener() { // from class: Facturacion.JPEventoECat.68
            public void itemStateChanged(ItemEvent evt) {
                JPEventoECat.this.JCBTerceroItemStateChanged(evt);
            }
        });
        this.JTFFuncionarioR.setFont(new Font("Arial", 1, 12));
        this.JTFFuncionarioR.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Funcionario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFuncionarioR.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.69
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTFFuncionarioRKeyTyped(evt);
            }
        });
        this.JTFNoDocuFuncionario.setFont(new Font("Arial", 1, 12));
        this.JTFNoDocuFuncionario.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento Funcionario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNoDocuFuncionario.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.70
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTFNoDocuFuncionarioKeyTyped(evt);
            }
        });
        GroupLayout JPRecibeLayout = new GroupLayout(this.JPRecibe);
        this.JPRecibe.setLayout(JPRecibeLayout);
        JPRecibeLayout.setHorizontalGroup(JPRecibeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRecibeLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTercero, -2, 265, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNoDocuFuncionario, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFuncionarioR, -1, 486, 32767).addContainerGap()));
        JPRecibeLayout.setVerticalGroup(JPRecibeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRecibeLayout.createSequentialGroup().addGroup(JPRecibeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTercero, -2, 50, -2).addComponent(this.JTFFuncionarioR, -2, 50, -2).addComponent(this.JTFNoDocuFuncionario)).addGap(10, 10, 10)));
        this.JTPUbicacion.addTab("EMPRESA RECIBE", this.JPRecibe);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JDFechaFurt, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTNEmpresa).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTCodHabilitacion, -2, 342, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCBTipServicio, -2, 174, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTOtroServicio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPlaca, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTDireccion, -2, 311, -2)).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTNombre1).addComponent(this.JTApellido1, -2, 337, -2)).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTApellido2).addComponent(this.JTNombre2, -2, 332, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipDocFutran, 0, -1, 32767).addComponent(this.JTNoDocuFutran))).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JTTel, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDpto_futran, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMpio_futran, 0, -1, 32767)).addComponent(this.JSPDocSoporte1, GroupLayout.Alignment.TRAILING).addComponent(this.JBGrabarFutran, -1, -1, 32767).addComponent(this.JTPUbicacion)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTCodHabilitacion, GroupLayout.Alignment.TRAILING).addComponent(this.JDFechaFurt, GroupLayout.Alignment.TRAILING, -2, 0, 32767).addComponent(this.JTNEmpresa, GroupLayout.Alignment.TRAILING)).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCBTipDocFutran, -2, 50, -2).addGap(4, 4, 4).addComponent(this.JTNoDocuFutran)).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTApellido1, -2, 50, -2).addComponent(this.JTApellido2, -2, 50, -2)).addGap(2, 2, 2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTNombre1).addComponent(this.JTNombre2, -2, 50, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTDireccion, -2, 50, -2).addGroup(jPanel4Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JCBTipServicio, -2, 49, -2)).addComponent(this.JTPlaca, -2, 51, -2)).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.JTOtroServicio, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMpio_futran, GroupLayout.Alignment.TRAILING, -2, 47, -2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTTel, -2, 50, -2).addComponent(this.JCBDpto_futran, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPUbicacion, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDocSoporte1, -2, 69, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabarFutran, -1, -1, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("DATOS", this.jPanel4);
        this.JSPDocSoporte2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE FURTRAN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPerFutranHistorico.setFont(new Font("Arial", 1, 12));
        this.JTPerFutranHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTPerFutranHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTPerFutranHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTPerFutranHistorico.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPEventoECat.71
            public void mouseClicked(MouseEvent evt) {
                JPEventoECat.this.JTPerFutranHistoricoMouseClicked(evt);
            }
        });
        this.JSPDocSoporte2.setViewportView(this.JTPerFutranHistorico);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDocSoporte2).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDocSoporte2, -2, 188, -2).addContainerGap(304, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel5);
        GroupLayout JPFurtranLayout = new GroupLayout(this.JPFurtran);
        this.JPFurtran.setLayout(JPFurtranLayout);
        JPFurtranLayout.setHorizontalGroup(JPFurtranLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFurtranLayout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        JPFurtranLayout.setVerticalGroup(JPFurtranLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFurtranLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jTabbedPane1).addContainerGap()));
        this.JTPEventos.addTab("REGISTRO FURTRAN", this.JPFurtran);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFPlacaBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFPlacaBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Placa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFPlacaBusqueda.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.72
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaBusquedaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JPEventoECat.this.JTFPlacaBusquedaKeyPressed(evt);
            }
        });
        this.JTNoDocBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTNoDocBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNoDocBusqueda.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEventoECat.73
            public void keyTyped(KeyEvent evt) {
                JPEventoECat.this.JTNoDocBusquedaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JPEventoECat.this.JTNoDocBusquedaKeyPressed(evt);
            }
        });
        this.JBGFiltroBusq.add(this.JTBPlaca);
        this.JBGFiltroBusq.add(this.JTBDocumento);
        this.JBBuscar.setFont(new Font("Arial", 1, 12));
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscar.setText("Buscar");
        this.JBBuscar.setToolTipText("Realizar Búsqueda");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.74
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JBGFiltroBusq.add(this.JTBDocumento1);
        this.JTBDocumento1.setFont(new Font("Arial", 1, 12));
        this.JTBDocumento1.setSelected(true);
        this.JTBDocumento1.setText("Sin Filtro");
        this.JTBDocumento1.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.75
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JTBDocumento1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.JTBPlaca).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFPlacaBusqueda, -2, 99, -2).addGap(52, 52, 52).addComponent(this.JTBDocumento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTNoDocBusqueda, -2, 262, -2).addGap(10, 10, 10).addComponent(this.JBBuscar, -2, 126, -2).addGap(50, 50, 50).addComponent(this.JTBDocumento1).addContainerGap(-1, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPlacaBusqueda, -2, 50, -2).addComponent(this.JTNoDocBusqueda, -2, 50, -2).addComponent(this.JTBPlaca)).addComponent(this.JTBDocumento).addComponent(this.JBBuscar, -1, -1, 32767)).addComponent(this.JTBDocumento1)).addGap(0, 6, 32767)));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPEventoECat.76
            public void mouseClicked(MouseEvent evt) {
                JPEventoECat.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico, -1, 962, 32767).addComponent(this.jPanel6, -1, -1, 32767)).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPHistorico, -2, 430, -2).addContainerGap()));
        this.JTPEventos.addTab("HISTÓRICO", this.JPHistorico);
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("SALIR");
        this.JBSalir.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.77
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JBSalirActionPerformed(evt);
            }
        });
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("GRABAR");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.78
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JBActualizar.setFont(new Font("Arial", 1, 12));
        this.JBActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBActualizar.setText("ACTUALIZAR");
        this.JBActualizar.addActionListener(new ActionListener() { // from class: Facturacion.JPEventoECat.79
            public void actionPerformed(ActionEvent evt) {
                JPEventoECat.this.JBActualizarActionPerformed(evt);
            }
        });
        this.JLB_Evento.setFont(new Font("Arial", 1, 12));
        this.JLB_Evento.setHorizontalAlignment(0);
        this.JLB_Evento.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Evento", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JBGrabar, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBActualizar, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSalir, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_Evento, -2, 156, -2).addContainerGap(-1, 32767)).addComponent(this.JTPEventos));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPEventos, -2, 556, -2).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGrabar, -2, 50, -2).addComponent(this.JBActualizar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2)).addComponent(this.JLB_Evento, -2, 45, -2)).addContainerGap()));
        pack();
    }

    private void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDptoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBDpto.getSelectedIndex() != -1) {
            this.JCBMpio.removeAllItems();
            String sql = "SELECT `Id`  , `Nbre` FROM `g_municipio` WHERE (`Estado` =0  AND `Id_Dpto` ='" + this.xidDpto[this.JCBDpto.getSelectedIndex()] + "') ORDER BY Nbre ASC";
            this.xidMpio = this.xct.llenarCombo(sql, this.xidMpio, this.JCBMpio);
            this.xct.cerrarConexionBd();
            this.JCBDpto_futran2.setSelectedItem(this.JCBDpto.getSelectedItem());
        }
    }

    private void btnGrabarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUrbanaActionPerformed(ActionEvent evt) {
        this.xzona = "U";
        this.xzonaFutrans = "U";
        this.JRBUrbana2.setSelected(true);
    }

    private void JTFFHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRuralzActionPerformed(ActionEvent evt) {
        this.xzona = "R";
        this.xzonaFutrans = "R";
        this.JRBRural2.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mEntrada();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xAutoridad = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xAutoridad = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDptoPropItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBDptoProp.getSelectedIndex() != -1) {
            this.JCBMpioProp.removeAllItems();
            String sql = "SELECT `Id`  , `Nbre` FROM `g_municipio` WHERE (`Estado` =0  AND `Id_Dpto` ='" + this.xidDptoProp[this.JCBDptoProp.getSelectedIndex()] + "') ORDER BY Nbre ASC";
            this.xidMpioProp = this.xct.llenarCombo(sql, this.xidMpioProp, this.JCBMpioProp);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDptoCondItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBDptoCond.getSelectedIndex() != -1) {
            this.JCBMpioCond.removeAllItems();
            String sql = "SELECT `Id`  , `Nbre` FROM `g_municipio` WHERE (`Estado` =0  AND `Id_Dpto` ='" + this.xidDptoCond[this.JCBDptoCond.getSelectedIndex()] + "') ORDER BY Nbre ASC";
            this.xidMpioCond = this.xct.llenarCombo(sql, this.xidMpioCond, this.JCBMpioCond);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() > -1) {
            mBuscarPersonas(this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            mBuscarDatosEventos();
            this.xevento = this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString();
            this.JLB_Evento.setText(this.xevento);
            this.JTPEventos.setSelectedIndex(0);
            mBuscarSoportesEvento(this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            mBuscarFurtran(this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipDocP2ItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipDocP2.getSelectedIndex() != -1) {
            this.xdoc1 = String.valueOf(this.xidTDocProp2[this.JCBTipDocP2.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipDocP3ItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipDocP3.getSelectedIndex() != -1) {
            this.xdoc2 = String.valueOf(this.xidTDocProp3[this.JCBTipDocP3.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConductorActionPerformed(ActionEvent evt) {
        if (this.JCHConductor.isSelected()) {
            this.JCBTipDocCond.setSelectedItem(this.JCBTipDocPropietario.getSelectedItem());
            this.JTNoDocCond.setText(this.JTNoDocPropietario.getText());
            this.JTApellido1Cond.setText(this.JTApellido1Prop.getText());
            this.JTApellido2Cond.setText(this.JTApellido2Prop.getText());
            this.JTNom1Cond.setText(this.JTNom1Prop.getText());
            this.JTNom2Cond.setText(this.JTNom2Prop.getText());
            this.JTNoDirecionCond.setText(this.JTNoDirecionProp.getText());
            this.JTNoTelCond.setText(this.JTNoTelProp.getText());
            this.JCBDptoCond.setSelectedItem(this.JCBDptoProp.getSelectedItem());
            this.JCBMpioCond.setSelectedItem(this.JCBMpioProp.getSelectedItem());
        } else {
            this.JCBTipDocCond.setSelectedIndex(-1);
            this.JTNoDocCond.setText("");
            this.JTApellido1Cond.setText("");
            this.JTApellido2Cond.setText("");
            this.JTNom1Cond.setText("");
            this.JTNom2Cond.setText("");
            this.JTNoDirecionCond.setText("");
            this.JTNoTelCond.setText("");
            this.JCBDptoCond.setSelectedIndex(-1);
            this.JCBMpioCond.setSelectedIndex(-1);
        }
        mValidaLongitudCampos(16, this.JTNoDocCond, 11, 1);
        mValidaLongitudCampos(20, this.JTApellido1Cond, 12, 1);
        mValidaLongitudCampos(30, this.JTApellido2Cond, 13, 1);
        mValidaLongitudCampos(20, this.JTNom1Cond, 14, 1);
        mValidaLongitudCampos(30, this.JTNom2Cond, 15, 1);
        mValidaLongitudCampos(40, this.JTNoDirecionCond, 16, 1);
        mValidaLongitudCampos(10, this.JTNoTelCond, 17, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSubirArchivoActionPerformed(ActionEvent evt) {
        mSubirArchivo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDocSoporteMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            String rutaa = this.xmodeloSoporte.getValueAt(this.JTDocSoporte.getSelectedRow(), 2).toString();
            if (this.xmt.mExisteArchivo(this.directorio + this.xmt.getBarra() + rutaa)) {
                this.xmt.mostrarPdf(this.directorio + this.xmt.getBarra() + rutaa);
            } else {
                JOptionPane.showMessageDialog(this, "El archivo que trata de abrir no se encuentra en la siguiente ruta:\n\n" + this.directorio + this.xmt.getBarra() + rutaa, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUrbana1ActionPerformed(ActionEvent evt) {
        this.xzonaTrans = "U";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRuralz1ActionPerformed(ActionEvent evt) {
        this.xzonaTrans = "R";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPersonasMouseClicked(MouseEvent evt) {
        this.numeroRadicado = this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 10).toString();
        this.JLB_NumeroCon.setText(this.numeroRadicado);
        if (this.JTPersonas.getSelectedRow() != -1) {
            Object[] botones = {"Imprimir", "Registrar Transporte", "Cerrar"};
            int n = JOptionPane.showOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, (Icon) null, botones, "Cerrar");
            if (n != 0) {
                if (n == 1) {
                    try {
                        this.xzonaTrans = "U";
                        this.JTFPlacaTrans.setText("");
                        this.JCBTipVehTrans.setSelectedIndex(-1);
                        this.JTDesdeTrans.setText("");
                        this.JTHastaTrans.setText("");
                        traerDatos();
                        this.JTPEventos.setEnabledAt(2, true);
                        this.JTPEventos.setSelectedIndex(2);
                        return;
                    } catch (Exception e) {
                        this.JTPEventos.setEnabledAt(2, true);
                        this.JTPEventos.setSelectedIndex(2);
                        this.JTFPlacaTrans.setText("");
                        this.JCBTipVehTrans.setSelectedIndex(-1);
                        this.JTDesdeTrans.setText("");
                        this.JTHastaTrans.setText("");
                        this.JRBUrbana1.setSelected(true);
                        this.xzonaTrans = "U";
                        return;
                    }
                }
                return;
            }
            Object[] botones1 = {"FURIPS ANTERIOR", "FURIPS 2023", "CERRAR"};
            int n2 = JOptionPane.showOptionDialog(this, "Que desea hacer?", "VISUALIZAR", 0, 3, (Icon) null, botones1, "CERRAR");
            if (n2 == 0) {
                Object[] botones2 = {"FORMATO A", "FORMATO B"};
                int n3 = JOptionPane.showOptionDialog(this, "Que desea hacer?", "VISUALIZAR", 0, 3, (Icon) null, botones2, "CERRAR");
                if (n3 == 0) {
                    Furips_PA xfrPA = new Furips_PA(this.xevento, this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 7).toString(), this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 9).toString(), "", "");
                    xfrPA.build();
                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPA.pdf");
                    return;
                } else {
                    if (n3 == 1) {
                        Furips_PB xfr = new Furips_PB(this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 6).toString(), this.xevento, this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 9).toString(), "", "", "");
                        xfr.build();
                        this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPB.pdf");
                        return;
                    }
                    return;
                }
            }
            if (n2 == 1) {
                Object[] botones3 = {"FORMATO A", "FORMATO B"};
                int n4 = JOptionPane.showOptionDialog(this, "Que desea hacer?", "VISUALIZAR", 0, 3, (Icon) null, botones3, "CERRAR");
                if (n4 == 0) {
                    System.err.println("v2023A");
                    Furips_PA_V2023 xfrPA_v2 = new Furips_PA_V2023(this.xevento, this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 7).toString(), this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 9).toString(), "", "");
                    xfrPA_v2.build();
                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPA_v2023.pdf");
                    return;
                }
                if (n4 == 1) {
                    System.err.println("v2023B");
                    Furips_PB_V2023 xfrb = new Furips_PB_V2023(this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 6).toString(), this.xevento, this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 9).toString(), "", "", "");
                    xfrb.build();
                    this.xmt.mostrarPdf(this.xmt.getRutaRep() + "furipsPB_v2023.pdf");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarTransActionPerformed(ActionEvent evt) {
        if (this.encotrado.booleanValue()) {
            actualizarDatos();
        } else {
            mGrabaTrasporte();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDatosUsuarioActionPerformed(ActionEvent evt) {
        if (this.JCHDatosUsuario.isSelected()) {
            mCargarDatosUsuario(this.xidTDocCond, this.JCBTipDocPropietario, this.JTNoDocPropietario, this.JTApellido1Prop, this.JTApellido2Prop, this.JTNom1Prop, this.JTNom2Prop, this.JTNoDirecionProp, this.JTNoTelProp, this.JCBDptoProp, this.JCBMpioProp, 0);
        } else {
            this.JCBTipDocPropietario.setSelectedIndex(-1);
            this.JTNoDocPropietario.setText("");
            this.JTApellido1Prop.setText("");
            this.JTApellido2Prop.setText("");
            this.JTNom1Prop.setText("");
            this.JTNom2Prop.setText("");
            this.JTNoDirecionProp.setText("");
            this.JTNoTelProp.setText("");
            this.JCBMpioProp.removeAllItems();
            this.JCBDptoProp.setSelectedIndex(-1);
        }
        mValidaLongitudCampos(16, this.JTNoDocPropietario, 4, 1);
        mValidaLongitudCampos(20, this.JTApellido1Prop, 5, 1);
        mValidaLongitudCampos(30, this.JTApellido2Prop, 6, 1);
        mValidaLongitudCampos(20, this.JTNom1Prop, 7, 1);
        mValidaLongitudCampos(30, this.JTNom2Prop, 8, 1);
        mValidaLongitudCampos(40, this.JTNoDirecionProp, 9, 1);
        mValidaLongitudCampos(10, this.JTNoTelProp, 10, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDireccionKeyTyped(KeyEvent evt) {
        if (!Character.isLetter(evt.getKeyChar()) && !Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != ' ' && evt.getKeyChar() != '\b') {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADescripcionKeyTyped(KeyEvent evt) {
        if (!Character.isLetter(evt.getKeyChar()) && !Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != ' ' && evt.getKeyChar() != '\b') {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoPolizaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocPropietarioKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido1PropKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido2PropKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNom1PropKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNom2PropKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDirecionPropKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoTelCondKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoTelPropKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocCondKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido1CondKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido2CondKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNom1CondKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNom2CondKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDirecionCondKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaVeh2KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocP2KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaVeh3KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocP3KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaTransKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDesdeTransKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHastaTransKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNEmpresaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCodHabilitacionKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido1KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido2KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNombre1KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNombre2KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocuFutranKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPlacaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDireccionKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTTelKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUrbana2ActionPerformed(ActionEvent evt) {
        this.xzonaFutrans = "U";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRural2ActionPerformed(ActionEvent evt) {
        this.xzonaFutrans = "R";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPerFutranMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDpto_futranItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBDpto_futran.getSelectedIndex() != -1) {
            this.JCBMpio_futran.removeAllItems();
            String sql = "SELECT `Id`  , `Nbre` FROM `g_municipio` WHERE (`Estado` =0  AND `Id_Dpto` ='" + this.xidDptoFTrans1[this.JCBDpto_futran.getSelectedIndex()] + "') ORDER BY Nbre ASC";
            this.xidMPioFtrans1 = this.xct.llenarCombo(sql, this.xidMPioFtrans1, this.JCBMpio_futran);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDpto_futran2ItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBDpto_futran2.getSelectedIndex() != -1) {
            this.JCBMpio_futran2.removeAllItems();
            String sql = "SELECT `Id`  , `Nbre` FROM `g_municipio` WHERE (`Estado` =0  AND `Id_Dpto` ='" + this.xidDptoFTrans2[this.JCBDpto_futran2.getSelectedIndex()] + "') ORDER BY Nbre ASC";
            this.xidMPioFtrans2 = this.xct.llenarCombo(sql, this.xidMPioFtrans2, this.JCBMpio_futran2);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDireccionRecogidaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTOtroServicioKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarFutranActionPerformed(ActionEvent evt) {
        mGrabarEvento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPerFutranHistoricoMouseClicked(MouseEvent evt) {
        Furtran x = new Furtran(this.xmodeloHistoricoF.getValueAt(this.JTPerFutranHistorico.getSelectedRow(), 0).toString(), 0);
        x.build();
        this.xmt.mostrarPdf(this.xmt.getRutaRep() + "Furtran.pdf");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        if (this.JTBPlaca.isSelected() || this.JTBDocumento.isSelected()) {
            mBuscarHistorico();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccionar un Filtro", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDocumento1ActionPerformed(ActionEvent evt) {
        mBuscarHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBActualizarActionPerformed(ActionEvent evt) {
        if (this.xevento.equals("")) {
            JOptionPane.showMessageDialog(this, "No a grabado este Registro", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else {
            mEntrada_Actualiza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEstadoSegVehItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEstadoSegVeh.getSelectedIndex() != -1) {
            mValidarCF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocCondFocusLost(FocusEvent evt) {
        if (this.JCBTipDocCond.getSelectedIndex() != -1 && !this.JTNoDocCond.getText().isEmpty()) {
            mCargarDatosUsuario(this.xidTDocCond, this.JCBTipDocCond, this.JTNoDocCond, this.JTApellido1Cond, this.JTApellido2Cond, this.JTNom1Cond, this.JTNom2Cond, this.JTNoDirecionCond, this.JTNoTelCond, this.JCBDptoCond, this.JCBMpioCond, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocPropietarioFocusLost(FocusEvent evt) {
        if (this.JCBTipDocPropietario.getSelectedIndex() != -1 && !this.JTNoDocPropietario.getText().isEmpty()) {
            mCargarDatosUsuario(this.xidTDocCond, this.JCBTipDocPropietario, this.JTNoDocPropietario, this.JTApellido1Prop, this.JTApellido2Prop, this.JTNom1Prop, this.JTNom2Prop, this.JTNoDirecionProp, this.JTNoTelProp, this.JCBDptoProp, this.JCBMpioProp, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFuncionarioRKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoDocuFuncionarioKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMpioItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBMpio.getSelectedIndex() != -1) {
            this.JCBMpio_futran2.setSelectedItem(this.JCBMpio.getSelectedItem());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(6, this.JTFPlaca, 2, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoPolizaKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(20, this.JTFNoPoliza, 3, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocPropietarioKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(16, this.JTNoDocPropietario, 4, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido1PropKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(20, this.JTApellido1Prop, 5, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido2PropKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(30, this.JTApellido2Prop, 6, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNom1PropKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(20, this.JTNom1Prop, 7, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNom2PropKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(30, this.JTNom2Prop, 8, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDirecionPropKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(40, this.JTNoDirecionProp, 9, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoTelPropKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(10, this.JTNoTelProp, 10, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocCondKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(16, this.JTNoDocCond, 11, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido1CondKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(20, this.JTApellido1Cond, 12, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTApellido2CondKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(30, this.JTApellido2Cond, 13, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNom1CondKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(20, this.JTNom1Cond, 14, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNom2CondKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(30, this.JTNom2Cond, 15, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDirecionCondKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(40, this.JTNoDirecionCond, 16, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoTelCondKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(10, this.JTNoTelCond, 17, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaVeh2KeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(6, this.JTFPlacaVeh2, 18, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocP2KeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(16, this.JTNoDocP2, 19, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaVeh3KeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(6, this.JTFPlacaVeh3, 20, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocP3KeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(16, this.JTNoDocP3, 21, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDireccionKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(40, this.JTFDireccion, 0, 0);
        if (!this.JTFDireccion.getText().isEmpty()) {
            this.JTDireccionRecogida.setText(this.JTFDireccion.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADescripcionKeyReleased(KeyEvent evt) {
        if (!Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            if (this.JTADescripcion.getText().length() > 255) {
                this.JTADescripcion.setBackground(new Color(255, 85, 111));
                this.JTADescripcion.setForeground(Color.WHITE);
                this.JTADescripcion.setToolTipText("número de caracteres no permitidos");
                this.validarLimite[1][0] = true;
                this.validarLimite[1][1] = this.JTADescripcion;
                return;
            }
            this.JTADescripcion.setBackground(Color.WHITE);
            this.JTADescripcion.setForeground(Color.BLACK);
            this.JTADescripcion.setToolTipText((String) null);
            this.validarLimite[1][0] = false;
            this.validarLimite[1][1] = this.JTADescripcion;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaTransKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(6, this.JTFPlacaTrans, 22, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDesdeTransKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(40, this.JTDesdeTrans, 23, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHastaTransKeyReleased(KeyEvent evt) {
        mValidaLongitudCampos(40, this.JTHastaTrans, 24, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPlacaKeyReleased(KeyEvent evt) {
        if (this.JTPlaca.getText().length() == 6) {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDireccionKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNoDocBusquedaKeyPressed(KeyEvent evt) {
        if (!this.JTNoDocBusqueda.getText().isEmpty()) {
            this.JTBDocumento.setSelected(true);
        } else {
            this.JTBDocumento1.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPlacaBusquedaKeyPressed(KeyEvent evt) {
        if (!this.JTFPlacaBusqueda.getText().isEmpty()) {
            this.JTBPlaca.setSelected(true);
        } else {
            this.JTBDocumento1.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSirasKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSirasKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAgotamientoActionPerformed(ActionEvent evt) {
        if (this.JCHAgotamiento.isSelected()) {
            this.agotamiento = "1";
        } else {
            this.agotamiento = "0";
        }
    }

    private void mValidaLongitudCampos(int xLimite, JTextField xcampo, int num, int tab) {
        if (xcampo.getText().length() > xLimite) {
            xcampo.setBackground(new Color(255, 85, 111));
            xcampo.setForeground(Color.WHITE);
            xcampo.setToolTipText("número de caracteres no permitidos");
            this.validarLimite[num][0] = true;
            this.validarLimite[num][1] = xcampo;
            this.validarLimite[num][2] = Integer.valueOf(tab);
            this.jtextfield[num] = xcampo;
            return;
        }
        if (xcampo.getText().length() <= xLimite) {
            xcampo.setBackground(Color.WHITE);
            xcampo.setForeground(Color.BLACK);
            xcampo.setToolTipText((String) null);
            this.validarLimite[num][0] = false;
            this.validarLimite[num][1] = xcampo;
            this.validarLimite[num][2] = Integer.valueOf(tab);
            this.jtextfield[num] = xcampo;
        }
    }

    private boolean mValidarLimite(int inicio, int fin) {
        boolean b = true;
        int i = inicio;
        while (true) {
            if (i <= fin) {
                if (this.validarLimite[i][0] == null || !((Boolean) this.validarLimite[i][0]).booleanValue()) {
                    i++;
                } else {
                    b = false;
                    JTextField campo = (JTextField) this.validarLimite[i][1];
                    System.out.println("" + campo.getText());
                    JOptionPane.showMessageDialog(this, "Favor verificar el campo " + campo.getName(), "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    campo.requestFocus();
                    this.JTPEventos.setSelectedIndex(((Integer) this.validarLimite[i][2]).intValue());
                    break;
                }
            } else {
                break;
            }
        }
        return b;
    }

    private void mGrabaTrasporte() {
        if (!this.JTFPlacaTrans.getText().isEmpty()) {
            if (this.JCBTipVehTrans.getSelectedIndex() != -1) {
                if (!this.JTDesdeTrans.getText().isEmpty()) {
                    if (!this.JTHastaTrans.getText().isEmpty()) {
                        if (mValidarLimite(22, 24)) {
                            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                String sql = "INSERT INTO  `a_transp_mov` (`Id_eventoecat_persona`,  `Placa`, `SitioEvento`, `FinRecorrido`, `Id_TipoServAmb`,  `ZonaRecogeVict`)  VALUES ('" + this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 6) + "', '" + this.JTFPlacaTrans.getText() + "', '" + this.JTDesdeTrans.getText() + "', '" + this.JTHastaTrans.getText() + "', '" + this.xidTipVehTrans[this.JCBTipVehTrans.getSelectedIndex()] + "', '" + this.xzonaTrans + "');";
                                this.xct.ejecutarSQL(sql);
                                this.xct.cerrarConexionBd();
                                this.JTPEventos.setSelectedIndex(0);
                                this.JTPEventos.setEnabledAt(2, true);
                                this.JTFPlacaTrans.setText("");
                                this.JCBTipVehTrans.setSelectedIndex(-1);
                                this.JTDesdeTrans.setText("");
                                this.JTHastaTrans.setText("");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe Digitar hasta dónde llevó la víctima", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTHastaTrans.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe Digitar dónde fué recogido la víctima", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTDesdeTrans.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de vehiculo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBTipVehTrans.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe digitar la Placa del vehiculo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTFPlacaTrans.requestFocus();
    }

    private void actualizarDatos() {
        if (!this.JTFPlacaTrans.getText().isEmpty()) {
            if (this.JCBTipVehTrans.getSelectedIndex() != -1) {
                if (!this.JTDesdeTrans.getText().isEmpty()) {
                    if (!this.JTHastaTrans.getText().isEmpty()) {
                        if (mValidarLimite(22, 24)) {
                            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de actualziar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                String sql = "UPDATE a_transp_mov SET Placa='" + this.JTFPlacaTrans.getText() + "', SitioEvento='" + this.JTDesdeTrans.getText() + "', FinRecorrido='" + this.JTHastaTrans.getText() + "', Id_TipoServAmb='" + this.xidTipVehTrans[this.JCBTipVehTrans.getSelectedIndex()] + "',  ZonaRecogeVict='" + this.xzonaTrans + "'  WHERE Id_eventoecat_persona=" + this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 6) + "";
                                this.xct.ejecutarSQL(sql);
                                this.xct.cerrarConexionBd();
                                this.JTPEventos.setSelectedIndex(0);
                                this.JTPEventos.setEnabledAt(2, true);
                                this.JTFPlacaTrans.setText("");
                                this.JCBTipVehTrans.setSelectedIndex(-1);
                                this.JTDesdeTrans.setText("");
                                this.JTHastaTrans.setText("");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe Digitar hasta dónde llevó la víctima", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTHastaTrans.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe Digitar dónde fué recogido la víctima", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTDesdeTrans.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de vehiculo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBTipVehTrans.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe digitar la Placa del vehiculo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTFPlacaTrans.requestFocus();
    }

    private void traerDatos() {
        String sql = "SELECT Id_eventoecat_persona,Placa, SitioEvento, FinRecorrido, Id_TipoServAmb,  ZonaRecogeVict from a_transp_mov WHERE Id_eventoecat_persona=" + this.xmodeloPersona.getValueAt(this.JTPersonas.getSelectedRow(), 6) + "";
        System.out.println("Trasnporte: " + sql);
        this.xct.ejecutarSQL(sql);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTFPlacaTrans.setText(xrs.getString("Placa"));
                if (xrs.getString("Id_TipoServAmb").equals("0")) {
                    this.JCBTipVehTrans.setSelectedIndex(0);
                } else {
                    this.JCBTipVehTrans.setSelectedIndex(1);
                }
                if (xrs.getString("ZonaRecogeVict").equals("U")) {
                    this.JRBUrbana.setSelected(true);
                    this.xzona = "U";
                } else {
                    this.JRBRuralz.setSelected(true);
                    this.xzona = "R";
                }
                this.JTDesdeTrans.setText(xrs.getString("SitioEvento"));
                this.JTHastaTrans.setText(xrs.getString("FinRecorrido"));
                this.encotrado = true;
            } else {
                this.encotrado = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPEventoECat.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xct.cerrarConexionBd();
    }

    private void mSubirArchivo() {
        if (!this.xevento.equals("")) {
            if (!this.JTFRuta.getText().isEmpty()) {
                if (this.JCBTipoDocumentoSoporte.getSelectedIndex() != -1) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.directorio = new File(this.xmt.mRutaSoporte("JPEventoECat"));
                        GTipoDocumentoSoporte tipoDocumentoSoporte = new GTipoDocumentoSoporte();
                        tipoDocumentoSoporte.setId(Long.valueOf(this.xidSoporteDoc[this.JCBTipoDocumentoSoporte.getSelectedIndex()]));
                        AEventoecat eventoecat = new AEventoecat();
                        eventoecat.setId(Long.valueOf(this.xevento));
                        AEventoecatSoportedoc eventoecatSoportedoc = new AEventoecatSoportedoc();
                        eventoecatSoportedoc.setIdEvento(eventoecat);
                        eventoecatSoportedoc.setIdTipoDoc(tipoDocumentoSoporte);
                        eventoecatSoportedoc.setUrl("");
                        eventoecatSoportedoc.setEstado(1);
                        eventoecatSoportedoc.setFecha(this.xmt.getFechaActual().toInstant());
                        eventoecatSoportedoc.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        AEventoecatSoportedoc eventoecatSoportedoc2 = this.aEventoecatSoportedocService.save(eventoecatSoportedoc);
                        String adjunto = eventoecatSoportedoc2.getId() + "_" + this.xevento + "_" + this.JCBTipoDocumentoSoporte.getSelectedItem() + ".pdf";
                        eventoecatSoportedoc2.setUrl(this.xmt.mTraerUrlBD(adjunto));
                        this.aEventoecatSoportedocService.save(eventoecatSoportedoc2);
                        File f1 = new File(this.JTFRuta.getText());
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(this.directorio, f2.getName()));
                        System.err.println(this.directorio + f2.getName());
                        if (this.xmt.mExisteArchivo(this.directorio + f2.getName())) {
                            this.aEventoecatSoportedocService.deleteById(eventoecatSoportedoc2.getId());
                            JOptionPane.showMessageDialog(this, "Se a generado un error al momento de cargar el archivo, favor volver a intentarlo ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                        }
                    }
                    mBuscarSoportesEvento(this.xevento);
                    this.JTFRuta.setText("");
                    this.JCBTipoDocumentoSoporte.setSelectedIndex(-1);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipoDocumentoSoporte.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFRuta.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un Evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void mEntrada() {
        if (this.JCBEstadoSegVeh.getSelectedIndex() != -1) {
            if (this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()].equals("3")) {
                if (!this.JTFFHora.getText().isEmpty()) {
                    if (this.JCBTipoEvento.getSelectedIndex() != -1) {
                        if (this.JCBDpto.getSelectedIndex() != -1) {
                            if (this.JCBMpio.getSelectedIndex() != -1) {
                                if (!this.JTFDireccion.getText().isEmpty() && this.JTFDireccion.getBackground().equals(Color.WHITE)) {
                                    if (!this.JTADescripcion.getText().isEmpty()) {
                                        if (this.JCBMarcVeh.getSelectedIndex() != -1) {
                                            if (this.JCBTipVeh.getSelectedIndex() != -1) {
                                                if (this.JCBAseguradora.getSelectedIndex() != -1) {
                                                    if (this.JTNoDirecionProp.getBackground().equals(Color.WHITE)) {
                                                        if (this.JTNoDirecionCond.getBackground().equals(Color.WHITE)) {
                                                            if (mValidarLimite(0, 21)) {
                                                                mGrabar();
                                                                return;
                                                            }
                                                            return;
                                                        } else {
                                                            JOptionPane.showMessageDialog(this, "Dirección del conductor no puede máximo permitido (40 caracteres)", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                            this.JTPEventos.setSelectedIndex(1);
                                                            this.JTNoDirecionCond.requestFocus();
                                                            return;
                                                        }
                                                    }
                                                    JOptionPane.showMessageDialog(this, "Dirección del propietario no puede máximo permitido (40 caracteres)", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                    this.JTPEventos.setSelectedIndex(1);
                                                    this.JTNoDirecionProp.requestFocus();
                                                    return;
                                                }
                                                JOptionPane.showMessageDialog(this, "Debe seleccionar una aseguradora", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                this.JTPEventos.setSelectedIndex(1);
                                                this.JCBTipVeh.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de vehiculo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.JTPEventos.setSelectedIndex(1);
                                            this.JCBTipVeh.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(this, "Debe seleccionar una marca de vehiculo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        this.JTPEventos.setSelectedIndex(1);
                                        this.JCBMarcVeh.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showMessageDialog(this, "Debe digitar una breve descripción del evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JTPEventos.setSelectedIndex(0);
                                    this.JTADescripcion.requestFocus();
                                    return;
                                }
                                JOptionPane.showMessageDialog(this, "Debe digitar la dirección del evento y/o  longitud del campo supera el máximo permitido(40 caracteres)", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JTPEventos.setSelectedIndex(0);
                                this.JTFDireccion.requestFocus();
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Debe Seleccionar el municipio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JTPEventos.setSelectedIndex(0);
                            this.JCBMpio.requestFocus();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe Seleccionar el departamento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTPEventos.setSelectedIndex(0);
                        this.JCBDpto.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe Seleccionar el tipo de evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTPEventos.setSelectedIndex(0);
                    this.JCBTipoEvento.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe digitar la hora", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTPEventos.setSelectedIndex(0);
                this.JTFFHora.requestFocus();
                return;
            }
            if (mValidarLimite(0, 21) && mValidaCamposVacios() && mValidaPoliza()) {
                mGrabar();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar estado del seguro", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTPEventos.setSelectedIndex(1);
        this.JCBEstadoSegVeh.requestFocus();
    }

    private void mGrabarEvento() {
        if (this.JCBTipoEvento.getSelectedIndex() != -1) {
            if (this.JCBMpio.getSelectedIndex() != -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xevento.equals("")) {
                        String sql = "INSERT INTO `a_eventoecat`  (`Id_tipoevento`, `Direccion`, `Fechaeventoecat`, `Horaeventoecat`, `Id_Departamento`, `Id_Munucipio`, `Zona`, `Descripcion`, `UsuarioS`) VALUES ( '" + this.xtipoEvento[this.JCBTipoEvento.getSelectedIndex()] + "',   '" + this.JTFDireccion.getText() + "', '" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "', '" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "', '" + this.xidDpto[this.JCBDpto.getSelectedIndex()] + "', '" + this.xidMpio[this.JCBMpio.getSelectedIndex()] + "', '" + this.xzona + "', '" + this.JTADescripcion.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xevento = this.xct.ejecutarSQLId(sql);
                        mGuardaFurtran(1);
                        return;
                    }
                    mGuardaFurtran(1);
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar municipio donde ocurrio el evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTPEventos.setSelectedIndex(0);
            this.JCBMpio.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar tipo de evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTPEventos.setSelectedIndex(0);
        this.JCBTipoEvento.requestFocus();
    }

    private void mGrabar() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JLB_Evento.getText().isEmpty()) {
                this.xevento = this.xct.ejecutarSQLId("INSERT INTO `a_eventoecat`  (`Id_tipoevento`, `Direccion`, `Fechaeventoecat`, `Horaeventoecat`, `Id_Departamento`, `Id_Munucipio`, `Zona`, `Descripcion`, `UsuarioS`) VALUES ( '" + this.xtipoEvento[this.JCBTipoEvento.getSelectedIndex()] + "',   '" + this.JTFDireccion.getText() + "', '" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "', '" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "', '" + this.xidDpto[this.JCBDpto.getSelectedIndex()] + "', '" + this.xidMpio[this.JCBMpio.getSelectedIndex()] + "', '" + this.xzona + "', '" + this.JTADescripcion.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')");
                this.JLB_Evento.setText(this.xevento);
                String xidTDocProp = "";
                if (this.JCBTipDocPropietario.getSelectedIndex() > 0) {
                    xidTDocProp = this.xidTDocProp[this.JCBTipDocPropietario.getSelectedIndex()];
                }
                String xidDptoProp = this.JCBDptoProp.getSelectedIndex() > 0 ? this.xidDptoProp[this.JCBDptoProp.getSelectedIndex()] : "";
                String xidMpioProp = this.JCBMpioProp.getSelectedIndex() > 0 ? this.xidMpioProp[this.JCBMpioProp.getSelectedIndex()] : "";
                String xidTDocCond = this.JCBTipDocCond.getSelectedIndex() > 0 ? this.xidTDocCond[this.JCBTipDocCond.getSelectedIndex()] : "";
                String xidDptoCond = this.JCBDptoCond.getSelectedIndex() > 0 ? this.xidDptoCond[this.JCBDptoCond.getSelectedIndex()] : "";
                String xidMpioCond = this.JCBMpioCond.getSelectedIndex() > 0 ? this.xidMpioCond[this.JCBMpioCond.getSelectedIndex()] : "";
                if (this.JCBMpioCond.getSelectedIndex() > 0) {
                    xidMpioCond = this.xidMpioCond[this.JCBMpioCond.getSelectedIndex()];
                }
                String sql2 = " insert into `a_accidentetransito`  (`Id_eventoecat`,  `Id_estadoasegveh`,  `Id_marcavehiculo`,  `Placa1Veh`,  `Id_tipovehiculo`,  `Id_aseguradora`,  `NoPoliza`,  `FechaInicPol`, `FechaFinPol`,  `IntAutoridad`, `Placa2Veh`,  `TipodocProp2`,  `NoDocProp2`,  `Placa3Veh`,    `TipodocProp3`,  `NoDocProp3`, `Id_tipodocProp`, `NodocumProp`,   `Apellido1Prop`,  `Apellido2Prop`,  `Nombre1Prop`, `Nombre2Prop`,  `DireccionProp`,  `TelefonoProp`,  `DepartProp`,  `MunicProp`, `Apellido1Cond`,  `Apellido2Cond`,  `Nombre1Cond`,  `Nombre2Cond`,  `tipodocCond`,  `NodocumCond`, `DireccionCond`,  `DepartCond`,  `MunicCond`,  `TelefonoCond`,  Fecha,  `UsuarioS`)  values ('" + this.JLB_Evento.getText() + "', '" + this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()] + "', '" + this.xidMarcaVeh[this.JCBMarcVeh.getSelectedIndex()] + "',  '" + this.JTFPlaca.getText() + "',  '" + this.xidtipoVeh[this.JCBTipVeh.getSelectedIndex()] + "', '" + this.xidAseguradora[this.JCBAseguradora.getSelectedIndex()] + "', '" + this.JTFNoPoliza.getText() + "', '" + this.xmt.formatoAMD.format(this.JDFechaInicioPol.getDate()) + "',  '" + this.xmt.formatoAMD.format(this.JDFechaFinPol.getDate()) + "',  '" + this.xAutoridad + "', '" + this.JTFPlacaVeh2.getText() + "', '" + this.xdoc1 + "',  '" + this.JTNoDocP2.getText() + "', '" + this.JTFPlacaVeh3.getText() + "', '" + this.xdoc2 + "',  '" + this.JTNoDocP3.getText() + "',  '" + xidTDocProp + "',  '" + this.JTNoDocPropietario.getText() + "', '" + this.JTApellido1Prop.getText() + "', '" + this.JTApellido2Prop.getText() + "',  '" + this.JTNom1Prop.getText() + "',  '" + this.JTNom2Prop.getText() + "', '" + this.JTNoDirecionProp.getText() + "', '" + this.JTNoTelProp.getText() + "', '" + xidDptoProp + "',  '" + xidMpioProp + "', '" + this.JTApellido1Cond.getText() + "', '" + this.JTApellido2Cond.getText() + "', '" + this.JTNom1Cond.getText() + "', '" + this.JTNom2Cond.getText() + "', '" + xidTDocCond + "', '" + this.JTNoDocCond.getText() + "', '" + this.JTNoDirecionCond.getText() + "', '" + xidDptoCond + "',  '" + xidMpioCond + "','" + this.JTNoTelCond.getText() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "') ";
                this.xct.ejecutarSQL(sql2);
                mBuscarNumeroRadicado();
                String sql4 = "INSERT INTO `a_eventoecat_paciente` (`Id_Eventoecat`, `Id_Persona`, `Id_condvictima`,Id_Ingreso, NumeroConsecutivoLareclamación ,agotamientoAseguradora )  VALUES ( '" + this.xevento + "', '" + this.xidPersona + "', '" + this.xidCondVict + "','" + this.xIngreso + "','" + this.JLB_NumeroCon.getText() + "','" + this.agotamiento + "')";
                this.xct.ejecutarSQL(sql4);
            } else {
                mBuscarNumeroRadicado();
                String sql = "INSERT INTO `a_eventoecat_paciente` (`Id_Eventoecat`, `Id_Persona`, `Id_condvictima`,Id_Ingreso, NumeroConsecutivoLareclamación , agotamientoAseguradora)  VALUES ( '" + this.xevento + "', '" + this.xidPersona + "', '" + this.xidCondVict + "','" + this.xIngreso + "','" + this.JLB_NumeroCon.getText() + "','" + this.agotamiento + "')";
                System.out.println("victima: " + sql);
                this.xct.ejecutarSQL(sql);
            }
            mBuscarPersonas(this.xevento);
            mBuscarHistorico();
            this.JTPEventos.setSelectedIndex(0);
        }
    }

    private void mEntrada_Actualiza() {
        if (this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()].equals("3")) {
            if (!this.JTFFHora.getText().isEmpty()) {
                if (this.JCBTipoEvento.getSelectedIndex() != -1) {
                    if (this.JCBDpto.getSelectedIndex() != -1) {
                        if (this.JCBMpio.getSelectedIndex() != -1) {
                            if (!this.JTFDireccion.getText().isEmpty()) {
                                if (!this.JTADescripcion.getText().isEmpty()) {
                                    mActualizar();
                                    return;
                                } else {
                                    JOptionPane.showMessageDialog(this, "Debe digitar una breve descripción del evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JTADescripcion.requestFocus();
                                    return;
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Debe digitar la dirección del evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JTFDireccion.requestFocus();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe Seleccionar el municipio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBMpio.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe Seleccionar el departamento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBDpto.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe Seleccionar el tipo de evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipoEvento.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe digitar la hora", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFFHora.requestFocus();
            return;
        }
        if (mValidaCamposVacios()) {
            mActualizar();
        }
    }

    private String mBuscarNumeroRadicado() {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs("SELECT (20-LENGTH(MAX(`a_eventoecat_paciente`.`NumeroConsecutivoLareclamación`))) AS vueltas , MAX(`a_eventoecat_paciente`.`NumeroConsecutivoLareclamación`+1) AS consecutivo FROM `a_eventoecat_paciente`;");
        try {
            if (xrs.next() && xrs.getString("consecutivo") != null) {
                String Caracter = xrs.getString("consecutivo");
                StringBuilder sb = new StringBuilder();
                int cerosNecesarios = 12 - Caracter.length();
                for (int i = 0; i < cerosNecesarios; i++) {
                    sb.append("0");
                }
                this.numeroRadicado = sb.append(xrs.getString("consecutivo")).toString();
                this.JLB_NumeroCon.setText(this.numeroRadicado);
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        System.err.println("" + this.numeroRadicado);
        return this.numeroRadicado;
    }

    private void mActualizar() {
        String sql2;
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de Actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (!this.xevento.equals("")) {
                String sql = "UPDATE `a_eventoecat` SET `Id_tipoevento`= '" + this.xtipoEvento[this.JCBTipoEvento.getSelectedIndex()] + "',`Direccion`='" + this.JTFDireccion.getText() + "',`Fechaeventoecat`='" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "',`Horaeventoecat`='" + this.JTFFHora.getText() + "',`Id_Departamento`='" + this.xidDpto[this.JCBDpto.getSelectedIndex()] + "',`Id_Munucipio`='" + this.xidMpio[this.JCBMpio.getSelectedIndex()] + "',`Zona`='" + this.xzona + "',`Descripcion`='" + this.JTADescripcion.getText() + "',`UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id` = '" + this.xevento + "'";
                ConsultasMySQL xctg = new ConsultasMySQL();
                xctg.ejecutarSQL(sql);
                xctg.cerrarConexionBd();
                String xidTDocProp = "";
                if (this.JCBTipDocPropietario.getSelectedIndex() >= 0) {
                    xidTDocProp = this.xidTDocProp[this.JCBTipDocPropietario.getSelectedIndex()];
                }
                String xidDptoProp = this.JCBDptoProp.getSelectedIndex() >= 0 ? this.xidDptoProp[this.JCBDptoProp.getSelectedIndex()] : "";
                String xidMpioProp = this.JCBMpioProp.getSelectedIndex() >= 0 ? this.xidMpioProp[this.JCBMpioProp.getSelectedIndex()] : "";
                String xidTDocCond = this.JCBTipDocCond.getSelectedIndex() >= 0 ? this.xidTDocCond[this.JCBTipDocCond.getSelectedIndex()] : "";
                String xidDptoCond = this.JCBDptoCond.getSelectedIndex() >= 0 ? this.xidDptoCond[this.JCBDptoCond.getSelectedIndex()] : "";
                String xidMpioCond = this.JCBMpioCond.getSelectedIndex() >= 0 ? this.xidMpioCond[this.JCBMpioCond.getSelectedIndex()] : "";
                if (!verificarExistenciaDeAccidente(this.xevento)) {
                    sql2 = " insert into `a_accidentetransito`  (`Id_eventoecat`,  `Id_estadoasegveh`,  `Id_marcavehiculo`,  `Placa1Veh`,  `Id_tipovehiculo`,  `Id_aseguradora`,  `NoPoliza`,  `FechaInicPol`, `FechaFinPol`,  `IntAutoridad`, `Placa2Veh`,  `TipodocProp2`,  `NoDocProp2`,  `Placa3Veh`,    `TipodocProp3`,  `NoDocProp3`, `Id_tipodocProp`, `NodocumProp`,   `Apellido1Prop`,  `Apellido2Prop`,  `Nombre1Prop`, `Nombre2Prop`,  `DireccionProp`,  `TelefonoProp`,  `DepartProp`,  `MunicProp`, `Apellido1Cond`,  `Apellido2Cond`,  `Nombre1Cond`,  `Nombre2Cond`,  `tipodocCond`,  `NodocumCond`, `DireccionCond`,  `DepartCond`,  `MunicCond`,  `TelefonoCond`,  Fecha,  `UsuarioS`)  values ('" + this.xevento + "', '" + this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()] + "', '" + this.xidMarcaVeh[this.JCBMarcVeh.getSelectedIndex()] + "',  '" + this.JTFPlaca.getText() + "',  '" + this.xidtipoVeh[this.JCBTipVeh.getSelectedIndex()] + "', '" + this.xidAseguradora[this.JCBAseguradora.getSelectedIndex()] + "', '" + this.JTFNoPoliza.getText() + "', '" + this.xmt.formatoAMD.format(this.JDFechaInicioPol.getDate()) + "',  '" + this.xmt.formatoAMD.format(this.JDFechaFinPol.getDate()) + "',  '" + this.xAutoridad + "', '" + this.JTFPlacaVeh2.getText() + "', '" + this.xdoc1 + "',  '" + this.JTNoDocP2.getText() + "', '" + this.JTFPlacaVeh3.getText() + "', '" + this.xdoc2 + "',  '" + this.JTNoDocP3.getText() + "',  '" + xidTDocProp + "',  '" + this.JTNoDocPropietario.getText() + "', '" + this.JTApellido1Prop.getText() + "', '" + this.JTApellido2Prop.getText() + "',  '" + this.JTNom1Prop.getText() + "',  '" + this.JTNom2Prop.getText() + "', '" + this.JTNoDirecionProp.getText() + "', '" + this.JTNoTelProp.getText() + "', '" + xidDptoProp + "',  '" + xidMpioProp + "', '" + this.JTApellido1Cond.getText() + "', '" + this.JTApellido2Cond.getText() + "', '" + this.JTNom1Cond.getText() + "', '" + this.JTNom2Cond.getText() + "', '" + xidTDocCond + "', '" + this.JTNoDocCond.getText() + "', '" + this.JTNoDirecionCond.getText() + "', '" + xidDptoCond + "',  '" + xidMpioCond + "','" + this.JTNoTelCond.getText() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "') ";
                } else {
                    sql2 = " UPDATE `a_accidentetransito` SET `Id_estadoasegveh`=  '" + this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()] + "', `Id_marcavehiculo`= '" + this.xidMarcaVeh[this.JCBMarcVeh.getSelectedIndex()] + "', `Placa1Veh`= '" + this.JTFPlaca.getText() + "', `Id_tipovehiculo`= '" + this.xidtipoVeh[this.JCBTipVeh.getSelectedIndex()] + "', `Id_aseguradora`= '" + this.xidAseguradora[this.JCBAseguradora.getSelectedIndex()] + "', `NoPoliza`= '" + this.JTFNoPoliza.getText() + "', `FechaInicPol`='" + this.xmt.formatoAMD.format(this.JDFechaInicioPol.getDate()) + "', `FechaFinPol`= '" + this.xmt.formatoAMD.format(this.JDFechaFinPol.getDate()) + "', `IntAutoridad`='" + this.xAutoridad + "', `Placa2Veh`= '" + this.JTFPlacaVeh2.getText() + "', `TipodocProp2`= '" + this.xdoc1 + "', `NoDocProp2`= '" + this.JTNoDocP2.getText() + "', `Placa3Veh`= '" + this.JTFPlacaVeh3.getText() + "', `TipodocProp3`= '" + this.xdoc2 + "', `NoDocProp3`='" + this.JTNoDocP3.getText() + "', `Id_tipodocProp`='" + xidTDocProp + "', `NodocumProp`=  '" + this.JTNoDocPropietario.getText() + "', `Apellido1Prop`= '" + this.JTApellido1Prop.getText() + "', `Apellido2Prop`= '" + this.JTApellido2Prop.getText() + "', `Nombre1Prop`='" + this.JTNom1Prop.getText() + "', `Nombre2Prop`= '" + this.JTNom2Prop.getText() + "', `DireccionProp`= '" + this.JTNoDirecionProp.getText() + "', `TelefonoProp`= '" + this.JTNoTelProp.getText() + "', `DepartProp`= '" + xidDptoProp + "', `MunicProp`='" + xidMpioProp + "', `Apellido1Cond`= '" + this.JTApellido1Cond.getText() + "', `Apellido2Cond`= '" + this.JTApellido2Cond.getText() + "', `Nombre1Cond`= '" + this.JTNom1Cond.getText() + "', `Nombre2Cond`= '" + this.JTNom2Cond.getText() + "', `tipodocCond`= '" + xidTDocCond + "', `NodocumCond`= '" + this.JTNoDocCond.getText() + "', `DireccionCond`= '" + this.JTNoDirecionCond.getText() + "', `DepartCond`= '" + xidDptoCond + "', `MunicCond`= '" + xidMpioCond + "', `TelefonoCond`='" + this.JTNoTelCond.getText() + "', `Fecha`= '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id_eventoecat='" + this.xevento + "'";
                    String sql3 = "update a_eventoecat_paciente set Id_condvictima='" + this.xidCondVict + "',NumeroConsecutivoLareclamación='" + this.JLB_NumeroCon.getText() + "', agotamientoAseguradora='" + this.agotamiento + "'where Id_Eventoecat='" + this.xevento + "' and Id_Persona='" + this.xidPersona + "'";
                    System.out.println("victima: " + sql3);
                    this.xct.ejecutarSQL(sql3);
                }
                System.out.println("Accidente : " + sql2);
                xctg.ejecutarSQL(sql2);
                xctg.cerrarConexionBd();
            }
            mBuscarPersonas(this.xevento);
            mBuscarHistorico();
            this.JTPEventos.setSelectedIndex(0);
        }
    }

    private boolean verificarExistenciaDeAccidente(String idEventoECat) {
        boolean existe = false;
        String sql = "SELECT `Id_Eventoecat`  FROM `a_accidentetransito` WHERE `Id_Eventoecat` ='" + idEventoECat + "'";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                existe = true;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existe;
    }

    private void actualizarAgotamiento(String idEventoECat) {
        String sql = "SELECT `Id_Eventoecat`  FROM `a_accidentetransito` WHERE `Id_Eventoecat` ='" + idEventoECat + "'";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mValidaPoliza() {
        boolean xvalidado = false;
        System.err.println("this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()]" + this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()]);
        if (this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()].equals("2") || this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()].equals("7") || !this.JTFNoPoliza.getText().equals("")) {
            xvalidado = true;
        } else {
            JOptionPane.showMessageDialog(this, "Debe escribir el numero de poliza", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTPEventos.setSelectedIndex(1);
            this.JTFNoPoliza.requestFocus();
        }
        return xvalidado;
    }

    private boolean mValidaCamposVacios() {
        boolean xvalidado = false;
        if (!this.JTFFHora.getText().isEmpty()) {
            if (this.JCBTipoEvento.getSelectedIndex() != -1) {
                if (this.JCBDpto.getSelectedIndex() != -1) {
                    if (this.JCBMpio.getSelectedIndex() != -1) {
                        if (!this.JTFDireccion.getText().isEmpty()) {
                            if (!this.JTADescripcion.getText().isEmpty()) {
                                if (this.JCBEstadoSegVeh.getSelectedIndex() != -1) {
                                    if (this.JCBMarcVeh.getSelectedIndex() != -1) {
                                        if (this.JCBTipVeh.getSelectedIndex() != -1) {
                                            if (this.JCBAseguradora.getSelectedIndex() != -1) {
                                                if (this.JCBTipoEvento.getSelectedItem().equals("Accidente de Tránsito")) {
                                                    if (!this.JTFPlaca.getText().isEmpty()) {
                                                        if (this.JCBTipDocPropietario.getSelectedIndex() != -1) {
                                                            if (!this.JTNoDocPropietario.getText().isEmpty()) {
                                                                if (!this.JTApellido1Prop.getText().isEmpty()) {
                                                                    if (!this.JTNom1Prop.getText().isEmpty()) {
                                                                        if (!this.JTNoDirecionProp.getText().isEmpty()) {
                                                                            if (!this.JTNoTelProp.getText().isEmpty()) {
                                                                                if (this.JCBDptoProp.getSelectedIndex() != -1) {
                                                                                    if (this.JCBMpioProp.getSelectedIndex() != -1) {
                                                                                        if (this.JCBTipDocCond.getSelectedIndex() != -1) {
                                                                                            if (!this.JTNoDocCond.getText().isEmpty()) {
                                                                                                if (!this.JTApellido1Cond.getText().isEmpty()) {
                                                                                                    if (!this.JTNom1Cond.getText().isEmpty()) {
                                                                                                        if (!this.JTNoDirecionCond.getText().isEmpty()) {
                                                                                                            if (!this.JTNoTelCond.getText().isEmpty()) {
                                                                                                                if (this.JCBDptoCond.getSelectedIndex() != -1) {
                                                                                                                    if (this.JCBMpioCond.getSelectedIndex() != -1) {
                                                                                                                        xvalidado = true;
                                                                                                                    } else {
                                                                                                                        JOptionPane.showMessageDialog(this, "Debe seleccionar el municipio del conductor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                                                        this.JTPEventos.setSelectedIndex(1);
                                                                                                                        this.JCBMpioCond.requestFocus();
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    JOptionPane.showMessageDialog(this, "Debe seleccionar el departamento del conductor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                                                    this.JTPEventos.setSelectedIndex(1);
                                                                                                                    this.JCBDptoCond.requestFocus();
                                                                                                                }
                                                                                                            } else {
                                                                                                                JOptionPane.showMessageDialog(this, "Debe digitar el teléfono del conductor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                                                this.JTPEventos.setSelectedIndex(1);
                                                                                                                this.JTNoTelCond.requestFocus();
                                                                                                            }
                                                                                                        } else {
                                                                                                            JOptionPane.showMessageDialog(this, "Debe digitar la dirección del conductor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                                            this.JTPEventos.setSelectedIndex(1);
                                                                                                            this.JTNoDirecionCond.requestFocus();
                                                                                                        }
                                                                                                    } else {
                                                                                                        JOptionPane.showMessageDialog(this, "Debe digitar el primer nombre del conductor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                                        this.JTPEventos.setSelectedIndex(1);
                                                                                                        this.JTNom1Cond.requestFocus();
                                                                                                    }
                                                                                                } else {
                                                                                                    JOptionPane.showMessageDialog(this, "Debe digitar el primer apellido del conductor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                                    this.JTPEventos.setSelectedIndex(1);
                                                                                                    this.JTApellido1Cond.requestFocus();
                                                                                                }
                                                                                            } else {
                                                                                                JOptionPane.showMessageDialog(this, "Debe digitar el documento del conductor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                                this.JTPEventos.setSelectedIndex(1);
                                                                                                this.JTNoDocCond.requestFocus();
                                                                                            }
                                                                                        } else {
                                                                                            JOptionPane.showMessageDialog(this, "Debe seleccionar el Tipo de documento del conductor", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                            this.JTPEventos.setSelectedIndex(1);
                                                                                            this.JCBTipDocCond.requestFocus();
                                                                                        }
                                                                                    } else {
                                                                                        JOptionPane.showMessageDialog(this, "Debe seleccionar el municipio del propietario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                        this.JTPEventos.setSelectedIndex(1);
                                                                                        this.JCBMpioProp.requestFocus();
                                                                                    }
                                                                                } else {
                                                                                    JOptionPane.showMessageDialog(this, "Debe seleccionar el departamento del propietario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                    this.JTPEventos.setSelectedIndex(1);
                                                                                    this.JCBDptoProp.requestFocus();
                                                                                }
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(this, "Debe digitar el teléfono del propietario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                                this.JTPEventos.setSelectedIndex(1);
                                                                                this.JTNoTelProp.requestFocus();
                                                                            }
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(this, "Debe digitar la dirección del propietario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                            this.JTPEventos.setSelectedIndex(1);
                                                                            this.JTNoDirecionProp.requestFocus();
                                                                        }
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(this, "Debe digitar el primer nombre del propietario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                        this.JTPEventos.setSelectedIndex(1);
                                                                        this.JTNom1Prop.requestFocus();
                                                                    }
                                                                } else {
                                                                    JOptionPane.showMessageDialog(this, "Debe digitar el primer apellido del propietario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                    this.JTPEventos.setSelectedIndex(1);
                                                                    this.JTApellido1Prop.requestFocus();
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(this, "Debe digitar el documento del propietario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                this.JTPEventos.setSelectedIndex(1);
                                                                this.JTNoDocPropietario.requestFocus();
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(this, "Debe seleccionar el Tipo de documento del propietario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                            this.JTPEventos.setSelectedIndex(1);
                                                            this.JCBTipDocPropietario.requestFocus();
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(this, "Debe digitar la placa del vehículo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                        this.JTPEventos.setSelectedIndex(1);
                                                        this.JTFPlaca.requestFocus();
                                                    }
                                                } else {
                                                    xvalidado = true;
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(this, "Debe seleccionar la aseguradora", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                this.JTPEventos.setSelectedIndex(1);
                                                this.JCBAseguradora.requestFocus();
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de vehiculo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.JTPEventos.setSelectedIndex(1);
                                            this.JCBTipVeh.requestFocus();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Debe seleccionar la marca del vehiculo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        this.JTPEventos.setSelectedIndex(1);
                                        this.JCBMarcVeh.requestFocus();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Debe seleccionar el estado del seguro", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JTPEventos.setSelectedIndex(1);
                                    this.JCBEstadoSegVeh.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Debe digitar una breve descripción del evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JTPEventos.setSelectedIndex(0);
                                this.JTADescripcion.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Debe digitar la dirección del evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JTPEventos.setSelectedIndex(0);
                            this.JTFDireccion.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe Seleccionar el municipio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBMpio.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Debe Seleccionar el departamento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTPEventos.setSelectedIndex(0);
                    this.JCBDpto.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe Seleccionar el tipo de evento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTPEventos.setSelectedIndex(0);
                this.JCBTipoEvento.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe digitar la hora", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTPEventos.setSelectedIndex(0);
            this.JTFFHora.requestFocus();
        }
        return xvalidado;
    }

    private void mLlenarCombos() {
        this.xidDpto = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_departamento` WHERE (`Estado` =0 AND CodPais=169) ORDER BY `Nbre` ASC", this.xidDpto, this.JCBDpto);
        this.JCBDpto.setSelectedIndex(-1);
        this.xidDptoCond = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_departamento` WHERE (`Estado` =0 AND CodPais=169) ORDER BY `Nbre` ASC", this.xidDptoCond, this.JCBDptoCond);
        this.JCBDptoCond.setSelectedIndex(-1);
        this.xidDptoProp = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_departamento` WHERE (`Estado` =0 AND CodPais=169) ORDER BY `Nbre` ASC", this.xidDptoProp, this.JCBDptoProp);
        this.JCBDptoProp.setSelectedIndex(-1);
        String sql = "SELECT  `Id` , `Nbre` FROM `a_tipoevento` WHERE (`Estado` =0 AND `Id_CausaExterna` ='" + this.xidCausaExt + "') ORDER BY `Nbre` ASC;";
        this.xtipoEvento = this.xct.llenarCombo(sql, this.xtipoEvento, this.JCBTipoEvento);
        if (this.xtipoEvento.length > 1) {
            this.JCBTipoEvento.setSelectedIndex(-1);
        }
        this.xidEstadoSeg = this.xct.llenarCombo("SELECT `Id`  , `Nbre` FROM `a_estadoasegveh` WHERE (`Estado` =0) order by Nbre", this.xidEstadoSeg, this.JCBEstadoSegVeh);
        this.JCBEstadoSegVeh.setSelectedIndex(-1);
        this.xidMarcaVeh = this.xct.llenarCombo("SELECT `Id`  , `Nbre` FROM `a_marcavehiculo` WHERE (`Estado` =0) order by Nbre", this.xidMarcaVeh, this.JCBMarcVeh);
        this.JCBMarcVeh.setSelectedIndex(-1);
        this.xidtipoVeh = this.xct.llenarCombo("SELECT `Id`  , `Nbre` FROM `a_tipovehiculo` WHERE (`Estado` =0) order by Nbre", this.xidtipoVeh, this.JCBTipVeh);
        this.JCBTipVeh.setSelectedIndex(-1);
        this.xidAseguradora = this.xct.llenarCombo("SELECT `Id`  , `Nbre` FROM `a_aseguradora`  order by Nbre", this.xidAseguradora, this.JCBAseguradora);
        this.JCBAseguradora.setSelectedIndex(-1);
        this.xidTDocProp = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoidentificacion` WHERE (`Estado` =0) ORDER BY Nbre", this.xidTDocProp, this.JCBTipDocPropietario);
        this.JCBTipDocPropietario.setSelectedIndex(-1);
        this.xidTDocProp2 = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoidentificacion` WHERE (`Estado` =0) ORDER BY Nbre", this.xidTDocProp2, this.JCBTipDocP2);
        this.JCBTipDocP2.setSelectedIndex(-1);
        this.xidTDocProp3 = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoidentificacion` WHERE (`Estado` =0) ORDER BY Nbre", this.xidTDocProp3, this.JCBTipDocP3);
        this.JCBTipDocP3.setSelectedIndex(-1);
        this.xidTDocCond = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoidentificacion` WHERE (`Estado` =0) ORDER BY Nbre", this.xidTDocCond, this.JCBTipDocCond);
        this.JCBTipDocCond.setSelectedIndex(-1);
        this.xidSoporteDoc = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipo_documento_soporte` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xidSoporteDoc, this.JCBTipoDocumentoSoporte);
        this.JCBTipoDocumentoSoporte.setSelectedIndex(-1);
        this.xidTipVehTrans = this.xct.llenarCombo("SELECT `Id`  , `Nbre` FROM `a_tipovehiculo` WHERE (`Estado` =0 AND Id=1 OR Id=2) order by Nbre", this.xidTipVehTrans, this.JCBTipVehTrans);
        this.JCBTipVehTrans.setSelectedIndex(-1);
        this.xidTDocFTrans = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoidentificacion` WHERE (`Estado` =0) ORDER BY Nbre", this.xidTDocFTrans, this.JCBTipDocFutran);
        this.JCBTipDocFutran.setSelectedIndex(-1);
        this.xidDptoFTrans1 = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_departamento` WHERE (`Estado` =0 AND CodPais=169) ORDER BY `Nbre` ASC", this.xidDptoFTrans1, this.JCBDpto_futran);
        this.JCBDpto_futran.setSelectedIndex(-1);
        this.xidDptoFTrans2 = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_departamento` WHERE (`Estado` =0 AND CodPais=169) ORDER BY `Nbre` ASC", this.xidDptoFTrans2, this.JCBDpto_futran2);
        this.JCBDpto_futran2.setSelectedIndex(-1);
        this.xidTerceroRecibe = this.xct.llenarCombo("SELECT `Id`, `RazonSocialCompleta` FROM `cc_terceros` WHERE (`Laboratorio` =1) ORDER BY `RazonSocialCompleta` ASC;", this.xidTerceroRecibe, this.JCBTercero);
        this.JCBTercero.setSelectedIndex(-1);
        this.xidtTipoServicio = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `a_tipovehiculo` WHERE (`Estado` =0) ORDER BY `Id` ASC;", this.xidtTipoServicio, this.JCBTipServicio);
        this.JCBTipServicio.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "TipoEvento", "Fecha", "Hora", "Municipio", "Departamento", "Zona", "Descripción"}) { // from class: Facturacion.JPEventoECat.80
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo2);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(150);
    }

    private void mBuscarHistorico() {
        String sql;
        mCrearModeloHistorico();
        if (this.JTBPlaca.isSelected()) {
            sql = " SELECT  `a_eventoecat`.`Id` , `a_tipoevento`.`Nbre` AS tipo_evento , `a_eventoecat`.`Fechaeventoecat` \n                 , `a_eventoecat`.`Horaeventoecat` , `g_municipio`.`Nbre` AS mpio , `g_departamento`.`Nbre` AS dpto , `a_eventoecat`.`Zona`\n                  , `a_eventoecat`.`Descripcion` \n                 FROM `a_eventoecat`  INNER JOIN `a_tipoevento`   ON (`a_eventoecat`.`Id_tipoevento` = `a_tipoevento`.`Id`)\n                 INNER JOIN `g_municipio`    ON (`a_eventoecat`.`Id_Munucipio` = `g_municipio`.`Id`)\n                 INNER JOIN `g_departamento`   ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n                 LEFT JOIN `a_accidentetransito`  ON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`)\n                 WHERE(a_accidentetransito.`Placa1Veh` LIKE '%" + this.JTFPlacaBusqueda.getText() + "%' AND a_eventoecat.`Estado`=1)\n          GROUP BY `a_eventoecat`.`Id`       ORDER BY `a_eventoecat`.`Fechaeventoecat` DESC";
        } else if (this.JTBDocumento.isSelected()) {
            sql = "SELECT  `a_eventoecat`.`Id` , `a_tipoevento`.`Nbre` AS tipo_evento , `a_eventoecat`.`Fechaeventoecat` \n                 , `a_eventoecat`.`Horaeventoecat` , `g_municipio`.`Nbre` AS mpio , `g_departamento`.`Nbre` AS dpto , `a_eventoecat`.`Zona`\n                  , `a_eventoecat`.`Descripcion` \n                 FROM `a_eventoecat`  INNER JOIN `a_tipoevento`   ON (`a_eventoecat`.`Id_tipoevento` = `a_tipoevento`.`Id`)\n                 INNER JOIN `g_municipio`    ON (`a_eventoecat`.`Id_Munucipio` = `g_municipio`.`Id`)\n                 INNER JOIN `g_departamento`   ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n                 INNER JOIN `a_eventoecat_paciente`  ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n                 LEFT JOIN `g_persona` ON (`a_eventoecat_paciente`.`Id_Persona` = `g_persona`.`Id`)\n                 WHERE(g_persona.`NoDocumento` LIKE '%" + this.JTNoDocBusqueda.getText() + "%' AND a_eventoecat.`Estado`=1)\n    GROUP BY `a_eventoecat`.`Id`             ORDER BY `a_eventoecat`.`Fechaeventoecat` DESC";
        } else {
            sql = "SELECT  `a_eventoecat`.`Id` , `a_tipoevento`.`Nbre` AS tipo_evento , `a_eventoecat`.`Fechaeventoecat`  , `a_eventoecat`.`Horaeventoecat` , `g_municipio`.`Nbre` AS mpio , `g_departamento`.`Nbre` AS dpto , `a_eventoecat`.`Zona`  , `a_eventoecat`.`Descripcion`  FROM `a_eventoecat`  INNER JOIN `a_tipoevento`   ON (`a_eventoecat`.`Id_tipoevento` = `a_tipoevento`.`Id`) INNER JOIN `g_municipio`    ON (`a_eventoecat`.`Id_Munucipio` = `g_municipio`.`Id`) INNER JOIN `g_departamento`   ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`) where (a_eventoecat.`Estado`=1) GROUP BY `a_eventoecat`.`Id` ORDER BY `a_eventoecat`.`Fechaeventoecat` DESC";
        }
        System.out.println("" + sql);
        this.xmt.mEstablecerTextEditor(this.JTHistorico, 7);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo2.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo2.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo2.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo2.setValueAt(xrs.getString(8), n, 7);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloPersonas() {
        this.xmodeloPersona = new DefaultTableModel(new Object[0], new String[]{"Tipo. Doc", "No. Documento", "Nombre Usuario", "Fecha Nac.", "Edad", "Condición", "IdPersonaEvento", "IdPersona", "Fecha Ingreso", "No. Ingreso", "No.Consecutivo"}) { // from class: Facturacion.JPEventoECat.81
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPersonas.setModel(this.xmodeloPersona);
        this.JTPersonas.getColumnModel().getColumn(0).setPreferredWidth(8);
        this.JTPersonas.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTPersonas.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTPersonas.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTPersonas.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTPersonas.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTPersonas.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTPersonas.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTPersonas.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTPersonas.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTPersonas.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTPersonas.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTPersonas.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTPersonas.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTPersonas.getColumnModel().getColumn(10).setPreferredWidth(25);
    }

    private void mBuscarPersonas(String xidEvento) {
        mCrearModeloPersonas();
        mCrearModeloPersonasFurtran();
        String sql = "SELECT  `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento`  , `persona`.`NUsuario`  , `persona`.`FechaNac`  , `persona`.`Edad` , `a_condvictima`.`Nbre` AS condicion, a_eventoecat_paciente.Id , persona.Id_persona, DATE_FORMAT(ingreso.FechaIngreso,'%d-%m-%Y') AS FechaIngreso , a_eventoecat_paciente.Id_Ingreso ,a_eventoecat_paciente.`NumeroConsecutivoLareclamación` FROM `a_eventoecat_paciente`  INNER JOIN `persona`   ON (`a_eventoecat_paciente`.`Id_Persona` = `persona`.`Id_persona`) INNER JOIN `ingreso`  ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `a_condvictima`   ON (`a_eventoecat_paciente`.`Id_condvictima` = `a_condvictima`.`Id`) WHERE (`a_eventoecat_paciente`.`Id_Eventoecat` ='" + xidEvento + "') order by NUsuario ASC";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloPersona.addRow(this.xdato);
                    this.xmodeloPersona.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloPersona.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloPersona.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloPersona.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloPersona.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloPersona.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloPersona.setValueAt(Integer.valueOf(xrs.getInt(7)), n, 6);
                    this.xmodeloPersona.setValueAt(Integer.valueOf(xrs.getInt(8)), n, 7);
                    this.xmodeloPersona.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloPersona.setValueAt(xrs.getString(10), n, 9);
                    this.xmodeloPersona.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloPersonaF.addRow(this.xdato);
                    this.xmodeloPersonaF.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloPersonaF.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloPersonaF.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloPersonaF.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloPersonaF.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloPersonaF.setValueAt(false, n, 5);
                    this.xmodeloPersonaF.setValueAt(xrs.getString("a_eventoecat_paciente.Id"), n, 6);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosEventos() {
        String sql = "SELECT `a_tipoevento`.`Nbre` AS Evento,`a_eventoecat`.`Direccion` , `a_eventoecat`.`Fechaeventoecat` , `a_eventoecat`.`Horaeventoecat`  , `g_departamento`.`Nbre` AS Dpto , `g_municipio`.`Nbre` AS Mpio , `a_eventoecat`.`Zona` , `a_eventoecat`.`Descripcion`  FROM `a_eventoecat`   INNER JOIN `a_tipoevento`  ON (`a_eventoecat`.`Id_tipoevento` = `a_tipoevento`.`Id`)  INNER JOIN `g_municipio`   ON (`a_eventoecat`.`Id_Munucipio` = `g_municipio`.`Id`)  INNER JOIN `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)  WHERE (`a_eventoecat`.`Id` ='" + this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "')";
        System.out.println("Paso 1-->" + sql);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JDFecha.setDate(xrs.getDate("Fechaeventoecat"));
                this.JTFFHora.setText(xrs.getString("Horaeventoecat"));
                this.JCBTipoEvento.setSelectedItem(xrs.getString("Evento"));
                this.JCBDpto.setSelectedItem(xrs.getString("Dpto"));
                this.JCBMpio.setSelectedItem(xrs.getString("Mpio"));
                if (xrs.getString("Zona").equals("U")) {
                    this.JRBUrbana.setSelected(true);
                    this.xzona = "U";
                } else {
                    this.JRBRuralz.setSelected(true);
                    this.xzona = "R";
                }
                this.JTFDireccion.setText(xrs.getString("Direccion"));
                this.JTADescripcion.setText(xrs.getString("Descripcion"));
                String sql2 = "SELECT  `a_estadoasegveh`.`Nbre` AS `EstadoSeg`  , `a_marcavehiculo`.`Nbre` AS `marcaveh`  , `a_accidentetransito`.`Placa1Veh`  , `a_tipovehiculo`.`Nbre` AS `tipoveh`  , `a_aseguradora`.`Nbre` AS `aseguradora`  , `a_accidentetransito`.`NoPoliza`  , `a_accidentetransito`.`FechaInicPol` , `a_accidentetransito`.`FechaFinPol`   , `a_accidentetransito`.`IntAutoridad` , `a_accidentetransito`.`Placa2Veh`  , `g_tipoidentificacion_Prop2`.`Nbre` AS `tdocprop2` , `a_accidentetransito`.`NoDocProp2` , `a_accidentetransito`.`Placa3Veh`  , `g_tipoidentificacion_Prop3`.`Nbre` AS `tdocprop3`  , `a_accidentetransito`.`NoDocProp3` , `g_tipoidentificacion_Prop`.`Nbre` AS `tdocPROP`  , `a_accidentetransito`.`NodocumProp` , `a_accidentetransito`.`Apellido1Prop` , `a_accidentetransito`.`Apellido2Prop`  , `a_accidentetransito`.`Nombre1Prop`  , `a_accidentetransito`.`Nombre2Prop`  , `a_accidentetransito`.`DireccionProp` , `a_accidentetransito`.`TelefonoProp`  , `g_departamento`.`Nbre` AS `dptoPROP` , `g_municipio`.`Nbre` AS `mpioPROP` , `a_accidentetransito`.`Apellido1Cond` , `a_accidentetransito`.`Apellido2Cond` , `a_accidentetransito`.`Nombre1Cond` , `a_accidentetransito`.`Nombre2Cond` , `g_tipoidentificacion_Cond`.`Nbre` AS `tdocCond`  , `a_accidentetransito`.`NodocumCond`  , `a_accidentetransito`.`DireccionCond` , `g_departamento_Cond`.`Nbre` AS `dptoCond` , `g_municipio_Cond`.`Nbre` AS `mpioCond` , `a_accidentetransito`.`TelefonoCond` FROM  `a_accidentetransito`  INNER JOIN  `a_estadoasegveh`   ON (`a_accidentetransito`.`Id_estadoasegveh` = `a_estadoasegveh`.`Id`)  INNER JOIN  `a_marcavehiculo`  ON (`a_accidentetransito`.`Id_marcavehiculo` = `a_marcavehiculo`.`Id`) INNER JOIN  `a_tipovehiculo`  ON (`a_accidentetransito`.`Id_tipovehiculo` = `a_tipovehiculo`.`Id`) INNER JOIN  `a_aseguradora`   ON (`a_accidentetransito`.`Id_aseguradora` = `a_aseguradora`.`Id`) LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop2` ON (`a_accidentetransito`.`TipodocProp2` = `g_tipoidentificacion_Prop2`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop`  ON (`a_accidentetransito`.`Id_tipodocProp` = `g_tipoidentificacion_Prop`.`Id`)  LEFT JOIN  `g_departamento`  ON (`a_accidentetransito`.`DepartProp` = `g_departamento`.`Id`)  LEFT JOIN  `g_municipio`  ON (`a_accidentetransito`.`MunicProp` = `g_municipio`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Cond`  ON (`a_accidentetransito`.`tipodocCond` = `g_tipoidentificacion_Cond`.`Id`)  LEFT JOIN  `g_departamento` AS `g_departamento_Cond`  ON (`a_accidentetransito`.`DepartCond` = `g_departamento_Cond`.`Id`)  LEFT JOIN  `g_municipio` AS `g_municipio_Cond`  ON (`a_accidentetransito`.`MunicCond` = `g_municipio_Cond`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop3`  ON (`a_accidentetransito`.`TipodocProp3` = `g_tipoidentificacion_Prop3`.`Id`)  WHERE (`a_accidentetransito`.`Id_eventoecat` ='" + this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "')";
                System.out.println("Paso 2-->" + sql2);
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet xrs2 = xct2.traerRs(sql2);
                if (xrs2.next()) {
                    xrs2.first();
                    this.JTNoTelCond.setText(xrs2.getString("TelefonoCond"));
                    this.JCBDptoCond.setSelectedItem(xrs2.getString("dptoCond"));
                    this.JCBMpioCond.setSelectedItem(xrs2.getString("mpioCond"));
                    this.JTNoDirecionCond.setText(xrs2.getString("DireccionCond"));
                    this.JTNoDocCond.setText(xrs2.getString("NodocumCond"));
                    this.JCBTipDocCond.setSelectedItem(xrs2.getString("tdocCond"));
                    this.JTNom2Cond.setText(xrs2.getString("Nombre2Cond"));
                    this.JTNom1Cond.setText(xrs2.getString("Nombre1Cond"));
                    this.JTApellido2Cond.setText(xrs2.getString("Apellido2Cond"));
                    this.JTApellido1Cond.setText(xrs2.getString("Apellido1Cond"));
                    this.JCBDptoProp.setSelectedItem(xrs2.getString("dptoPROP"));
                    this.JCBMpioProp.setSelectedItem(xrs2.getString("mpioPROP"));
                    this.JTNoTelProp.setText(xrs2.getString("TelefonoProp"));
                    this.JTNoDirecionProp.setText(xrs2.getString("DireccionProp"));
                    this.JTNom2Prop.setText(xrs2.getString("Nombre2Prop"));
                    this.JTNom1Prop.setText(xrs2.getString("Nombre1Prop"));
                    this.JTApellido2Prop.setText(xrs2.getString("Apellido2Prop"));
                    this.JTApellido1Prop.setText(xrs2.getString("Apellido1Prop"));
                    this.JTNoDocPropietario.setText(xrs2.getString("NodocumProp"));
                    this.JCBTipDocPropietario.setSelectedItem(xrs2.getString("tdocPROP"));
                    this.JTNoDocP3.setText(xrs2.getString("NoDocProp3"));
                    this.JCBTipDocP3.setSelectedItem(xrs2.getString("tdocprop3"));
                    this.JTFPlacaVeh3.setText(xrs2.getString("Placa3Veh"));
                    this.JTNoDocP2.setText(xrs2.getString("NoDocProp2"));
                    this.JCBTipDocP2.setSelectedItem(xrs2.getString("tdocprop2"));
                    this.JTFPlacaVeh2.setText(xrs2.getString("Placa2Veh"));
                    this.JCBEstadoSegVeh.setSelectedItem(xrs2.getString("EstadoSeg"));
                    this.JCBMarcVeh.setSelectedItem(xrs2.getString("marcaveh").toString());
                    this.JCBTipVeh.setSelectedItem(xrs2.getString("tipoveh").toString());
                    this.JTFPlaca.setText(xrs2.getString("Placa1Veh"));
                    if (xrs2.getLong("IntAutoridad") == 1) {
                        this.JRBSi.setSelected(true);
                        this.xAutoridad = 1L;
                    } else {
                        this.JRBNo.setSelected(true);
                        this.xAutoridad = 0L;
                    }
                    this.JCBAseguradora.setSelectedItem(xrs2.getString("aseguradora").toString());
                    this.JTFNoPoliza.setText(xrs2.getString("NoPoliza"));
                    this.JDFechaInicioPol.setDate(xrs2.getDate("FechaInicPol"));
                    this.JDFechaFinPol.setDate(xrs2.getDate("FechaFinPol"));
                }
                xrs2.close();
                xct2.cerrarConexionBd();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEventoECat.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloSoporte() {
        this.xmodeloSoporte = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre Documento", "URL"}) { // from class: Facturacion.JPEventoECat.82
            Class[] types = {Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDocSoporte.setModel(this.xmodeloSoporte);
        this.JTDocSoporte.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTDocSoporte.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDocSoporte.getColumnModel().getColumn(2).setPreferredWidth(150);
    }

    private void mBuscarSoportesEvento(String xEvento) {
        mCrearModeloSoporte();
        String sql = "SELECT `a_eventoecat_soportedoc`.`Id` , `g_tipo_documento_soporte`.`Nbre` , `a_eventoecat_soportedoc`.`URL`  FROM `a_eventoecat_soportedoc`  INNER JOIN `g_tipo_documento_soporte`  ON (`a_eventoecat_soportedoc`.`Id_TipoDoc` = `g_tipo_documento_soporte`.`Id`)  WHERE (`a_eventoecat_soportedoc`.`Id_Evento` ='" + xEvento + "')";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloSoporte.addRow(this.xdato);
                    this.xmodeloSoporte.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloSoporte.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloSoporte.setValueAt(xrs.getString(3), n, 2);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosUsuario(String[] xidTipoDoc, JComboBox xTipoDoc, JTextField xNoDoc, JTextField xApellido1, JTextField xApellido2, JTextField xNombre1, JTextField xNombre2, JTextField xDireccion, JTextField xTel, JComboBox xDpto, JComboBox xMpio, int xtipo) {
        try {
            if (xtipo == 0) {
                this.xSql = "SELECT `g_tipoidentificacion`.`Nbre`, `persona`.`NoDocumento`, `persona`.`Apellido1`, `persona`.`Apellido2`, `persona`.`Nombre1`, `persona`.`Nombre2`, `persona`.`Direccion`, IF((persona.`Telefono` ='' AND persona.`Celular` =''),'',IF((persona.`Telefono` ='' AND persona.`Celular` <>''), persona.`Celular`, IF((persona.`Telefono` <>'' AND persona.`Celular` =''), persona.`Telefono`, persona.`Telefono`))) Telefono , `g_departamento`.`Nbre`, `g_municipio`.`Nbre` FROM  `g_tipoidentificacion` INNER JOIN  `persona`  ON (`g_tipoidentificacion`.`Id` = `persona`.`Id_TipoIdentificacion`) INNER JOIN  `g_municipio` ON (`g_municipio`.`Id` = `persona`.`CodNMunicipio`) INNER JOIN  `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`) WHERE (`persona`.`Id_persona` ='" + this.xidPersona + "') ";
            } else {
                this.xSql = "SELECT `g_tipoidentificacion`.`Nbre`, `persona`.`NoDocumento`, `persona`.`Apellido1`, `persona`.`Apellido2`, `persona`.`Nombre1`, `persona`.`Nombre2`, `persona`.`Direccion`, IF((persona.`Telefono` ='' AND persona.`Celular` =''),'',IF((persona.`Telefono` ='' AND persona.`Celular` <>''), persona.`Celular`, IF((persona.`Telefono` <>'' AND persona.`Celular` =''), persona.`Telefono`, persona.`Telefono`))) Telefono, `g_departamento`.`Nbre`, `g_municipio`.`Nbre` \nFROM  `g_tipoidentificacion` INNER JOIN  `persona`  ON (`g_tipoidentificacion`.`Id` = `persona`.`Id_TipoIdentificacion`) \nINNER JOIN  `g_municipio` ON (`g_municipio`.`Id` = `persona`.`CodNMunicipio`) INNER JOIN  `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`) \nWHERE (`persona`.`NoDocumento` ='" + xNoDoc.getText() + "' AND `persona`.`Id_TipoIdentificacion`='" + xidTipoDoc[xTipoDoc.getSelectedIndex()] + "')";
            }
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = xct1.traerRs(this.xSql);
            if (xrs.next()) {
                xrs.first();
                xTipoDoc.setSelectedItem(xrs.getString(1));
                xNoDoc.setText(xrs.getString(2));
                xApellido1.setText(xrs.getString(3));
                xApellido2.setText(xrs.getString(4));
                xNombre1.setText(xrs.getString(5));
                xNombre2.setText(xrs.getString(6));
                xDireccion.setText(xrs.getString(7));
                xTel.setText(xrs.getString(8));
                xDpto.setSelectedItem(xrs.getString(9));
                xMpio.setSelectedItem(xrs.getString(10));
            } else {
                xApellido1.setText("");
                xApellido2.setText("");
                xNombre1.setText("");
                xNombre2.setText("");
                xDireccion.setText("");
                xTel.setText("");
                xMpio.removeAllItems();
                xDpto.setSelectedIndex(-1);
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEventoECat.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGuardaFurtran(int xFiltro) {
        if (xFiltro == 1) {
            if (!this.xevento.equals("")) {
                if (this.JCBTipServicio.getSelectedIndex() != -1) {
                    if (!this.JTPlaca.getText().isEmpty()) {
                        if (this.JCBDpto_futran.getSelectedIndex() != -1) {
                            if (this.JCBMpio_futran.getSelectedIndex() != -1) {
                                if (!this.JTDireccionRecogida.getText().isEmpty()) {
                                    if (this.JCBDpto_futran2.getSelectedIndex() != -1) {
                                        if (this.JCBMpio_futran2.getSelectedIndex() != -1) {
                                            if (this.JCBTercero.getSelectedIndex() != -1) {
                                                if (this.JTPerFutran.getRowCount() > 0) {
                                                    String sql = "INSERT INTO `a_furtran`\n            ( `IdEvento`, `FechaR`, `NEmpresaT`, `CodHabil`, `Apellido1`,\n             `Apellido2`, `Nombre1`, `Nombre2`, `TDocumento`, `NumDocumento`, `TServicio`,\n             `CualServ`, `Placa`, `Direccion`, `Telefono`, `IdDepartamento`, `IdMunicipio`,\n             `DireccionRec`, `IdDepartamentoRec`, `IdMunicipioRec`, `Zona`, IdTerceroRecibe, Nombre_Funcionario, IdTipoServicio, Documento_Funcionario, `UsuarioS`)\n VALUES ( '" + this.xevento + "', '" + this.xmt.formatoAMD1.format(this.JDFechaFurt.getDate()) + " " + this.JTFFHora.getText() + "', '" + this.JTNEmpresa.getText().toUpperCase() + "', '" + this.JTCodHabilitacion.getText() + "', '" + this.JTApellido1.getText().toUpperCase() + "',\n        '" + this.JTApellido2.getText().toUpperCase() + "', '" + this.JTNombre1.getText().toUpperCase() + "',  '" + this.JTNombre2.getText().toUpperCase() + "', '" + this.xidTDocFTrans[this.JCBTipDocFutran.getSelectedIndex()] + "',  '" + this.JTNoDocuFutran.getText() + "', '" + this.JCBTipServicio.getSelectedItem() + "',\n        '" + this.JTOtroServicio.getText() + "', '" + this.JTPlaca.getText().toUpperCase() + "', '" + this.JTDireccion.getText() + "', '" + this.JTTel.getText() + "', '" + this.xidDptoFTrans1[this.JCBDpto_futran.getSelectedIndex()] + "', '" + this.xidMPioFtrans1[this.JCBMpio_futran.getSelectedIndex()] + "',\n        '" + this.JTDireccionRecogida.getText() + "', '" + this.xidDptoFTrans2[this.JCBDpto_futran2.getSelectedIndex()] + "', '" + this.xidMPioFtrans2[this.JCBMpio_futran2.getSelectedIndex()] + "', '" + this.xzonaFutrans + "', '" + this.xidTerceroRecibe[this.JCBTercero.getSelectedIndex()] + "', '" + this.JTFFuncionarioR.getText() + "', '" + this.xidtTipoServicio[this.JCBTipServicio.getSelectedIndex()] + "', '" + this.JTFNoDocuFuncionario.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                    String xidFurtran = this.xct.ejecutarSQLId(sql);
                                                    this.xct.cerrarConexionBd();
                                                    this.xct.cerrarConexionBd();
                                                    String sql2 = "INSERT INTO `a_eventoecat_paciente` (`Id_Eventoecat`, `Id_Persona`, `Id_condvictima`,Id_Ingreso, NumeroConsecutivoLareclamación, agotamientoAseguradora)  VALUES ( '" + this.xevento + "', '" + this.xidPersona + "', '" + this.xidCondVict + "','" + this.xIngreso + "','" + this.JLB_NumeroCon.getText() + "','" + this.agotamiento + "')";
                                                    String xIdEventoPac = this.xct.ejecutarSQLId(sql2);
                                                    this.xct.cerrarConexionBd();
                                                    String sql22 = "INSERT INTO  `a_furtran_persona` (`IdPersonaEvento`, `IdFurtran`) VALUES ('" + xIdEventoPac + "',  '" + xidFurtran + "');";
                                                    this.xct.ejecutarSQL(sql22);
                                                    this.xct.cerrarConexionBd();
                                                    mBuscarPersonas(this.xevento);
                                                    mBuscarFurtran(this.xevento);
                                                    return;
                                                }
                                                JOptionPane.showMessageDialog(this, "No hay víctimas en la Tabla", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                return;
                                            }
                                            JOptionPane.showMessageDialog(this, "Debe seleccionar la empresa que recibira a la(s) victima(s)", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.JCBTercero.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(this, "Debe seleccionar el municipio donde recogió las víctimas", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        this.JCBMpio_futran2.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showMessageDialog(this, "Debe seleccionar el departamento donde recogió las víctimas", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JCBDpto_futran2.requestFocus();
                                    return;
                                }
                                JOptionPane.showMessageDialog(this, "Debe digitar la dirección donde recogió las víctimas", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JTDireccionRecogida.requestFocus();
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Debe selccionar el Municipio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JCBMpio_futran.requestFocus();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe selccionar el departamento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBDpto_futran.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe digitar la placa del vehículo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTPlaca.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de servicio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipServicio.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe cargar un Furips", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        if (!this.xevento.equals("")) {
            if (!this.JTApellido1.getText().isEmpty()) {
                if (!this.JTNombre1.getText().isEmpty()) {
                    if (this.JCBTipDocFutran.getSelectedIndex() != -1) {
                        if (!this.JTNoDocuFutran.getText().isEmpty()) {
                            if (this.JCBTipServicio.getSelectedIndex() != -1) {
                                if (!this.JTPlaca.getText().isEmpty()) {
                                    if (this.JCBDpto_futran.getSelectedIndex() != -1) {
                                        if (this.JCBMpio_futran.getSelectedIndex() != -1) {
                                            if (!this.JTDireccionRecogida.getText().isEmpty()) {
                                                if (this.JCBDpto_futran2.getSelectedIndex() != -1) {
                                                    if (this.JCBMpio_futran2.getSelectedIndex() != -1) {
                                                        if (this.JCBTercero.getSelectedIndex() != -1) {
                                                            if (this.JTPerFutran.getRowCount() > 0) {
                                                                if (this.xmt.mVerificarDatosTablaTrue(this.JTPerFutran, 5)) {
                                                                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                                    if (n == 0) {
                                                                        String sql3 = "INSERT INTO `a_furtran`\n            ( `IdEvento`, `FechaR`, `NEmpresaT`, `CodHabil`, `Apellido1`,\n             `Apellido2`, `Nombre1`, `Nombre2`, `TDocumento`, `NumDocumento`, `TServicio`,\n             `CualServ`, `Placa`, `Direccion`, `Telefono`, `IdDepartamento`, `IdMunicipio`,\n             `DireccionRec`, `IdDepartamentoRec`, `IdMunicipioRec`, `Zona`, IdTerceroRecibe, Nombre_Funcionario, IdTipoServicio, Documento_Funcionario, `UsuarioS`)\n VALUES ( '" + this.xevento + "', '" + this.xmt.formatoAMDH24.format(this.JDFechaFurt.getDate()) + "', '" + this.JTNEmpresa.getText().toUpperCase() + "', '" + this.JTCodHabilitacion.getText() + "', '" + this.JTApellido1.getText().toUpperCase() + "',\n        '" + this.JTApellido2.getText().toUpperCase() + "', '" + this.JTNombre1.getText().toUpperCase() + "',  '" + this.JTNombre2.getText().toUpperCase() + "', '" + this.xidTDocFTrans[this.JCBTipDocFutran.getSelectedIndex()] + "',  '" + this.JTNoDocuFutran.getText() + "', '" + this.JCBTipServicio.getSelectedItem() + "',\n        '" + this.JTOtroServicio.getText() + "', '" + this.JTPlaca.getText().toUpperCase() + "', '" + this.JTDireccion.getText() + "', '" + this.JTTel.getText() + "', '" + this.xidDptoFTrans1[this.JCBDpto_futran.getSelectedIndex()] + "', '" + this.xidMPioFtrans1[this.JCBMpio_futran.getSelectedIndex()] + "',\n        '" + this.JTDireccionRecogida.getText() + "', '" + this.xidDptoFTrans2[this.JCBDpto_futran2.getSelectedIndex()] + "', '" + this.xidMPioFtrans2[this.JCBMpio_futran2.getSelectedIndex()] + "', '" + this.xzonaFutrans + "', '" + this.xidTerceroRecibe[this.JCBTercero.getSelectedIndex()] + "', '" + this.JTFFuncionarioR.getText() + "', '" + this.xidtTipoServicio[this.JCBTipServicio.getSelectedIndex()] + "', '" + this.JTFNoDocuFuncionario.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                                        String xidFurtran2 = this.xct.ejecutarSQLId(sql3);
                                                                        this.xct.cerrarConexionBd();
                                                                        for (int i = 0; i < this.JTPerFutran.getRowCount(); i++) {
                                                                            if (Boolean.valueOf(this.xmodeloPersonaF.getValueAt(i, 5).toString()).booleanValue()) {
                                                                                String sql23 = "INSERT INTO  `a_furtran_persona` (`IdPersonaEvento`, `IdFurtran`) VALUES ('" + this.xmodeloPersonaF.getValueAt(i, 6) + "',  '" + xidFurtran2 + "');";
                                                                                this.xct.ejecutarSQL(sql23);
                                                                                this.xct.cerrarConexionBd();
                                                                            }
                                                                        }
                                                                        mBuscarFurtran(this.xevento);
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                JOptionPane.showMessageDialog(this, "Debe seleccionar las víctimas", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                                return;
                                                            }
                                                            JOptionPane.showMessageDialog(this, "No hay víctimas en la Tabla", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                            return;
                                                        }
                                                        JOptionPane.showMessageDialog(this, "Debe seleccionar la empresa que recibira a la(s) victima(s)", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                        this.JCBTercero.requestFocus();
                                                        return;
                                                    }
                                                    JOptionPane.showMessageDialog(this, "Debe seleccionar el municipio donde recogió las víctimas", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                    this.JCBMpio_futran2.requestFocus();
                                                    return;
                                                }
                                                JOptionPane.showMessageDialog(this, "Debe seleccionar el departamento donde recogió las víctimas", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                this.JCBDpto_futran2.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showMessageDialog(this, "Debe digitar la dirección donde recogió las víctimas", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.JTDireccionRecogida.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(this, "Debe selccionar el Municipio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        this.JCBMpio_futran.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showMessageDialog(this, "Debe selccionar el departamento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JCBDpto_futran.requestFocus();
                                    return;
                                }
                                JOptionPane.showMessageDialog(this, "Debe digitar la placa del vehículo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JTPlaca.requestFocus();
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de servicio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JCBTipServicio.requestFocus();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe digitar el numero de documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTNoDocuFutran.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBTipDocFutran.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe digitar el primer nombre", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTNombre1.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe digitar el primer apellido", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTApellido1.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Furips", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloPersonasFurtran() {
        this.xmodeloPersonaF = new DefaultTableModel(new Object[0], new String[]{"Tipo. Doc", "No. Documento", "Nombre Usuario", "Fecha Nac.", "Edad", "Víctima?", "IdPaciente"}) { // from class: Facturacion.JPEventoECat.83
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPerFutran.setModel(this.xmodeloPersonaF);
        this.JTPerFutran.getColumnModel().getColumn(0).setPreferredWidth(8);
        this.JTPerFutran.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTPerFutran.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTPerFutran.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTPerFutran.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTPerFutran.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTPerFutran.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTPerFutran.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTPerFutran.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistoricoFurtran() {
        this.xmodeloHistoricoF = new DefaultTableModel(new Object[0], new String[]{"Cod.", "Fecha", "Empresa", "Usuario", "Documento"}) { // from class: Facturacion.JPEventoECat.84
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPerFutranHistorico.setModel(this.xmodeloHistoricoF);
        this.JTPerFutranHistorico.getColumnModel().getColumn(0).setPreferredWidth(8);
        this.JTPerFutranHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTPerFutranHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTPerFutranHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTPerFutranHistorico.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mBuscarFurtran(String xEvento) {
        mCrearModeloHistoricoFurtran();
        String sql = "SELECT `Id` , `FechaR` , `NEmpresaT` , CONCAT(`Apellido1`, '' ,`Apellido2`, ' ',`Nombre1`, ' ',`Nombre2`) AS Usuario, `NumDocumento` FROM `a_furtran` WHERE (`IdEvento` ='" + xEvento + "' AND `Estado` =1) ORDER BY `FechaR` DESC;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloHistoricoF.addRow(this.xdato);
                    this.xmodeloHistoricoF.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloHistoricoF.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloHistoricoF.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloHistoricoF.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloHistoricoF.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public static void setEnableContainer(Container c, boolean band) {
        Container[] components = c.getComponents();
        c.setEnabled(band);
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(band);
            if (components[i] instanceof Container) {
                setEnableContainer(components[i], band);
            }
        }
    }

    private void mValidarCF() {
        if (this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()].equals("3") || this.xidEstadoSeg[this.JCBEstadoSegVeh.getSelectedIndex()].equals("5")) {
            this.JCBMarcVeh.setSelectedItem("");
            this.JCBTipVeh.setSelectedItem("");
            this.JCBAseguradora.setSelectedItem("");
            setEnableContainer(this.JPAccidente, false);
            setEnableContainer(this.JCBEstadoSegVeh, true);
            setEnableContainer(this.JCBMarcVeh, true);
            setEnableContainer(this.JCBTipVeh, true);
            setEnableContainer(this.JCBAseguradora, true);
            return;
        }
        setEnableContainer(this.JPAccidente, true);
    }

    private void mConsultarFechayHoraIngreso() {
        String sql = "SELECT `FechaIngreso` , `HoraIngreso` FROM `ingreso` WHERE (`Id` ='" + this.xIngreso + "');";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                this.JDFecha.setDate(xrs.getDate(1));
                this.JTFFHora.setValue(xrs.getTime(2));
                this.JDFechaFurt.setDate(xrs.getDate(1));
            } else {
                this.JDFecha.setDate(this.xmt.getFechaActual());
                this.JTFFHora.setValue(this.xmt.getFechaActualPC());
                this.JDFechaFurt.setDate(this.xmt.getFechaActual());
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
