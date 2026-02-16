package com.genoma.plus.controller.facturacion;

import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.FacturacionDAO;
import com.genoma.plus.dao.impl.facturacion.FacturacionDAOImp;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JP_SalidasInventario.class */
public class JP_SalidasInventario extends JPanel {
    private Metodos xmt = new Metodos();
    private FacturacionDAO ximplFacturacion;
    private DefaultTableModel xModelo;
    private DefaultTableModel xModelo1;
    private Object[] xdatos;
    private Long xId_Ingreso;
    private JScrollPane JSP_Detalle;
    private JScrollPane JSP_Detalle1;
    private JTabbedPane JTB_Salidad;
    private JTable JTDetalle;
    private JTable JTDetalle1;

    public JP_SalidasInventario(Long xId_Ingreso) {
        initComponents();
        this.xId_Ingreso = xId_Ingreso;
        springStart();
        mCargarDatos();
        mCargarDatos1();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTB_Salidad = new JTabbedPane();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSP_Detalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JTB_Salidad.setForeground(Color.red);
        this.JTB_Salidad.setFont(new Font("Arial", 1, 14));
        this.JSP_Detalle.setBorder((Border) null);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        this.JTB_Salidad.addTab("DETALLE SALIDA DE INVENTARIO", this.JSP_Detalle);
        this.JSP_Detalle1.setBorder((Border) null);
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JSP_Detalle1.setViewportView(this.JTDetalle1);
        this.JTB_Salidad.addTab("CONSOLIDADO POR BODEGA Y PRODUCTO", this.JSP_Detalle1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JTB_Salidad, -1, 822, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Salidad, -1, 499, 32767).addContainerGap()));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Producto", "Cantidad", "Lote", "Tipo Movimiento", "Bodega", "Tipo", "IdOrdenFac"}) { // from class: com.genoma.plus.controller.facturacion.JP_SalidasInventario.1
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo1() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Bodega", "Tipo Movimiento", "Tipo", "Producto", "Cantidad"}) { // from class: com.genoma.plus.controller.facturacion.JP_SalidasInventario.2
            Class[] types = {String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle1;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle1.doLayout();
        this.JTDetalle1.setModel(this.xModelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    private void mCargarDatos() {
        List<Object[]> list = this.ximplFacturacion.listSalidaInventario(this.xId_Ingreso);
        mCreaModelo();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xdatos);
            this.xModelo.setValueAt(list.get(x)[0], x, 0);
            this.xModelo.setValueAt(list.get(x)[1], x, 1);
            this.xModelo.setValueAt(list.get(x)[2], x, 2);
            this.xModelo.setValueAt(list.get(x)[3], x, 3);
            this.xModelo.setValueAt(list.get(x)[4], x, 4);
            this.xModelo.setValueAt(list.get(x)[5], x, 5);
            this.xModelo.setValueAt(list.get(x)[6], x, 6);
            this.xModelo.setValueAt(list.get(x)[7], x, 7);
            this.xModelo.setValueAt(list.get(x)[8], x, 8);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
        }
    }

    private void mCargarDatos1() {
        List<Object[]> list = this.ximplFacturacion.listSalidaInventarioCTipoMovimiento(this.xId_Ingreso);
        mCreaModelo1();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x)[0], x, 0);
            this.xModelo1.setValueAt(list.get(x)[1], x, 1);
            this.xModelo1.setValueAt(list.get(x)[2], x, 2);
            this.xModelo1.setValueAt(list.get(x)[3], x, 3);
            this.xModelo1.setValueAt(list.get(x)[4], x, 4);
        }
    }

    private void springStart() {
        this.ximplFacturacion = (FacturacionDAOImp) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("facturacionDAOImp");
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JP_SalidasInventario$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long IdOrdenFac = Long.parseLong(table.getValueAt(row, 8).toString());
            if (IdOrdenFac == 0) {
                cell.setBackground(Color.red);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
