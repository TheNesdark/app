package Historia;

import Acceso.Principal;
import Utilidades.CargarCombosVarios;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.controller.historia.dto.Anexo2335Dto;
import com.genoma.plus.controller.historia.dto.Anexo3Dto;
import com.genoma.plus.controller.historia.dto.AnexoDatoUsuarioDto;
import com.genoma.plus.controller.historia.dto.AnexoInformacionIpsDto;
import com.genoma.plus.controller.historia.dto.ListaCodigoOtrosDto;
import com.genoma.plus.controller.historia.dto.ListaCumDetalleDto;
import com.genoma.plus.controller.historia.dto.ListaCupsDetalleDto;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedicoDetalle;
import com.genoma.plus.controller.sgc.JDConsentimientoInformado;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.jpa.entities.FOrdenesDTO;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import com.genoma.plus.jpa.entities.HItemordenesProcedSeguimientoEntity;
import com.genoma.plus.jpa.entities.HTipoSeguimientoItemEntity;
import com.genoma.plus.jpa.entities.LiquidacionEntity;
import com.genoma.plus.jpa.service.FOrdenesService;
import com.genoma.plus.jpa.service.HItemordenesProcedSeguimientoService;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPOOrdenProcedimientosH.class */
public class JPOOrdenProcedimientosH extends JPanel {
    private Object[] xdato;
    private clasesHistoriaCE xclase;
    private String[] xidfinpro;
    public DefaultTableModel xmodelodetallet;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloH;
    private int xtipo;
    public String xNPadre;
    private List<GServicioGrupoEntity> listGrupoEntitys;
    private List<GServicioRipsEntity> ListripsEntitys;
    private boolean verifiacionAutorizacion;
    private JButton JBCtc;
    private ButtonGroup JBGTipoB;
    private JButton JBTAdicionar;
    public JButton JBTAdicionarHC;
    private JComboBox JCBFinProcedimiento;
    public JComboBox JCBGrupoSevicio;
    public JComboBox JCBSevicioRips;
    private JCheckBox JCHComienza;
    private JCheckBox JCHContiene;
    public JDateChooser JDFecha;
    private JLabel JLBEstado;
    private JPanel JPIHistorico;
    private JPanel JPIProcedimientos;
    private JPanel JPProcedimientos;
    private JSpinner JSPCantidad;
    private JScrollPane JSPDatosDetProcedimiento;
    private JScrollPane JSPDatosProcedimiento;
    private JScrollPane JSPDetalleH;
    private JSpinner JSPINImpresiones;
    private JScrollPane JSPObservaciones;
    private JScrollPane JSPResumenHC;
    private JTextArea JTAObservaciones;
    private JTextArea JTAResumenHC;
    public JTable JTDatosDetProcedimiento;
    private JTable JTDatosProcedimiento;
    private JTable JTDetalleH;
    public JFormattedTextField JTFFHora;
    private JTextField JTFNombre;
    private JTextField JTFNordenProc;
    private JTabbedPane JTPMenu;
    private JButton jButton1;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xfila = 0;
    private int xlleno = 0;
    private int xtipobusqueda = 0;
    public String x1 = "";
    public String x2 = "";
    public String x3 = "";
    public String x4 = "";
    public String x5 = "";
    public String x6 = "";
    public String x7 = "";
    public String x8 = "";
    public String x9 = "";
    public String xFechaNac = "";
    private final ILiquidacionService liquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
    private final FOrdenesService ordenesService = (FOrdenesService) Principal.contexto.getBean(FOrdenesService.class);
    private final HItemordenesProcedSeguimientoService seguimientoService = (HItemordenesProcedSeguimientoService) Principal.contexto.getBean(HItemordenesProcedSeguimientoService.class);

    public JPOOrdenProcedimientosH(clasesHistoriaCE xclase, int xidserv, int xtipo, String xNombre) {
        this.xNPadre = "";
        initComponents();
        this.JPIProcedimientos.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES DE AYUDAS DIAGNÓSTICAS - " + xNombre.toUpperCase(), 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.xtipo = xtipo;
        this.xclase = xclase;
        this.xNPadre = xNombre;
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdServicio(Integer.valueOf(xidserv));
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v120, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v80, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoB = new ButtonGroup();
        this.JTPMenu = new JTabbedPane();
        this.JPIProcedimientos = new JPanel();
        this.JPProcedimientos = new JPanel();
        this.JBTAdicionar = new JButton();
        this.JSPObservaciones = new JScrollPane();
        this.JTAObservaciones = new JTextArea();
        this.JSPCantidad = new JSpinner();
        this.JSPDatosProcedimiento = new JScrollPane();
        this.JTDatosProcedimiento = new JTable();
        this.JTFNombre = new JTextField();
        this.JCBFinProcedimiento = new JComboBox();
        this.JCHContiene = new JCheckBox();
        this.JCHComienza = new JCheckBox();
        this.JSPResumenHC = new JScrollPane();
        this.JTAResumenHC = new JTextArea();
        this.JCBGrupoSevicio = new JComboBox();
        this.JCBSevicioRips = new JComboBox();
        this.JSPINImpresiones = new JSpinner();
        this.JLBEstado = new JLabel();
        this.JTFNordenProc = new JTextField();
        this.JSPDatosDetProcedimiento = new JScrollPane();
        this.JTDatosDetProcedimiento = new JTable();
        this.JBCtc = new JButton();
        this.JBTAdicionarHC = new JButton("<html><center><b><u>F</u>órmulas Vencidas</b></html>");
        this.JDFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JPIHistorico = new JPanel();
        this.jButton1 = new JButton();
        this.JSPDetalleH = new JScrollPane();
        this.JTDetalleH = new JTable();
        setBorder(BorderFactory.createEtchedBorder(Color.blue, (Color) null));
        setName("jpprocedimientosh");
        setPreferredSize(new Dimension(872, 713));
        this.JTPMenu.setForeground(Color.red);
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JPIProcedimientos.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES DE AYUDAS DIAGNÓSTICAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIProcedimientos.setName("jpprocedimientos");
        this.JPProcedimientos.setBorder(BorderFactory.createEtchedBorder());
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setForeground(Color.blue);
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenProcedimientosH.1
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenProcedimientosH.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JSPObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservaciones.setHorizontalScrollBarPolicy(31);
        this.JSPObservaciones.setVerticalScrollBarPolicy(21);
        this.JTAObservaciones.setColumns(1);
        this.JTAObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTAObservaciones.setLineWrap(true);
        this.JTAObservaciones.setRows(1);
        this.JTAObservaciones.setBorder((Border) null);
        this.JTAObservaciones.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenProcedimientosH.2
            public void keyPressed(KeyEvent evt) {
                JPOOrdenProcedimientosH.this.JTAObservacionesKeyPressed(evt);
            }
        });
        this.JSPObservaciones.setViewportView(this.JTAObservaciones);
        this.JSPCantidad.setFont(new Font("Arial", 1, 12));
        this.JSPCantidad.setModel(new SpinnerNumberModel(1, 1, 50, 1));
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCantidad.addChangeListener(new ChangeListener() { // from class: Historia.JPOOrdenProcedimientosH.3
            public void stateChanged(ChangeEvent evt) {
                JPOOrdenProcedimientosH.this.JSPCantidadStateChanged(evt);
            }
        });
        this.JTDatosProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JTDatosProcedimiento.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDatosProcedimiento.setRowHeight(25);
        this.JTDatosProcedimiento.setSelectionBackground(new Color(255, 255, 255));
        this.JTDatosProcedimiento.setSelectionForeground(Color.red);
        this.JTDatosProcedimiento.setSelectionMode(0);
        this.JTDatosProcedimiento.addFocusListener(new FocusAdapter() { // from class: Historia.JPOOrdenProcedimientosH.4
            public void focusLost(FocusEvent evt) {
                JPOOrdenProcedimientosH.this.JTDatosProcedimientoFocusLost(evt);
            }
        });
        this.JTDatosProcedimiento.addMouseListener(new MouseAdapter() { // from class: Historia.JPOOrdenProcedimientosH.5
            public void mouseClicked(MouseEvent evt) {
                JPOOrdenProcedimientosH.this.JTDatosProcedimientoMouseClicked(evt);
            }
        });
        this.JTDatosProcedimiento.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenProcedimientosH.6
            public void keyPressed(KeyEvent evt) {
                JPOOrdenProcedimientosH.this.JTDatosProcedimientoKeyPressed(evt);
            }
        });
        this.JSPDatosProcedimiento.setViewportView(this.JTDatosProcedimiento);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenProcedimientosH.7
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenProcedimientosH.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenProcedimientosH.8
            public void keyTyped(KeyEvent evt) {
                JPOOrdenProcedimientosH.this.JTFNombreKeyTyped(evt);
            }
        });
        this.JCBFinProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBFinProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fin Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipoB.add(this.JCHContiene);
        this.JCHContiene.setFont(new Font("Arial", 1, 12));
        this.JCHContiene.setForeground(new Color(0, 0, 255));
        this.JCHContiene.setSelected(true);
        this.JCHContiene.setText("Contiene");
        this.JCHContiene.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenProcedimientosH.9
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenProcedimientosH.this.JCHContieneActionPerformed(evt);
            }
        });
        this.JBGTipoB.add(this.JCHComienza);
        this.JCHComienza.setFont(new Font("Arial", 1, 12));
        this.JCHComienza.setForeground(new Color(0, 0, 255));
        this.JCHComienza.setText("Comienza");
        this.JCHComienza.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenProcedimientosH.10
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenProcedimientosH.this.JCHComienzaActionPerformed(evt);
            }
        });
        this.JSPResumenHC.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General o Justificación Anexo 3", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPResumenHC.setVerticalScrollBarPolicy(21);
        this.JTAResumenHC.setColumns(1);
        this.JTAResumenHC.setFont(new Font("Arial", 1, 12));
        this.JTAResumenHC.setLineWrap(true);
        this.JTAResumenHC.setRows(1);
        this.JTAResumenHC.setBorder((Border) null);
        this.JTAResumenHC.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenProcedimientosH.11
            public void keyPressed(KeyEvent evt) {
                JPOOrdenProcedimientosH.this.JTAResumenHCKeyPressed(evt);
            }
        });
        this.JSPResumenHC.setViewportView(this.JTAResumenHC);
        this.JCBGrupoSevicio.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoSevicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoSevicio.setName("grupoServicio");
        this.JCBGrupoSevicio.addItemListener(new ItemListener() { // from class: Historia.JPOOrdenProcedimientosH.12
            public void itemStateChanged(ItemEvent evt) {
                JPOOrdenProcedimientosH.this.JCBGrupoSevicioItemStateChanged(evt);
            }
        });
        this.JCBSevicioRips.setFont(new Font("Arial", 1, 12));
        this.JCBSevicioRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSevicioRips.setName("servicioRips");
        GroupLayout JPProcedimientosLayout = new GroupLayout(this.JPProcedimientos);
        this.JPProcedimientos.setLayout(JPProcedimientosLayout);
        JPProcedimientosLayout.setHorizontalGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientosLayout.createSequentialGroup().addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDatosProcedimiento, -2, 774, -2).addGroup(JPProcedimientosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 594, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPCantidad, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHComienza).addComponent(this.JCHContiene))).addGroup(JPProcedimientosLayout.createSequentialGroup().addComponent(this.JCBFinProcedimiento, -2, 166, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResumenHC, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservaciones, -2, 214, -2))).addContainerGap(-1, 32767)).addGroup(JPProcedimientosLayout.createSequentialGroup().addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientosLayout.createSequentialGroup().addComponent(this.JCBGrupoSevicio, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSevicioRips, -2, 489, -2)).addComponent(this.JBTAdicionar, -2, 735, -2)).addGap(0, 0, 32767)))));
        JPProcedimientosLayout.setVerticalGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPCantidad, -2, -1, -2).addComponent(this.JTFNombre, -1, -1, -2)).addGroup(JPProcedimientosLayout.createSequentialGroup().addComponent(this.JCHComienza).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHContiene))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDatosProcedimiento, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGrupoSevicio, -2, -1, -2).addComponent(this.JCBSevicioRips, -2, -1, -2)).addGap(6, 6, 6).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBFinProcedimiento, -2, 43, -2).addComponent(this.JSPResumenHC, -1, 61, 32767).addComponent(this.JSPObservaciones)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionar, -2, 34, -2).addContainerGap(21, 32767)));
        this.JSPINImpresiones.setFont(new Font("Arial", 1, 14));
        this.JSPINImpresiones.setModel(new SpinnerNumberModel(1, 1, 3, 1));
        this.JSPINImpresiones.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Impr.", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 0, 255)));
        this.JLBEstado.setBackground(new Color(255, 255, 255));
        this.JLBEstado.setFont(new Font("Arial", 1, 18));
        this.JLBEstado.setForeground(Color.red);
        this.JLBEstado.setHorizontalAlignment(0);
        this.JLBEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNordenProc.setFont(new Font("Arial", 1, 24));
        this.JTFNordenProc.setForeground(Color.red);
        this.JTFNordenProc.setHorizontalAlignment(0);
        this.JTFNordenProc.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDatosDetProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDatosDetProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JTDatosDetProcedimiento.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDatosDetProcedimiento.setRowHeight(25);
        this.JTDatosDetProcedimiento.setSelectionBackground(new Color(255, 255, 255));
        this.JTDatosDetProcedimiento.setSelectionForeground(new Color(255, 0, 0));
        this.JTDatosDetProcedimiento.setSelectionMode(0);
        this.JTDatosDetProcedimiento.addFocusListener(new FocusAdapter() { // from class: Historia.JPOOrdenProcedimientosH.13
            public void focusLost(FocusEvent evt) {
                JPOOrdenProcedimientosH.this.JTDatosDetProcedimientoFocusLost(evt);
            }
        });
        this.JTDatosDetProcedimiento.addMouseListener(new MouseAdapter() { // from class: Historia.JPOOrdenProcedimientosH.14
            public void mouseClicked(MouseEvent evt) {
                JPOOrdenProcedimientosH.this.JTDatosDetProcedimientoMouseClicked(evt);
            }
        });
        this.JTDatosDetProcedimiento.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenProcedimientosH.15
            public void keyPressed(KeyEvent evt) {
                JPOOrdenProcedimientosH.this.JTDatosDetProcedimientoKeyPressed(evt);
            }
        });
        this.JSPDatosDetProcedimiento.setViewportView(this.JTDatosDetProcedimiento);
        this.JBCtc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CTC.png")));
        this.JBCtc.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenProcedimientosH.16
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenProcedimientosH.this.JBCtcActionPerformed(evt);
            }
        });
        this.JBTAdicionarHC.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTAdicionarHC.setText("<html><P ALIGN=center>Grabar");
        this.JBTAdicionarHC.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenProcedimientosH.17
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenProcedimientosH.this.JBTAdicionarHCActionPerformed(evt);
            }
        });
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Tahoma", 1, 12));
        GroupLayout JPIProcedimientosLayout = new GroupLayout(this.JPIProcedimientos);
        this.JPIProcedimientos.setLayout(JPIProcedimientosLayout);
        JPIProcedimientosLayout.setHorizontalGroup(JPIProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcedimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPIProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPProcedimientos, -1, -1, 32767).addGroup(JPIProcedimientosLayout.createSequentialGroup().addGroup(JPIProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcedimientosLayout.createSequentialGroup().addComponent(this.JTFNordenProc, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFecha, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPINImpresiones, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBCtc, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarHC, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBEstado, -2, 116, -2)).addComponent(this.JSPDatosDetProcedimiento, -2, 802, -2)).addGap(0, 0, 32767))).addContainerGap()));
        JPIProcedimientosLayout.setVerticalGroup(JPIProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIProcedimientosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPProcedimientos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDatosDetProcedimiento, -1, 182, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBEstado, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(JPIProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNordenProc, -2, 59, -2).addComponent(this.JSPINImpresiones, -2, 54, -2).addComponent(this.JTFFHora, -2, 50, -2)).addComponent(this.JBCtc, GroupLayout.Alignment.TRAILING, -2, 52, -2).addComponent(this.JBTAdicionarHC, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addComponent(this.JDFecha, GroupLayout.Alignment.TRAILING, -2, 50, -2))));
        this.JTPMenu.addTab("SOLICITUD", this.JPIProcedimientos);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Autorizacion.png")));
        this.jButton1.setText("Traslado Agrupado");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JPOOrdenProcedimientosH.18
            public void actionPerformed(ActionEvent evt) {
                JPOOrdenProcedimientosH.this.jButton1ActionPerformed(evt);
            }
        });
        this.JSPDetalleH.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleH.setFont(new Font("Arial", 1, 12));
        this.JTDetalleH.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleH.setCursor(new Cursor(0));
        this.JTDetalleH.setRowHeight(25);
        this.JTDetalleH.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleH.setSelectionForeground(Color.red);
        this.JTDetalleH.addFocusListener(new FocusAdapter() { // from class: Historia.JPOOrdenProcedimientosH.19
            public void focusLost(FocusEvent evt) {
                JPOOrdenProcedimientosH.this.JTDetalleHFocusLost(evt);
            }
        });
        this.JTDetalleH.addMouseListener(new MouseAdapter() { // from class: Historia.JPOOrdenProcedimientosH.20
            public void mouseClicked(MouseEvent evt) {
                JPOOrdenProcedimientosH.this.JTDetalleHMouseClicked(evt);
            }
        });
        this.JTDetalleH.addKeyListener(new KeyAdapter() { // from class: Historia.JPOOrdenProcedimientosH.21
            public void keyPressed(KeyEvent evt) {
                JPOOrdenProcedimientosH.this.JTDetalleHKeyPressed(evt);
            }
        });
        this.JSPDetalleH.setViewportView(this.JTDetalleH);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -2, 804, -2).addComponent(this.JSPDetalleH, GroupLayout.Alignment.TRAILING, -2, 806, -2)).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleH, -2, 564, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -2, 50, -2).addContainerGap()));
        this.JTPMenu.addTab("HISTORICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPMenu, -1, -1, -2).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTPMenu, -1, -1, -2).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.verifiacionAutorizacion && this.JTAResumenHC.getText().length() <= 30) {
            JOptionPane.showInternalMessageDialog(this, "<html><p style='text-align:center; font-family:Arial; color:red; font-size:14px;'><b>Jusitificación debe terner mas de 30 caracteres.</b></p><p style='text-align:center; font-family:Arial; color:red; font-size:14px;'>Favor ampliar        .</p></html>", "VERIFICACIÓN", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
            return;
        }
        if (this.JCBFinProcedimiento.getSelectedIndex() != -1) {
            if (this.JCBGrupoSevicio.getSelectedIndex() != -1) {
                if (this.JCBSevicioRips.getSelectedIndex() != -1) {
                    if (Boolean.parseBoolean(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 10).toString())) {
                        JOptionPane.showInternalMessageDialog(this, "<html><pALIGN=center> <font face='Arial' color='red' size=4>  <b>Se debe realizar el consentimiento informado al procedimiento seleccionado/p></html>", "CONSENTIMIENTO INFORMADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        JDConsentimientoInformado consentimientoInformado = new JDConsentimientoInformado(null, true, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString(), this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 1).toString(), this, Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        consentimientoInformado.setLocationRelativeTo(this);
                        consentimientoInformado.setVisible(true);
                    }
                    if (!mVerificarDx()) {
                        JOptionPane.showInternalMessageDialog(this, "<html><p ALIGN=center> <font face='Arial' color='red' size=4>  <b>El procedimiento seleccionado para adicionar requiere diagnostico ;</p><font face='Arial' color='red' size=4>Esta orden no se imprimira.</html>", "VERIFICAR DATOS ADICIONALES DEL PROCEDIMIENTO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                    mAdicionarDatos();
                    mNuevoItems();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debes seleccionar un servicio rips", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBSevicioRips.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debes seleccionar una grupo de servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGrupoSevicio.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debes seleccionar una finalidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBFinProcedimiento.requestFocus();
    }

    private void JBTAdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAdicionarDatos();
            mNuevoItems();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTAObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCantidadStateChanged(ChangeEvent evt) {
        this.JSPCantidad.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosProcedimientoFocusLost(FocusEvent evt) {
        if (this.JTDatosProcedimiento.getSelectedRow() != -1) {
            mvalidadprocedimiento();
            mVerificarRDatosAdicionales();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosProcedimientoKeyPressed(KeyEvent evt) {
        if (this.JTDatosProcedimiento.getSelectedRow() != -1 && evt.getKeyCode() == 9) {
            this.JTDatosProcedimiento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosProcedimientoMouseClicked(MouseEvent evt) {
        if (this.JTDatosProcedimiento.getSelectedRow() != -1) {
            CargarCombosVarios cargarCombosVarios = new CargarCombosVarios();
            cargarCombosVarios.cargarComboTableFinalidadPorProcedimiento(this.JCBFinProcedimiento, Long.valueOf(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 12).toString()));
            cargarCombosVarios.cargarComboBoxServicioGrupoProcedimiento(this.JCBGrupoSevicio, this.JCBSevicioRips, Long.valueOf(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 12).toString()));
            validarAutorizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAResumenHCKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mLLenartabla();
        } else {
            mCrearTablaProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosDetProcedimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosDetProcedimientoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDatosDetProcedimiento.getRowCount() != 0 && this.JTDatosDetProcedimiento.getSelectedRow() != -1) {
            this.xmodelodetallet.removeRow(this.JTDatosDetProcedimiento.getSelectedRow());
            this.xfila--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContieneActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHComienzaActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCtcActionPerformed(ActionEvent evt) {
        mImprimir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosDetProcedimientoMouseClicked(MouseEvent evt) {
        if (Boolean.valueOf(this.xmodelodetallet.getValueAt(this.JTDatosDetProcedimiento.getSelectedRow(), 15).toString()).booleanValue() && evt.getClickCount() == 2) {
            JDConsentimientoInformado jd = new JDConsentimientoInformado(null, true, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), this.xmodelodetallet.getValueAt(this.JTDatosDetProcedimiento.getSelectedRow(), 0).toString(), this, Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
            if (Long.valueOf(this.xmodelodetallet.getValueAt(this.JTDatosDetProcedimiento.getSelectedRow(), 16).toString()).longValue() != 0) {
                jd.JBT_Grabar.setEnabled(false);
                jd.JBT_NUevo.setEnabled(false);
            }
            jd.setLocationRelativeTo(this);
            jd.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarHCActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            grabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalleH.getRowCount() > 0) {
            String Ordenes = "";
            for (int i = 0; i < this.JTDetalleH.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodeloH.getValueAt(i, 4).toString()).booleanValue()) {
                    Ordenes = Ordenes + this.xmodeloH.getValueAt(i, 0).toString() + ",";
                }
            }
            if (!Ordenes.isEmpty()) {
                mBuscarProcedimiento(Ordenes.substring(0, Ordenes.length() - 1), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHMouseClicked(MouseEvent evt) {
        if (this.JTDetalleH.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            Object[] botones = {"Imprimir", "Cargar", "Transladar Items", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea realizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            switch (n) {
                case 0:
                    this.JTFNordenProc.setText(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString());
                    imprimir();
                    break;
                case 1:
                    mBuscarProcedimiento(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString(), true);
                    break;
                case 2:
                    mBuscarProcedimiento(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString(), false);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoSevicioItemStateChanged(ItemEvent evt) {
        if (this.xlleno == 1) {
            this.JCBSevicioRips.removeAllItems();
            this.ListripsEntitys = new ArrayList();
            LlenarCombosGenericos<GServicioRipsEntity> combosGenericos = new LlenarCombosGenericos<>();
            this.ListripsEntitys = combosGenericos.getListComboLlenoParametro(this.JCBSevicioRips.getName(), this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()));
            this.ListripsEntitys.forEach(e -> {
                this.JCBSevicioRips.addItem(e.getNombre());
            });
            this.JCBSevicioRips.addPopupMenuListener(new CustomPopupMenuListener(true, false));
            if (!this.listGrupoEntitys.isEmpty()) {
            }
        }
    }

    private void validarAutorizacion() {
        this.verifiacionAutorizacion = false;
        if (Boolean.parseBoolean(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 13).toString()) && this.xtipo != 1) {
            JOptionPane.showInternalMessageDialog(this, "<html><p style='text-align:center; font-family:Arial; color:red; font-size:14px;'><b>Procedimiento solicitado necesita justificación para la gestión de la autorización.</b></p><p style='text-align:center; font-family:Arial; color:red; font-size:14px;'>Favor diligenciarla.</p></html>", "VERIFICACIÓN", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
            this.verifiacionAutorizacion = true;
            this.JTAResumenHC.requestFocus();
        }
    }

    private void grabarSeguimiento(Long idItems) {
        HTipoSeguimientoItemEntity itemEntity = new HTipoSeguimientoItemEntity();
        itemEntity.setId(Short.valueOf("1"));
        HItemordenesProcedSeguimientoEntity seguimientos = new HItemordenesProcedSeguimientoEntity();
        seguimientos.setTipoSeguimientoItem(itemEntity);
        seguimientos.setIdItemsProcedimiento(idItems);
        seguimientos.setFechaHora(this.xmetodo.getFechaActualLocalTime());
        seguimientos.setDescripcion(this.JTAResumenHC.getText());
        seguimientos.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
        seguimientos.setEstado(true);
        seguimientos.setFecha(this.xmetodo.getFechaActualLocalTime());
        this.seguimientoService.Grabar(seguimientos);
    }

    private void mAdicionarDatos() {
        if (!mBuscarProced()) {
            if (this.JTDatosProcedimiento.getSelectedRow() != -1) {
                if (((Integer) this.JSPCantidad.getValue()).intValue() >= 1) {
                    if (Boolean.parseBoolean(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 8).toString())) {
                        JDNoPOS xNoPos = new JDNoPOS(null, true, "xProcedimientos", "", "", "", "");
                        xNoPos.setVisible(true);
                    }
                    if (Integer.parseInt(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 9).toString()) == 1) {
                        String sql = "SELECT\n    `g_procedimiento`.`Id`\n    , `g_procedimiento`.`Nbre`\n    , `f_tipofinprocedimiento`.`Nbre`\n    , 1\n    , '' AS `Observacion`\n    , `f_tipofinprocedimiento`.`Id`,g_procedimiento.Paquete \n    , IF(g_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL,FALSE,TRUE) GeneraConsentimiento  FROM\n    `g_procedimxpaquete`\n    INNER JOIN `g_procedimiento` \n        ON (`g_procedimxpaquete`.`Id_Procedim` = `g_procedimiento`.`Id`)\n    LEFT JOIN g_procedimientoxconsentimiento \n\t   ON (g_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`)    INNER JOIN `f_tipofinprocedimiento` \n        ON (`g_procedimiento`.`Id_TipoFinProced` = `f_tipofinprocedimiento`.`Id`)\nWHERE (`g_procedimxpaquete`.`Id_Paquete` ='" + this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 1).toString() + "'\n    AND `g_procedimxpaquete`.`Estado` =1)\nGROUP BY `g_procedimiento`.`Id` \nORDER BY `g_procedimxpaquete`.`Orden` ASC";
                        ResultSet rs = this.xconsultasbd.traerRs(sql);
                        try {
                            if (rs.next()) {
                                rs.beforeFirst();
                                this.xmetodo.mEstablecerTextEditor(this.JTDatosDetProcedimiento, 1);
                                this.xmetodo.mEstablecerTextEditor(this.JTDatosDetProcedimiento, 2);
                                this.xmetodo.mEstablecerTextEditor(this.JTDatosDetProcedimiento, 4);
                                this.xmetodo.mEstablecerTextEditor(this.JTDatosDetProcedimiento, 5);
                                while (rs.next()) {
                                    if (!rs.getBoolean("Paquete")) {
                                        this.xmodelodetallet.addRow(this.xdato);
                                        this.xmodelodetallet.setValueAt(Long.valueOf(rs.getLong(1)), this.xfila, 0);
                                        this.xmodelodetallet.setValueAt(rs.getString(2), this.xfila, 1);
                                        this.xmodelodetallet.setValueAt(this.JCBFinProcedimiento.getSelectedItem(), this.xfila, 2);
                                        this.xmodelodetallet.setValueAt(Integer.valueOf(rs.getInt(4)), this.xfila, 3);
                                        this.xmodelodetallet.setValueAt(rs.getString(5), this.xfila, 4);
                                        this.xmodelodetallet.setValueAt(this.xidfinpro[this.JCBFinProcedimiento.getSelectedIndex()], this.xfila, 5);
                                        this.xmodelodetallet.setValueAt(this.x1, this.xfila, 6);
                                        this.xmodelodetallet.setValueAt(this.x2, this.xfila, 7);
                                        this.xmodelodetallet.setValueAt(this.x3, this.xfila, 8);
                                        this.xmodelodetallet.setValueAt(this.x4, this.xfila, 9);
                                        this.xmodelodetallet.setValueAt(this.x5, this.xfila, 10);
                                        this.xmodelodetallet.setValueAt(this.x6, this.xfila, 11);
                                        this.xmodelodetallet.setValueAt(this.x7, this.xfila, 12);
                                        this.xmodelodetallet.setValueAt(this.x8, this.xfila, 13);
                                        this.xmodelodetallet.setValueAt(this.x9, this.xfila, 14);
                                        this.xmodelodetallet.setValueAt(Boolean.valueOf(rs.getBoolean(7)), this.xfila, 15);
                                        this.xmodelodetallet.setValueAt(0, this.xfila, 16);
                                        this.xmodelodetallet.setValueAt(false, this.xfila, 17);
                                        this.xmodelodetallet.setValueAt(0, this.xfila, 18);
                                        this.xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.xfila, 19);
                                        this.xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.xfila, 20);
                                        this.xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.xfila, 21);
                                        this.xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.xfila, 22);
                                        this.xmodelodetallet.setValueAt(Long.valueOf(rs.getLong(1)), this.xfila, 23);
                                        this.xmodelodetallet.setValueAt(0, this.xfila, 24);
                                        this.xfila++;
                                    }
                                }
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        }
                    } else {
                        this.xmodelodetallet.addRow(this.xdato);
                        this.xmodelodetallet.setValueAt(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 1), this.xfila, 0);
                        this.xmodelodetallet.setValueAt(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 3), this.xfila, 1);
                        this.xmodelodetallet.setValueAt(this.JCBFinProcedimiento.getSelectedItem(), this.xfila, 2);
                        this.xmodelodetallet.setValueAt(this.JSPCantidad.getValue(), this.xfila, 3);
                        this.xmodelodetallet.setValueAt(this.JTAObservaciones.getText(), this.xfila, 4);
                        this.xmodelodetallet.setValueAt(this.xidfinpro[this.JCBFinProcedimiento.getSelectedIndex()], this.xfila, 5);
                        this.xmodelodetallet.setValueAt(this.x1, this.xfila, 6);
                        this.xmodelodetallet.setValueAt(this.x2, this.xfila, 7);
                        this.xmodelodetallet.setValueAt(this.x3, this.xfila, 8);
                        this.xmodelodetallet.setValueAt(this.x4, this.xfila, 9);
                        this.xmodelodetallet.setValueAt(this.x5, this.xfila, 10);
                        this.xmodelodetallet.setValueAt(this.x6, this.xfila, 11);
                        this.xmodelodetallet.setValueAt(this.x7, this.xfila, 12);
                        this.xmodelodetallet.setValueAt(this.x8, this.xfila, 13);
                        this.xmodelodetallet.setValueAt(this.x9, this.xfila, 14);
                        this.xmodelodetallet.setValueAt(Boolean.valueOf(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 10).toString()), this.xfila, 15);
                        this.xmodelodetallet.setValueAt(0, this.xfila, 16);
                        this.xmodelodetallet.setValueAt(false, this.xfila, 17);
                        this.xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.xfila, 19);
                        this.xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.xfila, 20);
                        this.xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.xfila, 21);
                        this.xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.xfila, 22);
                        this.xmodelodetallet.setValueAt(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 12), this.xfila, 23);
                        this.xmodelodetallet.setValueAt(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 13), this.xfila, 24);
                        this.xfila++;
                        String sql2 = "SELECT h_procedimientoxprelacionado.Id_ProcedimientoR, g_procedimiento.Nbre, f_tipofinprocedimiento.Nbre, 1 AS Cantidad, '' AS observacion, f_tipofinprocedimiento.Id, IF(g_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL,FALSE,TRUE) GeneraConsentimiento FROM h_procedimientoxprelacionado INNER JOIN g_procedimiento  ON (h_procedimientoxprelacionado.Id_ProcedimientoR = g_procedimiento.Id) INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) LEFT JOIN g_procedimientoxconsentimiento ON (g_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`) WHERE (g_procedimiento.`Paquete`<>1 and  h_procedimientoxprelacionado.Id_Procedimiento ='" + this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 1).toString() + "' AND h_procedimientoxprelacionado.Estado=1) GROUP BY h_procedimientoxprelacionado.Id_ProcedimientoR ";
                        ResultSet rs2 = this.xconsultasbd.traerRs(sql2);
                        try {
                            if (rs2.next()) {
                                rs2.beforeFirst();
                                while (rs2.next()) {
                                    this.xmodelodetallet.addRow(this.xdato);
                                    this.xmodelodetallet.setValueAt(Integer.valueOf(rs2.getInt(1)), this.xfila, 0);
                                    this.xmodelodetallet.setValueAt(rs2.getString(2), this.xfila, 1);
                                    this.xmodelodetallet.setValueAt(this.JCBFinProcedimiento.getSelectedItem(), this.xfila, 2);
                                    this.xmodelodetallet.setValueAt(Integer.valueOf(rs2.getInt(4)), this.xfila, 3);
                                    this.xmodelodetallet.setValueAt(rs2.getString(5), this.xfila, 4);
                                    this.xmodelodetallet.setValueAt(this.xidfinpro[this.JCBFinProcedimiento.getSelectedIndex()], this.xfila, 5);
                                    this.xmodelodetallet.setValueAt(this.x1, this.xfila, 6);
                                    this.xmodelodetallet.setValueAt(this.x2, this.xfila, 7);
                                    this.xmodelodetallet.setValueAt(this.x3, this.xfila, 8);
                                    this.xmodelodetallet.setValueAt(this.x4, this.xfila, 9);
                                    this.xmodelodetallet.setValueAt(this.x5, this.xfila, 10);
                                    this.xmodelodetallet.setValueAt(this.x6, this.xfila, 11);
                                    this.xmodelodetallet.setValueAt(this.x7, this.xfila, 12);
                                    this.xmodelodetallet.setValueAt(this.x8, this.xfila, 13);
                                    this.xmodelodetallet.setValueAt(this.x9, this.xfila, 14);
                                    this.xmodelodetallet.setValueAt(Boolean.valueOf(rs2.getBoolean(7)), this.xfila, 15);
                                    this.xmodelodetallet.setValueAt(0, this.xfila, 16);
                                    this.xmodelodetallet.setValueAt(false, this.xfila, 17);
                                    this.xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.xfila, 19);
                                    this.xmodelodetallet.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.xfila, 20);
                                    this.xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.xfila, 21);
                                    this.xmodelodetallet.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.xfila, 22);
                                    this.xmodelodetallet.setValueAt(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 12), this.xfila, 23);
                                    this.xmodelodetallet.setValueAt(this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 13), this.xfila, 24);
                                    this.xfila++;
                                }
                            }
                        } catch (SQLException ex2) {
                            Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                        }
                    }
                    mCrearTablaProcedimiento();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo cantidad   \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JSPCantidad.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "\t\t\tDebe seleccionar   \n un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTDatosProcedimiento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Procedimiento ya registrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private boolean mBuscarProced() {
        boolean xrd = false;
        if (this.JTDatosDetProcedimiento.getRowCount() != 0) {
            for (int i = 0; i < this.JTDatosDetProcedimiento.getRowCount(); i++) {
                if (this.xmodelo.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 1).toString().equals(this.xmodelodetallet.getValueAt(i, 0))) {
                    xrd = true;
                }
            }
        }
        return xrd;
    }

    private void mNuevoItems() {
        this.xlleno = 0;
        this.JTFNombre.setText((String) null);
        this.JSPCantidad.setValue(1);
        this.JTAObservaciones.setText((String) null);
        this.JLBEstado.setText((String) null);
        this.JTFNombre.requestFocus();
        this.x1 = "";
        this.x2 = "";
        this.x3 = "";
        this.x4 = "";
        this.x5 = "";
        this.x6 = "";
        this.x7 = "";
        this.x8 = "";
        this.x9 = "";
        this.JCBSevicioRips.setSelectedIndex(-1);
        this.JCBGrupoSevicio.setSelectedIndex(-1);
        this.xlleno = 1;
    }

    public void nuevo() {
        this.xlleno = 0;
        this.JCBSevicioRips.removeAllItems();
        this.xidfinpro = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM f_tipofinprocedimiento ORDER BY Nbre ASC", this.xidfinpro, this.JCBFinProcedimiento);
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S") && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc().intValue() == 86) {
            this.JCBFinProcedimiento.setSelectedItem("Detección de alteraciones del embarazo");
        } else {
            this.JCBFinProcedimiento.setSelectedItem("No aplica");
        }
        this.xconsultasbd.cerrarConexionBd();
        this.JTAResumenHC.setText(clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta());
        this.JBCtc.setVisible(true);
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.JSPINImpresiones.setVisible(false);
        } else {
            this.JSPINImpresiones.setVisible(true);
        }
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.JBTAdicionarHC.setVisible(true);
        } else {
            this.JBTAdicionarHC.setVisible(false);
        }
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setText(this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()));
        this.JTFNombre.setText((String) null);
        this.xfila = 0;
        this.JSPCantidad.setValue(1);
        this.JTAObservaciones.setText((String) null);
        this.JTFNordenProc.setText("");
        this.JLBEstado.setText((String) null);
        this.JTFNombre.requestFocus();
        mCargarDatosTablaHistorico();
        mCrearTablaDetalleProc();
        mCrearTablaProcedimiento();
        this.JCBGrupoSevicio.removeAllItems();
        LlenarCombosGenericos<GServicioGrupoEntity> combosGenericos = new LlenarCombosGenericos<>();
        this.listGrupoEntitys = combosGenericos.getListComboLleno(this.JCBGrupoSevicio.getName());
        this.listGrupoEntitys.forEach(e -> {
            this.JCBGrupoSevicio.addItem(e.getNombre());
        });
        if (!this.listGrupoEntitys.isEmpty()) {
            this.JCBGrupoSevicio.setSelectedIndex(-1);
            this.JCBGrupoSevicio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
        this.xlleno = 1;
    }

    private void mGrabarP() {
        int esPrioritario;
        String sql;
        int eslectura = 0;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdServicio().intValue() == 3) {
            int xl = JOptionPane.showInternalConfirmDialog(this, "Esta orden requiere lectura?", "CONFIRMAR", 0);
            if (xl == 0) {
                eslectura = 1;
            } else {
                eslectura = 0;
            }
        }
        OrdenamientoMedico ordenamientoMedico = OrdenamientoMedico.builder().cerrada(false).descripcion("ORDEN DE " + this.xNPadre.toUpperCase()).especialidad(Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad()).profesional(Principal.usuarioSistemaDTO.getNombreUsuario()).estado(true).fechaOrden(this.xmetodo.getFechaActualLocalTime()).idServicio(Integer.valueOf(this.xtipo)).idAtencion(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())).build();
        List<OrdenamientoMedicoDetalle> listDetalles = new ArrayList<>();
        String sql2 = "Insert into h_ordenes (Id_Atencion, Id_TipoA,Id_TipoServicio, IdTipoFormula, Id_Profesional, Id_Especialidad, FechaOrden, HoraOrden, NoFormInicio, NoFormuFin, NotasMedPrepago, IdMunicipio, EstaEntregada, Estado, NotaHc, Lectura, Fecha, UsuarioS) Values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xtipo + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdServicio() + "','0','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.JTFFHora.getText() + "','0','0','','23466','1','0','" + this.JTAResumenHC.getText() + "','" + eslectura + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String id = this.xconsultasbd.ejecutarSQLId(sql2);
        ordenamientoMedico.setIdOrden(Long.valueOf(id));
        String xconc = "";
        for (int i = 0; i < this.JTDatosDetProcedimiento.getRowCount(); i++) {
            if (!this.xmodelodetallet.getValueAt(i, 6).toString().equals("") || !this.xmodelodetallet.getValueAt(i, 7).toString().equals("") || !this.xmodelodetallet.getValueAt(i, 8).toString().equals("") || !this.xmodelodetallet.getValueAt(i, 9).toString().equals("") || !this.xmodelodetallet.getValueAt(i, 10).toString().equals("") || !this.xmodelodetallet.getValueAt(i, 11).toString().equals("") || !this.xmodelodetallet.getValueAt(i, 12).toString().equals("") || !this.xmodelodetallet.getValueAt(i, 13).toString().equals("") || !this.xmodelodetallet.getValueAt(i, 14).toString().equals("")) {
                String sql22 = "INSERT INTO  `h_concecutivo_ctc` ( `FechaR`, `IdOrden`, `UsuarioS`) VALUES ('" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "', '" + id + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                xconc = this.xconsultasbd.ejecutarSQLId(sql22);
                this.xconsultasbd.cerrarConexionBd();
            }
        }
        for (int i2 = 0; i2 < this.JTDatosDetProcedimiento.getRowCount(); i2++) {
            if (Boolean.parseBoolean(this.xmodelodetallet.getValueAt(i2, 17).toString())) {
                esPrioritario = 1;
            } else {
                esPrioritario = 0;
            }
            if (!this.xmodelodetallet.getValueAt(i2, 6).toString().equals("") || !this.xmodelodetallet.getValueAt(i2, 7).toString().equals("") || !this.xmodelodetallet.getValueAt(i2, 8).toString().equals("") || !this.xmodelodetallet.getValueAt(i2, 9).toString().equals("") || !this.xmodelodetallet.getValueAt(i2, 10).toString().equals("") || !this.xmodelodetallet.getValueAt(i2, 11).toString().equals("") || !this.xmodelodetallet.getValueAt(i2, 12).toString().equals("") || !this.xmodelodetallet.getValueAt(i2, 13).toString().equals("") || !this.xmodelodetallet.getValueAt(i2, 14).toString().equals("")) {
                sql = "insert into h_itemordenesproced(Id_HOrdenes, Id_Procedimiento, IdtipofinProc, Cantidad, Descripcion, Fecha, UsuarioS, x1,x2,x3,x4,x5,x6,x7,x8,x9,IdConcecutivo,IdConsentimiento, esPrioritario, idModalidadAtencion,idServicioRips)  values('" + id + "','" + this.xmodelodetallet.getValueAt(i2, 23) + "','" + this.xmodelodetallet.getValueAt(i2, 5) + "','" + this.xmodelodetallet.getValueAt(i2, 3) + "','" + this.xmodelodetallet.getValueAt(i2, 4) + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmodelodetallet.getValueAt(i2, 6) + "','" + this.xmodelodetallet.getValueAt(i2, 7) + "','" + this.xmodelodetallet.getValueAt(i2, 8) + "','" + this.xmodelodetallet.getValueAt(i2, 9) + "','" + this.xmodelodetallet.getValueAt(i2, 10) + "','" + this.xmodelodetallet.getValueAt(i2, 11) + "','" + this.xmodelodetallet.getValueAt(i2, 12) + "','" + this.xmodelodetallet.getValueAt(i2, 13) + "','" + this.xmodelodetallet.getValueAt(i2, 14) + "','" + xconc + "','" + this.xmodelodetallet.getValueAt(i2, 16) + "','" + esPrioritario + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdModalidad() + "','" + this.xmodelodetallet.getValueAt(i2, 21) + "')";
            } else {
                sql = "insert into h_itemordenesproced(Id_HOrdenes, Id_Procedimiento, IdtipofinProc, Cantidad, Descripcion, Fecha, UsuarioS, x1,x2,x3,x4,x5,x6,x7,x8,x9,IdConsentimiento, esPrioritario, idModalidadAtencion,idServicioRips)  values('" + id + "','" + this.xmodelodetallet.getValueAt(i2, 23) + "','" + this.xmodelodetallet.getValueAt(i2, 5) + "','" + this.xmodelodetallet.getValueAt(i2, 3) + "','" + this.xmodelodetallet.getValueAt(i2, 4) + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmodelodetallet.getValueAt(i2, 6) + "','" + this.xmodelodetallet.getValueAt(i2, 7) + "','" + this.xmodelodetallet.getValueAt(i2, 8) + "','" + this.xmodelodetallet.getValueAt(i2, 9) + "','" + this.xmodelodetallet.getValueAt(i2, 10) + "','" + this.xmodelodetallet.getValueAt(i2, 11) + "','" + this.xmodelodetallet.getValueAt(i2, 12) + "','" + this.xmodelodetallet.getValueAt(i2, 13) + "','" + this.xmodelodetallet.getValueAt(i2, 14) + "','" + this.xmodelodetallet.getValueAt(i2, 16) + "','" + esPrioritario + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdModalidad() + "','" + this.xmodelodetallet.getValueAt(i2, 21) + "')";
            }
            String idItems = this.xconsultasbd.ejecutarSQLId(sql);
            OrdenamientoMedicoDetalle detalle = OrdenamientoMedicoDetalle.builder().codigo(this.xmodelodetallet.getValueAt(i2, 0).toString()).cantidad(this.xmodelodetallet.getValueAt(i2, 3).toString()).ejecutado(false).nombre(this.xmodelodetallet.getValueAt(i2, 1).toString()).observacion(this.xmodelodetallet.getValueAt(i2, 4).toString()).autorizacion(Boolean.valueOf(Boolean.parseBoolean(this.xmodelodetallet.getValueAt(i2, 24).toString()))).idItemsDetalle(Long.valueOf(idItems)).build();
            listDetalles.add(detalle);
            if (this.xtipo != 1 && Boolean.parseBoolean(this.xmodelodetallet.getValueAt(i2, 24).toString())) {
                grabarSeguimiento(Long.valueOf(idItems));
            }
        }
        if (this.xtipo != 1) {
            ordenamientoMedico.setDetalleOrden(listDetalles);
            this.xmetodo.getGrabarOrdenamientoMedico(ordenamientoMedico);
        }
        this.xconsultasbd.cerrarConexionBd();
        this.JLBEstado.setText("ACTIVA");
        this.JTFNordenProc.setText(id);
    }

    public void grabar() {
        if (this.JTFNordenProc.getText() != null && this.JTFNordenProc.getText().isEmpty()) {
            if (this.JTDatosDetProcedimiento.getRowCount() != 0) {
                if (this.xtipo == 1) {
                    mGrabarP();
                    grabarAnexo1NUevo();
                    imprimir();
                } else if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCargo().longValue() == 0) {
                    mGrabarP();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Ingreso con liquidación de servicios cerrada, no se podrán registrar más cargos;</p><font face='Arial' color='red' size=4>Informar al departamento de facturación", "VERIFICACIÓN DE LIQUIDACIÓN", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                }
                mCargarDatosTablaHistorico();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe ningun procedimiento \n registrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Orden ya grabada ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void grabarAnexo1NUevo() {
        Anexo2335Dto anexo2335Dto = new Anexo2335Dto();
        anexo2335Dto.setIngresoId(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso());
        anexo2335Dto.setFechaRegistro(this.xmetodo.formatoAMD1.format(this.JDFecha.getDate()));
        anexo2335Dto.setTipoAnexo(3);
        anexo2335Dto.setEstado(true);
        anexo2335Dto.setProfesionalId(String.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema()));
        anexo2335Dto.setEspecialidadId(String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()));
        anexo2335Dto.setIdUsuarioS(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        AnexoInformacionIpsDto anexoInformacionIpsDto = new AnexoInformacionIpsDto();
        anexoInformacionIpsDto.setCodigoEntidadPagadora("");
        anexoInformacionIpsDto.setCodigoPrestador(Principal.informacionIps.getCodigoOrganismo());
        anexoInformacionIpsDto.setNumeroAutorizacion("");
        anexoInformacionIpsDto.setNumeroIdentificacionIps(Principal.informacionIps.getIdentificacion());
        anexo2335Dto.setAnexoInformacionIps(anexoInformacionIpsDto);
        new Anexo3Dto();
        List<ListaCupsDetalleDto> cupsDetalle = new ArrayList();
        List<ListaCumDetalleDto> cumDetalle = new ArrayList<>();
        List<ListaCodigoOtrosDto> otroCodigoDetalle = new ArrayList();
        new AnexoDatoUsuarioDto();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ResultSet xrs1 = this.xconsultasbd.traerRs("with maestra as (\nselect \nfe.CRips codigoEntidadPagadora, \ngp2.Apellido1 primerApellido, \ngp2.Apellido2 segundoApellido, \ngp2.Nombre1 primerNombre,\ngp2.Nombre2 segundoNombre,\ngp2.Id_TipoIdentificacion tipoDocumento,\ngp2.NoDocumento numeroDocumento,\ngp2.FechaNac fechaNacimiento,\ngp2.Direccion direccion,\ngp2.Telefono telefono,\ngp2.Id_Municipio municipio,\ngp2.Correo correo,\ngc.codigo causaAtencion,\nha.Codigo_Dxp diagnostico,\nha.Codigo_DxR1 diagnosticoRelacionado1,\nha.Codigo_DxR2 diagnosticoRelacionado2,\nha.Codigo_DxR3 diagnosticoRelacionado3,\nif(hi.esPrioritario=0, '02', '01') prioridadAtencion ,\nif(hi.esPrioritario=1, '02', '03') tipoAtencionSolicitada,\nggs.codigo grupoServicios,\ngma.codigo modalidadAtencion,\ngp.C_Homologado codigoCups,\nhi.Cantidad cantidadRequerida,\nft2.codigo finalidadTecnologia,\nif(ft.codigoResolucion1036 is null, 0, 1) clasificacionDetalle,\nCASE \n    WHEN gp2.Correo REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$' THEN 'Válido'\n        ELSE 'No válido'\n    END AS estado_correo\n, ho.Id \nfrom h_ordenes ho \ninner join h_itemordenesproced hi on (ho.Id=hi.Id_HOrdenes)\ninner join g_procedimiento gp on (gp.Id=hi.Id_Procedimiento)\ninner join h_atencion ha on (ha.Id=ho.Id_Atencion)\ninner join ingreso i on (i.Id=ha.Id_Ingreso)\ninner join g_causaexterna gc on (gc.Id=i.Id_CausaExterna)\ninner join f_empresacontxconvenio fe on (fe.Id=i.Id_EmpresaContxConv)\ninner join g_persona gp2 on (gp2.Id=i.Id_Usuario)\ninner join g_usuario gu on (gu.Id_persona=gp2.Id)\ninner join g_modalidad_atencion gma on (gma.id=hi.idModalidadAtencion)\ninner join g_servicios_rips gsr on (gsr.id=hi.idServicioRips)\ninner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio)\ninner join f_tipoconceptoagrup ft on (gp.Id_TipoConceptoAgrup=ft.Id)\ninner join f_tipofinprocedimiento ft2 on (ft2.Id=hi.IdtipofinProc)\nwhere ho.Id =6\n), \ndetalleCups as (\n   SELECT \n        JSON_ARRAYAGG(\n            JSON_OBJECT(\n                'codigoCups', m.codigoCups,\n                'cantidadRequerida', m.cantidadRequerida,\n                'finalidadTecnologia', m.finalidadTecnologia\n            )\n        ) AS detalleCups\n    FROM maestra m \n    WHERE m.clasificacionDetalle = 0\n \n)\n, \notroCodigoDetalle as (\n   SELECT \n         JSON_ARRAYAGG(\n            JSON_OBJECT(\n                'codigoCups', m.codigoCups,\n                'cantidadRequerida', m.cantidadRequerida,\n                'finalidadTecnologia', m.finalidadTecnologia\n            )\n        ) AS otroCodigoDetalle\n    FROM maestra m \n    WHERE m.clasificacionDetalle = 1\n \n)\nselect   m.codigoEntidadPagadora, \n\n JSON_OBJECT(\n            'primerApellido', m.primerApellido,\n            'segundoApellido', m.segundoApellido,\n            'primerNombre', m.primerNombre,\n            'segundoNombre', m.segundoNombre,\n            'tipoDocumento', m.tipoDocumento,\n            'numeroDocumento', m.numeroDocumento,\n            'fechaNacimiento', m.fechaNacimiento,\n            'direccion', m.direccion,\n            'telefono', m.telefono,\n            'municipio', m.municipio,\n            'correo', if(estado_correo='Válido', m.correo, '') \n            \n \n ) as anexoDatoUsuario,\n    JSON_OBJECT(\n            'causaAtencion', m.causaAtencion,\n            'diagnostico', m.diagnostico,\n            'diagnosticoRelacionado1', m.diagnosticoRelacionado1,\n            'diagnosticoRelacionado2', m.diagnosticoRelacionado2,\n            'diagnosticoRelacionado3', m.diagnosticoRelacionado3,\n            'prioridadAtencion', m.prioridadAtencion,\n            'tipoAtencionSolicitada', m.tipoAtencionSolicitada,\n            'grupoServicios', m.grupoServicios,\n            'modalidadAtencion', m.modalidadAtencion\n \n ) as Anexo3Dto, d.detalleCups, o.otroCodigoDetalle\nfrom maestra m, detalleCups d, otroCodigoDetalle o\ngroup by m.Id");
            Throwable th = null;
            try {
                if (xrs1.next()) {
                    anexoInformacionIpsDto.setCodigoEntidadPagadora(xrs1.getString("codigoEntidadPagadora"));
                    AnexoDatoUsuarioDto usuarioDto = (AnexoDatoUsuarioDto) objectMapper.readValue(xrs1.getString("anexoDatoUsuario"), AnexoDatoUsuarioDto.class);
                    Anexo3Dto anexo3Dto = (Anexo3Dto) objectMapper.readValue(xrs1.getString("Anexo3Dto"), Anexo3Dto.class);
                    if (xrs1.getString("detalleCups") != null) {
                        cupsDetalle = (List) objectMapper.readValue(xrs1.getString("detalleCups"), new TypeReference<List<ListaCupsDetalleDto>>() { // from class: Historia.JPOOrdenProcedimientosH.22
                        });
                    }
                    if (xrs1.getString("otroCodigoDetalle") != null) {
                        otroCodigoDetalle = (List) objectMapper.readValue(xrs1.getString("otroCodigoDetalle"), new TypeReference<List<ListaCodigoOtrosDto>>() { // from class: Historia.JPOOrdenProcedimientosH.23
                        });
                    }
                    anexo2335Dto.setAnexoDatoUsuario(usuarioDto);
                    anexo3Dto.setCupsDetalle(cupsDetalle);
                    anexo3Dto.setOtroCodigoDetalle(otroCodigoDetalle);
                    anexo3Dto.setCumDetalle(cumDetalle);
                    anexo2335Dto.setAnexo3(anexo3Dto);
                }
                RecursosMicroserviciosDomain microserviciosDomain = this.xmetodo.getParametrosEncriptados("24", "RegistroAnexo2335");
                Response responsePos = this.xmetodo.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.xmetodo.getMapper().writeValueAsString(anexo2335Dto)));
                responsePos.close();
                this.xmetodo.getResteasyClient().close();
                if (xrs1 != null) {
                    if (0 != 0) {
                        try {
                            xrs1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs1.close();
                    }
                }
            } finally {
            }
        } catch (SQLException | JsonProcessingException ex) {
            Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificarDx() {
        ConsultasMySQL xct;
        ResultSet xrs1;
        Throwable th;
        boolean xestado = false;
        try {
            xct = new ConsultasMySQL();
            String xsql1 = "SELECT `Codigo_Dxp` , `Id` FROM `h_atencion` WHERE (`Codigo_Dxp` <>'' AND `Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ";
            xrs1 = xct.traerRs(xsql1);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (xrs1.next()) {
                    xestado = true;
                }
                if (xrs1 != null) {
                    if (0 != 0) {
                        try {
                            xrs1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs1.close();
                    }
                }
                xct.cerrarConexionBd();
                return xestado;
            } finally {
            }
        } finally {
        }
    }

    private void mImprimirFormula() {
        new Metodos();
        for (int i = 1; i <= ((Integer) this.JSPINImpresiones.getValue()).intValue(); i++) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdServicio().intValue() == 2) {
                try {
                    String xpeso = "";
                    String xtalla = "";
                    String xnstiker = "1";
                    String xsql = "SELECT h_examenfisico.Talla , h_examenfisico.Peso FROM h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE (h_examenfisico.Talla <>0 AND h_examenfisico.Peso <>0 AND h_ordenes.Id ='" + this.JTFNordenProc.getText() + "' AND h_ordenes.Id_TipoServicio =2 AND g_procedimiento.RPrevios IS NOT NULL) ";
                    ResultSet xrs = this.xconsultasbd.traerRs(xsql);
                    Throwable th = null;
                    try {
                        try {
                            if (xrs.next()) {
                                xrs.first();
                                xtalla = xrs.getString(1);
                                xpeso = xrs.getString(2);
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
                            String xsql2 = "SELECT l_tipomuestra.Id FROM h_ordenes INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenesproced  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) WHERE (h_ordenes.Id ='" + this.JTFNordenProc.getText() + "') GROUP BY l_tipomuestra.Id ORDER BY h_ordenes.Id ASC ";
                            ResultSet rs = this.xconsultasbd.traerRs(xsql2);
                            if (rs.next()) {
                                rs.last();
                                xnstiker = String.valueOf(rs.getRow());
                            }
                            rs.close();
                            this.xconsultasbd.cerrarConexionBd();
                            String[][] mparametros = new String[6][2];
                            mparametros[0][0] = "idorden";
                            mparametros[0][1] = this.JTFNordenProc.getText();
                            mparametros[1][0] = "talla";
                            mparametros[1][1] = "TALLA : " + xtalla;
                            mparametros[2][0] = "peso";
                            mparametros[2][1] = "PESO : " + xpeso;
                            mparametros[3][0] = "ns";
                            mparametros[3][1] = "N° Stiker : " + xnstiker;
                            mparametros[4][0] = "SUBREPORT_DIR";
                            mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                            mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                            mparametros[5][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL", mparametros);
                            } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1 || Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL", mparametros);
                                }
                            } else {
                                Object[] botones = {"Visualizar", "Imprimir", "Cerrar"};
                                int m = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                                if (m == 0) {
                                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL", mparametros);
                                        } else {
                                            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                                        }
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                        switch (Principal.informacionIps.getNombreIps()) {
                                            case "FUNDACIÓN PANZENÚ":
                                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL", mparametros);
                                                break;
                                            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                                                break;
                                            default:
                                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                                                break;
                                        }
                                    }
                                } else if (m == 1) {
                                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                                        switch (Principal.informacionIps.getNombreIps()) {
                                            case "FUNDACIÓN PANZENÚ":
                                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL", mparametros);
                                                break;
                                            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                                                break;
                                            default:
                                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL1", mparametros);
                                                break;
                                        }
                                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                                        switch (Principal.informacionIps.getNombreIps()) {
                                            case "FUNDACIÓN PANZENÚ":
                                                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RProcedimientosL.jasper", mparametros);
                                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL1", mparametros);
                                                break;
                                            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL_1_Hospital", mparametros);
                                                break;
                                            default:
                                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL1", mparametros);
                                                break;
                                        }
                                    }
                                }
                            }
                        } finally {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th3;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } else {
                String sql = "SELECT h_atencion.Motivo_Atencion, h_ordenes.Id FROM h_ordenes INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id) where h_ordenes.Id='" + this.JTFNordenProc.getText() + "'";
                String nota = this.xconsultasbd.traerDato(sql);
                this.xconsultasbd.cerrarConexionBd();
                String horario = "";
                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdServicio().intValue() == 3) {
                    horario = "Horario de Atencion:\nLunes a Jueves:  6:30 A.M - 4:30 P.M\nViernes:  6:30 A.M - 1:00 P.M";
                }
                String[][] mparametros2 = new String[6][2];
                mparametros2[0][0] = "idorden";
                mparametros2[0][1] = this.JTFNordenProc.getText();
                mparametros2[1][0] = "idservicio";
                mparametros2[1][1] = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdServicio());
                mparametros2[2][0] = "nota";
                mparametros2[2][1] = nota;
                mparametros2[3][0] = "horario";
                mparametros2[3][1] = horario;
                mparametros2[4][0] = "SUBREPORT_DIR";
                mparametros2[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                mparametros2[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros2[5][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO", mparametros2);
                } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL1", mparametros2);
                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosL2", mparametros2);
                    }
                } else {
                    Object[] botones2 = {"Visualizar", "Imprimir", "Cerrar"};
                    int m2 = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
                    if (m2 == 0) {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO1", mparametros2);
                            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                            } else {
                                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                            }
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            switch (Principal.informacionIps.getNombreIps()) {
                                case "FUNDACIÓN PANZENÚ":
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO1", mparametros2);
                                    break;
                                case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                                    break;
                                default:
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                                    break;
                            }
                        }
                    } else if (m2 == 1) {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            switch (Principal.informacionIps.getNombreIps()) {
                                case "FUNDACIÓN PANZENÚ":
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO1", mparametros2);
                                    break;
                                case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                                    break;
                                default:
                                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                                    break;
                            }
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            switch (Principal.informacionIps.getNombreIps()) {
                                case "FUNDACIÓN PANZENÚ":
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO1", mparametros2);
                                    break;
                                case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RProcedimientosO_Hospital", mparametros2);
                                    break;
                                default:
                                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RProcedimientosO_Hospital.jasper", mparametros2);
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void imprimir() {
        if (mVerificarDx()) {
            if (!this.JTFNordenProc.getText().isEmpty()) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    mImprimirFormula();
                    mImpresionArchivos();
                    return;
                }
                Object[] botones1 = {"INSTITUCIONAL", "ANEXO 3", "CERRAR"};
                int n = JOptionPane.showOptionDialog(this, "Que desea imprimir?", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "CERRAR");
                if (n == 0) {
                    mImprimirFormula();
                    mImpresionArchivos();
                    return;
                } else {
                    if (n == 1) {
                        ReporteAnexo3 x = new ReporteAnexo3(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), this.JTFNordenProc.getText(), 0, 1);
                        x.build();
                        this.xmetodo.mostrarPdf(this.xmetodo.getRutaRep() + "H_Anexo3_Orden.pdf");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.xclase.xjifhistoriaclinica != null) {
            JOptionPane.showInternalMessageDialog(this.xclase.xjifhistoriaclinica, "Falta Diagnòstico por digitar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else if (this.xclase.historia_Clinica_v2 != null) {
            JOptionPane.showInternalMessageDialog(this.xclase.historia_Clinica_v2, "Falta Diagnòstico por digitar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mImpresionArchivos() {
        String sql = "SELECT h_tipoconsentimiento.Nbre, h_tipoconsentimiento.Nbre_Reporte, ingreso.Id_Usuario FROM h_procedimientoxconsentimiento INNER JOIN h_tipoconsentimiento ON (h_procedimientoxconsentimiento.Id_TipoConsentimiento = h_tipoconsentimiento.Id)INNER JOIN g_procedimiento  ON (h_procedimientoxconsentimiento.Id_Procedimiento = g_procedimiento.Id)INNER JOIN h_itemordenesproced ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)INNER JOIN h_ordenes ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN h_atencion ON (h_ordenes.Id_Atencion = h_atencion.Id)INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (h_itemordenesproced.Id_HOrdenes ='" + this.JTFNordenProc.getText() + "') ";
        ResultSet xrs = this.xconsultasbd.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    String[][] mparametrosx = new String[3][2];
                    mparametrosx[0][0] = "idusuario";
                    mparametrosx[0][1] = xrs.getString(3);
                    mparametrosx[1][0] = "SUBREPORT_DIR";
                    mparametrosx[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                    mparametrosx[2][0] = "SUBREPORTFIRMA_DIR";
                    mparametrosx[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                    int n = JOptionPane.showInternalConfirmDialog(this.xclase.xjifhistoriaclinica, "Tiene ubica el papel tamaño carta \npara la impresion del consentimiento informado?", "IMPRIMIR", 0);
                    if (n == 0) {
                        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + xrs.getString(2), mparametrosx);
                    }
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOOrdenProcedimientosH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x039b: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:55:0x039b */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0396: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:53:0x0396 */
    public void mBuscarProcedimiento(String id, boolean xforma) {
        try {
            try {
                nuevo();
                String sql = "SELECT h_itemordenesproced.Id_Procedimiento, g_procedimiento.Nbre, f_tipofinprocedimiento.Nbre, h_itemordenesproced.Cantidad, h_itemordenesproced.Descripcion, f_tipofinprocedimiento.Id, h_ordenes.Estado, h_ordenes.Id,IF(h_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL,FALSE,TRUE) GeneraConsentimiento , h_itemordenesproced.`IdConsentimiento`, `h_ordenes`.`FechaOrden`, `h_ordenes`.`HoraOrden`, h_itemordenesproced.`esPrioritario`,h_itemordenesproced.Id_Orden_Fac, ggs.id idGrupo, ggs.nombre nombreGrupo, gsr.id idServicioRips, gsr.nombre nombreServicioRips    \nFROM h_itemordenesproced \nINNER JOIN h_ordenes  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) \nINNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_tipofinprocedimiento ON (h_itemordenesproced.IdtipofinProc = f_tipofinprocedimiento.Id) inner join g_servicios_rips gsr on (gsr.id=h_itemordenesproced.idServicioRips)\ninner join g_grupo_servicio ggs on (ggs.id=gsr.idGrupoServicio)\nLEFT JOIN `h_procedimientoxconsentimiento` ON (h_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`) AND(h_procedimientoxconsentimiento.`Estado`=1)  \nWHERE h_ordenes.Id IN(" + id + ") GROUP BY h_itemordenesproced.Id_Procedimiento";
                ResultSet rs = this.xconsultasbd.traerRs(sql);
                Throwable th = null;
                if (rs.next()) {
                    rs.first();
                    ResultSet xrs = this.xconsultasbd.traerRs(sql);
                    Throwable th2 = null;
                    try {
                        try {
                            this.xfila = 0;
                            this.xmetodo.mEstablecerTextEditor(this.JTDatosDetProcedimiento, 1);
                            this.xmetodo.mEstablecerTextEditor(this.JTDatosDetProcedimiento, 2);
                            this.xmetodo.mEstablecerTextEditor(this.JTDatosDetProcedimiento, 4);
                            this.xmetodo.mEstablecerTextEditor(this.JTDatosDetProcedimiento, 5);
                            while (xrs.next()) {
                                this.xmodelodetallet.addRow(this.xdato);
                                this.xmodelodetallet.setValueAt(xrs.getString(1), this.xfila, 0);
                                this.xmodelodetallet.setValueAt(xrs.getString(2), this.xfila, 1);
                                this.xmodelodetallet.setValueAt(xrs.getString(3), this.xfila, 2);
                                this.xmodelodetallet.setValueAt(Integer.valueOf(xrs.getInt(4)), this.xfila, 3);
                                this.xmodelodetallet.setValueAt(xrs.getString(5), this.xfila, 4);
                                this.xmodelodetallet.setValueAt(xrs.getString(6), this.xfila, 5);
                                this.xmodelodetallet.setValueAt("", this.xfila, 6);
                                this.xmodelodetallet.setValueAt("", this.xfila, 7);
                                this.xmodelodetallet.setValueAt("", this.xfila, 8);
                                this.xmodelodetallet.setValueAt("", this.xfila, 9);
                                this.xmodelodetallet.setValueAt("", this.xfila, 10);
                                this.xmodelodetallet.setValueAt("", this.xfila, 11);
                                this.xmodelodetallet.setValueAt("", this.xfila, 12);
                                this.xmodelodetallet.setValueAt("", this.xfila, 13);
                                this.xmodelodetallet.setValueAt("", this.xfila, 14);
                                this.xmodelodetallet.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), this.xfila, 15);
                                this.xmodelodetallet.setValueAt(Long.valueOf(xrs.getLong(10)), this.xfila, 16);
                                this.xmodelodetallet.setValueAt(Boolean.valueOf(xrs.getBoolean("esPrioritario")), this.xfila, 17);
                                this.xmodelodetallet.setValueAt(Long.valueOf(xrs.getLong("Id_Orden_Fac")), this.xfila, 18);
                                this.xmodelodetallet.setValueAt(xrs.getString("idGrupo"), this.xfila, 19);
                                this.xmodelodetallet.setValueAt(xrs.getString("nombreGrupo"), this.xfila, 20);
                                this.xmodelodetallet.setValueAt(xrs.getString("idServicioRips"), this.xfila, 21);
                                this.xmodelodetallet.setValueAt(xrs.getString("nombreServicioRips"), this.xfila, 22);
                                if (xforma) {
                                    if (rs.getInt(7) == 1) {
                                        this.JLBEstado.setText("ANULADA");
                                    } else {
                                        this.JLBEstado.setText("ACTIVA");
                                    }
                                    this.JTFNordenProc.setText(xrs.getString(8));
                                    this.JDFecha.setDate(xrs.getDate("FechaOrden"));
                                    this.JTFFHora.setText(xrs.getString("HoraOrden"));
                                } else {
                                    this.JTFNordenProc.setText("");
                                    this.JDFecha.setDate(this.xmetodo.getFechaActual());
                                    this.JTFFHora.setText(this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()));
                                }
                                this.xfila++;
                            }
                            this.JTPMenu.setSelectedIndex(0);
                            if (xrs != null) {
                                if (0 != 0) {
                                    try {
                                        xrs.close();
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                    }
                                } else {
                                    xrs.close();
                                }
                            }
                            this.xconsultasbd.cerrarConexionBd();
                        } catch (Throwable th4) {
                            if (xrs != null) {
                                if (th2 != null) {
                                    try {
                                        xrs.close();
                                    } catch (Throwable th5) {
                                        th2.addSuppressed(th5);
                                    }
                                } else {
                                    xrs.close();
                                }
                            }
                            throw th4;
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        throw th6;
                    }
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th7) {
                            th.addSuppressed(th7);
                        }
                    } else {
                        rs.close();
                    }
                }
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException e) {
            }
        } finally {
        }
    }

    public void anular() {
        if (this.xtipo == 1) {
            anularDetalle();
            return;
        }
        LiquidacionEntity liquidacionEntity = this.liquidacionService.liquidacionPorIdIngresoEstado(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso());
        if (liquidacionEntity == null) {
            anularDetalle();
        } else {
            JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Ingreso ya cerrado por facturación ;</p><font face='Arial' color='red' size=4>No se pude anular orden...", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void anularDetalle() {
        if (!this.JTFNordenProc.getText().isEmpty()) {
            int n = JOptionPane.showInternalOptionDialog(this, "¿Está seguro de anular la orden?", "ANULAR", 0, 3, (Icon) null, (Object[]) null, 0);
            if (n == 0) {
                String sql = "UPDATE h_ordenes SET Estado = 1 WHERE Id = '" + this.JTFNordenProc.getText() + "'";
                if (this.xconsultasbd != null) {
                    this.xconsultasbd.ejecutarSQL(sql);
                    this.xconsultasbd.cerrarConexionBd();
                }
                this.JLBEstado.setText("ANULADA");
                if (this.JTDatosDetProcedimiento != null && this.JTDatosDetProcedimiento.getRowCount() > 0 && this.JTDatosDetProcedimiento.getColumnCount() > 18 && this.JTDatosDetProcedimiento.getValueAt(0, 18) != null) {
                    try {
                        Long idOrden = Long.valueOf(this.JTDatosDetProcedimiento.getValueAt(0, 18).toString());
                        if (this.ordenesService != null) {
                            Optional<FOrdenesDTO> ordenesDTO = this.ordenesService.buscarPorIdOrden(idOrden);
                            if (ordenesDTO.isPresent()) {
                                FOrdenesDTO dto = ordenesDTO.get();
                                dto.setEstado(true);
                                dto.setId_MotivoAnulacion(2);
                                dto.setFecha_Anulacion(this.xmetodo.getFechaActualLocalTime());
                                dto.setDetalle_Anulacion("ANULACIÓN DESDE ORDENES MEDICAS");
                                if (Principal.usuarioSistemaDTO != null && Principal.usuarioSistemaDTO.getNombreUsuario() != null) {
                                    dto.setUsuario_Anulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
                                } else {
                                    dto.setUsuario_Anulacion("USUARIO_DESCONOCIDO");
                                }
                                this.ordenesService.actualizar(dto);
                            }
                        }
                        return;
                    } catch (NumberFormatException e) {
                        System.err.println("Error convirtiendo el ID de la orden a Long: " + e.getMessage());
                        return;
                    }
                }
                System.err.println("No se pudo obtener el ID de la orden desde la tabla.");
            }
        }
    }

    private void mvalidadprocedimiento() {
        try {
            String sql = "SELECT h_ordenes.Id, h_ordenes.FechaOrden, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, h_itemordenesproced.Id_Procedimiento, g_procedimiento.Nbre, h_itemordenesproced.Cantidad FROM h_itemordenesproced INNER JOIN h_ordenes  ON (h_itemordenesproced.Id_HOrdenes = h_ordenes.Id) INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN g_procedimiento  ON (h_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN ingreso  ON (ingreso.Id = h_atencion.Id_Ingreso) INNER JOIN g_profesional  ON (h_atencion.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_persona   ON (g_profesional.Id_Persona = g_persona.Id) WHERE (ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and h_itemordenesproced.Id_Procedimiento='" + this.JTDatosProcedimiento.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 1) + "' AND h_ordenes.Estado =0) order by h_ordenes.FechaOrden desc ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                JDValidarProcedimientos frm = new JDValidarProcedimientos(null, true, sql, "Historia");
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void buscar() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaProcedimiento() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"", "Cups", "", "Nombre Procedimiento", "", "", "Resultado", "", "CTC", "Paquete", "GC?", "TipoProcedimiento", "idProcedimiento", "autorización"}) { // from class: Historia.JPOOrdenProcedimientosH.24
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Integer.class, Boolean.class, Integer.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDatosProcedimiento.setAutoResizeMode(0);
        this.JTDatosProcedimiento.doLayout();
        this.JTDatosProcedimiento.setModel(this.xmodelo);
        this.JTDatosProcedimiento.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDatosProcedimiento.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(3).setPreferredWidth(570);
        this.JTDatosProcedimiento.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDatosProcedimiento.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDatosProcedimiento.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDatosProcedimiento.getColumnModel().getColumn(13).setPreferredWidth(100);
    }

    private void mLLenartabla() {
        String sql;
        try {
            mCrearTablaProcedimiento();
            String cups = " g_procedimiento.Id ";
            if (Principal.informacionIps.getNombreIps().equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S")) {
                cups = " IFNULL(g_procedimiento.C_Homologado, g_procedimiento.Id) as Id ";
            }
            if (Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 1023 || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 1024 || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 461 || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 1032 || Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue() == 250) {
                if (this.xtipobusqueda == 0) {
                    sql = "SELECT f_tiposervicio.Id, " + cups + ", CONCAT(g_procedimiento.Nbre,' ', IF(q_procedtipomanqx.`Grupo_UVR` IS NULL, '',CONCAT('Grupo QX: ',q_procedtipomanqx.`Grupo_UVR`))) AS Procedimiento, f_tipofinprocedimiento.Id, f_tipofinprocedimiento.Nbre,IF(g_procedimiento.RPrevios  IS NULL, '', g_procedimiento.RPrevios ) AS RPrevios, g_procedimiento.Oportunidad , g_procedimiento.EsRemitido, g_procedimiento.Paquete, IF(h_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL,FALSE,TRUE) GeneraConsentimiento   , g_procedimiento.Id_tipoprocedimiento,  g_procedimiento.Id idProcedimiento , if(fp.Id_Procedimiento is not null, 1, 0) autorizacion FROM f_tiposervtipoproced INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_tipoprocedimiento  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN g_procedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) LEFT JOIN `q_procedtipomanqx`  ON (g_procedimiento.`Id`= q_procedtipomanqx.`Id_Procedimiento`) AND (q_procedtipomanqx.`Id_TipoManualQx`=2) INNER JOIN f_tipofinprocedimiento ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) LEFT JOIN `h_procedimientoxconsentimiento` ON (h_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`)  AND(h_procedimientoxconsentimiento.`Estado`=1)  left join f_procedempresaconvenio fp on (fp.Id_Procedimiento = g_procedimiento.Id )\n and (fp.Estado= 0) and (fp.Id_EmpresacontxConv =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdConvenio() + ") and (fp.autorizacion =1) WHERE (( g_procedimiento.Nbre like'%" + this.JTFNombre.getText().toUpperCase() + "%' ||  g_procedimiento.Id like'%" + this.JTFNombre.getText().toUpperCase() + "%' ||  g_procedimiento.C_Homologado like'%" + this.JTFNombre.getText().toUpperCase() + "%'  ) and g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento() + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento() + "') <= g_procedimiento.EdadM)) ORDER BY g_procedimiento.Nbre ASC ";
                } else {
                    sql = "SELECT f_tiposervicio.Id, " + cups + ", CONCAT(g_procedimiento.Nbre,' ', IF(q_procedtipomanqx.`Grupo_UVR` IS NULL, '',CONCAT('Grupo QX: ',q_procedtipomanqx.`Grupo_UVR`))) AS Procedimiento, f_tipofinprocedimiento.Id, f_tipofinprocedimiento.Nbre,IF(g_procedimiento.RPrevios  IS NULL, '', g_procedimiento.RPrevios ) AS RPrevios, g_procedimiento.Oportunidad , g_procedimiento.EsRemitido, g_procedimiento.Paquete, IF(h_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL,FALSE,TRUE) GeneraConsentimiento   , g_procedimiento.Id_tipoprocedimiento,  g_procedimiento.Id idProcedimiento , if(fp.Id_Procedimiento is not null, 1, 0) autorizacion FROM f_tiposervtipoproced INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_tipoprocedimiento  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN g_procedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) LEFT JOIN `q_procedtipomanqx`  ON (g_procedimiento.`Id`= q_procedtipomanqx.`Id_Procedimiento`) AND (q_procedtipomanqx.`Id_TipoManualQx`=2) INNER JOIN f_tipofinprocedimiento ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) LEFT JOIN `h_procedimientoxconsentimiento` ON (h_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`)  AND(h_procedimientoxconsentimiento.`Estado`=1)  left join f_procedempresaconvenio fp on (fp.Id_Procedimiento = g_procedimiento.Id )\n and (fp.Estado= 0) and (fp.Id_EmpresacontxConv =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdConvenio() + ") and (fp.autorizacion =1) WHERE (( g_procedimiento.Nbre like'%" + this.JTFNombre.getText().toUpperCase() + "%' ||  g_procedimiento.Id like'%" + this.JTFNombre.getText().toUpperCase() + "%' ||  g_procedimiento.C_Homologado like'%" + this.JTFNombre.getText().toUpperCase() + "%')and g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento() + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento() + "') <= g_procedimiento.EdadM)) ORDER BY g_procedimiento.Nbre ASC ";
                }
            } else if (this.xtipobusqueda == 0) {
                sql = "SELECT f_tiposervicio.Id, " + cups + ", CONCAT(g_procedimiento.Nbre,' ', IF(q_procedtipomanqx.`Grupo_UVR` IS NULL, '',CONCAT('Grupo QX: ',q_procedtipomanqx.`Grupo_UVR`))) AS Procedimiento, f_tipofinprocedimiento.Id, f_tipofinprocedimiento.Nbre,IF(g_procedimiento.RPrevios  IS NULL, '', g_procedimiento.RPrevios ) AS RPrevios, g_procedimiento.Oportunidad , g_procedimiento.EsRemitido, g_procedimiento.Paquete, IF(h_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL,FALSE,TRUE) GeneraConsentimiento   , g_procedimiento.Id_tipoprocedimiento,  g_procedimiento.Id idProcedimiento , if(fp.Id_Procedimiento is not null, 1, 0) autorizacion FROM f_tiposervtipoproced INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_tipoprocedimiento  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN g_procedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) LEFT JOIN `q_procedtipomanqx`  ON (g_procedimiento.`Id`= q_procedtipomanqx.`Id_Procedimiento`) AND (q_procedtipomanqx.`Id_TipoManualQx`=2) INNER JOIN f_tipofinprocedimiento ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) LEFT JOIN `h_procedimientoxconsentimiento` ON (h_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`)  AND(h_procedimientoxconsentimiento.`Estado`=1)  left join f_procedempresaconvenio fp on (fp.Id_Procedimiento = g_procedimiento.Id )\n and (fp.Estado= 0) and (fp.Id_EmpresacontxConv =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdConvenio() + ") and (fp.autorizacion =1) WHERE (f_tiposervicio.Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdServicio() + "' and ( g_procedimiento.Nbre like'%" + this.JTFNombre.getText().toUpperCase() + "%' ||  g_procedimiento.Id like'%" + this.JTFNombre.getText().toUpperCase() + "%' ||  g_procedimiento.C_Homologado like'%" + this.JTFNombre.getText().toUpperCase() + "%') and g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento() + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento() + "') <= g_procedimiento.EdadM)) ORDER BY g_procedimiento.Nbre ASC ";
            } else {
                sql = "SELECT f_tiposervicio.Id, " + cups + ", CONCAT(g_procedimiento.Nbre,' ', IF(q_procedtipomanqx.`Grupo_UVR` IS NULL, '',CONCAT('Grupo QX: ',q_procedtipomanqx.`Grupo_UVR`))) AS Procedimiento, f_tipofinprocedimiento.Id, f_tipofinprocedimiento.Nbre,IF(g_procedimiento.RPrevios  IS NULL, '', g_procedimiento.RPrevios ) AS RPrevios, g_procedimiento.Oportunidad , g_procedimiento.EsRemitido, g_procedimiento.Paquete, IF(h_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL,FALSE,TRUE) GeneraConsentimiento   , g_procedimiento.Id_tipoprocedimiento,  g_procedimiento.Id idProcedimiento , if(fp.Id_Procedimiento is not null, 1, 0) autorizacion FROM f_tiposervtipoproced INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_tipoprocedimiento  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN g_procedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) LEFT JOIN `q_procedtipomanqx`  ON (g_procedimiento.`Id`= q_procedtipomanqx.`Id_Procedimiento`) AND (q_procedtipomanqx.`Id_TipoManualQx`=2) INNER JOIN f_tipofinprocedimiento ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) LEFT JOIN `h_procedimientoxconsentimiento` ON (h_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`)  AND(h_procedimientoxconsentimiento.`Estado`=1)  left join f_procedempresaconvenio fp on (fp.Id_Procedimiento = g_procedimiento.Id )\n and (fp.Estado= 0) and (fp.Id_EmpresacontxConv =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdConvenio() + ") and (fp.autorizacion =1) WHERE (f_tiposervicio.Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdServicio() + "' and ( g_procedimiento.Nbre like'%" + this.JTFNombre.getText().toUpperCase() + "%' ||  g_procedimiento.Id like'%" + this.JTFNombre.getText().toUpperCase() + "%' ||  g_procedimiento.C_Homologado like'%" + this.JTFNombre.getText().toUpperCase() + "%')and g_procedimiento.Estado=0 AND g_procedimiento.`Sexo` IN ('A', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo() + "') \n    AND ( DATEDIFF(NOW(),'" + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento() + "') >= g_procedimiento.EdadI  AND DATEDIFF(NOW(),'" + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento() + "') <= g_procedimiento.EdadM)) ORDER BY g_procedimiento.Nbre ASC ";
            }
            ResultSet rss = this.xconsultasbd.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (rss.next()) {
                        rss.beforeFirst();
                        int x = 0;
                        this.xmetodo.mEstablecerTextEditor(this.JTDatosProcedimiento, 3);
                        while (rss.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(rss.getString(1), x, 0);
                            this.xmodelo.setValueAt(rss.getString(2), x, 1);
                            this.xmodelo.setValueAt(rss.getString(4), x, 2);
                            this.xmodelo.setValueAt(rss.getString(3), x, 3);
                            this.xmodelo.setValueAt(rss.getString(5), x, 4);
                            this.xmodelo.setValueAt(rss.getString(6), x, 5);
                            this.xmodelo.setValueAt(rss.getString(7), x, 6);
                            this.xmodelo.setValueAt(rss.getString(8), x, 7);
                            this.xmodelo.setValueAt(false, x, 8);
                            this.xmodelo.setValueAt(rss.getString("Paquete"), x, 9);
                            this.xmodelo.setValueAt(Boolean.valueOf(rss.getBoolean("GeneraConsentimiento")), x, 10);
                            this.xmodelo.setValueAt(Integer.valueOf(rss.getInt("Id_tipoprocedimiento")), x, 11);
                            this.xmodelo.setValueAt(Long.valueOf(rss.getLong("idProcedimiento")), x, 12);
                            this.xmodelo.setValueAt(Boolean.valueOf(rss.getBoolean("autorizacion")), x, 13);
                            this.JTDatosProcedimiento.setDefaultRenderer(Object.class, new MiRender());
                            if (rss.getBoolean("GeneraConsentimiento")) {
                            }
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

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleProc() {
        this.xmodelodetallet = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Finalidad", "cantidad", "observaciones", "IdFin", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9", "GC?", "IdConsentimiento", "Es Prioritario?", "IdOrdenFac", "Código Grupo", "Nombre Grupo", "Código Servicio Rips", "Nombre Servicio Rips", "idProcedimiento", "autorizacion"}) { // from class: Historia.JPOOrdenProcedimientosH.25
            Class[] types = {Integer.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class, Boolean.class, Long.class, String.class, String.class, String.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDatosDetProcedimiento;
        JTable jTable2 = this.JTDatosDetProcedimiento;
        jTable.setAutoResizeMode(0);
        this.JTDatosDetProcedimiento.doLayout();
        this.JTDatosDetProcedimiento.setModel(this.xmodelodetallet);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(20).setPreferredWidth(150);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(22).setPreferredWidth(300);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTDatosDetProcedimiento.getColumnModel().getColumn(24).setPreferredWidth(100);
    }

    private void mImprimir() {
        if (!this.JTFNordenProc.getText().isEmpty()) {
            String sql = "SELECT  `Id` , `IdOrden` FROM `h_concecutivo_ctc` WHERE (`IdOrden` ='" + this.JTFNordenProc.getText() + "');";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    String[][] parametros = new String[3][2];
                    parametros[0][0] = "ID_Conc";
                    parametros[0][1] = this.JTFNordenProc.getText();
                    parametros[1][0] = "SUBREPORT_DIR";
                    parametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                    parametros[2][0] = "SUBREPORTFIRMA_DIR";
                    parametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "R_ServiciosNoPOS", parametros);
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

    private void mVerificarRDatosAdicionales() {
        if (!this.xmodelo.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 5).equals("")) {
            String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>El procedimiento seleccionado para adicionar requiere los siguientes datos : " + this.xmodelo.getValueAt(this.JTDatosProcedimiento.getSelectedRow(), 5) + " ;</p><font face='Arial' color='red' size=4>Favor digitar en la observación o registrar en el examen físico";
            JOptionPane.showInternalMessageDialog(this, xmensaje, "VERIFICAR DATOS ADICIONALES DEL PROCEDIMIENTO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPOOrdenProcedimientosH$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 7).toString().equals("1")) {
                cell.setBackground(new Color(177, 251, 177));
            } else if (table.getValueAt(row, 10).toString().equals("true")) {
                cell.setBackground(Color.YELLOW);
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalle() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"No. Orden", "Fecha", "Profesional", "Estado", "Seleccionar"}) { // from class: Historia.JPOOrdenProcedimientosH.26
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleH.setModel(this.xmodeloH);
        this.JTDetalleH.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleH.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalleH.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalleH.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleH.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mCargarDatosTablaHistorico() {
        mCrearTablaDetalle();
        String sql = "SELECT h_ordenes.Id, h_ordenes.FechaOrden, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, h_ordenes.Estado, if(hi.Id_Orden_Fac=0, 1, 2) EstaEntregada, h_atencion.Hora_Atencion FROM  h_ordenes inner join h_itemordenesproced hi  on (hi.Id_HOrdenes=h_ordenes.Id) INNER JOIN  h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN  ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN  g_profesional  ON (h_ordenes.Id_Profesional = g_profesional.Id_Persona) INNER JOIN  g_persona  ON (g_profesional.Id_Persona = g_persona.Id) WHERE ( h_ordenes.Id_TipoServicio ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdServicio() + "' AND ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and h_ordenes.Estado='0') group by h_ordenes.Id ORDER BY h_ordenes.FechaOrden DESC, h_atencion.Hora_Atencion DESC ";
        ResultSet xrs = this.xconsultasbd.traerRs(sql);
        try {
            xrs.next();
            if (xrs.getRow() != 0) {
                ResultSet rss = this.xconsultasbd.traerRs(sql);
                int i = 0;
                while (rss.next()) {
                    this.xmodeloH.addRow(this.xdato);
                    this.xmodeloH.setValueAt(Long.valueOf(rss.getLong(1)), i, 0);
                    this.xmodeloH.setValueAt(this.xmetodo.formatoDMA.format((Date) rss.getDate(2)), i, 1);
                    this.xmodeloH.setValueAt(rss.getString(3), i, 2);
                    if (rss.getInt(5) == 1) {
                        this.xmodeloH.setValueAt("Impresa", i, 3);
                    } else {
                        this.xmodeloH.setValueAt("Facturada", i, 3);
                    }
                    this.xmodeloH.setValueAt(false, i, 4);
                    i++;
                }
                rss.close();
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
        this.xconsultasbd.cerrarConexionBd();
    }
}
