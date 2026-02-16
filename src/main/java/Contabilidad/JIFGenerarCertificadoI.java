package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGenerarCertificadoI.class */
public class JIFGenerarCertificadoI extends JInternalFrame {
    private String xsql;
    private DefaultTableModel xmodelo;
    private String[] xidperiodot;
    public String[] xidtipoimpuesto;
    public String[] xidempresa;
    public String[] xidcuenta;
    private String[][] xidpuc;
    private Object[] xdato;
    private JIFConsultarDatosV xjifconsultard;
    private String xnombre;
    private ButtonGroup JBGTipo;
    private JButton JBTAdicionar;
    private JComboBox JCBCconsignaR;
    private JComboBox JCBPeriodo;
    private JComboBox JCBPuc;
    public JComboBox JCBTercero;
    public JComboBox JCBTipoImpuesto;
    private JDateChooser JDFFechaC;
    private JPanel JPIConsulta;
    private JPanel JPIDatosP;
    private JPanel JPITotales;
    private JScrollPane JSPObservacion;
    private JSpinner JSPPBase;
    private JSpinner JSPPIva;
    private JScrollPane JSPResultado;
    private JTextPane JTAObservacion;
    private JFormattedTextField JTFFTotalBase;
    private JFormattedTextField JTFFTotalIva;
    private JFormattedTextField JTFFTotalRetencion;
    private JFormattedTextField JTFFVBase;
    private JFormattedTextField JTFFVIngreso;
    private JFormattedTextField JTFFVIva;
    private JFormattedTextField JTFFVRetencion;
    public JTable JTResultado;
    private JYearChooser JYCAno;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xnfila = 0;
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JIFGenerarCertificadoI() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPIDatosP = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JCBTipoImpuesto = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JCBPeriodo = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JPIConsulta = new JPanel();
        this.JSPPBase = new JSpinner();
        this.JTFFVBase = new JFormattedTextField();
        this.JTFFVRetencion = new JFormattedTextField();
        this.JBTAdicionar = new JButton();
        this.JTFFVIva = new JFormattedTextField();
        this.JSPPIva = new JSpinner();
        this.JTFFVIngreso = new JFormattedTextField();
        this.JCBPuc = new JComboBox();
        this.JCBCconsignaR = new JComboBox();
        this.JPITotales = new JPanel();
        this.JTFFTotalBase = new JFormattedTextField();
        this.JTFFTotalRetencion = new JFormattedTextField();
        this.JTFFTotalIva = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE CERTIFICADO MANUAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifgeneracioncertificadoman");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setRowHeight(20);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCertificadoI.1
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCertificadoI.this.JTResultadoKeyPressed(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 13));
        this.JCBTipoImpuesto.setFont(new Font("Arial", 1, 13));
        this.JCBTipoImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoImpuesto.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGenerarCertificadoI.2
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerarCertificadoI.this.JCBTipoImpuestoItemStateChanged(evt);
            }
        });
        this.JCBTercero.setFont(new Font("Arial", 1, 13));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 13));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCBPeriodo.setFont(new Font("Arial", 1, 13));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoImpuesto, -2, 254, -2).addGap(18, 18, 18).addComponent(this.JCBTercero, 0, -1, 32767)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JYCAno, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion))).addGap(10, 10, 10)));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaC, -2, -1, -2).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTercero, -2, 50, -2).addComponent(this.JCBTipoImpuesto, -2, 50, -2))).addGap(18, 18, 18).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPeriodo, -2, 50, -2).addComponent(this.JYCAno, -2, 51, -2).addComponent(this.JSPObservacion, -2, -1, -2)).addContainerGap()));
        this.JPIConsulta.setBorder(BorderFactory.createEtchedBorder());
        this.JSPPBase.setFont(new Font("Arial", 1, 13));
        this.JSPPBase.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPBase.setBorder(BorderFactory.createTitledBorder((Border) null, "% Base", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPBase.addChangeListener(new ChangeListener() { // from class: Contabilidad.JIFGenerarCertificadoI.3
            public void stateChanged(ChangeEvent evt) {
                JIFGenerarCertificadoI.this.JSPPBaseStateChanged(evt);
            }
        });
        this.JSPPBase.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCertificadoI.4
            public void focusLost(FocusEvent evt) {
                JIFGenerarCertificadoI.this.JSPPBaseFocusLost(evt);
            }
        });
        this.JTFFVBase.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Base", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVBase.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVBase.setHorizontalAlignment(4);
        this.JTFFVBase.setFont(new Font("Arial", 1, 13));
        this.JTFFVBase.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCertificadoI.5
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCertificadoI.this.JTFFVBaseActionPerformed(evt);
            }
        });
        this.JTFFVBase.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCertificadoI.6
            public void focusLost(FocusEvent evt) {
                JIFGenerarCertificadoI.this.JTFFVBaseFocusLost(evt);
            }
        });
        this.JTFFVBase.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCertificadoI.7
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCertificadoI.this.JTFFVBaseKeyPressed(evt);
            }
        });
        this.JTFFVRetencion.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Retención", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVRetencion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVRetencion.setHorizontalAlignment(4);
        this.JTFFVRetencion.setFont(new Font("Arial", 1, 13));
        this.JTFFVRetencion.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCertificadoI.8
            public void focusLost(FocusEvent evt) {
                JIFGenerarCertificadoI.this.JTFFVRetencionFocusLost(evt);
            }
        });
        this.JTFFVRetencion.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCertificadoI.9
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCertificadoI.this.JTFFVRetencionKeyPressed(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCertificadoI.10
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCertificadoI.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JTFFVIva.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVIva.setHorizontalAlignment(4);
        this.JTFFVIva.setFont(new Font("Arial", 1, 13));
        this.JTFFVIva.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCertificadoI.11
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCertificadoI.this.JTFFVIvaKeyPressed(evt);
            }
        });
        this.JSPPIva.setFont(new Font("Arial", 1, 13));
        this.JSPPIva.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPIva.setBorder(BorderFactory.createTitledBorder((Border) null, "% Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPIva.addChangeListener(new ChangeListener() { // from class: Contabilidad.JIFGenerarCertificadoI.12
            public void stateChanged(ChangeEvent evt) {
                JIFGenerarCertificadoI.this.JSPPIvaStateChanged(evt);
            }
        });
        this.JTFFVIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Ingresos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVIngreso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVIngreso.setHorizontalAlignment(4);
        this.JTFFVIngreso.setFont(new Font("Arial", 1, 13));
        this.JTFFVIngreso.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCertificadoI.13
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCertificadoI.this.JTFFVIngresoActionPerformed(evt);
            }
        });
        this.JTFFVIngreso.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFGenerarCertificadoI.14
            public void focusLost(FocusEvent evt) {
                JIFGenerarCertificadoI.this.JTFFVIngresoFocusLost(evt);
            }
        });
        this.JTFFVIngreso.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFGenerarCertificadoI.15
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCertificadoI.this.JTFFVIngresoKeyPressed(evt);
            }
        });
        this.JCBPuc.setFont(new Font("Arial", 1, 13));
        this.JCBPuc.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPuc.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGenerarCertificadoI.16
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerarCertificadoI.this.JCBPucItemStateChanged(evt);
            }
        });
        this.JCBCconsignaR.setFont(new Font("Arial", 1, 12));
        this.JCBCconsignaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta De donde Se Consignan Retencion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIConsultaLayout = new GroupLayout(this.JPIConsulta);
        this.JPIConsulta.setLayout(JPIConsultaLayout);
        JPIConsultaLayout.setHorizontalGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsultaLayout.createSequentialGroup().addComponent(this.JCBPuc, -2, 410, -2).addGap(15, 15, 15).addComponent(this.JSPPBase, -2, 73, -2).addGap(18, 18, 18).addComponent(this.JSPPIva, -2, 54, -2).addGap(9, 9, 9).addComponent(this.JTFFVIngreso, -2, 102, -2).addGap(9, 9, 9).addComponent(this.JTFFVBase, -2, 102, -2).addGap(9, 9, 9).addComponent(this.JTFFVRetencion, -2, 103, -2).addGap(9, 9, 9).addComponent(this.JTFFVIva, -2, 89, -2)).addComponent(this.JCBCconsignaR, -2, 770, -2).addComponent(this.JBTAdicionar, -2, 999, -2)).addGap(10, 10, 10)));
        JPIConsultaLayout.setVerticalGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPuc, -2, 52, -2).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JSPPBase, -2, 50, -2)).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JSPPIva, -2, 50, -2)).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JTFFVIngreso, -2, -1, -2)).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JTFFVBase, -2, -1, -2)).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JTFFVRetencion, -2, -1, -2)).addGroup(JPIConsultaLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JTFFVIva, -2, 52, -2))).addGap(10, 10, 10).addComponent(this.JCBCconsignaR, -2, 60, -2).addGap(10, 10, 10).addComponent(this.JBTAdicionar, -2, 43, -2).addGap(10, 10, 10)));
        this.JPITotales.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFTotalBase.setBorder(BorderFactory.createTitledBorder((Border) null, "Base", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalBase.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalBase.setHorizontalAlignment(4);
        this.JTFFTotalBase.setFont(new Font("Arial", 1, 13));
        this.JTFFTotalRetencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Retención", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalRetencion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalRetencion.setHorizontalAlignment(4);
        this.JTFFTotalRetencion.setFont(new Font("Arial", 1, 13));
        this.JTFFTotalIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalIva.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalIva.setHorizontalAlignment(4);
        this.JTFFTotalIva.setFont(new Font("Arial", 1, 13));
        GroupLayout JPITotalesLayout = new GroupLayout(this.JPITotales);
        this.JPITotales.setLayout(JPITotalesLayout);
        JPITotalesLayout.setHorizontalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFTotalBase, -2, 126, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalRetencion, -2, 126, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalIva, -2, 126, -2).addContainerGap(-1, 32767)));
        JPITotalesLayout.setVerticalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotalesLayout.createSequentialGroup().addGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalBase, -2, 60, -2).addComponent(this.JTFFTotalRetencion, -2, 60, -2).addComponent(this.JTFFTotalIva, -2, 60, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIConsulta, -1, -1, 32767).addComponent(this.JPIDatosP, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPResultado, GroupLayout.Alignment.LEADING).addComponent(this.JPITotales, -2, -1, -2)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatosP, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JPIConsulta, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 206, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITotales, -2, -1, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBPuc.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPuc.requestFocus();
            return;
        }
        if (Double.valueOf(this.JTFFVBase.getValue().toString()).doubleValue() > 0.0d) {
            if (!this.xmetodos.mVerificarDatosDoblesTabla(this.JTResultado, 0, this.xidpuc[this.JCBPuc.getSelectedIndex()][0])) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(this.xidpuc[this.JCBPuc.getSelectedIndex()][0], this.xnfila, 0);
                this.xmodelo.setValueAt(this.JCBPuc.getSelectedItem(), this.xnfila, 1);
                this.xmodelo.setValueAt(this.JSPPBase.getValue(), this.xnfila, 2);
                this.xmodelo.setValueAt(this.JTFFVBase.getValue(), this.xnfila, 3);
                this.xmodelo.setValueAt(this.JTFFVRetencion.getValue(), this.xnfila, 4);
                this.xmodelo.setValueAt(this.JSPPIva.getValue(), this.xnfila, 5);
                this.xmodelo.setValueAt(this.JTFFVIva.getValue(), this.xnfila, 6);
                this.xmodelo.setValueAt(this.JTFFVIngreso.getValue(), this.xnfila, 7);
                this.xnfila++;
                mTotalizar();
                mLimpiarDatosD();
                this.JCBPuc.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Registro ya cargado en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Falta digitar el valor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFVBase.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoKeyPressed(KeyEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && evt.getKeyCode() == 127) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la fila seleccionada?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelo.removeRow(this.JTResultado.getSelectedRow());
                this.xnfila--;
                mTotalizar();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoImpuestoItemStateChanged(ItemEvent evt) {
        this.xlleno1 = false;
        ConsultasMySQL xct = new ConsultasMySQL();
        if (this.xlleno && this.JCBTipoImpuesto.getSelectedIndex() != -1) {
            this.JCBPeriodo.removeAllItems();
            if (this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()].equals("3")) {
                this.xidperiodot = xct.llenarCombo("SELECT Id, NPerido, FechaI, FechaF FROM cc_periodost WHERE (Estado =1)", this.xidperiodot, this.JCBPeriodo);
                this.JCBPeriodo.setSelectedIndex(-1);
                xct.cerrarConexionBd();
            } else {
                this.xidperiodot = xct.llenarCombo("SELECT Id, NPerido, FechaI, FechaF FROM cc_periodost WHERE (Estado =1)", this.xidperiodot, this.JCBPeriodo);
                this.JCBPeriodo.setSelectedIndex(-1);
                xct.cerrarConexionBd();
            }
            this.JCBPuc.removeAllItems();
            this.xsql = "SELECT Id,concat(Nbre, ' ',PBase) as Nombre , PBase FROM cc_puc WHERE (Id_TipoImpuesto ='" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()] + "') ORDER BY Nbre ASC";
            this.xidpuc = this.xconsultas.llenarComboyLista(this.xsql, this.xidpuc, this.JCBPuc, 2);
            this.JCBPuc.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVBaseActionPerformed(ActionEvent evt) {
        this.JTFFVBase.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVBaseKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFVBase.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVRetencionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFVRetencion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVIvaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFVIva.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPBaseFocusLost(FocusEvent evt) {
        mCalcularRetencion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVBaseFocusLost(FocusEvent evt) {
        mCalcularRetencion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVRetencionFocusLost(FocusEvent evt) {
        mCalcularRetencion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPBaseStateChanged(ChangeEvent evt) {
        mCalcularRetencion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPIvaStateChanged(ChangeEvent evt) {
        mCalcularRetencion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVIngresoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVIngresoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVIngresoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPucItemStateChanged(ItemEvent evt) {
    }

    private void mCalcularRetencion() {
        if (Double.valueOf(this.JSPPBase.getValue().toString()).doubleValue() != 0.0d && Double.valueOf(this.JTFFVBase.getValue().toString()).doubleValue() != 0.0d) {
            this.JTFFVRetencion.setValue(Double.valueOf((Double.valueOf(this.JTFFVBase.getValue().toString()).doubleValue() * Double.valueOf(this.JSPPBase.getValue().toString()).doubleValue()) / 100.0d));
            this.JTFFVIva.setValue(Double.valueOf((Double.valueOf(this.JTFFVBase.getValue().toString()).doubleValue() * Double.valueOf(this.JSPPIva.getValue().toString()).doubleValue()) / 100.0d));
        }
    }

    private void mTotalizar() {
        double xtotalb = 0.0d;
        double xtotalr = 0.0d;
        double xtotali = 0.0d;
        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
            xtotalb += Double.valueOf(this.xmodelo.getValueAt(y, 3).toString()).doubleValue();
            xtotalr += Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue();
            xtotali += Double.valueOf(this.xmodelo.getValueAt(y, 6).toString()).doubleValue();
        }
        this.JTFFTotalBase.setValue(Double.valueOf(xtotalb));
        this.JTFFTotalRetencion.setValue(Double.valueOf(xtotalr));
        this.JTFFTotalIva.setValue(Double.valueOf(xtotali));
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                if (this.JCBPeriodo.getSelectedIndex() != -1) {
                    if (this.JTResultado.getRowCount() > 0) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "insert into cc_certificado_impuestos (FechaG, Id_TipoImpuesto, Id_Tercero, Id_PeriodoT, Ano, Observacion ,`Id_CuentaxEmpresa` , UsuarioS) Values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()] + "','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','" + this.xidperiodot[this.JCBPeriodo.getSelectedIndex()] + "','" + this.JYCAno.getValue() + "','" + this.JTAObservacion.getText() + "','" + this.xidcuenta[this.JCBCconsignaR.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
                            Principal.txtEstado.setText("ACTIVA");
                            this.xconsultas.cerrarConexionBd();
                            for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                                String sql2 = "insert into cc_detalle_certificado_manual (Id_Certificado, Id_puc, Porcentaje, VBase, VRetencion, Iva, VTotalIVa, VIngreso) Values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 2) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + this.xmodelo.getValueAt(y, 4) + "','" + this.xmodelo.getValueAt(y, 5) + "','" + this.xmodelo.getValueAt(y, 6) + "','" + this.xmodelo.getValueAt(y, 7) + "')";
                                this.xconsultas.ejecutarSQL(sql2);
                                this.xconsultas.cerrarConexionBd();
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe registrar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBPeriodo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTercero.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        this.xlleno = false;
        Principal.mLimpiarDatosP();
        this.JDFFechaC.setDate(this.xmetodos.getFechaActual());
        this.JCBTipoImpuesto.removeAllItems();
        this.xsql = "SELECT   `cc_tipo_impuesto`.`Id` , `cc_tipo_impuesto`.`Nbre`\nFROM `cc_puc`  INNER JOIN  `cc_tipo_impuesto`   ON (`cc_puc`.`Id_TipoImpuesto` = `cc_tipo_impuesto`.`Id`) INNER JOIN  `cc_detalle_documentoc`   ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)\nWHERE (`cc_tipo_impuesto`.`EsImpuestos` =1)\nGROUP BY `cc_tipo_impuesto`.`Id`\nORDER BY `cc_tipo_impuesto`.`Nbre` ASC";
        this.xidtipoimpuesto = this.xconsultas.llenarCombo(this.xsql, this.xidtipoimpuesto, this.JCBTipoImpuesto);
        this.JCBTipoImpuesto.setSelectedIndex(-1);
        this.JCBTercero.removeAllItems();
        this.xidempresa = this.xconsultas.llenarCombo("SELECT Id, RazonSocialCompleta FROM cc_terceros WHERE (Estado =1) ORDER BY RazonSocialCompleta ASC", this.xidempresa, this.JCBTercero);
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBCconsignaR.removeAllItems();
        this.xsql = "SELECT  `cc_cuentaxempresa`.`Id` , CONCAT(`cc_banco`.`Nbre` ,' ' , `cc_cuentaxempresa`.`NCuenta`) FROM `g_ips`  INNER JOIN   `g_empresa`    ON (`g_ips`.`Id_gempresa` = `g_empresa`.`Id`)  INNER JOIN   `cc_cuentaxempresa`   ON (`cc_cuentaxempresa`.`Id_Empresa` = `g_empresa`.`Id`)INNER JOIN   `cc_bancoxsucursal`  ON (`cc_cuentaxempresa`.`Id_SucursalxBanco` = `cc_bancoxsucursal`.`Id`) INNER JOIN   `cc_banco`  ON (`cc_bancoxsucursal`.`Id_Banco` = `cc_banco`.`Id`)WHERE (`g_ips`.`Id` ='" + Principal.informacionIps.getId() + "' AND cc_cuentaxempresa.`Estado`=1) ORDER BY `cc_cuentaxempresa`.`EsPrincipal` ;";
        this.xidcuenta = this.xconsultas.llenarCombo(this.xsql, this.xidcuenta, this.JCBCconsignaR);
        this.JCBCconsignaR.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.xlleno = true;
        this.JTAObservacion.setText("");
        mLimpiarDatosD();
        mCrearTabla();
        this.JTFFTotalBase.setValue(new Double(0.0d));
        this.JTFFTotalIva.setValue(new Double(0.0d));
        this.JTFFTotalRetencion.setValue(new Double(0.0d));
        this.JTFFVIngreso.setValue(new Double(0.0d));
        this.JCBTipoImpuesto.requestFocus();
    }

    private void mLimpiarDatosD() {
        this.JCBPuc.setSelectedIndex(-1);
        this.JTFFVBase.setValue(new Double(0.0d));
        this.JTFFVRetencion.setValue(new Double(0.0d));
        this.JTFFVIva.setValue(new Double(0.0d));
        this.JSPPIva.setValue(new Double(0.0d));
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Puc", "Concepto", "%Retención", "V/Base", "V/Retención", "%Iva", "V/Iva", "V/Ingreso"}) { // from class: Contabilidad.JIFGenerarCertificadoI.17
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    public void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "IdC";
        mparametros[0][1] = Principal.txtNo.getText();
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_Certificado_Retencion", mparametros);
    }

    public void mBuscarDatos(String xid) {
        mNuevo();
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT cc_certificado_impuestos.Id, cc_certificado_impuestos.FechaG, cc_tipo_impuesto.Nbre, cc_tercero.NEmpresa, cc_periodost.NPerido, cc_certificado_impuestos.Ano, cc_certificado_impuestos.Observacion , cc_detalle_certificado_manual.Id_puc, cc_puc.Nbre, cc_detalle_certificado_manual.Porcentaje, cc_detalle_certificado_manual.VBase, cc_detalle_certificado_manual.VRetencion, cc_detalle_certificado_manual.Iva, cc_detalle_certificado_manual.VTotalIVa, cc_detalle_certificado_manual.VIngreso FROM cc_detalle_certificado_manual INNER JOIN cc_certificado_impuestos  ON (cc_detalle_certificado_manual.Id_Certificado = cc_certificado_impuestos.Id) INNER JOIN cc_tipo_impuesto ON (cc_certificado_impuestos.Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN cc_tercero ON (cc_tercero.Id = cc_certificado_impuestos.Id_Tercero) INNER JOIN baseserver.cc_periodost ON (cc_certificado_impuestos.Id_PeriodoT = cc_periodost.Id) INNER JOIN cc_puc  ON (cc_detalle_certificado_manual.Id_puc = cc_puc.Id) WHERE (cc_certificado_impuestos.Id ='" + xid + "') ORDER BY cc_puc.Nbre ASC ";
        ResultSet rs = xct.traerRs(sql);
        try {
            if (rs.next()) {
                Principal.txtNo.setText(rs.getString(1));
                this.JDFFechaC.setDate(rs.getDate(2));
                this.JCBTipoImpuesto.setSelectedItem(rs.getString(3));
                this.JCBTercero.setSelectedItem(rs.getString(4));
                this.JCBPeriodo.setSelectedItem(rs.getString(5));
                this.JYCAno.setValue(rs.getInt(6));
                this.JTAObservacion.setText(rs.getString(7));
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(8), x, 0);
                    this.xmodelo.setValueAt(rs.getString(9), x, 1);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(10)), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(11)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(12)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(13)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(14)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(15)), x, 7);
                    x++;
                }
                mTotalizar();
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            xct.mostrarErrorSQL(ex);
        }
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty() && !Principal.txtEstado.getText().equals("ANULADA")) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular la cuenta de cobro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "update cc_certificado_impuestos set  Estado=0 where id='" + Principal.txtNo.getText() + "'";
                this.xconsultas.ejecutarSQL(this.xsql);
                this.xconsultas.cerrarConexionBd();
                Principal.txtEstado.setText("ANULADO");
            }
        }
    }

    public void mBuscar() {
        if (this.JCBTipoImpuesto.getSelectedIndex() != -1) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                this.xjifconsultard = new JIFConsultarDatosV(this);
                Principal.cargarPantalla(this.xjifconsultard);
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTercero.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo impuesto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoImpuesto.requestFocus();
    }
}
