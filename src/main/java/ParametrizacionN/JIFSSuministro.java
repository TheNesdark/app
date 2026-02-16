package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDGenerico1Combo1Check;
import com.genoma.plus.controller.general.JIFConcentracion;
import com.genoma.plus.controller.parametrizacion.JD_CuestionariosSuministros;
import com.genoma.plus.jpa.entities.ISuministro;
import com.genoma.plus.jpa.service.ISuministroService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
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
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSSuministro.class */
public class JIFSSuministro extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    public String[][] xidtipoproducto;
    public String[][] xidcategoria;
    public String[] xidprincipioactivo;
    public String[] xidunidadmedida;
    public String[] xidpresentacionf;
    public String[] xidpresentacionc;
    public String[] xidviaadministracion;
    public String[] xidconcentracion;
    public String[] xidlaboratorio;
    public String[] xidprioridad;
    public String[] xidcasificacion;
    public String[] xidLasa;
    public String[] xidtipomedicamento;
    public String[] xidunidadminimadispensacion;
    public JIFSPrincipoActivo xjifprincipioactivo;
    public JIFSPresentacionFarmaceuta xjifpresentaconfarmaceutica;
    public JIFGenerico1CheckBox xjifgenerico;
    public JIFGenerico2CheckBox xjifgenericoch2;
    public JIFConcentracion xjifconcentracion;
    private ISuministro suministro;
    private int IdSuministro;
    private boolean lleno;
    private ButtonGroup JBGOpciones;
    private JButton JBTAreaLab;
    private JButton JBTAreaLab1;
    private JButton JBTProcedimientoCosto;
    private JButton JBTProcedimientoTarifa;
    private JButton JBTTarifaMP;
    private JButton JBTTipoFormula;
    private JButton JBTViaAdministracion;
    private JButton JBTViaAdministracion1;
    private JButton JBTViaAdministracion2;
    private JComboBox JCBCategoria;
    private JComboBox JCBClaLasa;
    private JComboBox JCBClasificacion;
    public JComboBox JCBConcentracion;
    public JComboBox JCBLaboratorio;
    public JComboBox JCBPComercial;
    public JComboBox JCBPFarmaceutica;
    public JComboBox JCBPrincipioActivo;
    private JComboBox JCBPrioridad;
    private JComboBox JCBTipoMedicamento;
    private JComboBox JCBTipoProducto;
    private JComboBox JCBUnidadMedida;
    private JComboBox JCBUnidadMinimaDispensacion;
    private JComboBox JCBViaAdministracion;
    private JCheckBox JCHActivo;
    private JCheckBox JCHActivoHC;
    private JCheckBox JCHCCompleta;
    private JCheckBox JCHCREnteControl;
    private JCheckBox JCHCTemperaura;
    private JCheckBox JCHCobrable;
    private JCheckBox JCHComienza;
    private JCheckBox JCHContiene;
    private JCheckBox JCHCosultarT;
    private JCheckBox JCHLogoSueno;
    private JCheckBox JCHMaterial;
    private JCheckBox JCHPos;
    private JCheckBox JCH_ValoresDefecto;
    public JDateChooser JDFFechaVInvima;
    private JPanel JPIDatos;
    private JPanel JPIDatosAdicional;
    private JPanel JPIDatosBusqueda;
    private JPanel JPIDatosP;
    private JTabbedPane JPIDatosS;
    private JPanel JPI_DatosAdional2;
    private JSpinner JSPCantidadE;
    private JSpinner JSPCantidadU;
    private JScrollPane JSPContraIndicaciones1;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPIndicacion;
    private JScrollPane JSPInteracciones1;
    private JSpinner JSPIva;
    private JScrollPane JSPReaccionesAdversas;
    private JSpinner JSPTMaxima;
    private JSpinner JSPTMinima;
    private JSpinner JSPValorMP;
    private JSpinner JSPValorPLM;
    private JScrollPane JSP_Ctc_Casuistica;
    private JScrollPane JSP_Ctc_Evidencia;
    private JScrollPane JSP_Ctc_Justificacion;
    private JScrollPane JSP_Ctc_Precauciones;
    private JSpinner JSP_VUtil;
    private JTextArea JTAContraIndicaciones;
    private JTextArea JTAIndicacion;
    private JTextArea JTAInteracciones;
    private JTextArea JTAReaccionesAdversas;
    private JTextArea JTA_Ctc_Casuistica;
    private JTextArea JTA_Ctc_Evidencia;
    private JTextArea JTA_Ctc_Justificacion;
    private JTextArea JTA_Ctc_Precauciones;
    private JTable JTDetalle;
    private JTextField JTFCodigoAtc;
    private JTextField JTFCodigoBarra;
    private JTextField JTFCodigoBarraEmba;
    private JTextField JTFCodigoCum;
    private JTextField JTFCodigoIUM;
    private JTextField JTFInvima;
    private JTextField JTFNombreBusqueda;
    private JTextField JTFNombreSuministro;
    private JTextField JTFV2463;
    private JTabbedPane JTPDatosP;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xcajacompleta = 0;
    private int xcontroltemp = 0;
    private int xrcontrol = 0;
    private int xtipobusqueda = 0;
    private int xpos = 0;
    private int xactivo = 1;
    private int xactivohc = 0;
    private int xmaterial = 1;
    private int xcobrable = 0;
    private String xurl = null;
    private final ISuministroService suministroService = (ISuministroService) Principal.contexto.getBean(ISuministroService.class);

    public JIFSSuministro() {
        initComponents();
        this.JTPDatosP.removeTabAt(2);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v337, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatosS = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JTPDatosP = new JTabbedPane();
        this.JPIDatosP = new JPanel();
        this.JTFCodigoBarra = new JTextField();
        this.JTFCodigoBarraEmba = new JTextField();
        this.JTFCodigoCum = new JTextField();
        this.JSPCantidadU = new JSpinner();
        this.JTFNombreSuministro = new JTextField();
        this.JSPCantidadE = new JSpinner();
        this.JCHCCompleta = new JCheckBox();
        this.JCBPrincipioActivo = new JComboBox();
        this.JCBUnidadMedida = new JComboBox();
        this.JCBPFarmaceutica = new JComboBox();
        this.JCBViaAdministracion = new JComboBox();
        this.JCBPComercial = new JComboBox();
        this.JCBConcentracion = new JComboBox();
        this.JCBLaboratorio = new JComboBox();
        this.JCBCategoria = new JComboBox();
        this.JTFInvima = new JTextField();
        this.JCBTipoProducto = new JComboBox();
        this.JDFFechaVInvima = new JDateChooser();
        this.JSP_VUtil = new JSpinner();
        this.JCBTipoMedicamento = new JComboBox();
        this.JCBUnidadMinimaDispensacion = new JComboBox();
        this.JPIDatosAdicional = new JPanel();
        this.JCBPrioridad = new JComboBox();
        this.JCHPos = new JCheckBox();
        this.JCHActivo = new JCheckBox();
        this.JCHActivoHC = new JCheckBox();
        this.JCHMaterial = new JCheckBox();
        this.JCHCobrable = new JCheckBox();
        this.JSPIva = new JSpinner();
        this.JCHLogoSueno = new JCheckBox();
        this.JCBClasificacion = new JComboBox();
        this.JSPValorMP = new JSpinner();
        this.JSPValorPLM = new JSpinner();
        this.JSPTMinima = new JSpinner();
        this.JSPTMaxima = new JSpinner();
        this.JCHCTemperaura = new JCheckBox();
        this.JCHCREnteControl = new JCheckBox();
        this.JTFCodigoAtc = new JTextField();
        this.JSPIndicacion = new JScrollPane();
        this.JTAIndicacion = new JTextArea();
        this.JSPContraIndicaciones1 = new JScrollPane();
        this.JTAContraIndicaciones = new JTextArea();
        this.JSPInteracciones1 = new JScrollPane();
        this.JTAInteracciones = new JTextArea();
        this.JCBClaLasa = new JComboBox();
        this.JTFV2463 = new JTextField();
        this.JSPReaccionesAdversas = new JScrollPane();
        this.JTAReaccionesAdversas = new JTextArea();
        this.JTFCodigoIUM = new JTextField();
        this.JPI_DatosAdional2 = new JPanel();
        this.JSP_Ctc_Justificacion = new JScrollPane();
        this.JTA_Ctc_Justificacion = new JTextArea();
        this.JSP_Ctc_Evidencia = new JScrollPane();
        this.JTA_Ctc_Evidencia = new JTextArea();
        this.JSP_Ctc_Casuistica = new JScrollPane();
        this.JTA_Ctc_Casuistica = new JTextArea();
        this.JSP_Ctc_Precauciones = new JScrollPane();
        this.JTA_Ctc_Precauciones = new JTextArea();
        this.JBTProcedimientoTarifa = new JButton();
        this.JBTTarifaMP = new JButton();
        this.JBTProcedimientoCosto = new JButton();
        this.JBTAreaLab = new JButton();
        this.JBTAreaLab1 = new JButton();
        this.JBTTipoFormula = new JButton();
        this.JBTViaAdministracion = new JButton();
        this.JBTViaAdministracion1 = new JButton();
        this.JCH_ValoresDefecto = new JCheckBox();
        this.JBTViaAdministracion2 = new JButton();
        this.jPanel1 = new JPanel();
        this.JPIDatosBusqueda = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.JCHComienza = new JCheckBox();
        this.JCHContiene = new JCheckBox();
        this.JCHCosultarT = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUMINISTRO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifsuministro");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFSSuministro.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSSuministro.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatosS.setForeground(new Color(0, 103, 0));
        this.JPIDatosS.setFont(new Font("Arial", 1, 14));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPDatosP.setForeground(Color.red);
        this.JTPDatosP.setFont(new Font("Arial", 1, 14));
        this.JTFCodigoBarra.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoBarra.setToolTipText("");
        this.JTFCodigoBarra.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Barra Unidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoBarra.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFSSuministro.2
            public void focusLost(FocusEvent evt) {
                JIFSSuministro.this.JTFCodigoBarraFocusLost(evt);
            }
        });
        this.JTFCodigoBarra.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.3
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JTFCodigoBarraKeyPressed(evt);
            }
        });
        this.JTFCodigoBarraEmba.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoBarraEmba.setToolTipText("");
        this.JTFCodigoBarraEmba.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Barra Embalaje", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoBarraEmba.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.4
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JTFCodigoBarraEmbaKeyPressed(evt);
            }
        });
        this.JTFCodigoCum.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoCum.setToolTipText("");
        this.JTFCodigoCum.setBorder(BorderFactory.createTitledBorder((Border) null, "Código CUM", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoCum.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.5
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JTFCodigoCumKeyPressed(evt);
            }
        });
        this.JSPCantidadU.setFont(new Font("Arial", 1, 12));
        this.JSPCantidadU.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPCantidadU.setToolTipText("Cantidad x Unidad");
        this.JSPCantidadU.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad U.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCantidadU.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.6
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JSPCantidadUKeyPressed(evt);
            }
        });
        this.JTFNombreSuministro.setFont(new Font("Arial", 1, 12));
        this.JTFNombreSuministro.setToolTipText("");
        this.JTFNombreSuministro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Suministro o Dispositivo Médico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreSuministro.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.7
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JTFNombreSuministroKeyPressed(evt);
            }
        });
        this.JSPCantidadE.setFont(new Font("Arial", 1, 12));
        this.JSPCantidadE.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPCantidadE.setToolTipText("Cantidad x Blister");
        this.JSPCantidadE.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant por Blister.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCantidadE.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.8
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JSPCantidadEKeyPressed(evt);
            }
        });
        this.JCHCCompleta.setFont(new Font("Arial", 1, 12));
        this.JCHCCompleta.setText("Caja Compla?");
        this.JCHCCompleta.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.9
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHCCompletaActionPerformed(evt);
            }
        });
        this.JCBPrincipioActivo.setFont(new Font("Arial", 1, 12));
        this.JCBPrincipioActivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Principio Activo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPrincipioActivo.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.10
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JCBPrincipioActivoMouseClicked(evt);
            }
        });
        this.JCBPrincipioActivo.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.11
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JCBPrincipioActivoKeyPressed(evt);
            }
        });
        this.JCBUnidadMedida.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadMedida.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Medida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadMedida.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.12
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JCBUnidadMedidaMouseClicked(evt);
            }
        });
        this.JCBUnidadMedida.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.13
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JCBUnidadMedidaKeyPressed(evt);
            }
        });
        this.JCBPFarmaceutica.setFont(new Font("Arial", 1, 12));
        this.JCBPFarmaceutica.setBorder(BorderFactory.createTitledBorder((Border) null, "Presentación Farmacéutica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPFarmaceutica.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.14
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JCBPFarmaceuticaMouseClicked(evt);
            }
        });
        this.JCBPFarmaceutica.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.15
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCBPFarmaceuticaActionPerformed(evt);
            }
        });
        this.JCBPFarmaceutica.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.16
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JCBPFarmaceuticaKeyPressed(evt);
            }
        });
        this.JCBViaAdministracion.setFont(new Font("Arial", 1, 12));
        this.JCBViaAdministracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Vía de Administración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBViaAdministracion.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.17
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JCBViaAdministracionMouseClicked(evt);
            }
        });
        this.JCBViaAdministracion.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.18
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JCBViaAdministracionKeyPressed(evt);
            }
        });
        this.JCBPComercial.setFont(new Font("Arial", 1, 12));
        this.JCBPComercial.setBorder(BorderFactory.createTitledBorder((Border) null, "Presentación Comercial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPComercial.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.19
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JCBPComercialMouseClicked(evt);
            }
        });
        this.JCBPComercial.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.20
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JCBPComercialKeyPressed(evt);
            }
        });
        this.JCBConcentracion.setFont(new Font("Arial", 1, 12));
        this.JCBConcentracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Concentración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcentracion.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.21
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JCBConcentracionMouseClicked(evt);
            }
        });
        this.JCBConcentracion.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.22
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JCBConcentracionKeyPressed(evt);
            }
        });
        this.JCBLaboratorio.setFont(new Font("Arial", 1, 12));
        this.JCBLaboratorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Laboratorio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBLaboratorio.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.23
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JCBLaboratorioMouseClicked(evt);
            }
        });
        this.JCBLaboratorio.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.24
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JCBLaboratorioKeyPressed(evt);
            }
        });
        this.JCBCategoria.setFont(new Font("Arial", 1, 12));
        this.JCBCategoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Categoría", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCategoria.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.25
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JCBCategoriaMouseClicked(evt);
            }
        });
        this.JCBCategoria.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.26
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JCBCategoriaKeyPressed(evt);
            }
        });
        this.JTFInvima.setFont(new Font("Arial", 1, 12));
        this.JTFInvima.setToolTipText("");
        this.JTFInvima.setBorder(BorderFactory.createTitledBorder((Border) null, "Registro Invima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFInvima.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.27
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JTFInvimaKeyPressed(evt);
            }
        });
        this.JCBTipoProducto.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoProducto.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFSSuministro.28
            public void itemStateChanged(ItemEvent evt) {
                JIFSSuministro.this.JCBTipoProductoItemStateChanged(evt);
            }
        });
        this.JCBTipoProducto.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.29
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JCBTipoProductoMouseClicked(evt);
            }
        });
        this.JCBTipoProducto.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.30
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JCBTipoProductoKeyPressed(evt);
            }
        });
        this.JDFFechaVInvima.setBorder(BorderFactory.createTitledBorder((Border) null, "FV Registro Invima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaVInvima.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaVInvima.setFont(new Font("Arial", 1, 12));
        this.JDFFechaVInvima.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.31
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JDFFechaVInvimaKeyPressed(evt);
            }
        });
        this.JSP_VUtil.setFont(new Font("Arial", 1, 12));
        this.JSP_VUtil.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSP_VUtil.setToolTipText("Vida util del producto o insumo si aplica");
        this.JSP_VUtil.setBorder(BorderFactory.createTitledBorder((Border) null, "Vida Util", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_VUtil.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.32
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JSP_VUtilKeyPressed(evt);
            }
        });
        this.JCBTipoMedicamento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoMedicamento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Medicamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadMinimaDispensacion.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadMinimaDispensacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Mínima Dispensación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBTipoProducto, -2, 248, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFInvima, -2, 308, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaVInvima, -2, 139, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JTFCodigoBarra, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCodigoBarraEmba, -2, 151, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JSPCantidadU, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCantidadE, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHCCompleta)).addComponent(this.JCBTipoMedicamento, -2, 300, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JTFCodigoCum, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreSuministro, -2, 680, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JCBPrincipioActivo, -2, 621, -2).addGap(18, 18, 18).addComponent(this.JSP_VUtil, -2, 190, -2)))).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBViaAdministracion, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBConcentracion, -2, 378, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCategoria, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBLaboratorio, -2, 386, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBUnidadMedida, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUnidadMinimaDispensacion, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPFarmaceutica, -2, 230, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPComercial, -2, 227, -2))))).addGap(122, 122, 122)));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoBarra, -2, -1, -2).addComponent(this.JTFCodigoBarraEmba, -2, -1, -2).addComponent(this.JTFCodigoCum, -2, -1, -2).addComponent(this.JTFNombreSuministro, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPCantidadU, -2, -1, -2).addComponent(this.JSPCantidadE, -2, -1, -2).addComponent(this.JCHCCompleta).addComponent(this.JCBPrincipioActivo, -2, 50, -2).addComponent(this.JSP_VUtil, -1, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBPFarmaceutica, GroupLayout.Alignment.LEADING).addComponent(this.JCBUnidadMinimaDispensacion, GroupLayout.Alignment.LEADING).addComponent(this.JCBUnidadMedida, GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoMedicamento).addComponent(this.JCBPComercial)).addGap(8, 8, 8).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBViaAdministracion, -2, 50, -2).addComponent(this.JCBConcentracion, -2, 50, -2).addComponent(this.JCBLaboratorio, -2, 50, -2).addComponent(this.JCBCategoria, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFFechaVInvima, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFInvima, -2, 50, -2).addComponent(this.JCBTipoProducto, -2, 50, -2))).addGap(45, 45, 45)));
        this.JCBUnidadMinimaDispensacion.getAccessibleContext().setAccessibleName("Unidad Minima Dispensacion");
        this.JTPDatosP.addTab("BÁSICOS", this.JPIDatosP);
        this.JCBPrioridad.setFont(new Font("Arial", 1, 13));
        this.JCBPrioridad.setBorder(BorderFactory.createTitledBorder((Border) null, "Prioridad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHPos.setFont(new Font("Arial", 1, 12));
        this.JCHPos.setText("Pos?");
        this.JCHPos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.33
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHPosActionPerformed(evt);
            }
        });
        this.JCHActivo.setFont(new Font("Arial", 1, 12));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo?");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.34
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JCHActivoHC.setFont(new Font("Arial", 1, 12));
        this.JCHActivoHC.setText("Activo Hc?");
        this.JCHActivoHC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.35
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHActivoHCActionPerformed(evt);
            }
        });
        this.JCHMaterial.setFont(new Font("Arial", 1, 12));
        this.JCHMaterial.setText("Es Materia?");
        this.JCHMaterial.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.36
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHMaterialActionPerformed(evt);
            }
        });
        this.JCHCobrable.setFont(new Font("Arial", 1, 12));
        this.JCHCobrable.setText("Es Cobrable?");
        this.JCHCobrable.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.37
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHCobrableActionPerformed(evt);
            }
        });
        this.JSPIva.setFont(new Font("Arial", 1, 13));
        this.JSPIva.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPIva.setToolTipText("");
        this.JSPIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHLogoSueno.setFont(new Font("Arial", 1, 12));
        this.JCHLogoSueno.setText("Logo Sueño?");
        this.JCHLogoSueno.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.38
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHLogoSuenoActionPerformed(evt);
            }
        });
        this.JCBClasificacion.setFont(new Font("Arial", 1, 13));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPValorMP.setFont(new Font("Arial", 1, 13));
        this.JSPValorMP.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(1.0f)));
        this.JSPValorMP.setToolTipText("");
        this.JSPValorMP.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor MP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPValorPLM.setFont(new Font("Arial", 1, 13));
        this.JSPValorPLM.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), (Comparable) null, (Comparable) null, Float.valueOf(1.0f)));
        this.JSPValorPLM.setToolTipText("");
        this.JSPValorPLM.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor PLM", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPTMinima.setFont(new Font("Arial", 1, 13));
        this.JSPTMinima.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), (Comparable) null, (Comparable) null, Float.valueOf(1.0f)));
        this.JSPTMinima.setToolTipText("");
        this.JSPTMinima.setBorder(BorderFactory.createTitledBorder((Border) null, "T° Mínima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPTMaxima.setFont(new Font("Arial", 1, 13));
        this.JSPTMaxima.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), (Comparable) null, (Comparable) null, Float.valueOf(1.0f)));
        this.JSPTMaxima.setToolTipText("");
        this.JSPTMaxima.setBorder(BorderFactory.createTitledBorder((Border) null, "T° Máxima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHCTemperaura.setFont(new Font("Arial", 1, 12));
        this.JCHCTemperaura.setText("Control Temperaura?");
        this.JCHCTemperaura.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.39
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHCTemperauraActionPerformed(evt);
            }
        });
        this.JCHCREnteControl.setFont(new Font("Arial", 1, 12));
        this.JCHCREnteControl.setText("Reporte Ente de Control?");
        this.JCHCREnteControl.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.40
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHCREnteControlActionPerformed(evt);
            }
        });
        this.JTFCodigoAtc.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoAtc.setToolTipText("");
        this.JTFCodigoAtc.setBorder(BorderFactory.createTitledBorder((Border) null, "Código ATC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPIndicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Indicaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPIndicacion.setAutoscrolls(true);
        this.JTAIndicacion.setColumns(20);
        this.JTAIndicacion.setFont(new Font("Arial", 1, 12));
        this.JTAIndicacion.setLineWrap(true);
        this.JTAIndicacion.setRows(1);
        this.JTAIndicacion.setTabSize(1);
        this.JSPIndicacion.setViewportView(this.JTAIndicacion);
        this.JSPContraIndicaciones1.setBorder(BorderFactory.createTitledBorder((Border) null, "Contra Indicaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPContraIndicaciones1.setAutoscrolls(true);
        this.JTAContraIndicaciones.setColumns(20);
        this.JTAContraIndicaciones.setFont(new Font("Arial", 1, 12));
        this.JTAContraIndicaciones.setLineWrap(true);
        this.JTAContraIndicaciones.setRows(1);
        this.JTAContraIndicaciones.setTabSize(1);
        this.JSPContraIndicaciones1.setViewportView(this.JTAContraIndicaciones);
        this.JSPInteracciones1.setBorder(BorderFactory.createTitledBorder((Border) null, "Interaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPInteracciones1.setAutoscrolls(true);
        this.JTAInteracciones.setColumns(20);
        this.JTAInteracciones.setFont(new Font("Arial", 1, 12));
        this.JTAInteracciones.setLineWrap(true);
        this.JTAInteracciones.setRows(1);
        this.JTAInteracciones.setTabSize(1);
        this.JSPInteracciones1.setViewportView(this.JTAInteracciones);
        this.JCBClaLasa.setFont(new Font("Arial", 1, 13));
        this.JCBClaLasa.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación LASA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFV2463.setFont(new Font("Arial", 1, 12));
        this.JTFV2463.setToolTipText("");
        this.JTFV2463.setBorder(BorderFactory.createTitledBorder((Border) null, "V2453", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPReaccionesAdversas.setBorder(BorderFactory.createTitledBorder((Border) null, "Reacciones Adversas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPReaccionesAdversas.setAutoscrolls(true);
        this.JTAReaccionesAdversas.setColumns(20);
        this.JTAReaccionesAdversas.setFont(new Font("Arial", 1, 12));
        this.JTAReaccionesAdversas.setLineWrap(true);
        this.JTAReaccionesAdversas.setRows(1);
        this.JTAReaccionesAdversas.setTabSize(1);
        this.JSPReaccionesAdversas.setViewportView(this.JTAReaccionesAdversas);
        this.JTFCodigoIUM.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoIUM.setToolTipText("");
        this.JTFCodigoIUM.setBorder(BorderFactory.createTitledBorder((Border) null, "CodigoIUM", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosAdicionalLayout = new GroupLayout(this.JPIDatosAdicional);
        this.JPIDatosAdicional.setLayout(JPIDatosAdicionalLayout);
        JPIDatosAdicionalLayout.setHorizontalGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAdicionalLayout.createSequentialGroup().addGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPIndicacion).addGroup(GroupLayout.Alignment.LEADING, JPIDatosAdicionalLayout.createSequentialGroup().addComponent(this.JCBPrioridad, -2, 219, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPIva, -2, 57, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAdicionalLayout.createSequentialGroup().addComponent(this.JCBClasificacion, -2, 284, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHPos, -2, 67, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHMaterial, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHActivo, -2, 67, -2).addGap(16, 16, 16).addComponent(this.JCHActivoHC, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHCobrable, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHLogoSueno, -2, 107, -2)).addGroup(JPIDatosAdicionalLayout.createSequentialGroup().addComponent(this.JSPContraIndicaciones1, -2, 284, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPInteracciones1, -2, 280, -2)))).addGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPReaccionesAdversas, -2, 280, -2).addGroup(JPIDatosAdicionalLayout.createSequentialGroup().addComponent(this.JSPValorMP, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPValorPLM, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTMinima, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTMaxima, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCodigoAtc, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClaLasa, -2, 189, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFV2463, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCodigoIUM, -2, 96, -2).addGap(65, 65, 65).addGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHCREnteControl, -2, 179, -2).addComponent(this.JCHCTemperaura, -2, 155, -2))))).addContainerGap(67, 32767)));
        JPIDatosAdicionalLayout.setVerticalGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPrioridad, -2, -1, -2).addComponent(this.JSPIva, -2, -1, -2).addComponent(this.JCHCobrable).addComponent(this.JCHLogoSueno).addComponent(this.JCHActivoHC).addComponent(this.JCHActivo).addComponent(this.JCHMaterial).addComponent(this.JCHPos).addComponent(this.JCBClasificacion, -2, -1, -2)).addGap(15, 15, 15).addGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPIndicacion, -1, 136, 32767).addComponent(this.JSPContraIndicaciones1, GroupLayout.Alignment.TRAILING).addComponent(this.JSPInteracciones1, GroupLayout.Alignment.TRAILING).addComponent(this.JSPReaccionesAdversas, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosAdicionalLayout.createSequentialGroup().addGroup(JPIDatosAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPValorMP, -2, -1, -2).addComponent(this.JSPValorPLM, -2, -1, -2).addComponent(this.JSPTMinima, -2, -1, -2).addComponent(this.JSPTMaxima, -2, -1, -2).addComponent(this.JTFCodigoAtc, -2, -1, -2).addComponent(this.JCBClaLasa, -2, -1, -2).addComponent(this.JTFV2463, -2, -1, -2).addComponent(this.JTFCodigoIUM, -2, -1, -2)).addGap(15, 15, 15)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosAdicionalLayout.createSequentialGroup().addComponent(this.JCHCTemperaura).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHCREnteControl).addContainerGap()))));
        this.JTPDatosP.addTab("ADICIONAL", this.JPIDatosAdicional);
        this.JSP_Ctc_Justificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Justificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Ctc_Justificacion.setAutoscrolls(true);
        this.JTA_Ctc_Justificacion.setColumns(20);
        this.JTA_Ctc_Justificacion.setFont(new Font("Arial", 1, 12));
        this.JTA_Ctc_Justificacion.setLineWrap(true);
        this.JTA_Ctc_Justificacion.setRows(1);
        this.JTA_Ctc_Justificacion.setTabSize(1);
        this.JSP_Ctc_Justificacion.setViewportView(this.JTA_Ctc_Justificacion);
        this.JSP_Ctc_Evidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Evidencia Cientifica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Ctc_Evidencia.setAutoscrolls(true);
        this.JTA_Ctc_Evidencia.setColumns(20);
        this.JTA_Ctc_Evidencia.setFont(new Font("Arial", 1, 12));
        this.JTA_Ctc_Evidencia.setLineWrap(true);
        this.JTA_Ctc_Evidencia.setRows(1);
        this.JTA_Ctc_Evidencia.setTabSize(1);
        this.JSP_Ctc_Evidencia.setViewportView(this.JTA_Ctc_Evidencia);
        this.JSP_Ctc_Casuistica.setBorder(BorderFactory.createTitledBorder((Border) null, "Casuistica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Ctc_Casuistica.setAutoscrolls(true);
        this.JTA_Ctc_Casuistica.setColumns(20);
        this.JTA_Ctc_Casuistica.setFont(new Font("Arial", 1, 12));
        this.JTA_Ctc_Casuistica.setLineWrap(true);
        this.JTA_Ctc_Casuistica.setRows(1);
        this.JTA_Ctc_Casuistica.setTabSize(1);
        this.JSP_Ctc_Casuistica.setViewportView(this.JTA_Ctc_Casuistica);
        this.JSP_Ctc_Precauciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Precauciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Ctc_Precauciones.setAutoscrolls(true);
        this.JTA_Ctc_Precauciones.setColumns(20);
        this.JTA_Ctc_Precauciones.setFont(new Font("Arial", 1, 12));
        this.JTA_Ctc_Precauciones.setLineWrap(true);
        this.JTA_Ctc_Precauciones.setRows(1);
        this.JTA_Ctc_Precauciones.setTabSize(1);
        this.JSP_Ctc_Precauciones.setViewportView(this.JTA_Ctc_Precauciones);
        GroupLayout JPI_DatosAdional2Layout = new GroupLayout(this.JPI_DatosAdional2);
        this.JPI_DatosAdional2.setLayout(JPI_DatosAdional2Layout);
        JPI_DatosAdional2Layout.setHorizontalGroup(JPI_DatosAdional2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAdional2Layout.createSequentialGroup().addComponent(this.JSP_Ctc_Justificacion, -2, 330, -2).addGap(44, 44, 44).addComponent(this.JSP_Ctc_Evidencia, -2, 330, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 228, 32767).addComponent(this.JSP_Ctc_Casuistica, -2, 330, -2)).addGroup(JPI_DatosAdional2Layout.createSequentialGroup().addComponent(this.JSP_Ctc_Precauciones, -2, 330, -2).addGap(0, 0, 32767)));
        JPI_DatosAdional2Layout.setVerticalGroup(JPI_DatosAdional2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosAdional2Layout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosAdional2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSP_Ctc_Evidencia, GroupLayout.Alignment.TRAILING).addComponent(this.JSP_Ctc_Casuistica, GroupLayout.Alignment.TRAILING).addComponent(this.JSP_Ctc_Justificacion, -2, 99, -2)).addGap(18, 18, 18).addComponent(this.JSP_Ctc_Precauciones, -2, 99, -2).addContainerGap(78, 32767)));
        this.JTPDatosP.addTab("ADICIONAL CTC", this.JPI_DatosAdional2);
        this.JBTProcedimientoTarifa.setFont(new Font("Arial", 1, 12));
        this.JBTProcedimientoTarifa.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tarifas.png")));
        this.JBTProcedimientoTarifa.setLabel("<html><P ALIGN=center>Tarifa para Facturacion");
        this.JBTProcedimientoTarifa.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.41
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JBTProcedimientoTarifaActionPerformed(evt);
            }
        });
        this.JBTTarifaMP.setFont(new Font("Arial", 1, 12));
        this.JBTTarifaMP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tarifas.png")));
        this.JBTTarifaMP.setText("<html><P ALIGN=center>Tarifa Medicina Prepagada");
        this.JBTTarifaMP.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.42
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JBTTarifaMPActionPerformed(evt);
            }
        });
        this.JBTProcedimientoCosto.setFont(new Font("Arial", 1, 12));
        this.JBTProcedimientoCosto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/centro de costo.png")));
        this.JBTProcedimientoCosto.setText("<html><P ALIGN=center>Suministro \npor Bodega");
        this.JBTProcedimientoCosto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.43
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JBTProcedimientoCostoActionPerformed(evt);
            }
        });
        this.JBTAreaLab.setFont(new Font("Arial", 1, 12));
        this.JBTAreaLab.setIcon(new ImageIcon(getClass().getResource("/Imagenes/micro.png")));
        this.JBTAreaLab.setText("<html><P ALIGN=center>Area de Laboratorio Clínico");
        this.JBTAreaLab.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.44
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JBTAreaLabActionPerformed(evt);
            }
        });
        this.JBTAreaLab1.setFont(new Font("Arial", 1, 12));
        this.JBTAreaLab1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Invima.png")));
        this.JBTAreaLab1.setText("<html><P ALIGN=center>Abrir Página Web");
        this.JBTAreaLab1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.45
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JBTAreaLab1ActionPerformed(evt);
            }
        });
        this.JBTTipoFormula.setFont(new Font("Arial", 1, 12));
        this.JBTTipoFormula.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.JBTTipoFormula.setText("Tipo de Fórmula");
        this.JBTTipoFormula.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.46
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JBTTipoFormulaActionPerformed(evt);
            }
        });
        this.JBTViaAdministracion.setFont(new Font("Arial", 1, 12));
        this.JBTViaAdministracion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/jerarquia.png")));
        this.JBTViaAdministracion.setText("<html><P ALIGN=center>Suministro por Via de Administracion");
        this.JBTViaAdministracion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.47
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JBTViaAdministracionActionPerformed(evt);
            }
        });
        this.JBTViaAdministracion1.setFont(new Font("Arial", 1, 12));
        this.JBTViaAdministracion1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/historia clinica.png")));
        this.JBTViaAdministracion1.setText("<html><P ALIGN=center>Encuesta Farmacovigilancia (Disparadores)");
        this.JBTViaAdministracion1.setToolTipText("<html>\n<p style=\"text-align: center;\"><strong>Metodolog&iacute;a &ldquo;gatillo&rdquo; o disparadores en farmacovigilancia.</strong>&nbsp;</p>\n<p style=\"text-align: justify;\">La herramienta <em>&ldquo;global trigger tools&rdquo;</em> (gtt) proporciona un m&eacute;todo f&aacute;cil de usar para identificar con precisi&oacute;n los eventos adversos (da&ntilde;os) y la medici&oacute;n de las tasas de eventos adversos (EA) en el tiempo.</p>\n<p style=\"text-align: justify;\">La metodolog&iacute;a es una revisi&oacute;n retrospectiva de una muestra aleatoria de historias cl&iacute;nicas (hc) utilizando \"disparadores\" (o pistas) para identificar posibles EA.</p>\n<p style=\"text-align: justify;\">Muchos hospitales han utilizado esta herramienta para identificar los EA, para evaluar el nivel de da&ntilde;o de cada uno y para determinar si se reducen en el tiempo como resultado de los esfuerzos de mejora.</p>\n<p style=\"text-align: justify;\">EA: \"Cualquier da&ntilde;o involuntario que ocurre a dosis utilizadas en el hombre para la profilaxis, diagn&oacute;stico, terapia, o la modificaci&oacute;n de funciones fisiol&oacute;gicas&rdquo;.</p>\n<p style=\"text-align: justify;\">La herramienta usa la escala de da&ntilde;o de la OMS.</p>\n</html>");
        this.JBTViaAdministracion1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.48
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JBTViaAdministracion1ActionPerformed(evt);
            }
        });
        this.JCH_ValoresDefecto.setFont(new Font("Arial", 1, 12));
        this.JCH_ValoresDefecto.setText("Establecer valores por defecto?");
        this.JCH_ValoresDefecto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.49
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCH_ValoresDefectoActionPerformed(evt);
            }
        });
        this.JBTViaAdministracion2.setFont(new Font("Arial", 1, 12));
        this.JBTViaAdministracion2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTViaAdministracion2.setText("<html><P ALIGN=center>Generar Consecutivo");
        this.JBTViaAdministracion2.setToolTipText("");
        this.JBTViaAdministracion2.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.50
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JBTViaAdministracion2ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosP, -2, 1262, -2).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTProcedimientoTarifa, -1, 160, 32767).addComponent(this.JBTViaAdministracion1, -2, 0, 32767)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTProcedimientoCosto, -1, 160, 32767).addComponent(this.JBTViaAdministracion2, -2, 0, 32767)).addGap(10, 10, 10).addComponent(this.JBTTarifaMP, -2, 160, -2).addGap(31, 31, 31).addComponent(this.JBTAreaLab, -2, 160, -2).addGap(18, 18, 18).addComponent(this.JBTTipoFormula, -2, 160, -2).addGap(18, 18, 18).addComponent(this.JBTViaAdministracion, -2, 160, -2).addGap(18, 18, 18).addComponent(this.JBTAreaLab1, -2, 160, -2)).addComponent(this.JCH_ValoresDefecto)).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTPDatosP, -2, 341, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_ValoresDefecto).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTProcedimientoCosto, -2, 50, -2).addComponent(this.JBTTipoFormula, -2, 50, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTViaAdministracion, -2, 50, -2).addComponent(this.JBTAreaLab1, -2, 50, -2)).addComponent(this.JBTTarifaMP, -2, 50, -2).addComponent(this.JBTAreaLab, -2, 50, -2).addComponent(this.JBTProcedimientoTarifa, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTViaAdministracion1, -2, 50, -2).addComponent(this.JBTViaAdministracion2, -2, 50, -2)).addGap(0, 0, 32767)));
        this.JTPDatosP.getAccessibleContext().setAccessibleName("Adicional");
        this.JPIDatosS.addTab("DATOS", this.JPIDatos);
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda Filtrada", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministro.51
            public void keyPressed(KeyEvent evt) {
                JIFSSuministro.this.JTFNombreBusquedaKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JIFSSuministro.this.JTFNombreBusquedaKeyTyped(evt);
            }
        });
        this.JBGOpciones.add(this.JCHComienza);
        this.JCHComienza.setFont(new Font("Arial", 1, 12));
        this.JCHComienza.setSelected(true);
        this.JCHComienza.setText("Comienza");
        this.JCHComienza.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.52
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHComienzaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JCHContiene);
        this.JCHContiene.setFont(new Font("Arial", 1, 12));
        this.JCHContiene.setText("Contiene");
        this.JCHContiene.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.53
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHContieneActionPerformed(evt);
            }
        });
        this.JCHCosultarT.setFont(new Font("Arial", 1, 12));
        this.JCHCosultarT.setText("Visualizar Todo?");
        this.JCHCosultarT.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministro.54
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministro.this.JCHCosultarTActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda, -2, 843, -2).addGap(18, 18, 18).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHComienza).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JCHContiene).addGap(18, 18, 18).addComponent(this.JCHCosultarT))).addContainerGap(-1, 32767)));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombreBusqueda, -2, 50, -2).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JCHComienza).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHContiene).addComponent(this.JCHCosultarT)))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministro.55
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministro.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosBusqueda, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 419, 32767).addContainerGap()));
        this.JPIDatosS.addTab("BÚSQUEDA", this.jPanel1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIDatosS, -2, 1284, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosS)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea cargar informacion para duplicar items?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.txtNo.setText("");
            } else {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            }
            Optional<ISuministro> suministroOptional = this.suministroService.suministroPorIdOp(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            if (suministroOptional.isPresent()) {
                this.suministro = suministroOptional.get();
            }
            this.JTFCodigoBarra.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSPCantidadU.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JTFCodigoBarraEmba.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFNombreSuministro.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCHCCompleta.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            this.JCBPrincipioActivo.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JCBUnidadMedida.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JCBPFarmaceutica.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JCBViaAdministracion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
            this.JCBPComercial.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString());
            this.JCBConcentracion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString());
            this.JCBClasificacion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString());
            this.JTFInvima.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString());
            this.JCBLaboratorio.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString());
            this.JCBTipoProducto.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString());
            this.JCBCategoria.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString());
            this.JCBPrioridad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString());
            this.JCHPos.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 18).toString()).booleanValue());
            this.JCHActivo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 19).toString()).booleanValue());
            this.JCHActivoHC.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 20).toString()).booleanValue());
            this.JCHMaterial.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 21).toString()).booleanValue());
            this.JCHCobrable.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 22).toString()).booleanValue());
            this.JSPIva.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 23).toString()));
            this.JTAIndicacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 24).toString());
            this.JTAContraIndicaciones.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 25).toString());
            this.JTAInteracciones.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 26).toString());
            this.JTFCodigoCum.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 27).toString());
            this.JSPValorMP.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 29).toString()));
            this.JSPValorPLM.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 30).toString()));
            if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 28).toString().equals("")) {
                this.xurl = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 28).toString();
                this.JCHLogoSueno.setSelected(true);
            } else {
                this.xurl = "";
                this.JCHLogoSueno.setSelected(false);
            }
            this.JDFFechaVInvima.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 31).toString()));
            this.JSPTMinima.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 32).toString()));
            this.JSPTMaxima.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 34).toString()));
            this.JCHCTemperaura.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 33).toString()).booleanValue());
            this.JCHCREnteControl.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 35).toString()).booleanValue());
            this.JTFCodigoAtc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 36).toString());
            this.JTA_Ctc_Justificacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 37).toString());
            this.JTA_Ctc_Evidencia.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 38).toString());
            this.JTA_Ctc_Casuistica.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 39).toString());
            this.JTA_Ctc_Precauciones.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 40).toString());
            this.JCBClaLasa.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 41).toString());
            this.JSP_VUtil.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 42).toString()));
            this.JTFV2463.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 43).toString());
            this.JTFCodigoIUM.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 44).toString());
            this.JTAReaccionesAdversas.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 45).toString());
            mIniciarCheck();
            this.JBTProcedimientoCosto.setEnabled(true);
            this.JBTProcedimientoTarifa.setEnabled(true);
            this.JBTAreaLab.setEnabled(true);
            this.JBTTarifaMP.setEnabled(true);
            System.out.println("tipo medicmantos: " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 46).toString());
            this.JCBTipoMedicamento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 46).toString());
            this.JCBUnidadMinimaDispensacion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 47).toString());
            this.JPIDatosS.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContieneActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTProcedimientoCostoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Suministro x Bodega");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTProcedimientoTarifaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Tarifa Suministro");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCCompletaActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPosActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoHCActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMaterialActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCobrableActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLogoSuenoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoBarraFocusLost(FocusEvent evt) {
        mCargarDatosxCodigoBarra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPrincipioActivoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar un principio activo", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xjifprincipioactivo = new JIFSPrincipoActivo(this);
                Principal.cargarPantalla(this.xjifprincipioactivo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPFarmaceuticaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar presentación farmacéutica", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xjifpresentaconfarmaceutica = new JIFSPresentacionFarmaceuta(this);
                Principal.cargarPantalla(this.xjifpresentaconfarmaceutica);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPComercialMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar presentación comercial", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xjifgenerico = new JIFGenerico1CheckBox("Presentación Comercial", "jifpresentacioncomer", this);
                Principal.cargarPantalla(this.xjifgenerico);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConcentracionMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar concentración", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xjifconcentracion = new JIFConcentracion();
                Principal.cargarPantalla(this.xjifconcentracion);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBLaboratorioMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar laboratorio", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xjifgenerico = new JIFGenerico1CheckBox("Laboratorio", "jiflaboratorio1", this);
                Principal.cargarPantalla(this.xjifgenerico);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHComienzaActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTTarifaMPActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Tarifa MP");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAreaLabActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Suministro x Area");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCTemperauraActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPFarmaceuticaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCREnteControlActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAreaLab1ActionPerformed(ActionEvent evt) {
        try {
            try {
                Desktop.getDesktop().browse(new URI(Principal.informacionIps.getUrlPaginaWebInvima()));
            } catch (IOException ex) {
                Logger.getLogger(JIFSSuministro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } catch (URISyntaxException ex2) {
            Logger.getLogger(JIFSSuministro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTTipoFormulaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Suministro x Tipo de Fórmula");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCosultarTActionPerformed(ActionEvent evt) {
        if (this.JCHCosultarT.isSelected()) {
            mCargarDatosTabla("SELECT\n\ti_suministro.Id,\n\ti_suministro.CodBarraUnidad,\n\ti_suministro.CantidadUnidad,\n\ti_suministro.CodBarraEmbalaje,\n\ti_suministro.Nbre,\n\ti_suministro.CajaCompleta,\n\ti_principioactivo.Nbre,\n\ti_unidadmedida.Nbre ,\n\ti_presentacionfarmaceutica.Nbre,\n\ti_viaadministracion.Nbre,\n\ti_presentacioncomercial.Nbre,\n\ti_concentracion.Nbre,\n\ti_clasificacion.Nbre,\n\tIF(i_suministro.RegistroInvima IS NULL,\n\t'',\n\ti_suministro.RegistroInvima) AS RINVIMA,\n\ti_laboratorio.Nbre ,\n\ti_tipoproducto.Nbre ,\n\ti_categoria.Nbre,\n\ti_prioridades.Nbre,\n\ti_suministro.Pos,\n\ti_suministro.EstaActivo,\n\ti_suministro.ActivoHc,\n\ti_suministro.EsMaterial,\n\ti_suministro.Escobrable,\n\ti_suministro.Iva,\n\tIF(i_suministro.Indicaciones IS NULL ,\n\t'',\n\ti_suministro.Indicaciones) AS Indicaciones ,\n\tif(i_suministro.ContraIndicaciones is null,\n\t'',\n\ti_suministro.ContraIndicaciones) as ContraIndicaciones ,\n\tif( i_suministro.Interacciones is null ,\n\t'',\n\ti_suministro.Interacciones) as Interacciones ,\n\tIF(i_suministro.CodigoCUM IS NULL,\n\t'',\n\ti_suministro.CodigoCUM) AS CodigoCum,\n\tIFNULL(i_suministro.DLogo , '') AS Logo,\n\ti_suministro.VMP,\n\ti_suministro.ValorPLM,\n\tDate_Format(i_suministro.FechaVInvima, '%d-%m-%Y') as FInvima,\n\tTMinima,\n\tMTemperatura,\n\tTMaxima,\n\ti_suministro.REntidad,\n\tIF(i_suministro.CodigoAtc IS NULL,\n\t'',\n\ti_suministro.CodigoAtc) AS CodigoAtc,\n\tIF(`i_suministro`.`Ctc_Justificacion` IS NULL,\n\t'',\n\t`i_suministro`.`Ctc_Justificacion`) AS Ctc,\n\tIF(`i_suministro`.`Ctc_EvidenciaC` IS NULL,\n\t'',\n\t`i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 ,\n\tIF(`i_suministro`.`Ctc_Casuistica` IS NULL,\n\t'',\n\t`i_suministro`.`Ctc_Casuistica`) AS Ctf2 ,\n\tIF(`i_suministro`.`Ctc_Precauciones` IS NULL,\n\t'',\n\t`i_suministro`.`Ctc_Precauciones`) AS Ctc3,\n\ti_clasif_lasa.Nombre,\n\ti_suministro.VUtil,\n\ti_suministro.`V2463`,\n\ti_suministro.`codigoIUM`,\n\tIFNULL(i_suministro.ReaccionesAdversas, '' ) AS ReaccionesAdversas,\n\ti_tipo_medicamento.nombre as tipoMedicamento,\n\ti_unidad_minima_dispensacion.nombre as unidadMinima \nFROM\n\ti_suministro\nINNER JOIN i_principioactivo ON\n\t(i_suministro.IdPrincipioActivo = i_principioactivo.Id)\nINNER JOIN i_unidadmedida ON\n\t(i_suministro.IdUnidadMedida = i_unidadmedida.Id)\nINNER JOIN i_presentacionfarmaceutica ON\n\t(i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id)\nINNER JOIN i_viaadministracion ON\n\t(i_suministro.IdViaAdministracion = i_viaadministracion.Id)\nINNER JOIN i_presentacioncomercial ON\n\t(i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id)\nINNER JOIN i_concentracion ON\n\t(i_suministro.IdConcentracion = i_concentracion.Id)\nINNER JOIN i_clasificacion ON\n\t(i_suministro.IdClasificacion = i_clasificacion.Id)\nINNER JOIN i_laboratorio ON\n\t(i_suministro.IdLaboratorio = i_laboratorio.Id)\nINNER JOIN i_tipoproducto ON\n\t(i_suministro.IdTipoProducto = i_tipoproducto.Id)\nINNER JOIN i_categoria ON\n\t(i_suministro.IdCategoria = i_categoria.Id)\nINNER JOIN i_prioridades ON\n\t(i_suministro.IdPrioridad = i_prioridades.Id)\nINNER JOIN i_clasif_lasa ON\n\t(i_suministro.Id_Cla_Lasa = i_clasif_lasa.Id)\nINNER JOIN i_tipo_medicamento  ON\n\t(i_suministro.idTipoMedicamento  = i_tipo_medicamento.Id)\nINNER JOIN i_unidad_minima_dispensacion  ON\n\t(i_suministro.idUnidadMInimaDispensacion  = i_unidad_minima_dispensacion.Id)\nORDER BY\n\ti_suministro.Nbre ASC,\n\ti_presentacionfarmaceutica.Nbre ASC");
        } else {
            mCrearModeloDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoBarraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCodigoBarra.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoBarraEmbaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCodigoBarraEmba.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoCumKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCodigoCum.transferFocus();
            String s = this.JTFCodigoCum.getText();
            String[] cadena = s.split("-");
            String parte1 = cadena[0];
            String parte2 = cadena[1];
            this.JTFCodigoCum.setText(parte1.replaceFirst("^0*", "") + parte2.replaceFirst("^0*", ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreSuministroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNombreSuministro.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCantidadUKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JSPCantidadE.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCantidadEKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBPrincipioActivo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPrincipioActivoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBPrincipioActivo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadMedidaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBUnidadMedida.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPFarmaceuticaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBPFarmaceutica.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPComercialKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBPComercial.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBViaAdministracionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBViaAdministracion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConcentracionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBConcentracion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCategoriaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBCategoria.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBLaboratorioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBLaboratorio.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoProductoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoProducto.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFInvimaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFInvima.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaVInvimaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTPDatosP.setSelectedIndex(1);
            this.JCBPrioridad.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCategoriaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar las categorias", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.claseparametrizacionn.cargarPantalla("Categoria");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_VUtilKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoProductoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar los tipos de productos", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.claseparametrizacionn.cargarPantalla("Tipo de Producto");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBViaAdministracionMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar la Vía de Administración", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.claseparametrizacionn.cargarPantalla("Via de Administracion");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadMedidaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar el tipo de medicion ", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.claseparametrizacionn.cargarPantalla("Unidad de Medida");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ValoresDefectoActionPerformed(ActionEvent evt) {
        if (this.JCH_ValoresDefecto.isSelected()) {
            this.JCBPrincipioActivo.setSelectedItem("NO APLICA");
            this.JCBUnidadMedida.setSelectedItem("-");
            this.JCBPFarmaceutica.setSelectedItem("NO APLICA");
            this.JCBPComercial.setSelectedItem("NO APLICA");
            this.JCBViaAdministracion.setSelectedItem("NO APLICA");
            this.JCBConcentracion.setSelectedItem("NO APLICA");
            this.JCBClaLasa.setSelectedItem("NO APLICA");
            this.JCBPrioridad.setSelectedItem("NULA");
            this.JCBClasificacion.setSelectedItem("N/A");
            this.JCBCategoria.setSelectedItem("DISPOSITIVOS MEDICOS");
            this.JCBTipoProducto.setSelectedItem("DISPOSITIVO MEDICO");
            return;
        }
        this.JCBPrincipioActivo.setSelectedIndex(-1);
        this.JCBUnidadMedida.setSelectedIndex(-1);
        this.JCBPFarmaceutica.setSelectedIndex(-1);
        this.JCBPComercial.setSelectedIndex(-1);
        this.JCBViaAdministracion.setSelectedIndex(-1);
        this.JCBConcentracion.setSelectedIndex(-1);
        this.JCBClaLasa.setSelectedIndex(-1);
        this.JCBPrioridad.setSelectedIndex(-1);
        this.JCBClasificacion.setSelectedIndex(-1);
        this.JCBCategoria.setSelectedIndex(-1);
        this.JCBTipoProducto.setSelectedIndex(-1);
        this.JCBTipoMedicamento.setSelectedIndex(-1);
        this.JCBUnidadMinimaDispensacion.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTViaAdministracionActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDGenerico1Combo1Check jd = new JDGenerico1Combo1Check(null, true, Principal.txtNo.getText(), "Suministro por Via de Administracion");
            jd.setLocationRelativeTo(this);
            jd.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un suministro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTViaAdministracion1ActionPerformed(ActionEvent evt) {
        if (this.suministro != null) {
            JD_CuestionariosSuministros cuestionariosSuministros = new JD_CuestionariosSuministros(null, true, this.suministro);
            cuestionariosSuministros.setLocationRelativeTo(this);
            cuestionariosSuministros.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargarDatosIniciales();
        }
    }

    private void JBTProcedimientoCosto1ActionPerformed(ActionEvent evt) {
        if (this.suministro != null) {
            this.IdSuministro = Integer.parseInt(Principal.txtNo.getText());
            JDTipoMedicamento tipoMedicamento = new JDTipoMedicamento(null, true, this.IdSuministro);
            tipoMedicamento.setLocationRelativeTo(this);
            tipoMedicamento.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoProductoItemStateChanged(ItemEvent evt) {
        System.out.println("" + this.JCBTipoProducto.getItemCount());
        if (this.lleno && this.JCBTipoProducto.getSelectedIndex() != -1) {
            System.out.println("abreviatura : " + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x029e: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:45:0x029e */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x02a3: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r16 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:47:0x02a3 */
    public void JBTViaAdministracion2ActionPerformed(ActionEvent evt) {
        if (this.JCBTipoProducto.getSelectedIndex() != -1 && this.JCBCategoria.getSelectedIndex() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de genera consecutivo de codigo de barra por tipo de producto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String xsql = "select ifnull(max(CAST(Extraer_Valores_Numericos(is2.CodBarraUnidad) AS UNSIGNED) ),0) numero\n, is2.Id \nfrom i_suministro is2 \nwhere is2.CodBarraUnidad  like '" + this.xidcategoria[this.JCBCategoria.getSelectedIndex()][1] + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][1] + "%'\norder by numero desc";
                try {
                    try {
                        ResultSet xrs = this.xconsulta.traerRs(xsql);
                        Throwable th = null;
                        System.out.println(xsql);
                        if (xrs.next()) {
                            xrs.beforeFirst();
                            while (xrs.next()) {
                                if (!xrs.wasNull()) {
                                    String numero = xrs.getString("numero");
                                    boolean esNull = xrs.wasNull();
                                    System.out.println("----------- Numero recuperado: " + numero + " (Es NULL? " + esNull + ")");
                                    String str = this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][0];
                                    String str2 = this.xidcategoria[this.JCBCategoria.getSelectedIndex()][0];
                                    if (!this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][1].isEmpty() && !this.xidcategoria[this.JCBCategoria.getSelectedIndex()][1].isEmpty()) {
                                        System.out.println("Entroo 2");
                                        this.JTFCodigoBarra.setText(this.xidcategoria[this.JCBCategoria.getSelectedIndex()][1] + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][1] + this.xmetodos.numeroCerosIzquierda(Long.valueOf(xrs.getLong("numero") + 1), 5));
                                    }
                                } else if (!this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][1].isEmpty() && !this.xidcategoria[this.JCBCategoria.getSelectedIndex()][1].isEmpty()) {
                                    this.JTFCodigoBarra.setText(this.xidcategoria[this.JCBCategoria.getSelectedIndex()][1] + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][1] + this.xmetodos.numeroCerosIzquierda(1L, 5));
                                }
                            }
                        } else if (!this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][1].isEmpty() && !this.xidcategoria[this.JCBCategoria.getSelectedIndex()][1].isEmpty()) {
                            this.JTFCodigoBarra.setText(this.xidcategoria[this.JCBCategoria.getSelectedIndex()][1] + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][1] + this.xmetodos.numeroCerosIzquierda(1L, 5));
                        }
                        if (xrs != null) {
                            if (0 != 0) {
                                try {
                                    xrs.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                xrs.close();
                            }
                        }
                    } finally {
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JIFFSubGrupoFactur.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    public void imprimir() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de imprimir códigos de barra?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String numero = JOptionPane.showInputDialog((Component) null, "Ingrese un número de sticker a imprimir", "Catidad", 3);
            int number = Integer.parseInt(numero);
            for (int i = 0; i < number; i++) {
                this.xmetodos.imprimirCodZebraCentralSImple(this.JTFCodigoBarra.getText());
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        mIniciarComponentes();
        this.suministro = null;
        this.xcajacompleta = 0;
        this.xtipobusqueda = 0;
        this.xpos = 0;
        this.xactivo = 0;
        this.xactivohc = 0;
        this.xmaterial = 1;
        this.xcobrable = 0;
        this.JTFCodigoBarra.setText("");
        this.JTFCodigoBarraEmba.setText("");
        this.JTFCodigoCum.setText("");
        this.JTFCodigoAtc.setText("");
        this.JTFCodigoIUM.setText("");
        this.JTFInvima.setText("");
        this.JTFNombreBusqueda.setText("");
        this.JTFNombreSuministro.setText("");
        this.JTAContraIndicaciones.setText("");
        this.JTA_Ctc_Casuistica.setText("");
        this.JTA_Ctc_Evidencia.setText("");
        this.JTA_Ctc_Justificacion.setText("");
        this.JTA_Ctc_Precauciones.setText("");
        this.JTAReaccionesAdversas.setText("");
        this.JTAIndicacion.setText("");
        this.JTAInteracciones.setText("");
        this.JCBCategoria.setSelectedIndex(-1);
        this.JCBClasificacion.setSelectedIndex(-1);
        this.JCBConcentracion.setSelectedIndex(-1);
        this.JCBLaboratorio.setSelectedIndex(-1);
        this.JCBPComercial.setSelectedIndex(-1);
        this.JCBPFarmaceutica.setSelectedIndex(-1);
        this.JCBPrincipioActivo.setSelectedIndex(-1);
        this.JCBPrioridad.setSelectedIndex(-1);
        this.JCBTipoProducto.setSelectedIndex(-1);
        this.JCBUnidadMedida.setSelectedIndex(-1);
        this.JCBViaAdministracion.setSelectedIndex(-1);
        this.JCHActivo.setSelected(true);
        this.JCHActivoHC.setSelected(false);
        this.JCHCCompleta.setSelected(false);
        this.JCHCobrable.setSelected(false);
        this.JCHComienza.setSelected(true);
        this.JCHLogoSueno.setSelected(false);
        this.JCHMaterial.setSelected(false);
        this.JCHPos.setSelected(false);
        this.JCHCREnteControl.setSelected(false);
        this.JSPCantidadE.setValue(new Integer(0));
        this.JSPCantidadU.setValue(new Integer(0));
        this.JSP_VUtil.setValue(new Integer(0));
        this.JSPIva.setValue(new Double(0.0d));
        this.JSPValorMP.setValue(new Double(0.0d));
        this.JSPValorPLM.setValue(new Double(0.0d));
        this.JSPTMinima.setValue(new Double(0.0d));
        this.JSPTMaxima.setValue(new Double(0.0d));
        this.JDFFechaVInvima.setDate(this.xmetodos.getFechaActual());
        mIniciarCheck();
        mCrearModeloDatos();
        this.JCBClaLasa.setSelectedIndex(0);
        this.JTFCodigoBarra.requestFocus();
        this.JCBTipoMedicamento.setSelectedIndex(-1);
        this.JCBUnidadMinimaDispensacion.setSelectedIndex(-1);
    }

    public void mGrabar() {
        String sql;
        String sql2;
        if (!this.JTFCodigoBarra.getText().isEmpty()) {
            if (!this.JTFNombreSuministro.getText().isEmpty()) {
                if (Integer.valueOf(this.JSPCantidadU.getValue().toString()).intValue() != 0) {
                    if (this.JCBPrincipioActivo.getSelectedIndex() != -1) {
                        if (this.JCBTipoMedicamento.getSelectedIndex() != -1) {
                            if (this.JCBUnidadMedida.getSelectedIndex() != -1) {
                                if (this.JCBUnidadMinimaDispensacion.getSelectedIndex() != -1) {
                                    if (this.JCBPFarmaceutica.getSelectedIndex() != -1) {
                                        if (this.JCBPComercial.getSelectedIndex() != -1) {
                                            if (this.JCBViaAdministracion.getSelectedIndex() != -1) {
                                                if (this.JCBConcentracion.getSelectedIndex() != -1) {
                                                    if (this.JCBLaboratorio.getSelectedIndex() != -1) {
                                                        if (this.JCBCategoria.getSelectedIndex() != -1) {
                                                            if (this.JCBTipoProducto.getSelectedIndex() != -1) {
                                                                if (!this.JTFInvima.getText().isEmpty()) {
                                                                    if (this.JCBPrioridad.getSelectedIndex() != -1) {
                                                                        if (this.JCBClasificacion.getSelectedIndex() != -1) {
                                                                            if (this.JTFV2463.getText().length() <= 4) {
                                                                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                                                if (n == 0) {
                                                                                    if (Principal.txtNo.getText().isEmpty()) {
                                                                                        if (this.JCHLogoSueno.isSelected()) {
                                                                                            sql2 = " Insert into i_suministro(CodBarraUnidad, CantidadUnidad, CodBarraEmbalaje, Nbre, CajaCompleta, IdPrincipioActivo, IdUnidadMedida, IdPresentacionFarmaceutica, IdViaAdministracion, IdPresentacionComercial  , IdConcentracion , IdClasificacion, RegistroInvima, IdLaboratorio, IdTipoProducto, IdCategoria, IdPrioridad, Pos, EstaActivo, ActivoHc, EsMaterial, Escobrable, Iva, Indicaciones, ContraIndicaciones, Interacciones, ReaccionesAdversas, CodigoCUM, CodigoAtc, DLogo, VMP, ValorPLM, FechaVInvima, TMinima, TMaxima, MTemperatura,REntidad, `Ctc_Justificacion` , `Ctc_EvidenciaC` , `Ctc_Casuistica` , `Ctc_Precauciones`,Id_Cla_Lasa, VUtil,`V2463`, codigoIUM, Fecha, UsuarioS,idTipoMedicamento,idUnidadMInimaDispensacion)  values ('" + this.JTFCodigoBarra.getText() + "','" + this.JSPCantidadU.getValue() + "','" + this.JTFCodigoBarraEmba.getText() + "','" + this.JTFNombreSuministro.getText().toUpperCase() + "','" + this.xcajacompleta + "','" + this.xidprincipioactivo[this.JCBPrincipioActivo.getSelectedIndex()] + "','" + this.xidunidadmedida[this.JCBUnidadMedida.getSelectedIndex()] + "','" + this.xidpresentacionf[this.JCBPFarmaceutica.getSelectedIndex()] + "','" + this.xidviaadministracion[this.JCBViaAdministracion.getSelectedIndex()] + "','" + this.xidpresentacionc[this.JCBPComercial.getSelectedIndex()] + "','" + this.xidconcentracion[this.JCBConcentracion.getSelectedIndex()] + "','" + this.xidcasificacion[this.JCBClasificacion.getSelectedIndex()] + "','" + this.JTFInvima.getText() + "','" + this.xidlaboratorio[this.JCBLaboratorio.getSelectedIndex()] + "','" + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][0] + "','" + this.xidcategoria[this.JCBCategoria.getSelectedIndex()][0] + "','" + this.xidprioridad[this.JCBPrioridad.getSelectedIndex()] + "','" + this.xpos + "','" + this.xactivo + "','" + this.xactivohc + "','" + this.xmaterial + "','" + this.xcobrable + "','" + this.JSPIva.getValue() + "','" + this.JTAIndicacion.getText() + "','" + this.JTAContraIndicaciones.getText() + "','" + this.JTAInteracciones.getText() + "','" + this.JTAReaccionesAdversas.getText() + "','" + this.JTFCodigoCum.getText() + "','" + this.JTFCodigoAtc.getText() + "','" + this.xmetodos.mTraerUrlBD(this.xurl) + "','" + this.JSPValorMP.getValue() + "','" + this.JSPValorPLM.getValue() + "','" + this.xmetodos.formatoAMD.format(this.JDFFechaVInvima.getDate()) + "','" + this.JSPTMinima.getValue() + "','" + this.JSPTMaxima.getValue() + "','" + this.xcontroltemp + "','" + this.xrcontrol + "','" + this.JTA_Ctc_Justificacion.getText() + "','" + this.JTA_Ctc_Evidencia.getText() + "','" + this.JTA_Ctc_Casuistica.getText() + "','" + this.JTA_Ctc_Precauciones.getText() + "','" + this.xidLasa[this.JCBClaLasa.getSelectedIndex()] + "','" + this.JSP_VUtil.getValue() + "','" + this.JTFV2463.getText() + "','" + this.JTFCodigoIUM.getText() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xidtipomedicamento[this.JCBTipoMedicamento.getSelectedIndex()] + "','" + this.xidunidadminimadispensacion[this.JCBUnidadMinimaDispensacion.getSelectedIndex()] + "')";
                                                                                        } else {
                                                                                            sql2 = " Insert into i_suministro(CodBarraUnidad, CantidadUnidad, CodBarraEmbalaje, Nbre, CajaCompleta, IdPrincipioActivo, IdUnidadMedida, IdPresentacionFarmaceutica, IdViaAdministracion, IdPresentacionComercial  , IdConcentracion , IdClasificacion, RegistroInvima, IdLaboratorio, IdTipoProducto, IdCategoria, IdPrioridad, Pos, EstaActivo, ActivoHc, EsMaterial, Escobrable, Iva, Indicaciones, ContraIndicaciones, Interacciones,ReaccionesAdversas, CodigoCUM, CodigoAtc, VMP, ValorPLM, FechaVInvima, TMinima, TMaxima, MTemperatura, REntidad, `Ctc_Justificacion` , `Ctc_EvidenciaC` , `Ctc_Casuistica` , `Ctc_Precauciones`,Id_Cla_Lasa, VUtil, V2463, codigoIUM, Fecha, UsuarioS,idTipoMedicamento,idUnidadMInimaDispensacion)  values ('" + this.JTFCodigoBarra.getText() + "','" + this.JSPCantidadU.getValue() + "','" + this.JTFCodigoBarraEmba.getText() + "','" + this.JTFNombreSuministro.getText().toUpperCase() + "','" + this.xcajacompleta + "','" + this.xidprincipioactivo[this.JCBPrincipioActivo.getSelectedIndex()] + "','" + this.xidunidadmedida[this.JCBUnidadMedida.getSelectedIndex()] + "','" + this.xidpresentacionf[this.JCBPFarmaceutica.getSelectedIndex()] + "','" + this.xidviaadministracion[this.JCBViaAdministracion.getSelectedIndex()] + "','" + this.xidpresentacionc[this.JCBPComercial.getSelectedIndex()] + "','" + this.xidconcentracion[this.JCBConcentracion.getSelectedIndex()] + "','" + this.xidcasificacion[this.JCBClasificacion.getSelectedIndex()] + "','" + this.JTFInvima.getText() + "','" + this.xidlaboratorio[this.JCBLaboratorio.getSelectedIndex()] + "','" + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][0] + "','" + this.xidcategoria[this.JCBCategoria.getSelectedIndex()][0] + "','" + this.xidprioridad[this.JCBPrioridad.getSelectedIndex()] + "','" + this.xpos + "','" + this.xactivo + "','" + this.xactivohc + "','" + this.xmaterial + "','" + this.xcobrable + "','" + this.JSPIva.getValue() + "','" + this.JTAIndicacion.getText() + "','" + this.JTAContraIndicaciones.getText() + "','" + this.JTAInteracciones.getText() + "','" + this.JTAReaccionesAdversas.getText() + "','" + this.JTFCodigoCum.getText() + "','" + this.JTFCodigoAtc.getText() + "','" + this.JSPValorMP.getValue() + "','" + this.JSPValorPLM.getValue() + "','" + this.xmetodos.formatoAMD.format(this.JDFFechaVInvima.getDate()) + "','" + this.JSPTMinima.getValue() + "','" + this.JSPTMaxima.getValue() + "','" + this.xcontroltemp + "','" + this.xrcontrol + "','" + this.JTA_Ctc_Justificacion.getText() + "','" + this.JTA_Ctc_Evidencia.getText() + "','" + this.JTA_Ctc_Casuistica.getText() + "','" + this.JTA_Ctc_Precauciones.getText() + "','" + this.xidLasa[this.JCBClaLasa.getSelectedIndex()] + "','" + this.JSP_VUtil.getValue() + "','" + this.JTFV2463.getText() + "','" + this.JTFCodigoIUM.getText() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xidtipomedicamento[this.JCBTipoMedicamento.getSelectedIndex()] + "','" + this.xidunidadminimadispensacion[this.JCBUnidadMinimaDispensacion.getSelectedIndex()] + "')";
                                                                                        }
                                                                                        Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql2));
                                                                                        this.xconsulta.cerrarConexionBd();
                                                                                        mCargarDatosIniciales();
                                                                                        return;
                                                                                    }
                                                                                    if (this.JCHLogoSueno.isSelected()) {
                                                                                        sql = " update i_suministro set CodBarraUnidad='" + this.JTFCodigoBarra.getText() + "',CantidadUnidad='" + this.JSPCantidadU.getValue() + "',CodBarraEmbalaje='" + this.JTFCodigoBarraEmba.getText() + "', Nbre='" + this.JTFNombreSuministro.getText().toUpperCase() + "',CajaCompleta='" + this.xcajacompleta + "', IdPrincipioActivo='" + this.xidprincipioactivo[this.JCBPrincipioActivo.getSelectedIndex()] + "',IdUnidadMedida='" + this.xidunidadmedida[this.JCBUnidadMedida.getSelectedIndex()] + "', IdPresentacionFarmaceutica='" + this.xidpresentacionf[this.JCBPFarmaceutica.getSelectedIndex()] + "',IdViaAdministracion='" + this.xidviaadministracion[this.JCBViaAdministracion.getSelectedIndex()] + "', IdPresentacionComercial='" + this.xidpresentacionc[this.JCBPComercial.getSelectedIndex()] + "',IdConcentracion='" + this.xidconcentracion[this.JCBConcentracion.getSelectedIndex()] + "',IdClasificacion='" + this.xidcasificacion[this.JCBClasificacion.getSelectedIndex()] + "',RegistroInvima='" + this.JTFInvima.getText() + "', IdLaboratorio='" + this.xidlaboratorio[this.JCBLaboratorio.getSelectedIndex()] + "',IdTipoProducto='" + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][0] + "', IdCategoria='" + this.xidcategoria[this.JCBCategoria.getSelectedIndex()][0] + "',IdPrioridad='" + this.xidprioridad[this.JCBPrioridad.getSelectedIndex()] + "', Pos='" + this.xpos + "',EstaActivo='" + this.xactivo + "', ActivoHc='" + this.xactivohc + "', EsMaterial='" + this.xmaterial + "', Escobrable='" + this.xcobrable + "',Iva='" + this.JSPIva.getValue() + "', Indicaciones='" + this.JTAIndicacion.getText() + "', ContraIndicaciones='" + this.JTAContraIndicaciones.getText() + "', Interacciones='" + this.JTAInteracciones.getText() + "', ReaccionesAdversas='" + this.JTAReaccionesAdversas.getText() + "',CodigoCUM ='" + this.JTFCodigoCum.getText() + "',CodigoAtc ='" + this.JTFCodigoAtc.getText() + "', DLogo='" + this.xmetodos.mTraerUrlBD(this.xurl) + "', VMP='" + this.JSPValorMP.getValue() + "', ValorPLM='" + this.JSPValorPLM.getValue() + "', FechaVInvima='" + this.xmetodos.formatoAMD.format(this.JDFFechaVInvima.getDate()) + "', TMinima='" + this.JSPTMinima.getValue() + "', TMaxima='" + this.JSPTMaxima.getValue() + "', MTemperatura='" + this.xcontroltemp + "', REntidad='" + this.xrcontrol + "', `Ctc_Justificacion` ='" + this.JTA_Ctc_Justificacion.getText() + "', `Ctc_EvidenciaC`='" + this.JTA_Ctc_Evidencia.getText() + "', `Ctc_Casuistica`='" + this.JTA_Ctc_Casuistica.getText() + "', `Ctc_Precauciones`='" + this.JTA_Ctc_Precauciones.getText() + "', `Id_Cla_Lasa`='" + this.xidLasa[this.JCBClaLasa.getSelectedIndex()] + "', `VUtil`='" + this.JSP_VUtil.getValue() + "', V2463 ='" + this.JTFV2463.getText() + "', codigoIUM ='" + this.JTFCodigoIUM.getText() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', idTipoMedicamento='" + this.xidtipomedicamento[this.JCBTipoMedicamento.getSelectedIndex()] + "', idUnidadMInimaDispensacion='" + this.xidunidadminimadispensacion[this.JCBUnidadMinimaDispensacion.getSelectedIndex()] + "' Where Id='" + Principal.txtNo.getText() + "'";
                                                                                    } else {
                                                                                        sql = " update i_suministro set CodBarraUnidad='" + this.JTFCodigoBarra.getText() + "',CantidadUnidad='" + this.JSPCantidadU.getValue() + "',CodBarraEmbalaje='" + this.JTFCodigoBarraEmba.getText() + "', Nbre='" + this.JTFNombreSuministro.getText().toUpperCase() + "',CajaCompleta='" + this.xcajacompleta + "', IdPrincipioActivo='" + this.xidprincipioactivo[this.JCBPrincipioActivo.getSelectedIndex()] + "',IdUnidadMedida='" + this.xidunidadmedida[this.JCBUnidadMedida.getSelectedIndex()] + "', IdPresentacionFarmaceutica='" + this.xidpresentacionf[this.JCBPFarmaceutica.getSelectedIndex()] + "',IdViaAdministracion='" + this.xidviaadministracion[this.JCBViaAdministracion.getSelectedIndex()] + "', IdPresentacionComercial='" + this.xidpresentacionc[this.JCBPComercial.getSelectedIndex()] + "',IdConcentracion='" + this.xidconcentracion[this.JCBConcentracion.getSelectedIndex()] + "',IdClasificacion='" + this.xidcasificacion[this.JCBClasificacion.getSelectedIndex()] + "',RegistroInvima='" + this.JTFInvima.getText() + "', IdLaboratorio='" + this.xidlaboratorio[this.JCBLaboratorio.getSelectedIndex()] + "',IdTipoProducto='" + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()][0] + "', IdCategoria='" + this.xidcategoria[this.JCBCategoria.getSelectedIndex()][0] + "',IdPrioridad='" + this.xidprioridad[this.JCBPrioridad.getSelectedIndex()] + "', Pos='" + this.xpos + "',EstaActivo='" + this.xactivo + "', ActivoHc='" + this.xactivohc + "', EsMaterial='" + this.xmaterial + "', Escobrable='" + this.xcobrable + "',Iva='" + this.JSPIva.getValue() + "', Indicaciones='" + this.JTAIndicacion.getText() + "', ContraIndicaciones='" + this.JTAContraIndicaciones.getText() + "', Interacciones='" + this.JTAInteracciones.getText() + "', ReaccionesAdversas='" + this.JTAReaccionesAdversas.getText() + "',CodigoCUM ='" + this.JTFCodigoCum.getText() + "',CodigoAtc ='" + this.JTFCodigoAtc.getText() + "', DLogo='" + this.xurl + "', VMP='" + this.JSPValorMP.getValue() + "', ValorPLM='" + this.JSPValorPLM.getValue() + "', FechaVInvima='" + this.xmetodos.formatoAMD.format(this.JDFFechaVInvima.getDate()) + "', TMinima='" + this.JSPTMinima.getValue() + "', TMaxima='" + this.JSPTMaxima.getValue() + "', MTemperatura='" + this.xcontroltemp + "', REntidad='" + this.xrcontrol + "', `Ctc_Justificacion` ='" + this.JTA_Ctc_Justificacion.getText() + "', `Ctc_EvidenciaC`='" + this.JTA_Ctc_Evidencia.getText() + "', `Ctc_Casuistica`='" + this.JTA_Ctc_Casuistica.getText() + "', `Ctc_Precauciones`='" + this.JTA_Ctc_Precauciones.getText() + "', `Id_Cla_Lasa`='" + this.xidLasa[this.JCBClaLasa.getSelectedIndex()] + "', `VUtil`='" + this.JSP_VUtil.getValue() + "', V2463 ='" + this.JTFV2463.getText() + "', codigoIUM ='" + this.JTFCodigoIUM.getText() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', idTipoMedicamento='" + this.xidtipomedicamento[this.JCBTipoMedicamento.getSelectedIndex()] + "', idUnidadMInimaDispensacion='" + this.xidunidadminimadispensacion[this.JCBUnidadMinimaDispensacion.getSelectedIndex()] + "' Where Id='" + Principal.txtNo.getText() + "'";
                                                                                    }
                                                                                    this.xconsulta.ejecutarSQL(sql);
                                                                                    this.xconsulta.cerrarConexionBd();
                                                                                    mCargarDatosIniciales();
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            }
                                                                            JOptionPane.showInternalMessageDialog(this, "El campo V2453 no puede ser mayor de 4 digitos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                            this.JTFV2463.requestFocus();
                                                                            return;
                                                                        }
                                                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de clasificación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                        this.JCBClasificacion.requestFocus();
                                                                        return;
                                                                    }
                                                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de prioridad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                    this.JCBPrioridad.requestFocus();
                                                                    return;
                                                                }
                                                                JOptionPane.showInternalMessageDialog(this, "El registro de invima no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                                this.JTFInvima.requestFocus();
                                                                return;
                                                            }
                                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                            this.JCBTipoProducto.requestFocus();
                                                            return;
                                                        }
                                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una categoría", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                        this.JCBCategoria.requestFocus();
                                                        return;
                                                    }
                                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una laboratorio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                    this.JCBLaboratorio.requestFocus();
                                                    return;
                                                }
                                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una concentración", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JCBConcentracion.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una vía de administración", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JCBViaAdministracion.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una presentación comercial", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JCBPComercial.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una presentación farmacéutica", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JCBPFarmaceutica.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad de medida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JCBUnidadMedida.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de medicamento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBTipoMedicamento.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad miníma de dispensación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBUnidadMinimaDispensacion.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un principio activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBPrincipioActivo.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "la cantidad x unidad debe ser mayor a cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JSPCantidadU.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCodigoBarra.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El código de barra no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFCodigoBarra.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Código Barra", "C/Unidad", "", "Suministro o Dispotivo Médicos", "", "Principio Activo", "", "", "", "", "", "", "", "Laboratorio", "", "", "", "", "Activo", "Activo HC", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Justificacion", "Evidencia", "Casuistica", "Precaucion", "lasa", "VUtil", "V2463", "codigoIUM", "Reacciones Adversar", "", ""}) { // from class: ParametrizacionN.JIFSSuministro.56
            Class[] types = {Long.class, String.class, Long.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Double.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class, Double.class, Boolean.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class, Integer.class, Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setMaxWidth(0);
    }

    private void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    System.out.println(xsql);
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                            this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                            this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                            this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                            this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                            this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                            this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                            this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                            this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                            this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                            this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                            this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                            this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                            this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(19)), n, 18);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(20)), n, 19);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(21)), n, 20);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(22)), n, 21);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(23)), n, 22);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(24)), n, 23);
                            this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                            this.xmodelo.setValueAt(xrs.getString(26), n, 25);
                            this.xmodelo.setValueAt(xrs.getString(27), n, 26);
                            this.xmodelo.setValueAt(xrs.getString(28), n, 27);
                            if (xrs.getString(29).isEmpty() || xrs.getString(29).equalsIgnoreCase("(NULL)")) {
                                this.xmodelo.setValueAt("", n, 28);
                            } else {
                                this.xmodelo.setValueAt(this.xmetodos.mTraerUrlBD(xrs.getString(29)), n, 28);
                            }
                            this.xmodelo.setValueAt(xrs.getString(30), n, 29);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(31)), n, 30);
                            this.xmodelo.setValueAt(xrs.getString(32), n, 31);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(33)), n, 32);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(34)), n, 33);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(35)), n, 34);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(36)), n, 35);
                            this.xmodelo.setValueAt(xrs.getString("CodigoAtc"), n, 36);
                            this.xmodelo.setValueAt(xrs.getString("Ctc"), n, 37);
                            this.xmodelo.setValueAt(xrs.getString("Ctc1"), n, 38);
                            this.xmodelo.setValueAt(xrs.getString("Ctf2"), n, 39);
                            this.xmodelo.setValueAt(xrs.getString("Ctc3"), n, 40);
                            this.xmodelo.setValueAt(xrs.getString("Nombre"), n, 41);
                            this.xmodelo.setValueAt(xrs.getString("VUtil"), n, 42);
                            this.xmodelo.setValueAt(xrs.getString("V2463"), n, 43);
                            this.xmodelo.setValueAt(xrs.getString("codigoIUM"), n, 44);
                            this.xmodelo.setValueAt(xrs.getString("ReaccionesAdversas"), n, 45);
                            this.xmodelo.setValueAt(xrs.getString(47), n, 46);
                            this.xmodelo.setValueAt(xrs.getString(48), n, 47);
                            n++;
                        }
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xconsulta.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSubGrupoFactur.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.lleno = false;
        this.xidprincipioactivo = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_principioactivo WHERE (Estado =1) ORDER BY Nbre ASC", this.xidprincipioactivo, this.JCBPrincipioActivo);
        this.JCBPrincipioActivo.setSelectedIndex(-1);
        this.xidunidadmedida = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_unidadmedida WHERE (Estado =0) ORDER BY Nbre ASC", this.xidunidadmedida, this.JCBUnidadMedida);
        this.JCBUnidadMedida.setSelectedIndex(-1);
        this.xidpresentacionf = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_presentacionfarmaceutica WHERE (Estado =0) ORDER BY Nbre ASC", this.xidpresentacionf, this.JCBPFarmaceutica);
        this.JCBPFarmaceutica.setSelectedIndex(-1);
        this.xidpresentacionc = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_presentacioncomercial WHERE (Estado =0) ORDER BY Nbre ASC", this.xidpresentacionc, this.JCBPComercial);
        this.JCBPComercial.setSelectedIndex(-1);
        this.xidviaadministracion = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_viaadministracion WHERE (Estado =0) ORDER BY Nbre ASC", this.xidviaadministracion, this.JCBViaAdministracion);
        this.JCBViaAdministracion.setSelectedIndex(-1);
        this.xidconcentracion = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_concentracion WHERE (Estado =0) ORDER BY Nbre ASC", this.xidconcentracion, this.JCBConcentracion);
        this.JCBConcentracion.setSelectedIndex(-1);
        this.xidlaboratorio = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_laboratorio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidlaboratorio, this.JCBLaboratorio);
        this.JCBLaboratorio.setSelectedIndex(-1);
        this.xidcategoria = this.xconsulta.llenarComboyLista("SELECT Id, Nbre, ifnull(abreviatura, '')abreviatura FROM i_categoria ORDER BY Nbre ASC", this.xidcategoria, this.JCBCategoria, 3);
        this.JCBCategoria.setSelectedIndex(-1);
        this.xidprioridad = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_prioridades WHERE (Estado =0) ORDER BY Nbre ASC", this.xidprioridad, this.JCBPrioridad);
        this.JCBPrioridad.setSelectedIndex(-1);
        this.xidcasificacion = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM i_clasificacion WHERE (Estado =0) ORDER BY Nbre ASC", this.xidcasificacion, this.JCBClasificacion);
        this.JCBClasificacion.setSelectedIndex(-1);
        this.xidtipoproducto = this.xconsulta.llenarComboyLista("SELECT Id, Nbre, ifnull(abreviatura, '')abreviatura FROM i_tipoproducto WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoproducto, this.JCBTipoProducto, 3);
        this.JCBTipoProducto.setSelectedIndex(-1);
        this.xidLasa = this.xconsulta.llenarCombo("SELECT `Id`, `Nombre` FROM `i_clasif_lasa` WHERE Estado=1", this.xidLasa, this.JCBClaLasa);
        this.JCBClaLasa.setSelectedIndex(0);
        this.xidtipomedicamento = this.xconsulta.llenarCombo("SELECT Id, nombre FROM i_tipo_medicamento ORDER BY nombre ASC", this.xidtipomedicamento, this.JCBTipoMedicamento);
        this.JCBTipoMedicamento.setSelectedIndex(-1);
        this.xidunidadminimadispensacion = this.xconsulta.llenarCombo("SELECT Id, nombre FROM i_unidad_minima_dispensacion ORDER BY nombre ASC", this.xidunidadminimadispensacion, this.JCBUnidadMinimaDispensacion);
        this.JCBUnidadMinimaDispensacion.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.lleno = true;
    }

    private void mCargarDatosIniciales() {
        String xsql;
        if (!this.JTFNombreBusqueda.getText().isEmpty()) {
            if (this.xtipobusqueda == 0) {
                xsql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.CantidadUnidad, i_suministro.CodBarraEmbalaje, i_suministro.Nbre, i_suministro.CajaCompleta, i_principioactivo.Nbre, i_unidadmedida.Nbre\t , i_presentacionfarmaceutica.Nbre, i_viaadministracion.Nbre, i_presentacioncomercial.Nbre, i_concentracion.Nbre, i_clasificacion.Nbre, IF(i_suministro.RegistroInvima IS NULL,'',i_suministro.RegistroInvima) AS RINVIMA, i_laboratorio.Nbre\t, i_tipoproducto.Nbre , i_categoria.Nbre, i_prioridades.Nbre, i_suministro.Pos, i_suministro.EstaActivo, i_suministro.ActivoHc, i_suministro.EsMaterial, i_suministro.Escobrable, i_suministro.Iva, IF(i_suministro.Indicaciones IS NULL , '',i_suministro.Indicaciones) AS Indicaciones ,  if(i_suministro.ContraIndicaciones is null, '',i_suministro.ContraIndicaciones) as ContraIndicaciones   , if( i_suministro.Interacciones is null ,'',  i_suministro.Interacciones) as Interacciones , IF(i_suministro.CodigoCUM IS NULL, '',i_suministro.CodigoCUM)  AS CodigoCum, IFNULL(i_suministro.DLogo,'')  AS Logo, i_suministro.VMP, i_suministro.ValorPLM, Date_Format(i_suministro.FechaVInvima, '%d-%m-%Y') as FInvima, TMinima, MTemperatura, TMaxima,i_suministro.REntidad, IF(i_suministro.CodigoAtc IS NULL, '',i_suministro.CodigoAtc)  AS CodigoAtc, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, i_clasif_lasa.Nombre, i_suministro.VUtil ,i_suministro.`V2463`,i_suministro.codigoIUM, IFNULL(i_suministro.ReaccionesAdversas,'' ) AS ReaccionesAdversas,i_tipo_medicamento.nombre as tipoMedicamento, i_unidad_minima_dispensacion.nombre as unidadMinima   FROM i_suministro INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_unidadmedida  ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_viaadministracion  ON (i_suministro.IdViaAdministracion = i_viaadministracion.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_clasificacion  ON (i_suministro.IdClasificacion = i_clasificacion.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN i_categoria  ON (i_suministro.IdCategoria = i_categoria.Id) INNER JOIN i_prioridades  ON (i_suministro.IdPrioridad = i_prioridades.Id) INNER JOIN i_clasif_lasa ON (i_suministro.Id_Cla_Lasa=i_clasif_lasa.Id)INNER JOIN i_tipo_medicamento  ON (i_suministro.idTipoMedicamento  = i_tipo_medicamento.Id) INNER JOIN i_unidad_minima_dispensacion  ON (i_suministro.idUnidadMInimaDispensacion  = i_unidad_minima_dispensacion.Id) WHERE (i_suministro.Nbre LIKE '" + this.JTFNombreBusqueda.getText() + "%'  or `i_principioactivo`.`Nbre` like'" + this.JTFNombreBusqueda.getText() + "%' )  ORDER BY i_suministro.Nbre ASC, i_presentacionfarmaceutica.Nbre ASC";
            } else {
                xsql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.CantidadUnidad, i_suministro.CodBarraEmbalaje, i_suministro.Nbre, i_suministro.CajaCompleta, i_principioactivo.Nbre, i_unidadmedida.Nbre\t , i_presentacionfarmaceutica.Nbre, i_viaadministracion.Nbre, i_presentacioncomercial.Nbre, i_concentracion.Nbre, i_clasificacion.Nbre, IF(i_suministro.RegistroInvima IS NULL,'',i_suministro.RegistroInvima) AS RINVIMA, i_laboratorio.Nbre\t, i_tipoproducto.Nbre , i_categoria.Nbre, i_prioridades.Nbre, i_suministro.Pos, i_suministro.EstaActivo, i_suministro.ActivoHc, i_suministro.EsMaterial, i_suministro.Escobrable, i_suministro.Iva, IF(i_suministro.Indicaciones IS NULL , '',i_suministro.Indicaciones) AS Indicaciones ,  if(i_suministro.ContraIndicaciones is null, '',i_suministro.ContraIndicaciones) as ContraIndicaciones   , if( i_suministro.Interacciones is null ,'',  i_suministro.Interacciones) as Interacciones ,  IF(i_suministro.CodigoCUM IS NULL, '',i_suministro.CodigoCUM)  AS CodigoCum, IFNULL(i_suministro.DLogo ,'')  AS Logo, i_suministro.VMP, i_suministro.ValorPLM, Date_Format(i_suministro.FechaVInvima, '%d-%m-%Y') as FInvima, TMinima, MTemperatura, TMaxima,i_suministro.REntidad, IF(i_suministro.CodigoAtc IS NULL, '',i_suministro.CodigoAtc)  AS CodigoAtc, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, i_clasif_lasa.Nombre, i_suministro.VUtil,i_suministro.`V2463`,i_suministro.codigoIUM, IFNULL(i_suministro.ReaccionesAdversas,'' ) AS ReaccionesAdversas,i_tipo_medicamento.nombre as tipoMedicamento, i_unidad_minima_dispensacion.nombre as unidadMinima  FROM i_suministro INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_unidadmedida  ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_viaadministracion  ON (i_suministro.IdViaAdministracion = i_viaadministracion.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_clasificacion  ON (i_suministro.IdClasificacion = i_clasificacion.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN i_categoria  ON (i_suministro.IdCategoria = i_categoria.Id) INNER JOIN i_prioridades  ON (i_suministro.IdPrioridad = i_prioridades.Id) INNER JOIN i_clasif_lasa ON (i_suministro.Id_Cla_Lasa=i_clasif_lasa.Id)INNER JOIN i_tipo_medicamento  ON (i_suministro.idTipoMedicamento  = i_tipo_medicamento.Id) INNER JOIN i_unidad_minima_dispensacion  ON (i_suministro.idUnidadMInimaDispensacion  = i_unidad_minima_dispensacion.Id) WHERE (i_suministro.Nbre LIKE '%" + this.JTFNombreBusqueda.getText() + "%'or `i_principioactivo`.`Nbre` like'" + this.JTFNombreBusqueda.getText() + "%') ORDER BY i_suministro.Nbre ASC, i_presentacionfarmaceutica.Nbre ASC";
            }
            mCargarDatosTabla(xsql);
            return;
        }
        mCrearModeloDatos();
    }

    private void mIniciarCheck() {
        if (this.JCHCCompleta.isSelected()) {
            this.xcajacompleta = 1;
        } else {
            this.xcajacompleta = 0;
        }
        if (this.JCHPos.isSelected()) {
            this.xpos = 1;
        } else {
            this.xpos = 0;
        }
        if (this.JCHActivo.isSelected()) {
            this.xactivo = 1;
        } else {
            this.xactivo = 0;
        }
        if (this.JCHActivoHC.isSelected()) {
            this.xactivohc = 1;
        } else {
            this.xactivohc = 0;
        }
        if (this.JCHMaterial.isSelected()) {
            this.xmaterial = 1;
        } else {
            this.xmaterial = 0;
        }
        if (this.JCHCobrable.isSelected()) {
            this.xcobrable = 1;
        } else {
            this.xcobrable = 0;
        }
        if (this.JCHCTemperaura.isSelected()) {
            this.xcontroltemp = 1;
        } else {
            this.xcontroltemp = 0;
        }
        if (this.JCHCREnteControl.isSelected()) {
            this.xrcontrol = 1;
        } else {
            this.xrcontrol = 0;
        }
        if (this.JCHLogoSueno.isSelected()) {
            this.xurl = "logosumi.png";
        } else {
            this.xurl = "(NULL)";
        }
    }

    private void mCargarDatosxCodigoBarra() {
        if (!this.JTFCodigoBarra.getText().isEmpty()) {
            String xsql = "SELECT\n\ti_suministro.Id,\n\ti_suministro.CodBarraUnidad,\n\ti_suministro.CantidadUnidad,\n\ti_suministro.CodBarraEmbalaje,\n\ti_suministro.Nbre,\n\ti_suministro.CajaCompleta,\n\ti_principioactivo.Nbre,\n\ti_unidadmedida.Nbre ,\n\ti_presentacionfarmaceutica.Nbre,\n\ti_viaadministracion.Nbre,\n\ti_presentacioncomercial.Nbre,\n\ti_concentracion.Nbre,\n\ti_clasificacion.Nbre,\n\tIF(i_suministro.RegistroInvima IS NULL,\n\t'',\n\ti_suministro.RegistroInvima) as RImvima,\n\ti_laboratorio.Nbre ,\n\ti_tipoproducto.Nbre ,\n\ti_categoria.Nbre,\n\ti_prioridades.Nbre,\n\ti_suministro.Pos,\n\ti_suministro.EstaActivo,\n\ti_suministro.ActivoHc,\n\ti_suministro.EsMaterial,\n\ti_suministro.Escobrable,\n\ti_suministro.Iva,\n\tIF(i_suministro.Indicaciones IS NULL ,\n\t'',\n\ti_suministro.Indicaciones) AS Indicaciones ,\n\tif(i_suministro.ContraIndicaciones is null,\n\t'',\n\ti_suministro.ContraIndicaciones) as ContraIndicaciones ,\n\tif( i_suministro.Interacciones is null ,\n\t'',\n\ti_suministro.Interacciones) as Interacciones ,\n\tIF(i_suministro.CodigoCUM IS NULL,\n\t'',\n\ti_suministro.CodigoCUM) AS CodigoCum,\n\tIFNULL(i_suministro.DLogo, '') AS Logo,\n\ti_suministro.VMP,\n\ti_suministro.ValorPLM,\n\tDate_Format(i_suministro.FechaVInvima, '%d-%m-%Y') as FInvima,\n\tTMinima,\n\tMTemperatura,\n\tTMaxima,\n\ti_suministro.REntidad,\n\tIF(i_suministro.CodigoAtc IS NULL,\n\t'',\n\ti_suministro.CodigoAtc) AS CodigoAtc,\n\tIF(`i_suministro`.`Ctc_Justificacion` IS NULL,\n\t'',\n\t`i_suministro`.`Ctc_Justificacion`) AS Ctc,\n\tIF(`i_suministro`.`Ctc_EvidenciaC` IS NULL,\n\t'',\n\t`i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 ,\n\tIF(`i_suministro`.`Ctc_Casuistica` IS NULL,\n\t'',\n\t`i_suministro`.`Ctc_Casuistica`) AS Ctf2 ,\n\tIF(`i_suministro`.`Ctc_Precauciones` IS NULL,\n\t'',\n\t`i_suministro`.`Ctc_Precauciones`) AS Ctc3 ,\n\ti_clasif_lasa.Nombre,\n\ti_suministro.`VUtil`,\n\ti_suministro.`V2463`,\n\ti_suministro.`codigoIUM`,\n\tIFNULL(i_suministro.ReaccionesAdversas, '' ) AS ReaccionesAdversas,\n\ti_tipo_medicamento.nombre,\n\ti_unidad_minima_dispensacion.nombre \nFROM\n\ti_suministro\nINNER JOIN i_principioactivo ON\n\t(i_suministro.IdPrincipioActivo = i_principioactivo.Id)\nINNER JOIN i_unidadmedida ON\n\t(i_suministro.IdUnidadMedida = i_unidadmedida.Id)\nINNER JOIN i_presentacionfarmaceutica ON\n\t(i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id)\nINNER JOIN i_viaadministracion ON\n\t(i_suministro.IdViaAdministracion = i_viaadministracion.Id)\nINNER JOIN i_presentacioncomercial ON\n\t(i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id)\nINNER JOIN i_concentracion ON\n\t(i_suministro.IdConcentracion = i_concentracion.Id)\nINNER JOIN i_clasificacion ON\n\t(i_suministro.IdClasificacion = i_clasificacion.Id)\nINNER JOIN i_laboratorio ON\n\t(i_suministro.IdLaboratorio = i_laboratorio.Id)\nINNER JOIN i_tipoproducto ON\n\t(i_suministro.IdTipoProducto = i_tipoproducto.Id)\nINNER JOIN i_categoria ON\n\t(i_suministro.IdCategoria = i_categoria.Id)\nINNER JOIN i_prioridades ON\n\t(i_suministro.IdPrioridad = i_prioridades.Id)\nINNER JOIN i_clasif_lasa ON\n\t(i_suministro.Id_Cla_Lasa = i_clasif_lasa.Id)\nINNER JOIN i_tipo_medicamento  ON\n\t(i_suministro.idTipoMedicamento  = i_tipo_medicamento.Id)\nINNER JOIN i_unidad_minima_dispensacion  ON\n\t(i_suministro.idUnidadMInimaDispensacion  = i_unidad_minima_dispensacion.Id)\nWHERE\n\ti_suministro.CodBarraUnidad = '" + this.JTFCodigoBarra.getText() + "'\nORDER BY\n\ti_suministro.Nbre ASC,\n\ti_presentacionfarmaceutica.Nbre ASC\n";
            mCargarDatosTabla(xsql);
            if (this.JTDetalle.getRowCount() == 1) {
                this.suministro = null;
                Principal.txtNo.setText(this.xmodelo.getValueAt(0, 0).toString());
                Optional<ISuministro> suministroOptional = this.suministroService.suministroPorIdOp(Long.valueOf(this.xmodelo.getValueAt(0, 0).toString()));
                if (suministroOptional.isPresent()) {
                    this.suministro = suministroOptional.get();
                } else {
                    System.err.println("this.suministroService.suministroPorIdOp este metodo no devuelve nada");
                }
                this.JTFCodigoBarra.setText(this.xmodelo.getValueAt(0, 1).toString());
                this.JSPCantidadU.setValue(Integer.valueOf(this.xmodelo.getValueAt(0, 2).toString()));
                this.JTFCodigoBarraEmba.setText(this.xmodelo.getValueAt(0, 3).toString());
                this.JTFNombreSuministro.setText(this.xmodelo.getValueAt(0, 4).toString());
                this.JCHCCompleta.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(0, 5).toString()).booleanValue());
                this.JCBPrincipioActivo.setSelectedItem(this.xmodelo.getValueAt(0, 6).toString());
                this.JCBUnidadMedida.setSelectedItem(this.xmodelo.getValueAt(0, 7).toString());
                this.JCBPFarmaceutica.setSelectedItem(this.xmodelo.getValueAt(0, 8).toString());
                this.JCBViaAdministracion.setSelectedItem(this.xmodelo.getValueAt(0, 9).toString());
                this.JCBPComercial.setSelectedItem(this.xmodelo.getValueAt(0, 10).toString());
                this.JCBConcentracion.setSelectedItem(this.xmodelo.getValueAt(0, 11).toString());
                this.JCBClasificacion.setSelectedItem(this.xmodelo.getValueAt(0, 12).toString());
                this.JTFInvima.setText(this.xmodelo.getValueAt(0, 13).toString());
                this.JCBLaboratorio.setSelectedItem(this.xmodelo.getValueAt(0, 14).toString());
                this.JCBTipoProducto.setSelectedItem(this.xmodelo.getValueAt(0, 15).toString());
                this.JCBCategoria.setSelectedItem(this.xmodelo.getValueAt(0, 16).toString());
                this.JCBPrioridad.setSelectedItem(this.xmodelo.getValueAt(0, 17).toString());
                this.JCHPos.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(0, 18).toString()).booleanValue());
                this.JCHActivo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(0, 19).toString()).booleanValue());
                this.JCHActivoHC.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(0, 20).toString()).booleanValue());
                this.JCHMaterial.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(0, 21).toString()).booleanValue());
                this.JCHCobrable.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(0, 22).toString()).booleanValue());
                this.JSPIva.setValue(Double.valueOf(this.xmodelo.getValueAt(0, 23).toString()));
                this.JTAIndicacion.setText(this.xmodelo.getValueAt(0, 24).toString());
                this.JTAContraIndicaciones.setText(this.xmodelo.getValueAt(0, 25).toString());
                this.JTAInteracciones.setText(this.xmodelo.getValueAt(0, 26).toString());
                this.JTFCodigoCum.setText(this.xmodelo.getValueAt(0, 27).toString());
                this.JSPValorMP.setValue(Double.valueOf(this.xmodelo.getValueAt(0, 29).toString()));
                this.JSPValorPLM.setValue(Double.valueOf(this.xmodelo.getValueAt(0, 30).toString()));
                if (!this.xmodelo.getValueAt(0, 28).toString().equals("")) {
                    this.xurl = this.xmodelo.getValueAt(0, 28).toString();
                    this.JCHLogoSueno.setSelected(true);
                } else {
                    this.xurl = "";
                    this.JCHLogoSueno.setSelected(false);
                }
                this.JDFFechaVInvima.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(0, 31).toString()));
                this.JSPTMinima.setValue(Double.valueOf(this.xmodelo.getValueAt(0, 32).toString()));
                this.JSPTMaxima.setValue(Double.valueOf(this.xmodelo.getValueAt(0, 34).toString()));
                this.JCHCTemperaura.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(0, 33).toString()).booleanValue());
                this.JCHCREnteControl.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(0, 35).toString()).booleanValue());
                this.JTFCodigoAtc.setText(this.xmodelo.getValueAt(0, 36).toString());
                this.JTA_Ctc_Justificacion.setText(this.xmodelo.getValueAt(0, 37).toString());
                this.JTA_Ctc_Evidencia.setText(this.xmodelo.getValueAt(0, 38).toString());
                this.JTA_Ctc_Casuistica.setText(this.xmodelo.getValueAt(0, 39).toString());
                this.JTA_Ctc_Precauciones.setText(this.xmodelo.getValueAt(0, 40).toString());
                this.JCBClaLasa.setSelectedItem(this.xmodelo.getValueAt(0, 41).toString());
                this.JSP_VUtil.setValue(Integer.valueOf(this.xmodelo.getValueAt(0, 42).toString()));
                this.JTFV2463.setText(this.xmodelo.getValueAt(0, 43).toString());
                this.JTFCodigoIUM.setText(this.xmodelo.getValueAt(0, 44).toString());
                this.JTAReaccionesAdversas.setText(this.xmodelo.getValueAt(0, 45).toString());
                this.JCBTipoMedicamento.setSelectedItem(this.xmodelo.getValueAt(0, 46).toString());
                this.JCBUnidadMinimaDispensacion.setSelectedItem(this.xmodelo.getValueAt(0, 47).toString());
                mIniciarCheck();
                this.JBTProcedimientoCosto.setEnabled(true);
                this.JBTProcedimientoTarifa.setEnabled(true);
                this.JBTAreaLab.setEnabled(true);
                this.JBTTarifaMP.setEnabled(true);
                this.JPIDatosS.setSelectedIndex(0);
            }
        }
    }
}
