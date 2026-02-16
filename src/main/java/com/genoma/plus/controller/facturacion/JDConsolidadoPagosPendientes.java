package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import com.genoma.plus.jpa.projection.ILiquidacionDeudaUsuarioProjection;
import com.genoma.plus.jpa.service.ILiquidacionService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JDConsolidadoPagosPendientes.class */
public class JDConsolidadoPagosPendientes extends JDialog {
    private final ILiquidacionService liquidacionService;
    private DefaultTableModel modelo;
    private Object[] datos;
    private Long idPersona;
    private Double valor;
    private String nombreFormulario;
    private List<ILiquidacionDeudaUsuarioProjection> liquidacionDeudaUsuarios;
    private JButton JBT_Salir;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFTotal;

    public JDConsolidadoPagosPendientes(Frame parent, boolean modal, Long idPersona, String nombreFormulario, List<ILiquidacionDeudaUsuarioProjection> liquidacionDeudaUsuarios) {
        super(parent, modal);
        this.liquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
        this.liquidacionDeudaUsuarios = new ArrayList();
        initComponents();
        this.idPersona = idPersona;
        this.nombreFormulario = nombreFormulario;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.liquidacionDeudaUsuarios = liquidacionDeudaUsuarios;
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_Salir = new JButton();
        this.JTFFTotal = new JFormattedTextField();
        setDefaultCloseOperation(2);
        setTitle("CONSOLIDADO DE LIQUIDACIONES PENDIENTES POR PAGO");
        setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JDConsolidadoPagosPendientes.1
            public void mouseClicked(MouseEvent evt) {
                JDConsolidadoPagosPendientes.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDConsolidadoPagosPendientes.2
            public void actionPerformed(ActionEvent evt) {
                JDConsolidadoPagosPendientes.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotal.setForeground(Color.red);
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 14));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, -2, 692, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Salir, -2, 400, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFTotal, -2, 157, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JSPDetalle, -2, 255, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBT_Salir, -1, 50, 32767).addComponent(this.JTFFTotal)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getSelectedRow() != -1 && this.nombreFormulario.equals("Recibos")) {
            Principal.clasecaja.frmRecibos.cboEPS.setSelectedItem(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0));
            Principal.clasecaja.frmRecibos.txtNoFactura.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            Principal.clasecaja.frmRecibos.buscarFactura();
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDetalle() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Convenio", "Subgrupo", "FechaOrdenFactura", "numeroOrdenFactura", "Valor Total", "Valor Pagado", "Total a Pagar"}) { // from class: com.genoma.plus.controller.facturacion.JDConsolidadoPagosPendientes.3
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void cargarDatos() {
        crearModeloDetalle();
        this.valor = new Double(0.0d);
        this.liquidacionDeudaUsuarios.forEach(detalle -> {
            this.modelo.addRow(this.datos);
            this.JTDetalle.setValueAt(detalle.getEmpresaConvenio(), this.JTDetalle.getRowCount() - 1, 0);
            this.JTDetalle.setValueAt(detalle.getSubgrupoServicio(), this.JTDetalle.getRowCount() - 1, 1);
            this.JTDetalle.setValueAt(detalle.getFechaOrdenFactura(), this.JTDetalle.getRowCount() - 1, 2);
            this.JTDetalle.setValueAt(detalle.getNumeroOrdenFactura(), this.JTDetalle.getRowCount() - 1, 3);
            this.JTDetalle.setValueAt(detalle.getVarloOrdenFactura(), this.JTDetalle.getRowCount() - 1, 4);
            this.JTDetalle.setValueAt(detalle.getValorPagado(), this.JTDetalle.getRowCount() - 1, 5);
            this.JTDetalle.setValueAt(detalle.getValorAPagar(), this.JTDetalle.getRowCount() - 1, 6);
            this.valor = Double.valueOf(this.valor.doubleValue() + detalle.getValorAPagar().doubleValue());
        });
        this.JTFFTotal.setValue(this.valor);
    }
}
