package Contabilidad;

import Acceso.Principal;
import General.AccesoModulos;
import General.Anular;
import General.JDBiometrico;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.contabilidad.JDConsultarCuentasPagarProveedores;
import com.genoma.plus.controller.contabilidad.JDRegistroSoportes;
import com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal;
import com.genoma.plus.dao.contabilidad.ContabilidadDAO;
import com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.jpa.dto.EntradaRadicacionDTO;
import com.genoma.plus.jpa.entities.CcSolicitudReembolso;
import com.genoma.plus.jpa.gcuenta.GCuentaDAO;
import com.genoma.plus.jpa.projection.InformeSolicitudReembolso;
import com.genoma.plus.jpa.service.ISolicituReembolsoService;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFDocContable.class */
public class JIFDocContable extends JInternalFrame {
    private Metodos xmt;
    public DefaultTableModel xmodelo;
    private ConsultasMySQL xconsultas;
    private String[] xidnfactura;
    private String[][] xidtipodoccontable;
    private String[][] xidempresa;
    private String[][] xidauxiliar;
    public int xtipoc;
    public int xnfila;
    public int xtipopago;
    private long xcargarreembolsocm;
    private long xId_CCaja;
    private long xidradicacion;
    public int xtipo;
    public int xForma;
    public int xComodin;
    private Object[] xdato;
    private boolean xejecutado;
    private boolean xlleno;
    public boolean xGrabado;
    public boolean xTipo;
    private JIFBuscarDocumentosC xjibuscardocumento;
    private claseContabilidad xclases;
    private JIFConsultarDatosV xjifconsultard;
    private String xsql;
    private String xcc_detalle_documentoc;
    private String xcc_puc;
    private String xcc_documentoc;
    private String xNFactura;
    private List<Long> xIdReembolso;
    private long xConsecutivo;
    private JIFGC_Pagos_Grupal xjifpago;
    private JIFGeneracionPagos_Directo xjifpago_Directo;
    private GCuentaDAO gcuenta;
    private ContabilidadDAO contabilidadDAO;
    private Long cierreCaja;
    private final ISolicituReembolsoService solicituReembolsoService;
    private List<CcSolicitudReembolso> ccSolicitudReembolsos;
    private EntradaRadicacionDTO entrada;
    private JButton JBBuscaTercero;
    private ButtonGroup JBGTipo;
    private ButtonGroup JBGTipoP;
    private JButton JBTAdicionar;
    private JButton JBTCarguesA;
    private JButton JBTCarguesA1;
    private JButton JBTCarguesA2;
    private JButton JBTHuella;
    public JComboBox JCBAuxiliar;
    public JComboBox JCBTercero;
    public JComboBox JCBTipoC;
    private JCheckBox JCHIncluir;
    private JCheckBox JCHUtilizar;
    public JDateChooser JDFFechaC;
    private JLabel JLNo;
    private JPanel JPIDatosC;
    private JPanel JPIDatosP;
    private JPanel JPITipoPago;
    private JPanel JPI_UDatos1;
    private JPanel JPI_UDatos2;
    private JPanel JPTipo;
    private JRadioButton JRBCheque;
    private JRadioButton JRBCredito;
    public JRadioButton JRBDebito;
    private JRadioButton JRBNinguno;
    private JRadioButton JRBOtros;
    private JRadioButton JRBSDisfon;
    private JScrollPane JSPComentario;
    private JScrollPane JSPConceptC;
    private JScrollPane JSPDetalle;
    public JTextPane JTAComentario;
    private JTextPane JTAConceptoC;
    private JTabbedPane JTB_DatosU;
    public JTable JTDetalle;
    private JFormattedTextField JTFFDiferencia;
    public JFormattedTextField JTFFValor;
    private JFormattedTextField JTFFValorC;
    private JFormattedTextField JTFFValorD;
    private JTextField JTFNCheque;
    private JTextField JTFNCuenta;
    private JTextField JTFRuta;
    private JTextField JTF_NComprobante;
    public JTextField JTF_NFactura;

    public JIFDocContable(claseContabilidad xclase) {
        this(xclase, null, null, 0, false, null);
    }

    public JIFDocContable(claseContabilidad xclase, JIFGC_Pagos_Grupal xjifpago) {
        this(xclase, xjifpago, null, 0, true, null);
    }

    public JIFDocContable(claseContabilidad xclase, JIFGeneracionPagos_Directo xjifpagoDirecto, int xTipo) {
        this(xclase, null, xjifpagoDirecto, xTipo, false, null);
    }

    public JIFDocContable(claseContabilidad xclase, EntradaRadicacionDTO entrada) {
        this(xclase, null, null, 0, false, entrada);
    }

    private JIFDocContable(claseContabilidad xclase, JIFGC_Pagos_Grupal jifPago, JIFGeneracionPagos_Directo jifPagoDirecto, int forma, boolean esPagoGrupal, EntradaRadicacionDTO entrada) {
        this.xmt = new Metodos();
        this.xconsultas = new ConsultasMySQL();
        this.xtipoc = 1;
        this.xnfila = -1;
        this.xtipopago = -1;
        this.xcargarreembolsocm = 0L;
        this.xId_CCaja = 0L;
        this.xidradicacion = 0L;
        this.xtipo = -1;
        this.xForma = -1;
        this.xComodin = 0;
        this.xejecutado = false;
        this.xlleno = false;
        this.xGrabado = false;
        this.xTipo = false;
        this.xNFactura = "0";
        this.xIdReembolso = new ArrayList();
        this.cierreCaja = 0L;
        this.solicituReembolsoService = (ISolicituReembolsoService) Principal.contexto.getBean(ISolicituReembolsoService.class);
        initComponents();
        this.xclases = xclase;
        this.xjifpago = jifPago;
        this.xjifpago_Directo = jifPagoDirecto;
        this.xForma = forma;
        this.xTipo = esPagoGrupal;
        this.entrada = entrada;
        inicializarTablasNiif();
        springStart();
        mNuevo();
        if (this.xjifpago != null) {
            mCargarInformacion_Cartera();
        }
        if (this.xjifpago_Directo != null) {
            mCargarInformacion_CPagoDirecto();
        }
        cargarInfoRadicacion();
    }

    /* JADX WARN: Type inference failed for: r3v111, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JBGTipoP = new ButtonGroup();
        this.JPIDatosP = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JCBTipoC = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JSPConceptC = new JScrollPane();
        this.JTAConceptoC = new JTextPane();
        this.JTF_NComprobante = new JTextField();
        this.JTF_NFactura = new JTextField();
        this.JLNo = new JLabel();
        this.JBBuscaTercero = new JButton();
        this.JPIDatosC = new JPanel();
        this.JTFNCuenta = new JTextField();
        this.JPTipo = new JPanel();
        this.JRBCredito = new JRadioButton();
        this.JRBDebito = new JRadioButton();
        this.JTFFValor = new JFormattedTextField();
        this.JBTAdicionar = new JButton();
        this.JSPComentario = new JScrollPane();
        this.JTAComentario = new JTextPane();
        this.JCBAuxiliar = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTB_DatosU = new JTabbedPane();
        this.JPI_UDatos1 = new JPanel();
        this.JPITipoPago = new JPanel();
        this.JRBNinguno = new JRadioButton();
        this.JRBSDisfon = new JRadioButton();
        this.JRBCheque = new JRadioButton();
        this.JRBOtros = new JRadioButton();
        this.JTFNCheque = new JTextField();
        this.JCHIncluir = new JCheckBox();
        this.JCHUtilizar = new JCheckBox();
        this.JTFFDiferencia = new JFormattedTextField();
        this.JTFFValorD = new JFormattedTextField();
        this.JTFFValorC = new JFormattedTextField();
        this.JPI_UDatos2 = new JPanel();
        this.JBTCarguesA1 = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTCarguesA = new JButton();
        this.JBTHuella = new JButton();
        this.JBTCarguesA2 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("DOCUMENTO CONTABLE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifdocumentoc");
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFDocContable.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFDocContable.this.formInternalFrameClosing(evt);
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
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ENCABEZADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JDFFechaC.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.2
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JDFFechaCKeyPressed(evt);
            }
        });
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.addItemListener(new ItemListener() { // from class: Contabilidad.JIFDocContable.3
            public void itemStateChanged(ItemEvent evt) {
                JIFDocContable.this.JCBTipoCItemStateChanged(evt);
            }
        });
        this.JCBTipoC.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.4
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JCBTipoCKeyPressed(evt);
            }
        });
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFDocContable.5
            public void mouseClicked(MouseEvent evt) {
                JIFDocContable.this.JCBTerceroMouseClicked(evt);
            }
        });
        this.JCBTercero.addItemListener(new ItemListener() { // from class: Contabilidad.JIFDocContable.6
            public void itemStateChanged(ItemEvent evt) {
                JIFDocContable.this.JCBTerceroItemStateChanged(evt);
            }
        });
        this.JCBTercero.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.7
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JCBTerceroKeyPressed(evt);
            }
        });
        this.JSPConceptC.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAConceptoC.setFont(new Font("Arial", 1, 12));
        this.JTAConceptoC.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.8
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JTAConceptoCKeyPressed(evt);
            }
        });
        this.JSPConceptC.setViewportView(this.JTAConceptoC);
        this.JTF_NComprobante.setFont(new Font("Arial", 1, 12));
        this.JTF_NComprobante.setHorizontalAlignment(0);
        this.JTF_NComprobante.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NFactura.setFont(new Font("Arial", 1, 12));
        this.JTF_NFactura.setHorizontalAlignment(0);
        this.JTF_NFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NFactura.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFDocContable.9
            public void mouseClicked(MouseEvent evt) {
                JIFDocContable.this.JTF_NFacturaMouseClicked(evt);
            }
        });
        this.JTF_NFactura.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.10
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JTF_NFacturaKeyPressed(evt);
            }
        });
        this.JLNo.setFont(new Font("Arial", 1, 12));
        this.JLNo.setForeground(Color.red);
        this.JLNo.setHorizontalAlignment(4);
        this.JLNo.setText("0");
        this.JLNo.setBorder(BorderFactory.createTitledBorder((Border) null, "No", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.11
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JSPConceptC, -2, 613, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_NFactura, -2, 139, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 121, -2).addGap(6, 6, 6).addComponent(this.JCBTipoC, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTercero, -2, 339, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscaTercero, -2, 58, -2))).addGap(18, 18, 18).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTF_NComprobante).addComponent(this.JLNo, -1, -1, 32767)).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaC, -2, 50, -2).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JCBTercero, -2, 50, -2)).addComponent(this.JBBuscaTercero, -2, 50, -2))).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JLNo, -2, 50, -2))).addGap(10, 10, 10).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPConceptC, -2, 56, -2).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JTF_NFactura, -2, 50, -2)).addComponent(this.JTF_NComprobante, -2, 50, -2))).addContainerGap(-1, 32767)));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CUENTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNCuenta.setFont(new Font("Arial", 1, 13));
        this.JTFNCuenta.setHorizontalAlignment(2);
        this.JTFNCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCuenta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFDocContable.12
            public void mouseClicked(MouseEvent evt) {
                JIFDocContable.this.JTFNCuentaMouseClicked(evt);
            }
        });
        this.JTFNCuenta.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.13
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JTFNCuentaActionPerformed(evt);
            }
        });
        this.JTFNCuenta.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.14
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JTFNCuentaKeyPressed(evt);
            }
        });
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipo.add(this.JRBCredito);
        this.JRBCredito.setFont(new Font("Arial", 1, 11));
        this.JRBCredito.setSelected(true);
        this.JRBCredito.setText("Crédito");
        this.JRBCredito.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.15
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JRBCreditoActionPerformed(evt);
            }
        });
        this.JRBCredito.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.16
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JRBCreditoKeyPressed(evt);
            }
        });
        this.JBGTipo.add(this.JRBDebito);
        this.JRBDebito.setFont(new Font("Arial", 1, 11));
        this.JRBDebito.setText("Débito");
        this.JRBDebito.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.17
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JRBDebitoActionPerformed(evt);
            }
        });
        this.JRBDebito.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.18
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JRBDebitoKeyPressed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBCredito).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDebito)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDebito).addComponent(this.JRBCredito)).addContainerGap(-1, 32767)));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setDoubleBuffered(true);
        this.JTFFValor.setFont(new Font("Arial", 1, 13));
        this.JTFFValor.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.19
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JTFFValorKeyPressed(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.20
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTAdicionar.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.21
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JBTAdicionarKeyPressed(evt);
            }
        });
        this.JSPComentario.setBorder(BorderFactory.createTitledBorder((Border) null, "Comentario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAComentario.setFont(new Font("Arial", 1, 12));
        this.JTAComentario.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.22
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JTAComentarioKeyPressed(evt);
            }
        });
        this.JSPComentario.setViewportView(this.JTAComentario);
        this.JCBAuxiliar.setFont(new Font("Arial", 1, 12));
        this.JCBAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAuxiliar.addItemListener(new ItemListener() { // from class: Contabilidad.JIFDocContable.23
            public void itemStateChanged(ItemEvent evt) {
                JIFDocContable.this.JCBAuxiliarItemStateChanged(evt);
            }
        });
        this.JCBAuxiliar.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.24
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JCBAuxiliarKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPComentario).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCBAuxiliar, -2, 152, -2).addGap(18, 18, 18).addComponent(this.JTFNCuenta, -2, 444, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValor, -2, 123, -2)).addComponent(this.JBTAdicionar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPTipo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNCuenta, -2, 50, -2).addComponent(this.JCBAuxiliar)).addComponent(this.JTFFValor)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPComentario, -2, 56, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 38, -2).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFDocContable.25
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDocContable.this.JTDetallePropertyChange(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFDocContable.26
            public void keyPressed(KeyEvent evt) {
                JIFDocContable.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTB_DatosU.setForeground(new Color(0, 103, 0));
        this.JTB_DatosU.setFont(new Font("Arial", 1, 14));
        this.JPITipoPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipoP.add(this.JRBNinguno);
        this.JRBNinguno.setFont(new Font("Arial", 1, 12));
        this.JRBNinguno.setSelected(true);
        this.JRBNinguno.setText("Ninguno");
        this.JRBNinguno.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.27
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JRBNingunoActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBSDisfon);
        this.JRBSDisfon.setFont(new Font("Arial", 1, 12));
        this.JRBSDisfon.setText("Disfon");
        this.JRBSDisfon.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.28
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JRBSDisfonActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBCheque);
        this.JRBCheque.setFont(new Font("Arial", 1, 12));
        this.JRBCheque.setText("Cheque");
        this.JRBCheque.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.29
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JRBChequeActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBOtros);
        this.JRBOtros.setFont(new Font("Arial", 1, 12));
        this.JRBOtros.setText("Otro");
        this.JRBOtros.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.30
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JRBOtrosActionPerformed(evt);
            }
        });
        this.JTFNCheque.setEditable(false);
        this.JTFNCheque.setFont(new Font("Arial", 1, 13));
        this.JTFNCheque.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cheque", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCheque.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFDocContable.31
            public void focusLost(FocusEvent evt) {
                JIFDocContable.this.JTFNChequeFocusLost(evt);
            }
        });
        this.JCHIncluir.setFont(new Font("Arial", 1, 12));
        this.JCHIncluir.setText("Incluir \"DE\"");
        this.JCHIncluir.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.32
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JCHIncluirActionPerformed(evt);
            }
        });
        this.JCHUtilizar.setFont(new Font("Arial", 1, 12));
        this.JCHUtilizar.setText("Utilizar valor Credito?");
        GroupLayout JPITipoPagoLayout = new GroupLayout(this.JPITipoPago);
        this.JPITipoPago.setLayout(JPITipoPagoLayout);
        JPITipoPagoLayout.setHorizontalGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPagoLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPagoLayout.createSequentialGroup().addComponent(this.JRBNinguno).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBCheque).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBOtros).addGap(18, 18, 18).addComponent(this.JTFNCheque, -2, 117, -2).addContainerGap(-1, 32767)).addGroup(JPITipoPagoLayout.createSequentialGroup().addComponent(this.JRBSDisfon).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHIncluir).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHUtilizar).addGap(14, 14, 14)))));
        JPITipoPagoLayout.setVerticalGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPagoLayout.createSequentialGroup().addGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCheque).addComponent(this.JRBOtros).addComponent(this.JRBNinguno)).addComponent(this.JTFNCheque, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHIncluir).addComponent(this.JCHUtilizar).addComponent(this.JRBSDisfon)).addContainerGap(-1, 32767)));
        this.JTFFDiferencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Diferencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDiferencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFDiferencia.setHorizontalAlignment(4);
        this.JTFFDiferencia.setFont(new Font("Arial", 1, 13));
        this.JTFFValorD.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValorD.setHorizontalAlignment(4);
        this.JTFFValorD.setFont(new Font("Arial", 1, 13));
        this.JTFFValorC.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorC.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValorC.setHorizontalAlignment(4);
        this.JTFFValorC.setFont(new Font("Arial", 1, 13));
        GroupLayout JPI_UDatos1Layout = new GroupLayout(this.JPI_UDatos1);
        this.JPI_UDatos1.setLayout(JPI_UDatos1Layout);
        JPI_UDatos1Layout.setHorizontalGroup(JPI_UDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UDatos1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPITipoPago, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 246, 32767).addGroup(JPI_UDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_UDatos1Layout.createSequentialGroup().addComponent(this.JTFFValorD, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JTFFValorC, -2, 120, -2)).addGroup(JPI_UDatos1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JTFFDiferencia))).addGap(17, 17, 17)));
        JPI_UDatos1Layout.setVerticalGroup(JPI_UDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UDatos1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_UDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UDatos1Layout.createSequentialGroup().addGroup(JPI_UDatos1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorD).addComponent(this.JTFFValorC)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFDiferencia, -2, 46, -2)).addComponent(this.JPITipoPago, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JTB_DatosU.addTab("DATOS", this.JPI_UDatos1);
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCarguesA1.setText("Exportar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.33
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFDocContable.34
            public void mouseClicked(MouseEvent evt) {
                JIFDocContable.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCarguesA.setText("Cargar Información");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.35
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JBTCarguesAActionPerformed(evt);
            }
        });
        this.JBTHuella.setFont(new Font("Arial", 1, 12));
        this.JBTHuella.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.JBTHuella.setToolTipText("Registro Biometrico");
        this.JBTHuella.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.36
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JBTHuellaActionPerformed(evt);
            }
        });
        this.JBTCarguesA2.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBTCarguesA2.setText("Cargar Soporte PDF");
        this.JBTCarguesA2.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDocContable.37
            public void actionPerformed(ActionEvent evt) {
                JIFDocContable.this.JBTCarguesA2ActionPerformed(evt);
            }
        });
        GroupLayout JPI_UDatos2Layout = new GroupLayout(this.JPI_UDatos2);
        this.JPI_UDatos2.setLayout(JPI_UDatos2Layout);
        JPI_UDatos2Layout.setHorizontalGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UDatos2Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JTFRuta, -2, 260, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCarguesA1, -2, 171, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTHuella, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCarguesA, -2, 219, -2).addGap(18, 18, 18).addComponent(this.JBTCarguesA2, -2, 163, 32767).addContainerGap()));
        JPI_UDatos2Layout.setVerticalGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UDatos2Layout.createSequentialGroup().addGap(26, 26, 26).addGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTHuella, -2, 50, -2).addGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCarguesA, -2, 50, -2).addComponent(this.JBTCarguesA2, -2, 50, -2)).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTCarguesA1, -2, 50, -2)).addContainerGap(29, 32767)));
        this.JTB_DatosU.addTab("UTILIDADES", this.JPI_UDatos2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDatosP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JSPDetalle, -2, 933, -2).addGap(0, 0, 32767)).addComponent(this.JTB_DatosU, GroupLayout.Alignment.TRAILING))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosC, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 203, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_DatosU, -2, 151, -2).addGap(17, 17, 17)));
        this.JPIDatosP.getAccessibleContext().setAccessibleName("ENCABEZADO");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCreditoActionPerformed(ActionEvent evt) {
        this.xtipoc = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDebitoActionPerformed(ActionEvent evt) {
        this.xtipoc = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCuentaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            Principal.xclase.cargarPantalla("Buscar Puc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mAdicionarTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (this.JLNo.getText().equals("0")) {
            if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (this.JLNo.getText().equals("0")) {
                        this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                        this.xnfila--;
                        mSumarValores();
                        this.JTFNCuenta.requestFocus();
                        return;
                    }
                    this.xsql = "delete from " + this.xcc_detalle_documentoc + " where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13) + "'";
                    this.xconsultas.ejecutarSQL(this.xsql);
                    this.xconsultas.cerrarConexionBd();
                    this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                    this.xnfila--;
                    mSumarValores();
                    this.JTFNCuenta.requestFocus();
                    return;
                }
                return;
            }
            return;
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 1 && evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            int x2 = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x2 == 0) {
                this.xsql = "delete from " + this.xcc_detalle_documentoc + " where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13) + "'";
                this.xconsultas.ejecutarSQL(this.xsql);
                this.xconsultas.cerrarConexionBd();
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                this.xnfila--;
                mSumarValores();
                this.JTFNCuenta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesAActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            Object[] botones = {"Caja", "Caja Menor", "Nomina", "Ventas", "Cerrar"};
            mCrearTablaDetalle();
            int n = JOptionPane.showInternalOptionDialog(this, "Que información desea cargar?", "CARGAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                JDCargarInformacionVentas xjidcargue = new JDCargarInformacionVentas(this.xclases.frmPrincipal, true, this, "CIERRE CAJA");
                xjidcargue.setLocationRelativeTo(this.xclases.frmPrincipal);
                xjidcargue.setVisible(true);
                return;
            }
            if (n == 1) {
                new AccesoModulos(null, true, "MODULO DE CAJA MENOR", "Caja Menor", "cajam", Principal.xclase.frmPrincipal);
                this.xjifconsultard = new JIFConsultarDatosV(this);
                Principal.cargarPantalla(this.xjifconsultard);
                return;
            } else if (n == 2) {
                JDCargarInformacionC xjidcargue2 = new JDCargarInformacionC(this.xclases.frmPrincipal, true, this);
                xjidcargue2.setLocationRelativeTo(this.xclases.frmPrincipal);
                xjidcargue2.setVisible(true);
                return;
            } else {
                if (n == 3) {
                    JDCargarInformacionVentas xjidcargue3 = new JDCargarInformacionVentas(this.xclases.frmPrincipal, true, this, "VENTAS");
                    xjidcargue3.setLocationRelativeTo(this.xclases.frmPrincipal);
                    xjidcargue3.setVisible(true);
                    return;
                }
                return;
            }
        }
        Object[] botones2 = {"Caja", "Caja Menor", "Información Plantilla", "Cerrar"};
        mCrearTablaDetalle();
        switch (JOptionPane.showInternalOptionDialog(this, "Que información desea cargar?", "CARGAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar")) {
            case 0:
                JDCargarInformacionVentas xjidcargue4 = new JDCargarInformacionVentas(this.xclases.frmPrincipal, true, this, "CIERRE CAJA");
                xjidcargue4.setLocationRelativeTo(this.xclases.frmPrincipal);
                xjidcargue4.setVisible(true);
                break;
            case 1:
                new AccesoModulos(null, true, "MODULO DE CAJA MENOR", "Caja Menor", "cajam", Principal.xclase.frmPrincipal);
                this.xjifconsultard = new JIFConsultarDatosV(this);
                Principal.cargarPantalla(this.xjifconsultard);
                break;
            case 2:
                JDCargarInformacionC xjidcargue5 = new JDCargarInformacionC(this.xclases.frmPrincipal, true, this);
                xjidcargue5.setLocationRelativeTo(this.xclases.frmPrincipal);
                xjidcargue5.setVisible(true);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSDisfonActionPerformed(ActionEvent evt) {
        this.xtipopago = 0;
        this.JTFNCheque.setText("");
        this.JTFNCheque.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBChequeActionPerformed(ActionEvent evt) {
        this.xtipopago = 1;
        if (this.JLNo.getText().equals("0")) {
            this.JTFNCheque.setText("" + this.xclases.mNumeroChequeGenerar());
            this.JTFNCheque.setEditable(true);
            this.JTFNCheque.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOtrosActionPerformed(ActionEvent evt) {
        this.xtipopago = 2;
        this.JTFNCheque.setText("");
        this.JTFNCheque.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNChequeFocusLost(FocusEvent evt) {
        if (!this.JTFNCheque.getText().isEmpty()) {
            String sql = "update cc_documentoc set NCheque='" + this.JTFNCheque.getText() + "' where Id='" + this.JLNo.getText() + "'";
            this.xconsultas.ejecutarSQL(sql);
            this.xconsultas.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle() + " - " + this.JCBTipoC.getSelectedItem() + " No. : " + this.JTF_NComprobante.getText() + "         No Interno: " + this.JLNo.getText());
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCuentaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNingunoActionPerformed(ActionEvent evt) {
        this.xtipopago = -1;
        this.JTFNCheque.setText("");
        this.JTFNCheque.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroItemStateChanged(ItemEvent evt) {
        if (!this.xlleno || this.JCBTercero.getSelectedIndex() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHIncluirActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAuxiliarItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBAuxiliar.getSelectedIndex() != -1) {
            this.JTFNCuenta.setText(this.xidauxiliar[this.JCBAuxiliar.getSelectedIndex()][1]);
            if (this.xidauxiliar[this.JCBAuxiliar.getSelectedIndex()][2].equals("0")) {
                this.xtipoc = 0;
                this.JRBDebito.setSelected(true);
            } else {
                this.xtipoc = 1;
                this.JRBCredito.setSelected(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaCKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoC.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAConceptoCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTAConceptoC.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAuxiliarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBAuxiliar.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCuentaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCuenta.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFValor.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAComentarioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTAComentario.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAdicionarTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTercero.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCreditoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBCredito.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDebitoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JRBDebito.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea crear un tercero?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.claseparametrizacionn.cargarPantalla("Empresa", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoC.getSelectedIndex() != -1) {
            mConcecutivo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mSumarValores();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NFacturaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTF_NFactura.getText().equals("0") && this.JCBTercero.getSelectedIndex() != -1) {
            List<Object[]> list = this.contabilidadDAO.facturaPorPagar(this.JTF_NFactura.getText(), this.xidempresa[this.JCBTercero.getSelectedIndex()][0]);
            if (!list.isEmpty()) {
                for (int x = 0; x < list.size(); x++) {
                    this.JTAComentario.setText(list.get(x)[6].toString());
                    this.JCBAuxiliar.setSelectedItem(list.get(x)[2].toString());
                    this.JTFFValor.setValue(list.get(x)[4]);
                    this.JRBDebito.setSelected(true);
                    this.xtipoc = 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NFacturaMouseClicked(MouseEvent evt) {
        if (this.JCBTercero.getSelectedIndex() != -1) {
            JDConsultarCuentasPagarProveedores e = new JDConsultarCuentasPagarProveedores(null, true, this.xidempresa[this.JCBTercero.getSelectedIndex()][0]);
            e.setLocationRelativeTo(this);
            e.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTHuellaActionPerformed(ActionEvent evt) {
        if (!this.JLNo.getText().equals("0")) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, "jifdocumentoc", this.JLNo.getText());
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un registro del Historico", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA2ActionPerformed(ActionEvent evt) {
        if (!this.JLNo.getText().isEmpty()) {
            JDRegistroSoportes registroSoportes = new JDRegistroSoportes(null, true, this.JLNo.getText());
            registroSoportes.setLocationRelativeTo(this);
            registroSoportes.setVisible(true);
        }
    }

    private void mAdicionarTabla() {
        if (this.JCBTercero.getSelectedIndex() != -1) {
            try {
            } catch (Exception e) {
                System.err.println("Componente Invalido para ese OptionPane, se procede a probar con otro.");
            } finally {
                JOptionPane.showMessageDialog(this, "Cuenta auxiliar no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            if (this.JCBAuxiliar.getSelectedIndex() != -1) {
                try {
                } catch (Exception e2) {
                    System.err.println("Componente Invalido para ese OptionPane, se procede a probar con otro.");
                } finally {
                    JOptionPane.showMessageDialog(this, "Valor no pueder ser cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
                if (Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue() != 0.0d) {
                    this.xnfila = this.JTDetalle.getRowCount();
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(this.JCBAuxiliar.getSelectedItem(), this.xnfila, 0);
                    this.xmodelo.setValueAt(this.JTFNCuenta.getText(), this.xnfila, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(this.xtipoc), this.xnfila, 2);
                    if (this.xtipoc == 1) {
                        this.xmodelo.setValueAt(this.JTFFValor.getValue(), this.xnfila, 4);
                        this.xmodelo.setValueAt(new Double(0.0d), this.xnfila, 3);
                    } else {
                        this.xmodelo.setValueAt(new Double(0.0d), this.xnfila, 4);
                        this.xmodelo.setValueAt(this.JTFFValor.getValue(), this.xnfila, 3);
                    }
                    this.xmodelo.setValueAt(this.xidempresa[this.JCBTercero.getSelectedIndex()][0], this.xnfila, 6);
                    this.xmodelo.setValueAt(this.JCBTercero.getSelectedItem().toString(), this.xnfila, 7);
                    this.xmodelo.setValueAt(Long.valueOf(this.xidradicacion), this.xnfila, 8);
                    this.xmodelo.setValueAt(new Double(0.0d), this.xnfila, 5);
                    this.xmodelo.setValueAt(this.JTAComentario.getText(), this.xnfila, 9);
                    this.xmodelo.setValueAt(new Long(0L), this.xnfila, 10);
                    this.xmodelo.setValueAt(new Long(0L), this.xnfila, 11);
                    this.xmodelo.setValueAt(this.JTF_NFactura.getText(), this.xnfila, 12);
                    this.xmodelo.setValueAt(false, this.xnfila, 14);
                    this.xmodelo.setValueAt(0, this.xnfila, 13);
                    mLimpiarD();
                    mSumarValores();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Valor no pueder ser cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFValor.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Cuenta auxiliar no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBAuxiliar.requestFocus();
            return;
        }
        try {
            try {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } catch (Throwable th) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                throw th;
            }
        } catch (Exception e3) {
            System.err.println("Componente Invalido para ese OptionPane, se procede a probar con otro.");
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        this.JCBTercero.requestFocus();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.gcuenta = (GCuentaDAOImpl) classPathXmlApplicationContext.getBean("gCuentaDAOImpl");
        this.contabilidadDAO = (ContabilidadDAOImpl) classPathXmlApplicationContext.getBean("contabilidadDAOImpl");
    }

    private void mCargarInformacion_Cartera() {
        this.xnfila = 0;
        int xpos = 0;
        for (int x = 0; x < this.xjifpago.JTDetalleS.getRowCount(); x++) {
            if (Boolean.valueOf(this.xjifpago.xModelo.getValueAt(x, 22).toString()).booleanValue()) {
                if (Principal.informacionIps.getIdentificacion().equals("900304530")) {
                    this.JCBTercero.setSelectedItem(this.xjifpago.xModelo.getValueAt(x, 25).toString());
                } else {
                    this.JCBTercero.setSelectedItem(this.xjifpago.JCB_Empresa.getSelectedItem());
                }
                this.JCBAuxiliar.setSelectedItem(this.xjifpago.xModelo.getValueAt(x, 18).toString());
                this.JRBCredito.setSelected(true);
                this.xtipoc = 1;
                this.xNFactura = this.xjifpago.xModelo.getValueAt(x, 1).toString();
                this.JTF_NFactura.setText(this.xjifpago.xModelo.getValueAt(x, 1).toString());
                this.JTFFValor.setValue(Double.valueOf(this.xjifpago.xModelo.getValueAt(x, 21).toString()));
                this.JTAComentario.setText(this.xjifpago.JCBConceptoP.getSelectedItem() + " FACTURA N° " + this.xjifpago.xModelo.getValueAt(x, 1).toString());
                xpos = x;
                mAdicionarTabla();
            }
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 0 || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            this.JCBTercero.setSelectedItem(Principal.informacionIps.getNombreIps());
        } else {
            this.JCBTercero.setSelectedItem(this.xjifpago.JCB_Empresa.getSelectedItem());
        }
        this.JCBAuxiliar.setSelectedItem(this.xjifpago.xModelo.getValueAt(xpos, 19).toString());
        this.JRBCredito.setSelected(true);
        this.xtipoc = 0;
        this.xNFactura = "0";
        this.JTFFValor.setValue(this.xjifpago.JTFFValorPagado.getValue());
        this.JTAComentario.setText(this.xjifpago.JCBConceptoP.getSelectedItem().toString());
        mAdicionarTabla();
    }

    private void cargarInfoRadicacion() {
        if (this.entrada == null) {
            return;
        }
        if (this.entrada.getIdDocumentoContable().longValue() != 0) {
            mBuscarDatos(this.entrada.getIdDocumentoContable().toString(), false);
            return;
        }
        this.JDFFechaC.setDate(this.xmt.convertirLocalDateADate(this.entrada.getFechaFactura()));
        this.JCBTercero.setSelectedItem(this.entrada.getNombreTercero());
        this.JTF_NFactura.setText(this.entrada.getNumeroFactura());
        this.JCBTipoC.setSelectedItem("CAUSACION CUENTAS POR PAGAR");
        String numeroFactura = this.entrada.getNumeroFactura();
        Long idRadicacion = this.entrada.getIdRadicacion();
        this.xcargarreembolsocm = idRadicacion.longValue();
        if (this.entrada.getDetalleContable() != null) {
            this.entrada.getDetalleContable().forEach(e -> {
                this.JCBAuxiliar.setSelectedItem(e.getPucDebito());
                this.JRBDebito.setSelected(true);
                this.xtipoc = 0;
                this.xidradicacion = idRadicacion.longValue();
                this.xIdReembolso.add(idRadicacion);
                this.JTFFValor.setValue(e.getSubTotal());
                this.JTAComentario.setText("PAGO A PROVEEDORES SEGUN FACTURA N° " + numeroFactura);
                mAdicionarTabla();
            });
        }
        if (this.entrada.getCuentaPucPagar() != null || !this.entrada.getCuentaPucPagar().isEmpty()) {
            this.JCBAuxiliar.setSelectedItem(this.entrada.getCuentaPucPagar());
            this.JTAComentario.setText("PAGO A PROVEEDORES SEGUN FACTURA N° " + numeroFactura);
            this.JRBCredito.setSelected(true);
            this.xtipoc = 1;
            this.JTFFValor.setValue(this.entrada.getSubTotal());
            mAdicionarTabla();
        }
    }

    private void mCargarInformacion_CPagoDirecto() {
        this.xnfila = 0;
        this.JCBTipoC.setSelectedItem(this.xjifpago_Directo.JCBTipoDoc_Cont.getSelectedItem());
        for (int x = 0; x < this.xjifpago_Directo.JTResultado.getRowCount(); x++) {
            if (Boolean.valueOf(this.xjifpago_Directo.xmodelo.getValueAt(x, 6).toString()).booleanValue()) {
                this.JCBTercero.setSelectedItem(this.xjifpago_Directo.xmodelo.getValueAt(x, 2).toString());
                this.JCBAuxiliar.setSelectedItem(this.xjifpago_Directo.xmodelo.getValueAt(x, 7).toString());
                this.JRBDebito.setSelected(true);
                this.xtipoc = 0;
                this.xcargarreembolsocm = Integer.valueOf(this.xjifpago_Directo.xmodelo.getValueAt(x, 5).toString()).intValue();
                this.xidradicacion = Long.valueOf(this.xjifpago_Directo.xmodelo.getValueAt(x, 5).toString()).longValue();
                this.xNFactura = this.xjifpago_Directo.xmodelo.getValueAt(x, 3).toString();
                this.JTF_NFactura.setText(this.xjifpago_Directo.xmodelo.getValueAt(x, 3).toString());
                this.JTFFValor.setValue(Double.valueOf(this.xjifpago_Directo.xmodelo.getValueAt(x, 18).toString()));
                this.JTAComentario.setText("PAGO A PROVEEDORES SEGUN FACTURA N° " + this.xjifpago_Directo.xmodelo.getValueAt(x, 3).toString());
                mAdicionarTabla();
                this.xComodin = 1;
            }
        }
    }

    private void mExportarDatos() {
        WritableWorkbook workbook;
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                File archivo = new File(this.JTFRuta.getText() + ".xls");
                if (this.xmt.mEliminarArchivo(archivo)) {
                    workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                } else {
                    workbook = Workbook.createWorkbook(archivo);
                }
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "ID"));
                sheet.addCell(new Label(1, 1, "Nombre"));
                sheet.addCell(new Label(2, 1, "Tipo"));
                sheet.addCell(new Label(3, 1, "V/Credito"));
                sheet.addCell(new Label(4, 1, "V/Debito"));
                sheet.addCell(new Label(5, 1, "IdTercero"));
                sheet.addCell(new Label(6, 1, "Tercero"));
                sheet.addCell(new Label(7, 1, "Nrecibo"));
                sheet.addCell(new Label(8, 1, "Concepto"));
                int x = 2;
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    sheet.addCell(new Number(0, x, Long.valueOf(this.xmodelo.getValueAt(y, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, x, this.xmodelo.getValueAt(y, 1).toString()));
                    sheet.addCell(new Label(2, x, this.xmodelo.getValueAt(y, 2).toString()));
                    sheet.addCell(new Number(3, x, Double.valueOf(this.xmodelo.getValueAt(y, 3).toString()).doubleValue()));
                    sheet.addCell(new Number(4, x, Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue()));
                    sheet.addCell(new Label(5, x, this.xmodelo.getValueAt(y, 6).toString()));
                    sheet.addCell(new Label(6, x, this.xmodelo.getValueAt(y, 7).toString()));
                    sheet.addCell(new Label(7, x, this.xmodelo.getValueAt(y, 8).toString()));
                    sheet.addCell(new Label(8, x, this.xmodelo.getValueAt(y, 9).toString()));
                    x++;
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFDocContable.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFDocContable.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mMensajeTercero() {
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Tercero desactivado por no tener movimiento;</p><font face='Arial' color='red' size=4>No se pueder realizar registro.", "VERIFICACIÓN TERCERO", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
    }

    private void inicializarTablasNiif() {
        boolean usaNiif = Principal.xclase.getxForma_Gn_Niif() == 1;
        this.xcc_detalle_documentoc = usaNiif ? "cc_detalle_documentoc_niif" : "cc_detalle_documentoc";
        this.xcc_puc = usaNiif ? "cc_puc_niif" : "cc_puc";
        this.xcc_documentoc = usaNiif ? "cc_documentoc_niif" : "cc_documentoc";
    }

    public void mNuevo() {
        this.JLNo.setText("0");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xlleno = false;
        this.xGrabado = false;
        this.ccSolicitudReembolsos = new ArrayList();
        this.JCBTipoC.removeAllItems();
        this.xsql = "SELECT cc_tipo_documentoc.Id, cc_tipo_documentoc.Nbre, cc_tipo_documentoc.NReporte, IFNULL(cc_tipo_documentof.`Id`, 0) IdDocFn\nFROM cc_tipo_documentoc \nLEFT JOIN `cc_tipo_documentof` ON (cc_tipo_documentof.`Id`=cc_tipo_documentoc.`Id_DocF`)\nWHERE (cc_tipo_documentoc.Estado =1) ORDER BY cc_tipo_documentoc.Nbre ASC";
        this.xidtipodoccontable = this.xconsultas.llenarComboyLista(this.xsql, this.xidtipodoccontable, this.JCBTipoC, 4);
        mLLenar_Combo_Tercero();
        this.JCBAuxiliar.removeAllItems();
        this.xidauxiliar = this.xconsultas.llenarComboyLista("SELECT `Id`, `Id`, `Nbre`, `Tipo` FROM `" + this.xcc_puc + "` WHERE (`UNivel`=1) ORDER BY `Id` ASC", this.xidauxiliar, this.JCBAuxiliar, 4);
        this.JCBAuxiliar.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCBTipoC.setSelectedIndex(-1);
        this.JTAConceptoC.setText("");
        this.JTFNCuenta.setText("");
        this.JTF_NFactura.setText("0");
        this.JTF_NComprobante.setText("0");
        this.JRBCredito.setSelected(true);
        this.xtipoc = 1;
        this.xidradicacion = 0L;
        this.xcargarreembolsocm = 0L;
        this.xId_CCaja = 0L;
        this.xejecutado = false;
        this.xtipopago = -1;
        this.JRBNinguno.setSelected(true);
        this.JRBCheque.setSelected(false);
        this.JRBSDisfon.setSelected(false);
        this.JRBOtros.setSelected(false);
        this.JTFNCheque.setText("");
        this.JTFFValor.setValue(new Integer(0));
        this.JTFFValorC.setValue(new Integer(0));
        this.JTFFValorD.setValue(new Integer(0));
        this.JTFFDiferencia.setValue(new Integer(0));
        this.JDFFechaC.requestFocus();
        mCrearTablaDetalle();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "plantilla");
        this.xlleno = true;
        this.xComodin = 0;
        this.cierreCaja = 0L;
    }

    public void mLLenar_Combo_Tercero() {
        ConsultasMySQL xct = new ConsultasMySQL();
        this.JCBTercero.removeAllItems();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xidempresa = xct.llenarComboyLista("SELECT  `Id` , `RazonSocialCompleta` , `ActivoC` FROM `cc_terceros` where Estado = 1 ORDER BY `RazonSocialCompleta` ASC", this.xidempresa, this.JCBTercero, 3);
        } else {
            this.xidempresa = xct.llenarComboyLista("SELECT  `Id` , `RazonSocialCompleta` , `ActivoC` FROM `cc_terceros`  where Estado = 1 ORDER BY `RazonSocialCompleta` ASC", this.xidempresa, this.JCBTercero, 3);
        }
        this.JCBTercero.setSelectedIndex(-1);
        xct.cerrarConexionBd();
    }

    private void mLimpiarD() {
        this.JCBAuxiliar.setSelectedIndex(-1);
        this.JTFNCuenta.setText("");
        this.JTAComentario.setText("");
        this.xtipoc = 0;
        this.JRBCredito.setSelected(true);
        this.JTFFValor.setValue(new Integer(0));
        this.JCBAuxiliar.requestFocus();
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && this.xComodin == 1) {
            this.JCBTercero.setSelectedIndex(-1);
        }
    }

    private Long mConcecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "' AND `Estado` =1);";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL LOCAL DE PUERTO LIBERTADOR") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO")) {
            this.xConsecutivo = Long.valueOf(this.JTF_NComprobante.getText()).longValue();
        } else {
            this.xConsecutivo = Con + 1;
        }
        this.JTF_NComprobante.setText(String.valueOf(this.xConsecutivo));
        return Long.valueOf(this.xConsecutivo);
    }

    public void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Tipo", "V/Débito", "V/Crédito", "Base", "IdTercero", "Tercero", "NReciboCM", "Concepto", "IdTemp", "IdRadicacion", "NFactura", "Id_Doc", "estado"}) { // from class: Contabilidad.JIFDocContable.38
            Class[] types = {String.class, String.class, Long.class, Double.class, Double.class, Double.class, String.class, String.class, Long.class, String.class, Long.class, Long.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true, true, false, false, false, true, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(20);
        this.xnfila = -1;
    }

    public void mSumarValores() {
        double xtd = 0.0d;
        double xtc = 0.0d;
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            xtd += Double.valueOf(this.xmodelo.getValueAt(x, 3).toString().replaceAll(",", ".")).doubleValue();
            xtc += Double.valueOf(this.xmodelo.getValueAt(x, 4).toString().replaceAll(",", ".")).doubleValue();
        }
        this.JTFFValorC.setValue(Double.valueOf(xtc));
        this.JTFFValorD.setValue(Double.valueOf(xtd));
        this.JTFFDiferencia.setValue(Double.valueOf(xtc - xtd));
    }

    public void mGrabar() {
        String sql;
        if (Principal.xclase.getXidperiodoc() != -1) {
            if (Principal.xclase.isXestadop()) {
                if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                    if (this.JCBTipoC.getSelectedIndex() != -1) {
                        if (this.JTDetalle.getRowCount() > -1) {
                            if (!this.xmt.mVerificarDatosLLeno(this.JTDetalle, 6)) {
                                if (this.JTFFDiferencia.getText().equals("0,00") || this.JTFFDiferencia.getText().equals("0.00")) {
                                    if (this.JLNo.getText().equals("0")) {
                                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                        if (x == 0) {
                                            if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL")) {
                                                sql = "insert into " + this.xcc_documentoc + " (FechaD, Id_TipoComprobante, Id_Radicacion, Id_PeriodoC, TipoPago, NCheque, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "','" + this.xcargarreembolsocm + "','" + Principal.xclase.getXidperiodoc() + "','" + this.xtipopago + "','" + this.JTFNCheque.getText() + "','" + this.JTAConceptoC.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                            } else {
                                                sql = "insert into " + this.xcc_documentoc + " (FechaD, Id_TipoComprobante, NConsecutivo, Id_Radicacion, Id_PeriodoC, TipoPago, NCheque, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "','" + this.JTF_NComprobante.getText() + "','" + this.xcargarreembolsocm + "','" + Principal.xclase.getXidperiodoc() + "','" + this.xtipopago + "','" + this.JTFNCheque.getText() + "','" + this.JTAConceptoC.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                            }
                                            this.JLNo.setText(this.xconsultas.ejecutarSQLId(sql));
                                            Principal.txtEstado.setText("ACTIVO");
                                            this.xconsultas.cerrarConexionBd();
                                            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                                                ConsultasMySQL xct1 = new ConsultasMySQL();
                                                String sql2 = "insert into " + this.xcc_detalle_documentoc + " (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Base, Concepto) Values ('" + this.JLNo.getText() + "','" + this.xmodelo.getValueAt(y, 0).toString() + "','" + this.xmodelo.getValueAt(y, 2).toString() + "','" + this.xmodelo.getValueAt(y, 6).toString() + "','" + this.xmodelo.getValueAt(y, 8).toString() + "','" + this.xmodelo.getValueAt(y, 12).toString() + "','" + this.xmodelo.getValueAt(y, 3) + "','" + this.xmodelo.getValueAt(y, 4) + "','" + this.xmodelo.getValueAt(y, 5) + "','" + this.xmodelo.getValueAt(y, 9).toString() + "' )";
                                                xct1.ejecutarSQL(sql2);
                                                xct1.cerrarConexionBd();
                                                if (this.JTDetalle.getRowCount() >= 50 && y % 50 == 0) {
                                                    try {
                                                        Thread.sleep(6000L);
                                                    } catch (InterruptedException ex) {
                                                        Logger.getLogger(JIFDocContable.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                                    }
                                                }
                                                if (this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0].equals("6")) {
                                                    this.xclases.mActualizarFacturaEvento(this.JLNo.getText(), this.xmodelo.getValueAt(y, 10).toString(), true, getXtipo());
                                                }
                                            }
                                            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                                                this.gcuenta.crearDocumentoContableInterfaz(this.JLNo.getText());
                                            }
                                            mActualizarNComprobanteReembolso();
                                            mActualizarNId_CierreCaja();
                                            mGrabarUsuarioA();
                                            if (this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0].equals("2")) {
                                                String sql3 = "INSERT INTO `cc_radicacion_pago`(`Id_Radicacion`,`Id_Documento`,`Id_Puc`,`Valor`)\nSELECT\n    `cc_radicacion`.`Id`, cc_detalle_documentoc.`Id_Documentoc`\n    , `cc_detalle_documentoc`.`Id_Puc`\n    , `cc_detalle_documentoc`.`VDebito`\nFROM\n   `cc_radicacion`\n    INNER JOIN`cc_detalle_documentoc` \n        ON (`cc_radicacion`.`NoFactura` = `cc_detalle_documentoc`.`NFactura`) AND (`cc_radicacion`.`Id_Proveedor` = `cc_detalle_documentoc`.`Id_Tercero`)\nWHERE (`cc_detalle_documentoc`.`Id_Documentoc` ='" + this.JLNo.getText() + "');";
                                                this.xconsultas.ejecutarSQL(sql3);
                                                this.xconsultas.cerrarConexionBd();
                                            }
                                            if (this.entrada != null) {
                                                this.xsql = "update cc_radicacion set Id_Documento='" + this.JLNo.getText() + "' where Id=" + this.entrada.getIdRadicacion() + "";
                                                this.xconsultas.ejecutarSQL(this.xsql);
                                                this.xconsultas.cerrarConexionBd();
                                                this.xsql = "update i_entradas set Id_DocContable='" + this.JLNo.getText() + "' where Id=" + this.entrada.getIdEntrada() + "";
                                                this.xconsultas.ejecutarSQL(this.xsql);
                                                this.xconsultas.cerrarConexionBd();
                                            }
                                            if (this.JRBCheque.isSelected()) {
                                                Principal.xclase.mActualizarNCheque(this.JTFNCheque.getText());
                                            }
                                            if (this.xTipo) {
                                                this.xjifpago.setnDocumento(Long.valueOf(this.JLNo.getText()).longValue());
                                                this.xjifpago.mGrabar();
                                                dispose();
                                            }
                                            if (this.xForma == 1) {
                                                this.xjifpago_Directo.mGrabarDetallePago(this.JLNo.getText());
                                                this.xjifpago_Directo.grabarPagoPresupuestal(this.JLNo.getText());
                                                this.xjifpago_Directo.mBuscar();
                                                dispose();
                                            }
                                            mImprimir();
                                        }
                                        mBuscarDatos(this.JLNo.getText(), false);
                                        return;
                                    }
                                    int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (x2 == 0) {
                                        String sql4 = "update " + this.xcc_documentoc + " set FechaD='" + this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()) + "', Id_TipoComprobante='" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "', Id_PeriodoC='" + Principal.xclase.getXidperiodoc() + "', Descripcion='" + this.JTAConceptoC.getText() + "' where Id=" + this.JLNo.getText() + "";
                                        this.xconsultas.ejecutarSQL(sql4);
                                        for (int y2 = 0; y2 < this.JTDetalle.getRowCount(); y2++) {
                                            if (!((Boolean) this.xmodelo.getValueAt(y2, 14)).booleanValue()) {
                                                ConsultasMySQL xct12 = new ConsultasMySQL();
                                                this.xsql = "insert into " + this.xcc_detalle_documentoc + " (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito,Base, Concepto) Values ('" + this.JLNo.getText() + "','" + this.xmodelo.getValueAt(y2, 0).toString() + "','" + this.xmodelo.getValueAt(y2, 2).toString() + "','" + this.xmodelo.getValueAt(y2, 6).toString() + "','" + this.xmodelo.getValueAt(y2, 8).toString() + "','" + this.xmodelo.getValueAt(y2, 12).toString() + "','" + this.xmodelo.getValueAt(y2, 3) + "','" + this.xmodelo.getValueAt(y2, 4) + "','" + this.xmodelo.getValueAt(y2, 5) + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "' )";
                                                xct12.ejecutarSQL(this.xsql);
                                                xct12.cerrarConexionBd();
                                            } else {
                                                ConsultasMySQL xct13 = new ConsultasMySQL();
                                                this.xsql = "UPDATE " + this.xcc_detalle_documentoc + " SET   Id_Puc='" + this.xmodelo.getValueAt(y2, 0).toString() + "', TipoCPuc='" + this.xmodelo.getValueAt(y2, 2).toString() + "', Id_Tercero='" + this.xmodelo.getValueAt(y2, 6).toString() + "', Id_Radicacion='" + this.xmodelo.getValueAt(y2, 8).toString() + "', NFactura='" + this.xmodelo.getValueAt(y2, 12).toString() + "', VDebito='" + this.xmodelo.getValueAt(y2, 3).toString() + "', VCredito='" + this.xmodelo.getValueAt(y2, 4).toString() + "', Base='" + this.xmodelo.getValueAt(y2, 5).toString() + "', Concepto='" + this.xmodelo.getValueAt(y2, 9).toString() + "' WHERE Id='" + this.xmodelo.getValueAt(y2, 13).toString() + "'";
                                                xct13.ejecutarSQL(this.xsql);
                                                xct13.cerrarConexionBd();
                                            }
                                        }
                                        mBuscarDatos(this.JLNo.getText(), false);
                                        return;
                                    }
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "La diferencia debe ser cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Falta información de tercer", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe adicionar una cuenta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoC.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JDFFechaC.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Existen mas de un periodo abierto, \nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    public void mImprimir() {
        if (!this.JLNo.getText().equals("0") && this.JCBTipoC.getSelectedIndex() != -1) {
            switch (this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0]) {
                case "1":
                    Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][1], "4", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                    break;
                case "3":
                    Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][1], "5", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                    break;
                case "2":
                    if (this.xForma == 1) {
                        Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][1], "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                        break;
                    } else {
                        Object[] botones = {"Comprobante Egreso", "Relación de Pago", "Formato de Cheque", "Cerrar"};
                        int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                        if (n == 0) {
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), "CC_DocumentoContableCE", "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                                Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), "CC_ComprobanteEgresoN", "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                            } else {
                                Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][1], "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                            }
                            break;
                        } else if (n == 1) {
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), "CC_RelacionComprobanteEgresoN", "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                                Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), "CC_ComprobanteEgresoN", "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), "CC_ComprobanteEgreso_N_1", "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                            } else {
                                Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][1], "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                            }
                            break;
                        } else if (n == 2 && this.JRBCheque.isSelected()) {
                            DecimalFormat formato = new DecimalFormat("#0.00");
                            String[][] mparametros = new String[5][2];
                            if (this.JCHIncluir.isSelected()) {
                                if (this.JCHUtilizar.isSelected()) {
                                    mparametros[0][0] = "Id";
                                    mparametros[0][1] = this.JLNo.getText();
                                    mparametros[1][0] = "ValorL";
                                    mparametros[1][1] = this.xmt.mConvertirNumeroLetras(formato.format(Double.valueOf(this.JTFFValorD.getValue().toString())));
                                    mparametros[2][0] = "Tipo";
                                    mparametros[2][1] = "1";
                                    mparametros[3][0] = "SUBREPORT_DIR";
                                    mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                                    mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                                    mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                                } else {
                                    mparametros[0][0] = "Id";
                                    mparametros[0][1] = this.JLNo.getText();
                                    mparametros[1][0] = "ValorL";
                                    mparametros[1][1] = this.xmt.mConvertirNumeroLetras(formato.format(Double.valueOf(this.JTFFValorD.getValue().toString())));
                                    mparametros[2][0] = "Tipo";
                                    mparametros[2][1] = "0";
                                    mparametros[3][0] = "SUBREPORT_DIR";
                                    mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                                    mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                                    mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                                }
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_FormatoCheques1", mparametros);
                            } else {
                                if (this.JCHUtilizar.isSelected()) {
                                    mparametros[0][0] = "Id";
                                    mparametros[0][1] = this.JLNo.getText();
                                    mparametros[1][0] = "ValorL";
                                    mparametros[1][1] = this.xmt.mConvertirNumeroLetras(formato.format(Double.valueOf(this.JTFFValorD.getValue().toString())));
                                    mparametros[2][0] = "Tipo";
                                    mparametros[2][1] = "1";
                                    mparametros[3][0] = "SUBREPORT_DIR";
                                    mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                                    mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                                    mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                                } else {
                                    mparametros[0][0] = "Id";
                                    mparametros[0][1] = this.JLNo.getText();
                                    mparametros[1][0] = "ValorL";
                                    mparametros[1][1] = this.xmt.mConvertirNumeroLetras(formato.format(Double.valueOf(this.JTFFValorD.getValue().toString())));
                                    mparametros[2][0] = "Tipo";
                                    mparametros[2][1] = "0";
                                    mparametros[3][0] = "SUBREPORT_DIR";
                                    mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                                    mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                                    mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                                }
                                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_FormatoCheques", mparametros);
                            }
                            break;
                        }
                    }
                    break;
                case "13":
                    String[][] mparametros2 = new String[4][2];
                    mparametros2[0][0] = "IdC";
                    mparametros2[0][1] = this.JLNo.getText();
                    mparametros2[1][0] = "UsuarioS";
                    mparametros2[1][1] = Principal.usuarioSistemaDTO.getLogin();
                    mparametros2[2][0] = "SUBREPORT_DIR";
                    mparametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
                    mparametros2[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_CostoInventario", mparametros2);
                    break;
                default:
                    if (!this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][1].equals("")) {
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), "CC_DocumentoContableCE", "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                            Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), "CC_ComprobanteEgresoN", "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                        } else {
                            Principal.xclase.mImprimDocumentoContable("IdC", this.JLNo.getText(), this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][1], "2", this.JTFFValorD.getValue().toString(), this.JTFFValorD.getText());
                        }
                        break;
                    }
                    break;
            }
        }
    }

    public void mBuscar() {
        this.xjibuscardocumento = new JIFBuscarDocumentosC(this);
        Principal.cargarPantalla(this.xjibuscardocumento);
    }

    public void mBuscarDatos(String xid, boolean xForma) {
        mNuevo();
        mCrearTablaDetalle();
        String sql = "SELECT cc_documentoc.Id, cc_documentoc.FechaD, cc_tipo_documentoc.Nbre, cc_detalle_documentoc.Id_Puc, cc_puc.Nbre, cc_detalle_documentoc.TipoCPuc, cc_detalle_documentoc.VCredito, cc_detalle_documentoc.VDebito, cc_terceros.Id, cc_terceros.RazonSocialCompleta as Empresa , cc_documentoc.Estado, cc_detalle_documentoc.Id_Radicacion, cc_documentoc.Ejecutado, cc_documentoc.NCheque, cc_documentoc.TipoPago, cc_detalle_documentoc.NFactura, cc_detalle_documentoc.Concepto, cc_detalle_documentoc.Id as Id_Doc, cc_documentoc.Descripcion, cc_documentoc.`NConsecutivo` , `cc_detalle_documentoc`.`Base`,`cc_detalle_documentoc`.`estado` As estadoD, cc_documentoc.idCierreCaja  FROM cc_detalle_documentoc INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_puc ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN cc_terceros ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) WHERE (cc_documentoc.Id ='" + xid + "') ORDER BY cc_documentoc.Id DESC, cc_detalle_documentoc.TipoCPuc ASC ";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        try {
            if (xrs.next()) {
                if (!xForma) {
                    this.JTFNCheque.setText("");
                    this.JLNo.setText(xrs.getString(1));
                    this.xidradicacion = xrs.getLong("Id_Radicacion");
                    this.xejecutado = xrs.getBoolean(13);
                    if (xrs.getBoolean(11)) {
                        Principal.txtEstado.setText("ACTIVO");
                    } else {
                        Principal.txtEstado.setText("ANULADO");
                    }
                    this.JDFFechaC.setDate(xrs.getDate(2));
                    this.JCBTipoC.setSelectedItem(xrs.getString(3));
                    this.JTAConceptoC.setText(xrs.getString("Descripcion"));
                    switch (xrs.getInt("TipoPago")) {
                        case 0:
                            this.JRBSDisfon.setSelected(true);
                            break;
                        case 1:
                            this.JRBCheque.setSelected(true);
                            this.JTFNCheque.setText(xrs.getString("NCheque"));
                            break;
                        case 2:
                            this.JRBOtros.setSelected(true);
                            break;
                        default:
                            this.JRBNinguno.setSelected(true);
                            break;
                    }
                    this.JTF_NComprobante.setText(xrs.getString("NConsecutivo"));
                    this.JRBCheque.setEnabled(false);
                    this.JRBOtros.setEnabled(false);
                    this.JRBSDisfon.setEnabled(false);
                    this.JRBNinguno.setEnabled(false);
                }
                this.cierreCaja = Long.valueOf(xrs.getLong("idCierreCaja"));
                xrs.beforeFirst();
                this.xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(4), this.xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(5), this.xnfila, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(6)), this.xnfila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), this.xnfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), this.xnfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Base")), this.xnfila, 5);
                    this.xmodelo.setValueAt(xrs.getString(9), this.xnfila, 6);
                    this.xmodelo.setValueAt(xrs.getString(10), this.xnfila, 7);
                    this.xmodelo.setValueAt(xrs.getString("NFactura"), this.xnfila, 12);
                    this.xmodelo.setValueAt(xrs.getString("Id_Radicacion"), this.xnfila, 8);
                    this.xmodelo.setValueAt(xrs.getString("Concepto"), this.xnfila, 9);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(12)), this.xnfila, 11);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id_Doc")), this.xnfila, 13);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("estadoD")), this.xnfila, 14);
                    this.xnfila++;
                    mSumarValores();
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFDocContable.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mAnularC(String xid, String xmotivo) {
        this.xclases.mAnularDocumentoContable(this.JLNo.getText(), xid, xmotivo);
        this.xclases.mActualizarSalidasSiAnulaDocContable(this.JLNo.getText());
        this.xclases.mAnularDocumentoPresupuesto(this.JLNo.getText(), xid, xmotivo);
        this.xclases.mActualizarFacturaEvento(this.JLNo.getText(), null, false, getXtipo());
        this.xclases.mActualizarEstadoSReembolso(this.JLNo.getText(), Double.valueOf(this.JTFFValorC.getValue().toString()));
        this.xclases.mActualizarFacRadicadas(this.JLNo.getText());
        this.xclases.mActualizarActivos(this.JLNo.getText());
        this.xclases.mActualizarCierres(this.JLNo.getText());
        this.xclases.mActualizarCierresIngreso(this.JLNo.getText());
        this.xclases.mAnulado_RadicacionFactura(this.JLNo.getText());
        this.xclases.mActualizarDatosRadicaciondeFacturas(this.JLNo.getText());
        this.xclases.mLimpiarIdComprobanteEnLiquidacionNomina(this.JLNo.getText());
        this.xclases.mActualizarGlosas(this.JLNo.getText());
        this.xclases.mActualizarRespuestaGlosas(this.JLNo.getText());
        this.xclases.mActualizarPagosFacturas(this.JLNo.getText(), xid, xmotivo);
        if (this.cierreCaja.longValue() > 0) {
            this.xclases.mAtualizarDatosSolicitudPresupuesto(this.JLNo.getText(), xid, xmotivo);
        }
        Principal.txtEstado.setText("ANULADO");
    }

    public void mAnular() {
        if (!this.JLNo.getText().equals("0")) {
            if (Principal.xclase.isXestadop()) {
                if (!this.xejecutado) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        Anular frm = new Anular(null, true, "Contabilidad", 6);
                        frm.setLocationRelativeTo(this);
                        frm.setVisible(true);
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Comprobante no se puede anular ya sue ejecutado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe registro para anular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mCargarDatosReembolsoCM(List<Long> idReembolsos) {
        mCrearTablaDetalle();
        this.ccSolicitudReembolsos = new ArrayList();
        List<InformeSolicitudReembolso> list = this.solicituReembolsoService.listaReembolsosEgreso(idReembolsos);
        this.ccSolicitudReembolsos = this.solicituReembolsoService.listaPorIdReembolsos(this.xIdReembolso);
        if (!list.isEmpty()) {
            this.xIdReembolso = idReembolsos;
            for (InformeSolicitudReembolso next : list) {
                this.xnfila++;
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(next.getIdPuc(), this.xnfila, 0);
                this.xmodelo.setValueAt(next.getNombrePuc(), this.xnfila, 1);
                this.xmodelo.setValueAt(next.getTipo(), this.xnfila, 2);
                this.xmodelo.setValueAt(next.getValorDebito(), this.xnfila, 3);
                this.xmodelo.setValueAt(next.getValorCredito(), this.xnfila, 4);
                this.xmodelo.setValueAt(0, this.xnfila, 5);
                this.xmodelo.setValueAt(next.getIdTercero(), this.xnfila, 6);
                this.xmodelo.setValueAt(next.getNombreTercero(), this.xnfila, 7);
                this.xmodelo.setValueAt(next.getIdReembolso(), this.xnfila, 8);
                this.xmodelo.setValueAt(next.getObservacion(), this.xnfila, 9);
                this.xmodelo.setValueAt("0", this.xnfila, 10);
                this.xmodelo.setValueAt("0", this.xnfila, 11);
                this.xmodelo.setValueAt(next.getNumeroFactura(), this.xnfila, 12);
                this.xmodelo.setValueAt(0, this.xnfila, 13);
                this.xmodelo.setValueAt(false, this.xnfila, 14);
            }
            mSumarValores();
        }
    }

    private void mActualizarNComprobanteReembolso() {
        if (this.xcargarreembolsocm != 0) {
            String sql = "update cc_tipo_caja set Saldo=Saldo+" + this.JTFFValorC.getValue() + " where Id='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "'";
            this.xconsultas.ejecutarSQL(sql);
            this.xconsultas.cerrarConexionBd();
        }
        if (!this.ccSolicitudReembolsos.isEmpty()) {
            this.ccSolicitudReembolsos.forEach(item -> {
                item.setIdDocContable(Long.valueOf(this.JLNo.getText()));
            });
            this.solicituReembolsoService.grabar(this.ccSolicitudReembolsos);
        }
    }

    private void mActualizarNId_CierreCaja() {
        if (getxId_CCaja() != 0) {
            String sql = "update k_cierre_n set Id_DocumentoC='" + this.JLNo.getText() + "' where Id='" + getxId_CCaja() + "'";
            this.xconsultas.ejecutarSQL(sql);
            this.xconsultas.cerrarConexionBd();
        }
    }

    private void mGrabarUsuarioA() {
        try {
            String xsql1 = " SELECT cc_usuarioxdocumentof.Id, gp.Correo  \n FROM g_persona gp  \n INNER JOIN cc_usuarioxdocumentof ON (gp.Id = cc_usuarioxdocumentof.Id_Persona)\n WHERE ( cc_usuarioxdocumentof.Id_TipoDocF ='" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][2] + "' AND cc_usuarioxdocumentof.Estado =1) ";
            ResultSet rs = this.xconsultas.traerRs(xsql1);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        while (rs.next()) {
                            ConsultasMySQL xct = new ConsultasMySQL();
                            if (rs.getRow() == 1) {
                                this.xsql = "insert into cc_detalle_firma_documentoc (Id_OrdenDc, Id_UsuarioF, Autorizo, FechaA, Observacion) values('" + this.JLNo.getText() + "','" + rs.getInt(1) + "',1,now(),'' )";
                            } else {
                                this.xsql = "insert into cc_detalle_firma_documentoc (Id_OrdenDc, Id_UsuarioF) values('" + this.JLNo.getText() + "','" + rs.getInt(1) + "')";
                            }
                            xct.ejecutarSQL(this.xsql);
                            xct.cerrarConexionBd();
                            if (rs.getRow() == 1) {
                                this.xsql = "update cc_documentoc set EstadoA=1 where  Id='" + this.JLNo.getText() + "'";
                                xct.ejecutarSQL(this.xsql);
                                xct.cerrarConexionBd();
                            }
                        }
                    }
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    this.xconsultas.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public int getXtipo() {
        return this.xtipo;
    }

    public void setXtipo(int xtipo) {
        this.xtipo = xtipo;
    }

    public long getxId_CCaja() {
        return this.xId_CCaja;
    }

    public void setxId_CCaja(long xId_CCaja) {
        this.xId_CCaja = xId_CCaja;
    }

    public void imprimirComprobante() {
    }
}
