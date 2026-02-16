package Presupuesto;

import Acceso.Principal;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl;
import com.genoma.plus.dao.presupuesto.PresupuestoDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFFMovimiento.class */
public class JIFFMovimiento extends JInternalFrame {
    private String[] xIdTercero;
    private String[] xIdRubros;
    private String[][] xIdDocumento;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloEvidencia;
    private Object[] xdatos;
    private File xfile;
    public String xIdClaseDoc;
    public int xIdMovDisponibilidad;
    private PresupuestoDAO presupuestoDAO;
    public String xIdSolicitud;
    private JDBusquedaDocPTO busquedaDocPTO;
    private JButton JBAdicion;
    private JButton JBAdicionar;
    private JButton JBAgregar;
    private JButton JBBuscar;
    private JButton JBReintegro;
    private JComboBox JCBRubros;
    private JComboBox JCBTipoDocumento;
    private JFormattedTextField JFTFValor;
    public JFormattedTextField JFTFValorDoc;
    private JFormattedTextField JFTFValorSaldoR;
    private JFormattedTextField JFTFValorTotal;
    public JLabel JLB_Registro;
    public JLabel JLCodigoDoc;
    public JTable JTDetalle;
    private JTable JTDetalleEvidencia;
    private JTextField JTFCodigoRbro;
    public JTextField JTFNoFactura;
    private JTextField JTFNombreArc;
    private JTextField JTFObservacion;
    private JTextField JTFRutaEvidencia;
    public JTextArea JTObservacion;
    public JTextArea JTObservacionArch;
    private ButtonGroup TipoMov;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTabbedPane jTabbedPane1;
    public JDateChooser txtFecha;
    public JDateChooser txtFechaFact;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean xllenoRubro = false;
    private int xFila = 0;
    public String xMovimiento = "";
    private int xTipo = 1;
    private long xConsecutivo = 0;
    public long xId_Movimiento = 0;
    public boolean conAdicion = false;

    public JIFFMovimiento(String xIdClaseDoc) {
        initComponents();
        springStart();
        Principal.mLimpiarDatosP();
        this.xIdClaseDoc = xIdClaseDoc;
        if (this.xIdClaseDoc.equals("4")) {
            setTitle("COMPROMISO PRESUPUESTAL");
        } else if (this.xIdClaseDoc.equals("9")) {
            setTitle("DISPONIBILIDAD PRESUPUESTAL");
        }
        mIniciaComponentes();
        mHabilitaComponentes();
    }

    private void springStart() {
        this.presupuestoDAO = (PresupuestoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("presupuestoDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r3v180, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v96, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.TipoMov = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCBTipoDocumento = new JComboBox();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.jScrollPane1 = new JScrollPane();
        this.JTObservacion = new JTextArea();
        this.JBBuscar = new JButton();
        this.JLCodigoDoc = new JLabel();
        this.txtFechaFact = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFNoFactura = new JTextField();
        this.JFTFValorDoc = new JFormattedTextField();
        this.jPanel2 = new JPanel();
        this.JCBRubros = new JComboBox();
        this.JTFCodigoRbro = new JTextField();
        this.JFTFValor = new JFormattedTextField();
        this.JBAdicionar = new JButton();
        this.JTFObservacion = new JTextField();
        this.JFTFValorSaldoR = new JFormattedTextField();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JFTFValorTotal = new JFormattedTextField();
        this.jPanel5 = new JPanel();
        this.JBReintegro = new JButton();
        this.JBAdicion = new JButton();
        this.JLB_Registro = new JLabel();
        this.jPanel4 = new JPanel();
        this.jPanel6 = new JPanel();
        this.JTFNombreArc = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.JTObservacionArch = new JTextArea();
        this.JTFRutaEvidencia = new JTextField();
        this.JBAgregar = new JButton();
        this.jScrollPane4 = new JScrollPane();
        this.JTDetalleEvidencia = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MOVIMIENTO DE RUBROS PRESUPUESTALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifMovimientoPPTO");
        addInternalFrameListener(new InternalFrameListener() { // from class: Presupuesto.JIFFMovimiento.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFMovimiento.this.formInternalFrameClosing(evt);
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
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFMovimiento.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFMovimiento.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFFMovimiento.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFMovimiento.this.txtFechaPropertyChange(evt);
            }
        });
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFMovimiento.4
            public void keyPressed(KeyEvent evt) {
                JIFFMovimiento.this.txtFechaKeyPressed(evt);
            }
        });
        this.JTObservacion.setColumns(1);
        this.JTObservacion.setFont(new Font("Arial", 1, 12));
        this.JTObservacion.setLineWrap(true);
        this.JTObservacion.setRows(1);
        this.JTObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Objeto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTObservacion);
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setToolTipText("Adjuntar Documento");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimiento.5
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JLCodigoDoc.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc.setForeground(Color.red);
        this.JLCodigoDoc.setHorizontalAlignment(0);
        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaFact.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Doc.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaFact.setDateFormatString("dd/MM/yyyy");
        this.txtFechaFact.setFont(new Font("Tahoma", 1, 12));
        this.txtFechaFact.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFMovimiento.6
            public void keyPressed(KeyEvent evt) {
                JIFFMovimiento.this.txtFechaFactKeyPressed(evt);
            }
        });
        this.JTFNoFactura.setFont(new Font("Arial", 1, 18));
        this.JTFNoFactura.setForeground(Color.red);
        this.JTFNoFactura.setHorizontalAlignment(0);
        this.JTFNoFactura.setToolTipText("");
        this.JTFNoFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoFactura.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimiento.7
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento.this.JTFNoFacturaActionPerformed(evt);
            }
        });
        this.JTFNoFactura.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JIFFMovimiento.8
            public void focusLost(FocusEvent evt) {
                JIFFMovimiento.this.JTFNoFacturaFocusLost(evt);
            }
        });
        this.JFTFValorDoc.setEditable(false);
        this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorDoc.setForeground(Color.red);
        this.JFTFValorDoc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorDoc.setHorizontalAlignment(0);
        this.JFTFValorDoc.setText("0");
        this.JFTFValorDoc.setFont(new Font("Arial", 1, 14));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtFecha, -2, 130, -2).addComponent(this.txtFechaFact, -2, 130, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBTipoDocumento, -2, 486, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCodigoDoc, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscar, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorDoc, -1, 135, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNoFactura, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtFecha, -1, -1, 32767).addComponent(this.JCBTipoDocumento).addComponent(this.JBBuscar, -1, -1, 32767).addComponent(this.JLCodigoDoc, -1, -1, 32767).addComponent(this.JFTFValorDoc, GroupLayout.Alignment.TRAILING, -2, 52, -2)).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, -2, 63, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNoFactura, GroupLayout.Alignment.TRAILING).addComponent(this.txtFechaFact, GroupLayout.Alignment.TRAILING, -1, 52, 32767))).addContainerGap(-1, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "RUBROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBRubros.setFont(new Font("Arial", 1, 12));
        this.JCBRubros.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRubros.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFMovimiento.9
            public void itemStateChanged(ItemEvent evt) {
                JIFFMovimiento.this.JCBRubrosItemStateChanged(evt);
            }
        });
        this.JTFCodigoRbro.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoRbro.setToolTipText("");
        this.JTFCodigoRbro.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoRbro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimiento.10
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento.this.JTFCodigoRbroActionPerformed(evt);
            }
        });
        this.JTFCodigoRbro.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JIFFMovimiento.11
            public void focusLost(FocusEvent evt) {
                JIFFMovimiento.this.JTFCodigoRbroFocusLost(evt);
            }
        });
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValor.setHorizontalAlignment(0);
        this.JFTFValor.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimiento.12
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento.this.JBAdicionarActionPerformed(evt);
            }
        });
        this.JTFObservacion.setFont(new Font("Arial", 1, 12));
        this.JTFObservacion.setToolTipText("");
        this.JTFObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorSaldoR.setEditable(false);
        this.JFTFValorSaldoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorSaldoR.setForeground(Color.red);
        this.JFTFValorSaldoR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorSaldoR.setHorizontalAlignment(0);
        this.JFTFValorSaldoR.setText("0");
        this.JFTFValorSaldoR.setFont(new Font("Arial", 1, 14));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAdicionar, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFCodigoRbro, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRubros, -2, 531, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValor, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorSaldoR)).addComponent(this.JTFObservacion, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigoRbro, -2, 53, -2).addComponent(this.JCBRubros, -2, 52, -2))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFValor, -2, 52, -2).addComponent(this.JFTFValorSaldoR, -2, 52, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFObservacion, -2, 50, -2).addGap(5, 5, 5).addComponent(this.JBAdicionar, -2, 39, -2).addGap(5, 5, 5)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFMovimiento.13
            public void mouseClicked(MouseEvent evt) {
                JIFFMovimiento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFFMovimiento.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFMovimiento.this.JTDetallePropertyChange(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFMovimiento.15
            public void keyPressed(KeyEvent evt) {
                JIFFMovimiento.this.JTDetalleKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.JFTFValorTotal.setEditable(false);
        this.JFTFValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorTotal.setForeground(Color.red);
        this.JFTFValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorTotal.setHorizontalAlignment(0);
        this.JFTFValorTotal.setText("0");
        this.JFTFValorTotal.setFont(new Font("Arial", 1, 14));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "Operaciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBReintegro.setFont(new Font("Arial", 1, 12));
        this.JBReintegro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/devolver.png")));
        this.JBReintegro.setText("Reintegro");
        this.JBReintegro.setToolTipText("Reintegro");
        this.JBReintegro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimiento.16
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento.this.JBReintegroActionPerformed(evt);
            }
        });
        this.JBAdicion.setFont(new Font("Arial", 1, 12));
        this.JBAdicion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBAdicion.setText("Adición");
        this.JBAdicion.setToolTipText("Adición");
        this.JBAdicion.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimiento.17
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento.this.JBAdicionActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JBReintegro, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.JBAdicion, -2, 130, -2).addGap(22, 22, 22)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBReintegro, -1, 50, 32767).addComponent(this.JBAdicion, -1, 50, 32767))));
        this.JLB_Registro.setFont(new Font("Arial", 1, 14));
        this.JLB_Registro.setForeground(Color.red);
        this.JLB_Registro.setHorizontalAlignment(0);
        this.JLB_Registro.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JLB_Registro, -2, 154, -2).addGap(18, 18, 18).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JFTFValorTotal, -2, 169, -2)).addComponent(this.jScrollPane2)).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel1, -2, 149, -2).addGap(5, 5, 5).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 216, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorTotal, -2, 66, -2).addGap(0, 0, 32767)).addGroup(jPanel3Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLB_Registro, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767)))).addGap(961, 961, 961)));
        this.jTabbedPane1.addTab("DATOS", this.jPanel3);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombreArc.setFont(new Font("Arial", 1, 12));
        this.JTFNombreArc.setToolTipText("");
        this.JTFNombreArc.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreArc.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimiento.18
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento.this.JTFNombreArcActionPerformed(evt);
            }
        });
        this.JTObservacionArch.setColumns(1);
        this.JTObservacionArch.setFont(new Font("Arial", 1, 12));
        this.JTObservacionArch.setRows(1);
        this.JTObservacionArch.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setViewportView(this.JTObservacionArch);
        this.JTFRutaEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTFRutaEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaEvidencia.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFMovimiento.19
            public void mouseClicked(MouseEvent evt) {
                JIFFMovimiento.this.JTFRutaEvidenciaMouseClicked(evt);
            }
        });
        this.JTFRutaEvidencia.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimiento.20
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento.this.JTFRutaEvidenciaActionPerformed(evt);
            }
        });
        this.JBAgregar.setFont(new Font("Tahoma", 1, 12));
        this.JBAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAgregar.setText("Agregar");
        this.JBAgregar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovimiento.21
            public void actionPerformed(ActionEvent evt) {
                JIFFMovimiento.this.JBAgregarActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.JTFNombreArc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRutaEvidencia, -2, 551, -2)).addComponent(this.JBAgregar, -1, -1, 32767).addComponent(this.jScrollPane3)).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombreArc, -1, 53, 32767).addComponent(this.JTFRutaEvidencia)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregar, -1, 37, 32767).addContainerGap()));
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "EVIDENCIA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEvidencia.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleEvidencia.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleEvidencia.setSelectionForeground(Color.red);
        this.JTDetalleEvidencia.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFMovimiento.22
            public void mouseClicked(MouseEvent evt) {
                JIFFMovimiento.this.JTDetalleEvidenciaMouseClicked(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.JTDetalleEvidencia);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jScrollPane4, GroupLayout.Alignment.TRAILING, -1, 975, 32767)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 313, -2).addContainerGap(148, 32767)));
        this.jTabbedPane1.addTab("SOPORTES", this.jPanel4);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jTabbedPane1).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, 704, -2).addGap(0, 0, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
        if (!this.xIdClaseDoc.equals("4")) {
            mHabilitaComponentes();
        }
    }

    private void mHabilitaComponentes() {
        if (this.xlleno && this.JCBTipoDocumento.getSelectedIndex() > -1) {
            this.xllenoRubro = false;
            this.JLCodigoDoc.setText("");
            if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.txtFechaFact.setVisible(false);
                this.JTFNoFactura.setVisible(false);
                this.JFTFValor.setVisible(true);
                this.JTFObservacion.setVisible(true);
                this.JTFCodigoRbro.setVisible(true);
                this.JCBRubros.setVisible(true);
                this.jPanel2.setVisible(true);
                mCrearModeloDatosDispo();
            } else if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4") || this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("5") || this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("6")) {
                if (this.xIdClaseDoc.equals("4")) {
                    this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Disponibilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Disp.", 0, 0, new Font("Arial", 1, 12), Color.blue));
                }
                mOcultaPanelRubro();
                mCrearModeloDatosCompromiso();
            }
            this.JCBRubros.removeAllItems();
            String sql = "SELECT `pp_rubro_x_tipo_doc`.`IdRubro`,concat(`pp_rubros`.`Nbre`, ' - ', `pp_rubro_x_tipo_doc`.`IdRubro`) AS Rubro FROM `pp_rubro_x_tipo_doc` INNER JOIN  `pp_rubros` ON (`pp_rubro_x_tipo_doc`.`IdRubro` = `pp_rubros`.`Id`) AND (pp_rubro_x_tipo_doc.`idEncabezadoRubro`=pp_rubros.`idEncabezadoRubro`) WHERE (`pp_rubro_x_tipo_doc`.`Estado` =1 AND pp_rubro_x_tipo_doc.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `pp_rubro_x_tipo_doc`.`IdTipoDoc` ='" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "') ORDER BY `pp_rubro_x_tipo_doc`.`IdRubro` ASC;";
            System.out.println("Items COmbo-->" + sql);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xIdRubros = xct1.llenarCombo(sql, this.xIdRubros, this.JCBRubros);
            this.JCBRubros.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
            this.xllenoRubro = true;
            this.JTFCodigoRbro.setText("");
        }
        System.out.println("Principal.informacionIps.getTiposolicitudcdp()-->" + Principal.informacionIps.getTiposolicitudcdp());
        if (Principal.informacionIps.getTiposolicitudcdp() == 1) {
            mOcultaPanelRubro();
        }
    }

    private void mOcultaPanelRubro() {
        this.JFTFValor.setVisible(false);
        this.JTFObservacion.setVisible(false);
        this.JTFCodigoRbro.setVisible(false);
        this.JCBRubros.setVisible(false);
        this.jPanel2.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    public void mBuscaRubrosSolicitud(int idSolicitud) {
        mCrearModeloDatosDispo();
        this.xFila = 0;
        List<Object[]> listSol = this.presupuestoDAO.getListRubrosSolicitud(idSolicitud, Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
        if (listSol.size() > 0) {
            for (int i = 0; i < listSol.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt("", this.xFila, 0);
                this.xmodelo.setValueAt(listSol.get(i)[0], this.xFila, 1);
                this.xmodelo.setValueAt(listSol.get(i)[1], this.xFila, 2);
                this.xmodelo.setValueAt(listSol.get(i)[2], this.xFila, 3);
                this.xmodelo.setValueAt(listSol.get(i)[3], this.xFila, 4);
                this.xmodelo.setValueAt(0, this.xFila, 5);
                this.xmodelo.setValueAt(0, this.xFila, 6);
                this.xmodelo.setValueAt(0, this.xFila, 7);
                this.xmodelo.setValueAt(0, this.xFila, 8);
                this.xmodelo.setValueAt(false, this.xFila, 9);
                this.xFila++;
            }
        }
        mTotaliza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRubrosItemStateChanged(ItemEvent evt) {
        if (this.xllenoRubro && this.JCBRubros.getSelectedIndex() != -1 && this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
            this.JTFCodigoRbro.setText(this.xIdRubros[this.JCBRubros.getSelectedIndex()]);
            mSaldoRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
            mAdicionarDisponibilidad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
            JDBusquedaDocPTO x = new JDBusquedaDocPTO(null, true, this, this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1], this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][3]);
            x.setLocationRelativeTo(this);
            x.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDocumento.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaEvidenciaMouseClicked(MouseEvent evt) {
        JFileChooser xfilec;
        if (evt.getClickCount() == 2) {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                xfilec = new JFileChooser("P:\\Soporte Ficha 5W1H\\");
            } else {
                xfilec = new JFileChooser("S:\\Soportes acciones 5W1H\\");
            }
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRutaEvidencia.setText(this.xfile.getAbsolutePath());
                this.JTFRutaEvidencia.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaEvidenciaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarActionPerformed(ActionEvent evt) {
        if (!this.JLB_Registro.getText().isEmpty()) {
            if (!this.JTFNombreArc.getText().isEmpty()) {
                if (!this.JTFRutaEvidencia.getText().isEmpty()) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = " INSERT INTO  `pp_movimiento_evidencia` (  `Id_Movimiento`,`Nbre`,`url`,`Observacion`,`Estado`,`Id_UsuarioR`)\n VALUES ( '" + this.xMovimiento + "','" + this.JTFNombreArc.getText() + "','" + this.JTFRutaEvidencia.getText() + "','" + this.JTObservacionArch.getText() + "','1','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "');";
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        this.JTFNombreArc.setText("");
                        this.JTFRutaEvidencia.setText("");
                        this.JTObservacionArch.setText("");
                        mBuscaEvidencia();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar la ruta del archivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFRutaEvidencia.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "El campo nombre no puede estar vacío", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombreArc.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreArcActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleEvidenciaMouseClicked(MouseEvent evt) {
        if (this.JTDetalleEvidencia.getSelectedRow() != -1) {
            this.xmt.mostrarPdf(this.xmodeloEvidencia.getValueAt(this.JTDetalleEvidencia.getSelectedRow(), 2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroFocusLost(FocusEvent evt) {
        if (!this.JTFCodigoRbro.getText().isEmpty()) {
            mVerificarRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroActionPerformed(ActionEvent evt) {
        if (!this.JTFCodigoRbro.getText().isEmpty()) {
            mVerificarRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        int columna = this.JTDetalle.columnAtPoint(evt.getPoint());
        int fila = this.JTDetalle.rowAtPoint(evt.getPoint());
        if (this.JTDetalle.getModel().getColumnClass(columna).equals(JButton.class) && this.JTDetalle.getSelectedRow() == fila) {
            JDPatologia x = new JDPatologia(null, true, this);
            x.setLocationRelativeTo(this);
            x.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFactKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoFacturaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoFacturaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            mTotaliza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBReintegroActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mAbreReintegro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionActionPerformed(ActionEvent evt) {
        if (!this.JLB_Registro.getText().isEmpty()) {
            JDAdiciones x = new JDAdiciones(null, true, this);
            x.setLocationRelativeTo(this);
            x.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            if (!this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).equals("")) {
                this.presupuestoDAO.actualizarEstadoDetalleMovimiento(Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            }
            this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
            this.xFila--;
            mTotaliza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
        this.txtFechaFact.setDate(this.txtFecha.getDate());
    }

    private void mAbreReintegro() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4")) {
                if (Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString()).doubleValue() > 0.0d) {
                    JDReintegro x = new JDReintegro(null, true, this, this.xIdClaseDoc);
                    x.setLocationRelativeTo(this);
                    x.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Este movimiento no tiene saldo disponible para reintegros", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
            System.out.println("this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1]-->" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1]);
            if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                System.out.println("entra a condicion 1");
                if (Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).doubleValue() > 0.0d) {
                    System.out.println("entra a condicion 2");
                    JDReintegro x2 = new JDReintegro(null, true, this, this.xIdClaseDoc);
                    x2.setLocationRelativeTo(this);
                    x2.setVisible(true);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Este movimiento no tiene saldo disponible para reintegros", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdDetalle", "CodRubro", "Nombre Rubro", "IdTercero", "Tercero", "Valor", "Observacion", "Estado", "Tipo"}) { // from class: Presupuesto.JIFFMovimiento.23
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(5);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDispo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdDetalle", "CodRubro", "Nombre Rubro", "Valor", "Observacion", "Adicion", "Reintegros", "Comprometido", "PorEjecutar", "Estado"}) { // from class: Presupuesto.JIFFMovimiento.24
            Class[] types = {String.class, String.class, String.class, Double.class, String.class, Double.class, Double.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    private void mAdicionarCompromiso() {
        if (!mVerificaRubroTabla()) {
            if (!this.JTFCodigoRbro.getText().isEmpty()) {
                if (this.JCBRubros.getSelectedIndex() > -1) {
                    if (!this.JFTFValor.getText().equals("0")) {
                        this.xmodelo.addRow(this.xdatos);
                        this.xmodelo.setValueAt("", this.xFila, 0);
                        this.xmodelo.setValueAt(this.xIdRubros[this.JCBRubros.getSelectedIndex()], this.xFila, 1);
                        this.xmodelo.setValueAt(this.JCBRubros.getSelectedItem(), this.xFila, 2);
                        this.xmodelo.setValueAt(this.JFTFValor.getValue(), this.xFila, 5);
                        this.xmodelo.setValueAt(this.JTFObservacion.getText(), this.xFila, 6);
                        this.xmodelo.setValueAt(false, this.xFila, 7);
                        if (this.xTipo == 0) {
                            this.xmodelo.setValueAt("D", this.xFila, 8);
                        } else {
                            this.xmodelo.setValueAt("C", this.xFila, 8);
                        }
                        this.xFila++;
                        mLimipia();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "El valor debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JFTFValor.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Seleccione un rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBRubros.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "el Código del rubro no puede estar vacío", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCodigoRbro.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Ya existe este rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mAdicionarDisponibilidad() {
        if (this.JCBRubros.getSelectedIndex() > -1) {
            if (!mVerificaRubroTabla()) {
                if (this.JTFCodigoRbro.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "el Código del rubro no puede estar vacío", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFCodigoRbro.requestFocus();
                    return;
                }
                if (Double.valueOf(this.JFTFValor.getValue().toString()).doubleValue() <= 0.0d) {
                    JOptionPane.showMessageDialog(this, "el valor debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JFTFValor.requestFocus();
                    return;
                }
                if (Double.valueOf(this.JFTFValor.getValue().toString()).doubleValue() <= Double.valueOf(this.JFTFValorSaldoR.getValue().toString()).doubleValue()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt("", this.xFila, 0);
                    this.xmodelo.setValueAt(this.xIdRubros[this.JCBRubros.getSelectedIndex()], this.xFila, 1);
                    this.xmodelo.setValueAt(this.JCBRubros.getSelectedItem(), this.xFila, 2);
                    this.xmodelo.setValueAt(this.JFTFValor.getValue(), this.xFila, 3);
                    this.xmodelo.setValueAt(this.JTFObservacion.getText(), this.xFila, 4);
                    this.xmodelo.setValueAt(0, this.xFila, 5);
                    this.xmodelo.setValueAt(0, this.xFila, 6);
                    this.xmodelo.setValueAt(0, this.xFila, 7);
                    this.xmodelo.setValueAt(0, this.xFila, 8);
                    this.xmodelo.setValueAt(false, this.xFila, 9);
                    this.xFila++;
                    mTotaliza();
                    mLimipia();
                    return;
                }
                JOptionPane.showMessageDialog(this, "el valor debe ser menor al saldo del Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JFTFValor.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Ya existe este rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Seleccione un rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBRubros.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCompromiso() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdDetalle", "CodRubro", "Nombre Rubro", "ValorComprometido", "IdTercero", "Tercero", "Observacion", "Estado", "", "DisponibilidadInicial", "AdicionCompr.", "PorEjecutar", "ReintegroCompromiso"}) { // from class: Presupuesto.JIFFMovimiento.25
            Class[] types = {String.class, String.class, String.class, Double.class, String.class, String.class, String.class, Boolean.class, JButton.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, true, false, false, true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Presupuesto.JIFFMovimiento.26
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(16);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(16);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(16);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(20);
    }

    private void mTotaliza() {
        double total = 0.0d;
        if (this.xIdClaseDoc.equals("4")) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                total = ((total + Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue()) + Double.valueOf(this.xmodelo.getValueAt(i, 10).toString()).doubleValue()) - Double.valueOf(this.xmodelo.getValueAt(i, 12).toString()).doubleValue();
            }
            this.JFTFValorTotal.setValue(Double.valueOf(total));
            return;
        }
        if (this.xIdClaseDoc.equals("9")) {
            for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                total += (Double.valueOf(this.xmodelo.getValueAt(i2, 3).toString()).doubleValue() + Double.valueOf(this.xmodelo.getValueAt(i2, 5).toString()).doubleValue()) - Double.valueOf(this.xmodelo.getValueAt(i2, 6).toString()).doubleValue();
            }
            this.JFTFValorTotal.setValue(Double.valueOf(total));
        }
    }

    private void mLimipia() {
        this.JTFCodigoRbro.setText("");
        this.JCBRubros.setSelectedIndex(-1);
        this.JFTFValor.setValue(0);
        this.JTFObservacion.setText("");
        this.JFTFValorSaldoR.setValue(0);
    }

    private void mIniciaComponentes() {
        this.JFTFValor.setValue(0);
        String sql = "SELECT pp_tipo_documentos.Id AS IdDoc, pp_tipo_documentos.Nbre AS NombreDoc,pp_tipo_documentos.Id_ClaseDoc,pp_clase_documento.`Nbre` AS NombreClaseDoc,pp_clase_documento.`IdPadre` FROM `pp_tipo_documentos`  INNER JOIN `pp_clase_documento` \n        ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE (pp_tipo_documentos.Estado=1 AND `pp_tipo_documentos`.`Id_ClaseDoc`='" + this.xIdClaseDoc + "') ORDER BY pp_tipo_documentos.Nbre ASC";
        this.xIdDocumento = this.xct.llenarComboyLista(sql, this.xIdDocumento, this.JCBTipoDocumento, 5);
        if (this.JCBTipoDocumento.getItemCount() == 1) {
            this.JCBTipoDocumento.setSelectedIndex(0);
            this.JCBTipoDocumento.setEnabled(false);
        } else {
            this.JCBTipoDocumento.setSelectedIndex(0);
        }
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.txtFechaFact.setDate(this.xmt.getFechaActual());
    }

    public void mGrabar() {
        if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.txtFecha.getDate()))) {
            if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
                if (this.JTDetalle.getRowCount() > 0) {
                    if (this.JLCodigoDoc.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Debe anexar un documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JBBuscar.requestFocus();
                        return;
                    }
                    if (Double.valueOf(this.JFTFValorTotal.getValue().toString()).doubleValue() <= Double.valueOf(this.JFTFValorDoc.getValue().toString()).doubleValue()) {
                        if (!xVerificaTercero()) {
                            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                if (this.JLB_Registro.getText().isEmpty()) {
                                    mConcecutivo();
                                    if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                                        String sql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,IdSolicitud,IdUsuarioR, NoConcecutivo, `UsuarioS`)  VALUES ( '" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "','" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "','" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.JTObservacion.getText() + "','" + this.xIdSolicitud + "' ,'" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xConsecutivo + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                        System.out.println("Inserta Encabezado Disponibilidad-->" + sql);
                                        this.xMovimiento = this.xct.ejecutarSQLId(sql);
                                        this.JLB_Registro.setText("" + this.xConsecutivo);
                                        this.xct.cerrarConexionBd();
                                        String sql2 = "UPDATE `pp_movimiento` SET `IdDisponibilidad`='" + this.xMovimiento + "' WHERE `Id`='" + this.xMovimiento + "'";
                                        this.xct.ejecutarSQL(sql2);
                                        this.xct.cerrarConexionBd();
                                    } else if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4")) {
                                        String sql3 = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,IdDisponibilidad, IdUsuarioR, NoConcecutivo, NoDocumento, `UsuarioS`)  VALUES ( '" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "','" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "','" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.JTObservacion.getText() + "','" + this.xIdMovDisponibilidad + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xConsecutivo + "','" + this.JTFNoFactura.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                        System.out.println("Inserta Encabezado Compromiso-->" + sql3);
                                        this.xMovimiento = this.xct.ejecutarSQLId(sql3);
                                        this.JLB_Registro.setText("" + this.xConsecutivo);
                                        this.xct.cerrarConexionBd();
                                        String sql22 = "UPDATE `pp_movimiento` SET `IdCompromiso`='" + this.xMovimiento + "' WHERE `Id`='" + this.xIdMovDisponibilidad + "'";
                                        this.xct.ejecutarSQL(sql22);
                                        this.xct.cerrarConexionBd();
                                        String sql32 = "UPDATE `pp_movimiento` SET `IdCompromiso`='" + this.xMovimiento + "' WHERE `Id`='" + this.xMovimiento + "'";
                                        this.xct.ejecutarSQL(sql32);
                                        this.xct.cerrarConexionBd();
                                    }
                                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                                        if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                                            if (!Boolean.valueOf(this.xmodelo.getValueAt(i, 9).toString()).booleanValue()) {
                                                this.xct.ejecutarSQL(" insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,Valor,Observacion, idEncabezado)\n values ('" + this.xMovimiento + "', '" + this.xmodelo.getValueAt(i, 1) + "','" + Principal.informacionIps.getIdEmpresa() + "','" + Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()) + "','" + this.xmodelo.getValueAt(i, 4) + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');");
                                                this.xct.cerrarConexionBd();
                                            }
                                        } else if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4") && !Boolean.valueOf(this.xmodelo.getValueAt(i, 7).toString()).booleanValue() && Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue() > 0.0d) {
                                            this.xct.ejecutarSQL(" insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,`Valor`,`Observacion`,idEncabezado)\n values ('" + this.xMovimiento + "', '" + this.xmodelo.getValueAt(i, 1) + "','" + this.xmodelo.getValueAt(i, 4) + "','" + this.xmodelo.getValueAt(i, 3) + "','" + this.xmodelo.getValueAt(i, 6) + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');");
                                            this.xct.cerrarConexionBd();
                                        }
                                    }
                                } else if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                                    if (!mVerificaCompromiso()) {
                                        String sql4 = "UPDATE  `pp_movimiento` SET  `Id_Periodo`='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "',`Id_TipoDoc`='" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "',`FechaD`='" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "',`Observacion`='" + this.JTObservacion.getText() + "', `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id='" + this.xMovimiento + "' ";
                                        this.xct.ejecutarSQL(sql4);
                                        this.xct.cerrarConexionBd();
                                        for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                                            if (!Boolean.valueOf(this.xmodelo.getValueAt(i2, 9).toString()).booleanValue()) {
                                                this.xct.ejecutarSQL(" insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,Valor, Observacion,idEncabezado)\n values ('" + this.xMovimiento + "', '" + this.xmodelo.getValueAt(i2, 1) + "','" + Principal.informacionIps.getIdEmpresa() + "','" + Double.valueOf(this.xmodelo.getValueAt(i2, 3).toString()) + "','" + this.xmodelo.getValueAt(i2, 4) + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');");
                                                this.xct.cerrarConexionBd();
                                            } else {
                                                this.xct.ejecutarSQL("UPDATE pp_detalle_movimiento SET Valor='" + Double.valueOf(this.xmodelo.getValueAt(i2, 3).toString()) + "', Observacion='" + this.xmodelo.getValueAt(i2, 4) + "' WHERE (Id_Movimiento='" + this.xMovimiento + "' AND Id_Rubro='" + this.xmodelo.getValueAt(i2, 1) + "' AND idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')");
                                                this.xct.cerrarConexionBd();
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "No se puede actualizar, la disponibilidad\nya tiene compromiso asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    }
                                } else if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4")) {
                                    if (!mVerificaObligacion()) {
                                        String sql5 = "UPDATE  `pp_movimiento` SET  `Id_Periodo`='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "',`Id_TipoDoc`='" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "',`FechaD`='" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "',`Observacion`='" + this.JTObservacion.getText() + "', `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id='" + this.xMovimiento + "' ";
                                        this.xct.ejecutarSQL(sql5);
                                        this.xct.cerrarConexionBd();
                                        for (int i3 = 0; i3 < this.JTDetalle.getRowCount(); i3++) {
                                            String sqld = "UPDATE pp_detalle_movimiento SET Id_Tercero='" + this.xmodelo.getValueAt(i3, 4).toString() + "',Valor='" + Double.valueOf(this.xmodelo.getValueAt(i3, 3).toString()) + "', Observacion='" + this.xmodelo.getValueAt(i3, 6) + "' WHERE (Id_Movimiento='" + this.xMovimiento + "' AND Id_Rubro='" + this.xmodelo.getValueAt(i3, 1) + "' AND idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
                                            System.out.println("sqlDetalle-->" + sqld);
                                            System.out.println("IdTercero-->" + this.xmodelo.getValueAt(i3, 4).toString());
                                            this.xct.ejecutarSQL(sqld);
                                            this.xct.cerrarConexionBd();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "No se puede actualizar, el Compromiso\nya tiene obligación asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    }
                                }
                                mBuscaMovimiento(this.xMovimiento);
                                return;
                            }
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "El Total no puede ser mayor a la Solicitud", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe agregar rubros a la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDocumento.requestFocus();
        }
    }

    private boolean mVerificaCompromiso() {
        boolean xExiste = false;
        String sql = "SELECT `IdCompromiso` FROM `pp_movimiento` WHERE `Id`= '" + this.xMovimiento + "'";
        System.out.println("Compromiso de la Disponibilidad-->" + sql);
        ConsultasMySQL xctC = new ConsultasMySQL();
        ResultSet xrs = xctC.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (!xrs.getString("IdCompromiso").equals("0")) {
                    xExiste = true;
                } else {
                    xExiste = false;
                }
            }
            xrs.close();
            xctC.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    private boolean mVerificaObligacion() {
        boolean xExiste = false;
        String sql = "SELECT `pp_movimiento`.`Id`\nFROM `pp_movimiento` INNER JOIN  `pp_tipo_documentos`   ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` =5 AND `pp_movimiento`.`IdCompromiso` ='" + this.xMovimiento + "');";
        System.out.println("Obligacion del compromiso-->" + sql);
        ConsultasMySQL xctC = new ConsultasMySQL();
        ResultSet xrs = xctC.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xExiste = true;
            }
            xrs.close();
            xctC.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    private void mBuscaValorSolicitud(String xid) {
        String sql;
        if (Principal.informacionIps.getTiposolicitudcdp() == 0) {
            sql = "SELECT nconsecutivo, `VPresupuestado` FROM `cc_r_requisicion` WHERE `Id`='" + xid + "'";
        } else {
            sql = "SELECT  nconsecutivo, Valor as VPresupuestado FROM pp_solicitud_pto  WHERE `Id`='" + xid + "'";
        }
        System.out.println("valor Solicitud de la disponibilidad-->" + sql);
        ConsultasMySQL xctC = new ConsultasMySQL();
        ResultSet xrs = xctC.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JFTFValorDoc.setValue(Double.valueOf(xrs.getString("VPresupuestado")));
                this.JLCodigoDoc.setText(xrs.getString("nconsecutivo"));
            }
            xrs.close();
            xctC.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaRubroTabla() {
        boolean xExiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalle.getRowCount()) {
                break;
            }
            if (!this.xmodelo.getValueAt(i, 1).toString().equals(this.xIdRubros[this.JCBRubros.getSelectedIndex()])) {
                i++;
            } else {
                xExiste = true;
                break;
            }
        }
        return xExiste;
    }

    public void mBuscaMovimientoOrigineal(String xId) {
        mCrearModeloDatos();
        String sql = "SELECT `pp_movimiento`.`Id` AS IdMovimiento, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS TipoDocumento, `pp_movimiento`.`Observacion`\n    , `pp_detalle_movimiento`.`Id_Rubro`, `pp_rubros`.`Nbre` AS NombreRubro, `pp_detalle_movimiento`.`Valor`, `pp_detalle_movimiento`.`Id_Tercero`,IF(`g_empresa`.Nbre='',CONCAT(`g_empresa`.Apellido1,' ',`g_empresa`.Apellido2,' ',`g_empresa`.Nombre1,' ',`g_empresa`.Nombre2),`g_empresa`.Nbre) AS NTercero \n    , `pp_detalle_movimiento`.`Observacion` AS ObsDetalle, `pp_detalle_movimiento`.`Estado`, pp_movimiento.IdSolicitud, pp_movimiento.IdDisponibilidad, pp_detalle_movimiento.Tipo \n FROM `pp_detalle_movimiento` INNER JOIN   `pp_movimiento` ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN   `pp_rubros`   ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`)\n    INNER JOIN   `g_empresa`   ON (`pp_detalle_movimiento`.`Id_Tercero` = `g_empresa`.`Id`)\n    INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n WHERE (`pp_movimiento`.`Id` ='" + xId + "' AND pp_movimiento.Id_MotivoAnulacion=1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs = xct2.traerRs(sql);
        System.out.println("Movimiento-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                System.out.println(" entro aqui 2");
                this.xMovimiento = xrs.getString("IdMovimiento");
                this.txtFecha.setDate(xrs.getDate("FechaD"));
                this.JCBTipoDocumento.setSelectedItem(xrs.getString("TipoDocumento"));
                this.JTObservacion.setText(xrs.getString("Observacion"));
                if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                    this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    this.JLCodigoDoc.setText(xrs.getString("IdSolicitud"));
                    this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                } else if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4")) {
                    this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Disponibilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    this.JLCodigoDoc.setText(xrs.getString("IdDisponibilidad"));
                    this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Disp.", 0, 0, new Font("Arial", 1, 12), Color.blue));
                }
                this.xFila = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt("", this.xFila, 0);
                    this.xmodelo.setValueAt(xrs.getString("Id_Rubro"), this.xFila, 1);
                    this.xmodelo.setValueAt(xrs.getString("NombreRubro"), this.xFila, 2);
                    this.xmodelo.setValueAt(xrs.getString("Id_Tercero"), this.xFila, 3);
                    this.xmodelo.setValueAt(xrs.getString("NTercero"), this.xFila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Valor")), this.xFila, 5);
                    this.xmodelo.setValueAt(xrs.getString("ObsDetalle"), this.xFila, 6);
                    this.xmodelo.setValueAt(true, this.xFila, 7);
                    if (xrs.getInt("Tipo") == 0) {
                        this.xmodelo.setValueAt("D", this.xFila, 8);
                    } else {
                        this.xmodelo.setValueAt("C", this.xFila, 8);
                    }
                    this.xFila++;
                }
                mBuscaEvidencia();
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscaMovimiento(String xId) {
        String sql = null;
        if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
            mCrearModeloDatosDispo();
            sql = "SELECT  D.IdMovimiento, D.NoConcecutivo,  D.FechaD ,D.TipoDocumento ,D.Observacion ,D.NoDocumento\n                    ,SUM(D.DISPONIBILIDAD) AS DISPONIBILIDAD_INICIAL\n                    ,SUM(D.ADICION) AS ADICION\n                    , SUM(D.REINTEGRO) AS REINTEGROS\n                    , IFNULL(C.REINTEGRO_COMPROMISO,0) AS REINTEGRO_COMPROMISO\n                    ,(IFNULL(C.Compromiso,0)+IFNULL(C.ADICION,0)-IFNULL(C.REINTEGRO_COMPROMISO,0)) COMPROMISO\n                    , IFNULL(C.ADICION,0) AS ADICIONCOMPROMISO\n                    ,((SUM(D.Disponibilidad)+SUM(D.ADICION)-SUM(D.REINTEGRO))-(IFNULL(C.Compromiso,0)+IFNULL(C.ADICION,0) -IFNULL(C.REINTEGRO_COMPROMISO,0))) Por_Ejecutar\n                     ,Estado\n                    ,D.IdDisponibilidad\n                    ,D.Id_Rubro\n                    , D.NombreRubro\n                    ,D.ObsDetalle\n                     ,D.Estado\n                     ,D.IdSolicitud\n                     ,D.Tipo\n                     ,D.Id_Tercero\n                     ,D.NTercero, D.idDetalleMovimiento\n                     FROM \n                    (SELECT  pp_movimiento.`Id` AS IdMovimiento,pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                      , pp_tipo_documentos.Nbre AS TipoDocumento \n                           , pp_movimiento.Observacion , `pp_movimiento`.NoDocumento \n                           , g_motivoanulacion.Nbre AS EstadoAnu \n                           , CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 9 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND DISPONIBILIDAD\n\t\t\t, CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 10 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND ADICION\n\t\t\t, CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 11 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND REINTEGRO\n                           ,pp_movimiento.IdDisponibilidad\n                           , pp_detalle_movimiento.`Id_Rubro`\n                           , pp_rubros.`Nbre` AS NombreRubro\n                           ,pp_detalle_movimiento.`Observacion` AS ObsDetalle\n                           ,`pp_detalle_movimiento`.`Id_Tercero`\n                           ,IF(`g_empresa`.Nbre='',CONCAT(`g_empresa`.Apellido1,' ',`g_empresa`.Apellido2,' ',`g_empresa`.Nombre1,' ',`g_empresa`.Nombre2),`g_empresa`.Nbre) AS NTercero\n                           ,`pp_detalle_movimiento`.`Estado` , pp_movimiento.IdSolicitud,  pp_detalle_movimiento.Tipo, pp_detalle_movimiento.Id  idDetalleMovimiento \n                          FROM pp_movimiento  \n                                    INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                    INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                    INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                    INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.`Id_Rubro` = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`)  \n                                    INNER JOIN   `g_empresa`   ON (`pp_detalle_movimiento`.`Id_Tercero` = `g_empresa`.`Id`)\n                                    WHERE (pp_tipo_documentos.Id_ClaseDoc IN (9,10,11) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Estado`=1)\n                          GROUP BY pp_detalle_movimiento.`Id_Rubro` , pp_movimiento.IdDisponibilidad,  pp_movimiento.Id -- , pp_tipo_documentos.Id_ClaseDoc\n                          ORDER BY  pp_movimiento.`Id` ASC,  pp_movimiento.FechaD DESC) D\n                          LEFT JOIN \n                         (SELECT   -- pp_movimiento.IdDisponibilidad,\n                                                                --  pp_movimiento.`Id` AS IdMovimiento, \n                                                                pp_movimiento.IdDisponibilidad , pp_detalle_movimiento.`Id_Rubro`, pp_movimiento.`IdCompromiso`,\n                                                               -- ,\n                                                               SUM(CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 4 THEN \n                                                                --  SUM(pp_detalle_movimiento.Valor) \n                                                                pp_detalle_movimiento.Valor\n                                                                 ELSE 0\n                                                                 END) COMPROMISO\n                                                               ,SUM(CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 12 THEN \n                                                                 -- SUM(pp_detalle_movimiento.Valor) \n                                                                 pp_detalle_movimiento.Valor\n                                                                 ELSE 0\n                                                                 END) ADICION\n                                                                 ,SUM(CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 13 THEN \n                                                                 -- SUM(pp_detalle_movimiento.Valor) \n                                                                 pp_detalle_movimiento.Valor\n                                                                 ELSE 0\n                                                                 END) REINTEGRO_COMPROMISO\n                                                                 , g_empresa.`Apellido2`\n                                                                 ,g_empresa.`Id`\n                                                                 ,g_empresa.`Nbre`\n                                                                    FROM pp_movimiento  \n                                                                    INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                                                    INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                                                    INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n\t\t\t\t\t\t\t\t\tINNER JOIN `g_empresa` ON (pp_detalle_movimiento.`Id_Tercero`=`g_empresa`.`Id`)\n                                                                    WHERE (pp_tipo_documentos.Id_ClaseDoc IN (4,12,13,5,15) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Estado`=1) \n                                                                    GROUP BY pp_detalle_movimiento.`Id_Rubro` ,pp_movimiento.`IdCompromiso`                          ) C\n                         ON D.IdDisponibilidad=C.IdDisponibilidad  AND D.Id_Rubro=C.Id_Rubro\n                         WHERE(D.IdDisponibilidad='" + xId + "')\n                         GROUP BY  D.IdDisponibilidad,  D.Id_Rubro";
        } else if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4")) {
            mCrearModeloDatosCompromiso();
            sql = "with maestra as  (\n\tselect \n\tpm.FechaD  fechaDocumento,\n\tptd.Nbre tipoDocumento,\n\tpm.Id idMovimiento, \n\tpm.Observacion observacion,\n\td.NoDocumento  numeroDocumentoDisponibilidad,\n\tifnull(d.Id,0)  idDisponibilidad, \n\tifnull(d.NoConcecutivo,0) consecutivoDisponibilida,\n\tifnull(c.Id,0)  idCompromiso, \n\tifnull(c.NoConcecutivo,0) consecutivoCopromiso,\n\tifnull(o.Id,0)  idObligacion, \n\tifnull(o.NoConcecutivo,0) consecutivoObligacion,\n\tif(ge.Nbre ='', concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1,' ', ge.Nombre2), ge.Nbre ) tercero, \n\tpr.Id  codigoRubro,\n\tpr.Nbre  nombreRubro,\n\tpdm.Valor valor,\n\tpdm.Observacion observacionDetalle,\n\tpdm.NFactura,\n\tpdm.Estado estado, \n\td.IdSolicitud idSolicitudDisponibilidad,\n\tpdm.Tipo,\n\tpdm.Id_Tercero  idTerceroCompromiso, \n\tpdm.Id  idDetalleMovimento, psp.Valor valorSolicitud,\n\tpr.idEncabezadoRubro \n\tfrom pp_movimiento pm \n\tinner join pp_detalle_movimiento pdm on (pm.Id=pdm.Id_Movimiento)\n\tinner join pp_tipo_documentos ptd on (ptd.Id=pm.Id_TipoDoc)\n\tinner join pp_rubros pr on (pr.Id=pdm.Id_Rubro)\n\tinner join g_empresa ge on (ge.Id=pdm.Id_Tercero)\n\tleft join pp_movimiento d  on (d.Id=pm.IdDisponibilidad)\n\tleft join pp_movimiento c  on (c.Id=pm.IdCompromiso )\n\tleft join pp_movimiento o  on (c.Id=pm.IdObligacion)\n\tleft join pp_solicitud_pto psp  on (psp.Id =d.IdSolicitud)\n\twhere (pm.Id='" + xId + "' and pm.Id_MotivoAnulacion=1 and pdm.Estado=1 AND pr.idEncabezadoRubro ='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') GROUP BY pm.Id\n)\n,\ntotalesPorClaseDocumento as (\n\tselect  pm.Id , \n\tptd.Id_ClaseDoc  idClaseDocumento, \n\tptd.Nbre nombreDocumento,\n\tpm.IdDisponibilidad idDisponibilidad,\n\tpm.IdCompromiso idCompromiso,\n\tpm.IdObligacion idObligacion,\n\tpdm.Id_Rubro idRubro,\n\tpdm.Id_Tercero idTercero,\n\tpdm.Valor valor,\n\tpcd.Nbre  claseDocumento,pdm.idRubrosCpc,\n\tif(ptd.Id_ClaseDoc = 9,  pdm.Valor, 0) valorDisponibilidad,\n\tif(ptd.Id_ClaseDoc = 10,  pdm.Valor, 0) valorAdicionDisponibilidad,\n\tif(ptd.Id_ClaseDoc = 11,  pdm.Valor, 0) valorReintegroDisponibilidad,\n\tif(ptd.Id_ClaseDoc = 4,  pdm.Valor, 0) valorCompromiso,\n\tif(ptd.Id_ClaseDoc = 12,  pdm.Valor, 0) valorAdicionCompromiso,\n\tif(ptd.Id_ClaseDoc = 13,  pdm.Valor, 0) valorReintegroCompromiso,\n\tif(ptd.Id_ClaseDoc = 5,  pdm.Valor, 0) valorObligacion,\n\tif(ptd.Id_ClaseDoc = 14,  pdm.Valor, 0) valorAdicionObligacion,\n\tif(ptd.Id_ClaseDoc = 15,  pdm.Valor, 0) valorReintegroObligacion,\n\tif(ptd.Id_ClaseDoc = 6,  pdm.Valor, 0) valorPagos\n\tfrom pp_movimiento pm \n\tinner join pp_detalle_movimiento pdm on (pm.Id=pdm.Id_Movimiento)\n\tinner join pp_tipo_documentos ptd on (ptd.Id=pm.Id_TipoDoc)\n\tinner join pp_clase_documento pcd on (pcd.Id=ptd.Id_ClaseDoc)\n\twhere pm.Id_MotivoAnulacion =1 and pm.IdCompromiso='" + xId + "' and pdm.Estado=1\n\t-- group by pm.Id , pdm.Id_Rubro , pdm.Id_Tercero \n\t\n)\n, \n\nsumatoraPorDocumento as (\n\tselect t.IdCompromiso, t.idRubro, \n\tsum(t.valorDisponibilidad) valorDisponibilidad,\n\tsum(t.valorAdicionDisponibilidad) valorAdicionDisponibilidad,\n\tsum(t.valorReintegroDisponibilidad) valorReintegroDisponibilidad,\n\tsum(t.valorCompromiso)valorCompromiso ,\n\tsum(t.valorAdicionCompromiso) valorAdicionCompromiso,\n\tsum(t.valorReintegroCompromiso)valorReintegroCompromiso ,\n\tsum(t.valorObligacion) valorObligacion,\n\tsum(t.valorAdicionObligacion) valorAdicionObligacion,\n\tsum(t.valorReintegroObligacion) valorReintegroObligacion,\n\tsum(t.valorPagos) valorPagos\n\t\t\t\n\tfrom totalesPorClaseDocumento t\n\t  group by t.idRubrosCpc\n)\n\n\nselect \nm.idMovimiento as IdMovimientoCompromiso,\nm.idDisponibilidad as IdMovimiento,\nm.consecutivoDisponibilida as NoConcecutivo, \nm.fechaDocumento FechaD ,\nm.tipoDocumento as TipoDocumento ,\nm.observacion as Observacion ,\nm.numeroDocumentoDisponibilidad as NoDocumento,\ns.valorDisponibilidad AS DISPONIBILIDAD_INICIAL,\ns.valorAdicionDisponibilidad AS ADICION\n,s.valorReintegroDisponibilidad AS REINTEGROS\n,s.valorCompromiso COMPROMISO\n, s.valorAdicionCompromiso AS ADICIONCOMPROMISO\n, s.valorReintegroCompromiso AS REINTEGRO_COMPROMISO\n,((((s.valorCompromiso+s.valorAdicionCompromiso +s.valorReintegroObligacion- s.valorReintegroDisponibilidad)-  s.valorAdicionObligacion)-s.valorReintegroCompromiso)-valorObligacion) Por_Ejecutar\n,m.estado as Estado\n,m.idDisponibilidad as IdDisponibilidad\n,m.codigoRubro as Id_Rubro\n,m.nombreRubro NombreRubro\n,m.observacionDetalle as ObsDetalle\n,m.estado as Estado\n,m.idSolicitudDisponibilidad as IdSolicitud\n                                        ,m.Tipo\n                                        ,m.idTerceroCompromiso as Id_Tercero\n                                        ,m.tercero as NTercero\n                                        , m.idDetalleMovimento as idDetalleMovimiento\n , m.tercero as Empresa , m.valorSolicitud                               \nfrom maestra m  \nleft join sumatoraPorDocumento s on (s.idCompromiso=m.idCompromiso)  and (s.idRubro=m.codigoRubro)";
        }
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs = xct2.traerRs(sql);
        System.out.println("Movimiento-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (this.xIdClaseDoc.equals("9")) {
                    this.xMovimiento = xrs.getString("IdDisponibilidad");
                } else if (this.xIdClaseDoc.equals("4")) {
                    System.out.println(" entro aqui 1");
                    this.xMovimiento = xrs.getString("IdMovimientoCompromiso");
                }
                this.txtFecha.setDate(xrs.getDate("FechaD"));
                this.JCBTipoDocumento.setSelectedItem(xrs.getString("TipoDocumento"));
                this.JTObservacion.setText(xrs.getString("Observacion"));
                this.xIdMovDisponibilidad = xrs.getInt("IdDisponibilidad");
                if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                    this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    this.xIdSolicitud = xrs.getString("IdSolicitud");
                    mBuscaValorSolicitud(xrs.getString("IdSolicitud"));
                } else if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4")) {
                    this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Disponibilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
                    this.JLCodigoDoc.setText(mConcecutivoDisponibilidad(xrs.getString("IdDisponibilidad")));
                    this.JTFNoFactura.setText(xrs.getString("NoDocumento"));
                    this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Disp.", 0, 0, new Font("Arial", 1, 12), Color.blue));
                }
                this.xFila = 0;
                xrs.beforeFirst();
                if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdatos);
                        this.xmodelo.setValueAt(xrs.getString("idDetalleMovimiento"), this.xFila, 0);
                        this.xmodelo.setValueAt(xrs.getString("Id_Rubro"), this.xFila, 1);
                        this.xmodelo.setValueAt(xrs.getString("NombreRubro"), this.xFila, 2);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("DISPONIBILIDAD_INICIAL")), this.xFila, 3);
                        this.xmodelo.setValueAt(xrs.getString("ObsDetalle"), this.xFila, 4);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("ADICION")), this.xFila, 5);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("REINTEGROS")), this.xFila, 6);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("COMPROMISO")), this.xFila, 7);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Por_Ejecutar")), this.xFila, 8);
                        this.xmodelo.setValueAt(true, this.xFila, 9);
                        this.xFila++;
                    }
                } else if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4")) {
                    double xSaldo = 0.0d;
                    if (xrs.next()) {
                        this.JFTFValorDoc.setValue(Double.valueOf(xrs.getDouble("valorSolicitud")));
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(xrs.getString("idDetalleMovimiento"), this.xFila, 0);
                            this.xmodelo.setValueAt(xrs.getString("Id_Rubro"), this.xFila, 1);
                            this.xmodelo.setValueAt(xrs.getString("NombreRubro"), this.xFila, 2);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("COMPROMISO")), this.xFila, 3);
                            this.xmodelo.setValueAt(xrs.getString("Id_Tercero"), this.xFila, 4);
                            this.xmodelo.setValueAt(xrs.getString("Empresa"), this.xFila, 5);
                            this.xmodelo.setValueAt(xrs.getString("ObsDetalle"), this.xFila, 6);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Estado")), this.xFila, 7);
                            this.xmodelo.setValueAt(new JButton("Tercero"), this.xFila, 8);
                            this.xmodelo.setValueAt(Double.valueOf((xrs.getDouble("DISPONIBILIDAD_INICIAL") + xrs.getDouble("ADICION")) - xrs.getDouble("REINTEGROS")), this.xFila, 9);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("ADICIONCOMPROMISO")), this.xFila, 10);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Por_Ejecutar")), this.xFila, 11);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("REINTEGRO_COMPROMISO")), this.xFila, 12);
                            xSaldo += (xrs.getDouble("DISPONIBILIDAD_INICIAL") + xrs.getDouble("ADICION")) - xrs.getDouble("REINTEGROS");
                            if (this.xmodelo.getValueAt(this.xFila, 3).equals("0")) {
                                this.xmodelo.isCellEditable(this.xFila, 3);
                            }
                            this.xFila++;
                        }
                    }
                }
                mTotaliza();
                mBuscaEvidencia();
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        if (this.jTabbedPane1.getSelectedIndex() == 1) {
            this.JTFNombreArc.setText("");
            this.JTFRutaEvidencia.setText("");
            this.JTObservacionArch.setText("");
            return;
        }
        this.JLB_Registro.setText("");
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.JTObservacion.setText("");
        this.JTFCodigoRbro.setText("");
        this.JCBRubros.setSelectedIndex(-1);
        this.JFTFValor.setValue(0);
        this.JTFObservacion.setText("");
        this.xFila = 0;
        this.xId_Movimiento = 0L;
        this.JLCodigoDoc.setText("");
        this.txtFechaFact.setDate(this.xmt.getFechaActual());
        this.JTFNoFactura.setText("");
        this.JFTFValorDoc.setValue(0);
        this.JFTFValorSaldoR.setValue(0);
        this.JFTFValorTotal.setValue(0);
        Principal.mLimpiarDatosP();
        mCrearModeloDatosDispo();
        mCreaModeloSoporte();
    }

    public void mBuscar() {
        JDBusquedaMovPTO x = new JDBusquedaMovPTO((Frame) null, true, this, this.xIdClaseDoc);
        x.setLocationRelativeTo(this);
        x.setVisible(true);
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , MAX(`pp_movimiento`.`NoConcecutivo`) AS MaximoCons\nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` ='" + this.xIdClaseDoc + "'  AND  pp_tipo_documentos.`Id`='" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "' and DATE_FORMAT(pp_movimiento.`FechaD`, '%Y') ='" + this.xmt.formatoANO.format(this.txtFecha.getDate()) + "') ";
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
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    private String mConcecutivoDisponibilidad(String xid) {
        String Con = "";
        String sql = "SELECT `NoConcecutivo` FROM `pp_movimiento` WHERE `Id`='" + xid + "'";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getString("NoConcecutivo");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Con;
    }

    public void mBuscaRubros(String xId) {
        String sql;
        mCrearModeloDatosCompromiso();
        if (this.conAdicion) {
            sql = "SELECT  D.IdMovimiento, D.NoConcecutivo,  D.FechaD ,D.TipoDocumento ,D.Observacion ,D.NoDocumento\n                    ,SUM(D.DISPONIBILIDAD) AS DISPONIBILIDAD_INICIAL\n                    ,SUM(D.ADICION) AS ADICION\n                    , SUM(D.REINTEGRO) AS REINTEGROS\n                    ,IFNULL(C.Compromiso,0) COMPROMISO\n                    ,((SUM(D.Disponibilidad)+SUM(D.ADICION))/*-IFNULL(C.Compromiso,0)*/- SUM(D.REINTEGRO)) Por_Ejecutar\n                     ,Estado\n                    ,D.IdDisponibilidad\n                    ,D.Id_Rubro\n                    , D.NombreRubro\n                    ,D.ObsDetalle\n                     ,D.Estado\n                     ,D.IdSolicitud\n                     ,D.Tipo\n                     ,D.Id_Tercero\n                     ,D.NTercero\n                     FROM \n                    (SELECT  pp_movimiento.`Id` AS IdMovimiento,pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                      , pp_tipo_documentos.Nbre AS TipoDocumento \n                           , pp_movimiento.Observacion , `pp_movimiento`.NoDocumento \n                           , g_motivoanulacion.Nbre AS EstadoAnu \n                           , CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 9 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND DISPONIBILIDAD\n\t\t\t, CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 10 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND ADICION\n\t\t\t, CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 11 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND REINTEGRO\n                           ,pp_movimiento.IdDisponibilidad\n                           , pp_detalle_movimiento.`Id_Rubro`\n                           , pp_rubros.`Nbre` AS NombreRubro\n                           ,pp_detalle_movimiento.`Observacion` AS ObsDetalle\n                           ,`pp_detalle_movimiento`.`Id_Tercero`\n                           ,IF(`g_empresa`.Nbre='',CONCAT(`g_empresa`.Apellido1,' ',`g_empresa`.Apellido2,' ',`g_empresa`.Nombre1,' ',`g_empresa`.Nombre2),`g_empresa`.Nbre) AS NTercero\n                           ,`pp_detalle_movimiento`.`Estado` , pp_movimiento.IdSolicitud,  pp_detalle_movimiento.Tipo \n                          FROM pp_movimiento  \n                                    INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                    INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                    INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                    INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.`Id_Rubro` = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                    INNER JOIN   `g_empresa`   ON (`pp_detalle_movimiento`.`Id_Tercero` = `g_empresa`.`Id`)\n                                    WHERE pp_tipo_documentos.Id_ClaseDoc IN (9,10,11) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Estado`=1 \n                          GROUP BY pp_detalle_movimiento.`Id_Rubro` , pp_movimiento.IdDisponibilidad,  pp_movimiento.Id -- , pp_tipo_documentos.Id_ClaseDoc\n                          ORDER BY pp_movimiento.FechaD DESC) D\n                          LEFT JOIN \n                         (SELECT  pp_movimiento.`Id` AS IdMovimiento, pp_movimiento.IdDisponibilidad , pp_detalle_movimiento.`Id_Rubro`\n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                            FROM pp_movimiento  \n                            INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                            INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                            INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                            WHERE pp_tipo_documentos.Id_ClaseDoc IN (4,12) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Estado`=1 \n                             GROUP BY pp_detalle_movimiento.`Id_Rubro` ,pp_movimiento.`IdDisponibilidad`\n                          ) C\n                         ON D.IdDisponibilidad=C.IdDisponibilidad  AND D.Id_Rubro=C.Id_Rubro\n                         WHERE(D.IdDisponibilidad='" + xId + "')\n                         GROUP BY  D.IdDisponibilidad,  D.Id_Rubro\n";
        } else {
            sql = "SELECT  D.IdMovimiento, D.NoConcecutivo,  D.FechaD ,D.TipoDocumento ,D.Observacion ,D.NoDocumento\n                    ,SUM(D.DISPONIBILIDAD) AS DISPONIBILIDAD_INICIAL\n                    ,SUM(D.ADICION) AS ADICION\n                    , SUM(D.REINTEGRO) AS REINTEGROS\n                    ,IFNULL(C.Compromiso,0) COMPROMISO\n                    ,((SUM(D.Disponibilidad)+SUM(D.ADICION))-IFNULL(C.Compromiso,0)- SUM(D.REINTEGRO)) Por_Ejecutar\n                     ,Estado\n                    ,D.IdDisponibilidad\n                    ,D.Id_Rubro\n                    , D.NombreRubro\n                    ,D.ObsDetalle\n                     ,D.Estado\n                     ,D.IdSolicitud\n                     ,D.Tipo\n                     ,D.Id_Tercero\n                     ,D.NTercero\n                     FROM \n                    (SELECT  pp_movimiento.`Id` AS IdMovimiento,pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                      , pp_tipo_documentos.Nbre AS TipoDocumento \n                           , pp_movimiento.Observacion , `pp_movimiento`.NoDocumento \n                           , g_motivoanulacion.Nbre AS EstadoAnu \n                           , CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 9 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND DISPONIBILIDAD\n\t\t\t, CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 10 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND ADICION\n\t\t\t, CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 11 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND REINTEGRO\n                           ,pp_movimiento.IdDisponibilidad\n                           , pp_detalle_movimiento.`Id_Rubro`\n                           , pp_rubros.`Nbre` AS NombreRubro\n                           ,pp_detalle_movimiento.`Observacion` AS ObsDetalle\n                           ,`pp_detalle_movimiento`.`Id_Tercero`\n                           ,IF(`g_empresa`.Nbre='',CONCAT(`g_empresa`.Apellido1,' ',`g_empresa`.Apellido2,' ',`g_empresa`.Nombre1,' ',`g_empresa`.Nombre2),`g_empresa`.Nbre) AS NTercero\n                           ,`pp_detalle_movimiento`.`Estado` , pp_movimiento.IdSolicitud,  pp_detalle_movimiento.Tipo \n                          FROM pp_movimiento  \n                                    INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                    INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                    INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                    INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.`Id_Rubro` = pp_rubros.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n                                    INNER JOIN   `g_empresa`   ON (`pp_detalle_movimiento`.`Id_Tercero` = `g_empresa`.`Id`)\n                                    WHERE pp_tipo_documentos.Id_ClaseDoc IN (9,10,11) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Estado`=1 \n                          GROUP BY pp_detalle_movimiento.`Id_Rubro` , pp_movimiento.IdDisponibilidad,  pp_movimiento.Id -- , pp_tipo_documentos.Id_ClaseDoc\n                          ORDER BY pp_movimiento.FechaD DESC) D\n                          LEFT JOIN \n                         (SELECT  pp_movimiento.`Id` AS IdMovimiento, pp_movimiento.IdDisponibilidad , pp_detalle_movimiento.`Id_Rubro`\n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                            FROM pp_movimiento  \n                            INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                            INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                            INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                            WHERE pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.`Estado`=1 \n                             GROUP BY pp_detalle_movimiento.`Id_Rubro` ,pp_movimiento.`IdDisponibilidad`\n                          ) C\n                         ON D.IdDisponibilidad=C.IdDisponibilidad  AND D.Id_Rubro=C.Id_Rubro\n                         WHERE(D.IdDisponibilidad='" + xId + "')\n                         GROUP BY  D.IdDisponibilidad,  D.Id_Rubro\n";
        }
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs = xct2.traerRs(sql);
        System.out.println("Movimiento-->" + sql);
        try {
            if (xrs.next()) {
                this.xFila = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt("", this.xFila, 0);
                    this.xmodelo.setValueAt(xrs.getString("Id_Rubro"), this.xFila, 1);
                    this.xmodelo.setValueAt(xrs.getString("NombreRubro"), this.xFila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Por_Ejecutar")), this.xFila, 3);
                    this.xmodelo.setValueAt("", this.xFila, 4);
                    this.xmodelo.setValueAt("", this.xFila, 5);
                    this.xmodelo.setValueAt(xrs.getString("ObsDetalle"), this.xFila, 6);
                    this.xmodelo.setValueAt(false, this.xFila, 7);
                    this.xmodelo.setValueAt(new JButton("Tercero"), this.xFila, 8);
                    this.xmodelo.setValueAt(Double.valueOf((xrs.getDouble("DISPONIBILIDAD_INICIAL") + xrs.getDouble("ADICION")) - xrs.getDouble("REINTEGROS")), this.xFila, 9);
                    this.xmodelo.setValueAt(0, this.xFila, 10);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Por_Ejecutar")), this.xFila, 11);
                    this.xmodelo.setValueAt(0, this.xFila, 12);
                    this.xFila++;
                    mTotaliza();
                }
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloSoporte() {
        this.xmodeloEvidencia = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre Archivo", "Ruta", "Observación", "Estado"}) { // from class: Presupuesto.JIFFMovimiento.27
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleEvidencia.setModel(this.xmodeloEvidencia);
        this.JTDetalleEvidencia.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleEvidencia.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleEvidencia.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleEvidencia.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleEvidencia.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleEvidencia.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleEvidencia.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    public void mBuscaEvidencia() {
        mCreaModeloSoporte();
        String sql = "SELECT `Id`, `Nbre`, `url`, `Observacion`, `Estado`\nFROM `pp_movimiento_evidencia` WHERE (`Id_Movimiento` ='" + this.xMovimiento + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloEvidencia.addRow(this.xdatos);
                    this.xmodeloEvidencia.setValueAt("Id", n, 0);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("Nbre"), n, 1);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("url"), n, 2);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("Observacion"), n, 3);
                    this.xmodeloEvidencia.setValueAt(Boolean.valueOf(xrs.getBoolean("Estado")), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificarRubro() {
        String sql = "SELECT concat(`pp_rubros`.`Nbre`, ' - ', `pp_rubro_x_tipo_doc`.`IdRubro`) AS Rubro FROM `pp_rubro_x_tipo_doc` INNER JOIN  `pp_rubros` ON (`pp_rubro_x_tipo_doc`.`IdRubro` = `pp_rubros`.`Id`) AND (pp_rubro_x_tipo_doc.`idEncabezadoRubro`=pp_rubros.`idEncabezadoRubro`) WHERE (pp_rubros.Id='" + this.JTFCodigoRbro.getText() + "'and `pp_rubro_x_tipo_doc`.`Estado` =1 AND pp_rubro_x_tipo_doc.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `pp_rubro_x_tipo_doc`.`IdTipoDoc` ='" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "') ORDER BY `pp_rubro_x_tipo_doc`.`IdRubro` ASC;";
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

    private boolean xVerificaTercero() {
        boolean xExiste = false;
        if (this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4") && this.JTDetalle.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i >= this.JTDetalle.getRowCount()) {
                    break;
                }
                System.out.println("FIla enviada-->" + this.JTDetalle.getValueAt(i, 4));
                if (!this.JTDetalle.getValueAt(i, 4).equals("") || Double.valueOf(this.JTDetalle.getValueAt(i, 3).toString()).doubleValue() <= 0.0d) {
                    i++;
                } else {
                    xExiste = true;
                    break;
                }
            }
        }
        return xExiste;
    }

    public void mImiprimir() {
        Double dValueOf;
        if (!this.JLB_Registro.getText().isEmpty()) {
            Double valorAdicion = new Double(0.0d);
            Double Reintegro = new Double(0.0d);
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (getTitle().equals("COMPROMISO PRESUPUESTAL")) {
                    valorAdicion = Double.valueOf(valorAdicion.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(x, 10).toString()).doubleValue());
                    dValueOf = Double.valueOf(Reintegro.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(x, 12).toString()).doubleValue());
                } else {
                    valorAdicion = Double.valueOf(valorAdicion.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(x, 5).toString()).doubleValue());
                    dValueOf = Double.valueOf(Reintegro.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(x, 6).toString()).doubleValue());
                }
                Reintegro = dValueOf;
            }
            String xv = this.JFTFValorTotal.getText();
            System.out.println("Valor en letras " + xv);
            if (this.xIdClaseDoc.equals("9")) {
                String[][] mparametros = new String[5][2];
                mparametros[0][0] = "IdDisponibilidad";
                mparametros[0][1] = this.xMovimiento;
                mparametros[1][0] = "numeroLetra1";
                mparametros[1][1] = this.xmt.mConvertirNumeroLetras(xv);
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                mparametros[4][0] = "idClaseDocumento";
                System.out.println("xMovimiento-->" + this.xMovimiento);
                if (valorAdicion.doubleValue() > 0.0d || Reintegro.doubleValue() > 0.0d) {
                    Object[] botones1 = {"Disponibilidad", "Reintegro-Adición", "Cerrar"};
                    int v = JOptionPane.showOptionDialog(this, "Que desea visualizar?", "CONSULTAR", 0, 3, (Icon) null, botones1, "Disponibilidad");
                    if (v == 0) {
                        mparametros[4][1] = this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1];
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_CDP", mparametros);
                        return;
                    } else {
                        if (v == 1) {
                            if (valorAdicion.doubleValue() > 0.0d) {
                                mparametros[4][1] = "10";
                            } else {
                                mparametros[4][1] = "11";
                            }
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_AdicionReintegros", mparametros);
                            return;
                        }
                        return;
                    }
                }
                mparametros[4][1] = this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1];
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_CDP", mparametros);
                return;
            }
            if (this.xIdClaseDoc.equals("4")) {
                String[][] mparametros2 = new String[5][2];
                mparametros2[0][0] = "IdCompromiso";
                mparametros2[0][1] = this.xMovimiento;
                mparametros2[1][0] = "numeroLetra1";
                mparametros2[1][1] = this.xmt.mConvertirNumeroLetras(xv);
                mparametros2[2][0] = "SUBREPORT_DIR";
                mparametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros2[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                mparametros2[4][0] = "idClaseDocumento";
                System.out.println("parametros " + mparametros2[0][1]);
                if (valorAdicion.doubleValue() > 0.0d || Reintegro.doubleValue() > 0.0d) {
                    Object[] botones12 = {"Compromiso", "Reintegro-Adición", "Cerrar"};
                    int v2 = JOptionPane.showOptionDialog(this, "Que desea visualizar?", "CONSULTAR", 0, 3, (Icon) null, botones12, "Compromiso");
                    if (v2 == 0) {
                        mparametros2[4][1] = this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1];
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_Compromiso", mparametros2);
                        return;
                    } else {
                        if (v2 == 1) {
                            if (valorAdicion.doubleValue() > 0.0d) {
                                mparametros2[4][1] = "12";
                            } else {
                                mparametros2[4][1] = "13";
                            }
                            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_AdicionReintegros_Compromiso", mparametros2);
                            return;
                        }
                        return;
                    }
                }
                mparametros2[4][1] = this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][1];
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_Compromiso", mparametros2);
            }
        }
    }

    public void mAnular() {
        JOptionPane.showInternalMessageDialog(this, "Operación no permitida", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mAnular_Registro(String xIdMot, String xObservacion) {
        Principal.xclasePresupuesto.mAnularMovimiento(xIdMot, xObservacion, this.xMovimiento, getTitle());
        Principal.txtEstado.setText("ANULADO");
    }

    private void mSaldoRubro() {
        String sql = "SELECT  \nr.Id\n,r.IdPadre\n,r.Nbre\n,r.TipoRubro\n,Presupuesto_Inicial\n,Adicion_Presupuesto\n,Reduccion_Presupuesto\n,Traslados_Debitos\n,Traslados_Creditos\n,Presupuesto_Definitivo\n,Reconocimiento_Anterior\n,Reconocimiento_Actual\n,Reconocimiento_Total\n,Recaudo_Anterior\n,Recaudo_Actual\n,Recaudo_Total\n,Saldo_por_Ejecutar\n,Saldo_por_Recaudar \n,Certificado_Anterior\n,Certificado_Actual\n,Total_Certificados\n,Compromiso_Anterior\n,Compromiso_Actual\n,Compromiso_Total\n,Obligacion_Anterior\n,Obligacion_Actual\n,Total_Obligaciones\n,Pagos_Anterior\n,Pagos_Actual\n,Total_Pagos\n,Saldo_Disponible\n,Sin_Comprometer\n,Compromisos_por_Pagar\n,Cuentas_por_Pagar\n,Certificado_sin_Comprometer\n\nFROM pp_rubros r\nINNER JOIN \n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n  ,Reconocimiento_Anterior\n ,Reconocimiento_Actual\n ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n ,Recaudo_Anterior\n ,Recaudo_Actual\n ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n/*Actualizacion con nuevos clase documentos*/ \n/*Disponibilidad CDP*/\n ,(Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)  AS Certificado_Anterior\n ,(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)  AS Certificado_Actual\n ,((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)) Total_Certificados\n/*Compromiso RP*/\n ,(Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior) AS Compromiso_Anterior\n ,(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual) AS Compromiso_Actual\n ,((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual)) Compromiso_Total\n /*Obligacion OP*/\n ,(Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior) AS Obligacion_Anterior\n ,(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual) AS Obligacion_Actual\n ,((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual)) Total_Obligaciones\n /*Pagos PP*/\n ,Pagos_Anterior\n ,Pagos_Actual\n ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n /*Operaciones...*/\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- ((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Sin_Comprometer\n ,(((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n ,(((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual))-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n ,(((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Certificado_sin_Comprometer\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\n-- -------------------------------------------------------------\n,SUM(IFNULL(Adicion_Disponibilidad_Anterior,0)) Adicion_Disponibilidad_Anterior\n,SUM(IFNULL(Adicion_Disponibilidad_Actual,0)) Adicion_Disponibilidad_Actual\n,SUM(IFNULL(Reintegro_Disponibilidad_Anterior,0)) Reintegro_Disponibilidad_Anterior\n,SUM(IFNULL(Reintegro_Disponibilidad_Actual,0)) Reintegro_Disponibilidad_Actual\n,SUM(IFNULL(Adicion_Compromiso_Anterior,0)) Adicion_Compromiso_Anterior\n,SUM(IFNULL(Adicion_Compromiso_Actual,0)) Adicion_Compromiso_Actual\n,SUM(IFNULL(Reintegro_Compromiso_Anterior,0)) Reintegro_Compromiso_Anterior\n,SUM(IFNULL(Reintegro_Compromiso_Actual,0)) Reintegro_Compromiso_Actual\n,SUM(IFNULL(Adicion_Obligacion_Anterior,0)) Adicion_Obligacion_Anterior\n,SUM(IFNULL(Adicion_Obligacion_Actual,0)) Adicion_Obligacion_Actual\n,SUM(IFNULL(Reintegro_Obligacion_Anterior,0)) Reintegro_Obligacion_Anterior\n,SUM(IFNULL(Reintegro_Obligacion_Actual,0)) Reintegro_Obligacion_Actual\n\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Reconocimiento_Anterior\n\n,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Reconocimiento_Actual\n\n,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Recaudo_Anterior\n\n,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Recaudo_Actual\n\n\n,CASE WHEN Id_CD=9  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Disponibilidad_Anterior\n\n,CASE WHEN Id_CD=9  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Disponibilidad_Actual\n\n,CASE WHEN Id_CD=4  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Compromiso_Anterior\n \n ,CASE WHEN Id_CD=4  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Compromiso_Actual\n \n,CASE WHEN Id_CD=5  AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Obligacion_Anterior\n \n,CASE WHEN Id_CD=5  AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Obligacion_Actual \n \n ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Pagos_Anterior\n \n ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Pagos_Actual\n -- -------------------------------------------------------\n /*\n10\tAdicion Disponibilidad\n11\tReintegro Disponibilidad\n12\tAdicion Compromiso\n13\tReintegro Compromiso\n14\tAdicion Obligación\n15\tReintegro Obligación\n*/\n ,CASE WHEN Id_CD=10 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=10 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Actual\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Actual\n\n ,CASE WHEN Id_CD=12 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=12 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Actual\n\n ,CASE WHEN Id_CD=13 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=13 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Reintegro_Compromiso_Actual \n    \n ,CASE WHEN Id_CD=14 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=14 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Adicion_Obligacion_Actual\n  \n,CASE WHEN Id_CD=15 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=15 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Actual\n \n\nFROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , pp_movimiento.Id_Periodo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    , @Periodo_Act Periodo_Act\n    \nFROM (SELECT @Periodo_Act:='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') p,\n    pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE   pp_periodo.Id IN ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n    WHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') pact\n    WHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n    OR pact.Id=pant.id\n         )  \n    AND pp_movimiento.Id_MotivoAnulacion=1  AND pp_rubros.`Id`='" + this.xIdRubros[this.JCBRubros.getSelectedIndex()] + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' \n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) datos ) datos\nON r.Id=datos.Id_R WHERE r.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "';";
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("Saldo Disponible-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                double valor = xrs.getDouble("Saldo_Disponible");
                this.JFTFValorSaldoR.setValue(Double.valueOf(valor));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private double mConsultaSaldoRubroDispo(String xidRubro) {
        double xValor = 0.0d;
        String sql = "SELECT  D.IdMovimiento, D.NoConcecutivo,  D.FechaD ,D.TipoDocumento ,D.Observacion ,D.NoDocumento\n                     ,\n                    SUM(D.DISPONIBILIDAD) AS DISPONIBILIDAD_INICIAL\n                    ,SUM(D.ADICION) AS ADICION\n                    , SUM(D.REINTEGRO) AS REINTEGROS\n                    ,IFNULL(C.Compromiso,0) COMPROMISO\n                    ,((SUM(D.Disponibilidad)+SUM(D.ADICION))-IFNULL(C.Compromiso,0)- SUM(D.REINTEGRO)) Por_Ejecutar\n                     ,Estado\n                    ,D.IdDisponibilidad\n                    ,D.Id_Rubro\n                    , D.NombreRubro\n                    ,D.ObsDetalle\n                     ,D.Estado\n                     ,D.IdSolicitud\n                     ,D.Tipo\n                     ,D.Id_Tercero\n                     ,D.NTercero\n                     FROM \n                    (SELECT  pp_movimiento.`Id` AS IdMovimiento,pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                      , pp_tipo_documentos.Nbre AS TipoDocumento \n                           , pp_movimiento.Observacion , `pp_movimiento`.NoDocumento \n                           , g_motivoanulacion.Nbre AS EstadoAnu \n                           , CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 9 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND DISPONIBILIDAD\n\t\t\t, CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 10 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND ADICION\n\t\t\t, CASE WHEN pp_tipo_documentos.Id_ClaseDoc = 11 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0 \n\t\t\tEND REINTEGRO\n                           ,pp_movimiento.IdDisponibilidad\n                           , pp_detalle_movimiento.`Id_Rubro`\n                           , pp_rubros.`Nbre` AS NombreRubro\n                           ,pp_detalle_movimiento.`Observacion` AS ObsDetalle\n                           ,`pp_detalle_movimiento`.`Id_Tercero`\n                           ,IF(`g_empresa`.Nbre='',CONCAT(`g_empresa`.Apellido1,' ',`g_empresa`.Apellido2,' ',`g_empresa`.Nombre1,' ',`g_empresa`.Nombre2),`g_empresa`.Nbre) AS NTercero\n                           ,`pp_detalle_movimiento`.`Estado` , pp_movimiento.IdSolicitud,  pp_detalle_movimiento.Tipo \n                          FROM pp_movimiento  \n                                    INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                    INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                    INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                    INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.`Id_Rubro` = pp_rubros.`Id`)\n                                    INNER JOIN   `g_empresa`   ON (`pp_detalle_movimiento`.`Id_Tercero` = `g_empresa`.`Id`)\n                                    WHERE pp_tipo_documentos.Id_ClaseDoc IN (9,10,11)\n                          GROUP BY pp_detalle_movimiento.`Id_Rubro` , pp_movimiento.IdDisponibilidad,  pp_movimiento.Id -- , pp_tipo_documentos.Id_ClaseDoc\n                          ORDER BY pp_movimiento.FechaD DESC) D\n                          LEFT JOIN \n                         (SELECT  pp_movimiento.`Id` AS IdMovimiento, pp_movimiento.IdDisponibilidad , pp_detalle_movimiento.`Id_Rubro`\n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                            FROM pp_movimiento  \n                            INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                            INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                            INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                            WHERE pp_tipo_documentos.Id_ClaseDoc IN (4) \n                             GROUP BY pp_detalle_movimiento.`Id_Rubro` ,pp_movimiento.`IdDisponibilidad`  -- ,  pp_movimiento.Id\n                          ) C\n                         ON D.IdDisponibilidad=C.IdDisponibilidad  AND D.Id_Rubro=C.Id_Rubro\n                         WHERE(C.IdDisponibilidad='" + this.xIdMovDisponibilidad + "' AND C.Id_Rubro='" + xidRubro + "')\n                         GROUP BY  D.IdDisponibilidad,  D.Id_Rubro\n                         -- ORDER BY D.IdDisponibilidad DESC, D.FechaD DESC";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xValor = xrs.getDouble("Por_Ejecutar");
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xValor;
    }

    private double mConsultaSaldoComprometido_Rubro(String xidRubro) {
        double xValor = 0.0d;
        String sql = " SELECT\n    `pp_detalle_movimiento`.`Id_Rubro`\n    , SUM(`pp_detalle_movimiento`.`Valor`) AS Valor\n FROM\n    `pp_detalle_movimiento`\n    INNER JOIN `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n WHERE (`pp_movimiento`.`IdDisponibilidad` ='" + this.xIdMovDisponibilidad + "'\n    AND `pp_tipo_documentos`.`Id_ClaseDoc` =4 AND `pp_detalle_movimiento`.`Id_Rubro`='" + xidRubro + "')\n    GROUP BY `pp_detalle_movimiento`.`Id_Rubro`;";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xValor = xrs.getDouble("Valor");
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xValor;
    }

    private double mConsultaReintegro() {
        double xVReintegro = 0.0d;
        String sql = "SELECT `pp_detalle_movimiento`.`Valor` AS ValorReintegro, `pp_detalle_movimiento`.`Id_Rubro` \nFROM `pp_detalle_movimiento` \nINNER JOIN `pp_movimiento`  ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\nINNER JOIN `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` =8  AND `pp_movimiento`.`IdDisponibilidad` ='" + this.xIdMovDisponibilidad + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    xVReintegro += xrs.getDouble("ValorReintegro");
                }
            }
            System.out.println("Valor Reintegro--->" + xVReintegro);
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xVReintegro;
    }

    private double mConsultaReintegro_x_Rubro(String xIdRubro) {
        double xVReintegro = 0.0d;
        System.out.println("Rubro-->" + xIdRubro);
        String sql = " SELECT  `pp_detalle_movimiento`.`Valor` as ValorReintegro\n FROM `pp_detalle_movimiento` INNER JOIN `pp_movimiento`  ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n WHERE (`pp_movimiento`.`IdDisponibilidad` ='" + this.xIdMovDisponibilidad + "' AND `pp_detalle_movimiento`.`Id_Rubro`='" + xIdRubro + "' \n    AND `pp_tipo_documentos`.`Id_ClaseDoc` =8);";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xVReintegro = xrs.getDouble("ValorReintegro");
            }
            System.out.println("Valor Comprometido--->" + xVReintegro);
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xVReintegro;
    }

    private String mBuscaIdDisponibilidad(String xidComp) {
        String xId = "";
        String sql = "SELECT IdDisponibilidad FROM pp_movimiento WHERE Id ='" + xidComp + "' ";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xId = xrs.getString("IdDisponibilidad");
            }
            System.out.println("IdDisponibilidad--->" + xId);
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xId;
    }

    private boolean mVerificaAnulacion() {
        try {
            String xsql = "SELECT\n    `pp_movimiento`.`Id`\n    , `pp_movimiento`.`IdDisponibilidad`\n    , `pp_movimiento`.`IdCompromiso`\n    , `pp_movimiento`.`IdObligacion`\n    , `pp_movimiento`.`Id_TipoDoc`\nFROM\n    `baseserver`.`pp_movimiento_autorizacion`\n    INNER JOIN `baseserver`.`pp_movimiento` \n        ON (`pp_movimiento_autorizacion`.`Id_Movimiento` = `pp_movimiento`.`Id`)\nWHERE (`pp_movimiento`.`Id` ='" + this.xMovimiento + "'\n    AND `pp_movimiento`.`Id_TipoDoc` ='" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "')";
            ResultSet xrs = this.xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                if (!this.xIdClaseDoc.equals("9") && this.xIdClaseDoc.equals("9")) {
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return false;
    }
}
