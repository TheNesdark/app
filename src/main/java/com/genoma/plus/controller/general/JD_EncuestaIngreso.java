package com.genoma.plus.controller.general;

import Acceso.Principal;
import General.JDBiometrico;
import Utilidades.Metodos;
import UtilidadesMetodosHttp.MetodosHttp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.controller.general.dto.DetalleCuestionarioDto;
import com.genoma.plus.controller.general.dto.EncuestaRegistroUsuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JD_EncuestaIngreso.class */
public class JD_EncuestaIngreso extends JDialog {
    private EncuestaRegistroUsuario registroUsuario;
    private String p1;
    private String p2;
    private String p3;
    private String p4;
    private String p5;
    private Long idPersona;
    private Metodos metodos;
    private File archivo;
    private ButtonGroup JBG_P1;
    private ButtonGroup JBG_P2;
    private ButtonGroup JBG_P3;
    private ButtonGroup JBG_P4;
    private ButtonGroup JBG_P5;
    private JButton JBT_Grabar;
    private JButton JBT_Salir;
    private JCheckBox JCH_P5_Email;
    private JCheckBox JCH_P5_Personal;
    private JCheckBox JCH_P5_Web;
    private JCheckBox JCH_P5_Whatsapp;
    private JLabel JLB_NRegistro;
    private JLabel JLB_Pregunta1;
    private JLabel JLB_Pregunta2;
    private JLabel JLB_Pregunta3;
    private JLabel JLB_Pregunta4;
    private JLabel JLB_Pregunta5;
    private JLabel JLB_Titulo;
    private JPanel JPI_Preguntas;
    private JPanel JPI_Respuesta;
    private JRadioButton JRB_P1No;
    private JRadioButton JRB_P1Si;
    private JRadioButton JRB_P2No;
    private JRadioButton JRB_P2Si;
    private JRadioButton JRB_P3No;
    private JRadioButton JRB_P3Si;
    private JRadioButton JRB_P4No;
    private JRadioButton JRB_P4Si;
    private JButton btnCerrar;

    public JD_EncuestaIngreso(Frame parent, boolean modal, String idPersona) {
        super(parent, modal);
        this.p1 = "";
        this.p2 = "";
        this.p3 = "";
        this.p4 = "";
        this.p5 = "";
        initComponents();
        this.idPersona = Long.valueOf(idPersona);
        this.metodos = new Metodos();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.registroUsuario = new EncuestaRegistroUsuario();
        this.JLB_NRegistro.setText("");
    }

    private void initComponents() {
        this.JBG_P5 = new ButtonGroup();
        this.JBG_P1 = new ButtonGroup();
        this.JBG_P2 = new ButtonGroup();
        this.JBG_P3 = new ButtonGroup();
        this.JBG_P4 = new ButtonGroup();
        this.JLB_Titulo = new JLabel();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.JPI_Preguntas = new JPanel();
        this.JLB_Pregunta1 = new JLabel();
        this.JLB_Pregunta2 = new JLabel();
        this.JLB_Pregunta3 = new JLabel();
        this.JLB_Pregunta4 = new JLabel();
        this.JLB_Pregunta5 = new JLabel();
        this.JCH_P5_Whatsapp = new JCheckBox();
        this.JCH_P5_Personal = new JCheckBox();
        this.JCH_P5_Email = new JCheckBox();
        this.JCH_P5_Web = new JCheckBox();
        this.JPI_Respuesta = new JPanel();
        this.JRB_P1Si = new JRadioButton();
        this.JRB_P1No = new JRadioButton();
        this.JRB_P2Si = new JRadioButton();
        this.JRB_P2No = new JRadioButton();
        this.JRB_P3Si = new JRadioButton();
        this.JRB_P3No = new JRadioButton();
        this.JRB_P4Si = new JRadioButton();
        this.JRB_P4No = new JRadioButton();
        this.JLB_NRegistro = new JLabel();
        this.btnCerrar = new JButton();
        setDefaultCloseOperation(2);
        this.JLB_Titulo.setFont(new Font("Arial", 1, 14));
        this.JLB_Titulo.setForeground(Color.red);
        this.JLB_Titulo.setHorizontalAlignment(0);
        this.JLB_Titulo.setText("REGISTRO DE INGRESO DE USUARIO");
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setMnemonic('G');
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.setName("JBAdicionaPProcedimiento");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.1
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.JBT_Salir.setMnemonic('S');
        this.JBT_Salir.setText("Firmar");
        this.JBT_Salir.setName("JBAdicionaPProcedimiento");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.2
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JPI_Preguntas.setBorder(BorderFactory.createTitledBorder((Border) null, "Preguntas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_Pregunta1.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta1.setText("¿Cumple con las recomendaciones para la toma de muestra?");
        this.JLB_Pregunta2.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta2.setText("¿Se le informó el tiempo de espera del resultado?");
        this.JLB_Pregunta3.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta3.setText("¿Se le informó sus deberes y derechos?");
        this.JLB_Pregunta4.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta4.setText("¿Autoriza el tratamiento de sus datos personales?");
        this.JLB_Pregunta5.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta5.setText("¿POR QUE MEDIO AUTORIZA LA ENTREGA DE SUS RESULTADOS?");
        this.JBG_P5.add(this.JCH_P5_Whatsapp);
        this.JCH_P5_Whatsapp.setFont(new Font("Arial", 1, 12));
        this.JCH_P5_Whatsapp.setForeground(new Color(0, 103, 0));
        this.JCH_P5_Whatsapp.setText("WhatsApp");
        this.JCH_P5_Whatsapp.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.3
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JCH_P5_WhatsappActionPerformed(evt);
            }
        });
        this.JBG_P5.add(this.JCH_P5_Personal);
        this.JCH_P5_Personal.setFont(new Font("Arial", 1, 12));
        this.JCH_P5_Personal.setForeground(new Color(0, 103, 0));
        this.JCH_P5_Personal.setText("Personal");
        this.JCH_P5_Personal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.4
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JCH_P5_PersonalActionPerformed(evt);
            }
        });
        this.JBG_P5.add(this.JCH_P5_Email);
        this.JCH_P5_Email.setFont(new Font("Arial", 1, 12));
        this.JCH_P5_Email.setForeground(new Color(0, 103, 0));
        this.JCH_P5_Email.setText("Email");
        this.JCH_P5_Email.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.5
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JCH_P5_EmailActionPerformed(evt);
            }
        });
        this.JBG_P5.add(this.JCH_P5_Web);
        this.JCH_P5_Web.setFont(new Font("Arial", 1, 12));
        this.JCH_P5_Web.setForeground(new Color(0, 103, 0));
        this.JCH_P5_Web.setText("Descarga Web");
        this.JCH_P5_Web.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.6
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JCH_P5_WebActionPerformed(evt);
            }
        });
        GroupLayout JPI_PreguntasLayout = new GroupLayout(this.JPI_Preguntas);
        this.JPI_Preguntas.setLayout(JPI_PreguntasLayout);
        JPI_PreguntasLayout.setHorizontalGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PreguntasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_PreguntasLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_PreguntasLayout.createSequentialGroup().addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Pregunta1).addComponent(this.JLB_Pregunta2).addComponent(this.JLB_Pregunta3).addComponent(this.JLB_Pregunta4)).addGap(212, 212, 212)).addGroup(JPI_PreguntasLayout.createSequentialGroup().addComponent(this.JLB_Pregunta5, -2, 468, -2).addContainerGap()))).addGroup(JPI_PreguntasLayout.createSequentialGroup().addComponent(this.JCH_P5_Whatsapp).addGap(39, 39, 39).addComponent(this.JCH_P5_Personal).addGap(41, 41, 41).addComponent(this.JCH_P5_Email).addGap(46, 46, 46).addComponent(this.JCH_P5_Web).addGap(0, 0, 32767)))));
        JPI_PreguntasLayout.setVerticalGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_PreguntasLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLB_Pregunta1).addGap(43, 43, 43).addComponent(this.JLB_Pregunta2).addGap(46, 46, 46).addComponent(this.JLB_Pregunta3).addGap(50, 50, 50).addComponent(this.JLB_Pregunta4).addGap(36, 36, 36).addComponent(this.JLB_Pregunta5).addGap(18, 18, 18).addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_P5_Whatsapp).addComponent(this.JCH_P5_Personal).addComponent(this.JCH_P5_Email).addComponent(this.JCH_P5_Web))));
        this.JPI_Respuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Respuestas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_P1.add(this.JRB_P1Si);
        this.JRB_P1Si.setFont(new Font("Arial", 1, 12));
        this.JRB_P1Si.setText("Si");
        this.JRB_P1Si.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.7
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JRB_P1SiActionPerformed(evt);
            }
        });
        this.JBG_P1.add(this.JRB_P1No);
        this.JRB_P1No.setFont(new Font("Arial", 1, 12));
        this.JRB_P1No.setText("No");
        this.JRB_P1No.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.8
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JRB_P1NoActionPerformed(evt);
            }
        });
        this.JBG_P2.add(this.JRB_P2Si);
        this.JRB_P2Si.setFont(new Font("Arial", 1, 12));
        this.JRB_P2Si.setText("Si");
        this.JRB_P2Si.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.9
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JRB_P2SiActionPerformed(evt);
            }
        });
        this.JBG_P2.add(this.JRB_P2No);
        this.JRB_P2No.setFont(new Font("Arial", 1, 12));
        this.JRB_P2No.setText("No");
        this.JRB_P2No.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.10
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JRB_P2NoActionPerformed(evt);
            }
        });
        this.JBG_P3.add(this.JRB_P3Si);
        this.JRB_P3Si.setFont(new Font("Arial", 1, 12));
        this.JRB_P3Si.setText("Si");
        this.JRB_P3Si.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.11
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JRB_P3SiActionPerformed(evt);
            }
        });
        this.JBG_P3.add(this.JRB_P3No);
        this.JRB_P3No.setFont(new Font("Arial", 1, 12));
        this.JRB_P3No.setText("No");
        this.JRB_P3No.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.12
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JRB_P3NoActionPerformed(evt);
            }
        });
        this.JBG_P4.add(this.JRB_P4Si);
        this.JRB_P4Si.setFont(new Font("Arial", 1, 12));
        this.JRB_P4Si.setText("Si");
        this.JRB_P4Si.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.13
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JRB_P4SiActionPerformed(evt);
            }
        });
        this.JBG_P4.add(this.JRB_P4No);
        this.JRB_P4No.setFont(new Font("Arial", 1, 12));
        this.JRB_P4No.setText("No");
        this.JRB_P4No.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.14
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.JRB_P4NoActionPerformed(evt);
            }
        });
        GroupLayout JPI_RespuestaLayout = new GroupLayout(this.JPI_Respuesta);
        this.JPI_Respuesta.setLayout(JPI_RespuestaLayout);
        JPI_RespuestaLayout.setHorizontalGroup(JPI_RespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RespuestaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_P4Si).addComponent(this.JRB_P3Si).addComponent(this.JRB_P2Si).addComponent(this.JRB_P1Si)).addGap(27, 27, 27).addGroup(JPI_RespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_P4No).addComponent(this.JRB_P3No).addComponent(this.JRB_P2No).addComponent(this.JRB_P1No)).addContainerGap(-1, 32767)));
        JPI_RespuestaLayout.setVerticalGroup(JPI_RespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RespuestaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RespuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_P1Si).addComponent(this.JRB_P1No)).addGap(43, 43, 43).addGroup(JPI_RespuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_P2Si).addComponent(this.JRB_P2No)).addGap(46, 46, 46).addGroup(JPI_RespuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_P3Si).addComponent(this.JRB_P3No)).addGap(41, 41, 41).addGroup(JPI_RespuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_P4Si).addComponent(this.JRB_P4No)).addContainerGap(15, 32767)));
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 12));
        this.JLB_NRegistro.setForeground(Color.red);
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.btnCerrar.setFont(new Font("Arial", 1, 12));
        this.btnCerrar.setForeground(new Color(0, 0, 153));
        this.btnCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCerrar.setText("Cerrar");
        this.btnCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JD_EncuestaIngreso.15
            public void actionPerformed(ActionEvent evt) {
                JD_EncuestaIngreso.this.btnCerrarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Grabar, -2, 180, -2).addGap(53, 53, 53).addComponent(this.JBT_Salir, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnCerrar, -2, 180, -2)).addComponent(this.JLB_Titulo, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPI_Preguntas, -2, 500, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_Respuesta, -1, -1, 32767).addComponent(this.JLB_NRegistro, -1, -1, 32767)))).addContainerGap(18, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLB_Titulo, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Preguntas, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JPI_Respuesta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_NRegistro, -2, 53, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addComponent(this.btnCerrar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_P5_EmailActionPerformed(ActionEvent evt) {
        this.p5 = this.JCH_P5_Email.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P1SiActionPerformed(ActionEvent evt) {
        this.p1 = this.JRB_P1Si.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P1NoActionPerformed(ActionEvent evt) {
        this.p1 = this.JRB_P1No.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P2SiActionPerformed(ActionEvent evt) {
        this.p2 = this.JRB_P2Si.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P2NoActionPerformed(ActionEvent evt) {
        this.p2 = this.JRB_P2No.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P3SiActionPerformed(ActionEvent evt) {
        this.p3 = this.JRB_P3Si.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P3NoActionPerformed(ActionEvent evt) {
        this.p3 = this.JRB_P3No.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P4SiActionPerformed(ActionEvent evt) {
        this.p4 = this.JRB_P4Si.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P4NoActionPerformed(ActionEvent evt) {
        this.p4 = this.JRB_P4No.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_P5_WhatsappActionPerformed(ActionEvent evt) {
        this.p5 = this.JCH_P5_Whatsapp.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_P5_PersonalActionPerformed(ActionEvent evt) {
        this.p5 = this.JCH_P5_Personal.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        JDBiometrico xjdBiometrico = new JDBiometrico((Frame) null, true, (JDialog) this);
        xjdBiometrico.setTemplate(null);
        xjdBiometrico.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_P5_WebActionPerformed(ActionEvent evt) {
        this.p5 = this.JCH_P5_Web.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void grabar() {
        if (this.JLB_NRegistro.getText().isEmpty()) {
            if (validateRadioButtonGroupWithLoop(this.JPI_Respuesta)) {
                if (validateRadioButtonGroupWithLoop(this.JPI_Preguntas)) {
                    if (!Objects.isNull(this.registroUsuario.getFirma()) && !this.registroUsuario.getFirma().isEmpty()) {
                        try {
                            this.registroUsuario.setCargo(Principal.usuarioSistemaDTO.getNombreCargoUsuario());
                            this.registroUsuario.setFechaOrden(LocalDateTime.now());
                            this.registroUsuario.setIdPersona(this.idPersona);
                            this.registroUsuario.setNombreSede(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
                            this.registroUsuario.setUsuarioSistema(Principal.usuarioSistemaDTO.getNombreUsuario());
                            this.registroUsuario.setEstado(true);
                            List<DetalleCuestionarioDto> list = new ArrayList<>();
                            DetalleCuestionarioDto rp1 = DetalleCuestionarioDto.builder().pregunta(this.JLB_Pregunta1.getText()).respuesta(this.p1).build();
                            list.add(rp1);
                            DetalleCuestionarioDto rp2 = DetalleCuestionarioDto.builder().pregunta(this.JLB_Pregunta2.getText()).respuesta(this.p2).build();
                            list.add(rp2);
                            DetalleCuestionarioDto rp3 = DetalleCuestionarioDto.builder().pregunta(this.JLB_Pregunta3.getText()).respuesta(this.p3).build();
                            list.add(rp3);
                            DetalleCuestionarioDto rp4 = DetalleCuestionarioDto.builder().pregunta(this.JLB_Pregunta4.getText()).respuesta(this.p4).build();
                            list.add(rp4);
                            DetalleCuestionarioDto rp5 = DetalleCuestionarioDto.builder().pregunta(this.JLB_Pregunta5.getText()).respuesta(this.p5).build();
                            list.add(rp5);
                            this.registroUsuario.setPreguntas(list);
                            MetodosHttp metodosHttp = new MetodosHttp();
                            EncuestaRegistroUsuario response = (EncuestaRegistroUsuario) metodosHttp.postRequest(EncuestaRegistroUsuario.class, this.registroUsuario, "5", "registroEncuesta");
                            ObjectMapper mapper = this.metodos.getMapper();
                            EncuestaRegistroUsuario response2 = (EncuestaRegistroUsuario) mapper.convertValue(response, EncuestaRegistroUsuario.class);
                            if (response2 != null) {
                                this.JLB_NRegistro.setText("" + response2.getId());
                            } else {
                                this.JLB_NRegistro.setText("");
                            }
                            System.out.println("" + this.metodos.getMapper().writeValueAsString(response2));
                            if (Principal.clasefacturacion != null) {
                                System.out.println("estro  a dejar la informcaion");
                                Principal.clasefacturacion.frmFacturac.setEncuestaRegistroUsuario(this.registroUsuario);
                                Principal.clasefacturacion.frmFacturac.getEncuestaRegistroUsuario().setId(response2.getId());
                            }
                            dispose();
                            return;
                        } catch (JsonProcessingException e) {
                            Logger.getLogger(JD_EncuestaIngreso.class.getName()).log(Level.SEVERE, (String) null, e);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(this, "No existe registro de firma", "VALIDACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleecionar al menos una opción", "VALIDACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Falta seleccionar respuesta", "VALIDACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    public static boolean validateRadioButtonGroupWithLoop(JPanel panel) {
        int numeroElemento = 0;
        int forma = 0;
        for (JRadioButton jRadioButton : panel.getComponents()) {
            if (jRadioButton instanceof JRadioButton) {
                forma = 1;
                JRadioButton radioButton = jRadioButton;
                if (radioButton.isSelected()) {
                    System.out.println("numero : " + numeroElemento);
                    numeroElemento++;
                }
            }
            if (jRadioButton instanceof JCheckBox) {
                forma = 2;
                JCheckBox radioButton2 = (JCheckBox) jRadioButton;
                if (radioButton2.isSelected()) {
                    System.out.println("numero : " + numeroElemento);
                    numeroElemento++;
                }
            }
        }
        if (forma == 1 && numeroElemento == 4) {
            return true;
        }
        if (forma == 2 && numeroElemento == 1) {
            return true;
        }
        return false;
    }

    public void setArchivo(File archivo) {
        try {
            this.registroUsuario.setFirma(Metodos.encodeFileToBase64Binary(archivo.getAbsolutePath()));
        } catch (IOException ex) {
            Logger.getLogger(JD_EncuestaIngreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void setArchivoHuella(File archivo) {
        try {
            this.registroUsuario.setHuella(Metodos.encodeFileToBase64Binary(archivo.getAbsolutePath()));
        } catch (IOException ex) {
            Logger.getLogger(JD_EncuestaIngreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
