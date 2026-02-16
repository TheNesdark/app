package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.jpa.projection.IGenericComboTresValores;
import com.genoma.plus.jpa.projection.IResultadosConsolidados;
import com.genoma.plus.jpa.projection.IResultadosRecepcion;
import com.genoma.plus.jpa.service.RecepcionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFExportacionPDFExamen.class */
public class JIFExportacionPDFExamen extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String[][] xidprofesionales;
    private String[] xidSede;
    private File xfile;
    private IGenericComboTresValores comboValores;
    List<IGenericComboTresValores> listacomboSede;
    List<IGenericComboTresValores> listacomboEmppresa;
    List<IGenericComboTresValores> listacomboConvenio;
    List<IResultadosConsolidados> listaResultadosConsolidado;
    List<IResultadosRecepcion> listaResultados;
    private ButtonGroup JBGOpciones;
    private JButton JBTExportar;
    private JComboBox<String> JCBEmpresa;
    private static JComboBox<String> JCBSede1;
    private JCheckBox JCHConvenio1;
    private JCheckBox JCHEmpresaConvenio;
    private JCheckBox JCHFiltroPlantillaPdf;
    private JCheckBox JCHSede;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private ButtonGroup JGPFiltroxConvenio;
    private JPanel JPIDatos;
    private JPanel JPIDetalleE;
    private JRadioButton JRBQuitarSeleccion;
    private JRadioButton JRBSeleccionar;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTextField JTFProcedimiento;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JPanel jPanel1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private final RecepcionService recepcionService = (RecepcionService) Principal.contexto.getBean(RecepcionService.class);
    HashSet hs = new HashSet();
    ArrayList array = new ArrayList();

    public JIFExportacionPDFExamen() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JGPFiltroxConvenio = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox<>();
        this.JCHSede = new JCheckBox();
        JCBSede1 = new JComboBox<>();
        this.JTFProcedimiento = new JTextField();
        this.JCHEmpresaConvenio = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.JRBSeleccionar = new JRadioButton();
        this.JRBQuitarSeleccion = new JRadioButton();
        this.JCHConvenio1 = new JCheckBox();
        this.JTPDatos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDetalleE = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCHFiltroPlantillaPdf = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE RESULTADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifgenerarreportePDF");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFExportacionPDFExamen.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.2
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionPDFExamen.this.JDFechaFMouseClicked(evt);
            }
        });
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFExportacionPDFExamen.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa o Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHSede.setFont(new Font("Arial", 1, 12));
        this.JCHSede.setSelected(true);
        this.JCHSede.setText("Filtrar por Sede?");
        this.JCHSede.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.4
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionPDFExamen.this.JCHSedeActionPerformed(evt);
            }
        });
        JCBSede1.setFont(new Font("Arial", 1, 12));
        JCBSede1.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFProcedimiento.setFont(new Font("Arial", 1, 13));
        this.JTFProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFProcedimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.5
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionPDFExamen.this.JTFProcedimientoActionPerformed(evt);
            }
        });
        this.JGPFiltroxConvenio.add(this.JCHEmpresaConvenio);
        this.JCHEmpresaConvenio.setFont(new Font("Arial", 1, 12));
        this.JCHEmpresaConvenio.setSelected(true);
        this.JCHEmpresaConvenio.setText("Filtrar por empresa?");
        this.JCHEmpresaConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.6
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionPDFExamen.this.JCHEmpresaConvenioActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.JBGOpciones.add(this.JRBSeleccionar);
        this.JRBSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JRBSeleccionar.setSelected(true);
        this.JRBSeleccionar.setText("Seleccionar Todo");
        this.JRBSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.7
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionPDFExamen.this.JRBSeleccionarActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBQuitarSeleccion);
        this.JRBQuitarSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRBQuitarSeleccion.setText("Quitar Selección");
        this.JRBQuitarSeleccion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.8
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionPDFExamen.this.JRBQuitarSeleccionActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBQuitarSeleccion).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(17, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSeleccionar).addComponent(this.JRBQuitarSeleccion)).addContainerGap()));
        this.JGPFiltroxConvenio.add(this.JCHConvenio1);
        this.JCHConvenio1.setFont(new Font("Arial", 1, 12));
        this.JCHConvenio1.setText("Filtrar por convenio?");
        this.JCHConvenio1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.9
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionPDFExamen.this.JCHConvenio1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 107, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 113, -2).addGap(10, 10, 10).addComponent(JCBSede1, -2, 300, -2)).addComponent(this.JCBEmpresa, -2, 546, -2)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEmpresaConvenio).addComponent(this.JCHConvenio1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFProcedimiento)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHSede).addGap(32, 32, 32).addComponent(this.jPanel1, -2, -1, -2))).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(JCBSede1, -2, 50, -2).addComponent(this.JCHSede)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)))).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2))).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(24, 24, 24).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa).addComponent(this.JTFProcedimiento, -2, 52, -2)).addGap(34, 34, 34)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.JCHEmpresaConvenio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHConvenio1).addContainerGap(-1, 32767)))));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.10
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionPDFExamen.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("CONSOLIDADO POR RECEPCIÓN", this.JSPDetalle);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "PROCEDIMIENTO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.11
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionPDFExamen.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        GroupLayout JPIDetalleELayout = new GroupLayout(this.JPIDetalleE);
        this.JPIDetalleE.setLayout(JPIDetalleELayout);
        JPIDetalleELayout.setHorizontalGroup(JPIDetalleELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleELayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -2, 1013, -2).addContainerGap(-1, 32767)));
        JPIDetalleELayout.setVerticalGroup(JPIDetalleELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleELayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -2, 236, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("DETALLADO POR EXAMEN", this.JPIDetalleE);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.12
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionPDFExamen.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.13
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionPDFExamen.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Generar PDF");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.14
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionPDFExamen.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHFiltroPlantillaPdf.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroPlantillaPdf.setText("Filtro plantilla pdf?");
        this.JCHFiltroPlantillaPdf.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.15
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionPDFExamen.this.JCHFiltroPlantillaPdfActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 191, -2).addGap(280, 280, 280).addComponent(this.JCHFiltroPlantillaPdf)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTPDatos, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap(30, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, 177, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 321, -2).addGap(27, 27, 27).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JCHFiltroPlantillaPdf))).addGap(27, 27, 27)));
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
        if (this.JTPDatos.getSelectedIndex() == 1) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle1, 9)) {
                mGenerarArchivos();
            }
        } else if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 8)) {
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
            JCBSede1.setEnabled(true);
        } else {
            JCBSede1.setEnabled(false);
        }
        JCBSede1.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFProcedimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmpresaConvenioActionPerformed(ActionEvent evt) {
        if (this.JDFechaI.getDate() != null && this.JDFechaF.getDate() != null && this.JCHEmpresaConvenio.isSelected()) {
            this.JCBEmpresa.setEnabled(true);
            llenarCombo();
        }
        this.JCBEmpresa.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.JDFechaI.getDate() != null && this.JDFechaF.getDate() != null) {
            llenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.JDFechaI.getDate() != null && this.JDFechaF.getDate() != null) {
            llenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHConvenio1ActionPerformed(ActionEvent evt) {
        if (this.JCHConvenio1.isSelected() && this.JDFechaI.getDate() != null && this.JDFechaF.getDate() != null) {
            llenarCombo();
        }
        this.JCBEmpresa.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroPlantillaPdfActionPerformed(ActionEvent evt) {
    }

    public void mBuscar() {
        mCargarDatosTabla();
        mCargarDatosTabla1();
    }

    public void llenarCombo() {
        JCBSede1.removeAllItems();
        this.listacomboSede = new ArrayList();
        this.JCBEmpresa.removeAllItems();
        this.listacomboEmppresa = new ArrayList();
        this.listacomboSede = this.recepcionService.listaSedeRecepcionIntervaloFechaOrderByNombre(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        if (!this.listacomboSede.isEmpty()) {
            this.listacomboSede.forEach(item -> {
                JCBSede1.addItem(item.getNombre());
            });
        }
        if (this.JCHEmpresaConvenio.isSelected()) {
            this.listacomboEmppresa = this.recepcionService.listaEmpresaRecepcionIntervaloFechaOrderByNombre(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            if (!this.listacomboEmppresa.isEmpty()) {
                this.listacomboEmppresa.forEach(item2 -> {
                    this.JCBEmpresa.addItem(item2.getNombre());
                });
                return;
            }
            return;
        }
        if (this.JCHConvenio1.isSelected()) {
            this.listacomboEmppresa = this.recepcionService.listarConveniosRecepcionIntervaloFechaOrderByNombre(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            if (!this.listacomboEmppresa.isEmpty()) {
                this.listacomboEmppresa.forEach(item3 -> {
                    this.JCBEmpresa.addItem(item3.getNombre());
                });
            }
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.JCBEmpresa.removeAllItems();
        JCBSede1.removeAllItems();
        llenarCombo();
        this.JCBEmpresa.setSelectedIndex(-1);
        JCBSede1.setSelectedIndex(-1);
        mCrearModeloDatos();
        mCrearModeloDatos1();
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

    private void mCrearVistaAjustes(String xsql) {
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS l_v_tmp_planilla  ");
        this.xct.cerrarConexionBd();
        System.out.println("vista " + xsql);
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
        if (this.JTDetalle1.getRowCount() != -1) {
            for (int x2 = 0; x2 < this.JTDetalle1.getRowCount(); x2++) {
                if (this.JRBSeleccionar.isSelected()) {
                    this.xmodelo1.setValueAt(true, x2, 9);
                } else if (this.JRBQuitarSeleccion.isSelected()) {
                    this.xmodelo1.setValueAt(false, x2, 9);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "NHC", "Usuario", "Sexo", "Edad", "Fecha", "NProfesional", "Especialidad", "Generar?", "", "IdPersona", "Sede", "Nombre Convenio", "NombrePdf"}) { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.16
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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "NHC", "Usuario", "IdP", "Procedimiento", "Validado?", "Revisado?", "IdResultado", "Generar?", "IdPersona", "Sede", "Nombre Convenio"}) { // from class: com.genoma.plus.controller.laboratorio.JIFExportacionPDFExamen.17
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, String.class, Boolean.class, Boolean.class, Long.class, Boolean.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, false, false, false};

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
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(400);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(11).setMaxWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(12).setMaxWidth(400);
    }

    private void mCargarDatosTabla() {
        Boolean filtro;
        mCrearModeloDatos1();
        List<Integer> idSede = new ArrayList<>();
        this.listaResultados = new ArrayList();
        if (this.JCHSede.isSelected()) {
            idSede.add(this.listacomboSede.get(JCBSede1.getSelectedIndex()).getId());
        } else {
            this.listacomboSede.forEach(item -> {
                idSede.add(item.getId());
            });
        }
        Integer idEmpresa = this.listacomboEmppresa.get(this.JCBEmpresa.getSelectedIndex()).getId();
        if (this.JCHEmpresaConvenio.isSelected()) {
            filtro = true;
        } else {
            filtro = false;
        }
        this.listaResultados = this.recepcionService.listarRegistrosRecepcion(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), idSede, idEmpresa, this.JTFProcedimiento.getText(), filtro);
        if (!this.listaResultados.isEmpty()) {
            this.listaResultados.forEach(item2 -> {
                this.xmodelo1.addRow(this.xdatos);
                this.xmodelo1.setValueAt(item2.getIdRecepcion(), this.JTDetalle1.getRowCount() - 1, 0);
                this.xmodelo1.setValueAt(item2.getFechaResultado(), this.JTDetalle1.getRowCount() - 1, 1);
                this.xmodelo1.setValueAt(item2.getNumeroDocumento(), this.JTDetalle1.getRowCount() - 1, 2);
                this.xmodelo1.setValueAt(item2.getNombreUsuario(), this.JTDetalle1.getRowCount() - 1, 3);
                this.xmodelo1.setValueAt(item2.getIdProcedimiento(), this.JTDetalle1.getRowCount() - 1, 4);
                this.xmodelo1.setValueAt(item2.getNombreProcedimiento(), this.JTDetalle1.getRowCount() - 1, 5);
                this.xmodelo1.setValueAt(item2.getEsValidado(), this.JTDetalle1.getRowCount() - 1, 6);
                this.xmodelo1.setValueAt(item2.getRevisado(), this.JTDetalle1.getRowCount() - 1, 7);
                this.xmodelo1.setValueAt(item2.getIdResultado(), this.JTDetalle1.getRowCount() - 1, 8);
                this.xmodelo1.setValueAt(false, this.JTDetalle1.getRowCount() - 1, 9);
                this.xmodelo1.setValueAt(item2.getIdPersona(), this.JTDetalle1.getRowCount() - 1, 10);
                this.xmodelo1.setValueAt(item2.getNombreSede(), this.JTDetalle1.getRowCount() - 1, 11);
                this.xmodelo1.setValueAt(item2.getConvenio(), this.JTDetalle1.getRowCount() - 1, 12);
            });
        }
    }

    private void mCargarDatosTabla1() {
        Boolean filtro;
        mCrearModeloDatos();
        List<Integer> idSede = new ArrayList<>();
        if (this.JCHSede.isSelected()) {
            idSede.add(this.listacomboSede.get(JCBSede1.getSelectedIndex()).getId());
        } else {
            this.listacomboSede.forEach(item -> {
                idSede.add(item.getId());
            });
        }
        Integer idEmpresaP = this.listacomboEmppresa.get(this.JCBEmpresa.getSelectedIndex()).getId();
        if (this.JCHEmpresaConvenio.isSelected()) {
            filtro = true;
        } else {
            filtro = false;
        }
        this.listaResultadosConsolidado = this.recepcionService.listarRegistrosTablaConsolidado(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), idSede, idEmpresaP, filtro, Boolean.valueOf(this.JCHFiltroPlantillaPdf.isSelected()));
        if (!idSede.isEmpty()) {
            this.listaResultadosConsolidado.forEach(item2 -> {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(item2.getIdRecepcion(), this.JTDetalle.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(item2.getNoHistoria(), this.JTDetalle.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(item2.getNusuario(), this.JTDetalle.getRowCount() - 1, 2);
                this.xmodelo.setValueAt(item2.getIdSexo(), this.JTDetalle.getRowCount() - 1, 3);
                this.xmodelo.setValueAt(item2.getEdad() + " " + item2.getNtipoEdad(), this.JTDetalle.getRowCount() - 1, 4);
                this.xmodelo.setValueAt(item2.getFechaR(), this.JTDetalle.getRowCount() - 1, 5);
                this.xmodelo.setValueAt(item2.getNprofesional(), this.JTDetalle.getRowCount() - 1, 6);
                this.xmodelo.setValueAt(item2.getEspecialidad(), this.JTDetalle.getRowCount() - 1, 7);
                this.xmodelo.setValueAt(true, this.JTDetalle.getRowCount() - 1, 8);
                this.xmodelo.setValueAt(item2.getIdProfesional(), this.JTDetalle.getRowCount() - 1, 9);
                this.xmodelo.setValueAt(item2.getIdPersona(), this.JTDetalle.getRowCount() - 1, 10);
                this.xmodelo.setValueAt(item2.getSede(), this.JTDetalle.getRowCount() - 1, 11);
                this.xmodelo.setValueAt(item2.getConvenio(), this.JTDetalle.getRowCount() - 1, 12);
                this.xmodelo.setValueAt(item2.getNombrePdf(), this.JTDetalle.getRowCount() - 1, 13);
            });
        }
    }

    private void mGenerarArchivos() {
        this.hs.clear();
        this.array.clear();
        String x = this.xmt.formatoDMA.format(this.JDFechaF.getDate());
        File directorio = new File(this.JTFRuta.getText() + x.replaceAll("/", "-"));
        if (directorio.mkdir()) {
            for (int i = 0; i < this.JTDetalle1.getRowCount(); i++) {
                if (this.xmodelo1.getValueAt(i, 9).toString().equals("true")) {
                    this.hs.add(this.xmodelo1.getValueAt(i, 0).toString());
                }
            }
            this.array.addAll(this.hs);
            for (int m = 0; m < this.array.size(); m++) {
                String codigoP = "";
                String fechaResulado = "";
                String numeroHistoria = "";
                String nombreUsuario = "";
                String idPersona = "";
                for (int n = 0; n < this.JTDetalle1.getRowCount(); n++) {
                    if (this.xmodelo1.getValueAt(n, 9).toString().equals("true") && this.xmodelo1.getValueAt(n, 0).toString().equals(this.array.get(m))) {
                        codigoP = codigoP + this.xmodelo1.getValueAt(n, 4).toString() + ",";
                        fechaResulado = this.xmodelo1.getValueAt(n, 1).toString();
                        numeroHistoria = this.xmodelo1.getValueAt(n, 2).toString();
                        nombreUsuario = this.xmodelo1.getValueAt(n, 3).toString();
                        idPersona = this.xmodelo1.getValueAt(n, 10).toString();
                    }
                }
                ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                impresion.mImprimirResultado(this.array.get(m).toString(), codigoP.substring(0, codigoP.length() - 1), this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, idPersona, false);
                String adjunto = this.xmt.getRutaRep() + numeroHistoria + "_" + nombreUsuario + "_" + fechaResulado + "_" + this.array.get(m).toString() + ".pdf";
                File f1 = new File(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado.pdf");
                File f2 = new File(adjunto);
                f1.renameTo(f2);
                f2.renameTo(new File(directorio, f2.getName()));
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El directorio : " + directorio.getPath() + ";\nya se encuentra creado, favor eliminar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
                    if (this.JCHFiltroPlantillaPdf.isSelected()) {
                        String nombrePdf = this.xmodelo.getValueAt(i, 13).toString();
                        adjunto = nombrePdf + ".pdf";
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
