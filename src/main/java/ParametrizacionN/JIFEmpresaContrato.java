package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.GContratos;
import com.genoma.plus.jpa.service.IGContratosService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFEmpresaContrato.class */
public class JIFEmpresaContrato extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidestrato;
    private claseParametrizacionN xclase;
    private File xfile;
    private File directorio;
    private GContratos contratos;
    private List<GContratos> listContratos;
    private EmpresaContConvenioEntity empresaContConvenioEntity;
    private ButtonGroup JBGTipo;
    private JCheckBox JCHEstado;
    private JCheckBox JCHGControl;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JPanel JPIDatoSiifnacion;
    private JPanel JPIDatosContrato;
    private JScrollPane JSPDetalle;
    private JSpinner JSPDuracion;
    private JSpinner JSPNUsuario;
    private JSpinner JSPPControl;
    private JTable JTDetalle;
    private JTextField JTFCorreoSiifnacion;
    private JFormattedTextField JTFFMonto;
    private JFormattedTextField JTFFTechoPresupuestal;
    private JFormattedTextField JTFFUsuarioAtendido;
    private JFormattedTextField JTFFValorActual;
    private JFormattedTextField JTFFValorGiroDirecto;
    private JFormattedTextField JTFFValorxUsuario;
    private JTextField JTFNContrato;
    private JTextField JTFNIdSiifnacion;
    private JTextField JTFNbreContrato1;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Datos;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestados = 0;
    private int xcuota = 0;
    private int xid = 0;
    private int xControl = 0;
    private boolean xestadog = false;
    private IGContratosService iGContratosService = (IGContratosService) Principal.contexto.getBean(IGContratosService.class);

    public JIFEmpresaContrato(claseParametrizacionN xclase) {
        initComponents();
        this.xclase = xclase;
        mNuevo();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JSPNUsuario = new JSpinner();
        this.JTFNContrato = new JTextField();
        this.JTFNbreContrato1 = new JTextField();
        this.JTFFValorxUsuario = new JFormattedTextField();
        this.JTFFValorGiroDirecto = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JTP_Datos = new JTabbedPane();
        this.JPIDatosContrato = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JSPDuracion = new JSpinner();
        this.JTFFValorActual = new JFormattedTextField();
        this.JTFFUsuarioAtendido = new JFormattedTextField();
        this.JTFFMonto = new JFormattedTextField();
        this.JTFFTechoPresupuestal = new JFormattedTextField();
        this.JSPPControl = new JSpinner();
        this.JCHGControl = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JPIDatoSiifnacion = new JPanel();
        this.JTFNIdSiifnacion = new JTextField();
        this.JTFCorreoSiifnacion = new JTextField();
        setClosable(true);
        setTitle("CONTRATO POR EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcontratoempresa");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFEmpresaContrato.1
            public void mouseClicked(MouseEvent evt) {
                JIFEmpresaContrato.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPNUsuario.setFont(new Font("Arial", 1, 12));
        this.JSPNUsuario.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Usuarios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNContrato.setFont(new Font("Arial", 1, 12));
        this.JTFNContrato.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Contrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNbreContrato1.setFont(new Font("Arial", 1, 12));
        this.JTFNbreContrato1.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorxUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor por Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorxUsuario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorxUsuario.setHorizontalAlignment(4);
        this.JTFFValorxUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFFValorxUsuario.setValue(new Integer(0));
        this.JTFFValorGiroDirecto.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Giro Directo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorGiroDirecto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorGiroDirecto.setHorizontalAlignment(4);
        this.JTFFValorGiroDirecto.setToolTipText("Valor pactado de giro directo");
        this.JTFFValorGiroDirecto.setFont(new Font("Arial", 1, 12));
        this.JTFFValorGiroDirecto.setValue(new Integer(0));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFEmpresaContrato.2
            public void mouseClicked(MouseEvent evt) {
                JIFEmpresaContrato.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JSPDuracion.setFont(new Font("Arial", 1, 12));
        this.JSPDuracion.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración (Meses)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorActual.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Actual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorActual.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorActual.setHorizontalAlignment(4);
        this.JTFFValorActual.setFont(new Font("Arial", 1, 12));
        this.JTFFValorActual.setValue(new Integer(0));
        this.JTFFUsuarioAtendido.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuarios Atendidos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFUsuarioAtendido.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFUsuarioAtendido.setHorizontalAlignment(4);
        this.JTFFUsuarioAtendido.setFont(new Font("Arial", 1, 12));
        this.JTFFUsuarioAtendido.setValue(new Integer(0));
        this.JTFFMonto.setBorder(BorderFactory.createTitledBorder((Border) null, "Monto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFMonto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFMonto.setHorizontalAlignment(4);
        this.JTFFMonto.setFont(new Font("Arial", 1, 12));
        this.JTFFMonto.setValue(new Integer(0));
        this.JTFFTechoPresupuestal.setBorder(BorderFactory.createTitledBorder((Border) null, "Techo Presupuestal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTechoPresupuestal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTechoPresupuestal.setHorizontalAlignment(4);
        this.JTFFTechoPresupuestal.setFont(new Font("Arial", 1, 12));
        this.JTFFTechoPresupuestal.setValue(new Integer(0));
        this.JSPPControl.setFont(new Font("Arial", 1, 12));
        this.JSPPControl.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-100.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPPControl.setToolTipText("Porcentaje Que se Dispara la Alerta");
        this.JSPPControl.setBorder(BorderFactory.createTitledBorder((Border) null, "Porcentaje Control", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHGControl.setFont(new Font("Arial", 1, 12));
        this.JCHGControl.setForeground(Color.blue);
        this.JCHGControl.setText("GControl");
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        GroupLayout JPIDatosContratoLayout = new GroupLayout(this.JPIDatosContrato);
        this.JPIDatosContrato.setLayout(JPIDatosContratoLayout);
        JPIDatosContratoLayout.setHorizontalGroup(JPIDatosContratoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosContratoLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JSPPControl, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTechoPresupuestal, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFUsuarioAtendido, -1, 200, 32767).addGap(18, 18, 18).addComponent(this.JCHGControl).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(80, 80, 80)).addGroup(JPIDatosContratoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaFin, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDuracion, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFMonto, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorActual).addContainerGap()));
        JPIDatosContratoLayout.setVerticalGroup(JPIDatosContratoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosContratoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosContratoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosContratoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 50, -2).addComponent(this.JDCFechaFin, -2, 50, -2)).addGroup(JPIDatosContratoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPDuracion).addComponent(this.JTFFValorActual, -2, 50, -2).addComponent(this.JTFFMonto, -2, 50, -2))).addGap(10, 10, 10).addGroup(JPIDatosContratoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTechoPresupuestal, -2, 50, -2).addComponent(this.JTFFUsuarioAtendido, -2, 50, -2).addComponent(this.JSPPControl).addComponent(this.JCHGControl).addComponent(this.JCHEstado)).addGap(24, 24, 24)));
        this.JTP_Datos.addTab("Datos del Contrato", this.JPIDatosContrato);
        this.JTFNIdSiifnacion.setFont(new Font("Arial", 1, 12));
        this.JTFNIdSiifnacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Identificador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCorreoSiifnacion.setFont(new Font("Arial", 1, 12));
        this.JTFCorreoSiifnacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo Autorizado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatoSiifnacionLayout = new GroupLayout(this.JPIDatoSiifnacion);
        this.JPIDatoSiifnacion.setLayout(JPIDatoSiifnacionLayout);
        JPIDatoSiifnacionLayout.setHorizontalGroup(JPIDatoSiifnacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoSiifnacionLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JTFNIdSiifnacion, -2, 228, -2).addGap(18, 18, 18).addComponent(this.JTFCorreoSiifnacion, -2, 519, -2).addContainerGap(32, 32767)));
        JPIDatoSiifnacionLayout.setVerticalGroup(JPIDatoSiifnacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoSiifnacionLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPIDatoSiifnacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNIdSiifnacion, -2, 50, -2).addComponent(this.JTFCorreoSiifnacion, -2, 50, -2)).addContainerGap(76, 32767)));
        this.JTP_Datos.addTab("Datos SIIFNación", this.JPIDatoSiifnacion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPNUsuario)).addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTFNContrato, -2, 117, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNbreContrato1).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFFValorxUsuario, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValorGiroDirecto, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta))).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos, -2, 832, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNContrato, -2, 50, -2).addComponent(this.JTFNbreContrato1, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNUsuario, -2, -1, -2).addComponent(this.JTFFValorxUsuario, -2, 47, -2).addComponent(this.JTFFValorGiroDirecto, -2, 47, -2).addComponent(this.JTFRuta, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTP_Datos).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JSPDetalle))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 295, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.contratos = this.listContratos.get(this.JTDetalle.getSelectedRow());
            this.JTFNContrato.setText(this.contratos.getNoContrato());
            this.JTFNbreContrato1.setText(this.contratos.getNbreContrato());
            this.JSPNUsuario.setValue(this.contratos.getNoUsuarios());
            this.JTFFValorxUsuario.setValue(Double.valueOf(this.contratos.getVUsuario()));
            this.JSPDuracion.setValue(this.contratos.getDuracion());
            this.JTFFMonto.setValue(this.contratos.getMonto());
            this.JTFFTechoPresupuestal.setValue(this.contratos.getTPresupuestal());
            this.JCHGControl.setSelected(this.contratos.getGControl().booleanValue());
            this.JSPPControl.setValue(this.contratos.getPControl());
            this.JTFFValorActual.setValue(this.contratos.getValorActual());
            this.JTFFUsuarioAtendido.setValue(this.contratos.getUsuariosAtendidos());
            this.JCHEstado.setSelected(!this.contratos.getEstado().booleanValue());
            this.JTFFValorGiroDirecto.setValue(this.contratos.getVGiroD());
            this.JTFNIdSiifnacion.setText(this.contratos.getIdSiifNacion());
            this.JTFCorreoSiifnacion.setText(this.contratos.getCorreoAdquiriente());
            this.JDCFechaInicio.setDate(this.contratos.getFechaInicio());
            this.JDCFechaFin.setDate(this.contratos.getFechaFin());
            if (evt.getClickCount() == 2) {
                this.xmetodos.mostrarPdf(this.directorio + "\\" + this.contratos.getUrlSoporte());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmetodos.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "N° Contrato", "Nombre Contrato", "N° Usuario", "V/Usuario", "FechaI", "FechaF", "Duración", "Monto", "TPresupuestal", "GControl", "PControl", "V/Actual", "U/Atendidos", "Estado", "VGD", "URL"}) { // from class: ParametrizacionN.JIFEmpresaContrato.3
            Class[] types = {Integer.class, String.class, String.class, Integer.class, Double.class, Date.class, Date.class, Integer.class, Double.class, Double.class, Boolean.class, Double.class, Double.class, Integer.class, Boolean.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        mCrearModeloDatos();
        this.listContratos = new ArrayList();
        this.listContratos = this.iGContratosService.listaContratosPorConvenio(this.empresaContConvenioEntity);
        if (!this.listContratos.isEmpty()) {
            this.listContratos.forEach(item -> {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(item.getId(), this.JTDetalle.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(item.getNoContrato(), this.JTDetalle.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(item.getNbreContrato(), this.JTDetalle.getRowCount() - 1, 2);
                this.xmodelo.setValueAt(item.getNoUsuarios(), this.JTDetalle.getRowCount() - 1, 3);
                this.xmodelo.setValueAt(Double.valueOf(item.getVUsuario()), this.JTDetalle.getRowCount() - 1, 4);
                this.xmodelo.setValueAt(item.getFechaInicio(), this.JTDetalle.getRowCount() - 1, 5);
                this.xmodelo.setValueAt(item.getFechaFin(), this.JTDetalle.getRowCount() - 1, 6);
                this.xmodelo.setValueAt(item.getDuracion(), this.JTDetalle.getRowCount() - 1, 7);
                this.xmodelo.setValueAt(item.getMonto(), this.JTDetalle.getRowCount() - 1, 8);
                this.xmodelo.setValueAt(item.getTPresupuestal(), this.JTDetalle.getRowCount() - 1, 9);
                this.xmodelo.setValueAt(item.getGControl(), this.JTDetalle.getRowCount() - 1, 10);
                this.xmodelo.setValueAt(item.getPControl(), this.JTDetalle.getRowCount() - 1, 11);
                this.xmodelo.setValueAt(item.getValorActual(), this.JTDetalle.getRowCount() - 1, 12);
                this.xmodelo.setValueAt(item.getUsuariosAtendidos(), this.JTDetalle.getRowCount() - 1, 13);
                this.xmodelo.setValueAt(Boolean.valueOf(!item.getEstado().booleanValue()), this.JTDetalle.getRowCount() - 1, 14);
                this.xmodelo.setValueAt(item.getVGiroD(), this.JTDetalle.getRowCount() - 1, 15);
                this.xmodelo.setValueAt(item.getUrlSoporte(), this.JTDetalle.getRowCount() - 1, 16);
            });
        }
    }

    public void mNuevo() {
        this.directorio = new File(this.xmetodos.mRutaSoporte("JIFEmpresaContrato"));
        this.empresaContConvenioEntity = new EmpresaContConvenioEntity();
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.empresaContConvenioEntity.setId(Integer.valueOf(this.xclase.xjifempresaBienestar.xidempresacont));
        } else {
            this.empresaContConvenioEntity.setId(Integer.valueOf(this.xclase.xjifempresa.xidempresacont));
        }
        this.contratos = new GContratos();
        this.listContratos = new ArrayList();
        this.JTFNContrato.setText("");
        this.JTFNIdSiifnacion.setText("");
        this.JTFCorreoSiifnacion.setText("");
        this.JTFNbreContrato1.setText("");
        this.JSPNUsuario.setValue(new Integer(0));
        this.JTFFValorxUsuario.setValue(new Integer(0));
        this.JDCFechaInicio.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaFin.setDate(this.xmetodos.getFechaActual());
        this.JSPDuracion.setValue(new Integer(0));
        this.JTFFMonto.setValue(new Integer(0));
        this.JTFFValorActual.setValue(new Integer(0));
        this.JTFFUsuarioAtendido.setValue(new Integer(0));
        this.JTFFValorGiroDirecto.setValue(new Double(0.0d));
        this.JCHEstado.setSelected(true);
        this.xestados = 0;
        this.xestadog = false;
        this.xControl = 0;
        this.JCHEstado.setSelected(false);
        this.JTFFTechoPresupuestal.setValue(new Integer(0));
        this.JSPPControl.setValue(new Float(0.0f));
        mCargarDatosTabla();
    }

    public void mGrabar() {
        String adjunto;
        if (!this.JTFNContrato.getText().isEmpty()) {
            if (!this.JTFNbreContrato1.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar N?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.contratos.setCorreoAdquiriente(this.JTFCorreoSiifnacion.getText());
                    this.contratos.setDuracion(Integer.valueOf(this.JSPDuracion.getValue().toString()));
                    this.contratos.setEstado(Boolean.valueOf(!this.JCHEstado.isSelected()));
                    this.contratos.setFecha(this.xmetodos.getFechaActual());
                    this.contratos.setFechaFin(this.JDCFechaFin.getDate());
                    this.contratos.setFechaInicio(this.JDCFechaInicio.getDate());
                    this.contratos.setGControl(Boolean.valueOf(this.JCHGControl.isSelected()));
                    this.contratos.setIdEmpresaContConvenio(this.empresaContConvenioEntity);
                    this.contratos.setIdSiifNacion(this.JTFNIdSiifnacion.getText());
                    this.contratos.setMonto(Double.valueOf(this.JTFFMonto.getValue().toString()));
                    this.contratos.setNbreContrato(this.JTFNbreContrato1.getText());
                    this.contratos.setNoContrato(this.JTFNContrato.getText());
                    this.contratos.setNoUsuarios(Integer.valueOf(this.JSPNUsuario.getValue().toString()));
                    this.contratos.setPControl(Double.valueOf(this.JSPPControl.getValue().toString()));
                    this.contratos.setTPresupuestal(Double.valueOf(this.JTFFTechoPresupuestal.getValue().toString()));
                    this.contratos.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    this.contratos.setUsuariosAtendidos(Integer.valueOf(this.JTFFUsuarioAtendido.getValue().toString()));
                    this.contratos.setVGiroD(Double.valueOf(this.JTFFValorGiroDirecto.getValue().toString()));
                    this.contratos.setVUsuario(Double.valueOf(this.JTFFValorxUsuario.getValue().toString()).doubleValue());
                    this.contratos.setValorActual(Double.valueOf(this.JTFFValorActual.getValue().toString()));
                    Integer id = this.iGContratosService.grabar(this.contratos);
                    if (!this.JTFRuta.getText().isEmpty()) {
                        File directorio = new File(this.xmetodos.mRutaSoporte("JIFEmpresaContrato"));
                        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                            adjunto = Principal.txtNo.getText() + "_" + this.xclase.xjifempresaBienestar.xidempresacont + "_" + id + ".pdf";
                        } else {
                            adjunto = Principal.txtNo.getText() + "_" + this.xclase.xjifempresa.xidempresacont + "_" + id + ".pdf";
                        }
                        this.contratos.setUrlSoporte(this.xmetodos.mTraerUrlBD(adjunto));
                        this.iGContratosService.grabar(this.contratos);
                        File f1 = new File(this.JTFRuta.getText());
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(directorio, f2.getName()));
                    }
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNbreContrato1.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo n° contrato no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNContrato.requestFocus();
    }
}
