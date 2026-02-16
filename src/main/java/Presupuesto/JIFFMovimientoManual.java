package Presupuesto;

import Acceso.Principal;
import General.Anular;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto_New;
import com.genoma.plus.jpa.entities.PpRubrosCentrocostos;
import com.genoma.plus.jpa.entities.PpRubrosCpc;
import com.genoma.plus.jpa.entities.PpRubrosFuenteFinanciacion;
import com.genoma.plus.jpa.entities.PpTipoVigencia;
import com.genoma.plus.jpa.service.IPpRubrosCentrocostosService;
import com.genoma.plus.jpa.service.IPpRubrosCpcService;
import com.genoma.plus.jpa.service.IPpRubrosFuenteFinanciacionService;
import com.genoma.plus.jpa.service.IPpTipoVigenciaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFFMovimientoManual.class */
public class JIFFMovimientoManual extends JInternalFrame {
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloHt;
    private Object[] xdatos;
    private String[][] xIdDocumento;
    private String[] xIdRubros;
    public PpRubrosCpc ppRubrosCpc;
    private PpRubrosCentrocostos ppRubrosCentrocostos;
    private PpRubrosFuenteFinanciacion ppRubrosFuenteFinanciacion;
    private List<PpRubrosFuenteFinanciacion> listFuenteFinanciacion;
    private List<PpRubrosCentrocostos> listCentroCosto;
    private List<PpTipoVigencia> listTipoVigencia;
    private final IPpRubrosCpcService iPpRubrosCpcService;
    private final IPpRubrosCentrocostosService iPpRubrosCentrocostosService;
    private final IPpRubrosFuenteFinanciacionService iPpRubrosFuenteFinanciacionService;
    private final IPpTipoVigenciaService iPpTipoVigenciaService;
    private JButton JBAdicionar;
    private JButton JBAdicionar1;
    private JButton JBExportar;
    private ButtonGroup JBG_FEStado;
    private JButton JBImportar;
    private JButton JBTBuscar;
    private JButton JBT_BusquedaCPC;
    private JComboBox JCBCentroCosto;
    private JComboBox JCBFuenteFinanciacion;
    private JComboBox JCBRubros;
    private JComboBox JCBTipoDocumento;
    private JComboBox JCBVIgencia;
    private JCheckBox JCHRecAuto;
    private JFormattedTextField JFTFTotal;
    private JFormattedTextField JFTFValor;
    private JFormattedTextField JFTFValorSaldoR;
    private JLabel JLB_Registro;
    public JLabel JLNoDoc;
    public JLabel JLTercero;
    private JPanel JPFiltro;
    private JRadioButton JRB_FActivos;
    private JRadioButton JRB_FAnulados;
    private JRadioButton JRB_FTodas;
    private JSpinner JSPAnio;
    private JTabbedPane JTBRubros;
    public JTable JTDetalle;
    private JTable JTDetalleHistorico;
    public JTextField JTFCodigoCPC;
    private JTextField JTFCodigoRbro;
    private JTextField JTFNombreCPC;
    private JTextField JTFRuta;
    public JTextArea JTObservacion;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    public JDateChooser txtFecha;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private JFileChooser FileChooser = new JFileChooser();
    private Vector columna = new Vector();
    private Vector filas = new Vector();
    private String xRubroEquivocado = "";
    private boolean xlleno = false;
    private boolean xllenoRubro = false;
    public String xIdTercero = "";
    private int xFila = 0;

    public JIFFMovimientoManual() {
        initComponents();
        this.iPpRubrosCpcService = (IPpRubrosCpcService) Principal.contexto.getBean(IPpRubrosCpcService.class);
        this.iPpRubrosCentrocostosService = (IPpRubrosCentrocostosService) Principal.contexto.getBean(IPpRubrosCentrocostosService.class);
        this.iPpRubrosFuenteFinanciacionService = (IPpRubrosFuenteFinanciacionService) Principal.contexto.getBean(IPpRubrosFuenteFinanciacionService.class);
        this.iPpTipoVigenciaService = (IPpTipoVigenciaService) Principal.contexto.getBean(IPpTipoVigenciaService.class);
        mNuevo();
        this.JSPAnio.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())));
        mCrearModeloDatos();
        this.txtFecha.setDate(this.xmt.getFechaActual());
        mInicia();
        mBuscaDatosHist();
    }

    /* JADX WARN: Type inference failed for: r3v160, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_FEStado = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JCBTipoDocumento = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTObservacion = new JTextArea();
        this.JCHRecAuto = new JCheckBox();
        this.JCBVIgencia = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBImportar = new JButton();
        this.JBAdicionar = new JButton();
        this.JFTFTotal = new JFormattedTextField();
        this.JLB_Registro = new JLabel();
        this.JTBRubros = new JTabbedPane();
        this.jPanel4 = new JPanel();
        this.JTFCodigoRbro = new JTextField();
        this.JCBRubros = new JComboBox();
        this.JFTFValor = new JFormattedTextField();
        this.JFTFValorSaldoR = new JFormattedTextField();
        this.JLTercero = new JLabel();
        this.JBTBuscar = new JButton();
        this.JLNoDoc = new JLabel();
        this.jPanel5 = new JPanel();
        this.JCBFuenteFinanciacion = new JComboBox();
        this.JCBCentroCosto = new JComboBox();
        this.JTFCodigoCPC = new JTextField();
        this.JTFNombreCPC = new JTextField();
        this.JBT_BusquedaCPC = new JButton();
        this.jPanel3 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        this.JSPAnio = new JSpinner();
        this.JBAdicionar1 = new JButton();
        this.JBExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JPFiltro = new JPanel();
        this.JRB_FTodas = new JRadioButton();
        this.JRB_FActivos = new JRadioButton();
        this.JRB_FAnulados = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MOVIMIENTOS MANUALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifMovimientoManual");
        addInternalFrameListener(new InternalFrameListener() { // from class: Presupuesto.JIFFMovimientoManual.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFMovimientoManual.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFMovimientoManual.2
            public void keyPressed(KeyEvent evt) {
                JIFFMovimientoManual.this.txtFechaKeyPressed(evt);
            }
        });
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFMovimientoManual.3
            public void itemStateChanged(ItemEvent evt) {
                JIFFMovimientoManual.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JTObservacion.setColumns(1);
        this.JTObservacion.setFont(new Font("Arial", 1, 12));
        this.JTObservacion.setRows(1);
        this.JTObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTObservacion);
        this.JCHRecAuto.setFont(new Font("Arial", 1, 12));
        this.JCHRecAuto.setText("Recaudo Automático");
        this.JCHRecAuto.setEnabled(false);
        this.JCHRecAuto.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.4
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JCHRecAutoActionPerformed(evt);
            }
        });
        this.JCBVIgencia.setFont(new Font("Arial", 1, 12));
        this.JCBVIgencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Vigencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(7, 7, 7).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1, -2, 580, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtFecha, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, 0, -1, 32767))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHRecAuto).addComponent(this.JCBVIgencia, -2, 156, -2)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtFecha, -1, -1, 32767).addComponent(this.JCBTipoDocumento)).addGap(5, 5, 5)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHRecAuto).addGap(18, 18, 18))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 63, -2).addComponent(this.JCBVIgencia, -2, 52, -2)).addGap(2, 2, 2)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 11));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFMovimientoManual.5
            public void mouseClicked(MouseEvent evt) {
                JIFFMovimientoManual.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFMovimientoManual.6
            public void keyPressed(KeyEvent evt) {
                JIFFMovimientoManual.this.JTDetalleKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.JBImportar.setFont(new Font("Arial", 1, 12));
        this.JBImportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.JBImportar.setText("Importar Archivo de Excel");
        this.JBImportar.setToolTipText("");
        this.JBImportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.7
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JBImportarActionPerformed(evt);
            }
        });
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.8
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JBAdicionarActionPerformed(evt);
            }
        });
        this.JFTFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFTotal.setHorizontalAlignment(0);
        this.JFTFTotal.setFont(new Font("Arial", 1, 12));
        this.JLB_Registro.setFont(new Font("Arial", 1, 14));
        this.JLB_Registro.setForeground(Color.red);
        this.JLB_Registro.setHorizontalAlignment(0);
        this.JLB_Registro.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTBRubros.setForeground(new Color(255, 0, 0));
        this.JTBRubros.setFont(new Font("Segoe UI", 1, 15));
        this.JTFCodigoRbro.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoRbro.setToolTipText("");
        this.JTFCodigoRbro.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoRbro.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JIFFMovimientoManual.9
            public void focusLost(FocusEvent evt) {
                JIFFMovimientoManual.this.JTFCodigoRbroFocusLost(evt);
            }
        });
        this.JTFCodigoRbro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.10
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JTFCodigoRbroActionPerformed(evt);
            }
        });
        this.JCBRubros.setFont(new Font("Arial", 1, 12));
        this.JCBRubros.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRubros.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFMovimientoManual.11
            public void itemStateChanged(ItemEvent evt) {
                JIFFMovimientoManual.this.JCBRubrosItemStateChanged(evt);
            }
        });
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValor.setHorizontalAlignment(0);
        this.JFTFValor.setFont(new Font("Arial", 1, 12));
        this.JFTFValorSaldoR.setEditable(false);
        this.JFTFValorSaldoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorSaldoR.setForeground(Color.red);
        this.JFTFValorSaldoR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorSaldoR.setHorizontalAlignment(0);
        this.JFTFValorSaldoR.setText("0");
        this.JFTFValorSaldoR.setFont(new Font("Arial", 1, 14));
        this.JLTercero.setFont(new Font("Arial", 1, 12));
        this.JLTercero.setHorizontalAlignment(0);
        this.JLTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTBuscar.setFont(new Font("Arial", 1, 12));
        this.JBTBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTBuscar.setToolTipText("Buscar CIE10");
        this.JBTBuscar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.12
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JBTBuscarActionPerformed(evt);
            }
        });
        this.JLNoDoc.setFont(new Font("Arial", 1, 12));
        this.JLNoDoc.setHorizontalAlignment(0);
        this.JLNoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JTFCodigoRbro, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRubros, -2, 430, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValor, -2, 107, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorSaldoR, -2, 107, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JLNoDoc, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLTercero, -2, 520, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTBuscar, -2, 48, -2))).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigoRbro, -2, 53, -2).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBRubros, -2, 52, -2).addComponent(this.JFTFValor, -2, 52, -2).addComponent(this.JFTFValorSaldoR, -2, 52, -2))).addGap(5, 5, 5).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLNoDoc, -2, 47, -2).addComponent(this.JLTercero, -2, 47, -2).addComponent(this.JBTBuscar, -2, 44, -2)).addContainerGap(34, 32767)));
        this.JTBRubros.addTab("RUBROS", this.jPanel4);
        this.JCBFuenteFinanciacion.setFont(new Font("Arial", 1, 12));
        this.JCBFuenteFinanciacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fuente Financiación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoCPC.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoCPC.setToolTipText("");
        this.JTFCodigoCPC.setBorder(BorderFactory.createTitledBorder((Border) null, "Código CPC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoCPC.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFMovimientoManual.13
            public void keyPressed(KeyEvent evt) {
                JIFFMovimientoManual.this.JTFCodigoCPCKeyPressed(evt);
            }
        });
        this.JTFNombreCPC.setFont(new Font("Arial", 1, 12));
        this.JTFNombreCPC.setToolTipText("");
        this.JTFNombreCPC.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre CPC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_BusquedaCPC.setFont(new Font("Arial", 1, 12));
        this.JBT_BusquedaCPC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBT_BusquedaCPC.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.14
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JBT_BusquedaCPCActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCBFuenteFinanciacion, -2, 214, -2).addGap(18, 18, 18).addComponent(this.JCBCentroCosto, -2, 424, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JTFCodigoCPC, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreCPC))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_BusquedaCPC, -2, 83, -2).addContainerGap(56, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFuenteFinanciacion, -2, 52, -2).addComponent(this.JCBCentroCosto, -2, 52, -2)).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoCPC, -2, 53, -2).addComponent(this.JTFNombreCPC, -2, 53, -2)).addComponent(this.JBT_BusquedaCPC, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JTBRubros.addTab("ADICIONAL", this.jPanel5);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JLB_Registro, -2, 154, -2).addGap(98, 98, 98).addComponent(this.JBImportar, -2, 268, -2).addGap(94, 94, 94).addComponent(this.JFTFTotal, -2, 131, -2).addGap(0, 0, 32767)).addComponent(this.JTBRubros, GroupLayout.Alignment.TRAILING).addComponent(this.JBAdicionar, -1, -1, 32767).addComponent(this.jScrollPane2)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTBRubros, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JBAdicionar, -2, 39, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 146, -2).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JLB_Registro, -1, -1, 32767).addContainerGap()).addGroup(jPanel2Layout.createSequentialGroup().addGap(9, 9, 9).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFTotal, -2, 52, -2).addComponent(this.JBImportar, -2, 45, -2)).addContainerGap(-1, 32767)))));
        this.jTabbedPane1.addTab("DATOS", this.jPanel2);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 11));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setAutoResizeMode(0);
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(Color.red);
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFMovimientoManual.15
            public void mouseClicked(MouseEvent evt) {
                JIFFMovimientoManual.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTDetalleHistorico);
        this.JSPAnio.setFont(new Font("Arial", 1, 12));
        this.JSPAnio.setModel(new SpinnerNumberModel(2013, 2013, (Comparable) null, 1));
        this.JSPAnio.setToolTipText("Año");
        this.JSPAnio.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPAnio.addChangeListener(new ChangeListener() { // from class: Presupuesto.JIFFMovimientoManual.16
            public void stateChanged(ChangeEvent evt) {
                JIFFMovimientoManual.this.JSPAnioStateChanged(evt);
            }
        });
        this.JSPAnio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFFMovimientoManual.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFMovimientoManual.this.JSPAnioPropertyChange(evt);
            }
        });
        this.JBAdicionar1.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBAdicionar1.setText("Actualizar");
        this.JBAdicionar1.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.18
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JBAdicionar1ActionPerformed(evt);
            }
        });
        this.JBExportar.setFont(new Font("Arial", 1, 12));
        this.JBExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.JBExportar.setText("Exportar");
        this.JBExportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.19
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JBExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFMovimientoManual.20
            public void mouseClicked(MouseEvent evt) {
                JIFFMovimientoManual.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JPFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Estado", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JBG_FEStado.add(this.JRB_FTodas);
        this.JRB_FTodas.setFont(new Font("Arial", 1, 12));
        this.JRB_FTodas.setSelected(true);
        this.JRB_FTodas.setText("Todos");
        this.JRB_FTodas.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.21
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JRB_FTodasActionPerformed(evt);
            }
        });
        this.JBG_FEStado.add(this.JRB_FActivos);
        this.JRB_FActivos.setFont(new Font("Arial", 1, 12));
        this.JRB_FActivos.setText("Activos");
        this.JRB_FActivos.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.22
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JRB_FActivosActionPerformed(evt);
            }
        });
        this.JBG_FEStado.add(this.JRB_FAnulados);
        this.JRB_FAnulados.setFont(new Font("Arial", 1, 12));
        this.JRB_FAnulados.setText("Anulados");
        this.JRB_FAnulados.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimientoManual.23
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimientoManual.this.JRB_FAnuladosActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroLayout = new GroupLayout(this.JPFiltro);
        this.JPFiltro.setLayout(JPFiltroLayout);
        JPFiltroLayout.setHorizontalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_FTodas).addGap(12, 12, 12).addComponent(this.JRB_FActivos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_FAnulados).addContainerGap(-1, 32767)));
        JPFiltroLayout.setVerticalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FTodas).addComponent(this.JRB_FActivos, -2, 23, -2).addComponent(this.JRB_FAnulados, -2, 23, -2)).addContainerGap(10, 32767)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JSPAnio, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionar1, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBExportar, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta)).addComponent(this.jScrollPane3, -1, 807, 32767).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JPFiltro, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -2, 56, -2).addComponent(this.JBAdicionar1, -1, -1, 32767).addComponent(this.JBExportar, -1, 59, 32767).addComponent(this.JSPAnio)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane3, -2, 443, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPFiltro, -2, -1, -2).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel3);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(12, 32767).addComponent(this.jTabbedPane1, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoDocumento.getSelectedIndex() > -1) {
            this.JCBRubros.removeAllItems();
            this.xIdRubros = null;
            String sql = "SELECT `pp_rubro_x_tipo_doc`.`IdRubro`,concat(`pp_rubros`.`Nbre`, ' - ', `pp_rubro_x_tipo_doc`.`IdRubro`) AS Rubro FROM `pp_rubro_x_tipo_doc` INNER JOIN  `pp_rubros` ON (`pp_rubro_x_tipo_doc`.`IdRubro` = `pp_rubros`.`Id`) AND (pp_rubro_x_tipo_doc.`idEncabezadoRubro`=pp_rubros.`idEncabezadoRubro`) WHERE (`pp_rubro_x_tipo_doc`.`Estado` =1 AND pp_rubro_x_tipo_doc.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `pp_rubro_x_tipo_doc`.`IdTipoDoc` ='" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "') ORDER BY `pp_rubro_x_tipo_doc`.`IdRubro` ASC;";
            System.out.println("Items COmbo-->" + sql);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xIdRubros = xct1.llenarCombo(sql, this.xIdRubros, this.JCBRubros);
            this.JCBRubros.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
            this.xllenoRubro = true;
            this.JTFCodigoRbro.setText("");
            this.JFTFValorSaldoR.setValue(0);
            this.JFTFValor.setValue(0);
            if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("2")) {
                this.JCHRecAuto.setEnabled(true);
            } else {
                this.JCHRecAuto.setEnabled(false);
                this.JCHRecAuto.setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    public void mBuscaMovimiento(String xId) {
        mCrearModeloDatos();
        String sql = "SELECT `pp_movimiento`.`Id` AS IdMovimiento, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS TipoDocumento, ifnull(`pp_movimiento`.`Observacion`,'') Observacion\n    , `pp_detalle_movimiento`.`Id_Rubro`,`pp_rubros`.`Cod_Alterno`, `pp_rubros`.`Nbre` AS NombreRubro, `pp_detalle_movimiento`.`Valor`, `pp_detalle_movimiento`.`Id_Tercero`,IF(`g_empresa`.Nbre='',CONCAT(`g_empresa`.Apellido1,' ',`g_empresa`.Apellido2,' ',`g_empresa`.Nombre1,' ',`g_empresa`.Nombre2),`g_empresa`.Nbre) AS NTercero \n    , `pp_detalle_movimiento`.`Observacion` AS ObsDetalle, `pp_detalle_movimiento`.`Estado`, pp_movimiento.IdSolicitud, pp_movimiento.IdDisponibilidad, IF(g_empresa.`Id_TipoIdentificacion` = 'CC',g_empresa.`No_identificacion`,CONCAT(g_empresa.`No_identificacion`,'-',g_empresa.`Dig_Verificacion`)) AS NoDocumento, pp_movimiento.Id_MotivoAnulacion \n  , `pp_detalle_movimiento`.`idRubrosCentroCostos` id_centro_costo\n  ,cc.`nombre` centro_costo \n  , `pp_detalle_movimiento`.`idRubrosCpc` id_cpc\n  ,cpc.`nombre` cpc \n  , `pp_detalle_movimiento`.`idRubrosFunteFinanciacion` id_fuente_financiacion\n  ,ff.`nombre` fuente_financiacion \n  , `pp_detalle_movimiento`.`idTopoVigencia` id_tipo_vigencia \n  ,tv.`Nombre` tipo_vigencia \n FROM `pp_detalle_movimiento` INNER JOIN   `pp_movimiento` ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN   `pp_rubros`   ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`)\n    INNER JOIN   `g_empresa`   ON (`pp_detalle_movimiento`.`Id_Tercero` = `g_empresa`.`Id`)\n    INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    INNER JOIN `pp_rubros_centrocostos` cc ON `pp_detalle_movimiento`.`idRubrosCentroCostos`=cc.id\n    INNER JOIN `pp_rubros_cpc` cpc ON `pp_detalle_movimiento`.`idRubrosCpc`=cpc.id\n    INNER JOIN `pp_rubros_fuente_financiacion` ff ON `pp_detalle_movimiento`.`idRubrosFunteFinanciacion`=ff.id\n    INNER JOIN `pp_tipo_vigencia` tv ON `pp_detalle_movimiento`.`idTopoVigencia`=tv.id \n WHERE (`pp_movimiento`.`Id` ='" + xId + "' AND pp_movimiento.Id_MotivoAnulacion=1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs = xct2.traerRs(sql);
        System.out.println("Movimiento-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JLB_Registro.setText(xrs.getString("IdMovimiento"));
                this.txtFecha.setDate(xrs.getDate("FechaD"));
                this.JCBTipoDocumento.setSelectedItem(xrs.getString("TipoDocumento"));
                this.JTObservacion.setText(xrs.getString("Observacion"));
                if (xrs.getInt("Id_MotivoAnulacion") == 1) {
                    Principal.txtEstado.setText("ACTIVO");
                } else {
                    Principal.txtEstado.setText("ANULADO");
                }
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("Id_Rubro"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("NombreRubro"), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Valor")), n, 2);
                    this.xmodelo.setValueAt(0, n, 3);
                    this.xmodelo.setValueAt(xrs.getString("Id_Tercero"), n, 4);
                    this.xmodelo.setValueAt(xrs.getString("NoDocumento"), n, 5);
                    this.xmodelo.setValueAt(xrs.getString("NTercero"), n, 6);
                    this.xmodelo.setValueAt(xrs.getString("ObsDetalle"), n, 7);
                    this.xmodelo.setValueAt(xrs.getString("id_centro_costo"), n, 8);
                    this.xmodelo.setValueAt(xrs.getString("centro_costo"), n, 9);
                    this.xmodelo.setValueAt(xrs.getString("id_cpc"), n, 10);
                    this.xmodelo.setValueAt(xrs.getString("cpc"), n, 11);
                    this.xmodelo.setValueAt(xrs.getString("id_fuente_financiacion"), n, 12);
                    this.xmodelo.setValueAt(xrs.getString("fuente_financiacion"), n, 13);
                    this.xmodelo.setValueAt(xrs.getString("id_tipo_vigencia"), n, 14);
                    this.xmodelo.setValueAt(xrs.getString("tipo_vigencia"), n, 15);
                    n++;
                }
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImportarActionPerformed(ActionEvent evt) {
        Importar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            mBuscaMovimiento(this.xmodeloHt.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString());
            mTotalizar();
            this.jTabbedPane1.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroActionPerformed(ActionEvent evt) {
        if (!this.JTFCodigoRbro.getText().isEmpty()) {
            mVerificarRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroFocusLost(FocusEvent evt) {
        if (!this.JTFCodigoRbro.getText().isEmpty()) {
            mVerificarRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRubrosItemStateChanged(ItemEvent evt) {
        if (this.xIdRubros != null && this.xllenoRubro && this.JCBRubros.getSelectedIndex() > -1) {
            this.JTFCodigoRbro.setText(this.xIdRubros[this.JCBRubros.getSelectedIndex()]);
            this.JFTFValorSaldoR.setValue(Double.valueOf(mSaldoRubro(this.xIdRubros[this.JCBRubros.getSelectedIndex()])));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        if (validarCampos()) {
            mAdicionar();
            mTotalizar();
            mLimipia();
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.JTObservacion.setText("");
        mCrearModeloDatos();
        this.JCBCentroCosto.removeAllItems();
        this.listCentroCosto = new ArrayList();
        this.listCentroCosto = this.iPpRubrosCentrocostosService.getListPpRubrosCentrocostosOrderByNombreAsc();
        this.listCentroCosto.forEach(e -> {
            this.JCBCentroCosto.addItem(e.getNombre());
        });
        this.JCBFuenteFinanciacion.removeAllItems();
        this.listFuenteFinanciacion = new ArrayList();
        this.listFuenteFinanciacion = this.iPpRubrosFuenteFinanciacionService.getListPpRubrosFuenteFinanciacionOrderByNombreAsc();
        this.listFuenteFinanciacion.forEach(e2 -> {
            this.JCBFuenteFinanciacion.addItem(e2.getNombre());
        });
        this.JCBVIgencia.removeAllItems();
        this.listTipoVigencia = new ArrayList();
        this.listTipoVigencia = this.iPpTipoVigenciaService.getListIPpTipoVigenciaOrderByNombreAsc();
        this.listTipoVigencia.forEach(e3 -> {
            this.JCBVIgencia.addItem(e3.getNombre());
        });
        mLimipia();
        this.JFTFTotal.setText("0");
    }

    private void mAdicionar() {
        this.xmodelo.addRow(this.xdatos);
        this.xmodelo.setValueAt(this.xIdRubros[this.JCBRubros.getSelectedIndex()], this.JTDetalle.getRowCount() - 1, 0);
        this.xmodelo.setValueAt(this.JCBRubros.getSelectedItem(), this.JTDetalle.getRowCount() - 1, 1);
        this.xmodelo.setValueAt(this.JFTFValor.getValue(), this.JTDetalle.getRowCount() - 1, 2);
        this.xmodelo.setValueAt(this.JFTFValorSaldoR.getValue(), this.JTDetalle.getRowCount() - 1, 3);
        this.xmodelo.setValueAt(this.xIdTercero, this.JTDetalle.getRowCount() - 1, 4);
        this.xmodelo.setValueAt(this.JLNoDoc.getText(), this.JTDetalle.getRowCount() - 1, 5);
        this.xmodelo.setValueAt(this.JLTercero.getText(), this.JTDetalle.getRowCount() - 1, 6);
        this.xmodelo.setValueAt(this.JTObservacion.getText(), this.JTDetalle.getRowCount() - 1, 7);
        this.xmodelo.setValueAt(this.listCentroCosto.get(this.JCBCentroCosto.getSelectedIndex()).getId(), this.JTDetalle.getRowCount() - 1, 8);
        this.xmodelo.setValueAt(this.JCBCentroCosto.getSelectedItem(), this.JTDetalle.getRowCount() - 1, 9);
        this.xmodelo.setValueAt(this.ppRubrosCpc.getId(), this.JTDetalle.getRowCount() - 1, 10);
        this.xmodelo.setValueAt(this.JTFNombreCPC.getText(), this.JTDetalle.getRowCount() - 1, 11);
        this.xmodelo.setValueAt(this.listFuenteFinanciacion.get(this.JCBFuenteFinanciacion.getSelectedIndex()).getId(), this.JTDetalle.getRowCount() - 1, 12);
        this.xmodelo.setValueAt(this.JCBFuenteFinanciacion.getSelectedItem(), this.JTDetalle.getRowCount() - 1, 13);
        this.xmodelo.setValueAt(this.listTipoVigencia.get(this.JCBVIgencia.getSelectedIndex()).getId(), this.JTDetalle.getRowCount() - 1, 14);
        this.xmodelo.setValueAt(this.JCBVIgencia.getSelectedItem(), this.JTDetalle.getRowCount() - 1, 15);
    }

    public void mAnular() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "PP_MoviManualesIngresos", 26);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
        }
    }

    private boolean mValidarAnulado() {
        return false;
    }

    public void mAnular_Registro(String xIdMot, String xObservacion) {
        Principal.xclasePresupuesto.mAnularMovimiento(xIdMot, xObservacion, this.JLB_Registro.getText(), getTitle());
        Principal.txtEstado.setText("ANULADO");
        mBuscaDatosHist();
        JOptionPane.showInternalMessageDialog(this, "Documento anulado correctamente", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mLimipia() {
        this.JTFCodigoRbro.setText("");
        this.JCBRubros.setSelectedIndex(-1);
        this.JFTFValor.setValue(0);
        this.JFTFValorSaldoR.setValue(0);
        this.JLNoDoc.setText("");
        this.JLTercero.setText("");
        this.xIdTercero = "";
        this.xFila = 0;
        this.JTObservacion.setText("");
        this.JCBCentroCosto.setSelectedIndex(-1);
        this.JCBFuenteFinanciacion.setSelectedIndex(-1);
        this.JCBVIgencia.setSelectedIndex(-1);
        this.JTFNombreCPC.setText("");
        this.JTFCodigoCPC.setText("");
        this.JLB_Registro.setText("");
        Principal.mLimpiarDatosP();
    }

    private boolean mVerificaRubroTabla() {
        boolean xExiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalle.getRowCount()) {
                break;
            }
            if (!this.xmodelo.getValueAt(i, 0).toString().equals(this.xIdRubros[this.JCBRubros.getSelectedIndex()])) {
                i++;
            } else {
                xExiste = true;
                break;
            }
        }
        return xExiste;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBuscarActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionar1ActionPerformed(ActionEvent evt) {
        mBuscaDatosHist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBExportarActionPerformed(ActionEvent evt) {
        mExportar();
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
    public void JCHRecAutoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (this.JLB_Registro.getText().isEmpty() && evt.getKeyCode() == 127) {
            this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
            this.xFila--;
            mTotalizar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FTodasActionPerformed(ActionEvent evt) {
        mBuscaDatosHist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FActivosActionPerformed(ActionEvent evt) {
        mBuscaDatosHist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FAnuladosActionPerformed(ActionEvent evt) {
        mBuscaDatosHist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPAnioPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPAnioStateChanged(ChangeEvent evt) {
        mBuscaDatosHist();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoCPCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            cargarInformacionCodigoCpc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_BusquedaCPCActionPerformed(ActionEvent evt) {
        cargarDialogoBusqueda("CodigoCpcMovManual");
    }

    private void mExportar() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleHistorico, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), "INFORME DE RECAUDOS Y RECONOCIMIENTOS");
        }
    }

    private void mVerificarRubro() {
        String sql = "SELECT concat(`pp_rubros`.`Nbre`, ' - ', `pp_rubro_x_tipo_doc`.`IdRubro`) AS Rubro FROM `pp_rubro_x_tipo_doc` INNER JOIN  `pp_rubros` ON (`pp_rubro_x_tipo_doc`.`IdRubro` = `pp_rubros`.`Id`) AND (pp_rubro_x_tipo_doc.`idEncabezadoRubro`=pp_rubros.`idEncabezadoRubro`) WHERE (`pp_rubro_x_tipo_doc`.`Estado` =1 AND pp_rubro_x_tipo_doc.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `pp_rubro_x_tipo_doc`.`IdTipoDoc` ='" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "' AND `pp_rubro_x_tipo_doc`.`IdRubro`= '" + this.JTFCodigoRbro.getText() + "') ORDER BY `pp_rubro_x_tipo_doc`.`IdRubro` ASC;";
        System.out.println("Entra Sql-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JCBRubros.setSelectedItem(xrs.getString("Rubro"));
            } else {
                this.JCBRubros.setSelectedIndex(-1);
                this.JTFCodigoRbro.setText("");
                JOptionPane.showMessageDialog(this, "Rubro no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private double mSaldoRubro(String xIdRubro) {
        double valor = 0.0d;
        String sql = "SELECT  \nr.Id\n,r.IdPadre\n,r.Nbre\n,r.TipoRubro\n,Presupuesto_Inicial\n,Adicion_Presupuesto\n,Reduccion_Presupuesto\n,Traslados_Debitos\n,Traslados_Creditos\n,Presupuesto_Definitivo\n,Reconocimiento_Anterior\n,Reconocimiento_Actual\n,Reconocimiento_Total\n,Recaudo_Anterior\n,Recaudo_Actual\n,Recaudo_Total\n,Saldo_por_Ejecutar\n,Saldo_por_Recaudar \n,Certificado_Anterior\n,Certificado_Actual\n,Total_Certificados\n,Compromiso_Anterior\n,Compromiso_Actual\n,Compromiso_Total\n,Obligacion_Anterior\n,Obligacion_Actual\n,Total_Obligaciones\n,Pagos_Anterior\n,Pagos_Actual\n,Total_Pagos\n,Saldo_Disponible\n,Sin_Comprometer\n,Compromisos_por_Pagar\n,Cuentas_por_Pagar\n,Certificado_sin_Comprometer\n\nFROM pp_rubros r\nINNER JOIN \n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n  ,Reconocimiento_Anterior\n ,Reconocimiento_Actual\n ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n ,Recaudo_Anterior\n ,Recaudo_Actual\n ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n/*Actualizacion con nuevos clase documentos*/ \n/*Disponibilidad CDP*/\n ,(Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)  AS Certificado_Anterior\n ,(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)  AS Certificado_Actual\n ,((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)) Total_Certificados\n/*Compromiso RP*/\n ,(Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior) AS Compromiso_Anterior\n ,(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual) AS Compromiso_Actual\n ,((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual)) Compromiso_Total\n /*Obligacion OP*/\n ,(Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior) AS Obligacion_Anterior\n ,(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual) AS Obligacion_Actual\n ,((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual)) Total_Obligaciones\n /*Pagos PP*/\n ,Pagos_Anterior\n ,Pagos_Actual\n ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n /*Operaciones...*/\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- ((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Sin_Comprometer\n ,(((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n ,(((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual))-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n ,(((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Certificado_sin_Comprometer\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\n-- -------------------------------------------------------------\n,SUM(IFNULL(Adicion_Disponibilidad_Anterior,0)) Adicion_Disponibilidad_Anterior\n,SUM(IFNULL(Adicion_Disponibilidad_Actual,0)) Adicion_Disponibilidad_Actual\n,SUM(IFNULL(Reintegro_Disponibilidad_Anterior,0)) Reintegro_Disponibilidad_Anterior\n,SUM(IFNULL(Reintegro_Disponibilidad_Actual,0)) Reintegro_Disponibilidad_Actual\n,SUM(IFNULL(Adicion_Compromiso_Anterior,0)) Adicion_Compromiso_Anterior\n,SUM(IFNULL(Adicion_Compromiso_Actual,0)) Adicion_Compromiso_Actual\n,SUM(IFNULL(Reintegro_Compromiso_Anterior,0)) Reintegro_Compromiso_Anterior\n,SUM(IFNULL(Reintegro_Compromiso_Actual,0)) Reintegro_Compromiso_Actual\n,SUM(IFNULL(Adicion_Obligacion_Anterior,0)) Adicion_Obligacion_Anterior\n,SUM(IFNULL(Adicion_Obligacion_Actual,0)) Adicion_Obligacion_Actual\n,SUM(IFNULL(Reintegro_Obligacion_Anterior,0)) Reintegro_Obligacion_Anterior\n,SUM(IFNULL(Reintegro_Obligacion_Actual,0)) Reintegro_Obligacion_Actual\n\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Reconocimiento_Anterior\n\n,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Reconocimiento_Actual\n\n,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Recaudo_Anterior\n\n,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Recaudo_Actual\n\n\n,CASE WHEN Id_CD=9  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Disponibilidad_Anterior\n\n,CASE WHEN Id_CD=9  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Disponibilidad_Actual\n\n,CASE WHEN Id_CD=4  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Compromiso_Anterior\n \n ,CASE WHEN Id_CD=4  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Compromiso_Actual\n \n,CASE WHEN Id_CD=5  AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Obligacion_Anterior\n \n,CASE WHEN Id_CD=5  AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Obligacion_Actual \n \n ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Pagos_Anterior\n \n ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Pagos_Actual\n -- -------------------------------------------------------\n /*\n10\tAdicion Disponibilidad\n11\tReintegro Disponibilidad\n12\tAdicion Compromiso\n13\tReintegro Compromiso\n14\tAdicion Obligación\n15\tReintegro Obligación\n*/\n ,CASE WHEN Id_CD=10 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=10 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Actual\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Actual\n\n ,CASE WHEN Id_CD=12 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=12 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Actual\n\n ,CASE WHEN Id_CD=13 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=13 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Reintegro_Compromiso_Actual \n    \n ,CASE WHEN Id_CD=14 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=14 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Adicion_Obligacion_Actual\n  \n,CASE WHEN Id_CD=15 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=15 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Actual\n \n\nFROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , pp_movimiento.Id_Periodo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    , @Periodo_Act Periodo_Act\n    \nFROM (SELECT @Periodo_Act:='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') p,\n    pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND  pp_periodo.Id IN ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n    WHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') pact\n    WHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n    OR pact.Id=pant.id\n         )  \n    AND pp_movimiento.Id_MotivoAnulacion=1  AND pp_rubros.`Id`='" + xIdRubro + "'\n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) datos ) datos\nON r.Id=datos.Id_R WHERE r.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "';";
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("Saldo Disponible-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                valor = xrs.getDouble("Saldo_Disponible");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return valor;
    }

    private void Importar() {
        this.FileChooser.showDialog((Component) null, "Importar Hoja ");
        File file = this.FileChooser.getSelectedFile();
        if (!file.getName().endsWith("xls")) {
            JOptionPane.showMessageDialog((Component) null, "Seleccione un archivo excel...", "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        try {
            CrearTabla(file);
        } catch (IOException ex) {
            Logger.getLogger(JIFFMovimientoManual.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void CrearTabla(File file) throws IOException {
        try {
            Workbook workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            this.columna.clear();
            for (int i = 0; i < sheet.getColumns(); i++) {
                Cell cell1 = sheet.getCell(i, 0);
                this.columna.add(cell1.getContents());
            }
            this.filas.clear();
            for (int j = 1; j < sheet.getRows(); j++) {
                Vector d = new Vector();
                for (int i2 = 0; i2 < sheet.getColumns(); i2++) {
                    Cell cell = sheet.getCell(i2, j);
                    switch (i2) {
                        case 2:
                            d.add(Double.valueOf(cell.getContents().replaceAll(",", ".")));
                            break;
                        case 3:
                            d.add(Double.valueOf(mSaldoRubro(sheet.getCell(0, j).getContents())));
                            break;
                        case 4:
                            d.add(sheet.getCell(4, j).getContents());
                            break;
                        default:
                            d.add(cell.getContents());
                            break;
                    }
                }
                d.add("\n");
                System.out.println("d - " + d);
                this.xmodelo.addRow(d);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    private boolean mVerificaUltNivel() {
        boolean xOk = false;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            String sql = " SELECT `Id`,`UltNivel` FROM `pp_rubros` WHERE Id='" + this.xmodelo.getValueAt(i, 0).toString() + "' and idEncabezadoRubro = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'";
            ResultSet xrs = this.xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    if (xrs.getInt("UltNivel") == 0) {
                        xOk = true;
                        this.xRubroEquivocado = xrs.getString("Id");
                        break;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFFMovimientoManual.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return xOk;
    }

    private String mIdTercero(String xDoc) {
        String xId = "";
        String sql = "SELECT Id FROM `g_empresa` WHERE (CONCAT(`No_identificacion`,'-',`Dig_Verificacion`)='" + xDoc + "')";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xId = xrs.getString(1);
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimientoManual.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        System.out.println("mIdTercero-->" + xId);
        return xId;
    }

    private void mTotalizar() {
        double xvalor = 0.0d;
        if (this.JTDetalle.getRowCount() != -1) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                xvalor += Double.valueOf(this.xmodelo.getValueAt(x, 2).toString()).doubleValue();
            }
        }
        this.JFTFTotal.setValue(Double.valueOf(xvalor));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdRubro", "Nombre", "Valor", "Saldo", "IdTercero", "DocumentoTercero", "NombreTercero", "Observaciòn", "Id Centro costos", "Centro Costos", "Id CPC", "CPC", "Id Fuente financiacion", "Fuente Financiacion", "Id Tipo vigencia", "Tipo Vigencia"}) { // from class: Presupuesto.JIFFMovimientoManual.24
            Class[] types = {String.class, String.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
    }

    private void mInicia() {
        this.xIdDocumento = this.xct.llenarComboyLista("SELECT pp_tipo_documentos.Id AS IdDoc, pp_tipo_documentos.Nbre AS NombreDoc,pp_tipo_documentos.Id_ClaseDoc,pp_clase_documento.`Nbre` AS NombreClaseDoc,pp_clase_documento.`IdPadre` FROM `pp_tipo_documentos`  INNER JOIN `pp_clase_documento` \n        ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`)WHERE (pp_tipo_documentos.Estado=1 AND pp_tipo_documentos.Id_ClaseDoc IN(2,3)) ORDER BY pp_tipo_documentos.Id_ClaseDoc ASC", this.xIdDocumento, this.JCBTipoDocumento, 5);
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.JFTFValor.setValue(0);
    }

    public void mGrabar() {
        if (Principal.usuarioSistemaDTO.getIdPersonaCargo() != null) {
            if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.txtFecha.getDate()))) {
                if (this.JLB_Registro.getText().isEmpty()) {
                    if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
                        if (this.JTDetalle.getRowCount() > -1) {
                            if (!mVerificaUltNivel()) {
                                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    String sql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,IdUsuarioR, `UsuarioS`)  VALUES ( '" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "','" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "','" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.JTObservacion.getText() + "' ,'" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                    System.out.println("Inserta Encabezado Mov-->" + sql);
                                    String xCargue = this.xct.ejecutarSQLId(sql);
                                    this.JLB_Registro.setText(xCargue);
                                    this.xct.cerrarConexionBd();
                                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                                        String sqld = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,`Valor`,`Observacion`,idEncabezado, idRubrosCentroCostos,idRubrosFunteFinanciacion,idRubrosCpc,idTopoVigencia)\n values ('" + xCargue + "', '" + this.xmodelo.getValueAt(i, 0) + "','" + this.xmodelo.getValueAt(i, 4) + "','" + this.xmodelo.getValueAt(i, 2) + "','" + this.xmodelo.getValueAt(i, 7) + "', '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "', '" + this.xmodelo.getValueAt(i, 8) + "', '" + this.xmodelo.getValueAt(i, 12) + "', '" + this.xmodelo.getValueAt(i, 10) + "', '" + this.xmodelo.getValueAt(i, 14) + "');";
                                        this.xct.ejecutarSQL(sqld);
                                        this.xct.cerrarConexionBd();
                                    }
                                    if (this.JCHRecAuto.isSelected()) {
                                        String xTDocRecaudo = null;
                                        for (int i2 = 0; i2 < this.JCBTipoDocumento.getItemCount(); i2++) {
                                            int j = 0;
                                            while (true) {
                                                if (j >= 4) {
                                                    break;
                                                }
                                                if (j != 1 || !this.xIdDocumento[i2][j].equals("3")) {
                                                    j++;
                                                } else {
                                                    xTDocRecaudo = this.xIdDocumento[i2][0];
                                                    break;
                                                }
                                            }
                                        }
                                        String sql2 = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,IdUsuarioR, `UsuarioS`)  VALUES ( '" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "','" + xTDocRecaudo + "','" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.JTObservacion.getText() + "' ,'" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                        System.out.println("Inserta Encabezado Mov-->" + sql2);
                                        String xCargue2 = this.xct.ejecutarSQLId(sql2);
                                        this.JLB_Registro.setText(xCargue2);
                                        this.xct.cerrarConexionBd();
                                        for (int i3 = 0; i3 < this.JTDetalle.getRowCount(); i3++) {
                                            String sqld2 = "INSERT INTO pp_detalle_movimiento (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`, `Observacion`, idEncabezado, idRubrosCentroCostos, idRubrosFunteFinanciacion, idRubrosCpc, idTopoVigencia) VALUES ('" + xCargue2 + "', '" + this.xmodelo.getValueAt(i3, 0) + "', '" + this.xmodelo.getValueAt(i3, 4) + "', '" + this.xmodelo.getValueAt(i3, 2) + "', '" + this.JTObservacion.getText() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "', '" + this.xmodelo.getValueAt(i3, 8) + "', '" + this.xmodelo.getValueAt(i3, 12) + "', '" + this.xmodelo.getValueAt(i3, 10) + "', '" + this.xmodelo.getValueAt(i3, 14) + "')";
                                            this.xct.ejecutarSQL(sqld2);
                                            this.xct.cerrarConexionBd();
                                        }
                                    }
                                    mBuscaDatosHist();
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "El rubro " + this.xRubroEquivocado + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe agregar rubros a la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoDocumento.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Registro ya grabado!!!", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Usuario de sistema sin cargo asginado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mBuscaDatosHist() {
        String sql;
        mCrearModeloDatosHist();
        if (this.JRB_FTodas.isSelected()) {
            sql = "SELECT `pp_movimiento`.`Id`,pp_periodo.Nbre AS Periodo, DATE_FORMAT(pp_periodo.FechaI,'%Y') AS Anio , `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, ifnull(`pp_movimiento`.`Observacion`,'') Observacion,\npp_detalle_movimiento.`Id_Rubro`, pp_rubros.`Nbre` AS Rubro, pp_detalle_movimiento.`Valor`,IF(g_empresa.`Id_TipoIdentificacion`='NI',g_empresa.`Nbre`,CONCAT( g_empresa.`Apellido1`,' ' , g_empresa.`Apellido2`,' '  , g_empresa.`Nombre1`,' ' , g_empresa.`Nombre2`)) AS Tercero, \n `g_motivoanulacion`.`Nbre` AS Anulacion, `pp_movimiento`.`NoFact`, `pp_detalle_movimiento`.`NCCobro`\n  , `pp_detalle_movimiento`.`idRubrosCentroCostos` id_centro_costo\n  ,cc.`nombre` centro_costo \n  , `pp_detalle_movimiento`.`idRubrosCpc` id_cpc\n  ,cpc.`nombre` cpc \n  , `pp_detalle_movimiento`.`idRubrosFunteFinanciacion` id_fuente_financiacion\n  ,ff.`nombre` fuente_financiacion \n  , `pp_detalle_movimiento`.`idTopoVigencia` id_tipo_vigencia \n  ,tv.`Nombre` tipo_vigencia \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n INNER JOIN   `pp_periodo`  ON (`pp_movimiento`.`Id_Periodo` = pp_periodo.`Id`)  \n INNER JOIN `pp_detalle_movimiento` ON (`pp_movimiento`.`Id`=`pp_detalle_movimiento`.`Id_Movimiento`)\n INNER JOIN pp_rubros ON (`pp_detalle_movimiento`.`Id_Rubro`= `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n INNER JOIN g_empresa ON (pp_detalle_movimiento.`Id_Tercero`= g_empresa.`Id`)     INNER JOIN `pp_rubros_centrocostos` cc ON `pp_detalle_movimiento`.`idRubrosCentroCostos`=cc.id\n    INNER JOIN `pp_rubros_cpc` cpc ON `pp_detalle_movimiento`.`idRubrosCpc`=cpc.id\n    INNER JOIN `pp_rubros_fuente_financiacion` ff ON `pp_detalle_movimiento`.`idRubrosFunteFinanciacion`=ff.id\n    INNER JOIN `pp_tipo_vigencia` tv ON `pp_detalle_movimiento`.`idTopoVigencia`=tv.id \n WHERE(pp_tipo_documentos.Id_ClaseDoc IN(2,3)  AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JSPAnio.getValue().toString() + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
        } else if (this.JRB_FActivos.isSelected()) {
            sql = "SELECT `pp_movimiento`.`Id`,pp_periodo.Nbre AS Periodo, DATE_FORMAT(pp_periodo.FechaI,'%Y') AS Anio , `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, ifnull(`pp_movimiento`.`Observacion`,'') Observacion,\npp_detalle_movimiento.`Id_Rubro`, pp_rubros.`Nbre` AS Rubro, pp_detalle_movimiento.`Valor`,IF(g_empresa.`Id_TipoIdentificacion`='NI',g_empresa.`Nbre`,CONCAT( g_empresa.`Apellido1`,' ' , g_empresa.`Apellido2`,' '  , g_empresa.`Nombre1`,' ' , g_empresa.`Nombre2`)) AS Tercero, \n `g_motivoanulacion`.`Nbre` AS Anulacion, `pp_movimiento`.`NoFact`, `pp_detalle_movimiento`.`NCCobro`\n  , `pp_detalle_movimiento`.`idRubrosCentroCostos` id_centro_costo\n  ,cc.`nombre` centro_costo \n  , `pp_detalle_movimiento`.`idRubrosCpc` id_cpc\n  ,cpc.`nombre` cpc \n  , `pp_detalle_movimiento`.`idRubrosFunteFinanciacion` id_fuente_financiacion\n  ,ff.`nombre` fuente_financiacion \n  , `pp_detalle_movimiento`.`idTopoVigencia` id_tipo_vigencia \n  ,tv.`Nombre` tipo_vigencia \n  , `pp_detalle_movimiento`.`idRubrosCentroCostos` id_centro_costo\n  ,cc.`nombre` centro_costo \n  , `pp_detalle_movimiento`.`idRubrosCpc` id_cpc\n  ,cpc.`nombre` cpc \n  , `pp_detalle_movimiento`.`idRubrosFunteFinanciacion` id_fuente_financiacion\n  ,ff.`nombre` fuente_financiacion \n  , `pp_detalle_movimiento`.`idTopoVigencia` id_tipo_vigencia \n  ,tv.`Nombre` tipo_vigencia \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n INNER JOIN   `pp_periodo`  ON (`pp_movimiento`.`Id_Periodo` = pp_periodo.`Id`)  \n INNER JOIN `pp_detalle_movimiento` ON (`pp_movimiento`.`Id`=`pp_detalle_movimiento`.`Id_Movimiento`)\n INNER JOIN pp_rubros ON (`pp_detalle_movimiento`.`Id_Rubro`= `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n INNER JOIN g_empresa ON (pp_detalle_movimiento.`Id_Tercero`= g_empresa.`Id`)     INNER JOIN `pp_rubros_centrocostos` cc ON `pp_detalle_movimiento`.`idRubrosCentroCostos`=cc.id\n    INNER JOIN `pp_rubros_cpc` cpc ON `pp_detalle_movimiento`.`idRubrosCpc`=cpc.id\n    INNER JOIN `pp_rubros_fuente_financiacion` ff ON `pp_detalle_movimiento`.`idRubrosFunteFinanciacion`=ff.id\n    INNER JOIN `pp_tipo_vigencia` tv ON `pp_detalle_movimiento`.`idTopoVigencia`=tv.id \n WHERE(pp_tipo_documentos.Id_ClaseDoc IN(2,3) AND pp_detalle_movimiento.`Estado`=1 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JSPAnio.getValue().toString() + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
        } else {
            sql = "SELECT `pp_movimiento`.`Id`,pp_periodo.Nbre AS Periodo, DATE_FORMAT(pp_periodo.FechaI,'%Y') AS Anio , `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, ifnull(`pp_movimiento`.`Observacion`,'') Observacion,\npp_detalle_movimiento.`Id_Rubro`, pp_rubros.`Nbre` AS Rubro, pp_detalle_movimiento.`Valor`,IF(g_empresa.`Id_TipoIdentificacion`='NI',g_empresa.`Nbre`,CONCAT( g_empresa.`Apellido1`,' ' , g_empresa.`Apellido2`,' '  , g_empresa.`Nombre1`,' ' , g_empresa.`Nombre2`)) AS Tercero, \n `g_motivoanulacion`.`Nbre` AS Anulacion, `pp_movimiento`.`NoFact`, `pp_detalle_movimiento`.`NCCobro`\n  , `pp_detalle_movimiento`.`idRubrosCentroCostos` id_centro_costo\n  ,cc.`nombre` centro_costo \n  , `pp_detalle_movimiento`.`idRubrosCpc` id_cpc\n  ,cpc.`nombre` cpc \n  , `pp_detalle_movimiento`.`idRubrosFunteFinanciacion` id_fuente_financiacion\n  ,ff.`nombre` fuente_financiacion \n  , `pp_detalle_movimiento`.`idTopoVigencia` id_tipo_vigencia \n  ,tv.`Nombre` tipo_vigencia \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n INNER JOIN   `pp_periodo`  ON (`pp_movimiento`.`Id_Periodo` = pp_periodo.`Id`)  \n INNER JOIN `pp_detalle_movimiento` ON (`pp_movimiento`.`Id`=`pp_detalle_movimiento`.`Id_Movimiento`)\n INNER JOIN pp_rubros ON (`pp_detalle_movimiento`.`Id_Rubro`= `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n INNER JOIN g_empresa ON (pp_detalle_movimiento.`Id_Tercero`= g_empresa.`Id`)     INNER JOIN `pp_rubros_centrocostos` cc ON `pp_detalle_movimiento`.`idRubrosCentroCostos`=cc.id\n    INNER JOIN `pp_rubros_cpc` cpc ON `pp_detalle_movimiento`.`idRubrosCpc`=cpc.id\n    INNER JOIN `pp_rubros_fuente_financiacion` ff ON `pp_detalle_movimiento`.`idRubrosFunteFinanciacion`=ff.id\n    INNER JOIN `pp_tipo_vigencia` tv ON `pp_detalle_movimiento`.`idTopoVigencia`=tv.id \n WHERE(pp_tipo_documentos.Id_ClaseDoc IN(2,3) AND pp_detalle_movimiento.`Estado`=0 AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JSPAnio.getValue().toString() + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
        }
        System.out.println("Movimientos-->" + sql);
        ResultSet xrsB = this.xct.traerRs(sql);
        int n = 0;
        try {
            if (xrsB.next()) {
                xrsB.beforeFirst();
                while (xrsB.next()) {
                    this.xmodeloHt.addRow(this.xdatos);
                    this.xmodeloHt.setValueAt(xrsB.getString("Id"), n, 0);
                    this.xmodeloHt.setValueAt(xrsB.getString("Periodo"), n, 1);
                    this.xmodeloHt.setValueAt(xrsB.getString("Anio"), n, 2);
                    this.xmodeloHt.setValueAt(xrsB.getString("FechaD"), n, 3);
                    this.xmodeloHt.setValueAt(xrsB.getString("Documento"), n, 4);
                    this.xmodeloHt.setValueAt(xrsB.getString("Observacion"), n, 5);
                    this.xmodeloHt.setValueAt(xrsB.getString("Id_Rubro"), n, 6);
                    this.xmodeloHt.setValueAt(xrsB.getString("Rubro"), n, 7);
                    this.xmodeloHt.setValueAt(Double.valueOf(xrsB.getDouble("Valor")), n, 8);
                    this.xmodeloHt.setValueAt(xrsB.getString("Tercero"), n, 9);
                    this.xmodeloHt.setValueAt(xrsB.getString("Anulacion"), n, 10);
                    this.xmodeloHt.setValueAt(xrsB.getString("NoFact"), n, 11);
                    this.xmodeloHt.setValueAt(xrsB.getString("NCCobro"), n, 12);
                    this.xmodeloHt.setValueAt(xrsB.getString("id_centro_costo"), n, 13);
                    this.xmodeloHt.setValueAt(xrsB.getString("centro_costo"), n, 14);
                    this.xmodeloHt.setValueAt(xrsB.getString("id_cpc"), n, 15);
                    this.xmodeloHt.setValueAt(xrsB.getString("cpc"), n, 16);
                    this.xmodeloHt.setValueAt(xrsB.getString("id_fuente_financiacion"), n, 17);
                    this.xmodeloHt.setValueAt(xrsB.getString("fuente_financiacion"), n, 18);
                    this.xmodeloHt.setValueAt(xrsB.getString("id_tipo_vigencia"), n, 19);
                    this.xmodeloHt.setValueAt(xrsB.getString("tipo_vigencia"), n, 20);
                    n++;
                }
            }
            xrsB.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaMovPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosHist() {
        this.xmodeloHt = new DefaultTableModel(new Object[0], new String[]{"Id", "Periodo", "Año", "Fecha", "Documento", "Observación", "Cod. Rubro", "NombreR", "Valor", "Tercero", "Estado", "Nº Factura", "CCobro", "Id Centro costos", "Centro Costos", "Id CPC", "CPC", "Id Fuente financiacion", "Fuente Financiacion", "Id Tipo vigencia", "Tipo Vigencia"}) { // from class: Presupuesto.JIFFMovimientoManual.25
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodeloHt);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(60);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(6).setPreferredWidth(65);
        this.JTDetalleHistorico.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(8).setPreferredWidth(65);
        this.JTDetalleHistorico.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalleHistorico.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalleHistorico.getColumnModel().getColumn(20).setPreferredWidth(100);
    }

    public void cargarInformacionCodigoCpc() {
        if (!this.JTFCodigoCPC.getText().isEmpty()) {
            this.ppRubrosCpc = new PpRubrosCpc();
            this.ppRubrosCpc = this.iPpRubrosCpcService.getPpRubrosCpcByNombreOrCodigo(this.JTFCodigoCPC.getText(), true);
            if (this.ppRubrosCpc != null) {
                this.JTFNombreCPC.setText(this.ppRubrosCpc.getNombre());
                this.JTFNombreCPC.transferFocus();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Código CPC no existe o no es de ultimo nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNombreCPC.setText("");
            }
        }
    }

    private void cargarDialogoBusqueda(String nombre) {
        JD_BusquedaInfoPresupuesto_New jd = new JD_BusquedaInfoPresupuesto_New(null, true, this, nombre);
        jd.setLocationRelativeTo(this);
        jd.setVisible(true);
    }

    private boolean validarCampos() {
        if (this.JCBRubros.getSelectedIndex() < 0) {
            mostrarMensaje("Debe seleccionar un Rubro", this.JCBRubros);
            return false;
        }
        if (this.xIdTercero == null || this.xIdTercero.trim().isEmpty()) {
            mostrarMensaje("Debe seleccionar un Tercero", this.JBTBuscar);
            return false;
        }
        if (this.JCBCentroCosto.getSelectedIndex() < 0) {
            mostrarMensaje("Debe seleccionar un Centro de Costo", this.JCBCentroCosto);
            this.JTBRubros.setSelectedIndex(1);
            return false;
        }
        if (this.listCentroCosto.get(this.JCBCentroCosto.getSelectedIndex()) == null) {
            mostrarMensaje("El Centro de Costo seleccionado no es válido", this.JCBCentroCosto);
            this.JTBRubros.setSelectedIndex(1);
            return false;
        }
        if (this.JTFCodigoCPC.getText().isEmpty()) {
            mostrarMensaje("Debe ingresar el Código CPC", this.JTFCodigoCPC);
            this.JTBRubros.setSelectedIndex(1);
            return false;
        }
        if (this.JTFNombreCPC.getText().isEmpty()) {
            mostrarMensaje("Debe ingresar el Nombre CPC", this.JTFNombreCPC);
            this.JTBRubros.setSelectedIndex(1);
            return false;
        }
        if (this.JCBFuenteFinanciacion.getSelectedIndex() < 0) {
            mostrarMensaje("Debe seleccionar una Fuente de Financiación", this.JCBFuenteFinanciacion);
            return false;
        }
        if (this.JCBVIgencia.getSelectedIndex() < 0) {
            mostrarMensaje("Debe seleccionar un Tipo de Vigencia", this.JCBVIgencia);
            this.JTBRubros.setSelectedIndex(1);
            return false;
        }
        return true;
    }

    private void mostrarMensaje(String mensaje, JComponent componente) {
        JOptionPane.showMessageDialog(this, mensaje, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        componente.requestFocus();
    }
}
