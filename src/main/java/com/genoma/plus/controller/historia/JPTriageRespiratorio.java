package com.genoma.plus.controller.historia;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.TriageRespiratorioDTO;
import com.genoma.plus.jpa.service.ITriageRespiratorioDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPTriageRespiratorio.class */
public class JPTriageRespiratorio extends JPanel {
    private TriageRespiratorioDTO respiratorioDTO;
    private Long idTriage;
    private Long idIngreso;
    private Integer clasificacion;
    private ButtonGroup JBG_Clasificacion;
    private JCheckBox JCH_AntecedenesContactos;
    private JCheckBox JCH_DificultadRespiratorio;
    private JCheckBox JCH_Fatiga;
    private JCheckBox JCH_Fiebre;
    private JCheckBox JCH_Ninguna_Anteriores;
    private JCheckBox JCH_Odinofagia;
    private JCheckBox JCH_SinSintomasRespiratorios;
    private JCheckBox JCH_Tos;
    private JCheckBox JCH_antecedentesOcupacion;
    private JCheckBox JCH_antecedentesViajes;
    private JPanel JPI_Clasificacion;
    private JPanel JPI_Datos;
    private JPanel JPI_Datos1;
    private JRadioButton JRB_Negativo;
    private JRadioButton JRB_Positivo;
    private JRadioButton JRB_Sospechoso;
    private JScrollPane JSPObserE;
    private JTextArea JTAObservacion;
    private final ITriageRespiratorioDAO triageRespiratorioDAO = (ITriageRespiratorioDAO) Principal.contexto.getBean(ITriageRespiratorioDAO.class);
    private Metodos metodos = new Metodos();

    @Generated
    public void setRespiratorioDTO(TriageRespiratorioDTO respiratorioDTO) {
        this.respiratorioDTO = respiratorioDTO;
    }

    @Generated
    public void setIdTriage(Long idTriage) {
        this.idTriage = idTriage;
    }

    @Generated
    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setClasificacion(Integer clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Generated
    public void setJBG_Clasificacion(ButtonGroup JBG_Clasificacion) {
        this.JBG_Clasificacion = JBG_Clasificacion;
    }

    @Generated
    public void setJCH_AntecedenesContactos(JCheckBox JCH_AntecedenesContactos) {
        this.JCH_AntecedenesContactos = JCH_AntecedenesContactos;
    }

    @Generated
    public void setJCH_DificultadRespiratorio(JCheckBox JCH_DificultadRespiratorio) {
        this.JCH_DificultadRespiratorio = JCH_DificultadRespiratorio;
    }

    @Generated
    public void setJCH_Fatiga(JCheckBox JCH_Fatiga) {
        this.JCH_Fatiga = JCH_Fatiga;
    }

    @Generated
    public void setJCH_Fiebre(JCheckBox JCH_Fiebre) {
        this.JCH_Fiebre = JCH_Fiebre;
    }

    @Generated
    public void setJCH_Ninguna_Anteriores(JCheckBox JCH_Ninguna_Anteriores) {
        this.JCH_Ninguna_Anteriores = JCH_Ninguna_Anteriores;
    }

    @Generated
    public void setJCH_Odinofagia(JCheckBox JCH_Odinofagia) {
        this.JCH_Odinofagia = JCH_Odinofagia;
    }

    @Generated
    public void setJCH_SinSintomasRespiratorios(JCheckBox JCH_SinSintomasRespiratorios) {
        this.JCH_SinSintomasRespiratorios = JCH_SinSintomasRespiratorios;
    }

    @Generated
    public void setJCH_Tos(JCheckBox JCH_Tos) {
        this.JCH_Tos = JCH_Tos;
    }

    @Generated
    public void setJCH_antecedentesOcupacion(JCheckBox JCH_antecedentesOcupacion) {
        this.JCH_antecedentesOcupacion = JCH_antecedentesOcupacion;
    }

    @Generated
    public void setJCH_antecedentesViajes(JCheckBox JCH_antecedentesViajes) {
        this.JCH_antecedentesViajes = JCH_antecedentesViajes;
    }

    @Generated
    public void setJPI_Clasificacion(JPanel JPI_Clasificacion) {
        this.JPI_Clasificacion = JPI_Clasificacion;
    }

    @Generated
    public void setJPI_Datos(JPanel JPI_Datos) {
        this.JPI_Datos = JPI_Datos;
    }

    @Generated
    public void setJPI_Datos1(JPanel JPI_Datos1) {
        this.JPI_Datos1 = JPI_Datos1;
    }

    @Generated
    public void setJRB_Negativo(JRadioButton JRB_Negativo) {
        this.JRB_Negativo = JRB_Negativo;
    }

    @Generated
    public void setJRB_Positivo(JRadioButton JRB_Positivo) {
        this.JRB_Positivo = JRB_Positivo;
    }

    @Generated
    public void setJRB_Sospechoso(JRadioButton JRB_Sospechoso) {
        this.JRB_Sospechoso = JRB_Sospechoso;
    }

    @Generated
    public void setJSPObserE(JScrollPane JSPObserE) {
        this.JSPObserE = JSPObserE;
    }

    @Generated
    public void setJTAObservacion(JTextArea JTAObservacion) {
        this.JTAObservacion = JTAObservacion;
    }

    @Generated
    public TriageRespiratorioDTO getRespiratorioDTO() {
        return this.respiratorioDTO;
    }

    @Generated
    public ITriageRespiratorioDAO getTriageRespiratorioDAO() {
        return this.triageRespiratorioDAO;
    }

    @Generated
    public Long getIdTriage() {
        return this.idTriage;
    }

    @Generated
    public Long getIdIngreso() {
        return this.idIngreso;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public Integer getClasificacion() {
        return this.clasificacion;
    }

    public JPTriageRespiratorio(Long idTriage, Long idIngreso, String tituloPanel) {
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, tituloPanel, 0, 0, new Font("Arial", 1, 14), Color.red));
        System.err.println("1 " + idTriage);
        if (idTriage == null) {
            setIdTriage(0L);
        } else {
            setIdTriage(idTriage);
        }
        if (idIngreso == null) {
            setIdIngreso(0L);
        } else {
            setIdIngreso(idIngreso);
        }
        nuevo();
    }

    private void initComponents() {
        this.JBG_Clasificacion = new ButtonGroup();
        this.JPI_Datos = new JPanel();
        this.JCH_Fiebre = new JCheckBox();
        this.JCH_Tos = new JCheckBox();
        this.JCH_DificultadRespiratorio = new JCheckBox();
        this.JCH_Odinofagia = new JCheckBox();
        this.JCH_Fatiga = new JCheckBox();
        this.JCH_SinSintomasRespiratorios = new JCheckBox();
        this.JPI_Datos1 = new JPanel();
        this.JCH_antecedentesViajes = new JCheckBox();
        this.JCH_antecedentesOcupacion = new JCheckBox();
        this.JCH_AntecedenesContactos = new JCheckBox();
        this.JCH_Ninguna_Anteriores = new JCheckBox();
        this.JSPObserE = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JPI_Clasificacion = new JPanel();
        this.JRB_Negativo = new JRadioButton();
        this.JRB_Positivo = new JRadioButton();
        this.JRB_Sospechoso = new JRadioButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 14), Color.red));
        setMaximumSize(new Dimension(884, 292));
        setName("jpTriageRespiratorio");
        setPreferredSize(new Dimension(884, 292));
        this.JPI_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "Usted presenta o ha presentado", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCH_Fiebre.setFont(new Font("Arial", 1, 12));
        this.JCH_Fiebre.setText("Fiebre");
        this.JCH_Fiebre.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.1
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_FiebreActionPerformed(evt);
            }
        });
        this.JCH_Tos.setFont(new Font("Arial", 1, 12));
        this.JCH_Tos.setText("Tos");
        this.JCH_Tos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.2
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_TosActionPerformed(evt);
            }
        });
        this.JCH_DificultadRespiratorio.setFont(new Font("Arial", 1, 12));
        this.JCH_DificultadRespiratorio.setText("Dificultad Respiratoria");
        this.JCH_DificultadRespiratorio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.3
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_DificultadRespiratorioActionPerformed(evt);
            }
        });
        this.JCH_Odinofagia.setFont(new Font("Arial", 1, 12));
        this.JCH_Odinofagia.setText("Odinofagia");
        this.JCH_Odinofagia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.4
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_OdinofagiaActionPerformed(evt);
            }
        });
        this.JCH_Fatiga.setFont(new Font("Arial", 1, 12));
        this.JCH_Fatiga.setText("Fatiga/Adinamia");
        this.JCH_Fatiga.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.5
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_FatigaActionPerformed(evt);
            }
        });
        this.JCH_SinSintomasRespiratorios.setFont(new Font("Arial", 1, 12));
        this.JCH_SinSintomasRespiratorios.setText("Sin sintomas respiratorios");
        this.JCH_SinSintomasRespiratorios.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.6
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_SinSintomasRespiratoriosActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Fiebre).addGap(31, 31, 31).addComponent(this.JCH_Tos).addGap(40, 40, 40).addComponent(this.JCH_DificultadRespiratorio).addGap(29, 29, 29).addComponent(this.JCH_Odinofagia).addGap(26, 26, 26).addComponent(this.JCH_Fatiga).addGap(18, 18, 18).addComponent(this.JCH_SinSintomasRespiratorios).addContainerGap(-1, 32767)));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Fiebre).addComponent(this.JCH_Tos).addComponent(this.JCH_DificultadRespiratorio).addComponent(this.JCH_Odinofagia).addComponent(this.JCH_Fatiga).addComponent(this.JCH_SinSintomasRespiratorios)).addContainerGap(-1, 32767)));
        this.JPI_Datos1.setBorder(BorderFactory.createTitledBorder((Border) null, "Usted tiene antecedentes de:", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCH_antecedentesViajes.setFont(new Font("Arial", 1, 12));
        this.JCH_antecedentesViajes.setText("<html><P ALIGN=center>Historial de viaje o que haya vivido en un pais o área con circulación viral confirmada del nuevo coronavirus (SARS-CoV-2) en los 14 dias anteriores al inicio de los síntomas.");
        this.JCH_antecedentesViajes.setActionCommand("Historial de viaje o que haya vivido en un pais o área con circulación viral confirmada del nuevo coronavirus (SARS-CoV-2) en los 14 dias anteriores al inicio de los síntomas.");
        this.JCH_antecedentesViajes.setHorizontalAlignment(11);
        this.JCH_antecedentesViajes.setVerticalTextPosition(1);
        this.JCH_antecedentesViajes.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.7
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_antecedentesViajesActionPerformed(evt);
            }
        });
        this.JCH_antecedentesOcupacion.setFont(new Font("Arial", 1, 12));
        this.JCH_antecedentesOcupacion.setText("<html><P ALIGN=center>Una ocupación como trabajador de la salud u  otro personal que labora en un entorno que atiende pacientes con IRAG con etiología desconocida.");
        this.JCH_antecedentesOcupacion.setVerticalTextPosition(1);
        this.JCH_antecedentesOcupacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.8
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_antecedentesOcupacionActionPerformed(evt);
            }
        });
        this.JCH_AntecedenesContactos.setFont(new Font("Arial", 1, 12));
        this.JCH_AntecedenesContactos.setText("<html><P ALIGN=center>Contacto estrecho en los últimos 14 días con un caso probable o  confirmado de infección respiratoria aguda grave por el nuevo coronavirus.");
        this.JCH_AntecedenesContactos.setVerticalTextPosition(1);
        this.JCH_AntecedenesContactos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.9
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_AntecedenesContactosActionPerformed(evt);
            }
        });
        this.JCH_Ninguna_Anteriores.setFont(new Font("Arial", 1, 12));
        this.JCH_Ninguna_Anteriores.setText("     Ninguna de las anteriores");
        this.JCH_Ninguna_Anteriores.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.10
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JCH_Ninguna_AnterioresActionPerformed(evt);
            }
        });
        GroupLayout JPI_Datos1Layout = new GroupLayout(this.JPI_Datos1);
        this.JPI_Datos1.setLayout(JPI_Datos1Layout);
        JPI_Datos1Layout.setHorizontalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_AntecedenesContactos, GroupLayout.Alignment.TRAILING).addComponent(this.JCH_antecedentesOcupacion, GroupLayout.Alignment.TRAILING).addGroup(JPI_Datos1Layout.createSequentialGroup().addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Ninguna_Anteriores, -2, 759, -2).addComponent(this.JCH_antecedentesViajes, -2, 848, -2)).addGap(0, 0, 32767))).addContainerGap()));
        JPI_Datos1Layout.setVerticalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addComponent(this.JCH_antecedentesViajes, -2, 33, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_antecedentesOcupacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_AntecedenesContactos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Ninguna_Anteriores)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObserE.setViewportView(this.JTAObservacion);
        this.JPI_Clasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Clasificacion.add(this.JRB_Negativo);
        this.JRB_Negativo.setFont(new Font("Arial", 1, 12));
        this.JRB_Negativo.setSelected(true);
        this.JRB_Negativo.setText("Negativo");
        this.JRB_Negativo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.11
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JRB_NegativoActionPerformed(evt);
            }
        });
        this.JBG_Clasificacion.add(this.JRB_Positivo);
        this.JRB_Positivo.setFont(new Font("Arial", 1, 12));
        this.JRB_Positivo.setText("Positivo");
        this.JRB_Positivo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.12
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JRB_PositivoActionPerformed(evt);
            }
        });
        this.JBG_Clasificacion.add(this.JRB_Sospechoso);
        this.JRB_Sospechoso.setFont(new Font("Arial", 1, 12));
        this.JRB_Sospechoso.setText("Sospechoso");
        this.JRB_Sospechoso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio.13
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio.this.JRB_SospechosoActionPerformed(evt);
            }
        });
        GroupLayout JPI_ClasificacionLayout = new GroupLayout(this.JPI_Clasificacion);
        this.JPI_Clasificacion.setLayout(JPI_ClasificacionLayout);
        JPI_ClasificacionLayout.setHorizontalGroup(JPI_ClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ClasificacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Negativo, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Positivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Sospechoso).addContainerGap(-1, 32767)));
        JPI_ClasificacionLayout.setVerticalGroup(JPI_ClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ClasificacionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ClasificacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Negativo).addComponent(this.JRB_Positivo).addComponent(this.JRB_Sospechoso)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_Datos, -1, -1, 32767).addComponent(this.JPI_Datos1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JSPObserE, -2, 519, -2).addGap(56, 56, 56).addComponent(this.JPI_Clasificacion, -1, -1, 32767).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPI_Datos, -2, 58, -2).addGap(5, 5, 5).addComponent(this.JPI_Datos1, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Clasificacion, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JSPObserE, -2, 55, -2))).addContainerGap(16, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiebreActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setFiebre(Boolean.valueOf(getJCH_Fiebre().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_TosActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setTos(Boolean.valueOf(getJCH_Tos().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_DificultadRespiratorioActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setDificultad_Respiratioria(Boolean.valueOf(getJCH_DificultadRespiratorio().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_OdinofagiaActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setOdinofagia(Boolean.valueOf(getJCH_Odinofagia().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FatigaActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setFatiga(Boolean.valueOf(getJCH_Fatiga().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_antecedentesViajesActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setAntecedente_Viaje(Boolean.valueOf(getJCH_antecedentesViajes().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_antecedentesOcupacionActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setAntecedente_IRAG(Boolean.valueOf(getJCH_antecedentesOcupacion().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AntecedenesContactosActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setAntecedente_Contacto(Boolean.valueOf(getJCH_AntecedenesContactos().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SinSintomasRespiratoriosActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setSin_sintomas_respiratorios(Boolean.valueOf(getJCH_SinSintomasRespiratorios().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Ninguna_AnterioresActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setNinguna_anteriores(Boolean.valueOf(getJCH_Ninguna_Anteriores().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_NegativoActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setClasificacion(0);
        setClasificacion(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_PositivoActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setClasificacion(2);
        setClasificacion(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_SospechosoActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setClasificacion(1);
        setClasificacion(1);
    }

    public void nuevo() {
        if (getIdIngreso().longValue() == 0) {
            if (getIdTriage().longValue() == 0) {
                this.respiratorioDTO = getTriageRespiratorioDAO().consultarTriageidIngreso(getIdIngreso());
            } else {
                this.respiratorioDTO = getTriageRespiratorioDAO().consultarTriageid(getIdTriage());
            }
            if (this.respiratorioDTO == null) {
                this.respiratorioDTO = TriageRespiratorioDTO.builder().fiebre(Boolean.valueOf(getJCH_Fiebre().isSelected())).tos(Boolean.valueOf(getJCH_Tos().isSelected())).dificultad_Respiratioria(Boolean.valueOf(getJCH_DificultadRespiratorio().isSelected())).odinofagia(Boolean.valueOf(getJCH_Odinofagia().isSelected())).fatiga(Boolean.valueOf(getJCH_Fatiga().isSelected())).antecedente_Viaje(Boolean.valueOf(getJCH_antecedentesViajes().isSelected())).antecedente_IRAG(Boolean.valueOf(getJCH_antecedentesOcupacion().isSelected())).antecedente_Contacto(Boolean.valueOf(getJCH_AntecedenesContactos().isSelected())).observacion(getJTAObservacion().getText()).estado(true).idIngreso(getIdIngreso()).sin_sintomas_respiratorios(Boolean.valueOf(getJCH_SinSintomasRespiratorios().isSelected())).ninguna_anteriores(Boolean.valueOf(getJCH_Ninguna_Anteriores().isSelected())).idTriage(getIdTriage()).clasificacion(getClasificacion()).build();
            } else {
                this.JCH_Tos.setSelected(this.respiratorioDTO.getTos().booleanValue());
                this.JCH_Fiebre.setSelected(this.respiratorioDTO.getFiebre().booleanValue());
                this.JCH_Fatiga.setSelected(this.respiratorioDTO.getFatiga().booleanValue());
                this.JCH_Odinofagia.setSelected(this.respiratorioDTO.getOdinofagia().booleanValue());
                this.JCH_DificultadRespiratorio.setSelected(this.respiratorioDTO.getTos().booleanValue());
                this.JCH_AntecedenesContactos.setSelected(this.respiratorioDTO.getAntecedente_Contacto().booleanValue());
                this.JCH_antecedentesOcupacion.setSelected(this.respiratorioDTO.getAntecedente_IRAG().booleanValue());
                this.JCH_antecedentesViajes.setSelected(this.respiratorioDTO.getAntecedente_Viaje().booleanValue());
                this.JTAObservacion.setText(this.respiratorioDTO.getObservacion());
                this.JCH_SinSintomasRespiratorios.setSelected(this.respiratorioDTO.getSin_sintomas_respiratorios().booleanValue());
                this.JCH_Ninguna_Anteriores.setSelected(this.respiratorioDTO.getNinguna_anteriores().booleanValue());
                setClasificacion(this.respiratorioDTO.getClasificacion());
                switch (this.respiratorioDTO.getClasificacion().intValue()) {
                    case 0:
                        this.JRB_Negativo.setSelected(true);
                        break;
                    case 1:
                        this.JRB_Sospechoso.setSelected(true);
                        break;
                    default:
                        this.JRB_Positivo.setSelected(true);
                        break;
                }
                this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
        }
        if (getIdTriage().longValue() == 0) {
            this.respiratorioDTO = getTriageRespiratorioDAO().consultarTriageidIngreso(getIdIngreso());
        }
        if (this.respiratorioDTO == null) {
            this.respiratorioDTO = TriageRespiratorioDTO.builder().fiebre(Boolean.valueOf(getJCH_Fiebre().isSelected())).tos(Boolean.valueOf(getJCH_Tos().isSelected())).dificultad_Respiratioria(Boolean.valueOf(getJCH_DificultadRespiratorio().isSelected())).odinofagia(Boolean.valueOf(getJCH_Odinofagia().isSelected())).fatiga(Boolean.valueOf(getJCH_Fatiga().isSelected())).antecedente_Viaje(Boolean.valueOf(getJCH_antecedentesViajes().isSelected())).antecedente_IRAG(Boolean.valueOf(getJCH_antecedentesOcupacion().isSelected())).antecedente_Contacto(Boolean.valueOf(getJCH_AntecedenesContactos().isSelected())).observacion(getJTAObservacion().getText()).estado(true).idIngreso(getIdIngreso()).sin_sintomas_respiratorios(Boolean.valueOf(getJCH_SinSintomasRespiratorios().isSelected())).ninguna_anteriores(Boolean.valueOf(getJCH_Ninguna_Anteriores().isSelected())).clasificacion(getClasificacion()).idTriage(getIdTriage()).build();
            return;
        }
        this.JCH_Tos.setSelected(this.respiratorioDTO.getTos().booleanValue());
        this.JCH_Fiebre.setSelected(this.respiratorioDTO.getFiebre().booleanValue());
        this.JCH_Fatiga.setSelected(this.respiratorioDTO.getFatiga().booleanValue());
        this.JCH_Odinofagia.setSelected(this.respiratorioDTO.getOdinofagia().booleanValue());
        this.JCH_DificultadRespiratorio.setSelected(this.respiratorioDTO.getTos().booleanValue());
        this.JCH_AntecedenesContactos.setSelected(this.respiratorioDTO.getAntecedente_Contacto().booleanValue());
        this.JCH_antecedentesOcupacion.setSelected(this.respiratorioDTO.getAntecedente_IRAG().booleanValue());
        this.JCH_antecedentesViajes.setSelected(this.respiratorioDTO.getAntecedente_Viaje().booleanValue());
        this.JTAObservacion.setText(this.respiratorioDTO.getObservacion());
        this.JCH_SinSintomasRespiratorios.setSelected(this.respiratorioDTO.getSin_sintomas_respiratorios().booleanValue());
        this.JCH_Ninguna_Anteriores.setSelected(this.respiratorioDTO.getNinguna_anteriores().booleanValue());
        setClasificacion(this.respiratorioDTO.getClasificacion());
        switch (this.respiratorioDTO.getClasificacion().intValue()) {
            case 0:
                this.JRB_Negativo.setSelected(true);
                break;
            case 1:
                this.JRB_Sospechoso.setSelected(true);
                break;
            default:
                this.JRB_Positivo.setSelected(true);
                break;
        }
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    public void grabar() {
        this.respiratorioDTO.setIdTriage(getIdTriage());
        this.respiratorioDTO.setIdIngreso(getIdIngreso());
        this.respiratorioDTO.setFecha(this.metodos.getFechaActualLocalTime());
        this.respiratorioDTO.setObservacion(this.JTAObservacion.getText());
        this.respiratorioDTO = getTriageRespiratorioDAO().grabar(this.respiratorioDTO);
        if (Principal.clasehistoriace != null && Principal.clasehistoriace.xjifhistoriaclinica != null) {
            System.out.println("" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta());
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta().equals("TEST REPIRATORIO(SARS-COV-2)")) {
                getTriageRespiratorioDAO().actualizarEstadoAtendidoAtencion(this.idIngreso);
                getTriageRespiratorioDAO().actualizarEstadoCitaAtendida(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCita());
            }
        }
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    public void imprimir() {
        if (getIdIngreso().longValue() != 0) {
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.imprimirTestRespiratorio(String.valueOf(getIdIngreso()));
        }
    }

    @Generated
    public ButtonGroup getJBG_Clasificacion() {
        return this.JBG_Clasificacion;
    }

    @Generated
    public JCheckBox getJCH_AntecedenesContactos() {
        return this.JCH_AntecedenesContactos;
    }

    @Generated
    public JCheckBox getJCH_DificultadRespiratorio() {
        return this.JCH_DificultadRespiratorio;
    }

    @Generated
    public JCheckBox getJCH_Fatiga() {
        return this.JCH_Fatiga;
    }

    @Generated
    public JCheckBox getJCH_Fiebre() {
        return this.JCH_Fiebre;
    }

    @Generated
    public JCheckBox getJCH_Ninguna_Anteriores() {
        return this.JCH_Ninguna_Anteriores;
    }

    @Generated
    public JCheckBox getJCH_Odinofagia() {
        return this.JCH_Odinofagia;
    }

    @Generated
    public JCheckBox getJCH_SinSintomasRespiratorios() {
        return this.JCH_SinSintomasRespiratorios;
    }

    @Generated
    public JCheckBox getJCH_Tos() {
        return this.JCH_Tos;
    }

    @Generated
    public JCheckBox getJCH_antecedentesOcupacion() {
        return this.JCH_antecedentesOcupacion;
    }

    @Generated
    public JCheckBox getJCH_antecedentesViajes() {
        return this.JCH_antecedentesViajes;
    }

    @Generated
    public JPanel getJPI_Clasificacion() {
        return this.JPI_Clasificacion;
    }

    @Generated
    public JPanel getJPI_Datos() {
        return this.JPI_Datos;
    }

    @Generated
    public JPanel getJPI_Datos1() {
        return this.JPI_Datos1;
    }

    @Generated
    public JRadioButton getJRB_Negativo() {
        return this.JRB_Negativo;
    }

    @Generated
    public JRadioButton getJRB_Positivo() {
        return this.JRB_Positivo;
    }

    @Generated
    public JRadioButton getJRB_Sospechoso() {
        return this.JRB_Sospechoso;
    }

    @Generated
    public JScrollPane getJSPObserE() {
        return this.JSPObserE;
    }

    @Generated
    public JTextArea getJTAObservacion() {
        return this.JTAObservacion;
    }
}
