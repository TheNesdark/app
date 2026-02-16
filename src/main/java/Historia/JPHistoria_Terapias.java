package Historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JDConsentimientoInformado;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPHistoria_Terapias.class */
public class JPHistoria_Terapias extends JPanel {
    private String[] xidespecialidad;
    public String[][] xidprofesional;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] dato;
    private int xtipo;
    private JButton JBTConsentimientoInformado;
    private JButton JBTEnviar;
    private JCheckBox JCBBEstatica;
    private JCheckBox JCBBalonterapia;
    private JCheckBox JCBBarraParalela;
    private JCheckBox JCBCEALibres;
    private JCheckBox JCBCRioterapia;
    private JCheckBox JCBCalorLocal;
    private JCheckBox JCBEAAsistidos;
    private JCheckBox JCBEAResistidos;
    private JCheckBox JCBEIsometricos;
    private JCheckBox JCBETemprana;
    private JCheckBox JCBEscDedos;
    private JComboBox JCBEspecialidad;
    private JCheckBox JCBEstimulacionFar;
    private JCheckBox JCBEstimulacionGalv;
    private JCheckBox JCBEstimulativo;
    private JCheckBox JCBMCicatrizal;
    private JCheckBox JCBMicronebulizacion;
    private JCheckBox JCBNeurodesarrollo;
    private JCheckBox JCBOxigenoterapia;
    private JCheckBox JCBParafina;
    private JCheckBox JCBPolea;
    public JComboBox JCBProfesional;
    private JCheckBox JCBPronosupinador;
    private JCheckBox JCBRayosInfr;
    private JCheckBox JCBRuedaHombro;
    private JCheckBox JCBSedativo;
    private JCheckBox JCBTCervical;
    private JCheckBox JCBTens;
    private JCheckBox JCBTerapiaResp;
    private JCheckBox JCBTfnp;
    private JCheckBox JCBUltrasonido;
    public JDateChooser JDCFecha;
    public JDateChooser JDCFechaC;
    public JDateChooser JDCFechaS;
    private JLabel JLBNo;
    private JLabel JLBNo1;
    private JLabel JLBSi;
    private JLabel JLBSi1;
    private JPanel JPDatosRetroalimentacion;
    private JPanel JPDatosSeguimiento;
    private JPanel JPDatosSeguimiento1;
    private JPanel JPEjercicios;
    private JPanel JPElectroterapia;
    private JPanel JPICierre;
    private JPanel JPIDatoO;
    private JPanel JPIHTFisica;
    private JPanel JPIHTRespiratorio;
    private JPanel JPIHistorico;
    private JPanel JPI_Seguimiento;
    private JPanel JPMasaje;
    private JPanel JPMecanoterapia;
    private JPanel JPMediosFisicos;
    private JPanel JPNeurologia;
    private JPanel JPPlanCasero;
    private JPanel JPPlanCasero1;
    private JPanel JPterapiaR;
    private JRadioButton JRBNo;
    private JRadioButton JRBNo1;
    private JRadioButton JRBNoP1;
    private JRadioButton JRBNoP2;
    private JRadioButton JRBSi;
    private JRadioButton JRBSi1;
    private JRadioButton JRBSiP1;
    private JRadioButton JRBSiP2;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalleR;
    private JScrollPane JSPEstiramiento;
    private JScrollPane JSPHistoriaS;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPOtros;
    private JScrollPane JSPOtrosElect;
    private JScrollPane JSPOtrosMecanoter;
    private JScrollPane JSPOtrosMf;
    private JScrollPane JSPOtrosTR;
    private JScrollPane JSPPlanCasero;
    private JScrollPane JSPReeducacionMuscular;
    private JScrollPane JSPRehabilitacionMarcha;
    public JTextField JTFCDxP;
    private JTextField JTFEmail;
    private JFormattedTextField JTFFHora;
    public JTextField JTFNCodigoDxP;
    private JTextField JTFNOrden;
    private JTable JTHistorialS;
    private JTable JTHistorico;
    public JTabbedPane JTPDatosHc;
    private JTextPane JTPDetalle;
    private JTextPane JTPDetalleR;
    private JTextPane JTPDetalle_Seguimiento;
    private JTextArea JTPEstiramiento;
    private JTextArea JTPOtros;
    private JTextPane JTPOtrosElect;
    private JTextPane JTPOtrosMecan;
    private JTextPane JTPOtrosMf;
    private JTextArea JTPOtrosTR;
    private JTextPane JTPP8;
    private JTextPane JTPP9;
    private JTextArea JTPPlanCasero;
    private JTextArea JTPReeducacionMuscular;
    private JTextArea JTPRehabilitacionMarcha;
    private JPanel jPanel1;
    private int xcalor = 0;
    private int xcrioterapia = 0;
    private int xrayosinfra = 0;
    private int xparafina = 0;
    private int xultrasonido = 0;
    private int xtracervical = 0;
    private int xbarrparalelas = 0;
    private int xbicileestatica = 0;
    private int xruedahombro = 0;
    private int xescaleradedo = 0;
    private int xpolea = 0;
    private int xpronosupinador = 0;
    private int xbalonterapia = 0;
    private int xestimulfaradica = 0;
    private int xestimulgalvanica = 0;
    private int xtens = 0;
    private int xmsedativo = 0;
    private int xmestimulativo = 0;
    private int xmcicatrizal = 0;
    private int xeisometrico = 0;
    private int xealibres = 0;
    private int xeaasistido = 0;
    private int xearesistidos = 0;
    private int xtfnp = 0;
    private int xnestimulaciontemp = 0;
    private int xnneurodesarrollo = 0;
    private int xplancasero = 0;
    private int xtipoterapia = 0;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private boolean xllenado = false;
    private int xretro = -1;
    private int xp1 = -1;
    private int xp2 = -1;
    private boolean xgrabado = false;

    public JPHistoria_Terapias(int xtipo) {
        this.xtipo = 0;
        initComponents();
        this.xtipo = xtipo;
        mNuevoI();
        mCargarDatos_TerapiaFisica();
        mCargarDatos_TRespiratoria();
        mCargarDatosTabla_Seguimiento();
        mCargarDatosTabla_Historico();
        mBuscarCierre();
        if (this.xtipo == 0) {
            this.JTPDatosHc.setEnabledAt(0, true);
            this.JTPDatosHc.setEnabledAt(1, false);
            this.JTPDatosHc.setSelectedIndex(0);
        } else {
            this.JTPDatosHc.setEnabledAt(1, true);
            this.JTPDatosHc.setEnabledAt(0, false);
            this.JTPDatosHc.setSelectedIndex(1);
        }
    }

    /* JADX WARN: Type inference failed for: r3v331, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v433, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatoO = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JBTConsentimientoInformado = new JButton();
        this.JTPDatosHc = new JTabbedPane();
        this.JPIHTFisica = new JPanel();
        this.JPMediosFisicos = new JPanel();
        this.JCBParafina = new JCheckBox();
        this.JCBRayosInfr = new JCheckBox();
        this.JCBCalorLocal = new JCheckBox();
        this.JCBCRioterapia = new JCheckBox();
        this.JCBUltrasonido = new JCheckBox();
        this.JSPOtrosMf = new JScrollPane();
        this.JTPOtrosMf = new JTextPane();
        this.JPMecanoterapia = new JPanel();
        this.JCBBEstatica = new JCheckBox();
        this.JCBRuedaHombro = new JCheckBox();
        this.JCBTCervical = new JCheckBox();
        this.JCBBarraParalela = new JCheckBox();
        this.JCBEscDedos = new JCheckBox();
        this.JSPOtrosMecanoter = new JScrollPane();
        this.JTPOtrosMecan = new JTextPane();
        this.JCBPolea = new JCheckBox();
        this.JCBPronosupinador = new JCheckBox();
        this.JCBBalonterapia = new JCheckBox();
        this.JPElectroterapia = new JPanel();
        this.JCBTens = new JCheckBox();
        this.JCBEstimulacionFar = new JCheckBox();
        this.JCBEstimulacionGalv = new JCheckBox();
        this.JSPOtrosElect = new JScrollPane();
        this.JTPOtrosElect = new JTextPane();
        this.JPMasaje = new JPanel();
        this.JCBMCicatrizal = new JCheckBox();
        this.JCBSedativo = new JCheckBox();
        this.JCBEstimulativo = new JCheckBox();
        this.JSPReeducacionMuscular = new JScrollPane();
        this.JTPReeducacionMuscular = new JTextArea();
        this.JSPRehabilitacionMarcha = new JScrollPane();
        this.JTPRehabilitacionMarcha = new JTextArea();
        this.JSPEstiramiento = new JScrollPane();
        this.JTPEstiramiento = new JTextArea();
        this.JPEjercicios = new JPanel();
        this.JCBEAAsistidos = new JCheckBox();
        this.JCBEAResistidos = new JCheckBox();
        this.JCBEIsometricos = new JCheckBox();
        this.JCBCEALibres = new JCheckBox();
        this.JPNeurologia = new JPanel();
        this.JCBNeurodesarrollo = new JCheckBox();
        this.JCBTfnp = new JCheckBox();
        this.JCBETemprana = new JCheckBox();
        this.JPPlanCasero = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JSPOtros = new JScrollPane();
        this.JTPOtros = new JTextArea();
        this.JSPPlanCasero = new JScrollPane();
        this.JTPPlanCasero = new JTextArea();
        this.JPIHTRespiratorio = new JPanel();
        this.JPterapiaR = new JPanel();
        this.JCBTerapiaResp = new JCheckBox();
        this.JCBMicronebulizacion = new JCheckBox();
        this.JCBOxigenoterapia = new JCheckBox();
        this.JSPOtrosTR = new JScrollPane();
        this.JTPOtrosTR = new JTextArea();
        this.JPI_Seguimiento = new JPanel();
        this.jPanel1 = new JPanel();
        this.JPDatosSeguimiento = new JPanel();
        this.JDCFechaS = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTPDetalle_Seguimiento = new JTextPane();
        this.JTFFHora = new JFormattedTextField();
        this.JTFNOrden = new JTextField();
        this.JSPHistoriaS = new JScrollPane();
        this.JTHistorialS = new JTable();
        this.JPICierre = new JPanel();
        this.JPDatosSeguimiento1 = new JPanel();
        this.JDCFechaC = new JDateChooser();
        this.JSPDetalle1 = new JScrollPane();
        this.JTPDetalle = new JTextPane();
        this.JTPP8 = new JTextPane();
        this.JTPP9 = new JTextPane();
        this.JLBSi = new JLabel();
        this.JLBNo = new JLabel();
        this.JRBSiP1 = new JRadioButton();
        this.JRBNoP1 = new JRadioButton();
        this.JRBSiP2 = new JRadioButton();
        this.JRBNoP2 = new JRadioButton();
        this.JLBSi1 = new JLabel();
        this.JLBNo1 = new JLabel();
        this.JPDatosRetroalimentacion = new JPanel();
        this.JSPDetalleR = new JScrollPane();
        this.JTPDetalleR = new JTextPane();
        this.JPPlanCasero1 = new JPanel();
        this.JRBSi1 = new JRadioButton();
        this.JRBNo1 = new JRadioButton();
        this.JTFEmail = new JTextField();
        this.JBTEnviar = new JButton();
        this.JPIHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjp_historia_terapia");
        this.JPIDatoO.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA ORDEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JPHistoria_Terapias.1
            public void itemStateChanged(ItemEvent evt) {
                JPHistoria_Terapias.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPHistoria_Terapias.2
            public void focusLost(FocusEvent evt) {
                JPHistoria_Terapias.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPHistoria_Terapias.3
            public void keyPressed(KeyEvent evt) {
                JPHistoria_Terapias.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPHistoria_Terapias.4
            public void mouseClicked(MouseEvent evt) {
                JPHistoria_Terapias.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPHistoria_Terapias.5
            public void keyPressed(KeyEvent evt) {
                JPHistoria_Terapias.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JBTConsentimientoInformado.setFont(new Font("Arial", 1, 12));
        this.JBTConsentimientoInformado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.JBTConsentimientoInformado.setText("Consentimiento Informado");
        this.JBTConsentimientoInformado.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.6
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JBTConsentimientoInformadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatoOLayout = new GroupLayout(this.JPIDatoO);
        this.JPIDatoO.setLayout(JPIDatoOLayout);
        JPIDatoOLayout.setHorizontalGroup(JPIDatoOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatoOLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatoOLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatoOLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, -2, 268, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProfesional, -2, 381, -2)).addGroup(JPIDatoOLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 449, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTConsentimientoInformado, -1, -1, 32767))).addGap(59, 59, 59)));
        JPIDatoOLayout.setVerticalGroup(JPIDatoOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoOLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatoOLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPIDatoOLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 50, -2).addGap(1, 1, 1)).addGroup(JPIDatoOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad).addComponent(this.JCBProfesional))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatoOLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatoOLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, 50, -2).addComponent(this.JTFNCodigoDxP, -2, 50, -2)).addComponent(this.JBTConsentimientoInformado, -1, -1, 32767)).addContainerGap(20, 32767)));
        this.JTPDatosHc.setForeground(Color.red);
        this.JTPDatosHc.setFont(new Font("Arial", 1, 14));
        this.JPMediosFisicos.setBorder(BorderFactory.createTitledBorder((Border) null, "MEDIOS FÍSICOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBParafina.setFont(new Font("Arial", 1, 12));
        this.JCBParafina.setForeground(Color.blue);
        this.JCBParafina.setText("Parafina");
        this.JCBParafina.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.7
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBParafinaActionPerformed(evt);
            }
        });
        this.JCBRayosInfr.setFont(new Font("Arial", 1, 12));
        this.JCBRayosInfr.setForeground(Color.blue);
        this.JCBRayosInfr.setText("Rayos Infra Rojos");
        this.JCBRayosInfr.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.8
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBRayosInfrActionPerformed(evt);
            }
        });
        this.JCBCalorLocal.setFont(new Font("Arial", 1, 12));
        this.JCBCalorLocal.setForeground(Color.blue);
        this.JCBCalorLocal.setText("Calor Local");
        this.JCBCalorLocal.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.9
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBCalorLocalActionPerformed(evt);
            }
        });
        this.JCBCRioterapia.setFont(new Font("Arial", 1, 12));
        this.JCBCRioterapia.setForeground(Color.blue);
        this.JCBCRioterapia.setText("Crioterapia");
        this.JCBCRioterapia.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.10
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBCRioterapiaActionPerformed(evt);
            }
        });
        this.JCBUltrasonido.setFont(new Font("Arial", 1, 12));
        this.JCBUltrasonido.setForeground(Color.blue);
        this.JCBUltrasonido.setText("Ultrasonido");
        this.JCBUltrasonido.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.11
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBUltrasonidoActionPerformed(evt);
            }
        });
        this.JSPOtrosMf.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Tahoma", 1, 11)));
        this.JTPOtrosMf.setFont(new Font("Arial", 1, 12));
        this.JSPOtrosMf.setViewportView(this.JTPOtrosMf);
        GroupLayout JPMediosFisicosLayout = new GroupLayout(this.JPMediosFisicos);
        this.JPMediosFisicos.setLayout(JPMediosFisicosLayout);
        JPMediosFisicosLayout.setHorizontalGroup(JPMediosFisicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPOtrosMf).addGroup(JPMediosFisicosLayout.createSequentialGroup().addComponent(this.JCBCalorLocal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCRioterapia).addGap(4, 4, 4).addComponent(this.JCBParafina).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBRayosInfr).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBUltrasonido)));
        JPMediosFisicosLayout.setVerticalGroup(JPMediosFisicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMediosFisicosLayout.createSequentialGroup().addGroup(JPMediosFisicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCalorLocal).addComponent(this.JCBCRioterapia).addComponent(this.JCBParafina).addComponent(this.JCBRayosInfr).addComponent(this.JCBUltrasonido)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPOtrosMf, -2, -1, -2)));
        this.JPMecanoterapia.setBorder(BorderFactory.createTitledBorder((Border) null, "MECANOTERAPIA", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JPMecanoterapia.setForeground(new Color(0, 0, 255));
        this.JCBBEstatica.setFont(new Font("Arial", 1, 12));
        this.JCBBEstatica.setForeground(new Color(0, 0, 255));
        this.JCBBEstatica.setText("Biciclieta Estática");
        this.JCBBEstatica.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.12
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBBEstaticaActionPerformed(evt);
            }
        });
        this.JCBRuedaHombro.setFont(new Font("Arial", 1, 12));
        this.JCBRuedaHombro.setForeground(new Color(0, 0, 255));
        this.JCBRuedaHombro.setText("Rueda para Hombro");
        this.JCBRuedaHombro.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.13
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBRuedaHombroActionPerformed(evt);
            }
        });
        this.JCBTCervical.setFont(new Font("Arial", 1, 12));
        this.JCBTCervical.setForeground(new Color(0, 0, 255));
        this.JCBTCervical.setText("Tracción Cervical");
        this.JCBTCervical.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.14
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBTCervicalActionPerformed(evt);
            }
        });
        this.JCBBarraParalela.setFont(new Font("Arial", 1, 12));
        this.JCBBarraParalela.setForeground(new Color(0, 0, 255));
        this.JCBBarraParalela.setText("Barra Paralela");
        this.JCBBarraParalela.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.15
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBBarraParalelaActionPerformed(evt);
            }
        });
        this.JCBEscDedos.setFont(new Font("Arial", 1, 12));
        this.JCBEscDedos.setForeground(new Color(0, 0, 255));
        this.JCBEscDedos.setText("Escalera para Dedos");
        this.JCBEscDedos.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.16
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBEscDedosActionPerformed(evt);
            }
        });
        this.JSPOtrosMecanoter.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Tahoma", 1, 11)));
        this.JTPOtrosMecan.setFont(new Font("Arial", 1, 12));
        this.JSPOtrosMecanoter.setViewportView(this.JTPOtrosMecan);
        this.JCBPolea.setFont(new Font("Arial", 1, 12));
        this.JCBPolea.setForeground(new Color(0, 0, 255));
        this.JCBPolea.setText("Polea");
        this.JCBPolea.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.17
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBPoleaActionPerformed(evt);
            }
        });
        this.JCBPronosupinador.setFont(new Font("Arial", 1, 12));
        this.JCBPronosupinador.setForeground(new Color(0, 0, 255));
        this.JCBPronosupinador.setText("Pronosupinador");
        this.JCBPronosupinador.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.18
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBPronosupinadorActionPerformed(evt);
            }
        });
        this.JCBBalonterapia.setFont(new Font("Arial", 1, 12));
        this.JCBBalonterapia.setForeground(new Color(0, 0, 255));
        this.JCBBalonterapia.setText("Balonterapia");
        this.JCBBalonterapia.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.19
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBBalonterapiaActionPerformed(evt);
            }
        });
        GroupLayout JPMecanoterapiaLayout = new GroupLayout(this.JPMecanoterapia);
        this.JPMecanoterapia.setLayout(JPMecanoterapiaLayout);
        JPMecanoterapiaLayout.setHorizontalGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMecanoterapiaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMecanoterapiaLayout.createSequentialGroup().addComponent(this.JCBTCervical).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBBarraParalela).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPronosupinador).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBBalonterapia)).addComponent(this.JSPOtrosMecanoter, -2, 448, -2).addGroup(JPMecanoterapiaLayout.createSequentialGroup().addComponent(this.JCBEscDedos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPolea).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBBEstatica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRuedaHombro))).addGap(38, 38, 38)));
        JPMecanoterapiaLayout.setVerticalGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPMecanoterapiaLayout.createSequentialGroup().addGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTCervical).addComponent(this.JCBBarraParalela).addComponent(this.JCBPronosupinador).addComponent(this.JCBBalonterapia)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEscDedos).addComponent(this.JCBPolea).addComponent(this.JCBRuedaHombro).addComponent(this.JCBBEstatica)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOtrosMecanoter, -2, -1, -2).addContainerGap()));
        this.JPElectroterapia.setBorder(BorderFactory.createTitledBorder((Border) null, "ELECTROTERAPIA", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBTens.setFont(new Font("Arial", 1, 12));
        this.JCBTens.setForeground(new Color(0, 0, 255));
        this.JCBTens.setText("TENS");
        this.JCBTens.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.20
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBTensActionPerformed(evt);
            }
        });
        this.JCBEstimulacionFar.setFont(new Font("Arial", 1, 12));
        this.JCBEstimulacionFar.setForeground(new Color(0, 0, 255));
        this.JCBEstimulacionFar.setText("Estimulación Farádica");
        this.JCBEstimulacionFar.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.21
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBEstimulacionFarActionPerformed(evt);
            }
        });
        this.JCBEstimulacionGalv.setFont(new Font("Arial", 1, 12));
        this.JCBEstimulacionGalv.setForeground(new Color(0, 0, 255));
        this.JCBEstimulacionGalv.setText("Estimulación Galvánica");
        this.JCBEstimulacionGalv.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.22
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBEstimulacionGalvActionPerformed(evt);
            }
        });
        this.JSPOtrosElect.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Tahoma", 1, 11)));
        this.JTPOtrosElect.setFont(new Font("Arial", 1, 12));
        this.JSPOtrosElect.setViewportView(this.JTPOtrosElect);
        GroupLayout JPElectroterapiaLayout = new GroupLayout(this.JPElectroterapia);
        this.JPElectroterapia.setLayout(JPElectroterapiaLayout);
        JPElectroterapiaLayout.setHorizontalGroup(JPElectroterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElectroterapiaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBEstimulacionFar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEstimulacionGalv).addContainerGap(-1, 32767)).addGroup(JPElectroterapiaLayout.createSequentialGroup().addComponent(this.JSPOtrosElect, -2, 258, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTens).addGap(0, 5, 32767)));
        JPElectroterapiaLayout.setVerticalGroup(JPElectroterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElectroterapiaLayout.createSequentialGroup().addContainerGap().addGroup(JPElectroterapiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEstimulacionFar).addComponent(this.JCBEstimulacionGalv)).addGroup(JPElectroterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElectroterapiaLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPOtrosElect, -2, -1, -2).addGap(34, 34, 34)).addGroup(JPElectroterapiaLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCBTens).addContainerGap(-1, 32767)))));
        this.JPMasaje.setBorder(BorderFactory.createTitledBorder((Border) null, "MASAJE", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBMCicatrizal.setFont(new Font("Arial", 1, 12));
        this.JCBMCicatrizal.setForeground(new Color(0, 0, 255));
        this.JCBMCicatrizal.setText("Cicatrizal");
        this.JCBMCicatrizal.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.23
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBMCicatrizalActionPerformed(evt);
            }
        });
        this.JCBSedativo.setFont(new Font("Arial", 1, 12));
        this.JCBSedativo.setForeground(new Color(0, 0, 255));
        this.JCBSedativo.setText("Sedativo");
        this.JCBSedativo.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.24
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBSedativoActionPerformed(evt);
            }
        });
        this.JCBEstimulativo.setFont(new Font("Arial", 1, 12));
        this.JCBEstimulativo.setForeground(new Color(0, 0, 255));
        this.JCBEstimulativo.setText("Estimulativo");
        this.JCBEstimulativo.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.25
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBEstimulativoActionPerformed(evt);
            }
        });
        GroupLayout JPMasajeLayout = new GroupLayout(this.JPMasaje);
        this.JPMasaje.setLayout(JPMasajeLayout);
        JPMasajeLayout.setHorizontalGroup(JPMasajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPMasajeLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBSedativo).addGap(10, 10, 10).addComponent(this.JCBEstimulativo).addGap(10, 10, 10).addComponent(this.JCBMCicatrizal).addGap(214, 214, 214)));
        JPMasajeLayout.setVerticalGroup(JPMasajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMasajeLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPMasajeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSedativo).addComponent(this.JCBMCicatrizal).addComponent(this.JCBEstimulativo)).addGap(73, 73, 73)));
        this.JSPReeducacionMuscular.setBorder(BorderFactory.createTitledBorder((Border) null, "REEDUCACIÓN MUSCULAR", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTPReeducacionMuscular.setColumns(1);
        this.JTPReeducacionMuscular.setFont(new Font("Arial", 1, 12));
        this.JTPReeducacionMuscular.setRows(1);
        this.JTPReeducacionMuscular.setTabSize(1);
        this.JSPReeducacionMuscular.setViewportView(this.JTPReeducacionMuscular);
        this.JSPRehabilitacionMarcha.setBorder(BorderFactory.createTitledBorder((Border) null, "REHABILITACIÓN DE MARCHA", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTPRehabilitacionMarcha.setColumns(1);
        this.JTPRehabilitacionMarcha.setFont(new Font("Arial", 1, 12));
        this.JTPRehabilitacionMarcha.setRows(1);
        this.JTPRehabilitacionMarcha.setTabSize(1);
        this.JSPRehabilitacionMarcha.setViewportView(this.JTPRehabilitacionMarcha);
        this.JSPEstiramiento.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTIRAMIENTOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTPEstiramiento.setColumns(1);
        this.JTPEstiramiento.setFont(new Font("Arial", 1, 12));
        this.JTPEstiramiento.setRows(1);
        this.JTPEstiramiento.setTabSize(1);
        this.JSPEstiramiento.setViewportView(this.JTPEstiramiento);
        this.JPEjercicios.setBorder(BorderFactory.createTitledBorder((Border) null, "EJERCICIOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBEAAsistidos.setFont(new Font("Arial", 1, 12));
        this.JCBEAAsistidos.setForeground(new Color(0, 0, 255));
        this.JCBEAAsistidos.setText("Activos Asistidos");
        this.JCBEAAsistidos.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.26
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBEAAsistidosActionPerformed(evt);
            }
        });
        this.JCBEAResistidos.setFont(new Font("Arial", 1, 12));
        this.JCBEAResistidos.setForeground(new Color(0, 0, 255));
        this.JCBEAResistidos.setText("Activos Resistidos");
        this.JCBEAResistidos.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.27
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBEAResistidosActionPerformed(evt);
            }
        });
        this.JCBEIsometricos.setFont(new Font("Arial", 1, 12));
        this.JCBEIsometricos.setForeground(new Color(0, 0, 255));
        this.JCBEIsometricos.setText("Isométricos");
        this.JCBEIsometricos.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.28
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBEIsometricosActionPerformed(evt);
            }
        });
        this.JCBCEALibres.setFont(new Font("Arial", 1, 12));
        this.JCBCEALibres.setForeground(new Color(0, 0, 255));
        this.JCBCEALibres.setText("Activos Libres");
        this.JCBCEALibres.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.29
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBCEALibresActionPerformed(evt);
            }
        });
        GroupLayout JPEjerciciosLayout = new GroupLayout(this.JPEjercicios);
        this.JPEjercicios.setLayout(JPEjerciciosLayout);
        JPEjerciciosLayout.setHorizontalGroup(JPEjerciciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEjerciciosLayout.createSequentialGroup().addGroup(JPEjerciciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEAResistidos).addComponent(this.JCBEIsometricos)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPEjerciciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBCEALibres).addComponent(this.JCBEAAsistidos))));
        JPEjerciciosLayout.setVerticalGroup(JPEjerciciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEjerciciosLayout.createSequentialGroup().addGroup(JPEjerciciosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEIsometricos).addComponent(this.JCBCEALibres)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPEjerciciosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEAResistidos).addComponent(this.JCBEAAsistidos)).addContainerGap(-1, 32767)));
        this.JPNeurologia.setBorder(BorderFactory.createTitledBorder((Border) null, "NEUROLOGÍA", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBNeurodesarrollo.setFont(new Font("Arial", 1, 12));
        this.JCBNeurodesarrollo.setForeground(new Color(0, 0, 255));
        this.JCBNeurodesarrollo.setText("Neurodesarrollo");
        this.JCBNeurodesarrollo.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.30
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBNeurodesarrolloActionPerformed(evt);
            }
        });
        this.JCBTfnp.setFont(new Font("Arial", 1, 12));
        this.JCBTfnp.setForeground(new Color(0, 0, 255));
        this.JCBTfnp.setText("TFNP");
        this.JCBTfnp.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.31
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBTfnpActionPerformed(evt);
            }
        });
        this.JCBETemprana.setFont(new Font("Arial", 1, 12));
        this.JCBETemprana.setForeground(new Color(0, 0, 255));
        this.JCBETemprana.setText("Estimulación Temprana");
        this.JCBETemprana.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.32
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBETempranaActionPerformed(evt);
            }
        });
        GroupLayout JPNeurologiaLayout = new GroupLayout(this.JPNeurologia);
        this.JPNeurologia.setLayout(JPNeurologiaLayout);
        JPNeurologiaLayout.setHorizontalGroup(JPNeurologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNeurologiaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPNeurologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNeurologiaLayout.createSequentialGroup().addComponent(this.JCBNeurodesarrollo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTfnp)).addComponent(this.JCBETemprana))));
        JPNeurologiaLayout.setVerticalGroup(JPNeurologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNeurologiaLayout.createSequentialGroup().addComponent(this.JCBETemprana).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPNeurologiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBNeurodesarrollo).addComponent(this.JCBTfnp))));
        this.JPPlanCasero.setBorder(BorderFactory.createTitledBorder((Border) null, "PLAN CASERO?", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setForeground(new Color(0, 0, 255));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.33
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JRBSiActionPerformed(evt);
            }
        });
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setForeground(new Color(0, 0, 255));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.34
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPPlanCaseroLayout = new GroupLayout(this.JPPlanCasero);
        this.JPPlanCasero.setLayout(JPPlanCaseroLayout);
        JPPlanCaseroLayout.setHorizontalGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCaseroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(22, 32767)));
        JPPlanCaseroLayout.setVerticalGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCaseroLayout.createSequentialGroup().addContainerGap().addGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addContainerGap(-1, 32767)));
        this.JSPOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTIRAMIENTOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTPOtros.setColumns(1);
        this.JTPOtros.setFont(new Font("Arial", 1, 12));
        this.JTPOtros.setRows(1);
        this.JTPOtros.setTabSize(1);
        this.JSPOtros.setViewportView(this.JTPOtros);
        this.JSPPlanCasero.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DEL PLAN", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTPPlanCasero.setColumns(1);
        this.JTPPlanCasero.setFont(new Font("Arial", 1, 12));
        this.JTPPlanCasero.setRows(1);
        this.JTPPlanCasero.setTabSize(1);
        this.JSPPlanCasero.setViewportView(this.JTPPlanCasero);
        GroupLayout JPIHTFisicaLayout = new GroupLayout(this.JPIHTFisica);
        this.JPIHTFisica.setLayout(JPIHTFisicaLayout);
        JPIHTFisicaLayout.setHorizontalGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHTFisicaLayout.createSequentialGroup().addContainerGap().addGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHTFisicaLayout.createSequentialGroup().addGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPMecanoterapia, -2, 0, 32767).addComponent(this.JPMediosFisicos, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPMasaje, -2, 314, -2).addGroup(GroupLayout.Alignment.LEADING, JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPEstiramiento, GroupLayout.Alignment.LEADING, -1, 243, 32767).addComponent(this.JSPReeducacionMuscular, GroupLayout.Alignment.LEADING).addComponent(this.JSPRehabilitacionMarcha, GroupLayout.Alignment.LEADING)))).addGroup(JPIHTFisicaLayout.createSequentialGroup().addGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPOtros, GroupLayout.Alignment.LEADING).addComponent(this.JPElectroterapia, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHTFisicaLayout.createSequentialGroup().addComponent(this.JPNeurologia, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPEjercicios, -1, -1, 32767)).addGroup(JPIHTFisicaLayout.createSequentialGroup().addComponent(this.JPPlanCasero, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPlanCasero, -2, 290, -2).addGap(0, 0, 32767))))).addContainerGap()));
        JPIHTFisicaLayout.setVerticalGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHTFisicaLayout.createSequentialGroup().addContainerGap().addGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHTFisicaLayout.createSequentialGroup().addComponent(this.JPMediosFisicos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPMecanoterapia, -2, -1, -2)).addGroup(JPIHTFisicaLayout.createSequentialGroup().addComponent(this.JPMasaje, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRehabilitacionMarcha, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPReeducacionMuscular, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPEstiramiento, -2, 47, -2))).addGap(12, 12, 12).addGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPElectroterapia, -2, 101, -2).addComponent(this.JPNeurologia, -2, -1, -2).addComponent(this.JPEjercicios, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIHTFisicaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPOtros, GroupLayout.Alignment.LEADING).addComponent(this.JPPlanCasero, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPPlanCasero)).addContainerGap(-1, 32767)));
        this.JTPDatosHc.addTab("H.TERAPIA FÍSICA", this.JPIHTFisica);
        this.JPterapiaR.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBTerapiaResp.setFont(new Font("Arial", 1, 12));
        this.JCBTerapiaResp.setForeground(Color.blue);
        this.JCBTerapiaResp.setText("Terapia Respiratoria");
        this.JCBTerapiaResp.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.35
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBTerapiaRespActionPerformed(evt);
            }
        });
        this.JCBMicronebulizacion.setFont(new Font("Arial", 1, 12));
        this.JCBMicronebulizacion.setForeground(Color.blue);
        this.JCBMicronebulizacion.setSelected(true);
        this.JCBMicronebulizacion.setText("Micronebulización (MNB)");
        this.JCBMicronebulizacion.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.36
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBMicronebulizacionActionPerformed(evt);
            }
        });
        this.JCBOxigenoterapia.setFont(new Font("Arial", 1, 12));
        this.JCBOxigenoterapia.setForeground(Color.blue);
        this.JCBOxigenoterapia.setText("Oxigenoterapia");
        this.JCBOxigenoterapia.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.37
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JCBOxigenoterapiaActionPerformed(evt);
            }
        });
        this.JSPOtrosTR.setBorder(BorderFactory.createTitledBorder((Border) null, "OTROS", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTPOtrosTR.setColumns(1);
        this.JTPOtrosTR.setFont(new Font("Arial", 1, 12));
        this.JTPOtrosTR.setRows(1);
        this.JTPOtrosTR.setTabSize(1);
        this.JSPOtrosTR.setViewportView(this.JTPOtrosTR);
        GroupLayout JPterapiaRLayout = new GroupLayout(this.JPterapiaR);
        this.JPterapiaR.setLayout(JPterapiaRLayout);
        JPterapiaRLayout.setHorizontalGroup(JPterapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPterapiaRLayout.createSequentialGroup().addContainerGap().addGroup(JPterapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPterapiaRLayout.createSequentialGroup().addComponent(this.JCBMicronebulizacion).addGap(28, 28, 28).addComponent(this.JCBOxigenoterapia).addGap(29, 29, 29).addComponent(this.JCBTerapiaResp).addGap(0, 292, 32767)).addComponent(this.JSPOtrosTR)).addContainerGap()));
        JPterapiaRLayout.setVerticalGroup(JPterapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPterapiaRLayout.createSequentialGroup().addContainerGap().addGroup(JPterapiaRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMicronebulizacion).addComponent(this.JCBOxigenoterapia).addComponent(this.JCBTerapiaResp)).addGap(18, 18, 18).addComponent(this.JSPOtrosTR, -1, 203, 32767).addContainerGap()));
        GroupLayout JPIHTRespiratorioLayout = new GroupLayout(this.JPIHTRespiratorio);
        this.JPIHTRespiratorio.setLayout(JPIHTRespiratorioLayout);
        JPIHTRespiratorioLayout.setHorizontalGroup(JPIHTRespiratorioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHTRespiratorioLayout.createSequentialGroup().addContainerGap().addComponent(this.JPterapiaR, -2, -1, -2).addContainerGap(-1, 32767)));
        JPIHTRespiratorioLayout.setVerticalGroup(JPIHTRespiratorioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHTRespiratorioLayout.createSequentialGroup().addContainerGap().addComponent(this.JPterapiaR, -2, -1, -2).addContainerGap(150, 32767)));
        this.JTPDatosHc.addTab("H.TERAPIA RESPIRATORIA", this.JPIHTRespiratorio);
        this.JPDatosSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaS.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaS.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaS.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTPDetalle_Seguimiento.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setViewportView(this.JTPDetalle_Seguimiento);
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm a"))));
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JTFNOrden.setEditable(false);
        this.JTFNOrden.setBackground(new Color(0, 0, 102));
        this.JTFNOrden.setFont(new Font("Arial", 1, 24));
        this.JTFNOrden.setForeground(new Color(255, 255, 255));
        this.JTFNOrden.setHorizontalAlignment(0);
        this.JTFNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 14), new Color(255, 255, 255)));
        GroupLayout JPDatosSeguimientoLayout = new GroupLayout(this.JPDatosSeguimiento);
        this.JPDatosSeguimiento.setLayout(JPDatosSeguimientoLayout);
        JPDatosSeguimientoLayout.setHorizontalGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addComponent(this.JDCFechaS, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 329, 32767).addComponent(this.JTFNOrden, -2, 136, -2).addGap(45, 45, 45)))));
        JPDatosSeguimientoLayout.setVerticalGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaS, -1, 51, 32767).addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora).addComponent(this.JTFNOrden, -2, 50, -2))).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 98, -2).addContainerGap()));
        this.JSPHistoriaS.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTHistorialS.setFont(new Font("Arial", 1, 12));
        this.JTHistorialS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorialS.setRowHeight(25);
        this.JTHistorialS.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorialS.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorialS.addMouseListener(new MouseAdapter() { // from class: Historia.JPHistoria_Terapias.38
            public void mouseClicked(MouseEvent evt) {
                JPHistoria_Terapias.this.JTHistorialSMouseClicked(evt);
            }
        });
        this.JSPHistoriaS.setViewportView(this.JTHistorialS);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatosSeguimiento, -1, -1, 32767).addComponent(this.JSPHistoriaS)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosSeguimiento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistoriaS, -1, 166, 32767).addGap(5, 5, 5)));
        GroupLayout JPI_SeguimientoLayout = new GroupLayout(this.JPI_Seguimiento);
        this.JPI_Seguimiento.setLayout(JPI_SeguimientoLayout);
        JPI_SeguimientoLayout.setHorizontalGroup(JPI_SeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        JPI_SeguimientoLayout.setVerticalGroup(JPI_SeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(46, 32767)));
        this.JTPDatosHc.addTab("SEGUIMIENTO", this.JPI_Seguimiento);
        this.JPDatosSeguimiento1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE CIERRE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatosSeguimiento1.setForeground(new Color(0, 103, 0));
        this.JDCFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTPDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle1.setViewportView(this.JTPDetalle);
        this.JTPP8.setEditable(false);
        this.JTPP8.setBorder((Border) null);
        this.JTPP8.setFont(new Font("Arial", 1, 12));
        this.JTPP8.setForeground(Color.blue);
        this.JTPP8.setText("El paciente concluyó el Num. de citas ordenadas por el Médico?");
        this.JTPP8.setOpaque(false);
        this.JTPP9.setEditable(false);
        this.JTPP9.setBorder((Border) null);
        this.JTPP9.setFont(new Font("Arial", 1, 12));
        this.JTPP9.setForeground(Color.blue);
        this.JTPP9.setText("Fué eficaz el tratamiento de Fisioterapia?");
        this.JTPP9.setOpaque(false);
        this.JLBSi.setFont(new Font("Arial", 1, 12));
        this.JLBSi.setForeground(Color.red);
        this.JLBSi.setHorizontalAlignment(0);
        this.JLBSi.setText("SI");
        this.JLBNo.setFont(new Font("Arial", 1, 12));
        this.JLBNo.setForeground(Color.red);
        this.JLBNo.setHorizontalAlignment(0);
        this.JLBNo.setText("NO");
        this.JRBSiP1.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.39
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JRBSiP1ActionPerformed(evt);
            }
        });
        this.JRBNoP1.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.40
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JRBNoP1ActionPerformed(evt);
            }
        });
        this.JRBSiP2.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.41
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JRBSiP2ActionPerformed(evt);
            }
        });
        this.JRBNoP2.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.42
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JRBNoP2ActionPerformed(evt);
            }
        });
        this.JLBSi1.setFont(new Font("Arial", 1, 12));
        this.JLBSi1.setForeground(Color.red);
        this.JLBSi1.setHorizontalAlignment(0);
        this.JLBSi1.setText("SI");
        this.JLBNo1.setFont(new Font("Arial", 1, 12));
        this.JLBNo1.setForeground(Color.red);
        this.JLBNo1.setHorizontalAlignment(0);
        this.JLBNo1.setText("NO");
        GroupLayout JPDatosSeguimiento1Layout = new GroupLayout(this.JPDatosSeguimiento1);
        this.JPDatosSeguimiento1.setLayout(JPDatosSeguimiento1Layout);
        JPDatosSeguimiento1Layout.setHorizontalGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimiento1Layout.createSequentialGroup().addContainerGap().addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimiento1Layout.createSequentialGroup().addComponent(this.JDCFechaC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle1, -2, 670, -2)).addGroup(JPDatosSeguimiento1Layout.createSequentialGroup().addComponent(this.JTPP8, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBSi, -2, 21, -2).addComponent(this.JRBSiP1)).addGap(18, 18, 18).addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNoP1, GroupLayout.Alignment.TRAILING).addComponent(this.JLBNo, GroupLayout.Alignment.TRAILING)).addGap(28, 28, 28).addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosSeguimiento1Layout.createSequentialGroup().addComponent(this.JTPP9, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSiP2)).addComponent(this.JLBSi1, -2, 21, -2)).addGap(18, 18, 18).addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNoP2, GroupLayout.Alignment.TRAILING).addComponent(this.JLBNo1, GroupLayout.Alignment.TRAILING)))).addContainerGap(-1, 32767)));
        JPDatosSeguimiento1Layout.setVerticalGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimiento1Layout.createSequentialGroup().addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaC, -2, -1, -2).addComponent(this.JSPDetalle1, -2, 96, -2)).addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimiento1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JTPP8, -2, -1, -2)).addGroup(JPDatosSeguimiento1Layout.createSequentialGroup().addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBSi).addComponent(this.JLBNo).addComponent(this.JLBSi1).addComponent(this.JLBNo1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPP9, -2, -1, -2).addGroup(JPDatosSeguimiento1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSiP1).addComponent(this.JRBNoP1)).addComponent(this.JRBSiP2).addComponent(this.JRBNoP2)))).addContainerGap()));
        this.JPDatosRetroalimentacion.setBorder(BorderFactory.createTitledBorder((Border) null, "ENVÍO DE CORREO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleR.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTPDetalleR.setEditable(false);
        this.JTPDetalleR.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleR.setViewportView(this.JTPDetalleR);
        this.JPPlanCasero1.setBorder(BorderFactory.createTitledBorder((Border) null, "Retroalimentación?", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JRBSi1.setFont(new Font("Arial", 1, 12));
        this.JRBSi1.setForeground(new Color(0, 0, 255));
        this.JRBSi1.setText("Si");
        this.JRBSi1.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.43
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JRBSi1ActionPerformed(evt);
            }
        });
        this.JRBNo1.setFont(new Font("Arial", 1, 12));
        this.JRBNo1.setForeground(new Color(0, 0, 255));
        this.JRBNo1.setText("No");
        this.JRBNo1.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.44
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JRBNo1ActionPerformed(evt);
            }
        });
        GroupLayout JPPlanCasero1Layout = new GroupLayout(this.JPPlanCasero1);
        this.JPPlanCasero1.setLayout(JPPlanCasero1Layout);
        JPPlanCasero1Layout.setHorizontalGroup(JPPlanCasero1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCasero1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi1).addGap(18, 18, 18).addComponent(this.JRBNo1).addContainerGap(41, 32767)));
        JPPlanCasero1Layout.setVerticalGroup(JPPlanCasero1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCasero1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi1).addComponent(this.JRBNo1)));
        this.JTFEmail.setFont(new Font("Arial", 1, 12));
        this.JTFEmail.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTEnviar.setFont(new Font("Arial", 1, 12));
        this.JBTEnviar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/correo_2.png")));
        this.JBTEnviar.setText("Enviar");
        this.JBTEnviar.addActionListener(new ActionListener() { // from class: Historia.JPHistoria_Terapias.45
            public void actionPerformed(ActionEvent evt) {
                JPHistoria_Terapias.this.JBTEnviarActionPerformed(evt);
            }
        });
        GroupLayout JPDatosRetroalimentacionLayout = new GroupLayout(this.JPDatosRetroalimentacion);
        this.JPDatosRetroalimentacion.setLayout(JPDatosRetroalimentacionLayout);
        JPDatosRetroalimentacionLayout.setHorizontalGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosRetroalimentacionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDatosRetroalimentacionLayout.createSequentialGroup().addComponent(this.JPPlanCasero1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEmail)).addComponent(this.JSPDetalleR, -2, 633, -2)).addGap(18, 18, 18).addComponent(this.JBTEnviar, -2, 129, -2).addGap(204, 204, 204)));
        JPDatosRetroalimentacionLayout.setVerticalGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosRetroalimentacionLayout.createSequentialGroup().addContainerGap(14, 32767).addGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTEnviar, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPDatosRetroalimentacionLayout.createSequentialGroup().addGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFEmail, -2, -1, -2).addComponent(this.JPPlanCasero1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleR, -2, 102, -2))).addContainerGap()));
        GroupLayout JPICierreLayout = new GroupLayout(this.JPICierre);
        this.JPICierre.setLayout(JPICierreLayout);
        JPICierreLayout.setHorizontalGroup(JPICierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICierreLayout.createSequentialGroup().addContainerGap().addGroup(JPICierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatosSeguimiento1, -1, -1, 32767).addComponent(this.JPDatosRetroalimentacion, -2, 0, 32767)).addContainerGap()));
        JPICierreLayout.setVerticalGroup(JPICierreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICierreLayout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosSeguimiento1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPDatosRetroalimentacion, -2, -1, -2).addContainerGap(41, 32767)));
        this.JTPDatosHc.addTab("CIERRE", this.JPICierre);
        this.JSPHistorico.setBorder((Border) null);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPHistoria_Terapias.46
            public void mouseClicked(MouseEvent evt) {
                JPHistoria_Terapias.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 808, 32767).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 427, 32767).addContainerGap()));
        this.JTPDatosHc.addTab("HISTORICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTPDatosHc, -2, 841, -2).addComponent(this.JPIDatoO, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoO, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JTPDatosHc, -2, 480, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xllenado && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            String xsql = "SELECT profesional1.Id_Persona, profesional1.NProfesional, profesional1.Email FROM g_profesional INNER JOIN profesional1  ON (g_profesional.Id_Persona = profesional1.Id_Persona) WHERE (profesional1.IdEspecialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'  AND g_profesional.Estado =0) ORDER BY profesional1.NProfesional ASC ";
            this.xidprofesional = this.xconsulta.llenarComboyLista(xsql, this.xidprofesional, this.JCBProfesional, 3);
            this.JCBProfesional.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBParafinaActionPerformed(ActionEvent evt) {
        if (this.JCBParafina.isSelected()) {
            this.xparafina = 1;
        } else {
            this.xparafina = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRayosInfrActionPerformed(ActionEvent evt) {
        if (this.JCBRayosInfr.isSelected()) {
            this.xrayosinfra = 1;
        } else {
            this.xrayosinfra = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCalorLocalActionPerformed(ActionEvent evt) {
        if (this.JCBCalorLocal.isSelected()) {
            this.xcalor = 1;
        } else {
            this.xcalor = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCRioterapiaActionPerformed(ActionEvent evt) {
        if (this.JCBCRioterapia.isSelected()) {
            this.xcrioterapia = 1;
        } else {
            this.xcrioterapia = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUltrasonidoActionPerformed(ActionEvent evt) {
        if (this.JCBUltrasonido.isSelected()) {
            this.xultrasonido = 1;
        } else {
            this.xultrasonido = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBEstaticaActionPerformed(ActionEvent evt) {
        if (this.JCBBEstatica.isSelected()) {
            this.xbicileestatica = 1;
        } else {
            this.xbicileestatica = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRuedaHombroActionPerformed(ActionEvent evt) {
        if (this.JCBRuedaHombro.isSelected()) {
            this.xruedahombro = 1;
        } else {
            this.xruedahombro = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTCervicalActionPerformed(ActionEvent evt) {
        if (this.JCBTCervical.isSelected()) {
            this.xtracervical = 1;
        } else {
            this.xtracervical = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBarraParalelaActionPerformed(ActionEvent evt) {
        if (this.JCBBarraParalela.isSelected()) {
            this.xbarrparalelas = 1;
        } else {
            this.xbarrparalelas = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEscDedosActionPerformed(ActionEvent evt) {
        if (this.JCBEscDedos.isSelected()) {
            this.xescaleradedo = 1;
        } else {
            this.xescaleradedo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPoleaActionPerformed(ActionEvent evt) {
        if (this.JCBPolea.isSelected()) {
            this.xpolea = 1;
        } else {
            this.xpolea = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBalonterapiaActionPerformed(ActionEvent evt) {
        if (this.JCBBalonterapia.isSelected()) {
            this.xbalonterapia = 1;
        } else {
            this.xbalonterapia = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPronosupinadorActionPerformed(ActionEvent evt) {
        if (this.JCBPronosupinador.isSelected()) {
            this.xpronosupinador = 1;
        } else {
            this.xpronosupinador = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTensActionPerformed(ActionEvent evt) {
        if (this.JCBTens.isSelected()) {
            this.xtens = 1;
        } else {
            this.xtens = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEstimulacionFarActionPerformed(ActionEvent evt) {
        if (this.JCBEstimulacionFar.isSelected()) {
            this.xestimulfaradica = 1;
        } else {
            this.xestimulfaradica = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEstimulacionGalvActionPerformed(ActionEvent evt) {
        if (this.JCBEstimulacionGalv.isSelected()) {
            this.xestimulgalvanica = 1;
        } else {
            this.xestimulgalvanica = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMCicatrizalActionPerformed(ActionEvent evt) {
        if (this.JCBMCicatrizal.isSelected()) {
            this.xmcicatrizal = 1;
        } else {
            this.xmcicatrizal = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedativoActionPerformed(ActionEvent evt) {
        if (this.JCBSedativo.isSelected()) {
            this.xmsedativo = 1;
        } else {
            this.xmsedativo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEstimulativoActionPerformed(ActionEvent evt) {
        if (this.JCBEstimulativo.isSelected()) {
            this.xmestimulativo = 1;
        } else {
            this.xmestimulativo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEAAsistidosActionPerformed(ActionEvent evt) {
        if (this.JCBEAAsistidos.isSelected()) {
            this.xeaasistido = 1;
        } else {
            this.xeaasistido = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEAResistidosActionPerformed(ActionEvent evt) {
        if (this.JCBEAResistidos.isSelected()) {
            this.xearesistidos = 1;
        } else {
            this.xearesistidos = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEIsometricosActionPerformed(ActionEvent evt) {
        if (this.JCBEIsometricos.isSelected()) {
            this.xeisometrico = 1;
        } else {
            this.xeisometrico = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCEALibresActionPerformed(ActionEvent evt) {
        if (this.JCBCEALibres.isSelected()) {
            this.xealibres = 1;
        } else {
            this.xealibres = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNeurodesarrolloActionPerformed(ActionEvent evt) {
        if (this.JCBNeurodesarrollo.isSelected()) {
            this.xnneurodesarrollo = 1;
        } else {
            this.xnneurodesarrollo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTfnpActionPerformed(ActionEvent evt) {
        if (this.JCBTfnp.isSelected()) {
            this.xtfnp = 1;
        } else {
            this.xtfnp = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBETempranaActionPerformed(ActionEvent evt) {
        if (this.JCBETemprana.isSelected()) {
            this.xnestimulaciontemp = 1;
        } else {
            this.xnestimulaciontemp = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xplancasero = 1;
        this.JTPPlanCasero.setEditable(true);
        this.JTPPlanCasero.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xplancasero = 0;
        this.JTPPlanCasero.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
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
    public void JTHistorialSMouseClicked(MouseEvent evt) {
        if (this.JTHistorialS.getSelectedRow() != -1) {
            this.JDCFechaS.setDate(this.xmetodo.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTHistorialS.getSelectedRow(), 1).toString()));
            this.JTFNOrden.setText(this.xmodelo.getValueAt(this.JTHistorialS.getSelectedRow(), 0).toString());
            this.JTPDetalle_Seguimiento.setText(this.xmodelo.getValueAt(this.JTHistorialS.getSelectedRow(), 2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP1ActionPerformed(ActionEvent evt) {
        this.xp1 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP1ActionPerformed(ActionEvent evt) {
        this.xp1 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP2ActionPerformed(ActionEvent evt) {
        this.xp2 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP2ActionPerformed(ActionEvent evt) {
        this.xp2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi1ActionPerformed(ActionEvent evt) {
        this.xretro = 1;
        this.JTFEmail.setEditable(true);
        this.JBTEnviar.setEnabled(true);
        this.JTPDetalleR.setEditable(true);
        this.JTFEmail.setText(this.xidprofesional[this.JCBProfesional.getSelectedIndex()][1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo1ActionPerformed(ActionEvent evt) {
        this.xretro = 0;
        this.JTFEmail.setEditable(false);
        this.JTPDetalleR.setEditable(false);
        this.JBTEnviar.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnviarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Desea enviar cierre de historia?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String recomendacion = "No se recomienda ninguna acción adicional";
            if (this.xretro == 1) {
                recomendacion = this.JTPDetalleR.getText();
            }
            String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
            String mensaje = "El Usuario " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + " ha finalizado las sesiones de fisioterpias ordenadas en su tratamiento.\n\nResumen de Atención \n" + this.JTPDetalle.getText() + "\n\nRetroalimentación \n" + recomendacion + "\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n";
            Email em = new Email();
            em.Send(xfrom, mensaje, this.JTFEmail.getText(), "Resumen de atención de fisioterapia");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (!Principal.txtNo.getText().isEmpty() || this.JTHistorico.getSelectedRow() != -1) {
                String[][] parametros = new String[3][2];
                parametros[0][0] = "idatencion1";
                parametros[0][1] = this.xmodelo1.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString();
                parametros[1][0] = "SUBREPORT_DIR";
                parametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                parametros[2][0] = "SUBREPORTFIRMA_DIR";
                parametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + this.xmodelo1.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString(), parametros);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerapiaRespActionPerformed(ActionEvent evt) {
        this.xtipoterapia = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMicronebulizacionActionPerformed(ActionEvent evt) {
        this.xtipoterapia = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBOxigenoterapiaActionPerformed(ActionEvent evt) {
        this.xtipoterapia = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConsentimientoInformadoActionPerformed(ActionEvent evt) {
        try {
            this.xsql = "SELECT\n    `ingreso`.`Id`\n    , `c_clasecita`.`Id_Procedimiento`\nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`ingreso`.`Id` =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + ")";
            ResultSet rs = this.xconsulta.traerRs(this.xsql);
            if (rs.next()) {
                rs.first();
                JDConsentimientoInformado consentimientoInformado = new JDConsentimientoInformado(null, true, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString(), rs.getString("Id_Procedimiento"), this, Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                consentimientoInformado.setLocationRelativeTo(this);
                consentimientoInformado.setVisible(true);
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPHistoria_Terapias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mNuevoI() {
        this.xllenado = false;
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.xidespecialidad = this.xconsulta.llenarCombo("SELECT `IdEspecialidad` , `Especialidad` FROM `profesional1` GROUP BY `IdEspecialidad` ORDER BY `Especialidad` ", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xsql = "SELECT profesional1.Id_Persona, profesional1.NProfesional, profesional1.Email FROM g_profesional INNER JOIN profesional1  ON (g_profesional.Id_Persona = profesional1.Id_Persona)  where g_profesional.Estado =0  ORDER BY profesional1.NProfesional ASC ";
        this.xidprofesional = this.xconsulta.llenarComboyLista(this.xsql, this.xidprofesional, this.JCBProfesional, 3);
        this.JCBProfesional.setSelectedIndex(-1);
        this.xllenado = true;
        this.xconsulta.cerrarConexionBd();
        this.JTFNOrden.setText("");
        this.JDCFechaS.setDate(this.xmetodo.getFechaActual());
        this.JDCFechaC.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setValue(this.xmetodo.getFechaActual());
    }

    public void mNuevo() {
        if (this.JTPDatosHc.getSelectedIndex() == 2) {
            mNuevo_Seguimiento();
        }
    }

    private void mBuscarCierre() {
        String sql = "SELECT h_atencionf.FechaCierre , h_atencionf.ObservacionCierre , profesional1.Especialidad , profesional1.NProfesional, h_atencionf.num_terapia, h_atencionf.eficaz  FROM profesional1 INNER JOIN h_atencionf ON (profesional1.IdEspecialidad = h_atencionf.Id_EspecialidadC) AND (profesional1.Id_Persona = h_atencionf.Id_ProfesionalC)  WHERE (h_atencionf.Id ='" + Principal.txtNo.getText() + "' and h_atencionf.Estado=0)";
        ResultSet rs = this.xconsulta.traerRs(sql);
        try {
            if (rs.next()) {
                this.JDCFechaC.setDate(rs.getDate(1));
                this.JTPDetalle.setText(rs.getString(2));
                if (rs.getInt(5) == 1) {
                    this.JRBSiP1.setSelected(true);
                } else {
                    this.JRBNoP1.setSelected(true);
                }
                if (rs.getInt(6) == 1) {
                    this.JRBSiP2.setSelected(true);
                } else {
                    this.JRBNoP2.setSelected(true);
                }
                mDesactivar_Cierre();
                this.xgrabado = true;
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCierreFT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mDesactivar_Cierre() {
        this.JTPDetalle.setEditable(false);
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'";
                ResultSet res = this.xconsulta.traerRs(sql);
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
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "historia_fisioterapia", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    private void mCargarDatos_TerapiaFisica() {
        String sql;
        System.out.println("idAtencion: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion().equals("0")) {
            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                sql = "SELECT h_atencionf.FechaHc, profesional1.NProfesional, profesional1.Especialidad, h_detalletf.CLocal, h_detalletf.RInfrarojo, h_detalletf.Parafina, h_detalletf.Ultrasonido, h_detalletf.Crioterapia , h_detalletf.OtrosMF, h_detalletf.EstimulacionF, h_detalletf.EstimulacionGalv, h_detalletf.Tens, h_detalletf.OtrosEl, h_detalletf.TraccionCervical, h_detalletf.BParalelas, h_detalletf.BEstatica, h_detalletf.RHombro , h_detalletf.EscaleraDedos, h_detalletf.Polea, h_detalletf.Pronosupinador, h_detalletf.Balonterapia, h_detalletf.OtrasMeca, h_detalletf.Sedativo, h_detalletf.Estimulativo, h_detalletf.Cicatrizal, h_detalletf.Estiramientos , h_detalletf.ReeducacionMuscular, h_detalletf.Isometricos, h_detalletf.ALibres, h_detalletf.AAsistidos, h_detalletf.AResistidos, h_detalletf.RMarcha, h_detalletf.TFNP, h_detalletf.ETemprana, h_detalletf.Neurodesarrollo , h_detalletf.PCasero, h_detalletf.Otros, h_atencionf.Id_Atencion, h_atencionf.Id_Usuario, h_atencionf.Id, h_atencionf.Estado, h_detalletf.DPlanCasero, MAX(h_atencionf.Id), `g_patologia`.`Id` as Id_Patologia, `g_patologia`.`Nbre` as Nbre_Patologia FROM h_detalletf INNER JOIN h_atencionf  ON (h_detalletf.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1  ON (profesional1.IdEspecialidad = h_atencionf.Id_Especialidad) AND (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN `g_patologia`  ON (`h_atencionf`.`Cie10` = `g_patologia`.`Id`) WHERE (h_atencionf.Estado =1 AND h_atencionf.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY h_atencionf.Id_Usuario";
            } else {
                sql = "SELECT h_atencionf.FechaHc, profesional1.NProfesional, profesional1.Especialidad, h_detalletf.CLocal, h_detalletf.RInfrarojo, h_detalletf.Parafina, h_detalletf.Ultrasonido, h_detalletf.Crioterapia , h_detalletf.OtrosMF, h_detalletf.EstimulacionF, h_detalletf.EstimulacionGalv, h_detalletf.Tens, h_detalletf.OtrosEl, h_detalletf.TraccionCervical, h_detalletf.BParalelas, h_detalletf.BEstatica, h_detalletf.RHombro , h_detalletf.EscaleraDedos, h_detalletf.Polea, h_detalletf.Pronosupinador, h_detalletf.Balonterapia, h_detalletf.OtrasMeca, h_detalletf.Sedativo, h_detalletf.Estimulativo, h_detalletf.Cicatrizal, h_detalletf.Estiramientos , h_detalletf.ReeducacionMuscular, h_detalletf.Isometricos, h_detalletf.ALibres, h_detalletf.AAsistidos, h_detalletf.AResistidos, h_detalletf.RMarcha, h_detalletf.TFNP, h_detalletf.ETemprana, h_detalletf.Neurodesarrollo , h_detalletf.PCasero, h_detalletf.Otros, h_atencionf.Id_Atencion, h_atencionf.Id_Usuario, h_atencionf.Id, h_atencionf.Estado, h_detalletf.DPlanCasero, MAX(h_atencionf.Id), `g_patologia`.`Id` as Id_Patologia, `g_patologia`.`Nbre` as Nbre_Patologia FROM h_detalletf INNER JOIN h_atencionf  ON (h_detalletf.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1  ON (profesional1.IdEspecialidad = h_atencionf.Id_Especialidad) AND (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN `g_patologia`  ON (`h_atencionf`.`Cie10` = `g_patologia`.`Id`) WHERE (h_atencionf.Estado =1 AND  h_atencionf.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_atencionf.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY h_atencionf.Id_Usuario";
            }
        } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS")) {
            sql = "SELECT h_atencionf.FechaHc, profesional1.NProfesional, profesional1.Especialidad, h_detalletf.CLocal, h_detalletf.RInfrarojo, h_detalletf.Parafina, h_detalletf.Ultrasonido, h_detalletf.Crioterapia , h_detalletf.OtrosMF, h_detalletf.EstimulacionF, h_detalletf.EstimulacionGalv, h_detalletf.Tens, h_detalletf.OtrosEl, h_detalletf.TraccionCervical, h_detalletf.BParalelas, h_detalletf.BEstatica, h_detalletf.RHombro , h_detalletf.EscaleraDedos, h_detalletf.Polea, h_detalletf.Pronosupinador, h_detalletf.Balonterapia, h_detalletf.OtrasMeca, h_detalletf.Sedativo, h_detalletf.Estimulativo, h_detalletf.Cicatrizal, h_detalletf.Estiramientos , h_detalletf.ReeducacionMuscular, h_detalletf.Isometricos, h_detalletf.ALibres, h_detalletf.AAsistidos, h_detalletf.AResistidos, h_detalletf.RMarcha, h_detalletf.TFNP, h_detalletf.ETemprana, h_detalletf.Neurodesarrollo , h_detalletf.PCasero, h_detalletf.Otros, h_atencionf.Id_Atencion, h_atencionf.Id_Usuario, h_atencionf.Id, h_atencionf.Estado, h_detalletf.DPlanCasero, MAX(h_atencionf.Id), `g_patologia`.`Id` as Id_Patologia, `g_patologia`.`Nbre` as Nbre_Patologia FROM h_detalletf INNER JOIN h_atencionf  ON (h_detalletf.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1  ON (profesional1.IdEspecialidad = h_atencionf.Id_Especialidad) AND (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN `g_patologia`  ON (`h_atencionf`.`Cie10` = `g_patologia`.`Id`) WHERE (h_atencionf.Estado =1 AND h_atencionf.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY h_atencionf.Id_Usuario";
        } else {
            sql = "SELECT h_atencionf.FechaHc, profesional1.NProfesional, profesional1.Especialidad, h_detalletf.CLocal, h_detalletf.RInfrarojo, h_detalletf.Parafina, h_detalletf.Ultrasonido, h_detalletf.Crioterapia , h_detalletf.OtrosMF, h_detalletf.EstimulacionF, h_detalletf.EstimulacionGalv, h_detalletf.Tens, h_detalletf.OtrosEl, h_detalletf.TraccionCervical, h_detalletf.BParalelas, h_detalletf.BEstatica, h_detalletf.RHombro , h_detalletf.EscaleraDedos, h_detalletf.Polea, h_detalletf.Pronosupinador, h_detalletf.Balonterapia, h_detalletf.OtrasMeca, h_detalletf.Sedativo, h_detalletf.Estimulativo, h_detalletf.Cicatrizal, h_detalletf.Estiramientos , h_detalletf.ReeducacionMuscular, h_detalletf.Isometricos, h_detalletf.ALibres, h_detalletf.AAsistidos, h_detalletf.AResistidos, h_detalletf.RMarcha, h_detalletf.TFNP, h_detalletf.ETemprana, h_detalletf.Neurodesarrollo , h_detalletf.PCasero, h_detalletf.Otros, h_atencionf.Id_Atencion, h_atencionf.Id_Usuario, h_atencionf.Id, h_atencionf.Estado, h_detalletf.DPlanCasero, MAX(h_atencionf.Id), `g_patologia`.`Id` as Id_Patologia, `g_patologia`.`Nbre` as Nbre_Patologia FROM h_detalletf INNER JOIN h_atencionf  ON (h_detalletf.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1  ON (profesional1.IdEspecialidad = h_atencionf.Id_Especialidad) AND (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN `g_patologia`  ON (`h_atencionf`.`Cie10` = `g_patologia`.`Id`) WHERE (h_atencionf.Estado =1 AND  h_atencionf.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_atencionf.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY h_atencionf.Id_Usuario";
        }
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JDCFecha.setDate(xrs.getDate(1));
                this.xllenado = false;
                this.JCBEspecialidad.setSelectedItem(xrs.getString(3));
                this.JCBProfesional.setSelectedItem(xrs.getString(2));
                this.xllenado = true;
                this.JCBCalorLocal.setSelected(xrs.getBoolean(4));
                this.JCBRayosInfr.setSelected(xrs.getBoolean(5));
                this.JCBParafina.setSelected(xrs.getBoolean(6));
                this.JCBUltrasonido.setSelected(xrs.getBoolean(7));
                this.JCBCRioterapia.setSelected(xrs.getBoolean(8));
                this.JTPOtrosMf.setText(xrs.getString(9));
                this.JCBEstimulacionFar.setSelected(xrs.getBoolean(10));
                this.JCBEstimulacionGalv.setSelected(xrs.getBoolean(11));
                this.JCBTens.setSelected(xrs.getBoolean(12));
                this.JTPOtrosElect.setText(xrs.getString(13));
                this.JCBTCervical.setSelected(xrs.getBoolean(14));
                this.JCBBarraParalela.setSelected(xrs.getBoolean(15));
                this.JCBBEstatica.setSelected(xrs.getBoolean(16));
                this.JCBRuedaHombro.setSelected(xrs.getBoolean(17));
                this.JCBEscDedos.setSelected(xrs.getBoolean(18));
                this.JCBPolea.setSelected(xrs.getBoolean(19));
                this.JCBPronosupinador.setSelected(xrs.getBoolean(20));
                this.JCBBalonterapia.setSelected(xrs.getBoolean(21));
                this.JTPOtrosMecan.setText(xrs.getString(22));
                this.JCBSedativo.setSelected(xrs.getBoolean(23));
                this.JCBEstimulativo.setSelected(xrs.getBoolean(24));
                this.JCBMCicatrizal.setSelected(xrs.getBoolean(25));
                this.JTPEstiramiento.setText(xrs.getString(26));
                this.JTPReeducacionMuscular.setText(xrs.getString(27));
                this.JCBEIsometricos.setSelected(xrs.getBoolean(28));
                this.JCBCEALibres.setSelected(xrs.getBoolean(29));
                this.JCBEAAsistidos.setSelected(xrs.getBoolean(30));
                this.JCBEAResistidos.setSelected(xrs.getBoolean(31));
                this.JTPRehabilitacionMarcha.setText(xrs.getString(32));
                this.JCBTfnp.setSelected(xrs.getBoolean(33));
                this.JCBETemprana.setSelected(xrs.getBoolean(34));
                this.JCBNeurodesarrollo.setSelected(xrs.getBoolean(35));
                if (xrs.getInt(36) == 0) {
                    this.JRBNo.setSelected(true);
                } else {
                    this.JRBSi.setSelected(true);
                }
                this.JTPOtros.setText(xrs.getString(37));
                this.JTPPlanCasero.setText(xrs.getString(42));
                Principal.txtNo.setText(xrs.getString(40));
                this.JTFCDxP.setText(xrs.getString("Id_Patologia"));
                this.JTFNCodigoDxP.setText(xrs.getString("Nbre_Patologia"));
                Principal.txtFecha.setText(this.xmetodo.formatoDMA.format((Date) xrs.getDate(1)));
                if (xrs.getInt(41) == 1) {
                    Principal.txtEstado.setText("ACTIVA");
                } else {
                    Principal.txtEstado.setText("CERRADA");
                }
                mDesctivarTF();
            } else {
                mActivarTF();
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaFTV.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mDesctivarTF() {
        this.JDCFecha.setEnabled(false);
        this.JCBEspecialidad.setEnabled(false);
        this.JCBProfesional.setEnabled(false);
        this.JCBCalorLocal.setEnabled(false);
        this.JCBRayosInfr.setEnabled(false);
        this.JCBParafina.setEnabled(false);
        this.JCBUltrasonido.setEnabled(false);
        this.JCBCRioterapia.setEnabled(false);
        this.JTPOtrosMf.setEditable(false);
        this.JCBEstimulacionFar.setEnabled(false);
        this.JCBEstimulacionGalv.setEnabled(false);
        this.JCBTens.setEnabled(false);
        this.JTPOtrosElect.setEditable(false);
        this.JCBTCervical.setEnabled(false);
        this.JCBBarraParalela.setEnabled(false);
        this.JCBBEstatica.setEnabled(false);
        this.JCBRuedaHombro.setEnabled(false);
        this.JCBEscDedos.setEnabled(false);
        this.JCBPolea.setEnabled(false);
        this.JCBPronosupinador.setEnabled(false);
        this.JCBBalonterapia.setEnabled(false);
        this.JTPOtrosMecan.setEditable(false);
        this.JCBSedativo.setEnabled(false);
        this.JCBEstimulativo.setEnabled(false);
        this.JCBMCicatrizal.setEnabled(false);
        this.JTPEstiramiento.setEditable(false);
        this.JTPReeducacionMuscular.setEditable(false);
        this.JCBEIsometricos.setEnabled(false);
        this.JCBCEALibres.setEnabled(false);
        this.JCBEAAsistidos.setEnabled(false);
        this.JCBEAResistidos.setEnabled(false);
        this.JTPRehabilitacionMarcha.setEditable(false);
        this.JCBTfnp.setEnabled(false);
        this.JCBETemprana.setEnabled(false);
        this.JCBNeurodesarrollo.setEnabled(false);
        this.JRBNo.setEnabled(false);
        this.JRBSi.setEnabled(false);
        this.JTPOtros.setEditable(false);
    }

    private void mActivarTF() {
        this.JDCFecha.setEnabled(true);
        this.JCBEspecialidad.setEnabled(true);
        this.JCBProfesional.setEnabled(true);
        this.JCBCalorLocal.setEnabled(true);
        this.JCBRayosInfr.setEnabled(true);
        this.JCBParafina.setEnabled(true);
        this.JCBUltrasonido.setEnabled(true);
        this.JCBCRioterapia.setEnabled(true);
        this.JTPOtrosMf.setEditable(true);
        this.JCBEstimulacionFar.setEnabled(true);
        this.JCBEstimulacionGalv.setEnabled(true);
        this.JCBTens.setEnabled(true);
        this.JTPOtrosElect.setEditable(true);
        this.JCBTCervical.setEnabled(true);
        this.JCBBarraParalela.setEnabled(true);
        this.JCBBEstatica.setEnabled(true);
        this.JCBRuedaHombro.setEnabled(true);
        this.JCBEscDedos.setEnabled(true);
        this.JCBPolea.setEnabled(true);
        this.JCBPronosupinador.setEnabled(true);
        this.JCBBalonterapia.setEnabled(true);
        this.JTPOtrosMecan.setEditable(true);
        this.JCBSedativo.setEnabled(true);
        this.JCBEstimulativo.setEnabled(true);
        this.JCBMCicatrizal.setEnabled(true);
        this.JTPEstiramiento.setEditable(true);
        this.JTPReeducacionMuscular.setEditable(true);
        this.JCBEIsometricos.setEnabled(true);
        this.JCBCEALibres.setEnabled(true);
        this.JCBEAAsistidos.setEnabled(true);
        this.JCBEAResistidos.setEnabled(true);
        this.JTPRehabilitacionMarcha.setEditable(true);
        this.JCBTfnp.setEnabled(true);
        this.JCBETemprana.setEnabled(true);
        this.JCBNeurodesarrollo.setEnabled(true);
        this.JRBNo.setEnabled(true);
        this.JRBSi.setEnabled(true);
        this.JTPOtros.setEditable(true);
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    if (!this.JTFNCodigoDxP.getText().isEmpty()) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            String sql = "insert into h_atencionf (Id_Usuario, Id_Atencion, Id_ClaseCita, FechaHc, Id_Profesional, Id_Especialidad, Cie10, UsuarioS, Fecha)  values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdClaseCita() + "','" + this.xmetodo.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()][0] + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.JTFCDxP.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "')";
                            Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                            this.xconsulta.cerrarConexionBd();
                            Principal.txtEstado.setText("ACTIVA");
                            if (this.JTPDatosHc.getSelectedIndex() == 0) {
                                sql = "insert into h_detalletf(Id_AtencionF, CLocal, RInfrarojo, Parafina, Ultrasonido, Crioterapia, OtrosMF, EstimulacionF, EstimulacionGalv, Tens  , OtrosEl, TraccionCervical, BParalelas, BEstatica, RHombro, EscaleraDedos, Polea, Pronosupinador, Balonterapia, OtrasMeca  , Sedativo, Estimulativo, Cicatrizal, Estiramientos, ReeducacionMuscular, Isometricos, ALibres, AAsistidos, AResistidos  , RMarcha, TFNP, ETemprana, Neurodesarrollo, PCasero, DPlanCasero, Otros ) values ('" + Principal.txtNo.getText() + "','" + this.xcalor + "','" + this.xrayosinfra + "','" + this.xparafina + "','" + this.xultrasonido + "','" + this.xcrioterapia + "','" + this.JTPOtrosMf.getText() + "','" + this.xestimulfaradica + "','" + this.xestimulgalvanica + "','" + this.xtens + "','" + this.JTPOtrosElect.getText() + "','" + this.xtracervical + "','" + this.xbarrparalelas + "','" + this.xbicileestatica + "','" + this.xruedahombro + "','" + this.xescaleradedo + "','" + this.xpolea + "','" + this.xpronosupinador + "','" + this.xbalonterapia + "','" + this.JTPOtrosMecan.getText() + "','" + this.xmsedativo + "','" + this.xmestimulativo + "','" + this.xmcicatrizal + "','" + this.JTPEstiramiento.getText() + "','" + this.JTPReeducacionMuscular.getText() + "','" + this.xeisometrico + "','" + this.xealibres + "','" + this.xeaasistido + "','" + this.xearesistidos + "','" + this.JTPRehabilitacionMarcha.getText() + "','" + this.xtfnp + "','" + this.xnestimulaciontemp + "','" + this.xnneurodesarrollo + "','" + this.xplancasero + "','" + this.JTPPlanCasero.getText() + "','" + this.JTPOtros.getText() + "')";
                            } else if (this.JTPDatosHc.getSelectedIndex() == 1) {
                                sql = "insert into h_detalletr(Id_AtencionF, Tipoterapia, Otros) values ('" + Principal.txtNo.getText() + "','" + this.xtipoterapia + "','" + this.JTPOtrosTR.getText() + "')";
                            }
                            this.xconsulta.ejecutarSQL(sql);
                            this.xconsulta.cerrarConexionBd();
                            this.xconsulta.ejecutarSQL("UPDATE c_citas SET Asistida = 3 WHERE Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCita() + "'");
                            this.xconsulta.cerrarConexionBd();
                            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una patología", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBProfesional.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBEspecialidad.requestFocus();
        }
    }

    public void mGrabar_Seguimiento() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JTFNOrden.getText().isEmpty()) {
                if (!this.JTPDetalle_Seguimiento.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        String sql = "Insert into h_seguimientof (Id_AtencionF, FechaS, Hora, Detalle, Id_Profesional, Id_Especialidad, UsuarioS, Fecha) values ('" + Principal.txtNo.getText() + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaS.getDate()) + "','" + this.xmetodo.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTPDetalle_Seguimiento.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','1','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "')";
                        this.JTFNOrden.setText(this.xconsulta.ejecutarSQLId(sql));
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla_Seguimiento();
                        String sql2 = "UPDATE c_citas SET Asistida = 3 WHERE Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCita() + "'";
                        this.xconsulta.ejecutarSQL(sql2);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla_Seguimiento();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La descripción no puede estar en blanco", "VERIFICAR", 0);
                this.JTPDetalle_Seguimiento.requestFocus();
                return;
            }
            String sql3 = "update  h_seguimientof set FechaS='" + this.xmetodo.formatoAMD.format(this.JDCFechaS.getDate()) + "', Hora='" + this.xmetodo.formatoH24.format(this.JTFFHora.getValue()) + "', Detalle='" + this.JTPDetalle_Seguimiento.getText() + "' Where Id='" + this.JTFNOrden.getText() + "'";
            this.xconsulta.ejecutarSQL(sql3);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla_Seguimiento();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Historia cerrada, No se pueden agregar seguimiento", "VERIFICAR", 0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Seguimiento() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Descripción", "Profesional"}) { // from class: Historia.JPHistoria_Terapias.47
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorialS.setModel(this.xmodelo);
        this.JTHistorialS.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistorialS.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorialS.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorialS.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorialS.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTHistorialS.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Historico() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Profesional Ordena", "Patología", "Fecha Cierre", "Observación Cierre", "Profesional Cierre", "ReporteHC"}) { // from class: Historia.JPHistoria_Terapias.48
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo1);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(20);
    }

    private void mCargarDatosTabla_Seguimiento() {
        try {
            mCrearTabla_Seguimiento();
            this.xsql = "SELECT h_seguimientof.Id, date_format(h_seguimientof.FechaS,'%d/%m/%Y') as Fecha, h_seguimientof.Detalle, profesional1.NProfesional  FROM profesional1 INNER JOIN h_seguimientof  ON (profesional1.Id_Persona = h_seguimientof.Id_Profesional) AND (profesional1.IdEspecialidad = h_seguimientof.Id_Especialidad)  WHERE (h_seguimientof.Id_AtencionF ='" + Principal.txtNo.getText() + "') ORDER BY h_seguimientof.FechaS DESC ";
            ResultSet rs = this.xconsulta.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                this.xmetodo.mEstablecerTextEditor(this.JTHistorialS, 2);
                while (rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    i++;
                }
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSeguimientoFT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_Historico() {
        try {
            mCrearTabla_Historico();
            this.xsql = "SELECT  `h_atencionf`.`Id`,  DATE_FORMAT(`h_atencionf`.`FechaHc`, '%d-%m-%Y') AS `FechaHC`, CONCAT(`profesional1_1`.`Especialidad` ,' - ', `profesional1_1`.`NProfesional`) AS `Profesional` , CONCAT(`h_atencionf`.`Cie10`,' - ', `g_patologia`.`Nbre`) AS `Patologia` , IF(`h_atencionf`.`FechaCierre` IS NULL, '',`h_atencionf`.`FechaCierre`) AS FCierre , IF(`h_atencionf`.`ObservacionCierre` IS NULL, '',`h_atencionf`.`ObservacionCierre`)  , `profesional1`.`NProfesional`, `h_tipohistoria`.`Reporte` FROM `h_atencion` INNER JOIN `h_atencionf`  ON (`h_atencion`.`Id` = `h_atencionf`.`Id_Atencion`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencionf`.`Id_ProfesionalC`) AND (`profesional1`.`IdEspecialidad` = `h_atencionf`.`Id_EspecialidadC`) INNER JOIN `profesional1` AS `profesional1_1`  ON (`profesional1_1`.`Id_Persona` = `h_atencionf`.`Id_Profesional`) AND (`profesional1_1`.`IdEspecialidad` = `h_atencionf`.`Id_Especialidad`) INNER JOIN `g_patologia`  ON (`h_atencionf`.`Cie10` = `g_patologia`.`Id`)  INNER JOIN `c_clasecita` ON (`h_atencionf`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) WHERE (`h_atencionf`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `h_atencionf`.`Estado` =0) ORDER BY `FechaHC` DESC ";
            ResultSet rs = this.xconsulta.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                this.xmetodo.mEstablecerTextEditor(this.JTHistorico, 2);
                this.xmetodo.mEstablecerTextEditor(this.JTHistorico, 3);
                this.xmetodo.mEstablecerTextEditor(this.JTHistorico, 5);
                this.xmetodo.mEstablecerTextEditor(this.JTHistorico, 6);
                while (rs.next()) {
                    this.xmodelo1.addRow(this.dato);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo1.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo1.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo1.setValueAt(rs.getString(8), i, 7);
                    i++;
                }
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSeguimientoFT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo_Seguimiento() {
        this.JTFNOrden.setText("");
        this.JDCFechaS.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setValue(this.xmetodo.getFechaActual());
        this.JTPDetalle_Seguimiento.setText("");
    }

    public void mGrabar_Cierre() {
        if (!this.xgrabado) {
            if (!this.JTPDetalle.getText().isEmpty()) {
                if (this.xp1 != -1) {
                    if (this.xp2 != -1) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "Update h_atencionf set Estado=0, FechaCierre='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', ObservacionCierre='" + this.JTPDetalle.getText() + "', Retro='" + this.xretro + "', DetalleRetro='" + this.JTPDetalleR.getText() + "', Id_ProfesionalC='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Id_EspecialidadC='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "',  num_terapia='" + this.xp1 + "',  eficaz='" + this.xp2 + "' where Id='" + Principal.txtNo.getText() + "'";
                            Principal.txtEstado.setText("CERRADA");
                            this.xconsulta.ejecutarSQL(sql);
                            this.xconsulta.cerrarConexionBd();
                            if (Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900017536")) {
                                Principal.clasehistoriace.mCambiarEstadoHc(1);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Falta respuesta de la pregunta N° 2 ", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Falta respuesta de la pregunta N° 1 ", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La descripción no puede estar en blanco", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTPDetalle.requestFocus();
        }
    }

    private void mCargarDatos_TRespiratoria() {
        String sql;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion().equals("0")) {
            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                sql = "SELECT h_atencionf.FechaHc, g_especialidad.Nbre, profesional1.NProfesional, h_detalletr.Tipoterapia, h_detalletr.Otros , h_atencionf.Id_Atencion, h_atencionf.Estado, h_atencionf.Id_Usuario, h_atencionf.Id, MAX(h_atencionf.Id)  FROM h_detalletr INNER JOIN h_atencionf  ON (h_detalletr.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1   ON (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN g_especialidad  ON (g_especialidad.Id = h_atencionf.Id_Especialidad) WHERE (h_atencionf.Estado =1 AND h_atencionf.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY h_atencionf.Id_Usuario  ";
            } else {
                sql = "SELECT h_atencionf.FechaHc, g_especialidad.Nbre, profesional1.NProfesional, h_detalletr.Tipoterapia, h_detalletr.Otros , h_atencionf.Id_Atencion, h_atencionf.Estado, h_atencionf.Id_Usuario, h_atencionf.Id, MAX(h_atencionf.Id)  FROM h_detalletr INNER JOIN h_atencionf  ON (h_detalletr.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1   ON (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN g_especialidad  ON (g_especialidad.Id = h_atencionf.Id_Especialidad) WHERE (h_atencionf.Estado =1 AND  h_atencionf.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_atencionf.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY h_atencionf.Id_Usuario  ";
            }
        } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            sql = "SELECT h_atencionf.FechaHc, g_especialidad.Nbre, profesional1.NProfesional, h_detalletr.Tipoterapia, h_detalletr.Otros , h_atencionf.Id_Atencion, h_atencionf.Estado, h_atencionf.Id_Usuario, h_atencionf.Id, MAX(h_atencionf.Id)  FROM h_detalletr INNER JOIN h_atencionf  ON (h_detalletr.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1   ON (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN g_especialidad  ON (g_especialidad.Id = h_atencionf.Id_Especialidad) WHERE ( h_atencionf.Estado =1 AND h_atencionf.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY h_atencionf.Id_Usuario ";
        } else {
            sql = "SELECT h_atencionf.FechaHc, g_especialidad.Nbre, profesional1.NProfesional, h_detalletr.Tipoterapia, h_detalletr.Otros , h_atencionf.Id_Atencion, h_atencionf.Estado, h_atencionf.Id_Usuario, h_atencionf.Id, MAX(h_atencionf.Id)  FROM h_detalletr INNER JOIN h_atencionf  ON (h_detalletr.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1   ON (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN g_especialidad  ON (g_especialidad.Id = h_atencionf.Id_Especialidad) WHERE ( h_atencionf.Estado =1 AND  h_atencionf.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_atencionf.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY h_atencionf.Id_Usuario ";
        }
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JDCFecha.setDate(xrs.getDate(1));
                this.xllenado = false;
                this.JCBEspecialidad.setSelectedItem(xrs.getString(2));
                this.JCBProfesional.setSelectedItem(xrs.getString(3));
                this.xllenado = true;
                if (xrs.getInt(4) == 0) {
                    this.JCBMicronebulizacion.setSelected(true);
                } else if (xrs.getInt(4) == 1) {
                    this.JCBOxigenoterapia.setSelected(true);
                } else if (xrs.getInt(4) == 2) {
                    this.JCBTerapiaResp.setSelected(true);
                }
                this.JTPOtrosTR.setText(xrs.getString(5));
                Principal.txtNo.setText(xrs.getString(9));
                Principal.txtFecha.setText(this.xmetodo.formatoDMA.format((Date) xrs.getDate(1)));
                if (xrs.getInt(7) == 1) {
                    Principal.txtEstado.setText("ACTIVA");
                } else {
                    Principal.txtEstado.setText("CERRADA");
                }
                mDesactivarTR();
            } else {
                mActivarTR();
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaFTV.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mDesactivarTR() {
        this.JDCFecha.setEnabled(false);
        this.JCBEspecialidad.setEnabled(false);
        this.JCBProfesional.setEnabled(false);
        this.JCBMicronebulizacion.setEnabled(false);
        this.JCBOxigenoterapia.setEnabled(false);
        this.JCBTerapiaResp.setEnabled(false);
        this.JTPOtrosTR.setEditable(false);
    }

    private void mActivarTR() {
        this.JDCFecha.setEnabled(true);
        this.JCBEspecialidad.setEnabled(true);
        this.JCBProfesional.setEnabled(true);
        this.JCBMicronebulizacion.setEnabled(true);
        this.JCBOxigenoterapia.setEnabled(true);
        this.JCBTerapiaResp.setEnabled(true);
        this.JTPOtrosTR.setEditable(true);
        this.JCBMicronebulizacion.requestFocus();
    }
}
