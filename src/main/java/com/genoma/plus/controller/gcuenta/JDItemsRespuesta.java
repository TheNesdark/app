package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Armado.JIFGestionCartera;
import com.genoma.plus.jpa.entities.FacturaNotaDetalle;
import com.genoma.plus.jpa.projection.DetalleGlosa;
import com.genoma.plus.jpa.service.FacturaGlosaDetalleDAO;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JDItemsRespuesta.class */
public class JDItemsRespuesta extends JDialog {
    private DefaultTableModel modelo;
    private Object[] datos;
    private Long factura;
    private FacturaGlosaDetalleDAO xItemsGlosaNotacredito;
    JIFGestionCartera padre;
    private JTable JTDetalle;
    private JButton jButton1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDItemsRespuesta(Frame parent, boolean modal, Long factura, JIFGestionCartera padre) {
        super(parent, modal);
        this.xItemsGlosaNotacredito = (FacturaGlosaDetalleDAO) Principal.contexto.getBean(FacturaGlosaDetalleDAO.class);
        initComponents();
        this.factura = factura;
        this.padre = padre;
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("Aplicar");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDItemsRespuesta.1
            public void actionPerformed(ActionEvent evt) {
                JDItemsRespuesta.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 928, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jButton1, -2, 151, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 366, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -1, 48, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.isEditing()) {
            this.JTDetalle.getCellEditor().stopCellEditing();
        }
        List<FacturaNotaDetalle> listaNota = new ArrayList<>();
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            System.out.println("" + this.JTDetalle.getValueAt(i, 8).toString());
        }
        Double suma = Double.valueOf(0.0d);
        for (int j = 0; j < listaNota.size(); j++) {
            suma = Double.valueOf(suma.doubleValue() + Double.parseDouble(this.JTDetalle.getValueAt(j, 6).toString()));
        }
        this.padre.JTFFRValorAceptado.setValue(suma);
        this.padre.listaNotaDetalle = listaNota;
        dispose();
    }

    private void cargarDatos() {
        crearModelo();
        System.out.println("ingreso " + this.factura);
        List<DetalleGlosa> listaItemsGlosa = this.xItemsGlosaNotacredito.listaGlosa(this.factura);
        for (int j = 0; j < listaItemsGlosa.size(); j++) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getIdFactura(), j, 0);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getItem(), j, 1);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getCantidad(), j, 2);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getValorGlosado(), j, 3);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getIdCodigo(), j, 4);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getTipo(), j, 5);
            this.modelo.setValueAt(0, j, 6);
            this.modelo.setValueAt(0, j, 7);
            this.modelo.setValueAt("", j, 8);
            this.modelo.setValueAt(listaItemsGlosa.get(j).getEsCapita(), j, 9);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"idGlosa", "NombreItem", "Cantidad", "valorGlosa", "idSuministroxprocedimiento", "idTipoServicio", "VrAceptado", "VrARecobrar", "Observacion", "esCapita"}) { // from class: com.genoma.plus.controller.gcuenta.JDItemsRespuesta.2
            Class[] types = {Long.class, String.class, Double.class, Double.class, Long.class, Integer.class, Double.class, Double.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(280);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
    }
}
