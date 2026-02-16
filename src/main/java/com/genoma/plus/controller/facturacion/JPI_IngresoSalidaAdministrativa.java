package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import General.Anular;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.IngresoSalidaAdministrativaDTO;
import com.genoma.plus.jpa.projection.IInformacionIngresoSalidaAdministrativaDTO;
import com.genoma.plus.jpa.service.IIngresoSalidaAdministrativaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPI_IngresoSalidaAdministrativa.class */
public class JPI_IngresoSalidaAdministrativa extends JPanel {
    private IInformacionIngresoSalidaAdministrativaDTO informacionIngresoSalidaAdministrativaDTO;
    private IngresoSalidaAdministrativaDTO ingresoSalidaAdministrativaDTO;
    private Long idIngreso;
    public JDateChooser JDFecha;
    private JLabel JLB_PersonaRh;
    private JLabel JLNOrden;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    private Metodos metodos = new Metodos();
    private final IIngresoSalidaAdministrativaService ingresoSalidaAdministrativaService = (IIngresoSalidaAdministrativaService) Principal.contexto.getBean(IIngresoSalidaAdministrativaService.class);

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setInformacionIngresoSalidaAdministrativaDTO(IInformacionIngresoSalidaAdministrativaDTO informacionIngresoSalidaAdministrativaDTO) {
        this.informacionIngresoSalidaAdministrativaDTO = informacionIngresoSalidaAdministrativaDTO;
    }

    @Generated
    public void setIngresoSalidaAdministrativaDTO(IngresoSalidaAdministrativaDTO ingresoSalidaAdministrativaDTO) {
        this.ingresoSalidaAdministrativaDTO = ingresoSalidaAdministrativaDTO;
    }

    @Generated
    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    @Generated
    public void setJDFecha(JDateChooser JDFecha) {
        this.JDFecha = JDFecha;
    }

    @Generated
    public void setJLB_PersonaRh(JLabel JLB_PersonaRh) {
        this.JLB_PersonaRh = JLB_PersonaRh;
    }

    @Generated
    public void setJLNOrden(JLabel JLNOrden) {
        this.JLNOrden = JLNOrden;
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
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public IInformacionIngresoSalidaAdministrativaDTO getInformacionIngresoSalidaAdministrativaDTO() {
        return this.informacionIngresoSalidaAdministrativaDTO;
    }

    @Generated
    public IngresoSalidaAdministrativaDTO getIngresoSalidaAdministrativaDTO() {
        return this.ingresoSalidaAdministrativaDTO;
    }

    @Generated
    public IIngresoSalidaAdministrativaService getIngresoSalidaAdministrativaService() {
        return this.ingresoSalidaAdministrativaService;
    }

    @Generated
    public Long getIdIngreso() {
        return this.idIngreso;
    }

    public JPI_IngresoSalidaAdministrativa(Long idIngreso) {
        initComponents();
        setIdIngreso(idIngreso);
        consultarDatosTabla();
    }

    private void initComponents() {
        this.JDFecha = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLNOrden = new JLabel();
        this.JLB_PersonaRh = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "SALIDA ADMINISTRATIVA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setFont(new Font("Arial", 1, 14));
        setName("jpSalidaAdministrativa");
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Tahoma", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo de salida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JLNOrden.setFont(new Font("Arial", 1, 14));
        this.JLNOrden.setForeground(Color.blue);
        this.JLNOrden.setHorizontalAlignment(0);
        this.JLNOrden.setText("0");
        this.JLNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registro", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JLB_PersonaRh.setFont(new Font("Arial", 1, 12));
        this.JLB_PersonaRh.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario Sistemas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JLB_PersonaRh, -1, -1, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.JDFecha, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 380, 32767).addComponent(this.JLNOrden, -2, 129, -2).addGap(21, 21, 21)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JSPObservacion).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLNOrden, -2, 50, -2).addComponent(this.JDFecha, -2, 50, -2)).addGap(12, 12, 12).addComponent(this.JSPObservacion, -2, 149, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_PersonaRh, -2, 50, -2).addContainerGap()));
    }

    private void nuevo() {
        this.JDFecha.setDate(getMetodos().getFechaActual());
        this.JLNOrden.setText("");
        this.JTAObservacion.setText("");
        this.JLB_PersonaRh.setText("");
    }

    private void consultarDatosTabla() {
        nuevo();
        setInformacionIngresoSalidaAdministrativaDTO(getIngresoSalidaAdministrativaService().informacionSalidaAdministrativaPorIdIngreso(getIdIngreso()));
        if (getInformacionIngresoSalidaAdministrativaDTO() != null) {
            this.JDFecha.setDate(getInformacionIngresoSalidaAdministrativaDTO().getFechaSolicitud());
            this.JLNOrden.setText("" + getInformacionIngresoSalidaAdministrativaDTO().getId());
            this.JTAObservacion.setText(getInformacionIngresoSalidaAdministrativaDTO().getMotivoSalida());
            this.JLB_PersonaRh.setText(getInformacionIngresoSalidaAdministrativaDTO().getUsuarioCargo());
            setIngresoSalidaAdministrativaDTO(getIngresoSalidaAdministrativaService().ingresoSalidaAdministrativaPorId(getInformacionIngresoSalidaAdministrativaDTO().getId()));
            return;
        }
        this.ingresoSalidaAdministrativaDTO = new IngresoSalidaAdministrativaDTO();
        this.JLB_PersonaRh.setText(Principal.usuarioSistemaDTO.getNombreUsuario() + " - " + Principal.usuarioSistemaDTO.getNombreCargoUsuario());
    }

    public void grabar() {
        if (!this.JTAObservacion.getText().isEmpty()) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                getIngresoSalidaAdministrativaDTO().setIdIngreso(getIdIngreso());
                getIngresoSalidaAdministrativaDTO().setFechaS(this.JDFecha.getDate());
                getIngresoSalidaAdministrativaDTO().setMotivoSalida(this.JTAObservacion.getText());
                getIngresoSalidaAdministrativaDTO().setIdPersonaRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                getIngresoSalidaAdministrativaDTO().setFecha(getMetodos().getFechaActual());
                getIngresoSalidaAdministrativaDTO().setEstado(true);
                Long id = this.ingresoSalidaAdministrativaService.grabar(this.ingresoSalidaAdministrativaDTO);
                this.JLNOrden.setText("" + id);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Motivo de salida no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void anular() {
        if (!this.JLNOrden.getText().equals("0") || !this.JLNOrden.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "SALIDA ADMINISTRATIVA", 5);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No hay orden de salida administrativa para este ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void anularDetalle(String detalle, String concepto) {
        getIngresoSalidaAdministrativaDTO().setEstado(false);
        getIngresoSalidaAdministrativaDTO().setConceptoAnulacion(concepto);
        getIngresoSalidaAdministrativaDTO().setDetalleAnulacion(detalle);
        getIngresoSalidaAdministrativaDTO().setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreCargoUsuario());
        getIngresoSalidaAdministrativaDTO().setFechaAnulacion(getMetodos().getFechaActual());
        this.ingresoSalidaAdministrativaService.grabar(this.ingresoSalidaAdministrativaDTO);
        consultarDatosTabla();
    }

    @Generated
    public JDateChooser getJDFecha() {
        return this.JDFecha;
    }

    @Generated
    public JLabel getJLB_PersonaRh() {
        return this.JLB_PersonaRh;
    }

    @Generated
    public JLabel getJLNOrden() {
        return this.JLNOrden;
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
