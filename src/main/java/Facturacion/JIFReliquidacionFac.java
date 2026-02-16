package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFReliquidacionFac.class */
public class JIFReliquidacionFac extends JInternalFrame {
    private int xidplan;
    private long xidingreso;
    private DefaultTableModel xmodcombos;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private ButtonGroup JBGTipo;
    private ButtonGroup JBGTipoC;
    public JTableComboBox JCBEstrato;
    private JPanel JPIDatos;
    private JPanel JPITipoCobro;
    private JPanel JPTipo;
    public JRadioButton JRBCModeradora;
    private JRadioButton JRBCapita;
    public JRadioButton JRBCopago;
    private JRadioButton JRBEvento;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;
    private JTextField JTFEmpresa;
    private JFormattedTextField JTFFNFactura;
    private JFormattedTextField JTFFTCCopago;
    private JFormattedTextField JTFFTCModeradora;
    private JFormattedTextField JTFFTEps;
    private JFormattedTextField JTFFTServicio;
    private JTextField JTFNAutorizacion;
    private JTextField JTFNServicio;
    private JTextField JTFNSiras;
    private JTextField JTFNUsuario;
    private int xtipo = 0;
    private int xescoopago = 0;
    private int xidempresa = 0;
    private long xidliquidacion = 0;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xlleno = false;

    public JIFReliquidacionFac(String xnombre) {
        initComponents();
        setName(xnombre);
        mCrearTablaDetalle();
    }

    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JBGTipoC = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JPTipo = new JPanel();
        this.JRBEvento = new JRadioButton();
        this.JRBCapita = new JRadioButton();
        this.JTFFNFactura = new JFormattedTextField();
        this.JTFNServicio = new JTextField();
        this.JTFNUsuario = new JTextField();
        this.JPITipoCobro = new JPanel();
        this.JRBCModeradora = new JRadioButton();
        this.JRBCopago = new JRadioButton();
        try {
            this.JCBEstrato = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        this.JTFEmpresa = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFFTServicio = new JFormattedTextField();
        this.JTFFTCModeradora = new JFormattedTextField();
        this.JTFFTCCopago = new JFormattedTextField();
        this.JTFFTEps = new JFormattedTextField();
        this.JTFNAutorizacion = new JTextField();
        this.JTFNSiras = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("ACTUALIZAR NUMERO DE AUTORIZACION");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifreliquidacionfactura");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Liquidación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipo.add(this.JRBEvento);
        this.JRBEvento.setFont(new Font("Arial", 1, 12));
        this.JRBEvento.setText("Evento");
        this.JRBEvento.addActionListener(new ActionListener() { // from class: Facturacion.JIFReliquidacionFac.1
            public void actionPerformed(ActionEvent evt) {
                JIFReliquidacionFac.this.JRBEventoActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBCapita);
        this.JRBCapita.setFont(new Font("Arial", 1, 12));
        this.JRBCapita.setSelected(true);
        this.JRBCapita.setText("Capita");
        this.JRBCapita.addActionListener(new ActionListener() { // from class: Facturacion.JIFReliquidacionFac.2
            public void actionPerformed(ActionEvent evt) {
                JIFReliquidacionFac.this.JRBCapitaActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEvento).addGap(18, 18, 18).addComponent(this.JRBCapita).addContainerGap(-1, 32767)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEvento).addComponent(this.JRBCapita)));
        this.JTFFNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Orden/Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNFactura.setHorizontalAlignment(4);
        this.JTFFNFactura.setFont(new Font("Arial", 1, 12));
        this.JTFFNFactura.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFReliquidacionFac.3
            public void focusLost(FocusEvent evt) {
                JIFReliquidacionFac.this.JTFFNFacturaFocusLost(evt);
            }
        });
        this.JTFFNFactura.addActionListener(new ActionListener() { // from class: Facturacion.JIFReliquidacionFac.4
            public void actionPerformed(ActionEvent evt) {
                JIFReliquidacionFac.this.JTFFNFacturaActionPerformed(evt);
            }
        });
        this.JTFNServicio.setFont(new Font("Arial", 1, 12));
        this.JTFNServicio.setHorizontalAlignment(2);
        this.JTFNServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFNUsuario.setHorizontalAlignment(2);
        this.JTFNUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPITipoCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Cobro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipoC.add(this.JRBCModeradora);
        this.JRBCModeradora.setFont(new Font("Arial", 1, 12));
        this.JRBCModeradora.setSelected(true);
        this.JRBCModeradora.setText("C. Moderadora");
        this.JRBCModeradora.addActionListener(new ActionListener() { // from class: Facturacion.JIFReliquidacionFac.5
            public void actionPerformed(ActionEvent evt) {
                JIFReliquidacionFac.this.JRBCModeradoraActionPerformed(evt);
            }
        });
        this.JBGTipoC.add(this.JRBCopago);
        this.JRBCopago.setFont(new Font("Arial", 1, 12));
        this.JRBCopago.setText("Copago");
        this.JRBCopago.addActionListener(new ActionListener() { // from class: Facturacion.JIFReliquidacionFac.6
            public void actionPerformed(ActionEvent evt) {
                JIFReliquidacionFac.this.JRBCopagoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoCobroLayout = new GroupLayout(this.JPITipoCobro);
        this.JPITipoCobro.setLayout(JPITipoCobroLayout);
        JPITipoCobroLayout.setHorizontalGroup(JPITipoCobroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoCobroLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBCModeradora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCopago, -2, 77, -2).addContainerGap(-1, 32767)));
        JPITipoCobroLayout.setVerticalGroup(JPITipoCobroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoCobroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCModeradora).addComponent(this.JRBCopago)));
        this.JCBEstrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Estrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEstrato.setFont(new Font("Arial", 1, 12));
        this.JCBEstrato.setShowTableGrid(true);
        this.JCBEstrato.setShowTableHeaders(true);
        this.JCBEstrato.addItemListener(new ItemListener() { // from class: Facturacion.JIFReliquidacionFac.7
            public void itemStateChanged(ItemEvent evt) {
                JIFReliquidacionFac.this.JCBEstratoItemStateChanged(evt);
            }
        });
        this.JTFEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFEmpresa.setHorizontalAlignment(2);
        this.JTFEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNFactura, -2, 123, -2).addGap(22, 22, 22).addComponent(this.JTFNUsuario, -1, 399, 32767).addGap(10, 10, 10).addComponent(this.JTFNServicio, -2, 203, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFEmpresa, -1, 390, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipoCobro, -2, 208, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEstrato, -2, 311, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTipo, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNServicio, -2, -1, -2).addComponent(this.JTFNUsuario, -2, -1, -2).addComponent(this.JTFFNFactura, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPITipoCobro, -2, -1, -2).addComponent(this.JTFEmpresa, -2, -1, -2).addComponent(this.JCBEstrato, -2, 52, -2)).addGap(20, 20, 20)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE ORDEN - FACTURA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setGridColor(new Color(204, 204, 204));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFReliquidacionFac.8
            public void keyPressed(KeyEvent evt) {
                JIFReliquidacionFac.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFFTServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTServicio.setHorizontalAlignment(4);
        this.JTFFTServicio.setFont(new Font("Arial", 1, 13));
        this.JTFFTServicio.setValue(new Double(0.0d));
        this.JTFFTCModeradora.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuota Moderadora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTCModeradora.setHorizontalAlignment(4);
        this.JTFFTCModeradora.setFont(new Font("Arial", 1, 13));
        this.JTFFTCModeradora.setValue(new Double(0.0d));
        this.JTFFTCCopago.setBorder(BorderFactory.createTitledBorder((Border) null, "Copago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTCCopago.setHorizontalAlignment(4);
        this.JTFFTCCopago.setFont(new Font("Arial", 1, 13));
        this.JTFFTCCopago.setValue(new Double(0.0d));
        this.JTFFTEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Eps", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTEps.setHorizontalAlignment(4);
        this.JTFFTEps.setFont(new Font("Arial", 1, 13));
        this.JTFFTEps.setValue(new Double(0.0d));
        this.JTFNAutorizacion.setFont(new Font("Arial", 1, 12));
        this.JTFNAutorizacion.setHorizontalAlignment(2);
        this.JTFNAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Autorización General", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNSiras.setFont(new Font("Arial", 1, 12));
        this.JTFNSiras.setHorizontalAlignment(2);
        this.JTFNSiras.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Siras", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNSiras.addActionListener(new ActionListener() { // from class: Facturacion.JIFReliquidacionFac.9
            public void actionPerformed(ActionEvent evt) {
                JIFReliquidacionFac.this.JTFNSirasActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 961, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFNAutorizacion, -2, 163, -2).addGap(18, 18, 18).addComponent(this.JTFNSiras, -2, 163, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFTServicio, -2, 123, -2).addGap(18, 18, 18).addComponent(this.JTFFTCModeradora, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTCCopago, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTEps, -2, 123, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 306, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTServicio, -2, -1, -2).addComponent(this.JTFFTCModeradora, -2, -1, -2).addComponent(this.JTFFTCCopago, -2, -1, -2).addComponent(this.JTFFTEps, -2, -1, -2).addComponent(this.JTFNAutorizacion, -2, -1, -2).addComponent(this.JTFNSiras, -2, -1, -2)).addContainerGap()));
        this.JTFNSiras.getAccessibleContext().setAccessibleName("N°Siras");
        getAccessibleContext().setAccessibleName("ACTUALIZACION NUMERO DE AUTORIZACION");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEventoActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCapitaActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCModeradoraActionPerformed(ActionEvent evt) {
        this.xescoopago = 0;
        mLLenarCombos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCopagoActionPerformed(ActionEvent evt) {
        this.xescoopago = 1;
        mLLenarCombos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNFacturaActionPerformed(ActionEvent evt) {
        this.JTFFNFactura.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNFacturaFocusLost(FocusEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEstratoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEstrato.getSelectedIndex() != -1) {
            mLiquidarOrden();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && !Principal.informacionIps.getIdentificacion().equals("812005644")) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar el procedimiento?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String xsql = "delete from f_itemordenesproced WHERE (Id_Ordenes ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' AND Id_Procedimiento ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1) + "')";
                this.xconsultas.ejecutarSQL(xsql);
                this.xconsultas.cerrarConexionBd();
                mActualizarValoresOrden();
                mCargarDatos();
                mActulizarIngresoLiquidacion();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNSirasActionPerformed(ActionEvent evt) {
    }

    private void mActulizarIngresoLiquidacion() {
        String xsql = "Update ingreso set SiCopago='" + this.xescoopago + "', Id_Estrato='" + this.JCBEstrato.getPopupTable().getValueAt(this.JCBEstrato.getSelectedIndex(), 0) + "' where Id='" + getXidingreso() + "'";
        this.xconsultas.ejecutarSQL(xsql);
        this.xconsultas.cerrarConexionBd();
        String xsql2 = "update f_liquidacion set TotalServicio='" + this.JTFFTServicio.getValue() + "', TotalEps='" + this.JTFFTEps.getValue() + "', TotalPlan='" + this.JTFFTServicio.getValue() + "', CuotaModeradora='" + this.JTFFTCModeradora.getValue() + "', Copago='" + this.JTFFTCCopago.getValue() + "' where Id='" + getXidliquidacion() + "'";
        this.xconsultas.ejecutarSQL(xsql2);
        this.xconsultas.cerrarConexionBd();
    }

    private void mActualizarValoresOrden() {
        String xsql;
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            try {
                String xsql2 = "SELECT `g_empresacont`.`Id_TipoPlan`, (SUM(((`f_itemordenesproced`.`ValorUnitario`*`f_itemordenesproced`.`Cantidad`)+f_itemordenesproced.valorImpuesto))-SUM(`f_itemordenesproced`.`ValorDescuento`)) AS `Valor`, SUM(`f_itemordenesproced`.`ValorDescuento`) AS Descuento FROM  `f_itemordenesproced` INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN`g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN  `f_tarifaprocedimiento`  ON (`f_tarifaprocedimiento`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) AND (`f_tarifaprocedimiento`.`Id_Manual` = `f_empresacontxconvenio`.`Id_Manual`) WHERE (`f_ordenes`.`Id` ='" + this.xmodelo.getValueAt(x, 0) + "') GROUP BY `f_tarifaprocedimiento`.`Id_TipoPlan` ";
                ResultSet xrs = this.xconsultas.traerRs(xsql2);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    ConsultasMySQL xct = new ConsultasMySQL();
                    while (xrs.next()) {
                        if (getXidplan() == xrs.getInt(1)) {
                            xsql = "update f_ordenes set `TotalOrdenes`=" + xrs.getDouble(2) + ", `TotalEPS`=" + xrs.getDouble(2) + ", `TotalDescuento`=" + xrs.getDouble(3) + " where Id='" + this.xmodelo.getValueAt(x, 0) + "'";
                        } else {
                            xsql = "update f_ordenes set `TotalPaciente`=" + xrs.getDouble(2) + " where Id='" + this.xmodelo.getValueAt(x, 0) + "'";
                        }
                        xct.ejecutarSQL(xsql);
                        xct.cerrarConexionBd();
                    }
                }
                xrs.close();
                this.xconsultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFReliquidacionFac.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mActualizarIngreso_NAutorizacion_Procedimiento() {
        String xsql = "Update ingreso set NoAutorizacion='" + this.JTFNAutorizacion.getText() + "' where Id='" + getXidingreso() + "'";
        this.xconsultas.ejecutarSQL(xsql);
        this.xconsultas.cerrarConexionBd();
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            String xsql2 = "update f_itemordenesproced set `NAutorizacion`='" + this.xmodelo.getValueAt(x, 6) + "' where Id_Ordenes='" + this.xmodelo.getValueAt(x, 0) + "' and Id_Procedimiento='" + this.xmodelo.getValueAt(x, 1) + "'";
            this.xconsultas.ejecutarSQL(xsql2);
            this.xconsultas.cerrarConexionBd();
        }
    }

    private void mActualizar_NSiras() {
        System.out.println("entraaaaaaaaaaaaa");
        String xsql = "Update ingreso set siras='" + this.JTFNSiras.getText() + "' where Id='" + getXidingreso() + "'";
        this.xconsultas.ejecutarSQL(xsql);
        this.xconsultas.cerrarConexionBd();
    }

    private void mLLenarCombos() {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT f_estrato.Id, f_estrato.Nbre as Estrato, f_estratoxemprcontconv.PorcSubsidio as Subsidio,f_estratoxemprcontconv.ValorMaximo as Valor_Maximo FROM f_estratoxemprcontconv INNER JOIN f_estrato  ON (f_estratoxemprcontconv.Id_Estrato = f_estrato.Id) WHERE (f_estratoxemprcontconv.Estado =0 AND f_estratoxemprcontconv.Copago ='" + this.xescoopago + "' AND f_estratoxemprcontconv.Id_EmpresaContConv ='" + getXidempresa() + "') ORDER BY Estrato ASC ";
        xct.llenarComboTabla(sql, this.JCBEstrato, this.xmodcombos, 1);
        this.JCBEstrato.setSelectedIndex(-1);
        xct.cerrarConexionBd();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"IdOrden", "IdProcedimiento", "Procedimiento", "Cant", "V/Unitario", "V/Total", "N° Autorización", "N° Siras"}) { // from class: Facturacion.JIFReliquidacionFac.10
            Class[] types = {Long.class, Long.class, String.class, Integer.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(40);
    }

    private void mCargarDatos() {
        if (!this.JTFFNFactura.getText().isEmpty()) {
            String sql = null;
            if (this.JRBCapita.isSelected()) {
                sql = "SELECT persona.NUsuario, f_tiposervicio.Nbre, f_empresacontxconvenio.Id, f_empresacontxconvenio.Nbre, ingreso.SiCopago, f_estrato.Nbre, f_itemordenesproced.Id_Ordenes, f_itemordenesproced.Id_Procedimiento , g_procedimiento.Nbre, f_itemordenesproced.Cantidad, f_itemordenesproced.ValorUnitario, ((f_itemordenesproced.ValorUnitario * f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto) AS VTotalE, f_liquidacion.TotalServicio, f_liquidacion.TotalEps, f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, f_liquidacion.CuotaModeradora, f_liquidacion.Copago, f_liquidacion.Id, ingreso.Id, `g_empresacont`.`Id_TipoPlan`, f_itemordenesproced.NAutorizacion, ingreso.NoAutorizacion , ingreso.siras FROM f_itemordenesproced INNER JOIN f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_factura_capita  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_tiposervicio ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN f_estrato  ON (ingreso.Id_Estrato = f_estrato.Id) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN`g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) WHERE (f_factura_capita.No_FacturaCapita ='" + this.JTFFNFactura.getText() + "' AND f_ordenes.Estado =0 AND f_liquidacion.Estado =0 AND f_factura_capita.Estado =0 AND f_factura_capita.No_FacturaEvento =0) ";
            } else if (this.JRBEvento.isSelected()) {
                sql = "SELECT persona.NUsuario, f_tiposervicio.Nbre, f_empresacontxconvenio.Id, f_empresacontxconvenio.Nbre, ingreso.SiCopago, f_estrato.Nbre, f_itemordenesproced.Id_Ordenes, f_itemordenesproced.Id_Procedimiento, g_procedimiento.Nbre, f_itemordenesproced.Cantidad , f_itemordenesproced.ValorUnitario, ((f_itemordenesproced.ValorUnitario * f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto) AS VTotalE, f_liquidacion.TotalServicio, f_liquidacion.TotalEps, f_liquidacion.TotalDescuento, f_liquidacion.TotalPaciente, f_liquidacion.CuotaModeradora, f_liquidacion.Copago, f_liquidacion.Id, ingreso.Id, `g_empresacont`.`Id_TipoPlan`, f_itemordenesproced.NAutorizacion, ingreso.NoAutorizacion, ingreso.siras  FROM f_itemordenesproced INNER JOIN f_ordenes  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN ingreso ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN persona ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN f_liquidacion  ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_tiposervicio ON (f_ordenes.Id_TipoServicio = f_tiposervicio.Id) INNER JOIN f_estrato ON (ingreso.Id_Estrato = f_estrato.Id) INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN`g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) WHERE (CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento_M) ='" + this.JTFFNFactura.getText() + "' AND f_ordenes.Estado =0 AND f_liquidacion.Estado =0 AND f_factura_evento.Estado =0) ";
            }
            mCrearTablaDetalle();
            ResultSet rs = this.xconsultas.traerRs(sql);
            try {
                if (rs.next()) {
                    this.JTFNUsuario.setText(rs.getString(1));
                    this.JTFNServicio.setText(rs.getString(2));
                    setXidempresa(rs.getInt(3));
                    this.JTFEmpresa.setText(rs.getString(4));
                    mLLenarCombos();
                    if (rs.getInt(5) == 0) {
                        this.JRBCModeradora.setSelected(true);
                        this.xescoopago = 0;
                    } else {
                        this.JRBCopago.setSelected(true);
                        this.xescoopago = 1;
                    }
                    this.JCBEstrato.setSelectedItem(rs.getString(6));
                    this.JTFFTServicio.setValue(Double.valueOf(rs.getDouble(13)));
                    this.JTFFTEps.setValue(Double.valueOf(rs.getDouble(14)));
                    this.JTFFTCModeradora.setValue(Double.valueOf(rs.getDouble(17)));
                    this.JTFFTCCopago.setValue(Double.valueOf(rs.getDouble(18)));
                    this.JTFNAutorizacion.setText(rs.getString("NoAutorizacion"));
                    this.JTFNSiras.setText(rs.getString("siras"));
                    setXidliquidacion(rs.getLong(19));
                    setXidingreso(rs.getLong(20));
                    setXidplan(rs.getInt(21));
                    this.xlleno = true;
                    rs.beforeFirst();
                    int x = 0;
                    while (rs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(7)), x, 0);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(8)), x, 1);
                        this.xmodelo.setValueAt(rs.getString(9), x, 2);
                        this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(10)), x, 3);
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(11)), x, 4);
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(12)), x, 5);
                        this.xmodelo.setValueAt(rs.getString("NAutorizacion"), x, 6);
                        this.xmodelo.setValueAt(rs.getString("siras"), x, 7);
                        x++;
                    }
                    mLiquidarOrden();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "N° Orden/Factura no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFNFactura.requestFocus();
                }
                rs.close();
                this.xconsultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFReliquidacionFac.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mLiquidarOrden() {
        double xtotals = 0.0d;
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            xtotals += Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue() * ((double) Integer.valueOf(this.xmodelo.getValueAt(x, 3).toString()).intValue());
        }
        this.JTFFTCCopago.setValue(new Double(0.0d));
        this.JTFFTCModeradora.setValue(new Double(0.0d));
        this.JTFFTServicio.setValue(Double.valueOf(xtotals));
        if (this.xescoopago == 0) {
            this.JTFFTCModeradora.setValue(this.JCBEstrato.getPopupTable().getValueAt(this.JCBEstrato.getSelectedIndex(), 3));
        } else {
            this.JTFFTCCopago.setValue(Double.valueOf(xtotals - ((xtotals * Double.valueOf(this.JCBEstrato.getPopupTable().getValueAt(this.JCBEstrato.getSelectedIndex(), 2).toString()).doubleValue()) / 100.0d)));
        }
        this.JTFFTEps.setValue(Double.valueOf(Double.valueOf(this.JTFFTServicio.getValue().toString()).doubleValue() - (Double.valueOf(this.JTFFTCModeradora.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFTCCopago.getValue().toString()).doubleValue())));
    }

    public void mGrabar() {
        if (!this.JTFFNFactura.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Object[] botones = {"Actualizar N° Autorización", "Actualizar Siras", "Cerrar"};
                    int n = JOptionPane.showInternalOptionDialog(this, "Que desea realizar?", "OPERACIONES A REALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Actualizar Siras");
                    if (n == 0) {
                        mActualizarIngreso_NAutorizacion_Procedimiento();
                    } else if (n == 1) {
                        mActualizar_NSiras();
                    }
                    mCargarDatos();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe buscar procedimientos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFNFactura.requestFocus();
    }

    public int getXidempresa() {
        return this.xidempresa;
    }

    public void setXidempresa(int xidempresa) {
        this.xidempresa = xidempresa;
    }

    public long getXidliquidacion() {
        return this.xidliquidacion;
    }

    public void setXidliquidacion(long xidliquidacion) {
        this.xidliquidacion = xidliquidacion;
    }

    public long getXidingreso() {
        return this.xidingreso;
    }

    public void setXidingreso(long xidingreso) {
        this.xidingreso = xidingreso;
    }

    public int getXidplan() {
        return this.xidplan;
    }

    public void setXidplan(int xidplan) {
        this.xidplan = xidplan;
    }

    public void mNuevo() {
        this.JRBCapita.setSelected(true);
        this.JTFFNFactura.setText("");
        this.JTFNUsuario.setText("");
        this.JTFFTServicio.setText("");
        this.JTFFTEps.setText("");
        this.JRBCModeradora.setSelected(true);
        this.JCBEstrato.setSelectedIndex(-1);
        this.JTFNAutorizacion.setText("");
        this.JTFNSiras.setText("");
        mCrearTablaDetalle();
    }

    public void mImprimir() {
        if (!this.JTFFNFactura.getText().isEmpty()) {
            Object[] botones = {"Carta", "Media Carta", "Cancelar"};
            if (this.xtipo == 0) {
                int n = JOptionPane.showInternalOptionDialog(this, "Con cual formato de pagina desea imprimir?", "VERIFICACION", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))), botones, "Cancelar");
                if (n == 0) {
                    Principal.clasefacturacion.imprimir_FacturayOrden(1, this.JTFFNFactura.getText(), String.valueOf(getXidingreso()), Principal.usuarioSistemaDTO.getLogin(), 0, 1, 0);
                    return;
                } else {
                    if (n == 1) {
                        Principal.clasefacturacion.imprimir_FacturayOrden(1, this.JTFFNFactura.getText(), String.valueOf(getXidingreso()), Principal.usuarioSistemaDTO.getLogin(), 0, 1, 1);
                        return;
                    }
                    return;
                }
            }
            int n2 = JOptionPane.showInternalOptionDialog(this, "Con cual formato de pagina desea imprimir?", "VERIFICACION", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))), botones, "Cancelar");
            if (n2 == 0) {
                Principal.clasefacturacion.imprimir_FacturayOrden(1, this.JTFFNFactura.getText(), String.valueOf(getXidingreso()), Principal.usuarioSistemaDTO.getLogin(), 0, 1, 0);
            } else if (n2 == 1) {
                Principal.clasefacturacion.imprimir_FacturayOrden(1, this.JTFFNFactura.getText(), String.valueOf(getXidingreso()), Principal.usuarioSistemaDTO.getLogin(), 0, 1, 1);
            }
        }
    }
}
