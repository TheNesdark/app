package Contabilidad;

import Acceso.Principal;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import com.genoma.plus.jpa.entities.PpMovimiento;
import com.genoma.plus.jpa.service.IPpMovimientoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGeneracionPagos_Directo.class */
public class JIFGeneracionPagos_Directo extends JInternalFrame {
    public DefaultTableModel xmodelo;
    public DefaultTableModel modeloPresupuesto;
    private String[] xidgrupo;
    private String[] xidsubcuenta;
    public String[] xidauxiliar;
    public String[] xidauxiliarxpagar;
    public String[][] xidcentrocosto;
    public String[][] xidempresa;
    public String[][] xId_CuentasB;
    public String[][] xidperiodo_ppt;
    public String[][] xidtipodoc_cont;
    private Object[] xdato;
    private int xtipo;
    private String[] xidtipodoc_ppt;
    private String[] xidperiodo_cont;
    private String[] xidtipodoc_contp;
    private String[] xId_Nomina;
    private String[] xId_ConceptoN;
    private String xsql;
    private String xId_Dato;
    private String xcc_puc;
    private long xConsecutivo;
    private int tipoDocPresupuesto;
    private int consecutivoPresupuesto;
    private ButtonGroup JBGTipo;
    private ButtonGroup JBGTipoP;
    private JButton JBTExportar;
    private JButton JBT_Contabilidacion;
    private JButton JBT_Reorganizar;
    private JComboBox JCBGrupo;
    private JComboBox JCBPeriodo_Cont;
    private JComboBox JCBPeriodo_Ppt;
    public JComboBox JCBSubCuenta;
    public JComboBox JCBTipoDoc_Cont;
    private JComboBox JCBTipoDoc_Cont1;
    private JComboBox JCBTipoDoc_Ppt;
    private JComboBox JCB_CuentaBancaria;
    private JComboBox JCB_NConcepto;
    private JComboBox JCB_NNomina;
    private JCheckBox JCHAplicaMovimientoPresupuestal;
    private JCheckBox JCHEnviarCorreo;
    private JCheckBox JCH_Agrupado;
    private JCheckBox JCH_AplicaMP1;
    private JCheckBox JCH_EsNomina;
    private JCheckBox JCH_FiltroMes;
    private JCheckBox JCH_Seleccionar;
    private JCheckBox JCH_SinCausacion;
    private JDateChooser JDFFechaC;
    private JDateChooser JDFFechaPP;
    private JPanel JPID_Contable;
    private JPanel JPID_Exportar;
    private JPanel JPIDatosForma;
    private JPanel JPIDistribucionPPT;
    private JPanel JPITipo;
    private JPanel JPITipoPago;
    private JPanel JPI_DNomina;
    private JPanel JPI_DatosC;
    private JRadioButton JRBCheque;
    private JRadioButton JRBOtros;
    private JRadioButton JRBQuitarS;
    private JRadioButton JRBSDisfon;
    private JRadioButton JRBSTodo;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPResultado;
    private JScrollPane JSPResultado1;
    private JTextPane JTAObservacion;
    private JTabbedPane JTB_DatosM;
    public JTable JTDetallePresupuesto;
    private JTextField JTFBusqueda;
    private JFormattedTextField JTFFNDoc_Cont;
    private JFormattedTextField JTFFNDoc_Ppt;
    private JFormattedTextField JTFFTotalizarPResupuesto;
    private JFormattedTextField JTFFTotalizarR;
    private JTextField JTFNCheque;
    private JTextField JTFRuta;
    private JTextField JTF_NComprobante;
    public JTable JTResultado;
    private JTabbedPane jTabbedPane1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xlleno2 = false;
    private int xtipopago = 0;
    private String xidcuentapuc = "0";
    private String xId_Banco = "0";
    private final IPpMovimientoService iPpMovimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
    private List<PpMovimiento> movimientosCompromiso = new ArrayList();

    public JIFGeneracionPagos_Directo(int xtipo) {
        this.xtipo = 0;
        initComponents();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_puc = "cc_puc_niif";
        } else {
            this.xcc_puc = "cc_puc";
        }
        this.xtipo = xtipo;
        this.xidgrupo = this.xct.llenarCombo("SELECT Id, concat(Id,'-',Nbre)as Nombre FROM cc_puc WHERE (Id_Nivel =3 and ClasificacionP=1)  ORDER BY Nbre ASC ", this.xidgrupo, this.JCBGrupo);
        this.JCBGrupo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v117, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JBGTipoP = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JTB_DatosM = new JTabbedPane();
        this.JPIDatosForma = new JPanel();
        this.JTFFTotalizarR = new JFormattedTextField();
        this.JPITipo = new JPanel();
        this.JRBSTodo = new JRadioButton();
        this.JRBQuitarS = new JRadioButton();
        this.JCBGrupo = new JComboBox();
        this.JCBSubCuenta = new JComboBox();
        this.JPITipoPago = new JPanel();
        this.JRBSDisfon = new JRadioButton();
        this.JRBCheque = new JRadioButton();
        this.JRBOtros = new JRadioButton();
        this.JTFNCheque = new JTextField();
        this.JDFFechaPP = new JDateChooser();
        this.JCHEnviarCorreo = new JCheckBox();
        this.JCB_CuentaBancaria = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JPID_Contable = new JPanel();
        this.JCBPeriodo_Cont = new JComboBox();
        this.JTFFNDoc_Cont = new JFormattedTextField();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDoc_Ppt = new JComboBox();
        this.JTFFNDoc_Ppt = new JFormattedTextField();
        this.JPIDistribucionPPT = new JPanel();
        this.JSPResultado1 = new JScrollPane();
        this.JTDetallePresupuesto = new JTable();
        this.JCHAplicaMovimientoPresupuestal = new JCheckBox();
        this.JCH_AplicaMP1 = new JCheckBox();
        this.JTFFTotalizarPResupuesto = new JFormattedTextField();
        this.JCH_Seleccionar = new JCheckBox();
        this.JPID_Exportar = new JPanel();
        this.JTFBusqueda = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JBT_Contabilidacion = new JButton();
        this.JCBTipoDoc_Cont1 = new JComboBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPI_DatosC = new JPanel();
        this.JCBTipoDoc_Cont = new JComboBox();
        this.JDFFechaC = new JDateChooser();
        this.JTF_NComprobante = new JTextField();
        this.JCH_Agrupado = new JCheckBox();
        this.JCH_FiltroMes = new JCheckBox();
        this.JPI_DNomina = new JPanel();
        this.JCB_NNomina = new JComboBox();
        this.JCB_NConcepto = new JComboBox();
        this.JCH_EsNomina = new JCheckBox();
        this.JBT_Reorganizar = new JButton();
        this.JCH_SinCausacion = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE PAGOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifgenerarpagos1");
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGeneracionPagos_Directo.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                JIFGeneracionPagos_Directo.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 204, 204));
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGeneracionPagos_Directo.2
            public void mouseClicked(MouseEvent evt) {
                JIFGeneracionPagos_Directo.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGeneracionPagos_Directo.this.JTResultadoPropertyChange(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JTB_DatosM.setForeground(Color.red);
        this.JTB_DatosM.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalizarR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setHorizontalAlignment(4);
        this.JTFFTotalizarR.setFont(new Font("Arial", 1, 13));
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipo.add(this.JRBSTodo);
        this.JRBSTodo.setFont(new Font("Arial", 1, 12));
        this.JRBSTodo.setSelected(true);
        this.JRBSTodo.setText("Seleccionar Todo");
        this.JRBSTodo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.4
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JRBSTodoActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBQuitarS);
        this.JRBQuitarS.setFont(new Font("Arial", 1, 12));
        this.JRBQuitarS.setText("Quitar Selección");
        this.JRBQuitarS.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.5
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JRBQuitarSActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSTodo).addGap(18, 18, 18).addComponent(this.JRBQuitarS)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSTodo).addComponent(this.JRBQuitarS)).addContainerGap(-1, 32767)));
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupo.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.6
            public void itemStateChanged(ItemEvent evt) {
                JIFGeneracionPagos_Directo.this.JCBGrupoItemStateChanged(evt);
            }
        });
        this.JCBSubCuenta.setFont(new Font("Arial", 1, 12));
        this.JCBSubCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPITipoPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipoP.add(this.JRBSDisfon);
        this.JRBSDisfon.setFont(new Font("Arial", 1, 12));
        this.JRBSDisfon.setSelected(true);
        this.JRBSDisfon.setText("Disfon");
        this.JRBSDisfon.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.7
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JRBSDisfonActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBCheque);
        this.JRBCheque.setFont(new Font("Arial", 1, 12));
        this.JRBCheque.setText("Cheque");
        this.JRBCheque.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.8
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JRBChequeActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBOtros);
        this.JRBOtros.setFont(new Font("Arial", 1, 12));
        this.JRBOtros.setText("Otro");
        this.JRBOtros.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.9
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JRBOtrosActionPerformed(evt);
            }
        });
        this.JTFNCheque.setEditable(false);
        this.JTFNCheque.setFont(new Font("Arial", 1, 13));
        this.JTFNCheque.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cheque", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPITipoPagoLayout = new GroupLayout(this.JPITipoPago);
        this.JPITipoPago.setLayout(JPITipoPagoLayout);
        JPITipoPagoLayout.setHorizontalGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPagoLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFNCheque, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPITipoPagoLayout.createSequentialGroup().addComponent(this.JRBSDisfon).addGap(18, 18, 18).addComponent(this.JRBCheque))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, 32767).addComponent(this.JRBOtros).addContainerGap()));
        JPITipoPagoLayout.setVerticalGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPagoLayout.createSequentialGroup().addGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSDisfon).addComponent(this.JRBCheque).addComponent(this.JRBOtros)).addGap(18, 18, 18).addComponent(this.JTFNCheque).addContainerGap()));
        this.JDFFechaPP.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha probable de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaPP.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaPP.setFont(new Font("Arial", 1, 12));
        this.JCHEnviarCorreo.setFont(new Font("Arial", 1, 12));
        this.JCHEnviarCorreo.setSelected(true);
        this.JCHEnviarCorreo.setText("Enviar Correo?");
        this.JCHEnviarCorreo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.10
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JCHEnviarCorreoActionPerformed(evt);
            }
        });
        this.JCB_CuentaBancaria.setFont(new Font("Arial", 1, 12));
        this.JCB_CuentaBancaria.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_CuentaBancaria.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.11
            public void itemStateChanged(ItemEvent evt) {
                JIFGeneracionPagos_Directo.this.JCB_CuentaBancariaItemStateChanged(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción o concepto de pago agrupado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPIDatosFormaLayout = new GroupLayout(this.JPIDatosForma);
        this.JPIDatosForma.setLayout(JPIDatosFormaLayout);
        JPIDatosFormaLayout.setHorizontalGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosFormaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFormaLayout.createSequentialGroup().addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosFormaLayout.createSequentialGroup().addComponent(this.JTFFTotalizarR, -2, 185, -2).addGap(28, 28, 28).addComponent(this.JPITipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, 32767).addComponent(this.JCHEnviarCorreo).addGap(18, 18, 18).addComponent(this.JDFFechaPP, -2, 156, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosFormaLayout.createSequentialGroup().addComponent(this.JCBGrupo, -2, 287, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSubCuenta, 0, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITipoPago, -2, -1, -2)).addGroup(JPIDatosFormaLayout.createSequentialGroup().addComponent(this.JCB_CuentaBancaria, -2, 708, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion))).addContainerGap()));
        JPIDatosFormaLayout.setVerticalGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFormaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPITipoPago, -2, -1, -2).addGroup(JPIDatosFormaLayout.createSequentialGroup().addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPITipo, -1, -1, 32767).addComponent(this.JTFFTotalizarR).addComponent(this.JCHEnviarCorreo).addComponent(this.JDFFechaPP, -2, 54, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBSubCuenta).addComponent(this.JCBGrupo, -2, 50, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCB_CuentaBancaria, -2, 50, -2).addComponent(this.JSPObservacion, -2, 74, -2)).addContainerGap(-1, 32767)));
        this.JTB_DatosM.addTab("FORMA", this.JPIDatosForma);
        this.JPID_Contable.setBorder(BorderFactory.createEtchedBorder());
        this.JCBPeriodo_Cont.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo_Cont.setBorder(BorderFactory.createTitledBorder((Border) null, "Período Contable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Cont.setEditable(false);
        this.JTFFNDoc_Cont.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Cont.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Cont.setHorizontalAlignment(0);
        this.JTFFNDoc_Cont.setFont(new Font("Arial", 1, 18));
        this.JCBPeriodo_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Período Presupuestal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Ppt.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.12
            public void itemStateChanged(ItemEvent evt) {
                JIFGeneracionPagos_Directo.this.JCBTipoDoc_PptItemStateChanged(evt);
            }
        });
        this.JTFFNDoc_Ppt.setEditable(false);
        this.JTFFNDoc_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Ppt.setHorizontalAlignment(0);
        this.JTFFNDoc_Ppt.setFont(new Font("Arial", 1, 18));
        GroupLayout JPID_ContableLayout = new GroupLayout(this.JPID_Contable);
        this.JPID_Contable.setLayout(JPID_ContableLayout);
        JPID_ContableLayout.setHorizontalGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ContableLayout.createSequentialGroup().addContainerGap().addGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ContableLayout.createSequentialGroup().addComponent(this.JCBPeriodo_Cont, -2, 238, -2).addGap(408, 408, 408).addComponent(this.JTFFNDoc_Cont, -2, 140, -2)).addGroup(JPID_ContableLayout.createSequentialGroup().addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Ppt, -2, 372, -2).addGap(18, 18, 18).addComponent(this.JTFFNDoc_Ppt, -2, 140, -2))).addContainerGap(371, 32767)));
        JPID_ContableLayout.setVerticalGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ContableLayout.createSequentialGroup().addContainerGap().addGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Cont, -2, 50, -2).addComponent(this.JTFFNDoc_Cont)).addGap(18, 18, 18).addGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Ppt, -2, 50, -2).addComponent(this.JTFFNDoc_Ppt)).addGap(32, 32, 32)));
        this.JTB_DatosM.addTab("DATOS CONTABLES Y/O PRESUPUESTALES", this.JPID_Contable);
        this.JSPResultado1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetallePresupuesto.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetallePresupuesto.setFont(new Font("Arial", 1, 12));
        this.JTDetallePresupuesto.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetallePresupuesto.setEditingColumn(1);
        this.JTDetallePresupuesto.setEditingRow(1);
        this.JTDetallePresupuesto.setGridColor(new Color(204, 204, 204));
        this.JTDetallePresupuesto.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetallePresupuesto.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetallePresupuesto.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGeneracionPagos_Directo.13
            public void mouseClicked(MouseEvent evt) {
                JIFGeneracionPagos_Directo.this.JTDetallePresupuestoMouseClicked(evt);
            }
        });
        this.JTDetallePresupuesto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGeneracionPagos_Directo.this.JTDetallePresupuestoPropertyChange(evt);
            }
        });
        this.JTDetallePresupuesto.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGeneracionPagos_Directo.15
            public void keyPressed(KeyEvent evt) {
                JIFGeneracionPagos_Directo.this.JTDetallePresupuestoKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JIFGeneracionPagos_Directo.this.JTDetallePresupuestoKeyTyped(evt);
            }
        });
        this.JSPResultado1.setViewportView(this.JTDetallePresupuesto);
        this.JCHAplicaMovimientoPresupuestal.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaMovimientoPresupuestal.setText("Aplica?");
        this.JCH_AplicaMP1.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMP1.setText("Aplicar valor del rubro?");
        this.JCH_AplicaMP1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.16
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JCH_AplicaMP1ActionPerformed(evt);
            }
        });
        this.JTFFTotalizarPResupuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarPResupuesto.setHorizontalAlignment(4);
        this.JTFFTotalizarPResupuesto.setFont(new Font("Arial", 1, 13));
        this.JCH_Seleccionar.setFont(new Font("Arial", 1, 12));
        this.JCH_Seleccionar.setText("Seleccionar");
        this.JCH_Seleccionar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.17
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JCH_SeleccionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDistribucionPPTLayout = new GroupLayout(this.JPIDistribucionPPT);
        this.JPIDistribucionPPT.setLayout(JPIDistribucionPPTLayout);
        JPIDistribucionPPTLayout.setHorizontalGroup(JPIDistribucionPPTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDistribucionPPTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDistribucionPPTLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIDistribucionPPTLayout.createSequentialGroup().addComponent(this.JCHAplicaMovimientoPresupuestal).addGap(18, 18, 18).addComponent(this.JCH_AplicaMP1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_Seleccionar).addGap(93, 93, 93).addComponent(this.JTFFTotalizarPResupuesto, -2, 185, -2)).addComponent(this.JSPResultado1, -2, 1106, -2)).addContainerGap(64, 32767)));
        JPIDistribucionPPTLayout.setVerticalGroup(JPIDistribucionPPTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDistribucionPPTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDistribucionPPTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDistribucionPPTLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAplicaMovimientoPresupuestal).addComponent(this.JCH_AplicaMP1).addComponent(this.JCH_Seleccionar)).addComponent(this.JTFFTotalizarPResupuesto, -2, 54, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado1, -2, 147, -2).addContainerGap(-1, 32767)));
        this.JTB_DatosM.addTab("DISTRIBUCIÓN PRESUPUESTAL", this.JPIDistribucionPPT);
        this.JTFBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda por tercero o documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBusqueda.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGeneracionPagos_Directo.18
            public void keyPressed(KeyEvent evt) {
                JIFGeneracionPagos_Directo.this.JTFBusquedaKeyPressed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.19
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGeneracionPagos_Directo.20
            public void mouseClicked(MouseEvent evt) {
                JIFGeneracionPagos_Directo.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBT_Contabilidacion.setFont(new Font("Arial", 1, 12));
        this.JBT_Contabilidacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.JBT_Contabilidacion.setText("Contabilización");
        this.JBT_Contabilidacion.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.21
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JBT_ContabilidacionActionPerformed(evt);
            }
        });
        GroupLayout JPID_ExportarLayout = new GroupLayout(this.JPID_Exportar);
        this.JPID_Exportar.setLayout(JPID_ExportarLayout);
        JPID_ExportarLayout.setHorizontalGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ExportarLayout.createSequentialGroup().addContainerGap(786, 32767).addComponent(this.JBTExportar, -2, 137, -2).addGap(244, 244, 244)).addGroup(JPID_ExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFBusqueda, -2, 536, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Contabilidacion, -2, 217, -2).addContainerGap()).addGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ExportarLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JTFRuta, -1, 758, 32767).addGap(389, 389, 389))));
        JPID_ExportarLayout.setVerticalGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPID_ExportarLayout.createSequentialGroup().addGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ExportarLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JTFBusqueda, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 83, 32767)).addGroup(JPID_ExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JBT_Contabilidacion, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.JBTExportar, -1, 50, 32767).addContainerGap()).addGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPID_ExportarLayout.createSequentialGroup().addContainerGap(164, 32767).addComponent(this.JTFRuta, -2, 50, -2).addGap(4, 4, 4))));
        this.JTB_DatosM.addTab("UTILIDADES", this.JPID_Exportar);
        this.JCBTipoDoc_Cont1.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Cont1.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento para pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPI_DatosC.setForeground(Color.red);
        this.JCBTipoDoc_Cont.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Cont.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Cont.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.22
            public void itemStateChanged(ItemEvent evt) {
                JIFGeneracionPagos_Directo.this.JCBTipoDoc_ContItemStateChanged(evt);
            }
        });
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JTF_NComprobante.setFont(new Font("Arial", 1, 12));
        this.JTF_NComprobante.setHorizontalAlignment(0);
        this.JTF_NComprobante.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Comprobante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Agrupado.setFont(new Font("Arial", 1, 12));
        this.JCH_Agrupado.setText("Es Agrupado?");
        this.JCH_Agrupado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.23
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JCH_AgrupadoActionPerformed(evt);
            }
        });
        this.JCH_FiltroMes.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroMes.setForeground(Color.red);
        this.JCH_FiltroMes.setText("Filtro por Mes?");
        this.JCH_FiltroMes.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.24
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JCH_FiltroMesActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosCLayout = new GroupLayout(this.JPI_DatosC);
        this.JPI_DatosC.setLayout(JPI_DatosCLayout);
        JPI_DatosCLayout.setHorizontalGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaC, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDoc_Cont, -2, 372, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_Agrupado).addComponent(this.JCH_FiltroMes)).addGap(18, 18, 18).addComponent(this.JTF_NComprobante, -2, 122, -2).addGap(25, 25, 25)));
        JPI_DatosCLayout.setVerticalGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTF_NComprobante, GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI_DatosCLayout.createSequentialGroup().addComponent(this.JCH_FiltroMes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_Agrupado)).addComponent(this.JDFFechaC, -2, 50, -2).addComponent(this.JCBTipoDoc_Cont, -2, 50, -2)))).addContainerGap()));
        this.jTabbedPane1.addTab("DATOS PARA COMPROBANTE", this.JPI_DatosC);
        this.JCB_NNomina.setFont(new Font("Arial", 1, 12));
        this.JCB_NNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_NNomina.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.25
            public void itemStateChanged(ItemEvent evt) {
                JIFGeneracionPagos_Directo.this.JCB_NNominaItemStateChanged(evt);
            }
        });
        this.JCB_NConcepto.setFont(new Font("Arial", 1, 12));
        this.JCB_NConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DNominaLayout = new GroupLayout(this.JPI_DNomina);
        this.JPI_DNomina.setLayout(JPI_DNominaLayout);
        JPI_DNominaLayout.setHorizontalGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DNominaLayout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JCB_NNomina, -2, 256, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_NConcepto, 0, 491, 32767).addContainerGap()));
        JPI_DNominaLayout.setVerticalGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DNominaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_NNomina, -2, 50, -2).addComponent(this.JCB_NConcepto, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("NOMINA", this.JPI_DNomina);
        this.JCH_EsNomina.setFont(new Font("Arial", 1, 12));
        this.JCH_EsNomina.setText("Es Nomina?");
        this.JCH_EsNomina.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.26
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JCH_EsNominaActionPerformed(evt);
            }
        });
        this.JBT_Reorganizar.setFont(new Font("Arial", 1, 12));
        this.JBT_Reorganizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_Reorganizar.setText("<html><P ALIGN=center>Reorganizar consecutivo");
        this.JBT_Reorganizar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.27
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JBT_ReorganizarActionPerformed(evt);
            }
        });
        this.JCH_SinCausacion.setFont(new Font("Arial", 1, 12));
        this.JCH_SinCausacion.setText("Sin causación?");
        this.JCH_SinCausacion.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos_Directo.28
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos_Directo.this.JCH_SinCausacionActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTB_DatosM, GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(4, 4, 4).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDoc_Cont1, 0, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JCH_EsNomina).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_SinCausacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Reorganizar, -2, 143, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 797, -2))).addContainerGap()).addComponent(this.JSPResultado));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_EsNomina).addComponent(this.JCH_SinCausacion)).addGap(18, 18, 18)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBT_Reorganizar, -2, -1, -2).addGap(10, 10, 10))).addComponent(this.JCBTipoDoc_Cont1, -2, 50, -2)).addComponent(this.jTabbedPane1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 293, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addComponent(this.JTB_DatosM, -2, 249, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            if (this.JTResultado.getSelectedColumn() == 0) {
                Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString(), "CC_LiquidacionFactura_N", "4", "", "");
                return;
            }
            if (this.JTResultado.getSelectedColumn() == 6) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
                    int contador = 0;
                    for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                        if (Boolean.valueOf(this.JTResultado.getValueAt(x, 6).toString()).booleanValue()) {
                            contador++;
                        }
                    }
                    if (contador > 1) {
                        this.JCH_Agrupado.setSelected(true);
                    }
                }
                mCargarDistribucionPPT();
                return;
            }
            if (this.JTResultado.getSelectedColumn() == 25 || this.JTResultado.getSelectedColumn() == 26) {
                JDPatologia x2 = new JDPatologia((Frame) null, true, (Object) this, this.JTResultado.getSelectedRow());
                x2.setVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSTodoActionPerformed(ActionEvent evt) {
        mSeleccionar(true);
        mCargarDistribucionPPT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBQuitarSActionPerformed(ActionEvent evt) {
        mSeleccionar(false);
        mCargarDistribucionPPT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBGrupo.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBSubCuenta.removeAllItems();
            String sql = "SELECT Id, concat(Id,'-',Nbre)as Nombre FROM " + this.xcc_puc + " WHERE (Id LIKE'" + this.xidgrupo[this.JCBGrupo.getSelectedIndex()] + "%' AND UNivel=1) ORDER BY Nbre ASC ";
            this.xidsubcuenta = xct1.llenarCombo(sql, this.xidsubcuenta, this.JCBSubCuenta);
            this.JCBSubCuenta.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mTotalizarReembolso();
            if (!this.JCH_EsNomina.isSelected()) {
                mAjustarValorDistribucionPpt();
            }
        }
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
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCB_CuentaBancaria.getSelectedIndex() != -1) {
                this.JTFNCheque.setText("" + (Long.valueOf(this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][3]).longValue() + 1));
            }
            this.JTFNCheque.setEditable(true);
            this.JTFNCheque.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOtrosActionPerformed(ActionEvent evt) {
        this.xtipopago = 2;
        this.JTFNCheque.setText("");
        this.JTFNCheque.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEnviarCorreoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTResultado.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_CuentaBancariaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCB_CuentaBancaria.getSelectedIndex() != -1) {
            this.xId_Banco = this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][0];
            if (this.JRBCheque.isSelected()) {
                this.JTFNCheque.setText("" + (Long.valueOf(this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][3]).longValue() + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePresupuestoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePresupuestoPropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetallePresupuesto.getSelectedColumn() == 3 && this.JTDetallePresupuesto.getRowCount() != 0 && Double.valueOf(this.modeloPresupuesto.getValueAt(this.JTDetallePresupuesto.getSelectedRow(), 3).toString()).doubleValue() > Double.valueOf(this.modeloPresupuesto.getValueAt(this.JTDetallePresupuesto.getSelectedRow(), 2).toString()).doubleValue()) {
            JOptionPane.showInternalMessageDialog(this, "Valor a Pagar no puede ser mayor a Valor del Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.modeloPresupuesto.setValueAt(Double.valueOf(this.modeloPresupuesto.getValueAt(this.JTDetallePresupuesto.getSelectedRow(), 2).toString()), this.JTDetallePresupuesto.getSelectedRow(), 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDoc_ContItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoDoc_Cont.getSelectedIndex() != -1) {
            mConcecutivo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AgrupadoActionPerformed(ActionEvent evt) {
        if (this.JTResultado.getRowCount() != -1) {
            if (this.JCH_Agrupado.isSelected()) {
                for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                    this.xmodelo.setValueAt(this.JTF_NComprobante.getText(), x, 17);
                }
                return;
            }
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_NNominaItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCB_NNomina.getSelectedIndex() != -1) {
            this.JCB_NConcepto.removeAllItems();
            this.xsql = "SELECT\n    `rh_tipo_clasificacion_conceptonomina`.`Id`\n    , `rh_tipo_clasificacion_conceptonomina`.`Nbre`\nFROM\n    .`rh_nomina_liquidacion_detalle`\n    INNER JOIN .`rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN .`rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN .`rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n    INNER JOIN .`rh_tipo_clasificacion_conceptonomina` \n        ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)\nWHERE (`rh_nomina_liquidacion`.`Id` ='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "'\n    AND `rh_tipo_clasificacion_conceptonomina`.`EsContable` =1)\nGROUP BY `rh_tipo_clasificacion_conceptonomina`.`Id`\nORDER BY `rh_tipo_clasificacion_conceptonomina`.`Nbre` ASC";
            this.xId_ConceptoN = this.xct.llenarCombo(this.xsql, this.xId_ConceptoN, this.JCB_NConcepto);
            this.JCB_NConcepto.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_EsNominaActionPerformed(ActionEvent evt) {
        mLlenarCombo_TipoDoc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_ReorganizarActionPerformed(ActionEvent evt) {
        if (this.JTResultado.getRowCount() != -1) {
            long xcons = this.xConsecutivo;
            for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 6).toString()).booleanValue()) {
                    this.xmodelo.setValueAt(Long.valueOf(xcons), x, 17);
                    xcons++;
                }
            }
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
    public void JTFBusquedaKeyPressed(KeyEvent evt) {
        if (!this.JTFBusqueda.getText().isEmpty()) {
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePresupuestoKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePresupuestoKeyPressed(KeyEvent evt) {
        if (this.JTDetallePresupuesto.getSelectedColumn() == 3 && this.JTDetallePresupuesto.getRowCount() != 0 && evt.getKeyCode() == 10 && Double.valueOf(this.modeloPresupuesto.getValueAt(this.JTDetallePresupuesto.getSelectedRow(), 3).toString()).doubleValue() > Double.valueOf(this.modeloPresupuesto.getValueAt(this.JTDetallePresupuesto.getSelectedRow(), 2).toString()).doubleValue()) {
            JOptionPane.showInternalMessageDialog(this, "Valor a Pagar no puede ser mayor a Valor del Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.modeloPresupuesto.setValueAt(Double.valueOf(this.modeloPresupuesto.getValueAt(this.JTDetallePresupuesto.getSelectedRow(), 2).toString()), this.JTDetallePresupuesto.getSelectedRow(), 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_ContabilidacionActionPerformed(ActionEvent evt) {
        if (this.JTResultado.getRowCount() == -1 || !this.xmt.mVerificarDatosTablaTrue(this.JTResultado, 6)) {
            JOptionPane.showInternalMessageDialog(this, "Falta seleccion de datos y/o tabla sin información", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (Double.valueOf(this.JTFFTotalizarR.getValue().toString()).doubleValue() != 0.0d) {
            if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                mCargarDocPantallaContable();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JDFFechaC.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Falta registro de valor pagado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTB_DatosM.setSelectedIndex(0);
        this.JTFFTotalizarR.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AplicaMP1ActionPerformed(ActionEvent evt) {
        if (this.JCH_AplicaMP1.isSelected()) {
            for (int x = 0; x < this.JTDetallePresupuesto.getRowCount(); x++) {
                this.modeloPresupuesto.setValueAt(Double.valueOf(Double.parseDouble(this.modeloPresupuesto.getValueAt(x, 2).toString())), x, 3);
            }
            return;
        }
        mCargarDistribucionPPT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SinCausacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroMesActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SeleccionarActionPerformed(ActionEvent evt) {
        boolean seleccionar = true;
        if (!this.JCH_Seleccionar.isSelected()) {
            seleccionar = false;
        }
        if (this.JTDetallePresupuesto.getRowCount() >= 1) {
            for (int i = 0; i < this.JTDetallePresupuesto.getRowCount(); i++) {
                if (seleccionar) {
                    this.modeloPresupuesto.setValueAt(true, i, 4);
                } else {
                    this.modeloPresupuesto.setValueAt(false, i, 4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDoc_PptItemStateChanged(ItemEvent evt) {
        String sql = "SELECT id FROM pp_tipo_documentos WHERE (Nbre ='" + this.JCBTipoDoc_Ppt.getSelectedItem() + "' )";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                this.tipoDocPresupuesto = xrs1.getInt("id");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public boolean isCellEditable(int row, int column) {
        return this.JTResultado.getModel().isCellEditable(row, column);
    }

    private void mCargarDistribucionPPT() {
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            String xcodigopro = "";
            String xIdObligacion = "";
            String xIdConcepto = "";
            String xIdTercero = "";
            String xidDocumentoC = "";
            for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 6).toString()).booleanValue()) {
                    if (this.JCH_EsNomina.isSelected()) {
                        xcodigopro = xcodigopro + "," + this.xmodelo.getValueAt(x, 19).toString();
                        xIdObligacion = xIdObligacion + "," + this.xmodelo.getValueAt(x, 23).toString();
                        xIdConcepto = xIdConcepto + "," + this.xmodelo.getValueAt(x, 22).toString();
                        xIdTercero = xIdTercero + "," + this.xmodelo.getValueAt(x, 9).toString();
                        xidDocumentoC = xidDocumentoC + "," + this.xmodelo.getValueAt(x, 0).toString();
                    } else {
                        xIdObligacion = xIdObligacion + "," + this.xmodelo.getValueAt(x, 23).toString();
                        xcodigopro = xcodigopro + "," + this.xmodelo.getValueAt(x, 0).toString();
                        xIdTercero = xIdTercero + "," + this.xmodelo.getValueAt(x, 9).toString();
                        xidDocumentoC = xidDocumentoC + "," + this.xmodelo.getValueAt(x, 0).toString();
                    }
                }
            }
            if (this.JCHAplicaMovimientoPresupuestal.isSelected()) {
                System.out.println("xIdObligacion->" + xIdObligacion + " xIdConcepto->" + xIdConcepto + " xIdTercero->" + xIdTercero + " xidDocumentoC->" + xidDocumentoC);
                if (xcodigopro.length() > 1) {
                    mCargarDatos_DistribucionPPT(xcodigopro, xIdObligacion, xIdConcepto, xIdTercero, xidDocumentoC);
                    if (!this.JCH_EsNomina.isSelected() && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO")) {
                        mAjustarValorDistribucionPpt();
                        return;
                    }
                    return;
                }
                crearTablaDistribucionPresupuestal();
            }
        }
    }

    private void mNuevo_DPpt() {
        this.JTFFNDoc_Ppt.setText("");
        this.JCBTipoDoc_Ppt.removeAllItems();
        this.JCBPeriodo_Ppt.removeAllItems();
        this.xsql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=6 ";
        this.xidtipodoc_ppt = this.xct.llenarCombo(this.xsql, this.xidtipodoc_ppt, this.JCBTipoDoc_Ppt);
        this.xidperiodo_ppt = this.xct.llenarComboyLista("SELECT `Id` , CONCAT(`Nbre` ,'-',DATE_FORMAT(`FechaI`, '%Y')) AS Nbre, idEncabezado FROM `pp_periodo` WHERE (`Cerrado` =0) ORDER BY `FechaI` DESC", this.xidperiodo_ppt, this.JCBPeriodo_Ppt, 3);
        if (this.xidperiodo_ppt.length > 1) {
            this.JCBPeriodo_Ppt.setSelectedIndex(0);
        }
        this.xct.cerrarConexionBd();
    }

    private void mNuevo_DContabilidad() {
        this.JTFFNDoc_Cont.setText("");
        this.JCBTipoDoc_Cont.removeAllItems();
        this.JCBPeriodo_Cont.removeAllItems();
        this.xsql = "SELECT `Id`, `Nbre`, NConsecutivo, NReporte FROM  `cc_tipo_documentoc` WHERE (IdClasificacion=3 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc_cont = this.xct.llenarComboyLista(this.xsql, this.xidtipodoc_cont, this.JCBTipoDoc_Cont, 4);
        if (this.xidtipodoc_cont.length > 1) {
            this.JCBTipoDoc_Cont.setSelectedIndex(-1);
        }
        this.xidperiodo_cont = this.xct.llenarCombo("SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Periodo FROM cc_periodo_contable WHERE (Estado =1 and Activo=1 AND EsCierre=0) ORDER BY FechaF DESC", this.xidperiodo_cont, this.JCBPeriodo_Cont);
        if (this.xidperiodo_cont.length > 1) {
            this.JCBPeriodo_Cont.setSelectedIndex(0);
        }
        this.xct.cerrarConexionBd();
        mLlenarCombo_TipoDoc();
    }

    private void mLlenarCombo_TipoDoc() {
        this.xlleno1 = false;
        this.JCBTipoDoc_Cont1.removeAllItems();
        this.JCB_NConcepto.removeAllItems();
        this.JCB_NNomina.removeAllItems();
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL")) {
        }
        if (this.JCH_EsNomina.isSelected()) {
            this.xsql = "SELECT  `cc_tipo_documentoc`.`Id` , `cc_tipo_documentoc`.`Nbre`\nFROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  INNER JOIN  `cc_tipo_documentoc`   ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`)\nWHERE (`cc_documentoc`.`Id_Nomina` <>0)\nGROUP BY `cc_tipo_documentoc`.`Id` ORDER BY `cc_tipo_documentoc`.`Nbre` ASC";
        } else {
            this.xsql = "SELECT cc_tipo_documentoc.`Id`, cc_tipo_documentoc.`Nbre`\nFROM cc_tipo_documentoc \nWHERE (`cc_tipo_documentoc`.`IdClasificacion`=2 )\nGROUP BY cc_tipo_documentoc.`Id` ORDER BY cc_tipo_documentoc.`Nbre` ";
            if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
                this.xsql = "SELECT\n  cc_tipo_documentoc.`Id`,\n  cc_tipo_documentoc.`Nbre`\nFROM\n  cc_radicacion\n  INNER JOIN cc_documentoc\n    ON (\n      cc_radicacion.Id = cc_documentoc.Id_Radicacion\n    )\n  INNER JOIN g_empresa\n    ON (\n      cc_radicacion.Id_Proveedor = g_empresa.Id\n    )\n  INNER JOIN cc_puc\n    ON (\n      cc_radicacion.Id_CuentaAuxPPagar = cc_puc.Id\n    )\n  INNER JOIN cc_detalle_documentoc\n    ON (\n      cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id\n    )\n    AND (\n      cc_radicacion.Id_CuentaAuxPPagar = cc_detalle_documentoc.Id_Puc\n    )\n  LEFT JOIN cc_detalle_firma_documentoc\n    ON (\n      cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id\n    )\n  INNER JOIN cc_tipo_documentoc\n    ON (\n      cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id\n    )\n  LEFT JOIN `pp_movimiento`\n    ON (\n      cc_documentoc.`Id` = pp_movimiento.`IdDocContable`\n    )\n  LEFT JOIN `pp_detalle_movimiento`\n    ON (\n      pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`\n    )\n  LEFT JOIN `cc_radicacion_pago`\n    ON (\n      cc_radicacion_pago.`Id_Radicacion` = cc_radicacion.`Id`\n    )\nWHERE (\n    `cc_tipo_documentoc`.`IdClasificacion` = 2\n    AND cc_documentoc.GenerarC = 0\n    -- AND cc_detalle_firma_documentoc.Autorizo = 1\n   -- AND cc_documentoc.EstadoA = 1\n    AND cc_documentoc.Estado = 1\n    AND cc_radicacion.Estado = 1\n  )\nGROUP BY cc_tipo_documentoc.`Id`\nORDER BY cc_tipo_documentoc.`Nbre`";
            }
        }
        System.out.println("Documentos para pagos  " + this.xsql);
        this.xidtipodoc_contp = this.xct.llenarCombo(this.xsql, this.xidperiodo_cont, this.JCBTipoDoc_Cont1);
        if (this.xidtipodoc_contp.length > 1) {
            this.JCBTipoDoc_Cont1.setSelectedIndex(0);
        }
        this.xsql = "SELECT `rh_nomina_liquidacion`.`Id` , CONCAT(`rh_nomina_liquidacion`.`Id`,' ',`rh_nomina_periodo`.`Nbre`,' ',`rh_nomina_liquidacion`.`Ano`) AS Nbre\nFROM `rh_nomina_liquidacion_detalle`  INNER JOIN  `rh_nomina_liquidacion`   ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\nINNER JOIN  `rh_nomina_periodo`ON (`rh_nomina_periodo`.`Id` = `rh_nomina_liquidacion`.`Id_Periodo`)\nWHERE (`rh_nomina_liquidacion`.`Estado` =1 AND `rh_nomina_liquidacion`.`Cerrada` =0)\nGROUP BY `rh_nomina_liquidacion`.`Id`\nORDER BY `rh_nomina_liquidacion`.`Id` DESC";
        this.xId_Nomina = this.xct.llenarCombo(this.xsql, this.xId_Nomina, this.JCB_NNomina);
        this.JCB_NNomina.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno1 = true;
    }

    public void mGrabar() {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTResultado, 6)) {
            if (this.JRBSDisfon.isSelected() || this.JRBOtros.isSelected()) {
                if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                    mGrabarD();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JDFFechaC.requestFocus();
                    return;
                }
            }
            if (this.JRBCheque.isSelected()) {
                if (!this.JTFNCheque.getText().isEmpty()) {
                    if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                        mGrabarD();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JDFFechaC.requestFocus();
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar en numero del cheque", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNCheque.requestFocus();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un pago", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGrabarD() {
        if (this.JCBSubCuenta.getSelectedIndex() != -1) {
            if (this.JCHAplicaMovimientoPresupuestal.isSelected() && Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 7) && !this.xmt.mVerificarDatosLLeno(this.JTDetallePresupuesto, 0)) {
                    mGrabarD1();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Falta cuenta contable y/o rubro presupuestal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (this.JCHAplicaMovimientoPresupuestal.isSelected() && Principal.informacionIps.getManejaContabilidad().intValue() == 0) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 0)) {
                    mGrabarD1();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Falta  rubro presupuestal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (!this.JCHAplicaMovimientoPresupuestal.isSelected() && Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 7)) {
                    mGrabarD1();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Falta  cuenta contable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            mGrabarD1();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la subcuenta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBSubCuenta.requestFocus();
    }

    private void mCargarDocPantallaContable() {
        if (this.JCBSubCuenta.getSelectedIndex() != -1) {
            if (this.JCHAplicaMovimientoPresupuestal.isSelected() && Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 7) && !this.xmt.mVerificarDatosLLeno(this.JTDetallePresupuesto, 0)) {
                    Principal.xclase.cargarPantalla("Documento Contable", this);
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Falta cuenta contable y/o rubro presupuestal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (this.JCHAplicaMovimientoPresupuestal.isSelected() && Principal.informacionIps.getManejaContabilidad().intValue() == 0) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 0)) {
                    Principal.xclase.cargarPantalla("Documento Contable", this);
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Falta  rubro presupuestal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (!this.JCHAplicaMovimientoPresupuestal.isSelected() && Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 7)) {
                    Principal.xclase.cargarPantalla("Documento Contable", this);
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Falta  cuenta contable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            Principal.xclase.cargarPantalla("Documento Contable", this);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la subcuenta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBSubCuenta.requestFocus();
    }

    private void mGrabarD1() {
        String idTercero;
        mConsecutivoPresupuesto();
        System.out.println("consecutivoPresupuesto ->> " + this.consecutivoPresupuesto);
        long xidNomina = 0;
        if (this.JCH_EsNomina.isSelected()) {
            xidNomina = Long.valueOf(this.xmodelo.getValueAt(0, 3).toString()).longValue();
        }
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            if (this.JCH_Agrupado.isSelected()) {
                String sql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC, TipoPago, NCheque,Id_CuentaEmpresaP, NConsecutivo, Descripcion, Id_Nomina, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][0] + "','" + this.xidperiodo_cont[this.JCBPeriodo_Cont.getSelectedIndex()] + "','" + this.xtipopago + "','" + this.JTFNCheque.getText() + "','" + this.xId_Banco + "','" + this.JTF_NComprobante.getText() + "','" + this.JTAObservacion.getText() + "','" + xidNomina + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.JTFFNDoc_Cont.setText(this.xct.ejecutarSQLId(sql));
                this.xct.cerrarConexionBd();
                String sqlNcons = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][0] + "' and Id = '" + this.JTFFNDoc_Cont.getText() + "');";
                this.xct.traerDato(sqlNcons);
                this.xct.cerrarConexionBd();
                for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                    if (this.JTResultado.getValueAt(y, 6).toString().equals("true")) {
                        String sql2 = "insert into cc_detalle_documentoc(Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, NFactura, VDebito, VCredito,  Concepto) values('" + this.JTFFNDoc_Cont.getText() + "','" + this.xmodelo.getValueAt(y, 7).toString() + "','" + this.xmodelo.getValueAt(y, 9).toString() + "','" + this.xmodelo.getValueAt(y, 5).toString() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "','" + this.xmodelo.getValueAt(y, 18).toString() + "','0','" + this.xmodelo.getValueAt(y, 14).toString() + "')";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S")) {
                            idTercero = String.valueOf(Principal.informacionIps.getIdEmpresa());
                        } else {
                            idTercero = this.xmodelo.getValueAt(y, 5).toString();
                        }
                        String sql3 = "insert into cc_detalle_documentoc(Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, NFactura, TipoCPuc, VDebito, VCredito,  Concepto) values('" + this.JTFFNDoc_Cont.getText() + "','" + this.xidsubcuenta[this.JCBSubCuenta.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(y, 24).toString() + "','" + idTercero + "','" + this.xmodelo.getValueAt(y, 3).toString() + "','1','0','" + this.xmodelo.getValueAt(y, 18).toString() + "','" + this.xmodelo.getValueAt(y, 14).toString() + "')";
                        this.xct.ejecutarSQL(sql3);
                        this.xct.cerrarConexionBd();
                        if (!this.JCH_SinCausacion.isSelected() && !this.JCH_EsNomina.isSelected() && !this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 28).toString().trim().equals("4")) {
                            String sql4 = "insert into cc_radicacion_pago(`Id_Radicacion` , Id_Puc, `Id_Documento` , `Valor` ) values('" + this.xmodelo.getValueAt(y, 5).toString() + "','" + this.xmodelo.getValueAt(y, 7).toString() + "','" + this.JTFFNDoc_Cont.getText() + "','" + this.xmodelo.getValueAt(y, 18).toString() + "')";
                            this.xct.ejecutarSQL(sql4);
                            this.xct.cerrarConexionBd();
                        }
                        if (this.JCHAplicaMovimientoPresupuestal.isSelected() && !this.xmodelo.getValueAt(y, 15).toString().equals("") && this.JTDetallePresupuesto.getRowCount() != -1 && !this.xmt.mVerificarDatosTablaTrue(this.JTDetallePresupuesto, 8)) {
                            this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,IdCompromiso, IdDocContable,IdObligacion, IdUsuarioR,`UsuarioS`, NoConcecutivo)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.JTAObservacion.getText() + " COMPROBANTE DE EGRESO N° " + this.JTFFNDoc_Cont.getText() + "','" + this.xmodelo.getValueAt(y, 19).toString() + "','" + this.JTFFNDoc_Cont.getText() + "','" + this.xmodelo.getValueAt(y, 21).toString() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "' ,'" + this.consecutivoPresupuesto + "');";
                            this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
                            this.xct.cerrarConexionBd();
                            for (int z = 0; z < this.JTDetallePresupuesto.getRowCount(); z++) {
                                if (this.JCH_Agrupado.isSelected()) {
                                    if (!Boolean.valueOf(this.modeloPresupuesto.getValueAt(z, 8).toString()).booleanValue() && Boolean.valueOf(this.JTDetallePresupuesto.getValueAt(z, 4).toString()).booleanValue()) {
                                        this.xsql = " insert into `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado, `Id_Tercero`,NFactura,Valor,Observacion,idRubrosCentroCostos,idRubrosFunteFinanciacion,idRubrosCpc, idTopoVigencia)\n values ('" + this.JTFFNDoc_Ppt.getText() + "','" + this.modeloPresupuesto.getValueAt(z, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y, 9).toString() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 3).toString() + "','" + this.xmodelo.getValueAt(y, 14).toString() + " COMPROBANTE DE EGRESO N° " + this.JTF_NComprobante.getText() + "','" + this.modeloPresupuesto.getValueAt(z, 10).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 12).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 14).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 16).toString() + "');";
                                        this.xct.ejecutarSQL(this.xsql);
                                        this.xct.cerrarConexionBd();
                                        this.modeloPresupuesto.setValueAt(true, z, 8);
                                    }
                                } else if (!Boolean.valueOf(this.modeloPresupuesto.getValueAt(z, 8).toString()).booleanValue() && Boolean.valueOf(this.JTDetallePresupuesto.getValueAt(z, 4).toString()).booleanValue() && this.JTDetallePresupuesto.getValueAt(z, 5).toString().equals(this.JTResultado.getValueAt(y, 0).toString())) {
                                    this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado, `Id_Tercero`,NFactura,Valor,Observacion,idRubrosCentroCostos, idRubrosFunteFinanciacion, idRubrosCpc, idTopoVigencia)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.modeloPresupuesto.getValueAt(z, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y, 9).toString() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 3).toString() + "','" + this.xmodelo.getValueAt(y, 14).toString() + " COMPROBANTE DE EGRESO N° " + this.JTF_NComprobante.getText() + "','" + this.modeloPresupuesto.getValueAt(z, 10).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 12).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 14).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 16).toString() + "');";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                    this.modeloPresupuesto.setValueAt(true, z, 8);
                                }
                            }
                        }
                        if (!this.JCH_EsNomina.isSelected()) {
                            Principal.xclase.mActulizarPagoRadicacion(this.JTFFNDoc_Cont.getText(), this.xmodelo.getValueAt(y, 5).toString());
                        } else {
                            this.xsql = "Update rh_nomina_liquidacion_detalle set Id_DocContableE='" + this.JTFFNDoc_Cont.getText() + "' WHERE (`Id_ConceptoCN` ='" + this.xmodelo.getValueAt(y, 20).toString() + "' AND `Id_Liquidacion` ='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "' AND `Id_Tercero` ='" + this.xmodelo.getValueAt(y, 9).toString() + "') ";
                            System.out.println("actualiza nomina : " + this.xsql);
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                }
                mGrabarUsuarioA(this.JTFFNDoc_Cont.getText());
                Principal.xclase.mImprimDocumentoContable("IdC", this.JTFFNDoc_Cont.getText(), this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][2], "2", this.JTFFTotalizarR.getValue().toString(), this.JTFFTotalizarR.getText());
                mActualizarNDocumentoDescuentoNota(this.JTFFNDoc_Cont.getText());
                if (this.JRBCheque.isSelected()) {
                    this.xsql = "update cc_cuentaxempresa  set  ConsecutivoA='" + this.JTFNCheque.getText() + "' where Id='" + this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][0] + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            } else {
                for (int y2 = 0; y2 < this.JTResultado.getRowCount(); y2++) {
                    if (this.JTResultado.getValueAt(y2, 6).toString().equals("true")) {
                        mConcecutivo();
                        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO")) {
                            this.xConsecutivo = Long.valueOf(this.xmodelo.getValueAt(y2, 17).toString()).longValue();
                        }
                        if (this.JCH_EsNomina.isSelected()) {
                        }
                        String sql5 = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_Radicacion, Id_PeriodoC, TipoPago, NCheque,Id_CuentaEmpresaP, NConsecutivo, Descripcion, Id_Nomina, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][0] + "','" + this.xmodelo.getValueAt(y2, 5).toString() + "','" + this.xidperiodo_cont[this.JCBPeriodo_Cont.getSelectedIndex()] + "','" + this.xtipopago + "','" + this.JTFNCheque.getText() + "','" + this.xId_Banco + "','" + this.xConsecutivo + "','" + this.JTAObservacion.getText() + "','" + xidNomina + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        String xid = this.xct.ejecutarSQLId(sql5);
                        this.xct.cerrarConexionBd();
                        String sqlNcons2 = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][0] + "' and Id = '" + xid + "');";
                        String nConsecutivo = this.xct.traerDato(sqlNcons2);
                        this.xct.cerrarConexionBd();
                        this.JTFFNDoc_Cont.setText(xid);
                        String sql6 = "insert into cc_detalle_documentoc(Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, NFactura, VDebito, VCredito,  Concepto) values('" + xid + "','" + this.xmodelo.getValueAt(y2, 7).toString() + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "','" + this.xmodelo.getValueAt(y2, 5).toString() + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','" + this.xmodelo.getValueAt(y2, 18).toString() + "','0','" + this.xmodelo.getValueAt(y2, 14).toString() + "')";
                        this.xct.ejecutarSQL(sql6);
                        this.xct.cerrarConexionBd();
                        String sql7 = "insert into cc_detalle_documentoc(Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, NFactura, TipoCPuc, VDebito, VCredito,  Concepto) values('" + xid + "','" + this.xidsubcuenta[this.JCBSubCuenta.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(y2, 24).toString() + "','" + this.xmodelo.getValueAt(y2, 5).toString() + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','1','0','" + this.xmodelo.getValueAt(y2, 18).toString() + "','" + this.xmodelo.getValueAt(y2, 14).toString() + "')";
                        this.xct.ejecutarSQL(sql7);
                        this.xct.cerrarConexionBd();
                        if (!this.JCH_SinCausacion.isSelected()) {
                            if (!this.JCH_EsNomina.isSelected()) {
                                if (!this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 28).toString().trim().equals("4")) {
                                    String sql8 = "insert into cc_radicacion_pago(`Id_Radicacion` ,Id_Puc,  `Id_Documento` , `Valor` ) values('" + this.xmodelo.getValueAt(y2, 5).toString() + "','" + this.xmodelo.getValueAt(y2, 7).toString() + "','" + xid + "','" + this.xmodelo.getValueAt(y2, 18).toString() + "')";
                                    this.xct.ejecutarSQL(sql8);
                                    this.xct.cerrarConexionBd();
                                }
                            } else {
                                this.xsql = "Update rh_nomina_liquidacion_detalle set Id_DocContableE='" + this.JTFFNDoc_Cont.getText() + "' WHERE (`Id_ConceptoCN` ='" + this.xmodelo.getValueAt(y2, 20).toString() + "' AND `Id_Liquidacion` ='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "' AND `Id_Tercero` ='" + this.xmodelo.getValueAt(y2, 9).toString() + "') ";
                                System.out.println(" update nomina : " + this.xsql);
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                        }
                        if (this.JCHAplicaMovimientoPresupuestal.isSelected() && !this.xmodelo.getValueAt(y2, 15).toString().equals("") && this.JTDetallePresupuesto.getRowCount() != -1) {
                            this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,NoFact, IdDocContable, `IdDisponibilidad`  ,`IdCompromiso`, IdObligacion, IdUsuarioR,`UsuarioS`,NoConcecutivo)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xmodelo.getValueAt(y2, 14).toString() + " COMPROBANTE DE EGRESO N° " + nConsecutivo + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','" + xid + "','" + this.modeloPresupuesto.getValueAt(0, 6).toString() + "','" + this.modeloPresupuesto.getValueAt(0, 7).toString() + "','" + this.xmodelo.getValueAt(y2, 21).toString() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "' ,'" + this.consecutivoPresupuesto + "');";
                            this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
                            this.xct.cerrarConexionBd();
                            for (int z2 = 0; z2 < this.JTDetallePresupuesto.getRowCount(); z2++) {
                                if (((Long) this.xmodelo.getValueAt(y2, 28)).longValue() == 3) {
                                    this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado,`Id_Tercero`,NFactura, Valor,Observacion,idRubrosCentroCostos, idRubrosFunteFinanciacion, idRubrosCpc, idTopoVigencia)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.modeloPresupuesto.getValueAt(z2, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','" + this.modeloPresupuesto.getValueAt(z2, 3).toString() + "','" + this.xmodelo.getValueAt(y2, 14).toString() + " COMPROBANTE DE EGRESO N° " + xid + "','" + this.modeloPresupuesto.getValueAt(z2, 10).toString() + "','" + this.modeloPresupuesto.getValueAt(z2, 12).toString() + "','" + this.modeloPresupuesto.getValueAt(z2, 14).toString() + "','" + this.modeloPresupuesto.getValueAt(z2, 16).toString() + "');";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                    this.modeloPresupuesto.setValueAt(true, z2, 8);
                                } else if (Boolean.valueOf(this.JTDetallePresupuesto.getValueAt(z2, 4).toString()).booleanValue() && this.JTDetallePresupuesto.getValueAt(z2, 5).toString().equals(this.JTResultado.getValueAt(y2, 0).toString())) {
                                    this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado,`Id_Tercero`,NFactura, Valor,Observacion,idRubrosCentroCostos, idRubrosFunteFinanciacion, idRubrosCpc, idTopoVigencia)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.modeloPresupuesto.getValueAt(z2, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','" + this.modeloPresupuesto.getValueAt(z2, 3).toString() + "','" + this.xmodelo.getValueAt(y2, 14).toString() + " COMPROBANTE DE EGRESO N° " + xid + "','" + this.modeloPresupuesto.getValueAt(z2, 10).toString() + "','" + this.modeloPresupuesto.getValueAt(z2, 12).toString() + "','" + this.modeloPresupuesto.getValueAt(z2, 14).toString() + "','" + this.modeloPresupuesto.getValueAt(z2, 16).toString() + "');";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                    this.modeloPresupuesto.setValueAt(true, z2, 8);
                                }
                            }
                        }
                        Principal.xclase.mActulizarPagoRadicacion(xid, this.xmodelo.getValueAt(y2, 5).toString());
                        mGrabarUsuarioA(xid);
                        Principal.xclase.mImprimDocumentoContable("IdC", this.JTFFNDoc_Cont.getText(), this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][2], "2", this.JTFFTotalizarR.getValue().toString(), this.JTFFTotalizarR.getText());
                        mActualizarNDocumentoDescuentoNota(xid);
                        if (this.JRBCheque.isSelected()) {
                            this.xsql = "update cc_cuentaxempresa  set  ConsecutivoA='" + this.JTFNCheque.getText() + "' where Id='" + this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][0] + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                }
            }
            mNuevo();
            mCargarDatos();
        }
    }

    public void mGrabarDetallePago(String xIdDocumento) {
        if (!this.JCH_EsNomina.isSelected()) {
            for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                if (this.JTResultado.getValueAt(y, 6).toString().equals("true")) {
                    String sql = "insert into cc_radicacion_pago(`Id_Radicacion` , Id_Puc, `Id_Documento` , `Valor` ) values('" + this.xmodelo.getValueAt(y, 5).toString() + "','" + this.xmodelo.getValueAt(y, 7).toString() + "','" + xIdDocumento + "','" + this.xmodelo.getValueAt(y, 18).toString() + "')";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                }
            }
        }
    }

    private void mConcecutivo() {
        if (this.JCBTipoDoc_Cont.getSelectedIndex() != -1) {
            int Con = 0;
            String sql = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][0] + "' );";
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
                Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            this.xConsecutivo = Con + 1;
        }
    }

    private void mConsecutivoPresupuesto() {
        if (this.JCBTipoDoc_Cont.getSelectedIndex() != -1) {
            int Con = 0;
            String sql = "SELECT MAX(`NoConcecutivo`) AS MaximoCons \nFROM `pp_movimiento` m \nINNER JOIN `pp_detalle_movimiento` dm ON m.`Id`=dm.`Id_Movimiento`\nWHERE (`Id_TipoDoc` ='" + this.tipoDocPresupuesto + "' AND dm.`idEncabezado` = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
            System.out.println("consecutivo ppt -> " + sql);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs1 = xct1.traerRs(sql);
            try {
                if (xrs1.next()) {
                    xrs1.first();
                    Con = xrs1.getInt("MaximoCons");
                } else {
                    Con = 0;
                }
                xrs1.close();
                xct1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            System.out.println("Con -> " + Con);
            this.consecutivoPresupuesto = Con + 1;
            System.out.println("consecutivoPresupuesto -> " + this.consecutivoPresupuesto);
        }
    }

    private void mGrabarUsuarioA(String xid_doc) {
        try {
            String xsql = "SELECT cc_usuarioxdocumentof.Id, persona.Corre FROM persona INNER JOIN cc_usuarioxdocumentof ON (persona.Id_persona = cc_usuarioxdocumentof.Id_Persona) WHERE ( cc_usuarioxdocumentof.Id_TipoDocF ='2' AND cc_usuarioxdocumentof.Estado =1) ";
            ResultSet rs = this.xct.traerRs(xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    String xsql2 = "insert into cc_detalle_firma_documentoc (Id_OrdenDc, Id_UsuarioF) values('" + xid_doc + "','" + rs.getInt(1) + "')";
                    xct.ejecutarSQL(xsql2);
                    xct.cerrarConexionBd();
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.xId_Banco = "0";
        this.JCB_CuentaBancaria.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xsql = "SELECT cc_cuentaxempresa.`Id`,  CONCAT(`cc_banco`.`Nbre` ,' Cuenta N° ', `cc_cuentaxempresa`.`NCuenta`,' ', `cc_tipo_cuenta`.`Nbre`) AS `Cuenta` , `cc_cuentaxempresa`.`ACheque` , `cc_cuentaxempresa`.`NInicio`, cc_cuentaxempresa.`ConsecutivoA`\nFROM `g_ips` INNER JOIN  `g_empresa`   ON (`g_ips`.`Id_gempresa` = `g_empresa`.`Id`) INNER JOIN  `cc_cuentaxempresa`   ON (`cc_cuentaxempresa`.`Id_Empresa` = `g_empresa`.`Id`) INNER JOIN  `cc_bancoxsucursal` \nON (`cc_cuentaxempresa`.`Id_SucursalxBanco` = `cc_bancoxsucursal`.`Id`) INNER JOIN  `cc_banco`  ON (`cc_bancoxsucursal`.`Id_Banco` = `cc_banco`.`Id`) INNER JOIN  `cc_tipo_cuenta`   ON (`cc_cuentaxempresa`.`Id_TipoCuenta` = `cc_tipo_cuenta`.`Id`)\nWHERE (`cc_cuentaxempresa`.`Estado` =1)\nORDER BY `cc_cuentaxempresa`.`EsPrincipal` DESC";
        this.xId_CuentasB = this.xct.llenarComboyLista(this.xsql, this.xId_CuentasB, this.JCB_CuentaBancaria, 5);
        this.JCB_CuentaBancaria.setSelectedIndex(-1);
        this.JDFFechaPP.setDate(this.xmt.getFechaActual());
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCH_Agrupado.setSelected(false);
        this.JCHEnviarCorreo.setSelected(false);
        this.JTAObservacion.setText("");
        mNuevo_DContabilidad();
        mNuevo_DPpt();
        crearTablaDistribucionPresupuestal();
        mCrearTabla();
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            this.JCHAplicaMovimientoPresupuestal.setSelected(true);
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.JTF_NComprobante.setVisible(true);
        } else {
            this.JTF_NComprobante.setVisible(false);
        }
        this.JCBPeriodo_Cont.setSelectedItem(Principal.xclase.getNombrePeriodo());
        this.xlleno = true;
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel() { // from class: Contabilidad.JIFGeneracionPagos_Directo.29
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Long.class, Boolean.class, String.class, String.class, String.class, Integer.class, Integer.class, Double.class, String.class, String.class, String.class, Double.class, Long.class, Double.class, Long.class, Long.class, Long.class, String.class, String.class, Long.class, String.class, String.class, Long.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("Id");
        this.xmodelo.addColumn("Fecha Radicación");
        this.xmodelo.addColumn("Tercero");
        this.xmodelo.addColumn("NFactura");
        this.xmodelo.addColumn("Neto a Pagar");
        this.xmodelo.addColumn("IdRadicado");
        this.xmodelo.addColumn("Generar");
        this.xmodelo.addColumn("CuentaPuc");
        this.xmodelo.addColumn("Nombre");
        this.xmodelo.addColumn("Id Empresa");
        this.xmodelo.addColumn("NotaCredito");
        this.xmodelo.addColumn("IdNC");
        this.xmodelo.addColumn("ValorDescontarNc");
        this.xmodelo.addColumn("Correo");
        this.xmodelo.addColumn("Cometario");
        this.xmodelo.addColumn("Rubro");
        this.xmodelo.addColumn("Valor_Rubro");
        this.xmodelo.addColumn("N° Comprobante");
        this.xmodelo.addColumn("Valor a Pagar");
        this.xmodelo.addColumn("Id_Compromiso");
        this.xmodelo.addColumn("Id_ConceptoCN");
        this.xmodelo.addColumn("Id_Obligacion");
        this.xmodelo.addColumn("Id_ConceptosNS");
        this.xmodelo.addColumn("Id_ObligacionAg");
        this.xmodelo.addColumn("IdTerceroCredito");
        this.xmodelo.addColumn("No. Documento");
        this.xmodelo.addColumn("Tercero Credito");
        this.xmodelo.addColumn("Dias_Cartera");
        this.xmodelo.addColumn("TipoRadiacion");
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTResultado.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(25).setPreferredWidth(120);
        this.JTResultado.getColumnModel().getColumn(26).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(28).setPreferredWidth(10);
        this.JTResultado.setModel(this.xmodelo);
    }

    private void crearTablaDistribucionPresupuestal() {
        this.modeloPresupuesto = new DefaultTableModel((Object[][]) null, new String[]{"Rubro", "Nombre", "V/Rubro", "V/Pagar", "Aplica", "Id_Documento", "Id_Disponibilidad", "Id_Compromiso", "Grabado", "IdRadicacion", "idCentroCostos", "Centro Costos", "idFuenteFinanciacion", "Fuente Financiacion", "idCpc", "CPC", "idTipoVigencia", "Vigencia"}) { // from class: Contabilidad.JIFGeneracionPagos_Directo.30
            Class[] types = {String.class, String.class, Double.class, Double.class, Boolean.class, Long.class, Long.class, Long.class, Boolean.class, Long.class, Integer.class, String.class, Integer.class, String.class, Integer.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetallePresupuesto;
        JTable jTable2 = this.JTDetallePresupuesto;
        jTable.setAutoResizeMode(0);
        this.JTDetallePresupuesto.doLayout();
        this.JTDetallePresupuesto.setModel(this.modeloPresupuesto);
        this.JTDetallePresupuesto.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetallePresupuesto.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetallePresupuesto.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetallePresupuesto.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetallePresupuesto.getColumnModel().getColumn(17).setPreferredWidth(100);
    }

    private void mCargarDatos() {
        String sql = "";
        mCrearTabla();
        if (this.JCH_EsNomina.isSelected()) {
            if (this.JCB_NConcepto.getSelectedIndex() != -1) {
                if (this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()].equals("2")) {
                    if (this.JTFBusqueda.getText().isEmpty()) {
                        sql = "SELECT `cc_documentoc`.`Id` , `cc_documentoc`.`FechaD` , `cc_terceros`.`RazonSocialCompleta` , `cc_documentoc`.`Id_Nomina`  , (`cc_detalle_documentoc`.`VCredito`- IFNULL(valorPagado.Valor,0)) VCredito   , 0 , `cc_puc`.`Id` , `cc_puc`.`Nbre` , `cc_terceros`.`Id`\n    , `cc_terceros`.`Correo` ,IFNULL(`cc_detalle_documentoc`.`Concepto`,\"\") AS Concepto , IF(rh_nomina_liquidacion_detalle.`RPresupuestal`='',`rh_nomina_concepto_unidadf`.`RPresupuesto`,rh_nomina_liquidacion_detalle.`RPresupuestal`) RPresupuestal , 0  , `rh_nomina_liquidacion_detalle`.`Id_Compromiso` AS IdCompromiso, rh_nomina_liquidacion_detalle.Id_ConceptoCN AS Id_ConceptoN, `rh_nomina_liquidacion_detalle`.`Id_Obligacion` AS IdObligacion, 0 NCredito, rh_nomina_liquidacion_detalle.`Id_DocContableE`, \n (SELECT GROUP_CONCAT(rh_nomina_liquidacion_detalle.`Id_ConceptoCN` SEPARATOR ',') IdCNS  \n \nFROM\n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n    INNER JOIN  `rh_tipo_clasificacion_conceptonomina` \n        ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)\nWHERE (`rh_tipo_clasificacion_conceptonomina`.`Id` ='" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "'\n    AND `rh_nomina_liquidacion_detalle`.`Id_Liquidacion` =`rh_nomina_liquidacion`.`Id`\n    AND `rh_nomina_liquidacion_detalle`.`Id_DocContable` =`cc_documentoc`.`Id`)) IdCNS, DATEDIFF(now(),`cc_documentoc`.`FechaD`) diasCartera \n    , GROUP_CONCAT(DISTINCT rh_nomina_liquidacion_detalle.`Id_Obligacion`) NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC, 0 as tipo \nFROM\n     `cc_detalle_documentoc`\n    INNER JOIN  `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN  `cc_terceros` \n        ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion`.`Id` = `cc_documentoc`.`Id_Nomina`)\n    left JOIN  `rh_nomina_liquidacion_detalle` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_detalle_documentoc`.`Id_Tercero`) AND (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    left JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_concepto_unidadf`.`CCredito` = `cc_puc`.`Id`) AND (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    left JOIN  `rh_nomina_persona_conceptos` \n        ON (`rh_nomina_persona_conceptos`.`Id_Tercero` = `cc_detalle_documentoc`.`Id_Tercero`) AND (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`)\n    left JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n    left JOIN  `rh_tipo_clasificacion_conceptonomina` \n        ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`) LEFT JOIN  (SELECT\n `cc_detalle_documentoc`.`Id_Puc`\n    , `cc_detalle_documentoc`.`Id_Tercero` \n    , SUM(`cc_detalle_documentoc`.`VDebito`) valor\n    , cc_documentoc.`Id_Nomina`\n    \nFROM\n     `cc_documentoc` \n    INNER JOIN  `cc_detalle_documentoc`\n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\nWHERE ( cc_documentoc.`Estado`=1 AND cc_documentoc.`Id_Nomina`<>0\t\n      AND `cc_detalle_documentoc`.`VDebito`<>0)\n    \n    GROUP BY `cc_detalle_documentoc`.`Id_Puc`, cc_documentoc.`Id_Nomina`, `cc_detalle_documentoc`.`Id_Tercero` ) valorPagado  \n    ON (`cc_detalle_documentoc`.`Id_Puc`=valorPagado.Id_Puc) AND (`cc_detalle_documentoc`.`Id_Tercero` =valorPagado.`Id_Tercero`) AND (valorPagado.Id_Nomina='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "') \nWHERE ( `cc_documentoc`.`Id_Nomina` ='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "' AND cc_documentoc.`Estado`=1 AND `rh_tipo_clasificacion_conceptonomina`.`Id` ='" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "')\nGROUP BY `cc_documentoc`.`Id_Nomina`, `cc_puc`.`Id`, `cc_terceros`.`Id`\nhaving VCredito>0\nORDER BY `cc_terceros`.`RazonSocialCompleta` ASC";
                    } else {
                        sql = "SELECT `cc_documentoc`.`Id` , `cc_documentoc`.`FechaD` , `cc_terceros`.`RazonSocialCompleta` , `cc_documentoc`.`Id_Nomina`  , (`cc_detalle_documentoc`.`VCredito`- IFNULL(valorPagado.Valor,0)) VCredito   , 0 , `cc_puc`.`Id` , `cc_puc`.`Nbre` , `cc_terceros`.`Id`\n    , `cc_terceros`.`Correo` ,IFNULL(`cc_detalle_documentoc`.`Concepto`,\"\") AS Concepto , IF(rh_nomina_liquidacion_detalle.`RPresupuestal`='',`rh_nomina_concepto_unidadf`.`RPresupuesto`,rh_nomina_liquidacion_detalle.`RPresupuestal`) RPresupuestal , 0  , `rh_nomina_liquidacion_detalle`.`Id_Compromiso` AS IdCompromiso, rh_nomina_liquidacion_detalle.Id_ConceptoCN AS Id_ConceptoN, `rh_nomina_liquidacion_detalle`.`Id_Obligacion` AS IdObligacion, 0 NCredito, rh_nomina_liquidacion_detalle.`Id_DocContableE`, (SELECT GROUP_CONCAT(rh_nomina_liquidacion_detalle.`Id_ConceptoCN` SEPARATOR ',') IdCNS\n \nFROM\n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n    INNER JOIN  `rh_tipo_clasificacion_conceptonomina` \n        ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)\nWHERE (`rh_tipo_clasificacion_conceptonomina`.`Id` ='" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "'\n    AND `rh_nomina_liquidacion_detalle`.`Id_Liquidacion` =`rh_nomina_liquidacion`.`Id`\n    AND `rh_nomina_liquidacion_detalle`.`Id_DocContable` =`cc_documentoc`.`Id`)) IdCNS, DATEDIFF(now(),`cc_documentoc`.`FechaD`) diasCartera \n    , GROUP_CONCAT(DISTINCT rh_nomina_liquidacion_detalle.`Id_Obligacion`) NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC , 0 as tipo\nFROM\n     `cc_detalle_documentoc`\n    INNER JOIN  `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN  `cc_terceros` \n        ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion`.`Id` = `cc_documentoc`.`Id_Nomina`)\n    left JOIN  `rh_nomina_liquidacion_detalle` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_detalle_documentoc`.`Id_Tercero`) AND (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    left JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_concepto_unidadf`.`CCredito` = `cc_puc`.`Id`) AND (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    left JOIN  `rh_nomina_persona_conceptos` \n        ON (`rh_nomina_persona_conceptos`.`Id_Tercero` = `cc_detalle_documentoc`.`Id_Tercero`) AND (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`)\n    left JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n    left JOIN  `rh_tipo_clasificacion_conceptonomina` \n        ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)\n LEFT JOIN  (SELECT\n `cc_detalle_documentoc`.`Id_Puc`\n    , `cc_detalle_documentoc`.`Id_Tercero` \n    , SUM(`cc_detalle_documentoc`.`VDebito`) valor\n    , cc_documentoc.`Id_Nomina`\n    \nFROM\n     `cc_documentoc` \n    INNER JOIN  `cc_detalle_documentoc`\n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\nWHERE ( cc_documentoc.`Estado`=1 AND cc_documentoc.`Id_Nomina`<>0\t\n      AND `cc_detalle_documentoc`.`VDebito`<>0)\n    \n    GROUP BY `cc_detalle_documentoc`.`Id_Puc`, cc_documentoc.`Id_Nomina`, `cc_detalle_documentoc`.`Id_Tercero` ) valorPagado  \n    ON (`cc_detalle_documentoc`.`Id_Puc`=valorPagado.Id_Puc) AND (`cc_detalle_documentoc`.`Id_Tercero` =valorPagado.`Id_Tercero`)  AND (valorPagado.Id_Nomina='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "') \nWHERE ((cc_terceros.`RazonSocialCompleta` like'" + this.JTFBusqueda.getText() + "%' ||  cc_terceros.`No_identificacion` like'" + this.JTFBusqueda.getText() + "%' )  AND  `cc_documentoc`.`Id_Nomina` ='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "' AND cc_documentoc.`Estado`=1 AND `rh_tipo_clasificacion_conceptonomina`.`Id` ='" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "')\nGROUP BY `cc_documentoc`.`Id_Nomina`, `cc_puc`.`Id`, `cc_terceros`.`Id`\nhaving VCredito>0\nORDER BY `cc_terceros`.`RazonSocialCompleta` ASC";
                    }
                } else if (this.JTFBusqueda.getText().isEmpty()) {
                    sql = "SELECT `cc_documentoc`.`Id` , `cc_documentoc`.`FechaD` , `cc_terceros`.`RazonSocialCompleta` , `cc_documentoc`.`Id_Nomina`  ,SUM( `cc_detalle_documentoc`.`VCredito`) AS VPagar , 0  AS Valor1, `cc_puc`.`Id` AS NPuc, `cc_puc`.`Nbre` , `cc_terceros`.`Id` AS IdTercero\n    , `cc_terceros`.`Correo` ,IFNULL(`cc_detalle_documentoc`.`Concepto`,\"\") AS Concepto , IF(rh_nomina_liquidacion_detalle.`RPresupuestal`='',`rh_nomina_concepto_unidadf`.`RPresupuesto`,rh_nomina_liquidacion_detalle.`RPresupuestal`) RPresupuestal  , 0  AS Valor, `rh_nomina_liquidacion_detalle`.`Id_Compromiso` AS IdCompromiso, rh_nomina_liquidacion_detalle.Id_ConceptoCN AS Id_ConceptoN , `rh_nomina_liquidacion_detalle`.`Id_Obligacion` AS IdObligacion \n    , `rh_nomina_conceptos`.`Id_Clasificacion` AS IdClase\n    ,d.IdConcept IdCNS\n    , GROUP_CONCAT(DISTINCT rh_nomina_liquidacion_detalle.`Id_Obligacion`) NOBG , 0 NCredito, rh_nomina_liquidacion_detalle.`Id_DocContableE`, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC, DATEDIFF(now(),`cc_documentoc`.`FechaD`) diasCartera, 0 as tipo \nFROM\n     `cc_detalle_documentoc`\n    INNER JOIN  `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`cc_documentoc`.`Id_Nomina` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `cc_terceros` \n        ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `rh_nomina_liquidacion_detalle` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `cc_detalle_documentoc`.`Id_ConceptoN`) AND (`rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_detalle_documentoc`.`Id_Tercero`) AND (`rh_nomina_liquidacion_detalle`.`Id_DocContable` = `cc_detalle_documentoc`.`Id_Documentoc`) AND (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n LEFT JOIN (SELECT    \n   GROUP_CONCAT(`rh_nomina_concepto_unidadf`.`Id`) IdConcept\n   , `rh_nomina_liquidacion_detalle`.`Id_Obligacion`\n   ,`rh_nomina_liquidacion_detalle`.`Id_Tercero`, 0 as tipo\n   \n   \nFROM\n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\nWHERE (`rh_nomina_liquidacion`.`Id` ='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "'\n    AND `rh_nomina_conceptos`.`Id_Clasificacion` ='" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "'\n    ) GROUP BY `rh_nomina_liquidacion_detalle`.`Id_Obligacion`, `rh_nomina_conceptos`.`Id_Clasificacion`, `rh_nomina_liquidacion_detalle`.`Id_Tercero`)  d \n    ON ( d.Id_Obligacion=`rh_nomina_liquidacion_detalle`.`Id_Obligacion`) AND (d.Id_Tercero=`cc_terceros`.`Id`)   \nWHERE (`cc_documentoc`.`Id_Nomina` ='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "'\n --   AND `cc_documentoc`.`Id` =15508\n    AND `cc_puc`.`CxP` = 1     AND `rh_nomina_conceptos`.`Id_Clasificacion` ='" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "')\nGROUP BY `cc_documentoc`.`Id` , `cc_documentoc`.`Id_Nomina`, `cc_puc`.`Id`, `cc_terceros`.`Id`   \nHAVING VPagar>0 and Id_DocContableE=0 ";
                } else {
                    sql = "SELECT `cc_documentoc`.`Id` , `cc_documentoc`.`FechaD` , `cc_terceros`.`RazonSocialCompleta` , `cc_documentoc`.`Id_Nomina`  ,SUM( `cc_detalle_documentoc`.`VCredito`) AS VPagar , 0  AS Valor1, `cc_puc`.`Id` AS NPuc, `cc_puc`.`Nbre` , `cc_terceros`.`Id` AS IdTercero\n    , `cc_terceros`.`Correo` ,IFNULL(`cc_detalle_documentoc`.`Concepto`,\"\") AS Concepto , IF(rh_nomina_liquidacion_detalle.`RPresupuestal`='',`rh_nomina_concepto_unidadf`.`RPresupuesto`,rh_nomina_liquidacion_detalle.`RPresupuestal`) RPresupuestal  , 0  AS Valor, `rh_nomina_liquidacion_detalle`.`Id_Compromiso` AS IdCompromiso, rh_nomina_liquidacion_detalle.Id_ConceptoCN AS Id_ConceptoN , `rh_nomina_liquidacion_detalle`.`Id_Obligacion` AS IdObligacion \n    , `rh_nomina_conceptos`.`Id_Clasificacion` AS IdClase\n    , d.IdConcept IdCNS\n    , GROUP_CONCAT(DISTINCT rh_nomina_liquidacion_detalle.`Id_Obligacion`) NOBG , 0 NCredito, rh_nomina_liquidacion_detalle.`Id_DocContableE`, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC, DATEDIFF(now(),`cc_documentoc`.`FechaD`) diasCartera, 0 as tipo  \nFROM\n     `cc_detalle_documentoc`\n    INNER JOIN  `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`cc_documentoc`.`Id_Nomina` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `cc_terceros` \n        ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `rh_nomina_liquidacion_detalle` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `cc_detalle_documentoc`.`Id_ConceptoN`) AND (`rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_detalle_documentoc`.`Id_Tercero`) AND (`rh_nomina_liquidacion_detalle`.`Id_DocContable` = `cc_detalle_documentoc`.`Id_Documentoc`) AND (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\n LEFT JOIN (SELECT    \n   GROUP_CONCAT(`rh_nomina_concepto_unidadf`.`Id`) IdConcept\n   , `rh_nomina_liquidacion_detalle`.`Id_Obligacion`\n   ,`rh_nomina_liquidacion_detalle`.`Id_Tercero` \n   \n   \nFROM\n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\nWHERE (`rh_nomina_liquidacion`.`Id` ='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "'\n    AND `rh_nomina_conceptos`.`Id_Clasificacion` ='" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "'\n    ) GROUP BY `rh_nomina_liquidacion_detalle`.`Id_Obligacion`, `rh_nomina_conceptos`.`Id_Clasificacion`, `rh_nomina_liquidacion_detalle`.`Id_Tercero`)  d \n    ON ( d.Id_Obligacion=`rh_nomina_liquidacion_detalle`.`Id_Obligacion`) AND (d.Id_Tercero=`cc_terceros`.`Id`)   \nWHERE ((cc_terceros.`RazonSocialCompleta` like'" + this.JTFBusqueda.getText() + "%' ||  cc_terceros.`No_identificacion` like'" + this.JTFBusqueda.getText() + "%' )      AND  `cc_documentoc`.`Id_Nomina` ='" + this.xId_Nomina[this.JCB_NNomina.getSelectedIndex()] + "'\n --   AND `cc_documentoc`.`Id` =15508\n  AND `cc_puc`.`CxP` = 1     AND `rh_nomina_conceptos`.`Id_Clasificacion` ='" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "')\nGROUP BY `cc_documentoc`.`Id` , `cc_documentoc`.`Id_Nomina`, `cc_puc`.`Id`, `cc_terceros`.`Id`   \nHAVING VPagar>0  and Id_DocContableE=0";
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Seleccione un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else {
            String filtroMes = "";
            if (this.JCH_FiltroMes.isSelected()) {
                filtroMes = " and date_format(cc_documentoc.FechaD, '%m-%Y') = '" + this.xmt.formatoMesAno.format(this.JDFFechaC.getDate()) + "'";
            }
            if (this.JTFBusqueda.getText().isEmpty()) {
                if (this.JCH_SinCausacion.isSelected()) {
                    if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                        sql = "with radicacion as (\nSELECT \n  `cc_radicacion`.`Id`,\n  `cc_radicacion`.`FechaFac` Fecha,\n  if(`ge`.Nbre='', concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1,' ', ge.Nombre2), ge.Nbre ) RazonSocialCompleta,\n  `cc_radicacion`.`NoFactura`,\n  `cc_radicacion`.`SubTotal`,\n  -- ((ROUND(`cc_radicacion`.`SubTotal`)-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0)) `VCreditoD`,\n  `cc_radicacion`.`Id` AS `Id_Radicacion`,\n  `cc_puc`.`Id` AS `Id_Puc`,\n  `cc_puc`.`Nbre` AS `nombrePuc`,\n  `ge`.`Id` AS `idTercero`,\n  `ge`.`Correo` AS `correoTercero`,\n  `cc_radicacion`.`ConceptoC` AS Comentario,\n  /*IF(\n    pp_detalle_movimiento.`Id_Rubro` IS NULL,\n    '',\n    pp_detalle_movimiento.`Id_Rubro`\n  ),\n  IF(\n    pp_detalle_movimiento.`Valor` IS NULL,\n    0,\n    pp_detalle_movimiento.`Valor`\n  ),\n  pp_movimiento.`IdCompromiso`,*/\n  0 AS Id_ConceptoN,\n -- pp_movimiento.`IdObligacion`,\n --  IF(IFNULL(NCredito.VAlorC, 0) = 0, 0, 1) NCredito,\n  0 IdCNS,\n  -- pp_movimiento.`IdObligacion` NOBG,\n  `ge`.`Id` AS IdTerceroC,\n  concat(`ge`.Id_TipoIdentificacion,' ',ge.No_identificacion, if(ge.Dig_Verificacion='', '',concat('-', ge.Dig_Verificacion)))  AS DocTerceroC,\n  if(`ge`.Nbre='', concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1,' ', ge.Nombre2), ge.Nbre ) AS TerceroC,\n  -- VPagado.VAlorC, \n  DATEDIFF(now(),cc_radicacion.FechaFac) diasCartera ,\n  `cc_radicacion`.`Tipo` \nFROM\n   `cc_radicacion` \n  INNER JOIN  g_empresa ge \n    ON (  `ge`.`Id` = `cc_radicacion`.`Id_Proveedor` ) \n  INNER JOIN  `cc_puc` \n    ON ( `cc_puc`.`Id` = `cc_radicacion`.`Id_CuentaAuxPPagar`) \n    WHERE (`cc_radicacion`.`Tipo` = 3 \n    AND cc_radicacion.`Estado`=1) \n)\n-- SELECT * from radicacion\n,\n\n\nobligacion as (\n\tselect pm.Id IdObligacion , pm.IdRadicacion, pdm.Id_Rubro, pdm.Valor valoRubro, pm.IdCompromiso \n\tfrom pp_movimiento pm \n\tinner join pp_detalle_movimiento pdm  \n\ton (pm.Id=pdm.Id_Movimiento)\n\tinner join pp_tipo_documentos ptd \n\ton (ptd.Id=pm.Id_TipoDoc)\n\tinner join radicacion rd\n\ton (rd.Id=pm.IdRadicacion)\n\twhere ptd.Id_ClaseDoc=5 and pm.Id_MotivoAnulacion =1\n\tand pdm.NFactura =rd.NoFactura\n\tgroup by pm.Id\n\t\n),\n\ndebitoCredito as (\n\tSELECT\n    SUM(if(`cc_tipo_documentoc`.`IdClasificacion`=5,`cc_detalle_documentoc`.`VDebito`, 0)) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_documentoc` \n    INNER JOIN `cc_detalle_documentoc`\n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n \tINNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n    inner join  radicacion rd\n    \ton (rd.NoFactura=cc_detalle_documentoc.NFactura) and (cc_detalle_documentoc.Id_Tercero=rd.IdTerceroC)\n WHERE (`cc_tipo_documentoc`.`IdClasificacion` in(5)\n    AND `cc_documentoc`.`Estado` =1)\n),\n\npago as (\n\tSELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` , cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_documentoc` \n    INNER JOIN `cc_detalle_documentoc`\n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n \tINNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n    inner join  radicacion rd\n    \ton (rd.NoFactura=cc_detalle_documentoc.NFactura) and (cc_detalle_documentoc.Id_Tercero=rd.IdTerceroC)\n WHERE (`cc_tipo_documentoc`.`IdClasificacion` in(3)\n    AND `cc_documentoc`.`Estado` =1) group by rd.NoFactura\n)\n\n\n\nSELECT \nr.`Id`,\n  r.Fecha,\n  r.RazonSocialCompleta,\n  r.`NoFactura`,\n   ((ROUND(`r`.`SubTotal`)-IF(p.`ValorC` IS NULL, 0, p.`ValorC` ))-IFNULL(nc.VAlorC,0)) `VCreditoD`,\n  r.`Id_Radicacion`,\n  r.`Id_Puc`,\n  r.`nombrePuc`,\n  r.`idTercero`,\n r.`correoTercero`,\n  r.Comentario,\n  IF( o.`Id_Rubro` IS NULL,'',o.`Id_Rubro` ) idRubro,\n  IF(o.`valoRubro` IS NULL,0, o.valoRubro) valorRubro,\n  o.`IdCompromiso`,\n  r.Id_ConceptoN,\n  o.`IdObligacion`,\n   IF(IFNULL(nc.VAlorC, 0) = 0, 0, 1) NCredito,\n  r.IdCNS,\n   o.`IdObligacion` NOBG,\n  r.IdTerceroC,\n  r.DocTerceroC,\n  r.TerceroC,\n   ifnull(p.VAlorC,0)VAlorC, \n  r.diasCartera ,\n  r.`Tipo` \nfrom radicacion r\nleft join obligacion o\non (r.Id=o.IdRadicacion)\nleft join debitoCredito  nc\non  (r.NoFactura=nc.NFactura) and (nc.Id_Tercero=r.IdTerceroC)\nleft join pago p\non (r.NoFactura=p.NFactura) and (p.Id_Tercero=r.IdTerceroC)\n HAVING VCreditoD > 0 ORDER BY RazonSocialCompleta ASC, NoFactura ASC;\n";
                    } else {
                        sql = "SELECT \n  `cc_radicacion`.`Id`,\n  `cc_radicacion`.`FechaFac` Fecha,\n  `cc_terceros`.`RazonSocialCompleta`,\n  `cc_radicacion`.`NoFactura`,\n  ((ROUND(`cc_radicacion`.`SubTotal`)-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0)+IFNULL(NDebito.ValorC,0)) `VCreditoD`,\n  `cc_radicacion`.`Id` AS `Id_Radicacion`,\n  `cc_puc`.`Id` AS `Id_Puc`,\n  `cc_puc`.`Nbre` AS `nombrePuc`,\n  `cc_terceros`.`Id` AS `idTercero`,\n  `cc_terceros`.`Correo` AS `correoTercero`,\n  `cc_radicacion`.`ConceptoC` AS Comentario,\n  IF(\n    pp_detalle_movimiento.`Id_Rubro` IS NULL,\n    '',\n    pp_detalle_movimiento.`Id_Rubro`\n  ),\n  IF(\n    pp_detalle_movimiento.`Valor` IS NULL,\n    0,\n    pp_detalle_movimiento.`Valor`\n  ),\n  pp_movimiento.`IdCompromiso`,\n  0 AS Id_ConceptoN,\n  pp_movimiento.`IdObligacion`,\n  IF(IFNULL(NCredito.VAlorC, 0) = 0, 0, 1) NCredito,\n  0 IdCNS,\n  pp_movimiento.`IdObligacion` NOBG,\n  `cc_terceros`.`Id` AS IdTerceroC,\n  `cc_terceros`.`TDCompleto` AS DocTerceroC,\n  `cc_terceros`.`RazonSocialCompleta` AS TerceroC,\n  VPagado.VAlorC , DATEDIFF(now(),cc_radicacion.FechaFac) diasCartera , `cc_radicacion`.`Tipo` \nFROM\n   `cc_terceros` \n  INNER JOIN  `cc_radicacion` \n    ON (\n      `cc_terceros`.`Id` = `cc_radicacion`.`Id_Proveedor`\n    ) \n  INNER JOIN  `cc_puc` \n    ON (\n      `cc_puc`.`Id` = `cc_radicacion`.`Id_CuentaAuxPPagar`\n    ) \n  LEFT JOIN `pp_movimiento` \n    ON (\n      cc_radicacion.Id = pp_movimiento.`IdRadicacion` \n    ) \n  LEFT JOIN `pp_detalle_movimiento` \n    ON (\n      pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`\n    ) \n    \nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY  `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NCredito ON( `NCredito`.`NoFactura`=cc_radicacion.`NoFactura`\nAND `NCredito`.`Id_Proveedor` =cc_terceros.Id \n -- AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` \n  AND NCredito.Id_Puc=cc_radicacion.`Id_CuentaAuxPPagar`)     \n\n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =4\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NDebito ON(  `NDebito`.`NoFactura` = cc_radicacion.`NoFactura` AND\n `NDebito`.`Id_Proveedor` =cc_terceros.Id \n -- AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc`  -- AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc`\n ) \nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  \n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY  cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`NFactura` ) VPagado ON( `VPagado`.`NoFactura`=cc_radicacion.`NoFactura`\nAND `VPagado`.`Id_Proveedor` =cc_terceros.Id \n-- AND VPagado.Id_Puc=cc_radicacion.`Id_CuentaAuxPPagar`\n-- AND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc`\n) \n        \nWHERE (`cc_radicacion`.`Tipo` = 3 AND cc_radicacion.`Estado`=1)  GROUP BY `cc_radicacion`.`Id` HAVING VCreditoD>0 ORDER BY cc_terceros.`RazonSocialCompleta` ASC, cc_radicacion.`NoFactura` ASC";
                    }
                } else if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
                    sql = "SELECT\n  cc_documentoc.Id,\n  DATE_FORMAT(\n    cc_documentoc.FechaD,\n    '%d-%m-%Y'\n  ) AS Fecha,\n  cc_terceros.`RazonSocialCompleta` AS NTercero,\n  cc_detalle_documentoc.`NFactura` NoFactura,\n  (\n    (\n      ROUND(\n        SUM(\n          DISTINCT cc_detalle_documentoc.VCredito\n        )\n      ) - IF(\n        VPagado.`ValorC` IS NULL,\n        0,\n        VPagado.`ValorC`\n      )\n    ) - IFNULL(NCredito.VAlorC, 0) + IFNULL(NDebito.ValorC, 0)\n  ) AS VCreditoD,\n  cc_detalle_documentoc.`Id_Radicacion`,\n  cc_detalle_documentoc.`Id_Puc`,\n  cc_puc.Nbre,\n  cc_terceros.Id,\n  cc_terceros.Correo,\n  CONCAT(\n    cc_detalle_documentoc.`Concepto`,\n    ' Factura N° ',\n    cc_detalle_documentoc.NFactura\n  ) AS Comentario,\n  IF(\n    pp_detalle_movimiento.`Id_Rubro` IS NULL,\n    '',\n    pp_detalle_movimiento.`Id_Rubro`\n  ),\n  IF(\n    pp_detalle_movimiento.`Valor` IS NULL,\n    0,\n    pp_detalle_movimiento.`Valor`\n  ),\n  pp_movimiento.`IdCompromiso`,\n  0 AS Id_ConceptoN,\n  pp_movimiento.`IdObligacion`,\n  IF(IFNULL(NCredito.VAlorC, 0) = 0, 0, 1) NCredito,\n  0 IdCNS,\n  pp_movimiento.`IdObligacion` NOBG,\n  `cc_terceros`.`Id` AS IdTerceroC,\n  `cc_terceros`.`TDCompleto` AS DocTerceroC,\n  `cc_terceros`.`RazonSocialCompleta` AS TerceroC,\n  VPagado.VAlorC,\n  DATEDIFF(\n    NOW(),\n    IFNULL(\n      cc_radicacion.FechaFac,\n      cc_documentoc.FechaD\n    )\n  ) diasCartera,\n  `cc_radicacion`.`Tipo`\nFROM\n  -- cc_radicacion INNER JOIN\n   cc_documentoc -- ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)    \n   INNER JOIN cc_detalle_documentoc\n    ON (\n      cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id\n    )\n  INNER JOIN cc_terceros\n    ON (\n      cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`\n    )\n  INNER JOIN cc_puc\n    ON (\n      `cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`\n    )\n    AND (cc_puc.`CxP` = 1)\n  LEFT JOIN cc_detalle_firma_documentoc\n    ON (\n      cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id\n    )\n  INNER JOIN cc_tipo_documentoc\n    ON (\n      cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id\n    )\n  LEFT JOIN `pp_movimiento`\n    ON (\n      cc_documentoc.`Id` = pp_movimiento.`IdDocContable`\n    )\n  LEFT JOIN `pp_detalle_movimiento`\n    ON (\n      pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`\n    )\n  LEFT JOIN cc_radicacion\n    ON (\n      cc_radicacion.Id = cc_documentoc.Id_Radicacion\n    )\n    AND (cc_radicacion.Estado = 1) --  LEFT  JOIN( SELECT\n--     `Id_Puc`\n--     , `Id_Radicacion`\n--     , SUM(`Valor`) AS `Valor`\n-- FROM\n--     `cc_radicacion_pago`\n-- WHERE (`Estado` =1)\n-- GROUP BY `Id_Puc`, `Id_Radicacion`) d ON (d.Id_Radicacion=cc_radicacion.`Id`) AND (d.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n   LEFT JOIN\n    (SELECT\n      SUM(\n        `cc_detalle_documentoc`.`VDebito`\n      ) AS `VAlorC`,\n      `cc_detalle_documentoc`.`NFactura` `NoFactura`,\n      `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`,\n      cc_detalle_documentoc.`Id_Puc`\n    FROM\n      `cc_detalle_documentoc`\n      INNER JOIN `cc_documentoc`\n        ON (\n          `cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`\n        )\n      LEFT JOIN `cc_radicacion_notac`\n        ON (\n          `cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`\n        )\n      INNER JOIN `cc_tipo_documentoc`\n        ON (\n          `cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`\n        )\n    WHERE (\n        `cc_tipo_documentoc`.`IdClasificacion` = 5\n        AND `cc_documentoc`.`Estado` = 1\n      )\n    GROUP BY `cc_documentoc`.`Id`,\n      cc_detalle_documentoc.`Id_Puc`) NCredito\n    ON (\n      `NCredito`.`NoFactura` = cc_detalle_documentoc.`NFactura`\n      AND `NCredito`.`Id_Proveedor` = cc_terceros.Id\n      AND NCredito.Id_Puc = cc_detalle_documentoc.`Id_Puc` --  AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` \n    )\n  LEFT JOIN\n    (SELECT\n      SUM(\n        `cc_detalle_documentoc`.`VCredito`\n      ) AS `VAlorC`,\n      `cc_detalle_documentoc`.`NFactura` `NoFactura`,\n      `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`,\n      cc_detalle_documentoc.`Id_Puc`\n    FROM\n      `cc_detalle_documentoc`\n      INNER JOIN `cc_documentoc`\n        ON (\n          `cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`\n        )\n      LEFT JOIN `cc_radicacion_notac`\n        ON (\n          `cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`\n        )\n      INNER JOIN `cc_tipo_documentoc`\n        ON (\n          `cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`\n        )\n    WHERE (\n        `cc_tipo_documentoc`.`IdClasificacion` = 4\n        AND `cc_documentoc`.`Estado` = 1\n      )\n    GROUP BY `cc_documentoc`.`Id`,\n      cc_detalle_documentoc.`Id_Puc`,\n      `cc_detalle_documentoc`.`NFactura`) NDebito\n    ON (\n      `NDebito`.`NoFactura` = cc_detalle_documentoc.`NFactura`\n      AND `NDebito`.`Id_Proveedor` = cc_terceros.Id\n      AND NDebito.Id_Puc = cc_detalle_documentoc.`Id_Puc`\n      AND NDebito.Id_Puc = cc_detalle_documentoc.`Id_Puc`\n    )\n  LEFT JOIN\n    (SELECT\n      SUM(\n        `cc_detalle_documentoc`.`VDebito`\n      ) AS `VAlorC`,\n      `cc_detalle_documentoc`.`NFactura` `NoFactura`,\n      `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`,\n      cc_detalle_documentoc.`Id_Puc`\n    FROM\n      `cc_detalle_documentoc`\n      INNER JOIN `cc_documentoc`\n        ON (\n          `cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`\n        )\n      INNER JOIN `cc_tipo_documentoc`\n        ON (\n          `cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`\n        )\n    WHERE (\n        `cc_tipo_documentoc`.`IdClasificacion` = 3\n        AND `cc_documentoc`.`Estado` = 1\n      )\n    GROUP BY cc_detalle_documentoc.`Id_Puc`,\n      `cc_detalle_documentoc`.`Id_Tercero`,\n      cc_detalle_documentoc.`NFactura`) VPagado\n    ON (\n      `VPagado`.`NoFactura` = cc_detalle_documentoc.`NFactura`\n      AND `VPagado`.`Id_Proveedor` = cc_terceros.Id\n      AND VPagado.Id_Puc = cc_detalle_documentoc.`Id_Puc`\n      AND VPagado.Id_Puc = cc_detalle_documentoc.`Id_Puc`\n    )\nWHERE (\n    cc_documentoc.Id_TipoComprobante = " + this.xidtipodoc_contp[this.JCBTipoDoc_Cont1.getSelectedIndex()] + "\n    AND cc_documentoc.GenerarC = 0\n   -- and cc_detalle_firma_documentoc.Autorizo = 1\n    -- AND cc_documentoc.EstadoA = 1\n    AND cc_documentoc.Estado = 1 " + filtroMes + "\n  )\nGROUP BY cc_documentoc.Id,\n  `cc_puc`.`Id`,\n  cc_detalle_firma_documentoc.Autorizo\nHAVING VCreditoD > 0\nORDER BY cc_terceros.`RazonSocialCompleta`,\n  cc_documentoc.Id";
                } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    sql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha, cc_terceros.`RazonSocialCompleta` AS NTercero, cc_radicacion.NoFactura, ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF( d.`Valor` IS NULL, 0, d.`Valor` ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD, cc_radicacion.Id, cc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,cc_terceros.Id, cc_terceros.Correo, CONCAT(cc_radicacion.`ConceptoC` ,' Factura N° ' ,cc_radicacion.NoFactura) as Comentario, if( pp_detalle_movimiento.`Id_Rubro` is null, '',pp_detalle_movimiento.`Id_Rubro`) , if( pp_detalle_movimiento.`Valor` is null, 0, pp_detalle_movimiento.`Valor`)  , pp_movimiento.`IdCompromiso`, 0  as Id_ConceptoN, pp_movimiento.`IdObligacion`, IF(IFNULL(NCredito.VAlorC,0)=0,0,1) NCredito, 0 IdCNS, pp_movimiento.`IdObligacion` NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC, DATEDIFF(now(), ifnull(cc_radicacion.FechaFac,cc_documentoc.FechaD)) diasCartera,`cc_radicacion`.`Tipo`\nFROM cc_radicacion INNER JOIN cc_documentoc ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)     INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)   INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)  LEFT JOIN `pp_movimiento`ON (cc_documentoc.`Id` = pp_movimiento.`IdDocContable`)  LEFT JOIN `pp_detalle_movimiento` ON (pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`)  LEFT  JOIN( SELECT\n    `Id_Puc`\n    , `Id_Radicacion`\n    , SUM(`Valor`) AS `Valor`\nFROM\n    `cc_radicacion_pago`\nWHERE (`Estado` =1)\nGROUP BY `Id_Puc`, `Id_Radicacion`) d ON (d.Id_Radicacion=cc_radicacion.`Id`) AND (d.Id_Puc=cc_detalle_documentoc.`Id_Puc`)  LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`, cc_detalle_documentoc.`Id_Puc`,`cc_detalle_documentoc`.`NFactura`) NCredito ON( `NCredito`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `NCredito`.`Id_Proveedor` =cc_terceros.Id \nAND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \nWHERE (cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc_contp[this.JCBTipoDoc_Cont1.getSelectedIndex()] + "'  and cc_documentoc.GenerarC=0 and cc_detalle_firma_documentoc.Autorizo =1 AND cc_documentoc.EstadoA=1 AND cc_documentoc.Estado=1 " + filtroMes + " and cc_radicacion.Estado=1)   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo HAVING VCreditoD>0 order by cc_documentoc.Id";
                } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    sql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha, cc_terceros.`RazonSocialCompleta` AS NTercero, cc_radicacion.NoFactura, ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF( d.`Valor` IS NULL, 0, d.`Valor` ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD, cc_radicacion.Id, cc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,cc_terceros.Id, cc_terceros.Correo, CONCAT(cc_radicacion.`ConceptoC` ,' Factura N° ' ,cc_radicacion.NoFactura) as Comentario, if( pp_detalle_movimiento.`Id_Rubro` is null, '',pp_detalle_movimiento.`Id_Rubro`) , if( pp_detalle_movimiento.`Valor` is null, 0, pp_detalle_movimiento.`Valor`)  , pp_movimiento.`IdCompromiso`, 0  as Id_ConceptoN, pp_movimiento.`IdObligacion`, IF(IFNULL(NCredito.VAlorC,0)=0,0,1) NCredito, 0 IdCNS, pp_movimiento.`IdObligacion` NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC, DATEDIFF(now(), ifnull(cc_radicacion.FechaFac,cc_documentoc.FechaD)) diasCartera , `cc_radicacion`.`Tipo`\nFROM cc_radicacion INNER JOIN cc_documentoc ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)     INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)    INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)  LEFT JOIN `pp_movimiento`ON (cc_documentoc.`Id` = pp_movimiento.`IdDocContable`)  LEFT JOIN `pp_detalle_movimiento` ON (pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`)  LEFT  JOIN( SELECT\n    `Id_Puc`\n    , `Id_Radicacion`\n    , SUM(`Valor`) AS `Valor`\nFROM\n    `cc_radicacion_pago`\nWHERE (`Estado` =1)\nGROUP BY `Id_Puc`, `Id_Radicacion`) d ON (d.Id_Radicacion=cc_radicacion.`Id`) AND (d.Id_Puc=cc_detalle_documentoc.`Id_Puc`)  LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_radicacion_notac`.`NoFactura`\n    , `cc_radicacion_notac`.`Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) INNER JOIN `cc_puc`   ON (cc_puc.`Id` = `cc_detalle_documentoc`.`Id_Puc`)    \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` IN (5) AND cc_puc.`CxP`=1 \n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`, cc_detalle_documentoc.Id_Puc, `cc_detalle_documentoc`.`NFactura`) NCredito ON( `NCredito`.`NoFactura`=cc_radicacion.NoFactura AND `NCredito`.`Id_Proveedor` =cc_terceros.Id AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc`) WHERE (cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc_contp[this.JCBTipoDoc_Cont1.getSelectedIndex()] + "'  and cc_documentoc.GenerarC=0 and cc_detalle_firma_documentoc.Autorizo =1 AND cc_documentoc.EstadoA=1 AND cc_documentoc.Estado=1 " + filtroMes + " and cc_radicacion.Estado=1)   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo HAVING VCreditoD>0 order by cc_terceros.`RazonSocialCompleta`, cc_documentoc.Id";
                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
                    sql = " SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha, cc_terceros.`RazonSocialCompleta` AS NTercero, cc_detalle_documentoc.`NFactura` NoFactura,\n  ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0)+IFNULL(NDebito.ValorC,0))  AS VCreditoD, \ncc_detalle_documentoc.`Id_Radicacion`, cc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,cc_terceros.Id, cc_terceros.Correo, CONCAT(cc_detalle_documentoc.`Concepto` ,' Factura N° ' ,cc_detalle_documentoc.NFactura) AS Comentario, IF( pp_detalle_movimiento.`Id_Rubro` IS NULL, '',pp_detalle_movimiento.`Id_Rubro`) , IF( pp_detalle_movimiento.`Valor` IS NULL, 0, pp_detalle_movimiento.`Valor`)  , pp_movimiento.`IdCompromiso`, 0  AS Id_ConceptoN, pp_movimiento.`IdObligacion`, IF(IFNULL(NCredito.VAlorC,0)=0,0,1) NCredito, 0 IdCNS, pp_movimiento.`IdObligacion` NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC\n, VPagado.VAlorC, DATEDIFF(now(), ifnull(cc_radicacion.FechaFac,cc_documentoc.FechaD)) diasCartera, `cc_radicacion`.`Tipo`, COUNT(DISTINCT `cc_detalle_firma_documentoc`.`Id_UsuarioF`) AS sumaFirma,\n  firmas.userfirma AS firmasNecesarias\nFROM \n-- cc_radicacion INNER JOIN\n cc_documentoc -- ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)    \n INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \n INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)  \n   INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) \n   INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id)\n    INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) \n     LEFT JOIN `pp_movimiento`ON (cc_documentoc.`Id` = pp_movimiento.`IdDocContable`)   and (date_format( pp_movimiento.FechaD, '%Y')='" + this.xmt.formatoANO.format(this.JDFFechaC.getDate()) + "')  \n     LEFT JOIN `pp_detalle_movimiento` ON (pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`)   left JOIN cc_radicacion  ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)  and  (cc_radicacion.Estado=1)\n left  join ((SELECT COUNT(cc_usuarioxdocumentof.id)AS userfirma, cc_detalle_firma_documentoc.Id_OrdenDc FROM `cc_usuarioxdocumentof` \n     inner join cc_detalle_firma_documentoc on cc_detalle_firma_documentoc.Id_UsuarioF=cc_usuarioxdocumentof.Id \n     WHERE (cc_usuarioxdocumentof.Estado = 1) group by cc_detalle_firma_documentoc.Id_OrdenDc)\n     ) firmas on (firmas.Id_OrdenDc=cc_documentoc.Id)      --  LEFT  JOIN( SELECT\n--     `Id_Puc`\n--     , `Id_Radicacion`\n--     , SUM(`Valor`) AS `Valor`\n-- FROM\n--     `cc_radicacion_pago`\n-- WHERE (`Estado` =1)\n-- GROUP BY `Id_Puc`, `Id_Radicacion`) d ON (d.Id_Radicacion=cc_radicacion.`Id`) AND (d.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\n GROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura` ) NCredito ON( `NCredito`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `NCredito`.`Id_Proveedor` =cc_terceros.Id \nAND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc`  --  AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` \n) \n\n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =4\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NDebito ON(  `NDebito`.`NoFactura`=cc_detalle_documentoc.`NFactura` AND\n   `NDebito`.`Id_Proveedor` =cc_terceros.Id \n AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc` \n)\nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  \n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY  cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`NFactura` ) VPagado ON( `VPagado`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `VPagado`.`Id_Proveedor` =cc_terceros.Id \nAND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \nWHERE (cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc_contp[this.JCBTipoDoc_Cont1.getSelectedIndex()] + "'  and cc_documentoc.GenerarC=0 and cc_detalle_firma_documentoc.Autorizo =1 AND cc_documentoc.EstadoA=1 " + filtroMes + " AND cc_documentoc.Estado=1 )   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo HAVING VCreditoD>0 AND sumaFirma= firmasNecesarias order by cc_terceros.`RazonSocialCompleta`, cc_documentoc.Id";
                } else {
                    sql = " SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha, cc_terceros.`RazonSocialCompleta` AS NTercero, cc_detalle_documentoc.`NFactura` NoFactura,\n  ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0)+IFNULL(NDebito.ValorC,0))  AS VCreditoD, \ncc_detalle_documentoc.`Id_Radicacion`, cc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,cc_terceros.Id, cc_terceros.Correo, CONCAT(cc_detalle_documentoc.`Concepto` ,' Factura N° ' ,cc_detalle_documentoc.NFactura) AS Comentario, IF( pp_detalle_movimiento.`Id_Rubro` IS NULL, '',pp_detalle_movimiento.`Id_Rubro`) , IF( pp_detalle_movimiento.`Valor` IS NULL, 0, pp_detalle_movimiento.`Valor`)  , pp_movimiento.`IdCompromiso`, 0  AS Id_ConceptoN, pp_movimiento.`IdObligacion`, IF(IFNULL(NCredito.VAlorC,0)=0,0,1) NCredito, 0 IdCNS, pp_movimiento.`IdObligacion` NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC\n, VPagado.VAlorC, DATEDIFF(now(), ifnull(cc_radicacion.FechaFac,cc_documentoc.FechaD)) diasCartera, `cc_radicacion`.`Tipo`\nFROM \n-- cc_radicacion INNER JOIN\n cc_documentoc -- ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)    \n INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \n INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)  \n   INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) \n   INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id)\n    INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) \n     LEFT JOIN `pp_movimiento`ON (cc_documentoc.`Id` = pp_movimiento.`IdDocContable`)   and (date_format( pp_movimiento.FechaD, '%Y')='" + this.xmt.formatoANO.format(this.JDFFechaC.getDate()) + "')  \n     LEFT JOIN `pp_detalle_movimiento` ON (pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`)   left JOIN cc_radicacion  ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)  and  (cc_radicacion.Estado=1)\n     --  LEFT  JOIN( SELECT\n--     `Id_Puc`\n--     , `Id_Radicacion`\n--     , SUM(`Valor`) AS `Valor`\n-- FROM\n--     `cc_radicacion_pago`\n-- WHERE (`Estado` =1)\n-- GROUP BY `Id_Puc`, `Id_Radicacion`) d ON (d.Id_Radicacion=cc_radicacion.`Id`) AND (d.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NCredito ON( `NCredito`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `NCredito`.`Id_Proveedor` =cc_terceros.Id \nAND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc`  --  AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` \n) \n\n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =4\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NDebito ON(  `NDebito`.`NoFactura`=cc_detalle_documentoc.`NFactura` AND\n   `NDebito`.`Id_Proveedor` =cc_terceros.Id \n AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc` \n)\nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  \n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY  cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`NFactura` ) VPagado ON( `VPagado`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `VPagado`.`Id_Proveedor` =cc_terceros.Id \nAND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \nWHERE (cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc_contp[this.JCBTipoDoc_Cont1.getSelectedIndex()] + "'  and cc_documentoc.GenerarC=0 and cc_detalle_firma_documentoc.Autorizo =1 AND cc_documentoc.EstadoA=1 " + filtroMes + " AND cc_documentoc.Estado=1 )   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo HAVING VCreditoD>0 order by cc_terceros.`RazonSocialCompleta`, cc_documentoc.Id";
                }
            } else if (this.JCH_SinCausacion.isSelected()) {
                if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                    sql = "with radicacion as (\nSELECT \n  `cc_radicacion`.`Id`,\n  `cc_radicacion`.`FechaFac` Fecha,\n  if(`ge`.Nbre='', concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1,' ', ge.Nombre2), ge.Nbre ) RazonSocialCompleta,\n  `cc_radicacion`.`NoFactura`,\n  `cc_radicacion`.`SubTotal`,\n  -- ((ROUND(`cc_radicacion`.`SubTotal`)-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0)) `VCreditoD`,\n  `cc_radicacion`.`Id` AS `Id_Radicacion`,\n  `cc_puc`.`Id` AS `Id_Puc`,\n  `cc_puc`.`Nbre` AS `nombrePuc`,\n  `ge`.`Id` AS `idTercero`,\n  `ge`.`Correo` AS `correoTercero`,\n  `cc_radicacion`.`ConceptoC` AS Comentario,\n  /*IF(\n    pp_detalle_movimiento.`Id_Rubro` IS NULL,\n    '',\n    pp_detalle_movimiento.`Id_Rubro`\n  ),\n  IF(\n    pp_detalle_movimiento.`Valor` IS NULL,\n    0,\n    pp_detalle_movimiento.`Valor`\n  ),\n  pp_movimiento.`IdCompromiso`,*/\n  0 AS Id_ConceptoN,\n -- pp_movimiento.`IdObligacion`,\n --  IF(IFNULL(NCredito.VAlorC, 0) = 0, 0, 1) NCredito,\n  0 IdCNS,\n  -- pp_movimiento.`IdObligacion` NOBG,\n  `ge`.`Id` AS IdTerceroC,\n  concat(`ge`.Id_TipoIdentificacion,' ',ge.No_identificacion, if(ge.Dig_Verificacion='', '',concat('-', ge.Dig_Verificacion)))  AS DocTerceroC,\n  if(`ge`.Nbre='', concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1,' ', ge.Nombre2), ge.Nbre ) AS TerceroC,\n  -- VPagado.VAlorC, \n  DATEDIFF(now(),cc_radicacion.FechaFac) diasCartera ,\n  `cc_radicacion`.`Tipo` \nFROM\n   `cc_radicacion` \n  INNER JOIN  g_empresa ge \n    ON (  `ge`.`Id` = `cc_radicacion`.`Id_Proveedor` ) \n  INNER JOIN  `cc_puc` \n    ON ( `cc_puc`.`Id` = `cc_radicacion`.`Id_CuentaAuxPPagar`) \n    WHERE ((if(`ge`.Nbre='', concat(ge.Apellido1,' ', ge.Apellido2,' ', ge.Nombre1,' ', ge.Nombre2), ge.Nbre )  like '" + this.JTFBusqueda.getText() + "%' ||  ge.`No_identificacion` like'" + this.JTFBusqueda.getText() + "%' ) \n    and `cc_radicacion`.`Tipo` = 3 \n    AND cc_radicacion.`Estado`=1) \n)\n-- SELECT * from radicacion\n,\n\n\nobligacion as (\n\tselect pm.Id IdObligacion , pm.IdRadicacion, pdm.Id_Rubro, pdm.Valor valoRubro, pm.IdCompromiso \n\tfrom pp_movimiento pm \n\tinner join pp_detalle_movimiento pdm  \n\ton (pm.Id=pdm.Id_Movimiento)\n\tinner join pp_tipo_documentos ptd \n\ton (ptd.Id=pm.Id_TipoDoc)\n\tinner join radicacion rd\n\ton (rd.Id=pm.IdRadicacion)\n\twhere ptd.Id_ClaseDoc=5 and pm.Id_MotivoAnulacion =1\n\tand pdm.NFactura =rd.NoFactura\n\tgroup by pm.Id\n\t\n),\n\ndebitoCredito as (\n\tSELECT\n    SUM(if(`cc_tipo_documentoc`.`IdClasificacion`=5,`cc_detalle_documentoc`.`VDebito`, 0)) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_documentoc` \n    INNER JOIN `cc_detalle_documentoc`\n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n \tINNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n    inner join  radicacion rd\n    \ton (rd.NoFactura=cc_detalle_documentoc.NFactura) and (cc_detalle_documentoc.Id_Tercero=rd.IdTerceroC)\n WHERE (`cc_tipo_documentoc`.`IdClasificacion` in(5)\n    AND `cc_documentoc`.`Estado` =1)\n),\n\npago as (\n\tSELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` , cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_documentoc` \n    INNER JOIN `cc_detalle_documentoc`\n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n \tINNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n    inner join  radicacion rd\n    \ton (rd.NoFactura=cc_detalle_documentoc.NFactura) and (cc_detalle_documentoc.Id_Tercero=rd.IdTerceroC)\n WHERE (`cc_tipo_documentoc`.`IdClasificacion` in(3)\n    AND `cc_documentoc`.`Estado` =1) group by rd.NoFactura\n)\n\n\n\nSELECT \nr.`Id`,\n  r.Fecha,\n  r.RazonSocialCompleta,\n  r.`NoFactura`,\n   ((ROUND(`r`.`SubTotal`)-IF(p.`ValorC` IS NULL, 0, p.`ValorC` ))-IFNULL(nc.VAlorC,0)) `VCreditoD`,\n  r.`Id_Radicacion`,\n  r.`Id_Puc`,\n  r.`nombrePuc`,\n  r.`idTercero`,\n r.`correoTercero`,\n  r.Comentario,\n  IF( o.`Id_Rubro` IS NULL,'',o.`Id_Rubro` ) idRubro,\n  IF(o.`valoRubro` IS NULL,0, o.valoRubro) valorRubro,\n  o.`IdCompromiso`,\n  r.Id_ConceptoN,\n  o.`IdObligacion`,\n   IF(IFNULL(nc.VAlorC, 0) = 0, 0, 1) NCredito,\n  r.IdCNS,\n   o.`IdObligacion` NOBG,\n  r.IdTerceroC,\n  r.DocTerceroC,\n  r.TerceroC,\n   ifnull(p.VAlorC,0)VAlorC, \n  r.diasCartera ,\n  r.`Tipo` \nfrom radicacion r\nleft join obligacion o\non (r.Id=o.IdRadicacion)\nleft join debitoCredito  nc\non  (r.NoFactura=nc.NFactura) and (nc.Id_Tercero=r.IdTerceroC)\nleft join pago p\non (r.NoFactura=p.NFactura) and (p.Id_Tercero=r.IdTerceroC)\n HAVING VCreditoD > 0 ORDER BY RazonSocialCompleta ASC, NoFactura ASC;\n";
                } else {
                    sql = "SELECT \n  `cc_radicacion`.`Id`,\n  `cc_radicacion`.`FechaFac` Fecha,\n  `cc_terceros`.`RazonSocialCompleta`,\n  `cc_radicacion`.`NoFactura`,\n  ((ROUND(`cc_radicacion`.`SubTotal`)-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0)) `VCreditoD`,\n  `cc_radicacion`.`Id` AS `Id_Radicacion`,\n  `cc_puc`.`Id` AS `Id_Puc`,\n  `cc_puc`.`Nbre` AS `nombrePuc`,\n  `cc_terceros`.`Id` AS `idTercero`,\n  `cc_terceros`.`Correo` AS `correoTercero`,\n  `cc_radicacion`.`ConceptoC` AS Comentario,\n  IF(\n    pp_detalle_movimiento.`Id_Rubro` IS NULL,\n    '',\n    pp_detalle_movimiento.`Id_Rubro`\n  ),\n  IF(\n    pp_detalle_movimiento.`Valor` IS NULL,\n    0,\n    pp_detalle_movimiento.`Valor`\n  ),\n  pp_movimiento.`IdCompromiso`,\n  0 AS Id_ConceptoN,\n  pp_movimiento.`IdObligacion`,\n  IF(IFNULL(NCredito.VAlorC, 0) = 0, 0, 1) NCredito,\n  0 IdCNS,\n  pp_movimiento.`IdObligacion` NOBG,\n  `cc_terceros`.`Id` AS IdTerceroC,\n  `cc_terceros`.`TDCompleto` AS DocTerceroC,\n  `cc_terceros`.`RazonSocialCompleta` AS TerceroC,\n  VPagado.VAlorC, DATEDIFF(now(),cc_radicacion.FechaFac) diasCartera ,`cc_radicacion`.`Tipo` \nFROM\n   `cc_terceros` \n  INNER JOIN  `cc_radicacion` \n    ON (\n      `cc_terceros`.`Id` = `cc_radicacion`.`Id_Proveedor`\n    ) \n  INNER JOIN  `cc_puc` \n    ON (\n      `cc_puc`.`Id` = `cc_radicacion`.`Id_CuentaAuxPPagar`\n    ) \n  LEFT JOIN `pp_movimiento` \n    ON (\n      cc_radicacion.Id = pp_movimiento.IdDocContable \n    ) \n  LEFT JOIN `pp_detalle_movimiento` \n    ON (\n      pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`\n    ) \n    \nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NCredito ON( `NCredito`.`NoFactura`=cc_radicacion.`NoFactura`\n AND `NCredito`.`Id_Proveedor` =cc_terceros.Id \n -- AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` \n AND NCredito.Id_Puc=cc_radicacion.`Id_CuentaAuxPPagar` )     \n\n\nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  \n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY  `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura` ) VPagado ON( `VPagado`.`NoFactura`=cc_radicacion.`NoFactura`\nAND `VPagado`.`Id_Proveedor` =cc_terceros.Id \nAND VPagado.Id_Puc=cc_radicacion.`Id_CuentaAuxPPagar`\n-- AND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc`\n) \n        \nWHERE ((cc_terceros.`RazonSocialCompleta` like'" + this.JTFBusqueda.getText() + "%' ||  cc_terceros.`No_identificacion` like'" + this.JTFBusqueda.getText() + "%' ) and `cc_radicacion`.`Tipo` = 3 " + filtroMes + " AND cc_radicacion.`Estado`=1) GROUP BY `cc_radicacion`.`Id`  HAVING VCreditoD>0 ORDER BY cc_terceros.`RazonSocialCompleta` ASC, cc_radicacion.`NoFactura` ASC ";
                }
            } else {
                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                    String str = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha, cc_terceros.`RazonSocialCompleta` AS NTercero, cc_radicacion.NoFactura, ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF(d.`Valor` IS NULL, 0, d.`Valor` ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD, cc_radicacion.Id, cc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,cc_terceros.Id, cc_terceros.Correo, CONCAT(cc_radicacion.`ConceptoC` ,' Factura N° ' ,cc_radicacion.NoFactura) as Comentario, if( pp_detalle_movimiento.`Id_Rubro` is null, '',pp_detalle_movimiento.`Id_Rubro`) , if( pp_detalle_movimiento.`Valor` is null, 0, pp_detalle_movimiento.`Valor`)  , pp_movimiento.`IdCompromiso`, 0  as Id_ConceptoN, pp_movimiento.`IdObligacion`, IF(IFNULL(NCredito.VAlorC,0)=0,0,1) NCredito, 0 IdCNS, pp_movimiento.`IdObligacion` NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC, DATEDIFF(now(),cc_radicacion.FechaFac) diasCartera,`cc_radicacion`.`Tipo` \nFROM cc_radicacion INNER JOIN cc_documentoc ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)    INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)    INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)  LEFT JOIN `pp_movimiento`ON (cc_documentoc.`Id` = pp_movimiento.`IdDocContable`)  LEFT JOIN `pp_detalle_movimiento` ON (pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`)  LEFT  JOIN( SELECT\n    `Id_Puc`\n    , `Id_Radicacion`\n    , SUM(`Valor`) AS `Valor`\nFROM\n    `cc_radicacion_pago`\nWHERE (`Estado` =1)\nGROUP BY `Id_Puc`, `Id_Radicacion`) d ON (d.Id_Radicacion=cc_radicacion.`Id`) AND (d.Id_Puc=cc_detalle_documentoc.`Id_Puc`)   LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NCredito ON( `NCredito`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `NCredito`.`Id_Proveedor` =cc_terceros.Id \nAND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \nWHERE ((cc_terceros.`RazonSocialCompleta` like'" + this.JTFBusqueda.getText() + "%' ||  cc_terceros.`No_identificacion` like'" + this.JTFBusqueda.getText() + "%' ) and cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc_contp[this.JCBTipoDoc_Cont1.getSelectedIndex()] + "'  and cc_documentoc.GenerarC=0 and cc_detalle_firma_documentoc.Autorizo =1 " + filtroMes + " AND cc_documentoc.EstadoA=1 AND cc_documentoc.Estado=1 and cc_radicacion.Estado=1)   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo HAVING VCreditoD>0 order by  cc_documentoc.Id";
                }
                switch (Principal.informacionIps.getNombreIps()) {
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO":
                        sql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha, cc_terceros.`RazonSocialCompleta` AS NTercero, cc_radicacion.NoFactura, ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF( d.`Valor` IS NULL, 0, d.`Valor` ))-IFNULL(NCredito.VAlorC,0))  AS VCreditoD, cc_radicacion.Id, cc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,cc_terceros.Id, cc_terceros.Correo, CONCAT(cc_radicacion.`ConceptoC` ,' Factura N° ' ,cc_radicacion.NoFactura) as Comentario, if( pp_detalle_movimiento.`Id_Rubro` is null, '',pp_detalle_movimiento.`Id_Rubro`) , if( pp_detalle_movimiento.`Valor` is null, 0, pp_detalle_movimiento.`Valor`)  , pp_movimiento.`IdCompromiso`, 0  as Id_ConceptoN, pp_movimiento.`IdObligacion`, IF(IFNULL(NCredito.VAlorC,0)=0,0,1) NCredito, 0 IdCNS, pp_movimiento.`IdObligacion` NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC, DATEDIFF(now(), ifnull(cc_radicacion.FechaFac,cc_documentoc.FechaD)) diasCartera, `cc_radicacion`.`Tipo` \nFROM cc_radicacion INNER JOIN cc_documentoc ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)   INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)   INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)  LEFT JOIN `pp_movimiento`ON (cc_documentoc.`Id` = pp_movimiento.`IdDocContable`)  LEFT JOIN `pp_detalle_movimiento` ON (pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`)  LEFT  JOIN( SELECT\n    `Id_Puc`\n    , `Id_Radicacion`\n    , SUM(`Valor`) AS `Valor`\nFROM\n    `cc_radicacion_pago`\nWHERE (`Estado` =1)\nGROUP BY `Id_Puc`, `Id_Radicacion`) d ON (d.Id_Radicacion=cc_radicacion.`Id`) AND (d.Id_Puc=cc_detalle_documentoc.`Id_Puc`)  LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_radicacion_notac`.`NoFactura`\n    , `cc_radicacion_notac`.`Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    INNER JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) INNER JOIN `cc_puc`   ON (cc_puc.`Id` = `cc_detalle_documentoc`.`Id_Puc`)     \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` IN (5) AND cc_puc.`CxP`=1\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`, cc_detalle_documentoc.Id_Puc, `cc_detalle_documentoc`.`NFactura`) NCredito ON( `NCredito`.`NoFactura`=cc_radicacion.NoFactura AND `NCredito`.`Id_Proveedor` =cc_terceros.Id AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc`) WHERE ((cc_terceros.`RazonSocialCompleta` like'" + this.JTFBusqueda.getText() + "%' ||  cc_terceros.`No_identificacion` like'" + this.JTFBusqueda.getText() + "%' ) and cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc_contp[this.JCBTipoDoc_Cont1.getSelectedIndex()] + "'  and cc_documentoc.GenerarC=0 and cc_detalle_firma_documentoc.Autorizo =1 " + filtroMes + " AND cc_documentoc.EstadoA=1 AND cc_documentoc.Estado=1 and cc_radicacion.Estado=1)   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo HAVING VCreditoD>0 order by cc_terceros.`RazonSocialCompleta`, cc_documentoc.Id";
                        break;
                    case "CLINICA PAJONAL S.A.S":
                        sql = " SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha, cc_terceros.`RazonSocialCompleta` AS NTercero, cc_detalle_documentoc.`NFactura` NoFactura,\n  ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0)+IFNULL(NDebito.ValorC,0))  AS VCreditoD, \ncc_detalle_documentoc.`Id_Radicacion`, cc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,cc_terceros.Id, cc_terceros.Correo, CONCAT(cc_detalle_documentoc.`Concepto` ,' Factura N° ' ,cc_detalle_documentoc.NFactura) AS Comentario, IF( pp_detalle_movimiento.`Id_Rubro` IS NULL, '',pp_detalle_movimiento.`Id_Rubro`) , IF( pp_detalle_movimiento.`Valor` IS NULL, 0, pp_detalle_movimiento.`Valor`)  , pp_movimiento.`IdCompromiso`, 0  AS Id_ConceptoN, pp_movimiento.`IdObligacion`, IF(IFNULL(NCredito.VAlorC,0)=0,0,1) NCredito, 0 IdCNS, pp_movimiento.`IdObligacion` NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC\n, VPagado.VAlorC, DATEDIFF(now(), ifnull(cc_radicacion.FechaFac,cc_documentoc.FechaD)) diasCartera, `cc_radicacion`.`Tipo`,\n COUNT(DISTINCT `cc_detalle_firma_documentoc`.`Id_UsuarioF`) AS sumaFirma,\n  firmas.userfirma AS firmasNecesarias\nFROM \n-- cc_radicacion INNER JOIN\n cc_documentoc -- ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)    \n INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \n INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)  \n   INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) \n   INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id)\n    INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) \n     LEFT JOIN `pp_movimiento`ON (cc_documentoc.`Id` = pp_movimiento.`IdDocContable`) and (date_format( pp_movimiento.FechaD, '%Y')='" + this.xmt.formatoANO.format(this.JDFFechaC.getDate()) + "') \n     LEFT JOIN `pp_detalle_movimiento` ON (pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`)   left JOIN cc_radicacion  ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)  and  (cc_radicacion.Estado=1)  \n  left  join ((SELECT COUNT(cc_usuarioxdocumentof.id)AS userfirma, cc_detalle_firma_documentoc.Id_OrdenDc FROM `cc_usuarioxdocumentof` \n     inner join cc_detalle_firma_documentoc on cc_detalle_firma_documentoc.Id_UsuarioF=cc_usuarioxdocumentof.Id \n     WHERE (cc_usuarioxdocumentof.Estado = 1) group by cc_detalle_firma_documentoc.Id_OrdenDc)\n     ) firmas on (firmas.Id_OrdenDc=cc_documentoc.Id) \n     --  LEFT  JOIN( SELECT\n--     `Id_Puc`\n--     , `Id_Radicacion`\n--     , SUM(`Valor`) AS `Valor`\n-- FROM\n--     `cc_radicacion_pago`\n-- WHERE (`Estado` =1)\n-- GROUP BY `Id_Puc`, `Id_Radicacion`) d ON (d.Id_Radicacion=cc_radicacion.`Id`) AND (d.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NCredito ON( `NCredito`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `NCredito`.`Id_Proveedor` =cc_terceros.Id \nAND NCredito.Id_Puc =cc_detalle_documentoc.`Id_Puc`-- AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` \n) \n\n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =4\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NDebito ON(  `NDebito`.`NoFactura`=cc_detalle_documentoc.`NFactura` AND\n `NDebito`.`Id_Proveedor` =cc_terceros.Id \n AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc`\n ) \nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  \n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura` ) VPagado ON( `VPagado`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `VPagado`.`Id_Proveedor` =cc_terceros.Id \nAND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n\n\n\nWHERE ((cc_terceros.`RazonSocialCompleta` like'" + this.JTFBusqueda.getText() + "%' ||  cc_terceros.`No_identificacion` like'" + this.JTFBusqueda.getText() + "%' ) and cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc_contp[this.JCBTipoDoc_Cont1.getSelectedIndex()] + "'  and cc_documentoc.GenerarC=0 and cc_detalle_firma_documentoc.Autorizo =1 " + filtroMes + " AND cc_documentoc.EstadoA=1 AND cc_documentoc.Estado=1 )   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo HAVING VCreditoD>0  AND sumaFirma= firmasNecesarias  order by cc_terceros.`RazonSocialCompleta`, cc_documentoc.Id";
                        break;
                    default:
                        sql = " SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha, cc_terceros.`RazonSocialCompleta` AS NTercero, cc_detalle_documentoc.`NFactura` NoFactura,\n  ((ROUND(SUM(DISTINCT cc_detalle_documentoc.VCredito))-IF( VPagado.`ValorC` IS NULL, 0, VPagado.`ValorC` ))-IFNULL(NCredito.VAlorC,0)+IFNULL(NDebito.ValorC,0))  AS VCreditoD, \ncc_detalle_documentoc.`Id_Radicacion`, cc_detalle_documentoc.`Id_Puc`, cc_puc.Nbre,cc_terceros.Id, cc_terceros.Correo, CONCAT(cc_detalle_documentoc.`Concepto` ,' Factura N° ' ,cc_detalle_documentoc.NFactura) AS Comentario, IF( pp_detalle_movimiento.`Id_Rubro` IS NULL, '',pp_detalle_movimiento.`Id_Rubro`) , IF( pp_detalle_movimiento.`Valor` IS NULL, 0, pp_detalle_movimiento.`Valor`)  , pp_movimiento.`IdCompromiso`, 0  AS Id_ConceptoN, pp_movimiento.`IdObligacion`, IF(IFNULL(NCredito.VAlorC,0)=0,0,1) NCredito, 0 IdCNS, pp_movimiento.`IdObligacion` NOBG, `cc_terceros`.`Id` AS IdTerceroC, `cc_terceros`.`TDCompleto` AS DocTerceroC,`cc_terceros`.`RazonSocialCompleta` AS TerceroC\n, VPagado.VAlorC, DATEDIFF(now(), ifnull(cc_radicacion.FechaFac,cc_documentoc.FechaD)) diasCartera, `cc_radicacion`.`Tipo`\nFROM \n-- cc_radicacion INNER JOIN\n cc_documentoc -- ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)    \n INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \n INNER JOIN cc_terceros ON (cc_detalle_documentoc.`Id_Tercero` = cc_terceros.`Id`)  \n   INNER JOIN cc_puc   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) AND (cc_puc.`CxP`=1) \n   INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id)\n    INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) \n     LEFT JOIN `pp_movimiento`ON (cc_documentoc.`Id` = pp_movimiento.`IdDocContable`) and (date_format( pp_movimiento.FechaD, '%Y')='" + this.xmt.formatoANO.format(this.JDFFechaC.getDate()) + "') \n     LEFT JOIN `pp_detalle_movimiento` ON (pp_detalle_movimiento.`Id_Movimiento` = pp_movimiento.`Id`)   left JOIN cc_radicacion  ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion)  and  (cc_radicacion.Estado=1)  \n     --  LEFT  JOIN( SELECT\n--     `Id_Puc`\n--     , `Id_Radicacion`\n--     , SUM(`Valor`) AS `Valor`\n-- FROM\n--     `cc_radicacion_pago`\n-- WHERE (`Estado` =1)\n-- GROUP BY `Id_Puc`, `Id_Radicacion`) d ON (d.Id_Radicacion=cc_radicacion.`Id`) AND (d.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =5\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NCredito ON( `NCredito`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `NCredito`.`Id_Proveedor` =cc_terceros.Id \nAND NCredito.Id_Puc =cc_detalle_documentoc.`Id_Puc`-- AND NCredito.Id_Puc=cc_detalle_documentoc.`Id_Puc` \n) \n\n LEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VCredito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)\n    LEFT JOIN `cc_radicacion_notac` \n        ON (`cc_radicacion_notac`.`Id` = `cc_documentoc`.`Id_Radicacion`)\n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =4\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY `cc_documentoc`.`Id`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura`) NDebito ON(  `NDebito`.`NoFactura`=cc_detalle_documentoc.`NFactura` AND\n `NDebito`.`Id_Proveedor` =cc_terceros.Id \n AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND NDebito.Id_Puc=cc_detalle_documentoc.`Id_Puc`\n ) \nLEFT JOIN(SELECT\n    SUM(`cc_detalle_documentoc`.`VDebito`) AS `VAlorC`\n    , `cc_detalle_documentoc`.`NFactura` `NoFactura`\n    , `cc_detalle_documentoc`.`Id_Tercero` `Id_Proveedor`, cc_detalle_documentoc.`Id_Puc`\n   \nFROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc` \n        ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  \n INNER JOIN `cc_tipo_documentoc` \n        ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) \n WHERE (`cc_tipo_documentoc`.`IdClasificacion` =3\n    AND `cc_documentoc`.`Estado` =1\n   )\nGROUP BY  `cc_detalle_documentoc`.`Id_Tercero`, cc_detalle_documentoc.`Id_Puc`, `cc_detalle_documentoc`.`NFactura` ) VPagado ON( `VPagado`.`NoFactura`=cc_detalle_documentoc.`NFactura`\nAND `VPagado`.`Id_Proveedor` =cc_terceros.Id \nAND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc` AND VPagado.Id_Puc=cc_detalle_documentoc.`Id_Puc`) \n\n\n\nWHERE ((cc_terceros.`RazonSocialCompleta` like'" + this.JTFBusqueda.getText() + "%' ||  cc_terceros.`No_identificacion` like'" + this.JTFBusqueda.getText() + "%' ) and cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc_contp[this.JCBTipoDoc_Cont1.getSelectedIndex()] + "'  and cc_documentoc.GenerarC=0 and cc_detalle_firma_documentoc.Autorizo =1 AND cc_documentoc.EstadoA=1 AND cc_documentoc.Estado=1 )   GROUP BY cc_documentoc.Id, `cc_puc`.`Id`, cc_detalle_firma_documentoc.Autorizo HAVING VCreditoD>0 order by cc_terceros.`RazonSocialCompleta`, cc_documentoc.Id";
                        break;
                }
            }
        }
        System.out.println(" Buscar : " + sql);
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                mConcecutivo();
                this.xmt.mEstablecerTextEditor(this.JTResultado, 2);
                this.xmt.mEstablecerTextEditor(this.JTResultado, 8);
                long xconsec = this.xConsecutivo;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(10), x, 13);
                    this.xmodelo.setValueAt(rs.getString(11), x, 14);
                    this.xmodelo.setValueAt(rs.getString(12), x, 15);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(13)), x, 16);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 18);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("IdCompromiso")), x, 19);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("IdObligacion")), x, 21);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_ConceptoN")), x, 20);
                    this.xmodelo.setValueAt(rs.getString("IdCNS"), x, 22);
                    this.xmodelo.setValueAt(rs.getString("NOBG"), x, 23);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("IdTerceroC")), x, 24);
                    this.xmodelo.setValueAt(rs.getString("DocTerceroC"), x, 25);
                    this.xmodelo.setValueAt(rs.getString("TerceroC"), x, 26);
                    this.xmodelo.setValueAt(rs.getString("diasCartera"), x, 27);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Tipo")), x, 28);
                    this.xmodelo.setValueAt(Long.valueOf(xconsec), x, 17);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    if (this.xtipo == 1) {
                        this.xmodelo.setValueAt(false, x, 6);
                    } else {
                        this.xmodelo.setValueAt(true, x, 6);
                    }
                    this.xmodelo.setValueAt(rs.getString(7), x, 7);
                    this.xmodelo.setValueAt(rs.getString(8), x, 8);
                    this.xmodelo.setValueAt(rs.getString(9), x, 9);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("NCredito")), x, 10);
                    this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodelo.setValueAt(0, x, 11);
                    this.xmodelo.setValueAt(0, x, 12);
                    x++;
                    xconsec++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.xlleno = true;
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos_DistribucionPPT(String xid_documento, String xIdObligacion, String xIdConcepto, String xIdTercero, String xidDocumentoC) {
        String sql;
        crearTablaDistribucionPresupuestal();
        if (this.JCH_EsNomina.isSelected()) {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL")) {
                sql = "SELECT  `pp_detalle_movimiento`.`Id_Rubro` , `pp_rubros`.`Nbre` , (`pp_detalle_movimiento`.`Valor`-IFNULL(e.Valor,0)) Valor , (`pp_detalle_movimiento`.`Valor`-IFNULL(e.Valor,0)) Valor ,true,  `pp_movimiento`.`IdDocContable` , `pp_movimiento`.`IdDisponibilidad`  , `pp_movimiento`.`IdCompromiso`,`pp_movimiento`.`IdRadicacion` \n ,`pp_detalle_movimiento`.`idRubrosCentroCostos` idCentroCostos,cc.`nombre` centroCostos\n,`pp_detalle_movimiento`.`idRubrosCpc` idCpc,cpc.`nombre` cpc,`pp_detalle_movimiento`.`idRubrosFunteFinanciacion` idFuenteF,ff.`nombre` fuenteFinanciacion\n,`pp_detalle_movimiento`.`idTopoVigencia` idTipoVig,tv.`Nombre` tipoVigencia \n FROM `pp_detalle_movimiento`  INNER JOIN  `pp_movimiento`  ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\nINNER JOIN  `pp_rubros`   ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`='" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "') \n  INNER JOIN `pp_tipo_vigencia` tv ON `pp_detalle_movimiento`.`idTopoVigencia`=tv.`Id`\n               INNER JOIN `pp_rubros_centrocostos` cc ON `pp_detalle_movimiento`.`idRubrosCentroCostos`=cc.`Id`\n               INNER JOIN `pp_rubros_cpc` cpc ON `pp_detalle_movimiento`.`idRubrosCpc`=cpc.`Id`\n               INNER JOIN `pp_rubros_fuente_financiacion` ff ON `pp_detalle_movimiento`.`idRubrosFunteFinanciacion`=ff.`Id` LEFT JOIN (SELECT\n    `pp_movimiento`.`IdObligacion`\n    , `pp_detalle_movimiento`.`Id_Rubro`\n    , `pp_detalle_movimiento`.`Id_Tercero`\n    , SUM(`pp_detalle_movimiento`.`Valor`) Valor\nFROM\n    `pp_detalle_movimiento`\n    INNER JOIN `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE ( `pp_tipo_documentos`.`Id_ClaseDoc` =6\n    AND `pp_movimiento`.`Id_MotivoAnulacion` =1\n    AND `pp_detalle_movimiento`.`Estado` =1)\n    GROUP BY  `pp_movimiento`.`IdObligacion` , `pp_detalle_movimiento`.`Id_Rubro`, `pp_detalle_movimiento`.`Id_Tercero`\n    ) e \n    ON (`e`.`IdObligacion`=`pp_movimiento`.`Id`) AND (e.Id_Rubro=`pp_detalle_movimiento`.`Id_Rubro` ) AND (e.Id_Tercero=pp_detalle_movimiento.`Id_Tercero`) \n WHERE (`pp_movimiento`.`Id` in(" + xIdObligacion.substring(1, xIdObligacion.length()) + ") AND  pp_detalle_movimiento.`Id_Tercero` in(" + xIdTercero.substring(1, xIdTercero.length()) + ") AND `pp_detalle_movimiento`.`Id_ConceptoN` in(" + xIdConcepto.substring(1, xIdConcepto.length()) + ") AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_rubros.idEncabezadoRubro ='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
            } else {
                sql = "SELECT\n                          pp_detalle_movimiento.Id_Rubro,\n                          pp_rubros.Nbre,\n                          (pp_detalle_movimiento.Valor - IFNULL(e.Valor, 0)) Valor, \n                          (pp_detalle_movimiento.Valor - IFNULL(e.Valor, 0)) Valor,\n                          TRUE,\n                          pp_movimiento.IdDocContable,\n                          pp_movimiento.IdDisponibilidad,\n                          pp_movimiento.IdCompromiso,\n                          pp_movimiento.IdRadicacion\n                          ,`pp_detalle_movimiento`.`idRubrosCentroCostos` idCentroCostos,cc.`nombre` centroCostos\n,`pp_detalle_movimiento`.`idRubrosCpc` idCpc,cpc.`nombre` cpc,`pp_detalle_movimiento`.`idRubrosFunteFinanciacion` idFuenteF,ff.`nombre` fuenteFinanciacion\n,`pp_detalle_movimiento`.`idTopoVigencia` idTipoVig,tv.`Nombre` tipoVigencia \n\n                        FROM pp_detalle_movimiento  \n                          INNER JOIN pp_movimiento   \t      ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n                          INNER JOIN pp_rubros  \t\t      ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.idEncabezadoRubro = '2')\n                          INNER JOIN pp_tipo_documentos        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                           INNER JOIN `pp_tipo_vigencia` tv ON `pp_detalle_movimiento`.`idTopoVigencia`=tv.`Id`\n               INNER JOIN `pp_rubros_centrocostos` cc ON `pp_detalle_movimiento`.`idRubrosCentroCostos`=cc.`Id`\n               INNER JOIN `pp_rubros_cpc` cpc ON `pp_detalle_movimiento`.`idRubrosCpc`=cpc.`Id`\n               INNER JOIN `pp_rubros_fuente_financiacion` ff ON `pp_detalle_movimiento`.`idRubrosFunteFinanciacion`=ff.`Id`\n                        LEFT JOIN \n                        (SELECT\n                            pp_movimiento.IdObligacion, \n                            pp_detalle_movimiento.Id_Rubro, \n                            pp_detalle_movimiento.Id_Tercero,\n                            SUM(pp_detalle_movimiento.Valor) Valor\n                        FROM\n                            pp_detalle_movimiento\n                            INNER JOIN pp_movimiento       ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n                            INNER JOIN pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                        WHERE (pp_tipo_documentos.Id_ClaseDoc = 6\n                            AND pp_movimiento.Id_MotivoAnulacion = 1\n                            AND pp_detalle_movimiento.Estado =1)\n                            GROUP BY pp_movimiento.IdObligacion, pp_detalle_movimiento.Id_Rubro, pp_detalle_movimiento.Id_Tercero) e \n                             ON (e.IdObligacion=pp_movimiento.Id) AND (e.Id_Rubro=pp_detalle_movimiento.Id_Rubro) AND (e.Id_Tercero=pp_detalle_movimiento.Id_Tercero) \n                            INNER JOIN rh_nomina_concepto_unidadf  \t    ON (pp_detalle_movimiento.Id_ConceptoN = rh_nomina_concepto_unidadf.Id)\n                            INNER JOIN rh_nomina_conceptos        \t    ON (rh_nomina_concepto_unidadf.Id_ConceptosN = rh_nomina_conceptos.Id)\n                            INNER JOIN rh_tipo_clasificacion_conceptonomina  ON (rh_nomina_conceptos.Id_Clasificacion = rh_tipo_clasificacion_conceptonomina.Id)\n                        \n                         WHERE (pp_tipo_documentos.Id_ClaseDoc = 5  \n                         AND pp_movimiento.IdCompromiso IN (" + xid_documento.substring(1, xid_documento.length()) + ")\n                         AND rh_tipo_clasificacion_conceptonomina.Id = '" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "'\n                         AND pp_detalle_movimiento.idEncabezado = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' \n                         AND pp_rubros.idEncabezadoRubro = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
            }
        } else if (!this.JCH_SinCausacion.isSelected()) {
            sql = "SELECT  `pp_detalle_movimiento`.`Id_Rubro` , `pp_rubros`.`Nbre` , `pp_detalle_movimiento`.`Valor` ,  (`pp_detalle_movimiento`.`Valor`-IFNULL(d.VPagado,0)) Valor ,true,  `pp_movimiento`.`IdDocContable` , `pp_movimiento`.`IdDisponibilidad`  , `pp_movimiento`.`IdCompromiso`, `pp_movimiento`.`IdObligacion`,`pp_movimiento`.`IdRadicacion`\n,`pp_detalle_movimiento`.`idRubrosCentroCostos` idCentroCostos,cc.`nombre` centroCostos\n,`pp_detalle_movimiento`.`idRubrosCpc` idCpc,cpc.`nombre` cpc,`pp_detalle_movimiento`.`idRubrosFunteFinanciacion` idFuenteF,ff.`nombre` fuenteFinanciacion\n,`pp_detalle_movimiento`.`idTopoVigencia` idTipoVig,tv.`Nombre` tipoVigencia \n FROM `pp_detalle_movimiento`  \n INNER JOIN  `pp_movimiento`  ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`) \n INNER JOIN  `pp_rubros`   ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) and (`pp_rubros`.idEncabezadoRubro='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')\n  INNER JOIN `pp_tipo_vigencia` tv ON `pp_detalle_movimiento`.`idTopoVigencia`=tv.`Id`\n               INNER JOIN `pp_rubros_centrocostos` cc ON `pp_detalle_movimiento`.`idRubrosCentroCostos`=cc.`Id`\n               INNER JOIN `pp_rubros_cpc` cpc ON `pp_detalle_movimiento`.`idRubrosCpc`=cpc.`Id`\n               INNER JOIN `pp_rubros_fuente_financiacion` ff ON `pp_detalle_movimiento`.`idRubrosFunteFinanciacion`=ff.`Id` lEFT JOIN (SELECT\n    SUM(`pp_detalle_movimiento`.`Valor`) AS `VPagado`, `pp_movimiento`.`IdCompromiso`, pp_detalle_movimiento.`Id_Rubro`, `pp_movimiento`.`IdObligacion`\nFROM\n     `pp_detalle_movimiento`\n    INNER JOIN  `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN  `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE ( `pp_tipo_documentos`.`Id_ClaseDoc` =6  AND pp_movimiento.`Id_MotivoAnulacion`=1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')\nGROUP BY `pp_movimiento`.`IdCompromiso`,  pp_detalle_movimiento.`Id_Rubro`) d ON d.IdObligacion=`pp_movimiento`.`IdObligacion` and (d.Id_Rubro=`pp_detalle_movimiento`.`Id_Rubro`)  \n WHERE (`pp_movimiento`.`IdDocContable` in(" + xidDocumentoC.substring(1, xidDocumentoC.length()) + ") AND  pp_detalle_movimiento.`Id_Tercero` in(" + xIdTercero.substring(1, xIdTercero.length()) + ") \n  AND pp_rubros.idEncabezadoRubro ='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
            if (this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 28).toString().trim().equals("4")) {
                sql = "SELECT  `pp_detalle_movimiento`.`Id_Rubro` , `pp_rubros`.`Nbre` , `pp_detalle_movimiento`.`Valor` ,  (`pp_detalle_movimiento`.`Valor`-IFNULL(d.VPagado,0)) Valor ,true,  `pp_movimiento`.`IdDocContable` , `pp_movimiento`.`IdDisponibilidad`  , `pp_movimiento`.`IdCompromiso`, `pp_movimiento`.`IdObligacion`,`pp_movimiento`.`IdRadicacion`\n FROM `pp_detalle_movimiento`  \n INNER JOIN  `pp_movimiento`  ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`) \n INNER JOIN  `pp_rubros`   ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) and (`pp_rubros`.idEncabezadoRubro='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')\n lEFT JOIN (SELECT\n    SUM(`pp_detalle_movimiento`.`Valor`) AS `VPagado`, `pp_movimiento`.`IdCompromiso`, pp_detalle_movimiento.`Id_Rubro`, `pp_movimiento`.`IdObligacion`\nFROM\n     `pp_detalle_movimiento`\n    INNER JOIN  `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN  `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE ( `pp_tipo_documentos`.`Id_ClaseDoc` =6  AND pp_movimiento.`Id_MotivoAnulacion`=1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')\nGROUP BY `pp_movimiento`.`IdCompromiso`,  pp_detalle_movimiento.`Id_Rubro`) d ON d.IdObligacion=`pp_movimiento`.`IdObligacion` and (d.Id_Rubro=`pp_detalle_movimiento`.`Id_Rubro`)  \n WHERE (`pp_movimiento`.`IdDocContable` in(" + xidDocumentoC.substring(1, xidDocumentoC.length()) + ") \n  AND pp_rubros.idEncabezadoRubro ='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
            }
        } else {
            String tercero = " AND  pp_detalle_movimiento.`Id_Tercero` in(" + xIdTercero.substring(1, xIdTercero.length()) + ") ";
            if (this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 28).toString().trim().equals("4")) {
                tercero = "";
            }
            sql = "SELECT  `pp_detalle_movimiento`.`Id_Rubro` , `pp_rubros`.`Nbre` , `pp_detalle_movimiento`.`Valor` ,  (`pp_detalle_movimiento`.`Valor`-IFNULL(d.VPagado,0)) Valor ,true,  `pp_movimiento`.`IdDocContable` , `pp_movimiento`.`IdDisponibilidad`  , `pp_movimiento`.`IdCompromiso`, `pp_movimiento`.`IdObligacion`,`pp_movimiento`.`IdRadicacion`\n ,`pp_detalle_movimiento`.`idRubrosCentroCostos` idCentroCostos,cc.`nombre` centroCostos\n,`pp_detalle_movimiento`.`idRubrosCpc` idCpc,cpc.`nombre` cpc,`pp_detalle_movimiento`.`idRubrosFunteFinanciacion` idFuenteF,ff.`nombre` fuenteFinanciacion\n,`pp_detalle_movimiento`.`idTopoVigencia` idTipoVig,tv.`Nombre` tipoVigencia \n FROM `pp_detalle_movimiento`  \n INNER JOIN  `pp_movimiento`  ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`) \n INNER JOIN  `pp_rubros`   ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) \n  INNER JOIN `pp_tipo_vigencia` tv ON `pp_detalle_movimiento`.`idTopoVigencia`=tv.`Id`\n               INNER JOIN `pp_rubros_centrocostos` cc ON `pp_detalle_movimiento`.`idRubrosCentroCostos`=cc.`Id`\n               INNER JOIN `pp_rubros_cpc` cpc ON `pp_detalle_movimiento`.`idRubrosCpc`=cpc.`Id`\n               INNER JOIN `pp_rubros_fuente_financiacion` ff ON `pp_detalle_movimiento`.`idRubrosFunteFinanciacion`=ff.`Id`lEFT JOIN (SELECT\n    SUM(`pp_detalle_movimiento`.`Valor`) AS `VPagado`, `pp_movimiento`.`IdCompromiso`, pp_detalle_movimiento.`Id_Rubro`, `pp_movimiento`.`IdObligacion`\nFROM\n     `pp_detalle_movimiento`\n    INNER JOIN  `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN  `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE ( `pp_tipo_documentos`.`Id_ClaseDoc` =6  AND pp_movimiento.`Id_MotivoAnulacion`=1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')\nGROUP BY `pp_movimiento`.`IdCompromiso`,  pp_detalle_movimiento.`Id_Rubro`) d ON d.IdObligacion=`pp_movimiento`.`IdObligacion` and (d.Id_Rubro=`pp_detalle_movimiento`.`Id_Rubro`)  \n WHERE (`pp_movimiento`.Id in(" + xIdObligacion.substring(1, xIdObligacion.length()) + ") " + tercero + " \n  AND pp_rubros.idEncabezadoRubro ='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
        }
        double xvalor = 0.0d;
        if (sql != null) {
            System.out.println(" Buscar Rubro: " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 0;
                    while (rs.next()) {
                        this.modeloPresupuesto.addRow(this.xdato);
                        this.modeloPresupuesto.setValueAt(rs.getString(1), x, 0);
                        this.modeloPresupuesto.setValueAt(rs.getString(2), x, 1);
                        this.modeloPresupuesto.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                        this.modeloPresupuesto.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                        this.modeloPresupuesto.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                        this.modeloPresupuesto.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                        this.modeloPresupuesto.setValueAt(Long.valueOf(rs.getLong(7)), x, 6);
                        this.modeloPresupuesto.setValueAt(Long.valueOf(rs.getLong(8)), x, 7);
                        this.modeloPresupuesto.setValueAt(false, x, 8);
                        this.modeloPresupuesto.setValueAt(Long.valueOf(rs.getLong("IdRadicacion")), x, 9);
                        this.modeloPresupuesto.setValueAt(Integer.valueOf(rs.getInt("idCentroCostos")), x, 10);
                        this.modeloPresupuesto.setValueAt(rs.getString("centroCostos"), x, 11);
                        this.modeloPresupuesto.setValueAt(Integer.valueOf(rs.getInt("idFuenteF")), x, 12);
                        this.modeloPresupuesto.setValueAt(rs.getString("fuenteFinanciacion"), x, 13);
                        this.modeloPresupuesto.setValueAt(Integer.valueOf(rs.getInt("idCpc")), x, 14);
                        this.modeloPresupuesto.setValueAt(rs.getString("cpc"), x, 15);
                        this.modeloPresupuesto.setValueAt(Integer.valueOf(rs.getInt("idTipoVig")), x, 16);
                        this.modeloPresupuesto.setValueAt(rs.getString("tipoVigencia"), x, 17);
                        xvalor += rs.getDouble(4);
                        x++;
                    }
                } else {
                    crearTablaDistribucionPresupuestal();
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
            }
            this.JTFFTotalizarPResupuesto.setValue(Double.valueOf(xvalor));
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGeneracionPagos_Directo$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int atendido = Integer.parseInt(table.getValueAt(row, 10).toString());
            if (atendido == 1) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mSeleccionar(boolean xestado) {
        for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
            this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 6);
        }
        mTotalizarReembolso();
    }

    public void mTotalizarReembolso() {
        double xtotal = 0.0d;
        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
            if (this.JTResultado.getValueAt(y, 6).toString().equals("true")) {
                xtotal += Double.valueOf(this.xmodelo.getValueAt(y, 18).toString()).doubleValue();
            }
        }
        this.JTFFTotalizarR.setValue(Double.valueOf(xtotal));
    }

    private void mActualizarNDocumentoDescuentoNota(String Xid_Doc) {
        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
            if (Double.valueOf(this.JTResultado.getValueAt(y, 12).toString()).doubleValue() != 0.0d && Boolean.valueOf(this.xmodelo.getValueAt(y, 6).toString()).booleanValue()) {
                String sql = "update cc_descuento_notac set Id_Comprobante='" + Xid_Doc + "' where Id_DocumentoC='" + this.xmodelo.getValueAt(y, 0) + "' and Id_Comprobante =0";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    public void mImprimir() {
        if (this.JRBCheque.isSelected()) {
            new convertirNumerosLetras();
            String[][] mparametros = new String[2][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "ValorL";
            mparametros[1][1] = this.xmt.mConvertirNumeroLetras(this.JTFFTotalizarR.getText().replace(".", ","));
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_FormatoCheques", mparametros);
        }
    }

    private void mAjustarValorDistribucionPpt() {
        if (this.JCHAplicaMovimientoPresupuestal.isSelected()) {
            for (int x = 0; x < this.JTDetallePresupuesto.getRowCount(); x++) {
                for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                    if (this.modeloPresupuesto.getValueAt(x, 0).toString().equals(this.xmodelo.getValueAt(y, 15).toString()) && this.modeloPresupuesto.getValueAt(x, 5).toString().equals(this.xmodelo.getValueAt(y, 0).toString())) {
                        this.modeloPresupuesto.setValueAt(this.xmodelo.getValueAt(y, 18), x, 3);
                    }
                }
            }
        }
    }

    public void mBuscar() {
        if (this.JCBTipoDoc_Cont1.getSelectedIndex() != -1) {
            if (this.JCBTipoDoc_Cont.getSelectedIndex() != -1) {
                mCargarDatos();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDoc_Cont.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de documento a pagar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoDoc_Cont1.requestFocus();
    }

    public void grabarPagoPresupuestal(String idDocumentoContable) {
        String consecutivo = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()][0] + "' and Id = '" + idDocumentoContable + "');";
        String numeroConsecutivo = this.xct.traerDato(consecutivo);
        if (this.JCH_Agrupado.isSelected()) {
            for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                if (this.JTResultado.getValueAt(y, 6).toString().equals("true") && this.JCHAplicaMovimientoPresupuestal.isSelected() && !this.xmodelo.getValueAt(y, 15).toString().equals("") && this.JTDetallePresupuesto.getRowCount() != -1 && !this.xmt.mVerificarDatosTablaTrue(this.JTDetallePresupuesto, 8)) {
                    this.xsql = "INSERT INTO `pp_movimiento` ( Id_Periodo, Id_TipoDoc, FechaD, Observacion, IdCompromiso, IdDocContable, IdObligacion,  IdUsuarioR, UsuarioS,  NoConcecutivo) VALUES ('" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.JTAObservacion.getText() + " COMPROBANTE DE EGRESO N° " + this.JTFFNDoc_Cont.getText() + "','" + this.xmodelo.getValueAt(y, 19).toString() + "','" + this.JTFFNDoc_Cont.getText() + "','" + this.xmodelo.getValueAt(y, 21).toString() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.consecutivoPresupuesto + "');";
                    this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    for (int z = 0; z < this.JTDetallePresupuesto.getRowCount(); z++) {
                        if (this.JCH_Agrupado.isSelected()) {
                            if (!Boolean.valueOf(this.modeloPresupuesto.getValueAt(z, 8).toString()).booleanValue() && Boolean.valueOf(this.JTDetallePresupuesto.getValueAt(z, 4).toString()).booleanValue()) {
                                this.xsql = " insert into pp_detalle_movimiento  (Id_Movimiento, Id_Rubro, idEncabezado,  Id_Tercero, NFactura, Valor, Observacion, idRubrosCentroCostos, idRubrosFunteFinanciacion, idRubrosCpc,  idTopoVigencia)\nvalues ('" + this.JTFFNDoc_Ppt.getText() + "','" + this.modeloPresupuesto.getValueAt(z, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y, 9).toString() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 3).toString() + "','" + this.xmodelo.getValueAt(y, 14).toString() + " COMPROBANTE DE EGRESO N° " + this.JTF_NComprobante.getText() + "','" + this.modeloPresupuesto.getValueAt(z, 10).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 12).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 14).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 16).toString() + "');";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                                this.modeloPresupuesto.setValueAt(true, z, 8);
                            }
                        } else if (!Boolean.valueOf(this.modeloPresupuesto.getValueAt(z, 8).toString()).booleanValue() && Boolean.valueOf(this.JTDetallePresupuesto.getValueAt(z, 4).toString()).booleanValue() && this.JTDetallePresupuesto.getValueAt(z, 5).toString().equals(this.JTResultado.getValueAt(y, 0).toString())) {
                            this.xsql = " insert into pp_detalle_movimiento (Id_Movimiento, Id_Rubro, idEncabezado,  Id_Tercero, NFactura, Valor, Observacion, idRubrosCentroCostos,  idRubrosFunteFinanciacion,  idRubrosCpc,  idTopoVigencia)\nvalues ('" + this.JTFFNDoc_Ppt.getText() + "','" + this.modeloPresupuesto.getValueAt(z, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y, 9).toString() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 3).toString() + "','" + this.xmodelo.getValueAt(y, 14).toString() + " COMPROBANTE DE EGRESO N° " + this.JTF_NComprobante.getText() + "','" + this.modeloPresupuesto.getValueAt(z, 10).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 12).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 14).toString() + "','" + this.modeloPresupuesto.getValueAt(z, 16).toString() + "');";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.modeloPresupuesto.setValueAt(true, z, 8);
                        }
                    }
                }
            }
            return;
        }
        for (int y2 = 0; y2 < this.JTResultado.getRowCount(); y2++) {
            if (this.JTResultado.getValueAt(y2, 6).toString().equals("true")) {
                if (this.JCHAplicaMovimientoPresupuestal.isSelected() && !this.xmodelo.getValueAt(y2, 15).toString().equals("") && this.JTDetallePresupuesto.getRowCount() != -1) {
                    this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,NoFact, IdDocContable, `IdDisponibilidad`  ,`IdCompromiso`, IdObligacion, IdUsuarioR,`UsuarioS`,NoConcecutivo)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xmodelo.getValueAt(y2, 14).toString() + " COMPROBANTE DE EGRESO N° " + numeroConsecutivo + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','" + idDocumentoContable + "','" + this.modeloPresupuesto.getValueAt(0, 6).toString() + "','" + this.modeloPresupuesto.getValueAt(0, 7).toString() + "','" + this.xmodelo.getValueAt(y2, 21).toString() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.consecutivoPresupuesto + "');";
                    this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    for (int tabla = 0; tabla < this.JTDetallePresupuesto.getRowCount(); tabla++) {
                        if (((Long) this.xmodelo.getValueAt(y2, 28)).longValue() == 3) {
                            this.xsql = "insert into  pp_detalle_movimiento( Id_Movimiento, Id_Rubro, idEncabezado, Id_Tercero, NFactura,  Valor, Observacion, idRubrosCentroCostos, idRubrosFunteFinanciacion, idRubrosCpc,  idTopoVigencia)\n values ('" + this.JTFFNDoc_Ppt.getText() + "','" + this.modeloPresupuesto.getValueAt(tabla, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','" + this.modeloPresupuesto.getValueAt(tabla, 3).toString() + "','" + this.xmodelo.getValueAt(y2, 14).toString() + " COMPROBANTE DE EGRESO N° " + idDocumentoContable + "','" + this.modeloPresupuesto.getValueAt(tabla, 10).toString() + "','" + this.modeloPresupuesto.getValueAt(tabla, 12).toString() + "','" + this.modeloPresupuesto.getValueAt(tabla, 14).toString() + "','" + this.modeloPresupuesto.getValueAt(tabla, 16).toString() + "');";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.modeloPresupuesto.setValueAt(true, tabla, 8);
                        } else if (Boolean.valueOf(this.JTDetallePresupuesto.getValueAt(tabla, 4).toString()).booleanValue()) {
                            this.xsql = "insert into pp_detalle_movimiento( Id_Movimiento, Id_Rubro, idEncabezado, Id_Tercero, NFactura,  Valor, Observacion, idRubrosCentroCostos,  idRubrosFunteFinanciacion,  idRubrosCpc, idTopoVigencia)\n values ('" + this.JTFFNDoc_Ppt.getText() + "','" + this.modeloPresupuesto.getValueAt(tabla, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','" + this.modeloPresupuesto.getValueAt(tabla, 3).toString() + "','" + this.xmodelo.getValueAt(y2, 14).toString() + " COMPROBANTE DE EGRESO N° " + idDocumentoContable + "','" + this.modeloPresupuesto.getValueAt(tabla, 10).toString() + "','" + this.modeloPresupuesto.getValueAt(tabla, 12).toString() + "','" + this.modeloPresupuesto.getValueAt(tabla, 14).toString() + "','" + this.modeloPresupuesto.getValueAt(tabla, 16).toString() + "');";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.modeloPresupuesto.setValueAt(true, tabla, 8);
                        }
                    }
                }
                Principal.xclase.mActulizarPagoRadicacion(idDocumentoContable, this.xmodelo.getValueAt(y2, 5).toString());
                mActualizarNDocumentoDescuentoNota(idDocumentoContable);
                if (this.JRBCheque.isSelected()) {
                    this.xsql = "update cc_cuentaxempresa  set  ConsecutivoA='" + this.JTFNCheque.getText() + "' where Id='" + this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][0] + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
        }
    }
}
