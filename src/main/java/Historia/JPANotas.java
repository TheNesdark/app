package Historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPANotas.class */
public class JPANotas extends JPanel {
    private DefaultTableModel xmodelonota;
    private Object[] dato;
    public String[][] xidtiponota;
    private String[] xidespecialidad;
    private String[] xidtiponota_historico;
    private DefaultTableModel xmodelo;
    private String xsql;
    private JInternalFrame xjif;
    private long xId_Atencion;
    private long xIdIngreso;
    private String xTipoAtencion;
    private String xId_AtencionEsp;
    private String xFiltro;
    public boolean nEvolucion;
    private JButton JBTGuardarTemp;
    private JButton JBTGuardarTemp1;
    private JButton JBTGuardarValoraciones;
    private JButton JBT_NotaP;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBH_Nota;
    private JComboBox JCBTipoNota;
    private JCheckBox JCHFiltro;
    private JCheckBox JCH_NCierreHC;
    private JDateChooser JDCFecha;
    private JDateChooser JDCFechaCardiologo;
    private JDateChooser JDCFechaEcocardiograma;
    private JDateChooser JDCFechaElectrocardiograma;
    private JDateChooser JDCFechaInternista;
    private JDateChooser JDCFechaNutricion;
    private JPanel JPDiagnostico;
    private JPanel JPIDFiltro;
    private JPanel JPI_Historico;
    private JPanel JPI_Nota;
    private JPanel JPUltimaAtencion;
    private JSpinner JSOrden;
    private JScrollPane JSPDetalleNotas;
    private JScrollPane JSPDiagnostico;
    private JScrollPane JSPHistoricoA;
    private JScrollPane JSPNotas;
    private JTable JTBDetalle;
    private JTable JTDetalle;
    public JTextField JTFCDxP;
    private JFormattedTextField JTFFHora;
    public JTextField JTFNCodigoDxP;
    public JTextField JTFNNota;
    private JTabbedPane JTPDatos;
    private JTextPane JTPHistoricoA;
    private JTabbedPane JTPMenus;
    public JTextPane JTPNota;
    private JPanel jPanel1;
    private JCheckBox jchMostrarNotas;
    private TableColumn column = null;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private boolean xlleno = false;
    private boolean xgrabar = false;
    private long xCerrarFac = 0;

    public JPANotas(JInternalFrame xjif, Long xId_Atencion, String xTipoAtencion, String xId_AtencionEsp, Long xIdIngreso, String xFiltro, String Nombre) {
        this.xId_Atencion = 0L;
        this.xIdIngreso = 0L;
        this.nEvolucion = false;
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, Nombre, 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.xjif = xjif;
        this.xIdIngreso = xIdIngreso.longValue();
        this.xId_Atencion = xId_Atencion.longValue();
        this.xTipoAtencion = xTipoAtencion;
        this.xId_AtencionEsp = xId_AtencionEsp;
        this.xFiltro = xFiltro;
        mNuevo();
        if (Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS")) {
            this.JCH_NCierreHC.setText("Cerrar Historia Clinica?");
        } else {
            this.JCH_NCierreHC.setText("Cerrar para facturar?");
        }
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JTPMenus.remove(1);
            this.JTPMenus.remove(2);
        }
        if (this.JTFNNota.getText().isEmpty() || this.JTFNNota.getText() == null || this.JTFNNota.getText().equals("0")) {
            this.nEvolucion = this.xmodelonota.getRowCount() != 0;
        } else {
            this.nEvolucion = true;
        }
        System.out.println("evolucion -> " + this.nEvolucion);
        if (!Principal.informacionIps.getIdentificacion().equals("812005644") && !Principal.informacionIps.getIdentificacion().equals("900293903")) {
            this.JTPMenus.setEnabledAt(3, false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPI_Nota = new JPanel();
        this.jPanel1 = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBTipoNota = new JComboBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCH_NCierreHC = new JCheckBox();
        this.JTPMenus = new JTabbedPane();
        this.JSPNotas = new JScrollPane();
        this.JTPNota = new JTextPane();
        this.JPDiagnostico = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JSPDiagnostico = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGuardarTemp1 = new JButton();
        this.JSOrden = new JSpinner();
        this.JSPDetalleNotas = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPUltimaAtencion = new JPanel();
        this.JBTGuardarValoraciones = new JButton();
        this.JDCFechaInternista = new JDateChooser();
        this.JDCFechaElectrocardiograma = new JDateChooser();
        this.JDCFechaNutricion = new JDateChooser();
        this.JDCFechaCardiologo = new JDateChooser();
        this.JDCFechaEcocardiograma = new JDateChooser();
        this.JBTGuardarTemp = new JButton();
        this.JTFNNota = new JTextField();
        this.JBT_NotaP = new JButton();
        this.jchMostrarNotas = new JCheckBox();
        this.JPI_Historico = new JPanel();
        this.JSPHistoricoA = new JScrollPane();
        this.JTPHistoricoA = new JTextPane();
        this.JPIDFiltro = new JPanel();
        this.JCBH_Nota = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Titulo", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpnotac");
        setPreferredSize(new Dimension(800, 681));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JDCFecha.addFocusListener(new FocusAdapter() { // from class: Historia.JPANotas.1
            public void focusLost(FocusEvent evt) {
                JPANotas.this.JDCFechaFocusLost(evt);
            }
        });
        this.JDCFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPANotas.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPANotas.this.JDCFechaPropertyChange(evt);
            }
        });
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Hora (HH:mm:ss)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.addFocusListener(new FocusAdapter() { // from class: Historia.JPANotas.3
            public void focusLost(FocusEvent evt) {
                JPANotas.this.JTFFHoraFocusLost(evt);
            }
        });
        this.JTFFHora.addActionListener(new ActionListener() { // from class: Historia.JPANotas.4
            public void actionPerformed(ActionEvent evt) {
                JPANotas.this.JTFFHoraActionPerformed(evt);
            }
        });
        this.JTFFHora.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPANotas.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPANotas.this.JTFFHoraPropertyChange(evt);
            }
        });
        this.JCBTipoNota.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Tipo Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoNota.addItemListener(new ItemListener() { // from class: Historia.JPANotas.6
            public void itemStateChanged(ItemEvent evt) {
                JPANotas.this.JCBTipoNotaItemStateChanged(evt);
            }
        });
        this.JCBTipoNota.addActionListener(new ActionListener() { // from class: Historia.JPANotas.7
            public void actionPerformed(ActionEvent evt) {
                JPANotas.this.JCBTipoNotaActionPerformed(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Especialidad (Solo en caso de valoraciones en urgencias)", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JCH_NCierreHC.setFont(new Font("Arial", 1, 12));
        this.JCH_NCierreHC.setText("Cerrar para facturar?");
        this.JCH_NCierreHC.addActionListener(new ActionListener() { // from class: Historia.JPANotas.8
            public void actionPerformed(ActionEvent evt) {
                JPANotas.this.JCH_NCierreHCActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 532, -2).addGap(12, 12, 12).addComponent(this.JCH_NCierreHC)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDCFecha, -2, 111, -2).addGap(18, 18, 18).addComponent(this.JTFFHora, -2, 119, -2).addGap(18, 18, 18).addComponent(this.JCBTipoNota, 0, -1, 32767))).addGap(28, 28, 28)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JCBTipoNota, -2, 50, -2)).addComponent(this.JDCFecha, -2, 50, -2)).addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEspecialidad, -2, 50, -2).addComponent(this.JCH_NCierreHC)).addGap(10, 10, 10)));
        this.JTPMenus.setForeground(new Color(0, 103, 0));
        this.JTPMenus.setFont(new Font("Arial", 1, 14));
        this.JSPNotas.setBorder((Border) null);
        this.JTPNota.setFont(new Font("Arial", 1, 12));
        this.JTPNota.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.9
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JTPNotaKeyPressed(evt);
            }
        });
        this.JSPNotas.setViewportView(this.JTPNota);
        this.JTPMenus.addTab("NOTA CLÍNICA", this.JSPNotas);
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPANotas.10
            public void focusLost(FocusEvent evt) {
                JPANotas.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.11
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPANotas.12
            public void mouseClicked(MouseEvent evt) {
                JPANotas.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.13
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPANotas.14
            public void mouseClicked(MouseEvent evt) {
                JPANotas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.15
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDiagnostico.setViewportView(this.JTDetalle);
        this.JBTGuardarTemp1.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarTemp1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarTemp1.addActionListener(new ActionListener() { // from class: Historia.JPANotas.16
            public void actionPerformed(ActionEvent evt) {
                JPANotas.this.JBTGuardarTemp1ActionPerformed(evt);
            }
        });
        this.JBTGuardarTemp1.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.17
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JBTGuardarTemp1KeyPressed(evt);
            }
        });
        this.JSOrden.setFont(new Font("Arial", 1, 12));
        this.JSOrden.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSOrden.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDiagnosticoLayout = new GroupLayout(this.JPDiagnostico);
        this.JPDiagnostico.setLayout(JPDiagnosticoLayout);
        JPDiagnosticoLayout.setHorizontalGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDiagnostico, -2, 703, -2).addGroup(JPDiagnosticoLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNCodigoDxP, -2, 466, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSOrden, -2, 78, -2).addGap(18, 18, 18).addComponent(this.JBTGuardarTemp1, -1, -1, 32767))).addContainerGap(32, 32767)));
        JPDiagnosticoLayout.setVerticalGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnosticoLayout.createSequentialGroup().addGap(13, 13, 13).addGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSOrden, GroupLayout.Alignment.LEADING).addGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, -1, -2).addComponent(this.JTFNCodigoDxP, -2, -1, -2))).addComponent(this.JBTGuardarTemp1, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addComponent(this.JSPDiagnostico, -1, 172, 32767)));
        this.JTPMenus.addTab("DIAGNOSTICOS", this.JPDiagnostico);
        this.JSPDetalleNotas.setBorder((Border) null);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPANotas.18
            public void mouseClicked(MouseEvent evt) {
                JPANotas.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.19
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalleNotas.setViewportView(this.JTBDetalle);
        this.JTPMenus.addTab("HISTÓRICO", this.JSPDetalleNotas);
        this.JBTGuardarValoraciones.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarValoraciones.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarValoraciones.addActionListener(new ActionListener() { // from class: Historia.JPANotas.20
            public void actionPerformed(ActionEvent evt) {
                JPANotas.this.JBTGuardarValoracionesActionPerformed(evt);
            }
        });
        this.JBTGuardarValoraciones.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.21
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JBTGuardarValoracionesKeyPressed(evt);
            }
        });
        this.JDCFechaInternista.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Fecha de última valoración por médico internista", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInternista.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInternista.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInternista.addFocusListener(new FocusAdapter() { // from class: Historia.JPANotas.22
            public void focusLost(FocusEvent evt) {
                JPANotas.this.JDCFechaInternistaFocusLost(evt);
            }
        });
        this.JDCFechaInternista.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPANotas.23
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPANotas.this.JDCFechaInternistaPropertyChange(evt);
            }
        });
        this.JDCFechaElectrocardiograma.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Fecha de ultima valoración por electrocardiograma", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaElectrocardiograma.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaElectrocardiograma.setFont(new Font("Arial", 1, 12));
        this.JDCFechaElectrocardiograma.addFocusListener(new FocusAdapter() { // from class: Historia.JPANotas.24
            public void focusLost(FocusEvent evt) {
                JPANotas.this.JDCFechaElectrocardiogramaFocusLost(evt);
            }
        });
        this.JDCFechaElectrocardiograma.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPANotas.25
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPANotas.this.JDCFechaElectrocardiogramaPropertyChange(evt);
            }
        });
        this.JDCFechaNutricion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Fecha de última valoración por nutrición ", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaNutricion.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaNutricion.setFont(new Font("Arial", 1, 12));
        this.JDCFechaNutricion.addFocusListener(new FocusAdapter() { // from class: Historia.JPANotas.26
            public void focusLost(FocusEvent evt) {
                JPANotas.this.JDCFechaNutricionFocusLost(evt);
            }
        });
        this.JDCFechaNutricion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPANotas.27
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPANotas.this.JDCFechaNutricionPropertyChange(evt);
            }
        });
        this.JDCFechaCardiologo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Fecha de ultima valoración por medico cardiólogo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaCardiologo.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaCardiologo.setFont(new Font("Arial", 1, 12));
        this.JDCFechaCardiologo.addFocusListener(new FocusAdapter() { // from class: Historia.JPANotas.28
            public void focusLost(FocusEvent evt) {
                JPANotas.this.JDCFechaCardiologoFocusLost(evt);
            }
        });
        this.JDCFechaCardiologo.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPANotas.29
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPANotas.this.JDCFechaCardiologoPropertyChange(evt);
            }
        });
        this.JDCFechaEcocardiograma.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Fecha de ultima valoración por ecocardiograma ", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaEcocardiograma.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaEcocardiograma.setFont(new Font("Arial", 1, 12));
        this.JDCFechaEcocardiograma.addFocusListener(new FocusAdapter() { // from class: Historia.JPANotas.30
            public void focusLost(FocusEvent evt) {
                JPANotas.this.JDCFechaEcocardiogramaFocusLost(evt);
            }
        });
        this.JDCFechaEcocardiograma.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPANotas.31
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPANotas.this.JDCFechaEcocardiogramaPropertyChange(evt);
            }
        });
        GroupLayout JPUltimaAtencionLayout = new GroupLayout(this.JPUltimaAtencion);
        this.JPUltimaAtencion.setLayout(JPUltimaAtencionLayout);
        JPUltimaAtencionLayout.setHorizontalGroup(JPUltimaAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPUltimaAtencionLayout.createSequentialGroup().addContainerGap().addGroup(JPUltimaAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaInternista, -1, 305, 32767).addComponent(this.JDCFechaNutricion, -1, -1, 32767).addComponent(this.JDCFechaElectrocardiograma, -1, -1, 32767)).addGap(56, 56, 56).addGroup(JPUltimaAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaEcocardiograma, -1, -1, 32767).addComponent(this.JDCFechaCardiologo, -1, -1, 32767).addComponent(this.JBTGuardarValoraciones, -2, 301, -2)).addContainerGap(73, 32767)));
        JPUltimaAtencionLayout.setVerticalGroup(JPUltimaAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPUltimaAtencionLayout.createSequentialGroup().addContainerGap().addGroup(JPUltimaAtencionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInternista, -2, 50, -2).addComponent(this.JDCFechaEcocardiograma, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addGroup(JPUltimaAtencionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaCardiologo, -2, 50, -2).addComponent(this.JDCFechaNutricion, -2, 50, -2)).addGap(31, 31, 31).addGroup(JPUltimaAtencionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCFechaElectrocardiograma, -2, 50, -2).addComponent(this.JBTGuardarValoraciones, -2, 43, -2)).addGap(20, 20, 20)));
        this.JTPMenus.addTab("ULTIMAS VALORACIONES", this.JPUltimaAtencion);
        this.JBTGuardarTemp.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarTemp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarTemp.setText("Guardar");
        this.JBTGuardarTemp.addActionListener(new ActionListener() { // from class: Historia.JPANotas.32
            public void actionPerformed(ActionEvent evt) {
                JPANotas.this.JBTGuardarTempActionPerformed(evt);
            }
        });
        this.JBTGuardarTemp.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.33
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JBTGuardarTempKeyPressed(evt);
            }
        });
        this.JTFNNota.setFont(new Font("Arial", 1, 24));
        this.JTFNNota.setHorizontalAlignment(0);
        this.JTFNNota.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "N° Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_NotaP.setFont(new Font("Arial", 1, 12));
        this.JBT_NotaP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_NotaP.setText("Notas Predefinidas");
        this.JBT_NotaP.addActionListener(new ActionListener() { // from class: Historia.JPANotas.34
            public void actionPerformed(ActionEvent evt) {
                JPANotas.this.JBT_NotaPActionPerformed(evt);
            }
        });
        this.JBT_NotaP.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.35
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JBT_NotaPKeyPressed(evt);
            }
        });
        this.jchMostrarNotas.setFont(new Font("Arial", 1, 12));
        this.jchMostrarNotas.setSelected(true);
        this.jchMostrarNotas.setText("Mostrar todas las notas");
        this.jchMostrarNotas.addActionListener(new ActionListener() { // from class: Historia.JPANotas.36
            public void actionPerformed(ActionEvent evt) {
                JPANotas.this.jchMostrarNotasActionPerformed(evt);
            }
        });
        GroupLayout JPI_NotaLayout = new GroupLayout(this.JPI_Nota);
        this.JPI_Nota.setLayout(JPI_NotaLayout);
        JPI_NotaLayout.setHorizontalGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, -2).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPI_NotaLayout.createSequentialGroup().addComponent(this.JBTGuardarTemp, -2, 189, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_NotaP).addGap(26, 26, 26).addComponent(this.JTFNNota, -2, 141, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jchMostrarNotas)).addComponent(this.JTPMenus, -2, 743, -2))).addGap(10, 10, 10)));
        JPI_NotaLayout.setVerticalGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPMenus, -2, 269, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_NotaP, -2, 48, -2).addGroup(JPI_NotaLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jchMostrarNotas)).addComponent(this.JBTGuardarTemp, -2, 50, -2).addGroup(JPI_NotaLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JTFNNota, -2, 50, -2))).addGap(2, 2, 2)));
        this.JTPDatos.addTab("NOTA", this.JPI_Nota);
        this.JPI_Historico.setAutoscrolls(true);
        this.JPI_Historico.setName("xjphistoricoa");
        this.JSPHistoricoA.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPHistoricoA.setEditable(false);
        this.JTPHistoricoA.setContentType("text/html");
        this.JTPHistoricoA.setFont(new Font("Arial", 1, 12));
        this.JTPHistoricoA.setCursor(new Cursor(0));
        this.JSPHistoricoA.setViewportView(this.JTPHistoricoA);
        this.JPIDFiltro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "FILTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBH_Nota.setFont(new Font("Arial", 1, 12));
        this.JCBH_Nota.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Tipo Nota", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBH_Nota.addItemListener(new ItemListener() { // from class: Historia.JPANotas.37
            public void itemStateChanged(ItemEvent evt) {
                JPANotas.this.JCBH_NotaItemStateChanged(evt);
            }
        });
        this.JCBH_Nota.addKeyListener(new KeyAdapter() { // from class: Historia.JPANotas.38
            public void keyPressed(KeyEvent evt) {
                JPANotas.this.JCBH_NotaKeyPressed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Aplicar filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Historia.JPANotas.39
            public void actionPerformed(ActionEvent evt) {
                JPANotas.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDFiltroLayout = new GroupLayout(this.JPIDFiltro);
        this.JPIDFiltro.setLayout(JPIDFiltroLayout);
        JPIDFiltroLayout.setHorizontalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBH_Nota, -2, 445, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro).addGap(158, 158, 158)));
        JPIDFiltroLayout.setVerticalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addGap(0, 8, 32767).addGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltro).addComponent(this.JCBH_Nota, -1, -1, -2))));
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistoricoA).addComponent(this.JPIDFiltro, -1, -1, 32767)).addGap(2, 2, 2)));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistoricoA, -1, 409, 32767).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTPDatos, -2, 781, -2).addGap(12, 12, 12)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTPDatos, -2, 547, -2).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPNotaKeyPressed(KeyEvent evt) {
        this.xmetodo.valiacionCaracterComillaSimpleTextPane(evt, this.JTPNota);
        if (evt.getKeyCode() == 9) {
            this.JTPNota.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) != null) {
            Object[] botones = {"Cargar", "Imprimir", "Cerrar"};
            int m = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (m == 0) {
                this.JTFNNota.setText(this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                mCargarDiagnosticos(this.JTFNNota.getText());
                this.JCBTipoNota.setSelectedItem(this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
                this.JDCFecha.setDate(this.xmetodo.getPasarTextoAFecha(this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 7).toString()));
                this.JTFFHora.setText(this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString());
                this.JTPNota.setText(this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString());
                this.JCBEspecialidad.setSelectedItem(this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 9).toString());
                this.JTFCDxP.setText("");
                this.JTFNCodigoDxP.setText("");
                this.JSOrden.setValue(new Integer(1));
                if (!this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString().equals("0") || Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                    this.xgrabar = true;
                    this.JTPNota.setEditable(true);
                } else {
                    int x = JOptionPane.showInternalOptionDialog(this, "Que accion desea realizar con este registro?", "CONFIRMACION", 1, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), new Object[]{"Modificar", "Imprimir", "Anular", "Cancelar"}, "Modificar");
                    if (x == 0) {
                        if (this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString().equals("0")) {
                            this.xgrabar = true;
                            this.JTPNota.setEditable(true);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Historia clínica ya se encuentra cerrada!!!", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else if (x == 1) {
                        mImprimirN(this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString(), this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString(), this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                        mNuevo();
                    } else if (x == 2) {
                        if (this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString().equals("0")) {
                            int z = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (z == 0) {
                                this.xsql = "update h_notasclinicas set    Estado=0 where Id='" + this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString() + "' and Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Historia clínica ya se encuentra cerrada!!!", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                        mNuevo();
                    } else if (x == 3) {
                        mNuevo();
                    }
                }
                this.JTPMenus.setSelectedIndex(0);
                this.nEvolucion = true;
                cargarValoraciones();
            } else if (m == 1) {
                mImprimirN(this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString(), this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString(), this.xmodelonota.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            }
            this.nEvolucion = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTempKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTempActionPerformed(ActionEvent evt) {
        mGrabar();
        if (!this.JTFNNota.getText().isEmpty()) {
            this.JBTGuardarValoraciones.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoNotaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.xidtiponota[this.JCBTipoNota.getSelectedIndex()][4].equals("1")) {
            mLlenarCombo();
        } else {
            this.JCBEspecialidad.removeAllItems();
            this.JCBEspecialidad.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBH_NotaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBH_Nota.getSelectedIndex() != -1) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBH_NotaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBEspecialidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mValidar_Fecha_Hora(this.xmetodo.formatoDMA1.format(this.JDCFecha.getDate()) + " " + this.JTFFHora.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mValidar_Fecha_Hora(this.xmetodo.formatoDMA1.format(this.JDCFecha.getDate()) + " " + this.JTFFHora.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPActionPerformed(ActionEvent evt) {
        mCargar_NotasP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargar_NotasP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
        mBuscarGuiasPatologias(this.JTFCDxP.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemp1ActionPerformed(ActionEvent evt) {
        if (this.JTFNNota.getText().isEmpty()) {
            if (!this.JTFCDxP.getText().isEmpty() && !this.JTFNCodigoDxP.getText().isEmpty()) {
                Object[] fila = {this.JTFCDxP.getText(), this.JTFNCodigoDxP.getText(), this.JSOrden.getValue()};
                this.xmodelo.addRow(fila);
                this.JTDetalle.setModel(this.xmodelo);
                this.JTFCDxP.setText("");
                this.JTFNCodigoDxP.setText("");
                this.JSOrden.setValue(new Integer(1));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Los campos no pueden estar vacios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP.setFocusable(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Esta nota ya se encuentra registrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemp1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JTFCDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNCodigoDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getRowCount() != 0 && this.JTDetalle.getSelectedRow() != -1 && this.JTFNNota.getText().isEmpty()) {
            this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_NCierreHCActionPerformed(ActionEvent evt) {
        if (this.JCH_NCierreHC.isSelected()) {
            this.xCerrarFac = 1L;
        } else {
            this.xCerrarFac = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoNotaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchMostrarNotasActionPerformed(ActionEvent evt) {
        if (!this.jchMostrarNotas.isSelected()) {
            this.jchMostrarNotas.setText("Mostrar todas las notas");
        } else {
            this.jchMostrarNotas.setText("Últimas notas");
        }
        mBuscar();
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarValoracionesActionPerformed(ActionEvent evt) {
        if (!this.JTFNNota.getText().isEmpty()) {
            grabarFechasValoraciones();
        } else {
            JOptionPane.showInternalMessageDialog(this, "¡Por favor guarde la nota!", "VALIDACIÓN", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarValoracionesKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInternistaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInternistaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaElectrocardiogramaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaElectrocardiogramaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaNutricionFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaNutricionPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaCardiologoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaCardiologoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaEcocardiogramaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaEcocardiogramaPropertyChange(PropertyChangeEvent evt) {
    }

    private void mCargar_NotasP() {
        JD_NotasPredefinidas dialog = new JD_NotasPredefinidas((Frame) null, true, this.JTPNota, this.JTPNota, 0);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void mValidar_Fecha_Hora(String xfecha) {
        if (this.JDCFecha.getDate() != null) {
        }
    }

    private void mLlenarCombo() {
        this.JCBEspecialidad.setEnabled(true);
        this.JCBEspecialidad.removeAllItems();
        ConsultasMySQL xct = new ConsultasMySQL();
        this.xsql = "SELECT `g_especialidad`.`Id`, `g_especialidad`.`Nbre` FROM `g_profesionalespecial` INNER JOIN `g_especialidad`  ON (`g_profesionalespecial`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN `g_profesional`  ON (`g_profesionalespecial`.`Id_Profesional` = `g_profesional`.`Id_Persona`) WHERE (`g_especialidad`.`Id` <>'" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `g_especialidad`.`RValoracion` =1 AND `g_profesional`.`P_Ips` =1) GROUP BY `g_especialidad`.`Id` ORDER BY `g_especialidad`.`Nbre` ASC ";
        this.xidespecialidad = xct.llenarCombo(this.xsql, this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
    }

    private void mBuscar() {
        if (this.jchMostrarNotas.isSelected()) {
            if (this.JCHFiltro.isSelected()) {
                if (this.JCBH_Nota.getSelectedIndex() != -1) {
                    if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                        this.xsql = "SELECT  `h_tiponota`.`Id`, concat(DATE_FORMAT(`h_notasclinicas`.`FechaNota`,'%d-%m-%Y'),`h_notasclinicas`.HoraNota) , `h_tiponota`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , `h_notasclinicas`.`Descripcion` , IF(g_patologia.`Nbre`  IS NULL, '', CONCAT('DIAGNÓSTICO(S):\\n', GROUP_CONCAT(CONCAT(g_patologia.Id ,' - ',g_patologia.`Nbre`) ORDER BY h_notaclinica_diagnostico.`NOrden` ASC SEPARATOR '\\n'))) AS NPatologia, IF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad FROM `h_notasclinicas` INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `h_tiponota_clasificacion`  ON (`h_tiponota_clasificacion`.`Id` = `h_tiponota`.`Id_Clasificacion`)  INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`)  LEFT JOIN `h_notaclinica_diagnostico`   ON (h_notaclinica_diagnostico.`Id_NClinica`= h_notasclinicas.`Id`) LEFT JOIN `g_patologia`  ON (g_patologia.Id = h_notaclinica_diagnostico.`Id_Patologia`) LEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`) LEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`) WHERE (`h_tiponota`.`Id`='" + this.xidtiponota_historico[this.JCBH_Nota.getSelectedIndex()] + "' AND h_tiponota_clasificacion.`Id` " + this.xFiltro + " and `h_tiponota`.`Es_Qx` <>2 AND `h_notasclinicas`.`Estado` =1 AND `h_notasclinicas`.`Id_Atencion` ='" + this.xId_Atencion + "' AND h_notasclinicas.FechaNota>= DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-01'), INTERVAL 1 MONTH)) GROUP BY `h_notasclinicas`.`Id`  ORDER BY `h_notasclinicas`.`FechaNota` DESC ";
                    } else {
                        this.xsql = "SELECT\n  h_tiponota.Id,CONCAT(DATE_FORMAT(h_notasclinicas.FechaNota,'%d-%m-%Y'),h_notasclinicas.HoraNota) AS fecha,\n  h_tiponota.Nbre, profesional1.Especialidad, profesional1.NProfesional, h_notasclinicas.Descripcion,\n  IF(g_patologia.Nbre IS NULL,'',CONCAT('DIAGNÓSTICO(S):\\\\n',GROUP_CONCAT(CONCAT(g_patologia.Id,' - ',g_patologia.Nbre) ORDER BY h_notaclinica_diagnostico.NOrden ASC SEPARATOR '\\\\n'))) AS NPatologia,\n  IF(g_especialidad.Nbre IS NULL,'',g_especialidad.Nbre) NEspecialidad\nFROM h_notasclinicas\n  INNER JOIN h_tiponota ON (h_notasclinicas.Id_TipoNota = h_tiponota.Id)\n  INNER JOIN profesional1 ON (profesional1.Id_Persona = h_notasclinicas.Id_Profesional) AND (profesional1.IdEspecialidad = h_notasclinicas.Id_Especialidad)\n  LEFT JOIN h_notaclinica_diagnostico ON (h_notaclinica_diagnostico.Id_NClinica = h_notasclinicas.Id)\n  LEFT JOIN g_patologia ON (g_patologia.Id = h_notaclinica_diagnostico.Id_Patologia)  \n  LEFT JOIN h_ordenes_interconsultas ON (h_ordenes_interconsultas.Id_Nota = h_notasclinicas.Id)\n  LEFT JOIN g_especialidad ON (h_ordenes_interconsultas.Id_Especialidad = g_especialidad.Id)\n  INNER JOIN h_atencion ON (h_notasclinicas.Id_Atencion = h_atencion.Id)\n  INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) AND (ingreso.Id_Usuario = (SELECT ingreso.Id_Usuario FROM h_atencion INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) WHERE (h_atencion.Id = '" + this.xId_Atencion + "')))\nWHERE (h_tiponota.Id = '" + this.xidtiponota_historico[this.JCBH_Nota.getSelectedIndex()] + "' AND h_tiponota.Es_Qx <> 2 AND h_notasclinicas.Estado = 1 AND h_notasclinicas.Id_Atencion <= '" + this.xId_Atencion + "'\n    AND h_notasclinicas.FechaNota >= DATE_SUB(DATE_FORMAT(NOW(), '%Y-%m-01'), INTERVAL 1 MONTH)\n  )GROUP BY h_notasclinicas.Id ORDER BY h_notasclinicas.FechaNota DESC";
                    }
                    mComponerDatos();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoNota.requestFocus();
                }
            } else {
                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    this.xsql = "SELECT  `h_tiponota`.`Id`, concat(DATE_FORMAT(`h_notasclinicas`.`FechaNota`,'%d-%m-%Y'),`h_notasclinicas`.HoraNota), `h_tiponota`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , `h_notasclinicas`.`Descripcion` , IF(g_patologia.`Nbre`  IS NULL, '', CONCAT('DIAGNÓSTICO(S):\n', GROUP_CONCAT(CONCAT(g_patologia.Id ,' - ',g_patologia.`Nbre`) ORDER BY h_notaclinica_diagnostico.`NOrden` ASC SEPARATOR '\n'))) AS NPatologia, IF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad FROM `h_notasclinicas` INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `h_tiponota_clasificacion`  ON (`h_tiponota_clasificacion`.`Id` = `h_tiponota`.`Id_Clasificacion`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`)  LEFT JOIN `h_notaclinica_diagnostico`   ON (h_notaclinica_diagnostico.`Id_NClinica`= h_notasclinicas.`Id`) LEFT JOIN `g_patologia`  ON (g_patologia.Id = h_notaclinica_diagnostico.`Id_Patologia`) LEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`) LEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`) WHERE (`h_tiponota`.`Es_Qx` <>2 AND h_tiponota_clasificacion.`Id` " + this.xFiltro + " AND `h_notasclinicas`.`Estado` =1 AND `h_notasclinicas`.`Id_Atencion` ='" + this.xId_Atencion + "' AND h_notasclinicas.FechaNota>= DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-01'), INTERVAL 1 MONTH)) GROUP BY `h_notasclinicas`.`Id`  ORDER BY `h_notasclinicas`.`FechaNota` DESC ";
                } else if (Principal.claseenfer != null) {
                    this.xsql = "SELECT\n  h_tiponota.Id, CONCAT(DATE_FORMAT(h_notasclinicas.FechaNota,'%d-%m-%Y'),h_notasclinicas.HoraNota) AS fecha,\n  h_tiponota.Nbre, profesional1.Especialidad, profesional1.NProfesional, h_notasclinicas.Descripcion,\n  IF(g_patologia.Nbre IS NULL,'',CONCAT('DIAGNÓSTICO(S):\\n',GROUP_CONCAT(CONCAT(g_patologia.Id,' - ',g_patologia.Nbre) ORDER BY h_notaclinica_diagnostico.NOrden ASC SEPARATOR '\\n'))) AS NPatologia,\n  IF(g_especialidad.Nbre IS NULL,'',g_especialidad.Nbre) NEspecialidad\nFROM  h_notasclinicas\n  INNER JOIN h_tiponota ON (h_notasclinicas.Id_TipoNota = h_tiponota.Id)\n  INNER JOIN profesional1 ON (profesional1.Id_Persona = h_notasclinicas.Id_Profesional) AND (profesional1.IdEspecialidad = h_notasclinicas.Id_Especialidad)\n  LEFT JOIN h_notaclinica_diagnostico ON (h_notaclinica_diagnostico.Id_NClinica = h_notasclinicas.Id)\n  LEFT JOIN g_patologia ON (g_patologia.Id = h_notaclinica_diagnostico.Id_Patologia)\n  LEFT JOIN h_ordenes_interconsultas ON (h_ordenes_interconsultas.Id_Nota = h_notasclinicas.Id)\n  LEFT JOIN g_especialidad ON (h_ordenes_interconsultas.Id_Especialidad = g_especialidad.Id) \n  INNER JOIN h_atencion ON (h_notasclinicas.Id_Atencion = h_atencion.Id)\n  INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) AND (ingreso.Id_Usuario = (SELECT ingreso.Id_Usuario FROM h_atencion INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) WHERE (h_atencion.Id = '" + this.xId_Atencion + "')))\nWHERE (h_tiponota.Es_Qx <> 2 AND h_notasclinicas.Estado = 1 AND h_notasclinicas.Id_Atencion <= '" + this.xId_Atencion + "'\n    AND h_notasclinicas.FechaNota >= DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-01'),INTERVAL 1 MONTH)\n  )GROUP BY h_notasclinicas.Id ORDER BY h_notasclinicas.FechaNota DESC";
                } else if (Principal.clasehistoriace != null) {
                    if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
                        this.xsql = "SELECT\n  h_tiponota.Id, CONCAT(DATE_FORMAT(h_notasclinicas.FechaNota,'%d-%m-%Y'),h_notasclinicas.HoraNota) AS fecha,\n  h_tiponota.Nbre, profesional1.Especialidad, profesional1.NProfesional, h_notasclinicas.Descripcion,\n  IF(g_patologia.Nbre IS NULL,'',CONCAT('DIAGNÓSTICO(S):\\n',GROUP_CONCAT(CONCAT(g_patologia.Id,' - ',g_patologia.Nbre) ORDER BY h_notaclinica_diagnostico.NOrden ASC SEPARATOR '\\n'))) AS NPatologia,\n  IF(g_especialidad.Nbre IS NULL,'',g_especialidad.Nbre) NEspecialidad\nFROM  h_notasclinicas\n  INNER JOIN h_tiponota ON (h_notasclinicas.Id_TipoNota = h_tiponota.Id)\n  INNER JOIN profesional1 ON (profesional1.Id_Persona = h_notasclinicas.Id_Profesional) AND (profesional1.IdEspecialidad = h_notasclinicas.Id_Especialidad)\n  LEFT JOIN h_notaclinica_diagnostico ON (h_notaclinica_diagnostico.Id_NClinica = h_notasclinicas.Id)\n  LEFT JOIN g_patologia ON (g_patologia.Id = h_notaclinica_diagnostico.Id_Patologia)\n  LEFT JOIN h_ordenes_interconsultas ON (h_ordenes_interconsultas.Id_Nota = h_notasclinicas.Id)\n  LEFT JOIN g_especialidad ON (h_ordenes_interconsultas.Id_Especialidad = g_especialidad.Id) \n  INNER JOIN h_atencion ON (h_notasclinicas.Id_Atencion = h_atencion.Id)\n  INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) AND (ingreso.Id_Usuario = (SELECT ingreso.Id_Usuario FROM h_atencion INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) WHERE (h_atencion.Id = '" + this.xId_Atencion + "')))\nWHERE (h_tiponota.Es_Qx <> 2 AND h_notasclinicas.Estado = 1 and profesional1.IdEspecialidad not in(3, 1025) AND h_notasclinicas.Id_Atencion <= '" + this.xId_Atencion + "'\n    AND h_notasclinicas.FechaNota >= DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-01'),INTERVAL 1 MONTH)\n  )GROUP BY h_notasclinicas.Id ORDER BY h_notasclinicas.FechaNota DESC";
                    } else {
                        this.xsql = "SELECT\n  h_tiponota.Id, CONCAT(DATE_FORMAT(h_notasclinicas.FechaNota,'%d-%m-%Y'),h_notasclinicas.HoraNota) AS fecha,\n  h_tiponota.Nbre, profesional1.Especialidad, profesional1.NProfesional, h_notasclinicas.Descripcion,\n  IF(g_patologia.Nbre IS NULL,'',CONCAT('DIAGNÓSTICO(S):\\n',GROUP_CONCAT(CONCAT(g_patologia.Id,' - ',g_patologia.Nbre) ORDER BY h_notaclinica_diagnostico.NOrden ASC SEPARATOR '\\n'))) AS NPatologia,\n  IF(g_especialidad.Nbre IS NULL,'',g_especialidad.Nbre) NEspecialidad\nFROM  h_notasclinicas\n  INNER JOIN h_tiponota ON (h_notasclinicas.Id_TipoNota = h_tiponota.Id)\n  INNER JOIN profesional1 ON (profesional1.Id_Persona = h_notasclinicas.Id_Profesional) AND (profesional1.IdEspecialidad = h_notasclinicas.Id_Especialidad)\n  LEFT JOIN h_notaclinica_diagnostico ON (h_notaclinica_diagnostico.Id_NClinica = h_notasclinicas.Id)\n  LEFT JOIN g_patologia ON (g_patologia.Id = h_notaclinica_diagnostico.Id_Patologia)\n  LEFT JOIN h_ordenes_interconsultas ON (h_ordenes_interconsultas.Id_Nota = h_notasclinicas.Id)\n  LEFT JOIN g_especialidad ON (h_ordenes_interconsultas.Id_Especialidad = g_especialidad.Id) \n  INNER JOIN h_atencion ON (h_notasclinicas.Id_Atencion = h_atencion.Id)\n  INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) AND (ingreso.Id_Usuario = (SELECT ingreso.Id_Usuario FROM h_atencion INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) WHERE (h_atencion.Id = '" + this.xId_Atencion + "')))\nWHERE (h_tiponota.Es_Qx <> 2 AND h_notasclinicas.Estado = 1 AND h_notasclinicas.Id_Atencion <= '" + this.xId_Atencion + "'\n    AND h_notasclinicas.FechaNota >= DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-01'),INTERVAL 1 MONTH)\n  )GROUP BY h_notasclinicas.Id ORDER BY h_notasclinicas.FechaNota DESC";
                    }
                }
                mComponerDatos();
            }
        } else if (this.JCHFiltro.isSelected()) {
            if (this.JCBH_Nota.getSelectedIndex() != -1) {
                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    this.xsql = "SELECT  `h_tiponota`.`Id`, concat(DATE_FORMAT(`h_notasclinicas`.`FechaNota`,'%d-%m-%Y'),`h_notasclinicas`.HoraNota) , `h_tiponota`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , `h_notasclinicas`.`Descripcion` , IF(g_patologia.`Nbre`  IS NULL, '', CONCAT('DIAGNÓSTICO(S):\\n', GROUP_CONCAT(CONCAT(g_patologia.Id ,' - ',g_patologia.`Nbre`) ORDER BY h_notaclinica_diagnostico.`NOrden` ASC SEPARATOR '\\n'))) AS NPatologia, IF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad FROM `h_notasclinicas` INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `h_tiponota_clasificacion`  ON (`h_tiponota_clasificacion`.`Id` = `h_tiponota`.`Id_Clasificacion`)  INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`)  LEFT JOIN `h_notaclinica_diagnostico`   ON (h_notaclinica_diagnostico.`Id_NClinica`= h_notasclinicas.`Id`) LEFT JOIN `g_patologia`  ON (g_patologia.Id = h_notaclinica_diagnostico.`Id_Patologia`) LEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`) LEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`) WHERE (`h_tiponota`.`Id`='" + this.xidtiponota_historico[this.JCBH_Nota.getSelectedIndex()] + "' AND h_tiponota_clasificacion.`Id` " + this.xFiltro + " and `h_tiponota`.`Es_Qx` <>2 AND `h_notasclinicas`.`Estado` =1 AND `h_notasclinicas`.`Id_Atencion` ='" + this.xId_Atencion + "') GROUP BY `h_notasclinicas`.`Id`  ORDER BY `h_notasclinicas`.`FechaNota` DESC ";
                } else {
                    this.xsql = "SELECT\n  h_tiponota.Id,CONCAT(DATE_FORMAT(h_notasclinicas.FechaNota,'%d-%m-%Y'),h_notasclinicas.HoraNota) AS fecha,\n  h_tiponota.Nbre,  profesional1.Especialidad,  profesional1.NProfesional,  h_notasclinicas.Descripcion,\n  IF(g_patologia.Nbre IS NULL,'',CONCAT('DIAGNÓSTICO(S):\\\\n',GROUP_CONCAT(CONCAT(g_patologia.Id,' - ',g_patologia.Nbre) ORDER BY h_notaclinica_diagnostico.NOrden ASC SEPARATOR '\\\\n'))) AS NPatologia,\n  IF(g_especialidad.Nbre IS NULL,'',g_especialidad.Nbre) NEspecialidad\nFROM\n  h_notasclinicas\n  INNER JOIN h_tiponota ON (h_notasclinicas.Id_TipoNota = h_tiponota.Id)\n  INNER JOIN profesional1 ON (profesional1.Id_Persona = h_notasclinicas.Id_Profesional) AND (profesional1.IdEspecialidad = h_notasclinicas.Id_Especialidad)\n  LEFT JOIN h_notaclinica_diagnostico ON (h_notaclinica_diagnostico.Id_NClinica = h_notasclinicas.Id)\n  LEFT JOIN g_patologia ON (g_patologia.Id = h_notaclinica_diagnostico.Id_Patologia)\n  LEFT JOIN h_ordenes_interconsultas ON (h_ordenes_interconsultas.Id_Nota = h_notasclinicas.Id)\n  LEFT JOIN g_especialidad ON (h_ordenes_interconsultas.Id_Especialidad = g_especialidad.Id)\n  INNER JOIN h_atencion ON (h_notasclinicas.Id_Atencion = h_atencion.Id)\n  INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) AND (ingreso.Id_Usuario = (SELECT ingreso.Id_Usuario FROM h_atencion INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) WHERE (h_atencion.Id = '" + this.xId_Atencion + "')))\nWHERE (h_tiponota.Id = '" + this.xidtiponota_historico[this.JCBH_Nota.getSelectedIndex()] + "' AND h_tiponota.Es_Qx <> 2 AND h_notasclinicas.Estado = 1 AND h_notasclinicas.Id_Atencion <= '" + this.xId_Atencion + "'\n  )GROUP BY h_notasclinicas.Id ORDER BY h_notasclinicas.FechaNota DESC";
                }
                mComponerDatos();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoNota.requestFocus();
            }
        } else {
            if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                this.xsql = "SELECT  `h_tiponota`.`Id`, concat(DATE_FORMAT(`h_notasclinicas`.`FechaNota`,'%d-%m-%Y'),`h_notasclinicas`.HoraNota), `h_tiponota`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , `h_notasclinicas`.`Descripcion` , IF(g_patologia.`Nbre`  IS NULL, '', CONCAT('DIAGNÓSTICO(S):\n', GROUP_CONCAT(CONCAT(g_patologia.Id ,' - ',g_patologia.`Nbre`) ORDER BY h_notaclinica_diagnostico.`NOrden` ASC SEPARATOR '\n'))) AS NPatologia, IF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad FROM `h_notasclinicas` INNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `h_tiponota_clasificacion`  ON (`h_tiponota_clasificacion`.`Id` = `h_tiponota`.`Id_Clasificacion`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`)  LEFT JOIN `h_notaclinica_diagnostico`   ON (h_notaclinica_diagnostico.`Id_NClinica`= h_notasclinicas.`Id`) LEFT JOIN `g_patologia`  ON (g_patologia.Id = h_notaclinica_diagnostico.`Id_Patologia`) LEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`) LEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`) WHERE (`h_tiponota`.`Es_Qx` <>2 AND h_tiponota_clasificacion.`Id` " + this.xFiltro + " AND `h_notasclinicas`.`Estado` =1 AND `h_notasclinicas`.`Id_Atencion` ='" + this.xId_Atencion + "') GROUP BY `h_notasclinicas`.`Id`  ORDER BY `h_notasclinicas`.`FechaNota` DESC ";
            } else {
                this.xsql = "SELECT\n  h_tiponota.Id, CONCAT(DATE_FORMAT(h_notasclinicas.FechaNota,'%d-%m-%Y'), h_notasclinicas.HoraNota) AS fecha,\n  h_tiponota.Nbre, profesional1.Especialidad, profesional1.NProfesional, h_notasclinicas.Descripcion,\n  IF(g_patologia.Nbre IS NULL,'',CONCAT('DIAGNÓSTICO(S):\\n',GROUP_CONCAT(CONCAT(g_patologia.Id,' - ',g_patologia.Nbre) ORDER BY h_notaclinica_diagnostico.NOrden ASC SEPARATOR '\\n'))) AS NPatologia,\n  IF(g_especialidad.Nbre IS NULL,'',g_especialidad.Nbre) NEspecialidad\nFROM h_notasclinicas\n  INNER JOIN h_tiponota ON (h_notasclinicas.Id_TipoNota = h_tiponota.Id)\n  INNER JOIN profesional1 ON (profesional1.Id_Persona = h_notasclinicas.Id_Profesional) AND (profesional1.IdEspecialidad = h_notasclinicas.Id_Especialidad)\n  LEFT JOIN h_notaclinica_diagnostico ON (h_notaclinica_diagnostico.Id_NClinica = h_notasclinicas.Id)\n  LEFT JOIN g_patologia ON (g_patologia.Id = h_notaclinica_diagnostico.Id_Patologia)\n  LEFT JOIN h_ordenes_interconsultas ON (h_ordenes_interconsultas.Id_Nota = h_notasclinicas.Id)\n  LEFT JOIN g_especialidad ON (h_ordenes_interconsultas.Id_Especialidad = g_especialidad.Id)\n  INNER JOIN h_atencion ON (h_notasclinicas.Id_Atencion = h_atencion.Id)\n  INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) AND (ingreso.Id_Usuario = (SELECT ingreso.Id_Usuario FROM h_atencion INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) WHERE (h_atencion.Id = '" + this.xId_Atencion + "')))\nWHERE (h_tiponota.Es_Qx <> 2 AND h_notasclinicas.Estado = 1 AND h_notasclinicas.Id_Atencion <= '" + this.xId_Atencion + "'\n  )GROUP BY h_notasclinicas.Id ORDER BY h_notasclinicas.FechaNota DESC";
            }
            mComponerDatos();
        }
        this.nEvolucion = true;
    }

    public void mGrabar() {
        if (this.JTFNNota.getText().isEmpty()) {
            if (this.JCBTipoNota.getSelectedIndex() != -1) {
                if (!this.xidtiponota[this.JCBTipoNota.getSelectedIndex()][2].equals("0")) {
                    if (this.JTPNota.getText().isEmpty()) {
                        JOptionPane.showInternalMessageDialog(this, "El campo no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFNNota.requestFocus();
                        return;
                    }
                    if (this.xId_Atencion != 0) {
                        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                            String sql = "insert into  h_notasclinicas (Id_Atencion, Id_Tipo_Atencion, FechaNota, HoraNota, Id_TipoNota, Descripcion, Id_Profesional, Id_Especialidad, NCierre, Fecha, UsuarioS) values ('" + this.xId_Atencion + "','" + this.xTipoAtencion + "','" + this.xmetodo.formatoAMD.format(this.JDCFecha.getDate()) + "',IF('" + this.JTFFHora.getText() + "'='24:00:00','23:59:59','" + this.JTFFHora.getText() + "'),'" + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()][0] + "','" + this.JTPNota.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xCerrarFac + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.JTFNNota.setText(this.xct.ejecutarSQLId(sql));
                            this.xct.cerrarConexionBd();
                            mRecorrerTabla();
                            mGrabarInterconsulta();
                            mCrearTabla();
                            mCargarDatosTabla();
                            mActualizarEstadoAtencionEspecial();
                            mActualizarCerrarFacturacionIngreso();
                            if (!this.xidtiponota[this.JCBTipoNota.getSelectedIndex()][0].equals("0")) {
                                mGrabar_Facturacion(this.JTFNNota.getText());
                            }
                            mBuscar();
                            if (Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS")) {
                                String sql2 = "update c_citas set Asistida=3 where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCita() + "'";
                                this.xct.ejecutarSQL(sql2);
                                this.xct.cerrarConexionBd();
                                if (this.JCH_NCierreHC.isSelected()) {
                                    Principal.clasehistoriace.mCambiarEstadoHc(1);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBEspecialidad.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe tener una atencion activa ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                if (this.JTPNota.getText().isEmpty()) {
                    JOptionPane.showInternalMessageDialog(this, "El campo no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFNNota.requestFocus();
                    return;
                }
                if (this.xId_Atencion != 0) {
                    String sql3 = "insert into  h_notasclinicas (Id_Atencion, FechaNota, HoraNota,  `Id_Tipo_Atencion`, Id_TipoNota, Descripcion, Id_Profesional, Id_Especialidad,Fecha, UsuarioS) values ('" + this.xId_Atencion + "','" + this.xmetodo.formatoAMD.format(this.JDCFecha.getDate()) + "',IF('" + this.JTFFHora.getText() + "'>='24:00:00','23:59:59','" + this.JTFFHora.getText() + "'),'" + this.xTipoAtencion + "','" + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()][0] + "','" + this.JTPNota.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JTFNNota.setText(this.xct.ejecutarSQLId(sql3));
                    this.JTPNota.setText(this.JTPNota.getText().toUpperCase());
                    this.xct.cerrarConexionBd();
                    mRecorrerTabla();
                    mCrearTabla();
                    mCargarDatosTabla();
                    mActualizarEstadoAtencionEspecial();
                    mGrabarInterconsulta();
                    if (!Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS")) {
                        mCambiar_Estado_Egreso();
                    }
                    mBuscar();
                    if (Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS")) {
                        String sql4 = "update c_citas set Asistida=3 where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCita() + "'";
                        this.xct.ejecutarSQL(sql4);
                        this.xct.cerrarConexionBd();
                        if (this.JCH_NCierreHC.isSelected()) {
                            Principal.clasehistoriace.mCambiarEstadoHc(1);
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe tener una atencion activa ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoNota.requestFocus();
            return;
        }
        if (this.xgrabar && this.JTBDetalle.getSelectedRow() != -1 && Principal.usuarioSistemaDTO.getNombreUsuario().equals(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 4)) && !Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS") && !Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            String sql5 = "update  h_notasclinicas set  Id_TipoNota='" + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()][0] + "', Descripcion='" + this.JTPNota.getText() + "', FechaNota='" + this.xmetodo.formatoAMD.format(this.JDCFecha.getDate()) + "', HoraNota= IF('" + this.JTFFHora.getText() + "'>='24:00:00','23:59:59','" + this.JTFFHora.getText() + "')  where Id='" + this.JTFNNota.getText() + "' and Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'";
            this.JTPNota.setText(this.JTPNota.getText().toUpperCase());
            this.xct.ejecutarSQL(sql5);
            this.xct.cerrarConexionBd();
            mCargarDatosTabla();
            mActualizarEstadoAtencionEspecial();
            mNuevo();
        }
    }

    private void mCambiar_Estado_Egreso() {
        if (Principal.clasehistoriace != null) {
            clasesHistoriaCE claseshistoriace = Principal.clasehistoriace;
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsAtencionEspecial().intValue() != 0) {
                this.xsql = "update h_egreso_atencion set Estado=1 WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `Estado` =1) ";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "update ingreso set `Egreso`=0 , `FEgreso`=null WHERE (`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "') ";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setText(this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()));
        this.JTFNNota.setText("");
        this.JTPNota.setText("");
        this.JTPNota.setEditable(true);
        this.JCBTipoNota.removeAllItems();
        this.JCBEspecialidad.removeAllItems();
        this.xsql = "SELECT `h_tiponota`.`Id` , `h_tiponota`.`Nbre`, `h_tiponota`.Orden, `h_tiponota_especialidad`.Id_Procedimiento, `h_tiponota`.`NReporte`, h_tiponota_especialidad.EsInterconsulta, `h_tiponota_clasificacion`.`Id` FROM `h_tiponota_especialidad` INNER JOIN  `h_tiponota`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `h_tiponota_clasificacion`  ON (`h_tiponota_clasificacion`.`Id` = `h_tiponota`.`Id_Clasificacion`)  WHERE (`h_tiponota_especialidad`.`Id_Especialidad` ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `h_tiponota_especialidad`.`Estado` =1 AND h_tiponota_clasificacion.`Id` " + this.xFiltro + ") ORDER BY `h_tiponota`.Orden ASC,`h_tiponota`.`Nbre` ASC ";
        this.xidtiponota = this.xct.llenarComboyLista(this.xsql, this.xidtiponota, this.JCBTipoNota, 7);
        if (this.xidtiponota.length > 1) {
            this.JCBTipoNota.setSelectedIndex(-1);
        }
        this.xsql = "SELECT  h_tiponota.Id,  h_tiponota.Nbre\nFROM  h_notasclinicas INNER JOIN h_tiponota ON (h_notasclinicas.Id_TipoNota = h_tiponota.Id)\nINNER JOIN h_atencion ON (h_notasclinicas.Id_Atencion = h_atencion.Id)\nINNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) AND (ingreso.Id_Usuario = (SELECT ingreso.Id_Usuario FROM h_atencion INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso) WHERE (h_atencion.Id = '" + this.xId_Atencion + "')) )\nWHERE (h_tiponota.Es_Qx <> 2 AND h_notasclinicas.Estado = 1 AND h_notasclinicas.Id_Atencion <= '" + this.xId_Atencion + "')\nGROUP BY h_tiponota.Id ORDER BY h_tiponota.Nbre ASC";
        this.xidtiponota_historico = this.xct.llenarCombo(this.xsql, this.xidtiponota_historico, this.JCBH_Nota);
        this.JCBH_Nota.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mLlenarCombo();
        mCrearTabla();
        mCargarDatosTabla();
        mBuscar();
        if (this.xFiltro.equals("in(5)")) {
            this.JCBEspecialidad.setEnabled(true);
        } else {
            this.JCBEspecialidad.setEnabled(false);
        }
        this.xlleno = true;
        this.xgrabar = false;
        this.JTPNota.requestFocus();
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JSOrden.setValue(new Integer(1));
        mCrearModeloDatos();
        this.jchMostrarNotas.setSelected(true);
        if (!this.jchMostrarNotas.isSelected()) {
            this.jchMostrarNotas.setText("Mostrar todas las notas");
        } else {
            this.jchMostrarNotas.setText("Últimas notas");
        }
        if (Principal.informacionIps.getIdentificacion().equals("900293903")) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaMedicoInterno = dateFormat.parse("01/01/1845");
                Date fechaNutricion = dateFormat.parse("01/01/1845");
                Date fechaEKG = dateFormat.parse("01/01/1845");
                Date fechaETT = dateFormat.parse("01/01/1845");
                Date fechaCardiologo = dateFormat.parse("01/01/1845");
                this.JDCFechaCardiologo.setDate(fechaCardiologo);
                this.JDCFechaEcocardiograma.setDate(fechaETT);
                this.JDCFechaElectrocardiograma.setDate(fechaEKG);
                this.JDCFechaInternista.setDate(fechaMedicoInterno);
                this.JDCFechaNutricion.setDate(fechaNutricion);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelonota = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha y Hora", "Descripción", "Especialidad", "Profesional", "Tipo Nota", "EstadoHC", "Fecha", "Hora", "Especilidad", "idClasificacionTipoNota"}) { // from class: Historia.JPANotas.40
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelonota);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
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
    }

    private void mCrearTabla_1() {
        this.xmodelonota = new DefaultTableModel();
        this.xmodelonota.addColumn("Id");
        this.xmodelonota.addColumn("Fecha y Hora");
        this.xmodelonota.addColumn("Descripcion");
        this.xmodelonota.addColumn("Especialidad");
        this.xmodelonota.addColumn("Profesional");
        this.xmodelonota.addColumn("Tipo Nota");
        this.xmodelonota.addColumn("EstadoHC");
        this.JTBDetalle.setModel(this.xmodelonota);
        this.column = this.JTBDetalle.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(10);
        this.column = this.JTBDetalle.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(30);
        this.column = this.JTBDetalle.getColumnModel().getColumn(2);
        this.column.setPreferredWidth(100);
        this.column = this.JTBDetalle.getColumnModel().getColumn(3);
        this.column.setPreferredWidth(50);
        this.column = this.JTBDetalle.getColumnModel().getColumn(4);
        this.column.setPreferredWidth(100);
        this.column = this.JTBDetalle.getColumnModel().getColumn(5);
        this.column.setPreferredWidth(30);
        this.column = this.JTBDetalle.getColumnModel().getColumn(6);
        this.column.setPreferredWidth(0);
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            mCrearTabla();
            if (this.jchMostrarNotas.isSelected()) {
                if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
                    if (Principal.claseenfer != null) {
                        System.out.println("v1");
                        sql = "SELECT h_notasclinicas.Id, \nDATE_FORMAT(h_notasclinicas.FechaNota, '%d-%m-%Y') AS fecha, \nh_notasclinicas.HoraNota, \nh_notasclinicas.Descripcion, \nge.Nbre Especialidad, \nconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2)NProfesional,\nh_tiponota.`Nbre`,\n`h_atencion`.`TipoGuardado`, \nIF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad, \nh_tiponota.NReporte \nFROM h_notasclinicas \ninner join g_profesional gp2 on (gp2.Id_Persona=h_notasclinicas.Id_Profesional)\nINNER JOIN  g_persona gp  ON (gp.Id  = gp2.Id_Persona)\ninner join g_especialidad ge on (h_notasclinicas.Id_Especialidad = ge.Id) \nINNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) \nINNER JOIN `h_atencion`   ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) \nLEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`)\nLEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`)\nWHERE (h_notasclinicas.Id_Atencion =" + this.xId_Atencion + " and h_notasclinicas.Estado=1 AND h_notasclinicas.FechaNota>= DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-01'), INTERVAL 1 MONTH)) \nORDER BY h_notasclinicas.FechaNota DESC, h_notasclinicas.HoraNota DESC ";
                    } else {
                        System.out.println("v2");
                        sql = "SELECT h_notasclinicas.Id, \nDATE_FORMAT(h_notasclinicas.FechaNota, '%d-%m-%Y') AS fecha, \nh_notasclinicas.HoraNota, \nh_notasclinicas.Descripcion, \nge.Nbre Especialidad, \nconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2)NProfesional,\nh_tiponota.`Nbre`,\n`h_atencion`.`TipoGuardado`, \nIF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad, \nh_tiponota.NReporte \nFROM h_notasclinicas \ninner join g_profesional gp2 on (gp2.Id_Persona=h_notasclinicas.Id_Profesional)\nINNER JOIN  g_persona gp  ON (gp.Id  = gp2.Id_Persona)\ninner join g_especialidad ge on (h_notasclinicas.Id_Especialidad = ge.Id) \nINNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) \nINNER JOIN `h_atencion`   ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) \nLEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`)\nLEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`)\nWHERE (h_notasclinicas.Id_Atencion =" + this.xId_Atencion + "  and ge.id not in(3, 1025)  and h_notasclinicas.Estado=1 AND h_notasclinicas.FechaNota>= DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-01'), INTERVAL 1 MONTH)) \nORDER BY h_notasclinicas.FechaNota DESC, h_notasclinicas.HoraNota DESC ";
                    }
                } else {
                    System.out.println("3");
                    sql = "SELECT h_notasclinicas.Id, \nDATE_FORMAT(h_notasclinicas.FechaNota, '%d-%m-%Y') AS fecha, \nh_notasclinicas.HoraNota, \nh_notasclinicas.Descripcion, \nge.Nbre Especialidad, \nconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2)NProfesional,\nh_tiponota.`Nbre`,\n`h_atencion`.`TipoGuardado`, \nIF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad, \nh_tiponota.NReporte \nFROM h_notasclinicas \ninner join g_profesional gp2 on (gp2.Id_Persona=h_notasclinicas.Id_Profesional)\nINNER JOIN  g_persona gp  ON (gp.Id  = gp2.Id_Persona)\ninner join g_especialidad ge on (h_notasclinicas.Id_Especialidad = ge.Id) \nINNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) \nINNER JOIN `h_atencion`   ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) \nLEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`)\nLEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`)\nWHERE (h_notasclinicas.Id_Atencion =" + this.xId_Atencion + " and h_notasclinicas.Estado=1 AND h_notasclinicas.FechaNota>= DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-01'), INTERVAL 1 MONTH)) \nORDER BY h_notasclinicas.FechaNota DESC, h_notasclinicas.HoraNota DESC ";
                }
            } else if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
                if (Principal.claseenfer != null) {
                    System.out.println("4");
                    sql = "SELECT h_notasclinicas.Id, \nDATE_FORMAT(h_notasclinicas.FechaNota, '%d-%m-%Y') AS fecha, \nh_notasclinicas.HoraNota, \nh_notasclinicas.Descripcion, \nge.Nbre Especialidad, \nconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2)NProfesional,\nh_tiponota.`Nbre`, \n`h_atencion`.`TipoGuardado`, \nIF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad,\nh_tiponota.NReporte \nFROM h_notasclinicas \ninner join g_profesional gp2 on (gp2.Id_Persona=h_notasclinicas.Id_Profesional)\nINNER JOIN  g_persona gp  ON (gp.Id  = gp2.Id_Persona)\ninner join g_especialidad ge on (h_notasclinicas.Id_Especialidad = ge.Id) \nINNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) \nINNER JOIN `h_atencion`   ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) \nLEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`) \nLEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`)\nWHERE (h_notasclinicas.Id_Atencion =" + this.xId_Atencion + " and h_notasclinicas.Estado=1) \nORDER BY h_notasclinicas.FechaNota DESC, h_notasclinicas.HoraNota DESC ";
                } else {
                    System.out.println("5");
                    sql = "SELECT h_notasclinicas.Id, \nDATE_FORMAT(h_notasclinicas.FechaNota, '%d-%m-%Y') AS fecha, \nh_notasclinicas.HoraNota, \nh_notasclinicas.Descripcion, \nge.Nbre Especialidad, \nconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2)NProfesional,\nh_tiponota.`Nbre`, \n`h_atencion`.`TipoGuardado`, \nIF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad,\nh_tiponota.NReporte \nFROM h_notasclinicas \ninner join g_profesional gp2 on (gp2.Id_Persona=h_notasclinicas.Id_Profesional)\nINNER JOIN  g_persona gp  ON (gp.Id  = gp2.Id_Persona)\ninner join g_especialidad ge on (h_notasclinicas.Id_Especialidad = ge.Id) \nINNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) \nINNER JOIN `h_atencion`   ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) \nLEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`) \nLEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`)\nWHERE (h_notasclinicas.Id_Atencion =" + this.xId_Atencion + " and ge.id not in(3, 1025)  and h_notasclinicas.Estado=1) \nORDER BY h_notasclinicas.FechaNota DESC, h_notasclinicas.HoraNota DESC ";
                }
            } else {
                System.out.println("6");
                sql = "SELECT h_notasclinicas.Id, \nDATE_FORMAT(h_notasclinicas.FechaNota, '%d-%m-%Y') AS fecha, \nh_notasclinicas.HoraNota, \nh_notasclinicas.Descripcion, \nge.Nbre Especialidad, \nconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1 ,' ', gp.Nombre2)NProfesional,\nh_tiponota.`Nbre`, \n`h_atencion`.`TipoGuardado`, \nIF(g_especialidad.`Nbre` IS NULL, '', g_especialidad.`Nbre`) NEspecialidad,\nh_tiponota.NReporte \nFROM h_notasclinicas \ninner join g_profesional gp2 on (gp2.Id_Persona=h_notasclinicas.Id_Profesional)\nINNER JOIN  g_persona gp  ON (gp.Id  = gp2.Id_Persona)\ninner join g_especialidad ge on (h_notasclinicas.Id_Especialidad = ge.Id) \nINNER JOIN `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) \nINNER JOIN `h_atencion`   ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) \nLEFT JOIN `h_ordenes_interconsultas`  ON (h_ordenes_interconsultas.`Id_Nota` = h_notasclinicas.`Id`) \nLEFT JOIN `g_especialidad`ON (h_ordenes_interconsultas.`Id_Especialidad` = g_especialidad.`Id`)\nWHERE (h_notasclinicas.Id_Atencion =" + this.xId_Atencion + " and h_notasclinicas.Estado=1) \nORDER BY h_notasclinicas.FechaNota DESC, h_notasclinicas.HoraNota DESC ";
            }
            ResultSet rs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    rs.next();
                    if (rs.getRow() != 0) {
                        rs.beforeFirst();
                        int i = 0;
                        while (rs.next()) {
                            this.xmodelonota.addRow(this.dato);
                            this.xmodelonota.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                            this.xmodelonota.setValueAt(rs.getString(2) + " " + rs.getString(3), i, 1);
                            this.xmodelonota.setValueAt(rs.getString(4), i, 2);
                            this.xmodelonota.setValueAt(rs.getString(5), i, 3);
                            this.xmodelonota.setValueAt(rs.getString(6), i, 4);
                            this.xmodelonota.setValueAt(rs.getString(7), i, 5);
                            this.xmodelonota.setValueAt(rs.getString(8), i, 6);
                            this.xmodelonota.setValueAt(rs.getString(2), i, 7);
                            this.xmodelonota.setValueAt(rs.getString(3), i, 8);
                            this.xmodelonota.setValueAt(rs.getString("NEspecialidad"), i, 9);
                            this.xmodelonota.setValueAt(rs.getString("NReporte"), i, 10);
                            i++;
                        }
                    }
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPANotas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarEstadoAtencionEspecial() {
        if (!this.xId_AtencionEsp.equals("0")) {
            String xsql = "update h_atencionespeciales set EstadoA=1 where Id='" + this.xId_AtencionEsp + "'";
            this.xct.ejecutarSQL(xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mActualizarCerrarFacturacionIngreso() {
        if (this.JCH_NCierreHC.isSelected()) {
            String xsql = "update ingreso set AFacturar=1 where Id='" + this.xIdIngreso + "'";
            this.xct.ejecutarSQL(xsql);
            this.xct.cerrarConexionBd();
        }
    }

    public void mImprimir() {
        if (!this.JTFNNota.getText().isEmpty()) {
            mImprimirN(this.JCBTipoNota.getSelectedItem().toString(), this.xidtiponota[this.JCBTipoNota.getSelectedIndex()][3], this.JTFNNota.getText());
        }
    }

    public void mImprimirN(String nombreTipoNota, String nombreReporte, String idNota) {
        ImpresionDocumentosHC impresionDocumentos = new ImpresionDocumentosHC();
        impresionDocumentos.mImprimirNotasClinciasNuevasIdNota(nombreTipoNota, nombreReporte, String.valueOf(this.xId_Atencion), idNota);
    }

    private void mGrabarInterconsulta() {
        System.out.println("Tipo de Nota : " + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()][4]);
        if (Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL LOCAL DE PUERTO LIBERTADOR") || this.xidtiponota[this.JCBTipoNota.getSelectedIndex()][4].equals("1")) {
            this.xsql = "insert into h_ordenes_interconsultas(`Id_Nota`, `Id_Especialidad`, `UsuarioS`) values('" + this.JTFNNota.getText() + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mComponerDatos() {
        try {
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                String xparte3 = "";
                String xparte4 = "";
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        String xparte1 = "<font face='Arial' color='red' size=4>" + xrs.getString(2) + "  :" + xrs.getString(4) + " - " + xrs.getString(5) + "</font><br>";
                        String xparte2 = xrs.getString(3) + " :" + xrs.getString(6) + "<br>" + xrs.getString(7);
                        if (!xrs.getString("NEspecialidad").equals("")) {
                            xparte4 = "ESPECIALIDAD SOLICITADA : " + xrs.getString("NEspecialidad") + "<br>";
                        }
                        xparte3 = xparte3 + xparte1 + " " + xparte2 + "<br>" + xparte4 + "<br><br>--------------------------------------------------------------------------------------<br>";
                    }
                }
                this.JTPHistoricoA.setText(xparte3);
                this.JTPHistoricoA.setCaretPosition(0);
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
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPANotas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabar_Facturacion(String xId) {
        if (!Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.xsql = "INSERT INTO `f_ordenes`( `Id_Ingreso` , `Id_TipoServicio` , `FechaOrden` , `HoraOrden` , `Id_Profesional` , `Id_Especialidad` , `Id_CentroCosto` , `TotalOrdenes` , `TotalEPS` ,  `TotalPaciente` , `Fecha` , `UsuarioS`)    SELECT  `f_tiposervtipoproced`.`Idtiposervicio` , `h_notasclinicas`.`FechaNota` , `h_notasclinicas`.`HoraNota`, `h_notasclinicas`.`Id_Profesional` , `h_notasclinicas`.`Id_Especialidad` , `f_procedimcentrocosto`.`Id_CentroCosto` , (((`f_tarifaprocedimiento`.`VrMinimo`*g_procedimiento.porcentajeImpuesto)/100)+`f_tarifaprocedimiento`.`VrMinimo`) AS `VOrden` , IF(`f_tarifaprocedimiento`.`Id_TipoPlan`=`f_empresacontxconvenio`.`Id_TipoPlan`, (((`f_tarifaprocedimiento`.`VrMinimo`*g_procedimiento.porcentajeImpuesto)/100)+`f_tarifaprocedimiento`.`VrMinimo`),0) AS `VEps` , IF(`f_tarifaprocedimiento`.`Id_TipoPlan`=`f_empresacontxconvenio`.`Id_TipoPlan`, (((`f_tarifaprocedimiento`.`VrMinimo`*g_procedimiento.porcentajeImpuesto)/100) +`f_tarifaprocedimiento`.`VrMinimo`),0) AS `VUsuario` FROM `h_notasclinicas` INNER JOIN  `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_Especialidad` = `h_notasclinicas`.`Id_Especialidad`) INNER JOIN  `h_atencion`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) AND (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_tarifaprocedimiento`  ON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `h_tiponota_especialidad`.`Id_Procedimiento`) AND (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifaprocedimiento`.`Id_Manual`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `h_tiponota_especialidad`.`Id_Procedimiento`) INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_procedimcentrocosto`  ON (`f_procedimcentrocosto`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`h_notasclinicas`.`Id` ='" + xId + "') GROUP BY `g_procedimiento`.`Id` ";
            String xN_Orden = this.xct.ejecutarSQLId(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "INSERT INTO `f_itemordenesproced`( `Id_Ordenes` , `Id_Procedimiento` , `Id_TipofinProc` , `Cantidad` , `ValorUnitario`, porcentajeImpuesto, valorImpuesto , `Id_CentroCosto` , Plan,  `Fecha` , `UsuarioS`) SELECT  '" + xN_Orden + "', `g_procedimiento`.`Id` , `g_procedimiento`.`Id_TipoFinProced` , 1, `f_tarifaprocedimiento`.`VrMinimo` AS `VOrden`, g_procedimiento.porcentajeImpuesto, ((`f_tarifaprocedimiento`.`VrMinimo`*g_procedimiento.porcentajeImpuesto)/100) AS ValorImpuesto ,`f_procedimcentrocosto`.`Id_CentroCosto` , `f_tarifaprocedimiento`.`Id_TipoPlan` , NOW() AS `FEcha`,'" + Principal.usuarioSistemaDTO.getLogin() + "' FROM `h_notasclinicas` INNER JOIN  `h_tiponota`  ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `h_tiponota_especialidad`  ON (`h_tiponota_especialidad`.`Id_Especialidad` = `h_notasclinicas`.`Id_Especialidad`) INNER JOIN  `h_atencion`  ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`) AND (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_tarifaprocedimiento`  ON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `h_tiponota_especialidad`.`Id_Procedimiento`) AND (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifaprocedimiento`.`Id_Manual`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `h_tiponota_especialidad`.`Id_Procedimiento`) INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_procedimcentrocosto`  ON (`f_procedimcentrocosto`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`h_notasclinicas`.`Id` ='" + xId + "') GROUP BY `g_procedimiento`.`Id` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update h_notasclinicas set Id_OrdenF='" + xN_Orden + "' Where Id='" + xId + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mBuscarGuiasPatologias(String codigo) {
        try {
            String sql = "SELECT PathGuia FROM h_patologiaxguiamanejo WHERE (Id_Patologia ='" + codigo + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                int x = JOptionPane.showInternalConfirmDialog(this, "El código tiene una guia asociada \n\t\t Desea consultarla?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xmetodo.mostrarPdf(xrs.getString(1));
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPANotas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOGÍA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "conclusion", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Diagnóstico", "Nº Orden"}) { // from class: Historia.JPANotas.41
            Class[] types = {String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void mRecorrerTabla() {
        if (this.JTDetalle.getRowCount() != 0) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                String sql = " Insert into h_notaclinica_diagnostico(Id_NClinica, Id_Patologia, NOrden, Id_UsuarioS)  values ('" + this.JTFNNota.getText() + "','" + this.JTDetalle.getValueAt(i, 0) + "','" + this.JTDetalle.getValueAt(i, 2) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            }
            mCrearModeloDatos();
        }
    }

    private void mCargarDiagnosticos(String xid) {
        try {
            mCrearModeloDatos();
            String sql = "SELECT`h_notaclinica_diagnostico`.`Id_Patologia`, `g_patologia`.`Nbre`, `h_notaclinica_diagnostico`.`NOrden`FROM`h_notaclinica_diagnostico`INNER JOIN `g_patologia` ON (`h_notaclinica_diagnostico`.`Id_Patologia` = `g_patologia`.`Id`)WHERE (`h_notaclinica_diagnostico`.`Id_NClinica` =" + xid + " and `h_notaclinica_diagnostico`.Estado=1);";
            ResultSet xrs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.dato);
                            this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
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
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPANotas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void grabarFechasValoraciones() {
        String fechaCardiologo = this.xmetodo.formatoAMD.format(this.JDCFechaCardiologo.getDate());
        String fechaMedicoInterno = this.xmetodo.formatoAMD.format(this.JDCFechaInternista.getDate());
        String fechaEKG = this.xmetodo.formatoAMD.format(this.JDCFechaElectrocardiograma.getDate());
        String fechaETT = this.xmetodo.formatoAMD.format(this.JDCFechaEcocardiograma.getDate());
        String fechaNutricion = this.xmetodo.formatoAMD.format(this.JDCFechaNutricion.getDate());
        String sql = "UPDATE `h_notasclinicas` SET `ultimaValoracionMedica` =  \nconcat('F.M.I: ','" + fechaMedicoInterno + "',' F.N: ','" + fechaNutricion + "',' F.EKG: ','" + fechaEKG + "',' F.ETT:','" + fechaETT + "',' F.M.C: ','" + fechaCardiologo + "')\nWHERE `Id` = " + this.JTFNNota.getText() + "";
        System.out.println("consulta -> " + sql);
        this.xct.ejecutaSQLUpdate(sql);
        this.xct.cerrarConexionBd();
    }

    private void cargarValoraciones() {
        try {
            String sql = "SELECT \nSUBSTRING_INDEX(SUBSTRING_INDEX(`ultimaValoracionMedica`, 'F.M.I: ', -1), ' ', 1) AS fechaMedicoInterno, \nSUBSTRING_INDEX(SUBSTRING_INDEX(`ultimaValoracionMedica`, ' F.N: ', -1), ' ', 1) AS fechaNutricion, \nSUBSTRING_INDEX(SUBSTRING_INDEX(`ultimaValoracionMedica`, ' F.EKG: ', -1), ' ', 1) AS fechaEKG,\nSUBSTRING_INDEX(SUBSTRING_INDEX(`ultimaValoracionMedica`, ' F.ETT:', -1), ' ', 1) AS fechaETT, \nSUBSTRING_INDEX(SUBSTRING_INDEX(`ultimaValoracionMedica`, ' F.M.C: ', -1), ' ', 1) AS fechaCardiologo \nFROM `h_notasclinicas` \nWHERE `Id` = " + this.JTFNNota.getText() + "";
            System.out.println("carga valoracion -> " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date fechaMedicoInterno = dateFormat.parse(xrs.getString("fechaMedicoInterno"));
                Date fechaNutricion = dateFormat.parse(xrs.getString("fechaNutricion"));
                Date fechaEKG = dateFormat.parse(xrs.getString("fechaEKG"));
                Date fechaETT = dateFormat.parse(xrs.getString("fechaETT"));
                Date fechaCardiologo = dateFormat.parse(xrs.getString("fechaCardiologo"));
                this.JDCFechaCardiologo.setDate(fechaCardiologo);
                this.JDCFechaEcocardiograma.setDate(fechaETT);
                this.JDCFechaElectrocardiograma.setDate(fechaEKG);
                this.JDCFechaInternista.setDate(fechaMedicoInterno);
                this.JDCFechaNutricion.setDate(fechaNutricion);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(JPANotas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
