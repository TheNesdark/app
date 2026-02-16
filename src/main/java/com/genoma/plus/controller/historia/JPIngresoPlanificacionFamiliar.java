package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.GTipoprograma;
import com.genoma.plus.jpa.entities.GUsuario;
import com.genoma.plus.jpa.entities.GUsuarioxprograma;
import com.genoma.plus.jpa.entities.HTipometplanifica;
import com.genoma.plus.jpa.service.GUsuarioService;
import com.genoma.plus.jpa.service.IGUsuarioprogramaService;
import com.genoma.plus.jpa.service.IHTipometplanificaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPIngresoPlanificacionFamiliar.class */
public class JPIngresoPlanificacionFamiliar extends JPanel {
    private List<HTipometplanifica> listaTipoMetodo;
    private GUsuarioxprograma gUsuarioxprograma;
    private Long idUsuario;
    private Integer idPrograma;
    private JButton JBTGuardar;
    private JComboBox JCBMetodoPlanificacion;
    private JComboBox JCBMotEgreso;
    private JComboBox<String> JCB_Resultado;
    public JDateChooser JDFechaEgreso;
    private JDateChooser JD_FechaIngreso;
    private JDateChooser JD_PruebaFecha;
    private JLabel JLBPBSentado;
    private JLabel JLIdIngresoPrograma;
    private JPanel JPESignosVitales;
    private JPanel JPIEgreso;
    private JPanel JPIPresion;
    private JPanel JPIngreso;
    private JPanel JPPruebaPanel;
    private JScrollPane JSPEObservacion;
    public JTextFieldValidator JTFFE_IMC;
    private JFormattedTextField JTFFE_PDiastolica;
    private JFormattedTextField JTFFE_PSistolica;
    public JTextFieldValidator JTFFE_Peso;
    public JTextFieldValidator JTFFE_Talla;
    private JTabbedPane JTPDatos;
    private JTextArea JTPEFObsEgresos;
    private JTextArea JTPEFObservaciones;
    private JScrollPane jScrollPane2;
    private final IHTipometplanificaService iHTipometplanificaService = (IHTipometplanificaService) Principal.contexto.getBean(IHTipometplanificaService.class);
    private final IGUsuarioprogramaService iUsuarioPorProgramaService = (IGUsuarioprogramaService) Principal.contexto.getBean(IGUsuarioprogramaService.class);
    private final GUsuarioService iGUsuarioService = (GUsuarioService) Principal.contexto.getBean(GUsuarioService.class);
    private Metodos metodos = new Metodos();

    public JPIngresoPlanificacionFamiliar(Long idUsuario, Integer idPrograma, Boolean forma) {
        initComponents();
        System.out.println("" + idUsuario);
        System.out.println("" + idPrograma);
        this.idUsuario = idUsuario;
        this.idPrograma = idPrograma;
        if (forma.booleanValue()) {
            this.JTPDatos.remove(1);
        }
        nuevo();
    }

    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIngreso = new JPanel();
        this.JD_FechaIngreso = new JDateChooser();
        this.JCBMetodoPlanificacion = new JComboBox();
        this.JPESignosVitales = new JPanel();
        this.JTFFE_Talla = new JTextFieldValidator();
        this.JTFFE_Peso = new JTextFieldValidator();
        this.JTFFE_IMC = new JTextFieldValidator();
        this.JSPEObservacion = new JScrollPane();
        this.JTPEFObservaciones = new JTextArea();
        this.JPPruebaPanel = new JPanel();
        this.JD_PruebaFecha = new JDateChooser();
        this.JCB_Resultado = new JComboBox<>();
        this.JPIPresion = new JPanel();
        this.JTFFE_PSistolica = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JTFFE_PDiastolica = new JFormattedTextField();
        this.JPIEgreso = new JPanel();
        this.JDFechaEgreso = new JDateChooser();
        this.JCBMotEgreso = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTPEFObsEgresos = new JTextArea();
        this.JBTGuardar = new JButton();
        this.JLIdIngresoPrograma = new JLabel();
        setName("jpIngresoPlanificacionFamiliar");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JD_FechaIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ingreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JD_FechaIngreso.setDateFormatString("dd/MM/yyyy");
        this.JD_FechaIngreso.setFont(new Font("Arial", 1, 12));
        this.JD_FechaIngreso.setMaxSelectableDate(new Date(253370786508000L));
        this.JD_FechaIngreso.setMinSelectableDate(new Date(-62135747892000L));
        this.JCBMetodoPlanificacion.setFont(new Font("Arial", 1, 12));
        this.JCBMetodoPlanificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Método Planificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMetodoPlanificacion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.1
            public void itemStateChanged(ItemEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JCBMetodoPlanificacionItemStateChanged(evt);
            }
        });
        this.JPESignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "SIGNOS VITALES", 1, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFE_Talla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFE_Talla.setHorizontalAlignment(0);
        this.JTFFE_Talla.setText("0");
        this.JTFFE_Talla.setToolTipText("Talla en Centimetros");
        this.JTFFE_Talla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFE_Talla.setFocusAccelerator('C');
        this.JTFFE_Talla.setFont(new Font("Arial", 1, 12));
        this.JTFFE_Talla.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.2
            public void actionPerformed(ActionEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_TallaActionPerformed(evt);
            }
        });
        this.JTFFE_Talla.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.3
            public void focusGained(FocusEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_TallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_TallaFocusLost(evt);
            }
        });
        this.JTFFE_Peso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFE_Peso.setHorizontalAlignment(0);
        this.JTFFE_Peso.setText("0");
        this.JTFFE_Peso.setToolTipText("Peso en Kilogramos");
        this.JTFFE_Peso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFE_Peso.setFocusAccelerator('C');
        this.JTFFE_Peso.setFont(new Font("Arial", 1, 12));
        this.JTFFE_Peso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.4
            public void actionPerformed(ActionEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_PesoActionPerformed(evt);
            }
        });
        this.JTFFE_Peso.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.5
            public void focusGained(FocusEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_PesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_PesoFocusLost(evt);
            }
        });
        this.JTFFE_IMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFE_IMC.setHorizontalAlignment(0);
        this.JTFFE_IMC.setText("0");
        this.JTFFE_IMC.setToolTipText("Indice de Masa Corporal");
        this.JTFFE_IMC.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFE_IMC.setExprecionRegular("^[0.0-9]*$");
        this.JTFFE_IMC.setFocusable(false);
        this.JTFFE_IMC.setFont(new Font("Arial", 1, 24));
        GroupLayout JPESignosVitalesLayout = new GroupLayout(this.JPESignosVitales);
        this.JPESignosVitales.setLayout(JPESignosVitalesLayout);
        JPESignosVitalesLayout.setHorizontalGroup(JPESignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPESignosVitalesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFE_Talla, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFE_Peso, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFFE_IMC, -2, 100, -2).addContainerGap()));
        JPESignosVitalesLayout.setVerticalGroup(JPESignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPESignosVitalesLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPESignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFE_Talla, -2, 50, -2).addComponent(this.JTFFE_Peso, -2, 50, -2).addComponent(this.JTFFE_IMC, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSPEObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPEFObservaciones.setColumns(1);
        this.JTPEFObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTPEFObservaciones.setLineWrap(true);
        this.JTPEFObservaciones.setRows(1);
        this.JTPEFObservaciones.setTabSize(1);
        this.JTPEFObservaciones.setBorder((Border) null);
        this.JSPEObservacion.setViewportView(this.JTPEFObservaciones);
        this.JPPruebaPanel.setBorder(BorderFactory.createTitledBorder((Border) null, "INFOMACIÓN PRUEBA EMBARAZO", 1, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JD_PruebaFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JD_PruebaFecha.setDateFormatString("dd/MM/yyyy");
        this.JD_PruebaFecha.setFont(new Font("Arial", 1, 12));
        this.JD_PruebaFecha.setMaxSelectableDate(new Date(253370786508000L));
        this.JD_PruebaFecha.setMinSelectableDate(new Date(-62135747892000L));
        this.JCB_Resultado.setFont(new Font("Arial", 1, 12));
        this.JCB_Resultado.setModel(new DefaultComboBoxModel(new String[]{" ", "Negativa", "Positiva"}));
        this.JCB_Resultado.setAutoscrolls(true);
        this.JCB_Resultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPPruebaPanelLayout = new GroupLayout(this.JPPruebaPanel);
        this.JPPruebaPanel.setLayout(JPPruebaPanelLayout);
        JPPruebaPanelLayout.setHorizontalGroup(JPPruebaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPruebaPanelLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JD_PruebaFecha, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCB_Resultado, -2, 124, -2)));
        JPPruebaPanelLayout.setVerticalGroup(JPPruebaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPPruebaPanelLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPPruebaPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JD_PruebaFecha, -1, -1, 32767).addComponent(this.JCB_Resultado, -2, 50, -2)).addContainerGap()));
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "Presión Sistólica / Diastólica", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFE_PSistolica.setHorizontalAlignment(4);
        this.JTFFE_PSistolica.setFont(new Font("Arial", 1, 12));
        this.JTFFE_PSistolica.setName("fechanaciemiento");
        this.JTFFE_PSistolica.setValue(new Integer(0));
        this.JTFFE_PSistolica.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.6
            public void focusGained(FocusEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_PSistolicaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_PSistolicaFocusLost(evt);
            }
        });
        this.JTFFE_PSistolica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.7
            public void actionPerformed(ActionEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_PSistolicaActionPerformed(evt);
            }
        });
        this.JTFFE_PSistolica.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.8
            public void keyTyped(KeyEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_PSistolicaKeyTyped(evt);
            }
        });
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JTFFE_PDiastolica.setHorizontalAlignment(4);
        this.JTFFE_PDiastolica.setFont(new Font("Arial", 1, 12));
        this.JTFFE_PDiastolica.setName("fechanaciemiento");
        this.JTFFE_PDiastolica.setValue(new Integer(0));
        this.JTFFE_PDiastolica.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.9
            public void focusGained(FocusEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_PDiastolicaFocusGained(evt);
            }
        });
        this.JTFFE_PDiastolica.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.10
            public void keyTyped(KeyEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JTFFE_PDiastolicaKeyTyped(evt);
            }
        });
        GroupLayout JPIPresionLayout = new GroupLayout(this.JPIPresion);
        this.JPIPresion.setLayout(JPIPresionLayout);
        JPIPresionLayout.setHorizontalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFE_PSistolica, -2, 60, -2).addGap(7, 7, 7).addComponent(this.JLBPBSentado).addGap(5, 5, 5).addComponent(this.JTFFE_PDiastolica, -2, 60, -2).addContainerGap(27, 32767)));
        JPIPresionLayout.setVerticalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFE_PSistolica, -2, 25, -2).addComponent(this.JLBPBSentado, -2, 23, -2).addComponent(this.JTFFE_PDiastolica, -2, 25, -2)).addGap(0, 3, 32767)));
        GroupLayout JPIngresoLayout = new GroupLayout(this.JPIngreso);
        this.JPIngreso.setLayout(JPIngresoLayout);
        JPIngresoLayout.setHorizontalGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPEObservacion, -2, 793, -2).addGroup(JPIngresoLayout.createSequentialGroup().addComponent(this.JD_FechaIngreso, -2, -1, -2).addGap(28, 28, 28).addComponent(this.JCBMetodoPlanificacion, -2, 404, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIPresion, -2, -1, -2)).addGroup(JPIngresoLayout.createSequentialGroup().addComponent(this.JPESignosVitales, -2, -1, -2).addGap(163, 163, 163).addComponent(this.JPPruebaPanel, -2, -1, -2))).addContainerGap(17, 32767)));
        JPIngresoLayout.setVerticalGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresoLayout.createSequentialGroup().addGap(13, 13, 13).addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMetodoPlanificacion, -2, 50, -2).addComponent(this.JD_FechaIngreso, -2, 50, -2).addComponent(this.JPIPresion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPESignosVitales, -2, -1, -2).addComponent(this.JPPruebaPanel, -2, 83, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPEObservacion, -1, 90, 32767).addContainerGap()));
        this.JTPDatos.addTab("INGRESO", this.JPIngreso);
        this.JDFechaEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Egreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaEgreso.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEgreso.setFont(new Font("Arial", 1, 12));
        this.JCBMotEgreso.setFont(new Font("Arial", 1, 12));
        this.JCBMotEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo de Egreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEFObsEgresos.setColumns(1);
        this.JTPEFObsEgresos.setLineWrap(true);
        this.JTPEFObsEgresos.setRows(1);
        this.JTPEFObsEgresos.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTPEFObsEgresos);
        GroupLayout JPIEgresoLayout = new GroupLayout(this.JPIEgreso);
        this.JPIEgreso.setLayout(JPIEgresoLayout);
        JPIEgresoLayout.setHorizontalGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEgresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -2, 735, -2).addGroup(JPIEgresoLayout.createSequentialGroup().addComponent(this.JDFechaEgreso, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMotEgreso, -2, 464, -2))).addContainerGap(79, 32767)));
        JPIEgresoLayout.setVerticalGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEgresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIEgresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMotEgreso, -2, 51, -2).addComponent(this.JDFechaEgreso, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.jScrollPane2, -2, 180, -2).addContainerGap(15, 32767)));
        this.JTPDatos.addTab("EGRESO", this.JPIEgreso);
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIngresoPlanificacionFamiliar.11
            public void actionPerformed(ActionEvent evt) {
                JPIngresoPlanificacionFamiliar.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JLIdIngresoPrograma.setFont(new Font("Arial", 1, 18));
        this.JLIdIngresoPrograma.setHorizontalAlignment(0);
        this.JLIdIngresoPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 841, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JBTGuardar, -2, 647, -2).addGap(18, 18, 18).addComponent(this.JLIdIngresoPrograma, -2, 156, -2).addGap(14, 14, 14)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 316, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTGuardar, -2, 50, -2).addComponent(this.JLIdIngresoPrograma, -2, 50, -2)).addContainerGap(7, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMetodoPlanificacionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_TallaActionPerformed(ActionEvent evt) {
        this.JTFFE_Peso.requestFocus();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_TallaFocusGained(FocusEvent evt) {
        this.JTFFE_Talla.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_TallaFocusLost(FocusEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PesoActionPerformed(ActionEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PesoFocusGained(FocusEvent evt) {
        this.JTFFE_Peso.selectAll();
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PesoFocusLost(FocusEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PSistolicaFocusGained(FocusEvent evt) {
        this.JTFFE_PSistolica.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PSistolicaFocusLost(FocusEvent evt) {
        if (!this.JTFFE_PSistolica.getText().isEmpty() && !this.JTFFE_PSistolica.getText().equals("0")) {
            mValidarPresion(Integer.valueOf(this.JTFFE_PSistolica.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PSistolicaActionPerformed(ActionEvent evt) {
        this.JTFFE_PDiastolica.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PSistolicaKeyTyped(KeyEvent evt) {
        soloNumero(evt, this.JTFFE_PSistolica.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PDiastolicaFocusGained(FocusEvent evt) {
        this.JTFFE_PDiastolica.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFE_PDiastolicaKeyTyped(KeyEvent evt) {
        soloNumero(evt, this.JTFFE_PDiastolica.getText());
    }

    private void soloNumero(KeyEvent evt, String campo) {
        if (IsInteger(evt.getKeyChar() + "") && campo.length() < 3) {
            evt.setKeyChar(evt.getKeyChar());
        } else {
            evt.consume();
        }
    }

    public static boolean IsInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void mValidarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                this.metodos.mostrarMensaje("La Presión Sistólica esta Baja");
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    this.metodos.mostrarMensaje("La Presión Sistólica esta Alta");
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            this.metodos.mostrarMensaje("La Presion Diastólica esta Baja");
        } else if (valor > 0 && valor > 90) {
            this.metodos.mostrarMensaje("La Presión Diastólica esta Alta");
        }
    }

    private void mCalcularImc() {
        if (this.JTFFE_Talla.getText() != null && this.JTFFE_Peso.getText() != null) {
            DecimalFormat formato = new DecimalFormat("00");
            double imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            this.JTFFE_IMC.setText(String.valueOf(formato.format(imc)));
            return;
        }
        this.JTFFE_IMC.setText("0.0");
    }

    private double getTalla() {
        double valor = 0.0d;
        if (this.JTFFE_Talla.getText() != null && !this.JTFFE_Talla.getText().equals("") && Double.parseDouble(this.JTFFE_Talla.getText()) > 0.0d) {
            valor = Double.parseDouble(this.JTFFE_Talla.getText());
        }
        return valor;
    }

    private double getPeso() {
        double valor = 0.0d;
        if (this.JTFFE_Peso.getText() != null && !this.JTFFE_Peso.getText().equals("") && Double.parseDouble(this.JTFFE_Peso.getText()) > 0.0d) {
            valor = Double.parseDouble(this.JTFFE_Peso.getText());
        }
        return valor;
    }

    public void nuevo() {
        this.JCBMetodoPlanificacion.removeAllItems();
        this.listaTipoMetodo = new ArrayList();
        this.listaTipoMetodo = this.iHTipometplanificaService.listaTipoMetodosPorEstado(false);
        if (!this.listaTipoMetodo.isEmpty()) {
            this.listaTipoMetodo.forEach(item -> {
                this.JCBMetodoPlanificacion.addItem(item.getNbre());
            });
            if (this.listaTipoMetodo.size() > 1) {
                this.JCBMetodoPlanificacion.setSelectedIndex(-1);
            }
        }
        this.gUsuarioxprograma = this.iUsuarioPorProgramaService.buscarPorIdUsuarioIdPrograma(this.idUsuario, this.idPrograma);
        if (this.gUsuarioxprograma != null) {
            this.JD_FechaIngreso.setDate(this.gUsuarioxprograma.getFechaIngreso());
            this.JCBMetodoPlanificacion.setSelectedItem(this.gUsuarioxprograma.getMtdoPlaniFliar());
            this.JTFFE_PDiastolica.setText("" + this.gUsuarioxprograma.getTADiastolica());
            this.JTFFE_PSistolica.setText("" + this.gUsuarioxprograma.getTASistolica());
            this.JTFFE_Peso.setText("" + this.gUsuarioxprograma.getPeso());
            this.JTFFE_Talla.setText("" + this.gUsuarioxprograma.getTalla());
            this.JTFFE_IMC.setText("" + this.gUsuarioxprograma.getImc());
            this.JD_PruebaFecha.setDate(this.gUsuarioxprograma.getIFechaDx());
            this.JCB_Resultado.setSelectedItem(this.gUsuarioxprograma.getICRiesgo());
            this.JTPEFObservaciones.setText(this.gUsuarioxprograma.getObservacionIngreso());
            this.JLIdIngresoPrograma.setText("" + this.gUsuarioxprograma.getId());
            return;
        }
        this.JD_FechaIngreso.setDate(this.metodos.getFechaActual());
        this.gUsuarioxprograma = new GUsuarioxprograma();
    }

    public void grabar() {
        if (datosObligatorios().booleanValue()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                GTipoprograma gTipoprograma = new GTipoprograma();
                gTipoprograma.setIdTipoPrograma(this.idPrograma);
                GPersona persona = new GPersona();
                persona.setId(this.idUsuario);
                Optional<GUsuario> gUsuario = this.iGUsuarioService.findByIdPersona(persona);
                if (gUsuario.isPresent()) {
                    this.gUsuarioxprograma.setFechaIngreso(this.JD_FechaIngreso.getDate());
                    this.gUsuarioxprograma.setMtdoPlaniFliar(this.JCBMetodoPlanificacion.getSelectedItem().toString());
                    this.gUsuarioxprograma.setTADiastolica(Short.valueOf(this.JTFFE_PDiastolica.getText()));
                    this.gUsuarioxprograma.setTASistolica(Short.valueOf(this.JTFFE_PSistolica.getText()));
                    this.gUsuarioxprograma.setPeso(Double.valueOf(this.JTFFE_Peso.getText()));
                    this.gUsuarioxprograma.setTalla(Double.valueOf(this.JTFFE_Talla.getText()));
                    this.gUsuarioxprograma.setImc(Double.valueOf(this.JTFFE_IMC.getText()));
                    this.gUsuarioxprograma.setIFechaDx(this.JD_PruebaFecha.getDate());
                    this.gUsuarioxprograma.setICRiesgo(this.JCB_Resultado.getSelectedItem().toString());
                    this.gUsuarioxprograma.setObservacionIngreso(this.JTPEFObservaciones.getText());
                    this.gUsuarioxprograma.setIdPrograma(gTipoprograma);
                    this.gUsuarioxprograma.setIdUsuario(gUsuario.get());
                    this.gUsuarioxprograma.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    this.gUsuarioxprograma.setEsIngreso(true);
                    this.gUsuarioxprograma.setEstado(true);
                    this.gUsuarioxprograma.setCardinal(0);
                    this.gUsuarioxprograma = this.iUsuarioPorProgramaService.grabar(this.gUsuarioxprograma);
                    this.JLIdIngresoPrograma.setText("" + this.gUsuarioxprograma.getId());
                }
            }
        }
    }

    private Boolean datosObligatorios() {
        Boolean opcion = true;
        if (this.JD_FechaIngreso.getDate() == null) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la fecha de ingreso al programa (Fecha en la que el paciente ingreso a este programa).", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JD_FechaIngreso.requestFocus();
        } else if (this.JCBMetodoPlanificacion.getSelectedIndex() == -1) {
            opcion = false;
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de metodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBMetodoPlanificacion.requestFocus();
        } else if (this.JTFFE_PSistolica.getText().isEmpty() || IsDoouble(this.JTFFE_PSistolica.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_PSistolica.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en presión sistólica", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_PSistolica.requestFocus();
            opcion = false;
        } else if (this.JTFFE_PDiastolica.getText().isEmpty() || IsDoouble(this.JTFFE_PDiastolica.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_PDiastolica.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en presión diastólica", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_PDiastolica.requestFocus();
            opcion = false;
        } else if (this.JTFFE_Talla.getText().isEmpty() || IsDoouble(this.JTFFE_Talla.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_Talla.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en talla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_Talla.requestFocus();
            opcion = false;
        } else if (this.JTFFE_Peso.getText().isEmpty() || IsDoouble(this.JTFFE_Peso.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_Peso.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en peso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_Peso.requestFocus();
            opcion = false;
        } else if (this.JTFFE_IMC.getText().isEmpty() || IsDoouble(this.JTFFE_IMC.getText()).doubleValue() <= 0.0d || !IsInteger(this.JTFFE_IMC.getText())) {
            JOptionPane.showInternalMessageDialog(this, "Ingrese un dato valido en IMC", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFE_IMC.requestFocus();
            opcion = false;
        }
        return opcion;
    }

    public static Double IsDoouble(String text) {
        Double v = Double.valueOf(0.0d);
        try {
            v = Double.valueOf(Double.parseDouble(text));
        } catch (NumberFormatException e) {
        }
        return v;
    }
}
