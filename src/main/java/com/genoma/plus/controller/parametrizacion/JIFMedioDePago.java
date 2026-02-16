package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.MedioPago;
import com.genoma.plus.jpa.service.IMedioPagoService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIFMedioDePago.class */
public class JIFMedioDePago extends JInternalFrame {
    private MedioPago medioPago;
    private final IMedioPagoService iMedioPagoService;
    private List<MedioPago> listarMedioPago;
    private DefaultTableModel modelo;
    private Object[] datos;
    private Metodos metodos = new Metodos();
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFCuentaDebito;
    private JTextField JTFNombre;

    public JIFMedioDePago() {
        initComponents();
        this.medioPago = new MedioPago();
        this.iMedioPagoService = (IMedioPagoService) Principal.contexto.getBean(IMedioPagoService.class);
        this.listarMedioPago = new ArrayList();
        this.modelo = new DefaultTableModel();
        cargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFCuentaDebito = new JTextField();
        this.JTFNombre = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("Medio de Pago");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("MedioDePago");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFMedioDePago.1
            public void actionPerformed(ActionEvent evt) {
                JIFMedioDePago.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFCuentaDebito.setFont(new Font("Arial", 1, 12));
        this.JTFCuentaDebito.setToolTipText("");
        this.JTFCuentaDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCuentaDebito, -2, 325, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(0, 0, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 133, -2).addGap(18, 18, 18).addComponent(this.JTFNombre))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCuentaDebito, -2, 50, -2).addComponent(this.JCHEstado)).addGap(6, 6, 6)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIFMedioDePago.2
            public void mouseClicked(MouseEvent evt) {
                JIFMedioDePago.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, -1, 659, 32767).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap(17, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 325, 32767).addContainerGap()));
        getAccessibleContext().setAccessibleName("MedioDePago");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTFCodigo.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if (Boolean.valueOf(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstado.setSelected(Boolean.valueOf(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            } else {
                this.JCHEstado.setSelected(false);
            }
            System.out.println("this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString() -> " + this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFCuentaDebito.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"CODIGO", "NOMBRE", "CUENTA DEBITO", "ESTADO", "ID"}) { // from class: com.genoma.plus.controller.parametrizacion.JIFMedioDePago.3
            Class[] types = {String.class, String.class, String.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.doLayout();
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void cargarDatosTabla() {
        crearModeloTabla();
        this.listarMedioPago = this.iMedioPagoService.listarMediosPagos();
        this.listarMedioPago.forEach(a -> {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(a.getCodigo(), this.JTDetalle.getRowCount() - 1, 0);
            this.modelo.setValueAt(a.getNombre(), this.JTDetalle.getRowCount() - 1, 1);
            this.modelo.setValueAt(a.getCuentaDebito(), this.JTDetalle.getRowCount() - 1, 2);
            this.modelo.setValueAt(a.getEstado(), this.JTDetalle.getRowCount() - 1, 3);
            this.modelo.setValueAt(a.getId(), this.JTDetalle.getRowCount() - 1, 4);
        });
    }

    public void grabar() {
        if (!this.JTFCodigo.getText().isEmpty() || !this.JTFNombre.getText().isEmpty()) {
            this.medioPago.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
            this.medioPago.setCodigo(this.JTFCodigo.getText());
            this.medioPago.setNombre(this.JTFNombre.getText());
            this.medioPago.setCuentaDebito(this.JTFCuentaDebito.getText());
            if (this.JCHEstado.isSelected()) {
                this.medioPago.setEstado(true);
            } else {
                this.medioPago.setEstado(false);
            }
            this.medioPago.setUsuarios(Principal.usuarioSistemaDTO.getLogin());
            this.iMedioPagoService.grabar(this.medioPago);
            JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
            this.JTFCodigo.setText("");
            this.JTFNombre.setText("");
            this.JTFCuentaDebito.setText("");
            Principal.txtNo.setText("");
            cargarDatosTabla();
        }
    }
}
