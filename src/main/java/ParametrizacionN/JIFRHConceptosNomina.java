package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
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
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFRHConceptosNomina.class */
public class JIFRHConceptosNomina extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String[] xidunidadfc;
    private String[] xId_Clasificacion;
    private String[] xIdClasificacionCGR;
    private String[] xId_ClasificacionNominaE;
    private String xsql;
    private String xnombremaestro;
    private String xnombrecorto;
    private String xCodigo;
    private double xValorBase;
    private double xValorBaseN;
    private double xValor;
    private double xValorE;
    static String xid;
    private ButtonGroup JBGFcalculo;
    private ButtonGroup JBG_BUtilizar;
    private ButtonGroup JBG_CSalarial;
    private ButtonGroup JBG_FUtilizacion;
    private JButton JBTAdicionarUF;
    private JComboBox JCBClasificacionCGR;
    private JComboBox JCBClasificacionNominaE;
    private JComboBox JCBUnidadFc;
    private JComboBox JCB_Clasificacion;
    private JCheckBox JCHBInicializar;
    private JCheckBox JCHCBase;
    private JCheckBox JCHCBase1;
    private JCheckBox JCHCSSalario;
    private JCheckBox JCHEsDeduccion;
    private JCheckBox JCHEsFijo;
    private JCheckBox JCHEsIBC;
    private JCheckBox JCHEsIncapacidad;
    private JCheckBox JCHEsReporte;
    private JCheckBox JCHEsSalario;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstadoUfc;
    private JCheckBox JCHMTercero;
    private JPanel JPIDatos;
    private JPanel JPIFCalculo;
    private JPanel JPIHistorico;
    private JPanel JPIUnidadF;
    private JPanel JPI_FUtilizacion;
    private JPanel JPI_FUtilizacion1;
    private JRadioButton JRBDesde;
    private JRadioButton JRBFCDias;
    private JRadioButton JRBFCNoAplica;
    private JRadioButton JRBFCPorcentaje;
    private JRadioButton JRBFCVfijo;
    private JRadioButton JRBHasta;
    private JRadioButton JRBNoAplica;
    private JRadioButton JRB_BU_CBase;
    private JRadioButton JRB_BU_IBC;
    private JRadioButton JRB_BU_NoAplica;
    private JRadioButton JRB_FU_Ambos;
    private JRadioButton JRB_FU_Empleado;
    private JRadioButton JRB_FU_Empleador;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    public JFormattedTextField JSPFCValor;
    public JFormattedTextField JSPFCValor1;
    private JSpinner JSPFPorcentajeDian;
    private JSpinner JSPOrden;
    private JSpinner JSPRedondeo;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTextField JTFCodigo;
    private JTextField JTFCredito;
    private JTextField JTFDebito;
    private JFormattedTextField JTFFTopeSalarial;
    private JFormattedTextField JTFFValorBase;
    private JFormattedTextField JTFFValorBaseN;
    private JTextField JTFF_Nombre;
    private JTextField JTFNombre;
    private JTextField JTFNombreCorto;
    private JTextField JTFRCuentaC;
    private JTextField JTFRCuentaD;
    private JTextField JTFRPresupuesto;
    private JTextField JTFRRubro;
    private JTabbedPane JTPDatosB;
    private JTabbedPane JTPMenu;
    private JButton jButton1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xcbase1 = 0;
    private int xestado = 1;
    private int xescontable = 1;
    private int xtipocalculo = 1;
    private int xesdeducion = 0;
    private int xesreporte = 0;
    private int xessalario = 0;
    private int xestadouf = 1;
    private int xcbase = 0;
    private int xmtercero = 0;
    private int xcssalario = 0;
    private int xUF_Utilizacion = 0;
    private int xincapacidad = 0;
    private int xesbinicializar = 0;
    private int xesfijo = 0;
    private int xUB_Utilizacion = -1;
    private int xesibc = 0;
    private int identificadorTope = -1;
    private boolean xgrabarufc = false;
    private DecimalFormat formato1 = new DecimalFormat("#.00000");

    public JIFRHConceptosNomina() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v295, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFcalculo = new ButtonGroup();
        this.JBG_FUtilizacion = new ButtonGroup();
        this.JBG_BUtilizar = new ButtonGroup();
        this.JBG_CSalarial = new ButtonGroup();
        this.JTPDatosB = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JPIUnidadF = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JCBUnidadFc = new JComboBox();
        this.JTFDebito = new JTextField();
        this.JTFRCuentaD = new JTextField();
        this.JTFCredito = new JTextField();
        this.JTFRCuentaC = new JTextField();
        this.JTFRPresupuesto = new JTextField();
        this.JTFRRubro = new JTextField();
        this.JCHEstadoUfc = new JCheckBox();
        this.JBTAdicionarUF = new JButton();
        this.JTPMenu = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JPI_FUtilizacion = new JPanel();
        this.JRB_FU_Empleado = new JRadioButton();
        this.JRB_FU_Empleador = new JRadioButton();
        this.JRB_FU_Ambos = new JRadioButton();
        this.JPI_FUtilizacion1 = new JPanel();
        this.JRB_BU_NoAplica = new JRadioButton();
        this.JRB_BU_CBase = new JRadioButton();
        this.JRB_BU_IBC = new JRadioButton();
        this.JTFNombre = new JTextField();
        this.JTFCodigo = new JTextField();
        this.JPIFCalculo = new JPanel();
        this.JRBFCNoAplica = new JRadioButton();
        this.JRBFCPorcentaje = new JRadioButton();
        this.JRBFCDias = new JRadioButton();
        this.JRBFCVfijo = new JRadioButton();
        this.JSPFCValor1 = new JFormattedTextField();
        this.JSPFCValor = new JFormattedTextField();
        this.JSPOrden = new JSpinner();
        this.JTFFValorBase = new JFormattedTextField();
        this.JTFFValorBaseN = new JFormattedTextField();
        this.JTFNombreCorto = new JTextField();
        this.JSPRedondeo = new JSpinner();
        this.JSPFPorcentajeDian = new JSpinner();
        this.jPanel4 = new JPanel();
        this.JCB_Clasificacion = new JComboBox();
        this.JCBClasificacionCGR = new JComboBox();
        this.JCBClasificacionNominaE = new JComboBox();
        this.jPanel5 = new JPanel();
        this.JCHEsSalario = new JCheckBox();
        this.JCHCBase = new JCheckBox();
        this.JCHCBase1 = new JCheckBox();
        this.JCHMTercero = new JCheckBox();
        this.JCHCSSalario = new JCheckBox();
        this.JCHEsIncapacidad = new JCheckBox();
        this.JCHEsIBC = new JCheckBox();
        this.JCHEsDeduccion = new JCheckBox();
        this.JCHEsReporte = new JCheckBox();
        this.JCHBInicializar = new JCheckBox();
        this.JCHEsFijo = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.jPanel3 = new JPanel();
        this.JTFFTopeSalarial = new JFormattedTextField();
        this.JRBNoAplica = new JRadioButton();
        this.JRBDesde = new JRadioButton();
        this.JRBHasta = new JRadioButton();
        this.jButton1 = new JButton();
        this.JPIHistorico = new JPanel();
        this.JTFF_Nombre = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCEPTO NOMINA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconceptonomina");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRHConceptosNomina.this.formInternalFrameClosing(evt);
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
        this.JTPDatosB.setForeground(new Color(0, 103, 0));
        this.JTPDatosB.setFont(new Font("Arial", 1, 14));
        this.JPIUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "UNIDAD FUNCIONAL", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHConceptosNomina.2
            public void mouseClicked(MouseEvent evt) {
                JIFRHConceptosNomina.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JCBUnidadFc.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebito.setFont(new Font("Arial", 1, 12));
        this.JTFDebito.setToolTipText("");
        this.JTFDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebito.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFRHConceptosNomina.3
            public void focusLost(FocusEvent evt) {
                JIFRHConceptosNomina.this.JTFDebitoFocusLost(evt);
            }
        });
        this.JTFDebito.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.4
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JTFDebitoActionPerformed(evt);
            }
        });
        this.JTFRCuentaD.setFont(new Font("Arial", 1, 12));
        this.JTFRCuentaD.setToolTipText("");
        this.JTFRCuentaD.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCredito.setFont(new Font("Arial", 1, 12));
        this.JTFCredito.setToolTipText("");
        this.JTFCredito.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCredito.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.5
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JTFCreditoActionPerformed(evt);
            }
        });
        this.JTFRCuentaC.setFont(new Font("Arial", 1, 12));
        this.JTFRCuentaC.setToolTipText("");
        this.JTFRCuentaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRPresupuesto.setFont(new Font("Arial", 1, 12));
        this.JTFRPresupuesto.setToolTipText("");
        this.JTFRPresupuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro Presupuestal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRPresupuesto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.6
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JTFRPresupuestoActionPerformed(evt);
            }
        });
        this.JTFRRubro.setFont(new Font("Arial", 1, 12));
        this.JTFRRubro.setToolTipText("");
        this.JTFRRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRRubro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.7
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JTFRRubroActionPerformed(evt);
            }
        });
        this.JCHEstadoUfc.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoUfc.setForeground(Color.blue);
        this.JCHEstadoUfc.setSelected(true);
        this.JCHEstadoUfc.setText("Estado");
        this.JCHEstadoUfc.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.8
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHEstadoUfcActionPerformed(evt);
            }
        });
        this.JBTAdicionarUF.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarUF.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarUF.setText("Adicionar");
        this.JBTAdicionarUF.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.9
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JBTAdicionarUFActionPerformed(evt);
            }
        });
        GroupLayout JPIUnidadFLayout = new GroupLayout(this.JPIUnidadF);
        this.JPIUnidadF.setLayout(JPIUnidadFLayout);
        JPIUnidadFLayout.setHorizontalGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUnidadFLayout.createSequentialGroup().addContainerGap().addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUnidadFLayout.createSequentialGroup().addComponent(this.JSPDetalle1, -1, 1137, 32767).addGap(12, 12, 12)).addGroup(JPIUnidadFLayout.createSequentialGroup().addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFRPresupuesto).addComponent(this.JCBUnidadFc, -2, 294, -2)).addGap(18, 18, 18).addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIUnidadFLayout.createSequentialGroup().addComponent(this.JTFDebito, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRCuentaD, -2, 234, -2)).addComponent(this.JTFRRubro, -2, 383, -2)).addGap(18, 18, 18).addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCredito, -2, 108, -2).addComponent(this.JCHEstadoUfc)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRCuentaC, -2, 247, -2).addGroup(JPIUnidadFLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JBTAdicionarUF, -2, 211, -2))).addContainerGap(-1, 32767)))));
        JPIUnidadFLayout.setVerticalGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIUnidadFLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadFc, -2, -1, -2).addComponent(this.JTFDebito, -2, -1, -2).addComponent(this.JTFRCuentaD, -2, -1, -2).addComponent(this.JTFCredito, -2, -1, -2).addComponent(this.JTFRCuentaC, -2, -1, -2)).addGap(10, 10, 10).addGroup(JPIUnidadFLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRPresupuesto, -2, -1, -2).addComponent(this.JTFRRubro, -2, -1, -2).addComponent(this.JCHEstadoUfc).addComponent(this.JBTAdicionarUF, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle1, -1, 119, 32767)));
        this.JTPMenu.setForeground(Color.red);
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JPI_FUtilizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Utilización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_FUtilizacion.add(this.JRB_FU_Empleado);
        this.JRB_FU_Empleado.setFont(new Font("Arial", 1, 12));
        this.JRB_FU_Empleado.setText("Empleado");
        this.JRB_FU_Empleado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.10
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRB_FU_EmpleadoActionPerformed(evt);
            }
        });
        this.JBG_FUtilizacion.add(this.JRB_FU_Empleador);
        this.JRB_FU_Empleador.setFont(new Font("Arial", 1, 12));
        this.JRB_FU_Empleador.setText("Empleador");
        this.JRB_FU_Empleador.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.11
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRB_FU_EmpleadorActionPerformed(evt);
            }
        });
        this.JBG_FUtilizacion.add(this.JRB_FU_Ambos);
        this.JRB_FU_Ambos.setFont(new Font("Arial", 1, 12));
        this.JRB_FU_Ambos.setText("Ambos");
        this.JRB_FU_Ambos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.12
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRB_FU_AmbosActionPerformed(evt);
            }
        });
        GroupLayout JPI_FUtilizacionLayout = new GroupLayout(this.JPI_FUtilizacion);
        this.JPI_FUtilizacion.setLayout(JPI_FUtilizacionLayout);
        JPI_FUtilizacionLayout.setHorizontalGroup(JPI_FUtilizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_FU_Empleado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_FU_Empleador).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_FU_Ambos).addContainerGap(-1, 32767)));
        JPI_FUtilizacionLayout.setVerticalGroup(JPI_FUtilizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizacionLayout.createSequentialGroup().addGroup(JPI_FUtilizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FU_Ambos).addComponent(this.JRB_FU_Empleador).addComponent(this.JRB_FU_Empleado)).addGap(0, 6, 32767)));
        this.JPI_FUtilizacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Base a Utilizar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_BUtilizar.add(this.JRB_BU_NoAplica);
        this.JRB_BU_NoAplica.setFont(new Font("Arial", 1, 12));
        this.JRB_BU_NoAplica.setSelected(true);
        this.JRB_BU_NoAplica.setText("No Aplica");
        this.JRB_BU_NoAplica.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.13
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRB_BU_NoAplicaActionPerformed(evt);
            }
        });
        this.JBG_BUtilizar.add(this.JRB_BU_CBase);
        this.JRB_BU_CBase.setFont(new Font("Arial", 1, 12));
        this.JRB_BU_CBase.setText("Concepto Base");
        this.JRB_BU_CBase.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.14
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRB_BU_CBaseActionPerformed(evt);
            }
        });
        this.JBG_BUtilizar.add(this.JRB_BU_IBC);
        this.JRB_BU_IBC.setFont(new Font("Arial", 1, 12));
        this.JRB_BU_IBC.setText("Calculo IBC");
        this.JRB_BU_IBC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.15
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRB_BU_IBCActionPerformed(evt);
            }
        });
        GroupLayout JPI_FUtilizacion1Layout = new GroupLayout(this.JPI_FUtilizacion1);
        this.JPI_FUtilizacion1.setLayout(JPI_FUtilizacion1Layout);
        JPI_FUtilizacion1Layout.setHorizontalGroup(JPI_FUtilizacion1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizacion1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRB_BU_NoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_BU_CBase).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_BU_IBC)));
        JPI_FUtilizacion1Layout.setVerticalGroup(JPI_FUtilizacion1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FUtilizacion1Layout.createSequentialGroup().addGroup(JPI_FUtilizacion1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_BU_IBC).addComponent(this.JRB_BU_CBase).addComponent(this.JRB_BU_NoAplica)).addGap(0, 6, 32767)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.16
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIFCalculo.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMA CÁLCULO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGFcalculo.add(this.JRBFCNoAplica);
        this.JRBFCNoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBFCNoAplica.setSelected(true);
        this.JRBFCNoAplica.setText("N/A");
        this.JRBFCNoAplica.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.17
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRBFCNoAplicaActionPerformed(evt);
            }
        });
        this.JBGFcalculo.add(this.JRBFCPorcentaje);
        this.JRBFCPorcentaje.setFont(new Font("Arial", 1, 12));
        this.JRBFCPorcentaje.setText("%");
        this.JRBFCPorcentaje.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.18
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRBFCPorcentajeActionPerformed(evt);
            }
        });
        this.JBGFcalculo.add(this.JRBFCDias);
        this.JRBFCDias.setFont(new Font("Arial", 1, 12));
        this.JRBFCDias.setText("Días");
        this.JRBFCDias.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.19
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRBFCDiasActionPerformed(evt);
            }
        });
        this.JBGFcalculo.add(this.JRBFCVfijo);
        this.JRBFCVfijo.setFont(new Font("Arial", 1, 12));
        this.JRBFCVfijo.setText("V/Fijo");
        this.JRBFCVfijo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.20
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRBFCVfijoActionPerformed(evt);
            }
        });
        this.JSPFCValor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor E", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPFCValor1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0000"))));
        this.JSPFCValor1.setHorizontalAlignment(4);
        this.JSPFCValor1.setToolTipText("Valor para calculo por empresa");
        this.JSPFCValor1.setFont(new Font("Arial", 1, 13));
        this.JSPFCValor1.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFRHConceptosNomina.21
            public void keyPressed(KeyEvent evt) {
                JIFRHConceptosNomina.this.JSPFCValor1KeyPressed(evt);
            }
        });
        this.JSPFCValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPFCValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0000"))));
        this.JSPFCValor.setHorizontalAlignment(4);
        this.JSPFCValor.setToolTipText("Valor para calculo por usuario");
        this.JSPFCValor.setFont(new Font("Arial", 1, 13));
        this.JSPFCValor.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFRHConceptosNomina.22
            public void keyPressed(KeyEvent evt) {
                JIFRHConceptosNomina.this.JSPFCValorKeyPressed(evt);
            }
        });
        GroupLayout JPIFCalculoLayout = new GroupLayout(this.JPIFCalculo);
        this.JPIFCalculo.setLayout(JPIFCalculoLayout);
        JPIFCalculoLayout.setHorizontalGroup(JPIFCalculoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFCalculoLayout.createSequentialGroup().addGroup(JPIFCalculoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBFCPorcentaje).addComponent(this.JRBFCNoAplica, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPIFCalculoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBFCVfijo).addComponent(this.JRBFCDias)).addGap(5, 5, 5).addComponent(this.JSPFCValor, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPFCValor1, -1, 96, 32767).addContainerGap()));
        JPIFCalculoLayout.setVerticalGroup(JPIFCalculoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFCalculoLayout.createSequentialGroup().addContainerGap().addGroup(JPIFCalculoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIFCalculoLayout.createSequentialGroup().addGroup(JPIFCalculoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFCNoAplica).addComponent(this.JRBFCDias, -2, 40, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIFCalculoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFCPorcentaje).addComponent(this.JRBFCVfijo))).addComponent(this.JSPFCValor1).addComponent(this.JSPFCValor)).addContainerGap()));
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorBase.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Base", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorBase.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorBase.setHorizontalAlignment(4);
        this.JTFFValorBase.setFont(new Font("Arial", 1, 12));
        this.JTFFValorBase.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.23
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JTFFValorBaseActionPerformed(evt);
            }
        });
        this.JTFFValorBaseN.setBorder(BorderFactory.createTitledBorder((Border) null, " Valor Base N", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorBaseN.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorBaseN.setHorizontalAlignment(4);
        this.JTFFValorBaseN.setFont(new Font("Arial", 1, 12));
        this.JTFNombreCorto.setFont(new Font("Arial", 1, 12));
        this.JTFNombreCorto.setToolTipText("");
        this.JTFNombreCorto.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Corto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreCorto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.24
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JTFNombreCortoActionPerformed(evt);
            }
        });
        this.JSPRedondeo.setFont(new Font("Arial", 1, 12));
        this.JSPRedondeo.setModel(new SpinnerNumberModel(0, -2, 4, 1));
        this.JSPRedondeo.setBorder(BorderFactory.createTitledBorder((Border) null, "Redondeo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPFPorcentajeDian.setFont(new Font("Arial", 1, 12));
        this.JSPFPorcentajeDian.setModel(new SpinnerNumberModel(0.0d, 0.0d, 100.0d, 1.0d));
        this.JSPFPorcentajeDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Porcentaje Dian", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACION", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCB_Clasificacion.setFont(new Font("Arial", 1, 12));
        this.JCB_Clasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación del Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasificacionCGR.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacionCGR.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación del Informe CGR", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasificacionNominaE.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacionNominaE.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion Nomina Electronica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBClasificacionNominaE, 0, -1, 32767).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCB_Clasificacion, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacionCGR, -2, 207, -2).addGap(0, 0, 32767))).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_Clasificacion, -2, 50, -2).addComponent(this.JCBClasificacionCGR, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBClasificacionNominaE, -2, 50, -2)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACION", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCHEsSalario.setFont(new Font("Arial", 1, 12));
        this.JCHEsSalario.setText("¿Es Salario?");
        this.JCHEsSalario.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.25
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHEsSalarioActionPerformed(evt);
            }
        });
        this.JCHCBase.setFont(new Font("Arial", 1, 12));
        this.JCHCBase.setText("¿Es base?");
        this.JCHCBase.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.26
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHCBaseActionPerformed(evt);
            }
        });
        this.JCHCBase1.setFont(new Font("Arial", 1, 12));
        this.JCHCBase1.setText("¿Es base 1?");
        this.JCHCBase1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.27
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHCBase1ActionPerformed(evt);
            }
        });
        this.JCHMTercero.setFont(new Font("Arial", 1, 12));
        this.JCHMTercero.setText("¿Maneja Tercero?");
        this.JCHMTercero.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.28
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHMTerceroActionPerformed(evt);
            }
        });
        this.JCHCSSalario.setFont(new Font("Arial", 1, 12));
        this.JCHCSSalario.setText("¿Tiene % Sobre Salario?");
        this.JCHCSSalario.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.29
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHCSSalarioActionPerformed(evt);
            }
        });
        this.JCHEsIncapacidad.setFont(new Font("Arial", 1, 12));
        this.JCHEsIncapacidad.setText("¿Es Incapacidad?");
        this.JCHEsIncapacidad.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.30
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHEsIncapacidadActionPerformed(evt);
            }
        });
        this.JCHEsIBC.setFont(new Font("Arial", 1, 12));
        this.JCHEsIBC.setText("Es IBC");
        this.JCHEsIBC.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.31
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHEsIBCActionPerformed(evt);
            }
        });
        this.JCHEsDeduccion.setFont(new Font("Arial", 1, 12));
        this.JCHEsDeduccion.setText("¿Es Deducción?");
        this.JCHEsDeduccion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.32
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHEsDeduccionActionPerformed(evt);
            }
        });
        this.JCHEsReporte.setFont(new Font("Arial", 1, 12));
        this.JCHEsReporte.setText("Es Reporte por Trabajador");
        this.JCHEsReporte.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.33
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHEsReporteActionPerformed(evt);
            }
        });
        this.JCHBInicializar.setFont(new Font("Arial", 1, 12));
        this.JCHBInicializar.setText("¿Inicializar Base?");
        this.JCHBInicializar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.34
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHBInicializarActionPerformed(evt);
            }
        });
        this.JCHEsFijo.setFont(new Font("Arial", 1, 12));
        this.JCHEsFijo.setText("¿Es Fijo?");
        this.JCHEsFijo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.35
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHEsFijoActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.36
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCHEsSalario).addGap(11, 11, 11).addComponent(this.JCHEsDeduccion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHCBase)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCHEsIncapacidad).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsReporte))).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCHEsFijo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBInicializar, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHMTercero).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addGap(0, 0, 32767)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCHCBase1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHCSSalario).addGap(18, 18, 18).addComponent(this.JCHEsIBC).addGap(132, 132, 132)))));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsSalario).addComponent(this.JCHCBase).addComponent(this.JCHCSSalario).addComponent(this.JCHEsIBC).addComponent(this.JCHCBase1).addComponent(this.JCHEsDeduccion)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsIncapacidad).addComponent(this.JCHEsReporte).addComponent(this.JCHEsFijo).addComponent(this.JCHBInicializar).addComponent(this.JCHMTercero).addComponent(this.JCHEstado)).addContainerGap(22, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre, -1, 434, 32767).addComponent(this.jPanel4, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombreCorto, -2, 183, -2).addGap(18, 18, 18).addComponent(this.JTFFValorBaseN, -2, 141, -2).addGap(18, 18, 18).addComponent(this.JTFFValorBase, -2, 124, -2).addGap(18, 18, 18).addComponent(this.JTFCodigo, -2, 97, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPI_FUtilizacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_FUtilizacion1, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPFPorcentajeDian, -2, 131, -2).addGap(18, 18, 18).addComponent(this.JSPRedondeo, -2, 96, -2).addGap(18, 18, 18).addComponent(this.JSPOrden, -2, 98, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPIFCalculo, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel5, -2, 0, 32767))).addGap(63, 63, 63)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, 51, -2).addComponent(this.JTFFValorBase, -2, 50, -2).addComponent(this.JTFFValorBaseN, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFNombreCorto, -2, 50, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(29, 29, 29).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPFPorcentajeDian, -2, 50, -2).addComponent(this.JSPRedondeo, -2, 50, -2).addComponent(this.JSPOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_FUtilizacion1, -2, -1, -2).addComponent(this.JPI_FUtilizacion, -2, -1, -2)).addGap(6, 6, 6))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JPIFCalculo, -2, -1, -2).addContainerGap()).addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -2, -1, -2))));
        this.JTPMenu.addTab("1", this.jPanel1);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Configuracion Salarial", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel3.setFont(new Font("Arial", 1, 14));
        this.JTFFTopeSalarial.setBorder(BorderFactory.createTitledBorder((Border) null, "Tope Salarial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTopeSalarial.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTopeSalarial.setHorizontalAlignment(4);
        this.JTFFTopeSalarial.setFont(new Font("Arial", 1, 12));
        this.JBG_CSalarial.add(this.JRBNoAplica);
        this.JRBNoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBNoAplica.setSelected(true);
        this.JRBNoAplica.setText("No Aplica");
        this.JRBNoAplica.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.37
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRBNoAplicaActionPerformed(evt);
            }
        });
        this.JBG_CSalarial.add(this.JRBDesde);
        this.JRBDesde.setFont(new Font("Arial", 1, 12));
        this.JRBDesde.setText("Desde");
        this.JRBDesde.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.38
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRBDesdeActionPerformed(evt);
            }
        });
        this.JBG_CSalarial.add(this.JRBHasta);
        this.JRBHasta.setFont(new Font("Arial", 1, 12));
        this.JRBHasta.setText("Hasta");
        this.JRBHasta.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.39
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.JRBHastaActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFTopeSalarial, -1, 193, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDesde).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBHasta).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNoAplica).addComponent(this.JRBDesde).addComponent(this.JRBHasta)).addComponent(this.JTFFTopeSalarial, -2, 50, -2)).addContainerGap(8, 32767)));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.jButton1.setText("Configuración Períodos");
        this.jButton1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRHConceptosNomina.40
            public void actionPerformed(ActionEvent evt) {
                JIFRHConceptosNomina.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, -1, -2).addGap(71, 71, 71).addComponent(this.jButton1, -2, 235, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jButton1, -2, 50, -2))).addContainerGap()));
        this.JTPMenu.addTab("2", this.jPanel2);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPMenu).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIUnidadF, -2, -1, -2).addContainerGap(34, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTPMenu).addGap(28, 28, 28).addComponent(this.JPIUnidadF, -2, -1, -2).addContainerGap()));
        this.JTPDatosB.addTab("INFORMACIÓN", this.JPIDatos);
        this.JTFF_Nombre.setFont(new Font("Arial", 1, 12));
        this.JTFF_Nombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Nombre.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFRHConceptosNomina.41
            public void keyPressed(KeyEvent evt) {
                JIFRHConceptosNomina.this.JTFF_NombreKeyPressed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRHConceptosNomina.42
            public void mouseClicked(MouseEvent evt) {
                JIFRHConceptosNomina.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 1161, 32767).addComponent(this.JTFF_Nombre)).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFF_Nombre, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 604, 32767).addContainerGap()));
        this.JTPDatosB.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosB, -2, 1205, -2).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosB, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombreCorto.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).intValue() == 1) {
                this.JRBFCNoAplica.setSelected(true);
                this.xtipocalculo = 1;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).intValue() == 2) {
                this.JRBFCDias.setSelected(true);
                this.xtipocalculo = 2;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).intValue() == 3) {
                this.JRBFCPorcentaje.setSelected(true);
                this.xtipocalculo = 3;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).intValue() == 4) {
                this.JRBFCVfijo.setSelected(true);
                this.xtipocalculo = 4;
            }
            this.JSPFCValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
            this.JSPFCValor1.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString()));
            this.JTFFValorBase.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 25).toString()));
            this.JTFFValorBaseN.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 26).toString()));
            this.JSPFPorcentajeDian.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 27).toString()));
            this.JSPRedondeo.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 28).toString()));
            this.JTFFTopeSalarial.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 29).toString()));
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 30).toString().equals("EVALUAR HASTA")) {
                this.identificadorTope = 0;
                this.JRBHasta.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 30).toString().equals("EVALUAR DESDE")) {
                this.identificadorTope = 1;
                this.JRBDesde.setSelected(true);
            } else {
                this.identificadorTope = -1;
                this.JRBNoAplica.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 31).toString().equals("")) {
                this.JCBClasificacionNominaE.setSelectedIndex(-1);
            } else {
                this.JCBClasificacionNominaE.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 31).toString());
            }
            if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString()).intValue() == 0) {
                this.JRB_FU_Empleado.setSelected(true);
                this.xUF_Utilizacion = 0;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString()).intValue() == 1) {
                this.JRB_FU_Empleador.setSelected(true);
                this.xUF_Utilizacion = 1;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString()).intValue() == 2) {
                this.JRB_FU_Ambos.setSelected(true);
                this.xUF_Utilizacion = 2;
            }
            this.JCB_Clasificacion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 18).toString());
            this.JCHEsDeduccion.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (this.JCHEsDeduccion.isSelected()) {
                this.xesdeducion = 1;
            } else {
                this.xesdeducion = 0;
            }
            this.JCHEsReporte.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue());
            if (this.JCHEsReporte.isSelected()) {
                this.xesreporte = 1;
            } else {
                this.xesreporte = 0;
            }
            this.JCHEsSalario.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            if (this.JCHEsSalario.isSelected()) {
                this.xessalario = 1;
            } else {
                this.xessalario = 0;
            }
            this.JCHCBase.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).booleanValue());
            if (this.JCHCBase.isSelected()) {
                this.xcbase = 1;
            } else {
                this.xcbase = 0;
            }
            this.JCHCBase1.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString()).booleanValue());
            if (this.JCHCBase1.isSelected()) {
                this.xcbase1 = 1;
            } else {
                this.xcbase1 = 0;
            }
            this.JCHMTercero.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString()).booleanValue());
            if (this.JCHMTercero.isSelected()) {
                this.xmtercero = 1;
            } else {
                this.xmtercero = 0;
            }
            this.JCHCSSalario.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString()).booleanValue());
            if (this.JCHCSSalario.isSelected()) {
                this.xcssalario = 1;
            } else {
                this.xcssalario = 0;
            }
            this.JSPOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JCHEsIncapacidad.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 19).toString()).booleanValue());
            if (this.JCHEsIncapacidad.isSelected()) {
                this.xincapacidad = 1;
            } else {
                this.xincapacidad = 0;
            }
            if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 20).toString()).intValue() == -1) {
                this.JRB_BU_NoAplica.setSelected(true);
                this.xUB_Utilizacion = -1;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 20).toString()).intValue() == 0) {
                this.JRB_BU_CBase.setSelected(true);
                this.xUB_Utilizacion = 0;
            } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 20).toString()).intValue() == 1) {
                this.JRB_BU_IBC.setSelected(true);
                this.xUB_Utilizacion = 1;
            }
            this.JCHBInicializar.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 21).toString()).booleanValue());
            if (this.JCHBInicializar.isSelected()) {
                this.xesbinicializar = 1;
            } else {
                this.xesbinicializar = 0;
            }
            this.JCHEsFijo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 22).toString()).booleanValue());
            if (this.JCHEsFijo.isSelected()) {
                this.xesfijo = 1;
            } else {
                this.xesfijo = 0;
            }
            this.JCHEsIBC.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 23).toString()).booleanValue());
            if (this.JCHEsIBC.isSelected()) {
                this.xesibc = 1;
            } else {
                this.xesibc = 0;
            }
            this.JCBClasificacionCGR.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 24).toString());
            mCargarDatosTabla1();
            this.JTPDatosB.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsDeduccionActionPerformed(ActionEvent evt) {
        if (this.JCHEsDeduccion.isSelected()) {
            this.xesdeducion = 1;
        } else {
            this.xesdeducion = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsReporteActionPerformed(ActionEvent evt) {
        if (this.JCHEsReporte.isSelected()) {
            this.xesreporte = 1;
        } else {
            this.xesreporte = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFCNoAplicaActionPerformed(ActionEvent evt) {
        this.xtipocalculo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFCDiasActionPerformed(ActionEvent evt) {
        this.xtipocalculo = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFCPorcentajeActionPerformed(ActionEvent evt) {
        this.xtipocalculo = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFCVfijoActionPerformed(ActionEvent evt) {
        this.xtipocalculo = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsSalarioActionPerformed(ActionEvent evt) {
        if (this.JCHEsSalario.isSelected()) {
            this.xessalario = 1;
        } else {
            this.xessalario = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCBaseActionPerformed(ActionEvent evt) {
        if (this.JCHCBase.isSelected()) {
            this.xcbase = 1;
        } else {
            this.xcbase = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMTerceroActionPerformed(ActionEvent evt) {
        if (this.JCHMTercero.isSelected()) {
            this.xmtercero = 1;
        } else {
            this.xmtercero = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCSSalarioActionPerformed(ActionEvent evt) {
        if (this.JCHCSSalario.isSelected()) {
            this.xcssalario = 1;
        } else {
            this.xcssalario = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FU_EmpleadoActionPerformed(ActionEvent evt) {
        this.xUF_Utilizacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FU_EmpleadorActionPerformed(ActionEvent evt) {
        this.xUF_Utilizacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FU_AmbosActionPerformed(ActionEvent evt) {
        this.xUF_Utilizacion = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_NombreKeyPressed(KeyEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_BU_NoAplicaActionPerformed(ActionEvent evt) {
        this.xUB_Utilizacion = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_BU_CBaseActionPerformed(ActionEvent evt) {
        this.xUB_Utilizacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_BU_IBCActionPerformed(ActionEvent evt) {
        this.xUB_Utilizacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsIncapacidadActionPerformed(ActionEvent evt) {
        if (this.JCHEsIncapacidad.isSelected()) {
            this.xincapacidad = 1;
        } else {
            this.xincapacidad = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBInicializarActionPerformed(ActionEvent evt) {
        if (this.JCHBInicializar.isSelected()) {
            this.xesbinicializar = 1;
        } else {
            this.xesbinicializar = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsFijoActionPerformed(ActionEvent evt) {
        if (this.JCHEsFijo.isSelected()) {
            this.xesfijo = 1;
        } else {
            this.xesfijo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsIBCActionPerformed(ActionEvent evt) {
        if (this.JCHEsIBC.isSelected()) {
            this.xesibc = 1;
        } else {
            this.xesibc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPFCValor1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JSPFCValor1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPFCValorKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoAplicaActionPerformed(ActionEvent evt) {
        this.identificadorTope = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDesdeActionPerformed(ActionEvent evt) {
        this.identificadorTope = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHastaActionPerformed(ActionEvent evt) {
        this.identificadorTope = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCBase1ActionPerformed(ActionEvent evt) {
        if (this.JCHCBase.isSelected()) {
            this.xcbase1 = 1;
        } else {
            this.xcbase1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreCortoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFValorBaseActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        xid = this.JTFNombre.getText();
        if (!Principal.txtNo.getText().isEmpty()) {
            JDNominaConceptosPeriodos jDNominaConceptosPeriodos = new JDNominaConceptosPeriodos(null, true, Integer.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            jDNominaConceptosPeriodos.setLocationRelativeTo(null);
            jDNominaConceptosPeriodos.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "Verificar", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1) {
            this.JCBUnidadFc.setSelectedItem(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 1));
            this.JTFDebito.setText(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 2).toString());
            this.JTFCredito.setText(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 3).toString());
            this.JTFRPresupuesto.setText(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 4).toString());
            this.JCHEstadoUfc.setSelected(Boolean.valueOf(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEstadoUfc.isSelected()) {
                this.xcbase = 1;
            } else {
                this.xcbase = 0;
            }
            this.xgrabarufc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mBuscarCuentadebito();
            this.JTFCredito.requestFocus();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro del histórico", "VERIFICAR", 1);
            this.JTDetalle.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mBuscarCuentacredito();
            this.JTFRPresupuesto.requestFocus();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro del histórico", "VERIFICAR", 1);
            this.JTDetalle.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRPresupuestoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mBuscarrubro();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro del histórico", "VERIFICAR", 1);
            this.JTDetalle.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRRubroActionPerformed(ActionEvent evt) {
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
    public void JBTAdicionarUFActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.JCBUnidadFc.getSelectedIndex() != -1) {
                String sql = null;
                if (this.xgrabarufc) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
                    if (n == 0) {
                        sql = "update rh_nomina_concepto_unidadf set Estado='" + this.xestadouf + "', CDebito='" + this.JTFDebito.getText() + "', CCredito='" + this.JTFCredito.getText() + "', RPresupuesto='" + this.JTFRPresupuesto.getText() + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', Id_UsuarioS='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'  Where ( `rh_nomina_concepto_unidadf`.`Id` = " + this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 0).toString() + " )";
                        System.out.println(sql);
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla1();
                    }
                } else if (!this.xmt.mVerificarDatosDoblesTabla(this.JTDetalle1, 1, this.JCBUnidadFc.getSelectedItem().toString())) {
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
                    if (n2 == 0) {
                        sql = "insert into rh_nomina_concepto_unidadf(Id_ConceptosN, Id_UnidaFC, CDebito, CCredito, RPresupuesto, Estado, Fecha, Id_UsuarioS) values('" + Principal.txtNo.getText() + "','" + this.xidunidadfc[this.JCBUnidadFc.getSelectedIndex()] + "','" + this.JTFDebito.getText() + "','" + this.JTFCredito.getText() + "','" + this.JTFRPresupuesto.getText() + "','" + this.xestadouf + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        mCargarDatosTabla1();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Unidad funcional ya grabada", "VERIFICAR", 1);
                }
                System.out.println(sql);
                this.xgrabarufc = false;
                this.JCBUnidadFc.setSelectedIndex(-1);
                this.JCHEstadoUfc.setSelected(true);
                this.xestadouf = 1;
                this.JCBUnidadFc.requestFocus();
                this.JTFRCuentaD.setText("");
                this.JTFRCuentaC.setText("");
                this.JTFRRubro.setText("");
                this.JTFDebito.setText("");
                this.JTFCredito.setText("");
                this.JTFRPresupuesto.setText("");
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1);
            this.JCBUnidadFc.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro del histórico", "VERIFICAR", 1);
        this.JTDetalle.requestFocus();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            this.JTFRPresupuesto.setEnabled(true);
        } else {
            this.JTFRPresupuesto.setEnabled(false);
        }
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JTFCredito.setEnabled(true);
            this.JTFDebito.setEnabled(true);
        } else {
            this.JTFCredito.setEnabled(false);
            this.JTFDebito.setEnabled(false);
        }
        this.JSPOrden.setValue(new Integer(0));
        this.JSPFCValor.setValue(new Double(0.0d));
        this.JSPFCValor1.setValue(new Double(0.0d));
        this.JTFFValorBase.setValue(new Double(0.0d));
        this.JTFFTopeSalarial.setValue(new Double(0.0d));
        this.xgrabarufc = false;
        this.JTFNombre.setText("");
        this.JTFCodigo.setText("");
        this.xtipocalculo = 1;
        this.xcbase = 0;
        this.xUF_Utilizacion = 0;
        this.JRB_FU_Ambos.setSelected(true);
        this.JRBFCNoAplica.setSelected(true);
        this.JCHEstado.setSelected(true);
        this.JCHEsDeduccion.setSelected(false);
        this.JCHCSSalario.setSelected(false);
        this.xcssalario = 0;
        this.xestado = 1;
        this.xesdeducion = 0;
        this.xesreporte = 0;
        this.xessalario = 0;
        this.xestadouf = 1;
        this.JCHEsReporte.setSelected(false);
        this.JCHEsSalario.setSelected(false);
        this.JCBUnidadFc.removeAllItems();
        this.xidunidadfc = this.xct.llenarCombo("SELECT Id, Nbre FROM cc_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidunidadfc, this.JCBUnidadFc);
        this.JCBUnidadFc.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBClasificacionNominaE.removeAllItems();
        this.xId_ClasificacionNominaE = this.xct.llenarCombo("SELECT `id`, `nombre` FROM `rh_clasificacion_concepto_nominae` WHERE (`estado` =1);", this.xId_ClasificacionNominaE, this.JCBClasificacionNominaE);
        this.JCBClasificacionNominaE.setSelectedIndex(-1);
        this.JCB_Clasificacion.removeAllItems();
        this.xId_Clasificacion = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM`rh_tipo_clasificacion_conceptonomina` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xId_Clasificacion, this.JCB_Clasificacion);
        this.JCB_Clasificacion.setSelectedIndex(-1);
        this.JCBClasificacionCGR.removeAllItems();
        this.xIdClasificacionCGR = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `rh_concepto_agrupacion_informe_cgr` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xIdClasificacionCGR, this.JCBClasificacionCGR);
        this.JCBClasificacionCGR.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFCredito.setText("");
        this.JTFDebito.setText("");
        this.JTFRPresupuesto.setText("");
        this.JCHEstadoUfc.setSelected(true);
        this.JCHCBase.setSelected(false);
        this.JCHMTercero.setSelected(false);
        this.xUB_Utilizacion = -1;
        this.JRB_BU_NoAplica.setSelected(true);
        this.JCHBInicializar.setSelected(false);
        this.xesbinicializar = 0;
        this.JCHEsFijo.setSelected(false);
        this.xesfijo = 0;
        this.JCHEsIncapacidad.setSelected(false);
        this.xincapacidad = 0;
        this.JCHEsIBC.setSelected(false);
        this.xesibc = 0;
        this.JRBNoAplica.setSelected(true);
        this.identificadorTope = -1;
        mCargarDatosTabla();
        mCrearModeloDatos1();
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCB_Clasificacion.getSelectedIndex() != -1) {
                if (this.JCBClasificacionCGR.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            this.xsql = " Insert into rh_nomina_conceptos(Nbre, Codigo, TipoCalculo, Valor,ValorBase, EsDeduccion, ReporteU, CSalario, CSSalario, CBase, MTercero, NOrden,`ValorE`, `CPago`, `Id_Clasificacion`,EsIncapacidad, BUtiliza, BInicializar, EsFijo, EsIBC, IdClasificacionCgr, topeSalarial, identificadorTope, Estado, UsuarioS,Id_ClasificacionNominaE,Nbre_Corto,ValorBaseN,porcentajeDian,CBase1,redondeo)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFCodigo.getText().toUpperCase() + "','" + this.xtipocalculo + "','" + this.JSPFCValor.getValue() + "','" + this.JTFFValorBase.getValue() + "','" + this.xesdeducion + "','" + this.xesreporte + "','" + this.xessalario + "','" + this.xcssalario + "','" + this.xcbase + "','" + this.xmtercero + "','" + this.JSPOrden.getValue() + "','" + this.JSPFCValor1.getValue() + "','" + this.xUF_Utilizacion + "','" + this.xId_Clasificacion[this.JCB_Clasificacion.getSelectedIndex()] + "','" + this.xincapacidad + "','" + this.xUB_Utilizacion + "','" + this.xesbinicializar + "','" + this.xesfijo + "','" + this.xesibc + "','" + this.xIdClasificacionCGR[this.JCBClasificacionCGR.getSelectedIndex()] + "','" + this.JTFFTopeSalarial.getValue() + "','" + this.identificadorTope + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xId_ClasificacionNominaE[this.JCBClasificacionNominaE.getSelectedIndex()] + "','" + this.JTFNombreCorto.getText() + "','" + this.JTFFValorBaseN.getValue() + "','" + this.JSPFPorcentajeDian.getValue() + "','" + this.xcbase1 + "','" + this.JSPRedondeo.getValue() + "')";
                        } else {
                            this.xsql = " update rh_nomina_conceptos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Codigo='" + this.JTFCodigo.getText().toUpperCase() + "',TipoCalculo='" + this.xtipocalculo + "',Valor='" + this.JSPFCValor.getValue() + "',ValorBase='" + this.JTFFValorBase.getValue() + "',EsDeduccion='" + this.xesdeducion + "',ReporteU='" + this.xesreporte + "',CSalario='" + this.xessalario + "',CSSalario='" + this.xcssalario + "',CBase='" + this.xcbase + "',MTercero='" + this.xmtercero + "',NOrden='" + this.JSPOrden.getValue() + "',ValorE='" + this.JSPFCValor1.getValue() + "',CPago='" + this.xUF_Utilizacion + "',Id_Clasificacion='" + this.xId_Clasificacion[this.JCB_Clasificacion.getSelectedIndex()] + "',EsIncapacidad='" + this.xincapacidad + "',BUtiliza='" + this.xUB_Utilizacion + "',BInicializar='" + this.xesbinicializar + "',EsFijo='" + this.xesfijo + "',EsIBC='" + this.xesibc + "',IdClasificacionCgr='" + this.xIdClasificacionCGR[this.JCBClasificacionCGR.getSelectedIndex()] + "',topeSalarial='" + this.JTFFTopeSalarial.getValue() + "',identificadorTope='" + this.identificadorTope + "',Estado='" + this.xestado + "',Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "',Id_ClasificacionNominaE = '" + this.xId_ClasificacionNominaE[this.JCBClasificacionNominaE.getSelectedIndex()] + "',Nbre_Corto = '" + this.JTFNombreCorto.getText() + "',ValorBaseN = '" + this.JTFFValorBaseN.getValue() + "',porcentajeDian = '" + this.JSPFPorcentajeDian.getValue() + "',CBase1='" + this.xcbase1 + "',redondeo='" + this.JSPRedondeo.getValue() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        }
                        System.out.print(this.xsql);
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        this.xsql = "UPDATE rh_nomina_persona_conceptos , (\n\nSELECT\n    `rh_nomina_persona_conceptos`.`Id_PersonaC`\n    , `rh_nomina_persona_conceptos`.`Id_RhConcepto_UF`\nFROM\n     `rh_nomina_persona_conceptos`\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`)\nWHERE (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` ='" + Principal.txtNo.getText() + "')) d SET rh_nomina_persona_conceptos.`Valor`=" + this.JSPFCValor.getValue() + ", rh_nomina_persona_conceptos.`ValorE`=" + this.JSPFCValor1.getValue() + "\n, rh_nomina_persona_conceptos.`TCalculo`=" + this.xtipocalculo + "\nWHERE rh_nomina_persona_conceptos.`Id_PersonaC`=d.Id_PersonaC AND d.Id_RhConcepto_UF=rh_nomina_persona_conceptos.`Id_RhConcepto_UF`";
                        mCargarDatosTabla();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una clasificación del informe CGR", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBClasificacionCGR.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una clasificación del concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_Clasificacion.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "NombreCorto", "Código", "IdTipoC", "Tipo Calculo", "Valor", "EsDeducción", "EsReporte", "EsSalario", "CBase", "CBase1", "ManejaTercero", "% Salario", "Orden", "Estado", "ValorE", "FUtilizacion", "Clasificacion", "EsIncapacidad", "BUtilizar", "BInicializar", "EsFijo", "EsIBC", "Clasificacion CGR", "Valor Base", "Valor Base N", "Porcentaje Dian", "Rendodeo", "Tope Salarial", "Tipo Tope", "Clasificacion NominaE"}) { // from class: ParametrizacionN.JIFRHConceptosNomina.43
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, String.class, Double.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Long.class, Boolean.class, Double.class, Long.class, String.class, Boolean.class, Long.class, Boolean.class, Boolean.class, Boolean.class, String.class, Double.class, Double.class, Integer.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Debito", "Credito", "Rubro Presupuestal", "Estado"}) { // from class: ParametrizacionN.JIFRHConceptosNomina.44
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT\n  `rh_nomina_conceptos`.Id,\n  `rh_nomina_conceptos`.Nbre,\n  `rh_nomina_conceptos`.Nbre_Corto ,\n  `rh_nomina_conceptos`.Codigo,\n  `rh_nomina_conceptos`.TipoCalculo,\n  IF(`rh_nomina_conceptos`.TipoCalculo = 1,'N/A',IF(`rh_nomina_conceptos`.TipoCalculo = 2,'D�?AS',IF(`rh_nomina_conceptos`.TipoCalculo = 3,'PORCENTAJE','V/FIJO'))) AS NTipoCalculo,\n  `rh_nomina_conceptos`.Valor,\n  `rh_nomina_conceptos`.EsDeduccion,\n  `rh_nomina_conceptos`.ReporteU,\n  `rh_nomina_conceptos`.CSalario,\n  `rh_nomina_conceptos`.CBase,\n  `rh_nomina_conceptos`.CBase1,\n  `rh_nomina_conceptos`.MTercero,\n  `rh_nomina_conceptos`.CSSalario,\n  `rh_nomina_conceptos`.NOrden,\n  `rh_nomina_conceptos`.Estado,\n  `rh_nomina_conceptos`.`ValorE`,\n  `rh_nomina_conceptos`.`CPago`,\n  `rh_tipo_clasificacion_conceptonomina`.`Nbre` AS `Clasificacion`,\n  EsIncapacidad,\n  BUtiliza,\n  BInicializar,\n  EsFijo,\n  EsIBC,\n  rh_concepto_agrupacion_informe_cgr.Nbre AS CGR,\n  ValorBase,\n  `rh_nomina_conceptos`.ValorBaseN,\n  `rh_nomina_conceptos`.porcentajeDian,\n  `rh_nomina_conceptos`.redondeo,\n  topeSalarial,\n  IF(`identificadorTope`=0,'EVALUAR HASTA',IF(`identificadorTope`=1,'EVALUAR DESDE', 'NO APLICA')) AS TipoTope\n ,ifnull(`rh_clasificacion_concepto_nominae`.`nombre`,'') as nombreConceptoE \nFROM\n  rh_nomina_conceptos\n  INNER JOIN `rh_tipo_clasificacion_conceptonomina`\n    ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)\n  INNER JOIN `rh_concepto_agrupacion_informe_cgr`\n    ON (`rh_nomina_conceptos`.`IdClasificacionCgr` = `rh_concepto_agrupacion_informe_cgr`.`Id`)\n   LEFT JOIN `rh_clasificacion_concepto_nominae`\n   ON (`rh_clasificacion_concepto_nominae`.`id` =rh_nomina_conceptos.`Id_ClasificacionNominaE` ) \nWHERE (`rh_nomina_conceptos`.Nbre LIKE '%" + this.JTFF_Nombre.getText() + "%')\nORDER BY `rh_nomina_conceptos`.Nbre";
            System.out.println(sql);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(11)), n, 10);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(12)), n, 11);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(13)), n, 12);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(14)), n, 13);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(15)), n, 14);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(16)), n, 15);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("ValorE")), n, 16);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("CPago")), n, 17);
                    this.xmodelo.setValueAt(xrs.getString("Clasificacion"), n, 18);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(20)), n, 19);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(21)), n, 20);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(22)), n, 21);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(23)), n, 22);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(24)), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("ValorBase")), n, 25);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("ValorBaseN")), n, 26);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("porcentajeDian")), n, 27);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("redondeo")), n, 28);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("topeSalarial")), n, 29);
                    this.xmodelo.setValueAt(xrs.getString("TipoTope"), n, 30);
                    this.xmodelo.setValueAt(xrs.getString("nombreConceptoE"), n, 31);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRHConceptosNomina.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1() {
        try {
            mCrearModeloDatos1();
            String sql = "SELECT rh_nomina_concepto_unidadf.Id, cc_unidad_funcional.Nbre, rh_nomina_concepto_unidadf.CDebito, rh_nomina_concepto_unidadf.CCredito, rh_nomina_concepto_unidadf.RPresupuesto, rh_nomina_concepto_unidadf.Estado FROM rh_nomina_concepto_unidadf INNER JOIN cc_unidad_funcional  ON (rh_nomina_concepto_unidadf.Id_UnidaFC = cc_unidad_funcional.Id) WHERE (rh_nomina_concepto_unidadf.Id_ConceptosN ='" + Principal.txtNo.getText() + "') ORDER BY cc_unidad_funcional.Nbre ASC ";
            System.out.println(sql);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRHConceptosNomina.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarCuentadebito() {
        if (!this.JTFCredito.getText().isEmpty()) {
            String sql = "SELECT `Nbre` FROM `p_cc_puc` WHERE (`Id` ='" + this.JTFCredito.getText() + "'AND `UNivel` =1 ); ";
            System.out.println(sql);
            ResultSet xrs = this.xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    this.JTFRCuentaC.setText(xrs.getString(1));
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Cuenta no Existe O no ES de Ultimo Nivel", "Consultar", 1);
                    this.JTFRCuentaC.setText(" ");
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRHConceptosNomina.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBuscarCuentacredito() {
        if (!this.JTFCredito.getText().isEmpty()) {
            String sql = "SELECT `Nbre` FROM `p_cc_puc` WHERE (`Id` ='" + this.JTFCredito.getText() + "'AND `UNivel` =1 ); ";
            System.out.println(sql);
            ResultSet xrs = this.xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    this.JTFRCuentaC.setText(xrs.getString(1));
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Cuenta no Existe O no ES de Ultimo Nivel", "Consultar", 1);
                    this.JTFRCuentaC.setText(" ");
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRHConceptosNomina.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBuscarrubro() {
        String sql = "SELECT `pp_rubros`.`Nbre` , `pp_rubros`.`UltNivel` , `pp_rubros_encabezado`.`id` FROM `pp_rubros` INNER JOIN `pp_rubros_encabezado` ON (`pp_rubros`.`idEncabezadoRubro` = `pp_rubros_encabezado`.`id`) AND (pp_rubros_encabezado.`estado`=1)\nWHERE (`pp_rubros`.`Id` ='" + this.JTFRPresupuesto.getText() + "' AND `pp_rubros`.`UltNivel` =1);";
        System.out.println(sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                this.JTFRRubro.setText(xrs.getString(1));
            } else {
                JOptionPane.showInternalMessageDialog(this, "Rubro no Existe O no ES de Ultimo Nivel", "Consultar", 1);
                this.JTFRRubro.setText(" ");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRHConceptosNomina.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
