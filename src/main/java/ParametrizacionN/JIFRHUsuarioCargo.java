package ParametrizacionN;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDBuscarConceptoNominaxVFijo;
import com.genoma.plus.controller.rrhh.JDContratosPorTrabajador;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFRHUsuarioCargo.class */
public class JIFRHUsuarioCargo extends JInternalFrame {
    private String xsql;
    public Persona xjppersona;
    private DefaultTableModel xmodeloBD;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelosgc;
    private DefaultTableModel xmodeloufc;
    private DefaultTableModel xmodelof;
    private DefaultTableModel xmodeloes;
    private DefaultTableModel xmodelodc;
    private DefaultTableModel xmodeloinf;
    private DefaultTableModel xModelo_CN;
    private Object[] xdato;
    private String[] xId_TipoBD;
    private String[] xidunidadf;
    private String[] xidtipop;
    private String[] xidunidadfc;
    private String[] xtipodocumento;
    private String[] xmunicipioex;
    private String[] xmunicipionaci;
    private String[] xsexo;
    private String[] xparentesco;
    private String[] xdocumento;
    private String[] xnestudio;
    private String[] xclasificacion;
    private String[] xtipoContrato;
    private String[] xtipoTrabajador;
    private String[] xSubTipotrabajador;
    private String[] xFormaDePago;
    private String[] xMetodoDePago;
    private File xfile;
    private File DirectorioEstudios;
    private File DirectorioDocumentos;
    public String[][] xidproceso;
    public String[][] xId_CNConcepto;
    public String[][] xId_CNTercero;
    public String[][] xidcargo;
    public String idContrato;
    private JButton JBContratos;
    private JButton JBTAdicionar;
    private JButton JBTAdicionarDc;
    private JButton JBTAdicionarDc1;
    private JButton JBTAdicionarES;
    private JButton JBTAdicionarUF;
    private JButton JBTAdicionarUF2;
    private JButton JBT_AdicionarBD;
    private JButton JBT_AdicionarT;
    private JButton JBT_AdicionarT1;
    private JComboBox JCBCargo;
    private JComboBox JCBDocumento;
    private JComboBox JCBEstudio;
    private JComboBox JCBFormaPago;
    private JComboBox JCBMetodoDePago;
    private JComboBox JCBMpioExpedicionF2;
    private JComboBox JCBMpioLaboral;
    private JComboBox JCBMpioNacimientoF1;
    private JComboBox JCBParentesco;
    private JComboBox JCBProceso;
    private JComboBox JCBSexoF;
    private JComboBox JCBSubTipoTrabajador;
    private JComboBox JCBTProceso;
    private JComboBox JCBTipoContrato;
    private JComboBox JCBTipoTrabajador;
    private JComboBox JCBTpDocumento;
    private JComboBox JCBTpclasificasion;
    private JComboBox JCBUnidadF;
    private JComboBox JCBUnidadFc;
    private JComboBox JCB_CTercero;
    private JComboBox JCB_Concepto;
    private JComboBox JCB_TipoB;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstadoCnomina;
    private JCheckBox JCHEstadoDoc;
    private JCheckBox JCHEstadoEstudio;
    private JCheckBox JCHEstadoLaboral;
    private JCheckBox JCHEstadoLaboral1;
    private JCheckBox JCHEstadoSgc;
    private JCheckBox JCHEstadoUfc;
    private JCheckBox JCHEstado_BD;
    private JCheckBox JCHFamiliaf;
    private JCheckBox JCHFijo;
    private JCheckBox JCHLider;
    private JCheckBox JCHSIntegral;
    private JCheckBox JCH_Planta;
    private JDateChooser JDCFechaExpDocF1;
    private JDateChooser JDCFechaNacimientoF1;
    private JDateChooser JDFFechaIngreso;
    private JDateChooser JDFFechaTerminacionDeContrato;
    private JPanel JPDAdicional;
    private JPanel JPDPrincipalDoc;
    private JPanel JPDPrincipalDoc1;
    private JPanel JPDPrincipales;
    private JPanel JPDprincipalLaboral;
    private JPanel JPHistoricoDoc;
    private JPanel JPHistoricoLaboral;
    private JPanel JPIDatosProf;
    private JPanel JPIDatosSgc;
    private JPanel JPIFDatosUsuario;
    private JPanel JPIUnidadF;
    private JPanel JPI_CDetalle;
    private JPanel JPI_FUtilizacion;
    private JPanel JPI_TipoPersona;
    private JRadioButton JRBTfijo;
    private JRadioButton JRBTindefinido;
    private JRadioButton JRB_FP_Dias;
    private JRadioButton JRB_FP_Horas;
    private JRadioButton JRB_FP_Jornal;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleSgc;
    private JScrollPane JSPDetalleUf;
    private JSpinner JSPFRiesgoArp;
    private JSpinner JSPPDistribucionS;
    private JScrollPane JSP_CHistorico;
    private JScrollPane JSP_DetalleB;
    private JScrollPane JSP_Observacion3;
    private JScrollPane JSP_Observacion4;
    private JTextPane JTADescripcionF1;
    private JTextPane JTA_ObservacionDoc;
    private JTable JTB_CNHistorico;
    private JTable JTB_DetalleBD;
    private JTable JTDetalleC;
    private JTable JTDetalleDc;
    private JTable JTDetalleEstudio;
    private JTable JTDetalleF;
    private JTable JTDetalleINF;
    private JTable JTDetalleSgc;
    private JTable JTDetalleUf;
    private JTextField JTFApellido1;
    private JTextField JTFApellido2;
    private JTextField JTFCargo;
    private JTextField JTFCodigoD785;
    private JTextField JTFDireccion;
    private JFormattedTextField JTFFCantidad;
    private JFormattedTextField JTFFSalario;
    private JFormattedTextField JTFF_Valor;
    private JFormattedTextField JTFF_Valor1;
    private JTextField JTFGrado;
    private JTextField JTFJefe;
    private JTextField JTFNDoc;
    private JTextField JTFNombre1;
    private JTextField JTFNombre2;
    private JTextField JTFNombreE;
    private JTextField JTFRuta;
    private JTextField JTFRutaSoporte;
    private JTextField JTFRutaSoporte2;
    private JTextField JTFTiempoL;
    private JTabbedPane JTPDatosLaboral;
    private JTabbedPane JTPDatosUsuario;
    private JTabbedPane JTPDetalleFami;
    private JTabbedPane JTPDocumentos;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JTextField jTextField1;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xlider = 0;
    private int xfijo = 1;
    private int xestadosgc = 1;
    private int xesintegral = 0;
    private int xestadouf = 1;
    private int xestadofamilia = 1;
    private int xestadoestudio = 1;
    private int xestadodoc = 1;
    private int xestadoInL = 1;
    private int xTipoV = 0;
    private int xEstadoLaboral1 = 1;
    private int xestadocnm = 1;
    private int xformapago = 0;
    private boolean xlleno_CN = false;
    private boolean xencontroacargo = false;
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xgrabarsgc = false;
    private boolean xgrabarufc = false;
    private boolean xgrabarf = false;
    private boolean xgrabares = false;
    private boolean xgrabardc = false;
    private boolean xgrabarilf = false;
    public boolean xGrabarCN = false;

    public JIFRHUsuarioCargo() {
        initComponents();
        mCargasPanelUsuario();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v113, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v150, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v200, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v285, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v330, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v410, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v454, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v481, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JTPDatosUsuario = new JTabbedPane();
        this.JPIDatosProf = new JPanel();
        this.JCBUnidadF = new JComboBox();
        this.JCBCargo = new JComboBox();
        this.JDFFechaIngreso = new JDateChooser();
        this.JTFFSalario = new JFormattedTextField();
        this.JCHSIntegral = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHLider = new JCheckBox();
        this.JCHFijo = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JSPFRiesgoArp = new JSpinner();
        this.JCBTpclasificasion = new JComboBox();
        this.JTFFCantidad = new JFormattedTextField();
        this.JPI_FUtilizacion = new JPanel();
        this.JRB_FP_Dias = new JRadioButton();
        this.JRB_FP_Horas = new JRadioButton();
        this.JRB_FP_Jornal = new JRadioButton();
        this.jPanel8 = new JPanel();
        this.JTFCodigoD785 = new JTextField();
        this.JTFGrado = new JTextField();
        this.JBContratos = new JButton();
        this.JCH_Planta = new JCheckBox();
        this.JPIDatosSgc = new JPanel();
        this.JSPDetalleSgc = new JScrollPane();
        this.JTDetalleSgc = new JTable();
        this.JCBTProceso = new JComboBox();
        this.JCBProceso = new JComboBox();
        this.JCHEstadoSgc = new JCheckBox();
        this.JBTAdicionar = new JButton();
        this.JPIUnidadF = new JPanel();
        this.JCBUnidadFc = new JComboBox();
        this.JSPPDistribucionS = new JSpinner();
        this.JSPDetalleUf = new JScrollPane();
        this.JTDetalleUf = new JTable();
        this.JCHEstadoUfc = new JCheckBox();
        this.JBTAdicionarUF = new JButton();
        this.jPanel6 = new JPanel();
        this.JPI_CDetalle = new JPanel();
        this.JCB_Concepto = new JComboBox();
        this.JCB_CTercero = new JComboBox();
        this.JBT_AdicionarT = new JButton();
        this.JCHEstadoCnomina = new JCheckBox();
        this.JTFF_Valor = new JFormattedTextField();
        this.JTFF_Valor1 = new JFormattedTextField();
        this.JBT_AdicionarT1 = new JButton();
        this.JSP_CHistorico = new JScrollPane();
        this.JTB_CNHistorico = new JTable();
        this.jPanel3 = new JPanel();
        this.JTPDetalleFami = new JTabbedPane();
        this.JPDPrincipales = new JPanel();
        this.JCBParentesco = new JComboBox();
        this.JCBTpDocumento = new JComboBox();
        this.JTFNDoc = new JTextField();
        this.JCBSexoF = new JComboBox();
        this.JTFApellido1 = new JTextField();
        this.JTFApellido2 = new JTextField();
        this.JTFNombre1 = new JTextField();
        this.JTFNombre2 = new JTextField();
        this.JCHFamiliaf = new JCheckBox();
        this.JDCFechaExpDocF1 = new JDateChooser();
        this.JCBMpioExpedicionF2 = new JComboBox();
        this.JDCFechaNacimientoF1 = new JDateChooser();
        this.JCBMpioNacimientoF1 = new JComboBox();
        this.JSP_Observacion4 = new JScrollPane();
        this.JTADescripcionF1 = new JTextPane();
        this.JBTAdicionarUF2 = new JButton();
        this.JPDAdicional = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.JTDetalleF = new JTable();
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JCBEstudio = new JComboBox();
        this.jTextField1 = new JTextField();
        this.JCHEstadoEstudio = new JCheckBox();
        this.JBTAdicionarES = new JButton();
        this.JTFRutaSoporte2 = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalleEstudio = new JTable();
        this.jPanel4 = new JPanel();
        this.JTPDatosLaboral = new JTabbedPane();
        this.JPDprincipalLaboral = new JPanel();
        this.JTFNombreE = new JTextField();
        this.JCBMpioLaboral = new JComboBox();
        this.JTFDireccion = new JTextField();
        this.JTFCargo = new JTextField();
        this.JTFJefe = new JTextField();
        this.JTFTiempoL = new JTextField();
        this.JPI_TipoPersona = new JPanel();
        this.JRBTfijo = new JRadioButton();
        this.JRBTindefinido = new JRadioButton();
        this.JCHEstadoLaboral = new JCheckBox();
        this.JBTAdicionarDc1 = new JButton();
        this.JDFFechaTerminacionDeContrato = new JDateChooser();
        this.JCBTipoTrabajador = new JComboBox();
        this.JCBSubTipoTrabajador = new JComboBox();
        this.JCHEstadoLaboral1 = new JCheckBox();
        this.JCBTipoContrato = new JComboBox();
        this.JPHistoricoLaboral = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTDetalleINF = new JTable();
        this.jPanel5 = new JPanel();
        this.JTPDocumentos = new JTabbedPane();
        this.JPDPrincipalDoc = new JPanel();
        this.JCBDocumento = new JComboBox();
        this.JCHEstadoDoc = new JCheckBox();
        this.JTFRutaSoporte = new JTextField();
        this.JSP_Observacion3 = new JScrollPane();
        this.JTA_ObservacionDoc = new JTextPane();
        this.JBTAdicionarDc = new JButton();
        this.JPHistoricoDoc = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.JTDetalleDc = new JTable();
        this.jPanel7 = new JPanel();
        this.JPDPrincipalDoc1 = new JPanel();
        this.JCB_TipoB = new JComboBox();
        this.JCHEstado_BD = new JCheckBox();
        this.JBT_AdicionarBD = new JButton();
        this.JSP_DetalleB = new JScrollPane();
        this.JTB_DetalleBD = new JTable();
        this.jPanel9 = new JPanel();
        this.JCBFormaPago = new JComboBox();
        this.JCBMetodoDePago = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTION DE EMPLEADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifusuariocargo");
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRHUsuarioCargo.this.formInternalFrameClosing(evt);
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
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL EMPLEADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1127, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 187, 32767));
        this.JTPDatosUsuario.setForeground(new Color(0, 103, 0));
        this.JTPDatosUsuario.setTabLayoutPolicy(1);
        this.JTPDatosUsuario.setFont(new Font("Arial", 1, 14));
        this.JTPDatosUsuario.addChangeListener(new ChangeListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.2
            public void stateChanged(ChangeEvent evt) {
                JIFRHUsuarioCargo.this.JTPDatosUsuarioStateChanged(evt);
            }
        });
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.3
            public void itemStateChanged(ItemEvent evt) {
                JIFRHUsuarioCargo.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JCBCargo.setFont(new Font("Arial", 1, 12));
        this.JCBCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCargo.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.4
            public void itemStateChanged(ItemEvent evt) {
                JIFRHUsuarioCargo.this.JCBCargoItemStateChanged(evt);
            }
        });
        this.JCBCargo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.5
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCBCargoActionPerformed(evt);
            }
        });
        this.JDFFechaIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaIngreso.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaIngreso.setFont(new Font("Arial", 1, 12));
        this.JTFFSalario.setBorder(BorderFactory.createTitledBorder((Border) null, "Salario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSalario.setHorizontalAlignment(4);
        this.JTFFSalario.setFont(new Font("Arial", 1, 12));
        this.JCHSIntegral.setFont(new Font("Arial", 1, 12));
        this.JCHSIntegral.setForeground(Color.blue);
        this.JCHSIntegral.setText(" Integral?");
        this.JCHSIntegral.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.6
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHSIntegralActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Firma", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.7
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.8
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHLider.setFont(new Font("Arial", 1, 12));
        this.JCHLider.setForeground(Color.blue);
        this.JCHLider.setText("Lider?");
        this.JCHLider.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.9
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHLiderActionPerformed(evt);
            }
        });
        this.JCHFijo.setFont(new Font("Arial", 1, 12));
        this.JCHFijo.setForeground(Color.blue);
        this.JCHFijo.setSelected(true);
        this.JCHFijo.setText("Fijo?");
        this.JCHFijo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.10
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHFijoActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.setSelectionMode(0);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.11
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalleC);
        this.JSPFRiesgoArp.setFont(new Font("Arial", 1, 12));
        this.JSPFRiesgoArp.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPFRiesgoArp.setToolTipText("% Calculo Riesgo Arp");
        this.JSPFRiesgoArp.setBorder(BorderFactory.createTitledBorder((Border) null, "% Riesgo Arp", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTpclasificasion.setFont(new Font("Arial", 1, 12));
        this.JCBTpclasificasion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTpclasificasion.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.12
            public void itemStateChanged(ItemEvent evt) {
                JIFRHUsuarioCargo.this.JCBTpclasificasionItemStateChanged(evt);
            }
        });
        this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setHorizontalAlignment(4);
        this.JTFFCantidad.setToolTipText("Valor trabajado de acuerdo a la forma de pago");
        this.JTFFCantidad.setFont(new Font("Arial", 1, 12));
        this.JTFFCantidad.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.13
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JTFFCantidadActionPerformed(evt);
            }
        });
        this.JPI_FUtilizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.buttonGroup1.add(this.JRB_FP_Dias);
        this.JRB_FP_Dias.setFont(new Font("Arial", 1, 12));
        this.JRB_FP_Dias.setSelected(true);
        this.JRB_FP_Dias.setText("Dias");
        this.JRB_FP_Dias.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.14
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JRB_FP_DiasActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRB_FP_Horas);
        this.JRB_FP_Horas.setFont(new Font("Arial", 1, 12));
        this.JRB_FP_Horas.setText("Horas");
        this.JRB_FP_Horas.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.15
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JRB_FP_HorasActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRB_FP_Jornal);
        this.JRB_FP_Jornal.setFont(new Font("Arial", 1, 12));
        this.JRB_FP_Jornal.setText("Jornal");
        this.JRB_FP_Jornal.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.16
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JRB_FP_JornalActionPerformed(evt);
            }
        });
        GroupLayout JPI_FUtilizacionLayout = new GroupLayout(this.JPI_FUtilizacion);
        this.JPI_FUtilizacion.setLayout(JPI_FUtilizacionLayout);
        JPI_FUtilizacionLayout.setHorizontalGroup(JPI_FUtilizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_FP_Dias).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_FP_Horas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_FP_Jornal).addContainerGap(-1, 32767)));
        JPI_FUtilizacionLayout.setVerticalGroup(JPI_FUtilizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizacionLayout.createSequentialGroup().addGroup(JPI_FUtilizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FP_Jornal).addComponent(this.JRB_FP_Horas).addComponent(this.JRB_FP_Dias)).addGap(0, 0, 32767)));
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "DECRETO 785", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFCodigoD785.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoD785.setToolTipText("Codigo de acuerdo al decreto 785");
        this.JTFCodigoD785.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFGrado.setFont(new Font("Arial", 1, 12));
        this.JTFGrado.setToolTipText("Grado de acuerdo al decreto 785");
        this.JTFGrado.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigoD785, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFGrado, -2, 93, -2).addGap(10, 10, 10)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigoD785, -2, 50, -2).addComponent(this.JTFGrado, -2, 50, -2)).addGap(15, 15, 15)));
        this.JBContratos.setFont(new Font("Arial", 1, 12));
        this.JBContratos.setText("Contrato");
        this.JBContratos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.17
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBContratosActionPerformed(evt);
            }
        });
        this.JCH_Planta.setFont(new Font("Arial", 1, 12));
        this.JCH_Planta.setForeground(Color.blue);
        this.JCH_Planta.setText("Planta?");
        this.JCH_Planta.setToolTipText("Empleado de planta");
        this.JCH_Planta.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.18
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCH_PlantaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosProfLayout = new GroupLayout(this.JPIDatosProf);
        this.JPIDatosProf.setLayout(JPIDatosProfLayout);
        JPIDatosProfLayout.setHorizontalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JSPDetalle).addContainerGap()).addGroup(JPIDatosProfLayout.createSequentialGroup().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JCBUnidadF, -2, 467, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCargo, -2, 379, -2).addGap(18, 18, 18).addComponent(this.JCH_Planta).addGap(0, 0, 32767)).addGroup(JPIDatosProfLayout.createSequentialGroup().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JDFFechaIngreso, -2, 131, -2).addGap(18, 18, 18).addComponent(this.JTFFSalario, -2, 170, -2)).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 319, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JSPFRiesgoArp, -2, 111, -2).addGap(3, 3, 3).addComponent(this.JCBTpclasificasion, -2, 318, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 144, 32767).addComponent(this.JPI_FUtilizacion, -2, -1, -2)).addGroup(JPIDatosProfLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JCHFijo).addGap(29, 29, 29).addComponent(this.JCHLider)).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JCHSIntegral).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCantidad, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBContratos, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel8, -2, -1, -2))))).addGap(10, 10, 10)))));
        JPIDatosProfLayout.setVerticalGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadF, -1, 50, 32767).addComponent(this.JCBCargo, -1, 50, 32767).addComponent(this.JCH_Planta)).addGap(5, 5, 5).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addComponent(this.JDFFechaIngreso, -2, 67, -2).addGap(5, 5, 5).addComponent(this.JTFRuta, -2, 50, -2)).addGroup(JPIDatosProfLayout.createSequentialGroup().addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProfLayout.createSequentialGroup().addGap(7, 7, 7).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSalario, -2, 50, -2).addComponent(this.JSPFRiesgoArp, -2, 49, -2).addComponent(this.JCBTpclasificasion, -2, 51, -2))).addComponent(this.JPI_FUtilizacion, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosProfLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSIntegral).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFijo).addComponent(this.JCHLider)).addGap(17, 17, 17)).addGroup(JPIDatosProfLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel8, -2, 74, -2).addGroup(JPIDatosProfLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBContratos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFFCantidad, GroupLayout.Alignment.LEADING, -1, 50, 32767))))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 133, -2).addGap(56, 56, 56)));
        this.JTPDatosUsuario.addTab("DATOS RRHH", this.JPIDatosProf);
        this.JSPDetalleSgc.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleSgc.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.19
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JSPDetalleSgcMouseClicked(evt);
            }
        });
        this.JTDetalleSgc.setFont(new Font("Arial", 1, 12));
        this.JTDetalleSgc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleSgc.setRowHeight(25);
        this.JTDetalleSgc.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleSgc.setSelectionForeground(Color.red);
        this.JTDetalleSgc.setSelectionMode(0);
        this.JTDetalleSgc.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.20
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTDetalleSgcMouseClicked(evt);
            }
        });
        this.JSPDetalleSgc.setViewportView(this.JTDetalleSgc);
        this.JCBTProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTProceso.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.21
            public void itemStateChanged(ItemEvent evt) {
                JIFRHUsuarioCargo.this.JCBTProcesoItemStateChanged(evt);
            }
        });
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstadoSgc.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoSgc.setForeground(Color.blue);
        this.JCHEstadoSgc.setSelected(true);
        this.JCHEstadoSgc.setText("Estado");
        this.JCHEstadoSgc.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.22
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHEstadoSgcActionPerformed(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.23
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosSgcLayout = new GroupLayout(this.JPIDatosSgc);
        this.JPIDatosSgc.setLayout(JPIDatosSgcLayout);
        JPIDatosSgcLayout.setHorizontalGroup(JPIDatosSgcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSgcLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosSgcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSgcLayout.createSequentialGroup().addComponent(this.JCBTProceso, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProceso, -2, 524, -2).addGap(18, 18, 18).addComponent(this.JCHEstadoSgc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -1, 255, 32767).addContainerGap()).addGroup(JPIDatosSgcLayout.createSequentialGroup().addComponent(this.JSPDetalleSgc).addGap(20, 20, 20)))));
        JPIDatosSgcLayout.setVerticalGroup(JPIDatosSgcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSgcLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosSgcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSgcLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTProceso, -2, -1, -2).addComponent(this.JCBProceso, -2, -1, -2).addComponent(this.JCHEstadoSgc, -2, 36, -2)).addComponent(this.JBTAdicionar, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleSgc, -1, 265, 32767).addContainerGap()));
        this.JTPDatosUsuario.addTab("SGC", this.JPIDatosSgc);
        this.JCBUnidadFc.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional Contable o Centro de Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadFc.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.24
            public void itemStateChanged(ItemEvent evt) {
                JIFRHUsuarioCargo.this.JCBUnidadFcItemStateChanged(evt);
            }
        });
        this.JSPPDistribucionS.setFont(new Font("Arial", 1, 12));
        this.JSPPDistribucionS.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPDistribucionS.setToolTipText("% Distribución Salarial");
        this.JSPPDistribucionS.setBorder(BorderFactory.createTitledBorder((Border) null, "% Distribución", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDetalleUf.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleUf.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.25
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JSPDetalleUfMouseClicked(evt);
            }
        });
        this.JTDetalleUf.setFont(new Font("Arial", 1, 12));
        this.JTDetalleUf.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleUf.setRowHeight(25);
        this.JTDetalleUf.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleUf.setSelectionForeground(Color.red);
        this.JTDetalleUf.setSelectionMode(0);
        this.JTDetalleUf.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.26
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTDetalleUfMouseClicked(evt);
            }
        });
        this.JSPDetalleUf.setViewportView(this.JTDetalleUf);
        this.JCHEstadoUfc.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoUfc.setForeground(Color.blue);
        this.JCHEstadoUfc.setSelected(true);
        this.JCHEstadoUfc.setText("Estado");
        this.JCHEstadoUfc.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.27
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHEstadoUfcActionPerformed(evt);
            }
        });
        this.JBTAdicionarUF.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarUF.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarUF.setText("Adicionar");
        this.JBTAdicionarUF.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.28
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBTAdicionarUFActionPerformed(evt);
            }
        });
        GroupLayout JPIUnidadFLayout = new GroupLayout(this.JPIUnidadF);
        this.JPIUnidadF.setLayout(JPIUnidadFLayout);
        JPIUnidadFLayout.setHorizontalGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUnidadFLayout.createSequentialGroup().addContainerGap().addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleUf, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIUnidadFLayout.createSequentialGroup().addComponent(this.JCBUnidadFc, -2, 594, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPDistribucionS, -2, 157, -2).addGap(28, 28, 28).addComponent(this.JCHEstadoUfc).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarUF, -1, -1, 32767))).addContainerGap()));
        JPIUnidadFLayout.setVerticalGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUnidadFLayout.createSequentialGroup().addContainerGap().addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadFc, -1, 50, 32767).addComponent(this.JSPPDistribucionS, -1, 54, 32767).addComponent(this.JCHEstadoUfc, -2, 36, -2)).addComponent(this.JBTAdicionarUF, -2, 53, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleUf, -1, 268, 32767).addContainerGap()));
        this.JTPDatosUsuario.addTab("UF CONTABLE", this.JPIUnidadF);
        this.JCB_Concepto.setFont(new Font("Arial", 1, 12));
        this.JCB_Concepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Concepto.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.29
            public void itemStateChanged(ItemEvent evt) {
                JIFRHUsuarioCargo.this.JCB_ConceptoItemStateChanged(evt);
            }
        });
        this.JCB_CTercero.setFont(new Font("Arial", 1, 12));
        this.JCB_CTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_AdicionarT.setFont(new Font("Arial", 1, 12));
        this.JBT_AdicionarT.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_AdicionarT.setText("Adicionar");
        this.JBT_AdicionarT.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.30
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBT_AdicionarTActionPerformed(evt);
            }
        });
        this.JCHEstadoCnomina.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoCnomina.setForeground(Color.blue);
        this.JCHEstadoCnomina.setSelected(true);
        this.JCHEstadoCnomina.setText("Estado");
        this.JCHEstadoCnomina.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.31
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHEstadoCnominaActionPerformed(evt);
            }
        });
        this.JTFF_Valor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Empleado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Valor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFF_Valor.setHorizontalAlignment(4);
        this.JTFF_Valor.setToolTipText("Valor empleado");
        this.JTFF_Valor.setFont(new Font("Arial", 1, 12));
        this.JTFF_Valor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.32
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JTFF_ValorActionPerformed(evt);
            }
        });
        this.JTFF_Valor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Valor1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JTFF_Valor1.setHorizontalAlignment(4);
        this.JTFF_Valor1.setToolTipText("Valor Empresa");
        this.JTFF_Valor1.setFont(new Font("Arial", 1, 12));
        this.JTFF_Valor1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.33
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JTFF_Valor1ActionPerformed(evt);
            }
        });
        this.JBT_AdicionarT1.setFont(new Font("Arial", 1, 12));
        this.JBT_AdicionarT1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBT_AdicionarT1.setText("Valor Fijo");
        this.JBT_AdicionarT1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.34
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBT_AdicionarT1ActionPerformed(evt);
            }
        });
        this.JSP_CHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_CNHistorico.setFont(new Font("Arial", 1, 12));
        this.JTB_CNHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_CNHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_CNHistorico.setSelectionForeground(Color.red);
        this.JTB_CNHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.35
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTB_CNHistoricoMouseClicked(evt);
            }
        });
        this.JTB_CNHistorico.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.36
            public void keyPressed(KeyEvent evt) {
                JIFRHUsuarioCargo.this.JTB_CNHistoricoKeyPressed(evt);
            }
        });
        this.JSP_CHistorico.setViewportView(this.JTB_CNHistorico);
        GroupLayout JPI_CDetalleLayout = new GroupLayout(this.JPI_CDetalle);
        this.JPI_CDetalle.setLayout(JPI_CDetalleLayout);
        JPI_CDetalleLayout.setHorizontalGroup(JPI_CDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_CDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CDetalleLayout.createSequentialGroup().addGroup(JPI_CDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CDetalleLayout.createSequentialGroup().addComponent(this.JCB_CTercero, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstadoCnomina)).addGroup(JPI_CDetalleLayout.createSequentialGroup().addComponent(this.JCB_Concepto, -2, 540, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_Valor, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_Valor1, -2, 138, -2).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_CDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_AdicionarT, -2, 140, -2).addComponent(this.JBT_AdicionarT1, -2, 139, -2)).addGap(21, 21, 21)).addGroup(JPI_CDetalleLayout.createSequentialGroup().addComponent(this.JSP_CHistorico).addContainerGap()))));
        JPI_CDetalleLayout.setVerticalGroup(JPI_CDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CDetalleLayout.createSequentialGroup().addGroup(JPI_CDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JBT_AdicionarT, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)).addGroup(JPI_CDetalleLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPI_CDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_Valor).addComponent(this.JCB_Concepto, -2, 50, -2).addComponent(this.JTFF_Valor1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_CDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_CDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstadoCnomina, -2, 30, -2).addComponent(this.JBT_AdicionarT1, -2, 50, -2)).addComponent(this.JCB_CTercero, -2, 50, -2)).addGap(11, 11, 11))).addComponent(this.JSP_CHistorico, -2, 194, -2).addGap(69, 69, 69)));
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_CDetalle, -1, -1, 32767).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_CDetalle, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPDatosUsuario.addTab("CONCEPTO DE NOMINA", this.jPanel6);
        this.JTPDetalleFami.setForeground(Color.red);
        this.JTPDetalleFami.setFont(new Font("Arial", 1, 14));
        this.JPDPrincipales.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBParentesco.setFont(new Font("Arial", 1, 12));
        this.JCBParentesco.setBorder(BorderFactory.createTitledBorder((Border) null, "Parentesco", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTpDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTpDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNDoc.setFont(new Font("Arial", 1, 13));
        this.JTFNDoc.setToolTipText("");
        this.JTFNDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Doc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSexoF.setFont(new Font("Arial", 1, 12));
        this.JCBSexoF.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFApellido1.setFont(new Font("Arial", 1, 13));
        this.JTFApellido1.setToolTipText("");
        this.JTFApellido1.setBorder(BorderFactory.createTitledBorder((Border) null, "1° Apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFApellido2.setFont(new Font("Arial", 1, 13));
        this.JTFApellido2.setToolTipText("");
        this.JTFApellido2.setBorder(BorderFactory.createTitledBorder((Border) null, "2° Apellido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre1.setFont(new Font("Arial", 1, 13));
        this.JTFNombre1.setToolTipText("");
        this.JTFNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "1° Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre2.setFont(new Font("Arial", 1, 13));
        this.JTFNombre2.setToolTipText("");
        this.JTFNombre2.setBorder(BorderFactory.createTitledBorder((Border) null, "2° Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFamiliaf.setFont(new Font("Arial", 1, 12));
        this.JCHFamiliaf.setForeground(Color.blue);
        this.JCHFamiliaf.setSelected(true);
        this.JCHFamiliaf.setText("Estado");
        this.JCHFamiliaf.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.37
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHFamiliafActionPerformed(evt);
            }
        });
        this.JDCFechaExpDocF1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Expedición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaExpDocF1.setToolTipText("Fecha de expedición del documento de identidad");
        this.JDCFechaExpDocF1.setFont(new Font("Arial", 1, 12));
        this.JCBMpioExpedicionF2.setFont(new Font("Arial", 1, 12));
        this.JCBMpioExpedicionF2.setToolTipText("Lugar de expedición del documento de identidad");
        this.JCBMpioExpedicionF2.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio Expedición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaNacimientoF1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Nacimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaNacimientoF1.setFont(new Font("Arial", 1, 12));
        this.JCBMpioNacimientoF1.setFont(new Font("Arial", 1, 12));
        this.JCBMpioNacimientoF1.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio de Nacimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Observacion4.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcionF1.setFont(new Font("Arial", 1, 12));
        this.JSP_Observacion4.setViewportView(this.JTADescripcionF1);
        this.JBTAdicionarUF2.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarUF2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarUF2.setText("Adicionar");
        this.JBTAdicionarUF2.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.38
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBTAdicionarUF2ActionPerformed(evt);
            }
        });
        GroupLayout JPDPrincipalesLayout = new GroupLayout(this.JPDPrincipales);
        this.JPDPrincipales.setLayout(JPDPrincipalesLayout);
        JPDPrincipalesLayout.setHorizontalGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalesLayout.createSequentialGroup().addContainerGap().addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalesLayout.createSequentialGroup().addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFApellido1, -2, 338, -2).addComponent(this.JTFNombre1, -2, 338, -2)).addGap(18, 18, 18).addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalesLayout.createSequentialGroup().addComponent(this.JDCFechaNacimientoF1, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMpioNacimientoF1, -2, 311, -2)).addGroup(JPDPrincipalesLayout.createSequentialGroup().addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalesLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JTFNombre2, -2, 367, -2)).addComponent(this.JTFApellido2, -2, 368, -2)).addGap(98, 98, 98).addComponent(this.JCHFamiliaf, -2, 81, -2))).addContainerGap(-1, 32767)).addGroup(JPDPrincipalesLayout.createSequentialGroup().addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBParentesco, -2, 284, -2).addGroup(JPDPrincipalesLayout.createSequentialGroup().addComponent(this.JDCFechaExpDocF1, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBSexoF, -2, 100, -2))).addGap(18, 18, 18).addComponent(this.JCBTpDocumento, -2, 165, -2).addGap(18, 18, 18).addComponent(this.JTFNDoc, -2, 194, -2).addGap(18, 18, 18).addComponent(this.JCBMpioExpedicionF2, -2, 305, -2).addGap(0, 0, 32767)).addGroup(JPDPrincipalesLayout.createSequentialGroup().addComponent(this.JSP_Observacion4, -2, 724, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionarUF2, -2, 202, -2).addGap(30, 30, 30)))));
        JPDPrincipalesLayout.setVerticalGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalesLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBParentesco, -2, 50, -2).addComponent(this.JCBTpDocumento, -2, 50, -2).addComponent(this.JTFNDoc, -2, 44, -2).addComponent(this.JCBMpioExpedicionF2, -2, -1, -2)).addGap(10, 10, 10).addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaExpDocF1, -2, 50, -2).addComponent(this.JCBSexoF, -2, 50, -2).addComponent(this.JDCFechaNacimientoF1, -2, 50, -2).addComponent(this.JCBMpioNacimientoF1, -2, 50, -2)).addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalesLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFApellido1, -2, -1, -2).addComponent(this.JTFApellido2, -2, 43, -2)).addGap(12, 12, 12).addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre1, -2, -1, -2).addComponent(this.JTFNombre2, -2, -1, -2))).addGroup(JPDPrincipalesLayout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.JCHFamiliaf, -2, 50, -2))).addGroup(JPDPrincipalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalesLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSP_Observacion4, -1, 83, 32767).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, JPDPrincipalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionarUF2, -2, 53, -2).addGap(25, 25, 25)))));
        this.JTPDetalleFami.addTab("DATOS PRINCIPALES", this.JPDPrincipales);
        this.JPDAdicional.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleF.setFont(new Font("Arial", 1, 12));
        this.JTDetalleF.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleF.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleF.setSelectionForeground(Color.red);
        this.JTDetalleF.setSelectionMode(0);
        this.JTDetalleF.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.39
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTDetalleFMouseClicked(evt);
            }
        });
        this.jScrollPane5.setViewportView(this.JTDetalleF);
        GroupLayout JPDAdicionalLayout = new GroupLayout(this.JPDAdicional);
        this.JPDAdicional.setLayout(JPDAdicionalLayout);
        JPDAdicionalLayout.setHorizontalGroup(JPDAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane5, -1, 1115, 32767));
        JPDAdicionalLayout.setVerticalGroup(JPDAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDAdicionalLayout.createSequentialGroup().addComponent(this.jScrollPane5, -2, 343, -2).addGap(0, 0, 32767)));
        this.JTPDetalleFami.addTab("HISTÓRICO", this.JPDAdicional);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JTPDetalleFami).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JTPDetalleFami, -2, 370, -2).addGap(0, 0, 32767)));
        this.JTPDatosUsuario.addTab("DATOS FAMILIA", this.jPanel3);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        this.JCBEstudio.setFont(new Font("Arial", 1, 12));
        this.JCBEstudio.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel de Estudio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jTextField1.setFont(new Font("Arial", 1, 12));
        this.jTextField1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstadoEstudio.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoEstudio.setForeground(Color.blue);
        this.JCHEstadoEstudio.setSelected(true);
        this.JCHEstadoEstudio.setText("Estado");
        this.JCHEstadoEstudio.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.40
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHEstadoEstudioActionPerformed(evt);
            }
        });
        this.JBTAdicionarES.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarES.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarES.setText("Adicionar");
        this.JBTAdicionarES.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.41
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBTAdicionarESActionPerformed(evt);
            }
        });
        this.JTFRutaSoporte2.setFont(new Font("Arial", 1, 12));
        this.JTFRutaSoporte2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaSoporte2.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.42
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTFRutaSoporte2MouseClicked(evt);
            }
        });
        this.JTFRutaSoporte2.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.43
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JTFRutaSoporte2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jTextField1, -2, 779, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addComponent(this.JBTAdicionarES, -2, 163, -2).addContainerGap()).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBEstudio, -2, 310, -2).addGap(18, 18, 18).addComponent(this.JTFRutaSoporte2, -2, 520, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstadoEstudio).addGap(38, 38, 38)))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEstudio, -2, -1, -2).addComponent(this.JCHEstadoEstudio, -2, 36, -2).addComponent(this.JTFRutaSoporte2, -2, 50, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField1, -2, 58, -2).addComponent(this.JBTAdicionarES, -2, 53, -2)).addContainerGap(-1, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICÓ", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleEstudio.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEstudio.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleEstudio.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleEstudio.setSelectionForeground(Color.red);
        this.JTDetalleEstudio.setSelectionMode(0);
        this.JTDetalleEstudio.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.44
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTDetalleEstudioMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalleEstudio);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, -2, 1006, -2).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel2, -2, -1, -2).addGap(10, 10, 10).addComponent(this.jScrollPane1, -1, 165, 32767).addContainerGap()));
        this.JTPDatosUsuario.addTab("ESTUDIOS", this.jPanel1);
        this.JTPDatosLaboral.setForeground(Color.red);
        this.JTPDatosLaboral.setFont(new Font("Arial", 1, 14));
        this.JPDprincipalLaboral.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDprincipalLaboral.setLayout(new AbsoluteLayout());
        this.JTFNombreE.setFont(new Font("Arial", 1, 13));
        this.JTFNombreE.setToolTipText("");
        this.JTFNombreE.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDprincipalLaboral.add(this.JTFNombreE, new AbsoluteConstraints(6, 25, 624, 50));
        this.JCBMpioLaboral.setFont(new Font("Arial", 1, 12));
        this.JCBMpioLaboral.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDprincipalLaboral.add(this.JCBMpioLaboral, new AbsoluteConstraints(640, 20, 370, 50));
        this.JTFDireccion.setFont(new Font("Arial", 1, 13));
        this.JTFDireccion.setToolTipText("");
        this.JTFDireccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDprincipalLaboral.add(this.JTFDireccion, new AbsoluteConstraints(6, 80, 400, 50));
        this.JTFCargo.setFont(new Font("Arial", 1, 13));
        this.JTFCargo.setToolTipText("");
        this.JTFCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDprincipalLaboral.add(this.JTFCargo, new AbsoluteConstraints(412, 80, 600, 50));
        this.JTFJefe.setFont(new Font("Arial", 1, 13));
        this.JTFJefe.setToolTipText("");
        this.JTFJefe.setBorder(BorderFactory.createTitledBorder((Border) null, "Jefe", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDprincipalLaboral.add(this.JTFJefe, new AbsoluteConstraints(10, 160, 310, 50));
        this.JTFTiempoL.setFont(new Font("Arial", 1, 13));
        this.JTFTiempoL.setToolTipText("");
        this.JTFTiempoL.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiempo Laborado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDprincipalLaboral.add(this.JTFTiempoL, new AbsoluteConstraints(330, 160, 140, 50));
        this.JPI_TipoPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE VINCULACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.buttonGroup2.add(this.JRBTfijo);
        this.JRBTfijo.setFont(new Font("Arial", 1, 12));
        this.JRBTfijo.setForeground(Color.blue);
        this.JRBTfijo.setText("Termino Fijo");
        this.JRBTfijo.setName("JRBTfijo");
        this.JRBTfijo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.45
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JRBTfijoActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.JRBTindefinido);
        this.JRBTindefinido.setFont(new Font("Arial", 1, 12));
        this.JRBTindefinido.setForeground(Color.blue);
        this.JRBTindefinido.setText("Termino Indefinido");
        this.JRBTindefinido.setName("JRBEntregable");
        this.JRBTindefinido.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.46
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JRBTindefinidoActionPerformed(evt);
            }
        });
        GroupLayout JPI_TipoPersonaLayout = new GroupLayout(this.JPI_TipoPersona);
        this.JPI_TipoPersona.setLayout(JPI_TipoPersonaLayout);
        JPI_TipoPersonaLayout.setHorizontalGroup(JPI_TipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoPersonaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTfijo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBTindefinido).addContainerGap(-1, 32767)));
        JPI_TipoPersonaLayout.setVerticalGroup(JPI_TipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoPersonaLayout.createSequentialGroup().addGroup(JPI_TipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTfijo).addComponent(this.JRBTindefinido, -2, 24, -2)).addGap(10, 10, 10)));
        this.JPDprincipalLaboral.add(this.JPI_TipoPersona, new AbsoluteConstraints(500, 150, 260, 60));
        this.JCHEstadoLaboral.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoLaboral.setForeground(Color.blue);
        this.JCHEstadoLaboral.setSelected(true);
        this.JCHEstadoLaboral.setText("Estado");
        this.JCHEstadoLaboral.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.47
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHEstadoLaboralActionPerformed(evt);
            }
        });
        this.JPDprincipalLaboral.add(this.JCHEstadoLaboral, new AbsoluteConstraints(780, 170, -1, 30));
        this.JBTAdicionarDc1.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarDc1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarDc1.setText("Adicionar");
        this.JBTAdicionarDc1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.48
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBTAdicionarDc1ActionPerformed(evt);
            }
        });
        this.JPDprincipalLaboral.add(this.JBTAdicionarDc1, new AbsoluteConstraints(860, 150, 150, 60));
        this.JDFFechaTerminacionDeContrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Terminacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaTerminacionDeContrato.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaTerminacionDeContrato.setFont(new Font("Arial", 1, 12));
        this.JPDprincipalLaboral.add(this.JDFFechaTerminacionDeContrato, new AbsoluteConstraints(10, 220, 180, 60));
        this.JCBTipoTrabajador.setFont(new Font("Arial", 1, 12));
        this.JCBTipoTrabajador.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Trabajador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDprincipalLaboral.add(this.JCBTipoTrabajador, new AbsoluteConstraints(490, 230, 300, 50));
        this.JCBSubTipoTrabajador.setFont(new Font("Arial", 1, 12));
        this.JCBSubTipoTrabajador.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Dependiente pensionado por vejez activo"}));
        this.JCBSubTipoTrabajador.setSelectedIndex(-1);
        this.JCBSubTipoTrabajador.setBorder(BorderFactory.createTitledBorder((Border) null, "SubTipo Trabajador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDprincipalLaboral.add(this.JCBSubTipoTrabajador, new AbsoluteConstraints(800, 230, 300, 50));
        this.JCHEstadoLaboral1.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoLaboral1.setForeground(Color.blue);
        this.JCHEstadoLaboral1.setSelected(true);
        this.JCHEstadoLaboral1.setLabel("Alto Riesgo Pension");
        this.JCHEstadoLaboral1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.49
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHEstadoLaboral1ActionPerformed(evt);
            }
        });
        this.JPDprincipalLaboral.add(this.JCHEstadoLaboral1, new AbsoluteConstraints(640, 330, 150, 30));
        this.JCBTipoContrato.setFont(new Font("Arial", 1, 12));
        this.JCBTipoContrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Contrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDprincipalLaboral.add(this.JCBTipoContrato, new AbsoluteConstraints(210, 230, 270, 50));
        this.JTPDatosLaboral.addTab("DATOS PRINCIPALES", this.JPDprincipalLaboral);
        this.JPHistoricoLaboral.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleINF.setFont(new Font("Arial", 1, 12));
        this.JTDetalleINF.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleINF.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleINF.setSelectionForeground(Color.red);
        this.JTDetalleINF.setSelectionMode(0);
        this.JTDetalleINF.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.50
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTDetalleINFMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTDetalleINF);
        GroupLayout JPHistoricoLaboralLayout = new GroupLayout(this.JPHistoricoLaboral);
        this.JPHistoricoLaboral.setLayout(JPHistoricoLaboralLayout);
        JPHistoricoLaboralLayout.setHorizontalGroup(JPHistoricoLaboralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLaboralLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 1103, 32767).addContainerGap()));
        JPHistoricoLaboralLayout.setVerticalGroup(JPHistoricoLaboralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLaboralLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 304, -2).addGap(10, 10, 10)));
        this.JTPDatosLaboral.addTab("HISTORICO", this.JPHistoricoLaboral);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosLaboral));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosLaboral));
        this.JTPDatosUsuario.addTab("INFORMACION LABORAL", this.jPanel4);
        this.JTPDocumentos.setForeground(Color.red);
        this.JTPDocumentos.setFont(new Font("Arial", 1, 14));
        this.JPDPrincipalDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstadoDoc.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoDoc.setForeground(Color.blue);
        this.JCHEstadoDoc.setSelected(true);
        this.JCHEstadoDoc.setText("Estado");
        this.JCHEstadoDoc.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.51
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHEstadoDocActionPerformed(evt);
            }
        });
        this.JTFRutaSoporte.setFont(new Font("Arial", 1, 12));
        this.JTFRutaSoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaSoporte.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.52
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTFRutaSoporteMouseClicked(evt);
            }
        });
        this.JTFRutaSoporte.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.53
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JTFRutaSoporteActionPerformed(evt);
            }
        });
        this.JSP_Observacion3.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTA_ObservacionDoc.setFont(new Font("Arial", 1, 12));
        this.JSP_Observacion3.setViewportView(this.JTA_ObservacionDoc);
        this.JBTAdicionarDc.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarDc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarDc.setText("Adicionar");
        this.JBTAdicionarDc.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.54
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBTAdicionarDcActionPerformed(evt);
            }
        });
        GroupLayout JPDPrincipalDocLayout = new GroupLayout(this.JPDPrincipalDoc);
        this.JPDPrincipalDoc.setLayout(JPDPrincipalDocLayout);
        JPDPrincipalDocLayout.setHorizontalGroup(JPDPrincipalDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalDocLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPDPrincipalDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalDocLayout.createSequentialGroup().addComponent(this.JSP_Observacion3).addGroup(JPDPrincipalDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalDocLayout.createSequentialGroup().addGap(64, 64, 64).addComponent(this.JBTAdicionarDc, -2, 163, -2)).addGroup(JPDPrincipalDocLayout.createSequentialGroup().addGap(87, 87, 87).addComponent(this.JCHEstadoDoc, -2, 81, -2))).addGap(55, 55, 55)).addGroup(JPDPrincipalDocLayout.createSequentialGroup().addComponent(this.JCBDocumento, -2, 322, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRutaSoporte, -2, 653, -2).addGap(0, 0, 32767)))));
        JPDPrincipalDocLayout.setVerticalGroup(JPDPrincipalDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalDocLayout.createSequentialGroup().addContainerGap().addGroup(JPDPrincipalDocLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDocumento, -2, 50, -2).addComponent(this.JTFRutaSoporte, -2, 50, -2)).addGroup(JPDPrincipalDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalDocLayout.createSequentialGroup().addGap(52, 52, 52).addComponent(this.JCHEstadoDoc, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JBTAdicionarDc, -2, 53, -2)).addGroup(JPDPrincipalDocLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JSP_Observacion3, -2, 164, -2))).addContainerGap(59, 32767)));
        this.JTPDocumentos.addTab("DATOS PRINCIPALES", this.JPDPrincipalDoc);
        this.JTDetalleDc.setFont(new Font("Arial", 1, 12));
        this.JTDetalleDc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleDc.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleDc.setSelectionForeground(Color.red);
        this.JTDetalleDc.setSelectionMode(0);
        this.JTDetalleDc.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.55
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTDetalleDcMouseClicked(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.JTDetalleDc);
        GroupLayout JPHistoricoDocLayout = new GroupLayout(this.JPHistoricoDoc);
        this.JPHistoricoDoc.setLayout(JPHistoricoDocLayout);
        JPHistoricoDocLayout.setHorizontalGroup(JPHistoricoDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoDocLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jScrollPane4, -1, 1099, 32767).addGap(10, 10, 10)));
        JPHistoricoDocLayout.setVerticalGroup(JPHistoricoDocLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoDocLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jScrollPane4, -1, 288, 32767).addContainerGap()));
        this.JTPDocumentos.addTab("HISTORICO", this.JPHistoricoDoc);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JTPDocumentos).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JTPDocumentos).addContainerGap()));
        this.JTPDatosUsuario.addTab("DOCUMENTO", this.jPanel5);
        this.JPDPrincipalDoc1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCB_TipoB.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoB.setBorder(BorderFactory.createTitledBorder((Border) null, "Base de Datos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado_BD.setFont(new Font("Arial", 1, 12));
        this.JCHEstado_BD.setForeground(Color.blue);
        this.JCHEstado_BD.setSelected(true);
        this.JCHEstado_BD.setText("Estado");
        this.JCHEstado_BD.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.56
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCHEstado_BDActionPerformed(evt);
            }
        });
        this.JBT_AdicionarBD.setFont(new Font("Arial", 1, 12));
        this.JBT_AdicionarBD.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_AdicionarBD.setText("Adicionar");
        this.JBT_AdicionarBD.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.57
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JBT_AdicionarBDActionPerformed(evt);
            }
        });
        this.JSP_DetalleB.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_DetalleBD.setFont(new Font("Arial", 1, 12));
        this.JTB_DetalleBD.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_DetalleBD.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_DetalleBD.setSelectionForeground(Color.red);
        this.JTB_DetalleBD.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.58
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JTB_DetalleBDMouseClicked(evt);
            }
        });
        this.JSP_DetalleB.setViewportView(this.JTB_DetalleBD);
        GroupLayout JPDPrincipalDoc1Layout = new GroupLayout(this.JPDPrincipalDoc1);
        this.JPDPrincipalDoc1.setLayout(JPDPrincipalDoc1Layout);
        JPDPrincipalDoc1Layout.setHorizontalGroup(JPDPrincipalDoc1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalDoc1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCB_TipoB, -2, 322, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 400, 32767).addComponent(this.JCHEstado_BD, -2, 81, -2).addGap(32, 32, 32).addComponent(this.JBT_AdicionarBD, -2, 163, -2).addContainerGap()).addGroup(JPDPrincipalDoc1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalDoc1Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JSP_DetalleB, -1, 994, 32767).addGap(8, 8, 8))));
        JPDPrincipalDoc1Layout.setVerticalGroup(JPDPrincipalDoc1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalDoc1Layout.createSequentialGroup().addContainerGap().addGroup(JPDPrincipalDoc1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_TipoB, -2, 50, -2).addComponent(this.JBT_AdicionarBD, -2, 53, -2).addComponent(this.JCHEstado_BD, -2, 50, -2)).addContainerGap(282, 32767)).addGroup(JPDPrincipalDoc1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPrincipalDoc1Layout.createSequentialGroup().addGap(89, 89, 89).addComponent(this.JSP_DetalleB, -2, 238, -2).addContainerGap(17, 32767))));
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPDPrincipalDoc1, -2, -1, -2).addGap(0, 0, 32767)));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPDPrincipalDoc1, -2, -1, -2).addGap(0, 0, 32767)));
        this.JTPDatosUsuario.addTab("TIPO BASE", this.jPanel7);
        this.JCBFormaPago.setFont(new Font("Arial", 1, 12));
        this.JCBFormaPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFormaPago.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.59
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JCBFormaPagoMouseClicked(evt);
            }
        });
        this.JCBFormaPago.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.60
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCBFormaPagoActionPerformed(evt);
            }
        });
        this.JCBMetodoDePago.setFont(new Font("Arial", 1, 12));
        this.JCBMetodoDePago.setBorder(BorderFactory.createTitledBorder((Border) null, "Metodo de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMetodoDePago.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHUsuarioCargo.61
            public void mouseClicked(MouseEvent evt) {
                JIFRHUsuarioCargo.this.JCBMetodoDePagoMouseClicked(evt);
            }
        });
        this.JCBMetodoDePago.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHUsuarioCargo.62
            public void actionPerformed(ActionEvent evt) {
                JIFRHUsuarioCargo.this.JCBMetodoDePagoActionPerformed(evt);
            }
        });
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBFormaPago, -2, 197, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBMetodoDePago, -2, 555, -2).addGap(302, 302, 302)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMetodoDePago, -2, 46, -2).addComponent(this.JCBFormaPago, -2, 46, -2)).addContainerGap(20, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel9, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 4, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFDatosUsuario, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JTPDatosUsuario, GroupLayout.Alignment.TRAILING, -2, -1, -2)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addGap(35, 35, 35).addComponent(this.jPanel9, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTPDatosUsuario, -2, 386, -2).addContainerGap()));
        getAccessibleContext().setAccessibleName("usuario");
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaSoporteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaSoporteMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmetodos.getDirectorioExportacion());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRutaSoporte.setText(this.xmetodos.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoDocActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoDoc.isSelected()) {
            this.xestadodoc = 1;
        } else {
            this.xestadodoc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoLaboralActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoLaboral.isSelected()) {
            this.xestadoInL = 1;
        } else {
            this.xestadoInL = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTindefinidoActionPerformed(ActionEvent evt) {
        this.xTipoV = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTfijoActionPerformed(ActionEvent evt) {
        this.xTipoV = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoEstudioActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoEstudio.isSelected()) {
            this.xestadoestudio = 1;
        } else {
            this.xestadoestudio = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFamiliafActionPerformed(ActionEvent evt) {
        if (this.JCHFamiliaf.isSelected()) {
            this.xestadofamilia = 1;
        } else {
            this.xestadofamilia = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarUFActionPerformed(ActionEvent evt) {
        String sql;
        if (this.JCBUnidadFc.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBUnidadFc.requestFocus();
            return;
        }
        if (Double.valueOf(this.JSPPDistribucionS.getValue().toString()).doubleValue() != 0.0d) {
            if (!this.xjppersona.getIdPersona().equals("")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xgrabarufc) {
                        sql = "update rh_nomina_persona_unidadf set Estado='" + this.xestadouf + "', Porcentaje='" + this.JSPPDistribucionS.getValue() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_UnidadF='" + this.xidunidadfc[this.JCBUnidadFc.getSelectedIndex()] + "' and Id_personaCargo='" + Principal.txtNo.getText() + "'";
                    } else {
                        sql = "insert ignore into rh_nomina_persona_unidadf(Id_personaCargo, Id_UnidadF, Porcentaje, UsuarioS) values('" + Principal.txtNo.getText() + "','" + this.xidunidadfc[this.JCBUnidadFc.getSelectedIndex()] + "','" + this.JSPPDistribucionS.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                    this.xconsultas.ejecutarSQL(sql);
                    this.xconsultas.cerrarConexionBd();
                    mCargarDatosTablaUf();
                    this.xgrabarufc = false;
                    this.JCBUnidadFc.setSelectedIndex(-1);
                    this.JCHEstadoUfc.setSelected(true);
                    this.xestadouf = 1;
                    this.JCBUnidadFc.requestFocus();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La distribucion debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBProceso.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoUfcActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoUfc.isSelected()) {
            this.xestadouf = 1;
        } else {
            this.xestadouf = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleUfMouseClicked(MouseEvent evt) {
        if (this.JTDetalleUf.getSelectedRow() != -1) {
            this.JCBUnidadFc.setSelectedItem(this.xmodeloufc.getValueAt(this.JTDetalleUf.getSelectedRow(), 0));
            this.JSPPDistribucionS.setValue(this.xmodeloufc.getValueAt(this.JTDetalleUf.getSelectedRow(), 1));
            this.JCHEstadoUfc.setSelected(Boolean.valueOf(this.xmodeloufc.getValueAt(this.JTDetalleUf.getSelectedRow(), 2).toString()).booleanValue());
            this.xgrabarufc = true;
            mNuevo_ConceptoNomina();
            mCargarDatos_CN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFcItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        String sql;
        if (this.JCBTProceso.getSelectedIndex() != -1) {
            if (this.JCBProceso.getSelectedIndex() != -1) {
                if (!this.xjppersona.getIdPersona().equals("")) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (this.xgrabarsgc) {
                            sql = "update s_sgc_usuario_tipoproceso set Estado='" + this.xestadosgc + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_TipoProceso='" + this.xidproceso[this.JCBProceso.getSelectedIndex()][0] + "' and Id_Usuario='" + this.xjppersona.getIdPersona() + "'";
                        } else {
                            sql = "insert ignore into s_sgc_usuario_tipoproceso(Id_TipoProceso, Id_Usuario, Estado, UsuarioS) values('" + this.xidproceso[this.JCBProceso.getSelectedIndex()][0] + "','" + this.xjppersona.getIdPersona() + "','" + this.xestadosgc + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        this.xconsultas.ejecutarSQL(sql);
                        this.xconsultas.cerrarConexionBd();
                        mCargarDatosTablaSgc(this.xjppersona.getIdPersona());
                        this.xgrabarsgc = false;
                        this.JCBProceso.removeAllItems();
                        this.JCBTProceso.setSelectedIndex(-1);
                        this.JCHEstadoSgc.setSelected(true);
                        this.xestadosgc = 1;
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProceso.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTProceso.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoSgcActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoSgc.isSelected()) {
            this.xestadosgc = 1;
        } else {
            this.xestadosgc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTProcesoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTProceso.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBProceso.removeAllItems();
            this.xidproceso = xct1.llenarComboyLista("SELECT Id, Nbre, correo FROM s_sgc_tipoproceso WHERE (Id_Proceso ='" + this.xidtipop[this.JCBTProceso.getSelectedIndex()] + "' AND Estado =1) ORDER BY Nbre ASC", this.xidproceso, this.JCBProceso, 3);
            this.JCBProceso.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSgcMouseClicked(MouseEvent evt) {
        if (this.JTDetalleSgc.getSelectedRow() != -1) {
            this.JCBTProceso.setSelectedItem(this.xmodelosgc.getValueAt(this.JTDetalleSgc.getSelectedRow(), 0));
            this.JCBProceso.setSelectedItem(this.xmodelosgc.getValueAt(this.JTDetalleSgc.getSelectedRow(), 1));
            this.JCHEstadoSgc.setSelected(Boolean.valueOf(this.xmodelosgc.getValueAt(this.JTDetalleSgc.getSelectedRow(), 2).toString()).booleanValue());
            System.out.println(this.xgrabares);
            this.xgrabares = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
        if (this.JTDetalleC.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0).toString());
            this.JCBUnidadF.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 1).toString());
            this.JCBCargo.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString());
            this.JCHLider.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 3).toString()).booleanValue());
            this.JCHFijo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 4).toString()).booleanValue());
            this.JTFRuta.setText(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 5).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 6).toString()).booleanValue());
            this.JDFFechaIngreso.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 7).toString()));
            this.JTFFSalario.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 8).toString()));
            this.JCHSIntegral.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 9).toString()).booleanValue());
            this.JSPFRiesgoArp.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 10).toString()));
            this.JCBTpclasificasion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 11).toString());
            if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 12).toString()).intValue() == 0) {
                this.JRB_FP_Dias.setSelected(true);
                this.xformapago = 0;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 12).toString()).intValue() == 1) {
                this.JRB_FP_Horas.setSelected(true);
                this.xformapago = 1;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 12).toString()).intValue() == 2) {
                this.JRB_FP_Jornal.setSelected(true);
                this.xformapago = 2;
            }
            this.JTFFCantidad.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 13).toString()));
            this.JTFCodigoD785.setText(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 14).toString());
            this.JTFGrado.setText(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 15).toString());
            this.JCH_Planta.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 16).toString()).booleanValue());
            mChangeCantidad();
            mCargarDatosTablaBD();
            mIniciarCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFijoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHLiderActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmetodos.getDirectorioExportacion() + "Firmas");
            FileNameExtensionFilter Imagenes = new FileNameExtensionFilter("Archivos de Imagenes (bmp, jpg, jpeg, png)", new String[]{"bmp", "jpg", "jpeg", "png"});
            xfilec.addChoosableFileFilter(Imagenes);
            xfilec.setAcceptAllFileFilterUsed(false);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getPath());
                this.JTFRuta.setText(this.xfile.getName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSIntegralActionPerformed(ActionEvent evt) {
        if (this.JCHSIntegral.isSelected()) {
            this.xesintegral = 1;
        } else {
            this.xesintegral = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadF.getSelectedIndex() != -1) {
            this.xlleno1 = false;
            this.JCBCargo.removeAllItems();
            String sql = "SELECT rh_unidadf_cargo.Id, rh_tipo_cargo.Nbre, rh_tipo_cargo.`Codigo` FROM rh_unidadf_cargo INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id) WHERE (rh_unidadf_cargo.Estado =1 AND rh_unidadf_cargo.Id_UnidadF ='" + this.xidunidadf[this.JCBUnidadF.getSelectedIndex()] + "' ) order by rh_tipo_cargo.Nbre";
            this.xidcargo = this.xconsultas.llenarComboyLista(sql, this.xidcargo, this.JCBCargo, 3);
            this.JCBCargo.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
            this.xlleno1 = true;
            this.JCBUnidadF.setActionCommand(this.JTFJefe.getSelectedText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarESActionPerformed(ActionEvent evt) {
        if (this.JCBEstudio.getSelectedIndex() != -1) {
            if (!this.xjppersona.getIdPersona().equals("")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xgrabares) {
                        String sql2 = "UPDATE rh_tercero_empleado_estudios SET  Id_NIvelEstudio = '" + this.xnestudio[this.JCBEstudio.getSelectedIndex()] + "', Observacion = '" + this.jTextField1.getText().toUpperCase() + "', Estado ='" + this.xestadoestudio + "', Fecha = '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Id_UsuarioS = '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'WHERE Id = '" + this.xmodeloes.getValueAt(this.JTDetalleEstudio.getSelectedRow(), 0) + "'";
                        System.out.println(sql2);
                        this.xconsultas.ejecutarSQL(sql2);
                        this.xconsultas.cerrarConexionBd();
                    } else {
                        this.DirectorioEstudios = new File(this.xmetodos.mRutaSoporte("JIFRHUsuarioCargoEstudios"));
                        String xidDoc = this.xconsultas.ejecutarSQLId("INSERT INTO rh_tercero_empleado_estudios (Id_PersonaC,Id_NIvelEstudio, Observacion, Estado,Fecha,Id_UsuarioS)VALUES ('" + Principal.txtNo.getText() + "','" + this.xnestudio[this.JCBEstudio.getSelectedIndex()] + "','" + this.jTextField1.getText().toUpperCase() + "','" + this.xestadoestudio + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')");
                        String adjunto = xidDoc + "_" + Principal.txtNo.getText() + "_" + this.JCBEstudio.getSelectedItem() + ".pdf";
                        System.out.println(adjunto);
                        String sql = "UPDATE rh_tercero_empleado_estudios set Url_Soporte='" + this.xmetodos.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                        this.xconsultas.ejecutarSQL(sql);
                        this.xconsultas.cerrarConexionBd();
                        File f1 = new File(this.JTFRutaSoporte2.getText());
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(this.DirectorioEstudios, f2.getName()));
                    }
                    mCargarDatosTablaEstudio();
                    this.JCBEstudio.setSelectedIndex(-1);
                    this.JCHEstadoEstudio.setSelected(true);
                    this.xestadoestudio = 1;
                    this.JTFRutaSoporte2.setText("");
                    this.jTextField1.setText("");
                    this.xgrabares = false;
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un nivel de estudio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarUF2ActionPerformed(ActionEvent evt) {
        String sql;
        if (this.JCBParentesco.getSelectedIndex() != -1) {
            if (this.JCBTpDocumento.getSelectedIndex() != -1) {
                if (this.JCBMpioExpedicionF2.getSelectedIndex() != -1) {
                    if (this.JCBSexoF.getSelectedIndex() != -1) {
                        if (this.JCBMpioNacimientoF1.getSelectedIndex() != -1) {
                            if (!this.JTFApellido1.getText().isEmpty()) {
                                if (!this.JTFNombre1.getText().isEmpty()) {
                                    if (!this.xjppersona.getIdPersona().equals("")) {
                                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                        if (n == 0) {
                                            if (this.xgrabarf) {
                                                sql = "UPDATE `rh_tercero_empleado_familia`SET `Id_Parentesco` ='" + this.xparentesco[this.JCBParentesco.getSelectedIndex()] + "',  `Id_TipoDoc` = '" + this.xtipodocumento[this.JCBTpDocumento.getSelectedIndex()] + "', `Documento` =  '" + this.JTFNDoc.getText().toUpperCase() + "', `Id_MunicipioExp` = '" + this.xmunicipioex[this.JCBMpioExpedicionF2.getSelectedIndex()] + "',  `FechaExp` = '" + this.xmetodos.formatoAMD.format(this.JDCFechaExpDocF1.getDate()) + "',  `Apellido1` ='" + this.JTFApellido1.getText().toUpperCase() + "', `Apellido2` ='" + this.JTFApellido2.getText().toUpperCase() + "', `Nombre1` = '" + this.JTFNombre1.getText().toUpperCase() + "',  `Nombre2` = '" + this.JTFNombre2.getText().toUpperCase() + "',  `Id_Sexo` = '" + this.xsexo[this.JCBSexoF.getSelectedIndex()] + "',  `FechaNac` = '" + this.xmetodos.formatoAMD.format(this.JDCFechaNacimientoF1.getDate()) + "', `Id_MunicipioNac` ='" + this.xmunicipionaci[this.JCBMpioNacimientoF1.getSelectedIndex()] + "', `ObservacionG` = '" + this.JTADescripcionF1.getText().toUpperCase() + "', `Estado` =  '" + this.xestadofamilia + "', `Fecha` = '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', `Id_UsuarioS` = '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'WHERE `Id` = '" + this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 0) + "'";
                                            } else {
                                                sql = "INSERT INTO rh_tercero_empleado_familia(Id_PersonaC,Id_Parentesco,Id_TipoDoc,Documento,Id_MunicipioExp,FechaExp,Apellido1, Apellido2,Nombre1,Nombre2,Id_Sexo, FechaNac,Id_MunicipioNac, ObservacionG, Estado,Fecha, Id_UsuarioS)VALUES ('" + Principal.txtNo.getText() + "','" + this.xparentesco[this.JCBParentesco.getSelectedIndex()] + "','" + this.xtipodocumento[this.JCBTpDocumento.getSelectedIndex()] + "','" + this.JTFNDoc.getText().toUpperCase() + "','" + this.xmunicipioex[this.JCBMpioExpedicionF2.getSelectedIndex()] + "','" + this.xmetodos.formatoAMD.format(this.JDCFechaExpDocF1.getDate()) + "','" + this.JTFApellido1.getText().toUpperCase() + "','" + this.JTFApellido2.getText().toUpperCase() + "','" + this.JTFNombre1.getText().toUpperCase() + "','" + this.JTFNombre2.getText().toUpperCase() + "','" + this.xsexo[this.JCBSexoF.getSelectedIndex()] + "','" + this.xmetodos.formatoAMD.format(this.JDCFechaNacimientoF1.getDate()) + "','" + this.xmunicipionaci[this.JCBMpioNacimientoF1.getSelectedIndex()] + "','" + this.JTADescripcionF1.getText().toUpperCase() + "','" + this.xestadofamilia + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                                            }
                                            this.xconsultas.ejecutarSQL(sql);
                                            this.xconsultas.cerrarConexionBd();
                                            mCargarDatosTablaFamilia();
                                            this.xgrabarf = false;
                                            this.JCBParentesco.setSelectedIndex(-1);
                                            this.JCBTpDocumento.setSelectedIndex(-1);
                                            this.JCBMpioExpedicionF2.setSelectedIndex(-1);
                                            this.JCBSexoF.setSelectedIndex(-1);
                                            this.JCBMpioNacimientoF1.setSelectedIndex(-1);
                                            this.JCHFamiliaf.setSelected(true);
                                            this.xestadofamilia = 1;
                                            this.JTFNDoc.setText("");
                                            this.JTFApellido1.setText("");
                                            this.JTFApellido2.setText("");
                                            this.JTFNombre1.setText("");
                                            this.JTFNombre2.setText("");
                                            this.JTADescripcionF1.setText("");
                                            this.JCBParentesco.requestFocus();
                                            return;
                                        }
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe digitar un nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTFNombre1.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe digitar un apellido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFApellido1.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Fecha Nacimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBMpioNacimientoF1.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Sexo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBSexoF.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fehca de expedicion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBMpioExpedicionF2.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTpDocumento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Parentesco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBParentesco.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleFMouseClicked(MouseEvent evt) {
        if (this.JTDetalleF.getSelectedRow() != -1) {
            this.JCBParentesco.setSelectedItem(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 2).toString());
            this.JCBTpDocumento.setSelectedItem(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 3).toString());
            this.JTFNDoc.setText(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 4).toString());
            this.JCBMpioExpedicionF2.setSelectedItem(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 5).toString());
            System.out.println(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 6).toString());
            this.JDCFechaExpDocF1.setDate(this.xmetodos.getPasarTextoaFecha(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 6).toString()));
            this.JTFApellido1.setText(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 7).toString());
            this.JTFApellido2.setText(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 8).toString());
            this.JTFNombre1.setText(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 9).toString());
            this.JTFNombre2.setText(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 10).toString());
            this.JCBSexoF.setSelectedItem(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 11).toString());
            this.JDCFechaNacimientoF1.setDate(this.xmetodos.getPasarTextoaFecha(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 12).toString()));
            this.JCBMpioNacimientoF1.setSelectedItem(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 13).toString());
            this.JTADescripcionF1.setText(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 14).toString());
            this.JCHFamiliaf.setSelected(Boolean.valueOf(this.xmodelof.getValueAt(this.JTDetalleF.getSelectedRow(), 15).toString()).booleanValue());
            if (this.JCHFamiliaf.isSelected()) {
                this.xestadofamilia = 1;
            } else {
                this.xestadofamilia = 0;
            }
            this.JTPDetalleFami.setSelectedIndex(0);
            mIniciarCheck();
            this.xgrabarf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleEstudioMouseClicked(MouseEvent evt) {
        if (this.JTDetalleEstudio.getSelectedRow() != -1) {
            this.JCBEstudio.setSelectedItem(this.xmodeloes.getValueAt(this.JTDetalleEstudio.getSelectedRow(), 1));
            this.jTextField1.setText(this.xmodeloes.getValueAt(this.JTDetalleEstudio.getSelectedRow(), 2).toString());
            this.JTFRutaSoporte2.setText(this.xmodeloes.getValueAt(this.JTDetalleEstudio.getSelectedRow(), 3).toString());
            this.JCHEstadoEstudio.setSelected(Boolean.valueOf(this.xmodeloes.getValueAt(this.JTDetalleEstudio.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstadoEstudio.isSelected()) {
                this.xestadoestudio = 1;
            } else {
                this.xestadoestudio = 0;
            }
            if (evt.getClickCount() == 2) {
                this.xmetodos.mostrarPdf(this.DirectorioEstudios + "\\" + this.xmodeloes.getValueAt(this.JTDetalleEstudio.getSelectedRow(), 3).toString());
            }
            System.out.println(this.xgrabares);
            this.xgrabares = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarDcActionPerformed(ActionEvent evt) {
        if (this.JCBDocumento.getSelectedIndex() != -1) {
            if (!this.JTFRutaSoporte.getText().isEmpty()) {
                if (!this.xjppersona.getIdPersona().equals("")) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (this.xgrabardc) {
                            String sql5 = " UPDATE rh_tercero_empleado_documentos SET  Id_Documento  = '" + this.xdocumento[this.JCBDocumento.getSelectedIndex()] + "',  Observacion = '" + this.JTA_ObservacionDoc.getText().toUpperCase() + "', Estado ='" + this.xestadodoc + "',  Fecha = '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',  Id_UsuarioS = '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'WHERE Id = '" + this.xmodelodc.getValueAt(this.JTDetalleDc.getSelectedRow(), 0) + "'";
                            System.out.println(sql5);
                            this.xconsultas.ejecutarSQL(sql5);
                            this.xconsultas.cerrarConexionBd();
                        } else {
                            this.DirectorioDocumentos = new File(this.xmetodos.mRutaSoporte("JIFRHUsuarioCargoDocumentos"));
                            String sql52 = "INSERT INTO  `rh_tercero_empleado_documentos`(`Id_PersonaC`, Id_Documento, `Observacion`, `Estado`,`Fecha`,`Id_UsuarioS`)VALUES ('" + Principal.txtNo.getText() + "','" + this.xdocumento[this.JCBDocumento.getSelectedIndex()] + "','" + this.JTA_ObservacionDoc.getText().toUpperCase() + "','" + this.xestadodoc + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                            String xidDoc = this.xconsultas.ejecutarSQLId(sql52);
                            String adjunto = xidDoc + "_" + Principal.txtNo.getText() + "_" + this.JCBDocumento.getSelectedItem() + ".pdf";
                            System.out.println(sql52);
                            System.out.println(adjunto);
                            String sql53 = "UPDATE rh_tercero_empleado_documentos set Url_Soporte='" + this.xmetodos.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                            System.out.println(sql53);
                            this.xconsultas.ejecutarSQL(sql53);
                            this.xconsultas.cerrarConexionBd();
                            File f1 = new File(this.JTFRutaSoporte.getText());
                            File f2 = new File(adjunto);
                            f1.renameTo(f2);
                            f2.renameTo(new File(this.DirectorioDocumentos, f2.getName()));
                        }
                        mCargarDatosTablaDocumento();
                        this.xgrabardc = false;
                        this.JCBDocumento.setSelectedIndex(-1);
                        this.JCHEstadoDoc.setSelected(true);
                        this.xestadodoc = 1;
                        this.JTFRutaSoporte.setText("");
                        this.JTA_ObservacionDoc.setText("");
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar unusuario ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRutaSoporte.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo documento ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBDocumento.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarDc1ActionPerformed(ActionEvent evt) {
        String sql6;
        if (this.JCBMpioLaboral.getSelectedIndex() != -1) {
            if (!this.xjppersona.getIdPersona().equals("")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xgrabarilf) {
                        sql6 = "UPDATE rh_tercero_empleado_inf_laboral SET NEmpresa = '" + this.JTFNombreE.getText().toUpperCase() + "',  `Id_Municipio` =  '" + this.xmunicipionaci[this.JCBMpioLaboral.getSelectedIndex()] + "', `Direccion` = '" + this.JTFDireccion.getText().toUpperCase() + "', `Cargo` = '" + this.JTFCargo.getText().toUpperCase() + "',`Jefe` ='" + this.JTFJefe.getText().toUpperCase() + "', `TiempoL` ='" + this.JTFTiempoL.getText().toUpperCase() + "', `TVinculacion` = '" + this.xTipoV + "',  Estado ='" + this.xestadodoc + "', Fecha = '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Id_UsuarioS = '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "',`Id_TipoContrato`='" + this.xtipoContrato[this.JCBTipoContrato.getSelectedIndex()] + "', Id_TipoTrabajador= '" + this.xtipoTrabajador[this.JCBTipoTrabajador.getSelectedIndex()] + "',fechaTerminacion= '" + this.xmetodos.formatoAMD1.format(this.JDFFechaTerminacionDeContrato.getDate()) + "',SubTipoTrabajador= '" + this.xSubTipotrabajador[this.JCBSubTipoTrabajador.getSelectedIndex()] + "' WHERE Id = '" + this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 0) + "'";
                    } else {
                        sql6 = "INSERT INTO `rh_tercero_empleado_inf_laboral`(`Id_PersonaC`,`NEmpresa`,`Id_Municipio`,`Direccion`,`Cargo`,`Jefe`,`TiempoL`,`TVinculacion`,`Estado`,`Fecha`,`Id_UsuarioS`,`Id_TipoContrato`,`Id_TipoTrabajador`,fechaTerminacion, `SubTipoTrabajador`)VALUES ('" + Principal.txtNo.getText() + "','" + this.JTFNombreE.getText().toUpperCase() + "','" + this.xmunicipionaci[this.JCBMpioLaboral.getSelectedIndex()] + "','" + this.JTFDireccion.getText().toUpperCase() + "','" + this.JTFCargo.getText().toUpperCase() + "','" + this.JTFJefe.getText().toUpperCase() + "','" + this.JTFTiempoL.getText().toUpperCase() + "','" + this.xTipoV + "','" + this.xestadoInL + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "', '" + this.xtipoContrato[this.JCBTipoContrato.getSelectedIndex()] + "', '" + this.xtipoTrabajador[this.JCBTipoTrabajador.getSelectedIndex()] + "', '" + this.xmetodos.formatoAMD1.format(this.JDFFechaTerminacionDeContrato.getDate()) + "', '" + this.xSubTipotrabajador[this.JCBSubTipoTrabajador.getSelectedIndex()] + "')";
                    }
                    System.out.println(sql6);
                    this.xconsultas.ejecutarSQL(sql6);
                    this.xconsultas.cerrarConexionBd();
                    mCargarDatosTablaInfLaboral();
                    this.xgrabarilf = false;
                    this.JCBMpioLaboral.setSelectedIndex(-1);
                    this.JCHEstadoLaboral.setSelected(true);
                    this.xTipoV = 0;
                    this.xestadoInL = 1;
                    this.JTFNombreE.setText("");
                    this.JTFDireccion.setText("");
                    this.JTFCargo.setText("");
                    this.JTFJefe.setText("");
                    this.JTFCargo.setText("");
                    this.JTFTiempoL.setText("");
                    this.JRBTfijo.setSelected(false);
                    this.JRBTindefinido.setSelected(false);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaSoporte2MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmetodos.getDirectorioExportacion());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRutaSoporte2.setText(this.xmetodos.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaSoporte2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleSgcMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleDcMouseClicked(MouseEvent evt) {
        if (this.JTDetalleDc.getSelectedRow() != -1) {
            this.JCBDocumento.setSelectedItem(this.xmodelodc.getValueAt(this.JTDetalleDc.getSelectedRow(), 2));
            this.JTFRutaSoporte.setText(this.xmodelodc.getValueAt(this.JTDetalleDc.getSelectedRow(), 4).toString());
            this.JTA_ObservacionDoc.setText(this.xmodelodc.getValueAt(this.JTDetalleDc.getSelectedRow(), 3).toString());
            this.JCHEstadoDoc.setSelected(Boolean.valueOf(this.xmodelodc.getValueAt(this.JTDetalleDc.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEstadoDoc.isSelected()) {
                this.xestadodoc = 1;
            } else {
                this.xestadodoc = 0;
            }
            if (evt.getClickCount() == 2) {
                this.xmetodos.mostrarPdf(this.DirectorioDocumentos + "\\" + this.xmodelodc.getValueAt(this.JTDetalleDc.getSelectedRow(), 4).toString());
            }
            System.out.println(this.xgrabardc);
            this.xgrabardc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleINFMouseClicked(MouseEvent evt) {
        this.JTFNombreE.setText(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 2).toString());
        this.JCBMpioLaboral.setSelectedItem(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 3));
        this.JTFDireccion.setText(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 4).toString());
        this.JTFCargo.setText(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 5).toString());
        this.JTFJefe.setText(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 6).toString());
        this.JTFTiempoL.setText(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 7).toString());
        if (this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 8).toString().equals("1")) {
            this.JRBTindefinido.setSelected(true);
            this.xTipoV = 1;
        } else {
            this.JRBTfijo.setSelected(true);
            this.xTipoV = 0;
        }
        this.JCHEstadoLaboral.setSelected(Boolean.valueOf(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 9).toString()).booleanValue());
        if (this.JCHEstadoLaboral.isSelected()) {
            this.xestadoInL = 1;
        } else {
            this.xestadoInL = 0;
        }
        this.JDFFechaTerminacionDeContrato.setDate((Date) this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 12));
        this.JCBTipoContrato.setSelectedItem(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 13));
        this.JCBTipoTrabajador.setSelectedItem(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 14));
        this.JCBSubTipoTrabajador.setSelectedItem(this.xmodeloinf.getValueAt(this.JTDetalleINF.getSelectedRow(), 15));
        this.JTPDatosLaboral.setSelectedIndex(0);
        this.xgrabarilf = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarTActionPerformed(ActionEvent evt) {
        if (!this.xjppersona.getIdPersona().equals("")) {
            if (this.JCB_Concepto.getSelectedIndex() != -1) {
                if (this.JCB_CTercero.getSelectedIndex() != -1) {
                    if (!this.xGrabarCN) {
                        if (!this.xmetodos.mVerificarDatosDoblesTabla(this.JTB_CNHistorico, 1, this.JCB_Concepto.getSelectedItem().toString())) {
                            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                String sql = "insert ignore into rh_nomina_persona_conceptos(`Id_PersonaC`,`Id_RhConcepto_UF`,`TCalculo`,`Valor`,ValorE, `Id_Tercero`, Estado, Id_UsuarioS) values('" + Principal.txtNo.getText() + "','" + this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][0] + "','" + this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][1] + "','" + this.JTFF_Valor.getValue() + "','" + this.JTFF_Valor1.getValue() + "','" + this.xId_CNTercero[this.JCB_CTercero.getSelectedIndex()][0] + "','" + this.xestadocnm + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                                this.xconsultas.ejecutarSQL(sql);
                                this.xconsultas.cerrarConexionBd();
                                mNuevo_ConceptoNomina();
                                mCargarDatos_CN();
                                this.xGrabarCN = false;
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Concepto ya registrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCB_CTercero.requestFocus();
                        return;
                    }
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n2 == 0) {
                        String sql2 = "update rh_nomina_persona_conceptos set Estado='" + this.xestadocnm + "', TCalculo = '" + this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][1] + "', Valor = '" + this.JTFF_Valor.getValue() + "', ValorE = '" + this.JTFF_Valor1.getValue() + "', Id_Tercero = '" + this.xId_CNTercero[this.JCB_CTercero.getSelectedIndex()][0] + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Id_UsuarioS='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' where Id_RhConcepto_UF='" + this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][0] + "' and Id_PersonaC='" + Principal.txtNo.getText() + "'";
                        this.xconsultas.ejecutarSQL(sql2);
                        this.xconsultas.cerrarConexionBd();
                        mNuevo_ConceptoNomina();
                        mCargarDatos_CN();
                        this.xGrabarCN = false;
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_CTercero.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Concepto Nómina", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_Concepto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        mCargarDatosCNomina();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_CNHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_CNHistorico.getSelectedRow() != -1) {
            this.JCB_Concepto.setSelectedItem(this.xModelo_CN.getValueAt(this.JTB_CNHistorico.getSelectedRow(), 1));
            this.JTFF_Valor.setValue(this.xModelo_CN.getValueAt(this.JTB_CNHistorico.getSelectedRow(), 3));
            this.JCB_CTercero.setSelectedItem(this.xModelo_CN.getValueAt(this.JTB_CNHistorico.getSelectedRow(), 4));
            this.JCHEstadoCnomina.setSelected(Boolean.valueOf(this.xModelo_CN.getValueAt(this.JTB_CNHistorico.getSelectedRow(), 5).toString()).booleanValue());
            this.xGrabarCN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoCnominaActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoCnomina.isSelected()) {
            this.xestadocnm = 1;
        } else {
            this.xestadocnm = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ConceptoItemStateChanged(ItemEvent evt) {
        if (this.xlleno_CN && this.JCB_Concepto.getSelectedIndex() != -1) {
            if (this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][1].equals("2")) {
                this.JTFF_Valor.setBorder(BorderFactory.createTitledBorder((Border) null, "Día Empleado", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JTFF_Valor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Día Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            } else if (this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][1].equals("3")) {
                this.JTFF_Valor.setBorder(BorderFactory.createTitledBorder((Border) null, "Porcentaje Empleado", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JTFF_Valor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Porcentaje Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            } else if (this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][1].equals("4")) {
                this.JTFF_Valor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Empleado", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JTFF_Valor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            }
            System.out.println(this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][3]);
            if (this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][3].indexOf(",") == 1) {
                this.JTFF_Valor.setValue(Double.valueOf(this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][3].replaceAll(".", ",")));
                this.JTFF_Valor1.setValue(Double.valueOf(this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][4].replaceAll(".", ",")));
            } else {
                this.JTFF_Valor.setValue(Double.valueOf(this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][3]));
                this.JTFF_Valor1.setValue(Double.valueOf(this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][4]));
            }
            System.out.println(this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][1]);
            System.out.println(this.xId_CNConcepto[this.JCB_Concepto.getSelectedIndex()][2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_ValorActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleUfMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTpclasificasionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_Valor1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarBDActionPerformed(ActionEvent evt) {
        if (this.JCB_TipoB.getSelectedIndex() != -1) {
            if (!this.xjppersona.getIdPersona().equals("")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xsql = "insert into rh_tipo_persona_cargon_bdatos (`Id_PersonaC` , `Id_TipoBd` , `Id_UsuarioS` ) value('" + Principal.txtNo.getText() + "','" + this.xId_TipoBD[this.JCB_TipoB.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                    this.xconsultas.ejecutarSQL(this.xsql);
                    this.xconsultas.cerrarConexionBd();
                    mCargarDatosTablaBD();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una base", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleBDMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstado_BDActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_CNHistoricoKeyPressed(KeyEvent evt) {
        if (this.JTB_CNHistorico.getSelectedRow() != -1) {
            System.out.println("" + evt.getKeyCode());
            if (evt.getKeyCode() == 127) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xsql = "delete from rh_nomina_persona_conceptos where Id_PersonaC='" + Principal.txtNo.getText() + "' and Id_RhConcepto_UF='" + this.xModelo_CN.getValueAt(this.JTB_CNHistorico.getSelectedRow(), 0) + "'";
                    this.xconsultas.ejecutarSQL(this.xsql);
                    this.xconsultas.cerrarConexionBd();
                    mCargarDatosCNomina();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarT1ActionPerformed(ActionEvent evt) {
        if (!this.xjppersona.getIdPersona().equals("") && this.JCBUnidadFc.getSelectedIndex() != -1) {
            JDBuscarConceptoNominaxVFijo jdialog = new JDBuscarConceptoNominaxVFijo(null, true, Integer.valueOf(Principal.txtNo.getText()).intValue(), this.xidunidadfc[this.JCBUnidadFc.getSelectedIndex()], this.xjppersona.txtApellido1.getText() + " " + this.xjppersona.txtApellido2.getText() + " " + this.xjppersona.txtNombre1.getText() + " " + this.xjppersona.txtNombre2.getText());
            jdialog.setLocationRelativeTo(this);
            jdialog.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FP_DiasActionPerformed(ActionEvent evt) {
        this.xformapago = 0;
        mChangeCantidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FP_HorasActionPerformed(ActionEvent evt) {
        this.xformapago = 1;
        mChangeCantidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FP_JornalActionPerformed(ActionEvent evt) {
        this.xformapago = 2;
        mChangeCantidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCargoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBCargo.getSelectedIndex() != -1) {
            this.JTFCodigoD785.setText(this.xidcargo[this.JCBCargo.getSelectedIndex()][1]);
            this.JTFCargo.setText(this.JCBCargo.getSelectedItem().toString());
            this.JTFJefe.setText(traerLider());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCantidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBContratosActionPerformed(ActionEvent evt) {
        JDContratosPorTrabajador jDContratosPorTrabajador = new JDContratosPorTrabajador(null, this.closable, this.xjppersona.getIdentificacion(), this);
        jDContratosPorTrabajador.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PlantaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoLaboral1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFormaPagoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFormaPagoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMetodoDePagoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMetodoDePagoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCargoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatosUsuarioStateChanged(ChangeEvent evt) {
        if (this.JTPDatosUsuario.getSelectedIndex() == 6) {
            mCargarDatosTablaInfLaboral();
        }
    }

    private void mIniciarCheck() {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
        if (this.JCHLider.isSelected()) {
            this.xlider = 1;
        } else {
            this.xlider = 0;
        }
        if (this.JCHFijo.isSelected()) {
            this.xfijo = 1;
        } else {
            this.xfijo = 0;
        }
        if (this.JCHSIntegral.isSelected()) {
            this.xesintegral = 1;
        } else {
            this.xesintegral = 0;
        }
        if (this.JCHEstadoUfc.isSelected()) {
            this.xestadouf = 1;
        } else {
            this.xestadouf = 0;
        }
        if (this.JCHEstadoCnomina.isSelected()) {
            this.xEstadoLaboral1 = 1;
        } else {
            this.xEstadoLaboral1 = 0;
        }
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    private void mCargarCombos() {
        this.JCBCargo.removeAllItems();
        this.JCBUnidadF.removeAllItems();
        this.JCBProceso.removeAllItems();
        this.xidunidadf = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM rh_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidunidadf, this.JCBUnidadF);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JCBTProceso.removeAllItems();
        this.xidtipop = this.xconsultas.llenarCombo("SELECT Id , Nbre FROM s_sgc_procesos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipop, this.JCBTProceso);
        this.JCBTProceso.setSelectedIndex(-1);
        this.JCBUnidadFc.removeAllItems();
        this.xidunidadfc = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidunidadfc, this.JCBUnidadFc);
        this.JCBUnidadFc.setSelectedIndex(-1);
        this.JCBParentesco.removeAllItems();
        this.xparentesco = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_parentesco WHERE (Estado =0) ORDER BY Nbre ASC", this.xparentesco, this.JCBParentesco);
        this.JCBParentesco.setSelectedIndex(-1);
        this.JCBTpDocumento.removeAllItems();
        this.xtipodocumento = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_tipoidentificacion WHERE (Estado =0) ORDER BY Nbre ASC", this.xtipodocumento, this.JCBTpDocumento);
        this.JCBTpDocumento.setSelectedIndex(-1);
        this.JCBMpioExpedicionF2.removeAllItems();
        this.xmunicipioex = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xmunicipioex, this.JCBMpioExpedicionF2);
        this.JCBMpioExpedicionF2.setSelectedIndex(-1);
        this.JCBSexoF.removeAllItems();
        this.xsexo = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_sexo WHERE (Estado =0) ORDER BY Nbre ASC", this.xsexo, this.JCBSexoF);
        this.JCBSexoF.setSelectedIndex(-1);
        this.JCBMpioNacimientoF1.removeAllItems();
        this.xmunicipionaci = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xmunicipionaci, this.JCBMpioNacimientoF1);
        this.JCBMpioNacimientoF1.setSelectedIndex(-1);
        this.JCBEstudio.removeAllItems();
        this.xnestudio = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_nivelestudio WHERE (Estado =0) ORDER BY Nbre ASC", this.xnestudio, this.JCBEstudio);
        this.JCBEstudio.setSelectedIndex(-1);
        this.JCBMpioLaboral.removeAllItems();
        this.xmunicipionaci = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xmunicipionaci, this.JCBMpioLaboral);
        this.JCBMpioLaboral.setSelectedIndex(-1);
        this.JCBDocumento.removeAllItems();
        this.xdocumento = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM rh_tipo_documentos WHERE (Estado =1) ORDER BY Nbre ASC", this.xdocumento, this.JCBDocumento);
        this.JCBDocumento.setSelectedIndex(-1);
        this.JCBTpclasificasion.removeAllItems();
        this.xclasificacion = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM `rh_tipo_clasificacion` WHERE (Estado =1) ORDER BY Nbre ASC", this.xclasificacion, this.JCBTpclasificasion);
        this.JCBTpclasificasion.setSelectedIndex(-1);
        this.JCB_TipoB.removeAllItems();
        this.xId_TipoBD = this.xconsultas.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipo_base_datos` ORDER BY `Nbre` ASC", this.xId_TipoBD, this.JCB_TipoB);
        this.JCB_TipoB.setSelectedIndex(-1);
        this.JCBTipoContrato.removeAllItems();
        this.xtipoContrato = this.xconsultas.llenarCombo("select id,nombre from `rh_tipo_contrato` where estado = 1 ORDER BY nombre ASC", this.xtipoContrato, this.JCBTipoContrato);
        this.JCBTipoContrato.setSelectedIndex(-1);
        this.JCBTipoTrabajador.removeAllItems();
        this.xtipoTrabajador = this.xconsultas.llenarCombo("SELECT id,nombre FROM `rh_tipo_trabajador` WHERE estado = 1 ORDER BY nombre ASC ", this.xtipoTrabajador, this.JCBTipoTrabajador);
        this.JCBTipoTrabajador.setSelectedIndex(-1);
        this.JCBSubTipoTrabajador.removeAllItems();
        this.xSubTipotrabajador = new String[]{"00", "01"};
        this.JCBSubTipoTrabajador.addItem("No Aplica");
        this.JCBSubTipoTrabajador.addItem("Dependiente pensionado por vejez activo");
        this.JCBSubTipoTrabajador.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JCBFormaPago.removeAllItems();
        this.xFormaDePago = new String[]{"1"};
        this.JCBFormaPago.addItem("Contado");
        this.JCBFormaPago.setSelectedIndex(-1);
        this.JCBMetodoDePago.removeAllItems();
        this.xMetodoDePago = this.xconsultas.llenarCombo("SELECT codigo,nombre FROM medio_pago  WHERE estado = 1 ORDER BY nombre ASC ", this.xMetodoDePago, this.JCBMetodoDePago);
        this.JCBMetodoDePago.setSelectedIndex(-1);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.DirectorioEstudios = new File(this.xmetodos.mRutaSoporte("JIFRHUsuarioCargoEstudios"));
        this.DirectorioDocumentos = new File(this.xmetodos.mRutaSoporte("JIFRHUsuarioCargoDocumentos"));
        this.xjppersona.nuevo();
        this.xlleno = false;
        mCargarCombos();
        this.xlleno = true;
        this.xgrabarsgc = false;
        this.xgrabarufc = false;
        this.xgrabarf = false;
        this.xestado = 1;
        this.xestadocnm = 1;
        this.xestadouf = 0;
        this.xestadofamilia = 1;
        this.JSPPDistribucionS.setValue(new Double(0.0d));
        this.JSPFRiesgoArp.setValue(new Double(0.0d));
        this.xlider = 0;
        this.xfijo = 1;
        this.xesintegral = 0;
        this.JCHFijo.setSelected(true);
        this.JCHEstado.setSelected(true);
        this.JCHLider.setSelected(false);
        this.JCHSIntegral.setSelected(false);
        this.JDFFechaIngreso.setDate(this.xmetodos.getFechaActual());
        this.JTFFSalario.setValue(new Double(0.0d));
        this.xencontroacargo = false;
        this.xTipoV = 0;
        this.JCBMpioLaboral.setSelectedItem(Principal.informacionIps.getNombreMunicipioIps());
        this.JCHEstadoLaboral.setSelected(true);
        this.xestadoInL = 1;
        this.JTFNombreE.setText(Principal.informacionIps.getNombreIps());
        this.JTFDireccion.setText(Principal.informacionIps.getDireccion1Ips());
        this.JTFCargo.setText("");
        this.JTFJefe.setText("");
        this.JTFCargo.setText("");
        this.JTFTiempoL.setText("");
        this.JTFApellido1.setText("");
        this.JTFApellido2.setText("");
        this.JTFNombre1.setText("");
        this.JTFNombre2.setText("");
        this.JTFRutaSoporte.setText("");
        this.JTFRuta.setText("");
        this.JTA_ObservacionDoc.setText("");
        this.JTFRutaSoporte2.setText("");
        this.jTextField1.setText("");
        this.JTFNDoc.setText("");
        this.JTADescripcionF1.setText("");
        this.JRBTfijo.setSelected(false);
        this.JRBTindefinido.setSelected(false);
        this.JRB_FP_Dias.setSelected(true);
        this.xformapago = 0;
        this.JTFFCantidad.setValue(new Double(0.0d));
        this.JTFCodigoD785.setText("");
        this.JTFGrado.setText("");
        mChangeCantidad();
        mCrearModelo();
        mCrearModeloSgc();
        mCrearModeloUfc();
        mCrearModeloFamilia();
        mCrearModeloEstudio();
        mCrearModeloInfoLaboral();
        mCrearModeloCN();
        mCrearModeloDoc();
        mCrearModeloBD();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelosCNomina() {
        this.xmodelosgc = new DefaultTableModel(new Object[0], new String[]{"Id", "Concepto", "TCálculo", "Valor", "Razón Social", "Estado"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.63
            Class[] types = {String.class, String.class, Boolean.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleSgc.setModel(this.xmodelosgc);
        this.JTDetalleSgc.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleSgc.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleSgc.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleSgc.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleSgc.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalleSgc.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarDatosCNomina() {
        try {
            mCrearModeloCN();
            String sql = "SELECT  `rh_nomina_concepto_unidadf`.`Id` , `rh_nomina_conceptos`.`Nbre` , `rh_nomina_persona_conceptos`.`TCalculo` , `rh_nomina_persona_conceptos`.`Valor` , `cc_terceros`.`RazonSocialCompleta` , `rh_nomina_persona_conceptos`.`Estado` FROM  `rh_nomina_persona_conceptos` INNER JOIN `rh_nomina_concepto_unidadf`  ON (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`) INNER JOIN `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `rh_nomina_persona_conceptos`.`Id_Tercero`) WHERE (`rh_nomina_persona_conceptos`.`Id_PersonaC` ='" + Principal.txtNo.getText() + "' ) ORDER BY `rh_nomina_conceptos`.`Nbre` ASC";
            System.out.println("Concepto  " + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModelo_CN.addRow(this.xdato);
                    this.xModelo_CN.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xModelo_CN.setValueAt(xrs.getString(2), n, 1);
                    this.xModelo_CN.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xModelo_CN.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xModelo_CN.setValueAt(xrs.getString(5), n, 4);
                    this.xModelo_CN.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo_ConceptoNomina() {
        this.xlleno_CN = false;
        this.xGrabarCN = false;
        this.JCB_Concepto.removeAllItems();
        this.xsql = "SELECT  `rh_nomina_concepto_unidadf`.`Id` , `rh_nomina_conceptos`.`Nbre` , `rh_nomina_conceptos`.`TipoCalculo` , `rh_nomina_conceptos`.`MTercero`, `rh_nomina_conceptos`.Valor, `rh_nomina_conceptos`.ValorE FROM `rh_nomina_concepto_unidadf` INNER JOIN  `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) WHERE (`rh_nomina_concepto_unidadf`.`Id_UnidaFC` ='" + this.xidunidadfc[this.JCBUnidadFc.getSelectedIndex()] + "')  AND rh_nomina_conceptos.Estado=1 ORDER BY `rh_nomina_conceptos`.`Nbre` ASC ";
        this.xId_CNConcepto = this.xconsultas.llenarComboyLista(this.xsql, this.xId_CNConcepto, this.JCB_Concepto, 6);
        this.JCB_Concepto.setSelectedIndex(-1);
        this.JTFF_Valor.setValue(new Double(0.0d));
        this.JTFF_Valor1.setValue(new Double(0.0d));
        this.JCB_CTercero.removeAllItems();
        this.xsql = "SELECT  `Id` , `RazonSocialCompleta` , `No_identificacion` FROM `cc_terceros` WHERE (`EsNomina` =1 AND Estado=1) order by RazonSocialCompleta asc ";
        this.xId_CNTercero = this.xconsultas.llenarComboyLista(this.xsql, this.xId_CNTercero, this.JCB_CTercero, 3);
        this.JCB_Concepto.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.xlleno_CN = true;
    }

    public void mGrabar() {
        String sql;
        if (!this.xjppersona.getIdPersona().equals("") && this.xjppersona.getIdPersona() != null) {
            if (this.JCBCargo.getSelectedIndex() != -1) {
                if (this.JCBTpclasificasion.getSelectedIndex() != -1) {
                    if (this.JCBFormaPago.getSelectedIndex() != -1) {
                        if (this.JCBMetodoDePago.getSelectedIndex() != -1) {
                            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                if (!Principal.txtNo.getText().isEmpty()) {
                                    sql = "update rh_tipo_persona_cargon set Estado='" + this.xestado + "', Lider='" + this.xlider + "', UrlFirma='" + this.JTFRuta.getText() + "', Fijo='" + this.xfijo + "', Id_unidadf_cargo='" + this.xidcargo[this.JCBCargo.getSelectedIndex()][0] + "', FechaIngreso='" + this.xmetodos.formatoAMD.format(this.JDFFechaIngreso.getDate()) + "', SalarioB='" + this.JTFFSalario.getValue() + "', FRiesgoArp='" + this.JSPFRiesgoArp.getValue() + "', SIntegral='" + this.xesintegral + "', Id_Clasificacion='" + this.xclasificacion[this.JCBTpclasificasion.getSelectedIndex()] + "', FPago='" + this.xformapago + "',  FormaDePago='" + this.xFormaDePago[this.JCBFormaPago.getSelectedIndex()] + "',  MetodoDePago='" + this.xMetodoDePago[this.JCBMetodoDePago.getSelectedIndex()] + "', Cantidad='" + this.JTFFCantidad.getValue() + "', Codigo='" + this.JTFCodigoD785.getText() + "', Planta=" + this.JCH_Planta.isSelected() + ", Grado='" + this.JTFGrado.getText() + "' where Id='" + Principal.txtNo.getText() + "'";
                                } else {
                                    this.xjppersona.grabar();
                                    sql = "Insert into rh_tipo_persona_cargon(Id_Persona, Id_unidadf_cargo, Lider, Fijo, Planta, UrlFirma, FechaIngreso, SalarioB, SIntegral, FRiesgoArp ,Id_Clasificacion, FPago, FormaDePago,MetodoDePago, Cantidad, Codigo, Grado, Estado, Fecha, UsuarioS) values ('" + this.xjppersona.getIdPersona() + "','" + this.xidcargo[this.JCBCargo.getSelectedIndex()][0] + "','" + this.xlider + "','" + this.xfijo + "'," + this.JCH_Planta.isSelected() + ",'" + this.JTFRuta.getText() + "','" + this.xmetodos.formatoAMD.format(this.JDFFechaIngreso.getDate()) + "','" + this.JTFFSalario.getValue() + "','" + this.xesintegral + "','" + this.JSPFRiesgoArp.getValue() + "','" + this.xclasificacion[this.JCBTpclasificasion.getSelectedIndex()] + "','" + this.xformapago + "','" + this.xFormaDePago[this.JCBFormaPago.getSelectedIndex()] + "','" + this.xMetodoDePago[this.JCBMetodoDePago.getSelectedIndex()] + "','" + this.JTFFCantidad.getValue() + "','" + this.JTFCodigoD785.getText() + "','" + this.JTFGrado.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xencontroacargo = true;
                                }
                                System.out.println("datos rrhh" + sql);
                                this.xconsultas.ejecutarSQL(sql);
                                this.xconsultas.cerrarConexionBd();
                                mCargarDatosTabla(this.xjppersona.getIdPersona());
                                mCargarDatosTablaInfLaboral();
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar metodo de pago", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBMetodoDePago.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar forma de pago", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBFormaPago.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una clasificación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBCargo.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un cargo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBCargo.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        if (traerInformacionEmpleado()) {
            System.out.println("existe");
        } else {
            traerEmpresa();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Unidad Funcional", "Cargo", "Lider", "Fijo", "Url", "Estado", "FechaIngreso", "Salario", "SIntegral", "FRiesgoArp", "Clasificacion", "FPago", "Cantidad", "Codigo", "Grado", "Planta"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.64
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class, String.class, Boolean.class, String.class, Double.class, Boolean.class, Double.class, String.class, Integer.class, Double.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleC;
        JTable jTable2 = this.JTDetalleC;
        jTable.setAutoResizeMode(0);
        this.JTDetalleC.doLayout();
        this.JTDetalleC.setModel(this.xmodelo);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleC.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalleC.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleC.setDefaultRenderer(Object.class, new MiRenderer());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloSgc() {
        this.xmodelosgc = new DefaultTableModel(new Object[0], new String[]{"Tipo", "Proceso", "Estado"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.65
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleSgc.setModel(this.xmodelosgc);
        this.JTDetalleSgc.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleSgc.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleSgc.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloUfc() {
        this.xmodeloufc = new DefaultTableModel(new Object[0], new String[]{"Unidad Funcional", "%", "Estado"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.66
            Class[] types = {String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleUf.setModel(this.xmodeloufc);
        this.JTDetalleUf.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleUf.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleUf.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloCN() {
        this.xModelo_CN = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tipo", "Valor", "Tercero", "Estado", "ValorE"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.67
            Class[] types = {Long.class, String.class, Double.class, Integer.class, String.class, Boolean.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_CNHistorico.setModel(this.xModelo_CN);
        this.JTB_CNHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_CNHistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTB_CNHistorico.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTB_CNHistorico.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTB_CNHistorico.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTB_CNHistorico.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTB_CNHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_CNHistorico.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTB_CNHistorico.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloFamilia() {
        this.xmodelof = new DefaultTableModel(new Object[0], new String[]{"id", "Id_personaC", "Parentesco", "tipo", "documento", "MunicipioE", "FechaE", "Apellido", "Apellido2", "Nombre", "Nombre2", "Sexo", "FechaN", "municipioN", "Observacion", "Estado", "Fecha", "UsuarioS"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.68
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleF.setModel(this.xmodelof);
        this.JTDetalleF.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleF.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleF.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleF.getColumnModel().getColumn(1).setPreferredWidth(60);
        this.JTDetalleF.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalleF.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalleF.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(4).setPreferredWidth(1);
        this.JTDetalleF.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleF.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleF.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalleF.getColumnModel().getColumn(10).setPreferredWidth(60);
        this.JTDetalleF.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTDetalleF.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleF.getColumnModel().getColumn(16).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloEstudio() {
        this.xmodeloes = new DefaultTableModel(new Object[0], new String[]{"id", "Nives Estudios", "Observacion", "Urlsoporte", "Estado", "Fecha", "usuarioS"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.69
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleEstudio.setModel(this.xmodeloes);
        this.JTDetalleEstudio.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleEstudio.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleEstudio.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleEstudio.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleEstudio.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleEstudio.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleEstudio.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleEstudio.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleEstudio.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleEstudio.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleEstudio.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloInfoLaboral() {
        this.xmodeloinf = new DefaultTableModel(new Object[0], new String[]{"Id", "IdPersona_C", "Empresa", "Municipio", "Direccion", "Cargo", "Jefe", "TiempoL", "Tvinculacion", "Estado", "Fecha", "Usuario_S", "Fecha Terminación", "Tipo Contrato", "Tipo Trabajador", "Sub TipoTrabajador"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.70
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, Date.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleINF;
        JTable jTable2 = this.JTDetalleINF;
        jTable.setAutoResizeMode(0);
        this.JTDetalleINF.doLayout();
        this.JTDetalleINF.setModel(this.xmodeloinf);
        this.JTDetalleINF.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleINF.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleINF.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleINF.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleINF.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleINF.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalleINF.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalleINF.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleINF.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleINF.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleINF.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleINF.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalleINF.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleINF.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTDetalleINF.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalleINF.getColumnModel().getColumn(15).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDoc() {
        this.xmodelodc = new DefaultTableModel(new Object[0], new String[]{"Id", "Id_personac", "Documento", "Observacion", "Url", "Estado", "Fecha", "Usuario_S"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.71
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleDc.setModel(this.xmodelodc);
        this.JTDetalleDc.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleDc.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleDc.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleDc.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleDc.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalleDc.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalleDc.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleDc.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleDc.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalleDc.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalleDc.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleDc.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleDc.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleDc.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloBD() {
        this.xmodeloBD = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado"}) { // from class: ParametrizacionN.JIFRHUsuarioCargo.72
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_DetalleBD.setModel(this.xmodeloBD);
        this.JTB_DetalleBD.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_DetalleBD.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_DetalleBD.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_DetalleBD.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTB_DetalleBD.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCargarDatosTablaDocumento() {
        try {
            mCrearModeloDoc();
            String sql = "SELECT    `rh_tercero_empleado_documentos`.`Id`    , `rh_tipo_persona_cargon`.`Id`    , `rh_tipo_documentos`.`Nbre`    , `rh_tercero_empleado_documentos`.`Observacion`    , `rh_tercero_empleado_documentos`.`Url_Soporte`    , `rh_tercero_empleado_documentos`.`Estado`    , `rh_tercero_empleado_documentos`.`Fecha`    , `rh_tercero_empleado_documentos`.`Id_UsuarioS`FROM    `rh_tercero_empleado_documentos`    INNER JOIN  `rh_tipo_documentos`         ON (`rh_tercero_empleado_documentos`.`Id_Documento` = `rh_tipo_documentos`.`Id`)    INNER JOIN  `rh_tipo_persona_cargon`         ON (`rh_tercero_empleado_documentos`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)WHERE (`rh_tipo_persona_cargon`.`Id`='" + Principal.txtNo.getText() + "')";
            System.out.println("Documento  " + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelodc.addRow(this.xdato);
                    this.xmodelodc.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelodc.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelodc.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelodc.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelodc.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelodc.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelodc.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelodc.setValueAt(xrs.getString(8), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaBD() {
        try {
            mCrearModeloBD();
            this.xsql = "SELECT\n    `g_tipo_base_datos`.`Id`\n    , `g_tipo_base_datos`.`Nbre`\n    , `g_tipo_base_datos`.`Estado`\nFROM\n    `rh_tipo_persona_cargon_bdatos`\n    INNER JOIN `g_tipo_base_datos` \n        ON (`rh_tipo_persona_cargon_bdatos`.`Id_TipoBd` = `g_tipo_base_datos`.`Id`)\nWHERE (`rh_tipo_persona_cargon_bdatos`.`Id_PersonaC` ='" + Principal.txtNo.getText() + "' )\nORDER BY `g_tipo_base_datos`.`Nbre` ASC";
            System.out.println("BD  " + this.xsql);
            ResultSet xrs = this.xconsultas.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloBD.addRow(this.xdato);
                    this.xmodeloBD.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodeloBD.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloBD.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaInfLaboral() {
        try {
            mCrearModeloInfoLaboral();
            String sql = "SELECT\n    `rh_tercero_empleado_inf_laboral`.`Id`\n    , `rh_tipo_persona_cargon`.`Id`\n    , `rh_tercero_empleado_inf_laboral`.`NEmpresa`\n    , `g_municipio`.`Nbre` AS `municipio`\n    , `rh_tercero_empleado_inf_laboral`.`Direccion`\n    , `rh_tercero_empleado_inf_laboral`.`Cargo`\n    , `rh_tercero_empleado_inf_laboral`.`Jefe`\n    , `rh_tercero_empleado_inf_laboral`.`TiempoL`\n    , `rh_tercero_empleado_inf_laboral`.`TVinculacion`\n    , `rh_tercero_empleado_inf_laboral`.`Estado`\n    , `rh_tercero_empleado_inf_laboral`.`Fecha`\n    , `rh_tercero_empleado_inf_laboral`.`Id_UsuarioS`\n    , rh_tercero_empleado_inf_laboral.fechaTerminacion \n    , rtc.nombre  tipoContrato\n    , rtt.nombre  tipoTrabajador\n    , if(rh_tercero_empleado_inf_laboral.SubTipoTrabajador = '00', 'No Aplica', 'Dependiente pensionado por vejez activo') subTipoTrabajador \n    \nFROM\n   `rh_tercero_empleado_inf_laboral`\n    INNER JOIN  `rh_tipo_persona_cargon` \n        ON (`rh_tercero_empleado_inf_laboral`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN  `g_municipio` \n        ON (`rh_tercero_empleado_inf_laboral`.`Id_Municipio` = `g_municipio`.`Id`)\n    left join rh_tipo_contrato rtc  on (rtc.id=rh_tercero_empleado_inf_laboral.Id_TipoContrato)\n    left join rh_tipo_trabajador rtt  on (rtt.id=rh_tercero_empleado_inf_laboral.Id_TipoTrabajador)WHERE (`rh_tipo_persona_cargon`.`Id`='" + Principal.txtNo.getText() + "') GROUP BY `rh_tercero_empleado_inf_laboral`.`Id`";
            System.out.println("laboral  " + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloinf.addRow(this.xdato);
                    this.xmodeloinf.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloinf.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloinf.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloinf.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloinf.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloinf.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloinf.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloinf.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloinf.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloinf.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.xmodeloinf.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloinf.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloinf.setValueAt(xrs.getDate("fechaTerminacion"), n, 12);
                    this.xmodeloinf.setValueAt(xrs.getString("tipoContrato"), n, 13);
                    this.xmodeloinf.setValueAt(xrs.getString("tipoTrabajador"), n, 14);
                    this.xmodeloinf.setValueAt(xrs.getString("subTipoTrabajador"), n, 15);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaEstudio() {
        try {
            mCrearModeloEstudio();
            String sql = "SELECT`rh_tercero_empleado_estudios`.`Id`    , `g_nivelestudio`.`Nbre` AS `nivel estudio`    , `rh_tercero_empleado_estudios`.`Observacion`    , `rh_tercero_empleado_estudios`.`Url_Soporte`    , `rh_tercero_empleado_estudios`.`Estado`    , `rh_tercero_empleado_estudios`.`Fecha`    , `rh_tercero_empleado_estudios`.`Id_UsuarioS`FROM    `rh_tercero_empleado_estudios`    INNER JOIN  `g_nivelestudio`         ON (`rh_tercero_empleado_estudios`.`Id_NIvelEstudio` = `g_nivelestudio`.`Id`)WHERE (`rh_tercero_empleado_estudios`.`Id_PersonaC` ='" + Principal.txtNo.getText() + "')ORDER BY `rh_tercero_empleado_estudios`.`Id` ASC; ";
            System.out.println("Estudio  " + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloes.addRow(this.xdato);
                    this.xmodeloes.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloes.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloes.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloes.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloes.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodeloes.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloes.setValueAt(xrs.getString(7), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaFamilia() {
        try {
            mCrearModeloFamilia();
            String sql = "SELECT`rh_tercero_empleado_familia`.`Id`, `rh_tipo_persona_cargon`.`Id` , `g_parentesco`.`Nbre` AS `parentesco`, `g_tipoidentificacion`.`Nbre` AS `tipo identidad`, `rh_tercero_empleado_familia`.`Documento` , `g_municipio_1`.`Nbre` AS `municipioe`, date_format(`rh_tercero_empleado_familia`.`FechaExp`,'%Y/%m/%d') , `rh_tercero_empleado_familia`.`Apellido1`, `rh_tercero_empleado_familia`.`Apellido2`, `rh_tercero_empleado_familia`.`Nombre1`, `rh_tercero_empleado_familia`.`Nombre2`, `g_sexo`.`Nbre` AS `sexo`, `rh_tercero_empleado_familia`.`FechaNac`, `g_municipio`.`Nbre` AS `municipioN`, `rh_tercero_empleado_familia`.`ObservacionG`, `rh_tercero_empleado_familia`.`Estado`, `rh_tercero_empleado_familia`.`Fecha`, `rh_tercero_empleado_familia`.`Id_UsuarioS`FROM     `rh_tercero_empleado_familia`    INNER JOIN  `g_sexo`         ON (`rh_tercero_empleado_familia`.`Id_Sexo` = `g_sexo`.`Id`)    INNER JOIN  `g_municipio`         ON (`rh_tercero_empleado_familia`.`Id_MunicipioNac` = `g_municipio`.`Id`)    INNER JOIN  `g_tipoidentificacion`         ON (`rh_tercero_empleado_familia`.`Id_TipoDoc` = `g_tipoidentificacion`.`Id`)    INNER JOIN  `g_parentesco`         ON (`rh_tercero_empleado_familia`.`Id_Parentesco` = `g_parentesco`.`Id`)    INNER JOIN  `rh_tipo_persona_cargon`         ON (`rh_tercero_empleado_familia`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)    INNER JOIN  `g_municipio` AS `g_municipio_1`        ON (`rh_tercero_empleado_familia`.`Id_MunicipioExp` = `g_municipio_1`.`Id`)WHERE (`rh_tipo_persona_cargon`.`Id` ='" + Principal.txtNo.getText() + "')ORDER BY `rh_tercero_empleado_familia`.`Id` ASC; ";
            System.out.println("Familia  " + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelof.addRow(this.xdato);
                    this.xmodelof.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelof.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelof.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelof.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelof.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelof.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelof.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelof.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelof.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelof.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelof.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelof.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelof.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelof.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelof.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelof.setValueAt(Boolean.valueOf(xrs.getBoolean(16)), n, 15);
                    this.xmodelof.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelof.setValueAt(xrs.getString(18), n, 17);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTabla(String xidp) {
        try {
            mCrearModelo();
            String sql = "SELECT rh_tipo_persona_cargon.Id, rh_unidad_funcional.Nbre, rh_tipo_cargo.Nbre, rh_tipo_persona_cargon.Lider, rh_tipo_persona_cargon.Fijo, rh_tipo_persona_cargon.UrlFirma, rh_tipo_persona_cargon.Estado, DATE_FORMAT(rh_tipo_persona_cargon.FechaIngreso,'%d-%m-%Y') AS FIngreso, rh_tipo_persona_cargon.SalarioB, rh_tipo_persona_cargon.SIntegral, rh_tipo_persona_cargon.FRiesgoArp  ,rh_tipo_clasificacion.`Nbre` AS Clasificacion, rh_tipo_persona_cargon.FPago, rh_tipo_persona_cargon.Cantidad, rh_tipo_persona_cargon.Codigo, rh_tipo_persona_cargon.Grado ,rh_tipo_persona_cargon.Planta FROM rh_tipo_persona_cargon  INNER JOIN rh_unidadf_cargo ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN rh_unidad_funcional   ON (rh_unidadf_cargo.Id_UnidadF = rh_unidad_funcional.Id) INNER JOIN rh_tipo_cargo  ON (rh_unidadf_cargo.Id_Cargo = rh_tipo_cargo.Id)  INNER JOIN`rh_tipo_clasificacion`  ON (rh_tipo_clasificacion.`Id` = rh_tipo_persona_cargon.`Id_Clasificacion`)  WHERE (rh_tipo_persona_cargon.Id_Persona ='" + xidp + "') ORDER BY rh_tipo_persona_cargon.Estado DESC, rh_unidad_funcional.Nbre ASC, rh_tipo_cargo.Nbre ASC";
            System.out.println(" datos rrhh " + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                Principal.txtNo.setText(xrs.getString(1));
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(13)), n, 12);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(14)), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Planta")), n, 16);
                    this.xencontroacargo = true;
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
            mCargarDatosTablaSgc(xidp);
            mCargarDatosTablaUf();
            mCargarDatosTablaFamilia();
            mCargarDatosTablaEstudio();
            mCargarDatosTablaInfLaboral();
            mCargarDatosTablaDocumento();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaSgc(String xidp) {
        try {
            mCrearModeloSgc();
            String sql = "SELECT s_sgc_procesos.Nbre, s_sgc_tipoproceso.Nbre, s_sgc_usuario_tipoproceso.Estado  FROM s_sgc_usuario_tipoproceso INNER JOIN s_sgc_tipoproceso  ON (s_sgc_usuario_tipoproceso.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) WHERE (s_sgc_usuario_tipoproceso.Id_Usuario ='" + xidp + "') ORDER BY s_sgc_procesos.Nbre ASC, s_sgc_tipoproceso.Nbre ASC ";
            System.out.println("sgc  " + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelosgc.addRow(this.xdato);
                    this.xmodelosgc.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelosgc.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelosgc.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaUf() {
        try {
            mCrearModeloUfc();
            String sql = "SELECT cc_unidad_funcional.Nbre, rh_nomina_persona_unidadf.Porcentaje, rh_nomina_persona_unidadf.Estado FROM rh_nomina_persona_unidadf INNER JOIN cc_unidad_funcional  ON (rh_nomina_persona_unidadf.Id_UnidadF = cc_unidad_funcional.Id) WHERE (rh_nomina_persona_unidadf.Id_personaCargo ='" + Principal.txtNo.getText() + "') ORDER BY cc_unidad_funcional.Nbre ASC   ";
            System.out.println("Uf : " + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloufc.addRow(this.xdato);
                    this.xmodeloufc.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloufc.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                    this.xmodeloufc.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatos_CN() {
        try {
            mCrearModeloCN();
            String sql = " SELECT  `rh_nomina_concepto_unidadf`.`Id` , `rh_nomina_conceptos`.`Nbre` , `rh_nomina_persona_conceptos`.`TCalculo` , `rh_nomina_persona_conceptos`.`Valor` , `cc_terceros`.`RazonSocialCompleta` , `rh_nomina_persona_conceptos`.`Estado`, `rh_nomina_persona_conceptos`.`ValorE`FROM  `rh_nomina_persona_conceptos` INNER JOIN `rh_nomina_concepto_unidadf`  ON (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`) INNER JOIN `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `rh_nomina_persona_conceptos`.`Id_Tercero`)WHERE (`rh_nomina_persona_conceptos`.`Id_PersonaC` ='" + Principal.txtNo.getText() + "')ORDER BY `rh_nomina_conceptos`.`Nbre` ASC ";
            System.out.println("" + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModelo_CN.addRow(this.xdato);
                    this.xModelo_CN.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xModelo_CN.setValueAt(xrs.getString(2), n, 1);
                    this.xModelo_CN.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xModelo_CN.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xModelo_CN.setValueAt(xrs.getString(5), n, 4);
                    this.xModelo_CN.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xModelo_CN.setValueAt(Double.valueOf(xrs.getDouble("ValorE")), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
        traerDatosDePago();
    }

    private void mChangeCantidad() {
        if (this.xformapago == 0) {
            this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad x Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else if (this.xformapago == 1) {
            this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad x Horas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else {
            this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad x Jornal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        }
    }

    public void traerDatosDePago() {
        this.JCBFormaPago.setSelectedIndex(0);
        this.xjppersona.getIdPersona();
        String sql = "SELECT\n     `MetodoDePago`\nFROM\n  `rh_tipo_persona_cargon`WHERE (`Id_Persona` ='" + this.xjppersona.getIdPersona() + "') ";
        String id = "1";
        try {
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    id = xrs.getString(1);
                }
            }
        } catch (SQLException e) {
        }
        for (int x = 0; x < this.xMetodoDePago.length; x++) {
            if (this.xMetodoDePago[x].equals(id)) {
                this.JCBMetodoDePago.setSelectedIndex(x);
            }
        }
    }

    public String traerLider() {
        String nombreLider = "";
        String sql = "SELECT \nCONCAT(g_persona.`Nombre1`,' ',`g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS lider\nFROM `rh_unidad_funcional`\nINNER JOIN `g_persona` ON (`g_persona`.`Id`=`rh_unidad_funcional`.id_persona)\nWHERE rh_unidad_funcional.`Id`= '" + this.xidunidadf[this.JCBUnidadF.getSelectedIndex()] + "'";
        try {
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    nombreLider = xrs.getString(1);
                }
            }
        } catch (SQLException e) {
        }
        return nombreLider;
    }

    public boolean traerInformacionEmpleado() {
        boolean cargarUsuario = false;
        String sql = "SELECT \ng_empresa.Id_TipoIdentificacion\n,g_empresa.No_identificacion\n,g_empresa.Apellido1\n,g_empresa.Apellido2\n,g_empresa.Nombre1\n,g_empresa.Nombre2\n,g_empresa.Nbre\nFROM g_empresa\nWHERE No_identificacion = '" + this.xjppersona.getIdentificacion() + "'";
        try {
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    cargarUsuario = true;
                }
            }
        } catch (SQLException e) {
        }
        return cargarUsuario;
    }

    public void traerEmpresa() {
        String sql = "INSERT INTO `baseserver`.`g_empresa` (\n  `Apellido1`,\n  `Apellido2`,\n  `Nombre1`,\n  `Nombre2`,\n  `Id_TipoIdentificacion`,\n  `No_identificacion`,\n  `Dig_Verificacion`,\n  `Id_Municipio`,\n  `Direccion`,\n  `Tel_Numero`,\n  `Fax`,\n  `Correo`,\n  `CorreoFacturaElectronica`,\n  `Contacto`,\n  `Transp`,\n  `Eps`,\n  `Id_TipoRegimen`,\n  `Id_Persona`,\n  `TipoPersona`,\n  `FacTInterna`,\n  `Estado`,\n  `DocComodin`,\n  `EsConvenioMp`,\n  `EsPlaboratorio`,\n  `EsMInventario`,\n  `EsManejoC`,\n  `EsManejoResiduos`,\n  `GRetencion`,\n  `FechaPoliza`,\n  `VCompraP`,\n  `ActivoC`,\n  `Id_VigenciaP`,\n  `Id_ClasificacionT`,\n  `EsNomina`,\n  `CHabilitacion`,\n  `CodigoPresupuestal`,\n  `requiereAuditoria`,\n  `UsuarioS`)\n VALUES ('" + this.xjppersona.getApellido1() + "','" + this.xjppersona.getApellido2() + "','" + this.xjppersona.getNombre1() + "','" + this.xjppersona.getNombre2() + "','" + this.xjppersona.getIdTipoIdentifiacion() + "','" + this.xjppersona.getIdentificacion() + "','','" + this.xjppersona.getIdMunicipio() + "','" + this.xjppersona.getDireccion() + "','" + this.xjppersona.txtTelefono.getText() + "','','" + this.xjppersona.txtCorreo.getText() + "','" + this.xjppersona.txtCorreo.getText() + "','" + this.xjppersona.txtTelefono1.getText() + "','0','0','0','" + this.xjppersona.getIdPersona() + "','1','0','1','','0','0','0','0','0','0','','0','1','1','1','1','','','0','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        System.out.println("dat" + sql);
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    /* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFRHUsuarioCargo$MiRenderer.class */
    public class MiRenderer extends DefaultTableCellRenderer {
        public MiRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            boolean estado = Boolean.parseBoolean(table.getValueAt(row, 6).toString());
            if (!estado) {
                setBackground(Color.LIGHT_GRAY);
                setForeground(Color.BLACK);
            } else {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}
