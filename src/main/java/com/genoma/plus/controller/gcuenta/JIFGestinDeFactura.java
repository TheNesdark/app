package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.FFacturaEvento;
import com.genoma.plus.jpa.entities.FFacturaEventoDetalle;
import com.genoma.plus.jpa.entities.LiquidacionEntity;
import com.genoma.plus.jpa.projection.GestionFacturaProjection;
import com.genoma.plus.jpa.service.EstadoAtencionService;
import com.genoma.plus.jpa.service.FFacturaEventoDetalleService;
import com.genoma.plus.jpa.service.FFacturaEventoService;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.genoma.plus.jpa.service.LlamadasService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: renamed from: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura, reason: invalid class name */
/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFGestiónDeFactura.class */
public class JIFGestinDeFactura extends JInternalFrame {
    private Object[] xdato;
    private String xsql;
    private boolean xlleno1;
    private boolean disponible;
    public DefaultTableModel xmodelo;
    public DefaultTableModel modcombos2;
    private clasesHistoriaCE xclaseHC;
    private JDRadicacion dRadicacion;
    private JDNotasElectronicas jDNotasElectronicas;
    private FFacturaEvento facturaEvento;
    private GestionFacturaProjection gestionFacturaProjection;
    private LiquidacionEntity liquidacionEntity;
    private FFacturaEventoDetalle fFacturaEventoDetalle;
    private List<FFacturaEvento> listFacturasVenta;
    private ButtonGroup JBGFiltro;
    private JButton JBTAdicionar1;
    private JButton JBTAdicionar2;
    private JDateChooser JDFechaEntrega;
    private JDateChooser JDFechaFac;
    private JDateChooser JDFechaRadicado;
    private JDateChooser JDFechaU;
    public JPanel JPDPersonales;
    private JFormattedTextField TxtLiquidacion;
    private JFormattedTextField TxtRadicacion;
    private JFormattedTextField txtCopago;
    private JFormattedTextField txtCuotaM;
    private JFormattedTextField txtDiasCartera;
    private JFormattedTextField txtEmpresa;
    public JTextFieldValidator txtNumeroFctura;
    public JTextFieldValidator txtObservacionR;
    private JFormattedTextField txtSaldo;
    private JFormattedTextField txtTotalDescuento;
    private JFormattedTextField txtTotalEps;
    private JFormattedTextField txtTotalServicio;
    private JFormattedTextField txtValorGlosa;
    private JFormattedTextField txtValorGlosaNoRecuperable;
    private JFormattedTextField txtValorGlosaRecuperable;
    private JFormattedTextField txtValorPago;
    private final Metodos xmt = new Metodos();
    private final LlamadasService llamadasService = (LlamadasService) Principal.contexto.getBean(LlamadasService.class);
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String profesional = "";
    private String consultorio = "";
    private String[][] xidprocedimiento = (String[][]) null;
    private boolean xlleno = false;
    private int estado = 0;
    private int xAplicaFiltroP = 0;
    private int render = 0;
    private int estado2 = 0;
    private Integer num = 0;
    private Integer estado_ = 0;
    private final EstadoAtencionService estadoAtencion = (EstadoAtencionService) Principal.contexto.getBean(EstadoAtencionService.class);
    AtomicBoolean EstadoTarea = new AtomicBoolean(true);
    private List<String> barcode = new ArrayList();
    private int contador = 0;
    private int cjuridico = 0;
    private String Nradicacion = "";
    private ILiquidacionService iLiquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
    private FFacturaEventoService fFacturaEventoService = (FFacturaEventoService) Principal.contexto.getBean(FFacturaEventoService.class);
    private FFacturaEventoDetalleService fFacturaEventoDetalleService = (FFacturaEventoDetalleService) Principal.contexto.getBean(FFacturaEventoDetalleService.class);

    public JIFGestinDeFactura() {
        initComponents();
        nuevo();
        ejecutarTareaTimer();
    }

    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JPDPersonales = new JPanel();
        this.txtNumeroFctura = new JTextFieldValidator();
        this.JDFechaFac = new JDateChooser();
        this.JDFechaEntrega = new JDateChooser();
        this.JDFechaRadicado = new JDateChooser();
        this.JDFechaU = new JDateChooser();
        this.JBTAdicionar1 = new JButton();
        this.txtTotalServicio = new JFormattedTextField();
        this.txtTotalDescuento = new JFormattedTextField();
        this.txtCuotaM = new JFormattedTextField();
        this.txtCopago = new JFormattedTextField();
        this.txtSaldo = new JFormattedTextField();
        this.txtValorPago = new JFormattedTextField();
        this.txtValorGlosa = new JFormattedTextField();
        this.txtValorGlosaRecuperable = new JFormattedTextField();
        this.txtValorGlosaNoRecuperable = new JFormattedTextField();
        this.JBTAdicionar2 = new JButton();
        this.txtTotalEps = new JFormattedTextField();
        this.TxtLiquidacion = new JFormattedTextField();
        this.TxtRadicacion = new JFormattedTextField();
        this.txtObservacionR = new JTextFieldValidator();
        this.txtEmpresa = new JFormattedTextField();
        this.txtDiasCartera = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("GESTIÓN DE FACTURA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(926, 583));
        setName("xJIFGestionDeFactura");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JIFGestinDeFactura.this.formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.2
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGestinDeFactura.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPDPersonales.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA ", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.txtNumeroFctura.setBorder(BorderFactory.createTitledBorder((Border) null, "No Factura.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNumeroFctura.setToolTipText("Número de Historia Clínica");
        this.txtNumeroFctura.setExprecionRegular("^[a-zA-ZñÑ0-9]*$");
        this.txtNumeroFctura.setFocusAccelerator('T');
        this.txtNumeroFctura.setFont(new Font("Arial", 1, 14));
        this.txtNumeroFctura.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.3
            public void focusGained(FocusEvent evt) {
                JIFGestinDeFactura.this.txtNumeroFcturaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFGestinDeFactura.this.txtNumeroFcturaFocusLost(evt);
            }
        });
        this.txtNumeroFctura.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.4
            public void keyPressed(KeyEvent evt) {
                JIFGestinDeFactura.this.txtNumeroFcturaKeyPressed(evt);
            }
        });
        this.JDFechaFac.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaFac.setDateFormatString("dd/MM/yyyy");
        this.JDFechaFac.setFont(new Font("Arial", 1, 12));
        this.JDFechaEntrega.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Entrega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaEntrega.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEntrega.setFont(new Font("Arial", 1, 12));
        this.JDFechaRadicado.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Radicado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaRadicado.setDateFormatString("dd/MM/yyyy");
        this.JDFechaRadicado.setFont(new Font("Arial", 1, 12));
        this.JDFechaU.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Upago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaU.setDateFormatString("dd/MM/yyyy");
        this.JDFechaU.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar1.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar1.setForeground(new Color(255, 0, 0));
        this.JBTAdicionar1.setText("RADICACION");
        this.JBTAdicionar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.5
            public void actionPerformed(ActionEvent evt) {
                JIFGestinDeFactura.this.JBTAdicionar1ActionPerformed(evt);
            }
        });
        this.txtTotalServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total Servicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalServicio.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotalServicio.setHorizontalAlignment(4);
        this.txtTotalServicio.setDisabledTextColor(new Color(0, 51, 153));
        this.txtTotalServicio.setEnabled(false);
        this.txtTotalServicio.setFont(new Font("Arial", 1, 18));
        this.txtTotalServicio.setValue(0);
        this.txtTotalDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Descuento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotalDescuento.setHorizontalAlignment(4);
        this.txtTotalDescuento.setDisabledTextColor(new Color(0, 51, 153));
        this.txtTotalDescuento.setEnabled(false);
        this.txtTotalDescuento.setFont(new Font("Arial", 1, 18));
        this.txtTotalDescuento.setValue(0);
        this.txtTotalDescuento.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestinDeFactura.this.txtTotalDescuentoPropertyChange(evt);
            }
        });
        this.txtCuotaM.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Cuota Moderadora", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCuotaM.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtCuotaM.setHorizontalAlignment(4);
        this.txtCuotaM.setDisabledTextColor(new Color(0, 51, 153));
        this.txtCuotaM.setEnabled(false);
        this.txtCuotaM.setFont(new Font("Arial", 1, 18));
        this.txtCuotaM.setValue(0);
        this.txtCuotaM.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestinDeFactura.this.txtCuotaMPropertyChange(evt);
            }
        });
        this.txtCopago.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Copago", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCopago.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtCopago.setHorizontalAlignment(4);
        this.txtCopago.setDisabledTextColor(new Color(0, 51, 153));
        this.txtCopago.setEnabled(false);
        this.txtCopago.setFont(new Font("Arial", 1, 18));
        this.txtCopago.setValue(0);
        this.txtCopago.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGestinDeFactura.this.txtCopagoPropertyChange(evt);
            }
        });
        this.txtSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtSaldo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtSaldo.setHorizontalAlignment(4);
        this.txtSaldo.setDisabledTextColor(new Color(0, 51, 153));
        this.txtSaldo.setEnabled(false);
        this.txtSaldo.setFont(new Font("Arial", 1, 18));
        this.txtSaldo.setValue(0);
        this.txtValorPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Pago", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorPago.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValorPago.setHorizontalAlignment(4);
        this.txtValorPago.setDisabledTextColor(new Color(0, 51, 153));
        this.txtValorPago.setEnabled(false);
        this.txtValorPago.setFont(new Font("Arial", 1, 18));
        this.txtValorPago.setValue(0);
        this.txtValorGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Glosa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorGlosa.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValorGlosa.setHorizontalAlignment(4);
        this.txtValorGlosa.setDisabledTextColor(new Color(0, 51, 153));
        this.txtValorGlosa.setEnabled(false);
        this.txtValorGlosa.setFont(new Font("Arial", 1, 18));
        this.txtValorGlosa.setValue(0);
        this.txtValorGlosaRecuperable.setBorder(BorderFactory.createTitledBorder((Border) null, "Glosa Recuperable", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorGlosaRecuperable.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValorGlosaRecuperable.setHorizontalAlignment(4);
        this.txtValorGlosaRecuperable.setDisabledTextColor(new Color(0, 51, 153));
        this.txtValorGlosaRecuperable.setEnabled(false);
        this.txtValorGlosaRecuperable.setFont(new Font("Arial", 1, 18));
        this.txtValorGlosaRecuperable.setValue(0);
        this.txtValorGlosaNoRecuperable.setBorder(BorderFactory.createTitledBorder((Border) null, "Glosa No Recuperable", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorGlosaNoRecuperable.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValorGlosaNoRecuperable.setHorizontalAlignment(4);
        this.txtValorGlosaNoRecuperable.setDisabledTextColor(new Color(0, 51, 153));
        this.txtValorGlosaNoRecuperable.setEnabled(false);
        this.txtValorGlosaNoRecuperable.setFont(new Font("Arial", 1, 18));
        this.txtValorGlosaNoRecuperable.setValue(0);
        this.JBTAdicionar2.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar2.setForeground(new Color(255, 0, 0));
        this.JBTAdicionar2.setText("NOTA ELECTRONICA");
        this.JBTAdicionar2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.9
            public void actionPerformed(ActionEvent evt) {
                JIFGestinDeFactura.this.JBTAdicionar2ActionPerformed(evt);
            }
        });
        this.txtTotalEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Eps o Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalEps.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotalEps.setHorizontalAlignment(4);
        this.txtTotalEps.setDisabledTextColor(new Color(0, 51, 153));
        this.txtTotalEps.setEnabled(false);
        this.txtTotalEps.setFont(new Font("Arial", 1, 18));
        this.txtTotalEps.setValue(0);
        this.TxtLiquidacion.setBorder(BorderFactory.createTitledBorder((Border) null, "IdLiquicacion", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.TxtLiquidacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.TxtLiquidacion.setHorizontalAlignment(4);
        this.TxtLiquidacion.setDisabledTextColor(new Color(0, 51, 153));
        this.TxtLiquidacion.setEnabled(false);
        this.TxtLiquidacion.setFont(new Font("Arial", 1, 18));
        this.TxtLiquidacion.setValue(0);
        this.TxtRadicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Radicacion", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.TxtRadicacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.TxtRadicacion.setHorizontalAlignment(4);
        this.TxtRadicacion.setDisabledTextColor(new Color(0, 51, 153));
        this.TxtRadicacion.setEnabled(false);
        this.TxtRadicacion.setFont(new Font("Arial", 1, 18));
        this.TxtRadicacion.setValue(0);
        this.txtObservacionR.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion Radicacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtObservacionR.setToolTipText("Número de Historia Clínica");
        this.txtObservacionR.setExprecionRegular("^[a-zA-ZñÑ0-9]*$");
        this.txtObservacionR.setFocusAccelerator('T');
        this.txtObservacionR.setFont(new Font("Arial", 1, 14));
        this.txtObservacionR.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.10
            public void focusGained(FocusEvent evt) {
                JIFGestinDeFactura.this.txtObservacionRFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFGestinDeFactura.this.txtObservacionRFocusLost(evt);
            }
        });
        this.txtObservacionR.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.11
            public void actionPerformed(ActionEvent evt) {
                JIFGestinDeFactura.this.txtObservacionRActionPerformed(evt);
            }
        });
        this.txtObservacionR.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura.12
            public void keyPressed(KeyEvent evt) {
                JIFGestinDeFactura.this.txtObservacionRKeyPressed(evt);
            }
        });
        this.txtEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtEmpresa.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtEmpresa.setHorizontalAlignment(4);
        this.txtEmpresa.setDisabledTextColor(new Color(0, 51, 153));
        this.txtEmpresa.setEnabled(false);
        this.txtEmpresa.setFont(new Font("Arial", 1, 18));
        this.txtEmpresa.setValue(0);
        this.txtDiasCartera.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias C", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtDiasCartera.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtDiasCartera.setHorizontalAlignment(4);
        this.txtDiasCartera.setDisabledTextColor(new Color(0, 51, 153));
        this.txtDiasCartera.setEnabled(false);
        this.txtDiasCartera.setFont(new Font("Arial", 1, 18));
        this.txtDiasCartera.setValue(0);
        GroupLayout JPDPersonalesLayout = new GroupLayout(this.JPDPersonales);
        this.JPDPersonales.setLayout(JPDPersonalesLayout);
        JPDPersonalesLayout.setHorizontalGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addGap(13, 13, 13).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.JBTAdicionar1, -2, 185, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar2, -2, 185, -2)).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.txtValorPago, -2, 185, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addComponent(this.txtValorGlosa, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorGlosaRecuperable, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtValorGlosaNoRecuperable, -2, 136, -2)).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.TxtRadicacion, -2, 247, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtDiasCartera, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaEntrega, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JDFechaRadicado, -2, -1, -2))).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDPersonalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JDFechaU, -2, -1, -2)).addGroup(JPDPersonalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.TxtLiquidacion, -2, 136, -2).addGap(0, 0, 32767))).addGap(12, 12, 12)).addGroup(JPDPersonalesLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.txtNumeroFctura, -2, 112, -2).addGap(12, 12, 12).addComponent(this.JDFechaFac, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtTotalServicio, -2, 136, -2).addGap(5, 5, 5).addComponent(this.txtTotalDescuento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCuotaM, -2, 184, -2).addGap(10, 10, 10))).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.txtCopago, -2, 156, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtTotalEps)).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.txtObservacionR, -2, 228, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtSaldo, -2, 150, -2)).addComponent(this.txtEmpresa, -2, 384, -2)))).addGap(10, 10, 10)));
        JPDPersonalesLayout.setVerticalGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addContainerGap().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtTotalServicio, -1, 52, 32767).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtTotalDescuento).addComponent(this.txtCuotaM)).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCopago).addComponent(this.txtTotalEps, -2, -1, -2)).addComponent(this.JDFechaFac, -1, 52, 32767).addComponent(this.txtNumeroFctura, -1, -1, 32767)).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaRadicado, -2, -1, -2).addComponent(this.JDFechaEntrega, -1, -1, 32767)).addComponent(this.txtDiasCartera).addComponent(this.TxtRadicacion)).addGap(12, 12, 12)).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtObservacionR, -2, 44, -2).addComponent(this.txtSaldo, -2, -1, -2)).addGap(18, 18, 18)))).addGroup(JPDPersonalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.TxtLiquidacion, -2, -1, -2).addGap(18, 18, 18))).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtValorPago, -2, -1, -2).addComponent(this.txtValorGlosa, -2, -1, -2).addComponent(this.txtValorGlosaRecuperable, -2, -1, -2).addComponent(this.txtValorGlosaNoRecuperable, -2, -1, -2)).addComponent(this.JDFechaU, -2, 0, 32767)).addComponent(this.txtEmpresa, -2, -1, -2)).addGap(10, 10, 10).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAdicionar1, -2, 47, -2).addComponent(this.JBTAdicionar2, -2, 47, -2)).addGap(20, 20, 20)));
        this.txtNumeroFctura.setFocusTraversalKeysEnabled(false);
        this.txtNumeroFctura.setFocusTraversalKeysEnabled(false);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDPersonales, -2, -1, -2).addContainerGap(8, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDPersonales, -2, -1, -2).addContainerGap(19, 32767)));
        getAccessibleContext().setAccessibleName("xJIFGestionDeFactura");
        pack();
    }

    private void buscaarPacientes(String documento) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.EstadoTarea.set(false);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        this.EstadoTarea.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumeroFcturaFocusGained(FocusEvent evt) {
        this.txtNumeroFctura.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumeroFcturaFocusLost(FocusEvent evt) {
    }

    public String getHistoria() {
        return this.txtNumeroFctura.getText();
    }

    public void nuevo() {
        this.txtNumeroFctura.setText("");
        this.JDFechaFac.setDate((Date) null);
        this.txtTotalEps.setValue(0);
        this.txtTotalServicio.setValue(0);
        this.txtTotalDescuento.setValue(0);
        this.txtCuotaM.setValue(0);
        this.txtCopago.setValue(0);
        this.txtSaldo.setValue(0);
        this.txtTotalDescuento.setValue(0);
        this.txtValorPago.setValue(0);
        this.txtValorGlosa.setValue(0);
        this.txtValorGlosaRecuperable.setValue(0);
        this.txtValorGlosaNoRecuperable.setValue(0);
        this.TxtLiquidacion.setText("");
        this.JDFechaRadicado.setDate((Date) null);
        this.JDFechaEntrega.setDate((Date) null);
        this.TxtRadicacion.setText("");
        this.txtObservacionR.setText("");
        this.JDFechaU.setDate((Date) null);
        this.txtEmpresa.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumeroFcturaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            String historiaText = this.txtNumeroFctura.getText();
            if (historiaText == null || historiaText.isEmpty()) {
                System.err.println("El campo txtHistoria está vacío o es null");
                return;
            }
            Optional<FFacturaEvento> facturaEventoOptional = this.fFacturaEventoService.findByPrefijoAndNoFacturaeventoM(this.txtNumeroFctura.getText());
            if (facturaEventoOptional.isPresent()) {
                this.facturaEvento = facturaEventoOptional.get();
                if (this.facturaEvento == null) {
                    System.err.println("Factura Evento es null");
                    return;
                }
                System.err.println("facturaEvento" + this.facturaEvento.getNoFacturaeventoM());
                if (this.facturaEvento.getFechaFacturaevento() == null || this.facturaEvento.getIdLiquidacion() == null) {
                    System.err.println("Datos de la factura incompletos");
                    return;
                }
                this.Nradicacion = this.facturaEvento.getNRadicado();
                this.JDFechaFac.setDate(new java.sql.Date(this.facturaEvento.getFechaFacturaevento().getTime()));
                if (this.facturaEvento.getIdLiquidacion() != null) {
                    this.txtTotalServicio.setValue(Double.valueOf(this.facturaEvento.getIdLiquidacion().getTotalServicio()));
                    this.txtTotalDescuento.setValue(Double.valueOf(this.facturaEvento.getIdLiquidacion().getTotalDescuento()));
                    this.txtCuotaM.setValue(Double.valueOf(this.facturaEvento.getIdLiquidacion().getCuotaModeradora()));
                    this.txtCopago.setValue(Double.valueOf(this.facturaEvento.getIdLiquidacion().getCopago()));
                    this.txtSaldo.setValue(Double.valueOf(this.facturaEvento.getIdLiquidacion().getTotalEps()));
                    this.TxtLiquidacion.setText(this.facturaEvento.getIdLiquidacion().getId().toString());
                    this.txtTotalEps.setValue(Double.valueOf(this.facturaEvento.getIdLiquidacion().getTotalEps()));
                    this.TxtRadicacion.setText(this.facturaEvento.getNRadicado());
                    if (this.facturaEvento.getFechaRadicado() != null && this.facturaEvento.getFechaEntrega() != null) {
                        this.JDFechaRadicado.setDate(new java.sql.Date(this.facturaEvento.getFechaRadicado().getTime()));
                        this.JDFechaEntrega.setDate(new java.sql.Date(this.facturaEvento.getFechaEntrega().getTime()));
                        this.txtObservacionR.setText(this.facturaEvento.getObservacionRad());
                        Optional<GestionFacturaProjection> gestionFacturaProjectionOptional = this.fFacturaEventoService.findByIdLiquidacionProjecion(Long.valueOf(historiaText));
                        if (gestionFacturaProjectionOptional.isPresent()) {
                            this.gestionFacturaProjection = gestionFacturaProjectionOptional.get();
                            this.txtSaldo.setValue(this.gestionFacturaProjection.getSaldo());
                            this.txtValorGlosa.setValue(this.gestionFacturaProjection.getVGlosa());
                            this.txtValorGlosaRecuperable.setValue(this.gestionFacturaProjection.getVGRecuperable());
                            this.txtValorGlosaNoRecuperable.setValue(this.gestionFacturaProjection.getVGAceptada());
                            this.txtValorPago.setValue(this.gestionFacturaProjection.getVPagado());
                            java.sql.Date fechaPago = (java.sql.Date) this.gestionFacturaProjection.getfechaPago();
                            if (fechaPago != null) {
                                this.JDFechaU.setDate(new java.sql.Date(fechaPago.getTime()));
                            } else {
                                System.err.println("Fecha de pago es null");
                            }
                        }
                        this.dRadicacion = new JDRadicacion(null, true, this, this.facturaEvento.getNRadicado(), new java.sql.Date(this.facturaEvento.getFechaFacturaevento().getTime()), new java.sql.Date(this.facturaEvento.getFechaRadicado().getTime()), "urlradicado", "CRad", 1, "NEtapaProceso", "IdLiquidacion");
                        return;
                    }
                    System.err.println("Fechas de radicado o entrega son null");
                    return;
                }
                System.err.println("IdLiquidacion es null");
                return;
            }
            nuevo();
            JOptionPane.showInputDialog(this, "En N° De Factura Erroneo", "VERIFICAR", 0);
            this.txtNumeroFctura.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar1ActionPerformed(ActionEvent evt) {
        if (this.Nradicacion != null) {
            this.dRadicacion.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "No hay factura para radicar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTotalDescuentoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCuotaMPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCopagoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar2ActionPerformed(ActionEvent evt) {
        this.jDNotasElectronicas = new JDNotasElectronicas(null, true, this, this.facturaEvento);
        this.jDNotasElectronicas.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtObservacionRFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtObservacionRFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtObservacionRActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtObservacionRKeyPressed(KeyEvent evt) {
    }

    private void ejecutarTareaTimer() {
    }

    private void llamar(String docuemtno) {
    }

    public void actualiza_estado(Integer estado) {
    }

    /* JADX INFO: renamed from: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura$ButtonRenderer */
    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFGestiónDeFactura$ButtonRenderer.class */
    private class ButtonRenderer implements TableCellRenderer {
        private ButtonRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton button = (JButton) value;
            return button;
        }
    }

    public void mCargarDatos() {
    }

    /* JADX INFO: renamed from: com.genoma.plus.controller.gcuenta.JIFGestiónDeFactura$MiRender */
    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFGestiónDeFactura$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 9) != null) {
                switch (Integer.valueOf(table.getValueAt(row, 9).toString()).intValue()) {
                    case 0:
                        cell.setBackground(new Color(0, 0, 102));
                        cell.setForeground(Color.WHITE);
                        break;
                    case 1:
                        cell.setBackground(new Color(177, 251, 177));
                        cell.setForeground(Color.BLACK);
                        break;
                    case 2:
                        cell.setBackground(new Color(103, 0, 103));
                        cell.setForeground(Color.WHITE);
                        break;
                    case 3:
                        cell.setBackground(new Color(177, 251, 177));
                        cell.setForeground(Color.BLACK);
                        break;
                    default:
                        cell.setBackground(Color.WHITE);
                        cell.setForeground(Color.BLACK);
                        break;
                }
            }
            return cell;
        }
    }

    private void cargarConsultorio() {
    }
}
