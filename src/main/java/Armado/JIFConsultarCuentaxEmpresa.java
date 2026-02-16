package Armado;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.service.ICcDocumentocService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFConsultarCuentaxEmpresa.class */
public class JIFConsultarCuentaxEmpresa extends JInternalFrame {
    private String[][] xidempresa;
    private String[][] xdatosinf;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo2;
    private Object[] xdato;
    private String xsql;
    private String[][] xdatosrips;
    public XSSFWorkbook workbook;
    private XSSFFont headerFont;
    private XSSFFont contentFont;
    private XSSFFont titleFont;
    private XSSFFont numericFont;
    private XSSFCellStyle headerStyle;
    private XSSFCellStyle bodyRowStyle;
    private XSSFCellStyle titleStyle;
    private XSSFCellStyle numericStyle;
    private final ICcDocumentocService ccDocumentocService;
    private ButtonGroup JBGExportar;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBG_Seleccionar;
    private JButton JBTExportarRips;
    private JComboBox JCBEmpresa;
    private JCheckBox JCH_FiltroEmpresa;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JPanel JPIDatoP;
    private JPanel JPIDatos;
    private JPanel JPIDatos1;
    private JPanel JPISeleccionar;
    private JPanel JPI_FiltroFecha;
    private JRadioButton JRBGeneral;
    private JRadioButton JRBNinguno;
    private JRadioButton JRBProcxMed;
    private JRadioButton JRBRips;
    private JRadioButton JRBRipsP;
    private JRadioButton JRBTodo;
    private JRadioButton JRB_CuentaCobro;
    private JRadioButton JRB_FiltroFecha;
    private JScrollPane JSPResultado;
    private JScrollPane JSPResultado1;
    private JScrollPane JSPResultado2;
    private JTable JTBResultado;
    private JTable JTBResultado1;
    private JTable JTBResultado2;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Utilidades;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xllenoc = 0;
    private int xforma = -1;

    public JIFConsultarCuentaxEmpresa() {
        initComponents();
        mNuevo();
        this.ccDocumentocService = (ICcDocumentocService) Principal.contexto.getBean(ICcDocumentocService.class);
    }

    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGExportar = new ButtonGroup();
        this.JBG_Seleccionar = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCH_FiltroEmpresa = new JCheckBox();
        this.JPI_FiltroFecha = new JPanel();
        this.JRB_FiltroFecha = new JRadioButton();
        this.JRB_CuentaCobro = new JRadioButton();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JTP_Utilidades = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JSPResultado1 = new JScrollPane();
        this.JTBResultado1 = new JTable();
        this.JSPResultado2 = new JScrollPane();
        this.JTBResultado2 = new JTable();
        this.jPanel1 = new JPanel();
        this.JRBGeneral = new JRadioButton();
        this.JRBProcxMed = new JRadioButton();
        this.JRBRips = new JRadioButton();
        this.JRBRipsP = new JRadioButton();
        this.JTFRuta = new JTextField();
        this.JBTExportarRips = new JButton();
        this.JPIDatos1 = new JPanel();
        this.jButton1 = new JButton();
        this.JPISeleccionar = new JPanel();
        this.JRBTodo = new JRadioButton();
        this.JRBNinguno = new JRadioButton();
        this.jButton2 = new JButton();
        setClosable(true);
        setTitle("CONSULTAR CUENTAS DE COBRO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarcuentacobroempresa");
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFConsultarCuentaxEmpresa.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarCuentaxEmpresa.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFConsultarCuentaxEmpresa.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarCuentaxEmpresa.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Armado.JIFConsultarCuentaxEmpresa.3
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarCuentaxEmpresa.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBEmpresa.addActionListener(new ActionListener() { // from class: Armado.JIFConsultarCuentaxEmpresa.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentaxEmpresa.this.JCBEmpresaActionPerformed(evt);
            }
        });
        this.JCH_FiltroEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroEmpresa.setSelected(true);
        this.JCH_FiltroEmpresa.setText("Filtro");
        this.JPI_FiltroFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Filtro en Fecha", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGSeleccion.add(this.JRB_FiltroFecha);
        this.JRB_FiltroFecha.setFont(new Font("Arial", 1, 12));
        this.JRB_FiltroFecha.setForeground(Color.blue);
        this.JRB_FiltroFecha.setSelected(true);
        this.JRB_FiltroFecha.setText("Factura");
        this.JBGSeleccion.add(this.JRB_CuentaCobro);
        this.JRB_CuentaCobro.setFont(new Font("Arial", 1, 12));
        this.JRB_CuentaCobro.setForeground(Color.blue);
        this.JRB_CuentaCobro.setText("Cuenta Cobro");
        GroupLayout JPI_FiltroFechaLayout = new GroupLayout(this.JPI_FiltroFecha);
        this.JPI_FiltroFecha.setLayout(JPI_FiltroFechaLayout);
        JPI_FiltroFechaLayout.setHorizontalGroup(JPI_FiltroFechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroFechaLayout.createSequentialGroup().addComponent(this.JRB_FiltroFecha).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_CuentaCobro).addContainerGap(-1, 32767)));
        JPI_FiltroFechaLayout.setVerticalGroup(JPI_FiltroFechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroFechaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroFechaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_FiltroFecha).addComponent(this.JRB_CuentaCobro)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_FiltroFecha, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaInicio, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JDCFechaFin, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 554, -2).addGap(18, 18, 18).addComponent(this.JCH_FiltroEmpresa).addGap(15, 15, 15)));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatoPLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCH_FiltroEmpresa)).addComponent(this.JDCFechaFin, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDCFechaInicio, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBEmpresa).addGroup(GroupLayout.Alignment.LEADING, JPIDatoPLayout.createSequentialGroup().addComponent(this.JPI_FiltroFecha, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(Color.red);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Armado.JIFConsultarCuentaxEmpresa.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCuentaxEmpresa.this.JTBResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JTP_Utilidades.setForeground(new Color(0, 103, 0));
        this.JTP_Utilidades.setFont(new Font("Arial", 1, 14));
        this.JSPResultado1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBResultado1.setFont(new Font("Arial", 1, 12));
        this.JTBResultado1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado1.setEditingColumn(1);
        this.JTBResultado1.setEditingRow(1);
        this.JTBResultado1.setRowHeight(25);
        this.JTBResultado1.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado1.setSelectionForeground(Color.red);
        this.JTBResultado1.setSelectionMode(0);
        this.JSPResultado1.setViewportView(this.JTBResultado1);
        this.JSPResultado2.setBorder(BorderFactory.createTitledBorder((Border) null, "RIPS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBResultado2.setFont(new Font("Arial", 1, 12));
        this.JTBResultado2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado2.setEditingColumn(1);
        this.JTBResultado2.setEditingRow(1);
        this.JTBResultado2.setRowHeight(25);
        this.JTBResultado2.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado2.setSelectionForeground(Color.red);
        this.JTBResultado2.setSelectionMode(0);
        this.JSPResultado2.setViewportView(this.JTBResultado2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMATO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGExportar.add(this.JRBGeneral);
        this.JRBGeneral.setFont(new Font("Arial", 1, 12));
        this.JRBGeneral.setText("General");
        this.JBGExportar.add(this.JRBProcxMed);
        this.JRBProcxMed.setFont(new Font("Arial", 1, 12));
        this.JRBProcxMed.setText("Procedimientos y Medicamentos");
        this.JBGExportar.add(this.JRBRips);
        this.JRBRips.setFont(new Font("Arial", 1, 12));
        this.JRBRips.setText("Rips");
        this.JBGExportar.add(this.JRBRipsP);
        this.JRBRipsP.setFont(new Font("Arial", 1, 12));
        this.JRBRipsP.setText("Rips Policia");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBGeneral).addComponent(this.JRBProcxMed).addComponent(this.JRBRips).addComponent(this.JRBRipsP)).addContainerGap(52, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRBGeneral).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBProcxMed).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBRips).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addComponent(this.JRBRipsP).addContainerGap()));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Armado.JIFConsultarCuentaxEmpresa.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCuentaxEmpresa.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportarRips.setFont(new Font("Arial", 1, 12));
        this.JBTExportarRips.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportarRips.setText("Exportar");
        this.JBTExportarRips.addActionListener(new ActionListener() { // from class: Armado.JIFConsultarCuentaxEmpresa.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentaxEmpresa.this.JBTExportarRipsActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JSPResultado1, -2, 482, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPResultado2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()).addGroup(JPIDatosLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JTFRuta, -2, 340, -2).addGap(18, 18, 18).addComponent(this.JBTExportarRips, -2, 228, -2).addContainerGap(-1, 32767)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPResultado1, GroupLayout.Alignment.LEADING, -2, 0, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.JSPResultado2, -2, 128, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportarRips, -2, 50, -2)))).addContainerGap(8, 32767)));
        this.JTP_Utilidades.addTab("DATOS", this.JPIDatos);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.jButton1.setText("Generar Documento Contable");
        this.jButton1.addActionListener(new ActionListener() { // from class: Armado.JIFConsultarCuentaxEmpresa.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentaxEmpresa.this.jButton1ActionPerformed(evt);
            }
        });
        this.JPISeleccionar.setBorder(BorderFactory.createTitledBorder((Border) null, "Seleccionar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPISeleccionar.setFont(new Font("Arial", 1, 12));
        this.JBG_Seleccionar.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setText("Todo");
        this.JRBTodo.addActionListener(new ActionListener() { // from class: Armado.JIFConsultarCuentaxEmpresa.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentaxEmpresa.this.JRBTodoActionPerformed(evt);
            }
        });
        this.JBG_Seleccionar.add(this.JRBNinguno);
        this.JRBNinguno.setFont(new Font("Arial", 1, 12));
        this.JRBNinguno.setSelected(true);
        this.JRBNinguno.setText("Ninguno");
        this.JRBNinguno.addActionListener(new ActionListener() { // from class: Armado.JIFConsultarCuentaxEmpresa.10
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentaxEmpresa.this.JRBNingunoActionPerformed(evt);
            }
        });
        GroupLayout JPISeleccionarLayout = new GroupLayout(this.JPISeleccionar);
        this.JPISeleccionar.setLayout(JPISeleccionarLayout);
        JPISeleccionarLayout.setHorizontalGroup(JPISeleccionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeleccionarLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNinguno).addContainerGap(-1, 32767)));
        JPISeleccionarLayout.setVerticalGroup(JPISeleccionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeleccionarLayout.createSequentialGroup().addContainerGap().addGroup(JPISeleccionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBNinguno)).addContainerGap(-1, 32767)));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton2.setText("Gestión Rips");
        this.jButton2.addActionListener(new ActionListener() { // from class: Armado.JIFConsultarCuentaxEmpresa.11
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentaxEmpresa.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatos1Layout = new GroupLayout(this.JPIDatos1);
        this.JPIDatos1.setLayout(JPIDatos1Layout);
        JPIDatos1Layout.setHorizontalGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos1Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JPISeleccionar, -2, -1, -2).addGap(26, 26, 26).addComponent(this.jButton1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 575, 32767).addComponent(this.jButton2, -2, 256, -2).addContainerGap()));
        JPIDatos1Layout.setVerticalGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatos1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPISeleccionar, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 50, -2).addComponent(this.jButton2, -2, 50, -2))).addGap(150, 150, 150)));
        this.JTP_Utilidades.addTab("UTILIDADES", this.JPIDatos1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatoP, -1, -1, -2).addComponent(this.JSPResultado).addComponent(this.JTP_Utilidades)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResultado, -1, 270, 32767).addGap(18, 18, 18).addComponent(this.JTP_Utilidades, -2, 237, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc == 1) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc == 1) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xllenoc == 1 && this.JCBEmpresa.getSelectedIndex() != -1) {
            mBuscar();
            mLlenarDatosInformes();
            if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("1") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("0")) {
                this.JRBRips.setEnabled(true);
            } else {
                this.JRBRips.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarRipsActionPerformed(ActionEvent evt) {
        if (this.JRBProcxMed.isSelected()) {
            if (this.JTBResultado.getSelectedRow() == -1) {
                JOptionPane.showInternalMessageDialog(this, "Para Este Formato De Exportacion Es Necesario Seleccionar Un Registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            String[][] strArr = new String[2][2];
            String[][] mConsulta = new String[2][2];
            mConsulta[0][0] = "Medicamentos";
            mConsulta[0][1] = "SELECT DATE_FORMAT( `f_factura_capita`.`Fecha_FacturaCapita`, '%d/%m/%Y' ) AS `fecha`,  `f_factura_capita`.`No_FacturaCapita`, `persona`.`NoDocumento`, `persona`.`NUsuario`,  `ingreso`.`NoAutorizacion` ,`f_tarifasuministro`.`Codigo` AS `CodigoC`, `i_suministro`.`Nbre` AS `NProcedimiento`, `f_itemordenessum`.`Cantidad` AS `CantidadP`,  `f_itemordenessum`.`ValorUnit` AS `ValorUP` , ((`f_itemordenessum`.`ValorUnit`*`f_itemordenessum`.`Cantidad`)+f_itemordenessum.valorImpuesto) AS VTotal FROM `f_factura_capita` AS `f_factura_capita`, `f_liquidacion`  AS `f_liquidacion`, `ingreso` AS `ingreso`,  `f_subgrupo_empresa` AS `f_subgrupo_empresa`, `f_subgruposervicio` AS `f_subgruposervicio`,   `persona` AS `persona`, `f_factura_evento` AS `f_factura_evento`,  `f_cuentacobro` AS `f_cuentacobro`, `f_gruposervicio` AS `f_gruposervicio`, `f_empresacontxconvenio`  AS `f_empresacontxconvenio`, `g_empresacont`  AS `g_empresacont`, `g_empresa` AS `g_empresa`, `g_ips`  AS `g_ips`, `g_municipio` AS `g_municipio`, `f_ordenes` AS `f_ordenes`, `f_itemordenessum`  AS `f_itemordenessum`, `i_suministro` AS `i_suministro` , `f_tarifasuministro` AS `f_tarifasuministro` WHERE `f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`  AND `ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`  AND `f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id` AND `f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`  AND `f_subgrupo_empresa`.`Id_Empresa` = `ingreso`.`Id_EmpresaContxConv` AND `persona`.`Id_persona` = `ingreso`.`Id_Usuario` AND `f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`  AND `f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta` AND `f_cuentacobro`.`IdGrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`  AND `f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`  AND `f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`  AND `f_empresacontxconvenio`.`Id_Manual` = `f_tarifasuministro`.`Id_manual`AND `i_suministro`.`Id`  = `f_tarifasuministro`.`Id_suministro` AND `g_empresacont`.`Id_empresa` = `g_empresa`.`Id`  AND `g_ips`.`Id_Municipio` = `g_municipio`.`Id`  AND `f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`  AND `f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`  AND `f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id` AND `f_factura_evento`.`No_CuentaCobro` = '" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "' AND `f_itemordenessum`.`ValorUnit` <> 0  AND f_factura_evento.Estado = 0 AND f_factura_capita.Estado = 0 AND f_liquidacion.Estado = 0 AND ingreso.Estado = 0 AND f_ordenes.Estado = 0 ORDER BY  `f_factura_capita`.`Fecha_FacturaCapita` ASC , `persona`.`NUsuario` ASC,  `f_factura_capita`.`No_FacturaCapita` ASC,  `i_suministro`.`Nbre` ASC";
            mConsulta[1][0] = "Procedimientos";
            mConsulta[1][1] = "SELECT DATE_FORMAT( `f_factura_capita`.`Fecha_FacturaCapita`, '%d/%m/%Y' ) AS `fecha`,  `f_factura_capita`.`No_FacturaCapita`, `persona`.`NoDocumento`, `persona`.`NUsuario`, `ingreso`.`NoAutorizacion`, `g_procedimiento`.`Id` AS CUPS, `g_procedimiento`.`Nbre` AS `NProcedimiento`, `f_itemordenesproced`.`Cantidad` AS `CantidadP`,   `f_itemordenesproced`.`ValorUnitario` AS `ValorUP` ,((`f_itemordenesproced`.`ValorUnitario`*`f_itemordenesproced`.`Cantidad`)+f_itemordenesproced.valorImpuesto) AS Vtotal ,`f_liquidacion`.`CuotaModeradora` AS `CuotaModeradoral`, `f_subgruposervicio`.`Nbre` AS `SubGrupo` FROM `f_factura_capita` AS `f_factura_capita`, `f_liquidacion`  AS `f_liquidacion`, `ingreso` AS `ingreso`, `f_subgrupo_empresa` AS `f_subgrupo_empresa`,  `f_subgruposervicio` AS `f_subgruposervicio`,  `persona` AS `persona`, `f_factura_evento` AS `f_factura_evento`,  `f_cuentacobro` AS `f_cuentacobro`, `f_gruposervicio`  AS `f_gruposervicio`, `f_empresacontxconvenio`  AS `f_empresacontxconvenio`, `g_empresacont`  AS `g_empresacont`, `g_empresa` AS `g_empresa`, `g_ips`  AS `g_ips`, `g_municipio` AS `g_municipio`, `f_ordenes` AS `f_ordenes`, `f_itemordenesproced`  AS `f_itemordenesproced`, `g_procedimiento` AS `g_procedimiento`  WHERE `f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`  AND `ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso` AND `f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id` AND `f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`  AND `f_subgrupo_empresa`.`Id_Empresa` = `ingreso`.`Id_EmpresaContxConv` AND `persona`.`Id_persona` = `ingreso`.`Id_Usuario` AND `f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento` AND `f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`  AND `f_cuentacobro`.`IdGrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`  AND `f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`  AND `f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`  AND `g_empresacont`.`Id_empresa` = `g_empresa`.`Id`  AND `g_ips`.`Id_Municipio` = `g_municipio`.`Id` AND `f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`  AND `f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`  AND `f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`  AND `f_factura_evento`.`No_CuentaCobro` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "' AND `f_itemordenesproced`.`ValorUnitario` <> 0  AND f_factura_evento.Estado = 0 AND f_factura_capita.Estado = 0 AND f_liquidacion.Estado = 0 AND ingreso.Estado = 0  AND f_ordenes.Estado = 0 ORDER BY   `f_subgruposervicio`.`Nbre`, `f_factura_capita`.`Fecha_FacturaCapita` ASC , `persona`.`NUsuario` ASC,  `f_factura_capita`.`No_FacturaCapita` ASC,  `g_procedimiento`.`Nbre` ASC ";
            try {
                mExportar_Datos_Formato_Consulta(mConsulta, this.JTFRuta.getText(), getTitle());
                return;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        if (!this.JRBRips.isSelected()) {
            if (!this.JRBRipsP.isSelected()) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBResultado, this.JTFRuta.getText(), getTitle());
                return;
            }
            if (this.JTBResultado.getSelectedRow() != -1) {
                String[][] strArr2 = new String[1][2];
                String[][] mConsulta2 = new String[1][2];
                mConsulta2[0][0] = "Procedimientos";
                mConsulta2[0][1] = "SELECT\n    IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento_M ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento_M)) AS numeroFactura\n    , `f_factura_evento`.`Fecha_FacturaEvento` fechaFactura\n    , `ingreso`.`FechaIngreso` fechaIngreso\n    , ifnull(hea.FechaSO,  `ingreso`.`FechaIngreso`) fechaEgreso\n    ,  CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`  ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS nombreUsuario\n    , `g_persona`.`NoDocumento` documento \n    , CONCAT(`g_persona`.`Edad` ,' ', `g_tipoedad`.`Nbre`, '(s)') AS edad\n    , ifnull(if((gp.Id is null or `gp`.`Id`='0000'), '',gp.Id), IF((`g_patologia`.`Id`='0000' or `g_patologia`.`Id`=''), '', `g_patologia`.`Id`)) AS codigoCie10\n    , ifnull(if((gp.Id is null or `gp`.`Id`='0000'), '',gp.Nbre ), IF((`g_patologia`.`Id`='0000' or `g_patologia`.`Id`=''), '', `g_patologia`.Nbre )) AS nombreCie10\n     , GROUP_CONCAT( DISTINCT `g_procedimiento`.`C_Homologado` ORDER BY `g_procedimiento`.`C_Homologado` DESC SEPARATOR ' ') AS codigoCups\n     , GROUP_CONCAT( DISTINCT `g_procedimiento`.`Nbre` ORDER BY `g_procedimiento`.`Nbre` DESC SEPARATOR ' ') AS nombreProcedimiento\n    , `f_liquidacion`.`TotalServicio`\nFROM\n `f_factura_evento`\n    INNER JOIN  `f_liquidacion`\n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\n    INNER JOIN  `f_subgrupo_empresa`\n        ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)\n    INNER JOIN  `g_usuario`\n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona`\n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_tipoedad`\n        ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n    INNER JOIN  `f_subgruposervicio`\n        ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)\n    INNER JOIN  `f_gruposervicio`\n        ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)\n    INNER JOIN  `f_ordenes`\n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_itemordenesproced`\n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento`\n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN  `f_cuentacobro`\n        ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)\n    INNER JOIN  `g_contratos`\n        ON (`g_contratos`.`Id` = `ingreso`.`Id_Contrato`)\n    LEFT JOIN  `g_patologia`\n        ON (`g_patologia`.`Id` = `ingreso`.`DxIngreso`)\n    left join h_atencion ha   \n    \ton(ha.Id_Ingreso = ingreso.Id) and (ha.Estado=0)\n    left join g_patologia gp \n    \ton(gp.Id=ha.Codigo_Dxp)\n    left join h_egreso_atencion hea \n    \ton(hea.Id_Atencion=ha.Id) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) and (hea.Estado=1)\nWHERE ( \n`f_cuentacobro`.`NoCuenta` =" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + " \nand `f_factura_evento`.`Estado` =0\n    AND `f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`EstaArmada` =2)\nGROUP BY `f_factura_evento`.`No_FacturaEvento`\nORDER BY fechaIngreso ASC, nombreUsuario ASC";
                try {
                    mExportar_Datos_Formato_Consulta(mConsulta2, this.JTFRuta.getText(), getTitle());
                    return;
                } catch (FileNotFoundException ex2) {
                    Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    return;
                }
            }
            return;
        }
        if (this.JTBResultado.getSelectedRow() == -1 || this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 0) == null) {
            JOptionPane.showInternalMessageDialog(this, "Para Este Formato De Exportacion Es Necesario Seleccionar Un Registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        try {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                int xnl = 0;
                for (int x = 0; x < this.xmodelo2.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo2.getValueAt(x, 2).toString()).booleanValue()) {
                        WritableSheet sheet = workbook.createSheet(this.xmodelo2.getValueAt(x, 0).toString(), xnl);
                        ResultSet xrs = this.xct.traerRs(this.xmodelo2.getValueAt(x, 1).toString());
                        if (xrs.next()) {
                            xrs.beforeFirst();
                            int y = 0;
                            while (xrs.next()) {
                                sheet.addCell(new Label(0, y, xrs.getString(1)));
                                y++;
                            }
                        }
                        xrs.close();
                        this.xct.cerrarConexionBd();
                        xnl++;
                    }
                }
                workbook.write();
                workbook.close();
            }
        } catch (IOException ex3) {
            Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
        } catch (WriteException e) {
            Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (SQLException ex4) {
            Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        if (this.JTBResultado.getSelectedRow() != -1) {
            if (this.JCH_FiltroEmpresa.isSelected()) {
                mLlenarDatosRips();
                mCrearVistasMaestra();
                if (this.JTBResultado.getModel().getColumnClass(this.JTBResultado.getSelectedColumn()).equals(JButton.class)) {
                    generarPdf();
                    return;
                }
                return;
            }
            if (this.JTBResultado.getModel().getColumnClass(this.JTBResultado.getSelectedColumn()).equals(JButton.class)) {
                generarPdf();
                return;
            }
            return;
        }
        mCrearTablaRips();
    }

    private void generarPdf() {
        String ruta;
        try {
            String factura = this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 1).toString();
            if (this.xmt.mExisteArchivo(Principal.informacionIps.getUrlRecursosAnkara().concat(factura).concat(this.xmt.getBarra()).concat(factura).concat(".pdf"))) {
                ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(factura).concat(this.xmt.getBarra()).concat(factura).concat(".pdf");
            } else if (this.xmt.mExisteArchivo(Principal.informacionIps.getUrlRecursosAnkara().concat(factura).concat(this.xmt.getBarra()).concat(factura).concat("_facturaPdf.pdf"))) {
                ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(factura).concat(this.xmt.getBarra()).concat(factura).concat("_facturaPdf.pdf");
            } else {
                ruta = Principal.informacionIps.getUrlRecursosAnkara().concat(factura).concat("_facturaPdf.pdf");
            }
            Path rutaF = Paths.get(ruta, new String[0]);
            File archivo = rutaF.toFile();
            if (archivo.exists()) {
                this.xmt.mostrarPdf(ruta);
            } else {
                String sql = "SELECT `pdf` FROM `f_factura_evento` WHERE( `f_factura_evento`.`No_FacturaEvento` =  " + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + " )";
                this.xmt.recuperarBlob(sql, 0, "FacturaNo" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 1), 0, ruta);
            }
        } catch (IOException | SQLException e) {
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
    public void JCBEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodoActionPerformed(ActionEvent evt) {
        marcarSeleccion(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNingunoActionPerformed(ActionEvent evt) {
        marcarSeleccion(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTBResultado.getValueAt(i, 17).toString()).booleanValue() && Long.valueOf(this.JTBResultado.getValueAt(i, 9).toString()).longValue() == 0) {
                this.ccDocumentocService.grabarDocumentoContableServiciosFacturacion(Long.valueOf(this.JTBResultado.getValueAt(i, 13).toString()), 6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
    }

    private void marcarSeleccion(Boolean estado) {
        for (int i = 0; i < this.JTBResultado.getRowCount(); i++) {
            this.xmodelo.setValueAt(estado, i, 18);
        }
    }

    private void mCrearTablaDetalleProc() {
        this.xmodelo = new DefaultTableModel() { // from class: Armado.JIFConsultarCuentaxEmpresa.12
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Long.class, Long.class, Long.class, String.class, Long.class, String.class, String.class, String.class, JButton.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("N° Ccobro");
        this.xmodelo.addColumn("N° Factura");
        this.xmodelo.addColumn("Periodo");
        this.xmodelo.addColumn("Servicio");
        this.xmodelo.addColumn("T/Servicio");
        this.xmodelo.addColumn("T/CModeradora");
        this.xmodelo.addColumn("T/CCopago");
        this.xmodelo.addColumn("T/Descuento");
        this.xmodelo.addColumn("T/Neto");
        this.xmodelo.addColumn("DocContable");
        this.xmodelo.addColumn("IdLiquidacion");
        this.xmodelo.addColumn("N° DocC");
        this.xmodelo.addColumn("Empresa");
        this.xmodelo.addColumn("Id_Factura");
        this.xmodelo.addColumn("V/CuentaCobro");
        this.xmodelo.addColumn("Regimén");
        this.xmodelo.addColumn("Período Contable");
        this.xmodelo.addColumn("Imprimir");
        this.xmodelo.addColumn("Seleccionar");
        this.xmodelo.addColumn("esCapitado");
        this.JTBResultado.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Armado.JIFConsultarCuentaxEmpresa.13
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTBResultado.setAutoResizeMode(0);
        this.JTBResultado.doLayout();
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBResultado.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTBResultado.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBResultado.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBResultado.getColumnModel().getColumn(19).setMaxWidth(0);
    }

    private void mCrearTablaInformes() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Informe", "NArchivo", "Imprimir?"}) { // from class: Armado.JIFConsultarCuentaxEmpresa.14
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBResultado1;
        JTable jTable2 = this.JTBResultado;
        jTable.setAutoResizeMode(0);
        this.JTBResultado1.doLayout();
        this.JTBResultado1.setModel(this.xmodelo1);
        this.JTBResultado1.getColumnModel().getColumn(0).setPreferredWidth(390);
        this.JTBResultado1.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBResultado1.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBResultado1.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBResultado1.getColumnModel().getColumn(2).setPreferredWidth(80);
    }

    private void mCrearTablaRips() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Nombre", "Sql", "Exportar?"}) { // from class: Armado.JIFConsultarCuentaxEmpresa.15
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado2.setModel(this.xmodelo2);
        this.JTBResultado2.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultado2.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBResultado2.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBResultado2.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBResultado2.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCargarDatos() {
        mCrearTablaDetalleProc();
        if (this.JCH_FiltroEmpresa.isSelected()) {
            if (this.JRB_FiltroFecha.isSelected()) {
                this.xsql = "SELECT f_cuentacobro.NoCuenta, CONCAT(IFNULL(f_factura_evento.Prefijo,'') ,'',f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento, '%d/%m/%Y'),\nf_gruposervicio.Nbre, f_liquidacion.`TotalServicio`, f_liquidacion.`CuotaModeradora` TotalCuotaM, f_liquidacion.`Copago` TotalCopago, \nf_liquidacion.`TotalDescuento` TotalDesc,  f_liquidacion.`TotalEps` TotalNeto,IF( IFNULL(`f_factura_notas`.`idConceptoNota`,0)=2,0, f_factura_evento.Id_DocumentoC ) AS Id_DocumentoC, f_factura_evento.Id_Liquidacion,\nIF( IFNULL(`f_factura_notas`.`idConceptoNota`,0)=2,0, f_factura_evento.Id_DocumentoC ) AS Id_DocumentoC , f_empresacontxconvenio.Nbre, f_factura_evento.No_FacturaEvento, f_cuentacobro.TotalNeto NCCobro\n, f_tiporegimen.Nbre as regimen, concat(DevuelveMes(cc_periodo_contable.FechaI),' - ', date_format(cc_periodo_contable.FechaI, '%Y')) periodo, f_empresacontxconvenio.EsCapitado\nFROM f_cuentacobro INNER JOIN f_empresacontxconvenio ON (f_cuentacobro.IdEmpContxConv = f_empresacontxconvenio.Id)\nINNER JOIN f_gruposervicio ON (f_cuentacobro.IdGrupoServicio = f_gruposervicio.Id_GrupoServicio)\nINNER JOIN f_factura_evento ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) \nAND (f_factura_evento.`Estado`=0) \n INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`) \nINNER JOIN f_liquidacion ON (f_liquidacion.`Id` = f_factura_evento.Id_Liquidacion)  \nINNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) \ninner join cc_periodo_contable on (cc_periodo_contable.Id=f_cuentacobro.Id_PeriodoC)\ninner join f_tiporegimen on (f_tiporegimen.Id=f_empresacontxconvenio.Id_TipoRegimen)\n LEFT JOIN `f_factura_glosa`\nON(`f_liquidacion`.`Id` = `f_factura_glosa`.`Id_Liquidacion`)\nLEFT JOIN `f_factura_glosa_respuesta`\nON(`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`)\nLEFT JOIN `f_factura_notas`\nON(`f_factura_notas`.`idRespuestaGlosa` = `f_factura_glosa_respuesta`.`Id`)  WHERE ( \nf_cuentacobro.Estado=0 \nand f_factura_evento.Fecha_FacturaEvento>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' \nand f_factura_evento.Fecha_FacturaEvento<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' \nand f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'\n)\nGROUP BY No_FacturaEvento ORDER BY f_cuentacobro.NoCuenta ASC, f_factura_evento.No_FacturaEvento asc ";
            } else if (this.JRB_CuentaCobro.isSelected()) {
                this.xsql = "SELECT f_cuentacobro.NoCuenta, CONCAT(IFNULL(f_factura_evento.Prefijo,'') ,'',f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento, '%d/%m/%Y'),\nf_gruposervicio.Nbre, f_liquidacion.`TotalServicio`, f_liquidacion.`CuotaModeradora` TotalCuotaM, f_liquidacion.`Copago` TotalCopago, \nf_liquidacion.`TotalDescuento` TotalDesc,  f_liquidacion.`TotalEps` TotalNeto, IF( IFNULL(`f_factura_notas`.`idConceptoNota`,0)=2,0, f_factura_evento.Id_DocumentoC ) AS Id_DocumentoC , f_factura_evento.Id_Liquidacion,\n IF( IFNULL(`f_factura_notas`.`idConceptoNota`,0)=2,0, f_factura_evento.Id_DocumentoC ) AS Id_DocumentoC , f_empresacontxconvenio.Nbre, f_factura_evento.No_FacturaEvento, f_cuentacobro.TotalNeto NCCobro\n, f_tiporegimen.Nbre as regimen, concat(DevuelveMes(cc_periodo_contable.FechaI),' - ', date_format(cc_periodo_contable.FechaI, '%Y')) periodo, f_empresacontxconvenio.EsCapitado\nFROM f_cuentacobro INNER JOIN f_empresacontxconvenio ON (f_cuentacobro.IdEmpContxConv = f_empresacontxconvenio.Id)\nINNER JOIN f_gruposervicio ON (f_cuentacobro.IdGrupoServicio = f_gruposervicio.Id_GrupoServicio)\nINNER JOIN f_factura_evento ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) \nAND (f_factura_evento.`Estado`=0) \nINNER JOIN f_liquidacion ON (f_liquidacion.`Id` = f_factura_evento.Id_Liquidacion)  \n INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`) \nINNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) \ninner join cc_periodo_contable on (cc_periodo_contable.Id=f_cuentacobro.Id_PeriodoC)\ninner join f_tiporegimen on (f_tiporegimen.Id=f_empresacontxconvenio.Id_TipoRegimen)\nLEFT JOIN `f_factura_glosa`\n ON(`f_liquidacion`.`Id` = `f_factura_glosa`.`Id_Liquidacion`)\nLEFT JOIN `f_factura_glosa_respuesta`\nON(`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`)\nLEFT JOIN `f_factura_notas`\nON(`f_factura_notas`.`idRespuestaGlosa` = `f_factura_glosa_respuesta`.`Id`) WHERE ( \nf_cuentacobro.Estado=0 \nand cc_periodo_contable.FechaI>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' \nand cc_periodo_contable.FechaF<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' \nand f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'\n)\n GROUP BY No_FacturaEvento ORDER BY f_cuentacobro.NoCuenta ASC, f_factura_evento.No_FacturaEvento asc ";
            }
        } else if (this.JRB_FiltroFecha.isSelected()) {
            this.xsql = "SELECT f_cuentacobro.NoCuenta,  CONCAT(IFNULL(f_factura_evento.Prefijo,'') ,'',f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento, '%d/%m/%Y'),\nf_gruposervicio.Nbre, f_liquidacion.`TotalServicio`, f_liquidacion.`CuotaModeradora` TotalCuotaM, f_liquidacion.`Copago` TotalCopago, \nf_liquidacion.`TotalDescuento` TotalDesc,  f_liquidacion.`TotalEps` TotalNeto, IF( IFNULL(`f_factura_notas`.`idConceptoNota`,0)=2,0, f_factura_evento.Id_DocumentoC ) AS Id_DocumentoC, f_factura_evento.Id_Liquidacion,\n IF( IFNULL(`f_factura_notas`.`idConceptoNota`,0)=2,0, f_factura_evento.Id_DocumentoC ) AS Id_DocumentoC , f_empresacontxconvenio.Nbre, f_factura_evento.No_FacturaEvento, f_cuentacobro.TotalNeto NCCobro\n, f_tiporegimen.Nbre as regimen, concat(DevuelveMes(cc_periodo_contable.FechaI),' - ', date_format(cc_periodo_contable.FechaI, '%Y')) periodo, f_empresacontxconvenio.EsCapitado\nFROM f_cuentacobro INNER JOIN f_empresacontxconvenio ON (f_cuentacobro.IdEmpContxConv = f_empresacontxconvenio.Id)\nINNER JOIN f_gruposervicio ON (f_cuentacobro.IdGrupoServicio = f_gruposervicio.Id_GrupoServicio)\nINNER JOIN f_factura_evento ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) \nAND (f_factura_evento.`Estado`=0) \nINNER JOIN f_liquidacion ON (f_liquidacion.`Id` = f_factura_evento.Id_Liquidacion)  \n INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`) \nINNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) \ninner join cc_periodo_contable on (cc_periodo_contable.Id=f_cuentacobro.Id_PeriodoC)\ninner join f_tiporegimen on (f_tiporegimen.Id=f_empresacontxconvenio.Id_TipoRegimen)\n LEFT JOIN `f_factura_glosa`\nON(`f_liquidacion`.`Id` = `f_factura_glosa`.`Id_Liquidacion`)\nLEFT JOIN `f_factura_glosa_respuesta`\nON(`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`)\nLEFT JOIN `f_factura_notas`\nON(`f_factura_notas`.`idRespuestaGlosa` = `f_factura_glosa_respuesta`.`Id`) WHERE ( \nf_cuentacobro.Estado=0 \nand f_factura_evento.Fecha_FacturaEvento>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' \nand f_factura_evento.Fecha_FacturaEvento<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' \n)\n GROUP BY No_FacturaEvento ORDER BY f_cuentacobro.NoCuenta ASC, f_factura_evento.No_FacturaEvento asc ";
        } else if (this.JRB_CuentaCobro.isSelected()) {
            this.xsql = "SELECT f_cuentacobro.NoCuenta,  CONCAT(IFNULL(f_factura_evento.Prefijo,'') ,'',f_factura_evento.`No_FacturaEvento_M`) AS No_FacturaEvento, DATE_FORMAT(f_factura_evento.Fecha_FacturaEvento, '%d/%m/%Y'),\nf_gruposervicio.Nbre, f_liquidacion.`TotalServicio`, f_liquidacion.`CuotaModeradora` TotalCuotaM, f_liquidacion.`Copago` TotalCopago, \nf_liquidacion.`TotalDescuento` TotalDesc,  f_liquidacion.`TotalEps` TotalNeto,  IF( IFNULL(`f_factura_notas`.`idConceptoNota`,0)=2,0, f_factura_evento.Id_DocumentoC ) AS Id_DocumentoC , f_factura_evento.Id_Liquidacion,\n IF( IFNULL(`f_factura_notas`.`idConceptoNota`,0)=2,0, f_factura_evento.Id_DocumentoC ) AS Id_DocumentoC , f_empresacontxconvenio.Nbre, f_factura_evento.No_FacturaEvento, f_cuentacobro.TotalNeto NCCobro\n, f_tiporegimen.Nbre as regimen, concat(DevuelveMes(cc_periodo_contable.FechaI),' - ', date_format(cc_periodo_contable.FechaI, '%Y')) periodo, f_empresacontxconvenio.EsCapitado\nFROM f_cuentacobro INNER JOIN f_empresacontxconvenio ON (f_cuentacobro.IdEmpContxConv = f_empresacontxconvenio.Id)\nINNER JOIN f_gruposervicio ON (f_cuentacobro.IdGrupoServicio = f_gruposervicio.Id_GrupoServicio)\nINNER JOIN f_factura_evento ON (f_cuentacobro.NoCuenta = f_factura_evento.No_CuentaCobro) \nAND (f_factura_evento.`Estado`=0) \nINNER JOIN f_liquidacion ON (f_liquidacion.`Id` = f_factura_evento.Id_Liquidacion)  \n INNER JOIN cc_resolucion_dian\n ON (cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`) \nINNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) \ninner join cc_periodo_contable on (cc_periodo_contable.Id=f_cuentacobro.Id_PeriodoC)\ninner join f_tiporegimen on (f_tiporegimen.Id=f_empresacontxconvenio.Id_TipoRegimen)\n LEFT JOIN `f_factura_glosa`\nON(`f_liquidacion`.`Id` = `f_factura_glosa`.`Id_Liquidacion`)\nLEFT JOIN `f_factura_glosa_respuesta`\nON(`f_factura_glosa_respuesta`.`Id_Factura_glosa` = `f_factura_glosa`.`Id`)\nLEFT JOIN `f_factura_notas`\nON(`f_factura_notas`.`idRespuestaGlosa` = `f_factura_glosa_respuesta`.`Id`) WHERE ( \nf_cuentacobro.Estado=0 \nand cc_periodo_contable.FechaI>='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' \nand cc_periodo_contable.FechaF<='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' \n)\n GROUP BY No_FacturaEvento ORDER BY f_cuentacobro.NoCuenta ASC, f_factura_evento.No_FacturaEvento asc ";
        }
        System.out.println("Relacion Factura  : " + this.xsql);
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), x, 8);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(10)), x, 9);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(11)), x, 10);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(12)), x, 11);
                    this.xmodelo.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(14)), x, 13);
                    this.xmodelo.setValueAt(rs.getString("NCCobro"), x, 14);
                    this.xmodelo.setValueAt(rs.getString("regimen"), x, 15);
                    this.xmodelo.setValueAt(rs.getString("periodo"), x, 16);
                    this.xmodelo.setValueAt(new JButton("Imprimir"), x, 17);
                    this.xmodelo.setValueAt(false, x, 18);
                    this.xmodelo.setValueAt(rs.getString("esCapitado"), x, 19);
                    if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                        this.JTBResultado.setDefaultRenderer(Object.class, new MiRender());
                    }
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Armado/JIFConsultarCuentaxEmpresa$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.parseLong(table.getValueAt(row, 9).toString()) == 0) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void mBuscar() {
        if (this.JCH_FiltroEmpresa.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                mCargarDatos();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBEmpresa.requestFocus();
                return;
            }
        }
        mCargarDatos();
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        mLLenarCEmpresa();
        mCrearTablaInformes();
        mCrearTablaRips();
        this.JRBRips.setEnabled(false);
        this.JDCFechaInicio.requestFocus();
    }

    public void mAnular() {
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("1") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("0")) {
            if (this.JTBResultado.getSelectedRow() != -1) {
                if (Long.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 9).toString()).longValue() == 0) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        Anular frm = new Anular(null, true, "jifconsultarcuentacobroempresa", 5);
                        frm.setVisible(true);
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No se puede anular;\nFactura con documento contable activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        if (this.JTBResultado.getSelectedRow() != -1) {
            String string4 = "Cuenta de Cobro No. " + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0);
            String string5 = "Factura de Venta No. " + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 1);
            Object[] botones1 = {string4, string5, "Cerrar"};
            int v = JOptionPane.showOptionDialog(this, "Que desea anular?", "CONSULTAR", 0, 3, (Icon) null, botones1, "Cerrar");
            if (v != 0) {
                if (v == 1) {
                    if (Long.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 9).toString()).longValue() == 0) {
                        this.xforma = 1;
                        int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x2 == 0) {
                            Anular frm2 = new Anular(null, true, "jifconsultarcuentacobroempresa", 5);
                            frm2.setVisible(true);
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "No se puede anular;\nFactura con documento contable activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                return;
            }
            boolean xestado = true;
            int x3 = 0;
            while (true) {
                if (x3 < this.JTBResultado.getRowCount()) {
                    if (!this.xmodelo.getValueAt(x3, 0).equals(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0)) || Long.valueOf(this.xmodelo.getValueAt(x3, 9).toString()).longValue() == 0) {
                        x3++;
                    } else {
                        xestado = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (xestado) {
                this.xforma = 0;
                int x4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x4 == 0) {
                    Anular frm3 = new Anular(null, true, "jifconsultarcuentacobroempresa", 5);
                    frm3.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Cuenta de cobro con documento contable activo;\nFavor revisar", "CONFIRMACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mAnular(String idMotivoAnulacion, String xMotivo, String xObservacion) {
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("1") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("0")) {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                this.xsql = "update f_factura_evento set Estado=1 , Id_MotivoAnulacion=" + idMotivoAnulacion + ", f_factura_evento.`Motivo_Anulacion`='" + xMotivo + "' , f_factura_evento.`Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' , f_factura_evento.`Observacion_Anulacion`='" + xObservacion + "' , f_factura_evento.`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where No_FacturaEvento_M='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 1) + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            } else {
                this.xsql = "update f_factura_evento set Estado=1 , Id_MotivoAnulacion=" + idMotivoAnulacion + ", f_factura_evento.`Motivo_Anulacion`='" + xMotivo + "' , f_factura_evento.`Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' , f_factura_evento.`Observacion_Anulacion`='" + xObservacion + "' , f_factura_evento.`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "'  where No_FacturaEvento = '" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
            this.xsql = "update f_liquidacion set Estado=1 where Id='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 10) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update f_cuentacobro set Estado=1 where NoCuenta='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update f_factura_capita set No_FacturaEvento=0, EstaArmada=1 where No_FacturaEvento='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        } else if (this.xforma == 0) {
            this.xsql = "update f_cuentacobro set Estado=1 where NoCuenta='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update f_factura_evento set EstaArmada=1, No_CuentaCobro=0 where No_CuentaCobro='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "UPDATE f_cuentacobro SET `TotalServicio`=TotalServicio-" + Double.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 4).toString()) + "\n    , `TotalCuotaM`=`TotalCuotaM`-" + Double.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 5).toString()) + "\n    , `TotalCopago`= `TotalCopago`-" + Double.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 6).toString()) + "\n    , `TotalNeto`=`TotalNeto`-" + Double.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString()) + "\nWHERE (`NoCuenta` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "')";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        } else {
            this.xsql = "update f_factura_evento set Estado=1 , EstaArmada=1, No_CuentaCobro=0 where No_FacturaEvento='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "UPDATE f_cuentacobro SET `TotalServicio`=TotalServicio-" + Double.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 4).toString()) + "\n    , `TotalCuotaM`=`TotalCuotaM`-" + Double.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 5).toString()) + "\n    , `TotalCopago`= `TotalCopago`-" + Double.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 6).toString()) + "\n    , `TotalNeto`=`TotalNeto`-" + Double.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 8).toString()) + "\nWHERE (`NoCuenta` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "')";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
        this.xsql = "update pp_detalle_movimiento set Estado=0  where NCCobro='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mCargarDatos();
    }

    private void mLLenarCEmpresa() {
        this.xllenoc = 0;
        this.xsql = "SELECT f_empresacontxconvenio.Id, f_empresacontxconvenio.Nbre, f_empresacontxconvenio.EsCapitado, g_ips.`Nbre` FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_ips  ON (f_empresacontxconvenio.`Id_GIps` = g_ips.`Id`) WHERE (f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "') GROUP BY f_empresacontxconvenio.Id ORDER BY f_empresacontxconvenio.Nbre ASC ";
        this.JCBEmpresa.removeAllItems();
        this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBEmpresa, 4);
        this.xct.cerrarConexionBd();
        this.JCBEmpresa.setSelectedIndex(-1);
        mCrearTablaDetalleProc();
        this.xllenoc = 1;
    }

    private void mLlenarDatosInformes() {
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("1") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("0")) {
            if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("CLINICA OFTALMOLOGICA DAJUD SAS") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("JAIME CESAR DAJUD FERNANDEZ") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                    this.xdatosinf = new String[7][2];
                    this.xdatosinf[0][0] = "Cuenta de Cobro";
                    this.xdatosinf[0][1] = "F_CuentadeCobro.jasper";
                    this.xdatosinf[1][0] = "Factura Dian Consolidada F3";
                    if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                        this.xdatosinf[1][1] = "F_FacturaDianConsolidada1_F3_UMT.jasper";
                    } else {
                        this.xdatosinf[1][1] = "F_FacturaDianConsolidada1_F3.jasper";
                    }
                    this.xdatosinf[2][0] = "Relacion Procedimiento Pacientes con N° Autorización";
                    this.xdatosinf[2][1] = "F_RelacionFacturasCapitaProcedimientoPac1.jasper";
                    this.xdatosinf[3][0] = "Relacion Procedimiento Qx Pacientes con N° Autorización";
                    this.xdatosinf[3][1] = "F_RelacionFacturasCapitaProcedimientoPac_1_Qx.jasper";
                    this.xdatosinf[4][0] = "Relacion Procedimiento N° Autorización - Sin Valor";
                    this.xdatosinf[4][1] = "F_RelacionFacturasCapitaProcedimientoPac1_Valores.jasper";
                    this.xdatosinf[5][0] = "Relacion Medicamentos Pacientes";
                    this.xdatosinf[5][1] = "F_RelacionFacturasCapitaMedicamentosPac.jasper";
                    this.xdatosinf[6][0] = "Relacion Ordenes";
                    this.xdatosinf[6][1] = "F_RelacionFacturasCapita.jasper";
                } else if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("CLINICA PAJONAL S.A.S") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                    this.xdatosinf = new String[8][2];
                    this.xdatosinf[0][0] = "Cuenta de Cobro";
                    this.xdatosinf[0][1] = "F_CuentadeCobro.jasper";
                    this.xdatosinf[1][0] = "Factura Dian Consolidada F3";
                    this.xdatosinf[1][1] = "F_FacturaDianConsolidada1_F3.jasper";
                    this.xdatosinf[2][0] = "Relacion Procedimiento Pacientes con N° Autorización";
                    this.xdatosinf[2][1] = "F_RelacionFacturasCapitaProcedimientoPac1.jasper";
                    this.xdatosinf[3][0] = "Relacion Procedimiento Qx Pacientes con N° Autorización";
                    this.xdatosinf[3][1] = "F_RelacionFacturasCapitaProcedimientoPac_1_Qx.jasper";
                    this.xdatosinf[4][0] = "Relacion Procedimiento N° Autorización - Sin Valor";
                    this.xdatosinf[4][1] = "F_RelacionFacturasCapitaProcedimientoPac1_Valores.jasper";
                    this.xdatosinf[5][0] = "Relacion Medicamentos Pacientes";
                    this.xdatosinf[5][1] = "F_RelacionFacturasCapitaMedicamentosPac.jasper";
                    this.xdatosinf[6][0] = "Relacion Ordenes";
                    this.xdatosinf[6][1] = "F_RelacionFacturasCapita.jasper";
                    this.xdatosinf[7][0] = "Consolidado de Capitación";
                    this.xdatosinf[7][1] = "F_Consolidado_Capitacion.jasper";
                } else if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("E.S.E. HOSPITAL SAN JUAN DE DIOS")) {
                    this.xdatosinf = new String[9][2];
                    this.xdatosinf[0][0] = "Cuenta de Cobro";
                    this.xdatosinf[0][1] = "F_CuentadeCobro.jasper";
                    this.xdatosinf[1][0] = "Factura Dian Consolidada F3";
                    this.xdatosinf[1][1] = "F_FacturaDianConsolidada1_F3.jasper";
                    this.xdatosinf[2][0] = "Relacion Procedimiento Pacientes con N° Autorización";
                    this.xdatosinf[2][1] = "F_RelacionFacturasCapitaProcedimientoPac1.jasper";
                    this.xdatosinf[3][0] = "Relacion Procedimiento Qx Pacientes con N° Autorización";
                    this.xdatosinf[3][1] = "F_RelacionFacturasCapitaProcedimientoPac_1_Qx.jasper";
                    this.xdatosinf[4][0] = "Relacion Procedimiento N° Autorización - Sin Valor";
                    this.xdatosinf[4][1] = "F_RelacionFacturasCapitaProcedimientoPac1_Valores.jasper";
                    this.xdatosinf[5][0] = "Relacion Medicamentos Pacientes";
                    this.xdatosinf[5][1] = "F_RelacionFacturasCapitaMedicamentosPac.jasper";
                    this.xdatosinf[6][0] = "Relacion Ordenes";
                    this.xdatosinf[6][1] = "F_RelacionFacturasCapita.jasper";
                    this.xdatosinf[7][0] = "Consolidado de Capitación";
                    this.xdatosinf[7][1] = "F_Consolidado_Capitacion.jasper";
                    this.xdatosinf[8][0] = "Relacion Factura Completa Capitación";
                    this.xdatosinf[8][1] = "F_RelacionFacturasCompletaCapita.jasper";
                } else if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                    this.xdatosinf = new String[4][2];
                    this.xdatosinf[0][0] = "Cuenta de Cobro";
                    this.xdatosinf[0][1] = "F_CuentadeCobroEventoS_Radiologos.jasper";
                    this.xdatosinf[1][0] = "Factura Dian Consolidada F3";
                    this.xdatosinf[1][1] = "F_FacturaDianConsolidada1_F3_Radiologos.jasper";
                    this.xdatosinf[2][0] = "Relacion Procedimiento Pacientes";
                    this.xdatosinf[2][1] = "F_RelacionFacturasCapitaProcedimientoPac_Radiologos.jasper";
                    this.xdatosinf[3][0] = "Relacion Procedimiento con SubGrupo";
                    this.xdatosinf[3][1] = "F_RelacionFacturasCapitaProcedimientoPacSubg_Radiologos.jasper";
                } else {
                    this.xdatosinf = new String[19][2];
                    this.xdatosinf[0][0] = "Cuenta de Cobro";
                    this.xdatosinf[0][1] = "F_CuentadeCobro.jasper";
                    this.xdatosinf[1][0] = "Factura Dian Consolidada";
                    this.xdatosinf[2][0] = "Factura Dian Detallada";
                    this.xdatosinf[3][0] = "Factura Dian Detallada Paciente";
                    this.xdatosinf[4][0] = "Factura Dian Con Grupo";
                    this.xdatosinf[5][0] = "Factura Dian Con Grupo - Agrupado";
                    this.xdatosinf[6][0] = "Factura Dian Con Grupo - Usuario";
                    this.xdatosinf[7][0] = "Factura Dian Agrupado por Subgrupo y Valor";
                    this.xdatosinf[8][0] = "Factura Dian Detallada Procedimiento";
                    this.xdatosinf[9][0] = "Relacion Procedimiento Pacientes";
                    this.xdatosinf[9][1] = "F_RelacionFacturasCapitaProcedimientoPac.jasper";
                    this.xdatosinf[10][0] = "Relacion Procedimiento con SubGrupo";
                    this.xdatosinf[10][1] = "F_RelacionFacturasCapitaProcedimientoPacSubg.jasper";
                    this.xdatosinf[11][0] = "Relacion Medicamentos Pacientes";
                    this.xdatosinf[11][1] = "F_RelacionFacturasCapitaMedicamentosPac.jasper";
                    this.xdatosinf[12][0] = "Relacion Ordenes";
                    this.xdatosinf[12][1] = "F_RelacionFacturasCapita.jasper";
                    this.xdatosinf[13][0] = "Factura Dian Consolidada";
                    this.xdatosinf[14][0] = "Factura Dian Consolidada F2";
                    this.xdatosinf[14][1] = "F_FacturaDianConsolidada1_LFonnegra.jasper";
                    this.xdatosinf[15][0] = "Relacion Procedimiento Pacientes con N° Autorización";
                    this.xdatosinf[15][1] = "F_RelacionFacturasCapitaProcedimientoPac1.jasper";
                    this.xdatosinf[16][0] = "Relacion Procedimiento Pacientes - Consolidado de pruebas";
                    this.xdatosinf[17][0] = "Factura Dian Consolidada F3";
                    this.xdatosinf[18][0] = "Consolidado de Capitación";
                    this.xdatosinf[18][1] = "F_Consolidado_Capitacion.jasper";
                    if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                        this.xdatosinf[1][1] = "F_FacturaDianConsolidada.jasper";
                        this.xdatosinf[2][1] = "F_FacturaDianDetallada.jasper";
                        this.xdatosinf[3][1] = "F_FacturaDianDetalladaPac.jasper";
                        this.xdatosinf[4][1] = "F_FacturaDianDetalladaconGrupoFac.jasper";
                        this.xdatosinf[5][1] = "F_FacturaDianDetalladaconGrupoFac1.jasper";
                        this.xdatosinf[6][1] = "F_FacturaDianDetalladaPacGrupoFac.jasper";
                        this.xdatosinf[7][1] = "F_FacturaDianDetalladaPacGrupoFac1.jasper";
                        this.xdatosinf[8][1] = "F_FacturaDianDetalladaconProcedimiento.jasper";
                        this.xdatosinf[13][1] = "F_FacturaDianConsolidada1.jasper";
                        this.xdatosinf[16][1] = "F_RelacionFacturasCapitaProcedimientoPac1_Consoldiado_LFonnegra.jasper";
                        this.xdatosinf[17][1] = "F_FacturaDianConsolidada1_F3.jasper";
                    } else if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                        this.xdatosinf[1][1] = "F_FacturaDianConsolidada_SusaludIntegral.jasper";
                        this.xdatosinf[2][1] = "F_FacturaDianDetallada_SuSaludIntegral.jasper";
                        this.xdatosinf[3][1] = "F_FacturaDianDetalladaPac_SusaludIntegral.jasper";
                        this.xdatosinf[4][1] = "F_FacturaDianDetalladaconGrupoFac_SuSaludIntegral.jasper";
                        this.xdatosinf[5][1] = "F_FacturaDianDetalladaconGrupoFac1_SuSaludIntegral.jasper";
                        this.xdatosinf[6][1] = "F_FacturaDianDetalladaPacGrupoFac_SuSaludIntegral.jasper";
                        this.xdatosinf[7][1] = "F_FacturaDianDetalladaPacGrupoFac1_SuSaludIntegral.jasper";
                        this.xdatosinf[8][1] = "F_FacturaDianDetalladaconProcedimiento_SuSaludIntegral.jasper";
                        this.xdatosinf[13][1] = "F_FacturaDianConsolidada1_SusaludIntegral.jasper";
                        this.xdatosinf[16][1] = "F_RelacionFacturasCapitaProcedimientoPac1_Consoldiado.jasper";
                        this.xdatosinf[17][1] = "F_FacturaDianConsolidada1_F3.jasper";
                    } else if (Principal.informacionIps.getNombreIps().equals("ASC EN SALUD TOTAL SAS")) {
                        this.xdatosinf[1][1] = "F_FacturaDianConsolidada_DRoss.jasper";
                        this.xdatosinf[2][1] = "F_FacturaDianDetallada_DRoss.jasper";
                        this.xdatosinf[3][1] = "F_FacturaDianDetalladaPac_DRoss.jasper";
                        this.xdatosinf[4][1] = "F_FacturaDianDetalladaconGrupoFac_DRoss.jasper";
                        this.xdatosinf[5][1] = "F_FacturaDianDetalladaconGrupoFac1_DRoss.jasper";
                        this.xdatosinf[6][1] = "F_FacturaDianDetalladaPacGrupoFac_DRoss.jasper";
                        this.xdatosinf[7][1] = "F_FacturaDianDetalladaPacGrupoFac1_DRoss.jasper";
                        this.xdatosinf[8][1] = "F_FacturaDianDetalladaconProcedimiento_DRoss.jasper";
                        this.xdatosinf[13][1] = "F_FacturaDianConsolidada1_DRoss.jasper";
                        this.xdatosinf[16][1] = "F_RelacionFacturasCapitaProcedimientoPac1_Consoldiado.jasper";
                        this.xdatosinf[17][1] = "F_FacturaDianConsolidada1_F3_DRoss.jasper";
                    } else {
                        this.xdatosinf[1][1] = "F_FacturaDianConsolidada.jasper";
                        this.xdatosinf[2][1] = "F_FacturaDianDetallada.jasper";
                        this.xdatosinf[3][1] = "F_FacturaDianDetalladaPac.jasper";
                        this.xdatosinf[4][1] = "F_FacturaDianDetalladaconGrupoFac.jasper";
                        this.xdatosinf[5][1] = "F_FacturaDianDetalladaconGrupoFac1.jasper";
                        this.xdatosinf[6][1] = "F_FacturaDianDetalladaPacGrupoFac.jasper";
                        this.xdatosinf[7][1] = "F_FacturaDianDetalladaPacGrupoFac1.jasper";
                        this.xdatosinf[8][1] = "F_FacturaDianDetalladaconProcedimiento.jasper";
                        this.xdatosinf[13][1] = "F_FacturaDianConsolidada1.jasper";
                        this.xdatosinf[16][1] = "F_RelacionFacturasCapitaProcedimientoPac1_Consoldiado.jasper";
                        this.xdatosinf[17][1] = "F_FacturaDianConsolidada1_F3.jasper";
                    }
                }
            } else {
                this.xdatosinf = new String[6][2];
                this.xdatosinf[0][0] = "Cuenta de Cobro";
                this.xdatosinf[0][1] = "F_CuentadeCobro.jasper";
                this.xdatosinf[1][0] = "Relacion Procedimiento Pacientes";
                this.xdatosinf[1][1] = "F_RelacionFacturasCapitaProcedimientoPac_1.jasper";
                this.xdatosinf[2][0] = "Relacion Medicamentos Pacientes";
                this.xdatosinf[2][1] = "F_RelacionFacturasCapitaMedicamentosPac.jasper";
                this.xdatosinf[3][0] = "Factura Dian Consolidada";
                this.xdatosinf[3][1] = "F_FacturaDianConsolidada.jasper";
                this.xdatosinf[4][0] = "Relacion Ordenes";
                this.xdatosinf[4][1] = "F_RelacionFacturasCapita1.jasper";
                this.xdatosinf[5][0] = "Consolidado de Capitación";
                this.xdatosinf[5][1] = "F_Consolidado_Capitacion.jasper";
            }
        } else if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
            this.xdatosinf = new String[6][2];
            this.xdatosinf[0][0] = "Cuenta de Cobro";
            this.xdatosinf[0][1] = "F_CuentadeCobroEventoS.jasper";
            this.xdatosinf[1][0] = "Relacion Facturas";
            this.xdatosinf[2][0] = "Relacion Facturas Ordenada por Servicios";
            this.xdatosinf[3][0] = "Relacion Facturas Ordenada por Nº Factura";
            this.xdatosinf[4][0] = "Relacion Facturas con Diagnóstico - Cups";
            this.xdatosinf[5][0] = "Relacion Facturas Ordenada por Nº Factura - Especial Soat";
            if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("CLINICA OFTALMOLOGICA DAJUD SAS") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("JAIME CESAR DAJUD FERNANDEZ") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("COD-OPTICA UT") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("CLINICA PAJONAL S.A.S") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("UNION TEMPORAL CLINICA LAURELES") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                this.xdatosinf[1][1] = "F_RelacionFacturasEventoS_1.jasper";
                this.xdatosinf[2][1] = "F_RelacionFacturasEventoS_OrdenFac_1.jasper";
                this.xdatosinf[3][1] = "F_RelacionFacturasEventoS_OrdenFac_SinAgrupar.jasper";
                this.xdatosinf[4][1] = "F_RelacionFacturasEventoS_OrdenFac_2.jasper";
                this.xdatosinf[5][1] = "F_RelacionFacturasEventoS_OrdenFac_SinAgrupar_EspecialSoat.jasper";
            } else if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("E.S.E. HOSPITAL SAN JUAN DE DIOS")) {
                this.xdatosinf = new String[8][2];
                this.xdatosinf[0][0] = "Cuenta de Cobro";
                this.xdatosinf[0][1] = "F_CuentadeCobroEventoS.jasper";
                this.xdatosinf[1][0] = "Relacion Facturas";
                this.xdatosinf[2][0] = "Relacion Facturas Ordenada por Servicios";
                this.xdatosinf[3][0] = "Relacion Facturas Ordenada por Nº Factura";
                this.xdatosinf[4][0] = "Relacion Facturas con Diagnóstico - Cups";
                this.xdatosinf[5][0] = "Relacion Facturas Ordenada por Nº Factura - Especial Soat";
                this.xdatosinf[6][0] = "Relacion Facturas Completa Evento";
                this.xdatosinf[1][1] = "F_RelacionFacturasEventoS_1.jasper";
                this.xdatosinf[2][1] = "F_RelacionFacturasEventoS_OrdenFac_1.jasper";
                this.xdatosinf[3][1] = "F_RelacionFacturasEventoS_OrdenFac_SinAgrupar.jasper";
                this.xdatosinf[4][1] = "F_RelacionFacturasEventoS_OrdenFac_2.jasper";
                this.xdatosinf[5][1] = "F_RelacionFacturasEventoS_OrdenFac_SinAgrupar_EspecialSoat.jasper";
                this.xdatosinf[6][1] = "F_RelacionFacturasCompletaEvento.jasper";
                this.xdatosinf[7][0] = "Factura Dian Consolidada F3";
                this.xdatosinf[7][1] = "F_FacturaDianConsolidada1_F3.jasper";
            } else if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2].equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
                this.xdatosinf[0][1] = "F_CuentadeCobroEventoS_Radiologos.jasper";
                this.xdatosinf[1][1] = "F_FacturaDianConsolidada1_F3_Radiologos.jasper";
                this.xdatosinf[2][1] = "F_RelacionFacturasEventoS_OrdenFac_Radiologos.jasper";
                this.xdatosinf[3][1] = "F_RelacionFacturasEventoS_OrdenFac_SinAgrupar.jasper";
                this.xdatosinf[4][1] = "F_RelacionFacturasEventoS_OrdenFac_2_RadiologosAs.jasper";
                this.xdatosinf[45][1] = "F_RelacionFacturasEventoS_OrdenFac_SinAgrupar_EspecialSoat.jasper";
            } else {
                this.xdatosinf[1][1] = "F_RelacionFacturasEventoS.jasper";
                this.xdatosinf[2][1] = "F_RelacionFacturasEventoS_OrdenFac.jasper";
                this.xdatosinf[3][1] = "F_RelacionFacturasEventoS_OrdenFac_SinAgrupar.jasper";
                this.xdatosinf[4][1] = "F_RelacionFacturasEventoS_OrdenFac_2.jasper";
                this.xdatosinf[5][1] = "F_RelacionFacturasEventoS_OrdenFac_SinAgrupar_EspecialSoat.jasper";
            }
        }
        mCrearTablaInformes();
        if (this.xdatosinf.length > 0) {
            this.xmt.mEstablecerTextEditor(this.JTBResultado1, 0);
            for (int x = 0; x < this.xdatosinf.length; x++) {
                this.xmodelo1.addRow(this.xdato);
                this.xmodelo1.setValueAt(this.xdatosinf[x][0], x, 0);
                this.xmodelo1.setValueAt(this.xdatosinf[x][1], x, 1);
                this.xmodelo1.setValueAt(false, x, 2);
            }
        }
    }

    private void mCrearVistasMaestra() {
        this.xsql = "DROP VIEW IF EXISTS v_f_facturas";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
            this.xsql = "CREATE VIEW  `v_f_facturas`  AS SELECT f_factura_capita.Fecha_FacturaCapita AS fecha, f_factura_capita.No_FacturaCapita, g_persona.`Id_TipoIdentificacion` as Id_TipoIdentificacion, `g_persona`.`NoDocumento`,CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2`)  AS `NUsuario`, ingreso.NoAutorizacion, f_liquidacion.TotalServicio AS TotalServiciol, f_liquidacion.CuotaModeradora AS CuotaModeradoral , f_liquidacion.Copago AS Copagol, f_liquidacion.TotalDescuento AS TotalDescuentol, f_liquidacion.TotalEps AS TotalEpsl, IF(f_factura_evento.Prefijo<>'', CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento_M), f_factura_evento.No_Facturaevento_M) AS No_FacturaEvento, f_factura_evento.No_CuentaCobro, f_gruposervicio.Nbre AS NbreServicio, f_cuentacobro.Periodo_Fact, f_cuentacobro.TotalServicio AS TotalServicioc  , f_cuentacobro.TotalCuotaM AS TotalCuotaMc, f_cuentacobro.TotalCopago AS TotalCopagoc, f_cuentacobro.TotalDesc AS TotalDescc, f_cuentacobro.TotalNeto AS TotalNetoc, f_empresacontxconvenio.Nbre AS NbreEmpresaConve, IF(g_empresa.Id_TipoIdentificacion='NI','NIT',g_empresa.Id_TipoIdentificacion) AS Id_TipoIdentificacionEC, g_empresa.No_identificacion AS No_identificacionEC, g_empresa.Dig_Verificacion AS Dig_VerificacionEC , d_ips.`TipoIdEmpresa` AS Id_TipoIdentificacionIPS, d_ips.`NIEmpresa` AS IdentificacionIPS, d_ips.`DVempresa` AS DigitoVerificacionIPS, d_ips.`NEmpresa`AS NbreIPS, d_ips.Direccion, d_ips.`NMunicipio`, d_ips.`Telefono`, f_subgruposervicio.Nbre AS SubGrupo FROM   `f_factura_capita` INNER JOIN  `f_liquidacion` ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`) INNER JOIN  `f_liquidacion` AS `f_Liquidacion_FE` ON (`f_factura_evento`.`Id_Liquidacion` = `f_Liquidacion_FE`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `f_cuentacobro`  ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN d_ips ON (f_empresacontxconvenio.Id_GIps = d_ips.Id) INNER JOIN `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`) WHERE (f_cuentacobro.`NoCuenta` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "') ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_f_facturas1";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_f_facturas1`  AS  SELECT `f_factura_capita`.`Fecha_FacturaCapita` AS  `fecha`,`f_factura_capita`.`No_FacturaCapita`, `g_persona`.`NoDocumento`,CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2`)  AS `NUsuario`,`ingreso`.`NoAutorizacion`, `f_liquidacion`.`TotalServicio` AS `TotalServiciol`,`f_liquidacion`.`CuotaModeradora` AS `CuotaModeradoral`, `f_liquidacion`.`Copago` AS `Copagol`, `f_liquidacion`.`TotalDescuento` AS `TotalDescuentol`,`f_liquidacion`.`TotalEps` AS `TotalEpsl`, IF(f_factura_evento.Prefijo<>'', CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento_M), f_factura_evento.No_Facturaevento_M) AS No_FacturaEvento, `f_factura_evento`.`No_CuentaCobro`, `f_gruposervicio`.`Nbre` AS `NbreServicio`,`f_cuentacobro`.`Periodo_Fact`, `f_cuentacobro`.`TotalServicio` AS `TotalServicioc`,`f_cuentacobro`.`TotalCuotaM` AS `TotalCuotaMc`, `f_cuentacobro`.`TotalCopago` AS`TotalCopagoc`, `f_cuentacobro`.`TotalDesc` AS `TotalDescc`, `f_cuentacobro`.`TotalNeto` AS`TotalNetoc`, `f_empresacontxconvenio`.`Nbre` AS `NbreEmpresaConve`, IF(`g_empresa`.`Id_TipoIdentificacion`='NI', 'NIT',`g_empresa`.`Id_TipoIdentificacion`)  AS `Id_TipoIdentificacionEC`,`g_empresa`.`No_identificacion` AS `No_identificacionEC`, `g_empresa`.`Dig_Verificacion` AS`Dig_VerificacionEC`,d_ips.`TipoIdEmpresa` AS Id_TipoIdentificacionIPS, d_ips.`NIEmpresa` AS IdentificacionIPS, d_ips.`DVempresa` AS DigitoVerificacionIPS, d_ips.`NEmpresa`AS NbreIPS, d_ips.Direccion as Direccion, d_ips.`NMunicipio`, d_ips.`Telefono` as Telefono , `f_subgruposervicio`.`Nbre`AS `SubGrupo`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, `f_itemordenesproced`.`Cantidad` AS `CantidadP`, `f_itemordenesproced`.`ValorUnitario` AS `ValorUP`, `f_tarifaprocedimiento`.`CodCUPS`, d_ips.`UrlLogoSuperS`, d_ips.`Logo` FROM  `f_factura_capita` INNER JOIN  `f_liquidacion` ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)INNER JOIN  `ingreso` ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)INNER JOIN  `f_subgrupo_empresa` ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`)INNER JOIN  `f_liquidacion` AS `f_Liquidacion_FE`ON (`f_factura_evento`.`Id_Liquidacion` = `f_Liquidacion_FE`.`Id`)INNER JOIN  `f_subgruposervicio` ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)INNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `f_cuentacobro` ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)INNER JOIN  `f_empresacontxconvenio` ON (`f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN d_ips ON (f_empresacontxconvenio.Id_GIps = d_ips.Id) INNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)INNER JOIN  `f_tarifaprocedimiento` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifaprocedimiento`.`Id_Manual`) INNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN  `f_itemordenesproced` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)INNER JOIN  `g_procedimiento` ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) AND (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_cuentacobro`.`NoCuenta` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "' AND `f_ordenes`.`Estado`=0 ) ORDER BY  `f_factura_capita`.`Fecha_FacturaCapita` ASC ,CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2`) ASC,`f_factura_capita`.`No_FacturaCapita` ASC,`g_procedimiento`.`Nbre` ASC";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_f_facturas2";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_f_facturas2`  AS  SELECT `f_factura_capita`.`Fecha_FacturaCapita` AS  `fecha`,`f_factura_capita`.`No_FacturaCapita`, `g_persona`.`NoDocumento`,CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2`)  AS `NUsuario`,`ingreso`.`NoAutorizacion`, `f_liquidacion`.`TotalServicio` AS `TotalServiciol`,`f_liquidacion`.`CuotaModeradora` AS `CuotaModeradoral`, `f_liquidacion`.`Copago` AS `Copagol`, `f_liquidacion`.`TotalDescuento` AS `TotalDescuentol`,`f_liquidacion`.`TotalEps` AS `TotalEpsl`, IF(f_factura_evento.Prefijo<>'', CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento_M), f_factura_evento.No_Facturaevento_M) AS No_FacturaEvento, `f_factura_evento`.`No_CuentaCobro`, `f_gruposervicio`.`Nbre` AS `NbreServicio`,`f_cuentacobro`.`Periodo_Fact`, `f_cuentacobro`.`TotalServicio` AS `TotalServicioc`,`f_cuentacobro`.`TotalCuotaM` AS `TotalCuotaMc`, `f_cuentacobro`.`TotalCopago` AS`TotalCopagoc`, `f_cuentacobro`.`TotalDesc` AS `TotalDescc`, `f_cuentacobro`.`TotalNeto` AS`TotalNetoc`, `f_empresacontxconvenio`.`Nbre` AS `NbreEmpresaConve`, IF(`g_empresa`.`Id_TipoIdentificacion`='NI', 'NIT',`g_empresa`.`Id_TipoIdentificacion`)  AS `Id_TipoIdentificacionEC`,`g_empresa`.`No_identificacion` AS `No_identificacionEC`, `g_empresa`.`Dig_Verificacion` AS`Dig_VerificacionEC`,d_ips.`TipoIdEmpresa` AS Id_TipoIdentificacionIPS, d_ips.`NIEmpresa` AS IdentificacionIPS, d_ips.`DVempresa` AS DigitoVerificacionIPS, d_ips.`NEmpresa`AS NbreIPS, d_ips.Direccion AS Direccion, d_ips.`NMunicipio`, d_ips.`Telefono` AS Telefono , `f_subgruposervicio`.`Nbre`AS `SubGrupo`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, 1 AS `CantidadP`, `f_ordenesqx`.`Valor` AS `ValorUP`, `g_procedimiento`.`C_Homologado` as CodCUPS, d_ips.`UrlLogoSuperS`, d_ips.`Logo` \nFROM  `f_factura_capita`  INNER JOIN  `f_liquidacion` ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `ingreso` ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_subgrupo_empresa` ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)  INNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`) INNER JOIN  `f_liquidacion` AS `f_Liquidacion_FE`ON (`f_factura_evento`.`Id_Liquidacion` = `f_Liquidacion_FE`.`Id`) INNER JOIN  `f_subgruposervicio` ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)  INNER JOIN  `f_cuentacobro` ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`) INNER JOIN  `f_empresacontxconvenio` ON (`f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN d_ips ON (f_empresacontxconvenio.Id_GIps = d_ips.Id)\nINNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)  INNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)  INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenesqx`  ON (`f_ordenes`.`Id` = `f_ordenesqx`.`Id_Orden`)  INNER JOIN  `g_procedimiento` ON (`f_ordenesqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  \n WHERE (`f_cuentacobro`.`NoCuenta` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "' AND `f_ordenes`.`Estado`=0 ) GROUP BY  `f_factura_capita`.`No_FacturaCapita`, `g_procedimiento`.`Id`  ORDER BY  `f_factura_capita`.`Fecha_FacturaCapita` ASC,  `f_factura_capita`.`No_FacturaCapita` ASC ,CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2`)  ASC,`g_procedimiento`.`Nbre` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            return;
        }
        this.xsql = "CREATE VIEW  `v_f_facturas`  AS SELECT f_factura_capita.Fecha_FacturaCapita AS fecha, f_factura_capita.No_FacturaCapita, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, ingreso.NoAutorizacion, f_liquidacion.TotalServicio AS TotalServiciol, f_liquidacion.CuotaModeradora AS CuotaModeradoral , f_liquidacion.Copago AS Copagol, f_liquidacion.TotalDescuento AS TotalDescuentol, f_liquidacion.TotalEps AS TotalEpsl,IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento, f_factura_evento.No_CuentaCobro, f_gruposervicio.Nbre AS NbreServicio, f_cuentacobro.Periodo_Fact, f_cuentacobro.TotalServicio AS TotalServicioc  , f_cuentacobro.TotalCuotaM AS TotalCuotaMc, f_cuentacobro.TotalCopago AS TotalCopagoc, f_cuentacobro.TotalDesc AS TotalDescc, f_cuentacobro.TotalNeto AS TotalNetoc, f_empresacontxconvenio.Nbre AS NbreEmpresaConve, IF(g_empresa.Id_TipoIdentificacion='NI','NIT',g_empresa.Id_TipoIdentificacion) AS Id_TipoIdentificacionEC, g_empresa.No_identificacion AS No_identificacionEC, g_empresa.Dig_Verificacion AS Dig_VerificacionEC , d_ips.`TipoIdEmpresa` AS Id_TipoIdentificacionIPS, d_ips.`NIEmpresa` AS IdentificacionIPS, d_ips.`DVempresa` AS DigitoVerificacionIPS, d_ips.`NEmpresa`AS NbreIPS, d_ips.Direccion, d_ips.`NMunicipio`, d_ips.`Telefono`, f_subgruposervicio.Nbre AS SubGrupo FROM  `d_ips`,  `f_factura_capita` INNER JOIN  `f_liquidacion` ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`) INNER JOIN  `f_liquidacion` AS `f_Liquidacion_FE` ON (`f_factura_evento`.`Id_Liquidacion` = `f_Liquidacion_FE`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `f_cuentacobro`  ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)   LEFT JOIN cc_resolucion_dian\n    ON (\n      cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`\n    )WHERE (f_cuentacobro.`NoCuenta` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "') ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_f_facturas1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_f_facturas1`  AS  SELECT `f_factura_capita`.`Fecha_FacturaCapita` AS  `fechaU`,`f_factura_capita`.`No_FacturaCapita`, `persona`.`NoDocumento`, `persona`.`NUsuario`,`ingreso`.`NoAutorizacion`, `f_liquidacion`.`TotalServicio` AS `TotalServiciol`,`f_liquidacion`.`CuotaModeradora` AS `CuotaModeradoral`, `f_liquidacion`.`Copago` AS `Copagol`, `f_liquidacion`.`TotalDescuento` AS `TotalDescuentol`,`f_liquidacion`.`TotalEps` AS `TotalEpsl`, IF( `cc_resolucion_dian`.`trasmision`= 0,IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento), f_factura_evento.No_Facturaevento), IF(f_factura_evento.Prefijo<>'',CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.`No_FacturaEvento_M`), f_factura_evento.`No_FacturaEvento_M`)) AS No_FacturaEvento , `f_factura_evento`.`No_CuentaCobro`, `f_gruposervicio`.`Nbre` AS `NbreServicio`,`f_cuentacobro`.`Periodo_Fact`, `f_cuentacobro`.`TotalServicio` AS `TotalServicioc`,`f_cuentacobro`.`TotalCuotaM` AS `TotalCuotaMc`, `f_cuentacobro`.`TotalCopago` AS`TotalCopagoc`, `f_cuentacobro`.`TotalDesc` AS `TotalDescc`, `f_cuentacobro`.`TotalNeto` AS`TotalNetoc`, `f_empresacontxconvenio`.`Nbre` AS `NbreEmpresaConve`, IF(`g_empresa`.`Id_TipoIdentificacion`='NI', 'NIT',`g_empresa`.`Id_TipoIdentificacion`)  AS `Id_TipoIdentificacionEC`,`g_empresa`.`No_identificacion` AS `No_identificacionEC`, `g_empresa`.`Dig_Verificacion` AS`Dig_VerificacionEC`,d_ips.`TipoIdEmpresa` AS Id_TipoIdentificacionIPS, d_ips.`NIEmpresa` AS IdentificacionIPS, d_ips.`DVempresa` AS DigitoVerificacionIPS, d_ips.`NEmpresa`AS NbreIPS, d_ips.Direccion as DireccionU, d_ips.`NMunicipio`, d_ips.`Telefono` as TelefonoU , `f_subgruposervicio`.`Nbre`AS `SubGrupo`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, `f_itemordenesproced`.`Cantidad` AS `CantidadP`, `f_itemordenesproced`.`ValorUnitario` AS `ValorUP`, `f_tarifaprocedimiento`.`CodCUPS` FROM `d_ips`, `f_factura_capita` INNER JOIN  `f_liquidacion` ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)INNER JOIN  `ingreso` ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)INNER JOIN  `f_subgrupo_empresa` ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`)INNER JOIN  `f_liquidacion` AS `f_Liquidacion_FE`ON (`f_factura_evento`.`Id_Liquidacion` = `f_Liquidacion_FE`.`Id`)INNER JOIN  `f_subgruposervicio` ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)INNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `f_cuentacobro` ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)INNER JOIN  `f_empresacontxconvenio` ON (`f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`)INNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)INNER JOIN  `f_tarifaprocedimiento` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifaprocedimiento`.`Id_Manual`) INNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN  `f_itemordenesproced` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)INNER JOIN  `g_procedimiento` ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) AND (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`)   LEFT JOIN cc_resolucion_dian\n    ON (\n      cc_resolucion_dian.`Id` = f_factura_evento.`idResolucionDian`\n    )WHERE (`f_cuentacobro`.`NoCuenta` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "' AND `f_ordenes`.`Estado`=0 ) ORDER BY  `f_factura_capita`.`Fecha_FacturaCapita` ASC ,`persona`.`NUsuario` ASC,`f_factura_capita`.`No_FacturaCapita` ASC,`g_procedimiento`.`Nbre` ASC";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_f_facturas2";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_f_facturas2`  AS  SELECT `f_factura_capita`.`Fecha_FacturaCapita` AS  `fechaU`,`f_factura_capita`.`No_FacturaCapita`, `persona`.`NoDocumento`, `persona`.`NUsuario`,`ingreso`.`NoAutorizacion`, `f_liquidacion`.`TotalServicio` AS `TotalServiciol`,`f_liquidacion`.`CuotaModeradora` AS `CuotaModeradoral`, `f_liquidacion`.`Copago` AS `Copagol`, `f_liquidacion`.`TotalDescuento` AS `TotalDescuentol`,`f_liquidacion`.`TotalEps` AS `TotalEpsl`, IF(f_factura_evento.Prefijo<>'', CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento_M), f_factura_evento.No_Facturaevento_M) AS No_FacturaEvento, `f_factura_evento`.`No_CuentaCobro`, `f_gruposervicio`.`Nbre` AS `NbreServicio`,`f_cuentacobro`.`Periodo_Fact`, `f_cuentacobro`.`TotalServicio` AS `TotalServicioc`,`f_cuentacobro`.`TotalCuotaM` AS `TotalCuotaMc`, `f_cuentacobro`.`TotalCopago` AS`TotalCopagoc`, `f_cuentacobro`.`TotalDesc` AS `TotalDescc`, `f_cuentacobro`.`TotalNeto` AS`TotalNetoc`, `f_empresacontxconvenio`.`Nbre` AS `NbreEmpresaConve`, IF(`g_empresa`.`Id_TipoIdentificacion`='NI', 'NIT',`g_empresa`.`Id_TipoIdentificacion`)  AS `Id_TipoIdentificacionEC`,`g_empresa`.`No_identificacion` AS `No_identificacionEC`, `g_empresa`.`Dig_Verificacion` AS`Dig_VerificacionEC`,d_ips.`TipoIdEmpresa` AS Id_TipoIdentificacionIPS, d_ips.`NIEmpresa` AS IdentificacionIPS, d_ips.`DVempresa` AS DigitoVerificacionIPS, d_ips.`NEmpresa`AS NbreIPS, d_ips.Direccion AS DireccionU, d_ips.`NMunicipio`, d_ips.`Telefono` AS TelefonoU , `f_subgruposervicio`.`Nbre`AS `SubGrupo`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, 1 AS `CantidadP`, `f_ordenesqx`.`Valor` AS `ValorUP`, `f_tarifaprocedimiento`.`CodCUPS` \nFROM  `f_factura_capita`  INNER JOIN  `f_liquidacion` ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `ingreso` ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_subgrupo_empresa` ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`)  INNER JOIN  `f_factura_evento`  ON (`f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`) INNER JOIN  `f_liquidacion` AS `f_Liquidacion_FE`ON (`f_factura_evento`.`Id_Liquidacion` = `f_Liquidacion_FE`.`Id`) INNER JOIN  `f_subgruposervicio` ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`)  INNER JOIN  `f_cuentacobro` ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`) INNER JOIN  `f_empresacontxconvenio` ON (`f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN d_ips ON (f_empresacontxconvenio.Id_GIps = d_ips.Id)\nINNER JOIN  `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN  `f_tarifaprocedimiento` ON (`f_empresacontxconvenio`.`Id_Manual` = `f_tarifaprocedimiento`.`Id_Manual`)  INNER JOIN  `g_empresa`  ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)  INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenesqx`  ON (`f_ordenes`.`Id` = `f_ordenesqx`.`Id_Orden`)  INNER JOIN  `g_procedimiento` ON (`f_ordenesqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  AND (`f_tarifaprocedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nWHERE (`f_cuentacobro`.`NoCuenta` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "' AND `f_ordenes`.`Estado`=0 )  ORDER BY  `f_factura_capita`.`Fecha_FacturaCapita` ASC ,`persona`.`NUsuario` ASC,`f_factura_capita`.`No_FacturaCapita` ASC,`g_procedimiento`.`Nbre` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mEliminarVistas() {
        this.xsql = "DROP VIEW IF EXISTS v_f_facturas";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_f_facturas1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mLlenarDatosRips() {
        this.xdatosrips = new String[6][2];
        this.xdatosrips[0][0] = "Usuario";
        this.xdatosrips[1][0] = "Consulta";
        this.xdatosrips[2][0] = "Procedimiento";
        this.xdatosrips[3][0] = "Otros Servicios No Pos";
        this.xdatosrips[4][0] = "Medicamentos";
        this.xdatosrips[5][0] = "Medicamentos No Pos";
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("1") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("0")) {
            this.xdatosrips[0][1] = "SELECT  concat(g_persona.Id_TipoIdentificacion,',', g_persona.NoDocumento,',', g_empresacont.Codigo,',', g_empresacont.Id_TipoRegimen,',', g_persona.Apellido1,',', g_persona.Apellido2,',',g_persona.Nombre1,',', g_persona.Nombre2,',', g_persona.Edad,',',g_persona.Id_TipoEdad,',', g_persona.Id_Sexo,',', LEFT(g_persona.Id_Municipio,2),',', RIGHT(g_persona.Id_Municipio,3),',', g_barrio.Zona) as Linea FROM g_usuario INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN g_barrio ON (g_persona.Id_Barrio = g_barrio.Id) INNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_empresacont ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) WHERE (f_factura_evento.No_FacturaEvento='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + "') GROUP BY g_persona.Id_TipoIdentificacion, g_persona.NoDocumento, g_empresacont.Codigo, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2";
            this.xdatosrips[1][1] = "SELECT  concat(f_factura_capita.No_FacturaCapita,',',IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))),',', g_ips.CodigoOrganismo,',', g_persona.Id_TipoIdentificacion,',', g_persona.NoDocumento,',', DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d/%m/%Y'),',', ingreso.NoAutorizacion,',',f_tarifaprocedimiento.CodCUPS,',', f_itemordenesproced.Id_TipofinProc,',', ingreso.Id_CausaExterna,',',f_itemripsconsulta.Id_DxPrincipal,',', f_itemripsconsulta.DxRelacional1,',', f_itemripsconsulta.DxRelacional2,',', f_itemripsconsulta.DxRelacional3,',', f_itemripsconsulta.Id_TipoDx,',', ((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto),',', f_liquidacion.CuotaModeradora,',', (((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto)- f_liquidacion.CuotaModeradora),',', g_procedimiento.Nbre) AS Linea FROM g_ips, g_usuario INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN f_itemripsconsulta ON (f_itemripsconsulta.Id_Ordenes = f_itemordenesproced.Id_Ordenes) AND (f_itemripsconsulta.Id_Procedimiento = f_itemordenesproced.Id_Procedimiento) INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_subgrupo_empresa  ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id) INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) INNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_itemordenesproced.ValorUnitario >0 AND g_procedimiento.Id_TipoProcRIPS =5 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_factura_capita.EstaArmada =2 and f_factura_evento.No_FacturaEvento='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + "') order by f_factura_evento.No_FacturaEvento ASC, f_subgruposervicio.Nbre ASC, f_factura_capita.Fecha_FacturaCapita ASC,  g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
            this.xdatosrips[2][1] = "SELECT concat(f_factura_capita.No_FacturaCapita,',',IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))),',',g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',g_persona.NoDocumento,',',DATE_FORMAT(f_factura_capita.Fecha_FacturaCapita,'%d/%m/%Y') ,',',ingreso.NoAutorizacion,',',f_tarifaprocedimiento.CodCUPS,',',g_tipoatencion.Id_TipoAmbito,',',f_itemordenesproced.Id_TipofinProc,',','',',',if(f_tarifaprocedimiento.CodCUPS=898001,'Z014',''),',','',',','',',','',',',((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+f_itemordenesproced.valorImpuesto),',', g_procedimiento.Nbre) as Linea FROM g_ips, g_usuario INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) INNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_itemordenesproced.ValorUnitario >0 AND g_procedimiento.Id_TipoProcRIPS =6  AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 AND f_ordenes.Estado =0  AND f_factura_capita.EstaArmada =2 AND f_factura_capita.Estado =0  and f_factura_evento.No_FacturaEvento='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + "') order by f_factura_evento.No_FacturaEvento ASC, f_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
            this.xdatosrips[3][1] = "SELECT CONCAT(f_factura_capita.No_FacturaCapita,',',IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))),',', g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',',g_persona.NoDocumento,',',ingreso.NoAutorizacion,',',g_procedimiento.Id_TipoProcRIPS,',', f_tarifaprocedimiento.CodCUPS,',',LEFT (g_procedimiento.Nbre,60),',', f_itemordenesproced.Cantidad,',',f_itemordenesproced.ValorUnitario,',',((f_itemordenesproced.Cantidad*f_itemordenesproced.ValorUnitario)+f_itemordenesproced.valorImpuesto),',', g_procedimiento.Nbre) AS Linea  FROM g_ips, g_usuario INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) INNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id)  INNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento) INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`)  WHERE (f_itemordenesproced.ValorUnitario >0 AND g_procedimiento.Id_TipoProcRIPS IN(1,2,3,4)  AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_factura_capita.Estado =0 AND f_factura_capita.EstaArmada =2 and f_factura_evento.No_FacturaEvento='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + "') order by f_factura_evento.No_FacturaEvento ASC, f_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
            this.xdatosrips[4][1] = "SELECT CONCAT(f_factura_capita.No_FacturaCapita,',',IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))),',', g_ips.CodigoOrganismo,',', g_persona.Id_TipoIdentificacion,',',g_persona.NoDocumento,',',  ingreso.NoAutorizacion,',',f_tarifasuministro.Codigo,',',i_suministro.Pos,',',LEFT(i_principioactivo.Nbre,30),',',LEFT(i_presentacionfarmaceutica.Nbre,20),',',LEFT(i_concentracion.Nbre,20),',',LEFT(i_unidadmedida.Nbre,20),',',f_itemordenessum.Cantidad,',',f_itemordenessum.ValorUnit,',',((f_itemordenessum.Cantidad*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto) )AS Linea  FROM g_ips, g_usuario INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_itemordenessum ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) INNER JOIN i_suministro ON (f_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_unidadmedida ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento)  INNER JOIN f_tarifasuministro ON (f_tarifasuministro.Id_suministro = i_suministro.Id) AND (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (i_suministro.EsMaterial =0   AND f_factura_capita.Estado =0  AND f_factura_capita.EstaArmada =2 AND f_factura_evento.Estado =0  AND f_factura_evento.EstaArmada =2 AND f_liquidacion.Estado =0 AND f_ordenes.Estado =0  AND ingreso.Estado =0  and f_factura_evento.No_FacturaEvento='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + "') order by f_factura_evento.No_FacturaEvento ASC, f_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
            this.xdatosrips[5][1] = "SELECT concat(f_factura_capita.No_FacturaCapita,',',IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))),',',g_ips.CodigoOrganismo,',',g_persona.Id_TipoIdentificacion,',', g_persona.NoDocumento,',',ingreso.NoAutorizacion,',', '1',',', '' ,',', i_suministro.Nbre,',', f_itemordenessum.Cantidad,',', f_itemordenessum.ValorUnit,',',((f_itemordenessum.Cantidad*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto)) AS Linea FROM  g_ips, g_usuario INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_itemordenessum ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) INNER JOIN i_suministro ON (f_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_unidadmedida ON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_concentracion ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_presentacionfarmaceutica ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_factura_evento ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento)  INNER JOIN f_tarifasuministro ON (f_tarifasuministro.Id_suministro = i_suministro.Id) AND (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (i_suministro.EsMaterial =1 AND f_factura_capita.Estado =0 AND f_factura_capita.EstaArmada =2 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2  AND f_liquidacion.Estado =0 AND f_ordenes.Estado =0 AND ingreso.Estado =0 AND f_factura_evento.No_FacturaEvento='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 13) + "') order by f_factura_evento.No_FacturaEvento ASC, f_factura_capita.Fecha_FacturaCapita ASC, g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC";
        } else if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
        }
        mCrearTablaRips();
        if (this.xdatosrips.length > 0) {
            for (int x = 0; x < this.xdatosrips.length; x++) {
                this.xmodelo2.addRow(this.xdato);
                this.xmodelo2.setValueAt(this.xdatosrips[x][0], x, 0);
                this.xmodelo2.setValueAt(this.xdatosrips[x][1], x, 1);
                this.xmodelo2.setValueAt(false, x, 2);
            }
        }
    }

    public void mImprimir() {
        if (this.JTBResultado.getSelectedRow() != -1 && this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 0) != null) {
            String[][] mparametros = new String[8][2];
            String[][] mparametros1 = new String[4][2];
            DecimalFormat formato = new DecimalFormat("#0.00");
            String vl = this.xmt.mConvertirNumeroLetras(formato.format(Double.valueOf(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 14).toString())));
            mparametros[0][0] = "idcuenta";
            mparametros[0][1] = this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 0).toString();
            mparametros[1][0] = "valorletra";
            mparametros[1][1] = vl.toUpperCase();
            mparametros[2][0] = "servicio";
            mparametros[2][1] = this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 3).toString();
            mparametros[3][0] = "dperiodo";
            mparametros[3][1] = this.xmt.formatoDMA.format(this.JDCFechaInicio.getDate()) + " al " + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate());
            mparametros[4][0] = "nfactura";
            mparametros[4][1] = this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 13).toString();
            mparametros[5][0] = "SUBREPORT_DIR";
            mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[6][0] = "SUBREPORTFIRMA_DIR";
            mparametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros[7][0] = "nbreUsuario";
            mparametros[7][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            mparametros1[0][0] = "idcuenta";
            mparametros1[0][1] = this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 0).toString();
            mparametros1[1][0] = "dperiodo";
            mparametros1[1][1] = this.xmt.formatoDMA.format(this.JDCFechaInicio.getDate()) + " al " + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate());
            mparametros1[2][0] = "SUBREPORT_DIR";
            mparametros1[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros1[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros1[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            for (int x = 0; x < this.xmodelo1.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo1.getValueAt(x, 2).toString()).booleanValue()) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + this.xmodelo1.getValueAt(x, 1).toString().substring(0, this.xmodelo1.getValueAt(x, 1).toString().length() - 7), mparametros);
                }
            }
        }
    }

    public void mImprimir1() {
        if (this.JTBResultado.getSelectedRow() != -1 && this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 0) != null) {
            mCrearVistasMaestra();
            String[][] mparametros = new String[5][2];
            String[][] mparametros1 = new String[3][2];
            DecimalFormat formato = new DecimalFormat("#0.00");
            String vl = this.xmt.mConvertirNumeroLetras(formato.format(Double.valueOf(this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 14).toString())));
            mparametros[0][0] = "idcuenta";
            mparametros[0][1] = this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 0).toString();
            mparametros[1][0] = "valorletra";
            mparametros[1][1] = vl;
            mparametros[2][0] = "nfactura";
            mparametros[2][1] = this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 13).toString();
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros1[0][0] = "idcuenta";
            mparametros1[0][1] = this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 0).toString();
            mparametros1[1][0] = "SUBREPORT_DIR";
            mparametros1[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros1[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros1[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("1") || this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("0")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_CuentadeCobro", mparametros);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_RelacionFacturasCapitaProcedimientoPac", mparametros);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_RelacionFacturasCapitaMedicamentosPac", mparametros);
                String[][] mparametros2 = new String[4][2];
                mparametros2[0][0] = "nfactura";
                mparametros2[0][1] = this.JTBResultado.getValueAt(this.JTBResultado.getSelectedRow(), 1).toString();
                mparametros2[1][0] = "valorletra";
                mparametros2[1][1] = vl;
                mparametros2[2][0] = "SUBREPORT_DIR";
                mparametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros2[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_FacturaDianDetalladaPac", mparametros2);
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_FacturaDianDetallada", mparametros2);
                }
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_FacturaDianConsolidada.", mparametros2);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_RelacionFacturasCapita1", mparametros1);
                String[][] mparametros3 = new String[5][2];
                mparametros3[0][0] = "idempresa";
                mparametros3[0][1] = this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0];
                mparametros3[1][0] = "fechaIni";
                mparametros3[1][1] = this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate());
                mparametros3[2][0] = "fechaFin";
                mparametros3[2][1] = this.xmt.formatoAMD.format(this.JDCFechaFin.getDate());
                mparametros3[3][0] = "SUBREPORT_DIR";
                mparametros3[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros3[4][0] = "SUBREPORTFIRMA_DIR";
                mparametros3[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_ConsolidadoFacturacionxEmpresa", mparametros1);
                return;
            }
            if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1].equals("2")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_CuentadeCobroEventoS", mparametros);
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_RelacionFacturasEventoS", mparametros1);
            }
        }
    }

    public void mExportar_Datos_Formato_Consulta(String[][] xconsulta, String xruta, String xTituloReporte) throws FileNotFoundException {
        this.workbook = new XSSFWorkbook();
        this.titleFont = createFont((short) 10, (short) 12, true);
        this.headerFont = createFont((short) 8, (short) 12, true);
        this.contentFont = createFont((short) 8, (short) 10, false);
        this.titleStyle = createStyle(this.titleFont, (short) 1, (short) 22, (short) 0, (short) 8);
        this.headerStyle = createStyle(this.headerFont, (short) 2, (short) 22, (short) 1, (short) 8);
        this.bodyRowStyle = createStyle(this.contentFont, (short) 0, (short) 9, (short) 1, (short) 63);
        for (int li = 0; li < xconsulta.length; li++) {
            try {
                ResultSet rs = this.xct.traerRs(xconsulta[li][1]);
                ResultSetMetaData Datos = rs.getMetaData();
                XSSFSheet sheet = this.workbook.createSheet();
                this.workbook.setSheetName(li, xconsulta[li][0]);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, Datos.getColumnCount() - 1));
                XSSFRow fila = sheet.createRow(0);
                fila.setHeight((short) 600);
                XSSFCell titlecell = fila.createCell(0);
                titlecell.setCellValue(xTituloReporte);
                titlecell.setCellStyle(this.titleStyle);
                XSSFRow fila2 = sheet.createRow(1);
                for (int i = 0; i < Datos.getColumnCount(); i++) {
                    XSSFCell contentCell = fila2.createCell(i);
                    contentCell.setCellValue(Datos.getColumnName(i + 1));
                    contentCell.setCellStyle(this.headerStyle);
                    if (Datos.getColumnDisplaySize(i + 1) <= 300) {
                        sheet.setColumnWidth(i, (Datos.getColumnName(i + 1).length() * 300) + (Datos.getColumnDisplaySize(i + 1) * 100));
                    } else {
                        sheet.setColumnWidth(i, (Datos.getColumnName(i + 1).length() * 300) + 20000);
                    }
                }
                if (rs.next()) {
                    rs.beforeFirst();
                    int n = 0;
                    while (rs.next()) {
                        XSSFRow fila3 = sheet.createRow(n + 2);
                        for (int i2 = 0; i2 < Datos.getColumnCount(); i2++) {
                            XSSFCell contentCell2 = fila3.createCell(i2);
                            contentCell2.setCellValue(rs.getString(i2 + 1));
                            contentCell2.setCellStyle(this.bodyRowStyle);
                        }
                        n++;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog((Component) null, "Error al exportar la consulta: " + e);
                return;
            }
        }
        FileOutputStream fileOut = new FileOutputStream(xruta + ".xlsx");
        this.workbook.write(fileOut);
        fileOut.close();
        this.xmt.mostrarPdf(xruta + ".xlsx");
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                this.xsql = "SELECT DATE_FORMAT( `f_factura_capita`.`Fecha_FacturaCapita`, '%d/%m/%Y' ) AS `fecha`,  `f_factura_capita`.`No_FacturaCapita`, `persona`.`NoDocumento`, `persona`.`NUsuario`,  `ingreso`.`NoAutorizacion` ,`f_tarifasuministro`.`Codigo` AS `CodigoC`, `i_suministro`.`Nbre` AS `NProcedimiento`, `f_itemordenessum`.`Cantidad` AS `CantidadP`,  `f_itemordenessum`.`ValorUnit` AS `ValorUP` , ((`f_itemordenessum`.`ValorUnit`*`f_itemordenessum`.`Cantidad`)+f_itemordenessum.valorImpuesto) AS VTotal FROM `f_factura_capita` AS `f_factura_capita`, `f_liquidacion`  AS `f_liquidacion`, `ingreso` AS `ingreso`,  `f_subgrupo_empresa` AS `f_subgrupo_empresa`, `f_subgruposervicio` AS `f_subgruposervicio`,   `persona` AS `persona`, `f_factura_evento` AS `f_factura_evento`,  `f_cuentacobro` AS `f_cuentacobro`, `f_gruposervicio` AS `f_gruposervicio`, `f_empresacontxconvenio`  AS `f_empresacontxconvenio`, `g_empresacont`  AS `g_empresacont`, `g_empresa` AS `g_empresa`, `g_ips`  AS `g_ips`, `g_municipio` AS `g_municipio`, `f_ordenes` AS `f_ordenes`, `f_itemordenessum`  AS `f_itemordenessum`, `i_suministro` AS `i_suministro` , `f_tarifasuministro` AS `f_tarifasuministro` WHERE `f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`  AND `ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`  AND `f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id` AND `f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`  AND `f_subgrupo_empresa`.`Id_Empresa` = `ingreso`.`Id_EmpresaContxConv` AND `persona`.`Id_persona` = `ingreso`.`Id_Usuario` AND `f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento`  AND `f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta` AND `f_cuentacobro`.`IdGrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`  AND `f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`  AND `f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`  AND `f_empresacontxconvenio`.`Id_Manual` = `f_tarifasuministro`.`Id_manual`AND `i_suministro`.`Id`  = `f_tarifasuministro`.`Id_suministro` AND `g_empresacont`.`Id_empresa` = `g_empresa`.`Id`  AND `g_ips`.`Id_Municipio` = `g_municipio`.`Id`  AND `f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`  AND `f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`  AND `f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id` AND `f_factura_evento`.`No_CuentaCobro` = '" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "' AND `f_itemordenessum`.`ValorUnit` <> 0  AND f_factura_evento.Estado = 0 AND f_factura_capita.Estado = 0 AND f_liquidacion.Estado = 0 AND ingreso.Estado = 0 AND f_ordenes.Estado = 0 ORDER BY  `f_factura_capita`.`Fecha_FacturaCapita` ASC , `persona`.`NUsuario` ASC,  `f_factura_capita`.`No_FacturaCapita` ASC,  `i_suministro`.`Nbre` ASC";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\Genoma\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("Medicamentos", 0);
                String[] xencabezado = {"Fecha", "N° Orden", "NIdentificacion", "Usuario", "N° Autorizacón", "Codigo", "Suministro/Procedimiento", "Cantidad", "V/Unitario", "V/Total"};
                for (int x = 0; x < xencabezado.length; x++) {
                    sheet.addCell(new Label(x, 0, xencabezado[x]));
                }
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int y = 0;
                    while (xrs.next()) {
                        sheet.addCell(new Label(0, y + 1, xrs.getString(1)));
                        sheet.addCell(new Label(1, y + 1, xrs.getString(2)));
                        sheet.addCell(new Label(2, y + 1, xrs.getString(3)));
                        sheet.addCell(new Label(3, y + 1, xrs.getString(4)));
                        sheet.addCell(new Label(4, y + 1, xrs.getString(5)));
                        sheet.addCell(new Label(5, y + 1, xrs.getString(6)));
                        sheet.addCell(new Label(6, y + 1, xrs.getString(7)));
                        sheet.addCell(new Number(7, y + 1, xrs.getInt(8)));
                        sheet.addCell(new Number(8, y + 1, xrs.getDouble(9)));
                        sheet.addCell(new Number(9, y + 1, xrs.getDouble(9)));
                        y++;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                WritableSheet sheet2 = workbook.createSheet("Procedimientos", 1);
                String[] xencabezado1 = {"Fecha", "N° Orden", "NIdentificacion", "Usuario", "N° Autorizacón", "Codigo", "Suministro/Procedimiento", "Cantidad", "V/Unitario", "V/Total", "C/Moderadora", "Servicio"};
                for (int x2 = 0; x2 < xencabezado1.length; x2++) {
                    sheet2.addCell(new Label(x2, 0, xencabezado1[x2]));
                }
                this.xsql = "SELECT DATE_FORMAT( `f_factura_capita`.`Fecha_FacturaCapita`, '%d/%m/%Y' ) AS `fecha`,  `f_factura_capita`.`No_FacturaCapita`, `persona`.`NoDocumento`, `persona`.`NUsuario`, `ingreso`.`NoAutorizacion`, `g_procedimiento`.`Id` AS CUPS, `g_procedimiento`.`Nbre` AS `NProcedimiento`, `f_itemordenesproced`.`Cantidad` AS `CantidadP`,   `f_itemordenesproced`.`ValorUnitario` AS `ValorUP` ,((`f_itemordenesproced`.`ValorUnitario`*`f_itemordenesproced`.`Cantidad`)+f_itemordenesproced.valorImpuesto) AS Vtotal ,`f_liquidacion`.`CuotaModeradora` AS `CuotaModeradoral`, `f_subgruposervicio`.`Nbre` AS `SubGrupo` FROM `f_factura_capita` AS `f_factura_capita`, `f_liquidacion`  AS `f_liquidacion`, `ingreso` AS `ingreso`, `f_subgrupo_empresa` AS `f_subgrupo_empresa`,  `f_subgruposervicio` AS `f_subgruposervicio`,  `persona` AS `persona`, `f_factura_evento` AS `f_factura_evento`,  `f_cuentacobro` AS `f_cuentacobro`, `f_gruposervicio`  AS `f_gruposervicio`, `f_empresacontxconvenio`  AS `f_empresacontxconvenio`, `g_empresacont`  AS `g_empresacont`, `g_empresa` AS `g_empresa`, `g_ips`  AS `g_ips`, `g_municipio` AS `g_municipio`, `f_ordenes` AS `f_ordenes`, `f_itemordenesproced`  AS `f_itemordenesproced`, `g_procedimiento` AS `g_procedimiento`  WHERE `f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`  AND `ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso` AND `f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id` AND `f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`  AND `f_subgrupo_empresa`.`Id_Empresa` = `ingreso`.`Id_EmpresaContxConv` AND `persona`.`Id_persona` = `ingreso`.`Id_Usuario` AND `f_factura_evento`.`No_FacturaEvento` = `f_factura_capita`.`No_FacturaEvento` AND `f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`  AND `f_cuentacobro`.`IdGrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`  AND `f_cuentacobro`.`IdEmpContxConv` = `f_empresacontxconvenio`.`Id`  AND `f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`  AND `g_empresacont`.`Id_empresa` = `g_empresa`.`Id`  AND `g_ips`.`Id_Municipio` = `g_municipio`.`Id` AND `f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`  AND `f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`  AND `f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`  AND `f_factura_evento`.`No_CuentaCobro` ='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "' AND `f_itemordenesproced`.`ValorUnitario` <> 0  AND f_factura_evento.Estado = 0 AND f_factura_capita.Estado = 0 AND f_liquidacion.Estado = 0 AND ingreso.Estado = 0  AND f_ordenes.Estado = 0 ORDER BY   `f_subgruposervicio`.`Nbre`, `f_factura_capita`.`Fecha_FacturaCapita` ASC , `persona`.`NUsuario` ASC,  `f_factura_capita`.`No_FacturaCapita` ASC,  `g_procedimiento`.`Nbre` ASC ";
                ResultSet xrs2 = this.xct.traerRs(this.xsql);
                if (xrs2.next()) {
                    xrs2.beforeFirst();
                    int y2 = 0;
                    while (xrs2.next()) {
                        sheet2.addCell(new Label(0, y2 + 1, xrs2.getString(1)));
                        sheet2.addCell(new Label(1, y2 + 1, xrs2.getString(2)));
                        sheet2.addCell(new Label(2, y2 + 1, xrs2.getString(3)));
                        sheet2.addCell(new Label(3, y2 + 1, xrs2.getString(4)));
                        sheet2.addCell(new Label(4, y2 + 1, xrs2.getString(5)));
                        sheet2.addCell(new Label(5, y2 + 1, xrs2.getString(6)));
                        sheet2.addCell(new Label(6, y2 + 1, xrs2.getString(7)));
                        sheet2.addCell(new Number(7, y2 + 1, xrs2.getInt(8)));
                        sheet2.addCell(new Number(8, y2 + 1, xrs2.getDouble(9)));
                        sheet2.addCell(new Number(9, y2 + 1, xrs2.getDouble(10)));
                        sheet2.addCell(new Number(10, y2 + 1, xrs2.getDouble(11)));
                        sheet2.addCell(new Label(11, y2 + 1, xrs2.getString(12)));
                        y2++;
                    }
                }
                xrs2.close();
                this.xct.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public XSSFFont createFont(short fontColor, short fontHeight, boolean fontBold) {
        XSSFFont font = this.workbook.createFont();
        font.setBold(fontBold);
        font.setColor(fontColor);
        font.setFontName("Arial");
        font.setFontHeightInPoints(fontHeight);
        return font;
    }

    public XSSFCellStyle createStyle(XSSFFont font, short cellAlign, short cellColor, short cellBorder, short cellBorderColor) {
        XSSFCellStyle style = this.workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(cellAlign);
        style.setFillForegroundColor(cellColor);
        style.setFillPattern((short) 1);
        style.setBorderTop(cellBorder);
        style.setBorderLeft(cellBorder);
        style.setBorderRight(cellBorder);
        style.setBorderBottom(cellBorder);
        style.setTopBorderColor(cellBorderColor);
        style.setLeftBorderColor(cellBorderColor);
        style.setRightBorderColor(cellBorderColor);
        style.setBottomBorderColor(cellBorderColor);
        style.setWrapText(true);
        return style;
    }
}
