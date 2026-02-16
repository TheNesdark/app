package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Armado.JIFGestionCartera;
import com.genoma.plus.jpa.entities.FacturaGlosaDetalle;
import com.genoma.plus.jpa.projection.ItemsGlosaNotaCredito;
import com.genoma.plus.jpa.service.ItemsGlosaNotaCreditoDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JDItemsGlosa.class */
public class JDItemsGlosa extends JDialog {
    private DefaultTableModel modelo;
    private Object[] datos;
    private Long ingreso;
    private ItemsGlosaNotaCreditoDAO xItemsGlosaNotacredito;
    JIFGestionCartera padre;
    private String esCapita;
    private String noFactura;
    private JButton jButton1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private JTable jTable1;

    public JDItemsGlosa(Frame parent, boolean modal, Long ingreso, JIFGestionCartera padre, String esCapita, String noFactura) {
        super(parent, modal);
        this.xItemsGlosaNotacredito = (ItemsGlosaNotaCreditoDAO) Principal.contexto.getBean(ItemsGlosaNotaCreditoDAO.class);
        initComponents();
        this.ingreso = ingreso;
        this.padre = padre;
        this.esCapita = esCapita;
        this.noFactura = noFactura;
        cargarDatosItemsGlosa();
    }

    public JDItemsGlosa(Frame parent, boolean modal, Long ingreso, JIFGestionCartera padre, List<FacturaGlosaDetalle> lista, String esCapita, String noFactura) {
        super(parent, modal);
        this.xItemsGlosaNotacredito = (ItemsGlosaNotaCreditoDAO) Principal.contexto.getBean(ItemsGlosaNotaCreditoDAO.class);
        initComponents();
        this.ingreso = ingreso;
        this.padre = padre;
        this.esCapita = esCapita;
        this.noFactura = noFactura;
        cargarDatosItemsGlosa();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "ITEMS GLOSA", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.jTable1.setFont(new Font("Arial", 1, 12));
        this.jTable1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jTable1.setSelectionForeground(new Color(255, 0, 0));
        this.jScrollPane2.setViewportView(this.jTable1);
        this.jButton1.setText("Aplicar");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDItemsGlosa.1
            public void actionPerformed(ActionEvent evt) {
                JDItemsGlosa.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 1030, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jButton1, -2, 150, -2).addGap(55, 55, 55)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 362, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -1, 51, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.jTable1.isEditing()) {
            this.jTable1.getCellEditor().stopCellEditing();
        }
        List<FacturaGlosaDetalle> listaGlosa = new ArrayList<>();
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            System.out.println("" + this.jTable1.getValueAt(i, 11).toString());
            if (Boolean.getBoolean(this.jTable1.getValueAt(i, 11).toString())) {
                FacturaGlosaDetalle factura = FacturaGlosaDetalle.builder().idFacturaGlosa(this.ingreso).idCodigo(Long.valueOf(Long.parseLong(this.jTable1.getValueAt(i, 9).toString()))).tipo(Integer.valueOf(Integer.parseInt(this.jTable1.getValueAt(i, 10).toString()))).cantidad(Double.valueOf(Double.parseDouble(this.jTable1.getValueAt(i, 3).toString()))).valorGlosado(Double.valueOf(Double.parseDouble(this.jTable1.getValueAt(i, 12).toString()))).observacion(this.jTable1.getValueAt(i, 13).toString()).estado(true).esCapita(Integer.valueOf(Integer.parseInt(this.esCapita))).build();
                listaGlosa.add(factura);
            }
        }
        this.padre.listaGlosa = listaGlosa;
        Double suma = Double.valueOf(0.0d);
        for (int j = 0; j < listaGlosa.size(); j++) {
            System.out.println(" " + this.jTable1.getValueAt(j, 12).toString());
            suma = Double.valueOf(suma.doubleValue() + Double.parseDouble(this.jTable1.getValueAt(j, 12).toString()));
        }
        this.padre.JTFFValorGlosado.setValue(suma);
        dispose();
    }

    private void cargarDatosItemsGlosa() {
        List<ItemsGlosaNotaCredito> listaItemsGlosa;
        crearModelo();
        System.out.println("ingreso " + this.ingreso);
        if (this.esCapita.equals("1")) {
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                listaItemsGlosa = this.xItemsGlosaNotacredito.listaItemsGlosaSaludIntegral(this.noFactura);
            } else {
                listaItemsGlosa = this.xItemsGlosaNotacredito.listaItemsGlosa(this.noFactura);
            }
        } else {
            listaItemsGlosa = this.xItemsGlosaNotacredito.listaItems(this.ingreso);
        }
        for (int j = 0; j < listaItemsGlosa.size(); j++) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getIdOrden(), j, 0);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getNombreServicio(), j, 1);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getNombreItems(), j, 2);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getCantidad(), j, 3);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getValorUnitario(), j, 4);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getValorDescuento(), j, 5);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getPorcentajeImpuesto(), j, 6);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getValorImpuesto(), j, 7);
            this.modelo.setValueAt(Double.valueOf(((listaItemsGlosa.get(j).getValorUnitario().doubleValue() * listaItemsGlosa.get(j).getCantidad().doubleValue()) + listaItemsGlosa.get(j).getValorImpuesto().doubleValue()) - listaItemsGlosa.get(j).getValorDescuento().doubleValue()), j, 8);
            System.out.println(" " + listaItemsGlosa.get(j).getIdSuminsitroProcedimiento());
            this.modelo.setValueAt(listaItemsGlosa.get(j).getIdSuminsitroProcedimiento(), j, 9);
            System.out.println("" + this.jTable1.getValueAt(j, 9).toString());
            this.modelo.setValueAt(listaItemsGlosa.get(j).getIdTipoServicio(), j, 10);
            if (this.padre.listaGlosa != null && this.padre.listaGlosa.size() > 0) {
                this.modelo.setValueAt(false, j, 11);
                this.modelo.setValueAt(this.padre.listaGlosa.get(j).getValorGlosado(), j, 12);
                this.modelo.setValueAt(this.padre.listaGlosa.get(j).getObservacion(), j, 13);
            } else {
                this.modelo.setValueAt(false, j, 11);
                this.modelo.setValueAt(0, j, 12);
                this.modelo.setValueAt("", j, 13);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"idOrden", "NombreServicio", "NombreItem", "Cantidad", "VrUnitario", "VrDescuento", "%Impuesto", "VrImpuesto", "VrTotal", "idSuministroxprocedimiento", "idTipoServicio", "Selecionar", "VrGlosado", "Observacion"}) { // from class: com.genoma.plus.controller.gcuenta.JDItemsGlosa.2
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Long.class, String.class, Boolean.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jTable1.setModel(this.modelo);
        this.jTable1.setAutoResizeMode(0);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        this.jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(190);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.jTable1.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.jTable1.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.jTable1.getColumnModel().getColumn(9).setMaxWidth(0);
        this.jTable1.getColumnModel().getColumn(9).setMinWidth(0);
        this.jTable1.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.jTable1.getColumnModel().getColumn(10).setMaxWidth(0);
        this.jTable1.getColumnModel().getColumn(10).setMinWidth(0);
        this.jTable1.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.jTable1.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.jTable1.getColumnModel().getColumn(13).setPreferredWidth(380);
    }
}
