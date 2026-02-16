package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.laboratorio.dto.ValidationDTO;
import com.genoma.plus.controller.laboratorio.enums.ValidationType;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JD_ValidacionAdministrativa.class */
public class JD_ValidacionAdministrativa extends JDialog {
    private Properties prop;
    private List<Long> idDetalleRecepcion;
    private Metodos metodos;
    private ButtonGroup JBGFiltro;
    private JButton JBGuardar;
    private JButton JBT_Salir;
    private JDateChooser JDFechaC;
    private JPanel JPI_Tipo;
    private JRadioButton JRB_Seguimiento;
    private JRadioButton JRB_Validado;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    private JTextField JTFCargo;
    private JTextField JTFUsuario;

    public JD_ValidacionAdministrativa(Frame parent, boolean modal, List<Long> idDetalleRecepcion) {
        super(parent, modal);
        initComponents();
        this.metodos = new Metodos();
        this.idDetalleRecepcion = idDetalleRecepcion;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        nuevo();
    }

    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JDFechaC = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBGuardar = new JButton();
        this.JBT_Salir = new JButton();
        this.JTFUsuario = new JTextField();
        this.JTFCargo = new JTextField();
        this.JPI_Tipo = new JPanel();
        this.JRB_Validado = new JRadioButton();
        this.JRB_Seguimiento = new JRadioButton();
        setDefaultCloseOperation(2);
        setTitle("CIERRE DE SEGUIMIENTO");
        setName("jdValidacionAdministartiva");
        this.JDFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JD_ValidacionAdministrativa.1
            public void actionPerformed(ActionEvent evt) {
                JD_ValidacionAdministrativa.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JD_ValidacionAdministrativa.2
            public void actionPerformed(ActionEvent evt) {
                JD_ValidacionAdministrativa.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JTFUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCargo.setFont(new Font("Arial", 1, 12));
        this.JTFCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_Tipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGFiltro.add(this.JRB_Validado);
        this.JRB_Validado.setFont(new Font("Arial", 1, 12));
        this.JRB_Validado.setSelected(true);
        this.JRB_Validado.setText("Validado");
        this.JBGFiltro.add(this.JRB_Seguimiento);
        this.JRB_Seguimiento.setFont(new Font("Arial", 1, 12));
        this.JRB_Seguimiento.setText("Seguimiento");
        GroupLayout JPI_TipoLayout = new GroupLayout(this.JPI_Tipo);
        this.JPI_Tipo.setLayout(JPI_TipoLayout);
        JPI_TipoLayout.setHorizontalGroup(JPI_TipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Validado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Seguimiento).addContainerGap(-1, 32767)));
        JPI_TipoLayout.setVerticalGroup(JPI_TipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_TipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Validado).addComponent(this.JRB_Seguimiento)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFUsuario, -2, 363, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCargo)).addGroup(layout.createSequentialGroup().addComponent(this.JBGuardar, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 261, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaC, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addComponent(this.JPI_Tipo, -2, -1, -2).addGap(268, 268, 268)).addComponent(this.JSPObservacion)).addGap(14, 14, 14)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaC, -1, 56, 32767).addComponent(this.JPI_Tipo, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 213, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFUsuario, -2, 50, -2).addComponent(this.JTFCargo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBGuardar, -1, -1, 32767).addComponent(this.JBT_Salir, -2, 44, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        if (!this.JTAObservacion.getText().isEmpty()) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                grabar();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La observacion no puede ser nula", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void grabar() {
        try {
            RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("24", "jdValidacionAdministartiva");
            List<ValidationDTO> list = new ArrayList<>();
            this.idDetalleRecepcion.forEach(e -> {
                ValidationType type = ValidationType.FOLLOWUP;
                if (this.JRB_Validado.isSelected()) {
                    type = ValidationType.VALIDATED;
                }
                ValidationDTO dTO = ValidationDTO.builder().cargo(Principal.usuarioSistemaDTO.getNombreCargoUsuario()).dateTime(this.JDFechaC.getDate()).idDetailReception(e).observation(this.JTAObservacion.getText()).validationTypeEnum(type).state(true).user(Principal.usuarioSistemaDTO.getNombreUsuario()).usuarioCreacion(Principal.usuarioSistemaDTO.getLogin()).build();
                list.add(dTO);
            });
            Response response = this.metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(list)));
            response.close();
            this.metodos.getResteasyClient().close();
            if (Principal.claselab.administrativa != null) {
                Principal.claselab.administrativa.buscar();
            }
            dispose();
        } catch (JsonProcessingException e2) {
            Logger.getLogger(JIFvalidacionAdministrativa.class.getName()).log(Level.SEVERE, (String) null, e2);
        }
    }

    private void nuevo() {
        this.JDFechaC.setDate(new Date());
        this.JTFCargo.setText(Principal.usuarioSistemaDTO.getNombreCargoUsuario());
        this.JTFUsuario.setText(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.JDFechaC.setEnabled(false);
        this.JTFCargo.setEditable(false);
        this.JTFUsuario.setEditable(false);
    }
}
