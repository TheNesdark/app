package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPHNutricional.class */
public class JPHNutricional extends JPanel {
    private String[] xidgen;
    private String[][] xidestadon;
    private clasesHistoriaCE xclaseh;
    private ButtonGroup JBGCFritos;
    private ButtonGroup JBGDietasA;
    private ButtonGroup JBGEstructura;
    private ButtonGroup JBGMastica;
    private ButtonGroup JBGMecatosC;
    private JButton JBTCHistorial;
    private JButton JBTGrabar;
    public JComboBox JCBTipoEstadoN;
    public JComboBox JCBTipoPPersonales;
    private JLabel JLBCCadera;
    private JLabel JLBCCarpo;
    private JLabel JLBCCintura;
    private JLabel JLBMasaOsea;
    private JLabel JLBMasaVic;
    private JLabel JLBPAgua;
    private JLabel JLBPGrasa;
    private JLabel JLBPLGrasa;
    private JLabel JLBPObjetivo;
    private JLabel JLBPUsual;
    private JLabel JLBSImc;
    private JLabel JLBSPeso;
    private JLabel JLBSTalla;
    private JPanel JPIAAlimentaria;
    private JPanel JPICFritos;
    private JPanel JPICMecatosChatarra;
    private JPanel JPIDatosAntropometrica;
    private JPanel JPIDietasAnteriores;
    private JPanel JPIEstructura;
    private JPanel JPIMastica;
    private JRadioButton JRBCFritosNo;
    private JRadioButton JRBCFritosSi;
    private JRadioButton JRBComidaNo;
    private JRadioButton JRBComidaSi;
    private JRadioButton JRBDespacio;
    private JRadioButton JRBDietasANo;
    private JRadioButton JRBDietasASi;
    private JRadioButton JRBGrande;
    private JRadioButton JRBMediano;
    private JRadioButton JRBNormal;
    private JRadioButton JRBPequeno;
    private JRadioButton JRBRapido;
    private JScrollPane JSPAPreferidos;
    private JScrollPane JSPARechazados;
    private JScrollPane JSPATolerados;
    private JScrollPane JSPAlgo;
    private JScrollPane JSPAlmuerzo;
    private JSpinner JSPCCadera;
    private JSpinner JSPCCarpo;
    private JSpinner JSPCCintura;
    private JScrollPane JSPComida;
    private JScrollPane JSPDesayuno;
    private JSpinner JSPIMC;
    private JSpinner JSPMasaOsea;
    private JSpinner JSPMasaVic;
    private JScrollPane JSPMediaManana;
    private JScrollPane JSPMediaTarde;
    private JSpinner JSPNVasosA;
    private JSpinner JSPPAgua;
    private JSpinner JSPPGrasa;
    private JSpinner JSPPLGrasa;
    private JSpinner JSPPObjetivo;
    private JSpinner JSPPUsual;
    private JSpinner JSPPeso;
    private JSpinner JSPTalla;
    private JTextPane JTPAPreferidos;
    private JTextPane JTPARechazados;
    private JTextPane JTPATolerados;
    private JTextPane JTPAlgo;
    private JTextPane JTPAlmuerzo;
    private JTextPane JTPComida;
    private JTextPane JTPDesayuno;
    private JTextPane JTPMManana;
    private JTextPane JTPMediaTarde;
    DecimalFormat xdecf = new DecimalFormat("#0.00");
    private int xestructura = 0;
    private int xmastica = 2;
    private int xcchatarra = 0;
    private int xcfritos = 0;
    private int xdanteriores = 0;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private double imc = 0.0d;
    private boolean xestado = false;

    public JPHNutricional(clasesHistoriaCE xclaseh) {
        initComponents();
        this.xclaseh = xclaseh;
        this.xidgen = this.consultas.llenarCombo("SELECT Id, Nbre FROM h_tiporiesgoemb WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgen, this.JCBTipoPPersonales);
        this.xidestadon = this.consultas.llenarComboyLista("SELECT Id, Nbre, RIMCMenor, RIMCMayor FROM h_tipoestadonutricional ORDER BY Nbre ASC", this.xidestadon, this.JCBTipoEstadoN, 3);
        this.JCBTipoEstadoN.setSelectedItem("Normal");
        this.consultas.cerrarConexionBd();
        mBuscarDatosBd();
    }

    private void initComponents() {
        this.JBGMastica = new ButtonGroup();
        this.JBGMecatosC = new ButtonGroup();
        this.JBGCFritos = new ButtonGroup();
        this.JBGDietasA = new ButtonGroup();
        this.JBGEstructura = new ButtonGroup();
        this.JPIDatosAntropometrica = new JPanel();
        this.JLBSTalla = new JLabel();
        this.JSPTalla = new JSpinner();
        this.JLBSPeso = new JLabel();
        this.JSPPeso = new JSpinner();
        this.JLBSImc = new JLabel();
        this.JSPIMC = new JSpinner();
        this.JLBCCarpo = new JLabel();
        this.JSPCCarpo = new JSpinner();
        this.JLBCCintura = new JLabel();
        this.JSPCCintura = new JSpinner();
        this.JLBCCadera = new JLabel();
        this.JSPCCadera = new JSpinner();
        this.JLBPAgua = new JLabel();
        this.JSPPAgua = new JSpinner();
        this.JLBPGrasa = new JLabel();
        this.JSPPGrasa = new JSpinner();
        this.JLBMasaOsea = new JLabel();
        this.JSPMasaOsea = new JSpinner();
        this.JLBMasaVic = new JLabel();
        this.JSPMasaVic = new JSpinner();
        this.JLBPLGrasa = new JLabel();
        this.JSPPLGrasa = new JSpinner();
        this.JLBPUsual = new JLabel();
        this.JSPPUsual = new JSpinner();
        this.JLBPObjetivo = new JLabel();
        this.JSPPObjetivo = new JSpinner();
        this.JPIEstructura = new JPanel();
        this.JRBGrande = new JRadioButton();
        this.JRBMediano = new JRadioButton();
        this.JRBPequeno = new JRadioButton();
        this.JCBTipoPPersonales = new JComboBox();
        this.JCBTipoEstadoN = new JComboBox();
        this.JPIAAlimentaria = new JPanel();
        this.JSPDesayuno = new JScrollPane();
        this.JTPDesayuno = new JTextPane();
        this.JSPMediaManana = new JScrollPane();
        this.JTPMManana = new JTextPane();
        this.JSPAlmuerzo = new JScrollPane();
        this.JTPAlmuerzo = new JTextPane();
        this.JSPMediaTarde = new JScrollPane();
        this.JTPMediaTarde = new JTextPane();
        this.JSPComida = new JScrollPane();
        this.JTPComida = new JTextPane();
        this.JSPAlgo = new JScrollPane();
        this.JTPAlgo = new JTextPane();
        this.JPIMastica = new JPanel();
        this.JRBRapido = new JRadioButton();
        this.JRBDespacio = new JRadioButton();
        this.JRBNormal = new JRadioButton();
        this.JSPNVasosA = new JSpinner();
        this.JPICMecatosChatarra = new JPanel();
        this.JRBComidaSi = new JRadioButton();
        this.JRBComidaNo = new JRadioButton();
        this.JPICFritos = new JPanel();
        this.JRBCFritosSi = new JRadioButton();
        this.JRBCFritosNo = new JRadioButton();
        this.JPIDietasAnteriores = new JPanel();
        this.JRBDietasASi = new JRadioButton();
        this.JRBDietasANo = new JRadioButton();
        this.JSPAPreferidos = new JScrollPane();
        this.JTPAPreferidos = new JTextPane();
        this.JSPARechazados = new JScrollPane();
        this.JTPARechazados = new JTextPane();
        this.JSPATolerados = new JScrollPane();
        this.JTPATolerados = new JTextPane();
        this.JBTGrabar = new JButton();
        this.JBTCHistorial = new JButton();
        setBorder(BorderFactory.createEtchedBorder(Color.blue, (Color) null));
        setName("jphnutricional");
        this.JPIDatosAntropometrica.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN ANTROPOMETRICA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLBSTalla.setFont(new Font("Arial", 1, 12));
        this.JLBSTalla.setForeground(new Color(0, 0, 255));
        this.JLBSTalla.setHorizontalAlignment(0);
        this.JLBSTalla.setText("Talla(cm)");
        this.JSPTalla.setFont(new Font("Arial", 1, 12));
        this.JSPTalla.setModel(new SpinnerNumberModel(0.0d, 0.0d, 250.1d, 0.1d));
        this.JSPTalla.addChangeListener(new ChangeListener() { // from class: Historia.JPHNutricional.1
            public void stateChanged(ChangeEvent evt) {
                JPHNutricional.this.JSPTallaStateChanged(evt);
            }
        });
        this.JSPTalla.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.2
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JSPTallaKeyPressed(evt);
            }
        });
        this.JLBSPeso.setFont(new Font("Arial", 1, 12));
        this.JLBSPeso.setForeground(new Color(0, 0, 255));
        this.JLBSPeso.setHorizontalAlignment(0);
        this.JLBSPeso.setText("Peso(Kg)");
        this.JSPPeso.setFont(new Font("Arial", 1, 12));
        this.JSPPeso.setModel(new SpinnerNumberModel(0.0d, 0.0d, 500.0d, 0.1d));
        this.JSPPeso.addChangeListener(new ChangeListener() { // from class: Historia.JPHNutricional.3
            public void stateChanged(ChangeEvent evt) {
                JPHNutricional.this.JSPPesoStateChanged(evt);
            }
        });
        this.JSPPeso.addFocusListener(new FocusAdapter() { // from class: Historia.JPHNutricional.4
            public void focusLost(FocusEvent evt) {
                JPHNutricional.this.JSPPesoFocusLost(evt);
            }
        });
        this.JSPPeso.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.5
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JSPPesoKeyPressed(evt);
            }
        });
        this.JLBSImc.setFont(new Font("Arial", 1, 12));
        this.JLBSImc.setForeground(new Color(0, 0, 255));
        this.JLBSImc.setHorizontalAlignment(0);
        this.JLBSImc.setText("IMC");
        this.JSPIMC.setFont(new Font("Arial", 1, 12));
        this.JSPIMC.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JLBCCarpo.setFont(new Font("Arial", 1, 12));
        this.JLBCCarpo.setForeground(new Color(0, 0, 255));
        this.JLBCCarpo.setHorizontalAlignment(0);
        this.JLBCCarpo.setText("Muñeca (cm)");
        this.JSPCCarpo.setFont(new Font("Arial", 1, 12));
        this.JSPCCarpo.setModel(new SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.5d));
        this.JSPCCarpo.addChangeListener(new ChangeListener() { // from class: Historia.JPHNutricional.6
            public void stateChanged(ChangeEvent evt) {
                JPHNutricional.this.JSPCCarpoStateChanged(evt);
            }
        });
        this.JSPCCarpo.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPHNutricional.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPHNutricional.this.JSPCCarpoPropertyChange(evt);
            }
        });
        this.JLBCCintura.setFont(new Font("Arial", 1, 12));
        this.JLBCCintura.setForeground(new Color(0, 0, 255));
        this.JLBCCintura.setHorizontalAlignment(0);
        this.JLBCCintura.setText("C. Cintura");
        this.JSPCCintura.setFont(new Font("Arial", 1, 12));
        this.JSPCCintura.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JLBCCadera.setFont(new Font("Arial", 1, 12));
        this.JLBCCadera.setForeground(new Color(0, 0, 255));
        this.JLBCCadera.setHorizontalAlignment(0);
        this.JLBCCadera.setText("C. Cadera");
        this.JSPCCadera.setFont(new Font("Arial", 1, 12));
        this.JSPCCadera.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JLBPAgua.setFont(new Font("Arial", 1, 12));
        this.JLBPAgua.setForeground(new Color(0, 0, 255));
        this.JLBPAgua.setHorizontalAlignment(0);
        this.JLBPAgua.setText("% Agua");
        this.JSPPAgua.setFont(new Font("Arial", 1, 12));
        this.JSPPAgua.setModel(new SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.1d));
        this.JLBPGrasa.setFont(new Font("Arial", 1, 12));
        this.JLBPGrasa.setForeground(new Color(0, 0, 255));
        this.JLBPGrasa.setHorizontalAlignment(0);
        this.JLBPGrasa.setText("% Grasa");
        this.JSPPGrasa.setFont(new Font("Arial", 1, 12));
        this.JSPPGrasa.setModel(new SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.1d));
        this.JLBMasaOsea.setFont(new Font("Arial", 1, 12));
        this.JLBMasaOsea.setForeground(new Color(0, 0, 255));
        this.JLBMasaOsea.setHorizontalAlignment(0);
        this.JLBMasaOsea.setText("Masa Osea");
        this.JSPMasaOsea.setFont(new Font("Arial", 1, 12));
        this.JSPMasaOsea.setModel(new SpinnerNumberModel(0.0d, 0.0d, 5.0d, 0.1d));
        this.JLBMasaVic.setFont(new Font("Arial", 1, 12));
        this.JLBMasaVic.setForeground(new Color(0, 0, 255));
        this.JLBMasaVic.setHorizontalAlignment(0);
        this.JLBMasaVic.setText("Masa Vice");
        this.JSPMasaVic.setFont(new Font("Arial", 1, 12));
        this.JSPMasaVic.setModel(new SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.1d));
        this.JSPMasaVic.setPreferredSize((Dimension) null);
        this.JLBPLGrasa.setFont(new Font("Arial", 1, 12));
        this.JLBPLGrasa.setForeground(new Color(0, 0, 255));
        this.JLBPLGrasa.setHorizontalAlignment(0);
        this.JLBPLGrasa.setText("P. Libre Grasa");
        this.JSPPLGrasa.setFont(new Font("Arial", 1, 12));
        this.JSPPLGrasa.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPPLGrasa.setPreferredSize((Dimension) null);
        this.JLBPUsual.setFont(new Font("Arial", 1, 12));
        this.JLBPUsual.setForeground(new Color(0, 0, 255));
        this.JLBPUsual.setHorizontalAlignment(0);
        this.JLBPUsual.setText("P. Usual");
        this.JSPPUsual.setFont(new Font("Arial", 1, 12));
        this.JSPPUsual.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPPUsual.setPreferredSize((Dimension) null);
        this.JLBPObjetivo.setFont(new Font("Arial", 1, 12));
        this.JLBPObjetivo.setForeground(new Color(0, 0, 255));
        this.JLBPObjetivo.setHorizontalAlignment(0);
        this.JLBPObjetivo.setText("P. Objetivo");
        this.JSPPObjetivo.setFont(new Font("Arial", 1, 12));
        this.JSPPObjetivo.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.JSPPObjetivo.setPreferredSize((Dimension) null);
        this.JPIEstructura.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTRUCTURA", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGEstructura.add(this.JRBGrande);
        this.JRBGrande.setFont(new Font("Arial", 1, 12));
        this.JRBGrande.setForeground(new Color(0, 0, 255));
        this.JRBGrande.setSelected(true);
        this.JRBGrande.setText("Grande");
        this.JRBGrande.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.8
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBGrandeActionPerformed(evt);
            }
        });
        this.JBGEstructura.add(this.JRBMediano);
        this.JRBMediano.setFont(new Font("Arial", 1, 12));
        this.JRBMediano.setForeground(new Color(0, 0, 255));
        this.JRBMediano.setText("Mediana");
        this.JRBMediano.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.9
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBMedianoActionPerformed(evt);
            }
        });
        this.JBGEstructura.add(this.JRBPequeno);
        this.JRBPequeno.setFont(new Font("Arial", 1, 12));
        this.JRBPequeno.setForeground(new Color(0, 0, 255));
        this.JRBPequeno.setText("Pequeña");
        this.JRBPequeno.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.10
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBPequenoActionPerformed(evt);
            }
        });
        GroupLayout JPIEstructuraLayout = new GroupLayout(this.JPIEstructura);
        this.JPIEstructura.setLayout(JPIEstructuraLayout);
        JPIEstructuraLayout.setHorizontalGroup(JPIEstructuraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstructuraLayout.createSequentialGroup().addComponent(this.JRBGrande).addGap(10, 10, 10).addComponent(this.JRBMediano).addGap(10, 10, 10).addComponent(this.JRBPequeno)));
        JPIEstructuraLayout.setVerticalGroup(JPIEstructuraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstructuraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBGrande).addComponent(this.JRBPequeno).addComponent(this.JRBMediano)));
        this.JCBTipoPPersonales.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPPersonales.setBorder(BorderFactory.createTitledBorder((Border) null, "RIESGO", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoPPersonales.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.11
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JCBTipoPPersonalesKeyPressed(evt);
            }
        });
        this.JCBTipoEstadoN.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEstadoN.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado Nutricional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoEstadoN.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.12
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JCBTipoEstadoNKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosAntropometricaLayout = new GroupLayout(this.JPIDatosAntropometrica);
        this.JPIDatosAntropometrica.setLayout(JPIDatosAntropometricaLayout);
        JPIDatosAntropometricaLayout.setHorizontalGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPCCintura).addComponent(this.JLBCCintura)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBCCadera).addComponent(this.JSPCCadera, -2, 62, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoPPersonales, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBPAgua, -2, 58, -2).addComponent(this.JSPPAgua, -2, 76, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBPGrasa).addComponent(this.JSPPGrasa, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBMasaOsea).addComponent(this.JSPMasaOsea, -2, 70, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPMasaVic, -1, -1, 32767).addComponent(this.JLBMasaVic)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPPLGrasa, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLBPLGrasa, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBPUsual).addComponent(this.JSPPUsual, -2, 70, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPPObjetivo, -1, 70, 32767).addComponent(this.JLBPObjetivo))).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBSTalla).addComponent(this.JSPTalla, -2, 70, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBSPeso).addComponent(this.JSPPeso, -2, 70, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBSImc, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPIMC, GroupLayout.Alignment.LEADING, -2, 70, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoEstadoN, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPCCarpo).addComponent(this.JLBCCarpo)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIEstructura, -2, -1, -2))).addContainerGap(-1, 32767)));
        JPIDatosAntropometricaLayout.setVerticalGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPPAgua, -2, 30, -2).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBPGrasa, -2, 15, -2).addComponent(this.JLBPAgua, -2, 15, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPGrasa, -2, 30, -2)).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addComponent(this.JLBMasaOsea).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPMasaOsea, -2, 30, -2)).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addComponent(this.JLBPLGrasa, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPLGrasa, -2, 30, -2)).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addComponent(this.JLBMasaVic, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPMasaVic, -2, 30, -2))).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addComponent(this.JLBPUsual, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPUsual, -2, 30, -2)).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addComponent(this.JLBPObjetivo, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPObjetivo, -2, 30, -2)).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addComponent(this.JLBSTalla).addGap(5, 5, 5).addComponent(this.JSPTalla, -2, 30, -2)).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addComponent(this.JLBSPeso).addGap(5, 5, 5).addComponent(this.JSPPeso, -2, 30, -2)).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addComponent(this.JLBSImc).addGap(5, 5, 5).addComponent(this.JSPIMC, -2, 30, -2)).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIEstructura, -2, -1, -2).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addComponent(this.JLBCCarpo).addGap(5, 5, 5).addComponent(this.JSPCCarpo, -2, 30, -2))).addComponent(this.JCBTipoEstadoN, -2, -1, -2)).addGap(25, 25, 25).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBCCadera).addComponent(this.JLBCCintura)).addGap(35, 35, 35)).addGroup(JPIDatosAntropometricaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPCCintura, -2, 30, -2).addComponent(this.JSPCCadera, -2, 30, -2))).addGroup(JPIDatosAntropometricaLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JCBTipoPPersonales, -2, -1, -2))))).addGap(81, 81, 81)));
        this.JPIAAlimentaria.setBorder(BorderFactory.createTitledBorder((Border) null, "ANAMNESIS ALIMENTARIA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDesayuno.setFont(new Font("Arial", 0, 12));
        this.JTPDesayuno.setBorder(BorderFactory.createTitledBorder((Border) null, "Desayuno", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPDesayuno.setFont(new Font("Arial", 1, 12));
        this.JTPDesayuno.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.13
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JTPDesayunoKeyPressed(evt);
            }
        });
        this.JSPDesayuno.setViewportView(this.JTPDesayuno);
        this.JSPMediaManana.setFont(new Font("Arial", 0, 12));
        this.JTPMManana.setBorder(BorderFactory.createTitledBorder((Border) null, "Media Mañana", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPMManana.setFont(new Font("Arial", 1, 12));
        this.JTPMManana.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.14
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JTPMMananaKeyPressed(evt);
            }
        });
        this.JSPMediaManana.setViewportView(this.JTPMManana);
        this.JSPAlmuerzo.setFont(new Font("Arial", 0, 12));
        this.JTPAlmuerzo.setBorder(BorderFactory.createTitledBorder((Border) null, "Almuerzo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPAlmuerzo.setFont(new Font("Arial", 1, 12));
        this.JTPAlmuerzo.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.15
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JTPAlmuerzoKeyPressed(evt);
            }
        });
        this.JSPAlmuerzo.setViewportView(this.JTPAlmuerzo);
        this.JSPMediaTarde.setFont(new Font("Arial", 0, 12));
        this.JTPMediaTarde.setBorder(BorderFactory.createTitledBorder((Border) null, "Media Tarde", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPMediaTarde.setFont(new Font("Arial", 1, 12));
        this.JTPMediaTarde.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.16
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JTPMediaTardeKeyPressed(evt);
            }
        });
        this.JSPMediaTarde.setViewportView(this.JTPMediaTarde);
        this.JSPComida.setFont(new Font("Arial", 0, 12));
        this.JTPComida.setBorder(BorderFactory.createTitledBorder((Border) null, "Comida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPComida.setFont(new Font("Arial", 1, 12));
        this.JTPComida.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.17
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JTPComidaKeyPressed(evt);
            }
        });
        this.JSPComida.setViewportView(this.JTPComida);
        this.JSPAlgo.setFont(new Font("Arial", 0, 12));
        this.JTPAlgo.setBorder(BorderFactory.createTitledBorder((Border) null, "Algo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPAlgo.setFont(new Font("Arial", 1, 12));
        this.JTPAlgo.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.18
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JTPAlgoKeyPressed(evt);
            }
        });
        this.JSPAlgo.setViewportView(this.JTPAlgo);
        this.JPIMastica.setBorder(BorderFactory.createTitledBorder((Border) null, "MASTICA", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGMastica.add(this.JRBRapido);
        this.JRBRapido.setFont(new Font("Arial", 1, 12));
        this.JRBRapido.setForeground(new Color(0, 0, 255));
        this.JRBRapido.setText("Rapido");
        this.JRBRapido.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.19
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBRapidoActionPerformed(evt);
            }
        });
        this.JBGMastica.add(this.JRBDespacio);
        this.JRBDespacio.setFont(new Font("Arial", 1, 12));
        this.JRBDespacio.setForeground(new Color(0, 0, 255));
        this.JRBDespacio.setText("Despacio");
        this.JRBDespacio.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.20
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBDespacioActionPerformed(evt);
            }
        });
        this.JBGMastica.add(this.JRBNormal);
        this.JRBNormal.setFont(new Font("Arial", 1, 12));
        this.JRBNormal.setForeground(new Color(0, 0, 255));
        this.JRBNormal.setSelected(true);
        this.JRBNormal.setText("Normal");
        this.JRBNormal.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.21
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBNormalActionPerformed(evt);
            }
        });
        GroupLayout JPIMasticaLayout = new GroupLayout(this.JPIMastica);
        this.JPIMastica.setLayout(JPIMasticaLayout);
        JPIMasticaLayout.setHorizontalGroup(JPIMasticaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIMasticaLayout.createSequentialGroup().addComponent(this.JRBRapido).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDespacio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBNormal).addContainerGap()));
        JPIMasticaLayout.setVerticalGroup(JPIMasticaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMasticaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDespacio).addComponent(this.JRBRapido).addComponent(this.JRBNormal)));
        this.JSPNVasosA.setFont(new Font("Arial", 1, 12));
        this.JSPNVasosA.setModel(new SpinnerNumberModel(1, 1, 30, 1));
        this.JSPNVasosA.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Vasos Agua", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPNVasosA.addChangeListener(new ChangeListener() { // from class: Historia.JPHNutricional.22
            public void stateChanged(ChangeEvent evt) {
                JPHNutricional.this.JSPNVasosAStateChanged(evt);
            }
        });
        this.JSPNVasosA.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.23
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JSPNVasosAKeyPressed(evt);
            }
        });
        this.JPICMecatosChatarra.setBorder(BorderFactory.createTitledBorder((Border) null, "C. MECATOS/CHATARRA", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGMecatosC.add(this.JRBComidaSi);
        this.JRBComidaSi.setFont(new Font("Arial", 1, 12));
        this.JRBComidaSi.setForeground(new Color(0, 0, 255));
        this.JRBComidaSi.setText("Si");
        this.JRBComidaSi.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.24
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBComidaSiActionPerformed(evt);
            }
        });
        this.JBGMecatosC.add(this.JRBComidaNo);
        this.JRBComidaNo.setFont(new Font("Arial", 1, 12));
        this.JRBComidaNo.setForeground(new Color(0, 0, 255));
        this.JRBComidaNo.setSelected(true);
        this.JRBComidaNo.setText("No");
        this.JRBComidaNo.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.25
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBComidaNoActionPerformed(evt);
            }
        });
        GroupLayout JPICMecatosChatarraLayout = new GroupLayout(this.JPICMecatosChatarra);
        this.JPICMecatosChatarra.setLayout(JPICMecatosChatarraLayout);
        JPICMecatosChatarraLayout.setHorizontalGroup(JPICMecatosChatarraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPICMecatosChatarraLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JRBComidaSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, 32767).addComponent(this.JRBComidaNo)));
        JPICMecatosChatarraLayout.setVerticalGroup(JPICMecatosChatarraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICMecatosChatarraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBComidaNo).addComponent(this.JRBComidaSi)));
        this.JPICFritos.setBorder(BorderFactory.createTitledBorder((Border) null, "C. FRITOS", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGCFritos.add(this.JRBCFritosSi);
        this.JRBCFritosSi.setFont(new Font("Arial", 1, 12));
        this.JRBCFritosSi.setForeground(new Color(0, 0, 255));
        this.JRBCFritosSi.setText("Si");
        this.JRBCFritosSi.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.26
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBCFritosSiActionPerformed(evt);
            }
        });
        this.JBGCFritos.add(this.JRBCFritosNo);
        this.JRBCFritosNo.setFont(new Font("Arial", 1, 12));
        this.JRBCFritosNo.setForeground(new Color(0, 0, 255));
        this.JRBCFritosNo.setSelected(true);
        this.JRBCFritosNo.setText("No");
        this.JRBCFritosNo.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.27
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBCFritosNoActionPerformed(evt);
            }
        });
        GroupLayout JPICFritosLayout = new GroupLayout(this.JPICFritos);
        this.JPICFritos.setLayout(JPICFritosLayout);
        JPICFritosLayout.setHorizontalGroup(JPICFritosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICFritosLayout.createSequentialGroup().addComponent(this.JRBCFritosSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCFritosNo).addContainerGap(-1, 32767)));
        JPICFritosLayout.setVerticalGroup(JPICFritosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICFritosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCFritosSi).addComponent(this.JRBCFritosNo)));
        this.JPIDietasAnteriores.setBorder(BorderFactory.createTitledBorder((Border) null, "DIESTAS ANTERIORES", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGDietasA.add(this.JRBDietasASi);
        this.JRBDietasASi.setFont(new Font("Arial", 1, 12));
        this.JRBDietasASi.setForeground(new Color(0, 0, 255));
        this.JRBDietasASi.setText("Si");
        this.JRBDietasASi.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.28
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBDietasASiActionPerformed(evt);
            }
        });
        this.JBGDietasA.add(this.JRBDietasANo);
        this.JRBDietasANo.setFont(new Font("Arial", 1, 12));
        this.JRBDietasANo.setForeground(new Color(0, 0, 255));
        this.JRBDietasANo.setSelected(true);
        this.JRBDietasANo.setText("No");
        this.JRBDietasANo.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.29
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JRBDietasANoActionPerformed(evt);
            }
        });
        GroupLayout JPIDietasAnterioresLayout = new GroupLayout(this.JPIDietasAnteriores);
        this.JPIDietasAnteriores.setLayout(JPIDietasAnterioresLayout);
        JPIDietasAnterioresLayout.setHorizontalGroup(JPIDietasAnterioresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDietasAnterioresLayout.createSequentialGroup().addComponent(this.JRBDietasASi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBDietasANo).addContainerGap()));
        JPIDietasAnterioresLayout.setVerticalGroup(JPIDietasAnterioresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDietasAnterioresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDietasASi).addComponent(this.JRBDietasANo)));
        this.JSPAPreferidos.setFont(new Font("Arial", 0, 12));
        this.JTPAPreferidos.setBorder(BorderFactory.createTitledBorder((Border) null, "Alimentos Preferidos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPAPreferidos.setFont(new Font("Arial", 1, 12));
        this.JTPAPreferidos.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.30
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JTPAPreferidosKeyPressed(evt);
            }
        });
        this.JSPAPreferidos.setViewportView(this.JTPAPreferidos);
        this.JSPARechazados.setFont(new Font("Arial", 0, 12));
        this.JTPARechazados.setBorder(BorderFactory.createTitledBorder((Border) null, "Alimentos Rechazados", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPARechazados.setFont(new Font("Arial", 1, 12));
        this.JTPARechazados.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.31
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JTPARechazadosKeyPressed(evt);
            }
        });
        this.JSPARechazados.setViewportView(this.JTPARechazados);
        this.JSPATolerados.setFont(new Font("Arial", 0, 12));
        this.JTPATolerados.setBorder(BorderFactory.createTitledBorder((Border) null, "Alimentos no Tolerados", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPATolerados.setFont(new Font("Arial", 1, 12));
        this.JTPATolerados.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.32
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JTPAToleradosKeyPressed(evt);
            }
        });
        this.JSPATolerados.setViewportView(this.JTPATolerados);
        GroupLayout JPIAAlimentariaLayout = new GroupLayout(this.JPIAAlimentaria);
        this.JPIAAlimentaria.setLayout(JPIAAlimentariaLayout);
        JPIAAlimentariaLayout.setHorizontalGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAAlimentariaLayout.createSequentialGroup().addContainerGap().addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAAlimentariaLayout.createSequentialGroup().addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPAPreferidos, GroupLayout.Alignment.LEADING).addComponent(this.JPIMastica, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIAAlimentariaLayout.createSequentialGroup().addComponent(this.JSPNVasosA, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPICMecatosChatarra, -2, -1, -2)).addComponent(this.JSPARechazados)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAAlimentariaLayout.createSequentialGroup().addComponent(this.JPICFritos, -2, -1, -2).addGap(26, 26, 26).addComponent(this.JPIDietasAnteriores, -1, -1, 32767)).addComponent(this.JSPATolerados))).addGroup(JPIAAlimentariaLayout.createSequentialGroup().addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPComida).addComponent(this.JSPAlmuerzo).addComponent(this.JSPDesayuno, -1, 353, 32767)).addGap(70, 70, 70).addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPAlgo).addComponent(this.JSPMediaTarde).addComponent(this.JSPMediaManana, -1, 389, 32767)))).addContainerGap()));
        JPIAAlimentariaLayout.setVerticalGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAAlimentariaLayout.createSequentialGroup().addContainerGap().addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPMediaManana, -1, 51, 32767).addComponent(this.JSPDesayuno)).addGap(17, 17, 17).addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPAlmuerzo, -1, 60, 32767).addComponent(this.JSPMediaTarde)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPComida, -1, 61, 32767).addComponent(this.JSPAlgo)).addGap(15, 15, 15).addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPICMecatosChatarra, -2, -1, -2).addComponent(this.JPIMastica, -2, -1, -2).addComponent(this.JPICFritos, -2, -1, -2).addComponent(this.JPIDietasAnteriores, -2, -1, -2).addComponent(this.JSPNVasosA, -2, -1, -2)).addGap(15, 15, 15).addGroup(JPIAAlimentariaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPARechazados).addComponent(this.JSPAPreferidos).addComponent(this.JSPATolerados)).addContainerGap()));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.33
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTGrabar.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.34
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JBTGrabarKeyPressed(evt);
            }
        });
        this.JBTCHistorial.setFont(new Font("Arial", 1, 12));
        this.JBTCHistorial.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTCHistorial.setText("Consultar Historial");
        this.JBTCHistorial.addActionListener(new ActionListener() { // from class: Historia.JPHNutricional.35
            public void actionPerformed(ActionEvent evt) {
                JPHNutricional.this.JBTCHistorialActionPerformed(evt);
            }
        });
        this.JBTCHistorial.addKeyListener(new KeyAdapter() { // from class: Historia.JPHNutricional.36
            public void keyPressed(KeyEvent evt) {
                JPHNutricional.this.JBTCHistorialKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosAntropometrica, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIAAlimentaria, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBTGrabar, -1, -1, 32767).addComponent(this.JBTCHistorial, -1, -1, 32767)).addGap(15, 15, 15)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosAntropometrica, -2, 182, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIAAlimentaria, -2, -1, -2).addGap(13, 13, 13).addComponent(this.JBTCHistorial).addGap(18, 18, 18).addComponent(this.JBTGrabar).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRapidoActionPerformed(ActionEvent evt) {
        this.xmastica = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDespacioActionPerformed(ActionEvent evt) {
        this.xmastica = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBComidaNoActionPerformed(ActionEvent evt) {
        this.xcchatarra = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBComidaSiActionPerformed(ActionEvent evt) {
        this.xcchatarra = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCFritosSiActionPerformed(ActionEvent evt) {
        this.xcfritos = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCFritosNoActionPerformed(ActionEvent evt) {
        this.xcfritos = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDietasASiActionPerformed(ActionEvent evt) {
        this.xdanteriores = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDietasANoActionPerformed(ActionEvent evt) {
        this.xdanteriores = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPTallaStateChanged(ChangeEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPTallaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JSPTalla.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPesoStateChanged(ChangeEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPesoFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPesoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            calcularImc();
            this.JSPPeso.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNormalActionPerformed(ActionEvent evt) {
        this.xmastica = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPNVasosAStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPNVasosAKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGrandeActionPerformed(ActionEvent evt) {
        this.xestructura = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMedianoActionPerformed(ActionEvent evt) {
        this.xestructura = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPequenoActionPerformed(ActionEvent evt) {
        this.xestructura = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoPPersonalesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoPPersonales.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCCarpoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCCarpoStateChanged(ChangeEvent evt) {
        mCalcularEstructura();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDesayunoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPDesayuno.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPMMananaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPMManana.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPAlmuerzoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPAlmuerzo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPMediaTardeKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPMediaTarde.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPComidaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPComida.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPAlgoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPAlgo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPAPreferidosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPAPreferidos.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPARechazadosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPARechazados.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPAToleradosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPATolerados.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEstadoNKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCHistorialActionPerformed(ActionEvent evt) {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "idusuario";
        String[] strArr = parametros[0];
        clasesHistoriaCE claseshistoriace = this.xclaseh;
        strArr[1] = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        parametros[1][0] = "usuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_HistoricoNutricional", parametros);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCHistorialKeyPressed(KeyEvent evt) {
    }

    private void calcularImc() {
        if (((Double) this.JSPTalla.getValue()).doubleValue() != 0.0d) {
            this.JSPIMC.setValue(Double.valueOf(Double.parseDouble(this.xdecf.format(((Double) this.JSPPeso.getValue()).doubleValue() / Math.pow(((Double) this.JSPTalla.getValue()).doubleValue() / 100.0d, 2.0d)).replaceAll(",", "."))));
            this.imc = Double.parseDouble(this.xdecf.format(((Double) this.JSPPeso.getValue()).doubleValue() / Math.pow(((Double) this.JSPTalla.getValue()).doubleValue() / 100.0d, 2.0d)).replaceAll(",", "."));
        }
    }

    private void mCalcularEstructura() {
        double lrs = Double.parseDouble(this.xdecf.format(((Double) this.JSPTalla.getValue()).doubleValue() / ((Double) this.JSPCCarpo.getValue()).doubleValue()).replaceAll(",", "."));
        clasesHistoriaCE claseshistoriace = this.xclaseh;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo().equals("M")) {
            if (lrs < 9.6d) {
                this.xestructura = 0;
                this.JRBGrande.setSelected(true);
                return;
            } else if (lrs >= 9.6d && lrs <= 10.4d) {
                this.xestructura = 1;
                this.JRBMediano.setSelected(true);
                return;
            } else {
                if (lrs > 10.4d) {
                    this.xestructura = 2;
                    this.JRBPequeno.setSelected(true);
                    return;
                }
                return;
            }
        }
        if (lrs < 10.1d) {
            this.xestructura = 0;
            this.JRBGrande.setSelected(true);
        } else if (lrs >= 10.1d && lrs <= 11.0d) {
            this.xestructura = 1;
            this.JRBMediano.setSelected(true);
        } else if (lrs > 11.0d) {
            this.xestructura = 2;
            this.JRBPequeno.setSelected(true);
        }
    }

    public void mGrabarBd() {
        if (!this.xestado) {
            if (this.JCBTipoEstadoN.getSelectedIndex() != -1) {
                StringBuilder sbAppend = new StringBuilder().append("INSERT INTO h_nutricional (Id_Atencion, Talla, Peso, Imc, Id_tipoestadonutricional, CCarpo, EstructuraM, CCintura, CCadera, Id_Riesgo, PAgua, PGrasa, MOsea, MViceral, PesoLGrasa, PesoUsual, PesoObjetivo, TDesayuno, TMManana, TAlmuerzo, TMediaTarde, TComida, TAlgo, Mastica, NVAgua, Mecatos, Fritos, DietasAnteriores, ARequeridos, ARechazados, ANoTolerados) VALUES ( '");
                clasesHistoriaCE claseshistoriace = this.xclaseh;
                String sql = sbAppend.append(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).append("','").append(this.JSPTalla.getValue()).append("','").append(this.JSPPeso.getValue()).append("','").append(this.JSPIMC.getValue()).append("','").append(this.xidestadon[this.JCBTipoEstadoN.getSelectedIndex()][0]).append("','").append(this.JSPCCarpo.getValue()).append("','").append(this.xestructura).append("','").append(this.JSPCCintura.getValue()).append("','").append(this.JSPCCadera.getValue()).append("','").append(this.xidgen[this.JCBTipoPPersonales.getSelectedIndex()]).append("','").append(this.JSPPAgua.getValue()).append("','").append(this.JSPPGrasa.getValue()).append("','").append(this.JSPMasaOsea.getValue()).append("','").append(this.JSPMasaVic.getValue()).append("','").append(this.JSPPLGrasa.getValue()).append("','").append(this.JSPPUsual.getValue()).append("','").append(this.JSPPObjetivo.getValue()).append("','").append(this.JTPDesayuno.getText()).append("','").append(this.JTPMManana.getText()).append("','").append(this.JTPAlmuerzo.getText()).append("','").append(this.JTPMediaTarde.getText()).append("','").append(this.JTPComida.getText()).append("','").append(this.JTPAlgo.getText()).append("','").append(this.xmastica).append("','").append(this.JSPNVasosA.getValue()).append("','").append(this.xcchatarra).append("','").append(this.xcfritos).append("','").append(this.xdanteriores).append("','").append(this.JTPAPreferidos.getText()).append("','").append(this.JTPARechazados.getText()).append("','").append(this.JTPATolerados.getText()).append("')").toString();
                this.consultas.ejecutarSQL(sql);
                this.consultas.cerrarConexionBd();
                this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe selecionar un estado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoEstadoN.requestFocus();
        }
    }

    private void mBuscarDatosBd() {
        clasesHistoriaCE claseshistoriace = this.xclaseh;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
            try {
                StringBuilder sbAppend = new StringBuilder().append("SELECT h_nutricional.Talla, h_nutricional.Peso, h_nutricional.Imc, h_tipoestadonutricional.Nbre, h_nutricional.CCarpo, h_nutricional.EstructuraM, h_nutricional.CCintura, h_nutricional.CCadera, h_tiporiesgoemb.Nbre , h_nutricional.PAgua, h_nutricional.PGrasa, h_nutricional.MOsea, h_nutricional.MViceral, h_nutricional.PesoLGrasa, h_nutricional.PesoUsual, h_nutricional.PesoObjetivo, h_nutricional.TDesayuno, h_nutricional.TMManana, h_nutricional.TAlmuerzo  , h_nutricional.TMediaTarde, h_nutricional.TComida, h_nutricional.TAlgo, h_nutricional.Mastica, h_nutricional.NVAgua, h_nutricional.Mecatos, h_nutricional.Fritos, h_nutricional.DietasAnteriores, h_nutricional.ARequeridos, h_nutricional.ARechazados, h_nutricional.ANoTolerados FROM h_tipoestadonutricional INNER JOIN h_nutricional  ON (h_tipoestadonutricional.Id = h_nutricional.Id_tipoestadonutricional) INNER JOIN h_tiporiesgoemb ON (h_nutricional.Id_Riesgo = h_tiporiesgoemb.Id) WHERE (h_nutricional.Id_Atencion ='");
                clasesHistoriaCE claseshistoriace2 = this.xclaseh;
                String sql = sbAppend.append(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).append("' and h_nutricional.Estado=1) ").toString();
                ResultSet xrs = this.consultas.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    this.JSPTalla.setValue(Double.valueOf(xrs.getDouble(1)));
                    this.JSPPeso.setValue(Double.valueOf(xrs.getDouble(2)));
                    this.JSPIMC.setValue(Double.valueOf(xrs.getDouble(3)));
                    this.JCBTipoEstadoN.setSelectedItem(xrs.getString(4));
                    this.JSPCCarpo.setValue(Double.valueOf(xrs.getDouble(5)));
                    if (xrs.getInt(6) == 0) {
                        this.JRBGrande.setSelected(true);
                    } else if (xrs.getInt(6) == 1) {
                        this.JRBMediano.setSelected(true);
                    } else {
                        this.JRBNormal.setSelected(true);
                    }
                    this.JSPCCintura.setValue(Double.valueOf(xrs.getDouble(7)));
                    this.JSPCCadera.setValue(Double.valueOf(xrs.getDouble(8)));
                    this.JCBTipoPPersonales.setSelectedItem(xrs.getString(9));
                    this.JSPPAgua.setValue(Double.valueOf(xrs.getDouble(10)));
                    this.JSPPGrasa.setValue(Double.valueOf(xrs.getDouble(11)));
                    this.JSPMasaOsea.setValue(Double.valueOf(xrs.getDouble(12)));
                    this.JSPMasaVic.setValue(Double.valueOf(xrs.getDouble(13)));
                    this.JSPPLGrasa.setValue(Double.valueOf(xrs.getDouble(14)));
                    this.JSPPUsual.setValue(Double.valueOf(xrs.getDouble(15)));
                    this.JSPPObjetivo.setValue(Double.valueOf(xrs.getDouble(16)));
                    this.JTPDesayuno.setText(xrs.getString(17));
                    this.JTPMManana.setText(xrs.getString(18));
                    this.JTPAlmuerzo.setText(xrs.getString(19));
                    this.JTPMediaTarde.setText(xrs.getString(20));
                    this.JTPComida.setText(xrs.getString(21));
                    this.JTPAlgo.setText(xrs.getString(22));
                    if (xrs.getInt(23) == 0) {
                        this.JRBRapido.setSelected(true);
                    } else if (xrs.getInt(23) == 1) {
                        this.JRBDespacio.setSelected(true);
                    } else {
                        this.JRBNormal.setSelected(true);
                    }
                    this.JSPNVasosA.setValue(Double.valueOf(xrs.getDouble(24)));
                    if (xrs.getInt(25) == 0) {
                        this.JRBComidaNo.setSelected(true);
                    } else {
                        this.JRBComidaSi.setSelected(true);
                    }
                    if (xrs.getInt(26) == 0) {
                        this.JRBCFritosNo.setSelected(true);
                    } else {
                        this.JRBCFritosSi.setSelected(true);
                    }
                    if (xrs.getInt(27) == 0) {
                        this.JRBDietasANo.setSelected(true);
                    } else {
                        this.JRBDietasASi.setSelected(true);
                    }
                    this.JTPAPreferidos.setText(xrs.getString(28));
                    this.JTPARechazados.setText(xrs.getString(29));
                    this.JTPATolerados.setText(xrs.getString(29));
                    this.JBTGrabar.setEnabled(false);
                    this.xestado = true;
                    this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
                xrs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPHNutricional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
