package Salud_Ocupacional;

import Acceso.Principal;
import Facturacion.BuscarIngreso;
import General.Persona;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.HSoDeclaracionSalud;
import com.genoma.plus.jpa.entities.HSoDeclaracionSaludDetalle;
import com.genoma.plus.jpa.entities.HSoPreguntasDetalle;
import com.genoma.plus.jpa.service.HSoDeclaracionSaludDetalleService;
import com.genoma.plus.jpa.service.HSoDeclaracionSaludService;
import com.genoma.plus.jpa.service.HSoPreguntasDetalleService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFDeclaracionSalud.class */
public class JIFDeclaracionSalud extends JInternalFrame {
    public BuscarIngreso frmBuscarI = null;
    public Persona frmPersona = null;
    private Metodos metodos = new Metodos();
    private JTable table;
    private DefaultTableModel model;
    public String declaracionS;
    public Long ingreso;
    private Long idIngreso;
    public HSoDeclaracionSalud idDeclaracion;
    public HSoDeclaracionSalud declaracion;
    private HSoDeclaracionSalud declaracionSalud;
    private final HSoDeclaracionSaludService declaracionSaludService;
    private final HSoDeclaracionSaludDetalleService declaracionSaludDetalleService;
    private List<HSoDeclaracionSalud> listDeclaracionSalud;
    private HSoPreguntasDetalle preguntasDetalle;
    private final HSoPreguntasDetalleService preguntasDetalleService;
    private List<HSoPreguntasDetalle> listPreguntasDetalle;
    private JPanel respuestaPanel;
    private String rMecanico;
    private String rErgonomico;
    private String rQuimico;
    private String rPsicosocial;
    private String rLocativo;
    private String rVial;
    private String rTareas;
    private String rFisico;
    private String eAudiometria;
    private String eVisiometria;
    private String eEspirometria;
    private String ePerfil;
    private String eResonanciaLumbar;
    private String eResonanciaHombro;
    private String eRxTorax;
    private String ePricosensometrica;
    private String eAlcoholimetria;
    private String eSustancia;
    private String eElectrocardiograma;
    private String ePsicologica;
    private String tipoRiesgo;
    private String autorizacion;
    private Long idEncabezado;
    private HSoDeclaracionSalud idDeclaracionS;
    private JButton JBTAceptar;
    private JButton JBTImprimir;
    private JButton JBTSiguiente;
    private JButton JBTSiguiente1;
    private JCheckBox JCHBAlcoholimetria;
    private JCheckBox JCHBAudiometria;
    private JCheckBox JCHBElectrocardiograma;
    private JCheckBox JCHBErgonomico;
    private JCheckBox JCHBEspirometria;
    private JCheckBox JCHBFisico;
    private JCheckBox JCHBLocativo;
    private JCheckBox JCHBMecanico;
    private JCheckBox JCHBPerfilLipidico;
    private JCheckBox JCHBPsicologica;
    private JCheckBox JCHBPsicosensometrica;
    private JCheckBox JCHBQuimico;
    private JCheckBox JCHBResonanciaHombro;
    private JCheckBox JCHBResonanciaLumbar;
    private JCheckBox JCHBRxTorax;
    private JCheckBox JCHBSustancias;
    private JCheckBox JCHBTareas;
    private JCheckBox JCHBVial;
    private JCheckBox JCHBVisiometria;
    private JPanel JPIAspectosI;
    private JPanel JPIAspectosII;
    private JPanel JPanelAspecto;
    private JRadioButton JRBAlcoholimetriaNO;
    private JRadioButton JRBAlcoholimetriaSI;
    private JRadioButton JRBAudiometriaNO;
    private JRadioButton JRBAudiometriaSI;
    private JRadioButton JRBElectrocardiogramaNO;
    private JRadioButton JRBElectrocardiogramaSI;
    private JRadioButton JRBEspiroNO;
    private JRadioButton JRBEspiroSI;
    private JRadioButton JRBHombroNO;
    private JRadioButton JRBHombroSI;
    private JRadioButton JRBLumbarNO;
    private JRadioButton JRBLumbarSI;
    private JRadioButton JRBPerfilNO;
    private JRadioButton JRBPerfilSI;
    private JRadioButton JRBPsicologiaSI;
    private JRadioButton JRBPsicologicaNO;
    private JRadioButton JRBPsicosensometricaNO;
    private JRadioButton JRBPsicosensometricaSI;
    private JRadioButton JRBRxTorax;
    private JRadioButton JRBRxToraxNO;
    private JRadioButton JRBSustanciasNO;
    private JRadioButton JRBSustanciasSI;
    private JRadioButton JRBVIsiometriaNO;
    private JRadioButton JRBVisiometriaSI;
    private JTable JTAspectos;
    private JTextField JTFObservacionRiesgo;
    private JTextField JTFOtrosRiesgos;
    public JTabbedPane JTPDatos;
    private JCheckBox Psicosocial;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup10;
    private ButtonGroup buttonGroup11;
    private ButtonGroup buttonGroup12;
    private ButtonGroup buttonGroup13;
    private ButtonGroup buttonGroup14;
    private ButtonGroup buttonGroup15;
    private ButtonGroup buttonGroup16;
    private ButtonGroup buttonGroup17;
    private ButtonGroup buttonGroup18;
    private ButtonGroup buttonGroup19;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup20;
    private ButtonGroup buttonGroup21;
    private ButtonGroup buttonGroup22;
    private ButtonGroup buttonGroup23;
    private ButtonGroup buttonGroup24;
    private ButtonGroup buttonGroup25;
    private ButtonGroup buttonGroup26;
    private ButtonGroup buttonGroup27;
    private ButtonGroup buttonGroup28;
    private ButtonGroup buttonGroup29;
    private ButtonGroup buttonGroup3;
    private ButtonGroup buttonGroup30;
    private ButtonGroup buttonGroup31;
    private ButtonGroup buttonGroup32;
    private ButtonGroup buttonGroup33;
    private ButtonGroup buttonGroup34;
    private ButtonGroup buttonGroup35;
    private ButtonGroup buttonGroup36;
    private ButtonGroup buttonGroup37;
    private ButtonGroup buttonGroup38;
    private ButtonGroup buttonGroup39;
    private ButtonGroup buttonGroup4;
    private ButtonGroup buttonGroup40;
    private ButtonGroup buttonGroup41;
    private ButtonGroup buttonGroup42;
    private ButtonGroup buttonGroup43;
    private ButtonGroup buttonGroup44;
    private ButtonGroup buttonGroup45;
    private ButtonGroup buttonGroup46;
    private ButtonGroup buttonGroup47;
    private ButtonGroup buttonGroup48;
    private ButtonGroup buttonGroup49;
    private ButtonGroup buttonGroup5;
    private ButtonGroup buttonGroup50;
    private ButtonGroup buttonGroup51;
    private ButtonGroup buttonGroup52;
    private ButtonGroup buttonGroup53;
    private ButtonGroup buttonGroup54;
    private ButtonGroup buttonGroup55;
    private ButtonGroup buttonGroup56;
    private ButtonGroup buttonGroup57;
    private ButtonGroup buttonGroup58;
    private ButtonGroup buttonGroup59;
    private ButtonGroup buttonGroup6;
    private ButtonGroup buttonGroup60;
    private ButtonGroup buttonGroup7;
    private ButtonGroup buttonGroup8;
    private ButtonGroup buttonGroup9;
    private JLabel jLabel132;
    private JLabel jLabel133;
    private JLabel jLabel134;
    private JLabel jLabel135;
    private JLabel jLabel136;
    private JLabel jLabel137;
    private JLabel jLabel138;
    private JLabel jLabel139;
    private JLabel jLabel140;
    private JLabel jLabel141;
    private JLabel jLabel142;
    private JLabel jLabel143;
    private JLabel jLabel144;
    private JLabel jLabel145;
    private JLabel jLabel146;
    private JLabel jLabel147;
    private JLabel jLabel148;
    private JLabel jLabel149;
    private JLabel jLabel150;
    private JLabel jLabel151;
    private JLabel jLabel152;
    private JLabel jLabel153;
    private JLabel jLabel154;
    private JLabel jLabel155;
    private JLabel jLabel156;
    private JLabel jLabel157;
    private JLabel jLabel158;
    private JLabel jLabel159;
    private JLabel jLabel33;
    private JPanel jPanel1;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JScrollPane jScrollPane1;
    private JPanel panelPersona;

    public JIFDeclaracionSalud() {
        initComponents();
        cargarPanelPersona();
        this.declaracionSalud = new HSoDeclaracionSalud();
        this.declaracionSaludService = (HSoDeclaracionSaludService) Principal.contexto.getBean(HSoDeclaracionSaludService.class);
        this.declaracionSaludDetalleService = (HSoDeclaracionSaludDetalleService) Principal.contexto.getBean(HSoDeclaracionSaludDetalleService.class);
        this.listDeclaracionSalud = new ArrayList();
        this.preguntasDetalle = new HSoPreguntasDetalle();
        this.preguntasDetalleService = (HSoPreguntasDetalleService) Principal.contexto.getBean(HSoPreguntasDetalleService.class);
        this.listPreguntasDetalle = new ArrayList();
        this.model = new DefaultTableModel();
        this.table = new JTable(this.model);
        cargarPreguntas();
        inicializarVariables();
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.buttonGroup4 = new ButtonGroup();
        this.buttonGroup5 = new ButtonGroup();
        this.buttonGroup6 = new ButtonGroup();
        this.buttonGroup7 = new ButtonGroup();
        this.buttonGroup8 = new ButtonGroup();
        this.buttonGroup9 = new ButtonGroup();
        this.buttonGroup10 = new ButtonGroup();
        this.buttonGroup11 = new ButtonGroup();
        this.buttonGroup12 = new ButtonGroup();
        this.buttonGroup13 = new ButtonGroup();
        this.buttonGroup14 = new ButtonGroup();
        this.buttonGroup15 = new ButtonGroup();
        this.buttonGroup16 = new ButtonGroup();
        this.buttonGroup17 = new ButtonGroup();
        this.buttonGroup18 = new ButtonGroup();
        this.buttonGroup19 = new ButtonGroup();
        this.buttonGroup20 = new ButtonGroup();
        this.buttonGroup21 = new ButtonGroup();
        this.buttonGroup22 = new ButtonGroup();
        this.buttonGroup23 = new ButtonGroup();
        this.buttonGroup24 = new ButtonGroup();
        this.buttonGroup25 = new ButtonGroup();
        this.buttonGroup26 = new ButtonGroup();
        this.buttonGroup27 = new ButtonGroup();
        this.buttonGroup28 = new ButtonGroup();
        this.buttonGroup29 = new ButtonGroup();
        this.buttonGroup30 = new ButtonGroup();
        this.buttonGroup31 = new ButtonGroup();
        this.buttonGroup32 = new ButtonGroup();
        this.buttonGroup33 = new ButtonGroup();
        this.buttonGroup34 = new ButtonGroup();
        this.buttonGroup35 = new ButtonGroup();
        this.buttonGroup36 = new ButtonGroup();
        this.buttonGroup37 = new ButtonGroup();
        this.buttonGroup38 = new ButtonGroup();
        this.buttonGroup39 = new ButtonGroup();
        this.buttonGroup40 = new ButtonGroup();
        this.buttonGroup41 = new ButtonGroup();
        this.buttonGroup42 = new ButtonGroup();
        this.buttonGroup43 = new ButtonGroup();
        this.buttonGroup44 = new ButtonGroup();
        this.buttonGroup45 = new ButtonGroup();
        this.buttonGroup46 = new ButtonGroup();
        this.buttonGroup47 = new ButtonGroup();
        this.buttonGroup48 = new ButtonGroup();
        this.buttonGroup49 = new ButtonGroup();
        this.buttonGroup50 = new ButtonGroup();
        this.buttonGroup51 = new ButtonGroup();
        this.buttonGroup52 = new ButtonGroup();
        this.buttonGroup53 = new ButtonGroup();
        this.buttonGroup54 = new ButtonGroup();
        this.buttonGroup55 = new ButtonGroup();
        this.buttonGroup56 = new ButtonGroup();
        this.buttonGroup57 = new ButtonGroup();
        this.buttonGroup58 = new ButtonGroup();
        this.buttonGroup59 = new ButtonGroup();
        this.buttonGroup60 = new ButtonGroup();
        this.panelPersona = new JPanel();
        this.jPanel1 = new JPanel();
        this.JTPDatos = new JTabbedPane();
        this.JPIAspectosI = new JPanel();
        this.JPanelAspecto = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAspectos = new JTable();
        this.JBTSiguiente = new JButton();
        this.JBTImprimir = new JButton();
        this.JBTSiguiente1 = new JButton();
        this.JPIAspectosII = new JPanel();
        this.JBTAceptar = new JButton();
        this.jPanel11 = new JPanel();
        this.JRBPerfilSI = new JRadioButton();
        this.JRBPerfilNO = new JRadioButton();
        this.jLabel132 = new JLabel();
        this.JRBEspiroSI = new JRadioButton();
        this.JRBEspiroNO = new JRadioButton();
        this.jLabel133 = new JLabel();
        this.JRBVisiometriaSI = new JRadioButton();
        this.JRBVIsiometriaNO = new JRadioButton();
        this.jLabel134 = new JLabel();
        this.jLabel135 = new JLabel();
        this.jLabel136 = new JLabel();
        this.JRBAudiometriaSI = new JRadioButton();
        this.JRBAudiometriaNO = new JRadioButton();
        this.JRBLumbarSI = new JRadioButton();
        this.JRBLumbarNO = new JRadioButton();
        this.jLabel137 = new JLabel();
        this.JCHBAudiometria = new JCheckBox();
        this.JCHBVisiometria = new JCheckBox();
        this.JCHBEspirometria = new JCheckBox();
        this.JCHBPerfilLipidico = new JCheckBox();
        this.jLabel138 = new JLabel();
        this.JCHBResonanciaLumbar = new JCheckBox();
        this.jLabel139 = new JLabel();
        this.JCHBResonanciaHombro = new JCheckBox();
        this.JRBHombroSI = new JRadioButton();
        this.JRBHombroNO = new JRadioButton();
        this.JCHBRxTorax = new JCheckBox();
        this.jLabel140 = new JLabel();
        this.JRBRxTorax = new JRadioButton();
        this.JRBRxToraxNO = new JRadioButton();
        this.JCHBPsicosensometrica = new JCheckBox();
        this.jLabel141 = new JLabel();
        this.JRBPsicosensometricaSI = new JRadioButton();
        this.JRBPsicosensometricaNO = new JRadioButton();
        this.JCHBAlcoholimetria = new JCheckBox();
        this.jLabel142 = new JLabel();
        this.JRBAlcoholimetriaSI = new JRadioButton();
        this.JRBAlcoholimetriaNO = new JRadioButton();
        this.JCHBSustancias = new JCheckBox();
        this.jLabel143 = new JLabel();
        this.JRBSustanciasSI = new JRadioButton();
        this.JRBSustanciasNO = new JRadioButton();
        this.JCHBElectrocardiograma = new JCheckBox();
        this.jLabel144 = new JLabel();
        this.JRBElectrocardiogramaSI = new JRadioButton();
        this.JRBElectrocardiogramaNO = new JRadioButton();
        this.jLabel145 = new JLabel();
        this.JCHBPsicologica = new JCheckBox();
        this.JRBPsicologiaSI = new JRadioButton();
        this.JRBPsicologicaNO = new JRadioButton();
        this.jLabel146 = new JLabel();
        this.jLabel147 = new JLabel();
        this.jLabel148 = new JLabel();
        this.jLabel149 = new JLabel();
        this.jLabel150 = new JLabel();
        this.jPanel12 = new JPanel();
        this.jLabel151 = new JLabel();
        this.jLabel152 = new JLabel();
        this.jLabel153 = new JLabel();
        this.jLabel154 = new JLabel();
        this.jLabel155 = new JLabel();
        this.jLabel156 = new JLabel();
        this.jLabel157 = new JLabel();
        this.jLabel158 = new JLabel();
        this.jLabel159 = new JLabel();
        this.JCHBMecanico = new JCheckBox();
        this.JCHBLocativo = new JCheckBox();
        this.JCHBVial = new JCheckBox();
        this.JCHBErgonomico = new JCheckBox();
        this.Psicosocial = new JCheckBox();
        this.JCHBQuimico = new JCheckBox();
        this.JCHBFisico = new JCheckBox();
        this.JCHBTareas = new JCheckBox();
        this.JTFObservacionRiesgo = new JTextField();
        this.JTFOtrosRiesgos = new JTextField();
        this.jLabel33 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("DECLARACIÓN DE CONDICIÓN Y ANTECEDENTES DE SALUD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifDeclaracionSalud");
        addInternalFrameListener(new InternalFrameListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFDeclaracionSalud.this.formInternalFrameClosing(evt);
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
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 181, 32767));
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIAspectosI.setName("jifdeclaracions");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTAspectos.setFont(new Font("Arial", 1, 12));
        this.JTAspectos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTAspectos.setColumnSelectionAllowed(true);
        this.JTAspectos.setRowHeight(65);
        this.JTAspectos.setSelectionBackground(Color.white);
        this.JTAspectos.setSelectionForeground(new Color(255, 0, 0));
        this.JTAspectos.setSelectionMode(0);
        this.JTAspectos.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.2
            public void mouseClicked(MouseEvent evt) {
                JIFDeclaracionSalud.this.JTAspectosMouseClicked(evt);
            }
        });
        this.JTAspectos.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.3
            public void keyPressed(KeyEvent evt) {
                JIFDeclaracionSalud.this.JTAspectosKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTAspectos);
        this.JTAspectos.getColumnModel().getSelectionModel().setSelectionMode(1);
        this.JBTSiguiente.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_siguente.png")));
        this.JBTSiguiente.setText("SIGUIENTE");
        this.JBTSiguiente.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.4
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JBTSiguienteActionPerformed(evt);
            }
        });
        this.JBTImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTImprimir.setText("IMPRIMIR");
        this.JBTImprimir.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.5
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JBTImprimirActionPerformed(evt);
            }
        });
        this.JBTSiguiente1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBTSiguiente1.setText("NUEVO");
        this.JBTSiguiente1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.6
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JBTSiguiente1ActionPerformed(evt);
            }
        });
        GroupLayout JPanelAspectoLayout = new GroupLayout(this.JPanelAspecto);
        this.JPanelAspecto.setLayout(JPanelAspectoLayout);
        JPanelAspectoLayout.setHorizontalGroup(JPanelAspectoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelAspectoLayout.createSequentialGroup().addContainerGap().addGroup(JPanelAspectoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelAspectoLayout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 1232, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPanelAspectoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JBTSiguiente1, -2, 197, -2).addGap(18, 18, 18).addComponent(this.JBTImprimir, -2, 197, -2).addGap(18, 18, 18).addComponent(this.JBTSiguiente, -2, 197, -2).addGap(272, 272, 272)))));
        JPanelAspectoLayout.setVerticalGroup(JPanelAspectoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelAspectoLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 539, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 93, 32767).addGroup(JPanelAspectoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTSiguiente1, -2, 48, -2).addComponent(this.JBTImprimir, -2, 48, -2).addComponent(this.JBTSiguiente, -2, 48, -2)).addGap(58, 58, 58)));
        GroupLayout JPIAspectosILayout = new GroupLayout(this.JPIAspectosI);
        this.JPIAspectosI.setLayout(JPIAspectosILayout);
        JPIAspectosILayout.setHorizontalGroup(JPIAspectosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAspectosILayout.createSequentialGroup().addContainerGap().addComponent(this.JPanelAspecto, -1, -1, 32767).addContainerGap()));
        JPIAspectosILayout.setVerticalGroup(JPIAspectosILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAspectosILayout.createSequentialGroup().addContainerGap().addComponent(this.JPanelAspecto, -2, -1, -2).addContainerGap(21, 32767)));
        this.JTPDatos.addTab("ASOECTOS DECLARADOS BAJO JURAMENTO I", this.JPIAspectosI);
        this.JBTAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTAceptar.setText("ACEPTAR");
        this.JBTAceptar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.7
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JBTAceptarActionPerformed(evt);
            }
        });
        this.jPanel11.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "AUTORIZACIÓN", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.buttonGroup50.add(this.JRBPerfilSI);
        this.JRBPerfilSI.setText("Si");
        this.buttonGroup50.add(this.JRBPerfilNO);
        this.JRBPerfilNO.setText("No");
        this.jLabel132.setFont(new Font("Arial", 0, 14));
        this.jLabel132.setText("Espirometría");
        this.buttonGroup49.add(this.JRBEspiroSI);
        this.JRBEspiroSI.setText("Si");
        this.JRBEspiroSI.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.8
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JRBEspiroSIActionPerformed(evt);
            }
        });
        this.buttonGroup49.add(this.JRBEspiroNO);
        this.JRBEspiroNO.setText("No");
        this.jLabel133.setFont(new Font("Arial", 0, 14));
        this.jLabel133.setText("Visiometría");
        this.buttonGroup48.add(this.JRBVisiometriaSI);
        this.JRBVisiometriaSI.setText("Si");
        this.buttonGroup48.add(this.JRBVIsiometriaNO);
        this.JRBVIsiometriaNO.setText("No");
        this.jLabel134.setFont(new Font("Arial", 0, 14));
        this.jLabel134.setText("Audiometría");
        this.jLabel135.setFont(new Font("Arial", 0, 14));
        this.jLabel135.setText("Aplica");
        this.jLabel136.setFont(new Font("Arial", 0, 14));
        this.jLabel136.setText("Perfil lipídico - glicemia");
        this.buttonGroup47.add(this.JRBAudiometriaSI);
        this.JRBAudiometriaSI.setText("Si");
        this.buttonGroup47.add(this.JRBAudiometriaNO);
        this.JRBAudiometriaNO.setText("No");
        this.buttonGroup51.add(this.JRBLumbarSI);
        this.JRBLumbarSI.setText("Si");
        this.buttonGroup51.add(this.JRBLumbarNO);
        this.JRBLumbarNO.setText("No");
        this.jLabel137.setFont(new Font("Arial", 0, 14));
        this.jLabel137.setText("Tipo de Examen");
        this.JCHBAudiometria.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.9
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBAudiometriaActionPerformed(evt);
            }
        });
        this.JCHBVisiometria.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.10
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBVisiometriaActionPerformed(evt);
            }
        });
        this.JCHBEspirometria.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.11
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBEspirometriaActionPerformed(evt);
            }
        });
        this.JCHBPerfilLipidico.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.12
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBPerfilLipidicoActionPerformed(evt);
            }
        });
        this.jLabel138.setFont(new Font("Arial", 0, 14));
        this.jLabel138.setText("Resonancia Magnética computarizada de columna lumbar");
        this.JCHBResonanciaLumbar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.13
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBResonanciaLumbarActionPerformed(evt);
            }
        });
        this.jLabel139.setFont(new Font("Arial", 0, 14));
        this.jLabel139.setText("Resonancia Magnética computarizada de hombro (dominante)");
        this.JCHBResonanciaHombro.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.14
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBResonanciaHombroActionPerformed(evt);
            }
        });
        this.buttonGroup53.add(this.JRBHombroSI);
        this.JRBHombroSI.setText("Si");
        this.buttonGroup53.add(this.JRBHombroNO);
        this.JRBHombroNO.setText("No");
        this.JCHBRxTorax.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.15
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBRxToraxActionPerformed(evt);
            }
        });
        this.jLabel140.setFont(new Font("Arial", 0, 14));
        this.jLabel140.setText("Rx de tórax");
        this.buttonGroup54.add(this.JRBRxTorax);
        this.JRBRxTorax.setText("Si");
        this.buttonGroup54.add(this.JRBRxToraxNO);
        this.JRBRxToraxNO.setText("No");
        this.JCHBPsicosensometrica.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.16
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBPsicosensometricaActionPerformed(evt);
            }
        });
        this.jLabel141.setFont(new Font("Arial", 0, 14));
        this.jLabel141.setText("Prueba psicosensometríca");
        this.buttonGroup55.add(this.JRBPsicosensometricaSI);
        this.JRBPsicosensometricaSI.setText("Si");
        this.buttonGroup55.add(this.JRBPsicosensometricaNO);
        this.JRBPsicosensometricaNO.setText("No");
        this.JCHBAlcoholimetria.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.17
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBAlcoholimetriaActionPerformed(evt);
            }
        });
        this.jLabel142.setFont(new Font("Arial", 0, 14));
        this.jLabel142.setText("Alcoholimetría");
        this.buttonGroup56.add(this.JRBAlcoholimetriaSI);
        this.JRBAlcoholimetriaSI.setText("Si");
        this.buttonGroup56.add(this.JRBAlcoholimetriaNO);
        this.JRBAlcoholimetriaNO.setText("No");
        this.JCHBSustancias.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.18
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBSustanciasActionPerformed(evt);
            }
        });
        this.jLabel143.setFont(new Font("Arial", 0, 14));
        this.jLabel143.setText("Pruebas de sustancias Psicoactivas");
        this.buttonGroup57.add(this.JRBSustanciasSI);
        this.JRBSustanciasSI.setText("Si");
        this.buttonGroup57.add(this.JRBSustanciasNO);
        this.JRBSustanciasNO.setText("No");
        this.JCHBElectrocardiograma.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.19
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBElectrocardiogramaActionPerformed(evt);
            }
        });
        this.jLabel144.setFont(new Font("Arial", 0, 14));
        this.jLabel144.setText("Electrocardiograma");
        this.buttonGroup58.add(this.JRBElectrocardiogramaSI);
        this.JRBElectrocardiogramaSI.setText("Si");
        this.buttonGroup58.add(this.JRBElectrocardiogramaNO);
        this.JRBElectrocardiogramaNO.setText("No");
        this.jLabel145.setFont(new Font("Arial", 0, 14));
        this.jLabel145.setText("Valoración Psicológica");
        this.JCHBPsicologica.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.20
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBPsicologicaActionPerformed(evt);
            }
        });
        this.buttonGroup59.add(this.JRBPsicologiaSI);
        this.JRBPsicologiaSI.setText("Si");
        this.buttonGroup59.add(this.JRBPsicologicaNO);
        this.JRBPsicologicaNO.setText("No");
        this.jLabel146.setFont(new Font("Arial", 0, 14));
        this.jLabel146.setText("Aplica");
        this.jLabel147.setFont(new Font("Arial", 0, 14));
        this.jLabel147.setText("Tipo de Examen");
        this.jLabel148.setFont(new Font("Arial", 0, 14));
        this.jLabel148.setText("Por lo anterior, doy mi consentimiento previo, libre e informado sobre los exámenes médicos que me deben practicar y autorizo al médico empresarial para que tenga conocimiento de estos");
        this.jLabel149.setFont(new Font("Arial", 0, 14));
        this.jLabel149.setText("con el fin de evaluar si mis condiciones de salud son o no compatibles con el cargo al cual estoy aspirando.");
        this.jLabel150.setFont(new Font("Arial", 0, 14));
        this.jLabel150.setText("Autorizo la practica de los siguentes exámenes médicos.");
        GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
        this.jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel149, -1, -1, 32767).addComponent(this.jLabel150, -1, -1, 32767).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel148, -1, 1214, 32767).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel135, -2, 54, -2).addComponent(this.JCHBRxTorax).addComponent(this.JCHBPsicosensometrica).addComponent(this.JCHBResonanciaHombro).addComponent(this.JCHBResonanciaLumbar).addComponent(this.JCHBEspirometria).addComponent(this.JCHBPerfilLipidico)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel140, -2, 93, -2).addComponent(this.jLabel141, -2, 181, -2).addComponent(this.jLabel139).addComponent(this.jLabel138, -2, 372, -2).addComponent(this.jLabel132).addComponent(this.jLabel136, -2, 155, -2).addComponent(this.jLabel137, -2, 119, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JRBPsicosensometricaSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPsicosensometricaNO)).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addComponent(this.JRBRxTorax).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBRxToraxNO)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JRBLumbarSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBLumbarNO)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JRBHombroSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBHombroNO)).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBEspiroSI).addComponent(this.JRBPerfilSI)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBEspiroNO).addComponent(this.JRBPerfilNO)))).addGap(114, 114, 114).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBPsicologica, GroupLayout.Alignment.TRAILING).addComponent(this.JCHBElectrocardiograma, GroupLayout.Alignment.TRAILING).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHBAlcoholimetria).addComponent(this.JCHBSustancias, GroupLayout.Alignment.TRAILING)).addComponent(this.JCHBAudiometria).addComponent(this.JCHBVisiometria)).addGap(36, 36, 36).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel145, -2, 201, -2).addComponent(this.jLabel144, -2, 228, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JRBPsicologiaSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPsicologicaNO)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JRBElectrocardiogramaSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBElectrocardiogramaNO)))).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addComponent(this.jLabel143).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSustanciasSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSustanciasNO)).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JRBVisiometriaSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBVIsiometriaNO)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JRBAudiometriaSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAudiometriaNO)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JRBAlcoholimetriaSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAlcoholimetriaNO)))))).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jLabel146, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel134).addComponent(this.jLabel147, -2, 119, -2).addComponent(this.jLabel133).addComponent(this.jLabel142, -2, 113, -2)))).addGap(0, 0, 32767))).addContainerGap()))));
        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel148).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel149).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel150).addGap(20, 20, 20).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel146).addComponent(this.jLabel147).addComponent(this.jLabel137).addComponent(this.jLabel135)).addGap(155, 155, 155).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel143).addComponent(this.JCHBSustancias))).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSustanciasSI).addComponent(this.JRBSustanciasNO)).addGap(7, 7, 7))).addGap(14, 14, 14).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JCHBElectrocardiograma).addGap(29, 29, 29)).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jLabel144).addGap(18, 18, 18))).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBElectrocardiogramaSI).addComponent(this.JRBElectrocardiogramaNO)).addGap(36, 36, 36))).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPsicologiaSI).addComponent(this.JRBPsicologicaNO).addComponent(this.jLabel145)).addComponent(this.JCHBPsicologica)).addGap(4, 4, 4)).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEspiroSI).addComponent(this.JRBEspiroNO)).addGap(18, 18, 18).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPerfilNO).addComponent(this.JRBPerfilSI)).addGap(27, 27, 27).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBLumbarSI).addComponent(this.JRBLumbarNO)).addGap(18, 18, 18).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBHombroSI).addComponent(this.JRBHombroNO))).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel134).addComponent(this.JRBAudiometriaSI).addComponent(this.JRBAudiometriaNO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel133).addComponent(this.JRBVisiometriaSI).addComponent(this.JRBVIsiometriaNO))).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.JCHBAudiometria).addGap(18, 18, 18).addComponent(this.JCHBVisiometria))).addGap(15, 15, 15).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAlcoholimetria).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel142).addComponent(this.JRBAlcoholimetriaSI).addComponent(this.JRBAlcoholimetriaNO))))).addGroup(jPanel11Layout.createSequentialGroup().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel11Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JCHBEspirometria).addGap(27, 27, 27).addComponent(this.JCHBPerfilLipidico)).addGroup(jPanel11Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel132).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel136, -2, 24, -2))).addGap(26, 26, 26).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel138).addComponent(this.JCHBResonanciaLumbar)).addGap(29, 29, 29).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel139).addComponent(this.JCHBResonanciaHombro)))).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addGap(22, 22, 22).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel140).addComponent(this.JCHBRxTorax)).addGap(25, 25, 25)).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBRxTorax).addComponent(this.JRBRxToraxNO)).addGap(18, 18, 18))).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel141).addComponent(this.JRBPsicosensometricaSI).addComponent(this.JRBPsicosensometricaNO)).addComponent(this.JCHBPsicosensometrica)))).addContainerGap(15, 32767)));
        this.jPanel12.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "DEFINICION DE RIESGOS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.jLabel151.setFont(new Font("Arial", 0, 14));
        this.jLabel151.setText("Tipo de Riesgo");
        this.jLabel152.setFont(new Font("Arial", 0, 14));
        this.jLabel152.setText("Mecánico");
        this.jLabel153.setFont(new Font("Arial", 0, 14));
        this.jLabel153.setText("Ergonómico o biomecánico");
        this.jLabel154.setFont(new Font("Arial", 0, 14));
        this.jLabel154.setText("Químico (sustancias químicas, material particulado, etc)");
        this.jLabel155.setFont(new Font("Arial", 0, 14));
        this.jLabel155.setText("Psicosocial");
        this.jLabel156.setFont(new Font("Arial", 0, 14));
        this.jLabel156.setText("Locativo");
        this.jLabel157.setFont(new Font("Arial", 0, 14));
        this.jLabel157.setText("Vial");
        this.jLabel158.setFont(new Font("Arial", 0, 14));
        this.jLabel158.setText("Tareas de alto riesgo (alturas, espacio confinado, energías peligrosas, buceo y trabajo en caliente");
        this.jLabel159.setFont(new Font("Arial", 0, 14));
        this.jLabel159.setText("Físico (ruido/iluminacion/vibracion, entre otros:");
        this.JCHBMecanico.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.21
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBMecanicoActionPerformed(evt);
            }
        });
        this.JCHBLocativo.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.22
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBLocativoActionPerformed(evt);
            }
        });
        this.JCHBVial.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.23
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBVialActionPerformed(evt);
            }
        });
        this.JCHBErgonomico.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.24
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBErgonomicoActionPerformed(evt);
            }
        });
        this.Psicosocial.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.25
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.PsicosocialActionPerformed(evt);
            }
        });
        this.JCHBQuimico.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.26
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBQuimicoActionPerformed(evt);
            }
        });
        this.JCHBFisico.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.27
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBFisicoActionPerformed(evt);
            }
        });
        this.JCHBTareas.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.28
            public void actionPerformed(ActionEvent evt) {
                JIFDeclaracionSalud.this.JCHBTareasActionPerformed(evt);
            }
        });
        this.JTFObservacionRiesgo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Observaciones: Detallar equipos a operar y los medios de transporte a utilizar", 0, 0, new Font("Arial", 0, 14), Color.blue));
        this.JTFOtrosRiesgos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Otros", 0, 0, new Font("Dialog", 0, 12), Color.blue));
        GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
        this.jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup().addComponent(this.jLabel151, -2, 928, -2).addGap(0, 0, 32767)).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup().addComponent(this.JTFObservacionRiesgo, -2, 530, -2).addGap(18, 18, 18).addComponent(this.JTFOtrosRiesgos)).addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addComponent(this.jLabel152, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBMecanico).addGap(45, 45, 45).addComponent(this.jLabel156, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBLocativo)).addGroup(jPanel12Layout.createSequentialGroup().addGap(289, 289, 289).addComponent(this.jLabel157, -2, 38, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBVial).addGap(39, 39, 39).addComponent(this.jLabel153).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBErgonomico).addGap(18, 18, 18).addComponent(this.jLabel155).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Psicosocial).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel159).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBFisico)).addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup().addComponent(this.jLabel154).addGap(18, 18, 18).addComponent(this.JCHBQuimico).addGap(18, 18, 18).addComponent(this.jLabel158, -2, 632, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHBTareas))).addGap(0, 63, 32767))))).addContainerGap(79, 32767)));
        jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel151).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel12Layout.createSequentialGroup().addGap(24, 24, 24).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBMecanico, -1, -1, 32767).addComponent(this.jLabel152, -1, -1, 32767).addComponent(this.jLabel156, -1, -1, 32767).addComponent(this.JCHBLocativo, -1, -1, 32767).addComponent(this.jLabel157, -1, -1, 32767).addComponent(this.JCHBVial, -1, -1, 32767).addComponent(this.JCHBErgonomico, -1, -1, 32767).addComponent(this.Psicosocial, -1, -1, 32767).addComponent(this.jLabel153, -1, -1, 32767).addComponent(this.jLabel155, -1, -1, 32767).addGroup(jPanel12Layout.createSequentialGroup().addComponent(this.JCHBFisico).addGap(0, 0, 32767)))).addGroup(jPanel12Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLabel159, -1, -1, 32767))).addGap(36, 36, 36).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHBQuimico, -1, -1, 32767).addComponent(this.jLabel154, -1, -1, 32767)).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHBTareas, -1, -1, 32767).addComponent(this.jLabel158, -2, 24, -2))).addGap(18, 18, 18).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFObservacionRiesgo).addComponent(this.JTFOtrosRiesgos)).addGap(33, 33, 33)));
        GroupLayout JPIAspectosIILayout = new GroupLayout(this.JPIAspectosII);
        this.JPIAspectosII.setLayout(JPIAspectosIILayout);
        JPIAspectosIILayout.setHorizontalGroup(JPIAspectosIILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAspectosIILayout.createSequentialGroup().addGroup(JPIAspectosIILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAspectosIILayout.createSequentialGroup().addGap(497, 497, 497).addComponent(this.JBTAceptar, -2, 177, -2)).addGroup(JPIAspectosIILayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel12, -2, -1, -2)).addGroup(JPIAspectosIILayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel11, -2, -1, -2))).addContainerGap(14, 32767)));
        JPIAspectosIILayout.setVerticalGroup(JPIAspectosIILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAspectosIILayout.createSequentialGroup().addContainerGap(12, 32767).addComponent(this.jPanel12, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel11, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAceptar, -2, 49, -2).addContainerGap()));
        this.JTPDatos.addTab("ASPECTOS DECLARADOS BAJO JURAMENTO II", this.JPIAspectosII);
        this.jLabel33.setFont(new Font("Arial", 0, 14));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel33).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 1258, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(542, 32767).addComponent(this.jLabel33).addGap(284, 284, 284)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 798, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.panelPersona, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelPersona, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFDeclaracionSalud.29
            public void mouseClicked(MouseEvent e) {
                JIFDeclaracionSalud.this.JTDetalleMouseClicked(e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBPsicologicaActionPerformed(ActionEvent evt) {
        if (!this.JCHBPsicologica.isSelected()) {
            this.JRBPsicologiaSI.setEnabled(false);
            this.JRBPsicologicaNO.setEnabled(false);
        } else {
            this.JRBPsicologiaSI.setEnabled(true);
            this.JRBPsicologicaNO.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBElectrocardiogramaActionPerformed(ActionEvent evt) {
        if (!this.JCHBElectrocardiograma.isSelected()) {
            this.JRBElectrocardiogramaSI.setEnabled(false);
            this.JRBElectrocardiogramaNO.setEnabled(false);
        } else {
            this.JRBElectrocardiogramaSI.setEnabled(true);
            this.JRBElectrocardiogramaNO.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBSustanciasActionPerformed(ActionEvent evt) {
        if (!this.JCHBSustancias.isSelected()) {
            this.JRBSustanciasNO.setEnabled(false);
            this.JRBSustanciasSI.setEnabled(false);
        } else {
            this.JRBSustanciasNO.setEnabled(true);
            this.JRBSustanciasSI.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAlcoholimetriaActionPerformed(ActionEvent evt) {
        if (!this.JCHBAlcoholimetria.isSelected()) {
            this.JRBAlcoholimetriaNO.setEnabled(false);
            this.JRBAlcoholimetriaSI.setEnabled(false);
        } else {
            this.JRBAlcoholimetriaNO.setEnabled(true);
            this.JRBAlcoholimetriaSI.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBPsicosensometricaActionPerformed(ActionEvent evt) {
        if (!this.JCHBPsicosensometrica.isSelected()) {
            this.JRBPsicosensometricaNO.setEnabled(false);
            this.JRBPsicosensometricaSI.setEnabled(false);
        } else {
            this.JRBPsicosensometricaSI.setEnabled(true);
            this.JRBPsicosensometricaNO.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBRxToraxActionPerformed(ActionEvent evt) {
        if (!this.JCHBRxTorax.isSelected()) {
            this.JRBRxTorax.setEnabled(false);
            this.JRBRxToraxNO.setEnabled(false);
        } else {
            this.JRBRxTorax.setEnabled(true);
            this.JRBRxToraxNO.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBResonanciaHombroActionPerformed(ActionEvent evt) {
        if (!this.JCHBResonanciaHombro.isSelected()) {
            this.JRBHombroNO.setEnabled(false);
            this.JRBHombroSI.setEnabled(false);
        } else {
            this.JRBHombroNO.setEnabled(true);
            this.JRBHombroSI.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBResonanciaLumbarActionPerformed(ActionEvent evt) {
        if (!this.JCHBResonanciaLumbar.isSelected()) {
            this.JRBLumbarNO.setEnabled(false);
            this.JRBLumbarSI.setEnabled(false);
        } else {
            this.JRBLumbarNO.setEnabled(true);
            this.JRBLumbarSI.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBPerfilLipidicoActionPerformed(ActionEvent evt) {
        if (!this.JCHBPerfilLipidico.isSelected()) {
            this.JRBPerfilNO.setEnabled(false);
            this.JRBPerfilSI.setEnabled(false);
        } else {
            this.JRBPerfilNO.setEnabled(true);
            this.JRBPerfilSI.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEspirometriaActionPerformed(ActionEvent evt) {
        if (!this.JCHBEspirometria.isSelected()) {
            this.JRBEspiroNO.setEnabled(false);
            this.JRBEspiroSI.setEnabled(false);
        } else {
            this.JRBEspiroNO.setEnabled(true);
            this.JRBEspiroSI.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVisiometriaActionPerformed(ActionEvent evt) {
        if (!this.JCHBVisiometria.isSelected()) {
            this.JRBVisiometriaSI.setEnabled(false);
            this.JRBVIsiometriaNO.setEnabled(false);
        } else {
            this.JRBVisiometriaSI.setEnabled(true);
            this.JRBVIsiometriaNO.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAudiometriaActionPerformed(ActionEvent evt) {
        if (!this.JCHBAudiometria.isSelected()) {
            this.JRBAudiometriaNO.setEnabled(false);
            this.JRBAudiometriaSI.setEnabled(false);
        } else {
            this.JRBAudiometriaNO.setEnabled(true);
            this.JRBAudiometriaSI.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAceptarActionPerformed(ActionEvent evt) {
        grabar();
        datosSensibles();
        inicializarVariables();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAspectosMouseClicked(MouseEvent evt) {
        String newValue;
        int columnClic = this.JTAspectos.columnAtPoint(evt.getPoint());
        if (columnClic == 1) {
            String currentValue = (String) this.model.getValueAt(this.JTAspectos.getSelectedRow(), 1);
            if (currentValue != null && !currentValue.isEmpty() && currentValue.equals("NO")) {
                newValue = "SI";
            } else {
                newValue = "NO";
            }
            this.model.setValueAt(newValue, this.JTAspectos.getSelectedRow(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSiguienteActionPerformed(ActionEvent evt) {
        this.JTPDatos.setSelectedIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBMecanicoActionPerformed(ActionEvent evt) {
        if (this.JCHBMecanico.isSelected()) {
            this.rMecanico = "SI";
        } else {
            this.rMecanico = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBLocativoActionPerformed(ActionEvent evt) {
        if (this.JCHBLocativo.isSelected()) {
            this.rLocativo = "SI";
        } else {
            this.rLocativo = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBVialActionPerformed(ActionEvent evt) {
        if (this.JCHBVial.isSelected()) {
            this.rVial = "SI";
        } else {
            this.rVial = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBErgonomicoActionPerformed(ActionEvent evt) {
        if (this.JCHBErgonomico.isSelected()) {
            this.rErgonomico = "SI";
        } else {
            this.rErgonomico = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PsicosocialActionPerformed(ActionEvent evt) {
        if (this.Psicosocial.isSelected()) {
            this.rPsicosocial = "SI";
        } else {
            this.rPsicosocial = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBQuimicoActionPerformed(ActionEvent evt) {
        if (this.JCHBQuimico.isSelected()) {
            this.rQuimico = "SI";
        } else {
            this.rQuimico = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBFisicoActionPerformed(ActionEvent evt) {
        if (this.JCHBFisico.isSelected()) {
            this.rFisico = "SI";
        } else {
            this.rFisico = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBTareasActionPerformed(ActionEvent evt) {
        if (this.JCHBTareas.isSelected()) {
            this.rTareas = "SI";
        } else {
            this.rTareas = "NO";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAspectosKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspiroSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImprimirActionPerformed(ActionEvent evt) {
        imprimir(Long.valueOf(Long.parseLong(Principal.txtNo.getText())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSiguiente1ActionPerformed(ActionEvent evt) {
        nuevo();
    }

    private void cargarPanelPersona() {
        if (this.frmPersona == null) {
            this.frmPersona = new Persona(this);
        }
        this.frmPersona.setVisible(true);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 1190, 500);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.txtHistoria.requestFocus();
    }

    public void buscarIngreso() {
        if (this.frmPersona.getIdPersona() == null || this.frmPersona.getIdPersona().equals("")) {
            this.metodos.mostrarMensaje("Debe estar seleccionado un Usuario");
            return;
        }
        this.frmBuscarI = new BuscarIngreso((Frame) null, true, this);
        this.frmBuscarI.setLocationRelativeTo(this);
        this.frmBuscarI.setVisible(true);
    }

    public void cargarConsentimiento(Integer ingreso, String cargo, String ciudad) {
        String nombre = this.frmPersona.getNombre1() + " " + this.frmPersona.getNombre2() + " " + this.frmPersona.getApellido1() + " " + this.frmPersona.getApellido2();
        String numeroDoc = this.frmPersona.getIdentificacion();
        JDAccederDeclaracionSalud declaracion = new JDAccederDeclaracionSalud(new JFrame(), true, this, cargo, nombre, numeroDoc, ciudad, ingreso);
        declaracion.setLocationRelativeTo(this);
        declaracion.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTabla() {
        this.model = new DefaultTableModel(new Object[0], new String[]{"Pregunta", "Respuesta", "Observación", "Tipo de Respuesta", "idPregunta"}) { // from class: Salud_Ocupacional.JIFDeclaracionSalud.30
            Class[] types = {String.class, String.class, String.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTAspectos;
        JTable jTable2 = this.JTAspectos;
        jTable.setAutoResizeMode(0);
        this.JTAspectos.doLayout();
        this.JTAspectos.setModel(this.model);
        this.JTAspectos.getColumnModel().getColumn(0).setPreferredWidth(800);
        this.JTAspectos.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTAspectos.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTAspectos.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTAspectos.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTAspectos.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTAspectos.getColumnModel().getColumn(4).setPreferredWidth(10);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(0);
        this.JTAspectos.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
    }

    public void cargarPreguntas() {
        crearTabla();
        this.model.setRowCount(0);
        this.listPreguntasDetalle = this.preguntasDetalleService.findByEncabezado("2");
        for (HSoPreguntasDetalle preguntaDetalle : this.listPreguntasDetalle) {
            Object[] fila = new Object[5];
            fila[0] = "<html>" + preguntaDetalle.getNbre().replace("\n", "<br>") + "</html>";
            fila[1] = "NO";
            fila[3] = preguntaDetalle.getTipoRespuesta();
            fila[4] = preguntaDetalle.getId();
            this.model.addRow(fila);
        }
    }

    private void grabar() {
        System.out.println("ingreso  -> " + this.idIngreso);
        System.out.println("declaracion  -> " + this.declaracionSalud);
        new HSoDeclaracionSalud();
        HSoDeclaracionSalud ds = this.declaracionSaludService.findByIdIngreso(Long.valueOf(Principal.txtNo.getText()));
        for (int n = 0; n < this.JTAspectos.getRowCount(); n++) {
            HSoDeclaracionSaludDetalle dh = new HSoDeclaracionSaludDetalle();
            String observacion = "";
            if (this.JTAspectos.getValueAt(n, 2) != null) {
                observacion = this.JTAspectos.getValueAt(n, 2).toString();
            }
            dh.setIdDeclaracion(ds);
            dh.setOrden(Integer.valueOf(n));
            dh.setPregunta(Integer.valueOf(Integer.parseInt(this.JTAspectos.getValueAt(n, 4).toString())));
            dh.setRespuesta(this.JTAspectos.getValueAt(n, 1).toString());
            dh.setObservacion(observacion);
            dh.setPadre(0);
            dh.setFechaCreacion(this.metodos.getFechaActual());
            dh.setFechaActualizacion(this.metodos.getFechaActual());
            dh.setUsuarioCreacion(Principal.usuarioSistemaDTO.getLogin());
            dh.setUsuarioActualizacion(Principal.usuarioSistemaDTO.getLogin());
            this.declaracionSaludDetalleService.save(dh);
        }
        grabarDatosTipoRiesgo(ds);
        grabarDatosAutorizacion(ds);
        JOptionPane.showMessageDialog(this, "Registro Guardado exitosamente", "ACEPTADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Aceptar30x30.png"))));
        imprimir(ds.getId());
    }

    private void grabarDatosTipoRiesgo(HSoDeclaracionSalud ds) {
        this.listPreguntasDetalle = this.preguntasDetalleService.findByEncabezado("3");
        if (!this.listPreguntasDetalle.isEmpty()) {
            List<String> preguntasTipoRiesgo = new ArrayList<>();
            List<String> respuestasTipoRiesgo = new ArrayList<>();
            for (HSoPreguntasDetalle preguntaDetalle : this.listPreguntasDetalle) {
                preguntasTipoRiesgo.add(preguntaDetalle.getId().toString());
            }
            respuestasTipoRiesgo.add(this.rMecanico);
            respuestasTipoRiesgo.add(this.rLocativo);
            respuestasTipoRiesgo.add(this.rVial);
            respuestasTipoRiesgo.add(this.rErgonomico);
            respuestasTipoRiesgo.add(this.rPsicosocial);
            respuestasTipoRiesgo.add(this.rFisico);
            respuestasTipoRiesgo.add(this.rQuimico);
            respuestasTipoRiesgo.add(this.rTareas);
            respuestasTipoRiesgo.add(this.JTFObservacionRiesgo.getText());
            respuestasTipoRiesgo.add(this.JTFOtrosRiesgos.getText());
            for (int i = 0; i < preguntasTipoRiesgo.size(); i++) {
                System.out.println(" preguntasTipoRiesgo.size()-> " + preguntasTipoRiesgo.size());
                HSoDeclaracionSaludDetalle dsd = new HSoDeclaracionSaludDetalle();
                System.out.println("tipoRiesgo -> " + preguntasTipoRiesgo.get(i) + ": " + respuestasTipoRiesgo.get(i));
                dsd.setIdDeclaracion(ds);
                dsd.setOrden(99);
                dsd.setRespuesta(respuestasTipoRiesgo.get(i));
                dsd.setPregunta(Integer.valueOf(Integer.parseInt(preguntasTipoRiesgo.get(i))));
                dsd.setPadre(1);
                dsd.setFechaCreacion(this.metodos.getFechaActual());
                dsd.setFechaActualizacion(this.metodos.getFechaActual());
                dsd.setUsuarioCreacion(Principal.usuarioSistemaDTO.getLogin());
                dsd.setUsuarioActualizacion(Principal.usuarioSistemaDTO.getLogin());
                this.declaracionSaludDetalleService.save(dsd);
            }
            return;
        }
        System.out.println("La lista del tipo de riesgo esta vacía");
    }

    private void grabarDatosAutorizacion(HSoDeclaracionSalud ds) {
        this.listPreguntasDetalle = this.preguntasDetalleService.findByEncabezado("4");
        if (!this.listPreguntasDetalle.isEmpty()) {
            List<String> preguntasAutorizacion = new ArrayList<>();
            List<String> respuestasAutorizacion = new ArrayList<>();
            for (HSoPreguntasDetalle preguntaDetalle : this.listPreguntasDetalle) {
                preguntasAutorizacion.add(preguntaDetalle.getId().toString());
            }
            respuestasAutorizacion.add(this.JRBPsicologiaSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBElectrocardiogramaSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBSustanciasSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBAlcoholimetriaSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBPsicosensometricaSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBRxTorax.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBHombroSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBLumbarSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBPerfilSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBEspiroSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBVisiometriaSI.isSelected() ? "SI" : "NO");
            respuestasAutorizacion.add(this.JRBAudiometriaSI.isSelected() ? "SI" : "NO");
            for (int i = 0; i < preguntasAutorizacion.size(); i++) {
                HSoDeclaracionSaludDetalle dsd = new HSoDeclaracionSaludDetalle();
                dsd.setIdDeclaracion(ds);
                dsd.setOrden(99);
                dsd.setRespuesta(respuestasAutorizacion.get(i));
                dsd.setPregunta(Integer.valueOf(Integer.parseInt(preguntasAutorizacion.get(i))));
                dsd.setPadre(2);
                dsd.setFechaCreacion(this.metodos.getFechaActual());
                dsd.setFechaActualizacion(this.metodos.getFechaActual());
                dsd.setUsuarioCreacion(Principal.usuarioSistemaDTO.getLogin());
                dsd.setUsuarioActualizacion(Principal.usuarioSistemaDTO.getLogin());
                this.declaracionSaludDetalleService.save(dsd);
            }
        } else {
            System.out.println("La lista autorizacion esta vacía");
        }
        this.idDeclaracionS = ds;
    }

    public void recibirIngresoDeclaracion(Long i, Long idEcabezado) {
        this.idIngreso = i;
        this.idEncabezado = idEcabezado;
    }

    private void inicializarVariables() {
        this.rMecanico = "NO";
        this.rErgonomico = "NO";
        this.rQuimico = "NO";
        this.rPsicosocial = "NO";
        this.rLocativo = "NO";
        this.rVial = "NO";
        this.rTareas = "NO";
        this.rFisico = "NO";
        this.eAudiometria = "NO";
        this.eVisiometria = "NO";
        this.eEspirometria = "NO";
        this.ePerfil = "NO";
        this.eResonanciaLumbar = "NO";
        this.eResonanciaHombro = "NO";
        this.eRxTorax = "NO";
        this.ePricosensometrica = "NO";
        this.eAlcoholimetria = "NO";
        this.eSustancia = "NO";
        this.eElectrocardiograma = "NO";
        this.ePsicologica = "NO";
        this.tipoRiesgo = "NO";
        this.autorizacion = "NO";
        this.JRBPsicologiaSI.setEnabled(false);
        this.JRBPsicologicaNO.setEnabled(false);
        this.JRBElectrocardiogramaSI.setEnabled(false);
        this.JRBElectrocardiogramaNO.setEnabled(false);
        this.JRBSustanciasNO.setEnabled(false);
        this.JRBSustanciasSI.setEnabled(false);
        this.JRBAlcoholimetriaNO.setEnabled(false);
        this.JRBAlcoholimetriaSI.setEnabled(false);
        this.JRBPsicosensometricaNO.setEnabled(false);
        this.JRBPsicosensometricaSI.setEnabled(false);
        this.JRBRxTorax.setEnabled(false);
        this.JRBRxToraxNO.setEnabled(false);
        this.JRBHombroNO.setEnabled(false);
        this.JRBHombroSI.setEnabled(false);
        this.JRBLumbarNO.setEnabled(false);
        this.JRBLumbarSI.setEnabled(false);
        this.JRBPerfilNO.setEnabled(false);
        this.JRBPerfilSI.setEnabled(false);
        this.JRBEspiroNO.setEnabled(false);
        this.JRBEspiroSI.setEnabled(false);
        this.JRBVisiometriaSI.setEnabled(false);
        this.JRBVIsiometriaNO.setEnabled(false);
        this.JRBAudiometriaNO.setEnabled(false);
        this.JRBAudiometriaSI.setEnabled(false);
        this.JRBPsicologicaNO.setSelected(true);
        this.JRBElectrocardiogramaNO.setSelected(true);
        this.JRBSustanciasNO.setSelected(true);
        this.JRBAlcoholimetriaNO.setSelected(true);
        this.JRBPsicosensometricaNO.setSelected(true);
        this.JRBRxToraxNO.setSelected(true);
        this.JRBHombroNO.setSelected(true);
        this.JRBLumbarNO.setSelected(true);
        this.JRBPerfilNO.setSelected(true);
        this.JRBEspiroNO.setSelected(true);
        this.JRBVIsiometriaNO.setSelected(true);
        this.JRBAudiometriaNO.setSelected(true);
    }

    public void imprimir(Long idDeclaracion) {
        System.out.println("idDeclaracion -> " + idDeclaracion);
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idDeclaracion";
        mparametros[0][1] = String.valueOf(idDeclaracion);
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "DeclaracionDeAntecedentes", mparametros);
        JDDatosSensibles datosSensible = new JDDatosSensibles(null, true, null, null);
        datosSensible.imprimirGuardado(Principal.txtNo.getText());
    }

    private void datosSensibles() {
        JDDatosSensibles datosSensible = new JDDatosSensibles(null, true, Long.valueOf(Principal.txtNo.getText()), this.idDeclaracionS);
        datosSensible.setLocationRelativeTo(this);
        datosSensible.setVisible(true);
    }

    private void nuevo() {
        crearTabla();
        inicializarVariables();
    }
}
