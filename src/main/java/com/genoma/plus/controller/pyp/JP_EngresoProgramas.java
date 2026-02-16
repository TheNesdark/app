package com.genoma.plus.controller.pyp;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GUsuarioxprograma;
import com.genoma.plus.jpa.entities.PMotivoegresoEntity;
import com.genoma.plus.jpa.service.IGUsuarioprogramaService;
import com.genoma.plus.jpa.service.PMotivoegresoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/pyp/JP_EngresoProgramas.class */
public class JP_EngresoProgramas extends JPanel {
    private List<PMotivoegresoEntity> listarMotivosEgreso;
    Integer idUsuarioPrograma;
    private JButton JBTEGuardar;
    private JComboBox JCBMotEgreso;
    public JDateChooser JDFechaEgreso;
    private JPanel JPEstadoPaciente;
    private JRadioButton JRBMuerto;
    private JRadioButton JRBVivo;
    private JLabel JTFEstado;
    private JTextArea JTPEFObsEgresos;
    private ButtonGroup buttonGroup1;
    private JScrollPane jScrollPane2;
    private Metodos metodos = new Metodos();
    private final IGUsuarioprogramaService iUsuarioPorProgramaService = (IGUsuarioprogramaService) Principal.contexto.getBean(IGUsuarioprogramaService.class);
    private final PMotivoegresoService iPMotivoegresoService = (PMotivoegresoService) Principal.contexto.getBean(PMotivoegresoService.class);
    private GUsuarioxprograma GUsuarioxprogramaDTO = new GUsuarioxprograma();
    boolean vivo = true;

    public JP_EngresoProgramas(Integer idUsuarioPrograma) {
        initComponents();
        this.idUsuarioPrograma = idUsuarioPrograma;
        nuevo();
    }

    private void llenarCombo() {
        this.listarMotivosEgreso = this.iPMotivoegresoService.listarMotivosEgresoPorEstado(false);
        this.JCBMotEgreso.removeAllItems();
        for (int i = 0; i < this.listarMotivosEgreso.size(); i++) {
            this.JCBMotEgreso.addItem(this.listarMotivosEgreso.get(i).getNbre());
        }
        this.JCBMotEgreso.setSelectedIndex(-1);
    }

    private void nuevo() {
        llenarCombo();
        mBuscarDatosEgreso();
    }

    public void mBuscarDatosEgreso() {
        this.GUsuarioxprogramaDTO = this.iUsuarioPorProgramaService.buscarPorIdUsuarioPrograma(this.idUsuarioPrograma);
        if (this.GUsuarioxprogramaDTO.isEstado()) {
            this.JTFEstado.setText("EGRESADO");
            this.JDFechaEgreso.setDate(this.GUsuarioxprogramaDTO.getFechaEgreso());
            this.JCBMotEgreso.setSelectedItem(this.iPMotivoegresoService.buscarMotivoEgreso(this.GUsuarioxprogramaDTO.getMotivoEgreso()).getNbre());
            if (!this.GUsuarioxprogramaDTO.getViva().booleanValue()) {
                this.JRBMuerto.setSelected(true);
            } else {
                this.JRBVivo.setSelected(true);
            }
            this.JTPEFObsEgresos.setText(this.GUsuarioxprogramaDTO.getObservacionEgreso());
            this.JBTEGuardar.setEnabled(false);
            return;
        }
        this.JTFEstado.setText("ACTIVO");
        this.JDFechaEgreso.setDate(this.metodos.getFechaActual());
        this.JTPEFObsEgresos.setText("");
        this.JRBVivo.setSelected(true);
        this.JBTEGuardar.setEnabled(true);
    }

    public void grabar() {
        this.GUsuarioxprogramaDTO.setEstado(true);
        this.GUsuarioxprogramaDTO.setFechaEgreso(this.JDFechaEgreso.getDate());
        this.GUsuarioxprogramaDTO.setMotivoEgreso(this.listarMotivosEgreso.get(this.JCBMotEgreso.getSelectedIndex()).getId());
        this.GUsuarioxprogramaDTO.setObservacionEgreso(this.JTPEFObsEgresos.getText());
        this.GUsuarioxprogramaDTO.setFecha(this.metodos.getFechaActual());
        this.GUsuarioxprogramaDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.GUsuarioxprogramaDTO.setViva(Boolean.valueOf(this.vivo));
        this.iUsuarioPorProgramaService.grabar(this.GUsuarioxprogramaDTO);
        this.JTFEstado.setText("EGRESADO");
        this.JBTEGuardar.setEnabled(true);
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JDFechaEgreso = new JDateChooser();
        this.JCBMotEgreso = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTPEFObsEgresos = new JTextArea();
        this.JPEstadoPaciente = new JPanel();
        this.JRBVivo = new JRadioButton();
        this.JRBMuerto = new JRadioButton();
        this.JBTEGuardar = new JButton();
        this.JTFEstado = new JLabel();
        this.JDFechaEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Egreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaEgreso.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEgreso.setFont(new Font("Arial", 1, 12));
        this.JCBMotEgreso.setFont(new Font("Arial", 1, 12));
        this.JCBMotEgreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo de Egreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEFObsEgresos.setColumns(1);
        this.JTPEFObsEgresos.setFont(new Font("Arial", 1, 12));
        this.JTPEFObsEgresos.setLineWrap(true);
        this.JTPEFObsEgresos.setRows(1);
        this.JTPEFObsEgresos.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTPEFObsEgresos);
        this.JPEstadoPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO DEL PACIENTE", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JPEstadoPaciente.setFont(new Font("Tahoma", 1, 12));
        this.buttonGroup1.add(this.JRBVivo);
        this.JRBVivo.setFont(new Font("Arial", 1, 12));
        this.JRBVivo.setSelected(true);
        this.JRBVivo.setText("Vivo");
        this.JRBVivo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoProgramas.1
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoProgramas.this.JRBVivoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBMuerto);
        this.JRBMuerto.setFont(new Font("Arial", 1, 12));
        this.JRBMuerto.setText("Muerto");
        this.JRBMuerto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoProgramas.2
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoProgramas.this.JRBMuertoActionPerformed(evt);
            }
        });
        GroupLayout JPEstadoPacienteLayout = new GroupLayout(this.JPEstadoPaciente);
        this.JPEstadoPaciente.setLayout(JPEstadoPacienteLayout);
        JPEstadoPacienteLayout.setHorizontalGroup(JPEstadoPacienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEstadoPacienteLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBVivo).addGap(18, 18, 18).addComponent(this.JRBMuerto).addContainerGap()));
        JPEstadoPacienteLayout.setVerticalGroup(JPEstadoPacienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoPacienteLayout.createSequentialGroup().addGroup(JPEstadoPacienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBVivo).addComponent(this.JRBMuerto)).addGap(0, 7, 32767)));
        this.JBTEGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTEGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTEGuardar.setText("Grabar");
        this.JBTEGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JP_EngresoProgramas.3
            public void actionPerformed(ActionEvent evt) {
                JP_EngresoProgramas.this.JBTEGuardarActionPerformed(evt);
            }
        });
        this.JBTEGuardar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.pyp.JP_EngresoProgramas.4
            public void keyPressed(KeyEvent evt) {
                JP_EngresoProgramas.this.JBTEGuardarKeyPressed(evt);
            }
        });
        this.JTFEstado.setFont(new Font("Arial", 1, 14));
        this.JTFEstado.setForeground(Color.red);
        this.JTFEstado.setHorizontalAlignment(0);
        this.JTFEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane2, -2, 746, -2).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaEgreso, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBMotEgreso, -2, 464, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPEstadoPaciente, -2, 150, -2)))).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JBTEGuardar, -2, 602, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEstado, -1, -1, 32767))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMotEgreso, -2, 51, -2).addComponent(this.JDFechaEgreso, -2, 50, -2).addComponent(this.JPEstadoPaciente, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 179, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTEGuardar, -2, 50, -2).addComponent(this.JTFEstado, -2, 50, -2)).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVivoActionPerformed(ActionEvent evt) {
        this.vivo = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMuertoActionPerformed(ActionEvent evt) {
        this.vivo = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEGuardarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            grabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEGuardarKeyPressed(KeyEvent evt) {
    }
}
