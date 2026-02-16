package Armado;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.contabilidad.ContabilidadDAO;
import com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.jpa.gcuenta.GCuentaDAO;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.service.ICargarComboMedioPagoDAO;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFCuentaCobroCapitacionServicio.class */
public class JIFCuentaCobroCapitacionServicio extends JInternalFrame {
    private String[] xidtipodoc;
    private String[] xidperiodo;
    private String[] xidsede;
    private String[] xidtipodoc_ppt;
    private String[][] xidgrupocuentac;
    private String[][] xidservicio;
    private String[][] xidempresa;
    private String[][] xidperiodo_ppt;
    public DefaultTableModel xmodelo;
    private String xsql;
    private int xid;
    private Object[] xdato;
    private Object jfp;
    private ContabilidadDAO contabilidad;
    private GCuentaDAO gcuenta;
    private IResolucionFacturaElectronica resolucionDian;
    private List<ICargarCombo> medioDePago;
    private List<ICargarCombo> tipoDePago;
    private double totalEps;
    private double servicio;
    private boolean selecionado;
    private ButtonGroup JBGSeleccion;
    private JComboBox JCBEmpresa;
    private JComboBox JCBGrupo;
    private JComboBox JCBGrupoCCobro;
    private JComboBox<String> JCBMedioDePago;
    private JComboBox JCBPeriodoC;
    private JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBSede;
    private JComboBox JCBTipoC;
    private JComboBox JCBTipoDoc_Ppt;
    private JComboBox<String> JCBTipoPago;
    private JCheckBox JCHLimitar;
    private JCheckBox JCHSede;
    private JCheckBox JCH_AplicaMC;
    private JCheckBox JCH_AplicaMP;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JDateChooser JDFFechaC;
    private JPanel JPIDContables;
    private JPanel JPIDContables1;
    private JPanel JPIDatoP;
    private JPanel JPIDetalle;
    private JPanel JPI_DConsolidado;
    private JPanel JPI_DatosCP;
    private JScrollPane JSPConcepto;
    private JSpinner JSPNRegistro;
    private JScrollPane JSPResultado;
    private JTextPane JTAConcepto;
    private JTable JTBResultado;
    private JFormattedTextField JTFFNCuentaCobro;
    private JFormattedTextField JTFFNDoc;
    private JFormattedTextField JTFFNDoc_Ppt;
    private JFormattedTextField JTFFNFacturaEvento;
    private JFormattedTextField JTFFTotalCModeradora;
    private JFormattedTextField JTFFTotalCopago;
    private JFormattedTextField JTFFTotalDescuento;
    private JFormattedTextField JTFFTotalEps;
    private JFormattedTextField JTFFTotalPaciente;
    private JFormattedTextField JTFFTotalServicio;
    private JTabbedPane JTP_DatosP;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xsede = "";
    private int xllenoc = 0;
    private int xllenocg = 0;
    private final IResolucionDianDAO xIResolucionDianDAO = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
    private final ICargarComboMedioPagoDAO xICargarComboMedioPagoDAO = (ICargarComboMedioPagoDAO) Principal.contexto.getBean(ICargarComboMedioPagoDAO.class);

    public JIFCuentaCobroCapitacionServicio(String xtitulo, int xid) {
        this.xid = 0;
        initComponents();
        this.xid = xid;
        setTitle(xtitulo);
        mNuevo();
        springStart();
        mValidaResolucionDian(true);
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.JCH_AplicaMC.setEnabled(true);
        }
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCBGrupo = new JComboBox();
        this.JCHSede = new JCheckBox();
        this.JCBSede = new JComboBox();
        this.JPIDetalle = new JPanel();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JTFFTotalServicio = new JFormattedTextField();
        this.JTFFTotalCModeradora = new JFormattedTextField();
        this.JTFFTotalCopago = new JFormattedTextField();
        this.JTFFTotalEps = new JFormattedTextField();
        this.JTFFTotalDescuento = new JFormattedTextField();
        this.JTFFTotalPaciente = new JFormattedTextField();
        this.JTP_DatosP = new JTabbedPane();
        this.JPI_DConsolidado = new JPanel();
        this.JSPConcepto = new JScrollPane();
        this.JTAConcepto = new JTextPane();
        this.JSPNRegistro = new JSpinner();
        this.JCHLimitar = new JCheckBox();
        this.JTFFNCuentaCobro = new JFormattedTextField();
        this.JTFFNFacturaEvento = new JFormattedTextField();
        this.JCBGrupoCCobro = new JComboBox();
        this.JPI_DatosCP = new JPanel();
        this.JPIDContables = new JPanel();
        this.JCBPeriodoC = new JComboBox();
        this.JCBTipoC = new JComboBox();
        this.JTFFNDoc = new JFormattedTextField();
        this.JDFFechaC = new JDateChooser();
        this.JCH_AplicaMC = new JCheckBox();
        this.JPIDContables1 = new JPanel();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDoc_Ppt = new JComboBox();
        this.JTFFNDoc_Ppt = new JFormattedTextField();
        this.JCH_AplicaMP = new JCheckBox();
        this.JCBTipoPago = new JComboBox<>();
        this.JCBMedioDePago = new JComboBox<>();
        setClosable(true);
        setTitle("CAPITACION POR SERVICIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcuentacobrocapitacionserv");
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE ARMADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFCuentaCobroCapitacionServicio.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFCuentaCobroCapitacionServicio.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Armado.JIFCuentaCobroCapitacionServicio.3
            public void itemStateChanged(ItemEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHSede.setFont(new Font("Arial", 1, 12));
        this.JCHSede.setText("Filtrar?");
        this.JCHSede.addActionListener(new ActionListener() { // from class: Armado.JIFCuentaCobroCapitacionServicio.4
            public void actionPerformed(ActionEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JCHSedeActionPerformed(evt);
            }
        });
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSede.addItemListener(new ItemListener() { // from class: Armado.JIFCuentaCobroCapitacionServicio.5
            public void itemStateChanged(ItemEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JCBSedeItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addComponent(this.JCBGrupo, -2, 526, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHSede).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSede, 0, -1, 32767)).addGroup(JPIDatoPLayout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 547, -2))).addContainerGap(-1, 32767)));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 61, -2).addComponent(this.JDCFechaFin, -2, 61, -2)).addComponent(this.JCBEmpresa, -2, 51, -2)).addGap(18, 18, 18).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBGrupo, -1, 51, 32767).addComponent(this.JCHSede).addComponent(this.JCBSede)).addContainerGap(-1, 32767)));
        this.JPIDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPResultado.setBorder(BorderFactory.createEtchedBorder());
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setEnabled(false);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultado.setSelectionMode(0);
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JTFFTotalServicio.setEditable(false);
        this.JTFFTotalServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL SERVICIO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalServicio.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalServicio.setHorizontalAlignment(4);
        this.JTFFTotalServicio.setText("0");
        this.JTFFTotalServicio.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalCModeradora.setEditable(false);
        this.JTFFTotalCModeradora.setBorder(BorderFactory.createTitledBorder((Border) null, "C/MODERADORA", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalCModeradora.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalCModeradora.setHorizontalAlignment(4);
        this.JTFFTotalCModeradora.setText("0");
        this.JTFFTotalCModeradora.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalCModeradora.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionServicio.6
            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalCModeradoraFocusLost(evt);
            }
        });
        this.JTFFTotalCModeradora.addKeyListener(new KeyAdapter() { // from class: Armado.JIFCuentaCobroCapitacionServicio.7
            public void keyPressed(KeyEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalCModeradoraKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalCModeradoraKeyReleased(evt);
            }
        });
        this.JTFFTotalCopago.setEditable(false);
        this.JTFFTotalCopago.setBorder(BorderFactory.createTitledBorder((Border) null, "COPAGO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalCopago.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalCopago.setHorizontalAlignment(4);
        this.JTFFTotalCopago.setText("0");
        this.JTFFTotalCopago.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalCopago.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionServicio.8
            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalCopagoFocusLost(evt);
            }
        });
        this.JTFFTotalCopago.addKeyListener(new KeyAdapter() { // from class: Armado.JIFCuentaCobroCapitacionServicio.9
            public void keyPressed(KeyEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalCopagoKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalCopagoKeyReleased(evt);
            }
        });
        this.JTFFTotalEps.setEditable(false);
        this.JTFFTotalEps.setBorder(BorderFactory.createTitledBorder((Border) null, "EPS", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalEps.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalEps.setHorizontalAlignment(4);
        this.JTFFTotalEps.setText("0");
        this.JTFFTotalEps.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalDescuento.setEditable(false);
        this.JTFFTotalDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCUENTO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalDescuento.setHorizontalAlignment(4);
        this.JTFFTotalDescuento.setText("0");
        this.JTFFTotalDescuento.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalDescuento.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionServicio.10
            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalDescuentoFocusLost(evt);
            }
        });
        this.JTFFTotalDescuento.addInputMethodListener(new InputMethodListener() { // from class: Armado.JIFCuentaCobroCapitacionServicio.11
            public void inputMethodTextChanged(InputMethodEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalDescuentoInputMethodTextChanged(evt);
            }

            public void caretPositionChanged(InputMethodEvent evt) {
            }
        });
        this.JTFFTotalDescuento.addKeyListener(new KeyAdapter() { // from class: Armado.JIFCuentaCobroCapitacionServicio.12
            public void keyPressed(KeyEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalDescuentoKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalDescuentoKeyReleased(evt);
            }
        });
        this.JTFFTotalPaciente.setEditable(false);
        this.JTFFTotalPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "PACIENTE", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalPaciente.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalPaciente.setHorizontalAlignment(4);
        this.JTFFTotalPaciente.setText("0");
        this.JTFFTotalPaciente.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalPaciente.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionServicio.13
            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalPacienteFocusLost(evt);
            }
        });
        this.JTFFTotalPaciente.addKeyListener(new KeyAdapter() { // from class: Armado.JIFCuentaCobroCapitacionServicio.14
            public void keyPressed(KeyEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalPacienteKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JTFFTotalPacienteKeyReleased(evt);
            }
        });
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTotalCopago, -2, 136, -2).addComponent(this.JTFFTotalServicio, -2, 136, -2).addComponent(this.JTFFTotalPaciente, -2, 136, -2)).addGap(10, 10, 10).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTotalDescuento, -2, 136, -2).addComponent(this.JTFFTotalCModeradora, -2, 136, -2).addComponent(this.JTFFTotalEps, -2, 136, -2)).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalServicio, -2, -1, -2).addComponent(this.JTFFTotalDescuento, -2, -1, -2)).addGap(29, 29, 29).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFTotalCModeradora, -2, -1, -2).addComponent(this.JTFFTotalPaciente, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalCopago, -2, -1, -2).addComponent(this.JTFFTotalEps, -2, -1, -2))).addComponent(this.JSPResultado, -2, 216, -2)).addContainerGap(-1, 32767)));
        this.JTP_DatosP.setForeground(new Color(0, 103, 0));
        this.JTP_DatosP.setFont(new Font("Arial", 1, 14));
        this.JSPConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAConcepto.setFont(new Font("Arial", 1, 12));
        this.JSPConcepto.setViewportView(this.JTAConcepto);
        this.JSPNRegistro.setFont(new Font("Arial", 1, 12));
        this.JSPNRegistro.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHLimitar.setFont(new Font("Arial", 1, 12));
        this.JCHLimitar.setText("Limitar");
        this.JCHLimitar.addActionListener(new ActionListener() { // from class: Armado.JIFCuentaCobroCapitacionServicio.15
            public void actionPerformed(ActionEvent evt) {
                JIFCuentaCobroCapitacionServicio.this.JCHLimitarActionPerformed(evt);
            }
        });
        this.JTFFNCuentaCobro.setEditable(false);
        this.JTFFNCuentaCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° CUENTA COBRO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNCuentaCobro.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNCuentaCobro.setHorizontalAlignment(0);
        this.JTFFNCuentaCobro.setFont(new Font("Arial", 1, 18));
        this.JTFFNFacturaEvento.setEditable(false);
        this.JTFFNFacturaEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° FACTURA EVENTO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNFacturaEvento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNFacturaEvento.setHorizontalAlignment(0);
        this.JTFFNFacturaEvento.setFont(new Font("Arial", 1, 18));
        this.JCBGrupoCCobro.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoCCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Cuenta de Cobro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DConsolidadoLayout = new GroupLayout(this.JPI_DConsolidado);
        this.JPI_DConsolidado.setLayout(JPI_DConsolidadoLayout);
        JPI_DConsolidadoLayout.setHorizontalGroup(JPI_DConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPConcepto, -1, 580, 32767).addGap(57, 57, 57).addComponent(this.JCHLimitar).addGap(31, 31, 31).addComponent(this.JSPNRegistro, -2, 106, -2).addGap(21, 21, 21)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DConsolidadoLayout.createSequentialGroup().addComponent(this.JCBGrupoCCobro, -2, 482, -2).addGap(42, 42, 42).addComponent(this.JTFFNCuentaCobro, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFNFacturaEvento, -2, 165, -2)));
        JPI_DConsolidadoLayout.setVerticalGroup(JPI_DConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPConcepto, -2, 86, -2).addGroup(JPI_DConsolidadoLayout.createSequentialGroup().addGroup(JPI_DConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHLimitar).addComponent(this.JSPNRegistro, -2, 51, -2)).addGap(20, 20, 20))).addGap(18, 18, 18).addGroup(JPI_DConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNCuentaCobro, -2, -1, -2).addComponent(this.JTFFNFacturaEvento).addComponent(this.JCBGrupoCCobro, -1, 50, 32767)).addGap(82, 82, 82)));
        this.JTP_DatosP.addTab("DATOS CUENTA COBRO", this.JPI_DConsolidado);
        this.JPIDContables.setBorder(BorderFactory.createTitledBorder((Border) null, "CONTABLE", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBPeriodoC.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc.setEditable(false);
        this.JTFFNDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc.setHorizontalAlignment(0);
        this.JTFFNDoc.setFont(new Font("Arial", 1, 18));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMC.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMC.setText("Aplica?");
        GroupLayout JPIDContablesLayout = new GroupLayout(this.JPIDContables);
        this.JPIDContables.setLayout(JPIDContablesLayout);
        JPIDContablesLayout.setHorizontalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_AplicaMC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addComponent(this.JCBPeriodoC, -2, 205, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoC, -2, 243, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNDoc, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaC, -2, 112, -2).addContainerGap()));
        JPIDContablesLayout.setVerticalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodoC, -2, 50, -2).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JTFFNDoc).addComponent(this.JCH_AplicaMC)).addGap(56, 56, 56)).addGroup(JPIDContablesLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 54, -2).addGap(0, 0, 32767)));
        this.JPIDContables1.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESUPUESTO", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBPeriodo_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt.setEditable(false);
        this.JTFFNDoc_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Ppt.setHorizontalAlignment(0);
        this.JTFFNDoc_Ppt.setFont(new Font("Arial", 1, 18));
        this.JCH_AplicaMP.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMP.setText("Aplica?");
        GroupLayout JPIDContables1Layout = new GroupLayout(this.JPIDContables1);
        this.JPIDContables1.setLayout(JPIDContables1Layout);
        JPIDContables1Layout.setHorizontalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_AplicaMP).addGap(31, 31, 31).addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Ppt, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, 32767).addComponent(this.JTFFNDoc_Ppt, -2, 140, -2).addContainerGap()));
        JPIDContables1Layout.setVerticalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Ppt, -2, 50, -2).addComponent(this.JTFFNDoc_Ppt)).addContainerGap(-1, 32767)).addGroup(JPIDContables1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_AplicaMP).addContainerGap(-1, 32767)));
        this.JCBTipoPago.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMedioDePago.setFont(new Font("Arial", 1, 12));
        this.JCBMedioDePago.setBorder(BorderFactory.createTitledBorder((Border) null, "Medio de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DatosCPLayout = new GroupLayout(this.JPI_DatosCP);
        this.JPI_DatosCP.setLayout(JPI_DatosCPLayout);
        JPI_DatosCPLayout.setHorizontalGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCPLayout.createSequentialGroup().addGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCPLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDContables1, -1, -1, 32767)).addGroup(JPI_DatosCPLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDContables, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()).addGroup(JPI_DatosCPLayout.createSequentialGroup().addGap(118, 118, 118).addComponent(this.JCBTipoPago, -2, 308, -2).addGap(18, 18, 18).addComponent(this.JCBMedioDePago, -2, 308, -2).addContainerGap(-1, 32767)));
        JPI_DatosCPLayout.setVerticalGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCPLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMedioDePago, -2, 50, -2).addComponent(this.JCBTipoPago, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDContables, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDContables1, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTP_DatosP.addTab("DATOS CONTABLES Y/O PRESUPUESTALES", this.JPI_DatosCP);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_DatosP).addComponent(this.JPIDetalle, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPIDatoP, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addGap(4, 4, 4).addComponent(this.JPIDetalle, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_DatosP, -1, 286, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xllenoc == 1 && this.JCBEmpresa.getSelectedIndex() != -1) {
            this.JCBGrupoCCobro.removeAllItems();
            this.JCBGrupo.removeAllItems();
            this.JCBSede.removeAllItems();
            mCrearVistasMaestra();
            if (this.xid == 0) {
                this.xsql = "SELECT `IdGrupo`, `NGrupo` FROM  `v_f_tmp` GROUP BY `IdGrupo` ORDER BY `NGrupo` ASC";
            } else {
                this.xsql = "SELECT f_gruposervicio.Id_GrupoServicio , f_gruposervicio.Nbre FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso) INNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) WHERE (f_factura_evento.EstaArmada =1  AND f_factura_evento.Estado =0 AND f_empresacontxconvenio.Id='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' ) GROUP BY f_gruposervicio.Id_GrupoServicio ORDER BY f_gruposervicio.Nbre ASC ";
            }
            this.xidservicio = this.xct.llenarComboyLista(this.xsql, this.xidservicio, this.JCBGrupo, 2);
            if (this.xidservicio.length == 1) {
                this.JCBGrupo.setSelectedIndex(0);
            } else {
                this.JCBGrupo.setSelectedIndex(-1);
            }
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT f_subgrupo_empresa.Id, f_subgruposervicio.Nbre, f_subgrupo_empresa.IdRubro FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN  f_gruposervicio ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) WHERE (f_subgruposervicio.EsGrupo =1 AND f_subgrupo_empresa.Id_Empresa ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_subgrupo_empresa.Estado =1) ORDER BY f_subgruposervicio.Nbre ASC ";
            this.xidgrupocuentac = this.xct.llenarComboyLista(this.xsql, this.xidgrupocuentac, this.JCBGrupoCCobro, 3);
            if (this.xidgrupocuentac.length == 1) {
                this.JCBGrupoCCobro.setSelectedIndex(0);
            } else {
                this.JCBGrupoCCobro.setSelectedIndex(-1);
            }
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT g_sedes.`Id`, g_sedes.`Nbre`   FROM f_factura_capita  INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN ingreso  ON (f_liquidacion.Id_Ingreso = ingreso.Id)  INNER JOIN g_sedes ON (g_sedes.`Id` = ingreso.`Id_Sede`)  INNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)  INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)  INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)  WHERE (ingreso.FechaIngreso >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'  AND f_factura_capita.EstaArmada =1 AND f_empresacontxconvenio.Id='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "')  GROUP BY g_sedes.`Id` ORDER BY g_sedes.`Nbre`  ASC  ";
            this.xidsede = this.xct.llenarCombo(this.xsql, this.xidsede, this.JCBSede);
            this.JCBSede.setSelectedIndex(-1);
            if (this.xidsede.length >= 1) {
                this.JCBSede.setSelectedItem(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
            }
            this.xct.cerrarConexionBd();
            this.xllenocg = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc == 1) {
            mLlenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc == 1) {
            mLlenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSedeActionPerformed(ActionEvent evt) {
        if (!this.JCHSede.isSelected()) {
            this.xsede = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeItemStateChanged(ItemEvent evt) {
        if (this.xllenocg == 1 && this.JCBSede.getSelectedIndex() != -1) {
            this.xsede = this.JCBSede.getSelectedItem().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLimitarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalDescuentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (Double.parseDouble(this.JTFFTotalDescuento.getValue().toString()) > Double.parseDouble(this.JTFFTotalServicio.getValue().toString())) {
                this.JTFFTotalDescuento.setValue(0);
                JOptionPane.showInternalMessageDialog(this, "Descuento no puede ser mayor a Total Servicio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            } else {
                this.JTFFTotalDescuento.transferFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalPacienteKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFTotalPaciente.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCModeradoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFTotalCModeradora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCopagoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFTotalCopago.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalDescuentoKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalPacienteKeyReleased(KeyEvent evt) {
        this.JTFFTotalEps.setValue(Double.valueOf(opeacion()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCModeradoraKeyReleased(KeyEvent evt) {
        this.JTFFTotalEps.setValue(Double.valueOf(opeacion()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCopagoKeyReleased(KeyEvent evt) {
        this.JTFFTotalEps.setValue(Double.valueOf(opeacion()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalDescuentoInputMethodTextChanged(InputMethodEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalDescuentoFocusLost(FocusEvent evt) {
        if (Double.parseDouble(this.JTFFTotalDescuento.getValue().toString()) > Double.parseDouble(this.JTFFTotalServicio.getValue().toString())) {
            this.JTFFTotalDescuento.setValue(0);
            JOptionPane.showInternalMessageDialog(this, "Descuento no puede ser mayor a Total Servicio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        } else {
            this.JTFFTotalEps.setValue(Double.valueOf(opeacion()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalPacienteFocusLost(FocusEvent evt) {
        this.JTFFTotalEps.setValue(Double.valueOf(opeacion()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCModeradoraFocusLost(FocusEvent evt) {
        this.JTFFTotalEps.setValue(Double.valueOf(opeacion()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCopagoFocusLost(FocusEvent evt) {
        this.JTFFTotalEps.setValue(Double.valueOf(opeacion()));
    }

    private void mValidaResolucionDian(Boolean validar) {
        List<IResolucionFacturaElectronica> lis = this.xIResolucionDianDAO.consultarResolucion(Principal.sedeUsuarioSeleccionadaDTO.getId());
        if (lis.size() > 0) {
            this.resolucionDian = lis.get(0);
            if (validar.booleanValue()) {
                this.xmt.mResolucionDian(lis.get(0));
            }
        }
    }

    private void mCrearTablaDetalleProc() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"N° Items", "Servicio", "Total Eps", "CDebito", "CCredito", "RubroP"}) { // from class: Armado.JIFCuentaCobroCapitacionServicio.16
            Class[] types = {Long.class, String.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarDatos() {
        String sql;
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.JCBGrupo.getSelectedIndex() != -1) {
                if (this.JCHSede.isSelected()) {
                    if (this.xid == 0) {
                        mCrearVistasDetalleSede();
                        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                            sql = "SELECT COUNT(`NFactura`) AS `NItems` , `NSubgrupo` , SUM(`TotalServicio`) AS `TotalServicio` , SUM(`TotalDescuento`) AS `TotalDescuento` , SUM(`TotalPaciente`) AS `TotalPaciente`, SUM(`CuotaModeradora`) AS `TotalCmoderadora`, SUM(`Copago`) AS `TotalCopago`, IF(SUM(TotalEps)=0,SUM(TotalPaciente),SUM(TotalEps)) AS `TotalEps`, CDebito, CCredito , CodRubro FROM  `v_f_tmp1` GROUP BY `IdSubgrupo` ORDER BY `NSubgrupo` ASC ";
                        } else {
                            sql = "SELECT COUNT(`NFactura`) AS `NItems` , `NSubgrupo` , SUM(`TotalServicio`) AS `TotalServicio` , SUM(`TotalDescuento`) AS `TotalDescuento` , SUM(`TotalPaciente`) AS `TotalPaciente`, SUM(`CuotaModeradora`) AS `TotalCmoderadora`, SUM(`Copago`) AS `TotalCopago`, IF(SUM(TotalEps)=0,SUM(TotalPaciente),SUM(TotalEps)) AS `TotalEps`, CPuc_Debito, CPuc_Credito, CodRubro FROM  `v_f_tmp1` GROUP BY `IdSubgrupo` ORDER BY `NSubgrupo` ASC ";
                        }
                    } else {
                        sql = "SELECT count(f_factura_evento.No_FacturaEvento) as NItems, f_subgruposervicio.`Nbre` AS Subgrupo, sum(f_liquidacion.TotalServicio) as TotalServicio, sum(f_liquidacion.TotalDescuento) as TotalDescuento, sum(f_liquidacion.TotalPaciente) as TotalPaciente, sum(f_liquidacion.CuotaModeradora) as TotalCmoderadora, sum(f_liquidacion.Copago) as TotalCopago, IF(SUM(f_liquidacion.TotalEps)=0,SUM(f_liquidacion.TotalPaciente), SUM(f_liquidacion.TotalEps)) as TotalEps, f_subgrupo_empresa.`CPuc_Debito`, f_subgrupo_empresa.`CPuc_Credito`,  f_subgrupo_empresa.`IdRubro` AS CodRubro FROM  f_factura_evento INNER JOIN  f_liquidacion  ON  (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN f_subgrupo_empresa ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id) INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso) WHERE (f_factura_evento.Fecha_FacturaEvento>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.Id_Sede ='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' and f_factura_evento.Fecha_FacturaEvento<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'  and f_factura_evento.EstaArmada =1 AND f_gruposervicio.Id_GrupoServicio ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_factura_evento.Estado = 0 AND f_liquidacion.Estado = 0 AND ingreso.Estado = 0 and f_factura_evento.No_CuentaCobro=0) GROUP BY f_subgruposervicio.`Nbre`";
                    }
                } else if (this.xid == 0) {
                    mCrearVistasDetalle();
                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        sql = "SELECT COUNT(`NFactura`) AS `NItems` , `NSubgrupo` , SUM(`TotalServicio`) AS `TotalServicio` , SUM(`TotalDescuento`) AS `TotalDescuento` , SUM(`TotalPaciente`) AS `TotalPaciente`, SUM(`CuotaModeradora`) AS `TotalCmoderadora`, SUM(`Copago`) AS `TotalCopago`, IF(SUM(TotalEps)=0,SUM(TotalPaciente),SUM(TotalEps)) AS `TotalEps`, CDebito, CCredito , CodRubro FROM  `v_f_tmp1` GROUP BY `IdSubgrupo` ORDER BY `NSubgrupo` ASC ";
                    } else {
                        sql = "SELECT COUNT(`NFactura`) AS `NItems` , `NSubgrupo` , SUM(`TotalServicio`) AS `TotalServicio` , SUM(`TotalDescuento`) AS `TotalDescuento` , SUM(`TotalPaciente`) AS `TotalPaciente`, SUM(`CuotaModeradora`) AS `TotalCmoderadora`, SUM(`Copago`) AS `TotalCopago`, IF(SUM(TotalEps)=0,SUM(TotalPaciente),SUM(TotalEps)) AS `TotalEps`, CPuc_Debito, CPuc_Credito , CodRubro FROM  `v_f_tmp1` GROUP BY `IdSubgrupo` ORDER BY `NSubgrupo` ASC ";
                    }
                } else {
                    sql = "SELECT count(f_factura_evento.No_FacturaEvento) as NItems, f_subgruposervicio.`Nbre` AS Subgrupo, sum(f_liquidacion.TotalServicio) as TotalServicio, sum(f_liquidacion.TotalDescuento) as TotalDescuento, sum(f_liquidacion.TotalPaciente) as TotalPaciente, sum(f_liquidacion.CuotaModeradora) as TotalCmoderadora, sum(f_liquidacion.Copago) as TotalCopago, IF(SUM(f_liquidacion.TotalEps)=0,SUM(f_liquidacion.TotalPaciente), SUM(f_liquidacion.TotalEps)) as TotalEps, f_subgrupo_empresa.`CPuc_Debito`, f_subgrupo_empresa.`CPuc_Credito`, f_subgrupo_empresa.IdRubro AS CodRubro  FROM  f_factura_evento INNER JOIN  f_liquidacion  ON  (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN f_subgrupo_empresa ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id) INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) INNER JOIN ingreso  ON  (ingreso.Id = f_liquidacion.Id_Ingreso) WHERE (f_factura_evento.Fecha_FacturaEvento>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' and f_factura_evento.Fecha_FacturaEvento<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'  and f_factura_evento.EstaArmada =1 AND f_gruposervicio.Id_GrupoServicio ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_factura_evento.Estado = 0 AND f_liquidacion.Estado = 0 AND ingreso.Estado = 0 and f_factura_evento.No_CuentaCobro=0) GROUP BY f_subgruposervicio.`Nbre`";
                }
                System.out.print("datos tabla   " + sql);
                mCrearTablaDetalleProc();
                ResultSet rs = this.xct.traerRs(sql);
                try {
                    double xv = 0.0d;
                    double xv1 = 0.0d;
                    double xv2 = 0.0d;
                    double xv3 = 0.0d;
                    double xv4 = 0.0d;
                    double xv5 = 0.0d;
                    if (rs.next()) {
                        rs.beforeFirst();
                        int x = 0;
                        while (rs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                            this.xmodelo.setValueAt(rs.getString(2), x, 1);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), x, 2);
                            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                                this.xmodelo.setValueAt(traerMedioPago(), x, 3);
                            } else {
                                this.xmodelo.setValueAt(rs.getString(9), x, 3);
                            }
                            this.xmodelo.setValueAt(rs.getString(10), x, 4);
                            this.xmodelo.setValueAt(rs.getString("CodRubro"), x, 5);
                            xv += rs.getLong(3);
                            xv1 += rs.getLong(4);
                            xv2 += rs.getLong(5);
                            xv3 += rs.getLong(6);
                            xv4 += rs.getLong(7);
                            xv5 += rs.getLong(8);
                            x++;
                        }
                    }
                    this.totalEps = opeacion(xv, xv1, xv2, xv3, xv4);
                    this.servicio = xv;
                    this.JTFFTotalServicio.setValue(Double.valueOf(xv));
                    this.JTFFTotalDescuento.setValue(Double.valueOf(xv1));
                    this.JTFFTotalPaciente.setValue(Double.valueOf(xv2));
                    this.JTFFTotalCModeradora.setValue(Double.valueOf(xv3));
                    this.JTFFTotalCopago.setValue(Double.valueOf(xv4));
                    this.JTFFTotalEps.setValue(Double.valueOf(this.totalEps));
                    rs.close();
                    this.xct.cerrarConexionBd();
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(JIFCuentaCobroCapitacionServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBGrupo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBEmpresa.requestFocus();
    }

    private double opeacion(double n1, double n2, double n3, double n4, double n5) {
        return (((n1 - n2) - n3) - n4) - n5;
    }

    private double opeacion() {
        double calcular = (((this.servicio - Double.parseDouble(this.JTFFTotalDescuento.getValue().toString())) - Double.parseDouble(this.JTFFTotalPaciente.getValue().toString())) - Double.parseDouble(this.JTFFTotalCModeradora.getValue().toString())) - Double.parseDouble(this.JTFFTotalCopago.getValue().toString());
        System.out.println(calcular);
        return calcular;
    }

    public void mBuscar() {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                mCargarDatos();
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "Seleccione un medio de pago");
            this.JTP_DatosP.setSelectedIndex(1);
            this.JCBMedioDePago.requestFocus();
            return;
        }
        mCargarDatos();
    }

    private boolean descuentoMayor() {
        if (Double.parseDouble(this.JTFFTotalEps.getValue().toString()) > Double.parseDouble(this.JTFFTotalServicio.getValue().toString())) {
            return true;
        }
        return false;
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        mLlenarCEmpresa();
        mCrearTablaDetalleProc();
        this.JCBGrupo.setSelectedIndex(-1);
        mCrearTablaDetalleProc();
        this.JTFFTotalServicio.setValue(0);
        this.JTFFTotalCModeradora.setValue(0);
        this.JTFFTotalCModeradora.setEditable(true);
        this.JTFFTotalCopago.setValue(0);
        this.JTFFTotalCopago.setEditable(true);
        this.JTFFTotalEps.setValue(0);
        this.JTFFTotalDescuento.setValue(0);
        this.JTFFTotalDescuento.setEditable(true);
        this.JTFFTotalPaciente.setValue(0);
        this.JTFFTotalPaciente.setEditable(true);
        this.JTFFNCuentaCobro.setText("");
        this.JTFFNFacturaEvento.setText("");
        this.JTAConcepto.setText("");
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            this.JCH_AplicaMP.setSelected(true);
            if (Principal.informacionIps.getIdentificacion().equals("812003382")) {
                this.JCH_AplicaMP.setSelected(false);
                this.JCH_AplicaMP.setEnabled(false);
            }
        }
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JCH_AplicaMC.setSelected(true);
            this.JCH_AplicaMC.setEnabled(false);
            this.JCH_AplicaMC.setSelected(true);
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                this.JCH_AplicaMC.setEnabled(true);
            }
            if (Principal.informacionIps.getIdentificacion().equals("812007286") || Principal.informacionIps.getIdentificacion().equals("901440362")) {
                this.JCH_AplicaMC.setSelected(false);
                this.JCH_AplicaMC.setEnabled(true);
            }
        }
        this.JDCFechaInicio.requestFocus();
        mCargarCombo();
    }

    private void mCargarCombo() {
        this.medioDePago = this.xICargarComboMedioPagoDAO.cargarComboMedioDePago();
        this.JCBMedioDePago.removeAllItems();
        for (int i = 0; i < this.medioDePago.size(); i++) {
            this.JCBMedioDePago.addItem(this.medioDePago.get(i).getNombre());
        }
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.JCBMedioDePago.setSelectedIndex(-1);
        } else {
            this.JCBMedioDePago.setSelectedItem("Crédito ACH");
        }
        this.tipoDePago = this.xICargarComboMedioPagoDAO.cargarComboTipoDePago();
        this.JCBTipoPago.removeAllItems();
        for (int i2 = 0; i2 < this.tipoDePago.size(); i2++) {
            this.JCBTipoPago.addItem(this.tipoDePago.get(i2).getNombre());
        }
        this.JCBTipoPago.setSelectedItem("CREDITO");
    }

    private void mLlenarCEmpresa() {
        this.xllenoc = 0;
        this.xllenocg = 0;
        this.JCBGrupo.removeAllItems();
        this.JCBEmpresa.removeAllItems();
        this.JCBGrupoCCobro.removeAllItems();
        this.JCBPeriodoC.removeAllItems();
        this.JCBTipoC.removeAllItems();
        this.JCBPeriodoC.removeAllItems();
        this.JCBTipoDoc_Ppt.removeAllItems();
        this.JCBPeriodo_Ppt.removeAllItems();
        if (this.xid == 0) {
            this.xsql = "SELECT f_empresacontxconvenio.Id, f_empresacontxconvenio.Nbre , f_empresacontxconvenio.EsCapitado, g_empresacont.`Id_empresa`, f_empresacontxconvenio.`Id_GIps` FROM f_factura_capita INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN `g_empresacont`  ON (g_empresacont.`Id_empresa`= f_empresacontxconvenio.`Id_EmpresaCont`)  WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_factura_capita.`EstaArmada`=1 ) GROUP BY f_empresacontxconvenio.Id  order by f_empresacontxconvenio.Nbre ";
        } else {
            this.xsql = "SELECT f_empresacontxconvenio.Id, f_empresacontxconvenio.Nbre, f_empresacontxconvenio.EsCapitado, g_empresacont.`Id_empresa`, f_empresacontxconvenio.`Id_GIps` FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN `g_empresacont`  ON (g_empresacont.`Id_empresa`= f_empresacontxconvenio.`Id_EmpresaCont`) WHERE (f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "'AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'  AND f_factura_evento.Estado =0 and f_factura_evento.No_CuentaCobro=0 AND f_factura_evento.`EstaArmada`=1) GROUP BY f_empresacontxconvenio.Id ORDER BY f_empresacontxconvenio.Nbre ASC ";
        }
        this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBEmpresa, 5);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xsql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsVentas` =1 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc = this.xct.llenarCombo(this.xsql, this.xidtipodoc, this.JCBTipoC);
        if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        if (Principal.informacionIps.getIdentificacion().equals("812003382")) {
            this.JCBTipoC.setSelectedItem("VENTAS");
        }
        this.xidperiodo = this.xct.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1 and Activo=1 and EsCierre=0) ORDER BY FechaF DESC", this.xidperiodo, this.JCBPeriodoC);
        if (this.xidperiodo.length > 1) {
            this.JCBPeriodoC.setSelectedIndex(0);
            this.JCBPeriodoC.setSelectedItem(Principal.xclase.getNombrePeriodo().toUpperCase());
        }
        this.xsql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=2 ";
        this.xidtipodoc_ppt = this.xct.llenarCombo(this.xsql, this.xidtipodoc_ppt, this.JCBTipoDoc_Ppt);
        if (this.xidtipodoc_ppt.length > 1 && !Principal.informacionIps.getIdentificacion().equals("812003382")) {
            this.JCBTipoDoc_Ppt.setSelectedIndex(-1);
        }
        this.xidperiodo_ppt = this.xct.llenarComboyLista("SELECT `Id` , CONCAT(`Nbre` ,'-',DATE_FORMAT(`FechaI`, '%Y')) AS Nbre, idEncabezado FROM `pp_periodo` WHERE (`Cerrado` =0) ORDER BY `FechaI` DESC", this.xidperiodo_ppt, this.JCBPeriodo_Ppt, 3);
        if (this.xidperiodo_ppt.length > 1 && !Principal.informacionIps.getIdentificacion().equals("812003382")) {
            this.JCBTipoDoc_Ppt.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
        this.xllenoc = 1;
        this.xllenocg = 1;
    }

    public void mGrabar() {
        if (this.JTFFNCuentaCobro.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.JTBResultado.getRowCount() > 0) {
                    if (this.JCH_AplicaMC.isSelected() && !this.JCH_AplicaMP.isSelected()) {
                        if (this.JCH_AplicaMC.isSelected()) {
                            if (!this.xmt.mVerificarDatosLLeno(this.JTBResultado, 3) && !this.xmt.mVerificarDatosLLeno(this.JTBResultado, 4)) {
                                if (this.JCBTipoC.getSelectedIndex() != -1) {
                                    if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                        if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                            if (this.JCBTipoPago.getSelectedIndex() != -1) {
                                                if (this.xid == 0) {
                                                    if (this.JCBGrupoCCobro.getSelectedIndex() != -1) {
                                                        mGenerarFacturaEvento();
                                                        return;
                                                    } else {
                                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar grupo cuenta de cobro", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                        this.JCBGrupoCCobro.requestFocus();
                                                        return;
                                                    }
                                                }
                                                mGenerarCuentaCobro();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.JCBTipoPago.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar medio de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        this.JCBMedioDePago.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JDFFechaC.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JCBTipoC.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Faltan cuentas contables", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            return;
                        }
                        this.JCH_AplicaMC.setSelected(false);
                        if (this.xid == 0) {
                            mGenerarFacturaEvento();
                            return;
                        } else {
                            mGenerarCuentaCobro();
                            return;
                        }
                    }
                    if (this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                        if (this.JCH_AplicaMC.isSelected()) {
                            if (!this.xmt.mVerificarDatosLLeno(this.JTBResultado, 3) && !this.xmt.mVerificarDatosLLeno(this.JTBResultado, 4) && !this.xmt.mVerificarDatosLLeno(this.JTBResultado, 5)) {
                                if (this.JCBTipoC.getSelectedIndex() != -1) {
                                    if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                        if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                            if (this.JCBTipoPago.getSelectedIndex() != -1) {
                                                if (this.xid == 0) {
                                                    mGenerarFacturaEvento();
                                                    return;
                                                } else {
                                                    mGenerarCuentaCobro();
                                                    return;
                                                }
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.JCBTipoPago.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar medio de pago", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        this.JCBMedioDePago.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.JDFFechaC.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JCBTipoC.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Faltan cuentas contables y/o rubros presupuestales  ", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            return;
                        }
                        this.JCH_AplicaMC.setSelected(false);
                        if (!this.xmt.mVerificarDatosLLeno(this.JTBResultado, 5)) {
                            if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                if (this.xid == 0) {
                                    mGenerarFacturaEvento();
                                    return;
                                } else {
                                    mGenerarCuentaCobro();
                                    return;
                                }
                            }
                            JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JDFFechaC.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Falta rubro presupuestal", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                    if (!this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                        if (!this.xmt.mVerificarDatosLLeno(this.JTBResultado, 5)) {
                            if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                if (this.xid == 0) {
                                    mGenerarFacturaEvento();
                                    return;
                                } else {
                                    mGenerarCuentaCobro();
                                    return;
                                }
                            }
                            JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JDFFechaC.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Falta rubro presupuestal", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                    if (this.xid == 0) {
                        mGenerarFacturaEvento();
                        return;
                    } else {
                        mGenerarCuentaCobro();
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "No existe orden seleccionada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTBResultado.requestFocus();
            }
        }
    }

    public void mImprimir() {
    }

    private void mGenerarDocContable(String xIdCuentaCobro) {
        String xconcepto;
        if (this.JTAConcepto.getText().isEmpty()) {
            xconcepto = this.JCBGrupoCCobro.getSelectedItem().toString();
        } else {
            xconcepto = this.JTAConcepto.getText();
        }
        String xnfactura = this.JTFFNFacturaEvento.getText();
        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC,Id_CuentaCobro, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','" + xIdCuentaCobro + "','" + xconcepto + " Factura Venta N° " + xnfactura + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.JTFFNDoc.setText(this.xct.ejecutarSQLId(this.xsql));
        this.xct.cerrarConexionBd();
        for (int y = 0; y < this.JTBResultado.getRowCount(); y++) {
            try {
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "','0','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "',round(" + this.xmodelo.getValueAt(y, 2) + "),'0','" + xconcepto + "  Factura de Venta N° : " + xnfactura + "'  )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xmodelo.getValueAt(y, 4).toString() + "','1','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "','0',round(" + this.xmodelo.getValueAt(y, 2) + "),'" + xconcepto + "  Factura de Venta N° : " + xnfactura + "' )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "SELECT `cc_puc`.`Id`\n    , `cc_puc`.`Nbre`\n    , `cc_puc`.`PBase` ,cc_puc.`Tipo`, `g_empresa`.`Id`, IF(cc_puc.`Tipo`=0, ((" + this.xmodelo.getValueAt(y, 2) + "*`cc_puc`.`PBase`)/100), 0) VDebito\n    , IF(cc_puc.`Tipo`=1, ((" + this.xmodelo.getValueAt(y, 2) + "*`cc_puc`.`PBase`)/100), 0) VCredito\nFROM\n     `cc_impuestoxempresa`\n    INNER JOIN  `cc_valorxtipo_impuesto` \n        ON (`cc_impuestoxempresa`.`Id_Impuesto` = `cc_valorxtipo_impuesto`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`cc_impuestoxempresa`.`Id_Empresa` = `g_empresa`.`Id`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_valorxtipo_impuesto`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`cc_impuestoxempresa`.`Filtro` =1 AND `g_empresa`.`Id`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "')";
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet xrs2 = xct1.traerRs(this.xsql);
                Throwable th = null;
                try {
                    try {
                        if (xrs2.next()) {
                            xrs2.beforeFirst();
                            while (xrs2.next()) {
                                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito,`PRetencion` , `Base`, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + xrs2.getString("Id") + "','" + xrs2.getString("Tipo") + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "','" + xrs2.getDouble("VDebito") + "','" + xrs2.getDouble("VCredito") + "','" + xrs2.getDouble("PBase") + "',round(" + this.xmodelo.getValueAt(y, 2) + "),'" + xconcepto + "  Factura de Venta N° : " + xnfactura + "' )";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                            }
                        }
                        if (xrs2 != null) {
                            if (0 != 0) {
                                try {
                                    xrs2.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                xrs2.close();
                            }
                        }
                        xct1.cerrarConexionBd();
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFCuentaCobroCapitacionServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.gcuenta.crearDocumentoContableInterfaz(this.JTFFNDoc.getText());
        }
        this.xsql = "update f_factura_evento set Id_DocumentoC='" + this.JTFFNDoc.getText() + "' where  CONCAT(Prefijo,'',No_FacturaEvento_M)  ='" + this.JTFFNFacturaEvento.getText() + "'";
        ConsultasMySQL xct = new ConsultasMySQL();
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.gcuenta = (GCuentaDAOImpl) classPathXmlApplicationContext.getBean("gCuentaDAOImpl");
        this.contabilidad = (ContabilidadDAOImpl) classPathXmlApplicationContext.getBean("contabilidadDAOImpl");
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x06b1: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:57:0x06b1 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x06b5: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:59:0x06b5 */
    private void mGenerarDocContable_Evento() {
        String xIdTercero;
        try {
            try {
                this.xsql = "SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))) AS FacturaE , f_subgruposervicio.`Nbre` AS Subgrupo, IF(SUM(f_liquidacion.TotalEps)=0,SUM(f_liquidacion.TotalPaciente), SUM(f_liquidacion.TotalEps)) AS TotalEps, f_subgrupo_empresa.`CPuc_Debito`, f_subgrupo_empresa.`CPuc_Credito`, f_factura_evento.No_FacturaEvento \n, g_persona.`Id_TipoIdentificacion`, g_persona.`NoDocumento`, f_empresacontxconvenio.`Id_TipoPlan`, f_empresacontxconvenio.`Nbre`, ingreso.`Id_Usuario`\nFROM\n     `f_factura_evento`\n    INNER JOIN  `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n    INNER JOIN  `f_subgrupo_empresa` \n        ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `f_subgruposervicio` \n        ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n    INNER JOIN  `f_gruposervicio` \n        ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_factura_evento.No_CuentaCobro='" + this.JTFFNCuentaCobro.getText() + "') GROUP BY f_factura_evento.No_FacturaEvento";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante,NConsecutivo, Id_CuentaCobro, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + xrs.getString("No_FacturaEvento") + "','" + this.JTFFNCuentaCobro.getText() + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','" + xrs.getString(2) + " Factura Venta N° " + xrs.getString(1) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.JTFFNDoc.setText(xct1.ejecutarSQLId(this.xsql));
                        xct1.cerrarConexionBd();
                        if (xrs.getInt("Id_TipoPlan") == 4) {
                            xIdTercero = this.xmt.mCrearTercero_GEmpresa(xrs.getString("Id_Usuario"), xrs.getString("Id_TipoIdentificacion"), xrs.getString("NoDocumento"));
                            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + xrs.getString(4) + "','0','" + xIdTercero + "','0','" + xrs.getString(1) + "',round(" + xrs.getDouble(3) + "),'0','" + xrs.getString(2) + "  Factura de Venta N° : " + xrs.getString(1) + "'  )";
                            xct1.ejecutarSQL(this.xsql);
                            xct1.cerrarConexionBd();
                            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + xrs.getString(5) + "','1','" + xIdTercero + "','0','" + xrs.getString(1) + "','0',round(" + xrs.getDouble(3) + "),'" + xrs.getString(2) + "  Factura de Venta N° : " + xrs.getString(1) + "' )";
                            xct1.ejecutarSQL(this.xsql);
                            xct1.cerrarConexionBd();
                            this.xsql = "update f_factura_evento set Id_DocumentoC='" + this.JTFFNDoc.getText() + "' where No_FacturaEvento='" + xrs.getString(6) + "'";
                            xct1.ejecutarSQL(this.xsql);
                            xct1.cerrarConexionBd();
                        } else {
                            xIdTercero = this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2];
                            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + xrs.getString(4) + "','0','" + xIdTercero + "','0','" + xrs.getString(1) + "',round(" + xrs.getDouble(3) + "),'0','" + xrs.getString(2) + "  Factura de Venta N° : " + xrs.getString(1) + "'  )";
                            xct1.ejecutarSQL(this.xsql);
                            xct1.cerrarConexionBd();
                            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + xrs.getString(5) + "','1','" + xIdTercero + "','0','" + xrs.getString(1) + "','0',round(" + xrs.getDouble(3) + "),'" + xrs.getString(2) + "  Factura de Venta N° : " + xrs.getString(1) + "' )";
                            xct1.ejecutarSQL(this.xsql);
                            xct1.cerrarConexionBd();
                            this.xsql = "update f_factura_evento set Id_DocumentoC='" + this.JTFFNDoc.getText() + "' where No_FacturaEvento='" + xrs.getString(6) + "'";
                            xct1.ejecutarSQL(this.xsql);
                            xct1.cerrarConexionBd();
                        }
                        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                            this.gcuenta.crearDocumentoContableInterfaz(this.JTFFNDoc.getText());
                        }
                        this.xsql = "SELECT `cc_puc`.`Id`\n    , `cc_puc`.`Nbre`\n    , `cc_puc`.`PBase` ,cc_puc.`Tipo`, `g_empresa`.`Id`, IF(cc_puc.`Tipo`=0, round((" + xrs.getDouble(3) + "*`cc_puc`.`PBase`)/100), 0) VDebito\n    , IF(cc_puc.`Tipo`=1, round((" + xrs.getDouble(3) + "*`cc_puc`.`PBase`)/100), 0) VCredito\nFROM\n     `cc_impuestoxempresa`\n    INNER JOIN  `cc_valorxtipo_impuesto` \n        ON (`cc_impuestoxempresa`.`Id_Impuesto` = `cc_valorxtipo_impuesto`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`cc_impuestoxempresa`.`Id_Empresa` = `g_empresa`.`Id`)\n    INNER JOIN  `cc_puc` \n        ON (`cc_valorxtipo_impuesto`.`Id_Puc` = `cc_puc`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`cc_impuestoxempresa`.`Filtro` =1 and cc_impuestoxempresa.Estado=1 AND `g_empresa`.`Id`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "' ) GROUP BY `cc_puc`.`Id` ";
                        ConsultasMySQL xct2 = new ConsultasMySQL();
                        ResultSet xrs2 = xct2.traerRs(this.xsql);
                        Throwable th2 = null;
                        try {
                            try {
                                if (xrs2.next()) {
                                    xrs2.beforeFirst();
                                    while (xrs2.next()) {
                                        ConsultasMySQL xct3 = new ConsultasMySQL();
                                        this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito,`PRetencion` , `Base`, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + xrs2.getString("Id") + "','" + xrs2.getString("Tipo") + "','" + xIdTercero + "','0','" + xrs.getString(1) + "','" + xrs2.getDouble("VDebito") + "','" + xrs2.getDouble("VCredito") + "','" + xrs2.getDouble("PBase") + "',round(" + xrs.getDouble(3) + "),'" + xrs.getString(2) + "  Factura de Venta N° : " + xrs.getString(1) + "' )";
                                        xct3.ejecutarSQL(this.xsql);
                                        xct3.cerrarConexionBd();
                                    }
                                }
                                if (xrs2 != null) {
                                    if (0 != 0) {
                                        try {
                                            xrs2.close();
                                        } catch (Throwable th3) {
                                            th2.addSuppressed(th3);
                                        }
                                    } else {
                                        xrs2.close();
                                    }
                                }
                                xct2.cerrarConexionBd();
                            } catch (Throwable th4) {
                                if (xrs2 != null) {
                                    if (th2 != null) {
                                        try {
                                            xrs2.close();
                                        } catch (Throwable th5) {
                                            th2.addSuppressed(th5);
                                        }
                                    } else {
                                        xrs2.close();
                                    }
                                }
                                throw th4;
                            }
                        } catch (Throwable th6) {
                            th2 = th6;
                            throw th6;
                        }
                    }
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th7) {
                            th.addSuppressed(th7);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCuentaCobroCapitacionServicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGenerarDoc_Presupuesto() {
        this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,NoFact, IdDocContable, IdUsuarioR,`UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.JTAConcepto.getText() + " CUENTA DE COBRO N° " + this.JTFFNCuentaCobro.getText() + "','" + this.JTFFNFacturaEvento.getText() + "','" + this.JTFFNDoc.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
        this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
        this.xct.cerrarConexionBd();
        this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado, `Id_Tercero`,Valor,NCCobro, NFactura, Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][1] + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','" + this.JTFFTotalEps.getValue() + "','" + this.JTFFNCuentaCobro.getText() + "','" + this.JTFFNFacturaEvento.getText() + "','" + this.JTAConcepto.getText() + " CUENTA DE COBRO N° " + this.JTFFNCuentaCobro.getText() + "');";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mGenerarFacturaEvento() {
        mValidaResolucionDian(false);
        String sql = "insert into f_liquidacion (TotalServicio, TotalEps, TotalDescuento, TotalPaciente, CuotaModeradora, Copago, Id_SubGrupoServicio, IdEmpresaContxConv, NEquipo, DireccionIp, Estado, IdFormaPago,Fecha, UsuarioS )  values ('" + this.JTFFTotalServicio.getValue() + "','" + this.JTFFTotalEps.getValue() + "','" + this.JTFFTotalDescuento.getValue() + "','" + this.JTFFTotalPaciente.getValue() + "','" + this.JTFFTotalCModeradora.getValue() + "','" + this.JTFFTotalCopago.getValue() + "','" + this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][0] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "','" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','0','" + this.tipoDePago.get(this.JCBTipoPago.getSelectedIndex()).getId() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xidliquidacion = this.xct.ejecutarSQLId(sql);
        this.xct.cerrarConexionBd();
        String sql2 = "insert into f_cuentacobro(Id_PeriodoC, IdGrupoServicio, IdEmpContxConv, Periodo_Fact, Periodo_Fact1, TotalServicio, TotalCuotaM, TotalCopago, TotalDesc, TotalNeto, NoRegistros, Fecha, UsuarioS)  values('" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "','" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "','" + this.JTFFTotalServicio.getValue() + "','" + this.JTFFTotalCModeradora.getValue() + "','" + this.JTFFTotalCopago.getValue() + "','" + this.JTFFTotalDescuento.getValue() + "','" + this.JTFFTotalEps.getValue() + "','" + this.JTBResultado.getValueAt(0, 0) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xcuentacobro = this.xct.ejecutarSQLId(sql2);
        this.xct.cerrarConexionBd();
        String sql3 = "insert into f_factura_evento(Fecha_FacturaEvento, Prefijo, No_FacturaEvento_M , Id_Liquidacion, idResolucionDian, idMedioPago , EstaArmada, No_CuentaCobro, ConceptoCobro, Sede, Fecha, UsuarioS)  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActualPC()) + "','" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "','" + xidliquidacion + "','" + this.resolucionDian.getId() + "','" + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + "','2','" + xcuentacobro + "',replace('" + this.JTAConcepto.getText() + "', '\n', ' '),'" + this.xsede + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xnfacturaevento = this.xct.ejecutarSQLId(sql3);
        this.xct.cerrarConexionBd();
        Principal.clasegeneral.mActualizar_ResolucionDian(xnfacturaevento, this.xidempresa[this.JCBEmpresa.getSelectedIndex()][3]);
        String sql4 = "insert into f_detalle_facturaevento (No_FacturaEvento, Concepto, Total ) values('" + xnfacturaevento + "','" + this.JCBGrupo.getSelectedItem() + "','" + this.JTFFTotalEps.getValue() + "')";
        this.xct.ejecutarSQL(sql4);
        this.xct.cerrarConexionBd();
        this.JTFFNFacturaEvento.setValue(new Long(xnfacturaevento));
        this.JTFFNCuentaCobro.setValue(new Long(xcuentacobro));
        String sql5 = "UPDATE f_factura_capita, `v_f_tmp1` SET f_factura_capita.EstaArmada=2, f_factura_capita.No_FacturaEvento='" + xnfacturaevento + "' WHERE f_factura_capita.`No_FacturaCapita`=v_f_tmp1.NFactura ";
        this.xct.ejecutarSQL(sql5);
        this.xct.cerrarConexionBd();
        this.xsql = "SELECT concat(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento_M) FROM `f_factura_evento` WHERE (`No_FacturaEvento` ='" + xnfacturaevento + "') ";
        this.JTFFNFacturaEvento.setText("" + this.xct.traerDato(this.xsql));
        if (this.JCH_AplicaMC.isSelected()) {
            mGenerarDocContable(xcuentacobro);
        }
        if (this.JCH_AplicaMP.isSelected()) {
            mGenerarDoc_Presupuesto();
        }
        int idLiquidacion = 0;
        try {
            ResultSet xrs = this.xct.traerRs("SELECT Id FROM f_liquidacion WHERE Id =(SELECT MAX(Id) FROM `f_liquidacion`)");
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        idLiquidacion = xrs.getInt(1);
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCuentaCobroCapitacionGlobalT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        System.out.println("idLiquidacion -> " + idLiquidacion);
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") && this.JCBMedioDePago.getSelectedItem().equals("EFECTIVO")) {
            insertarProcedureFFacturaPagos(idLiquidacion);
        }
        JOptionPane.showInternalMessageDialog(this, "Se guardo con exito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void insertarProcedureFFacturaPagos(int idLiquidacion) {
        System.out.println("idLiquidacioon -> " + idLiquidacion);
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            CallableStatement cs = xct.establecerConexionBd().prepareCall("{CALL `insertarFFPagos`('" + idLiquidacion + "')}");
            cs.execute();
            JOptionPane.showMessageDialog((Component) null, "Se realizó el pago correctamente");
            cs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimirCuentaFactura() {
        if (!this.JTFFNCuentaCobro.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            String[][] mparametros1 = new String[3][2];
            mparametros[0][0] = "idcuenta";
            mparametros[0][1] = this.JTFFNCuentaCobro.getText();
            mparametros[1][0] = "valorletra";
            mparametros[1][1] = this.xmt.mConvertirNumeroLetras(this.JTFFTotalEps.getValue().toString());
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros1[0][0] = "idcuenta";
            mparametros1[0][1] = this.JTFFNCuentaCobro.getText();
            mparametros1[1][0] = "SUBREPORT_DIR";
            mparametros1[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros1[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros1[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.xid == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_CuentadeCobro", mparametros);
                String[][] mparametros2 = new String[4][2];
                mparametros2[0][0] = "nfactura";
                mparametros2[0][1] = this.JTFFNCuentaCobro.getText();
                mparametros2[1][0] = "valorletra";
                mparametros2[1][1] = this.xmt.mConvertirNumeroLetras(this.JTFFTotalEps.getValue().toString());
                mparametros2[2][0] = "SUBREPORT_DIR";
                mparametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros2[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_FacturaDianConsolidada", mparametros2);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_RelacionFacturasCapita", mparametros1);
                return;
            }
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_CuentadeCobroEventoS", mparametros);
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_RelacionFacturasEventoS", mparametros1);
        }
    }

    private void mGenerarCuentaCobro() {
        String sql = "insert into f_cuentacobro(Id_PeriodoC, IdGrupoServicio, IdEmpContxConv, Periodo_Fact,Periodo_Fact1, TotalServicio, TotalCuotaM, TotalCopago, TotalDesc, TotalNeto, NoRegistros, ConceptoCobro, Fecha, UsuarioS)  values('" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "','" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "','" + this.JTFFTotalServicio.getValue() + "','" + this.JTFFTotalCModeradora.getValue() + "','" + this.JTFFTotalCopago.getValue() + "','" + this.JTFFTotalDescuento.getValue() + "','" + this.JTFFTotalEps.getValue() + "','" + this.JTBResultado.getValueAt(0, 0) + "','" + this.JTAConcepto.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xcuentacobro = this.xct.ejecutarSQLId(sql);
        this.xct.cerrarConexionBd();
        this.JTFFNCuentaCobro.setText(xcuentacobro);
        String sql2 = "UPDATE f_factura_evento , ( SELECT f_factura_evento.No_FacturaEvento\nFROM  f_factura_evento \nINNER JOIN  f_liquidacion  ON  (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  \nINNER JOIN f_subgrupo_empresa ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id) \nINNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) \nINNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) \nINNER JOIN ingreso  ON (ingreso.Id_EmpresaContxConv = f_subgrupo_empresa.Id_Empresa) AND (ingreso.Id = f_liquidacion.Id_Ingreso) \nWHERE (f_factura_evento.Fecha_FacturaEvento>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "'\nAND f_factura_evento.Fecha_FacturaEvento<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "'\nAND f_factura_evento.EstaArmada =1 AND f_gruposervicio.Id_GrupoServicio ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "'\nAND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_factura_evento.Estado = 0\nAND f_liquidacion.Estado = 0 AND ingreso.Estado = 0 AND f_factura_evento.No_CuentaCobro=0) \nGROUP BY  f_factura_evento.No_FacturaEvento) D\n   SET f_factura_evento.`No_CuentaCobro`='" + xcuentacobro + "', f_factura_evento.`EstaArmada`=2 WHERE f_factura_evento.`No_FacturaEvento`=D.No_FacturaEvento";
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        if (this.JCH_AplicaMC.isSelected()) {
            mGenerarDocContable_Evento();
        }
        if (this.JCH_AplicaMP.isSelected()) {
            mGenerarDoc_Presupuesto();
        }
    }

    private void mCrearVistasMaestra() {
        this.xsql = "DROP VIEW IF EXISTS v_f_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_f_tmp`  AS SELECT `f_liquidacion`.`Id` AS `IdLiquidacion`, `f_factura_capita`.`No_FacturaCapita` AS `NFactura`, `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`, `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo` , `f_gruposervicio`.`Nbre` AS `NGrupo`, `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`, `f_subgruposervicio`.`Nbre` AS `NSubgrupo`, `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`, `f_liquidacion`.`TotalServicio`, `f_liquidacion`.`TotalPlan` , `f_liquidacion`.`TotalEps`, `f_liquidacion`.`TotalDescuento`, `f_liquidacion`.`TotalPaciente`, `f_liquidacion`.`CuotaModeradora`, `f_liquidacion`.`Copago`, `ingreso`.`Id_Sede` AS `IdSede`, `f_subgrupo_empresa`.`CPuc_Debito` , `f_subgrupo_empresa`.`CPuc_Credito`, f_subgrupo_empresa.`IdRubro` AS CodRubro FROM `ingreso` INNER JOIN  `f_liquidacion`   ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) WHERE (`f_factura_capita`.`Fecha_FacturaCapita` >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `f_factura_capita`.`Fecha_FacturaCapita` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND `f_factura_capita`.`Estado` =0 AND `f_liquidacion`.`Estado` =0 AND `ingreso`.`Id_EmpresaContxConv` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `f_factura_capita`.`EstaArmada` =1)";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mCrearVistasDetalle() {
        this.xsql = "DROP VIEW IF EXISTS v_f_tmp1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (this.JCHLimitar.isSelected()) {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                this.xsql = "CREATE VIEW  `v_f_tmp1`  AS SELECT\n  `f_liquidacion`.`Id` AS `IdLiquidacion`,\n  `f_factura_capita`.`No_FacturaCapita` AS `NFactura`,\n  `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`,\n  `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`,\n  `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo`,\n  `f_gruposervicio`.`Nbre` AS `NGrupo`,\n  `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`,\n  `f_subgruposervicio`.`Nbre` AS `NSubgrupo`,\n  `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`,\n  `f_liquidacion`.`TotalServicio`,\n  `f_liquidacion`.`TotalPlan`,\n  `f_liquidacion`.`TotalEps`,\n  `f_liquidacion`.`TotalDescuento`,\n  `f_liquidacion`.`TotalPaciente`,\n  `f_liquidacion`.`CuotaModeradora`,\n  `f_liquidacion`.`Copago`,\n  `ingreso`.`Id_Sede` AS `IdSede`,\n    d.CCredito, \n    d.CDebito,\n  f_subgrupo_empresa.`IdRubro` AS CodRubro\nFROM\n  `ingreso`\n  INNER JOIN `f_liquidacion`\n    ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n  INNER JOIN `f_subgrupo_empresa`\n    ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `f_subgruposervicio`\n    ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n  INNER JOIN `f_gruposervicio`\n    ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)\n  INNER JOIN `f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  INNER JOIN `g_empresacont`\n    ON (\n      `f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`\n    )\n    INNER  JOIN  (\n    \n      SELECT f_liquidacion.`Id` AS idliquidacion  , f_procedimcentrocosto.`CCredito` , f_procedimcentrocosto.`CDebito` FROM f_liquidacion \n      INNER JOIN  ingreso ON f_liquidacion.`Id_Ingreso`=ingreso.`Id`\n      INNER JOIN `f_ordenes`ON    ingreso.`Id`=`f_ordenes`.`Id_Ingreso`\n      INNER JOIN `f_itemordenesproced` ON f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`\n      INNER JOIN `f_procedimcentrocosto` ON f_itemordenesproced.`Id_Procedimiento`=f_procedimcentrocosto.`Id_Procedimiento`\n      INNER JOIN  f_centrocosto ON f_procedimcentrocosto.`Id_CentroCosto`=`f_centrocosto`.`Id`\n      INNER JOIN  `g_procedimiento` ON  f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`\n    \n    )  d ON d.idliquidacion = f_liquidacion.`Id`\nWHERE (\n    `f_gruposervicio`.`Id_GrupoServicio` = '" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` >= '" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` <= '" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'\n    AND `f_factura_capita`.`Estado` = 0\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`Id_EmpresaContxConv` = '" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`EstaArmada` = 1\n  )LIMIT " + this.JSPNRegistro.getValue() + "";
            } else {
                this.xsql = "CREATE VIEW  `v_f_tmp1`  AS SELECT `f_liquidacion`.`Id` AS `IdLiquidacion`, `f_factura_capita`.`No_FacturaCapita` AS `NFactura`, `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`, `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo` , `f_gruposervicio`.`Nbre` AS `NGrupo`, `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`, `f_subgruposervicio`.`Nbre` AS `NSubgrupo`, `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`, `f_liquidacion`.`TotalServicio`, `f_liquidacion`.`TotalPlan` , `f_liquidacion`.`TotalEps`, `f_liquidacion`.`TotalDescuento`, `f_liquidacion`.`TotalPaciente`, `f_liquidacion`.`CuotaModeradora`, `f_liquidacion`.`Copago`, `ingreso`.`Id_Sede` AS `IdSede`, `f_subgrupo_empresa`.`CPuc_Debito` , `f_subgrupo_empresa`.`CPuc_Credito`,f_subgrupo_empresa.`IdRubro` AS CodRubro  FROM `ingreso` INNER JOIN  `f_liquidacion`   ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) WHERE (`f_gruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND `f_factura_capita`.`Fecha_FacturaCapita` >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `f_factura_capita`.`Fecha_FacturaCapita` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND `f_factura_capita`.`Estado` =0 AND `f_liquidacion`.`Estado` =0 AND `ingreso`.`Id_EmpresaContxConv` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `f_factura_capita`.`EstaArmada` =1) LIMIT " + this.JSPNRegistro.getValue() + "";
            }
        } else if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            System.out.println("nueva val------->" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0]);
            if (!this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0].equals("3694")) {
                this.xsql = "CREATE VIEW  `v_f_tmp1`  AS SELECT\n  `f_liquidacion`.`Id` AS `IdLiquidacion`,\n  `f_factura_capita`.`No_FacturaCapita` AS `NFactura`,\n  `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`,\n  `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`,\n  `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo`,\n  `f_gruposervicio`.`Nbre` AS `NGrupo`,\n  `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`,\n  `f_subgruposervicio`.`Nbre` AS `NSubgrupo`,\n  `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`,\n  `f_liquidacion`.`TotalServicio`,\n  `f_liquidacion`.`TotalPlan`,\n  `f_liquidacion`.`TotalEps`,\n  `f_liquidacion`.`TotalDescuento`,\n  `f_liquidacion`.`TotalPaciente`,\n  `f_liquidacion`.`CuotaModeradora`,\n  `f_liquidacion`.`Copago`,\n  `ingreso`.`Id_Sede` AS `IdSede`,\n    d.CCredito, \n    d.CDebito,\n  f_subgrupo_empresa.`IdRubro` AS CodRubro\nFROM\n  `ingreso`\n  INNER JOIN `f_liquidacion`\n    ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n  INNER JOIN `f_subgrupo_empresa`\n    ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `f_subgruposervicio`\n    ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n  INNER JOIN `f_gruposervicio`\n    ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)\n  INNER JOIN `f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  INNER JOIN `g_empresacont`\n    ON (\n      `f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`\n    )\n    INNER  JOIN  (\n    \n      SELECT f_liquidacion.`Id` AS idliquidacion  , f_procedimcentrocosto.`CCredito` , f_procedimcentrocosto.`CDebito` FROM f_liquidacion \n      INNER JOIN  ingreso ON f_liquidacion.`Id_Ingreso`=ingreso.`Id`\n      INNER JOIN `f_ordenes`ON    ingreso.`Id`=`f_ordenes`.`Id_Ingreso`\n      INNER JOIN `f_itemordenesproced` ON f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`\n      INNER JOIN `f_procedimcentrocosto` ON f_itemordenesproced.`Id_Procedimiento`=f_procedimcentrocosto.`Id_Procedimiento`\n      INNER JOIN  f_centrocosto ON f_procedimcentrocosto.`Id_CentroCosto`=`f_centrocosto`.`Id`\n      INNER JOIN  `g_procedimiento` ON  f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`\n    \n    )  d ON d.idliquidacion = f_liquidacion.`Id`\nWHERE (\n    `f_gruposervicio`.`Id_GrupoServicio` = '" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` >= '" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` <= '" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'\n    AND `f_factura_capita`.`Estado` = 0\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`Id_EmpresaContxConv` = '" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`EstaArmada` = 1\n  ) GROUP BY `f_gruposervicio`.`Id_GrupoServicio`";
            } else {
                this.xsql = "CREATE VIEW  `v_f_tmp1`  AS SELECT\n  `f_liquidacion`.`Id` AS `IdLiquidacion`,\n  `f_factura_capita`.`No_FacturaCapita` AS `NFactura`,\n  `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`,\n  `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`,\n  `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo`,\n  `f_gruposervicio`.`Nbre` AS `NGrupo`,\n  `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`,\n  `f_subgruposervicio`.`Nbre` AS `NSubgrupo`,\n  `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`,\n  `f_liquidacion`.`TotalServicio`,\n  `f_liquidacion`.`TotalPlan`,\n  `f_liquidacion`.`TotalEps`,\n  `f_liquidacion`.`TotalDescuento`,\n  `f_liquidacion`.`TotalPaciente`,\n  `f_liquidacion`.`CuotaModeradora`,\n  `f_liquidacion`.`Copago`,\n  `ingreso`.`Id_Sede` AS `IdSede`,\n    d.CCredito, \n    d.CDebito,\n  f_subgrupo_empresa.`IdRubro` AS CodRubro\nFROM\n  `ingreso`\n  INNER JOIN `f_liquidacion`\n    ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n  INNER JOIN `f_subgrupo_empresa`\n    ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `f_subgruposervicio`\n    ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n  INNER JOIN `f_gruposervicio`\n    ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)\n  INNER JOIN `f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  INNER JOIN `g_empresacont`\n    ON (\n      `f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`\n    )\n    INNER  JOIN  (\n    \n      SELECT f_liquidacion.`Id` AS idliquidacion  , f_procedimcentrocosto.`CCredito` , f_procedimcentrocosto.`CDebito` FROM f_liquidacion \n      INNER JOIN  ingreso ON f_liquidacion.`Id_Ingreso`=ingreso.`Id`\n      INNER JOIN `f_ordenes`ON    ingreso.`Id`=`f_ordenes`.`Id_Ingreso`\n      INNER JOIN `f_itemordenesproced` ON f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`\n      INNER JOIN `f_procedimcentrocosto` ON f_itemordenesproced.`Id_Procedimiento`=f_procedimcentrocosto.`Id_Procedimiento`\n      INNER JOIN  f_centrocosto ON f_procedimcentrocosto.`Id_CentroCosto`=`f_centrocosto`.`Id`\n      INNER JOIN  `g_procedimiento` ON  f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`\n    \n    )  d ON d.idliquidacion = f_liquidacion.`Id`\nWHERE (\n    `f_gruposervicio`.`Id_GrupoServicio` = '" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` >= '" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` <= '" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'\n    AND `f_factura_capita`.`Estado` = 0\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`Id_EmpresaContxConv` = '" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`EstaArmada` = 1\n  ) GROUP BY `f_factura_capita`.`No_FacturaCapita`,`f_gruposervicio`.`Id_GrupoServicio` ";
            }
        } else {
            this.xsql = "CREATE VIEW  `v_f_tmp1`  AS SELECT `f_liquidacion`.`Id` AS `IdLiquidacion`, `f_factura_capita`.`No_FacturaCapita` AS `NFactura`, `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`, `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo` , `f_gruposervicio`.`Nbre` AS `NGrupo`, `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`, `f_subgruposervicio`.`Nbre` AS `NSubgrupo`, `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`, `f_liquidacion`.`TotalServicio`, `f_liquidacion`.`TotalPlan` , `f_liquidacion`.`TotalEps`, `f_liquidacion`.`TotalDescuento`, `f_liquidacion`.`TotalPaciente`, `f_liquidacion`.`CuotaModeradora`, `f_liquidacion`.`Copago`, `ingreso`.`Id_Sede` AS `IdSede`, `f_subgrupo_empresa`.`CPuc_Debito` , `f_subgrupo_empresa`.`CPuc_Credito`, f_subgrupo_empresa.`IdRubro` AS CodRubro FROM `ingreso` INNER JOIN  `f_liquidacion`   ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) WHERE (`f_gruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND `f_factura_capita`.`Fecha_FacturaCapita` >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `f_factura_capita`.`Fecha_FacturaCapita` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND `f_factura_capita`.`Estado` =0 AND `f_liquidacion`.`Estado` =0 AND `ingreso`.`Id_EmpresaContxConv` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `f_factura_capita`.`EstaArmada` =1)";
        }
        System.out.println("vista v_f_tmp1 -> " + this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mCrearVistasDetalleSede() {
        this.xsql = "DROP VIEW IF EXISTS v_f_tmp1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (this.JCHLimitar.isSelected()) {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                this.xsql = "CREATE VIEW  `v_f_tmp1`  AS SELECT\n  `f_liquidacion`.`Id` AS `IdLiquidacion`,\n  `f_factura_capita`.`No_FacturaCapita` AS `NFactura`,\n  `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`,\n  `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`,\n  `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo`,\n  `f_gruposervicio`.`Nbre` AS `NGrupo`,\n  `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`,\n  `f_subgruposervicio`.`Nbre` AS `NSubgrupo`,\n  `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`,\n  `f_liquidacion`.`TotalServicio`,\n  `f_liquidacion`.`TotalPlan`,\n  `f_liquidacion`.`TotalEps`,\n  `f_liquidacion`.`TotalDescuento`,\n  `f_liquidacion`.`TotalPaciente`,\n  `f_liquidacion`.`CuotaModeradora`,\n  `f_liquidacion`.`Copago`,\n  `ingreso`.`Id_Sede` AS `IdSede`,\n    d.CCredito, \n    d.CDebito,\n  f_subgrupo_empresa.`IdRubro` AS CodRubro\nFROM\n  `ingreso`\n  INNER JOIN `f_liquidacion`\n    ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n  INNER JOIN `f_subgrupo_empresa`\n    ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `f_subgruposervicio`\n    ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n  INNER JOIN `f_gruposervicio`\n    ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)\n  INNER JOIN `f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  INNER JOIN `g_empresacont`\n    ON (\n      `f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`\n    )\n    INNER  JOIN  (\n    \n      SELECT f_liquidacion.`Id` AS idliquidacion  , f_procedimcentrocosto.`CCredito` , f_procedimcentrocosto.`CDebito` FROM f_liquidacion \n      INNER JOIN  ingreso ON f_liquidacion.`Id_Ingreso`=ingreso.`Id`\n      INNER JOIN `f_ordenes`ON    ingreso.`Id`=`f_ordenes`.`Id_Ingreso`\n      INNER JOIN `f_itemordenesproced` ON f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`\n      INNER JOIN `f_procedimcentrocosto` ON f_itemordenesproced.`Id_Procedimiento`=f_procedimcentrocosto.`Id_Procedimiento`\n      INNER JOIN  f_centrocosto ON f_procedimcentrocosto.`Id_CentroCosto`=`f_centrocosto`.`Id`\n      INNER JOIN  `g_procedimiento` ON  f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`\n    \n    )  d ON d.idliquidacion = f_liquidacion.`Id`\nWHERE (\n `ingreso`.`Id_Sede` = '" + this.xidsede[this.JCBSede.getSelectedIndex()] + "'   AND  `f_gruposervicio`.`Id_GrupoServicio` = '" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` >= '" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` <= '" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'\n    AND `f_factura_capita`.`Estado` = 0\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`Id_EmpresaContxConv` = '" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`EstaArmada` = 1\n  )LIMIT " + this.JSPNRegistro.getValue() + "";
            } else {
                this.xsql = "CREATE VIEW  `v_f_tmp1`  AS SELECT `f_liquidacion`.`Id` AS `IdLiquidacion`, `f_factura_capita`.`No_FacturaCapita` AS `NFactura`, `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`, `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo` , `f_gruposervicio`.`Nbre` AS `NGrupo`, `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`, `f_subgruposervicio`.`Nbre` AS `NSubgrupo`, `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`, `f_liquidacion`.`TotalServicio`, `f_liquidacion`.`TotalPlan` , `f_liquidacion`.`TotalEps`, `f_liquidacion`.`TotalDescuento`, `f_liquidacion`.`TotalPaciente`, `f_liquidacion`.`CuotaModeradora`, `f_liquidacion`.`Copago`, `ingreso`.`Id_Sede` AS `IdSede`, `f_subgrupo_empresa`.`CPuc_Debito` , `f_subgrupo_empresa`.`CPuc_Credito`, f_subgrupo_empresa.`IdRubro` AS CodRubro FROM `ingreso` INNER JOIN  `f_liquidacion`   ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) WHERE (`ingreso`.`Id_Sede`='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' and  `f_gruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND `f_factura_capita`.`Fecha_FacturaCapita` >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `f_factura_capita`.`Fecha_FacturaCapita` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND `f_factura_capita`.`Estado` =0 AND `f_liquidacion`.`Estado` =0 AND `ingreso`.`Id_EmpresaContxConv` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `f_factura_capita`.`EstaArmada` =1) LIMIT " + this.JSPNRegistro.getValue() + "";
            }
        } else if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.xsql = "CREATE VIEW  `v_f_tmp1`  AS SELECT\n  `f_liquidacion`.`Id` AS `IdLiquidacion`,\n  `f_factura_capita`.`No_FacturaCapita` AS `NFactura`,\n  `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`,\n  `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`,\n  `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo`,\n  `f_gruposervicio`.`Nbre` AS `NGrupo`,\n  `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`,\n  `f_subgruposervicio`.`Nbre` AS `NSubgrupo`,\n  `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`,\n  `f_liquidacion`.`TotalServicio`,\n  `f_liquidacion`.`TotalPlan`,\n  `f_liquidacion`.`TotalEps`,\n  `f_liquidacion`.`TotalDescuento`,\n  `f_liquidacion`.`TotalPaciente`,\n  `f_liquidacion`.`CuotaModeradora`,\n  `f_liquidacion`.`Copago`,\n  `ingreso`.`Id_Sede` AS `IdSede`,\n    d.CCredito, \n    d.CDebito,\n  f_subgrupo_empresa.`IdRubro` AS CodRubro\nFROM\n  `ingreso`\n  INNER JOIN `f_liquidacion`\n    ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n  INNER JOIN `f_subgrupo_empresa`\n    ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `f_subgruposervicio`\n    ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n  INNER JOIN `f_gruposervicio`\n    ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)\n  INNER JOIN `f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  INNER JOIN `g_empresacont`\n    ON (\n      `f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`\n    )\n    INNER  JOIN  (\n    \n      SELECT f_liquidacion.`Id` AS idliquidacion  , f_procedimcentrocosto.`CCredito` , f_procedimcentrocosto.`CDebito` FROM f_liquidacion \n      INNER JOIN  ingreso ON f_liquidacion.`Id_Ingreso`=ingreso.`Id`\n      INNER JOIN `f_ordenes`ON    ingreso.`Id`=`f_ordenes`.`Id_Ingreso`\n      INNER JOIN `f_itemordenesproced` ON f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`\n      INNER JOIN `f_procedimcentrocosto` ON f_itemordenesproced.`Id_Procedimiento`=f_procedimcentrocosto.`Id_Procedimiento`\n      INNER JOIN  f_centrocosto ON f_procedimcentrocosto.`Id_CentroCosto`=`f_centrocosto`.`Id`\n      INNER JOIN  `g_procedimiento` ON  f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`\n    \n    )  d ON d.idliquidacion = f_liquidacion.`Id`\nWHERE (\n  `ingreso`.`Id_Sede`='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' and     `f_gruposervicio`.`Id_GrupoServicio` = '" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` >= '" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "'\n    AND `f_factura_capita`.`Fecha_FacturaCapita` <= '" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'\n    AND `f_factura_capita`.`Estado` = 0\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`Id_EmpresaContxConv` = '" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'\n    AND `f_factura_capita`.`EstaArmada` = 1\n  ) GROUP BY `f_gruposervicio`.`Id_GrupoServicio` ";
        } else {
            this.xsql = "CREATE VIEW  `v_f_tmp1`  AS SELECT `f_liquidacion`.`Id` AS `IdLiquidacion`, `f_factura_capita`.`No_FacturaCapita` AS `NFactura`, `f_empresacontxconvenio`.`Id` AS `IdEmpresaConv`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConv`, `f_gruposervicio`.`Id_GrupoServicio` AS `IdGrupo` , `f_gruposervicio`.`Nbre` AS `NGrupo`, `f_subgruposervicio`.`Id_SubgrupoServicio` AS `IdSubgrupo`, `f_subgruposervicio`.`Nbre` AS `NSubgrupo`, `f_subgrupo_empresa`.`Id` AS `IdSubgrupoEmpresa`, `f_liquidacion`.`TotalServicio`, `f_liquidacion`.`TotalPlan` , `f_liquidacion`.`TotalEps`, `f_liquidacion`.`TotalDescuento`, `f_liquidacion`.`TotalPaciente`, `f_liquidacion`.`CuotaModeradora`, `f_liquidacion`.`Copago`, `ingreso`.`Id_Sede` AS `IdSede`, `f_subgrupo_empresa`.`CPuc_Debito` , `f_subgrupo_empresa`.`CPuc_Credito`, f_subgrupo_empresa.`IdRubro` AS CodRubro FROM `ingreso` INNER JOIN  `f_liquidacion`   ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) WHERE (`ingreso`.`Id_Sede`='" + this.xidsede[this.JCBSede.getSelectedIndex()] + "' and `f_gruposervicio`.`Id_GrupoServicio` ='" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "' AND `f_factura_capita`.`Fecha_FacturaCapita` >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `f_factura_capita`.`Fecha_FacturaCapita` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND `f_factura_capita`.`Estado` =0 AND `f_liquidacion`.`Estado` =0 AND `ingreso`.`Id_EmpresaContxConv` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `f_factura_capita`.`EstaArmada` =1)";
        }
        System.out.println("vista detalle sede -> " + this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private String traerMedioPago() {
        String medioPago = null;
        System.out.println("medio de pago -> " + this.JCBMedioDePago.getSelectedItem());
        String xsql = "SELECT cuentaDebito FROM medio_pago WHERE nombre = '" + this.JCBMedioDePago.getSelectedItem() + "'";
        System.out.println("consulta -> " + xsql);
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                medioPago = xrs.getString("cuentaDebito");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException e) {
            System.out.println(">>>error<<<");
        }
        return medioPago;
    }
}
