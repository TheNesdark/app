package Historia;

import Acceso.Principal;
import AutorizacionMP.JIFAutorizaciones;
import AutorizacionMP.JIFAutorizaciones1;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.genoma.plus.controller.inventario.JD_CuestionarioFarmacovigilanciaDisparadores;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import com.genoma.plus.jpa.entities.HItemordenessum;
import com.genoma.plus.jpa.entities.HItemordenessumRespuestacuestionario;
import com.genoma.plus.jpa.entities.ISuministro;
import com.genoma.plus.jpa.entities.ISuministroTipocuestionario;
import com.genoma.plus.jpa.entities.IViaadministracion;
import com.genoma.plus.jpa.entities.SoTipoCuestionario;
import com.genoma.plus.jpa.service.IHItemordenessumRespuestacuestionarioService;
import com.genoma.plus.jpa.service.IHItemordenessumService;
import com.genoma.plus.jpa.service.ISuministroService;
import com.genoma.plus.jpa.service.ISuministroTipocuestionarioService;
import com.genoma.plus.jpa.service.IViaAdministracionService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPOOrdenSuministroH.class */
public class JPOOrdenSuministroH extends JPanel {
    private DefaultTableModel xmodelo;
    private Object xjifobjetollamador;
    private int editar;
    private int xtipoim;
    private int xvllenado;
    private int duracion;
    private int xestaentregada;
    private GregorianCalendar xhoy;
    private GregorianCalendar xhoytf;
    private SimpleDateFormat xfechasql;
    private String xsql;
    private String xidusuario;
    private ResultSet rs;
    private int xtipobusqueda;
    private int IdregistraPrimeraOrden;
    private SimpleDateFormat xfechasqly;
    private SimpleDateFormat xfechasqlm;
    private SimpleDateFormat xfechasqld;
    private Object[] xdato;
    public String x1;
    public String x2;
    public String x3;
    public String x4;
    public String xCtc;
    public String xCtc1;
    public String xCtc2;
    public String xCtc3;
    private int xv;
    private int xv1;
    private int xtipo;
    private Metodos xmetodo;
    public String xobjetollamador;
    private String[] xidtipof;
    private Object xjifgenerico;
    public DefaultListModel xmodelodetalle;
    public static DefaultTableModel xmodelodetallet;
    private ConsultasMySQL xconsultasbd;
    private clasesHistoriaCE xclase;
    private int xfila;
    private int xespolimedicado;
    private boolean xtipom;
    private final ISuministroTipocuestionarioService iSuministroTipocuestionarioService;
    private final ISuministroService iSuministroService;
    private final IHItemordenessumRespuestacuestionarioService iHItemordenessumRespuestacuestionarioService;
    private final IHItemordenessumService iHItemordenessumService;
    private final IViaAdministracionService viaAdministracionService;
    private ISuministro suministro;
    public Integer idPregunta;
    public String cuerpoMensaje;
    public String nombreUsuario;
    public static List<HItemordenessumRespuestacuestionario> hItemordenessumRespuestacuestionarios;
    private List<IViaadministracion> viaadministracion;
    public static Vector vector = new Vector();
    private List<GServicioGrupoEntity> listGrupoEntitys;
    private List<GServicioRipsEntity> ListripsEntitys;
    private int xlleno;
    private JButton JBCtc;
    private ButtonGroup JBGTipo;
    public JButton JBTAdicionar;
    public JButton JBTAdicionarHC;
    private JButton JBTCerrar;
    public JComboBox JCBGrupoSevicio;
    public JComboBox JCBSevicioRips;
    private JComboBox JCBTipoFormula;
    private JComboBox JCBViaAdministracion;
    private JCheckBox JCHComienza;
    private JCheckBox JCHContiene;
    private JCheckBox JCHEsPrincipio;
    private JLabel JLBEstado;
    private JLabel JLBObservacionLasa;
    private JPanel JPIDetalleSuministros;
    private JPanel JPI_Adicional;
    private JPanel JPI_Adicional1;
    private JPanel JPPosologia;
    private JScrollPane JSPDatosDetMedicamentos;
    private JScrollPane JSPDatosMedicamentos;
    private JSpinner JSPINImpresiones;
    private JScrollPane JSPObservaciones;
    private JTextArea JTAObservaciones;
    public static JTable JTDatosDetMedicamentos;
    private JTable JTDatosMedicamentos;
    private JTextField JTFDosisFrecuencia;
    private JFormattedTextField JTFFCantidad;
    private JFormattedTextField JTFFDuracion;
    private JSpinner JTFFNTratamiento;
    private JFormattedTextField JTFFValorFormula;
    private JTextField JTFNombre;
    public JTextField JTFNordenSum;
    private JTabbedPane JTPDatosInternos;

    public JPOOrdenSuministroH(Object jfautorizacion, int xv, String usuarioS) {
        this.editar = 0;
        this.xtipoim = -1;
        this.xvllenado = 0;
        this.xestaentregada = 0;
        this.xhoy = new GregorianCalendar();
        this.xhoytf = new GregorianCalendar();
        this.xfechasql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.xtipobusqueda = 0;
        this.IdregistraPrimeraOrden = 0;
        this.xfechasqly = new SimpleDateFormat("yyyy");
        this.xfechasqlm = new SimpleDateFormat("MM");
        this.xfechasqld = new SimpleDateFormat("dd");
        this.x1 = "";
        this.x2 = "";
        this.x3 = "";
        this.x4 = "";
        this.xCtc = "";
        this.xCtc1 = "";
        this.xCtc2 = "";
        this.xCtc3 = "";
        this.xv = 1;
        this.xv1 = 0;
        this.xtipo = 0;
        this.xmetodo = new Metodos();
        this.xmodelodetalle = new DefaultListModel();
        this.xconsultasbd = new ConsultasMySQL();
        this.xfila = 0;
        this.xespolimedicado = 0;
        this.xtipom = false;
        this.iSuministroTipocuestionarioService = (ISuministroTipocuestionarioService) Principal.contexto.getBean(ISuministroTipocuestionarioService.class);
        this.iSuministroService = (ISuministroService) Principal.contexto.getBean(ISuministroService.class);
        this.iHItemordenessumRespuestacuestionarioService = (IHItemordenessumRespuestacuestionarioService) Principal.contexto.getBean(IHItemordenessumRespuestacuestionarioService.class);
        this.iHItemordenessumService = (IHItemordenessumService) Principal.contexto.getBean(IHItemordenessumService.class);
        this.viaAdministracionService = (IViaAdministracionService) Principal.contexto.getBean(IViaAdministracionService.class);
        this.idPregunta = null;
        this.cuerpoMensaje = "";
        this.nombreUsuario = "";
        initComponents();
        this.xv1 = xv;
        this.xjifobjetollamador = jfautorizacion;
        this.xjifgenerico = jfautorizacion;
        this.JBCtc.setVisible(true);
        this.xsql = "SELECT Id, Nbre FROM h_tipoformula WHERE (Especial =1 AND Estado =0) ORDER BY Nbre ASC";
        this.xidtipof = this.xconsultasbd.llenarCombo(this.xsql, this.xidtipof, this.JCBTipoFormula);
        this.xconsultasbd.cerrarConexionBd();
        this.JLBObservacionLasa.setVisible(false);
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.JBTAdicionarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
            this.JBTAdicionarHC.setText("Grabar");
        }
        nuevo();
    }

    public JPOOrdenSuministroH(Object jfautorizacion, int xv, String usuarioS, int x) {
        this.editar = 0;
        this.xtipoim = -1;
        this.xvllenado = 0;
        this.xestaentregada = 0;
        this.xhoy = new GregorianCalendar();
        this.xhoytf = new GregorianCalendar();
        this.xfechasql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.xtipobusqueda = 0;
        this.IdregistraPrimeraOrden = 0;
        this.xfechasqly = new SimpleDateFormat("yyyy");
        this.xfechasqlm = new SimpleDateFormat("MM");
        this.xfechasqld = new SimpleDateFormat("dd");
        this.x1 = "";
        this.x2 = "";
        this.x3 = "";
        this.x4 = "";
        this.xCtc = "";
        this.xCtc1 = "";
        this.xCtc2 = "";
        this.xCtc3 = "";
        this.xv = 1;
        this.xv1 = 0;
        this.xtipo = 0;
        this.xmetodo = new Metodos();
        this.xmodelodetalle = new DefaultListModel();
        this.xconsultasbd = new ConsultasMySQL();
        this.xfila = 0;
        this.xespolimedicado = 0;
        this.xtipom = false;
        this.iSuministroTipocuestionarioService = (ISuministroTipocuestionarioService) Principal.contexto.getBean(ISuministroTipocuestionarioService.class);
        this.iSuministroService = (ISuministroService) Principal.contexto.getBean(ISuministroService.class);
        this.iHItemordenessumRespuestacuestionarioService = (IHItemordenessumRespuestacuestionarioService) Principal.contexto.getBean(IHItemordenessumRespuestacuestionarioService.class);
        this.iHItemordenessumService = (IHItemordenessumService) Principal.contexto.getBean(IHItemordenessumService.class);
        this.viaAdministracionService = (IViaAdministracionService) Principal.contexto.getBean(IViaAdministracionService.class);
        this.idPregunta = null;
        this.cuerpoMensaje = "";
        this.nombreUsuario = "";
        initComponents();
        this.xv1 = xv;
        this.xjifobjetollamador = jfautorizacion;
        this.xjifgenerico = jfautorizacion;
        this.JBCtc.setVisible(true);
        this.xsql = "SELECT Id, Nbre FROM h_tipoformula WHERE (Id in(2,4) AND Estado =0) ORDER BY Nbre ASC";
        this.xidtipof = this.xconsultasbd.llenarCombo(this.xsql, this.xidtipof, this.JCBTipoFormula);
        this.xconsultasbd.cerrarConexionBd();
        this.JLBObservacionLasa.setVisible(false);
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.JBTAdicionarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
            this.JBTAdicionarHC.setText("Grabar");
        }
        nuevo();
    }

    public JPOOrdenSuministroH(String xobjetollamador, Object jif) {
        this.editar = 0;
        this.xtipoim = -1;
        this.xvllenado = 0;
        this.xestaentregada = 0;
        this.xhoy = new GregorianCalendar();
        this.xhoytf = new GregorianCalendar();
        this.xfechasql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.xtipobusqueda = 0;
        this.IdregistraPrimeraOrden = 0;
        this.xfechasqly = new SimpleDateFormat("yyyy");
        this.xfechasqlm = new SimpleDateFormat("MM");
        this.xfechasqld = new SimpleDateFormat("dd");
        this.x1 = "";
        this.x2 = "";
        this.x3 = "";
        this.x4 = "";
        this.xCtc = "";
        this.xCtc1 = "";
        this.xCtc2 = "";
        this.xCtc3 = "";
        this.xv = 1;
        this.xv1 = 0;
        this.xtipo = 0;
        this.xmetodo = new Metodos();
        this.xmodelodetalle = new DefaultListModel();
        this.xconsultasbd = new ConsultasMySQL();
        this.xfila = 0;
        this.xespolimedicado = 0;
        this.xtipom = false;
        this.iSuministroTipocuestionarioService = (ISuministroTipocuestionarioService) Principal.contexto.getBean(ISuministroTipocuestionarioService.class);
        this.iSuministroService = (ISuministroService) Principal.contexto.getBean(ISuministroService.class);
        this.iHItemordenessumRespuestacuestionarioService = (IHItemordenessumRespuestacuestionarioService) Principal.contexto.getBean(IHItemordenessumRespuestacuestionarioService.class);
        this.iHItemordenessumService = (IHItemordenessumService) Principal.contexto.getBean(IHItemordenessumService.class);
        this.viaAdministracionService = (IViaAdministracionService) Principal.contexto.getBean(IViaAdministracionService.class);
        this.idPregunta = null;
        this.cuerpoMensaje = "";
        this.nombreUsuario = "";
        initComponents();
        this.xobjetollamador = xobjetollamador;
        this.xjifgenerico = jif;
        if (xobjetollamador.equals("Autorizacion")) {
            this.xsql = "SELECT Id, Nbre FROM h_tipoformula WHERE (Especial =1 AND Estado =0) ORDER BY Nbre ASC";
            this.JBTAdicionarHC.setVisible(false);
        } else if (xobjetollamador.equals("Historia") || this.xobjetollamador.equals("HistoriaV2")) {
            this.xsql = "SELECT h_tipoformula.id, h_tipoformula.Nbre FROM h_tipoformespec INNER JOIN h_tipoformula ON (h_tipoformespec.Id_TipoFormula = h_tipoformula.Id) WHERE (h_tipoformespec.Id_Especialidad =´" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + " AND h_tipoformula.Estado =0) ORDER BY h_tipoformula.Nbre ASC";
            this.JBTAdicionarHC.setVisible(true);
        } else {
            this.xsql = "SELECT Id, Nbre FROM h_tipoformula WHERE (Id in(2,4) AND Estado =0) ORDER BY Nbre ASC";
            this.JBTAdicionarHC.setVisible(false);
        }
        this.JBCtc.setVisible(true);
        this.xidtipof = this.xconsultasbd.llenarCombo(this.xsql, this.xidtipof, this.JCBTipoFormula);
        mCrearTablaDetalleMedicamentos();
        this.JLBObservacionLasa.setVisible(false);
        this.xconsultasbd.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.JBTAdicionarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
            this.JBTAdicionarHC.setText("Grabar");
        }
        nuevo();
    }

    public JPOOrdenSuministroH(String xobjetollamador, clasesHistoriaCE xclase) {
        this.editar = 0;
        this.xtipoim = -1;
        this.xvllenado = 0;
        this.xestaentregada = 0;
        this.xhoy = new GregorianCalendar();
        this.xhoytf = new GregorianCalendar();
        this.xfechasql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.xtipobusqueda = 0;
        this.IdregistraPrimeraOrden = 0;
        this.xfechasqly = new SimpleDateFormat("yyyy");
        this.xfechasqlm = new SimpleDateFormat("MM");
        this.xfechasqld = new SimpleDateFormat("dd");
        this.x1 = "";
        this.x2 = "";
        this.x3 = "";
        this.x4 = "";
        this.xCtc = "";
        this.xCtc1 = "";
        this.xCtc2 = "";
        this.xCtc3 = "";
        this.xv = 1;
        this.xv1 = 0;
        this.xtipo = 0;
        this.xmetodo = new Metodos();
        this.xmodelodetalle = new DefaultListModel();
        this.xconsultasbd = new ConsultasMySQL();
        this.xfila = 0;
        this.xespolimedicado = 0;
        this.xtipom = false;
        this.iSuministroTipocuestionarioService = (ISuministroTipocuestionarioService) Principal.contexto.getBean(ISuministroTipocuestionarioService.class);
        this.iSuministroService = (ISuministroService) Principal.contexto.getBean(ISuministroService.class);
        this.iHItemordenessumRespuestacuestionarioService = (IHItemordenessumRespuestacuestionarioService) Principal.contexto.getBean(IHItemordenessumRespuestacuestionarioService.class);
        this.iHItemordenessumService = (IHItemordenessumService) Principal.contexto.getBean(IHItemordenessumService.class);
        this.viaAdministracionService = (IViaAdministracionService) Principal.contexto.getBean(IViaAdministracionService.class);
        this.idPregunta = null;
        this.cuerpoMensaje = "";
        this.nombreUsuario = "";
        initComponents();
        this.xclase = xclase;
        this.nombreUsuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getNumeroHistoria() + "- " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario();
        this.xobjetollamador = xobjetollamador;
        this.xsql = "SELECT h_tipoformula.id, h_tipoformula.Nbre FROM h_tipoformespec INNER JOIN h_tipoformula ON (h_tipoformespec.Id_TipoFormula = h_tipoformula.Id) WHERE (h_tipoformespec.Id_Especialidad ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND h_tipoformula.Estado =0) order by h_tipoformula.Nbre ";
        this.xidtipof = this.xconsultasbd.llenarCombo(this.xsql, this.xidtipof, this.JCBTipoFormula);
        this.xconsultasbd.cerrarConexionBd();
        mCrearTablaDetalleMedicamentos();
        this.JBTAdicionarHC.setVisible(false);
        this.JBCtc.setVisible(true);
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.JCHEsPrincipio.setSelected(true);
            this.JSPINImpresiones.setValue(new Integer(1));
        } else {
            this.JCHEsPrincipio.setSelected(false);
        }
        this.JLBObservacionLasa.setVisible(false);
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.JBTAdicionarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
            this.JBTAdicionarHC.setText("Grabar");
        }
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v131, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JPIDetalleSuministros = new JPanel();
        this.JBTAdicionar = new JButton();
        this.JCBTipoFormula = new JComboBox();
        this.JSPDatosMedicamentos = new JScrollPane();
        this.JTDatosMedicamentos = new JTable();
        this.JTFNombre = new JTextField();
        this.JCHEsPrincipio = new JCheckBox();
        this.JCHComienza = new JCheckBox();
        this.JCHContiene = new JCheckBox();
        this.JLBObservacionLasa = new JLabel();
        this.JTPDatosInternos = new JTabbedPane();
        this.JPPosologia = new JPanel();
        this.JTFDosisFrecuencia = new JTextField();
        this.JTFFDuracion = new JFormattedTextField();
        this.JTFFCantidad = new JFormattedTextField();
        this.JTFFNTratamiento = new JSpinner();
        this.JCBViaAdministracion = new JComboBox();
        this.JPI_Adicional1 = new JPanel();
        this.JSPObservaciones = new JScrollPane();
        this.JTAObservaciones = new JTextArea();
        this.JPI_Adicional = new JPanel();
        this.JCBGrupoSevicio = new JComboBox();
        this.JCBSevicioRips = new JComboBox();
        this.JTFNordenSum = new JTextField();
        this.JSPINImpresiones = new JSpinner();
        this.JLBEstado = new JLabel();
        this.JTFFValorFormula = new JFormattedTextField();
        this.JSPDatosDetMedicamentos = new JScrollPane();
        JTDatosDetMedicamentos = new JTable();
        this.JBTCerrar = new JButton("<html><center><b><u>F</u>órmulas Vencidas</b></html>");
        this.JBTAdicionarHC = new JButton("<html><center><b><u>F</u>órmulas Vencidas</b></html>");
        this.JBCtc = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ORDEN DE MEDICAMENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpsuministroh");
        setPreferredSize(new Dimension(850, 597));
        this.JPIDetalleSuministros.setBorder(BorderFactory.createEtchedBorder());
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenSuministroH.1
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenSuministroH.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTAdicionar.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenSuministroH.2
            public void keyPressed(KeyEvent evt) {
                JPOOrdenSuministroH.this.JBTAdicionarKeyPressed(evt);
            }
        });
        this.JCBTipoFormula.setFont(new Font("Arial", 1, 12));
        this.JCBTipoFormula.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Formula", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTDatosMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTDatosMedicamentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDatosMedicamentos.setCursor(new Cursor(0));
        this.JTDatosMedicamentos.setRowHeight(25);
        this.JTDatosMedicamentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDatosMedicamentos.setSelectionForeground(Color.red);
        this.JTDatosMedicamentos.setSelectionMode(0);
        this.JTDatosMedicamentos.addFocusListener(new FocusAdapter() { // from class: Historia.JPOOrdenSuministroH.3
            public void focusLost(FocusEvent evt) {
                JPOOrdenSuministroH.this.JTDatosMedicamentosFocusLost(evt);
            }
        });
        this.JTDatosMedicamentos.addMouseListener(new MouseAdapter() { // from class: Historia.JPOOrdenSuministroH.4
            public void mouseClicked(MouseEvent evt) {
                JPOOrdenSuministroH.this.JTDatosMedicamentosMouseClicked(evt);
            }
        });
        this.JTDatosMedicamentos.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPOOrdenSuministroH.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPOOrdenSuministroH.this.JTDatosMedicamentosPropertyChange(evt);
            }
        });
        this.JTDatosMedicamentos.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenSuministroH.6
            public void keyPressed(KeyEvent evt) {
                JPOOrdenSuministroH.this.JTDatosMedicamentosKeyPressed(evt);
            }
        });
        this.JSPDatosMedicamentos.setViewportView(this.JTDatosMedicamentos);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Medicamento", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPOOrdenSuministroH.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPOOrdenSuministroH.this.JTFNombrePropertyChange(evt);
            }
        });
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenSuministroH.8
            public void keyPressed(KeyEvent evt) {
                JPOOrdenSuministroH.this.JTFNombreKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPOOrdenSuministroH.this.JTFNombreKeyTyped(evt);
            }
        });
        this.JCHEsPrincipio.setFont(new Font("Arial", 1, 12));
        this.JCHEsPrincipio.setForeground(Color.blue);
        this.JCHEsPrincipio.setText("PrincipioActivo");
        this.JCHEsPrincipio.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenSuministroH.9
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenSuministroH.this.JCHEsPrincipioActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JCHComienza);
        this.JCHComienza.setFont(new Font("Arial", 1, 12));
        this.JCHComienza.setForeground(new Color(0, 0, 255));
        this.JCHComienza.setText("Comienza");
        this.JCHComienza.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenSuministroH.10
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenSuministroH.this.JCHComienzaActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JCHContiene);
        this.JCHContiene.setFont(new Font("Arial", 1, 12));
        this.JCHContiene.setForeground(new Color(0, 0, 255));
        this.JCHContiene.setSelected(true);
        this.JCHContiene.setText("Contiene");
        this.JCHContiene.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenSuministroH.11
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenSuministroH.this.JCHContieneActionPerformed(evt);
            }
        });
        this.JLBObservacionLasa.setBackground(Color.orange);
        this.JLBObservacionLasa.setFont(new Font("Arial", 1, 12));
        this.JLBObservacionLasa.setHorizontalAlignment(0);
        this.JLBObservacionLasa.setOpaque(true);
        this.JTPDatosInternos.setForeground(Color.red);
        this.JTPDatosInternos.setFont(new Font("Arial", 1, 14));
        this.JTFDosisFrecuencia.setFont(new Font("Arial", 1, 13));
        this.JTFDosisFrecuencia.setHorizontalAlignment(0);
        this.JTFDosisFrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Dosis - Frecuencia", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDuracion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFDuracion.setHorizontalAlignment(0);
        this.JTFFDuracion.setFont(new Font("Arial", 1, 13));
        this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFCantidad.setHorizontalAlignment(0);
        this.JTFFCantidad.setFont(new Font("Arial", 1, 13));
        this.JTFFNTratamiento.setFont(new Font("Arial", 1, 13));
        this.JTFFNTratamiento.setModel(new SpinnerNumberModel(1, 1, 6, 1));
        this.JTFFNTratamiento.setBorder(BorderFactory.createTitledBorder((Border) null, "NTto x Mes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBViaAdministracion.setFont(new Font("Arial", 1, 12));
        this.JCBViaAdministracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Vía Administración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPPosologiaLayout = new GroupLayout(this.JPPosologia);
        this.JPPosologia.setLayout(JPPosologiaLayout);
        JPPosologiaLayout.setHorizontalGroup(JPPosologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPosologiaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDosisFrecuencia, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBViaAdministracion, -2, 165, -2).addGap(18, 18, 18).addComponent(this.JTFFDuracion, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFCantidad, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNTratamiento, -2, 94, -2).addContainerGap(171, 32767)));
        JPPosologiaLayout.setVerticalGroup(JPPosologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPPosologiaLayout.createSequentialGroup().addContainerGap(17, 32767).addGroup(JPPosologiaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFNTratamiento).addComponent(this.JTFFDuracion, GroupLayout.Alignment.LEADING).addComponent(this.JTFDosisFrecuencia, GroupLayout.Alignment.LEADING).addComponent(this.JTFFCantidad).addComponent(this.JCBViaAdministracion, -2, 50, -2)).addContainerGap()));
        this.JTPDatosInternos.addTab("POSOLOGÍA", this.JPPosologia);
        this.JSPObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones/Justificacion", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservaciones.setColumns(20);
        this.JTAObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTAObservaciones.setRows(5);
        this.JTAObservaciones.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenSuministroH.12
            public void keyPressed(KeyEvent evt) {
                JPOOrdenSuministroH.this.JTAObservacionesKeyPressed(evt);
            }
        });
        this.JSPObservaciones.setViewportView(this.JTAObservaciones);
        GroupLayout JPI_Adicional1Layout = new GroupLayout(this.JPI_Adicional1);
        this.JPI_Adicional1.setLayout(JPI_Adicional1Layout);
        JPI_Adicional1Layout.setHorizontalGroup(JPI_Adicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 855, 32767).addGroup(JPI_Adicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Adicional1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservaciones, -2, 793, -2).addContainerGap(56, 32767))));
        JPI_Adicional1Layout.setVerticalGroup(JPI_Adicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 73, 32767).addGroup(JPI_Adicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Adicional1Layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JSPObservaciones, -2, 59, -2).addContainerGap(7, 32767))));
        this.JTPDatosInternos.addTab("ADICIONAL", this.JPI_Adicional1);
        this.JCBGrupoSevicio.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoSevicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoSevicio.setName("grupoServicio");
        this.JCBGrupoSevicio.addItemListener(new ItemListener() { // from class: Historia.JPOOrdenSuministroH.13
            public void itemStateChanged(ItemEvent evt) {
                JPOOrdenSuministroH.this.JCBGrupoSevicioItemStateChanged(evt);
            }
        });
        this.JCBSevicioRips.setFont(new Font("Arial", 1, 12));
        this.JCBSevicioRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSevicioRips.setName("servicioRips");
        GroupLayout JPI_AdicionalLayout = new GroupLayout(this.JPI_Adicional);
        this.JPI_Adicional.setLayout(JPI_AdicionalLayout);
        JPI_AdicionalLayout.setHorizontalGroup(JPI_AdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AdicionalLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBGrupoSevicio, -2, 279, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSevicioRips, 0, -1, 32767).addGap(30, 30, 30)));
        JPI_AdicionalLayout.setVerticalGroup(JPI_AdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_AdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPI_AdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGrupoSevicio, -2, -1, -2).addComponent(this.JCBSevicioRips, -2, -1, -2)).addContainerGap(28, 32767)));
        this.JTPDatosInternos.addTab("ADICIONAL1", this.JPI_Adicional);
        GroupLayout JPIDetalleSuministrosLayout = new GroupLayout(this.JPIDetalleSuministros);
        this.JPIDetalleSuministros.setLayout(JPIDetalleSuministrosLayout);
        JPIDetalleSuministrosLayout.setHorizontalGroup(JPIDetalleSuministrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleSuministrosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleSuministrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleSuministrosLayout.createSequentialGroup().addComponent(this.JCBTipoFormula, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 414, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsPrincipio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalleSuministrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHComienza).addComponent(this.JCHContiene)).addContainerGap(-1, 32767)).addGroup(JPIDetalleSuministrosLayout.createSequentialGroup().addGroup(JPIDetalleSuministrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTAdicionar, -2, 814, -2).addComponent(this.JSPDatosMedicamentos).addComponent(this.JLBObservacionLasa, -1, -1, 32767).addComponent(this.JTPDatosInternos)).addGap(0, 0, 32767)))));
        JPIDetalleSuministrosLayout.setVerticalGroup(JPIDetalleSuministrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleSuministrosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleSuministrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleSuministrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoFormula, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCHEsPrincipio)).addGroup(JPIDetalleSuministrosLayout.createSequentialGroup().addComponent(this.JCHComienza).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHContiene))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDatosMedicamentos, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBObservacionLasa, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosInternos, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 27, -2).addContainerGap()));
        this.JTFNordenSum.setFont(new Font("Arial", 1, 24));
        this.JTFNordenSum.setForeground(Color.blue);
        this.JTFNordenSum.setHorizontalAlignment(0);
        this.JTFNordenSum.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Orden", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JSPINImpresiones.setFont(new Font("Arial", 1, 14));
        this.JSPINImpresiones.setModel(new SpinnerNumberModel(1, 1, 6, 1));
        this.JSPINImpresiones.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Impr.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBEstado.setBackground(new Color(255, 255, 255));
        this.JLBEstado.setFont(new Font("Arial", 1, 18));
        this.JLBEstado.setForeground(Color.red);
        this.JLBEstado.setHorizontalAlignment(0);
        this.JLBEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorFormula.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Formula", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorFormula.setForeground(Color.blue);
        this.JTFFValorFormula.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorFormula.setHorizontalAlignment(0);
        this.JTFFValorFormula.setFont(new Font("Arial", 1, 18));
        JTDatosDetMedicamentos.setFont(new Font("Arial", 1, 12));
        JTDatosDetMedicamentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        JTDatosDetMedicamentos.setRowHeight(25);
        JTDatosDetMedicamentos.setSelectionBackground(new Color(255, 255, 255));
        JTDatosDetMedicamentos.setSelectionForeground(new Color(255, 0, 0));
        JTDatosDetMedicamentos.setSelectionMode(0);
        JTDatosDetMedicamentos.addFocusListener(new FocusAdapter() { // from class: Historia.JPOOrdenSuministroH.14
            public void focusLost(FocusEvent evt) {
                JPOOrdenSuministroH.this.JTDatosDetMedicamentosFocusLost(evt);
            }
        });
        JTDatosDetMedicamentos.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenSuministroH.15
            public void keyPressed(KeyEvent evt) {
                JPOOrdenSuministroH.this.JTDatosDetMedicamentosKeyPressed(evt);
            }
        });
        this.JSPDatosDetMedicamentos.setViewportView(JTDatosDetMedicamentos);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setForeground(Color.blue);
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/fv.png")));
        this.JBTCerrar.setText("<html><P ALIGN=center>Formulas Vencidas");
        this.JBTCerrar.setMinimumSize((Dimension) null);
        this.JBTCerrar.setPreferredSize((Dimension) null);
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenSuministroH.16
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenSuministroH.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JBTAdicionarHC.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarHC.setText("<html><P ALIGN=center>Adjuntar a la Atención");
        this.JBTAdicionarHC.setMinimumSize((Dimension) null);
        this.JBTAdicionarHC.setPreferredSize((Dimension) null);
        this.JBTAdicionarHC.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenSuministroH.17
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenSuministroH.this.JBTAdicionarHCActionPerformed(evt);
            }
        });
        this.JBCtc.setFont(new Font("Arial", 1, 12));
        this.JBCtc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBCtc.setText("<html><P ALIGN=center>Mipres");
        this.JBCtc.setToolTipText("Formulación de NO POS");
        this.JBCtc.setMinimumSize((Dimension) null);
        this.JBCtc.setPreferredSize((Dimension) null);
        this.JBCtc.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenSuministroH.18
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenSuministroH.this.JBCtcActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDetalleSuministros, -1, -1, 32767).addComponent(this.JSPDatosDetMedicamentos).addGroup(layout.createSequentialGroup().addComponent(this.JTFNordenSum, -2, 111, -2).addGap(18, 18, 18).addComponent(this.JSPINImpresiones, -2, 84, -2).addGap(3, 3, 3).addComponent(this.JTFFValorFormula, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBEstado, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBCtc, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarHC, -2, 127, -2).addGap(0, 0, 32767)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDetalleSuministros, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDatosDetMedicamentos, -2, 149, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFValorFormula, GroupLayout.Alignment.TRAILING).addComponent(this.JSPINImpresiones, GroupLayout.Alignment.TRAILING).addComponent(this.JTFNordenSum, GroupLayout.Alignment.TRAILING).addComponent(this.JLBEstado, -1, -1, 32767).addComponent(this.JBTCerrar, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JBCtc, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JBTAdicionarHC, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.xtipom) {
            if (this.xtipoim == -1) {
                adicionar();
                mConsultarALerta();
                consultarCuestionarioSuministro();
                return;
            } else {
                if (this.xtipoim == 0 || this.xtipoim == 1 || this.xtipoim == 2) {
                    if (!this.JTAObservaciones.getText().isEmpty()) {
                        adicionar();
                        mConsultarALerta();
                        consultarCuestionarioSuministro();
                        return;
                    } else {
                        JOptionPane.showMessageDialog((Component) null, "Medicamento no se puede agregar;\nDebe agregar justificación;\nAlerta Activa", "ALERTA DE SEGURIDAD CLÍNICA", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTAObservaciones.requestFocus();
                        return;
                    }
                }
                return;
            }
        }
        adicionar();
        mConsultarALerta();
        consultarCuestionarioSuministro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            adicionar();
            limpiar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTAObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mLLenartabla();
        } else {
            mCrearTablaMedicamentos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPrincipioActionPerformed(ActionEvent evt) {
        if (this.JCHEsPrincipio.isSelected()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                mCrearTablaMedicamentos();
                mLLenartabla();
                return;
            } else {
                mCrearTablaMedicamentos();
                return;
            }
        }
        if (!this.JTFNombre.getText().isEmpty()) {
            mCrearTablaMedicamentos();
            mLLenartabla();
        } else {
            mCrearTablaMedicamentos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosFocusLost(FocusEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            mVerificarMensaje_ClasificacionLasa(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 19).toString());
            validarmedicamentos();
            mValidarInteracionMed();
            mVerificarFVencimientoInvima();
            mVerificarNovedadP();
            mVerificarMedicamentoControl();
            if (this.xobjetollamador.equals("Autorizacion") && Double.valueOf(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 6).toString()).doubleValue() == 0.0d) {
                JOptionPane.showInternalMessageDialog(this, "El valor del medicamento esta en cero;\nFavor actualizar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosKeyPressed(KeyEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1 && evt.getKeyCode() == 9) {
            this.JTDatosMedicamentos.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mLLenartabla();
        } else {
            mCrearTablaMedicamentos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosDetMedicamentosFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosDetMedicamentosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && JTDatosDetMedicamentos.getRowCount() != 0 && JTDatosDetMedicamentos.getSelectedRow() != -1) {
            if (this.JTFNordenSum.getText().isEmpty()) {
                if (Integer.valueOf(JTDatosDetMedicamentos.getValueAt(JTDatosDetMedicamentos.getSelectedRow(), 14).toString()).intValue() != -1) {
                    vector.remove(Integer.valueOf(JTDatosDetMedicamentos.getValueAt(JTDatosDetMedicamentos.getSelectedRow(), 14).toString()));
                }
                xmodelodetallet.removeRow(JTDatosDetMedicamentos.getSelectedRow());
                this.xfila--;
                return;
            }
            if (this.xestaentregada != 2) {
                if (!Principal.informacionIps.getIdentificacion().equals("800080586")) {
                    int x = JOptionPane.showConfirmDialog((Component) null, "Desea elimar el suministro seleccionado", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        String sql = "delete from h_itemordenessum where Id_HOrdenes='" + this.JTFNordenSum.getText() + "' and Id_Suministro='" + xmodelodetallet.getValueAt(JTDatosDetMedicamentos.getSelectedRow(), 0) + "'";
                        this.xconsultasbd.ejecutarSQL(sql);
                        this.xconsultasbd.cerrarConexionBd();
                        xmodelodetallet.removeRow(JTDatosDetMedicamentos.getSelectedRow());
                        this.xfila--;
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No se puede eliminar item;\nfavor anular la orden", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHComienzaActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContieneActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        if (this.xobjetollamador.equals("Autorizacion")) {
            JIFAutorizaciones xfc = (JIFAutorizaciones) this.xjifgenerico;
            if (!xfc.frmPersona.getIdPersona().equals("0")) {
                JDFormulaVencida fc = new JDFormulaVencida(null, true, xfc.frmPersona.getIdPersona());
                fc.setVisible(true);
                return;
            }
            return;
        }
        if (this.xobjetollamador.equals("Historia") || this.xobjetollamador.equals("HistoriaV2")) {
            JDFormulaVencida xfc1 = new JDFormulaVencida(null, true, this.xclase.xjifhistoriaclinica.xidusuario);
            xfc1.setVisible(true);
        } else if (this.xobjetollamador.equals("Formulas PyP")) {
            JDFormulaVencida xfc12 = new JDFormulaVencida(null, true, this.xclase.xjifformulaspyp.xjppersona.getIdPersona());
            xfc12.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarHCActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            grabar();
            return;
        }
        if (!this.JTFNordenSum.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de adjuntar a esta atención?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "update h_ordenes set Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', EstaEntregada=2 where Id='" + this.JTFNordenSum.getText() + "'";
                this.xconsultasbd.ejecutarSQL(this.xsql);
                this.xconsultasbd.cerrarConexionBd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCtcActionPerformed(ActionEvent evt) {
        try {
            try {
                Desktop.getDesktop().browse(new URI("https://mipres.sispro.gov.co/MIPRESNOPBS/Login.aspx?ReturnUrl=%2fMIPRESNOPBS"));
            } catch (IOException ex) {
                Logger.getLogger(JPOOrdenSuministroH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } catch (URISyntaxException ex2) {
            Logger.getLogger(JPOOrdenSuministroH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosMouseClicked(MouseEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 3).toString());
            System.out.println("via " + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 23).toString());
            this.JCBViaAdministracion.setSelectedItem(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 23).toString());
            if (!this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 21).equals("")) {
                this.JLBObservacionLasa.setVisible(true);
                this.JLBObservacionLasa.setText(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 21).toString());
                this.JLBObservacionLasa.setBackground(Color.white);
                if (isNumeric(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 22).toString())) {
                    Color color = new Color(Integer.parseInt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 22).toString()));
                    this.JLBObservacionLasa.setForeground(color);
                    return;
                }
                return;
            }
            this.JLBObservacionLasa.setText("");
            this.JLBObservacionLasa.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosPropertyChange(PropertyChangeEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombrePropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoSevicioItemStateChanged(ItemEvent evt) {
        if (this.xlleno == 1 && this.JCBGrupoSevicio.getSelectedIndex() != -1) {
            this.JCBSevicioRips.removeAllItems();
            this.ListripsEntitys = new ArrayList();
            LlenarCombosGenericos<GServicioRipsEntity> combosGenericos = new LlenarCombosGenericos<>();
            this.ListripsEntitys = combosGenericos.getListComboLlenoParametro(this.JCBSevicioRips.getName(), this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()));
            this.ListripsEntitys.forEach(e -> {
                this.JCBSevicioRips.addItem(e.getNombre());
            });
            this.JCBSevicioRips.addPopupMenuListener(new CustomPopupMenuListener(true, false));
            if (!this.listGrupoEntitys.isEmpty()) {
                this.JCBSevicioRips.setSelectedItem("SERVICIO FARMACEUTICO");
            }
        }
    }

    public void mVerificarMensaje_ClasificacionLasa(String nAlerta) {
        if (!nAlerta.equals("")) {
            String xalergias = "<html><P ALIGN=left><font color=#FF0000> " + nAlerta.toUpperCase() + "</font> <P>";
            JOptionPane.showMessageDialog(this, xalergias, "ALERTA DE SEGURIDAD CLINICA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mImprimir() {
        if (!this.JTFNordenSum.getText().isEmpty()) {
            String sql = "SELECT  `Id` , `IdOrden` FROM `h_concecutivo_ctc` WHERE (`IdOrden` ='" + this.JTFNordenSum.getText() + "');";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    String[][] parametros = new String[3][2];
                    parametros[0][0] = "ID_Conc";
                    parametros[0][1] = this.JTFNordenSum.getText();
                    parametros[1][0] = "SUBREPORT_DIR";
                    parametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                    parametros[2][0] = "SUBREPORTFIRMA_DIR";
                    parametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS")) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "R_MedicamentoNoPOS_CDajud", parametros);
                    } else {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "R_MedicamentoNoPOS", parametros);
                    }
                    this.xconsultasbd.cerrarConexionBd();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Esta Orden no tiene CTC", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
                xrs.close();
                xct.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe cargar una orden", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mValidadNTratamiento() {
    }

    private void adicionar() {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            if (!this.JTFDosisFrecuencia.getText().isEmpty()) {
                if (!this.JTFFDuracion.getText().isEmpty()) {
                    if (!this.JTFFCantidad.getText().isEmpty()) {
                        if (this.JTFNordenSum.getText().isEmpty()) {
                            if (Boolean.valueOf(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 14).toString()).booleanValue()) {
                                JDNoPOS xNoPos = new JDNoPOS(null, true, "xMedicamentos", this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 15).toString(), this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 16).toString(), this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 17).toString(), this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 18).toString());
                                xNoPos.setVisible(true);
                            }
                            xmodelodetallet.addRow(this.xdato);
                            this.suministro = null;
                            this.suministro = this.iSuministroService.suministroPorId(Long.valueOf(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2).toString()));
                            xmodelodetallet.setValueAt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2), this.xfila, 0);
                            xmodelodetallet.setValueAt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 3), this.xfila, 1);
                            xmodelodetallet.setValueAt(this.JTFDosisFrecuencia.getText(), this.xfila, 2);
                            xmodelodetallet.setValueAt(this.JTFFDuracion.getValue(), this.xfila, 3);
                            xmodelodetallet.setValueAt(this.JTFFCantidad.getValue(), this.xfila, 4);
                            xmodelodetallet.setValueAt(this.JTAObservaciones.getText(), this.xfila, 5);
                            xmodelodetallet.setValueAt(this.JTFFNTratamiento.getValue(), this.xfila, 6);
                            xmodelodetallet.setValueAt(new Integer(1), this.xfila, 7);
                            xmodelodetallet.setValueAt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 6), this.xfila, 8);
                            xmodelodetallet.setValueAt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0), this.xfila, 9);
                            xmodelodetallet.setValueAt(this.x1, this.xfila, 10);
                            xmodelodetallet.setValueAt(this.x2, this.xfila, 11);
                            xmodelodetallet.setValueAt(this.x3, this.xfila, 12);
                            xmodelodetallet.setValueAt(this.x4, this.xfila, 13);
                            xmodelodetallet.setValueAt(-1, this.xfila, 14);
                            this.xCtc = this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 15).toString();
                            this.xCtc1 = this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 16).toString();
                            this.xCtc2 = this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 17).toString();
                            this.xCtc3 = this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 18).toString();
                            xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.xfila, 15);
                            xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.xfila, 16);
                            xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.xfila, 17);
                            xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.xfila, 18);
                            xmodelodetallet.setValueAt(this.viaadministracion.get(this.JCBViaAdministracion.getSelectedIndex()).getId(), this.xfila, 19);
                            xmodelodetallet.setValueAt(this.viaadministracion.get(this.JCBViaAdministracion.getSelectedIndex()).getNbre(), this.xfila, 20);
                            this.xfila++;
                            this.JTFFValorFormula.setValue(Integer.valueOf(mCalcularTotalFormula()));
                            limpiar();
                            this.xtipom = false;
                            return;
                        }
                        if (this.xestaentregada != 2) {
                            int x = JOptionPane.showConfirmDialog((Component) null, "Desea adicionar el suministro seleccionado", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                this.xsql = "insert into h_itemordenessum (Id_HOrdenes, Id_Suministro, PosologiaManual, Duracion, Cantidad, EsfueraVadem, Justificacion, ValorUnitario, ValorTotal, Fecha, UsuarioS) values('" + this.JTFNordenSum.getText() + "','" + this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2) + "','" + this.JTFDosisFrecuencia.getText() + "','" + this.JTFFDuracion.getValue() + "','" + this.JTFFCantidad.getValue() + "','0','" + this.JTAObservaciones.getText() + "','" + this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 6) + "','" + (Integer.valueOf(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 6).toString()).intValue() * Integer.valueOf(this.JTFFCantidad.getValue().toString()).intValue()) + "','" + this.xfechasql.format(this.xhoy.getTime()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.xconsultasbd.ejecutarSQL(this.xsql);
                                this.xconsultasbd.cerrarConexionBd();
                                mBuscarSuministro(this.JTFNordenSum.getText(), true);
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "No se puede adicionar suministro, la orden ya fue dispensada.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo cantidad   \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFCantidad.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo duración   \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFDuracion.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo dosis y frecuencia  \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFDosisFrecuencia.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTDatosMedicamentos.requestFocus();
    }

    private void limpiar() {
        this.JTFNombre.setText("");
        this.JTFDosisFrecuencia.setText((String) null);
        this.JTFFCantidad.setText((String) null);
        this.JTFFDuracion.setText((String) null);
        this.JTFFNTratamiento.setValue(new Integer(1));
        this.JTAObservaciones.setText("");
        this.JLBEstado.setText((String) null);
        this.x1 = "";
        this.x2 = "";
        this.x3 = "";
        this.x4 = "";
    }

    public void nuevo() {
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            int x = JOptionPane.showConfirmDialog((Component) null, "Desea generar nueva formula", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                mNuevo();
                return;
            }
            return;
        }
        mNuevo();
    }

    private void mNuevo() {
        this.xlleno = 1;
        this.JCBSevicioRips.removeAllItems();
        hItemordenessumRespuestacuestionarios = new ArrayList();
        this.viaadministracion = new ArrayList();
        this.JTFNombre.setText((String) null);
        this.JTFDosisFrecuencia.setText((String) null);
        this.JTFFCantidad.setText((String) null);
        this.JTFFDuracion.setText((String) null);
        this.JTFFNTratamiento.setValue(1);
        this.JTAObservaciones.setText((String) null);
        this.JTAObservaciones.setText((String) null);
        this.xmodelodetalle.removeAllElements();
        this.JTFNordenSum.setText("");
        this.JLBEstado.setText((String) null);
        this.JTFFValorFormula.setValue(0);
        this.xfila = 0;
        this.xestaentregada = 0;
        this.xespolimedicado = 0;
        mCrearTablaMedicamentos();
        mCrearTablaDetalleMedicamentos();
        this.JCBGrupoSevicio.removeAllItems();
        this.JCBViaAdministracion.removeAllItems();
        LlenarCombosGenericos<GServicioGrupoEntity> combosGenericos = new LlenarCombosGenericos<>();
        this.listGrupoEntitys = combosGenericos.getListComboLleno(this.JCBGrupoSevicio.getName());
        this.listGrupoEntitys.forEach(e -> {
            this.JCBGrupoSevicio.addItem(e.getNombre());
        });
        this.viaadministracion = this.viaAdministracionService.getListAllOrderByNbre(false);
        this.viaadministracion.forEach(e2 -> {
            this.JCBViaAdministracion.addItem(e2.getNbre());
        });
        this.xlleno = 1;
        if (!this.listGrupoEntitys.isEmpty()) {
            this.JCBGrupoSevicio.setSelectedItem("Apoyo diagnóstico y complementación  terapéutica");
            this.JCBGrupoSevicio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
    }

    public void mGrabarOrdene() {
        String idatencion;
        if (mVerificarDatos()) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() == null && this.JTFNordenSum.getText().isEmpty()) {
                this.xsql = "INSERT INTO paciente_atencion (IdPaciente, Cardinal_Atencion, IdTipoConsulta, IdTipoPrograma, Fecha_Atencion, Motivo_Atencion, paciente_atencion.Codigo_Dxp, paciente_atencion.IdTipo_Dx, paciente_atencion.Codigo_DxR1, paciente_atencion.Codigo_DxR2, paciente_atencion.Codigo_DxR3,  conclusion, Idprofesional, Id_Especialidad, Anulada) VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','0','9','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','','1','1','','','','','','0')";
                idatencion = this.xconsultasbd.ejecutarSQLId(this.xsql);
            } else {
                idatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
            }
            mGuardarDatosOrdenes(Long.parseLong(idatencion), String.valueOf(Principal.informacionIps.getIdMunicipio()), String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString(), "8");
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                mEnviarMensajePolimedicado("El usuario: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + " con N° Hc " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + ", fue clasificado como polimedicado. \nSe debe hacer seguimiento.");
            }
        }
        this.xconsultasbd.cerrarConexionBd();
    }

    public boolean mVerificarDatos() {
        boolean estado = false;
        if (JTDatosDetMedicamentos.getRowCount() != 0) {
            estado = true;
        }
        return estado;
    }

    public void grabar() {
        if (this.JTFNordenSum.getText().isEmpty()) {
            if (this.xfila >= 4) {
                int x = JOptionPane.showInternalConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Definición de polimedicados: Usuario al que se le formule 5 medicamentos o más, </p><font face='Arial' color='red' size=4>por un período superior a 5 meses, para una enfermedad crónica.\n\nOrden con: " + this.xfila + " Medicamentos\nDesea clasificar como polimedicado? ", "PROGRAMA DE POLIMEDICADO", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xespolimedicado = 1;
                } else {
                    this.xespolimedicado = 0;
                }
            }
            switch (this.xobjetollamador) {
                case "Autorizacion":
                    mGuardarDatosAutorizacion();
                    break;
                case "Historia":
                case "HistoriaV2":
                    mGrabarOrdene();
                    break;
                case "Formulas PyP":
                    mGuardarDatosFormulaPyp();
                    break;
            }
        }
    }

    private void mGuardarDatosFormulaPyp() {
        Integer xclasecita;
        String sql = "Insert into ingreso (Id_Usuario, FechaIngreso, HoraIngreso, Id_EmpresaContxConv, Id_Estrato, Id_OrigenAdmision, Id_CausaExterna, Id_Especialidad, Id_Profesional, Id_TipoAtencion, Id_Contrato, EsAtencion,  NAcompanante, TelefonoAcomp, NPersonaResp, TelefonoPResp, Id_Parentesco, Fecha, UsuarioS) Values('" + this.xclase.xjifformulaspyp.xjppersona.getIdPersona() + "','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "','" + this.xclase.xjifformulaspyp.xjppersona.listaEmpresa[this.xclase.xjifformulaspyp.xjppersona.cboEps.getSelectedIndex()][1] + "','1','2','13','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','1','1','1','','','','','5','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String ningreso = this.xconsultasbd.ejecutarSQLId(sql);
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            xclasecita = 86;
        } else {
            xclasecita = 5;
        }
        String sql2 = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ( '" + ningreso + "','" + xclasecita + "','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "','','','1','','','','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String natencion = this.xconsultasbd.ejecutarSQLId(sql2);
        mGuardarDatosOrdenes(Long.parseLong(natencion), String.valueOf(Principal.informacionIps.getIdMunicipio()), String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString(), "8");
        mEnviarMensajePolimedicado("El usuario: " + this.xclase.xjifformulaspyp.xjppersona.getApellido1() + " " + this.xclase.xjifformulaspyp.xjppersona.getApellido2() + " " + this.xclase.xjifformulaspyp.xjppersona.getNombre1() + " " + this.xclase.xjifformulaspyp.xjppersona.getNombre2() + "  con N° Hc " + this.xclase.xjifformulaspyp.xjppersona.getHistoria() + ", fue clasificado como polimedicado. \nSe debe hacer seguimiento.");
        this.xclase.xjifformulaspyp.JTFFNAtencion.setText(natencion);
        this.xconsultasbd.cerrarConexionBd();
    }

    private void mGuardarDatosAutorizacion() {
        JIFAutorizaciones1 jifa = (JIFAutorizaciones1) this.xjifgenerico;
        String sql = "Insert into ingreso (Id_Usuario, FechaIngreso, HoraIngreso, Id_EmpresaContxConv, Id_Estrato, Id_OrigenAdmision, Id_CausaExterna, Id_Especialidad, Id_Profesional, Id_TipoAtencion, Id_Contrato, EsAtencion,  NAcompanante, TelefonoAcomp, NPersonaResp, TelefonoPResp, Id_Parentesco, Fecha, UsuarioS) Values('" + jifa.frmPersona.getIdPersona() + "','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "','" + jifa.frmPersona.listaEmpresa[jifa.frmPersona.cboEps.getSelectedIndex()][1] + "','1','2','13','" + jifa.xidprofesional[jifa.JCBProfesional.getSelectedIndex()][1] + "','" + jifa.xidprofesional[jifa.JCBProfesional.getSelectedIndex()][0] + "','1','1','1','','','','','5','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String ningreso = this.xconsultasbd.ejecutarSQLId(sql);
        String sql2 = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ( '" + ningreso + "','85','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "','','','1','','','','','" + jifa.xidprofesional[jifa.JCBProfesional.getSelectedIndex()][0] + "','" + jifa.xidprofesional[jifa.JCBProfesional.getSelectedIndex()][1] + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.xconsultasbd.ejecutarSQLId(sql2));
        mGuardarDatosOrdenes(Long.valueOf(Principal.txtNo.getText()).longValue(), jifa.xidmunicipio[jifa.JCBMunicipioR.getSelectedIndex()], jifa.xidprofesional[jifa.JCBProfesional.getSelectedIndex()][1], jifa.xidprofesional[jifa.JCBProfesional.getSelectedIndex()][0], jifa.xidempresa[jifa.JCBEmpresaConvenio.getSelectedIndex()]);
        mEnviarMensajePolimedicado("El usuario: " + jifa.frmPersona.getApellido1() + " " + jifa.frmPersona.getApellido2() + " " + jifa.frmPersona.getNombre1() + " " + jifa.frmPersona.getNombre2() + "  con N° Hc " + jifa.frmPersona.getHistoria() + ", fue clasificado como polimedicado. \nSe debe hacer seguimiento.");
        this.xconsultasbd.cerrarConexionBd();
    }

    public int mCalcularTotalFormula() {
        int valor = 0;
        int valort = 0;
        if (JTDatosDetMedicamentos.getRowCount() != 0) {
            for (int J = 0; J < JTDatosDetMedicamentos.getRowCount(); J++) {
                valor += Integer.valueOf(xmodelodetallet.getValueAt(J, 8).toString()).intValue() * Integer.valueOf(xmodelodetallet.getValueAt(J, 4).toString()).intValue();
                valort += Integer.valueOf(xmodelodetallet.getValueAt(J, 8).toString()).intValue() * Integer.valueOf(xmodelodetallet.getValueAt(J, 4).toString()).intValue() * Integer.valueOf(xmodelodetallet.getValueAt(J, 6).toString()).intValue();
            }
            if (this.xobjetollamador.equals("Autorizacion")) {
                JIFAutorizaciones1 jifa = (JIFAutorizaciones1) this.xjifgenerico;
                if (jifa.frmPersona.cboTipoEmpresa.getSelectedIndex() != -1 && jifa.frmPersona.cboRelacionLaboral.getSelectedIndex() != -1) {
                    jifa.JTFFValorTratamiento.setValue(Integer.valueOf(valort));
                    if (valort <= Long.valueOf(jifa.frmPersona.listaRelacionLaboral[jifa.frmPersona.cboRelacionLaboral.getSelectedIndex()][1]).longValue()) {
                        jifa.JTFFValorDescuento.setValue(Long.valueOf(jifa.frmPersona.listaRelacionLaboral[jifa.frmPersona.cboRelacionLaboral.getSelectedIndex()][2]));
                    } else if (valor < Long.valueOf(jifa.frmPersona.listaRelacionLaboral[jifa.frmPersona.cboRelacionLaboral.getSelectedIndex()][5]).longValue()) {
                        Double cal = Double.valueOf((((double) valort) * Double.parseDouble(jifa.frmPersona.listaRelacionLaboral[jifa.frmPersona.cboRelacionLaboral.getSelectedIndex()][4])) / 100.0d);
                        jifa.JTFFValorDescuento.setValue(cal);
                    } else {
                        Double cal2 = Double.valueOf((((double) valort) * Double.parseDouble(jifa.frmPersona.listaRelacionLaboral[jifa.frmPersona.cboRelacionLaboral.getSelectedIndex()][3])) / 100.0d);
                        jifa.JTFFValorDescuento.setValue(cal2);
                    }
                    jifa.JTFFValorDescuentoxQuinc.setValue(Double.valueOf(Double.valueOf(jifa.JTFFValorDescuento.getValue().toString()).doubleValue() / ((double) jifa.xnquincenas)));
                }
            }
            return valor;
        }
        if (this.xv1 == 1) {
            JIFAutorizaciones1 jifa2 = (JIFAutorizaciones1) this.xjifobjetollamador;
            jifa2.JTFFValorTratamiento.setValue(0);
            jifa2.JTFFValorDescuento.setValue(0);
            jifa2.JTFFValorDescuentoxQuinc.setValue(0);
            this.JTFFValorFormula.setValue(0);
        }
        return 0;
    }

    private void mEnviarMensajePolimedicado(String xdatosu) {
        if (this.xespolimedicado == 1) {
            this.xmetodo.mEnvioCorreoElectronico(xdatosu + "\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario(), "polimedicado@fundacionpanzenu.org.co", "USUARIO POLIMEDICADO", Principal.usuarioSistemaDTO.getLogin());
        }
    }

    private void mGuardarDatosOrdenes(long idatencion, String municipio, String xidesp, String xidprofesional, String xidempresa) {
        int vmax = 1;
        int dias = 0;
        int validaPrimeraOrden = 0;
        for (int i = 0; i < JTDatosDetMedicamentos.getRowCount(); i++) {
            if (Integer.parseInt(xmodelodetallet.getValueAt(i, 6).toString()) > vmax) {
                vmax = Integer.parseInt(xmodelodetallet.getValueAt(i, 6).toString());
            }
        }
        for (int k = 1; k <= vmax; k++) {
            this.xhoytf = new GregorianCalendar();
            this.xhoytf.add(5, dias);
            ConsultasMySQL xmt1 = new ConsultasMySQL();
            this.xsql = "Insert into h_ordenes (Id_Atencion, Id_TipoServicio, IdTipoFormula, Id_Profesional, Id_Especialidad, FechaOrden, NoFormInicio, NoFormuFin, NotasMedPrepago, IdMunicipio, EstaEntregada, EstaAuditada, Id_Proveedor, EsPolimedicado, Estado, Fecha, UsuarioS) values('" + idatencion + "','7','" + this.xidtipof[this.JCBTipoFormula.getSelectedIndex()] + "','" + xidprofesional + "','" + xidesp + "','" + this.xmetodo.formatoAMD.format(this.xhoytf.getTime()) + "','" + k + "','" + vmax + "',' ','" + municipio + "','" + this.xtipo + "','0','" + xidempresa + "','" + this.xespolimedicado + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            String idOrden = xmt1.ejecutarSQLId(this.xsql);
            validaPrimeraOrden++;
            if (validaPrimeraOrden == 1) {
                this.JTFNordenSum.setText(idOrden);
                this.JLBEstado.setText("ACTIVA");
                this.IdregistraPrimeraOrden = Integer.valueOf(this.JTFNordenSum.getText()).intValue();
            }
            xmt1.cerrarConexionBd();
            guardaritemorden(k, Long.parseLong(idOrden));
            dias += 30;
            this.editar++;
        }
        mImprimir(Long.parseLong(this.IdregistraPrimeraOrden + ""), 1);
    }

    public void imprimir() {
        if (!this.JTFNordenSum.getText().isEmpty()) {
            mVerHImpresion(Long.valueOf(this.JTFNordenSum.getText()).longValue());
        }
    }

    public void mImprimir(long idorden, int n) {
        if (idorden != 0) {
            try {
                SimpleDateFormat xfechar = new SimpleDateFormat("dd/MM/yyyy");
                String xnotasad = null;
                String tipo = "Farmacia";
                String sql = "SELECT Id_Atencion, Id, FechaOrden FROM h_ordenes where Id='" + idorden + "'";
                ConsultasMySQL xmt = new ConsultasMySQL();
                ResultSet rsm = xmt.traerRs(sql);
                if (rsm.next()) {
                    rsm.first();
                    long xida = rsm.getLong(1);
                    String sql2 = "SELECT Id_Atencion, Id, FechaOrden FROM  h_ordenes where  Id_Atencion='" + xida + "' and Id>'" + idorden + "' order by Id";
                    rsm = this.xconsultasbd.traerRs(sql2);
                    if (rsm.next()) {
                        rsm.first();
                        xnotasad = "Orden N° : " + rsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + xfechar.format((Date) rsm.getDate(3));
                    }
                }
                rsm.close();
                this.xconsultasbd.cerrarConexionBd();
                xmt.cerrarConexionBd();
                String[][] mparametros = new String[6][2];
                for (int j = 0; j < n; j++) {
                    mparametros[0][0] = "norden";
                    mparametros[0][1] = String.valueOf(idorden);
                    mparametros[1][0] = "xp2";
                    mparametros[1][1] = tipo;
                    mparametros[2][0] = "ip";
                    mparametros[2][1] = xnotasad;
                    mparametros[3][0] = "nusuarios";
                    mparametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
                    mparametros[4][0] = "SUBREPORT_DIR";
                    mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                    mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                    mparametros[5][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        this.xsql = "SELECT  `g_relacionlaboral`.`Id` FROM  `h_ordenes` INNER JOIN`h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN`ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN`g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN`g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_usuario`.`Id_persona`) INNER JOIN`g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`) WHERE (`h_ordenes`.`Id` ='" + idorden + "') ";
                        ResultSet xrs = this.xconsultasbd.traerRs(this.xsql);
                        Throwable th = null;
                        try {
                            try {
                                if (xrs.next()) {
                                    xrs.first();
                                    if (this.xobjetollamador.equals("Autorizacion")) {
                                        if (xrs.getInt(1) == 1) {
                                            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP", mparametros);
                                        } else {
                                            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Directivos", mparametros);
                                        }
                                    } else if (xrs.getInt(1) == 1) {
                                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP", mparametros);
                                    } else {
                                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Directivos", mparametros);
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
                                this.xconsultasbd.cerrarConexionBd();
                            } finally {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th3;
                        }
                    } else if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 0) {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CDajud.jasper", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras.jasper", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP1.jasper", mparametros);
                            } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_San_Jorge", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros);
                            } else {
                                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital.jasper", mparametros);
                            }
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CDajud.jasper", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras.jasper", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP1.jasper", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros);
                            } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_San_Jorge", mparametros);
                            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros);
                            } else {
                                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital.jasper", mparametros);
                            }
                        }
                    } else {
                        Object[] botones = {"Visualizar", "Imprimir", "Cerrar"};
                        int m = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                        if (m == 0) {
                            if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CDajud", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP1", mparametros);
                                } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_San_Jorge", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros);
                                } else {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros);
                                }
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CDajud", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP1", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros);
                                } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_San_Jorge", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros);
                                } else {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros);
                                }
                            }
                        } else if (m == 1) {
                            if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CDajud.jasper", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP1.jasper", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros);
                                } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_San_Jorge", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros);
                                } else {
                                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital.jasper", mparametros);
                                }
                            } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CDajud.jasper", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_CPsiquiatras", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP1.jasper", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital", mparametros);
                                } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RFormulaGeneralMP2_San_Jorge", mparametros);
                                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "Pajonal_RFormulaGeneralMP2", mparametros);
                                } else {
                                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RFormulaGeneralMP_Hospital.jasper", mparametros);
                                }
                            }
                        }
                    }
                    tipo = "Usuario";
                }
            } catch (SQLException e) {
            }
        }
    }

    private void guardaritemorden(int vmes, long idorden) {
        int dr = 0;
        String xconc = "";
        if (JTDatosDetMedicamentos.getRowCount() != 0) {
            for (int J = 0; J < JTDatosDetMedicamentos.getRowCount(); J++) {
                if (!xmodelodetallet.getValueAt(J, 10).toString().equals("") || !xmodelodetallet.getValueAt(J, 11).toString().equals("") || !xmodelodetallet.getValueAt(J, 12).toString().equals("") || !xmodelodetallet.getValueAt(J, 13).toString().equals("")) {
                    String sql = "INSERT INTO  `h_concecutivo_ctc` ( `FechaR`, `IdOrden`, `UsuarioS`) VALUES ('" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', '" + this.JTFNordenSum.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    xconc = this.xconsultasbd.ejecutarSQLId(sql);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            for (int J2 = 0; J2 < JTDatosDetMedicamentos.getRowCount(); J2++) {
                if (Integer.valueOf(xmodelodetallet.getValueAt(J2, 6).toString()).intValue() >= vmes) {
                    ConsultasMySQL xmt2 = new ConsultasMySQL();
                    if (!xmodelodetallet.getValueAt(J2, 10).toString().equals("") || !xmodelodetallet.getValueAt(J2, 11).toString().equals("") || !xmodelodetallet.getValueAt(J2, 12).toString().equals("") || !xmodelodetallet.getValueAt(J2, 13).toString().equals("")) {
                        this.xsql = "insert into h_itemordenessum (Id_HOrdenes, Id_Suministro, PosologiaManual, Duracion, Cantidad, EsfueraVadem, Justificacion, ValorUnitario, ValorTotal, Fecha, UsuarioS, x1, x2, x3, x4, idModalidadAtencion, idServicioRips,IdConcecutivo,idViaAdministracion) values('" + idorden + "','" + xmodelodetallet.getValueAt(J2, 0) + "','" + xmodelodetallet.getValueAt(J2, 2) + "','" + xmodelodetallet.getValueAt(J2, 3) + "','" + xmodelodetallet.getValueAt(J2, 4) + "','0','" + xmodelodetallet.getValueAt(J2, 5) + "','" + xmodelodetallet.getValueAt(J2, 8) + "','" + (Integer.valueOf(xmodelodetallet.getValueAt(J2, 8).toString()).intValue() * Integer.valueOf(xmodelodetallet.getValueAt(J2, 4).toString()).intValue()) + "','" + this.xfechasql.format(this.xhoy.getTime()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + xmodelodetallet.getValueAt(J2, 10) + "','" + xmodelodetallet.getValueAt(J2, 11) + "','" + xmodelodetallet.getValueAt(J2, 12) + "','" + xmodelodetallet.getValueAt(J2, 13) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdModalidad() + "','" + xmodelodetallet.getValueAt(J2, 17) + "','" + xconc + "','" + xmodelodetallet.getValueAt(J2, 19) + "')";
                    } else {
                        this.xsql = "insert into h_itemordenessum (Id_HOrdenes, Id_Suministro, PosologiaManual, Duracion, Cantidad, EsfueraVadem, Justificacion, ValorUnitario, ValorTotal, Fecha, UsuarioS, x1, x2, x3, x4, idModalidadAtencion, idServicioRips, idViaAdministracion) values('" + idorden + "','" + xmodelodetallet.getValueAt(J2, 0) + "','" + xmodelodetallet.getValueAt(J2, 2) + "','" + xmodelodetallet.getValueAt(J2, 3) + "','" + xmodelodetallet.getValueAt(J2, 4) + "','0','" + xmodelodetallet.getValueAt(J2, 5) + "','" + xmodelodetallet.getValueAt(J2, 8) + "','" + (Integer.valueOf(xmodelodetallet.getValueAt(J2, 8).toString()).intValue() * Integer.valueOf(xmodelodetallet.getValueAt(J2, 4).toString()).intValue()) + "','" + this.xfechasql.format(this.xhoy.getTime()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + xmodelodetallet.getValueAt(J2, 10) + "','" + xmodelodetallet.getValueAt(J2, 11) + "','" + xmodelodetallet.getValueAt(J2, 12) + "','" + xmodelodetallet.getValueAt(J2, 13) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdModalidad() + "','" + xmodelodetallet.getValueAt(J2, 17) + "','" + xmodelodetallet.getValueAt(J2, 19) + "')";
                    }
                    dr += Integer.valueOf(xmodelodetallet.getValueAt(J2, 3).toString()).intValue();
                    xmt2.ejecutarSQL(this.xsql);
                    xmt2.cerrarConexionBd();
                    if (!vector.isEmpty() && Integer.valueOf(JTDatosDetMedicamentos.getValueAt(J2, 14).toString()).intValue() != -1) {
                        HItemordenessum itemordenessum = this.iHItemordenessumService.detalleItemOrdeHistoria(Long.valueOf(idorden), Long.valueOf(xmodelodetallet.getValueAt(J2, 0).toString()));
                        new ArrayList();
                        List<HItemordenessumRespuestacuestionario> list = (List) vector.get(Integer.valueOf(JTDatosDetMedicamentos.getValueAt(J2, 14).toString()).intValue());
                        list.forEach(value -> {
                            value.setIdItemOrdenSuministro(itemordenessum);
                        });
                        new ArrayList();
                        new ArrayList();
                        List<HItemordenessumRespuestacuestionario> listNueva = this.iHItemordenessumRespuestacuestionarioService.grabar(list);
                        List<HItemordenessumRespuestacuestionario> listNueva1 = this.iHItemordenessumRespuestacuestionarioService.listaRespuestaCuestionarioIdOrdenItemsSuminitro(Long.valueOf(listNueva.get(0).getIdItemOrdenSuministro().getId()));
                        System.out.println("lista : " + listNueva1.toString());
                        if (!listNueva1.isEmpty()) {
                            for (HItemordenessumRespuestacuestionario hItemordenessumRespuestacuestionario : listNueva1) {
                                if (hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoPreguntas().getId() != this.idPregunta) {
                                    this.idPregunta = hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoPreguntas().getId();
                                    switch (hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoRespuesta().getTipo().intValue()) {
                                        case 1:
                                            this.cuerpoMensaje += hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoPreguntas().getNbre() + "\n\t-" + hItemordenessumRespuestacuestionario.getObservacion() + "\n\n";
                                            break;
                                        default:
                                            String observacion = "";
                                            if (!hItemordenessumRespuestacuestionario.getObservacion().isEmpty()) {
                                                observacion = "\nObservación : " + hItemordenessumRespuestacuestionario.getObservacion();
                                            }
                                            this.cuerpoMensaje += hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoPreguntas().getNbre() + "\n\t-" + hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoRespuesta().getNbre() + observacion + "\n\n";
                                            break;
                                    }
                                } else {
                                    switch (hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoRespuesta().getTipo().intValue()) {
                                        case 1:
                                            this.cuerpoMensaje += "\n\t-" + hItemordenessumRespuestacuestionario.getObservacion() + "\n\n";
                                            break;
                                        default:
                                            String observacion2 = "";
                                            if (!hItemordenessumRespuestacuestionario.getObservacion().isEmpty()) {
                                                observacion2 = "\nObservación : " + hItemordenessumRespuestacuestionario.getObservacion();
                                            }
                                            this.cuerpoMensaje += "\n\t-" + hItemordenessumRespuestacuestionario.getIdTipoRespuestaCuestionario().getSoTipoRespuesta().getNbre() + observacion2 + "\n\n";
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
                this.duracion = dr / JTDatosDetMedicamentos.getRowCount();
                if (!this.cuerpoMensaje.isEmpty()) {
                    System.out.println("Cuerpo : " + this.cuerpoMensaje);
                    this.xmetodo.mEnvioCorreoElectronico("Se ha generado encuesta de farmacovigilancia al usuario: " + this.nombreUsuario + "\n" + this.cuerpoMensaje + "\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), "rdtejadas@fundacionpanzenu.org.co", "CASO DE FARMACOVIGILANCIA (Metodología “gatillo” o disparadores) - FORMULA No. " + this.JTFNordenSum.getText(), "sistemas");
                }
            }
        }
    }

    private void mValidarInteracionMed() {
        try {
            String str = "SELECT h_interaciones_pactivo.Id_PrincipioA1, h_interaciones_pactivo.Id_PrincipioA2, i_principioactivo.Nbre, h_interaciones_pactivo.Mensaje FROM h_interaciones_pactivo INNER JOIN i_principioactivo  ON (h_interaciones_pactivo.Id_PrincipioA2 = i_principioactivo.Id) WHERE (h_interaciones_pactivo.Estado =1 AND h_interaciones_pactivo.Id_PrincipioA1 ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "') ";
            for (int x = 0; x < JTDatosDetMedicamentos.getRowCount(); x++) {
                String sql = "SELECT h_interaciones_pactivo.Id_PrincipioA1, h_interaciones_pactivo.Id_PrincipioA2, i_principioactivo.Nbre, h_interaciones_pactivo.Mensaje, h_interaciones_pactivo.Tipo FROM h_interaciones_pactivo INNER JOIN i_principioactivo  ON (h_interaciones_pactivo.Id_PrincipioA2 = i_principioactivo.Id) WHERE (h_interaciones_pactivo.Estado =1 AND h_interaciones_pactivo.Id_PrincipioA1 ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "'AND h_interaciones_pactivo.Id_PrincipioA2 ='" + JTDatosDetMedicamentos.getValueAt(x, 9).toString() + "') ";
                ResultSet xrs = this.xconsultasbd.traerRs(sql);
                if (xrs.next()) {
                    this.xtipom = true;
                    this.xtipoim = xrs.getInt(5);
                    JOptionPane.showMessageDialog((Component) null, xrs.getString(4) + "\nPrincipio Activo : " + xrs.getString(3), "ALERTA DE SEGURIDAD CLÍNICA", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                }
                xrs.close();
                this.xconsultasbd.cerrarConexionBd();
                String sql2 = "SELECT h_interaciones_pactivo.Id_PrincipioA1, h_interaciones_pactivo.Id_PrincipioA2, i_principioactivo.Nbre, h_interaciones_pactivo.Mensaje, h_interaciones_pactivo.Tipo FROM h_interaciones_pactivo INNER JOIN i_principioactivo  ON (h_interaciones_pactivo.Id_PrincipioA2 = i_principioactivo.Id) WHERE (h_interaciones_pactivo.Estado =1 AND h_interaciones_pactivo.Id_PrincipioA2 ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "'AND h_interaciones_pactivo.Id_PrincipioA1 ='" + JTDatosDetMedicamentos.getValueAt(x, 9).toString() + "') ";
                ResultSet xrs2 = this.xconsultasbd.traerRs(sql2);
                if (xrs2.next()) {
                    this.xtipoim = xrs2.getInt(5);
                    this.xtipom = true;
                    JOptionPane.showMessageDialog((Component) null, xrs2.getString(4) + "\nPrincipio Activo : " + xrs2.getString(3), "ALERTA DE SEGURIDAD CLÍNICA", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                }
                xrs2.close();
                this.xconsultasbd.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPOOrdenSuministroH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void validarmedicamentos() {
        String sql;
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            try {
                ConsultasMySQL xmt = new ConsultasMySQL();
                if (this.xobjetollamador.equals("Historia") || this.xobjetollamador.equals("HistoriaV2")) {
                    this.xidusuario = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                } else if (this.xobjetollamador.equals("Autorizacion")) {
                    JIFAutorizaciones1 jifa = (JIFAutorizaciones1) this.xjifgenerico;
                    this.xidusuario = jifa.frmPersona.getIdPersona();
                } else if (this.xobjetollamador.equals("Formulas PyP")) {
                    this.xidusuario = this.xclase.xjifformulaspyp.xjppersona.getIdPersona();
                }
                if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                    sql = "SELECT DATE_FORMAT(h_ordenes.FechaOrden,'%d/%m/%Y'), UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) as NSuministro  , h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, profesional.NProfesional, h_tipoformula.Nbre,DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion AS DURACION FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona) INNER JOIN h_tipoformula  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN profesional  ON (profesional.Id_Persona = g_profesional.Id_Persona) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) WHERE (h_ordenes.Estado =0 AND i_principioactivo.Id ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "' AND ingreso.Id_Usuario ='" + this.xidusuario + "' AND (DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion)>0) ORDER BY h_ordenes.FechaOrden DESC ";
                } else {
                    sql = "SELECT DATE_FORMAT(h_ordenes.FechaOrden,'%d/%m/%Y'), concat(i_suministro.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ',i_concentracion.Nbre,' ',i_presentacioncomercial.Nbre)as NSuministro  , h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, profesional.NProfesional, h_tipoformula.Nbre,DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion AS DURACION FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona) INNER JOIN h_tipoformula  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN profesional  ON (profesional.Id_Persona = g_profesional.Id_Persona) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) WHERE (h_ordenes.Estado =0 AND i_principioactivo.Id ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "' AND ingreso.Id_Usuario ='" + this.xidusuario + "' AND (DATEDIFF(h_ordenes.FechaOrden,NOW())+h_itemordenessum.Duracion)>0) ORDER BY h_ordenes.FechaOrden DESC ";
                }
                this.rs = xmt.traerRs(sql);
                if (this.rs.next()) {
                    try {
                        Component jIFConsultarMedicamentosActivos = new JIFConsultarMedicamentosActivos(sql, 0, this.xobjetollamador);
                        Principal.PanelPpal.add(jIFConsultarMedicamentosActivos, JLayeredPane.DEFAULT_LAYER);
                        jIFConsultarMedicamentosActivos.setVisible(true);
                        jIFConsultarMedicamentosActivos.setSelected(true);
                    } catch (PropertyVetoException e) {
                    }
                }
                this.rs.close();
                xmt.cerrarConexionBd();
                String str = "SELECT g_novedadsuministro.Id, g_tiponovedad.Nbre, g_tiponovedad.tipo, g_novedadsuministro.Documento FROM g_novedadsuministro INNER JOIN g_tiponovedad  ON (g_novedadsuministro.Id_TipoNovedad = g_tiponovedad.Id) WHERE (g_novedadsuministro.Id_Suministro ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2) + "' AND g_novedadsuministro.Estado =0) ";
            } catch (SQLException e2) {
                e2.getMessage();
            }
        }
    }

    public void anular() {
        if (!this.JTFNordenSum.getText().isEmpty()) {
            if (this.xestaentregada != 2) {
                int n = JOptionPane.showInternalOptionDialog(this, "Esta seguro de anular la orden", "ANULAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, 0);
                if (n == 0) {
                    String sql = "UPDATE h_ordenes SET Estado = 1 WHERE Id_TipoServicio = 7 and id='" + this.JTFNordenSum.getText() + "'";
                    this.xconsultasbd.ejecutarSQL(sql);
                    this.xconsultasbd.cerrarConexionBd();
                    this.JLBEstado.setText("Anulada");
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Orden ya dispensada.\nNo se puede anular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe orden activa", "ANULAR ORDEN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    public void mVerHImpresion(long nord) {
        Calendar DiaSemana = Calendar.getInstance();
        int NumeroDia = DiaSemana.get(7);
        String sql = "SELECT Id, HoraInicial, HoraFinal, EsLaboral FROM g_horariofarmacia where Id='" + NumeroDia + "'";
        ResultSet rs1 = this.xconsultasbd.traerRs(sql);
        try {
            rs1.next();
            if (rs1.getRow() != 0) {
                int y = Integer.parseInt(this.xfechasqly.format(this.xhoy.getTime()));
                int m = Integer.parseInt(this.xfechasqlm.format(this.xhoy.getTime())) - 1;
                int d = Integer.parseInt(this.xfechasqld.format(this.xhoy.getTime()));
                GregorianCalendar xhoyv = new GregorianCalendar(y, m, d, Integer.parseInt(rs1.getString(2).substring(0, 2)), Integer.parseInt(rs1.getString(2).substring(4, 5)), Integer.parseInt(rs1.getString(2).substring(7, 8)));
                GregorianCalendar xhoyv1 = new GregorianCalendar(y, m, d, Integer.parseInt(rs1.getString(3).substring(0, 2)), Integer.parseInt(rs1.getString(3).substring(4, 5)), Integer.parseInt(rs1.getString(3).substring(7, 8)));
                if (rs1.getBoolean(4)) {
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        mImprimir(nord, 1);
                    } else {
                        mImprimir(nord, 1);
                    }
                } else if (this.xhoy.getTimeInMillis() >= xhoyv.getTimeInMillis() && this.xhoy.getTimeInMillis() <= xhoyv1.getTimeInMillis()) {
                    mImprimir(nord, 1);
                } else {
                    mImprimir(nord, 1);
                }
            }
            rs1.close();
        } catch (SQLException e) {
        }
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mBuscarSuministro(String id, boolean xforma) {
        String sql;
        try {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                sql = "SELECT i_suministro.Id, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))), h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, h_itemordenessum.Justificacion, h_itemordenessum.ValorUnitario, h_ordenes.Estado, h_ordenes.Id, h_ordenes.EstaEntregada, i_principioactivo.Id  , ggs.id idGrupo, ggs.nombre nombreGrupo, gsr.id idServicioRips, gsr.nombre nombreServicioRips, iv.Id as idVia, iv.Nbre as viaAdministracion FROM h_tipoformula INNER JOIN h_ordenes  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (ingreso.Id = h_atencion.Id_Ingreso) INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo ON (i_principioactivo.Id= i_suministro.IdPrincipioActivo) INNER JOIN `i_concentracion` ON (i_concentracion.`Id`=`i_suministro`.`IdConcentracion`) INNER JOIN `i_presentacionfarmaceutica` ON (`i_presentacionfarmaceutica`.`Id` = `i_suministro`.`IdPresentacionFarmaceutica`) inner join g_servicios_rips gsr on (gsr.id=h_itemordenessum.idServicioRips)\ninner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio)\n inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion)\nWHERE     (h_ordenes.Id = '" + id + "' and h_itemordenessum.Estado=1)";
            } else {
                sql = "SELECT i_suministro.Id, i_suministro.Nbre, h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, h_itemordenessum.Justificacion, h_itemordenessum.ValorUnitario, h_ordenes.Estado, h_ordenes.Id, h_ordenes.EstaEntregada, i_principioactivo.Id , ggs.id idGrupo, ggs.nombre nombreGrupo, gsr.id idServicioRips, gsr.nombre nombreServicioRips, iv.Id as idVia, iv.Nbre as viaAdministracion FROM h_tipoformula INNER JOIN h_ordenes  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (ingreso.Id = h_atencion.Id_Ingreso) INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo ON (i_principioactivo.Id= i_suministro.IdPrincipioActivo) inner join g_servicios_rips gsr on (gsr.id=h_itemordenessum.idServicioRips)\ninner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio)\n inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion)\nWHERE     (h_ordenes.Id = '" + id + "' and h_itemordenessum.Estado=1)";
            }
            nuevo();
            System.out.println(sql);
            this.rs = this.xconsultasbd.traerRs(sql);
            this.rs.next();
            if (this.rs.getRow() != 0) {
                this.rs.first();
                if (xforma) {
                    if (this.rs.getInt(8) == 1) {
                        this.JLBEstado.setText("ANULADA");
                    } else {
                        this.JLBEstado.setText("ACTIVA");
                    }
                    this.xestaentregada = this.rs.getInt(10);
                    this.JTFNordenSum.setText("" + this.rs.getLong(9));
                    this.IdregistraPrimeraOrden = this.rs.getInt(9);
                } else {
                    this.xestaentregada = 0;
                }
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    xmodelodetallet.addRow(this.xdato);
                    xmodelodetallet.setValueAt(Integer.valueOf(this.rs.getInt(1)), this.xfila, 0);
                    xmodelodetallet.setValueAt(this.rs.getString(2), this.xfila, 1);
                    xmodelodetallet.setValueAt(this.rs.getString(3), this.xfila, 2);
                    xmodelodetallet.setValueAt(Integer.valueOf(this.rs.getInt(4)), this.xfila, 3);
                    xmodelodetallet.setValueAt(Integer.valueOf(this.rs.getInt(5)), this.xfila, 4);
                    xmodelodetallet.setValueAt(this.rs.getString(6), this.xfila, 5);
                    xmodelodetallet.setValueAt(new Integer(1), this.xfila, 6);
                    xmodelodetallet.setValueAt(new Integer(1), this.xfila, 7);
                    xmodelodetallet.setValueAt(Long.valueOf(this.rs.getLong(7)), this.xfila, 8);
                    xmodelodetallet.setValueAt(this.rs.getString(11), this.xfila, 9);
                    xmodelodetallet.setValueAt(this.x1, this.xfila, 10);
                    xmodelodetallet.setValueAt(this.x2, this.xfila, 11);
                    xmodelodetallet.setValueAt(this.x3, this.xfila, 12);
                    xmodelodetallet.setValueAt(this.x4, this.xfila, 13);
                    xmodelodetallet.setValueAt(-1, this.xfila, 14);
                    xmodelodetallet.setValueAt(this.rs.getString("idGrupo"), this.xfila, 15);
                    xmodelodetallet.setValueAt(this.rs.getString("nombreGrupo"), this.xfila, 16);
                    xmodelodetallet.setValueAt(this.rs.getString("idServicioRips"), this.xfila, 17);
                    xmodelodetallet.setValueAt(this.rs.getString("nombreServicioRips"), this.xfila, 18);
                    xmodelodetallet.setValueAt(this.rs.getString("idVia"), this.xfila, 19);
                    xmodelodetallet.setValueAt(this.rs.getString("viaAdministracion"), this.xfila, 20);
                    this.xfila++;
                }
            }
            this.JTFFValorFormula.setValue(Integer.valueOf(mCalcularTotalFormula()));
            this.rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaMedicamentos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdPactivo", "Nombre Pricipio Activo", "IdProducto", "Producto", "Presentación", "Cantidad", "Valor", "C", "Vencido", "FechaV", "CInventario", "Tipo", "Tipo", "pos", "CTC", "CTC1", "CTC2", "CTC3", "CTC4", "AlertaLasa", "LASA", "ObservacionLasa", "Color", "Via"}) { // from class: Historia.JPOOrdenSuministroH.19
            Class[] types = {Integer.class, String.class, Long.class, String.class, String.class, Integer.class, Double.class, String.class, Integer.class, String.class, Boolean.class, Integer.class, String.class, Integer.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDatosMedicamentos;
        JTable jTable2 = this.JTDatosMedicamentos;
        jTable.setAutoResizeMode(0);
        this.JTDatosMedicamentos.doLayout();
        this.JTDatosMedicamentos.setModel(this.xmodelo);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDatosMedicamentos.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDatosMedicamentos.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDatosMedicamentos.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDatosMedicamentos.getColumnModel().getColumn(21).setPreferredWidth(200);
        this.JTDatosMedicamentos.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(23).setMaxWidth(0);
    }

    private void mLLenartabla() {
        String sql;
        try {
            mCrearTablaMedicamentos();
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                if (this.JCHEsPrincipio.isSelected()) {
                    if (!this.xobjetollamador.equals("Autorizacion")) {
                        if (this.xtipobusqueda == 0) {
                            sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, avg(i_suministroxbodega.Costo), i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc, IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN `h_tipoformula_suministro` ON (i_suministro.Id = h_tipoformula_suministro.`Id_Suministro`)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 AND h_tipoformula_suministro.Estado=1 AND h_tipoformula_suministro.`Id_TipoFormula`='" + this.xidtipof[this.JCBTipoFormula.getSelectedIndex()] + "'   and i_principioactivo.Nbre<>'-' and i_principioactivo.Nbre like'" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre ";
                        } else {
                            sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, avg(i_suministroxbodega.Costo), i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc, IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN `h_tipoformula_suministro` ON (i_suministro.Id = h_tipoformula_suministro.`Id_Suministro`)   INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 AND h_tipoformula_suministro.Estado=1 AND h_tipoformula_suministro.`Id_TipoFormula`='" + this.xidtipof[this.JCBTipoFormula.getSelectedIndex()] + "'  and i_principioactivo.Nbre<>'-' and i_principioactivo.Nbre like '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro ORDER BY i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo ASC, IdSuministro, i_suministro.Nbre ";
                        }
                    } else if (this.xtipobusqueda == 0) {
                        sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, i_suministro.ValorPLM, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1  and i_suministro.EstaActivo=1 and i_suministroxbodega.idbodega=2 and i_suministro.IdTipoProducto in(1,7,8,10,11,12 )  and i_principioactivo.Nbre like'" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre ";
                    } else {
                        sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, sum(i_suministroxlotexbodega.Cantidad), i_suministro.ValorPLM, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta ,i_clasif_lasa.`color` Colorlasa FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1  and i_suministro.EstaActivo=1 and i_suministroxbodega.idbodega=2 and i_suministro.IdTipoProducto in(1,7,8,10,11,12 )  and i_principioactivo.Nbre like '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre ";
                    }
                } else if (!this.xobjetollamador.equals("Autorizacion")) {
                    if (this.xtipobusqueda == 0) {
                        sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, avg(i_suministroxbodega.Costo), i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN `h_tipoformula_suministro` ON (i_suministro.Id = h_tipoformula_suministro.`Id_Suministro`)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 AND h_tipoformula_suministro.Estado=1 AND h_tipoformula_suministro.`Id_TipoFormula`='" + this.xidtipof[this.JCBTipoFormula.getSelectedIndex()] + "'  and i_principioactivo.Nbre<>'-' and UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) like '" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_suministro.Nbre, i_presentacionfarmaceutica.Nbre ";
                    } else {
                        sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, avg(i_suministroxbodega.Costo), i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN `h_tipoformula_suministro` ON (i_suministro.Id = h_tipoformula_suministro.`Id_Suministro`)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 AND h_tipoformula_suministro.Estado=1 AND h_tipoformula_suministro.`Id_TipoFormula`='" + this.xidtipof[this.JCBTipoFormula.getSelectedIndex()] + "' and  i_principioactivo.Nbre<>'-' and UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) like'%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_suministro.Nbre, i_presentacionfarmaceutica.Nbre ";
                    }
                } else if (this.xtipobusqueda == 0) {
                    sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad,i_suministro.ValorPLM, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 and i_suministro.EstaActivo=1 and i_suministroxbodega.idbodega=2 and i_suministro.IdTipoProducto in(1, 6, 7,8,10,11, 12)  and UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) like '" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro  order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre";
                } else {
                    sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad,i_suministro.ValorPLM, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`, IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 and i_suministro.EstaActivo=1 and i_suministroxbodega.idbodega=2 and i_suministro.IdTipoProducto in(1, 6, 7,8,10,11, 12)  and UPPER(CONCAT(IF(i_principioactivo.`Nbre`='NO APLICA',i_suministro.`Nbre`,i_principioactivo.`Nbre`),' ', IF(i_concentracion.`Nbre`='NO APLICA' OR i_concentracion.`Nbre`='-','',i_concentracion.`Nbre`) ,' ', IF(i_presentacionfarmaceutica.`Nbre`='NO APLICA','', i_presentacionfarmaceutica.`Nbre`))) like  '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro  order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre";
                }
            } else if (this.JCHEsPrincipio.isSelected()) {
                if (!this.xobjetollamador.equals("Autorizacion")) {
                    if (this.xtipobusqueda == 0) {
                        sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, avg(i_suministroxbodega.Costo), i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc, IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN `h_tipoformula_suministro` ON (i_suministro.Id = h_tipoformula_suministro.`Id_Suministro`)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 AND h_tipoformula_suministro.Estado=1 AND h_tipoformula_suministro.`Id_TipoFormula`='" + this.xidtipof[this.JCBTipoFormula.getSelectedIndex()] + "'   and i_principioactivo.Nbre<>'-' and i_principioactivo.Nbre like'" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre ";
                    } else {
                        sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, avg(i_suministroxbodega.Costo), i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc, IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN `h_tipoformula_suministro` ON (i_suministro.Id = h_tipoformula_suministro.`Id_Suministro`)   INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 AND h_tipoformula_suministro.Estado=1 AND h_tipoformula_suministro.`Id_TipoFormula`='" + this.xidtipof[this.JCBTipoFormula.getSelectedIndex()] + "'  and i_principioactivo.Nbre<>'-' and i_principioactivo.Nbre like '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro ORDER BY i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo ASC, IdSuministro, i_suministro.Nbre ";
                    }
                } else if (this.xtipobusqueda == 0) {
                    sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, i_suministro.ValorPLM, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1  and i_suministro.EstaActivo=1 and i_suministroxbodega.idbodega=2 and i_suministro.IdTipoProducto in(1,7,8,10,11,12 )  and i_principioactivo.Nbre like'" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre ";
                } else {
                    sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, sum(i_suministroxlotexbodega.Cantidad), i_suministro.ValorPLM, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta ,i_clasif_lasa.`color` Colorlasa FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1  and i_suministro.EstaActivo=1 and i_suministroxbodega.idbodega=2 and i_suministro.IdTipoProducto in(1,7,8,10,11,12 )  and i_principioactivo.Nbre like '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre ";
                }
            } else if (!this.xobjetollamador.equals("Autorizacion")) {
                if (this.xtipobusqueda == 0) {
                    sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, avg(i_suministroxbodega.Costo), i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN `h_tipoformula_suministro` ON (i_suministro.Id = h_tipoformula_suministro.`Id_Suministro`)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 AND h_tipoformula_suministro.Estado=1 AND h_tipoformula_suministro.`Id_TipoFormula`='" + this.xidtipof[this.JCBTipoFormula.getSelectedIndex()] + "'  and i_principioactivo.Nbre<>'-' and i_suministro.Nbre like '" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_suministro.Nbre, i_presentacionfarmaceutica.Nbre ";
                } else {
                    sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, avg(i_suministroxbodega.Costo), i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN `h_tipoformula_suministro` ON (i_suministro.Id = h_tipoformula_suministro.`Id_Suministro`)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 AND h_tipoformula_suministro.Estado=1 AND h_tipoformula_suministro.`Id_TipoFormula`='" + this.xidtipof[this.JCBTipoFormula.getSelectedIndex()] + "' and  i_principioactivo.Nbre<>'-' and i_suministro.Nbre like'%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro order by i_suministro.Nbre, i_presentacionfarmaceutica.Nbre ";
                }
            } else if (this.xtipobusqueda == 0) {
                sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad,i_suministro.ValorPLM, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`,IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 and i_suministro.EstaActivo=1 and i_suministroxbodega.idbodega=2 and i_suministro.IdTipoProducto in(1, 6, 7,8,10,11, 12)  and i_suministro.Nbre like '" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro  order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre";
            } else {
                sql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo, i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion , i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0,(SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad,i_suministro.ValorPLM, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) as VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`, IF(i_suministro.`Pos`=1,'POS','NO POS') AS Pos, i_suministro.`Pos` AS PosA, IF(`i_suministro`.`Ctc_Justificacion` IS NULL, '',`i_suministro`.`Ctc_Justificacion`) AS Ctc,  IF(`i_suministro`.`Ctc_EvidenciaC` IS NULL, '', `i_suministro`.`Ctc_EvidenciaC` ) AS Ctc1 , IF(`i_suministro`.`Ctc_Casuistica` IS NULL,'', `i_suministro`.`Ctc_Casuistica`) AS Ctf2  , IF(`i_suministro`.`Ctc_Precauciones` IS NULL, '', `i_suministro`.`Ctc_Precauciones`) AS Ctc3, IFNULL(`i_clasif_lasa`.`MAlerta`, '') MAlerta, i_clasif_lasa.`Nombre` CLasa, i_clasif_lasa.`Observacion` ObservacionLasa ,i_clasif_lasa.`color` Colorlasa, iv.Nbre as viaAdministracion FROM i_suministroxbodega INNER JOIN i_bodegas ON (i_suministroxbodega.IdBodega = i_bodegas.Id) INNER JOIN i_suministro ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)  INNER JOIN `i_clasif_lasa`  ON (`i_suministro`.`Id_Cla_Lasa` = `i_clasif_lasa`.`Id`) inner join i_viaadministracion iv on (iv.Id=i_suministro.IdViaAdministracion) WHERE (i_bodegas.MostrarInventario =1 and i_suministro.EstaActivo=1 and i_suministroxbodega.idbodega=2 and i_suministro.IdTipoProducto in(1, 6, 7,8,10,11, 12)  and i_suministro.Nbre like  '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro  order by i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre";
            }
            System.out.println(" Medicamentos   " + sql);
            ResultSet rss = this.xconsultasbd.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (rss.next()) {
                        rss.beforeFirst();
                        int x = 0;
                        this.xmetodo.mEstablecerTextEditor(this.JTDatosMedicamentos, 1);
                        this.xmetodo.mEstablecerTextEditor(this.JTDatosMedicamentos, 3);
                        while (rss.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(rss.getString(1), x, 0);
                            this.xmodelo.setValueAt(rss.getString(2), x, 1);
                            this.xmodelo.setValueAt(rss.getString(3), x, 2);
                            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                                this.xmodelo.setValueAt(rss.getString(4), x, 3);
                            } else {
                                this.xmodelo.setValueAt(rss.getString(4) + " " + rss.getString(5), x, 3);
                            }
                            this.xmodelo.setValueAt(rss.getString(7), x, 4);
                            this.xmodelo.setValueAt(Integer.valueOf(rss.getInt(8)), x, 5);
                            this.xmodelo.setValueAt(Long.valueOf(rss.getLong(9)), x, 6);
                            this.xmodelo.setValueAt(rss.getString(10), x, 7);
                            this.xmodelo.setValueAt(Long.valueOf(rss.getLong(11)), x, 8);
                            this.xmodelo.setValueAt(rss.getString(12), x, 9);
                            this.xmodelo.setValueAt(Boolean.valueOf(rss.getBoolean(13)), x, 10);
                            this.xmodelo.setValueAt(Long.valueOf(rss.getLong(14)), x, 11);
                            this.JTDatosMedicamentos.setDefaultRenderer(Object.class, new MiRender());
                            this.xmodelo.setValueAt(rss.getString("Pos"), x, 12);
                            this.xmodelo.setValueAt(Integer.valueOf(rss.getInt("PosA")), x, 13);
                            this.xmodelo.setValueAt(rss.getString("Ctc"), x, 15);
                            this.xmodelo.setValueAt(rss.getString("Ctc1"), x, 16);
                            this.xmodelo.setValueAt(rss.getString("Ctf2"), x, 17);
                            this.xmodelo.setValueAt(rss.getString("Ctc3"), x, 18);
                            this.xmodelo.setValueAt(rss.getString("MAlerta"), x, 19);
                            this.xmodelo.setValueAt(rss.getString("CLasa"), x, 20);
                            this.xmodelo.setValueAt(rss.getString("ObservacionLasa"), x, 21);
                            this.xmodelo.setValueAt(rss.getString("Colorlasa"), x, 22);
                            this.xmodelo.setValueAt(rss.getString("viaAdministracion"), x, 23);
                            this.xmodelo.setValueAt(false, x, 14);
                            x++;
                        }
                    }
                    if (rss != null) {
                        if (0 != 0) {
                            try {
                                rss.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rss.close();
                        }
                    }
                    this.xconsultasbd.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPOOrdenSuministroH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificarFVencimientoInvima() {
        if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 8).toString()).intValue() == 0) {
            JOptionPane.showInternalMessageDialog(this, "Medicamento con fecha: " + this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 9).toString() + " de invima vencido.\nFavor revisar", "VERIFICACIÓN DE VENCIMIENTO INVIMA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    private void mVerificarNovedadP() {
        String sql = "SELECT g_tiponovedad.Nbre, i_novedad_suministro.Soporte, i_novedad_suministro.Documento  FROM i_novedad_suministro INNER JOIN g_tiponovedad  ON (i_novedad_suministro.Id_TipoNovedad = g_tiponovedad.Id) WHERE (i_novedad_suministro.Estado =1 AND i_novedad_suministro.Id_Suministro ='" + this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2) + "') ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getBoolean(2)) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Producto con novedad registrada;\nTIPO : " + xrs.getString(1) + "\ndesea visualizarla?", "NOVEDADES", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    if (x == 0) {
                        this.xmetodo.mostrarPdf(xrs.getString(3));
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Producto con novedad registrada;\nTIPO : " + xrs.getString(1), "NOVEDADES", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOOrdenSuministroH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleMedicamentos() {
        xmodelodetallet = new DefaultTableModel(new Object[0], new String[]{"IdProducto", "Producto", "xfrecuencia", "duracion", "cantidad", "observaciones", "IdMesT", "dig", "Valor", "PrincipioActivo", "x1", "x2", "x3", "x4", "idIndex", "Código Grupo", "Nombre Grupo", "Código Servicio Rips", "Nombre Servicio Rips", "codViaAdministración", "viaAdministración"}) { // from class: Historia.JPOOrdenSuministroH.20
            Class[] types = {Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Long.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = JTDatosDetMedicamentos;
        JTable jTable2 = JTDatosDetMedicamentos;
        jTable.setAutoResizeMode(0);
        JTDatosDetMedicamentos.doLayout();
        JTDatosDetMedicamentos.setModel(xmodelodetallet);
        JTDatosDetMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(0).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(0).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(400);
        JTDatosDetMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(200);
        JTDatosDetMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(200);
        JTDatosDetMedicamentos.getColumnModel().getColumn(4).setPreferredWidth(100);
        JTDatosDetMedicamentos.getColumnModel().getColumn(5).setPreferredWidth(300);
        JTDatosDetMedicamentos.getColumnModel().getColumn(6).setPreferredWidth(80);
        JTDatosDetMedicamentos.getColumnModel().getColumn(7).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(7).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(7).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(8).setPreferredWidth(80);
        JTDatosDetMedicamentos.getColumnModel().getColumn(9).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(9).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(9).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(10).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(10).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(10).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(11).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(11).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(11).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(12).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(12).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(12).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(13).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(13).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(13).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(14).setPreferredWidth(100);
        JTDatosDetMedicamentos.getColumnModel().getColumn(15).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(15).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(15).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(16).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(16).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(16).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(17).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(17).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(17).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(18).setPreferredWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(18).setMinWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(18).setMaxWidth(0);
        JTDatosDetMedicamentos.getColumnModel().getColumn(19).setPreferredWidth(30);
        JTDatosDetMedicamentos.getColumnModel().getColumn(20).setPreferredWidth(30);
    }

    public void buscar() {
        try {
            if (this.xobjetollamador.equals("HistoriaV2")) {
                Component jIFConsultarSuministro = new JIFConsultarSuministro(this.xclase, "jpsuministroh1", this.JCBTipoFormula.getSelectedItem().toString());
                Principal.PanelPpal.add(jIFConsultarSuministro, JLayeredPane.DEFAULT_LAYER);
                jIFConsultarSuministro.setVisible(true);
                jIFConsultarSuministro.setSelected(true);
            } else {
                Component jIFConsultarSuministro2 = new JIFConsultarSuministro(this.xclase, "jpsuministroh", this.JCBTipoFormula.getSelectedItem().toString());
                Principal.PanelPpal.add(jIFConsultarSuministro2, JLayeredPane.DEFAULT_LAYER);
                jIFConsultarSuministro2.setVisible(true);
                jIFConsultarSuministro2.setSelected(true);
            }
        } catch (PropertyVetoException e) {
        }
    }

    private void mVerificarMedicamentoControl() {
        if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 11).toString()).intValue() == 7) {
            JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='#9932CC' size=4>  <b>MEDICAMENTO DE USO CONTROLADO;</p><font face='Arial' color='#9932CC' size=4>FAVOR DILIGENCIAR FORMATO RESPECTIVO.", "CONTROL ESPECIAL DE MEDICAMENTO", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    private void mConsultarALerta() {
        String xsql = "SELECT g_tipoalerta.Nbre, g_usuarioxtipoalerta.Detalle FROM g_usuarioxtipoalerta INNER JOIN g_tipoalerta  ON (g_usuarioxtipoalerta.Id_TipoAlerta = g_tipoalerta.Id) WHERE (g_usuarioxtipoalerta.Estado =1 AND g_tipoalerta.EsHC =1 AND g_usuarioxtipoalerta.Id_Usuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY g_tipoalerta.Nbre ASC ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Usuario con alertar;\nDesea Visualizarla", "ALERTA", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    String xmensaje = "";
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        xmensaje = xmensaje + "TIPO DE MENSAJE: " + xrs.getString(1) + "\nINFORMACIÓN:" + xrs.getString(2).toUpperCase() + "\n";
                    }
                    JOptionPane.showMessageDialog((Component) null, xmensaje, "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaClinica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void consultarCuestionarioSuministro() {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            List<ISuministroTipocuestionario> suministroTipocuestionarios = this.iSuministroTipocuestionarioService.listaCuestionarioPorSuministroEstado(this.suministro, true);
            if (!suministroTipocuestionarios.isEmpty()) {
                SoTipoCuestionario cuestionario = suministroTipocuestionarios.get(0).getIdTipoCuestionario();
                JD_CuestionarioFarmacovigilanciaDisparadores disparadores = new JD_CuestionarioFarmacovigilanciaDisparadores(null, true, cuestionario, "pantallaFormulacion");
                disparadores.setLocationRelativeTo(this);
                disparadores.setVisible(true);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPOOrdenSuministroH$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 7).toString();
            if (table.getValueAt(row, 11).toString().equals("7")) {
                cell.setBackground(new Color(153, 0, 153));
                cell.setForeground(Color.WHITE);
            } else {
                if (trabajador.equals("1") && !Boolean.valueOf(table.getValueAt(row, 10).toString()).booleanValue()) {
                    cell.setBackground(new Color(177, 251, 177));
                } else if (trabajador.equals("0") && Boolean.valueOf(table.getValueAt(row, 10).toString()).booleanValue()) {
                    cell.setBackground(Color.RED);
                } else if (trabajador.equals("0") && !Boolean.valueOf(table.getValueAt(row, 10).toString()).booleanValue()) {
                    cell.setBackground(Color.WHITE);
                }
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
