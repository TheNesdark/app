package RecursosHumanos;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIF_Nomina_Causacion.class */
public class JIF_Nomina_Causacion extends JInternalFrame {
    public DefaultTableModel xModeloH;
    public DefaultTableModel xModeloN;
    private String xsql;
    public String[][] xPeriodo;
    public String[][] xId_PeriodoPresupuestal;
    private Object[] xdatos;
    private String[] xId_TDocContable;
    private String[] xId_PeriodoContable;
    private String[] xId_DocObligacion;
    private String[] xId_DocCompromiso;
    private String[] xIdUnidadF;
    private String[] xId_Disponibilidad;
    private String[] xIdClasificacion;
    private String[] xIdConceptoNomina;
    private WorkerSQL xWorkerSQL;
    private JButton JBTActualizarCo1;
    private JButton JBTExportar;
    private JButton JBTGenerarDocPpt;
    private JComboBox JCBClasificacion;
    private JComboBox JCBConceptosNomina;
    private JComboBox JCBPeriodoC;
    public JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBTipoC;
    private JComboBox JCBTipoDoc_Compromiso;
    private JComboBox JCBTipoDoc_Disponibilidad;
    private JComboBox JCBTipoDoc_Obligacion;
    private JComboBox JCB_UndadFuncional;
    private JCheckBox JCHFiltroClasificacion;
    private JCheckBox JCHFiltroConceptosNomina;
    private JCheckBox JCHFiltroUnidadF;
    private JCheckBox JCHSeleccionar;
    private JCheckBox JCH_Disponibilidad;
    private JCheckBox JCH_SeleccionarT;
    private JDateChooser JDCFechaDPresupuesto;
    private JDateChooser JDCFechaInicio;
    private JLabel JLBIdLiquidacion;
    private JLabel JLB_Periodo;
    private JPanel JPIDContables1;
    private JPanel JPID_Contable;
    private JPanel JPID_Exportar;
    private JPanel JPI_Historico;
    private JPanel JPI_NNomina;
    private JScrollPane JSP_Historico;
    private JScrollPane JSP_NNomina;
    private JTabbedPane JTB_DatosM;
    public JTable JTB_Historico;
    public JTable JTB_NNomina;
    private JFormattedTextField JTFFNDisponibilidad;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Datos;
    private JYearChooser JY_HAno;
    private JButton jButton1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xlleno2 = false;
    public String xId_Compromiso = "0";
    public String xId_DocContable = "0";
    public String xId_DocPptom = "0";
    public String xId_DisponibilidadC = "0";
    private long xConsecutivo = 0;
    private long xConsecutivo_Obligacion = 0;
    private long xFomaA = -1;
    private long xIdNomina = 0;

    public JIF_Nomina_Causacion() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v155, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_Datos = new JTabbedPane();
        this.JPI_NNomina = new JPanel();
        this.JSP_NNomina = new JScrollPane();
        this.JTB_NNomina = new JTable();
        this.JTB_DatosM = new JTabbedPane();
        this.JPID_Contable = new JPanel();
        this.JCBPeriodoC = new JComboBox();
        this.JCBTipoC = new JComboBox();
        this.JLBIdLiquidacion = new JLabel();
        this.JLB_Periodo = new JLabel();
        this.JPIDContables1 = new JPanel();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDoc_Compromiso = new JComboBox();
        this.JCBTipoDoc_Obligacion = new JComboBox();
        this.JTFFNDisponibilidad = new JFormattedTextField();
        this.JCBTipoDoc_Disponibilidad = new JComboBox();
        this.JCH_Disponibilidad = new JCheckBox();
        this.JDCFechaDPresupuesto = new JDateChooser();
        this.JBTActualizarCo1 = new JButton();
        this.JBTGenerarDocPpt = new JButton();
        this.JCH_SeleccionarT = new JCheckBox();
        this.jButton1 = new JButton();
        this.JPID_Exportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCHSeleccionar = new JCheckBox();
        this.JCB_UndadFuncional = new JComboBox();
        this.JCHFiltroUnidadF = new JCheckBox();
        this.JDCFechaInicio = new JDateChooser();
        this.JCBClasificacion = new JComboBox();
        this.JCHFiltroClasificacion = new JCheckBox();
        this.JCBConceptosNomina = new JComboBox();
        this.JCHFiltroConceptosNomina = new JCheckBox();
        this.JPI_Historico = new JPanel();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        this.JY_HAno = new JYearChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("CAUSACIÓN DE NOMINA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_causacion_nomina");
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JSP_NNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_NNomina.setFont(new Font("Arial", 1, 12));
        this.JTB_NNomina.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_NNomina.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_NNomina.setSelectionForeground(Color.red);
        this.JTB_NNomina.addPropertyChangeListener(new PropertyChangeListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Nomina_Causacion.this.JTB_NNominaPropertyChange(evt);
            }
        });
        this.JTB_NNomina.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIF_Nomina_Causacion.2
            public void keyTyped(KeyEvent evt) {
                JIF_Nomina_Causacion.this.JTB_NNominaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIF_Nomina_Causacion.this.JTB_NNominaKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIF_Nomina_Causacion.this.JTB_NNominaKeyReleased(evt);
            }
        });
        this.JSP_NNomina.setViewportView(this.JTB_NNomina);
        this.JTB_DatosM.setForeground(Color.red);
        this.JTB_DatosM.setFont(new Font("Arial", 1, 14));
        this.JPID_Contable.setBorder(BorderFactory.createEtchedBorder());
        this.JCBPeriodoC.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBIdLiquidacion.setBackground(new Color(255, 255, 255));
        this.JLBIdLiquidacion.setFont(new Font("Arial", 1, 14));
        this.JLBIdLiquidacion.setForeground(Color.red);
        this.JLBIdLiquidacion.setHorizontalAlignment(0);
        this.JLBIdLiquidacion.setBorder(BorderFactory.createTitledBorder((Border) null, "No.Liquidacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_Periodo.setBackground(new Color(255, 255, 255));
        this.JLB_Periodo.setFont(new Font("Arial", 1, 14));
        this.JLB_Periodo.setForeground(Color.red);
        this.JLB_Periodo.setHorizontalAlignment(0);
        this.JLB_Periodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPID_ContableLayout = new GroupLayout(this.JPID_Contable);
        this.JPID_Contable.setLayout(JPID_ContableLayout);
        JPID_ContableLayout.setHorizontalGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ContableLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPeriodoC, -2, 350, -2).addGap(18, 18, 18).addComponent(this.JCBTipoC, -2, 350, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_Periodo, -1, 217, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBIdLiquidacion, -2, 160, -2).addGap(17, 17, 17)));
        JPID_ContableLayout.setVerticalGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ContableLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Periodo, -2, 50, -2).addComponent(this.JLBIdLiquidacion, -2, 50, -2).addGroup(JPID_ContableLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodoC, -2, 50, -2).addComponent(this.JCBTipoC, -2, 50, -2))).addContainerGap(470, 32767)));
        this.JTB_DatosM.addTab("DATOS CONTABLES", this.JPID_Contable);
        this.JCBPeriodo_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Compromiso.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Compromiso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento (Compromisos)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc_Obligacion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Obligacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento (Obligación)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDisponibilidad.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDisponibilidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDisponibilidad.setHorizontalAlignment(0);
        this.JTFFNDisponibilidad.setText("0");
        this.JTFFNDisponibilidad.setFont(new Font("Arial", 1, 18));
        this.JTFFNDisponibilidad.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JTFFNDisponibilidadActionPerformed(evt);
            }
        });
        this.JCBTipoDoc_Disponibilidad.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc_Disponibilidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Disponibilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Disponibilidad.setFont(new Font("Arial", 1, 12));
        this.JCH_Disponibilidad.setSelected(true);
        this.JCH_Disponibilidad.setText("Generar Disponibilidad");
        this.JDCFechaDPresupuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaDPresupuesto.setToolTipText("Fecha para disponibilidad y compromiso");
        this.JDCFechaDPresupuesto.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaDPresupuesto.setFont(new Font("Arial", 1, 12));
        this.JBTActualizarCo1.setFont(new Font("Arial", 1, 12));
        this.JBTActualizarCo1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTActualizarCo1.setText("<html><P ALIGN=center>Validacion Presupuestal");
        this.JBTActualizarCo1.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.4
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JBTActualizarCo1ActionPerformed(evt);
            }
        });
        this.JBTGenerarDocPpt.setFont(new Font("Arial", 1, 12));
        this.JBTGenerarDocPpt.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGenerarDocPpt.setText("<html><P ALIGN=center>Generar Documentos");
        this.JBTGenerarDocPpt.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JBTGenerarDocPptActionPerformed(evt);
            }
        });
        this.JCH_SeleccionarT.setFont(new Font("Arial", 1, 12));
        this.JCH_SeleccionarT.setText("Seleccionar");
        this.JCH_SeleccionarT.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JCH_SeleccionarTActionPerformed(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.jButton1.setText("Buscar Solicitud");
        this.jButton1.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDContables1Layout = new GroupLayout(this.JPIDContables1);
        this.JPIDContables1.setLayout(JPIDContables1Layout);
        JPIDContables1Layout.setHorizontalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addComponent(this.JCBPeriodo_Ppt, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDoc_Disponibilidad, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, 32767).addComponent(this.JCBTipoDoc_Compromiso, -2, 250, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDoc_Obligacion, -2, 250, -2).addGap(18, 18, 18).addComponent(this.JTFFNDisponibilidad, -2, 140, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addComponent(this.JDCFechaDPresupuesto, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Disponibilidad).addGap(18, 18, 18).addComponent(this.jButton1, -2, 175, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTActualizarCo1, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerarDocPpt, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_SeleccionarT))).addContainerGap()));
        JPIDContables1Layout.setVerticalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContables1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDoc_Compromiso, -2, 50, -2).addComponent(this.JCBTipoDoc_Obligacion, -2, 50, -2).addComponent(this.JTFFNDisponibilidad).addComponent(this.JCBTipoDoc_Disponibilidad, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTActualizarCo1, -2, 48, -2).addComponent(this.JCH_Disponibilidad).addComponent(this.JBTGenerarDocPpt, -2, 48, -2).addComponent(this.JCH_SeleccionarT).addComponent(this.jButton1, -2, 48, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addComponent(this.JDCFechaDPresupuesto, -2, -1, -2).addContainerGap()))));
        this.JTB_DatosM.addTab("DATOS PRESUPUESTALES", this.JPIDContables1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIF_Nomina_Causacion.8
            public void mouseClicked(MouseEvent evt) {
                JIF_Nomina_Causacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.9
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todo?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.10
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout JPID_ExportarLayout = new GroupLayout(this.JPID_Exportar);
        this.JPID_Exportar.setLayout(JPID_ExportarLayout);
        JPID_ExportarLayout.setHorizontalGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPID_ExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 825, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHSeleccionar).addContainerGap(-1, 32767)));
        JPID_ExportarLayout.setVerticalGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_ExportarLayout.createSequentialGroup().addContainerGap(31, 32767).addComponent(this.JCHSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPID_ExportarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -1, 50, 32767)).addContainerGap()));
        this.JTB_DatosM.addTab("EXPORTAR", this.JPID_Exportar);
        this.JCB_UndadFuncional.setFont(new Font("Arial", 1, 12));
        this.JCB_UndadFuncional.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_UndadFuncional.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.11
            public void itemStateChanged(ItemEvent evt) {
                JIF_Nomina_Causacion.this.JCB_UndadFuncionalItemStateChanged(evt);
            }
        });
        this.JCB_UndadFuncional.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.12
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JCB_UndadFuncionalActionPerformed(evt);
            }
        });
        this.JCHFiltroUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroUnidadF.setText("Filtro");
        this.JCHFiltroUnidadF.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.13
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JCHFiltroUnidadFActionPerformed(evt);
            }
        });
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Conceptos de Nómina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasificacion.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.14
            public void itemStateChanged(ItemEvent evt) {
                JIF_Nomina_Causacion.this.JCBClasificacionItemStateChanged(evt);
            }
        });
        this.JCHFiltroClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroClasificacion.setText("Filtro");
        this.JCHFiltroClasificacion.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.15
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JCHFiltroClasificacionActionPerformed(evt);
            }
        });
        this.JCBConceptosNomina.setFont(new Font("Arial", 1, 12));
        this.JCBConceptosNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "Conceptos de Nómina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptosNomina.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.16
            public void itemStateChanged(ItemEvent evt) {
                JIF_Nomina_Causacion.this.JCBConceptosNominaItemStateChanged(evt);
            }
        });
        this.JCHFiltroConceptosNomina.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroConceptosNomina.setText("Filtro");
        this.JCHFiltroConceptosNomina.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.17
            public void actionPerformed(ActionEvent evt) {
                JIF_Nomina_Causacion.this.JCHFiltroConceptosNominaActionPerformed(evt);
            }
        });
        GroupLayout JPI_NNominaLayout = new GroupLayout(this.JPI_NNomina);
        this.JPI_NNomina.setLayout(JPI_NNominaLayout);
        JPI_NNominaLayout.setHorizontalGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_NNominaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTB_DatosM, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPI_NNominaLayout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_UndadFuncional, -2, 266, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltroUnidadF).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBClasificacion, -2, 225, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltroClasificacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBConceptosNomina, -2, 225, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltroConceptosNomina).addGap(0, 0, 32767))).addContainerGap()).addGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_NNominaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSP_NNomina, -2, 1148, -2).addContainerGap(-1, 32767))));
        JPI_NNominaLayout.setVerticalGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NNominaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_UndadFuncional, -2, 50, -2).addComponent(this.JCHFiltroUnidadF)).addComponent(this.JDCFechaInicio, -2, -1, -2).addGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBClasificacion, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPI_NNominaLayout.createSequentialGroup().addGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConceptosNomina, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPI_NNominaLayout.createSequentialGroup().addComponent(this.JCHFiltroConceptosNomina).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1, -2))).addComponent(this.JCHFiltroClasificacion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 466, 32767).addComponent(this.JTB_DatosM, -2, 167, -2).addContainerGap()).addGroup(JPI_NNominaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_NNominaLayout.createSequentialGroup().addContainerGap(61, 32767).addComponent(this.JSP_NNomina, -2, 448, -2).addContainerGap(187, 32767))));
        this.JTP_Datos.addTab("NOMINA", this.JPI_NNomina);
        this.JSP_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Historico.setSelectionForeground(Color.red);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIF_Nomina_Causacion.18
            public void mouseClicked(MouseEvent evt) {
                JIF_Nomina_Causacion.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        this.JY_HAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JY_HAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: RecursosHumanos.JIF_Nomina_Causacion.19
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Nomina_Causacion.this.JY_HAnoPropertyChange(evt);
            }
        });
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Historico, -1, 1148, 32767).addGroup(JPI_HistoricoLayout.createSequentialGroup().addComponent(this.JY_HAno, -2, 87, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JY_HAno, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JSP_Historico, -1, 596, 32767).addContainerGap()));
        this.JTP_Datos.addTab("HÍSTORICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos, -2, 723, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_Historico.getSelectedRow() != -1) {
            this.JCHFiltroClasificacion.setSelected(false);
            this.JCHFiltroUnidadF.setSelected(false);
            mCargar_Nomina();
            mLlenarCombo_Unid();
            this.xIdNomina = Long.valueOf(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString()).longValue();
            this.JLBIdLiquidacion.setText(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString());
            this.JLB_Periodo.setText(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 3).toString());
            this.JTP_Datos.setSelectedIndex(0);
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTP_Datos.getSelectedIndex() == 0) {
            if (this.JTB_NNomina.getRowCount() != -1) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_NNomina, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle() + " - NOMINA");
            }
        } else if (this.JTB_Historico.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Historico, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle() + " - HISTORICO");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroUnidadFActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroUnidadF.isSelected()) {
            if (this.JCB_UndadFuncional.getSelectedIndex() != -1 && this.xlleno1) {
                mCargar_Nomina();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCB_UndadFuncional.requestFocus();
                return;
            }
        }
        mCargar_Nomina();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroClasificacionActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroClasificacion.isSelected()) {
            if (this.JCBClasificacion.getSelectedIndex() != -1 && this.xlleno1) {
                mCargar_Nomina();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Clasificacion de Concepto Nomina", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBClasificacion.requestFocus();
                return;
            }
        }
        mCargar_Nomina();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClasificacionItemStateChanged(ItemEvent evt) {
        if (this.JCBClasificacion.getSelectedIndex() != -1 && this.xlleno1 && this.JCHFiltroClasificacion.isSelected() && this.JTB_Historico.getSelectedRow() != -1) {
            mCargar_Nomina();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_UndadFuncionalItemStateChanged(ItemEvent evt) {
        if (this.JCB_UndadFuncional.getSelectedIndex() != -1 && this.xlleno1 && this.JCHFiltroUnidadF.isSelected() && this.JTB_Historico.getSelectedRow() != -1) {
            mCargar_Nomina();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            mActivarDesactivar(true);
        } else {
            mActivarDesactivar(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarCo1ActionPerformed(ActionEvent evt) {
        if (this.JTB_NNomina.getRowCount() != -1 && this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
            JD_ValidacionN dialog = new JD_ValidacionN(null, true, this);
            dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
            dialog.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_NNominaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarDocPptActionPerformed(ActionEvent evt) {
        if (this.JTB_NNomina.getRowCount() != -1) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTB_NNomina, 27)) {
                mGrabarMovPresupeustoAdicional();
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar items de la tabla para generar el documento", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SeleccionarTActionPerformed(ActionEvent evt) {
        if (this.JCH_SeleccionarT.isSelected()) {
            this.JCH_SeleccionarT.setText("Quitar Selección");
            mRecorrerTabla();
        } else {
            this.JCH_SeleccionarT.setText("Seleccionar Todo");
            mRecorrerTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JY_HAnoPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargar_DHistorico();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_NNominaKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if ((evt.getKeyCode() == 10 || evt.getKeyCode() == 18) && this.JTB_NNomina.getSelectedRow() != -1) {
            if (this.JTB_NNomina.getSelectedColumn() == 4 || this.JTB_NNomina.getSelectedColumn() == 5 || this.JTB_NNomina.getSelectedColumn() == 6 || this.JTB_NNomina.getSelectedColumn() == 8 || this.JTB_NNomina.getSelectedColumn() == 9 || this.JTB_NNomina.getSelectedColumn() == 10) {
                if (this.JTB_NNomina.isEditing()) {
                    this.JTB_NNomina.getCellEditor().stopCellEditing();
                }
                if (Integer.valueOf(this.xModeloN.getValueAt(this.JTB_NNomina.getSelectedRow(), 13).toString()).intValue() == 0) {
                    mActualizarFila(this.JTB_NNomina.getSelectedRow());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_NNominaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_NNominaKeyReleased(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if ((evt.getKeyCode() == 10 || evt.getKeyCode() == 18) && this.JTB_NNomina.getSelectedRow() != -1) {
            if (this.JTB_NNomina.getSelectedColumn() == 4 || this.JTB_NNomina.getSelectedColumn() == 5 || this.JTB_NNomina.getSelectedColumn() == 6 || this.JTB_NNomina.getSelectedColumn() == 8 || this.JTB_NNomina.getSelectedColumn() == 9 || this.JTB_NNomina.getSelectedColumn() == 10) {
                if (this.JTB_NNomina.isEditing()) {
                    this.JTB_NNomina.getCellEditor().stopCellEditing();
                }
                if (Integer.valueOf(this.xModeloN.getValueAt(this.JTB_NNomina.getSelectedRow(), 13).toString()).intValue() == 0) {
                    this.xModeloN.setValueAt(true, this.JTB_NNomina.getSelectedRow(), 26);
                    mActualizarFila(this.JTB_NNomina.getSelectedRow());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNDisponibilidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptosNominaItemStateChanged(ItemEvent evt) {
        if (this.JCBConceptosNomina.getSelectedIndex() != -1 && this.xlleno1 && this.JCHFiltroConceptosNomina.isSelected() && this.JTB_Historico.getSelectedRow() != -1) {
            mCargar_Nomina();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroConceptosNominaActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroConceptosNomina.isSelected()) {
            if (this.JCBConceptosNomina.getSelectedIndex() != -1 && this.xlleno1) {
                mCargar_Nomina();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Concepto Nomina", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBConceptosNomina.requestFocus();
                return;
            }
        }
        mCargar_Nomina();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_UndadFuncionalActionPerformed(ActionEvent evt) {
    }

    private void mRecorrerTabla() {
        if (this.JTB_NNomina.getRowCount() > 0) {
            for (int i = 0; i < this.JTB_NNomina.getRowCount(); i++) {
                if (this.JCH_SeleccionarT.isSelected()) {
                    this.xModeloN.setValueAt(true, i, 27);
                } else {
                    this.xModeloN.setValueAt(false, i, 27);
                }
            }
        }
    }

    public void mBtnActualizar() {
        mActulizarDatos();
        mCargar_Nomina();
    }

    private void mActivarDesactivar(boolean estado) {
        if (this.JTB_NNomina.getRowCount() > 0) {
            for (int x = 0; x < this.JTB_NNomina.getRowCount(); x++) {
                this.xModeloN.setValueAt(Boolean.valueOf(estado), x, 11);
            }
        }
    }

    private void mActulizarDatos() {
        for (int i = 0; i < this.JTB_NNomina.getRowCount(); i++) {
            if (Boolean.valueOf(this.xModeloN.getValueAt(i, 26).toString()).booleanValue()) {
                System.out.println("Liquidacion: " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0));
                System.out.println("IDPersonaC: " + this.JTB_NNomina.getValueAt(i, 12).toString());
                System.out.println("IDConcepto: " + this.JTB_NNomina.getValueAt(i, 23).toString());
                String sql = "update rh_nomina_liquidacion_detalle set  VDevengado='" + Double.valueOf(this.JTB_NNomina.getValueAt(i, 4).toString()) + "', VDeducido='" + Double.valueOf(this.JTB_NNomina.getValueAt(i, 5).toString()) + "', TValorE='" + Double.valueOf(this.JTB_NNomina.getValueAt(i, 6).toString()) + "', RPresupuestal='" + this.JTB_NNomina.getValueAt(i, 10).toString() + "' where Id_Liquidacion='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "' AND Id_PersonaC='" + Integer.valueOf(this.JTB_NNomina.getValueAt(i, 12).toString()) + "' AND Id_ConceptoCN ='" + Integer.valueOf(this.JTB_NNomina.getValueAt(i, 23).toString()) + "'";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    private void mActualizarFila(int xNFila) {
        String sql = "update rh_nomina_liquidacion_detalle set  VDevengado='" + Double.valueOf(this.JTB_NNomina.getValueAt(xNFila, 4).toString()) + "', VDeducido='" + Double.valueOf(this.JTB_NNomina.getValueAt(xNFila, 5).toString()) + "', TValorE='" + Double.valueOf(this.JTB_NNomina.getValueAt(xNFila, 6).toString()) + "', CDebito='" + this.JTB_NNomina.getValueAt(xNFila, 8).toString() + "', CCredito='" + this.JTB_NNomina.getValueAt(xNFila, 9).toString() + "', RPresupuestal='" + this.JTB_NNomina.getValueAt(xNFila, 10).toString() + "' where Id_Liquidacion='" + this.JTB_NNomina.getValueAt(xNFila, 28).toString() + "' AND Id_PersonaC='" + Integer.valueOf(this.JTB_NNomina.getValueAt(xNFila, 12).toString()) + "' AND Id_ConceptoCN ='" + Integer.valueOf(this.JTB_NNomina.getValueAt(xNFila, 23).toString()) + "'";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    public void mNuevo() {
        this.xIdNomina = 0L;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            this.JBTActualizarCo1.setEnabled(true);
            this.JBTGenerarDocPpt.setEnabled(true);
        } else {
            this.JBTActualizarCo1.setEnabled(false);
            this.JBTGenerarDocPpt.setEnabled(false);
        }
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaDPresupuesto.setDate(this.xmt.getFechaActual());
        this.JCHFiltroClasificacion.setSelected(false);
        this.JCHFiltroUnidadF.setSelected(false);
        this.JCBClasificacion.removeAllItems();
        this.JCB_UndadFuncional.removeAllItems();
        mCargar_DHistorico();
        mCrearModelo_Nomina();
        mLlenarCombo();
    }

    public void mBuscar() {
        if (this.JTP_Datos.getSelectedIndex() == 1) {
            mCargar_DHistorico();
        } else {
            mCargar_Nomina();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_DHistorico() {
        this.xModeloH = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Observación", "Período", "FechaI", "FechaF", "Neto", "TDevengado", "TDeducido", "Cerrado?"}) { // from class: RecursosHumanos.JIF_Nomina_Causacion.20
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Historico.setModel(this.xModeloH);
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(9).setPreferredWidth(0);
    }

    private void mCrearModelo_Nomina() {
        this.xModeloN = new DefaultTableModel() { // from class: RecursosHumanos.JIF_Nomina_Causacion.21
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Long.class, String.class, String.class, String.class, Boolean.class, Long.class, Long.class, Long.class, Long.class, Long.class, Double.class, String.class, String.class, String.class, Long.class, Boolean.class, Long.class, String.class, Long.class, Boolean.class, Boolean.class, Long.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, true, true, true, false, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xModeloN.addColumn("Documento");
        this.xModeloN.addColumn("Empleado");
        this.xModeloN.addColumn("Cargo");
        this.xModeloN.addColumn("Concepto");
        this.xModeloN.addColumn("VDevengado");
        this.xModeloN.addColumn("VDeducido");
        this.xModeloN.addColumn("VEmpresa");
        this.xModeloN.addColumn("Id_tercero");
        this.xModeloN.addColumn("CDebito");
        this.xModeloN.addColumn("CCredito");
        this.xModeloN.addColumn("RPresupuesto");
        this.xModeloN.addColumn("I");
        this.xModeloN.addColumn("Id_Persona");
        this.xModeloN.addColumn("DocContable");
        this.xModeloN.addColumn("Id_Compromiso");
        this.xModeloN.addColumn("Id_Obligacion");
        this.xModeloN.addColumn("Id_Concepto");
        this.xModeloN.addColumn("Neto");
        this.xModeloN.addColumn("Documento");
        this.xModeloN.addColumn("Clasificacion");
        this.xModeloN.addColumn("DoCumento");
        this.xModeloN.addColumn("Id_Clasificacion");
        this.xModeloN.addColumn("CSalario");
        this.xModeloN.addColumn("NConceptoxUnidadf");
        this.xModeloN.addColumn("Tercero Movimiento");
        this.xModeloN.addColumn("Id_ConceptoCN");
        this.xModeloN.addColumn("ValidacionR");
        this.xModeloN.addColumn("Generación");
        this.xModeloN.addColumn("IdNomina");
        this.xModeloN.addColumn("correo Electronico");
        this.xModeloN.addColumn("idClasificacionDIan");
        this.JTB_NNomina.setAutoResizeMode(0);
        this.JTB_NNomina.doLayout();
        this.JTB_NNomina.setModel(this.xModeloN);
        this.JTB_NNomina.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_NNomina.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTB_NNomina.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTB_NNomina.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTB_NNomina.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTB_NNomina.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTB_NNomina.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTB_NNomina.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTB_NNomina.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTB_NNomina.getColumnModel().getColumn(19).setPreferredWidth(200);
        this.JTB_NNomina.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTB_NNomina.getColumnModel().getColumn(25).setPreferredWidth(20);
        this.JTB_NNomina.getColumnModel().getColumn(26).setPreferredWidth(80);
        this.JTB_NNomina.getColumnModel().getColumn(27).setPreferredWidth(80);
        this.JTB_NNomina.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(29).setPreferredWidth(200);
        this.JTB_NNomina.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTB_NNomina.getColumnModel().getColumn(30).setMaxWidth(0);
    }

    private void mCargar_DHistorico() {
        try {
            mCrearModelo_DHistorico();
            this.xsql = "SELECT  `rh_nomina_liquidacion`.`Id` , DATE_FORMAT(`rh_nomina_liquidacion`.`FechaR`,'%d-%m-%Y') AS FRealizacion\n    , `rh_nomina_liquidacion`.`Observacion`\n    , CONCAT(`rh_nomina_periodo`.`Nbre`,' ',`rh_nomina_liquidacion`.`Ano`) AS `Periodo`\n    , CONCAT(`rh_nomina_periodo`.`Del` ,'-',`rh_nomina_liquidacion`.`Ano`) AS `FechaI`\n    , CONCAT(`rh_nomina_periodo`.`Al`,'-',`rh_nomina_liquidacion`.`Ano`) AS `FechaF`\n    ,(SUM(`rh_nomina_liquidacion_detalle`.`VDevengado`)-SUM(`rh_nomina_liquidacion_detalle`.`VDeducido`)) AS TotalN\n    , SUM(`rh_nomina_liquidacion_detalle`.`VDevengado`) AS `VDevengado`\n    , SUM(`rh_nomina_liquidacion_detalle`.`VDeducido`) AS `VDeducido`\n    , rh_nomina_liquidacion.Cerrada\nFROM\n    `rh_nomina_liquidacion_detalle`\n    INNER JOIN `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN `rh_nomina_periodo` \n        ON (`rh_nomina_liquidacion`.`Id_Periodo` = `rh_nomina_periodo`.`Id`)\nWHERE (`rh_nomina_liquidacion`.`Estado` =1 AND `rh_nomina_liquidacion`.`Ano`='" + this.JY_HAno.getValue() + "')\nGROUP BY `rh_nomina_liquidacion`.`Id` ORDER BY `rh_nomina_liquidacion`.`FechaR`  DESC \n";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_Historico, 2);
                while (xrs.next()) {
                    this.xModeloH.addRow(this.xdatos);
                    this.xModeloH.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xModeloH.setValueAt(xrs.getString(2), n, 1);
                    this.xModeloH.setValueAt(xrs.getString(3), n, 2);
                    this.xModeloH.setValueAt(xrs.getString(4), n, 3);
                    this.xModeloH.setValueAt(xrs.getString(5), n, 4);
                    this.xModeloH.setValueAt(xrs.getString(6), n, 5);
                    this.xModeloH.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xModeloH.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 7);
                    this.xModeloH.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xModeloH.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Nomina_Causacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargar_Nomina() {
        try {
            mCrearModelo_Nomina();
            if (Principal.informacionIps.getIdentificacion().equals("812001219")) {
                this.xsql = "with maestra as (\nSELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion` ,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `Empleado`\n    , `rh_tipo_cargo`.`Nbre` AS `Cargo`\n    , `rh_nomina_conceptos`.`Nbre` nombreConcepto\n    , `rh_nomina_liquidacion_detalle`.`VDevengado`\n    , `rh_nomina_liquidacion_detalle`.`VDeducido`\n    , `rh_nomina_liquidacion_detalle`.`TValorE`\n    , `rh_nomina_liquidacion_detalle`.`Id_Tercero`\n    , TRIM(ifnull(`cc_puc`.`Id`,''))CDebito\n    , TRIM(ifnull(`cc_puc1`.`Id`,'')) CCredito\n    , TRIM(`rh_nomina_liquidacion_detalle`.RPresupuestal) `RPresupuesto`\n    , FALSE filtroEstado\n    , `rh_tipo_persona_cargon`.`Id` idPersonaCargo\n    , rh_nomina_conceptos.`Id` idConcepto\n    ,  0 as NetoP, `rh_nomina_liquidacion_detalle`.`Id_DocContable`\n    , `rh_nomina_liquidacion_detalle`.`Id_Compromiso`\n    , `rh_nomina_liquidacion_detalle`.`Id_Obligacion`\n    , `g_persona`.`NoDocumento`\n    , rh_tipo_clasificacion_conceptonomina.`Nbre` AS Concepto, cc_terceros.`TDCompleto2`\n    , rh_tipo_clasificacion_conceptonomina.Id idConceptoNomina\n    ,if(rccn.id=1, true, false ) CSalario  \n,  ROUND(`rh_nomina_liquidacion_detalle`.`VDeducido`+ `rh_nomina_liquidacion_detalle`.`TValorE`) VRedondeo\n, rh_nomina_concepto_unidadf.`Id` AS Conceptoxunidad \n, IF(rh_nomina_conceptos.`MTercero`=1,cc_terceros.`RazonSocialCompleta`, '') TerceroP\n, rh_nomina_liquidacion_detalle.Id_ConceptoCN\n, IF(`rh_nomina_liquidacion_detalle`.`Id_DocContable`=0,FALSE,TRUE) AS validacion\n, `rh_nomina_liquidacion`.`Id` IdNomina  \n, rh_nomina_conceptos.NOrden, g_persona.Correo correo, rh_nomina_conceptos.Id_ClasificacionNominaE  \nFROM\n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_tipo_persona_cargon` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `rh_unidadf_cargo` \n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.Id_ConceptosN  = `rh_nomina_conceptos`.`Id`)\n    INNER JOIN  `rh_unidad_funcional` \n        ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`) \n inner join rh_clasificacion_concepto_nominae rccn  on (rccn.id=rh_nomina_conceptos.Id_ClasificacionNominaE)  \n    INNER JOIN  `rh_tipo_cargo` \n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN  `rh_tipo_clasificacion_conceptonomina` \n        ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)  INNER JOIN  `cc_terceros`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_terceros`.`Id`)\nleft JOIN  `cc_puc`\n        ON (`rh_nomina_liquidacion_detalle`.`CDebito` = `cc_puc`.`Id`)\nleft JOIN  `cc_puc` as cc_puc1\n        ON (`rh_nomina_liquidacion_detalle`.`CCredito` = `cc_puc1`.`Id`)\n        WHERE rh_nomina_liquidacion.`Id`='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "'\n";
                if (this.JCHFiltroUnidadF.isSelected()) {
                    this.xsql += "AND `rh_unidad_funcional`.`Id`='" + this.xIdUnidadF[this.JCB_UndadFuncional.getSelectedIndex()] + "'\n";
                }
                if (this.JCHFiltroClasificacion.isSelected()) {
                    this.xsql += "AND rh_tipo_clasificacion_conceptonomina.`Id`='" + this.xIdClasificacion[this.JCBClasificacion.getSelectedIndex()] + "'\n";
                }
                if (this.JCHFiltroConceptosNomina.isSelected()) {
                    this.xsql += "AND rh_nomina_conceptos.Id ='" + this.xIdConceptoNomina[this.JCBConceptosNomina.getSelectedIndex()] + "'\n";
                }
                this.xsql += " and rh_nomina_conceptos.contabilizar=1 \n        ORDER BY `Empleado` ASC, rh_nomina_conceptos.NOrden asc\n),\nvalorDevengado AS (\nSELECT\n    SUM(`VDevengado`) AS devengado\n    , `rh_nomina_liquidacion_detalle`.`Id_PersonaC` idPersona\n    \nFROM\n    `rh_nomina_liquidacion_detalle`\n    INNER JOIN `rh_nomina_concepto_unidadf`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.Id_ConceptosN  = `rh_nomina_conceptos`.`Id`)    \nWHERE (`rh_nomina_conceptos`.`contabilizar` =1 and rh_nomina_conceptos.Id_ClasificacionNominaE =1      AND `rh_nomina_liquidacion_detalle`.`Id_Liquidacion` ='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "')\nGROUP BY `rh_nomina_liquidacion_detalle`.`Id_PersonaC`\n)\n, valorDeducido AS (\nSELECT\n   SUM(`VDeducido`) AS deducido\n    , `rh_nomina_liquidacion_detalle`.`Id_PersonaC` idPersona\n  \nFROM\n    `rh_nomina_liquidacion_detalle`\n    INNER JOIN `rh_nomina_concepto_unidadf`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.Id_ConceptosN  = `rh_nomina_conceptos`.`Id`)    \nWHERE (`rh_nomina_conceptos`.`contabilizar` =1\n    AND `rh_nomina_liquidacion_detalle`.`Id_Liquidacion` ='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "')\nGROUP BY `rh_nomina_liquidacion_detalle`.`Id_PersonaC`\n) \nSELECT \nm.`Documento`\n    , m.`Empleado`\n    , m.`Cargo`\n    , m.nombreConcepto\n    , m.`VDevengado`\n    , m.`VDeducido`\n    , m.`TValorE`\n    , m.`Id_Tercero`\n    , m.CDebito\n    , m.CCredito\n    , m.`RPresupuesto`\n    , m.filtroEstado\n    , m.idPersonaCargo\n    , m.idConcepto\n    , p.devengado-s.deducido NetoP\n    , m.`Id_DocContable`\n    , m.`Id_Compromiso`\n    , m.`Id_Obligacion`\n    , m.`NoDocumento`\n    , m.Concepto\n    , m.`TDCompleto2`\n    , m.idConceptoNomina\n    ,m.CSalario  \n,  m.VRedondeo\n, m.Conceptoxunidad \n, m.TerceroP\n, m.Id_ConceptoCN\n,m.validacion\n,m.IdNomina, m.correo, m.Id_ClasificacionNominaE  \nFROM maestra m \nLEFT JOIN valorDevengado p ON (p.idPersona =idPersonaCargo)\nLEFT JOIN valorDeducido s ON (s.idPersona =idPersonaCargo)\nORDER BY m.Empleado ASC, NOrden asc";
            } else {
                this.xsql = "with maestra as (\nSELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion` ,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `Empleado`\n    , `rh_tipo_cargo`.`Nbre` AS `Cargo`\n    , `rh_nomina_conceptos`.`Nbre` nombreConcepto\n    , `rh_nomina_liquidacion_detalle`.`VDevengado`\n    , `rh_nomina_liquidacion_detalle`.`VDeducido`\n    , `rh_nomina_liquidacion_detalle`.`TValorE`\n    , `rh_nomina_liquidacion_detalle`.`Id_Tercero`\n    , TRIM(ifnull(`cc_puc`.`Id`,''))CDebito\n    , TRIM(ifnull(`cc_puc1`.`Id`,'')) CCredito\n    , TRIM(`rh_nomina_liquidacion_detalle`.RPresupuestal) `RPresupuesto`\n    , FALSE filtroEstado\n    , `rh_tipo_persona_cargon`.`Id` idPersonaCargo\n    , rh_nomina_conceptos.`Id` idConcepto\n    ,  0 as NetoP, `rh_nomina_liquidacion_detalle`.`Id_DocContable`\n    , `rh_nomina_liquidacion_detalle`.`Id_Compromiso`\n    , `rh_nomina_liquidacion_detalle`.`Id_Obligacion`\n    , `g_persona`.`NoDocumento`\n    , rh_tipo_clasificacion_conceptonomina.`Nbre` AS Concepto, cc_terceros.`TDCompleto2`\n    , rh_tipo_clasificacion_conceptonomina.Id idConceptoNomina\n    ,if(rccn.id=1, true, false ) CSalario  \n,  ROUND(`rh_nomina_liquidacion_detalle`.`VDeducido`+ `rh_nomina_liquidacion_detalle`.`TValorE`) VRedondeo\n, rh_nomina_concepto_unidadf.`Id` AS Conceptoxunidad \n, IF(rh_nomina_conceptos.`MTercero`=1,cc_terceros.`RazonSocialCompleta`, '') TerceroP\n, rh_nomina_liquidacion_detalle.Id_ConceptoCN\n, IF(`rh_nomina_liquidacion_detalle`.`Id_DocContable`=0,FALSE,TRUE) AS validacion\n, `rh_nomina_liquidacion`.`Id` IdNomina  \n, rh_nomina_conceptos.NOrden, g_persona.Correo correo, rh_nomina_conceptos.Id_ClasificacionNominaE  \nFROM\n     `rh_nomina_liquidacion_detalle`\n    INNER JOIN  `rh_nomina_liquidacion` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)\n    INNER JOIN  `rh_tipo_persona_cargon` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN  `rh_nomina_concepto_unidadf` \n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `rh_unidadf_cargo` \n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN  `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.Id_ConceptosN  = `rh_nomina_conceptos`.`Id`)\n    INNER JOIN  `rh_unidad_funcional` \n        ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`) \n inner join rh_clasificacion_concepto_nominae rccn  on (rccn.id=rh_nomina_conceptos.Id_ClasificacionNominaE)  \n    INNER JOIN  `rh_tipo_cargo` \n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN  `rh_tipo_clasificacion_conceptonomina` \n        ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)  INNER JOIN  `cc_terceros`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_Tercero` = `cc_terceros`.`Id`)\nleft JOIN  `cc_puc`\n        ON (`rh_nomina_liquidacion_detalle`.`CDebito` = `cc_puc`.`Id`)\nleft JOIN  `cc_puc` as cc_puc1\n        ON (`rh_nomina_liquidacion_detalle`.`CCredito` = `cc_puc1`.`Id`)\n        WHERE rh_nomina_liquidacion.`Id`='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "'\n";
                if (this.JCHFiltroUnidadF.isSelected()) {
                    this.xsql += "AND `rh_unidad_funcional`.`Id`='" + this.xIdUnidadF[this.JCB_UndadFuncional.getSelectedIndex()] + "'\n";
                }
                if (this.JCHFiltroClasificacion.isSelected()) {
                    this.xsql += "AND rh_tipo_clasificacion_conceptonomina.`Id`='" + this.xIdClasificacion[this.JCBClasificacion.getSelectedIndex()] + "'\n";
                }
                if (this.JCHFiltroConceptosNomina.isSelected()) {
                    this.xsql += "AND rh_nomina_conceptos.Id ='" + this.xIdConceptoNomina[this.JCBConceptosNomina.getSelectedIndex()] + "'\n";
                }
                this.xsql += " and rh_nomina_conceptos.contabilizar=1 \n        ORDER BY `Empleado` ASC, rh_nomina_conceptos.NOrden asc\n),\nvalorDevengado AS (\nSELECT\n    SUM(`VDevengado`) AS devengado\n    , `rh_nomina_liquidacion_detalle`.`Id_PersonaC` idPersona\n    \nFROM\n    `rh_nomina_liquidacion_detalle`\n    INNER JOIN `rh_nomina_concepto_unidadf`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.Id_ConceptosN  = `rh_nomina_conceptos`.`Id`)    \nWHERE (`rh_nomina_conceptos`.`contabilizar` =1     AND `rh_nomina_liquidacion_detalle`.`Id_Liquidacion` ='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "')\nGROUP BY `rh_nomina_liquidacion_detalle`.`Id_PersonaC`\n)\n, valorDeducido AS (\nSELECT\n   SUM(`VDeducido`) AS deducido\n    , `rh_nomina_liquidacion_detalle`.`Id_PersonaC` idPersona\n  \nFROM\n    `rh_nomina_liquidacion_detalle`\n    INNER JOIN `rh_nomina_concepto_unidadf`\n        ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`)\n    INNER JOIN `rh_nomina_conceptos` \n        ON (`rh_nomina_concepto_unidadf`.Id_ConceptosN  = `rh_nomina_conceptos`.`Id`)    \nWHERE (`rh_nomina_conceptos`.`contabilizar` =1\n    AND `rh_nomina_liquidacion_detalle`.`Id_Liquidacion` ='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "')\nGROUP BY `rh_nomina_liquidacion_detalle`.`Id_PersonaC`\n) \nSELECT \nm.`Documento`\n    , m.`Empleado`\n    , m.`Cargo`\n    , m.nombreConcepto\n    , m.`VDevengado`\n    , m.`VDeducido`\n    , m.`TValorE`\n    , m.`Id_Tercero`\n    , m.CDebito\n    , m.CCredito\n    , m.`RPresupuesto`\n    , m.filtroEstado\n    , m.idPersonaCargo\n    , m.idConcepto\n    , p.devengado-s.deducido NetoP\n    , m.`Id_DocContable`\n    , m.`Id_Compromiso`\n    , m.`Id_Obligacion`\n    , m.`NoDocumento`\n    , m.Concepto\n    , m.`TDCompleto2`\n    , m.idConceptoNomina\n    ,m.CSalario  \n,  m.VRedondeo\n, m.Conceptoxunidad \n, m.TerceroP\n, m.Id_ConceptoCN\n,m.validacion\n,m.IdNomina, m.correo, m.Id_ClasificacionNominaE  \nFROM maestra m \nLEFT JOIN valorDevengado p ON (p.idPersona =idPersonaCargo)\nLEFT JOIN valorDeducido s ON (s.idPersona =idPersonaCargo)\nORDER BY m.Empleado ASC, NOrden asc";
            }
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModeloN.addRow(this.xdatos);
                    this.xModeloN.setValueAt(xrs.getString(1), n, 0);
                    this.xModeloN.setValueAt(xrs.getString(2), n, 1);
                    this.xModeloN.setValueAt(xrs.getString(3), n, 2);
                    this.xModeloN.setValueAt(xrs.getString(4), n, 3);
                    this.xModeloN.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xModeloN.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xModeloN.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xModeloN.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    this.xModeloN.setValueAt(xrs.getString(9), n, 8);
                    this.xModeloN.setValueAt(xrs.getString(10), n, 9);
                    this.xModeloN.setValueAt(xrs.getString(11), n, 10);
                    this.xModeloN.setValueAt(Boolean.valueOf(xrs.getBoolean(12)), n, 11);
                    this.xModeloN.setValueAt(Long.valueOf(xrs.getLong(13)), n, 12);
                    this.xModeloN.setValueAt(Long.valueOf(xrs.getLong(16)), n, 13);
                    this.xModeloN.setValueAt(Long.valueOf(xrs.getLong(17)), n, 14);
                    this.xModeloN.setValueAt(Long.valueOf(xrs.getLong(18)), n, 15);
                    this.xModeloN.setValueAt(Long.valueOf(xrs.getLong(14)), n, 16);
                    this.xModeloN.setValueAt(Double.valueOf(xrs.getDouble(15)), n, 17);
                    this.xModeloN.setValueAt(xrs.getString(19), n, 18);
                    this.xModeloN.setValueAt(xrs.getString(20), n, 19);
                    this.xModeloN.setValueAt(xrs.getString(21), n, 20);
                    this.xModeloN.setValueAt(xrs.getString(22), n, 21);
                    this.xModeloN.setValueAt(Boolean.valueOf(xrs.getBoolean("CSalario")), n, 22);
                    this.xModeloN.setValueAt(Long.valueOf(xrs.getLong("Conceptoxunidad")), n, 23);
                    this.xModeloN.setValueAt(xrs.getString("TerceroP"), n, 24);
                    this.xModeloN.setValueAt(Long.valueOf(xrs.getLong("Id_ConceptoCN")), n, 25);
                    this.xModeloN.setValueAt(Long.valueOf(xrs.getLong("IdNomina")), n, 28);
                    this.xModeloN.setValueAt(xrs.getString("correo"), n, 29);
                    this.xModeloN.setValueAt(Integer.valueOf(xrs.getInt("Id_ClasificacionNominaE")), n, 30);
                    this.xModeloN.setValueAt(false, n, 27);
                    if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                        this.xModeloN.setValueAt(Boolean.valueOf(xrs.getBoolean("validacion")), n, 26);
                    } else {
                        this.xModeloN.setValueAt(true, n, 26);
                    }
                    this.JTB_NNomina.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Nomina_Causacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIF_Nomina_Causacion$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!Boolean.valueOf(table.getValueAt(row, 26).toString()).booleanValue()) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mLlenarCombo_Unid() {
        this.xlleno1 = false;
        this.JCB_UndadFuncional.removeAllItems();
        this.xsql = "SELECT rh_unidad_funcional.`Id`, `rh_unidad_funcional`.`Nbre` AS `NUnidadF` \n FROM `rh_nomina_liquidacion_persona_conceptos` INNER JOIN   `rh_tipo_persona_cargon`  ON (`rh_nomina_liquidacion_persona_conceptos`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`) INNER JOIN   `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN   `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\nINNER JOIN   `rh_tipo_cargo`  ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN   `rh_unidad_funcional`  ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`) INNER JOIN   `rh_nomina_concepto_unidadf`  ON (`rh_nomina_liquidacion_persona_conceptos`.`Id_RhConcepto_UF` = `rh_nomina_concepto_unidadf`.`Id`) INNER JOIN   `rh_nomina_conceptos`  ON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`)\nWHERE (rh_tipo_persona_cargon.`Estado`=1 AND `rh_unidadf_cargo`.`Estado` =1 AND `rh_nomina_liquidacion_persona_conceptos`.`Estado` =1)\n GROUP BY  rh_unidad_funcional.`Id` \n ORDER BY `rh_unidad_funcional`.`Nbre` ASC ";
        this.xIdUnidadF = this.xct.llenarCombo(this.xsql, this.xIdUnidadF, this.JCB_UndadFuncional);
        this.JCB_UndadFuncional.setSelectedIndex(-1);
        this.JCBClasificacion.removeAllItems();
        this.xsql = "SELECT `rh_tipo_clasificacion_conceptonomina`.`Id`, `rh_tipo_clasificacion_conceptonomina`.`Nbre` FROM `rh_nomina_concepto_unidadf` INNER JOIN `rh_nomina_conceptos` \nON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) INNER JOIN `rh_tipo_clasificacion_conceptonomina` ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)\nINNER JOIN `rh_nomina_liquidacion_detalle` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`) WHERE (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` ='" + this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "')\nGROUP BY `rh_tipo_clasificacion_conceptonomina`.`Id` ORDER BY `rh_tipo_clasificacion_conceptonomina`.`Nbre` ASC;";
        this.xIdClasificacion = this.xct.llenarCombo(this.xsql, this.xIdClasificacion, this.JCBClasificacion);
        this.JCBClasificacion.setSelectedIndex(-1);
        this.JCBConceptosNomina.removeAllItems();
        this.xsql = "SELECT `rh_nomina_conceptos`.`Id`, `rh_nomina_conceptos`.`Nbre` FROM `rh_nomina_concepto_unidadf` INNER JOIN `rh_nomina_conceptos` \nON (`rh_nomina_concepto_unidadf`.`Id_ConceptosN` = `rh_nomina_conceptos`.`Id`) INNER JOIN `rh_tipo_clasificacion_conceptonomina` ON (`rh_nomina_conceptos`.`Id_Clasificacion` = `rh_tipo_clasificacion_conceptonomina`.`Id`)\nINNER JOIN `rh_nomina_liquidacion_detalle` ON (`rh_nomina_liquidacion_detalle`.`Id_ConceptoCN` = `rh_nomina_concepto_unidadf`.`Id`) WHERE (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` ='" + this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "')\nGROUP BY `rh_nomina_conceptos`.`Id` ORDER BY `rh_nomina_conceptos`.`Nbre` ASC;";
        this.xIdConceptoNomina = this.xct.llenarCombo(this.xsql, this.xIdConceptoNomina, this.JCBConceptosNomina);
        this.JCBConceptosNomina.setSelectedIndex(-1);
        this.xlleno1 = true;
    }

    private void mLlenarCombo() {
        this.xlleno = false;
        this.JCBPeriodoC.removeAllItems();
        this.JCBTipoC.removeAllItems();
        this.JCBTipoDoc_Compromiso.removeAllItems();
        this.JCBPeriodo_Ppt.removeAllItems();
        this.JCBTipoDoc_Obligacion.removeAllItems();
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.xsql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (Id=23 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        } else {
            this.xsql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (Id=14 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        }
        this.xId_TDocContable = this.xct.llenarCombo(this.xsql, this.xId_TDocContable, this.JCBTipoC);
        if (this.xId_TDocContable.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        this.xId_PeriodoContable = this.xct.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1 and Activo=1 and EsCierre=0) ORDER BY FechaF DESC", this.xId_PeriodoContable, this.JCBPeriodoC);
        if (this.xId_PeriodoContable.length > 1) {
            this.JCBPeriodoC.setSelectedIndex(-1);
        }
        this.xsql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=4  and pp_tipo_documentos.Estado=1";
        this.xId_DocCompromiso = this.xct.llenarCombo(this.xsql, this.xId_DocCompromiso, this.JCBTipoDoc_Compromiso);
        if (this.xId_DocCompromiso.length > 1) {
            this.JCBTipoDoc_Compromiso.setSelectedIndex(-1);
        }
        this.xId_PeriodoPresupuestal = this.xct.llenarComboyLista("SELECT `Id` , CONCAT(`Nbre` ,'-',DATE_FORMAT(`FechaI`, '%Y')) AS Nbre, idEncabezado FROM `pp_periodo` WHERE (`Cerrado` =0) ORDER BY `FechaI` DESC", this.xId_PeriodoPresupuestal, this.JCBPeriodo_Ppt, 3);
        if (this.xId_PeriodoPresupuestal.length > 1) {
            this.JCBPeriodo_Ppt.setSelectedIndex(0);
        }
        this.xsql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=5 and pp_tipo_documentos.Estado=1 ";
        this.xId_DocObligacion = this.xct.llenarCombo(this.xsql, this.xId_DocObligacion, this.JCBTipoDoc_Obligacion);
        if (this.xId_DocObligacion.length > 1) {
            this.JCBTipoDoc_Obligacion.setSelectedIndex(-1);
        }
        this.xsql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=9 and pp_tipo_documentos.Estado=1 ";
        System.out.println("" + this.xsql);
        this.xId_Disponibilidad = this.xct.llenarCombo(this.xsql, this.xId_Disponibilidad, this.JCBTipoDoc_Disponibilidad);
        if (this.xId_Disponibilidad.length > 1) {
            this.JCBTipoDoc_Disponibilidad.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    public void mGrabar() {
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1 && Principal.informacionIps.getManejaPresupuesto().intValue() == 0) {
            if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                if (this.JCBTipoC.getSelectedIndex() != -1) {
                    if (!this.xmt.mVerificarDatosLLeno(this.JTB_NNomina, 8) && !this.xmt.mVerificarDatosLLeno(this.JTB_NNomina, 9)) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            this.xWorkerSQL = null;
                            this.xWorkerSQL = new WorkerSQL("Grabando la información", this);
                            this.xWorkerSQL.execute();
                            return;
                        }
                        return;
                    }
                    this.xmt.mostrarMensaje("Faltan cuentas puc en los conceptos");
                    return;
                }
                this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento COntable");
                this.JTB_DatosM.setSelectedIndex(0);
                this.JCBTipoC.requestFocus();
                return;
            }
            this.xmt.mostrarMensaje("Debe seleccionar periodo contable");
            this.JTB_DatosM.setSelectedIndex(0);
            this.JCBPeriodoC.requestFocus();
            return;
        }
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 0 && Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            if (this.JCH_Disponibilidad.isSelected()) {
                if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                    if (this.JCBTipoDoc_Disponibilidad.getSelectedIndex() != -1) {
                        if (this.JCBTipoDoc_Compromiso.getSelectedIndex() != -1) {
                            if (this.JCBTipoDoc_Obligacion.getSelectedIndex() != -1) {
                                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x2 == 0) {
                                    this.xWorkerSQL = null;
                                    this.xWorkerSQL = new WorkerSQL("Grabando la información", this);
                                    this.xWorkerSQL.execute();
                                    return;
                                }
                                return;
                            }
                            this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Obligacion)");
                            this.JTB_DatosM.setSelectedIndex(1);
                            this.JCBTipoDoc_Obligacion.requestFocus();
                            return;
                        }
                        this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Compromiso)");
                        this.JTB_DatosM.setSelectedIndex(1);
                        this.JCBTipoDoc_Compromiso.requestFocus();
                        return;
                    }
                    this.xmt.mostrarMensaje("Debe seleccionar una Disponibilidad");
                    this.JTB_DatosM.setSelectedIndex(1);
                    this.JCBTipoDoc_Disponibilidad.requestFocus();
                    return;
                }
                this.xmt.mostrarMensaje("Debe seleccionar un Periodo Presupuestal");
                this.JTB_DatosM.setSelectedIndex(1);
                this.JCBPeriodo_Ppt.requestFocus();
                return;
            }
            if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                if (this.JCBTipoDoc_Compromiso.getSelectedIndex() != -1) {
                    if (this.JCBTipoDoc_Obligacion.getSelectedIndex() != -1) {
                        int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x3 == 0) {
                            this.xWorkerSQL = null;
                            this.xWorkerSQL = new WorkerSQL("Grabando la información", this);
                            this.xWorkerSQL.execute();
                            return;
                        }
                        return;
                    }
                    this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Obligacion)");
                    this.JTB_DatosM.setSelectedIndex(1);
                    this.JCBTipoDoc_Obligacion.requestFocus();
                    return;
                }
                this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Compromiso)");
                this.JTB_DatosM.setSelectedIndex(1);
                this.JCBTipoDoc_Compromiso.requestFocus();
                return;
            }
            this.xmt.mostrarMensaje("Debe seleccionar un Periodo Presupuestal");
            this.JTB_DatosM.setSelectedIndex(1);
            this.JCBPeriodo_Ppt.requestFocus();
            return;
        }
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1 && Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                if (this.JCBTipoC.getSelectedIndex() != -1) {
                    if (this.JCH_Disponibilidad.isSelected()) {
                        if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                            if (this.JCBTipoDoc_Disponibilidad.getSelectedIndex() != -1) {
                                if (this.JCBTipoDoc_Compromiso.getSelectedIndex() != -1) {
                                    if (this.JCBTipoDoc_Obligacion.getSelectedIndex() != -1) {
                                        if (!this.xmt.mVerificarDatosLLeno(this.JTB_NNomina, 8) && !this.xmt.mVerificarDatosLLeno(this.JTB_NNomina, 9)) {
                                            int x4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                            if (x4 == 0) {
                                                this.xWorkerSQL = null;
                                                this.xWorkerSQL = new WorkerSQL("Grabando la información", this);
                                                this.xWorkerSQL.execute();
                                                return;
                                            }
                                            return;
                                        }
                                        this.xmt.mostrarMensaje("Faltan cuentas puc y/o rubros presupuestales en los conceptos");
                                        return;
                                    }
                                    this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Obligacion)");
                                    this.JTB_DatosM.setSelectedIndex(1);
                                    this.JCBTipoDoc_Obligacion.requestFocus();
                                    return;
                                }
                                this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Compromiso)");
                                this.JTB_DatosM.setSelectedIndex(1);
                                this.JCBTipoDoc_Compromiso.requestFocus();
                                return;
                            }
                            this.xmt.mostrarMensaje("Debe seleccionar una Disponibilidad");
                            this.JTB_DatosM.setSelectedIndex(1);
                            this.JCBTipoDoc_Disponibilidad.requestFocus();
                            return;
                        }
                        this.xmt.mostrarMensaje("Debe seleccionar un Periodo Presupuestal");
                        this.JTB_DatosM.setSelectedIndex(1);
                        this.JCBPeriodo_Ppt.requestFocus();
                        return;
                    }
                    if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                        if (this.JCBTipoDoc_Compromiso.getSelectedIndex() != -1) {
                            if (this.JCBTipoDoc_Obligacion.getSelectedIndex() != -1) {
                                if (!this.xmt.mVerificarDatosLLeno(this.JTB_NNomina, 8) && !this.xmt.mVerificarDatosLLeno(this.JTB_NNomina, 9)) {
                                    int x5 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    if (x5 == 0) {
                                        this.xWorkerSQL = null;
                                        this.xWorkerSQL = new WorkerSQL("Grabando la información", this);
                                        this.xWorkerSQL.execute();
                                        return;
                                    }
                                    return;
                                }
                                this.xmt.mostrarMensaje("Faltan cuentas puc y/o rubros presupuestales en los conceptos");
                                return;
                            }
                            this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Obligacion)");
                            this.JTB_DatosM.setSelectedIndex(1);
                            this.JCBTipoDoc_Obligacion.requestFocus();
                            return;
                        }
                        this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Compromiso)");
                        this.JTB_DatosM.setSelectedIndex(1);
                        this.JCBTipoDoc_Compromiso.requestFocus();
                        return;
                    }
                    this.xmt.mostrarMensaje("Debe seleccionar un Periodo Presupuestal");
                    this.JTB_DatosM.setSelectedIndex(1);
                    this.JCBPeriodo_Ppt.requestFocus();
                    return;
                }
                this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento COntable");
                this.JTB_DatosM.setSelectedIndex(0);
                this.JCBTipoC.requestFocus();
                return;
            }
            this.xmt.mostrarMensaje("Debe seleccionar periodo contable");
            this.JTB_DatosM.setSelectedIndex(0);
            this.JCBPeriodoC.requestFocus();
        }
    }

    private void mGrabarMovPresupeustoAdicional() {
        if (this.JCH_Disponibilidad.isSelected()) {
            if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                if (this.JCBTipoDoc_Disponibilidad.getSelectedIndex() != -1) {
                    if (this.JCBTipoDoc_Compromiso.getSelectedIndex() != -1) {
                        if (this.JCBTipoDoc_Obligacion.getSelectedIndex() != -1) {
                            if (this.xmt.mVerificarDatosTablaTrue(this.JTB_NNomina, 26)) {
                                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x == 0) {
                                    this.xWorkerSQL = null;
                                    this.xWorkerSQL = new WorkerSQL("Grabando la información", "JIF_Nomina_Causacion_GMovPresupuestal");
                                    this.xWorkerSQL.execute();
                                    return;
                                }
                                return;
                            }
                            this.xmt.mostrarMensaje("Verifique saldo de disponibilidad");
                            return;
                        }
                        this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Obligacion)");
                        this.JTB_DatosM.setSelectedIndex(1);
                        this.JCBTipoDoc_Obligacion.requestFocus();
                        return;
                    }
                    this.xmt.mostrarMensaje("Debe seleccionar un Tipo de Documento(Compromiso)");
                    this.JTB_DatosM.setSelectedIndex(1);
                    this.JCBTipoDoc_Compromiso.requestFocus();
                    return;
                }
                this.xmt.mostrarMensaje("Debe seleccionar una Disponibilidad");
                this.JTB_DatosM.setSelectedIndex(1);
                this.JCBTipoDoc_Disponibilidad.requestFocus();
                return;
            }
            this.xmt.mostrarMensaje("Debe seleccionar un Periodo Presupuestal");
            this.JTB_DatosM.setSelectedIndex(1);
            this.JCBPeriodo_Ppt.requestFocus();
        }
    }

    public void mGrabarM() {
        String xid = "";
        for (int x = 0; x < this.JTB_NNomina.getRowCount(); x++) {
            System.out.println(xid);
            System.out.println(this.xModeloN.getValueAt(x, 0).toString());
            if (xid.equals(this.xModeloN.getValueAt(x, 0).toString())) {
                if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                    mGrabar_DetalleDocumentoC(x);
                    this.xModeloN.setValueAt(this.xId_DocContable, x, 13);
                }
                if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1 && !this.xModeloN.getValueAt(x, 10).toString().equals("")) {
                    if (this.JCH_Disponibilidad.isSelected()) {
                        mGrabar_DetPpto(x, this.xId_DisponibilidadC);
                    }
                    mGrabar_DetPpto(x, this.xId_Compromiso);
                    this.xModeloN.setValueAt(this.xId_Compromiso, x, 14);
                    mGrabar_DetPpto(x, this.xId_DocPptom);
                    this.xModeloN.setValueAt(this.xId_DocPptom, x, 15);
                }
            } else {
                if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                    this.xId_DocContable = mGenerar_DocContable();
                    mGrabar_DetalleDocumentoC(x);
                    this.xModeloN.setValueAt(this.xId_DocContable, x, 13);
                }
                if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1 && !this.xModeloN.getValueAt(x, 10).toString().equals("")) {
                    if (this.JCH_Disponibilidad.isSelected()) {
                        mConcecutivo(9, this.xId_Disponibilidad[this.JCBTipoDoc_Disponibilidad.getSelectedIndex()]);
                        this.xId_DisponibilidadC = mGenerar_DocPresupuesto_Compromiso_Obligacion(this.xId_Disponibilidad[this.JCBTipoDoc_Disponibilidad.getSelectedIndex()], this.JDCFechaDPresupuesto);
                        this.xsql = "update pp_movimiento set  `IdDisponibilidad`='" + this.xId_DisponibilidadC + "' WHERE Id='" + this.xId_DisponibilidadC + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mGrabar_DetPpto(x, this.xId_DisponibilidadC);
                    }
                    mConcecutivo(4, this.xId_DocCompromiso[this.JCBTipoDoc_Compromiso.getSelectedIndex()]);
                    this.xId_Compromiso = mGenerar_DocPresupuesto_Compromiso_Obligacion(this.xId_DocCompromiso[this.JCBTipoDoc_Compromiso.getSelectedIndex()], this.JDCFechaDPresupuesto);
                    this.xsql = "update pp_movimiento set  `IdCompromiso`='" + this.xId_Compromiso + "' WHERE Id='" + this.xId_Compromiso + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mGrabar_DetPpto(x, this.xId_Compromiso);
                    this.xModeloN.setValueAt(this.xId_Compromiso, x, 14);
                    mConcecutivo(5, this.xId_DocObligacion[this.JCBTipoDoc_Obligacion.getSelectedIndex()]);
                    this.xId_DocPptom = mGenerar_DocPresupuesto_Compromiso_Obligacion(this.xId_DocObligacion[this.JCBTipoDoc_Obligacion.getSelectedIndex()], this.JDCFechaInicio);
                    this.xsql = "update pp_movimiento set  `IdCompromiso`='" + this.xId_Compromiso + "', IdObligacion='" + this.xId_DocPptom + "'  WHERE Id='" + this.xId_DocPptom + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mGrabar_DetPpto(x, this.xId_DocPptom);
                    this.xModeloN.setValueAt(this.xId_DocPptom, x, 15);
                }
            }
            this.xsql = "UPDATE rh_nomina_liquidacion_detalle SET    `Id_DocContable`='" + this.xId_DocContable + "', `Id_Compromiso`='" + this.xId_Compromiso + "' , `Id_Obligacion`='" + this.xId_DocPptom + "' WHERE (`Id_Liquidacion` ='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "' AND `Id_PersonaC` ='" + this.xModeloN.getValueAt(x, 12) + "') ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            xid = this.xModeloN.getValueAt(x, 0).toString();
        }
    }

    public void mGrabarMPresupuesto() {
        String xid = "";
        for (int x = 0; x < this.JTB_NNomina.getRowCount(); x++) {
            System.out.println(xid);
            if (Boolean.valueOf(this.xModeloN.getValueAt(x, 27).toString()).booleanValue()) {
                System.out.println(this.xModeloN.getValueAt(x, 0).toString());
                if (xid.equals(this.xModeloN.getValueAt(x, 0).toString())) {
                    if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1 && !this.xModeloN.getValueAt(x, 10).toString().equals("")) {
                        if (this.JCH_Disponibilidad.isSelected()) {
                            mGrabar_DetPpto(x, this.xId_DisponibilidadC);
                        }
                        mGrabar_DetPpto(x, this.xId_Compromiso);
                        this.xModeloN.setValueAt(this.xId_Compromiso, x, 14);
                        mGrabar_DetPpto(x, this.xId_DocPptom);
                        this.xModeloN.setValueAt(this.xId_DocPptom, x, 15);
                    }
                } else {
                    if (this.JCH_Disponibilidad.isSelected()) {
                        mConcecutivo(9, this.xId_Disponibilidad[this.JCBTipoDoc_Disponibilidad.getSelectedIndex()]);
                        this.xId_DisponibilidadC = mGenerar_DocPresupuesto_Compromiso_Obligacion(this.xId_Disponibilidad[this.JCBTipoDoc_Disponibilidad.getSelectedIndex()], this.JDCFechaDPresupuesto);
                        this.xsql = "update pp_movimiento set  `IdDisponibilidad`='" + this.xId_DisponibilidadC + "' WHERE Id='" + this.xId_DisponibilidadC + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mGrabar_DetPpto(x, this.xId_DisponibilidadC);
                    }
                    mConcecutivo(4, this.xId_DocCompromiso[this.JCBTipoDoc_Compromiso.getSelectedIndex()]);
                    this.xId_Compromiso = mGenerar_DocPresupuesto_Compromiso_Obligacion(this.xId_DocCompromiso[this.JCBTipoDoc_Compromiso.getSelectedIndex()], this.JDCFechaDPresupuesto);
                    this.xsql = "update pp_movimiento set  `IdCompromiso`='" + this.xId_Compromiso + "' WHERE Id='" + this.xId_Compromiso + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mGrabar_DetPpto(x, this.xId_Compromiso);
                    this.xModeloN.setValueAt(this.xId_Compromiso, x, 14);
                    mConcecutivo(5, this.xId_DocObligacion[this.JCBTipoDoc_Obligacion.getSelectedIndex()]);
                    this.xId_DocPptom = mGenerar_DocPresupuesto_Compromiso_Obligacion(this.xId_DocObligacion[this.JCBTipoDoc_Obligacion.getSelectedIndex()], this.JDCFechaInicio);
                    this.xsql = "update pp_movimiento set  `IdCompromiso`='" + this.xId_Compromiso + "', IdObligacion='" + this.xId_DocPptom + "'  WHERE Id='" + this.xId_DocPptom + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mGrabar_DetPpto(x, this.xId_DocPptom);
                    this.xModeloN.setValueAt(this.xId_DocPptom, x, 15);
                }
                this.xsql = "UPDATE rh_nomina_liquidacion_detalle SET     `Id_Compromiso`='" + this.xId_Compromiso + "' , `Id_Obligacion`='" + this.xId_DocPptom + "' WHERE (`Id_Liquidacion` ='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "' AND `Id_PersonaC` ='" + this.xModeloN.getValueAt(x, 12) + "'  AND `Id_ConceptoCN` ='" + this.xModeloN.getValueAt(x, 25) + "') ";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                xid = this.xModeloN.getValueAt(x, 0).toString();
            }
        }
    }

    private void mGrabar_DetalleDocumentoC(int xfila) {
        if (Double.valueOf(this.xModeloN.getValueAt(xfila, 4).toString()).doubleValue() > 0.0d && Double.valueOf(this.xModeloN.getValueAt(xfila, 5).toString()).doubleValue() == 0.0d && Double.valueOf(this.xModeloN.getValueAt(xfila, 6).toString()).doubleValue() == 0.0d) {
            if (Integer.valueOf(this.xModeloN.getValueAt(xfila, 30).toString()).intValue() == 1) {
                mGrabar_movContable(xfila, 0, Double.valueOf(this.xModeloN.getValueAt(xfila, 4).toString()).doubleValue());
                mGrabar_movContable(xfila, 1, Double.valueOf(this.xModeloN.getValueAt(xfila, 17).toString()).doubleValue());
                return;
            } else {
                mGrabar_movContable(xfila, 0, Double.valueOf(this.xModeloN.getValueAt(xfila, 4).toString()).doubleValue());
                if (Principal.informacionIps.getIdentificacion().equals("812001219")) {
                    mGrabar_movContable(xfila, 1, Double.valueOf(this.xModeloN.getValueAt(xfila, 4).toString()).doubleValue());
                    return;
                }
                return;
            }
        }
        if (Double.valueOf(this.xModeloN.getValueAt(xfila, 4).toString()).doubleValue() == 0.0d && Double.valueOf(this.xModeloN.getValueAt(xfila, 5).toString()).doubleValue() > 0.0d && Double.valueOf(this.xModeloN.getValueAt(xfila, 6).toString()).doubleValue() > 0.0d) {
            mGrabar_movContable(xfila, 0, Double.valueOf(this.xModeloN.getValueAt(xfila, 6).toString()).doubleValue());
            mGrabar_movContable(xfila, 1, Double.valueOf(this.xModeloN.getValueAt(xfila, 5).toString()).doubleValue() + Double.valueOf(this.xModeloN.getValueAt(xfila, 6).toString()).doubleValue());
            return;
        }
        if (Double.valueOf(this.xModeloN.getValueAt(xfila, 4).toString()).doubleValue() == 0.0d && Double.valueOf(this.xModeloN.getValueAt(xfila, 5).toString()).doubleValue() > 0.0d && Double.valueOf(this.xModeloN.getValueAt(xfila, 6).toString()).doubleValue() == 0.0d) {
            mGrabar_movContable(xfila, 1, Double.valueOf(this.xModeloN.getValueAt(xfila, 5).toString()).doubleValue());
        } else if (Double.valueOf(this.xModeloN.getValueAt(xfila, 4).toString()).doubleValue() == 0.0d && Double.valueOf(this.xModeloN.getValueAt(xfila, 5).toString()).doubleValue() == 0.0d && Double.valueOf(this.xModeloN.getValueAt(xfila, 6).toString()).doubleValue() > 0.0d) {
            mGrabar_movContable(xfila, 0, Double.valueOf(this.xModeloN.getValueAt(xfila, 6).toString()).doubleValue());
            mGrabar_movContable(xfila, 1, Double.valueOf(this.xModeloN.getValueAt(xfila, 6).toString()).doubleValue());
        }
    }

    private void mGrabar_movContable(int xfila, int xtipo, double xvalor) {
        if (xtipo == 0) {
            if (xvalor > 0.0d) {
                this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito,Id_ConceptoN, Concepto) Values ('" + this.xId_DocContable + "','" + this.xModeloN.getValueAt(xfila, 8) + "','0','" + this.xModeloN.getValueAt(xfila, 7) + "','" + xvalor + "','0','" + this.xModeloN.getValueAt(xfila, 25) + "',' NOMINA  N° " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "  PERIODO " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 3) + "'  )";
                System.out.println(" Detalle  DebitoPuc : " + this.xsql);
            }
        } else if (xvalor > 0.0d) {
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito,Id_ConceptoN, Concepto) Values ('" + this.xId_DocContable + "','" + this.xModeloN.getValueAt(xfila, 9) + "','1','" + this.xModeloN.getValueAt(xfila, 7) + "','0','" + xvalor + "','" + this.xModeloN.getValueAt(xfila, 25) + "',' NOMINA  N° " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "  PERIODO " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 3) + "'  )";
            System.out.println(" Detalle Credito Puc : " + this.xsql);
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private String mGenerar_DocContable() {
        this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC, Descripcion, Id_Nomina, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "','" + this.xId_TDocContable[this.JCBTipoC.getSelectedIndex()] + "','" + this.xId_PeriodoContable[this.JCBPeriodoC.getSelectedIndex()] + "',' NOMINA  N° " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "  PERIODO " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 3) + "','" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xid = this.xct.ejecutarSQLId(this.xsql);
        this.xct.cerrarConexionBd();
        return xid;
    }

    private String mGenerar_DocPresupuesto_Compromiso_Obligacion(String xid_TipoDoc, JDateChooser xFecha) {
        this.xsql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,NoConcecutivo, `FechaD`,Observacion, `IdDisponibilidad` , Id_Nomina, `IdDocContable`,  IdUsuarioR, `UsuarioS`)  VALUES ( '" + this.xId_PeriodoPresupuestal[this.JCBPeriodo_Ppt.getSelectedIndex()][0] + "','" + xid_TipoDoc + "','" + this.xConsecutivo + "','" + this.xmt.formatoAMD.format(xFecha.getDate()) + "',' NOMINA  N° " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "  PERIODO " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 3) + "','" + this.JTFFNDisponibilidad.getText() + "','" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "','" + this.xId_DocContable + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
        String xid = this.xct.ejecutarSQLId(this.xsql);
        this.xct.cerrarConexionBd();
        return xid;
    }

    private void mGrabar_DetPpto(int xn_fila, String xId_Doc) {
        if (this.xModeloN.getValueAt(xn_fila, 21).toString().equals("7")) {
            mGrabar_DetallePpto(xId_Doc, xn_fila, Double.valueOf(this.xModeloN.getValueAt(xn_fila, 4).toString()).doubleValue());
        } else {
            if (this.xModeloN.getValueAt(xn_fila, 10).toString().equals("")) {
                return;
            }
            if (Double.valueOf(this.xModeloN.getValueAt(xn_fila, 6).toString()).doubleValue() > 0.0d) {
                mGrabar_DetallePpto(xId_Doc, xn_fila, Double.valueOf(this.xModeloN.getValueAt(xn_fila, 6).toString()).doubleValue());
            } else {
                mGrabar_DetallePpto(xId_Doc, xn_fila, Double.valueOf(this.xModeloN.getValueAt(xn_fila, 4).toString()).doubleValue() + Double.valueOf(this.xModeloN.getValueAt(xn_fila, 5).toString()).doubleValue());
            }
        }
    }

    private void mGrabar_DetallePpto(String xid, int xnfila, double xvalor) {
        this.xsql = " insert into  `pp_detalle_movimiento` (`Id_Movimiento`,`Id_Rubro`,idEncabezado, `Id_Tercero`,Valor,Id_ConceptoN,Observacion)\n values ('" + xid + "', '" + this.xModeloN.getValueAt(xnfila, 10) + "','" + this.xId_PeriodoPresupuestal[this.JCBPeriodo_Ppt.getSelectedIndex()][1] + "','" + this.xModeloN.getValueAt(xnfila, 7) + "','" + xvalor + "','" + this.xModeloN.getValueAt(xnfila, 25) + "',' NOMINA  N° " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0) + "  PERIODO " + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 3) + "  CONCEPTO " + this.xModeloN.getValueAt(xnfila, 3) + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mConcecutivo(int xId_Clase, String xid_TipoDoc) {
        int Con = 0;
        String sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , IF(MAX(`pp_movimiento`.`NoConcecutivo`) IS NULL, 0,MAX(`pp_movimiento`.`NoConcecutivo`)) AS MaximoCons\nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` ='" + xId_Clase + "'  AND  pp_tipo_documentos.`Id`='" + xid_TipoDoc + "');";
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
            Logger.getLogger(JIF_Nomina_Causacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    public void mImprimir() {
        if (this.JTP_Datos.getSelectedIndex() == 0) {
            Object[] botones1 = {"Volante de Pago", "Liquidación", "Consolidado por Concepto", "Cerrar"};
            int j = JOptionPane.showInternalOptionDialog(this, "Como desea visualizar?", "GENERACIÓN REPORTE", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "Cerrar");
            switch (j) {
                case 0:
                    Object[] botones = {"Visualizar", "Generar", "Enviar por correo", "Cerrar"};
                    int n = JOptionPane.showInternalOptionDialog(this, "Como desea visualizar el reporte?", "GENERAR VOLANTE DE PAGO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                    switch (n) {
                        case 0:
                            Principal.claserecursoshumanos.imprimirSoporteNomina(this.JLBIdLiquidacion.getText(), this.xModeloN.getValueAt(this.JTB_NNomina.getSelectedRow(), 18).toString(), this, 0, true);
                            break;
                        case 1:
                            mCrearArchivos();
                            break;
                        case 2:
                            enviarComprobanteCorreo();
                            break;
                    }
                    break;
                case 1:
                    Principal.claserecursoshumanos.imprimirConsolidadoNomina(this.JLBIdLiquidacion.getText());
                    break;
                case 2:
                    Principal.claserecursoshumanos.imprimirConsolidadoNominaPorConcepto(this.JLBIdLiquidacion.getText());
                    break;
            }
        }
    }

    private void enviarComprobanteCorreo() {
        String nombre = "";
        for (int i = 0; i < this.JTB_NNomina.getRowCount(); i++) {
            if (Boolean.valueOf(this.xModeloN.getValueAt(i, 11).toString()).booleanValue() && !nombre.equals(Boolean.valueOf(this.xModeloN.getValueAt(i, 29).toString().isEmpty()))) {
                System.out.println(i + " " + this.xModeloN.getValueAt(i, 29).toString());
                if (this.xModeloN.getValueAt(i, 29).toString().matches(this.xmt.getEXPRESION_REGULAR_COREO()) && !nombre.equals(this.xModeloN.getValueAt(i, 29).toString())) {
                    this.xmt.EnviarPDFGeneradoHC("COMPROBANTE DE NOMINA", this.xmt.getRutaRep() + "N_Comprobante_Pago", getParametrosNomina(i), true, true, this.xModeloN.getValueAt(i, 29).toString(), Principal.informacionGeneralPrincipalDTO.getIdModulo());
                    System.out.println("entro a enviar mensaje" + this.xModeloN.getValueAt(i, 29).toString());
                }
                nombre = this.xModeloN.getValueAt(i, 29).toString();
            }
        }
    }

    private String[][] getParametrosNomina(int pos) {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "Id_Liquidacion";
        parametros[0][1] = this.JLBIdLiquidacion.getText();
        parametros[1][0] = "Documento";
        parametros[1][1] = this.xModeloN.getValueAt(pos, 18).toString();
        parametros[2][0] = "Usuario";
        parametros[2][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        return parametros;
    }

    private void mCrearArchivos() {
        String x = this.xmt.formatoDMA.format(this.xmt.getFechaActual());
        File directorio = new File(this.JTFRuta.getText() + x.replaceAll("/", "-"));
        if (directorio.mkdir()) {
            for (int i = 0; i < this.JTB_NNomina.getRowCount(); i++) {
                if (this.xModeloN.getValueAt(i, 11).toString().equals("true")) {
                    new File(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + "N_Comprobante_Pago.pdf");
                    String adjunto = this.xmt.getRutaRep() + this.xModeloN.getValueAt(i, 0).toString() + "_" + this.xModeloN.getValueAt(i, 1).toString() + "_" + this.JLB_Periodo.getText() + ".pdf";
                    if (!this.xmt.mExisteArchivo(directorio + this.xmt.getBarra() + this.xModeloN.getValueAt(i, 0).toString() + "_" + this.xModeloN.getValueAt(i, 1).toString() + "_" + this.JLB_Periodo.getText() + ".pdf")) {
                        this.xmt.CrearPDF(this.xmt.getRutaRep() + "N_Comprobante_Pago", getParametrosNomina(i));
                        System.out.println("Nuevo nombre : " + adjunto);
                        File f1 = new File(this.xmt.getRutaRep() + "N_Comprobante_Pago.pdf");
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(directorio, f2.getName()));
                    }
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El directorio : " + directorio.getPath() + ";\nya se encuentra creado, favor eliminar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mAnular() {
        if (!Boolean.valueOf(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 9).toString()).booleanValue()) {
            if (Principal.informacionIps.getManejaContabilidad().intValue() == 1 && Principal.informacionIps.getManejaPresupuesto().intValue() == 0) {
                if (!this.xmt.mVerificarDatosLLenoCero(this.JTB_NNomina, 13)) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xFomaA = 1L;
                        Anular frm = new Anular(null, true, "Causación Nomina", 27);
                        frm.setVisible(true);
                        return;
                    }
                    return;
                }
                System.out.println("Entro aki");
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x2 == 0) {
                    this.xFomaA = 0L;
                    Anular frm2 = new Anular(null, true, "Causación Nomina", 27);
                    frm2.setVisible(true);
                    return;
                }
                return;
            }
            if (Principal.informacionIps.getManejaContabilidad().intValue() == 0 && Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                if (!this.xmt.mVerificarDatosLLenoCero(this.JTB_NNomina, 14)) {
                    System.out.println("ENTRO EN 2");
                    if (!this.xmt.mVerificarDatosLLenoCero(this.JTB_NNomina, 15)) {
                        System.out.println("ENTRO EN 3");
                        int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x3 == 0) {
                            this.xFomaA = 1L;
                            Anular frm3 = new Anular(null, true, "Causación Nomina", 27);
                            frm3.setVisible(true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                System.out.println("Entro aki");
                int x4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x4 == 0) {
                    this.xFomaA = 0L;
                    Anular frm4 = new Anular(null, true, "Causación Nomina", 27);
                    frm4.setVisible(true);
                    return;
                }
                return;
            }
            if (Principal.informacionIps.getManejaContabilidad().intValue() == 1 && Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                if (!this.xmt.mVerificarDatosLLenoCero(this.JTB_NNomina, 13)) {
                    System.out.println("ENTRO EN 1");
                    if (!this.xmt.mVerificarDatosLLenoCero(this.JTB_NNomina, 14)) {
                        System.out.println("ENTRO EN 2");
                        if (!this.xmt.mVerificarDatosLLenoCero(this.JTB_NNomina, 15)) {
                            System.out.println("ENTRO EN 3");
                            int x5 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x5 == 0) {
                                this.xFomaA = 1L;
                                Anular frm5 = new Anular(null, true, "Causación Nomina", 27);
                                frm5.setVisible(true);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                System.out.println("Entro aki");
                int x6 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x6 == 0) {
                    this.xFomaA = 0L;
                    Anular frm6 = new Anular(null, true, "Causación Nomina", 27);
                    frm6.setVisible(true);
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este registro no se puede anular porque ya se encuentra cerrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public boolean mVerificarDatosLLeno(JTable xjtabla, int xpos) {
        boolean estado = false;
        int cont = 0;
        System.out.println(xjtabla.getRowCount());
        if (xjtabla.getRowCount() > 0) {
            for (int i = 0; i < xjtabla.getRowCount(); i++) {
                if (0 != Integer.valueOf(xjtabla.getValueAt(i, xpos).toString()).intValue()) {
                    cont++;
                }
            }
        }
        if (cont == 0) {
            estado = true;
        }
        System.out.println("cantador-->" + cont);
        return estado;
    }

    public void mAnular(String idMotivo, String xobservacion) {
        System.out.println("cantador-->" + this.xFomaA);
        if (this.xFomaA == 1) {
            if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                this.xsql = "UPDATE `cc_documentoc` SET cc_documentoc.`Estado`=0, cc_documentoc.Id_Anulado = '" + idMotivo + "', `MotivoAnulacion` = '" + xobservacion + "', `FechaAnulacion` = '" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', `UsuarioAnulacion` = '" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE cc_documentoc.`Id_Nomina`='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString() + "';";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
            if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                this.xsql = "UPDATE `pp_movimiento` SET pp_movimiento.`Id_MotivoAnulacion`='" + idMotivo + "', `Observacion_Anul` = '" + xobservacion + "', `FechaAnulacion` = '" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', `Usuario_Anul` = '" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE pp_movimiento.`Id_Nomina`='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString() + "';";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "UPDATE`pp_detalle_movimiento`, pp_movimiento SET pp_detalle_movimiento.`Estado`=0\nWHERE pp_detalle_movimiento.`Id_Movimiento`=pp_movimiento.`Id` AND pp_movimiento.`Id_Nomina`='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString() + "';";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
            this.xsql = "UPDATE `rh_nomina_liquidacion_detalle` SET rh_nomina_liquidacion_detalle.`Id_Compromiso`=0\n, rh_nomina_liquidacion_detalle.`Id_DocContable`=0 \n, rh_nomina_liquidacion_detalle.`Id_Obligacion`=0 \nWHERE rh_nomina_liquidacion_detalle.`Id_Liquidacion`='" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString() + "';";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xmt.mostrarMensaje("DOCUMENTOS CONTABLES Y/O PRESUPUESTALES ANULADOS");
            mNuevo();
            return;
        }
        this.xsql = "UPDATE `rh_nomina_liquidacion` SET `Estado` = 0,   `Id_Anulado` = '" + idMotivo + "',   `MotivoAnulacion` = '" + xobservacion + "',   `FechaAnulacion` = '" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "',   `UsuarioAnulacion` = '" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' WHERE `Id` = '" + this.xModeloH.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString() + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xmt.mostrarMensaje("CAUSACIÓN ANULADA");
        mNuevo();
    }
}
