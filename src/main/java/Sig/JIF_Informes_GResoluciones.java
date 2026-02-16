package Sig;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IInformeCircular015_ST006;
import com.genoma.plus.jpa.projection.IInformeResolucion1552Projection;
import com.genoma.plus.jpa.service.IInformeResolucion1552Service;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.toedter.calendar.JDateChooser;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.JLabel;
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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIF_Informes_GResoluciones.class */
public class JIF_Informes_GResoluciones extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelotp2;
    private DefaultTableModel xmodelotp3;
    private DefaultTableModel xmodelotp4;
    private DefaultTableModel xmodelotp5;
    private DefaultTableModel xmodelotp6;
    private Object[] xdato;
    private String[][] xid_ips;
    private String[] xidempresa;
    private String xsql;
    private String xtitulo;
    private File xfile;
    private WorkerSQL xWorkerSQL;
    private List<IInformeCircular015_ST006> informeCircular015_ST006s;
    private List<IInformeResolucion1552Projection> listainformeResolucion1552;
    private ButtonGroup JBG_Filtro;
    private JButton JBTGenerar;
    private JComboBox JCBEmpresa;
    private JComboBox JCB_Combo1;
    private JCheckBox JCHFiltro;
    private JCheckBox JCH_Agrupacion;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBNRegistro;
    private JPanel JPExportar;
    private JPanel JPGenerar;
    private JPanel JPIDatos;
    private JRadioButton JRB_Exportar;
    private JRadioButton JRB_Generar;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleTipo2;
    private JScrollPane JSPDetalleTipo3;
    private JScrollPane JSPDetalleTipo4;
    private JScrollPane JSPDetalleTipo5;
    private JScrollPane JSPDetalleTipo6;
    private JTable JTDetalle;
    private JTable JTDetalleTipo2;
    private JTable JTDetalleTipo3;
    private JTable JTDetalleTipo4;
    private JTable JTDetalleTipo5;
    private JTable JTDetalleTipo6;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatosC;
    private JTabbedPane JTPExportar;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xcodigo = "";
    private boolean xlleno = false;
    private boolean xllenof = false;
    private long xnregistro = 0;
    private int xForma = -1;
    private int Pos = 1;
    private final ILiquidacionService liquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
    private final IInformeResolucion1552Service informeResolucion1552Service = (IInformeResolucion1552Service) Principal.contexto.getBean(IInformeResolucion1552Service.class);
    private List<ICargarCombo> listaCargarCombo = new ArrayList();

    public JIF_Informes_GResoluciones(String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        this.xtitulo = xtitulo;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v62, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCB_Combo1 = new JComboBox();
        this.JLBNRegistro = new JLabel();
        this.JCH_Agrupacion = new JCheckBox();
        this.JTPDatosC = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalleTipo2 = new JScrollPane();
        this.JTDetalleTipo2 = new JTable();
        this.JSPDetalleTipo3 = new JScrollPane();
        this.JTDetalleTipo3 = new JTable();
        this.JSPDetalleTipo4 = new JScrollPane();
        this.JTDetalleTipo4 = new JTable();
        this.JSPDetalleTipo5 = new JScrollPane();
        this.JTDetalleTipo5 = new JTable();
        this.JSPDetalleTipo6 = new JScrollPane();
        this.JTDetalleTipo6 = new JTable();
        this.JTPExportar = new JTabbedPane();
        this.JPGenerar = new JPanel();
        this.JCBEmpresa = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        this.JRB_Generar = new JRadioButton();
        this.JRB_Exportar = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_informes_resoluciones");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIF_Informes_GResoluciones.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Informes_GResoluciones.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIF_Informes_GResoluciones.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Informes_GResoluciones.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCB_Combo1.setFont(new Font("Arial", 1, 12));
        this.JCB_Combo1.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(Color.red);
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.JCH_Agrupacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Agrupacion.setText("Agrupación?");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Combo1, -2, 432, -2).addGap(18, 18, 18).addComponent(this.JCH_Agrupacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNRegistro, -2, 125, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCH_Agrupacion)).addComponent(this.JLBNRegistro, -1, 55, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JCB_Combo1, GroupLayout.Alignment.LEADING)).addContainerGap()));
        this.JTPDatosC.setForeground(Color.red);
        this.JTPDatosC.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatosC.addTab("DETALLE", this.JSPDetalle);
        this.JSPDetalleTipo2.setBorder((Border) null);
        this.JTDetalleTipo2.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTipo2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleTipo2.setRowHeight(25);
        this.JTDetalleTipo2.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleTipo2.setSelectionForeground(Color.red);
        this.JTDetalleTipo2.addKeyListener(new KeyAdapter() { // from class: Sig.JIF_Informes_GResoluciones.3
            public void keyPressed(KeyEvent evt) {
                JIF_Informes_GResoluciones.this.JTDetalleTipo2KeyPressed(evt);
            }
        });
        this.JSPDetalleTipo2.setViewportView(this.JTDetalleTipo2);
        this.JTPDatosC.addTab("TIPO2", this.JSPDetalleTipo2);
        this.JSPDetalleTipo3.setBorder((Border) null);
        this.JTDetalleTipo3.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTipo3.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleTipo3.setRowHeight(25);
        this.JTDetalleTipo3.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleTipo3.setSelectionForeground(Color.red);
        this.JTDetalleTipo3.addKeyListener(new KeyAdapter() { // from class: Sig.JIF_Informes_GResoluciones.4
            public void keyPressed(KeyEvent evt) {
                JIF_Informes_GResoluciones.this.JTDetalleTipo3KeyPressed(evt);
            }
        });
        this.JSPDetalleTipo3.setViewportView(this.JTDetalleTipo3);
        this.JTPDatosC.addTab("TIPO3", this.JSPDetalleTipo3);
        this.JSPDetalleTipo4.setBorder((Border) null);
        this.JTDetalleTipo4.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTipo4.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleTipo4.setRowHeight(25);
        this.JTDetalleTipo4.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleTipo4.setSelectionForeground(Color.red);
        this.JTDetalleTipo4.addKeyListener(new KeyAdapter() { // from class: Sig.JIF_Informes_GResoluciones.5
            public void keyPressed(KeyEvent evt) {
                JIF_Informes_GResoluciones.this.JTDetalleTipo4KeyPressed(evt);
            }
        });
        this.JSPDetalleTipo4.setViewportView(this.JTDetalleTipo4);
        this.JTPDatosC.addTab("TIPO4", this.JSPDetalleTipo4);
        this.JSPDetalleTipo5.setBorder((Border) null);
        this.JTDetalleTipo5.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTipo5.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleTipo5.setRowHeight(25);
        this.JTDetalleTipo5.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleTipo5.setSelectionForeground(Color.red);
        this.JTDetalleTipo5.addKeyListener(new KeyAdapter() { // from class: Sig.JIF_Informes_GResoluciones.6
            public void keyPressed(KeyEvent evt) {
                JIF_Informes_GResoluciones.this.JTDetalleTipo5KeyPressed(evt);
            }
        });
        this.JSPDetalleTipo5.setViewportView(this.JTDetalleTipo5);
        this.JTPDatosC.addTab("TIPO5", this.JSPDetalleTipo5);
        this.JSPDetalleTipo6.setBorder((Border) null);
        this.JTDetalleTipo6.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTipo6.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleTipo6.setRowHeight(25);
        this.JTDetalleTipo6.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleTipo6.setSelectionForeground(Color.red);
        this.JTDetalleTipo6.addKeyListener(new KeyAdapter() { // from class: Sig.JIF_Informes_GResoluciones.7
            public void keyPressed(KeyEvent evt) {
                JIF_Informes_GResoluciones.this.JTDetalleTipo6KeyPressed(evt);
            }
        });
        this.JSPDetalleTipo6.setViewportView(this.JTDetalleTipo6);
        this.JTPDatosC.addTab("TIPO6", this.JSPDetalleTipo6);
        this.JTPExportar.setForeground(Color.red);
        this.JTPExportar.setFont(new Font("Arial", 1, 14));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Sig.JIF_Informes_GResoluciones.8
            public void itemStateChanged(ItemEvent evt) {
                JIF_Informes_GResoluciones.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCBEmpresa.addActionListener(new ActionListener() { // from class: Sig.JIF_Informes_GResoluciones.9
            public void actionPerformed(ActionEvent evt) {
                JIF_Informes_GResoluciones.this.JCBEmpresaActionPerformed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtrar por Empresa?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Sig.JIF_Informes_GResoluciones.10
            public void actionPerformed(ActionEvent evt) {
                JIF_Informes_GResoluciones.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPGenerarLayout = new GroupLayout(this.JPGenerar);
        this.JPGenerar.setLayout(JPGenerarLayout);
        JPGenerarLayout.setHorizontalGroup(JPGenerarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGenerarLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBEmpresa, 0, 760, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addGap(28, 28, 28)));
        JPGenerarLayout.setVerticalGroup(JPGenerarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPGenerarLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(JPGenerarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -1, 50, 32767).addComponent(this.JCHFiltro)).addContainerGap()));
        this.JTPExportar.addTab("FILTRAR", this.JPGenerar);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIF_Informes_GResoluciones.11
            public void mouseClicked(MouseEvent evt) {
                JIF_Informes_GResoluciones.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Sig.JIF_Informes_GResoluciones.12
            public void actionPerformed(ActionEvent evt) {
                JIF_Informes_GResoluciones.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Generar);
        this.JRB_Generar.setFont(new Font("Arial", 1, 12));
        this.JRB_Generar.setSelected(true);
        this.JRB_Generar.setText("Generar");
        this.JRB_Generar.addActionListener(new ActionListener() { // from class: Sig.JIF_Informes_GResoluciones.13
            public void actionPerformed(ActionEvent evt) {
                JIF_Informes_GResoluciones.this.JRB_GenerarActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Exportar);
        this.JRB_Exportar.setFont(new Font("Arial", 1, 12));
        this.JRB_Exportar.setText("Exportar");
        this.JRB_Exportar.addActionListener(new ActionListener() { // from class: Sig.JIF_Informes_GResoluciones.14
            public void actionPerformed(ActionEvent evt) {
                JIF_Informes_GResoluciones.this.JRB_ExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPExportarLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFRuta, -2, 464, -2).addGap(18, 18, 18).addComponent(this.JBTGenerar, -2, 230, -2).addGap(64, 64, 64).addComponent(this.JRB_Generar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Exportar).addContainerGap()));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPExportarLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JBTGenerar, -2, 41, -2)).addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Generar).addComponent(this.JRB_Exportar))).addContainerGap()));
        this.JTPExportar.addTab("EXPORTAR", this.JPExportar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPExportar, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTPDatosC)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTPDatosC, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPExportar, -2, 100, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: Sig.JIF_Informes_GResoluciones.15
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
    }

    private void mCrearModeloDatosC015() {
        this.xmodelo = new DefaultTableModel() { // from class: Sig.JIF_Informes_GResoluciones.16
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("idPoliza");
        this.xmodelo.addColumn("fechaVencimiento");
        this.xmodelo.addColumn("idVictima");
        this.xmodelo.addColumn("codigoPrestador");
        this.xmodelo.addColumn("idPrestador");
        this.xmodelo.addColumn("fechaSiniestro");
        this.xmodelo.addColumn("idPagador");
        this.xmodelo.addColumn("idFactura");
        this.xmodelo.addColumn("fechaFactura");
        this.xmodelo.addColumn("fechaRadicacion");
        this.xmodelo.addColumn("valorProcedimientos");
        this.xmodelo.addColumn("valorInsumo");
        this.xmodelo.addColumn("valorMedicamentos");
        this.xmodelo.addColumn("valorOtros");
        this.xmodelo.addColumn("valorFactura");
        JTable jTable = this.JTDetalleTipo2;
        JTable jTable2 = this.JTDetalleTipo2;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo2.doLayout();
        this.JTDetalleTipo2.setModel(this.xmodelo);
        this.JTDetalleTipo2.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalleTipo2.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(13).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.JTDetalleTipo2.setModel(this.xmodelo);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosC014() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Nit", "Dv", "Periodo", "Año", "TFactura", "NFactura", "Valor", "CEps", "CMunicipio", "VAcuerdo", "Convenio"}) { // from class: Sig.JIF_Informes_GResoluciones.17
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleTipo2;
        JTable jTable2 = this.JTDetalleTipo2;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo2.doLayout();
        this.JTDetalleTipo2.setModel(this.xmodelo);
        this.JTDetalleTipo2.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleTipo2.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleTipo2.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalleTipo2.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleTipo2.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(10).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosC014_FT0025() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Nit", "Razon Social", "Tipo Aseguramiento", "Contrato", "Otro Contrato", "Valor Radicado", "Valor Pagos"}) { // from class: Sig.JIF_Informes_GResoluciones.18
            Class[] types = {String.class, String.class, Integer.class, Integer.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosConvenios014() {
        this.xmodelotp2 = new DefaultTableModel(new Object[0], new String[]{"ID", "Nombre", "Seleccionar"}) { // from class: Sig.JIF_Informes_GResoluciones.19
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelotp2);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs("SELECT `p_res_2175`.`Id` , `persona`.`NUsuario` FROM `p_res_2175` INNER JOIN  `persona`  ON (`p_res_2175`.`IdUsuario` = `persona`.`Id_persona`) ORDER BY `p_res_2175`.`Id`;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    n++;
                    this.JLBNRegistro.setText("" + n);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mverifarConvenioSeleccionado014() {
        this.xcodigo = "";
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodelotp2.getValueAt(i, 2).toString()).booleanValue()) {
                this.xcodigo += "," + this.xmodelotp2.getValueAt(i, 0).toString();
            }
        }
        return this.xcodigo;
    }

    private void mCargarDatosTablaC014() {
        String sql;
        try {
            mCrearModeloDatosC014();
            mverifarConvenioSeleccionado014();
            if (!this.xcodigo.isEmpty()) {
                sql = "SELECT\n   `g_ips`.`Identificacion`\n    , `g_ips`.`DigitoVerificacion`\n    , DATE_FORMAT(`f_factura_evento`.`FechaRadicado`,'%m') AS `Mes`\n    , DATE_FORMAT(`f_factura_evento`.`FechaRadicado`,'%Y') AS `Ano`\n,  IF(f_empresacontxconvenio.`EsCapitado`=1,1,2) AS `TipoFac`\n    , CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`) AS `NFactura`\n    , `f_liquidacion`.`TotalEps`\n    , `f_empresacontxconvenio`.`CRips`\n    ,  IF(f_empresacontxconvenio.`EsCapitado`=1,f_empresacontxconvenio.`IdMunicipio`,g_ips.`Id_Municipio`)  AS `Municipio`\n    , `g_contratos`.`VGiroD`\n    ,  f_empresacontxconvenio.Nbre AS Convenio\nFROM\n    `f_factura_evento`\n    INNER JOIN `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)\n    INNER JOIN `g_contratos` \n        ON (`g_contratos`.`Id_EmpresaContConvenio` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\nWHERE (`f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`Estado` =0\n    AND `g_contratos`.`Estado` =0\n    AND `f_factura_evento`.`FechaRadicado` IS NOT NULL\n    AND `f_factura_evento`.`FechaRadicado` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `f_empresacontxconvenio`.`Id` IN (" + this.xcodigo.substring(1, this.xcodigo.length()) + ")\n    AND `f_factura_evento`.`FechaRadicado` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND  `f_liquidacion`.`TotalEps`<>0)\n-- GROUP BY `f_empresacontxconvenio`.`Id`\nORDER BY `f_empresacontxconvenio`.`Nbre` ASC, IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento`))  ASC";
            } else {
                sql = "SELECT\n   `g_ips`.`Identificacion`\n    , `g_ips`.`DigitoVerificacion`\n    , DATE_FORMAT(`f_factura_evento`.`FechaRadicado`,'%m') AS `Mes`\n    , DATE_FORMAT(`f_factura_evento`.`FechaRadicado`,'%Y') AS `Ano`\n,  IF(f_empresacontxconvenio.`EsCapitado`=1,1,2) AS `TipoFac`\n    , CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`) AS `NFactura`\n    , `f_liquidacion`.`TotalEps`\n    , `f_empresacontxconvenio`.`CRips`\n    ,  IF(f_empresacontxconvenio.`EsCapitado`=1,f_empresacontxconvenio.`IdMunicipio`,g_ips.`Id_Municipio`)  AS `Municipio`\n    , `g_contratos`.`VGiroD`\n    ,  f_empresacontxconvenio.Nbre AS Convenio\nFROM\n    `f_factura_evento`\n    INNER JOIN `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)\n    INNER JOIN `g_contratos` \n        ON (`g_contratos`.`Id_EmpresaContConvenio` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\nWHERE (`f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`Estado` =0\n    AND `g_contratos`.`Estado` =0\n    AND `f_factura_evento`.`FechaRadicado` IS NOT NULL\n    AND `f_factura_evento`.`FechaRadicado` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `f_factura_evento`.`FechaRadicado` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND  `f_liquidacion`.`TotalEps`<>0)\n-- GROUP BY `f_empresacontxconvenio`.`Id`\nORDER BY `f_empresacontxconvenio`.`Nbre` ASC, IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento`))  ASC";
            }
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    n++;
                }
                this.JLBNRegistro.setText("" + n);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaC014_FT0025() {
        try {
            mCrearModeloDatosC014_FT0025();
            String sql = "WITH infoConvenio AS (\nSELECT\n    `g_empresa`.`No_identificacion` AS `nit`\n    , `g_empresa`.`Nbre` AS `razonSocial`\n    , `g_tipo_aseguramiento`.`id` AS `tipoAseguramiento`\n    , `g_tipo_contratacion`.`id` AS `tipoContrato`\n    , '' AS `otroContrato`\n    , `f_empresacontxconvenio`.`Id` AS `idEmpresConvenio`\nFROM\n    `f_empresacontxconvenio`\n    INNER JOIN `g_empresa` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\n    INNER JOIN `f_liquidacion` \n        ON (`f_liquidacion`.`IdEmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `g_tipo_contratacion` \n        ON (`f_empresacontxconvenio`.`idTipoContratacion` = `g_tipo_contratacion`.`id`)\n    INNER JOIN `g_tipo_aseguramiento` \n        ON (`f_empresacontxconvenio`.`idTipoAseguramiento` = `g_tipo_aseguramiento`.`id`)\nWHERE (`f_factura_evento`.`EstaArmada` =2)\nGROUP BY `tipoContrato`, `f_empresacontxconvenio`.`Id`\nORDER BY `razonSocial` ASC\n)\n, \n   infoRadicacion AS   (\n\tSELECT\n\t    `f_liquidacion`.`IdEmpresaContxConv`\n\t    , SUM(`f_liquidacion`.`TotalEps`) AS `valorRadicacion`\t  \n\tFROM\n\t    `f_factura_evento`\n\t    INNER JOIN `f_liquidacion` \n\t\tON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n\tWHERE (`f_factura_evento`.`EstaArmada` =2\n\t    AND `f_factura_evento`.`Estado` =0\n\t    AND `f_liquidacion`.`Estado` =0\n\t    AND `f_factura_evento`.`FechaRadicado` BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')\n\tGROUP BY `f_liquidacion`.`IdEmpresaContxConv`\n )\n ,\n infoPagos AS (\n\t SELECT\n\t    `f_liquidacion`.`IdEmpresaContxConv`\n\t    , SUM(`f_factura_pagos`.`Valor`) AS `valorPago`   \n\tFROM\n\t    `f_factura_evento`\n\t    INNER JOIN `f_liquidacion` \n\t\tON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n\t    INNER JOIN `f_factura_pagos` \n\t\tON (`f_factura_pagos`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n     INNER JOIN f_tipoconcepto_pago\n         ON f_factura_pagos.Id_ConceptoPago = f_tipoconcepto_pago.Id\n\tWHERE (`f_factura_pagos`.`Estado` =1\n\t    AND `f_factura_pagos`.`FechaAbono` BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' )\n     AND f_tipoconcepto_pago.`visualizarInforme014`=1\n\tGROUP BY `f_liquidacion`.`IdEmpresaContxConv`\n)\n \nSELECT infoConvenio.`nit`\n    , infoConvenio.`razonSocial`\n    , infoConvenio.`tipoAseguramiento`\n    , infoConvenio.`tipoContrato`\n    , infoConvenio.`otroContrato`\n    , round(sum(IFNULL(infoRadicacion.valorRadicacion, 0))) valorRadicacion\n    , round(sum(IFNULL(infoPagos.valorPago,0))) valorPagos,  `infoConvenio`.`idEmpresConvenio`\nFROM  infoConvenio \nLEFT JOIN infoRadicacion ON (infoRadicacion.IdEmpresaContxConv=infoConvenio.idEmpresConvenio)\nLEFT JOIN infoPagos ON (infoPagos.IdEmpresaContxConv=infoConvenio.idEmpresConvenio)\n\ngroup by infoConvenio.`nit`, infoConvenio.`tipoAseguramiento`, infoConvenio.`tipoContrato`\nhaving valorRadicacion<>0 || valorPagos<>0\norder by razonSocial asc\n\n;";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString("nit"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("razonSocial"), n, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("tipoAseguramiento")), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("tipoContrato")), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("otroContrato"), n, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("valorRadicacion")), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("valorPagos")), n, 6);
                    n++;
                }
                this.JLBNRegistro.setText("" + n);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaConvenios014() {
        try {
            mCrearModeloDatosConvenios014();
            String sql = "SELECT\n    `f_empresacontxconvenio`.`Id`\n    , `f_empresacontxconvenio`.`Nbre`\nFROM\n    `f_factura_evento`\n    INNER JOIN `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)\n    INNER JOIN `g_contratos` \n        ON (`g_contratos`.`Id_EmpresaContConvenio` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\nWHERE (`f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`Estado` =0\n    AND `g_contratos`.`Estado` =0\n    AND `f_factura_evento`.`FechaRadicado` IS NOT NULL\n    AND `f_factura_evento`.`FechaRadicado` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' \n    AND `f_factura_evento`.`FechaRadicado` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' )\nGROUP BY `f_empresacontxconvenio`.`Id`\nORDER BY `f_empresacontxconvenio`.`Nbre` ASC";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelotp2.addRow(this.xdato);
                    this.xmodelotp2.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelotp2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelotp2.setValueAt(false, n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatosTablaC015_ST006() {
        this.informeCircular015_ST006s = new ArrayList();
        this.informeCircular015_ST006s = this.liquidacionService.listaInformeCircular015_ST006(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        System.out.println("entrooo" + this.informeCircular015_ST006s.size());
        mCrearModeloDatosC015();
        this.informeCircular015_ST006s.forEach(item -> {
            this.xmodelo.addRow(this.xdato);
            this.xmodelo.setValueAt(item.getNumeroPoliza(), this.JTDetalleTipo2.getRowCount() - 1, 0);
            this.xmodelo.setValueAt(item.getFechaPoliza(), this.JTDetalleTipo2.getRowCount() - 1, 1);
            this.xmodelo.setValueAt(item.getDocumentoVictima(), this.JTDetalleTipo2.getRowCount() - 1, 2);
            this.xmodelo.setValueAt(item.getCodigoHabilitacion(), this.JTDetalleTipo2.getRowCount() - 1, 3);
            this.xmodelo.setValueAt(item.getNitPrestador(), this.JTDetalleTipo2.getRowCount() - 1, 4);
            this.xmodelo.setValueAt(item.getFechaSinistro(), this.JTDetalleTipo2.getRowCount() - 1, 5);
            this.xmodelo.setValueAt(item.getNitPagador(), this.JTDetalleTipo2.getRowCount() - 1, 6);
            this.xmodelo.setValueAt(item.getNumeroFactura(), this.JTDetalleTipo2.getRowCount() - 1, 7);
            this.xmodelo.setValueAt(item.getFechaFactura(), this.JTDetalleTipo2.getRowCount() - 1, 8);
            this.xmodelo.setValueAt(item.getFechaRadicacion(), this.JTDetalleTipo2.getRowCount() - 1, 9);
            this.xmodelo.setValueAt(item.getValorProcedimiento(), this.JTDetalleTipo2.getRowCount() - 1, 10);
            this.xmodelo.setValueAt(item.getValorInsumo(), this.JTDetalleTipo2.getRowCount() - 1, 11);
            this.xmodelo.setValueAt(item.getValorSuministro(), this.JTDetalleTipo2.getRowCount() - 1, 12);
            this.xmodelo.setValueAt(item.getValorOtros(), this.JTDetalleTipo2.getRowCount() - 1, 13);
            this.xmodelo.setValueAt(item.getValorFactura(), this.JTDetalleTipo2.getRowCount() - 1, 14);
        });
        this.JLBNRegistro.setText("" + this.JTDetalleTipo2.getRowCount());
    }

    private void gerenarXMLST006() {
        try {
            generate("ST006");
        } catch (Exception ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void generate(String name) throws Exception {
        if (this.JTDetalleTipo2.getRowCount() > 0) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");
            Element raiz = document.getDocumentElement();
            this.informeCircular015_ST006s.forEach(item -> {
                Element itemNode = document.createElement("RegistroST006");
                Element idPolizaValue = document.createElement("idPoliza");
                Text idPolizaValueDato = document.createTextNode(item.getNumeroPoliza());
                idPolizaValue.appendChild(idPolizaValueDato);
                itemNode.appendChild(idPolizaValue);
                Element fechaVencimientoValue = document.createElement("fechaVencimiento");
                Text fechaVencimientoValueDato = document.createTextNode(item.getFechaPoliza());
                fechaVencimientoValue.appendChild(fechaVencimientoValueDato);
                itemNode.appendChild(fechaVencimientoValue);
                Element idVictimaValue = document.createElement("idVictima");
                Text idVictimaValueDato = document.createTextNode(item.getDocumentoVictima());
                idVictimaValue.appendChild(idVictimaValueDato);
                itemNode.appendChild(idVictimaValue);
                Element codigoPrestadorValue = document.createElement("codigoPrestador");
                Text codigoPrestadorValueDato = document.createTextNode(item.getCodigoHabilitacion());
                codigoPrestadorValue.appendChild(codigoPrestadorValueDato);
                itemNode.appendChild(codigoPrestadorValue);
                Element idPrestadorValue = document.createElement("idPrestador");
                Text idPrestadorValueDato = document.createTextNode(item.getNitPrestador());
                idPrestadorValue.appendChild(idPrestadorValueDato);
                itemNode.appendChild(idPrestadorValue);
                Element fechaSiniestroValue = document.createElement("fechaSiniestro");
                Text fechaSiniestroValueDato = document.createTextNode(item.getFechaSinistro());
                fechaSiniestroValue.appendChild(fechaSiniestroValueDato);
                itemNode.appendChild(fechaSiniestroValue);
                Element idPagadorValue = document.createElement("idPagador");
                Text idPagadorValueDato = document.createTextNode(item.getNitPagador());
                idPagadorValue.appendChild(idPagadorValueDato);
                itemNode.appendChild(idPagadorValue);
                Element idFacturaValue = document.createElement("idFactura");
                Text idFacturaValueDato = document.createTextNode(item.getNumeroFactura());
                idFacturaValue.appendChild(idFacturaValueDato);
                itemNode.appendChild(idFacturaValue);
                Element fechaFacturaValue = document.createElement("fechaFactura");
                Text fechaFacturaValueDato = document.createTextNode(item.getFechaFactura());
                fechaFacturaValue.appendChild(fechaFacturaValueDato);
                itemNode.appendChild(fechaFacturaValue);
                Element fechaRadicacionValue = document.createElement("fechaRadicacion");
                Text fechaRadicacionValueDato = document.createTextNode(item.getFechaRadicacion());
                fechaRadicacionValue.appendChild(fechaRadicacionValueDato);
                itemNode.appendChild(fechaRadicacionValue);
                Element valorProcedimientosValue = document.createElement("valorProcedimientos");
                Text valorProcedimientosValueDato = document.createTextNode(item.getValorProcedimiento().toString());
                valorProcedimientosValue.appendChild(valorProcedimientosValueDato);
                itemNode.appendChild(valorProcedimientosValue);
                Element valorInsumoValue = document.createElement("valorInsumo");
                Text valorInsumoValueDato = document.createTextNode(item.getValorInsumo().toString());
                valorInsumoValue.appendChild(valorInsumoValueDato);
                itemNode.appendChild(valorInsumoValue);
                Element valorMedicamentosValue = document.createElement("valorMedicamentos");
                Text valorMedicamentosValueDato = document.createTextNode(item.getValorSuministro().toString());
                valorMedicamentosValue.appendChild(valorMedicamentosValueDato);
                itemNode.appendChild(valorMedicamentosValue);
                Element valorOtrosValue = document.createElement("valorOtros");
                Text valorOtrosValueDato = document.createTextNode(item.getValorOtros().toString());
                valorOtrosValue.appendChild(valorOtrosValueDato);
                itemNode.appendChild(valorOtrosValue);
                Element valorFacturaValue = document.createElement("valorFactura");
                Text valorFacturaValueDato = document.createTextNode(item.getValorFactura().toString());
                valorFacturaValue.appendChild(valorFacturaValueDato);
                itemNode.appendChild(valorFacturaValue);
                raiz.appendChild(itemNode);
            });
            Source source = new DOMSource(document);
            Result result = new StreamResult(new File(this.JTFRuta.getText() + name + ".xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mCargarDatosTablaC015() {
        String sql;
        try {
            mCrearModeloDatosC015();
            if (this.JCHFiltro.isSelected()) {
                if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
                    sql = "SELECT\n    IF(`a_accidentetransito`.`NoPoliza` IS NULL, ingreso.`NoPoliza`, `a_accidentetransito`.`NoPoliza`) AS `idPoliza`\n    ,IF(a_estadoasegveh.`MPoliza`=1,DATE_FORMAT(`a_accidentetransito`.`FechaFinPol`,'%Y%m%d'), '00000000') AS `FVencimientoP`\n    , `g_persona`.`NoDocumento` AS `idVictima`\n    , `d_ips`.`CodigoOrganismo` AS `CHabilitacion`\n    , `d_ips`.`NIEmpresa` AS `idPrestador`\n    , DATE_FORMAT(`a_eventoecat`.`Fechaeventoecat`,'%Y%m%d') AS `fechaSiniestro`\n    , `g_empresa`.`No_identificacion` AS `idPagador`\n    , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,'',`f_factura_evento`.`No_FacturaEvento`))  AS `idFactura`\n    ,  DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%Y%m%d') AS `fechaFactura`\n    , IFNULL( DATE_FORMAT(`f_factura_evento`.`FechaRadicado` ,'%Y%m%d'), '')AS `fechaRadicado`\n    , IFNULL((SELECT\n    \n     SUM(((`f_itemordenesproced`.`Cantidad`*`f_itemordenesproced`.`ValorUnitario`)-`f_itemordenesproced`.`ValorDescuento`)) AS `ValorProce`\nFROM\n    `f_itemordenesproced`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE (`f_itemordenesproced`.`EsCobrable` =1\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VProced\n, IFNULL((SELECT\n    \n     SUM((((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`)) AS `ValorSumini`\nFROM\n    `f_itemordenessum`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `i_suministro`\n        ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nWHERE (`f_itemordenessum`.`EsCobrable`=1  AND i_suministro.`EsMaterial`=1\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VInsumo\n, IFNULL((SELECT\n    \n     SUM((((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`)) AS `ValorSumini`\nFROM\n    `f_itemordenessum`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `i_suministro`\n        ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nWHERE (`f_itemordenessum`.`EsCobrable`=1  AND i_suministro.`EsMaterial`=0\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VMedicamentos\n,IFNULL((SELECT\n    SUM(`f_itemordenesqx`.`Valor`)  ValorQx\nFROM\n    `f_ordenesqx`\n    INNER JOIN `f_ordenes` \n        ON (`f_ordenesqx`.`Id_Orden` = `f_ordenes`.`Id`)\n    INNER JOIN `f_itemordenesqx` \n        ON (`f_itemordenesqx`.`Id_OrdenQX` = `f_ordenesqx`.`Id`)\nWHERE (`f_ordenes`.`Id_Ingreso` =`ingreso`.`Id`\n    AND `f_ordenes`.`Estado` =0\n    AND `f_ordenesqx`.`Estado` =1)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VOtrosProc, f_liquidacion.`TotalEps` VFactura, IF(a_estadoasegveh.`Id` IS NULL, 1,a_estadoasegveh.`Id`) EtadoAsegurado\nFROM \n    `ingreso`\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) AND (`a_eventoecat_paciente`.`Id_Persona` = `g_usuario`.`Id_persona`)\n    INNER JOIN `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n    LEFT JOIN `a_accidentetransito` \n        ON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`)\n    LEFT JOIN `a_estadoasegveh`\n        ON (`a_accidentetransito`.`Id_estadoasegveh` = `a_estadoasegveh`.`Id`)\n    INNER JOIN `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `f_liquidacion` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)   \n    INNER JOIN `d_ips` \n        ON (`d_ips`.`Id` = `f_empresacontxconvenio`.`Id_GIps`)   \n                                        \nWHERE (f_factura_evento.`Estado`=0 AND f_liquidacion.`Estado`=0 AND `ingreso`.`Estado` =0\n    AND `a_eventoecat`.`Estado` =1 AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'  \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' ) ORDER  BY ingreso.`FechaIngreso` ;";
                } else {
                    sql = "SELECT\n    `a_accidentetransito`.`NoPoliza` AS `idPoliza`\n    ,IF(a_estadoasegveh.`MPoliza`=1,DATE_FORMAT(`a_accidentetransito`.`FechaFinPol`,'%Y%m%d'), '00000000') AS `FVencimientoP`\n    , `g_persona`.`NoDocumento` AS `idVictima`\n    , `d_ips`.`CodigoOrganismo` AS `CHabilitacion`\n    , `d_ips`.`NIEmpresa` AS `idPrestador`\n    , DATE_FORMAT(`a_eventoecat`.`Fechaeventoecat`,'%Y%m%d') AS `fechaSiniestro`\n    , `g_empresa`.`No_identificacion` AS `idPagador`\n    , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,'',`f_factura_evento`.`No_FacturaEvento`))  AS `idFactura`\n    ,  DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%Y%m%d') AS `fechaFactura`\n    ,  DATE_FORMAT(`f_factura_evento`.`FechaRadicado` ,'%Y%m%d')AS `fechaRadicado`\n    , IFNULL((SELECT\n    \n     SUM(((`f_itemordenesproced`.`Cantidad`*`f_itemordenesproced`.`ValorUnitario`)-`f_itemordenesproced`.`ValorDescuento`)) AS `ValorProce`\nFROM\n    `f_itemordenesproced`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE (`f_itemordenesproced`.`EsCobrable` =1\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VProced\n, IFNULL((SELECT\n    \n     SUM((((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`)) AS `ValorSumini`\nFROM\n    `f_itemordenessum`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `i_suministro`\n        ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nWHERE (`f_itemordenessum`.`EsCobrable`=1  AND i_suministro.`EsMaterial`=1\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VInsumo\n, IFNULL((SELECT\n    \n     SUM((((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`)) AS `ValorSumini`\nFROM\n    `f_itemordenessum`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `i_suministro`\n        ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nWHERE (`f_itemordenessum`.`EsCobrable`=1  AND i_suministro.`EsMaterial`=0\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VMedicamentos\n,IFNULL((SELECT\n    SUM(`f_itemordenesqx`.`Valor`)  ValorQx\nFROM\n    `f_ordenesqx`\n    INNER JOIN `f_ordenes` \n        ON (`f_ordenesqx`.`Id_Orden` = `f_ordenes`.`Id`)\n    INNER JOIN `f_itemordenesqx` \n        ON (`f_itemordenesqx`.`Id_OrdenQX` = `f_ordenesqx`.`Id`)\nWHERE (`f_ordenes`.`Id_Ingreso` =`ingreso`.`Id`\n    AND `f_ordenes`.`Estado` =0\n    AND `f_ordenesqx`.`Estado` =1)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VOtrosProc, f_liquidacion.`TotalEps` VFactura, a_estadoasegveh.`Id`\nFROM\n    `d_ips`, \n    `ingreso`\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) AND (`a_eventoecat_paciente`.`Id_Persona` = `g_usuario`.`Id_persona`)\n    INNER JOIN `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n    INNER JOIN `a_accidentetransito` \n        ON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`)\n    INNER JOIN `a_estadoasegveh`\n        ON (`a_accidentetransito`.`Id_estadoasegveh` = `a_estadoasegveh`.`Id`)\n    INNER JOIN `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `f_liquidacion` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)                \nWHERE (f_factura_evento.`Estado`=0 AND f_liquidacion.`Estado`=0 AND `ingreso`.`Estado` =0\n    AND `a_eventoecat`.`Estado` =1 AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') ORDER  BY ingreso.`FechaIngreso` ;";
                }
            } else if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
                sql = "SELECT\n    IF(`a_accidentetransito`.`NoPoliza` IS NULL, ingreso.`NoPoliza`, `a_accidentetransito`.`NoPoliza`) AS `idPoliza`\n    ,IF(a_estadoasegveh.`MPoliza`=1,DATE_FORMAT(`a_accidentetransito`.`FechaFinPol`,'%Y%m%d'), '00000000') AS `FVencimientoP`\n    , `g_persona`.`NoDocumento` AS `idVictima`\n    , `d_ips`.`CodigoOrganismo` AS `CHabilitacion`\n    , `d_ips`.`NIEmpresa` AS `idPrestador`\n    , DATE_FORMAT(`a_eventoecat`.`Fechaeventoecat`,'%Y%m%d') AS `fechaSiniestro`\n    , `g_empresa`.`No_identificacion` AS `idPagador`\n    , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,'',`f_factura_evento`.`No_FacturaEvento`))  AS `idFactura`\n    ,  DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%Y%m%d') AS `fechaFactura`\n    , IFNULL( DATE_FORMAT(`f_factura_evento`.`FechaRadicado` ,'%Y%m%d'), '')AS `fechaRadicado`\n    , IFNULL((SELECT\n    \n     SUM(((`f_itemordenesproced`.`Cantidad`*`f_itemordenesproced`.`ValorUnitario`)-`f_itemordenesproced`.`ValorDescuento`)) AS `ValorProce`\nFROM\n    `f_itemordenesproced`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE (`f_itemordenesproced`.`EsCobrable` =1\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VProced\n, IFNULL((SELECT\n    \n     SUM((((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`)) AS `ValorSumini`\nFROM\n    `f_itemordenessum`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `i_suministro`\n        ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nWHERE (`f_itemordenessum`.`EsCobrable`=1  AND i_suministro.`EsMaterial`=1\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VInsumo\n, IFNULL((SELECT\n    \n     SUM((((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`)) AS `ValorSumini`\nFROM\n    `f_itemordenessum`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `i_suministro`\n        ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nWHERE (`f_itemordenessum`.`EsCobrable`=1  AND i_suministro.`EsMaterial`=0\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VMedicamentos\n,IFNULL((SELECT\n    SUM(`f_itemordenesqx`.`Valor`)  ValorQx\nFROM\n    `f_ordenesqx`\n    INNER JOIN `f_ordenes` \n        ON (`f_ordenesqx`.`Id_Orden` = `f_ordenes`.`Id`)\n    INNER JOIN `f_itemordenesqx` \n        ON (`f_itemordenesqx`.`Id_OrdenQX` = `f_ordenesqx`.`Id`)\nWHERE (`f_ordenes`.`Id_Ingreso` =`ingreso`.`Id`\n    AND `f_ordenes`.`Estado` =0\n    AND `f_ordenesqx`.`Estado` =1)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VOtrosProc, f_liquidacion.`TotalEps` VFactura, IF(a_estadoasegveh.`Id` IS NULL, 1,a_estadoasegveh.`Id`) EtadoAsegurado\nFROM \n    `ingreso`\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) AND (`a_eventoecat_paciente`.`Id_Persona` = `g_usuario`.`Id_persona`)\n    INNER JOIN `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n    LEFT JOIN `a_accidentetransito` \n        ON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`)\n    LEFT JOIN `a_estadoasegveh`\n        ON (`a_accidentetransito`.`Id_estadoasegveh` = `a_estadoasegveh`.`Id`)\n    INNER JOIN `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `f_liquidacion` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)   \n    INNER JOIN `d_ips` \n        ON (`d_ips`.`Id` = `f_empresacontxconvenio`.`Id_GIps`)   \n                                        \nWHERE (f_factura_evento.`Estado`=0 AND f_liquidacion.`Estado`=0 AND `ingreso`.`Estado` =0\n    AND `a_eventoecat`.`Estado` =1 AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'  \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' ) ORDER  BY ingreso.`FechaIngreso` ;";
            } else {
                sql = "SELECT\n    `a_accidentetransito`.`NoPoliza` AS `idPoliza`\n    ,IF(a_estadoasegveh.`MPoliza`=1,DATE_FORMAT(`a_accidentetransito`.`FechaFinPol`,'%Y%m%d'), '00000000') AS `FVencimientoP`\n    , `g_persona`.`NoDocumento` AS `idVictima`\n    , `d_ips`.`CodigoOrganismo` AS `CHabilitacion`\n    , `d_ips`.`NIEmpresa` AS `idPrestador`\n    , DATE_FORMAT(`a_eventoecat`.`Fechaeventoecat`,'%Y%m%d') AS `fechaSiniestro`\n    , `g_empresa`.`No_identificacion` AS `idPagador`\n    , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,'',`f_factura_evento`.`No_FacturaEvento`))  AS `idFactura`\n    ,  DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%Y%m%d') AS `fechaFactura`\n    ,  DATE_FORMAT(`f_factura_evento`.`FechaRadicado` ,'%Y%m%d')AS `fechaRadicado`\n    , IFNULL((SELECT\n    \n     SUM(((`f_itemordenesproced`.`Cantidad`*`f_itemordenesproced`.`ValorUnitario`)-`f_itemordenesproced`.`ValorDescuento`)) AS `ValorProce`\nFROM\n    `f_itemordenesproced`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE (`f_itemordenesproced`.`EsCobrable` =1\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VProced\n, IFNULL((SELECT\n    \n     SUM((((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`)) AS `ValorSumini`\nFROM\n    `f_itemordenessum`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `i_suministro`\n        ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nWHERE (`f_itemordenessum`.`EsCobrable`=1  AND i_suministro.`EsMaterial`=1\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VInsumo\n, IFNULL((SELECT\n    \n     SUM((((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`)) AS `ValorSumini`\nFROM\n    `f_itemordenessum`\n    INNER JOIN `f_ordenes` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `i_suministro`\n        ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nWHERE (`f_itemordenessum`.`EsCobrable`=1  AND i_suministro.`EsMaterial`=0\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso`=`ingreso`.`Id`)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VMedicamentos\n,IFNULL((SELECT\n    SUM(`f_itemordenesqx`.`Valor`)  ValorQx\nFROM\n    `f_ordenesqx`\n    INNER JOIN `f_ordenes` \n        ON (`f_ordenesqx`.`Id_Orden` = `f_ordenes`.`Id`)\n    INNER JOIN `f_itemordenesqx` \n        ON (`f_itemordenesqx`.`Id_OrdenQX` = `f_ordenesqx`.`Id`)\nWHERE (`f_ordenes`.`Id_Ingreso` =`ingreso`.`Id`\n    AND `f_ordenes`.`Estado` =0\n    AND `f_ordenesqx`.`Estado` =1)\nGROUP BY `f_ordenes`.`Id_Ingreso`),0) VOtrosProc, f_liquidacion.`TotalEps` VFactura, a_estadoasegveh.`Id`\nFROM\n    `d_ips`, \n    `ingreso`\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) AND (`a_eventoecat_paciente`.`Id_Persona` = `g_usuario`.`Id_persona`)\n    INNER JOIN `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n    INNER JOIN `a_accidentetransito` \n        ON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`)\n    INNER JOIN `a_estadoasegveh`\n        ON (`a_accidentetransito`.`Id_estadoasegveh` = `a_estadoasegveh`.`Id`)\n    INNER JOIN `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `f_liquidacion` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)                \nWHERE (f_factura_evento.`Estado`=0 AND f_liquidacion.`Estado`=0 AND `ingreso`.`Estado` =0\n    AND `a_eventoecat`.`Estado` =1 AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') ORDER  BY ingreso.`FechaIngreso` ;";
            }
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), n, 10);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(12)), n, 11);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(13)), n, 12);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(14)), n, 13);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(15)), n, 14);
                    n++;
                }
                this.JLBNRegistro.setText("" + n);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaTipo2() {
        String sql;
        String sql2;
        String sql3;
        try {
            mCrearModeloDatosTipo2();
            if (this.JCHFiltro.isSelected() && this.JCBEmpresa.getSelectedIndex() != -1) {
                if (this.JCH_Agrupacion.isSelected()) {
                    sql = "SELECT \n2 AS `TR` \n, 1 AS `NC` \n, `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`V256` \n, TRIM(`g_persona`.`Apellido1`) \n, TRIM(`g_persona`.`Apellido2`) \n, TRIM(`g_persona`.`Nombre1`) \n, TRIM(`g_persona`.`Nombre2`) \n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n, NR256 \n, DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') AS `FechaSolicitud` \n, '1' \n, `c_citas`.`Fecha_Cita` AS `FechaAsignacion` \n, IF(`c_citas`.`Fecha_SUsuario` IS NULL,DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d'), IF(`c_citas`.`Fecha_SUsuario`<  DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') , DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') ,`c_citas`.`Fecha_SUsuario`))  AS `FSolicitoUsuario` \nFROM \n`c_citas` \nINNER JOIN   `g_usuario`  \nON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN   `c_clasecita`  \nON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \nINNER JOIN   `g_procedimiento`  \nON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nWHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND f_tipoempresacont.AplicaR=1   AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n--  AND `g_procedimiento`.`C_Homologado` IN(890201, 890203, 890202,881112, 882841) \nAND `c_citas`.`Id_Especialidad` IN(1,382,387,461,460,1024,550,341,137,601,602) \nAND NR256 <>0 \nAND `c_citas`.`Id_MotivoDesistida` =1 AND `g_empresacont`.`Id_empresa`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'  \n-- and`g_persona`.`NoDocumento`=78301182 \n) GROUP BY `g_persona`.`NoDocumento`, NR256 \nORDER BY NR256 ASC;";
                } else {
                    sql = "SELECT \n2 AS `TR` \n, 1 AS `NC` \n, `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`V256` \n, TRIM(`g_persona`.`Apellido1`) \n, TRIM(`g_persona`.`Apellido2`) \n, TRIM(`g_persona`.`Nombre1`) \n, TRIM(`g_persona`.`Nombre2`) \n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n, NR256 \n, DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') AS `FechaSolicitud` \n, '1' \n, `c_citas`.`Fecha_Cita` AS `FechaAsignacion` \n, IF(`c_citas`.`Fecha_SUsuario` IS NULL,DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d'), IF(`c_citas`.`Fecha_SUsuario`<  DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') , DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') ,`c_citas`.`Fecha_SUsuario`))  AS `FSolicitoUsuario` \nFROM \n`c_citas` \nINNER JOIN   `g_usuario`  \nON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN   `c_clasecita`  \nON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \nINNER JOIN   `g_procedimiento`  \nON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nWHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND f_tipoempresacont.AplicaR=1   AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n--  AND `g_procedimiento`.`C_Homologado` IN(890201, 890203, 890202,881112, 882841) \nAND `c_citas`.`Id_Especialidad` IN(1,382,387,461,460,1024,550,341,137,601,602) \nAND NR256 <>0 \nAND `c_citas`.`Id_MotivoDesistida` =1 AND `g_empresacont`.`Id_empresa`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'  \n-- and`g_persona`.`NoDocumento`=78301182 \n) \nORDER BY NR256 ASC;";
                }
            } else if (this.JCH_Agrupacion.isSelected()) {
                sql = "SELECT \n2 AS `TR` \n, 1 AS `NC` \n, `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`V256` \n, TRIM(`g_persona`.`Apellido1`) \n, TRIM(`g_persona`.`Apellido2`) \n, TRIM(`g_persona`.`Nombre1`) \n, TRIM(`g_persona`.`Nombre2`) \n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n, NR256 \n, DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') AS `FechaSolicitud` \n, '1' \n, `c_citas`.`Fecha_Cita` AS `FechaAsignacion` \n, IF(`c_citas`.`Fecha_SUsuario` IS NULL,DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d'), IF(`c_citas`.`Fecha_SUsuario`<  DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') , DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') ,`c_citas`.`Fecha_SUsuario`))  AS `FSolicitoUsuario` \nFROM \n`c_citas` \nINNER JOIN   `g_usuario`  \nON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN   `c_clasecita`  \nON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \nINNER JOIN   `g_procedimiento`  \nON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nWHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND f_tipoempresacont.AplicaR=1   AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n--  AND `g_procedimiento`.`C_Homologado` IN(890201, 890203, 890202,881112, 882841) \nAND `c_citas`.`Id_Especialidad` IN(1,382,387,461,460,1024,550,341,137,601,602)  \nAND NR256 <>0 \nAND `c_citas`.`Id_MotivoDesistida` =1  \n-- and`g_persona`.`NoDocumento`=78301182 \n) GROUP BY `g_persona`.`NoDocumento`, NR256  \nORDER BY NR256 ASC;";
            } else {
                sql = "SELECT \n2 AS `TR` \n, 1 AS `NC` \n, `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`V256` \n, TRIM(`g_persona`.`Apellido1`) \n, TRIM(`g_persona`.`Apellido2`) \n, TRIM(`g_persona`.`Nombre1`) \n, TRIM(`g_persona`.`Nombre2`) \n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n, NR256 \n, DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') AS `FechaSolicitud` \n, '1' \n, `c_citas`.`Fecha_Cita` AS `FechaAsignacion` \n, IF(`c_citas`.`Fecha_SUsuario` IS NULL,DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d'), IF(`c_citas`.`Fecha_SUsuario`<  DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') , DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') ,`c_citas`.`Fecha_SUsuario`))  AS `FSolicitoUsuario` \nFROM \n`c_citas` \nINNER JOIN   `g_usuario`  \nON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN   `c_clasecita`  \nON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \nINNER JOIN   `g_procedimiento`  \nON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nWHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND f_tipoempresacont.AplicaR=1   AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n--  AND `g_procedimiento`.`C_Homologado` IN(890201, 890203, 890202,881112, 882841) \nAND `c_citas`.`Id_Especialidad` IN(1,382,387,461,460,1024,550,341,137,601,602)  \nAND NR256 <>0 \nAND `c_citas`.`Id_MotivoDesistida` =1  \n-- and`g_persona`.`NoDocumento`=78301182 \n) \nORDER BY NR256 ASC;";
            }
            System.out.println("Tipo 2 : " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            int n = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp2.addRow(this.xdato);
                    this.xmodelotp2.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelotp2.setValueAt(Long.valueOf(this.xnregistro), n, 1);
                    this.xmodelotp2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp2.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotp2.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelotp2.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelotp2.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelotp2.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelotp2.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelotp2.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelotp2.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelotp2.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelotp2.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelotp2.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelotp2.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelotp2.setValueAt(xrs.getString(16), n, 15);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            if (this.JCHFiltro.isSelected() && this.JCBEmpresa.getSelectedIndex() != -1) {
                sql2 = "SELECT \n2 AS `TR` \n, 1 AS `NC` \n, `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`V256` \n, TRIM(`g_persona`.`Apellido1`) \n, TRIM(`g_persona`.`Apellido2`) \n, TRIM(`g_persona`.`Nombre1`) \n, TRIM(`g_persona`.`Nombre2`) \n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n, 1 NR256 \n, DATE_FORMAT(ingreso.`FechaIngreso`,'%Y-%m-%d') AS `FechaSolicitud` \n, '1' \n, ingreso.`FechaIngreso` AS `FechaAsignacion` \n,ingreso.`FechaIngreso`,ingreso.`FechaIngreso`  AS `FSolicitoUsuario` \nFROM \ningreso\nINNER JOIN   `g_usuario`  \nON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN  `f_ordenes` \nON (`f_ordenes`.`Id_Ingreso`= `ingreso`.`Id`) \nINNER JOIN  `f_itemordenesproced`\nON (`f_ordenes`.`Id`= `f_itemordenesproced`.`Id_Ordenes`) \nINNER JOIN   `g_procedimiento`  \nON (`f_itemordenesproced`.`Id_Procedimiento`= `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`f_ordenes`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \n\nLEFT JOIN  c_citas\nON (`c_citas`.`Id_ingreso`= `ingreso`.`Id`) \nWHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND f_tipoempresacont.AplicaR=1   AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n  AND `g_procedimiento`.`C_Homologado` IN(890201, 890203, 890202,881112, 882841) \nAND `f_ordenes`.`Id_Especialidad`IN(1,382,387,461,460,1024,550,341,137,601,602) AND `g_empresacont`.`Id_empresa`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'  \n-- AND NR256 <>0 \nAND `f_ordenes`.`Estado` =0  AND  c_citas.`Id` IS NULL \n-- and`g_persona`.`NoDocumento`=78301182 \n) \nORDER BY NR256 ASC;";
            } else {
                sql2 = "SELECT \n2 AS `TR` \n, 1 AS `NC` \n, `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`V256` \n, TRIM(`g_persona`.`Apellido1`) \n, TRIM(`g_persona`.`Apellido2`) \n, TRIM(`g_persona`.`Nombre1`) \n, TRIM(`g_persona`.`Nombre2`) \n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n, 1 NR256 \n, DATE_FORMAT(ingreso.`FechaIngreso`,'%Y-%m-%d') AS `FechaSolicitud` \n, '1' \n, ingreso.`FechaIngreso` AS `FechaAsignacion` \n,ingreso.`FechaIngreso`,ingreso.`FechaIngreso`  AS `FSolicitoUsuario` \nFROM \ningreso\nINNER JOIN   `g_usuario`  \nON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN  `f_ordenes` \nON (`f_ordenes`.`Id_Ingreso`= `ingreso`.`Id`) \nINNER JOIN  `f_itemordenesproced`\nON (`f_ordenes`.`Id`= `f_itemordenesproced`.`Id_Ordenes`) \nINNER JOIN   `g_procedimiento`  \nON (`f_itemordenesproced`.`Id_Procedimiento`= `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`f_ordenes`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \n\nLEFT JOIN  c_citas\nON (`c_citas`.`Id_ingreso`= `ingreso`.`Id`) \nWHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND f_tipoempresacont.AplicaR=1   AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n  AND `g_procedimiento`.`C_Homologado` IN(890201, 890203, 890202,881112, 882841) \nAND `f_ordenes`.`Id_Especialidad`IN(1,382,387,461,460,1024,550,341,137,601,602) \n-- AND NR256 <>0 \nAND `f_ordenes`.`Estado` =0  AND  c_citas.`Id` IS NULL \n-- and`g_persona`.`NoDocumento`=78301182 \n) \nORDER BY NR256 ASC;";
            }
            System.out.println("Tipo 2 : " + sql2);
            ResultSet xrs2 = this.xct.traerRs(sql2);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    this.xnregistro++;
                    this.xmodelotp2.addRow(this.xdato);
                    this.xmodelotp2.setValueAt(Long.valueOf(xrs2.getLong(1)), n, 0);
                    this.xmodelotp2.setValueAt(Long.valueOf(this.xnregistro), n, 1);
                    this.xmodelotp2.setValueAt(xrs2.getString(3), n, 2);
                    this.xmodelotp2.setValueAt(xrs2.getString(4), n, 3);
                    this.xmodelotp2.setValueAt(xrs2.getString(5), n, 4);
                    this.xmodelotp2.setValueAt(xrs2.getString(6), n, 5);
                    this.xmodelotp2.setValueAt(xrs2.getString(7), n, 6);
                    this.xmodelotp2.setValueAt(xrs2.getString(8), n, 7);
                    this.xmodelotp2.setValueAt(xrs2.getString(9), n, 8);
                    this.xmodelotp2.setValueAt(xrs2.getString(10), n, 9);
                    this.xmodelotp2.setValueAt(xrs2.getString(11), n, 10);
                    this.xmodelotp2.setValueAt(xrs2.getString(12), n, 11);
                    this.xmodelotp2.setValueAt(xrs2.getString(13), n, 12);
                    this.xmodelotp2.setValueAt(xrs2.getString(14), n, 13);
                    this.xmodelotp2.setValueAt(xrs2.getString(15), n, 14);
                    this.xmodelotp2.setValueAt(xrs2.getString(16), n, 15);
                    n++;
                }
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            if (this.JCHFiltro.isSelected() && this.JCBEmpresa.getSelectedIndex() != -1) {
                sql3 = "SELECT \n2 AS `TR` \n, 1 AS `NC`\n, `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`V256` \n, TRIM(`g_persona`.`Apellido1`) \n, TRIM(`g_persona`.`Apellido2`) \n, TRIM(`g_persona`.`Nombre1`) \n, TRIM(`g_persona`.`Nombre2`) \n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n, NR256 \n, DATE_FORMAT(c_citasnp.`Fecha`,'%Y-%m-%d') AS `FechaSolicitud` \n, '1' \n, `c_citasnp`.`Fecha_Cita` AS `FechaAsignacion` \n, IF(`c_citasnp`.`Fecha_Cita` IS NULL,DATE_FORMAT(c_citasnp.`Fecha`,'%Y-%m-%d'), IF(`c_citasnp`.`Fecha_Cita`<  DATE_FORMAT(c_citasnp.`Fecha`,'%Y-%m-%d') , DATE_FORMAT(c_citasnp.`Fecha`,'%Y-%m-%d') ,`c_citasnp`.`Fecha_Cita`))  AS `FSolicitoUsuario` \nFROM \n`c_citasnp` \nINNER JOIN   `g_usuario`  \nON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN   `c_clasecita`  \nON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) \nINNER JOIN   `g_procedimiento`  \nON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nWHERE (`c_citasnp`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND f_tipoempresacont.AplicaR=1   AND `c_citasnp`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n--  AND `g_procedimiento`.`C_Homologado` IN(890201, 890203, 890202,881112, 882841) \nAND `c_citasnp`.`Id_Especialidad` IN(382,387,461,460,1024,550,341,137,601,602) \nAND NR256 <>0 \nAND `c_citasnp`.`Id_MotivoDesistida` =1 AND `g_empresacont`.`Id_empresa`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'  \n-- and`g_persona`.`NoDocumento`=78301182 \n)\nORDER BY NR256 ASC;";
            } else {
                sql3 = "SELECT \n2 AS `TR` \n, 1 AS `NC` \n, `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`V256` \n, TRIM(`g_persona`.`Apellido1`) \n, TRIM(`g_persona`.`Apellido2`) \n, TRIM(`g_persona`.`Nombre1`) \n, TRIM(`g_persona`.`Nombre2`) \n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n, NR256 \n, DATE_FORMAT(c_citasnp.`Fecha`,'%Y-%m-%d') AS `FechaSolicitud` \n, '1' \n, `c_citasnp`.`Fecha_Cita` AS `FechaAsignacion` \n, IF(`c_citasnp`.`Fecha_Cita` IS NULL,DATE_FORMAT(c_citasnp.`Fecha`,'%Y-%m-%d'), IF(`c_citasnp`.`Fecha_Cita`<  DATE_FORMAT(c_citasnp.`Fecha`,'%Y-%m-%d') , DATE_FORMAT(c_citasnp.`Fecha`,'%Y-%m-%d') ,`c_citasnp`.`Fecha_Cita`))  AS `FSolicitoUsuario` \nFROM \n`c_citasnp` \nINNER JOIN   `g_usuario`  \nON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN   `c_clasecita`  \nON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) \nINNER JOIN   `g_procedimiento`  \nON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nWHERE (`c_citasnp`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\nAND f_tipoempresacont.AplicaR=1   AND `c_citasnp`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n--  AND `g_procedimiento`.`C_Homologado` IN(890201, 890203, 890202,881112, 882841) \nAND `c_citasnp`.`Id_Especialidad` IN(382,387,461,460,1024,550,341,137,601,602)  \nAND NR256 <>0 \nAND `c_citasnp`.`Id_MotivoDesistida` =1  \n-- and`g_persona`.`NoDocumento`=78301182 \n) \nORDER BY NR256 ASC;";
            }
            System.out.println("Tipo 2 : " + sql3);
            ResultSet xrs3 = this.xct.traerRs(sql3);
            if (xrs3.next()) {
                xrs3.beforeFirst();
                while (xrs3.next()) {
                    this.xnregistro++;
                    this.xmodelotp2.addRow(this.xdato);
                    this.xmodelotp2.setValueAt(Long.valueOf(xrs3.getLong(1)), n, 0);
                    this.xmodelotp2.setValueAt(Long.valueOf(this.xnregistro), n, 1);
                    this.xmodelotp2.setValueAt(xrs3.getString(3), n, 2);
                    this.xmodelotp2.setValueAt(xrs3.getString(4), n, 3);
                    this.xmodelotp2.setValueAt(xrs3.getString(5), n, 4);
                    this.xmodelotp2.setValueAt(xrs3.getString(6), n, 5);
                    this.xmodelotp2.setValueAt(xrs3.getString(7), n, 6);
                    this.xmodelotp2.setValueAt(xrs3.getString(8), n, 7);
                    this.xmodelotp2.setValueAt(xrs3.getString(9), n, 8);
                    this.xmodelotp2.setValueAt(xrs3.getString(10), n, 9);
                    this.xmodelotp2.setValueAt(xrs3.getString(11), n, 10);
                    this.xmodelotp2.setValueAt(xrs3.getString(12), n, 11);
                    this.xmodelotp2.setValueAt(xrs3.getString(13), n, 12);
                    this.xmodelotp2.setValueAt(xrs3.getString(14), n, 13);
                    this.xmodelotp2.setValueAt(xrs3.getString(15), n, 14);
                    this.xmodelotp2.setValueAt(xrs3.getString(16), n, 15);
                    n++;
                }
            }
            xrs3.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTipo2() {
        this.xmodelotp2 = new DefaultTableModel(new Object[0], new String[]{"Tr", "Nc", "Tident", "Ndoc", "Fnc", "Sexo", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "CAPB", "NR256", "FechaS", "FueAsig", "FechaA", "FechaSU"}) { // from class: Sig.JIF_Informes_GResoluciones.20
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleTipo2.setModel(this.xmodelotp2);
        this.JTDetalleTipo2.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleTipo2.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalleTipo2.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.JTDetalleTipo2.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTDetalleTipo2.getColumnModel().getColumn(6).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(8).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(9).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(11).setPreferredWidth(40);
        this.JTDetalleTipo2.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalleTipo2.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalleTipo2.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(15).setPreferredWidth(250);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosR1552() {
        this.xmodelotp2 = new DefaultTableModel(new Object[0], new String[]{"Tr", "Nc", "Tident", "Ndoc", "Fnc", "Sexo", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Telefono", "Correo", "Direccion", "CAPB", "TipoCita", "NAutorizacion", "FSolicitud", "FSolicitudU", "FAsignacion", "CodEspecilidad"}) { // from class: Sig.JIF_Informes_GResoluciones.21
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleTipo2;
        JTable jTable2 = this.JTDetalleTipo2;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo2.doLayout();
        this.JTDetalleTipo2.setModel(this.xmodelotp2);
        this.JTDetalleTipo2.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(6).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(8).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(9).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(11).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(12).setPreferredWidth(250);
        this.JTDetalleTipo2.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(19).setPreferredWidth(100);
    }

    private void mCargarDatosTablaTipo2_R1552() {
        try {
            mCrearModeloDatosR1552();
            this.xct.ejecutarSQL("DELETE FROM `p_res_1552`");
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("INSERT INTO `p_res_1552`\nSELECT \n `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`Id` \n, TRIM(`g_persona`.`Apellido1`) Apellido1\n, TRIM(`g_persona`.`Apellido2`) Apellido2\n, TRIM(`g_persona`.`Nombre1`) Nombre1\n, TRIM(`g_persona`.`Nombre2`) Nombre2\n, g_persona.Movil AS Telefono\n, g_persona.Correo\n, g_persona.Direccion\n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n,c_clasificacion_tipocita.`Id` TipoCita\n,c_citas.`NAutorizacion`\n, DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') AS `FechaSolicitud` \n, IF(`c_citas`.`Fecha_SUsuario` IS NULL,DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d'), IF(`c_citas`.`Fecha_SUsuario`<  DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') , DATE_FORMAT(c_citas.`Fecha`,'%Y-%m-%d') ,`c_citas`.`Fecha_SUsuario`))  AS `FSolicitoUsuario` \n, `c_citas`.`Fecha_Cita` AS `FechaAsignacion` , g_especialidad.`Cups`, f_empresacontxconvenio.`Id` IdEmpresaConvenio, f_empresacontxconvenio.`Nbre` NEmpresaConvenio\n, cc_terceros.`Id` Id_Empresa, `cc_terceros`.`RazonSocialCompleta` NEmpresa\nFROM \n`c_citas` \nINNER JOIN   `g_usuario`  \nON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  `cc_terceros` \nON (`g_empresacont`.`Id_empresa` = `cc_terceros`.`Id`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN   `c_clasecita`  \nON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \nINNER JOIN   `c_clasificacion_tipocita` \nON (`c_clasificacion_tipocita`.`Id` = `c_clasecita`.`Id_ClasificacionTC`) \nINNER JOIN   `g_procedimiento`  \nON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nWHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\nAND `c_citas`.`Id_MotivoDesistida` =1  \n) \nORDER BY `c_citas`.`Fecha_Cita` ASC");
            this.xct.cerrarConexionBd();
            String sql = "INSERT INTO p_res_1552\nSELECT \n `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_sexo`.`Id` \n, TRIM(`g_persona`.`Apellido1`) Apellido1\n, TRIM(`g_persona`.`Apellido2`) Apellido2\n, TRIM(`g_persona`.`Nombre1`) Nombre1\n, TRIM(`g_persona`.`Nombre2`) Nombre2\n, g_persona.Movil AS Telefono\n, g_persona.Correo\n, g_persona.Direccion\n, IF((`g_empresacont`.`Codigo`='NA'||`g_empresacont`.`Codigo`='') , `g_municipio`.`Id`, `g_empresacont`.`Codigo`) AS `CEAPB` \n,c_clasificacion_tipocita.`Id` TipoCita\n,c_citasnp.`NAutorizacion`\n, c_citasnp.`Fecha_Cita` AS `FechaSolicitud` \n, c_citasnp.`Fecha_Cita` AS `FSolicitoUsuario` \n, `c_citasnp`.`Fecha_Cita` AS `FechaAsignacion` , g_especialidad.`Cups`, f_empresacontxconvenio.`Id` IdEmpresaConvenio, f_empresacontxconvenio.`Nbre` NEmpresaConvenio\n, cc_terceros.`Id` Id_Empresa, `cc_terceros`.`RazonSocialCompleta` NEmpresa\nFROM \n`c_citasnp` \nINNER JOIN   `g_usuario`  \nON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona`  \nON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  g_sexo  \nON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) \nINNER JOIN   `f_empresacontxconvenio`  \nON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   g_empresacont  \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  `cc_terceros` \nON (`g_empresacont`.`Id_empresa` = `cc_terceros`.`Id`) \nINNER JOIN  f_tipoempresacont  \nON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN   `c_clasecita`  \nON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`) \nINNER JOIN   `c_clasificacion_tipocita` \nON (`c_clasificacion_tipocita`.`Id` = `c_clasecita`.`Id_ClasificacionTC`) \nINNER JOIN   `g_procedimiento`  \nON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad`  \nON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nWHERE (`c_citasnp`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n AND `c_citasnp`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\nAND `c_citasnp`.`Id_MotivoDesistida` =0  \n) \nORDER BY `c_citasnp`.`Fecha_Cita` ASC";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            if (this.JCHFiltro.isSelected()) {
                if (this.xForma == 0) {
                    this.xsql = "SELECT\n    `Id_TipoIdentificacion`\n    , `NoDocumento`\n    , `FechaNac`\n    , `Id`\n    , `Apellido1`\n    , `Apellido2`\n    , `Nombre1`\n    , `Nombre2`\n    , `CEAPB`\n    , `TipoCita`\n    , `NAutorizacion`\n    , `FechaSolicitud`\n    , `FSolicitoUsuario`\n    , `FechaAsignacion`\n    , `CEspecilidad`\n    , `Telefono`\n    , `Correo`\n    , `Direccion`\nFROM\n    `p_res_1552`\nWHERE (`IdEmpresaConvenio` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "')";
                } else {
                    this.xsql = "SELECT\n    `Id_TipoIdentificacion`\n    , `NoDocumento`\n    , `FechaNac`\n    , `Id`\n    , `Apellido1`\n    , `Apellido2`\n    , `Nombre1`\n    , `Nombre2`\n    , `CEAPB`\n    , `TipoCita`\n    , `NAutorizacion`\n    , `FechaSolicitud`\n    , `FSolicitoUsuario`\n    , `FechaAsignacion`\n    , `CEspecilidad`\n    , `Telefono`\n    , `Correo`\n    , `Direccion`\nFROM\n    `p_res_1552`\nWHERE (`Id_Empresa` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "')";
                }
            } else {
                this.xsql = "SELECT\n    `Id_TipoIdentificacion`\n    , `NoDocumento`\n    , `FechaNac`\n    , `Id`\n    , `Apellido1`\n    , `Apellido2`\n    , `Nombre1`\n    , `Nombre2`\n    , `CEAPB`\n    , `TipoCita`\n    , `NAutorizacion`\n    , `FechaSolicitud`\n    , `FSolicitoUsuario`\n    , `FechaAsignacion`\n    , `CEspecilidad`\n    , `Telefono`\n    , `Correo`\n    , `Direccion`\nFROM\n    `p_res_1552`";
            }
            this.xnregistro = 0L;
            System.out.println("Tipo 2 : " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            System.out.println("la consulta " + sql);
            int n = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp2.addRow(this.xdato);
                    this.xmodelotp2.setValueAt(2, n, 0);
                    this.xmodelotp2.setValueAt(Long.valueOf(this.xnregistro), n, 1);
                    this.xmodelotp2.setValueAt(xrs.getString(1), n, 2);
                    this.xmodelotp2.setValueAt(xrs.getString(2), n, 3);
                    this.xmodelotp2.setValueAt(xrs.getString(3), n, 4);
                    this.xmodelotp2.setValueAt(xrs.getString(4), n, 5);
                    this.xmodelotp2.setValueAt(xrs.getString(5), n, 6);
                    this.xmodelotp2.setValueAt(xrs.getString(6), n, 7);
                    this.xmodelotp2.setValueAt(xrs.getString(7), n, 8);
                    this.xmodelotp2.setValueAt(xrs.getString(8), n, 9);
                    this.xmodelotp2.setValueAt(xrs.getString("Telefono"), n, 10);
                    this.xmodelotp2.setValueAt(xrs.getString("Correo"), n, 11);
                    this.xmodelotp2.setValueAt(xrs.getString("Direccion"), n, 12);
                    this.xmodelotp2.setValueAt(xrs.getString(9), n, 13);
                    this.xmodelotp2.setValueAt(xrs.getString(10), n, 14);
                    this.xmodelotp2.setValueAt(xrs.getString(11), n, 15);
                    this.xmodelotp2.setValueAt(xrs.getString(12), n, 16);
                    this.xmodelotp2.setValueAt(xrs.getString(13), n, 17);
                    this.xmodelotp2.setValueAt(xrs.getString(14), n, 18);
                    this.xmodelotp2.setValueAt(xrs.getString(15), n, 19);
                    n++;
                }
            }
            this.JLBNRegistro.setText("" + this.xnregistro);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosR1552_CajaCopi() {
        this.xmodelotp2 = new DefaultTableModel(new Object[0], new String[]{"TD", "Documento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Direccion", "Telefono", "Correo", "FSolicitud", "FAsignacion", "FSolicitudU", "CUP", "Especialidad"}) { // from class: Sig.JIF_Informes_GResoluciones.22
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleTipo2;
        JTable jTable2 = this.JTDetalleTipo2;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo2.doLayout();
        this.JTDetalleTipo2.setModel(this.xmodelotp2);
        this.JTDetalleTipo2.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleTipo2.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleTipo2.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalleTipo2.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalleTipo2.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalleTipo2.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalleTipo2.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalleTipo2.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalleTipo2.getColumnModel().getColumn(13).setPreferredWidth(300);
    }

    private void mCargarDatosTablaTipo2_R1552_CajaCopi() {
        mCrearModeloDatosR1552_CajaCopi();
        this.listainformeResolucion1552 = new ArrayList();
        if (this.JCHFiltro.isSelected()) {
            if (this.xForma == 0) {
                this.listainformeResolucion1552 = this.informeResolucion1552Service.ListarInforme1552FiltroConvenio(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.listaCargarCombo.get(this.JCBEmpresa.getSelectedIndex()).getId());
            } else {
                this.listainformeResolucion1552 = this.informeResolucion1552Service.ListarInforme1552FiltroTercero(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.listaCargarCombo.get(this.JCBEmpresa.getSelectedIndex()).getId());
            }
        } else {
            this.listainformeResolucion1552 = this.informeResolucion1552Service.ListarInforme1552(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        }
        if (!this.listainformeResolucion1552.isEmpty()) {
            for (int i = 0; i < this.listainformeResolucion1552.size(); i++) {
                this.xmodelotp2.addRow(this.xdato);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getIdTipoIdentificacion(), i, 0);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getNoDocumento(), i, 1);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getApellido1(), i, 2);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getApellido2(), i, 3);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getNombre1(), i, 4);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getNombre2(), i, 5);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getDireccion(), i, 6);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getTelefono(), i, 7);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getCorreo(), i, 8);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getFechaSolicitud(), i, 9);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getFechaAsignacion(), i, 10);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getFSolicitoUsuario(), i, 11);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getCupCita(), i, 12);
                this.xmodelotp2.setValueAt(this.listainformeResolucion1552.get(i).getEspecialidad(), i, 13);
            }
            this.JLBNRegistro.setText("" + this.listainformeResolucion1552.size());
        }
    }

    private void mCargarDatosTablaTipo3() {
        try {
            mCrearModeloDatosTipo3();
            String sql = "SELECT 3 AS `TR`, 1 AS `NC`, `M`.`TipoIdNormal` \n, `M`.`NIEmpresa` \n, SUM(D.C5) C5 \n, SUM(D.C6) C6 \n, SUM(D.C7) C7 \n, SUM(D.C8) C8 \n, SUM(D.C9) C9  \n, SUM(D.C10) C10 \n, SUM(D.C11) C11 \n, SUM(D.C12) C12 \n, SUM(D.C13) C13 \n, SUM(D.C14) C14 \n, SUM(D.C15) C15 \nFROM `d_ips` M \nINNER JOIN \n(SELECT \n-- 1 AS `NC` \n-- , `d_ips`.`TipoIdNormal` \n-- , `d_ips`.`NIEmpresa` \n`t_epregunta`.`Id` AS `Id_Pregunta` \n, `t_epregunta`.`Nbre` AS `NPregunta` \n, `t_etipo_respuesta`.`Id` AS `Id_Respuesta` \n, `t_etipo_respuesta`.`Nbre` AS `NRespuesta` \n, COUNT(`t_etipo_respuesta`.`Id`) AS `Cant` \n, IF(`t_epregunta`.`AplicaR`=1, IF( (`t_etipo_respuesta`.`Nbre`='MUY BUENO' || `t_etipo_respuesta`.`Nbre`='MUY BUENA') , COUNT(`t_etipo_respuesta`.`Id`),0),0) C5 \n, IF(`t_epregunta`.`AplicaR`=1, IF( (`t_etipo_respuesta`.`Nbre`='BUENO' || `t_etipo_respuesta`.`Nbre`='BUENA') , COUNT(`t_etipo_respuesta`.`Id`),0),0) C6 \n, IF(`t_epregunta`.`AplicaR`=1, IF( (`t_etipo_respuesta`.`Nbre`='REGULAR' ) , COUNT(`t_etipo_respuesta`.`Id`),0),0) C7 \n, IF(`t_epregunta`.`AplicaR`=1, IF( (`t_etipo_respuesta`.`Nbre`='MALA' || `t_etipo_respuesta`.`Nbre`='MALO') , COUNT(`t_etipo_respuesta`.`Id`),0),0) C8 \n, IF(`t_epregunta`.`AplicaR`=1, IF( (`t_etipo_respuesta`.`Nbre`='MUY MALA' || `t_etipo_respuesta`.`Nbre`='MUY MALO') , COUNT(`t_etipo_respuesta`.`Id`),0),0) C9 \n, IF(`t_epregunta`.`AplicaR`=1, IF( (`t_etipo_respuesta`.`Nbre`='NO RESPONDE' || `t_etipo_respuesta`.`Nbre`='NO RESPONDE') , COUNT(`t_etipo_respuesta`.`Id`),0),0) C10 \n, IF(`t_epregunta`.`AplicaR`=2, IF(`t_etipo_respuesta`.`Nbre`='DEFINITIVAMENTE SI'  , COUNT(`t_etipo_respuesta`.`Id`),0),0) C11 \n, IF(`t_epregunta`.`AplicaR`=2, IF(`t_etipo_respuesta`.`Nbre`='PROBABLEMENTE SI'  , COUNT(`t_etipo_respuesta`.`Id`),0),0) C12 \n, IF(`t_epregunta`.`AplicaR`=2, IF(`t_etipo_respuesta`.`Nbre`='DEFINITIVAMENTE NO'  , COUNT(`t_etipo_respuesta`.`Id`),0),0) C13 \n, IF(`t_epregunta`.`AplicaR`=2, IF(`t_etipo_respuesta`.`Nbre`='PROBABLEMENTE NO'  , COUNT(`t_etipo_respuesta`.`Id`),0),0) C14 \n, IF(`t_epregunta`.`AplicaR`=2, IF(`t_etipo_respuesta`.`Nbre`='NO RESPONDE'  , COUNT(`t_etipo_respuesta`.`Id`),0),0) C15 \n, A.`Id` \nFROM \n`d_ips` A,  \n`t_e_tipo_encuesta` \nINNER JOIN  `t_encuestas`  \nON (`t_e_tipo_encuesta`.`Id_TipoEncuesta` = `t_encuestas`.`Id`) \nINNER JOIN  `t_e_tipo_encuesta_detalle`  \nON (`t_e_tipo_encuesta_detalle`.`Id_Tipo_Encuesta` = `t_e_tipo_encuesta`.`Id`) \nINNER JOIN  `t_encuestas_registro`  \nON (`t_encuestas_registro`.`Id_TipoEncuestaD` = `t_e_tipo_encuesta_detalle`.`Id`) \nINNER JOIN  `t_detalle_encuesta_registro`  \nON (`t_detalle_encuesta_registro`.`Id_Encuestas` = `t_encuestas_registro`.`Id`) \nINNER JOIN  `t_epregunta`  \nON (`t_detalle_encuesta_registro`.`Id_Pregunta` = `t_epregunta`.`Id`) \nINNER JOIN  `t_etipo_respuesta`  \nON (`t_detalle_encuesta_registro`.`Id_Respuesta` = `t_etipo_respuesta`.`Id`) \nWHERE (`t_encuestas`.`AplicaR` =1 \nAND `t_epregunta`.`AplicaR` IN(1,2) \nAND `t_encuestas_registro`.`FechaEncuestas` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \nAND `t_encuestas_registro`.`FechaEncuestas` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) \nGROUP BY `Id_Pregunta`, `Id_Respuesta` \nORDER BY `t_epregunta`.`AplicaR` ASC) D ON (`M`.`Id`=D.Id) \nGROUP BY M.`Id`";
            ResultSet xrs = this.xct.traerRs(sql);
            System.out.println("Tipo 3 : " + sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp3.addRow(this.xdato);
                    this.xmodelotp3.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelotp3.setValueAt(Long.valueOf(this.xnregistro), n, 1);
                    this.xmodelotp3.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp3.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotp3.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelotp3.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelotp3.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelotp3.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelotp3.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelotp3.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelotp3.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelotp3.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelotp3.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelotp3.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelotp3.setValueAt(xrs.getString(15), n, 14);
                    n++;
                }
            } else {
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet xrs1 = xct1.traerRs("SELECT 3 AS `TR`, 1 AS `NC`, `M`.`TipoIdNormal`, `M`.`NIEmpresa`      FROM `d_ips` M GROUP BY M.`Id`");
                System.out.println("Tipo 3 : SELECT 3 AS `TR`, 1 AS `NC`, `M`.`TipoIdNormal`, `M`.`NIEmpresa`      FROM `d_ips` M GROUP BY M.`Id`");
                if (xrs1.next()) {
                    xrs1.beforeFirst();
                    int n2 = 0;
                    while (xrs1.next()) {
                        this.xnregistro++;
                        this.xmodelotp3.addRow(this.xdato);
                        this.xmodelotp3.setValueAt(Long.valueOf(xrs1.getLong(1)), n2, 0);
                        this.xmodelotp3.setValueAt(Long.valueOf(this.xnregistro), n2, 1);
                        this.xmodelotp3.setValueAt(xrs1.getString(3), n2, 2);
                        this.xmodelotp3.setValueAt(xrs1.getString(4), n2, 3);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 4);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 5);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 6);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 7);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 8);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 9);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 10);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 11);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 12);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 13);
                        this.xmodelotp3.setValueAt(new Long(0L), n2, 14);
                        n2++;
                    }
                }
                xrs1.close();
                xct1.cerrarConexionBd();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTipo3() {
        this.xmodelotp3 = new DefaultTableModel(new Object[0], new String[]{"Tr", "Nc", "Tident", "Nempresa", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12", "C13", "C14", "C15"}) { // from class: Sig.JIF_Informes_GResoluciones.23
            Class[] types = {Long.class, Long.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleTipo3.setModel(this.xmodelotp3);
        this.JTDetalleTipo3.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTDetalleTipo3.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDetalleTipo3.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalleTipo3.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(14).setPreferredWidth(50);
    }

    private void mCargarDatosTablaTipo4() {
        String sql;
        try {
            mCrearModeloDatosTipo4();
            if (this.JCHFiltro.isSelected() && this.JCBEmpresa.getSelectedIndex() != -1) {
                sql = "SELECT \n4 AS `TR` \n, 1 AS `NC` \n, `g_persona`.`Id_TipoIdentificacion` \n, `g_persona`.`NoDocumento` \n, `g_persona`.`FechaNac` \n, `g_persona`.`Id_Sexo` \n, `g_persona`.`Apellido1` \n, `g_persona`.`Apellido2` \n, `g_persona`.`Nombre1` \n, `g_persona`.`Nombre2` \n, IF(`f_empresacontxconvenio`.`CRips`='NA', `g_municipio`.`Id`, `f_empresacontxconvenio`.`CRips`) AS `CEAPB` \n, `g_municipio`.`Id` AS `CodMunicipio` \n, `g_procedimiento`.`C_Homologado` \n, IF( DATE_FORMAT(`q_agendacx`.`Fecha`, '%Y-%m-%d')>=`q_agendacx`.`FechaCx`,`q_agendacx`.`FechaCx`,DATE_FORMAT(`q_agendacx`.`Fecha`, '%Y-%m-%d')) AS `FSolicitud` \n, `q_agendacx`.`FechaCx` AS `FProgramacion` \n, IF(`q_agendacx`.`Id_Ingreso` =0, 'NO', 'SI') AS `Realizo` \n, '' AS `Causa` \n, '' AS `Reprogramacion` \n, `q_agendacx`.`Id_MotivoDesistida` \nFROM \n`q_agendacx` \nINNER JOIN  `g_persona`  \nON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`) \nINNER JOIN  `f_empresacontxconvenio`  \nON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `g_municipio`  \nON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nINNER JOIN  `g_procedimiento`  \nON (`g_procedimiento`.`Id` = `q_agendacx`.`Id_Procedimiento`) \nINNER JOIN   g_empresacont \nON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`)   \nWHERE (`q_agendacx`.`FechaCx` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\nAND `q_agendacx`.`FechaCx` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `g_empresacont`.`Id_empresa`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "');";
            } else {
                sql = "SELECT     4 AS `TR`     , 1 AS `NC`     , `g_persona`.`Id_TipoIdentificacion`     , `g_persona`.`NoDocumento`     , `g_persona`.`FechaNac`     , `g_persona`.`Id_Sexo`     , `g_persona`.`Apellido1`     , `g_persona`.`Apellido2`     , `g_persona`.`Nombre1`     , `g_persona`.`Nombre2`     , IF(`f_empresacontxconvenio`.`CRips`='NA', `g_municipio`.`Id`, `f_empresacontxconvenio`.`CRips`) AS `CEAPB`     , `g_municipio`.`Id` AS `CodMunicipio`     , `g_procedimiento`.`C_Homologado`     , IF( DATE_FORMAT(`q_agendacx`.`Fecha`, '%Y-%m-%d')>=`q_agendacx`.`FechaCx`,`q_agendacx`.`FechaCx`,DATE_FORMAT(`q_agendacx`.`Fecha`, '%Y-%m-%d')) AS `FSolicitud`     , `q_agendacx`.`FechaCx` AS `FProgramacion`     , IF(`q_agendacx`.`Id_Ingreso` =0, 'NO', 'SI') AS `Realizo`     , '' AS `Causa`     , '' AS `Reprogramacion`     , `q_agendacx`.`Id_MotivoDesistida` FROM      `q_agendacx`     INNER JOIN  `g_persona`          ON (`q_agendacx`.`Id_Usuario` = `g_persona`.`Id`)     INNER JOIN  `f_empresacontxconvenio`          ON (`q_agendacx`.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`)     INNER JOIN  `g_municipio`          ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)     INNER JOIN  `g_procedimiento`          ON (`g_procedimiento`.`Id` = `q_agendacx`.`Id_Procedimiento`) WHERE (`q_agendacx`.`FechaCx` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'    AND `q_agendacx`.`FechaCx` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "');";
            }
            System.out.println("Tipo 4 : " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            System.out.println("Tipo 4 : " + sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp4.addRow(this.xdato);
                    this.xmodelotp4.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelotp4.setValueAt(Long.valueOf(this.xnregistro), n, 1);
                    this.xmodelotp4.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp4.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelotp4.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelotp4.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelotp4.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelotp4.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelotp4.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelotp4.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelotp4.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelotp4.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelotp4.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelotp4.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelotp4.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelotp4.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelotp4.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelotp4.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelotp4.setValueAt(xrs.getString(19), n, 18);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTipo4() {
        this.xmodelotp4 = new DefaultTableModel(new Object[0], new String[]{"Tr", "Nc", "Tident", "Ndoc", "Fnc", "Sexo", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "CEAPB", "CMunicipio", "C_Homologado", "FehaS", "FechaP", "Realizo", "Causa", "Reprograma", "IdDesistida"}) { // from class: Sig.JIF_Informes_GResoluciones.24
            Class[] types = {Long.class, Long.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleTipo4.setModel(this.xmodelotp4);
        this.JTDetalleTipo4.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTDetalleTipo4.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDetalleTipo4.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.JTDetalleTipo4.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalleTipo4.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalleTipo4.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleTipo4.getColumnModel().getColumn(6).setPreferredWidth(250);
        this.JTDetalleTipo4.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.JTDetalleTipo4.getColumnModel().getColumn(8).setPreferredWidth(250);
        this.JTDetalleTipo4.getColumnModel().getColumn(9).setPreferredWidth(250);
        this.JTDetalleTipo4.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalleTipo4.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalleTipo4.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalleTipo4.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalleTipo4.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalleTipo4.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalleTipo4.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleTipo4.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleTipo4.getColumnModel().getColumn(18).setPreferredWidth(100);
    }

    private void mCargarDatosTablaTipo5() {
        try {
            mCrearModeloDatosTipo5();
            ResultSet xrs = this.xct.traerRs("SELECT 5 AS `TR`, 1 AS `NC`, `M`.`TipoIdNormal`, `M`.`NIEmpresa`      FROM `d_ips` M GROUP BY M.`Id`");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp5.addRow(this.xdato);
                    this.xmodelotp5.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelotp5.setValueAt(Long.valueOf(this.xnregistro), n, 1);
                    this.xmodelotp5.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp5.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotp5.setValueAt(new Long(0L), n, 4);
                    this.xmodelotp5.setValueAt(new Long(0L), n, 5);
                    this.xmodelotp5.setValueAt(new Long(0L), n, 6);
                    this.xmodelotp5.setValueAt(new Long(0L), n, 7);
                    this.xmodelotp5.setValueAt(new Long(0L), n, 8);
                    this.xmodelotp5.setValueAt(new Long(0L), n, 9);
                    this.xmodelotp5.setValueAt(new Long(0L), n, 10);
                    this.xmodelotp5.setValueAt(new Long(0L), n, 11);
                    this.xmodelotp5.setValueAt(new Long(0L), n, 12);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTipo5() {
        this.xmodelotp5 = new DefaultTableModel(new Object[0], new String[]{"Tr", "Nc", "Tident", "Nempresa", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "C11", "C12"}) { // from class: Sig.JIF_Informes_GResoluciones.25
            Class[] types = {Long.class, Long.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, true, true, true, true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleTipo5.setModel(this.xmodelotp5);
        this.JTDetalleTipo5.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTDetalleTipo5.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDetalleTipo5.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalleTipo5.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(12).setPreferredWidth(50);
    }

    private void mCargarDatosTablaTipo6() {
        String sql;
        try {
            mCrearModeloDatosTipo6();
            if (this.JCHFiltro.isSelected() && this.JCBEmpresa.getSelectedIndex() != -1) {
                sql = "SELECT     6 AS `TR`     , 1 AS `NC`     , `g_persona`.`Id_TipoIdentificacion`     , `g_persona`.`NoDocumento`     , `g_persona`.`FechaNac`     , g_sexo.V256     , TRIM(`g_persona`.`Apellido1`)     , TRIM(`g_persona`.`Apellido2`)     , TRIM(`g_persona`.`Nombre1`)     , TRIM(`g_persona`.`Nombre2`)     , IF(`f_empresacontxconvenio`.`CRips`='NA', `g_municipio`.`Id`, `f_empresacontxconvenio`.`CRips`) AS `CEAPB`     , `h_triage`.`FechaTriage`     , date_format(`h_triage`.`HoraTriage`,'%H:%i')     , `h_atencion`.`Fecha_Atencion`     , date_format(`h_atencion`.`Hora_Atencion`,'%H:%i') , TIMESTAMPDIFF(MINUTE, STR_TO_DATE(concat(`h_triage`.FechaTriage , ' ', `h_triage`.`HoraTriage`),'%Y-%m-%d %H:%i:%s') ,STR_TO_DATE(concat(`h_atencion`.Fecha_Atencion , ' ', `h_atencion`.`Hora_Atencion`),'%Y-%m-%d %H:%i:%s')) tiempo  FROM      `h_atencion`     INNER JOIN  `ingreso`          ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     INNER JOIN  `g_persona`          ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)     INNER JOIN  g_sexo          ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)     INNER JOIN  `f_empresacontxconvenio`          ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)     INNER JOIN   g_empresacont          ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`)     INNER JOIN  f_tipoempresacont          ON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`)     INNER JOIN  `h_triage`          ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)     INNER JOIN  `g_municipio`          ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'    AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'    AND `h_triage`.`Estado` =0 AND `g_empresacont`.`Id_empresa`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'    AND `h_triage`.`Clasificacion` =2 and f_tipoempresacont.AplicaR=1) ORDER BY `ingreso`.`FechaIngreso` ASC, `ingreso`.`HoraIngreso` ASC;";
            } else {
                sql = "SELECT     6 AS `TR`     , 1 AS `NC`     , `g_persona`.`Id_TipoIdentificacion`     , `g_persona`.`NoDocumento`     , `g_persona`.`FechaNac`     , g_sexo.V256     , TRIM(`g_persona`.`Apellido1`)     , TRIM(`g_persona`.`Apellido2`)     , TRIM(`g_persona`.`Nombre1`)     , TRIM(`g_persona`.`Nombre2`)     , IF(`f_empresacontxconvenio`.`CRips`='NA', `g_municipio`.`Id`, `f_empresacontxconvenio`.`CRips`) AS `CEAPB`     , `h_triage`.`FechaTriage`     , date_format(`h_triage`.`HoraTriage`,'%H:%i')     , `h_atencion`.`Fecha_Atencion`     , date_format(`h_atencion`.`Hora_Atencion`,'%H:%i') , TIMESTAMPDIFF(MINUTE, STR_TO_DATE(concat(`h_triage`.FechaTriage , ' ', `h_triage`.`HoraTriage`),'%Y-%m-%d %H:%i:%s'),STR_TO_DATE(concat(`h_atencion`.Fecha_Atencion , ' ', `h_atencion`.`Hora_Atencion`),'%Y-%m-%d %H:%i:%s')) tiempo  FROM      `h_atencion`     INNER JOIN  `ingreso`          ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     INNER JOIN  `g_persona`          ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)     INNER JOIN  g_sexo          ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)     INNER JOIN  `f_empresacontxconvenio`          ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)     INNER JOIN   g_empresacont          ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`)     INNER JOIN  f_tipoempresacont          ON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`)     INNER JOIN  `h_triage`          ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)     INNER JOIN  `g_municipio`          ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'    AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'    AND `h_triage`.`Estado` =0     AND `h_triage`.`Clasificacion` =2 and f_tipoempresacont.AplicaR=1) ORDER BY `ingreso`.`FechaIngreso` ASC, `ingreso`.`HoraIngreso` ASC;";
            }
            System.out.println("Tipo 6 : " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp6.addRow(this.xdato);
                    this.xmodelotp6.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelotp6.setValueAt(Long.valueOf(this.xnregistro), n, 1);
                    this.xmodelotp6.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp6.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotp6.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelotp6.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelotp6.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelotp6.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelotp6.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelotp6.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelotp6.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelotp6.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelotp6.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelotp6.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelotp6.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelotp6.setValueAt(Integer.valueOf(xrs.getInt("tiempo")), n, 15);
                    this.JTDetalleTipo6.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sig/JIF_Informes_GResoluciones$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Integer tiempo = Integer.valueOf(table.getValueAt(row, 15).toString());
            if (tiempo.intValue() > 15) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTipo6() {
        this.xmodelotp6 = new DefaultTableModel(new Object[0], new String[]{"Tr", "Nc", "Tident", "Ndoc", "Fnc", "Sexo", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "CEAPB", "FTriage", "HTriage", "FehaA", "HoraA", "Minuto"}) { // from class: Sig.JIF_Informes_GResoluciones.26
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleTipo6.setModel(this.xmodelotp6);
        this.JTDetalleTipo6.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTDetalleTipo6.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDetalleTipo6.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleTipo6.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(15).setPreferredWidth(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (getTitle().equals("INFORME RESOLUCIÓN 2175")) {
            if (this.JRB_Generar.isSelected()) {
                if (this.JTDetalle.getRowCount() > 0) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        mCrearArchivoRes();
                        return;
                    }
                    return;
                }
                return;
            }
            int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n2 == 0) {
                if (this.JTPDatosC.getSelectedIndex() == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle() + " - " + this.JTPDatosC.getTitleAt(this.JTPDatosC.getSelectedIndex()));
                    return;
                }
                if (this.JTPDatosC.getSelectedIndex() == 1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo2, this.JTFRuta.getText(), getTitle() + " - " + this.JTPDatosC.getTitleAt(this.JTPDatosC.getSelectedIndex()));
                    return;
                }
                if (this.JTPDatosC.getSelectedIndex() == 2) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo3, this.JTFRuta.getText(), getTitle() + " - " + this.JTPDatosC.getTitleAt(this.JTPDatosC.getSelectedIndex()));
                    return;
                }
                if (this.JTPDatosC.getSelectedIndex() == 3) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo4, this.JTFRuta.getText(), getTitle() + " - " + this.JTPDatosC.getTitleAt(this.JTPDatosC.getSelectedIndex()));
                    return;
                } else if (this.JTPDatosC.getSelectedIndex() == 4) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo5, this.JTFRuta.getText(), getTitle() + " - " + this.JTPDatosC.getTitleAt(this.JTPDatosC.getSelectedIndex()));
                    return;
                } else {
                    if (this.JTPDatosC.getSelectedIndex() == 5) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo6, this.JTFRuta.getText(), getTitle() + " - " + this.JTPDatosC.getTitleAt(this.JTPDatosC.getSelectedIndex()));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (getTitle().equals("INFORME RESOLUCIÓN 256")) {
            if (this.JRB_Generar.isSelected()) {
                int n3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n3 == 0) {
                    mCrearArchivoRes256();
                    return;
                }
                return;
            }
            if (!this.JTFRuta.getText().isEmpty()) {
                int n4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n4 == 0) {
                    if (this.JTPDatosC.getSelectedIndex() == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo2, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(0));
                        return;
                    }
                    if (this.JTPDatosC.getSelectedIndex() == 1) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo3, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(1));
                        return;
                    }
                    if (this.JTPDatosC.getSelectedIndex() == 2) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo4, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(2));
                        return;
                    } else if (this.JTPDatosC.getSelectedIndex() == 3) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo5, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(3));
                        return;
                    } else {
                        if (this.JTPDatosC.getSelectedIndex() == 4) {
                            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo6, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(4));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (getTitle().equals("INFORME CIRCULAR 014")) {
            if (this.JTDetalleTipo2.getRowCount() > 0) {
                if (this.JRB_Generar.isSelected()) {
                    int n5 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n5 == 0) {
                        mCrearArchivoCircular014();
                        return;
                    }
                    return;
                }
                int n6 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n6 == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo2, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe buscar la informacion para poder Exportar/Generar el archivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        if (getTitle().equals("INFORME CIRCULAR EXTERNA 015")) {
            if (this.JRB_Generar.isSelected()) {
                int n7 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n7 == 0) {
                    mCrearArchivoCircular015();
                    return;
                }
                return;
            }
            int n8 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n8 == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo2, this.JTFRuta.getText(), getTitle());
                return;
            }
            return;
        }
        if (getTitle().equals("INFORME RESOLUCIÓN 1552")) {
            if (this.JRB_Generar.isSelected()) {
                int n9 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n9 == 0) {
                    mCrearArchivoRes1552();
                    return;
                }
                return;
            }
            if (!this.JTFRuta.getText().isEmpty()) {
                int n10 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n10 == 0 && this.JTPDatosC.getSelectedIndex() == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo2, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        if (getTitle().equals("INFORME RESOLUCIÓN 1552 (CAJACOPI)")) {
            if (!this.JTFRuta.getText().isEmpty()) {
                int n11 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n11 == 0 && this.JTPDatosC.getSelectedIndex() == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo2, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        if (getTitle().equals("CIRCULAR 000014 (FT025)")) {
            if (this.JTDetalle.getRowCount() > 0) {
                if (this.JRB_Generar.isSelected()) {
                    int n12 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n12 == 0) {
                        mCrearArchivoCircular014_FT025();
                        return;
                    }
                    return;
                }
                int n13 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n13 == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe buscar la informacion para poder Exportar/Generar el archivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        if (getTitle().equals("Informe Circular 015(Formato ST006)".toUpperCase())) {
            if (this.JTDetalleTipo2.getRowCount() > 0) {
                if (this.JRB_Generar.isSelected()) {
                    int n14 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n14 == 0) {
                        gerenarXMLST006();
                        return;
                    }
                    return;
                }
                int n15 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n15 == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleTipo2, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe buscar la informacion para poder Exportar/Generar el archivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_GenerarActionPerformed(ActionEvent evt) {
        this.JBTGenerar.setText("Generar");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ExportarActionPerformed(ActionEvent evt) {
        this.JBTGenerar.setText("Exportar");
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "plantilla.xls");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleTipo2KeyPressed(KeyEvent evt) {
        System.out.println("" + evt.getKeyCode());
        if (evt.getKeyCode() == 127 && this.JTDetalleTipo2.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmodelo.removeRow(this.JTDetalleTipo2.getSelectedRow());
                mReorganizarConsecutivo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleTipo3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleTipo3.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmodelotp3.removeRow(this.JTDetalleTipo3.getSelectedRow());
                mReorganizarConsecutivo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleTipo4KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleTipo4.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmodelotp4.removeRow(this.JTDetalleTipo4.getSelectedRow());
                mReorganizarConsecutivo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleTipo5KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleTipo5.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmodelotp5.removeRow(this.JTDetalleTipo5.getSelectedRow());
                mReorganizarConsecutivo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleTipo6KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleTipo6.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmodelotp6.removeRow(this.JTDetalleTipo6.getSelectedRow());
                mReorganizarConsecutivo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.xllenof) {
            if (getTitle().equals("INFORME RESOLUCIÓN 1552") || getTitle().equals("INFORME RESOLUCIÓN 1552 (CAJACOPI)")) {
                mLLenarComboEmpresaC(mConsutlarFormaEmpresa());
            } else {
                mLLenarComboEmpresaC(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEmpresa.getSelectedIndex() != -1) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenof) {
            mLLenarComboEmpresaC(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenof) {
            mLLenarComboEmpresaC(-1);
        }
    }

    private int mConsutlarFormaEmpresa() {
        int xvalor = -1;
        Object[] botones1 = {"Convenio", "Empresa", "Cerrar"};
        int v = JOptionPane.showOptionDialog(this, "Con que desaea realizar el cargue?", "CONSULTAR", 0, 3, (Icon) null, botones1, "Convenio");
        if (v == 0) {
            xvalor = 0;
            this.xForma = 0;
        } else if (v == 1) {
            xvalor = 1;
            this.xForma = 1;
        }
        return xvalor;
    }

    public void mNuevo() {
        this.xlleno = false;
        this.xllenof = false;
        this.xForma = -1;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.xllenof = true;
        this.JCBEmpresa.setEnabled(false);
        this.xsql = "SELECT  `Id` , `Nbre` , `Id_TipoIdentificacion` , `Identificacion` ,`DigitoVerificacion`, `CodigoOrganismo` , LPAD(`Identificacion`,12,'0') Nit, LPAD((g_ips.`NoRemision256`+1),2,'0') FROM `g_ips`  ORDER BY `Nbre` ASC  ";
        this.xid_ips = this.xct.llenarComboyLista(this.xsql, this.xid_ips, this.JCB_Combo1, 8);
        this.JCB_Combo1.setSelectedItem(Principal.informacionIps.getNombreIps());
        this.JCH_Agrupacion.setVisible(false);
        this.xct.cerrarConexionBd();
        if (getTitle().equals("INFORME RESOLUCIÓN 256")) {
            this.JTPDatosC.remove(0);
            this.JCH_Agrupacion.setVisible(true);
        } else if (getTitle().equals("INFORME CIRCULAR EXTERNA 015") || getTitle().equals("INFORME RESOLUCIÓN 1552") || getTitle().equals("INFORME RESOLUCIÓN 1552 (CAJACOPI)") || getTitle().equals("Informe Circular 015(Formato ST006)".toUpperCase())) {
            this.JTPDatosC.remove(5);
            this.JTPDatosC.remove(4);
            this.JTPDatosC.remove(3);
            this.JTPDatosC.remove(2);
            this.JTPDatosC.remove(0);
        } else if (getTitle().equals("INFORME CIRCULAR 014")) {
            this.JTPDatosC.remove(5);
            this.JTPDatosC.remove(4);
            this.JTPDatosC.remove(3);
            this.JTPDatosC.remove(2);
            this.JTPExportar.remove(0);
            this.JTPDatosC.setTitleAt(0, "CONVENIOS");
            this.JTPDatosC.setTitleAt(1, "DETALLE");
            mCrearModeloDatosConvenios014();
        } else if (getTitle().equals("INFORME RESOLUCIÓN 2175")) {
            this.JTPDatosC.setTitleAt(3, "TIPO4-5");
            this.JTPDatosC.setTitleAt(4, "TIPO6");
            this.JTPDatosC.setTitleAt(5, "TIPO7");
        } else if (getTitle().equals("CIRCULAR 000014 (FT025)")) {
            this.JTPDatosC.remove(5);
            this.JTPDatosC.remove(4);
            this.JTPDatosC.remove(3);
            this.JTPDatosC.remove(2);
            this.JTPDatosC.remove(1);
            mCrearModeloDatosC014_FT0025();
            this.JTPExportar.remove(0);
        }
        this.JCHFiltro.setSelected(false);
    }

    public void mConsultaInformacion() {
        new ConsultasMySQL();
        this.xct.ejecutarSQL("TRUNCATE `p_res_2175`");
        this.xct.cerrarConexionBd();
        ResultSet xrs = this.xct.traerRs("SELECT EXISTS(SELECT column_name FROM information_schema.columns WHERE table_schema='baseserver' AND table_name='p_res_2175' AND column_name='Id') AS Existencia");
        try {
            if (xrs.next()) {
                System.out.println("Existencia: " + xrs.getInt(1));
                if (xrs.getInt(1) == 1) {
                    this.xct.ejecutarSQL("ALTER TABLE p_res_2175 DROP Id");
                    this.xct.cerrarConexionBd();
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        String sql = "INSERT INTO p_res_2175( `TipoRegistro`, `IdAtencion`, `FechaAtencion`, `IdUsuario`, `Finalidad`) SELECT '2',h_atencion.`Id`,h_atencion.`Fecha_Atencion`,`g_usuario`.`Id_persona`,`c_clasecita`.`Id_Finalidad` FROM `g_ips`, `h_atencion` INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE ( c_clasecita.id_Resolicion_2175=1 AND h_atencion.`Fecha_Atencion`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND h_atencion.`Fecha_Atencion`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')";
        System.out.println("Registro Tipo 2-->" + sql);
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (\n SELECT p_res_2175.`IdUsuario`, `l_protocoloxprocedimiento`.`Id_Procedim`, `l_resultados`.`FechaResult`  \n FROM `l_recepcion` INNER JOIN `p_res_2175` ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`)  \n INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)  \n INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)  \n INNER JOIN `l_protocoloxprocedimiento` ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)  \n WHERE (`l_protocoloxprocedimiento`.`Id_Procedim` =904903)) D SET p_res_2175.`TSH`='1', p_res_2175.`FechaTSH`=D.FechaResult\n WHERE p_res_2175.`IdUsuario`=D.IdUsuario");
        this.xct.cerrarConexionBd();
        String sql2 = "INSERT INTO p_res_2175( `TipoRegistro` , `IdAtencion`, `FechaAtencion`, `IdUsuario`, `Finalidad`,CUPS) SELECT '3',h_atencion.`Id`,h_atencion.`Fecha_Atencion`,`g_usuario`.`Id_persona`,`c_clasecita`.`Id_Finalidad`,c_clasecita.`Id_Procedimiento`\nFROM `g_ips`, `g_usuario`  INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nINNER JOIN `h_atencion`ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n WHERE (c_clasecita.id_Resolicion_2175=2 AND YEAR(CURDATE())-YEAR(g_persona.`FechaNac`)<='5'\n AND h_atencion.`Fecha_Atencion`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'  AND h_atencion.`Fecha_Atencion`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' \nAND  c_clasecita.`Id_Procedimiento`='890201' OR c_clasecita.`Id_Procedimiento`='890205' \nOR c_clasecita.`Id_Procedimiento`='890301' OR c_clasecita.`Id_Procedimiento`='890305') ;";
        System.out.println("Registro Tipo 3-->" + sql2);
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (\nSELECT p_res_2175.`IdAtencion`, round(`h_examenfisico`.`Peso`,1)Peso, round(`h_examenfisico`.`Talla`,1)Talla \nFROM `p_res_2175` INNER JOIN `h_atencion` ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`) \nINNER JOIN `h_examenfisico` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE p_res_2175.`TipoRegistro`='3'\n ) D SET p_res_2175.`Peso`=D.Peso, p_res_2175.`Talla`=D.Talla\n WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL(" UPDATE  p_res_2175, (\n SELECT p_res_2175.`IdAtencion`,MAX(DATE_FORMAT(`h_ordenes`.`FechaOrden`,'%Y-%m-%d')) AS FechaOrden  \n  FROM `h_ordenes` INNER JOIN `h_atencion` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)  \n     INNER JOIN `h_itemordenessum` ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)  \n     INNER JOIN `i_suministro` ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)  \n     INNER JOIN `i_principioactivo` ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)  \n     INNER JOIN `i_atcsubgrupoquimico` ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)  \n     INNER JOIN `p_res_2175` ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`)  \n  WHERE (`i_atcsubgrupoquimico`.`Id` IN ('B03AE') AND p_res_2175.`TipoRegistro`='3') GROUP BY p_res_2175.`IdAtencion` \n   ) D SET p_res_2175.FHierro=D.FechaOrden\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL(" UPDATE  p_res_2175, (\n SELECT p_res_2175.`IdAtencion`,MAX(DATE_FORMAT(`h_ordenes`.`FechaOrden`,'%Y-%m-%d')) AS FechaOrden  \n  FROM `h_ordenes` INNER JOIN `h_atencion` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)  \n     INNER JOIN `h_itemordenessum` ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)  \n     INNER JOIN `i_suministro` ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)  \n     INNER JOIN `i_principioactivo` ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)  \n     INNER JOIN `i_atcsubgrupoquimico` ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)  \n     INNER JOIN `p_res_2175` ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`)  \n  WHERE (`i_atcsubgrupoquimico`.`Id` IN ('A11CA') AND p_res_2175.`TipoRegistro`='3') GROUP BY p_res_2175.`IdAtencion` \n   ) D SET p_res_2175.FVitA=D.FechaOrden\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL(" UPDATE  p_res_2175, (  \n \nSELECT \nd.Id_Paciente,  f.FechaResult, f.VrNumerico\nFROM\n(SELECT\n    MAX(`l_recepcion`.`Id`) IdRecepcion\n    , `l_recepcion`.`Id_Paciente`, `l_protocoloxprocedimiento`.`Id` IdProtocolo\nFROM\n    `l_resultados`\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n inner join l_protocolos lp \n    \ton (lp.Id=l_protocoloxprocedimiento.Id_Protocolo)  \n    INNER JOIN `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) AND (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detallerecepcion`.`Id_Procedim`)\nWHERE (lp.V4505 ='V103'\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0 AND l_recepcion.`FechaRecep`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND l_recepcion.`FechaRecep`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')\nGROUP BY `l_recepcion`.`Id_Paciente`) d\t\n LEFT JOIN (\n  SELECT `l_protocoloxprocedimiento`.`Id_Procedim`, DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS FechaResult \n  , `l_detalleresultado`.`VrNumerico`, l_recepcion.`Id`, l_protocoloxprocedimiento.`Id` idProtocolo    \n  FROM `l_recepcion`     \n      INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)   \n      INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)   \n      INNER JOIN `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)   \n inner join l_protocolos lp \n    \ton (lp.Id=l_protocoloxprocedimiento.Id_Protocolo)  \n     -- INNER JOIN `p_res_2175`  ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`)  \n  WHERE (lp.V4505 ='V103' \n  -- AND p_res_2175.`TipoRegistro`='3'\n  )\n) f ON (d.IdRecepcion=f.Id) AND (d.IdProtocolo=f.idProtocolo)\n  -- GROUP BY p_res_2175.`IdAtencion` \n   \n  ) D SET p_res_2175.FHemoglobina=D.FechaResult, p_res_2175.RHemoglobina=D.VrNumerico \n     WHERE p_res_2175.`IdUsuario`=D.Id_Paciente AND p_res_2175.`TipoRegistro`='3'");
        this.xct.cerrarConexionBd();
        String sql3 = "INSERT INTO p_res_2175( `TipoRegistro` , `IdAtencion`, `FechaAtencion`, `IdUsuario`, `Finalidad`,CUPS) SELECT '4',h_atencion.`Id`,h_atencion.`Fecha_Atencion`,`g_usuario`.`Id_persona`,`c_clasecita`.`Id_Finalidad`,c_clasecita.`Id_Procedimiento`\nFROM `g_ips`, `g_usuario`  INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\niNNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nINNER JOIN `h_atencion`ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n WHERE ( c_clasecita.id_Resolicion_2175=3 and YEAR(CURDATE())-YEAR(g_persona.`FechaNac`)>='6'\n AND h_atencion.`Fecha_Atencion`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'  AND h_atencion.`Fecha_Atencion`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' \nAND (c_clasecita.`Id_Procedimiento`='890201' OR c_clasecita.`Id_Procedimiento`='890205' \nOR c_clasecita.`Id_Procedimiento`='890301' OR c_clasecita.`Id_Procedimiento`='890305')) ;";
        System.out.println("Registro Tipo 4-->" + sql3);
        this.xct.ejecutarSQL(sql3);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (\nSELECT p_res_2175.`IdAtencion`, `h_examenfisico`.`Peso`, `h_examenfisico`.`Talla` \nFROM `p_res_2175` INNER JOIN `h_atencion` ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`) \nINNER JOIN `h_examenfisico` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE p_res_2175.`TipoRegistro`='4'\n ) D SET p_res_2175.`Peso`=D.Peso, p_res_2175.`Talla`=D.Talla\n WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL(" UPDATE  p_res_2175, (  \n \nSELECT \nd.Id_Paciente,  f.FechaResult, f.VrNumerico\nFROM\n(SELECT\n    MAX(`l_recepcion`.`Id`) IdRecepcion\n    , `l_recepcion`.`Id_Paciente`, `l_protocoloxprocedimiento`.`Id` IdProtocolo\nFROM\n    `l_resultados`\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n inner join l_protocolos lp \n    \ton (lp.Id=l_protocoloxprocedimiento.Id_Protocolo)  \n    INNER JOIN `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) AND (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detallerecepcion`.`Id_Procedim`)\nWHERE (lp.V4505 ='V103'\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0 AND l_recepcion.`FechaRecep`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND l_recepcion.`FechaRecep`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')\nGROUP BY `l_recepcion`.`Id_Paciente`) d\t\n INNER JOIN (\n  SELECT `l_protocoloxprocedimiento`.`Id_Procedim`, DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS FechaResult \n  , `l_detalleresultado`.`VrNumerico`, l_recepcion.`Id`, l_protocoloxprocedimiento.`Id` idProtocolo    \n  FROM `l_recepcion`     \n      INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)   \n      INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)   \n      INNER JOIN `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)   \n inner join l_protocolos lp \n    \ton (lp.Id=l_protocoloxprocedimiento.Id_Protocolo)  \n     -- INNER JOIN `p_res_2175`  ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`)  \n  WHERE (lp.V4505 ='V103' \n  -- AND p_res_2175.`TipoRegistro`='3'\n  )\n) f ON (d.IdRecepcion=f.Id) AND (d.IdProtocolo=f.idProtocolo)\n  -- GROUP BY p_res_2175.`IdAtencion` \n   \n  ) D SET p_res_2175.FHemoglobina=D.FechaResult, p_res_2175.RHemoglobina=D.VrNumerico \n     WHERE p_res_2175.`IdUsuario`=D.Id_Paciente AND p_res_2175.`TipoRegistro`='4'");
        this.xct.cerrarConexionBd();
        String sql4 = "INSERT INTO p_res_2175( `TipoRegistro` , `IdAtencion`, `FechaAtencion`, `IdUsuario`, `Finalidad`,CUPS)  SELECT '5',h_atencion.`Id`,h_atencion.`Fecha_Atencion`,`g_usuario`.`Id_persona`,`c_clasecita`.`Id_Finalidad`,c_clasecita.`Id_Procedimiento`  FROM `g_ips`, `h_atencion` INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)      INNER JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  WHERE ( c_clasecita.id_Resolicion_2175=4 AND h_atencion.`Fecha_Atencion`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.`Fecha_Atencion`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND (c_clasecita.`Id_Procedimiento`='890201' OR c_clasecita.`Id_Procedimiento`='890205' OR c_clasecita.`Id_Procedimiento`='890301' OR c_clasecita.`Id_Procedimiento`='890305')) ;";
        System.out.println("Registro Tipo 5-->" + sql4);
        this.xct.ejecutarSQL(sql4);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (\nSELECT p_res_2175.`IdAtencion`, `h_examenfisico`.`Peso`, `h_examenfisico`.`Talla` \nFROM `p_res_2175` INNER JOIN `h_atencion` ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`) \nINNER JOIN `h_examenfisico` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE p_res_2175.`TipoRegistro`='5'\n ) D SET p_res_2175.`Peso`=D.Peso, p_res_2175.`Talla`=D.Talla\n WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL(" UPDATE  p_res_2175, (  \n \nSELECT \nd.Id_Paciente,  f.FechaResult, f.VrNumerico\nFROM\n(SELECT\n    MAX(`l_recepcion`.`Id`) IdRecepcion\n    , `l_recepcion`.`Id_Paciente`, `l_protocoloxprocedimiento`.`Id` IdProtocolo\nFROM\n    `l_resultados`\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n inner join l_protocolos lp \n    \ton (lp.Id=l_protocoloxprocedimiento.Id_Protocolo)  \n    INNER JOIN `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) AND (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detallerecepcion`.`Id_Procedim`)\nWHERE (lp.V4505 ='V103'\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0 AND l_recepcion.`FechaRecep`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND l_recepcion.`FechaRecep`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')\nGROUP BY `l_recepcion`.`Id_Paciente`) d\t\n INNER JOIN (\n  SELECT `l_protocoloxprocedimiento`.`Id_Procedim`, DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS FechaResult \n  , `l_detalleresultado`.`VrNumerico`, l_recepcion.`Id`, l_protocoloxprocedimiento.`Id` idProtocolo    \n  FROM `l_recepcion`     \n      INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)   \n      INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)   \n      INNER JOIN `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)   \n inner join l_protocolos lp \n    \ton (lp.Id=l_protocoloxprocedimiento.Id_Protocolo)  \n     -- INNER JOIN `p_res_2175`  ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`)  \n  WHERE (lp.V4505 ='V103' \n  -- AND p_res_2175.`TipoRegistro`='3'\n  )\n) f ON (d.IdRecepcion=f.Id) AND (d.IdProtocolo=f.idProtocolo)\n  -- GROUP BY p_res_2175.`IdAtencion` \n   \n  ) D SET p_res_2175.FHemoglobina=D.FechaResult, p_res_2175.RHemoglobina=D.VrNumerico \n     WHERE p_res_2175.`IdUsuario`=D.Id_Paciente AND p_res_2175.`TipoRegistro`='5'");
        this.xct.cerrarConexionBd();
        String sql5 = "INSERT INTO p_res_2175( `TipoRegistro` , `IdAtencion`, `FechaAtencion`, `IdUsuario`, `Finalidad`,CUPS)  SELECT '6',h_atencion.`Id`,h_atencion.`Fecha_Atencion`,`g_usuario`.`Id_persona`,`c_clasecita`.`Id_Finalidad`,c_clasecita.`Id_Procedimiento`  FROM `g_ips`, `h_atencion`INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)   INNER JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  WHERE (c_clasecita.id_Resolicion_2175=5 AND h_atencion.`Fecha_Atencion`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.`Fecha_Atencion`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND (c_clasecita.`Id_Procedimiento`='890201'  OR c_clasecita.`Id_Procedimiento`='890301' OR c_clasecita.`Id_Procedimiento`='890305' OR c_clasecita.`Id_Procedimiento`='890203' OR c_clasecita.`Id_Procedimiento`='890303' OR c_clasecita.`Id_Procedimiento`='890206' OR c_clasecita.`Id_Procedimiento`='890306')) ;";
        System.out.println("Registro Tipo 6-->" + sql5);
        this.xct.ejecutarSQL(sql5);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (SELECT p_res_2175.`IdAtencion`, ROUND(`h_examenfisico`.`SGestacion`) AS SGestacion \n FROM `p_res_2175` INNER JOIN `h_atencion` ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`) \n INNER JOIN `h_examenfisico` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE p_res_2175.`TipoRegistro`='6'\n ) D SET p_res_2175.EdadGestacional=D.SGestacion\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (SELECT p_res_2175.`IdAtencion`, MAX(DATE_FORMAT(`h_ordenes`.`FechaOrden`,'%Y-%m-%d')) AS FechaOrden \n  FROM `h_ordenes` INNER JOIN `h_atencion` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) \n     INNER JOIN `h_itemordenessum` ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) \n     INNER JOIN `i_suministro` ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`) \n     INNER JOIN `i_principioactivo` ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) \n     INNER JOIN `i_atcsubgrupoquimico` ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`) \n     INNER JOIN `p_res_2175` ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`) \n  WHERE (`i_atcsubgrupoquimico`.`Id` ='B03BB' AND p_res_2175.`TipoRegistro`='6') GROUP BY p_res_2175.`IdAtencion`\n ) D SET p_res_2175.FAcFolico=D.FechaOrden\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (SELECT p_res_2175.`IdAtencion`, MAX(DATE_FORMAT(`h_ordenes`.`FechaOrden`,'%Y-%m-%d')) AS FechaOrden \n  FROM `h_ordenes` INNER JOIN `h_atencion` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) \n     INNER JOIN `h_itemordenessum` ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) \n     INNER JOIN `i_suministro` ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`) \n     INNER JOIN `i_principioactivo` ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) \n     INNER JOIN `i_atcsubgrupoquimico` ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`) \n     INNER JOIN `p_res_2175` ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`) \n  WHERE (`i_atcsubgrupoquimico`.`Id` ='B03AE' AND p_res_2175.`TipoRegistro`='6') GROUP BY p_res_2175.`IdAtencion`\n ) D SET p_res_2175.FHierro=D.FechaOrden\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (SELECT p_res_2175.`IdAtencion`, MAX(DATE_FORMAT(`h_ordenes`.`FechaOrden`,'%Y-%m-%d')) AS FechaOrden \n  FROM `h_ordenes` INNER JOIN `h_atencion` ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) \n     INNER JOIN `h_itemordenessum` ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`) \n     INNER JOIN `i_suministro` ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`) \n     INNER JOIN `i_principioactivo` ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) \n     INNER JOIN `i_atcsubgrupoquimico` ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`) \n     INNER JOIN `p_res_2175` ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`) \n  WHERE (`i_atcsubgrupoquimico`.`Id` ='A12AA' AND p_res_2175.`TipoRegistro`='6') GROUP BY p_res_2175.`IdAtencion`\n ) D SET p_res_2175.FCarbCalcio=D.FechaOrden\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, ( SELECT p_res_2175.`IdAtencion`,`l_protocoloxprocedimiento`.`Id_Procedim`, MAX(DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d')) AS FechaResult, IF(l_tiporesultado.`Nbre`='Negativo','2','1') AS Resultado \n  FROM `l_recepcion`INNER JOIN `p_res_2175` ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`) \n     INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) \n     INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) \n     INNER JOIN `l_protocoloxprocedimiento` ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) \n     INNER JOIN `l_tiporesultado` ON (`l_detalleresultado`.`Resultado` = `l_tiporesultado`.`Id`) \n  WHERE (`l_protocoloxprocedimiento`.`Id_Procedim` =906317  AND p_res_2175.`TipoRegistro`='6') GROUP BY   p_res_2175.`IdAtencion`\n ) D SET p_res_2175.FHepatitisB=D.FechaResult, p_res_2175.RHepatitisB=D.Resultado\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (  SELECT p_res_2175.`IdAtencion`,`l_protocoloxprocedimiento`.`Id_Procedim`, MAX(DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d')) AS FechaResult  \n     ,IF(l_tiporesultado.`Nbre`='No reactiva','2','1') AS Resultado  \n  FROM `l_recepcion` INNER JOIN `p_res_2175` ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`)  \n     INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)  \n     INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)  \n     INNER JOIN `l_protocoloxprocedimiento` ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)  \n     INNER JOIN `l_tiporesultado` ON (`l_detalleresultado`.`Resultado` = `l_tiporesultado`.`Id`) \n  WHERE (`l_protocoloxprocedimiento`.`Id_Procedim` IN(906916,172)  AND p_res_2175.`TipoRegistro`='6') GROUP BY   p_res_2175.`IdAtencion`\n ) D SET p_res_2175.FSifilis=D.FechaResult, p_res_2175.RSifilis=D.Resultado\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (   SELECT p_res_2175.`IdAtencion`,l_recepcion.FechaRecep, `l_protocoloxprocedimiento`.`Id_Procedim`, MAX(DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d')) AS FechaResult  \n     ,IF(l_tiporesultado.`Nbre`='Negativo','1','2') AS Resultado  \n  FROM `l_recepcion` INNER JOIN `p_res_2175` ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`)  \n     INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)  \n     INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)  \n     INNER JOIN `l_protocoloxprocedimiento` ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)  \n     INNER JOIN `l_tiporesultado` ON (`l_detalleresultado`.`Resultado` = `l_tiporesultado`.`Id`)  \n  WHERE (`l_protocoloxprocedimiento`.`Id_Procedim` IN(906255, 906840, 906249, 908832, 906250)  AND p_res_2175.`TipoRegistro`='6') GROUP BY   p_res_2175.`IdAtencion`\n ) D SET p_res_2175.FAseVIH=D.FechaRecep, p_res_2175.FVIH=D.FechaResult , p_res_2175.RVIH=D.Resultado \n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL(" UPDATE  p_res_2175, (  \n \nSELECT \nd.Id_Paciente,  f.FechaResult, f.VrNumerico\nFROM\n(SELECT\n    MAX(`l_recepcion`.`Id`) IdRecepcion\n    , `l_recepcion`.`Id_Paciente`, `l_protocoloxprocedimiento`.`Id` IdProtocolo\nFROM\n    `l_resultados`\n    INNER JOIN `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) AND (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_detallerecepcion`.`Id_Procedim`)\n inner join l_protocolos lp \n    \ton (lp.Id=l_protocoloxprocedimiento.Id_Protocolo)  \nWHERE (lp.V4505 ='V103'\n    AND `l_recepcion`.`Estado` =0\n    AND `l_resultados`.`Estado` =0 AND l_recepcion.`FechaRecep`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND l_recepcion.`FechaRecep`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')\nGROUP BY `l_recepcion`.`Id_Paciente`) d\t\n INNER JOIN (\n  SELECT `l_protocoloxprocedimiento`.`Id_Procedim`, DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d') AS FechaResult \n  , `l_detalleresultado`.`VrNumerico`, l_recepcion.`Id`, l_protocoloxprocedimiento.`Id` idProtocolo    \n  FROM `l_recepcion`     \n      INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)   \n      INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)   \n      INNER JOIN `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)   \n inner join l_protocolos lp \n    \ton (lp.Id=l_protocoloxprocedimiento.Id_Protocolo)  \n     -- INNER JOIN `p_res_2175`  ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`)  \n  WHERE (l_protocoloxprocedimiento.`Id_Protocolo` IN (1,2) \n  -- AND p_res_2175.`TipoRegistro`='3'\n  )\n) f ON (d.IdRecepcion=f.Id) AND (d.IdProtocolo=f.idProtocolo)\n  -- GROUP BY p_res_2175.`IdAtencion` \n   \n  ) D SET p_res_2175.FHemoglobina=D.FechaResult, p_res_2175.RHemoglobina=D.VrNumerico \n     WHERE p_res_2175.`IdUsuario`=D.Id_Paciente AND p_res_2175.`TipoRegistro`='6'");
        this.xct.cerrarConexionBd();
        String sql6 = "INSERT INTO p_res_2175( `TipoRegistro` , `IdAtencion`, `FechaAtencion`, `IdUsuario`, `Finalidad`,CUPS)  SELECT '7',h_atencion.`Id`,h_atencion.`Fecha_Atencion`,`g_usuario`.`Id_persona`,`c_clasecita`.`Id_Finalidad`,c_clasecita.`Id_Procedimiento`  FROM `g_ips`, `h_atencion`     INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)      INNER JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  WHERE (`c_clasecita`.`Id_Finalidad` ='01' AND h_atencion.`Fecha_Atencion`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.`Fecha_Atencion`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND (c_clasecita.`Id_Procedimiento`='735300'  OR c_clasecita.`Id_Procedimiento`='735910' OR c_clasecita.`Id_Procedimiento`='740100' )) ;";
        System.out.println("Registro Tipo 7-->" + sql6);
        this.xct.ejecutarSQL(sql6);
        this.xct.cerrarConexionBd();
        String sql7 = "INSERT IGNORE INTO p_res_2175( TipoRegistro , IdAtencion, FechaAtencion, IdUsuario, Finalidad,CUPS )\n    \n   SELECT * FROM (SELECT\n     '7' AS tipor\n    , h_atencion.Id AS atencion\n    , h_atencion.Fecha_Atencion\n    , ingreso.Id_Usuario\n    , g_procedimiento.Id_TipoFinProced\n    , g_procedimiento.C_Homologado\nFROM\n    `f_ordenes`\n    INNER JOIN `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `h_atencion` ON (h_atencion.`Id_Ingreso`=ingreso.`Id`)\n    INNER JOIN `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    WHERE  g_procedimiento.C_Homologado IN('721003','732201','735301','735930','735931',\n    '735980','740001','740002','740003')\n    AND h_atencion.Fecha_Atencion >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND ingreso.Estado='0' AND h_atencion.Estado='0' GROUP BY h_atencion.`Id` ) AS  temporal\n    WHERE NOT EXISTS(SELECT   `TipoRegistro`  , `IdAtencion`    \n   FROM `p_res_2175`\n         WHERE (p_res_2175.`IdAtencion`=temporal.atencion AND\n               p_res_2175.`TipoRegistro`=.temporal.tipor))";
        System.out.println("Registro Tipo 7-->" + sql7);
        this.xct.ejecutarSQL(sql7);
        this.xct.cerrarConexionBd();
        System.out.println("Registro Tipo 7.1-->INSERT IGNORE INTO p_res_2175( TipoRegistro , IdAtencion, FechaAtencion, IdUsuario, Finalidad,CUPS)\nSELECT * FROM (SELECT '7' AS tipor\n    , h_atencion.Id AS atencion\n    , h_atencion.Fecha_Atencion\n    , ingreso.Id_Usuario\n    , g_procedimiento.Id_TipoFinProced\n    , g_procedimiento.C_Homologado\nFROM\n    baseserver.f_ordenes     \n    INNER JOIN baseserver.ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id) \n    INNER JOIN h_atencion ON (h_atencion.Id_Ingreso=ingreso.Id)\n    INNER JOIN baseserver.f_ordenesqx   ON (f_ordenesqx.Id_Orden = f_ordenes.Id)\n    INNER JOIN g_procedimiento ON (g_procedimiento.Id=f_ordenesqx.Id_Procedimiento)\n    WHERE  g_procedimiento.C_Homologado IN('721003','732201','735301','735930','735931',\n    '735980','740001','740002','740003')\n    AND h_atencion.Fecha_Atencion >= '2020-12-01' AND h_atencion.Fecha_Atencion <= '2020-12-31'\n    AND ingreso.Estado='0' AND h_atencion.Estado='0' GROUP BY h_atencion.`Id` ) AS  temporal\n    WHERE NOT EXISTS(SELECT   `TipoRegistro`  , `IdAtencion`    \n   FROM `p_res_2175`\n         WHERE (p_res_2175.`IdAtencion`=temporal.atencion AND\n               p_res_2175.`TipoRegistro`=.temporal.tipor))");
        this.xct.ejecutarSQL("INSERT IGNORE INTO p_res_2175( TipoRegistro , IdAtencion, FechaAtencion, IdUsuario, Finalidad,CUPS)\nSELECT * FROM (SELECT '7' AS tipor\n    , h_atencion.Id AS atencion\n    , h_atencion.Fecha_Atencion\n    , ingreso.Id_Usuario\n    , g_procedimiento.Id_TipoFinProced\n    , g_procedimiento.C_Homologado\nFROM\n    baseserver.f_ordenes     \n    INNER JOIN baseserver.ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id) \n    INNER JOIN h_atencion ON (h_atencion.Id_Ingreso=ingreso.Id)\n    INNER JOIN baseserver.f_ordenesqx   ON (f_ordenesqx.Id_Orden = f_ordenes.Id)\n    INNER JOIN g_procedimiento ON (g_procedimiento.Id=f_ordenesqx.Id_Procedimiento)\n    WHERE  g_procedimiento.C_Homologado IN('721003','732201','735301','735930','735931',\n    '735980','740001','740002','740003')\n    AND h_atencion.Fecha_Atencion >= '2020-12-01' AND h_atencion.Fecha_Atencion <= '2020-12-31'\n    AND ingreso.Estado='0' AND h_atencion.Estado='0' GROUP BY h_atencion.`Id` ) AS  temporal\n    WHERE NOT EXISTS(SELECT   `TipoRegistro`  , `IdAtencion`    \n   FROM `p_res_2175`\n         WHERE (p_res_2175.`IdAtencion`=temporal.atencion AND\n               p_res_2175.`TipoRegistro`=.temporal.tipor))");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (SELECT `g_usuarioxprograma`.`PartoProbable` , p_res_2175.`IdAtencion`\n FROM `p_res_2175`  INNER JOIN `g_usuarioxprograma`   ON (`p_res_2175`.`IdUsuario` = `g_usuarioxprograma`.`Id_Usuario`) \n WHERE (`p_res_2175`.`TipoRegistro` =7)\n ) D SET p_res_2175.FechaParto=D.PartoProbable\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, ( SELECT p_res_2175.`IdAtencion`,`l_protocoloxprocedimiento`.`Id_Procedim`, MAX(DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d')) AS FechaResult \n     ,IF(l_tiporesultado.`Nbre`='Reactiva','1','2') AS Resultado \n FROM `l_recepcion` INNER JOIN `p_res_2175` ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`) \n     INNER JOIN `l_resultados` ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) \n     INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) \n     INNER JOIN `l_protocoloxprocedimiento` ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) \n     INNER JOIN `l_tiporesultado` ON (`l_detalleresultado`.`Resultado` = `l_tiporesultado`.`Id`) \n WHERE (`l_protocoloxprocedimiento`.`Id_Procedim` IN(906916,172)  AND p_res_2175.`TipoRegistro`='7') GROUP BY   p_res_2175.`IdAtencion`\n ) D SET p_res_2175.TomaRapSifilis=1, p_res_2175.FTomaRapSifilis=D.FechaResult, p_res_2175.RSifilis=D.Resultado\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE  p_res_2175, (SELECT p_res_2175.`IdAtencion`, `l_protocoloxprocedimiento`.`Id_Procedim` \n     , MAX(DATE_FORMAT(`l_resultados`.`FechaResult`,'%Y-%m-%d')) AS FechaResult,IF(l_tiporesultado.`Nbre`='Positivo','1','2') AS Resultado, p_res_2175.FechaAtencion  \n FROM `l_recepcion` INNER JOIN `p_res_2175` ON (`l_recepcion`.`Id_Paciente` = `p_res_2175`.`IdUsuario`) \n     INNER JOIN `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) \n     INNER JOIN `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) \n     INNER JOIN `l_protocoloxprocedimiento` ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) \n          INNER JOIN `l_tiporesultado` ON (`l_detalleresultado`.`Resultado` = `l_tiporesultado`.`Id`) \n WHERE (`l_protocoloxprocedimiento`.`Id_Procedim` IN(906255)  AND p_res_2175.`TipoRegistro`='7') GROUP BY   p_res_2175.`IdAtencion`\n ) D SET p_res_2175.AsesoriaVIHElisa=1, p_res_2175.FAseVIH=D.FechaAtencion, p_res_2175.PruRapidaVIH = 1, p_res_2175.FVIH=D.FechaResult, p_res_2175.RSifilis=D.Resultado\n    WHERE p_res_2175.`IdAtencion`=D.IdAtencion");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("ALTER TABLE p_res_2175 AUTO_INCREMENT = 1");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("ALTER TABLE p_res_2175 ADD Id mediumint UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST");
        this.xct.cerrarConexionBd();
        mCargarDatosTabla();
    }

    public void mBuscar() {
        this.xWorkerSQL = new WorkerSQL("Consultando la información", this);
        this.xWorkerSQL.execute();
    }

    public void mBuscarInformacion() {
        if (getTitle().equals("INFORME RESOLUCIÓN 2175")) {
            mConsultaInformacion();
            this.Pos = 1;
            mCargarDatosTabla2175Tipo2();
            mCargarDatosTabla2175Tipo3();
            mCargarDatosTabla2175Tipo4y5();
            mCargarDatosTabla2175Tipo6();
            mCargarDatosTabla2175Tipo7();
            this.JLBNRegistro.setText(String.valueOf(this.JTDetalleTipo2.getRowCount() + this.JTDetalleTipo3.getRowCount() + this.JTDetalleTipo4.getRowCount() + this.JTDetalleTipo5.getRowCount() + this.JTDetalleTipo6.getRowCount()));
            return;
        }
        if (getTitle().equals("INFORME RESOLUCIÓN 256")) {
            this.xnregistro = 0L;
            mCargarDatosTablaTipo2();
            mCargarDatosTablaTipo3();
            mCargarDatosTablaTipo4();
            mCargarDatosTablaTipo5();
            mCargarDatosTablaTipo6();
            this.JLBNRegistro.setText("" + this.xnregistro);
            return;
        }
        if (getTitle().equals("INFORME CIRCULAR 014")) {
            this.JTPDatosC.setSelectedIndex(1);
            mCargarDatosTablaC014();
            return;
        }
        if (getTitle().equals("CIRCULAR 000014 (FT025)")) {
            mCargarDatosTablaC014_FT0025();
            return;
        }
        if (getTitle().equals("Informe Circular 015(Formato ST006)".toUpperCase())) {
            cargarDatosTablaC015_ST006();
            return;
        }
        if (getTitle().equals("INFORME CIRCULAR EXTERNA 015")) {
            mCargarDatosTablaC015();
            return;
        }
        if (getTitle().equals("INFORME RESOLUCIÓN 1552")) {
            if (this.JCHFiltro.isSelected()) {
                if (this.JCBEmpresa.getSelectedIndex() != -1) {
                    mCargarDatosTablaTipo2_R1552();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBEmpresa.requestFocus();
                    return;
                }
            }
            mCargarDatosTablaTipo2_R1552();
            return;
        }
        if (getTitle().equals("INFORME RESOLUCIÓN 1552 (CAJACOPI)")) {
            if (this.JCHFiltro.isSelected()) {
                if (this.JCBEmpresa.getSelectedIndex() != -1) {
                    mCargarDatosTablaTipo2_R1552_CajaCopi();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBEmpresa.requestFocus();
                    return;
                }
            }
            mCargarDatosTablaTipo2_R1552_CajaCopi();
        }
    }

    private void mCrearArchivoRes1552() {
        try {
            this.JLBNRegistro.getText();
            String sFichero = this.JTFRuta.getText() + "\\" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][5] + "R1552" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            bw.write("1|" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][4] + "|" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][1] + "|" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][5] + "|" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "|" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            if (this.JTDetalleTipo2.getRowCount() != -1) {
                for (int y = 0; y < this.JTDetalleTipo2.getRowCount(); y++) {
                    bw.newLine();
                    bw.write(this.xmodelotp2.getValueAt(y, 0) + "|" + this.xmodelotp2.getValueAt(y, 1) + "|" + this.xmodelotp2.getValueAt(y, 2) + "|" + this.xmodelotp2.getValueAt(y, 3) + "|" + this.xmodelotp2.getValueAt(y, 4) + "|" + this.xmodelotp2.getValueAt(y, 5) + "|" + this.xmodelotp2.getValueAt(y, 6) + "|" + this.xmodelotp2.getValueAt(y, 7) + "|" + this.xmodelotp2.getValueAt(y, 8) + "|" + this.xmodelotp2.getValueAt(y, 9) + "|" + this.xmodelotp2.getValueAt(y, 13) + "|" + this.xmodelotp2.getValueAt(y, 14) + "|" + this.xmodelotp2.getValueAt(y, 15) + "|" + this.xmodelotp2.getValueAt(y, 16) + "|" + this.xmodelotp2.getValueAt(y, 17) + "|" + this.xmodelotp2.getValueAt(y, 18) + "|" + this.xmodelotp2.getValueAt(y, 19));
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivoRes256() {
        try {
            String xnregistro = this.JLBNRegistro.getText();
            String sFichero = this.JTFRuta.getText() + "MCA195MOCA" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate()) + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][1] + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][5] + "C" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][6] + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            bw.write("1|" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][4] + "|" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][1] + "|" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][2] + "|" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "|" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "|" + xnregistro);
            if (this.JTDetalleTipo2.getRowCount() != -1) {
                for (int y = 0; y < this.JTDetalleTipo2.getRowCount(); y++) {
                    bw.newLine();
                    bw.write(this.xmodelotp2.getValueAt(y, 0) + "|" + this.xmodelotp2.getValueAt(y, 1) + "|" + this.xmodelotp2.getValueAt(y, 2) + "|" + this.xmodelotp2.getValueAt(y, 3) + "|" + this.xmodelotp2.getValueAt(y, 4) + "|" + this.xmodelotp2.getValueAt(y, 5) + "|" + this.xmodelotp2.getValueAt(y, 6) + "|" + this.xmodelotp2.getValueAt(y, 7) + "|" + this.xmodelotp2.getValueAt(y, 8) + "|" + this.xmodelotp2.getValueAt(y, 9) + "|" + this.xmodelotp2.getValueAt(y, 10) + "|" + this.xmodelotp2.getValueAt(y, 11) + "|" + this.xmodelotp2.getValueAt(y, 12) + "|" + this.xmodelotp2.getValueAt(y, 13) + "|" + this.xmodelotp2.getValueAt(y, 14) + "|" + this.xmodelotp2.getValueAt(y, 15));
                }
            }
            if (this.JTDetalleTipo3.getRowCount() != -1) {
                for (int y2 = 0; y2 < this.JTDetalleTipo3.getRowCount(); y2++) {
                    bw.newLine();
                    bw.write(this.xmodelotp3.getValueAt(y2, 0) + "|" + this.xmodelotp3.getValueAt(y2, 1) + "|" + this.xmodelotp3.getValueAt(y2, 2) + "|" + this.xmodelotp3.getValueAt(y2, 3) + "|" + this.xmodelotp3.getValueAt(y2, 4) + "|" + this.xmodelotp3.getValueAt(y2, 5) + "|" + this.xmodelotp3.getValueAt(y2, 6) + "|" + this.xmodelotp3.getValueAt(y2, 7) + "|" + this.xmodelotp3.getValueAt(y2, 8) + "|" + this.xmodelotp3.getValueAt(y2, 9) + "|" + this.xmodelotp3.getValueAt(y2, 10) + "|" + this.xmodelotp3.getValueAt(y2, 11) + "|" + this.xmodelotp3.getValueAt(y2, 12) + "|" + this.xmodelotp3.getValueAt(y2, 13) + "|" + this.xmodelotp3.getValueAt(y2, 14));
                }
            }
            if (this.JTDetalleTipo4.getRowCount() != -1) {
                for (int y3 = 0; y3 < this.JTDetalleTipo4.getRowCount(); y3++) {
                    bw.newLine();
                    bw.write(this.xmodelotp4.getValueAt(y3, 0) + "|" + this.xmodelotp4.getValueAt(y3, 1) + "|" + this.xmodelotp4.getValueAt(y3, 2) + "|" + this.xmodelotp4.getValueAt(y3, 3) + "|" + this.xmodelotp4.getValueAt(y3, 4) + "|" + this.xmodelotp4.getValueAt(y3, 5) + "|" + this.xmodelotp4.getValueAt(y3, 6) + "|" + this.xmodelotp4.getValueAt(y3, 7) + "|" + this.xmodelotp4.getValueAt(y3, 8) + "|" + this.xmodelotp4.getValueAt(y3, 9) + "|" + this.xmodelotp4.getValueAt(y3, 10) + "|" + this.xmodelotp4.getValueAt(y3, 11) + "|" + this.xmodelotp4.getValueAt(y3, 12) + "|" + this.xmodelotp4.getValueAt(y3, 13) + "|" + this.xmodelotp4.getValueAt(y3, 14) + "|" + this.xmodelotp4.getValueAt(y3, 15) + "|" + this.xmodelotp4.getValueAt(y3, 16) + "|" + this.xmodelotp4.getValueAt(y3, 17));
                }
            }
            if (this.JTDetalleTipo5.getRowCount() != -1) {
                for (int y4 = 0; y4 < this.JTDetalleTipo5.getRowCount(); y4++) {
                    bw.newLine();
                    bw.write(this.xmodelotp5.getValueAt(y4, 0) + "|" + this.xmodelotp5.getValueAt(y4, 1) + "|" + this.xmodelotp5.getValueAt(y4, 2) + "|" + this.xmodelotp5.getValueAt(y4, 3) + "|" + this.xmodelotp5.getValueAt(y4, 4) + "|" + this.xmodelotp5.getValueAt(y4, 5) + "|" + this.xmodelotp5.getValueAt(y4, 6) + "|" + this.xmodelotp5.getValueAt(y4, 7) + "|" + this.xmodelotp5.getValueAt(y4, 8) + "|" + this.xmodelotp5.getValueAt(y4, 9) + "|" + this.xmodelotp5.getValueAt(y4, 10) + "|" + this.xmodelotp5.getValueAt(y4, 11) + "|" + this.xmodelotp5.getValueAt(y4, 12));
                }
            }
            if (this.JTDetalleTipo6.getRowCount() != -1) {
                for (int y5 = 0; y5 < this.JTDetalleTipo6.getRowCount(); y5++) {
                    bw.newLine();
                    bw.write(this.xmodelotp6.getValueAt(y5, 0) + "|" + this.xmodelotp6.getValueAt(y5, 1) + "|" + this.xmodelotp6.getValueAt(y5, 2) + "|" + this.xmodelotp6.getValueAt(y5, 3) + "|" + this.xmodelotp6.getValueAt(y5, 4) + "|" + this.xmodelotp6.getValueAt(y5, 5) + "|" + this.xmodelotp6.getValueAt(y5, 6) + "|" + this.xmodelotp6.getValueAt(y5, 7) + "|" + this.xmodelotp6.getValueAt(y5, 8) + "|" + this.xmodelotp6.getValueAt(y5, 9) + "|" + this.xmodelotp6.getValueAt(y5, 10) + "|" + this.xmodelotp6.getValueAt(y5, 11) + "|" + this.xmodelotp6.getValueAt(y5, 12) + "|" + this.xmodelotp6.getValueAt(y5, 13) + "|" + this.xmodelotp6.getValueAt(y5, 14));
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivoCircular014() {
        try {
            this.JLBNRegistro.getText();
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + this.xmodelo.getValueAt(0, 0) + this.xmodelo.getValueAt(0, 1) + this.xmodelo.getValueAt(0, 2) + this.xmodelo.getValueAt(0, 3) + "179.txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            if (this.JTDetalleTipo2.getRowCount() != -1) {
                for (int y = 0; y < this.JTDetalleTipo2.getRowCount(); y++) {
                    bw.write(this.xmodelo.getValueAt(y, 0) + "," + this.xmodelo.getValueAt(y, 1) + "," + this.xmodelo.getValueAt(y, 2) + "," + this.xmodelo.getValueAt(y, 3) + "," + this.xmodelo.getValueAt(y, 4) + "," + this.xmodelo.getValueAt(y, 5) + "," + this.xmodelo.getValueAt(y, 6) + "," + this.xmodelo.getValueAt(y, 7) + "," + this.xmodelo.getValueAt(y, 8) + "," + this.xmodelo.getValueAt(y, 9));
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivoCircular014_FT025() {
        String periodo;
        try {
            this.JLBNRegistro.getText();
            if (this.xmt.formatoMes.format(this.JDFechaF.getDate()).equals("06")) {
                periodo = "81";
            } else {
                periodo = "82";
            }
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][2] + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][3] + periodo + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + "FT025.txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            if (this.JTDetalle.getRowCount() != -1) {
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    bw.write(this.xmodelo.getValueAt(y, 0) + "|" + this.xmodelo.getValueAt(y, 1) + "|" + this.xmodelo.getValueAt(y, 2) + "|" + this.xmodelo.getValueAt(y, 3) + "|" + this.xmodelo.getValueAt(y, 4) + "|" + this.xmodelo.getValueAt(y, 5) + "|" + this.xmodelo.getValueAt(y, 6));
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivoCircular015() {
        try {
            this.JLBNRegistro.getText();
            String sFichero = this.JTFRuta.getText() + "\\" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][2] + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][3] + this.xmt.formatoAMD_Unida.format(this.JDFechaF.getDate()) + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + "ST006.XML";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            if (this.JTDetalleTipo2.getRowCount() != -1) {
                for (int y = 0; y < this.JTDetalleTipo2.getRowCount(); y++) {
                    bw.write(this.xmodelo.getValueAt(y, 0) + "," + this.xmodelo.getValueAt(y, 1) + "," + this.xmodelo.getValueAt(y, 2) + "," + this.xmodelo.getValueAt(y, 3) + "," + this.xmodelo.getValueAt(y, 4) + "," + this.xmodelo.getValueAt(y, 5) + "," + this.xmodelo.getValueAt(y, 6) + "," + this.xmodelo.getValueAt(y, 7) + "," + this.xmodelo.getValueAt(y, 8) + "," + this.xmodelo.getValueAt(y, 9) + "," + this.xmodelo.getValueAt(y, 10) + "," + this.xmodelo.getValueAt(y, 11) + "," + this.xmodelo.getValueAt(y, 12) + "," + this.xmodelo.getValueAt(y, 13) + "," + this.xmodelo.getValueAt(y, 14));
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivoRes() {
        try {
            int xnregistro = this.JTDetalleTipo2.getRowCount() + this.JTDetalleTipo3.getRowCount() + this.JTDetalleTipo4.getRowCount() + this.JTDetalleTipo5.getRowCount() + this.JTDetalleTipo6.getRowCount();
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "REC165ATGE" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate()) + Principal.informacionIps.getIdTipoIdentificacion() + "000" + Principal.informacionIps.getIdentificacion() + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            bw.write("1|" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][1] + "|" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][2] + "|" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][4] + "|" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "|" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "|" + xnregistro);
            bw.newLine();
            if (this.JTDetalleTipo2.getRowCount() > 0) {
                for (int i = 0; i < this.JTDetalleTipo2.getRowCount(); i++) {
                    bw.write(this.xmodelotp2.getValueAt(i, 0) + "|" + this.xmodelotp2.getValueAt(i, 1) + "|" + this.xmodelotp2.getValueAt(i, 2) + "|" + this.xmodelotp2.getValueAt(i, 3) + "|" + this.xmodelotp2.getValueAt(i, 4) + "|" + this.xmodelotp2.getValueAt(i, 5) + "|" + this.xmodelotp2.getValueAt(i, 6) + "|" + this.xmodelotp2.getValueAt(i, 7) + "|" + this.xmodelotp2.getValueAt(i, 8) + "|" + this.xmodelotp2.getValueAt(i, 9) + "|" + this.xmodelotp2.getValueAt(i, 10) + "|" + this.xmodelotp2.getValueAt(i, 11) + "|" + this.xmodelotp2.getValueAt(i, 12));
                    bw.newLine();
                }
            }
            if (this.JTDetalleTipo3.getRowCount() > 0) {
                for (int i2 = 0; i2 < this.JTDetalleTipo3.getRowCount(); i2++) {
                    bw.write(this.xmodelotp3.getValueAt(i2, 0) + "|" + this.xmodelotp3.getValueAt(i2, 1) + "|" + this.xmodelotp3.getValueAt(i2, 2) + "|" + this.xmodelotp3.getValueAt(i2, 3) + "|" + this.xmodelotp3.getValueAt(i2, 4) + "|" + this.xmodelotp3.getValueAt(i2, 5) + "|" + this.xmodelotp3.getValueAt(i2, 6) + "|" + this.xmodelotp3.getValueAt(i2, 7) + "|" + this.xmodelotp3.getValueAt(i2, 8) + "|" + this.xmodelotp3.getValueAt(i2, 9) + "|" + this.xmodelotp3.getValueAt(i2, 10) + "|" + this.xmodelotp3.getValueAt(i2, 11) + "|" + this.xmodelotp3.getValueAt(i2, 12) + "|" + this.xmodelotp3.getValueAt(i2, 13) + "|" + this.xmodelotp3.getValueAt(i2, 14) + "|" + this.xmodelotp3.getValueAt(i2, 15) + "|" + this.xmodelotp3.getValueAt(i2, 16) + "|" + this.xmodelotp3.getValueAt(i2, 17) + "|" + this.xmodelotp3.getValueAt(i2, 18) + "|" + this.xmodelotp3.getValueAt(i2, 19) + "|" + this.xmodelotp3.getValueAt(i2, 20));
                    bw.newLine();
                }
            }
            if (this.JTDetalleTipo4.getRowCount() > 0) {
                for (int i3 = 0; i3 < this.JTDetalleTipo4.getRowCount(); i3++) {
                    bw.write(this.xmodelotp4.getValueAt(1, 0) + "|" + this.xmodelotp4.getValueAt(i3, 1) + "|" + this.xmodelotp4.getValueAt(i3, 2) + "|" + this.xmodelotp4.getValueAt(i3, 3) + "|" + this.xmodelotp4.getValueAt(i3, 4) + "|" + this.xmodelotp4.getValueAt(i3, 5) + "|" + this.xmodelotp4.getValueAt(i3, 6) + "|" + this.xmodelotp4.getValueAt(i3, 7) + "|" + this.xmodelotp4.getValueAt(i3, 8) + "|" + this.xmodelotp4.getValueAt(i3, 9) + "|" + this.xmodelotp4.getValueAt(i3, 10) + "|" + this.xmodelotp4.getValueAt(i3, 11) + "|" + this.xmodelotp4.getValueAt(i3, 12) + "|" + this.xmodelotp4.getValueAt(i3, 13) + "|" + this.xmodelotp4.getValueAt(i3, 14) + "|" + this.xmodelotp4.getValueAt(i3, 15) + "|" + this.xmodelotp4.getValueAt(i3, 16) + "|" + this.xmodelotp4.getValueAt(i3, 17));
                    bw.newLine();
                }
            }
            if (this.JTDetalleTipo5.getRowCount() > 0) {
                for (int i4 = 0; i4 < this.JTDetalleTipo5.getRowCount(); i4++) {
                    bw.write(this.xmodelotp5.getValueAt(i4, 0) + "|" + this.xmodelotp5.getValueAt(i4, 1) + "|" + this.xmodelotp5.getValueAt(i4, 2) + "|" + this.xmodelotp5.getValueAt(i4, 3) + "|" + this.xmodelotp5.getValueAt(i4, 4) + "|" + this.xmodelotp5.getValueAt(i4, 5) + "|" + this.xmodelotp5.getValueAt(i4, 6) + "|" + this.xmodelotp5.getValueAt(i4, 7) + "|" + this.xmodelotp5.getValueAt(i4, 8) + "|" + this.xmodelotp5.getValueAt(i4, 9) + "|" + this.xmodelotp5.getValueAt(i4, 10) + "|" + this.xmodelotp5.getValueAt(i4, 11) + "|" + this.xmodelotp5.getValueAt(i4, 12) + "|" + this.xmodelotp5.getValueAt(i4, 13) + "|" + this.xmodelotp5.getValueAt(i4, 14) + "|" + this.xmodelotp5.getValueAt(i4, 15) + "|" + this.xmodelotp5.getValueAt(i4, 16) + "|" + this.xmodelotp5.getValueAt(i4, 17) + "|" + this.xmodelotp5.getValueAt(i4, 18) + "|" + this.xmodelotp5.getValueAt(i4, 19) + "|" + this.xmodelotp5.getValueAt(i4, 20) + "|" + this.xmodelotp5.getValueAt(i4, 21) + "|" + this.xmodelotp5.getValueAt(i4, 22) + "|" + this.xmodelotp5.getValueAt(i4, 23) + "|" + this.xmodelotp5.getValueAt(i4, 24) + "|" + this.xmodelotp5.getValueAt(i4, 25) + "|" + this.xmodelotp5.getValueAt(i4, 26));
                    bw.newLine();
                }
            }
            if (this.JTDetalleTipo6.getRowCount() > 0) {
                for (int i5 = 0; i5 < this.JTDetalleTipo6.getRowCount(); i5++) {
                    bw.write(this.xmodelotp6.getValueAt(i5, 0) + "|" + this.xmodelotp6.getValueAt(i5, 1) + "|" + this.xmodelotp6.getValueAt(i5, 2) + "|" + this.xmodelotp6.getValueAt(i5, 3) + "|" + this.xmodelotp6.getValueAt(i5, 4) + "|" + this.xmodelotp6.getValueAt(i5, 5) + "|" + this.xmodelotp6.getValueAt(i5, 6) + "|" + this.xmodelotp6.getValueAt(i5, 7) + "|" + this.xmodelotp6.getValueAt(i5, 8) + "|" + this.xmodelotp6.getValueAt(i5, 9) + "|" + this.xmodelotp6.getValueAt(i5, 10) + "|" + this.xmodelotp6.getValueAt(i5, 11) + "|" + this.xmodelotp6.getValueAt(i5, 12) + "|" + this.xmodelotp6.getValueAt(i5, 13) + "|" + this.xmodelotp6.getValueAt(i5, 14) + "|" + this.xmodelotp6.getValueAt(i5, 15) + "|" + this.xmodelotp6.getValueAt(i5, 16) + "|" + this.xmodelotp6.getValueAt(i5, 17) + "|" + this.xmodelotp6.getValueAt(i5, 18) + "|" + this.xmodelotp6.getValueAt(i5, 19) + "|" + this.xmodelotp6.getValueAt(i5, 20) + "|" + this.xmodelotp6.getValueAt(i5, 21));
                    bw.newLine();
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFConsultarInfR4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mReorganizarConsecutivo() {
        this.xnregistro = 0L;
        if (this.JTDetalleTipo2.getRowCount() != -1) {
            for (int y = 0; y < this.JTDetalleTipo2.getRowCount(); y++) {
                this.xnregistro++;
                this.xmodelo.setValueAt(Long.valueOf(this.xnregistro), y, 1);
            }
        }
        if (this.JTDetalleTipo3.getRowCount() != -1) {
            for (int y2 = 0; y2 < this.JTDetalleTipo3.getRowCount(); y2++) {
                this.xnregistro++;
                this.xmodelotp3.setValueAt(Long.valueOf(this.xnregistro), y2, 1);
            }
        }
        if (this.JTDetalleTipo4.getRowCount() != -1) {
            for (int y3 = 0; y3 < this.JTDetalleTipo4.getRowCount(); y3++) {
                this.xnregistro++;
                this.xmodelotp4.setValueAt(Long.valueOf(this.xnregistro), y3, 1);
            }
        }
        if (this.JTDetalleTipo5.getRowCount() != -1) {
            for (int y4 = 0; y4 < this.JTDetalleTipo5.getRowCount(); y4++) {
                this.xnregistro++;
                this.xmodelotp5.setValueAt(Long.valueOf(this.xnregistro), y4, 1);
            }
        }
        if (this.JTDetalleTipo6.getRowCount() != -1) {
            for (int y5 = 0; y5 < this.JTDetalleTipo6.getRowCount(); y5++) {
                this.xnregistro++;
                this.xmodelotp6.setValueAt(Long.valueOf(this.xnregistro), y5, 1);
            }
        }
        this.JLBNRegistro.setText("" + this.xnregistro);
    }

    private void mLLenarComboEmpresaC(int xd) {
        if (this.JCHFiltro.isSelected()) {
            this.xlleno = false;
            this.JCBEmpresa.setEnabled(true);
            this.JCBEmpresa.removeAllItems();
            if (getTitle().equals("INFORME RESOLUCIÓN 256")) {
                this.xsql = "SELECT cc_terceros.`Id`, cc_terceros.`RazonSocialCompleta` FROM `c_citas` INNER JOIN   `g_usuario` ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  g_sexo ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`) INNER JOIN   `f_empresacontxconvenio`  \nON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN   g_empresacont ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  `cc_terceros` ON (`g_empresacont`.`Id_empresa` = `cc_terceros`.`Id`) INNER JOIN  f_tipoempresacont ON (`f_tipoempresacont`.`Id` = `g_empresacont`.`Id_TipoEmprCont`) \nINNER JOIN   `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN   `g_procedimiento` ON (`c_clasecita`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nINNER JOIN   `g_especialidad` ON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN  `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nWHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'  AND f_tipoempresacont.AplicaR=1   AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' --  AND `g_procedimiento`.`C_Homologado` IN(890201, 890203, 890202,881112, 882841) \nAND `c_citas`.`Id_Especialidad` IN(382,387,461,460,1024,550,341,137,601,602) AND NR256 <>0 AND `c_citas`.`Id_MotivoDesistida` =1 -- and`g_persona`.`NoDocumento`=78301182 \n) GROUP BY cc_terceros.`Id` ORDER BY cc_terceros.`RazonSocialCompleta` ASC;";
                this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBEmpresa);
            } else if (getTitle().equals("INFORME RESOLUCIÓN 1552")) {
                if (xd == 0) {
                    this.xsql = "SELECT\n    `IdEmpresaConvenio`\n    , `NEmpresaConvenio`\nFROM\n     `p_res_1552`\nGROUP BY `IdEmpresaConvenio`\nORDER BY `NEmpresaConvenio` ASC";
                    this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBEmpresa);
                    this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
                } else if (xd == 1) {
                    this.xsql = "SELECT\n    `Id_Empresa`\n    , `NEmpresa`\nFROM\n    `p_res_1552`\nGROUP BY `Id_Empresa`\nORDER BY `NEmpresa` ASC";
                    this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBEmpresa);
                    this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
                }
            } else if (getTitle().equals("INFORME RESOLUCIÓN 1552 (CAJACOPI)")) {
                if (xd == 0) {
                    this.listaCargarCombo = new ArrayList();
                    this.listaCargarCombo = this.informeResolucion1552Service.ListarInforme1552Convenios(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                    this.JCBEmpresa.removeAllItems();
                    this.listaCargarCombo.forEach(next -> {
                        this.JCBEmpresa.addItem(next.getNombre());
                    });
                    this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
                } else if (xd == 1) {
                    this.listaCargarCombo = new ArrayList();
                    this.listaCargarCombo = this.informeResolucion1552Service.ListarInforme1552Terceros(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                    this.JCBEmpresa.removeAllItems();
                    this.listaCargarCombo.forEach(next2 -> {
                        this.JCBEmpresa.addItem(next2.getNombre());
                    });
                    this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
                }
            }
            this.JCBEmpresa.setSelectedIndex(-1);
            this.xlleno = true;
            return;
        }
        if (getTitle().equals("INFORME CIRCULAR 014")) {
            mCargarDatosTablaConvenios014();
        }
    }

    private void mCargarDatosTabla2175Tipo2() {
        try {
            mCrearModeloDatos2175Tipo2();
            String sql = "SELECT `p_res_2175`.`TipoRegistro` \n, `p_res_2175`.`Id`\n, `g_persona`.`Id_TipoIdentificacion`\n, TRIM(`g_persona`.`NoDocumento`) AS NoDocumento\n, `g_persona`.`FechaNac`\n, IF(`g_persona`.`Id_Sexo`='F','M','H') AS Sexo\n, `g_tipo_etnia`.`Id`\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido1`),'Ñ','N')) AS Apellido1\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido2`),'Ñ','N')) AS Apellido2\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre1`),'Ñ','N')) AS Nombre1\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre2`),'Ñ','N')) AS Nombre2\n, `p_res_2175`.`TSH`\n, IF(`p_res_2175`.`FechaTSH` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FechaTSH`),`p_res_2175`.`FechaTSH`,'')) AS FechaTSH\nFROM  `p_res_2175`  \n INNER JOIN  `h_atencion`  ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`)  \n INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  \n INNER JOIN  `f_empresacontxconvenio`  ON (ingreso.`Id_EmpresaContxConv`= f_empresacontxconvenio.`Id`) \n INNER JOIN  `g_usuario`   ON (`p_res_2175`.`IdUsuario`= `g_usuario`.`Id_persona`) \n INNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  \n INNER JOIN  `g_tipo_etnia`  ON (`g_tipo_etnia`.`Id` = `g_persona`.`Id_Etnia`) \n WHERE (`p_res_2175`.`TipoRegistro` =2 AND f_empresacontxconvenio.`Id_GIps`='" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][0] + "' ) ORDER BY `p_res_2175`.`Id`";
            System.out.println("Tipo 2 : " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            int n = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp2.addRow(this.xdato);
                    this.xmodelotp2.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    DefaultTableModel defaultTableModel = this.xmodelotp2;
                    int i = this.Pos;
                    this.Pos = i + 1;
                    defaultTableModel.setValueAt(Integer.valueOf(i), n, 1);
                    this.xmodelotp2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp2.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotp2.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelotp2.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelotp2.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelotp2.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelotp2.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelotp2.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelotp2.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelotp2.setValueAt(Integer.valueOf(xrs.getInt(12)), n, 11);
                    this.xmodelotp2.setValueAt(xrs.getString(13), n, 12);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2175Tipo2() {
        this.xmodelotp2 = new DefaultTableModel(new Object[0], new String[]{"TipoRegistro", "Id", "TipoIdentificacion", "No Documento", "FechaNac", "Sexo", "IdEtnia", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "TSH?", "FechaTSH"}) { // from class: Sig.JIF_Informes_GResoluciones.27
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleTipo2;
        JTable jTable2 = this.JTDetalleTipo2;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo2.doLayout();
        this.JTDetalleTipo2.setModel(this.xmodelotp2);
        this.JTDetalleTipo2.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleTipo2.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleTipo2.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleTipo2.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleTipo2.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleTipo2.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalleTipo2.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalleTipo2.getColumnModel().getColumn(12).setPreferredWidth(120);
    }

    private void mCargarDatosTabla2175Tipo3() {
        try {
            mCrearModeloDatos2175Tipo3();
            String sql = "SELECT `p_res_2175`.`TipoRegistro` \n, `p_res_2175`.`Id`\n, `g_persona`.`Id_TipoIdentificacion`\n, TRIM(`g_persona`.`NoDocumento`) AS NoDocumento\n, `g_persona`.`FechaNac`\n, IF(`g_persona`.`Id_Sexo`='F','M','H') AS Sexo\n, `g_tipo_etnia`.`Id`\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido1`),'Ñ','N')) as Apellido1\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido2`),'Ñ','N')) AS Apellido2\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre1`),'Ñ','N')) as Nombre1\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre2`),'Ñ','N')) AS Nombre2\n, `h_atencion`.`Fecha_Atencion` \n, `p_res_2175`.`Finalidad`\n, `p_res_2175`.`CUPS`\n, ROUND(`p_res_2175`.`Peso`,1) AS Peso\n, ROUND(`p_res_2175`.`Talla`)c\n, IF(`p_res_2175`.`FHierro` IS NULL,'', IF((p_res_2175.`FechaAtencion`<=`p_res_2175`.`FechaTSH`),`p_res_2175`.`FechaTSH`,'')) AS FechaTSH\n, IF(`p_res_2175`.`FVitA` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FVitA`),`p_res_2175`.`FVitA`,'')) AS FVitA\n, IF(`p_res_2175`.`FMNutriente` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FMNutriente`),`p_res_2175`.`FMNutriente`,'')) AS FMNutriente\n, IF(`p_res_2175`.`FHemoglobina` IS NULL,'',`p_res_2175`.`FHemoglobina`) AS FHemoglobina\n, ROUND(`p_res_2175`.`RHemoglobina`,1) AS RHemoglobina\nFROM  `p_res_2175`  \nINNER JOIN  `h_atencion`  ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`)  \nINNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  \nINNER JOIN  `f_empresacontxconvenio`  ON (ingreso.`Id_EmpresaContxConv`= f_empresacontxconvenio.`Id`)  \nINNER JOIN  `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  \nINNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  \nINNER JOIN  `g_tipo_etnia`  ON (`g_tipo_etnia`.`Id` = `g_persona`.`Id_Etnia`)  \nWHERE (`p_res_2175`.`TipoRegistro` =3 AND f_empresacontxconvenio.`Id_GIps`='" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][0] + "'    -- AND `g_persona`.`Id_TipoIdentificacion` IN('RC','PA') AND `p_res_2175`.`Talla`>0 \n-- AND `p_res_2175`.`RHemoglobina`>0 \\n \n) ORDER BY `p_res_2175`.`Id`";
            System.out.println("Tipo 3 : " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            int n = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp3.addRow(this.xdato);
                    this.xmodelotp3.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    DefaultTableModel defaultTableModel = this.xmodelotp3;
                    int i = this.Pos;
                    this.Pos = i + 1;
                    defaultTableModel.setValueAt(Integer.valueOf(i), n, 1);
                    this.xmodelotp3.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp3.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotp3.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelotp3.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelotp3.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelotp3.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelotp3.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelotp3.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelotp3.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelotp3.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelotp3.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelotp3.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelotp3.setValueAt(Double.valueOf(xrs.getDouble(15)), n, 14);
                    this.xmodelotp3.setValueAt(Double.valueOf(xrs.getDouble(16)), n, 15);
                    this.xmodelotp3.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelotp3.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelotp3.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelotp3.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelotp3.setValueAt(Double.valueOf(xrs.getDouble(21)), n, 20);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2175Tipo3() {
        this.xmodelotp3 = new DefaultTableModel(new Object[0], new String[]{"TipoRegistro", "Id", "TipoIdentificacion", "No Documento", "FechaNac", "Sexo", "IdEtnia", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Fecha Atencion", "Finalidad", "CUPS", "Peso", "Talla", "FechaTSH", "Fecha Vitamina A", "Fecha Suministro Nutrientes", "Fecha Hemoglobina", "Resultado Hemoglobina"}) { // from class: Sig.JIF_Informes_GResoluciones.28
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleTipo3;
        JTable jTable2 = this.JTDetalleTipo3;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo3.doLayout();
        this.JTDetalleTipo3.setModel(this.xmodelotp3);
        this.JTDetalleTipo3.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleTipo3.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleTipo3.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalleTipo3.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleTipo3.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTDetalleTipo3.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTDetalleTipo3.getColumnModel().getColumn(16).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(17).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(18).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(19).setPreferredWidth(120);
        this.JTDetalleTipo3.getColumnModel().getColumn(20).setPreferredWidth(80);
    }

    private void mCargarDatosTabla2175Tipo4y5() {
        try {
            mCrearModeloDatos2175Tipo4y5();
            String sql = "SELECT `p_res_2175`.`TipoRegistro` \n, `p_res_2175`.`Id`\n, `g_persona`.`Id_TipoIdentificacion`\n, TRIM(`g_persona`.`NoDocumento`) AS NoDocumento\n, `g_persona`.`FechaNac`\n, IF(`g_persona`.`Id_Sexo`='F','M','H') AS Sexo\n, `g_tipo_etnia`.`Id`\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido1`),'Ñ','N')) AS Apellido1\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido2`),'Ñ','N')) AS Apellido2\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre1`),'Ñ','N')) AS Nombre1\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre2`),'Ñ','N')) as Nombre2\n, `h_atencion`.`Fecha_Atencion` \n,`p_res_2175`.`Finalidad`\n, `p_res_2175`.`CUPS`\n, ROUND(`p_res_2175`.`Peso`,1) AS Peso\n, ROUND(`p_res_2175`.`Talla`) AS Talla\n, IF(`p_res_2175`.`FHemoglobina` IS NULL,'',`p_res_2175`.`FHemoglobina`) AS FHemoglobina\n,  ROUND(`p_res_2175`.`RHemoglobina`,1) AS RHemoglobina\nFROM  `p_res_2175`  \nINNER JOIN  `h_atencion`  ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`)  \nINNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  \nINNER JOIN  `f_empresacontxconvenio`  ON (ingreso.`Id_EmpresaContxConv`= f_empresacontxconvenio.`Id`)  \nINNER JOIN  `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  \nINNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  \nINNER JOIN  `g_tipo_etnia`  ON (`g_tipo_etnia`.`Id` = `g_persona`.`Id_Etnia`)  \nWHERE (`p_res_2175`.`TipoRegistro` IN(4,5) AND f_empresacontxconvenio.`Id_GIps`='" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][0] + "' -- AND `g_persona`.`Id_TipoIdentificacion` IN('RC','TI','PA') \n-- AND `p_res_2175`.`RHemoglobina`>0 \\n\n-- AND `p_res_2175`.`Talla`>0) ORDER BY `p_res_2175`.`Id`";
            System.out.println("Tipo 4 y 5 : " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            int n = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp4.addRow(this.xdato);
                    this.xmodelotp4.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    DefaultTableModel defaultTableModel = this.xmodelotp4;
                    int i = this.Pos;
                    this.Pos = i + 1;
                    defaultTableModel.setValueAt(Integer.valueOf(i), n, 1);
                    this.xmodelotp4.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp4.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotp4.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelotp4.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelotp4.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelotp4.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelotp4.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelotp4.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelotp4.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelotp4.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelotp4.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelotp4.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelotp4.setValueAt(Double.valueOf(xrs.getDouble(15)), n, 14);
                    this.xmodelotp4.setValueAt(Double.valueOf(xrs.getDouble(16)), n, 15);
                    this.xmodelotp4.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelotp4.setValueAt(Double.valueOf(xrs.getDouble(18)), n, 17);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2175Tipo4y5() {
        this.xmodelotp4 = new DefaultTableModel(new Object[0], new String[]{"TipoRegistro", "Id", "TipoIdentificacion", "No Documento", "FechaNac", "Sexo", "IdEtnia", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Fecha Atencion", "Finalidad", "CUPS", "Peso", "Talla", "Fecha Hemoglobina", "Resultado Hemoglobina"}) { // from class: Sig.JIF_Informes_GResoluciones.29
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleTipo4;
        JTable jTable2 = this.JTDetalleTipo4;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo4.doLayout();
        this.JTDetalleTipo4.setModel(this.xmodelotp4);
        this.JTDetalleTipo4.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleTipo4.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleTipo4.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleTipo4.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalleTipo4.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalleTipo4.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalleTipo4.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalleTipo4.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleTipo4.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalleTipo4.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleTipo4.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalleTipo4.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalleTipo4.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalleTipo4.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleTipo4.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTDetalleTipo4.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTDetalleTipo4.getColumnModel().getColumn(16).setPreferredWidth(120);
        this.JTDetalleTipo4.getColumnModel().getColumn(17).setPreferredWidth(120);
    }

    private void mCargarDatosTabla2175Tipo6() {
        try {
            mCrearModeloDatos2175Tipo6();
            String sql = "SELECT `p_res_2175`.`TipoRegistro`\n, `p_res_2175`.`Id`\n,`g_persona`\n.`Id_TipoIdentificacion`\n,TRIM(`g_persona`.`NoDocumento`) AS NoDocumento\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido1`),'Ñ','N')) AS Apellido1\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido2`),'Ñ','N')) AS Apellido2\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre1`),'Ñ','N')) AS Nombre1\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre2`),'Ñ','N')) AS Nombre2\n, `g_persona`.`FechaNac`\n, `p_res_2175`.`EdadGestacional`\n, `g_tipo_etnia`.`Id`\n, `h_atencion`.`Fecha_Atencion`\n, `p_res_2175`.`Finalidad`\n, `p_res_2175`.`CUPS`\n, IF(`p_res_2175`.`FAcFolico` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FAcFolico`),`p_res_2175`.`FAcFolico`,'')) as FAcFolico\n, IF(`p_res_2175`.`FHierro` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FHierro`),`p_res_2175`.`FHierro`,'')) as FHierro\n, IF(`p_res_2175`.`FCarbCalcio` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FCarbCalcio`),`p_res_2175`.`FCarbCalcio`,'')) as FCarbCalcio\n, IF(`p_res_2175`.`FHepatitisB` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FHepatitisB`),`p_res_2175`.`FHepatitisB`,'')) as FHepatitisB\n, `p_res_2175`.`RHepatitisB`\n, IF(`p_res_2175`.`FSifilis` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FSifilis`),`p_res_2175`.`FSifilis`,'')) as FSifilis\n, `p_res_2175`.`RSifilis`\n, IF(`p_res_2175`.`FAseVIH` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FAseVIH`),`p_res_2175`.`FAseVIH`,'')) as FAseVIH\n, IF(`p_res_2175`.`FVIH` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FVIH`),`p_res_2175`.`FVIH`,'')) as FVIH\n, `p_res_2175`.`RVIH`\n, IF(`p_res_2175`.`FHemoglobina` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FHemoglobina`),`p_res_2175`.`FHemoglobina`,'')) as FHemoglobina\n,  ROUND(`p_res_2175`.`RHemoglobina`,1) as RHemoglobina\n, IF(`p_res_2175`.`FLacMaterna` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FLacMaterna`),`p_res_2175`.`FLacMaterna`,'')) as FLacMaterna\nFROM  `p_res_2175`  \nINNER JOIN  `h_atencion`  ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`)  \nINNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  \nINNER JOIN  `f_empresacontxconvenio`  ON (ingreso.`Id_EmpresaContxConv`= f_empresacontxconvenio.`Id`)  \nINNER JOIN  `g_usuario`   ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  \nINNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  \nINNER JOIN  `g_tipo_etnia`  ON (`g_tipo_etnia`.`Id` = `g_persona`.`Id_Etnia`)  \nWHERE (`p_res_2175`.`TipoRegistro` IN(6) AND f_empresacontxconvenio.`Id_GIps`='" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][0] + "' -- AND `g_persona`.`Id_TipoIdentificacion` IN('RC','TI','CE','CC','PA') AND `p_res_2175`.`RHemoglobina`>0 AND `p_res_2175`.`EdadGestacional`>0) ORDER BY `p_res_2175`.`Id`";
            System.out.println("Tipo 6 : " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            int n = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp5.addRow(this.xdato);
                    this.xmodelotp5.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    DefaultTableModel defaultTableModel = this.xmodelotp5;
                    int i = this.Pos;
                    this.Pos = i + 1;
                    defaultTableModel.setValueAt(Integer.valueOf(i), n, 1);
                    this.xmodelotp5.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp5.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotp5.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelotp5.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelotp5.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelotp5.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelotp5.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelotp5.setValueAt(Integer.valueOf(xrs.getInt(10)), n, 9);
                    this.xmodelotp5.setValueAt(Long.valueOf(xrs.getLong(11)), n, 10);
                    this.xmodelotp5.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelotp5.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelotp5.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelotp5.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelotp5.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelotp5.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelotp5.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelotp5.setValueAt(Integer.valueOf(xrs.getInt(19)), n, 18);
                    this.xmodelotp5.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelotp5.setValueAt(Integer.valueOf(xrs.getInt(21)), n, 20);
                    this.xmodelotp5.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelotp5.setValueAt(xrs.getString(23), n, 22);
                    this.xmodelotp5.setValueAt(Integer.valueOf(xrs.getInt(24)), n, 23);
                    this.xmodelotp5.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelotp5.setValueAt(xrs.getString(26), n, 25);
                    this.xmodelotp5.setValueAt(xrs.getString(27), n, 26);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2175Tipo6() {
        this.xmodelotp5 = new DefaultTableModel(new Object[0], new String[]{"TipoRegistro", "Id", "TipoIdentificacion", "No Documento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "FechaNac", "Edad Gestacional", "IdEtnia", "Fecha Atencion", "Finalidad", "CUPS", "Fecha Acido Folico", "Fecha SulfatoF", "Fecha Carbonato Calcio", "Fecha HepatitisB", "Resultado HepatitisB", "Fecha Sifilis", "Resultado Sifilis", "Fecha AseVIH", "Fecha VIH", "Resultado VIH", "Fecha Hemoglobina", "Resultado Hemoglobina", "Fecha LacMaterna"}) { // from class: Sig.JIF_Informes_GResoluciones.30
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class, Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleTipo5;
        JTable jTable2 = this.JTDetalleTipo5;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo5.doLayout();
        this.JTDetalleTipo5.setModel(this.xmodelotp5);
        this.JTDetalleTipo5.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleTipo5.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleTipo5.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalleTipo5.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalleTipo5.getColumnModel().getColumn(13).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(15).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(16).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(17).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTDetalleTipo5.getColumnModel().getColumn(19).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTDetalleTipo5.getColumnModel().getColumn(21).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(22).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(23).setPreferredWidth(80);
        this.JTDetalleTipo5.getColumnModel().getColumn(24).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(25).setPreferredWidth(120);
        this.JTDetalleTipo5.getColumnModel().getColumn(26).setPreferredWidth(120);
    }

    private void mCargarDatosTabla2175Tipo7() {
        try {
            mCrearModeloDatos2175Tipo7();
            String sql = "SELECT `p_res_2175`.`TipoRegistro`\n, `p_res_2175`.`Id`\n,`g_persona`.`Id_TipoIdentificacion`\n, TRIM(`g_persona`.`NoDocumento`) AS NoDocumento\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido1`),'Ñ','N')) AS Apellido1\n, TRIM(REPLACE(UPPER(`g_persona`.`Apellido2`),'Ñ','N')) AS Apellido2\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre1`),'Ñ','N')) AS Nombre1\n, TRIM(REPLACE(UPPER(`g_persona`.`Nombre2`),'Ñ','N')) AS Nombre2\n, `g_tipo_etnia`.`Id`\n, IF(`p_res_2175`.`FechaParto` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FechaParto`),`p_res_2175`.`FechaParto`,'')) AS FechaParto\n, `p_res_2175`.`Finalidad`\n, `p_res_2175`.`CUPS`\n,  p_res_2175.TomaRapSifilis\n, IF(`p_res_2175`.`FTomaRapSifilis` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FTomaRapSifilis`),`p_res_2175`.`FTomaRapSifilis`,'')) AS FTomaRapSifilis\n, p_res_2175.RSifilis\n, p_res_2175.AsesoriaVIHElisa\n, IF(`p_res_2175`.`FAseVIH` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FAseVIH`),`p_res_2175`.`FAseVIH`,'')) AS FAseVIH\n, p_res_2175.PruRapidaVIH\n, IF(`p_res_2175`.`FVIH` IS NULL,'', IF( (p_res_2175.`FechaAtencion`<=`p_res_2175`.`FVIH`),`p_res_2175`.`FVIH`,'')) AS FVIH\n, p_res_2175.RVIH\n, p_res_2175.SumAnticonceptivo\n, IF(p_res_2175.FSumAnticonceptivo IS NULL,'',p_res_2175.FSumAnticonceptivo) AS FSumAnticonceptivo1\nFROM  `p_res_2175`  \nINNER JOIN  `h_atencion`  ON (`p_res_2175`.`IdAtencion` = `h_atencion`.`Id`)  \nINNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  \nINNER JOIN  `f_empresacontxconvenio`  ON (ingreso.`Id_EmpresaContxConv`= f_empresacontxconvenio.`Id`)  \nINNER JOIN  `g_usuario`   ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  \nINNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  \nINNER JOIN  `g_tipo_etnia`  ON (`g_tipo_etnia`.`Id` = `g_persona`.`Id_Etnia`)  \nWHERE (`p_res_2175`.`TipoRegistro` IN(7) AND f_empresacontxconvenio.`Id_GIps`='" + this.xid_ips[this.JCB_Combo1.getSelectedIndex()][0] + "' -- AND `g_persona`.`Id_TipoIdentificacion` IN('TI','CE','CC','PA')) ORDER BY `p_res_2175`.`Id`";
            System.out.println("Tipo 7 : " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            int n = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnregistro++;
                    this.xmodelotp6.addRow(this.xdato);
                    this.xmodelotp6.setValueAt(xrs.getString(1), n, 0);
                    DefaultTableModel defaultTableModel = this.xmodelotp6;
                    int i = this.Pos;
                    this.Pos = i + 1;
                    defaultTableModel.setValueAt(Integer.valueOf(i), n, 1);
                    this.xmodelotp6.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelotp6.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelotp6.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelotp6.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelotp6.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelotp6.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelotp6.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelotp6.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelotp6.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelotp6.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelotp6.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelotp6.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelotp6.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelotp6.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelotp6.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelotp6.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelotp6.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelotp6.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelotp6.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelotp6.setValueAt(xrs.getString(22), n, 21);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Informes_GResoluciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2175Tipo7() {
        this.xmodelotp6 = new DefaultTableModel(new Object[0], new String[]{"TipoRegistro", "Id", "TipoIdentificacion", "No Documento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "IdEtnia", "FechaParto", "Finalidad", "CUPS", "TomaRapSifilis", "FechaTomaRapSifilis", "ResultadoSifilis", "AsesoriaVIHElisa", "Fecha AseVIH", "PruRapidaVIH", "FechaVIH", "ResultadoVIH", "SumAnticonceptivo", "Fecha FSumAnticonceptivo1"}) { // from class: Sig.JIF_Informes_GResoluciones.31
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleTipo6;
        JTable jTable2 = this.JTDetalleTipo6;
        jTable.setAutoResizeMode(0);
        this.JTDetalleTipo6.doLayout();
        this.JTDetalleTipo6.setModel(this.xmodelotp6);
        this.JTDetalleTipo6.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleTipo6.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleTipo6.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalleTipo6.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalleTipo6.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalleTipo6.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleTipo6.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleTipo6.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleTipo6.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleTipo6.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleTipo6.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleTipo6.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalleTipo6.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalleTipo6.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalleTipo6.getColumnModel().getColumn(21).setPreferredWidth(100);
    }
}
