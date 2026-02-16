package Armado;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFDigitacionDx.class */
public class JIFDigitacionDx extends JInternalFrame {
    private String[] xidespecialidad;
    private String[] xidprofesional;
    private int xllenoc;
    private int xllenof;
    private Object[] xdato;
    private JComboBox comboBox;
    JCheckBox jchk;
    private File xfile;
    private ButtonGroup JBG_Filtro;
    private JButton JBTCargar;
    private JButton JBTLimpiar;
    private JButton JBTLimpiarCampos;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JComboBox JCBdx;
    private JCheckBox JCHSeleccion;
    private JCheckBox JCH_FiltroProf;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JLabel JLB_NRegistro;
    private JMenuItem JMIConsultarDx;
    private JMenuItem JMISalir;
    private JPopupMenu JMPAyuda;
    private JPanel JPIDatosFiltrado;
    private JPanel JPI_Filtro;
    private JRadioButton JRB_FacturaO;
    private JRadioButton JRB_Todas;
    private JScrollPane JSPResultado;
    public JTable JTBResultado;
    public JTextField JTFDxP;
    public JTextField JTFDxR1;
    public JTextField JTFDxR2;
    public JTextField JTFDxR3;
    private JTextField JTFRuta;
    private JTextField JTxtNdocumento;
    private JButton jButton1;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    public DefaultTableModel xmodelo = new DefaultTableModel();
    private int xllenat = 0;
    public int xposfila = -1;
    public int xposcolumna = -1;
    public int xordenar = 0;

    public JIFDigitacionDx(String xnombre) {
        this.xllenoc = 0;
        initComponents();
        setName(xnombre);
        mNuevo();
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Armado.JIFDigitacionDx.1
            public void mouseClicked(MouseEvent e) {
                JIFDigitacionDx.this.xposfila = JIFDigitacionDx.this.JTBResultado.rowAtPoint(e.getPoint());
                JIFDigitacionDx.this.xposcolumna = JIFDigitacionDx.this.JTBResultado.columnAtPoint(e.getPoint());
            }
        });
        this.xllenoc = 1;
    }

    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JMPAyuda = new JPopupMenu();
        this.JMIConsultarDx = new JMenuItem();
        this.JMISalir = new JMenuItem();
        this.JBG_Filtro = new ButtonGroup();
        this.JPIDatosFiltrado = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCH_FiltroProf = new JCheckBox();
        this.JPI_Filtro = new JPanel();
        this.JRB_Todas = new JRadioButton();
        this.JRB_FacturaO = new JRadioButton();
        this.JLB_NRegistro = new JLabel();
        this.JTxtNdocumento = new JTextField();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.jPanel1 = new JPanel();
        this.JCBdx = new JComboBox();
        this.JTFDxR1 = new JTextField();
        this.JTFDxP = new JTextField();
        this.JTFDxR2 = new JTextField();
        this.JTFDxR3 = new JTextField();
        this.JBTCargar = new JButton();
        this.JCHSeleccion = new JCheckBox();
        this.JBTLimpiar = new JButton();
        this.JBTLimpiarCampos = new JButton();
        this.JTFRuta = new JTextField();
        this.jButton1 = new JButton();
        this.JMIConsultarDx.setFont(new Font("Arial", 1, 12));
        this.JMIConsultarDx.setText("Consultar Dx");
        this.JMIConsultarDx.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx.2
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx.this.JMIConsultarDxActionPerformed(evt);
            }
        });
        this.JMPAyuda.add(this.JMIConsultarDx);
        this.JMISalir.setFont(new Font("Arial", 1, 12));
        this.JMISalir.setText("Salir");
        this.JMISalir.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx.3
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx.this.JMISalirActionPerformed(evt);
            }
        });
        this.JMPAyuda.add(this.JMISalir);
        setClosable(true);
        setIconifiable(true);
        setTitle("DIGITACIÓN DE DX PARA RIPS DE CONSULTA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifdigitaciondx");
        this.JPIDatosFiltrado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Armado.JIFDigitacionDx.4
            public void itemStateChanged(ItemEvent evt) {
                JIFDigitacionDx.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFDigitacionDx.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDigitacionDx.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFDigitacionDx.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDigitacionDx.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JCH_FiltroProf.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroProf.setForeground(Color.blue);
        this.JCH_FiltroProf.setText("Filtro Prof.");
        this.JCH_FiltroProf.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx.7
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx.this.JCH_FiltroProfActionPerformed(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JRB_Todas);
        this.JRB_Todas.setFont(new Font("Arial", 1, 12));
        this.JRB_Todas.setSelected(true);
        this.JRB_Todas.setText("Todas");
        this.JBG_Filtro.add(this.JRB_FacturaO);
        this.JRB_FacturaO.setFont(new Font("Arial", 1, 12));
        this.JRB_FacturaO.setText("Con Factura / N° Orden");
        this.JRB_FacturaO.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx.8
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx.this.JRB_FacturaOActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todas).addGap(18, 18, 18).addComponent(this.JRB_FacturaO).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todas).addComponent(this.JRB_FacturaO))));
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTxtNdocumento.setFont(new Font("Arial Black", 1, 12));
        this.JTxtNdocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosFiltradoLayout = new GroupLayout(this.JPIDatosFiltrado);
        this.JPIDatosFiltrado.setLayout(JPIDatosFiltradoLayout);
        JPIDatosFiltradoLayout.setHorizontalGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltradoLayout.createSequentialGroup().addGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltradoLayout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaFin, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEspecialidad, -2, 346, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProfesional, -2, 396, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_FiltroProf)).addGroup(JPIDatosFiltradoLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTxtNdocumento, -2, 306, -2).addGap(410, 410, 410).addComponent(this.JLB_NRegistro, -2, 111, -2))).addGap(5, 5, 5)));
        JPIDatosFiltradoLayout.setVerticalGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltradoLayout.createSequentialGroup().addGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, 50, -2).addComponent(this.JCBProfesional, -2, 51, -2).addComponent(this.JCH_FiltroProf)).addGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 50, -2).addComponent(this.JDCFechaFin, -2, 50, -2))).addGap(7, 7, 7).addGroup(JPIDatosFiltradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltradoLayout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPIDatosFiltradoLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JLB_NRegistro, -1, -1, 32767)).addComponent(this.JTxtNdocumento, GroupLayout.Alignment.TRAILING)).addGap(5, 5, 5)));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(Color.red);
        this.JTBResultado.setSelectionMode(0);
        this.JTBResultado.addFocusListener(new FocusAdapter() { // from class: Armado.JIFDigitacionDx.9
            public void focusGained(FocusEvent evt) {
                JIFDigitacionDx.this.JTBResultadoFocusGained(evt);
            }
        });
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Armado.JIFDigitacionDx.10
            public void mouseClicked(MouseEvent evt) {
                JIFDigitacionDx.this.JTBResultadoMouseClicked(evt);
            }

            public void mousePressed(MouseEvent evt) {
                JIFDigitacionDx.this.JTBResultadoMousePressed(evt);
            }
        });
        this.JTBResultado.addKeyListener(new KeyAdapter() { // from class: Armado.JIFDigitacionDx.11
            public void keyPressed(KeyEvent evt) {
                JIFDigitacionDx.this.JTBResultadoKeyPressed(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "ASIGNAR DX", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBdx.setFont(new Font("Arial", 1, 12));
        this.JCBdx.setModel(new DefaultComboBoxModel(new String[]{"Impresión Dx", "Confirmado Nuevo", "Confirmado Repetido"}));
        this.JCBdx.setSelectedIndex(-1);
        this.JCBdx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Diagnóstico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFDxR1.setBorder(BorderFactory.createTitledBorder((Border) null, "DxR1", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDxP.setFont(new Font("Arial", 1, 12));
        this.JTFDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "DxP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFDxR2.setBorder(BorderFactory.createTitledBorder((Border) null, "DxR2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFDxR3.setBorder(BorderFactory.createTitledBorder((Border) null, "DxR3", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTCargar.setFont(new Font("Arial", 1, 12));
        this.JBTCargar.setForeground(Color.blue);
        this.JBTCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Upload 60x55.png")));
        this.JBTCargar.setText("Cargar");
        this.JBTCargar.setHorizontalTextPosition(0);
        this.JBTCargar.setVerticalTextPosition(3);
        this.JBTCargar.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx.12
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx.this.JBTCargarActionPerformed(evt);
            }
        });
        this.JCHSeleccion.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setForeground(Color.blue);
        this.JCHSeleccion.setText("Seleccionar Todo");
        this.JCHSeleccion.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx.13
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx.this.JCHSeleccionActionPerformed(evt);
            }
        });
        this.JBTLimpiar.setFont(new Font("Arial", 1, 12));
        this.JBTLimpiar.setForeground(Color.blue);
        this.JBTLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Clear 24x31.png")));
        this.JBTLimpiar.setText("Limpiar Tabla");
        this.JBTLimpiar.setActionCommand("Limpiar Dx en Tabla");
        this.JBTLimpiar.setHorizontalTextPosition(0);
        this.JBTLimpiar.setPreferredSize(new Dimension(125, 59));
        this.JBTLimpiar.setVerticalTextPosition(3);
        this.JBTLimpiar.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx.14
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx.this.JBTLimpiarActionPerformed(evt);
            }
        });
        this.JBTLimpiarCampos.setFont(new Font("Arial", 1, 12));
        this.JBTLimpiarCampos.setForeground(Color.blue);
        this.JBTLimpiarCampos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Clear 24x31.png")));
        this.JBTLimpiarCampos.setText("Limpiar Campos");
        this.JBTLimpiarCampos.setHorizontalTextPosition(0);
        this.JBTLimpiarCampos.setVerticalTextPosition(3);
        this.JBTLimpiarCampos.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx.15
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx.this.JBTLimpiarCamposActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Armado.JIFDigitacionDx.16
            public void mouseClicked(MouseEvent evt) {
                JIFDigitacionDx.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.jButton1.addActionListener(new ActionListener() { // from class: Armado.JIFDigitacionDx.17
            public void actionPerformed(ActionEvent evt) {
                JIFDigitacionDx.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBdx, -2, 346, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDxP, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDxR1, -2, 78, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 362, -2).addGap(18, 18, 18).addComponent(this.jButton1, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JTFDxR2, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDxR3, -2, 78, -2)).addComponent(this.JCHSeleccion, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTLimpiarCampos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTLimpiar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCargar, -2, 145, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBdx, -2, 50, -2).addComponent(this.JTFDxP, -2, 50, -2).addComponent(this.JTFDxR1, -2, 50, -2).addComponent(this.JTFDxR2, -2, 50, -2).addComponent(this.JTFDxR3, -2, 50, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JCHSeleccion)).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta).addComponent(this.jButton1, -1, 51, 32767))))).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTLimpiar, -1, -1, 32767).addComponent(this.JBTCargar, -1, -1, 32767).addComponent(this.JBTLimpiarCampos, -1, -1, 32767)))).addGap(21, 21, 21)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosFiltrado, -2, -1, -2)).addComponent(this.JSPResultado, GroupLayout.Alignment.LEADING)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosFiltrado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 344, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xllenoc == 1) {
            this.JCBProfesional.removeAllItems();
            String sql = "SELECT g_profesional.Id_Persona,  CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS `NProfesional`   FROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)   INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  `g_profesional`  ON (g_profesional.`Id_Persona`= f_ordenes.Id_Profesional)   INNER JOIN  `g_profesionalespecial`  ON (g_profesional.Id_Persona = g_profesionalespecial.`Id_Profesional`)    AND (`f_ordenes`.`Id_Especialidad`=g_profesionalespecial.`Id_Especialidad`) INNER JOIN  g_persona  ON (g_persona.`Id`= g_profesional.Id_Persona)  INNER JOIN  `g_especialidad`  ON (g_especialidad.`Id`= g_profesionalespecial.`Id_Especialidad`)     INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN  f_liquidacion  ON (f_liquidacion.Id_Ingreso = ingreso.Id)  WHERE (f_itemripsconsulta.Id_DxPrincipal IS NULL  AND g_procedimiento.Id_TipoProcRIPS =5 AND  ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND  f_liquidacion.Estado=0 AND f_ordenes.Estado =0  AND ingreso.Estado=0 AND `f_ordenes`.`Id_Especialidad`='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' )    GROUP BY   g_profesional.Id_Persona ORDER BY NProfesional ";
            this.xidprofesional = this.xct.llenarCombo(sql, this.xidprofesional, this.JCBProfesional);
            this.xct.cerrarConexionBd();
            this.JCBProfesional.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoFocusGained(FocusEvent evt) {
        if (this.xllenat == 1 && this.JTBResultado.getSelectedRow() != -1) {
            if (this.JTBResultado.getSelectedColumn() == 4) {
                if (!this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 4).equals("")) {
                    mBuscarP(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 4).toString(), this.JTBResultado.getSelectedRow(), 4);
                }
            } else if (this.JTBResultado.getSelectedColumn() == 5) {
                if (!this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 5).equals("")) {
                    mBuscarP(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 5).toString(), this.JTBResultado.getSelectedRow(), 5);
                }
            } else if (this.JTBResultado.getSelectedColumn() == 6) {
                if (!this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 6).equals("")) {
                    mBuscarP(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 6).toString(), this.JTBResultado.getSelectedRow(), 6);
                }
            } else if (this.JTBResultado.getSelectedColumn() == 7 && !this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 7).equals("")) {
                mBuscarP(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 7).toString(), this.JTBResultado.getSelectedRow(), 7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        if (evt.getButton() == 3) {
            int pos1 = this.JTBResultado.rowAtPoint(evt.getPoint());
            if (pos1 == 4) {
                mBuscarPatologia();
            }
        }
        if (this.JTBResultado.getSelectedColumn() == 12) {
            this.xordenar = 1;
            mBuscar();
        } else {
            this.xordenar = 0;
        }
        if (this.JTBResultado.getSelectedColumn() == 3 || this.JTBResultado.getSelectedColumn() == 4 || this.JTBResultado.getSelectedColumn() == 5 || this.JTBResultado.getSelectedColumn() == 6 || this.JTBResultado.getSelectedColumn() == 7) {
            this.JTBResultado.setValueAt(true, this.JTBResultado.getSelectedRow(), 15);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroProfActionPerformed(ActionEvent evt) {
        if (this.JCH_FiltroProf.isSelected()) {
            this.JCBProfesional.setEnabled(true);
        } else {
            this.JCBProfesional.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMousePressed(MouseEvent evt) {
        if (evt.getButton() == 3 && this.xposcolumna != -1 && this.xposfila != -1 && this.xposcolumna >= 4 && this.xposcolumna <= 7) {
            this.JMPAyuda.setVisible(true);
            this.JMPAyuda.setLocation(evt.getLocationOnScreen().x, evt.getLocationOnScreen().y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMISalirActionPerformed(ActionEvent evt) {
        this.JMPAyuda.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIConsultarDxActionPerformed(ActionEvent evt) {
        if (this.xposfila != -1 && this.xposcolumna != -1) {
            this.JMPAyuda.setVisible(false);
            JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, (Object) this, "digitaciondx");
            pac.setVisible(true);
            pac.setLocationRelativeTo(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenof == 1) {
            mLLenar_Combo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenof == 1) {
            mLLenar_Combo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FacturaOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccion.isSelected()) {
            this.JCHSeleccion.setText("Quitar Selección");
            mRecorrerTabla();
        } else {
            this.JCHSeleccion.setText("Seleccionar Todo");
            mRecorrerTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCargarActionPerformed(ActionEvent evt) {
        for (int x = 0; x < this.JTBResultado.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 15).toString()).booleanValue()) {
                this.xmodelo.setValueAt(this.JCBdx.getSelectedItem(), x, 3);
                this.xmodelo.setValueAt(this.JTFDxP.getText(), x, 4);
                this.xmodelo.setValueAt(this.JTFDxR1.getText(), x, 5);
                this.xmodelo.setValueAt(this.JTFDxR2.getText(), x, 6);
                this.xmodelo.setValueAt(this.JTFDxR3.getText(), x, 7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTLimpiarActionPerformed(ActionEvent evt) {
        for (int x = 0; x < this.JTBResultado.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 15).toString()).booleanValue()) {
                this.xmodelo.setValueAt("", x, 3);
                this.xmodelo.setValueAt("", x, 4);
                this.xmodelo.setValueAt("", x, 5);
                this.xmodelo.setValueAt("", x, 6);
                this.xmodelo.setValueAt("", x, 7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTLimpiarCamposActionPerformed(ActionEvent evt) {
        this.JCBdx.setSelectedIndex(-1);
        this.JTFDxP.setText("");
        this.JTFDxR1.setText("");
        this.JTFDxR2.setText("");
        this.JTFDxR3.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        mExportar();
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTBResultado.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBResultado, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    private void mRecorrerTabla() {
        if (this.JTBResultado.getRowCount() > 0) {
            for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
                if (this.JCHSeleccion.isSelected()) {
                    this.xmodelo.setValueAt(true, i, 15);
                } else {
                    this.xmodelo.setValueAt(false, i, 15);
                }
            }
        }
    }

    private void mBuscarPatologia() {
        JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, (Object) "", "digitaciondx");
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    private void mBuscarP(String codigo, int posf, int posc) {
        try {
            String sql = "SELECT Id, Nbre FROM  g_patologia where Id='" + codigo + "' and Estado=1";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.first();
                this.xmodelo.setValueAt(rs.getString(1), posf, posc);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Codigo Incorrecto", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.xmodelo.setValueAt("", posf, posc);
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFDigitacionDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearTablaDetalleProc() {
        this.xmodelo = new DefaultTableModel() { // from class: Armado.JIFDigitacionDx.18
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, true, true, true, true, true, false, false, false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("Fecha");
        this.xmodelo.addColumn("Usuario");
        this.xmodelo.addColumn("Procedimiento");
        this.xmodelo.addColumn("Tipo Dx");
        this.xmodelo.addColumn("DxP");
        this.xmodelo.addColumn("DxR1");
        this.xmodelo.addColumn("DxR2");
        this.xmodelo.addColumn("DxR3");
        this.xmodelo.addColumn("");
        this.xmodelo.addColumn("");
        this.xmodelo.addColumn("Profesional");
        this.xmodelo.addColumn("N° Historia");
        this.xmodelo.addColumn("Convenio");
        this.xmodelo.addColumn("Ingreso");
        this.xmodelo.addColumn("N° Doc");
        this.xmodelo.addColumn("Seleccionar");
        this.xmodelo.addColumn("Finalidad");
        JTable jTable = this.JTBResultado;
        JTable jTable2 = this.JTBResultado;
        jTable.setAutoResizeMode(0);
        this.JTBResultado.doLayout();
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(16).setPreferredWidth(300);
        this.JTBResultado.setModel(this.xmodelo);
        TableColumn sportColumn = this.JTBResultado.getColumnModel().getColumn(3);
        this.comboBox = new JComboBox();
        this.comboBox.addItem("Impresión Dx");
        this.comboBox.addItem("Confirmado Nuevo");
        this.comboBox.addItem("Confirmado Repetido");
        sportColumn.setCellEditor(new DefaultCellEditor(this.comboBox));
    }

    public void mBuscar() {
        String sql;
        String sql2;
        mCrearTablaDetalleProc();
        if (this.JCH_FiltroProf.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (this.JRB_Todas.isSelected()) {
                        if (this.xordenar == 1) {
                            sql2 = "SELECT f_itemordenesproced.Id_Ordenes,ingreso.FechaIngreso, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, g_procedimiento.Nbre, f_itemripsconsulta.Id_Ordenes, f_itemripsconsulta.Id_DxPrincipal, profesional.NProfesional,  ingreso.HoraIngreso, f_itemordenesproced.Id_Procedimiento, g_usuario.NoHistoria,`f_empresacontxconvenio`.`Nbre`,  ingreso.Id AS Id_Ingreso,CONCAT(g_persona.`Id_TipoIdentificacion`,'-',g_persona.`NoDocumento`) AS Documento, `f_tipofinprocedimiento`.`Nbre` AS Finalidad,if((ingreso.DxIngreso=null or ingreso.DxIngreso='' or ingreso.DxIngreso='0000'),'',ingreso.DxIngreso) as diagnostico  \nFROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  profesional  ON (profesional.Id_Persona = f_ordenes.Id_Profesional)  INNER JOIN  g_persona  ON (g_persona.`Id`= ingreso.Id_Usuario)  INNER JOIN  g_usuario  ON (g_persona.`Id`= g_usuario.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `f_tipofinprocedimiento` ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`) WHERE (f_itemripsconsulta.Id_DxPrincipal is null  AND g_procedimiento.Id_TipoProcRIPS =5 AND f_ordenes.Estado =0 AND ingreso.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'AND f_ordenes.Id_Profesional ='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "' and ingreso.Estado=0  ) ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
                        } else {
                            sql2 = "SELECT f_itemordenesproced.Id_Ordenes,ingreso.FechaIngreso, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, g_procedimiento.Nbre, f_itemripsconsulta.Id_Ordenes, f_itemripsconsulta.Id_DxPrincipal, profesional.NProfesional,  ingreso.HoraIngreso, f_itemordenesproced.Id_Procedimiento, g_usuario.NoHistoria,`f_empresacontxconvenio`.`Nbre`,  ingreso.Id AS Id_Ingreso,CONCAT(g_persona.`Id_TipoIdentificacion`,'-',g_persona.`NoDocumento`) AS Documento, `f_tipofinprocedimiento`.`Nbre` AS Finalidad,if((ingreso.DxIngreso=null or ingreso.DxIngreso='' or ingreso.DxIngreso='0000'),'',ingreso.DxIngreso) as diagnostico  \nFROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  profesional  ON (profesional.Id_Persona = f_ordenes.Id_Profesional)  INNER JOIN  g_persona  ON (g_persona.`Id`= ingreso.Id_Usuario)  INNER JOIN  g_usuario  ON (g_persona.`Id`= g_usuario.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `f_tipofinprocedimiento` ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`) WHERE (f_itemripsconsulta.Id_DxPrincipal is null  AND g_procedimiento.Id_TipoProcRIPS =5 AND f_ordenes.Estado =0 AND ingreso.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'AND f_ordenes.Id_Profesional ='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "' and ingreso.Estado=0  ) ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
                        }
                    } else if (this.xordenar == 1) {
                        sql2 = "SELECT f_itemordenesproced.Id_Ordenes,ingreso.FechaIngreso, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, g_procedimiento.Nbre, f_itemripsconsulta.Id_Ordenes, f_itemripsconsulta.Id_DxPrincipal, profesional.NProfesional,  ingreso.HoraIngreso, f_itemordenesproced.Id_Procedimiento, g_usuario.NoHistoria,`f_empresacontxconvenio`.`Nbre`,  ingreso.Id AS Id_Ingreso,CONCAT(g_persona.`Id_TipoIdentificacion`,'-',g_persona.`NoDocumento`) AS Documento, `f_tipofinprocedimiento`.`Nbre` AS Finalidad,if((ingreso.DxIngreso=null or ingreso.DxIngreso='' or ingreso.DxIngreso='0000'),'',ingreso.DxIngreso) as diagnostico  \nFROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  profesional  ON (profesional.Id_Persona = f_ordenes.Id_Profesional)  INNER JOIN  g_persona  ON (g_persona.`Id`= ingreso.Id_Usuario)  INNER JOIN  g_usuario  ON (g_persona.`Id`= g_usuario.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN  f_liquidacion  ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN `f_tipofinprocedimiento` ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`) WHERE (f_itemripsconsulta.Id_DxPrincipal is null  AND g_procedimiento.Id_TipoProcRIPS =5 AND f_ordenes.Estado =0 AND ingreso.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and f_liquidacion.Estado =0 and ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'AND f_ordenes.Id_Profesional ='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "' and ingreso.Estado=0  ) ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
                    } else {
                        sql2 = "SELECT f_itemordenesproced.Id_Ordenes,ingreso.FechaIngreso, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, g_procedimiento.Nbre, f_itemripsconsulta.Id_Ordenes, f_itemripsconsulta.Id_DxPrincipal, profesional.NProfesional,  ingreso.HoraIngreso, f_itemordenesproced.Id_Procedimiento, g_usuario.NoHistoria,`f_empresacontxconvenio`.`Nbre`,  ingreso.Id AS Id_Ingreso,CONCAT(g_persona.`Id_TipoIdentificacion`,'-',g_persona.`NoDocumento`) AS Documento, `f_tipofinprocedimiento`.`Nbre` AS Finalidad,if((ingreso.DxIngreso=null or ingreso.DxIngreso='' or ingreso.DxIngreso='0000'),'',ingreso.DxIngreso) as diagnostico  \nFROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  profesional  ON (profesional.Id_Persona = f_ordenes.Id_Profesional)  INNER JOIN  g_persona  ON (g_persona.`Id`= ingreso.Id_Usuario)  INNER JOIN  g_usuario  ON (g_persona.`Id`= g_usuario.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN  f_liquidacion  ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN `f_tipofinprocedimiento` ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`) WHERE (f_itemripsconsulta.Id_DxPrincipal is null  AND g_procedimiento.Id_TipoProcRIPS =5 AND f_ordenes.Estado =0 AND ingreso.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and f_liquidacion.Estado =0 and ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'AND f_ordenes.Id_Profesional ='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "' and ingreso.Estado=0  ) ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
                    }
                    mCargarDatos(sql2);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            if (this.JRB_Todas.isSelected()) {
                if (this.xordenar == 1) {
                    sql = "SELECT f_itemordenesproced.Id_Ordenes,ingreso.FechaIngreso, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, g_procedimiento.Nbre, f_itemripsconsulta.Id_Ordenes, f_itemripsconsulta.Id_DxPrincipal, profesional.NProfesional,  ingreso.HoraIngreso, f_itemordenesproced.Id_Procedimiento, g_usuario.NoHistoria,`f_empresacontxconvenio`.`Nbre`,  ingreso.Id AS Id_Ingreso,CONCAT(g_persona.`Id_TipoIdentificacion`,'-',g_persona.`NoDocumento`) AS Documento, `f_tipofinprocedimiento`.`Nbre` AS Finalidad,if((ingreso.DxIngreso=null or ingreso.DxIngreso='' or ingreso.DxIngreso='0000'),'',ingreso.DxIngreso) as diagnostico  \nFROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  profesional  ON (profesional.Id_Persona = f_ordenes.Id_Profesional)  INNER JOIN  g_persona  ON (g_persona.`Id`= ingreso.Id_Usuario)  INNER JOIN  g_usuario  ON (g_persona.`Id`= g_usuario.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)   INNER JOIN `f_tipofinprocedimiento` ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`) WHERE (f_itemripsconsulta.Id_DxPrincipal is null  AND g_procedimiento.Id_TipoProcRIPS =5 and ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' and f_ordenes.Estado =0 AND ingreso.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and ingreso.Estado=0) ORDER BY `f_empresacontxconvenio`.`Nbre` ASC,  ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
                } else {
                    sql = "SELECT f_itemordenesproced.Id_Ordenes,ingreso.FechaIngreso, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, g_procedimiento.Nbre, f_itemripsconsulta.Id_Ordenes, f_itemripsconsulta.Id_DxPrincipal, profesional.NProfesional,  ingreso.HoraIngreso, f_itemordenesproced.Id_Procedimiento, g_usuario.NoHistoria,`f_empresacontxconvenio`.`Nbre`,  ingreso.Id AS Id_Ingreso,CONCAT(g_persona.`Id_TipoIdentificacion`,'-',g_persona.`NoDocumento`) AS Documento, `f_tipofinprocedimiento`.`Nbre` AS Finalidad,if((ingreso.DxIngreso=null or ingreso.DxIngreso='' or ingreso.DxIngreso='0000'),'',ingreso.DxIngreso) as diagnostico  \nFROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  profesional  ON (profesional.Id_Persona = f_ordenes.Id_Profesional)  INNER JOIN  g_persona  ON (g_persona.`Id`= ingreso.Id_Usuario)  INNER JOIN  g_usuario  ON (g_persona.`Id`= g_usuario.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)   INNER JOIN `f_tipofinprocedimiento` ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`) WHERE (f_itemripsconsulta.Id_DxPrincipal is null  AND g_procedimiento.Id_TipoProcRIPS =5 and ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' and f_ordenes.Estado =0 AND ingreso.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and ingreso.Estado=0) ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
                }
            } else if (this.xordenar == 1) {
                sql = "SELECT f_itemordenesproced.Id_Ordenes,ingreso.FechaIngreso, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, g_procedimiento.Nbre, f_itemripsconsulta.Id_Ordenes, f_itemripsconsulta.Id_DxPrincipal, profesional.NProfesional,  ingreso.HoraIngreso, f_itemordenesproced.Id_Procedimiento, g_usuario.NoHistoria,`f_empresacontxconvenio`.`Nbre`,  ingreso.Id AS Id_Ingreso,CONCAT(g_persona.`Id_TipoIdentificacion`,'-',g_persona.`NoDocumento`) AS Documento, `f_tipofinprocedimiento`.`Nbre` AS Finalidad,if((ingreso.DxIngreso=null or ingreso.DxIngreso='' or ingreso.DxIngreso='0000'),'',ingreso.DxIngreso) as diagnostico  \nFROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  profesional  ON (profesional.Id_Persona = f_ordenes.Id_Profesional)  INNER JOIN  g_persona  ON (g_persona.`Id`= ingreso.Id_Usuario)  INNER JOIN  g_usuario  ON (g_persona.`Id`= g_usuario.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN  f_liquidacion  ON (f_liquidacion.Id_Ingreso = ingreso.Id)INNER JOIN `f_tipofinprocedimiento` ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`) WHERE (f_itemripsconsulta.Id_DxPrincipal is null  AND g_procedimiento.Id_TipoProcRIPS =5 and ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' and f_liquidacion.Estado=0 and f_ordenes.Estado =0 AND ingreso.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and ingreso.Estado=0) ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
            } else {
                sql = "SELECT f_itemordenesproced.Id_Ordenes,ingreso.FechaIngreso, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, g_procedimiento.Nbre, f_itemripsconsulta.Id_Ordenes, f_itemripsconsulta.Id_DxPrincipal, profesional.NProfesional,  ingreso.HoraIngreso, f_itemordenesproced.Id_Procedimiento, g_usuario.NoHistoria,`f_empresacontxconvenio`.`Nbre`,  ingreso.Id AS Id_Ingreso,CONCAT(g_persona.`Id_TipoIdentificacion`,'-',g_persona.`NoDocumento`) AS Documento, `f_tipofinprocedimiento`.`Nbre` AS Finalidad,if((ingreso.DxIngreso=null or ingreso.DxIngreso='' or ingreso.DxIngreso='0000'),'',ingreso.DxIngreso) as diagnostico  \nFROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  profesional  ON (profesional.Id_Persona = f_ordenes.Id_Profesional)  INNER JOIN  g_persona  ON (g_persona.`Id`= ingreso.Id_Usuario)  INNER JOIN  g_usuario  ON (g_persona.`Id`= g_usuario.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN  f_liquidacion  ON (f_liquidacion.Id_Ingreso = ingreso.Id)INNER JOIN `f_tipofinprocedimiento` ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`) WHERE (f_itemripsconsulta.Id_DxPrincipal is null  AND g_procedimiento.Id_TipoProcRIPS =5 and ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' and f_liquidacion.Estado=0 and f_ordenes.Estado =0 AND ingreso.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' and ingreso.Estado=0) ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
            }
            mCargarDatos(sql);
            return;
        }
        String sql3 = "SELECT f_itemordenesproced.Id_Ordenes,ingreso.FechaIngreso, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre2`) AS NUsuario, g_procedimiento.Nbre, f_itemripsconsulta.Id_Ordenes, f_itemripsconsulta.Id_DxPrincipal, profesional.NProfesional,  ingreso.HoraIngreso, f_itemordenesproced.Id_Procedimiento, g_usuario.NoHistoria,`f_empresacontxconvenio`.`Nbre`,  ingreso.Id AS Id_Ingreso,CONCAT(g_persona.`Id_TipoIdentificacion`,'-',g_persona.`NoDocumento`) AS Documento, `f_tipofinprocedimiento`.`Nbre` AS Finalidad,if((ingreso.DxIngreso=null or ingreso.DxIngreso='' or ingreso.DxIngreso='0000'),'',ingreso.DxIngreso) as diagnostico  \nFROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  \nINNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  \nINNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   \nINNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  \nINNER JOIN  profesional  ON (profesional.Id_Persona = f_ordenes.Id_Profesional) \n INNER JOIN  g_persona  ON (g_persona.`Id`= ingreso.Id_Usuario)  \n INNER JOIN  g_usuario  ON (g_persona.`Id`= g_usuario.`Id_persona`)  \n INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)   \n INNER JOIN `f_tipofinprocedimiento` ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`) \n WHERE (f_itemripsconsulta.Id_DxPrincipal IS NULL  AND g_procedimiento.Id_TipoProcRIPS =5 AND ingreso.FechaIngreso>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_ordenes.Estado =0  AND ingreso.Estado=0 AND g_persona.`NoDocumento` LIKE '%" + this.JTxtNdocumento.getText() + "%') ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
        mCargarDatos(sql3);
    }

    private void mCargarDatos(String SQL) {
        System.out.println("Procedimiento " + SQL);
        ResultSet rs = this.xct.traerRs(SQL);
        mCrearTablaDetalleProc();
        try {
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int m = 0;
                this.xmt.mEstablecerTextEditor(this.JTBResultado, 1);
                this.xmt.mEstablecerTextEditor(this.JTBResultado, 2);
                this.xmt.mEstablecerTextEditor(this.JTBResultado, 10);
                this.xmt.mEstablecerTextEditor(this.JTBResultado, 12);
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), m, 8);
                    this.xmodelo.setValueAt(rs.getString(2), m, 0);
                    this.xmodelo.setValueAt(rs.getString(3), m, 1);
                    this.xmodelo.setValueAt(rs.getString(4), m, 2);
                    this.xmodelo.setValueAt(rs.getString("diagnostico"), m, 4);
                    this.xmodelo.setValueAt("", m, 5);
                    this.xmodelo.setValueAt("", m, 6);
                    this.xmodelo.setValueAt("", m, 7);
                    this.xmodelo.setValueAt(rs.getString(9), m, 9);
                    this.xmodelo.setValueAt(rs.getString(7), m, 10);
                    this.xmodelo.setValueAt(rs.getString(10), m, 11);
                    this.xmodelo.setValueAt(rs.getString(11), m, 12);
                    this.xmodelo.setValueAt(rs.getString("Id_Ingreso"), m, 13);
                    this.xmodelo.setValueAt(rs.getString("Documento"), m, 14);
                    this.xmodelo.setValueAt(false, m, 15);
                    this.xmodelo.setValueAt(rs.getString("Finalidad"), m, 16);
                    m++;
                }
                this.JLB_NRegistro.setText("" + (m + 1));
                this.xllenat = 1;
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFDigitacionDx.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.xllenof = 0;
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        mCrearTablaDetalleProc();
        mLLenar_Combo();
        this.xordenar = 0;
        this.xllenoc = 1;
        this.xllenof = 1;
    }

    private void mLLenar_Combo() {
        this.xllenoc = 0;
        this.JCBEspecialidad.removeAllItems();
        String xsql = "SELECT g_especialidad.`Id`, g_especialidad.`Nbre` AS `Especialidad`  FROM  f_itemordenesproced  LEFT JOIN  f_itemripsconsulta  ON (f_itemordenesproced.Id_Ordenes = f_itemripsconsulta.Id_Ordenes)  INNER JOIN  g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN  f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  `g_profesional`  ON (g_profesional.`Id_Persona`= f_ordenes.Id_Profesional)  INNER JOIN  `g_profesionalespecial`  ON (g_profesional.Id_Persona = g_profesionalespecial.`Id_Profesional`)   AND (`f_ordenes`.`Id_Especialidad`=g_profesionalespecial.`Id_Especialidad`) INNER JOIN  `g_especialidad`  ON (g_especialidad.`Id`= g_profesionalespecial.`Id_Especialidad`)     INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  f_liquidacion  ON (f_liquidacion.Id_Ingreso = ingreso.Id) WHERE (f_itemripsconsulta.Id_DxPrincipal IS NULL  AND g_procedimiento.Id_TipoProcRIPS =5 AND ingreso.FechaIngreso>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "'  AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Estado=0 AND f_ordenes.Estado =0  AND ingreso.Estado=0)   GROUP BY   g_especialidad.`Id` ORDER BY  g_especialidad.`Nbre`  ";
        this.xidespecialidad = this.xct.llenarCombo(xsql, this.xidespecialidad, this.JCBEspecialidad);
        this.xct.cerrarConexionBd();
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBProfesional.removeAllItems();
        this.xllenoc = 1;
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (mVerificarDatosT()) {
                for (int x = 0; x < this.JTBResultado.getRowCount(); x++) {
                    if (this.xmodelo.getValueAt(x, 3) != null && !this.xmodelo.getValueAt(x, 4).toString().equals("") && !this.xmodelo.getValueAt(x, 3).toString().equals("")) {
                        String sql = "Insert into  f_itemripsconsulta(Id_Ordenes, Id_Procedimiento, Id_TipoDx, Id_DxPrincipal, DxRelacional1, DxRelacional2, DxRelacional3, Fecha, UsuarioS) values('" + this.xmodelo.getValueAt(x, 8) + "','" + this.xmodelo.getValueAt(x, 9) + "','" + mDdevuelveValorCombo(this.xmodelo.getValueAt(x, 3).toString()) + "','" + this.xmodelo.getValueAt(x, 4).toString().toUpperCase() + "','" + this.xmodelo.getValueAt(x, 5).toString().toUpperCase() + "','" + this.xmodelo.getValueAt(x, 6).toString().toUpperCase() + "','" + this.xmodelo.getValueAt(x, 7).toString().toUpperCase() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        String sql2 = "update ingreso set  DxIngreso='" + this.xmodelo.getValueAt(x, 4) + "' where Id='" + this.xmodelo.getValueAt(x, 13) + "'";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                    }
                }
                mCrearTablaDetalleProc();
                mBuscar();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe registro diligenciado en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private boolean mVerificarDatosT() {
        boolean ver = false;
        int i = 0;
        while (true) {
            if (i < this.JTBResultado.getRowCount()) {
                if (this.xmodelo.getValueAt(i, 3) == null || this.xmodelo.getValueAt(i, 4).toString().equals("") || this.xmodelo.getValueAt(i, 3).toString().equals("")) {
                    i++;
                } else {
                    ver = true;
                    break;
                }
            } else {
                break;
            }
        }
        return ver;
    }

    private int mDdevuelveValorCombo(String dato) {
        int xv = 1;
        if (dato.equals("Impresión Dx")) {
            xv = 1;
        } else if (dato.equals("Confirmado Nuevo")) {
            xv = 2;
        } else if (dato.equals("Confirmado Repetido")) {
            xv = 3;
        }
        return xv;
    }
}
