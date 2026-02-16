package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.DetalleExamenFisicoDAO;
import com.genoma.plus.dao.historia.ExamenFisicoDAO;
import com.genoma.plus.dao.impl.historia.DetalleExamenFisicoDAOImpl;
import com.genoma.plus.dao.impl.historia.ExamenFisicoDAOImpl;
import com.genoma.plus.dto.historia.DetalleExamenFisicoNDTO;
import com.genoma.plus.dto.historia.ExamenFisicoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPBuscarPatologia.class */
public class JPBuscarPatologia extends JPanel {
    private clasesHistoriaCE xclase;
    private ExamenFisicoDAO examenFisicoDAO;
    private DetalleExamenFisicoDAO detalleExamenFisicoDAO;
    private DefaultTableModel xmodelo;
    private String xNHoja;
    private Object[] xDato;
    private ButtonGroup JBG_Filtro;
    private JButton JBTGuardar;
    private JCheckBox JCH_EstadoInicial;
    private JCheckBox JCH_SinValidacionSignos;
    private JCheckBox JCH_ValorporDefecto;
    private JLabel JLBCImc;
    private JLabel JLBCObecidad;
    private JLabel JLBPBSentado;
    private JLabel JLBPSentado1;
    private JPanel JPIPresion;
    private JPanel JPI_SignosVitales;
    private JScrollPane JSP_EFEstadoGeneral;
    private JScrollPane JSP_Hallazgo;
    private JTable JTB_Hallazgo;
    private JFormattedTextField JTFFPSentadoD;
    private JFormattedTextField JTFFPSentadoS;
    public JTextFieldValidator JTFFPs2;
    public JTextFieldValidator JTFFSFc;
    public JTextFieldValidator JTFFSFr;
    public JTextFieldValidator JTFFSIMC;
    public JTextFieldValidator JTFFSPAM;
    private JSpinner JTFFSPIdeal;
    public JTextFieldValidator JTFFSPeso2;
    public JTextFieldValidator JTFFSTalla;
    public JTextFieldValidator JTFFTemperatura;
    public JTextField JTFNRegistro;
    public JTextFieldValidator JTFPAbdominal;
    private JTextPane JTP_EFEstadoGeneral;
    private JPanel jPanel2;
    private double imc = 0.0d;
    private Metodos xmetodo = new Metodos();
    private DecimalFormat formato = new DecimalFormat("0.00");

    public JPBuscarPatologia(clasesHistoriaCE xclase, String xNHoja) {
        initComponents();
        this.JTFFSIMC.setEditable(false);
        this.xclase = xclase;
        springStart();
        mCargarDatosTabla();
        this.xNHoja = xNHoja;
        if ((Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") && Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue() == 444893) || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            this.JTFFPs2.setEnabled(false);
            this.JTFFPs2.setVisible(false);
        }
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() != 1) {
            this.JTFPAbdominal.setVisible(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v106, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JSP_EFEstadoGeneral = new JScrollPane();
        this.JTP_EFEstadoGeneral = new JTextPane();
        this.JPI_SignosVitales = new JPanel();
        this.JPIPresion = new JPanel();
        this.JTFFPSentadoS = new JFormattedTextField();
        this.JTFFPSentadoD = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JLBPSentado1 = new JLabel();
        this.JTFFSFc = new JTextFieldValidator();
        this.JTFFSFr = new JTextFieldValidator();
        this.JTFFTemperatura = new JTextFieldValidator();
        this.JTFFPs2 = new JTextFieldValidator();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFPAbdominal = new JTextFieldValidator();
        this.JTFFSPIdeal = new JSpinner();
        this.JTFFSPAM = new JTextFieldValidator();
        this.JTFFSPeso2 = new JTextFieldValidator();
        this.JTFFSIMC = new JTextFieldValidator();
        this.JSP_Hallazgo = new JScrollPane();
        this.JTB_Hallazgo = new JTable();
        this.JCH_EstadoInicial = new JCheckBox();
        this.JCH_ValorporDefecto = new JCheckBox();
        this.JTFNRegistro = new JTextField();
        this.JBTGuardar = new JButton();
        this.JCH_SinValidacionSignos = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.JLBCImc = new JLabel();
        this.JLBCObecidad = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "EXAMEN FISICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jp_examenfisico_nuevo1");
        this.JSP_EFEstadoGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado General", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_EFEstadoGeneral.setFont(new Font("Arial", 1, 12));
        this.JTP_EFEstadoGeneral.setFont(new Font("Arial", 1, 12));
        this.JTP_EFEstadoGeneral.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.1
            public void keyPressed(KeyEvent evt) {
                JPBuscarPatologia.this.JTP_EFEstadoGeneralKeyPressed(evt);
            }
        });
        this.JSP_EFEstadoGeneral.setViewportView(this.JTP_EFEstadoGeneral);
        this.JPI_SignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "SIGNOS VITALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESIÓN", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFPSentadoS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoS.setHorizontalAlignment(4);
        this.JTFFPSentadoS.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoS.setName("fechanaciemiento");
        this.JTFFPSentadoS.setValue(new Integer(0));
        this.JTFFPSentadoS.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.2
            public void focusLost(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFPSentadoSFocusLost(evt);
            }
        });
        this.JTFFPSentadoS.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.3
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JTFFPSentadoSActionPerformed(evt);
            }
        });
        this.JTFFPSentadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoD.setHorizontalAlignment(4);
        this.JTFFPSentadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoD.setName("fechanaciemiento");
        this.JTFFPSentadoD.setValue(new Integer(0));
        this.JTFFPSentadoD.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.4
            public void focusLost(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFPSentadoDFocusLost(evt);
            }
        });
        this.JTFFPSentadoD.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.5
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JTFFPSentadoDActionPerformed(evt);
            }
        });
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JLBPSentado1.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado1.setForeground(Color.blue);
        this.JLBPSentado1.setHorizontalAlignment(0);
        this.JLBPSentado1.setText("Sistólica  /  Diastólica");
        GroupLayout JPIPresionLayout = new GroupLayout(this.JPIPresion);
        this.JPIPresion.setLayout(JPIPresionLayout);
        JPIPresionLayout.setHorizontalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addComponent(this.JTFFPSentadoS, -2, 45, -2).addGap(5, 5, 5).addComponent(this.JLBPBSentado).addGap(5, 5, 5).addComponent(this.JTFFPSentadoD, -2, 45, -2)).addComponent(this.JLBPSentado1, -2, 130, -2))));
        JPIPresionLayout.setVerticalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPSentadoS, -2, 25, -2).addComponent(this.JLBPBSentado, -2, 23, -2).addComponent(this.JTFFPSentadoD, -2, 25, -2)).addGap(5, 5, 5).addComponent(this.JLBPSentado1)));
        this.JTFFSFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fc (p/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFc.setHorizontalAlignment(0);
        this.JTFFSFc.setText("0");
        this.JTFFSFc.setToolTipText("Frecuencia Cardiáca");
        this.JTFFSFc.setExprecionRegular("^[0-9]*$");
        this.JTFFSFc.setFocusAccelerator('C');
        this.JTFFSFc.setFont(new Font("Arial", 1, 12));
        this.JTFFSFc.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.6
            public void focusGained(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFSFcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFSFcFocusLost(evt);
            }
        });
        this.JTFFSFc.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.7
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JTFFSFcActionPerformed(evt);
            }
        });
        this.JTFFSFc.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.8
            public void keyPressed(KeyEvent evt) {
                JPBuscarPatologia.this.JTFFSFcKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPBuscarPatologia.this.JTFFSFcKeyTyped(evt);
            }
        });
        this.JTFFSFr.setBorder(BorderFactory.createTitledBorder((Border) null, "Fr (r/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFr.setHorizontalAlignment(0);
        this.JTFFSFr.setText("0");
        this.JTFFSFr.setToolTipText("Frecuencia Respiratoria");
        this.JTFFSFr.setExprecionRegular("^[0-9]*$");
        this.JTFFSFr.setFocusAccelerator('C');
        this.JTFFSFr.setFont(new Font("Arial", 1, 12));
        this.JTFFSFr.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.9
            public void focusGained(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFSFrFocusGained(evt);
            }
        });
        this.JTFFSFr.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.10
            public void keyTyped(KeyEvent evt) {
                JPBuscarPatologia.this.JTFFSFrKeyTyped(evt);
            }
        });
        this.JTFFTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "T (ªC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTemperatura.setHorizontalAlignment(0);
        this.JTFFTemperatura.setText("0");
        this.JTFFTemperatura.setToolTipText("Temperatura");
        this.JTFFTemperatura.setExprecionRegular("^[0-9.]*$");
        this.JTFFTemperatura.setFocusAccelerator('C');
        this.JTFFTemperatura.setFont(new Font("Arial", 1, 12));
        this.JTFFTemperatura.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.11
            public void focusGained(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFTemperaturaFocusGained(evt);
            }
        });
        this.JTFFTemperatura.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.12
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JTFFTemperaturaActionPerformed(evt);
            }
        });
        this.JTFFTemperatura.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.13
            public void keyTyped(KeyEvent evt) {
                JPBuscarPatologia.this.JTFFTemperaturaKeyTyped(evt);
            }
        });
        this.JTFFPs2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ps2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPs2.setHorizontalAlignment(0);
        this.JTFFPs2.setText("0");
        this.JTFFPs2.setToolTipText("Ps2");
        this.JTFFPs2.setExprecionRegular("^[0-9]*$");
        this.JTFFPs2.setFocusAccelerator('C');
        this.JTFFPs2.setFont(new Font("Arial", 1, 12));
        this.JTFFPs2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.14
            public void focusGained(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFPs2FocusGained(evt);
            }
        });
        this.JTFFPs2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.15
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JTFFPs2ActionPerformed(evt);
            }
        });
        this.JTFFPs2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.16
            public void keyTyped(KeyEvent evt) {
                JPBuscarPatologia.this.JTFFPs2KeyTyped(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.17
            public void focusGained(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFSTallaFocusGained(evt);
            }
        });
        this.JTFFSTalla.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.18
            public void keyTyped(KeyEvent evt) {
                JPBuscarPatologia.this.JTFFSTallaKeyTyped(evt);
            }
        });
        this.JTFPAbdominal.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Abdominal (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFPAbdominal.setHorizontalAlignment(0);
        this.JTFPAbdominal.setText("0");
        this.JTFPAbdominal.setToolTipText("Perimetro Abdominal");
        this.JTFPAbdominal.setExprecionRegular("^[0.0-9]*$");
        this.JTFPAbdominal.setFocusAccelerator('C');
        this.JTFPAbdominal.setFont(new Font("Arial", 1, 12));
        this.JTFPAbdominal.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.19
            public void focusGained(FocusEvent evt) {
                JPBuscarPatologia.this.JTFPAbdominalFocusGained(evt);
            }
        });
        this.JTFPAbdominal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.20
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JTFPAbdominalActionPerformed(evt);
            }
        });
        this.JTFPAbdominal.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.21
            public void keyTyped(KeyEvent evt) {
                JPBuscarPatologia.this.JTFPAbdominalKeyTyped(evt);
            }
        });
        this.JTFFSPIdeal.setFont(new Font("Arial", 1, 12));
        this.JTFFSPIdeal.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(0.1f)));
        this.JTFFSPIdeal.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso Ideal", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JTFFSPAM.setEditable(false);
        this.JTFFSPAM.setBorder(BorderFactory.createTitledBorder((Border) null, "PAM", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPAM.setHorizontalAlignment(0);
        this.JTFFSPAM.setText("0");
        this.JTFFSPAM.setToolTipText("Presion Arterial Media");
        this.JTFFSPAM.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPAM.setFocusAccelerator('C');
        this.JTFFSPAM.setFont(new Font("Arial", 1, 12));
        this.JTFFSPAM.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.22
            public void focusGained(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFSPAMFocusGained(evt);
            }
        });
        this.JTFFSPeso2.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso2.setHorizontalAlignment(0);
        this.JTFFSPeso2.setText("0");
        this.JTFFSPeso2.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso2.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso2.setFocusAccelerator('C');
        this.JTFFSPeso2.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.23
            public void focusLost(FocusEvent evt) {
                JPBuscarPatologia.this.JTFFSPeso2FocusLost(evt);
            }
        });
        this.JTFFSPeso2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.24
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JTFFSPeso2ActionPerformed(evt);
            }
        });
        this.JTFFSIMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSIMC.setHorizontalAlignment(0);
        this.JTFFSIMC.setText("0");
        this.JTFFSIMC.setToolTipText("Indice de Masa Corporal");
        this.JTFFSIMC.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFSIMC.setExprecionRegular("^[0-9]{1,5}(\\,[0-9]{0,2})?$");
        this.JTFFSIMC.setFocusable(false);
        this.JTFFSIMC.setFont(new Font("Arial", 1, 24));
        GroupLayout JPI_SignosVitalesLayout = new GroupLayout(this.JPI_SignosVitales);
        this.JPI_SignosVitales.setLayout(JPI_SignosVitalesLayout);
        JPI_SignosVitalesLayout.setHorizontalGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIPresion, -2, -1, -2).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JTFFSFc, -2, 80, -2)).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSPAM, -2, 90, -2))).addGap(10, 10, 10).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addComponent(this.JTFPAbdominal, -2, 123, -2).addGap(18, 18, 18).addComponent(this.JTFFSPIdeal, -2, 97, -2).addContainerGap(336, 32767)).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addComponent(this.JTFFSFr, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTemperatura, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFPs2, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSTalla, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFSPeso2, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSIMC, -2, 82, -2).addGap(14, 14, 14)))));
        JPI_SignosVitalesLayout.setVerticalGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTemperatura, -2, 50, -2).addComponent(this.JTFFSFr, -2, 50, -2).addComponent(this.JTFFPs2, -2, 50, -2)).addComponent(this.JTFFSFc, -2, 50, -2).addComponent(this.JTFFSIMC, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPAbdominal, -2, 50, -2).addComponent(this.JTFFSPIdeal, -2, 50, -2).addComponent(this.JTFFSPAM, -2, 50, -2)).addGap(0, 12, 32767)).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso2, -2, 50, -2)).addComponent(this.JPIPresion, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSP_Hallazgo.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Hallazgo.setFont(new Font("Arial", 1, 12));
        this.JTB_Hallazgo.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Hallazgo.setRowHeight(50);
        this.JTB_Hallazgo.setSelectionMode(0);
        this.JSP_Hallazgo.setViewportView(this.JTB_Hallazgo);
        this.JBG_Filtro.add(this.JCH_EstadoInicial);
        this.JCH_EstadoInicial.setFont(new Font("Arial", 1, 12));
        this.JCH_EstadoInicial.setForeground(Color.red);
        this.JCH_EstadoInicial.setSelected(true);
        this.JCH_EstadoInicial.setText("Estado Inicial");
        this.JCH_EstadoInicial.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.25
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JCH_EstadoInicialActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JCH_ValorporDefecto);
        this.JCH_ValorporDefecto.setFont(new Font("Arial", 1, 12));
        this.JCH_ValorporDefecto.setForeground(Color.red);
        this.JCH_ValorporDefecto.setText("No Patologico");
        this.JCH_ValorporDefecto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.26
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JCH_ValorporDefectoActionPerformed(evt);
            }
        });
        this.JTFNRegistro.setFont(new Font("Arial", 1, 24));
        this.JTFNRegistro.setHorizontalAlignment(0);
        this.JTFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.27
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JCH_SinValidacionSignos.setFont(new Font("Arial", 1, 12));
        this.JCH_SinValidacionSignos.setForeground(Color.red);
        this.JCH_SinValidacionSignos.setText("Sin Validación de Signos Vitales");
        this.JCH_SinValidacionSignos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.28
            public void actionPerformed(ActionEvent evt) {
                JPBuscarPatologia.this.JCH_SinValidacionSignosActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación antropométrica", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JLBCImc.setFont(new Font("Arial", 1, 14));
        this.JLBCImc.setForeground(Color.red);
        this.JLBCImc.setHorizontalAlignment(0);
        this.JLBCImc.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Riesgo (IMC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBCObecidad.setFont(new Font("Arial", 1, 14));
        this.JLBCObecidad.setForeground(Color.red);
        this.JLBCObecidad.setHorizontalAlignment(0);
        this.JLBCObecidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Obesidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBCImc, -2, 278, -2).addGap(36, 36, 36).addComponent(this.JLBCObecidad, -2, 240, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBCObecidad, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JLBCImc, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(5, 5, 5)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBTGuardar, -2, 621, -2).addGap(18, 18, 18).addComponent(this.JTFNRegistro, -2, 195, -2)).addComponent(this.JSP_EFEstadoGeneral, -2, 834, -2).addComponent(this.JPI_SignosVitales, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JCH_EstadoInicial).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_ValorporDefecto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_SinValidacionSignos)).addComponent(this.JSP_Hallazgo, -2, 834, -2)).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGap(276, 276, 276)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSP_EFEstadoGeneral, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_SignosVitales, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_ValorporDefecto).addComponent(this.JCH_EstadoInicial).addComponent(this.JCH_SinValidacionSignos)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Hallazgo, -2, 177, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNRegistro, -2, 50, -2).addComponent(this.JBTGuardar, -2, 50, -2)).addGap(22, 22, 22)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_EFEstadoGeneralKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 9) {
            this.JTP_EFEstadoGeneral.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoS.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPSentadoS.getText()).intValue(), 0);
            calcularPAM(this.JTFFPSentadoS.getText(), this.JTFFPSentadoD.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoD.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPSentadoD.getText()).intValue(), 1);
            calcularPAM(this.JTFFPSentadoS.getText(), this.JTFFPSentadoD.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoD.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusGained(FocusEvent evt) {
        this.JTFFSFc.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusLost(FocusEvent evt) {
        this.JTFFSFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcActionPerformed(ActionEvent evt) {
        this.JTFFSFr.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFc.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFc.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrFocusGained(FocusEvent evt) {
        this.JTFFSFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFr.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFr.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaFocusGained(FocusEvent evt) {
        this.JTFFTemperatura.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaActionPerformed(ActionEvent evt) {
        this.JTFFPs2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFTemperatura.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFTemperatura.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2FocusGained(FocusEvent evt) {
        this.JTFFPs2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2ActionPerformed(ActionEvent evt) {
        this.JTFFSTalla.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2KeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFPs2.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFPs2.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ValorporDefectoActionPerformed(ActionEvent evt) {
        if (this.JCH_ValorporDefecto.isSelected()) {
            for (int i = 0; i < this.JTB_Hallazgo.getRowCount(); i++) {
                if (this.xmodelo.getValueAt(i, 2).toString().equals("")) {
                    this.xmodelo.setValueAt(this.xmodelo.getValueAt(i, 4).toString(), i, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_EstadoInicialActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTB_Hallazgo.getRowCount(); i++) {
            this.xmodelo.setValueAt("", i, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SinValidacionSignosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPAbdominalFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPAbdominalKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPAbdominalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPAMFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso2FocusLost(FocusEvent evt) {
        IMC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso2ActionPerformed(ActionEvent evt) {
        this.JTFFSPeso2.transferFocus();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.examenFisicoDAO = (ExamenFisicoDAOImpl) classPathXmlApplicationContext.getBean("examenFisicoDAOImpl");
        this.detalleExamenFisicoDAO = (DetalleExamenFisicoDAOImpl) classPathXmlApplicationContext.getBean("detalleExamenFisicoDAOImpl");
    }

    private void mValidarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                JOptionPane.showInternalMessageDialog(this, "Presión Sistólica Baja", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    JOptionPane.showInternalMessageDialog(this, "Presión Sistólica Alta", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            JOptionPane.showInternalMessageDialog(this, "Presión Diastólica Baja", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        } else if (valor > 0 && valor > 90) {
            JOptionPane.showInternalMessageDialog(this, "Presión Diastólica Alta", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Sistema", "Descripcion", "IdDetalle", "VDefecto"}) { // from class: com.genoma.plus.controller.historia.JPBuscarPatologia.29
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Hallazgo.setModel(this.xmodelo);
        this.JTB_Hallazgo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_Hallazgo.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTB_Hallazgo.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTB_Hallazgo.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mCargarTriage() {
        List<Object[]> listTriage = this.examenFisicoDAO.listInformacionTriage(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()));
        if (!listTriage.isEmpty()) {
            this.JTFFPSentadoD.setValue(listTriage.get(0)[1]);
            this.JTFFPSentadoS.setValue(listTriage.get(0)[2]);
            this.JTFFSFc.setText("" + listTriage.get(0)[7]);
            this.JTFFSFr.setText("" + listTriage.get(0)[8]);
            this.JTFFSTalla.setText("" + listTriage.get(0)[9]);
            this.JTFFSPeso2.setText("" + listTriage.get(0)[10]);
            this.JTFFTemperatura.setText("" + listTriage.get(0)[13]);
            this.JTFFPs2.setText("" + listTriage.get(0)[12]);
            this.JTFFSIMC.setText("" + listTriage.get(0)[14]);
        }
    }

    private void mCargarDatosTabla() {
        List<ExamenFisicoDTO> listExamen = this.examenFisicoDAO.listExamenFisico(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        if (!listExamen.isEmpty()) {
            this.JTFNRegistro.setText("" + listExamen.get(0).getId());
            this.JTP_EFEstadoGeneral.setText(listExamen.get(0).getEstadoGeneral());
            this.JTFFPSentadoD.setValue(listExamen.get(0).getTArtSentadoD());
            this.JTFFPSentadoS.setValue(listExamen.get(0).getTArtSentadoS());
            this.JTFFPs2.setText(String.valueOf(listExamen.get(0).getPresionOxigeno()));
            this.JTFFSFc.setText(String.valueOf(listExamen.get(0).getFrecuenciaCardiaca()));
            this.JTFFSFr.setText(String.valueOf(listExamen.get(0).getFrecuenciaRespiratoria()));
            this.JTFFSPeso2.setText(String.valueOf(listExamen.get(0).getPeso()));
            this.JTFFSTalla.setText(String.valueOf(listExamen.get(0).getTalla()));
            this.JTFFTemperatura.setText(String.valueOf(listExamen.get(0).getTemperatura()));
            this.JTFFSIMC.setText(this.formato.format(listExamen.get(0).getTAMedia()).toString());
            if (listExamen.get(0).getTAMedia().doubleValue() < 18.5d) {
                this.JLBCImc.setText("Delgadez");
            } else if (listExamen.get(0).getTAMedia().doubleValue() >= 18.5d && listExamen.get(0).getTAMedia().doubleValue() < 25.0d) {
                this.JLBCImc.setText("Normal");
            } else if (listExamen.get(0).getTAMedia().doubleValue() >= 25.0d && listExamen.get(0).getTAMedia().doubleValue() < 30.0d) {
                this.JLBCImc.setText("Sobrepeso");
            } else if (listExamen.get(0).getTAMedia().doubleValue() >= 30.0d) {
                this.JLBCImc.setText("Obesidad");
                if (listExamen.get(0).getTAMedia().doubleValue() >= 30.0d && listExamen.get(0).getTAMedia().doubleValue() <= 34.9d) {
                    this.JLBCObecidad.setText("Obesidad grado I");
                } else if (listExamen.get(0).getTAMedia().doubleValue() >= 35.0d && listExamen.get(0).getTAMedia().doubleValue() <= 39.9d) {
                    this.JLBCObecidad.setText("Obesidad grado II");
                } else if (listExamen.get(0).getTAMedia().doubleValue() >= 40.0d) {
                    this.JLBCObecidad.setText("Obesidad grado III");
                } else if (listExamen.get(0).getTAMedia().doubleValue() <= 30.0d) {
                    this.JLBCObecidad.setText("Normal");
                }
            }
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 1) {
                this.JTFPAbdominal.setText(String.valueOf(listExamen.get(0).getPAbdominal()));
            }
        }
        List<Object[]> list = this.examenFisicoDAO.listConfDetalleExamenFisico(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipohc()), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        mModelo();
        this.xmetodo.mEstablecerTextEditor(this.JTB_Hallazgo, 1);
        this.xmetodo.mEstablecerTextEditor(this.JTB_Hallazgo, 2);
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(list.get(x)[0].toString(), x, 0);
                this.xmodelo.setValueAt(list.get(x)[1].toString(), x, 1);
                this.xmodelo.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list.get(x)[3], x, 3);
                this.xmodelo.setValueAt(list.get(x)[4], x, 4);
            }
        }
    }

    public void mGrabarM() {
        Long xIdExamen;
        ExamenFisicoDTO e = new ExamenFisicoDTO();
        Double pabdominal = new Double(0.0d);
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() == 1) {
            pabdominal = Double.valueOf(this.JTFPAbdominal.getText());
        }
        e.setIdAtencion(Long.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
        e.setEstadoGeneral(this.JTP_EFEstadoGeneral.getText());
        e.setTArtSentadoD(Long.valueOf(this.JTFFPSentadoD.getText()));
        e.setTArtSentadoS(Long.valueOf(this.JTFFPSentadoS.getText()));
        e.setPeso(Double.valueOf(this.JTFFSPeso2.getText()));
        e.setTalla(Double.valueOf(this.JTFFSTalla.getText()));
        e.setPresionOxigeno(Long.valueOf(this.JTFFPs2.getText()));
        e.setFrecuenciaCardiaca(Long.valueOf(this.JTFFSFc.getText()));
        e.setFrecuenciaRespiratoria(Long.valueOf(this.JTFFSFr.getText()));
        e.setTemperatura(Double.valueOf(this.JTFFTemperatura.getText()));
        e.setTAMedia(Double.valueOf(this.imc));
        e.setPAbdominal(pabdominal);
        e.setImc(new Double(0.0d));
        if (this.JTFNRegistro.getText().isEmpty()) {
            xIdExamen = this.examenFisicoDAO.mCrear(e);
            this.JTFNRegistro.setText("" + xIdExamen);
        } else {
            xIdExamen = Long.valueOf(this.JTFNRegistro.getText());
            e.setId(xIdExamen);
            this.examenFisicoDAO.mActualizar(e);
        }
        for (int i = 0; i < this.JTB_Hallazgo.getRowCount(); i++) {
            DetalleExamenFisicoNDTO d = new DetalleExamenFisicoNDTO();
            d.setIdExamenFisico(xIdExamen);
            d.setIdGrupoExamen(Long.valueOf(this.JTB_Hallazgo.getValueAt(i, 0).toString()));
            d.setObservacion(this.JTB_Hallazgo.getValueAt(i, 2).toString());
            d.setEstado(true);
            d.setFecha(this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()));
            d.setId(Long.valueOf(this.JTB_Hallazgo.getValueAt(i, 3).toString()));
            System.out.println("" + this.JTB_Hallazgo.getValueAt(i, 3).toString());
            if (Long.valueOf(this.JTB_Hallazgo.getValueAt(i, 3).toString()).longValue() == 0) {
                this.detalleExamenFisicoDAO.mCrear(d);
            } else {
                this.detalleExamenFisicoDAO.mActualizar(d);
            }
        }
        this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
        mCargarDatosTabla();
    }

    private Boolean validarPresion() {
        System.out.println("edad : " + clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
        boolean estado = false;
        Integer edad = this.examenFisicoDAO.consultarEdadUsuario(clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento());
        if (edad.intValue() < 16) {
            estado = true;
        } else if (Double.parseDouble(this.JTFFPSentadoS.getValue().toString()) <= 0.0d || this.JTFFPSentadoS.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "La Presión Sistólica (Sentado) no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFPSentadoS.requestFocus();
        } else if (Double.parseDouble(this.JTFFPSentadoD.getValue().toString()) > 0.0d && !this.JTFFPSentadoS.getText().isEmpty()) {
            estado = true;
        } else {
            JOptionPane.showInternalMessageDialog(this, "La Presión Diastólica (Sentado) no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFPSentadoD.requestFocus();
        }
        return Boolean.valueOf(estado);
    }

    private Boolean validarDatosObligatorios() {
        Boolean estado = false;
        if (!this.JTFFSFc.getText().isEmpty() && Double.parseDouble(this.JTFFSFc.getText().toString()) > 0.0d) {
            if (!this.JTFFSFr.getText().isEmpty() && Double.parseDouble(this.JTFFSFr.getText().toString()) > 0.0d) {
                if (!this.JTFFTemperatura.getText().isEmpty() && Double.parseDouble(this.JTFFTemperatura.getText().toString()) >= 0.0d) {
                    if (validarPresion().booleanValue()) {
                        if (!this.JTP_EFEstadoGeneral.getText().isEmpty()) {
                            if (!this.xmetodo.mVerificarDatosLLeno(this.JTB_Hallazgo, 1)) {
                                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion().intValue() != 1 || Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S") || (!this.JTFPAbdominal.getText().isEmpty() && Double.parseDouble(this.JTFPAbdominal.getText()) > 0.0d)) {
                                    estado = true;
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Llene el perimetro Abdominal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFPAbdominal.requestFocus();
                                }
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Los hallagazgo no deben estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "El estado general no debe estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTP_EFEstadoGeneral.requestFocus();
                        }
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "La Temperatura no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFTemperatura.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "La Fr no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSFr.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "La Fc no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFc.requestFocus();
        }
        return estado;
    }

    public void mGrabar() {
        if (this.JTB_Hallazgo.isEditing()) {
            this.JTB_Hallazgo.getCellEditor().stopCellEditing();
        }
        if (!this.JCH_SinValidacionSignos.isSelected()) {
            if (validarDatosObligatorios().booleanValue()) {
                mGrabarM();
                return;
            }
            return;
        }
        mGrabarM();
    }

    private double getPeso() {
        double valor = 0.0d;
        if (this.JTFFSPeso2.getText() != null && !this.JTFFSPeso2.getText().equals("") && Double.parseDouble(this.JTFFSPeso2.getText()) > 0.0d) {
            valor = Double.parseDouble(this.JTFFSPeso2.getText());
            System.out.println("el valor" + valor);
        }
        return valor;
    }

    private double getTalla() {
        double valor = 0.0d;
        if (this.JTFFSTalla.getText() != null && !this.JTFFSTalla.getText().equals("") && !this.JTFFSTalla.getText().equals("0") && Double.valueOf(this.JTFFSTalla.getText()).doubleValue() > 0.0d) {
            valor = Double.valueOf(this.JTFFSTalla.getText()).doubleValue();
        }
        return valor;
    }

    private void IMC() {
        if (this.JTFFSTalla.getText() != null && this.JTFFSPeso2.getText() != null && !this.JTFFSPeso2.getText().equals("0") && !this.JTFFSTalla.getText().equals("0") && !this.JTFFSTalla.getText().equals("0.0")) {
            DecimalFormat formato = new DecimalFormat("0.00");
            this.imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            System.out.println("el imc" + this.imc);
            this.JTFFSIMC.setText(String.valueOf(formato.format(this.imc)));
            this.JTFFSPIdeal.setValue(Double.valueOf((getPeso() * 24.9d) / this.imc));
            System.out.println("el imc2 " + this.imc);
            this.JLBCObecidad.setText("");
            if (this.imc < 18.5d) {
                this.JLBCImc.setText("Delgadez");
                return;
            }
            if (this.imc >= 18.5d && this.imc < 25.0d) {
                this.JLBCImc.setText("Normal");
                return;
            }
            if (this.imc >= 25.0d && this.imc < 30.0d) {
                this.JLBCImc.setText("Sobrepeso");
                return;
            }
            if (this.imc >= 30.0d) {
                this.JLBCImc.setText("Obesidad");
                if (this.imc >= 30.0d && this.imc <= 34.9d) {
                    this.JLBCObecidad.setText("Obesidad grado I");
                    return;
                }
                if (this.imc >= 35.0d && this.imc <= 39.9d) {
                    this.JLBCObecidad.setText("Obesidad grado II");
                    return;
                } else if (this.imc >= 40.0d) {
                    this.JLBCObecidad.setText("Obesidad grado III");
                    return;
                } else {
                    if (this.imc <= 30.0d) {
                        this.JLBCObecidad.setText("Normal");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.JTFFSIMC.setText("0");
        this.JLBCObecidad.setText("");
    }

    private void calcularPAM(String pad, String pas) {
        if (!pad.isEmpty() && isNumeric(pad) && !pas.isEmpty() && isNumeric(pas)) {
            double pam = ((2 * Integer.valueOf(pad).intValue()) + Integer.valueOf(pas).intValue()) / 3;
            this.JTFFSPAM.setText(pam + "");
        } else {
            this.JTFFSPAM.setText("0");
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Esta Orden No Es Numerica");
            return false;
        }
    }
}
