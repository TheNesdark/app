package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import co.com.genomaempresarial.ankara.dto.FacturacionRequest;
import co.com.genomaempresarial.ankara.dto.NotificacionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.jpa.entities.FacturaEquivalenteDTO;
import com.genoma.plus.jpa.entities.KFormapago;
import com.genoma.plus.jpa.entities.MCcFacturaInternaDetalle;
import com.genoma.plus.jpa.entities.MedioPago;
import com.genoma.plus.jpa.service.IKFormapagoService;
import com.genoma.plus.jpa.service.IMCcFacturaInternaService;
import com.genoma.plus.jpa.service.IMedioPagoService;
import com.genoma.plus.jpa.service.MCfacturaInternaService;
import com.genoma.plus.jpa.service.impl.MCcFacturaInternaServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JDGFacturaInternaNew.class */
public class JDGFacturaInternaNew extends JDialog {
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Object[] xdato;
    private int xnfila;
    private long xidc;
    private Integer xidr;
    private String xsql;
    private Integer xideEmpresa;
    private String[] xidresolucion;
    private List<String> reteIMpuestos;
    private final FacturaEquivalenteDTO facturaInterna;
    private final List<MCcFacturaInternaDetalle> detalle;
    private final MCfacturaInternaService cfacturaInternaService;
    private List<MedioPago> medioPagosList;
    private List<KFormapago> formaPagosLIst;
    private final IMedioPagoService iMedioPagoService;
    private final IKFormapagoService formaPagoService;
    private Integer xidMedio;
    private Integer xidforma;
    private MedioPago mp;
    private KFormapago fp;
    private final IMCcFacturaInternaService facturaInternaService;
    private String end_point;
    private JButton JBTAdicionar;
    private JButton JBTAnular;
    private JButton JBTAnular1;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JButton JBTenviar;
    private JComboBox JCBFormaPago;
    private JComboBox JCBMedioPafo;
    private JComboBox JCBResolucionDian;
    private JDateChooser JDFFecha;
    private JDateChooser JDFFechaPago;
    private JLabel JLBNFacturaI;
    private JLabel JLBNFacturaI1;
    private JPanel JPIDetalle;
    private JSpinner JSPCantidad;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JTable JTDetalle;
    private JTextField JTFConcepto;
    private JFormattedTextField JTFFVSTotal;
    private JFormattedTextField JTFFVTotal;
    private JFormattedTextField JTFFVUnitario;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;

    public JDGFacturaInternaNew(Frame parent, boolean modal, Integer idTercero, FacturaEquivalenteDTO facturaEquivalenteDTO) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xnfila = -1;
        this.xidc = 0L;
        this.xidr = 0;
        this.xideEmpresa = 0;
        this.reteIMpuestos = new ArrayList();
        this.xidMedio = 0;
        this.xidforma = 0;
        this.facturaInternaService = (IMCcFacturaInternaService) Principal.contexto.getBean(MCcFacturaInternaServiceImpl.class);
        this.end_point = Principal.informacionIps.getEndPointFacturaElectronica() + "/factura/";
        initComponents();
        this.cfacturaInternaService = (MCfacturaInternaService) Principal.contexto.getBean(MCfacturaInternaService.class);
        this.iMedioPagoService = (IMedioPagoService) Principal.contexto.getBean(IMedioPagoService.class);
        this.formaPagoService = (IKFormapagoService) Principal.contexto.getBean(IKFormapagoService.class);
        this.mp = new MedioPago();
        this.fp = new KFormapago();
        this.detalle = new ArrayList();
        this.medioPagosList = new ArrayList();
        this.formaPagosLIst = new ArrayList();
        mNuevo();
        this.JTFFVUnitario.setValue(facturaEquivalenteDTO.getValorUnitario());
        this.JTFConcepto.setText(facturaEquivalenteDTO.getConcepto());
        this.facturaInterna = facturaEquivalenteDTO;
        mBuscar();
        this.xideEmpresa = idTercero;
    }

    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDetalle = new JPanel();
        this.JTFConcepto = new JTextField();
        this.JSPCantidad = new JSpinner();
        this.JTFFVUnitario = new JFormattedTextField();
        this.JTFFVTotal = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTAdicionar = new JButton();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JTFFVSTotal = new JFormattedTextField();
        this.JDFFecha = new JDateChooser();
        this.JCBResolucionDian = new JComboBox();
        this.JDFFechaPago = new JDateChooser();
        this.JCBFormaPago = new JComboBox();
        this.JCBMedioPafo = new JComboBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JBTGrabar = new JButton();
        this.JBTAnular = new JButton();
        this.JBTSalir = new JButton();
        this.JLBNFacturaI1 = new JLabel();
        this.JBTAnular1 = new JButton();
        this.jPanel2 = new JPanel();
        this.JBTenviar = new JButton();
        this.JLBNFacturaI = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("FACTURA INTERNA");
        this.JPIDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS FACTURA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFConcepto.setFont(new Font("Arial", 1, 12));
        this.JTFConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCantidad.setFont(new Font("Arial", 1, 12));
        this.JSPCantidad.setModel(new SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(1.0d), (Comparable) null, Double.valueOf(1.0d)));
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCantidad.addChangeListener(new ChangeListener() { // from class: Contabilidad.JDGFacturaInternaNew.1
            public void stateChanged(ChangeEvent evt) {
                JDGFacturaInternaNew.this.JSPCantidadStateChanged(evt);
            }
        });
        this.JTFFVUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVUnitario.setHorizontalAlignment(4);
        this.JTFFVUnitario.setFont(new Font("Arial", 1, 14));
        this.JTFFVUnitario.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JDGFacturaInternaNew.2
            public void focusLost(FocusEvent evt) {
                JDGFacturaInternaNew.this.JTFFVUnitarioFocusLost(evt);
            }
        });
        this.JTFFVUnitario.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.3
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JTFFVUnitarioActionPerformed(evt);
            }
        });
        this.JTFFVTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVTotal.setHorizontalAlignment(4);
        this.JTFFVTotal.setFont(new Font("Arial", 1, 14));
        this.JTFFVTotal.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JDGFacturaInternaNew.4
            public void focusGained(FocusEvent evt) {
                JDGFacturaInternaNew.this.JTFFVTotalFocusGained(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JDGFacturaInternaNew.5
            public void keyPressed(KeyEvent evt) {
                JDGFacturaInternaNew.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.6
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JTFFVSTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVSTotal.setHorizontalAlignment(4);
        this.JTFFVSTotal.setFont(new Font("Arial", 1, 14));
        this.JDFFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFFecha.setFont(new Font("Arial", 1, 12));
        this.JCBResolucionDian.setFont(new Font("Arial", 1, 12));
        this.JCBResolucionDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Resolución DIAN", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBResolucionDian.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.7
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JCBResolucionDianActionPerformed(evt);
            }
        });
        this.JDFFechaPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaPago.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaPago.setFont(new Font("Arial", 1, 12));
        this.JCBFormaPago.setFont(new Font("Arial", 1, 12));
        this.JCBFormaPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFormaPago.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.8
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JCBFormaPagoActionPerformed(evt);
            }
        });
        this.JCBMedioPafo.setFont(new Font("Arial", 1, 12));
        this.JCBMedioPafo.setBorder(BorderFactory.createTitledBorder((Border) null, "Medio de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMedioPafo.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.9
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JCBMedioPafoActionPerformed(evt);
            }
        });
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addComponent(this.JBTAdicionar, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleLayout.createSequentialGroup().addComponent(this.JDFFecha, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFVSTotal, -2, 138, -2)).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JTFConcepto).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPCantidad, -2, 67, -2).addGap(18, 18, 18).addComponent(this.JTFFVUnitario, -2, 115, -2).addGap(18, 18, 18).addComponent(this.JTFFVTotal, -2, 115, -2)).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JCBResolucionDian, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBFormaPago, -2, 167, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMedioPafo, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaPago, -2, -1, -2))).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFVUnitario, -2, 0, 32767).addComponent(this.JTFFVTotal, -2, 0, 32767)).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFConcepto, -2, 50, -2).addComponent(this.JSPCantidad, -2, 49, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 42, -2).addGap(11, 11, 11).addComponent(this.JSPDetalle, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBResolucionDian, -2, 50, -2).addComponent(this.JCBFormaPago, -2, 50, -2).addComponent(this.JCBMedioPafo, -2, 50, -2)).addComponent(this.JDFFechaPago, -2, 50, -2)).addGap(13, 13, 13).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFecha, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFVSTotal, GroupLayout.Alignment.TRAILING, -1, 50, 32767).addComponent(this.JSPObservacion, GroupLayout.Alignment.TRAILING))).addContainerGap()));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.10
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTAnular.setFont(new Font("Arial", 1, 12));
        this.JBTAnular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.JBTAnular.setText("Anular");
        this.JBTAnular.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.11
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JBTAnularActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.12
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JLBNFacturaI1.setFont(new Font("Arial", 1, 24));
        this.JLBNFacturaI1.setHorizontalAlignment(0);
        this.JLBNFacturaI1.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.JBTAnular1.setFont(new Font("Arial", 1, 12));
        this.JBTAnular1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTAnular1.setText("Imprimir");
        this.JBTAnular1.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.13
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JBTAnular1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAnular1, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAnular, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTSalir, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNFacturaI1, -2, 128, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(17, 17, 17).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNFacturaI1, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAnular, -2, 50, -2).addComponent(this.JBTSalir, -2, 50, -2).addComponent(this.JBTAnular1, -2, 50, -2)).addComponent(this.JBTGrabar, -2, 50, -2)))).addGap(54, 54, 54)));
        this.jTabbedPane1.addTab("ACCIONES", this.jPanel1);
        this.JBTenviar.setFont(new Font("Arial", 1, 12));
        this.JBTenviar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/enviar.png")));
        this.JBTenviar.setText("Enviar Dian");
        this.JBTenviar.addActionListener(new ActionListener() { // from class: Contabilidad.JDGFacturaInternaNew.14
            public void actionPerformed(ActionEvent evt) {
                JDGFacturaInternaNew.this.JBTenviarActionPerformed(evt);
            }
        });
        this.JLBNFacturaI.setFont(new Font("Arial", 1, 24));
        this.JLBNFacturaI.setHorizontalAlignment(0);
        this.JLBNFacturaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JBTenviar, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 500, 32767).addComponent(this.JLBNFacturaI, -2, 110, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNFacturaI, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JBTenviar, -2, 50, -2).addGap(0, 0, 32767))).addContainerGap()));
        this.jTabbedPane1.addTab("ENVIOS", this.jPanel2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDetalle, -1, -1, 32767).addComponent(this.jTabbedPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDetalle, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -2, 125, -2).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JLBNFacturaI.getText().isEmpty()) {
            if (this.JTFConcepto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Concepto no puede estar eb blanco", "VERIFICAR", 1);
                this.JTFConcepto.requestFocus();
                return;
            }
            if (Double.valueOf(this.JTFFVUnitario.getValue().toString()).doubleValue() > 0.0d) {
                MCcFacturaInternaDetalle facturaInternaDetalle = new MCcFacturaInternaDetalle();
                this.xmodelo.addRow(this.xdato);
                this.xnfila++;
                this.xmodelo.setValueAt(this.JTFConcepto.getText(), this.xnfila, 0);
                this.xmodelo.setValueAt(this.JSPCantidad.getValue(), this.xnfila, 1);
                this.xmodelo.setValueAt(this.JTFFVUnitario.getValue(), this.xnfila, 2);
                this.xmodelo.setValueAt(this.JTFFVTotal.getValue(), this.xnfila, 3);
                mCalcularDatosTabla();
                facturaInternaDetalle.setCantidad(Double.valueOf(this.JSPCantidad.getValue().toString()).doubleValue());
                facturaInternaDetalle.setConcepto(this.JTFConcepto.getText());
                facturaInternaDetalle.setVUnitario(Double.valueOf(this.JTFFVUnitario.getValue().toString()).doubleValue());
                facturaInternaDetalle.setIdfacturainterna(this.facturaInterna);
                JD_ImpuestoG frmA = new JD_ImpuestoG(null, true, this.xideEmpresa, facturaInternaDetalle, Double.valueOf(this.JTFFVTotal.getValue().toString()), "facturaInterna", null);
                frmA.setLocationRelativeTo(this);
                frmA.setVisible(true);
                System.out.println("se paso a la otra ventana");
                this.detalle.add(facturaInternaDetalle);
                mNuevoConcepto();
                return;
            }
            JOptionPane.showMessageDialog(this, "Falta digitar valor unitario", "VERIFICAR", 1);
            this.JTFFVUnitario.requestFocus();
        }
    }

    private void mCargarC() {
        this.xidresolucion = this.xct.llenarCombo("SELECT  Id , Descripcion FROM cc_resolucion_dian WHERE Estado =1 AND clasificacion=5;", this.xidresolucion, this.JCBResolucionDian);
        this.xct.cerrarConexionBd();
    }

    private void cargarMedioPago() {
        this.medioPagosList = this.iMedioPagoService.listarMediosPagos();
        if (this.medioPagosList != null && !this.medioPagosList.isEmpty()) {
            this.medioPagosList.forEach(detalle -> {
                this.JCBMedioPafo.addItem(detalle.getNombre());
                this.JCBMedioPafo.setSelectedIndex(-1);
            });
        }
    }

    private void cargarFormaPago() {
        this.formaPagosLIst = this.formaPagoService.listarFormasPago();
        if (this.formaPagosLIst != null && !this.formaPagosLIst.isEmpty()) {
            this.formaPagosLIst.forEach(detalle -> {
                this.JCBFormaPago.addItem(detalle.getNombre());
                this.JCBFormaPago.setSelectedIndex(-1);
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCantidadStateChanged(ChangeEvent evt) {
        calculoValorTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVUnitarioFocusLost(FocusEvent evt) {
        calculoValorTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVUnitarioActionPerformed(ActionEvent evt) {
        calculoValorTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVTotalFocusGained(FocusEvent evt) {
        calculoValorTotal();
    }

    private void calculoValorTotal() throws NumberFormatException {
        if (this.JSPCantidad.getValue() != null && this.JTFFVUnitario.getValue() != null) {
            this.JTFFVTotal.setValue(Double.valueOf(Double.valueOf(this.JTFFVUnitario.getValue().toString()).doubleValue() * Double.valueOf(this.JSPCantidad.getValue().toString()).doubleValue()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (this.JLBNFacturaI.getText().isEmpty() && evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            System.out.println(evt.getKeyCode());
            int x = JOptionPane.showConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 3);
            if (x == 0) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                mCalcularDatosTabla();
                this.xnfila--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAnularActionPerformed(ActionEvent evt) {
        if (!this.JLBNFacturaI.getText().isEmpty() && this.xidc == 0) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3);
            if (x == 0) {
                this.xsql = "update cc_factura_interna set Estado=0 where Id='" + this.JLBNFacturaI.getText() + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                mNuevo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFormaPagoActionPerformed(ActionEvent evt) {
        if (this.JCBFormaPago.getSelectedItem() != null) {
            this.fp = this.formaPagoService.buscarPornombre(this.JCBFormaPago.getSelectedItem().toString());
            if (!this.fp.equals((Object) null)) {
                this.xidforma = this.fp.getId();
                System.out.println("el uide de la forma de pago es de " + this.xidforma);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMedioPafoActionPerformed(ActionEvent evt) {
        if (this.JCBMedioPafo.getSelectedItem() != null) {
            this.mp = this.iMedioPagoService.buscarPorNOmbre(this.JCBMedioPafo.getSelectedItem().toString());
            if (!this.mp.equals((Object) null)) {
                this.xidMedio = this.mp.getId();
                System.out.println("el ide del mdeio de pago es " + this.xidMedio);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBResolucionDianActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTenviarActionPerformed(ActionEvent evt) {
        try {
            FacturacionRequest factura = this.facturaInternaService.generarDocumentoSoporte(Long.valueOf(this.JLBNFacturaI.getText()));
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("entra a imprimir objetMapper");
            System.out.println(mapper.writeValueAsString(factura));
            new NotificacionResponse();
            RestTemplate restTemplate = new RestTemplate();
        } catch (JsonProcessingException | NumberFormatException | RestClientException e) {
            System.out.println(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAnular1ActionPerformed(ActionEvent evt) {
        if (!this.JLBNFacturaI.getText().isEmpty()) {
            Principal.xclase.mImprimirFacturaInterna(Long.valueOf(this.JLBNFacturaI.getText()), 0);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Concepto", "Cantidad", "V/Unitario", "V/Total"}) { // from class: Contabilidad.JDGFacturaInternaNew.15
            Class[] types = {String.class, Long.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mNuevo() {
        this.JTFConcepto.setText("");
        this.JSPCantidad.setValue(new Double(0.0d));
        this.JTFFVUnitario.setValue(new Double(0.0d));
        this.JTFFVTotal.setValue(new Double(0.0d));
        this.JTFFVSTotal.setValue(new Double(0.0d));
        this.JTAObservacion.setText("");
        this.JLBNFacturaI.setText("");
        this.JDFFecha.setDate(this.xmt.getFechaActual());
        this.JDFFechaPago.setDate(this.xmt.getFechaActual());
        mCargarC();
        cargarFormaPago();
        cargarMedioPago();
        mCrearModeloDatos();
    }

    private void mNuevoConcepto() {
        this.JTFConcepto.setText("");
        this.JSPCantidad.setValue(new Integer(1));
        this.JTFFVUnitario.setValue(new Double(0.0d));
        this.JTFFVTotal.setValue(new Double(0.0d));
    }

    private void mGrabar() {
        if (this.JLBNFacturaI.getText().isEmpty()) {
            if (this.xmodelo.getRowCount() != -1) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
                if (x == 0) {
                    try {
                        this.facturaInterna.setUsuarioSistema(Principal.usuarioSistemaDTO.getNombreUsuario());
                        this.facturaInterna.setIdResolucion(Integer.valueOf(this.xidresolucion[this.JCBResolucionDian.getSelectedIndex()]));
                        this.facturaInterna.setEstado(true);
                        this.facturaInterna.setFecha(new Date());
                        this.facturaInterna.setCantidad(Integer.valueOf(this.JSPCantidad.getValue().toString()));
                        this.facturaInterna.setFechaPago(this.JDFFechaPago.getDate());
                        this.facturaInterna.setIdMedioPago(this.xidMedio);
                        this.facturaInterna.setIdFormaPago(this.xidforma);
                        this.facturaInterna.setMCcFacturaInternaDetalleCollection(this.detalle);
                        ObjectMapper mapper = new ObjectMapper();
                        System.out.println("entra a imprimir objetMapper");
                        System.out.println(mapper.writeValueAsString(this.facturaInterna));
                        FacturaEquivalenteDTO mCcFacturaInterna = this.cfacturaInternaService.grabar(this.facturaInterna);
                        System.out.println("si grabo");
                        this.JLBNFacturaI.setText("" + mCcFacturaInterna.getId());
                        this.JLBNFacturaI1.setText("" + mCcFacturaInterna.getNumeroConsecutivo());
                        Principal.xclase.mImprimirFacturaInterna(Long.valueOf(this.JLBNFacturaI.getText()), 0);
                        return;
                    } catch (JsonProcessingException | NumberFormatException ex) {
                        Logger.getLogger(JDGFacturaInternaNew.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        return;
                    }
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Faltan adicionar concepto", "VERIFICAR", 1);
        }
    }

    private void mCalcularDatosTabla() {
        double xvalor = 0.0d;
        for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
            xvalor += Double.valueOf(this.xmodelo.getValueAt(y, 2).toString()).doubleValue() * Double.valueOf(this.xmodelo.getValueAt(y, 1).toString()).doubleValue();
        }
        this.JTFFVSTotal.setValue(Double.valueOf(xvalor));
    }

    private void mBuscar() {
        this.xsql = "SELECT `cc_factura_interna`.`Id` , `cc_factura_interna`.`FechaC`  , `cc_factura_interna_detalle`.`Concepto` , `cc_factura_interna_detalle`.`VUnitario`, (`cc_factura_interna_detalle`.`VUnitario`*`cc_factura_interna_detalle`.`Cantidad`) AS VTotal, `cc_factura_interna_detalle`.`Cantidad`,  concat(luc.Prefijo ,cc_factura_interna.NoConsecutivo) NoConsecutivo  FROM `cc_factura_interna_detalle`  INNER JOIN  `cc_factura_interna`  ON (`cc_factura_interna_detalle`.`idfacturainterna` = `cc_factura_interna`.`Id`)  inner join cc_resolucion_dian luc on (luc.Id=cc_factura_interna.idResolucion)  WHERE (`cc_factura_interna`.`Id_Radicacion` ='" + this.facturaInterna.getIdRadicacion() + "' AND `cc_factura_interna`.`Estado`=1)  ";
        System.out.println("buscar " + this.xsql);
        ResultSet xrs = this.xct.traerRs(this.xsql);
        mCrearModeloDatos();
        try {
            if (xrs.next()) {
                xrs.first();
                this.JLBNFacturaI.setText(xrs.getString(1));
                this.JLBNFacturaI1.setText(xrs.getString("NoConsecutivo"));
                this.JDFFecha.setDate(xrs.getDate(2));
                this.JTAObservacion.setText(xrs.getString(3));
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString("Concepto"), this.JTDetalle.getRowCount() - 1, 0);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Cantidad")), this.JTDetalle.getRowCount() - 1, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("VUnitario")), this.JTDetalle.getRowCount() - 1, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("VTotal")), this.JTDetalle.getRowCount() - 1, 3);
                    mCalcularDatosTabla();
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDGFacturaInternaNew.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
