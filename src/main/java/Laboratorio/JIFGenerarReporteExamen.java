package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.jpa.projection.IEmpresaContratoConvenioDTO;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFGenerarReporteExamen.class */
public class JIFGenerarReporteExamen extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String[][] xidprofesionales;
    private String[] xidSede;
    private String[] idMunicipio;
    private File xfile;
    public List<IEmpresaContratoConvenioDTO> listConvenio;
    private final IEmpresaContConvenioService iEmpresaContConvenioService;
    private String[] xidSubEmpresa;
    private ButtonGroup JBGOpciones;
    private ButtonGroup JBGOpciones1;
    private JButton JBTExportar;
    private JButton JBTValidarExamenes;
    private JComboBox<String> JCBConvenio;
    private JComboBox<String> JCBMunicipio;
    private JComboBox<String> JCBSede;
    private JComboBox<String> JCBSubEmpresa;
    private JCheckBox JCHMunicipio;
    private JCheckBox JCHSede;
    public JCheckBox JCH_AplicaFiltroConvenio;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDetalleE;
    private JPanel JPI_Filtro;
    private JRadioButton JRBQuitarSeleccion;
    private JRadioButton JRBSeleccionar;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTextField JTFDesde;
    private JTextField JTFHasta;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String listSedesSeleccionadas = "";
    private String subEmpresa = "";

    public JIFGenerarReporteExamen(String xnombre) {
        initComponents();
        setName(xnombre);
        this.iEmpresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v66, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JBGOpciones1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JRBSeleccionar = new JRadioButton();
        this.JRBQuitarSeleccion = new JRadioButton();
        this.JCBSede = new JComboBox<>();
        this.JCHSede = new JCheckBox();
        this.JCBMunicipio = new JComboBox<>();
        this.JCHMunicipio = new JCheckBox();
        this.JCBConvenio = new JComboBox<>();
        this.JCBSubEmpresa = new JComboBox<>();
        this.JCH_AplicaFiltroConvenio = new JCheckBox();
        this.JPI_Filtro = new JPanel();
        this.jRadioButton1 = new JRadioButton();
        this.jRadioButton2 = new JRadioButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDetalleE = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JBTValidarExamenes = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel1 = new JPanel();
        this.JTFDesde = new JTextField();
        this.JTFHasta = new JTextField();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE RESULTADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifgenerarreporte");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFGenerarReporteExamen.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarReporteExamen.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFGenerarReporteExamen.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarReporteExamen.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JBGOpciones.add(this.JRBSeleccionar);
        this.JRBSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JRBSeleccionar.setSelected(true);
        this.JRBSeleccionar.setText("Seleccionar Todo");
        this.JRBSeleccionar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JRBSeleccionarActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBQuitarSeleccion);
        this.JRBQuitarSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRBQuitarSeleccion.setText("Quitar Selección");
        this.JRBQuitarSeleccion.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.4
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JRBQuitarSeleccionActionPerformed(evt);
            }
        });
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHSede.setFont(new Font("Arial", 1, 12));
        this.JCHSede.setText("Filtrar por Sede?");
        this.JCHSede.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.5
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JCHSedeActionPerformed(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio Residencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCHMunicipio.setText("Filtrar por municipio?");
        this.JCHMunicipio.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.6
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JCHMunicipioActionPerformed(evt);
            }
        });
        this.JCBConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConvenio.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.7
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JCBConvenioActionPerformed(evt);
            }
        });
        this.JCBSubEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Sub Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 204)));
        this.JCBSubEmpresa.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.8
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JCBSubEmpresaActionPerformed(evt);
            }
        });
        this.JCH_AplicaFiltroConvenio.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaFiltroConvenio.setText("Filtrar?");
        this.JCH_AplicaFiltroConvenio.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.9
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JCH_AplicaFiltroConvenioActionPerformed(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por fecha de:", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGOpciones1.add(this.jRadioButton1);
        this.jRadioButton1.setFont(new Font("Arial", 1, 12));
        this.jRadioButton1.setSelected(true);
        this.jRadioButton1.setText("Resultado");
        this.JBGOpciones1.add(this.jRadioButton2);
        this.jRadioButton2.setFont(new Font("Arial", 1, 12));
        this.jRadioButton2.setText("Facturación");
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.jRadioButton1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRadioButton2).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRadioButton1).addComponent(this.jRadioButton2)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBSubEmpresa, -2, 749, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_AplicaFiltroConvenio)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JDFechaI, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 131, -2).addGap(18, 18, 18).addComponent(this.JCBSede, 0, -1, 32767))).addGap(12, 12, 12).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSeleccionar).addComponent(this.JRBQuitarSeleccion).addComponent(this.JCHSede))).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBMunicipio, -2, 225, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHMunicipio).addGap(18, 18, 18).addComponent(this.JCBConvenio, 0, -1, 32767).addGap(5, 5, 5))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_Filtro, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSede).addComponent(this.JCBSede, -2, 50, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMunicipio, -2, 50, -2).addComponent(this.JCHMunicipio).addComponent(this.JCBConvenio, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSubEmpresa, -2, 43, -2).addComponent(this.JCH_AplicaFiltroConvenio)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JRBSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBQuitarSeleccion))).addContainerGap()));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFGenerarReporteExamen.10
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarReporteExamen.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("CONSOLIDADO POR RECEPCIÓN", this.JSPDetalle);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "PROCEDIMIENTO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFGenerarReporteExamen.11
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarReporteExamen.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JBTValidarExamenes.setFont(new Font("Arial", 1, 12));
        this.JBTValidarExamenes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTValidarExamenes.setText("Validar Exámenes");
        this.JBTValidarExamenes.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.12
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JBTValidarExamenesActionPerformed(evt);
            }
        });
        GroupLayout JPIDetalleELayout = new GroupLayout(this.JPIDetalleE);
        this.JPIDetalleE.setLayout(JPIDetalleELayout);
        JPIDetalleELayout.setHorizontalGroup(JPIDetalleELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleELayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleELayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JBTValidarExamenes, -2, 353, -2)).addComponent(this.JSPDetalle1, -1, 1055, 32767)).addContainerGap()));
        JPIDetalleELayout.setVerticalGroup(JPIDetalleELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleELayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 317, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTValidarExamenes, -2, 56, -2).addContainerGap()));
        this.JTPDatos.addTab("DETALLADO POR EXAMEN", this.JPIDetalleE);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFGenerarReporteExamen.13
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarReporteExamen.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.14
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFGenerarReporteExamen.15
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamen.this.JBTExportarActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar por rango de Recepciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JTFDesde.setFont(new Font("Arial", 1, 16));
        this.JTFDesde.setHorizontalAlignment(0);
        this.JTFDesde.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFGenerarReporteExamen.16
            public void keyPressed(KeyEvent evt) {
                JIFGenerarReporteExamen.this.JTFDesdeKeyPressed(evt);
            }
        });
        this.JTFHasta.setFont(new Font("Arial", 1, 16));
        this.JTFHasta.setHorizontalAlignment(0);
        this.JTFHasta.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFGenerarReporteExamen.17
            public void keyPressed(KeyEvent evt) {
                JIFGenerarReporteExamen.this.JTFHastaKeyPressed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Desde");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Hasta");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDesde, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFHasta, -2, 104, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDesde, -2, -1, -2).addComponent(this.JTFHasta, -2, -1, -2).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGap(0, 4, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 191, -2).addGap(49, 49, 49).addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTPDatos, GroupLayout.Alignment.LEADING))).addContainerGap(31, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -1, 422, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2)).addComponent(this.jPanel1, -2, -1, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 0) {
            mImprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSeleccionarActionPerformed(ActionEvent evt) {
        mQuitarPonerSeleccion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBQuitarSeleccionActionPerformed(ActionEvent evt) {
        mQuitarPonerSeleccion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                String[][] parametros = new String[5][2];
                parametros[0][0] = "id";
                parametros[0][1] = this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 8).toString();
                parametros[1][0] = "profesional";
                parametros[1][1] = "";
                parametros[2][0] = "idprocedimiento";
                parametros[2][1] = this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 4).toString();
                parametros[3][0] = "SUBREPORT_DIR";
                parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[4][0] = "SUBREPORTFIRMA_DIR";
                parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_Proced", parametros);
                this.xct.cerrarConexionBd();
                return;
            }
            mImprimir1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValidarExamenesActionPerformed(ActionEvent evt) {
        if (this.JTDetalle1.getRowCount() != -1) {
            if (!this.xmt.mVerificarDatosTablaTrue(this.JTDetalle1, 6)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de validar los resultados pendientes?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    for (int z = 0; z < this.JTDetalle1.getRowCount(); z++) {
                        if (!Boolean.valueOf(this.xmodelo1.getValueAt(z, 6).toString()).booleanValue()) {
                            String xsql = "update l_detallerecepcion set ValidadoLab=1 where Id_Recepcion='" + this.xmodelo1.getValueAt(z, 0) + "', Id_Procedim='" + this.xmodelo1.getValueAt(z, 4) + "'";
                            this.xct.ejecutarSQL(xsql);
                            this.xct.cerrarConexionBd();
                            mCargarDatosTabla1();
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Resultados validadados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 8)) {
            mCrearArchivos();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar recepcioón a generar ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSedeActionPerformed(ActionEvent evt) {
        if (this.JCHSede.isSelected()) {
            this.JCBSede.setEnabled(true);
        } else {
            this.JCBSede.setEnabled(false);
        }
        this.JCBSede.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMunicipioActionPerformed(ActionEvent evt) {
        llenarMunicipio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.JCHMunicipio.isSelected()) {
            llenarMunicipio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.JCHMunicipio.isSelected()) {
            llenarMunicipio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDesdeKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.JTFDesde.getText().isEmpty()) {
                mCargarDatosTabla();
            } else {
                JOptionPane.showInternalOptionDialog(this, "Ingrese un valor inicial", "BUSCAR", 1, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFHastaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.JTFDesde.getText().isEmpty()) {
                mCargarDatosTabla();
            } else {
                JOptionPane.showInternalOptionDialog(this, "Ingrese un valor inicial", "BUSCAR", 1, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioActionPerformed(ActionEvent evt) {
        if (this.listConvenio.get(this.JCBConvenio.getSelectedIndex()).getId() != null) {
            this.JCBSubEmpresa.removeAllItems();
            String sql = "select ec.id, ec.nombre from f_empresacontxconvenio_mision ec WHERE ec.idEmpresaConvenio = '" + this.listConvenio.get(this.JCBConvenio.getSelectedIndex()).getId() + "'";
            this.xidSubEmpresa = this.xct.llenarCombo(sql, this.xidSubEmpresa, this.JCBSubEmpresa);
            this.JCBSubEmpresa.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubEmpresaActionPerformed(ActionEvent evt) {
        this.subEmpresa = (String) this.JCBSubEmpresa.getSelectedItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AplicaFiltroConvenioActionPerformed(ActionEvent evt) {
        getConvenios();
    }

    public void mBuscar() {
        mCargarDatosTabla();
        mCargarDatosTabla1();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.JCBSede.removeAllItems();
        this.xidSede = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `g_sedes` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", this.xidSede, this.JCBSede);
        this.JCBSede.setSelectedIndex(-1);
        this.JCBSede.setEnabled(false);
        this.xct.cerrarConexionBd();
        mCrearModeloDatos();
        mCrearModeloDatos1();
    }

    private void llenarMunicipio() {
        this.JCBMunicipio.removeAllItems();
        String datoFecha = " DATE_FORMAT(lr2.`FechaResult`, '%Y-%m-%d') ";
        if (this.jRadioButton2.isSelected()) {
            datoFecha = " DATE_FORMAT(i.FechaIngreso, '%Y-%m-%d') ";
        }
        String sql = "select gm.Id, concat(gm.Nbre,'-',gd.Nbre) nombre\nfrom l_recepcion lr \ninner join f_ordenes fo on (lr.Id_OrdenFacturac =fo.Id )\ninner join ingreso i on (i.Id=fo.Id_Ingreso )\n inner join l_resultados lr2  on (lr2.Id_Recepcion =lr.Id )\n inner join g_persona gp on (gp.Id =i.Id_Usuario )\ninner join g_municipio gm on (gm.Id =gp.Id_Municipio )\ninner join g_departamento gd on (gm.Id_Dpto =gd.Id )\nwhere (" + datoFecha + ">='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\nand " + datoFecha + "<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')\ngroup by gm.Id\norder by nombre asc";
        this.idMunicipio = this.xct.llenarCombo(sql, this.idMunicipio, this.JCBMunicipio);
    }

    public void mImprimir() {
        Object[] botones = {"Formato PreImpreso", "Normal", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "IMPRIMIR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
        if (n == 0) {
            impresion.mImprimirResultado(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), false, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString(), true);
        } else if (n == 1) {
            impresion.mImprimirResultado(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString(), true);
        }
    }

    private void getConvenios() {
        this.JCBConvenio.setModel(new DefaultComboBoxModel());
        this.listConvenio = new ArrayList();
        this.listConvenio = this.iEmpresaContConvenioService.getListEmpresaConvenio(new Long(0L));
        this.JCBConvenio.removeAllItems();
        this.listConvenio.forEach(e -> {
            this.JCBConvenio.addItem(e.getEmpresaContratante());
        });
    }

    public void mImprimir1() {
        String[][] parametros = new String[4][2];
        if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle1, 8)) {
            String xcodigopro = "";
            for (int x = 0; x < this.JTDetalle1.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo1.getValueAt(x, 8).toString()).booleanValue()) {
                    xcodigopro = xcodigopro + "," + this.xmodelo1.getValueAt(x, 4).toString();
                }
            }
            String sql = "SELECT l_resultados.Id_Recepcion, CAST(LPAD(l_resultados.Id_Recepcion,10,'0') AS CHAR) AS NRecepcion, l_recepcion.FechaRecep AS FechaR, persona.NoHistoria, CONCAT(persona.Id_TipoIdentificacion,'-', persona.NoDocumento) AS NDocumento , persona.NUsuario, persona.Edad,persona.NTipoEdad, persona.IdSexo, persona.Telefono,cc_terceros.RazonSocialCompleta AS NEmpresa, l_areas.Nbre AS NArea, g_procedimiento.`Id` AS IdProcedimiento, g_procedimiento.Nbre AS NProcedimiento, l_protocolos.Nbre AS NProtocolo , IF(l_tiporesultado.Vandera=0,l_detalleresultado.VrNumerico,IF(l_tiporesultado.Vandera=1,l_tiporesultado.Nbre,l_detalleresultado.VrNumerico )) AS Resultado , l_detalleresultado.`VReferencia1` AS VMinimo , l_detalleresultado.`VReferencia2` AS VMaximo , IF(l_detalleresultado.`Observacion`='',NULL,CONCAT('OBSERVACIÓN : ',l_detalleresultado.`Observacion`)) AS ObservacionProtocolo , IF(l_detalleresultado.`Alterado`=1, '***','') AS RAlterado , profesional1.NProfesional, profesional1.Especialidad , l_detalleresultado.Unidad, w_profesional.NProfesional AS Bacteriologa, w_profesional.Especialidad AS EspBact, w_profesional.DireccionF AS Url ,l_tipo_metodo.Nbre AS TipoMetodo ,l_detallerecepcion.FechaResultado AS FechaResultado, d_ips.`NEmpresa` AS NIPs,IF(d_ips.`Direccion` IS NULL,'',d_ips.`Direccion`) AS DireccionIps,IF(d_ips.`Direccion2` IS NULL,'',d_ips.`Direccion2`) AS DireccionIps2,d_ips.`TipoIdEmpresa` AS TipoDocIps,d_ips.`IdConcatenado` AS NitIps,IF(d_ips.`Eslogan` IS NULL,'',d_ips.`Eslogan`)  AS EsloganIps, d_ips.`Logo` AS LogoIps,d_ips.`LogoC` AS LogoCIps, g_procedimiento.`NOrdenI`, g_sedes.`Nbre` AS Sede, IF(l_tipo_encabezado.Nbre='NO APLICA',NULL,l_tipo_encabezado.Nbre) AS Encabezado, `ingreso`.`NoAutorizacion`, IFNULL(PersonaValida.NProfesional,'') AS BacteriologaV, IFNULL(PersonaValida.Especialidad,'') AS EspBactV, IFNULL(PersonaValida.DireccionF,'') AS UrlV FROM d_ips, l_detalleresultado INNER JOIN l_resultados ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN w_profesional ON (l_detalleresultado.`Bacteriologo` = w_profesional.Id_Persona) AND (l_detalleresultado.`Id_Especialidad` = w_profesional.`IdEspecialidad`) LEFT JOIN w_profesional AS PersonaValida ON (l_detalleresultado.`IdProfesionalV` = PersonaValida.Id_Persona) AND (l_detalleresultado.`IdEspecialidadV` = PersonaValida.`IdEspecialidad`) INNER JOIN l_recepcion ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN profesional1 ON (profesional1.Id_Persona = l_recepcion.Id_Profesional) AND (profesional1.IdEspecialidad = l_recepcion.Id_Especialidad) INNER JOIN persona ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN g_procedimiento ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) INNER JOIN l_areas  INNER JOIN l_protocolos ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) INNER JOIN l_tiporesultado ON (l_detalleresultado.Resultado = l_tiporesultado.Id) INNER JOIN l_tipo_metodo ON (l_tipo_metodo.Id = g_procedimiento.Id_TipoMetodo) INNER JOIN l_detallerecepcion ON (l_recepcion.Id = l_detallerecepcion.Id_Recepcion)  AND (l_protocoloxprocedimiento.Id_Procedim = l_detallerecepcion.Id_Procedim) INNER JOIN `f_empresacontxconvenio` ON (l_recepcion.`Id_EmpresaConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_empresacont` ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`) INNER JOIN cc_terceros ON (`g_empresacont`.`Id_empresa` = cc_terceros.`Id`) INNER JOIN g_sedes ON (g_sedes.`Id` = l_recepcion.`Id_Sede`) INNER JOIN l_tipo_encabezado ON (l_tipo_encabezado.Id = l_protocolos.Id_tencabezado) INNER JOIN `f_ordenes` ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) INNER JOIN `ingreso` ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`) WHERE (l_resultados.Id_Recepcion ='" + this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 4).toString() + "' AND g_procedimiento.Id in(" + xcodigopro.substring(1, xcodigopro.length()) + ") AND l_resultados.Estado =0 AND l_detallerecepcion.`ValidadoLab`=1 AND  l_detalleresultado.Estado=1  AND  l_detalleresultado.Imprime=1 )  GROUP BY l_protocoloxprocedimiento.Id  ORDER BY g_procedimiento.`NOrdenI` ASC, l_protocoloxprocedimiento.`Orden` ASC ";
            mCrearVistaAjustes(sql);
            parametros[0][0] = "id";
            parametros[0][1] = this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 4).toString();
            parametros[1][0] = "idp";
            parametros[1][1] = xcodigopro.substring(1, xcodigopro.length());
            parametros[2][0] = "SUBREPORT_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[3][0] = "SUBREPORTFIRMA_DIR";
            parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_Resultados_Id_N1_P", parametros);
            this.xct.cerrarConexionBd();
        }
    }

    private void mCrearVistaAjustes(String xsql) {
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS l_v_tmp_planilla  ");
        this.xct.cerrarConexionBd();
        String sqlw = "CREATE VIEW l_v_tmp_planilla AS " + xsql;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
    }

    public void mQuitarPonerSeleccion() {
        if (this.JTDetalle.getRowCount() != -1) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (this.JRBSeleccionar.isSelected()) {
                    this.xmodelo.setValueAt(true, x, 8);
                } else if (this.JRBQuitarSeleccion.isSelected()) {
                    this.xmodelo.setValueAt(false, x, 8);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "NHC", "Usuario", "Sexo", "Edad", "Fecha", "NProfesional", "Especialidad", "Generar?", "", "IdPersona", "Sede", "Fecha Ingreso", "Fecha Resultado"}) { // from class: Laboratorio.JIFGenerarReporteExamen.18
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Recepcion", "NHC", "Usuario", "IdP", "Procedimiento", "Validado?", "Revisado?", "IdResultado", "Imprimir?", "IdPersona", "Sede", "Fecha Ingreso", "Fecha Resultado"}) { // from class: Laboratorio.JIFGenerarReporteExamen.19
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, String.class, Boolean.class, Boolean.class, Long.class, Boolean.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle1;
        JTable jTable2 = this.JTDetalle1;
        jTable.setAutoResizeMode(0);
        this.JTDetalle1.doLayout();
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(13).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mCrearModeloDatos();
        StringBuilder sql = new StringBuilder();
        String datoFecha = " DATE_FORMAT(l_resultados.`FechaResult`, '%Y-%m-%d') ";
        if (this.jRadioButton2.isSelected()) {
            datoFecha = " DATE_FORMAT(i.FechaIngreso, '%Y-%m-%d') ";
        }
        if (Principal.informacionIps.getIdentificacion().equals("800080586")) {
            sql.append("SELECT l_resultados.Id_Recepcion\n, gu.NoHistoria, concat(gp.Apellido1 ,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) as NUsuario\n, gp.Id_Sexo IdSexo\n, gp.Edad edad\n, gp.Id_TipoEdad \n, DATE_FORMAT(l_recepcion.FechaRecep, '%d-%m-%Y') AS FechaR\n, profesional1.NProfesional\n, profesional1.Especialidad\n, l_recepcion.Id_Profesional\n, gp.Id as Id_persona\n,`g_sedes`.`Nbre` AS Sede \n, fe.Nbre  convenio\n, ge.Nbre  entidad, ge.Id \n, gp2.Id idProcedimiento\n, gp2.Nbre  nombrePoced, i.FechaIngreso, l_resultados.FechaResult as fechaResultado \n FROM l_resultados \n INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id) \n inner join l_detallerecepcion ld on (ld.Id_Recepcion =l_recepcion.Id)\n inner  join g_procedimiento gp2 on (gp2.Id=ld.Id_Procedim)\n INNER JOIN f_ordenes fo ON (fo.Id= l_recepcion.Id_OrdenFacturac)\n inner  join ingreso i  on (i.Id=fo.Id_Ingreso)\n inner join f_empresacontxconvenio fe on (fe.Id=i.Id_EmpresaContxConv)\n inner join g_empresa ge on (ge.Id=fe.Id_EmpresaCont)\n INNER JOIN profesional1  ON (profesional1.Id_Persona = l_recepcion.Id_Profesional) AND (profesional1.IdEspecialidad = l_recepcion.Id_Especialidad) \n inner join g_usuario gu on (gu.Id_persona=l_recepcion.Id_Paciente)\n INNER JOIN g_persona gp  ON (gp.Id = gu.Id_persona) \nINNER JOIN `g_sedes` ON (`g_sedes`.`Id`= `l_recepcion`.`Id_Sede`) \nWHERE (l_resultados.Estado =0 \nAND " + datoFecha + " BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'  and '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `l_recepcion`.`Id_Sede` =1\nand ge.Id =98\nand gp2.Nbre like '%covid%'\n) \n GROUP BY l_resultados.Id_Recepcion\nORDER BY l_resultados.Id_Recepcion");
            return;
        }
        if (!this.JTFDesde.getText().isEmpty() && !this.JTFHasta.getText().isEmpty()) {
            sql.append("  SELECT  l_resultados.Id_Recepcion, g_persona.NoDocumento, CONCAT(g_persona.Nombre1,' ', g_persona.Nombre2,' ', g_persona.Apellido1, ' ', g_persona.Apellido2) AS  nombre ,\n  g_persona.Id_Sexo, IF(g_persona.Edad=0, 1 , Edad) Edad , g_tipoedad.`Nbre` TipoEdad,  DATE_FORMAT( l_recepcion.FechaRecep,'%d-%m-%Y'  ) AS FechaR,\n  profesional1.NProfesional,  profesional1.Especialidad,  l_recepcion.Id_Profesional,  `g_persona`.`Id` AS idPersona, g_sedes.Nbre AS Sede, i.FechaIngreso, l_resultados.FechaResult as fechaResultado\n  FROM \n  l_resultados \n  INNER JOIN l_recepcion   ON ( l_resultados.Id_Recepcion = l_recepcion.Id  )\n  INNER JOIN profesional1  ON ( profesional1.Id_Persona = l_recepcion.Id_Profesional  )AND ( profesional1.IdEspecialidad = l_recepcion.Id_Especialidad     )\n  INNER JOIN g_persona   ON (  g_persona.Id = l_recepcion.Id_Paciente    )\n  INNER JOIN `g_tipoedad` ON g_persona.`Id_TipoEdad`=g_tipoedad.`Id`\n  INNER JOIN g_sedes  ON (  g_sedes.Id = l_recepcion.Id_Sede )\n  WHERE (l_resultados.Id_Recepcion>=" + this.JTFDesde.getText() + " and  l_resultados.Id_Recepcion<=" + this.JTFHasta.getText() + " ) \n GROUP BY l_resultados.Id_Recepcion\n ORDER BY l_resultados.Id_Recepcion");
        } else {
            sql.append("SELECT  l_resultados.Id_Recepcion, g_persona.NoDocumento, CONCAT(g_persona.Nombre1,' ', g_persona.Nombre2,' ', g_persona.Apellido1, ' ', g_persona.Apellido2) AS  nombre ,\n  g_persona.Id_Sexo, IF(g_persona.Edad=0, 1 , Edad) Edad , g_tipoedad.`Nbre` TipoEdad,  DATE_FORMAT( l_recepcion.FechaRecep,'%d-%m-%Y'  ) AS FechaR,\n  profesional1.NProfesional,  profesional1.Especialidad,  l_recepcion.Id_Profesional,  `g_persona`.`Id` AS idPersona, g_sedes.Nbre AS Sede, i.FechaIngreso, l_resultados.FechaResult as fechaResultado\n  FROM \n  l_resultados \n  INNER JOIN l_recepcion   ON ( l_resultados.Id_Recepcion = l_recepcion.Id  )\n  inner join f_ordenes fo on (fo.Id =l_recepcion.Id_OrdenFacturac )\n  inner join ingreso i on (i.Id =fo.Id_Ingreso ) \n  INNER JOIN profesional1  ON ( profesional1.Id_Persona = l_recepcion.Id_Profesional  )AND ( profesional1.IdEspecialidad = l_recepcion.Id_Especialidad     )\n  INNER JOIN g_persona   ON (  g_persona.Id = l_recepcion.Id_Paciente    )\n  INNER JOIN `g_tipoedad` ON g_persona.`Id_TipoEdad`=g_tipoedad.`Id`\n  INNER JOIN g_sedes  ON (  g_sedes.Id = l_recepcion.Id_Sede )\n  WHERE (\n  l_resultados.Estado =0 AND " + datoFecha + " >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'  AND " + datoFecha + " <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' \n");
            if (this.JCHSede.isSelected() && this.JCBSede.getSelectedIndex() != -1) {
                sql.append("  AND `l_recepcion`.`Id_Sede` =" + this.xidSede[this.JCBSede.getSelectedIndex()] + " \n");
            }
            if (this.JCHMunicipio.isSelected() && this.JCBMunicipio.getSelectedIndex() != -1) {
                sql.append("  AND g_persona.Id_Municipio ='" + this.idMunicipio[this.JCBMunicipio.getSelectedIndex()] + "' \n");
            }
            if (this.JCH_AplicaFiltroConvenio.isSelected() && this.JCBConvenio.getSelectedIndex() != -1) {
                sql.append("  AND i.Id_EmpresaContxConv=" + this.listConvenio.get(this.JCBConvenio.getSelectedIndex()).getId() + " \n");
            }
            if (this.JCH_AplicaFiltroConvenio.isSelected() && this.JCBSubEmpresa.getSelectedIndex() != -1) {
                sql.append("  AND i.subEmpresa='" + this.JCBSubEmpresa.getSelectedItem().toString() + "' \n");
            }
            sql.append(" ) GROUP BY l_resultados.Id_Recepcion  ORDER BY l_resultados.Id_Recepcion");
        }
        System.out.println(sql);
        try {
            ResultSet xrs = this.xct.traerRs(sql.toString());
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelo.setValueAt(xrs.getString(5) + " " + xrs.getString(6), n, 4);
                            this.xmodelo.setValueAt(xrs.getString(7), n, 5);
                            this.xmodelo.setValueAt(xrs.getString(8), n, 6);
                            this.xmodelo.setValueAt(xrs.getString(9), n, 7);
                            this.xmodelo.setValueAt(true, n, 8);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(10)), n, 9);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), n, 10);
                            this.xmodelo.setValueAt(xrs.getString("Sede"), n, 11);
                            this.xmodelo.setValueAt(xrs.getString("FechaIngreso"), n, 12);
                            this.xmodelo.setValueAt(xrs.getString("fechaResultado"), n, 13);
                            n++;
                        }
                    }
                    this.xct.cerrarConexionBd();
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
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarReporteExamen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1() {
        mCrearModeloDatos1();
        StringBuilder sql = new StringBuilder();
        if (!this.JTFDesde.getText().isEmpty() && !this.JTFHasta.getText().isEmpty()) {
            sql.append("SELECT `l_recepcion`.`Id`, l_resultados.`FechaResult`, `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS`NUsuario`, `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `l_detallerecepcion`.`ValidadoLab`, IF(`l_detallerecepcion`.`Interpretacion` IS NULL,0,1) AS `Revisado`, l_resultados.Id, `g_persona`.`Id` AS IdPersona, `g_sedes`.`Nbre` AS Sede , i.FechaIngreso, l_resultados.FechaResult as fechaResultado  \n FROM  `l_detallerecepcion` \n INNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) \n inner join f_ordenes fo on (fo.Id =l_recepcion.Id_OrdenFacturac )\n  inner join ingreso i on (i.Id =fo.Id_Ingreso ) \n INNER JOIN `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) \n INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) \n INNER JOIN  `l_detalleresultado`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) \n INNER JOIN `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) \n INNER JOIN `g_persona` ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`) \n INNER JOIN `g_usuario` ON (`g_usuario`.`Id_persona`= `g_persona`.`Id`)\n INNER JOIN `g_sedes` on (`g_sedes`.`Id`= `l_recepcion`.`Id_Sede`) \n WHERE (l_resultados.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND l_resultados.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ' and `l_recepcion`.`Id` >=" + this.JTFDesde.getText() + " and `l_recepcion`.`Id` >=" + this.JTFHasta.getText() + " \n) GROUP BY `l_recepcion`.`Id`,  `g_procedimiento`.`Id`  ORDER BY l_resultados.Id_Recepcion ASC ");
        } else {
            sql.append("SELECT `l_recepcion`.`Id`, l_resultados.`FechaResult`, `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS`NUsuario`, `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, `l_detallerecepcion`.`ValidadoLab`, IF(`l_detallerecepcion`.`Interpretacion` IS NULL,0,1) AS `Revisado`, l_resultados.Id, `g_persona`.`Id` AS IdPersona, `g_sedes`.`Nbre` AS Sede  , i.FechaIngreso, l_resultados.FechaResult as fechaResultado \n FROM  `l_detallerecepcion` \n INNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) \n inner join f_ordenes fo on (fo.Id =l_recepcion.Id_OrdenFacturac )\n  inner join ingreso i on (i.Id =fo.Id_Ingreso ) \n INNER JOIN `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) \n INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) \n INNER JOIN  `l_detalleresultado`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) \n INNER JOIN `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) \n INNER JOIN `g_persona` ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`) \n INNER JOIN `g_usuario` ON (`g_usuario`.`Id_persona`= `g_persona`.`Id`)\n INNER JOIN `g_sedes` on (`g_sedes`.`Id`= `l_recepcion`.`Id_Sede`) \n WHERE (l_resultados.`FechaResult` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND l_resultados.`FechaResult` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' \n");
            if (this.JCHSede.isSelected() && this.JCBSede.getSelectedIndex() != -1) {
                sql.append("  AND `l_recepcion`.`Id_Sede` =" + this.xidSede[this.JCBSede.getSelectedIndex()] + " \n");
            }
            if (this.JCHMunicipio.isSelected() && this.JCBMunicipio.getSelectedIndex() != -1) {
                sql.append("  AND g_persona.Id_Municipio ='" + this.idMunicipio[this.JCBMunicipio.getSelectedIndex()] + "' \n");
            }
            if (this.JCH_AplicaFiltroConvenio.isSelected() && this.JCBConvenio.getSelectedIndex() != -1) {
                sql.append("  AND i.Id_EmpresaContxConv=" + this.listConvenio.get(this.JCBConvenio.getSelectedIndex()).getId() + " \n");
            }
            if (this.JCH_AplicaFiltroConvenio.isSelected() && this.JCBSubEmpresa.getSelectedIndex() != -1) {
                sql.append("  AND i.subEmpresa='" + this.JCBSubEmpresa.getSelectedItem().toString() + "' \n");
            }
            sql.append(" ) GROUP BY `l_recepcion`.`Id`,  `g_procedimiento`.`Id`  ORDER BY l_resultados.Id_Recepcion ASC");
        }
        System.out.println("detalle " + ((Object) sql));
        try {
            ResultSet xrs = this.xct.traerRs(sql.toString());
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n = 0;
                    while (xrs.next()) {
                        this.xmodelo1.addRow(this.xdatos);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                        this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                        this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                        this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                        this.xmodelo1.setValueAt(xrs.getString(6), n, 5);
                        this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                        this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                        this.xmodelo1.setValueAt(false, n, 9);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong("IdPersona")), n, 10);
                        this.xmodelo1.setValueAt(xrs.getString("Sede"), n, 11);
                        this.xmodelo1.setValueAt(xrs.getString("FechaIngreso"), n, 12);
                        this.xmodelo1.setValueAt(xrs.getString("fechaResultado"), n, 13);
                        n++;
                    }
                }
                this.xct.cerrarConexionBd();
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
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarReporteExamen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivos() {
        String adjunto;
        File f1;
        String x = this.xmt.formatoDMA.format(this.JDFechaF.getDate());
        File directorio = new File(this.JTFRuta.getText() + x.replaceAll("/", "-"));
        if (directorio.mkdir()) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (this.xmodelo.getValueAt(i, 8).toString().equals("true")) {
                    ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                    new File("");
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        impresion.mImprimirResultado(this.xmodelo.getValueAt(i, 0).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, this.xmodelo.getValueAt(i, 10).toString(), false);
                        adjunto = this.xmt.getRutaRep() + this.xmodelo.getValueAt(i, 1).toString() + "_" + this.xmodelo.getValueAt(i, 5).toString() + "_" + this.xmodelo.getValueAt(i, 0).toString() + ".pdf";
                        f1 = new File(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado.pdf");
                    } else {
                        impresion.mImprimirResultado(this.xmodelo.getValueAt(i, 0).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, this.xmodelo.getValueAt(i, 10).toString(), false);
                        adjunto = this.xmt.getRutaRep() + this.xmodelo.getValueAt(i, 1).toString() + "_" + this.xmodelo.getValueAt(i, 2).toString() + "_" + this.xmodelo.getValueAt(i, 5).toString() + "_" + this.xmodelo.getValueAt(i, 0).toString() + ".pdf";
                        f1 = new File(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado.pdf");
                    }
                    File f2 = new File(adjunto);
                    f1.renameTo(f2);
                    f2.renameTo(new File(directorio, f2.getName()));
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El directorio : " + directorio.getPath() + ";\nya se encuentra creado, favor eliminar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
