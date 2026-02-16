package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Utilidades.Email;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.RadicacionDetalleAuditoriaDTO;
import com.genoma.plus.jpa.projection.IAuditoresDocumentosContables;
import com.genoma.plus.jpa.service.IRadicacionDetalleAuditoriaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JDAuditoresDocumentos.class */
public class JDAuditoresDocumentos extends JDialog {
    private final IRadicacionDetalleAuditoriaDAO documentoDetalleAuditoriaDAO;
    private final Metodos metodos;
    private DefaultTableModel modelo;
    private Long idEmpresa;
    private Long idRadicacion;
    private JButton BTGrabar;
    private JButton BTSalir;
    private JButton BTSalir1;
    private JButton BTSalir2;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;

    @Generated
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    @Generated
    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Generated
    public void setIdRadicacion(Long idRadicacion) {
        this.idRadicacion = idRadicacion;
    }

    @Generated
    public void setBTGrabar(JButton BTGrabar) {
        this.BTGrabar = BTGrabar;
    }

    @Generated
    public void setBTSalir(JButton BTSalir) {
        this.BTSalir = BTSalir;
    }

    @Generated
    public void setBTSalir1(JButton BTSalir1) {
        this.BTSalir1 = BTSalir1;
    }

    @Generated
    public void setBTSalir2(JButton BTSalir2) {
        this.BTSalir2 = BTSalir2;
    }

    @Generated
    public void setJSPDetalle(JScrollPane JSPDetalle) {
        this.JSPDetalle = JSPDetalle;
    }

    @Generated
    public void setJTBDetalle(JTable JTBDetalle) {
        this.JTBDetalle = JTBDetalle;
    }

    @Generated
    public IRadicacionDetalleAuditoriaDAO getDocumentoDetalleAuditoriaDAO() {
        return this.documentoDetalleAuditoriaDAO;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public DefaultTableModel getModelo() {
        return this.modelo;
    }

    @Generated
    public Long getIdEmpresa() {
        return this.idEmpresa;
    }

    @Generated
    public Long getIdRadicacion() {
        return this.idRadicacion;
    }

    public JDAuditoresDocumentos(Frame parent, boolean modal, Long idEmpresa, Long idRadicacion) {
        super(parent, modal);
        this.documentoDetalleAuditoriaDAO = (IRadicacionDetalleAuditoriaDAO) Principal.contexto.getBean(IRadicacionDetalleAuditoriaDAO.class);
        this.metodos = new Metodos();
        initComponents();
        this.idEmpresa = idEmpresa;
        this.idRadicacion = idRadicacion;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        cargarAuditores();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.BTGrabar = new JButton();
        this.BTSalir2 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("AUDITORES DE DOCUMENTOS CONTABLES");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "AUDITORES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JDAuditoresDocumentos.1
            public void mouseClicked(MouseEvent evt) {
                JDAuditoresDocumentos.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.BTGrabar.setFont(new Font("Arial", 1, 12));
        this.BTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.BTGrabar.setText("Grabar");
        this.BTGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDAuditoresDocumentos.2
            public void actionPerformed(ActionEvent evt) {
                JDAuditoresDocumentos.this.BTGrabarActionPerformed(evt);
            }
        });
        this.BTSalir2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.BTSalir2.setText("Cerrar");
        this.BTSalir2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDAuditoresDocumentos.3
            public void actionPerformed(ActionEvent evt) {
                JDAuditoresDocumentos.this.BTSalir2ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPDetalle, -2, 709, -2).addGap(0, 2, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.BTGrabar, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.BTSalir2, -2, 250, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 225, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BTSalir2, -2, 50, -2).addComponent(this.BTGrabar, -2, 50, -2)).addGap(18, 18, 18)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BTGrabarActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTBDetalle.getValueAt(i, 3).toString()).booleanValue()) {
                RadicacionDetalleAuditoriaDTO e = new RadicacionDetalleAuditoriaDTO();
                e.setIdPersonaRh(Integer.valueOf(this.JTBDetalle.getValueAt(i, 0).toString()));
                e.setIdRadicacion(getIdRadicacion());
                e.setEstado(true);
                e.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                if (this.JTBDetalle.getValueAt(i, 5) != null) {
                    e.setId(Long.valueOf(this.JTBDetalle.getValueAt(i, 5).toString()));
                }
                this.JTBDetalle.setValueAt(getDocumentoDetalleAuditoriaDAO().grabar(e), i, 5);
                if (!this.JTBDetalle.getValueAt(i, 4).toString().isEmpty()) {
                    Email enviar = new Email();
                    String cuerpo = "Se le ha asignado el registro de auditoria No. " + this.JTBDetalle.getValueAt(i, 5).toString() + "\nTercero :" + Principal.xclase.xjifradicacion.JCBEmpresa.getSelectedItem() + "\nNo. Factura :" + Principal.xclase.xjifradicacion.JTFNFactura.getText() + "\nFavor entrar y  hacer el registro respectivo \n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario();
                    String remite = null;
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        remite = "noresponder@fundacionpanzenu.org.co";
                    } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS")) {
                        remite = "noresponder@clinicapajonal.com";
                    }
                    enviar.Send(this.JTBDetalle.getValueAt(i, 4).toString(), cuerpo, remite, "AUDITORIA FACTURA No." + Principal.xclase.xjifradicacion.JTFNFactura.getText());
                }
            }
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BTSalir2ActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void crearModeloTabla() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"idPersona", "Nombre", "Cargo", "Seleccionar", "Correo", "id"}) { // from class: com.genoma.plus.controller.contabilidad.JDAuditoresDocumentos.4
            Class[] types = {Long.class, String.class, String.class, Boolean.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.modelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void cargarAuditores() {
        crearModeloTabla();
        List<IAuditoresDocumentosContables> listaAuditores = this.documentoDetalleAuditoriaDAO.listaAuditoresContables(getIdEmpresa(), getIdRadicacion());
        if (listaAuditores.size() > 0) {
            this.metodos.mEstablecerTextEditor(this.JTBDetalle, 2);
            for (IAuditoresDocumentosContables listaAuditore : listaAuditores) {
                Object[] fila = {listaAuditore.getIdPersonaCargo(), listaAuditore.getAuditor(), listaAuditore.getCargo(), listaAuditore.getSeleccion(), listaAuditore.getCorreoElectronico(), listaAuditore.getId()};
                this.modelo.addRow(fila);
            }
        }
    }

    @Generated
    public JButton getBTGrabar() {
        return this.BTGrabar;
    }

    @Generated
    public JButton getBTSalir() {
        return this.BTSalir;
    }

    @Generated
    public JButton getBTSalir1() {
        return this.BTSalir1;
    }

    @Generated
    public JButton getBTSalir2() {
        return this.BTSalir2;
    }

    @Generated
    public JScrollPane getJSPDetalle() {
        return this.JSPDetalle;
    }

    @Generated
    public JTable getJTBDetalle() {
        return this.JTBDetalle;
    }
}
