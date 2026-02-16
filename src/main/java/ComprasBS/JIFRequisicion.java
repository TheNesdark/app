package ComprasBS;

import Acceso.Principal;
import Contabilidad.JIFConsultarDatosV;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFRequisicion.class */
public class JIFRequisicion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloc;
    private String[] xidempresa;
    private String[] xidcuentas;
    public String[][] xidunidadfuncional;
    public String[][] xidauxiliar;
    public String[] xidtipobien;
    private Object[] xdato;
    private JIFBuscarProducto xjibuscarproducto;
    private JIFConsultarDatosV xjifbuscarorden;
    private String xLlamador;
    private long xConsecutivo;
    private String[][] xidtipodoccontable;
    private ButtonGroup JBGTipo;
    private ButtonGroup JBGTipo1;
    private JButton JBTAdicionar;
    private JComboBox JCBCuenta;
    public JComboBox JCBCuentaAuxiliar;
    public JComboBox JCBTipoBien;
    private JComboBox JCBTipoC;
    private JComboBox JCBUnidadF;
    private JDateChooser JDFFechaC;
    private JPanel JPIDRequisicion;
    private JPanel JPIDatosC;
    private JPanel JPIDatosP;
    private JPanel JPTipo;
    private JPanel JPTipoR;
    private JRadioButton JRBAutomatico;
    private JRadioButton JRBBienes;
    private JRadioButton JRBManual;
    private JRadioButton JRBServicios;
    private JSpinner JSPCant;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacionP;
    private JTextArea JTAObservacionG;
    private JTextPane JTAObservacionP;
    public JTable JTDetalle;
    private JFormattedTextField JTFFValor;
    private JFormattedTextField JTFFValorPpt;
    public JTextField JTFNombreP;
    private JTextField JTF_NComprobante;
    private JTabbedPane JTPDatos;
    private JScrollPane jScrollPane1;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xtipoc = 1;
    private int xnfila = -1;
    private int xtipob = 0;
    public long xcodigop = 1;
    private String xsql = null;
    private boolean xejecutado = false;
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private long xidorden = 0;

    public JIFRequisicion(String xnombre, String xLlamador) {
        this.xLlamador = "";
        initComponents();
        this.xLlamador = xLlamador;
        setName(xnombre);
        this.JTFFValorPpt.setValue(0);
        mNuevo();
        if (this.xLlamador.equals("SolDisp")) {
            setTitle("SOLICITUD DE DISPONIBILIDAD");
            this.JTPDatos.setTitleAt(0, "SOLICITUD");
            this.JPTipoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Solicitud", 0, 0, new Font("Arial", 1, 12), Color.red));
        }
    }

    /* JADX WARN: Type inference failed for: r3v109, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JBGTipo1 = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIDRequisicion = new JPanel();
        this.JPIDatosP = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JCBUnidadF = new JComboBox();
        this.JTFFValorPpt = new JFormattedTextField();
        this.JPTipoR = new JPanel();
        this.JRBBienes = new JRadioButton();
        this.JRBServicios = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacionG = new JTextArea();
        this.JCBTipoC = new JComboBox();
        this.JTF_NComprobante = new JTextField();
        this.JPIDatosC = new JPanel();
        this.JPTipo = new JPanel();
        this.JRBManual = new JRadioButton();
        this.JRBAutomatico = new JRadioButton();
        this.JCBTipoBien = new JComboBox();
        this.JTFNombreP = new JTextField();
        this.JSPCant = new JSpinner();
        this.JTFFValor = new JFormattedTextField();
        this.JBTAdicionar = new JButton();
        this.JSPObservacionP = new JScrollPane();
        this.JTAObservacionP = new JTextPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCBCuenta = new JComboBox();
        this.JCBCuentaAuxiliar = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("REQUISICIÓN DE BIENES O SERVICIOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifrequisicion");
        addInternalFrameListener(new InternalFrameListener() { // from class: ComprasBS.JIFRequisicion.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRequisicion.this.formInternalFrameClosing(evt);
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
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: ComprasBS.JIFRequisicion.2
            public void itemStateChanged(ItemEvent evt) {
                JIFRequisicion.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JTFFValorPpt.setBorder(BorderFactory.createTitledBorder((Border) null, "Presupuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPpt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValorPpt.setHorizontalAlignment(0);
        this.JTFFValorPpt.setText("0");
        this.JTFFValorPpt.setToolTipText("Presupuesto aproximando");
        this.JTFFValorPpt.setFont(new Font("Arial", 1, 12));
        this.JPTipoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Requisición", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipo1.add(this.JRBBienes);
        this.JRBBienes.setFont(new Font("Arial", 1, 12));
        this.JRBBienes.setSelected(true);
        this.JRBBienes.setText("Bienes");
        this.JRBBienes.addActionListener(new ActionListener() { // from class: ComprasBS.JIFRequisicion.3
            public void actionPerformed(ActionEvent evt) {
                JIFRequisicion.this.JRBBienesActionPerformed(evt);
            }
        });
        this.JBGTipo1.add(this.JRBServicios);
        this.JRBServicios.setFont(new Font("Arial", 1, 12));
        this.JRBServicios.setText("Servicio");
        this.JRBServicios.addActionListener(new ActionListener() { // from class: ComprasBS.JIFRequisicion.4
            public void actionPerformed(ActionEvent evt) {
                JIFRequisicion.this.JRBServiciosActionPerformed(evt);
            }
        });
        GroupLayout JPTipoRLayout = new GroupLayout(this.JPTipoR);
        this.JPTipoR.setLayout(JPTipoRLayout);
        JPTipoRLayout.setHorizontalGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRLayout.createSequentialGroup().addComponent(this.JRBBienes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBServicios, -1, 87, 32767).addContainerGap()));
        JPTipoRLayout.setVerticalGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBServicios).addComponent(this.JRBBienes)));
        this.JTAObservacionG.setColumns(1);
        this.JTAObservacionG.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionG.setLineWrap(true);
        this.JTAObservacionG.setRows(1);
        this.JTAObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacionG);
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.addItemListener(new ItemListener() { // from class: ComprasBS.JIFRequisicion.5
            public void itemStateChanged(ItemEvent evt) {
                JIFRequisicion.this.JCBTipoCItemStateChanged(evt);
            }
        });
        this.JCBTipoC.addKeyListener(new KeyAdapter() { // from class: ComprasBS.JIFRequisicion.6
            public void keyPressed(KeyEvent evt) {
                JIFRequisicion.this.JCBTipoCKeyPressed(evt);
            }
        });
        this.JTF_NComprobante.setFont(new Font("Arial", 1, 12));
        this.JTF_NComprobante.setHorizontalAlignment(0);
        this.JTF_NComprobante.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 783, -2).addGap(18, 18, 18).addComponent(this.JTF_NComprobante)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JPTipoR, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaC, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUnidadF, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoC, -2, 202, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValorPpt, -2, 110, -2))).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadF, -2, -1, -2).addComponent(this.JTFFValorPpt, -2, 49, -2).addComponent(this.JCBTipoC, -2, -1, -2)).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFFechaC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPTipoR, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, -2, 61, -2).addComponent(this.JTF_NComprobante, -2, 50, -2)).addContainerGap(7, 32767)));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN DEL BIEN O SERVICIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipo.add(this.JRBManual);
        this.JRBManual.setFont(new Font("Arial", 1, 12));
        this.JRBManual.setSelected(true);
        this.JRBManual.setText("Manual");
        this.JRBManual.setToolTipText("Manual");
        this.JRBManual.addActionListener(new ActionListener() { // from class: ComprasBS.JIFRequisicion.7
            public void actionPerformed(ActionEvent evt) {
                JIFRequisicion.this.JRBManualActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBAutomatico);
        this.JRBAutomatico.setFont(new Font("Arial", 1, 12));
        this.JRBAutomatico.setText("Selección");
        this.JRBAutomatico.setToolTipText("Automática");
        this.JRBAutomatico.addActionListener(new ActionListener() { // from class: ComprasBS.JIFRequisicion.8
            public void actionPerformed(ActionEvent evt) {
                JIFRequisicion.this.JRBAutomaticoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBManual).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAutomatico).addContainerGap(-1, 32767)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAutomatico).addComponent(this.JRBManual)));
        this.JCBTipoBien.setFont(new Font("Arial", 1, 12));
        this.JCBTipoBien.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreP.setFont(new Font("Arial", 1, 12));
        this.JTFNombreP.setHorizontalAlignment(2);
        this.JTFNombreP.setBorder(BorderFactory.createTitledBorder((Border) null, "Bien o Servicio a Requerir", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreP.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFRequisicion.9
            public void mouseClicked(MouseEvent evt) {
                JIFRequisicion.this.JTFNombrePMouseClicked(evt);
            }
        });
        this.JSPCant.setFont(new Font("Arial", 1, 12));
        this.JSPCant.setModel(new SpinnerNumberModel(1, 0, (Comparable) null, 1));
        this.JSPCant.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setToolTipText("El valor debe ser sin iva");
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFRequisicion.10
            public void actionPerformed(ActionEvent evt) {
                JIFRequisicion.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JSPObservacionP.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación Especificas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionP.setFont(new Font("Arial", 1, 12));
        this.JSPObservacionP.setViewportView(this.JTAObservacionP);
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoBien, -2, 179, -2)).addComponent(this.JSPObservacionP)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JTFNombreP, -2, 386, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCant, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValor, -2, 110, -2)).addComponent(this.JBTAdicionar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIDatosCLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoBien).addComponent(this.JTFNombreP, -2, -1, -2).addComponent(this.JTFFValor, -1, 52, 32767).addComponent(this.JSPCant, -2, 51, -2))).addComponent(this.JPTipo, GroupLayout.Alignment.LEADING, -2, -1, -2)).addGap(5, 5, 5).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionar, -1, -1, 32767).addComponent(this.JSPObservacionP, -1, 63, 32767)).addGap(5, 5, 5)));
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
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: ComprasBS.JIFRequisicion.11
            public void keyPressed(KeyEvent evt) {
                JIFRequisicion.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JCBCuenta.setFont(new Font("Arial", 1, 12));
        this.JCBCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuenta.addItemListener(new ItemListener() { // from class: ComprasBS.JIFRequisicion.12
            public void itemStateChanged(ItemEvent evt) {
                JIFRequisicion.this.JCBCuentaItemStateChanged(evt);
            }
        });
        this.JCBCuentaAuxiliar.setFont(new Font("Arial", 1, 12));
        this.JCBCuentaAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDRequisicionLayout = new GroupLayout(this.JPIDRequisicion);
        this.JPIDRequisicion.setLayout(JPIDRequisicionLayout);
        JPIDRequisicionLayout.setHorizontalGroup(JPIDRequisicionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRequisicionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDRequisicionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRequisicionLayout.createSequentialGroup().addComponent(this.JCBCuenta, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCuentaAuxiliar, -2, 524, -2).addGap(71, 71, 71)).addGroup(JPIDRequisicionLayout.createSequentialGroup().addGroup(JPIDRequisicionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDatosP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)))));
        JPIDRequisicionLayout.setVerticalGroup(JPIDRequisicionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRequisicionLayout.createSequentialGroup().addComponent(this.JPIDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosC, -2, -1, -2).addGap(12, 12, 12).addComponent(this.JSPDetalle, -2, 180, -2).addGap(10, 10, 10).addGroup(JPIDRequisicionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBCuentaAuxiliar, -2, 50, -2).addComponent(this.JCBCuenta, -2, 50, -2)).addGap(30, 30, 30)));
        this.JTPDatos.addTab("REQUISICIÓN", this.JPIDRequisicion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 1005, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 608, 32767)));
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
        if (evt.getClickCount() == 2 && this.JRBAutomatico.isSelected()) {
            if (this.JCBTipoBien.getSelectedIndex() != -1) {
                this.xjibuscarproducto = new JIFBuscarProducto(this);
                Principal.cargarPantalla(this.xjibuscarproducto);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debes seleccionar un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoBien.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JTFNombreP.getText().isEmpty()) {
            if (Integer.parseInt(this.JSPCant.getValue().toString()) > 0) {
                this.xnfila++;
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(Long.valueOf(this.xcodigop), this.xnfila, 0);
                this.xmodelo.setValueAt(this.JTFNombreP.getText(), this.xnfila, 1);
                this.xmodelo.setValueAt(this.JSPCant.getValue(), this.xnfila, 2);
                this.xmodelo.setValueAt(this.JTFFValor.getValue(), this.xnfila, 3);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue() * Long.valueOf(this.JSPCant.getValue().toString()).longValue()), this.xnfila, 4);
                this.xmodelo.setValueAt(this.JTAObservacionP.getText(), this.xnfila, 5);
                mLimpiarD();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La Cantidad no puede ser cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JSPCant.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El producto no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombreP.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
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
            this.JCBCuentaAuxiliar.removeAllItems();
            this.JCBCuenta.removeAllItems();
            String sql = "SELECT cc_puc.Id, concat(cc_puc.Id,'-',cc_puc.Nbre) as Nombre FROM cc_pucxunidad_funcional INNER JOIN cc_puc  ON (cc_pucxunidad_funcional.Id_Puc = cc_puc.Id) INNER JOIN cc_auxiliar_cuenta  ON (cc_auxiliar_cuenta.Cuenta = cc_puc.Id) WHERE (cc_pucxunidad_funcional.Estado =1 AND cc_pucxunidad_funcional.Id_UnidadFuncional ='" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()] + "') GROUP BY cc_puc.Id order by cc_puc.Nbre";
            this.xidcuentas = this.xconsultas.llenarCombo(sql, this.xidcuentas, this.JCBCuenta);
            this.JCBCuenta.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBBienesActionPerformed(ActionEvent evt) {
        this.xtipob = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBServiciosActionPerformed(ActionEvent evt) {
        this.xtipob = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBCuenta.getSelectedIndex() != -1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.JCBCuentaAuxiliar.removeAllItems();
            String sql = "SELECT Id, concat(Id,'-',Nbre)as Nombre, Tipo FROM cc_puc WHERE (Id LIKE'" + this.xidcuentas[this.JCBCuenta.getSelectedIndex()] + "%' AND Nivel >=8) ORDER BY Nbre ASC ";
            this.xidauxiliar = xct.llenarComboyLista(sql, this.xidauxiliar, this.JCBCuentaAuxiliar, 3);
            this.JCBCuentaAuxiliar.setSelectedIndex(-1);
            xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoC.getSelectedIndex() != -1) {
            mConcecutivo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoC.transferFocus();
        }
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(`NConsecutivo`) AS MaximoCons FROM `cc_r_requisicion`\n WHERE (`Id_TipoDoc` ='" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "' \n AND `Estado` =1 AND DATE_FORMAT(cc_r_requisicion.`FechaR`, '%Y')='" + this.xmetodos.formatoANO.format(this.JDFFechaC.getDate()) + "')";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
            this.JTF_NComprobante.setText("" + (Con + 1));
        } catch (SQLException ex) {
            Logger.getLogger(JIFRequisicion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.JDFFechaC.setDate(this.xmetodos.getFechaActual());
        this.JCBUnidadF.removeAllItems();
        this.xsql = "SELECT cc_unidad_funcional.Id , cc_unidad_funcional.Nbre, g_persona.`Correo`,rh_unidad_funcional.`Id_Persona` FROM cc_unidad_funcional_rrhhuf  INNER JOIN rh_unidad_funcional  ON (cc_unidad_funcional_rrhhuf.Id_UF_RRHH = rh_unidad_funcional.Id) INNER JOIN cc_unidad_funcional  ON (cc_unidad_funcional_rrhhuf.Id_Unidad_Funcional = cc_unidad_funcional.Id) INNER JOIN rh_unidadf_cargo  ON (rh_unidadf_cargo.Id_UnidadF = rh_unidad_funcional.Id) INNER JOIN rh_tipo_persona_cargon  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN `g_persona`  ON (`rh_unidad_funcional`.`Id_Persona` = `g_persona`.`Id`) WHERE (rh_tipo_persona_cargon.Id ='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "') GROUP BY cc_unidad_funcional.Id ORDER BY cc_unidad_funcional.Nbre ASC ";
        this.xidunidadfuncional = this.xconsultas.llenarComboyLista(this.xsql, this.xidunidadfuncional, this.JCBUnidadF, 4);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JTAObservacionG.setText("");
        this.JTFNombreP.setText("");
        this.JCBTipoBien.removeAllItems();
        this.xsql = "SELECT i_tipoproducto.Id, i_tipoproducto.Nbre FROM i_suministro INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) WHERE (i_suministro.EstaActivo =1) GROUP BY i_tipoproducto.Id ORDER BY i_tipoproducto.Nbre ASC ";
        this.xidtipobien = this.xconsultas.llenarCombo(this.xsql, this.xidtipobien, this.JCBTipoBien);
        this.JCBTipoBien.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JCBTipoC.removeAllItems();
        this.xidtipodoccontable = this.xconsultas.llenarComboyLista("SELECT Id, Nbre, NReporte FROM cc_tipo_documentoc WHERE (Estado =1 and EsContable=2) ORDER BY Nbre ASC", this.xidtipodoccontable, this.JCBTipoC, 3);
        this.JCBTipoC.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JRBManual.setSelected(true);
        this.JRBBienes.setSelected(true);
        this.xtipoc = 1;
        this.xtipob = 0;
        this.xcodigop = 1L;
        this.JTAObservacionP.setText("");
        this.JCBTipoBien.setEnabled(false);
        this.JTFFValor.setValue(new Integer(0));
        this.JDFFechaC.requestFocus();
        this.xlleno = true;
        this.JCBCuenta.setVisible(false);
        this.JCBCuentaAuxiliar.setVisible(false);
        mCrearTablaDetalle();
    }

    private void mLimpiarD() {
        this.xcodigop = 1L;
        this.JTFNombreP.setText("");
        this.JTAObservacionP.setText("");
        this.JTFFValor.setValue(new Integer(0));
        this.JSPCant.setValue(new Integer(0));
        this.JTFNombreP.requestFocus();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Cant.", "V/Unitario", "V/Total", "Observación"}) { // from class: ComprasBS.JIFRequisicion.13
            Class[] types = {Long.class, String.class, Long.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.xnfila = -1;
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBUnidadF.getSelectedIndex() != -1) {
                if (this.JCBTipoC.getSelectedIndex() > -1) {
                    if (this.JTDetalle.getRowCount() > 0) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "insert into cc_r_requisicion (FechaR,`Id_TipoDoc`, `NConsecutivo`, Id_UnidadFC, Id_Persona_cargo, TipoR, IdLider, ObservacionG, VPresupuestado, Autorizado,UsuarioS) Values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "','" + this.JTF_NComprobante.getText() + "','" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][0] + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xtipob + "','" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][2] + "','" + this.JTAObservacionG.getText() + "','" + this.JTFFValorPpt.getValue() + "','1','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            System.out.println(sql);
                            Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
                            Principal.txtEstado.setText("ACTIVA");
                            this.xconsultas.cerrarConexionBd();
                            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                                String sql2 = "insert into cc_r_requisicion_detalle (Id_Requisicion, IdSuministro, Descripcion, Cantidad, VPromedioC, Observacion) Values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 1) + "','" + this.xmodelo.getValueAt(y, 2) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + this.xmodelo.getValueAt(y, 5) + "')";
                                System.out.println(sql2);
                                this.xconsultas.ejecutarSQL(sql2);
                                this.xconsultas.cerrarConexionBd();
                            }
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                this.xmetodos.mEnvioCorreoElectronico("Se ha generado la requisición  N°" + Principal.txtNo.getText() + "\nde la unidad funcional: " + this.JCBUnidadF.getSelectedItem().toString() + "\nfavor entrar a la aplicación Genoma Plus y autorizar", this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][1], "AUTORIZACIÓN DE REQUISICIÓN", Principal.usuarioSistemaDTO.getLogin());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe adicionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El Valor debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFValorPpt.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBUnidadF.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mBuscarDatos(String xid) {
        mNuevo();
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT `cc_r_requisicion`.`Id` , `cc_r_requisicion`.`TipoR`  , `cc_r_requisicion`.`FechaR` , `cc_unidad_funcional`.`Nbre`  , `cc_r_requisicion`.`VPresupuestado`, `cc_r_requisicion`.`ObservacionG` , `cc_r_requisicion_detalle`.`Id`,`cc_r_requisicion_detalle`.`Descripcion`, `cc_r_requisicion_detalle`.`Cantidad` , `cc_r_requisicion_detalle`.`VPromedioC`,((`cc_r_requisicion_detalle`.`VPromedioC`)*(`cc_r_requisicion_detalle`.`Cantidad`)) AS vtotal, `cc_r_requisicion_detalle`.`Observacion`, cc_r_requisicion.Estado , `cc_r_requisicion`.`NConsecutivo` , `cc_tipo_documentoc`.`Nbre` AS TipoDoc  FROM `cc_r_requisicion` INNER JOIN `cc_unidad_funcional`   ON (`cc_r_requisicion`.`Id_UnidadFC` = `cc_unidad_funcional`.`Id`) INNER JOIN `cc_r_requisicion_detalle`  ON (`cc_r_requisicion_detalle`.`Id_Requisicion` = `cc_r_requisicion`.`Id`)  INNER JOIN `cc_tipo_documentoc`   ON (`cc_tipo_documentoc`.`Id` = `cc_r_requisicion`.`Id_TipoDoc`) WHERE (`cc_r_requisicion`.`Id`='" + xid + "')";
        ResultSet rs = xct.traerRs(sql);
        try {
            if (rs.next()) {
                Principal.txtNo.setText(rs.getString(1));
                if (rs.getString(2).equals("0")) {
                    this.JRBBienes.setSelected(true);
                } else {
                    this.JRBServicios.setSelected(true);
                }
                this.JDFFechaC.setDate(rs.getDate(3));
                this.JCBUnidadF.setSelectedItem(rs.getString(4));
                this.JTFFValorPpt.setText(rs.getString(5));
                this.JTAObservacionG.setText(rs.getString(6));
                this.JCBTipoC.setSelectedItem(rs.getString("TipoDoc"));
                this.JTF_NComprobante.setText(rs.getString("NConsecutivo"));
                if (rs.getString(13).equals("1")) {
                    Principal.txtEstado.setText("ACTIVA");
                } else {
                    Principal.txtEstado.setText("ANULADA");
                }
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(7)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(8), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(10)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(11)), x, 4);
                    this.xmodelo.setValueAt(rs.getString(12), x, 5);
                    x++;
                }
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            xct.mostrarErrorSQL(ex);
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
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            if (this.xLlamador.equals("SolDisp")) {
                if (this.JRBBienes.isSelected()) {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "PP_Solicutud", mparametros);
                    return;
                } else {
                    if (this.JRBServicios.isSelected()) {
                        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "PP_SolicutudServ", mparametros);
                        return;
                    }
                    return;
                }
            }
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_Requisicion", mparametros);
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
                    Anular frm = new Anular(null, true, "Requisicion", 30);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Comprobante no se puede anular ya fue ejecutado", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe registro para anular", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mAnular(String idMotivoAnulacion, String xObservacion) {
        this.xsql = "update cc_r_requisicion set Estado=0, Id_MotivoAnulacion='" + idMotivoAnulacion + "', Observacion_Anul='" + xObservacion + "', Fecha_Anul='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Usuario_Anul='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "'  where Id='" + Principal.txtNo.getText() + "'";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
        Principal.txtEstado.setText("ANULADO");
    }

    public void mCargarDatosOrden(long xid) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT cc_orden_compra.Id, cc_orden_compra.FechaC, cc_unidad_funcional.Nbre, cc_terceros.RazonSocialCompleta, cc_orden_compra.VFlete, cc_orden_compra.Observacion, '' , '', if(cc_orden_compra.Estado=1,'ACTIVA','ANULADA') AS ESTADO, i_suministro.Id, IF(cc_detalle_orden_compra.Tipo=0,CONCAT(i_suministro.Nbre,' ', i_presentacioncomercial.Nbre,' ', i_laboratorio.Nbre),cc_detalle_orden_compra.NProducto) AS Nproducto  , cc_detalle_orden_compra.Cantidad, cc_detalle_orden_compra.PIva, cc_detalle_orden_compra.VUntiario, (((cc_detalle_orden_compra.VUntiario*cc_detalle_orden_compra.PIva)/100)*cc_detalle_orden_compra.Cantidad) AS VIva, (cc_detalle_orden_compra.VUntiario*cc_detalle_orden_compra.Cantidad) AS VTotal, cc_detalle_orden_compra.Tipo FROM cc_orden_compra INNER JOIN cc_unidad_funcional ON (cc_orden_compra.Id_UnidadF = cc_unidad_funcional.Id) INNER JOIN cc_terceros ON (cc_orden_compra.Id_Tercero = cc_terceros.Id) INNER JOIN cc_detalle_orden_compra ON (cc_detalle_orden_compra.Id_OrdenC = cc_orden_compra.Id) INNER JOIN i_suministro  ON (cc_detalle_orden_compra.Id_Producto = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (cc_orden_compra.Id ='" + xid + "') ";
        mCrearTablaDetalle();
        ResultSet rs = xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.first();
                Principal.txtNo.setText(rs.getString(1));
                Principal.txtEstado.setText(rs.getString(9));
                this.JDFFechaC.setDate(rs.getDate(2));
                this.JCBUnidadF.setSelectedItem(rs.getString(3));
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
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRequisicion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarSolicitud() {
        ConsultasMySQL xct = new ConsultasMySQL();
        this.xsql = "SELECT cc_unidad_funcional.Nbre, cc_terceros.RazonSocialCompleta, i_suministro.Id, CONCAT(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre, ' ' ,i_laboratorio.Nbre) AS NProducto , i_mdetalle_solicitud_pedido.Cantidad, i_suministro.Iva, ROUND((((i_mdetalle_solicitud_pedido.Valor*i_suministro.Iva)/100)*i_mdetalle_solicitud_pedido.Cantidad)) AS VIva , ROUND(i_mdetalle_solicitud_pedido.Valor)AS Valor, (ROUND(i_mdetalle_solicitud_pedido.Valor)*i_mdetalle_solicitud_pedido.Cantidad) AS VTotal FROM i_mdetalle_solicitud_pedido INNER JOIN i_msolicitud_pedido  ON (i_mdetalle_solicitud_pedido.Id_msolicitud = i_msolicitud_pedido.Id) INNER JOIN i_suministro ON (i_mdetalle_solicitud_pedido.Id_Producto = i_suministro.Id) INNER JOIN cc_terceros  ON (i_msolicitud_pedido.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_unidadfuncionalxempresa  ON (cc_unidadfuncionalxempresa.Id_Empresa = cc_terceros.Id) INNER JOIN cc_unidad_funcional ON (cc_unidadfuncionalxempresa.Id_UnidadF = cc_unidad_funcional.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_msolicitud_pedido.Id ='" + this.xidorden + "' AND cc_unidad_funcional.Id =6) ORDER BY NProducto ASC ";
        ResultSet rs = xct.traerRs(this.xsql);
        mCrearTablaDetalle();
        try {
            if (rs.next()) {
                rs.first();
                this.JCBUnidadF.setSelectedItem(rs.getString(1));
                rs.beforeFirst();
                while (rs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), this.xnfila, 0);
                    this.xmodelo.setValueAt(rs.getString(4), this.xnfila, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), this.xnfila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), this.xnfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), this.xnfila, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), this.xnfila, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), this.xnfila, 6);
                    this.xmodelo.setValueAt(0, this.xnfila, 7);
                }
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRequisicion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarSolicitud() {
        this.xsql = "update i_msolicitud_pedido set Id_OrdenCompra='" + Principal.txtNo.getText() + "' where Id='" + this.xidorden + "'";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
    }

    private void mGrabarUsuarioA() {
        try {
            ResultSet rs = this.xconsultas.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    this.xsql = "insert into cc_detalle_firma_ordenc (Id_OrdenC, Id_UsuarioF) values('" + Principal.txtNo.getText() + "','" + rs.getInt(1) + "')";
                    xct.ejecutarSQL(this.xsql);
                    xct.cerrarConexionBd();
                    this.xmetodos.mEnvioCorreoElectronico("Se ha generado orden de compra N°" + Principal.txtNo.getText() + "\nde la unidad funcional: " + this.JCBUnidadF.getSelectedItem().toString() + "\nfavor entrar a la aplicación Genoma Plus y autorizar", rs.getString(2), "AUTORIZACIÓN DE ORDEN DE COMPRA", Principal.usuarioSistemaDTO.getLogin());
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRequisicion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
