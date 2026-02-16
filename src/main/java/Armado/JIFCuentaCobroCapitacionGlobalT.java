package Armado;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.jpa.gcuenta.GCuentaDAO;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.service.ICargarComboMedioPagoDAO;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFCuentaCobroCapitacionGlobalT.class */
public class JIFCuentaCobroCapitacionGlobalT extends JInternalFrame {
    private String[] xidtipodoc;
    private String[] xidperiodo;
    private String[] xidtipodoc_ppt;
    private String[][] xidgrupocuentac;
    private String[][] xidempresa;
    private String[][] xidservicio;
    private String[][] xidperiodo_ppt;
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private Object jfp;
    private String xsql;
    private GCuentaDAO gcuenta;
    private IResolucionFacturaElectronica resolucionDian;
    private List<ICargarCombo> medioDePago;
    private List<ICargarCombo> tipoDePago;
    private String xnfacturaevento;
    private ButtonGroup JBGSeleccion;
    private JButton JBTDistribucion;
    private JComboBox JCBEmpresa;
    private JComboBox JCBGrupo;
    private JComboBox JCBGrupoCCobro;
    private JComboBox<String> JCBMedioDePago;
    private JComboBox JCBPeriodoC;
    private JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBTipoC;
    private JComboBox JCBTipoDoc_Ppt;
    private JComboBox<String> JCBTipoPago;
    private JCheckBox JCH_AplicaMC;
    private JCheckBox JCH_AplicaMP;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JDateChooser JDFFechaC;
    private JPanel JPIDContables;
    private JPanel JPIDContables1;
    private JPanel JPIDatoP;
    private JPanel JPIDatos;
    private JPanel JPIDetalle;
    private JPanel JPI_DatosCP;
    private JScrollPane JSPConcepto;
    private JScrollPane JSPResultado;
    private JTable JTBResultado;
    private JFormattedTextField JTFFDesCP;
    private JFormattedTextField JTFFNCuentaCobro;
    private JFormattedTextField JTFFNDoc;
    private JFormattedTextField JTFFNDoc_Ppt;
    private JFormattedTextField JTFFNFacturaEvento;
    private JFormattedTextField JTFFNUsuario;
    private JFormattedTextField JTFFTotalCModeradora;
    private JFormattedTextField JTFFTotalCapitacion;
    private JFormattedTextField JTFFTotalCapitacion1;
    private JFormattedTextField JTFFTotalCopago;
    private JFormattedTextField JTFFTotalDescuento;
    private JFormattedTextField JTFFTotalDistribucion;
    private JFormattedTextField JTFFTotalEps;
    private JFormattedTextField JTFFTotalPaciente;
    private JFormattedTextField JTFFTotalPorcentajeD;
    private JFormattedTextField JTFFTotalServicio;
    private JFormattedTextField JTFFValorxUsuario;
    private JTextPane JTPConcepto;
    private JTabbedPane JTP_Datos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xllenoc = 0;
    private int xllenocg = 0;
    private int xid = 0;
    private final IResolucionDianDAO xIResolucionDianDAO = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
    private final ICargarComboMedioPagoDAO xICargarComboMedioPagoDAO = (ICargarComboMedioPagoDAO) Principal.contexto.getBean(ICargarComboMedioPagoDAO.class);

    public JIFCuentaCobroCapitacionGlobalT(String xtitulo) {
        initComponents();
        setTitle(xtitulo);
        springStart();
        mNuevo();
        mValidaResolucionDian(true);
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCBGrupo = new JComboBox();
        this.JPIDetalle = new JPanel();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JTFFTotalServicio = new JFormattedTextField();
        this.JTFFTotalCModeradora = new JFormattedTextField();
        this.JTFFTotalCopago = new JFormattedTextField();
        this.JTFFTotalEps = new JFormattedTextField();
        this.JTFFTotalDescuento = new JFormattedTextField();
        this.JTFFTotalPaciente = new JFormattedTextField();
        this.JTFFTotalPorcentajeD = new JFormattedTextField();
        this.JTFFTotalDistribucion = new JFormattedTextField();
        this.JTP_Datos = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JTFFNUsuario = new JFormattedTextField();
        this.JTFFValorxUsuario = new JFormattedTextField();
        this.JTFFTotalCapitacion = new JFormattedTextField();
        this.JSPConcepto = new JScrollPane();
        this.JTPConcepto = new JTextPane();
        this.JCBGrupoCCobro = new JComboBox();
        this.JTFFDesCP = new JFormattedTextField();
        this.JTFFNCuentaCobro = new JFormattedTextField();
        this.JTFFNFacturaEvento = new JFormattedTextField();
        this.JTFFTotalCapitacion1 = new JFormattedTextField();
        this.JBTDistribucion = new JButton();
        this.JPI_DatosCP = new JPanel();
        this.JPIDContables = new JPanel();
        this.JCBPeriodoC = new JComboBox();
        this.JCBTipoC = new JComboBox();
        this.JTFFNDoc = new JFormattedTextField();
        this.JDFFechaC = new JDateChooser();
        this.JCH_AplicaMC = new JCheckBox();
        this.JCBMedioDePago = new JComboBox<>();
        this.JCBTipoPago = new JComboBox<>();
        this.JPIDContables1 = new JPanel();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDoc_Ppt = new JComboBox();
        this.JTFFNDoc_Ppt = new JFormattedTextField();
        this.JCH_AplicaMP = new JCheckBox();
        setClosable(true);
        setTitle("CAPITACION POR SERVICIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifcuentacobrocapitacionglobalt");
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE ARMADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.3
            public void itemStateChanged(ItemEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBGrupo, GroupLayout.Alignment.LEADING, 0, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatoPLayout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, 0, -1, 32767))).addGap(20, 20, 20)));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 61, -2).addComponent(this.JDCFechaFin, -2, 61, -2)).addComponent(this.JCBEmpresa, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBGrupo, -2, 50, -2).addContainerGap(-1, 32767)));
        this.JPIDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPResultado.setBorder(BorderFactory.createEtchedBorder());
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(Color.red);
        this.JTBResultado.setSelectionMode(2);
        this.JTBResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTBResultadoPropertyChange(evt);
            }
        });
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
        this.JTFFTotalCopago.setEditable(false);
        this.JTFFTotalCopago.setBorder(BorderFactory.createTitledBorder((Border) null, "COPAGO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalCopago.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalCopago.setHorizontalAlignment(4);
        this.JTFFTotalCopago.setText("0");
        this.JTFFTotalCopago.setFont(new Font("Arial", 1, 14));
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
        this.JTFFTotalPaciente.setEditable(false);
        this.JTFFTotalPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "PACIENTE", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalPaciente.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalPaciente.setHorizontalAlignment(4);
        this.JTFFTotalPaciente.setText("0");
        this.JTFFTotalPaciente.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalPorcentajeD.setEditable(false);
        this.JTFFTotalPorcentajeD.setBorder(BorderFactory.createTitledBorder((Border) null, "%", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalPorcentajeD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalPorcentajeD.setHorizontalAlignment(0);
        this.JTFFTotalPorcentajeD.setText("0");
        this.JTFFTotalPorcentajeD.setFont(new Font("Arial", 1, 14));
        this.JTFFTotalDistribucion.setEditable(false);
        this.JTFFTotalDistribucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Distribución", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalDistribucion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalDistribucion.setHorizontalAlignment(0);
        this.JTFFTotalDistribucion.setText("0");
        this.JTFFTotalDistribucion.setFont(new Font("Arial", 1, 14));
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado, -2, 476, -2).addGap(18, 18, 18).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTotalServicio, -2, 136, -2).addComponent(this.JTFFTotalPaciente, -2, 136, -2)).addGap(30, 30, 30).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTotalDescuento, -2, 136, -2).addComponent(this.JTFFTotalCModeradora, -2, 136, -2))).addGroup(JPIDetalleLayout.createSequentialGroup().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTotalCopago, -2, 136, -2).addComponent(this.JTFFTotalPorcentajeD, -2, 136, -2)).addGap(30, 30, 30).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTotalDistribucion, -2, 136, -2).addComponent(this.JTFFTotalEps, -2, 136, -2)))).addContainerGap(-1, 32767)));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalServicio, -2, -1, -2).addComponent(this.JTFFTotalDescuento, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFTotalCModeradora, -2, -1, -2).addComponent(this.JTFFTotalPaciente, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalCopago, -2, -1, -2).addComponent(this.JTFFTotalEps, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleLayout.createSequentialGroup().addComponent(this.JTFFTotalPorcentajeD, -2, -1, -2).addGap(7, 7, 7)).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleLayout.createSequentialGroup().addComponent(this.JTFFTotalDistribucion, -2, -1, -2).addContainerGap()))).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JSPResultado, -2, 216, -2).addGap(0, 0, 32767)));
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JTFFNUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Usuarios", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNUsuario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFNUsuario.setHorizontalAlignment(4);
        this.JTFFNUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFFNUsuario.setValue(new Long(0L));
        this.JTFFNUsuario.addActionListener(new ActionListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.5
            public void actionPerformed(ActionEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFNUsuarioActionPerformed(evt);
            }
        });
        this.JTFFNUsuario.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.6
            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFNUsuarioFocusLost(evt);
            }
        });
        this.JTFFValorxUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor por Usuario", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorxUsuario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFValorxUsuario.setHorizontalAlignment(4);
        this.JTFFValorxUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFFValorxUsuario.setValue(new Long(0L));
        this.JTFFValorxUsuario.addActionListener(new ActionListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.7
            public void actionPerformed(ActionEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFValorxUsuarioActionPerformed(evt);
            }
        });
        this.JTFFValorxUsuario.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.8
            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFValorxUsuarioFocusLost(evt);
            }
        });
        this.JTFFTotalCapitacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Capitación", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalCapitacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFTotalCapitacion.setHorizontalAlignment(4);
        this.JTFFTotalCapitacion.setFont(new Font("Arial", 1, 12));
        this.JTFFTotalCapitacion.setValue(new Long(0L));
        this.JTFFTotalCapitacion.addActionListener(new ActionListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.9
            public void actionPerformed(ActionEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFTotalCapitacionActionPerformed(evt);
            }
        });
        this.JTFFTotalCapitacion.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.10
            public void focusGained(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFTotalCapitacionFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFTotalCapitacionFocusLost(evt);
            }
        });
        this.JSPConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPConcepto.setFont(new Font("Arial", 1, 12));
        this.JSPConcepto.setViewportView(this.JTPConcepto);
        this.JCBGrupoCCobro.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoCCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Cuenta de Cobro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDesCP.setBorder(BorderFactory.createTitledBorder((Border) null, "CModeradora/Copago", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDesCP.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFDesCP.setHorizontalAlignment(4);
        this.JTFFDesCP.setFont(new Font("Arial", 1, 12));
        this.JTFFDesCP.setValue(new Long(0L));
        this.JTFFDesCP.addActionListener(new ActionListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.11
            public void actionPerformed(ActionEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFDesCPActionPerformed(evt);
            }
        });
        this.JTFFDesCP.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.12
            public void focusGained(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFDesCPFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFDesCPFocusLost(evt);
            }
        });
        this.JTFFNCuentaCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° CUENTA COBRO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNCuentaCobro.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNCuentaCobro.setHorizontalAlignment(0);
        this.JTFFNCuentaCobro.setFont(new Font("Arial", 1, 18));
        this.JTFFNCuentaCobro.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.13
            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFNCuentaCobroFocusLost(evt);
            }
        });
        this.JTFFNCuentaCobro.addKeyListener(new KeyAdapter() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.14
            public void keyPressed(KeyEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFNCuentaCobroKeyPressed(evt);
            }
        });
        this.JTFFNFacturaEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° FACTURA EVENTO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNFacturaEvento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNFacturaEvento.setHorizontalAlignment(0);
        this.JTFFNFacturaEvento.setFont(new Font("Arial", 1, 18));
        this.JTFFNFacturaEvento.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.15
            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFNFacturaEventoFocusLost(evt);
            }
        });
        this.JTFFNFacturaEvento.addKeyListener(new KeyAdapter() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.16
            public void keyPressed(KeyEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFNFacturaEventoKeyPressed(evt);
            }
        });
        this.JTFFTotalCapitacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotalCapitacion1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalCapitacion1.setHorizontalAlignment(0);
        this.JTFFTotalCapitacion1.setFont(new Font("Arial", 1, 12));
        this.JTFFTotalCapitacion1.setValue(new Long(0L));
        this.JTFFTotalCapitacion1.addActionListener(new ActionListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.17
            public void actionPerformed(ActionEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFTotalCapitacion1ActionPerformed(evt);
            }
        });
        this.JTFFTotalCapitacion1.addFocusListener(new FocusAdapter() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.18
            public void focusGained(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFTotalCapitacion1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JTFFTotalCapitacion1FocusLost(evt);
            }
        });
        this.JBTDistribucion.setFont(new Font("Arial", 1, 12));
        this.JBTDistribucion.setForeground(Color.red);
        this.JBTDistribucion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Porcentaje.png")));
        this.JBTDistribucion.setText("Distribucion Valor Capita");
        this.JBTDistribucion.addActionListener(new ActionListener() { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.19
            public void actionPerformed(ActionEvent evt) {
                JIFCuentaCobroCapitacionGlobalT.this.JBTDistribucionActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBGrupoCCobro, 0, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFNUsuario, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValorxUsuario, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFDesCP, -2, 150, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalCapitacion, -2, 127, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFNCuentaCobro, -2, 140, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalCapitacion1, -2, 183, -2).addGap(18, 18, 18).addComponent(this.JTFFNFacturaEvento, -2, 149, -2))).addGap(0, 16, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPConcepto, -1, 307, 32767).addComponent(this.JBTDistribucion, -1, -1, 32767)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPConcepto).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFNUsuario).addComponent(this.JTFFValorxUsuario).addComponent(this.JTFFTotalCapitacion).addComponent(this.JTFFDesCP, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.JCBGrupoCCobro, -2, 51, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTDistribucion, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(0, 41, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFNFacturaEvento, GroupLayout.Alignment.TRAILING, -1, 64, 32767).addComponent(this.JTFFTotalCapitacion1, GroupLayout.Alignment.TRAILING).addComponent(this.JTFFNCuentaCobro, GroupLayout.Alignment.TRAILING)))).addGap(14, 14, 14)));
        this.JTP_Datos.addTab("DATOS FACTURA", this.JPIDatos);
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
        this.JCBMedioDePago.setFont(new Font("Arial", 1, 12));
        this.JCBMedioDePago.setBorder(BorderFactory.createTitledBorder((Border) null, "Medio de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoPago.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDContablesLayout = new GroupLayout(this.JPIDContables);
        this.JPIDContables.setLayout(JPIDContablesLayout);
        JPIDContablesLayout.setHorizontalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_AplicaMC).addGap(24, 24, 24).addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addComponent(this.JCBPeriodoC, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoC, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNDoc, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaC, -2, 112, -2)).addGroup(JPIDContablesLayout.createSequentialGroup().addComponent(this.JCBTipoPago, -2, 308, -2).addGap(23, 23, 23).addComponent(this.JCBMedioDePago, -2, 308, -2))).addContainerGap(19, 32767)));
        JPIDContablesLayout.setVerticalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContablesLayout.createSequentialGroup().addContainerGap(37, 32767).addComponent(this.JCH_AplicaMC).addGap(57, 57, 57)).addGroup(JPIDContablesLayout.createSequentialGroup().addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaC, -2, 50, -2).addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JCBPeriodoC, -2, 50, -2)).addComponent(this.JTFFNDoc, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMedioDePago, -2, 50, -2).addComponent(this.JCBTipoPago, -2, 50, -2))));
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
        JPIDContables1Layout.setHorizontalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_AplicaMP).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Ppt, -2, 238, -2).addGap(42, 42, 42).addComponent(this.JTFFNDoc_Ppt, -2, 140, -2).addContainerGap()));
        JPIDContables1Layout.setVerticalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Ppt, -2, 50, -2).addComponent(this.JTFFNDoc_Ppt)).addContainerGap(-1, 32767)).addGroup(JPIDContables1Layout.createSequentialGroup().addComponent(this.JCH_AplicaMP).addContainerGap(-1, 32767)));
        GroupLayout JPI_DatosCPLayout = new GroupLayout(this.JPI_DatosCP);
        this.JPI_DatosCP.setLayout(JPI_DatosCPLayout);
        JPI_DatosCPLayout.setHorizontalGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCPLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDContables, -1, -1, 32767).addGroup(JPI_DatosCPLayout.createSequentialGroup().addComponent(this.JPIDContables1, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPI_DatosCPLayout.setVerticalGroup(JPI_DatosCPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCPLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDContables, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDContables1, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTP_Datos.addTab("DATOS CONTABLES Y/O PRESUPUESTALES", this.JPI_DatosCP);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Datos).addComponent(this.JPIDetalle, -1, -1, 32767).addComponent(this.JPIDatoP, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDetalle, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xllenoc == 1 && this.JCBEmpresa.getSelectedIndex() != -1) {
            this.JCBGrupo.removeAllItems();
            String xsql = "SELECT f_gruposervicio.Id_GrupoServicio, f_gruposervicio.Nbre, f_gruposervicio.ConSubGrupo FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_empresacontxconvenio  ON (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) WHERE (f_subgrupo_empresa.Id_Empresa =" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + " AND f_subgrupo_empresa.Estado =1) GROUP BY f_gruposervicio.Id_GrupoServicio ORDER BY f_gruposervicio.Nbre ASC ";
            this.xidservicio = this.xct.llenarComboyLista(xsql, this.xidservicio, this.JCBGrupo, 3);
            this.xct.cerrarConexionBd();
            this.xllenocg = 1;
            String xsql2 = "SELECT f_subgrupo_empresa.Id, f_subgruposervicio.Nbre, f_subgrupo_empresa.`CPuc_Debito`, f_subgrupo_empresa.`CPuc_Credito`, f_subgrupo_empresa.`IdRubro`, f_subgrupo_empresa.`CPuc_Ganancia`, f_subgrupo_empresa.`CPuc_Perdida` FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN  f_gruposervicio ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) WHERE (f_subgruposervicio.EsGrupo =1 AND f_subgrupo_empresa.Id_Empresa ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND f_subgrupo_empresa.Estado =1) ORDER BY f_subgruposervicio.Nbre ASC ";
            this.xidgrupocuentac = this.xct.llenarComboyLista(xsql2, this.xidgrupocuentac, this.JCBGrupoCCobro, 7);
            if (this.xidgrupocuentac.length > 1) {
                this.JCBGrupoCCobro.setSelectedIndex(-1);
            } else {
                this.JCBGrupoCCobro.setSelectedIndex(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNUsuarioActionPerformed(ActionEvent evt) {
        this.JTFFNUsuario.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorxUsuarioActionPerformed(ActionEvent evt) {
        this.JTFFValorxUsuario.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCapitacionActionPerformed(ActionEvent evt) {
        this.JTFFTotalCapitacion.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNUsuarioFocusLost(FocusEvent evt) {
        mCalcularTotalC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorxUsuarioFocusLost(FocusEvent evt) {
        mCalcularTotalC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCapitacionFocusLost(FocusEvent evt) {
        mCalcularTotalC();
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
    public void JTFFDesCPActionPerformed(ActionEvent evt) {
        mCalcularTotalC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDesCPFocusLost(FocusEvent evt) {
        mCalcularTotalC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFDesCPFocusGained(FocusEvent evt) {
        mCalcularTotalC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCapitacionFocusGained(FocusEvent evt) {
        mCalcularTotalC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCapitacion1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCapitacion1FocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTotalCapitacion1FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDistribucionActionPerformed(ActionEvent evt) {
        if (this.JTBResultado.getRowCount() != -1) {
            DecimalFormat mas = new DecimalFormat("#0");
            double xvalorDistribucion = 0.0d;
            if (Double.valueOf(mas.format(this.JTFFTotalCapitacion.getValue())).doubleValue() > 0.0d) {
                for (int x = 0; x < this.JTBResultado.getRowCount(); x++) {
                    xvalorDistribucion += (Double.valueOf(mas.format(this.JTFFTotalCapitacion.getValue())).doubleValue() * Double.valueOf(this.JTBResultado.getValueAt(x, 5).toString()).doubleValue()) / 100.0d;
                    this.xmodelo.setValueAt(Double.valueOf((Double.valueOf(mas.format(this.JTFFTotalCapitacion.getValue())).doubleValue() * Double.valueOf(this.JTBResultado.getValueAt(x, 5).toString()).doubleValue()) / 100.0d), x, 6);
                }
                this.JTFFTotalDistribucion.setValue(Double.valueOf(xvalorDistribucion));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe consultar información", "VERIFICACACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoPropertyChange(PropertyChangeEvent evt) {
        if (this.JTBResultado.getRowCount() != -1) {
            mSumatoriaValoresDistribucion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNCuentaCobroFocusLost(FocusEvent evt) {
        if (!this.JTFFNCuentaCobro.getText().isEmpty()) {
            buscarFacturaCuentaCobro(this.JTFFNCuentaCobro.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNFacturaEventoFocusLost(FocusEvent evt) {
        if (!this.JTFFNFacturaEvento.getText().isEmpty()) {
            buscarFacturaCuentaCobro(this.JTFFNFacturaEvento.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNCuentaCobroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarFacturaCuentaCobro(this.JTFFNCuentaCobro.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNFacturaEventoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarFacturaCuentaCobro(this.JTFFNFacturaEvento.getText());
        }
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

    private void buscarFacturaCuentaCobro(String numero) {
        try {
            String sql = "SELECT \n`fl`.`IdEmpresaContxConv`\n    , `ffe`.`No_FacturaEvento`, \n    `ffe`.`No_FacturaEvento_M` \n    , `ffe`.`No_CuentaCobro` \nfrom \nf_liquidacion fl \ninner join f_factura_evento ffe  on (ffe.Id_Liquidacion=fl.Id)\ninner join f_empresacontxconvenio fe on (fe.Id=fl.IdEmpresaContxConv)\nwhere (fe.Id_EmpresaCont=" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "  and ffe.Estado=0\nand (ffe.No_FacturaEvento_M=" + numero + " or ffe.No_CuentaCobro =" + numero + ")\n)";
            ResultSet rs = this.xct.traerRs(sql);
            System.out.println("" + sql);
            if (rs.next()) {
                rs.first();
                this.xnfacturaevento = rs.getString("No_FacturaEvento");
                this.JTFFNFacturaEvento.setText(rs.getString("No_FacturaEvento_M"));
                this.JTFFNCuentaCobro.setText(rs.getString("No_CuentaCobro"));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCuentaCobroCapitacionGlobalT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mSumatoriaValoresDistribucion() {
        DecimalFormat mas = new DecimalFormat("#0");
        double xvalorDistribucion = 0.0d;
        if (Double.valueOf(mas.format(this.JTFFTotalCapitacion.getValue())).doubleValue() > 0.0d) {
            for (int x = 0; x < this.JTBResultado.getRowCount(); x++) {
                xvalorDistribucion += Double.valueOf(this.JTBResultado.getValueAt(x, 6).toString()).doubleValue();
            }
            this.JTFFTotalDistribucion.setValue(Double.valueOf(xvalorDistribucion));
        }
    }

    private void mCrearTablaDetalleProc() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"N° Items", "Servicio", "Total Eps", "D", "C", "%", "ValorDistribucion"}) { // from class: Armado.JIFCuentaCobroCapitacionGlobalT.20
            Class[] types = {Long.class, String.class, Double.class, String.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBResultado;
        JTable jTable2 = this.JTBResultado;
        jTable.setAutoResizeMode(0);
        this.JTBResultado.doLayout();
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void springStart() {
        this.gcuenta = (GCuentaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("gCuentaDAOImpl");
    }

    private void mCargarDatos() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.JCBGrupo.getSelectedIndex() != -1) {
                String sql = "SELECT count(f_factura_capita.No_FacturaCapita) as NItems, f_subgruposervicio.Nbre, sum(f_liquidacion.TotalServicio) AS TServicio, \nsum(f_liquidacion.TotalEps) AS TEps, sum(f_liquidacion.TotalDescuento) AS TDescuento, sum(f_liquidacion.TotalPaciente) AS TPaciente, \nsum(f_liquidacion.CuotaModeradora) AS TCModeradora, sum(f_liquidacion.Copago) AS TCopago, ifnull(cc_puc.Id, '') as `CPuc_Debito`, \n ifnull(cc_puc_1.Id, '') as `CPuc_Credito` \n, round(((SUM(f_liquidacion.TotalEps)/d.VTotal)*100),2) Porcentaje\nFROM f_factura_capita INNER JOIN  f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id) \nINNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo= f_subgruposervicio.Id_SubgrupoServicio) \nINNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) \n LEFT JOIN `cc_puc`\n        ON (`cc_puc`.`Id` = `f_subgrupo_empresa`.`CPuc_Debito`)\n LEFT JOIN `cc_puc` as cc_puc_1\n        ON (`cc_puc_1`.`Id` = `f_subgrupo_empresa`.`CPuc_Credito`)  \n INNER JOIN ingreso ON (ingreso.Id = f_liquidacion.Id_Ingreso),\n(SELECT SUM(f_liquidacion.`TotalEps`) AS VTotal\nFROM f_factura_capita INNER JOIN  f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) \nINNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id) \nINNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo= f_subgruposervicio.Id_SubgrupoServicio) \nINNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) \nINNER JOIN ingreso ON (ingreso.Id = f_liquidacion.Id_Ingreso) \nWHERE (f_factura_capita.Fecha_FacturaCapita>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "'\n AND f_factura_capita.Estado =0 AND f_liquidacion.Estado =0 \n AND f_factura_capita.EstaArmada =1 AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') ) d \nWHERE (f_factura_capita.Fecha_FacturaCapita>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and f_factura_capita.Fecha_FacturaCapita<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "'\n and f_factura_capita.Estado =0 AND f_liquidacion.Estado =0 \n AND f_factura_capita.EstaArmada =1 AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') \n GROUP BY f_subgruposervicio.Nbre ORDER BY f_subgruposervicio.Nbre ASC ";
                mCrearTablaDetalleProc();
                ResultSet rs = this.xct.traerRs(sql);
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        int m = 0;
                        long vtotal = 0;
                        long vcopago = 0;
                        long vmoderado = 0;
                        long veps = 0;
                        double xporcentaje = 0.0d;
                        while (rs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), m, 0);
                            this.xmodelo.setValueAt(rs.getString(2), m, 1);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), m, 2);
                            this.xmodelo.setValueAt(rs.getString("CPuc_Debito"), m, 3);
                            this.xmodelo.setValueAt(rs.getString("CPuc_Credito"), m, 4);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("Porcentaje")), m, 5);
                            this.xmodelo.setValueAt(0, m, 6);
                            vtotal += rs.getLong(3);
                            vmoderado += rs.getLong(7);
                            vcopago += rs.getLong(8);
                            veps += rs.getLong(4);
                            xporcentaje += rs.getDouble("Porcentaje");
                            m++;
                        }
                        this.JTFFTotalServicio.setValue(Long.valueOf(vtotal));
                        this.JTFFTotalDescuento.setValue(new Long(0L));
                        this.JTFFTotalPaciente.setValue(new Long(0L));
                        this.JTFFTotalCModeradora.setValue(Long.valueOf(vmoderado));
                        this.JTFFTotalCopago.setValue(Long.valueOf(vcopago));
                        this.JTFFTotalEps.setValue(Long.valueOf(veps));
                        this.JTFFTotalPorcentajeD.setValue(Double.valueOf(xporcentaje));
                    }
                    rs.close();
                    this.xct.cerrarConexionBd();
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(JIFCuentaCobroCapitacionGlobalT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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

    public void mBuscar() {
        mCargarDatos();
    }

    public void mNuevo() {
        this.xllenoc = 0;
        this.xllenocg = 0;
        this.JCBGrupo.setVisible(true);
        this.JCBGrupo.setEnabled(true);
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCBGrupo.setSelectedIndex(-1);
        mLlenarCEmpresa();
        mCrearTablaDetalleProc();
        this.JTFFTotalServicio.setValue(new Integer(0));
        this.JTFFTotalCModeradora.setValue(new Integer(0));
        this.JTFFTotalCopago.setValue(new Integer(0));
        this.JTFFTotalEps.setValue(new Integer(0));
        this.JTFFTotalDescuento.setValue(new Integer(0));
        this.JTFFTotalPaciente.setValue(new Integer(0));
        this.JTFFNCuentaCobro.setText("");
        this.JTFFNFacturaEvento.setText("");
        this.xnfacturaevento = "";
        this.xllenoc = 1;
        this.xllenocg = 1;
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            this.JCH_AplicaMP.setSelected(true);
            if (Principal.informacionIps.getIdentificacion().equals("812003382")) {
                this.JCH_AplicaMP.setSelected(false);
                this.JCH_AplicaMP.setEnabled(false);
            }
        }
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JCH_AplicaMC.setSelected(true);
            if (Principal.informacionIps.getIdentificacion().equals("891982129") || Principal.informacionIps.getIdentificacion().equals("812005644")) {
                this.JCH_AplicaMC.setEnabled(false);
                this.JCH_AplicaMC.setSelected(true);
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
        this.JCBMedioDePago.setSelectedItem("Crédito ACH");
        this.tipoDePago = this.xICargarComboMedioPagoDAO.cargarComboTipoDePago();
        this.JCBTipoPago.removeAllItems();
        for (int i2 = 0; i2 < this.tipoDePago.size(); i2++) {
            this.JCBTipoPago.addItem(this.tipoDePago.get(i2).getNombre());
        }
        this.JCBTipoPago.setSelectedItem("CREDITO");
    }

    public void mGrabar() {
        if (this.JTFFNCuentaCobro.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar", "CONFIRMAR", 2, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.JTBResultado.getRowCount() > 0) {
                    if (this.JCH_AplicaMC.isSelected() && !this.JCH_AplicaMP.isSelected()) {
                        if (this.JCH_AplicaMC.isSelected()) {
                            if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                                if (this.JCBTipoC.getSelectedIndex() != -1) {
                                    if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                        if (this.JCBTipoPago.getSelectedIndex() != -1) {
                                            if (!this.xmt.mVerificarDatosLLeno(this.JTBResultado, 3) && !this.xmt.mVerificarDatosLLeno(this.JTBResultado, 4)) {
                                                if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                                    mGenerarFacturaEvento();
                                                    return;
                                                } else {
                                                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                    this.JDFFechaC.requestFocus();
                                                    return;
                                                }
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Faltan cuentas contables", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.JCBGrupoCCobro.requestFocus();
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
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar documento contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JTP_Datos.setSelectedIndex(1);
                                this.JCBTipoC.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JTP_Datos.setSelectedIndex(1);
                            this.JCBPeriodoC.requestFocus();
                            return;
                        }
                        this.JCH_AplicaMC.setSelected(false);
                        mGenerarFacturaEvento();
                        return;
                    }
                    if (this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                        if (this.JCH_AplicaMC.isSelected()) {
                            if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                                if (this.JCBTipoC.getSelectedIndex() != -1) {
                                    if (!this.xmt.mVerificarDatosLLeno(this.JTBResultado, 3) && !this.xmt.mVerificarDatosLLeno(this.JTBResultado, 4)) {
                                        if (this.JCBMedioDePago.getSelectedIndex() != -1) {
                                            if (this.JCBTipoPago.getSelectedIndex() != -1) {
                                                if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                                    mGenerarFacturaEvento();
                                                    return;
                                                } else {
                                                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                    this.JDFFechaC.requestFocus();
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
                                    JOptionPane.showInternalMessageDialog(this, "Faltan cuentas contables y/o rubros presupuestales  ", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar documento contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JTP_Datos.setSelectedIndex(1);
                                this.JCBTipoC.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JTP_Datos.setSelectedIndex(1);
                            this.JCBPeriodoC.requestFocus();
                            return;
                        }
                        this.JCH_AplicaMC.setSelected(false);
                        if (!this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][3].equals("")) {
                            if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                mGenerarFacturaEvento();
                                return;
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JDFFechaC.requestFocus();
                                return;
                            }
                        }
                        JOptionPane.showInternalMessageDialog(this, "Falta rubro presupuestal", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                    if (!this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                        if (!this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][3].equals("")) {
                            if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                                mGenerarFacturaEvento();
                                return;
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.JDFFechaC.requestFocus();
                                return;
                            }
                        }
                        JOptionPane.showInternalMessageDialog(this, "Falta rubro presupuestal", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                    if (this.JCBGrupoCCobro.getSelectedIndex() != -1) {
                        mGenerarFacturaEvento();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Falta rubro presupuestal", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                }
                JOptionPane.showInternalMessageDialog(this, "No existe orden seleccionada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTBResultado.requestFocus();
                return;
            }
            return;
        }
        if (!this.JTFFNCuentaCobro.getText().isEmpty() && !this.JTFFNFacturaEvento.getText().isEmpty()) {
            actualizarCuentaCobroNotaCargo(this.xnfacturaevento);
        }
    }

    public void mImprimir() {
        mImprimirCuentaFactura();
    }

    private void mGenerarFacturaEvento() {
        String xidliquidacion;
        String xcuentacobro;
        mValidaResolucionDian(false);
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            String sql = "insert into f_liquidacion (TotalServicio, TotalEps, TotalDescuento, TotalPaciente, CuotaModeradora, Copago, Id_SubGrupoServicio, IdEmpresaContxConv, NEquipo, DireccionIp, Estado, IdFormaPago, Fecha, UsuarioS )  values ('" + this.JTFFValorxUsuario.getValue() + "','" + this.JTFFTotalCapitacion.getValue() + "','0','0','" + this.JTFFDesCP.getValue() + "','0','" + this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][0] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "','" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','0','" + this.tipoDePago.get(this.JCBTipoPago.getSelectedIndex()).getId() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActualPC()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            xidliquidacion = this.xct.ejecutarSQLId(sql);
            this.xct.cerrarConexionBd();
            String sql2 = "insert into f_cuentacobro(IdGrupoServicio, Id_PeriodoC, IdEmpContxConv, Periodo_Fact, Periodo_Fact1, TotalServicio, TotalCuotaM, TotalCopago, TotalDesc, TotalNeto, NoRegistros, Fecha, UsuarioS)  values('" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "','" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "','" + this.JTFFValorxUsuario.getValue() + "','0','" + this.JTFFDesCP.getValue() + "','0','" + this.JTFFTotalCapitacion.getValue() + "','1','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            xcuentacobro = this.xct.ejecutarSQLId(sql2);
            this.xct.cerrarConexionBd();
        } else {
            String sql3 = "insert into f_liquidacion (TotalServicio, TotalEps, TotalDescuento, TotalPaciente, CuotaModeradora, Copago, Id_SubGrupoServicio, IdEmpresaContxConv, NEquipo, DireccionIp, Estado, IdFormaPago, Fecha, UsuarioS )  values ('" + (Double.valueOf(this.JTFFTotalCapitacion.getValue().toString()).doubleValue() + Double.valueOf(this.JTFFDesCP.getValue().toString()).doubleValue()) + "','" + this.JTFFTotalCapitacion.getValue() + "','0','0','" + this.JTFFDesCP.getValue() + "','0','" + this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][0] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "','" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','0','" + this.tipoDePago.get(this.JCBTipoPago.getSelectedIndex()).getId() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            xidliquidacion = this.xct.ejecutarSQLId(sql3);
            this.xct.cerrarConexionBd();
            String sql4 = "insert into f_cuentacobro(IdGrupoServicio,  Id_PeriodoC, IdEmpContxConv, Periodo_Fact, Periodo_Fact1, TotalServicio, TotalCuotaM, TotalCopago, TotalDesc, TotalNeto, NoRegistros, Fecha, UsuarioS)  values('" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "','" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "','" + this.JTFFTotalCapitacion.getValue() + "','0','0','0','" + this.JTFFTotalCapitacion.getValue() + "','1','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            xcuentacobro = this.xct.ejecutarSQLId(sql4);
            this.xct.cerrarConexionBd();
        }
        String sql5 = "insert into f_factura_evento(Fecha_FacturaEvento, Prefijo, No_FacturaEvento_M, Id_Liquidacion, idResolucionDian, idMedioPago, EstaArmada, No_CuentaCobro, Sede, UsuarioS)  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.resolucionDian.getPrefijo() + "','" + this.resolucionDian.getConsecutivoFE() + "','" + xidliquidacion + "','" + this.resolucionDian.getId() + "','" + this.medioDePago.get(this.JCBMedioDePago.getSelectedIndex()).getId() + "','2','" + xcuentacobro + "','" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        System.out.println(sql5);
        this.xnfacturaevento = this.xct.ejecutarSQLId(sql5);
        this.xct.cerrarConexionBd();
        Principal.clasegeneral.mActualizar_ResolucionDian(this.xnfacturaevento, this.xidempresa[this.JCBEmpresa.getSelectedIndex()][3]);
        String sql6 = "insert into f_detalle_facturaevento (No_FacturaEvento, NUsuarios, ValorUsuario, Concepto, Total) values('" + this.xnfacturaevento + "','" + this.JTFFNUsuario.getValue() + "','" + this.JTFFValorxUsuario.getValue() + "',replace('" + this.JTPConcepto.getText().toUpperCase() + "', '\n', ' '),'" + this.JTFFTotalCapitacion.getValue() + "')";
        this.xct.ejecutarSQL(sql6);
        this.xct.cerrarConexionBd();
        this.JTFFNFacturaEvento.setValue(new Long(this.xnfacturaevento));
        this.JTFFNCuentaCobro.setValue(new Long(xcuentacobro));
        actualizarCuentaCobroNotaCargo(this.xnfacturaevento);
        this.xsql = "SELECT concat(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento_M) FROM `f_factura_evento` WHERE (`No_FacturaEvento` ='" + this.xnfacturaevento + "') ";
        this.JTFFNFacturaEvento.setText("" + this.xct.traerDato(this.xsql));
        if (this.JCH_AplicaMC.isSelected()) {
            mGenerarDocContable(xcuentacobro);
        }
        if (this.JCH_AplicaMP.isSelected()) {
            mGenerarDoc_Presupuesto();
        }
        JOptionPane.showInternalMessageDialog(this, "Se guardo con exito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private void actualizarCuentaCobroNotaCargo(String nfactura) {
        String sql = "UPDATE  f_factura_capita,  f_liquidacion,  f_subgruposervicio, f_gruposervicio,  `f_subgrupo_empresa` , ingreso SET  f_factura_capita.EstaArmada=2,  f_factura_capita.No_FacturaEvento='" + nfactura + "' WHERE  f_factura_capita.Id_Liquidacion = f_liquidacion.Id AND f_liquidacion.Id_SubGrupoServicio =  f_subgrupo_empresa.Id  AND f_subgruposervicio.`Id_SubgrupoServicio`= f_subgrupo_empresa.`Id_SubGrupo` AND ingreso.Id = f_liquidacion.Id_Ingreso AND f_factura_capita.Fecha_FacturaCapita>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "'AND f_factura_capita.EstaArmada =1 AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    private void mGenerarDoc_Presupuesto() {
        this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,IdUsuarioR, IdDocContable, `Observacion`,NoFact, `UsuarioS`)  VALUES ( '" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + this.xidtipodoc_ppt[this.JCBTipoDoc_Ppt.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.JTFFNDoc.getText() + "','" + this.JTPConcepto.getText() + " CUENTA DE COBRO N° " + this.JTFFNCuentaCobro.getText() + "','" + this.JTFFNFacturaEvento.getText() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
        this.JTFFNDoc_Ppt.setText(this.xct.ejecutarSQLId(this.xsql));
        this.xct.cerrarConexionBd();
        this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado, `Id_Tercero`,Valor,NCCobro,NFactura, Observacion)\n values ('" + this.JTFFNDoc_Ppt.getText() + "', '" + this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][3] + "','" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','" + this.JTFFTotalCapitacion.getValue() + "','" + this.JTFFNCuentaCobro.getText() + "','" + this.JTFFNFacturaEvento.getText() + "','" + this.JTPConcepto.getText() + " SEGÚN CUENTA DE COBRO N° " + this.JTFFNCuentaCobro.getText() + "');";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mGenerarDocContable(String xIdCuentaCobro) {
        String xconcepto;
        if (this.JTPConcepto.getText().isEmpty()) {
            xconcepto = this.JCBGrupoCCobro.getSelectedItem().toString();
        } else {
            xconcepto = this.JTPConcepto.getText();
        }
        String xnfactura = this.JTFFNFacturaEvento.getText();
        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC,Id_CuentaCobro, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','" + xIdCuentaCobro + "','" + xconcepto.toUpperCase() + " FACTURA VENTA N° " + xnfactura + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.JTFFNDoc.setText(this.xct.ejecutarSQLId(this.xsql));
        this.xct.cerrarConexionBd();
        if (!Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            for (int y = 0; y < this.JTBResultado.getRowCount(); y++) {
                if (Principal.informacionIps.getAplicaDistribucion().booleanValue()) {
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xmodelo.getValueAt(y, 4) + "','1','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "','0',round(" + Double.valueOf(this.JTBResultado.getValueAt(y, 6).toString()) + "),'" + xconcepto + " " + this.xmodelo.getValueAt(y, 1) + "  FACTURA VENTA N° : " + xnfactura + "' )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                } else {
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xmodelo.getValueAt(y, 4) + "','1','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "','0',round(" + Double.valueOf(this.JTBResultado.getValueAt(y, 2).toString()) + "),'" + xconcepto + " " + this.xmodelo.getValueAt(y, 1) + "  FACTURA VENTA N° : " + xnfactura + "' )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
            if (!Principal.informacionIps.getAplicaDistribucion().booleanValue() && Double.valueOf(this.JTFFTotalCapitacion1.getValue().toString()).doubleValue() != 0.0d) {
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xmodelo.getValueAt(0, 3) + "','0','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "',abs(round(" + Double.valueOf(this.JTFFTotalCapitacion.getValue().toString()) + ")),'0','" + this.JTPConcepto.getText() + "  FACTURA VENTA N° : " + xnfactura + "'  )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                if (Double.valueOf(this.JTFFTotalCapitacion1.getValue().toString()).doubleValue() < 0.0d) {
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][5] + "','0','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "',abs(round(" + this.JTFFTotalCapitacion1.getValue() + ")),'0','" + this.JTPConcepto.getText() + "  FACTURA VENTA N° : " + xnfactura + "'  )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                } else {
                    this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][4] + "','1','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "','0',abs(round(" + this.JTFFTotalCapitacion1.getValue() + ")),'" + this.JTPConcepto.getText() + "  FACTURA VENTA N° : " + xnfactura + "'  )";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            } else {
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xmodelo.getValueAt(0, 3) + "','0','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "',round(" + this.JTFFTotalCapitacion.getValue() + "),'0','" + this.JTPConcepto.getText() + "  FACTURA VENTA N° : " + xnfactura + "'  )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
        } else {
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][1] + "','0','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "','" + this.JTFFTotalCapitacion.getValue() + "','0','" + xconcepto + "  FACTURA VENTA N° : " + xnfactura + "'  )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero,Id_Radicacion, NFactura, VDebito, VCredito, Concepto) Values ('" + this.JTFFNDoc.getText() + "','" + this.xidgrupocuentac[this.JCBGrupoCCobro.getSelectedIndex()][2] + "','1','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2] + "','0','" + xnfactura + "','0','" + this.JTFFTotalCapitacion.getValue() + "','" + xconcepto + "  FACTURA VENTA N° : " + xnfactura + "' )";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
        this.xsql = "update f_factura_evento set Id_DocumentoC='" + this.JTFFNDoc.getText() + "' where No_FacturaEvento='" + this.xnfacturaevento + "'";
        ConsultasMySQL xct = new ConsultasMySQL();
        xct.ejecutarSQL(this.xsql);
        xct.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.gcuenta.crearDocumentoContableInterfaz(this.JTFFNDoc.getText());
        }
    }

    private void mImprimirCuentaFactura() {
        if (!this.JTFFNCuentaCobro.getText().isEmpty() && !this.JTFFNFacturaEvento.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            String[][] mparametros1 = new String[3][2];
            DecimalFormat formato = new DecimalFormat("#0.00");
            String vl = this.xmt.mConvertirNumeroLetras(formato.format(this.JTFFTotalEps.getValue().toString()));
            mparametros[0][0] = "idcuenta";
            mparametros[0][1] = this.JTFFNCuentaCobro.getText();
            mparametros[1][0] = "valorletra";
            mparametros[1][1] = vl;
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
                mparametros2[1][1] = vl;
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

    private void mCalcularTotalC() {
        if (!this.JTFFNUsuario.getText().isEmpty() && !this.JTFFValorxUsuario.getText().isEmpty()) {
            Double valor = Double.valueOf((Double.valueOf(this.JTFFNUsuario.getValue().toString()).doubleValue() * Double.valueOf(this.JTFFValorxUsuario.getValue().toString()).doubleValue()) - Double.valueOf(this.JTFFDesCP.getValue().toString()).doubleValue());
            double xvalord = valor.doubleValue() - Double.valueOf(this.JTFFTotalEps.getValue().toString()).doubleValue();
            this.JTFFTotalCapitacion.setValue(valor);
            this.JTFFTotalCapitacion1.setValue(Double.valueOf(xvalord));
        }
    }

    private void mLlenarCEmpresa() {
        this.xllenoc = 0;
        this.xllenocg = 0;
        this.JCBGrupo.removeAllItems();
        this.JCBEmpresa.removeAllItems();
        this.JCBGrupoCCobro.removeAllItems();
        this.JCBPeriodoC.removeAllItems();
        this.JCBTipoC.removeAllItems();
        this.JCBTipoDoc_Ppt.removeAllItems();
        this.JCBPeriodo_Ppt.removeAllItems();
        mCrearTablaDetalleProc();
        this.xsql = "SELECT f_empresacontxconvenio.Id, f_empresacontxconvenio.Nbre , f_empresacontxconvenio.EsCapitado, g_empresacont.`Id_empresa`, f_empresacontxconvenio.`Id_GIps` FROM f_factura_capita INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN `g_empresacont`  ON (g_empresacont.`Id_empresa`= f_empresacontxconvenio.`Id_EmpresaCont`)  WHERE (ingreso.FechaIngreso >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_factura_capita.`EstaArmada`=1 AND f_empresacontxconvenio.`EsCapitado`=1 ) GROUP BY f_empresacontxconvenio.Id  order by f_empresacontxconvenio.Nbre ";
        this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBEmpresa, 5);
        this.xsql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsVentas` =1 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc = this.xct.llenarCombo(this.xsql, this.xidtipodoc, this.JCBTipoC);
        if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        this.xidperiodo = this.xct.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1 and Activo=1 and EsCierre=0) ORDER BY FechaF DESC", this.xidperiodo, this.JCBPeriodoC);
        if (this.xidperiodo.length > 1) {
            this.JCBPeriodoC.setSelectedIndex(-1);
            this.JCBPeriodoC.setSelectedItem(Principal.xclase.getNombrePeriodo().toUpperCase());
        }
        this.JCBTipoC.setSelectedItem("VENTAS");
        this.xsql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=2 ";
        this.xidtipodoc_ppt = this.xct.llenarCombo(this.xsql, this.xidtipodoc_ppt, this.JCBTipoDoc_Ppt);
        if (this.xidtipodoc_ppt.length > 1 && !Principal.informacionIps.getIdentificacion().equals("812003382")) {
            this.JCBTipoDoc_Ppt.setSelectedIndex(-1);
        }
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xidperiodo_ppt = this.xct.llenarComboyLista("SELECT `Id` , CONCAT(`Nbre` ,'-',DATE_FORMAT(`FechaI`, '%Y')) AS Nbre, idEncabezado FROM `pp_periodo` WHERE (`Cerrado` =0) ORDER BY `FechaI` DESC", this.xidperiodo_ppt, this.JCBPeriodo_Ppt, 3);
        if (this.xidperiodo_ppt.length > 1) {
            this.JCBPeriodo_Ppt.setSelectedIndex(0);
        }
        this.xct.cerrarConexionBd();
        this.xllenoc = 1;
        this.xllenocg = 1;
    }
}
