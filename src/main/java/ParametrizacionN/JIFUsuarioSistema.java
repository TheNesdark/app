package ParametrizacionN;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.BuildChecBoxTree;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.parametrizacion.JDProcedimientoCntCode;
import com.genoma.plus.controller.parametrizacion.UserSisproDTO;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Enumeration;
import java.util.EventObject;
import java.util.List;
import java.util.Objects;
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
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFUsuarioSistema.class */
public class JIFUsuarioSistema extends JInternalFrame {
    public static Persona xjppersona;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelom;
    private DefaultTableModel xmodelob;
    private DefaultTableModel xmodeloc;
    private DefaultTableModel xmodelocs;
    private DefaultTableModel xmodeloS;
    private DefaultTableModel xmodeloRH;
    private DefaultTableModel xmodeloSispro;
    private Object[] xdato;
    private File xfile;
    private String[] xidespecialidad;
    private String[] xidmodulo;
    private String[] xidbodega;
    private String[] xidcaja;
    private String[] xidcajas;
    private String[] xidsede;
    private String[] xidunidadf;
    private String[] xclasificacion;
    public String[][] xidcargo;
    private List<UserSisproDTO> dtoList;
    private UserSisproDTO sisproDTO;
    private Long id;
    private Date fecha;
    private boolean tipoMecanismoValidacion;
    private boolean reps;
    private ButtonGroup JBGAutorizacionLAB;
    private ButtonGroup JBGOpciones;
    private ButtonGroup JBGTipoUsuario;
    private JButton JBGrabar;
    private JButton JBGrabar1;
    private JButton JBTGrabar;
    private JButton JBTGrabar1;
    private JButton JBTGrabarB;
    private JButton JBTGrabarC;
    private JButton JBTGrabarCS;
    private JButton JBTGrabarS;
    private JButton JBTGrabarS1;
    private JButton JBTGrabarUsuarioSispro;
    private JButton JBTNuevo;
    private JButton JBTNuevoSispro;
    private JComboBox JCBBodega;
    private JComboBox JCBCaja;
    private JComboBox JCBCajas;
    private JComboBox JCBCargo;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBModulo;
    private JComboBox JCBSede;
    private JComboBox JCBTpclasificasion;
    private JComboBox JCBUnidadF;
    private JCheckBox JCHActivoCita;
    private JCheckBox JCHAnular;
    private JCheckBox JCHBodega;
    private JCheckBox JCHCajero;
    private JCheckBox JCHConductor;
    private JCheckBox JCHConsulta;
    private JCheckBox JCHDescuento;
    private JCheckBox JCHEsVacunador;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstadoBodega;
    private JCheckBox JCHEstadoCaja;
    private JCheckBox JCHEstadoCajas;
    private JCheckBox JCHEstadoEspe;
    private JCheckBox JCHEstadoModulo;
    private JCheckBox JCHEstadoRH;
    private JCheckBox JCHEstadoSede;
    private JCheckBox JCHEstadoSispro;
    private JCheckBox JCHFijo;
    private JCheckBox JCHIps;
    private JCheckBox JCHLider;
    private JCheckBox JCHMecanismoValidacion;
    private JCheckBox JCHProfesional;
    private JCheckBox JCHReps;
    private JCheckBox JCHSIntegral;
    private JDateChooser JDFFechaFC;
    private JDateChooser JDFFechaIngreso;
    private JDateChooser JDFFechaUC;
    private JLabel JLBIdPersonaRH;
    private JPanel JPAdicional;
    private JPanel JPAutorizacion;
    private JPanel JPAutorizacion1;
    private JPanel JPDatosContra;
    private JPanel JPIDatosBodega;
    private JPanel JPIDatosCaja;
    private JPanel JPIDatosCajas;
    private JPanel JPIDatosCuenta;
    private JPanel JPIDatosModulos;
    private JPanel JPIDatosProf;
    private JPanel JPIDatosProf1;
    private JPanel JPIDatosSede;
    private JPanel JPIFDatosUsuario;
    private JPanel JPIUsuarioSispro;
    private JPanel JPI_FUtilizacion;
    private JPanel JPMenuUsuario;
    private JRadioButton JRBAdministrador;
    private JRadioButton JRBGraba;
    private JRadioButton JRBNoAplica;
    private JRadioButton JRBNormal;
    private JRadioButton JRBSuper;
    private JRadioButton JRBTodos;
    private JRadioButton JRBValida;
    private JRadioButton JRBValidaGraba;
    private JRadioButton JRB_FP_Dias;
    private JRadioButton JRB_FP_Horas;
    private JRadioButton JRB_FP_Jornal;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleBodega;
    private JScrollPane JSPDetalleCaja;
    private JScrollPane JSPDetalleCajas;
    private JScrollPane JSPDetalleEspecialidad;
    private JScrollPane JSPDetalleModulo;
    private JScrollPane JSPDetalleSede;
    private JSpinner JSPFRiesgoArp;
    private JScrollPane JSPMenuTree;
    private JScrollPane JSPMenuTreeCalidad;
    private JTable JTDetalle;
    private JTable JTDetalleBodega;
    private JTable JTDetalleC;
    private JTable JTDetalleCaja;
    private JTable JTDetalleCajas;
    private JTable JTDetalleModulo;
    private JTable JTDetalleSede;
    private JTextField JTFClave;
    private JTextField JTFCodigoD785;
    private JFormattedTextField JTFFCantidad;
    private JFormattedTextField JTFFSalario;
    private JTextField JTFGrado;
    private JTextField JTFLogin;
    private JTextField JTFRuta;
    private JTextField JTFRuta1;
    private JTextField JTFTarjetaP;
    private JTabbedPane JTPDatosCuenta;
    private JPasswordField JTPFContasena;
    private JTabbedPane JTPInformacion;
    private JTable JTableUsuarioSIspro;
    private JPanel jPanel8;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xesprofesional = 0;
    private int xescajero = 0;
    private int xesadministrativo = 0;
    private int xesbodega = 0;
    private int xVacunador = 0;
    private int xesanular = 0;
    private int xestado = 0;
    private int xactivocita = 1;
    private int xips = 0;
    private int xestadomodulo = 0;
    private int xestadobodega = 1;
    private int xestadocaja = 1;
    private int xestadocajas = 1;
    private int xestadosede = 1;
    private int xesconsulta = 0;
    private int xautorizacionLAB = 2;
    private int xesintegral = 0;
    private int xformapago = 0;
    private int xlider = 0;
    private int xfijo = 1;
    private int xestadoRH = 1;
    private int xdescuento = 0;
    private int xconductor = 0;
    private boolean xestadog = false;
    private boolean xencontrousuario = false;
    private boolean xencontroprofesional = false;
    private boolean xencontrousuariomodulo = false;
    private boolean xencontrobodegas = false;
    private boolean xencontroespprofesional = false;
    private boolean xencontrocaja = false;
    private boolean xencontrocajas = false;
    private boolean xencontrosede = false;
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xencontroacargo = false;
    TreeModel modelo = null;
    DefaultMutableTreeNode root1 = null;
    DefaultMutableTreeNode parent1 = null;
    DefaultMutableTreeNode childnode = null;
    private BuildChecBoxTree xBuildChecBoxTree = new BuildChecBoxTree("g_menu_conf", "g_usuario_sist_menu");
    private BuildChecBoxTree xBuildChecBoxTreeCal = new BuildChecBoxTree("g_menu_conf_cal", "g_usuario_sist_menu_cal");

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFUsuarioSistema$Status.class */
    enum Status {
        SELECTED,
        DESELECTED,
        INDETERMINATE
    }

    public JIFUsuarioSistema() {
        initComponents();
        mCargasPanelUsuario();
        mNuevo();
        this.JSPMenuTree.getViewport().add(this.xBuildChecBoxTree.mCheckboxTree());
        this.JSPMenuTreeCalidad.getViewport().add(this.xBuildChecBoxTreeCal.mCheckboxTree());
    }

    /* JADX WARN: Type inference failed for: r3v112, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v156, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v201, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v232, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v304, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v404, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v68, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JBGAutorizacionLAB = new ButtonGroup();
        this.JBGTipoUsuario = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JPIDatosCuenta = new JPanel();
        this.JTPDatosCuenta = new JTabbedPane();
        this.JPIDatosProf = new JPanel();
        this.JTFTarjetaP = new JTextField();
        this.JCHActivoCita = new JCheckBox();
        this.JCHIps = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JCBEspecialidad = new JComboBox();
        this.JSPDetalleEspecialidad = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCHEstadoEspe = new JCheckBox();
        this.JBTGrabar = new JButton();
        this.JCHEsVacunador = new JCheckBox();
        this.JPIDatosModulos = new JPanel();
        this.JCHEstadoModulo = new JCheckBox();
        this.JCBModulo = new JComboBox();
        this.JBTGrabar1 = new JButton();
        this.JSPDetalleModulo = new JScrollPane();
        this.JTDetalleModulo = new JTable();
        this.JPIDatosBodega = new JPanel();
        this.JCHEstadoBodega = new JCheckBox();
        this.JCBBodega = new JComboBox();
        this.JBTGrabarB = new JButton();
        this.JSPDetalleBodega = new JScrollPane();
        this.JTDetalleBodega = new JTable();
        this.JPIDatosCaja = new JPanel();
        this.JCHEstadoCaja = new JCheckBox();
        this.JCBCaja = new JComboBox();
        this.JBTGrabarC = new JButton();
        this.JSPDetalleCaja = new JScrollPane();
        this.JTDetalleCaja = new JTable();
        this.JPIDatosCajas = new JPanel();
        this.JCBCajas = new JComboBox();
        this.JCHEstadoCajas = new JCheckBox();
        this.JBTGrabarCS = new JButton();
        this.JSPDetalleCajas = new JScrollPane();
        this.JTDetalleCajas = new JTable();
        this.JPIDatosSede = new JPanel();
        this.JCBSede = new JComboBox();
        this.JBTGrabarS = new JButton();
        this.JCHEstadoSede = new JCheckBox();
        this.JSPDetalleSede = new JScrollPane();
        this.JTDetalleSede = new JTable();
        this.JPMenuUsuario = new JPanel();
        this.JSPMenuTree = new JScrollPane();
        this.JBGrabar = new JButton();
        this.JSPMenuTreeCalidad = new JScrollPane();
        this.JBGrabar1 = new JButton();
        this.JPIDatosProf1 = new JPanel();
        this.JCBUnidadF = new JComboBox();
        this.JCBCargo = new JComboBox();
        this.JDFFechaIngreso = new JDateChooser();
        this.JTFFSalario = new JFormattedTextField();
        this.JCHSIntegral = new JCheckBox();
        this.JTFRuta1 = new JTextField();
        this.JCHEstadoRH = new JCheckBox();
        this.JCHLider = new JCheckBox();
        this.JCHFijo = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JSPFRiesgoArp = new JSpinner();
        this.JCBTpclasificasion = new JComboBox();
        this.JTFFCantidad = new JFormattedTextField();
        this.JPI_FUtilizacion = new JPanel();
        this.JRB_FP_Dias = new JRadioButton();
        this.JRB_FP_Horas = new JRadioButton();
        this.JRB_FP_Jornal = new JRadioButton();
        this.jPanel8 = new JPanel();
        this.JTFCodigoD785 = new JTextField();
        this.JTFGrado = new JTextField();
        this.JLBIdPersonaRH = new JLabel();
        this.JBTGrabarS1 = new JButton();
        this.JBTNuevo = new JButton();
        this.JPIUsuarioSispro = new JPanel();
        this.JBTNuevoSispro = new JButton();
        this.JCHEstadoSispro = new JCheckBox();
        this.JBTGrabarUsuarioSispro = new JButton();
        this.JTFClave = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTableUsuarioSIspro = new JTable();
        this.JCHReps = new JCheckBox();
        this.JCHMecanismoValidacion = new JCheckBox();
        this.JTPInformacion = new JTabbedPane();
        this.JPDatosContra = new JPanel();
        this.JTFLogin = new JTextField();
        this.JTPFContasena = new JPasswordField();
        this.JCHProfesional = new JCheckBox();
        this.JCHBodega = new JCheckBox();
        this.JCHCajero = new JCheckBox();
        this.JCHAnular = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JDFFechaUC = new JDateChooser();
        this.JDFFechaFC = new JDateChooser();
        this.JCHConsulta = new JCheckBox();
        this.JCHDescuento = new JCheckBox();
        this.JCHConductor = new JCheckBox();
        this.JPAdicional = new JPanel();
        this.JPAutorizacion = new JPanel();
        this.JRBValidaGraba = new JRadioButton();
        this.JRBGraba = new JRadioButton();
        this.JRBValida = new JRadioButton();
        this.JRBTodos = new JRadioButton();
        this.JRBNoAplica = new JRadioButton();
        this.JPAutorizacion1 = new JPanel();
        this.JRBSuper = new JRadioButton();
        this.JRBAdministrador = new JRadioButton();
        this.JRBNormal = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE USUARIO");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifusuariosistemas");
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFUsuarioSistema.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFUsuarioSistema.this.formInternalFrameClosing(evt);
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
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JPIDatosCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "CUENTAS DE USUARIO Y ACCESO A MÓDULOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPDatosCuenta.setForeground(Color.red);
        this.JTPDatosCuenta.setFont(new Font("Arial", 1, 14));
        this.JTFTarjetaP.setFont(new Font("Arial", 1, 12));
        this.JTFTarjetaP.setBorder(BorderFactory.createTitledBorder((Border) null, "Tarjeta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivoCita.setFont(new Font("Arial", 1, 12));
        this.JCHActivoCita.setForeground(Color.blue);
        this.JCHActivoCita.setText("Activo Cita?");
        this.JCHActivoCita.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.2
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHActivoCitaActionPerformed(evt);
            }
        });
        this.JCHIps.setFont(new Font("Arial", 1, 12));
        this.JCHIps.setForeground(Color.blue);
        this.JCHIps.setText("Ips?");
        this.JCHIps.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.3
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHIpsActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.4
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.5
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDetalleEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.6
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleEspecialidad.setViewportView(this.JTDetalle);
        this.JCHEstadoEspe.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoEspe.setForeground(Color.blue);
        this.JCHEstadoEspe.setSelected(true);
        this.JCHEstadoEspe.setText("Estado");
        this.JCHEstadoEspe.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.7
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEstadoEspeActionPerformed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.8
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JCHEsVacunador.setFont(new Font("Arial", 1, 12));
        this.JCHEsVacunador.setForeground(Color.blue);
        this.JCHEsVacunador.setText("Es Vacunador");
        this.JCHEsVacunador.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.9
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEsVacunadorActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosProfLayout = new GroupLayout(this.JPIDatosProf);
        this.JPIDatosProf.setLayout(JPIDatosProfLayout);
        JPIDatosProfLayout.setHorizontalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleEspecialidad).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, 0, 894, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstadoEspe).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGrabar, -2, 162, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosProfLayout.createSequentialGroup().addComponent(this.JTFTarjetaP, -2, 214, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHActivoCita, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHIps, -1, 200, 32767).addGap(6, 6, 6).addComponent(this.JCHEsVacunador).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 482, -2))).addContainerGap()));
        JPIDatosProfLayout.setVerticalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JTFTarjetaP, -2, 50, -2)).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsVacunador, -2, 50, -2).addComponent(this.JCHIps, -2, 50, -2).addComponent(this.JCHActivoCita, -2, 50, -2))).addGap(15, 15, 15).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -1, 50, 32767).addComponent(this.JBTGrabar, -2, 45, -2).addComponent(this.JCHEstadoEspe, -2, 36, -2)).addGap(5, 5, 5).addComponent(this.JSPDetalleEspecialidad, -2, 220, -2).addContainerGap()));
        this.JTPDatosCuenta.addTab("PROFESIONAL", this.JPIDatosProf);
        this.JPIDatosModulos.setEnabled(false);
        this.JCHEstadoModulo.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoModulo.setForeground(Color.blue);
        this.JCHEstadoModulo.setSelected(true);
        this.JCHEstadoModulo.setText("Estado");
        this.JCHEstadoModulo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.10
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEstadoModuloActionPerformed(evt);
            }
        });
        this.JCBModulo.setFont(new Font("Arial", 1, 12));
        this.JCBModulo.setBorder(BorderFactory.createTitledBorder((Border) null, "Módulos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGrabar1.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar1.setText("Grabar");
        this.JBTGrabar1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.11
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTGrabar1ActionPerformed(evt);
            }
        });
        this.JSPDetalleModulo.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleModulo.setFont(new Font("Arial", 1, 12));
        this.JTDetalleModulo.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleModulo.setRowHeight(25);
        this.JTDetalleModulo.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleModulo.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleModulo.setSelectionMode(0);
        this.JTDetalleModulo.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.12
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTDetalleModuloMouseClicked(evt);
            }
        });
        this.JSPDetalleModulo.setViewportView(this.JTDetalleModulo);
        GroupLayout JPIDatosModulosLayout = new GroupLayout(this.JPIDatosModulos);
        this.JPIDatosModulos.setLayout(JPIDatosModulosLayout);
        JPIDatosModulosLayout.setHorizontalGroup(JPIDatosModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosModulosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBModulo, -2, 629, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 298, 32767).addComponent(this.JCHEstadoModulo).addGap(18, 18, 18).addComponent(this.JBTGrabar1, -2, 129, -2).addContainerGap()).addGroup(JPIDatosModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosModulosLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JSPDetalleModulo, -1, 1124, 32767).addGap(15, 15, 15))));
        JPIDatosModulosLayout.setVerticalGroup(JPIDatosModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosModulosLayout.createSequentialGroup().addGap(27, 27, 27).addGroup(JPIDatosModulosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBModulo, -1, 50, 32767).addComponent(this.JCHEstadoModulo).addComponent(this.JBTGrabar1, -2, 47, -2)).addGap(222, 222, 222)).addGroup(JPIDatosModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosModulosLayout.createSequentialGroup().addGap(99, 99, 99).addComponent(this.JSPDetalleModulo, -1, 273, 32767).addContainerGap())));
        this.JTPDatosCuenta.addTab("MODULOS", this.JPIDatosModulos);
        this.JPIDatosBodega.setEnabled(false);
        this.JCHEstadoBodega.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoBodega.setForeground(Color.blue);
        this.JCHEstadoBodega.setSelected(true);
        this.JCHEstadoBodega.setText("Estado");
        this.JCHEstadoBodega.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.13
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEstadoBodegaActionPerformed(evt);
            }
        });
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGrabarB.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarB.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarB.setText("Grabar");
        this.JBTGrabarB.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.14
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTGrabarBActionPerformed(evt);
            }
        });
        this.JSPDetalleBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleBodega.setFont(new Font("Arial", 1, 12));
        this.JTDetalleBodega.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleBodega.setRowHeight(25);
        this.JTDetalleBodega.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleBodega.setSelectionForeground(Color.red);
        this.JTDetalleBodega.setSelectionMode(0);
        this.JTDetalleBodega.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.15
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTDetalleBodegaMouseClicked(evt);
            }
        });
        this.JSPDetalleBodega.setViewportView(this.JTDetalleBodega);
        GroupLayout JPIDatosBodegaLayout = new GroupLayout(this.JPIDatosBodega);
        this.JPIDatosBodega.setLayout(JPIDatosBodegaLayout);
        JPIDatosBodegaLayout.setHorizontalGroup(JPIDatosBodegaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBodegaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBBodega, -2, 629, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 298, 32767).addComponent(this.JCHEstadoBodega).addGap(18, 18, 18).addComponent(this.JBTGrabarB, -2, 129, -2).addContainerGap()).addGroup(JPIDatosBodegaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBodegaLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JSPDetalleBodega, -1, 1124, 32767).addGap(15, 15, 15))));
        JPIDatosBodegaLayout.setVerticalGroup(JPIDatosBodegaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBodegaLayout.createSequentialGroup().addGap(27, 27, 27).addGroup(JPIDatosBodegaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBBodega, -1, 50, 32767).addComponent(this.JCHEstadoBodega).addComponent(this.JBTGrabarB, -2, 47, -2)).addGap(222, 222, 222)).addGroup(JPIDatosBodegaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBodegaLayout.createSequentialGroup().addGap(99, 99, 99).addComponent(this.JSPDetalleBodega, -1, 273, 32767).addContainerGap())));
        this.JTPDatosCuenta.addTab("BODEGA", this.JPIDatosBodega);
        this.JPIDatosCaja.setEnabled(false);
        this.JCHEstadoCaja.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoCaja.setForeground(Color.blue);
        this.JCHEstadoCaja.setSelected(true);
        this.JCHEstadoCaja.setText("Estado");
        this.JCHEstadoCaja.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.16
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEstadoCajaActionPerformed(evt);
            }
        });
        this.JCBCaja.setFont(new Font("Arial", 1, 12));
        this.JCBCaja.setBorder(BorderFactory.createTitledBorder((Border) null, "Caja", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGrabarC.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarC.setText("Grabar");
        this.JBTGrabarC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.17
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTGrabarCActionPerformed(evt);
            }
        });
        this.JSPDetalleCaja.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleCaja.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.18
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JSPDetalleCajaMouseClicked(evt);
            }
        });
        this.JTDetalleCaja.setFont(new Font("Arial", 1, 12));
        this.JTDetalleCaja.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleCaja.setRowHeight(25);
        this.JTDetalleCaja.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleCaja.setSelectionForeground(Color.red);
        this.JTDetalleCaja.setSelectionMode(0);
        this.JTDetalleCaja.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.19
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTDetalleCajaMouseClicked(evt);
            }
        });
        this.JSPDetalleCaja.setViewportView(this.JTDetalleCaja);
        GroupLayout JPIDatosCajaLayout = new GroupLayout(this.JPIDatosCaja);
        this.JPIDatosCaja.setLayout(JPIDatosCajaLayout);
        JPIDatosCajaLayout.setHorizontalGroup(JPIDatosCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCajaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBCaja, -2, 629, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 298, 32767).addComponent(this.JCHEstadoCaja).addGap(18, 18, 18).addComponent(this.JBTGrabarC, -2, 129, -2).addContainerGap()).addGroup(JPIDatosCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCajaLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JSPDetalleCaja, -1, 1124, 32767).addGap(15, 15, 15))));
        JPIDatosCajaLayout.setVerticalGroup(JPIDatosCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCajaLayout.createSequentialGroup().addGap(27, 27, 27).addGroup(JPIDatosCajaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCaja, -1, 50, 32767).addComponent(this.JCHEstadoCaja).addComponent(this.JBTGrabarC, -2, 47, -2)).addGap(222, 222, 222)).addGroup(JPIDatosCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCajaLayout.createSequentialGroup().addGap(99, 99, 99).addComponent(this.JSPDetalleCaja, -1, 273, 32767).addContainerGap())));
        this.JTPDatosCuenta.addTab("CAJA MENOR", this.JPIDatosCaja);
        this.JCBCajas.setFont(new Font("Arial", 1, 12));
        this.JCBCajas.setBorder(BorderFactory.createTitledBorder((Border) null, "Caja", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCajas.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.20
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCBCajasActionPerformed(evt);
            }
        });
        this.JCHEstadoCajas.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoCajas.setForeground(Color.blue);
        this.JCHEstadoCajas.setSelected(true);
        this.JCHEstadoCajas.setText("Estado");
        this.JCHEstadoCajas.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.21
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEstadoCajasActionPerformed(evt);
            }
        });
        this.JBTGrabarCS.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarCS.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarCS.setText("Grabar");
        this.JBTGrabarCS.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.22
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTGrabarCSActionPerformed(evt);
            }
        });
        this.JSPDetalleCajas.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleCajas.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.23
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JSPDetalleCajasMouseClicked(evt);
            }
        });
        this.JTDetalleCajas.setFont(new Font("Arial", 1, 12));
        this.JTDetalleCajas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleCajas.setRowHeight(25);
        this.JTDetalleCajas.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleCajas.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleCajas.setSelectionMode(0);
        this.JTDetalleCajas.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.24
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTDetalleCajasMouseClicked(evt);
            }
        });
        this.JSPDetalleCajas.setViewportView(this.JTDetalleCajas);
        GroupLayout JPIDatosCajasLayout = new GroupLayout(this.JPIDatosCajas);
        this.JPIDatosCajas.setLayout(JPIDatosCajasLayout);
        JPIDatosCajasLayout.setHorizontalGroup(JPIDatosCajasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCajasLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosCajasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCajasLayout.createSequentialGroup().addComponent(this.JCBCajas, -2, 539, -2).addGap(29, 29, 29).addComponent(this.JCHEstadoCajas).addGap(43, 43, 43).addComponent(this.JBTGrabarCS, -1, -1, 32767)).addComponent(this.JSPDetalleCajas, -1, 1133, 32767)).addGap(10, 10, 10)));
        JPIDatosCajasLayout.setVerticalGroup(JPIDatosCajasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCajasLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosCajasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCajas, -1, 50, 32767).addComponent(this.JCHEstadoCajas).addComponent(this.JBTGrabarCS, -2, 50, -2)).addGap(10, 10, 10).addComponent(this.JSPDetalleCajas, -1, 292, 32767).addGap(10, 10, 10)));
        this.JTPDatosCuenta.addTab("CAJA", this.JPIDatosCajas);
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGrabarS.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarS.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabarS.setText("Grabar");
        this.JBTGrabarS.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.25
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTGrabarSActionPerformed(evt);
            }
        });
        this.JCHEstadoSede.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoSede.setForeground(Color.blue);
        this.JCHEstadoSede.setSelected(true);
        this.JCHEstadoSede.setText("Estado");
        this.JCHEstadoSede.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.26
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEstadoSedeActionPerformed(evt);
            }
        });
        this.JTDetalleSede.setFont(new Font("Arial", 1, 12));
        this.JTDetalleSede.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleSede.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleSede.setSelectionForeground(Color.red);
        this.JTDetalleSede.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.27
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTDetalleSedeMouseClicked(evt);
            }
        });
        this.JSPDetalleSede.setViewportView(this.JTDetalleSede);
        GroupLayout JPIDatosSedeLayout = new GroupLayout(this.JPIDatosSede);
        this.JPIDatosSede.setLayout(JPIDatosSedeLayout);
        JPIDatosSedeLayout.setHorizontalGroup(JPIDatosSedeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSedeLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosSedeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleSede, -1, 1141, 32767).addGroup(JPIDatosSedeLayout.createSequentialGroup().addComponent(this.JCBSede, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JCHEstadoSede).addGap(32, 32, 32).addComponent(this.JBTGrabarS, -2, 129, -2))).addContainerGap()));
        JPIDatosSedeLayout.setVerticalGroup(JPIDatosSedeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSedeLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPIDatosSedeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSedeLayout.createSequentialGroup().addGroup(JPIDatosSedeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabarS, -2, 47, -2).addComponent(this.JCHEstadoSede)).addGap(0, 0, 32767)).addComponent(this.JCBSede)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleSede, -2, 211, -2).addGap(222, 222, 222)));
        this.JTPDatosCuenta.addTab("SEDE", this.JPIDatosSede);
        this.JSPMenuTree.setBorder(BorderFactory.createTitledBorder((Border) null, "PARAMETRIZACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Grabar Parametrizacion");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.28
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JSPMenuTreeCalidad.setBorder(BorderFactory.createTitledBorder((Border) null, "SISTEMA GESTIÓN DE CALIDAD", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBGrabar1.setFont(new Font("Arial", 1, 12));
        this.JBGrabar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar1.setText("Grabar SGC");
        this.JBGrabar1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.29
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBGrabar1ActionPerformed(evt);
            }
        });
        GroupLayout JPMenuUsuarioLayout = new GroupLayout(this.JPMenuUsuario);
        this.JPMenuUsuario.setLayout(JPMenuUsuarioLayout);
        JPMenuUsuarioLayout.setHorizontalGroup(JPMenuUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMenuUsuarioLayout.createSequentialGroup().addContainerGap().addGroup(JPMenuUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBGrabar, -1, -1, 32767).addComponent(this.JSPMenuTree, -2, 500, -2)).addGap(53, 53, 53).addGroup(JPMenuUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPMenuTreeCalidad, -1, 500, 32767).addComponent(this.JBGrabar1, -1, -1, 32767)).addContainerGap(94, 32767)));
        JPMenuUsuarioLayout.setVerticalGroup(JPMenuUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMenuUsuarioLayout.createSequentialGroup().addContainerGap().addGroup(JPMenuUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPMenuTreeCalidad, -2, 246, -2).addComponent(this.JSPMenuTree, -2, 246, -2)).addGap(18, 18, 32767).addGroup(JPMenuUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGrabar1, -2, 34, -2).addComponent(this.JBGrabar, -2, 34, -2)).addContainerGap()));
        this.JTPDatosCuenta.addTab("MENÚ", this.JPMenuUsuario);
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFUsuarioSistema.30
            public void itemStateChanged(ItemEvent evt) {
                JIFUsuarioSistema.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JCBUnidadF.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.31
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCBUnidadFActionPerformed(evt);
            }
        });
        this.JCBCargo.setFont(new Font("Arial", 1, 12));
        this.JCBCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCargo.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFUsuarioSistema.32
            public void itemStateChanged(ItemEvent evt) {
                JIFUsuarioSistema.this.JCBCargoItemStateChanged(evt);
            }
        });
        this.JDFFechaIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaIngreso.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaIngreso.setFont(new Font("Arial", 1, 12));
        this.JTFFSalario.setBorder(BorderFactory.createTitledBorder((Border) null, "Salario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSalario.setHorizontalAlignment(4);
        this.JTFFSalario.setFont(new Font("Arial", 1, 12));
        this.JCHSIntegral.setFont(new Font("Arial", 1, 12));
        this.JCHSIntegral.setForeground(Color.blue);
        this.JCHSIntegral.setText(" Integral?");
        this.JCHSIntegral.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.33
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHSIntegralActionPerformed(evt);
            }
        });
        this.JTFRuta1.setFont(new Font("Arial", 1, 12));
        this.JTFRuta1.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Firma", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta1.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.34
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTFRuta1MouseClicked(evt);
            }
        });
        this.JCHEstadoRH.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoRH.setForeground(Color.blue);
        this.JCHEstadoRH.setSelected(true);
        this.JCHEstadoRH.setText("Estado");
        this.JCHEstadoRH.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.35
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEstadoRHActionPerformed(evt);
            }
        });
        this.JCHLider.setFont(new Font("Arial", 1, 12));
        this.JCHLider.setForeground(Color.blue);
        this.JCHLider.setText("Lider?");
        this.JCHLider.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.36
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHLiderActionPerformed(evt);
            }
        });
        this.JCHFijo.setFont(new Font("Arial", 1, 12));
        this.JCHFijo.setForeground(Color.blue);
        this.JCHFijo.setSelected(true);
        this.JCHFijo.setText("Fijo?");
        this.JCHFijo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.37
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHFijoActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.38
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalleC);
        this.JSPFRiesgoArp.setFont(new Font("Arial", 1, 12));
        this.JSPFRiesgoArp.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPFRiesgoArp.setToolTipText("% Calculo Riesgo Arp");
        this.JSPFRiesgoArp.setBorder(BorderFactory.createTitledBorder((Border) null, "% Riesgo Arp", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTpclasificasion.setFont(new Font("Arial", 1, 12));
        this.JCBTpclasificasion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTpclasificasion.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFUsuarioSistema.39
            public void itemStateChanged(ItemEvent evt) {
                JIFUsuarioSistema.this.JCBTpclasificasionItemStateChanged(evt);
            }
        });
        this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setHorizontalAlignment(4);
        this.JTFFCantidad.setToolTipText("Valor trabajado de acuerdo a la forma de pago");
        this.JTFFCantidad.setFont(new Font("Arial", 1, 12));
        this.JTFFCantidad.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.40
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JTFFCantidadActionPerformed(evt);
            }
        });
        this.JPI_FUtilizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRB_FP_Dias.setFont(new Font("Arial", 1, 12));
        this.JRB_FP_Dias.setSelected(true);
        this.JRB_FP_Dias.setText("Dias");
        this.JRB_FP_Dias.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.41
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRB_FP_DiasActionPerformed(evt);
            }
        });
        this.JRB_FP_Horas.setFont(new Font("Arial", 1, 12));
        this.JRB_FP_Horas.setText("Horas");
        this.JRB_FP_Horas.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.42
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRB_FP_HorasActionPerformed(evt);
            }
        });
        this.JRB_FP_Jornal.setFont(new Font("Arial", 1, 12));
        this.JRB_FP_Jornal.setText("Jornal");
        this.JRB_FP_Jornal.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.43
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRB_FP_JornalActionPerformed(evt);
            }
        });
        GroupLayout JPI_FUtilizacionLayout = new GroupLayout(this.JPI_FUtilizacion);
        this.JPI_FUtilizacion.setLayout(JPI_FUtilizacionLayout);
        JPI_FUtilizacionLayout.setHorizontalGroup(JPI_FUtilizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_FP_Dias).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_FP_Horas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_FP_Jornal).addContainerGap(-1, 32767)));
        JPI_FUtilizacionLayout.setVerticalGroup(JPI_FUtilizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizacionLayout.createSequentialGroup().addGroup(JPI_FUtilizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FP_Jornal).addComponent(this.JRB_FP_Horas).addComponent(this.JRB_FP_Dias)).addGap(0, 0, 32767)));
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "DECRETO 785", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFCodigoD785.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoD785.setToolTipText("Codigo de acuerdo al decreto 785");
        this.JTFCodigoD785.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFGrado.setFont(new Font("Arial", 1, 12));
        this.JTFGrado.setToolTipText("Grado de acuerdo al decreto 785");
        this.JTFGrado.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigoD785, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFGrado, -2, 93, -2).addGap(10, 10, 10)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoD785, -2, 50, -2).addComponent(this.JTFGrado, -2, 50, -2)).addGap(15, 15, 15)));
        this.JLBIdPersonaRH.setFont(new Font("Arial", 1, 14));
        this.JLBIdPersonaRH.setForeground(Color.blue);
        this.JLBIdPersonaRH.setHorizontalAlignment(0);
        this.JLBIdPersonaRH.setText("0");
        this.JLBIdPersonaRH.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo RH", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTGrabarS1.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarS1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabarS1.setText("Grabar");
        this.JBTGrabarS1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.44
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTGrabarS1ActionPerformed(evt);
            }
        });
        this.JBTNuevo.setFont(new Font("Arial", 1, 12));
        this.JBTNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBTNuevo.setText("Nuevo");
        this.JBTNuevo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.45
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTNuevoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosProf1Layout = new GroupLayout(this.JPIDatosProf1);
        this.JPIDatosProf1.setLayout(JPIDatosProf1Layout);
        JPIDatosProf1Layout.setHorizontalGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProf1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProf1Layout.createSequentialGroup().addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProf1Layout.createSequentialGroup().addComponent(this.JDFFechaIngreso, -2, 131, -2).addGap(18, 18, 18).addComponent(this.JTFFSalario, -2, 170, -2)).addComponent(this.JTFRuta1, GroupLayout.Alignment.TRAILING, -2, 319, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProf1Layout.createSequentialGroup().addComponent(this.JSPFRiesgoArp, -2, 111, -2).addGap(3, 3, 3).addComponent(this.JCBTpclasificasion, -2, 318, -2).addGap(116, 116, 116).addComponent(this.JPI_FUtilizacion, -2, -1, -2)).addGroup(JPIDatosProf1Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProf1Layout.createSequentialGroup().addComponent(this.JCHFijo).addGap(29, 29, 29).addComponent(this.JCHLider)).addGroup(JPIDatosProf1Layout.createSequentialGroup().addComponent(this.JCHSIntegral).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstadoRH))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCantidad, -2, 149, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel8, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTNuevo, -1, -1, 32767).addComponent(this.JBTGrabarS1, -1, -1, 32767))))).addComponent(this.JSPDetalle, -2, 1096, -2).addGroup(JPIDatosProf1Layout.createSequentialGroup().addComponent(this.JCBUnidadF, -2, 505, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCargo, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBIdPersonaRH, -2, 121, -2))).addContainerGap()));
        JPIDatosProf1Layout.setVerticalGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProf1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadF).addComponent(this.JCBCargo).addComponent(this.JLBIdPersonaRH, -2, 50, -2)).addGap(5, 5, 5).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProf1Layout.createSequentialGroup().addComponent(this.JDFFechaIngreso, -2, 67, -2).addGap(5, 5, 5).addComponent(this.JTFRuta1, -2, 50, -2)).addGroup(JPIDatosProf1Layout.createSequentialGroup().addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProf1Layout.createSequentialGroup().addGap(7, 7, 7).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSalario, -2, 50, -2).addComponent(this.JSPFRiesgoArp, -2, 49, -2).addComponent(this.JCBTpclasificasion, -2, 51, -2))).addComponent(this.JPI_FUtilizacion, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosProf1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSIntegral).addComponent(this.JCHEstadoRH)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFijo).addComponent(this.JCHLider)).addGap(17, 17, 17)).addGroup(JPIDatosProf1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosProf1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel8, -2, 74, -2).addComponent(this.JTFFCantidad, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosProf1Layout.createSequentialGroup().addComponent(this.JBTNuevo, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTGrabarS1))))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 91, -2).addGap(206, 206, 206)));
        this.JTPDatosCuenta.addTab("DATOS RRHH", this.JPIDatosProf1);
        this.JBTNuevoSispro.setFont(new Font("Arial", 1, 12));
        this.JBTNuevoSispro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBTNuevoSispro.setText("Nuevo");
        this.JBTNuevoSispro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.46
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTNuevoSisproActionPerformed(evt);
            }
        });
        this.JCHEstadoSispro.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoSispro.setForeground(Color.blue);
        this.JCHEstadoSispro.setSelected(true);
        this.JCHEstadoSispro.setText("Estado");
        this.JCHEstadoSispro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.47
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEstadoSisproActionPerformed(evt);
            }
        });
        this.JBTGrabarUsuarioSispro.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarUsuarioSispro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabarUsuarioSispro.setText("Grabar");
        this.JBTGrabarUsuarioSispro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.48
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JBTGrabarUsuarioSisproActionPerformed(evt);
            }
        });
        this.JTFClave.setFont(new Font("Arial", 1, 12));
        this.JTFClave.setBorder(BorderFactory.createTitledBorder((Border) null, "Clave", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTableUsuarioSIspro.setFont(new Font("Arial", 1, 12));
        this.JTableUsuarioSIspro.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTableUsuarioSIspro.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFUsuarioSistema.49
            public void mouseClicked(MouseEvent evt) {
                JIFUsuarioSistema.this.JTableUsuarioSIsproMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTableUsuarioSIspro);
        this.JCHReps.setFont(new Font("Arial", 1, 12));
        this.JCHReps.setForeground(Color.blue);
        this.JCHReps.setSelected(true);
        this.JCHReps.setText("Reps");
        this.JCHReps.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.50
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHRepsActionPerformed(evt);
            }
        });
        this.JCHMecanismoValidacion.setFont(new Font("Arial", 1, 12));
        this.JCHMecanismoValidacion.setForeground(Color.blue);
        this.JCHMecanismoValidacion.setSelected(true);
        this.JCHMecanismoValidacion.setText("Mecanismo Validacion");
        this.JCHMecanismoValidacion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.51
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHMecanismoValidacionActionPerformed(evt);
            }
        });
        GroupLayout JPIUsuarioSisproLayout = new GroupLayout(this.JPIUsuarioSispro);
        this.JPIUsuarioSispro.setLayout(JPIUsuarioSisproLayout);
        JPIUsuarioSisproLayout.setHorizontalGroup(JPIUsuarioSisproLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUsuarioSisproLayout.createSequentialGroup().addContainerGap().addGroup(JPIUsuarioSisproLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1).addGroup(JPIUsuarioSisproLayout.createSequentialGroup().addComponent(this.JTFClave, -2, 519, -2).addGap(18, 18, 18).addComponent(this.JCHEstadoSispro).addGap(18, 18, 18).addComponent(this.JCHMecanismoValidacion).addGap(18, 18, 18).addComponent(this.JCHReps).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, 32767).addGroup(JPIUsuarioSisproLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrabarUsuarioSispro, GroupLayout.Alignment.TRAILING, -2, 200, -2).addComponent(this.JBTNuevoSispro, GroupLayout.Alignment.TRAILING, -2, 200, -2)))).addGap(39, 39, 39)));
        JPIUsuarioSisproLayout.setVerticalGroup(JPIUsuarioSisproLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUsuarioSisproLayout.createSequentialGroup().addGroup(JPIUsuarioSisproLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUsuarioSisproLayout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JBTNuevoSispro, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGrabarUsuarioSispro, -2, 50, -2)).addGroup(JPIUsuarioSisproLayout.createSequentialGroup().addGap(33, 33, 33).addGroup(JPIUsuarioSisproLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFClave, -2, 50, -2).addGroup(JPIUsuarioSisproLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstadoSispro, -2, 39, -2).addComponent(this.JCHMecanismoValidacion, -2, 39, -2).addComponent(this.JCHReps, -2, 39, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, 227, -2).addGap(192, 192, 192)));
        this.JTPDatosCuenta.addTab("USUARIO SISPRO", this.JPIUsuarioSispro);
        this.JTPInformacion.setForeground(Color.red);
        this.JTPInformacion.setFont(new Font("Arial", 1, 14));
        this.JPDatosContra.setBorder(BorderFactory.createEtchedBorder());
        this.JTFLogin.setFont(new Font("Arial", 1, 12));
        this.JTFLogin.setBorder(BorderFactory.createTitledBorder((Border) null, "Login", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPFContasena.setFont(new Font("Arial", 1, 12));
        this.JTPFContasena.setBorder(BorderFactory.createTitledBorder((Border) null, "Contraseña", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHProfesional.setFont(new Font("Arial", 1, 12));
        this.JCHProfesional.setForeground(Color.blue);
        this.JCHProfesional.setText("Es Profesional?");
        this.JCHProfesional.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.52
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHProfesionalActionPerformed(evt);
            }
        });
        this.JCHBodega.setFont(new Font("Arial", 1, 12));
        this.JCHBodega.setForeground(Color.blue);
        this.JCHBodega.setText("Maneja Bodega?");
        this.JCHBodega.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.53
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHBodegaActionPerformed(evt);
            }
        });
        this.JCHCajero.setFont(new Font("Arial", 1, 12));
        this.JCHCajero.setForeground(Color.blue);
        this.JCHCajero.setText("Es Cajero?");
        this.JCHCajero.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.54
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHCajeroActionPerformed(evt);
            }
        });
        this.JCHAnular.setFont(new Font("Arial", 1, 12));
        this.JCHAnular.setForeground(Color.blue);
        this.JCHAnular.setText("Puede Anular?");
        this.JCHAnular.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.55
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHAnularActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.56
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JDFFechaUC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ultimo Cambio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaUC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaUC.setFont(new Font("Arial", 1, 12));
        this.JDFFechaFC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Bloqueo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaFC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaFC.setFont(new Font("Arial", 1, 12));
        this.JCHConsulta.setFont(new Font("Arial", 1, 12));
        this.JCHConsulta.setForeground(Color.blue);
        this.JCHConsulta.setText("Es consulta?");
        this.JCHConsulta.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.57
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHConsultaActionPerformed(evt);
            }
        });
        this.JCHDescuento.setFont(new Font("Arial", 1, 12));
        this.JCHDescuento.setForeground(Color.blue);
        this.JCHDescuento.setText("Descuento");
        this.JCHDescuento.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.58
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHDescuentoActionPerformed(evt);
            }
        });
        this.JCHConductor.setFont(new Font("Arial", 1, 12));
        this.JCHConductor.setForeground(Color.blue);
        this.JCHConductor.setText("Conductor");
        this.JCHConductor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.59
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JCHConductorActionPerformed(evt);
            }
        });
        GroupLayout JPDatosContraLayout = new GroupLayout(this.JPDatosContra);
        this.JPDatosContra.setLayout(JPDatosContraLayout);
        JPDatosContraLayout.setHorizontalGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosContraLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFLogin, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPFContasena, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaUC, -2, 142, -2).addGap(18, 18, 18).addComponent(this.JDFFechaFC, -2, 144, -2).addGap(18, 18, 18).addGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHProfesional, -1, -1, 32767).addComponent(this.JCHBodega)).addGap(18, 18, 18).addGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAnular).addComponent(this.JCHCajero)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosContraLayout.createSequentialGroup().addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHConsulta)).addGroup(JPDatosContraLayout.createSequentialGroup().addComponent(this.JCHDescuento).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHConductor))).addContainerGap(132, 32767)));
        JPDatosContraLayout.setVerticalGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosContraLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaUC, -2, 51, -2).addComponent(this.JDFFechaFC, -2, 51, -2)).addComponent(this.JCHCajero).addGroup(JPDatosContraLayout.createSequentialGroup().addGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHProfesional).addGroup(GroupLayout.Alignment.TRAILING, JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHDescuento).addComponent(this.JCHConductor))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHBodega).addComponent(this.JCHAnular).addComponent(this.JCHEstado).addComponent(this.JCHConsulta))).addGroup(JPDatosContraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFLogin, -2, 51, -2).addComponent(this.JTPFContasena, -2, 51, -2))).addContainerGap(27, 32767)));
        this.JTPInformacion.addTab("CONTRATO", this.JPDatosContra);
        this.JPAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Autorizacion del Laboratorio", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JPAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JBGAutorizacionLAB.add(this.JRBValidaGraba);
        this.JRBValidaGraba.setFont(new Font("Arial", 1, 12));
        this.JRBValidaGraba.setText("Valida y Graba");
        this.JRBValidaGraba.setToolTipText("");
        this.JRBValidaGraba.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.60
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRBValidaGrabaActionPerformed(evt);
            }
        });
        this.JBGAutorizacionLAB.add(this.JRBGraba);
        this.JRBGraba.setFont(new Font("Arial", 1, 12));
        this.JRBGraba.setText("Graba");
        this.JRBGraba.setToolTipText("");
        this.JRBGraba.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.61
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRBGrabaActionPerformed(evt);
            }
        });
        this.JBGAutorizacionLAB.add(this.JRBValida);
        this.JRBValida.setFont(new Font("Arial", 1, 12));
        this.JRBValida.setText("Valida");
        this.JRBValida.setToolTipText("");
        this.JRBValida.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.62
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRBValidaActionPerformed(evt);
            }
        });
        this.JBGAutorizacionLAB.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setText("Todos");
        this.JRBTodos.setToolTipText("");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.63
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JBGAutorizacionLAB.add(this.JRBNoAplica);
        this.JRBNoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBNoAplica.setText("No Aplica");
        this.JRBNoAplica.setToolTipText("");
        this.JRBNoAplica.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.64
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRBNoAplicaActionPerformed(evt);
            }
        });
        GroupLayout JPAutorizacionLayout = new GroupLayout(this.JPAutorizacion);
        this.JPAutorizacion.setLayout(JPAutorizacionLayout);
        JPAutorizacionLayout.setHorizontalGroup(JPAutorizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPAutorizacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(this.JRBValida).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBGraba).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBValidaGraba).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBTodos).addContainerGap()));
        JPAutorizacionLayout.setVerticalGroup(JPAutorizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAutorizacionLayout.createSequentialGroup().addGroup(JPAutorizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBValida).addComponent(this.JRBGraba).addComponent(this.JRBValidaGraba).addComponent(this.JRBTodos).addComponent(this.JRBNoAplica)).addGap(0, 0, 0)));
        this.JPAutorizacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Usuario", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JPAutorizacion1.setFont(new Font("Arial", 1, 12));
        this.JBGTipoUsuario.add(this.JRBSuper);
        this.JRBSuper.setFont(new Font("Arial", 1, 12));
        this.JRBSuper.setText("Super");
        this.JRBSuper.setToolTipText("");
        this.JRBSuper.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.65
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRBSuperActionPerformed(evt);
            }
        });
        this.JBGTipoUsuario.add(this.JRBAdministrador);
        this.JRBAdministrador.setFont(new Font("Arial", 1, 12));
        this.JRBAdministrador.setText("Administrador");
        this.JRBAdministrador.setToolTipText("");
        this.JRBAdministrador.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.66
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRBAdministradorActionPerformed(evt);
            }
        });
        this.JBGTipoUsuario.add(this.JRBNormal);
        this.JRBNormal.setFont(new Font("Arial", 1, 12));
        this.JRBNormal.setSelected(true);
        this.JRBNormal.setText("Normal");
        this.JRBNormal.setToolTipText("");
        this.JRBNormal.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.67
            public void actionPerformed(ActionEvent evt) {
                JIFUsuarioSistema.this.JRBNormalActionPerformed(evt);
            }
        });
        GroupLayout JPAutorizacion1Layout = new GroupLayout(this.JPAutorizacion1);
        this.JPAutorizacion1.setLayout(JPAutorizacion1Layout);
        JPAutorizacion1Layout.setHorizontalGroup(JPAutorizacion1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPAutorizacion1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBNormal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBAdministrador).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSuper).addGap(194, 194, 194)));
        JPAutorizacion1Layout.setVerticalGroup(JPAutorizacion1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAutorizacion1Layout.createSequentialGroup().addGroup(JPAutorizacion1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAdministrador).addComponent(this.JRBSuper).addComponent(this.JRBNormal)).addGap(0, 0, 0)));
        GroupLayout JPAdicionalLayout = new GroupLayout(this.JPAdicional);
        this.JPAdicional.setLayout(JPAdicionalLayout);
        JPAdicionalLayout.setHorizontalGroup(JPAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAdicionalLayout.createSequentialGroup().addContainerGap().addComponent(this.JPAutorizacion, -2, -1, -2).addGap(35, 35, 35).addComponent(this.JPAutorizacion1, -2, 268, -2).addContainerGap(400, 32767)));
        JPAdicionalLayout.setVerticalGroup(JPAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPAutorizacion1, -2, -1, -2).addComponent(this.JPAutorizacion, -2, -1, -2)).addContainerGap(42, 32767)));
        this.JTPInformacion.addTab("ADICIONAL", this.JPAdicional);
        GroupLayout JPIDatosCuentaLayout = new GroupLayout(this.JPIDatosCuenta);
        this.JPIDatosCuenta.setLayout(JPIDatosCuentaLayout);
        JPIDatosCuentaLayout.setHorizontalGroup(JPIDatosCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCuentaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosCuenta).addComponent(this.JTPInformacion, -2, 0, 32767)).addContainerGap()));
        JPIDatosCuentaLayout.setVerticalGroup(JPIDatosCuentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCuentaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPInformacion, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTPDatosCuenta, -2, 409, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosCuenta, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPIFDatosUsuario, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIDatosCuenta, -2, -1, -2).addGap(10, 10, 10)));
        getAccessibleContext().setAccessibleName("usuario");
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHProfesionalActionPerformed(ActionEvent evt) {
        if (this.JCHProfesional.isSelected()) {
            this.JTPDatosCuenta.setEnabledAt(0, true);
        } else {
            this.JTPDatosCuenta.setEnabledAt(0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCajeroActionPerformed(ActionEvent evt) {
        if (this.JCHCajero.isSelected()) {
            this.xescajero = 1;
        } else {
            this.xescajero = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBodegaActionPerformed(ActionEvent evt) {
        if (this.JCHBodega.isSelected()) {
            this.xesbodega = 1;
            this.JTPDatosCuenta.setEnabledAt(2, true);
        } else {
            this.xesbodega = 0;
            this.JTPDatosCuenta.setEnabledAt(2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAnularActionPerformed(ActionEvent evt) {
        if (this.JCHAnular.isSelected()) {
            this.xesanular = 1;
        } else {
            this.xesanular = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConsultaActionPerformed(ActionEvent evt) {
        if (this.JCHConsulta.isSelected()) {
            this.xesconsulta = 1;
        } else {
            this.xesconsulta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCajasMouseClicked(MouseEvent evt) {
        if (this.JTDetalleCajas.getSelectedRow() != -1) {
            this.JCBCajas.setSelectedItem(this.xmodelocs.getValueAt(this.JTDetalleCajas.getSelectedRow(), 0).toString());
            this.JCHEstadoCajas.setSelected(Boolean.valueOf(this.xmodelocs.getValueAt(this.JTDetalleCajas.getSelectedRow(), 1).toString()).booleanValue());
            this.xencontrocajas = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarCSActionPerformed(ActionEvent evt) {
        String sql;
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBCajas.getSelectedIndex() != -1) {
                if (this.xencontrocajas) {
                    sql = "update g_usuariosxcajac set Estado='" + this.xestadocajas + "' where Id_Persona='" + Principal.txtNo.getText() + "' and Id_Caja='" + this.xidcajas[this.JCBCajas.getSelectedIndex()] + "'";
                } else {
                    sql = "Insert ignore into g_usuariosxcajac(Id_persona, Id_Caja, Estado, UsuarioS) values ('" + Principal.txtNo.getText() + "','" + this.xidcajas[this.JCBCajas.getSelectedIndex()] + "','" + this.xestadocajas + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                }
                this.xencontrocajas = false;
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTablaCajas(xjppersona.getIdPersona());
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una caja", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBCajas.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoCajasActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoCajas.isSelected()) {
            this.xestadocajas = 1;
        } else {
            this.xestadocajas = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCajaMouseClicked(MouseEvent evt) {
        if (this.JTDetalleCaja.getSelectedRow() != -1) {
            this.JCBCaja.setSelectedItem(this.xmodeloc.getValueAt(this.JTDetalleCaja.getSelectedRow(), 0).toString());
            this.JCHEstadoCaja.setSelected(Boolean.valueOf(this.xmodeloc.getValueAt(this.JTDetalleCaja.getSelectedRow(), 1).toString()).booleanValue());
            this.xencontrocaja = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarCActionPerformed(ActionEvent evt) {
        String sql;
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBCaja.getSelectedIndex() != -1) {
                if (this.xencontrocaja) {
                    sql = "update g_usuariosxcaja set Estado='" + this.xestadocaja + "' where Id_Persona='" + Principal.txtNo.getText() + "' and Id_TipoCaja='" + this.xidcaja[this.JCBCaja.getSelectedIndex()] + "'";
                } else {
                    sql = "Insert into g_usuariosxcaja(Id_persona, Id_TipoCaja, Estado, Fecha, UsuarioS) values ('" + Principal.txtNo.getText() + "','" + this.xidcaja[this.JCBCaja.getSelectedIndex()] + "','" + this.xestadocaja + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                }
                this.xencontrocaja = false;
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTablaCaja(xjppersona.getIdPersona());
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una caja", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBCaja.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoCajaActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoCaja.isSelected()) {
            this.xestadocaja = 1;
        } else {
            this.xestadocaja = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleBodegaMouseClicked(MouseEvent evt) {
        if (this.JTDetalleBodega.getSelectedRow() != -1) {
            this.JCBBodega.setSelectedItem(this.xmodelob.getValueAt(this.JTDetalleBodega.getSelectedRow(), 0).toString());
            this.JCHEstadoBodega.setSelected(Boolean.valueOf(this.xmodelob.getValueAt(this.JTDetalleBodega.getSelectedRow(), 1).toString()).booleanValue());
            this.xencontrobodegas = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarBActionPerformed(ActionEvent evt) {
        String sql;
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBBodega.getSelectedIndex() != -1) {
                if (this.xencontrobodegas) {
                    sql = "update g_usuariosxbodega set Estado='" + this.xestadobodega + "' where Id_Persona='" + Principal.txtNo.getText() + "' and Id_Bodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'";
                } else {
                    sql = "Insert ignore into g_usuariosxbodega(Id_persona, Id_Bodega, Estado, Fecha, UsuarioS) values ('" + Principal.txtNo.getText() + "','" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "','" + this.xestadobodega + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                }
                this.xencontrobodegas = false;
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTablaBodega(xjppersona.getIdPersona());
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBBodega.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoBodegaActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoBodega.isSelected()) {
            this.xestadobodega = 1;
        } else {
            this.xestadobodega = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleModuloMouseClicked(MouseEvent evt) {
        if (this.JTDetalleModulo.getSelectedRow() != -1) {
            this.JCBModulo.setSelectedItem(this.xmodelom.getValueAt(this.JTDetalleModulo.getSelectedRow(), 0).toString());
            this.JCHEstadoModulo.setSelected(Boolean.valueOf(this.xmodelom.getValueAt(this.JTDetalleModulo.getSelectedRow(), 1).toString()).booleanValue());
            this.xencontrousuariomodulo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabar1ActionPerformed(ActionEvent evt) {
        String sql;
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBModulo.getSelectedIndex() != -1) {
                if (this.xencontrousuariomodulo) {
                    sql = "update g_usuariosxmodulo set Estado='" + this.xestadomodulo + "' where Id_persona='" + Principal.txtNo.getText() + "' and Id_Modulo='" + this.xidmodulo[this.JCBModulo.getSelectedIndex()] + "'";
                } else {
                    sql = "Insert ignore into g_usuariosxmodulo(Id_persona, Id_Modulo, Estado, Fecha, UsuarioS) values ('" + Principal.txtNo.getText() + "','" + this.xidmodulo[this.JCBModulo.getSelectedIndex()] + "','" + this.xestadomodulo + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                }
                this.xencontrousuariomodulo = false;
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTablaModulo(xjppersona.getIdPersona());
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un módulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBModulo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoModuloActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoModulo.isSelected()) {
            this.xestadomodulo = 0;
        } else {
            this.xestadomodulo = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        String sql;
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                mGrabarProfesional();
                if (!this.xmetodos.mVerificarDatosDoblesTabla(this.JTDetalle, 0, this.JCBEspecialidad.getSelectedItem().toString()) || (this.xencontroespprofesional && this.JTDetalle.getSelectedRow() != -1)) {
                    if (this.xencontroespprofesional && this.JTDetalle.getSelectedRow() != -1) {
                        sql = "update g_profesionalespecial set Estado='" + this.xesprofesional + "' where Id_Profesional='" + Principal.txtNo.getText() + "' and Id_Especialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'";
                    } else {
                        sql = "Insert IGNORE into g_profesionalespecial(Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) values ('" + Principal.txtNo.getText() + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xesprofesional + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                    this.xconsultas.ejecutarSQL(sql);
                    this.xconsultas.cerrarConexionBd();
                    mCargarDatosTablaProfesional(xjppersona.getIdPersona());
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Especialidad ya registrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoEspeActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoEspe.isSelected()) {
            this.xesprofesional = 0;
        } else {
            this.xesprofesional = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        System.out.println("this.JTDetalle.getSelectedRow()-->" + this.JTDetalle.getSelectedRow());
        if (this.JTDetalle.getSelectedRow() != -1) {
            System.out.println("this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()-->" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBEspecialidad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCHEstadoEspe.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmetodos.getDirectorioExportacion() + "Firmas");
            FileNameExtensionFilter Imagenes = new FileNameExtensionFilter("Archivos de Imagenes (bmp, jpg, jpeg, png)", new String[]{"bmp", "jpg", "jpeg", "png"});
            xfilec.addChoosableFileFilter(Imagenes);
            xfilec.setAcceptAllFileFilterUsed(false);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getPath());
                this.JTFRuta.setText(this.xfile.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHIpsActionPerformed(ActionEvent evt) {
        if (this.JCHIps.isSelected()) {
            this.xips = 1;
        } else {
            this.xips = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoCitaActionPerformed(ActionEvent evt) {
        if (this.JCHActivoCita.isSelected()) {
            this.xactivocita = 0;
        } else {
            this.xactivocita = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        if (!xjppersona.getIdPersona().equals("0")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar la configuración del Menú?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xBuildChecBoxTree.printTree(this.xBuildChecBoxTree.tree, this.xBuildChecBoxTree.root, xjppersona.getIdPersona());
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe cargar un Usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabar1ActionPerformed(ActionEvent evt) {
        if (!xjppersona.getIdPersona().equals("0")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar la configuración del Menú?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xBuildChecBoxTreeCal.printTree(this.xBuildChecBoxTreeCal.tree, this.xBuildChecBoxTreeCal.root, xjppersona.getIdPersona());
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe cargar un Usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleCajasMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCajasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleCajaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsVacunadorActionPerformed(ActionEvent evt) {
        if (this.JCHEsVacunador.isSelected()) {
            this.xVacunador = 1;
        } else {
            this.xVacunador = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarSActionPerformed(ActionEvent evt) {
        String sql;
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBSede.getSelectedIndex() != -1) {
                if (this.xencontrosede) {
                    sql = "update g_usuario_sist_sede set Estado='" + this.xestadosede + "' where Id_Persona='" + Principal.txtNo.getText() + "' and Id_Sede='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "'";
                } else {
                    sql = "Insert ignore into g_usuario_sist_sede(Id_Persona, Id_Sede, Estado, Id_UsuarioS) values ('" + Principal.txtNo.getText() + "','" + this.xidsede[this.JCBSede.getSelectedIndex()] + "','" + this.xestadosede + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                }
                this.xencontrosede = false;
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTablaSede(xjppersona.getIdPersona());
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBSede.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoSedeActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoSede.isSelected()) {
            this.xestadosede = 1;
        } else {
            this.xestadosede = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSedeMouseClicked(MouseEvent evt) {
        if (this.JTDetalleSede.getSelectedRow() != -1) {
            this.JCBSede.setSelectedItem(this.xmodeloS.getValueAt(this.JTDetalleSede.getSelectedRow(), 0).toString());
            this.JCHEstadoSede.setSelected(Boolean.valueOf(this.xmodeloS.getValueAt(this.JTDetalleSede.getSelectedRow(), 1).toString()).booleanValue());
            this.xencontrosede = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBValidaActionPerformed(ActionEvent evt) {
        this.xautorizacionLAB = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGrabaActionPerformed(ActionEvent evt) {
        this.xautorizacionLAB = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBValidaGrabaActionPerformed(ActionEvent evt) {
        this.xautorizacionLAB = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xautorizacionLAB = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoAplicaActionPerformed(ActionEvent evt) {
        this.xautorizacionLAB = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadF.getSelectedIndex() != -1) {
            this.xlleno1 = false;
            this.JCBCargo.removeAllItems();
            String sql = "SELECT rh_unidadf_cargo.Id, rh_tipo_cargo.Nbre, rh_tipo_cargo.`Codigo` FROM rh_unidadf_cargo INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) WHERE (rh_unidadf_cargo.Estado =1 AND rh_unidadf_cargo.Id_UnidadF ='" + this.xidunidadf[this.JCBUnidadF.getSelectedIndex()] + "' ) order by rh_tipo_cargo.Nbre";
            this.xidcargo = this.xconsultas.llenarComboyLista(sql, this.xidcargo, this.JCBCargo, 3);
            this.JCBCargo.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCargoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBCargo.getSelectedIndex() != -1) {
            this.JTFCodigoD785.setText(this.xidcargo[this.JCBCargo.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSIntegralActionPerformed(ActionEvent evt) {
        if (this.JCHSIntegral.isSelected()) {
            this.xesintegral = 1;
        } else {
            this.xesintegral = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmetodos.getDirectorioExportacion() + "Firmas");
            FileNameExtensionFilter Imagenes = new FileNameExtensionFilter("Archivos de Imagenes (bmp, jpg, jpeg, png)", new String[]{"bmp", "jpg", "jpeg", "png"});
            xfilec.addChoosableFileFilter(Imagenes);
            xfilec.setAcceptAllFileFilterUsed(false);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getPath());
                this.JTFRuta.setText(this.xfile.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoRHActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLiderActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFijoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTpclasificasionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCantidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FP_DiasActionPerformed(ActionEvent evt) {
        this.xformapago = 0;
        mChangeCantidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FP_HorasActionPerformed(ActionEvent evt) {
        this.xformapago = 1;
        mChangeCantidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FP_JornalActionPerformed(ActionEvent evt) {
        this.xformapago = 2;
        mChangeCantidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarS1ActionPerformed(ActionEvent evt) {
        mGrabarRH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
        if (this.JTDetalleC.getSelectedRow() != -1) {
            this.JLBIdPersonaRH.setText(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 0).toString());
            this.JCBUnidadF.setSelectedItem(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 1).toString());
            this.JCBCargo.setSelectedItem(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString());
            this.JCHLider.setSelected(Boolean.valueOf(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 3).toString()).booleanValue());
            this.JCHFijo.setSelected(Boolean.valueOf(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 4).toString()).booleanValue());
            this.JTFRuta.setText(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 5).toString());
            this.JCHEstadoRH.setSelected(Boolean.valueOf(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 6).toString()).booleanValue());
            this.JDFFechaIngreso.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 7).toString()));
            this.JTFFSalario.setValue(Double.valueOf(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 8).toString()));
            this.JCHSIntegral.setSelected(Boolean.valueOf(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 9).toString()).booleanValue());
            this.JSPFRiesgoArp.setValue(Double.valueOf(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 10).toString()));
            this.JCBTpclasificasion.setSelectedItem(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 11).toString());
            switch (Integer.valueOf(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 12).toString()).intValue()) {
                case 0:
                    this.JRB_FP_Dias.setSelected(true);
                    this.xformapago = 0;
                    break;
                case 1:
                    this.JRB_FP_Horas.setSelected(true);
                    this.xformapago = 1;
                    break;
                case 2:
                    this.JRB_FP_Jornal.setSelected(true);
                    this.xformapago = 2;
                    break;
            }
            this.JTFFCantidad.setValue(Double.valueOf(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 13).toString()));
            this.JTFCodigoD785.setText(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 14).toString());
            this.JTFGrado.setText(this.xmodeloRH.getValueAt(this.JTDetalleC.getSelectedRow(), 15).toString());
            mChangeCantidad();
            mIniciarCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNuevoActionPerformed(ActionEvent evt) {
        mnuevoRH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDescuentoActionPerformed(ActionEvent evt) {
        if (this.JCHDescuento.isSelected()) {
            this.xdescuento = 1;
        } else {
            this.xdescuento = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConductorActionPerformed(ActionEvent evt) {
        if (this.JCHConductor.isSelected()) {
            this.xconductor = 1;
        } else {
            this.xconductor = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarUsuarioSisproActionPerformed(ActionEvent evt) {
        mGrabarUsuarioSispro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNuevoSisproActionPerformed(ActionEvent evt) {
        mNuevoSispro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoSisproActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoSispro.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableUsuarioSIsproMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTableUsuarioSIspro.getSelectedRow() != -1) {
            this.id = Long.valueOf(this.JTableUsuarioSIspro.getValueAt(this.JTableUsuarioSIspro.getSelectedRow(), 0).toString());
            this.JCHMecanismoValidacion.setSelected(Boolean.valueOf(this.JTableUsuarioSIspro.getValueAt(this.JTableUsuarioSIspro.getSelectedRow(), 2).toString()).booleanValue());
            this.JTFClave.setText(this.JTableUsuarioSIspro.getValueAt(this.JTableUsuarioSIspro.getSelectedRow(), 3).toString());
            this.JCHReps.setSelected(Boolean.valueOf(this.JTableUsuarioSIspro.getValueAt(this.JTableUsuarioSIspro.getSelectedRow(), 4).toString()).booleanValue());
            this.JCHEstadoSispro.setSelected(Boolean.parseBoolean(this.xmodeloSispro.getValueAt(this.JTableUsuarioSIspro.getSelectedRow(), 5).toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRepsActionPerformed(ActionEvent evt) {
        this.reps = this.JCHReps.isSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMecanismoValidacionActionPerformed(ActionEvent evt) {
        this.tipoMecanismoValidacion = this.JCHMecanismoValidacion.isSelected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSuperActionPerformed(ActionEvent evt) {
        this.xesadministrativo = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAdministradorActionPerformed(ActionEvent evt) {
        this.xesadministrativo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNormalActionPerformed(ActionEvent evt) {
        this.xesadministrativo = 0;
    }

    private void mCargasPanelUsuario() {
        xjppersona = new Persona(this);
        xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void mBuscarUsuarioSistema(String xid) {
        String sql = "SELECT Login, Clave, Estado, EsProfesional, Bodega, EsCajero, EsAdministrativo, Anular, FechaUltimoC, FechaFinC, Fecha, UsuarioS, EsConsulta, PLaboratorio,Descuento, Conductor FROM g_usuario_sist WHERE (Id_Persona ='" + xid + "') ";
        ResultSet rs = this.xconsultas.traerRs(sql);
        System.out.println("----------------------------" + sql);
        try {
            if (rs.next()) {
                rs.first();
                Principal.txtNo.setText(xid);
                this.JTFLogin.setText(rs.getString(1));
                this.JCHEstado.setSelected(!rs.getBoolean(3));
                if (!rs.getBoolean(3)) {
                    this.xestado = 0;
                } else {
                    this.xestado = 1;
                }
                this.JCHProfesional.setSelected(rs.getBoolean(4));
                if (rs.getBoolean(4)) {
                    this.JTPDatosCuenta.setEnabledAt(0, true);
                    this.xesprofesional = 1;
                } else {
                    this.JTPDatosCuenta.setEnabledAt(0, false);
                    this.xesprofesional = 0;
                }
                this.JCHBodega.setSelected(rs.getBoolean(5));
                if (rs.getBoolean(5)) {
                    this.JTPDatosCuenta.setEnabledAt(2, true);
                    this.xesbodega = 1;
                } else {
                    this.JTPDatosCuenta.setEnabledAt(2, false);
                    this.xesbodega = 0;
                }
                this.JCHCajero.setSelected(rs.getBoolean(6));
                if (rs.getBoolean(6)) {
                    this.xescajero = 1;
                } else {
                    this.xescajero = 0;
                }
                switch (rs.getInt(7)) {
                    case 1:
                        this.xesadministrativo = 1;
                        this.JRBAdministrador.setSelected(true);
                        break;
                    case 2:
                        this.xesadministrativo = 2;
                        this.JRBSuper.setSelected(true);
                        break;
                    default:
                        this.xesadministrativo = 0;
                        this.JRBNormal.setSelected(true);
                        break;
                }
                this.JCHAnular.setSelected(rs.getBoolean(8));
                if (rs.getBoolean(8)) {
                    this.xesanular = 1;
                } else {
                    this.xesanular = 0;
                }
                this.JDFFechaUC.setDate(rs.getDate(9));
                this.JDFFechaFC.setDate(rs.getDate(10));
                if (rs.getLong(13) == 1) {
                    this.JCHConsulta.setSelected(true);
                } else {
                    this.JCHConsulta.setSelected(false);
                }
                this.xautorizacionLAB = rs.getInt(14);
                switch (rs.getInt(14)) {
                    case -1:
                        this.JRBNoAplica.setSelected(true);
                        break;
                    case 0:
                        this.JRBValida.setSelected(true);
                        break;
                    case 1:
                        this.JRBGraba.setSelected(true);
                        break;
                    case 2:
                        this.JRBValidaGraba.setSelected(true);
                        break;
                    case 3:
                        this.JRBTodos.setSelected(true);
                        break;
                }
                this.JCHDescuento.setSelected(rs.getBoolean(15));
                if (rs.getBoolean(15)) {
                    this.xdescuento = 1;
                } else {
                    this.xdescuento = 0;
                }
                if (rs.getInt(16) == 1) {
                    this.JCHConductor.setSelected(true);
                } else {
                    this.JCHConductor.setSelected(false);
                }
                this.xencontrousuario = true;
                mBuscarProfesional(xid);
                mCargarDatosTablaModulo(xid);
                mCargarDatosTablaBodega(xid);
                mCargarDatosTablaCaja(xid);
                mCargarDatosTablaCajas(xid);
                mCargarDatosTablaSede(xid);
                this.xBuildChecBoxTree.mSeleccionar(xjppersona.getIdPersona());
                this.xBuildChecBoxTreeCal.mSeleccionar(xjppersona.getIdPersona());
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFUsuarioSistema.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarProfesional(String xidusuario) {
        String sql = "SELECT Tarjeta, Activo_Cita, P_Ips, IF(DireccionF IS NULL, '',DireccionF) AS Firma, Id_Persona  FROM g_profesional WHERE (Id_Persona ='" + xidusuario + "')";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTFTarjetaP.setText(xrs.getString(1));
                this.JCHActivoCita.setSelected(!xrs.getBoolean(2));
                this.JCHIps.setSelected(xrs.getBoolean(3));
                this.JTFRuta.setText(xrs.getString(4));
                this.xencontroprofesional = true;
                this.JTPDatosCuenta.setEnabledAt(0, true);
                mCargarDatosTablaProfesional(xidusuario);
                if (this.xencontroprofesional) {
                    this.JCHProfesional.setSelected(true);
                }
            } else {
                this.xencontroprofesional = false;
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFUsuarioSistema.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        Principal.mLimpiarDatosP();
        xjppersona.nuevo();
        this.JCBEspecialidad.removeAllItems();
        this.xidespecialidad = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBModulo.removeAllItems();
        this.xidmodulo = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_modulos WHERE (Estado =0) ORDER BY Nbre", this.xidmodulo, this.JCBModulo);
        this.JCBModulo.setSelectedIndex(-1);
        this.JCBBodega.removeAllItems();
        this.xidbodega = this.xconsultas.llenarCombo("SELECT Id, UCASE(Nbre) FROM i_bodegas WHERE (Estado =0) ORDER BY Nbre ASC", this.xidbodega, this.JCBBodega);
        this.JCBBodega.setSelectedIndex(-1);
        this.JCBCaja.removeAllItems();
        this.xidcaja = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_tipo_caja WHERE (Estado =1) ORDER BY Nbre ASC", this.xidcaja, this.JCBCaja);
        this.JCBCaja.setSelectedIndex(-1);
        this.JCBCajas.removeAllItems();
        this.xidcajas = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM k_caja WHERE (Estado =1) ORDER BY Nbre ASC", this.xidcajas, this.JCBCajas);
        this.JCBCajas.setSelectedIndex(-1);
        this.JCBSede.removeAllItems();
        this.xidsede = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_sedes WHERE (Estado =1) ORDER BY Nbre ASC", this.xidsede, this.JCBSede);
        this.JCBSede.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.xesadministrativo = 0;
        this.JRBNormal.setSelected(false);
        this.xesprofesional = 0;
        this.JCHProfesional.setSelected(false);
        this.xesbodega = 0;
        this.JCHBodega.setSelected(false);
        this.xescajero = 0;
        this.JCHCajero.setSelected(false);
        this.xesanular = 0;
        this.JCHAnular.setSelected(false);
        this.JDFFechaFC.setDate(this.xmetodos.getFechaActual());
        this.JDFFechaUC.setDate(this.xmetodos.getFechaActual());
        this.xestado = 0;
        this.JCHEstado.setSelected(true);
        this.JTFLogin.setText("");
        this.JTFRuta.setText("");
        this.JTFTarjetaP.setText("");
        this.JTPFContasena.setText("");
        this.xactivocita = 0;
        this.JCHActivoCita.setSelected(true);
        this.xips = 1;
        this.JCHIps.setSelected(true);
        this.xestadomodulo = 0;
        this.JCHEstadoModulo.setSelected(true);
        this.xestadobodega = 1;
        this.JCHEstadoBodega.setSelected(true);
        this.xestadocaja = 1;
        this.JCHEstadoCaja.setSelected(true);
        this.xestadocajas = 1;
        this.JCHEstadoSede.setSelected(true);
        this.xestadosede = 1;
        this.JCHEstadoCajas.setSelected(true);
        this.JTPDatosCuenta.setEnabledAt(0, false);
        this.JTPDatosCuenta.setEnabledAt(2, false);
        this.xesconsulta = 0;
        this.JCHConsulta.setSelected(false);
        this.xencontroprofesional = false;
        this.xencontrousuario = false;
        this.xencontroespprofesional = false;
        this.JCHEsVacunador.setSelected(false);
        this.xVacunador = 0;
        this.JRBNoAplica.setSelected(true);
        this.xautorizacionLAB = -1;
        mnuevoRH();
        mCrearModeloDatosBodega();
        mCrearModeloDatosCaja();
        mCrearModeloDatosCajas();
        mCrearModeloDatosModulo();
        mCrearModeloDatosProfesional();
        mCrearModeloDatosSede();
        this.xBuildChecBoxTree.mNuevo();
        this.xBuildChecBoxTreeCal.mNuevo();
        this.xlleno = true;
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            cargarTablaUsuarioSispro();
        } else {
            this.JTPDatosCuenta.setEnabledAt(8, false);
        }
    }

    private void mGrabarUsuarioSistema() {
        String sql;
        if (!this.JTFLogin.getText().isEmpty()) {
            if (this.xencontrousuario) {
                if (this.JTPFContasena.getPassword().length == 0) {
                    sql = "update g_usuario_sist set Estado='" + this.xestado + "', Login='" + this.JTFLogin.getText() + "', EsProfesional='" + this.xesprofesional + "', Bodega='" + this.xesbodega + "', EsCajero='" + this.xescajero + "', EsAdministrativo='" + this.xesadministrativo + "', FechaUltimoC='" + this.xmetodos.formatoAMD.format(this.JDFFechaUC.getDate()) + "', FechaFinC='" + this.xmetodos.formatoAMD.format(this.JDFFechaFC.getDate()) + "', Anular='" + this.xesanular + "', EsConsulta='" + this.xesconsulta + "', PLaboratorio='" + this.xautorizacionLAB + "', Descuento='" + this.xdescuento + "', Conductor='" + this.xconductor + "' where Id_Persona='" + Principal.txtNo.getText() + "'";
                } else {
                    sql = "update g_usuario_sist set Estado='" + this.xestado + "', Login='" + this.JTFLogin.getText() + "', Clave='" + this.xmetodos.getEncryptedPassword(new String(this.JTPFContasena.getPassword())) + "', EsProfesional='" + this.xesprofesional + "', Bodega='" + this.xesbodega + "', EsCajero='" + this.xescajero + "', EsAdministrativo='" + this.xesadministrativo + "', FechaUltimoC='" + this.xmetodos.formatoAMD.format(this.JDFFechaUC.getDate()) + "', FechaFinC='" + this.xmetodos.formatoAMD.format(this.JDFFechaFC.getDate()) + "', Anular='" + this.xesanular + "', EsConsulta='" + this.xesconsulta + "', PLaboratorio='" + this.xautorizacionLAB + "', Descuento='" + this.xdescuento + "', Conductor='" + this.xconductor + "' where Id_Persona='" + Principal.txtNo.getText() + "'";
                }
            } else {
                sql = "Insert into g_usuario_sist(Id_Persona, Login, Clave, Estado, EsProfesional, Bodega, EsCajero,Descuento, EsAdministrativo, FechaUltimoC, FechaFinC, Anular, EsConsulta, PLaboratorio, Fecha, UsuarioS, Conductor) values ('" + Principal.txtNo.getText() + "','" + this.JTFLogin.getText() + "','" + this.xmetodos.getEncryptedPassword(new String(this.JTPFContasena.getPassword())) + "','" + this.xestado + "','" + this.xesprofesional + "','" + this.xesbodega + "','" + this.xescajero + "','" + this.xdescuento + "','" + this.xesadministrativo + "','" + this.xmetodos.formatoAMD.format(this.JDFFechaUC.getDate()) + "','" + this.xmetodos.formatoAMD.format(this.JDFFechaFC.getDate()) + "','" + this.xesanular + "','" + this.xesconsulta + "','" + this.xautorizacionLAB + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xconductor + "')";
            }
            this.xconsultas.ejecutarSQL(sql);
            this.xconsultas.cerrarConexionBd();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Login no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFLogin.requestFocus();
    }

    private boolean mValidadDUsuarioSistema() {
        boolean xs = false;
        if (!this.JTFLogin.getText().isEmpty()) {
            xs = true;
        } else {
            JOptionPane.showInternalMessageDialog(this, "Login no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFLogin.requestFocus();
        }
        return xs;
    }

    private void mGrabarProfesional() {
        String sql;
        if (this.JCHProfesional.isSelected()) {
            if (this.xencontroprofesional) {
                sql = "update g_profesional set Tarjeta='" + this.JTFTarjetaP.getText() + "', Activo_Cita='" + this.xactivocita + "', P_Ips='" + this.xips + "', EsVacunador='" + this.xVacunador + "', DireccionF='" + this.JTFRuta.getText() + "' where Id_Persona='" + xjppersona.getIdPersona() + "'";
            } else {
                sql = "Insert into g_profesional(Id_persona, Tarjeta, Activo_Cita, P_Ips, DireccionF,EsVacunador, Fecha, UsuarioS) values ('" + xjppersona.getIdPersona() + "','" + this.JTFTarjetaP.getText() + "','" + this.xactivocita + "','" + this.xips + "','" + this.JTFRuta.getText() + "','" + this.xVacunador + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xencontroprofesional = true;
            }
            this.xconsultas.ejecutarSQL(sql);
            this.xconsultas.cerrarConexionBd();
            mCargarDatosTablaBodega(xjppersona.getIdPersona());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosModulo() {
        this.xmodelom = new DefaultTableModel(new Object[0], new String[]{"Modulo", "Estado", ""}) { // from class: ParametrizacionN.JIFUsuarioSistema.68
            Class[] types = {String.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleModulo.setModel(this.xmodelom);
        this.JTDetalleModulo.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleModulo.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleModulo.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalleModulo.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalleModulo.getColumnModel().getColumn(2).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosProfesional() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Especialidad", "Estado"}) { // from class: ParametrizacionN.JIFUsuarioSistema.69
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosBodega() {
        this.xmodelob = new DefaultTableModel(new Object[0], new String[]{"Bodega", "Estado"}) { // from class: ParametrizacionN.JIFUsuarioSistema.70
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleBodega.setModel(this.xmodelob);
        this.JTDetalleBodega.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleBodega.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCaja() {
        this.xmodeloc = new DefaultTableModel(new Object[0], new String[]{"Bodega", "Estado"}) { // from class: ParametrizacionN.JIFUsuarioSistema.71
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleCaja.setModel(this.xmodeloc);
        this.JTDetalleCaja.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleCaja.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCajas() {
        this.xmodelocs = new DefaultTableModel(new Object[0], new String[]{"Bodega", "Estado"}) { // from class: ParametrizacionN.JIFUsuarioSistema.72
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleCajas.setModel(this.xmodelocs);
        this.JTDetalleCajas.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleCajas.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosSede() {
        this.xmodeloS = new DefaultTableModel(new Object[0], new String[]{"Sede", "Estado"}) { // from class: ParametrizacionN.JIFUsuarioSistema.73
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleSede.setModel(this.xmodeloS);
        this.JTDetalleSede.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleSede.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    private void mCargarDatosTablaProfesional(String xidp) {
        try {
            mCrearModeloDatosProfesional();
            String sql = "SELECT g_especialidad.Nbre, g_profesionalespecial.Estado FROM g_profesionalespecial INNER JOIN g_especialidad  ON (g_profesionalespecial.Id_Especialidad = g_especialidad.Id) WHERE (g_profesionalespecial.Id_Profesional ='" + xidp + "')  ORDER BY g_especialidad.Estado ASC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(2)), n, 1);
                    this.xencontroespprofesional = true;
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaModulo(String xidp) {
        try {
            mCrearModeloDatosModulo();
            String sql = "SELECT g_modulos.Nbre, g_usuariosxmodulo.Estado, g_modulos.Id FROM g_usuariosxmodulo INNER JOIN g_modulos  ON (g_usuariosxmodulo.Id_Modulo = g_modulos.Id) WHERE (g_usuariosxmodulo.Id_persona ='" + xidp + "') ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelom.addRow(this.xdato);
                    this.xmodelom.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelom.setValueAt(Boolean.valueOf(!xrs.getBoolean(2)), n, 1);
                    this.xmodelom.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaBodega(String xidp) {
        try {
            mCrearModeloDatosBodega();
            String sql = "SELECT ucase(i_bodegas.Nbre), g_usuariosxbodega.Estado FROM g_usuariosxbodega INNER JOIN i_bodegas  ON (g_usuariosxbodega.Id_Bodega = i_bodegas.Id) WHERE (g_usuariosxbodega.Id_Persona ='" + xidp + "') ORDER BY i_bodegas.Nbre ASC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelob.addRow(this.xdato);
                    this.xmodelob.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelob.setValueAt(Boolean.valueOf(xrs.getBoolean(2)), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaCaja(String xidp) {
        try {
            mCrearModeloDatosCaja();
            String sql = "SELECT cc_tipo_caja.Nbre, g_usuariosxcaja.Estado FROM g_usuariosxcaja INNER JOIN cc_tipo_caja ON (g_usuariosxcaja.Id_TipoCaja = cc_tipo_caja.Id) WHERE (g_usuariosxcaja.Id_Persona ='" + xidp + "') ORDER BY cc_tipo_caja.Nbre ASC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloc.addRow(this.xdato);
                    this.xmodeloc.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloc.setValueAt(Boolean.valueOf(xrs.getBoolean(2)), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaCajas(String xidp) {
        try {
            mCrearModeloDatosCajas();
            String sql = "SELECT k_caja.Nbre, g_usuariosxcajac.Estado FROM g_usuariosxcajac INNER JOIN k_caja  ON (g_usuariosxcajac.Id_Caja = k_caja.Id) WHERE (g_usuariosxcajac.Id_Persona ='" + xidp + "') ORDER BY k_caja.Nbre ASC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelocs.addRow(this.xdato);
                    this.xmodelocs.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelocs.setValueAt(Boolean.valueOf(xrs.getBoolean(2)), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaSede(String xidp) {
        try {
            mCrearModeloDatosSede();
            String sql = "SELECT `g_sedes`.`Nbre`, `g_usuario_sist_sede`.`Estado` FROM `g_usuario_sist_sede` INNER JOIN `g_sedes` ON (`g_usuario_sist_sede`.`Id_Sede` = `g_sedes`.`Id`) WHERE (`g_usuario_sist_sede`.`Id_Persona` ='" + xidp + "') ORDER BY `g_sedes`.`Nbre` ASC;";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloS.addRow(this.xdato);
                    this.xmodeloS.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloS.setValueAt(Boolean.valueOf(xrs.getBoolean(2)), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, xjppersona);
        frmBuscar.setVisible(true);
    }

    public void mGrabar() {
        if (mValidadDUsuarioSistema() && xjppersona.validarDatos(1) == 1) {
            xjppersona.grabar();
            Principal.txtNo.setText(xjppersona.getIdPersona());
            mGrabarUsuarioSistema();
        }
    }

    public void getHojas(DefaultMutableTreeNode raiz, String id) {
        Object[][] data = select("g_menu_conf", " Id, menuName,Estado ", " parentId='" + id + "'");
        for (int i = 0; i < data.length; i++) {
            DefaultMutableTreeNode hoja = new DefaultMutableTreeNode(new CheckBoxNode(data[i][1].toString(), Status.DESELECTED, Integer.valueOf(data[i][0].toString()).intValue()));
            getHojas(hoja, data[i][0].toString());
            raiz.add(hoja);
        }
    }

    public Object[][] select(String table, String fields, String where) {
        int registros = 0;
        String[] colname = fields.split(",");
        String q = "SELECT " + fields + " FROM " + table;
        String q2 = "SELECT count(*) as total FROM " + table;
        if (where != null) {
            q = q + " WHERE " + where;
            q2 = q2 + " WHERE " + where;
        }
        ResultSet xrs = this.xconsultas.traerRs(q2);
        try {
            if (xrs.next()) {
                xrs.first();
                registros = xrs.getInt("total");
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFUsuarioSistema.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        Object[][] data = new String[registros][fields.split(",").length];
        ResultSet xrs2 = this.xconsultas.traerRs(q);
        try {
            if (xrs2.next()) {
                xrs2.beforeFirst();
                int i = 0;
                while (xrs2.next()) {
                    for (int j = 0; j <= fields.split(",").length - 1; j++) {
                        data[i][j] = xrs2.getString(colname[j].trim());
                    }
                    i++;
                }
            }
            xrs2.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex2) {
            Logger.getLogger(JIFUsuarioSistema.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        return data;
    }

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFUsuarioSistema$TriStateCheckBox.class */
    class TriStateCheckBox extends JCheckBox {
        private Icon currentIcon;

        TriStateCheckBox() {
        }

        public void updateUI() {
            this.currentIcon = getIcon();
            setIcon(null);
            super.updateUI();
            EventQueue.invokeLater(new Runnable() { // from class: ParametrizacionN.JIFUsuarioSistema.TriStateCheckBox.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TriStateCheckBox.this.currentIcon != null) {
                        TriStateCheckBox.this.setIcon(JIFUsuarioSistema.this.new IndeterminateIcon());
                    }
                    TriStateCheckBox.this.setOpaque(false);
                }
            });
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFUsuarioSistema$IndeterminateIcon.class */
    class IndeterminateIcon implements Icon {
        private static final int SIDE_MARGIN = 4;
        private static final int HEIGHT = 2;
        private final Color FOREGROUND = new Color(50, 20, 255, 200);
        private final Icon icon = UIManager.getIcon("CheckBox.icon");

        IndeterminateIcon() {
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            this.icon.paintIcon(c, g, x, y);
            int w = getIconWidth();
            int h = getIconHeight();
            Graphics2D g2 = g.create();
            g2.setPaint(this.FOREGROUND);
            g2.translate(x, y);
            g2.fillRect(SIDE_MARGIN, (h - HEIGHT) / HEIGHT, (w - SIDE_MARGIN) - SIDE_MARGIN, HEIGHT);
            g2.dispose();
        }

        public int getIconWidth() {
            return this.icon.getIconWidth();
        }

        public int getIconHeight() {
            return this.icon.getIconHeight();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFUsuarioSistema$CheckBoxNode.class */
    class CheckBoxNode {
        public final int Id;
        public final String label;
        public final Status status;

        public CheckBoxNode(String label, int Id) {
            this.Id = Id;
            this.label = label;
            this.status = Status.INDETERMINATE;
        }

        public CheckBoxNode(String label, Status status, int Id) {
            this.Id = Id;
            this.label = label;
            this.status = status;
        }

        public String toString() {
            return this.label;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFUsuarioSistema$CheckBoxStatusUpdateListener.class */
    class CheckBoxStatusUpdateListener implements TreeModelListener {
        private boolean adjusting;

        CheckBoxStatusUpdateListener() {
        }

        public void treeNodesChanged(TreeModelEvent e) {
            DefaultMutableTreeNode node;
            CheckBoxNode c;
            int xEstadoC;
            DefaultMutableTreeNode n;
            if (this.adjusting) {
                return;
            }
            this.adjusting = true;
            TreePath parent = e.getTreePath();
            Object[] children = e.getChildren();
            DefaultTreeModel model = (DefaultTreeModel) e.getSource();
            if (children != null && children.length == 1) {
                node = (DefaultMutableTreeNode) children[0];
                c = (CheckBoxNode) node.getUserObject();
                DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode) parent.getLastPathComponent();
                while (true) {
                    n = defaultMutableTreeNode;
                    if (n == null) {
                        break;
                    }
                    updateParentUserObject(n);
                    DefaultMutableTreeNode tmp = (DefaultMutableTreeNode) n.getParent();
                    if (tmp == null) {
                        break;
                    } else {
                        defaultMutableTreeNode = tmp;
                    }
                }
                model.nodeChanged(n);
            } else {
                node = (DefaultMutableTreeNode) model.getRoot();
                c = (CheckBoxNode) node.getUserObject();
            }
            System.out.println("c-->" + c.label);
            if (c.status == Status.SELECTED || c.status == Status.INDETERMINATE) {
                xEstadoC = 1;
            } else {
                xEstadoC = 0;
            }
            System.out.println("Guarda 1-->treeNodesChanged");
            mGuardaMenu(c.Id, xEstadoC);
            updateAllChildrenUserObject(node, c.status);
            model.nodeChanged(node);
            this.adjusting = false;
        }

        private void updateParentUserObject(DefaultMutableTreeNode parent) {
            int xEstadoC;
            String label = ((CheckBoxNode) parent.getUserObject()).label;
            int Id = ((CheckBoxNode) parent.getUserObject()).Id;
            int selectedCount = 0;
            int indeterminateCount = 0;
            Enumeration children = parent.children();
            int i = 0;
            while (true) {
                xEstadoC = i;
                if (!children.hasMoreElements()) {
                    break;
                }
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) children.nextElement();
                CheckBoxNode check = (CheckBoxNode) node.getUserObject();
                if (check.status == Status.INDETERMINATE) {
                    indeterminateCount = 0 + 1;
                    break;
                }
                if (check.status == Status.SELECTED) {
                    selectedCount++;
                }
                if (check.status == Status.SELECTED || check.status == Status.INDETERMINATE) {
                    i = 1;
                } else {
                    i = 0;
                }
            }
            System.out.println("Guarda 2-->updateParentUserObject");
            mGuardaMenu(Id, xEstadoC);
            if (indeterminateCount > 0) {
                parent.setUserObject(JIFUsuarioSistema.this.new CheckBoxNode(label, Id));
                return;
            }
            if (selectedCount == 0) {
                parent.setUserObject(JIFUsuarioSistema.this.new CheckBoxNode(label, Status.DESELECTED, Id));
            } else if (selectedCount == parent.getChildCount()) {
                parent.setUserObject(JIFUsuarioSistema.this.new CheckBoxNode(label, Status.SELECTED, Id));
            } else {
                parent.setUserObject(JIFUsuarioSistema.this.new CheckBoxNode(label, Id));
            }
        }

        private void updateAllChildrenUserObject(DefaultMutableTreeNode root, Status status) {
            int i;
            Enumeration breadth = root.breadthFirstEnumeration();
            while (breadth.hasMoreElements()) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) breadth.nextElement();
                if (!Objects.equals(root, node)) {
                    CheckBoxNode check = (CheckBoxNode) node.getUserObject();
                    if (status == Status.SELECTED || status == Status.INDETERMINATE) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    int xEstadoC = i;
                    System.out.println("Guarda 3-->updateAllChildrenUserObject");
                    mGuardaMenu(check.Id, xEstadoC);
                    System.out.println("label-->" + check.label + " status-->" + status + " Id-->" + check.Id);
                    node.setUserObject(JIFUsuarioSistema.this.new CheckBoxNode(check.label, status, check.Id));
                }
            }
        }

        public void updateAllChildrenUserObjectSearch(DefaultMutableTreeNode root, Status status) {
            Enumeration breadth = root.breadthFirstEnumeration();
            while (breadth.hasMoreElements()) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) breadth.nextElement();
                if (!Objects.equals(root, node)) {
                    CheckBoxNode check = (CheckBoxNode) node.getUserObject();
                    node.setUserObject(JIFUsuarioSistema.this.new CheckBoxNode(check.label, status, check.Id));
                }
            }
        }

        private void mGuardaMenu(int xIdMenu, int xEstado) {
            ConsultasMySQL xct = new ConsultasMySQL();
            if (!mVerificaMenu(xIdMenu)) {
                String sql = "INSERT INTO `g_usuario_sist_menu` (`IdUsuario`,`IdMenu`,`Estado`,`UsuarioS`) VALUES ('" + JIFUsuarioSistema.xjppersona.getIdPersona() + "','" + xIdMenu + "','" + xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                System.out.println("inserta menu-->" + sql);
                xct.ejecutarSQL(sql);
                xct.cerrarConexionBd();
                return;
            }
            if (xIdMenu != 1) {
                String sql2 = "UPDATE g_usuario_sist_menu SET Estado='" + xEstado + "' WHERE(IdMenu='" + xIdMenu + "' AND IdUsuario='" + JIFUsuarioSistema.xjppersona.getIdPersona() + "')";
                System.out.println("actualiza menu-->" + sql2);
                xct.ejecutarSQL(sql2);
                xct.cerrarConexionBd();
            }
        }

        private boolean mVerificaMenu(int xIdMenu) {
            boolean xExiste = false;
            String sql = "SELECT IdMenu,IdUsuario FROM g_usuario_sist_menu WHERE (IdMenu='" + xIdMenu + "'AND IdUsuario='" + JIFUsuarioSistema.xjppersona.getIdPersona() + "')";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xExiste = true;
                }
                xrs.close();
                xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFUsuarioSistema.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            return xExiste;
        }

        public void treeNodesInserted(TreeModelEvent e) {
        }

        public void treeNodesRemoved(TreeModelEvent e) {
        }

        public void treeStructureChanged(TreeModelEvent e) {
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFUsuarioSistema$CheckBoxNodeRenderer.class */
    class CheckBoxNodeRenderer extends TriStateCheckBox implements TreeCellRenderer {
        private final DefaultTreeCellRenderer renderer;
        private final JPanel panel;

        public CheckBoxNodeRenderer() {
            super();
            this.renderer = new DefaultTreeCellRenderer();
            this.panel = new JPanel(new BorderLayout());
            String uiName = getUI().getClass().getName();
            if (uiName.contains("Synth") && System.getProperty("java.version").startsWith("1.7.0")) {
                System.out.println("XXX: FocusBorder bug?, JDK 1.7.0, Nimbus start LnF");
                this.renderer.setBackgroundSelectionColor(new Color(0, 0, 0, 0));
            }
            this.panel.setFocusable(false);
            this.panel.setRequestFocusEnabled(false);
            this.panel.setOpaque(false);
            this.panel.add(this, "West");
            setOpaque(false);
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            JLabel l = this.renderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
            l.setFont(tree.getFont());
            if (value instanceof DefaultMutableTreeNode) {
                setEnabled(tree.isEnabled());
                setFont(tree.getFont());
                Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
                if (userObject instanceof CheckBoxNode) {
                    CheckBoxNode node = (CheckBoxNode) userObject;
                    if (node.status == Status.INDETERMINATE) {
                        setIcon(JIFUsuarioSistema.this.new IndeterminateIcon());
                    } else {
                        setIcon(null);
                    }
                    l.setText(node.label);
                    setSelected(node.status == Status.SELECTED);
                }
                this.panel.add(l);
                return this.panel;
            }
            return l;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFUsuarioSistema$CheckBoxNodeEditor.class */
    class CheckBoxNodeEditor extends TriStateCheckBox implements TreeCellEditor {
        private final DefaultTreeCellRenderer renderer;
        private final JPanel panel;
        private String str;
        private int IdNode;

        public CheckBoxNodeEditor() {
            super();
            this.renderer = new DefaultTreeCellRenderer();
            this.panel = new JPanel(new BorderLayout());
            addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFUsuarioSistema.CheckBoxNodeEditor.1
                public void actionPerformed(ActionEvent e) {
                    CheckBoxNodeEditor.this.stopCellEditing();
                }
            });
            this.panel.setFocusable(false);
            this.panel.setRequestFocusEnabled(false);
            this.panel.setOpaque(false);
            this.panel.add(this, "West");
            setOpaque(false);
        }

        public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
            JLabel l = this.renderer.getTreeCellRendererComponent(tree, value, true, expanded, leaf, row, true);
            l.setFont(tree.getFont());
            if (value instanceof DefaultMutableTreeNode) {
                setEnabled(tree.isEnabled());
                setFont(tree.getFont());
                Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
                if (userObject instanceof CheckBoxNode) {
                    CheckBoxNode node = (CheckBoxNode) userObject;
                    if (node.status == Status.INDETERMINATE) {
                        setIcon(JIFUsuarioSistema.this.new IndeterminateIcon());
                    } else {
                        setIcon(null);
                    }
                    l.setText(node.label);
                    setSelected(node.status == Status.SELECTED);
                    this.str = node.label;
                    this.IdNode = node.Id;
                }
                this.panel.add(l);
                return this.panel;
            }
            return l;
        }

        public Object getCellEditorValue() {
            return JIFUsuarioSistema.this.new CheckBoxNode(this.str, isSelected() ? Status.SELECTED : Status.DESELECTED, this.IdNode);
        }

        public boolean isCellEditable(EventObject e) {
            if ((e instanceof MouseEvent) && (e.getSource() instanceof JTree)) {
                MouseEvent me = (MouseEvent) e;
                JTree tree = (JTree) e.getSource();
                TreePath path = tree.getPathForLocation(me.getX(), me.getY());
                Rectangle r = tree.getPathBounds(path);
                if (r == null) {
                    return false;
                }
                Dimension d = getPreferredSize();
                r.setSize(new Dimension(d.width, r.height));
                if (r.contains(me.getX(), me.getY())) {
                    if (this.str == null && System.getProperty("java.version").startsWith("1.7.0")) {
                        System.out.println("XXX: Java 7, only on first run-->" + getBounds());
                        setBounds(new Rectangle(0, 0, d.width, r.height));
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // ParametrizacionN.JIFUsuarioSistema.TriStateCheckBox
        public void updateUI() {
            super.updateUI();
            setName("Tree.cellEditor");
            if (this.panel != null) {
                this.panel.updateUI();
            }
        }

        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

        public boolean stopCellEditing() {
            fireEditingStopped();
            return true;
        }

        public void cancelCellEditing() {
            fireEditingCanceled();
        }

        public void addCellEditorListener(CellEditorListener l) {
            this.listenerList.add(CellEditorListener.class, l);
        }

        public void removeCellEditorListener(CellEditorListener l) {
            this.listenerList.remove(CellEditorListener.class, l);
        }

        public CellEditorListener[] getCellEditorListeners() {
            return this.listenerList.getListeners(CellEditorListener.class);
        }

        protected void fireEditingStopped() {
            Object[] listeners = this.listenerList.getListenerList();
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == CellEditorListener.class) {
                    if (this.changeEvent == null) {
                        this.changeEvent = new ChangeEvent(this);
                    }
                    ((CellEditorListener) listeners[i + 1]).editingStopped(this.changeEvent);
                }
            }
        }

        protected void fireEditingCanceled() {
            Object[] listeners = this.listenerList.getListenerList();
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == CellEditorListener.class) {
                    if (this.changeEvent == null) {
                        this.changeEvent = new ChangeEvent(this);
                    }
                    ((CellEditorListener) listeners[i + 1]).editingCanceled(this.changeEvent);
                }
            }
        }
    }

    private void mChangeCantidad() {
        if (this.xformapago == 0) {
            this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad x Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else if (this.xformapago == 1) {
            this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad x Horas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else {
            this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad x Jornal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        }
    }

    private void mIniciarCheck() {
        if (this.JCHEstadoRH.isSelected()) {
            this.xestadoRH = 1;
        } else {
            this.xestadoRH = 0;
        }
        if (this.JCHLider.isSelected()) {
            this.xlider = 1;
        } else {
            this.xlider = 0;
        }
        if (this.JCHFijo.isSelected()) {
            this.xfijo = 1;
        } else {
            this.xfijo = 0;
        }
        if (this.JCHSIntegral.isSelected()) {
            this.xesintegral = 1;
        } else {
            this.xesintegral = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloRH() {
        this.xmodeloRH = new DefaultTableModel(new Object[0], new String[]{"Id", "Unidad Funcional", "Cargo", "Lider", "Fijo", "Url", "Estado", "FechaIngreso", "Salario", "SIntegral", "FRiesgoArp", "Clasificacion", "FPago", "Cantidad", "Codigo", "Grado"}) { // from class: ParametrizacionN.JIFUsuarioSistema.74
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class, String.class, Boolean.class, String.class, Double.class, Boolean.class, Double.class, String.class, Integer.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleC;
        JTable jTable2 = this.JTDetalleC;
        jTable.setAutoResizeMode(0);
        this.JTDetalleC.doLayout();
        this.JTDetalleC.setModel(this.xmodeloRH);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleC.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalleC.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(15).setPreferredWidth(100);
    }

    public void mCargarDatosTablaRH(String xidp) {
        try {
            mCrearModeloRH();
            String sql = "SELECT rh_tipo_persona_cargon.Id, rh_unidad_funcional.Nbre, rh_tipo_cargo.Nbre, rh_tipo_persona_cargon.Lider, rh_tipo_persona_cargon.Fijo, rh_tipo_persona_cargon.UrlFirma, rh_tipo_persona_cargon.Estado, DATE_FORMAT(rh_tipo_persona_cargon.FechaIngreso,'%d-%m-%Y') AS FIngreso, rh_tipo_persona_cargon.SalarioB, rh_tipo_persona_cargon.SIntegral, rh_tipo_persona_cargon.FRiesgoArp  ,rh_tipo_clasificacion.`Nbre` AS Clasificacion, rh_tipo_persona_cargon.FPago, rh_tipo_persona_cargon.Cantidad, rh_tipo_persona_cargon.Codigo, rh_tipo_persona_cargon.Grado  FROM rh_tipo_persona_cargon  INNER JOIN rh_unidadf_cargo ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_unidad_funcional   ON (rh_unidadf_cargo.Id_UnidadF = rh_unidad_funcional.Id) INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id)  INNER JOIN`rh_tipo_clasificacion`  ON (rh_tipo_clasificacion.`Id` = rh_tipo_persona_cargon.`Id_Clasificacion`)  WHERE (rh_tipo_persona_cargon.Id_Persona ='" + xidp + "') ORDER BY rh_unidad_funcional.Nbre ASC, rh_tipo_cargo.Nbre ASC";
            System.out.println(" datos rrhh " + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JLBIdPersonaRH.setText("0");
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloRH.addRow(this.xdato);
                    this.xmodeloRH.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodeloRH.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloRH.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloRH.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodeloRH.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodeloRH.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloRH.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodeloRH.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloRH.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodeloRH.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.xmodeloRH.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 10);
                    this.xmodeloRH.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloRH.setValueAt(Integer.valueOf(xrs.getInt(13)), n, 12);
                    this.xmodeloRH.setValueAt(Double.valueOf(xrs.getDouble(14)), n, 13);
                    this.xmodeloRH.setValueAt(xrs.getString(15), n, 14);
                    this.xmodeloRH.setValueAt(xrs.getString(16), n, 15);
                    this.xencontroacargo = true;
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mnuevoRH() {
        this.JLBIdPersonaRH.setText("0");
        this.JDFFechaIngreso.setDate(this.xmetodos.getFechaActual());
        this.JCBCargo.removeAllItems();
        this.JCBUnidadF.removeAllItems();
        this.xidunidadf = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM rh_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidunidadf, this.JCBUnidadF);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JCBTpclasificasion.removeAllItems();
        this.xclasificacion = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM `rh_tipo_clasificacion` WHERE (Estado =1) ORDER BY Nbre ASC", this.xclasificacion, this.JCBTpclasificasion);
        this.JCBTpclasificasion.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JTFFSalario.setValue(new Double(0.0d));
        this.JSPFRiesgoArp.setValue(new Double(0.0d));
        mChangeCantidad();
        this.JTFRuta.setText("");
        this.JCHFijo.setSelected(true);
        this.xfijo = 1;
        this.JCHEstadoRH.setSelected(true);
        this.xestadoRH = 1;
        this.JCHLider.setSelected(false);
        this.xlider = 0;
        this.JCHSIntegral.setSelected(false);
        this.xesintegral = 0;
        this.JTFFCantidad.setValue(new Double(0.0d));
        this.JTFCodigoD785.setText("");
        this.JTFGrado.setText("");
        this.JRB_FP_Dias.setSelected(true);
        this.xformapago = 0;
        if (!xjppersona.getIdPersona().isEmpty() && !xjppersona.getIdPersona().equals("0")) {
            mCargarDatosTablaRH(xjppersona.getIdPersona());
        } else {
            mCrearModeloRH();
        }
    }

    public void mGrabarRH() {
        if (!xjppersona.getIdPersona().equals("") && xjppersona.getIdPersona() != null && !xjppersona.getIdPersona().equals("0")) {
            if (this.JCBCargo.getSelectedIndex() != -1) {
                if (this.JCBTpclasificasion.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (!this.JLBIdPersonaRH.getText().isEmpty() && !"0".equals(this.JLBIdPersonaRH.getText())) {
                            this.xconsultas.ejecutarSQL("update rh_tipo_persona_cargon set Estado='" + this.xestadoRH + "', Lider='" + this.xlider + "', UrlFirma='" + this.JTFRuta.getText() + "', Fijo='" + this.xfijo + "', Id_unidadf_cargo='" + this.xidcargo[this.JCBCargo.getSelectedIndex()][0] + "', FechaIngreso='" + this.xmetodos.formatoAMD.format(this.JDFFechaIngreso.getDate()) + "', SalarioB='" + this.JTFFSalario.getValue() + "', FRiesgoArp='" + this.JSPFRiesgoArp.getValue() + "', SIntegral='" + this.xesintegral + "', Id_Clasificacion='" + this.xclasificacion[this.JCBTpclasificasion.getSelectedIndex()] + "', FPago='" + this.xformapago + "', Cantidad='" + this.JTFFCantidad.getValue() + "', Codigo='" + this.JTFCodigoD785.getText() + "', Grado='" + this.JTFGrado.getText() + "' where Id='" + this.JLBIdPersonaRH.getText() + "'");
                            return;
                        } else {
                            if (!this.xmetodos.mVerificarDatosDoblesTabla(this.JTDetalleC, 2, this.JCBCargo.getSelectedItem().toString())) {
                                String sql = "Insert into rh_tipo_persona_cargon(Id_Persona, Id_unidadf_cargo, Lider, Fijo, UrlFirma, FechaIngreso, SalarioB, SIntegral, FRiesgoArp ,Id_Clasificacion, FPago, Cantidad, Codigo, Grado, Estado, Fecha, UsuarioS) values ('" + xjppersona.getIdPersona() + "','" + this.xidcargo[this.JCBCargo.getSelectedIndex()][0] + "','" + this.xlider + "','" + this.xfijo + "','" + this.JTFRuta.getText() + "','" + this.xmetodos.formatoAMD.format(this.JDFFechaIngreso.getDate()) + "','" + this.JTFFSalario.getValue() + "','" + this.xesintegral + "','" + this.JSPFRiesgoArp.getValue() + "','" + this.xclasificacion[this.JCBTpclasificasion.getSelectedIndex()] + "','" + this.xformapago + "','" + this.JTFFCantidad.getValue() + "','" + this.JTFCodigoD785.getText() + "','" + this.JTFGrado.getText() + "','" + this.xestadoRH + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.JLBIdPersonaRH.setText(this.xconsultas.ejecutarSQLId(sql));
                                this.xencontroacargo = true;
                                System.out.println("datos rrhh" + sql);
                                this.xconsultas.cerrarConexionBd();
                                mCargarDatosTablaRH(xjppersona.getIdPersona());
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Cargo ya registrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Clasificasion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTpclasificasion.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un cargo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBCargo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void crearModeloTablaSispro() {
        this.xmodeloSispro = new DefaultTableModel(new Object[0], new String[]{"Id", "IdPersona", "Tipo Mecanismo Validacion", "Clave", "Reps", "Estado"}) { // from class: ParametrizacionN.JIFUsuarioSistema.75
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTableUsuarioSIspro.setAutoResizeMode(4);
        this.JTableUsuarioSIspro.doLayout();
        this.JTableUsuarioSIspro.setModel(this.xmodeloSispro);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(4).setPreferredWidth(90);
        this.JTableUsuarioSIspro.getColumnModel().getColumn(5).setPreferredWidth(90);
    }

    public void cargarTablaUsuarioSispro() {
        try {
            if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
                RecursosMicroserviciosDomain microserviciosDomain = this.xmetodos.getParametrosEncriptados("26", "findUsuarioSispro");
                String fullUrl = microserviciosDomain.getUrlRecurso();
                Response response = this.xmetodos.getResteasyClient().target(fullUrl).request().get();
                Throwable th = null;
                try {
                    try {
                        System.out.println("microservicio" + response);
                        crearModeloTablaSispro();
                        int statusCode = response.getStatus();
                        if (statusCode == 200) {
                            CustomPresenter presenter = (CustomPresenter) this.xmetodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                            String dataJson = this.xmetodos.getMapper().writeValueAsString(presenter.getData());
                            JsonNode jsonNode = this.xmetodos.getMapper().readTree(dataJson);
                            if (jsonNode.isArray()) {
                                this.dtoList = (List) this.xmetodos.getMapper().readValue(dataJson, new TypeReference<List<UserSisproDTO>>() { // from class: ParametrizacionN.JIFUsuarioSistema.76
                                });
                            }
                            if (this.dtoList != null) {
                                this.dtoList.forEach(e -> {
                                    Object[] dato = new Object[6];
                                    this.xmodeloSispro.addRow(dato);
                                    this.xmodeloSispro.setValueAt(e.getId(), this.JTableUsuarioSIspro.getRowCount() - 1, 0);
                                    this.xmodeloSispro.setValueAt(e.getIdPersona(), this.JTableUsuarioSIspro.getRowCount() - 1, 1);
                                    this.xmodeloSispro.setValueAt(e.getTipoMecanismoValidacion(), this.JTableUsuarioSIspro.getRowCount() - 1, 2);
                                    this.xmodeloSispro.setValueAt(e.getClave(), this.JTableUsuarioSIspro.getRowCount() - 1, 3);
                                    this.xmodeloSispro.setValueAt(e.getReps(), this.JTableUsuarioSIspro.getRowCount() - 1, 4);
                                    this.xmodeloSispro.setValueAt(e.getEstado(), this.JTableUsuarioSIspro.getRowCount() - 1, 5);
                                });
                            }
                        }
                        if (response != null) {
                            if (0 != 0) {
                                try {
                                    response.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                response.close();
                            }
                        }
                        this.xmetodos.getResteasyClient().close();
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            }
        } catch (JsonProcessingException e2) {
            Logger.getLogger(JDProcedimientoCntCode.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e2);
        }
    }

    public void mNuevoSispro() {
        this.JCHMecanismoValidacion.setSelected(true);
        this.JTFClave.setText("");
        this.JCHReps.setSelected(true);
        this.xestado = 1;
    }

    public void mGrabarUsuarioSispro() {
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            RecursosMicroserviciosDomain microserviciosDomain = this.xmetodos.getParametrosEncriptados("26", "createUsuarioSispro");
            if (this.JTFClave.getText() != null) {
                JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                try {
                    this.sisproDTO = UserSisproDTO.builder().id(this.id).idPersona(Long.valueOf(Principal.txtNo.getText())).tipoMecanismoValidacion(Boolean.valueOf(this.tipoMecanismoValidacion)).clave(this.JTFClave.getText()).reps(Boolean.valueOf(this.reps)).estado(Boolean.valueOf(this.JCHEstadoSispro.isSelected())).fecha(this.fecha).idUsuarioS(null).build();
                    System.out.println("Lo que se graba" + this.sisproDTO);
                    Response response = this.xmetodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.xmetodos.getMapper().writeValueAsString(this.sisproDTO)));
                    response.close();
                    this.xmetodos.getResteasyClient().close();
                } catch (JsonProcessingException e) {
                    Logger.getLogger(JIFUsuarioSistema.class.getName()).log(Level.SEVERE, (String) null, e);
                }
                mNuevoSispro();
                cargarTablaUsuarioSispro();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe ingresar un tipo de mecanismo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFClave.requestFocus();
        }
    }
}
