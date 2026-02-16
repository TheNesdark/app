package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GTipoDocumentoSoporte;
import com.genoma.plus.jpa.entities.ReportesDTO;
import com.genoma.plus.jpa.projection.GTipoDocumentoSoporteProjection;
import com.genoma.plus.jpa.service.GTipoDocumentoSoporteService;
import com.genoma.plus.jpa.service.IReportesService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGTipoDocumentoSoporte.class */
public class JIFGTipoDocumentoSoporte extends JInternalFrame {
    private List<ReportesDTO> listaReportes;
    private DefaultTableModel xmodelo;
    private Object[] datos;
    private List<GTipoDocumentoSoporteProjection> documentoSoporteProjections;
    private JComboBox JCBReportes;
    private JCheckBox JCHEstado;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private Metodos xmt = new Metodos();
    private final IReportesService reportesService = (IReportesService) Principal.contexto.getBean(IReportesService.class);
    private final GTipoDocumentoSoporteService Detalle = (GTipoDocumentoSoporteService) Principal.contexto.getBean(GTipoDocumentoSoporteService.class);
    private int xGuardado = 0;

    public JIFGTipoDocumentoSoporte() {
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBReportes = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE DOCUMENTO SOPORTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipodedocumentosoporte");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGTipoDocumentoSoporte.1
            public void actionPerformed(ActionEvent evt) {
                JIFGTipoDocumentoSoporte.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBReportes.setFont(new Font("Arial", 1, 12));
        this.JCBReportes.setBorder(BorderFactory.createTitledBorder((Border) null, "Reporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBReportes, -2, 290, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 51, -2).addComponent(this.JCBReportes).addComponent(this.JCHEstado)).addContainerGap(21, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane1.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGTipoDocumentoSoporte.2
            public void mouseClicked(MouseEvent evt) {
                JIFGTipoDocumentoSoporte.this.jScrollPane1MouseClicked(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGTipoDocumentoSoporte.3
            public void mouseClicked(MouseEvent evt) {
                JIFGTipoDocumentoSoporte.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 755, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 308, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    public void cargarDetalles() {
        mModelo();
        this.documentoSoporteProjections = this.Detalle.ListaTipoDocSoporte();
        System.out.println("entra al metodo" + this.documentoSoporteProjections.size());
        if (this.documentoSoporteProjections != null && !this.documentoSoporteProjections.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
            this.documentoSoporteProjections.forEach(detalle -> {
                this.xmodelo.addRow(this.datos);
                this.JTDetalle.setValueAt(detalle.getId(), this.JTDetalle.getRowCount() - 1, 0);
                this.JTDetalle.setValueAt(detalle.getNbre(), this.JTDetalle.getRowCount() - 1, 1);
                this.JTDetalle.setValueAt(detalle.getNbreReporte(), this.JTDetalle.getRowCount() - 1, 2);
                this.JTDetalle.setValueAt(detalle.getEstado(), this.JTDetalle.getRowCount() - 1, 3);
            });
        }
        this.listaReportes = this.reportesService.listaReportesPorEstadoOrdenadoPorNombre(true);
        this.JCBReportes.removeAllItems();
        this.listaReportes.forEach(next -> {
            this.JCBReportes.addItem(next.getNbre());
        });
        this.JCBReportes.setSelectedIndex(-1);
    }

    public void mNuevo() {
        cargarDetalles();
        this.JCBReportes.setSelectedIndex(-1);
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xGuardado = 0;
    }

    public void mGrabar() {
        GTipoDocumentoSoporte documentoSoporte = new GTipoDocumentoSoporte();
        if (this.xGuardado == 0) {
            if (!this.JTFNombre.getText().isEmpty() && this.JCBReportes.getSelectedIndex() > -1) {
                documentoSoporte.setNbre(this.JTFNombre.getText());
                documentoSoporte.setIdReporte(this.listaReportes.get(this.JCBReportes.getSelectedIndex()).getId());
                documentoSoporte.setUsuarioS(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                if (this.JCHEstado.isSelected()) {
                    documentoSoporte.setEstado(true);
                } else {
                    documentoSoporte.setEstado(false);
                }
                this.Detalle.grabar(documentoSoporte);
                JOptionPane.showMessageDialog((Component) null, "Agregado.", "Mensaje", 1);
                mNuevo();
                cargarDetalles();
            } else {
                JOptionPane.showMessageDialog((Component) null, "Llene todos los campos antes de guardar.", "Error", 0);
            }
            this.xGuardado = 0;
            return;
        }
        if (this.xGuardado == 1) {
            if (!this.JTFNombre.getText().isEmpty() && this.JCBReportes.getSelectedIndex() > -1) {
                documentoSoporte.setId(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
                documentoSoporte.setNbre(this.JTFNombre.getText());
                documentoSoporte.setIdReporte(this.listaReportes.get(this.JCBReportes.getSelectedIndex()).getId());
                documentoSoporte.setUsuarioS(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                if (this.JCHEstado.isSelected()) {
                    documentoSoporte.setEstado(true);
                } else {
                    documentoSoporte.setEstado(false);
                }
                this.Detalle.grabar(documentoSoporte);
                JOptionPane.showMessageDialog((Component) null, "Agregado.", "Mensaje", 1);
                mNuevo();
                cargarDetalles();
            } else {
                JOptionPane.showMessageDialog((Component) null, "Llene todos los campos antes de guardar.", "Error", 0);
            }
            this.xGuardado = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Reporte", "Estado"}) { // from class: ParametrizacionN.JIFGTipoDocumentoSoporte.4
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() > -1) {
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBReportes.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
            } else {
                this.JCHEstado.setSelected(false);
            }
            this.xGuardado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jScrollPane1MouseClicked(MouseEvent evt) {
    }
}
