package Sig;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
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

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFInformes_Pyp_Eps.class */
public class JIFInformes_Pyp_Eps extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private String[] xidempresa;
    private String[] xidprograma;
    private ButtonGroup JBGOpciones;
    private ButtonGroup JBGOpciones_CA;
    private ButtonGroup JBGOpciones_Ex;
    private ButtonGroup JBGOpciones_F;
    private ButtonGroup JBGOpciones_Vacunas;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JComboBox JCBPrograma;
    private JCheckBox JCHFiltroEps;
    private JCheckBox JCHTipoC;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPICAdicionales;
    private JPanel JPIDatosF;
    private JPanel JPIExamenFisico;
    private JPanel JPIFitro;
    private JPanel JPIForma;
    private JPanel JPIOpcionesLab;
    private JPanel JPIUtilidades;
    private JPanel JPIVacunas;
    private JRadioButton JRB_10_UControl;
    private JRadioButton JRB_11_Inasistencia;
    private JRadioButton JRB_12_PControl;
    private JRadioButton JRB_13_NConsultasMG;
    private JRadioButton JRB_14_NConsultasMI;
    private JRadioButton JRB_15_NConsultasSubEsp;
    private JRadioButton JRB_16_NConsultasNutricion;
    private JRadioButton JRB_17_NConsultasPsicologia;
    private JRadioButton JRB_18_NConsultasEnfermeria;
    private JRadioButton JRB_18_NConsultasEnfermeria1;
    private JRadioButton JRB_1_Creatrinina;
    private JRadioButton JRB_2_Microalbumina;
    private JRadioButton JRB_3_Glicemia;
    private JRadioButton JRB_4_Glicocilada;
    private JRadioButton JRB_5_CTotal;
    private JRadioButton JRB_6_CHdl;
    private JRadioButton JRB_7_Ldl;
    private JRadioButton JRB_7_Proteinuria;
    private JRadioButton JRB_7_Proteinuria1;
    private JRadioButton JRB_8_Trigliceridos;
    private JRadioButton JRB_9_PControl;
    private JRadioButton JRB_9_PControl1;
    private JRadioButton JRB_A;
    private JRadioButton JRB_B;
    private JRadioButton JRB_VacunaInfluenza;
    private JRadioButton JRB_VacunaNeumococo;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFInformes_Pyp_Eps() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JBGOpciones_Ex = new ButtonGroup();
        this.JBGOpciones_CA = new ButtonGroup();
        this.JBGOpciones_F = new ButtonGroup();
        this.JBGOpciones_Vacunas = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIDatosF = new JPanel();
        this.JPIFitro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBPrograma = new JComboBox();
        this.JCBEmpresa = new JComboBox();
        this.JPIForma = new JPanel();
        this.JRB_A = new JRadioButton();
        this.JRB_B = new JRadioButton();
        this.JCHFiltroEps = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPIUtilidades = new JPanel();
        this.JPIOpcionesLab = new JPanel();
        this.JRB_1_Creatrinina = new JRadioButton();
        this.JRB_2_Microalbumina = new JRadioButton();
        this.JRB_3_Glicemia = new JRadioButton();
        this.JRB_4_Glicocilada = new JRadioButton();
        this.JRB_5_CTotal = new JRadioButton();
        this.JRB_6_CHdl = new JRadioButton();
        this.JRB_7_Ldl = new JRadioButton();
        this.JRB_8_Trigliceridos = new JRadioButton();
        this.JRB_7_Proteinuria = new JRadioButton();
        this.JCHTipoC = new JCheckBox();
        this.JRB_7_Proteinuria1 = new JRadioButton();
        this.JPIExamenFisico = new JPanel();
        this.JRB_9_PControl = new JRadioButton();
        this.JRB_10_UControl = new JRadioButton();
        this.JPICAdicionales = new JPanel();
        this.JRB_11_Inasistencia = new JRadioButton();
        this.JRB_12_PControl = new JRadioButton();
        this.JRB_13_NConsultasMG = new JRadioButton();
        this.JRB_14_NConsultasMI = new JRadioButton();
        this.JRB_15_NConsultasSubEsp = new JRadioButton();
        this.JRB_16_NConsultasNutricion = new JRadioButton();
        this.JRB_17_NConsultasPsicologia = new JRadioButton();
        this.JRB_18_NConsultasEnfermeria = new JRadioButton();
        this.JRB_18_NConsultasEnfermeria1 = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.JRB_9_PControl1 = new JRadioButton();
        this.JPIVacunas = new JPanel();
        this.JRB_VacunaInfluenza = new JRadioButton();
        this.JRB_VacunaNeumococo = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES DE PYP POR EPS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_consultarinformes_eps");
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIFitro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIForma.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Formato", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGOpciones_F.add(this.JRB_A);
        this.JRB_A.setFont(new Font("Arial", 1, 12));
        this.JRB_A.setSelected(true);
        this.JRB_A.setText("A");
        this.JRB_A.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.1
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_AActionPerformed(evt);
            }
        });
        this.JBGOpciones_F.add(this.JRB_B);
        this.JRB_B.setFont(new Font("Arial", 1, 12));
        this.JRB_B.setText("B");
        this.JRB_B.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_BActionPerformed(evt);
            }
        });
        GroupLayout JPIFormaLayout = new GroupLayout(this.JPIForma);
        this.JPIForma.setLayout(JPIFormaLayout);
        JPIFormaLayout.setHorizontalGroup(JPIFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFormaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_A).addGap(38, 38, 38).addComponent(this.JRB_B).addContainerGap(-1, 32767)));
        JPIFormaLayout.setVerticalGroup(JPIFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFormaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIFormaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_B).addComponent(this.JRB_A))));
        this.JCHFiltroEps.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroEps.setText("Filtro EPS");
        GroupLayout JPIFitroLayout = new GroupLayout(this.JPIFitro);
        this.JPIFitro.setLayout(JPIFitroLayout);
        JPIFitroLayout.setHorizontalGroup(JPIFitroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFitroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFitroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFitroLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JCBPrograma, 0, -1, 32767).addContainerGap()).addGroup(JPIFitroLayout.createSequentialGroup().addComponent(this.JCBEmpresa, -2, 505, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroEps).addGap(45, 45, 45).addComponent(this.JPIForma, -2, -1, -2).addGap(20, 20, 20)))));
        JPIFitroLayout.setVerticalGroup(JPIFitroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFitroLayout.createSequentialGroup().addGroup(JPIFitroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -1, -1, 32767).addComponent(this.JCBPrograma, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIFitroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFitroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, 51, -2).addComponent(this.JCHFiltroEps)).addComponent(this.JPIForma, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformes_Pyp_Eps.3
            public void mouseClicked(MouseEvent evt) {
                JIFInformes_Pyp_Eps.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosFLayout = new GroupLayout(this.JPIDatosF);
        this.JPIDatosF.setLayout(JPIDatosFLayout);
        JPIDatosFLayout.setHorizontalGroup(JPIDatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFitro, -1, -1, 32767).addComponent(this.JSPDetalle).addGroup(JPIDatosFLayout.createSequentialGroup().addComponent(this.JTFRuta, -1, 737, 32767).addGap(10, 10, 10).addComponent(this.JBTExportar, -2, 171, -2))).addContainerGap()));
        JPIDatosFLayout.setVerticalGroup(JPIDatosFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIFitro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 327, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosFLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        this.JTPDatos.addTab("DATOS", this.JPIDatosF);
        this.JPIOpcionesLab.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTUALIZAR FECHA Y VALOR DE LABORATORIO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JBGOpciones.add(this.JRB_1_Creatrinina);
        this.JRB_1_Creatrinina.setFont(new Font("Arial", 1, 12));
        this.JRB_1_Creatrinina.setText("Creatinina");
        this.JRB_1_Creatrinina.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.5
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_1_CreatrininaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_2_Microalbumina);
        this.JRB_2_Microalbumina.setFont(new Font("Arial", 1, 12));
        this.JRB_2_Microalbumina.setText("Microalbumina");
        this.JRB_2_Microalbumina.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_2_MicroalbuminaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_3_Glicemia);
        this.JRB_3_Glicemia.setFont(new Font("Arial", 1, 12));
        this.JRB_3_Glicemia.setText("Glicemia");
        this.JRB_3_Glicemia.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.7
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_3_GlicemiaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_4_Glicocilada);
        this.JRB_4_Glicocilada.setFont(new Font("Arial", 1, 12));
        this.JRB_4_Glicocilada.setText("Glicocilada");
        this.JRB_4_Glicocilada.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.8
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_4_GlicociladaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_5_CTotal);
        this.JRB_5_CTotal.setFont(new Font("Arial", 1, 12));
        this.JRB_5_CTotal.setText("Colesterol Total");
        this.JRB_5_CTotal.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.9
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_5_CTotalActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_6_CHdl);
        this.JRB_6_CHdl.setFont(new Font("Arial", 1, 12));
        this.JRB_6_CHdl.setText("Colesterol HDL");
        this.JRB_6_CHdl.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.10
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_6_CHdlActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_7_Ldl);
        this.JRB_7_Ldl.setFont(new Font("Arial", 1, 12));
        this.JRB_7_Ldl.setText("Colesterol LDL");
        this.JRB_7_Ldl.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.11
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_7_LdlActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_8_Trigliceridos);
        this.JRB_8_Trigliceridos.setFont(new Font("Arial", 1, 12));
        this.JRB_8_Trigliceridos.setText("Triglicerido");
        this.JRB_8_Trigliceridos.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.12
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_8_TrigliceridosActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_7_Proteinuria);
        this.JRB_7_Proteinuria.setFont(new Font("Arial", 1, 12));
        this.JRB_7_Proteinuria.setText("Proteinuria");
        this.JRB_7_Proteinuria.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.13
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_7_ProteinuriaActionPerformed(evt);
            }
        });
        this.JCHTipoC.setFont(new Font("Arial", 1, 12));
        this.JCHTipoC.setForeground(new Color(0, 0, 255));
        this.JCHTipoC.setText("Ingreso");
        this.JCHTipoC.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.14
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JCHTipoCActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_7_Proteinuria1);
        this.JRB_7_Proteinuria1.setFont(new Font("Arial", 1, 12));
        this.JRB_7_Proteinuria1.setText("Relacion Albumina/Creatinina");
        this.JRB_7_Proteinuria1.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.15
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_7_Proteinuria1ActionPerformed(evt);
            }
        });
        GroupLayout JPIOpcionesLabLayout = new GroupLayout(this.JPIOpcionesLab);
        this.JPIOpcionesLab.setLayout(JPIOpcionesLabLayout);
        JPIOpcionesLabLayout.setHorizontalGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLabLayout.createSequentialGroup().addContainerGap().addGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLabLayout.createSequentialGroup().addComponent(this.JRB_1_Creatrinina).addGap(35, 35, 35).addComponent(this.JRB_2_Microalbumina, -2, 129, -2).addGap(33, 33, 33).addComponent(this.JRB_3_Glicemia, -2, 101, -2)).addGroup(JPIOpcionesLabLayout.createSequentialGroup().addComponent(this.JRB_4_Glicocilada, -2, 100, -2).addGap(18, 18, 18).addComponent(this.JRB_5_CTotal, -2, 129, -2).addGap(33, 33, 33).addGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_6_CHdl, -2, 127, -2).addComponent(this.JRB_7_Proteinuria, -2, 127, -2))).addGroup(JPIOpcionesLabLayout.createSequentialGroup().addGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_7_Ldl).addComponent(this.JCHTipoC)).addGap(9, 9, 9).addGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_8_Trigliceridos, -2, 129, -2).addComponent(this.JRB_7_Proteinuria1, -2, 278, -2)))).addContainerGap(36, 32767)));
        JPIOpcionesLabLayout.setVerticalGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLabLayout.createSequentialGroup().addContainerGap().addGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_1_Creatrinina).addComponent(this.JRB_2_Microalbumina).addComponent(this.JRB_3_Glicemia)).addGap(10, 10, 10).addGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_4_Glicocilada).addComponent(this.JRB_5_CTotal).addComponent(this.JRB_6_CHdl)).addGap(10, 10, 10).addGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_7_Ldl).addComponent(this.JRB_8_Trigliceridos).addComponent(this.JRB_7_Proteinuria)).addGroup(JPIOpcionesLabLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOpcionesLabLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCHTipoC)).addGroup(GroupLayout.Alignment.TRAILING, JPIOpcionesLabLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_7_Proteinuria1).addContainerGap()))));
        this.JPIExamenFisico.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTUALIZAR DATOS EXÁMEN FÍSICO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGOpciones_Ex.add(this.JRB_9_PControl);
        this.JRB_9_PControl.setFont(new Font("Arial", 1, 12));
        this.JRB_9_PControl.setText("Primer Control");
        this.JRB_9_PControl.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.16
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_9_PControlActionPerformed(evt);
            }
        });
        this.JBGOpciones_Ex.add(this.JRB_10_UControl);
        this.JRB_10_UControl.setFont(new Font("Arial", 1, 12));
        this.JRB_10_UControl.setText("Ultimo Control");
        this.JRB_10_UControl.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.17
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_10_UControlActionPerformed(evt);
            }
        });
        GroupLayout JPIExamenFisicoLayout = new GroupLayout(this.JPIExamenFisico);
        this.JPIExamenFisico.setLayout(JPIExamenFisicoLayout);
        JPIExamenFisicoLayout.setHorizontalGroup(JPIExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenFisicoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRB_9_PControl, -2, 129, -2).addGap(33, 33, 33).addComponent(this.JRB_10_UControl, -2, 127, -2)));
        JPIExamenFisicoLayout.setVerticalGroup(JPIExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenFisicoLayout.createSequentialGroup().addContainerGap().addGroup(JPIExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_9_PControl).addComponent(this.JRB_10_UControl)).addContainerGap(-1, 32767)));
        this.JPICAdicionales.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTUALIZAR DATOS ADICIONALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGOpciones_CA.add(this.JRB_11_Inasistencia);
        this.JRB_11_Inasistencia.setFont(new Font("Arial", 1, 12));
        this.JRB_11_Inasistencia.setText("Inasistencia");
        this.JRB_11_Inasistencia.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.18
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_11_InasistenciaActionPerformed(evt);
            }
        });
        this.JBGOpciones_CA.add(this.JRB_12_PControl);
        this.JRB_12_PControl.setFont(new Font("Arial", 1, 12));
        this.JRB_12_PControl.setText("Próximo Control");
        this.JRB_12_PControl.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.19
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_12_PControlActionPerformed(evt);
            }
        });
        this.JBGOpciones_CA.add(this.JRB_13_NConsultasMG);
        this.JRB_13_NConsultasMG.setFont(new Font("Arial", 1, 12));
        this.JRB_13_NConsultasMG.setText("Cantidad de Consultas Médico General");
        this.JRB_13_NConsultasMG.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.20
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_13_NConsultasMGActionPerformed(evt);
            }
        });
        this.JBGOpciones_CA.add(this.JRB_14_NConsultasMI);
        this.JRB_14_NConsultasMI.setFont(new Font("Arial", 1, 12));
        this.JRB_14_NConsultasMI.setText("Cantidad de Consultas Medicina Interna");
        this.JRB_14_NConsultasMI.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.21
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_14_NConsultasMIActionPerformed(evt);
            }
        });
        this.JBGOpciones_CA.add(this.JRB_15_NConsultasSubEsp);
        this.JRB_15_NConsultasSubEsp.setFont(new Font("Arial", 1, 12));
        this.JRB_15_NConsultasSubEsp.setText("Cantidad de Consultas SubEspecialidades(Nefrología, Reumatología y Endocrinología)");
        this.JRB_15_NConsultasSubEsp.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.22
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_15_NConsultasSubEspActionPerformed(evt);
            }
        });
        this.JBGOpciones_CA.add(this.JRB_16_NConsultasNutricion);
        this.JRB_16_NConsultasNutricion.setFont(new Font("Arial", 1, 12));
        this.JRB_16_NConsultasNutricion.setText("Cantidad de Consultas Nutrición");
        this.JRB_16_NConsultasNutricion.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.23
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_16_NConsultasNutricionActionPerformed(evt);
            }
        });
        this.JBGOpciones_CA.add(this.JRB_17_NConsultasPsicologia);
        this.JRB_17_NConsultasPsicologia.setFont(new Font("Arial", 1, 12));
        this.JRB_17_NConsultasPsicologia.setText("Cantidad de Consultas Psicología");
        this.JRB_17_NConsultasPsicologia.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.24
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_17_NConsultasPsicologiaActionPerformed(evt);
            }
        });
        this.JBGOpciones_CA.add(this.JRB_18_NConsultasEnfermeria);
        this.JRB_18_NConsultasEnfermeria.setFont(new Font("Arial", 1, 12));
        this.JRB_18_NConsultasEnfermeria.setText("Cantidad de Consultas Enfermería");
        this.JRB_18_NConsultasEnfermeria.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.25
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_18_NConsultasEnfermeriaActionPerformed(evt);
            }
        });
        this.JBGOpciones_CA.add(this.JRB_18_NConsultasEnfermeria1);
        this.JRB_18_NConsultasEnfermeria1.setFont(new Font("Arial", 1, 12));
        this.JRB_18_NConsultasEnfermeria1.setText("Antecedentes Personales");
        this.JRB_18_NConsultasEnfermeria1.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.26
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_18_NConsultasEnfermeria1ActionPerformed(evt);
            }
        });
        GroupLayout JPICAdicionalesLayout = new GroupLayout(this.JPICAdicionales);
        this.JPICAdicionales.setLayout(JPICAdicionalesLayout);
        JPICAdicionalesLayout.setHorizontalGroup(JPICAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICAdicionalesLayout.createSequentialGroup().addContainerGap().addGroup(JPICAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICAdicionalesLayout.createSequentialGroup().addGroup(JPICAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICAdicionalesLayout.createSequentialGroup().addComponent(this.JRB_11_Inasistencia, -2, 129, -2).addGap(18, 18, 18).addComponent(this.JRB_12_PControl, -2, 127, -2).addGap(35, 35, 35).addComponent(this.JRB_13_NConsultasMG)).addComponent(this.JRB_15_NConsultasSubEsp)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, 32767).addGroup(JPICAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_14_NConsultasMI).addComponent(this.JRB_16_NConsultasNutricion))).addGroup(JPICAdicionalesLayout.createSequentialGroup().addComponent(this.JRB_17_NConsultasPsicologia).addGap(18, 18, 18).addComponent(this.JRB_18_NConsultasEnfermeria).addGap(18, 18, 18).addComponent(this.JRB_18_NConsultasEnfermeria1).addGap(0, 0, 32767))).addContainerGap()));
        JPICAdicionalesLayout.setVerticalGroup(JPICAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICAdicionalesLayout.createSequentialGroup().addContainerGap().addGroup(JPICAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_11_Inasistencia).addComponent(this.JRB_12_PControl).addComponent(this.JRB_13_NConsultasMG).addComponent(this.JRB_14_NConsultasMI)).addGap(18, 18, 18).addGroup(JPICAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_15_NConsultasSubEsp).addComponent(this.JRB_16_NConsultasNutricion)).addGap(18, 18, 18).addGroup(JPICAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_17_NConsultasPsicologia).addComponent(this.JRB_18_NConsultasEnfermeria).addComponent(this.JRB_18_NConsultasEnfermeria1)).addContainerGap(69, 32767)));
        this.jTextArea1.setColumns(20);
        this.jTextArea1.setRows(5);
        this.jScrollPane1.setViewportView(this.jTextArea1);
        this.JRB_9_PControl1.setFont(new Font("Arial", 1, 12));
        this.JRB_9_PControl1.setText("Agregar Usuario a programa por patologia");
        this.JRB_9_PControl1.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.27
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_9_PControl1ActionPerformed(evt);
            }
        });
        this.JPIVacunas.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTUALIZAR ULTIMA FECHA DE VACUNAS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGOpciones_Vacunas.add(this.JRB_VacunaInfluenza);
        this.JRB_VacunaInfluenza.setFont(new Font("Arial", 1, 12));
        this.JRB_VacunaInfluenza.setText("Influenza");
        this.JRB_VacunaInfluenza.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.28
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_VacunaInfluenzaActionPerformed(evt);
            }
        });
        this.JBGOpciones_Vacunas.add(this.JRB_VacunaNeumococo);
        this.JRB_VacunaNeumococo.setFont(new Font("Arial", 1, 12));
        this.JRB_VacunaNeumococo.setText("Neumococo");
        this.JRB_VacunaNeumococo.addActionListener(new ActionListener() { // from class: Sig.JIFInformes_Pyp_Eps.29
            public void actionPerformed(ActionEvent evt) {
                JIFInformes_Pyp_Eps.this.JRB_VacunaNeumococoActionPerformed(evt);
            }
        });
        GroupLayout JPIVacunasLayout = new GroupLayout(this.JPIVacunas);
        this.JPIVacunas.setLayout(JPIVacunasLayout);
        JPIVacunasLayout.setHorizontalGroup(JPIVacunasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIVacunasLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_VacunaInfluenza, -2, 129, -2).addGap(33, 33, 33).addComponent(this.JRB_VacunaNeumococo).addContainerGap(72, 32767)));
        JPIVacunasLayout.setVerticalGroup(JPIVacunasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIVacunasLayout.createSequentialGroup().addContainerGap().addGroup(JPIVacunasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_VacunaInfluenza).addComponent(this.JRB_VacunaNeumococo)).addContainerGap(-1, 32767)));
        GroupLayout JPIUtilidadesLayout = new GroupLayout(this.JPIUtilidades);
        this.JPIUtilidades.setLayout(JPIUtilidadesLayout);
        JPIUtilidadesLayout.setHorizontalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addContainerGap().addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPICAdicionales, -1, -1, 32767).addGroup(JPIUtilidadesLayout.createSequentialGroup().addComponent(this.JPIOpcionesLab, -2, -1, -2).addGap(18, 18, 18).addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIExamenFisico, -1, -1, 32767).addComponent(this.JRB_9_PControl1, -1, -1, 32767)).addComponent(this.JPIVacunas, -2, -1, -2)).addGap(0, 0, 32767)).addComponent(this.jScrollPane1)).addContainerGap()));
        JPIUtilidadesLayout.setVerticalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIOpcionesLab, -2, -1, -2).addGroup(JPIUtilidadesLayout.createSequentialGroup().addComponent(this.JPIExamenFisico, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIVacunas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_9_PControl1))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPICAdicionales, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 173, 32767).addContainerGap()));
        this.JTPDatos.addTab("PREPARAR INFORMES", this.JPIUtilidades);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_1_CreatrininaActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            mActualizarDatosExamen(241, "CS_FCreatinina", "CS_VCreatinina", "MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(3," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_1_Creatrinina.setForeground(new Color(0, 103, 0));
            return;
        }
        mActualizarDatosExamen(241, "I_FCreatinina", "I_VCreatinina", "MIN");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(4," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_1_Creatrinina.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_2_MicroalbuminaActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            mActualizarDatosExamen(347, "CS_FMicroalbumina", "CS_VMicroalbumina", "MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(5," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_2_Microalbumina.setForeground(new Color(0, 103, 0));
            return;
        }
        mActualizarDatosExamen(347, "I_FMicroalbumina", "I_VMicroalbumina", "MIN");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(6," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_2_Microalbumina.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_3_GlicemiaActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            mActualizarDatosExamen(283, "CS_FGlicemia", "CS_VGlicemia", "MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(7," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_3_Glicemia.setForeground(new Color(0, 103, 0));
            return;
        }
        mActualizarDatosExamen(283, "I_FGlicemia", "I_VGlicemia", "MIN");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(8," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_3_Glicemia.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_4_GlicociladaActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            mActualizarDatosExamen(291, "CS_FHGlicosilada", "CS_VHGlicosilada", "MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(9," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_4_Glicocilada.setForeground(new Color(0, 103, 0));
            return;
        }
        mActualizarDatosExamen(291, "I_FHGlicosilada", "I_VHGlicosilada", "MIN");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(10," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_4_Glicocilada.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_5_CTotalActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            mActualizarDatosExamen(55, "CS_FColesterolT", "CS_VColesterolT", "MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(11," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_5_CTotal.setForeground(new Color(0, 103, 0));
            return;
        }
        mActualizarDatosExamen(55, "I_FColesterolT", "I_VColesterolT", "MIN");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(12," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_5_CTotal.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_6_CHdlActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            mActualizarDatosExamen(56, "CS_FColesterolHdl", "CS_VColesterolHdl", "MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(13," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_6_CHdl.setForeground(new Color(0, 103, 0));
            return;
        }
        mActualizarDatosExamen(56, "I_FColesterolHdl", "I_VColesterolHdl", "MIN");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(14," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_6_CHdl.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_7_LdlActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            mActualizarDatosExamen(57, "CS_FColesterolLdl", "CS_VColesterolLdl", "MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(15," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_7_Ldl.setForeground(new Color(0, 103, 0));
            return;
        }
        mActualizarDatosExamen(57, "I_FColesterolLdl", "I_VColesterolLdl", "MIN");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(16," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_7_Ldl.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_8_TrigliceridosActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            mActualizarDatosExamen(59, "CS_FTrigliceridos", "CS_VTrigliceridos", "MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(2," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_8_Trigliceridos.setForeground(new Color(0, 103, 0));
            return;
        }
        mActualizarDatosExamen(59, "I_FTrigliceridos", "I_VTrigliceridos", "MIN");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(1," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_8_Trigliceridos.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTipoCActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            this.JCHTipoC.setText("Ultimo Control");
        } else {
            this.JCHTipoC.setText("Ingreso");
        }
        mCambiarColorCheckBox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_9_PControlActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            mActualizarDatosExamenFisico("MIN");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(17," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_examen_fisico_atencion";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_examen_fisico_datos_atencion";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_9_PControl.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_10_UControlActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            mActualizarDatosExamenFisico("MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(18," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(27," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_examen_fisico_atencion";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_examen_fisico_datos_atencion";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_dx_asociados";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_10_UControl.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_11_InasistenciaActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "DROP VIEW IF EXISTS v_pyp_citas_inasistencia";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_pyp_citas_inasistencia`  AS SELECT`c_citas`.`Id_Usuario` AS `Id_Usuario`,`c_citas`.`Fecha_Cita` AS `Fecha_Cita`,COUNT(`c_citas`.`Asistida`) AS `Cantidad` FROM (`c_citas` JOIN `c_clasecita` ON ((`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)))  WHERE ((`c_clasecita`.`Id_Programa` ='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "')  AND (`c_citas`.`Fecha_Cita` <'" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') AND (`c_citas`.`Id_MotivoDesistida` > 1)) GROUP BY `c_citas`.`Id_Usuario` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(19," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_citas_inasistencia";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_11_Inasistencia.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_12_PControlActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "DROP VIEW IF EXISTS v_pyp_citas_proximo_control";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_pyp_citas_proximo_control`  AS SELECT`c_citas`.`Id_Usuario` AS `Id_Usuario`,`c_citas`.`Fecha_Cita` AS `Fecha_Cita` FROM (`c_citas` JOIN `c_clasecita` ON ((`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`))) WHERE ((`c_clasecita`.`Id_Programa` = '" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "') AND (`c_citas`.`Asistida` = 0) AND (`c_citas`.`Fecha_Cita` > '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') AND (`c_citas`.`Id_MotivoDesistida` = 1)) ORDER BY `c_citas`.`Id_Usuario` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(20," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_citas_proximo_control";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_12_PControl.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_13_NConsultasMGActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_pyp_cantidad_consultas`  AS SELECT`ingreso`.`Id_Usuario` AS `Id_Usuario`,COUNT(`ingreso`.`Id_Usuario`) AS `Cantidad` FROM ((`h_atencion` JOIN `ingreso` ON ((`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`))) JOIN `g_usuarioxprograma` ON ((`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`))) WHERE ((`h_atencion`.`Id_Especialidad` = 382) AND (`h_atencion`.`Codigo_Dxp` <> '') AND (`g_usuarioxprograma`.`Id_Programa` = '" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "') AND (`h_atencion`.`Fecha_Atencion` < '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')) GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(21," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_13_NConsultasMG.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_14_NConsultasMIActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_pyp_cantidad_consultas`  AS SELECT`ingreso`.`Id_Usuario` AS `Id_Usuario`,COUNT(`ingreso`.`Id_Usuario`) AS `Cantidad` FROM ((`h_atencion` JOIN `ingreso` ON ((`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`))) JOIN `g_usuarioxprograma` ON ((`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`))) WHERE ((`h_atencion`.`Id_Especialidad` = 387) AND (`h_atencion`.`Codigo_Dxp` <> '') AND (`g_usuarioxprograma`.`Id_Programa` = '" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "') AND (`h_atencion`.`Fecha_Atencion` < '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')) GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(22," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_14_NConsultasMI.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_15_NConsultasSubEspActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_pyp_cantidad_consultas`  AS SELECT`ingreso`.`Id_Usuario` AS `Id_Usuario`,COUNT(`ingreso`.`Id_Usuario`) AS `Cantidad` FROM ((`h_atencion` JOIN `ingreso` ON ((`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`))) JOIN `g_usuarioxprograma` ON ((`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`))) WHERE ((`h_atencion`.`Id_Especialidad` In(410,620,241)  ) AND (`h_atencion`.`Codigo_Dxp` <> '') AND (`g_usuarioxprograma`.`Id_Programa` = '" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "') AND (`h_atencion`.`Fecha_Atencion` < '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')) GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(23," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_15_NConsultasSubEsp.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_16_NConsultasNutricionActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_pyp_cantidad_consultas`  AS SELECT`ingreso`.`Id_Usuario` AS `Id_Usuario`,COUNT(`ingreso`.`Id_Usuario`) AS `Cantidad` FROM ((`h_atencion` JOIN `ingreso` ON ((`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`))) JOIN `g_usuarioxprograma` ON ((`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`))) WHERE ((`h_atencion`.`Id_Especialidad`=451  ) AND (`h_atencion`.`Codigo_Dxp` <> '') AND (`g_usuarioxprograma`.`Id_Programa` = '" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "') AND (`h_atencion`.`Fecha_Atencion` < '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')) GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(24," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_16_NConsultasNutricion.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_17_NConsultasPsicologiaActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_pyp_cantidad_consultas`  AS SELECT`ingreso`.`Id_Usuario` AS `Id_Usuario`,COUNT(`ingreso`.`Id_Usuario`) AS `Cantidad` FROM ((`h_atencion` JOIN `ingreso` ON ((`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`))) JOIN `g_usuarioxprograma` ON ((`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`))) WHERE ((`h_atencion`.`Id_Especialidad`=710  ) AND (`h_atencion`.`Codigo_Dxp` <> '') AND (`g_usuarioxprograma`.`Id_Programa` = '" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "') AND (`h_atencion`.`Fecha_Atencion` < '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')) GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(25," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_17_NConsultasPsicologia.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_18_NConsultasEnfermeriaActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_pyp_cantidad_consultas`  AS SELECT`ingreso`.`Id_Usuario` AS `Id_Usuario`,COUNT(`ingreso`.`Id_Usuario`) AS `Cantidad` FROM ((`h_atencion` JOIN `ingreso` ON ((`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`))) JOIN `g_usuarioxprograma` ON ((`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`))) WHERE ((`h_atencion`.`Id_Especialidad` IN(1022,3)  ) AND (`h_atencion`.`Codigo_Dxp` <> '') AND (`g_usuarioxprograma`.`Id_Programa` = '" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "') AND (`h_atencion`.`Fecha_Atencion` < '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')) GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(26," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_cantidad_consultas";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_18_NConsultasEnfermeria.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                if (this.JRB_A.isSelected()) {
                    mExportar_FA();
                    return;
                } else {
                    mExportar_FB();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_7_ProteinuriaActionPerformed(ActionEvent evt) {
        if (this.JCHTipoC.isSelected()) {
            mActualizarDatosExamen(339, "CS_FProteinuria", "CS_VProteinuria", "MAX");
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(28," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_7_Proteinuria.setForeground(new Color(0, 103, 0));
            return;
        }
        mActualizarDatosExamen(339, "I_FProteinuria", "I_VProteinuria", "MIN");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(29," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_7_Proteinuria.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_BActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_18_NConsultasEnfermeria1ActionPerformed(ActionEvent evt) {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            this.xsql = "DROP VIEW IF EXISTS v_pyp_dx_asociados";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_pyp_dx_asociados`  AS SELECT `h_patologiaasociadas`.`Id_Usuario` , IF(GROUP_CONCAT(CONCAT(DATE_FORMAT(`h_patologiaasociadas`.`Fecha`,'%d-%m-%y'),'_', `h_patologiaasociadas`.`Id_Patologia`,'_',`g_patologia`.`Nbre`) SEPARATOR '\n') IS NULL, '', GROUP_CONCAT(CONCAT(DATE_FORMAT(`h_patologiaasociadas`.`Fecha`,'%d-%m-%y'),'_', `h_patologiaasociadas`.`Id_Patologia`,'_',`g_patologia`.`Nbre`) SEPARATOR '\n'))  AS `Patologias` FROM `h_patologiaasociadas` INNER JOIN `g_patologia`  ON (`h_patologiaasociadas`.`Id_Patologia` = `g_patologia`.`Id`) WHERE (`h_patologiaasociadas`.`Id_Patologia` <>'0000' )  GROUP BY `h_patologiaasociadas`.`Id_Usuario` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL pyp_actualizar_datos_examenes_lab(30," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_pyp_dx_asociados";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.JRB_18_NConsultasEnfermeria1.setForeground(new Color(0, 103, 0));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTPDatos.setSelectedIndex(0);
        this.JCBPrograma.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_9_PControl1ActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.xsql = "INSERT INTO g_usuarioxprograma(`Id_Usuario` , `Id_Programa`) SELECT `ingreso`.`Id_Usuario` , `g_patologia_programa`.`Id_Programa` FROM  `g_patologia_programa` INNER JOIN  `h_atencion`  ON (`g_patologia_programa`.`Id_Patologia` = `h_atencion`.`Codigo_Dxp`) INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) LEFT JOIN  `g_usuarioxprograma`  ON (`g_usuarioxprograma`.`Id_Programa` = `g_patologia_programa`.`Id_Programa`) AND (`g_usuarioxprograma`.`Id_Usuario` = `ingreso`.`Id_Usuario`) WHERE (`g_usuarioxprograma`.`Id` IS NULL) GROUP BY `ingreso`.`Id_Usuario`, `g_patologia_programa`.`Id_Programa` ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_7_Proteinuria1ActionPerformed(ActionEvent evt) {
        mActualizarDatosExamen(353, "CS_FRAlbuminaCreatinina", "CS_VRAlbuminaCreatinina", "MAX");
        this.xsql = "CALL pyp_actualizar_datos_examenes_lab(31," + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + ")";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JRB_7_Proteinuria1.setForeground(new Color(0, 103, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_VacunaInfluenzaActionPerformed(ActionEvent evt) {
        actualizarFechasVacunas(11, "fechaVacunaInfluenza", this.JRB_VacunaInfluenza);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_VacunaNeumococoActionPerformed(ActionEvent evt) {
        actualizarFechasVacunas(14, "fechaVacunaNeumococo", this.JRB_VacunaNeumococo);
    }

    private void actualizarFechasVacunas(Integer idVacuna, String columnaActualizar, JRadioButton jr) {
        this.xsql = "update g_usuarioxprograma , (\nWITH    maestra  as (\nSELECT  pvc.IdPaciente , pvc.FechaVacuna, pvc.id \nfrom p_vacunacion_carnet pvc \ninner join p_vacunacion_esquema pve on (pve.Id=pvc.IdEsquema)\ninner join p_vacunacion_vacunas pvv on (pvv.Id=pve.IdVacuna)\nwhere pvv.Id =" + idVacuna + " and pvc.FechaVacuna is not null and  pvc.FechaVacuna<>''\n)\n, \nmaxVacuna as(\nSELECT  max(pvc.id) idMaxVacuna\nfrom p_vacunacion_carnet pvc \ninner join p_vacunacion_esquema pve on (pve.Id=pvc.IdEsquema)\ninner join p_vacunacion_vacunas pvv on (pvv.Id=pve.IdVacuna)\n where pvv.Id =" + idVacuna + " and pvc.FechaVacuna is not null and  pvc.FechaVacuna<>''\ngroup by pvc.IdPaciente, pvv.Id\n),\n\nresultadoConsulta as (\n\tSELECT  maestra.IdPaciente, maestra.FechaVacuna\n\t\n\tfrom maestra\n\tinner join maxVacuna on (maestra.id=maxVacuna.idMaxVacuna)\n)\n\n\nSELECT resultadoConsulta.IdPaciente, resultadoConsulta.FechaVacuna from resultadoConsulta \n) d\n\nset g_usuarioxprograma.`" + columnaActualizar + "` =d.FechaVacuna\nwhere d.IdPaciente=g_usuarioxprograma.Id_Usuario \n\n  \n";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        jr.setForeground(new Color(0, 103, 0));
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mLlenarCombo();
        mCrearTablaDetallePyP_FA();
    }

    private void mLlenarCombo() {
        this.xlleno = false;
        this.JCBEmpresa.removeAllItems();
        this.JCBPrograma.removeAllItems();
        this.xsql = "SELECT`persona`.`IdEmpresaCont`, `persona`.`EPS` FROM `g_usuarioxprograma` INNER JOIN `persona`  ON (`g_usuarioxprograma`.`Id_Usuario` = `persona`.`Id_persona`) WHERE (`g_usuarioxprograma`.`Estado` =0) GROUP BY `persona`.`IdEmpresaCont` ORDER BY `persona`.`EPS` ASC";
        this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xsql = "SELECT`g_tipoprograma`.`Id_TipoPrograma` , `g_tipoprograma`.`Nbre` FROM `g_usuarioxprograma` INNER JOIN  `persona`  ON (`g_usuarioxprograma`.`Id_Usuario` = `persona`.`Id_persona`) INNER JOIN  `g_tipoprograma`  ON (`g_usuarioxprograma`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`) WHERE (`g_usuarioxprograma`.`Estado` =0) GROUP BY `g_tipoprograma`.`Id_TipoPrograma` ORDER BY `g_tipoprograma`.`Nbre` ASC ";
        this.xidprograma = this.xct.llenarCombo(this.xsql, this.xidprograma, this.JCBPrograma);
        this.JCBPrograma.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mActualizarDatosExamen(int xnprotocolo, String xvariableF, String xvariableV, String xtipoc) {
        this.xsql = "DROP VIEW IF EXISTS v_pyp_resultado_examen_primero";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_pyp_resultado_examen_primero`  AS SELECT`l_recepcion`.`Id_Paciente` AS `Id_Paciente`," + xtipoc + "(`l_detalleresultado`.`Id_Resultado`) AS `Id_Resultado` FROM ((((((`l_detalleresultado` JOIN `l_resultados` ON ((`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`))) JOIN `l_recepcion` ON ((`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`))) JOIN `l_protocoloxprocedimiento` ON ((`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`))) JOIN `l_protocolos` ON ((`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`))) JOIN `g_procedimiento` ON ((`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`))) JOIN `g_usuarioxprograma` ON ((`g_usuarioxprograma`.`Id_Usuario` = `l_recepcion`.`Id_Paciente`))) WHERE ((`l_protocolos`.`Id` ='" + xnprotocolo + "') AND (`l_resultados`.`Estado` = 0)) GROUP BY `l_recepcion`.`Id_Paciente` ORDER BY `l_recepcion`.`Id_Paciente` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_pyp_resultado_examen_p";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_pyp_resultado_examen_p`  AS SELECT `l_recepcion`.`Id_Paciente`       AS `Id_Paciente`, " + xtipoc + "(`l_resultados`.`FechaResult`) AS `FechaR`,  `l_detalleresultado`.`VrNumerico` AS `VrNumerico` FROM (((((((`l_detalleresultado` JOIN `l_resultados` ON ((`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`))) JOIN `l_recepcion` ON ((`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`))) JOIN `l_protocoloxprocedimiento` ON ((`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)))  JOIN `l_protocolos` ON ((`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`))) JOIN `g_procedimiento` ON ((`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`)))    JOIN `v_pyp_resultado_examen_primero` ON ((`v_pyp_resultado_examen_primero`.`Id_Resultado` = `l_detalleresultado`.`Id_Resultado`)))  JOIN `g_usuarioxprograma` ON ((`g_usuarioxprograma`.`Id_Usuario` = `l_recepcion`.`Id_Paciente`))) WHERE ((`l_protocolos`.`Id` = '" + xnprotocolo + "') AND (`l_resultados`.`Estado` = 0) AND (`l_resultados`.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')) GROUP BY `l_recepcion`.`Id_Paciente`,`l_detalleresultado`.`Id_Resultado` ORDER BY `l_resultados`.`FechaResult` DESC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mActualizarDatosExamenFisico(String xtipoc) {
        this.xsql = "DROP VIEW IF EXISTS v_pyp_examen_fisico_atencion";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_pyp_examen_fisico_atencion`  AS SELECT " + xtipoc + "(`h_atencion`.`Id`) as Id_Atencion, `ingreso`.`Id_Usuario`, " + xtipoc + "(h_atencion.`Fecha_Atencion`) FROM `h_atencion` INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_examenfisico`  ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `c_clasecita`.`Id_Programa` ='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `h_atencion`.`Id` DESC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_pyp_examen_fisico_datos_atencion";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_pyp_examen_fisico_datos_atencion`  AS  SELECT v_pyp_examen_fisico_atencion.Id_Usuario AS Id_Usuario,DATE_FORMAT(`h_examenfisico`.`Fecha`,'%Y-%m-%d') as Fecha ,`h_examenfisico`.`TArtSentadoD` AS `TArtSentadoD`,`h_examenfisico`.`TArtSentadoS`       AS `TArtSentadoS`,`h_examenfisico`.`Talla`              AS `Talla`,`h_examenfisico`.`Peso`               AS `Peso`,  `h_examenfisico`.`IMC`                AS `IMC`, `h_examenfisico`.`PerimetroAbdominal` AS `PerimetroAbdominal`, `h_tipo_riesgo`.`Nbre` as CRiesgo, `g_ocupacion`.`Nbre` AS OcupacionUsuario  FROM `v_pyp_examen_fisico_atencion` INNER JOIN `h_examenfisico`  ON (`v_pyp_examen_fisico_atencion`.`Id_Atencion` = `h_examenfisico`.`Id_Atencion`) INNER JOIN `h_tipo_riesgo` ON (`h_examenfisico`.`Id_CRiesgo` = `h_tipo_riesgo`.`Id`)  INNER JOIN `h_atencion`  ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `g_ocupacion`  ON (`ingreso`.`Id_Ocupacion` = `g_ocupacion`.`Id`)   ORDER BY v_pyp_examen_fisico_atencion.Id_Usuario ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_pyp_dx_asociados";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_pyp_dx_asociados`  AS  SELECT  v_pyp_examen_fisico_atencion.Id_Usuario, GROUP_CONCAT(CONCAT(`h_atenciondx`.`Id_Dx`,'-',`g_patologia`.`Nbre`) SEPARATOR ', ') AS U_Diagnostico  FROM `h_atenciondx`  INNER JOIN  v_pyp_examen_fisico_atencion  ON (`h_atenciondx`.`Id_Atencion` = `v_pyp_examen_fisico_atencion`.`Id_Atencion`)  INNER JOIN  `g_patologia`   ON (`h_atenciondx`.`Id_Dx` = `g_patologia`.`Id`) WHERE (`h_atenciondx`.`Orden` >=1) GROUP BY `h_atenciondx`.`Id_Atencion`;";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mActualizarDiabetesHta(String xtipoc) {
        this.xsql = "DROP VIEW IF EXISTS v_pyp_examen_fisico_atencion";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_pyp_examen_fisico_atencion`  AS SELECT " + xtipoc + "(`h_atencion`.`Id`) as Id_Atencion, `ingreso`.`Id_Usuario` FROM `h_atencion` INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_examenfisico`  ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `c_clasecita`.`Id_Programa` ='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `h_atencion`.`Id` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_pyp_examen_fisico_datos_atencion";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_pyp_examen_fisico_datos_atencion`  AS SELECT v_pyp_examen_fisico_atencion.Id_Usuario AS Id_Usuario,DATE_FORMAT(`h_examenfisico`.`Fecha`,'%Y-%m-%d') as Fecha ,`h_examenfisico`.`TArtSentadoD` AS `TArtSentadoD`,`h_examenfisico`.`TArtSentadoS`       AS `TArtSentadoS`,`h_examenfisico`.`Talla`              AS `Talla`,`h_examenfisico`.`Peso`               AS `Peso`, `h_examenfisico`.`IMC`                AS `IMC`, `h_examenfisico`.`PerimetroAbdominal` AS `PerimetroAbdominal`, `h_tipo_riesgo`.`Nbre` as CRiesgo FROM `v_pyp_examen_fisico_atencion` INNER JOIN `h_examenfisico`  ON (`v_pyp_examen_fisico_atencion`.`Id_Atencion` = `h_examenfisico`.`Id_Atencion`) INNER JOIN `h_tipo_riesgo` ON (`h_examenfisico`.`Id_CRiesgo` = `h_tipo_riesgo`.`Id`) ORDER BY v_pyp_examen_fisico_atencion.Id_Usuario ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mCambiarColorCheckBox() {
        for (int x = 0; x < this.JPIOpcionesLab.getComponentCount(); x++) {
            if (this.JPIOpcionesLab.getComponent(x).getClass().getName().equals("javax.swing.JRadioButton")) {
                JRadioButton xvar = this.JPIOpcionesLab.getComponent(x);
                xvar.setForeground(Color.BLACK);
            }
        }
    }

    private void mCrearTablaDetallePyP_FA() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"CodigoOrganismo", "CodMunicipio", "CodDepartamento", "NMunicipio", "NEmpresa", "FIngresoP", "Apellido1", "Apellido2", "Nombre", "Id_TipoIdentificacion", "NoDocumento", "Edad_Ingreso", "Edad_Actual", "Id_Sexo", "EstadoCivil", "Escolaridad", "Direccion", "Telefono", "Celular", "Es_Hta", "Hta_TipoDx", "Hta_AnoDx", "Hta_MesDx", "Es_Dm", "Dm_Tipo", "Dm_AnoDx", "Dm_MesDx", "ERC", "Erc_TipoDx", "Erc_AnoDx", "Erc_MesDx", "ClasifRiesgoHTA", "I_CRiesgo", "I_Tipo_Diabetes", "I_Tipo_Insulina", "TFG_Valor", "TFG_Fecha", "NFG_Estadio", "NFF_Proteinuro", "NFP_POrina", "NFF_Microalbumina", "NFF_Ecografia", "NFF_RegresionE", "NF_VMicroalbumina", "Programa_Pertence", "I_Talla", "I_Peso", "TASistolica", "TADiastolica", "I_Imc", "PAbdominal", "I_VCreatinina", "I_FCreatinina", "I_VMicroalbumina", "I_FMicroAlbumina", "I_VGlicemia", "I_FGlicemia", "I_VHGlicosilada", "I_FHGlicosilada", "I_VColesterolT", "I_FColesterolT", "I_VColesterolHdl", "I_FColesterolHdl", "I_VColesterolLdl", "I_FColesterolLdl", "I_VTrigliceridos", "I_FTrigliceridos", "I_TFG", "FU_Control", "FP_Control", "CS_Inasistencia_Cant", "I_FColesterolT", "CS_Inasistencia_Causa", "CS_NConsultas_MG", "CS_NConsultas_MI", "CS_NConsultas_Sub", "CS_NConsultas_N", "CS_NConsultas_PS", "CS_NConsultas_Enf", "CS_NConsultas_N_Grupales", "CS_NConsultas_PS_Grupales", "U_CRiesgo_Hta", "U_CRiesgo", "U_TipoDiabetes", "U_TipoInsulina", "U_Estadio_NFP", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "NF_Predialisis", "NF_Dialisis", "NF_Trasplante", "U_Talla", "U_Peso", "U_PSistolica", "U_PDiastolica", "U_Imc", "U_PAbdominal", "CS_VCreatinina", "CS_FCreatinina", "CS_VMicroalbumina", "CS_FMicroalbumina", "CS_VGlicemia", "CS_FGlicemia", "CS_VHGlicosilada", "CS_FHGlicosilada", "CS_VColesterolT", "CS_FColesterolT", "CS_VColesterolHdl", "CS_FColesterolHdl", "CS_VColesterolLdl", "CS_FColesterolLdl", "CS_VTrigliceridos", "CS_FTrigliceridos", "121", "122", "CS_UTFG", "124", "125", "126", "127", "128", "H129", "H130", "H131", "H132", "H133", "H134", "C135", "C136", "C137", "C138", "C139", "C140", "C141", "C142", "C143", "C144", "C145", "C146", "MtdoPlaniFliar", "HtaEstadio", "DxAsociados", "ClasificacionRiesgoCardiovascular", "FechaHospitalizacion", "DxHospitalizacion", "CS_VGlicemia", "CS_VHGlicosilada", "CS_VProteinuria", "FechaIngreso", "EPS", "CS_FRAlbuminaCreatinina", "CS_VRAlbuminaCreatinina", "fechaVacunaInfluenza", "fechaVacunaNeumococo"}) { // from class: Sig.JIFInformes_Pyp_Eps.30
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
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
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(53).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(53).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(53).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(54).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(54).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(54).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(55).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(55).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(55).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(56).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(56).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(56).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(57).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(57).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(57).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(58).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(58).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(58).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(59).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(59).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(59).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(60).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(60).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(60).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(61).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(61).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(61).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(62).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(62).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(62).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(63).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(63).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(63).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(64).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(64).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(64).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(65).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(65).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(65).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(65).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(65).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(65).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(66).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(66).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(66).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(67).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(67).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(67).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(68).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(68).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(68).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(69).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(69).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(69).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(70).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(70).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(70).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(71).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(71).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(71).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(72).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(72).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(72).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(73).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(73).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(73).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(74).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(74).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(74).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(75).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(75).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(75).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(76).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(76).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(76).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(77).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(77).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(77).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(78).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(78).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(78).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(79).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(79).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(79).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(80).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(80).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(80).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(81).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(81).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(81).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(82).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(82).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(82).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(83).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(83).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(83).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(84).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(84).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(84).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(85).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(85).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(85).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(86).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(86).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(86).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(87).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(87).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(87).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(88).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(88).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(88).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(89).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(89).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(89).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(90).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(90).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(90).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(91).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(91).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(91).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(92).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(92).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(92).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(93).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(93).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(93).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(94).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(94).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(94).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(95).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(95).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(95).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(96).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(96).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(96).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(97).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(97).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(97).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(98).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(98).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(98).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(99).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(99).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(99).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(100).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(100).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(100).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(101).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(101).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(101).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(102).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(102).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(102).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(103).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(103).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(103).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(104).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(104).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(104).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(105).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(105).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(105).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(106).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(106).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(106).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(107).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(107).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(107).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(108).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(108).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(108).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(109).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(109).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(109).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(110).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(110).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(110).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(111).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(111).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(111).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(112).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(112).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(112).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(113).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(113).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(113).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(114).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(114).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(114).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(115).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(115).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(115).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(116).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(116).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(116).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(117).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(117).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(117).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(118).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(118).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(118).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(119).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(119).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(119).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(120).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(120).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(120).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(121).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(121).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(121).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(122).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(122).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(122).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(123).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(123).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(123).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(124).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(124).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(124).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(125).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(125).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(125).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(126).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(126).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(126).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(127).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(127).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(127).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(128).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(128).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(128).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(129).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(129).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(129).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(130).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(130).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(130).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(131).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(131).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(131).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(132).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(132).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(132).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(133).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(133).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(133).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(134).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(134).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(134).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(135).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(135).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(135).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(136).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(136).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(136).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(137).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(137).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(137).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(138).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(138).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(138).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(139).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(139).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(139).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(140).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(140).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(140).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(141).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(141).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(141).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(142).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(142).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(142).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(143).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(143).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(143).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(144).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(144).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(144).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(145).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(145).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(145).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(146).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(146).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(146).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(147).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(147).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(147).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(148).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(148).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(148).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(149).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(149).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(149).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(150).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(150).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(150).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(151).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(151).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(151).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(152).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(152).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(152).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(153).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(153).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(153).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(154).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(154).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(154).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(155).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(155).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(155).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(156).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(156).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(156).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(157).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(157).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(157).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(158).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(159).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(160).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(161).setPreferredWidth(100);
    }

    private void mCrearTablaDetallePyP_FB() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NIps", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_TipoIdentificacion", "NoDocumento", "NSexo", "Escolaridad", "FechaNac", "Edad_Actual", "NEtnia", "GPEspeciales", "Ocupacion", "Direccion", "Zona", "Telefono", "Email", "Medico", "VIngreso", "ESIngreso", "FechaIngreso", "I_Peso", "I_Talla", "I_Imc", "I_FechaDx", "I_Clasificacion_Estadio", "Otras patologias", "Actividad_Fisica", "CAlcohol", "C_Tabaquismo", "CNutricional", "CEnfermedadC", "V_Creatinina", "FU_Control", "U_Diagnostico", "U_Peso", "U_Imc", "U_PSistolica", "U_PDiastolica", "C_VColesterolT", "CS_FColesterolT", "CS_ColesterolHdl", "CS_FColesterolHdl", "CS_ColesterolLdl", "CS_FColesterolLdl", "CS_VTrigliceridos", "CS_FTrigliceridos", "CS_Microalbumina", "CS_VCreatinina", "FechaUltimaCreatinina", "CS_VProteinuria", "FechaProteinuria", "O_PRealizado", "o_Fecha_P", "O_RMedicamentos", "O_Cual_Medicamento", "I_CPanifica", "FP_Control", "Fecha_Hospitalizacion", "DxHospitalizacion", "EPS", "IdUsuario", "FecUltimaCitaNefrologia", "FecUltHemoglobina", "ValorUltimaHemoglobina", "FecUltimaMicroalbuminuria", "CS_VGlicemia", "CS_FGlicemia", "FecDepuracionCreatinina", "ValorUltimaDepCreatinina", "FecFiltracionGlome", "ValorFiltracionGlome", "FechaPTH", "ValorPTH", "FechaBUN", "ValorBUN", "FechaPSA", "ValorPSA", "FechaPotasio", "ValorPotasio", "FechaAcidoUrico", "ValorAcidoUrico", "FechaCalcio", "ValorCalcio", "FechaUltimoEKG", "UltAtenNutricion", "UltAtenOdontologia", "UltAtenOftamologia", "UltAtenMedInterna"}) { // from class: Sig.JIFInformes_Pyp_Eps.31
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(15);
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
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
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
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(53).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(53).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(53).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(54).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(54).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(54).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(55).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(55).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(55).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(56).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(56).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(56).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(57).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(57).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(57).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(58).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(58).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(58).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(59).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(59).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(59).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(60).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(60).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(60).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(61).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(61).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(61).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(62).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(62).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(62).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(63).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(63).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(63).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(64).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(64).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(64).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(65).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(65).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(65).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(66).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(66).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(66).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(67).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(67).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(67).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(68).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(68).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(68).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(69).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(69).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(69).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(70).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(70).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(70).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(71).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(71).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(71).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(72).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(72).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(72).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(73).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(73).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(73).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(74).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(74).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(74).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(75).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(75).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(75).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(76).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(76).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(76).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(77).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(77).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(77).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(78).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(78).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(78).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(79).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(79).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(79).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(80).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(80).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(80).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(81).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(81).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(81).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(82).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(82).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(82).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(83).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(83).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(83).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(84).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(84).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(84).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(85).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(85).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(85).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(86).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(86).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(86).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(87).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(87).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(87).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(88).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(88).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(88).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(89).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(89).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(89).setMaxWidth(0);
    }

    private void mCargarDatosTabla_FA() {
        try {
            mCrearTablaDetallePyP_FA();
            if (this.JCHFiltroEps.isSelected()) {
                this.xsql = "SELECT `d_ips`.`CodigoOrganismo`, `d_ips`.`CodMunicipio`, `d_ips`.`CodDepartamento`, `d_ips`.`NMunicipio`, `d_ips`.`NEmpresa` , IF(`g_usuarioxprograma`.`I_Fecha` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`I_Fecha`,'%d/%m/%Y')) AS `FIngresoP`, `persona`.`Apellido1`, `persona`.`Apellido2` , CONCAT(`persona`.`Nombre1`,' ' ,`persona`.`Nombre2`) AS `Nombre`, `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento` , IF(ROUND(DATEDIFF(`g_usuarioxprograma`.`I_Fecha`, `persona`.`FechaNac`)/365) IS NULL, '',ROUND(DATEDIFF(`g_usuarioxprograma`.`I_Fecha`, `persona`.`FechaNac`)/365) )  AS `Edad_Ingreso`, ROUND(DATEDIFF(NOW(), `persona`.`FechaNac`)/365) AS `Edad_Acutal` , `persona`.`IdSexo`, `persona`.`EstadoCivil`, `persona`.`Escolaridad`, `persona`.`Direccion`, `persona`.`Telefono`, `persona`.`Celular` , IF(`g_usuarioxprograma`.`EsDM_HTA`=1,'X','') AS `Es_Hta`, IF(`g_usuarioxprograma`.`Hta_TipoDx`=-1,'',IF(`g_usuarioxprograma`.`Hta_TipoDx`=0, 'Nuevo', 'Conocido')) AS `Hta_TipoDx` , IF(`g_usuarioxprograma`.`Hta_FechaDx`IS NULL, '1900', DATE_FORMAT(`g_usuarioxprograma`.`Hta_FechaDx`,'%Y') ) AS `Hta_AnoDx` , IF(`g_usuarioxprograma`.`Hta_FechaDx`IS NULL, '1', DATE_FORMAT(`g_usuarioxprograma`.`Hta_FechaDx`,'%m') ) AS `Hta_MesDx` , IF(`g_usuarioxprograma`.`Id_Programa`=1,'X','') AS `Es_Dm`, IF(`g_usuarioxprograma`.`I_TipoDx`=-1,'',IF(`g_usuarioxprograma`.`I_TipoDx`=0, 'Nuevo', 'Conocido')) AS `Dm_Tipo` , IF(`g_usuarioxprograma`.`I_FechaDx`IS NULL, '1900', DATE_FORMAT(`g_usuarioxprograma`.`I_FechaDx`,'%Y') ) AS `Dm_AnoDx` , IF(`g_usuarioxprograma`.`I_FechaDx`IS NULL, '1', DATE_FORMAT(`g_usuarioxprograma`.`I_FechaDx`,'%m') ) AS `Dm_MesDx` , IF(`g_usuarioxprograma`.`I_NF_Fecha` IS NULL, 'NO', 'SI') AS `ERC`, IF(`g_usuarioxprograma`.`I_NF_TipoDx`=-1,'',IF(`g_usuarioxprograma`.`I_NF_TipoDx`=0, 'Nuevo', 'Conocido'))  AS `Erc_TipoDx` , IF(`g_usuarioxprograma`.`I_NF_Fecha`IS NULL, '1900', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_Fecha`,'%Y') ) AS `Erc_AnoDx` , IF(`g_usuarioxprograma`.`I_NF_Fecha`IS NULL, '1', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_Fecha`,'%m') ) AS `Erc_MesDx` , `g_usuarioxprograma`.`ClasifRiesgoHTA`, `g_usuarioxprograma`.`I_CRiesgo`, `g_usuarioxprograma`.`I_Tipo_Diabetes`, `g_usuarioxprograma`.`I_Tipo_Insulina`     , ROUND(IF(`persona`.`IdSexo`='M',IF((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)) IS NULL, 0, (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))) ,IF(((((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85) IS NULL, 0,((((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85))     ),2) AS `TFG_Valor` , IF(ROUND(IF(`persona`.`IdSexo`='M',IF((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)) IS NULL, 0, (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))) ,IF(((((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)IS NULL, 0,((((140- ( ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85))),2)>0,DATE_FORMAT(g_usuarioxprograma.`I_FCreatinina`,'%d/%m/%Y'),'') AS `TFG_Fecha` , IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- ( ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)>0 AND ROUND(IF(`persona`.`IdSexo`='M',(((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)<=15,'Estadio V', IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`) /(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)>=15 AND ROUND(IF(`persona`.`IdSexo`='M', (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)<=29,'Estadio IV',  IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`) /(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)>=30 AND ROUND(IF(`persona`.`IdSexo`='M', (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)<=59,'Estadio III',  IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`) /(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)>=60 AND ROUND(IF(`persona`.`IdSexo`='M', (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`,`persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)<=89,'Estadio II', IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`) /(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)=0 OR ROUND(IF(`persona`.`IdSexo`='M', (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2) IS NULL ,'Sin dato','Estadio I' ))))) AS `TFG_Estadio`     , IF(`g_usuarioxprograma`.`I_NF_FProteinas24H` IS NULL ,'', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FProteinas24H`,'%d/%m/%Y')) AS `NFF_Proteinurio` ,  IF(`g_usuarioxprograma`.`I_NF_FOrina`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FOrina`,'%d/%m/%Y'))  AS `NFP_POrina` , IF(`g_usuarioxprograma`.`I_NF_FMicroAlbumina`IS NULL ,'', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FMicroAlbumina`,'%d/%m/%Y')) AS `NFF_Microalbumina` , IF(`g_usuarioxprograma`.`I_NF_FEcografiaR`IS NULL ,'', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FEcografiaR`,'%d/%m/%Y')) AS `NFF_Ecografia` , IF(`g_usuarioxprograma`.`I_NF_FRegresionE`IS NULL ,'', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FRegresionE`,'%d/%m/%Y')) AS `NFF_RegresionE` , `g_usuarioxprograma`.`I_NF_VMicroAlbumina` AS `NF_VMicroalbumina`, IF(`g_usuarioxprograma`.`Id_Programa`=1, 'DIABETES', 'HIPERTENSIÓN') AS `Programa_Pertence` , ROUND(`g_usuarioxprograma`.`Talla`) AS `I_Talla`, ROUND(`g_usuarioxprograma`.`Peso`) AS `I_Peso`, `g_usuarioxprograma`.`TASistolica`, `g_usuarioxprograma`.`TADiastolica` , ROUND(`g_usuarioxprograma`.`IMC`,2) AS `I_Imc`, `g_usuarioxprograma`.`PAbdominal`, `g_usuarioxprograma`.`I_VCreatinina` , IF(`g_usuarioxprograma`.`I_FCreatinina` IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FCreatinina`,'%d/%m/%Y')) AS `I_FCreatinina`,`g_usuarioxprograma`.`I_VMicroalbumina` , IF(`g_usuarioxprograma`.`I_FMicroalbumina` IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FMicroalbumina`,'%d/%m/%Y'))  AS `I_FMicroAlbumina`,`g_usuarioxprograma`.`I_VGlicemia` ,  IF(`g_usuarioxprograma`.`I_FGlicemia` IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FGlicemia`,'%d/%m/%Y'))  AS `I_FGlicemia`, `g_usuarioxprograma`.`I_VHGlicosilada` , IF(`g_usuarioxprograma`.`I_FHGlicosilada`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FHGlicosilada`,'%d/%m/%Y')) AS `I_FHGlicocilada`, `g_usuarioxprograma`.`I_VColesterolT` , IF(`g_usuarioxprograma`.`I_FColesterolT`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FColesterolT`,'%d/%m/%Y')) AS `I_FColesterolT`, `g_usuarioxprograma`.`I_VColesterolHdl` , IF(`g_usuarioxprograma`.`I_FColesterolHdl`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FColesterolHdl`,'%d/%m/%Y'))  AS `I_FColesterolHdl`, `g_usuarioxprograma`.`I_VColesterolLdl` , IF(`g_usuarioxprograma`.`I_FColesterolLdl`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FColesterolLdl`,'%d/%m/%Y')) AS `I_FColesterolLdl`, `g_usuarioxprograma`.`I_VTrigliceridos` , IF(`g_usuarioxprograma`.`I_FTrigliceridos`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FTrigliceridos`,'%d/%m/%Y'))  AS `I_FTrigliceridos`     , ROUND(IF(`persona`.`IdSexo`='M',IF((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)) IS NULL, 0, (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))) ,IF(((((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85) IS NULL, 0,((((140- (ROUND(DATEDIFF (g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85))),2) AS `I_TFG`     , IF(`g_usuarioxprograma`.`U_FechaControl` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`U_FechaControl`,'%d/%m/%Y') ) AS `FU_Control` , `g_usuarioxprograma`.`U_Diagnostico`  AS `U_Diagnosticos` , IF(`g_usuarioxprograma`.`U_Fecha_PControl` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`U_Fecha_PControl`,'%d/%m/%Y') )  AS `FP_Control` , `g_usuarioxprograma`.`CS_Inasistencia_Cant`, `g_usuarioxprograma`.`CS_Inasistencia_Causa`, `g_usuarioxprograma`.`CS_NConsultas_MG`, `g_usuarioxprograma`.`CS_NConsultas_MI` , `g_usuarioxprograma`.`CS_NConsultas_Sub`, `g_usuarioxprograma`.`CS_NConsultas_N`, `g_usuarioxprograma`.`CS_NConsultas_PS`, `g_usuarioxprograma`.`CS_NConsultas_Enf` , `g_usuarioxprograma`.`CS_NConsultas_N_Grupales`, `g_usuarioxprograma`.`CS_NConsultas_PS_Grupales`, `g_usuarioxprograma`.`U_CRiesgo_Hta`, `g_usuarioxprograma`.`U_CRiesgo` , `g_usuarioxprograma`.`U_TipoDiabetes`, `g_usuarioxprograma`.`U_TipoInsulina`, `g_usuarioxprograma`.`U_Estadio_NFP`, '' AS `86`, '' AS `87`, '' AS `88`, '' AS `89` , '' AS `90`, '' AS `91`, '' AS `92`, '' AS `93`, '' AS `94`, '' AS `95`, IF(`g_usuarioxprograma`.`NF_FPreDialisis` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`NF_FPreDialisis`,'%d/%m/%Y') ) AS `NF_Predialisis` , IF(`g_usuarioxprograma`.`NF_FDialisis` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`NF_FDialisis`,'%d/%m/%Y') )  AS `NF_Dialisis` , IF(`g_usuarioxprograma`.`NF_FTranspante` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`NF_FTranspante`,'%d/%m/%Y') )  AS `NF_Trasplante` , ROUND(`g_usuarioxprograma`.`U_Talla`) AS `U_Talla`, ROUND(`g_usuarioxprograma`.`U_Peso`) AS `U_Peso`, `g_usuarioxprograma`.`U_PSistolica`, `g_usuarioxprograma`.`U_PDiastolica` , ROUND(`g_usuarioxprograma`.`U_Imc`,2) AS `U_Imc`, `g_usuarioxprograma`.`U_PAbdominal`, `g_usuarioxprograma`.`CS_VCreatinina` , IF(`g_usuarioxprograma`.`CS_FCreatinina`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FCreatinina`,'%d/%m/%Y') ) AS `CS_FCreatinina`, `g_usuarioxprograma`.`CS_VMicroalbumina` , IF(`g_usuarioxprograma`.`CS_FMicroalbumina`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FMicroalbumina`,'%d/%m/%Y') ) AS `CS_FMicroalbumina`, `g_usuarioxprograma`.`CS_VGlicemia` , IF(`g_usuarioxprograma`.`CS_FGlicemia` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FGlicemia`,'%d/%m/%Y') )  AS `CS_FGlicemia`, `g_usuarioxprograma`.`CS_VHGlicosilada` , IF(`g_usuarioxprograma`.`CS_FHGlicosilada`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FHGlicosilada`,'%d/%m/%Y') )  AS `CS_FHGlicolada`, `g_usuarioxprograma`.`CS_VColesterolT` , IF(`g_usuarioxprograma`.`CS_FColesterolT`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FColesterolT`,'%d/%m/%Y') ) AS `CS_FColesterolT`, `g_usuarioxprograma`.`CS_VColesterolHdl` , IF(`g_usuarioxprograma`.`CS_FColesterolHdl`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FColesterolHdl`,'%d/%m/%Y') ) AS `CS_FColesterolHdl`, `g_usuarioxprograma`.`CS_VColesterolLdl` , IF(`g_usuarioxprograma`.`CS_FColesterolLdl`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FColesterolLdl`,'%d/%m/%Y') ) AS `CS_FColesterolLdl`, `g_usuarioxprograma`.`CS_VTrigliceridos` , IF(`g_usuarioxprograma`.`CS_FTrigliceridos` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FTrigliceridos`,'%d/%m/%Y') ) AS `CS_FTriglicerido`, '' AS `121`, '' AS `122` , ROUND(IF(`persona`.`IdSexo`='M',IF((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`CS_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`U_Peso`)/(g_usuarioxprograma.`CS_VCreatinina`*72))IS NULL, 0,  (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`CS_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`U_Peso`)/(g_usuarioxprograma.`CS_VCreatinina`*72))) ,IF(((((140- (ROUND(DATEDIFF (g_usuarioxprograma.`CS_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`U_Peso`)/(g_usuarioxprograma.`CS_VCreatinina`*72))*0.85) IS NULL, 0,((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`CS_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`U_Peso`)/(g_usuarioxprograma.`CS_VCreatinina`*72))*0.85))),2) AS `CS_UTFG`, '' AS `124`, '' AS `125`, '' AS `126`, '' AS `127`, '' AS `128` , IF(`g_usuarioxprograma`.`H_129` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_129`,'%d/%m/%Y') )  AS `H129` , IF(`g_usuarioxprograma`.`H_130`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_130`,'%d/%m/%Y') )  AS `H130` , IF(`g_usuarioxprograma`.`H_131`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_131`,'%d/%m/%Y') )  AS `H131` , IF(`g_usuarioxprograma`.`H_132`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_132`,'%d/%m/%Y') )  AS `H132` , IF(`g_usuarioxprograma`.`H_133`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_133`,'%d/%m/%Y') )  AS `H133` , IF(`g_usuarioxprograma`.`H_134`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_134`,'%d/%m/%Y') )  AS `H134`, `g_usuarioxprograma`.`C_135` AS `C135` , IF(`g_usuarioxprograma`.`C_136`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_136`,'%d/%m/%Y') )  AS `C136` , IF(`g_usuarioxprograma`.`C_137`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_137`,'%d/%m/%Y') )  AS `C137` , IF(`g_usuarioxprograma`.`C_138`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_138`,'%d/%m/%Y') )  AS `C138` , IF(`g_usuarioxprograma`.`C_139`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_139`,'%d/%m/%Y') )  AS `C139` , IF(`g_usuarioxprograma`.`C_140`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_140`,'%d/%m/%Y') )  AS `C140` , IF(`g_usuarioxprograma`.`C_141`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_141`,'%d/%m/%Y') )  AS `C141` , IF(`g_usuarioxprograma`.`C_142`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_142`,'%d/%m/%Y') )  AS `C142` , IF(`g_usuarioxprograma`.`C_143`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_143`,'%d/%m/%Y') )  AS `C143` , IF(`g_usuarioxprograma`.`C_144`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_144`,'%d/%m/%Y') )  AS `C144` , IF(`g_usuarioxprograma`.`C_145`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_145`,'%d/%m/%Y') ) AS `C145` , IF(`g_usuarioxprograma`.`C_146`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_146`,'%d/%m/%Y') )  AS `C146` , `g_usuarioxprograma`.`MtdoPlaniFliar`,g_usuarioxprograma.HtaEstadio ,g_usuarioxprograma.HtaDXAsociados, g_usuarioxprograma.ClasRiesgoCVascular,IF(g_usuarioxprograma.FechaHospitalizion IS NULL, '',g_usuarioxprograma.FechaHospitalizion) AS FechaHospitalizion, g_usuarioxprograma.DxHospitalizacion,g_usuarioxprograma.CS_VGlicemia,g_usuarioxprograma.CS_VHGlicosilada,g_usuarioxprograma.CS_VProteinuria, IF(g_usuarioxprograma.FechaIngreso IS NULL, '',g_usuarioxprograma.FechaIngreso) AS FIngreso ,`persona`.`EPS` , IF(`g_usuarioxprograma`.`CS_FRAlbuminaCreatinina`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`CS_FRAlbuminaCreatinina`,'%d/%m/%Y')) as CS_FRAlbuminaCreatinina, ifnull(g_usuarioxprograma.CS_VRAlbuminaCreatinina,'') CS_VRAlbuminaCreatinina , ifnull(g_usuarioxprograma.fechaVacunaInfluenza,'') fechaVacunaInfluenza , ifnull(g_usuarioxprograma.fechaVacunaNeumococo,'') fechaVacunaNeumococo  FROM  `d_ips`, `persona` INNER JOIN  `g_usuarioxprograma`    ON (`persona`.`Id_persona` = `g_usuarioxprograma`.`Id_Usuario`)WHERE (`g_usuarioxprograma`.`Id_Programa` ='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "' and  `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `g_usuarioxprograma`.`Estado` =0);";
            } else {
                this.xsql = "SELECT `d_ips`.`CodigoOrganismo`, `d_ips`.`CodMunicipio`, `d_ips`.`CodDepartamento`, `d_ips`.`NMunicipio`, `d_ips`.`NEmpresa` , IF(`g_usuarioxprograma`.`I_Fecha` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`I_Fecha`,'%d/%m/%Y')) AS `FIngresoP`, `persona`.`Apellido1`, `persona`.`Apellido2` , CONCAT(`persona`.`Nombre1`,' ' ,`persona`.`Nombre2`) AS `Nombre`, `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento` , IF(ROUND(DATEDIFF(`g_usuarioxprograma`.`I_Fecha`, `persona`.`FechaNac`)/365) IS NULL, '',ROUND(DATEDIFF(`g_usuarioxprograma`.`I_Fecha`, `persona`.`FechaNac`)/365) )  AS `Edad_Ingreso`, ROUND(DATEDIFF(NOW(), `persona`.`FechaNac`)/365) AS `Edad_Acutal` , `persona`.`IdSexo`, `persona`.`EstadoCivil`, `persona`.`Escolaridad`, `persona`.`Direccion`, `persona`.`Telefono`, `persona`.`Celular` , IF(`g_usuarioxprograma`.`EsDM_HTA`=1,'X','') AS `Es_Hta`, IF(`g_usuarioxprograma`.`Hta_TipoDx`=-1,'',IF(`g_usuarioxprograma`.`Hta_TipoDx`=0, 'Nuevo', 'Conocido')) AS `Hta_TipoDx` , IF(`g_usuarioxprograma`.`Hta_FechaDx`IS NULL, '1900', DATE_FORMAT(`g_usuarioxprograma`.`Hta_FechaDx`,'%Y') ) AS `Hta_AnoDx` , IF(`g_usuarioxprograma`.`Hta_FechaDx`IS NULL, '1', DATE_FORMAT(`g_usuarioxprograma`.`Hta_FechaDx`,'%m') ) AS `Hta_MesDx` , IF(`g_usuarioxprograma`.`Id_Programa`=1,'X','') AS `Es_Dm`, IF(`g_usuarioxprograma`.`I_TipoDx`=-1,'',IF(`g_usuarioxprograma`.`I_TipoDx`=0, 'Nuevo', 'Conocido')) AS `Dm_Tipo` , IF(`g_usuarioxprograma`.`I_FechaDx`IS NULL, '1900', DATE_FORMAT(`g_usuarioxprograma`.`I_FechaDx`,'%Y') ) AS `Dm_AnoDx` , IF(`g_usuarioxprograma`.`I_FechaDx`IS NULL, '1', DATE_FORMAT(`g_usuarioxprograma`.`I_FechaDx`,'%m') ) AS `Dm_MesDx` , IF(`g_usuarioxprograma`.`I_NF_Fecha` IS NULL, 'NO', 'SI') AS `ERC`, IF(`g_usuarioxprograma`.`I_NF_TipoDx`=-1,'',IF(`g_usuarioxprograma`.`I_NF_TipoDx`=0, 'Nuevo', 'Conocido'))  AS `Erc_TipoDx` , IF(`g_usuarioxprograma`.`I_NF_Fecha`IS NULL, '1900', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_Fecha`,'%Y') ) AS `Erc_AnoDx` , IF(`g_usuarioxprograma`.`I_NF_Fecha`IS NULL, '1', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_Fecha`,'%m') ) AS `Erc_MesDx` , `g_usuarioxprograma`.`ClasifRiesgoHTA`, `g_usuarioxprograma`.`I_CRiesgo`, `g_usuarioxprograma`.`I_Tipo_Diabetes`, `g_usuarioxprograma`.`I_Tipo_Insulina`     , ROUND(IF(`persona`.`IdSexo`='M',IF((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)) IS NULL, 0, (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))) ,IF(((((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85) IS NULL, 0,((((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85))     ),2) AS `TFG_Valor` , IF(ROUND(IF(`persona`.`IdSexo`='M',IF((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)) IS NULL, 0, (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))) ,IF(((((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)IS NULL, 0,((((140- ( ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85))),2)>0,DATE_FORMAT(g_usuarioxprograma.`I_FCreatinina`,'%d/%m/%Y'),'') AS `TFG_Fecha` , IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- ( ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)>0 AND ROUND(IF(`persona`.`IdSexo`='M',(((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)<=15,'Estadio V', IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`) /(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)>=15 AND ROUND(IF(`persona`.`IdSexo`='M', (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)<=29,'Estadio IV',  IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`) /(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)>=30 AND ROUND(IF(`persona`.`IdSexo`='M', (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)<=59,'Estadio III',  IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`) /(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)>=60 AND ROUND(IF(`persona`.`IdSexo`='M', (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`,`persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)<=89,'Estadio II', IF(ROUND(IF(`persona`.`IdSexo`='M',(((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`) /(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2)=0 OR ROUND(IF(`persona`.`IdSexo`='M', (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)),((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365))) *g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85)),2) IS NULL ,'Sin dato','Estadio I' ))))) AS `TFG_Estadio`     , IF(`g_usuarioxprograma`.`I_NF_FProteinas24H` IS NULL ,'', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FProteinas24H`,'%d/%m/%Y')) AS `NFF_Proteinurio` ,  IF(`g_usuarioxprograma`.`I_NF_FOrina`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FOrina`,'%d/%m/%Y'))  AS `NFP_POrina` , IF(`g_usuarioxprograma`.`I_NF_FMicroAlbumina`IS NULL ,'', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FMicroAlbumina`,'%d/%m/%Y')) AS `NFF_Microalbumina` , IF(`g_usuarioxprograma`.`I_NF_FEcografiaR`IS NULL ,'', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FEcografiaR`,'%d/%m/%Y')) AS `NFF_Ecografia` , IF(`g_usuarioxprograma`.`I_NF_FRegresionE`IS NULL ,'', DATE_FORMAT(`g_usuarioxprograma`.`I_NF_FRegresionE`,'%d/%m/%Y')) AS `NFF_RegresionE` , `g_usuarioxprograma`.`I_NF_VMicroAlbumina` AS `NF_VMicroalbumina`, IF(`g_usuarioxprograma`.`Id_Programa`=1, 'DIABETES', 'HIPERTENSIÓN') AS `Programa_Pertence` , ROUND(`g_usuarioxprograma`.`Talla`) AS `I_Talla`, ROUND(`g_usuarioxprograma`.`Peso`) AS `I_Peso`, `g_usuarioxprograma`.`TASistolica`, `g_usuarioxprograma`.`TADiastolica` , ROUND(`g_usuarioxprograma`.`IMC`,2) AS `I_Imc`, `g_usuarioxprograma`.`PAbdominal`, `g_usuarioxprograma`.`I_VCreatinina` , IF(`g_usuarioxprograma`.`I_FCreatinina` IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FCreatinina`,'%d/%m/%Y')) AS `I_FCreatinina`,`g_usuarioxprograma`.`I_VMicroalbumina` , IF(`g_usuarioxprograma`.`I_FMicroalbumina` IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FMicroalbumina`,'%d/%m/%Y'))  AS `I_FMicroAlbumina`,`g_usuarioxprograma`.`I_VGlicemia` ,  IF(`g_usuarioxprograma`.`I_FGlicemia` IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FGlicemia`,'%d/%m/%Y'))  AS `I_FGlicemia`, `g_usuarioxprograma`.`I_VHGlicosilada` , IF(`g_usuarioxprograma`.`I_FHGlicosilada`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FHGlicosilada`,'%d/%m/%Y')) AS `I_FHGlicocilada`, `g_usuarioxprograma`.`I_VColesterolT` , IF(`g_usuarioxprograma`.`I_FColesterolT`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FColesterolT`,'%d/%m/%Y')) AS `I_FColesterolT`, `g_usuarioxprograma`.`I_VColesterolHdl` , IF(`g_usuarioxprograma`.`I_FColesterolHdl`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FColesterolHdl`,'%d/%m/%Y'))  AS `I_FColesterolHdl`, `g_usuarioxprograma`.`I_VColesterolLdl` , IF(`g_usuarioxprograma`.`I_FColesterolLdl`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FColesterolLdl`,'%d/%m/%Y')) AS `I_FColesterolLdl`, `g_usuarioxprograma`.`I_VTrigliceridos` , IF(`g_usuarioxprograma`.`I_FTrigliceridos`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`I_FTrigliceridos`,'%d/%m/%Y'))  AS `I_FTrigliceridos`     , ROUND(IF(`persona`.`IdSexo`='M',IF((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72)) IS NULL, 0, (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))) ,IF(((((140-  (ROUND(DATEDIFF(g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85) IS NULL, 0,((((140- (ROUND(DATEDIFF (g_usuarioxprograma.`I_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`Peso`)/(g_usuarioxprograma.`I_VCreatinina`*72))*0.85))),2) AS `I_TFG`     , IF(`g_usuarioxprograma`.`U_FechaControl` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`U_FechaControl`,'%d/%m/%Y') ) AS `FU_Control` , `g_usuarioxprograma`.`U_Diagnostico`  AS `U_Diagnosticos` , IF(`g_usuarioxprograma`.`U_Fecha_PControl` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`U_Fecha_PControl`,'%d/%m/%Y') )  AS `FP_Control` , `g_usuarioxprograma`.`CS_Inasistencia_Cant`, `g_usuarioxprograma`.`CS_Inasistencia_Causa`, `g_usuarioxprograma`.`CS_NConsultas_MG`, `g_usuarioxprograma`.`CS_NConsultas_MI` , `g_usuarioxprograma`.`CS_NConsultas_Sub`, `g_usuarioxprograma`.`CS_NConsultas_N`, `g_usuarioxprograma`.`CS_NConsultas_PS`, `g_usuarioxprograma`.`CS_NConsultas_Enf` , `g_usuarioxprograma`.`CS_NConsultas_N_Grupales`, `g_usuarioxprograma`.`CS_NConsultas_PS_Grupales`, `g_usuarioxprograma`.`U_CRiesgo_Hta`, `g_usuarioxprograma`.`U_CRiesgo` , `g_usuarioxprograma`.`U_TipoDiabetes`, `g_usuarioxprograma`.`U_TipoInsulina`, `g_usuarioxprograma`.`U_Estadio_NFP`, '' AS `86`, '' AS `87`, '' AS `88`, '' AS `89` , '' AS `90`, '' AS `91`, '' AS `92`, '' AS `93`, '' AS `94`, '' AS `95`, IF(`g_usuarioxprograma`.`NF_FPreDialisis` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`NF_FPreDialisis`,'%d/%m/%Y') ) AS `NF_Predialisis` , IF(`g_usuarioxprograma`.`NF_FDialisis` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`NF_FDialisis`,'%d/%m/%Y') )  AS `NF_Dialisis` , IF(`g_usuarioxprograma`.`NF_FTranspante` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`NF_FTranspante`,'%d/%m/%Y') )  AS `NF_Trasplante` , ROUND(`g_usuarioxprograma`.`U_Talla`) AS `U_Talla`, ROUND(`g_usuarioxprograma`.`U_Peso`) AS `U_Peso`, `g_usuarioxprograma`.`U_PSistolica`, `g_usuarioxprograma`.`U_PDiastolica` , ROUND(`g_usuarioxprograma`.`U_Imc`,2) AS `U_Imc`, `g_usuarioxprograma`.`U_PAbdominal`, `g_usuarioxprograma`.`CS_VCreatinina` , IF(`g_usuarioxprograma`.`CS_FCreatinina`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FCreatinina`,'%d/%m/%Y') ) AS `CS_FCreatinina`, `g_usuarioxprograma`.`CS_VMicroalbumina` , IF(`g_usuarioxprograma`.`CS_FMicroalbumina`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FMicroalbumina`,'%d/%m/%Y') ) AS `CS_FMicroalbumina`, `g_usuarioxprograma`.`CS_VGlicemia` , IF(`g_usuarioxprograma`.`CS_FGlicemia` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FGlicemia`,'%d/%m/%Y') )  AS `CS_FGlicemia`, `g_usuarioxprograma`.`CS_VHGlicosilada` , IF(`g_usuarioxprograma`.`CS_FHGlicosilada`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FHGlicosilada`,'%d/%m/%Y') )  AS `CS_FHGlicolada`, `g_usuarioxprograma`.`CS_VColesterolT` , IF(`g_usuarioxprograma`.`CS_FColesterolT`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FColesterolT`,'%d/%m/%Y') ) AS `CS_FColesterolT`, `g_usuarioxprograma`.`CS_VColesterolHdl` , IF(`g_usuarioxprograma`.`CS_FColesterolHdl`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FColesterolHdl`,'%d/%m/%Y') ) AS `CS_FColesterolHdl`, `g_usuarioxprograma`.`CS_VColesterolLdl` , IF(`g_usuarioxprograma`.`CS_FColesterolLdl`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FColesterolLdl`,'%d/%m/%Y') ) AS `CS_FColesterolLdl`, `g_usuarioxprograma`.`CS_VTrigliceridos` , IF(`g_usuarioxprograma`.`CS_FTrigliceridos` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`CS_FTrigliceridos`,'%d/%m/%Y') ) AS `CS_FTriglicerido`, '' AS `121`, '' AS `122` , ROUND(IF(`persona`.`IdSexo`='M',IF((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`CS_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`U_Peso`)/(g_usuarioxprograma.`CS_VCreatinina`*72))IS NULL, 0,  (((140- (ROUND(DATEDIFF(g_usuarioxprograma.`CS_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`U_Peso`)/(g_usuarioxprograma.`CS_VCreatinina`*72))) ,IF(((((140- (ROUND(DATEDIFF (g_usuarioxprograma.`CS_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`U_Peso`)/(g_usuarioxprograma.`CS_VCreatinina`*72))*0.85) IS NULL, 0,((((140- (ROUND(DATEDIFF(g_usuarioxprograma.`CS_FCreatinina`, `persona`.`FechaNac`)/365)))*g_usuarioxprograma.`U_Peso`)/(g_usuarioxprograma.`CS_VCreatinina`*72))*0.85))),2) AS `CS_UTFG`, '' AS `124`, '' AS `125`, '' AS `126`, '' AS `127`, '' AS `128` , IF(`g_usuarioxprograma`.`H_129` IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_129`,'%d/%m/%Y') )  AS `H129` , IF(`g_usuarioxprograma`.`H_130`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_130`,'%d/%m/%Y') )  AS `H130` , IF(`g_usuarioxprograma`.`H_131`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_131`,'%d/%m/%Y') )  AS `H131` , IF(`g_usuarioxprograma`.`H_132`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_132`,'%d/%m/%Y') )  AS `H132` , IF(`g_usuarioxprograma`.`H_133`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_133`,'%d/%m/%Y') )  AS `H133` , IF(`g_usuarioxprograma`.`H_134`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`H_134`,'%d/%m/%Y') )  AS `H134`, `g_usuarioxprograma`.`C_135` AS `C135` , IF(`g_usuarioxprograma`.`C_136`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_136`,'%d/%m/%Y') )  AS `C136` , IF(`g_usuarioxprograma`.`C_137`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_137`,'%d/%m/%Y') )  AS `C137` , IF(`g_usuarioxprograma`.`C_138`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_138`,'%d/%m/%Y') )  AS `C138` , IF(`g_usuarioxprograma`.`C_139`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_139`,'%d/%m/%Y') )  AS `C139` , IF(`g_usuarioxprograma`.`C_140`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_140`,'%d/%m/%Y') )  AS `C140` , IF(`g_usuarioxprograma`.`C_141`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_141`,'%d/%m/%Y') )  AS `C141` , IF(`g_usuarioxprograma`.`C_142`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_142`,'%d/%m/%Y') )  AS `C142` , IF(`g_usuarioxprograma`.`C_143`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_143`,'%d/%m/%Y') )  AS `C143` , IF(`g_usuarioxprograma`.`C_144`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_144`,'%d/%m/%Y') )  AS `C144` , IF(`g_usuarioxprograma`.`C_145`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_145`,'%d/%m/%Y') ) AS `C145` , IF(`g_usuarioxprograma`.`C_146`IS NULL,'',DATE_FORMAT(`g_usuarioxprograma`.`C_146`,'%d/%m/%Y') )  AS `C146` , `g_usuarioxprograma`.`MtdoPlaniFliar`, g_usuarioxprograma.HtaEstadio,g_usuarioxprograma.HtaDXAsociados, g_usuarioxprograma.ClasRiesgoCVascular,IF(g_usuarioxprograma.FechaHospitalizion IS NULL, '',g_usuarioxprograma.FechaHospitalizion) AS FechaHospitalizion, g_usuarioxprograma.DxHospitalizacion,g_usuarioxprograma.CS_VGlicemia,g_usuarioxprograma.CS_VHGlicosilada,g_usuarioxprograma.CS_VProteinuria,IF(g_usuarioxprograma.FechaIngreso IS NULL, '',g_usuarioxprograma.FechaIngreso) AS FIngreso, `persona`.`EPS`, IF(`g_usuarioxprograma`.`CS_FRAlbuminaCreatinina`IS NULL, '', DATE_FORMAT(`g_usuarioxprograma`.`CS_FRAlbuminaCreatinina`,'%d/%m/%Y')) as CS_FRAlbuminaCreatinina, ifnull(g_usuarioxprograma.CS_VRAlbuminaCreatinina,'') CS_VRAlbuminaCreatinina , ifnull(g_usuarioxprograma.fechaVacunaInfluenza,'') fechaVacunaInfluenza , ifnull(g_usuarioxprograma.fechaVacunaNeumococo,'') fechaVacunaNeumococo  FROM  `d_ips`, `persona` INNER JOIN  `g_usuarioxprograma`    ON (`persona`.`Id_persona` = `g_usuarioxprograma`.`Id_Usuario`)WHERE (`g_usuarioxprograma`.`Id_Programa` ='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "' AND `g_usuarioxprograma`.`Estado` =0);";
            }
            this.jTextArea1.setText(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
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
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelo.setValueAt(xrs.getString(23), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelo.setValueAt(xrs.getString(26), n, 25);
                    this.xmodelo.setValueAt(xrs.getString(27), n, 26);
                    this.xmodelo.setValueAt(xrs.getString(28), n, 27);
                    this.xmodelo.setValueAt(xrs.getString(29), n, 28);
                    this.xmodelo.setValueAt(xrs.getString(30), n, 29);
                    this.xmodelo.setValueAt(xrs.getString(31), n, 30);
                    this.xmodelo.setValueAt(xrs.getString(32), n, 31);
                    this.xmodelo.setValueAt(xrs.getString(33), n, 32);
                    this.xmodelo.setValueAt(xrs.getString(34), n, 33);
                    this.xmodelo.setValueAt(xrs.getString(35), n, 34);
                    this.xmodelo.setValueAt(xrs.getString(36), n, 35);
                    this.xmodelo.setValueAt(xrs.getString(37), n, 36);
                    this.xmodelo.setValueAt(xrs.getString(38), n, 37);
                    this.xmodelo.setValueAt(xrs.getString(39), n, 38);
                    this.xmodelo.setValueAt(xrs.getString(40), n, 39);
                    this.xmodelo.setValueAt(xrs.getString(41), n, 40);
                    this.xmodelo.setValueAt(xrs.getString(42), n, 41);
                    this.xmodelo.setValueAt(xrs.getString(43), n, 42);
                    this.xmodelo.setValueAt(xrs.getString(44), n, 43);
                    this.xmodelo.setValueAt(xrs.getString(45), n, 44);
                    this.xmodelo.setValueAt(xrs.getString(46), n, 45);
                    this.xmodelo.setValueAt(xrs.getString(47), n, 46);
                    this.xmodelo.setValueAt(xrs.getString(48), n, 47);
                    this.xmodelo.setValueAt(xrs.getString(49), n, 48);
                    this.xmodelo.setValueAt(xrs.getString(50), n, 49);
                    this.xmodelo.setValueAt(xrs.getString(51), n, 50);
                    this.xmodelo.setValueAt(xrs.getString(52), n, 51);
                    this.xmodelo.setValueAt(xrs.getString(53), n, 52);
                    this.xmodelo.setValueAt(xrs.getString(54), n, 53);
                    this.xmodelo.setValueAt(xrs.getString(55), n, 54);
                    this.xmodelo.setValueAt(xrs.getString(56), n, 55);
                    this.xmodelo.setValueAt(xrs.getString(57), n, 56);
                    this.xmodelo.setValueAt(xrs.getString(58), n, 57);
                    this.xmodelo.setValueAt(xrs.getString(59), n, 58);
                    this.xmodelo.setValueAt(xrs.getString(60), n, 59);
                    this.xmodelo.setValueAt(xrs.getString(61), n, 60);
                    this.xmodelo.setValueAt(xrs.getString(62), n, 61);
                    this.xmodelo.setValueAt(xrs.getString(63), n, 62);
                    this.xmodelo.setValueAt(xrs.getString(64), n, 63);
                    this.xmodelo.setValueAt(xrs.getString(65), n, 64);
                    this.xmodelo.setValueAt(xrs.getString(66), n, 65);
                    this.xmodelo.setValueAt(xrs.getString(67), n, 66);
                    this.xmodelo.setValueAt(xrs.getString(68), n, 67);
                    this.xmodelo.setValueAt(xrs.getString(69), n, 68);
                    this.xmodelo.setValueAt(xrs.getString(70), n, 69);
                    this.xmodelo.setValueAt(xrs.getString(71), n, 70);
                    this.xmodelo.setValueAt(xrs.getString(72), n, 71);
                    this.xmodelo.setValueAt(xrs.getString(73), n, 72);
                    this.xmodelo.setValueAt(xrs.getString(74), n, 73);
                    this.xmodelo.setValueAt(xrs.getString(75), n, 74);
                    this.xmodelo.setValueAt(xrs.getString(76), n, 75);
                    this.xmodelo.setValueAt(xrs.getString(77), n, 76);
                    this.xmodelo.setValueAt(xrs.getString(78), n, 77);
                    this.xmodelo.setValueAt(xrs.getString(78), n, 78);
                    this.xmodelo.setValueAt(xrs.getString(80), n, 79);
                    this.xmodelo.setValueAt(xrs.getString(81), n, 80);
                    this.xmodelo.setValueAt(xrs.getString(82), n, 81);
                    this.xmodelo.setValueAt(xrs.getString(83), n, 82);
                    this.xmodelo.setValueAt(xrs.getString(84), n, 83);
                    this.xmodelo.setValueAt(xrs.getString(85), n, 84);
                    this.xmodelo.setValueAt(xrs.getString(86), n, 85);
                    this.xmodelo.setValueAt(xrs.getString(87), n, 86);
                    this.xmodelo.setValueAt(xrs.getString(88), n, 87);
                    this.xmodelo.setValueAt(xrs.getString(89), n, 88);
                    this.xmodelo.setValueAt(xrs.getString(90), n, 89);
                    this.xmodelo.setValueAt(xrs.getString(91), n, 90);
                    this.xmodelo.setValueAt(xrs.getString(92), n, 91);
                    this.xmodelo.setValueAt(xrs.getString(93), n, 92);
                    this.xmodelo.setValueAt(xrs.getString(94), n, 93);
                    this.xmodelo.setValueAt(xrs.getString(95), n, 94);
                    this.xmodelo.setValueAt(xrs.getString(96), n, 95);
                    this.xmodelo.setValueAt(xrs.getString(97), n, 96);
                    this.xmodelo.setValueAt(xrs.getString(98), n, 97);
                    this.xmodelo.setValueAt(xrs.getString(99), n, 98);
                    this.xmodelo.setValueAt(xrs.getString(100), n, 99);
                    this.xmodelo.setValueAt(xrs.getString(101), n, 100);
                    this.xmodelo.setValueAt(xrs.getString(102), n, 101);
                    this.xmodelo.setValueAt(xrs.getString(103), n, 102);
                    this.xmodelo.setValueAt(xrs.getString(104), n, 103);
                    this.xmodelo.setValueAt(xrs.getString(105), n, 104);
                    this.xmodelo.setValueAt(xrs.getString(106), n, 105);
                    this.xmodelo.setValueAt(xrs.getString(107), n, 106);
                    this.xmodelo.setValueAt(xrs.getString(108), n, 107);
                    this.xmodelo.setValueAt(xrs.getString(109), n, 108);
                    this.xmodelo.setValueAt(xrs.getString(110), n, 109);
                    this.xmodelo.setValueAt(xrs.getString(111), n, 110);
                    this.xmodelo.setValueAt(xrs.getString(112), n, 111);
                    this.xmodelo.setValueAt(xrs.getString(113), n, 112);
                    this.xmodelo.setValueAt(xrs.getString(114), n, 113);
                    this.xmodelo.setValueAt(xrs.getString(115), n, 114);
                    this.xmodelo.setValueAt(xrs.getString(116), n, 115);
                    this.xmodelo.setValueAt(xrs.getString(117), n, 116);
                    this.xmodelo.setValueAt(xrs.getString(118), n, 117);
                    this.xmodelo.setValueAt(xrs.getString(119), n, 118);
                    this.xmodelo.setValueAt(xrs.getString(120), n, 119);
                    this.xmodelo.setValueAt(xrs.getString(121), n, 120);
                    this.xmodelo.setValueAt(xrs.getString(122), n, 121);
                    this.xmodelo.setValueAt(xrs.getString(123), n, 122);
                    this.xmodelo.setValueAt(xrs.getString(124), n, 123);
                    this.xmodelo.setValueAt(xrs.getString(125), n, 124);
                    this.xmodelo.setValueAt(xrs.getString(126), n, 125);
                    this.xmodelo.setValueAt(xrs.getString(127), n, 126);
                    this.xmodelo.setValueAt(xrs.getString(128), n, 127);
                    this.xmodelo.setValueAt(xrs.getString(129), n, 128);
                    this.xmodelo.setValueAt(xrs.getString(130), n, 129);
                    this.xmodelo.setValueAt(xrs.getString(131), n, 130);
                    this.xmodelo.setValueAt(xrs.getString(132), n, 131);
                    this.xmodelo.setValueAt(xrs.getString(133), n, 132);
                    this.xmodelo.setValueAt(xrs.getString(134), n, 133);
                    this.xmodelo.setValueAt(xrs.getString(135), n, 134);
                    this.xmodelo.setValueAt(xrs.getString(136), n, 135);
                    this.xmodelo.setValueAt(xrs.getString(137), n, 136);
                    this.xmodelo.setValueAt(xrs.getString(138), n, 137);
                    this.xmodelo.setValueAt(xrs.getString(139), n, 138);
                    this.xmodelo.setValueAt(xrs.getString(140), n, 139);
                    this.xmodelo.setValueAt(xrs.getString(141), n, 140);
                    this.xmodelo.setValueAt(xrs.getString(142), n, 141);
                    this.xmodelo.setValueAt(xrs.getString(143), n, 142);
                    this.xmodelo.setValueAt(xrs.getString(144), n, 143);
                    this.xmodelo.setValueAt(xrs.getString(145), n, 144);
                    this.xmodelo.setValueAt(xrs.getString(146), n, 145);
                    this.xmodelo.setValueAt(xrs.getString(147), n, 146);
                    this.xmodelo.setValueAt(xrs.getString(148), n, 147);
                    this.xmodelo.setValueAt(xrs.getString(149), n, 148);
                    this.xmodelo.setValueAt(xrs.getString(150), n, 149);
                    this.xmodelo.setValueAt(xrs.getString(151), n, 150);
                    this.xmodelo.setValueAt(xrs.getString(152), n, 151);
                    this.xmodelo.setValueAt(xrs.getString(153), n, 152);
                    this.xmodelo.setValueAt(xrs.getString(154), n, 153);
                    this.xmodelo.setValueAt(xrs.getString(155), n, 154);
                    this.xmodelo.setValueAt(xrs.getString(156), n, 155);
                    this.xmodelo.setValueAt(xrs.getString("FIngreso"), n, 156);
                    this.xmodelo.setValueAt(xrs.getString("EPS"), n, 157);
                    this.xmodelo.setValueAt(xrs.getString("CS_FRAlbuminaCreatinina"), n, 158);
                    this.xmodelo.setValueAt(xrs.getString("CS_VRAlbuminaCreatinina"), n, 159);
                    this.xmodelo.setValueAt(xrs.getString("fechaVacunaInfluenza"), n, 160);
                    this.xmodelo.setValueAt(xrs.getString("fechaVacunaNeumococo"), n, 161);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_FB() {
        try {
            mCrearTablaDetallePyP_FB();
            if (this.JCHFiltroEps.isSelected()) {
                this.xsql = "SELECT `d_ips`.`NEmpresa` AS `NIps`, `persona`.`Nombre1`, `persona`.`Nombre2`, `persona`.`Apellido1`, `persona`.`Apellido2`, `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento`, `persona`.`NSexo`, `persona`.`Escolaridad`, `persona`.`FechaNac` AS `FechaNac`, ROUND(DATEDIFF(NOW(), `persona`.`FechaNac`)/365) AS `Edad_Acutal`, `persona`.`NEtnia`  , 'No Aplica' AS `GPEspeciales`, g_usuarioxprograma.Ocupacion , `persona`.`Direccion`, IF(`persona`.`Zona`='U', 'Urbana', 'Rural') AS `Zona`, `persona`.`Telefono`, `persona`.`Corre` AS `Email`, '' AS `Medico`, 'IPS' AS `VIngreso`, IF(`g_usuarioxprograma`.`EsIngreso`=0,'No', 'Si') AS `ESIngreso`,IF(g_usuarioxprograma.FechaIngreso IS NULL, '',g_usuarioxprograma.FechaIngreso) AS FIngreso , ROUND(`g_usuarioxprograma`.`Peso`) AS `I_Peso`, ROUND(`g_usuarioxprograma`.`Talla`) AS `I_Talla` , `g_usuarioxprograma`.`IMC` AS `I_Imc`, IF(`g_usuarioxprograma`.`I_FechaDx` IS NULL,'',`g_usuarioxprograma`.`I_FechaDx`) AS `I_FechaDx`, g_usuarioxprograma.HtaEstadio ,g_usuarioxprograma.HtaDXAsociados, `g_usuarioxprograma`.`I_CActividadFisica` AS `Actividad_Fisica`, `g_usuarioxprograma`.`I_CAlcohol` AS `CAlcohol`, `g_usuarioxprograma`.`I_CTabaco_Clasificacion` AS `CTabaquismo`, `g_usuarioxprograma`.`I_CNutricional` AS `CNutricional`, `g_usuarioxprograma`.`I_CAntecedenteFC` AS `CEnfermedadC`, `g_usuarioxprograma`.`I_VCreatinina` AS `VCreatinina` , IF(`g_usuarioxprograma`.`U_FechaControl` IS NULL,'',`g_usuarioxprograma`.`U_FechaControl` ) AS `FU_Control`, `g_usuarioxprograma`.U_Diagnostico, ROUND(`g_usuarioxprograma`.`U_Peso`) AS `U_Peso`, ROUND(`g_usuarioxprograma`.`U_Imc`,2) AS `U_Imc`, `g_usuarioxprograma`.`U_PSistolica` , `g_usuarioxprograma`.`U_PDiastolica`, `g_usuarioxprograma`.`CS_VColesterolT`,IF(`g_usuarioxprograma`.CS_FColesterolT IS NULL,'',`g_usuarioxprograma`.CS_FColesterolT) AS CS_FColesterolT, `g_usuarioxprograma`.`CS_VColesterolHdl`,IF(g_usuarioxprograma.CS_FColesterolHdl IS NULL,'',g_usuarioxprograma.CS_FColesterolHdl) AS CS_FColesterolHdl  , `g_usuarioxprograma`.`CS_VColesterolLdl`, IF(g_usuarioxprograma.CS_FColesterolLdl IS NULL,'',g_usuarioxprograma.CS_FColesterolLdl) AS CS_FColesterolLdl, g_usuarioxprograma.CS_VTrigliceridos,IF(g_usuarioxprograma.CS_FTrigliceridos IS NULL,'', g_usuarioxprograma.CS_FTrigliceridos) AS CS_FTrigliceridos, `g_usuarioxprograma`.`CS_VMicroalbumina`, `g_usuarioxprograma`.`CS_VCreatinina`,IF(g_usuarioxprograma.CS_FCreatinina IS NULL,'',g_usuarioxprograma.CS_FCreatinina) AS FecUltimaCreatinina, g_usuarioxprograma.CS_VProteinuria, IF(g_usuarioxprograma.CS_FProteinuria IS NULL,'',g_usuarioxprograma.CS_FProteinuria) AS CS_FProteinuria ,`g_usuarioxprograma`.`O_PRealizado`, IF(`g_usuarioxprograma`.`O_Fecha_PR`IS NULL,'',`g_usuarioxprograma`.`O_Fecha_PR` )  AS o_Fecha_P , `g_usuarioxprograma`.`O_RMedicamentos`, `g_usuarioxprograma`.`O_Cual_Medicamento`, `g_usuarioxprograma`.`I_CPanifica`, IF(`g_usuarioxprograma`.`U_Fecha_PControl` IS NULL,'',`g_usuarioxprograma`.`U_Fecha_PControl` )  AS `FP_Control`, IF(g_usuarioxprograma.FechaHospitalizion IS NULL, '',g_usuarioxprograma.FechaHospitalizion) AS FechaHospitalizion, g_usuarioxprograma.DxHospitalizacion  , `persona`.`EPS`,g_usuarioxprograma.`Id_Usuario` AS IdUsuarioPersona, (SELECT IF(MAX(`h_atencion`.`Fecha_Atencion`) IS NULL,'',MAX(`h_atencion`.`Fecha_Atencion`)) FROM `h_atencion` INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `g_usuarioxprograma` ON (`ingreso`.`Id_Usuario` = `g_usuarioxprograma`.`Id_Usuario`)\nWHERE (`h_atencion`.`Id_Especialidad` =410 AND g_usuarioxprograma.`Id_Usuario`=IdUsuarioPersona)) AS FechaNefrologia,IF(g_usuarioxprograma.CS_FHGlicosilada IS NULL,'',CS_FHGlicosilada) AS FecUltimaHGlicosilada, g_usuarioxprograma.CS_VHGlicosilada AS ValorUltimaHGlicosilada,IF(g_usuarioxprograma.CS_FMicroalbumina IS NULL ,'',g_usuarioxprograma.CS_FMicroalbumina) AS FecUltimaMicroalbumina, g_usuarioxprograma.CS_VGlicemia, IF(g_usuarioxprograma.CS_FGlicemia IS NULL, '',g_usuarioxprograma.CS_FGlicemia ) AS CS_FGlicemia  FROM `d_ips`,  `persona` INNER JOIN  `g_usuarioxprograma`  ON (`persona`.`Id_persona` = `g_usuarioxprograma`.`Id_Usuario`) WHERE (`g_usuarioxprograma`.`Id_Programa` ='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "' and  `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `g_usuarioxprograma`.`Estado` =0) GROUP BY `FechaNac` ";
                System.out.println("Se_ejecuto_primero");
            } else {
                this.xsql = "SELECT `d_ips`.`NEmpresa` AS `NIps`, `persona`.`Nombre1`, `persona`.`Nombre2`, `persona`.`Apellido1`, `persona`.`Apellido2`, `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento`, `persona`.`NSexo`, `persona`.`Escolaridad`, `persona`.`FechaNac` AS `FechaNac`, ROUND(DATEDIFF(NOW(), `persona`.`FechaNac`)/365) AS `Edad_Acutal`, `persona`.`NEtnia`  , 'No Aplica' AS `GPEspeciales`, g_usuarioxprograma.Ocupacion , `persona`.`Direccion`, IF(`persona`.`Zona`='U', 'Urbana', 'Rural') AS `Zona`, `persona`.`Telefono`, `persona`.`Corre` AS `Email`, '' AS `Medico`, 'IPS' AS `VIngreso`, IF(`g_usuarioxprograma`.`EsIngreso`=0,'No', 'Si') AS `ESIngreso`,IF(g_usuarioxprograma.FechaIngreso IS NULL, '',g_usuarioxprograma.FechaIngreso) AS FIngreso , ROUND(`g_usuarioxprograma`.`Peso`) AS `I_Peso`, ROUND(`g_usuarioxprograma`.`Talla`) AS `I_Talla` , `g_usuarioxprograma`.`IMC` AS `I_Imc`, IF(`g_usuarioxprograma`.`I_FechaDx` IS NULL,'',`g_usuarioxprograma`.`I_FechaDx`) AS `I_FechaDx`, g_usuarioxprograma.HtaEstadio ,g_usuarioxprograma.HtaDXAsociados, `g_usuarioxprograma`.`I_CActividadFisica` AS `Actividad_Fisica`, `g_usuarioxprograma`.`I_CAlcohol` AS `CAlcohol`, `g_usuarioxprograma`.`I_CTabaco_Clasificacion` AS `CTabaquismo`, `g_usuarioxprograma`.`I_CNutricional` AS `CNutricional`, `g_usuarioxprograma`.`I_CAntecedenteFC` AS `CEnfermedadC`, `g_usuarioxprograma`.`I_VCreatinina` AS `VCreatinina` , IF(`g_usuarioxprograma`.`U_FechaControl` IS NULL,'',`g_usuarioxprograma`.`U_FechaControl` ) AS `FU_Control`, `g_usuarioxprograma`.U_Diagnostico, ROUND(`g_usuarioxprograma`.`U_Peso`) AS `U_Peso`, ROUND(`g_usuarioxprograma`.`U_Imc`,2) AS `U_Imc`, `g_usuarioxprograma`.`U_PSistolica` , `g_usuarioxprograma`.`U_PDiastolica`, `g_usuarioxprograma`.`CS_VColesterolT`,IF(`g_usuarioxprograma`.CS_FColesterolT IS NULL,'',`g_usuarioxprograma`.CS_FColesterolT) AS CS_FColesterolT, `g_usuarioxprograma`.`CS_VColesterolHdl`,IF(g_usuarioxprograma.CS_FColesterolHdl IS NULL,'',g_usuarioxprograma.CS_FColesterolHdl) AS CS_FColesterolHdl  , `g_usuarioxprograma`.`CS_VColesterolLdl`, IF(g_usuarioxprograma.CS_FColesterolLdl IS NULL,'',g_usuarioxprograma.CS_FColesterolLdl) AS CS_FColesterolLdl, g_usuarioxprograma.CS_VTrigliceridos,IF(g_usuarioxprograma.CS_FTrigliceridos IS NULL,'', g_usuarioxprograma.CS_FTrigliceridos) AS CS_FTrigliceridos, `g_usuarioxprograma`.`CS_VMicroalbumina`, `g_usuarioxprograma`.`CS_VCreatinina`,IF(g_usuarioxprograma.CS_FCreatinina IS NULL,'',g_usuarioxprograma.CS_FCreatinina) AS FecUltimaCreatinina, g_usuarioxprograma.CS_VProteinuria, IF(g_usuarioxprograma.CS_FProteinuria IS NULL,'',g_usuarioxprograma.CS_FProteinuria) AS CS_FProteinuria ,`g_usuarioxprograma`.`O_PRealizado`, IF(`g_usuarioxprograma`.`O_Fecha_PR`IS NULL,'',`g_usuarioxprograma`.`O_Fecha_PR` )  AS o_Fecha_P , `g_usuarioxprograma`.`O_RMedicamentos`, `g_usuarioxprograma`.`O_Cual_Medicamento`, `g_usuarioxprograma`.`I_CPanifica`, IF(`g_usuarioxprograma`.`U_Fecha_PControl` IS NULL,'',`g_usuarioxprograma`.`U_Fecha_PControl` )  AS `FP_Control`, IF(g_usuarioxprograma.FechaHospitalizion IS NULL, '',g_usuarioxprograma.FechaHospitalizion) AS FechaHospitalizion, g_usuarioxprograma.DxHospitalizacion  , `persona`.`EPS`,g_usuarioxprograma.`Id_Usuario` AS IdUsuarioPersona, (SELECT IF(MAX(`h_atencion`.`Fecha_Atencion`) IS NULL,'',MAX(`h_atencion`.`Fecha_Atencion`)) FROM `h_atencion` INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `g_usuarioxprograma` ON (`ingreso`.`Id_Usuario` = `g_usuarioxprograma`.`Id_Usuario`)\nWHERE (`h_atencion`.`Id_Especialidad` =410 AND g_usuarioxprograma.`Id_Usuario`=IdUsuarioPersona)) AS FechaNefrologia,IF(g_usuarioxprograma.CS_FHGlicosilada IS NULL,'',CS_FHGlicosilada) AS FecUltimaHGlicosilada, g_usuarioxprograma.CS_VHGlicosilada AS ValorUltimaHGlicosilada,IF(g_usuarioxprograma.CS_FMicroalbumina IS NULL ,'',g_usuarioxprograma.CS_FMicroalbumina) AS FecUltimaMicroalbumina, g_usuarioxprograma.CS_VGlicemia, IF(g_usuarioxprograma.CS_FGlicemia IS NULL, '',g_usuarioxprograma.CS_FGlicemia ) AS CS_FGlicemia  FROM `d_ips`,  `persona` INNER JOIN  `g_usuarioxprograma`  ON (`persona`.`Id_persona` = `g_usuarioxprograma`.`Id_Usuario`)  WHERE (`g_usuarioxprograma`.`Id_Programa` ='" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "' AND `g_usuarioxprograma`.`Estado` =0) GROUP BY `FechaNac` ";
            }
            this.jTextArea1.setText(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
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
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelo.setValueAt(xrs.getString(23), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelo.setValueAt(xrs.getString(26), n, 28);
                    this.xmodelo.setValueAt(xrs.getString(30), n, 29);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 25);
                    this.xmodelo.setValueAt(xrs.getString(27), n, 26);
                    this.xmodelo.setValueAt(xrs.getString(28), n, 27);
                    this.xmodelo.setValueAt(xrs.getString(29), n, 28);
                    this.xmodelo.setValueAt(xrs.getString(30), n, 29);
                    this.xmodelo.setValueAt(xrs.getString(31), n, 30);
                    this.xmodelo.setValueAt(xrs.getString(32), n, 31);
                    this.xmodelo.setValueAt(xrs.getString(33), n, 32);
                    this.xmodelo.setValueAt(xrs.getString(34), n, 33);
                    this.xmodelo.setValueAt(xrs.getString(35), n, 34);
                    this.xmodelo.setValueAt(xrs.getString(36), n, 35);
                    this.xmodelo.setValueAt(xrs.getString(37), n, 36);
                    this.xmodelo.setValueAt(xrs.getString(38), n, 37);
                    this.xmodelo.setValueAt(xrs.getString(39), n, 38);
                    this.xmodelo.setValueAt(xrs.getString(40), n, 39);
                    this.xmodelo.setValueAt(xrs.getString(41), n, 40);
                    this.xmodelo.setValueAt(xrs.getString(42), n, 41);
                    this.xmodelo.setValueAt(xrs.getString(43), n, 42);
                    this.xmodelo.setValueAt(xrs.getString(44), n, 43);
                    this.xmodelo.setValueAt(xrs.getString(45), n, 44);
                    this.xmodelo.setValueAt(xrs.getString(46), n, 45);
                    this.xmodelo.setValueAt(xrs.getString(47), n, 46);
                    this.xmodelo.setValueAt(xrs.getString(48), n, 47);
                    this.xmodelo.setValueAt(xrs.getString(49), n, 48);
                    this.xmodelo.setValueAt(xrs.getString(50), n, 49);
                    this.xmodelo.setValueAt(xrs.getString(51), n, 50);
                    this.xmodelo.setValueAt(xrs.getString(52), n, 51);
                    this.xmodelo.setValueAt(xrs.getString(53), n, 52);
                    this.xmodelo.setValueAt(xrs.getString(54), n, 53);
                    this.xmodelo.setValueAt(xrs.getString(55), n, 54);
                    this.xmodelo.setValueAt(xrs.getString(56), n, 55);
                    this.xmodelo.setValueAt(xrs.getString(57), n, 56);
                    this.xmodelo.setValueAt(xrs.getString(58), n, 57);
                    this.xmodelo.setValueAt(xrs.getString(59), n, 58);
                    this.xmodelo.setValueAt(xrs.getString(60), n, 59);
                    this.xmodelo.setValueAt(xrs.getString(61), n, 60);
                    this.xmodelo.setValueAt(xrs.getString(62), n, 61);
                    this.xmodelo.setValueAt(xrs.getString(63), n, 62);
                    this.xmodelo.setValueAt(xrs.getString(64), n, 63);
                    this.xmodelo.setValueAt(xrs.getString(65), n, 64);
                    this.xmodelo.setValueAt(xrs.getString(66), n, 65);
                    this.xmodelo.setValueAt(xrs.getString(67), n, 66);
                    this.xmodelo.setValueAt(xrs.getString(68), n, 67);
                    this.xmodelo.setValueAt(xrs.getString(69), n, 68);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903823", 0)[0], n, 69);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903823", 0)[1], n, 70);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903823", 1)[0], n, 71);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903823", 1)[1], n, 72);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "904912", 0)[0], n, 73);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "904912", 0)[1], n, 74);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903856", 0)[0], n, 75);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903856", 0)[1], n, 76);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "906610", 0)[0], n, 77);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "906610", 0)[1], n, 78);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903859", 0)[0], n, 79);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903859", 0)[1], n, 80);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903801", 0)[0], n, 81);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903801", 0)[1], n, 82);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903810", 0)[0], n, 83);
                    this.xmodelo.setValueAt(mBuscaProcedimiento(xrs.getString("IdUsuarioPersona"), "903810", 0)[1], n, 84);
                    this.xmodelo.setValueAt(mProcedimientoFacturado("895100", xrs.getString("IdUsuarioPersona")), n, 85);
                    this.xmodelo.setValueAt(mCitaEspecialidad("451", xrs.getString("IdUsuarioPersona")), n, 86);
                    this.xmodelo.setValueAt(mCitaEspecialidad("1024,461", xrs.getString("IdUsuarioPersona")), n, 87);
                    this.xmodelo.setValueAt(mCitaEspecialidad("480", xrs.getString("IdUsuarioPersona")), n, 88);
                    this.xmodelo.setValueAt(mCitaEspecialidad("387", xrs.getString("IdUsuarioPersona")), n, 89);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesNProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String[] mBuscaProcedimiento(String x, String xProc, int AplProtcolo) {
        String sql;
        String[] xResultado = new String[2];
        if (AplProtcolo == 0) {
            sql = "SELECT IF(MAX(`l_resultados`.`FechaResult`)  IS NULL,'',MAX(`l_resultados`.`FechaResult`)) AS Fecha,  IF(`l_detalleresultado`.`VrNumerico` IS NULL,'',`l_detalleresultado`.`VrNumerico`) AS VrNumerico  FROM `l_resultados` INNER JOIN `l_recepcion` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `g_usuarioxprograma` ON (`l_recepcion`.`Id_Paciente` = `g_usuarioxprograma`.`Id_Usuario`)\n    INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_tiporesultado` ON (`l_detalleresultado`.`Resultado` = `l_tiporesultado`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n WHERE (`l_protocoloxprocedimiento`.`Id_Procedim` IN ('" + xProc + "') AND `g_usuarioxprograma`.`Id_Usuario` ='" + x + "')";
        } else {
            sql = "SELECT IF(MAX(`l_resultados`.`FechaResult`)  IS NULL,'',MAX(`l_resultados`.`FechaResult`)) AS Fecha,  IF(`l_detalleresultado`.`VrNumerico` IS NULL,'',`l_detalleresultado`.`VrNumerico`) AS VrNumerico  FROM `l_resultados` INNER JOIN `l_recepcion` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `g_usuarioxprograma` ON (`l_recepcion`.`Id_Paciente` = `g_usuarioxprograma`.`Id_Usuario`)\n    INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_tiporesultado` ON (`l_detalleresultado`.`Resultado` = `l_tiporesultado`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n WHERE (`l_protocoloxprocedimiento`.`Id_Procedim` IN ('" + xProc + "') AND `g_usuarioxprograma`.`Id_Usuario` ='" + x + "' AND `l_detalleresultado`.`Id_ProtocolProcedim` =670)";
        }
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs1 = xct2.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xResultado[0] = xrs1.getString("Fecha");
                xResultado[1] = xrs1.getString("VrNumerico");
            } else {
                xResultado[0] = "";
                xResultado[1] = "";
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformes_Pyp_Eps.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xResultado;
    }

    private String mCitaEspecialidad(String IdEsp, String xidUsuario) {
        String xexiste = "";
        String sql = "SELECT IF(MAX(`h_atencion`.`Fecha_Atencion`) IS NULL,'',MAX(`h_atencion`.`Fecha_Atencion`)) AS Fecha FROM `h_atencion` INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `g_usuarioxprograma` ON (`ingreso`.`Id_Usuario` = `g_usuarioxprograma`.`Id_Usuario`)\nWHERE (`h_atencion`.`Id_Especialidad` IN ('" + IdEsp + "') AND g_usuarioxprograma.`Id_Usuario`='" + xidUsuario + "')";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs1 = xct2.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xexiste = xrs1.getString("Fecha");
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformes_Pyp_Eps.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xexiste;
    }

    private String mProcedimientoFacturado(String xProc, String xUsuario) {
        String xexiste = "";
        String sql = "SELECT IF(MAX(`f_ordenes`.`FechaOrden`) IS NULL,'',MAX(`f_ordenes`.`FechaOrden`)) AS FechaOrden, `f_itemordenesproced`.`Id_Procedimiento`\nFROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `ingreso`   ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`f_itemordenesproced`.`Id_Procedimiento` ='" + xProc + "'   AND `ingreso`.`Id_Usuario` ='" + xUsuario + "' ) GROUP BY `ingreso`.`Id_Usuario`;";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs1 = xct2.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xexiste = xrs1.getString("FechaOrden");
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformes_Pyp_Eps.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xexiste;
    }

    public void mBuscar() {
        if (this.JCBPrograma.getSelectedIndex() != -1) {
            if (this.JCHFiltroEps.isSelected()) {
                if (this.JCBEmpresa.getSelectedIndex() != -1) {
                    if (this.JRB_A.isSelected()) {
                        mCargarDatosTabla_FA();
                        return;
                    } else {
                        mCargarDatosTabla_FB();
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBEmpresa.requestFocus();
                return;
            }
            if (this.JRB_A.isSelected()) {
                mCargarDatosTabla_FA();
                return;
            } else {
                mCargarDatosTabla_FB();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBPrograma.requestFocus();
    }

    private void mExportar_FA() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    private void mExportar_FB() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }
}
