package com.genoma.plus.controller.historia;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.TriageRespiratorioDTO;
import com.genoma.plus.jpa.service.ITriageRespiratorioDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPTriageRespiratorio_V2.class */
public class JPTriageRespiratorio_V2 extends JPanel {
    private TriageRespiratorioDTO respiratorioDTO;
    private Long idTriage;
    private Long idIngreso;
    private JCheckBox JCH_AntecedenesContactos;
    private JCheckBox JCH_DiagnosticoIRA;
    private JCheckBox JCH_DificultadRespiratorio;
    private JCheckBox JCH_DolorGarganta;
    private JCheckBox JCH_Fatiga;
    private JCheckBox JCH_Fiebre;
    private JCheckBox JCH_SecrecionesNasales;
    private JCheckBox JCH_Tos;
    private JPanel JPI_Datos;
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
    public void setJCH_AntecedenesContactos(JCheckBox JCH_AntecedenesContactos) {
        this.JCH_AntecedenesContactos = JCH_AntecedenesContactos;
    }

    @Generated
    public void setJCH_DiagnosticoIRA(JCheckBox JCH_DiagnosticoIRA) {
        this.JCH_DiagnosticoIRA = JCH_DiagnosticoIRA;
    }

    @Generated
    public void setJCH_DificultadRespiratorio(JCheckBox JCH_DificultadRespiratorio) {
        this.JCH_DificultadRespiratorio = JCH_DificultadRespiratorio;
    }

    @Generated
    public void setJCH_DolorGarganta(JCheckBox JCH_DolorGarganta) {
        this.JCH_DolorGarganta = JCH_DolorGarganta;
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
    public void setJCH_SecrecionesNasales(JCheckBox JCH_SecrecionesNasales) {
        this.JCH_SecrecionesNasales = JCH_SecrecionesNasales;
    }

    @Generated
    public void setJCH_Tos(JCheckBox JCH_Tos) {
        this.JCH_Tos = JCH_Tos;
    }

    @Generated
    public void setJPI_Datos(JPanel JPI_Datos) {
        this.JPI_Datos = JPI_Datos;
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

    public JPTriageRespiratorio_V2(Long idTriage, Long idIngreso, String tituloPanel) {
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, tituloPanel, 0, 0, new Font("Arial", 1, 14), Color.red));
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
        System.out.println(getIdIngreso());
        System.out.println(getIdTriage());
        nuevo();
    }

    private void initComponents() {
        this.JCH_DiagnosticoIRA = new JCheckBox();
        this.JPI_Datos = new JPanel();
        this.JCH_Fiebre = new JCheckBox();
        this.JCH_Tos = new JCheckBox();
        this.JCH_DificultadRespiratorio = new JCheckBox();
        this.JCH_Fatiga = new JCheckBox();
        this.JCH_DolorGarganta = new JCheckBox();
        this.JCH_SecrecionesNasales = new JCheckBox();
        this.JSPObserE = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JCH_AntecedenesContactos = new JCheckBox();
        setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 14), Color.red));
        setName("jpTriageRespiratorio");
        this.JCH_DiagnosticoIRA.setFont(new Font("Arial", 1, 14));
        this.JCH_DiagnosticoIRA.setForeground(new Color(0, 103, 0));
        this.JCH_DiagnosticoIRA.setText("1. Tiene diagnóstico de Infección Respiratoria Aguda?");
        this.JCH_DiagnosticoIRA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio_V2.1
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio_V2.this.JCH_DiagnosticoIRAActionPerformed(evt);
            }
        });
        this.JPI_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "2. Usted presenta o ha presentado", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCH_Fiebre.setFont(new Font("Arial", 1, 12));
        this.JCH_Fiebre.setText("Fiebre mayor a 38ºC");
        this.JCH_Fiebre.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio_V2.2
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio_V2.this.JCH_FiebreActionPerformed(evt);
            }
        });
        this.JCH_Tos.setFont(new Font("Arial", 1, 12));
        this.JCH_Tos.setText("Tos");
        this.JCH_Tos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio_V2.3
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio_V2.this.JCH_TosActionPerformed(evt);
            }
        });
        this.JCH_DificultadRespiratorio.setFont(new Font("Arial", 1, 12));
        this.JCH_DificultadRespiratorio.setText("Dificultad Respiratoria");
        this.JCH_DificultadRespiratorio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio_V2.4
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio_V2.this.JCH_DificultadRespiratorioActionPerformed(evt);
            }
        });
        this.JCH_Fatiga.setFont(new Font("Arial", 1, 12));
        this.JCH_Fatiga.setText("Fatiga/Adinamia");
        this.JCH_Fatiga.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio_V2.5
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio_V2.this.JCH_FatigaActionPerformed(evt);
            }
        });
        this.JCH_DolorGarganta.setFont(new Font("Arial", 1, 12));
        this.JCH_DolorGarganta.setText("Dolor de Garganta");
        this.JCH_DolorGarganta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio_V2.6
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio_V2.this.JCH_DolorGargantaActionPerformed(evt);
            }
        });
        this.JCH_SecrecionesNasales.setFont(new Font("Arial", 1, 12));
        this.JCH_SecrecionesNasales.setText("Secreciones Nasales");
        this.JCH_SecrecionesNasales.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio_V2.7
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio_V2.this.JCH_SecrecionesNasalesActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JCH_Fiebre).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Tos).addGap(18, 18, 18).addComponent(this.JCH_DificultadRespiratorio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_DolorGarganta)).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JCH_Fatiga).addGap(18, 18, 18).addComponent(this.JCH_SecrecionesNasales))).addContainerGap(149, 32767)));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Fiebre).addComponent(this.JCH_Tos).addComponent(this.JCH_DificultadRespiratorio).addComponent(this.JCH_DolorGarganta)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Fatiga).addComponent(this.JCH_SecrecionesNasales))));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObserE.setViewportView(this.JTAObservacion);
        this.JCH_AntecedenesContactos.setFont(new Font("Arial", 1, 14));
        this.JCH_AntecedenesContactos.setForeground(new Color(0, 103, 0));
        this.JCH_AntecedenesContactos.setText("3. Contacto con un paciente sospechoso o confirmado de COVID-19 así este asintomático.");
        this.JCH_AntecedenesContactos.setActionCommand("3. Contacto con un paciente sospechoso o confirmado de COVID-19 así este asintomático.");
        this.JCH_AntecedenesContactos.setVerticalTextPosition(1);
        this.JCH_AntecedenesContactos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPTriageRespiratorio_V2.8
            public void actionPerformed(ActionEvent evt) {
                JPTriageRespiratorio_V2.this.JCH_AntecedenesContactosActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_AntecedenesContactos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_DiagnosticoIRA).addComponent(this.JPI_Datos, -2, -1, -2).addComponent(this.JSPObserE, -2, 709, -2)).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_DiagnosticoIRA).addGap(28, 28, 28).addComponent(this.JPI_Datos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_AntecedenesContactos).addGap(18, 18, 18).addComponent(this.JSPObserE, -2, 58, -2).addContainerGap(19, 32767)));
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
    public void JCH_FatigaActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setFatiga(Boolean.valueOf(getJCH_Fatiga().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AntecedenesContactosActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setContacto_Paciente_Covid19(Boolean.valueOf(getJCH_AntecedenesContactos().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_DiagnosticoIRAActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setDiagnostico_IRA(Boolean.valueOf(getJCH_DiagnosticoIRA().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_DolorGargantaActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setDolor_Garganta(Boolean.valueOf(getJCH_DolorGarganta().isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SecrecionesNasalesActionPerformed(ActionEvent evt) {
        this.respiratorioDTO.setSecrecion_nasal(Boolean.valueOf(getJCH_SecrecionesNasales().isSelected()));
    }

    public void nuevo() {
        if (getIdTriage().longValue() == 0) {
            this.respiratorioDTO = getTriageRespiratorioDAO().consultarTriageidIngreso(getIdIngreso());
        } else {
            this.respiratorioDTO = getTriageRespiratorioDAO().consultarTriageid(getIdTriage());
        }
        if (this.respiratorioDTO == null) {
            this.respiratorioDTO = TriageRespiratorioDTO.builder().fiebre(Boolean.valueOf(getJCH_Fiebre().isSelected())).tos(Boolean.valueOf(getJCH_Tos().isSelected())).dificultad_Respiratioria(Boolean.valueOf(getJCH_DificultadRespiratorio().isSelected())).fatiga(Boolean.valueOf(getJCH_Fatiga().isSelected())).diagnostico_IRA(Boolean.valueOf(getJCH_DiagnosticoIRA().isSelected())).dolor_Garganta(Boolean.valueOf(getJCH_DolorGarganta().isSelected())).contacto_Paciente_Covid19(Boolean.valueOf(getJCH_AntecedenesContactos().isSelected())).secrecion_nasal(Boolean.valueOf(getJCH_SecrecionesNasales().isSelected())).observacion(getJTAObservacion().getText()).estado(true).idIngreso(getIdIngreso()).idTriage(getIdTriage()).build();
            return;
        }
        this.JCH_Tos.setSelected(this.respiratorioDTO.getTos().booleanValue());
        this.JCH_Fiebre.setSelected(this.respiratorioDTO.getFiebre().booleanValue());
        this.JCH_Fatiga.setSelected(this.respiratorioDTO.getFatiga().booleanValue());
        this.JCH_DolorGarganta.setSelected(this.respiratorioDTO.getDolor_Garganta().booleanValue());
        this.JCH_DificultadRespiratorio.setSelected(this.respiratorioDTO.getTos().booleanValue());
        this.JCH_AntecedenesContactos.setSelected(this.respiratorioDTO.getContacto_Paciente_Covid19().booleanValue());
        this.JCH_DiagnosticoIRA.setSelected(this.respiratorioDTO.getDiagnostico_IRA().booleanValue());
        this.JCH_SecrecionesNasales.setSelected(this.respiratorioDTO.getSecrecion_nasal().booleanValue());
        this.JTAObservacion.setText(this.respiratorioDTO.getObservacion());
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    public void grabar() {
        this.respiratorioDTO.setIdTriage(getIdTriage());
        this.respiratorioDTO.setIdIngreso(getIdIngreso());
        this.respiratorioDTO.setFecha(this.metodos.getFechaActualLocalTime());
        this.respiratorioDTO.setObservacion(this.JTAObservacion.getText());
        this.respiratorioDTO.setAntecedente_IRAG(false);
        this.respiratorioDTO.setAntecedente_Contacto(false);
        this.respiratorioDTO.setAntecedente_Viaje(false);
        this.respiratorioDTO.setOdinofagia(false);
        this.respiratorioDTO = getTriageRespiratorioDAO().grabar(this.respiratorioDTO);
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    public void imprimir() {
        if (getIdIngreso().longValue() != 0) {
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.imprimirTestRespiratorio(String.valueOf(getIdIngreso()));
        }
    }

    @Generated
    public JCheckBox getJCH_AntecedenesContactos() {
        return this.JCH_AntecedenesContactos;
    }

    @Generated
    public JCheckBox getJCH_DiagnosticoIRA() {
        return this.JCH_DiagnosticoIRA;
    }

    @Generated
    public JCheckBox getJCH_DificultadRespiratorio() {
        return this.JCH_DificultadRespiratorio;
    }

    @Generated
    public JCheckBox getJCH_DolorGarganta() {
        return this.JCH_DolorGarganta;
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
    public JCheckBox getJCH_SecrecionesNasales() {
        return this.JCH_SecrecionesNasales;
    }

    @Generated
    public JCheckBox getJCH_Tos() {
        return this.JCH_Tos;
    }

    @Generated
    public JPanel getJPI_Datos() {
        return this.JPI_Datos;
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
