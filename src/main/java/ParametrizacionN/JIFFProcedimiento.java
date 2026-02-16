package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.JDProcedimentoRelacionadoController;
import com.genoma.plus.controller.general.JDGenerico1Combo1Check;
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
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFProcedimiento.class */
public class JIFFProcedimiento extends JInternalFrame {
    private int xestado;
    private int xtipoHC;
    private int xtipoCita;
    private int xtipomanual;
    private int esSeguimiento;
    private int esCitologia;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String xsql;
    private String xnombre;
    private String xsexo;
    private String[] xidtipoproc;
    private String[] xidtipoprocrips;
    private String[] xidtipofinalidad;
    private String[] xidtipoagrupacion;
    private String[] xidarea;
    private String[] xidtipomuestra;
    private String[] xidmetodo;
    private String[] xtipotubo;
    private String[] xidperfil;
    private String[] xidmanualtarifas;
    private String[] xidclasecita;
    private String[] xidHC;
    private String[] xIdTipoEquipo;
    static String idProcedimiento;
    private int idGProcedimiento;
    private ButtonGroup JBGOpciones;
    private ButtonGroup JBGOpciones2;
    private ButtonGroup JBGOpciones3;
    private JButton JBSuministro;
    private JButton JBTAdicionarC;
    private JButton JBTComplicaciones;
    private JButton JBTConcentimientos;
    private JButton JBTEquipo;
    private JButton JBTExportar;
    private JButton JBTFInalidad;
    private JButton JBTPaquete;
    private JButton JBTProcedimientoCosto;
    private JButton JBTProcedimientoTarifa;
    private JButton JBTRemisiones;
    private JButton JBTServicioRips;
    private JButton JBTTiempo;
    private JButton JBT_CGruposCx;
    private JButton JBT_ProxEsp;
    private JButton JBT_ProxEsp1;
    private JComboBox JCBAgrupacion;
    private JComboBox JCBAreaLab;
    private JComboBox JCBClaseCita;
    private JComboBox JCBFinalidad;
    private JComboBox JCBManualTarifa;
    private JComboBox JCBMetodo;
    private JComboBox JCBPerfiles;
    private JComboBox JCBSexo;
    private JComboBox JCBTipoEquipo;
    private JComboBox JCBTipoHC;
    private JComboBox JCBTipoMuestra;
    private JComboBox JCBTipoPrcRips;
    private JComboBox JCBTipoProcedimiento;
    private JComboBox JCBTubo;
    private JCheckBox JCHComienza;
    private JCheckBox JCHContiene;
    private JCheckBox JCHEsAProcEnfer;
    private JCheckBox JCHEsASeguimiento;
    private JCheckBox JCHEsAgenda;
    private JCheckBox JCHEsCita;
    private JCheckBox JCHEsCitologia;
    private JCheckBox JCHEsCorreo;
    private JCheckBox JCHEsOdontologico;
    private JCheckBox JCHEsPaquete;
    private JCheckBox JCHEsPrioritario;
    private JCheckBox JCHEsPypOdon;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstadoC;
    private JCheckBox JCHGeneraAlerta;
    private JCheckBox JCHProcedimiento;
    private JCheckBox JCHRemitido;
    private JCheckBox JCHTodo;
    private JCheckBox JCHValidarLab;
    private JFormattedTextField JFTFValor;
    private JPanel JPIAdicional;
    private JPanel JPIBusqueda;
    private JPanel JPIComentario;
    private JPanel JPIDatos;
    private JPanel JPIDatosBusqueda;
    private JPanel JPIDatosProc;
    private JTabbedPane JPIProcedimientoTab;
    private JPanel JPI_Exportacion;
    private JPanel JPMenu1;
    private JPanel JPMenu2;
    private JRadioButton JRBFactor;
    private JRadioButton JRBGrupo;
    private JRadioButton JRBUvr;
    private JRadioButton JRBValor;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSPDescripcion1;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JSpinner JSPEdadI;
    private JSpinner JSPEdadM;
    private JSpinner JSPImpuesto;
    private JSpinner JSPNDias;
    private JSpinner JSPNOrden;
    private JSpinner JSPNOrdenI;
    private JSpinner JSPNivelC;
    private JScrollPane JSPPreparacion1;
    private JScrollPane JSPRequisitosP;
    private JTextArea JTAPreparacion1;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTextField JTFAbreviaturaRef;
    private JTextField JTFCHomologado;
    private JTextField JTFCPersonalizado;
    private JTextField JTFCReal;
    private JTextField JTFCodigoCups;
    private JTextField JTFLIS;
    private JTextField JTFNombre;
    private JTextField JTFNombreBusqueda;
    private JTextField JTFNombreSoat;
    private JTextField JTFRuta;
    private JTextField JTFTResultado;
    private JTabbedPane JTPDatosProc;
    private JTextPane JTPDescripcion;
    private JTextPane JTPDescripcion1;
    private JTabbedPane JTPOpciones;
    public JTextPane JTPRequisitosP;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xesprioritario = 0;
    private int xesremitido = 0;
    private int xtipobusqueda = 1;
    private int xEsPypOdontologico = 1;
    private int xesagenda = 0;
    private int xescita = 0;
    private int xvalidarlab = 0;
    private int xespaquete = 0;
    private int xgeneraalerta = 0;
    private int xesodontologico = 0;
    private int xestadoc = 1;
    private int xesAProcEnfer = 0;
    private int xtipov = 0;
    private int esCorreo = 1;
    private boolean xestadog = false;
    private long xidcometario = 0;

    public JIFFProcedimiento(String xnombre) {
        initComponents();
        setName(xnombre);
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v442, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v492, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JBGOpciones2 = new ButtonGroup();
        this.JBGOpciones3 = new ButtonGroup();
        this.JTPDatosProc = new JTabbedPane();
        this.JPIDatosProc = new JPanel();
        this.jPanel2 = new JPanel();
        this.JCBAreaLab = new JComboBox();
        this.JCBTipoMuestra = new JComboBox();
        this.JCBMetodo = new JComboBox();
        this.JCBTubo = new JComboBox();
        this.JSPPreparacion1 = new JScrollPane();
        this.JTAPreparacion1 = new JTextArea();
        this.JSPRequisitosP = new JScrollPane();
        this.JTPRequisitosP = new JTextPane();
        this.JCHValidarLab = new JCheckBox();
        this.JCHRemitido = new JCheckBox();
        this.JCHEsPrioritario = new JCheckBox();
        this.JSPNivelC = new JSpinner();
        this.JSPNDias = new JSpinner();
        this.JSPNOrdenI = new JSpinner();
        this.JTFAbreviaturaRef = new JTextField();
        this.JTFTResultado = new JTextField();
        this.JCBPerfiles = new JComboBox();
        this.JTFLIS = new JTextField();
        this.JPIProcedimientoTab = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JTFCodigoCups = new JTextField();
        this.JTFNombre = new JTextField();
        this.JCBTipoPrcRips = new JComboBox();
        this.JCBTipoProcedimiento = new JComboBox();
        this.JCBFinalidad = new JComboBox();
        this.JCBAgrupacion = new JComboBox();
        this.JCHEsCita = new JCheckBox();
        this.JCHEsPaquete = new JCheckBox();
        this.JCHGeneraAlerta = new JCheckBox();
        this.JCHEsOdontologico = new JCheckBox();
        this.jPanel3 = new JPanel();
        this.JTFCReal = new JTextField();
        this.JTFCHomologado = new JTextField();
        this.JTFCPersonalizado = new JTextField();
        this.JCHEsPypOdon = new JCheckBox();
        this.jPanel4 = new JPanel();
        this.JSPEdadI = new JSpinner();
        this.JSPEdadM = new JSpinner();
        this.jPanel5 = new JPanel();
        this.JCBSexo = new JComboBox();
        this.JCHEsAProcEnfer = new JCheckBox();
        this.JCHEsAgenda = new JCheckBox();
        this.JSPImpuesto = new JSpinner();
        this.JCHEsASeguimiento = new JCheckBox();
        this.JCHEsCitologia = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JCHEsCorreo = new JCheckBox();
        this.JPIAdicional = new JPanel();
        this.JTFNombreSoat = new JTextField();
        this.jPanel6 = new JPanel();
        this.JRBGrupo = new JRadioButton();
        this.JRBFactor = new JRadioButton();
        this.JRBUvr = new JRadioButton();
        this.JRBValor = new JRadioButton();
        this.JCBManualTarifa = new JComboBox();
        this.JCBClaseCita = new JComboBox();
        this.JCBTipoHC = new JComboBox();
        this.JFTFValor = new JFormattedTextField();
        this.JTPOpciones = new JTabbedPane();
        this.JPMenu1 = new JPanel();
        this.JBTProcedimientoCosto = new JButton();
        this.JBTProcedimientoTarifa = new JButton();
        this.JBTPaquete = new JButton();
        this.JBTEquipo = new JButton();
        this.JBSuministro = new JButton();
        this.JBT_CGruposCx = new JButton();
        this.JBT_ProxEsp = new JButton();
        this.JBT_ProxEsp1 = new JButton();
        this.JPMenu2 = new JPanel();
        this.JBTComplicaciones = new JButton();
        this.JBTConcentimientos = new JButton();
        this.JBTRemisiones = new JButton();
        this.JBTServicioRips = new JButton();
        this.JBTTiempo = new JButton();
        this.JBTFInalidad = new JButton();
        this.JPI_Exportacion = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel1 = new JPanel();
        this.JCHTodo = new JCheckBox();
        this.JCHProcedimiento = new JCheckBox();
        this.JPIComentario = new JPanel();
        this.JSPDescripcion = new JScrollPane();
        this.JTPDescripcion = new JTextPane();
        this.JCHEstadoC = new JCheckBox();
        this.JSPNOrden = new JSpinner();
        this.JBTAdicionarC = new JButton();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JSPDescripcion1 = new JScrollPane();
        this.JTPDescripcion1 = new JTextPane();
        this.JCBTipoEquipo = new JComboBox();
        this.JPIBusqueda = new JPanel();
        this.JPIDatosBusqueda = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.JCHComienza = new JCheckBox();
        this.JCHContiene = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROCEDIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifprocedimiento");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFFProcedimiento.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFProcedimiento.this.formInternalFrameClosing(evt);
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
        this.JTPDatosProc.setForeground(new Color(0, 103, 0));
        this.JTPDatosProc.setFont(new Font("Arial", 1, 14));
        this.JTPDatosProc.addChangeListener(new ChangeListener() { // from class: ParametrizacionN.JIFFProcedimiento.2
            public void stateChanged(ChangeEvent evt) {
                JIFFProcedimiento.this.JTPDatosProcStateChanged(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "PARAMETRIZACIÓN PARA EL MODÚLO DEL LABORATORIO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBAreaLab.setFont(new Font("Arial", 1, 12));
        this.JCBAreaLab.setBorder(BorderFactory.createTitledBorder((Border) null, "Área", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoMuestra.setFont(new Font("Arial", 1, 12));
        this.JCBTipoMuestra.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Muestra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMetodo.setFont(new Font("Arial", 1, 12));
        this.JCBMetodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Método", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTubo.setFont(new Font("Arial", 1, 12));
        this.JCBTubo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Tubo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPreparacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Preparación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPreparacion1.setAutoscrolls(true);
        this.JTAPreparacion1.setColumns(20);
        this.JTAPreparacion1.setFont(new Font("Arial", 1, 12));
        this.JTAPreparacion1.setLineWrap(true);
        this.JTAPreparacion1.setRows(1);
        this.JTAPreparacion1.setTabSize(1);
        this.JSPPreparacion1.setViewportView(this.JTAPreparacion1);
        this.JSPRequisitosP.setBorder(BorderFactory.createTitledBorder((Border) null, "Requisitos", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPRequisitosP.setToolTipText("Requisitos que se deben indagar en la consulta");
        this.JTPRequisitosP.setFont(new Font("Arial", 1, 12));
        this.JSPRequisitosP.setViewportView(this.JTPRequisitosP);
        this.JCHValidarLab.setFont(new Font("Arial", 1, 12));
        this.JCHValidarLab.setText("Validar Laboratorio");
        this.JCHValidarLab.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.3
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHValidarLabActionPerformed(evt);
            }
        });
        this.JCHRemitido.setFont(new Font("Arial", 1, 12));
        this.JCHRemitido.setText("Es Remitido?");
        this.JCHRemitido.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.4
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHRemitidoActionPerformed(evt);
            }
        });
        this.JCHEsPrioritario.setFont(new Font("Arial", 1, 12));
        this.JCHEsPrioritario.setText("Es Prioritario?");
        this.JCHEsPrioritario.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.5
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsPrioritarioActionPerformed(evt);
            }
        });
        this.JSPNivelC.setFont(new Font("Arial", 1, 12));
        this.JSPNivelC.setModel(new SpinnerNumberModel(1, 1, 6, 1));
        this.JSPNivelC.setToolTipText("Nivel de prioridad");
        this.JSPNivelC.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNDias.setFont(new Font("Arial", 1, 12));
        this.JSPNDias.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNDias.setToolTipText("Numero de días pra la entrega del resultado");
        this.JSPNDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Días", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNOrdenI.setFont(new Font("Arial", 1, 12));
        this.JSPNOrdenI.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNOrdenI.setToolTipText("Orden de impresión en el resultado");
        this.JSPNOrdenI.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden Imp.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAbreviaturaRef.setFont(new Font("Arial", 1, 12));
        this.JTFAbreviaturaRef.setToolTipText("");
        this.JTFAbreviaturaRef.setBorder(BorderFactory.createTitledBorder((Border) null, "Abreviatura de Ref", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTResultado.setFont(new Font("Arial", 1, 12));
        this.JTFTResultado.setToolTipText("Tiempo de Entrega de Resultado");
        this.JTFTResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiempo EntregaR", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPerfiles.setFont(new Font("Arial", 1, 12));
        this.JCBPerfiles.setToolTipText("Perfiles de pruebas");
        this.JCBPerfiles.setBorder(BorderFactory.createTitledBorder((Border) null, "Perfil", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLIS.setFont(new Font("Arial", 1, 12));
        this.JTFLIS.setToolTipText("");
        this.JTFLIS.setBorder(BorderFactory.createTitledBorder((Border) null, "LIS", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBAreaLab, -2, 227, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoMuestra, -2, 242, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMetodo, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTubo, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPerfiles, 0, -1, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCHEsPrioritario).addGap(14, 14, 14).addComponent(this.JCHValidarLab).addGap(18, 18, 18).addComponent(this.JCHRemitido)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JSPPreparacion1, -2, 280, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRequisitosP, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNivelC, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNDias, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNOrdenI, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFAbreviaturaRef, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFTResultado, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFLIS, -2, 106, -2))).addGap(143, 143, 143))).addGap(30, 30, 30)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBAreaLab, -2, 50, -2).addComponent(this.JCBTipoMuestra, -2, 50, -2).addComponent(this.JCBMetodo, -2, 50, -2).addComponent(this.JCBTubo, -2, 50, -2).addComponent(this.JCBPerfiles, -2, 50, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPPreparacion1, -2, 58, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPRequisitosP, -1, 58, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNivelC, -2, 50, -2).addComponent(this.JSPNDias, -2, 50, -2).addComponent(this.JSPNOrdenI, -2, 50, -2).addComponent(this.JTFTResultado, -2, 50, -2).addComponent(this.JTFAbreviaturaRef, -2, 51, -2).addComponent(this.JTFLIS, -2, 51, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsPrioritario).addComponent(this.JCHValidarLab).addComponent(this.JCHRemitido)).addContainerGap(-1, 32767)));
        this.JPIProcedimientoTab.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION DEL PROCEDIMIENTO", 2, 1, new Font("Arial", 1, 14), Color.red));
        this.JPIProcedimientoTab.setForeground(new Color(0, 103, 0));
        this.JPIProcedimientoTab.setFont(new Font("Arial", 1, 14));
        this.JTFCodigoCups.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoCups.setToolTipText("");
        this.JTFCodigoCups.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoCups.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFProcedimiento.6
            public void focusLost(FocusEvent evt) {
                JIFFProcedimiento.this.JTFCodigoCupsFocusLost(evt);
            }
        });
        this.JTFCodigoCups.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.7
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JTFCodigoCupsActionPerformed(evt);
            }
        });
        this.JTFCodigoCups.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFProcedimiento.8
            public void keyPressed(KeyEvent evt) {
                JIFFProcedimiento.this.JTFCodigoCupsKeyPressed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoPrcRips.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPrcRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Procedimiento Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFinalidad.setFont(new Font("Arial", 1, 12));
        this.JCBFinalidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Finalidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAgrupacion.setFont(new Font("Arial", 1, 12));
        this.JCBAgrupacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Agrupación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsCita.setFont(new Font("Arial", 1, 12));
        this.JCHEsCita.setText("Es Cita?");
        this.JCHEsCita.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.9
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsCitaActionPerformed(evt);
            }
        });
        this.JCHEsPaquete.setFont(new Font("Arial", 1, 12));
        this.JCHEsPaquete.setText("Es Paquete?");
        this.JCHEsPaquete.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.10
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsPaqueteActionPerformed(evt);
            }
        });
        this.JCHGeneraAlerta.setFont(new Font("Arial", 1, 12));
        this.JCHGeneraAlerta.setText("Genera Alerta?");
        this.JCHGeneraAlerta.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.11
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHGeneraAlertaActionPerformed(evt);
            }
        });
        this.JCHEsOdontologico.setFont(new Font("Arial", 1, 12));
        this.JCHEsOdontologico.setText("Es Odontologico?");
        this.JCHEsOdontologico.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.12
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsOdontologicoActionPerformed(evt);
            }
        });
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Códigos a Visualizar", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFCReal.setFont(new Font("Arial", 1, 12));
        this.JTFCReal.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Real (Soat)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCHomologado.setFont(new Font("Arial", 1, 12));
        this.JTFCHomologado.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Homologado (Cups)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCPersonalizado.setFont(new Font("Arial", 1, 12));
        this.JTFCPersonalizado.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Personalizado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCPersonalizado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.13
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JTFCPersonalizadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCHomologado).addComponent(this.JTFCReal, GroupLayout.Alignment.TRAILING).addComponent(this.JTFCPersonalizado, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JTFCReal, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCHomologado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCPersonalizado, -2, -1, -2).addContainerGap(19, 32767)));
        this.JCHEsPypOdon.setFont(new Font("Arial", 1, 12));
        this.JCHEsPypOdon.setText("Es PyP Odontología");
        this.JCHEsPypOdon.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.14
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsPypOdonActionPerformed(evt);
            }
        });
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO DE EDAD (DIAS)", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPEdadI.setFont(new Font("Arial", 1, 12));
        this.JSPEdadI.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPEdadI.setBorder(BorderFactory.createTitledBorder((Border) null, "Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEdadM.setFont(new Font("Arial", 1, 12));
        this.JSPEdadM.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPEdadM.setBorder(BorderFactory.createTitledBorder((Border) null, "Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPEdadI, -2, 99, -2).addGap(18, 18, 18).addComponent(this.JSPEdadM, -2, 89, -2).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPEdadI, -2, 50, -2).addComponent(this.JSPEdadM, -2, 50, -2)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO DE SEXO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBSexo.setFont(new Font("Arial", 1, 12));
        this.JCBSexo.setModel(new DefaultComboBoxModel(new String[]{"Ambos", "Femenino", "Masculino"}));
        this.JCBSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSexo.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFProcedimiento.15
            public void itemStateChanged(ItemEvent evt) {
                JIFFProcedimiento.this.JCBSexoItemStateChanged(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSexo, 0, 129, 32767));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSexo, -2, 50, -2));
        this.JCHEsAProcEnfer.setFont(new Font("Arial", 1, 12));
        this.JCHEsAProcEnfer.setText("Es Agenda Procedimiento Enfermeria");
        this.JCHEsAProcEnfer.setToolTipText("Clasificacion de procedimientos para mostrar en la agenda de enfemeria");
        this.JCHEsAProcEnfer.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.16
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsAProcEnferActionPerformed(evt);
            }
        });
        this.JCHEsAgenda.setFont(new Font("Arial", 1, 12));
        this.JCHEsAgenda.setText("Es Agenda?");
        this.JCHEsAgenda.setToolTipText("Para realizar el fintro en la agenda de los procedimientos");
        this.JCHEsAgenda.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.17
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsAgendaActionPerformed(evt);
            }
        });
        this.JSPImpuesto.setFont(new Font("Arial", 1, 12));
        this.JSPImpuesto.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "% Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsASeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCHEsASeguimiento.setText("Seguimiento Ambulatorio?");
        this.JCHEsASeguimiento.setToolTipText("Clasificacion de procedimientos para mostrar en la agenda de enfemeria");
        this.JCHEsASeguimiento.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.18
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsASeguimientoActionPerformed(evt);
            }
        });
        this.JCHEsCitologia.setFont(new Font("Arial", 1, 12));
        this.JCHEsCitologia.setText("Es Citologia?");
        this.JCHEsCitologia.setToolTipText("Clasificacion de procedimientos para mostrar en la agenda de enfemeria");
        this.JCHEsCitologia.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.19
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsCitologiaActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.setToolTipText("Clasificacion de procedimientos para mostrar en la agenda de enfemeria");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.20
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEsCorreo.setFont(new Font("Arial", 1, 12));
        this.JCHEsCorreo.setSelected(true);
        this.JCHEsCorreo.setText("Envio Por Correo Electronico?");
        this.JCHEsCorreo.setToolTipText("Clasificacion de procedimientos para mostrar en la agenda de enfemeria");
        this.JCHEsCorreo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.21
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEsCorreoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoPrcRips, -2, 217, -2).addGap(12, 12, 12).addComponent(this.JCBFinalidad, -2, 562, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoProcedimiento, -2, 430, -2).addGap(20, 20, 20).addComponent(this.JCBAgrupacion, -2, 340, -2)))).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigoCups, -2, 129, -2).addGap(3, 3, 3).addComponent(this.JTFNombre, -2, 656, -2))).addGap(15, 15, 15).addComponent(this.jPanel3, -1, -1, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEsCita).addGap(13, 13, 13).addComponent(this.JCHEsPaquete).addGap(21, 21, 21).addComponent(this.JCHGeneraAlerta).addGap(17, 17, 17).addComponent(this.JCHEsOdontologico).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addGap(7, 7, 7).addComponent(this.JCHEsPypOdon).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsAgenda)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEsAProcEnfer).addGap(18, 18, 18).addComponent(this.JCHEsASeguimiento, -2, 197, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsCitologia, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsCorreo, -2, 223, -2))).addGap(64, 64, 64).addComponent(this.JSPImpuesto, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel3, -2, -1, -2).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFCodigoCups, -2, 51, -2)).addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JCBTipoPrcRips, -2, -1, -2)).addComponent(this.JCBFinalidad, -2, 50, -2)).addGap(7, 7, 7).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoProcedimiento, -2, -1, -2).addComponent(this.JCBAgrupacion, -2, -1, -2)))).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsPaquete).addComponent(this.JCHEsCita)).addComponent(this.JCHGeneraAlerta).addComponent(this.JCHEsOdontologico).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsPypOdon).addComponent(this.JCHEsAgenda).addComponent(this.JCHEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsAProcEnfer).addComponent(this.JCHEsASeguimiento).addComponent(this.JCHEsCitologia).addComponent(this.JCHEsCorreo)).addGap(25, 25, 25)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -2, -1, -2).addComponent(this.jPanel5, -2, -1, -2)))).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.JSPImpuesto, -2, 50, -2))).addGap(22, 22, 22)));
        this.JPIProcedimientoTab.addTab("BASICA", this.JPIDatos);
        this.JTFNombreSoat.setFont(new Font("Arial", 1, 12));
        this.JTFNombreSoat.setToolTipText("");
        this.JTFNombreSoat.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Soat", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Valor", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGOpciones3.add(this.JRBGrupo);
        this.JRBGrupo.setFont(new Font("Arial", 1, 12));
        this.JRBGrupo.setSelected(true);
        this.JRBGrupo.setText("Grupo");
        this.JRBGrupo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.22
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JRBGrupoActionPerformed(evt);
            }
        });
        this.JBGOpciones3.add(this.JRBFactor);
        this.JRBFactor.setFont(new Font("Arial", 1, 12));
        this.JRBFactor.setText("Factor");
        this.JRBFactor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.23
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JRBFactorActionPerformed(evt);
            }
        });
        this.JBGOpciones3.add(this.JRBUvr);
        this.JRBUvr.setFont(new Font("Arial", 1, 12));
        this.JRBUvr.setText("Uvr");
        this.JRBUvr.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.24
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JRBUvrActionPerformed(evt);
            }
        });
        this.JBGOpciones3.add(this.JRBValor);
        this.JRBValor.setFont(new Font("Arial", 1, 12));
        this.JRBValor.setText("Valor");
        this.JRBValor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.25
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JRBValorActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBGrupo).addGap(18, 18, 18).addComponent(this.JRBFactor).addGap(18, 18, 18).addComponent(this.JRBUvr).addGap(18, 18, 18).addComponent(this.JRBValor).addContainerGap(-1, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBGrupo).addComponent(this.JRBFactor).addComponent(this.JRBUvr).addComponent(this.JRBValor)).addContainerGap(-1, 32767)));
        this.JCBManualTarifa.setFont(new Font("Arial", 1, 12));
        this.JCBManualTarifa.setBorder(BorderFactory.createTitledBorder((Border) null, "Manual Tarifas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClaseCita.setFont(new Font("Arial", 1, 12));
        this.JCBClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase de Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClaseCita.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFProcedimiento.26
            public void itemStateChanged(ItemEvent evt) {
                JIFFProcedimiento.this.JCBClaseCitaItemStateChanged(evt);
            }
        });
        this.JCBTipoHC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoHC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Historia Clinica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoHC.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFProcedimiento.27
            public void itemStateChanged(ItemEvent evt) {
                JIFFProcedimiento.this.JCBTipoHCItemStateChanged(evt);
            }
        });
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValor.setHorizontalAlignment(0);
        this.JFTFValor.setText("0");
        this.JFTFValor.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIAdicionalLayout = new GroupLayout(this.JPIAdicional);
        this.JPIAdicional.setLayout(JPIAdicionalLayout);
        JPIAdicionalLayout.setHorizontalGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionalLayout.createSequentialGroup().addComponent(this.JTFNombreSoat, -2, 781, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel6, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValor, -2, 134, -2).addGap(4, 4, 4)).addGroup(JPIAdicionalLayout.createSequentialGroup().addComponent(this.JCBTipoHC, -2, 383, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBClaseCita, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBManualTarifa, -2, 327, -2).addContainerGap()))));
        JPIAdicionalLayout.setVerticalGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionalLayout.createSequentialGroup().addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.JTFNombreSoat)).addComponent(this.JFTFValor, -2, 52, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoHC, -2, -1, -2).addComponent(this.JCBClaseCita, -2, -1, -2)).addComponent(this.JCBManualTarifa, -2, -1, -2)).addContainerGap(168, 32767)));
        this.JPIProcedimientoTab.addTab("ADICIONAL", this.JPIAdicional);
        this.JTPOpciones.setForeground(Color.red);
        this.JTPOpciones.setFont(new Font("Arial", 1, 14));
        this.JBTProcedimientoCosto.setFont(new Font("Arial", 1, 12));
        this.JBTProcedimientoCosto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/centro de costo.png")));
        this.JBTProcedimientoCosto.setText("Centro de Costo");
        this.JBTProcedimientoCosto.setEnabled(false);
        this.JBTProcedimientoCosto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.28
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTProcedimientoCostoActionPerformed(evt);
            }
        });
        this.JBTProcedimientoTarifa.setFont(new Font("Arial", 1, 12));
        this.JBTProcedimientoTarifa.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tarifas.png")));
        this.JBTProcedimientoTarifa.setText("Tarifas");
        this.JBTProcedimientoTarifa.setEnabled(false);
        this.JBTProcedimientoTarifa.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.29
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTProcedimientoTarifaActionPerformed(evt);
            }
        });
        this.JBTPaquete.setFont(new Font("Arial", 1, 12));
        this.JBTPaquete.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Autorizacion.png")));
        this.JBTPaquete.setText("Paquetes");
        this.JBTPaquete.setEnabled(false);
        this.JBTPaquete.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.30
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTPaqueteActionPerformed(evt);
            }
        });
        this.JBTEquipo.setFont(new Font("Arial", 1, 12));
        this.JBTEquipo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion.png")));
        this.JBTEquipo.setText("Equipo");
        this.JBTEquipo.setEnabled(false);
        this.JBTEquipo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.31
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTEquipoActionPerformed(evt);
            }
        });
        this.JBSuministro.setFont(new Font("Arial", 1, 12));
        this.JBSuministro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Hc29x27.png")));
        this.JBSuministro.setText("Suministros");
        this.JBSuministro.setToolTipText("Agregar Suministros a procedimientos");
        this.JBSuministro.setEnabled(false);
        this.JBSuministro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.32
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBSuministroActionPerformed(evt);
            }
        });
        this.JBT_CGruposCx.setFont(new Font("Arial", 1, 12));
        this.JBT_CGruposCx.setIcon(new ImageIcon(getClass().getResource("/Imagenes/estratos.png")));
        this.JBT_CGruposCx.setText("Grupos Qx");
        this.JBT_CGruposCx.setToolTipText("Configuración de Grupos Qx");
        this.JBT_CGruposCx.setEnabled(false);
        this.JBT_CGruposCx.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.33
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBT_CGruposCxActionPerformed(evt);
            }
        });
        this.JBT_ProxEsp.setFont(new Font("Arial", 1, 12));
        this.JBT_ProxEsp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/procedimientos.png")));
        this.JBT_ProxEsp.setText("Procedimiento");
        this.JBT_ProxEsp.setToolTipText("Procedimiento por Especialidad");
        this.JBT_ProxEsp.setEnabled(false);
        this.JBT_ProxEsp.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.34
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBT_ProxEspActionPerformed(evt);
            }
        });
        this.JBT_ProxEsp1.setFont(new Font("Arial", 1, 12));
        this.JBT_ProxEsp1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/relacionados.png")));
        this.JBT_ProxEsp1.setText("Pro. Relacionado");
        this.JBT_ProxEsp1.setToolTipText("Procedimientos Relacionados");
        this.JBT_ProxEsp1.setEnabled(false);
        this.JBT_ProxEsp1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.35
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBT_ProxEsp1ActionPerformed(evt);
            }
        });
        GroupLayout JPMenu1Layout = new GroupLayout(this.JPMenu1);
        this.JPMenu1.setLayout(JPMenu1Layout);
        JPMenu1Layout.setHorizontalGroup(JPMenu1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMenu1Layout.createSequentialGroup().addContainerGap().addComponent(this.JBTProcedimientoCosto, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTProcedimientoTarifa, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTPaquete, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEquipo, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSuministro, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_CGruposCx, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_ProxEsp, -2, 159, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_ProxEsp1, -2, 176, -2).addContainerGap()));
        JPMenu1Layout.setVerticalGroup(JPMenu1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMenu1Layout.createSequentialGroup().addContainerGap().addGroup(JPMenu1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTProcedimientoTarifa, -2, 51, -2).addComponent(this.JBTPaquete, -2, 51, -2).addComponent(this.JBTEquipo, -2, 51, -2).addComponent(this.JBSuministro, -2, 51, -2).addComponent(this.JBT_CGruposCx, -2, 51, -2).addComponent(this.JBT_ProxEsp, -2, 51, -2).addComponent(this.JBTProcedimientoCosto, -2, 51, -2).addComponent(this.JBT_ProxEsp1, -2, 51, -2)).addGap(19, 19, 19)));
        this.JTPOpciones.addTab("MENU 1", this.JPMenu1);
        this.JBTComplicaciones.setFont(new Font("Arial", 1, 12));
        this.JBTComplicaciones.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Mantenimiento.jpg")));
        this.JBTComplicaciones.setText("Complicaciones");
        this.JBTComplicaciones.setEnabled(false);
        this.JBTComplicaciones.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.36
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTComplicacionesActionPerformed(evt);
            }
        });
        this.JBTConcentimientos.setFont(new Font("Arial", 1, 12));
        this.JBTConcentimientos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBTConcentimientos.setText("Consentimientos");
        this.JBTConcentimientos.setEnabled(false);
        this.JBTConcentimientos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.37
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTConcentimientosActionPerformed(evt);
            }
        });
        this.JBTRemisiones.setFont(new Font("Arial", 1, 12));
        this.JBTRemisiones.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTRemisiones.setText("Remision");
        this.JBTRemisiones.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.38
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTRemisionesActionPerformed(evt);
            }
        });
        this.JBTServicioRips.setFont(new Font("Arial", 1, 12));
        this.JBTServicioRips.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Servicio_Rips.png")));
        this.JBTServicioRips.setText("Servicio Rips");
        this.JBTServicioRips.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.39
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTServicioRipsActionPerformed(evt);
            }
        });
        this.JBTTiempo.setFont(new Font("Arial", 1, 12));
        this.JBTTiempo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Alarma.png")));
        this.JBTTiempo.setText("Tiempo Servicio");
        this.JBTTiempo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.40
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTTiempoActionPerformed(evt);
            }
        });
        this.JBTFInalidad.setFont(new Font("Arial", 1, 12));
        this.JBTFInalidad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/FinalidadProcedimiento.png")));
        this.JBTFInalidad.setText("Finalidad");
        this.JBTFInalidad.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.41
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTFInalidadActionPerformed(evt);
            }
        });
        GroupLayout JPMenu2Layout = new GroupLayout(this.JPMenu2);
        this.JPMenu2.setLayout(JPMenu2Layout);
        JPMenu2Layout.setHorizontalGroup(JPMenu2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMenu2Layout.createSequentialGroup().addContainerGap().addComponent(this.JBTComplicaciones).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTConcentimientos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTRemisiones, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTServicioRips, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTTiempo, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTFInalidad, -2, 175, -2).addContainerGap(351, 32767)));
        JPMenu2Layout.setVerticalGroup(JPMenu2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMenu2Layout.createSequentialGroup().addContainerGap().addGroup(JPMenu2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTServicioRips, -1, -1, 32767).addComponent(this.JBTRemisiones, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPMenu2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTConcentimientos, -2, 51, -2).addComponent(this.JBTComplicaciones, -2, 51, -2)).addComponent(this.JBTTiempo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBTFInalidad, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(31, 32767)));
        this.JTPOpciones.addTab("MENU 2", this.JPMenu2);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFProcedimiento.42
            public void mouseClicked(MouseEvent evt) {
                JIFFProcedimiento.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.43
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTExportarActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.JBGOpciones2.add(this.JCHTodo);
        this.JCHTodo.setFont(new Font("Arial", 1, 12));
        this.JCHTodo.setText("Todo");
        this.JCHTodo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.44
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHTodoActionPerformed(evt);
            }
        });
        this.JBGOpciones2.add(this.JCHProcedimiento);
        this.JCHProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCHProcedimiento.setText("Con Movimiento");
        this.JCHProcedimiento.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.45
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHProcedimientoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JCHTodo).addGap(18, 18, 18).addComponent(this.JCHProcedimiento).addContainerGap(20, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHTodo).addComponent(this.JCHProcedimiento)).addContainerGap(19, 32767)));
        GroupLayout JPI_ExportacionLayout = new GroupLayout(this.JPI_Exportacion);
        this.JPI_Exportacion.setLayout(JPI_ExportacionLayout);
        JPI_ExportacionLayout.setHorizontalGroup(JPI_ExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportacionLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JTFRuta, -2, 435, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 186, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        JPI_ExportacionLayout.setVerticalGroup(JPI_ExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_ExportacionLayout.createSequentialGroup().addContainerGap(13, 32767).addGroup(JPI_ExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -2, 51, -2).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 54, -2).addComponent(this.jPanel1, -2, -1, -2)).addContainerGap()));
        this.JTPOpciones.addTab("UTILIDADES", this.JPI_Exportacion);
        GroupLayout JPIDatosProcLayout = new GroupLayout(this.JPIDatosProc);
        this.JPIDatosProc.setLayout(JPIDatosProcLayout);
        JPIDatosProcLayout.setHorizontalGroup(JPIDatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIProcedimientoTab).addGroup(JPIDatosProcLayout.createSequentialGroup().addGroup(JPIDatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JTPOpciones, GroupLayout.Alignment.TRAILING, -2, 0, 32767)).addContainerGap()));
        JPIDatosProcLayout.setVerticalGroup(JPIDatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosProcLayout.createSequentialGroup().addComponent(this.JPIProcedimientoTab, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPOpciones, -2, 119, -2).addGap(19, 19, 19)));
        this.JTPDatosProc.addTab("DATOS", this.JPIDatosProc);
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDescripcion.setAutoscrolls(true);
        this.JTPDescripcion.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion.setViewportView(this.JTPDescripcion);
        this.JCHEstadoC.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoC.setSelected(true);
        this.JCHEstadoC.setText("Estado");
        this.JCHEstadoC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.46
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHEstadoCActionPerformed(evt);
            }
        });
        this.JSPNOrden.setFont(new Font("Arial", 1, 12));
        this.JSPNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNOrden.setToolTipText("N° Orden");
        this.JSPNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionarC.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarC.setText("Adicionar");
        this.JBTAdicionarC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.47
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JBTAdicionarCActionPerformed(evt);
            }
        });
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFProcedimiento.48
            public void mouseClicked(MouseEvent evt) {
                JIFFProcedimiento.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JSPDescripcion1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE PLANILLA DE TRABAJO", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPDescripcion1.setAutoscrolls(true);
        this.JTPDescripcion1.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion1.setViewportView(this.JTPDescripcion1);
        this.JCBTipoEquipo.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEquipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Equipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIComentarioLayout = new GroupLayout(this.JPIComentario);
        this.JPIComentario.setLayout(JPIComentarioLayout);
        JPIComentarioLayout.setHorizontalGroup(JPIComentarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIComentarioLayout.createSequentialGroup().addContainerGap().addGroup(JPIComentarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPIComentarioLayout.createSequentialGroup().addComponent(this.JSPDescripcion, -2, 507, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIComentarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoEquipo, -2, 376, -2).addGroup(JPIComentarioLayout.createSequentialGroup().addComponent(this.JSPNOrden, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstadoC))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarC, -1, 502, 32767)).addComponent(this.JSPDescripcion1)).addContainerGap()));
        JPIComentarioLayout.setVerticalGroup(JPIComentarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIComentarioLayout.createSequentialGroup().addGroup(JPIComentarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDescripcion, -2, 134, -2).addGroup(JPIComentarioLayout.createSequentialGroup().addComponent(this.JCBTipoEquipo, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIComentarioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPNOrden, -2, 51, -2).addComponent(this.JCHEstadoC))).addGroup(JPIComentarioLayout.createSequentialGroup().addGap(39, 39, 39).addComponent(this.JBTAdicionarC, -2, 73, -2))).addGap(10, 10, 10).addComponent(this.JSPDetalle1, -2, 154, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDescripcion1, -2, 290, -2).addGap(121, 121, 121)));
        this.JTPDatosProc.addTab("COMENTARIOS", this.JPIComentario);
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda Filtrada", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre o código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.49
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JTFNombreBusquedaActionPerformed(evt);
            }
        });
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFProcedimiento.50
            public void keyTyped(KeyEvent evt) {
                JIFFProcedimiento.this.JTFNombreBusquedaKeyTyped(evt);
            }
        });
        this.JBGOpciones.add(this.JCHComienza);
        this.JCHComienza.setFont(new Font("Arial", 1, 12));
        this.JCHComienza.setText("Comienza");
        this.JCHComienza.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.51
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHComienzaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JCHContiene);
        this.JCHContiene.setFont(new Font("Arial", 1, 12));
        this.JCHContiene.setSelected(true);
        this.JCHContiene.setText("Contiene");
        this.JCHContiene.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFProcedimiento.52
            public void actionPerformed(ActionEvent evt) {
                JIFFProcedimiento.this.JCHContieneActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda, -1, 1047, 32767).addGap(18, 18, 18).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHContiene).addComponent(this.JCHComienza)).addContainerGap(243, 32767)));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JCHComienza).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHContiene)).addComponent(this.JTFNombreBusqueda, -2, 50, -2));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFProcedimiento.53
            public void mouseClicked(MouseEvent evt) {
                JIFFProcedimiento.this.JTDetalleMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JIFFProcedimiento.this.JTDetalleMouseEntered(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIBusquedaLayout = new GroupLayout(this.JPIBusqueda);
        this.JPIBusqueda.setLayout(JPIBusquedaLayout);
        JPIBusquedaLayout.setHorizontalGroup(JPIBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 1403, 32767).addComponent(this.JPIDatosBusqueda, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPIBusquedaLayout.setVerticalGroup(JPIBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 552, -2).addContainerGap(65, 32767)));
        this.JTPDatosProc.addTab("BÚSQUEDA", this.JPIBusqueda);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosProc));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosProc, -2, 722, -2));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            consultarDatosProcedimientos(this.JTDetalle.getSelectedRow());
        } else {
            mCrearModeloDatos();
            mCrearModeloDatosC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRemitidoActionPerformed(ActionEvent evt) {
        if (this.JCHRemitido.isSelected()) {
            this.xesremitido = 1;
        } else {
            this.xesremitido = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHComienzaActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHContieneActionPerformed(ActionEvent evt) {
        this.xtipobusqueda = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
        mCargarC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTProcedimientoCostoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Procedimiento Por Centro De Costo");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTProcedimientoTarifaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Tarifa Procedimiento");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsCitaActionPerformed(ActionEvent evt) {
        if (this.JCHEsCita.isSelected()) {
            this.xescita = 1;
        } else {
            this.xescita = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHValidarLabActionPerformed(ActionEvent evt) {
        if (this.JCHValidarLab.isSelected()) {
            this.xvalidarlab = 1;
        } else {
            this.xvalidarlab = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPaqueteActionPerformed(ActionEvent evt) {
        if (this.JCHEsPaquete.isSelected()) {
            this.xespaquete = 1;
        } else {
            this.xespaquete = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPaqueteActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Procedimiento x Paquete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHGeneraAlertaActionPerformed(ActionEvent evt) {
        if (this.JCHGeneraAlerta.isSelected()) {
            this.xgeneraalerta = 1;
        } else {
            this.xgeneraalerta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsOdontologicoActionPerformed(ActionEvent evt) {
        if (this.JCHEsOdontologico.isSelected()) {
            this.xesodontologico = 1;
        } else {
            this.xesodontologico = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1) {
            this.xidcometario = Long.valueOf(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 0).toString()).longValue();
            this.JTPDescripcion.setText(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 1).toString());
            this.JCBTipoEquipo.setSelectedItem(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 2).toString());
            this.JSPNOrden.setValue(Long.valueOf(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 3).toString()));
            this.JCHEstadoC.setSelected(Boolean.valueOf(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstadoC.isSelected()) {
                this.xestadoc = 1;
            } else {
                this.xestadoc = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoCActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoC.isSelected()) {
            this.xestadoc = 1;
        } else {
            this.xestadoc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarCActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (!this.JTPDescripcion.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xidcometario == 0) {
                        this.xsql = "insert into g_procedimiento_comentario(`Id_Procedimiento` , IdEquipo, `Descripcion` , `Orden` , `Estado`  , `UsuariosS`) values('" + Principal.txtNo.getText() + "','" + this.xIdTipoEquipo[this.JCBTipoEquipo.getSelectedIndex()] + "','" + this.JTPDescripcion.getText() + "','" + this.JSPNOrden.getValue() + "','" + this.xestadoc + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsulta.ejecutarSQL(this.xsql);
                        this.xconsulta.cerrarConexionBd();
                    } else {
                        this.xsql = "update g_procedimiento_comentario set `Descripcion`='" + this.JTPDescripcion.getText() + "', `IdEquipo`='" + this.xIdTipoEquipo[this.JCBTipoEquipo.getSelectedIndex()] + "', `Orden`='" + this.JSPNOrden.getValue() + "', `Estado`='" + this.xestadoc + "', `Fecha`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', `UsuariosS`='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.xidcometario + "'";
                        this.xconsulta.ejecutarSQL(this.xsql);
                        this.xconsulta.cerrarConexionBd();
                    }
                    mCargarDatosTablaC();
                    this.xidcometario = 0L;
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La descripción no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPDescripcion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTodoActionPerformed(ActionEvent evt) {
        this.xsql = "SELECT g_procedimiento.id, g_procedimiento.Nbre, f_tipoprocedimiento.Nbre, f_tipoprocrips.Nbre, f_tipofinprocedimiento.Nbre, f_tipoconceptoagrup.Nbre, g_procedimiento.NivelComplejidad,IF(g_procedimiento.Preparacion IS NULL, '',g_procedimiento.Preparacion) AS preparacion , l_areas.Nbre, g_procedimiento.Ref, g_procedimiento.EsRemitido, l_tipomuestra.Nbre, g_procedimiento.Estado, g_procedimiento.EsCita, g_procedimiento.ValidarLab, g_procedimiento.Paquete, g_procedimiento.Alerta, g_procedimiento.EsOdontologico, g_procedimiento.PyPodonto, IF(g_procedimiento.RPrevios IS NULL,'', g_procedimiento.RPrevios) AS RequisitosP, g_procedimiento.Oportunidad, l_tipo_metodo.Nbre , g_procedimiento.NOrdenI, IF(g_procedimiento.VariablesL IS NULL,'',g_procedimiento.VariablesL) AS VariableL, g_procedimiento.Es_Prioritario,  g_procedimiento.NDiasR, `l_tipo_tubo`.`Nbre`,g_procedimiento.C_Real,g_procedimiento.C_Homologado FROM g_procedimiento INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tipoprocrips  ON (g_procedimiento.Id_TipoProcRIPS = f_tipoprocrips.Id) INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) INNER JOIN f_tipoconceptoagrup  ON (g_procedimiento.Id_TipoConceptoAgrup = f_tipoconceptoagrup.Id) INNER JOIN l_areas  ON (l_areas.Id = g_procedimiento.Id_Area) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) INNER JOIN l_tipo_metodo ON (g_procedimiento.Id_TipoMetodo = l_tipo_metodo.Id) INNER JOIN `l_tipo_tubo` ON (`l_tipo_tubo`.`Id` = `g_procedimiento`.`Id_Tubo`) WHERE g_procedimiento.Nbre LIKE '%' ORDER BY f_tipoprocedimiento.Nbre ASC, g_procedimiento.Nbre ASC  ";
        mCargarDatosTabla(this.xsql);
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHProcedimientoActionPerformed(ActionEvent evt) {
        this.xsql = "SELECT g_procedimiento.id, g_procedimiento.Nbre, f_tipoprocedimiento.Nbre, f_tipoprocrips.Nbre, f_tipofinprocedimiento.Nbre, f_tipoconceptoagrup.Nbre, g_procedimiento.NivelComplejidad, IF(g_procedimiento.Preparacion IS NULL, '',g_procedimiento.Preparacion) AS preparacion         \n, l_areas.Nbre, g_procedimiento.Ref, g_procedimiento.EsRemitido, l_tipomuestra.Nbre, g_procedimiento.Estado, g_procedimiento.EsCita, g_procedimiento.ValidarLab, g_procedimiento.Paquete, g_procedimiento.Alerta, g_procedimiento.EsOdontologico, g_procedimiento.PyPodonto,IF(g_procedimiento.RPrevios IS NULL, '', g_procedimiento.RPrevios) AS RequisitosP, g_procedimiento.Oportunidad, l_tipo_metodo.Nbre , g_procedimiento.NOrdenI, IF(g_procedimiento.VariablesL IS NULL,'',g_procedimiento.VariablesL) AS VariableL, g_procedimiento.Es_Prioritario,  g_procedimiento.NDiasR, `l_tipo_tubo`.`Nbre` , g_procedimiento.C_Real,  g_procedimiento.C_Homologado       \nFROM g_procedimiento INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN `baseserver`.`f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN f_tipoprocrips         \nON (g_procedimiento.Id_TipoProcRIPS = f_tipoprocrips.Id) INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) INNER JOIN f_tipoconceptoagrup         \nON (g_procedimiento.Id_TipoConceptoAgrup = f_tipoconceptoagrup.Id) INNER JOIN l_areas  ON (l_areas.Id = g_procedimiento.Id_Area) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) INNER JOIN l_tipo_metodo ON (g_procedimiento.Id_TipoMetodo = l_tipo_metodo.Id) INNER JOIN `l_tipo_tubo` ON (`l_tipo_tubo`.`Id` = `g_procedimiento`.`Id_Tubo`)        \nGROUP BY f_itemordenesproced.`Id_Procedimiento` ORDER BY f_tipoprocedimiento.Nbre ASC, g_procedimiento.Nbre ASC;\n            ";
        mCargarDatosTabla(this.xsql);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEquipoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Equipo x Procedimiento");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPrioritarioActionPerformed(ActionEvent evt) {
        if (this.JCHEsPrioritario.isSelected()) {
            this.xesprioritario = 1;
        } else {
            this.xesprioritario = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSuministroActionPerformed(ActionEvent evt) {
        JDProcedimientoxSum xven = new JDProcedimientoxSum(null, true, "SUMINISTRO POR PROCEDIMIENTO", Principal.txtNo.getText());
        xven.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CGruposCxActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JD_CGruposQx dialog = new JD_CGruposQx(null, true);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_ProxEspActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDProxEspc dialog = new JDProxEspc(null, true);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPypOdonActionPerformed(ActionEvent evt) {
        if (this.JCHEsPypOdon.isSelected()) {
            this.xEsPypOdontologico = 1;
        } else {
            this.xEsPypOdontologico = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_ProxEsp1ActionPerformed(ActionEvent evt) {
        JDProcedimentoRelacionadoController jd = new JDProcedimentoRelacionadoController(null, true, new Long(this.xidtipoproc[this.JCBTipoProcedimiento.getSelectedIndex()]));
        jd.setLocationRelativeTo(this);
        jd.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSexoItemStateChanged(ItemEvent evt) {
        if (this.JCBSexo.getSelectedIndex() == 0) {
            this.xsexo = "A";
        } else if (this.JCBSexo.getSelectedIndex() == 1) {
            this.xsexo = "F";
        } else {
            this.xsexo = "M";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsAProcEnferActionPerformed(ActionEvent evt) {
        if (this.JCHEsAProcEnfer.isSelected()) {
            this.xesAProcEnfer = 1;
        } else {
            this.xesAProcEnfer = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsAgendaActionPerformed(ActionEvent evt) {
        if (this.JCHEsAgenda.isSelected()) {
            this.xesagenda = 1;
        } else {
            this.xesagenda = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCPersonalizadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGrupoActionPerformed(ActionEvent evt) {
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xtipov = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFactorActionPerformed(ActionEvent evt) {
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Factor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xtipov = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUvrActionPerformed(ActionEvent evt) {
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Uvr", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xtipov = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBValorActionPerformed(ActionEvent evt) {
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xtipov = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoHCItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClaseCitaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTComplicacionesActionPerformed(ActionEvent evt) {
        JDGenerico1Combo1Check jd = new JDGenerico1Combo1Check(null, true, Principal.txtNo.getText(), "Complicaciones por procedimiento");
        jd.setLocationRelativeTo(this);
        jd.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConcentimientosActionPerformed(ActionEvent evt) {
        JDGenerico1Combo1Check jd = new JDGenerico1Combo1Check(null, true, Principal.txtNo.getText(), "Concentimientos por procedimiento");
        jd.setLocationRelativeTo(this);
        jd.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoCupsKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNombreBusqueda.setText(this.JTFCodigoCups.getText());
            this.JTFCodigoCups.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoCupsFocusLost(FocusEvent evt) {
        if (!this.JTFCodigoCups.getText().isEmpty()) {
            mCargarC();
            if (this.JTDetalle.getRowCount() != -1) {
                consultarDatosProcedimientos(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDatosProcStateChanged(ChangeEvent evt) {
        if (this.JTPDatosProc.getSelectedIndex() == 2) {
            this.JTFNombreBusqueda.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsASeguimientoActionPerformed(ActionEvent evt) {
        if (this.JCHEsASeguimiento.isSelected()) {
            this.esSeguimiento = 1;
        } else {
            this.esSeguimiento = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsCitologiaActionPerformed(ActionEvent evt) {
        if (this.JCHEsCitologia.isSelected()) {
            this.esCitologia = 1;
        } else {
            this.esCitologia = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRemisionesActionPerformed(ActionEvent evt) {
        idProcedimiento = this.JTFCodigoCups.getText();
        if (!Principal.txtNo.getText().isEmpty()) {
            JDProcedimientoEmpresaRemision jDProcedimientoEmpresaRemision = new JDProcedimientoEmpresaRemision(null, true, Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            jDProcedimientoEmpresaRemision.setLocationRelativeTo(null);
            jDProcedimientoEmpresaRemision.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "Verificar", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTServicioRipsActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Procedimiento Servicio Rips");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsCorreoActionPerformed(ActionEvent evt) {
        if (this.JCHEsCorreo.isSelected()) {
            this.esCorreo = 1;
        } else {
            this.esCorreo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTTiempoActionPerformed(ActionEvent evt) {
        idProcedimiento = this.JTFCodigoCups.getText();
        if (!Principal.txtNo.getText().isEmpty()) {
            JDProcedimientoTiempoServicio jifprocedimientoTiempoServicio = new JDProcedimientoTiempoServicio(null, true, Principal.txtNo.getText(), this.JTFNombre.getText(), "TIEMPO POR PROCEDIMIENTO");
            jifprocedimientoTiempoServicio.setLocationRelativeTo(null);
            jifprocedimientoTiempoServicio.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "Verificar", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoCupsActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTFInalidadActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.claseparametrizacionn.cargarPantalla("Procedimiento Tipo Finalidad");
        }
    }

    private void consultarDatosProcedimientos(int filaSeleccionada) {
        this.JCBTipoHC.setSelectedIndex(-1);
        this.JCBClaseCita.setSelectedIndex(-1);
        this.JCBManualTarifa.setSelectedIndex(-1);
        Principal.txtNo.setText(this.xmodelo.getValueAt(filaSeleccionada, 0).toString());
        this.JTFCodigoCups.setText(this.xmodelo.getValueAt(filaSeleccionada, 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(filaSeleccionada, 1).toString());
        this.JCBTipoProcedimiento.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 2).toString());
        this.JCBTipoPrcRips.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 3).toString());
        this.JCBFinalidad.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 4).toString());
        this.JCBAgrupacion.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 5).toString());
        this.JSPNivelC.setValue(Integer.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 6).toString()));
        this.JTAPreparacion1.setText(this.xmodelo.getValueAt(filaSeleccionada, 7).toString());
        this.JCBAreaLab.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 8).toString());
        this.JTFAbreviaturaRef.setText(this.xmodelo.getValueAt(filaSeleccionada, 9).toString());
        this.JCHRemitido.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 10).toString()).booleanValue());
        if (this.JCHRemitido.isSelected()) {
            this.xesremitido = 1;
        } else {
            this.xesremitido = 0;
        }
        this.JCBTipoMuestra.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 11).toString());
        this.JCHEstado.setSelected(!Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 12).toString()).booleanValue());
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
        this.JCHEsCita.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 13).toString()).booleanValue());
        if (this.JCHEsCita.isSelected()) {
            this.xescita = 1;
        } else {
            this.xescita = 0;
        }
        this.JCHValidarLab.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 14).toString()).booleanValue());
        if (this.JCHValidarLab.isSelected()) {
            this.xvalidarlab = 1;
        } else {
            this.xvalidarlab = 0;
        }
        this.JCHEsPaquete.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 15).toString()).booleanValue());
        if (this.JCHEsPaquete.isSelected()) {
            this.xespaquete = 1;
        } else {
            this.xespaquete = 0;
        }
        this.JCHGeneraAlerta.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 16).toString()).booleanValue());
        if (this.JCHGeneraAlerta.isSelected()) {
            this.xespaquete = 1;
        } else {
            this.xespaquete = 0;
        }
        this.JCHEsOdontologico.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 17).toString()).booleanValue());
        if (this.JCHEsOdontologico.isSelected()) {
            this.xesodontologico = 1;
        } else {
            this.xesodontologico = 0;
        }
        this.JCHEsPypOdon.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 18).toString()).booleanValue());
        if (this.JCHEsPypOdon.isSelected()) {
            this.xEsPypOdontologico = 1;
        } else {
            this.xEsPypOdontologico = 0;
        }
        this.JTPRequisitosP.setText(this.xmodelo.getValueAt(filaSeleccionada, 19).toString());
        this.JTFTResultado.setText(this.xmodelo.getValueAt(filaSeleccionada, 20).toString());
        this.JBTProcedimientoCosto.setEnabled(true);
        this.JBTProcedimientoTarifa.setEnabled(true);
        this.JBT_ProxEsp.setEnabled(true);
        this.JBSuministro.setEnabled(true);
        this.JBT_CGruposCx.setEnabled(true);
        this.JBT_ProxEsp1.setEnabled(true);
        this.JBTEquipo.setEnabled(true);
        if (this.JCHEsPaquete.isSelected()) {
            this.JBTPaquete.setEnabled(true);
        } else {
            this.JBTPaquete.setEnabled(false);
        }
        this.JBTComplicaciones.setEnabled(true);
        this.JBTConcentimientos.setEnabled(true);
        this.JTPDatosProc.setSelectedIndex(0);
        this.JCBMetodo.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 21).toString());
        this.JSPNOrdenI.setValue(Integer.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 22).toString()));
        this.JTPDescripcion1.setText(this.xmodelo.getValueAt(filaSeleccionada, 23).toString());
        this.JCHEsPrioritario.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 24).toString()).booleanValue());
        if (this.JCHEsPrioritario.isSelected()) {
            this.xesprioritario = 1;
        } else {
            this.xesprioritario = 0;
        }
        this.JSPNDias.setValue(Integer.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 25).toString()));
        this.JCBTubo.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 26).toString());
        this.JTFCReal.setText(this.xmodelo.getValueAt(filaSeleccionada, 27).toString());
        this.JTFCHomologado.setText(this.xmodelo.getValueAt(filaSeleccionada, 28).toString());
        this.JSPEdadI.setValue(Integer.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 29).toString()));
        this.JSPEdadM.setValue(Integer.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 30).toString()));
        if (null == this.xmodelo.getValueAt(filaSeleccionada, 31).toString()) {
            this.JCBSexo.setSelectedIndex(2);
        } else {
            switch (this.xmodelo.getValueAt(filaSeleccionada, 31).toString()) {
                case "A":
                    this.JCBSexo.setSelectedIndex(0);
                    break;
                case "F":
                    this.JCBSexo.setSelectedIndex(1);
                    break;
                default:
                    this.JCBSexo.setSelectedIndex(2);
                    break;
            }
        }
        this.JCHEsAProcEnfer.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 32).toString()).booleanValue());
        if (this.JCHEsAProcEnfer.isSelected()) {
            this.xesAProcEnfer = 1;
        } else {
            this.xesAProcEnfer = 0;
        }
        this.JTFCPersonalizado.setText(this.xmodelo.getValueAt(filaSeleccionada, 33).toString());
        this.JFTFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 34).toString()));
        switch (Integer.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 35).toString()).intValue()) {
            case 0:
                this.xtipov = 0;
                this.JRBGrupo.setSelected(true);
                JRBGrupoActionPerformed(null);
                break;
            case 1:
                this.xtipov = 1;
                this.JRBFactor.setSelected(true);
                JRBFactorActionPerformed(null);
                break;
            case 2:
                this.xtipov = 2;
                this.JRBUvr.setSelected(true);
                JRBUvrActionPerformed(null);
                break;
            default:
                this.xtipov = 3;
                this.JRBValor.setSelected(true);
                JRBValorActionPerformed(null);
                break;
        }
        this.JCBManualTarifa.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 36).toString());
        this.JCBClaseCita.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 37).toString());
        this.JCBTipoHC.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 38).toString());
        this.JCHEsAgenda.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 39).toString()).booleanValue());
        if (this.JCHEsAgenda.isSelected()) {
            this.xesagenda = 1;
        } else {
            this.xesagenda = 0;
        }
        this.JCBPerfiles.setSelectedItem(this.xmodelo.getValueAt(filaSeleccionada, 40).toString());
        this.JTFNombreSoat.setText(this.xmodelo.getValueAt(filaSeleccionada, 41).toString());
        this.JSPImpuesto.setValue(Float.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 42).toString()));
        this.JTFLIS.setText(this.xmodelo.getValueAt(filaSeleccionada, 43).toString());
        this.JCHEsASeguimiento.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 44).toString()).booleanValue());
        if (this.JCHEsASeguimiento.isSelected()) {
            this.esSeguimiento = 1;
        } else {
            this.esSeguimiento = 0;
        }
        this.JCHEsCitologia.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 45).toString()).booleanValue());
        if (this.JCHEsCitologia.isSelected()) {
            this.esCitologia = 1;
        } else {
            this.esCitologia = 0;
        }
        System.err.println("correo" + Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 46).toString()));
        this.JCHEsCorreo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(filaSeleccionada, 46).toString()).booleanValue());
        if (this.JCHEsCorreo.isSelected()) {
            this.esCorreo = 1;
        } else {
            this.esCorreo = 0;
        }
        mCargarDatosTablaC();
    }

    private void mExportar() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 1, "Id"));
                    sheet.addCell(new Label(1, 1, "Nombre Procedimiento"));
                    sheet.addCell(new Label(2, 1, "Tipo Procedimiento"));
                    sheet.addCell(new Label(3, 1, "Tipo Procedimiento Rips"));
                    sheet.addCell(new Label(4, 1, "Fin Procedimiento Rips"));
                    sheet.addCell(new Label(5, 1, "Concepto Agrupación Rips"));
                    sheet.addCell(new Label(6, 1, "Nivel"));
                    sheet.addCell(new Label(7, 1, "Preparación"));
                    sheet.addCell(new Label(8, 1, "Area"));
                    sheet.addCell(new Label(9, 1, "Ref"));
                    sheet.addCell(new Label(10, 1, "Es Remitido"));
                    sheet.addCell(new Label(11, 1, "Tipo Muestra"));
                    sheet.addCell(new Label(12, 1, "Estado"));
                    sheet.addCell(new Label(13, 1, "Es Ctia"));
                    sheet.addCell(new Label(14, 1, "ValidarLab"));
                    sheet.addCell(new Label(15, 1, "Paquete"));
                    sheet.addCell(new Label(16, 1, "Alerta"));
                    sheet.addCell(new Label(17, 1, "EsOdontologico"));
                    sheet.addCell(new Label(18, 1, "PyPodonto"));
                    sheet.addCell(new Label(19, 1, "RequisitosP"));
                    sheet.addCell(new Label(20, 1, "Oportunidad"));
                    sheet.addCell(new Label(21, 1, "Perfil"));
                    sheet.addCell(new Label(22, 1, "NOrdenI"));
                    sheet.addCell(new Label(23, 1, "DatosPlanilla"));
                    int y = 2;
                    for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                        sheet.addCell(new Number(0, y, Integer.valueOf(this.xmodelo.getValueAt(x, 0).toString()).intValue()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x, 5).toString()));
                        sheet.addCell(new Number(6, y, Integer.valueOf(this.xmodelo.getValueAt(x, 6).toString()).intValue()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x, 9).toString()));
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 10).toString()).booleanValue()) {
                            sheet.addCell(new Number(10, y, 1.0d));
                        } else {
                            sheet.addCell(new Number(10, y, 0.0d));
                        }
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x, 11).toString()));
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 12).toString()).booleanValue()) {
                            sheet.addCell(new Number(12, y, 1.0d));
                        } else {
                            sheet.addCell(new Number(12, y, 0.0d));
                        }
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 13).toString()).booleanValue()) {
                            sheet.addCell(new Number(13, y, 1.0d));
                        } else {
                            sheet.addCell(new Number(13, y, 0.0d));
                        }
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 14).toString()).booleanValue()) {
                            sheet.addCell(new Number(14, y, 1.0d));
                        } else {
                            sheet.addCell(new Number(14, y, 0.0d));
                        }
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 15).toString()).booleanValue()) {
                            sheet.addCell(new Number(15, y, 1.0d));
                        } else {
                            sheet.addCell(new Number(15, y, 0.0d));
                        }
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 16).toString()).booleanValue()) {
                            sheet.addCell(new Number(16, y, 1.0d));
                        } else {
                            sheet.addCell(new Number(16, y, 0.0d));
                        }
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 17).toString()).booleanValue()) {
                            sheet.addCell(new Number(17, y, 1.0d));
                        } else {
                            sheet.addCell(new Number(17, y, 0.0d));
                        }
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 18).toString()).booleanValue()) {
                            sheet.addCell(new Number(18, y, 1.0d));
                        } else {
                            sheet.addCell(new Number(18, y, 0.0d));
                        }
                        sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x, 19).toString()));
                        sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x, 20).toString()));
                        sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x, 21).toString()));
                        sheet.addCell(new Number(22, y, Integer.valueOf(this.xmodelo.getValueAt(x, 22).toString()).intValue()));
                        sheet.addCell(new Label(23, y, this.xmodelo.getValueAt(x, 23).toString()));
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (WriteException e) {
                    Logger.getLogger(JIFFProcedimiento.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (IOException ex) {
                    Logger.getLogger(JIFFProcedimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    private void mCargarC() {
        if (!this.JTFNombreBusqueda.getText().isEmpty()) {
            if (this.xtipobusqueda == 0) {
                this.xsql = "SELECT g_procedimiento.id, g_procedimiento.Nbre, f_tipoprocedimiento.Nbre, f_tipoprocrips.Nbre, f_tipofinprocedimiento.Nbre, f_tipoconceptoagrup.Nbre, g_procedimiento.NivelComplejidad,IF(g_procedimiento.Preparacion IS NULL, '',g_procedimiento.Preparacion) AS preparacion \n, l_areas.Nbre, g_procedimiento.Ref, g_procedimiento.EsRemitido, l_tipomuestra.Nbre, g_procedimiento.Estado, g_procedimiento.EsCita, g_procedimiento.ValidarLab, g_procedimiento.Paquete, g_procedimiento.Alerta, g_procedimiento.EsOdontologico,g_procedimiento.PyPodonto , IF(g_procedimiento.RPrevios IS NULL,'', g_procedimiento.RPrevios) AS RequisitosP, g_procedimiento.Oportunidad, l_tipo_metodo.Nbre , g_procedimiento.NOrdenI, IF(g_procedimiento.VariablesL IS NULL,'',g_procedimiento.VariablesL) AS VariableL, g_procedimiento.Es_Prioritario,  g_procedimiento.NDiasR, `l_tipo_tubo`.`Nbre`,g_procedimiento.C_Real,g_procedimiento.C_Homologado, g_procedimiento.EdadI, g_procedimiento.EdadM, g_procedimiento.Sexo, g_procedimiento.AProcEnfer,\nIFNULL(`g_procedimiento`.`C_Personalizado`,'') AS C_Personalizado, `g_procedimiento`.`GFUV`, `g_procedimiento`.`Tipo_V`, IFNULL(`g_tipo_manual_tarifas`.`Nbre`,'') AS `ManualTarifa`, IFNULL(`c_clasecita`.`Nbre`,'') AS `ClaseCita`\n, IFNULL(`h_tipohistoria`.`Nbre`,'') AS `TipoHC`, `g_procedimiento`.`EsAgenda`, `l_perfiles`.`Nbre` AS `Perfil`, `g_procedimiento`.`Nbre_Soat`, `g_procedimiento`.`porcentajeImpuesto`, `g_procedimiento`.`lis`, `g_procedimiento`.`Seguimiento`\n, g_procedimiento.`esCitologia`, g_procedimiento.exportablePorCorreo FROM g_procedimiento INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tipoprocrips  \nON (g_procedimiento.Id_TipoProcRIPS = f_tipoprocrips.Id) INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) INNER JOIN f_tipoconceptoagrup  \nON (g_procedimiento.Id_TipoConceptoAgrup = f_tipoconceptoagrup.Id) INNER JOIN l_areas  ON (l_areas.Id = g_procedimiento.Id_Area) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) INNER JOIN l_tipo_metodo ON (g_procedimiento.Id_TipoMetodo = l_tipo_metodo.Id) INNER JOIN `l_tipo_tubo` ON (`l_tipo_tubo`.`Id` = `g_procedimiento`.`Id_Tubo`)\nLEFT JOIN `g_tipo_manual_tarifas` ON (`g_procedimiento`.`Id_Manual_Tarifas` = `g_tipo_manual_tarifas`.`Id`) LEFT JOIN `c_clasecita` ON (`g_procedimiento`.`IdClaseCita` = `c_clasecita`.`Id`)\nLEFT JOIN `h_tipohistoria` ON (`g_procedimiento`.`Id_Hc` = `h_tipohistoria`.`Id`)LEFT JOIN `l_perfiles` ON (`g_procedimiento`.`Id_lPerfiles` = `l_perfiles`.`Id`)\nWHERE (g_procedimiento.Nbre LIKE '" + this.JTFNombreBusqueda.getText() + "%' or g_procedimiento.Id LIKE '" + this.JTFNombreBusqueda.getText() + "%') ORDER BY f_tipoprocedimiento.Nbre ASC, g_procedimiento.Nbre ASC";
            } else {
                this.xsql = "SELECT g_procedimiento.id, g_procedimiento.Nbre, f_tipoprocedimiento.Nbre, f_tipoprocrips.Nbre, f_tipofinprocedimiento.Nbre, f_tipoconceptoagrup.Nbre, g_procedimiento.NivelComplejidad,IF(g_procedimiento.Preparacion IS NULL, '',g_procedimiento.Preparacion) AS preparacion \n, l_areas.Nbre, g_procedimiento.Ref, g_procedimiento.EsRemitido, l_tipomuestra.Nbre, g_procedimiento.Estado, g_procedimiento.EsCita, g_procedimiento.ValidarLab, g_procedimiento.Paquete, g_procedimiento.Alerta, g_procedimiento.EsOdontologico,g_procedimiento.PyPodonto , IF(g_procedimiento.RPrevios IS NULL,'', g_procedimiento.RPrevios) AS RequisitosP, g_procedimiento.Oportunidad, l_tipo_metodo.Nbre , g_procedimiento.NOrdenI, IF(g_procedimiento.VariablesL IS NULL,'',g_procedimiento.VariablesL) AS VariableL, g_procedimiento.Es_Prioritario,  g_procedimiento.NDiasR, `l_tipo_tubo`.`Nbre`,g_procedimiento.C_Real,g_procedimiento.C_Homologado, g_procedimiento.EdadI, g_procedimiento.EdadM, g_procedimiento.Sexo, g_procedimiento.AProcEnfer,\nIFNULL(`g_procedimiento`.`C_Personalizado`,'') AS C_Personalizado, `g_procedimiento`.`GFUV`, `g_procedimiento`.`Tipo_V`, IFNULL(`g_tipo_manual_tarifas`.`Nbre`,'') AS `ManualTarifa`, IFNULL(`c_clasecita`.`Nbre`,'') AS `ClaseCita`\n, IFNULL(`h_tipohistoria`.`Nbre`,'') AS `TipoHC`, `g_procedimiento`.`EsAgenda`, `l_perfiles`.`Nbre` AS `Perfil`, `g_procedimiento`.`Nbre_Soat`, `g_procedimiento`.`porcentajeImpuesto`, `g_procedimiento`.`lis`, `g_procedimiento`.`Seguimiento`\n, g_procedimiento.`esCitologia`, g_procedimiento.exportablePorCorreo FROM g_procedimiento INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tipoprocrips  \nON (g_procedimiento.Id_TipoProcRIPS = f_tipoprocrips.Id) INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id) INNER JOIN f_tipoconceptoagrup  \nON (g_procedimiento.Id_TipoConceptoAgrup = f_tipoconceptoagrup.Id) INNER JOIN l_areas  ON (l_areas.Id = g_procedimiento.Id_Area) INNER JOIN l_tipomuestra  ON (g_procedimiento.Id_TipoMuestra = l_tipomuestra.Id) INNER JOIN l_tipo_metodo ON (g_procedimiento.Id_TipoMetodo = l_tipo_metodo.Id) INNER JOIN `l_tipo_tubo` ON (`l_tipo_tubo`.`Id` = `g_procedimiento`.`Id_Tubo`)\nLEFT JOIN `g_tipo_manual_tarifas` ON (`g_procedimiento`.`Id_Manual_Tarifas` = `g_tipo_manual_tarifas`.`Id`) LEFT JOIN `c_clasecita` ON (`g_procedimiento`.`IdClaseCita` = `c_clasecita`.`Id`)\nLEFT JOIN `h_tipohistoria` ON (`g_procedimiento`.`Id_Hc` = `h_tipohistoria`.`Id`)LEFT JOIN `l_perfiles` ON (`g_procedimiento`.`Id_lPerfiles` = `l_perfiles`.`Id`)\nWHERE (g_procedimiento.Nbre LIKE '%" + this.JTFNombreBusqueda.getText() + "%' or g_procedimiento.Id LIKE '%" + this.JTFNombreBusqueda.getText() + "%' ) ORDER BY f_tipoprocedimiento.Nbre ASC, g_procedimiento.Nbre ASC";
            }
            System.err.println("sql" + this.xsql);
            mCargarDatosTabla(this.xsql);
            return;
        }
        mCrearModeloDatos();
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JTFNombreSoat.setText("");
        this.JTFCReal.setText("");
        this.JTFCHomologado.setText("");
        this.JFTFValor.setText("0");
        this.JTFCPersonalizado.setText("");
        this.JCBTipoProcedimiento.setSelectedIndex(-1);
        this.JCBTipoPrcRips.setSelectedIndex(-1);
        this.JCBAgrupacion.setSelectedIndex(-1);
        this.JCBFinalidad.setSelectedIndex(-1);
        this.JCBAgrupacion.setSelectedIndex(-1);
        this.JCBAreaLab.setSelectedIndex(0);
        this.JCBTipoHC.setSelectedIndex(-1);
        this.JCBClaseCita.setSelectedIndex(-1);
        this.JCBManualTarifa.setSelectedIndex(-1);
        this.JCBPerfiles.setSelectedIndex(-1);
        this.JTFAbreviaturaRef.setText("");
        this.JTAPreparacion1.setText("");
        this.JTPRequisitosP.setText("");
        this.JTFLIS.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 0;
        this.xesremitido = 0;
        this.xescita = 0;
        this.xvalidarlab = 0;
        this.xgeneraalerta = 0;
        this.xesodontologico = 0;
        this.xEsPypOdontologico = 0;
        this.xesAProcEnfer = 0;
        this.xesagenda = 0;
        this.esSeguimiento = 0;
        this.JCHEsASeguimiento.setSelected(false);
        this.JCHEsCitologia.setSelected(false);
        this.xtipov = 0;
        this.JRBGrupo.setSelected(true);
        this.JCHEsAgenda.setSelected(false);
        this.JCHEsAProcEnfer.setSelected(false);
        this.JCHEsPypOdon.setSelected(false);
        this.JCHEsOdontologico.setSelected(false);
        this.JCHGeneraAlerta.setSelected(false);
        this.JCHRemitido.setSelected(false);
        this.JCHEsCita.setSelected(false);
        this.JCHValidarLab.setSelected(false);
        this.JTFNombreBusqueda.setText("");
        this.JTFTResultado.setText("");
        this.JCBMetodo.setSelectedIndex(-1);
        this.JSPNOrdenI.setValue(new Integer(0));
        this.JSPNDias.setValue(new Integer(0));
        this.JTFNombre.requestFocus();
        this.JTPDescripcion.setText("");
        this.JTPDescripcion1.setText("");
        this.JSPNOrden.setValue(new Integer(0));
        this.xidcometario = 0L;
        this.JCBSexo.setSelectedIndex(-1);
        this.JSPEdadI.setValue(new Integer(0));
        this.JSPEdadM.setValue(new Integer(0));
        this.JSPImpuesto.setValue(new Float(0.0f));
        this.JCHEsCorreo.setSelected(true);
        mCrearModeloDatos();
        mCrearModeloDatosC();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBTipoProcedimiento.getSelectedIndex() != -1) {
                if (this.JCBTipoPrcRips.getSelectedIndex() != -1) {
                    if (this.JCBFinalidad.getSelectedIndex() != -1) {
                        if (this.JCBAgrupacion.getSelectedIndex() != -1) {
                            if (this.JCBMetodo.getSelectedIndex() != -1) {
                                if (this.JCBSexo.getSelectedIndex() != -1) {
                                    if (this.JCBPerfiles.getSelectedIndex() != -1) {
                                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                        if (n == 0) {
                                            if (this.JCBTipoHC.getSelectedIndex() != -1) {
                                                this.xtipoHC = Integer.valueOf(this.xidHC[this.JCBTipoHC.getSelectedIndex()]).intValue();
                                            } else {
                                                this.xtipoHC = 0;
                                            }
                                            if (this.JCBClaseCita.getSelectedIndex() != -1) {
                                                this.xtipoCita = Integer.valueOf(this.xidclasecita[this.JCBClaseCita.getSelectedIndex()]).intValue();
                                            } else {
                                                this.xtipoCita = 0;
                                            }
                                            if (this.JCBManualTarifa.getSelectedIndex() != -1) {
                                                this.xtipomanual = Integer.valueOf(this.xidmanualtarifas[this.JCBManualTarifa.getSelectedIndex()]).intValue();
                                            } else {
                                                this.xtipomanual = 0;
                                            }
                                            if (Principal.txtNo.getText().isEmpty()) {
                                                String sql = " Insert into g_procedimiento(Id, Nbre, Id_tipoprocedimiento, Id_TipoProcRIPS, Id_TipoFinProced, Id_TipoConceptoAgrup, NivelComplejidad, Preparacion, Id_Area, Ref, EsRemitido, Id_TipoMuestra, Estado, EsCita, ValidarLab, Paquete, Alerta, EsOdontologico, PyPodonto, RPrevios, Oportunidad, Id_TipoMetodo, NOrdenI, VariablesL, Es_Prioritario, NDiasR, Id_Tubo,C_Real,C_Homologado, EdadI, EdadM, Sexo, AProcEnfer,C_Personalizado,GFUV, Tipo_V, Id_Manual_Tarifas, IdClaseCita,Id_Hc, EsAgenda, Id_lPerfiles, Nbre_Soat, porcentajeImpuesto, lis, Seguimiento, Fecha, esCitologia, exportablePorCorreo, UsuarioS)  values ('" + this.JTFCodigoCups.getText() + "','" + this.JTFNombre.getText() + "','" + this.xidtipoproc[this.JCBTipoProcedimiento.getSelectedIndex()] + "','" + this.xidtipoprocrips[this.JCBTipoPrcRips.getSelectedIndex()] + "','" + this.xidtipofinalidad[this.JCBFinalidad.getSelectedIndex()] + "','" + this.xidtipoagrupacion[this.JCBAgrupacion.getSelectedIndex()] + "','" + this.JSPNivelC.getValue() + "','" + this.JTAPreparacion1.getText() + "','" + this.xidarea[this.JCBAreaLab.getSelectedIndex()] + "','" + this.JTFAbreviaturaRef.getText() + "','" + this.xesremitido + "','" + this.xidtipomuestra[this.JCBTipoMuestra.getSelectedIndex()] + "','" + this.xestado + "','" + this.xescita + "','" + this.xvalidarlab + "','" + this.xespaquete + "','" + this.xgeneraalerta + "','" + this.xesodontologico + "','" + this.xEsPypOdontologico + "','" + this.JTPRequisitosP.getText() + "','" + this.JTFTResultado.getText() + "','" + this.xidmetodo[this.JCBMetodo.getSelectedIndex()] + "','" + this.JSPNOrdenI.getValue() + "','" + this.JTPDescripcion1.getText() + "','" + this.xesprioritario + "','" + this.JSPNDias.getValue() + "','" + this.xtipotubo[this.JCBTubo.getSelectedIndex()] + "','" + this.JTFCReal.getText() + "','" + this.JTFCHomologado.getText() + "','" + this.JSPEdadI.getValue() + "','" + this.JSPEdadM.getValue() + "','" + this.xsexo + "','" + this.xesAProcEnfer + "','" + this.JTFCPersonalizado.getText() + "','" + this.JFTFValor.getText() + "','" + this.xtipov + "','" + this.xtipomanual + "','" + this.xtipoCita + "','" + this.xtipoHC + "','" + this.xesagenda + "','" + this.xidperfil[this.JCBPerfiles.getSelectedIndex()] + "','" + this.JTFNombreSoat.getText() + "','" + this.JSPImpuesto.getValue() + "','" + this.JTFLIS.getText() + "','" + this.esSeguimiento + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.esCitologia + "','" + this.esCorreo + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                                Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                                                System.out.println(sql);
                                                this.xconsulta.cerrarConexionBd();
                                            } else {
                                                String sql2 = " update g_procedimiento set Nbre='" + this.JTFNombre.getText() + "',Id_tipoprocedimiento='" + this.xidtipoproc[this.JCBTipoProcedimiento.getSelectedIndex()] + "',Id_TipoProcRIPS='" + this.xidtipoprocrips[this.JCBTipoPrcRips.getSelectedIndex()] + "', Id_TipoFinProced='" + this.xidtipofinalidad[this.JCBFinalidad.getSelectedIndex()] + "',Id_TipoConceptoAgrup='" + this.xidtipoagrupacion[this.JCBAgrupacion.getSelectedIndex()] + "', NivelComplejidad='" + this.JSPNivelC.getValue() + "',Preparacion='" + this.JTAPreparacion1.getText() + "', Id_Area='" + this.xidarea[this.JCBAreaLab.getSelectedIndex()] + "',Ref='" + this.JTFAbreviaturaRef.getText() + "', EsRemitido='" + this.xesremitido + "',Id_TipoMuestra='" + this.xidtipomuestra[this.JCBTipoMuestra.getSelectedIndex()] + "',Estado='" + this.xestado + "',EsCita='" + this.xescita + "',ValidarLab='" + this.xvalidarlab + "',Paquete='" + this.xespaquete + "',Alerta='" + this.xgeneraalerta + "',EsOdontologico='" + this.xesodontologico + "',PyPodonto='" + this.xEsPypOdontologico + "',RPrevios='" + this.JTPRequisitosP.getText() + "',Oportunidad='" + this.JTFTResultado.getText() + "',Id_TipoMetodo ='" + this.xidmetodo[this.JCBMetodo.getSelectedIndex()] + "',NOrdenI='" + this.JSPNOrdenI.getValue() + "',VariablesL='" + this.JTPDescripcion1.getText() + "',Es_Prioritario='" + this.xesprioritario + "',Id_Tubo='" + this.xtipotubo[this.JCBTubo.getSelectedIndex()] + "',NDiasR='" + this.JSPNDias.getValue() + "',C_Real='" + this.JTFCReal.getText() + "',C_Homologado='" + this.JTFCHomologado.getText() + "',EdadI='" + this.JSPEdadI.getValue() + "',EdadM='" + this.JSPEdadM.getValue() + "',Sexo='" + this.xsexo + "',AProcEnfer='" + this.xesAProcEnfer + "',C_Personalizado='" + this.JTFCPersonalizado.getText() + "',GFUV='" + this.JFTFValor.getText() + "',Tipo_V='" + this.xtipov + "',Id_Manual_Tarifas='" + this.xtipomanual + "',IdClaseCita='" + this.xtipoCita + "',Id_Hc='" + this.xtipoHC + "',EsAgenda='" + this.xesagenda + "',Id_lPerfiles='" + this.xidperfil[this.JCBPerfiles.getSelectedIndex()] + "',Nbre_Soat='" + this.JTFNombreSoat.getText() + "',porcentajeImpuesto='" + this.JSPImpuesto.getValue() + "',lis='" + this.JTFLIS.getText() + "',Seguimiento='" + this.esSeguimiento + "',esCitologia='" + this.esCitologia + "',exportablePorCorreo='" + this.esCorreo + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                                                System.out.println(sql2);
                                                this.xconsulta.ejecutarSQL(sql2);
                                                this.xconsulta.cerrarConexionBd();
                                            }
                                        }
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un perfil", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JPIProcedimientoTab.setSelectedIndex(0);
                                        this.JCBPerfiles.requestFocus();
                                    }
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el sexo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JPIProcedimientoTab.setSelectedIndex(0);
                                    this.JCBSexo.requestFocus();
                                }
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un metodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JPIProcedimientoTab.setSelectedIndex(0);
                                this.JCBMetodo.requestFocus();
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de agrupación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JPIProcedimientoTab.setSelectedIndex(0);
                            this.JCBAgrupacion.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una finalidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JPIProcedimientoTab.setSelectedIndex(0);
                        this.JCBFinalidad.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de procedimiento rips", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JPIProcedimientoTab.setSelectedIndex(0);
                    this.JCBTipoPrcRips.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JPIProcedimientoTab.setSelectedIndex(0);
                this.JCBTipoProcedimiento.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JPIProcedimientoTab.setSelectedIndex(0);
            this.JTFNombre.requestFocus();
        }
        mCargarC();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre Procedimiento", "Tipo Procedimiento", "Tipo Procedimiento Rips", "Fin Procedimiento Rips", "Concepto Agrupación Rips", "Nivel", "Preparación", "Area", "Ref", "Es Remitido?", "Tipo Muestra", "Estado", "Es Ctia", "ValidarLab", "Paquete", "Alerta", "EsOdontologico", "EsPypOdonto", "RequisitosP", "Oportunidad", "Perfil", "NOrdenI", "DatosPlanilla", "Es_Prioritario", "NDias", "Tipo Tubo", "C_Real", "C_Homologado", "EdadI", "EdadM", "Sexo", "AProcEnfer", "C_Personalizado", "GFUV", "Tipo_V", "Id_Manual_Tarifas", "IdClaseCita", "Id_Hc", "EsAgenda", "Id_lPerfiles", "Nbre_Soat", "% Impuesto", "LIS", "Seguimiento", "EsCitologia", "EsCitologia"}) { // from class: ParametrizacionN.JIFFProcedimiento.54
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Boolean.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class, String.class, String.class, Long.class, String.class, Boolean.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, Boolean.class, String.class, Double.class, Integer.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, Double.class, String.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosC() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Comentario", "Equipo", "NOrden", "Estado"}) { // from class: ParametrizacionN.JIFFProcedimiento.55
            Class[] types = {Long.class, String.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            System.out.println(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(11)), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(13)), n, 12);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(14)), n, 13);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(15)), n, 14);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(16)), n, 15);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(17)), n, 16);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(18)), n, 17);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(19)), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(23)), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 23);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(25)), n, 24);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(26)), n, 25);
                    this.xmodelo.setValueAt(xrs.getString(27), n, 26);
                    this.xmodelo.setValueAt(xrs.getString(28), n, 27);
                    this.xmodelo.setValueAt(xrs.getString(29), n, 28);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(30)), n, 29);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(31)), n, 30);
                    this.xmodelo.setValueAt(xrs.getString(32), n, 31);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(33)), n, 32);
                    this.xmodelo.setValueAt(xrs.getString(34), n, 33);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(35)), n, 34);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(36)), n, 35);
                    this.xmodelo.setValueAt(xrs.getString(37), n, 36);
                    this.xmodelo.setValueAt(xrs.getString(38), n, 37);
                    this.xmodelo.setValueAt(xrs.getString(39), n, 38);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(40)), n, 39);
                    this.xmodelo.setValueAt(xrs.getString(41), n, 40);
                    this.xmodelo.setValueAt(xrs.getString(42), n, 41);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(43)), n, 42);
                    this.xmodelo.setValueAt(xrs.getString(44), n, 43);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(45)), n, 44);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(46)), n, 45);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(47)), n, 46);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSubGrupoFactur.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaC() {
        try {
            mCrearModeloDatosC();
            this.xsql = "SELECT\n\tgpc.Id,\n\tgpc.Descripcion,\n\tlta.nombre as Equipo,\n\tgpc.Orden,\n\tgpc.Estado\nFROM\n\tg_procedimiento_comentario gpc\nINNER JOIN l_tipo_analizador lta ON\n\tgpc.IdEquipo = lta.id\nWHERE\n\tgpc.Id_Procedimiento = " + Principal.txtNo.getText() + "\nORDER BY\n\tgpc.Orden ASC";
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSubGrupoFactur.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xidtipoproc = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_tipoprocedimiento WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoproc, this.JCBTipoProcedimiento);
        this.JCBTipoProcedimiento.setSelectedIndex(-1);
        this.xidtipoprocrips = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_tipoprocrips WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoprocrips, this.JCBTipoPrcRips);
        this.JCBTipoPrcRips.setSelectedIndex(-1);
        this.xidtipofinalidad = this.xconsulta.llenarCombo("SELECT Id , Nbre FROM f_tipofinprocedimiento ORDER BY Nbre ASC", this.xidtipofinalidad, this.JCBFinalidad);
        this.JCBFinalidad.setSelectedIndex(-1);
        this.xidtipoagrupacion = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_tipoconceptoagrup WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoagrupacion, this.JCBAgrupacion);
        this.JCBAgrupacion.setSelectedIndex(-1);
        this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM l_areas WHERE (Estado =0) ORDER BY Nbre ASC", this.xidarea, this.JCBAreaLab);
        this.JCBAreaLab.setSelectedIndex(0);
        this.xidtipomuestra = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM l_tipomuestra WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipomuestra, this.JCBTipoMuestra);
        this.JCBTipoMuestra.setSelectedIndex(2);
        this.xidmetodo = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM l_tipo_metodo WHERE (Estado =1) ORDER BY Nbre ASC", this.xidmetodo, this.JCBMetodo);
        this.JCBMetodo.setSelectedItem("NO APLICA");
        this.xtipotubo = this.xconsulta.llenarCombo("SELECT`Id` , `Nbre` FROM `l_tipo_tubo` ORDER BY `Nbre` ASC", this.xtipotubo, this.JCBTubo);
        this.JCBTubo.setSelectedItem("N/A");
        this.JCBSexo.setSelectedIndex(-1);
        this.xidperfil = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM l_perfiles WHERE (Estado =1) ORDER BY Nbre ASC", this.xidperfil, this.JCBPerfiles);
        this.JCBPerfiles.setSelectedItem("N/A");
        this.xidHC = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM `h_tipohistoria` WHERE (Estado =0) ORDER BY Nbre ASC", this.xidHC, this.JCBTipoHC);
        this.JCBTipoHC.setSelectedIndex(-1);
        this.xidclasecita = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM `c_clasecita` WHERE (Estado =0) ORDER BY Nbre ASC", this.xidclasecita, this.JCBClaseCita);
        this.JCBClaseCita.setSelectedIndex(-1);
        this.xidmanualtarifas = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM `g_tipo_manual_tarifas` WHERE (Estado =1) ORDER BY Nbre ASC", this.xidmanualtarifas, this.JCBManualTarifa);
        this.JCBManualTarifa.setSelectedIndex(-1);
        this.xIdTipoEquipo = this.xconsulta.llenarCombo("SELECT lta.id, lta.nombre FROM l_tipo_analizador lta WHERE lta.estado =1 ORDER BY lta.nombre ASC", this.xIdTipoEquipo, this.JCBTipoEquipo);
        this.JCBTipoEquipo.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCrearModeloDatos();
        mCrearModeloDatosC();
    }
}
