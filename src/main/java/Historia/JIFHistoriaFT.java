package Historia;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFHistoriaFT.class */
public class JIFHistoriaFT extends JInternalFrame {
    public Persona xjppersona;
    private String[] xidespecialidad;
    public String[][] xidprofesional;
    private boolean xllenado;
    private JButton JBTCierre;
    private JButton JBTCierreTF;
    private JButton JBTCierreTF1;
    private JButton JBTRetro;
    private JButton JBTRetro1;
    private JButton JBTSeguimiento;
    private JButton JBTSeguimientot;
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
    private JPanel JPDatosAtencion;
    private JPanel JPEjercicios;
    private JPanel JPElectroterapia;
    private JPanel JPIDUsuario;
    private JPanel JPMasaje;
    private JPanel JPMecanoterapia;
    private JPanel JPMediosFisicos;
    private JPanel JPNeurologia;
    private JPanel JPPlanCasero;
    private JPanel JPTerapiaF;
    private JPanel JPTerapiaR;
    private JPanel JPterapiaR;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPEstiramiento;
    private JScrollPane JSPOtros;
    private JScrollPane JSPOtrosElect;
    private JScrollPane JSPOtrosMecanoter;
    private JScrollPane JSPOtrosMf;
    private JScrollPane JSPOtrosTR;
    private JScrollPane JSPPlanCasero;
    private JScrollPane JSPReeducacionMuscular;
    private JScrollPane JSPRehabilitacionMarcha;
    private JTabbedPane JTPDatosHc;
    private JTextPane JTPEstiramiento;
    private JTextPane JTPOtros;
    private JTextPane JTPOtrosElect;
    private JTextPane JTPOtrosMecan;
    private JTextPane JTPOtrosMf;
    private JTextPane JTPOtrosTR;
    private JTextPane JTPPlanCasero;
    private JTextPane JTPReeducacionMuscular;
    private JTextPane JTPRehabilitacionMarcha;
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

    public JIFHistoriaFT() {
        this.xllenado = false;
        initComponents();
        mCargasPanelUsuario();
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.xidespecialidad = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xidprofesional = this.xconsulta.llenarComboyLista("SELECT profesional1.Id_Persona, profesional1.NProfesional, profesional1.Email FROM g_profesional INNER JOIN profesional1  ON (g_profesional.Id_Persona = profesional1.Id_Persona)  where g_profesional.Estado =0  ORDER BY profesional1.NProfesional ASC ", this.xidprofesional, this.JCBProfesional, 3);
        this.JCBProfesional.setSelectedIndex(-1);
        this.xllenado = true;
        this.xconsulta.cerrarConexionBd();
        mTraerNAtencion();
        this.xjppersona.txtHistoria.setText(Principal.clasescita.getxNHistoria());
        this.xjppersona.buscar(2);
    }

    private void initComponents() {
        this.JPIDUsuario = new JPanel();
        this.JBTCierreTF1 = new JButton();
        this.JPDatosAtencion = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JCBProfesional = new JComboBox();
        this.JCBEspecialidad = new JComboBox();
        this.JTPDatosHc = new JTabbedPane();
        this.JPTerapiaF = new JPanel();
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
        this.JCBBalonterapia = new JCheckBox();
        this.JCBPronosupinador = new JCheckBox();
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
        this.JSPEstiramiento = new JScrollPane();
        this.JTPEstiramiento = new JTextPane();
        this.JSPReeducacionMuscular = new JScrollPane();
        this.JTPReeducacionMuscular = new JTextPane();
        this.JSPRehabilitacionMarcha = new JScrollPane();
        this.JTPRehabilitacionMarcha = new JTextPane();
        this.JPEjercicios = new JPanel();
        this.JCBEAAsistidos = new JCheckBox();
        this.JCBEAResistidos = new JCheckBox();
        this.JCBEIsometricos = new JCheckBox();
        this.JCBCEALibres = new JCheckBox();
        this.JPNeurologia = new JPanel();
        this.JCBNeurodesarrollo = new JCheckBox();
        this.JCBTfnp = new JCheckBox();
        this.JCBETemprana = new JCheckBox();
        this.JSPOtros = new JScrollPane();
        this.JTPOtros = new JTextPane();
        this.JPPlanCasero = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JSPPlanCasero = new JScrollPane();
        this.JTPPlanCasero = new JTextPane();
        this.JBTSeguimientot = new JButton();
        this.JBTCierreTF = new JButton();
        this.JBTRetro = new JButton();
        this.JPTerapiaR = new JPanel();
        this.JPterapiaR = new JPanel();
        this.JCBTerapiaResp = new JCheckBox();
        this.JCBMicronebulizacion = new JCheckBox();
        this.JCBOxigenoterapia = new JCheckBox();
        this.JSPOtrosTR = new JScrollPane();
        this.JTPOtrosTR = new JTextPane();
        this.JBTSeguimiento = new JButton();
        this.JBTCierre = new JButton();
        this.JBTRetro1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("HISTORIA CLÍNICA FISIOTERAPIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifhistoriaft");
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFHistoriaFT.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFHistoriaFT.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JBTCierreTF1.setFont(new Font("Arial", 1, 12));
        this.JBTCierreTF1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CHistoria.png")));
        this.JBTCierreTF1.setText("Consultar HC");
        this.JBTCierreTF1.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.2
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JBTCierreTF1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDUsuarioLayout = new GroupLayout(this.JPIDUsuario);
        this.JPIDUsuario.setLayout(JPIDUsuarioLayout);
        JPIDUsuarioLayout.setHorizontalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDUsuarioLayout.createSequentialGroup().addContainerGap(935, 32767).addComponent(this.JBTCierreTF1)));
        JPIDUsuarioLayout.setVerticalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTCierreTF1, -1, 219, 32767));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JIFHistoriaFT.3
            public void itemStateChanged(ItemEvent evt) {
                JIFHistoriaFT.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        GroupLayout JPDatosAtencionLayout = new GroupLayout(this.JPDatosAtencion);
        this.JPDatosAtencion.setLayout(JPDatosAtencionLayout);
        JPDatosAtencionLayout.setHorizontalGroup(JPDatosAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFecha, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEspecialidad, -2, 361, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProfesional, 0, 550, 32767).addContainerGap()));
        JPDatosAtencionLayout.setVerticalGroup(JPDatosAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAtencionLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosAtencionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosAtencionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -1, 52, 32767).addComponent(this.JCBProfesional, -1, 52, 32767)).addComponent(this.JDCFecha, -1, 52, 32767)).addContainerGap()));
        this.JTPDatosHc.setForeground(new Color(255, 0, 0));
        this.JTPDatosHc.setFont(new Font("Arial", 1, 14));
        this.JPMediosFisicos.setBorder(BorderFactory.createTitledBorder((Border) null, "MEDIOS FÍSICOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBParafina.setFont(new Font("Arial", 1, 12));
        this.JCBParafina.setForeground(Color.blue);
        this.JCBParafina.setText("Parafina");
        this.JCBParafina.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.4
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBParafinaActionPerformed(evt);
            }
        });
        this.JCBRayosInfr.setFont(new Font("Arial", 1, 12));
        this.JCBRayosInfr.setForeground(Color.blue);
        this.JCBRayosInfr.setText("Rayos Infra Rojos");
        this.JCBRayosInfr.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.5
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBRayosInfrActionPerformed(evt);
            }
        });
        this.JCBCalorLocal.setFont(new Font("Arial", 1, 12));
        this.JCBCalorLocal.setForeground(Color.blue);
        this.JCBCalorLocal.setText("Calor Local");
        this.JCBCalorLocal.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.6
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBCalorLocalActionPerformed(evt);
            }
        });
        this.JCBCRioterapia.setFont(new Font("Arial", 1, 12));
        this.JCBCRioterapia.setForeground(Color.blue);
        this.JCBCRioterapia.setText("Crioterapia");
        this.JCBCRioterapia.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.7
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBCRioterapiaActionPerformed(evt);
            }
        });
        this.JCBUltrasonido.setFont(new Font("Arial", 1, 12));
        this.JCBUltrasonido.setForeground(Color.blue);
        this.JCBUltrasonido.setText("Ultrasonido");
        this.JCBUltrasonido.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.8
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBUltrasonidoActionPerformed(evt);
            }
        });
        this.JSPOtrosMf.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Tahoma", 1, 11)));
        this.JTPOtrosMf.setFont(new Font("Arial", 1, 12));
        this.JSPOtrosMf.setViewportView(this.JTPOtrosMf);
        GroupLayout JPMediosFisicosLayout = new GroupLayout(this.JPMediosFisicos);
        this.JPMediosFisicos.setLayout(JPMediosFisicosLayout);
        JPMediosFisicosLayout.setHorizontalGroup(JPMediosFisicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPOtrosMf).addGroup(JPMediosFisicosLayout.createSequentialGroup().addComponent(this.JCBCalorLocal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCRioterapia).addGap(4, 4, 4).addComponent(this.JCBParafina).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBRayosInfr).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBUltrasonido)));
        JPMediosFisicosLayout.setVerticalGroup(JPMediosFisicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMediosFisicosLayout.createSequentialGroup().addGroup(JPMediosFisicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCalorLocal).addComponent(this.JCBCRioterapia).addComponent(this.JCBParafina).addComponent(this.JCBRayosInfr).addComponent(this.JCBUltrasonido)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPOtrosMf, -2, 72, -2).addContainerGap(-1, 32767)));
        this.JPMecanoterapia.setBorder(BorderFactory.createTitledBorder((Border) null, "MECANOTERAPIA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPMecanoterapia.setForeground(new Color(0, 0, 255));
        this.JCBBEstatica.setFont(new Font("Arial", 1, 12));
        this.JCBBEstatica.setForeground(new Color(0, 0, 255));
        this.JCBBEstatica.setText("Biciclieta Estática");
        this.JCBBEstatica.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.9
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBBEstaticaActionPerformed(evt);
            }
        });
        this.JCBRuedaHombro.setFont(new Font("Arial", 1, 12));
        this.JCBRuedaHombro.setForeground(new Color(0, 0, 255));
        this.JCBRuedaHombro.setText("Rueda para Hombro");
        this.JCBRuedaHombro.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.10
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBRuedaHombroActionPerformed(evt);
            }
        });
        this.JCBTCervical.setFont(new Font("Arial", 1, 12));
        this.JCBTCervical.setForeground(new Color(0, 0, 255));
        this.JCBTCervical.setText("Tracción Cervical");
        this.JCBTCervical.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.11
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBTCervicalActionPerformed(evt);
            }
        });
        this.JCBBarraParalela.setFont(new Font("Arial", 1, 12));
        this.JCBBarraParalela.setForeground(new Color(0, 0, 255));
        this.JCBBarraParalela.setText("Barra Paralela");
        this.JCBBarraParalela.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.12
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBBarraParalelaActionPerformed(evt);
            }
        });
        this.JCBEscDedos.setFont(new Font("Arial", 1, 12));
        this.JCBEscDedos.setForeground(new Color(0, 0, 255));
        this.JCBEscDedos.setText("Escalera para Dedos");
        this.JCBEscDedos.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.13
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBEscDedosActionPerformed(evt);
            }
        });
        this.JSPOtrosMecanoter.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Tahoma", 1, 11)));
        this.JTPOtrosMecan.setFont(new Font("Arial", 1, 12));
        this.JSPOtrosMecanoter.setViewportView(this.JTPOtrosMecan);
        this.JCBPolea.setFont(new Font("Arial", 1, 12));
        this.JCBPolea.setForeground(new Color(0, 0, 255));
        this.JCBPolea.setText("Polea");
        this.JCBPolea.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.14
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBPoleaActionPerformed(evt);
            }
        });
        this.JCBBalonterapia.setFont(new Font("Arial", 1, 12));
        this.JCBBalonterapia.setForeground(new Color(0, 0, 255));
        this.JCBBalonterapia.setText("Balonterapia");
        this.JCBBalonterapia.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.15
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBBalonterapiaActionPerformed(evt);
            }
        });
        this.JCBPronosupinador.setFont(new Font("Arial", 1, 12));
        this.JCBPronosupinador.setForeground(new Color(0, 0, 255));
        this.JCBPronosupinador.setText("Pronosupinador");
        this.JCBPronosupinador.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.16
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBPronosupinadorActionPerformed(evt);
            }
        });
        GroupLayout JPMecanoterapiaLayout = new GroupLayout(this.JPMecanoterapia);
        this.JPMecanoterapia.setLayout(JPMecanoterapiaLayout);
        JPMecanoterapiaLayout.setHorizontalGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMecanoterapiaLayout.createSequentialGroup().addContainerGap().addGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMecanoterapiaLayout.createSequentialGroup().addComponent(this.JCBEscDedos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPolea).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPronosupinador).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBBalonterapia)).addGroup(JPMecanoterapiaLayout.createSequentialGroup().addComponent(this.JCBTCervical).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBBarraParalela).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBBEstatica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRuedaHombro)).addComponent(this.JSPOtrosMecanoter, -2, 448, -2)).addContainerGap(41, 32767)));
        JPMecanoterapiaLayout.setVerticalGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPMecanoterapiaLayout.createSequentialGroup().addGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTCervical).addComponent(this.JCBBarraParalela).addComponent(this.JCBBEstatica).addComponent(this.JCBRuedaHombro)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 5, 32767).addGroup(JPMecanoterapiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEscDedos).addComponent(this.JCBPolea).addComponent(this.JCBPronosupinador).addComponent(this.JCBBalonterapia)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOtrosMecanoter, -2, 62, -2)));
        this.JPElectroterapia.setBorder(BorderFactory.createTitledBorder((Border) null, "ELECTROTERAPIA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBTens.setFont(new Font("Arial", 1, 12));
        this.JCBTens.setForeground(new Color(0, 0, 255));
        this.JCBTens.setText("TENS");
        this.JCBTens.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.17
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBTensActionPerformed(evt);
            }
        });
        this.JCBEstimulacionFar.setFont(new Font("Arial", 1, 12));
        this.JCBEstimulacionFar.setForeground(new Color(0, 0, 255));
        this.JCBEstimulacionFar.setText("Estimulación Farádica");
        this.JCBEstimulacionFar.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.18
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBEstimulacionFarActionPerformed(evt);
            }
        });
        this.JCBEstimulacionGalv.setFont(new Font("Arial", 1, 12));
        this.JCBEstimulacionGalv.setForeground(new Color(0, 0, 255));
        this.JCBEstimulacionGalv.setText("Estimulación Galvánica");
        this.JCBEstimulacionGalv.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.19
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBEstimulacionGalvActionPerformed(evt);
            }
        });
        this.JSPOtrosElect.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Tahoma", 1, 11)));
        this.JTPOtrosElect.setFont(new Font("Arial", 1, 12));
        this.JSPOtrosElect.setViewportView(this.JTPOtrosElect);
        GroupLayout JPElectroterapiaLayout = new GroupLayout(this.JPElectroterapia);
        this.JPElectroterapia.setLayout(JPElectroterapiaLayout);
        JPElectroterapiaLayout.setHorizontalGroup(JPElectroterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElectroterapiaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBEstimulacionFar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEstimulacionGalv).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTens)).addComponent(this.JSPOtrosElect, -2, 355, -2));
        JPElectroterapiaLayout.setVerticalGroup(JPElectroterapiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElectroterapiaLayout.createSequentialGroup().addContainerGap().addGroup(JPElectroterapiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEstimulacionFar).addComponent(this.JCBEstimulacionGalv).addComponent(this.JCBTens)).addGap(7, 7, 7).addComponent(this.JSPOtrosElect, -1, 78, 32767)));
        this.JPMasaje.setBorder(BorderFactory.createTitledBorder((Border) null, "MASAJE", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBMCicatrizal.setFont(new Font("Arial", 1, 12));
        this.JCBMCicatrizal.setForeground(new Color(0, 0, 255));
        this.JCBMCicatrizal.setText("Cicatrizal");
        this.JCBMCicatrizal.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.20
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBMCicatrizalActionPerformed(evt);
            }
        });
        this.JCBSedativo.setFont(new Font("Arial", 1, 12));
        this.JCBSedativo.setForeground(new Color(0, 0, 255));
        this.JCBSedativo.setText("Sedativo");
        this.JCBSedativo.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.21
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBSedativoActionPerformed(evt);
            }
        });
        this.JCBEstimulativo.setFont(new Font("Arial", 1, 12));
        this.JCBEstimulativo.setForeground(new Color(0, 0, 255));
        this.JCBEstimulativo.setText("Estimulativo");
        this.JCBEstimulativo.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.22
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBEstimulativoActionPerformed(evt);
            }
        });
        GroupLayout JPMasajeLayout = new GroupLayout(this.JPMasaje);
        this.JPMasaje.setLayout(JPMasajeLayout);
        JPMasajeLayout.setHorizontalGroup(JPMasajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPMasajeLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBSedativo).addGap(10, 10, 10).addComponent(this.JCBEstimulativo).addGap(10, 10, 10).addComponent(this.JCBMCicatrizal).addGap(214, 214, 214)));
        JPMasajeLayout.setVerticalGroup(JPMasajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMasajeLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPMasajeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSedativo).addComponent(this.JCBMCicatrizal).addComponent(this.JCBEstimulativo)).addGap(76, 76, 76)));
        this.JSPEstiramiento.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTIRAMIENTOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPEstiramiento.setAutoscrolls(true);
        this.JTPEstiramiento.setFont(new Font("Arial", 1, 12));
        this.JSPEstiramiento.setViewportView(this.JTPEstiramiento);
        this.JSPReeducacionMuscular.setBorder(BorderFactory.createTitledBorder((Border) null, "REEDUCACIÓN MUSCULAR", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPReeducacionMuscular.setAutoscrolls(true);
        this.JTPReeducacionMuscular.setFont(new Font("Arial", 1, 12));
        this.JSPReeducacionMuscular.setViewportView(this.JTPReeducacionMuscular);
        this.JSPRehabilitacionMarcha.setBorder(BorderFactory.createTitledBorder((Border) null, "REHABILITACIÓN DE MARCHA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPRehabilitacionMarcha.setAutoscrolls(true);
        this.JTPRehabilitacionMarcha.setFont(new Font("Arial", 1, 12));
        this.JSPRehabilitacionMarcha.setViewportView(this.JTPRehabilitacionMarcha);
        this.JPEjercicios.setBorder(BorderFactory.createTitledBorder((Border) null, "EJERCICIOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBEAAsistidos.setFont(new Font("Arial", 1, 12));
        this.JCBEAAsistidos.setForeground(new Color(0, 0, 255));
        this.JCBEAAsistidos.setText("Activos Asistidos");
        this.JCBEAAsistidos.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.23
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBEAAsistidosActionPerformed(evt);
            }
        });
        this.JCBEAResistidos.setFont(new Font("Arial", 1, 12));
        this.JCBEAResistidos.setForeground(new Color(0, 0, 255));
        this.JCBEAResistidos.setText("Activos Resistidos");
        this.JCBEAResistidos.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.24
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBEAResistidosActionPerformed(evt);
            }
        });
        this.JCBEIsometricos.setFont(new Font("Arial", 1, 12));
        this.JCBEIsometricos.setForeground(new Color(0, 0, 255));
        this.JCBEIsometricos.setText("Isométricos");
        this.JCBEIsometricos.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.25
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBEIsometricosActionPerformed(evt);
            }
        });
        this.JCBCEALibres.setFont(new Font("Arial", 1, 12));
        this.JCBCEALibres.setForeground(new Color(0, 0, 255));
        this.JCBCEALibres.setText("Activos Libres");
        this.JCBCEALibres.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.26
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBCEALibresActionPerformed(evt);
            }
        });
        GroupLayout JPEjerciciosLayout = new GroupLayout(this.JPEjercicios);
        this.JPEjercicios.setLayout(JPEjerciciosLayout);
        JPEjerciciosLayout.setHorizontalGroup(JPEjerciciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEjerciciosLayout.createSequentialGroup().addComponent(this.JCBEIsometricos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCEALibres).addGap(4, 4, 4).addComponent(this.JCBEAAsistidos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEAResistidos)));
        JPEjerciciosLayout.setVerticalGroup(JPEjerciciosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEjerciciosLayout.createSequentialGroup().addGroup(JPEjerciciosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEIsometricos).addComponent(this.JCBCEALibres).addComponent(this.JCBEAAsistidos).addComponent(this.JCBEAResistidos)).addContainerGap(-1, 32767)));
        this.JPNeurologia.setBorder(BorderFactory.createTitledBorder((Border) null, "NEUROLOGÍA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBNeurodesarrollo.setFont(new Font("Arial", 1, 12));
        this.JCBNeurodesarrollo.setForeground(new Color(0, 0, 255));
        this.JCBNeurodesarrollo.setText("Neurodesarrollo");
        this.JCBNeurodesarrollo.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.27
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBNeurodesarrolloActionPerformed(evt);
            }
        });
        this.JCBTfnp.setFont(new Font("Arial", 1, 12));
        this.JCBTfnp.setForeground(new Color(0, 0, 255));
        this.JCBTfnp.setText("TFNP");
        this.JCBTfnp.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.28
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBTfnpActionPerformed(evt);
            }
        });
        this.JCBETemprana.setFont(new Font("Arial", 1, 12));
        this.JCBETemprana.setForeground(new Color(0, 0, 255));
        this.JCBETemprana.setText("Estimulación Temprana");
        this.JCBETemprana.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.29
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBETempranaActionPerformed(evt);
            }
        });
        GroupLayout JPNeurologiaLayout = new GroupLayout(this.JPNeurologia);
        this.JPNeurologia.setLayout(JPNeurologiaLayout);
        JPNeurologiaLayout.setHorizontalGroup(JPNeurologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNeurologiaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBTfnp).addGap(8, 8, 8).addComponent(this.JCBETemprana).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBNeurodesarrollo)));
        JPNeurologiaLayout.setVerticalGroup(JPNeurologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNeurologiaLayout.createSequentialGroup().addGroup(JPNeurologiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTfnp).addComponent(this.JCBETemprana).addComponent(this.JCBNeurodesarrollo)).addContainerGap(-1, 32767)));
        this.JSPOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "OTROS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPOtros.setFont(new Font("Arial", 1, 12));
        this.JSPOtros.setViewportView(this.JTPOtros);
        this.JPPlanCasero.setBorder(BorderFactory.createTitledBorder((Border) null, "PLAN CASERO?", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setForeground(new Color(0, 0, 255));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.30
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JRBSiActionPerformed(evt);
            }
        });
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setForeground(new Color(0, 0, 255));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.31
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPPlanCaseroLayout = new GroupLayout(this.JPPlanCasero);
        this.JPPlanCasero.setLayout(JPPlanCaseroLayout);
        JPPlanCaseroLayout.setHorizontalGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCaseroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(22, 32767)));
        JPPlanCaseroLayout.setVerticalGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCaseroLayout.createSequentialGroup().addContainerGap().addGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addContainerGap(-1, 32767)));
        this.JSPPlanCasero.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN PLAN", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPPlanCasero.setAutoscrolls(true);
        this.JTPPlanCasero.setEditable(false);
        this.JTPPlanCasero.setFont(new Font("Arial", 1, 12));
        this.JTPPlanCasero.setAutoscrolls(false);
        this.JTPPlanCasero.addMouseListener(new MouseAdapter() { // from class: Historia.JIFHistoriaFT.32
            public void mouseClicked(MouseEvent evt) {
                JIFHistoriaFT.this.JTPPlanCaseroMouseClicked(evt);
            }
        });
        this.JSPPlanCasero.setViewportView(this.JTPPlanCasero);
        this.JBTSeguimientot.setFont(new Font("Arial", 1, 12));
        this.JBTSeguimientot.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.JBTSeguimientot.setText("Seguimiento");
        this.JBTSeguimientot.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.33
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JBTSeguimientotActionPerformed(evt);
            }
        });
        this.JBTCierreTF.setFont(new Font("Arial", 1, 12));
        this.JBTCierreTF.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.JBTCierreTF.setText("Cierre Hc");
        this.JBTCierreTF.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.34
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JBTCierreTFActionPerformed(evt);
            }
        });
        this.JBTRetro.setFont(new Font("Arial", 1, 12));
        this.JBTRetro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBTRetro.setText("Envio de Recomendación");
        this.JBTRetro.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.35
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JBTRetroActionPerformed(evt);
            }
        });
        GroupLayout JPTerapiaFLayout = new GroupLayout(this.JPTerapiaF);
        this.JPTerapiaF.setLayout(JPTerapiaFLayout);
        JPTerapiaFLayout.setHorizontalGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTerapiaFLayout.createSequentialGroup().addContainerGap().addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTerapiaFLayout.createSequentialGroup().addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPTerapiaFLayout.createSequentialGroup().addComponent(this.JSPOtros, -2, 337, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPlanCasero, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPPlanCasero, -2, 168, -2)).addGroup(GroupLayout.Alignment.LEADING, JPTerapiaFLayout.createSequentialGroup().addComponent(this.JPEjercicios, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPNeurologia, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTRetro, -1, -1, 32767).addComponent(this.JBTSeguimientot, -1, -1, 32767).addComponent(this.JBTCierreTF, -1, -1, 32767))).addGroup(JPTerapiaFLayout.createSequentialGroup().addComponent(this.JPElectroterapia, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPEstiramiento).addComponent(this.JPMasaje, -2, 273, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRehabilitacionMarcha).addComponent(this.JSPReeducacionMuscular))).addGroup(JPTerapiaFLayout.createSequentialGroup().addComponent(this.JPMediosFisicos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPMecanoterapia, -2, -1, -2))).addGap(55, 55, 55)));
        JPTerapiaFLayout.setVerticalGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTerapiaFLayout.createSequentialGroup().addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPMecanoterapia, -1, -1, 32767).addComponent(this.JPMediosFisicos, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPElectroterapia, -2, -1, -2).addGroup(JPTerapiaFLayout.createSequentialGroup().addComponent(this.JPMasaje, -2, 71, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPEstiramiento, -2, 69, -2)).addGroup(JPTerapiaFLayout.createSequentialGroup().addComponent(this.JSPReeducacionMuscular, -2, 69, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRehabilitacionMarcha, -2, 69, -2))).addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPTerapiaFLayout.createSequentialGroup().addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPEjercicios, -2, -1, -2).addComponent(this.JPNeurologia, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPPlanCasero, -2, 69, -2).addGroup(JPTerapiaFLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPOtros, -2, 69, -2).addGroup(JPTerapiaFLayout.createSequentialGroup().addComponent(this.JPPlanCasero, -2, -1, -2).addGap(1, 1, 1))))).addGroup(JPTerapiaFLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JBTCierreTF).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTSeguimientot, -1, 41, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTRetro, -2, 40, -2))).addContainerGap()));
        this.JTPDatosHc.addTab("TERAPIA FÍSICA", this.JPTerapiaF);
        this.JPterapiaR.setBorder(BorderFactory.createTitledBorder((Border) null, "TERAPIA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBTerapiaResp.setFont(new Font("Arial", 1, 12));
        this.JCBTerapiaResp.setForeground(Color.blue);
        this.JCBTerapiaResp.setText("Terapia Respiratoria");
        this.JCBTerapiaResp.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.36
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBTerapiaRespActionPerformed(evt);
            }
        });
        this.JCBMicronebulizacion.setFont(new Font("Arial", 1, 12));
        this.JCBMicronebulizacion.setForeground(Color.blue);
        this.JCBMicronebulizacion.setSelected(true);
        this.JCBMicronebulizacion.setText("Micronebulización (MNB)");
        this.JCBMicronebulizacion.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.37
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBMicronebulizacionActionPerformed(evt);
            }
        });
        this.JCBOxigenoterapia.setFont(new Font("Arial", 1, 12));
        this.JCBOxigenoterapia.setForeground(Color.blue);
        this.JCBOxigenoterapia.setText("Oxigenoterapia");
        this.JCBOxigenoterapia.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.38
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JCBOxigenoterapiaActionPerformed(evt);
            }
        });
        this.JSPOtrosTR.setBorder(BorderFactory.createTitledBorder((Border) null, "OTROS", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTPOtrosTR.setFont(new Font("Arial Black", 1, 12));
        this.JSPOtrosTR.setViewportView(this.JTPOtrosTR);
        GroupLayout JPterapiaRLayout = new GroupLayout(this.JPterapiaR);
        this.JPterapiaR.setLayout(JPterapiaRLayout);
        JPterapiaRLayout.setHorizontalGroup(JPterapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPterapiaRLayout.createSequentialGroup().addContainerGap().addGroup(JPterapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPOtrosTR).addGroup(JPterapiaRLayout.createSequentialGroup().addComponent(this.JCBMicronebulizacion).addGap(28, 28, 28).addComponent(this.JCBOxigenoterapia).addGap(29, 29, 29).addComponent(this.JCBTerapiaResp).addGap(0, 0, 32767))).addContainerGap()));
        JPterapiaRLayout.setVerticalGroup(JPterapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPterapiaRLayout.createSequentialGroup().addContainerGap().addGroup(JPterapiaRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMicronebulizacion).addComponent(this.JCBOxigenoterapia).addComponent(this.JCBTerapiaResp)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPOtrosTR, -1, 214, 32767).addContainerGap()));
        this.JBTSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBTSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.JBTSeguimiento.setText("Seguimiento");
        this.JBTSeguimiento.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.39
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JBTSeguimientoActionPerformed(evt);
            }
        });
        this.JBTCierre.setFont(new Font("Arial", 1, 12));
        this.JBTCierre.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cancelar30x30.png")));
        this.JBTCierre.setText("Cierre Hc");
        this.JBTCierre.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.40
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JBTCierreActionPerformed(evt);
            }
        });
        this.JBTRetro1.setFont(new Font("Arial", 1, 12));
        this.JBTRetro1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBTRetro1.setText("Envio de Recomendación");
        this.JBTRetro1.addActionListener(new ActionListener() { // from class: Historia.JIFHistoriaFT.41
            public void actionPerformed(ActionEvent evt) {
                JIFHistoriaFT.this.JBTRetro1ActionPerformed(evt);
            }
        });
        GroupLayout JPTerapiaRLayout = new GroupLayout(this.JPTerapiaR);
        this.JPTerapiaR.setLayout(JPTerapiaRLayout);
        JPTerapiaRLayout.setHorizontalGroup(JPTerapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTerapiaRLayout.createSequentialGroup().addContainerGap().addGroup(JPTerapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPterapiaR, -1, -1, 32767).addGroup(JPTerapiaRLayout.createSequentialGroup().addComponent(this.JBTSeguimiento, -2, 286, -2).addGap(18, 18, 18).addComponent(this.JBTCierre, -2, 293, -2).addGap(18, 18, 18).addComponent(this.JBTRetro1, -2, 276, -2))).addContainerGap(176, 32767)));
        JPTerapiaRLayout.setVerticalGroup(JPTerapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTerapiaRLayout.createSequentialGroup().addContainerGap().addComponent(this.JPterapiaR, -2, -1, -2).addGap(18, 18, 18).addGroup(JPTerapiaRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTerapiaRLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPTerapiaRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTSeguimiento, -2, 88, -2).addComponent(this.JBTCierre, -2, 88, -2))).addComponent(this.JBTRetro1, -1, 93, 32767)).addGap(33, 33, 33)));
        this.JTPDatosHc.addTab("RESPIRATORIA - NEBULIZACIONES", this.JPTerapiaR);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatosAtencion, -1, -1, 32767).addComponent(this.JPIDUsuario, -1, -1, 32767).addComponent(this.JTPDatosHc, -2, 1082, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDUsuario, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPDatosAtencion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosHc, -2, 474, -2).addContainerGap()));
        pack();
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
    public void JBTSeguimientoActionPerformed(ActionEvent evt) {
        Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "jifseguimientoft");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCierreActionPerformed(ActionEvent evt) {
        Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "jifcierreft");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRetro1ActionPerformed(ActionEvent evt) {
        Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "jifretroalimentacion");
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
    public void JTPPlanCaseroMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && !this.JTPPlanCasero.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Desea imprimir el plan casero?", "IMPRIMIR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String[][] parametros = new String[5][2];
                parametros[0][0] = "numero";
                parametros[0][1] = Principal.txtNo.getText();
                parametros[1][0] = "nbreUsuario";
                parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                parametros[2][0] = "ruta";
                parametros[2][1] = this.xmetodo.getRutaRep();
                parametros[3][0] = "SUBREPORT_DIR";
                parametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
                parametros[4][0] = "SUBREPORTFIRMA_DIR";
                parametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_PlanCaseroFT", parametros);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSeguimientotActionPerformed(ActionEvent evt) {
        Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "jifseguimientoft");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCierreTFActionPerformed(ActionEvent evt) {
        Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "jifcierreft");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCierreTF1ActionPerformed(ActionEvent evt) {
        Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "Consultar Atenciones");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (Principal.clasescita.frmCitaTerapia != null) {
            Principal.clasescita.frmCitaTerapia.setVisible(true);
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRetroActionPerformed(ActionEvent evt) {
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIDUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 940, 160);
        this.JPIDUsuario.add(this.xjppersona);
        this.JPIDUsuario.setVisible(true);
    }

    public void nuevo() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Desa generar una nueva atencion?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        if (n == 0) {
            this.xllenado = false;
            this.JCBBEstatica.setSelected(false);
            this.JCBBalonterapia.setSelected(false);
            this.JCBBarraParalela.setSelected(false);
            this.JCBCEALibres.setSelected(false);
            this.JCBCRioterapia.setSelected(false);
            this.JCBCalorLocal.setSelected(false);
            this.JCBEAAsistidos.setSelected(false);
            this.JCBEAResistidos.setSelected(false);
            this.JCBEIsometricos.setSelected(false);
            this.JCBETemprana.setSelected(false);
            this.JCBEscDedos.setSelected(false);
            this.JCBEstimulacionFar.setSelected(false);
            this.JCBEstimulacionGalv.setSelected(false);
            this.JCBEstimulativo.setSelected(false);
            this.JCBMCicatrizal.setSelected(false);
            this.JCBMicronebulizacion.setSelected(true);
            this.JCBNeurodesarrollo.setSelected(false);
            this.JCBParafina.setSelected(false);
            this.JCBPolea.setSelected(false);
            this.JCBPronosupinador.setSelected(false);
            this.JCBRayosInfr.setSelected(false);
            this.JCBRuedaHombro.setSelected(false);
            this.JCBSedativo.setSelected(false);
            this.JCBTCervical.setSelected(false);
            this.JCBTens.setSelected(false);
            this.JCBTfnp.setSelected(false);
            this.JCBUltrasonido.setSelected(false);
            this.JRBNo.setSelected(true);
            mInicializarVariables();
            this.JCBProfesional.removeAllItems();
            this.JCBEspecialidad.setSelectedIndex(-1);
            this.JDCFecha.setDate(this.xmetodo.getFechaActual());
            Principal.txtNo.setText((String) null);
            Principal.txtEstado.setText((String) null);
            Principal.txtFecha.setText(this.xmetodo.formatoDMA.format(this.xmetodo.getFechaActual()));
            if (Principal.clasescita.getxTipoTerapia() == 1) {
                mActivarTF();
            } else {
                mActivarTR();
            }
            this.xllenado = true;
        }
    }

    private void mInicializarVariables() {
        this.xcalor = 0;
        this.xcrioterapia = 0;
        this.xrayosinfra = 0;
        this.xparafina = 0;
        this.xultrasonido = 0;
        this.xtracervical = 0;
        this.xbarrparalelas = 0;
        this.xbicileestatica = 0;
        this.xruedahombro = 0;
        this.xescaleradedo = 0;
        this.xpolea = 0;
        this.xpronosupinador = 0;
        this.xbalonterapia = 0;
        this.xestimulfaradica = 0;
        this.xestimulgalvanica = 0;
        this.xtens = 0;
        this.xmsedativo = 0;
        this.xmestimulativo = 0;
        this.xmcicatrizal = 0;
        this.xeisometrico = 0;
        this.xealibres = 0;
        this.xeaasistido = 0;
        this.xearesistidos = 0;
        this.xtfnp = 0;
        this.xnestimulaciontemp = 0;
        this.xnneurodesarrollo = 0;
        this.xplancasero = 0;
        this.xtipoterapia = 0;
    }

    public void grabar() {
        String sql;
        if (Principal.txtNo.getText().isEmpty() && this.xjppersona.validarDatos(0) == 1) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                if (this.JCBProfesional.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql2 = "insert into h_atencionf (Id_Usuario, Id_Atencion, FechaHc, Id_Profesional, Id_Especialidad, UsuarioS, Fecha)  values ('" + this.xjppersona.getIdPersona() + "','" + Principal.clasescita.getxIdAtencion() + "','" + this.xmetodo.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()][0] + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "')";
                        Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql2));
                        this.xconsulta.cerrarConexionBd();
                        Principal.txtEstado.setText("ACTIVA");
                        if (Principal.clasescita.getxTipoTerapia() == 1) {
                            sql = "insert into h_detalletf(Id_AtencionF, CLocal, RInfrarojo, Parafina, Ultrasonido, Crioterapia, OtrosMF, EstimulacionF, EstimulacionGalv, Tens  , OtrosEl, TraccionCervical, BParalelas, BEstatica, RHombro, EscaleraDedos, Polea, Pronosupinador, Balonterapia, OtrasMeca  , Sedativo, Estimulativo, Cicatrizal, Estiramientos, ReeducacionMuscular, Isometricos, ALibres, AAsistidos, AResistidos  , RMarcha, TFNP, ETemprana, Neurodesarrollo, PCasero, DPlanCasero, Otros ) values ('" + Principal.txtNo.getText() + "','" + this.xcalor + "','" + this.xrayosinfra + "','" + this.xparafina + "','" + this.xultrasonido + "','" + this.xcrioterapia + "','" + this.JTPOtrosMf.getText() + "','" + this.xestimulfaradica + "','" + this.xestimulgalvanica + "','" + this.xtens + "','" + this.JTPOtrosElect.getText() + "','" + this.xtracervical + "','" + this.xbarrparalelas + "','" + this.xbicileestatica + "','" + this.xruedahombro + "','" + this.xescaleradedo + "','" + this.xpolea + "','" + this.xpronosupinador + "','" + this.xbalonterapia + "','" + this.JTPOtrosMecan.getText() + "','" + this.xmsedativo + "','" + this.xmestimulativo + "','" + this.xmcicatrizal + "','" + this.JTPEstiramiento.getText() + "','" + this.JTPReeducacionMuscular.getText() + "','" + this.xeisometrico + "','" + this.xealibres + "','" + this.xeaasistido + "','" + this.xearesistidos + "','" + this.JTPRehabilitacionMarcha.getText() + "','" + this.xtfnp + "','" + this.xnestimulaciontemp + "','" + this.xnneurodesarrollo + "','" + this.xplancasero + "','" + this.JTPPlanCasero.getText() + "','" + this.JTPOtros.getText() + "')";
                        } else {
                            sql = "insert into h_detalletr(Id_AtencionF, Tipoterapia, Otros) values ('" + Principal.txtNo.getText() + "','" + this.xtipoterapia + "','" + this.JTPOtrosTR.getText() + "')";
                        }
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        String sql3 = "UPDATE c_citas SET Asistida = 3 WHERE Id ='" + Principal.clasescita.getXidcita() + "'";
                        this.xconsulta.ejecutarSQL(sql3);
                        this.xconsulta.cerrarConexionBd();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 0);
                this.JCBProfesional.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 0);
            this.JCBEspecialidad.requestFocus();
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "idatencion1";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            if (Principal.clasescita.getxTipoTerapia() == 1) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinicaFT", parametros);
            } else {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_HistoriaClinicaFTR", parametros);
            }
        }
    }

    private void mTraerNAtencion() {
        try {
            String xsql = "SELECT Id FROM h_atencion WHERE (Id_Ingreso ='" + Principal.clasescita.getxIdIngreso() + "') ";
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                Principal.clasescita.setxIdAtencion(xrs.getLong(1));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaFT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActivarPestana() {
        if (Principal.clasescita.getxTipoTerapia() == 1) {
            this.JTPDatosHc.setEnabledAt(0, true);
            this.JTPDatosHc.setEnabledAt(1, false);
            this.JTPDatosHc.setSelectedIndex(0);
        } else {
            this.JTPDatosHc.setEnabledAt(0, false);
            this.JTPDatosHc.setEnabledAt(1, true);
            this.JTPDatosHc.setSelectedIndex(1);
        }
    }

    public void mTerapiasResp() {
        String sql;
        if (Principal.clasescita.getxIdAtencion() == 0) {
            sql = "SELECT h_atencionf.FechaHc, g_especialidad.Nbre, profesional1.NProfesional, h_detalletr.Tipoterapia, h_detalletr.Otros , h_atencionf.Id_Atencion, h_atencionf.Estado, h_atencionf.Id_Usuario, h_atencionf.Id, MAX(h_atencionf.Id)  FROM h_detalletr INNER JOIN h_atencionf  ON (h_detalletr.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1   ON (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN g_especialidad  ON (g_especialidad.Id = h_atencionf.Id_Especialidad) WHERE (h_atencionf.Estado =1 AND h_atencionf.Id_Usuario ='" + this.xjppersona.getIdPersona() + "') GROUP BY h_atencionf.Id_Usuario  ";
        } else {
            sql = "SELECT h_atencionf.FechaHc, g_especialidad.Nbre, profesional1.NProfesional, h_detalletr.Tipoterapia, h_detalletr.Otros , h_atencionf.Id_Atencion, h_atencionf.Estado, h_atencionf.Id_Usuario, h_atencionf.Id, MAX(h_atencionf.Id)  FROM h_detalletr INNER JOIN h_atencionf  ON (h_detalletr.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1   ON (profesional1.Id_Persona = h_atencionf.Id_Profesional) INNER JOIN g_especialidad  ON (g_especialidad.Id = h_atencionf.Id_Especialidad) WHERE ( h_atencionf.Estado =1 AND h_atencionf.Id_Usuario ='" + this.xjppersona.getIdPersona() + "') GROUP BY h_atencionf.Id_Usuario ";
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

    public void mTerapiasFis() {
        String sql;
        if (Principal.clasescita.getxIdAtencion() == 0) {
            sql = "SELECT h_atencionf.FechaHc, profesional1.NProfesional, profesional1.Especialidad, h_detalletf.CLocal, h_detalletf.RInfrarojo, h_detalletf.Parafina, h_detalletf.Ultrasonido, h_detalletf.Crioterapia , h_detalletf.OtrosMF, h_detalletf.EstimulacionF, h_detalletf.EstimulacionGalv, h_detalletf.Tens, h_detalletf.OtrosEl, h_detalletf.TraccionCervical, h_detalletf.BParalelas, h_detalletf.BEstatica, h_detalletf.RHombro , h_detalletf.EscaleraDedos, h_detalletf.Polea, h_detalletf.Pronosupinador, h_detalletf.Balonterapia, h_detalletf.OtrasMeca, h_detalletf.Sedativo, h_detalletf.Estimulativo, h_detalletf.Cicatrizal, h_detalletf.Estiramientos , h_detalletf.ReeducacionMuscular, h_detalletf.Isometricos, h_detalletf.ALibres, h_detalletf.AAsistidos, h_detalletf.AResistidos, h_detalletf.RMarcha, h_detalletf.TFNP, h_detalletf.ETemprana, h_detalletf.Neurodesarrollo , h_detalletf.PCasero, h_detalletf.Otros, h_atencionf.Id_Atencion, h_atencionf.Id_Usuario, h_atencionf.Id, h_atencionf.Estado, h_detalletf.DPlanCasero, MAX(h_atencionf.Id) FROM h_detalletf INNER JOIN h_atencionf  ON (h_detalletf.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1  ON (profesional1.IdEspecialidad = h_atencionf.Id_Especialidad) AND (profesional1.Id_Persona = h_atencionf.Id_Profesional) WHERE (h_atencionf.Estado =1 AND h_atencionf.Id_Usuario ='" + this.xjppersona.getIdPersona() + "') GROUP BY h_atencionf.Id_Usuario";
        } else {
            sql = "SELECT h_atencionf.FechaHc, profesional1.NProfesional, profesional1.Especialidad, h_detalletf.CLocal, h_detalletf.RInfrarojo, h_detalletf.Parafina, h_detalletf.Ultrasonido, h_detalletf.Crioterapia , h_detalletf.OtrosMF, h_detalletf.EstimulacionF, h_detalletf.EstimulacionGalv, h_detalletf.Tens, h_detalletf.OtrosEl, h_detalletf.TraccionCervical, h_detalletf.BParalelas, h_detalletf.BEstatica, h_detalletf.RHombro , h_detalletf.EscaleraDedos, h_detalletf.Polea, h_detalletf.Pronosupinador, h_detalletf.Balonterapia, h_detalletf.OtrasMeca, h_detalletf.Sedativo, h_detalletf.Estimulativo, h_detalletf.Cicatrizal, h_detalletf.Estiramientos , h_detalletf.ReeducacionMuscular, h_detalletf.Isometricos, h_detalletf.ALibres, h_detalletf.AAsistidos, h_detalletf.AResistidos, h_detalletf.RMarcha, h_detalletf.TFNP, h_detalletf.ETemprana, h_detalletf.Neurodesarrollo , h_detalletf.PCasero, h_detalletf.Otros, h_atencionf.Id_Atencion, h_atencionf.Id_Usuario, h_atencionf.Id, h_atencionf.Estado, h_detalletf.DPlanCasero, MAX(h_atencionf.Id) FROM h_detalletf INNER JOIN h_atencionf  ON (h_detalletf.Id_AtencionF = h_atencionf.Id) INNER JOIN profesional1  ON (profesional1.IdEspecialidad = h_atencionf.Id_Especialidad) AND (profesional1.Id_Persona = h_atencionf.Id_Profesional) WHERE (h_atencionf.Estado =1 AND h_atencionf.Id_Usuario ='" + this.xjppersona.getIdPersona() + "') GROUP BY h_atencionf.Id_Usuario";
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
}
