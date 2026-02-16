package Armado;

import Acceso.Principal;
import Facturacion.JIFAgendaTaquilla;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.FEConceptoNotas;
import com.genoma.plus.jpa.entities.FacturaNota;
import com.genoma.plus.jpa.entities.FacturaNotaDetalle;
import com.genoma.plus.jpa.entities.NotificacionResponseDTO;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.projection.NotaDebitoProjection;
import com.genoma.plus.jpa.service.FEConceptoNotasService;
import com.genoma.plus.jpa.service.FacturaNotaDetalleService;
import com.genoma.plus.jpa.service.FacturaNotasService;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.genoma.plus.jpa.service.NotaDebitoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JD_NotasP.class */
public class JD_NotasP extends JDialog {
    private DefaultTableModel modelo;
    private DefaultTableModel modeloHistorico;
    private DefaultTableModel modeloResultadoHistorico;
    private final Metodos metodos;
    private String idFactura;
    private Metodos xmt;
    private Integer xidfactura;
    private Integer idNota;
    public List<NotaDebitoProjection> debitoProjections;
    private final FEConceptoNotasService iConceptoNotaService;
    private final FacturaNotasService iFeNotasService;
    private String tipo;
    private List<FEConceptoNotas> conceptoNotas;
    private FacturaNota notas;
    private IResolucionDianDAO resolucionDian;
    private Object[] dato;
    private Object[] datoH;
    private NotaDebitoService debitoService;
    private Double total;
    private Double valorTotal;
    private Object[] xDato;
    private Integer idconcepto;
    private ConsultasMySQL xct;
    private long idLiquidacion;
    private long idLIquidacion;
    private long idINgreso;
    private Double valorN;
    public List<FacturaNotaDetalle> listaNotaDetalle;
    public String concepto;
    public String observacion;
    public Boolean primero;
    public Integer numeroConsecutivo;
    private final FacturaNotaDetalleService facturaNotaDetalleService;
    private JButton JBTAdicionar;
    private JButton JBTAdicionar1;
    private JButton JBTAdicionar2;
    private JButton JBTAdicionar3;
    private JButton JBTAgregar;
    private JButton JBTAgregar1;
    private JButton JBTAnular;
    private JButton JBTAnular1;
    private JButton JBTSalir;
    private JComboBox<String> JCB_Concepto;
    private JCheckBox JCHBSeleccionarTodo;
    private JDateChooser JDFFecha;
    private JLabel JLBNFacturaI;
    private JLabel JLConsecutivo;
    private JLabel JLNo;
    private JPanel JPI_EEncabezado;
    private JPanel JPI_EEncabezado3;
    private JPanel JPI_Historico;
    private JPanel JPI_Nota;
    private JPanel JPI_newItem;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPObservacion1;
    private JScrollPane JSPResultado;
    private JScrollPane JSPResultadoH;
    private JTextPane JTAObservacion;
    private JTextField JTFCantidad;
    private JTextField JTFCodigo;
    private JTextField JTFValorN1;
    private JTextField JTFValorU;
    private JTabbedPane JTP_Datos;
    public JTable JTResultado;
    public JTable JTResultadoH;
    private JTextPane JTfitem;
    private ButtonGroup buttonGroup1;
    private JCheckBox jchbNotaSinFactura;

    public JD_NotasP(Frame parent, boolean modal, String idFactura, String numeroFactura) {
        super(parent, modal);
        this.idFactura = "";
        this.xmt = new Metodos();
        this.xidfactura = 0;
        this.idNota = 0;
        this.iConceptoNotaService = (FEConceptoNotasService) Principal.contexto.getBean(FEConceptoNotasService.class);
        this.resolucionDian = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
        this.total = new Double(0.0d);
        this.valorTotal = new Double(0.0d);
        this.idconcepto = 0;
        this.xct = new ConsultasMySQL();
        this.idLiquidacion = 0L;
        this.idLIquidacion = 0L;
        this.idINgreso = 0L;
        this.valorN = Double.valueOf(0.0d);
        this.concepto = "";
        this.observacion = "";
        this.numeroConsecutivo = 0;
        this.facturaNotaDetalleService = (FacturaNotaDetalleService) Principal.contexto.getBean(FacturaNotaDetalleService.class);
        initComponents();
        this.debitoService = (NotaDebitoService) Principal.contexto.getBean(NotaDebitoService.class);
        this.iFeNotasService = (FacturaNotasService) Principal.contexto.getBean(FacturaNotasService.class);
        this.debitoProjections = new ArrayList();
        this.listaNotaDetalle = new ArrayList();
        springStart();
        this.JLBNFacturaI.setText(numeroFactura);
        this.idFactura = idFactura;
        this.metodos = new Metodos();
        this.notas = new FacturaNota();
        this.primero = true;
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v154, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Nota = new JPanel();
        this.JPI_EEncabezado = new JPanel();
        this.JCB_Concepto = new JComboBox<>();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JDFFecha = new JDateChooser();
        this.JLBNFacturaI = new JLabel();
        this.JBTAdicionar2 = new JButton();
        this.JBTAdicionar3 = new JButton();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JBTAdicionar = new JButton();
        this.JBTSalir = new JButton();
        this.JBTAdicionar1 = new JButton();
        this.JLNo = new JLabel();
        this.JBTAnular1 = new JButton();
        this.JBTAnular = new JButton();
        this.JCHBSeleccionarTodo = new JCheckBox();
        this.JLConsecutivo = new JLabel();
        this.jchbNotaSinFactura = new JCheckBox();
        this.JPI_newItem = new JPanel();
        this.JPI_EEncabezado3 = new JPanel();
        this.JBTAgregar1 = new JButton();
        this.JTFValorU = new JTextField();
        this.JTFCantidad = new JTextField();
        this.JTFValorN1 = new JTextField();
        this.JTFCodigo = new JTextField();
        this.JBTAgregar = new JButton();
        this.JSPObservacion1 = new JScrollPane();
        this.JTfitem = new JTextPane();
        this.JPI_Historico = new JPanel();
        this.JSPResultadoH = new JScrollPane();
        this.JTResultadoH = new JTable();
        setDefaultCloseOperation(2);
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_Nota.setForeground(new Color(0, 103, 0));
        this.JPI_Nota.setFont(new Font("Arial", 1, 14));
        this.JPI_EEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "ENCABEZADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCB_Concepto.setFont(new Font("Arial", 1, 12));
        this.JCB_Concepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto Notas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JDFFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFFecha.setFont(new Font("Arial", 1, 12));
        this.JLBNFacturaI.setFont(new Font("Arial", 1, 14));
        this.JLBNFacturaI.setHorizontalAlignment(0);
        this.JLBNFacturaI.setBorder(BorderFactory.createTitledBorder((Border) null, "No Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionar2.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar2.setText("Nuevo Item");
        this.JBTAdicionar2.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.1
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JBTAdicionar2ActionPerformed(evt);
            }
        });
        this.JBTAdicionar3.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar3.setText("Eliminar Item");
        this.JBTAdicionar3.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.2
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JBTAdicionar3ActionPerformed(evt);
            }
        });
        GroupLayout JPI_EEncabezadoLayout = new GroupLayout(this.JPI_EEncabezado);
        this.JPI_EEncabezado.setLayout(JPI_EEncabezadoLayout);
        JPI_EEncabezadoLayout.setHorizontalGroup(JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_EEncabezadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EEncabezadoLayout.createSequentialGroup().addComponent(this.JDFFecha, -2, 142, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCB_Concepto, -2, 514, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNFacturaI, -2, 156, -2)).addGroup(JPI_EEncabezadoLayout.createSequentialGroup().addComponent(this.JSPObservacion, -2, 569, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar3, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionar2, -2, 142, -2))).addContainerGap(18, 32767)));
        JPI_EEncabezadoLayout.setVerticalGroup(JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCB_Concepto, -1, 50, 32767).addComponent(this.JLBNFacturaI, -1, 50, 32767).addComponent(this.JDFFecha, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 32767).addGroup(JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAdicionar2, -2, 38, -2).addComponent(this.JBTAdicionar3, -2, 38, -2))).addContainerGap()));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 204, 204));
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.setSelectionMode(2);
        this.JTResultado.addKeyListener(new KeyAdapter() { // from class: Armado.JD_NotasP.3
            public void keyPressed(KeyEvent evt) {
                JD_NotasP.this.JTResultadoKeyPressed(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Grabar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.4
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Cerrar");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.5
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JBTAdicionar1.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Copiar.png")));
        this.JBTAdicionar1.setText("Enviar Dian");
        this.JBTAdicionar1.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.6
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JBTAdicionar1ActionPerformed(evt);
            }
        });
        this.JLNo.setFont(new Font("Arial", 1, 12));
        this.JLNo.setHorizontalAlignment(0);
        this.JLNo.setText("0");
        this.JLNo.setBorder(BorderFactory.createTitledBorder((Border) null, "IdNota", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAnular1.setFont(new Font("Arial", 1, 12));
        this.JBTAnular1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTAnular1.setText("Imprimir");
        this.JBTAnular1.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.7
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JBTAnular1ActionPerformed(evt);
            }
        });
        this.JBTAnular.setFont(new Font("Arial", 1, 12));
        this.JBTAnular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.JBTAnular.setText("Anular");
        this.JBTAnular.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.8
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JBTAnularActionPerformed(evt);
            }
        });
        this.JCHBSeleccionarTodo.setText("Seleccionar todo");
        this.JCHBSeleccionarTodo.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.9
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JCHBSeleccionarTodoActionPerformed(evt);
            }
        });
        this.JLConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JLConsecutivo.setHorizontalAlignment(0);
        this.JLConsecutivo.setText("0");
        this.JLConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jchbNotaSinFactura.setFont(new Font("Arial", 1, 12));
        this.jchbNotaSinFactura.setText("Nota Sin Factura");
        this.jchbNotaSinFactura.setToolTipText("Notas Créditos sin Factura relacionada");
        this.jchbNotaSinFactura.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.10
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.jchbNotaSinFacturaActionPerformed(evt);
            }
        });
        GroupLayout JPI_NotaLayout = new GroupLayout(this.JPI_Nota);
        this.JPI_Nota.setLayout(JPI_NotaLayout);
        JPI_NotaLayout.setHorizontalGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_NotaLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jchbNotaSinFactura, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JCHBSeleccionarTodo)).addGroup(JPI_NotaLayout.createSequentialGroup().addComponent(this.JBTAdicionar, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionar1, -2, 138, -2).addGap(18, 18, 18).addComponent(this.JBTAnular1).addGap(18, 18, 18).addComponent(this.JBTAnular).addGap(18, 18, 18).addComponent(this.JBTSalir, -2, 112, -2).addGap(18, 18, 18).addComponent(this.JLNo, -1, 99, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLConsecutivo, -2, 118, -2))).addContainerGap()).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createSequentialGroup().addComponent(this.JSPResultado).addContainerGap()).addComponent(this.JPI_EEncabezado, -1, -1, 32767)))));
        JPI_NotaLayout.setVerticalGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_NotaLayout.createSequentialGroup().addGap(169, 169, 169).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBSeleccionarTodo).addComponent(this.jchbNotaSinFactura)).addGap(193, 193, 193).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLNo, -2, 50, -2).addGroup(GroupLayout.Alignment.LEADING, JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAdicionar1, -2, 50, -2).addComponent(this.JBTAdicionar, -2, 50, -2).addComponent(this.JBTAnular1, -2, 50, -2).addComponent(this.JBTSalir, -2, 50, -2).addComponent(this.JBTAnular, -2, 50, -2))).addComponent(this.JLConsecutivo, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGap(41, 41, 41)).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_EEncabezado, -2, -1, -2).addGap(28, 28, 28).addComponent(this.JSPResultado, -2, 181, -2).addContainerGap(107, 32767))));
        this.JTP_Datos.addTab("NOTA", this.JPI_Nota);
        this.JPI_EEncabezado3.setBorder(BorderFactory.createTitledBorder((Border) null, "ENCABEZADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBTAgregar1.setFont(new Font("Arial", 1, 12));
        this.JBTAgregar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAgregar1.setText("Agregar");
        this.JBTAgregar1.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.11
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JBTAgregar1ActionPerformed(evt);
            }
        });
        this.JTFValorU.setFont(new Font("Arial", 1, 12));
        this.JTFValorU.setHorizontalAlignment(4);
        this.JTFValorU.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFValorU.addFocusListener(new FocusAdapter() { // from class: Armado.JD_NotasP.12
            public void focusLost(FocusEvent evt) {
                JD_NotasP.this.JTFValorUFocusLost(evt);
            }
        });
        this.JTFValorU.addKeyListener(new KeyAdapter() { // from class: Armado.JD_NotasP.13
            public void keyPressed(KeyEvent evt) {
                JD_NotasP.this.JTFValorUKeyPressed(evt);
            }
        });
        this.JTFCantidad.setFont(new Font("Arial", 1, 12));
        this.JTFCantidad.setHorizontalAlignment(4);
        this.JTFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCantidad.addFocusListener(new FocusAdapter() { // from class: Armado.JD_NotasP.14
            public void focusLost(FocusEvent evt) {
                JD_NotasP.this.JTFCantidadFocusLost(evt);
            }
        });
        this.JTFCantidad.addKeyListener(new KeyAdapter() { // from class: Armado.JD_NotasP.15
            public void keyPressed(KeyEvent evt) {
                JD_NotasP.this.JTFCantidadKeyPressed(evt);
            }
        });
        this.JTFValorN1.setEditable(false);
        this.JTFValorN1.setFont(new Font("Arial", 1, 12));
        this.JTFValorN1.setHorizontalAlignment(4);
        this.JTFValorN1.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Nota", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFValorN1.addFocusListener(new FocusAdapter() { // from class: Armado.JD_NotasP.16
            public void focusLost(FocusEvent evt) {
                JD_NotasP.this.JTFValorN1FocusLost(evt);
            }
        });
        this.JTFValorN1.addKeyListener(new KeyAdapter() { // from class: Armado.JD_NotasP.17
            public void keyPressed(KeyEvent evt) {
                JD_NotasP.this.JTFValorN1KeyPressed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setHorizontalAlignment(4);
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addFocusListener(new FocusAdapter() { // from class: Armado.JD_NotasP.18
            public void focusLost(FocusEvent evt) {
                JD_NotasP.this.JTFCodigoFocusLost(evt);
            }
        });
        this.JBTAgregar.setFont(new Font("Arial", 1, 12));
        this.JBTAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Clear 24x31.png")));
        this.JBTAgregar.setText("Limpiar");
        this.JBTAgregar.addActionListener(new ActionListener() { // from class: Armado.JD_NotasP.19
            public void actionPerformed(ActionEvent evt) {
                JD_NotasP.this.JBTAgregarActionPerformed(evt);
            }
        });
        this.JSPObservacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Item", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTfitem.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion1.setViewportView(this.JTfitem);
        GroupLayout JPI_EEncabezado3Layout = new GroupLayout(this.JPI_EEncabezado3);
        this.JPI_EEncabezado3.setLayout(JPI_EEncabezado3Layout);
        JPI_EEncabezado3Layout.setHorizontalGroup(JPI_EEncabezado3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EEncabezado3Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_EEncabezado3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFCodigo, GroupLayout.Alignment.LEADING, -1, 170, 32767).addComponent(this.JTFCantidad, GroupLayout.Alignment.LEADING)).addGroup(JPI_EEncabezado3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_EEncabezado3Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JTFValorU, -2, 170, -2).addGap(2, 2, 2).addComponent(this.JTFValorN1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAgregar1, -2, 135, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAgregar, -2, 135, -2)).addGroup(JPI_EEncabezado3Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion1, -2, 658, -2)))));
        JPI_EEncabezado3Layout.setVerticalGroup(JPI_EEncabezado3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EEncabezado3Layout.createSequentialGroup().addContainerGap(10, 32767).addGroup(JPI_EEncabezado3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_EEncabezado3Layout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 50, -2).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.TRAILING, JPI_EEncabezado3Layout.createSequentialGroup().addComponent(this.JSPObservacion1, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(JPI_EEncabezado3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFValorU, -2, 50, -2).addComponent(this.JTFValorN1, -2, 50, -2).addComponent(this.JTFCantidad, -2, 50, -2).addComponent(this.JBTAgregar1, -2, 50, -2).addComponent(this.JBTAgregar, -2, 50, -2)).addGap(99, 99, 99)));
        GroupLayout JPI_newItemLayout = new GroupLayout(this.JPI_newItem);
        this.JPI_newItem.setLayout(JPI_newItemLayout);
        JPI_newItemLayout.setHorizontalGroup(JPI_newItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_newItemLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_EEncabezado3, -1, -1, 32767).addContainerGap()));
        JPI_newItemLayout.setVerticalGroup(JPI_newItemLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_newItemLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_EEncabezado3, -1, -1, -2).addContainerGap(215, 32767)));
        this.JTP_Datos.addTab("NUEVO ITEM", this.JPI_newItem);
        this.JSPResultadoH.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultadoH.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultadoH.setFont(new Font("Arial", 1, 12));
        this.JTResultadoH.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultadoH.setEditingColumn(1);
        this.JTResultadoH.setEditingRow(1);
        this.JTResultadoH.setGridColor(new Color(204, 204, 204));
        this.JTResultadoH.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultadoH.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultadoH.addMouseListener(new MouseAdapter() { // from class: Armado.JD_NotasP.20
            public void mouseClicked(MouseEvent evt) {
                JD_NotasP.this.JTResultadoHMouseClicked(evt);
            }
        });
        this.JTResultadoH.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JD_NotasP.21
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JD_NotasP.this.JTResultadoHPropertyChange(evt);
            }
        });
        this.JTResultadoH.addKeyListener(new KeyAdapter() { // from class: Armado.JD_NotasP.22
            public void keyPressed(KeyEvent evt) {
                JD_NotasP.this.JTResultadoHKeyPressed(evt);
            }
        });
        this.JSPResultadoH.setViewportView(this.JTResultadoH);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 893, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultadoH, -1, 881, 32767).addContainerGap())));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 474, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultadoH, -2, 309, -2).addContainerGap(159, 32767))));
        this.JTP_Datos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos, -2, 893, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoKeyPressed(KeyEvent evt) {
        System.out.println("" + evt.getKeyCode());
        if (this.JTResultado.getSelectedColumn() == 6 && evt.getKeyCode() == 10) {
            nuevoCalculo();
        }
    }

    public void mImprimir() {
        if (!this.JLNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = this.JLNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "CC_RadicacionNotaCredito", mparametros);
        }
    }

    private void nuevoCalculo() {
        if (!"".equals(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 6)) && "" != this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 5)) {
            this.total = Double.valueOf(Double.valueOf(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 6).toString()).doubleValue() * Double.valueOf(this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 5).toString()).doubleValue());
            this.modelo.setValueAt(this.total, this.JTResultado.getSelectedRow(), 7);
            System.out.println("cantidad " + this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 5).toString() + " y el valor " + this.modelo.getValueAt(this.JTResultado.getSelectedRow(), 6).toString());
            System.out.println("el total" + this.total);
            return;
        }
        JOptionPane.showMessageDialog(this, "Faltan datos para el calculo", "VERIFICAR", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoHPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoHKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar2ActionPerformed(ActionEvent evt) {
        this.JTP_Datos.setSelectedIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAgregarActionPerformed(ActionEvent evt) {
        this.JTFCodigo.setText("");
        this.JTFCantidad.setText("");
        this.JTFValorU.setText("");
        this.JTFValorN1.setText("");
        this.JTfitem.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAgregar1ActionPerformed(ActionEvent evt) {
        mAsignar();
        this.JTP_Datos.setSelectedIndex(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFValorUFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFValorUKeyPressed(KeyEvent evt) {
        if ((evt.getKeyCode() == 10 || evt.getKeyCode() == 18) && !this.JTFCantidad.getText().isEmpty() && !this.JTFValorU.getText().isEmpty()) {
            this.valorN = Double.valueOf(Double.valueOf(this.JTFCantidad.getText()).doubleValue() * Double.valueOf(this.JTFValorU.getText()).doubleValue());
            this.JTFValorN1.setText(this.valorN.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFValorN1FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFValorN1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCantidadFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCantidadKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar3ActionPerformed(ActionEvent evt) {
        meliminar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar1ActionPerformed(ActionEvent evt) {
        if (!this.JLNo.getText().equals(0)) {
            this.idNota = Integer.valueOf(this.JLNo.getText());
            System.out.println("el nuevo id nota es -> " + this.idNota);
            System.out.println("va enviar nota");
            System.out.println("llamo al servicio de notas");
            if (Boolean.parseBoolean(this.JTResultadoH.getValueAt(this.JTResultadoH.getSelectedRow(), 7).toString()) || this.jchbNotaSinFactura.isSelected()) {
                this.iFeNotasService.generarNotasDebitoCredito(this.idNota, this.JLBNFacturaI.getText(), "DEBIT_NOTE_WBR");
                return;
            } else {
                this.iFeNotasService.generarNotasDebitoCredito(this.idNota, this.JLBNFacturaI.getText(), "DEBIT_NOTE");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una Nota", "VERIFICAR", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoHMouseClicked(MouseEvent evt) {
        if (this.JTResultadoH.getSelectedRow() != -1) {
            buscarConcepto(Integer.valueOf(this.modeloHistorico.getValueAt(this.JTResultadoH.getSelectedRow(), 2).toString()));
            this.JDFFecha.setDateFormatString(this.modeloHistorico.getValueAt(this.JTResultadoH.getSelectedRow(), 1).toString());
            this.JCB_Concepto.setSelectedItem(this.concepto);
            this.JTAObservacion.setText(this.modeloHistorico.getValueAt(this.JTResultadoH.getSelectedRow(), 4).toString());
            this.JLNo.setText(this.modeloHistorico.getValueAt(this.JTResultadoH.getSelectedRow(), 0).toString());
            this.jchbNotaSinFactura.setSelected(Boolean.parseBoolean(this.JTResultadoH.getValueAt(this.JTResultadoH.getSelectedRow(), 7).toString()));
            this.JTP_Datos.setSelectedIndex(0);
            if (this.JLNo.getText() != null) {
                buscarConcecutivo(Integer.valueOf(this.JLNo.getText()));
            }
            System.out.println("consecutivo f -> " + this.modeloHistorico.getValueAt(this.JTResultadoH.getSelectedRow(), 5).toString());
            this.JLConsecutivo.setText(this.modeloHistorico.getValueAt(this.JTResultadoH.getSelectedRow(), 6).toString() + "" + this.modeloHistorico.getValueAt(this.JTResultadoH.getSelectedRow(), 5).toString());
        }
        llenarDatosResultadoTablaHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAnular1ActionPerformed(ActionEvent evt) {
        System.out.println("idNota -> " + this.JLNo.getText());
        if (!this.JLNo.getText().isEmpty()) {
            Principal.xclase.mImprimirNotaDebito(Long.valueOf(this.JLNo.getText()), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAnularActionPerformed(ActionEvent evt) {
        if (!this.JLBNFacturaI.getText().isEmpty() && !this.JBTAnular.getText().isEmpty()) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3);
            if (x == 0) {
                if (!this.JLNo.getText().isEmpty()) {
                    String xsql = "update f_factura_notas set estado=0 where Id='" + this.JLNo.getText() + "'";
                    String xsql1 = "update f_factura_nota_detalle set estado = 0 where idFacturaNota = '" + this.JLNo.getText() + "'";
                    this.xct.ejecutarSQL(xsql);
                    this.xct.ejecutarSQL(xsql1);
                    this.xct.cerrarConexionBd();
                    System.out.println("" + xsql + "\n " + xsql1);
                }
                nuevo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBSeleccionarTodoActionPerformed(ActionEvent evt) {
        seleccionar(this.JCHBSeleccionarTodo.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchbNotaSinFacturaActionPerformed(ActionEvent evt) {
    }

    public void seleccionar(boolean estado) {
        for (int i = 0; i < this.JTResultado.getRowCount(); i++) {
            this.JTResultado.setValueAt(Boolean.valueOf(estado), i, 9);
        }
    }

    private void mAsignar() {
        asignarResultado(this.JTFCodigo.getText(), this.JTFCantidad.getText(), this.JTFValorU.getText(), this.JTFValorN1.getText(), this.JTfitem.getText());
    }

    private void buscarConcepto(Integer id) {
        String xsql = "select nombre  from cc_fe_concepto_notas cfcn where id =" + id + " ";
        System.out.println(xsql);
        try {
            ResultSet rs = this.xct.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        this.concepto = rs.getString("nombre");
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
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void meliminar() {
        int fila = this.JTResultado.getRowCount();
        int i = 0;
        while (i < this.JTResultado.getRowCount()) {
            System.out.println("1. this.JTResultado.getValueAt(i, 9).toString() -> " + this.JTResultado.getValueAt(i, 9).toString());
            System.out.println("2. Boolean.valueOf(this.JTResultado.getValueAt(i, 9).toString()) -> " + Boolean.valueOf(this.JTResultado.getValueAt(i, 9).toString()));
            if (Boolean.valueOf(this.JTResultado.getValueAt(i, 9).toString()).booleanValue()) {
                this.modelo.removeRow(i);
                i--;
                fila--;
            }
            System.out.println("---" + this.JTResultado.getRowCount());
            i++;
        }
    }

    private void grabar() {
        if (this.JCB_Concepto.getSelectedIndex() != -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
            if (n == 0) {
                new NotificacionResponseDTO();
                List<IResolucionFacturaElectronica> listaResolucionDian = this.resolucionDian.consultarResolucionPorSede(Principal.sedeUsuarioSeleccionadaDTO.getId(), 4);
                String prefijo = "";
                Integer idResolucion = 0;
                if (listaResolucionDian.size() > 0) {
                    prefijo = listaResolucionDian.get(0).getPrefijo();
                    idResolucion = listaResolucionDian.get(0).getId();
                }
                this.notas.setFechaNota(this.JDFFecha.getDate());
                this.notas.setEstado(true);
                this.notas.setIdLiquidacion(Long.valueOf(Long.valueOf("" + this.idLiquidacion).longValue()));
                this.notas.setIdConceptoNota(this.idconcepto);
                this.notas.setPrefijo(prefijo);
                this.notas.setFecha(this.metodos.getFechaActual());
                this.notas.setIdResolucion(idResolucion);
                if (!"".equals(this.JTAObservacion.getText())) {
                    this.notas.setDescripcionGeneral(this.JTAObservacion.getText());
                } else {
                    this.notas.setDescripcionGeneral("");
                }
                this.notas.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                this.notas.setResponse("La nota Débito ha sido registrada con éxito.");
                this.notas.setResponseEstado("SUCCESS");
                this.notas.setEnviada(true);
                this.notas.setIdRespuestaGlosa(0L);
                this.notas.setNumeroConsecutivo(0);
                this.notas.setNotaSinFactura(Boolean.valueOf(this.jchbNotaSinFactura.isSelected()));
                this.notas.setFechaPeriodoInicial(Principal.xclase.getXfechai());
                this.notas.setFechaPeriodoFinal(Principal.xclase.getXfechaf());
                this.iFeNotasService.save(this.notas);
                this.JLNo.setText("" + this.notas.getId());
                grabarItemsConcepto();
                this.facturaNotaDetalleService.saveAll(this.listaNotaDetalle);
                llenarDatosTablaHistorico();
                buscarConcecutivo(Integer.valueOf(this.JLNo.getText()));
                return;
            }
            return;
        }
        this.metodos.mostrarMensaje("Debe seleccionar un concepto");
        this.JCB_Concepto.requestFocus();
    }

    private void grabarItemsConcepto() {
        if (this.JTResultado.isEditing()) {
            this.JTResultado.getCellEditor().stopCellEditing();
        }
        List<FacturaNotaDetalle> listaNota = new ArrayList<>();
        for (int i = 0; i < this.JTResultado.getRowCount(); i++) {
            FacturaNotaDetalle facturadetalle = FacturaNotaDetalle.builder().cantidad(Integer.valueOf(Integer.parseInt(this.JTResultado.getValueAt(i, 5).toString()))).idCodigo(this.JTResultado.getValueAt(i, 4).toString()).valorNota(Double.valueOf(Double.valueOf(this.JTResultado.getValueAt(i, 6).toString()).doubleValue() * Double.valueOf(this.JTResultado.getValueAt(i, 5).toString()).doubleValue())).estado(true).tipo(0).valorUnitario(Double.valueOf(Double.parseDouble(this.JTResultado.getValueAt(i, 6).toString()))).porcentajeImpuesto(Double.valueOf(0.0d)).idFacturaNota(this.notas.getId()).observacion("").fecha(LocalDateTime.now()).nombreItem(this.JTResultado.getValueAt(i, 8).toString()).build();
            listaNota.add(facturadetalle);
        }
        this.listaNotaDetalle = listaNota;
    }

    public void nuevo() {
        this.JDFFecha.setDate(this.metodos.getFechaActual());
        llenarComboConcepto("");
        llenarDatosTabla();
        llenarDatosTablaHistorico();
        this.JTAObservacion.setText("");
        this.JLNo.setText("");
    }

    private void llenarComboConcepto(String tipo) {
        this.JCB_Concepto.removeAllItems();
        this.conceptoNotas = new ArrayList();
        if (tipo.equals("")) {
            this.conceptoNotas = this.iConceptoNotaService.listaDeConcep();
        } else {
            this.conceptoNotas = this.iConceptoNotaService.listaDeConcep();
        }
        this.conceptoNotas.forEach(e -> {
            this.JCB_Concepto.addItem(e.getNombre());
            this.idconcepto = e.getId();
        });
    }

    private void crearTabla() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id Liquidacion", "Id Ingreso", "id Factura", "Numero Factura", "Codigo", "Cantidad", "Valor Unitario", "Valor Nota", "Nombre Item", "s"}) { // from class: Armado.JD_NotasP.23
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, true, true, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.modelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(50);
    }

    private void crearTablaHistorico() {
        this.modeloHistorico = new DefaultTableModel((Object[][]) null, new String[]{"Nota", "Fecha Nota", "Concepto nota", "Id Liquidacion", "Observación", "Consecutivo", "prefijo", "Nota sin Factura"}) { // from class: Armado.JD_NotasP.24
            Class[] types = {String.class, Date.class, String.class, String.class, String.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultadoH.setAutoResizeMode(0);
        this.JTResultadoH.doLayout();
        this.JTResultadoH.setModel(this.modeloHistorico);
        this.JTResultadoH.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultadoH.getColumnModel().getColumn(1).setPreferredWidth(180);
        this.JTResultadoH.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTResultadoH.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultadoH.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTResultadoH.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTResultadoH.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTResultadoH.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    public void llenarDatosTabla() {
        crearTabla();
        this.debitoProjections = this.debitoService.liostarItemConcepto(this.JLBNFacturaI.getText());
        if (this.debitoProjections != null && !this.debitoProjections.isEmpty()) {
            this.debitoProjections.forEach(detalle -> {
                this.modelo.addRow(this.dato);
                this.JTResultado.setValueAt(detalle.getIdLiquidacion(), this.JTResultado.getRowCount() - 1, 0);
                this.idLiquidacion = detalle.getIdLiquidacion().longValue();
                this.JTResultado.setValueAt(detalle.getIdIngreso(), this.JTResultado.getRowCount() - 1, 1);
                this.JTResultado.setValueAt(detalle.getIdFactura(), this.JTResultado.getRowCount() - 1, 2);
                this.JTResultado.setValueAt(detalle.getNumeroFactura(), this.JTResultado.getRowCount() - 1, 3);
                this.JTResultado.setValueAt(detalle.getCodigo(), this.JTResultado.getRowCount() - 1, 4);
                this.JTResultado.setValueAt(detalle.getCantidad(), this.JTResultado.getRowCount() - 1, 5);
                this.JTResultado.setValueAt(detalle.getValorUinitario(), this.JTResultado.getRowCount() - 1, 6);
                if (this.primero.booleanValue()) {
                    this.JTResultado.setValueAt(detalle.getValorNota(), this.JTResultado.getRowCount() - 1, 7);
                } else {
                    this.JTResultado.setValueAt(this.total, this.JTResultado.getRowCount() - 1, 7);
                }
                this.JTResultado.setValueAt(detalle.getNombreItem(), this.JTResultado.getRowCount() - 1, 8);
                this.JTResultado.setValueAt(false, this.JTResultado.getRowCount() - 1, 9);
                this.idLIquidacion = detalle.getIdLiquidacion().longValue();
                this.idINgreso = detalle.getIdIngreso().longValue();
                System.out.println("el valor unitario es de " + detalle.getValorUinitario());
            });
            this.primero = false;
        }
    }

    public void asignarResultado(String codigo, String cantidad, String valorU, String valorN, String ITem) {
        this.modelo.addRow(this.dato);
        this.modelo.setValueAt(Long.valueOf(this.idLIquidacion), this.JTResultado.getRowCount() - 1, 0);
        this.modelo.setValueAt(Long.valueOf(this.idINgreso), this.JTResultado.getRowCount() - 1, 1);
        this.modelo.setValueAt(this.idFactura, this.JTResultado.getRowCount() - 1, 2);
        this.modelo.setValueAt(this.JLBNFacturaI.getText(), this.JTResultado.getRowCount() - 1, 3);
        this.modelo.setValueAt(codigo, this.JTResultado.getRowCount() - 1, 4);
        this.modelo.setValueAt(cantidad, this.JTResultado.getRowCount() - 1, 5);
        this.modelo.setValueAt(valorU, this.JTResultado.getRowCount() - 1, 6);
        this.modelo.setValueAt(valorN, this.JTResultado.getRowCount() - 1, 7);
        this.modelo.setValueAt(ITem, this.JTResultado.getRowCount() - 1, 8);
    }

    private void buscarConcecutivo(Integer idNota) {
        String xsql = "select numeroConsecutivo  from f_factura_notas ffn  where ffn.id =" + this.idNota + "";
        System.out.println(xsql);
        try {
            ResultSet rs = this.xct.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        this.numeroConsecutivo = Integer.valueOf(rs.getInt("numeroConsecutivo"));
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
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Finally extract failed */
    private void llenarDatosResultadoTablaHistorico() {
        crearModeloTablaResultadoHistorico();
        String xsql = "SELECT idFacturaNota, tipo, idCodigo, cantidad, valorUnitario, valorNota, nombreItem, observacion, porcentajeImpuesto\nFROM f_factura_nota_detalle WHERE idFacturaNota = '" + this.JLNo.getText() + "'";
        System.out.println(xsql);
        try {
            ResultSet rs = this.xct.traerRs(xsql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        this.modeloResultadoHistorico.addRow(this.datoH);
                        this.modeloResultadoHistorico.setValueAt(Integer.valueOf(rs.getInt("idFacturaNota")), this.JTResultado.getRowCount() - 1, 0);
                        this.modeloResultadoHistorico.setValueAt(Integer.valueOf(rs.getInt("tipo")), this.JTResultado.getRowCount() - 1, 1);
                        this.modeloResultadoHistorico.setValueAt(rs.getString("idCodigo"), this.JTResultado.getRowCount() - 1, 2);
                        this.modeloResultadoHistorico.setValueAt(Double.valueOf(rs.getDouble("cantidad")), this.JTResultado.getRowCount() - 1, 3);
                        this.modeloResultadoHistorico.setValueAt(Double.valueOf(rs.getDouble("valorUnitario")), this.JTResultado.getRowCount() - 1, 4);
                        this.modeloResultadoHistorico.setValueAt(Double.valueOf(rs.getDouble("valorNota")), this.JTResultado.getRowCount() - 1, 5);
                        this.modeloResultadoHistorico.setValueAt(rs.getString("nombreItem"), this.JTResultado.getRowCount() - 1, 6);
                        this.modeloResultadoHistorico.setValueAt(rs.getString("observacion"), this.JTResultado.getRowCount() - 1, 7);
                        this.modeloResultadoHistorico.setValueAt(Double.valueOf(rs.getDouble("porcentajeImpuesto")), this.JTResultado.getRowCount() - 1, 8);
                    }
                    this.JBTAgregar.setEnabled(false);
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
            } catch (Throwable th3) {
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        rs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void llenarDatosTablaHistorico() {
        crearTablaHistorico();
        String xsql = "SELECT id, fechaNota, idConceptoNota,idLiquidacion,descripcionGeneral, numeroConsecutivo, prefijo,notaSinFactura FROM f_factura_notas ffn WHERE idLiquidacion =" + this.idLiquidacion + "";
        System.out.println(xsql);
        try {
            ResultSet rs = this.xct.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        while (rs.next()) {
                            this.modeloHistorico.addRow(this.datoH);
                            this.idNota = Integer.valueOf(rs.getInt("id"));
                            System.out.println("el id de la nota " + this.idNota);
                            this.modeloHistorico.setValueAt(Integer.valueOf(rs.getInt("id")), this.JTResultadoH.getRowCount() - 1, 0);
                            this.modeloHistorico.setValueAt(rs.getDate("fechaNota"), this.JTResultadoH.getRowCount() - 1, 1);
                            this.modeloHistorico.setValueAt(Integer.valueOf(rs.getInt("idConceptoNota")), this.JTResultadoH.getRowCount() - 1, 2);
                            this.modeloHistorico.setValueAt(Integer.valueOf(rs.getInt("idLiquidacion")), this.JTResultadoH.getRowCount() - 1, 3);
                            this.modeloHistorico.setValueAt(rs.getString("descripcionGeneral"), this.JTResultadoH.getRowCount() - 1, 4);
                            this.modeloHistorico.setValueAt(Integer.valueOf(rs.getInt("numeroConsecutivo")), this.JTResultadoH.getRowCount() - 1, 5);
                            this.modeloHistorico.setValueAt(rs.getString("prefijo"), this.JTResultadoH.getRowCount() - 1, 6);
                            this.modeloHistorico.setValueAt(Boolean.valueOf(rs.getBoolean("notaSinFactura")), this.JTResultadoH.getRowCount() - 1, 7);
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
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void springStart() {
    }

    private void crearModeloTablaResultadoHistorico() {
        this.modeloResultadoHistorico = new DefaultTableModel((Object[][]) null, new String[]{"idFacturaNota", "tipo", "idCodigo", "cantidad", "valorUnitario", "valorNota", "nombreItem", "observacion", "porcentajeImpuesto"}) { // from class: Armado.JD_NotasP.25
            Class[] types = {Integer.class, Integer.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.modeloResultadoHistorico);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Armado/JD_NotasP$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8) == null || table.getValueAt(row, 8).toString().equals("")) {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            } else if (table.getValueAt(row, 8) == null || table.getValueAt(row, 8).toString().equals("SUCCESS")) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
