package ComprasBS;

import Acceso.Principal;
import Contabilidad.JIFRadicacion;
import Inventarios.Entradas;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IOdenesCompraContrato;
import com.genoma.plus.jpa.projection.iCcordenCompraResgitroFacturaProjection;
import com.genoma.plus.jpa.service.ICcordenCompraRegistroFacturaService;
import com.genoma.plus.jpa.service.ICordenCompraService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFConsultarEstadoOc.class */
public class JIFConsultarEstadoOc extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelode;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloDetalleEntrada;
    private String[] xidbodega;
    private Object[] xdatos;
    private Entradas xjifentrada;
    private JIFRadicacion xjifradicacion;
    private String xobjetollamador;
    private String xsql;
    private Object[] datos;
    private List<Integer> filtro;
    private List<iCcordenCompraResgitroFacturaProjection> detallesHistorico;
    private ButtonGroup JBGEstado;
    private ButtonGroup JBGTipo;
    private JComboBox JCBBodega;
    private JCheckBox JCHFiltro;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPIDatosc;
    private JPanel JPTipo;
    private JPanel JPTotales;
    private JRadioButton JRBContrato;
    private JRadioButton JRBOrdenC;
    private JRadioButton JRBOrdenT;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleEntrada;
    public JTable JTDetalle;
    public JTable JTDetalleEntrada;
    private JFormattedTextField JTFFSubtotal;
    private JFormattedTextField JTFFTotal;
    private JFormattedTextField JTFFVIva;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xtipo = 0;
    private int xTipoOrden = 1;
    private String xidproveedor = "0";
    private boolean xlleno = false;
    private final ICordenCompraService CordenCompra = (ICordenCompraService) Principal.contexto.getBean(ICordenCompraService.class);
    private final ICcordenCompraRegistroFacturaService registroFacturaService = (ICcordenCompraRegistroFacturaService) Principal.contexto.getBean(ICcordenCompraRegistroFacturaService.class);

    public JIFConsultarEstadoOc(String xname, JInternalFrame xjif) {
        initComponents();
        setName(xname);
        mRealizarCasting(xjif);
        mNuevo();
        cargarPedidoPorIdEmpresa(this.filtro, Long.valueOf(Long.parseLong(this.xidproveedor)));
    }

    /* JADX WARN: Type inference failed for: r3v58, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEstado = new ButtonGroup();
        this.JBGTipo = new ButtonGroup();
        this.JPIDatosc = new JPanel();
        this.JPTipo = new JPanel();
        this.JRBOrdenC = new JRadioButton();
        this.JRBOrdenT = new JRadioButton();
        this.JRBContrato = new JRadioButton();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCHFiltro = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalleEntrada = new JScrollPane();
        this.JTDetalleEntrada = new JTable();
        this.JPTotales = new JPanel();
        this.JTFFSubtotal = new JFormattedTextField();
        this.JTFFVIva = new JFormattedTextField();
        this.JTFFTotal = new JFormattedTextField();
        this.JCBBodega = new JComboBox();
        setClosable(true);
        setTitle("CONSULTAR ESTADO DE ORDENES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarordenesc");
        this.JPIDatosc.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Orden", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipo.add(this.JRBOrdenC);
        this.JRBOrdenC.setFont(new Font("Arial", 1, 11));
        this.JRBOrdenC.setSelected(true);
        this.JRBOrdenC.setText("Compra");
        this.JRBOrdenC.addActionListener(new ActionListener() { // from class: ComprasBS.JIFConsultarEstadoOc.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarEstadoOc.this.JRBOrdenCActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBOrdenT);
        this.JRBOrdenT.setFont(new Font("Arial", 1, 11));
        this.JRBOrdenT.setText("Servicio");
        this.JRBOrdenT.addActionListener(new ActionListener() { // from class: ComprasBS.JIFConsultarEstadoOc.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarEstadoOc.this.JRBOrdenTActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBContrato);
        this.JRBContrato.setFont(new Font("Arial", 1, 11));
        this.JRBContrato.setText("Contrato");
        this.JRBContrato.addActionListener(new ActionListener() { // from class: ComprasBS.JIFConsultarEstadoOc.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarEstadoOc.this.JRBContratoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBOrdenC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBOrdenT).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBContrato).addContainerGap(-1, 32767)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBOrdenT).addComponent(this.JRBOrdenC).addComponent(this.JRBContrato)).addContainerGap(-1, 32767)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFConsultarEstadoOc.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarEstadoOc.this.JDFFechaIPropertyChange(evt);
            }
        });
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFConsultarEstadoOc.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarEstadoOc.this.JDFFechaFPropertyChange(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Consultar todo?");
        GroupLayout JPIDatoscLayout = new GroupLayout(this.JPIDatosc);
        this.JPIDatosc.setLayout(JPIDatoscLayout);
        JPIDatoscLayout.setHorizontalGroup(JPIDatoscLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoscLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPTipo, -2, -1, -2).addGap(121, 121, 121).addComponent(this.JCHFiltro).addGap(51, 51, 51)));
        JPIDatoscLayout.setVerticalGroup(JPIDatoscLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatoscLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2)).addComponent(this.JPTipo, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatoscLayout.createSequentialGroup().addComponent(this.JCHFiltro).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFConsultarEstadoOc.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarEstadoOc.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JSPDetalleEntrada.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE ENTRADA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleEntrada.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalleEntrada.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEntrada.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleEntrada.setEditingColumn(2);
        this.JTDetalleEntrada.setEditingRow(1);
        this.JTDetalleEntrada.setRowHeight(25);
        this.JTDetalleEntrada.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleEntrada.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleEntrada.setSelectionMode(0);
        this.JTDetalleEntrada.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFConsultarEstadoOc.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarEstadoOc.this.JTDetalleEntradaMouseClicked(evt);
            }
        });
        this.JSPDetalleEntrada.setViewportView(this.JTDetalleEntrada);
        this.JPTotales.setBorder(BorderFactory.createTitledBorder((Border) null, "Consolidado Entradas", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFSubtotal.setEditable(false);
        this.JTFFSubtotal.setBackground(new Color(255, 255, 255));
        this.JTFFSubtotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Subtotal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSubtotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFSubtotal.setHorizontalAlignment(4);
        this.JTFFSubtotal.setFont(new Font("Arial", 1, 14));
        this.JTFFSubtotal.setValue(new Double(0.0d));
        this.JTFFVIva.setEditable(false);
        this.JTFFVIva.setBackground(new Color(255, 255, 255));
        this.JTFFVIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVIva.setHorizontalAlignment(4);
        this.JTFFVIva.setFont(new Font("Arial", 1, 14));
        this.JTFFVIva.setValue(new Double(0.0d));
        this.JTFFTotal.setEditable(false);
        this.JTFFTotal.setBackground(new Color(255, 255, 255));
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 14));
        this.JTFFTotal.setValue(new Double(0.0d));
        GroupLayout JPTotalesLayout = new GroupLayout(this.JPTotales);
        this.JPTotales.setLayout(JPTotalesLayout);
        JPTotalesLayout.setHorizontalGroup(JPTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTotalesLayout.createSequentialGroup().addComponent(this.JTFFSubtotal).addGap(18, 18, 18).addComponent(this.JTFFVIva).addGap(18, 18, 18).addComponent(this.JTFFTotal).addContainerGap()));
        JPTotalesLayout.setVerticalGroup(JPTotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTotalesLayout.createSequentialGroup().addGroup(JPTotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSubtotal, -2, -1, -2).addComponent(this.JTFFVIva, -2, -1, -2).addComponent(this.JTFFTotal, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleEntrada).addComponent(this.JPIDatosc, -1, -1, 32767).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JCBBodega, -2, 352, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTotales, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosc, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 208, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleEntrada, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTotales, -2, -1, -2).addComponent(this.JCBBodega, -2, -1, -2)).addContainerGap(13, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOrdenCActionPerformed(ActionEvent evt) {
        this.xTipoOrden = 1;
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOrdenTActionPerformed(ActionEvent evt) {
        this.xTipoOrden = 2;
        this.filtro = new ArrayList();
        this.filtro.add(Integer.valueOf(this.xTipoOrden));
        cargarPedidoPorIdEmpresa(this.filtro, Long.valueOf(Long.parseLong(this.xidproveedor)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBContratoActionPerformed(ActionEvent evt) {
        this.xTipoOrden = 3;
        this.filtro = new ArrayList();
        this.filtro.add(Integer.valueOf(this.xTipoOrden));
        cargarPedidoPorIdEmpresa(this.filtro, Long.valueOf(Long.parseLong(this.xidproveedor)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.xobjetollamador.equals("Entradas")) {
                Object[] botones = {"Cargar Datos", "Consultar Entradas", "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (n == 0) {
                    try {
                        this.xjifentrada.JTFOrdenC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.xjifentrada.JTFTotalOCompra.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
                        String sql = "SELECT Id, Id_OrdenCompra FROM i_msolicitud_pedido WHERE (Id_OrdenCompra ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString() + "') ";
                        ResultSet xrs = this.xconsulta.traerRs(sql);
                        try {
                            if (xrs.next()) {
                                xrs.first();
                                this.xjifentrada.JSPNSolicitudP.setValue(Long.valueOf(xrs.getLong(1)));
                            }
                            xrs.close();
                            this.xconsulta.cerrarConexionBd();
                        } catch (SQLException ex) {
                            Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        }
                        this.xjifentrada.setSelected(true);
                    } catch (PropertyVetoException e) {
                        Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, e);
                    }
                    dispose();
                    return;
                }
                if (n == 1) {
                    mCargarDatosTabla(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    return;
                }
                return;
            }
            if (this.xobjetollamador.equals("Radicacion")) {
                if (this.JRBOrdenC.isSelected()) {
                    if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().equals("SIN RECIBIR")) {
                        JOptionPane.showInternalMessageDialog(this, "Orden sin recibir", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    if (Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).longValue() != 0) {
                        Object[] botones2 = {"Orden de Compra", "Entrada", "Cargar Dato", "Cerrar"};
                        int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
                        if (n2 == 0) {
                            String[][] mparametros = new String[4][2];
                            mparametros[0][0] = "IdC";
                            mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                            mparametros[1][0] = "UsuarioS";
                            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                            mparametros[2][0] = "SUBREPORT_DIR";
                            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenCompra", mparametros);
                            return;
                        }
                        if (n2 == 1) {
                            mCargarDatosTabla(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                            return;
                        }
                        if (n2 == 2) {
                            if (this.JTDetalleEntrada.getRowCount() > 0) {
                                if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalleEntrada, 6)) {
                                    this.xjifradicacion.JTFNOrdenCompra.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                                    this.xjifradicacion.JDFFechaOC.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
                                    this.xjifradicacion.JTAConceptoC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                                    if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                                        this.xjifradicacion.JTFNFactura.setText(this.xmodelode.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 2).toString());
                                        this.xjifradicacion.JTFFSubTotal.setValue(Double.valueOf(this.xmodelode.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 3).toString()));
                                        this.xjifradicacion.JTFFIva.setValue(Double.valueOf(this.xmodelode.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 4).toString()));
                                    } else {
                                        this.xjifradicacion.JTFNFactura.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
                                        this.xjifradicacion.JTFFSubTotal.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()));
                                        this.xjifradicacion.JTFFIva.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()));
                                    }
                                    this.xjifradicacion.mCalcularTotal();
                                    try {
                                        this.xjifradicacion.setSelected(true);
                                    } catch (PropertyVetoException e2) {
                                        Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, e2);
                                    }
                                    dispose();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe selecionar las entradas", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            this.xjifradicacion.JTFNOrdenCompra.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                            this.xjifradicacion.JDFFechaOC.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
                            this.xjifradicacion.JTAConceptoC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                            this.xjifradicacion.JTFNFactura.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
                            this.xjifradicacion.JTFFSubTotal.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()));
                            this.xjifradicacion.JTFFIva.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()));
                            this.xjifradicacion.mCalcularTotal();
                            try {
                                this.xjifradicacion.setSelected(true);
                            } catch (PropertyVetoException e3) {
                                Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, e3);
                            }
                            dispose();
                            return;
                        }
                        return;
                    }
                    Object[] botones3 = {"Orden de Compra", "Cargar Dato", "Cerrar"};
                    int n3 = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones3, "Cerrar");
                    if (n3 == 0) {
                        String[][] mparametros2 = new String[4][2];
                        mparametros2[0][0] = "IdC";
                        mparametros2[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                        mparametros2[1][0] = "UsuarioS";
                        mparametros2[1][1] = Principal.usuarioSistemaDTO.getLogin();
                        mparametros2[2][0] = "SUBREPORT_DIR";
                        mparametros2[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                        mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
                        mparametros2[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenCompra", mparametros2);
                        return;
                    }
                    if (n3 == 1) {
                        if (this.JTDetalleEntrada.getRowCount() > 0) {
                            if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalleEntrada, 6)) {
                                this.xjifradicacion.JTFNOrdenCompra.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                                this.xjifradicacion.JDFFechaOC.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
                                this.xjifradicacion.JTAConceptoC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                                this.xjifradicacion.JTFNFactura.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
                                this.xjifradicacion.JTFFSubTotal.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()));
                                this.xjifradicacion.JTFFIva.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()));
                                this.xjifradicacion.mCalcularTotal();
                                try {
                                    this.xjifradicacion.setSelected(true);
                                } catch (PropertyVetoException e4) {
                                    Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, e4);
                                }
                                dispose();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe selecionar las entradas", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        this.xjifradicacion.JTFNOrdenCompra.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.xjifradicacion.JDFFechaOC.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
                        this.xjifradicacion.JTAConceptoC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                        this.xjifradicacion.JTFNFactura.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
                        this.xjifradicacion.JTFFSubTotal.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()));
                        this.xjifradicacion.JTFFIva.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()));
                        this.xjifradicacion.mCalcularTotal();
                        try {
                            this.xjifradicacion.setSelected(true);
                        } catch (PropertyVetoException e5) {
                            Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, e5);
                        }
                        dispose();
                        return;
                    }
                    return;
                }
                llenarDatosTablaEntrada();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleEntradaMouseClicked(MouseEvent evt) {
        if (this.JTDetalleEntrada.getSelectedRow() != -1) {
            if (this.JRBOrdenC.isSelected()) {
                if (this.JTDetalleEntrada.getSelectedColumn() != 6) {
                    String[][] parametros = new String[4][2];
                    parametros[0][0] = "numero";
                    parametros[0][1] = this.xmodelode.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 0).toString();
                    parametros[1][0] = "nbreUsuario";
                    parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                    parametros[2][0] = "SUBREPORT_DIR";
                    parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                    parametros[3][0] = "SUBREPORTFIRMA_DIR";
                    parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "I_EntradaAInventario", parametros);
                    return;
                }
                if (this.JTDetalleEntrada.getSelectedColumn() == 6 && this.xobjetollamador.equals("Radicacion")) {
                    mAgregar_Id_Vector();
                    return;
                }
                return;
            }
            if (Long.valueOf(this.JTDetalleEntrada.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 14).toString()).longValue() == 0) {
                System.out.println("" + this.JTDetalleEntrada.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 6).toString());
                this.xjifradicacion.JTFNOrdenCompra.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.xjifradicacion.JTFNFactura.setText(this.modeloDetalleEntrada.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 2).toString());
                this.xjifradicacion.JDFFechaOC.setDate((Date) this.modeloDetalleEntrada.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 1));
                this.xjifradicacion.JTAConceptoC.setText(this.modeloDetalleEntrada.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 7).toString());
                this.xjifradicacion.JTFFSubTotal.setValue(Double.valueOf(this.modeloDetalleEntrada.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 3).toString()));
                this.xjifradicacion.JTFFIva.setValue(Double.valueOf(this.modeloDetalleEntrada.getValueAt(this.JTDetalleEntrada.getSelectedRow(), 5).toString()));
                this.xjifradicacion.setxIdTipoO(this.xTipoOrden);
                this.xjifradicacion.mCalcularTotal();
                try {
                    this.xjifradicacion.setSelected(true);
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, e);
                }
                dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "Factura ya radicada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_Combo_Bodega();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_Combo_Bodega();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Orden", "Fecha", "Observación", "Valor", "Saldo", "EstadoR", "Id", "NFactura", "SubTotal", "V/Iva", "IdEstadoR"}) { // from class: ComprasBS.JIFConsultarEstadoOc.8
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, String.class, Long.class, String.class, Double.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloOrdenCompraEntrada() {
        this.modeloDetalleEntrada = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "numero Factura", "subtotal", "flete", "impuesto", "descuento", "observacion", "estado", "Motivo Anulacion", "fechaAnulacion", "usuarioAnulacion", "fechaRegistro", "idUsuarioRh", "Id radicacion"}) { // from class: ComprasBS.JIFConsultarEstadoOc.9
            Class[] types = {Long.class, Date.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, Boolean.class, String.class, Date.class, String.class, Date.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleEntrada;
        JTable jTable2 = this.JTDetalleEntrada;
        jTable.setAutoResizeMode(0);
        this.JTDetalleEntrada.doLayout();
        this.JTDetalleEntrada.setModel(this.modeloDetalleEntrada);
        this.JTDetalleEntrada.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleEntrada.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalleEntrada.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleEntrada.getColumnModel().getColumn(14).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloOrdenCompra() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Orden", "Consecutivo", "Tipo Documento", "Documento", "Tercero", "ValorOrden", "ValorFacturas", "Saldo"}) { // from class: ComprasBS.JIFConsultarEstadoOc.10
            Class[] types = {Long.class, Date.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class};
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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    public void cargarPedidoPorIdEmpresa(List<Integer> tipo, Long idEmpresa) {
        crearModeloOrdenCompra();
        List<IOdenesCompraContrato> e = this.CordenCompra.ListaOrdenesDeCompraPorIdEmpresa(tipo, idEmpresa);
        System.out.println("entra al metodo" + e.size());
        if (e != null && !e.isEmpty()) {
            e.forEach(detalle -> {
                this.modelo.addRow(this.datos);
                this.JTDetalle.setValueAt(detalle.getId(), this.JTDetalle.getRowCount() - 1, 0);
                this.JTDetalle.setValueAt(detalle.getFechaOrden(), this.JTDetalle.getRowCount() - 1, 1);
                this.JTDetalle.setValueAt(detalle.getConsecutivo(), this.JTDetalle.getRowCount() - 1, 2);
                this.JTDetalle.setValueAt(detalle.getTipoDocumento(), this.JTDetalle.getRowCount() - 1, 3);
                this.JTDetalle.setValueAt(detalle.getDocumento(), this.JTDetalle.getRowCount() - 1, 4);
                this.JTDetalle.setValueAt(detalle.getTercero(), this.JTDetalle.getRowCount() - 1, 5);
                this.JTDetalle.setValueAt(detalle.getValorOrden(), this.JTDetalle.getRowCount() - 1, 6);
                this.JTDetalle.setValueAt(detalle.getValorFacturas(), this.JTDetalle.getRowCount() - 1, 7);
                this.JTDetalle.setValueAt(detalle.getValorSaldo(), this.JTDetalle.getRowCount() - 1, 8);
            });
        }
    }

    private void llenarDatosTablaEntrada() {
        crearModeloOrdenCompraEntrada();
        this.detallesHistorico = this.registroFacturaService.ListaOrdenProduccionFacturaRadicacion(Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
        this.detallesHistorico.forEach(e -> {
            this.modeloDetalleEntrada.addRow(this.datos);
            this.modeloDetalleEntrada.setValueAt(e.getId(), this.JTDetalleEntrada.getRowCount() - 1, 0);
            this.modeloDetalleEntrada.setValueAt(e.getFecha(), this.JTDetalleEntrada.getRowCount() - 1, 1);
            this.modeloDetalleEntrada.setValueAt(e.getNumeroFactura(), this.JTDetalleEntrada.getRowCount() - 1, 2);
            this.modeloDetalleEntrada.setValueAt(e.getSubtotal(), this.JTDetalleEntrada.getRowCount() - 1, 3);
            this.modeloDetalleEntrada.setValueAt(e.getFlete(), this.JTDetalleEntrada.getRowCount() - 1, 4);
            this.modeloDetalleEntrada.setValueAt(e.getImpuesto(), this.JTDetalleEntrada.getRowCount() - 1, 5);
            this.modeloDetalleEntrada.setValueAt(e.getDescuento(), this.JTDetalleEntrada.getRowCount() - 1, 6);
            this.modeloDetalleEntrada.setValueAt(e.getObservacion(), this.JTDetalleEntrada.getRowCount() - 1, 7);
            this.modeloDetalleEntrada.setValueAt(e.getEstado(), this.JTDetalleEntrada.getRowCount() - 1, 8);
            System.out.println(e.getEstado());
            this.modeloDetalleEntrada.setValueAt(e.getMotivoAnulacion(), this.JTDetalleEntrada.getRowCount() - 1, 9);
            this.modeloDetalleEntrada.setValueAt(e.getFechaAnulacion(), this.JTDetalleEntrada.getRowCount() - 1, 10);
            this.modeloDetalleEntrada.setValueAt(e.getUsuarioAnulacion(), this.JTDetalleEntrada.getRowCount() - 1, 11);
            this.modeloDetalleEntrada.setValueAt(e.getFechaRegistro(), this.JTDetalleEntrada.getRowCount() - 1, 12);
            this.modeloDetalleEntrada.setValueAt(e.getIdUsuarioRh(), this.JTDetalleEntrada.getRowCount() - 1, 13);
            this.modeloDetalleEntrada.setValueAt(e.getIdRadicacion(), this.JTDetalleEntrada.getRowCount() - 1, 14);
            this.JTDetalleEntrada.setDefaultRenderer(Object.class, new MiRender2());
        });
    }

    /* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFConsultarEstadoOc$MiRender2.class */
    public static class MiRender2 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 14).toString()).longValue() != 0) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_OC() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Orden", "Fecha", "Observación", "Subtotal", "V/Iva", "Total", "EstadoR", "Id", "VRadicado", "Saldo"}) { // from class: ComprasBS.JIFConsultarEstadoOc.11
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class, Boolean.class, Long.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosE() {
        this.xmodelode = new DefaultTableModel(new Object[0], new String[]{"N° Orden", "Fecha", "N° Factura", "Valor", "V/Iva", "Total", "S"}) { // from class: ComprasBS.JIFConsultarEstadoOc.12
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleEntrada.setModel(this.xmodelode);
        this.JTDetalleEntrada.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleEntrada.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalleEntrada.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalleEntrada.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleEntrada.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleEntrada.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleEntrada.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    public void mNuevo() {
        this.xTipoOrden = 1;
        this.xlleno = false;
        GregorianCalendar xdato = new GregorianCalendar(Integer.valueOf(this.xmetodos.formatoANO.format(this.xmetodos.getFechaActual())).intValue(), Integer.valueOf(this.xmetodos.formatoMes.format(this.xmetodos.getFechaActual())).intValue() - 1, new Integer(1).intValue());
        this.JDFFechaI.setDate(xdato.getTime());
        this.JDFFechaF.setDate(this.xmetodos.getFechaActual());
        this.JRBOrdenC.setSelected(true);
        mCrearModeloDatos();
        mCrearModeloDatosE();
        mCargar_Combo_Bodega();
        this.xlleno = true;
    }

    private void mCargar_Combo_Bodega() {
        this.JCBBodega.removeAllItems();
        if (this.xobjetollamador.equals("Entradas")) {
            this.xsql = "SELECT `i_bodegas`.`Id` , `i_bodegas`.`Nbre` FROM  `i_entradas` INNER JOIN `i_bodegas`  ON (`i_entradas`.`IdBodega` = `i_bodegas`.`Id`) WHERE (`i_entradas`.`FechaEntrada` >='" + this.xmetodos.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND `i_entradas`.`Estado` =0 AND `i_entradas`.`FechaEntrada` <='" + this.xmetodos.formatoAMD1.format(this.JDFFechaF.getDate()) + "') GROUP BY `i_bodegas`.`Id` ORDER BY `i_bodegas`.`Nbre` ASC ";
            this.xidbodega = this.xconsulta.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
            this.JCBBodega.setSelectedItem(Principal.xClaseInventario.getNbreBodega());
        } else {
            this.xsql = "SELECT `i_bodegas`.`Id` , `i_bodegas`.`Nbre` FROM  `i_entradas` INNER JOIN `i_bodegas`  ON (`i_entradas`.`IdBodega` = `i_bodegas`.`Id`) WHERE (`i_bodegas`.`Contabilidad` = 1 AND `i_entradas`.`FechaEntrada` >='" + this.xmetodos.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND `i_entradas`.`Estado` =0 AND `i_entradas`.`FechaEntrada` <='" + this.xmetodos.formatoAMD1.format(this.JDFFechaF.getDate()) + "') GROUP BY `i_bodegas`.`Id` ORDER BY `i_bodegas`.`Nbre` ASC ";
            this.xidbodega = this.xconsulta.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
            this.JCBBodega.setSelectedIndex(-1);
        }
        this.xconsulta.cerrarConexionBd();
    }

    private void mRealizarCasting(JInternalFrame frm) {
        if (frm.getName().equals("Entradas")) {
            this.xjifentrada = (Entradas) frm;
            this.xobjetollamador = "Entradas";
            this.xidproveedor = this.xjifentrada.listaProveedor[this.xjifentrada.cboProveedor.getSelectedIndex()];
        } else if (frm.getName().equals("jifradicacionfac")) {
            this.xjifradicacion = (JIFRadicacion) frm;
            this.xidproveedor = this.xjifradicacion.xidempresa[this.xjifradicacion.JCBEmpresa.getSelectedIndex()][0];
            this.xobjetollamador = "Radicacion";
        }
    }

    private void mCargarDatosTabla(String xid) {
        try {
            mCrearModeloDatosE();
            String sql = "SELECT i_entradas.Id,  DATE_FORMAT(i_entradas.FechaEntrada,'%d-%m-%Y') AS FechaE, i_entradas.NoFactura, ROUND(SUM(i_detalleentrada.ValorUnitario*i_detalleentrada.Cantidad)+`i_entradas`.`VFletesO`-`i_entradas`.`VDescuento`) AS VUnitario, SUM(IF(i_bodegas.`Principal`=1,((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100),IF(i_detalleentrada.Iva<>0,ROUND(((i_detalleentrada.ValorUnitario-(i_detalleentrada.ValorUnitario/((i_detalleentrada.Iva/100)+1)))*i_detalleentrada.Cantidad),2) ,0) )) AS VIva , ROUND(SUM(i_detalleentrada.ValorUnitario*i_detalleentrada.Cantidad)+`i_entradas`.`VFletesO`-`i_entradas`.`VDescuento`)  AS VTotal FROM i_detalleentrada INNER JOIN i_entradas  ON (i_detalleentrada.IdEntrada = i_entradas.Id) INNER JOIN `i_bodegas`  ON (i_bodegas.`Id` = i_entradas.`IdBodega`) WHERE (i_entradas.NOrdenCompra ='" + xid + "' AND i_entradas.Estado =0 AND i_entradas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') GROUP BY i_entradas.Id ORDER BY i_entradas.FechaEntrada ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                double xsubtotal = 0.0d;
                double xiva = 0.0d;
                while (xrs.next()) {
                    this.xmodelode.addRow(this.xdatos);
                    this.xmodelode.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelode.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelode.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelode.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelode.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelode.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelode.setValueAt(false, n, 6);
                    xsubtotal += xrs.getDouble(4);
                    xiva += xrs.getDouble(5);
                    n++;
                }
                this.JTFFSubtotal.setValue(Double.valueOf(xsubtotal));
                this.JTFFVIva.setValue(Double.valueOf(xiva));
                this.JTFFTotal.setValue(Double.valueOf(xsubtotal + xiva));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "with  ordenCompra as (\nSELECT \ncc_orden_compra.Id idOrden, \ncc_orden_compra.FechaC fechaOrden,\ncc_orden_compra.Observacion  observacion, \nSUM((((cc_detalle_orden_compra.VUntiario*cc_detalle_orden_compra.Cantidad)*cc_detalle_orden_compra.PIva)/100)+(cc_detalle_orden_compra.VUntiario*cc_detalle_orden_compra.Cantidad)+cc_orden_compra.VFlete) AS valorTotalOrden ,\nIF(cc_orden_compra.EstadoR=0,'SIN RECIBIR',IF(cc_orden_compra.EstadoR=1,'PARCIALMENTE',IF(cc_orden_compra.EstadoR=2,'TOTAL','CERRADA'))) AS estadoRecibidoTexto,\ncc_orden_compra.EstadoR estadoRecibido,\ncc_orden_compra.Id_Tercero  idTercero\nFROM cc_detalle_orden_compra \nINNER JOIN cc_orden_compra  ON (cc_detalle_orden_compra.Id_OrdenC = cc_orden_compra.Id)\nWHERE ( cc_orden_compra.Id_Tercero=" + this.xidproveedor + "  \nAND cc_orden_compra.Estado=1 and cc_orden_compra.FechaC between '" + this.xmetodos.formatoAMD1.format(this.JDFFechaI.getDate()) + "' and '" + this.xmetodos.formatoAMD1.format(this.JDFFechaF.getDate()) + "' ) \nGROUP BY cc_orden_compra.Id desc\n),\n\nentrada as (\nselect\nSUM(i_detalleentrada.Cantidad*(i_detalleentrada.ValorUnitario+((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)+i_detalleentrada.VFletesO-i_detalleentrada.VDescuento)) Valortotal,\ni_entradas.Id idEntrada,\ni_entradas.IdProveedor idTercero,\ni_entradas.NoFactura numeroFactura,\nsum(((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)) iva,\ni_entradas.NOrdenCompra idOrden\n\n    FROM\n     i_entradas\n    INNER JOIN  i_detalleentrada\n        ON (i_detalleentrada.IdEntrada = i_entradas.Id)\n    inner join  ordenCompra o on (o.idOrden=i_entradas.NOrdenCompra) and (o.idTercero=i_entradas.IdProveedor)\nWHERE ( i_entradas.Estado=0 \n and i_entradas.IdBodega = " + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "\n    )\t\nGROUP BY  i_entradas.NOrdenCompra\n)\n\nselect \no.idOrden, \nDate_Format(o.fechaOrden,'%d-%m-%Y') fechaOrden, \no.observacion, \no.valorTotalOrden ,\no.estadoRecibidoTexto,\no.estadoRecibido,\nifnull(round(e.Valortotal,2), 0) valorEntrada ,\nifnull(e.idEntrada,0)idEntrada,\nifnull(e.numeroFactura,'')numeroFactura,\nifnull(e.iva,0) valorIvaEntrada,\nround((o.valorTotalOrden-ifnull(round(e.Valortotal,2), 0)),2) saldo,\nifnull(e.idOrden, 0)idOrden\nfrom ordenCompra o\nleft join entrada e on (e.idOrden=o.idOrden)\norder by o.fechaOrden desc";
            System.out.println(sql);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idOrden")), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("fechaOrden"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("observacion"), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("valorTotalOrden")), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("saldo")), n, 4);
                    this.xmodelo.setValueAt(xrs.getString("estadoRecibidoTexto"), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idEntrada")), n, 6);
                    this.xmodelo.setValueAt(xrs.getString("numeroFactura"), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("valorEntrada")), n, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("valorIvaEntrada")), n, 9);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("estadoRecibido")), n, 10);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_OC() {
        try {
            mCrearModeloDatos_OC();
            this.xsql = "with ordenCompra as (\n \t SELECT\n    `cc_orden_compra`.`NInterno` numeroConsecutivo\n    , date_format(`cc_orden_compra`.`FechaC`, '%d-%m-%Y') fechaOrden\n    , ifnull(`cc_orden_compra`.`ObjetivoG`,'')  objetivoOrden\n \t, (ifnull(cc_orden_compra.VDescuento, 0) + ifnull(cc_orden_compra.ValorP , 0)+  ifnull(cc_orden_compra.VFlete , 0))\n , round(ifnull(sum((cdoc.Cantidad *cdoc.VUntiario )+(((cdoc.Cantidad *cdoc.VUntiario )* cdoc.PIva )/100)),(ifnull(cc_orden_compra.VDescuento, 0) + ifnull(cc_orden_compra.ValorP , 0)+  ifnull(cc_orden_compra.VFlete , 0)+ ((ifnull(cc_orden_compra.ValorP , 0) * cc_orden_compra.Iva )/100) )))  valoTotal\n    , round(ifnull(sum(((cdoc.Cantidad *cdoc.VUntiario )* cdoc.PIva )/100),((ifnull(cc_orden_compra.ValorP , 0) * cc_orden_compra.Iva )/100))) valorIva\n    -- , cdoc.PIva \n   --  , + IFNULL(d.VAdicion,0)\n   -- , IF((SUM(IFNULL(cc_radicacion.`SubTotal`,0)+IFNULL(cc_radicacion.`Iva`, 0)) <(`cc_orden_compra`.`ValorP`   + ROUND((`cc_orden_compra`.`ValorP`*`cc_orden_compra`.`Iva`)/100)+ IFNULL(d.VAdicion,0))), FALSE, TRUE)  AS `EstadoR` \n    , `cc_orden_compra`.`Id`  idOrdenCompra\n    ,  `cc_tipo_documentof`.`Tipo` idTipoDocumento\n    -- , SUM(IFNULL(cc_radicacion.`SubTotal`,0)+IFNULL(cc_radicacion.`Iva`, 0)) VRadicado\n -- , ((`cc_orden_compra`.`ValorP`   + ROUND((`cc_orden_compra`.`ValorP`*`cc_orden_compra`.`Iva`)/100) + IFNULL(d.VAdicion,0))-SUM(IFNULL(cc_radicacion.`SubTotal`,0)+IFNULL(cc_radicacion.`Iva`, 0))) saldo   \nFROM\n    `cc_orden_compra`\n\tleft join cc_detalle_orden_compra cdoc \n\t\ton (cdoc.Id_OrdenC=cc_orden_compra.Id)\n  left JOIN `cc_tipo_documentof` \n        ON (`cc_orden_compra`.`Id_TipoDocF` = `cc_tipo_documentof`.`Id`) \nWHERE (`cc_orden_compra`.`Id_Tercero` =" + this.xidproveedor + " \n     AND `cc_orden_compra`.`Estado` =1\n     AND `cc_tipo_documentof`.`Tipo` =" + this.xTipoOrden + "\n      and `cc_orden_compra`.`FechaC` between '" + this.xmetodos.formatoAMD1.format(this.JDFFechaI.getDate()) + "' and '" + this.xmetodos.formatoAMD1.format(this.JDFFechaF.getDate()) + "'\n    )\n  GROUP BY    cc_orden_compra.`Id` \n  ORDER BY `cc_orden_compra`.`FechaC` DESC\n \n ),\n adicionesOrdeCompra as (\n \tSELECT\n    ad.`Id_OrdenCompra` idOrden\n    , IFNULL(SUM(ad.`Valor`),0) AS valorAdicion\nFROM\n    `cc_orden_compra_adicion` ad\n    inner join ordenCompra o on (o.idOrdenCompra=ad.Id_OrdenCompra)\nWHERE (ad.`Estado` =1)\nGROUP BY ad.`Id_OrdenCompra`\n HAVING valorAdicion<>0 \n ),\n radicacionesOrdenCompra as (\n \tselect cr.NoCompra idOrden,\n \t(cr.SubTotal + cr.Otros + cr.Iva ) valorRadicacion\n \tfrom  cc_radicacion cr \n \t inner join ordenCompra o on (o.idOrdenCompra=cr.NoCompra) and (cr.TipoR=o.idTipoDocumento)\n \t where cr.Estado =1\n \t\n )\n         \nselect \no.numeroConsecutivo,\no.fechaOrden,\no.objetivoOrden,\no.valoTotal subTotal,\no.valorIva,\no.valoTotal,\nif(((o.valoTotal+ifnull(a.valorAdicion,0))<ifnull(r.valorRadicacion,0)), true, false)estadoRecibido,\no.idOrdenCompra, \nround(ifnull(r.valorRadicacion,0)) valorRadicado,\nround(((o.valoTotal+ifnull(a.valorAdicion,0))-ifnull(r.valorRadicacion,0)),2) saldo\nfrom   ordenCompra o\nleft join adicionesOrdeCompra a on (a.idOrden=o.idOrdenCompra)\nleft join radicacionesOrdenCompra r on (r.idOrden=o.idOrdenCompra)";
            System.out.println(this.xsql);
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("numeroConsecutivo"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("fechaOrden"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("objetivoOrden"), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("subTotal")), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("valorIva")), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("valoTotal")), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("estadoRecibido")), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("idOrdenCompra")), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("valorRadicado")), n, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("saldo")), n, 9);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender1());
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarEstadoOc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFConsultarEstadoOc$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xestado = Long.valueOf(table.getValueAt(row, 10).toString()).longValue();
            if (xestado == 0) {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.black);
            } else if (xestado == 3) {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.black);
            } else if (xestado == 1) {
                cell.setBackground(Color.PINK);
                cell.setForeground(Color.black);
            } else {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.black);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFConsultarEstadoOc$MiRender1.class */
    public class MiRender1 extends DefaultTableCellRenderer {
        public MiRender1() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 6).toString()).booleanValue()) {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.black);
            } else {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.black);
            }
            return cell;
        }
    }

    public void mBuscar() {
        if (this.JRBOrdenC.isSelected()) {
            if (this.JCBBodega.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBBodega.requestFocus();
                return;
            }
        }
        if (this.JRBOrdenT.isSelected() || this.JRBContrato.isSelected()) {
            cargarPedidoPorIdEmpresa(this.filtro, Long.valueOf(Long.parseLong(this.xidproveedor)));
        }
    }

    private void mAgregar_Id_Vector() {
        this.xjifradicacion.xvector.removeAllElements();
        for (int x = 0; x < this.JTDetalleEntrada.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelode.getValueAt(x, 6).toString()).booleanValue()) {
                this.xjifradicacion.xvector.add(this.xmodelode.getValueAt(x, 0).toString());
            }
        }
    }
}
