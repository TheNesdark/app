package com.genoma.plus.controller.GestionDoc;

import Acceso.Principal;
import Historia.JIFConsultarExamenesxUsuario;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GdPlantillaHCEntity;
import com.genoma.plus.jpa.projection.AtencionProjection;
import com.genoma.plus.jpa.projection.IGenericComboTresValores;
import com.genoma.plus.jpa.service.CClasecitaService;
import com.genoma.plus.jpa.service.EstadoAtencionService;
import com.genoma.plus.jpa.service.IGdPlantillaHcService;
import com.genoma.plus.utils.UtilidadesGenericas;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/GestionDoc/JIFExportacionHCPDFPlantilla.class */
public class JIFExportacionHCPDFPlantilla extends JInternalFrame {
    private String[] xidsubgrupo;
    private String[][] xidempresa;
    private String[][] xidservicio;
    private Object[] xdato;
    private String xsql;
    private final CClasecitaService cClasecitaService;
    private final IGdPlantillaHcService IplantillaHcService;
    private final EstadoAtencionService IAtencionService;
    private DefaultTableModel modeloClaseCita;
    private DefaultTableModel modeloDetalle;
    private JIFConsultarExamenesxUsuario xjifconsultasexamen;
    private final UtilidadesGenericas utilidadesGenericas;
    private List<IGenericComboTresValores> listaEntidades;
    private List<Integer> idClaseCita;
    private File directorio;
    private File fileExcel;
    private ButtonGroup JBGSeleccion;
    private JButton JBTExportar2;
    private JButton JBTExportar3;
    private JComboBox<String> JCB_Entidad;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JLabel JLBNumeroRegistro;
    private JPanel JPIDatoP;
    private JPanel JPITipoSeleccion;
    private JRadioButton JRBDeseleccionarTodo;
    private JRadioButton JRBSelecionarTodo;
    private JScrollPane JSPResultado;
    private JScrollPane JSPResultado1;
    private JTable JTBResultadoClaseCita;
    private JTable JTBResultadoDetalle;
    private JTextField JTFRuta;
    private JTextField JTFRutaExcel;
    private JTabbedPane jTabbedPane1;
    private int xllenoc = 0;
    private int xllenocg = 0;
    private int xarmada = 0;
    private final Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int numeroRegistro = 0;

    public JIFExportacionHCPDFPlantilla() {
        initComponents();
        this.cClasecitaService = (CClasecitaService) Principal.contexto.getBean(CClasecitaService.class);
        this.IplantillaHcService = (IGdPlantillaHcService) Principal.contexto.getBean(IGdPlantillaHcService.class);
        this.IAtencionService = (EstadoAtencionService) Principal.contexto.getBean(EstadoAtencionService.class);
        this.utilidadesGenericas = new UtilidadesGenericas();
        this.listaEntidades = new ArrayList();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JBTExportar2 = new JButton();
        this.JTFRutaExcel = new JTextField();
        this.JCB_Entidad = new JComboBox<>();
        this.JLBNumeroRegistro = new JLabel();
        this.jTabbedPane1 = new JTabbedPane();
        this.JSPResultado = new JScrollPane();
        this.JTBResultadoClaseCita = new JTable();
        this.JSPResultado1 = new JScrollPane();
        this.JTBResultadoDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar3 = new JButton();
        this.JPITipoSeleccion = new JPanel();
        this.JRBSelecionarTodo = new JRadioButton();
        this.JRBDeseleccionarTodo = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("EXPORTACIÓN HISTORIA CLINICA PDF MASIVA");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifexportacionmasivahcpdf");
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JBTExportar2.setFont(new Font("Arial", 1, 12));
        this.JBTExportar2.setForeground(Color.red);
        this.JBTExportar2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar2.setText("Importar");
        this.JBTExportar2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.3
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JBTExportar2ActionPerformed(evt);
            }
        });
        this.JTFRutaExcel.setFont(new Font("Arial", 1, 12));
        this.JTFRutaExcel.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo (Archivo Excel)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaExcel.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.4
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JTFRutaExcelMouseClicked(evt);
            }
        });
        this.JCB_Entidad.setFont(new Font("Arial", 1, 12));
        this.JCB_Entidad.setToolTipText("");
        this.JCB_Entidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Entidad.setName("empresaAtencion");
        this.JCB_Entidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.5
            public void itemStateChanged(ItemEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JCB_EntidadItemStateChanged(evt);
            }
        });
        this.JLBNumeroRegistro.setFont(new Font("Arial", 1, 14));
        this.JLBNumeroRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registro", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 130, -2).addGap(33, 33, 33).addComponent(this.JDCFechaFin, -2, 130, -2).addGap(28, 28, 28).addComponent(this.JCB_Entidad, 0, -1, 32767)).addGroup(JPIDatoPLayout.createSequentialGroup().addComponent(this.JTFRutaExcel, -2, 361, -2).addGap(47, 47, 47).addComponent(this.JBTExportar2, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNumeroRegistro, -2, 151, -2))).addContainerGap()));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 50, -2).addComponent(this.JDCFechaFin, -2, 50, -2)).addGap(0, 0, 32767)).addComponent(this.JCB_Entidad)).addGap(18, 18, 18).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRutaExcel, -2, 50, -2).addComponent(this.JBTExportar2, -2, 50, -2).addComponent(this.JLBNumeroRegistro, -2, 50, -2)).addGap(19, 19, 19)));
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JSPResultado.setBorder((Border) null);
        this.JSPResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultadoClaseCita.setFont(new Font("Arial", 1, 12));
        this.JTBResultadoClaseCita.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultadoClaseCita.setEditingColumn(1);
        this.JTBResultadoClaseCita.setEditingRow(1);
        this.JTBResultadoClaseCita.setRowHeight(25);
        this.JTBResultadoClaseCita.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultadoClaseCita.setSelectionForeground(Color.red);
        this.JTBResultadoClaseCita.setSelectionMode(0);
        this.JSPResultado.setViewportView(this.JTBResultadoClaseCita);
        this.jTabbedPane1.addTab("CLASE CITA", this.JSPResultado);
        this.JSPResultado1.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPResultado1.setFont(new Font("Arial", 1, 12));
        this.JTBResultadoDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBResultadoDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultadoDetalle.setEditingColumn(1);
        this.JTBResultadoDetalle.setEditingRow(1);
        this.JTBResultadoDetalle.setRowHeight(25);
        this.JTBResultadoDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultadoDetalle.setSelectionForeground(Color.red);
        this.JTBResultadoDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.6
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JTBResultadoDetalleMouseClicked(evt);
            }
        });
        this.JSPResultado1.setViewportView(this.JTBResultadoDetalle);
        this.jTabbedPane1.addTab("DETALLE", this.JSPResultado1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.7
            public void mouseClicked(MouseEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar3.setFont(new Font("Arial", 1, 12));
        this.JBTExportar3.setForeground(Color.red);
        this.JBTExportar3.setText("Exportar");
        this.JBTExportar3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.8
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JBTExportar3ActionPerformed(evt);
            }
        });
        this.JPITipoSeleccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Selección", 0, 0, new Font("Arial", 1, 12)));
        this.JBGSeleccion.add(this.JRBSelecionarTodo);
        this.JRBSelecionarTodo.setFont(new Font("Arial", 1, 12));
        this.JRBSelecionarTodo.setText("Todo");
        this.JRBSelecionarTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.9
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JRBSelecionarTodoActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBDeseleccionarTodo);
        this.JRBDeseleccionarTodo.setFont(new Font("Arial", 1, 12));
        this.JRBDeseleccionarTodo.setSelected(true);
        this.JRBDeseleccionarTodo.setText("Ninguno");
        this.JRBDeseleccionarTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.10
            public void actionPerformed(ActionEvent evt) {
                JIFExportacionHCPDFPlantilla.this.JRBDeseleccionarTodoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoSeleccionLayout = new GroupLayout(this.JPITipoSeleccion);
        this.JPITipoSeleccion.setLayout(JPITipoSeleccionLayout);
        JPITipoSeleccionLayout.setHorizontalGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoSeleccionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSelecionarTodo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDeseleccionarTodo).addContainerGap(14, 32767)));
        JPITipoSeleccionLayout.setVerticalGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoSeleccionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSelecionarTodo).addComponent(this.JRBDeseleccionarTodo)).addGap(29, 29, 29)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatoP, -1, -1, 32767).addComponent(this.jTabbedPane1).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 491, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar3, -2, 167, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 62, 32767).addComponent(this.JPITipoSeleccion, -2, -1, -2).addGap(52, 52, 52))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBTExportar3, -1, -1, 32767)).addComponent(this.JPITipoSeleccion, GroupLayout.Alignment.TRAILING, -2, 55, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        llenarComboEmpresa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar2ActionPerformed(ActionEvent evt) {
        leerArchivoExcel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        llenarComboEmpresa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmt.getDirectorioExportacion());
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
    public void JTFRutaExcelMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmt.getDirectorioExportacion());
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("XLSX", new String[]{"xlsx"});
            xfilec.setFileFilter(filtroImagen);
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                xfilec.showOpenDialog(this);
                this.fileExcel = xfilec.getSelectedFile();
                this.JTFRutaExcel.setText(this.fileExcel.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_EntidadItemStateChanged(ItemEvent evt) {
        if (this.JCB_Entidad.getSelectedIndex() != -1) {
            buscarClaseCita();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar3ActionPerformed(ActionEvent evt) {
        generarHC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSelecionarTodoActionPerformed(ActionEvent evt) {
        seleccionarEstado(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeseleccionarTodoActionPerformed(ActionEvent evt) {
        seleccionarEstado(false);
    }

    private void seleccionarEstado(Boolean estado) {
        if (this.jTabbedPane1.getSelectedIndex() == 0) {
            establecerDatos(this.JTBResultadoClaseCita, estado, 2);
        } else if (this.jTabbedPane1.getSelectedIndex() == 1) {
            establecerDatos(this.JTBResultadoDetalle, estado, 0);
        }
    }

    private void establecerDatos(JTable tabla, Boolean estado, int posColumna) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            tabla.setValueAt(estado, i, posColumna);
        }
    }

    private void llenarComboEmpresa() {
        this.JCB_Entidad.removeAllItems();
        this.listaEntidades = new ArrayList();
        this.listaEntidades = this.cClasecitaService.listaEmpresaAtencion(this.JDCFechaInicio.getDate(), this.JDCFechaFin.getDate());
        this.utilidadesGenericas.llenarCombo(this.JCB_Entidad, this.listaEntidades);
    }

    private void buscarClaseCita() {
        crearTablaClaseCita();
        new ArrayList();
        List<IGenericComboTresValores> claseCitaList = this.cClasecitaService.buscarClseCitaAtencionEmpresa(this.JDCFechaInicio.getDate(), this.JDCFechaFin.getDate(), this.listaEntidades.get(this.JCB_Entidad.getSelectedIndex()).getId());
        if (claseCitaList != null && !claseCitaList.isEmpty()) {
            claseCitaList.forEach(detalle -> {
                this.modeloClaseCita.addRow(this.xdato);
                this.JTBResultadoClaseCita.setValueAt(detalle.getId(), this.JTBResultadoClaseCita.getRowCount() - 1, 0);
                this.JTBResultadoClaseCita.setValueAt(detalle.getNombre(), this.JTBResultadoClaseCita.getRowCount() - 1, 1);
                this.JTBResultadoClaseCita.setValueAt(false, this.JTBResultadoClaseCita.getRowCount() - 1, 2);
            });
        }
    }

    private void buscarDetalle() {
        crearTablaDetalle();
        this.idClaseCita = new ArrayList();
        for (int i = 0; i < this.JTBResultadoClaseCita.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTBResultadoClaseCita.getValueAt(i, 2).toString()).booleanValue()) {
                this.idClaseCita.add(Integer.valueOf(this.JTBResultadoClaseCita.getValueAt(i, 0).toString()));
            }
        }
        List<AtencionProjection> listAtenciones = this.IAtencionService.buscarPacientePDF(this.JDCFechaInicio.getDate(), this.JDCFechaFin.getDate(), this.idClaseCita, this.listaEntidades.get(this.JCB_Entidad.getSelectedIndex()).getId());
        this.numeroRegistro = 0;
        if (listAtenciones != null && !listAtenciones.isEmpty()) {
            listAtenciones.forEach(detalle -> {
                this.modeloDetalle.addRow(this.xdato);
                this.JTBResultadoDetalle.setValueAt(false, this.JTBResultadoDetalle.getRowCount() - 1, 0);
                this.JTBResultadoDetalle.setValueAt(detalle.getFechaAtencion(), this.JTBResultadoDetalle.getRowCount() - 1, 1);
                this.JTBResultadoDetalle.setValueAt(detalle.getHoraAtencion(), this.JTBResultadoDetalle.getRowCount() - 1, 2);
                this.JTBResultadoDetalle.setValueAt(detalle.getDocumento(), this.JTBResultadoDetalle.getRowCount() - 1, 3);
                this.JTBResultadoDetalle.setValueAt(detalle.getNombreUsuario(), this.JTBResultadoDetalle.getRowCount() - 1, 4);
                this.JTBResultadoDetalle.setValueAt(detalle.getSexo(), this.JTBResultadoDetalle.getRowCount() - 1, 5);
                this.JTBResultadoDetalle.setValueAt(detalle.getNombreConvenio(), this.JTBResultadoDetalle.getRowCount() - 1, 6);
                this.JTBResultadoDetalle.setValueAt(detalle.getReporte(), this.JTBResultadoDetalle.getRowCount() - 1, 7);
                this.JTBResultadoDetalle.setValueAt(detalle.getIdAtencion(), this.JTBResultadoDetalle.getRowCount() - 1, 8);
                this.JTBResultadoDetalle.setValueAt(detalle.getIdPaciente(), this.JTBResultadoDetalle.getRowCount() - 1, 9);
                this.JTBResultadoDetalle.setValueAt(detalle.getIdIngreso(), this.JTBResultadoDetalle.getRowCount() - 1, 10);
                this.JTBResultadoDetalle.setValueAt(detalle.getClaseConsulta(), this.JTBResultadoDetalle.getRowCount() - 1, 11);
                this.numeroRegistro++;
            });
        }
        this.JLBNumeroRegistro.setText("" + this.numeroRegistro);
    }

    private void crearTablaClaseCita() {
        this.modeloClaseCita = new DefaultTableModel() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.11
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloClaseCita.addColumn("Id");
        this.modeloClaseCita.addColumn("Nombre");
        this.modeloClaseCita.addColumn("Seleccionar");
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<>(this.modeloClaseCita);
        this.JTBResultadoClaseCita.setRowSorter(elQueOrdena);
        this.JTBResultadoClaseCita.setAutoResizeMode(0);
        this.JTBResultadoClaseCita.doLayout();
        this.JTBResultadoClaseCita.setModel(this.modeloClaseCita);
        this.JTBResultadoClaseCita.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultadoClaseCita.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTBResultadoClaseCita.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBResultadoClaseCita.setModel(this.modeloClaseCita);
    }

    private void crearTablaDetalle() {
        this.modeloDetalle = new DefaultTableModel() { // from class: com.genoma.plus.controller.GestionDoc.JIFExportacionHCPDFPlantilla.12
            Class[] types = {Boolean.class, Date.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloDetalle.addColumn("Seleccionar");
        this.modeloDetalle.addColumn("Fecha Atención");
        this.modeloDetalle.addColumn("Hora Atención");
        this.modeloDetalle.addColumn("No. Documento");
        this.modeloDetalle.addColumn("Nombre Usuario");
        this.modeloDetalle.addColumn("Sexo");
        this.modeloDetalle.addColumn("Nombre Convenio");
        this.modeloDetalle.addColumn("NombreReporte");
        this.modeloDetalle.addColumn("idAtencion");
        this.modeloDetalle.addColumn("idPaciente");
        this.modeloDetalle.addColumn("idIngreso");
        this.modeloDetalle.addColumn("ClaseCita");
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<>(this.modeloDetalle);
        this.JTBResultadoDetalle.setRowSorter(elQueOrdena);
        this.JTBResultadoDetalle.setAutoResizeMode(0);
        this.JTBResultadoDetalle.doLayout();
        this.JTBResultadoDetalle.setModel(this.modeloDetalle);
        this.JTBResultadoDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBResultadoDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBResultadoDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBResultadoDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBResultadoDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTBResultadoDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTBResultadoDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTBResultadoDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTBResultadoDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBResultadoDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBResultadoDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBResultadoDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBResultadoDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBResultadoDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBResultadoDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBResultadoDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBResultadoDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBResultadoDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
    }

    public void grabar() {
    }

    public void buscar() {
        buscarDetalle();
    }

    public void nuevo() {
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        crearTablaClaseCita();
        crearTablaDetalle();
    }

    private void leerArchivoExcel() {
        try {
            FileInputStream inputStream = new FileInputStream(this.fileExcel);
            Sheet firstSheet = new XSSFWorkbook(inputStream).getSheetAt(0);
            Iterator iterator = firstSheet.iterator();
            int nfila = 0;
            iterator.next();
            List<GdPlantillaHCEntity> listPlantilla = new ArrayList<>();
            while (iterator.hasNext()) {
                Row nextRow = (Row) iterator.next();
                Cell cell1 = nextRow.getCell(0);
                Cell cell2 = nextRow.getCell(1);
                String valor1 = String.valueOf(cell2.getStringCellValue());
                System.out.println("" + cell1 + " : " + valor1);
                GdPlantillaHCEntity p = GdPlantillaHCEntity.builder().tipoDocumento(cell1.getStringCellValue()).noDocumento(valor1).build();
                listPlantilla.add(p);
                nfila++;
            }
            this.IplantillaHcService.eliminarDatosPlantilla();
            this.IplantillaHcService.grabar(listPlantilla);
        } catch (IOException ex) {
            Logger.getLogger(JIFExportacionHCPDFPlantilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void generarHC() {
        for (int i = 0; i < this.JTBResultadoDetalle.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTBResultadoDetalle.getValueAt(i, 0).toString()).booleanValue()) {
                List<InputStream> lista = new ArrayList<>();
                String nombreArchivo = this.JTBResultadoDetalle.getValueAt(i, 3).toString();
                List<AtencionProjection> listAtenciones = this.IAtencionService.listaAtencionesPacientesPDF(this.JDCFechaInicio.getDate(), this.JDCFechaFin.getDate(), this.idClaseCita, this.listaEntidades.get(this.JCB_Entidad.getSelectedIndex()).getId(), Long.valueOf(this.JTBResultadoDetalle.getValueAt(i, 9).toString()));
                if (listAtenciones != null && !listAtenciones.isEmpty()) {
                    listAtenciones.forEach(detalle -> {
                        try {
                            String[][] mparametros = new String[8][2];
                            mparametros[0][0] = "idatencion1";
                            mparametros[0][1] = detalle.getIdAtencion().toString();
                            mparametros[1][0] = "idpaciente1";
                            mparametros[1][1] = detalle.getIdPaciente().toString();
                            mparametros[2][0] = "idingreso";
                            mparametros[2][1] = detalle.getIdIngreso().toString();
                            mparametros[3][0] = "SUBREPORT_DIR";
                            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                            mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                            mparametros[5][0] = "tituloReporte";
                            mparametros[6][0] = "nbreUsuario";
                            mparametros[6][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                            mparametros[7][0] = "SO";
                            mparametros[7][1] = this.xmt.getSO();
                            System.out.println("" + detalle.getReporte());
                            this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + detalle.getReporte() + ".pdf"));
                            this.xmt.CrearPDF(this.xmt.getRutaRep() + detalle.getReporte(), mparametros, this.xmt.getRutaRep() + detalle.getIdAtencion() + detalle.getReporte());
                            File origen = new File(this.xmt.getRutaRep() + detalle.getIdAtencion() + detalle.getReporte() + ".pdf");
                            lista.add(new FileInputStream(origen));
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(JIFExportacionHCPDFPlantilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        }
                    });
                    this.xmt.unirPdf_Generico(this.JTFRuta.getText(), "HC" + nombreArchivo, lista);
                }
            }
        }
    }
}
