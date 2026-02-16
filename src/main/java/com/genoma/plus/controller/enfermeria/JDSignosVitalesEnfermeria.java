package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.enfermeria.dto.RegistroSignosVitalesDto;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JDSignosVitalesEnfermeria.class */
public class JDSignosVitalesEnfermeria extends JDialog {
    private Long idAtencion;
    private Metodos xmetodo;
    private JLabel JLAtencion;
    private JLabel JLBPBSentado;
    private JLabel JLBPSentado1;
    private JLabel JLIdRegistro;
    private JPanel JPIPresion;
    private JPanel JPI_SignosVitales;
    private JScrollPane JSP_EFEstadoGeneral;
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
    public JTextFieldValidator JTFPAbdominal;
    private JTextPane JTP_EFEstadoGeneral;
    private JButton jButton1;
    private JPanel jPanel1;

    public JDSignosVitalesEnfermeria(Frame parent, boolean modal, Long idAtencion) {
        super(parent, modal);
        this.xmetodo = new Metodos();
        initComponents();
        this.idAtencion = idAtencion;
        this.JLIdRegistro.setText(idAtencion.toString());
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
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
        this.JLIdRegistro = new JLabel();
        this.JLAtencion = new JLabel();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("REGISTRO SIGNOS VITALES");
        setResizable(false);
        this.JSP_EFEstadoGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado General", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_EFEstadoGeneral.setFont(new Font("Arial", 1, 12));
        this.JTP_EFEstadoGeneral.setFont(new Font("Arial", 1, 12));
        this.JTP_EFEstadoGeneral.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.1
            public void keyPressed(KeyEvent evt) {
                JDSignosVitalesEnfermeria.this.JTP_EFEstadoGeneralKeyPressed(evt);
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
        this.JTFFPSentadoS.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.2
            public void focusLost(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFPSentadoSFocusLost(evt);
            }
        });
        this.JTFFPSentadoS.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.3
            public void actionPerformed(ActionEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFPSentadoSActionPerformed(evt);
            }
        });
        this.JTFFPSentadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoD.setHorizontalAlignment(4);
        this.JTFFPSentadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoD.setName("fechanaciemiento");
        this.JTFFPSentadoD.setValue(new Integer(0));
        this.JTFFPSentadoD.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.4
            public void focusLost(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFPSentadoDFocusLost(evt);
            }
        });
        this.JTFFPSentadoD.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.5
            public void actionPerformed(ActionEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFPSentadoDActionPerformed(evt);
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
        this.JTFFSFc.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.6
            public void focusGained(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSFcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSFcFocusLost(evt);
            }
        });
        this.JTFFSFc.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.7
            public void actionPerformed(ActionEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSFcActionPerformed(evt);
            }
        });
        this.JTFFSFc.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.8
            public void keyPressed(KeyEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSFcKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSFcKeyTyped(evt);
            }
        });
        this.JTFFSFr.setBorder(BorderFactory.createTitledBorder((Border) null, "Fr (r/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFr.setHorizontalAlignment(0);
        this.JTFFSFr.setText("0");
        this.JTFFSFr.setToolTipText("Frecuencia Respiratoria");
        this.JTFFSFr.setExprecionRegular("^[0-9]*$");
        this.JTFFSFr.setFocusAccelerator('C');
        this.JTFFSFr.setFont(new Font("Arial", 1, 12));
        this.JTFFSFr.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.9
            public void focusGained(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSFrFocusGained(evt);
            }
        });
        this.JTFFSFr.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.10
            public void keyTyped(KeyEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSFrKeyTyped(evt);
            }
        });
        this.JTFFTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "T (ªC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTemperatura.setHorizontalAlignment(0);
        this.JTFFTemperatura.setText("0");
        this.JTFFTemperatura.setToolTipText("Temperatura");
        this.JTFFTemperatura.setExprecionRegular("^[0-9.]*$");
        this.JTFFTemperatura.setFocusAccelerator('C');
        this.JTFFTemperatura.setFont(new Font("Arial", 1, 12));
        this.JTFFTemperatura.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.11
            public void focusGained(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFTemperaturaFocusGained(evt);
            }
        });
        this.JTFFTemperatura.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.12
            public void actionPerformed(ActionEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFTemperaturaActionPerformed(evt);
            }
        });
        this.JTFFTemperatura.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.13
            public void keyTyped(KeyEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFTemperaturaKeyTyped(evt);
            }
        });
        this.JTFFPs2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ps2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPs2.setHorizontalAlignment(0);
        this.JTFFPs2.setText("0");
        this.JTFFPs2.setToolTipText("Ps2");
        this.JTFFPs2.setExprecionRegular("^[0-9]*$");
        this.JTFFPs2.setFocusAccelerator('C');
        this.JTFFPs2.setFont(new Font("Arial", 1, 12));
        this.JTFFPs2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.14
            public void focusGained(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFPs2FocusGained(evt);
            }
        });
        this.JTFFPs2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.15
            public void actionPerformed(ActionEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFPs2ActionPerformed(evt);
            }
        });
        this.JTFFPs2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.16
            public void keyTyped(KeyEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFPs2KeyTyped(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.17
            public void focusGained(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSTallaFocusGained(evt);
            }
        });
        this.JTFFSTalla.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.18
            public void keyTyped(KeyEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSTallaKeyTyped(evt);
            }
        });
        this.JTFPAbdominal.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Abdominal (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFPAbdominal.setHorizontalAlignment(0);
        this.JTFPAbdominal.setText("0");
        this.JTFPAbdominal.setToolTipText("Perimetro Abdominal");
        this.JTFPAbdominal.setExprecionRegular("^[0.0-9]*$");
        this.JTFPAbdominal.setFocusAccelerator('C');
        this.JTFPAbdominal.setFont(new Font("Arial", 1, 12));
        this.JTFPAbdominal.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.19
            public void focusGained(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFPAbdominalFocusGained(evt);
            }
        });
        this.JTFPAbdominal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.20
            public void actionPerformed(ActionEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFPAbdominalActionPerformed(evt);
            }
        });
        this.JTFPAbdominal.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.21
            public void keyTyped(KeyEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFPAbdominalKeyTyped(evt);
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
        this.JTFFSPAM.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.22
            public void focusGained(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSPAMFocusGained(evt);
            }
        });
        this.JTFFSPeso2.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso2.setHorizontalAlignment(0);
        this.JTFFSPeso2.setText("0");
        this.JTFFSPeso2.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso2.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso2.setFocusAccelerator('C');
        this.JTFFSPeso2.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.23
            public void focusLost(FocusEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSPeso2FocusLost(evt);
            }
        });
        this.JTFFSPeso2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.24
            public void actionPerformed(ActionEvent evt) {
                JDSignosVitalesEnfermeria.this.JTFFSPeso2ActionPerformed(evt);
            }
        });
        this.JTFFSIMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSIMC.setHorizontalAlignment(0);
        this.JTFFSIMC.setText("0");
        this.JTFFSIMC.setToolTipText("Indice de Masa Corporal");
        this.JTFFSIMC.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFSIMC.setEnabled(false);
        this.JTFFSIMC.setExprecionRegular("^[0-9]{1,5}(\\,[0-9]{0,2})?$");
        this.JTFFSIMC.setFocusable(false);
        this.JTFFSIMC.setFont(new Font("Arial", 1, 24));
        GroupLayout JPI_SignosVitalesLayout = new GroupLayout(this.JPI_SignosVitales);
        this.JPI_SignosVitales.setLayout(JPI_SignosVitalesLayout);
        JPI_SignosVitalesLayout.setHorizontalGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIPresion, -2, -1, -2).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JTFFSFc, -2, 80, -2)).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSPAM, -2, 90, -2))).addGap(10, 10, 10).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addComponent(this.JTFPAbdominal, -2, 123, -2).addGap(18, 18, 18).addComponent(this.JTFFSPIdeal, -2, 97, -2).addContainerGap(336, 32767)).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addComponent(this.JTFFSFr, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTemperatura, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFPs2, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSTalla, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFSPeso2, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSIMC, -2, 82, -2).addGap(14, 14, 14)))));
        JPI_SignosVitalesLayout.setVerticalGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTemperatura, -2, 50, -2).addComponent(this.JTFFSFr, -2, 50, -2).addComponent(this.JTFFPs2, -2, 50, -2)).addComponent(this.JTFFSFc, -2, 50, -2).addComponent(this.JTFFSIMC, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPAbdominal, -2, 50, -2).addComponent(this.JTFFSPIdeal, -2, 50, -2).addComponent(this.JTFFSPAM, -2, 50, -2)).addGap(0, 12, 32767)).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso2, -2, 50, -2)).addComponent(this.JPIPresion, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JLIdRegistro.setFont(new Font("Arial", 1, 12));
        this.JLIdRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLAtencion.setFont(new Font("Arial", 1, 12));
        this.JLAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Atencion", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.jButton1.setText("Grabar");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JDSignosVitalesEnfermeria.25
            public void actionPerformed(ActionEvent evt) {
                JDSignosVitalesEnfermeria.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jButton1, -2, 293, -2).addGap(18, 18, 18).addComponent(this.JLIdRegistro, -2, 185, -2).addGap(18, 18, 18).addComponent(this.JLAtencion, -2, 185, -2).addContainerGap(147, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_SignosVitales, -1, -1, 32767).addComponent(this.JSP_EFEstadoGeneral, -1, 846, 32767)).addContainerGap())));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(270, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLAtencion, -2, 45, -2).addComponent(this.jButton1, -2, 59, -2).addComponent(this.JLIdRegistro, -2, 45, -2)).addGap(16, 16, 16)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSP_EFEstadoGeneral, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_SignosVitales, -2, -1, -2).addContainerGap(150, 32767))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(16, 16, 16)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addGap(5, 5, 5)));
        pack();
    }

    private void mGrabarSignosVitales() {
        try {
            RegistroSignosVitalesDto registroSignosVitalesDto = new RegistroSignosVitalesDto();
            registroSignosVitalesDto.setId(null);
            registroSignosVitalesDto.setIdAtencion(this.idAtencion);
            registroSignosVitalesDto.setIdUsuarioPrograma(0);
            registroSignosVitalesDto.setEstadoGeneral(this.JTP_EFEstadoGeneral.getText());
            registroSignosVitalesDto.setEstadoConciencia(null);
            registroSignosVitalesDto.setTensionArterialSentadoD(Short.valueOf(this.JTFFPSentadoD.getText()));
            registroSignosVitalesDto.setTensionArterialSentadoS(Short.valueOf(this.JTFFPSentadoS.getText()));
            registroSignosVitalesDto.setTensionArterialAcostadoD(Short.valueOf("0"));
            registroSignosVitalesDto.setTensionArterialAcostadoS(Short.valueOf("0"));
            registroSignosVitalesDto.setTensionArterialPieD(Short.valueOf("0"));
            registroSignosVitalesDto.setTensionArterialPieS(Short.valueOf("0"));
            registroSignosVitalesDto.setTensionArterialSentado(this.JTFFPSentadoD.getText());
            registroSignosVitalesDto.setTensionArterialAcostado(this.JTFFPSentadoS.getText());
            registroSignosVitalesDto.setTensionArterialPie("");
            registroSignosVitalesDto.setTensionArterialMedia(Double.valueOf(this.JTFFSPAM.getText()));
            registroSignosVitalesDto.setControlTA(false);
            registroSignosVitalesDto.setFecuencuaCardiaca(Short.valueOf(this.JTFFSFc.getText()));
            registroSignosVitalesDto.setFrecuenciaRespiratoria(Short.valueOf(this.JTFFSFr.getText()));
            registroSignosVitalesDto.setTalla(Float.valueOf(this.JTFFSTalla.getText()));
            registroSignosVitalesDto.setPeso(Float.valueOf(this.JTFFSPeso2.getText()));
            registroSignosVitalesDto.setImc(Float.valueOf(1.0f));
            registroSignosVitalesDto.setRiesgoImc(null);
            registroSignosVitalesDto.setRiesgoObecidad("");
            registroSignosVitalesDto.setObservacion("");
            registroSignosVitalesDto.setTemperatura(Double.valueOf(this.JTFFTemperatura.getText()));
            registroSignosVitalesDto.setPs2(Float.valueOf(this.JTFFPs2.getText()));
            registroSignosVitalesDto.setControlDm(false);
            registroSignosVitalesDto.setValorGlicemia(Float.valueOf(0.0f));
            registroSignosVitalesDto.setPerimetroCefalico(Short.valueOf("0"));
            registroSignosVitalesDto.setPerimetroAbdominal(Short.valueOf(this.JTFPAbdominal.getText()));
            registroSignosVitalesDto.setPerimetroBrazo(Short.valueOf("0"));
            registroSignosVitalesDto.setRiesgoPerimetoAbdominal(" ");
            registroSignosVitalesDto.setIdCRiesgo(Short.valueOf("1"));
            registroSignosVitalesDto.setSemanasGestacion(Double.valueOf(0.0d));
            registroSignosVitalesDto.setAlturaUterina(Double.valueOf(0.0d));
            registroSignosVitalesDto.setFrecuenciaCFh1(Short.valueOf("0"));
            registroSignosVitalesDto.setFrecuenciaCFh2(Short.valueOf("0"));
            registroSignosVitalesDto.setPresentacionFetalH1("NO APLICA");
            registroSignosVitalesDto.setPresentacionFetalH2("NO APLICA");
            registroSignosVitalesDto.setMovFetalH1("NO");
            registroSignosVitalesDto.setMovFetalH2("NO");
            registroSignosVitalesDto.setValoracionCuelloUterino("NO");
            registroSignosVitalesDto.setEdemas("NO");
            registroSignosVitalesDto.setSintomaPEclampsia("NO");
            registroSignosVitalesDto.setSaludOral("NO REALIZADO");
            registroSignosVitalesDto.setEmbarazo(false);
            registroSignosVitalesDto.setMetaHb(Double.valueOf(0.0d));
            registroSignosVitalesDto.setPesoIdeal(Double.valueOf(0.0d));
            registroSignosVitalesDto.setPeGrasa(Double.valueOf(0.0d));
            registroSignosVitalesDto.setRePGrasa("Normal");
            registroSignosVitalesDto.setEgEsfuerzo(Double.valueOf(0.0d));
            registroSignosVitalesDto.setFlexibilidad(Double.valueOf(0.0d));
            registroSignosVitalesDto.setRegistroFlexibilidad("");
            registroSignosVitalesDto.setClasificacionRiesgoDm(Short.valueOf("0"));
            registroSignosVitalesDto.setClasificacionRiesgoHta(null);
            registroSignosVitalesDto.setResultadoVMAX(Double.valueOf(0.0d));
            registroSignosVitalesDto.setVmax(Double.valueOf(0.0d));
            registroSignosVitalesDto.setClaVMAX("");
            registroSignosVitalesDto.setFrecMax(Double.valueOf(0.0d));
            registroSignosVitalesDto.setFrecMaxAlc(Double.valueOf(0.0d));
            registroSignosVitalesDto.setResultadoFrecMax("");
            registroSignosVitalesDto.setIrc(Double.valueOf(0.0d));
            registroSignosVitalesDto.setClaIRC("");
            registroSignosVitalesDto.setTensionASistolicaT(null);
            registroSignosVitalesDto.setResultadoITB(Double.valueOf(0.0d));
            registroSignosVitalesDto.setClaITB("");
            registroSignosVitalesDto.setIdRemoto(Long.MIN_VALUE);
            registroSignosVitalesDto.setAutoExamenSeno("NO");
            registroSignosVitalesDto.setPerimetroBranquial(null);
            registroSignosVitalesDto.setPerimetroPantorrilla(null);
            registroSignosVitalesDto.setFecha(this.xmetodo.getFechaActual());
            registroSignosVitalesDto.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            registroSignosVitalesDto.setSintomatologiaUrinaria(Short.valueOf("0"));
            registroSignosVitalesDto.setFlujoVaginal(Short.valueOf("0"));
            registroSignosVitalesDto.setCefaleaPersistente(Short.valueOf("0"));
            registroSignosVitalesDto.setNauseasVomito(Short.valueOf("0"));
            System.out.println(this.xmetodo.getMapper().writeValueAsString(registroSignosVitalesDto));
            try {
                RecursosMicroserviciosDomain microserviciosDomain = this.xmetodo.getParametrosEncriptados("100", "RegistroSignosVitales");
                Response responsePos = this.xmetodo.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.xmetodo.getMapper().writeValueAsString(registroSignosVitalesDto)));
                CustomPresenter presenter = (CustomPresenter) this.xmetodo.getMapper().readValue((String) responsePos.readEntity(String.class), CustomPresenter.class);
                RegistroSignosVitalesDto dto = (RegistroSignosVitalesDto) this.xmetodo.getMapper().readValue(this.xmetodo.getMapper().writeValueAsString(presenter.getData()), RegistroSignosVitalesDto.class);
                System.err.println("dtoId" + dto.getId());
                this.JLIdRegistro.setText(dto.getId().toString());
                JOptionPane.showInternalMessageDialog(this, "INGRESO REALIZADO", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                responsePos.close();
                this.xmetodo.getResteasyClient().close();
            } catch (JsonProcessingException e) {
                Logger.getLogger(JDSignosVitalesEnfermeria.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDFocusLost(FocusEvent evt) {
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
    public void JTFFSFcKeyPressed(KeyEvent evt) {
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
    public void JTFPAbdominalFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPAbdominalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPAbdominalKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPAMFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso2FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso2ActionPerformed(ActionEvent evt) {
        this.JTFFSPeso2.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        mGrabarSignosVitales();
    }
}
