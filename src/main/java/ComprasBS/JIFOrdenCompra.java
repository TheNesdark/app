package ComprasBS;

import Acceso.Principal;
import Contabilidad.JIFConsultarDatosV;
import General.Anular;
import Presupuesto.JDBusquedaDocPTO;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFOrdenCompra.class */
public class JIFOrdenCompra extends JInternalFrame {
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloc;
    private ConsultasMySQL xconsultas;
    private String[] xidunidadfuncional;
    private String[] xIdTipoDoc;
    private String[][] xidempresa;
    public String[] xidtipobien;
    private int xtipoc;
    private int xnfila;
    public long xcodigop;
    private String xsql;
    private Object[] xdato;
    private boolean xejecutado;
    private boolean xlleno;
    private boolean xlleno1;
    private JIFBuscarProducto xjibuscarproducto;
    private JIFConsultarDatosV xjifbuscarorden;
    private long xidorden;
    private File xfile;
    public int xIdMovDisponibilidad;
    private JTable datosTable;
    private JButton JBBuscar;
    private ButtonGroup JBGFormato;
    private ButtonGroup JBGTipo;
    private JButton JBTAdicionar;
    private JButton JBTExportar;
    private JComboBox JCBTercero;
    public JComboBox JCBTipoBien;
    private JComboBox JCBTipoDoc;
    private JComboBox JCBUnidadF;
    private JCheckBox JCHImportar;
    private JDateChooser JDFFechaC;
    public JLabel JLCodigoDoc;
    public JLabel JLCodigoDoc1;
    private JPanel JPIDatosC;
    private JPanel JPIDatosP;
    private JPanel JPTipo;
    private JRadioButton JRBAutomatico;
    private JRadioButton JRBFExcel;
    private JRadioButton JRBFTexto;
    private JRadioButton JRBManual;
    private JSpinner JSPCant;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleC;
    public JSpinner JSPIva;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    public JTable JTDetalle;
    public JTable JTDetalleC;
    private JFormattedTextField JTFFSubtotal;
    private JFormattedTextField JTFFTotal;
    private JFormattedTextField JTFFTotalIva;
    private JFormattedTextField JTFFValor;
    private JFormattedTextField JTFFValorDescuento;
    private JFormattedTextField JTFFValorFlete;
    public JTextField JTFNRequisicion;
    public JTextField JTFNombreP;
    private JTextField JTFRuta;

    public JIFOrdenCompra(String xnombre, long xidorden) {
        this.xmt = new Metodos();
        this.xconsultas = new ConsultasMySQL();
        this.xtipoc = 1;
        this.xnfila = -1;
        this.xcodigop = 1L;
        this.xsql = null;
        this.xejecutado = false;
        this.xlleno = false;
        this.xidorden = 0L;
        this.xIdMovDisponibilidad = 0;
        initComponents();
        setName(xnombre);
        this.xidorden = xidorden;
        this.xidunidadfuncional = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidunidadfuncional, this.JCBUnidadF);
        this.xsql = "SELECT i_tipoproducto.Id, i_tipoproducto.Nbre FROM i_suministro INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) WHERE (i_suministro.EstaActivo =1) GROUP BY i_tipoproducto.Id ORDER BY i_tipoproducto.Nbre ASC ";
        this.xidtipobien = this.xconsultas.llenarCombo(this.xsql, this.xidtipobien, this.JCBTipoBien);
        this.xconsultas.cerrarConexionBd();
        this.xlleno = true;
        mNuevo();
        if (!mPresupuesto()) {
            this.JBBuscar.setEnabled(false);
        }
    }

    public JIFOrdenCompra(String xnombre, JTable datos) {
        this.xmt = new Metodos();
        this.xconsultas = new ConsultasMySQL();
        this.xtipoc = 1;
        this.xnfila = -1;
        this.xcodigop = 1L;
        this.xsql = null;
        this.xejecutado = false;
        this.xlleno = false;
        this.xidorden = 0L;
        this.xIdMovDisponibilidad = 0;
        initComponents();
        setName(xnombre);
        this.datosTable = datos;
        this.xidunidadfuncional = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidunidadfuncional, this.JCBUnidadF);
        this.xsql = "SELECT i_tipoproducto.Id, i_tipoproducto.Nbre FROM i_suministro INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) WHERE (i_suministro.EstaActivo =1) GROUP BY i_tipoproducto.Id ORDER BY i_tipoproducto.Nbre ASC ";
        this.xidtipobien = this.xconsultas.llenarCombo(this.xsql, this.xidtipobien, this.JCBTipoBien);
        this.xconsultas.cerrarConexionBd();
        this.xlleno = true;
        mNuevo();
        cargarDatosLista();
    }

    /* JADX WARN: Type inference failed for: r3v120, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v98, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JBGFormato = new ButtonGroup();
        this.JPIDatosP = new JPanel();
        this.JCBUnidadF = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JDFFechaC = new JDateChooser();
        this.JCBTipoDoc = new JComboBox();
        this.JLCodigoDoc1 = new JLabel();
        this.JLCodigoDoc = new JLabel();
        this.JBBuscar = new JButton();
        this.JTFNRequisicion = new JTextField();
        this.JPIDatosC = new JPanel();
        this.JPTipo = new JPanel();
        this.JRBManual = new JRadioButton();
        this.JRBAutomatico = new JRadioButton();
        this.JCBTipoBien = new JComboBox();
        this.JTFNombreP = new JTextField();
        this.JSPCant = new JSpinner();
        this.JTFFValor = new JFormattedTextField();
        this.JSPIva = new JSpinner();
        this.JBTAdicionar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFFValorFlete = new JFormattedTextField();
        this.JTFFSubtotal = new JFormattedTextField();
        this.JTFFTotalIva = new JFormattedTextField();
        this.JTFFTotal = new JFormattedTextField();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JRBFTexto = new JRadioButton();
        this.JRBFExcel = new JRadioButton();
        this.JCHImportar = new JCheckBox();
        this.JTFFValorDescuento = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("ORDEN DE COMPRA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcompras");
        addInternalFrameListener(new InternalFrameListener() { // from class: ComprasBS.JIFOrdenCompra.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFOrdenCompra.this.formInternalFrameClosing(evt);
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
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: ComprasBS.JIFOrdenCompra.2
            public void itemStateChanged(ItemEvent evt) {
                JIFOrdenCompra.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addItemListener(new ItemListener() { // from class: ComprasBS.JIFOrdenCompra.3
            public void itemStateChanged(ItemEvent evt) {
                JIFOrdenCompra.this.JCBTerceroItemStateChanged(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc.addItemListener(new ItemListener() { // from class: ComprasBS.JIFOrdenCompra.4
            public void itemStateChanged(ItemEvent evt) {
                JIFOrdenCompra.this.JCBTipoDocItemStateChanged(evt);
            }
        });
        this.JCBTipoDoc.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.5
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JCBTipoDocActionPerformed(evt);
            }
        });
        this.JLCodigoDoc1.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc1.setForeground(Color.red);
        this.JLCodigoDoc1.setHorizontalAlignment(0);
        this.JLCodigoDoc1.setText("0");
        this.JLCodigoDoc1.setToolTipText("");
        this.JLCodigoDoc1.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLCodigoDoc.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc.setForeground(Color.red);
        this.JLCodigoDoc.setHorizontalAlignment(0);
        this.JLCodigoDoc.setText("0");
        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Disponibilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setToolTipText("Adjuntar Documento");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.6
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JTFNRequisicion.setEditable(false);
        this.JTFNRequisicion.setFont(new Font("Arial", 1, 12));
        this.JTFNRequisicion.setHorizontalAlignment(0);
        this.JTFNRequisicion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Requisición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNRequisicion.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFOrdenCompra.7
            public void mouseClicked(MouseEvent evt) {
                JIFOrdenCompra.this.JTFNRequisicionMouseClicked(evt);
            }
        });
        this.JTFNRequisicion.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.8
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JTFNRequisicionActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNRequisicion, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDoc, -2, 396, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLCodigoDoc1, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLCodigoDoc, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscar, -2, 51, -2).addGap(0, 0, 32767)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBUnidadF, -2, 208, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTercero, 0, -1, 32767))).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaC, -2, 50, -2).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLCodigoDoc, -1, 50, 32767).addComponent(this.JLCodigoDoc1, -2, 50, -2).addComponent(this.JCBTipoDoc, -2, 50, -2).addComponent(this.JTFNRequisicion, -1, 50, 32767)).addComponent(this.JBBuscar, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBUnidadF, -2, 50, -2).addComponent(this.JCBTercero, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, 32767).addComponent(this.JSPObservacion, -2, 55, -2)));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL BIEN", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipo.add(this.JRBManual);
        this.JRBManual.setFont(new Font("Arial", 1, 12));
        this.JRBManual.setSelected(true);
        this.JRBManual.setText("M");
        this.JRBManual.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.9
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JRBManualActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBAutomatico);
        this.JRBAutomatico.setFont(new Font("Arial", 1, 12));
        this.JRBAutomatico.setText("A");
        this.JRBAutomatico.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.10
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JRBAutomaticoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBManual).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAutomatico)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAutomatico).addComponent(this.JRBManual)).addContainerGap(-1, 32767)));
        this.JCBTipoBien.setFont(new Font("Arial", 1, 12));
        this.JCBTipoBien.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Bien", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreP.setFont(new Font("Arial", 1, 12));
        this.JTFNombreP.setHorizontalAlignment(2);
        this.JTFNombreP.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreP.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFOrdenCompra.11
            public void mouseClicked(MouseEvent evt) {
                JIFOrdenCompra.this.JTFNombrePMouseClicked(evt);
            }
        });
        this.JTFNombreP.addKeyListener(new KeyAdapter() { // from class: ComprasBS.JIFOrdenCompra.12
            public void keyPressed(KeyEvent evt) {
                JIFOrdenCompra.this.JTFNombrePKeyPressed(evt);
            }
        });
        this.JSPCant.setFont(new Font("Arial", 1, 13));
        this.JSPCant.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPCant.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setToolTipText("El valor debe ser sin iva");
        this.JTFFValor.setFont(new Font("Arial", 1, 13));
        this.JSPIva.setFont(new Font("Arial", 1, 13));
        this.JSPIva.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPIva.setBorder(BorderFactory.createTitledBorder((Border) null, "% Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.13
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosCLayout.createSequentialGroup().addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoBien, -2, 179, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreP, -2, 437, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPIva, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCant, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValor, -2, 110, -2))).addContainerGap(-1, 32767)));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreP).addComponent(this.JCBTipoBien).addComponent(this.JTFFValor).addComponent(this.JSPCant, -2, 46, -2).addComponent(this.JSPIva, -2, 46, -2)).addComponent(this.JPTipo, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 38, -2).addGap(16, 16, 16)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: ComprasBS.JIFOrdenCompra.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFOrdenCompra.this.JTDetallePropertyChange(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: ComprasBS.JIFOrdenCompra.15
            public void keyPressed(KeyEvent evt) {
                JIFOrdenCompra.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFFValorFlete.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Flete", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorFlete.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorFlete.setHorizontalAlignment(4);
        this.JTFFValorFlete.setFont(new Font("Arial", 1, 13));
        this.JTFFValorFlete.addFocusListener(new FocusAdapter() { // from class: ComprasBS.JIFOrdenCompra.16
            public void focusLost(FocusEvent evt) {
                JIFOrdenCompra.this.JTFFValorFleteFocusLost(evt);
            }
        });
        this.JTFFValorFlete.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.17
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JTFFValorFleteActionPerformed(evt);
            }
        });
        this.JTFFSubtotal.setEditable(false);
        this.JTFFSubtotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Sub Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSubtotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFSubtotal.setHorizontalAlignment(4);
        this.JTFFSubtotal.setFont(new Font("Arial", 1, 13));
        this.JTFFTotalIva.setEditable(false);
        this.JTFFTotalIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalIva.setHorizontalAlignment(4);
        this.JTFFTotalIva.setFont(new Font("Arial", 1, 13));
        this.JTFFTotal.setEditable(false);
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 13));
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "Condiciones de Entrega", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalleC.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleC.setEditingColumn(2);
        this.JTDetalleC.setEditingRow(1);
        this.JTDetalleC.setGridColor(new Color(204, 204, 204));
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleC.setSelectionMode(0);
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFOrdenCompra.18
            public void mouseClicked(MouseEvent evt) {
                JIFOrdenCompra.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.19
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JBGFormato.add(this.JRBFTexto);
        this.JRBFTexto.setFont(new Font("Arial", 1, 12));
        this.JRBFTexto.setText("Texto");
        this.JBGFormato.add(this.JRBFExcel);
        this.JRBFExcel.setFont(new Font("Arial", 1, 12));
        this.JRBFExcel.setSelected(true);
        this.JRBFExcel.setText("Excel");
        this.JCHImportar.setFont(new Font("Arial", 1, 12));
        this.JCHImportar.setText("Importar?");
        this.JCHImportar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.20
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JCHImportarActionPerformed(evt);
            }
        });
        this.JTFFValorDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorDescuento.setHorizontalAlignment(4);
        this.JTFFValorDescuento.setFont(new Font("Arial", 1, 13));
        this.JTFFValorDescuento.addFocusListener(new FocusAdapter() { // from class: ComprasBS.JIFOrdenCompra.21
            public void focusLost(FocusEvent evt) {
                JIFOrdenCompra.this.JTFFValorDescuentoFocusLost(evt);
            }
        });
        this.JTFFValorDescuento.addActionListener(new ActionListener() { // from class: ComprasBS.JIFOrdenCompra.22
            public void actionPerformed(ActionEvent evt) {
                JIFOrdenCompra.this.JTFFValorDescuentoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIDatosC, -1, -1, 32767).addComponent(this.JPIDatosP, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JSPDetalleC, -2, 364, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFFValorDescuento, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorFlete, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSubtotal, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotalIva, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotal, -2, 123, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 373, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JRBFTexto).addGap(18, 18, 18).addComponent(this.JRBFExcel)).addComponent(this.JCHImportar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTExportar, -2, 128, -2))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 273, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFTotal, GroupLayout.Alignment.LEADING).addComponent(this.JTFFTotalIva, GroupLayout.Alignment.LEADING).addComponent(this.JTFFSubtotal, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorFlete, -2, 50, -2).addComponent(this.JTFFValorDescuento, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JCHImportar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFTexto).addComponent(this.JRBFExcel))))).addComponent(this.JSPDetalleC, -2, 111, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBManualActionPerformed(ActionEvent evt) {
        this.xtipoc = 1;
        this.JCBTipoBien.setEnabled(false);
        this.JTFNombreP.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAutomaticoActionPerformed(ActionEvent evt) {
        this.xtipoc = 0;
        this.JCBTipoBien.setEnabled(true);
        this.JCBTipoBien.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombrePMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            mCargar_Busqueda();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBTercero.getSelectedIndex() != -1) {
            if (this.JTFNombreP.getText().isEmpty()) {
                JOptionPane.showInternalMessageDialog(this, "El producto no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNombreP.requestFocus();
                return;
            }
            if (Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue() != 0.0d) {
                this.xnfila++;
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(Long.valueOf(this.xcodigop), this.xnfila, 0);
                this.xmodelo.setValueAt(this.JTFNombreP.getText(), this.xnfila, 1);
                this.xmodelo.setValueAt(this.JSPCant.getValue(), this.xnfila, 2);
                this.xmodelo.setValueAt(this.JSPIva.getValue(), this.xnfila, 3);
                this.xmodelo.setValueAt(Double.valueOf(((Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue() * Double.valueOf(this.JSPIva.getValue().toString()).doubleValue()) / 100.0d) * Double.valueOf(this.JSPCant.getValue().toString()).doubleValue()), this.xnfila, 4);
                this.xmodelo.setValueAt(this.JTFFValor.getValue(), this.xnfila, 5);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue() * Long.valueOf(this.JSPCant.getValue().toString()).longValue()), this.xnfila, 6);
                this.xmodelo.setValueAt(Integer.valueOf(this.xtipoc), this.xnfila, 7);
                mLimpiarD();
                mSumarValores();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Valor no pueder ser cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFValor.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTercero.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                mSumarValores();
                this.JTFNombreP.requestFocus();
                this.xnfila--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadF.getSelectedIndex() != -1) {
            this.xlleno1 = false;
            this.JCBTercero.removeAllItems();
            this.xsql = "SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta, cc_terceros.ActivoC FROM cc_unidadfuncionalxempresa  INNER JOIN cc_terceros ON (cc_unidadfuncionalxempresa.Id_Empresa = cc_terceros.Id) WHERE (cc_unidadfuncionalxempresa.Estado =1 and cc_terceros.Estado=1 AND cc_unidadfuncionalxempresa.Id_UnidadF ='" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()] + "') ORDER BY cc_terceros.RazonSocialCompleta ASC ";
            this.xidempresa = this.xconsultas.llenarComboyLista(this.xsql, this.xidempresa, this.JCBTercero, 3);
            this.JCBTercero.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorFleteActionPerformed(ActionEvent evt) {
        this.JTFFValorFlete.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorFleteFocusLost(FocusEvent evt) {
        mSumarValores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JCHImportar.isSelected()) {
                JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
                FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("XLS", new String[]{"xls"});
                xfilec.setFileFilter(filtroImagen);
                int r = xfilec.showOpenDialog(this);
                if (r == 0) {
                    xfilec.showOpenDialog(this);
                    this.xfile = xfilec.getSelectedFile();
                    this.JTFRuta.setText(this.xfile.getAbsolutePath());
                    return;
                }
                return;
            }
            JFileChooser xfilec2 = new JFileChooser(this.JTFRuta.getText());
            xfilec2.setFileSelectionMode(1);
            int xv = xfilec2.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec2.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                if (this.JRBFExcel.isSelected()) {
                    if (this.JCHImportar.isSelected()) {
                        mImportar();
                        return;
                    } else {
                        mExportar();
                        return;
                    }
                }
                if (!Principal.txtNo.getText().isEmpty()) {
                    mGenerarArchivo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHImportarActionPerformed(ActionEvent evt) {
        if (this.JCHImportar.isSelected()) {
            this.JBTExportar.setText("Importar");
            this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a importar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else {
            this.JBTExportar.setText("Exportar");
            this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            mSumarValores();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBTercero.getSelectedIndex() != -1 && this.xidempresa[this.JCBTercero.getSelectedIndex()][1].equals("0")) {
            mMensajeTercero();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombrePKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargar_Busqueda();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        JDBusquedaDocPTO x = new JDBusquedaDocPTO(null, true, this, "9", "");
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoDoc.getSelectedIndex() != -1) {
            mConsecutivo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNRequisicionMouseClicked(MouseEvent evt) {
        JDBuscarInformacion dialog = new JDBuscarInformacion(null, true, this, 0);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNRequisicionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorDescuentoFocusLost(FocusEvent evt) {
        mSumarValores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorDescuentoActionPerformed(ActionEvent evt) {
        this.JTFFValorDescuento.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocActionPerformed(ActionEvent evt) {
    }

    private void mConsecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(CONVERT(`NInterno`, UNSIGNED)) as MaximoCons FROM `cc_orden_compra` WHERE (`Id_TipoDocF` ='" + this.xIdTipoDoc[this.JCBTipoDoc.getSelectedIndex()] + "' AND `Estado` =1);";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
            this.JLCodigoDoc1.setText("" + (Con + 1));
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mMensajeTercero() {
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Tercero desactivado por no tener movimiento;</p><font face='Arial' color='red' size=4>No se pueder realizar registro.", "VERIFICACIÓN TERCERO", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.JCBTercero.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JDFFechaC.setEnabled(true);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.JTFNombreP.setText("");
        this.JTFNRequisicion.setText("0");
        this.JCBTipoBien.setSelectedIndex(-1);
        this.JRBManual.setSelected(true);
        this.xtipoc = 1;
        this.JCBTipoBien.setEnabled(false);
        this.xcodigop = 1L;
        if (getName().equals("jifcompras")) {
            this.xidorden = 0L;
        }
        this.xejecutado = false;
        this.JTFFValor.setValue(new Integer(0));
        this.JTFFSubtotal.setValue(new Integer(0));
        this.JTFFTotalIva.setValue(new Integer(0));
        this.JTFFTotal.setValue(new Integer(0));
        this.JTFFValorFlete.setValue(new Integer(0));
        this.JTFFValorDescuento.setValue(new Integer(0));
        this.JDFFechaC.requestFocus();
        this.JCBTipoDoc.removeAllItems();
        this.xIdTipoDoc = this.xconsultas.llenarCombo("SELECT `Id` , `Nbre` FROM `cc_tipo_documentof` WHERE (`Tipo` =1)   ORDER BY `Nbre` ASC", this.xIdTipoDoc, this.JCBTipoDoc);
        this.JCBTipoDoc.setSelectedIndex(-1);
        this.xlleno = true;
        mCrearTablaDetalle(true);
        mCargarDatosTablaCond();
        mCargarSolicitud();
    }

    private void mLimpiarD() {
        this.xcodigop = 1L;
        this.JTFNombreP.setText("");
        this.JTFFValor.setValue(new Integer(0));
        this.JSPCant.setValue(new Integer(0));
        this.JSPIva.setValue(new Double(0.0d));
        this.JTFNombreP.requestFocus();
    }

    private void mCrearTablaDetalle(final boolean xbloqueo) {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Cantidad", "% Iva", "V/Iva", "V/Unitario", "V/Total", "Tipo"}) { // from class: ComprasBS.JIFOrdenCompra.23
            Class[] types = {Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Long.class};
            boolean[] canEdit;

            {
                this.canEdit = new boolean[]{false, false, true, xbloqueo, false, xbloqueo, false, false};
            }

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.xnfila = -1;
    }

    private void mCrearTablaCond() {
        this.xmodeloc = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Aplica"}) { // from class: ComprasBS.JIFOrdenCompra.24
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodeloc);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mSumarValores() {
        double xtd = 0.0d;
        double xtc = 0.0d;
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            this.xmodelo.setValueAt(Double.valueOf(((Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()).doubleValue() * Double.valueOf(this.xmodelo.getValueAt(x, 3).toString()).doubleValue()) / 100.0d) * Double.valueOf(this.xmodelo.getValueAt(x, 2).toString()).doubleValue()), x, 4);
            this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()).doubleValue() * Double.valueOf(this.xmodelo.getValueAt(x, 2).toString()).doubleValue()), x, 6);
            xtd += Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue();
            xtc += Double.valueOf(this.xmodelo.getValueAt(x, 6).toString()).doubleValue();
        }
        this.JTFFSubtotal.setValue(Double.valueOf(xtc));
        this.JTFFTotalIva.setValue(Double.valueOf(xtd));
        this.JTFFTotal.setValue(Double.valueOf(((xtc + xtd) + Double.valueOf(this.JTFFValorFlete.getValue().toString()).doubleValue()) - Double.valueOf(this.JTFFValorDescuento.getValue().toString()).doubleValue()));
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                if (this.JTDetalle.getRowCount() > -1) {
                    if (this.xidempresa[this.JCBTercero.getSelectedIndex()][1].equals("1")) {
                        if (!mPresupuesto()) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                String sql = "insert into cc_orden_compra (FechaC, Id_Tercero,NInterno, Id_UnidadF, VDescuento, VFlete, Observacion, Estado, Fecha,IdDisponibilidad,Id_PersonaRh, IdRequisicion, UsuarioS, Id_TipoDocF) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + this.JLCodigoDoc1.getText() + "','" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()] + "','" + this.JTFFValorDescuento.getValue() + "','" + this.JTFFValorFlete.getValue() + "','" + this.JTAObservacion.getText() + "','1','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.xIdMovDisponibilidad + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.JTFNRequisicion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xIdTipoDoc[this.JCBTipoDoc.getSelectedIndex()] + "')";
                                Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
                                Principal.txtEstado.setText("ACTIVA");
                                this.xconsultas.cerrarConexionBd();
                                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                                    String xnombre = "";
                                    if (Integer.valueOf(this.xmodelo.getValueAt(y, 0).toString()).intValue() == 1) {
                                        xnombre = this.xmodelo.getValueAt(y, 1).toString();
                                    }
                                    String sql2 = "insert into cc_detalle_orden_compra (Id_OrdenC, Tipo, Id_Producto, NProducto, Cantidad, PIva, VUntiario) Values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 7) + "','" + this.xmodelo.getValueAt(y, 0) + "','" + xnombre + "','" + this.xmodelo.getValueAt(y, 2) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + this.xmodelo.getValueAt(y, 5) + "')";
                                    System.out.println("--------->" + sql2);
                                    this.xconsultas.ejecutarSQL(sql2);
                                    this.xconsultas.cerrarConexionBd();
                                }
                                if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalleC, 2)) {
                                    for (int y2 = 0; y2 < this.JTDetalleC.getRowCount(); y2++) {
                                        if (Boolean.valueOf(this.xmodeloc.getValueAt(y2, 2).toString()).booleanValue()) {
                                            String sql3 = "insert into cc_detalle_orden_compra_condiciones (Id_OrdenC, Id_TipoCondiciones) Values ('" + Principal.txtNo.getText() + "','" + this.xmodeloc.getValueAt(y2, 0) + "')";
                                            this.xconsultas.ejecutarSQL(sql3);
                                            this.xconsultas.cerrarConexionBd();
                                        }
                                    }
                                }
                                mActualizarSolicitud();
                                mGrabarUsuarioA();
                                mImprimir();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la Disponibilidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JLCodigoDoc.requestFocus();
                        this.JLCodigoDoc.setBackground(Color.red);
                        return;
                    }
                    mMensajeTercero();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe adicionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTercero.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private boolean mPresupuesto() {
        boolean xPto = false;
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1 && this.JLCodigoDoc.getText().equals("0")) {
            xPto = true;
        }
        return xPto;
    }

    private void cargarDatosLista() {
        if (this.datosTable != null) {
            this.xnfila = 0;
            for (int x = 0; x < this.datosTable.getRowCount(); x++) {
                if (Boolean.valueOf(this.datosTable.getValueAt(x, 6).toString()).booleanValue()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(this.datosTable.getValueAt(x, 0), this.xnfila, 0);
                    this.xmodelo.setValueAt(this.datosTable.getValueAt(x, 1), this.xnfila, 1);
                    this.xmodelo.setValueAt(this.datosTable.getValueAt(x, 7), this.xnfila, 2);
                    this.xmodelo.setValueAt(this.datosTable.getValueAt(x, 19), this.xnfila, 3);
                    this.xmodelo.setValueAt(0, this.xnfila, 4);
                    this.xmodelo.setValueAt(0, this.xnfila, 5);
                    this.xmodelo.setValueAt(0, this.xnfila, 6);
                    this.xmodelo.setValueAt(0, this.xnfila, 7);
                    this.xnfila++;
                }
            }
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_OrdenCompra", mparametros);
        }
    }

    public void mBuscar() {
        this.xjifbuscarorden = new JIFConsultarDatosV(this);
        Principal.cargarPantalla(this.xjifbuscarorden);
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty() && Principal.txtEstado.getText().equals("ACTIVA")) {
            if (!this.xejecutado) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "Orden Compra", 30);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Comprobante no se puede anular ya fue ejecutado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe registro para anular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mAnular(String idMotivoAnulacion, String xObservacion) {
        this.xsql = "update cc_r_requisicion set Estado=0, Id_MotivoAnulacion='" + idMotivoAnulacion + "', Observacion_Anul='" + xObservacion + "', Fecha_Anul='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', Usuario_Anul='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where Id='" + this.JTFNRequisicion.getText() + "'";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
        this.xsql = "update cc_orden_compra set Estado=0 where Id='" + Principal.txtNo.getText() + "'";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
        Principal.txtEstado.setText("ANULADO");
        this.xsql = "SELECT g_persona.Correo FROM cc_detalle_firma_ordenc INNER JOIN cc_usuarioxdocumentof ON (cc_detalle_firma_ordenc.Id_UsuarioF = cc_usuarioxdocumentof.Id) INNER JOIN g_persona  ON (cc_usuarioxdocumentof.Id_Persona = g_persona.Id) WHERE (cc_detalle_firma_ordenc.Id_OrdenC ='" + Principal.txtNo.getText() + "') ";
        ResultSet xrs = this.xconsultas.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmt.mEnvioCorreoElectronico("Se anulo la orden de compra de compra N°" + Principal.txtNo.getText() + "\nde la unidad funcional: " + this.JCBUnidadF.getSelectedItem().toString(), xrs.getString(1), "ANULACIÓN ORDEN DE COMPRA", Principal.usuarioSistemaDTO.getLogin());
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaCond() {
        try {
            mCrearTablaCond();
            ResultSet xrs = this.xconsultas.traerRs("SELECT Id, Nbre FROM cc_tipo_condiciones_compra WHERE (Estado =1) ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloc.addRow(this.xdato);
                    this.xmodeloc.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloc.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloc.setValueAt(false, n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosOrden(long xid) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT cc_orden_compra.Id, cc_orden_compra.FechaC, cc_unidad_funcional.Nbre, cc_terceros.RazonSocialCompleta, cc_orden_compra.VFlete, cc_orden_compra.Observacion, '' , '', if(cc_orden_compra.Estado=1,'ACTIVA','ANULADA') AS ESTADO, i_suministro.Id, IF(cc_detalle_orden_compra.NProducto IS NULL OR cc_detalle_orden_compra.NProducto=''  ,CONCAT(i_suministro.Nbre,' ', i_presentacioncomercial.Nbre,' ', i_laboratorio.Nbre),cc_detalle_orden_compra.NProducto) AS Nproducto  , cc_detalle_orden_compra.Cantidad, cc_detalle_orden_compra.PIva, cc_detalle_orden_compra.VUntiario, (((cc_detalle_orden_compra.VUntiario*cc_detalle_orden_compra.PIva)/100)*cc_detalle_orden_compra.Cantidad) AS VIva, (cc_detalle_orden_compra.VUntiario*cc_detalle_orden_compra.Cantidad) AS VTotal, cc_detalle_orden_compra.Tipo, `cc_orden_compra`.`IdRequisicion`,  `cc_orden_compra`.`VDescuento` FROM cc_orden_compra INNER JOIN cc_unidad_funcional ON (cc_orden_compra.Id_UnidadF = cc_unidad_funcional.Id) INNER JOIN cc_terceros ON (cc_orden_compra.Id_Tercero = cc_terceros.Id) INNER JOIN cc_detalle_orden_compra ON (cc_detalle_orden_compra.Id_OrdenC = cc_orden_compra.Id) INNER JOIN i_suministro  ON (cc_detalle_orden_compra.Id_Producto = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (cc_orden_compra.Id ='" + xid + "') ";
        mCrearTablaDetalle(true);
        ResultSet rs = xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.first();
                Principal.txtNo.setText(rs.getString(1));
                Principal.txtEstado.setText(rs.getString(9));
                this.JDFFechaC.setDate(rs.getDate(2));
                this.JCBUnidadF.setSelectedItem(rs.getString(3));
                this.JCBTercero.setSelectedItem(rs.getString(4));
                this.JTFFValorFlete.setValue(Double.valueOf(rs.getDouble(5)));
                this.JTAObservacion.setText(rs.getString(6));
                this.JTFNRequisicion.setText(rs.getString(18));
                this.JTFFValorDescuento.setValue(Double.valueOf(rs.getDouble(19)));
                rs.beforeFirst();
                while (rs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(10)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs.getString(11), this.xnfila, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(12)), this.xnfila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(13)), this.xnfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(15)), this.xnfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(14)), this.xnfila, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(16)), this.xnfila, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(17)), this.xnfila, 7);
                }
                mSumarValores();
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarSolicitud() {
        ConsultasMySQL xct = new ConsultasMySQL();
        this.xsql = "SELECT cc_unidad_funcional.Nbre, cc_terceros.RazonSocialCompleta, i_suministro.Id, CONCAT(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre, ' ' ,i_laboratorio.Nbre) AS NProducto , i_mdetalle_solicitud_pedido.Cantidad, i_suministro.Iva, ROUND((((i_mdetalle_solicitud_pedido.Valor*i_suministro.Iva)/100)*i_mdetalle_solicitud_pedido.Cantidad)) AS VIva , ROUND(i_mdetalle_solicitud_pedido.Valor)AS Valor, (ROUND(i_mdetalle_solicitud_pedido.Valor)*i_mdetalle_solicitud_pedido.Cantidad) AS VTotal FROM i_mdetalle_solicitud_pedido INNER JOIN i_msolicitud_pedido  ON (i_mdetalle_solicitud_pedido.Id_msolicitud = i_msolicitud_pedido.Id) INNER JOIN i_suministro ON (i_mdetalle_solicitud_pedido.Id_Producto = i_suministro.Id) INNER JOIN cc_terceros  ON (i_msolicitud_pedido.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_unidadfuncionalxempresa  ON (cc_unidadfuncionalxempresa.Id_Empresa = cc_terceros.Id) INNER JOIN cc_unidad_funcional ON (cc_unidadfuncionalxempresa.Id_UnidadF = cc_unidad_funcional.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_msolicitud_pedido.Id ='" + this.xidorden + "' ) group by i_suministro.Id ORDER BY NProducto ASC ";
        ResultSet rs = xct.traerRs(this.xsql);
        mCrearTablaDetalle(true);
        try {
            if (rs.next()) {
                rs.first();
                this.JCBUnidadF.setSelectedItem(rs.getString(1));
                this.JCBTercero.setSelectedItem(rs.getString(2));
                rs.beforeFirst();
                while (rs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs.getString(4), this.xnfila, 1);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), this.xnfila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), this.xnfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), this.xnfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), this.xnfila, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), this.xnfila, 6);
                    this.xmodelo.setValueAt(0, this.xnfila, 7);
                    mSumarValores();
                }
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarSolicitud() {
        this.xsql = "update i_msolicitud_pedido set Id_OrdenCompra='" + Principal.txtNo.getText() + "' where Id='" + this.xidorden + "'";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
    }

    private void mGrabarUsuarioA() {
        try {
            this.xsql = "SELECT cc_usuarioxdocumentof.Id, persona.Corre FROM persona INNER JOIN cc_usuarioxdocumentof ON (persona.Id_persona = cc_usuarioxdocumentof.Id_Persona) WHERE (cc_usuarioxdocumentof.MontoM <=" + this.JTFFTotal.getValue() + " AND cc_usuarioxdocumentof.Monto >=" + this.JTFFTotal.getValue() + " AND cc_usuarioxdocumentof.Id_TipoDocF ='" + this.xIdTipoDoc[this.JCBTipoDoc.getSelectedIndex()] + "' AND cc_usuarioxdocumentof.Estado =1) ";
            System.out.println("------validar usuario por firma------>" + this.xsql);
            ResultSet rs = this.xconsultas.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    this.xsql = "insert into cc_detalle_firma_ordenc (Id_OrdenC, Id_UsuarioF) values('" + Principal.txtNo.getText() + "','" + rs.getInt(1) + "')";
                    xct.ejecutarSQL(this.xsql);
                    xct.cerrarConexionBd();
                    this.xmt.mEnvioCorreoElectronico("Se ha generado orden de compra N°" + Principal.txtNo.getText() + "\nde la unidad funcional: " + this.JCBUnidadF.getSelectedItem().toString() + "\nfavor entrar a la aplicación Genoma Plus y autorizar", rs.getString(2), "AUTORIZACIÓN DE ORDEN DE COMPRA", Principal.usuarioSistemaDTO.getLogin());
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                this.xmt.mEliminarArchivo(new File(this.JTFRuta.getText() + ".xls"));
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Datos", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Number(0, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Number(2, x2 + 1, Long.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).longValue()));
                    sheet.addCell(new Number(3, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 3).toString()).doubleValue()));
                    sheet.addCell(new Number(4, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 4).toString()).doubleValue()));
                    sheet.addCell(new Number(5, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 5).toString()).doubleValue()));
                    sheet.addCell(new Number(6, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 6).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mGenerarArchivo() {
        try {
            String sFichero = this.JTFRuta.getText() + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.xsql = "SELECT CONCAT(DATE_FORMAT(`cc_orden_compra`.`FechaC`,'%Y/%m/%d'),',',`cc_detalle_orden_compra`.`Id_Producto`,',',`cc_detalle_orden_compra`.`VUntiario`,',', `cc_detalle_orden_compra`.`Cantidad`,',', 1526 ) AS Linea FROM `cc_detalle_orden_compra` INNER JOIN  `cc_orden_compra`  ON (`cc_detalle_orden_compra`.`Id_OrdenC` = `cc_orden_compra`.`Id`) INNER JOIN `i_suministro`  ON (`cc_detalle_orden_compra`.`Id_Producto` = `i_suministro`.`Id`) WHERE (`cc_orden_compra`.`Id` ='" + Principal.txtNo.getText() + "') ";
            ResultSet xrs = this.xconsultas.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                }
            }
            bw.close();
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (IOException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mImportar() {
        try {
            String archivo = this.JTFRuta.getText();
            Workbook workbook = Workbook.getWorkbook(new File(archivo));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            mCrearTablaDetalle(true);
            for (int x = 0; x < rows; x++) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(Long.valueOf(sheet.getCell(0, x).getContents()), x, 0);
                this.xmodelo.setValueAt(sheet.getCell(1, x).getContents(), x, 1);
                this.xmodelo.setValueAt(Long.valueOf(sheet.getCell(2, x).getContents()), x, 2);
                this.xmodelo.setValueAt(Long.valueOf(sheet.getCell(3, x).getContents()), x, 3);
                this.xmodelo.setValueAt(Double.valueOf(((Double.valueOf(sheet.getCell(4, x).getContents()).doubleValue() * Long.valueOf(sheet.getCell(3, x).getContents()).longValue()) / 100.0d) * Long.valueOf(sheet.getCell(2, x).getContents()).longValue()), x, 4);
                this.xmodelo.setValueAt(Double.valueOf(sheet.getCell(4, x).getContents()), x, 5);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(sheet.getCell(4, x).getContents()).doubleValue() * Long.valueOf(sheet.getCell(2, x).getContents()).longValue()), x, 6);
                this.xmodelo.setValueAt(1, x, 7);
            }
            mSumarValores();
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (BiffException e) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    private void mCargar_Busqueda() {
        if (this.JRBAutomatico.isSelected()) {
            if (this.JCBTipoBien.getSelectedIndex() != -1) {
                this.xjibuscarproducto = new JIFBuscarProducto(this);
                Principal.cargarPantalla(this.xjibuscarproducto);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debes seleccionar un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoBien.requestFocus();
            }
        }
    }

    public void mBuscarDatosRequisicion(String xid) {
        String sql = "SELECT `cc_r_requisicion`.`Id`, `cc_r_requisicion`.`ObservacionG` , `cc_r_requisicion_detalle`.`IdSuministro`, `cc_r_requisicion_detalle`.`Descripcion`, `cc_r_requisicion_detalle`.`Cantidad`, `cc_r_requisicion_detalle`.`Tipo`\n, IFNULL(d.PIva,0) PIva\n, IFNULL(d.Iva,0) Iva\n, IFNULL(d.ValorU,0) ValorU\n, IFNULL(d.total,0) total\nFROM  `cc_r_requisicion_detalle` \nINNER JOIN  `cc_r_requisicion`  ON (`cc_r_requisicion_detalle`.`Id_Requisicion` = `cc_r_requisicion`.`Id`) \nLEFT JOIN (SELECT \n cc_r_cotizacion.`Aprobado`\n, cc_r_cotizacion.`Estado`\n,`cc_r_requisicion_detalle`.`Id`\n, `cc_r_cotizacion_valor`.`ValorU`\n, `cc_r_cotizacion_valor`.`PIva` \n, IF(`cc_r_cotizacion_valor`.`PIva`=0,`cc_r_cotizacion_valor`.`Iva`,((`cc_r_cotizacion_valor`.`ValorU` * `cc_r_requisicion_detalle`.`Cantidad`) * `cc_r_cotizacion_valor`.`PIva`)/100) AS Iva\n, (`cc_r_cotizacion_valor`.`ValorU` * `cc_r_requisicion_detalle`.`Cantidad`) AS total \nFROM `cc_r_cotizacion` \nINNER JOIN `cc_r_cotizacion_valor` ON (`cc_r_cotizacion`.`Id` = cc_r_cotizacion_valor.`Id_Cotizacion`)\nINNER JOIN `cc_r_requisicion_detalle` ON (`cc_r_cotizacion_valor`.`Id_Suministro` = `cc_r_requisicion_detalle`.`Id`) \n) d ON (d.Id=cc_r_requisicion_detalle.`Id` AND d.Aprobado=1 AND d.Estado=1) \nWHERE (`cc_r_requisicion`.`Id` ='" + xid + "')";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        mCrearTablaDetalle(true);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTFNRequisicion.setText(xrs.getString(1));
                this.JTAObservacion.setText(xrs.getString(2));
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), this.xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(4), this.xnfila, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), this.xnfila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), this.xnfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), this.xnfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), this.xnfila, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(10)), this.xnfila, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(6)), this.xnfila, 7);
                }
            }
            mSumarValores();
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFOrdenCompra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
