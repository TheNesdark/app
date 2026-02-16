package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Laboratorio.Imprimir;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.RecepcionStikerDAOImpl;
import com.genoma.plus.dao.laboratorio.RecepcionStikerDAO;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IEmpresaContratoConvenioDTO;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.genoma.plus.jpa.service.IFacturaElectronicaDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFGenerarReporteExamenCitologia.class */
public class JIFGenerarReporteExamenCitologia extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String[][] xidprofesionales;
    private String[] xidSede;
    private String[] xidSubEmpresa;
    private File xfile;

    /* JADX INFO: renamed from: listAños, reason: contains not printable characters */
    private List<String> f22listAos;
    private List<JCheckBox> checkBoxes;
    private List<String> listSedes;
    private List<ICargarCombo> comboGenerico;
    private final IEmpresaContConvenioService iEmpresaContConvenioService;
    public List<IEmpresaContratoConvenioDTO> listConvenio;
    private String[] xIdMunicipio;
    private RecepcionStikerDAO xRecepcionStikerDAO;
    private ButtonGroup JBGOpciones;
    private JButton JBTExportar;
    private JComboBox<String> JCBGenerico;
    private JComboBox JCBMunicipio;
    private JComboBox<String> JCBSubEmpresa;
    public JCheckBox JCH_AplicaFiltroConvenio;
    public JCheckBox JCH_AplicaFiltroMunicipio;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JRadioButton JRBQuitarSeleccion;
    private JRadioButton JRBSeleccionar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFDesde;
    private JTextField JTFFalseCombobox;
    private JTextField JTFHasta;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPopupMenu jPopupMenu1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String listSedesSeleccionadas = "";
    private String subEmpresa = "";
    private IFacturaElectronicaDAO xIFacturaElectronicaDAO = (IFacturaElectronicaDAO) Principal.contexto.getBean(IFacturaElectronicaDAO.class);

    public JIFGenerarReporteExamenCitologia() {
        initComponents();
        this.iEmpresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
        mNuevo();
        this.xRecepcionStikerDAO = (RecepcionStikerDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("recepcionStikerDAO");
    }

    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.jPopupMenu1 = new JPopupMenu();
        this.JPIDatos = new JPanel();
        this.JRBSeleccionar = new JRadioButton();
        this.JRBQuitarSeleccion = new JRadioButton();
        this.JTFFalseCombobox = new JTextField();
        this.JCH_AplicaFiltroConvenio = new JCheckBox();
        this.JCBGenerico = new JComboBox<>();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBMunicipio = new JComboBox();
        this.JCH_AplicaFiltroMunicipio = new JCheckBox();
        this.JCBSubEmpresa = new JComboBox<>();
        this.JTPDatos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jButton1 = new JButton();
        this.jPanel1 = new JPanel();
        this.JTFDesde = new JTextField();
        this.JTFHasta = new JTextField();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE RESULTADOS DE CITOLOGIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifgenerarreportecitologia");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBGOpciones.add(this.JRBSeleccionar);
        this.JRBSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JRBSeleccionar.setSelected(true);
        this.JRBSeleccionar.setText("Seleccionar Todo");
        this.JRBSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JRBSeleccionarActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBQuitarSeleccion);
        this.JRBQuitarSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRBQuitarSeleccion.setText("Quitar Selección");
        this.JRBQuitarSeleccion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JRBQuitarSeleccionActionPerformed(evt);
            }
        });
        this.JTFFalseCombobox.setEditable(false);
        this.JTFFalseCombobox.setFont(new Font("Arial", 1, 12));
        this.JTFFalseCombobox.setText("Seleccionar opciones...");
        this.JTFFalseCombobox.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFalseCombobox.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JTFFalseComboboxMouseClicked(evt);
            }

            public void mousePressed(MouseEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JTFFalseComboboxMousePressed(evt);
            }
        });
        this.JTFFalseCombobox.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.4
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JTFFalseComboboxActionPerformed(evt);
            }
        });
        this.JCH_AplicaFiltroConvenio.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaFiltroConvenio.setText("Filtrar?");
        this.JCH_AplicaFiltroConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.5
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JCH_AplicaFiltroConvenioActionPerformed(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.6
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JCBGenericoActionPerformed(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBMunicipio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.9
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JCBMunicipioActionPerformed(evt);
            }
        });
        this.JCH_AplicaFiltroMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaFiltroMunicipio.setText("Filtrar?");
        this.JCH_AplicaFiltroMunicipio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.10
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JCH_AplicaFiltroMunicipioActionPerformed(evt);
            }
        });
        this.JCBSubEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Sub Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 204)));
        this.JCBSubEmpresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.11
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JCBSubEmpresaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JTFFalseCombobox, -2, 273, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMunicipio, -2, 245, -2).addGap(12, 12, 12).addComponent(this.JCH_AplicaFiltroMunicipio).addGap(18, 18, 18).addComponent(this.JRBSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBQuitarSeleccion)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBGenerico, -2, 363, -2).addGap(18, 18, 18).addComponent(this.JCBSubEmpresa, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_AplicaFiltroConvenio))).addContainerGap(23, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSeleccionar).addComponent(this.JRBQuitarSeleccion).addComponent(this.JTFFalseCombobox, -2, -1, -2).addComponent(this.JCBMunicipio, -2, -1, -2).addComponent(this.JCH_AplicaFiltroMunicipio, -2, 43, -2))).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 55, -2).addComponent(this.JDFechaF, -2, 55, -2)))).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSubEmpresa, -2, 43, -2).addComponent(this.JCBGenerico, -2, 43, -2))).addGroup(JPIDatosLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.JCH_AplicaFiltroConvenio))).addContainerGap(16, 32767)));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.12
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("CONSOLIDADO POR RECEPCIÓN", this.JSPDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.13
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.14
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.15
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JBTExportarActionPerformed(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.jButton1.setText("Impresión masiva");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.16
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarReporteExamenCitologia.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar por rango de Recepciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JTFDesde.setFont(new Font("Arial", 1, 16));
        this.JTFDesde.setHorizontalAlignment(0);
        this.JTFDesde.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.17
            public void keyPressed(KeyEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JTFDesdeKeyPressed(evt);
            }
        });
        this.JTFHasta.setFont(new Font("Arial", 1, 16));
        this.JTFHasta.setHorizontalAlignment(0);
        this.JTFHasta.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.18
            public void keyPressed(KeyEvent evt) {
                JIFGenerarReporteExamenCitologia.this.JTFHastaKeyPressed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Desde");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Hasta");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDesde, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFHasta, -2, 104, -2).addContainerGap(18, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDesde, -2, -1, -2).addComponent(this.JTFHasta, -2, -1, -2).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGap(0, 4, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatos).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 353, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 191, -2).addGap(18, 18, 18).addComponent(this.jButton1, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18)))).addComponent(this.JPIDatos, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTPDatos, -2, 403, -2).addGap(36, 36, 36).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 52, -2).addComponent(this.JBTExportar, -2, 52, -2))).addComponent(this.jPanel1, -2, -1, -2)).addContainerGap(35, 32767)));
        getAccessibleContext().setAccessibleName("GENERACIÓN DE RESULTADOS POR FECHA");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() == -1 || this.JTDetalle.getSelectedColumn() == 0) {
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
        if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 0)) {
            mCrearArchivos();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar recepcioón a generar ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
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
    public void jButton1ActionPerformed(ActionEvent evt) {
        PresentacionImpresora();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFalseComboboxMouseClicked(MouseEvent evt) {
        togglePopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFalseComboboxMousePressed(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFalseComboboxActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AplicaFiltroConvenioActionPerformed(ActionEvent evt) {
        getConvenios();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenericoActionPerformed(ActionEvent evt) {
        if (this.listConvenio.get(this.JCBGenerico.getSelectedIndex()).getId() != null) {
            this.JCBSubEmpresa.removeAllItems();
            String sql = "select ec.id, ec.nombre from f_empresacontxconvenio_mision ec WHERE ec.idEmpresaConvenio = '" + this.listConvenio.get(this.JCBGenerico.getSelectedIndex()).getId() + "'";
            this.xidSubEmpresa = this.xct.llenarCombo(sql, this.xidSubEmpresa, this.JCBSubEmpresa);
            this.JCBSubEmpresa.setSelectedIndex(-1);
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
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        mCargarComboSede();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        mCargarComboSede();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMunicipioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AplicaFiltroMunicipioActionPerformed(ActionEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubEmpresaActionPerformed(ActionEvent evt) {
        this.subEmpresa = (String) this.JCBSubEmpresa.getSelectedItem();
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.xct.cerrarConexionBd();
        mCrearModeloDatos();
        mCargarComboSede();
        this.JTFDesde.setText("");
        this.JTFHasta.setText("");
    }

    private void togglePopup() {
        if (this.jPopupMenu1.isVisible()) {
            this.jPopupMenu1.setVisible(false);
        } else {
            showPopup();
        }
    }

    private void showPopup() {
        Point location = this.JTFFalseCombobox.getLocationOnScreen();
        this.jPopupMenu1.setLocation(location.x, location.y + this.JTFFalseCombobox.getHeight());
        this.jPopupMenu1.setVisible(true);
    }

    public void mCargarCombo() {
        this.JCBMunicipio.removeAllItems();
        List<Object[]> list = this.xRecepcionStikerDAO.ListMunicipiosRecepcionMunicipio(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
        this.xIdMunicipio = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xIdMunicipio[x] = list.get(x)[0].toString();
            this.JCBMunicipio.addItem(list.get(x)[1].toString());
        }
    }

    private void mCargarComboSede() {
        try {
            this.jPopupMenu1.removeAll();
            this.checkBoxes = new ArrayList();
            this.listSedes = new ArrayList();
            ResultSet xrs = this.xct.traerRs("SELECT\n\tgs.Id,\n\tconcat(gs.Nbre,' (',gm.Nbre,')') as sede\nFROM\n\tl_detallerecepcion ld\nINNER JOIN l_recepcion lr on\n\t(ld.Id_Recepcion = lr.Id)\nINNER JOIN g_sedes gs on\n\t(lr.Id_Sede = gs.Id)\nINNER JOIN g_procedimiento gp ON\n\t(ld.Id_Procedim = gp.Id)\nINNER JOIN g_municipio gm  ON\n\t(gs.Id_Municipio = gm.Id )\nWHERE\n\t(lr.Estado = 0)\nGROUP BY gs.Id\nORDER BY gs.Nbre ASC");
            Throwable th = null;
            try {
                try {
                    mCrearModeloDatos();
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            this.listSedes.add(xrs.getString(1));
                            JCheckBox checkBox = new JCheckBox(xrs.getString(2));
                            checkBox.addItemListener(e -> {
                                updateTextField();
                            });
                            this.checkBoxes.add(checkBox);
                            this.jPopupMenu1.add(checkBox);
                        }
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
                    updateTextField();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void updateTextField() {
        List<String> seleccionados = new ArrayList<>();
        StringBuilder idSedes = new StringBuilder();
        for (int x = 0; x < this.checkBoxes.size(); x++) {
            if (this.checkBoxes.get(x).isSelected()) {
                seleccionados.add(this.checkBoxes.get(x).getText());
                idSedes.append(",").append(this.listSedes.get(x));
            }
        }
        this.listSedesSeleccionadas = idSedes.length() > 0 ? idSedes.substring(1) : "";
        this.JTFFalseCombobox.setText(seleccionados.isEmpty() ? "Seleccionar opciones..." : "Sedes Seleccionadas (" + seleccionados.size() + ")");
    }

    public void mImprimir() {
        if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString().equals("true")) {
            ImpresionReporteCitologiaBethesda bethesda = new ImpresionReporteCitologiaBethesda();
            bethesda.generarReporte(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString()), 1);
        } else {
            ImpresionReporteCitologiaBethesda bethesda2 = new ImpresionReporteCitologiaBethesda();
            bethesda2.generarReporte(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString()), 1);
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
                    this.xmodelo.setValueAt(true, x, 0);
                } else if (this.JRBQuitarSeleccion.isSelected()) {
                    this.xmodelo.setValueAt(false, x, 0);
                }
            }
        }
    }

    private void getConvenios() {
        this.JCBGenerico.setModel(new DefaultComboBoxModel());
        this.listConvenio = new ArrayList();
        this.listConvenio = this.iEmpresaContConvenioService.getListEmpresaConvenio(new Long(0L));
        this.JCBGenerico.removeAllItems();
        this.listConvenio.forEach(e -> {
            this.JCBGenerico.addItem(e.getEmpresaContratante());
        });
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Generar?", "Id", "NHC", "Usuario", "Sexo", "Edad", "Fecha", "NProfesional", "Especialidad", "", "IdPersona", "Sede", "Municipio", "Convenio", "idRecepcion", "idCitologia", "liquida"}) { // from class: com.genoma.plus.controller.laboratorio.JIFGenerarReporteExamenCitologia.19
            Class[] types = {Boolean.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class, String.class, String.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(300);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
    }

    /* JADX WARN: Finally extract failed */
    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            StringBuilder sql = new StringBuilder();
            String[] sedesArray = this.listSedesSeleccionadas.split(",");
            String sedesList = String.join(",", sedesArray);
            if (!this.JTFDesde.getText().isEmpty() && !this.JTFHasta.getText().isEmpty()) {
                sql.append(" SELECT\n\tl_recepcion_citologia.Id_Recepcion,\n\tg_persona.NoDocumento,\n\tCONCAT( g_persona.Apellido1, ' ', g_persona.Apellido2, ' ',g_persona.Nombre1, ' ', g_persona.Nombre2) AS nombre ,\n\tg_persona.Id_Sexo,\n\tIF(g_persona.Edad = 0,\n\t1 ,\n\tEdad) Edad ,\n\tg_tipoedad.`Nbre` TipoEdad,\n\tDATE_FORMAT( l_recepcion.FechaRecep, '%d-%m-%Y' ) AS FechaR,\n\tprofesional1.NProfesional,\n\tprofesional1.Especialidad,\n\tl_recepcion.Id_Profesional,\n\t`g_persona`.`Id` AS idPersona,\n\tg_sedes.Nbre AS Sede,\n\tl_recepcion_citologia.Id_Consecutivo, \n\tpc.Id idCitologia,\n    CASE\n        WHEN EXISTS (\n            SELECT 1\n            FROM l_detallerecepcion ld\n            WHERE ld.Id_Recepcion = l_recepcion.Id\n              AND ld.Id_Procedim = '898002'\n        ) THEN true\n        ELSE false\n    END AS liquida,\n    gm.Nbre as municipio,\n    fe.Nbre as convenio\nFROM\n\tl_recepcion_citologia  \nINNER JOIN l_recepcion ON\n\t( l_recepcion_citologia.Id_Recepcion = l_recepcion.Id )\nINNER JOIN profesional1 ON\n\t( profesional1.Id_Persona = l_recepcion.Id_Profesional )\n\tAND ( profesional1.IdEspecialidad = l_recepcion.Id_Especialidad )\nINNER JOIN g_persona ON\n\t( g_persona.Id = l_recepcion.Id_Paciente )\nINNER JOIN `g_tipoedad` ON\n\tg_persona.`Id_TipoEdad` = g_tipoedad.`Id`\nINNER JOIN g_sedes ON\n\t( g_sedes.Id = l_recepcion.Id_Sede )\nINNER JOIN p_citologia pc ON pc.Id_Recepcion = l_recepcion.Id\nINNER JOIN g_municipio gm on gm.Id  = g_sedes.Id_Municipio\nINNER JOIN f_empresacontxconvenio fe on fe.Id = l_recepcion.Id_EmpresaConv\n   WHERE(l_recepcion_citologia.Id_Consecutivo  BETWEEN " + this.JTFDesde.getText() + " and " + this.JTFHasta.getText() + " and l_recepcion.Id_Sede in (" + sedesList + ") )\nGROUP BY\n\tl_recepcion_citologia.Id_Recepcion\nORDER BY\n\tl_recepcion_citologia.Id_Consecutivo");
            } else {
                sql.append("SELECT\n    l_recepcion_citologia.Id_Recepcion,\n    g_persona.NoDocumento,\n    CONCAT( g_persona.Apellido1, ' ', g_persona.Apellido2, ' ',g_persona.Nombre1, ' ', g_persona.Nombre2) AS nombre,\n    g_persona.Id_Sexo,\n    IF(g_persona.Edad = 0, 1, Edad) AS Edad,\n    g_tipoedad.Nbre AS TipoEdad,\n    DATE_FORMAT(l_recepcion.FechaRecep, '%d-%m-%Y') AS FechaR,\n    profesional1.NProfesional,\n    profesional1.Especialidad,\n    l_recepcion.Id_Profesional,\n    g_persona.Id AS idPersona,\n    g_sedes.Nbre AS Sede,\n    l_recepcion_citologia.Id_Consecutivo,\n    pc.Id AS idCitologia,\n    CASE\n        WHEN EXISTS (\n            SELECT 1\n            FROM l_detallerecepcion ld\n            WHERE ld.Id_Recepcion = l_recepcion.Id\n              AND ld.Id_Procedim = '898002'\n        ) THEN true\n        ELSE false\n    END AS liquida,\n    gm.Nbre as municipio,\n    fe.Nbre as convenio\nFROM\n    l_recepcion_citologia\nINNER JOIN l_recepcion ON l_recepcion_citologia.Id_Recepcion = l_recepcion.Id\nINNER JOIN profesional1 ON profesional1.Id_Persona = l_recepcion.Id_Profesional\nAND profesional1.IdEspecialidad = l_recepcion.Id_Especialidad\nINNER JOIN g_persona ON g_persona.Id = l_recepcion.Id_Paciente\nINNER JOIN g_tipoedad ON g_persona.Id_TipoEdad = g_tipoedad.Id\nINNER JOIN g_sedes ON g_sedes.Id = l_recepcion.Id_Sede\nINNER JOIN p_citologia pc ON pc.Id_Recepcion = l_recepcion.Id\nINNER JOIN g_municipio gm on gm.Id  = g_sedes.Id_Municipio\nINNER JOIN f_empresacontxconvenio fe on fe.Id = l_recepcion.Id_EmpresaConv\nINNER JOIN f_ordenes fo on fo.Id  = l_recepcion.Id_OrdenFacturac \nINNER JOIN ingreso i on i.Id = fo.Id_Ingreso\nINNER  JOIN p_citologia_resultados pcr on pcr.Id = pc.Id\nWHERE (pcr.FechaR >= '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' and pcr.FechaR <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' and l_recepcion.Id_Sede in (" + sedesList + ")\n");
                if (this.JCH_AplicaFiltroConvenio.isSelected()) {
                    sql.append("AND i.subEmpresa =  '" + this.subEmpresa + "'\n");
                }
                if (this.JCH_AplicaFiltroMunicipio.isSelected()) {
                    sql.append("AND g_sedes.Id_Municipio =  " + this.xIdMunicipio[this.JCBMunicipio.getSelectedIndex()] + "\n");
                }
                sql.append(")\nGROUP BY l_recepcion_citologia.Id_Recepcion\nORDER BY l_recepcion_citologia.Id_Consecutivo;");
            }
            System.out.println("valor sql >>>" + ((Object) sql));
            ResultSet xrs = this.xct.traerRs(sql.toString());
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n = 0;
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdatos);
                        this.xmodelo.setValueAt(true, n, 0);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(13)), n, 1);
                        this.xmodelo.setValueAt(xrs.getString(2), n, 2);
                        this.xmodelo.setValueAt(xrs.getString(3), n, 3);
                        this.xmodelo.setValueAt(xrs.getString(4), n, 4);
                        this.xmodelo.setValueAt(xrs.getString(5) + " " + xrs.getString(6), n, 5);
                        this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                        this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                        this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(10)), n, 9);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), n, 10);
                        this.xmodelo.setValueAt(xrs.getString("Sede"), n, 11);
                        this.xmodelo.setValueAt(xrs.getString(16), n, 12);
                        this.xmodelo.setValueAt(xrs.getString(17), n, 13);
                        this.xmodelo.setValueAt(xrs.getString(1), n, 14);
                        this.xmodelo.setValueAt(xrs.getString(14), n, 15);
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(15)), n, 16);
                        n++;
                    }
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
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarReporteExamenCitologia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivos() {
        ImpresionReporteCitologiaBethesda bethesda = new ImpresionReporteCitologiaBethesda();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateFolderName = currentDate.format(formatter);
        Path destinationFolder = Paths.get(this.JTFRuta.getText(), dateFolderName);
        try {
            Files.createDirectories(destinationFolder, new FileAttribute[0]);
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (this.xmodelo.getValueAt(i, 0).toString().equals("true")) {
                    if (this.xmodelo.getValueAt(i, 16).toString().equals("false")) {
                        System.out.println("entra a normal");
                        bethesda.generarReporte(Long.valueOf(this.xmodelo.getValueAt(i, 15).toString()), 2);
                        String nombreFile = this.xmodelo.getValueAt(i, 1).toString() + "_" + this.xmodelo.getValueAt(i, 2).toString() + "_" + this.xmodelo.getValueAt(i, 3).toString() + "_" + this.xmodelo.getValueAt(i, 6).toString() + ".pdf";
                        Path sourcePath = Paths.get(this.xmt.getRutaRep() + nombreFile, new String[0]);
                        Path destinationPath = destinationFolder.resolve(nombreFile);
                        try {
                            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.err.println("Error al mover el archivo: " + e.getMessage());
                        }
                    } else {
                        bethesda.generarReporte(Long.valueOf(this.xmodelo.getValueAt(i, 15).toString()), 2);
                        Path sourcePath2 = Paths.get(this.xmt.getRutaRep() + "H_CitologiaLiquida.pdf", new String[0]);
                        Path destinationPath2 = destinationFolder.resolve(this.xmodelo.getValueAt(i, 1).toString() + "_" + this.xmodelo.getValueAt(i, 2).toString() + "_" + this.xmodelo.getValueAt(i, 3).toString() + "_" + this.xmodelo.getValueAt(i, 6).toString() + ".pdf");
                        try {
                            Files.move(sourcePath2, destinationPath2, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            System.err.println("Error al mover el archivo citologia liquida: " + e2.getMessage());
                        }
                    }
                }
            }
        } catch (IOException e3) {
            System.err.println("Error al crear la carpeta de destino: " + e3.getMessage());
        }
    }

    public void PresentacionImpresora() {
        ImpresionReporteCitologiaBethesda bethesda = new ImpresionReporteCitologiaBethesda();
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (this.xmodelo.getValueAt(i, 0).toString().equals("true")) {
                if (this.xmodelo.getValueAt(i, 16).toString().equals("false")) {
                    bethesda.generarReporte(Long.valueOf(this.xmodelo.getValueAt(i, 15).toString()), 3);
                } else {
                    bethesda.generarReporte(Long.valueOf(this.xmodelo.getValueAt(i, 15).toString()), 3);
                }
            }
        }
    }
}
