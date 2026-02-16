package Odontologia;

import Acceso.Principal;
import Historia.JPAAntecentesFamiliares;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPAAntecentesOdontologicos.class */
public class JPAAntecentesOdontologicos extends JPanel {
    private String[] xtipo;
    private String[] xtiporespuesta;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelohistorico;
    private DefaultTableModel xmodelohistoricoPC;
    private Metodos xmt;
    private ConsultasMySQL xct;
    private clasesHistoriaCE xclase;
    private Object[] xdato;
    private int xmod;
    public long xidusuario;
    private String xidatencion;
    private JIFHistoriaOdontologica xjifcho;
    private String xsql;
    private boolean xlleno;
    private String xnombre;
    private long x1;
    private long x2;
    private long x3;
    private long x4;
    private long x5;
    private long x6;
    private long x7;
    private long xmed;
    private DefaultTableModel xmodeloSoral;
    private ButtonGroup JBG1;
    private ButtonGroup JBG2;
    private ButtonGroup JBG3;
    private ButtonGroup JBG4;
    private ButtonGroup JBG5;
    private ButtonGroup JBG6;
    private ButtonGroup JBG7;
    private ButtonGroup JBG8Med;
    private JRadioButton JBGNO1;
    private JRadioButton JBGNO2;
    private JRadioButton JBGNO3;
    private JRadioButton JBGNO4;
    private JRadioButton JBGNO5;
    private JRadioButton JBGNO6;
    private JRadioButton JBGNO7;
    private JRadioButton JBGNO8;
    private JRadioButton JBGNO9;
    private JRadioButton JBGSI1;
    private JRadioButton JBGSI2;
    private JRadioButton JBGSI3;
    private JRadioButton JBGSI4;
    private JRadioButton JBGSI5;
    private JRadioButton JBGSI6;
    private JRadioButton JBGSI7;
    private JRadioButton JBGSI8;
    private ButtonGroup JBGVive;
    private JButton JBTAdicionarAntCli;
    private JButton JBTGuardar;
    private JButton JBTGuardarPC;
    public JComboBox JCBRespuesta;
    public JComboBox JCBTipo;
    private JPanel JPIAntecendesClinicos;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSPHistorial;
    private JScrollPane JSPHistorial1;
    private JScrollPane JSPHistorial2;
    private JTextArea JTAHabitosN;
    private JTextArea JTAMedicamentos;
    private JTextArea JTAObservacion;
    private JTextArea JTASitEspecial;
    private JTextField JTFNoDPerdidos;
    private JTextField JTFNoVCepillado;
    private JTextField JTFNoVSeda;
    private JTextField JTFTiempoEvol;
    private JTable JTHistorial;
    private JTable JTHistorialPacienteCronico;
    private JTable JTHistorialSaludOral;
    private JTextPane JTPDescripcion;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTabbedPane jTabbedPane1;

    public JPAAntecentesOdontologicos(clasesHistoriaCE xclase, int xmod, String xnombre) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xmod = -1;
        this.xlleno = false;
        this.xnombre = "";
        this.x1 = 2L;
        this.x2 = 2L;
        this.x3 = 2L;
        this.x4 = 2L;
        this.x5 = 2L;
        this.x6 = 2L;
        this.x7 = 0L;
        this.xmed = 2L;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        this.xnombre = xnombre;
        setName(xnombre);
        mNuevo();
        mVerificarExistencia();
        mBuscaHistoricoSOral();
        mBuscaHistoricoPC();
    }

    public JPAAntecentesOdontologicos(JIFHistoriaOdontologica xjifcho, int xmod) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xmod = -1;
        this.xlleno = false;
        this.xnombre = "";
        this.x1 = 2L;
        this.x2 = 2L;
        this.x3 = 2L;
        this.x4 = 2L;
        this.x5 = 2L;
        this.x6 = 2L;
        this.x7 = 0L;
        this.xmed = 2L;
        initComponents();
        this.xmod = xmod;
        this.xjifcho = xjifcho;
        mNuevo();
        mVerificarExistencia();
        mBuscaHistoricoSOral();
        mBuscaHistoricoPC();
    }

    public JPAAntecentesOdontologicos(String xid_persona, String xid_Atencion) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xmod = -1;
        this.xlleno = false;
        this.xnombre = "";
        this.x1 = 2L;
        this.x2 = 2L;
        this.x3 = 2L;
        this.x4 = 2L;
        this.x5 = 2L;
        this.x6 = 2L;
        this.x7 = 0L;
        this.xmed = 2L;
        initComponents();
        this.xidusuario = Long.valueOf(xid_persona).longValue();
        this.xidatencion = xid_Atencion;
        mNuevo();
        mVerificarExistencia();
        mBuscaHistoricoSOral();
        mBuscaHistoricoPC();
    }

    /* JADX WARN: Type inference failed for: r3v160, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v97, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGVive = new ButtonGroup();
        this.JBG1 = new ButtonGroup();
        this.JBG2 = new ButtonGroup();
        this.JBG3 = new ButtonGroup();
        this.JBG4 = new ButtonGroup();
        this.JBG5 = new ButtonGroup();
        this.JBG6 = new ButtonGroup();
        this.JBG7 = new ButtonGroup();
        this.JBG8Med = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JPIAntecendesClinicos = new JPanel();
        this.JCBTipo = new JComboBox();
        this.JCBRespuesta = new JComboBox();
        this.JSPDescripcion = new JScrollPane();
        this.JTPDescripcion = new JTextPane();
        this.JBTAdicionarAntCli = new JButton();
        this.JSPHistorial = new JScrollPane();
        this.JTHistorial = new JTable();
        this.jPanel2 = new JPanel();
        this.jPanel3 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.JBGSI1 = new JRadioButton();
        this.JBGNO1 = new JRadioButton();
        this.JBGSI2 = new JRadioButton();
        this.JBGNO2 = new JRadioButton();
        this.JBGSI3 = new JRadioButton();
        this.JBGNO3 = new JRadioButton();
        this.JBGSI4 = new JRadioButton();
        this.JBGNO4 = new JRadioButton();
        this.JBGSI5 = new JRadioButton();
        this.JBGNO5 = new JRadioButton();
        this.JTFNoVCepillado = new JTextField();
        this.JTFNoVSeda = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTAHabitosN = new JTextArea();
        this.jScrollPane2 = new JScrollPane();
        this.JTASitEspecial = new JTextArea();
        this.JBTGuardar = new JButton();
        this.JSPHistorial1 = new JScrollPane();
        this.JTHistorialSaludOral = new JTable();
        this.jPanel4 = new JPanel();
        this.jPanel5 = new JPanel();
        this.jLabel7 = new JLabel();
        this.JBGSI6 = new JRadioButton();
        this.JBGNO6 = new JRadioButton();
        this.jLabel8 = new JLabel();
        this.JTFNoDPerdidos = new JTextField();
        this.jLabel9 = new JLabel();
        this.JBGSI7 = new JRadioButton();
        this.JBGNO7 = new JRadioButton();
        this.JBGNO8 = new JRadioButton();
        this.jLabel10 = new JLabel();
        this.JTFTiempoEvol = new JTextField();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.JBGSI8 = new JRadioButton();
        this.JBGNO9 = new JRadioButton();
        this.jScrollPane3 = new JScrollPane();
        this.JTAMedicamentos = new JTextArea();
        this.jScrollPane4 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBTGuardarPC = new JButton();
        this.JSPHistorial2 = new JScrollPane();
        this.JTHistorialPacienteCronico = new JTable();
        setName("jifanteodontologicos");
        setPreferredSize(new Dimension(835, 386));
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPIAntecendesClinicos.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipo.setFont(new Font("Arial", 1, 12));
        this.JCBTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipo.addItemListener(new ItemListener() { // from class: Odontologia.JPAAntecentesOdontologicos.1
            public void itemStateChanged(ItemEvent evt) {
                JPAAntecentesOdontologicos.this.JCBTipoItemStateChanged(evt);
            }
        });
        this.JCBTipo.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPAAntecentesOdontologicos.2
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOdontologicos.this.JCBTipoKeyPressed(evt);
            }
        });
        this.JCBRespuesta.setFont(new Font("Arial", 1, 12));
        this.JCBRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Respuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRespuesta.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPAAntecentesOdontologicos.3
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOdontologicos.this.JCBRespuestaKeyPressed(evt);
            }
        });
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDescripcion.setFont(new Font("Arial", 1, 12));
        this.JTPDescripcion.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPAAntecentesOdontologicos.4
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOdontologicos.this.JTPDescripcionKeyPressed(evt);
            }
        });
        this.JSPDescripcion.setViewportView(this.JTPDescripcion);
        this.JBTAdicionarAntCli.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarAntCli.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarAntCli.setText("Guardar");
        this.JBTAdicionarAntCli.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.5
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBTAdicionarAntCliActionPerformed(evt);
            }
        });
        this.JBTAdicionarAntCli.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPAAntecentesOdontologicos.6
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOdontologicos.this.JBTAdicionarAntCliKeyPressed(evt);
            }
        });
        GroupLayout JPIAntecendesClinicosLayout = new GroupLayout(this.JPIAntecendesClinicos);
        this.JPIAntecendesClinicos.setLayout(JPIAntecendesClinicosLayout);
        JPIAntecendesClinicosLayout.setHorizontalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addContainerGap().addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDescripcion, -1, 786, 32767).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addComponent(this.JCBTipo, -2, 467, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRespuesta, 0, 313, 32767)).addComponent(this.JBTAdicionarAntCli, -1, 786, 32767)).addContainerGap()));
        JPIAntecendesClinicosLayout.setVerticalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipo, -2, -1, -2).addComponent(this.JCBRespuesta, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDescripcion, -2, 56, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarAntCli, -2, 43, -2)));
        this.JSPHistorial.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorial.setFont(new Font("Arial", 1, 12));
        this.JTHistorial.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorial.setRowHeight(25);
        this.JTHistorial.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorial.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorial.setSelectionMode(0);
        this.JTHistorial.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPAAntecentesOdontologicos.7
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOdontologicos.this.JTHistorialMouseClicked(evt);
            }
        });
        this.JSPHistorial.setViewportView(this.JTHistorial);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIAntecendesClinicos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPHistorial, GroupLayout.Alignment.TRAILING));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIAntecendesClinicos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorial, -2, 166, -2).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("ODONTOLÓGICOS", this.jPanel1);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Ha recibido Instrucciones en salud oral?");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Practica el cepillado a diario?");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Usa seda dental?");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("Se le ha aplicado Flúor?");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("Se han aplicado sellantes?");
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("SI               NO               No. Veces");
        this.JBG1.add(this.JBGSI1);
        this.JBGSI1.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.8
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGSI1ActionPerformed(evt);
            }
        });
        this.JBG1.add(this.JBGNO1);
        this.JBGNO1.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.9
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGNO1ActionPerformed(evt);
            }
        });
        this.JBG2.add(this.JBGSI2);
        this.JBGSI2.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.10
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGSI2ActionPerformed(evt);
            }
        });
        this.JBG2.add(this.JBGNO2);
        this.JBGNO2.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.11
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGNO2ActionPerformed(evt);
            }
        });
        this.JBG3.add(this.JBGSI3);
        this.JBGSI3.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.12
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGSI3ActionPerformed(evt);
            }
        });
        this.JBG3.add(this.JBGNO3);
        this.JBGNO3.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.13
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGNO3ActionPerformed(evt);
            }
        });
        this.JBG4.add(this.JBGSI4);
        this.JBGSI4.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.14
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGSI4ActionPerformed(evt);
            }
        });
        this.JBG4.add(this.JBGNO4);
        this.JBGNO4.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.15
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGNO4ActionPerformed(evt);
            }
        });
        this.JBG5.add(this.JBGSI5);
        this.JBGSI5.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.16
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGSI5ActionPerformed(evt);
            }
        });
        this.JBG5.add(this.JBGNO5);
        this.JBGNO5.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.17
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGNO5ActionPerformed(evt);
            }
        });
        this.JTFNoVCepillado.setHorizontalAlignment(4);
        this.JTFNoVCepillado.setText("0");
        this.JTFNoVSeda.setHorizontalAlignment(4);
        this.JTFNoVSeda.setText("0");
        this.JTAHabitosN.setColumns(1);
        this.JTAHabitosN.setFont(new Font("Arial", 0, 13));
        this.JTAHabitosN.setLineWrap(true);
        this.JTAHabitosN.setRows(1);
        this.JTAHabitosN.setBorder(BorderFactory.createTitledBorder((Border) null, "Presencia de hábitos nocivos:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAHabitosN);
        this.JTASitEspecial.setColumns(1);
        this.JTASitEspecial.setFont(new Font("Arial", 0, 13));
        this.JTASitEspecial.setLineWrap(true);
        this.JTASitEspecial.setRows(1);
        this.JTASitEspecial.setBorder(BorderFactory.createTitledBorder((Border) null, "Situaciones que requieren manejo especial: ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTASitEspecial);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel1, -1, -1, 32767).addComponent(this.jLabel3, GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, GroupLayout.Alignment.LEADING, -2, 145, -2).addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(37, 37, 37).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JBGSI2).addGap(35, 35, 35).addComponent(this.JBGNO2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JBGSI3).addGap(35, 35, 35).addComponent(this.JBGNO3))).addGap(40, 40, 40).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNoVSeda, -2, 60, -2).addComponent(this.JTFNoVCepillado, -2, 60, -2))).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JBGSI4).addGap(35, 35, 35).addComponent(this.JBGNO4)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JBGSI5).addGap(35, 35, 35).addComponent(this.JBGNO5)).addComponent(this.jLabel6, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -2, 294, -2).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -2, 294, -2))).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JBGSI1).addGap(35, 35, 35).addComponent(this.JBGNO1).addGap(0, 424, 32767))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel6).addGap(4, 4, 4).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addComponent(this.JBGSI1).addComponent(this.JBGNO1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2)).addComponent(this.JBGSI2).addComponent(this.JBGNO2).addComponent(this.JTFNoVCepillado, -2, -1, -2)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jLabel3)).addGroup(jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTFNoVSeda, -2, -1, -2)))).addComponent(this.JBGSI3).addComponent(this.JBGNO3)).addGap(11, 11, 11).addComponent(this.jLabel4)).addComponent(this.JBGSI4).addComponent(this.JBGNO4)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel5).addComponent(this.JBGSI5).addComponent(this.JBGNO5))).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 64, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 62, -2))).addGap(1, 1, 1)));
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.18
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPAAntecentesOdontologicos.19
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOdontologicos.this.JBTGuardarKeyPressed(evt);
            }
        });
        this.JSPHistorial1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorialSaludOral.setFont(new Font("Arial", 1, 12));
        this.JTHistorialSaludOral.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorialSaludOral.setRowHeight(25);
        this.JTHistorialSaludOral.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorialSaludOral.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorialSaludOral.setSelectionMode(0);
        this.JSPHistorial1.setViewportView(this.JTHistorialSaludOral);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.JBTGuardar, -1, -1, 32767).addComponent(this.JSPHistorial1)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorial1, -2, 119, -2).addContainerGap()));
        this.jTabbedPane1.addTab("PYP SALUD ORAL", this.jPanel2);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("Utiliza prótesis?");
        this.JBG6.add(this.JBGSI6);
        this.JBGSI6.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.20
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGSI6ActionPerformed(evt);
            }
        });
        this.JBG6.add(this.JBGNO6);
        this.JBGNO6.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.21
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGNO6ActionPerformed(evt);
            }
        });
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("Número de dientes perdidos:");
        this.JTFNoDPerdidos.setHorizontalAlignment(4);
        this.JTFNoDPerdidos.setText("0");
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("Clasificación:");
        this.JBG7.add(this.JBGSI7);
        this.JBGSI7.setFont(new Font("Arial", 1, 12));
        this.JBGSI7.setText("I");
        this.JBGSI7.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.22
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGSI7ActionPerformed(evt);
            }
        });
        this.JBG7.add(this.JBGNO7);
        this.JBGNO7.setFont(new Font("Arial", 1, 12));
        this.JBGNO7.setText("II");
        this.JBGNO7.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.23
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGNO7ActionPerformed(evt);
            }
        });
        this.JBG7.add(this.JBGNO8);
        this.JBGNO8.setFont(new Font("Arial", 1, 12));
        this.JBGNO8.setText("III");
        this.JBGNO8.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.24
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGNO8ActionPerformed(evt);
            }
        });
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("Tiempo de evolución:");
        this.JTFTiempoEvol.setHorizontalAlignment(4);
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("SI               NO");
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("Medicamentos?");
        this.JBG8Med.add(this.JBGSI8);
        this.JBGSI8.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.25
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGSI8ActionPerformed(evt);
            }
        });
        this.JBG8Med.add(this.JBGNO9);
        this.JBGNO9.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.26
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBGNO9ActionPerformed(evt);
            }
        });
        this.JTAMedicamentos.setColumns(1);
        this.JTAMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTAMedicamentos.setLineWrap(true);
        this.JTAMedicamentos.setRows(1);
        this.JTAMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuales medicamentos?", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setViewportView(this.JTAMedicamentos);
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane4.setViewportView(this.JTAObservacion);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel10, -2, 163, -2).addGap(103, 103, 103)).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel12, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel7, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel8, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel9, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(25, 25, 25))).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JTFTiempoEvol, -2, 102, -2).addGap(0, 0, 32767)).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11, -1, -1, 32767).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JBGSI8).addGap(35, 35, 35).addComponent(this.JBGNO9))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 397, -2)).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFNoDPerdidos, GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JBGSI6).addGap(35, 35, 35).addComponent(this.JBGNO6))).addGap(101, 101, 101)).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(117, 117, 117).addComponent(this.JBGNO8)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JBGSI7).addGap(27, 27, 27).addComponent(this.JBGNO7))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addComponent(this.jScrollPane4, -2, 321, -2))).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.JTFTiempoEvol, -2, -1, -2)).addGap(8, 8, 8).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBGSI8).addComponent(this.JBGNO9).addComponent(this.jLabel12))).addComponent(this.jScrollPane3, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBGSI6).addComponent(this.JBGNO6))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.JTFNoDPerdidos, -2, -1, -2)).addGap(11, 11, 11).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel9).addComponent(this.JBGSI7).addComponent(this.JBGNO7))).addComponent(this.JBGNO8).addComponent(this.jScrollPane4)).addContainerGap()));
        this.JBTGuardarPC.setFont(new Font("Arial", 1, 14));
        this.JBTGuardarPC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarPC.setText("Guardar");
        this.JBTGuardarPC.addActionListener(new ActionListener() { // from class: Odontologia.JPAAntecentesOdontologicos.27
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOdontologicos.this.JBTGuardarPCActionPerformed(evt);
            }
        });
        this.JBTGuardarPC.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPAAntecentesOdontologicos.28
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOdontologicos.this.JBTGuardarPCKeyPressed(evt);
            }
        });
        this.JSPHistorial2.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTHistorialPacienteCronico.setFont(new Font("Arial", 1, 12));
        this.JTHistorialPacienteCronico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorialPacienteCronico.setRowHeight(25);
        this.JTHistorialPacienteCronico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorialPacienteCronico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorialPacienteCronico.setSelectionMode(0);
        this.JSPHistorial2.setViewportView(this.JTHistorialPacienteCronico);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -1, -1, 32767).addComponent(this.JBTGuardarPC, -1, -1, 32767).addComponent(this.JSPHistorial2)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jPanel5, -2, 182, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardarPC, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorial2, -1, 87, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("PACIENTES CRÓNICOS", this.jPanel4);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jTabbedPane1, -2, 371, -2).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDescripcionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPDescripcion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRespuestaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipo.getSelectedIndex() != -1) {
            this.JCBRespuesta.removeAllItems();
            this.xsql = "SELECT o_tipo_descripcionxparametro.Id_TipoParametro, o_tipo_parametros.Nbre FROM o_tipo_contenidoxdescripcion INNER JOIN o_tipo_contenido  ON (o_tipo_contenidoxdescripcion.Id_tipo_contenido = o_tipo_contenido.Id) INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_contenidoxdescripcion.Id_tipo_adescripcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_descripcionxparametro  ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_contenidoxdescripcion.Id ='" + this.xtipo[this.JCBTipo.getSelectedIndex()] + "' AND o_tipo_descripcionxparametro.Estado =1) GROUP BY o_tipo_descripcionxparametro.Id_TipoParametro  ORDER BY o_tipo_descripcionxparametro.NOrden ASC ";
            this.xtiporespuesta = this.xct.llenarCombo(this.xsql, this.xtiporespuesta, this.JCBRespuesta);
            this.JCBRespuesta.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorialMouseClicked(MouseEvent evt) {
        if (this.JTHistorial.getSelectedRow() != -1) {
            this.JCBTipo.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 0));
            this.JCBRespuesta.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 1));
            this.JTPDescripcion.setText(this.xmodelo.getValueAt(this.JTHistorial.getSelectedRow(), 2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGSI3ActionPerformed(ActionEvent evt) {
        this.x3 = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGSI4ActionPerformed(ActionEvent evt) {
        this.x4 = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGSI5ActionPerformed(ActionEvent evt) {
        this.x5 = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGSI1ActionPerformed(ActionEvent evt) {
        this.x1 = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGNO1ActionPerformed(ActionEvent evt) {
        this.x1 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGSI2ActionPerformed(ActionEvent evt) {
        this.x2 = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGNO2ActionPerformed(ActionEvent evt) {
        this.x2 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGNO3ActionPerformed(ActionEvent evt) {
        this.x3 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGNO4ActionPerformed(ActionEvent evt) {
        this.x4 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGNO5ActionPerformed(ActionEvent evt) {
        this.x5 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    private void mVerificarExistencia() {
        String sql = "SELECT  `id` , `IdUsuario` , `IdAtencion` FROM `h_antecedentes_salud_oral` WHERE (`IdAtencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JBTGuardar.setEnabled(false);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOdontologicos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        String sql2 = "SELECT  `id` , `IdUsuario` , `IdAtencion` FROM `h_antecedentes_paciente_cronico` WHERE (`IdAtencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
        ResultSet xrs2 = this.xct.traerRs(sql2);
        try {
            if (xrs2.next()) {
                xrs2.first();
                this.JBTGuardarPC.setEnabled(false);
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex2) {
            Logger.getLogger(JPAAntecentesOdontologicos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGSI6ActionPerformed(ActionEvent evt) {
        this.x6 = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGNO6ActionPerformed(ActionEvent evt) {
        this.x6 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGSI7ActionPerformed(ActionEvent evt) {
        this.x7 = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGNO7ActionPerformed(ActionEvent evt) {
        this.x7 = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGNO8ActionPerformed(ActionEvent evt) {
        this.x7 = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGSI8ActionPerformed(ActionEvent evt) {
        this.xmed = 1L;
        this.JTAMedicamentos.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGNO9ActionPerformed(ActionEvent evt) {
        this.xmed = 0L;
        this.JTAMedicamentos.setEnabled(false);
        this.JTAMedicamentos.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarPCActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarPCKeyPressed(KeyEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo", "Respuesta", "Descripción"}) { // from class: Odontologia.JPAAntecentesOdontologicos.29
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorial.setModel(this.xmodelo);
        this.JTHistorial.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTHistorial.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistorial.getColumnModel().getColumn(2).setPreferredWidth(250);
    }

    private void mBuscarDatos() {
    }

    private void mBuscarDatosBd() {
        int xtipo;
        try {
            if (this.xnombre.equals("jifhdentarios")) {
                xtipo = 9;
            } else {
                xtipo = 1;
            }
            String sql = "SELECT o_tipo_contenido_descripcion.Nbre, o_tipo_parametros.Nbre, h_antecedenteodontologico.Despcripcion FROM h_antecedenteodontologico INNER JOIN o_tipo_contenidoxdescripcion  ON (h_antecedenteodontologico.Id_Tipo_ContDresc = o_tipo_contenidoxdescripcion.Id) INNER JOIN o_tipo_parametros  ON (h_antecedenteodontologico.Id_TipoParametro = o_tipo_parametros.Id) INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_contenidoxdescripcion.Id_tipo_adescripcion = o_tipo_contenido_descripcion.Id)  WHERE (o_tipo_contenidoxdescripcion.Id_tipo_contenido ='" + xtipo + "' AND h_antecedenteodontologico.Id_Usuario ='" + this.xidusuario + "') ORDER BY o_tipo_contenido_descripcion.Nbre ASC ";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesFamiliares.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabarBd() {
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            if (this.JCBTipo.getSelectedIndex() != -1) {
                if (this.JCBRespuesta.getSelectedIndex() != -1) {
                    if (!this.JTPDescripcion.getText().isEmpty()) {
                        this.xsql = "insert ignore into  h_antecedenteodontologico(Id_Usuario, Id_Tipo_ContDresc, Id_Atencion, Id_TipoParametro, Despcripcion, UsuarioS) values( '" + this.xidusuario + "','" + this.xtipo[this.JCBTipo.getSelectedIndex()] + "','" + this.xidatencion + "','" + this.xtiporespuesta[this.JCBRespuesta.getSelectedIndex()] + "','" + this.JTPDescripcion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        System.out.println("odontologicos  " + this.xsql);
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mCrearTabla();
                        mBuscarDatosBd();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "La descripcion \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTPDescripcion.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar \n un tipo de respuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar \n un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipo.requestFocus();
            return;
        }
        if (this.jTabbedPane1.getSelectedIndex() == 1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "INSERT INTO `h_antecedentes_salud_oral` ( `IdUsuario`, `IdAtencion`, `InstSOral`, `Cepillado`, `NoVecesCep`, `SedaDental`,  `NoVecesSeda`, `Fluor`, `Sellantes`, `HabNocivos`, `ManEspecial`,UsuarioS)  VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + this.x1 + "', '" + this.x2 + "', '" + this.JTFNoVCepillado.getText() + "',  '" + this.x3 + "', '" + this.JTFNoVSeda.getText() + "',  '" + this.x4 + "', '" + this.x5 + "', '" + this.JTAHabitosN.getText() + "', '" + this.JTASitEspecial.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                mBuscaHistoricoSOral();
                this.JBTGuardar.setEnabled(false);
                return;
            }
            return;
        }
        if (this.jTabbedPane1.getSelectedIndex() == 2) {
            int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n2 == 0) {
                String sql2 = "INSERT INTO `h_antecedentes_paciente_cronico` (`IdUsuario`,`IdAtencion`,TEvolucion, Medicamento,CualMed,protesis,DientesPerdidos,Clasificacion, Observacion ,UsuarioS)  VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + this.JTFTiempoEvol.getText() + "', '" + this.xmed + "', '" + this.JTAMedicamentos.getText() + "',  '" + this.x6 + "','" + this.JTFNoDPerdidos.getText() + "','" + this.x7 + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
                mBuscaHistoricoPC();
                this.JBTGuardar.setEnabled(false);
            }
        }
    }

    public void mNuevo() {
        if (this.xmod == 0) {
            this.xidusuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue();
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        } else if (this.xmod == 0) {
            System.out.println(this.xjifcho.xjppersona.getIdPersona());
            if (!this.xjifcho.xjppersona.getIdPersona().equals("0")) {
                this.xidusuario = Long.valueOf(this.xjifcho.xjppersona.getIdPersona()).longValue();
            }
            this.xidatencion = "0";
        }
        mCrearTabla();
        mBuscarDatosBd();
        mCargarCombo();
        this.JTAMedicamentos.setEnabled(false);
        if (this.xnombre.equals("jifhdentarios")) {
            this.jTabbedPane1.remove(1);
            this.jTabbedPane1.remove(1);
        }
    }

    private void mCargarCombo() {
        int xtipo;
        if (this.xnombre.equals("jifhdentarios")) {
            xtipo = 9;
        } else {
            xtipo = 1;
        }
        this.xsql = "SELECT o_tipo_contenidoxdescripcion.Id, o_tipo_contenido_descripcion.Nbre FROM o_tipo_contenidoxdescripcion INNER JOIN o_tipo_contenido  ON (o_tipo_contenidoxdescripcion.Id_tipo_contenido = o_tipo_contenido.Id) INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_contenidoxdescripcion.Id_tipo_adescripcion = o_tipo_contenido_descripcion.Id) WHERE (o_tipo_contenidoxdescripcion.Estado =1 AND o_tipo_contenido.Id ='" + xtipo + "') ORDER BY o_tipo_contenidoxdescripcion.NOrden ASC ";
        this.xtipo = this.xct.llenarCombo(this.xsql, this.xtipo, this.JCBTipo);
        this.JCBTipo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistorico() {
        this.xmodelohistorico = new DefaultTableModel(new Object[0], new String[]{"Ha recibido Instrucciones en salud oral?", "Practica el cepillado a diario?", "No. veces", "Usa seda dental?", "No. veces", "Se le ha aplicado Flúor?", "Se han aplicado sellantes?", "Presencia de hábitos nocivos", "Situaciones que requieran manejo especial"}) { // from class: Odontologia.JPAAntecentesOdontologicos.30
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorialSaludOral.setModel(this.xmodelohistorico);
        this.JTHistorialSaludOral.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTHistorialSaludOral.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorialSaludOral.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTHistorialSaludOral.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTHistorialSaludOral.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTHistorialSaludOral.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTHistorialSaludOral.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTHistorialSaludOral.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTHistorialSaludOral.getColumnModel().getColumn(8).setPreferredWidth(30);
    }

    private void mBuscaHistoricoSOral() {
        mCrearTablaHistorico();
        String sql = "SELECT  IF(`InstSOral`=0,'NO', IF(`InstSOral`=1,'SI','')) AS InstSOral, IF(`Cepillado`=0,'NO',IF(`Cepillado`=1,'SI','')) AS Cepillado, `NoVecesCep`,  IF(`SedaDental`=0,'NO',IF(`SedaDental`=1,'SI','')) AS SedaDental, `NoVecesSeda`, IF(`Fluor`=0,'NO',IF(`Fluor`=1,'SI','')) AS Fluor, IF(`Sellantes`=0,'NO',IF(`Sellantes`=1,'SI','')) AS Sellantes,   `HabNocivos`, `ManEspecial`  FROM `h_antecedentes_salud_oral` where IdUsuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelohistorico.addRow(this.xdato);
                    this.xmodelohistorico.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelohistorico.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelohistorico.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelohistorico.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelohistorico.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelohistorico.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelohistorico.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelohistorico.setValueAt(xrs.getString(8), x, 7);
                    this.xmodelohistorico.setValueAt(xrs.getString(9), x, 8);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOdontologicos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistoricoPC() {
        this.xmodelohistoricoPC = new DefaultTableModel(new Object[0], new String[]{"Fecha Atención", "Tiempo de evolución", "Medicamentos?", "Cuales?", "Utiliza prótesis?", "No. dientes perdidos", "Clasificación", "Observación"}) { // from class: Odontologia.JPAAntecentesOdontologicos.31
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorialPacienteCronico.setModel(this.xmodelohistoricoPC);
        this.JTHistorialPacienteCronico.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTHistorialPacienteCronico.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorialPacienteCronico.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTHistorialPacienteCronico.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTHistorialPacienteCronico.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTHistorialPacienteCronico.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTHistorialPacienteCronico.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTHistorialPacienteCronico.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    private void mBuscaHistoricoPC() {
        mCrearTablaHistoricoPC();
        String sql = "SELECT  DATE_FORMAT(Fecha,'%d-%m-%Y') AS Fecha,TEvolucion,IF(Medicamento=0,'No',IF(Medicamento=1,'Si',''))AS Medicamento ,CualMed,IF(`protesis`=0,'NO',IF(`protesis`=1,'SI','')) AS protesis, `DientesPerdidos`, IF(`Clasificacion`=1,'I',IF(`Clasificacion`=2,'II',IF(`Clasificacion`=3,'III',''))) AS Clasificacion,Observacion  FROM `h_antecedentes_paciente_cronico` where IdUsuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelohistoricoPC.addRow(this.xdato);
                    this.xmodelohistoricoPC.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelohistoricoPC.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelohistoricoPC.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelohistoricoPC.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelohistoricoPC.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelohistoricoPC.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelohistoricoPC.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelohistoricoPC.setValueAt(xrs.getString(8), x, 7);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOdontologicos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
