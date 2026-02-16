package com.genoma.plus.controller.integracion_simedis;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/DetalleItemsOrden.class */
public class DetalleItemsOrden extends JDialog {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private ConsultasMySQL xcsmysql;
    List<Object[]> listaDetalleProcedimientoEditar;
    private Metodos metodos;
    private JButton JBGrabar;
    private JButton JBSalir;
    private JTable JTable;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;

    public DetalleItemsOrden(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmodelo = new DefaultTableModel();
        this.xcsmysql = new ConsultasMySQL();
        this.listaDetalleProcedimientoEditar = null;
        this.metodos = new Metodos();
        initComponents();
        crearModeloDatos();
    }

    public DetalleItemsOrden(Frame parent, boolean modal, List<Object[]> listaDetalleProcedimiento) {
        super(parent, modal);
        this.xmodelo = new DefaultTableModel();
        this.xcsmysql = new ConsultasMySQL();
        this.listaDetalleProcedimientoEditar = null;
        this.metodos = new Metodos();
        initComponents();
        this.listaDetalleProcedimientoEditar = listaDetalleProcedimiento;
        crearModeloDatos();
        mCargarDatosTabla(listaDetalleProcedimiento);
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/DetalleItemsOrden$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "CodCUPS", "Procedimiento", "Valor", "idTipoServicio", "IdTipoFinProcedimiento", "codigocnt", "HCli_ID", "PCli_ID"}) { // from class: com.genoma.plus.controller.integracion_simedis.DetalleItemsOrden.1
            Class[] types = {Integer.class, String.class, String.class, Long.class, Integer.class, String.class, Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTable.setModel(this.xmodelo);
        this.JTable.doLayout();
        this.JTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTable.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTable.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTable.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTable.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTable.getColumnModel().getColumn(8).setPreferredWidth(0);
    }

    private void listarEmpresasBienEstar(String busqueda) {
    }

    private void mCargarDatosTabla(List<Object[]> listaDetalleProcedimientoEditar) {
        crearModeloDatos();
        if (listaDetalleProcedimientoEditar.size() > 0) {
            int x = 0;
            for (int i = 0; i < listaDetalleProcedimientoEditar.size(); i++) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(listaDetalleProcedimientoEditar.get(i)[0].toString(), x, 0);
                this.xmodelo.setValueAt(listaDetalleProcedimientoEditar.get(i)[1].toString(), x, 1);
                this.xmodelo.setValueAt(listaDetalleProcedimientoEditar.get(i)[2].toString(), x, 2);
                this.xmodelo.setValueAt(listaDetalleProcedimientoEditar.get(i)[3].toString(), x, 3);
                this.xmodelo.setValueAt(listaDetalleProcedimientoEditar.get(i)[4].toString(), x, 4);
                this.xmodelo.setValueAt(listaDetalleProcedimientoEditar.get(i)[5].toString(), x, 5);
                this.xmodelo.setValueAt(listaDetalleProcedimientoEditar.get(i)[6].toString(), x, 6);
                this.xmodelo.setValueAt(listaDetalleProcedimientoEditar.get(i)[7].toString(), x, 7);
                this.xmodelo.setValueAt(listaDetalleProcedimientoEditar.get(i)[8].toString(), x, 8);
                this.JTable.setDefaultRenderer(Object.class, new MiRender());
                x++;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTable = new JTable();
        this.JBGrabar = new JButton();
        this.jLabel1 = new JLabel();
        this.JBSalir = new JButton();
        setDefaultCloseOperation(2);
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.DetalleItemsOrden.2
            public void mouseClicked(MouseEvent evt) {
                DetalleItemsOrden.this.JTableMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTable);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("VALIDAR");
        this.JBGrabar.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.DetalleItemsOrden.3
            public void mouseClicked(MouseEvent evt) {
                DetalleItemsOrden.this.JBGrabarMouseClicked(evt);
            }
        });
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.DetalleItemsOrden.4
            public void actionPerformed(ActionEvent evt) {
                DetalleItemsOrden.this.JBGrabarActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Segoe UI", 1, 16));
        this.jLabel1.setForeground(new Color(0, 102, 255));
        this.jLabel1.setText("VISTA PREVIA");
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Cancelar");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.DetalleItemsOrden.5
            public void actionPerformed(ActionEvent evt) {
                DetalleItemsOrden.this.JBSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addGroup(layout.createSequentialGroup().addComponent(this.JBGrabar, -2, 496, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBSalir, -2, 494, -2))).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 256, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGrabar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
    }

    private void actualizarPrecios() {
        int tipoServicio = 0;
        new ArrayList(this.JTable.getRowCount());
        double SUBTOTAL = 0.0d;
        List<Object[]> e = new ArrayList<>();
        for (int i = 0; i < this.JTable.getRowCount(); i++) {
            Object[] fila = {this.xmodelo.getValueAt(i, 0), this.xmodelo.getValueAt(i, 1), this.xmodelo.getValueAt(i, 2), this.xmodelo.getValueAt(i, 3), this.xmodelo.getValueAt(i, 4), this.xmodelo.getValueAt(i, 5), this.xmodelo.getValueAt(i, 6), this.xmodelo.getValueAt(i, 7), this.xmodelo.getValueAt(i, 8)};
            tipoServicio = Integer.valueOf(this.xmodelo.getValueAt(0, 4).toString()).intValue();
            SUBTOTAL += Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue();
            e.add(fila);
        }
        if (tipoServicio == 1) {
            JIF_AgendaSimedisBienestar.listaDetalleProcedimientoValidadoConsulta = e;
            JIF_AgendaSimedisBienestar.totalConsultas = SUBTOTAL;
        } else if (tipoServicio == 2) {
            JIF_AgendaSimedisBienestar.listaDetalleProcedimientoValidadoLaboratorio = e;
            JIF_AgendaSimedisBienestar.totalLaboratorio = SUBTOTAL;
        }
        System.out.println("test");
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTable.isEditing()) {
                this.JTable.getCellEditor().stopCellEditing();
            }
            actualizarPrecios();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        JIF_AgendaSimedisBienestar.cancelarOperacion = true;
        dispose();
    }
}
