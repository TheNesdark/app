package Historia;

import Acceso.Principal;
import Odontologia.JIFHistoriaOdontologica;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAntecedentesPediatricos.class */
public class JPAAntecedentesPediatricos extends JPanel {
    private Metodos xmetodo;
    private ConsultasMySQL xconsultasbd;
    private clasesHistoriaCE xclase;
    private int xestadon;
    private int xcianosis;
    private int xictericia;
    private int xconvulciones;
    private int xduelo;
    private int xsuicidio;
    private int xseparacionp;
    private int xalcoholf;
    private int xencontro;
    private String[] xidgen;
    private String[] xnescolar;
    private String[] xrparto;
    private int xmod;
    public long xidusuario;
    private String xidatencion;
    private JIFHistoriaOdontologica xjifcho;
    private ButtonGroup JBGAlcoholFarma;
    private ButtonGroup JBGCianosis;
    private ButtonGroup JBGConvulciones;
    private ButtonGroup JBGDuelo;
    private ButtonGroup JBGEstadoN;
    private ButtonGroup JBGIctericia;
    private ButtonGroup JBGSeparacion;
    private ButtonGroup JBGSuicidio;
    private JButton JBTAdicionarPat;
    private JComboBox JCBAComplementaria;
    private JComboBox JCBAMaterna;
    private JComboBox JCBAMixta;
    private JComboBox JCBCamino;
    private JComboBox JCBControlEsf;
    private JComboBox JCBDenticion;
    private JComboBox JCBDuracionS;
    private JComboBox JCBOHistoriaEscolar;
    private JComboBox JCBPrimerasPalabra;
    private JComboBox JCBSentoSolo;
    private JComboBox JCBSostuvoCabeza;
    private JComboBox JCBTipoParto;
    private JComboBox JCBgateo;
    private JComboBox JCUnidadDeTiempo;
    private JPanel JPIAlcoholFarm;
    private JPanel JPICianosis;
    private JPanel JPIConvulciones;
    private JPanel JPIDalimentacion;
    private JPanel JPIDatosNac;
    private JPanel JPIDatosOtros;
    private JPanel JPIDuelo;
    private JPanel JPIEstadoNacer;
    private JPanel JPIIctericia;
    private JPanel JPIOtros;
    private JPanel JPISeparacionP;
    private JPanel JPISuicidio;
    private JRadioButton JRBAlcoholFarmNo;
    private JRadioButton JRBAlcoholFarmSi;
    private JRadioButton JRBCianosisNo;
    private JRadioButton JRBCianosisSi;
    private JRadioButton JRBConvulcionesNo;
    private JRadioButton JRBConvulcionesSi;
    private JRadioButton JRBDueloNo;
    private JRadioButton JRBDueloSi;
    private JRadioButton JRBIctericiaNo;
    private JRadioButton JRBIctericiaSi;
    private JRadioButton JRBMuerto;
    private JRadioButton JRBSeparacionPNo;
    private JRadioButton JRBSeparacionPSi;
    private JRadioButton JRBSuicidioNo;
    private JRadioButton JRBSuicidioSi;
    private JRadioButton JRBVivo;
    private JScrollPane JSPAActual;
    private JSpinner JSPEdadM;
    private JScrollPane JSPEnferndadesDG;
    private JScrollPane JSPEstadoDPS;
    private JSpinner JSPGestacionN;
    private JScrollPane JSPOOtros;
    private JScrollPane JSPOtros;
    private JScrollPane JSPOtrosM;
    private JScrollPane JSPTrastornosAlimentarios;
    private JScrollPane JSPTrastornosDg;
    private JFormattedTextField JTFFPEncefalico;
    private JFormattedTextField JTFFPeso;
    private JFormattedTextField JTFFTalla;
    private JTextPane JTPAActual;
    private JTabbedPane JTPAPediatricos;
    private JTextPane JTPEnferndadesDG;
    private JTextPane JTPEstadoDPS;
    private JTextPane JTPOOtros;
    private JTextPane JTPOtrosDn;
    private JTextPane JTPOtrosM;
    private JTextPane JTPTrastornosAlimentarios;
    private JTextPane JTPTrastornosDg;

    public JPAAntecedentesPediatricos(clasesHistoriaCE xclase, int xmod) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xestadon = 1;
        this.xcianosis = 0;
        this.xictericia = 0;
        this.xconvulciones = 0;
        this.xduelo = 0;
        this.xsuicidio = 0;
        this.xseparacionp = 0;
        this.xalcoholf = 0;
        this.xencontro = 0;
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mNuevo();
    }

    public JPAAntecedentesPediatricos(JIFHistoriaOdontologica xjifcho, int xmod) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xestadon = 1;
        this.xcianosis = 0;
        this.xictericia = 0;
        this.xconvulciones = 0;
        this.xduelo = 0;
        this.xsuicidio = 0;
        this.xseparacionp = 0;
        this.xalcoholf = 0;
        this.xencontro = 0;
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xjifcho = xjifcho;
        mNuevo();
    }

    public JPAAntecedentesPediatricos(String xid_persona, String xid_Atencion) {
        this.xmetodo = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        this.xestadon = 1;
        this.xcianosis = 0;
        this.xictericia = 0;
        this.xconvulciones = 0;
        this.xduelo = 0;
        this.xsuicidio = 0;
        this.xseparacionp = 0;
        this.xalcoholf = 0;
        this.xencontro = 0;
        this.xmod = -1;
        initComponents();
        this.xidusuario = Long.valueOf(xid_persona).longValue();
        this.xidatencion = xid_Atencion;
        mNuevo();
    }

    private void initComponents() {
        this.JBGEstadoN = new ButtonGroup();
        this.JBGCianosis = new ButtonGroup();
        this.JBGIctericia = new ButtonGroup();
        this.JBGConvulciones = new ButtonGroup();
        this.JBGDuelo = new ButtonGroup();
        this.JBGSuicidio = new ButtonGroup();
        this.JBGSeparacion = new ButtonGroup();
        this.JBGAlcoholFarma = new ButtonGroup();
        this.JTPAPediatricos = new JTabbedPane();
        this.JPIDatosNac = new JPanel();
        this.JSPEdadM = new JSpinner();
        this.JCBDuracionS = new JComboBox();
        this.JSPEnferndadesDG = new JScrollPane();
        this.JTPEnferndadesDG = new JTextPane();
        this.JTFFPeso = new JFormattedTextField();
        this.JTFFTalla = new JFormattedTextField();
        this.JTFFPEncefalico = new JFormattedTextField();
        this.JSPEstadoDPS = new JScrollPane();
        this.JTPEstadoDPS = new JTextPane();
        this.JSPTrastornosDg = new JScrollPane();
        this.JTPTrastornosDg = new JTextPane();
        this.JPICianosis = new JPanel();
        this.JRBCianosisSi = new JRadioButton();
        this.JRBCianosisNo = new JRadioButton();
        this.JPIConvulciones = new JPanel();
        this.JRBIctericiaSi = new JRadioButton();
        this.JRBIctericiaNo = new JRadioButton();
        this.JPIIctericia = new JPanel();
        this.JRBConvulcionesSi = new JRadioButton();
        this.JRBConvulcionesNo = new JRadioButton();
        this.JSPOtros = new JScrollPane();
        this.JTPOtrosDn = new JTextPane();
        this.JCBSostuvoCabeza = new JComboBox();
        this.JCBSentoSolo = new JComboBox();
        this.JCBCamino = new JComboBox();
        this.JCBPrimerasPalabra = new JComboBox();
        this.JCBDenticion = new JComboBox();
        this.JCBControlEsf = new JComboBox();
        this.JSPOtrosM = new JScrollPane();
        this.JTPOtrosM = new JTextPane();
        this.JPIEstadoNacer = new JPanel();
        this.JRBVivo = new JRadioButton();
        this.JRBMuerto = new JRadioButton();
        this.JCBTipoParto = new JComboBox();
        this.JSPGestacionN = new JSpinner();
        this.JCBgateo = new JComboBox();
        this.JCUnidadDeTiempo = new JComboBox();
        this.JPIDatosOtros = new JPanel();
        this.JPIDalimentacion = new JPanel();
        this.JCBAMaterna = new JComboBox();
        this.JCBAMixta = new JComboBox();
        this.JCBAComplementaria = new JComboBox();
        this.JSPAActual = new JScrollPane();
        this.JTPAActual = new JTextPane();
        this.JSPTrastornosAlimentarios = new JScrollPane();
        this.JTPTrastornosAlimentarios = new JTextPane();
        this.JPIOtros = new JPanel();
        this.JCBOHistoriaEscolar = new JComboBox();
        this.JSPOOtros = new JScrollPane();
        this.JTPOOtros = new JTextPane();
        this.JPIDuelo = new JPanel();
        this.JRBDueloSi = new JRadioButton();
        this.JRBDueloNo = new JRadioButton();
        this.JPISuicidio = new JPanel();
        this.JRBSuicidioSi = new JRadioButton();
        this.JRBSuicidioNo = new JRadioButton();
        this.JPISeparacionP = new JPanel();
        this.JRBSeparacionPSi = new JRadioButton();
        this.JRBSeparacionPNo = new JRadioButton();
        this.JPIAlcoholFarm = new JPanel();
        this.JRBAlcoholFarmSi = new JRadioButton();
        this.JRBAlcoholFarmNo = new JRadioButton();
        this.JBTAdicionarPat = new JButton();
        setName("jpaantecedentespediatricos");
        setPreferredSize(new Dimension(852, 384));
        addAncestorListener(new AncestorListener() { // from class: Historia.JPAAntecedentesPediatricos.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAAntecedentesPediatricos.this.formAncestorRemoved(evt);
            }
        });
        this.JTPAPediatricos.setForeground(new Color(0, 103, 0));
        this.JTPAPediatricos.setFont(new Font("Arial", 1, 14));
        this.JSPEdadM.setFont(new Font("Arial", 1, 12));
        this.JSPEdadM.setModel(new SpinnerNumberModel(1, 1, 70, 1));
        this.JSPEdadM.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad(Madre)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDuracionS.setFont(new Font("Arial", 1, 12));
        this.JCBDuracionS.setBorder(BorderFactory.createTitledBorder((Border) null, "Duracion Semanas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEnferndadesDG.setFont(new Font("Arial", 0, 12));
        this.JTPEnferndadesDG.setBorder(BorderFactory.createTitledBorder((Border) null, "Enfermedades durante la gestación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEnferndadesDG.setFont(new Font("Arial", 1, 12));
        this.JSPEnferndadesDG.setViewportView(this.JTPEnferndadesDG);
        this.JTFFPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPeso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFPeso.setHorizontalAlignment(4);
        this.JTFFPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFPeso.setValue(new Integer(0));
        this.JTFFTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTalla.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFTalla.setHorizontalAlignment(4);
        this.JTFFTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFTalla.setValue(new Integer(0));
        this.JTFFPEncefalico.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Enc.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPEncefalico.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFPEncefalico.setHorizontalAlignment(4);
        this.JTFFPEncefalico.setFont(new Font("Arial", 1, 12));
        this.JTFFPEncefalico.setValue(new Integer(0));
        this.JSPEstadoDPS.setFont(new Font("Arial", 0, 12));
        this.JTPEstadoDPS.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado durante la primera semana", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEstadoDPS.setFont(new Font("Arial", 1, 12));
        this.JSPEstadoDPS.setViewportView(this.JTPEstadoDPS);
        this.JSPTrastornosDg.setFont(new Font("Arial", 0, 12));
        this.JTPTrastornosDg.setBorder(BorderFactory.createTitledBorder((Border) null, "Trastornos Digestivos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPTrastornosDg.setFont(new Font("Arial", 1, 12));
        this.JSPTrastornosDg.setViewportView(this.JTPTrastornosDg);
        this.JPICianosis.setBorder(BorderFactory.createTitledBorder((Border) null, "CIANOSIS", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGCianosis.add(this.JRBCianosisSi);
        this.JRBCianosisSi.setFont(new Font("Arial", 1, 12));
        this.JRBCianosisSi.setForeground(Color.blue);
        this.JRBCianosisSi.setText("Si");
        this.JRBCianosisSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.2
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBCianosisSiActionPerformed(evt);
            }
        });
        this.JBGCianosis.add(this.JRBCianosisNo);
        this.JRBCianosisNo.setFont(new Font("Arial", 1, 12));
        this.JRBCianosisNo.setForeground(Color.blue);
        this.JRBCianosisNo.setSelected(true);
        this.JRBCianosisNo.setText("No");
        this.JRBCianosisNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.3
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBCianosisNoActionPerformed(evt);
            }
        });
        GroupLayout JPICianosisLayout = new GroupLayout(this.JPICianosis);
        this.JPICianosis.setLayout(JPICianosisLayout);
        JPICianosisLayout.setHorizontalGroup(JPICianosisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICianosisLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBCianosisSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCianosisNo)));
        JPICianosisLayout.setVerticalGroup(JPICianosisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICianosisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCianosisSi).addComponent(this.JRBCianosisNo)));
        this.JPIConvulciones.setBorder(BorderFactory.createTitledBorder((Border) null, "CONVULSIONES", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGIctericia.add(this.JRBIctericiaSi);
        this.JRBIctericiaSi.setFont(new Font("Arial", 1, 12));
        this.JRBIctericiaSi.setForeground(Color.blue);
        this.JRBIctericiaSi.setText("Si");
        this.JRBIctericiaSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.4
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBIctericiaSiActionPerformed(evt);
            }
        });
        this.JBGIctericia.add(this.JRBIctericiaNo);
        this.JRBIctericiaNo.setFont(new Font("Arial", 1, 12));
        this.JRBIctericiaNo.setForeground(Color.blue);
        this.JRBIctericiaNo.setSelected(true);
        this.JRBIctericiaNo.setText("No");
        this.JRBIctericiaNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.5
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBIctericiaNoActionPerformed(evt);
            }
        });
        GroupLayout JPIConvulcionesLayout = new GroupLayout(this.JPIConvulciones);
        this.JPIConvulciones.setLayout(JPIConvulcionesLayout);
        JPIConvulcionesLayout.setHorizontalGroup(JPIConvulcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConvulcionesLayout.createSequentialGroup().addComponent(this.JRBIctericiaSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBIctericiaNo).addContainerGap(62, 32767)));
        JPIConvulcionesLayout.setVerticalGroup(JPIConvulcionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConvulcionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBIctericiaSi).addComponent(this.JRBIctericiaNo)));
        this.JPIIctericia.setBorder(BorderFactory.createTitledBorder((Border) null, "ICTERICIA", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGConvulciones.add(this.JRBConvulcionesSi);
        this.JRBConvulcionesSi.setFont(new Font("Arial", 1, 12));
        this.JRBConvulcionesSi.setForeground(Color.blue);
        this.JRBConvulcionesSi.setText("Si");
        this.JRBConvulcionesSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.6
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBConvulcionesSiActionPerformed(evt);
            }
        });
        this.JBGConvulciones.add(this.JRBConvulcionesNo);
        this.JRBConvulcionesNo.setFont(new Font("Arial", 1, 12));
        this.JRBConvulcionesNo.setForeground(Color.blue);
        this.JRBConvulcionesNo.setSelected(true);
        this.JRBConvulcionesNo.setText("No");
        this.JRBConvulcionesNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.7
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBConvulcionesNoActionPerformed(evt);
            }
        });
        GroupLayout JPIIctericiaLayout = new GroupLayout(this.JPIIctericia);
        this.JPIIctericia.setLayout(JPIIctericiaLayout);
        JPIIctericiaLayout.setHorizontalGroup(JPIIctericiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIctericiaLayout.createSequentialGroup().addComponent(this.JRBConvulcionesSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBConvulcionesNo).addContainerGap()));
        JPIIctericiaLayout.setVerticalGroup(JPIIctericiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIctericiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBConvulcionesSi).addComponent(this.JRBConvulcionesNo)));
        this.JSPOtros.setFont(new Font("Arial", 0, 12));
        this.JTPOtrosDn.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPOtrosDn.setFont(new Font("Arial", 1, 12));
        this.JSPOtros.setViewportView(this.JTPOtrosDn);
        this.JCBSostuvoCabeza.setFont(new Font("Arial", 1, 12));
        this.JCBSostuvoCabeza.setBorder(BorderFactory.createTitledBorder((Border) null, "Sostuvo la Cabeza", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSostuvoCabeza.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.8
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JCBSostuvoCabezaActionPerformed(evt);
            }
        });
        this.JCBSentoSolo.setFont(new Font("Arial", 1, 12));
        this.JCBSentoSolo.setBorder(BorderFactory.createTitledBorder((Border) null, "Se sentó solo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSentoSolo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.9
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JCBSentoSoloActionPerformed(evt);
            }
        });
        this.JCBCamino.setFont(new Font("Arial", 1, 12));
        this.JCBCamino.setBorder(BorderFactory.createTitledBorder((Border) null, "Camino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPrimerasPalabra.setFont(new Font("Arial", 1, 12));
        this.JCBPrimerasPalabra.setBorder(BorderFactory.createTitledBorder((Border) null, "Primeras Palabra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDenticion.setFont(new Font("Arial", 1, 12));
        this.JCBDenticion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dentición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDenticion.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.10
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JCBDenticionActionPerformed(evt);
            }
        });
        this.JCBControlEsf.setFont(new Font("Arial", 1, 12));
        this.JCBControlEsf.setBorder(BorderFactory.createTitledBorder((Border) null, "Control de esfínteres", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPOtrosM.setFont(new Font("Arial", 0, 12));
        this.JTPOtrosM.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPOtrosM.setFont(new Font("Arial", 1, 12));
        this.JSPOtrosM.setViewportView(this.JTPOtrosM);
        this.JPIEstadoNacer.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO AL NACER", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGEstadoN.add(this.JRBVivo);
        this.JRBVivo.setFont(new Font("Arial", 1, 12));
        this.JRBVivo.setForeground(Color.blue);
        this.JRBVivo.setSelected(true);
        this.JRBVivo.setText("Vivo");
        this.JRBVivo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.11
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBVivoActionPerformed(evt);
            }
        });
        this.JBGEstadoN.add(this.JRBMuerto);
        this.JRBMuerto.setFont(new Font("Arial", 1, 12));
        this.JRBMuerto.setForeground(Color.blue);
        this.JRBMuerto.setText("Muerto");
        this.JRBMuerto.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.12
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBMuertoActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoNacerLayout = new GroupLayout(this.JPIEstadoNacer);
        this.JPIEstadoNacer.setLayout(JPIEstadoNacerLayout);
        JPIEstadoNacerLayout.setHorizontalGroup(JPIEstadoNacerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEstadoNacerLayout.createSequentialGroup().addComponent(this.JRBVivo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBMuerto).addContainerGap(22, 32767)));
        JPIEstadoNacerLayout.setVerticalGroup(JPIEstadoNacerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoNacerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBMuerto).addComponent(this.JRBVivo)));
        this.JCBTipoParto.setFont(new Font("Arial", 1, 12));
        this.JCBTipoParto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Parto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPGestacionN.setFont(new Font("Arial", 1, 12));
        this.JSPGestacionN.setModel(new SpinnerNumberModel(1, 1, 20, 1));
        this.JSPGestacionN.setBorder(BorderFactory.createTitledBorder((Border) null, "Gestación N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBgateo.setFont(new Font("Arial", 1, 12));
        this.JCBgateo.setBorder(BorderFactory.createTitledBorder((Border) null, "Gateo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCUnidadDeTiempo.setFont(new Font("Arial", 1, 12));
        this.JCUnidadDeTiempo.setModel(new DefaultComboBoxModel(new String[]{"Dias", "Meses", "Años"}));
        this.JCUnidadDeTiempo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiempo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosNacLayout = new GroupLayout(this.JPIDatosNac);
        this.JPIDatosNac.setLayout(JPIDatosNacLayout);
        JPIDatosNacLayout.setHorizontalGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosNacLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosNacLayout.createSequentialGroup().addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosNacLayout.createSequentialGroup().addComponent(this.JSPGestacionN, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPEdadM, -2, 94, -2).addGap(18, 18, 18).addComponent(this.JCUnidadDeTiempo, -2, 97, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoParto, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPEnferndadesDG)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosNacLayout.createSequentialGroup().addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPOtros).addComponent(this.JCBPrimerasPalabra, 0, 290, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBDenticion, 0, -1, 32767).addComponent(this.JCBSostuvoCabeza, 0, -1, 32767)).addGap(0, 0, 0).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBControlEsf, -2, 187, -2).addComponent(this.JCBSentoSolo, -2, 187, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBgateo, 0, 162, 32767).addComponent(this.JCBCamino, 0, -1, 32767))).addGroup(JPIDatosNacLayout.createSequentialGroup().addComponent(this.JPIEstadoNacer, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPICianosis, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIConvulciones, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JPIIctericia, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPTrastornosDg, -2, 251, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosNacLayout.createSequentialGroup().addComponent(this.JCBDuracionS, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPeso, -1, 57, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTalla, -2, 69, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFPEncefalico, -2, 68, -2).addGap(15, 15, 15).addComponent(this.JSPEstadoDPS, -2, 445, -2))).addGap(6, 6, 6)).addGroup(JPIDatosNacLayout.createSequentialGroup().addComponent(this.JSPOtrosM).addContainerGap()))));
        JPIDatosNacLayout.setVerticalGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosNacLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPGestacionN, -2, -1, -2).addComponent(this.JSPEdadM, -2, -1, -2).addComponent(this.JCBTipoParto, -2, -1, -2).addComponent(this.JCUnidadDeTiempo)).addComponent(this.JSPEnferndadesDG, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosNacLayout.createSequentialGroup().addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFPeso, -2, 49, -2).addComponent(this.JCBDuracionS, -2, -1, -2)).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFPEncefalico, -2, 52, -2).addComponent(this.JTFFTalla, -2, 52, -2)).addComponent(this.JSPEstadoDPS)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIConvulciones, -1, -1, 32767).addComponent(this.JPIIctericia, -1, -1, 32767).addComponent(this.JSPTrastornosDg).addComponent(this.JPICianosis, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSostuvoCabeza, -2, -1, -2).addComponent(this.JCBSentoSolo, -2, -1, -2).addComponent(this.JCBCamino, -2, -1, -2))).addGroup(JPIDatosNacLayout.createSequentialGroup().addComponent(this.JPIEstadoNacer, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPOtros, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosNacLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBControlEsf, -2, -1, -2).addComponent(this.JCBgateo).addComponent(this.JCBDenticion).addComponent(this.JCBPrimerasPalabra, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOtrosM, -2, 85, -2).addGap(35, 35, 35)));
        this.JTPAPediatricos.addTab("DEL NACIMIENTO", this.JPIDatosNac);
        this.JPIDalimentacion.setBorder(BorderFactory.createTitledBorder((Border) null, "ALIMENTACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBAMaterna.setFont(new Font("Arial", 1, 12));
        this.JCBAMaterna.setBorder(BorderFactory.createTitledBorder((Border) null, "Materna", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAMixta.setFont(new Font("Arial", 1, 12));
        this.JCBAMixta.setBorder(BorderFactory.createTitledBorder((Border) null, "Mixta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAComplementaria.setFont(new Font("Arial", 1, 12));
        this.JCBAComplementaria.setBorder(BorderFactory.createTitledBorder((Border) null, "Complementaria", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPAActual.setFont(new Font("Arial", 0, 12));
        this.JTPAActual.setBorder(BorderFactory.createTitledBorder((Border) null, "Actual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPAActual.setFont(new Font("Arial", 1, 12));
        this.JSPAActual.setViewportView(this.JTPAActual);
        this.JSPTrastornosAlimentarios.setFont(new Font("Arial", 0, 12));
        this.JTPTrastornosAlimentarios.setBorder(BorderFactory.createTitledBorder((Border) null, "Transtornos de la Alimentación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPTrastornosAlimentarios.setFont(new Font("Arial", 1, 12));
        this.JSPTrastornosAlimentarios.setViewportView(this.JTPTrastornosAlimentarios);
        GroupLayout JPIDalimentacionLayout = new GroupLayout(this.JPIDalimentacion);
        this.JPIDalimentacion.setLayout(JPIDalimentacionLayout);
        JPIDalimentacionLayout.setHorizontalGroup(JPIDalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDalimentacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDalimentacionLayout.createSequentialGroup().addComponent(this.JCBAMaterna, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBAMixta, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBAComplementaria, -2, 150, -2).addGap(10, 10, 10).addComponent(this.JSPAActual)).addComponent(this.JSPTrastornosAlimentarios, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        JPIDalimentacionLayout.setVerticalGroup(JPIDalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDalimentacionLayout.createSequentialGroup().addGroup(JPIDalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPAActual, 0, -1, 32767).addComponent(this.JCBAComplementaria).addComponent(this.JCBAMaterna).addComponent(this.JCBAMixta)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTrastornosAlimentarios, -2, -1, -2)));
        this.JPIOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "OTROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBOHistoriaEscolar.setFont(new Font("Arial", 1, 12));
        this.JCBOHistoriaEscolar.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel Escolar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPOOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPOOtros.setFont(new Font("Arial", 0, 12));
        this.JTPOOtros.setFont(new Font("Arial", 1, 12));
        this.JSPOOtros.setViewportView(this.JTPOOtros);
        this.JPIDuelo.setBorder(BorderFactory.createTitledBorder((Border) null, "DUELO", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGDuelo.add(this.JRBDueloSi);
        this.JRBDueloSi.setFont(new Font("Arial", 1, 12));
        this.JRBDueloSi.setForeground(Color.blue);
        this.JRBDueloSi.setText("Si");
        this.JRBDueloSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.13
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBDueloSiActionPerformed(evt);
            }
        });
        this.JBGDuelo.add(this.JRBDueloNo);
        this.JRBDueloNo.setFont(new Font("Arial", 1, 12));
        this.JRBDueloNo.setForeground(Color.blue);
        this.JRBDueloNo.setSelected(true);
        this.JRBDueloNo.setText("No");
        this.JRBDueloNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.14
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBDueloNoActionPerformed(evt);
            }
        });
        GroupLayout JPIDueloLayout = new GroupLayout(this.JPIDuelo);
        this.JPIDuelo.setLayout(JPIDueloLayout);
        JPIDueloLayout.setHorizontalGroup(JPIDueloLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDueloLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBDueloSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDueloNo)));
        JPIDueloLayout.setVerticalGroup(JPIDueloLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDueloLayout.createSequentialGroup().addGroup(JPIDueloLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDueloSi).addComponent(this.JRBDueloNo)).addContainerGap(-1, 32767)));
        this.JPISuicidio.setBorder(BorderFactory.createTitledBorder((Border) null, "SUCIDIO", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGSuicidio.add(this.JRBSuicidioSi);
        this.JRBSuicidioSi.setFont(new Font("Arial", 1, 12));
        this.JRBSuicidioSi.setForeground(Color.blue);
        this.JRBSuicidioSi.setText("Si");
        this.JRBSuicidioSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.15
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBSuicidioSiActionPerformed(evt);
            }
        });
        this.JBGSuicidio.add(this.JRBSuicidioNo);
        this.JRBSuicidioNo.setFont(new Font("Arial", 1, 12));
        this.JRBSuicidioNo.setForeground(Color.blue);
        this.JRBSuicidioNo.setSelected(true);
        this.JRBSuicidioNo.setText("No");
        this.JRBSuicidioNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.16
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBSuicidioNoActionPerformed(evt);
            }
        });
        GroupLayout JPISuicidioLayout = new GroupLayout(this.JPISuicidio);
        this.JPISuicidio.setLayout(JPISuicidioLayout);
        JPISuicidioLayout.setHorizontalGroup(JPISuicidioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISuicidioLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSuicidioSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSuicidioNo)));
        JPISuicidioLayout.setVerticalGroup(JPISuicidioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISuicidioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSuicidioSi).addComponent(this.JRBSuicidioNo)));
        this.JPISeparacionP.setBorder(BorderFactory.createTitledBorder((Border) null, "SEPARACIÓN", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGSeparacion.add(this.JRBSeparacionPSi);
        this.JRBSeparacionPSi.setFont(new Font("Arial", 1, 12));
        this.JRBSeparacionPSi.setForeground(Color.blue);
        this.JRBSeparacionPSi.setText("Si");
        this.JRBSeparacionPSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.17
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBSeparacionPSiActionPerformed(evt);
            }
        });
        this.JBGSeparacion.add(this.JRBSeparacionPNo);
        this.JRBSeparacionPNo.setFont(new Font("Arial", 1, 12));
        this.JRBSeparacionPNo.setForeground(Color.blue);
        this.JRBSeparacionPNo.setSelected(true);
        this.JRBSeparacionPNo.setText("No");
        this.JRBSeparacionPNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.18
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBSeparacionPNoActionPerformed(evt);
            }
        });
        GroupLayout JPISeparacionPLayout = new GroupLayout(this.JPISeparacionP);
        this.JPISeparacionP.setLayout(JPISeparacionPLayout);
        JPISeparacionPLayout.setHorizontalGroup(JPISeparacionPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeparacionPLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSeparacionPSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSeparacionPNo)));
        JPISeparacionPLayout.setVerticalGroup(JPISeparacionPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeparacionPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSeparacionPSi).addComponent(this.JRBSeparacionPNo)));
        this.JPIAlcoholFarm.setBorder(BorderFactory.createTitledBorder((Border) null, "ALCOHOL", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGAlcoholFarma.add(this.JRBAlcoholFarmSi);
        this.JRBAlcoholFarmSi.setFont(new Font("Arial", 1, 12));
        this.JRBAlcoholFarmSi.setForeground(Color.blue);
        this.JRBAlcoholFarmSi.setText("Si");
        this.JRBAlcoholFarmSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.19
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBAlcoholFarmSiActionPerformed(evt);
            }
        });
        this.JBGAlcoholFarma.add(this.JRBAlcoholFarmNo);
        this.JRBAlcoholFarmNo.setFont(new Font("Arial", 1, 12));
        this.JRBAlcoholFarmNo.setForeground(Color.blue);
        this.JRBAlcoholFarmNo.setSelected(true);
        this.JRBAlcoholFarmNo.setText("No");
        this.JRBAlcoholFarmNo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.20
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JRBAlcoholFarmNoActionPerformed(evt);
            }
        });
        GroupLayout JPIAlcoholFarmLayout = new GroupLayout(this.JPIAlcoholFarm);
        this.JPIAlcoholFarm.setLayout(JPIAlcoholFarmLayout);
        JPIAlcoholFarmLayout.setHorizontalGroup(JPIAlcoholFarmLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIAlcoholFarmLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JRBAlcoholFarmSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767).addComponent(this.JRBAlcoholFarmNo)));
        JPIAlcoholFarmLayout.setVerticalGroup(JPIAlcoholFarmLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAlcoholFarmLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAlcoholFarmNo).addComponent(this.JRBAlcoholFarmSi)));
        GroupLayout JPIOtrosLayout = new GroupLayout(this.JPIOtros);
        this.JPIOtros.setLayout(JPIOtrosLayout);
        JPIOtrosLayout.setHorizontalGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosLayout.createSequentialGroup().addContainerGap().addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPOOtros).addGroup(JPIOtrosLayout.createSequentialGroup().addComponent(this.JCBOHistoriaEscolar, -2, 257, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDuelo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPISuicidio, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JPISeparacionP, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JPIAlcoholFarm, -2, -1, -2))).addContainerGap()));
        JPIOtrosLayout.setVerticalGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosLayout.createSequentialGroup().addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOtrosLayout.createSequentialGroup().addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIAlcoholFarm, GroupLayout.Alignment.LEADING, -2, -1, -2).addComponent(this.JCBOHistoriaEscolar, GroupLayout.Alignment.LEADING, -2, -1, -2)).addGap(6, 6, 6)).addGroup(JPIOtrosLayout.createSequentialGroup().addGroup(JPIOtrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPISeparacionP, -1, -1, 32767).addComponent(this.JPISuicidio, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDuelo, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.JSPOOtros, -1, 133, 32767).addContainerGap()));
        GroupLayout JPIDatosOtrosLayout = new GroupLayout(this.JPIDatosOtros);
        this.JPIDatosOtros.setLayout(JPIDatosOtrosLayout);
        JPIDatosOtrosLayout.setHorizontalGroup(JPIDatosOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOtrosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDalimentacion, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPIOtros, -1, -1, 32767)).addContainerGap()));
        JPIDatosOtrosLayout.setVerticalGroup(JPIDatosOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOtrosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDalimentacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIOtros, -1, -1, 32767).addGap(16, 16, 16)));
        this.JTPAPediatricos.addTab("OTROS", this.JPIDatosOtros);
        this.JBTAdicionarPat.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarPat.setForeground(Color.red);
        this.JBTAdicionarPat.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarPat.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedentesPediatricos.21
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedentesPediatricos.this.JBTAdicionarPatActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPAPediatricos, -1, 848, 32767).addComponent(this.JBTAdicionarPat, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPAPediatricos, -2, 421, -2).addGap(18, 18, 18).addComponent(this.JBTAdicionarPat).addContainerGap(39, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVivoActionPerformed(ActionEvent evt) {
        this.xestadon = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMuertoActionPerformed(ActionEvent evt) {
        this.xestadon = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCianosisNoActionPerformed(ActionEvent evt) {
        this.xcianosis = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCianosisSiActionPerformed(ActionEvent evt) {
        this.xcianosis = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIctericiaSiActionPerformed(ActionEvent evt) {
        this.xictericia = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIctericiaNoActionPerformed(ActionEvent evt) {
        this.xictericia = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConvulcionesSiActionPerformed(ActionEvent evt) {
        this.xconvulciones = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConvulcionesNoActionPerformed(ActionEvent evt) {
        this.xconvulciones = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDueloSiActionPerformed(ActionEvent evt) {
        this.xduelo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDueloNoActionPerformed(ActionEvent evt) {
        this.xduelo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSuicidioSiActionPerformed(ActionEvent evt) {
        this.xsuicidio = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSuicidioNoActionPerformed(ActionEvent evt) {
        this.xsuicidio = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSeparacionPSiActionPerformed(ActionEvent evt) {
        this.xseparacionp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSeparacionPNoActionPerformed(ActionEvent evt) {
        this.xseparacionp = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlcoholFarmSiActionPerformed(ActionEvent evt) {
        this.xalcoholf = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlcoholFarmNoActionPerformed(ActionEvent evt) {
        this.xalcoholf = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarPatActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        if (this.xidusuario != 0) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSentoSoloActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSostuvoCabezaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDenticionActionPerformed(ActionEvent evt) {
    }

    private void mBuscarDatosBd() {
        try {
            String sql = "SELECT h_antecedentepediatria.Id_Usuario, h_antecedentepediatria.SemanaGesN, h_antecedentepediatria.Edad_Madre, h_antecedentepediatria.DuracionEmba, h_antecedentepediatria.EnfermedadesDG, h_antecedentepediatria.Id_TipoParto, g_tipoparto.Nbre, h_antecedentepediatria.EstadoRn , h_antecedentepediatria.Peso, h_antecedentepediatria.Talla, h_antecedentepediatria.PEncefalico, h_antecedentepediatria.EstadoDPSemana, h_antecedentepediatria.EsCianosis, h_antecedentepediatria.EsIctericia, h_antecedentepediatria.EsConvulsiones, h_antecedentepediatria.TrastornosDigestivos , h_antecedentepediatria.OtrosDrn, h_antecedentepediatria.SCabeza, h_antecedentepediatria.SSento, h_antecedentepediatria.SCamina, h_antecedentepediatria.SPalabra, h_antecedentepediatria.SDenticion, h_antecedentepediatria.SCEnti, h_antecedentepediatria.OtrosDrn1, h_antecedentepediatria.AMaterna , h_antecedentepediatria.AMixta, h_antecedentepediatria.AComplementario, h_antecedentepediatria.AlimentacionActual, h_antecedentepediatria.TrastornoAlimentacion, h_antecedentepediatria.Id_NivelEstudio, g_nivelestudio.Nbre, h_antecedentepediatria.EsDuelo, h_antecedentepediatria.EsSuicidio, h_antecedentepediatria.EsSeparacionP , h_antecedentepediatria.EsAlcoholFarm, h_antecedentepediatria.OtrosAsicos, h_antecedentepediatria.SGateo ,ifnull(`Edad_Madre_Tiempo`,'Meses') as Edad_Madre_Tiempo FROM h_antecedentepediatria INNER JOIN g_tipoparto ON (h_antecedentepediatria.Id_TipoParto = g_tipoparto.Id)INNER JOIN g_nivelestudio ON (h_antecedentepediatria.Id_NivelEstudio = g_nivelestudio.Id) where h_antecedentepediatria.Id_Usuario='" + this.xidusuario + "'";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JSPGestacionN.setValue(Integer.valueOf(xrs.getInt(2)));
                this.JSPEdadM.setValue(Integer.valueOf(xrs.getInt(3)));
                this.JCBDuracionS.setSelectedItem(xrs.getString(4));
                this.JTPEnferndadesDG.setText(xrs.getString(5));
                this.JCBTipoParto.setSelectedItem(xrs.getString(7));
                if (xrs.getInt(8) == 1) {
                    this.JRBVivo.setSelected(true);
                    this.JRBMuerto.setSelected(false);
                    this.xestadon = 1;
                } else {
                    this.JRBVivo.setSelected(false);
                    this.JRBMuerto.setSelected(true);
                    this.xestadon = 0;
                }
                this.JTFFPeso.setValue(Double.valueOf(xrs.getDouble(9)));
                this.JTFFTalla.setValue(Double.valueOf(xrs.getDouble(10)));
                this.JTFFPEncefalico.setValue(Double.valueOf(xrs.getDouble(11)));
                this.JTPEstadoDPS.setText(xrs.getString(12));
                if (xrs.getInt(13) == 1) {
                    this.JRBCianosisSi.setSelected(true);
                    this.JRBCianosisNo.setSelected(false);
                    this.xcianosis = 1;
                } else {
                    this.JRBCianosisSi.setSelected(false);
                    this.JRBCianosisNo.setSelected(true);
                    this.xcianosis = 0;
                }
                if (xrs.getInt(14) == 1) {
                    this.JRBIctericiaSi.setSelected(true);
                    this.JRBIctericiaNo.setSelected(false);
                    this.xictericia = 1;
                } else {
                    this.JRBIctericiaSi.setSelected(false);
                    this.JRBIctericiaNo.setSelected(true);
                    this.xictericia = 0;
                }
                if (xrs.getInt(15) == 1) {
                    this.JRBConvulcionesSi.setSelected(true);
                    this.JRBConvulcionesNo.setSelected(false);
                    this.xconvulciones = 1;
                } else {
                    this.JRBConvulcionesSi.setSelected(false);
                    this.JRBConvulcionesNo.setSelected(true);
                    this.xconvulciones = 0;
                }
                this.JTPTrastornosDg.setText(xrs.getString(16));
                this.JTPOtrosDn.setText("" + xrs.getString(17));
                this.JCBSostuvoCabeza.setSelectedItem(xrs.getString(18));
                this.JCBSentoSolo.setSelectedItem(xrs.getString(19));
                this.JCBCamino.setSelectedItem(xrs.getString(20));
                this.JCBPrimerasPalabra.setSelectedItem(xrs.getString(21));
                this.JCBDenticion.setSelectedItem(xrs.getString(22));
                this.JCBControlEsf.setSelectedItem(xrs.getString(23));
                this.JTPOtrosM.setText(xrs.getString(24));
                this.JCBAMaterna.setSelectedItem(xrs.getString(25));
                this.JCBAMixta.setSelectedItem(xrs.getString(26));
                this.JCBAComplementaria.setSelectedItem(xrs.getString(27));
                this.JTPAActual.setText(xrs.getString(28));
                this.JTPTrastornosAlimentarios.setText(xrs.getString(29));
                this.JCBOHistoriaEscolar.setSelectedItem(xrs.getString(31));
                if (xrs.getInt(32) == 1) {
                    this.JRBDueloSi.setSelected(true);
                    this.JRBDueloNo.setSelected(false);
                    this.xduelo = 1;
                } else {
                    this.JRBDueloSi.setSelected(false);
                    this.JRBDueloNo.setSelected(true);
                    this.xduelo = 0;
                }
                if (xrs.getInt(33) == 1) {
                    this.JRBSuicidioSi.setSelected(true);
                    this.JRBSuicidioNo.setSelected(false);
                    this.xsuicidio = 1;
                } else {
                    this.JRBSuicidioSi.setSelected(false);
                    this.JRBSuicidioNo.setSelected(true);
                    this.xsuicidio = 0;
                }
                if (xrs.getInt(34) == 1) {
                    this.JRBSeparacionPSi.setSelected(true);
                    this.JRBSeparacionPNo.setSelected(false);
                    this.xseparacionp = 1;
                } else {
                    this.JRBSeparacionPSi.setSelected(false);
                    this.JRBSeparacionPNo.setSelected(true);
                    this.xseparacionp = 0;
                }
                if (xrs.getInt(35) == 1) {
                    this.JRBAlcoholFarmSi.setSelected(true);
                    this.JRBAlcoholFarmNo.setSelected(false);
                    this.xalcoholf = 1;
                } else {
                    this.JRBAlcoholFarmSi.setSelected(false);
                    this.JRBAlcoholFarmNo.setSelected(true);
                    this.xalcoholf = 0;
                }
                this.JTPOOtros.setText(xrs.getString(36));
                this.xencontro = 1;
                this.JCUnidadDeTiempo.setSelectedItem(xrs.getString(38).trim());
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesHabitos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabarBd() {
        if (this.xencontro == 0) {
            String sql = "INSERT INTO h_antecedentepediatria (Id_Usuario, SemanaGesN, Edad_Madre, DuracionEmba, Id_TipoParto, EnfermedadesDG, EstadoRn, Peso, Talla, PEncefalico, EstadoDPSemana, EsCianosis, EsIctericia, EsConvulsiones, TrastornosDigestivos, OtrosDrn, SGateo, SCabeza, SSento, SCamina, SPalabra, SDenticion, SCEnti , OtrosDrn1, AMaterna, AMixta, AComplementario, AlimentacionActual, TrastornoAlimentacion, Id_NivelEstudio, EsDuelo, EsSuicidio, EsSeparacionP, EsAlcoholFarm, OtrosAsicos, Fecha, UsuarioS,`Edad_Madre_Tiempo`)  VALUES ( '" + this.xidusuario + "','" + this.JSPGestacionN.getValue() + "','" + this.JSPEdadM.getValue() + "','" + this.JCBDuracionS.getSelectedItem().toString() + "','" + this.xrparto[this.JCBTipoParto.getSelectedIndex()] + "','" + this.JTPEnferndadesDG.getText() + "','" + this.xestadon + "','" + this.JTFFPeso.getValue() + "','" + this.JTFFTalla.getValue() + "','" + this.JTFFPEncefalico.getValue() + "','" + this.JTPEstadoDPS.getText() + "','" + this.xcianosis + "','" + this.xictericia + "','" + this.xconvulciones + "','" + this.JTPTrastornosDg.getText() + "','" + this.JTPOtrosDn.getText() + "','" + this.JCBgateo.getSelectedItem().toString() + "','" + this.JCBSostuvoCabeza.getSelectedItem().toString() + "','" + this.JCBSentoSolo.getSelectedItem().toString() + "','" + this.JCBCamino.getSelectedItem().toString() + "','" + this.JCBPrimerasPalabra.getSelectedItem().toString() + "','" + this.JCBDenticion.getSelectedItem().toString() + "','" + this.JCBControlEsf.getSelectedItem().toString() + "','" + this.JTPOtrosM.getText() + "','" + this.JCBAMaterna.getSelectedItem().toString() + "','" + this.JCBAMixta.getSelectedItem().toString() + "','" + this.JCBAComplementaria.getSelectedItem().toString() + "','" + this.JTPAActual.getText() + "','" + this.JTPTrastornosAlimentarios.getText() + "','" + this.xnescolar[this.JCBOHistoriaEscolar.getSelectedIndex()] + "','" + this.xduelo + "','" + this.xsuicidio + "','" + this.xseparacionp + "','" + this.xalcoholf + "','" + this.JTPOOtros.getText() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.JCUnidadDeTiempo.getSelectedItem().toString() + "')";
            this.xencontro = 1;
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
        } else {
            String sql2 = "UPDATE h_antecedentepediatria SET SemanaGesN ='" + this.JSPGestacionN.getValue() + "', Edad_Madre ='" + this.JSPEdadM.getValue() + "', DuracionEmba ='" + this.JCBDuracionS.getSelectedItem().toString() + "', Id_TipoParto ='" + this.xrparto[this.JCBTipoParto.getSelectedIndex()] + "', EnfermedadesDG ='" + this.JTPEnferndadesDG.getText() + "', EstadoRn ='" + this.xestadon + "', Peso ='" + this.JTFFPeso.getValue() + "', Talla ='" + this.JTFFTalla.getValue() + "', PEncefalico ='" + this.JTFFPEncefalico.getValue() + "', EstadoDPSemana ='" + this.JTPEstadoDPS.getText() + "', EsCianosis ='" + this.xcianosis + "', EsIctericia ='" + this.xictericia + "', EsConvulsiones ='" + this.xconvulciones + "', TrastornosDigestivos ='" + this.JTPTrastornosDg.getText() + "', OtrosDrn ='" + this.JTPOtrosDn.getText() + "', SGateo ='" + this.JCBgateo.getSelectedItem().toString() + "', SCabeza ='" + this.JCBSostuvoCabeza.getSelectedItem().toString() + "', SSento ='" + this.JCBSentoSolo.getSelectedItem().toString() + "', SCamina ='" + this.JCBCamino.getSelectedItem().toString() + "', SPalabra ='" + this.JCBPrimerasPalabra.getSelectedItem().toString() + "', SDenticion ='" + this.JCBDenticion.getSelectedItem().toString() + "', SCEnti ='" + this.JCBControlEsf.getSelectedItem().toString() + "', OtrosDrn1 ='" + this.JTPOtrosM.getText() + "', AMaterna ='" + this.JCBAMaterna.getSelectedItem().toString() + "', AMixta ='" + this.JCBAMixta.getSelectedItem().toString() + "', AComplementario ='" + this.JCBAComplementaria.getSelectedItem().toString() + "', AlimentacionActual ='" + this.JTPAActual.getText() + "', TrastornoAlimentacion ='" + this.JTPTrastornosAlimentarios.getText() + "', Id_NivelEstudio ='" + this.xnescolar[this.JCBOHistoriaEscolar.getSelectedIndex()] + "', EsDuelo ='" + this.xduelo + "', EsSuicidio ='" + this.xsuicidio + "', EsSeparacionP ='" + this.xseparacionp + "', EsAlcoholFarm ='" + this.xalcoholf + "', OtrosAsicos ='" + this.JTPOOtros.getText() + "', Fecha ='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "',`Edad_Madre_Tiempo`= '" + this.JCUnidadDeTiempo.getSelectedItem().toString() + "' WHERE(Id_Usuario ='" + this.xidusuario + "')";
            this.xconsultasbd.ejecutarSQL(sql2);
            this.xconsultasbd.cerrarConexionBd();
        }
        this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    public void mNuevo() {
        if (this.xmod == 0) {
            this.xidusuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue();
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        } else if (this.xmod == 1) {
            if (!this.xjifcho.xjppersona.getIdPersona().equals("0")) {
                this.xidusuario = Long.valueOf(this.xjifcho.xjppersona.getIdPersona()).longValue();
            }
            this.xidatencion = "0";
        }
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =1 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBDuracionS);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBSostuvoCabeza);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBSentoSolo);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBCamino);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBPrimerasPalabra);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBDenticion);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBControlEsf);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBAMaterna);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBAMixta);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBAComplementaria);
        this.xidgen = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tiposemanames WHERE (EsSemana =0 AND Estado =0) ORDER BY Orden ASC", this.xidgen, this.JCBgateo);
        this.xnescolar = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_nivelestudio WHERE (Estado =0) ORDER BY Nbre ASC", this.xnescolar, this.JCBOHistoriaEscolar);
        this.xrparto = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_tipoparto WHERE (Estado =0) ORDER BY Nbre ASC", this.xrparto, this.JCBTipoParto);
        this.xconsultasbd.cerrarConexionBd();
        this.JCBAComplementaria.setSelectedIndex(0);
        this.JCBAMaterna.setSelectedIndex(0);
        this.JCBAMixta.setSelectedIndex(0);
        this.JCBCamino.setSelectedIndex(0);
        this.JCBControlEsf.setSelectedIndex(0);
        this.JCBDenticion.setSelectedIndex(0);
        this.JCBDuracionS.setSelectedIndex(0);
        this.JCBPrimerasPalabra.setSelectedIndex(0);
        this.JCBSentoSolo.setSelectedIndex(0);
        this.JCBSostuvoCabeza.setSelectedIndex(0);
        this.JCBgateo.setSelectedIndex(0);
        this.JCBTipoParto.setSelectedIndex(2);
        this.JCBOHistoriaEscolar.setSelectedIndex(3);
        mBuscarDatosBd();
    }
}
