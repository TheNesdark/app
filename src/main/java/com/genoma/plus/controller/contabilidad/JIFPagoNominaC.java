package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Contabilidad.JIFGeneracionDisfon;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import java.util.Arrays;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFPagoNominaC.class */
public class JIFPagoNominaC extends JInternalFrame {
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    private String[] xidgrupo;
    private String[] xidsubcuenta;
    public String[] xidauxiliar;
    public String[] xidauxiliarxpagar;
    public String[][] xidcentrocosto;
    public String[][] xidempresa;
    public String[][] xId_CuentasB;
    public String[][] xidperiodo_ppt;
    private Object[] xdato;
    private int xtipo;
    private String[] xidtipodoc_ppt;
    private String[] xidtipodoc_cont;
    private String[] xidperiodo_cont;
    private String[] xidtipodoc_contp;
    private String[] xidClasificacion;
    private String[] xId_ConceptoN;
    private String xsql;
    private String xId_Dato;
    private String xcc_puc;
    private long xConsecutivo;
    private long xConsecutivoP;
    private ButtonGroup JBGTipo;
    private ButtonGroup JBGTipoP;
    private JButton JBTExportar;
    private JButton JBT_Reorganizar;
    private JComboBox JCBClasificacion;
    private JComboBox JCBGrupo;
    private JComboBox JCBPeriodo_Cont;
    private JComboBox JCBPeriodo_Ppt;
    public JComboBox JCBSubCuenta;
    private JComboBox JCBTipoDoc_Cont;
    private JComboBox JCBTipoDoc_Cont1;
    private JComboBox JCBTipoDoc_Ppt;
    private JComboBox JCB_CuentaBancaria;
    private JComboBox JCB_NConcepto;
    private JCheckBox JCHEnviarCorreo;
    private JCheckBox JCHFiltroConcepto;
    private JCheckBox JCH_Agrupado;
    private JCheckBox JCH_Agrupado1;
    private JCheckBox JCH_AplicaN;
    private JCheckBox JCH_EsNomina;
    private JDateChooser JDFFechaC;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JDateChooser JDFFechaPP;
    private JPanel JPID_Contable;
    private JPanel JPID_Exportar;
    private JPanel JPIDatosForma;
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
    private JTextField JTFBusqueda;
    private JFormattedTextField JTFFNDoc_Cont;
    private JFormattedTextField JTFFNDoc_Ppt;
    private JFormattedTextField JTFFTotalizarR;
    private JTextField JTFNCheque;
    private JTextField JTFRuta;
    private JTextField JTF_NComprobante;
    private JTabbedPane JTP_Concepto;
    public JTable JTResultado;
    public JTable JTResultado1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private int xtipopago = 0;
    private String xidcuentapuc = "0";
    private String xId_Banco = "0";
    private long xIdNomina = 0;

    public JIFPagoNominaC(int xtipo) {
        this.xtipo = 0;
        initComponents();
        this.xtipo = xtipo;
        System.out.println(Principal.informacionIps.getNombreIps());
        cargarGrupos();
        this.xcc_puc = "cc_puc";
        mNuevo();
    }

    private void cargarGrupos() {
        this.xidgrupo = this.xct.llenarCombo("SELECT Id, CONCAT(Id,'-',Nbre)AS Nombre FROM  cc_puc WHERE (Id_Nivel =3 AND ClasificacionP=1)  ORDER BY Nbre ASC ", this.xidgrupo, this.JCBGrupo);
        this.JCBGrupo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v119, types: [java.lang.Object[], java.lang.Object[][]] */
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
        this.JCH_AplicaN = new JCheckBox();
        this.JSPResultado1 = new JScrollPane();
        this.JTResultado1 = new JTable();
        this.JPID_Exportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFBusqueda = new JTextField();
        this.JCBTipoDoc_Cont1 = new JComboBox();
        this.JTP_Concepto = new JTabbedPane();
        this.JPI_DatosC = new JPanel();
        this.JCBTipoDoc_Cont = new JComboBox();
        this.JDFFechaC = new JDateChooser();
        this.JTF_NComprobante = new JTextField();
        this.JCH_Agrupado = new JCheckBox();
        this.JPI_DNomina = new JPanel();
        this.JCB_NConcepto = new JComboBox();
        this.JBT_Reorganizar = new JButton();
        this.JDFFechaF = new JDateChooser();
        this.JDFFechaI = new JDateChooser();
        this.JCBClasificacion = new JComboBox();
        this.JCHFiltroConcepto = new JCheckBox();
        this.JCH_Agrupado1 = new JCheckBox();
        this.JCH_EsNomina = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE PAGOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifpagosnominac");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFPagoNominaC.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                JIFPagoNominaC.this.formInternalFrameActivated(evt);
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
        this.JTResultado.setRowHeight(20);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.2
            public void mouseClicked(MouseEvent evt) {
                JIFPagoNominaC.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPagoNominaC.this.JTResultadoPropertyChange(evt);
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
        this.JRBSTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.4
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JRBSTodoActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBQuitarS);
        this.JRBQuitarS.setFont(new Font("Arial", 1, 12));
        this.JRBQuitarS.setText("Quitar Selección");
        this.JRBQuitarS.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.5
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JRBQuitarSActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSTodo).addGap(18, 18, 18).addComponent(this.JRBQuitarS)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSTodo).addComponent(this.JRBQuitarS)).addContainerGap(-1, 32767)));
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupo.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.6
            public void itemStateChanged(ItemEvent evt) {
                JIFPagoNominaC.this.JCBGrupoItemStateChanged(evt);
            }
        });
        this.JCBSubCuenta.setFont(new Font("Arial", 1, 12));
        this.JCBSubCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPITipoPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipoP.add(this.JRBSDisfon);
        this.JRBSDisfon.setFont(new Font("Arial", 1, 12));
        this.JRBSDisfon.setText("Disfon");
        this.JRBSDisfon.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.7
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JRBSDisfonActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBCheque);
        this.JRBCheque.setFont(new Font("Arial", 1, 12));
        this.JRBCheque.setText("Cheque");
        this.JRBCheque.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.8
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JRBChequeActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBOtros);
        this.JRBOtros.setFont(new Font("Arial", 1, 12));
        this.JRBOtros.setSelected(true);
        this.JRBOtros.setText("Otro");
        this.JRBOtros.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.9
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JRBOtrosActionPerformed(evt);
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
        this.JCHEnviarCorreo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.10
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JCHEnviarCorreoActionPerformed(evt);
            }
        });
        this.JCB_CuentaBancaria.setFont(new Font("Arial", 1, 12));
        this.JCB_CuentaBancaria.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_CuentaBancaria.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.11
            public void itemStateChanged(ItemEvent evt) {
                JIFPagoNominaC.this.JCB_CuentaBancariaItemStateChanged(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción o concepto de pago agrupado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPIDatosFormaLayout = new GroupLayout(this.JPIDatosForma);
        this.JPIDatosForma.setLayout(JPIDatosFormaLayout);
        JPIDatosFormaLayout.setHorizontalGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosFormaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFormaLayout.createSequentialGroup().addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosFormaLayout.createSequentialGroup().addComponent(this.JTFFTotalizarR, -2, 185, -2).addGap(28, 28, 28).addComponent(this.JPITipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 167, 32767).addComponent(this.JCHEnviarCorreo).addGap(18, 18, 18).addComponent(this.JDFFechaPP, -2, 156, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosFormaLayout.createSequentialGroup().addComponent(this.JCBGrupo, -2, 287, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSubCuenta, 0, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITipoPago, -2, -1, -2)).addGroup(JPIDatosFormaLayout.createSequentialGroup().addComponent(this.JCB_CuentaBancaria, -2, 708, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion))).addContainerGap()));
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
        this.JTFFNDoc_Ppt.setEditable(false);
        this.JTFFNDoc_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Ppt.setHorizontalAlignment(0);
        this.JTFFNDoc_Ppt.setFont(new Font("Arial", 1, 18));
        this.JCH_AplicaN.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaN.setSelected(true);
        this.JCH_AplicaN.setText("Aplica?");
        this.JCH_AplicaN.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.12
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JCH_AplicaNActionPerformed(evt);
            }
        });
        GroupLayout JPID_ContableLayout = new GroupLayout(this.JPID_Contable);
        this.JPID_Contable.setLayout(JPID_ContableLayout);
        JPID_ContableLayout.setHorizontalGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ContableLayout.createSequentialGroup().addContainerGap().addGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ContableLayout.createSequentialGroup().addComponent(this.JCBPeriodo_Cont, -2, 238, -2).addGap(408, 408, 408).addComponent(this.JTFFNDoc_Cont, -2, 140, -2)).addGroup(JPID_ContableLayout.createSequentialGroup().addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Ppt, -2, 372, -2).addGap(18, 18, 18).addComponent(this.JTFFNDoc_Ppt, -2, 140, -2).addGap(18, 18, 18).addComponent(this.JCH_AplicaN))).addContainerGap(336, 32767)));
        JPID_ContableLayout.setVerticalGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ContableLayout.createSequentialGroup().addContainerGap().addGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Cont, -2, 50, -2).addComponent(this.JTFFNDoc_Cont)).addGap(18, 18, 18).addGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Ppt, -2, 50, -2).addComponent(this.JTFFNDoc_Ppt).addComponent(this.JCH_AplicaN)).addGap(32, 32, 32)));
        this.JTB_DatosM.addTab("DATOS CONTABLES Y/O PRESUPUESTALES", this.JPID_Contable);
        this.JSPResultado1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado1.setFont(new Font("Arial", 1, 12));
        this.JTResultado1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado1.setEditingColumn(1);
        this.JTResultado1.setEditingRow(1);
        this.JTResultado1.setGridColor(new Color(204, 204, 204));
        this.JTResultado1.setRowHeight(20);
        this.JTResultado1.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado1.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.13
            public void mouseClicked(MouseEvent evt) {
                JIFPagoNominaC.this.JTResultado1MouseClicked(evt);
            }
        });
        this.JTResultado1.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPagoNominaC.this.JTResultado1PropertyChange(evt);
            }
        });
        this.JSPResultado1.setViewportView(this.JTResultado1);
        this.JTB_DatosM.addTab("DISTRIBUCIÓN PRESUPUESTAL", this.JSPResultado1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\GenomaCountA\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.15
            public void mouseClicked(MouseEvent evt) {
                JIFPagoNominaC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.16
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda por tercero o documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBusqueda.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.17
            public void keyPressed(KeyEvent evt) {
                JIFPagoNominaC.this.JTFBusquedaKeyPressed(evt);
            }
        });
        GroupLayout JPID_ExportarLayout = new GroupLayout(this.JPID_Exportar);
        this.JPID_Exportar.setLayout(JPID_ExportarLayout);
        JPID_ExportarLayout.setHorizontalGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ExportarLayout.createSequentialGroup().addContainerGap().addGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ExportarLayout.createSequentialGroup().addComponent(this.JTFRuta, -1, 812, 32767).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 137, -2).addGap(244, 244, 244)).addGroup(JPID_ExportarLayout.createSequentialGroup().addComponent(this.JTFBusqueda, -2, 536, -2).addContainerGap(-1, 32767)))));
        JPID_ExportarLayout.setVerticalGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPID_ExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFBusqueda, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 89, 32767).addGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -1, 50, 32767)).addContainerGap()));
        this.JTB_DatosM.addTab("EXPORTAR", this.JPID_Exportar);
        this.JCBTipoDoc_Cont1.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Cont1.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento para pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTP_Concepto.setForeground(Color.red);
        this.JTP_Concepto.setFont(new Font("Arial", 1, 14));
        this.JPI_DatosC.setForeground(Color.red);
        this.JCBTipoDoc_Cont.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Cont.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Cont.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.18
            public void itemStateChanged(ItemEvent evt) {
                JIFPagoNominaC.this.JCBTipoDoc_ContItemStateChanged(evt);
            }
        });
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JTF_NComprobante.setFont(new Font("Arial", 1, 12));
        this.JTF_NComprobante.setHorizontalAlignment(0);
        this.JTF_NComprobante.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Comprobante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Agrupado.setFont(new Font("Arial", 1, 12));
        this.JCH_Agrupado.setSelected(true);
        this.JCH_Agrupado.setText("Es Agrupado?");
        this.JCH_Agrupado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.19
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JCH_AgrupadoActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosCLayout = new GroupLayout(this.JPI_DatosC);
        this.JPI_DatosC.setLayout(JPI_DatosCLayout);
        JPI_DatosCLayout.setHorizontalGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaC, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDoc_Cont, -2, 372, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_Agrupado).addGap(37, 37, 37).addComponent(this.JTF_NComprobante, -2, 122, -2).addContainerGap()));
        JPI_DatosCLayout.setVerticalGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTF_NComprobante, GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_Agrupado).addComponent(this.JDFFechaC, -2, 50, -2).addComponent(this.JCBTipoDoc_Cont, -2, 50, -2)))).addContainerGap()));
        this.JTP_Concepto.addTab("DATOS PARA COMPROBANTE", this.JPI_DatosC);
        this.JCB_NConcepto.setFont(new Font("Arial", 1, 12));
        this.JCB_NConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_Reorganizar.setFont(new Font("Arial", 1, 12));
        this.JBT_Reorganizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_Reorganizar.setText("<html><P ALIGN=center>Reorganizar consecutivo");
        this.JBT_Reorganizar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.20
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JBT_ReorganizarActionPerformed(evt);
            }
        });
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.21
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPagoNominaC.this.JDFFechaFPropertyChange(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.22
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFPagoNominaC.this.JDFFechaIPropertyChange(evt);
            }
        });
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasificacion.setName("jIFpagoNominaC");
        this.JCBClasificacion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.23
            public void itemStateChanged(ItemEvent evt) {
                JIFPagoNominaC.this.JCBClasificacionItemStateChanged(evt);
            }
        });
        this.JCHFiltroConcepto.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroConcepto.setSelected(true);
        this.JCHFiltroConcepto.setText("Filtrar Concepto?");
        this.JCHFiltroConcepto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.24
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JCHFiltroConceptoActionPerformed(evt);
            }
        });
        this.JCH_Agrupado1.setFont(new Font("Arial", 1, 12));
        this.JCH_Agrupado1.setText("Es Agrupado?");
        this.JCH_Agrupado1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.25
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JCH_Agrupado1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_DNominaLayout = new GroupLayout(this.JPI_DNomina);
        this.JPI_DNomina.setLayout(JPI_DNominaLayout);
        JPI_DNominaLayout.setHorizontalGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DNominaLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JDFFechaI, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaF, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacion, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_NConcepto, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltroConcepto).addComponent(this.JCH_Agrupado1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JBT_Reorganizar, -2, 142, -2).addContainerGap()));
        JPI_DNominaLayout.setVerticalGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DNominaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DNominaLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCH_Agrupado1)).addComponent(this.JBT_Reorganizar).addGroup(GroupLayout.Alignment.LEADING, JPI_DNominaLayout.createSequentialGroup().addGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2)).addGroup(JPI_DNominaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_NConcepto, -2, 50, -2).addComponent(this.JCBClasificacion, -2, 50, -2)).addComponent(this.JCHFiltroConcepto)).addGap(0, 0, 32767))).addContainerGap()));
        this.JTP_Concepto.addTab("NOMINA", this.JPI_DNomina);
        this.JCH_EsNomina.setFont(new Font("Arial", 1, 12));
        this.JCH_EsNomina.setText("Es Nomina?");
        this.JCH_EsNomina.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.26
            public void actionPerformed(ActionEvent evt) {
                JIFPagoNominaC.this.JCH_EsNominaActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTB_DatosM, GroupLayout.Alignment.LEADING).addComponent(this.JSPResultado, GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(4, 4, 4).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_EsNomina).addComponent(this.JCBTipoDoc_Cont1, -2, 275, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Concepto))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.JCH_EsNomina).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Cont1, -2, 50, -2)).addComponent(this.JTP_Concepto, -2, 100, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResultado, -2, 293, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.JTB_DatosM, -2, 249, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && this.JTResultado.getSelectedColumn() == 0) {
            mCargarDatos(1);
            return;
        }
        if (Integer.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 10).toString()).intValue() == 1) {
            if (this.xtipo == 0) {
                Principal.xclase.cargarPantalla("Consultar NotaC");
                return;
            }
            return;
        }
        if (this.JTResultado.getSelectedRow() != -1 && this.JTResultado.getSelectedColumn() == 6) {
            String xidObligacion = "";
            String xnempresa = "";
            String xIdConceptoN = "";
            for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 6).toString()).booleanValue()) {
                    if (this.JCH_EsNomina.isSelected()) {
                        if (this.JCH_Agrupado1.isSelected()) {
                            xidObligacion = xidObligacion + "," + this.xmodelo.getValueAt(x, 28).toString();
                        } else {
                            xidObligacion = xidObligacion + "," + this.xmodelo.getValueAt(x, 21).toString();
                        }
                        xnempresa = xnempresa + "," + this.xmodelo.getValueAt(x, 9).toString();
                        System.out.println("" + this.xmodelo.getValueAt(x, 26).toString());
                        xIdConceptoN = xIdConceptoN + "," + this.xmodelo.getValueAt(x, 26).toString();
                    } else {
                        xidObligacion = xidObligacion + "," + this.xmodelo.getValueAt(x, 0).toString();
                    }
                }
            }
            if (xidObligacion.length() >= 1) {
                if (this.JCH_AplicaN.isSelected()) {
                    System.out.println("" + xIdConceptoN);
                    mCargarDatos_DistribucionPPT(xidObligacion, xnempresa, xIdConceptoN);
                    return;
                }
                return;
            }
            mCrearTablaDistribucionPPT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSTodoActionPerformed(ActionEvent evt) {
        mSeleccionar(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBQuitarSActionPerformed(ActionEvent evt) {
        mSeleccionar(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBGrupo.getSelectedIndex() != -1) {
            llenarSubCuentas();
        }
    }

    private void llenarSubCuentas() {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.JCBSubCuenta.removeAllItems();
        String sql = "SELECT Id, concat(Id,'-',Nbre)as Nombre FROM " + this.xcc_puc + " WHERE (Id LIKE'" + this.xidgrupo[this.JCBGrupo.getSelectedIndex()] + "%' AND UNivel=1) ORDER BY Nbre ASC ";
        this.xidsubcuenta = xct1.llenarCombo(sql, this.xidsubcuenta, this.JCBSubCuenta);
        this.JCBSubCuenta.setSelectedIndex(-1);
        xct1.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
        mTotalizarReembolso();
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
                System.out.println(this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][3]);
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTResultado.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_CuentaBancariaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCB_CuentaBancaria.getSelectedIndex() != -1) {
            this.xId_Banco = this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][0];
            if (this.JRBCheque.isSelected()) {
                System.out.println(this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][3]);
                this.JTFNCheque.setText("" + (Long.valueOf(this.xId_CuentasB[this.JCB_CuentaBancaria.getSelectedIndex()][3]).longValue() + 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultado1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultado1PropertyChange(PropertyChangeEvent evt) {
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
                this.JTF_NComprobante.setEditable(true);
                for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                    this.xmodelo.setValueAt(this.JTF_NComprobante.getText(), x, 17);
                }
                return;
            }
            this.JTF_NComprobante.setEditable(false);
            mBuscar();
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
    public void JCH_AplicaNActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaIPropertyChange(PropertyChangeEvent evt) {
        mLlenaComboClasificacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFPropertyChange(PropertyChangeEvent evt) {
        mLlenaComboClasificacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClasificacionItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBClasificacion.getSelectedIndex() != -1) {
            llenarConceptosDeNomina();
            this.xIdNomina = Long.valueOf(this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()]).longValue();
        }
    }

    private void llenarConceptosDeNomina() {
        this.JCB_NConcepto.removeAllItems();
        this.xsql = "SELECT `rh_nomina_conceptos`.`Id` , `rh_nomina_conceptos`.`Nbre` FROM `rh_nomina_liquidacion_detalle` INNER JOIN `rh_nomina_liquidacion` ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\nINNER JOIN `rh_nomina_concepto_unidadf` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`) INNER JOIN `rh_nomina_conceptos` \nON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) INNER JOIN `rh_tipo_clasificacion_conceptonomina` ON (`rh_tipo_clasificacion_conceptonomina`.`Id` = `rh_nomina_conceptos`.`Id_Clasificacion`)\nINNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Tercero`) WHERE (`rh_tipo_clasificacion_conceptonomina`.`EsContable` =0 AND \n`rh_tipo_clasificacion_conceptonomina`.`Id`= '" + this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()] + "' AND `rh_nomina_liquidacion`.`FechaR`>='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND `rh_nomina_liquidacion`.`FechaR`<='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "')\nGROUP BY `rh_nomina_conceptos`.`Id` ORDER BY `rh_nomina_conceptos`.`Nbre` ASC";
        this.xId_ConceptoN = this.xct.llenarCombo(this.xsql, this.xId_ConceptoN, this.JCB_NConcepto);
        this.JCB_NConcepto.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroConceptoActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroConcepto.isSelected()) {
            this.JCB_NConcepto.setEnabled(true);
        } else {
            this.JCB_NConcepto.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBusquedaKeyPressed(KeyEvent evt) {
        if (!this.JTFBusqueda.getText().isEmpty()) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_Agrupado1ActionPerformed(ActionEvent evt) {
    }

    private void mLlenaComboClasificacion() {
        if (this.xlleno) {
            this.xlleno1 = false;
            this.JCB_NConcepto.removeAllItems();
            this.JCBClasificacion.removeAllItems();
            this.xsql = "SELECT `rh_tipo_clasificacion_conceptonomina`.`Id` , `rh_tipo_clasificacion_conceptonomina`.`Nbre` FROM `rh_nomina_liquidacion_detalle` INNER JOIN `rh_nomina_liquidacion` ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\nINNER JOIN `rh_nomina_concepto_unidadf` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`) INNER JOIN `rh_nomina_conceptos` \nON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) INNER JOIN `rh_tipo_clasificacion_conceptonomina` ON (`rh_tipo_clasificacion_conceptonomina`.`Id` = `rh_nomina_conceptos`.`Id_Clasificacion`)\nINNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Tercero`) WHERE (`rh_tipo_clasificacion_conceptonomina`.`EsContable` =0 AND `rh_nomina_liquidacion`.`FechaR`>='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND `rh_nomina_liquidacion`.`FechaR`<='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "')\nGROUP BY `rh_tipo_clasificacion_conceptonomina`.`Id` ORDER BY `rh_tipo_clasificacion_conceptonomina`.`Nbre` ASC";
            this.xidClasificacion = this.xct.llenarCombo(this.xsql, this.xidClasificacion, this.JCBClasificacion);
            this.JCBClasificacion.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    public boolean isCellEditable(int row, int column) {
        return this.JTResultado.getModel().isCellEditable(row, column);
    }

    private void mNuevo_DPpt() {
        this.JTFFNDoc_Ppt.setText("");
        this.JCBTipoDoc_Ppt.removeAllItems();
        this.JCBPeriodo_Ppt.removeAllItems();
        this.xsql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=6 AND `pp_tipo_documentos`.`Estado` =1 ";
        this.xidtipodoc_ppt = this.xct.llenarCombo(this.xsql, this.xidtipodoc_ppt, this.JCBTipoDoc_Ppt);
        if (this.xidtipodoc_ppt.length > 1) {
            this.JCBTipoDoc_Ppt.setSelectedIndex(-1);
        }
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
        this.JCH_EsNomina.setSelected(true);
        this.xsql = "SELECT `Id`, `Nbre`, NConsecutivo FROM  `cc_tipo_documentoc` WHERE (EsEgreso=1 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc_cont = this.xct.llenarCombo(this.xsql, this.xidtipodoc_cont, this.JCBTipoDoc_Cont);
        if (this.xidtipodoc_cont.length > 1) {
            this.JCBTipoDoc_Cont.setSelectedIndex(0);
        }
        this.xidperiodo_cont = this.xct.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1 AND Activo=1) ORDER BY FechaF DESC", this.xidperiodo_cont, this.JCBPeriodo_Cont);
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
        this.JCBClasificacion.removeAllItems();
        this.xsql = "SELECT  `cc_tipo_documentoc`.`Id` , `cc_tipo_documentoc`.`Nbre`\nFROM   `cc_detalle_documentoc`  INNER JOIN  `cc_documentoc`  ON (  `cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  INNER JOIN  `cc_tipo_documentoc`   ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`)\nWHERE (`cc_documentoc`.`Id_Nomina` <>0) GROUP BY `cc_tipo_documentoc`.`Id` ORDER BY `cc_tipo_documentoc`.`Nbre` ASC ";
        System.out.println("Nomina : " + this.xsql);
        this.xidtipodoc_contp = this.xct.llenarCombo(this.xsql, this.xidperiodo_cont, this.JCBTipoDoc_Cont1);
        if (this.xidtipodoc_contp.length > 1) {
            this.JCBTipoDoc_Cont1.setSelectedIndex(0);
        }
        this.xsql = "SELECT `rh_tipo_clasificacion_conceptonomina`.`Id` , `rh_tipo_clasificacion_conceptonomina`.`Nbre` FROM `rh_nomina_liquidacion_detalle` INNER JOIN `rh_nomina_liquidacion` ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\nINNER JOIN `rh_nomina_concepto_unidadf` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`) INNER JOIN `rh_nomina_conceptos` \nON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) INNER JOIN `rh_tipo_clasificacion_conceptonomina` ON (`rh_tipo_clasificacion_conceptonomina`.`Id` = `rh_nomina_conceptos`.`Id_Clasificacion`)\nINNER JOIN `cc_terceros` ON (`cc_terceros`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Tercero`) WHERE (`rh_tipo_clasificacion_conceptonomina`.`EsContable` =0 AND `rh_nomina_liquidacion`.`FechaR`>='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND `rh_nomina_liquidacion`.`FechaR`<='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "')\nGROUP BY `rh_tipo_clasificacion_conceptonomina`.`Id` ORDER BY `rh_tipo_clasificacion_conceptonomina`.`Nbre` ASC";
        System.out.println("Clasificacion : " + this.xsql);
        this.xidClasificacion = this.xct.llenarCombo(this.xsql, this.xidClasificacion, this.JCBClasificacion);
        this.JCBClasificacion.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno1 = true;
    }

    public void mGrabar() {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTResultado, 6)) {
            if (this.JRBSDisfon.isSelected() || this.JRBOtros.isSelected()) {
                mGrabarD();
                return;
            }
            if (this.JRBCheque.isSelected()) {
                if (!this.JTFNCheque.getText().isEmpty()) {
                    mGrabarD();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe digitar en numero del cheque", "VERIFICAR", 1);
                    this.JTFNCheque.requestFocus();
                    return;
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un pago", "VERIFICAR", 1);
    }

    private void mGrabarD() {
        if (this.JCBSubCuenta.getSelectedIndex() != -1) {
            if (this.JCH_AplicaN.isSelected()) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 7, 6) && !this.xmt.mVerificarDatosLLeno(this.JTResultado, 15, 6)) {
                    mGrabarD1();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Falta cuenta contable y/o rubro presupuestal", "VERIFICAR", 1);
                    return;
                }
            }
            if (this.JCH_AplicaN.isSelected()) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 15, 6)) {
                    mGrabarD1();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Falta  rubro presupuestal", "VERIFICAR", 1);
                    return;
                }
            }
            if (this.JCH_AplicaN.isSelected()) {
                if (!this.xmt.mVerificarDatosLLeno(this.JTResultado, 7, 6)) {
                    mGrabarD1();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Falta  cuenta contable", "VERIFICAR", 1);
                    return;
                }
            }
            mGrabarD1();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la subcuenta", "VERIFICAR", 1);
        this.JTB_DatosM.setSelectedIndex(0);
        this.JCBSubCuenta.requestFocus();
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` ='" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()] + "' AND `Estado` =1 and date_format(FechaD, '%Y')='" + this.xmt.formatoANO.format(this.JDFFechaC.getDate()) + "' ) group by Id_TipoComprobante";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException e) {
        }
        this.xConsecutivo = Con + 1;
        this.JTF_NComprobante.setText("" + this.xConsecutivo);
    }

    private void mConsecutivo(int xId_Clase, String xid_TipoDoc) {
        int Con = 0;
        String sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , IF(MAX(`pp_movimiento`.`NoConcecutivo`) IS NULL, 0,MAX(`pp_movimiento`.`NoConcecutivo`)) AS MaximoCons FROM `pp_movimiento` INNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`) WHERE (`pp_tipo_documentos`.`Id_ClaseDoc` ='" + xId_Clase + "'  AND  pp_tipo_documentos.`Id`='" + xid_TipoDoc + "');";
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
            Logger.getLogger(JIFPagoNominaC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivoP = Con + 1;
    }

    private void mGrabarD1() {
        String PP_Concepto;
        String CC_Concepto;
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
        if (x == 0) {
            mConcecutivo();
            if (this.JCHFiltroConcepto.isSelected()) {
                PP_Concepto = this.JCB_NConcepto.getSelectedItem() + " COMPROBANTE DE EGRESO N° ";
                CC_Concepto = this.JCB_NConcepto.getSelectedItem().toString();
            } else {
                PP_Concepto = this.JCBClasificacion.getSelectedItem() + " COMPROBANTE DE EGRESO N° ";
                CC_Concepto = this.JCBClasificacion.getSelectedItem().toString();
            }
            if (this.JCH_Agrupado.isSelected()) {
                if (this.xmt.mVerificarDatosTablaTrue(this.JTResultado, 6)) {
                    for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                        if (this.JTResultado.getValueAt(y, 6).equals(true)) {
                            this.JTFFNDoc_Cont.setText("" + crearDocumentoContable());
                            crearMovimientoDebito(y, CC_Concepto);
                            crearMovimientoCredito(y, CC_Concepto, false);
                            if (this.JCH_AplicaN.isSelected() && Principal.informacionIps.getManejaPresupuesto().intValue() == 1 && this.JTResultado1.getRowCount() != -1) {
                                String[] parts = this.xmodelo.getValueAt(y, 27).toString().split("\\,");
                                System.out.println("" + Arrays.toString(this.xmodelo.getValueAt(y, 27).toString().split("\\,")));
                                for (String texto : parts) {
                                    for (int z = 0; z < this.JTResultado1.getRowCount(); z++) {
                                        if (Boolean.valueOf(this.JTResultado1.getValueAt(z, 4).toString()).booleanValue() && texto.equals(this.xmodelo1.getValueAt(z, 7).toString())) {
                                            crearMovimientoPresupuestal(y, PP_Concepto);
                                            crearMovimientoDetallePresupuestoUnico(y, PP_Concepto, z);
                                        }
                                    }
                                }
                            }
                            System.out.println("" + this.xmodelo.getValueAt(y, 28).toString());
                            System.out.println("" + this.xmodelo.getValueAt(y, 20).toString());
                            this.xsql = "Update rh_nomina_liquidacion_detalle set Id_DocContableE='" + this.JTFFNDoc_Cont.getText() + "' WHERE (`Id_ConceptoCN` in(" + this.xmodelo.getValueAt(y, 20).toString() + ") AND `rh_nomina_liquidacion_detalle`.`Id_Obligacion` in(" + this.xmodelo.getValueAt(y, 28).toString() + ") AND `Id_Tercero` ='" + this.xmodelo.getValueAt(y, 9).toString() + "' and Id_DocContableE=0) ";
                            System.out.println("" + this.xsql);
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                }
            } else {
                for (int y2 = 0; y2 < this.JTResultado.getRowCount(); y2++) {
                    if (this.JTResultado.getValueAt(y2, 6).toString().equals("true")) {
                        mConcecutivo();
                        String sql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_Radicacion, Id_PeriodoC, NConsecutivo, TipoPago, NCheque, `Id_CuentaEmpresa`,  Id_Nomina, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(y2, 5).toString() + "','" + this.xidperiodo_cont[this.JCBPeriodo_Cont.getSelectedIndex()] + "','" + this.xConsecutivo + "','" + this.xtipopago + "','" + this.JTFNCheque.getText() + "','" + this.xId_Banco + "','" + this.xmodelo.getValueAt(y2, 0).toString() + "','" + CC_Concepto + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        String xid = this.xct.ejecutarSQLId(sql);
                        this.xct.cerrarConexionBd();
                        this.JTFFNDoc_Cont.setText(xid);
                        String sql2 = "insert into cc_detalle_documentoc(Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, NFactura, VDebito, VCredito, Id_ConceptoN ,Id_Certificado,  Concepto) values('" + xid + "','" + this.xmodelo.getValueAt(y2, 7).toString() + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "','" + this.xmodelo.getValueAt(y2, 5).toString() + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','" + this.xmodelo.getValueAt(y2, 18).toString() + "','0','" + this.xmodelo.getValueAt(y2, 20).toString() + "','" + this.xmodelo.getValueAt(y2, 25).toString() + "','" + CC_Concepto + "')";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                        String sql3 = "insert into cc_detalle_documentoc(Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, NFactura, TipoCPuc, VDebito, VCredito, Id_ConceptoN, Id_Certificado,  Concepto) values('" + xid + "','" + this.xidsubcuenta[this.JCBSubCuenta.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "','" + this.xmodelo.getValueAt(y2, 5).toString() + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','1','0','" + this.xmodelo.getValueAt(y2, 18).toString() + "','" + this.xmodelo.getValueAt(y2, 20).toString() + "','" + this.xmodelo.getValueAt(y2, 25).toString() + "','" + CC_Concepto + "')";
                        this.xct.ejecutarSQL(sql3);
                        this.xct.cerrarConexionBd();
                        if (!this.JCH_EsNomina.isSelected()) {
                            String sql4 = "insert into m_cc_radicacion_fact_pago(`Id_Radicacion` , `Id_Documento` , `Valor` ) values('" + this.xmodelo.getValueAt(y2, 5).toString() + "','" + xid + "','" + this.xmodelo.getValueAt(y2, 18).toString() + "')";
                            this.xct.ejecutarSQL(sql4);
                            this.xct.cerrarConexionBd();
                        } else {
                            if (this.JCH_Agrupado1.isSelected()) {
                                this.xsql = "Update rh_nomina_liquidacion_detalle set Id_DocContableE='" + this.JTFFNDoc_Cont.getText() + "' WHERE (`Id_ConceptoCN` ='" + this.xmodelo.getValueAt(y2, 20).toString() + "' AND `rh_nomina_liquidacion_detalle`.`Id_Obligacion` in(" + this.xmodelo.getValueAt(y2, 28).toString() + ") AND `Id_Tercero` ='" + this.xmodelo.getValueAt(y2, 9).toString() + "' and Id_DocContableE=0) ";
                            } else {
                                this.xsql = "Update rh_nomina_liquidacion_detalle set Id_DocContableE='" + this.JTFFNDoc_Cont.getText() + "' WHERE (`Id_ConceptoCN` ='" + this.xmodelo.getValueAt(y2, 20).toString() + "' AND `Id_Liquidacion` ='" + this.xmodelo.getValueAt(y2, 3).toString() + "' AND `Id_Tercero` ='" + this.xmodelo.getValueAt(y2, 9).toString() + "' and Id_DocContableE=0) ";
                            }
                            System.out.println("Actuzali : " + this.xsql);
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                        if (this.JCH_AplicaN.isSelected() && Principal.informacionIps.getManejaPresupuesto().intValue() == 1 && this.JTResultado1.getRowCount() != -1) {
                            mConsecutivo(6, this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()]);
                            this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,NoConcecutivo, `Observacion`,NoFact, IdDocContable, `IdCompromiso`, IdObligacion,  IdUsuarioR,`UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xConsecutivoP + "','" + PP_Concepto + xid + "','" + this.xmodelo.getValueAt(y2, 3).toString() + "','" + xid + "','" + this.xmodelo.getValueAt(y2, 19).toString() + "','" + this.xmodelo.getValueAt(y2, 21).toString() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                            System.out.println("Inserta Encabezado -->" + this.xsql);
                            this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
                            this.xct.cerrarConexionBd();
                            if (this.JCH_Agrupado1.isSelected()) {
                                String[] parts2 = this.xmodelo.getValueAt(y2, 27).toString().split("\\,");
                                int i = 0;
                                for (String texto2 : parts2) {
                                    System.out.println(" i--> " + i + " str--> " + texto2);
                                    for (int z2 = 0; z2 < this.JTResultado1.getRowCount(); z2++) {
                                        if (Boolean.valueOf(this.JTResultado1.getValueAt(z2, 4).toString()).booleanValue() && parts2[i].equals(this.xmodelo1.getValueAt(z2, 7).toString())) {
                                            this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado,`Id_Tercero`,Valor,Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xmodelo1.getValueAt(z2, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "','" + this.xmodelo1.getValueAt(z2, 3).toString() + "','" + PP_Concepto + xid + "');";
                                            System.out.println("Detalle Movimiento Presupuesto --> " + this.xsql);
                                            this.xct.ejecutarSQL(this.xsql);
                                            this.xct.cerrarConexionBd();
                                        }
                                    }
                                    i++;
                                }
                            } else {
                                for (int z3 = 0; z3 < this.JTResultado1.getRowCount(); z3++) {
                                    System.out.println("Pos 4: " + this.JTResultado1.getValueAt(z3, 4).toString() + ", Pos 19: " + this.xmodelo.getValueAt(y2, 19).toString() + ", Pos 7: " + this.xmodelo1.getValueAt(z3, 7).toString());
                                    if (Boolean.valueOf(this.JTResultado1.getValueAt(z3, 4).toString()).booleanValue() && this.xmodelo.getValueAt(y2, 19).toString().equals(this.xmodelo1.getValueAt(z3, 7).toString())) {
                                        this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado,`Id_Tercero`,Valor,Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xmodelo1.getValueAt(z3, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(y2, 9).toString() + "','" + this.xmodelo1.getValueAt(z3, 3).toString() + "','" + PP_Concepto + xid + "');";
                                        System.out.println("Detalle Movimiento Presupuesto --> " + this.xsql);
                                        this.xct.ejecutarSQL(this.xsql);
                                        this.xct.cerrarConexionBd();
                                    }
                                }
                            }
                        }
                        if (this.JRBCheque.isSelected()) {
                        }
                    }
                }
            }
            if (this.JRBSDisfon.isSelected()) {
                JIFGeneracionDisfon xjifgeneraciondisfon = new JIFGeneracionDisfon();
                Principal.cargarPantalla(xjifgeneraciondisfon);
                mNuevo();
            } else {
                mNuevo();
            }
            mCrearTabla();
            mCrearTablaDistribucionPPT();
        }
    }

    private Long crearDocumentoContable() {
        new Long(0L);
        String sql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC,NConsecutivo, Id_Nomina, TipoPago, NCheque, Id_CuentaEmpresa, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc_cont[this.JCBTipoDoc_Cont.getSelectedIndex()] + "','" + this.xidperiodo_cont[this.JCBPeriodo_Cont.getSelectedIndex()] + "','" + this.xConsecutivo + "','0','" + this.xtipopago + "','" + this.JTFNCheque.getText() + "','" + this.xId_Banco + "','" + this.JTAObservacion.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Long idDocumento = Long.valueOf(this.xct.ejecutarSQLId(sql));
        this.xct.cerrarConexionBd();
        return idDocumento;
    }

    private void crearMovimientoDebito(int pos, String concepto) {
        String sql = "insert into  cc_detalle_documentoc (Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, NFactura, VDebito, VCredito,  `Id_Certificado`, Concepto) values('" + this.JTFFNDoc_Cont.getText() + "','" + this.xmodelo.getValueAt(pos, 7).toString() + "','" + this.xmodelo.getValueAt(pos, 9).toString() + "','" + this.xmodelo.getValueAt(pos, 5).toString() + "','" + this.xmodelo.getValueAt(pos, 3).toString() + "','" + this.xmodelo.getValueAt(pos, 18).toString() + "','0','" + this.xmodelo.getValueAt(pos, 25).toString() + "','" + concepto + "')";
        System.out.println(sql);
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    private void crearMovimientoCredito(int pos, String concepto, boolean forma) {
        Double valor;
        new Double(0.0d);
        if (forma) {
            valor = Double.valueOf(this.JTFFTotalizarR.getValue().toString());
        } else {
            valor = Double.valueOf(this.xmodelo.getValueAt(pos, 18).toString());
        }
        String sql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, NFactura, TipoCPuc, VDebito, VCredito, `Id_Certificado`, Concepto) values('" + this.JTFFNDoc_Cont.getText() + "','" + this.xidsubcuenta[this.JCBSubCuenta.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(pos, 9).toString() + "','" + this.xmodelo.getValueAt(pos, 5).toString() + "','" + this.xmodelo.getValueAt(pos, 3).toString() + "','1','0','" + valor + "','" + this.xmodelo.getValueAt(pos, 25).toString() + "','" + concepto + "')";
        System.out.println(sql);
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    private void crearMovimientoPresupuestal(int pos, String concepto) {
        this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,NoConcecutivo,`Observacion`,IdCompromiso, IdDocContable,IdObligacion,Id_Nomina, IdUsuarioR,`UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xConsecutivoP + "','" + this.JTAObservacion.getText() + " COMPROBANTE DE EGRESO N° " + this.JTFFNDoc_Cont.getText() + "','" + this.xmodelo.getValueAt(pos, 19).toString() + "','" + this.JTFFNDoc_Cont.getText() + "','" + this.xmodelo.getValueAt(pos, 21).toString() + "','0','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
        System.out.println("Inserta Encabezado -->" + this.xsql);
        this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
    }

    private void crearMovimientoDetallePresupuesto(int pos, String concepto) {
        for (int z = 0; z < this.JTResultado1.getRowCount(); z++) {
            if (this.JTResultado1.getValueAt(z, 8).toString().equals(this.JTResultado.getValueAt(pos, 21).toString()) && !Boolean.valueOf(this.JTResultado1.getValueAt(z, 9).toString()).booleanValue()) {
                this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado, `Id_Tercero`,Valor,Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xmodelo1.getValueAt(z, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(pos, 9).toString() + "','" + this.xmodelo1.getValueAt(z, 3).toString() + "','" + concepto + this.JTF_NComprobante.getText() + "');";
                System.out.println("Detalle Movimiento Presupuesto --> " + this.xsql);
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.JTResultado1.setValueAt(true, z, 9);
            }
        }
    }

    private void crearMovimientoDetallePresupuestoUnico(int pos, String concepto, int posDetalle) {
        this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado, `Id_Tercero`,Valor,Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xmodelo1.getValueAt(posDetalle, 0).toString() + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xmodelo.getValueAt(pos, 9).toString() + "','" + this.xmodelo1.getValueAt(posDetalle, 3).toString() + "','" + concepto + this.JTF_NComprobante.getText() + "');";
        System.out.println("Detalle Movimiento Presupuesto --> " + this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.JTResultado1.setValueAt(true, posDetalle, 9);
    }

    private void springStart() {
        new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).close();
    }

    public void mNuevo() {
        this.xlleno = false;
        this.xId_Banco = "0";
        this.xIdNomina = 0L;
        this.JCB_CuentaBancaria.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xsql = "SELECT\n  `cc_cuentaxempresa`.`Id`,\n  CONCAT(\n    `cc_banco`.`Nbre`,\n    ' Cuenta N° ',\n    `cc_cuentaxempresa`.`NCuenta`,\n    ' ',\n    `cc_tipo_cuenta`.`Nbre`\n  ) AS `Cuenta`,\n `cc_cuentaxempresa`.`ACheque`,\n  `cc_cuentaxempresa`.`NInicio`,\n  `cc_cuentaxempresa`.`ConsecutivoA`\nFROM\n  `g_empresa`\n  INNER JOIN `cc_cuentaxempresa`\n    ON (\n      `cc_cuentaxempresa`.`Id_Empresa` = `g_empresa`.`Id`\n    )\n  INNER JOIN `cc_bancoxsucursal`\n    ON (\n     `cc_cuentaxempresa`.`Id_SucursalxBanco` = `cc_bancoxsucursal`.`Id`\n    )\n  INNER JOIN `cc_banco`\n    ON (\n      `cc_bancoxsucursal`.`Id_Banco` = `cc_banco`.`Id`\n    )\n  INNER JOIN `cc_tipo_cuenta`\n    ON (\n      `cc_cuentaxempresa`.`Id_TipoCuenta` = `cc_tipo_cuenta`.`Id`\n    )\nWHERE (`cc_cuentaxempresa`.`Estado` = 1)\nORDER BY `cc_cuentaxempresa`.`EsPrincipal` DESC";
        this.xId_CuentasB = this.xct.llenarComboyLista(this.xsql, this.xId_CuentasB, this.JCB_CuentaBancaria, 5);
        this.JCB_CuentaBancaria.setSelectedIndex(-1);
        this.JDFFechaPP.setDate(this.xmt.getFechaActual());
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCH_Agrupado.setSelected(false);
        this.JTF_NComprobante.setEditable(false);
        this.JCHEnviarCorreo.setSelected(false);
        this.JTAObservacion.setText("");
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        mNuevo_DContabilidad();
        mNuevo_DPpt();
        mCrearTablaDistribucionPPT();
        mCrearTabla();
        this.xlleno = true;
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha Radicación", "Tercero", "NFactura", "Neto a Pagar", "IdRadicado", "Generar", "CuentaPuc", "Nombre", "Id Empresa", "NotaCredito", "IdNC", "ValorDescontarNc", "Correo", "Cometario", "Rubro", "Valor_Rubro", "N° Comprobante", "Valor a Pagar", "Id_Compromiso", "Id_ConceptoCN", "Id_Obligacion", "NDías", "NUnidadF", "Id_PersonaC", "Id_CGestion", "IdConceptoNConsulta", "IdCompromisos", "IdObligaciones", "IdDocumentos"}) { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.27
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Long.class, Boolean.class, String.class, String.class, String.class, Integer.class, Integer.class, Double.class, String.class, String.class, String.class, Double.class, Long.class, Double.class, Long.class, String.class, Long.class, Long.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(300);
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
        this.JTResultado.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(21).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(23).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(26).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(29).setPreferredWidth(100);
    }

    private void mCrearTablaDistribucionPPT() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Rubro", "Nombre", "Neto", "Valor a Pagar", "Aplica", "Id_Documento", "Id_Disponibilidad", "Id_Compromiso", "Id_Obligacion", "Grabado"}) { // from class: com.genoma.plus.controller.contabilidad.JIFPagoNominaC.28
            Class[] types = {String.class, String.class, Double.class, Double.class, Boolean.class, Long.class, Long.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado1.setModel(this.xmodelo1);
        this.JTResultado1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTResultado1.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTResultado1.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTResultado1.getColumnModel().getColumn(9).setPreferredWidth(30);
    }

    private void mCargarDatos(int xForma) {
        String sql = null;
        mCrearTabla();
        if (xForma == 0) {
            if (this.JCH_Agrupado1.isSelected()) {
                sql = "SELECT \nd.Id \n, d.FechaD \n, d.RazonSocialCompleta \n, d.Id_Nomina  \n, SUM(d.valor) valor\n, d.comidin\n, d.IdPuc\n, d.NPuc\n, d.IdTercero\n, d.Correo \n, d.Concepto \n , d.RPresupuestal  \n , d.Comodin1\n , d.IdCompromiso\n ,d.Id_ConceptoN\n , d.IdObligacion\n , d.NDias \n , d.Id_DocContableE\n , d.UnidadF\n , d.Id_PersonaC\n , GROUP_CONCAT(DISTINCT d.IdConceptoNC)IdConceptoNC  \n , GROUP_CONCAT(DISTINCT d.IdCompromiso) IdCompromisoC\n , GROUP_CONCAT(DISTINCT d.IdObligacion) IdObligacionC   \n , GROUP_CONCAT(DISTINCT d.Id) IdDocContable   \n , d.Id_Certificado \n\nFROM (\nSELECT \ncc_documentoc.Id \n, cc_documentoc.FechaD \n, cc_terceros.RazonSocialCompleta \n, cc_documentoc.Id_Nomina  \n, SUM(DISTINCT cc_detalle_documentoc.VCredito)  valor\n, 0 comidin\n, cc_puc.Id IdPuc\n, cc_puc.Nbre  NPuc\n, cc_terceros.Id IdTercero\n, cc_terceros.Correo ,\n cc_detalle_documentoc.Concepto \n , IF(rh_nomina_liquidacion_detalle.RPresupuestal='',rh_nomina_concepto_unidadf.RPresupuesto,rh_nomina_liquidacion_detalle.RPresupuestal) RPresupuestal  \n , 0   Comodin1\n , rh_nomina_liquidacion_detalle.Id_Compromiso AS IdCompromiso\n ,GROUP_CONCAT(DISTINCT rh_nomina_liquidacion_detalle.Id_ConceptoCN SEPARATOR ',') AS Id_ConceptoN\n , rh_nomina_liquidacion_detalle.Id_Obligacion AS IdObligacion\n ,   DATEDIFF(NOW(),cc_documentoc.FechaD) NDias \n , rh_nomina_liquidacion_detalle.Id_DocContableE\n , cc_unidad_funcional.Nbre  UnidadF\n , rh_nomina_liquidacion_detalle.Id_PersonaC\n ,GROUP_CONCAT(DISTINCT rh_nomina_liquidacion_detalle.Id_ConceptoCN SEPARATOR ',') AS IdConceptoNC     \n ,   cc_detalle_documentoc.Id_Certificado \nFROM\n\n     cc_detalle_documentoc\n\n    INNER JOIN  cc_documentoc \n\n        ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\n\n    INNER JOIN  rh_nomina_liquidacion_detalle \n\n        ON (rh_nomina_liquidacion_detalle.Id_Liquidacion = cc_documentoc.Id_Nomina) AND (rh_nomina_liquidacion_detalle.Id_Tercero = cc_detalle_documentoc.Id_Tercero) AND (rh_nomina_liquidacion_detalle.Id_DocContable = cc_detalle_documentoc.Id_Documentoc)\n\n    INNER JOIN  rh_nomina_concepto_unidadf \n\n        ON (rh_nomina_liquidacion_detalle.CCredito = cc_detalle_documentoc.Id_Puc) AND (rh_nomina_liquidacion_detalle.Id_ConceptoCN = rh_nomina_concepto_unidadf.Id)\n\n    INNER JOIN  rh_tipo_persona_cargon \n\n        ON (rh_nomina_liquidacion_detalle.Id_PersonaC = rh_tipo_persona_cargon.Id)\n\n    INNER JOIN  rh_nomina_conceptos \n\n        ON (rh_nomina_concepto_unidadf.Id_ConceptosN = rh_nomina_conceptos.Id) -- AND (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_nomina_concepto_unidadf.Id_UnidaFC)\n\n    left JOIN  cc_unidad_funcional \n\n        ON (rh_tipo_persona_cargon.Id_unidadf_cargo = cc_unidad_funcional.Id)\n\n    INNER JOIN  rh_tipo_clasificacion_conceptonomina \n\n        ON (rh_tipo_clasificacion_conceptonomina.Id = rh_nomina_conceptos.Id_Clasificacion)\n\n    INNER JOIN  cc_terceros \n\n        ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero)\n\n    INNER JOIN  cc_puc \n\n        ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id)\n\nINNER JOIN  rh_nomina_liquidacion\n\nON (rh_nomina_liquidacion.Id = rh_nomina_liquidacion_detalle.Id_Liquidacion) LEFT JOIN (SELECT\n\n    cc_documentoc.Id_Nomina\n\n    , SUM(cc_detalle_documentoc.VDebito) AS Valor\n\n    , cc_detalle_documentoc.Id_Tercero\n\n    , cc_detalle_documentoc.Id_ConceptoN\n\nFROM\n\n     cc_detalle_documentoc\n\n    INNER JOIN  cc_documentoc \n\n        ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\n\n    INNER JOIN  cc_tipo_documentoc \n\n        ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)\n\nWHERE (cc_tipo_documentoc.EsEgreso =1 AND cc_documentoc.Estado=1 \n\n  ) GROUP BY cc_detalle_documentoc.Id_Tercero, cc_detalle_documentoc.Id_ConceptoN, cc_documentoc.Id_Nomina)  d  ON (d.Id_Nomina =cc_documentoc.Id_Nomina) \n\n    AND (d.Id_Tercero = rh_nomina_liquidacion_detalle.Id_PersonaC) AND (d.Id_ConceptoN =rh_nomina_liquidacion_detalle.Id_ConceptoCN)  \n WHERE (( cc_terceros.RazonSocialCompleta LIKE '" + this.JTFBusqueda.getText() + "%' ||  cc_terceros.No_identificacion LIKE'" + this.JTFBusqueda.getText() + "%' ) AND rh_nomina_liquidacion.FechaR >='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND rh_nomina_liquidacion.FechaR <='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "' AND cc_documentoc.Estado=1  AND rh_nomina_conceptos.Id_Clasificacion ='" + this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()] + "' AND rh_tipo_clasificacion_conceptonomina.EsContable =0)\n\n GROUP BY cc_documentoc.Id_Nomina, cc_puc.Id, cc_terceros.Id, cc_documentoc.Id  \n\n HAVING  rh_nomina_liquidacion_detalle.Id_DocContableE=0  ORDER BY cc_unidad_funcional.Nbre , cc_terceros.RazonSocial,   rh_tipo_clasificacion_conceptonomina.Nbre ASC\n) d\n\nGROUP BY  d.IdTercero, d.Id_ConceptoN \nORDER BY d.RazonSocialCompleta  ASC";
            } else {
                sql = "SELECT cc_documentoc.Id , cc_documentoc.FechaD , cc_terceros.RazonSocialCompleta , cc_documentoc.Id_Nomina  , SUM(DISTINCT cc_detalle_documentoc.VCredito)  , 0 , cc_puc.Id , cc_puc.Nbre , cc_terceros.Id\n, cc_terceros.Correo , cc_detalle_documentoc.Concepto , IF(rh_nomina_liquidacion_detalle.RPresupuestal='',rh_nomina_concepto_unidadf.RPresupuesto,rh_nomina_liquidacion_detalle.RPresupuestal) RPresupuestal  , 0  , rh_nomina_liquidacion_detalle.Id_Compromiso AS IdCompromiso,GROUP_CONCAT(DISTINCT rh_nomina_liquidacion_detalle.Id_ConceptoCN SEPARATOR ',') AS Id_ConceptoN, rh_nomina_liquidacion_detalle.Id_Obligacion AS IdObligacion,   DATEDIFF(NOW(),cc_documentoc.FechaD) NDias , rh_nomina_liquidacion_detalle.Id_DocContableE, cc_unidad_funcional.Nbre  UnidadF, rh_nomina_liquidacion_detalle.Id_PersonaC, GROUP_CONCAT(DISTINCT rh_nomina_liquidacion_detalle.Id_ConceptoCN SEPARATOR ',') AS IdConceptoNC, '' IdCompromisoC, '' IdObligacionC, '' IdDocContable      \n , cc_detalle_documentoc.Id_Certificado \nFROM\n     cc_detalle_documentoc\n    INNER JOIN  cc_documentoc \n        ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\n    INNER JOIN  rh_nomina_liquidacion_detalle \n        ON (rh_nomina_liquidacion_detalle.Id_Liquidacion = cc_documentoc.Id_Nomina) AND (rh_nomina_liquidacion_detalle.Id_Tercero = cc_detalle_documentoc.Id_Tercero) AND (rh_nomina_liquidacion_detalle.Id_DocContable = cc_detalle_documentoc.Id_Documentoc)\n    INNER JOIN  rh_nomina_concepto_unidadf \n        ON (rh_nomina_liquidacion_detalle.CCredito = cc_detalle_documentoc.Id_Puc) AND (rh_nomina_liquidacion_detalle.Id_ConceptoCN = rh_nomina_concepto_unidadf.Id)\n    INNER JOIN  rh_tipo_persona_cargon \n        ON (rh_nomina_liquidacion_detalle.Id_PersonaC = rh_tipo_persona_cargon.Id)\n    INNER JOIN  rh_nomina_conceptos \n        ON (rh_nomina_concepto_unidadf.Id_ConceptosN = rh_nomina_conceptos.Id) -- AND (rh_tipo_persona_cargon.Id_Unidadf_cargo = rh_nomina_concepto_unidadf.Id_UnidaFC)\n    left JOIN  cc_unidad_funcional \n        ON (rh_tipo_persona_cargon.Id_Unidadf_cargo = cc_unidad_funcional.Id)\n    INNER JOIN  rh_tipo_clasificacion_conceptonomina \n        ON (rh_tipo_clasificacion_conceptonomina.Id = rh_nomina_conceptos.Id_Clasificacion)\n    INNER JOIN  cc_terceros \n        ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero)\n    INNER JOIN  cc_puc \n        ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id)\nINNER JOIN  rh_nomina_liquidacion\nON (rh_nomina_liquidacion.Id = rh_nomina_liquidacion_detalle.Id_Liquidacion) LEFT JOIN (SELECT\n    cc_documentoc.Id_Nomina\n    , SUM(cc_detalle_documentoc.VDebito) AS Valor\n    , cc_detalle_documentoc.Id_Tercero\n    , cc_detalle_documentoc.Id_ConceptoN\nFROM\n     cc_detalle_documentoc\n    INNER JOIN  cc_documentoc \n        ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\n    INNER JOIN  cc_tipo_documentoc \n        ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)\nWHERE (cc_tipo_documentoc.EsEgreso =1 AND cc_documentoc.Estado=1 \n  ) GROUP BY cc_detalle_documentoc.Id_Tercero, cc_detalle_documentoc.Id_ConceptoN, cc_documentoc.Id_Nomina)  d  ON (d.Id_Nomina =cc_documentoc.Id_Nomina) \n    AND (d.Id_Tercero = rh_nomina_liquidacion_detalle.Id_PersonaC) AND (d.Id_ConceptoN =rh_nomina_liquidacion_detalle.Id_ConceptoCN)  WHERE (( cc_terceros.RazonSocialCompleta LIKE'" + this.JTFBusqueda.getText() + "%' ||  cc_terceros.No_identificacion LIKE'" + this.JTFBusqueda.getText() + "%' ) AND rh_nomina_liquidacion.FechaR >='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "' AND rh_nomina_liquidacion.FechaR <='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "' AND cc_documentoc.Estado=1  AND rh_nomina_conceptos.Id_Clasificacion ='" + this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()] + "' AND rh_tipo_clasificacion_conceptonomina.EsContable =0)\n GROUP BY cc_documentoc.Id_Nomina, cc_puc.Id, cc_terceros.Id, cc_documentoc.Id  \n HAVING  rh_nomina_liquidacion_detalle.Id_DocContableE=0  ORDER BY cc_unidad_funcional.Nbre , cc_terceros.RazonSocialCompleta,   rh_tipo_clasificacion_conceptonomina.Nbre ASC";
            }
        } else if (xForma == 1) {
            if (this.JCH_Agrupado1.isSelected()) {
                sql = "SELECT\n  d.`Id`,\n  d.`FechaD`,\n  d.`RazonSocialCompleta`,\n  d.`Id_Nomina`,\n  SUM(d.valor) valor,\n  d.comidin,\n  d.IdPuc,\n  d.NPuc,\n  d.IdTercero,\n  d.`Correo`,\n  d.`Concepto`,\n  d.RPresupuestal,\n  d.Comodin1,\n  d.IdCompromiso,\n  d.Id_ConceptoN,\n  d.IdObligacion,\n  d.NDias,\n  d.`Id_DocContableE`,\n  d.UnidadF,\n  d.Id_PersonaC,\n  d.`Id_Certificado`,\n  GROUP_CONCAT(DISTINCT d.IdConceptoNC) IdConceptoNC,\n  GROUP_CONCAT(DISTINCT d.IdCompromiso) IdCompromisoC,\n  GROUP_CONCAT(DISTINCT d.IdObligacion) IdObligacionC,\n  GROUP_CONCAT(DISTINCT d.`Id`) IdDocContable\nFROM\n  (SELECT\n    `cc_documentoc`.`Id`,\n    `cc_documentoc`.`FechaD`,\n    `cc_terceros`.`RazonSocialCompleta`,\n    `cc_documentoc`.`Id_Nomina`,\n    SUM(\n      DISTINCT `cc_detalle_documentoc`.`VCredito`\n    ) valor,\n    0 comidin,\n    `cc_puc`.`Id` IdPuc,\n    `cc_puc`.`Nbre` NPuc,\n    `cc_terceros`.`Id` IdTercero,\n    `cc_terceros`.`Correo`,\n    `cc_detalle_documentoc`.`Concepto`,\n    IF(\n      rh_nomina_liquidacion_detalle.`RPresupuestal` = '',\n      `rh_nomina_concepto_unidadf`.`RPresupuesto`,\n      rh_nomina_liquidacion_detalle.`RPresupuestal`\n    ) RPresupuestal,\n    0 Comodin1,\n    `rh_nomina_liquidacion_detalle`.`Id_Compromiso` AS IdCompromiso,\n    GROUP_CONCAT(\n      DISTINCT rh_nomina_liquidacion_detalle.Id_ConceptoCN SEPARATOR ','\n    ) AS Id_ConceptoN,\n    `rh_nomina_liquidacion_detalle`.`Id_Obligacion` AS IdObligacion,\n    DATEDIFF(NOW(), `cc_documentoc`.`FechaD`) NDias,\n    rh_nomina_liquidacion_detalle.`Id_DocContableE`,\n    `cc_unidad_funcional`.`Nbre` UnidadF,\n    rh_nomina_liquidacion_detalle.Id_PersonaC,\n    cc_detalle_documentoc.`Id_Certificado`,\n    GROUP_CONCAT(\n      DISTINCT rh_nomina_liquidacion_detalle.Id_ConceptoCN SEPARATOR ','\n    ) AS IdConceptoNC\n  FROM\n    `cc_detalle_documentoc`\n    INNER JOIN `cc_documentoc`\n      ON (\n        `cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`\n      )\n    INNER JOIN `rh_nomina_liquidacion_detalle`\n      ON (\n        `rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `cc_documentoc`.`Id_Nomina`\n      )\n      AND (\n        `rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_detalle_documentoc`.`Id_Tercero`\n      )\n      AND (\n        `rh_nomina_liquidacion_detalle`.`Id_DocContable` = `cc_detalle_documentoc`.`Id_Documentoc`\n      )\n    INNER JOIN `rh_nomina_concepto_unidadf`\n      ON (\n        `rh_nomina_liquidacion_detalle`.`CCredito` = `cc_detalle_documentoc`.`Id_Puc`\n      )\n      AND (\n        `rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`\n      )\n    INNER JOIN `rh_tipo_persona_cargon`\n      ON (\n        `rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`\n      )\n    INNER JOIN `rh_nomina_conceptos`\n      ON (\n        `rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`\n      ) -- AND (`rh_tercero_tipocargo`.`Id_UnidadF` = `rh_nomina_concepto_unidadf`.`Id_UnidaFC`)\n     INNER JOIN `rh_nomina_persona_unidadf`\n      ON (\n        `rh_tipo_persona_cargon`.`Id` = `rh_nomina_persona_unidadf`.`Id_personaCargo`\n      )\n    left JOIN `cc_unidad_funcional`\n      ON (\n        `rh_nomina_persona_unidadf`.`Id_UnidadF` = `cc_unidad_funcional`.`Id`\n      )\n    INNER JOIN `rh_tipo_clasificacion_conceptonomina`\n      ON (\n        `rh_tipo_clasificacion_conceptonomina`.`Id` = `rh_nomina_conceptos`.`Id_Clasificacion`\n      )\n    INNER JOIN `cc_terceros`\n      ON (\n        `cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`\n      )\n    INNER JOIN `cc_puc`\n      ON (\n        `cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`\n      )\n    INNER JOIN `rh_nomina_liquidacion`\n      ON (\n        `rh_nomina_liquidacion`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Liquidacion`\n      )\n    LEFT JOIN\n      (SELECT\n        `cc_documentoc`.`Id_Nomina`,\n        SUM(\n          `cc_detalle_documentoc`.`VDebito`\n        ) AS `Valor`,\n        `cc_detalle_documentoc`.`Id_Tercero`,\n        `cc_detalle_documentoc`.`Id_ConceptoN`\n      FROM\n        `cc_detalle_documentoc`\n        INNER JOIN `cc_documentoc`\n          ON (\n            `cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`\n          )\n        INNER JOIN `cc_tipo_documentoc`\n          ON (\n            `cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`\n          )\n      WHERE (\n          `cc_tipo_documentoc`.`EsEgreso` = 1\n          AND cc_documentoc.`Estado` = 1\n        )\n      GROUP BY `cc_detalle_documentoc`.`Id_Tercero`,\n        `cc_detalle_documentoc`.`Id_ConceptoN`,\n        `cc_documentoc`.`Id_Nomina`) d\n      ON (\n        `d`.`Id_Nomina` = `cc_documentoc`.`Id_Nomina`\n      )\n      AND (\n        `d`.`Id_Tercero` = rh_nomina_liquidacion_detalle.Id_PersonaC\n      )\n      AND (\n        `d`.`Id_ConceptoN` = rh_nomina_liquidacion_detalle.Id_ConceptoCN\n      )\n  WHERE (\n      (\n        cc_terceros.`RazonSocialCompleta` LIKE '" + this.JTFBusqueda.getText() + "%' || cc_terceros.`No_identificacion` LIKE '" + this.JTFBusqueda.getText() + "%'\n      )\n      AND `rh_nomina_liquidacion`.`FechaR` >= '" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "'\n      AND `rh_nomina_liquidacion`.`FechaR` <= '" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "'\n      AND cc_documentoc.`Estado` = 1\n      AND `rh_nomina_conceptos`.`Id` = '" + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + "'\n      AND `rh_tipo_clasificacion_conceptonomina`.`EsContable` = 0\n    )\n  GROUP BY `cc_documentoc`.`Id_Nomina`,\n    `cc_puc`.`Id`,\n    `cc_terceros`.`Id`,\n    cc_documentoc.Id\n  HAVING rh_nomina_liquidacion_detalle.`Id_DocContableE` = 0\n  ORDER BY `cc_unidad_funcional`.`Nbre`,\n    cc_terceros.`RazonSocialCompleta`,\n    `rh_tipo_clasificacion_conceptonomina`.`Nbre` ASC) d\nGROUP BY d.IdTercero\nORDER BY d.`RazonSocialCompleta` ASC";
            } else {
                sql = "SELECT\n  `cc_documentoc`.`Id`,\n  `cc_documentoc`.`FechaD`,\n  `cc_terceros`.`RazonSocialCompleta` ,\n  `cc_documentoc`.`Id_Nomina`,\n  SUM(\n    DISTINCT `cc_detalle_documentoc`.`VCredito`\n  ),\n  0,\n  `cc_puc`.`Id`,\n  `cc_puc`.`Nbre`,\n  `cc_terceros`.`Id`,\n  `cc_terceros`.`Correo`,\n  `cc_detalle_documentoc`.`Concepto`,\n  IF(\n    rh_nomina_liquidacion_detalle.`RPresupuestal` = '',\n    `rh_nomina_concepto_unidadf`.`RPresupuesto`,\n    rh_nomina_liquidacion_detalle.`RPresupuestal`\n  ) RPresupuestal,\n  0,\n  `rh_nomina_liquidacion_detalle`.`Id_Compromiso` AS IdCompromiso,\n  GROUP_CONCAT(\n    DISTINCT rh_nomina_liquidacion_detalle.Id_ConceptoCN SEPARATOR ','\n  ) AS Id_ConceptoN,\n  `rh_nomina_liquidacion_detalle`.`Id_Obligacion` AS IdObligacion,\n  DATEDIFF(NOW(), `cc_documentoc`.`FechaD`) NDias,\n  rh_nomina_liquidacion_detalle.`Id_DocContableE`,\n `cc_unidad_funcional`.`Nbre` UnidadF,\n  rh_nomina_liquidacion_detalle.Id_PersonaC,\n  cc_detalle_documentoc.`Id_Certificado`,\n  GROUP_CONCAT(\n    DISTINCT rh_nomina_liquidacion_detalle.Id_ConceptoCN SEPARATOR ','\n  ) AS IdConceptoNC,\n  '' IdCompromisoC,\n  '' IdObligacionC,\n  '' IdDocContable\nFROM\n  `cc_detalle_documentoc`\n  INNER JOIN `cc_documentoc`\n    ON (\n      `cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`\n    )\n  INNER JOIN `rh_nomina_liquidacion_detalle`\n    ON (\n      `rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `cc_documentoc`.`Id_Nomina`\n    )\n    AND (\n      `rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_detalle_documentoc`.`Id_Tercero`\n    )\n    AND (\n      `rh_nomina_liquidacion_detalle`.`Id_DocContable` = `cc_detalle_documentoc`.`Id_Documentoc`\n    )\n  INNER JOIN `rh_nomina_concepto_unidadf`\n    ON (\n      `rh_nomina_liquidacion_detalle`.`CCredito` = `cc_detalle_documentoc`.`Id_Puc`\n    )\n    AND (\n      `rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`\n    )\n  INNER JOIN `rh_tipo_persona_cargon`\n    ON (\n      `rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`\n    )\n  INNER JOIN `rh_nomina_conceptos`\n    ON (\n      `rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`\n    )\n   left JOIN `cc_unidad_funcional`\n    ON (\n      `rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `cc_unidad_funcional`.`Id`\n    )\n  INNER JOIN `rh_tipo_clasificacion_conceptonomina`\n    ON (\n      `rh_tipo_clasificacion_conceptonomina`.`Id` = `rh_nomina_conceptos`.`Id_Clasificacion`\n    )\n  INNER JOIN `cc_terceros`\n    ON (\n      `cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`\n    )\n  INNER JOIN `cc_puc`\n    ON (\n      `cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`\n    )\n  INNER JOIN `rh_nomina_liquidacion`\n    ON (\n      `rh_nomina_liquidacion`.`Id` = `rh_nomina_liquidacion_detalle`.`Id_Liquidacion`\n    )\n  LEFT JOIN\n    (SELECT\n      `cc_documentoc`.`Id_Nomina`,\n      SUM(\n        `cc_detalle_documentoc`.`VDebito`\n      ) AS `Valor`,\n      `cc_detalle_documentoc`.`Id_Tercero`,\n      `cc_detalle_documentoc`.`Id_ConceptoN`\n    FROM\n      `cc_detalle_documentoc`\n      INNER JOIN `cc_documentoc`\n        ON (\n          `cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`\n        )\n      INNER JOIN `cc_tipo_documentoc`\n        ON (\n          `cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`\n        )\n    WHERE (\n        `cc_tipo_documentoc`.`EsEgreso` = 1\n        AND cc_documentoc.`Estado` = 1\n      )\n    GROUP BY `cc_detalle_documentoc`.`Id_Tercero`,\n      `cc_detalle_documentoc`.`Id_ConceptoN`,\n      `cc_documentoc`.`Id_Nomina`) d\n    ON (\n      `d`.`Id_Nomina` = `cc_documentoc`.`Id_Nomina`\n    )\n    AND (\n      `d`.`Id_Tercero` = rh_nomina_liquidacion_detalle.Id_PersonaC\n    )\n    AND (\n      `d`.`Id_ConceptoN` = rh_nomina_liquidacion_detalle.Id_ConceptoCN\n    )\nWHERE (\n    (\n      cc_terceros.`RazonSocialCompleta` LIKE '" + this.JTFBusqueda.getText().trim() + "%' || cc_terceros.`No_identificacion` LIKE '" + this.JTFBusqueda.getText() + "%'\n    )\n    AND `rh_nomina_liquidacion`.`FechaR` >= '" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "'\n    AND `rh_nomina_liquidacion`.`FechaR` <= '" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "'\n    AND cc_documentoc.`Estado` = 1\n    AND `rh_nomina_conceptos`.`Id` = " + this.xId_ConceptoN[this.JCB_NConcepto.getSelectedIndex()] + " \n    AND `rh_tipo_clasificacion_conceptonomina`.`EsContable` = 0\n  )\nGROUP BY `cc_documentoc`.`Id_Nomina`,\n  `cc_puc`.`Id`,\n  `cc_terceros`.`Id`,\n  cc_documentoc.Id\nHAVING rh_nomina_liquidacion_detalle.`Id_DocContableE` = 0\nORDER BY `cc_unidad_funcional`.`Nbre`,\n  cc_terceros.`RazonSocialCompleta`,\n  `rh_tipo_clasificacion_conceptonomina`.`Nbre` ASC";
            }
        }
        System.out.println(" Buscar : " + sql);
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                mConcecutivo();
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
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id_Certificado")), x, 25);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("NDias")), x, 22);
                    this.xmodelo.setValueAt(rs.getString("UnidadF"), x, 23);
                    this.xmodelo.setValueAt(rs.getString("Id_PersonaC"), x, 24);
                    this.xmodelo.setValueAt(rs.getString("IdConceptoNC"), x, 26);
                    this.xmodelo.setValueAt(rs.getString("IdCompromisoC"), x, 27);
                    this.xmodelo.setValueAt(rs.getString("IdObligacionC"), x, 28);
                    this.xmodelo.setValueAt(rs.getString("IdDocContable"), x, 29);
                    this.xmodelo.setValueAt(rs.getString("Id_ConceptoN"), x, 20);
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
                    this.xmodelo.setValueAt(0, x, 10);
                    this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodelo.setValueAt(0, x, 11);
                    this.xmodelo.setValueAt(0, x, 12);
                    this.xct.cerrarConexionBd();
                    x++;
                    xconsec++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            mTotalizarReembolso();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos_DistribucionPPT(String xIdObligacion, String xNEmpresa, String xIdConceptoN) {
        System.out.println(xIdConceptoN);
        mCrearTablaDistribucionPPT();
        String sql = "SELECT\n    `pp_rubros`.`Id` , `pp_rubros`.`Nbre` , rh_nomina_liquidacion_detalle.`TValorE`,  rh_nomina_liquidacion_detalle.`TValorE`,TRUE,  `rh_nomina_liquidacion_detalle`.`Id_DocContable` \n    , 0 , `rh_nomina_liquidacion_detalle`.`Id_Compromiso`,`rh_nomina_liquidacion_detalle`.Id_Obligacion\n    FROM\n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `pp_rubros` \n        ON (`pp_rubros`.`Id` = `rh_nomina_liquidacion_detalle`.`RPresupuestal`)\nWHERE (`rh_nomina_liquidacion_detalle`.`Id_Obligacion` in(" + xIdObligacion.substring(1, xIdObligacion.length()) + ")\n    AND `rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` in(" + xIdConceptoN.substring(1, xIdConceptoN.length()) + ")\n    AND `rh_nomina_liquidacion_detalle`.`Id_DocContableE` =0\n    AND `pp_rubros`.`idEncabezadoRubro` ='" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "'  AND  `rh_nomina_liquidacion_detalle`.`Id_Tercero` in(" + xNEmpresa.substring(1, xNEmpresa.length()) + ") )";
        if (sql != null) {
            System.out.println(" Buscar : " + sql);
            ResultSet rs = this.xct.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 0;
                    while (rs.next()) {
                        this.xmodelo1.addRow(this.xdato);
                        this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                        this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                        this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                        this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                        this.xmodelo1.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(7)), x, 6);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(8)), x, 7);
                        this.xmodelo1.setValueAt(Long.valueOf(rs.getLong("Id_Obligacion")), x, 8);
                        this.xmodelo1.setValueAt(false, x, 9);
                        x++;
                    }
                } else {
                    mCrearTablaDistribucionPPT();
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFPagoNominaC$MiRender.class */
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
                String sql = "update m_cc_nota_credito_descuento set Id_Comprobante='" + Xid_Doc + "' where Id_DocumentoC='" + this.xmodelo.getValueAt(y, 0) + "' and Id_Comprobante =0";
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
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_FormatoCheques", mparametros);
        }
    }

    public void mBuscar() {
        if (this.JCBTipoDoc_Cont1.getSelectedIndex() != -1) {
            if (this.JCBTipoDoc_Cont.getSelectedIndex() != -1) {
                if (this.JCH_EsNomina.isSelected()) {
                    if (this.JCBClasificacion.getSelectedIndex() != -1) {
                        if (this.JCHFiltroConcepto.isSelected()) {
                            if (this.JCB_NConcepto.getSelectedIndex() != -1) {
                                mCargarDatos(1);
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de concepto", "VERIFICAR", 1);
                            this.JTP_Concepto.setSelectedIndex(1);
                            this.JCB_NConcepto.requestFocus();
                            return;
                        }
                        mCargarDatos(0);
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una nomina", "VERIFICAR", 1);
                    this.JTP_Concepto.setSelectedIndex(1);
                    this.JCBClasificacion.requestFocus();
                    return;
                }
                mCargarDatos(0);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de documento", "VERIFICAR", 1);
            this.JCBTipoDoc_Cont.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de documento a pagar", "VERIFICAR", 1);
        this.JCBTipoDoc_Cont1.requestFocus();
    }
}
