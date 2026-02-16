package Salud_Ocupacional;

import Acceso.Principal;
import General.JDBiometrico;
import General.Persona;
import Historia.JIFHistoriaClinica;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.text.DecimalFormat;
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
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JPPruebaAyD.class */
public class JPPruebaAyD extends JPanel {
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String xsql;
    private String[] xidmotivo;
    private String[] xidvinculo;
    private JIFPrueba_AyD xjifp;
    private String xnombre;
    private File xfile;
    private JIFHistoriaClinica xjifhc;
    private ButtonGroup JBGPAlcohol;
    private ButtonGroup JBGPDroga;
    private ButtonGroup JBG_1a;
    private ButtonGroup JBG_1b;
    private ButtonGroup JBG_1c;
    private ButtonGroup JBG_2;
    private ButtonGroup JBG_3a;
    private ButtonGroup JBG_3b;
    private ButtonGroup JBG_SN;
    private JButton JBTAdicionar;
    private JComboBox JCBMotivo;
    private JComboBox JCBVinculo;
    private JCheckBox JCH_1_No;
    private JCheckBox JCH_1_NoResponde;
    private JCheckBox JCH_1_NoSabe;
    private JCheckBox JCH_1_Si;
    private JCheckBox JCH_1b_No;
    private JCheckBox JCH_1b_NoResponde;
    private JCheckBox JCH_1b_NoSabe;
    private JCheckBox JCH_1b_Si;
    private JCheckBox JCH_1c_No;
    private JCheckBox JCH_1c_NoResponde;
    private JCheckBox JCH_1c_NoSabe;
    private JCheckBox JCH_1c_Si;
    private JCheckBox JCH_2_Si;
    private JCheckBox JCH_2c_No;
    private JCheckBox JCH_2c_NoResponde;
    private JCheckBox JCH_2c_NoSabe;
    private JCheckBox JCH_3_No;
    private JCheckBox JCH_3_NoResponde;
    private JCheckBox JCH_3_NoSabe;
    private JCheckBox JCH_3_Si;
    private JCheckBox JCH_3b_No;
    private JCheckBox JCH_3b_NoResponde;
    private JCheckBox JCH_3b_NoSabe;
    private JCheckBox JCH_3b_Si;
    private JCheckBox JCH_ANo;
    private JCheckBox JCH_ASi;
    private JLabel JLB_1a;
    private JLabel JLB_1b;
    private JLabel JLB_1c;
    private JLabel JLB_3a;
    private JLabel JLB_3b;
    private JLabel JLB_No;
    private JLabel JLB_NoResponde;
    private JLabel JLB_NoSabe;
    private JLabel JLB_Pregunta;
    private JLabel JLB_Pregunta1;
    private JLabel JLB_Pregunta2;
    private JLabel JLB_Pregunta3;
    private JLabel JLB_Si;
    private JPanel JPIHistorico;
    private JPanel JPIRegistro;
    private JPanel JPIResultadoAlcohol;
    private JPanel JPIResultadoDrogas;
    private JPanel JPISoporte;
    private JPanel JPI_Encuesta;
    private JPanel JPI_Registro;
    private JRadioButton JRBANegativo;
    private JRadioButton JRBANoAplica;
    private JRadioButton JRBAPositivo;
    private JRadioButton JRBDNegativo;
    private JRadioButton JRBDNoAplica;
    private JRadioButton JRBDPositivo;
    private JScrollPane JSPDSustancia;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPMedicamentos;
    private JTextArea JTAMedicamentos;
    public JTable JTBDSustancia;
    public JTable JTDetalleHistorico;
    private JTextField JTFALote;
    private JTextField JTFDLote;
    private JFormattedTextField JTFFValor;
    private JTextField JTFNEmpresa;
    private JTextField JTFRuta_Soporte;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTP_DRegistro;
    private JButton jButton1;
    private JButton jButton2;
    private JSeparator jSeparator1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xralcohol = "NEGATIVO";
    private String xrdroga = "NEGATIVO";
    private String xNCargo = "";
    private String xsustancias = "";
    private long IdPersona = 0;
    private int xp1_a = -1;
    private int xp1_b = -1;
    private int xp1_c = -1;
    private int xp2 = -1;
    private int xp3_a = -1;
    private int xp3_b = -1;
    private int xAcepta = -1;

    public JPPruebaAyD(JInternalFrame xjif) {
        initComponents();
        mNuevo();
        mHacerCasting(xjif);
    }

    /* JADX WARN: Type inference failed for: r3v149, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v210, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGPAlcohol = new ButtonGroup();
        this.JBGPDroga = new ButtonGroup();
        this.JBG_1a = new ButtonGroup();
        this.JBG_1b = new ButtonGroup();
        this.JBG_1c = new ButtonGroup();
        this.JBG_2 = new ButtonGroup();
        this.JBG_3a = new ButtonGroup();
        this.JBG_3b = new ButtonGroup();
        this.JBG_SN = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPI_Registro = new JPanel();
        this.JTP_DRegistro = new JTabbedPane();
        this.JPI_Encuesta = new JPanel();
        this.jSeparator1 = new JSeparator();
        this.JLB_Pregunta = new JLabel();
        this.JLB_Si = new JLabel();
        this.JLB_No = new JLabel();
        this.JLB_NoSabe = new JLabel();
        this.JLB_NoResponde = new JLabel();
        this.JLB_1a = new JLabel();
        this.JCH_1_Si = new JCheckBox();
        this.JCH_1_No = new JCheckBox();
        this.JCH_1_NoSabe = new JCheckBox();
        this.JCH_1_NoResponde = new JCheckBox();
        this.JLB_1b = new JLabel();
        this.JCH_1b_Si = new JCheckBox();
        this.JCH_1b_No = new JCheckBox();
        this.JCH_1b_NoSabe = new JCheckBox();
        this.JCH_1b_NoResponde = new JCheckBox();
        this.JLB_1c = new JLabel();
        this.JCH_1c_Si = new JCheckBox();
        this.JCH_1c_No = new JCheckBox();
        this.JCH_1c_NoSabe = new JCheckBox();
        this.JCH_1c_NoResponde = new JCheckBox();
        this.JLB_Pregunta1 = new JLabel();
        this.JCH_2_Si = new JCheckBox();
        this.JCH_2c_No = new JCheckBox();
        this.JCH_2c_NoSabe = new JCheckBox();
        this.JCH_2c_NoResponde = new JCheckBox();
        this.JLB_Pregunta3 = new JLabel();
        this.JLB_3a = new JLabel();
        this.JLB_3b = new JLabel();
        this.JCH_3_Si = new JCheckBox();
        this.JCH_3_No = new JCheckBox();
        this.JCH_3_NoSabe = new JCheckBox();
        this.JCH_3_NoResponde = new JCheckBox();
        this.JCH_3b_Si = new JCheckBox();
        this.JCH_3b_No = new JCheckBox();
        this.JCH_3b_NoSabe = new JCheckBox();
        this.JCH_3b_NoResponde = new JCheckBox();
        this.JLB_Pregunta2 = new JLabel();
        this.JCH_ASi = new JCheckBox();
        this.JCH_ANo = new JCheckBox();
        this.JPIRegistro = new JPanel();
        this.JCBMotivo = new JComboBox();
        this.JCBVinculo = new JComboBox();
        this.JTFNEmpresa = new JTextField();
        this.JPIResultadoAlcohol = new JPanel();
        this.JRBANegativo = new JRadioButton();
        this.JRBAPositivo = new JRadioButton();
        this.JTFFValor = new JFormattedTextField();
        this.JTFALote = new JTextField();
        this.JRBANoAplica = new JRadioButton();
        this.JPIResultadoDrogas = new JPanel();
        this.JRBDNegativo = new JRadioButton();
        this.JRBDPositivo = new JRadioButton();
        this.JSPDSustancia = new JScrollPane();
        this.JTBDSustancia = new JTable();
        this.JTFDLote = new JTextField();
        this.JRBDNoAplica = new JRadioButton();
        this.JSPMedicamentos = new JScrollPane();
        this.JTAMedicamentos = new JTextArea();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.JPIHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        this.JPISoporte = new JPanel();
        this.JTFRuta_Soporte = new JTextField();
        this.JBTAdicionar = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE LA PRUEBA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjp_pruebaayd");
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTP_DRegistro.setForeground(new Color(0, 103, 0));
        this.JTP_DRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_Pregunta.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta.setForeground(Color.blue);
        this.JLB_Pregunta.setText("1. En los últimos 15 minutos:");
        this.JLB_Si.setFont(new Font("Arial", 1, 12));
        this.JLB_Si.setForeground(new Color(0, 103, 0));
        this.JLB_Si.setHorizontalAlignment(0);
        this.JLB_Si.setText("SI");
        this.JLB_No.setFont(new Font("Arial", 1, 12));
        this.JLB_No.setForeground(new Color(0, 103, 0));
        this.JLB_No.setHorizontalAlignment(0);
        this.JLB_No.setText("No");
        this.JLB_NoSabe.setFont(new Font("Arial", 1, 12));
        this.JLB_NoSabe.setForeground(new Color(0, 103, 0));
        this.JLB_NoSabe.setHorizontalAlignment(0);
        this.JLB_NoSabe.setText("No Sabe");
        this.JLB_NoResponde.setFont(new Font("Arial", 1, 12));
        this.JLB_NoResponde.setForeground(new Color(0, 103, 0));
        this.JLB_NoResponde.setHorizontalAlignment(0);
        this.JLB_NoResponde.setText("No Responde");
        this.JLB_1a.setFont(new Font("Arial", 1, 12));
        this.JLB_1a.setText("a. ¿Ha ingerido licor? ");
        this.JBG_1a.add(this.JCH_1_Si);
        this.JCH_1_Si.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.1
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1_SiActionPerformed(evt);
            }
        });
        this.JBG_1a.add(this.JCH_1_No);
        this.JCH_1_No.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.2
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1_NoActionPerformed(evt);
            }
        });
        this.JBG_1a.add(this.JCH_1_NoSabe);
        this.JCH_1_NoSabe.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.3
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1_NoSabeActionPerformed(evt);
            }
        });
        this.JBG_1a.add(this.JCH_1_NoResponde);
        this.JCH_1_NoResponde.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.4
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1_NoRespondeActionPerformed(evt);
            }
        });
        this.JLB_1b.setFont(new Font("Arial", 1, 12));
        this.JLB_1b.setText("b. ¿Ha fumado? ");
        this.JBG_1b.add(this.JCH_1b_Si);
        this.JCH_1b_Si.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.5
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1b_SiActionPerformed(evt);
            }
        });
        this.JBG_1b.add(this.JCH_1b_No);
        this.JCH_1b_No.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.6
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1b_NoActionPerformed(evt);
            }
        });
        this.JBG_1b.add(this.JCH_1b_NoSabe);
        this.JCH_1b_NoSabe.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.7
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1b_NoSabeActionPerformed(evt);
            }
        });
        this.JBG_1b.add(this.JCH_1b_NoResponde);
        this.JCH_1b_NoResponde.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.8
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1b_NoRespondeActionPerformed(evt);
            }
        });
        this.JLB_1c.setFont(new Font("Arial", 1, 12));
        this.JLB_1c.setText("c. ¿Ha utilizado aerosoles bucales? ");
        this.JBG_1c.add(this.JCH_1c_Si);
        this.JCH_1c_Si.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.9
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1c_SiActionPerformed(evt);
            }
        });
        this.JBG_1c.add(this.JCH_1c_No);
        this.JCH_1c_No.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.10
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1c_NoActionPerformed(evt);
            }
        });
        this.JBG_1c.add(this.JCH_1c_NoSabe);
        this.JCH_1c_NoSabe.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.11
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1c_NoSabeActionPerformed(evt);
            }
        });
        this.JBG_1c.add(this.JCH_1c_NoResponde);
        this.JCH_1c_NoResponde.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.12
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_1c_NoRespondeActionPerformed(evt);
            }
        });
        this.JLB_Pregunta1.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta1.setForeground(Color.blue);
        this.JLB_Pregunta1.setText("<html><P ALIGN=center>2. ¿Tiene algún objeto dentro de la boca (Dulces, chicles, palitos, ect)?");
        this.JBG_2.add(this.JCH_2_Si);
        this.JCH_2_Si.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.13
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_2_SiActionPerformed(evt);
            }
        });
        this.JBG_2.add(this.JCH_2c_No);
        this.JCH_2c_No.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.14
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_2c_NoActionPerformed(evt);
            }
        });
        this.JBG_2.add(this.JCH_2c_NoSabe);
        this.JCH_2c_NoSabe.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.15
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_2c_NoSabeActionPerformed(evt);
            }
        });
        this.JBG_2.add(this.JCH_2c_NoResponde);
        this.JCH_2c_NoResponde.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.16
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_2c_NoRespondeActionPerformed(evt);
            }
        });
        this.JLB_Pregunta3.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta3.setForeground(Color.blue);
        this.JLB_Pregunta3.setText("3. En los últimos 15 minutos:");
        this.JLB_3a.setFont(new Font("Arial", 1, 12));
        this.JLB_3a.setText("a. ¿Ha vomitado? ");
        this.JLB_3b.setFont(new Font("Arial", 1, 12));
        this.JLB_3b.setText("b. ¿Ha eructado? ");
        this.JBG_3a.add(this.JCH_3_Si);
        this.JCH_3_Si.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.17
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_3_SiActionPerformed(evt);
            }
        });
        this.JBG_3a.add(this.JCH_3_No);
        this.JCH_3_No.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.18
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_3_NoActionPerformed(evt);
            }
        });
        this.JBG_3a.add(this.JCH_3_NoSabe);
        this.JCH_3_NoSabe.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.19
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_3_NoSabeActionPerformed(evt);
            }
        });
        this.JBG_3a.add(this.JCH_3_NoResponde);
        this.JCH_3_NoResponde.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.20
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_3_NoRespondeActionPerformed(evt);
            }
        });
        this.JBG_3b.add(this.JCH_3b_Si);
        this.JCH_3b_Si.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.21
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_3b_SiActionPerformed(evt);
            }
        });
        this.JBG_3b.add(this.JCH_3b_No);
        this.JCH_3b_No.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.22
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_3b_NoActionPerformed(evt);
            }
        });
        this.JBG_3b.add(this.JCH_3b_NoSabe);
        this.JCH_3b_NoSabe.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.23
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_3b_NoSabeActionPerformed(evt);
            }
        });
        this.JBG_3b.add(this.JCH_3b_NoResponde);
        this.JCH_3b_NoResponde.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.24
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_3b_NoRespondeActionPerformed(evt);
            }
        });
        this.JLB_Pregunta2.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta2.setForeground(Color.blue);
        this.JLB_Pregunta2.setText("Acepta usted y nos otorga su consentimiento para proceder a efectuar la prueba?");
        this.JBG_SN.add(this.JCH_ASi);
        this.JCH_ASi.setFont(new Font("Arial", 1, 12));
        this.JCH_ASi.setSelected(true);
        this.JCH_ASi.setText("Si");
        this.JCH_ASi.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.25
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_ASiActionPerformed(evt);
            }
        });
        this.JBG_SN.add(this.JCH_ANo);
        this.JCH_ANo.setFont(new Font("Arial", 1, 12));
        this.JCH_ANo.setText("No");
        this.JCH_ANo.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.26
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JCH_ANoActionPerformed(evt);
            }
        });
        GroupLayout JPI_EncuestaLayout = new GroupLayout(this.JPI_Encuesta);
        this.JPI_Encuesta.setLayout(JPI_EncuestaLayout);
        JPI_EncuestaLayout.setHorizontalGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncuestaLayout.createSequentialGroup().addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jSeparator1, -2, 264, -2).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncuestaLayout.createSequentialGroup().addGap(311, 311, 311).addComponent(this.JLB_Si, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_No, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_NoSabe, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_NoResponde, -2, 85, -2)).addGroup(JPI_EncuestaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Pregunta, -2, 191, -2).addGroup(JPI_EncuestaLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncuestaLayout.createSequentialGroup().addComponent(this.JLB_1b, -2, 191, -2).addGap(105, 105, 105).addComponent(this.JCH_1b_Si).addGap(26, 26, 26).addComponent(this.JCH_1b_No).addGap(42, 42, 42).addComponent(this.JCH_1b_NoSabe).addGap(53, 53, 53).addComponent(this.JCH_1b_NoResponde)).addGroup(JPI_EncuestaLayout.createSequentialGroup().addComponent(this.JLB_1a, -2, 191, -2).addGap(105, 105, 105).addComponent(this.JCH_1_Si).addGap(26, 26, 26).addComponent(this.JCH_1_No).addGap(42, 42, 42).addComponent(this.JCH_1_NoSabe).addGap(53, 53, 53).addComponent(this.JCH_1_NoResponde)).addGroup(JPI_EncuestaLayout.createSequentialGroup().addComponent(this.JLB_1c, -2, 240, -2).addGap(56, 56, 56).addComponent(this.JCH_1c_Si).addGap(26, 26, 26).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncuestaLayout.createSequentialGroup().addComponent(this.JCH_2c_No).addGap(42, 42, 42).addComponent(this.JCH_2c_NoSabe).addGap(53, 53, 53).addComponent(this.JCH_2c_NoResponde)).addGroup(JPI_EncuestaLayout.createSequentialGroup().addComponent(this.JCH_1c_No).addGap(42, 42, 42).addComponent(this.JCH_1c_NoSabe).addGap(53, 53, 53).addComponent(this.JCH_1c_NoResponde)))))))))).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncuestaLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JLB_3b, -2, 189, -2).addGap(105, 105, 105).addComponent(this.JCH_3b_Si).addGap(26, 26, 26).addComponent(this.JCH_3b_No).addGap(42, 42, 42).addComponent(this.JCH_3b_NoSabe).addGap(53, 53, 53).addComponent(this.JCH_3b_NoResponde)).addGroup(JPI_EncuestaLayout.createSequentialGroup().addGap(314, 314, 314).addComponent(this.JCH_3_Si).addGap(26, 26, 26).addComponent(this.JCH_3_No).addGap(42, 42, 42).addComponent(this.JCH_3_NoSabe).addGap(53, 53, 53).addComponent(this.JCH_3_NoResponde)).addGroup(GroupLayout.Alignment.TRAILING, JPI_EncuestaLayout.createSequentialGroup().addComponent(this.JLB_Pregunta1, -2, 308, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_2_Si).addGap(184, 184, 184))).addGroup(JPI_EncuestaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncuestaLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JLB_3a, -2, 189, -2)).addComponent(this.JLB_Pregunta3, -2, 189, -2).addGroup(JPI_EncuestaLayout.createSequentialGroup().addComponent(this.JLB_Pregunta2, -2, 488, -2).addGap(18, 18, 18).addComponent(this.JCH_ASi, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_ANo))))).addContainerGap(235, 32767)));
        JPI_EncuestaLayout.setVerticalGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncuestaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_EncuestaLayout.createSequentialGroup().addComponent(this.JLB_Pregunta2, -2, 12, -2).addGap(34, 34, 34)).addGroup(JPI_EncuestaLayout.createSequentialGroup().addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_ASi).addComponent(this.JCH_ANo)).addGap(25, 25, 25))).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_1a).addGroup(JPI_EncuestaLayout.createSequentialGroup().addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLB_Si).addComponent(this.JLB_No).addComponent(this.JLB_NoSabe).addComponent(this.JLB_NoResponde)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jSeparator1, -2, -1, -2).addGap(12, 12, 12).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_EncuestaLayout.createSequentialGroup().addComponent(this.JLB_Pregunta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_1_Si)).addComponent(this.JCH_1_No).addComponent(this.JCH_1_NoResponde).addComponent(this.JCH_1_NoSabe)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_1b).addComponent(this.JCH_1b_Si).addComponent(this.JCH_1b_No).addComponent(this.JCH_1b_NoResponde).addComponent(this.JCH_1b_NoSabe)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_1c).addComponent(this.JCH_1c_Si).addComponent(this.JCH_1c_No).addComponent(this.JCH_1c_NoResponde).addComponent(this.JCH_1c_NoSabe)).addGap(18, 18, 18).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Pregunta1, -2, 41, -2).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_2_Si).addComponent(this.JCH_2c_No).addComponent(this.JCH_2c_NoResponde).addComponent(this.JCH_2c_NoSabe))).addGap(18, 18, 18).addComponent(this.JLB_Pregunta3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_3a).addComponent(this.JCH_3_Si).addComponent(this.JCH_3_No).addComponent(this.JCH_3_NoResponde).addComponent(this.JCH_3_NoSabe)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_EncuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_3b).addComponent(this.JCH_3b_Si).addComponent(this.JCH_3b_No).addComponent(this.JCH_3b_NoResponde).addComponent(this.JCH_3b_NoSabe)).addContainerGap(57, 32767)));
        this.JTP_DRegistro.addTab("ENCUESTA PREVIA", this.JPI_Encuesta);
        this.JCBMotivo.setFont(new Font("Arial", 1, 12));
        this.JCBMotivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBVinculo.setFont(new Font("Arial", 1, 12));
        this.JCBVinculo.setBorder(BorderFactory.createTitledBorder((Border) null, "Vinculo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFNEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Empresa Contratista / Proveedora / Visitante", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPIResultadoAlcohol.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO PRUEBA ALCOHOL", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGPAlcohol.add(this.JRBANegativo);
        this.JRBANegativo.setFont(new Font("Arial", 1, 12));
        this.JRBANegativo.setSelected(true);
        this.JRBANegativo.setText("NEGATIVO");
        this.JRBANegativo.addChangeListener(new ChangeListener() { // from class: Salud_Ocupacional.JPPruebaAyD.27
            public void stateChanged(ChangeEvent evt) {
                JPPruebaAyD.this.JRBANegativoStateChanged(evt);
            }
        });
        this.JRBANegativo.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.28
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JRBANegativoActionPerformed(evt);
            }
        });
        this.JBGPAlcohol.add(this.JRBAPositivo);
        this.JRBAPositivo.setFont(new Font("Arial", 1, 12));
        this.JRBAPositivo.setText("POSITIVO");
        this.JRBAPositivo.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.29
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JRBAPositivoActionPerformed(evt);
            }
        });
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JTFALote.setFont(new Font("Arial", 1, 12));
        this.JTFALote.setBorder(BorderFactory.createTitledBorder((Border) null, "Lote", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGPAlcohol.add(this.JRBANoAplica);
        this.JRBANoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBANoAplica.setText("NO APLICA");
        this.JRBANoAplica.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.30
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JRBANoAplicaActionPerformed(evt);
            }
        });
        GroupLayout JPIResultadoAlcoholLayout = new GroupLayout(this.JPIResultadoAlcohol);
        this.JPIResultadoAlcohol.setLayout(JPIResultadoAlcoholLayout);
        JPIResultadoAlcoholLayout.setHorizontalGroup(JPIResultadoAlcoholLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoAlcoholLayout.createSequentialGroup().addContainerGap().addGroup(JPIResultadoAlcoholLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBANegativo).addComponent(this.JRBANoAplica).addComponent(this.JRBAPositivo)).addGap(18, 18, 18).addGroup(JPIResultadoAlcoholLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFALote, -1, 114, 32767).addComponent(this.JTFFValor)).addContainerGap(28, 32767)));
        JPIResultadoAlcoholLayout.setVerticalGroup(JPIResultadoAlcoholLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoAlcoholLayout.createSequentialGroup().addGroup(JPIResultadoAlcoholLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoAlcoholLayout.createSequentialGroup().addComponent(this.JRBANegativo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAPositivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBANoAplica, -2, 15, -2)).addGroup(JPIResultadoAlcoholLayout.createSequentialGroup().addComponent(this.JTFFValor, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFALote, -2, -1, -2))).addGap(0, 40, 32767)));
        this.JPIResultadoDrogas.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO PRUEBA DROGA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGPDroga.add(this.JRBDNegativo);
        this.JRBDNegativo.setFont(new Font("Arial", 1, 12));
        this.JRBDNegativo.setSelected(true);
        this.JRBDNegativo.setText("NEGATIVO");
        this.JRBDNegativo.addChangeListener(new ChangeListener() { // from class: Salud_Ocupacional.JPPruebaAyD.31
            public void stateChanged(ChangeEvent evt) {
                JPPruebaAyD.this.JRBDNegativoStateChanged(evt);
            }
        });
        this.JRBDNegativo.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.32
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JRBDNegativoActionPerformed(evt);
            }
        });
        this.JBGPDroga.add(this.JRBDPositivo);
        this.JRBDPositivo.setFont(new Font("Arial", 1, 12));
        this.JRBDPositivo.setText("POSITIVO");
        this.JRBDPositivo.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.33
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JRBDPositivoActionPerformed(evt);
            }
        });
        this.JSPDSustancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Sustancia", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTBDSustancia.setFont(new Font("Arial", 1, 12));
        this.JTBDSustancia.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDSustancia.setName("xjifpruebaayd");
        this.JTBDSustancia.setRowHeight(25);
        this.JTBDSustancia.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDSustancia.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDSustancia.setViewportView(this.JTBDSustancia);
        this.JTFDLote.setFont(new Font("Arial", 1, 12));
        this.JTFDLote.setBorder(BorderFactory.createTitledBorder((Border) null, "Lote", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGPDroga.add(this.JRBDNoAplica);
        this.JRBDNoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBDNoAplica.setText("NO APLICA");
        this.JRBDNoAplica.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.34
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JRBDNoAplicaActionPerformed(evt);
            }
        });
        GroupLayout JPIResultadoDrogasLayout = new GroupLayout(this.JPIResultadoDrogas);
        this.JPIResultadoDrogas.setLayout(JPIResultadoDrogasLayout);
        JPIResultadoDrogasLayout.setHorizontalGroup(JPIResultadoDrogasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoDrogasLayout.createSequentialGroup().addContainerGap().addGroup(JPIResultadoDrogasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFDLote, -2, 134, -2).addGroup(JPIResultadoDrogasLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPIResultadoDrogasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBDNegativo).addComponent(this.JRBDPositivo).addComponent(this.JRBDNoAplica)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDSustancia, -2, 364, -2).addContainerGap(-1, 32767)));
        JPIResultadoDrogasLayout.setVerticalGroup(JPIResultadoDrogasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoDrogasLayout.createSequentialGroup().addGroup(JPIResultadoDrogasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoDrogasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDSustancia, -2, 0, 32767)).addGroup(JPIResultadoDrogasLayout.createSequentialGroup().addComponent(this.JRBDNegativo, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDPositivo, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDNoAplica, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDLote, -1, 47, 32767).addGap(5, 5, 5))).addContainerGap()));
        this.JTAMedicamentos.setColumns(1);
        this.JTAMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTAMedicamentos.setLineWrap(true);
        this.JTAMedicamentos.setRows(1);
        this.JTAMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "Medicamentos (de todo tipo) ingeridos los últimos treinta (30) días.", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPMedicamentos.setViewportView(this.JTAMedicamentos);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.jButton1.setText("Consentimiento informado");
        this.jButton1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.35
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.jButton2.setText("Firmado por Biometría");
        this.jButton2.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.36
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout JPIRegistroLayout = new GroupLayout(this.JPIRegistro);
        this.JPIRegistro.setLayout(JPIRegistroLayout);
        JPIRegistroLayout.setHorizontalGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRegistroLayout.createSequentialGroup().addComponent(this.JPIResultadoDrogas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIResultadoAlcohol, -2, -1, -2)).addGroup(JPIRegistroLayout.createSequentialGroup().addGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIRegistroLayout.createSequentialGroup().addComponent(this.JCBMotivo, -2, 278, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBVinculo, -2, 204, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNEmpresa)).addComponent(this.JSPMedicamentos, -2, 817, -2).addGroup(JPIRegistroLayout.createSequentialGroup().addComponent(this.jButton1, -2, 290, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton2, -2, 290, -2))).addGap(0, 0, 32767))).addContainerGap()));
        JPIRegistroLayout.setVerticalGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMotivo, -2, 50, -2).addComponent(this.JCBVinculo, -2, 50, -2).addComponent(this.JTFNEmpresa, -2, 50, -2)).addGap(20, 20, 20).addComponent(this.JSPMedicamentos, -2, 61, -2).addGap(18, 18, 18).addGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIResultadoAlcohol, -2, -1, -2).addComponent(this.JPIResultadoDrogas, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIRegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton1, -1, -1, 32767).addComponent(this.jButton2, -1, -1, 32767)).addContainerGap(18, 32767)));
        this.JTP_DRegistro.addTab("DATOS PRUEBA", this.JPIRegistro);
        GroupLayout JPI_RegistroLayout = new GroupLayout(this.JPI_Registro);
        this.JPI_Registro.setLayout(JPI_RegistroLayout);
        JPI_RegistroLayout.setHorizontalGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RegistroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DRegistro).addContainerGap()));
        JPI_RegistroLayout.setVerticalGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RegistroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DRegistro).addContainerGap()));
        this.JTPDatos.addTab("DATOS PUEBA", this.JPI_Registro);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JPPruebaAyD.37
            public void mouseClicked(MouseEvent evt) {
                JPPruebaAyD.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        this.JPISoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Subir Imagen de Soporte", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta_Soporte.setFont(new Font("Arial", 1, 12));
        this.JTFRuta_Soporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta_Soporte.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JPPruebaAyD.38
            public void mouseClicked(MouseEvent evt) {
                JPPruebaAyD.this.JTFRuta_SoporteMouseClicked(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Grabar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JPPruebaAyD.39
            public void actionPerformed(ActionEvent evt) {
                JPPruebaAyD.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPISoporteLayout = new GroupLayout(this.JPISoporte);
        this.JPISoporte.setLayout(JPISoporteLayout);
        JPISoporteLayout.setHorizontalGroup(JPISoporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISoporteLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta_Soporte, -2, 588, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionar, -2, 191, -2).addContainerGap()));
        JPISoporteLayout.setVerticalGroup(JPISoporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISoporteLayout.createSequentialGroup().addContainerGap().addGroup(JPISoporteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta_Soporte, -2, -1, -2).addComponent(this.JBTAdicionar, -2, 41, -2)).addContainerGap(16, 32767)));
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico).addComponent(this.JPISoporte, -1, -1, 32767)).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 289, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPISoporte, -2, -1, -2).addContainerGap(30, 32767)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBANegativoActionPerformed(ActionEvent evt) {
        this.xralcohol = this.JRBANegativo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAPositivoActionPerformed(ActionEvent evt) {
        this.xralcohol = this.JRBAPositivo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDNegativoActionPerformed(ActionEvent evt) {
        this.xrdroga = this.JRBDNegativo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDPositivoActionPerformed(ActionEvent evt) {
        this.xrdroga = this.JRBDPositivo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.xsustancias = "";
            Principal.txtNo.setText(this.xmodelo1.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString());
            this.JTFRuta_Soporte.setText(this.xmodelo1.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 10).toString());
            mLlenarTablaSustancia();
            mImprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta_SoporteMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTFRuta_Soporte.getText().isEmpty()) {
                JFileChooser xfilec = new JFileChooser("S:\\Salud Ocupacional\\Soporte_PAyD\\" + this.xmt.formatoANO.format(this.xmt.getFechaActual()));
                int xv = xfilec.showOpenDialog(this);
                if (xv == 0) {
                    this.xfile = xfilec.getSelectedFile();
                    System.out.println(this.xfile.getAbsolutePath());
                    this.JTFRuta_Soporte.setText(this.xfile.getAbsolutePath());
                    this.JTFRuta_Soporte.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
                    return;
                }
                return;
            }
            Object[] botones = {"Visualizar", "Cargar", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "SOPORTE", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.xmt.mostrarPdf(this.JTFRuta_Soporte.getText());
                return;
            }
            JFileChooser xfilec2 = new JFileChooser("S:\\Salud Ocupacional\\Soporte_PAyD\\" + this.xmt.formatoANO.format(this.xmt.getFechaActual()));
            int xv2 = xfilec2.showOpenDialog(this);
            if (xv2 == 0) {
                this.xfile = xfilec2.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRuta_Soporte.setText(this.xfile.getAbsolutePath());
                this.JTFRuta_Soporte.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1) {
            int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 3);
            if (y == 0) {
                this.xsql = "update  h_so_alcohol_drogas set UrlSoporte ='" + this.JTFRuta_Soporte.getText() + "' where Id='" + this.xmodelo1.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0) + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "IdUsuario";
        mparametros[0][1] = String.valueOf(this.IdPersona);
        mparametros[1][0] = "FECHA";
        mparametros[1][1] = this.xmt.formatoAMD.format(this.xmt.getFechaActual());
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concentimiento_AyD", mparametros);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1_SiActionPerformed(ActionEvent evt) {
        this.xp1_a = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1_NoActionPerformed(ActionEvent evt) {
        this.xp1_a = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1_NoSabeActionPerformed(ActionEvent evt) {
        this.xp1_a = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1_NoRespondeActionPerformed(ActionEvent evt) {
        this.xp1_a = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1b_SiActionPerformed(ActionEvent evt) {
        this.xp1_b = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1b_NoActionPerformed(ActionEvent evt) {
        this.xp1_b = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1b_NoSabeActionPerformed(ActionEvent evt) {
        this.xp1_b = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1b_NoRespondeActionPerformed(ActionEvent evt) {
        this.xp1_b = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1c_SiActionPerformed(ActionEvent evt) {
        this.xp1_c = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1c_NoActionPerformed(ActionEvent evt) {
        this.xp1_c = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1c_NoSabeActionPerformed(ActionEvent evt) {
        this.xp1_c = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_1c_NoRespondeActionPerformed(ActionEvent evt) {
        this.xp1_c = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_2_SiActionPerformed(ActionEvent evt) {
        this.xp2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_2c_NoActionPerformed(ActionEvent evt) {
        this.xp2 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_2c_NoSabeActionPerformed(ActionEvent evt) {
        this.xp2 = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_2c_NoRespondeActionPerformed(ActionEvent evt) {
        this.xp2 = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_3_SiActionPerformed(ActionEvent evt) {
        this.xp3_a = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_3_NoActionPerformed(ActionEvent evt) {
        this.xp3_a = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_3_NoSabeActionPerformed(ActionEvent evt) {
        this.xp3_a = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_3_NoRespondeActionPerformed(ActionEvent evt) {
        this.xp3_a = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_3b_SiActionPerformed(ActionEvent evt) {
        this.xp3_b = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_3b_NoActionPerformed(ActionEvent evt) {
        this.xp3_b = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_3b_NoSabeActionPerformed(ActionEvent evt) {
        this.xp3_b = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_3b_NoRespondeActionPerformed(ActionEvent evt) {
        this.xp3_b = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, getName(), Principal.txtNo.getText());
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ASiActionPerformed(ActionEvent evt) {
        this.xAcepta = 1;
        seleccionCheckNo(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ANoActionPerformed(ActionEvent evt) {
        this.xAcepta = 0;
        seleccionCheckNo(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDNoAplicaActionPerformed(ActionEvent evt) {
        this.xrdroga = this.JRBDNoAplica.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBANoAplicaActionPerformed(ActionEvent evt) {
        this.xralcohol = this.JRBANoAplica.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDNegativoStateChanged(ChangeEvent evt) {
        System.out.println("Cambio Drogas NEGATIVO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBANegativoStateChanged(ChangeEvent evt) {
        System.out.println("Cambio Alcohol NEGATIVO");
    }

    private void seleccionCheckNo(Boolean estado) {
        this.JCH_1_NoResponde.setSelected(estado.booleanValue());
        this.xp1_a = 3;
        this.xp1_b = 3;
        this.xp1_c = 3;
        this.xp2 = 3;
        this.xp3_a = 3;
        this.xp3_b = 3;
        this.JCH_1b_NoResponde.setSelected(estado.booleanValue());
        this.JCH_1c_NoResponde.setSelected(estado.booleanValue());
        this.JCH_2c_NoResponde.setSelected(estado.booleanValue());
        this.JCH_3_NoResponde.setSelected(estado.booleanValue());
        this.JCH_3b_NoResponde.setSelected(estado.booleanValue());
        this.JRBANoAplica.setSelected(estado.booleanValue());
        this.JRBDNoAplica.setSelected(estado.booleanValue());
        this.xrdroga = this.JRBDNoAplica.getText();
        this.xralcohol = this.JRBANoAplica.getText();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBMotivo.removeAllItems();
        this.xidmotivo = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `so_tipo_motivo_prueba` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xidmotivo, this.JCBMotivo);
        this.JCBMotivo.setSelectedIndex(-1);
        this.JCBVinculo.removeAllItems();
        this.xidvinculo = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `so_tipo_vinculacion` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xidvinculo, this.JCBVinculo);
        this.JCBVinculo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFNEmpresa.setText("");
        this.JRBANegativo.setSelected(true);
        this.JRBDNegativo.setSelected(true);
        this.JTAMedicamentos.setText("");
        this.JTFALote.setText("");
        this.JTFDLote.setText("");
        this.xralcohol = "NEGATIVO";
        this.xrdroga = "NEGATIVO";
        this.xp1_a = -1;
        this.xp1_b = -1;
        this.xp1_c = -1;
        this.xp2 = -1;
        this.xp3_a = -1;
        this.xp3_b = -1;
        this.JBG_1a.clearSelection();
        this.JBG_1b.clearSelection();
        this.JBG_1c.clearSelection();
        this.JBG_2.clearSelection();
        this.JBG_3a.clearSelection();
        this.JBG_3b.clearSelection();
        this.JBG_SN.clearSelection();
        this.xAcepta = -1;
        this.JTFFValor.setValue(0);
        mCargarDatosTabla();
        mCrearModeloHistorico();
        this.JCBMotivo.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaS() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Observación", "Aplica?"}) { // from class: Salud_Ocupacional.JPPruebaAyD.40
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDSustancia.setModel(this.xmodelo);
        this.JTBDSustancia.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDSustancia.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDSustancia.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDSustancia.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDSustancia.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDSustancia.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloTablaS();
            this.xsql = "SELECT `Id`, `Nbre` FROM `so_tipo_sustancia` WHERE (`Estado` =1) ORDER BY `Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt("", x, 2);
                    this.xmodelo.setValueAt(false, x, 3);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPPruebaAyD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mValidarCampos() {
        boolean xestado = false;
        if (this.JCBMotivo.getSelectedIndex() != -1) {
            if (this.JCBVinculo.getSelectedIndex() != -1) {
                if (this.xp1_a != -1) {
                    if (this.xp1_a != -1) {
                        if (this.xp1_c != -1) {
                            if (this.xp2 != -1) {
                                if (this.xp3_a != -1) {
                                    if (this.xp3_b != -1) {
                                        xestado = true;
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar respuesta para la pregunta 3 sección b", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    }
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar respuesta para la pregunta 3 sección a", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                }
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar respuesta para la pregunta 2", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar respuesta para la pregunta 1 sección c", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar respuesta para la pregunta 1 sección b", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar respuesta para la pregunta 1 sección a", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de vinculo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBMotivo.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un motivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBMotivo.requestFocus();
        }
        return xestado;
    }

    public void mGrabar() {
        if (!Principal.txtNo.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.IdPersona != 0) {
            if (mValidarCampos()) {
                int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y == 0) {
                    if (getName().equals("xjifpruebaayd") || getName().equals("xjifpruebaaydE")) {
                        setxNCargo(this.xjifp.xjppersona.JCBSupervisor.getSelectedItem().toString());
                    }
                    this.xsql = "insert into h_so_alcohol_drogas (`FechaR`, `Id_Sede`,`Id_Usuario`, `Id_Motivo`, `Id_Vinculo`, `NEmpresa`, `AResultado`, `AValor`, `ALote`,`DResultado`,`DLote`, `Medicamentos`,`Id_Profesional`, `Id_Especialidad`, `PAcepta`,`P1_a`, `P1_b`, `P1_c`, `P2`, `P3_a`, `P3_b`, NSupervisor, `UsuarioS` )  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + this.IdPersona + "','" + this.xidmotivo[this.JCBMotivo.getSelectedIndex()] + "','" + this.xidvinculo[this.JCBVinculo.getSelectedIndex()] + "','" + this.JTFNEmpresa.getText() + "','" + this.xralcohol + "','" + this.JTFFValor.getValue() + "','" + this.JTFALote.getText() + "','" + this.xrdroga + "','" + this.JTFDLote.getText() + "','" + this.JTAMedicamentos.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xAcepta + "','" + this.xp1_a + "','" + this.xp1_b + "','" + this.xp1_b + "','" + this.xp2 + "','" + this.xp3_a + "','" + this.xp3_b + "','" + getxNCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    for (int x = 0; x < this.JTBDSustancia.getRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue()) {
                            this.xsql = "insert into h_so_alcohol_drogras_detalles (`Id_ad`, `Id_tsustancia`, `Observacion`,`UsuarioS`) values('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 2) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    mCargarDatosTablaHistorico();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mHacerCasting(JInternalFrame xjf) {
        switch (xjf.getName()) {
            case "xjifpruebaayd":
                this.xjifp = (JIFPrueba_AyD) xjf;
                this.xnombre = "xjifpruebaayd";
                break;
            case "jifhistoriaclinica":
                this.xjifhc = (JIFHistoriaClinica) xjf;
                this.xnombre = "jifhistoriaclinica";
                setIdPersona(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue());
                mCargarDatosTablaHistorico();
                break;
            case "xjifpruebaaydE":
                this.xjifp = (JIFPrueba_AyD) xjf;
                this.xnombre = "xjifpruebaaydE";
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Motivo", "Vinculacion", "Empresa", "ResultadoA", "Valor", "ResultadoD", "Especialidad", "Profesional", "UrlSoporte"}) { // from class: Salud_Ocupacional.JPPruebaAyD.41
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodelo1);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalleHistorico.getColumnModel().getColumn(10).setPreferredWidth(10);
    }

    public void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT `h_so_alcohol_drogas`.`Id`, DATE_FORMAT(`h_so_alcohol_drogas`.`FechaR`,'%d-%m-%Y') AS Fecha, `so_tipo_motivo_prueba`.`Nbre`, `so_tipo_vinculacion`.`Nbre`, `h_so_alcohol_drogas`.`NEmpresa` , `h_so_alcohol_drogas`.`AResultado`, `h_so_alcohol_drogas`.`AValor`, `h_so_alcohol_drogas`.`DResultado`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `h_so_alcohol_drogas`.`Url_Soporte` FROM `h_so_alcohol_drogas` INNER JOIN `so_tipo_motivo_prueba`  ON (`h_so_alcohol_drogas`.`Id_Motivo` = `so_tipo_motivo_prueba`.`Id`) INNER JOIN `so_tipo_vinculacion`  ON (`h_so_alcohol_drogas`.`Id_Vinculo` = `so_tipo_vinculacion`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `h_so_alcohol_drogas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_so_alcohol_drogas`.`Id_Especialidad`) WHERE (`h_so_alcohol_drogas`.`Id_Usuario` ='" + this.IdPersona + "' AND `h_so_alcohol_drogas`.`Estado` =1) ORDER BY `h_so_alcohol_drogas`.`FechaR` DESC ";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo1.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo1.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo1.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo1.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo1.setValueAt(xrs.getString(11), n, 10);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPPruebaAyD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLlenarTablaSustancia() {
        try {
            mCrearModeloTablaS();
            this.xsql = "SELECT `h_so_alcohol_drogras_detalles`.`Id_tsustancia`, `so_tipo_sustancia`.`Nbre`, `h_so_alcohol_drogras_detalles`.`Observacion`, TRUE AS `Aplica` FROM  `h_so_alcohol_drogras_detalles` INNER JOIN `so_tipo_sustancia`  ON (`h_so_alcohol_drogras_detalles`.`Id_tsustancia` = `so_tipo_sustancia`.`Id`) WHERE (`h_so_alcohol_drogras_detalles`.`Id_ad` ='" + Principal.txtNo.getText() + "' AND `h_so_alcohol_drogras_detalles`.`Estado` =1) ORDER BY `so_tipo_sustancia`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xsustancias += xrs.getString(2) + "\n";
                }
                System.out.println(this.xsustancias);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPPruebaAyD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = Principal.txtNo.getText();
        mparametros[1][0] = "Med";
        mparametros[1][1] = this.xsustancias;
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        Object[] botones = {"Reporte", "Anexos (Etanol en Sangre)", "Anexos (Droga en Orina)", "Cerrar"};
        int m = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        switch (m) {
            case 0:
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Autorizacion_Prueba_AyD_1", mparametros);
                break;
            case 1:
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_SO_RCustodia_PEtanol", mparametros);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_RCadenaCustodia_Etanol", mparametros);
                break;
            case 2:
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_SO_RCustodia_PDrogasOrina", mparametros);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_RCadenaCustodiaDrogas", mparametros);
                break;
        }
    }

    public long getIdPersona() {
        return this.IdPersona;
    }

    public void setIdPersona(long IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getxNCargo() {
        return this.xNCargo;
    }

    public void setxNCargo(String xNCargo) {
        this.xNCargo = xNCargo;
    }
}
