package Historia;

import Acceso.Principal;
import Odontologia.JIFHistoriaOdontologica;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAntecentesHabitos.class */
public class JPAAntecentesHabitos extends JPanel {
    Metodos xmetodos;
    private String[] idfrecdeportiva;
    private String[] idfrecalcohol;
    private String[][] idcantidacigarrillo;
    private Object jifhistoriaclinica;
    private Object jfprincipal;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloh;
    private DefaultTableModel xmodelofuncion;
    private DefaultTableModel xmodelotipoactividad;
    private int xpdeporte;
    private int xencontro;
    private int xexfumador;
    private int xsicoactivas;
    private int xtrabajo;
    private int xalcohol;
    private int xlleno;
    private int xfuma;
    private int xhumol;
    private int xmod;
    public long xidusuario;
    private String xidatencion;
    private Metodos xmetodo;
    private ConsultasMySQL xconsultasbd;
    private clasesHistoriaCE xclase;
    private JIFHistoriaOdontologica xjifcho1;
    private Object[] xdato;
    private String xhabito;
    private ButtonGroup JBGAlcohol;
    private ButtonGroup JBGExFumador;
    private ButtonGroup JBGHumoLena;
    private ButtonGroup JBGPDeporte;
    private ButtonGroup JBGPTrabajo;
    private ButtonGroup JBGSicoactivas;
    private JButton JBTAdicionarAntCli;
    public JComboBox JCBActividadFisica;
    public JComboBox JCBDuracion;
    public JComboBox JCBFrecuenciaAlcohol;
    public JComboBox JCBFrecuenciaDeportiva;
    public JComboBox JCBFuma;
    public JComboBox JCBIntencidad;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    public JDateChooser JDCFechaInicioF;
    private JPanel JPActividadFisica;
    private JPanel JPExFumador;
    private JPanel JPHistorico;
    private JPanel JPHumoLena;
    private JPanel JPIAntecendesClinicos;
    private JRadioButton JRBAlcholNo;
    private JRadioButton JRBAlcholSi;
    private JRadioButton JRBEFNo;
    private JRadioButton JRBEFNo_Trabajo;
    private JRadioButton JRBEFNo_sicoactivas;
    private JRadioButton JRBEFSi;
    private JRadioButton JRBEFSi_Trabajo;
    private JRadioButton JRBEFSi_sicoactivas;
    private JRadioButton JRBHLNo;
    private JRadioButton JRBHLSi;
    private JRadioButton JRBPDNo;
    public JRadioButton JRBPDSi;
    private JScrollPane JSPActividadesAlt;
    private JScrollPane JSPFunciones;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacionesAlcohol;
    private JScrollPane JSPObservacionesFuma;
    private JScrollPane JSPTipoActividad;
    private JTable JTActividadesAlt;
    private JLabel JTFFAnosFumF;
    private JTextField JTFFAnosFumador;
    private JFormattedTextField JTFFCualAlcohol;
    private JFormattedTextField JTFFCualDeporte;
    private JTextField JTFFFechaFin;
    private JTextField JTFFFechaInicio;
    private JTextField JTFFFechaInicioF;
    public JTextField JTFNRegistro;
    public JTextField JTFTrabajo;
    private JTable JTFunciones;
    private JTable JTHistorico;
    private JTabbedPane JTPHabitos;
    private JTextPane JTPObservacionesAlcohol;
    private JTextPane JTPObservacionesFuma;
    private JTable JTTipoActividad;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;

    public JPAAntecentesHabitos(clasesHistoriaCE xclase, int xmod) {
        this.xmetodos = new Metodos();
        this.xpdeporte = 0;
        this.xencontro = 0;
        this.xexfumador = 0;
        this.xsicoactivas = 0;
        this.xtrabajo = 0;
        this.xalcohol = 0;
        this.xlleno = 0;
        this.xfuma = 0;
        this.xhumol = 0;
        this.xmod = -1;
        this.xidusuario = 0L;
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        initComponents();
        this.xclase = xclase;
        this.xmod = xmod;
        mNuevo();
    }

    public JPAAntecentesHabitos(JIFHistoriaOdontologica xjifcho1, int xmod) {
        this.xmetodos = new Metodos();
        this.xpdeporte = 0;
        this.xencontro = 0;
        this.xexfumador = 0;
        this.xsicoactivas = 0;
        this.xtrabajo = 0;
        this.xalcohol = 0;
        this.xlleno = 0;
        this.xfuma = 0;
        this.xhumol = 0;
        this.xmod = -1;
        this.xidusuario = 0L;
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        initComponents();
        this.xmod = xmod;
        this.xjifcho1 = xjifcho1;
        mNuevo();
    }

    public JPAAntecentesHabitos(String xid_persona, String xid_Atencion) {
        this.xmetodos = new Metodos();
        this.xpdeporte = 0;
        this.xencontro = 0;
        this.xexfumador = 0;
        this.xsicoactivas = 0;
        this.xtrabajo = 0;
        this.xalcohol = 0;
        this.xlleno = 0;
        this.xfuma = 0;
        this.xhumol = 0;
        this.xmod = -1;
        this.xidusuario = 0L;
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        initComponents();
        this.xidusuario = Long.valueOf(xid_persona).longValue();
        this.xidatencion = xid_Atencion;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v170, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v274, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v280, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v300, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGPDeporte = new ButtonGroup();
        this.JBGExFumador = new ButtonGroup();
        this.JBGAlcohol = new ButtonGroup();
        this.JBGHumoLena = new ButtonGroup();
        this.JBGSicoactivas = new ButtonGroup();
        this.JBGPTrabajo = new ButtonGroup();
        this.JTPHabitos = new JTabbedPane();
        this.JPIAntecendesClinicos = new JPanel();
        this.jPanel3 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JRBPDSi = new JRadioButton();
        this.JRBPDNo = new JRadioButton();
        this.JTFFCualDeporte = new JFormattedTextField();
        this.JCBFrecuenciaDeportiva = new JComboBox();
        this.jPanel8 = new JPanel();
        this.JRBEFSi_sicoactivas = new JRadioButton();
        this.JRBEFNo_sicoactivas = new JRadioButton();
        this.jPanel6 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JRBAlcholSi = new JRadioButton();
        this.JRBAlcholNo = new JRadioButton();
        this.JTFFCualAlcohol = new JFormattedTextField();
        this.JCBFrecuenciaAlcohol = new JComboBox();
        this.JSPObservacionesAlcohol = new JScrollPane();
        this.JTPObservacionesAlcohol = new JTextPane();
        this.jPanel7 = new JPanel();
        this.jPanel4 = new JPanel();
        this.JCBFuma = new JComboBox();
        this.JSPObservacionesFuma = new JScrollPane();
        this.JTPObservacionesFuma = new JTextPane();
        this.JPHumoLena = new JPanel();
        this.JRBHLSi = new JRadioButton();
        this.JRBHLNo = new JRadioButton();
        this.jPanel9 = new JPanel();
        this.JRBEFSi_Trabajo = new JRadioButton();
        this.JRBEFNo_Trabajo = new JRadioButton();
        this.JTFTrabajo = new JTextField();
        this.JSPActividadesAlt = new JScrollPane();
        this.JTActividadesAlt = new JTable();
        this.JPExFumador = new JPanel();
        this.jPanel5 = new JPanel();
        this.JRBEFSi = new JRadioButton();
        this.JRBEFNo = new JRadioButton();
        this.JTFFAnosFumador = new JTextField();
        this.JTFFFechaFin = new JTextField();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JTFFFechaInicio = new JTextField();
        this.JTFFAnosFumF = new JLabel();
        this.JDCFechaInicioF = new JDateChooser();
        this.JTFFFechaInicioF = new JTextField();
        this.JPActividadFisica = new JPanel();
        this.JCBActividadFisica = new JComboBox();
        this.JCBIntencidad = new JComboBox();
        this.JCBDuracion = new JComboBox();
        this.JSPFunciones = new JScrollPane();
        this.JTFunciones = new JTable();
        this.JSPTipoActividad = new JScrollPane();
        this.JTTipoActividad = new JTable();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JBTAdicionarAntCli = new JButton();
        this.JTFNRegistro = new JTextField();
        setName("jpaantecedenteshabitos");
        setPreferredSize(new Dimension(834, 450));
        addAncestorListener(new AncestorListener() { // from class: Historia.JPAAntecentesHabitos.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAAntecentesHabitos.this.formAncestorRemoved(evt);
            }
        });
        this.JTPHabitos.setForeground(new Color(0, 103, 0));
        this.JTPHabitos.setFont(new Font("Arial", 1, 14));
        this.JPIAntecendesClinicos.setForeground(new Color(0, 0, 102));
        this.JPIAntecendesClinicos.setPreferredSize(new Dimension(835, 679));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTIVIDAD FÍSICA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        this.JBGPDeporte.add(this.JRBPDSi);
        this.JRBPDSi.setFont(new Font("Arial", 1, 12));
        this.JRBPDSi.setForeground(Color.blue);
        this.JRBPDSi.setText("Si");
        this.JRBPDSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.2
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBPDSiActionPerformed(evt);
            }
        });
        this.JRBPDSi.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.3
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBPDSiKeyPressed(evt);
            }
        });
        this.JBGPDeporte.add(this.JRBPDNo);
        this.JRBPDNo.setFont(new Font("Arial", 1, 12));
        this.JRBPDNo.setForeground(Color.blue);
        this.JRBPDNo.setSelected(true);
        this.JRBPDNo.setText("No");
        this.JRBPDNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.4
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBPDNoActionPerformed(evt);
            }
        });
        this.JRBPDNo.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.5
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBPDNoKeyPressed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBPDSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBPDNo).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPDSi).addComponent(this.JRBPDNo))));
        this.JTFFCualDeporte.setEditable(false);
        this.JTFFCualDeporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Cual", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCualDeporte.setFont(new Font("Arial", 1, 12));
        this.JTFFCualDeporte.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.6
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JTFFCualDeporteKeyPressed(evt);
            }
        });
        this.JCBFrecuenciaDeportiva.setFont(new Font("Arial", 1, 12));
        this.JCBFrecuenciaDeportiva.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFrecuenciaDeportiva.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.7
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JCBFrecuenciaDeportivaKeyPressed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCualDeporte, -1, 254, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFrecuenciaDeportiva, -2, 393, -2).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCualDeporte).addComponent(this.JCBFrecuenciaDeportiva))).addGap(21, 21, 21)));
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "Sustancias Psicoactivas?", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGSicoactivas.add(this.JRBEFSi_sicoactivas);
        this.JRBEFSi_sicoactivas.setFont(new Font("Arial", 1, 12));
        this.JRBEFSi_sicoactivas.setForeground(Color.blue);
        this.JRBEFSi_sicoactivas.setText("Si");
        this.JRBEFSi_sicoactivas.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.8
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBEFSi_sicoactivasActionPerformed(evt);
            }
        });
        this.JRBEFSi_sicoactivas.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.9
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBEFSi_sicoactivasKeyPressed(evt);
            }
        });
        this.JBGSicoactivas.add(this.JRBEFNo_sicoactivas);
        this.JRBEFNo_sicoactivas.setFont(new Font("Arial", 1, 12));
        this.JRBEFNo_sicoactivas.setForeground(Color.blue);
        this.JRBEFNo_sicoactivas.setSelected(true);
        this.JRBEFNo_sicoactivas.setText("No");
        this.JRBEFNo_sicoactivas.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.10
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBEFNo_sicoactivasActionPerformed(evt);
            }
        });
        this.JRBEFNo_sicoactivas.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.11
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBEFNo_sicoactivasKeyPressed(evt);
            }
        });
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBEFSi_sicoactivas).addGap(32, 32, 32).addComponent(this.JRBEFNo_sicoactivas).addContainerGap(36, 32767)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEFSi_sicoactivas).addComponent(this.JRBEFNo_sicoactivas)).addContainerGap(-1, 32767)));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSUME ALCOHOL", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.JBGAlcohol.add(this.JRBAlcholSi);
        this.JRBAlcholSi.setFont(new Font("Arial", 1, 12));
        this.JRBAlcholSi.setForeground(Color.blue);
        this.JRBAlcholSi.setText("Si");
        this.JRBAlcholSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.12
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBAlcholSiActionPerformed(evt);
            }
        });
        this.JRBAlcholSi.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.13
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBAlcholSiKeyPressed(evt);
            }
        });
        this.JBGAlcohol.add(this.JRBAlcholNo);
        this.JRBAlcholNo.setFont(new Font("Arial", 1, 12));
        this.JRBAlcholNo.setForeground(Color.blue);
        this.JRBAlcholNo.setSelected(true);
        this.JRBAlcholNo.setText("No");
        this.JRBAlcholNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.14
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBAlcholNoActionPerformed(evt);
            }
        });
        this.JRBAlcholNo.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.15
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBAlcholNoKeyPressed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBAlcholSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAlcholNo).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAlcholSi).addComponent(this.JRBAlcholNo))));
        this.JTFFCualAlcohol.setEditable(false);
        this.JTFFCualAlcohol.setBorder(BorderFactory.createTitledBorder((Border) null, "Cual?", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCualAlcohol.setFont(new Font("Arial", 1, 12));
        this.JTFFCualAlcohol.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.16
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JTFFCualAlcoholKeyPressed(evt);
            }
        });
        this.JCBFrecuenciaAlcohol.setFont(new Font("Arial", 1, 12));
        this.JCBFrecuenciaAlcohol.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFrecuenciaAlcohol.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.17
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JCBFrecuenciaAlcoholKeyPressed(evt);
            }
        });
        this.JSPObservacionesAlcohol.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacionesAlcohol.setFont(new Font("Arial", 1, 12));
        this.JTPObservacionesAlcohol.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.18
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JTPObservacionesAlcoholKeyPressed(evt);
            }
        });
        this.JSPObservacionesAlcohol.setViewportView(this.JTPObservacionesAlcohol);
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFCualAlcohol, -1, 347, 32767).addGap(18, 18, 18).addComponent(this.JCBFrecuenciaAlcohol, -2, 268, -2).addGap(36, 36, 36)).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacionesAlcohol, -1, 755, 32767).addGap(12, 12, 12)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFCualAlcohol, GroupLayout.Alignment.LEADING, 0, 0, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBFrecuenciaAlcohol, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionesAlcohol, -1, 62, 32767).addContainerGap()));
        GroupLayout JPIAntecendesClinicosLayout = new GroupLayout(this.JPIAntecendesClinicos);
        this.JPIAntecendesClinicos.setLayout(JPIAntecendesClinicosLayout);
        JPIAntecendesClinicosLayout.setHorizontalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addContainerGap().addGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel6, -1, -1, 32767).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addComponent(this.jPanel8, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIAntecendesClinicosLayout.setVerticalGroup(JPIAntecendesClinicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAntecendesClinicosLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel8, -2, 50, -2).addContainerGap(25, 32767)));
        this.JTPHabitos.addTab("PRIMERA", this.JPIAntecendesClinicos);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "FUMA ?", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBFuma.setFont(new Font("Arial", 1, 12));
        this.JCBFuma.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFuma.addItemListener(new ItemListener() { // from class: Historia.JPAAntecentesHabitos.19
            public void itemStateChanged(ItemEvent evt) {
                JPAAntecentesHabitos.this.JCBFumaItemStateChanged(evt);
            }
        });
        this.JCBFuma.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.20
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JCBFumaKeyPressed(evt);
            }
        });
        this.JSPObservacionesFuma.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacionesFuma.setFont(new Font("Arial", 1, 12));
        this.JTPObservacionesFuma.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.21
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JTPObservacionesFumaKeyPressed(evt);
            }
        });
        this.JSPObservacionesFuma.setViewportView(this.JTPObservacionesFuma);
        this.JPHumoLena.setBorder(BorderFactory.createTitledBorder((Border) null, "Humo Leña?", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGHumoLena.add(this.JRBHLSi);
        this.JRBHLSi.setFont(new Font("Arial", 1, 12));
        this.JRBHLSi.setForeground(Color.blue);
        this.JRBHLSi.setText("Si");
        this.JRBHLSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.22
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBHLSiActionPerformed(evt);
            }
        });
        this.JRBHLSi.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.23
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBHLSiKeyPressed(evt);
            }
        });
        this.JBGHumoLena.add(this.JRBHLNo);
        this.JRBHLNo.setFont(new Font("Arial", 1, 12));
        this.JRBHLNo.setForeground(Color.blue);
        this.JRBHLNo.setSelected(true);
        this.JRBHLNo.setText("No");
        this.JRBHLNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.24
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBHLNoActionPerformed(evt);
            }
        });
        this.JRBHLNo.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.25
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBHLNoKeyPressed(evt);
            }
        });
        GroupLayout JPHumoLenaLayout = new GroupLayout(this.JPHumoLena);
        this.JPHumoLena.setLayout(JPHumoLenaLayout);
        JPHumoLenaLayout.setHorizontalGroup(JPHumoLenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHumoLenaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBHLSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBHLNo).addContainerGap(-1, 32767)));
        JPHumoLenaLayout.setVerticalGroup(JPHumoLenaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHumoLenaLayout.createSequentialGroup().addGroup(JPHumoLenaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBHLSi).addComponent(this.JRBHLNo)).addContainerGap(-1, 32767)));
        this.jPanel9.setBorder(BorderFactory.createTitledBorder((Border) null, "Desempeña otro trabajo?", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGPTrabajo.add(this.JRBEFSi_Trabajo);
        this.JRBEFSi_Trabajo.setFont(new Font("Arial", 1, 12));
        this.JRBEFSi_Trabajo.setForeground(Color.blue);
        this.JRBEFSi_Trabajo.setText("Si");
        this.JRBEFSi_Trabajo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.26
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBEFSi_TrabajoActionPerformed(evt);
            }
        });
        this.JRBEFSi_Trabajo.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.27
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBEFSi_TrabajoKeyPressed(evt);
            }
        });
        this.JBGPTrabajo.add(this.JRBEFNo_Trabajo);
        this.JRBEFNo_Trabajo.setFont(new Font("Arial", 1, 12));
        this.JRBEFNo_Trabajo.setForeground(Color.blue);
        this.JRBEFNo_Trabajo.setSelected(true);
        this.JRBEFNo_Trabajo.setText("No");
        this.JRBEFNo_Trabajo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.28
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBEFNo_TrabajoActionPerformed(evt);
            }
        });
        this.JRBEFNo_Trabajo.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.29
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBEFNo_TrabajoKeyPressed(evt);
            }
        });
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBEFSi_Trabajo).addGap(32, 32, 32).addComponent(this.JRBEFNo_Trabajo).addContainerGap(41, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEFSi_Trabajo).addComponent(this.JRBEFNo_Trabajo)));
        this.JTFTrabajo.setFont(new Font("Arial", 1, 12));
        this.JTFTrabajo.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción otro trabajo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTrabajo.setEnabled(false);
        this.JSPActividadesAlt.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividades Alternas", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTActividadesAlt.setFont(new Font("Arial", 1, 12));
        this.JTActividadesAlt.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTActividadesAlt.setToolTipText("este es un comentario de la Tabla");
        this.JTActividadesAlt.setSelectionBackground(new Color(255, 255, 255));
        this.JTActividadesAlt.setSelectionForeground(new Color(255, 0, 0));
        this.JSPActividadesAlt.setViewportView(this.JTActividadesAlt);
        this.JPExFumador.setBorder(BorderFactory.createTitledBorder((Border) null, "ExFumador?", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGExFumador.add(this.JRBEFSi);
        this.JRBEFSi.setFont(new Font("Arial", 1, 12));
        this.JRBEFSi.setForeground(Color.blue);
        this.JRBEFSi.setText("Si");
        this.JRBEFSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.30
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBEFSiActionPerformed(evt);
            }
        });
        this.JRBEFSi.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.31
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBEFSiKeyPressed(evt);
            }
        });
        this.JBGExFumador.add(this.JRBEFNo);
        this.JRBEFNo.setFont(new Font("Arial", 1, 12));
        this.JRBEFNo.setForeground(Color.blue);
        this.JRBEFNo.setSelected(true);
        this.JRBEFNo.setText("No");
        this.JRBEFNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.32
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JRBEFNoActionPerformed(evt);
            }
        });
        this.JRBEFNo.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.33
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JRBEFNoKeyPressed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBEFSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEFNo).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEFSi).addComponent(this.JRBEFNo)).addGap(3, 3, 3)));
        this.JTFFAnosFumador.setFont(new Font("Arial", 1, 12));
        this.JTFFAnosFumador.setHorizontalAlignment(0);
        this.JTFFAnosFumador.setText("0");
        this.JTFFAnosFumador.setBorder(BorderFactory.createTitledBorder((Border) null, "Años?", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFAnosFumador.setEnabled(false);
        this.JTFFFechaFin.setFont(new Font("Arial", 1, 12));
        this.JTFFFechaFin.setText(" ");
        this.JTFFFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFechaFin.setEnabled(false);
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 11), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setEnabled(false);
        this.JDCFechaInicio.setFont(new Font("Tahoma", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecentesHabitos.34
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecentesHabitos.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 11), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setEnabled(false);
        this.JDCFechaFin.setFont(new Font("Tahoma", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecentesHabitos.35
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecentesHabitos.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JTFFFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JTFFFechaInicio.setText(" ");
        this.JTFFFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFechaInicio.setEnabled(false);
        GroupLayout JPExFumadorLayout = new GroupLayout(this.JPExFumador);
        this.JPExFumador.setLayout(JPExFumadorLayout);
        JPExFumadorLayout.setHorizontalGroup(JPExFumadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExFumadorLayout.createSequentialGroup().addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFechaInicio, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaInicio, -2, 28, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFFechaFin, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaFin, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFAnosFumador, -2, 75, -2).addGap(18, 18, 18)));
        JPExFumadorLayout.setVerticalGroup(JPExFumadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExFumadorLayout.createSequentialGroup().addGroup(JPExFumadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -2, -1, -2).addGroup(JPExFumadorLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDCFechaInicio, -2, 41, -2).addGroup(JPExFumadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFAnosFumador, GroupLayout.Alignment.TRAILING, -1, 42, 32767).addComponent(this.JTFFFechaFin, GroupLayout.Alignment.TRAILING, -1, 42, 32767).addComponent(this.JDCFechaFin, GroupLayout.Alignment.TRAILING, -1, -1, 32767))).addGroup(JPExFumadorLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JTFFFechaInicio, -2, 42, -2))).addGap(3, 3, 3)));
        this.JTFFAnosFumF.setFont(new Font("Arial", 1, 12));
        this.JTFFAnosFumF.setHorizontalAlignment(0);
        this.JTFFAnosFumF.setText("0");
        this.JTFFAnosFumF.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiempo Fumando", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JDCFechaInicioF.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 11), Color.blue));
        this.JDCFechaInicioF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicioF.setEnabled(false);
        this.JDCFechaInicioF.setFont(new Font("Tahoma", 1, 12));
        this.JDCFechaInicioF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecentesHabitos.36
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecentesHabitos.this.JDCFechaInicioFPropertyChange(evt);
            }
        });
        this.JTFFFechaInicioF.setFont(new Font("Arial", 1, 12));
        this.JTFFFechaInicioF.setText(" ");
        this.JTFFFechaInicioF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFechaInicioF.setEnabled(false);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jPanel9, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTrabajo)).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCBFuma, -2, 287, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFechaInicioF).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaInicioF, -2, 29, -2).addGap(333, 333, 333)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JSPActividadesAlt, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPObservacionesFuma, -2, 280, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JPExFumador, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPHumoLena, -2, -1, -2))).addGap(0, 11, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFAnosFumF, -2, 332, -2))).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBFuma, GroupLayout.Alignment.TRAILING, -2, 47, -2).addComponent(this.JTFFAnosFumF, -2, 50, -2)).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCFechaInicioF, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFFFechaInicioF, GroupLayout.Alignment.TRAILING, -1, 47, 32767))).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JPExFumador, -2, -1, -2).addGap(8, 8, 8)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPHumoLena, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JTFTrabajo, GroupLayout.Alignment.TRAILING, -2, 47, -2)).addGap(8, 8, 8).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPActividadesAlt, GroupLayout.Alignment.TRAILING, -2, 105, -2).addComponent(this.JSPObservacionesFuma, GroupLayout.Alignment.TRAILING, -2, 105, -2))));
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -1, -1, 32767).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.jPanel4, -1, -1, 32767).addContainerGap()));
        this.JTPHabitos.addTab("SEGUNDA", this.jPanel7);
        this.JCBActividadFisica.setFont(new Font("Arial", 1, 12));
        this.JCBActividadFisica.setModel(new DefaultComboBoxModel(new String[]{"NO REALIZA", "CADA 15 DIAS", "UNA VEZ X SEMANA", "UNA A TRES VECES X SEMANA", "MAS DE 3 VECES POR SEMANA"}));
        this.JCBActividadFisica.setBorder(BorderFactory.createTitledBorder((Border) null, "Veces por semana", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBActividadFisica.addItemListener(new ItemListener() { // from class: Historia.JPAAntecentesHabitos.37
            public void itemStateChanged(ItemEvent evt) {
                JPAAntecentesHabitos.this.JCBActividadFisicaItemStateChanged(evt);
            }
        });
        this.JCBActividadFisica.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.38
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JCBActividadFisicaKeyPressed(evt);
            }
        });
        this.JCBIntencidad.setFont(new Font("Arial", 1, 12));
        this.JCBIntencidad.setModel(new DefaultComboBoxModel(new String[]{"NO APLICA", "SUAVE", "MODERADO", "ALGO PESADO", "FUERTE"}));
        this.JCBIntencidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Intensidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBIntencidad.addItemListener(new ItemListener() { // from class: Historia.JPAAntecentesHabitos.39
            public void itemStateChanged(ItemEvent evt) {
                JPAAntecentesHabitos.this.JCBIntencidadItemStateChanged(evt);
            }
        });
        this.JCBIntencidad.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.40
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JCBIntencidadKeyPressed(evt);
            }
        });
        this.JCBDuracion.setFont(new Font("Arial", 1, 12));
        this.JCBDuracion.setModel(new DefaultComboBoxModel(new String[]{"NO APLICA", "1 A 30 MINUTOS", "30 MINUTOS A 1 HORA", "MAS DE UNA HORA"}));
        this.JCBDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDuracion.addItemListener(new ItemListener() { // from class: Historia.JPAAntecentesHabitos.41
            public void itemStateChanged(ItemEvent evt) {
                JPAAntecentesHabitos.this.JCBDuracionItemStateChanged(evt);
            }
        });
        this.JCBDuracion.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.42
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JCBDuracionKeyPressed(evt);
            }
        });
        this.JSPFunciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividades que realiza", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFunciones.setFont(new Font("Arial", 1, 12));
        this.JTFunciones.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTFunciones.setSelectionBackground(new Color(255, 255, 255));
        this.JTFunciones.setSelectionForeground(new Color(255, 0, 0));
        this.JSPFunciones.setViewportView(this.JTFunciones);
        this.JSPTipoActividad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Actividad", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTTipoActividad.setFont(new Font("Arial", 1, 12));
        this.JTTipoActividad.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTTipoActividad.setSelectionBackground(new Color(255, 255, 255));
        this.JTTipoActividad.setSelectionForeground(new Color(255, 0, 0));
        this.JSPTipoActividad.setViewportView(this.JTTipoActividad);
        GroupLayout JPActividadFisicaLayout = new GroupLayout(this.JPActividadFisica);
        this.JPActividadFisica.setLayout(JPActividadFisicaLayout);
        JPActividadFisicaLayout.setHorizontalGroup(JPActividadFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPActividadFisicaLayout.createSequentialGroup().addContainerGap().addGroup(JPActividadFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPActividadFisicaLayout.createSequentialGroup().addComponent(this.JCBActividadFisica, -2, 223, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBIntencidad, -2, 226, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDuracion, -2, 226, -2).addGap(0, 102, 32767)).addGroup(JPActividadFisicaLayout.createSequentialGroup().addComponent(this.JSPTipoActividad, -2, 392, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPFunciones, -2, 0, 32767))).addContainerGap()));
        JPActividadFisicaLayout.setVerticalGroup(JPActividadFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPActividadFisicaLayout.createSequentialGroup().addContainerGap().addGroup(JPActividadFisicaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBActividadFisica, -2, 47, 32767).addComponent(this.JCBIntencidad, -2, 47, 32767).addComponent(this.JCBDuracion, -2, 47, 32767)).addGap(18, 18, 18).addGroup(JPActividadFisicaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPTipoActividad, -1, 164, 32767).addComponent(this.JSPFunciones, -2, 0, 32767)).addGap(43, 43, 43)));
        this.JTPHabitos.addTab("ACTIVIDAD FÍSICA", this.JPActividadFisica);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.setSelectionMode(0);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesHabitos.43
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesHabitos.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 789, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.JSPHistorico, -1, 335, 32767).addContainerGap()));
        this.JTPHabitos.addTab("HISTÓRICO", this.JPHistorico);
        this.JBTAdicionarAntCli.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarAntCli.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarAntCli.setText("Grabar");
        this.JBTAdicionarAntCli.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesHabitos.44
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesHabitos.this.JBTAdicionarAntCliActionPerformed(evt);
            }
        });
        this.JBTAdicionarAntCli.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesHabitos.45
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesHabitos.this.JBTAdicionarAntCliKeyPressed(evt);
            }
        });
        this.JTFNRegistro.setFont(new Font("Arial", 1, 24));
        this.JTFNRegistro.setHorizontalAlignment(0);
        this.JTFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPHabitos, -1, 822, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTAdicionarAntCli, -2, 677, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNRegistro))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPHabitos, -2, 377, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNRegistro).addComponent(this.JBTAdicionarAntCli, -1, -1, 32767)).addContainerGap(11, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPDNoActionPerformed(ActionEvent evt) {
        this.xpdeporte = 0;
        this.JTFFCualDeporte.setEditable(false);
        this.JCBFrecuenciaDeportiva.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPDSiActionPerformed(ActionEvent evt) {
        this.xpdeporte = 1;
        this.JTFFCualDeporte.setEditable(true);
        this.JCBFrecuenciaDeportiva.setEnabled(true);
        this.JTFFCualDeporte.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFSiActionPerformed(ActionEvent evt) {
        if (this.xfuma == 0) {
            this.xexfumador = 1;
            this.JTFFFechaFin.setEnabled(true);
            this.JTFFFechaInicio.setEnabled(true);
            this.JTFFAnosFumador.setEnabled(true);
            this.JTFFAnosFumador.setText("0");
            this.JTFFAnosFumador.requestFocus();
            this.JDCFechaInicio.setEnabled(true);
            this.JDCFechaFin.setEnabled(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "El usuario es fumador activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JRBEFNo.setSelected(true);
        this.xexfumador = 0;
        this.JDCFechaInicio.setEnabled(false);
        this.JDCFechaFin.setEnabled(false);
        this.JTFFFechaFin.setText("");
        this.JTFFFechaInicio.setText("");
        this.JTFFAnosFumador.setText("0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFNoActionPerformed(ActionEvent evt) {
        this.xexfumador = 0;
        this.JTFFFechaFin.setEnabled(false);
        this.JTFFFechaInicio.setEnabled(false);
        this.JTFFAnosFumador.setEnabled(false);
        this.JTFFFechaFin.setText("");
        this.JTFFAnosFumador.setText("0");
        this.JTFFFechaInicio.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlcholSiActionPerformed(ActionEvent evt) {
        this.xalcohol = 1;
        this.JTFFCualAlcohol.setEditable(true);
        this.JCBFrecuenciaAlcohol.setEnabled(true);
        this.JTFFCualAlcohol.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlcholNoActionPerformed(ActionEvent evt) {
        this.xalcohol = 0;
        this.JTFFCualAlcohol.setEditable(false);
        this.JCBFrecuenciaAlcohol.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFumaItemStateChanged(ItemEvent evt) {
        if (this.JCBFuma.getSelectedIndex() != -1 && this.xlleno == 1) {
            if (!this.idcantidacigarrillo[this.JCBFuma.getSelectedIndex()][0].equals("1")) {
                this.JTFFFechaInicioF.setEnabled(true);
                this.xfuma = 1;
            } else {
                this.JTFFFechaInicioF.setEnabled(false);
                this.JTFFAnosFumF.setText("0");
                this.JTFFFechaInicioF.setText("");
                this.xfuma = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPDSiKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBPDSi.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPDNoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBPDNo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCualDeporteKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFCualDeporte.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFrecuenciaDeportivaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBFrecuenciaDeportiva.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFumaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBFuma.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFSiKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBEFSi.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFNoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBEFNo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlcholSiKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBAlcholSi.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlcholNoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBAlcholNo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCualAlcoholKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFCualAlcohol.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFrecuenciaAlcoholKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBFrecuenciaAlcohol.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPObservacionesAlcoholKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPObservacionesAlcohol.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPObservacionesFumaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHLSiActionPerformed(ActionEvent evt) {
        this.xhumol = 1;
        this.JRBHLSi.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHLSiKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHLNoActionPerformed(ActionEvent evt) {
        this.xhumol = 0;
        this.JRBHLNo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHLNoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        if (this.xmod == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFSi_sicoactivasActionPerformed(ActionEvent evt) {
        this.xsicoactivas = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFSi_sicoactivasKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFNo_sicoactivasActionPerformed(ActionEvent evt) {
        this.xsicoactivas = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFNo_sicoactivasKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFSi_TrabajoActionPerformed(ActionEvent evt) {
        this.xtrabajo = 1;
        this.JTFTrabajo.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFSi_TrabajoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFNo_TrabajoActionPerformed(ActionEvent evt) {
        this.xtrabajo = 0;
        this.JTFTrabajo.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEFNo_TrabajoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getRowCount() > -1 && evt.getClickCount() == 2) {
            mBuscarDatosBd();
            this.JTPHabitos.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBActividadFisicaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBActividadFisicaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBIntencidadItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBIntencidadKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDuracionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDuracionKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.JDCFechaInicio.getDate() != null) {
            this.JTFFFechaInicio.setText(this.xmetodo.formatoAMD.format(this.JDCFechaInicio.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.JDCFechaFin.getDate() != null) {
            this.JTFFFechaFin.setText(this.xmetodo.formatoAMD.format(this.JDCFechaFin.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioFPropertyChange(PropertyChangeEvent evt) {
        if (this.JDCFechaInicioF.getDate() != null) {
            this.JTFFFechaInicioF.setText(this.xmetodo.formatoAMD.format(this.JDCFechaInicioF.getDate()));
        }
    }

    public void mNuevo() {
        this.xlleno = 0;
        this.JTFNRegistro.setText("");
        this.idfrecdeportiva = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tipofrecuencia WHERE (Estado =0) ORDER BY Nbre ASC", this.idfrecdeportiva, this.JCBFrecuenciaDeportiva);
        this.JCBFrecuenciaDeportiva.setSelectedItem("Nunca");
        this.idfrecalcohol = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tipofrecuencia WHERE (Estado =0) ORDER BY Nbre ASC", this.idfrecalcohol, this.JCBFrecuenciaAlcohol);
        this.JCBFrecuenciaAlcohol.setSelectedItem("Nunca");
        this.idcantidacigarrillo = this.xconsultasbd.llenarComboyLista("SELECT Id, Nbre, Fuma FROM h_tipocantcigarro WHERE (Estado =0) ORDER BY Nbre ASC", this.idcantidacigarrillo, this.JCBFuma, 2);
        this.JCBFuma.setSelectedIndex(5);
        this.xconsultasbd.cerrarConexionBd();
        if (this.xmod == 0) {
            this.xidusuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue();
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        } else if (this.xmod == 1) {
            if (!this.xjifcho1.xjppersona.getIdPersona().equals("0") || this.xjifcho1.xjppersona.getIdPersona() != null) {
                this.xidusuario = Long.valueOf(this.xjifcho1.xjppersona.getIdPersona()).longValue();
            }
            this.xidatencion = "0";
        }
        this.xconsultasbd.cerrarConexionBd();
        mBuscarDatosBdIdAtencion();
        mBuscarresultado();
        mBuscarHistorico();
        mBuscarFunciones();
        mBuscarTipoActividad();
        this.xlleno = 1;
        this.JTFFFechaInicioF.setText("");
    }

    private void mBuscarDatosBdIdAtencion() {
        try {
            String sql = "SELECT h_habitos.Id_Usuario, h_habitos.Habito_Deporte, h_habitos.Cual_Deporte, h_habitos.Id_FrecDeportiva, g_frecuencia.NFrecuencia, h_habitos.Id_TipoCantCigarro, h_tipocantcigarro.Nbre, h_habitos.Annos_Fumador, h_habitos.ExFumador,  h_habitos.Inicio_Exfumador, h_habitos.Fin_Exfumador, h_habitos.Habito_Alcohol, h_habitos.Cual_Alcohol, h_habitos.Id_FrecAlcohol,  h_tipofrecuencia.Nbre, h_habitos.ObserALcohol, h_habitos.ObserFuma, h_habitos.Habito_HumoLenna, h_habitos.`Id_Atencion` AS atencion, h_habitos.Sicoactivas, h_habitos.`OtroTrabajo`, h_habitos.`TrabajoDesc` ,h_habitos.`Id` , h_habitos.FrecActi_Fisica, h_habitos.Intensidad, h_habitos.Duracion, h_habitos.FechaFumador, h_habitos.AniosFuma, h_habitos.Id  FROM  h_habitos INNER JOIN  h_tipofrecuencia  ON (h_habitos.Id_FrecAlcohol = h_tipofrecuencia.Id) INNER JOIN  h_tipocantcigarro  ON (h_habitos.Id_TipoCantCigarro = h_tipocantcigarro.Id) INNER JOIN  g_frecuencia  ON (g_frecuencia.Id = h_habitos.Id_FrecDeportiva) where h_habitos.Id_Atencion='" + this.xidatencion + "'";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrset = xct.traerRs(sql);
            if (xrset.next()) {
                xrset.first();
                this.JTFNRegistro.setText(xrset.getString("Id"));
                if (xrset.getInt(2) == 1) {
                    this.JRBPDSi.setSelected(true);
                    this.JRBPDNo.setSelected(false);
                } else {
                    this.JRBPDNo.setSelected(true);
                    this.JRBPDSi.setSelected(false);
                }
                this.JTFFCualDeporte.setText(xrset.getString(3));
                this.JCBFrecuenciaDeportiva.setSelectedItem(xrset.getString(5));
                this.JCBFuma.setSelectedItem(xrset.getString(7));
                this.JTFFAnosFumador.setText(xrset.getString(8));
                if (xrset.getInt(9) == 1) {
                    this.JRBEFSi.setSelected(true);
                    this.JRBEFNo.setSelected(false);
                } else {
                    this.JRBEFNo.setSelected(true);
                    this.JRBEFSi.setSelected(false);
                }
                this.JTFFFechaInicio.setText(xrset.getString(10));
                this.JTFFFechaFin.setText(xrset.getString(11));
                if (xrset.getInt(12) == 1) {
                    this.JRBAlcholSi.setSelected(true);
                    this.JRBAlcholNo.setSelected(false);
                } else {
                    this.JRBAlcholSi.setSelected(false);
                    this.JRBAlcholNo.setSelected(true);
                }
                if (xrset.getInt(18) == 1) {
                    this.JRBHLSi.setSelected(true);
                    this.JRBHLNo.setSelected(false);
                } else {
                    this.JRBHLSi.setSelected(false);
                    this.JRBHLNo.setSelected(true);
                }
                this.JTFFCualAlcohol.setText(xrset.getString(13));
                this.JCBFrecuenciaAlcohol.setSelectedItem(xrset.getString(15));
                this.JTPObservacionesAlcohol.setText(xrset.getString(16));
                this.JTPObservacionesFuma.setText(xrset.getString(17));
                if (xrset.getInt(20) == 1) {
                    this.JRBEFSi_sicoactivas.setSelected(true);
                } else {
                    this.JRBEFNo_sicoactivas.setSelected(true);
                }
                if (xrset.getInt(21) == 1) {
                    this.JRBEFSi_Trabajo.setSelected(true);
                } else {
                    this.JRBEFNo_Trabajo.setSelected(true);
                }
                this.JTFTrabajo.setText(xrset.getString(22));
                this.JCBActividadFisica.setSelectedItem(xrset.getString(24));
                this.JCBIntencidad.setSelectedItem(xrset.getString(25));
                this.JCBDuracion.setSelectedItem(xrset.getString(26));
                this.JTFFFechaInicioF.setText(xrset.getString(27));
                this.JTFFAnosFumF.setText(xrset.getString(28));
                this.xencontro = 1;
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet rs1 = xct1.traerRs("SELECT g_so_act_alternas.Id, `g_so_act_alternas`.`Nbre`  , `h_so_habitos_act_alternas`.`Observacion`  FROM `h_so_habitos_act_alternas` INNER JOIN `baseserver`.`g_so_act_alternas` ON (`h_so_habitos_act_alternas`.`Id_Actividad` = `g_so_act_alternas`.`Id`) WHERE (`h_so_habitos_act_alternas`.`Id_Habito` ='" + xrset.getString(23) + "')");
                mModeloActividadesAlt();
                if (rs1.next()) {
                    rs1.beforeFirst();
                    int x = 0;
                    while (rs1.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(rs1.getLong(1)), x, 0);
                        this.xmodelo.setValueAt(rs1.getString(2), x, 1);
                        this.xmodelo.setValueAt(true, x, 2);
                        this.xmodelo.setValueAt(rs1.getString(3), x, 3);
                        x++;
                    }
                }
                rs1.close();
                xct1.cerrarConexionBd();
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet rs2 = xct2.traerRs("SELECT `so_actividad_fisica`.`Id` , `so_actividad_fisica`.`Nbre`  , `h_so_act_fisica_detalle`.`Observacion` FROM `h_so_act_fisica_detalle` INNER JOIN `baseserver`.`so_actividad_fisica`    ON (`h_so_act_fisica_detalle`.`Id_SOActFisica` = `so_actividad_fisica`.`Id`) WHERE (`h_so_act_fisica_detalle`.`Id_Habito` ='" + xrset.getString(23) + "')");
                mModeloFunciones();
                if (rs2.next()) {
                    rs2.beforeFirst();
                    int x2 = 0;
                    while (rs2.next()) {
                        this.xmodelofuncion.addRow(this.xdato);
                        this.xmodelofuncion.setValueAt(Long.valueOf(rs2.getLong(1)), x2, 0);
                        this.xmodelofuncion.setValueAt(rs2.getString(2), x2, 1);
                        this.xmodelofuncion.setValueAt(true, x2, 2);
                        this.xmodelofuncion.setValueAt(rs2.getString(3), x2, 3);
                        x2++;
                    }
                }
                rs2.close();
                xct2.cerrarConexionBd();
                ConsultasMySQL xct3 = new ConsultasMySQL();
                ResultSet rs3 = xct3.traerRs("SELECT so_tipo_actividad_fisica.`Id` ,`so_tipo_actividad_fisica`.`Nbre` , `h_so_tipo_act_fisica_detalle`.`Observacion` FROM `h_so_tipo_act_fisica_detalle` INNER JOIN `baseserver`.`so_tipo_actividad_fisica`  ON (`h_so_tipo_act_fisica_detalle`.`Id_Actividad` = `so_tipo_actividad_fisica`.`Id`) WHERE (`h_so_tipo_act_fisica_detalle`.`Id_Habito` ='" + xrset.getString(23) + "')");
                mModeloTipoActividad();
                if (rs3.next()) {
                    rs3.beforeFirst();
                    int x3 = 0;
                    while (rs3.next()) {
                        this.xmodelotipoactividad.addRow(this.xdato);
                        this.xmodelotipoactividad.setValueAt(Long.valueOf(rs3.getLong(1)), x3, 0);
                        this.xmodelotipoactividad.setValueAt(rs3.getString(2), x3, 1);
                        this.xmodelotipoactividad.setValueAt(true, x3, 2);
                        this.xmodelotipoactividad.setValueAt(rs3.getString(3), x3, 3);
                        x3++;
                    }
                }
                rs3.close();
                xct3.cerrarConexionBd();
            }
            xrset.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesHabitos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosBd() {
        try {
            String sql = "SELECT h_habitos.Id_Usuario, h_habitos.Habito_Deporte, h_habitos.Cual_Deporte, h_habitos.Id_FrecDeportiva, g_frecuencia.NFrecuencia, h_habitos.Id_TipoCantCigarro, h_tipocantcigarro.Nbre, h_habitos.Annos_Fumador, h_habitos.ExFumador,  h_habitos.Inicio_Exfumador, h_habitos.Fin_Exfumador, h_habitos.Habito_Alcohol, h_habitos.Cual_Alcohol, h_habitos.Id_FrecAlcohol,  h_tipofrecuencia.Nbre, h_habitos.ObserALcohol, h_habitos.ObserFuma, h_habitos.Habito_HumoLenna, h_habitos.`Id_Atencion` AS atencion, h_habitos.Sicoactivas, h_habitos.`OtroTrabajo`, h_habitos.`TrabajoDesc` ,h_habitos.`Id` , h_habitos.FrecActi_Fisica, h_habitos.Intensidad, h_habitos.Duracion, h_habitos.FechaFumador, h_habitos.AniosFuma  FROM  h_habitos INNER JOIN  h_tipofrecuencia  ON (h_habitos.Id_FrecAlcohol = h_tipofrecuencia.Id) INNER JOIN  h_tipocantcigarro  ON (h_habitos.Id_TipoCantCigarro = h_tipocantcigarro.Id) INNER JOIN  g_frecuencia  ON (g_frecuencia.Id = h_habitos.Id_FrecDeportiva) where h_habitos.Id_Atencion='" + this.xmodeloh.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "'";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrset = xct.traerRs(sql);
            if (xrset.next()) {
                xrset.first();
                if (xrset.getInt(2) == 1) {
                    this.JRBPDSi.setSelected(true);
                    this.JRBPDNo.setSelected(false);
                } else {
                    this.JRBPDNo.setSelected(true);
                    this.JRBPDSi.setSelected(false);
                }
                this.JTFFCualDeporte.setText(xrset.getString(3));
                this.JCBFrecuenciaDeportiva.setSelectedItem(xrset.getString(5));
                this.JCBFuma.setSelectedItem(xrset.getString(7));
                this.JTFFAnosFumador.setText(xrset.getString(8));
                if (xrset.getInt(9) == 1) {
                    this.JRBEFSi.setSelected(true);
                    this.JRBEFNo.setSelected(false);
                } else {
                    this.JRBEFNo.setSelected(true);
                    this.JRBEFSi.setSelected(false);
                }
                this.JTFFFechaInicio.setText(xrset.getString(10));
                this.JTFFFechaFin.setText(xrset.getString(11));
                if (xrset.getInt(12) == 1) {
                    this.JRBAlcholSi.setSelected(true);
                    this.JRBAlcholNo.setSelected(false);
                } else {
                    this.JRBAlcholSi.setSelected(false);
                    this.JRBAlcholNo.setSelected(true);
                }
                if (xrset.getInt(18) == 1) {
                    this.JRBHLSi.setSelected(true);
                    this.JRBHLNo.setSelected(false);
                } else {
                    this.JRBHLSi.setSelected(false);
                    this.JRBHLNo.setSelected(true);
                }
                this.JTFFCualAlcohol.setText(xrset.getString(13));
                this.JCBFrecuenciaAlcohol.setSelectedItem(xrset.getString(15));
                this.JTPObservacionesAlcohol.setText(xrset.getString(16));
                this.JTPObservacionesFuma.setText(xrset.getString(17));
                if (xrset.getInt(20) == 1) {
                    this.JRBEFSi_sicoactivas.setSelected(true);
                } else {
                    this.JRBEFNo_sicoactivas.setSelected(true);
                }
                if (xrset.getInt(21) == 1) {
                    this.JRBEFSi_Trabajo.setSelected(true);
                } else {
                    this.JRBEFNo_Trabajo.setSelected(true);
                }
                this.JTFTrabajo.setText(xrset.getString(22));
                this.JCBActividadFisica.setSelectedItem(xrset.getString(24));
                this.JCBIntencidad.setSelectedItem(xrset.getString(25));
                this.JCBDuracion.setSelectedItem(xrset.getString(26));
                this.JTFFFechaInicioF.setText(xrset.getString(27));
                this.JTFFAnosFumF.setText(xrset.getString(28));
                this.xencontro = 1;
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet rs1 = xct1.traerRs("SELECT g_so_act_alternas.Id, `g_so_act_alternas`.`Nbre`  , `h_so_habitos_act_alternas`.`Observacion`  FROM `h_so_habitos_act_alternas` INNER JOIN `baseserver`.`g_so_act_alternas` ON (`h_so_habitos_act_alternas`.`Id_Actividad` = `g_so_act_alternas`.`Id`) WHERE (`h_so_habitos_act_alternas`.`Id_Habito` ='" + xrset.getString(23) + "')");
                mModeloActividadesAlt();
                if (rs1.next()) {
                    rs1.beforeFirst();
                    int x = 0;
                    while (rs1.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(rs1.getLong(1)), x, 0);
                        this.xmodelo.setValueAt(rs1.getString(2), x, 1);
                        this.xmodelo.setValueAt(true, x, 2);
                        this.xmodelo.setValueAt(rs1.getString(3), x, 3);
                        x++;
                    }
                }
                rs1.close();
                xct1.cerrarConexionBd();
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet rs2 = xct2.traerRs("SELECT `so_actividad_fisica`.`Id` , `so_actividad_fisica`.`Nbre`  , `h_so_act_fisica_detalle`.`Observacion` FROM `h_so_act_fisica_detalle` INNER JOIN `baseserver`.`so_actividad_fisica`    ON (`h_so_act_fisica_detalle`.`Id_SOActFisica` = `so_actividad_fisica`.`Id`) WHERE (`h_so_act_fisica_detalle`.`Id_Habito` ='" + xrset.getString(23) + "')");
                mModeloFunciones();
                if (rs2.next()) {
                    rs2.beforeFirst();
                    int x2 = 0;
                    while (rs2.next()) {
                        this.xmodelofuncion.addRow(this.xdato);
                        this.xmodelofuncion.setValueAt(Long.valueOf(rs2.getLong(1)), x2, 0);
                        this.xmodelofuncion.setValueAt(rs2.getString(2), x2, 1);
                        this.xmodelofuncion.setValueAt(true, x2, 2);
                        this.xmodelofuncion.setValueAt(rs2.getString(3), x2, 3);
                        x2++;
                    }
                }
                rs2.close();
                xct2.cerrarConexionBd();
                ConsultasMySQL xct3 = new ConsultasMySQL();
                ResultSet rs3 = xct3.traerRs("SELECT so_tipo_actividad_fisica.`Id` ,`so_tipo_actividad_fisica`.`Nbre` , `h_so_tipo_act_fisica_detalle`.`Observacion` FROM `h_so_tipo_act_fisica_detalle` INNER JOIN `baseserver`.`so_tipo_actividad_fisica`  ON (`h_so_tipo_act_fisica_detalle`.`Id_Actividad` = `so_tipo_actividad_fisica`.`Id`) WHERE (`h_so_tipo_act_fisica_detalle`.`Id_Habito` ='" + xrset.getString(23) + "')");
                mModeloTipoActividad();
                if (rs3.next()) {
                    rs3.beforeFirst();
                    int x3 = 0;
                    while (rs3.next()) {
                        this.xmodelotipoactividad.addRow(this.xdato);
                        this.xmodelotipoactividad.setValueAt(Long.valueOf(rs3.getLong(1)), x3, 0);
                        this.xmodelotipoactividad.setValueAt(rs3.getString(2), x3, 1);
                        this.xmodelotipoactividad.setValueAt(true, x3, 2);
                        this.xmodelotipoactividad.setValueAt(rs3.getString(3), x3, 3);
                        x3++;
                    }
                }
                rs3.close();
                xct3.cerrarConexionBd();
            }
            xrset.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesHabitos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabarBd() {
        if (this.JTFNRegistro.getText().isEmpty()) {
            String sql = "insert into h_habitos (Id_Usuario, Habito_Deporte, Cual_Deporte, Id_FrecDeportiva, Id_TipoCantCigarro, Annos_Fumador, ExFumador, Inicio_Exfumador, Fin_Exfumador, Habito_Alcohol, Cual_Alcohol, Id_FrecAlcohol, ObserALcohol, ObserFuma, Habito_HumoLenna,Id_Atencion,Sicoactivas,OtroTrabajo,TrabajoDesc,FrecActi_Fisica,Intensidad,Duracion,FechaFumador,AniosFuma, Fecha, UsuarioS)VALUES ( '" + this.xidusuario + "','" + this.xpdeporte + "','" + this.JTFFCualDeporte.getText() + "','" + this.idfrecdeportiva[this.JCBFrecuenciaDeportiva.getSelectedIndex()] + "','" + this.idcantidacigarrillo[this.JCBFuma.getSelectedIndex()][0] + "','" + this.JTFFAnosFumador.getText() + "','" + this.xexfumador + "','" + this.JTFFFechaInicio.getText() + "','" + this.JTFFFechaFin.getText() + "','" + this.xalcohol + "','" + this.JTFFCualAlcohol.getText() + "','" + this.idfrecalcohol[this.JCBFrecuenciaAlcohol.getSelectedIndex()] + "','" + this.JTPObservacionesAlcohol.getText() + "','" + this.JTPObservacionesFuma.getText() + "','" + this.xhumol + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xsicoactivas + "','" + this.xtrabajo + "','" + this.JTFTrabajo.getText() + "','" + this.JCBActividadFisica.getSelectedItem() + "','" + this.JCBIntencidad.getSelectedItem() + "','" + this.JCBDuracion.getSelectedItem() + "','" + this.JTFFFechaInicioF.getText() + "','" + this.JTFFAnosFumF.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xhabito = this.xconsultasbd.ejecutarSQLId(sql);
            this.JTFNRegistro.setText(this.xhabito);
            this.xconsultasbd.cerrarConexionBd();
            for (int y = 0; y < this.JTActividadesAlt.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(y, 2).toString()).booleanValue()) {
                    String sql2 = "insert into h_so_habitos_act_alternas( `Id_Habito`,`Id_Actividad`, `Observacion`,  `UsuarioS`) values ('" + this.xhabito + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xconsultasbd.ejecutarSQL(sql2);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            for (int y2 = 0; y2 < this.JTFunciones.getRowCount(); y2++) {
                if (Boolean.valueOf(this.xmodelofuncion.getValueAt(y2, 2).toString()).booleanValue()) {
                    String sql3 = "insert into h_so_act_fisica_detalle( `Id_Habito` , `Id_SOActFisica` , `Observacion`) values ('" + this.xhabito + "','" + this.xmodelofuncion.getValueAt(y2, 0) + "','" + this.xmodelo.getValueAt(y2, 3) + "')";
                    this.xconsultasbd.ejecutarSQL(sql3);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            for (int y3 = 0; y3 < this.JTTipoActividad.getRowCount(); y3++) {
                if (Boolean.valueOf(this.xmodelotipoactividad.getValueAt(y3, 2).toString()).booleanValue()) {
                    String sql4 = "insert into h_so_tipo_act_fisica_detalle( `Id_Habito` , `Id_Actividad` , `Observacion`) values ('" + this.xhabito + "','" + this.xmodelotipoactividad.getValueAt(y3, 0) + "','" + this.xmodelotipoactividad.getValueAt(y3, 3) + "')";
                    this.xconsultasbd.ejecutarSQL(sql4);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            return;
        }
        String sql5 = "UPDATE h_habitos SET  Habito_Deporte ='" + this.xpdeporte + "', Cual_Deporte = '" + this.JTFFCualDeporte.getText() + "', Id_FrecDeportiva = '" + this.idfrecdeportiva[this.JCBFrecuenciaDeportiva.getSelectedIndex()] + "', Id_TipoCantCigarro ='" + this.idcantidacigarrillo[this.JCBFuma.getSelectedIndex()][0] + "', Annos_Fumador = '" + this.JTFFAnosFumador.getText() + "', ExFumador ='" + this.xexfumador + "', Inicio_Exfumador = '" + this.JTFFAnosFumador.getText() + "', Fin_Exfumador = '" + this.JTFFFechaFin.getText() + "', Habito_Alcohol = '" + this.xalcohol + "', Cual_Alcohol='" + this.JTFFCualAlcohol.getText() + "', Id_FrecAlcohol ='" + this.idfrecalcohol[this.JCBFrecuenciaAlcohol.getSelectedIndex()] + "', ObserALcohol ='" + this.JTPObservacionesAlcohol.getText() + "', ObserFuma ='" + this.JTPObservacionesFuma.getText() + "', Habito_HumoLenna ='" + this.xhumol + "', Sicoactivas ='" + this.xsicoactivas + "', OtroTrabajo ='" + this.xtrabajo + "', TrabajoDesc ='" + this.JTFTrabajo.getText() + "', FrecActi_Fisica ='" + this.JCBActividadFisica.getSelectedItem() + "', Intensidad ='" + this.JCBIntencidad.getSelectedItem() + "', Duracion ='" + this.JCBDuracion.getSelectedItem() + "', Fecha ='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE(Id_Usuario ='" + this.xidusuario + "' AND Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
        this.xconsultasbd.ejecutarSQL(sql5);
        this.xconsultasbd.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloActividadesAlt() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Actividad", "Aplica?", "Observacion"}) { // from class: Historia.JPAAntecentesHabitos.46
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTActividadesAlt.setModel(this.xmodelo);
        this.JTActividadesAlt.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTActividadesAlt.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTActividadesAlt.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTActividadesAlt.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTActividadesAlt.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTActividadesAlt.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mBuscarresultado() {
        try {
            mModeloActividadesAlt();
            ResultSet xrs4 = this.xconsultasbd.traerRs("SELECT `Id` , `Nbre` FROM `g_so_act_alternas` WHERE (`Estado` =1)");
            if (xrs4.next()) {
                xrs4.beforeFirst();
                int n = 0;
                while (xrs4.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs4.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs4.getString(2), n, 1);
                    this.xmodelo.setValueAt(false, n, 2);
                    this.xmodelo.setValueAt("", n, 3);
                    n++;
                }
            }
            xrs4.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesHabitos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "Profesional"}) { // from class: Historia.JPAAntecentesHabitos.47
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodeloh);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void mBuscarHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT `h_atencion`.`Id`, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS Fecha, `profesional1`.`NProfesional` , `h_atencion`.`Fecha_Atencion` FROM `h_atencion` INNER JOIN  `h_habitos`  ON (`h_atencion`.`Id` = `h_habitos`.`Id_Atencion`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) WHERE (`h_habitos`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY `h_atencion`.`Fecha_Atencion` DESC ";
            ResultSet xrs5 = this.xconsultasbd.traerRs(sql);
            if (xrs5.next()) {
                xrs5.beforeFirst();
                int n = 0;
                while (xrs5.next()) {
                    this.xmodeloh.addRow(this.xdato);
                    this.xmodeloh.setValueAt(xrs5.getString(1), n, 0);
                    this.xmodeloh.setValueAt(xrs5.getString(2), n, 1);
                    this.xmodeloh.setValueAt(xrs5.getString(3), n, 2);
                    n++;
                }
            }
            xrs5.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesHabitos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT `h_habitos`.`Habito_Deporte` , `h_habitos`.`Cual_Deporte`  , `h_habitos`.`Id_FrecDeportiva`  , `h_habitos`.`Id_TipoCantCigarro`  , `h_habitos`.`Annos_Fumador` , `h_habitos`.`ExFumador` , `h_habitos`.`Inicio_Exfumador`  , `h_habitos`.`Fin_Exfumador`  , `h_habitos`.`Habito_Alcohol`  , `h_habitos`.`Cual_Alcohol` , `h_habitos`.`Id_FrecAlcohol`  , `h_habitos`.`ObserALcohol` , `h_habitos`.`ObserFuma`  , `h_habitos`.`Habito_HumoLenna` , `h_habitos`.`Sicoactivas` , `h_habitos`.`OtroTrabajo` , `h_habitos`.`TrabajoDesc` FROM `h_habitos`  INNER JOIN `h_atencion`  ON (`h_habitos`.`Id_Usuario` = `h_atencion`.`Id`) WHERE (`h_habitos`.`Id_Atencion` ='" + this.xmodeloh.getValueAt(this.JTHistorico.getSelectedRow(), 0) + "')";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getLong(1) == 1) {
                    this.JRBPDSi.setSelected(true);
                } else {
                    this.JRBPDNo.setSelected(true);
                }
                this.JTFFCualDeporte.setText(xrs.getString(2));
                this.JCBFrecuenciaDeportiva.setSelectedItem(xrs.getString(3));
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesHabitos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloFunciones() {
        this.xmodelofuncion = new DefaultTableModel(new Object[0], new String[]{"Id", "Actividad", "Aplica?", "Observacion"}) { // from class: Historia.JPAAntecentesHabitos.48
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTFunciones.setModel(this.xmodelofuncion);
        this.JTFunciones.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTFunciones.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTFunciones.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTFunciones.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTFunciones.getColumnModel().getColumn(2).setPreferredWidth(6);
        this.JTFunciones.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mBuscarFunciones() {
        try {
            mModeloFunciones();
            ResultSet xrs = this.xconsultasbd.traerRs("SELECT `Id` , `Nbre` FROM `so_actividad_fisica` WHERE (`Estado` =1);");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelofuncion.addRow(this.xdato);
                    this.xmodelofuncion.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelofuncion.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelofuncion.setValueAt(false, n, 2);
                    this.xmodelofuncion.setValueAt("", n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesHabitos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloTipoActividad() {
        this.xmodelotipoactividad = new DefaultTableModel(new Object[0], new String[]{"Id", "Actividad", "Aplica?", "Observacion"}) { // from class: Historia.JPAAntecentesHabitos.49
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTTipoActividad.setModel(this.xmodelotipoactividad);
        this.JTTipoActividad.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTTipoActividad.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTTipoActividad.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTTipoActividad.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTTipoActividad.getColumnModel().getColumn(2).setPreferredWidth(6);
        this.JTTipoActividad.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mBuscarTipoActividad() {
        try {
            mModeloTipoActividad();
            ResultSet xrs = this.xconsultasbd.traerRs("SELECT `Id` , `Nbre` FROM `so_tipo_actividad_fisica` WHERE (`Estado` =1)");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelotipoactividad.addRow(this.xdato);
                    this.xmodelotipoactividad.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelotipoactividad.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelotipoactividad.setValueAt(false, n, 2);
                    this.xmodelotipoactividad.setValueAt("", n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesHabitos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCalcularAniosExFumador() {
        try {
            ResultSet xrs = this.xconsultasbd.traerRs("SELECT `CalculaTiempo_AMD_2Fechas`('2013-01-01','2014-01-01') AS tiempo");
            if (xrs.next()) {
                xrs.first();
                this.JTFFAnosFumador.setText(xrs.getString("tiempo"));
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesHabitos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
