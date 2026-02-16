package com.genoma.plus.controller.inventario;

import Acceso.Principal;
import Historia.JPIOrden_Tratamiento;
import Historia.JPOOrdenSuministroH;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.HItemordenessumRespuestacuestionario;
import com.genoma.plus.jpa.entities.HOrdenesUnidosisDetalleRespuestacuestionario;
import com.genoma.plus.jpa.entities.SoTipoCuestionario;
import com.genoma.plus.jpa.entities.SoTipoPreguntaRespuesta;
import com.genoma.plus.jpa.service.ITipoPreguntaRespuestaCuestionarioService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JD_CuestionarioFarmacovigilanciaDisparadores.class */
public class JD_CuestionarioFarmacovigilanciaDisparadores extends JDialog {
    private final ITipoPreguntaRespuestaCuestionarioService iTipoPreguntaRespuestaCuestionarioService;
    private List<SoTipoPreguntaRespuesta> tipoPreguntaRespuesta;
    private DefaultTableModel modelo;
    private Object[] datos;
    private Integer idPregunta;
    private final Metodos metodos;
    private final SoTipoCuestionario cuestionario;
    private String formularios;
    private ButtonGroup JBG_P1Filtro;
    private JButton JBT_Grabar;
    private JButton JBT_Salir;
    private JPanel JPI_Pregunta1;
    private JPanel JPI_Pregunta2;
    private JRadioButton JRB_P1No;
    private JRadioButton JRB_P1Si;
    private JScrollPane JSP_P1Observacion;
    private JScrollPane JSP_P3Detalle;
    private JScrollPane JSP_P4Detalle;
    private JTextField JTF_P2Medicamento;
    private JTextPane JTP_P1Observacion;
    private JTable JT_P3Detalle;
    private JTable JT_P4Detalle;
    private JLabel jLabel1;

    public JD_CuestionarioFarmacovigilanciaDisparadores(Frame parent, boolean modal, SoTipoCuestionario cuestionario, String formularios) {
        super(parent, modal);
        this.iTipoPreguntaRespuestaCuestionarioService = (ITipoPreguntaRespuestaCuestionarioService) Principal.contexto.getBean(ITipoPreguntaRespuestaCuestionarioService.class);
        this.idPregunta = null;
        this.metodos = new Metodos();
        initComponents();
        this.formularios = formularios;
        this.cuestionario = cuestionario;
        setTitle(cuestionario.getNbre().toUpperCase());
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        armarInformacionFormulario();
        activarDesactivarComponentes(false);
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_P1Filtro = new ButtonGroup();
        this.jLabel1 = new JLabel();
        this.JPI_Pregunta1 = new JPanel();
        this.JRB_P1Si = new JRadioButton();
        this.JRB_P1No = new JRadioButton();
        this.JSP_P1Observacion = new JScrollPane();
        this.JTP_P1Observacion = new JTextPane();
        this.JPI_Pregunta2 = new JPanel();
        this.JTF_P2Medicamento = new JTextField();
        this.JSP_P3Detalle = new JScrollPane();
        this.JT_P3Detalle = new JTable();
        this.JSP_P4Detalle = new JScrollPane();
        this.JT_P4Detalle = new JTable();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("<html><p style=\"text-align: center;\"><span style=\"color: #0000ff;\"><strong><span><span><span>PREGUNTAS</span></span></span></strong></span></p></html>");
        this.JPI_Pregunta1.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p style=\"text-align: justify;\"><strong><span style=\"color: #ff0000;\">1.<span class=\"Apple-tab-span\"> </span>El medicamento seleccionado tiene considerado dentro de sus indicaciones de uso, tratar alg&uacute;n tipo de PRM (Problema relacionado con el medicamento).</span></strong></p></html>", 0, 0, new Font("Arial", 1, 12)));
        this.JBG_P1Filtro.add(this.JRB_P1Si);
        this.JRB_P1Si.setFont(new Font("Arial", 1, 12));
        this.JRB_P1Si.setText("Si");
        this.JRB_P1Si.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JD_CuestionarioFarmacovigilanciaDisparadores.1
            public void actionPerformed(ActionEvent evt) {
                JD_CuestionarioFarmacovigilanciaDisparadores.this.JRB_P1SiActionPerformed(evt);
            }
        });
        this.JBG_P1Filtro.add(this.JRB_P1No);
        this.JRB_P1No.setFont(new Font("Arial", 1, 12));
        this.JRB_P1No.setSelected(true);
        this.JRB_P1No.setText("No");
        this.JRB_P1No.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JD_CuestionarioFarmacovigilanciaDisparadores.2
            public void actionPerformed(ActionEvent evt) {
                JD_CuestionarioFarmacovigilanciaDisparadores.this.JRB_P1NoActionPerformed(evt);
            }
        });
        this.JSP_P1Observacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12)));
        this.JTP_P1Observacion.setFont(new Font("Arial", 1, 12));
        this.JSP_P1Observacion.setViewportView(this.JTP_P1Observacion);
        GroupLayout JPI_Pregunta1Layout = new GroupLayout(this.JPI_Pregunta1);
        this.JPI_Pregunta1.setLayout(JPI_Pregunta1Layout);
        JPI_Pregunta1Layout.setHorizontalGroup(JPI_Pregunta1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Pregunta1Layout.createSequentialGroup().addComponent(this.JRB_P1Si).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_P1No).addGap(37, 37, 37).addComponent(this.JSP_P1Observacion, -2, 573, -2).addContainerGap(-1, 32767)));
        JPI_Pregunta1Layout.setVerticalGroup(JPI_Pregunta1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Pregunta1Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_Pregunta1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRB_P1No, -1, -1, 32767).addGroup(JPI_Pregunta1Layout.createSequentialGroup().addComponent(this.JSP_P1Observacion, -2, 50, -2).addGap(0, 0, 32767)).addComponent(this.JRB_P1Si, -1, -1, 32767)).addContainerGap()));
        this.JPI_Pregunta2.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p style=\"text-align: justify;\"><strong><span style=\"color: #ff0000;\">2.<span class=\"Apple-tab-span\"> </span>Que medicamento, procedimiento o suceso dio origen al PRM (Problema Relacionado con medicamento).</span></strong></p></html>", 0, 0, new Font("Arial", 1, 12)));
        this.JTF_P2Medicamento.setFont(new Font("Arial", 1, 12));
        this.JTF_P2Medicamento.setBorder(BorderFactory.createTitledBorder((Border) null, "Medicamento/Insumo", 0, 0, new Font("Arial", 1, 12)));
        GroupLayout JPI_Pregunta2Layout = new GroupLayout(this.JPI_Pregunta2);
        this.JPI_Pregunta2.setLayout(JPI_Pregunta2Layout);
        JPI_Pregunta2Layout.setHorizontalGroup(JPI_Pregunta2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Pregunta2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTF_P2Medicamento, -2, 706, -2).addContainerGap(-1, 32767)));
        JPI_Pregunta2Layout.setVerticalGroup(JPI_Pregunta2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Pregunta2Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTF_P2Medicamento, -2, 50, -2).addContainerGap(-1, 32767)));
        this.JSP_P3Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p><strong><span style=\"color: #ff0000;\">3.<span class=\"Apple-tab-span\"> </span>El medicamento prescrito se us&oacute; para tratar:</span></strong></p></html>", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JT_P3Detalle.setFont(new Font("Arial", 1, 12));
        this.JT_P3Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JT_P3Detalle.setRowHeight(25);
        this.JT_P3Detalle.setSelectionBackground(Color.white);
        this.JT_P3Detalle.setSelectionForeground(Color.red);
        this.JT_P3Detalle.setSelectionMode(0);
        this.JSP_P3Detalle.setViewportView(this.JT_P3Detalle);
        this.JSP_P4Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p><strong><span style=\"color: #ff0000;\">4.&iquest;Cu&aacute;l de las siguientes opciones se relacionan al suceso?</span></strong></p></html>", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JT_P4Detalle.setFont(new Font("Arial", 1, 12));
        this.JT_P4Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JT_P4Detalle.setRowHeight(25);
        this.JT_P4Detalle.setSelectionBackground(Color.white);
        this.JT_P4Detalle.setSelectionForeground(Color.red);
        this.JT_P4Detalle.setSelectionMode(0);
        this.JSP_P4Detalle.setViewportView(this.JT_P4Detalle);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JD_CuestionarioFarmacovigilanciaDisparadores.3
            public void actionPerformed(ActionEvent evt) {
                JD_CuestionarioFarmacovigilanciaDisparadores.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JD_CuestionarioFarmacovigilanciaDisparadores.4
            public void actionPerformed(ActionEvent evt) {
                JD_CuestionarioFarmacovigilanciaDisparadores.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel1).addComponent(this.JPI_Pregunta2, -1, -1, 32767).addComponent(this.JPI_Pregunta1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_P3Detalle, -2, 341, -2).addComponent(this.JBT_Grabar, -2, 341, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSP_P4Detalle, -1, 353, 32767).addComponent(this.JBT_Salir, -1, -1, 32767)))).addContainerGap(16, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Pregunta1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Pregunta2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSP_P3Detalle, -2, 203, -2).addComponent(this.JSP_P4Detalle, -2, 203, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        SoTipoPreguntaRespuesta soTipoPreguntaRespuesta = new SoTipoPreguntaRespuesta();
        if (this.JRB_P1Si.isSelected()) {
            soTipoPreguntaRespuesta.setId(Integer.valueOf(this.JRB_P1Si.getName()));
        } else {
            soTipoPreguntaRespuesta.setId(Integer.valueOf(this.JRB_P1No.getName()));
        }
        if (this.formularios.equals("pantallaFormulacion")) {
            ArrayList arrayList = new ArrayList();
            HItemordenessumRespuestacuestionario hItemordenessumRespuestacuestionario = new HItemordenessumRespuestacuestionario();
            hItemordenessumRespuestacuestionario.setIdTipoRespuestaCuestionario(soTipoPreguntaRespuesta);
            hItemordenessumRespuestacuestionario.setEstado(true);
            hItemordenessumRespuestacuestionario.setFecha(this.metodos.getFechaActual());
            hItemordenessumRespuestacuestionario.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
            hItemordenessumRespuestacuestionario.setObservacion(this.JTP_P1Observacion.getText());
            arrayList.add(hItemordenessumRespuestacuestionario);
            HItemordenessumRespuestacuestionario hItemordenessumRespuestacuestionario2 = new HItemordenessumRespuestacuestionario();
            SoTipoPreguntaRespuesta soTipoPreguntaRespuesta2 = new SoTipoPreguntaRespuesta();
            soTipoPreguntaRespuesta2.setId(Integer.valueOf(this.JTF_P2Medicamento.getName()));
            hItemordenessumRespuestacuestionario2.setIdTipoRespuestaCuestionario(soTipoPreguntaRespuesta2);
            hItemordenessumRespuestacuestionario2.setEstado(true);
            hItemordenessumRespuestacuestionario2.setFecha(this.metodos.getFechaActual());
            hItemordenessumRespuestacuestionario2.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
            hItemordenessumRespuestacuestionario2.setObservacion(this.JTF_P2Medicamento.getText());
            arrayList.add(hItemordenessumRespuestacuestionario2);
            for (int x = 0; x < this.JT_P3Detalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.JT_P3Detalle.getValueAt(x, 3).toString()).booleanValue()) {
                    HItemordenessumRespuestacuestionario hItemordenessumRespuestacuestionario3 = new HItemordenessumRespuestacuestionario();
                    SoTipoPreguntaRespuesta soTipoPreguntaRespuesta3 = new SoTipoPreguntaRespuesta();
                    soTipoPreguntaRespuesta3.setId(Integer.valueOf(this.JT_P3Detalle.getValueAt(x, 0).toString()));
                    hItemordenessumRespuestacuestionario3.setIdTipoRespuestaCuestionario(soTipoPreguntaRespuesta3);
                    hItemordenessumRespuestacuestionario3.setEstado(true);
                    hItemordenessumRespuestacuestionario3.setFecha(this.metodos.getFechaActual());
                    hItemordenessumRespuestacuestionario3.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                    hItemordenessumRespuestacuestionario3.setObservacion(this.JT_P3Detalle.getValueAt(x, 2).toString());
                    arrayList.add(hItemordenessumRespuestacuestionario3);
                }
            }
            for (int x2 = 0; x2 < this.JT_P4Detalle.getRowCount(); x2++) {
                if (Boolean.valueOf(this.JT_P4Detalle.getValueAt(x2, 3).toString()).booleanValue()) {
                    HItemordenessumRespuestacuestionario hItemordenessumRespuestacuestionario4 = new HItemordenessumRespuestacuestionario();
                    SoTipoPreguntaRespuesta soTipoPreguntaRespuesta4 = new SoTipoPreguntaRespuesta();
                    soTipoPreguntaRespuesta4.setId(Integer.valueOf(this.JT_P4Detalle.getValueAt(x2, 0).toString()));
                    hItemordenessumRespuestacuestionario4.setIdTipoRespuestaCuestionario(soTipoPreguntaRespuesta4);
                    hItemordenessumRespuestacuestionario4.setEstado(true);
                    hItemordenessumRespuestacuestionario4.setFecha(this.metodos.getFechaActual());
                    hItemordenessumRespuestacuestionario4.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                    hItemordenessumRespuestacuestionario4.setObservacion(this.JT_P4Detalle.getValueAt(x2, 2).toString());
                    arrayList.add(hItemordenessumRespuestacuestionario4);
                }
            }
            JPOOrdenSuministroH.vector.add(arrayList);
            JPOOrdenSuministroH.xmodelodetallet.setValueAt(Integer.valueOf(JPOOrdenSuministroH.vector.size() - 1), JPOOrdenSuministroH.JTDatosDetMedicamentos.getRowCount() - 1, 14);
        } else if (this.formularios.equals("pantallaTratamiento")) {
            ArrayList arrayList2 = new ArrayList();
            HOrdenesUnidosisDetalleRespuestacuestionario hItemordenessumRespuestacuestionario5 = new HOrdenesUnidosisDetalleRespuestacuestionario();
            hItemordenessumRespuestacuestionario5.setIdTipoRespuestaCuestionario(soTipoPreguntaRespuesta);
            hItemordenessumRespuestacuestionario5.setEstado(true);
            hItemordenessumRespuestacuestionario5.setFecha(this.metodos.getFechaActual());
            hItemordenessumRespuestacuestionario5.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
            hItemordenessumRespuestacuestionario5.setObservacion(this.JTP_P1Observacion.getText());
            arrayList2.add(hItemordenessumRespuestacuestionario5);
            HOrdenesUnidosisDetalleRespuestacuestionario hItemordenessumRespuestacuestionario6 = new HOrdenesUnidosisDetalleRespuestacuestionario();
            SoTipoPreguntaRespuesta soTipoPreguntaRespuesta5 = new SoTipoPreguntaRespuesta();
            soTipoPreguntaRespuesta5.setId(Integer.valueOf(this.JTF_P2Medicamento.getName()));
            hItemordenessumRespuestacuestionario6.setIdTipoRespuestaCuestionario(soTipoPreguntaRespuesta5);
            hItemordenessumRespuestacuestionario6.setEstado(true);
            hItemordenessumRespuestacuestionario6.setFecha(this.metodos.getFechaActual());
            hItemordenessumRespuestacuestionario6.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
            hItemordenessumRespuestacuestionario6.setObservacion(this.JTF_P2Medicamento.getText());
            arrayList2.add(hItemordenessumRespuestacuestionario6);
            for (int x3 = 0; x3 < this.JT_P3Detalle.getRowCount(); x3++) {
                if (Boolean.valueOf(this.JT_P3Detalle.getValueAt(x3, 3).toString()).booleanValue()) {
                    HOrdenesUnidosisDetalleRespuestacuestionario hItemordenessumRespuestacuestionario7 = new HOrdenesUnidosisDetalleRespuestacuestionario();
                    SoTipoPreguntaRespuesta soTipoPreguntaRespuesta6 = new SoTipoPreguntaRespuesta();
                    soTipoPreguntaRespuesta6.setId(Integer.valueOf(this.JT_P3Detalle.getValueAt(x3, 0).toString()));
                    hItemordenessumRespuestacuestionario7.setIdTipoRespuestaCuestionario(soTipoPreguntaRespuesta6);
                    hItemordenessumRespuestacuestionario7.setEstado(true);
                    hItemordenessumRespuestacuestionario7.setFecha(this.metodos.getFechaActual());
                    hItemordenessumRespuestacuestionario7.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                    hItemordenessumRespuestacuestionario7.setObservacion(this.JT_P3Detalle.getValueAt(x3, 2).toString());
                    arrayList2.add(hItemordenessumRespuestacuestionario7);
                }
            }
            for (int x4 = 0; x4 < this.JT_P4Detalle.getRowCount(); x4++) {
                if (Boolean.valueOf(this.JT_P4Detalle.getValueAt(x4, 3).toString()).booleanValue()) {
                    HOrdenesUnidosisDetalleRespuestacuestionario hItemordenessumRespuestacuestionario8 = new HOrdenesUnidosisDetalleRespuestacuestionario();
                    SoTipoPreguntaRespuesta soTipoPreguntaRespuesta7 = new SoTipoPreguntaRespuesta();
                    soTipoPreguntaRespuesta7.setId(Integer.valueOf(this.JT_P4Detalle.getValueAt(x4, 0).toString()));
                    hItemordenessumRespuestacuestionario8.setIdTipoRespuestaCuestionario(soTipoPreguntaRespuesta7);
                    hItemordenessumRespuestacuestionario8.setEstado(true);
                    hItemordenessumRespuestacuestionario8.setFecha(this.metodos.getFechaActual());
                    hItemordenessumRespuestacuestionario8.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                    hItemordenessumRespuestacuestionario8.setObservacion(this.JT_P4Detalle.getValueAt(x4, 2).toString());
                    arrayList2.add(hItemordenessumRespuestacuestionario8);
                }
            }
            JPIOrden_Tratamiento.vector.add(arrayList2);
            JPIOrden_Tratamiento.xmodelodetallet.setValueAt(Integer.valueOf(JPIOrden_Tratamiento.vector.size() - 1), JPIOrden_Tratamiento.JTDatosDetMedicamentos.getRowCount() - 1, 6);
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P1SiActionPerformed(ActionEvent evt) {
        activarDesactivarComponentes(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_P1NoActionPerformed(ActionEvent evt) {
        activarDesactivarComponentes(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDetalle(JTable jTable) {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"id", "Respuesta", "Observación", "Seleccionar"}) { // from class: com.genoma.plus.controller.inventario.JD_CuestionarioFarmacovigilanciaDisparadores.5
            Class[] types = {Integer.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        jTable.setAutoResizeMode(0);
        jTable.doLayout();
        jTable.setModel(this.modelo);
        jTable.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTable.getColumnModel().getColumn(0).setMinWidth(0);
        jTable.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    private void armarInformacionFormulario() {
        this.tipoPreguntaRespuesta = new ArrayList();
        this.tipoPreguntaRespuesta = this.iTipoPreguntaRespuestaCuestionarioService.listarPreguntasPorCuestionario(this.cuestionario);
        if (!this.tipoPreguntaRespuesta.isEmpty()) {
            this.tipoPreguntaRespuesta.forEach(tipoRespuesta -> {
                if (!Objects.equals(tipoRespuesta.getSoTipoPreguntas().getId(), this.idPregunta)) {
                    this.idPregunta = tipoRespuesta.getSoTipoPreguntas().getId();
                    switch (tipoRespuesta.getSoTipoRespuesta().getTipo().intValue()) {
                        case 1:
                            this.JTF_P2Medicamento.setName("" + tipoRespuesta.getId());
                            break;
                        case 2:
                            if (tipoRespuesta.getSoTipoRespuesta().getNbre().equals(this.JRB_P1Si.getText().toUpperCase())) {
                                this.JRB_P1Si.setName("" + tipoRespuesta.getId());
                            }
                            if (tipoRespuesta.getSoTipoRespuesta().getNbre().equals(this.JRB_P1No.getText().toUpperCase())) {
                                this.JRB_P1No.setName("" + tipoRespuesta.getId());
                            }
                            break;
                        case 3:
                            if (tipoRespuesta.getSoTipoPreguntas().getNbre().equals("3.\tEl medicamento prescrito se usó para tratar:")) {
                                crearModeloDetalle(this.JT_P3Detalle);
                                this.modelo.addRow(this.datos);
                                this.metodos.mEstablecerTextEditor(this.JT_P3Detalle, 1);
                                this.JT_P3Detalle.setValueAt(tipoRespuesta.getId(), this.JT_P3Detalle.getRowCount() - 1, 0);
                                this.JT_P3Detalle.setValueAt(tipoRespuesta.getSoTipoRespuesta().getNbre(), this.JT_P3Detalle.getRowCount() - 1, 1);
                                this.JT_P3Detalle.setValueAt("", this.JT_P3Detalle.getRowCount() - 1, 2);
                                this.JT_P3Detalle.setValueAt(false, this.JT_P3Detalle.getRowCount() - 1, 3);
                            } else {
                                crearModeloDetalle(this.JT_P4Detalle);
                                this.modelo.addRow(this.datos);
                                this.metodos.mEstablecerTextEditor(this.JT_P4Detalle, 1);
                                this.JT_P4Detalle.setValueAt(tipoRespuesta.getId(), this.JT_P4Detalle.getRowCount() - 1, 0);
                                this.JT_P4Detalle.setValueAt(tipoRespuesta.getSoTipoRespuesta().getNbre(), this.JT_P4Detalle.getRowCount() - 1, 1);
                                this.JT_P4Detalle.setValueAt("", this.JT_P4Detalle.getRowCount() - 1, 2);
                                this.JT_P4Detalle.setValueAt(false, this.JT_P4Detalle.getRowCount() - 1, 3);
                            }
                            break;
                    }
                }
                switch (tipoRespuesta.getSoTipoRespuesta().getTipo().intValue()) {
                    case 1:
                        this.JTF_P2Medicamento.setName("" + tipoRespuesta.getId());
                        break;
                    case 2:
                        if (tipoRespuesta.getSoTipoRespuesta().getNbre().equals(this.JRB_P1Si.getText().toUpperCase())) {
                            this.JRB_P1Si.setName("" + tipoRespuesta.getId());
                        }
                        if (tipoRespuesta.getSoTipoRespuesta().getNbre().equals(this.JRB_P1No.getText().toUpperCase())) {
                            this.JRB_P1No.setName("" + tipoRespuesta.getId());
                        }
                        break;
                    case 3:
                        if (tipoRespuesta.getSoTipoPreguntas().getNbre().equals("3.\tEl medicamento prescrito se usó para tratar:")) {
                            this.modelo.addRow(this.datos);
                            this.metodos.mEstablecerTextEditor(this.JT_P3Detalle, 1);
                            this.JT_P3Detalle.setValueAt(tipoRespuesta.getId(), this.JT_P3Detalle.getRowCount() - 1, 0);
                            this.JT_P3Detalle.setValueAt(tipoRespuesta.getSoTipoRespuesta().getNbre(), this.JT_P3Detalle.getRowCount() - 1, 1);
                            this.JT_P3Detalle.setValueAt("", this.JT_P3Detalle.getRowCount() - 1, 2);
                            this.JT_P3Detalle.setValueAt(false, this.JT_P3Detalle.getRowCount() - 1, 3);
                        } else {
                            this.modelo.addRow(this.datos);
                            this.metodos.mEstablecerTextEditor(this.JT_P4Detalle, 1);
                            this.JT_P4Detalle.setValueAt(tipoRespuesta.getId(), this.JT_P4Detalle.getRowCount() - 1, 0);
                            this.JT_P4Detalle.setValueAt(tipoRespuesta.getSoTipoRespuesta().getNbre(), this.JT_P4Detalle.getRowCount() - 1, 1);
                            this.JT_P4Detalle.setValueAt("", this.JT_P4Detalle.getRowCount() - 1, 2);
                            this.JT_P4Detalle.setValueAt(false, this.JT_P4Detalle.getRowCount() - 1, 3);
                        }
                        break;
                }
            });
        }
    }

    private void activarDesactivarComponentes(Boolean estado) {
        this.JTF_P2Medicamento.setEditable(estado.booleanValue());
        this.JSP_P3Detalle.setEnabled(estado.booleanValue());
        this.JSP_P4Detalle.setEnabled(estado.booleanValue());
        this.JT_P3Detalle.setEnabled(estado.booleanValue());
        this.JT_P4Detalle.setEnabled(estado.booleanValue());
    }
}
