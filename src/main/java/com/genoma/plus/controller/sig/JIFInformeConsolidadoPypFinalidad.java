package com.genoma.plus.controller.sig;

import Acceso.Principal;
import Utilidades.Metodos;
import Utilidades.PlantillaReporteJasper;
import com.genoma.plus.jpa.projection.GenericCombo;
import com.genoma.plus.jpa.projection.IInformeConsolidadoPypFinalidadDTO;
import com.genoma.plus.jpa.projection.IInformeDetalladoPypFinalidadDTO;
import com.genoma.plus.jpa.projection.IInformeProduccion;
import com.genoma.plus.jpa.service.IngresoService;
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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFInformeConsolidadoPypFinalidad.class */
public class JIFInformeConsolidadoPypFinalidad extends JInternalFrame {
    private DefaultTableModel modeloConsolidado;
    private DefaultTableModel modeloDetalleUsuario;
    private Object[] dato;
    private List<GenericCombo> listaConvenios;
    private List<IInformeProduccion> listaProcedimientos;
    private List<IInformeProduccion> listaConsultas;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPI_Exportar;
    private JScrollPane JSPInformeConsolidado;
    private JScrollPane JSPInformeDetallado;
    private JTextField JTFRuta;
    private JTable JTInformeConsolidado;
    private JTable JTInformeDetallado;
    private JTabbedPane JTPMenu;
    private Metodos metodo = new Metodos();
    private boolean lleno = false;
    private final IngresoService ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);

    public JIFInformeConsolidadoPypFinalidad(String nombre, String titulo) {
        initComponents();
        setName(nombre);
        setTitle(titulo);
        nuevo();
    }

    public void nuevo() {
        this.lleno = false;
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.metodo.getFechaActual());
        this.JDFechaF.setDate(this.metodo.getFechaActual());
        this.JTFRuta.setText(this.metodo.getDirectorioExportacion() + "Planilla");
        crearModeloDatosConsolidado();
        this.JDFechaI.requestFocus();
        llevarComboConvenio();
        this.lleno = true;
    }

    public void buscar() {
        if (getName().equals("jifInformeConsoliadoPorFinalidad1")) {
            cargarDatosTablaConsolidadoProduccion();
            cargarDatosTablaConsolidadoProduccionConsulta();
        } else {
            cargarDatosTablaConsolidado();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosConsolidado() {
        this.modeloConsolidado = new DefaultTableModel(new Object[0], new String[]{"Servicio", "Codigo Cups", "Nombre Procedimiento", "Finalidad", "Cantidad", "Nombre del Convenio", "idFinalidad", "idServicio"}) { // from class: com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad.1
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTInformeConsolidado;
        JTable jTable2 = this.JTInformeConsolidado;
        jTable.setAutoResizeMode(0);
        this.JTInformeConsolidado.doLayout();
        this.JTInformeConsolidado.setModel(this.modeloConsolidado);
        this.JTInformeConsolidado.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTInformeConsolidado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTInformeConsolidado.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTInformeConsolidado.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTInformeConsolidado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTInformeConsolidado.getColumnModel().getColumn(5).setPreferredWidth(400);
        this.JTInformeConsolidado.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTInformeConsolidado.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos(JTable table) {
        this.modeloConsolidado = new DefaultTableModel(new Object[0], new String[]{"Cups", "Nombre Procedimiento", "Cantidad", "Valor Unitario", "Valor Total"}) { // from class: com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad.2
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        table.setAutoResizeMode(0);
        table.doLayout();
        table.setModel(this.modeloConsolidado);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(500);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void cargarDatosTablaConsolidado() {
        List<IInformeConsolidadoPypFinalidadDTO> list = this.ingresoService.informeConsolidadoPypFinalidad(this.metodo.formatoAMD1.format(this.JDFechaI.getDate()), this.metodo.formatoAMD1.format(this.JDFechaF.getDate()), this.listaConvenios.get(this.JCBEmpresa.getSelectedIndex()).getId());
        crearModeloDatosConsolidado();
        if (!list.isEmpty()) {
            this.metodo.mEstablecerTextEditor(this.JTInformeConsolidado, 2);
            this.metodo.mEstablecerTextEditor(this.JTInformeConsolidado, 3);
            this.metodo.mEstablecerTextEditor(this.JTInformeConsolidado, 5);
            for (int x = 0; x < list.size(); x++) {
                this.modeloConsolidado.addRow(this.dato);
                this.modeloConsolidado.setValueAt(list.get(x).getNombreServicio(), x, 0);
                this.modeloConsolidado.setValueAt(list.get(x).getCodigoCups(), x, 1);
                this.modeloConsolidado.setValueAt(list.get(x).getNombreProcedimiento(), x, 2);
                this.modeloConsolidado.setValueAt(list.get(x).getNombreFinalidad(), x, 3);
                this.modeloConsolidado.setValueAt(list.get(x).getCantidad(), x, 4);
                this.modeloConsolidado.setValueAt(list.get(x).getNombreConvenio(), x, 5);
                this.modeloConsolidado.setValueAt(list.get(x).getIdFinalidad(), x, 6);
                this.modeloConsolidado.setValueAt(list.get(x).getIdServicio(), x, 7);
            }
        }
    }

    private void cargarDatosTablaConsolidadoProduccion() {
        this.listaProcedimientos = new ArrayList();
        this.listaProcedimientos = this.ingresoService.informeProduccionProcedimiento(this.JDFechaI.getDate(), this.JDFechaF.getDate(), Long.valueOf(this.listaConvenios.get(this.JCBEmpresa.getSelectedIndex()).getId().intValue()));
        crearModeloDatos(this.JTInformeConsolidado);
        double valorTotal = 0.0d;
        if (!this.listaProcedimientos.isEmpty()) {
            this.metodo.mEstablecerTextEditor(this.JTInformeConsolidado, 1);
            for (int x = 0; x < this.listaProcedimientos.size(); x++) {
                this.modeloConsolidado.addRow(this.dato);
                this.modeloConsolidado.setValueAt(this.listaProcedimientos.get(x).getCups(), this.JTInformeConsolidado.getRowCount() - 1, 0);
                this.modeloConsolidado.setValueAt(this.listaProcedimientos.get(x).getNombreCups(), this.JTInformeConsolidado.getRowCount() - 1, 1);
                this.modeloConsolidado.setValueAt(this.listaProcedimientos.get(x).getCantidad(), this.JTInformeConsolidado.getRowCount() - 1, 2);
                this.modeloConsolidado.setValueAt(this.listaProcedimientos.get(x).getValorUnidad(), this.JTInformeConsolidado.getRowCount() - 1, 3);
                this.modeloConsolidado.setValueAt(this.listaProcedimientos.get(x).getValorTotal(), this.JTInformeConsolidado.getRowCount() - 1, 4);
                valorTotal += this.listaProcedimientos.get(x).getValorTotal().doubleValue();
            }
            this.modeloConsolidado.addRow(this.dato);
            this.modeloConsolidado.setValueAt("TOTAL", this.JTInformeConsolidado.getRowCount() - 1, 0);
            this.modeloConsolidado.setValueAt("", this.JTInformeConsolidado.getRowCount() - 1, 1);
            this.modeloConsolidado.setValueAt(0, this.JTInformeConsolidado.getRowCount() - 1, 2);
            this.modeloConsolidado.setValueAt(0, this.JTInformeConsolidado.getRowCount() - 1, 3);
            this.modeloConsolidado.setValueAt(Double.valueOf(valorTotal), this.JTInformeConsolidado.getRowCount() - 1, 4);
        }
    }

    private void cargarDatosTablaConsolidadoProduccionConsulta() {
        this.listaConsultas = this.ingresoService.informeProduccionConsulta(this.JDFechaI.getDate(), this.JDFechaF.getDate(), Long.valueOf(this.listaConvenios.get(this.JCBEmpresa.getSelectedIndex()).getId().intValue()));
        crearModeloDatos(this.JTInformeDetallado);
        double valorTotal = 0.0d;
        if (!this.listaConsultas.isEmpty()) {
            this.metodo.mEstablecerTextEditor(this.JTInformeDetallado, 1);
            for (int x = 0; x < this.listaConsultas.size(); x++) {
                this.modeloConsolidado.addRow(this.dato);
                this.modeloConsolidado.setValueAt(this.listaConsultas.get(x).getCups(), this.JTInformeDetallado.getRowCount() - 1, 0);
                this.modeloConsolidado.setValueAt(this.listaConsultas.get(x).getNombreCups(), this.JTInformeDetallado.getRowCount() - 1, 1);
                this.modeloConsolidado.setValueAt(this.listaConsultas.get(x).getCantidad(), this.JTInformeDetallado.getRowCount() - 1, 2);
                this.modeloConsolidado.setValueAt(this.listaConsultas.get(x).getValorUnidad(), this.JTInformeDetallado.getRowCount() - 1, 3);
                this.modeloConsolidado.setValueAt(this.listaConsultas.get(x).getValorTotal(), this.JTInformeDetallado.getRowCount() - 1, 4);
                valorTotal += this.listaConsultas.get(x).getValorTotal().doubleValue();
            }
            this.modeloConsolidado.addRow(this.dato);
            this.modeloConsolidado.setValueAt("TOTAL", this.JTInformeDetallado.getRowCount() - 1, 0);
            this.modeloConsolidado.setValueAt("", this.JTInformeDetallado.getRowCount() - 1, 1);
            this.modeloConsolidado.setValueAt(0, this.JTInformeDetallado.getRowCount() - 1, 2);
            this.modeloConsolidado.setValueAt(0, this.JTInformeDetallado.getRowCount() - 1, 3);
            this.modeloConsolidado.setValueAt(Double.valueOf(valorTotal), this.JTInformeDetallado.getRowCount() - 1, 4);
        }
    }

    private void llevarComboConvenio() {
        this.JCBEmpresa.removeAllItems();
        this.listaConvenios = new ArrayList();
        this.listaConvenios = this.ingresoService.listadoEmpresasConvenioAtenciones(this.metodo.formatoAMD1.format(this.JDFechaI.getDate()), this.metodo.formatoAMD1.format(this.JDFechaF.getDate()));
        this.listaConvenios.forEach(next -> {
            this.JCBEmpresa.addItem(next.getNombre());
        });
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosDetalle() {
        this.modeloDetalleUsuario = new DefaultTableModel(new Object[0], new String[]{"Tipo Documento", "Documento", "Usuario", "Fecha Nacimiento", "Edad", "Sexo", "NOrden", "Fecha Orden", "Codigo Cups", "Nombre Procedimiento", "Nombre Finalidad", "Cantidad"}) { // from class: com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTInformeDetallado;
        JTable jTable2 = this.JTInformeDetallado;
        jTable.setAutoResizeMode(0);
        this.JTInformeDetallado.doLayout();
        this.JTInformeDetallado.setModel(this.modeloDetalleUsuario);
        this.JTInformeDetallado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTInformeDetallado.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTInformeDetallado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTInformeDetallado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTInformeDetallado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTInformeDetallado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTInformeDetallado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTInformeDetallado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTInformeDetallado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTInformeDetallado.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTInformeDetallado.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTInformeDetallado.getColumnModel().getColumn(11).setPreferredWidth(100);
    }

    private void cargarDatosTablaDetalleUsuario() {
        List<IInformeDetalladoPypFinalidadDTO> list = this.ingresoService.informeDetalladoPypFinalidadUsuario(this.metodo.formatoAMD1.format(this.JDFechaI.getDate()), this.metodo.formatoAMD1.format(this.JDFechaF.getDate()), this.listaConvenios.get(this.JCBEmpresa.getSelectedIndex()).getId(), this.JTInformeConsolidado.getValueAt(this.JTInformeConsolidado.getSelectedRow(), 1).toString(), this.JTInformeConsolidado.getValueAt(this.JTInformeConsolidado.getSelectedRow(), 6).toString(), Integer.valueOf(this.JTInformeConsolidado.getValueAt(this.JTInformeConsolidado.getSelectedRow(), 7).toString()));
        crearModeloDatosDetalle();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.modeloDetalleUsuario.addRow(this.dato);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getIdTipoDocumento(), x, 0);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getNumeroDocumento(), x, 1);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getNombreUsuario(), x, 2);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getFechaNacimiento(), x, 3);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getEdad(), x, 4);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getSexo(), x, 5);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getNumeroOrden(), x, 6);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getFechaOrden(), x, 7);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getCodigoCups(), x, 8);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getNombreProcedimiento(), x, 9);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getNombreFinalidad(), x, 10);
                this.modeloDetalleUsuario.setValueAt(list.get(x).getCantidad(), x, 11);
            }
        }
    }

    public void impimir() {
        if (getName().equals("jifInformeConsoliadoPorFinalidad1")) {
            PlantillaReporteJasper jasper = new PlantillaReporteJasper();
            jasper.setFechaInicial(this.metodo.formatoDMA1.format(this.JDFechaI.getDate()));
            jasper.setFechaFinal(this.metodo.formatoDMA1.format(this.JDFechaF.getDate()));
            jasper.setEntidad(this.JCBEmpresa.getSelectedItem().toString());
            jasper.setNombreUsuario(Principal.usuarioSistemaDTO.getNombreUsuario());
            String SubReport = this.metodo.getRutaRep();
            jasper.setSubReporte(SubReport);
            if (this.JTPMenu.getSelectedIndex() == 0) {
                jasper.setTitulo("INFORME DE PROCEDIMIENTOS");
                jasper.setListaDetalleInforme(this.listaProcedimientos);
            } else {
                jasper.setTitulo("INFORME DE CONSULTAS");
                jasper.setListaDetalleInforme(this.listaConsultas);
            }
            this.metodo.GenerarPDF(SubReport + "F_ProduccionPorConvenio", jasper, "F_ProduccionPorConvenio", true);
        }
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JPI_Exportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTPMenu = new JTabbedPane();
        this.JSPInformeConsolidado = new JScrollPane();
        this.JTInformeConsolidado = new JTable();
        this.JSPInformeDetallado = new JScrollPane();
        this.JTInformeDetallado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME CONSOLIDADO DE ATENCIONES POR FINALIDAD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifInformeConsoliadoPorFinalidad");
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeConsolidadoPypFinalidad.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeConsolidadoPypFinalidad.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_Exportar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad.6
            public void mouseClicked(MouseEvent evt) {
                JIFInformeConsolidadoPypFinalidad.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad.7
            public void actionPerformed(ActionEvent evt) {
                JIFInformeConsolidadoPypFinalidad.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPI_ExportarLayout = new GroupLayout(this.JPI_Exportar);
        this.JPI_Exportar.setLayout(JPI_ExportarLayout);
        JPI_ExportarLayout.setHorizontalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 198, -2).addContainerGap()));
        JPI_ExportarLayout.setVerticalGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExportarLayout.createSequentialGroup().addGroup(JPI_ExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(0, 16, 32767)));
        this.JTPMenu.setForeground(Color.red);
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JTInformeConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTInformeConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTInformeConsolidado.setRowHeight(25);
        this.JTInformeConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTInformeConsolidado.setSelectionForeground(Color.red);
        this.JTInformeConsolidado.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad.8
            public void mouseClicked(MouseEvent evt) {
                JIFInformeConsolidadoPypFinalidad.this.JTInformeConsolidadoMouseClicked(evt);
            }
        });
        this.JSPInformeConsolidado.setViewportView(this.JTInformeConsolidado);
        this.JTPMenu.addTab("CONSOLIDADO", this.JSPInformeConsolidado);
        this.JTInformeDetallado.setFont(new Font("Arial", 1, 12));
        this.JTInformeDetallado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTInformeDetallado.setSelectionBackground(Color.white);
        this.JTInformeDetallado.setSelectionForeground(Color.red);
        this.JTInformeDetallado.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformeConsolidadoPypFinalidad.9
            public void mouseClicked(MouseEvent evt) {
                JIFInformeConsolidadoPypFinalidad.this.JTInformeDetalladoMouseClicked(evt);
            }
        });
        this.JSPInformeDetallado.setViewportView(this.JTInformeDetallado);
        this.JTPMenu.addTab("DETALLADO", this.JSPInformeDetallado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPMenu, -1, 983, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBEmpresa, -2, 700, -2).addGap(0, 0, 32767)).addComponent(this.JPI_Exportar, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, -1, -2)).addComponent(this.JCBEmpresa, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JTPMenu, -1, 332, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Exportar, -2, -1, -2).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTInformeConsolidadoMouseClicked(MouseEvent evt) {
        if (this.JTInformeConsolidado.getSelectedRow() != -1) {
            cargarDatosTablaDetalleUsuario();
            this.JTPMenu.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno) {
            llevarComboConvenio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno) {
            llevarComboConvenio();
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodo.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JTPMenu.getSelectedIndex() == 0) {
                this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTInformeConsolidado, this.JTFRuta.getText(), this.title + " - " + this.JTPMenu.getTitleAt(0));
            } else {
                this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTInformeDetallado, this.JTFRuta.getText(), this.title + " - " + this.JTPMenu.getTitleAt(1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTInformeDetalladoMouseClicked(MouseEvent evt) {
    }
}
