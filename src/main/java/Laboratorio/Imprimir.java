package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/Imprimir.class */
public class Imprimir extends JDialog {
    private Metodos xmt;
    private ConsultasMySQL xct;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo2;
    private int xesremitido;
    private int xresultado;
    private String[][] xidarea;
    private String[][] parametros;
    private String[] xidmunicipio;
    private String[] xidServicios;
    private String xsql;
    private boolean xlleno;
    private String xtipo;
    private Object[] xdatos;
    private List<JCheckBox> checkBoxes;
    private List<String> listSedes;
    private String listSedesSeleccionadas;
    private ButtonGroup JBGAreas;
    private ButtonGroup JBGTPapel;
    private ButtonGroup JBGTipoPlanilla;
    private JButton JBTImprimir;
    private JButton JBTSalir;
    private JComboBox JCBMunicipio;
    private JComboBox JCBTipoServicio;
    private JCheckBox JCHFMunicipio;
    private JCheckBox JCHFTipoAtencion;
    private JCheckBox JCHFTipoAtencion1;
    private JCheckBox JCHPResultado;
    private JCheckBox JCHRemitido;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIArea;
    private JPanel JPIDPeriodo;
    private JPanel JPIFiltroR;
    private JPanel JPIProcedimiento;
    private JPanel JPITamanoP;
    private JPanel JPITipoP;
    private JRadioButton JRBCarta;
    private JRadioButton JRBNormal;
    private JRadioButton JRBNormal1;
    private JRadioButton JRBNormal2;
    private JRadioButton JRBOficio;
    private JScrollPane JSPDetalleA;
    private JScrollPane JSPDetalleExamen;
    public JTable JTBDetalleA;
    public JTable JTBDetalleExamen;
    private JFormattedTextField JTFFNFinal;
    private JFormattedTextField JTFFNInicial;
    private JTextField JTFFalseCombobox;
    private JTextField JTFFiltroNombre;
    private JTabbedPane JTPFiltro;
    private JPopupMenu jPopupMenu1;

    public Imprimir(Frame parent, boolean modal, int Opcion) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xesremitido = 0;
        this.xresultado = 0;
        this.xlleno = false;
        this.xtipo = "0";
        this.listSedesSeleccionadas = "";
        setModalityType(Dialog.ModalityType.MODELESS);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v117, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v81, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGAreas = new ButtonGroup();
        this.JBGTipoPlanilla = new ButtonGroup();
        this.JBGTPapel = new ButtonGroup();
        this.jPopupMenu1 = new JPopupMenu();
        this.JPIDPeriodo = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCHPResultado = new JCheckBox();
        this.JCHRemitido = new JCheckBox();
        this.JPITipoP = new JPanel();
        this.JRBNormal = new JRadioButton();
        this.JRBNormal1 = new JRadioButton();
        this.JRBNormal2 = new JRadioButton();
        this.JCHFMunicipio = new JCheckBox();
        this.JCBMunicipio = new JComboBox();
        this.JCBTipoServicio = new JComboBox();
        this.JCHFTipoAtencion = new JCheckBox();
        this.JTFFalseCombobox = new JTextField();
        this.JBTSalir = new JButton();
        this.JBTImprimir = new JButton();
        this.JTPFiltro = new JTabbedPane();
        this.JPIArea = new JPanel();
        this.JSPDetalleA = new JScrollPane();
        this.JTBDetalleA = new JTable();
        this.JPIFiltroR = new JPanel();
        this.JTFFNInicial = new JFormattedTextField();
        this.JTFFNFinal = new JFormattedTextField();
        this.JPIProcedimiento = new JPanel();
        this.JTFFiltroNombre = new JTextField();
        this.JSPDetalleExamen = new JScrollPane();
        this.JTBDetalleExamen = new JTable();
        this.JPITamanoP = new JPanel();
        this.JRBCarta = new JRadioButton();
        this.JRBOficio = new JRadioButton();
        this.JCHFTipoAtencion1 = new JCheckBox();
        this.jPopupMenu1.setAutoscrolls(true);
        this.jPopupMenu1.setLightWeightPopupEnabled(false);
        this.jPopupMenu1.setRequestFocusEnabled(false);
        setDefaultCloseOperation(2);
        setTitle("IMPRESIÓN PLANILLAS DE TRABAJO");
        setName("Impresion");
        addMouseListener(new MouseAdapter() { // from class: Laboratorio.Imprimir.1
            public void mousePressed(MouseEvent evt) {
                Imprimir.this.formMousePressed(evt);
            }
        });
        addComponentListener(new ComponentAdapter() { // from class: Laboratorio.Imprimir.2
            public void componentMoved(ComponentEvent evt) {
                Imprimir.this.formComponentMoved(evt);
            }
        });
        this.JPIDPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "PERÍODO", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.Imprimir.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Imprimir.this.JDCFechaIPropertyChange(evt);
            }
        });
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.Imprimir.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Imprimir.this.JDCFechaFPropertyChange(evt);
            }
        });
        this.JCHPResultado.setFont(new Font("Arial", 1, 12));
        this.JCHPResultado.setSelected(true);
        this.JCHPResultado.setText("Por resultado?");
        this.JCHPResultado.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.5
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JCHPResultadoActionPerformed(evt);
            }
        });
        this.JCHRemitido.setFont(new Font("Arial", 1, 12));
        this.JCHRemitido.setText("Es remitido?");
        this.JCHRemitido.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.6
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JCHRemitidoActionPerformed(evt);
            }
        });
        this.JPITipoP.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Planillas", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipoPlanilla.add(this.JRBNormal);
        this.JRBNormal.setFont(new Font("Arial", 1, 12));
        this.JRBNormal.setSelected(true);
        this.JRBNormal.setText("Normal");
        this.JRBNormal.setToolTipText("");
        this.JBGTipoPlanilla.add(this.JRBNormal1);
        this.JRBNormal1.setFont(new Font("Arial", 1, 12));
        this.JRBNormal1.setText("Area y Exàmen en  Columnas");
        this.JRBNormal1.setToolTipText("");
        this.JRBNormal1.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.7
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JRBNormal1ActionPerformed(evt);
            }
        });
        this.JBGTipoPlanilla.add(this.JRBNormal2);
        this.JRBNormal2.setFont(new Font("Arial", 1, 12));
        this.JRBNormal2.setText("Exámen y protocolo en Columna");
        this.JRBNormal2.setToolTipText("");
        GroupLayout JPITipoPLayout = new GroupLayout(this.JPITipoP);
        this.JPITipoP.setLayout(JPITipoPLayout);
        JPITipoPLayout.setHorizontalGroup(JPITipoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPLayout.createSequentialGroup().addComponent(this.JRBNormal).addGap(18, 18, 18).addComponent(this.JRBNormal2)).addComponent(this.JRBNormal1)).addContainerGap(-1, 32767)));
        JPITipoPLayout.setVerticalGroup(JPITipoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNormal).addComponent(this.JRBNormal2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNormal1).addContainerGap()));
        this.JCHFMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCHFMunicipio.setText("Visualizar planilla por municipio?");
        this.JCHFMunicipio.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.8
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JCHFMunicipioActionPerformed(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Atencion y/o Servicios", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHFTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.JCHFTipoAtencion.setText("Visualizar planilla por Tipo de Atencion y/o Servicios");
        this.JCHFTipoAtencion.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.9
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JCHFTipoAtencionActionPerformed(evt);
            }
        });
        this.JTFFalseCombobox.setEditable(false);
        this.JTFFalseCombobox.setFont(new Font("Arial", 1, 12));
        this.JTFFalseCombobox.setText("Seleccionar opciones...");
        this.JTFFalseCombobox.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFalseCombobox.setComponentPopupMenu(this.jPopupMenu1);
        this.JTFFalseCombobox.addMouseListener(new MouseAdapter() { // from class: Laboratorio.Imprimir.10
            public void mouseClicked(MouseEvent evt) {
                Imprimir.this.JTFFalseComboboxMouseClicked(evt);
            }

            public void mousePressed(MouseEvent evt) {
                Imprimir.this.JTFFalseComboboxMousePressed(evt);
            }
        });
        GroupLayout JPIDPeriodoLayout = new GroupLayout(this.JPIDPeriodo);
        this.JPIDPeriodo.setLayout(JPIDPeriodoLayout);
        JPIDPeriodoLayout.setHorizontalGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addComponent(this.JCBMunicipio, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoServicio, -2, 352, -2)).addGroup(JPIDPeriodoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDPeriodoLayout.createSequentialGroup().addComponent(this.JCHFMunicipio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFTipoAtencion).addGap(42, 42, 42)).addGroup(JPIDPeriodoLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaF, -2, 120, -2).addGap(18, 18, 18).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHPResultado).addComponent(this.JCHRemitido)).addGap(18, 18, 18).addComponent(this.JPITipoP, -1, -1, 32767).addContainerGap()))).addComponent(this.JTFFalseCombobox));
        JPIDPeriodoLayout.setVerticalGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 55, -2).addComponent(this.JDCFechaF, -2, 55, -2)).addGroup(JPIDPeriodoLayout.createSequentialGroup().addComponent(this.JCHPResultado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHRemitido)))).addGroup(JPIDPeriodoLayout.createSequentialGroup().addComponent(this.JPITipoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFTipoAtencion).addComponent(this.JCHFMunicipio)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMunicipio, -2, -1, -2).addComponent(this.JCBTipoServicio, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFalseCombobox, -2, -1, -2).addContainerGap()));
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.setMaximumSize(new Dimension(107, 41));
        this.JBTSalir.setMinimumSize(new Dimension(107, 41));
        this.JBTSalir.setPreferredSize(new Dimension(107, 41));
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.11
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JBTImprimir.setFont(new Font("Arial", 1, 12));
        this.JBTImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTImprimir.setText("Imprimir");
        this.JBTImprimir.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.12
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JBTImprimirActionPerformed(evt);
            }
        });
        this.JTPFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPFiltro.setForeground(Color.red);
        this.JTPFiltro.setFont(new Font("Arial", 1, 14));
        this.JTPFiltro.addMouseListener(new MouseAdapter() { // from class: Laboratorio.Imprimir.13
            public void mouseClicked(MouseEvent evt) {
                Imprimir.this.JTPFiltroMouseClicked(evt);
            }
        });
        this.JSPDetalleA.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalleA.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleA.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleA.setRowHeight(25);
        this.JTBDetalleA.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleA.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleA.setSelectionMode(0);
        this.JTBDetalleA.addMouseListener(new MouseAdapter() { // from class: Laboratorio.Imprimir.14
            public void mouseClicked(MouseEvent evt) {
                Imprimir.this.JTBDetalleAMouseClicked(evt);
            }
        });
        this.JTBDetalleA.addKeyListener(new KeyAdapter() { // from class: Laboratorio.Imprimir.15
            public void keyPressed(KeyEvent evt) {
                Imprimir.this.JTBDetalleAKeyPressed(evt);
            }
        });
        this.JSPDetalleA.setViewportView(this.JTBDetalleA);
        GroupLayout JPIAreaLayout = new GroupLayout(this.JPIArea);
        this.JPIArea.setLayout(JPIAreaLayout);
        JPIAreaLayout.setHorizontalGroup(JPIAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAreaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleA, -1, 757, 32767).addContainerGap()));
        JPIAreaLayout.setVerticalGroup(JPIAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAreaLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleA, -1, 152, 32767).addContainerGap()));
        this.JTPFiltro.addTab("ÁREA", this.JPIArea);
        this.JTFFNInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNInicial.setFont(new Font("Arial", 1, 12));
        this.JTFFNInicial.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.16
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JTFFNInicialActionPerformed(evt);
            }
        });
        this.JTFFNInicial.addKeyListener(new KeyAdapter() { // from class: Laboratorio.Imprimir.17
            public void keyPressed(KeyEvent evt) {
                Imprimir.this.JTFFNInicialKeyPressed(evt);
            }
        });
        this.JTFFNFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNFinal.setFont(new Font("Arial", 1, 12));
        this.JTFFNFinal.addKeyListener(new KeyAdapter() { // from class: Laboratorio.Imprimir.18
            public void keyPressed(KeyEvent evt) {
                Imprimir.this.JTFFNFinalKeyPressed(evt);
            }
        });
        GroupLayout JPIFiltroRLayout = new GroupLayout(this.JPIFiltroR);
        this.JPIFiltroR.setLayout(JPIFiltroRLayout);
        JPIFiltroRLayout.setHorizontalGroup(JPIFiltroRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroRLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFNInicial, -2, 150, -2).addGap(33, 33, 33).addComponent(this.JTFFNFinal, -2, 150, -2).addContainerGap(430, 32767)));
        JPIFiltroRLayout.setVerticalGroup(JPIFiltroRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroRLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNInicial, -2, 60, -2).addComponent(this.JTFFNFinal, -2, 60, -2)).addContainerGap(103, 32767)));
        this.JTPFiltro.addTab("RECEPCIÓN", this.JPIFiltroR);
        this.JTFFiltroNombre.setFont(new Font("Arial", 1, 12));
        this.JTFFiltroNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Nombre Procedimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFiltroNombre.addKeyListener(new KeyAdapter() { // from class: Laboratorio.Imprimir.19
            public void keyPressed(KeyEvent evt) {
                Imprimir.this.JTFFiltroNombreKeyPressed(evt);
            }
        });
        this.JSPDetalleExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalleExamen.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleExamen.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleExamen.setRowHeight(25);
        this.JTBDetalleExamen.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleExamen.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleExamen.setSelectionMode(0);
        this.JTBDetalleExamen.addMouseListener(new MouseAdapter() { // from class: Laboratorio.Imprimir.20
            public void mouseClicked(MouseEvent evt) {
                Imprimir.this.JTBDetalleExamenMouseClicked(evt);
            }
        });
        this.JTBDetalleExamen.addKeyListener(new KeyAdapter() { // from class: Laboratorio.Imprimir.21
            public void keyPressed(KeyEvent evt) {
                Imprimir.this.JTBDetalleExamenKeyPressed(evt);
            }
        });
        this.JSPDetalleExamen.setViewportView(this.JTBDetalleExamen);
        GroupLayout JPIProcedimientoLayout = new GroupLayout(this.JPIProcedimiento);
        this.JPIProcedimiento.setLayout(JPIProcedimientoLayout);
        JPIProcedimientoLayout.setHorizontalGroup(JPIProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcedimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPIProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleExamen, -1, 757, 32767).addComponent(this.JTFFiltroNombre)).addContainerGap()));
        JPIProcedimientoLayout.setVerticalGroup(JPIProcedimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProcedimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFiltroNombre, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleExamen, -1, 103, 32767).addGap(4, 4, 4)));
        this.JTPFiltro.addTab("PROCEDIMIENTO", this.JPIProcedimiento);
        this.JPITamanoP.setBorder(BorderFactory.createTitledBorder((Border) null, "Tamaño Papel", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTPapel.add(this.JRBCarta);
        this.JRBCarta.setFont(new Font("Arial", 1, 12));
        this.JRBCarta.setSelected(true);
        this.JRBCarta.setText("Carta");
        this.JRBCarta.setToolTipText("");
        this.JRBCarta.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.22
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JRBCartaActionPerformed(evt);
            }
        });
        this.JBGTPapel.add(this.JRBOficio);
        this.JRBOficio.setFont(new Font("Arial", 1, 12));
        this.JRBOficio.setText("Oficio");
        this.JRBOficio.setToolTipText("");
        GroupLayout JPITamanoPLayout = new GroupLayout(this.JPITamanoP);
        this.JPITamanoP.setLayout(JPITamanoPLayout);
        JPITamanoPLayout.setHorizontalGroup(JPITamanoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITamanoPLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBCarta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBOficio).addContainerGap()));
        JPITamanoPLayout.setVerticalGroup(JPITamanoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITamanoPLayout.createSequentialGroup().addContainerGap().addGroup(JPITamanoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCarta).addComponent(this.JRBOficio)).addContainerGap(-1, 32767)));
        this.JCHFTipoAtencion1.setFont(new Font("Arial", 1, 12));
        this.JCHFTipoAtencion1.setText("Seleccionar Todo?");
        this.JCHFTipoAtencion1.addActionListener(new ActionListener() { // from class: Laboratorio.Imprimir.23
            public void actionPerformed(ActionEvent evt) {
                Imprimir.this.JCHFTipoAtencion1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDPeriodo, -1, -1, 32767).addContainerGap()).addComponent(this.JTPFiltro).addGroup(layout.createSequentialGroup().addComponent(this.JBTImprimir, -2, 280, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTSalir, -2, 280, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITamanoP, -1, -1, 32767).addComponent(this.JCHFTipoAtencion1, -1, -1, 32767)).addGap(12, 12, 12)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDPeriodo, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPFiltro, -2, 231, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTImprimir, -2, 60, -2).addComponent(this.JBTSalir, -2, 60, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JPITamanoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFTipoAtencion1))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarDatosModeloA();
            mCargarDatosModelo();
            if (this.JCHFTipoAtencion.isSelected()) {
                mCargarComboServicios();
            } else {
                this.JCBTipoServicio.setSelectedIndex(-1);
            }
            if (this.JCHFMunicipio.isSelected()) {
                mCargarComboMunicipio();
            } else {
                this.JCBMunicipio.setSelectedIndex(-1);
            }
            mCargarComboSede();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarDatosModeloA();
            mCargarDatosModelo();
            if (this.JCHFTipoAtencion.isSelected()) {
                mCargarComboServicios();
            } else {
                this.JCBTipoServicio.setSelectedIndex(-1);
            }
            if (this.JCHFMunicipio.isSelected()) {
                mCargarComboMunicipio();
            } else {
                this.JCBMunicipio.setSelectedIndex(-1);
            }
            mCargarComboSede();
        }
    }

    private void mCargarComboMunicipio() {
        this.JCBMunicipio.removeAllItems();
        String sql = "SELECT  g_municipio.`Id`, `g_municipio`.`Nbre`\nFROM `l_detallerecepcion` \nINNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) \nINNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) \nINNER JOIN  `l_areas`  ON (`g_procedimiento`.`Id_Area` = `l_areas`.`Id`) \nINNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN  `g_municipio`  ON (`g_municipio`.`Id` = `g_persona`.`Id_Municipio`) \nWHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "'  AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "'  AND `l_recepcion`.`Estado` =0 \nAND `g_procedimiento`.`EsRemitido` ='" + this.xesremitido + "') GROUP BY `g_municipio`.`Nbre` ORDER BY `g_municipio`.`Nbre` ASC ";
        this.xidmunicipio = this.xct.llenarCombo(sql, this.xidmunicipio, this.JCBMunicipio);
        this.JCBMunicipio.setSelectedIndex(-1);
    }

    private void mCargarComboSede() {
        try {
            this.jPopupMenu1.removeAll();
            this.checkBoxes = new ArrayList();
            this.listSedes = new ArrayList();
            String sql = "SELECT\n\tgs.Id,\n\tconcat(gs.Nbre,' (',gm.Nbre,')') as sede\nFROM\n\tl_detallerecepcion ld\nINNER JOIN l_recepcion lr on\n\t(ld.Id_Recepcion = lr.Id)\nINNER JOIN g_sedes gs on\n\t(lr.Id_Sede = gs.Id)\nINNER JOIN g_procedimiento gp ON\n\t(ld.Id_Procedim = gp.Id)\nINNER JOIN g_municipio gm  ON\n\t(gs.Id_Municipio = gm.Id )\nWHERE\n\t(DATE_FORMAT(lr.FechaRecep, '%Y-%m-%d') BETWEEN '" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "'\n\t\tAND lr.Estado = 0\n\t\tAND gp.EsRemitido = '" + this.xesremitido + "')\nGROUP BY gs.Id\nORDER BY gs.Nbre ASC";
            ResultSet xrs = this.xct.traerRs(sql);
            mCrearModeloDetalle();
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.listSedes.add(xrs.getString(1).toString());
                    JCheckBox checkBox = new JCheckBox(xrs.getString(2).toString());
                    checkBox.addItemListener(e -> {
                        updateTextField();
                    });
                    this.checkBoxes.add(checkBox);
                    this.jPopupMenu1.add(checkBox);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarComboServicios() {
        this.JCBTipoServicio.removeAllItems();
        String sql = "SELECT\n\t`g_tipoatencion`.`Id`,\n\t`g_tipoatencion`.`Nbre`\nFROM\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n\t(`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n\t(`g_procedimiento`.`Id_Area` = `l_areas`.`Id`)\nINNER JOIN `f_ordenes` ON \n\t(`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN  `ingreso` ON\n\t(`ingreso`.`Id`=`f_ordenes`.`Id_Ingreso`)\ninner JOIN  `g_tipoatencion` ON\n\t(`g_tipoatencion`.`Id`=`ingreso`.`Id_TipoAtencion`)\nWHERE\n\t(DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') >= '" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "'\n\tAND DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') <= '" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "'\n\tAND `l_recepcion`.`Estado` = 0\n\tAND `g_procedimiento`.`EsRemitido` = " + this.xesremitido + ")\nGROUP BY\n\t`g_tipoatencion`.`Nbre`\nORDER BY\n\t`g_tipoatencion`.`Nbre` ASC";
        this.xidServicios = this.xct.llenarCombo(sql, this.xidServicios, this.JCBTipoServicio);
        this.JCBTipoServicio.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRemitidoActionPerformed(ActionEvent evt) {
        if (this.JCHRemitido.isSelected()) {
            this.xesremitido = 1;
        } else {
            this.xesremitido = 0;
        }
        mCargarDatosModeloA();
        mCargarDatosModelo();
        mCargarComboSede();
        this.JTPFiltro.setSelectedIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPResultadoActionPerformed(ActionEvent evt) {
        if (this.JCHPResultado.isSelected()) {
            this.xresultado = 0;
        } else {
            this.xresultado = 1;
        }
        mCargarDatosModeloA();
        mCargarDatosModelo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImprimirActionPerformed(ActionEvent evt) {
        mImprimir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroNombreKeyPressed(KeyEvent evt) {
        mCargarDatosModelo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleExamenMouseClicked(MouseEvent evt) {
        if (this.JTBDetalleExamen.getRowCount() != -1 && this.JTBDetalleExamen.getSelectedRow() != -1) {
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleExamen.getSelectedRow(), 2).toString()).booleanValue()) {
                this.xmodelo1.setValueAt(false, this.JTBDetalleExamen.getSelectedRow(), 2);
            } else {
                this.xmodelo1.setValueAt(true, this.JTBDetalleExamen.getSelectedRow(), 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleExamenKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 32 && this.JTBDetalleExamen.getRowCount() != -1 && this.JTBDetalleExamen.getSelectedRow() != -1) {
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleExamen.getSelectedRow(), 2).toString()).booleanValue()) {
                this.xmodelo1.setValueAt(false, this.JTBDetalleExamen.getSelectedRow(), 2);
            } else {
                this.xmodelo1.setValueAt(true, this.JTBDetalleExamen.getSelectedRow(), 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleAMouseClicked(MouseEvent evt) {
        if (this.JTBDetalleA.getRowCount() != -1 && this.JTBDetalleA.getSelectedRow() != -1) {
            if (Boolean.valueOf(this.xmodelo2.getValueAt(this.JTBDetalleA.getSelectedRow(), 2).toString()).booleanValue()) {
                this.xmodelo2.setValueAt(false, this.JTBDetalleA.getSelectedRow(), 2);
            } else {
                this.xmodelo2.setValueAt(true, this.JTBDetalleA.getSelectedRow(), 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleAKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 32 && this.JTBDetalleA.getRowCount() != -1 && this.JTBDetalleA.getSelectedRow() != -1) {
            if (Boolean.valueOf(this.xmodelo2.getValueAt(this.JTBDetalleA.getSelectedRow(), 2).toString()).booleanValue()) {
                this.xmodelo2.setValueAt(false, this.JTBDetalleA.getSelectedRow(), 2);
            } else {
                this.xmodelo2.setValueAt(true, this.JTBDetalleA.getSelectedRow(), 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNInicialActionPerformed(ActionEvent evt) {
        this.JTFFNInicial.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNFinalKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JBTImprimir.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNInicialKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFNInicial.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPFiltroMouseClicked(MouseEvent evt) {
        if (this.JTPFiltro.getSelectedIndex() == 1) {
            this.JTFFNInicial.requestFocus();
        } else if (this.JTPFiltro.getSelectedIndex() == 2) {
            this.JTFFiltroNombre.requestFocus();
        } else if (this.JTPFiltro.getSelectedIndex() == 0) {
            this.JTBDetalleA.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCartaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNormal1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFMunicipioActionPerformed(ActionEvent evt) {
        if (this.JCHFMunicipio.isSelected()) {
            mCargarComboMunicipio();
        } else {
            this.JCBMunicipio.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFTipoAtencionActionPerformed(ActionEvent evt) {
        if (this.JCHFTipoAtencion.isSelected()) {
            mCargarComboServicios();
        } else {
            this.JCBTipoServicio.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFTipoAtencion1ActionPerformed(ActionEvent evt) {
        if (this.JTPFiltro.getSelectedIndex() == 0) {
            mSeleccionarArea();
        } else if (this.JTPFiltro.getSelectedIndex() == 2) {
            mSeleccionarProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFalseComboboxMouseClicked(MouseEvent evt) {
        togglePopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFalseComboboxMousePressed(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMousePressed(MouseEvent evt) {
        if (!this.JTFFalseCombobox.getBounds().contains(evt.getPoint())) {
            this.jPopupMenu1.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formComponentMoved(ComponentEvent evt) {
        if (this.jPopupMenu1.isVisible()) {
            showPopup();
        }
    }

    private void mSeleccionarProcedimiento() {
        if (this.JTBDetalleExamen.getRowCount() != 0) {
            for (int x = 0; x < this.JTBDetalleExamen.getRowCount(); x++) {
                this.xmodelo1.setValueAt(Boolean.valueOf(this.JCHFTipoAtencion1.isSelected()), x, 2);
            }
        }
    }

    private void mSeleccionarArea() {
        if (this.JTBDetalleA.getRowCount() != 0) {
            for (int x = 0; x < this.JTBDetalleA.getRowCount(); x++) {
                this.xmodelo2.setValueAt(Boolean.valueOf(this.JCHFTipoAtencion1.isSelected()), x, 2);
            }
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.xlleno = true;
        this.JCBMunicipio.setSelectedIndex(-1);
        this.JCBTipoServicio.setSelectedIndex(-1);
        this.JCHFTipoAtencion.setSelected(false);
        this.JCHPResultado.setSelected(true);
        this.JCHRemitido.setSelected(false);
        this.xresultado = 0;
        this.xesremitido = 0;
        mCargarDatosModelo();
        mCargarDatosModeloA();
    }

    private void mImprimir() {
        int selectedIndex = this.JTPFiltro.getSelectedIndex();
        switch (selectedIndex) {
            case 0:
                imprimirPorArea();
                break;
            case 1:
                imprimirPorRecepcion();
                break;
            case 2:
                imprimirPorProcedimiento();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opción no válida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                break;
        }
    }

    private void imprimirPorArea() {
        if (!this.xmt.mVerificarDatosTablaTrue(this.JTBDetalleA, 2)) {
            mostrarMensaje("Debe seleccionar área a imprimir", this.JTBDetalleA);
            return;
        }
        Object[][] parametros = crearParametrosBase();
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            String xidArea = obtenerIdsSeleccionados(this.JTBDetalleA, 0);
            parametros[2][1] = xidArea;
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                String rutaReporte = this.JRBNormal1.isSelected() ? "L_Planilla_Trabajo_F1_Agrupada" : "L_N_Planilla_Area_FPZ_Agrupada";
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + rutaReporte, parametros);
            } else {
                String rutaReporte2 = obtenerRutaReporteAgrupado();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + rutaReporte2, parametros);
            }
        } else {
            for (int x = 0; x < this.JTBDetalleA.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo2.getValueAt(x, 2).toString()).booleanValue()) {
                    parametros[2][1] = this.xmodelo2.getValueAt(x, 0).toString();
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_N_Planilla_Area_3", parametros, this.xmodelo2.getValueAt(x, 1).toString());
                }
            }
        }
        this.xct.cerrarConexionBd();
    }

    private void imprimirPorRecepcion() {
        if (this.JTFFNInicial.getText().isEmpty()) {
            mostrarMensaje("Número de recepción inicial no puede ser nulo", this.JTFFNInicial);
            return;
        }
        if (this.JTFFNFinal.getText().isEmpty()) {
            mostrarMensaje("Número de recepción final no puede ser nulo", this.JTFFNFinal);
            return;
        }
        String[][] parametros = crearParametrosBase();
        parametros[5][1] = this.JTFFNInicial.getText();
        parametros[6][1] = this.JTFFNFinal.getText();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_N_Planilla_NRecepcion_FPZ", parametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_N_Planilla_NRecepcion", parametros);
        }
        this.xct.cerrarConexionBd();
    }

    private void imprimirPorProcedimiento() {
        if (!this.xmt.mVerificarDatosTablaTrue(this.JTBDetalleExamen, 2)) {
            mostrarMensaje("Debe seleccionar los exámenes a imprimir", this.JTBDetalleExamen);
            return;
        }
        String xcodigopro = obtenerIdsSeleccionados(this.JTBDetalleExamen, 0);
        String[][] parametros = crearParametrosBase();
        parametros[14][1] = xcodigopro;
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_N_Planilla_Procedimiento_FPZ", parametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_N_Planilla_Procedimiento", parametros);
        }
        this.xct.cerrarConexionBd();
    }

    private String[][] crearParametrosBase() {
        String[][] parametros = new String[15][2];
        parametros[0][0] = "fechaIni";
        parametros[0][1] = this.xmt.formatoAMD1.format(this.JDCFechaI.getDate());
        parametros[1][0] = "fechaFin";
        parametros[1][1] = this.xmt.formatoAMD1.format(this.JDCFechaF.getDate());
        parametros[2][0] = "idArea";
        parametros[3][0] = "Profesional";
        parametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[4][0] = "remitido";
        parametros[4][1] = String.valueOf(this.xesremitido);
        parametros[5][0] = "resultado";
        parametros[5][1] = String.valueOf(this.xresultado);
        parametros[6][0] = "nrecepcion";
        parametros[7][0] = "nrecepcion1";
        parametros[8][0] = "idmunicipio";
        parametros[8][1] = this.JCBMunicipio.getSelectedIndex() != -1 ? this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] : "0";
        parametros[9][0] = "SUBREPORT_DIR";
        parametros[9][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[10][0] = "SUBREPORTFIRMA_DIR";
        parametros[10][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[11][0] = "servicio";
        parametros[11][1] = String.valueOf(this.JCHFTipoAtencion.isSelected());
        parametros[12][0] = "idservicio";
        parametros[12][1] = this.JCBTipoServicio.getSelectedIndex() != -1 ? this.xidServicios[this.JCBTipoServicio.getSelectedIndex()] : "0";
        parametros[13][0] = "idSede";
        parametros[13][1] = !this.listSedesSeleccionadas.equals("") ? this.listSedesSeleccionadas : "0";
        parametros[14][0] = "idProcedimientos";
        return parametros;
    }

    private String obtenerIdsSeleccionados(JTable tabla, int columna) {
        StringBuilder ids = new StringBuilder();
        for (int x = 0; x < tabla.getRowCount(); x++) {
            if (Boolean.valueOf(tabla.getModel().getValueAt(x, 2).toString()).booleanValue()) {
                ids.append(",").append(tabla.getModel().getValueAt(x, columna).toString());
            }
        }
        return ids.length() > 0 ? ids.substring(1) : "";
    }

    private void mostrarMensaje(String mensaje, JComponent componente) {
        JOptionPane.showMessageDialog(this, mensaje, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        componente.requestFocus();
    }

    private String obtenerRutaReporteAgrupado() {
        if (this.JRBNormal1.isSelected()) {
            return (!this.JCHFMunicipio.isSelected() || this.JCBMunicipio.getSelectedIndex() == -1) ? "L_Planilla_Trabajo_F1_Municipio_1_Agrupada" : "L_Planilla_Trabajo_F1_Municipio_Filtrada_Agrupada";
        }
        if (this.JRBOficio.isSelected()) {
            if (this.JCHFMunicipio.isSelected()) {
                return this.JCBMunicipio.getSelectedIndex() == -1 ? "L_N_Planilla_Area_2_Municipio_Agrupada" : "L_N_Planilla_Area_2_Municipio_Filtrada_Agrupada";
            }
            return "L_N_Planilla_Area_2_Agrupada";
        }
        if (this.JRBCarta.isSelected()) {
            if (this.JCHFMunicipio.isSelected()) {
                return this.JCBMunicipio.getSelectedIndex() == -1 ? "L_N_Planilla_Area_1_Municipio_Agrupada" : "L_N_Planilla_Area_1_Municipio_Filtrada_Agrupada";
            }
            return "L_N_Planilla_Area_1_Agrupada";
        }
        return "";
    }

    private String obtenerRutaReporteIndividual() {
        if (this.JRBNormal1.isSelected()) {
            return (!this.JCHFMunicipio.isSelected() || this.JCBMunicipio.getSelectedIndex() == -1) ? "L_Planilla_Trabajo_F1_Municipio_1" : "L_Planilla_Trabajo_F1_Municipio_Filtrada";
        }
        if (this.JRBOficio.isSelected()) {
            if (this.JCHFMunicipio.isSelected()) {
                return this.JCBMunicipio.getSelectedIndex() == -1 ? "L_N_Planilla_Area_2_Municipio" : "L_N_Planilla_Area_2_Municipio_Filtrada";
            }
            return "L_N_Planilla_Area_2";
        }
        if (this.JRBCarta.isSelected()) {
            if (this.JCHFMunicipio.isSelected()) {
                return this.JCBMunicipio.getSelectedIndex() == -1 ? "L_N_Planilla_Area_1_Municipio" : "L_N_Planilla_Area_1_Municipio_Filtrada";
            }
            return "L_N_Planilla_Area_1";
        }
        return "";
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Cargar"}) { // from class: Laboratorio.Imprimir.24
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleExamen.setModel(this.xmodelo1);
        this.JTBDetalleExamen.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalleExamen.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalleExamen.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalleExamen.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBDetalleExamen.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalleA() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Imprimir?", "Reporte"}) { // from class: Laboratorio.Imprimir.25
            Class[] types = {Long.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleA.setModel(this.xmodelo2);
        this.JTBDetalleA.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalleA.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalleA.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalleA.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBDetalleA.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalleA.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalleA.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalleA.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatosModelo() {
        try {
            if (this.JTFFiltroNombre.getText().isEmpty()) {
                this.xsql = "SELECT `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, `g_procedimiento`.`Ref` FROM `l_detallerecepcion` INNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `l_areas`  ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`) INNER JOIN  `l_recepcion`   ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE ( DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND  DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND `l_recepcion`.`Estado`=0 and `g_procedimiento`.`EsRemitido`='" + this.xesremitido + "') GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
            } else {
                this.xsql = "SELECT `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, `g_procedimiento`.`Ref` FROM `l_detallerecepcion` INNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `l_areas`  ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`) INNER JOIN  `l_recepcion`   ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE ( DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND  DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND `l_recepcion`.`Estado`=0 and `g_procedimiento`.`EsRemitido`='" + this.xesremitido + "' and `g_procedimiento`.`Nbre` like'" + this.JTFFiltroNombre.getText() + "%') GROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mCrearModeloDetalle();
            if (xrs.next()) {
                int x = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(false, x, 2);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDFiltroPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosModeloA() {
        try {
            this.xsql = "SELECT `l_areas`.`Id`, `l_areas`.`Nbre`, `l_areas`.`IdReporte` FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN  `l_areas`  ON (`g_procedimiento`.`Id_Area` = `l_areas`.`Id`) WHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "'  AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "'  AND `l_recepcion`.`Estado` =0 AND `g_procedimiento`.`EsRemitido` ='" + this.xesremitido + "') GROUP BY `l_areas`.`Id` ORDER BY `l_areas`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mCrearModeloDetalleA();
            if (xrs.next()) {
                int x = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo2.setValueAt(false, x, 2);
                    this.xmodelo2.setValueAt(xrs.getString(3), x, 3);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDFiltroPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearVistaAjustes(String xsql) {
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS l_v_tmp_planilla  ");
        this.xct.cerrarConexionBd();
        String sqlw = "CREATE VIEW l_v_tmp_planilla AS " + xsql;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
    }

    private void togglePopup() {
        if (this.jPopupMenu1.isVisible()) {
            this.jPopupMenu1.setVisible(false);
        } else {
            showPopup();
        }
    }

    private void showPopup() {
        Point location = this.JTFFalseCombobox.getLocationOnScreen();
        this.jPopupMenu1.setLocation(location.x, location.y + this.JTFFalseCombobox.getHeight());
        this.jPopupMenu1.setVisible(true);
    }

    private void updateTextField() {
        List<String> seleccionados = new ArrayList<>();
        StringBuilder idSedes = new StringBuilder();
        for (int x = 0; x < this.checkBoxes.size(); x++) {
            if (this.checkBoxes.get(x).isSelected()) {
                seleccionados.add(this.checkBoxes.get(x).getText());
                idSedes.append(",").append(this.listSedes.get(x));
            }
        }
        this.listSedesSeleccionadas = idSedes.length() > 0 ? idSedes.substring(1) : "";
        System.out.println(this.listSedesSeleccionadas);
        this.JTFFalseCombobox.setText(seleccionados.isEmpty() ? "Seleccionar opciones..." : String.join(", ", seleccionados));
    }
}
