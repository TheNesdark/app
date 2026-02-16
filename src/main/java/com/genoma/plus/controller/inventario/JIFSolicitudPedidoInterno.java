package com.genoma.plus.controller.inventario;

import Acceso.Principal;
import General.Anular;
import General.ClaseImpresionInformes;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.BodegaDTO;
import com.genoma.plus.jpa.entities.EmpleadosNomina;
import com.genoma.plus.jpa.entities.ISuministro;
import com.genoma.plus.jpa.entities.SolicitudPedidoInternoAutorizacionEntity;
import com.genoma.plus.jpa.entities.SolicitudPedidoInternoDetalleEntity;
import com.genoma.plus.jpa.entities.SolicitudPedidoInternoEntity;
import com.genoma.plus.jpa.entities.TipoDocumentoClasificacion;
import com.genoma.plus.jpa.entities.TipoDocumentoContable;
import com.genoma.plus.jpa.entities.UnidadFuncionalEntity;
import com.genoma.plus.jpa.projection.GenericCombo;
import com.genoma.plus.jpa.projection.ISuministroBodegaInventario;
import com.genoma.plus.jpa.service.IBodegaDAO;
import com.genoma.plus.jpa.service.ISolicitudPedidoInternoService;
import com.genoma.plus.jpa.service.ITipoDocumentoContableService;
import com.genoma.plus.jpa.service.IUsuarioPorDocumentoFirmaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIFSolicitudPedidoInterno.class */
public class JIFSolicitudPedidoInterno extends JInternalFrame {
    private DefaultTableModel modelo;
    private Object[] datos;
    private List<SolicitudPedidoInternoDetalleEntity> pedidoInternoDetalleEntitys;
    private SolicitudPedidoInternoEntity pedidoInternoEntity;
    private List<SolicitudPedidoInternoAutorizacionEntity> pedidoInternoAutorizacionEntity;
    private List<BodegaDTO> bodegaDTOs;
    private List<TipoDocumentoContable> tipoDocumentoContables;
    private final EmpleadosNomina empleadosNomina;
    private final UnidadFuncionalEntity unidadFuncionalEntity;
    private List<ISuministroBodegaInventario> suministroBodegaInventarios;
    private JButton JBAdicionar;
    private JComboBox JCBBodega;
    private JComboBox JCBItems;
    private JComboBox JCBTipoDocumento;
    private JDateChooser JDFechaC;
    private JLabel JLB_Registro;
    private JPanel JPI_Datos;
    private JPanel JPI_DatosItems;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPObservacionItems;
    private JSpinner JSP_Cantidad;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionItems;
    private JTable JTDetalle;
    private JTextField JTF_CodigoBarra;
    public JFormattedTextField JTF_Existencia;
    private final Metodos metodos = new Metodos();
    private final IBodegaDAO bodegaDAO = (IBodegaDAO) Principal.contexto.getBean(IBodegaDAO.class);
    private final ISolicitudPedidoInternoService pedidoInternoService = (ISolicitudPedidoInternoService) Principal.contexto.getBean(ISolicitudPedidoInternoService.class);
    private final ITipoDocumentoContableService documentoContableService = (ITipoDocumentoContableService) Principal.contexto.getBean(ITipoDocumentoContableService.class);
    private final IUsuarioPorDocumentoFirmaService usuarioPorDocumentoFirmaService = (IUsuarioPorDocumentoFirmaService) Principal.contexto.getBean(IUsuarioPorDocumentoFirmaService.class);
    private Boolean llenoCombo = false;

    public JIFSolicitudPedidoInterno() {
        initComponents();
        nuevo();
        this.empleadosNomina = new EmpleadosNomina();
        this.unidadFuncionalEntity = new UnidadFuncionalEntity();
        this.empleadosNomina.setId(Principal.usuarioSistemaDTO.getIdPersonaCargo());
        this.unidadFuncionalEntity.setId(Principal.usuarioSistemaDTO.getIdUnidadFuncional());
    }

    /* JADX WARN: Type inference failed for: r3v80, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Datos = new JPanel();
        this.JDFechaC = new JDateChooser();
        this.JCBTipoDocumento = new JComboBox();
        this.JCBBodega = new JComboBox();
        this.JLB_Registro = new JLabel();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JPI_DatosItems = new JPanel();
        this.JTF_CodigoBarra = new JTextField();
        this.JCBItems = new JComboBox();
        this.JSP_Cantidad = new JSpinner();
        this.JSPObservacionItems = new JScrollPane();
        this.JTAObservacionItems = new JTextArea();
        this.JBAdicionar = new JButton();
        this.JTF_Existencia = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SOLICITUD DE PEDIDO INTERNO");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifSolicitudPedidoInterno");
        this.JPI_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPI_Datos.setFont(new Font("Arial", 1, 14));
        this.JDFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.inventario.JIFSolicitudPedidoInterno.1
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudPedidoInterno.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBodega.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.inventario.JIFSolicitudPedidoInterno.2
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudPedidoInterno.this.JCBBodegaItemStateChanged(evt);
            }
        });
        this.JLB_Registro.setFont(new Font("Arial", 1, 14));
        this.JLB_Registro.setForeground(Color.red);
        this.JLB_Registro.setHorizontalAlignment(0);
        this.JLB_Registro.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JDFechaC, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, -2, 297, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBBodega, -2, 297, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_Registro, -2, 123, -2).addGap(19, 19, 19)).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JSPObservacion).addContainerGap()))));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGap(13, 13, 13).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBBodega, -2, 50, -2).addComponent(this.JCBTipoDocumento, -2, 50, -2)).addComponent(this.JDFechaC, -1, -1, 32767).addComponent(this.JLB_Registro, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, -1, -2).addContainerGap(14, 32767)));
        this.JPI_DatosItems.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN ITEM", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTF_CodigoBarra.setFont(new Font("Arial", 1, 12));
        this.JTF_CodigoBarra.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Barra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_CodigoBarra.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.inventario.JIFSolicitudPedidoInterno.3
            public void focusLost(FocusEvent evt) {
                JIFSolicitudPedidoInterno.this.JTF_CodigoBarraFocusLost(evt);
            }
        });
        this.JTF_CodigoBarra.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFSolicitudPedidoInterno.4
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudPedidoInterno.this.JTF_CodigoBarraActionPerformed(evt);
            }
        });
        this.JCBItems.setFont(new Font("Arial", 1, 12));
        this.JCBItems.setBorder(BorderFactory.createTitledBorder((Border) null, "Items", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBItems.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.inventario.JIFSolicitudPedidoInterno.5
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudPedidoInterno.this.JCBItemsItemStateChanged(evt);
            }
        });
        this.JSP_Cantidad.setFont(new Font("Arial", 1, 12));
        this.JSP_Cantidad.setModel(new SpinnerNumberModel(Double.valueOf(1.0d), (Comparable) null, (Comparable) null, Double.valueOf(1.0d)));
        this.JSP_Cantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacionItems.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionItems.setColumns(20);
        this.JTAObservacionItems.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionItems.setRows(5);
        this.JSPObservacionItems.setViewportView(this.JTAObservacionItems);
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFSolicitudPedidoInterno.6
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudPedidoInterno.this.JBAdicionarActionPerformed(evt);
            }
        });
        this.JTF_Existencia.setEditable(false);
        this.JTF_Existencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Existencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Existencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTF_Existencia.setHorizontalAlignment(4);
        this.JTF_Existencia.setDisabledTextColor(new Color(0, 0, 0));
        this.JTF_Existencia.setEnabled(false);
        this.JTF_Existencia.setFocusable(false);
        this.JTF_Existencia.setFont(new Font("Arial", 1, 12));
        this.JTF_Existencia.setValue(new Integer(0));
        GroupLayout JPI_DatosItemsLayout = new GroupLayout(this.JPI_DatosItems);
        this.JPI_DatosItems.setLayout(JPI_DatosItemsLayout);
        JPI_DatosItemsLayout.setHorizontalGroup(JPI_DatosItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosItemsLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosItemsLayout.createSequentialGroup().addComponent(this.JTF_CodigoBarra, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBItems, -2, 513, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_Existencia, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSP_Cantidad, -2, 104, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosItemsLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JBAdicionar, -2, 155, -2))).addContainerGap()).addGroup(JPI_DatosItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosItemsLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacionItems, -2, 726, -2).addContainerGap(181, 32767))));
        JPI_DatosItemsLayout.setVerticalGroup(JPI_DatosItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosItemsLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosItemsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_CodigoBarra, -2, 50, -2).addComponent(this.JCBItems, -2, 50, -2).addComponent(this.JSP_Cantidad, -2, 50, -2).addComponent(this.JTF_Existencia, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionar, -1, 56, 32767).addContainerGap()).addGroup(JPI_DatosItemsLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosItemsLayout.createSequentialGroup().addGap(63, 63, 63).addComponent(this.JSPObservacionItems, -1, 56, 32767).addContainerGap())));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.inventario.JIFSolicitudPedidoInterno.7
            public void keyPressed(KeyEvent evt) {
                JIFSolicitudPedidoInterno.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JPI_DatosItems, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JPI_Datos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Datos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPI_DatosItems, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 215, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBodegaItemStateChanged(ItemEvent evt) {
        if (this.llenoCombo.booleanValue() && this.JCBBodega.getSelectedIndex() != -1) {
            this.JCBItems.removeAllItems();
            this.suministroBodegaInventarios = new ArrayList();
            this.suministroBodegaInventarios = this.bodegaDAO.listSuministroBodegaExistencia(this.metodos.formatoAMD1.format(this.JDFechaC.getDate()), this.bodegaDTOs.get(this.JCBBodega.getSelectedIndex()).getId());
            if (!this.suministroBodegaInventarios.isEmpty()) {
                this.suministroBodegaInventarios.forEach(item -> {
                    this.JCBItems.addItem(item.getNombreItem());
                });
            }
            this.JCBItems.setSelectedIndex(-1);
            this.JTF_CodigoBarra.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBItemsItemStateChanged(ItemEvent evt) {
        if (this.llenoCombo.booleanValue() && this.JCBItems.getSelectedIndex() != -1) {
            this.JTF_CodigoBarra.setText(this.suministroBodegaInventarios.get(this.JCBItems.getSelectedIndex()).getCodigoBarra());
            this.JTF_Existencia.setText("" + this.suministroBodegaInventarios.get(this.JCBItems.getSelectedIndex()).getExistencia());
            this.JSP_Cantidad.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoBarraActionPerformed(ActionEvent evt) {
        this.JTF_CodigoBarra.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_CodigoBarraFocusLost(FocusEvent evt) {
        buscarPorCodigoBarra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBItems.getSelectedIndex() != -1) {
            if (!this.JSP_Cantidad.getValue().equals("0")) {
                SolicitudPedidoInternoDetalleEntity e = new SolicitudPedidoInternoDetalleEntity();
                ISuministro suministro = new ISuministro();
                suministro.setId(this.suministroBodegaInventarios.get(this.JCBItems.getSelectedIndex()).getIdSuministro());
                e.setSuministros(suministro);
                e.setCantidad(Double.valueOf(this.JSP_Cantidad.getValue().toString()));
                e.setObservacion(this.JTAObservacionItems.getText());
                this.pedidoInternoDetalleEntitys.add(e);
                this.modelo.addRow(this.datos);
                this.JTDetalle.setValueAt(this.suministroBodegaInventarios.get(this.JCBItems.getSelectedIndex()).getIdSuministro(), this.JTDetalle.getRowCount() - 1, 0);
                this.JTDetalle.setValueAt(this.JCBItems.getSelectedItem(), this.JTDetalle.getRowCount() - 1, 1);
                this.JTDetalle.setValueAt(e.getCantidad(), this.JTDetalle.getRowCount() - 1, 2);
                this.JTDetalle.setValueAt(e.getObservacion(), this.JTDetalle.getRowCount() - 1, 3);
                this.JTDetalle.setValueAt(0, this.JTDetalle.getRowCount() - 1, 4);
                nuevoItem();
                return;
            }
            JOptionPane.showMessageDialog(this, "Cantidad no puede ser cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JSP_Cantidad.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un items", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBItems.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1 && Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).longValue() == 0) {
            this.pedidoInternoDetalleEntitys.remove(this.JTDetalle.getSelectedRow());
            this.modelo.removeRow(this.JTDetalle.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
    }

    private void buscarPorCodigoBarra() {
        ISuministroBodegaInventario e;
        if (!this.JTF_CodigoBarra.getText().isEmpty() && (e = this.bodegaDAO.suministroBodegaExistenciaPorCodigoBarra(this.metodos.formatoAMD1.format(this.JDFechaC.getDate()), this.bodegaDTOs.get(this.JCBBodega.getSelectedIndex()).getId(), this.JTF_CodigoBarra.getText())) != null) {
            this.JCBItems.setSelectedItem(e.getNombreItem());
            this.JSP_Cantidad.requestFocus();
        }
    }

    public void cargarPedidoPorId(Long idSolicitud) {
        Optional<SolicitudPedidoInternoEntity> e = this.pedidoInternoService.buscarPorIdPedido(idSolicitud);
        this.pedidoInternoEntity = e.get();
        if (e != null) {
            this.JLB_Registro.setText("" + e.get().getId());
            this.JDFechaC.setDate(e.get().getFecha());
            this.JCBBodega.setSelectedItem(e.get().getIdBodega().getNombre());
            this.JCBTipoDocumento.setSelectedItem(e.get().getIdTipoDocumento().getNbre());
            this.JTAObservacion.setText(e.get().getObservacion());
            crearModeloDetalleSolicitud();
            e.get().getISolicitudPedidoInternoDetalleCollection().forEach(detalle -> {
                this.modelo.addRow(this.datos);
                this.JTDetalle.setValueAt(detalle.getSuministros().getId(), this.JTDetalle.getRowCount() - 1, 0);
                this.JTDetalle.setValueAt(detalle.getSuministros().getNbre(), this.JTDetalle.getRowCount() - 1, 1);
                this.JTDetalle.setValueAt(detalle.getCantidad(), this.JTDetalle.getRowCount() - 1, 2);
                this.JTDetalle.setValueAt(detalle.getObservacion(), this.JTDetalle.getRowCount() - 1, 3);
                this.JTDetalle.setValueAt(detalle.getId(), this.JTDetalle.getRowCount() - 1, 4);
            });
        }
    }

    private void nuevoItem() {
        this.JLB_Registro.setText("");
        this.JTAObservacionItems.setText("");
        this.JTF_CodigoBarra.setText("");
        this.JTF_Existencia.setText("0");
        this.JSP_Cantidad.setValue(1);
        this.JCBItems.setSelectedIndex(-1);
        this.JTF_CodigoBarra.requestFocus();
    }

    public void nuevo() {
        this.JLB_Registro.setText("");
        this.JTF_Existencia.setText("0");
        this.llenoCombo = false;
        this.JCBItems.removeAllItems();
        this.JCBBodega.removeAllItems();
        this.JCBTipoDocumento.removeAllItems();
        this.JDFechaC.setDate(this.metodos.getFechaActual());
        this.JTAObservacion.setText("");
        this.JTAObservacionItems.setText("");
        this.JTF_CodigoBarra.setText("");
        this.JSP_Cantidad.setValue(1);
        this.pedidoInternoEntity = new SolicitudPedidoInternoEntity();
        this.pedidoInternoAutorizacionEntity = new ArrayList();
        this.pedidoInternoDetalleEntitys = new ArrayList();
        this.tipoDocumentoContables = new ArrayList();
        this.bodegaDTOs = new ArrayList();
        crearModeloDetalleSolicitud();
        this.bodegaDTOs = this.bodegaDAO.listaBodegasDespachosInternos(true);
        if (!this.bodegaDTOs.isEmpty()) {
            this.bodegaDTOs.forEach(bodega -> {
                this.JCBBodega.addItem(bodega.getNombre());
            });
        }
        this.JCBBodega.setSelectedIndex(-1);
        TipoDocumentoClasificacion e = new TipoDocumentoClasificacion();
        e.setId(10);
        this.tipoDocumentoContables = this.documentoContableService.listaTipoDocumentoContablePorIdClasificacion(e);
        if (!this.tipoDocumentoContables.isEmpty()) {
            this.tipoDocumentoContables.forEach(tipoDocumento -> {
                this.JCBTipoDocumento.addItem(tipoDocumento.getNbre());
            });
            if (this.tipoDocumentoContables.size() > 1) {
                this.JCBTipoDocumento.setSelectedIndex(-1);
            }
        }
        this.llenoCombo = true;
        this.JDFechaC.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDetalleSolicitud() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"idItems", "Nombre", "Cantidad", "Observación", "id"}) { // from class: com.genoma.plus.controller.inventario.JIFSolicitudPedidoInterno.8
            Class[] types = {Long.class, String.class, Double.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    public void grabar() {
        if (this.JCBTipoDocumento.getSelectedIndex() != -1) {
            if (this.pedidoInternoDetalleEntitys.size() > 0) {
                if (this.JLB_Registro.getText().isEmpty()) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.pedidoInternoEntity.setFechaSolicitud(this.JDFechaC.getDate());
                        this.pedidoInternoEntity.setEstado(true);
                        this.pedidoInternoEntity.setIdTipoDocumento(this.tipoDocumentoContables.get(this.JCBTipoDocumento.getSelectedIndex()));
                        this.pedidoInternoEntity.setIdBodega(this.bodegaDTOs.get(this.JCBBodega.getSelectedIndex()));
                        this.pedidoInternoEntity.setIdPersonaRh(this.empleadosNomina);
                        this.pedidoInternoEntity.setIdUnidadFuncional(this.unidadFuncionalEntity);
                        this.pedidoInternoEntity.setObservacion(this.JTAObservacion.getText());
                        this.pedidoInternoEntity.setIdSalida(new Long(0L));
                        this.pedidoInternoEntity.setFecha(this.metodos.getFechaActual());
                        this.pedidoInternoDetalleEntitys.forEach(detalle -> {
                            detalle.setIdSolicitud(this.pedidoInternoEntity);
                        });
                        this.pedidoInternoEntity.setISolicitudPedidoInternoDetalleCollection(this.pedidoInternoDetalleEntitys);
                        List<GenericCombo> listaPersonaAutoriza = this.usuarioPorDocumentoFirmaService.listaPorIdTipoDocumento(this.tipoDocumentoContables.get(this.JCBTipoDocumento.getSelectedIndex()).getIdClasificacion().getId());
                        listaPersonaAutoriza.forEach(dato -> {
                            SolicitudPedidoInternoAutorizacionEntity e = new SolicitudPedidoInternoAutorizacionEntity();
                            EmpleadosNomina empleadosNominaRh = new EmpleadosNomina();
                            empleadosNominaRh.setId(Long.valueOf(dato.getId().intValue()));
                            e.setEmpleadosNominaId(empleadosNominaRh);
                            e.setFecha(this.metodos.getFechaActual());
                            e.setEstado(true);
                            e.setIdSolicitudPedido(this.pedidoInternoEntity);
                            this.pedidoInternoAutorizacionEntity.add(e);
                        });
                        this.pedidoInternoEntity.setISolicitudPedidoInternoAutorizacionCollection(this.pedidoInternoAutorizacionEntity);
                        this.pedidoInternoEntity = this.pedidoInternoService.grabar(this.pedidoInternoEntity);
                        this.JLB_Registro.setText("" + this.pedidoInternoEntity.getId());
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "No existen items para grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_CodigoBarra.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoDocumento.requestFocus();
    }

    public void buscar() {
        JDBusquedaSolicitudesInternas internas = new JDBusquedaSolicitudesInternas(null, true, getName());
        internas.setLocationRelativeTo(this);
        internas.setVisible(true);
    }

    public void imprimir() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.impresionSolicitudesInternas(this.JLB_Registro.getText());
        }
    }

    public void anular() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            System.out.println("" + this.pedidoInternoEntity.getIdSalida());
            if (this.pedidoInternoEntity.getIdSalida() == null || this.pedidoInternoEntity.getIdSalida().longValue() == 0) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "jifSolicitudPedidoInterno", 3);
                    frm.setLocationRelativeTo(this);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Solicitud con orden de salida No. " + this.pedidoInternoEntity.getIdSalida(), "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una solicitud para anular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void anularBase(String movito, String observacion) {
        this.pedidoInternoEntity.setFechaAnulacion(this.metodos.getFechaActual());
        this.pedidoInternoEntity.setMotivoAnulacion(movito);
        this.pedidoInternoEntity.setObservacionAnulacion(observacion);
        this.pedidoInternoEntity.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.pedidoInternoEntity = this.pedidoInternoService.grabar(this.pedidoInternoEntity);
    }
}
