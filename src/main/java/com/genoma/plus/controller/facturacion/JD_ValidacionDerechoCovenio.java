package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.ValidacionDetalleDTO;
import com.genoma.plus.jpa.projection.IInformacionValidacionUsuarioDTO;
import com.genoma.plus.jpa.service.IValidacionDetalleService;
import com.genoma.plus.jpa.service.IValidacionEncabezadoService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JD_ValidacionDerechoCovenio.class */
public class JD_ValidacionDerechoCovenio extends JDialog {
    private DefaultTableModel modelo;
    private final IValidacionEncabezadoService validacionEncabezadoService;
    private final IValidacionDetalleService validacionDetalleService;
    private final String tipoDocumento;
    private final String numeroDocumento;
    private Object[] dato;
    private Metodos metodos;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;

    public JD_ValidacionDerechoCovenio(Frame parent, boolean modal, String tipoDocumento, String numeroDocumento) {
        super(parent, modal);
        this.validacionEncabezadoService = (IValidacionEncabezadoService) Principal.contexto.getBean(IValidacionEncabezadoService.class);
        this.validacionDetalleService = (IValidacionDetalleService) Principal.contexto.getBean(IValidacionDetalleService.class);
        this.metodos = new Metodos();
        initComponents();
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setDefaultCloseOperation(2);
        setTitle("RESULTADO VALIDACIÓN DE DERECHO");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "CONVENIO RELACIONADOS PARA FACTURACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setAutoResizeMode(0);
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JD_ValidacionDerechoCovenio.1
            public void mouseClicked(MouseEvent evt) {
                JD_ValidacionDerechoCovenio.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 708, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle, -2, 229, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            ValidacionDetalleDTO detalleDTO = this.validacionDetalleService.informacionUsuarioPorId(Long.valueOf(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString()));
            Principal.clasefacturacion.frmFacturac.frmPersona.txtApellido1.setText(detalleDTO.getApellido1());
            Principal.clasefacturacion.frmFacturac.frmPersona.txtApellido2.setText(detalleDTO.getApellido2());
            Principal.clasefacturacion.frmFacturac.frmPersona.txtNombre1.setText(detalleDTO.getNombre1());
            Principal.clasefacturacion.frmFacturac.frmPersona.txtNombre2.setText(detalleDTO.getNombre2());
            Principal.clasefacturacion.frmFacturac.frmPersona.cboFechaNacimiento.setDate(this.metodos.getPasarTextoaFecha(detalleDTO.getFechaNacimiento()));
            Principal.clasefacturacion.frmFacturac.frmPersona.txtDireccion.setText(detalleDTO.getDireccion());
            Principal.clasefacturacion.frmFacturac.frmPersona.txtTelefono.setText(detalleDTO.getTelefono());
            Principal.clasefacturacion.frmFacturac.frmPersona.txtTelefono1.setText(detalleDTO.getTelefono());
            if (detalleDTO.getSexo().equals("F")) {
                Principal.clasefacturacion.frmFacturac.frmPersona.cboSexo.setSelectedItem("FEMENINO");
            } else if (detalleDTO.getSexo().equals("M")) {
                Principal.clasefacturacion.frmFacturac.frmPersona.cboSexo.setSelectedItem("MASCULINO");
            }
            Principal.clasefacturacion.frmFacturac.frmPersona.cboEps.setSelectedItem(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            Principal.clasefacturacion.frmFacturac.frmIngreso.cboEmpresa.setSelectedItem(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            dispose();
        }
    }

    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Nombre Empresa", "Nombre Convenio", "id"}) { // from class: com.genoma.plus.controller.facturacion.JD_ValidacionDerechoCovenio.2
            Class[] types = {String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.modelo);
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(250);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void cargarDatos() {
        crearModeloDatos();
        List<IInformacionValidacionUsuarioDTO> list = this.validacionEncabezadoService.informacionConvenioValidacion(this.tipoDocumento, this.numeroDocumento);
        list.forEach(next -> {
            this.modelo.addRow(this.dato);
            int nfila = this.JTBDetalle.getRowCount() - 1;
            this.modelo.setValueAt(next.getNombreEntidad(), nfila, 0);
            this.modelo.setValueAt(next.getNombreConvenio(), nfila, 1);
            this.modelo.setValueAt(next.getIdValidacionDetalle(), nfila, 2);
        });
    }
}
