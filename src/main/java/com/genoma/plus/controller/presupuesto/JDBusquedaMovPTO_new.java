package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import Contabilidad.JIFSolicitudReembolsoCMV2;
import Presupuesto.JIFFMovManualOP_PP;
import Utilidades.Metodos;
import com.genoma.plus.jpa.dto.ListMovimientosPPTDto;
import com.genoma.plus.jpa.entities.PpDetalleMovimiento;
import com.genoma.plus.jpa.projection.IPpMovimientoProjection;
import com.genoma.plus.jpa.service.IPpMovimientoDetalleService;
import com.genoma.plus.jpa.service.IPpMovimientoService;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JDBusquedaMovPTO_new.class */
public class JDBusquedaMovPTO_new extends JDialog {
    private DefaultTableModel modelo;
    private Metodos metodo = new Metodos();
    private Object[] datos;
    private JIFFMovimiento_new movimiento_new;
    private String objetoLlamador;
    private final IPpMovimientoService iPpMovimientoService;
    private Integer idClaseDocumento;
    private String nombre;
    private ListMovimientosPPTDto movimientos;
    private JIFFMovManualOP_PP xJIFFMovManualOP_PP;
    private JIFSolicitudReembolsoCMV2 jIFSolicitudReembolsoCMV2;
    private final IPpMovimientoDetalleService iPpMovimientoDetalleService;
    private List<PpDetalleMovimiento> listdetalleMovimiento;
    private JButton JBConsultar;
    private ButtonGroup JBGEstado;
    private ButtonGroup JBGFiltro;
    private JButton JBTBuscar;
    private JButton JBT_Salir;
    private JRadioButton JRBActivos;
    private JRadioButton JRBAnulados;
    private JTextField JTConsecutivo;
    private JTable JTDetalle;
    private JRadioButton filtro;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JRadioButton todos;

    public JDBusquedaMovPTO_new(Frame parent, boolean modal, Integer idClaseDocumento, Object llamador, String nombre) {
        initComponents();
        this.nombre = nombre;
        this.idClaseDocumento = idClaseDocumento;
        this.iPpMovimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
        this.iPpMovimientoDetalleService = (IPpMovimientoDetalleService) Principal.contexto.getBean(IPpMovimientoDetalleService.class);
        this.listdetalleMovimiento = new ArrayList();
        setTitle("BÚSQUEDA DE MOVIMIENTOS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        casting(llamador);
        buscarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGEstado = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTConsecutivo = new JTextField();
        this.JBConsultar = new JButton();
        this.filtro = new JRadioButton();
        this.todos = new JRadioButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JRBAnulados = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JBTBuscar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "FILTROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JTConsecutivo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "No. Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBConsultar.setFont(new Font("Arial", 1, 12));
        this.JBConsultar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBConsultar.setText("Consultar");
        this.JBConsultar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JDBusquedaMovPTO_new.1
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO_new.this.JBConsultarActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.filtro);
        this.filtro.setFont(new Font("Arial", 1, 12));
        this.filtro.setText("Filtro");
        this.JBGFiltro.add(this.todos);
        this.todos.setFont(new Font("Arial", 1, 12));
        this.todos.setText("Todos");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JTConsecutivo, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBConsultar).addGap(337, 337, 337).addComponent(this.filtro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.todos).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBConsultar, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.filtro).addComponent(this.todos))).addComponent(this.JTConsecutivo, -1, 39, 32767)).addGap(23, 23, 23)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDBusquedaMovPTO_new.2
            public void mouseClicked(MouseEvent evt) {
                JDBusquedaMovPTO_new.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.JBGEstado.add(this.JRBAnulados);
        this.JRBAnulados.setFont(new Font("Arial", 1, 12));
        this.JRBAnulados.setText("Anulados");
        this.JRBAnulados.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JDBusquedaMovPTO_new.3
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO_new.this.JRBAnuladosActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setSelected(true);
        this.JRBActivos.setText("Activos");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JDBusquedaMovPTO_new.4
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO_new.this.JRBActivosActionPerformed(evt);
            }
        });
        this.JBTBuscar.setFont(new Font("Arial", 1, 12));
        this.JBTBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTBuscar.setText("Cargar");
        this.JBTBuscar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JDBusquedaMovPTO_new.5
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO_new.this.JBTBuscarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JDBusquedaMovPTO_new.6
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaMovPTO_new.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -2, 775, -2)).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.JBTBuscar, -2, 270, -2).addGap(32, 32, 32).addComponent(this.JBT_Salir, -2, 270, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBActivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAnulados).addGap(10, 10, 10)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 315, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTBuscar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JRBActivos).addComponent(this.JRBAnulados)).addContainerGap(11, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBConsultarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        buscarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnuladosActionPerformed(ActionEvent evt) {
        buscarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBuscarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0 && this.JTDetalle.getSelectedRow() > -1 && this.nombre.equals("xjifMovimientoPPTO_N")) {
            Principal.txtNo.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            System.out.println("idClaseDocumento -> " + this.idClaseDocumento);
            String idClaseD = this.idClaseDocumento.toString();
            if (idClaseD.equals("9")) {
                System.out.println("this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString" + this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
                this.movimiento_new.JLB_Registro.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
                this.movimiento_new.xMovimiento = this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString();
                this.movimiento_new.mBuscaMovimiento(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString(), this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            } else if (idClaseD.equals("4")) {
                this.movimiento_new.JLB_Registro.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
                this.movimiento_new.xMovimiento = this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString();
                this.movimiento_new.mBuscaMovimiento(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString(), this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            }
            dispose();
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void casting(Object objetoLlamador) {
        switch (objetoLlamador.getClass().getSimpleName()) {
            case "JIFFMovimiento_new":
                this.objetoLlamador = "JIFFMovimiento_new";
                this.movimiento_new = (JIFFMovimiento_new) objetoLlamador;
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Cod.", "Fecha", "Documento", "Observación", "Valor", "Estado", "Id", "IdDisponibilidad", "Seleccionar"}) { // from class: com.genoma.plus.controller.presupuesto.JDBusquedaMovPTO_new.7
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, Boolean.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    private void buscarDatos() {
        crearModelo();
        this.movimientos = this.iPpMovimientoService.buscarTodosMovimentos(this.idClaseDocumento, Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()));
        this.movimientos.getMovimientoPPTDtos().forEach(e -> {
            Boolean estado = true;
            if (e.getMovimiento().getIdMotivoAnulacion().getId().intValue() != 1) {
                estado = false;
            }
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(Integer.valueOf(e.getMovimiento().getNoConcecutivo()), this.JTDetalle.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getMovimiento().getFechaD(), this.JTDetalle.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getMovimiento().getNoDocumento(), this.JTDetalle.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getMovimiento().getObservacion(), this.JTDetalle.getRowCount() - 1, 3);
            this.modelo.setValueAt(estado, this.JTDetalle.getRowCount() - 1, 5);
            this.modelo.setValueAt(e.getMovimiento().getId(), this.JTDetalle.getRowCount() - 1, 6);
            this.modelo.setValueAt(e.getMovimiento().getIdDisponibilidad(), this.JTDetalle.getRowCount() - 1, 7);
            this.modelo.setValueAt(false, this.JTDetalle.getRowCount() - 1, 8);
        });
        List<IPpMovimientoProjection> detalleProjection = this.iPpMovimientoService.getListMovimientoDisponibilidadSuma(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro());
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            int sumaValores = 0;
            String idMovimiento = this.JTDetalle.getValueAt(i, 6).toString();
            for (IPpMovimientoProjection detalle : detalleProjection) {
                if (idMovimiento.equals(detalle.getIdMovimiento())) {
                    sumaValores = (int) (((double) sumaValores) + detalle.getValorDetalle().doubleValue());
                }
            }
            this.modelo.setValueAt(Integer.valueOf(sumaValores), i, 4);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JDBusquedaMovPTO_new$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Double.valueOf(table.getValueAt(row, 10).toString()).doubleValue() <= 0.0d) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
