package com.genoma.plus.controller.inventario;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import com.genoma.plus.jpa.entities.BodegaDTO;
import com.genoma.plus.jpa.entities.SolicitudPedidoInternoEntity;
import com.genoma.plus.jpa.service.ISolicitudPedidoInternoService;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JDBusquedaSolicitudesInternas.class */
public class JDBusquedaSolicitudesInternas extends JDialog {
    private DefaultTableModel modelo;
    private Object[] datos;
    private final ISolicitudPedidoInternoService pedidoInternoService;
    private List<SolicitudPedidoInternoEntity> pedidoInternoEntitys;
    private String formularioLlamador;
    private ButtonGroup JBG_Filtro;
    private JButton JBT_Cargar;
    private JButton JBT_Imprimir;
    private JButton JBT_Salir;
    private JPanel JPI_Filtro;
    private JRadioButton JRB_Autorizada;
    private JRadioButton JRB_AutorizadaDespachadas;
    private JRadioButton JRB_PorAutorizar;
    private JRadioButton JRB_Todas;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JDBusquedaSolicitudesInternas(Frame parent, boolean modal, String formularioLlamador) {
        super(parent, modal);
        this.pedidoInternoService = (ISolicitudPedidoInternoService) Principal.contexto.getBean(ISolicitudPedidoInternoService.class);
        initComponents();
        this.formularioLlamador = formularioLlamador;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        if (this.formularioLlamador.equals("jifSolicitudPedidoInterno")) {
            this.JRB_Todas.setSelected(true);
        } else {
            this.JRB_Autorizada.setSelected(true);
        }
        System.err.println("formularioLlamador" + formularioLlamador);
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Filtro = new JPanel();
        this.JRB_Todas = new JRadioButton();
        this.JRB_PorAutorizar = new JRadioButton();
        this.JRB_Autorizada = new JRadioButton();
        this.JRB_AutorizadaDespachadas = new JRadioButton();
        this.JBT_Cargar = new JButton();
        this.JBT_Imprimir = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("BÚSQUEDA DE SOLICITUDES INTERNAS");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas.1
            public void mouseClicked(MouseEvent evt) {
                JDBusquedaSolicitudesInternas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPI_Filtro.setFont(new Font("Arial", 1, 14));
        this.JRB_Todas.setBackground(new Color(255, 255, 255));
        this.JBG_Filtro.add(this.JRB_Todas);
        this.JRB_Todas.setFont(new Font("Arial", 1, 12));
        this.JRB_Todas.setSelected(true);
        this.JRB_Todas.setText("Todas");
        this.JRB_Todas.setOpaque(true);
        this.JRB_Todas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas.2
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaSolicitudesInternas.this.JRB_TodasActionPerformed(evt);
            }
        });
        this.JRB_PorAutorizar.setBackground(Color.red);
        this.JBG_Filtro.add(this.JRB_PorAutorizar);
        this.JRB_PorAutorizar.setFont(new Font("Arial", 1, 12));
        this.JRB_PorAutorizar.setForeground(new Color(255, 255, 255));
        this.JRB_PorAutorizar.setText("Por Autorizar");
        this.JRB_PorAutorizar.setOpaque(true);
        this.JRB_PorAutorizar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas.3
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaSolicitudesInternas.this.JRB_PorAutorizarActionPerformed(evt);
            }
        });
        this.JRB_Autorizada.setBackground(Color.green);
        this.JBG_Filtro.add(this.JRB_Autorizada);
        this.JRB_Autorizada.setFont(new Font("Arial", 1, 12));
        this.JRB_Autorizada.setText("Autorizadas por Despacho");
        this.JRB_Autorizada.setOpaque(true);
        this.JRB_Autorizada.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas.4
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaSolicitudesInternas.this.JRB_AutorizadaActionPerformed(evt);
            }
        });
        this.JRB_AutorizadaDespachadas.setBackground(Color.pink);
        this.JBG_Filtro.add(this.JRB_AutorizadaDespachadas);
        this.JRB_AutorizadaDespachadas.setFont(new Font("Arial", 1, 12));
        this.JRB_AutorizadaDespachadas.setText("Autorizadas Despachadas");
        this.JRB_AutorizadaDespachadas.setOpaque(true);
        this.JRB_AutorizadaDespachadas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas.5
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaSolicitudesInternas.this.JRB_AutorizadaDespachadasActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todas).addGap(18, 18, 18).addComponent(this.JRB_PorAutorizar).addGap(18, 18, 18).addComponent(this.JRB_Autorizada).addGap(18, 18, 18).addComponent(this.JRB_AutorizadaDespachadas).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todas).addComponent(this.JRB_PorAutorizar).addComponent(this.JRB_Autorizada).addComponent(this.JRB_AutorizadaDespachadas, -2, 22, -2)).addContainerGap(15, 32767)));
        this.JBT_Cargar.setFont(new Font("Arial", 1, 12));
        this.JBT_Cargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Cargar.setText("Cargar");
        this.JBT_Cargar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas.6
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaSolicitudesInternas.this.JBT_CargarActionPerformed(evt);
            }
        });
        this.JBT_Imprimir.setFont(new Font("Arial", 1, 12));
        this.JBT_Imprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBT_Imprimir.setText("Imprimir");
        this.JBT_Imprimir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas.7
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaSolicitudesInternas.this.JBT_ImprimirActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas.8
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaSolicitudesInternas.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Cargar, -2, 157, -2).addGap(109, 109, 109).addComponent(this.JBT_Imprimir, -2, 157, -2).addGap(112, 112, 112).addComponent(this.JBT_Salir, -2, 157, -2)).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 255, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Imprimir, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JBT_Cargar, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getSelectedRow() != -1) {
            cargarSolicitud();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodasActionPerformed(ActionEvent evt) {
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_PorAutorizarActionPerformed(ActionEvent evt) {
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AutorizadaActionPerformed(ActionEvent evt) {
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_ImprimirActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.impresionSolicitudesInternas(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            cargarSolicitud();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AutorizadaDespachadasActionPerformed(ActionEvent evt) {
        cargarDatos();
    }

    private void cargarSolicitud() {
        if (this.formularioLlamador.equals("jifSolicitudPedidoInterno")) {
            Principal.clasegeneral.solicitudPedidoInterno.cargarPedidoPorId(Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            dispose();
            return;
        }
        if (Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).longValue() == 0) {
            if (Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900520293")) {
                Principal.xClaseInventario.frmSalida.buscarOrden(this.pedidoInternoEntitys.get(this.JTDetalle.getSelectedRow()));
                dispose();
                return;
            }
            Boolean.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue();
            if (Boolean.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue()) {
                Principal.xClaseInventario.frmSalida.buscarOrden(this.pedidoInternoEntitys.get(this.JTDetalle.getSelectedRow()));
                dispose();
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Solicitud pendiente por autorizar", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Solicitud ya despachada", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void cargarDatos() {
        crearModeloDetalleSolicitud();
        this.pedidoInternoEntitys = new ArrayList();
        if (this.JRB_Todas.isSelected()) {
            if (this.formularioLlamador.equals("jifSolicitudPedidoInterno")) {
                this.pedidoInternoEntitys = this.pedidoInternoService.listarTodasSolicitudesPedido();
            } else {
                BodegaDTO bodegaDTO = new BodegaDTO();
                bodegaDTO.setId(Long.valueOf(Principal.xClaseInventario.getIdBodega()));
                this.pedidoInternoEntitys = this.pedidoInternoService.listarTodasSolicitudesPedidoPorIdBodega(bodegaDTO);
            }
        } else if (this.JRB_PorAutorizar.isSelected()) {
            if (this.formularioLlamador.equals("jifSolicitudPedidoInterno")) {
                this.pedidoInternoEntitys = this.pedidoInternoService.listarSolicitudesPedidoPorAutorizar();
            } else {
                BodegaDTO bodegaDTO2 = new BodegaDTO();
                bodegaDTO2.setId(Long.valueOf(Principal.xClaseInventario.getIdBodega()));
                this.pedidoInternoEntitys = this.pedidoInternoService.listarSolicitudesPedidoPorAutorizarsPorIdBodega(bodegaDTO2);
            }
        } else if (this.JRB_Autorizada.isSelected()) {
            if (this.formularioLlamador.equals("jifSolicitudPedidoInterno")) {
                this.pedidoInternoEntitys = this.pedidoInternoService.listarSolicitudesPedidoAutorizadas();
            } else {
                BodegaDTO bodegaDTO3 = new BodegaDTO();
                bodegaDTO3.setId(Long.valueOf(Principal.xClaseInventario.getIdBodega()));
                this.pedidoInternoEntitys = this.pedidoInternoService.listarSolicitudesPedidoAutorizadasPorIdBodega(bodegaDTO3);
            }
        } else if (this.JRB_AutorizadaDespachadas.isSelected()) {
            if (this.formularioLlamador.equals("jifSolicitudPedidoInterno")) {
                this.pedidoInternoEntitys = this.pedidoInternoService.listarSolicitudesPedidoAutorizadasDespachadas();
            } else {
                BodegaDTO bodegaDTO4 = new BodegaDTO();
                bodegaDTO4.setId(Long.valueOf(Principal.xClaseInventario.getIdBodega()));
                this.pedidoInternoEntitys = this.pedidoInternoService.listarSolicitudesPedidoAutorizadasPorIdBodegaDespachada(bodegaDTO4);
            }
        }
        this.pedidoInternoEntitys.forEach(detalle -> {
            this.modelo.addRow(this.datos);
            this.JTDetalle.setValueAt(detalle.getId(), this.JTDetalle.getRowCount() - 1, 0);
            this.JTDetalle.setValueAt(detalle.getFechaSolicitud(), this.JTDetalle.getRowCount() - 1, 1);
            this.JTDetalle.setValueAt(detalle.getIdBodega().getNombre(), this.JTDetalle.getRowCount() - 1, 2);
            this.JTDetalle.setValueAt(detalle.getIdUnidadFuncional().getNbre(), this.JTDetalle.getRowCount() - 1, 3);
            this.JTDetalle.setValueAt(detalle.getIdPersonaRh().getIdPersona().getApellido1() + " " + detalle.getIdPersonaRh().getIdPersona().getApellido2() + " " + detalle.getIdPersonaRh().getIdPersona().getNombre1() + " " + detalle.getIdPersonaRh().getIdPersona().getNombre2(), this.JTDetalle.getRowCount() - 1, 4);
            this.JTDetalle.setValueAt(detalle.getObservacion(), this.JTDetalle.getRowCount() - 1, 5);
            this.JTDetalle.setValueAt(detalle.getEstado(), this.JTDetalle.getRowCount() - 1, 7);
            this.JTDetalle.setValueAt(detalle.getIdSalida(), this.JTDetalle.getRowCount() - 1, 8);
            this.JTDetalle.setValueAt(false, this.JTDetalle.getRowCount() - 1, 6);
            if (!detalle.getISolicitudPedidoInternoAutorizacionCollection().isEmpty()) {
                detalle.getISolicitudPedidoInternoAutorizacionCollection().forEach(autoriza -> {
                    if (autoriza.getFechaAutorizacion() != null) {
                        this.JTDetalle.setValueAt(true, this.JTDetalle.getRowCount() - 1, 6);
                    } else {
                        this.JTDetalle.setValueAt(false, this.JTDetalle.getRowCount() - 1, 6);
                    }
                });
            }
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
        });
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JDBusquedaSolicitudesInternas$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean nvalidacion = Boolean.valueOf(table.getValueAt(row, 6).toString());
            if (!nvalidacion.booleanValue()) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            } else if (Long.valueOf(table.getValueAt(row, 8).toString()).longValue() != 0) {
                cell.setBackground(Color.PINK);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDetalleSolicitud() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Bodega", "Unidad Funcional", "Usuario que solicita", "Observación", "Autorizada", "Estado", "IdSalida"}) { // from class: com.genoma.plus.controller.inventario.JDBusquedaSolicitudesInternas.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Long.class};
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
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }
}
