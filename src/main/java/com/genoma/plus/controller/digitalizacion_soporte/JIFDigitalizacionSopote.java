package com.genoma.plus.controller.digitalizacion_soporte;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import ParametrizacionN.AutoCompletarComboBox;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dto.soporte_digitalizado.ImpresionReportesDTO;
import com.genoma.plus.jpa.entities.SoporteCarpetasDTO;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IDigitalizacionSoporte;
import com.genoma.plus.jpa.projection.ISoporteCarpetasArchivos;
import com.genoma.plus.jpa.service.IDigitalizacionSoporteDAO;
import com.genoma.plus.jpa.service.ISoporteCarpetasArchivosDAO;
import com.genoma.plus.jpa.service.ISoporteCarpetasDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/digitalizacion_soporte/JIFDigitalizacionSopote.class */
public class JIFDigitalizacionSopote extends JInternalFrame {
    private List<IDigitalizacionSoporte> listaUsuarios;
    private List<SoporteCarpetasDTO> listarCarpetas;
    private List<ISoporteCarpetasArchivos> listarArchivosCarpeta;
    private List<ICargarCombo> listarconvenios;
    private List<ICargarCombo> listarCuentaCobro;
    private Object[] xdatos;
    private DefaultTableModel xmodelo;
    private WorkerSQL xWorkerSQL;
    private ButtonGroup BGFiltro;
    private ButtonGroup BGGeneracionAdjuntos;
    private ButtonGroup BGTipoExportado;
    private JButton JBTExportar;
    private JComboBox<String> JCBConvenio;
    private JComboBox<String> JCBCuentaCobro;
    private JCheckBox JCHAdjuntosDian;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPAdjuntoDian;
    private JPanel JPGeneracion;
    private JRadioButton JRBAdjuntoDian;
    private JRadioButton JRBConvenios;
    private JRadioButton JRBCuentaCobro;
    private JRadioButton JRBGenerar;
    private JRadioButton JRBNoFactura;
    private JRadioButton JRBNoOrdenInterna;
    private JRadioButton JRBUbicacionFactura;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPOpciones;
    private JRadioButton jRadioButton2;
    private final IDigitalizacionSoporteDAO xIDigitalizacionSoporteDAO = (IDigitalizacionSoporteDAO) Principal.contexto.getBean(IDigitalizacionSoporteDAO.class);
    private final ISoporteCarpetasArchivosDAO xISoporteCarpetasArchivosDAO = (ISoporteCarpetasArchivosDAO) Principal.contexto.getBean(ISoporteCarpetasArchivosDAO.class);
    private final ISoporteCarpetasDAO xISoporteCarpetasDAO = (ISoporteCarpetasDAO) Principal.contexto.getBean(ISoporteCarpetasDAO.class);
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private Metodos metodos = new Metodos();

    public JIFDigitalizacionSopote() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.BGFiltro = new ButtonGroup();
        this.BGTipoExportado = new ButtonGroup();
        this.BGGeneracionAdjuntos = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBConvenio = new JComboBox<>();
        this.JCHSeleccionar = new JCheckBox();
        this.JCBCuentaCobro = new JComboBox<>();
        this.JRBCuentaCobro = new JRadioButton();
        this.JRBNoFactura = new JRadioButton();
        this.JRBConvenios = new JRadioButton();
        this.JRBNoOrdenInterna = new JRadioButton();
        this.JTPOpciones = new JTabbedPane();
        this.JPAdjuntoDian = new JPanel();
        this.JCHAdjuntosDian = new JCheckBox();
        this.JRBUbicacionFactura = new JRadioButton();
        this.JRBAdjuntoDian = new JRadioButton();
        this.JPGeneracion = new JPanel();
        this.JBTExportar = new JButton();
        this.jRadioButton2 = new JRadioButton();
        this.JTFRuta = new JTextField();
        this.JRBGenerar = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("SOPORTES DIGITALIZADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifdigitalizacionsoporte");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDigitalizacionSopote.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDigitalizacionSopote.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConvenio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.3
            public void itemStateChanged(ItemEvent evt) {
                JIFDigitalizacionSopote.this.JCBConvenioItemStateChanged(evt);
            }
        });
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setForeground(Color.blue);
        this.JCHSeleccionar.setText("Seleccionar todos?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.4
            public void actionPerformed(ActionEvent evt) {
                JIFDigitalizacionSopote.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JCBCuentaCobro.setEditable(true);
        this.JCBCuentaCobro.setFont(new Font("Arial", 1, 12));
        this.JCBCuentaCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Cuenta de Cobro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuentaCobro.setEnabled(false);
        this.BGFiltro.add(this.JRBCuentaCobro);
        this.JRBCuentaCobro.setFont(new Font("Arial", 1, 12));
        this.JRBCuentaCobro.setText("No Cuenta de Cobro");
        this.JRBCuentaCobro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.5
            public void actionPerformed(ActionEvent evt) {
                JIFDigitalizacionSopote.this.JRBCuentaCobroActionPerformed(evt);
            }
        });
        this.BGFiltro.add(this.JRBNoFactura);
        this.JRBNoFactura.setFont(new Font("Arial", 1, 12));
        this.JRBNoFactura.setText("No de Factura");
        this.JRBNoFactura.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.6
            public void actionPerformed(ActionEvent evt) {
                JIFDigitalizacionSopote.this.JRBNoFacturaActionPerformed(evt);
            }
        });
        this.BGFiltro.add(this.JRBConvenios);
        this.JRBConvenios.setFont(new Font("Arial", 1, 12));
        this.JRBConvenios.setSelected(true);
        this.JRBConvenios.setText("Solo Convenios");
        this.JRBConvenios.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.7
            public void actionPerformed(ActionEvent evt) {
                JIFDigitalizacionSopote.this.JRBConveniosActionPerformed(evt);
            }
        });
        this.BGFiltro.add(this.JRBNoOrdenInterna);
        this.JRBNoOrdenInterna.setFont(new Font("Arial", 1, 12));
        this.JRBNoOrdenInterna.setText("No Orden Interna");
        this.JRBNoOrdenInterna.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.8
            public void actionPerformed(ActionEvent evt) {
                JIFDigitalizacionSopote.this.JRBNoOrdenInternaActionPerformed(evt);
            }
        });
        this.JTPOpciones.setForeground(new Color(0, 123, 0));
        this.JTPOpciones.setFont(new Font("Arial", 1, 14));
        this.JCHAdjuntosDian.setFont(new Font("Arial", 1, 12));
        this.JCHAdjuntosDian.setForeground(Color.blue);
        this.JCHAdjuntosDian.setText("Añadir Adjuntos Dian?");
        this.JCHAdjuntosDian.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.9
            public void actionPerformed(ActionEvent evt) {
                JIFDigitalizacionSopote.this.JCHAdjuntosDianActionPerformed(evt);
            }
        });
        this.BGGeneracionAdjuntos.add(this.JRBUbicacionFactura);
        this.JRBUbicacionFactura.setFont(new Font("Arial", 1, 12));
        this.JRBUbicacionFactura.setText("Generar en ubicacion facturas");
        this.JRBUbicacionFactura.setEnabled(false);
        this.BGGeneracionAdjuntos.add(this.JRBAdjuntoDian);
        this.JRBAdjuntoDian.setFont(new Font("Arial", 1, 12));
        this.JRBAdjuntoDian.setSelected(true);
        this.JRBAdjuntoDian.setText("Generar en carpeta adjunto dian");
        this.JRBAdjuntoDian.setEnabled(false);
        GroupLayout JPAdjuntoDianLayout = new GroupLayout(this.JPAdjuntoDian);
        this.JPAdjuntoDian.setLayout(JPAdjuntoDianLayout);
        JPAdjuntoDianLayout.setHorizontalGroup(JPAdjuntoDianLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAdjuntoDianLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHAdjuntosDian).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBUbicacionFactura).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAdjuntoDian).addContainerGap(454, 32767)));
        JPAdjuntoDianLayout.setVerticalGroup(JPAdjuntoDianLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAdjuntoDianLayout.createSequentialGroup().addContainerGap().addGroup(JPAdjuntoDianLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBUbicacionFactura).addComponent(this.JCHAdjuntosDian).addComponent(this.JRBAdjuntoDian)).addGap(41, 41, 41)));
        this.JTPOpciones.addTab("ADJUNTOS DIAN", this.JPAdjuntoDian);
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTExportar.setText("Generar Informes");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.10
            public void actionPerformed(ActionEvent evt) {
                JIFDigitalizacionSopote.this.JBTExportarActionPerformed(evt);
            }
        });
        this.BGTipoExportado.add(this.jRadioButton2);
        this.jRadioButton2.setFont(new Font("Arial", 1, 12));
        this.jRadioButton2.setText("Exportar a Excel");
        this.jRadioButton2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.11
            public void actionPerformed(ActionEvent evt) {
                JIFDigitalizacionSopote.this.jRadioButton2ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.12
            public void mouseClicked(MouseEvent evt) {
                JIFDigitalizacionSopote.this.JTFRutaMouseClicked(evt);
            }
        });
        this.BGTipoExportado.add(this.JRBGenerar);
        this.JRBGenerar.setFont(new Font("Arial", 1, 12));
        this.JRBGenerar.setSelected(true);
        this.JRBGenerar.setText("Generar");
        this.JRBGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.13
            public void actionPerformed(ActionEvent evt) {
                JIFDigitalizacionSopote.this.JRBGenerarActionPerformed(evt);
            }
        });
        GroupLayout JPGeneracionLayout = new GroupLayout(this.JPGeneracion);
        this.JPGeneracion.setLayout(JPGeneracionLayout);
        JPGeneracionLayout.setHorizontalGroup(JPGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGeneracionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 706, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton2).addComponent(this.JRBGenerar)).addContainerGap(-1, 32767)));
        JPGeneracionLayout.setVerticalGroup(JPGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGeneracionLayout.createSequentialGroup().addContainerGap().addGroup(JPGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 45, -2).addGroup(JPGeneracionLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JRBGenerar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRadioButton2))).addGap(10, 10, 10)));
        this.JTPOpciones.addTab("GENERACION", this.JPGeneracion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCHSeleccionar).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBConvenio, -2, 457, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBCuentaCobro).addComponent(this.JRBNoFactura).addComponent(this.JRBNoOrdenInterna)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBConvenios).addComponent(this.JCBCuentaCobro, -2, 151, -2)).addContainerGap(-1, 32767)))).addComponent(this.JTPOpciones, -1, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.JRBCuentaCobro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNoFactura).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNoOrdenInterna)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 55, -2).addComponent(this.JDFechaF, -2, 55, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConvenio, -2, 43, -2).addComponent(this.JCBCuentaCobro, -2, 40, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSeleccionar).addComponent(this.JRBConvenios)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 381, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPOpciones, -2, 100, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            llenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            llenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JRBGenerar.isSelected()) {
            mImprimir();
        } else {
            this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                this.xmodelo.setValueAt(Boolean.valueOf(this.JCHSeleccionar.isSelected()), i, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioItemStateChanged(ItemEvent evt) {
        llenarComboFiltro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                if (this.JRBGenerar.isSelected()) {
                    this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                } else {
                    this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra() + "Planilla");
                }
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoFacturaActionPerformed(ActionEvent evt) {
        this.JCBCuentaCobro.setEnabled(true);
        this.JCBCuentaCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        llenarComboFiltro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCuentaCobroActionPerformed(ActionEvent evt) {
        this.JCBCuentaCobro.setEnabled(true);
        this.JCBCuentaCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Cuenta de Cobro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        llenarComboFiltro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConveniosActionPerformed(ActionEvent evt) {
        this.JCBCuentaCobro.setEnabled(false);
        this.JCBCuentaCobro.removeAllItems();
        this.JCBCuentaCobro.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGenerarActionPerformed(ActionEvent evt) {
        this.JBTExportar.setText("Generar Informes");
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Soportes Digitalizados" + this.metodos.getBarra());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton2ActionPerformed(ActionEvent evt) {
        this.JBTExportar.setText("Exportar a Excel");
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoOrdenInternaActionPerformed(ActionEvent evt) {
        this.JCBCuentaCobro.setEnabled(true);
        this.JCBCuentaCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Orden Interna", 0, 0, new Font("Arial", 1, 12), Color.blue));
        llenarComboFiltro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAdjuntosDianActionPerformed(ActionEvent evt) {
        if (this.JCHAdjuntosDian.isSelected()) {
            this.JRBUbicacionFactura.setEnabled(true);
            this.JRBAdjuntoDian.setEnabled(true);
        } else {
            this.JRBUbicacionFactura.setEnabled(false);
            this.JRBAdjuntoDian.setEnabled(false);
        }
    }

    private void llenarCombo() {
        this.xlleno1 = false;
        this.listarconvenios = this.xIDigitalizacionSoporteDAO.cargarComboConvenios(this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()));
        this.JCBConvenio.removeAllItems();
        for (int i = 0; i < this.listarconvenios.size(); i++) {
            this.JCBConvenio.addItem(this.listarconvenios.get(i).getNombre());
        }
        this.JCBConvenio.setSelectedIndex(-1);
        this.xlleno1 = true;
    }

    private void llenarComboFiltro() {
        if (this.JCBConvenio.getSelectedIndex() != -1 && this.xlleno1) {
            if (this.JRBCuentaCobro.isSelected()) {
                this.listarCuentaCobro = this.xIDigitalizacionSoporteDAO.cargarComboCuentaCobro(this.listarconvenios.get(this.JCBConvenio.getSelectedIndex()).getId(), this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()));
                this.JCBCuentaCobro.removeAllItems();
                for (int i = 0; i < this.listarCuentaCobro.size(); i++) {
                    this.JCBCuentaCobro.addItem(this.listarCuentaCobro.get(i).getId().toString());
                }
            } else if (this.JRBNoOrdenInterna.isSelected()) {
                this.listarCuentaCobro = this.xIDigitalizacionSoporteDAO.cargarComboFacturasCapita(this.listarconvenios.get(this.JCBConvenio.getSelectedIndex()).getId(), this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()));
                this.JCBCuentaCobro.removeAllItems();
                for (int i2 = 0; i2 < this.listarCuentaCobro.size(); i2++) {
                    this.JCBCuentaCobro.addItem(this.listarCuentaCobro.get(i2).getId().toString());
                }
            } else {
                this.listarCuentaCobro = this.xIDigitalizacionSoporteDAO.cargarComboFacturas(this.listarconvenios.get(this.JCBConvenio.getSelectedIndex()).getId(), this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()));
                this.JCBCuentaCobro.removeAllItems();
                for (int i3 = 0; i3 < this.listarCuentaCobro.size(); i3++) {
                    this.JCBCuentaCobro.addItem(this.listarCuentaCobro.get(i3).getId().toString());
                }
            }
            this.JCBCuentaCobro.setSelectedIndex(-1);
            autocompletarComboEmpresa();
        }
    }

    private void autocompletarComboEmpresa() {
        new AutoCompletarComboBox(this.JCBCuentaCobro);
    }

    public void mNuevo() {
        this.xlleno = false;
        if (this.JRBGenerar.isSelected()) {
            this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Soportes Digitalizados" + this.metodos.getBarra());
        } else {
            this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        }
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        this.JCBCuentaCobro.removeAllItems();
        this.JCBCuentaCobro.setSelectedIndex(-1);
        mCrearModeloTabla();
        this.JCHSeleccionar.setSelected(false);
        this.xlleno = true;
    }

    public void mBuscar() {
        if (this.JRBCuentaCobro.isSelected() || this.JRBNoFactura.isSelected() || this.JRBNoOrdenInterna.isSelected()) {
            if (this.JCBCuentaCobro.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            }
            if (this.JRBCuentaCobro.isSelected()) {
                JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar Una Cuenta De Cobro", "INFORMACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar Una Factura", "INFORMACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            this.JCBCuentaCobro.requestFocus();
            return;
        }
        mCargarDatosTabla();
    }

    public void mImprimir() {
        this.xWorkerSQL = new WorkerSQL("Generando PDF", this);
        this.xWorkerSQL.execute();
    }

    public void GenerarReportes() {
        if (this.JTDetalle.getRowCount() > 0) {
            IntStream.range(0, this.JTDetalle.getRowCount()).filter(i -> {
                return Boolean.parseBoolean(this.xmodelo.getValueAt(i, 0).toString());
            }).forEach(i2 -> {
                consultarCarpetaConvenio(Long.valueOf(Long.parseLong(this.xmodelo.getValueAt(i2, 20).toString())), i2);
            });
        }
        eliminarArchivosTemporales(this.metodos.mRutaSoporte("temp"), "_tmp.pdf");
    }

    private String generarNombre(String nombre, String separador, int pos) {
        StringBuilder nombreCarpeta = new StringBuilder();
        StringBuilder concatenado = new StringBuilder();
        int countComilla = 0;
        DecimalFormat df = new DecimalFormat("#");
        for (int i = 0; i < nombre.length(); i++) {
            char ch = nombre.charAt(i);
            if (countComilla == 1 && ch != '\'') {
                concatenado.append(ch);
            } else {
                switch (ch) {
                    case '#':
                        nombreCarpeta.append(this.xmodelo.getValueAt(pos, 9)).append(separador);
                        break;
                    case '$':
                        nombreCarpeta.append(this.xmodelo.getValueAt(pos, 19)).append(separador);
                        break;
                    case '\'':
                        countComilla++;
                        if (countComilla == 2) {
                            nombreCarpeta.append(concatenado.toString()).append(separador);
                            concatenado.setLength(0);
                            countComilla = 0;
                        }
                        break;
                    case 'A':
                        nombreCarpeta.append(this.xmodelo.getValueAt(pos, 12)).append(separador);
                        break;
                    case 'C':
                        nombreCarpeta.append(this.xmodelo.getValueAt(pos, 18)).append(separador);
                        break;
                    case 'E':
                        if (!this.xmodelo.getValueAt(pos, 22).toString().isEmpty()) {
                            LocalDate date = LocalDate.parse(this.xmodelo.getValueAt(pos, 22).toString());
                            nombreCarpeta.append(date.format(DateTimeFormatter.ofPattern("ddMMyyyy"))).append(separador);
                        }
                        break;
                    case 'I':
                        nombreCarpeta.append(this.xmodelo.getValueAt(pos, 13)).append(separador);
                        break;
                    case 'N':
                        nombreCarpeta.append(this.xmodelo.getValueAt(pos, 17)).append(separador);
                        break;
                    case 'P':
                        nombreCarpeta.append(this.xmodelo.getValueAt(pos, 8)).append(separador);
                        break;
                    case 'R':
                        if (!this.xmodelo.getValueAt(pos, 7).toString().isEmpty()) {
                            LocalDate date2 = LocalDate.parse(this.xmodelo.getValueAt(pos, 7).toString());
                            nombreCarpeta.append(date2.format(DateTimeFormatter.ofPattern("ddMMyyyy"))).append(separador);
                        }
                        break;
                    case 'V':
                        String sinDecimales = df.format(Double.parseDouble(this.xmodelo.getValueAt(pos, 11).toString()));
                        nombreCarpeta.append(sinDecimales).append(separador);
                        break;
                    case 'X':
                        nombreCarpeta.append(Principal.informacionIps.getIdentificacion()).append(separador);
                        break;
                    case 'Z':
                        nombreCarpeta.append(this.xmodelo.getValueAt(pos, 8)).append(this.xmodelo.getValueAt(pos, 9)).append(separador);
                        break;
                }
            }
        }
        if (nombreCarpeta.length() > 0 && !separador.isEmpty()) {
            nombreCarpeta.setLength(nombreCarpeta.length() - separador.length());
        }
        return nombreCarpeta.toString();
    }

    private void consultarCarpetaConvenio(Long idConvenio, int posFila) {
        eliminarArchivosTemporales(this.metodos.mRutaSoporte("temp"), "_tmp.pdf");
        this.listarCarpetas = this.xISoporteCarpetasDAO.consultarSoporteCarpetasActivasPorConvenio(idConvenio, true);
        this.listarCarpetas.stream().forEach(e -> {
            String rutaCarpeta = this.JTFRuta.getText() + generarNombre(e.getNombre(), e.getSeparador(), posFila);
            File directorio = new File(rutaCarpeta);
            if (directorio.exists() || directorio.mkdirs()) {
                consultarArchivosCarpeta(e.getId(), directorio, posFila);
            }
            eliminarArchivosTemporales(this.metodos.mRutaSoporte("temp"), "_tmp.pdf");
            eliminar(directorio);
        });
    }

    public void eliminar(File f) {
        int cont = 0;
        System.out.println(f.getAbsolutePath());
        if (f.isDirectory()) {
            for (File file : f.listFiles()) {
                cont++;
            }
        }
        if (cont == 0) {
            f.delete();
        }
        System.out.println(cont);
    }

    private void consultarArchivosCarpeta(Long idCarpeta, File directorioCarpeta, int posFila) {
        ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
        this.listarArchivosCarpeta = this.xISoporteCarpetasArchivosDAO.consultarArchivosSoporteCarpetasActivosConTipoHistoriaConSoportes(idCarpeta, Long.valueOf(this.listaUsuarios.get(posFila).getIdTipoHistoria()));
        this.listarArchivosCarpeta.stream().forEach(archivo -> {
            File file;
            String nombreArchivo = generarNombre(archivo.getNombre(), archivo.getSeparador(), posFila);
            ImpresionReportesDTO dto = prepararReporteDTO(archivo, posFila);
            System.out.println("Tipo Historia: " + this.listaUsuarios.get(posFila).getIdTipoHistoria());
            System.out.println("idReporte: " + archivo.getIdReporte());
            System.out.println("Especial: " + archivo.getEspecial());
            List<String> listaarchivos = (List) impresionInformes.impresionReportes(dto).stream().filter(item -> {
                return (item == null || item.isEmpty() || !this.metodos.mExisteArchivo(item)) ? false : true;
            }).collect(Collectors.toList());
            listaarchivos.forEach(ruta -> {
                generarSoportesDigitalizados(directorioCarpeta, nombreArchivo, ruta, archivo.getUnificado());
            });
            if (this.JCHAdjuntosDian.isSelected() && dto.getEspecial().intValue() == 61 && dto.getEsDocumentoEscaneado().intValue() == 0) {
                String ruta2 = impresionInformes.consultarAdjuntosDian(dto.getIdIngreso().toString());
                if (!ruta2.isEmpty()) {
                    Path sourceDir = Paths.get(ruta2, new String[0]);
                    Path targetDir = null;
                    if (this.JRBUbicacionFactura.isSelected()) {
                        file = directorioCarpeta.getAbsoluteFile();
                    } else {
                        file = new File(this.metodos.getDirectorioExportacion() + "Soportes Digitalizados" + this.metodos.getBarra() + "adjuntos dian");
                    }
                    File file2 = file;
                    if (file2.exists() || file2.mkdirs()) {
                        targetDir = Paths.get(file2.getAbsolutePath(), new String[0]);
                    }
                    try {
                        DirectoryStream<Path> stream = Files.newDirectoryStream(sourceDir, "zad*.zip");
                        Throwable th = null;
                        try {
                            try {
                                Iterator<Path> it = stream.iterator();
                                if (it.hasNext()) {
                                    Path entry = it.next();
                                    Path targetPath = targetDir.resolve(entry.getFileName());
                                    Files.copy(entry, targetPath, StandardCopyOption.REPLACE_EXISTING);
                                    System.out.println("Archivo copiado a: " + targetPath);
                                }
                                if (stream != null) {
                                    if (0 != 0) {
                                        try {
                                            stream.close();
                                        } catch (Throwable th2) {
                                            th.addSuppressed(th2);
                                        }
                                    } else {
                                        stream.close();
                                    }
                                }
                            } finally {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            throw th3;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private ImpresionReportesDTO prepararReporteDTO(ISoporteCarpetasArchivos archivo, int posFila) {
        ImpresionReportesDTO e = new ImpresionReportesDTO();
        e.setTitulo(archivo.getReporte());
        e.setIdReporte(archivo.getIdReporte());
        e.setNombrePDF(archivo.getNombrePDF());
        e.setEspecial(Integer.valueOf(Integer.parseInt(archivo.getEspecial())));
        e.setIdAtencion(this.listaUsuarios.get(posFila).getIdAtencion());
        e.setIdUsuario(this.listaUsuarios.get(posFila).getIdUsuario());
        e.setIdIngreso(this.listaUsuarios.get(posFila).getIdIngreso());
        e.setIdTipoAtencion(this.listaUsuarios.get(posFila).getIdTipoAtencion());
        e.setNoFactura(this.listaUsuarios.get(posFila).getPrefijo() + this.listaUsuarios.get(posFila).getNumeroFacturaOrden());
        e.setIdIdentificadorTipoFactura(this.listaUsuarios.get(posFila).getIdentificadorTipoFactura());
        e.setNit(this.listaUsuarios.get(posFila).getNit());
        e.setRutaCarpeta(this.metodos.mRutaSoporte("temp"));
        e.setVisualizar(false);
        e.setFechaI(this.metodos.formatoAMD1.format(this.JDFechaI.getDate()));
        e.setFechaF(this.metodos.formatoAMD1.format(this.JDFechaF.getDate()));
        e.setEsDocumentoEscaneado(archivo.getEsSoporte());
        return e;
    }

    private void generarSoportesDigitalizados(File directorioCarpeta, String nombreArchivo, String rutaArchivo, boolean esUnificado) {
        if ((esUnificado && this.metodos.mExisteArchivo(directorioCarpeta + this.metodos.getBarra() + nombreArchivo + ".pdf") && this.metodos.mExisteArchivo(rutaArchivo)) || (this.metodos.mExisteArchivo(directorioCarpeta + this.metodos.getBarra() + nombreArchivo + ".pdf") && this.metodos.mExisteArchivo(rutaArchivo))) {
            try {
                PDFMergerUtility pdfmerger = new PDFMergerUtility();
                pdfmerger.setDestinationFileName(directorioCarpeta + this.metodos.getBarra() + nombreArchivo + ".pdf");
                pdfmerger.addSource(directorioCarpeta + this.metodos.getBarra() + nombreArchivo + ".pdf");
                pdfmerger.addSource(rutaArchivo);
                pdfmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
                return;
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
                return;
            } catch (IOException ex2) {
                System.out.println(ex2.getMessage());
                return;
            }
        }
        if (this.metodos.mExisteArchivo(rutaArchivo)) {
            this.metodos.FileCopy(rutaArchivo, directorioCarpeta.getAbsolutePath(), nombreArchivo + ".pdf");
            this.metodos.mEliminarArchivo(new File(nombreArchivo + ".pdf"));
        }
    }

    private void eliminarArchivosTemporales(String directorioCarpeta, String filtro) {
        File directory = new File(directorioCarpeta);
        Arrays.stream((Object[]) Objects.requireNonNull(directory.listFiles())).filter(f -> {
            return f.getName().endsWith(filtro);
        }).forEach(f2 -> {
            try {
                FileUtils.forceDelete(f2);
            } catch (IOException ex) {
                Logger.getLogger(JIFDigitalizacionSopote.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "No. Factura", "Fecha Ingreso", "Documento", "Usuario", "Sexo", "Convenio", "Fecha Factura", "Prefijo", "No. Factura", "SubGrupo Servicio", "Valor Total", "IdAtencion", "IdIngreso", "IdUsuario", "IdentificacionTipoFactura", "Cuenta Cobro", "NIT", "No Contrato", "FechaCorta", "idConvenio", "idTipoAtencion", "FechaEventoECat"}) { // from class: com.genoma.plus.controller.digitalizacion_soporte.JIFDigitalizacionSopote.14
            Class[] types = {Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Long.class, Long.class, Long.class, Integer.class, Integer.class, String.class, String.class, String.class, Long.class, Long.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(this.JTDetalle.getModel());
        this.JTDetalle.setRowSorter(sorter);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(200);
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
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        this.listaUsuarios = null;
        if (this.JRBCuentaCobro.isSelected()) {
            this.listaUsuarios = this.xIDigitalizacionSoporteDAO.consultarUsuariosSoportePorIdConvenioYNoCobro(this.listarconvenios.get(this.JCBConvenio.getSelectedIndex()).getId(), this.JCBCuentaCobro.getSelectedItem().toString());
        } else if (this.JRBNoFactura.isSelected()) {
            this.listaUsuarios = this.xIDigitalizacionSoporteDAO.consultarUsuariosSoportePorIdConvenioYNoFactura(this.listarconvenios.get(this.JCBConvenio.getSelectedIndex()).getId(), this.JCBCuentaCobro.getSelectedItem().toString());
        } else if (this.JRBNoOrdenInterna.isSelected()) {
            this.listaUsuarios = this.xIDigitalizacionSoporteDAO.consultarUsuariosSoportePorIdConvenioYNoOrdenInterna(this.listarconvenios.get(this.JCBConvenio.getSelectedIndex()).getId(), this.JCBCuentaCobro.getSelectedItem().toString());
        } else {
            this.listaUsuarios = this.xIDigitalizacionSoporteDAO.consultarUsuariosSoporteConvenio(this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()), this.listarconvenios.get(this.JCBConvenio.getSelectedIndex()).getId());
        }
        if (!this.listaUsuarios.isEmpty()) {
            for (int i = 0; i < this.listaUsuarios.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(false, i, 0);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getNumeroFacturaOrden(), i, 1);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getFechaIngreso(), i, 2);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getDocumento(), i, 3);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getNombreUsuario(), i, 4);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getSexo(), i, 5);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getnombreConvenio(), i, 6);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getFechaFacturaOrden(), i, 7);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getPrefijo(), i, 8);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getNumeroFacturaOrden(), i, 9);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getSubGrupoServicio(), i, 10);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getValorTotal(), i, 11);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getIdAtencion(), i, 12);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getIdIngreso(), i, 13);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getIdUsuario(), i, 14);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getIdentificadorTipoFactura(), i, 15);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getCuentaCobro(), i, 16);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getNit(), i, 17);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getNumeroContrato(), i, 18);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getFechaCorta(), i, 19);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getIdConvenio(), i, 20);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getIdTipoAtencion(), i, 21);
                this.xmodelo.setValueAt(this.listaUsuarios.get(i).getFechaeventoecat(), i, 22);
            }
        }
    }
}
