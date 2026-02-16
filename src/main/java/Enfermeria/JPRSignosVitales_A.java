package Enfermeria;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPRSignosVitales_A.class */
public class JPRSignosVitales_A extends JPanel {
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JButton JBTGuardar;
    private JLabel JLBPBPresion;
    private JLabel JLBPTPresion;
    private JPanel JPIPresion;
    private JPanel JPSignosVitales;
    private JScrollPane JSPDHistorico;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    private JTable JTDHistorico;
    private JFormattedTextField JTFFPDiastolica;
    private JFormattedTextField JTFFPSistolica;
    public JTextFieldValidator JTFFPs2;
    public JTextFieldValidator JTFFSFc;
    public JTextFieldValidator JTFFSFr;
    public JTextFieldValidator JTFFSIMC;
    private JSpinner JTFFSPerimetroAbd;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    public JTextFieldValidator JTFFTemperatura;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xidatencion = "0";

    public JPRSignosVitales_A(String xnombre) {
        initComponents();
        mRealizarCasting(xnombre);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v113, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPIPresion = new JPanel();
        this.JTFFPSistolica = new JFormattedTextField();
        this.JTFFPDiastolica = new JFormattedTextField();
        this.JLBPBPresion = new JLabel();
        this.JLBPTPresion = new JLabel();
        this.JTFFSPerimetroAbd = new JSpinner();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBTGuardar = new JButton();
        this.JPSignosVitales = new JPanel();
        this.JTFFSFc = new JTextFieldValidator();
        this.JTFFSFr = new JTextFieldValidator();
        this.JTFFTemperatura = new JTextFieldValidator();
        this.JTFFPs2 = new JTextFieldValidator();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.JTFFSIMC = new JTextFieldValidator();
        this.JSPDHistorico = new JScrollPane();
        this.JTDHistorico = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "REGISTRO DE SIGNOS VITALES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESIÓN", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFPSistolica.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSistolica.setHorizontalAlignment(4);
        this.JTFFPSistolica.setFont(new Font("Arial", 1, 12));
        this.JTFFPSistolica.setName("fechanaciemiento");
        this.JTFFPSistolica.setValue(new Integer(0));
        this.JTFFPSistolica.addActionListener(new ActionListener() { // from class: Enfermeria.JPRSignosVitales_A.1
            public void actionPerformed(ActionEvent evt) {
                JPRSignosVitales_A.this.JTFFPSistolicaActionPerformed(evt);
            }
        });
        this.JTFFPSistolica.addFocusListener(new FocusAdapter() { // from class: Enfermeria.JPRSignosVitales_A.2
            public void focusLost(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFPSistolicaFocusLost(evt);
            }
        });
        this.JTFFPDiastolica.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPDiastolica.setHorizontalAlignment(4);
        this.JTFFPDiastolica.setFont(new Font("Arial", 1, 12));
        this.JTFFPDiastolica.setName("fechanaciemiento");
        this.JTFFPDiastolica.setValue(new Integer(0));
        this.JTFFPDiastolica.addActionListener(new ActionListener() { // from class: Enfermeria.JPRSignosVitales_A.3
            public void actionPerformed(ActionEvent evt) {
                JPRSignosVitales_A.this.JTFFPDiastolicaActionPerformed(evt);
            }
        });
        this.JTFFPDiastolica.addFocusListener(new FocusAdapter() { // from class: Enfermeria.JPRSignosVitales_A.4
            public void focusLost(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFPDiastolicaFocusLost(evt);
            }
        });
        this.JLBPBPresion.setFont(new Font("Arial", 1, 18));
        this.JLBPBPresion.setForeground(Color.blue);
        this.JLBPBPresion.setHorizontalAlignment(0);
        this.JLBPBPresion.setText("/");
        this.JLBPTPresion.setFont(new Font("Arial", 1, 12));
        this.JLBPTPresion.setForeground(Color.blue);
        this.JLBPTPresion.setHorizontalAlignment(0);
        this.JLBPTPresion.setText("Sistólica  /  Diastólica");
        GroupLayout JPIPresionLayout = new GroupLayout(this.JPIPresion);
        this.JPIPresion.setLayout(JPIPresionLayout);
        JPIPresionLayout.setHorizontalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addContainerGap().addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addComponent(this.JTFFPSistolica, -2, 50, -2).addGap(4, 4, 4).addComponent(this.JLBPBPresion).addGap(4, 4, 4).addComponent(this.JTFFPDiastolica, -2, 50, -2)).addComponent(this.JLBPTPresion)).addContainerGap(-1, 32767)));
        JPIPresionLayout.setVerticalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPSistolica, -2, 25, -2).addComponent(this.JLBPBPresion, -2, 23, -2).addComponent(this.JTFFPDiastolica, -2, 25, -2)).addGap(6, 6, 6).addComponent(this.JLBPTPresion)));
        this.JTFFSPerimetroAbd.setFont(new Font("Arial", 1, 12));
        this.JTFFSPerimetroAbd.setModel(new SpinnerNumberModel(0.0d, 0.0d, 250.0d, 1.0d));
        this.JTFFSPerimetroAbd.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Abdominal", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder((Border) null);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Enfermeria.JPRSignosVitales_A.5
            public void actionPerformed(ActionEvent evt) {
                JPRSignosVitales_A.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JPRSignosVitales_A.6
            public void keyPressed(KeyEvent evt) {
                JPRSignosVitales_A.this.JBTGuardarKeyPressed(evt);
            }
        });
        this.JPSignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "SIGNOS VITALES", 1, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFSFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fc (p/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFc.setHorizontalAlignment(0);
        this.JTFFSFc.setText("0");
        this.JTFFSFc.setToolTipText("Frecuencia Cardiáca");
        this.JTFFSFc.setExprecionRegular("^[0-9]*$");
        this.JTFFSFc.setFocusAccelerator('C');
        this.JTFFSFc.setFont(new Font("Arial", 1, 12));
        this.JTFFSFc.addActionListener(new ActionListener() { // from class: Enfermeria.JPRSignosVitales_A.7
            public void actionPerformed(ActionEvent evt) {
                JPRSignosVitales_A.this.JTFFSFcActionPerformed(evt);
            }
        });
        this.JTFFSFc.addFocusListener(new FocusAdapter() { // from class: Enfermeria.JPRSignosVitales_A.8
            public void focusGained(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFSFcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFSFcFocusLost(evt);
            }
        });
        this.JTFFSFr.setBorder(BorderFactory.createTitledBorder((Border) null, "Fr (r/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFr.setHorizontalAlignment(0);
        this.JTFFSFr.setText("0");
        this.JTFFSFr.setToolTipText("Frecuencia Respiratoria");
        this.JTFFSFr.setExprecionRegular("^[0-9]*$");
        this.JTFFSFr.setFocusAccelerator('C');
        this.JTFFSFr.setFont(new Font("Arial", 1, 12));
        this.JTFFSFr.addActionListener(new ActionListener() { // from class: Enfermeria.JPRSignosVitales_A.9
            public void actionPerformed(ActionEvent evt) {
                JPRSignosVitales_A.this.JTFFSFrActionPerformed(evt);
            }
        });
        this.JTFFSFr.addFocusListener(new FocusAdapter() { // from class: Enfermeria.JPRSignosVitales_A.10
            public void focusGained(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFSFrFocusGained(evt);
            }
        });
        this.JTFFTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "T (ªC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTemperatura.setHorizontalAlignment(0);
        this.JTFFTemperatura.setText("0");
        this.JTFFTemperatura.setToolTipText("Temperatura");
        this.JTFFTemperatura.setExprecionRegular("^[0-9.]*$");
        this.JTFFTemperatura.setFocusAccelerator('C');
        this.JTFFTemperatura.setFont(new Font("Arial", 1, 12));
        this.JTFFTemperatura.addActionListener(new ActionListener() { // from class: Enfermeria.JPRSignosVitales_A.11
            public void actionPerformed(ActionEvent evt) {
                JPRSignosVitales_A.this.JTFFTemperaturaActionPerformed(evt);
            }
        });
        this.JTFFTemperatura.addFocusListener(new FocusAdapter() { // from class: Enfermeria.JPRSignosVitales_A.12
            public void focusGained(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFTemperaturaFocusGained(evt);
            }
        });
        this.JTFFPs2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ps2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPs2.setHorizontalAlignment(0);
        this.JTFFPs2.setText("0");
        this.JTFFPs2.setToolTipText("Ps2");
        this.JTFFPs2.setExprecionRegular("^[0-9]*$");
        this.JTFFPs2.setFocusAccelerator('C');
        this.JTFFPs2.setFont(new Font("Arial", 1, 12));
        this.JTFFPs2.addActionListener(new ActionListener() { // from class: Enfermeria.JPRSignosVitales_A.13
            public void actionPerformed(ActionEvent evt) {
                JPRSignosVitales_A.this.JTFFPs2ActionPerformed(evt);
            }
        });
        this.JTFFPs2.addFocusListener(new FocusAdapter() { // from class: Enfermeria.JPRSignosVitales_A.14
            public void focusGained(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFPs2FocusGained(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addActionListener(new ActionListener() { // from class: Enfermeria.JPRSignosVitales_A.15
            public void actionPerformed(ActionEvent evt) {
                JPRSignosVitales_A.this.JTFFSTallaActionPerformed(evt);
            }
        });
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: Enfermeria.JPRSignosVitales_A.16
            public void focusGained(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFSTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFSTallaFocusLost(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addActionListener(new ActionListener() { // from class: Enfermeria.JPRSignosVitales_A.17
            public void actionPerformed(ActionEvent evt) {
                JPRSignosVitales_A.this.JTFFSPesoActionPerformed(evt);
            }
        });
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: Enfermeria.JPRSignosVitales_A.18
            public void focusGained(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFSPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPRSignosVitales_A.this.JTFFSPesoFocusLost(evt);
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
        GroupLayout JPSignosVitalesLayout = new GroupLayout(this.JPSignosVitales);
        this.JPSignosVitales.setLayout(JPSignosVitalesLayout);
        JPSignosVitalesLayout.setHorizontalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFFSFc, -2, 80, -2).addGap(3, 3, 3).addComponent(this.JTFFSFr, -2, 75, -2).addGap(3, 3, 3).addComponent(this.JTFFTemperatura, -2, 70, -2).addGap(3, 3, 3).addComponent(this.JTFFPs2, -2, 70, -2).addGap(7, 7, 7).addComponent(this.JTFFSTalla, -2, 90, -2).addGap(3, 3, 3).addComponent(this.JTFFSPeso, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSIMC, -2, 100, -2).addContainerGap()));
        JPSignosVitalesLayout.setVerticalGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSignosVitalesLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFSFc, -2, 50, -2).addComponent(this.JTFFSFr, -2, 50, -2).addComponent(this.JTFFTemperatura, -2, 50, -2).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFPs2, -2, 50, -2).addGroup(JPSignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso, -2, 50, -2))).addComponent(this.JTFFSIMC, -2, 50, -2))));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFFSPerimetroAbd, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 444, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGuardar, -1, -1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPIPresion, -2, 144, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPSignosVitales, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIPresion, -2, -1, -2)).addComponent(this.JPSignosVitales, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFSPerimetroAbd, -1, 50, 32767).addComponent(this.JSPObservacion)).addComponent(this.JBTGuardar, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSPDHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDHistorico.setRowHeight(25);
        this.JTDHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDHistorico.setSelectionMode(0);
        this.JSPDHistorico.setViewportView(this.JTDHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDHistorico).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDHistorico, -1, 292, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSistolicaActionPerformed(ActionEvent evt) {
        this.JTFFPSistolica.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSistolicaFocusLost(FocusEvent evt) {
        if (!this.JTFFPSistolica.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPSistolica.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPDiastolicaActionPerformed(ActionEvent evt) {
        this.JTFFPDiastolica.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPDiastolicaFocusLost(FocusEvent evt) {
        if (!this.JTFFPDiastolica.getText().isEmpty()) {
            mValidarPresion(Integer.valueOf(this.JTFFPDiastolica.getText()).intValue(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcActionPerformed(ActionEvent evt) {
        this.JTFFSFr.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusGained(FocusEvent evt) {
        this.JTFFSFc.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrActionPerformed(ActionEvent evt) {
        this.JTFFTemperatura.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrFocusGained(FocusEvent evt) {
        this.JTFFSFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaActionPerformed(ActionEvent evt) {
        this.JTFFPs2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaFocusGained(FocusEvent evt) {
        this.JTFFTemperatura.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2ActionPerformed(ActionEvent evt) {
        this.JTFFSTalla.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2FocusGained(FocusEvent evt) {
        this.JTFFPs2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaActionPerformed(ActionEvent evt) {
        this.JTFFSPeso.requestFocus();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusLost(FocusEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoActionPerformed(ActionEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusGained(FocusEvent evt) {
        this.JTFFSPeso.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusLost(FocusEvent evt) {
        mCalcularImc();
    }

    private void mCalcularImc() {
        if (this.JTFFSTalla.getText() != null && this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("0") && !this.JTFFSTalla.getText().equals("0") && !this.JTFFSTalla.getText().equals("0.0")) {
            DecimalFormat formato = new DecimalFormat("0.00");
            double imc = getPeso() / Math.pow(getTalla(), 2.0d);
            this.JTFFSIMC.setText(String.valueOf(formato.format(imc)));
            return;
        }
        this.JTFFSIMC.setText("0");
    }

    private int getTalla() {
        int valor = 0;
        if (this.JTFFSTalla.getText() != null && !this.JTFFSTalla.getText().equals("") && Integer.parseInt(this.JTFFSTalla.getText()) > 0) {
            valor = Integer.parseInt(this.JTFFSTalla.getText());
        }
        return valor;
    }

    private double getPeso() {
        double valor = 0.0d;
        if (this.JTFFSPeso.getText() != null && !this.JTFFSPeso.getText().equals("") && Double.parseDouble(this.JTFFSPeso.getText()) > 0.0d) {
            valor = Double.parseDouble(this.JTFFSPeso.getText());
        }
        return valor;
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

    private void mGrabarBd() {
        if (this.JBTGuardar.isEnabled()) {
            if (Double.parseDouble(this.JTFFSFc.getText()) < 0.0d) {
                JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fc no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFSFc.requestFocus();
                return;
            }
            if (Double.parseDouble(this.JTFFSFr.getText()) >= 0.0d) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "insert into h_au_rsignos_vitales ( `Id_Atencion` , `TArterialD` , `TArterialS` , `FCardiaca` , `FRespiratoria` , `Talla` , `Peso` , `IMC` , `Temperatura` , `Ps2` , `PerimetroAbdominal` , `Id_Profesional` , `Id_Especialidad`, `Observacion` , `UsuarioS` ) values('" + this.xidatencion + "','" + this.JTFFPDiastolica.getValue() + "','" + this.JTFFPSistolica.getValue() + "','" + this.JTFFSFc.getText() + "','" + this.JTFFSFr.getText() + "','" + this.JTFFSTalla.getText() + "','" + this.JTFFSPeso.getText() + "','" + this.JTFFSIMC.getText().replaceAll(",", ".") + "','" + this.JTFFTemperatura.getText() + "','" + this.JTFFPs2.getText() + "','" + this.JTFFSPerimetroAbd.getValue() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "\t\t\tLa Fr no debe \n\t  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFr.requestFocus();
        }
    }

    private void mNuevo() {
        this.JTFFPDiastolica.setValue(new Integer(0));
        this.JTFFPSistolica.setValue(new Integer(0));
        this.JTFFSFc.setText("0");
        this.JTFFSFr.setText("0");
        this.JTFFSTalla.setText("0");
        this.JTFFSPeso.setText("0");
        this.JTFFSIMC.setText("0");
        this.JTFFTemperatura.setText("0");
        this.JTFFPs2.setText("0");
        this.JTFFSPerimetroAbd.setValue(new Double(0.0d));
        this.JTAObservacion.setText("");
        mCargarDatos();
        this.JTFFPDiastolica.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Presión", "FC", "FR", "Tº", "Ps2", "Talla", "Peso", "Imc", "PAbdominal", "Observación", "Especialidad", "Profesional"}) { // from class: Enfermeria.JPRSignosVitales_A.19
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDHistorico.setModel(this.xmodelo);
        this.JTDHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDHistorico.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDHistorico.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDHistorico.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDHistorico.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDHistorico.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDHistorico.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDHistorico.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDHistorico.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDHistorico.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDHistorico.getColumnModel().getColumn(12).setPreferredWidth(60);
        this.JTDHistorico.getColumnModel().getColumn(13).setPreferredWidth(80);
    }

    private void mCargarDatos() {
        try {
            mCrearTabla();
            this.xsql = "SELECT  `h_au_rsignos_vitales`.`Id` , date_Format(`h_au_rsignos_vitales`.`Fecha`,'%d-%m-%Y %H:%m:%s %p') as Fecha , concat(`h_au_rsignos_vitales`.`TArterialD` ,'/', `h_au_rsignos_vitales`.`TArterialS`) as Presion , `h_au_rsignos_vitales`.`FCardiaca` , `h_au_rsignos_vitales`.`FRespiratoria` , `h_au_rsignos_vitales`.`Temperatura` , `h_au_rsignos_vitales`.`Ps2` , `h_au_rsignos_vitales`.`Talla` , `h_au_rsignos_vitales`.`Peso` , `h_au_rsignos_vitales`.`IMC` , `h_au_rsignos_vitales`.`PerimetroAbdominal` , `h_au_rsignos_vitales`.`Observacion` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` , `h_au_rsignos_vitales`.`Id_Atencion` FROM `profesional1` INNER JOIN  `h_au_rsignos_vitales`  ON (`profesional1`.`Id_Persona` = `h_au_rsignos_vitales`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_au_rsignos_vitales`.`Id_Especialidad`) WHERE (`h_au_rsignos_vitales`.`Id_Atencion` ='" + this.xidatencion + "' AND `h_au_rsignos_vitales`.`Estado` =1) ORDER BY `h_au_rsignos_vitales`.`Fecha` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                int xfila = 0;
                xrs.beforeFirst();
                this.xmt.mEstablecerTextEditor(this.JTDHistorico, 1);
                this.xmt.mEstablecerTextEditor(this.JTDHistorico, 11);
                this.xmt.mEstablecerTextEditor(this.JTDHistorico, 12);
                this.xmt.mEstablecerTextEditor(this.JTDHistorico, 13);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), xfila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), xfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), xfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), xfila, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), xfila, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), xfila, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), xfila, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(10)), xfila, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), xfila, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), xfila, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), xfila, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), xfila, 13);
                    xfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPRSignosVitales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mRealizarCasting(String xnombre) {
        if (xnombre.equals("xjifhistoriauh")) {
            this.xidatencion = Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText();
        } else if (xnombre.equals("jifhistoriaclinica")) {
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        }
    }
}
