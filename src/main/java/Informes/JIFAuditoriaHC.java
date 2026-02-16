package Informes;

import Acceso.Principal;
import General.JD_Impresin_Central_Dc;
import Historia.JPGestionHC;
import Historia.JPGraficasCyDImpresion;
import Historia.JPGraficasPrenatalImpresion;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JIFAuditoriaHC.class */
public class JIFAuditoriaHC extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String[] xidprofesional;
    private String[][] xidespecialidad;
    private int xvc = 0;
    private int xlleno = 0;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xnombre;
    private JPGraficasCyDImpresion xJPGraficasCyDImpresion;
    private JPGraficasPrenatalImpresion xJPGraficasPrenatalImpresion;
    private JDialog dialogoGraifcaPrenatal;
    private ButtonGroup JBGOpciones;
    private JButton JBTExportar;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JCheckBox JCHFiltrado;
    private JCheckBox JCHFiltradoHigiene;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIDatosC;
    private JPanel JPIOpciones;
    private JRadioButton JRBEspecFecha;
    private JRadioButton JRBEspecialidad;
    private JRadioButton JRBIFechas;
    private JRadioButton JRBTodas;
    private JScrollPane JSPDetalleResultado;
    public JTextField JTFCDxP;
    private JFormattedTextField JTFFTotalRegistros;
    private JTextField JTFNCodigoDxP;
    private JTextField JTFRuta;
    private JTable JTResultado;
    private JPanel jPanel1;

    public JIFAuditoriaHC(String xnombre) {
        initComponents();
        this.xmt.cargarPanelOdontogramaDientes(this.JPIOpciones);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xnombre = xnombre;
        setName(xnombre);
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        mCargarDatosGenerales();
        mCrearTablaDetalle();
    }

    private void mRenderPanelGraficasCyD(long idUsuarioA, long idUsuarioPrograma) {
        this.xJPGraficasCyDImpresion = new JPGraficasCyDImpresion(idUsuarioA, idUsuarioPrograma);
        this.xJPGraficasCyDImpresion.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICAS CyD", 2, 0, new Font("Arial", 1, 14), Color.BLACK));
        this.xJPGraficasCyDImpresion.setVisible(false);
        this.xJPGraficasCyDImpresion.setBounds(-50, 0, 896, 570);
        this.JPIDatosC.add(this.xJPGraficasCyDImpresion);
    }

    private void mGeneraGraficaCyD() {
        this.xJPGraficasCyDImpresion.mGeneraGrafico_ScreenShot();
    }

    private void mRenderPanelGraficasPrenatal(long IdUsuarioA, long IdUsuarioPrograma) {
        this.dialogoGraifcaPrenatal = new JDialog();
        this.xJPGraficasPrenatalImpresion = new JPGraficasPrenatalImpresion(IdUsuarioA, IdUsuarioPrograma);
        this.xJPGraficasPrenatalImpresion.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICAS PRENATAL", 2, 0, new Font("Arial", 1, 14), Color.BLACK));
        this.xJPGraficasPrenatalImpresion.setVisible(true);
        this.xJPGraficasPrenatalImpresion.setBounds(-50, 0, 896, 570);
        this.dialogoGraifcaPrenatal.add(this.xJPGraficasPrenatalImpresion);
        this.dialogoGraifcaPrenatal.setSize(600, 700);
        this.dialogoGraifcaPrenatal.setVisible(true);
        this.dialogoGraifcaPrenatal.dispose();
    }

    private void mGeneraGraficaPrenatal() {
        this.xJPGraficasPrenatalImpresion.GenerarScreeshot();
    }

    /* JADX WARN: Type inference failed for: r3v72, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JPIDatosC = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCBEspecialidad = new JComboBox();
        this.JPIOpciones = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBIFechas = new JRadioButton();
        this.JRBEspecialidad = new JRadioButton();
        this.JRBEspecFecha = new JRadioButton();
        this.JCBProfesional = new JComboBox();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JCHFiltrado = new JCheckBox();
        this.JCHFiltradoHigiene = new JCheckBox();
        this.JSPDetalleResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JTFFTotalRegistros = new JFormattedTextField();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIA HISTORIA CLINICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifauditoriahc");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN ATENCIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel1.setName("jpauditoriahc");
        this.JPIDatosC.setBorder(BorderFactory.createEtchedBorder());
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Informes.JIFAuditoriaHC.1
            public void itemStateChanged(ItemEvent evt) {
                JIFAuditoriaHC.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JPIOpciones.setBorder(BorderFactory.createTitledBorder((Border) null, "OPCIONES", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JBGOpciones.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setForeground(new Color(0, 0, 255));
        this.JRBTodas.setSelected(true);
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaHC.2
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaHC.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBIFechas);
        this.JRBIFechas.setFont(new Font("Arial", 1, 12));
        this.JRBIFechas.setForeground(new Color(0, 0, 255));
        this.JRBIFechas.setText("Intervalos de Fecha");
        this.JRBIFechas.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaHC.3
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaHC.this.JRBIFechasActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBEspecialidad);
        this.JRBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JRBEspecialidad.setForeground(new Color(0, 0, 255));
        this.JRBEspecialidad.setText("Especialidad");
        this.JRBEspecialidad.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaHC.4
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaHC.this.JRBEspecialidadActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBEspecFecha);
        this.JRBEspecFecha.setFont(new Font("Arial", 1, 12));
        this.JRBEspecFecha.setForeground(new Color(0, 0, 255));
        this.JRBEspecFecha.setText("Especialidad y Profesional");
        this.JRBEspecFecha.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaHC.5
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaHC.this.JRBEspecFechaActionPerformed(evt);
            }
        });
        GroupLayout JPIOpcionesLayout = new GroupLayout(this.JPIOpciones);
        this.JPIOpciones.setLayout(JPIOpcionesLayout);
        JPIOpcionesLayout.setHorizontalGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLayout.createSequentialGroup().addComponent(this.JRBTodas).addGap(92, 92, 92).addComponent(this.JRBEspecialidad)).addGroup(JPIOpcionesLayout.createSequentialGroup().addComponent(this.JRBIFechas).addGap(18, 18, 18).addComponent(this.JRBEspecFecha))).addContainerGap(16, 32767)));
        JPIOpcionesLayout.setVerticalGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBEspecialidad, GroupLayout.Alignment.LEADING).addComponent(this.JRBTodas, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, 32767).addGroup(JPIOpcionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEspecFecha).addComponent(this.JRBIFechas)).addContainerGap()));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxP.setEditable(false);
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxP.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaHC.6
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaHC.this.JTFCDxPActionPerformed(evt);
            }
        });
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Informes.JIFAuditoriaHC.7
            public void focusLost(FocusEvent evt) {
                JIFAuditoriaHC.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFNCodigoDxP.setEditable(false);
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patologia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Informes.JIFAuditoriaHC.8
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaHC.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaHC.9
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaHC.this.JTFNCodigoDxPActionPerformed(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Informes.JIFAuditoriaHC.10
            public void keyPressed(KeyEvent evt) {
                JIFAuditoriaHC.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JCHFiltrado.setFont(new Font("Arial", 1, 12));
        this.JCHFiltrado.setText("Filtro");
        this.JCHFiltrado.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaHC.11
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaHC.this.JCHFiltradoActionPerformed(evt);
            }
        });
        this.JCHFiltradoHigiene.setFont(new Font("Arial", 1, 12));
        this.JCHFiltradoHigiene.setForeground(Color.red);
        this.JCHFiltradoHigiene.setText("Es Higiene Oral?");
        this.JCHFiltradoHigiene.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaHC.12
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaHC.this.JCHFiltradoHigieneActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addComponent(this.JPIOpciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, 0, 395, 32767)).addComponent(this.JCBProfesional, 0, 651, 32767))).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNCodigoDxP, -2, 720, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltrado).addGap(37, 37, 37).addComponent(this.JCHFiltradoHigiene).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIOpciones, -2, -1, -2)).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaF, -2, 56, -2).addComponent(this.JDCFechaI, -2, 56, -2))).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.JCBEspecialidad, -2, 48, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProfesional, -2, 48, -2))).addGap(18, 18, 18).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, 50, -2).addComponent(this.JCHFiltrado).addComponent(this.JTFNCodigoDxP, -2, 50, -2).addComponent(this.JCHFiltradoHigiene)).addContainerGap(-1, 32767)));
        this.JSPDetalleResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Informes.JIFAuditoriaHC.13
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaHC.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalleResultado.setViewportView(this.JTResultado);
        this.JTFFTotalRegistros.setEditable(false);
        this.JTFFTotalRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL ATENCIONES", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotalRegistros.setHorizontalAlignment(0);
        this.JTFFTotalRegistros.setFont(new Font("Arial", 1, 18));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaHC.14
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaHC.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Informes.JIFAuditoriaHC.15
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaHC.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleResultado, GroupLayout.Alignment.LEADING, -1, 1043, 32767).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 477, 32767).addGap(28, 28, 28).addComponent(this.JBTExportar, -2, 128, -2).addGap(240, 240, 240).addComponent(this.JTFFTotalRegistros, -2, 170, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleResultado, -2, 343, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JBTExportar, -2, 50, -2)).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JTFFTotalRegistros, -2, 62, -2)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno == 1 && this.xvc == 3 && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            String sql = "SELECT profesional.Id_Persona, profesional.NProfesional FROM g_profesionalespecial INNER JOIN profesional  ON (g_profesionalespecial.Id_Profesional = profesional.Id_Persona) WHERE (g_profesionalespecial.Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "') ORDER BY profesional.NProfesional ASC ";
            this.xidprofesional = this.xconsultas.llenarCombo(sql, this.xidprofesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        this.xvc = 0;
        this.JDCFechaI.setEnabled(false);
        this.JDCFechaF.setEnabled(false);
        this.JCBEspecialidad.setEnabled(false);
        this.JCBProfesional.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIFechasActionPerformed(ActionEvent evt) {
        this.xvc = 1;
        this.JDCFechaI.setEnabled(true);
        this.JDCFechaF.setEnabled(true);
        this.JCBEspecialidad.setEnabled(false);
        this.JCBProfesional.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspecialidadActionPerformed(ActionEvent evt) {
        this.xvc = 2;
        this.JDCFechaI.setEnabled(true);
        this.JDCFechaF.setEnabled(true);
        this.JCBEspecialidad.setEnabled(true);
        this.JCBProfesional.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEspecFechaActionPerformed(ActionEvent evt) {
        this.xvc = 3;
        this.JDCFechaI.setEnabled(true);
        this.JDCFechaF.setEnabled(true);
        this.JCBEspecialidad.setEnabled(true);
        this.JCBProfesional.setEnabled(true);
        this.JCBEspecialidad.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPActionPerformed(ActionEvent evt) {
        this.JTFCDxP.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltradoActionPerformed(ActionEvent evt) {
        if (this.JCHFiltrado.isSelected()) {
            this.JTFNCodigoDxP.setEditable(true);
            this.JTFCDxP.setEditable(true);
            this.JTFCDxP.setText((String) null);
            this.JTFNCodigoDxP.setText((String) null);
            this.JTFCDxP.requestFocus();
            return;
        }
        this.JTFNCodigoDxP.setEditable(false);
        this.JTFCDxP.setEditable(false);
        this.JTFCDxP.setText((String) null);
        this.JTFNCodigoDxP.setText((String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 0) != null) {
            JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 7).toString(), this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 8).toString(), this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 10).toString(), this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 7).toString(), Integer.valueOf(this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 18).toString()), this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 22).toString());
            xjd.setLocationRelativeTo(this);
            xjd.setVisible(true);
        }
    }

    private String mConsultaIdUsuarioPrograma(String idpersona, String IdPrograma) {
        String idUsuarioPrograma = "";
        String sql = "SELECT Id FROM `g_usuarioxprograma` \nWHERE g_usuarioxprograma.`Id_Usuario`='" + idpersona + "' AND Id_Programa=" + IdPrograma;
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                idUsuarioPrograma = xrs.getString("Id");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException e) {
        }
        return idUsuarioPrograma;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTResultado.getRowCount() > -1) {
                mExportar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltradoHigieneActionPerformed(ActionEvent evt) {
    }

    private String mConsultaIdUsuarioPrograma(String IdPrograma) {
        String idUsuarioPrograma = "";
        String sql = "SELECT Id FROM `g_usuarioxprograma` \nWHERE g_usuarioxprograma.`Id_Usuario`='" + this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 8).toString() + "' AND Id_Programa=" + IdPrograma;
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                idUsuarioPrograma = xrs.getString("Id");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return idUsuarioPrograma;
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Usuario", 0);
                for (int x = 0; x < this.JTResultado.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTResultado.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTResultado.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.xmodelo.getValueAt(x2, 9).toString()));
                    sheet.addCell(new Label(10, x2 + 1, this.xmodelo.getValueAt(x2, 10).toString()));
                    sheet.addCell(new Label(11, x2 + 1, this.xmodelo.getValueAt(x2, 11).toString()));
                    sheet.addCell(new Label(12, x2 + 1, this.xmodelo.getValueAt(x2, 12).toString()));
                    sheet.addCell(new Label(13, x2 + 1, this.xmodelo.getValueAt(x2, 13).toString()));
                    sheet.addCell(new Label(14, x2 + 1, this.xmodelo.getValueAt(x2, 14).toString()));
                    sheet.addCell(new Label(15, x2 + 1, this.xmodelo.getValueAt(x2, 15).toString()));
                    sheet.addCell(new Label(16, x2 + 1, this.xmodelo.getValueAt(x2, 16).toString()));
                    sheet.addCell(new Label(17, x2 + 1, this.xmodelo.getValueAt(x2, 17).toString()));
                    sheet.addCell(new Label(18, x2 + 1, this.xmodelo.getValueAt(x2, 18).toString()));
                    sheet.addCell(new Label(19, x2 + 1, this.xmodelo.getValueAt(x2, 19).toString()));
                    sheet.addCell(new Label(20, x2 + 1, this.xmodelo.getValueAt(x2, 20).toString()));
                }
                workbook.write();
                workbook.close();
                this.xmt.mostrarPdf(this.JTFRuta.getText() + ".xls");
            } catch (IOException ex) {
                Logger.getLogger(JIFAuditoriaHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFAuditoriaHC.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void nuevo() {
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.xlleno = 0;
        this.JCBProfesional.removeAllItems();
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JTFFTotalRegistros.setValue(new Integer(0));
        this.JTFCDxP.setText((String) null);
        this.JTFNCodigoDxP.setText((String) null);
        mCrearTablaDetalle();
        this.xlleno = 1;
    }

    public void buscar() {
        String sql;
        String sql1;
        String sql12;
        String sql2;
        String sql13;
        String sql14;
        String sql3;
        String sql4;
        String sql15 = "";
        mCrearTablaDetalle();
        if (this.JCHFiltradoHigiene.isSelected()) {
            if (this.JRBIFechas.isSelected()) {
                sql15 = "\n where(hn.FechaNota BETWEEN '" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "' and '" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "') group by i.Id ORDER BY hn.FechaNota  ASC, hn.HoraNota asc";
            } else if (this.JRBEspecialidad.isSelected()) {
                sql15 = "\n where(ge.Id=" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + " and hn.FechaNota BETWEEN '" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "' and '" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "') group by i.Id ORDER BY hn.FechaNota  ASC, hn.HoraNota asc";
            } else if (this.JRBEspecFecha.isSelected()) {
                sql15 = "\n where(hn.Id_Profesional ='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "' and ge.Id=" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + " and hn.FechaNota BETWEEN '" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "' and '" + this.xmt.formatoAMD1.format(this.JDCFechaF.getDate()) + "') group by i.Id ORDER BY hn.FechaNota  ASC, hn.HoraNota asc";
            }
            String sql5 = "SELECT \nDATE_FORMAT(hn.FechaNota , '%d-%m-%Y') AS fechaAtencion\n, hn.HoraNota horaAtencion\n, `gu`.NoHistoria numeroHistoria\n, CONCAT(`gp`.`Apellido1`,' ',`gp`.`Apellido2`,' ',`gp`.`Nombre1`,' ',`gp`.`Nombre2`) AS nombreUsuario\n, ha.Codigo_Dxp diagnosticoPrincipal\n, CONCAT(`gp3`.`Apellido1`,' ',`gp3`.`Apellido2`,' ',`gp3`.`Nombre1`,' ',`gp3`.`Nombre2`) nombreProfesional\n, ge.Nbre  nombreEspecialidad\n, ha.Id idAtencion\n, i.Id_Usuario idUsuario\n, gp2.Nbre nombreDiagnoosticoPrincipal\n  ,IFNULL(ha.Motivo_Atencion, '') AS Motivo_Atencion \n  ,IFNULL(ha.Conclusion,'') AS Conclusion\n  ,IFNULL(ha.Recomendaciones ,'') AS Recomendaciones\n  , IFnull( gt.Nbre ,'') AS tipoEmpresa\n  , IFnull(gp4.Nbre ,'') AS parentesco\n  , gs.Nbre AS sede\n  ,0\n  , ge.Id idEspecialidad \n , `cc`.`Id_Historia` idTipoHistoria\n ,  `gt2`.`EsPrenatal`\n , fe.`Nbre` AS Convenio\n ,i.Id idIngreso\n , gp.Correo correo  \nfrom ingreso i \ninner join h_atencion ha on (i.Id=ha.Id_Ingreso)\ninner join g_usuario gu on (i.Id_Usuario=gu.Id_persona)\ninner join g_persona gp on (gp.Id=gu.Id_persona)\ninner join o_hc_tratamiento oht on (oht.Id_Atencion=ha.Id)\ninner join h_notasclinicas hn  on (hn.Id_Atencion=ha.Id)\ninner join g_patologia gp2 on (gp2.Id=ha.Codigo_Dxp)\ninner join g_persona gp3  on (gp3.Id=hn.Id_Profesional)\ninner join g_especialidad ge on (ge.Id=hn.Id_Especialidad)\ninner join g_sedes gs  on (gs.Id=i.Id_Sede)\ninner join c_clasecita cc  on (cc.Id=ha.Id_ClaseCita)\ninner join g_tipoprograma gt2  on (gt2.Id_TipoPrograma=cc.Id_Programa)\ninner join f_empresacontxconvenio fe on (fe.Id=i.Id_EmpresaContxConv)\nleft join g_usuario_fpz guf on (guf.Id_Persona=gp.Id)\nleft join g_tipoempresa gt on (gt.Id=guf.Id_Empresa)\nleft join g_parentesco gp4 on (gp4.Id=guf.Id_Parentesco) " + sql15;
            System.out.println(" odontologia " + sql5);
            mCargarDatosTabla(sql5);
            return;
        }
        if (this.xvc == 0) {
            if (getName().equals("Recepcion") || getName().equals("xjifauditoriahcmed")) {
                sql4 = "SELECT DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS fechaa, \nh_atencion.Hora_Atencion, `g_usuario`.NoHistoria, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional,\n profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre,\n  IF(h_atencion.Motivo_Atencion IS NULL, '',h_atencion.Motivo_Atencion) AS Motivo_Atencion , \n  IF(h_atencion.Conclusion IS NULL,'',h_atencion.Conclusion) AS Conclusion, \n  IF(h_atencion.Recomendaciones IS NULL,'',h_atencion.Recomendaciones) AS Recomendaciones, \n IF( g_tipoempresa.Nbre IS NULL ,'',g_tipoempresa.Nbre) AS Nbre, IF(g_parentesco.Nbre IS NULL,'',g_parentesco.Nbre) AS Nbre, g_sedes.Nbre AS Sede,0, h_atencion.Id_Especialidad \n , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso, g_persona.correo \n  FROM h_atencion \n   INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)\n   INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario) \n   INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)  \n   AND (profesional1.IdEspecialidad= h_atencion.Id_Especialidad)   \n   INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id) \n   INNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)  \n    LEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona) \n     LEFT JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa)  \n     LEFT JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) \n    INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede) \n    INNER JOIN `c_clasecita` ON( `c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)  INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`) INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
            } else {
                sql4 = "SELECT DATE_FORMAT(`ingreso`.`Fecha`, '%d/%m/%Y') AS fechaa, IFNULL(h_triage.HoraTriage,'') AS HoraTriage, \n`g_usuario`.NoHistoria,CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp,\n CONCAT(profesional1.`Apellido1`,' ', profesional1.`Apellido2`, ' ', profesional1.`Nombre1`, ' ',profesional1.`Nombre2` )NProfesional,\n   `g_especialidad`.`Nbre` AS especialidad, h_atencion.Id, ingreso.Id_Usuario,\n  g_patologia.Nbre, IFNULL(h_triage.MotivoConsulta,'') AS MotivoConsulta,IFNULL(h_triage.Observacion,'') AS Observacion, '', \n  IFNULL(g_tipoempresa.Nbre,'') AS Nbre, IFNULL(g_parentesco.Nbre,'') AS Nbre, g_sedes.Nbre AS Sede, \n  IFNULL(h_triage.Id,'') AS Id, h_atencion.Id_Especialidad,`c_clasecita`.Id_Historia, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso, g_persona.correo \n  FROM h_atencion \n  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) \n   INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario) \n   INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id) \n   INNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)  \n   LEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona) \n   LEFT JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa) \n   LEFT JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)\n   LEFT JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)\n   INNER JOIN `g_especialidad` ON(`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\n   INNER JOIN  profesional1  ON (profesional1.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n   LEFT JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede) \n   INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)  INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`) INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
            }
            if (!this.JCHFiltrado.isSelected()) {
                mCargarDatosTabla(sql4 + "WHERE (h_atencion.Codigo_Dxp <>'') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ");
                return;
            }
            if (this.JCHFiltrado.isSelected()) {
                if (!this.JTFCDxP.getText().isEmpty()) {
                    String sql16 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Codigo_Dxp='" + this.JTFCDxP.getText() + "') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                    mCargarDatosTabla(sql4 + sql16);
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Debe digitar un codigo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTFCDxP.requestFocus();
                    return;
                }
            }
            return;
        }
        if (this.xvc == 1) {
            if (getName().equals("Recepcion") || getName().equals("xjifauditoriahcmed")) {
                sql3 = "SELECT DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS fechaa, h_atencion.Hora_Atencion, `g_usuario`.NoHistoria, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre,  IF(h_atencion.Motivo_Atencion IS NULL, '',h_atencion.Motivo_Atencion) AS Motivo_Atencion ,   IF(h_atencion.Conclusion IS NULL,'',h_atencion.Conclusion) AS Conclusion,   IF(h_atencion.Recomendaciones IS NULL,'',h_atencion.Recomendaciones) AS Recomendaciones,  IF( g_tipoempresa.Nbre IS NULL ,'',g_tipoempresa.Nbre) AS Nbre, IF(g_parentesco.Nbre IS NULL,'',g_parentesco.Nbre) AS Nbre, g_sedes.Nbre AS Sede,0, h_atencion.Id_Especialidad   , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso, g_persona.correo \n  FROM h_atencion    INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario)    INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)     AND (profesional1.IdEspecialidad= h_atencion.Id_Especialidad)      INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id)    INNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)      LEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona)      LEFT JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa)       LEFT JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)     INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede)    INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)  INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
            } else {
                sql3 = "SELECT DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS fechaa, h_triage.HoraTriage,  `g_usuario`.NoHistoria,CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre, h_triage.MotivoConsulta,h_triage.Observacion, '', g_tipoempresa.Nbre, g_parentesco.Nbre, g_sedes.Nbre AS Sede, h_triage.Id, h_atencion.Id_Especialidad , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso  FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario)    INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id)  INNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)   INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona)   INNER JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa)   INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)  INNER JOIN profesional1  ON (profesional1.Id_Persona = h_triage.Id_Profesional)   AND (profesional1.IdEspecialidad= h_triage.Id_Especialidad)  INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede)     INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)  INNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
            }
            if (!this.JCHFiltrado.isSelected()) {
                String sql17 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' ) ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                mCargarDatosTabla(sql3 + sql17);
                return;
            } else {
                if (this.JCHFiltrado.isSelected()) {
                    if (!this.JTFCDxP.getText().isEmpty()) {
                        String sql18 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Codigo_Dxp='" + this.JTFCDxP.getText() + "' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' ) ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                        mCargarDatosTabla(sql3 + sql18);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe digitar un codigo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTFCDxP.requestFocus();
                        return;
                    }
                }
                return;
            }
        }
        if (this.xvc == 2) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][1].equals("1")) {
                    sql2 = "SELECT c_citas.`Fecha_Cita`,c_citas.`HoraInicial` , \n`g_usuario`.NoHistoria, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, \nh_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre, \nIF(h_atencion.Motivo_Atencion IS NULL, '',h_atencion.Motivo_Atencion) AS Motivo_Atencion , \nIF(h_atencion.Conclusion IS NULL,'',h_atencion.Conclusion) AS Conclusion, \nIF(h_atencion.Recomendaciones IS NULL,'',h_atencion.Recomendaciones) AS Recomendaciones, \ng_tipoempresa.Nbre, g_parentesco.Nbre, g_sedes.Nbre AS Sede,0, h_atencion.Id_Especialidad , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso, g_persona.correo \nFROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario) \nINNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)   \nAND (profesional1.IdEspecialidad= h_atencion.Id_Especialidad)   \nINNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id) \nINNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)  \nINNER JOIN `c_citas` ON (c_citas.`Id_ingreso` = ingreso.Id)  \nINNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona)  \nINNER JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa)  \nINNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) \nINNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede)\nINNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)\nINNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
                } else if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                    sql2 = "SELECT DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fechaa, h_atencion.Hora_Atencion, `g_usuario`.NoHistoria, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre, h_atencion.Id_Especialidad , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso\n FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)   AND (profesional1.IdEspecialidad= h_atencion.Id_Especialidad)   INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id) INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede) INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)\nINNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
                } else if (getName().equals("Recepcion") || getName().equals("xjifauditoriahcmed")) {
                    sql2 = "SELECT DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fechaa, h_atencion.Hora_Atencion, `g_usuario`.NoHistoria, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre, IF(h_atencion.Motivo_Atencion IS NULL, '',h_atencion.Motivo_Atencion) AS Motivo_Atencion , IF(h_atencion.Conclusion IS NULL,'',h_atencion.Conclusion) AS Conclusion, IF(h_atencion.Recomendaciones IS NULL,'',h_atencion.Recomendaciones) AS Recomendaciones, g_tipoempresa.Nbre, g_parentesco.Nbre, g_sedes.Nbre AS Sede,0 , h_atencion.Id_Especialidad , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso, g_persona.correo \n FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)   AND (profesional1.IdEspecialidad= h_atencion.Id_Especialidad)   INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id) INNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)  INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona)  INNER JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa)  INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede) INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)\nINNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
                } else {
                    sql2 = "SELECT DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS fechaa, h_triage.HoraTriage,  `g_usuario`.NoHistoria,CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre, h_triage.MotivoConsulta,h_triage.Observacion, '', g_tipoempresa.Nbre, g_parentesco.Nbre, g_sedes.Nbre AS Sede, h_triage.Id, h_atencion.Id_Especialidad , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso, g_persona.correo\n FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario)    INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id)  INNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)   INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona)   INNER JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa)   INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)  INNER JOIN profesional1  ON (profesional1.Id_Persona = h_triage.Id_Profesional)   AND (profesional1.IdEspecialidad= h_triage.Id_Especialidad)  INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede)  INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)\nINNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
                }
                if (!this.JCHFiltrado.isSelected()) {
                    if (this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][1].equals("1")) {
                        sql14 = "WHERE (h_atencion.Codigo_Dxp <>'' AND c_citas.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND c_citas.`Asistida`=3 AND profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC";
                    } else if (getName().equals("Recepcion") || getName().equals("xjifauditoriahcmed")) {
                        sql14 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' and profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' ) ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                    } else {
                        sql14 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' and profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' ) ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                    }
                    mCargarDatosTabla(sql2 + sql14);
                    return;
                }
                if (this.JCHFiltrado.isSelected()) {
                    if (!this.JTFCDxP.getText().isEmpty()) {
                        if (this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][1].equals("1")) {
                            sql13 = "WHERE (h_atencion.Codigo_Dxp <>'' AND h_atencion.Codigo_Dxp='" + this.JTFCDxP.getText() + "' AND c_citas.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND c_citas.`Asistida`=3 AND profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC";
                        } else if (getName().equals("Recepcion") || getName().equals("xjifauditoriahcmed")) {
                            sql13 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Codigo_Dxp='" + this.JTFCDxP.getText() + "' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' and profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' ) ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                        } else {
                            sql13 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Codigo_Dxp='" + this.JTFCDxP.getText() + "' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' and profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' ) ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                        }
                        mCargarDatosTabla(sql2 + sql13);
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe digitar un codigo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTFCDxP.requestFocus();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBEspecialidad.requestFocus();
            return;
        }
        if (this.xvc == 3) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][1].equals("1")) {
                        sql = "SELECT DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') AS fechaa, h_atencion.Hora_Atencion, `g_usuario`.NoHistoria, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre,  IF(h_atencion.Motivo_Atencion IS NULL, '',h_atencion.Motivo_Atencion) AS Motivo_Atencion ,   IF(h_atencion.Conclusion IS NULL,'',h_atencion.Conclusion) AS Conclusion,  IF(h_atencion.Recomendaciones IS NULL,'',h_atencion.Recomendaciones) AS Recomendaciones,  g_tipoempresa.Nbre, g_parentesco.Nbre, g_sedes.Nbre AS Sede,0, h_atencion.Id_Especialidad , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso, g_persona.correo\n  FROM h_atencion    INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario)    INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)    AND (profesional1.IdEspecialidad= h_atencion.Id_Especialidad)     INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id)    INNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)      LEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona)      LEFT JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa)      LEFT JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)    INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede) INNER JOIN `c_citas` ON (c_citas.`Id_ingreso` = ingreso.Id)  INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)\nINNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
                    } else if (getName().equals("Recepcion") || getName().equals("xjifauditoriahcmed")) {
                        sql = "SELECT DATE_FORMAT(h_atencion.Fecha_Atencion, '%d/%m/%Y') as fechaa, h_atencion.Hora_Atencion, `g_usuario`.NoHistoria, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre, IF(h_atencion.Motivo_Atencion IS NULL, '',h_atencion.Motivo_Atencion) AS Motivo_Atencion , IF(h_atencion.Conclusion IS NULL,'',h_atencion.Conclusion) AS Conclusion, IF(h_atencion.Recomendaciones IS NULL,'',h_atencion.Recomendaciones) AS Recomendaciones, g_tipoempresa.Nbre, g_parentesco.Nbre, g_sedes.Nbre AS Sede,0, h_atencion.Id_Especialidad , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso, g_persona.correo\n FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)   AND (profesional1.IdEspecialidad= h_atencion.Id_Especialidad)   INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id) INNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)  INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona)  INNER JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa)  INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede)INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)\nINNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
                    } else {
                        sql = "SELECT DATE_FORMAT(h_triage.FechaTriage, '%d/%m/%Y') AS fechaa, h_triage.HoraTriage,  `g_usuario`.NoHistoria,CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS NUsuario, h_atencion.Codigo_Dxp, profesional1.NProfesional, profesional1.Especialidad, h_atencion.Id, ingreso.Id_Usuario, g_patologia.Nbre, h_triage.MotivoConsulta,h_triage.Observacion, '', g_tipoempresa.Nbre, g_parentesco.Nbre, g_sedes.Nbre AS Sede, h_triage.Id, h_atencion.Id_Especialidad , `c_clasecita`.`Id_Historia`, `g_tipoprograma`.`EsPrenatal`, `f_empresacontxconvenio`.`Nbre` AS Convenio,ingreso.Id idIngreso, g_persona.correo\n FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN g_persona  ON (g_persona.Id = ingreso.Id_Usuario)    INNER JOIN g_patologia  ON (h_atencion.Codigo_Dxp = g_patologia.Id)  INNER JOIN g_usuario  ON (g_persona.Id = g_usuario.Id_persona)   INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_persona = g_usuario.Id_persona)   INNER JOIN g_tipoempresa  ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa)   INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco)  INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id)  INNER JOIN profesional1  ON (profesional1.Id_Persona = h_triage.Id_Profesional)   AND (profesional1.IdEspecialidad= h_triage.Id_Especialidad)  INNER JOIN g_sedes  ON (g_sedes.Id = ingreso.Id_Sede)  INNER JOIN `c_clasecita` ON (`c_clasecita`.`Id` = `h_atencion`.`Id_ClaseCita`)\nINNER JOIN `g_tipoprograma` ON (`g_tipoprograma`.`Id_TipoPrograma`=`c_clasecita`.`Id_Programa`)INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) ";
                    }
                    if (!this.JCHFiltrado.isSelected()) {
                        if (this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][1].equals("1")) {
                            sql12 = "WHERE (h_atencion.Codigo_Dxp <>'' AND c_citas.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND c_citas.`Asistida`=3 AND profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' AND profesional1.Id_Persona='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC";
                        } else if (getName().equals("Recepcion") || getName().equals("xjifauditoriahcmed")) {
                            sql12 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' and profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' and profesional1.Id_Persona='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                        } else {
                            sql12 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' and profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' and profesional1.Id_Persona='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                        }
                        mCargarDatosTabla(sql + sql12);
                        return;
                    }
                    if (this.JCHFiltrado.isSelected()) {
                        if (!this.JTFCDxP.getText().isEmpty()) {
                            if (this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][1].equals("1")) {
                                sql1 = "WHERE (h_atencion.Codigo_Dxp <>'' AND h_atencion.Codigo_Dxp='" + this.JTFCDxP.getText() + "' AND c_citas.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND c_citas.`Asistida`=3 AND profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' AND profesional1.Id_Persona='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC";
                            } else if (getName().equals("Recepcion") || getName().equals("xjifauditoriahcmed")) {
                                sql1 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Codigo_Dxp='" + this.JTFCDxP.getText() + "' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' and profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' and profesional1.Id_Persona='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                            } else {
                                sql1 = "WHERE (h_atencion.Codigo_Dxp <>'' and h_atencion.Codigo_Dxp='" + this.JTFCDxP.getText() + "' and h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' and h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' and profesional1.IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()][0] + "' and profesional1.Id_Persona='" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "') ORDER BY h_atencion.Fecha_Atencion ASC, h_atencion.Hora_Atencion ASC ";
                            }
                            mCargarDatosTabla(sql + sql1);
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe digitar un codigo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTFCDxP.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBEspecialidad.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBEspecialidad.requestFocus();
        }
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Hora", "N° Hc", "Usuario", "Dx", "Profesional", "Especialidad", "IdAtencion", "IdPaciente", "NPatologia", "MC", "Conclusión", "Recomendaciones", "Tipo Empresa", "Tipo Parentesco", "Sede", "IdTriage", "IdEspecialidad", "IdTipoHistoria", "Es Prenatal?", "Convenio", "idIngreso", "correo"}) { // from class: Informes.JIFAuditoriaHC.16
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTResultado.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(20).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(22).setMaxWidth(0);
    }

    private void mCargarDatosTabla(String vsql) {
        if (vsql != null) {
            new Metodos();
            this.JTFFTotalRegistros.setValue(new Integer(0));
            int idc = this.JCBEspecialidad.getSelectedIndex();
            int i = idc + 1;
            ResultSet rs = this.xconsultas.traerRs(vsql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int xn = 0;
                    int xc = 0;
                    while (rs.next()) {
                        this.xmodelo.addRow((Object[]) null);
                        this.xmodelo.setValueAt(rs.getString(1), xn, 0);
                        this.xmodelo.setValueAt(rs.getString(2), xn, 1);
                        this.xmodelo.setValueAt(rs.getString(3), xn, 2);
                        this.xmodelo.setValueAt(rs.getString(4), xn, 3);
                        this.xmodelo.setValueAt(rs.getString(5), xn, 4);
                        this.xmodelo.setValueAt(rs.getString(6), xn, 5);
                        this.xmodelo.setValueAt(rs.getString(7), xn, 6);
                        this.xmodelo.setValueAt(rs.getString(8), xn, 7);
                        this.xmodelo.setValueAt(rs.getString(9), xn, 8);
                        this.xmodelo.setValueAt(rs.getString(10), xn, 9);
                        this.xmodelo.setValueAt(rs.getString(11), xn, 10);
                        this.xmodelo.setValueAt(rs.getString(12), xn, 11);
                        this.xmodelo.setValueAt(rs.getString(13), xn, 12);
                        this.xmodelo.setValueAt(rs.getString(14), xn, 13);
                        this.xmodelo.setValueAt(rs.getString(15), xn, 14);
                        this.xmodelo.setValueAt(rs.getString(16), xn, 15);
                        this.xmodelo.setValueAt(rs.getString(17), xn, 16);
                        this.xmodelo.setValueAt(rs.getString(18), xn, 17);
                        this.xmodelo.setValueAt(rs.getString(19), xn, 18);
                        this.xmodelo.setValueAt(rs.getString(20), xn, 19);
                        this.xmodelo.setValueAt(rs.getString(21), xn, 20);
                        this.xmodelo.setValueAt(rs.getString("idIngreso"), xn, 21);
                        this.xmodelo.setValueAt(rs.getString("correo"), xn, 22);
                        xc++;
                        xn++;
                    }
                    this.JTFFTotalRegistros.setValue(Integer.valueOf(xc));
                }
                rs.close();
                this.xconsultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFAuditoriaHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mCargarDatosGenerales() {
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.xidespecialidad = this.xconsultas.llenarComboyLista("SELECT Id, Nbre, EsOdontologia FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad, 3);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.xlleno = 1;
        this.JDCFechaI.setEnabled(false);
        this.JDCFechaF.setEnabled(false);
        this.JCBEspecialidad.setEnabled(false);
        this.JCBProfesional.setEnabled(false);
        this.JTFNCodigoDxP.setEditable(false);
        this.JTFCDxP.setEditable(false);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Informes/JIFAuditoriaHC$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String trabajador = table.getValueAt(row, 11).toString();
            if (trabajador != null && trabajador.equals("1")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (codigo.getText().length() != 0) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'";
                ResultSet res = this.xconsultas.traerRs(sql);
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
                this.xconsultas.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }
}
