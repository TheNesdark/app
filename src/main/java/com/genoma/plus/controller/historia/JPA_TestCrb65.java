package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.EscalaCrb65DTO;
import com.genoma.plus.jpa.service.IEscalaCrb65Service;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPA_TestCrb65.class */
public class JPA_TestCrb65 extends JPanel {
    private String interpretacion;
    private String recomendacion;
    private Long idAtencion;
    private final IEscalaCrb65Service escalaCrb65Service = (IEscalaCrb65Service) Principal.contexto.getBean(IEscalaCrb65Service.class);
    private Metodos metodos = new Metodos();
    private Integer puntaje = 0;
    private EscalaCrb65DTO escalaCrb65DTO;
    ButtonGroup JBG_Filtro;
    JCheckBox JCH_Respuesta1;
    JCheckBox JCH_Respuesta2;
    JCheckBox JCH_Respuesta3;
    JCheckBox JCH_Respuesta4;
    JLabel JLB_Conducta1;
    JLabel JLB_Conducta2;
    JLabel JLB_Id;
    JLabel JLB_Pregunta1;
    JLabel JLB_Pregunta2;
    JLabel JLB_Pregunta3;
    JLabel JLB_Pregunta4;
    JLabel JLB_Puntuacion;
    JPanel JPI_Preguntas;
    JPanel JPI_Respuestas;
    JRadioButton JRB_Puntaje0;
    JRadioButton JRB_Puntaje1;
    JRadioButton JRB_Puntaje2;
    JRadioButton JRB_Puntaje3;
    JRadioButton JRB_Puntaje4;
    JScrollPane JSPObservacion;
    JTextArea JTAObservacion;

    @Generated
    public void setInterpretacion(String interpretacion) {
        this.interpretacion = interpretacion;
    }

    @Generated
    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    @Generated
    public void setIdAtencion(Long idAtencion) {
        this.idAtencion = idAtencion;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    @Generated
    public void setEscalaCrb65DTO(EscalaCrb65DTO escalaCrb65DTO) {
        this.escalaCrb65DTO = escalaCrb65DTO;
    }

    @Generated
    public void setJBG_Filtro(ButtonGroup JBG_Filtro) {
        this.JBG_Filtro = JBG_Filtro;
    }

    @Generated
    public void setJCH_Respuesta1(JCheckBox JCH_Respuesta1) {
        this.JCH_Respuesta1 = JCH_Respuesta1;
    }

    @Generated
    public void setJCH_Respuesta2(JCheckBox JCH_Respuesta2) {
        this.JCH_Respuesta2 = JCH_Respuesta2;
    }

    @Generated
    public void setJCH_Respuesta3(JCheckBox JCH_Respuesta3) {
        this.JCH_Respuesta3 = JCH_Respuesta3;
    }

    @Generated
    public void setJCH_Respuesta4(JCheckBox JCH_Respuesta4) {
        this.JCH_Respuesta4 = JCH_Respuesta4;
    }

    @Generated
    public void setJLB_Conducta1(JLabel JLB_Conducta1) {
        this.JLB_Conducta1 = JLB_Conducta1;
    }

    @Generated
    public void setJLB_Conducta2(JLabel JLB_Conducta2) {
        this.JLB_Conducta2 = JLB_Conducta2;
    }

    @Generated
    public void setJLB_Id(JLabel JLB_Id) {
        this.JLB_Id = JLB_Id;
    }

    @Generated
    public void setJLB_Pregunta1(JLabel JLB_Pregunta1) {
        this.JLB_Pregunta1 = JLB_Pregunta1;
    }

    @Generated
    public void setJLB_Pregunta2(JLabel JLB_Pregunta2) {
        this.JLB_Pregunta2 = JLB_Pregunta2;
    }

    @Generated
    public void setJLB_Pregunta3(JLabel JLB_Pregunta3) {
        this.JLB_Pregunta3 = JLB_Pregunta3;
    }

    @Generated
    public void setJLB_Pregunta4(JLabel JLB_Pregunta4) {
        this.JLB_Pregunta4 = JLB_Pregunta4;
    }

    @Generated
    public void setJLB_Puntuacion(JLabel JLB_Puntuacion) {
        this.JLB_Puntuacion = JLB_Puntuacion;
    }

    @Generated
    public void setJPI_Preguntas(JPanel JPI_Preguntas) {
        this.JPI_Preguntas = JPI_Preguntas;
    }

    @Generated
    public void setJPI_Respuestas(JPanel JPI_Respuestas) {
        this.JPI_Respuestas = JPI_Respuestas;
    }

    @Generated
    public void setJRB_Puntaje0(JRadioButton JRB_Puntaje0) {
        this.JRB_Puntaje0 = JRB_Puntaje0;
    }

    @Generated
    public void setJRB_Puntaje1(JRadioButton JRB_Puntaje1) {
        this.JRB_Puntaje1 = JRB_Puntaje1;
    }

    @Generated
    public void setJRB_Puntaje2(JRadioButton JRB_Puntaje2) {
        this.JRB_Puntaje2 = JRB_Puntaje2;
    }

    @Generated
    public void setJRB_Puntaje3(JRadioButton JRB_Puntaje3) {
        this.JRB_Puntaje3 = JRB_Puntaje3;
    }

    @Generated
    public void setJRB_Puntaje4(JRadioButton JRB_Puntaje4) {
        this.JRB_Puntaje4 = JRB_Puntaje4;
    }

    @Generated
    public void setJSPObservacion(JScrollPane JSPObservacion) {
        this.JSPObservacion = JSPObservacion;
    }

    @Generated
    public void setJTAObservacion(JTextArea JTAObservacion) {
        this.JTAObservacion = JTAObservacion;
    }

    @Generated
    public String getInterpretacion() {
        return this.interpretacion;
    }

    @Generated
    public String getRecomendacion() {
        return this.recomendacion;
    }

    @Generated
    public Long getIdAtencion() {
        return this.idAtencion;
    }

    @Generated
    public IEscalaCrb65Service getEscalaCrb65Service() {
        return this.escalaCrb65Service;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public Integer getPuntaje() {
        return this.puntaje;
    }

    @Generated
    public EscalaCrb65DTO getEscalaCrb65DTO() {
        return this.escalaCrb65DTO;
    }

    public JPA_TestCrb65(Long idAtencion) {
        initComponents();
        setIdAtencion(idAtencion);
        nuevo();
    }

    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_Preguntas = new JPanel();
        this.JLB_Pregunta1 = new JLabel();
        this.JLB_Pregunta2 = new JLabel();
        this.JLB_Pregunta3 = new JLabel();
        this.JLB_Pregunta4 = new JLabel();
        this.JCH_Respuesta1 = new JCheckBox();
        this.JCH_Respuesta2 = new JCheckBox();
        this.JCH_Respuesta3 = new JCheckBox();
        this.JCH_Respuesta4 = new JCheckBox();
        this.JPI_Respuestas = new JPanel();
        this.JRB_Puntaje0 = new JRadioButton();
        this.JRB_Puntaje1 = new JRadioButton();
        this.JRB_Puntaje2 = new JRadioButton();
        this.JRB_Puntaje3 = new JRadioButton();
        this.JRB_Puntaje4 = new JRadioButton();
        this.JLB_Conducta1 = new JLabel();
        this.JLB_Conducta2 = new JLabel();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLB_Puntuacion = new JLabel();
        this.JLB_Id = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ESCALA CRB-65. (Sistema evaluación gravedad en Neumonía Adquirida en la Comunidad)", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setFont(new Font("Arial", 1, 14));
        setName("jpa_TestCrb65");
        this.JPI_Preguntas.setBorder(BorderFactory.createTitledBorder((Border) null, "CRITERIOS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JLB_Pregunta1.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta1.setText("El enfermo presenta confusión?");
        this.JLB_Pregunta2.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta2.setText("Frecuencia respiratoria mayor o igual que 30/m?");
        this.JLB_Pregunta3.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta3.setText("Tensión arterial sistólica < 90 mm Hg o Tensión arterial diastóslica menor o igual a 60 mm Hg?");
        this.JLB_Pregunta4.setFont(new Font("Arial", 1, 12));
        this.JLB_Pregunta4.setText("Edad es igual o mayor que 65 años?");
        this.JCH_Respuesta1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_TestCrb65.1
            public void actionPerformed(ActionEvent evt) {
                JPA_TestCrb65.this.JCH_Respuesta1ActionPerformed(evt);
            }
        });
        this.JCH_Respuesta2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_TestCrb65.2
            public void actionPerformed(ActionEvent evt) {
                JPA_TestCrb65.this.JCH_Respuesta2ActionPerformed(evt);
            }
        });
        this.JCH_Respuesta3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_TestCrb65.3
            public void actionPerformed(ActionEvent evt) {
                JPA_TestCrb65.this.JCH_Respuesta3ActionPerformed(evt);
            }
        });
        this.JCH_Respuesta4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_TestCrb65.4
            public void actionPerformed(ActionEvent evt) {
                JPA_TestCrb65.this.JCH_Respuesta4ActionPerformed(evt);
            }
        });
        GroupLayout JPI_PreguntasLayout = new GroupLayout(this.JPI_Preguntas);
        this.JPI_Preguntas.setLayout(JPI_PreguntasLayout);
        JPI_PreguntasLayout.setHorizontalGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PreguntasLayout.createSequentialGroup().addGap(26, 26, 26).addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Pregunta1, -2, 501, -2).addComponent(this.JLB_Pregunta4, -2, 501, -2).addComponent(this.JLB_Pregunta2, -2, 501, -2).addComponent(this.JLB_Pregunta3, -2, 561, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 171, 32767).addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Respuesta1).addComponent(this.JCH_Respuesta2).addComponent(this.JCH_Respuesta3).addComponent(this.JCH_Respuesta4)).addGap(28, 28, 28)));
        JPI_PreguntasLayout.setVerticalGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PreguntasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCH_Respuesta1, -1, -1, 32767).addComponent(this.JLB_Pregunta1, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCH_Respuesta2, -1, 32, 32767).addComponent(this.JLB_Pregunta2, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Respuesta3, -1, 32, 32767).addComponent(this.JLB_Pregunta3, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_PreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Respuesta4, -1, 32, 32767).addComponent(this.JLB_Pregunta4, -1, -1, 32767)).addContainerGap()));
        this.JPI_Respuestas.setBorder(BorderFactory.createTitledBorder((Border) null, "PUNTUACIÓN, RIESGO Y  CONDUCTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBG_Filtro.add(this.JRB_Puntaje0);
        this.JRB_Puntaje0.setFont(new Font("Arial", 1, 12));
        this.JRB_Puntaje0.setSelected(true);
        this.JRB_Puntaje0.setText("0  - Riesgo bajo (0.9 mortalidad)");
        this.JBG_Filtro.add(this.JRB_Puntaje1);
        this.JRB_Puntaje1.setFont(new Font("Arial", 1, 12));
        this.JRB_Puntaje1.setText("1  - Riesgo moderado (5.2% mortalidad )");
        this.JBG_Filtro.add(this.JRB_Puntaje2);
        this.JRB_Puntaje2.setFont(new Font("Arial", 1, 12));
        this.JRB_Puntaje2.setText("2  - Riesgo elevado (12.2% mortalidad )");
        this.JBG_Filtro.add(this.JRB_Puntaje3);
        this.JRB_Puntaje3.setFont(new Font("Arial", 1, 12));
        this.JRB_Puntaje3.setText("3  - Riesgo alto (31.2% mortalidad )");
        this.JBG_Filtro.add(this.JRB_Puntaje4);
        this.JRB_Puntaje4.setFont(new Font("Arial", 1, 12));
        this.JRB_Puntaje4.setText("4  - Riesgo alto (31.2% mortalidad )");
        this.JLB_Conducta1.setBackground(new Color(255, 255, 255));
        this.JLB_Conducta1.setFont(new Font("Arial", 1, 14));
        this.JLB_Conducta1.setHorizontalAlignment(0);
        this.JLB_Conducta1.setText("Atención  domiciliaria");
        this.JLB_Conducta1.setHorizontalTextPosition(0);
        this.JLB_Conducta1.setOpaque(true);
        this.JLB_Conducta2.setBackground(Color.red);
        this.JLB_Conducta2.setFont(new Font("Arial", 1, 14));
        this.JLB_Conducta2.setForeground(new Color(255, 255, 255));
        this.JLB_Conducta2.setHorizontalAlignment(0);
        this.JLB_Conducta2.setText("Requiere hospitalización");
        this.JLB_Conducta2.setHorizontalTextPosition(0);
        this.JLB_Conducta2.setOpaque(true);
        GroupLayout JPI_RespuestasLayout = new GroupLayout(this.JPI_Respuestas);
        this.JPI_Respuestas.setLayout(JPI_RespuestasLayout);
        JPI_RespuestasLayout.setHorizontalGroup(JPI_RespuestasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RespuestasLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPI_RespuestasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_Puntaje0, -1, -1, 32767).addComponent(this.JRB_Puntaje1, -1, -1, 32767).addComponent(this.JRB_Puntaje2, -1, -1, 32767).addComponent(this.JRB_Puntaje3, -1, -1, 32767).addComponent(this.JRB_Puntaje4, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPI_RespuestasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Conducta1, GroupLayout.Alignment.TRAILING, -2, 231, -2).addComponent(this.JLB_Conducta2, GroupLayout.Alignment.TRAILING, -2, 231, -2)).addContainerGap()));
        JPI_RespuestasLayout.setVerticalGroup(JPI_RespuestasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RespuestasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RespuestasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRB_Puntaje0).addComponent(this.JLB_Conducta1, -2, 32, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_RespuestasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RespuestasLayout.createSequentialGroup().addComponent(this.JRB_Puntaje1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Puntaje2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Puntaje3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Puntaje4).addGap(0, 0, 32767)).addComponent(this.JLB_Conducta2, -1, -1, 32767)).addContainerGap()));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JLB_Puntuacion.setFont(new Font("Arial", 1, 24));
        this.JLB_Puntuacion.setForeground(Color.red);
        this.JLB_Puntuacion.setHorizontalAlignment(0);
        this.JLB_Puntuacion.setBorder(BorderFactory.createTitledBorder((Border) null, "PUNTAJE", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_Id.setFont(new Font("Arial", 1, 14));
        this.JLB_Id.setHorizontalAlignment(0);
        this.JLB_Id.setBorder(BorderFactory.createTitledBorder((Border) null, "ID", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Preguntas, -1, -1, 32767).addComponent(this.JPI_Respuestas, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JSPObservacion, -2, 506, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_Puntuacion, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_Id, -2, 127, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JPI_Preguntas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_Respuestas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPObservacion).addComponent(this.JLB_Puntuacion, -1, -1, 32767).addComponent(this.JLB_Id, -1, -1, 32767)).addContainerGap(14, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Respuesta1ActionPerformed(ActionEvent evt) {
        calcularPuntaje();
        getEscalaCrb65DTO().setPregunta1(Boolean.valueOf(this.JCH_Respuesta1.isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Respuesta2ActionPerformed(ActionEvent evt) {
        calcularPuntaje();
        getEscalaCrb65DTO().setPregunta2(Boolean.valueOf(this.JCH_Respuesta2.isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Respuesta3ActionPerformed(ActionEvent evt) {
        calcularPuntaje();
        getEscalaCrb65DTO().setPregunta3(Boolean.valueOf(this.JCH_Respuesta3.isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Respuesta4ActionPerformed(ActionEvent evt) {
        calcularPuntaje();
        getEscalaCrb65DTO().setPregunta4(Boolean.valueOf(this.JCH_Respuesta4.isSelected()));
    }

    private void establecerColorDefectoCheckBox() {
        for (int i = 0; i < this.JPI_Respuestas.getComponentCount(); i++) {
            if (this.JPI_Respuestas.getComponent(i).getClass().toString().equals("class javax.swing.JRadioButton")) {
                JRadioButton jch = this.JPI_Respuestas.getComponent(i);
                if (!jch.isSelected()) {
                    jch.setBackground(new Color(238, 238, 238));
                    jch.setForeground(new Color(0, 0, 0));
                }
            }
        }
    }

    private void calcularPuntaje() {
        setPuntaje(0);
        for (int i = 0; i < this.JPI_Preguntas.getComponentCount(); i++) {
            if (this.JPI_Preguntas.getComponent(i).getClass().toString().equals("class javax.swing.JCheckBox")) {
                JCheckBox jch = this.JPI_Preguntas.getComponent(i);
                if (jch.isSelected()) {
                    Integer num = this.puntaje;
                    this.puntaje = Integer.valueOf(this.puntaje.intValue() + 1);
                }
            }
        }
        this.JLB_Puntuacion.setText("" + getPuntaje());
        switch (getPuntaje().intValue()) {
            case 0:
                this.JRB_Puntaje0.setSelected(true);
                setInterpretacion(this.JRB_Puntaje0.getText().substring(5, this.JRB_Puntaje0.getText().length()));
                setRecomendacion(this.JLB_Conducta1.getText());
                this.JRB_Puntaje0.setBackground(Color.white);
                this.JRB_Puntaje0.setForeground(new Color(0, 0, 0));
                this.JLB_Conducta1.setVisible(true);
                this.JLB_Conducta2.setVisible(false);
                establecerColorDefectoCheckBox();
                break;
            case 1:
                this.JRB_Puntaje1.setSelected(true);
                setInterpretacion(this.JRB_Puntaje1.getText().substring(5, this.JRB_Puntaje1.getText().length()));
                setRecomendacion(this.JLB_Conducta2.getText());
                this.JRB_Puntaje1.setBackground(new Color(0, 103, 0));
                this.JRB_Puntaje1.setForeground(new Color(255, 255, 255));
                this.JLB_Conducta2.setVisible(true);
                this.JLB_Conducta1.setVisible(false);
                establecerColorDefectoCheckBox();
                break;
            case 2:
                this.JRB_Puntaje2.setSelected(true);
                setInterpretacion(this.JRB_Puntaje2.getText().substring(5, this.JRB_Puntaje2.getText().length()));
                setRecomendacion(this.JLB_Conducta2.getText());
                this.JRB_Puntaje2.setBackground(Color.orange);
                this.JRB_Puntaje2.setForeground(new Color(0, 0, 0));
                this.JLB_Conducta2.setVisible(true);
                this.JLB_Conducta1.setVisible(false);
                establecerColorDefectoCheckBox();
                break;
            case 3:
                this.JRB_Puntaje3.setSelected(true);
                setInterpretacion(this.JRB_Puntaje3.getText().substring(5, this.JRB_Puntaje3.getText().length()));
                setRecomendacion(this.JLB_Conducta2.getText());
                this.JRB_Puntaje3.setBackground(Color.red);
                this.JRB_Puntaje3.setForeground(new Color(255, 255, 255));
                this.JLB_Conducta2.setVisible(true);
                this.JLB_Conducta1.setVisible(false);
                establecerColorDefectoCheckBox();
                break;
            case 4:
                this.JRB_Puntaje4.setSelected(true);
                setInterpretacion(this.JRB_Puntaje4.getText().substring(5, this.JRB_Puntaje4.getText().length()));
                setRecomendacion(this.JLB_Conducta2.getText());
                this.JRB_Puntaje4.setBackground(Color.red);
                this.JRB_Puntaje4.setForeground(new Color(255, 255, 255));
                this.JLB_Conducta2.setVisible(true);
                this.JLB_Conducta1.setVisible(false);
                establecerColorDefectoCheckBox();
                break;
        }
    }

    public void nuevo() {
        calcularPuntaje();
        if (calcularEdad().intValue() >= 65) {
            this.JCH_Respuesta4.setSelected(true);
        }
        setEscalaCrb65DTO(getEscalaCrb65Service().escalaPorIdAtencionAndEstado(getIdAtencion(), true));
        if (getEscalaCrb65DTO() == null) {
            this.escalaCrb65DTO = EscalaCrb65DTO.builder().pregunta1(Boolean.valueOf(this.JCH_Respuesta1.isSelected())).pregunta2(Boolean.valueOf(this.JCH_Respuesta2.isSelected())).pregunta3(Boolean.valueOf(this.JCH_Respuesta3.isSelected())).pregunta4(Boolean.valueOf(this.JCH_Respuesta4.isSelected())).interpretacion(getInterpretacion()).observacion(this.JTAObservacion.getText()).recomendacion(getRecomendacion()).estado(true).fecha(getMetodos().getFechaActual()).fechaTest(getMetodos().getFechaActual()).idAtencion(getIdAtencion()).idEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()).idProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema()).puntaje(Integer.valueOf(this.JLB_Puntuacion.getText())).build();
            return;
        }
        this.JCH_Respuesta1.setSelected(getEscalaCrb65DTO().getPregunta1().booleanValue());
        this.JCH_Respuesta2.setSelected(getEscalaCrb65DTO().getPregunta2().booleanValue());
        this.JCH_Respuesta3.setSelected(getEscalaCrb65DTO().getPregunta3().booleanValue());
        this.JCH_Respuesta4.setSelected(getEscalaCrb65DTO().getPregunta4().booleanValue());
        this.JLB_Id.setText("" + getEscalaCrb65DTO().getId());
        this.JTAObservacion.setText(getEscalaCrb65DTO().getObservacion());
        calcularPuntaje();
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    private Integer calcularEdad() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        return Integer.valueOf(periodo.getYears());
    }

    public void grabar() {
        getEscalaCrb65DTO().setObservacion(this.JTAObservacion.getText());
        getEscalaCrb65DTO().setInterpretacion(getInterpretacion());
        getEscalaCrb65DTO().setRecomendacion(getRecomendacion());
        getEscalaCrb65DTO().setFecha(getMetodos().getFechaActual());
        getEscalaCrb65DTO().setFechaTest(getMetodos().getFechaActual());
        getEscalaCrb65DTO().setPuntaje(Integer.valueOf(this.JLB_Puntuacion.getText()));
        Long id = getEscalaCrb65Service().grabar(getEscalaCrb65DTO());
        this.JLB_Id.setText("" + id);
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    @Generated
    public ButtonGroup getJBG_Filtro() {
        return this.JBG_Filtro;
    }

    @Generated
    public JCheckBox getJCH_Respuesta1() {
        return this.JCH_Respuesta1;
    }

    @Generated
    public JCheckBox getJCH_Respuesta2() {
        return this.JCH_Respuesta2;
    }

    @Generated
    public JCheckBox getJCH_Respuesta3() {
        return this.JCH_Respuesta3;
    }

    @Generated
    public JCheckBox getJCH_Respuesta4() {
        return this.JCH_Respuesta4;
    }

    @Generated
    public JLabel getJLB_Conducta1() {
        return this.JLB_Conducta1;
    }

    @Generated
    public JLabel getJLB_Conducta2() {
        return this.JLB_Conducta2;
    }

    @Generated
    public JLabel getJLB_Id() {
        return this.JLB_Id;
    }

    @Generated
    public JLabel getJLB_Pregunta1() {
        return this.JLB_Pregunta1;
    }

    @Generated
    public JLabel getJLB_Pregunta2() {
        return this.JLB_Pregunta2;
    }

    @Generated
    public JLabel getJLB_Pregunta3() {
        return this.JLB_Pregunta3;
    }

    @Generated
    public JLabel getJLB_Pregunta4() {
        return this.JLB_Pregunta4;
    }

    @Generated
    public JLabel getJLB_Puntuacion() {
        return this.JLB_Puntuacion;
    }

    @Generated
    public JPanel getJPI_Preguntas() {
        return this.JPI_Preguntas;
    }

    @Generated
    public JPanel getJPI_Respuestas() {
        return this.JPI_Respuestas;
    }

    @Generated
    public JRadioButton getJRB_Puntaje0() {
        return this.JRB_Puntaje0;
    }

    @Generated
    public JRadioButton getJRB_Puntaje1() {
        return this.JRB_Puntaje1;
    }

    @Generated
    public JRadioButton getJRB_Puntaje2() {
        return this.JRB_Puntaje2;
    }

    @Generated
    public JRadioButton getJRB_Puntaje3() {
        return this.JRB_Puntaje3;
    }

    @Generated
    public JRadioButton getJRB_Puntaje4() {
        return this.JRB_Puntaje4;
    }

    @Generated
    public JScrollPane getJSPObservacion() {
        return this.JSPObservacion;
    }

    @Generated
    public JTextArea getJTAObservacion() {
        return this.JTAObservacion;
    }
}
