package Historia;

import Acceso.Principal;
import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPTrasnporteAsis.class */
public class JPTrasnporteAsis extends JPanel {
    private String[] idespecialida;
    private String[] xidempresa;
    private String[] xidmunicipio;
    private String[] xidParentezco;
    private String[] xidTAtencion;
    private int esllenado;
    private String xsql;
    private String xplaca;
    private String xconductor;
    private ReporteRemision xReporteRemision;
    private ReporteContraRemision xReporteContraRemision;
    private ButtonGroup JBGAmbulancia;
    private ButtonGroup JBGHospitalizacion;
    private ButtonGroup JBGTRemision;
    private ButtonGroup JBGUrgente;
    private JPanel JBTRemitido;
    public JComboBox JCBEmpresaCR;
    public JComboBox JCBEspecialidad;
    public JComboBox JCBMunicipio;
    public JComboBox JCBServRemision;
    private JCheckBox JCHLimpiar;
    private JLabel JLBEstado;
    private JLabel JLBNRemision;
    private JPanel JPRemisiones;
    private JRadioButton JRBPrimari;
    private JRadioButton JRBSecundaria;
    private JRadioButton JRBUNo;
    private JRadioButton JRBUSi;
    private JScrollPane JSPDRObservaciones;
    private JScrollPane JSPEor;
    private JTextPane JTADRObservaciones;
    private JTextPane JTADRemisiones;
    private JTabbedPane JTDRemision;
    private JTextField JTFConductor;
    private JTextField JTFEnfermera;
    private JTextField JTFInstirucionRecibe;
    private JTextField JTFMedicoAco;
    private JTextField JTFPlaca_amb;
    private JTextField JTFProfesionalRecibe;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xp8 = 0;
    private int xp9 = 0;
    private int urgente = 0;
    private int xidm = -1;
    private int xidem = -1;
    private int xtipo = 0;
    private int xtipoRemision = 0;

    public JPTrasnporteAsis() {
        this.esllenado = 0;
        initComponents();
        this.idespecialida = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0 and RValoracion=1) ORDER BY Nbre", this.idespecialida, this.JCBEspecialidad);
        JTextComponent editor = this.JCBEspecialidad.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.JCBEspecialidad));
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xidempresa = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM f_empresacontxconvenio ORDER BY Nbre ASC", this.xidempresa, this.JCBEmpresaCR);
        this.JCBEmpresaCR.setSelectedIndex(-1);
        this.xidmunicipio = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_municipio ORDER BY Nbre ASC", this.xidmunicipio, this.JCBMunicipio);
        this.JCBMunicipio.setSelectedIndex(-1);
        this.JCBServRemision.setSelectedIndex(-1);
        mComponerDatosInicialesRemision();
        mDesactivarR();
        this.xconsultasbd.cerrarConexionBd();
        this.esllenado = 1;
        mRadioButonFalse();
    }

    private void initComponents() {
        this.JBGUrgente = new ButtonGroup();
        this.JBGHospitalizacion = new ButtonGroup();
        this.JBGAmbulancia = new ButtonGroup();
        this.JBGTRemision = new ButtonGroup();
        this.JTDRemision = new JTabbedPane();
        this.JPRemisiones = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JSPEor = new JScrollPane();
        this.JTADRemisiones = new JTextPane();
        this.jPanel1 = new JPanel();
        this.JRBUSi = new JRadioButton();
        this.JRBUNo = new JRadioButton();
        this.JLBNRemision = new JLabel();
        this.JLBEstado = new JLabel();
        this.JCHLimpiar = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.JRBPrimari = new JRadioButton();
        this.JRBSecundaria = new JRadioButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.JBTRemitido = new JPanel();
        this.JCBEmpresaCR = new JComboBox();
        this.JSPDRObservaciones = new JScrollPane();
        this.JTADRObservaciones = new JTextPane();
        this.JTFProfesionalRecibe = new JTextField();
        this.JTFInstirucionRecibe = new JTextField();
        this.JCBMunicipio = new JComboBox();
        this.JTFConductor = new JTextField();
        this.JTFPlaca_amb = new JTextField();
        this.JTFEnfermera = new JTextField();
        this.JTFMedicoAco = new JTextField();
        this.JCBServRemision = new JComboBox();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ORDEN DE INTECONSULTA O REMISIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jptransporteAsistencial");
        this.JTDRemision.setForeground(Color.red);
        this.JTDRemision.setFont(new Font("Arial", 1, 14));
        this.JPRemisiones.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 18)));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JPTrasnporteAsis.1
            public void itemStateChanged(ItemEvent evt) {
                JPTrasnporteAsis.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBEspecialidad.addKeyListener(new KeyAdapter() { // from class: Historia.JPTrasnporteAsis.2
            public void keyPressed(KeyEvent evt) {
                JPTrasnporteAsis.this.JCBEspecialidadKeyPressed(evt);
            }
        });
        this.JSPEor.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTADRemisiones.setFont(new Font("Arial", 1, 12));
        this.JTADRemisiones.addKeyListener(new KeyAdapter() { // from class: Historia.JPTrasnporteAsis.3
            public void keyPressed(KeyEvent evt) {
                JPTrasnporteAsis.this.JTADRemisionesKeyPressed(evt);
            }
        });
        this.JSPEor.setViewportView(this.JTADRemisiones);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Es Prioritaria ?", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGUrgente.add(this.JRBUSi);
        this.JRBUSi.setFont(new Font("Arial", 1, 12));
        this.JRBUSi.setForeground(Color.blue);
        this.JRBUSi.setText("Si");
        this.JRBUSi.addActionListener(new ActionListener() { // from class: Historia.JPTrasnporteAsis.4
            public void actionPerformed(ActionEvent evt) {
                JPTrasnporteAsis.this.JRBUSiActionPerformed(evt);
            }
        });
        this.JRBUSi.addKeyListener(new KeyAdapter() { // from class: Historia.JPTrasnporteAsis.5
            public void keyPressed(KeyEvent evt) {
                JPTrasnporteAsis.this.JRBUSiKeyPressed(evt);
            }
        });
        this.JBGUrgente.add(this.JRBUNo);
        this.JRBUNo.setFont(new Font("Arial", 1, 12));
        this.JRBUNo.setForeground(Color.blue);
        this.JRBUNo.setSelected(true);
        this.JRBUNo.setText("No");
        this.JRBUNo.addActionListener(new ActionListener() { // from class: Historia.JPTrasnporteAsis.6
            public void actionPerformed(ActionEvent evt) {
                JPTrasnporteAsis.this.JRBUNoActionPerformed(evt);
            }
        });
        this.JRBUNo.addKeyListener(new KeyAdapter() { // from class: Historia.JPTrasnporteAsis.7
            public void keyPressed(KeyEvent evt) {
                JPTrasnporteAsis.this.JRBUNoKeyPressed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(9, 32767).addComponent(this.JRBUSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBUNo).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUSi).addComponent(this.JRBUNo)));
        this.JLBNRemision.setBackground(new Color(255, 255, 255));
        this.JLBNRemision.setFont(new Font("Arial", 1, 18));
        this.JLBNRemision.setForeground(new Color(255, 0, 0));
        this.JLBNRemision.setHorizontalAlignment(0);
        this.JLBNRemision.setBorder(BorderFactory.createTitledBorder((Border) null, "N° InterConsulta", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBEstado.setBackground(new Color(255, 255, 255));
        this.JLBEstado.setFont(new Font("Arial", 1, 18));
        this.JLBEstado.setForeground(new Color(255, 0, 0));
        this.JLBEstado.setHorizontalAlignment(0);
        this.JLBEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHLimpiar.setFont(new Font("Arial", 1, 12));
        this.JCHLimpiar.setForeground(new Color(255, 0, 0));
        this.JCHLimpiar.setText("No utlizar resumen de atención.");
        this.JCHLimpiar.addActionListener(new ActionListener() { // from class: Historia.JPTrasnporteAsis.8
            public void actionPerformed(ActionEvent evt) {
                JPTrasnporteAsis.this.JCHLimpiarActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Remisión", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGTRemision.add(this.JRBPrimari);
        this.JRBPrimari.setFont(new Font("Arial", 1, 12));
        this.JRBPrimari.setForeground(Color.blue);
        this.JRBPrimari.setSelected(true);
        this.JRBPrimari.setText("Primaria");
        this.JRBPrimari.addActionListener(new ActionListener() { // from class: Historia.JPTrasnporteAsis.9
            public void actionPerformed(ActionEvent evt) {
                JPTrasnporteAsis.this.JRBPrimariActionPerformed(evt);
            }
        });
        this.JRBPrimari.addKeyListener(new KeyAdapter() { // from class: Historia.JPTrasnporteAsis.10
            public void keyPressed(KeyEvent evt) {
                JPTrasnporteAsis.this.JRBPrimariKeyPressed(evt);
            }
        });
        this.JBGTRemision.add(this.JRBSecundaria);
        this.JRBSecundaria.setFont(new Font("Arial", 1, 12));
        this.JRBSecundaria.setForeground(Color.blue);
        this.JRBSecundaria.setText("Secundaria");
        this.JRBSecundaria.addActionListener(new ActionListener() { // from class: Historia.JPTrasnporteAsis.11
            public void actionPerformed(ActionEvent evt) {
                JPTrasnporteAsis.this.JRBSecundariaActionPerformed(evt);
            }
        });
        this.JRBSecundaria.addKeyListener(new KeyAdapter() { // from class: Historia.JPTrasnporteAsis.12
            public void keyPressed(KeyEvent evt) {
                JPTrasnporteAsis.this.JRBSecundariaKeyPressed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBPrimari).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSecundaria).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPrimari).addComponent(this.JRBSecundaria)));
        GroupLayout JPRemisionesLayout = new GroupLayout(this.JPRemisiones);
        this.JPRemisiones.setLayout(JPRemisionesLayout);
        JPRemisionesLayout.setHorizontalGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRemisionesLayout.createSequentialGroup().addContainerGap().addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRemisionesLayout.createSequentialGroup().addComponent(this.JCHLimpiar).addGap(0, 0, 32767)).addGroup(JPRemisionesLayout.createSequentialGroup().addComponent(this.JSPEor).addContainerGap()).addGroup(JPRemisionesLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 260, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBEstado, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNRemision, -2, 124, -2).addGap(19, 19, 19)))));
        JPRemisionesLayout.setVerticalGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRemisionesLayout.createSequentialGroup().addContainerGap().addGroup(JPRemisionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBNRemision, -1, -1, 32767).addComponent(this.JLBEstado, -1, -1, 32767).addComponent(this.JCBEspecialidad).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHLimpiar).addGap(3, 3, 3).addComponent(this.JSPEor, -2, 145, -2).addGap(3, 3, 3)));
        this.JTDRemision.addTab("DESCRIPCIÓN", this.JPRemisiones);
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JBTRemitido.setBorder(BorderFactory.createEtchedBorder());
        this.JCBEmpresaCR.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresaCR.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa por la cual se remite", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresaCR.addItemListener(new ItemListener() { // from class: Historia.JPTrasnporteAsis.13
            public void itemStateChanged(ItemEvent evt) {
                JPTrasnporteAsis.this.JCBEmpresaCRItemStateChanged(evt);
            }
        });
        this.JSPDRObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADRObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTADRObservaciones.addKeyListener(new KeyAdapter() { // from class: Historia.JPTrasnporteAsis.14
            public void keyPressed(KeyEvent evt) {
                JPTrasnporteAsis.this.JTADRObservacionesKeyPressed(evt);
            }
        });
        this.JSPDRObservaciones.setViewportView(this.JTADRObservaciones);
        this.JTFProfesionalRecibe.setFont(new Font("Arial", 1, 12));
        this.JTFProfesionalRecibe.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que recibe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFInstirucionRecibe.setFont(new Font("Arial", 1, 12));
        this.JTFInstirucionRecibe.setBorder(BorderFactory.createTitledBorder((Border) null, "Institución que recibe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMunicipio.addItemListener(new ItemListener() { // from class: Historia.JPTrasnporteAsis.15
            public void itemStateChanged(ItemEvent evt) {
                JPTrasnporteAsis.this.JCBMunicipioItemStateChanged(evt);
            }
        });
        this.JTFConductor.setFont(new Font("Arial", 1, 12));
        this.JTFConductor.setBorder(BorderFactory.createTitledBorder((Border) null, "Conductor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPlaca_amb.setFont(new Font("Arial", 1, 12));
        this.JTFPlaca_amb.setBorder(BorderFactory.createTitledBorder((Border) null, "Placa de Ambulancia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEnfermera.setFont(new Font("Arial", 1, 12));
        this.JTFEnfermera.setBorder(BorderFactory.createTitledBorder((Border) null, "Aux. Enfermería", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFMedicoAco.setFont(new Font("Arial", 1, 12));
        this.JTFMedicoAco.setBorder(BorderFactory.createTitledBorder((Border) null, "Médico Acompañante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBServRemision.setFont(new Font("Arial", 1, 12));
        this.JCBServRemision.setToolTipText("Servicio para el cual se solicita la referencia");
        this.JCBServRemision.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio a Remitir", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBServRemision.addItemListener(new ItemListener() { // from class: Historia.JPTrasnporteAsis.16
            public void itemStateChanged(ItemEvent evt) {
                JPTrasnporteAsis.this.JCBServRemisionItemStateChanged(evt);
            }
        });
        GroupLayout JBTRemitidoLayout = new GroupLayout(this.JBTRemitido);
        this.JBTRemitido.setLayout(JBTRemitidoLayout);
        JBTRemitidoLayout.setHorizontalGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JBTRemitidoLayout.createSequentialGroup().addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JBTRemitidoLayout.createSequentialGroup().addComponent(this.JCBEmpresaCR, -2, 235, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBServRemision, 0, 142, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMunicipio, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFInstirucionRecibe, -2, 274, -2)).addGroup(JBTRemitidoLayout.createSequentialGroup().addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JBTRemitidoLayout.createSequentialGroup().addComponent(this.JTFProfesionalRecibe, -2, 324, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPlaca_amb, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFConductor, -2, 313, -2)).addGroup(JBTRemitidoLayout.createSequentialGroup().addComponent(this.JTFMedicoAco, -2, 264, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEnfermera, -2, 264, -2))).addGap(0, 0, 32767)).addGroup(JBTRemitidoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDRObservaciones))).addContainerGap()));
        JBTRemitidoLayout.setVerticalGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JBTRemitidoLayout.createSequentialGroup().addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresaCR, -2, 50, -2).addComponent(this.JCBServRemision, -2, 50, -2).addComponent(this.JCBMunicipio, -2, 50, -2).addComponent(this.JTFInstirucionRecibe, -1, 50, 32767)).addGap(2, 2, 2).addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFProfesionalRecibe, -2, 50, -2).addComponent(this.JTFConductor, -2, 50, -2).addComponent(this.JTFPlaca_amb, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JBTRemitidoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFEnfermera, -2, 50, -2).addComponent(this.JTFMedicoAco, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDRObservaciones, -2, 91, -2).addContainerGap()));
        this.jTabbedPane1.addTab("DATOS DE REMISIÓN", this.JBTRemitido);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTDRemision, GroupLayout.Alignment.TRAILING).addComponent(this.jTabbedPane1, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTDRemision, -2, 275, -2).addGap(3, 3, 3).addComponent(this.jTabbedPane1, -2, 301, -2).addContainerGap(-1, 32767)));
    }

    private boolean mBuscaRemisionPac() {
        boolean xexiste = false;
        String sql = "SELECT `Id` FROM `h_remisiones` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "');";
        ResultSet xrs = this.xconsultasbd.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xexiste = true;
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTrasnporteAsis.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xexiste;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.esllenado == 1) {
            this.JTADRemisiones.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUNoActionPerformed(ActionEvent evt) {
        this.urgente = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUSiActionPerformed(ActionEvent evt) {
        this.urgente = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBEspecialidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUSiKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.urgente = 1;
            this.JRBUSi.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUNoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.urgente = 0;
            this.JRBUNo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADRemisionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTADRemisiones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADRObservacionesKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMunicipioItemStateChanged(ItemEvent evt) {
        if (this.esllenado == 1 && this.JCBMunicipio.getSelectedIndex() != -1) {
            this.xidm = Integer.valueOf(this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()]).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaCRItemStateChanged(ItemEvent evt) {
        if (this.esllenado == 1 && this.JCBEmpresaCR.getSelectedIndex() != -1) {
            this.xidem = Integer.valueOf(this.xidempresa[this.JCBEmpresaCR.getSelectedIndex()]).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLimpiarActionPerformed(ActionEvent evt) {
        if (this.JCHLimpiar.isSelected()) {
            this.JTADRemisiones.setText("");
            this.JTADRemisiones.requestFocus();
        } else {
            mComponerDatosInicialesRemision();
            this.JTADRemisiones.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBServRemisionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPrimariActionPerformed(ActionEvent evt) {
        this.xtipoRemision = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPrimariKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSecundariaActionPerformed(ActionEvent evt) {
        this.xtipoRemision = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSecundariaKeyPressed(KeyEvent evt) {
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "' and Estado=1";
                ResultSet res = this.xconsultasbd.traerRs(sql);
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
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void mRadioButonFalse() {
    }

    public void grabar() {
        if (!mBuscaRemisionPac()) {
            if (this.JLBNRemision.getText().isEmpty()) {
                if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                    if (!this.JTADRemisiones.getText().isEmpty()) {
                        if (this.JCBEmpresaCR.getSelectedIndex() != -1) {
                            if (this.JCBMunicipio.getSelectedIndex() != -1) {
                                if (!this.JTFProfesionalRecibe.getText().isEmpty()) {
                                    if (!this.JTFInstirucionRecibe.getText().isEmpty()) {
                                        if (this.JCBServRemision.getSelectedIndex() != -1) {
                                            if (!this.JTFPlaca_amb.getText().isEmpty()) {
                                                if (!this.JTFConductor.getText().isEmpty()) {
                                                    if (!this.JTFMedicoAco.getText().isEmpty()) {
                                                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                        if (n == 0) {
                                                            String sql = "INSERT INTO  `h_remisiones`   (  `Fecha`, `Hora`, `Tipo`, `Id_Atencion`, `I_Especialidad`, `EsUrgente`, `Detalle`,   `Id_EmpresaR`, `Id_Municipio`, `NInstitucion`, `MedicosRecibe`, `ObservacionesRM`,   `Id_Profesional`, `Id_EspecialidadR`,   `PlacaAmbulancia`,   `Conductor`, `TipoRemision`,  `AuxEnfermeria`, `MedicoAcompania`, ServicioRem, `UsuarioS`)  VALUES ( '" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', '" + this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()) + "', '1', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + this.idespecialida[this.JCBEspecialidad.getSelectedIndex()] + "', '" + this.urgente + "', '" + this.JTADRemisiones.getText() + "',    '" + this.xidempresa[this.JCBEmpresaCR.getSelectedIndex()] + "', '" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()] + "', '" + this.JTFInstirucionRecibe.getText() + "', '" + this.JTFProfesionalRecibe.getText() + "', '" + this.JTADRObservaciones.getText() + "',    '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + this.JTFPlaca_amb.getText() + "', '" + this.JTFConductor.getText() + "', '" + this.xtipoRemision + "',    '" + this.JTFEnfermera.getText() + "', '" + this.JTFMedicoAco.getText() + "', '" + this.JCBServRemision.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                                            this.JLBNRemision.setText(this.xconsultasbd.ejecutarSQLId(sql));
                                                            this.xconsultasbd.cerrarConexionBd();
                                                            this.JLBEstado.setText("ACTIVA");
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    JOptionPane.showInternalMessageDialog(this, "Digite el nombre del medico que acompaña", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                    this.JTFMedicoAco.requestFocus();
                                                    return;
                                                }
                                                JOptionPane.showInternalMessageDialog(this, "Digite el nombre del conductor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JTFConductor.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Digite la placa de la ambulancia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTFPlaca_amb.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Seleccione el servicio para el cual se solicita la remisión", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JCBServRemision.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Digite la institución que recibe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFInstirucionRecibe.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Digite el profesional que recibe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFProfesionalRecibe.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Seleccione el municipio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBMunicipio.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Seleccione la empresa por la cual se remite", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBEmpresaCR.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo descripción de \n remision no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTADRemisiones.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "\t\t\tDebe seleccionar \n la especialidad a la que remite", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEspecialidad.requestFocus();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Esta atención ya tiene una remisión", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBEspecialidad.requestFocus();
    }

    public void nuevo() {
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JLBNRemision.setText("");
        this.JLBEstado.setText((String) null);
        this.JCBMunicipio.setSelectedIndex(-1);
        this.JCBEmpresaCR.setSelectedIndex(-1);
        this.JTFInstirucionRecibe.setText((String) null);
        this.JTFProfesionalRecibe.setText((String) null);
        this.JTADRObservaciones.setText((String) null);
        this.JCBEspecialidad.requestFocus();
        mDesactivarR();
        this.JTADRemisiones.setText(clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta());
    }

    public void imprimir() {
        Object[] botones1 = {"INSTITUCIONAL", "REFERENCIA", "CONTRAREFERENCIA", "CERRAR"};
        int n = JOptionPane.showOptionDialog(this, "Que desea imprimir?", "VISUALIZAR", 0, 3, (Icon) null, botones1, "CERRAR");
        if (n != 0) {
            if (n == 1) {
                this.xReporteRemision = new ReporteRemision(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), this.JLBNRemision.getText());
                this.xReporteRemision.build();
                this.xmetodo.mostrarPdf(this.xmetodo.getRutaRep() + "\\FReferencia" + this.JLBNRemision.getText() + ".pdf");
            } else if (n == 2) {
                this.xReporteContraRemision = new ReporteContraRemision(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                this.xReporteContraRemision.build();
                this.xmetodo.mostrarPdf(this.xmetodo.getRutaRep() + "\\FContraReferencia.pdf");
            }
        }
    }

    public void mBuscarRemision(String id) {
        try {
            String sql = "SELECT h_remisiones.Id, h_remisiones.EsUrgente, h_remisiones.Detalle, h_remisiones.Estado, g_especialidad.Nbre, Id_Municipio FROM h_remisiones INNER JOIN g_especialidad ON (h_remisiones.I_Especialidad = g_especialidad.Id) WHERE (h_remisiones.Id ='" + id + "')";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.first();
                this.JCBEspecialidad.setSelectedItem(rs.getString(5));
                if (rs.getInt(4) == 1) {
                    this.JLBEstado.setText("ANULADA");
                } else {
                    this.JLBEstado.setText("ACTIVA");
                }
                if (rs.getInt(2) == 1) {
                    this.JRBUSi.setSelected(true);
                } else {
                    this.JRBUSi.setSelected(false);
                }
                this.JTADRemisiones.setText(rs.getString(3));
                this.JLBNRemision.setText("" + rs.getInt(1));
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void mComponerDatosInicialesRemision() {
        try {
            this.xsql = "SELECT  CONCAT('DATOS EXAMEN FISICO : \n', CONCAT('FC (p/m) : ',h_examenfisico.FCardiaca) ,'     ', CONCAT('FR (r/m): ',h_examenfisico.FRespiratoria) ,'     ', CONCAT('Talla (cm): ',h_examenfisico.Talla),'     ',CONCAT('Peso (Kg): ',h_examenfisico.Peso),'     ',CONCAT('Imc: ',h_examenfisico.IMC) ) AS Examen,  h_examenfisico.Observacion, h_atencion.Motivo_atencion, h_atencion.EActual FROM  h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) WHERE (h_examenfisico.Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_atencion.Id_Especialidad ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'); ";
            this.JTADRemisiones.setText("MC:" + clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta() + "\n\nEA: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getEnfermedadActual());
            ResultSet xrs = this.xconsultasbd.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTADRemisiones.setText("MC:" + xrs.getString(3) + "\n\n EA: " + xrs.getString(4) + "\n\n" + xrs.getString(1));
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
            this.xsql = "SELECT h_grupoexamenfisico.Nbre, h_tipoexamenfisico.Nbre, h_detalleexamenfisico.Descripcion , h_grupoexamenfisico.Orden FROM  h_examenfisico INNER JOIN h_atencion  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_detalleexamenfisico  ON (h_detalleexamenfisico.Id_ExamenFisico = h_examenfisico.Id) INNER JOIN h_tipoexamenfisico  ON (h_detalleexamenfisico.Id_TipoExamenFisico = h_tipoexamenfisico.Id) INNER JOIN h_grupoexamenfisico  ON (h_grupoexamenfisico.Id = h_tipoexamenfisico.Id_GrupoExamenFisico) WHERE (h_examenfisico.Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_detalleexamenfisico.Valor =1) ORDER BY h_grupoexamenfisico.Orden ASC, h_tipoexamenfisico.Nbre ASC ";
            ResultSet xrs2 = this.xconsultasbd.traerRs(this.xsql);
            if (xrs2.next()) {
                xrs2.last();
                int xn = xrs2.getRow();
                if (xn == 1) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nDETALLE EXÁMEN FÍSICO\n" + xrs2.getString(1) + "\t" + xrs2.getString(2) + "\t" + xrs2.getString(3));
                } else {
                    xrs2.beforeFirst();
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nDETALLE EXÁMEN FÍSICO");
                    while (xrs2.next()) {
                        this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n" + xrs2.getString(1) + "\t" + xrs2.getString(2) + "\t" + xrs2.getString(3) + "\n");
                    }
                }
            }
            xrs2.close();
            this.xconsultasbd.cerrarConexionBd();
            this.xsql = "SELECT IF(Conclusion IS NULL,'',Conclusion) AS Conclusion, IF(Recomendaciones IS NULL,'',Recomendaciones)  AS Recomendaciones FROM h_atencion WHERE (Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
            ResultSet xrs3 = this.xconsultasbd.traerRs(this.xsql);
            if (xrs3.next()) {
                xrs3.first();
                if (xrs3.getString(1).length() > 0) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nCONCLUSIÓN \n" + xrs3.getString(1));
                }
                if (xrs3.getString(2).length() > 0) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nRECOMENDACIONES \n" + xrs3.getString(2));
                }
            }
            xrs3.close();
            this.xconsultasbd.cerrarConexionBd();
            this.xsql = "SELECT h_atenciondx.Orden, g_patologia.Id, g_patologia.Nbre FROM h_atenciondx INNER JOIN g_patologia  ON (h_atenciondx.Id_Dx = g_patologia.Id) WHERE (h_atenciondx.Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ORDER BY h_atenciondx.Orden ASC ";
            ResultSet xrs4 = this.xconsultasbd.traerRs(this.xsql);
            if (xrs4.next()) {
                xrs4.last();
                int xn2 = xrs4.getRow();
                if (xn2 == 1) {
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nIMPRESIÓN DIAGNÓSTICA\n" + xrs4.getString(1) + "-" + xrs4.getString(2) + "  -  " + xrs4.getString(3));
                } else {
                    xrs4.beforeFirst();
                    this.JTADRemisiones.setText(this.JTADRemisiones.getText() + "\n\nIMPRESIÓN DIAGNÓSTICA\n");
                    while (xrs4.next()) {
                        this.JTADRemisiones.setText(this.JTADRemisiones.getText() + xrs4.getString(1) + "-" + xrs4.getString(2) + "   -   " + xrs4.getString(3) + "\n");
                    }
                }
            }
            xrs4.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTrasnporteAsis.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void anular() {
        if (!this.JLBNRemision.getText().isEmpty()) {
            int n = JOptionPane.showInternalOptionDialog(this, "Esta seguro de anular", "ANULAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, 0);
            if (n == 0) {
                String sql = "UPDATE h_remisiones SET Estado =1 WHERE Id ='" + this.JLBNRemision.getText() + "'";
                this.xconsultasbd.ejecutarSQL(sql);
                this.xconsultasbd.cerrarConexionBd();
                this.JLBEstado.setText("ANULADA");
            }
        }
    }

    private void mActivarR() {
        this.JCBMunicipio.setEnabled(true);
        this.JCBEmpresaCR.setEnabled(true);
        this.JTFInstirucionRecibe.setEnabled(true);
        this.JTFProfesionalRecibe.setEnabled(true);
        this.JTADRObservaciones.setEnabled(true);
    }

    private void mDesactivarR() {
    }

    public void buscar() {
        try {
            Component jIFConsultarRemisiones = new JIFConsultarRemisiones(Principal.clasehistoriace, 0);
            Principal.PanelPpal.add(jIFConsultarRemisiones, JLayeredPane.DEFAULT_LAYER);
            jIFConsultarRemisiones.setVisible(true);
            jIFConsultarRemisiones.setSelected(true);
        } catch (PropertyVetoException e) {
        }
    }
}
