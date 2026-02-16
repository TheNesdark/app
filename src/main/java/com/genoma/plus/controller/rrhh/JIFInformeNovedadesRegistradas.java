package com.genoma.plus.controller.rrhh;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.rrhh.ConsolidadoConceptosDAO;
import com.genoma.plus.jpa.entities.RhPeriodoNomina;
import com.genoma.plus.jpa.projection.INominaConsolidadoItemsNovedades;
import com.genoma.plus.jpa.service.IRhPeriodoNominaService;
import com.genoma.plus.jpa.service.RhNominaNovedadesService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JIFInformeNovedadesRegistradas.class */
public class JIFInformeNovedadesRegistradas extends JInternalFrame {
    private IRhPeriodoNominaService periodoNomina;
    private RhNominaNovedadesService novedadesService;
    private List<RhPeriodoNomina> listPeriodoNomina;
    private DefaultTableModel modeloDetalle;
    private DefaultTableModel modeloConsolidado;
    private Object[] datos;
    private String[] xidnomina;
    private String xsql;
    private ConsolidadoConceptosDAO xConsolidadoConceptosDAO;
    private JButton JBTExportar;
    private JComboBox<String> JCBPeriodo;
    private JPanel JPFiltroPro;
    private JScrollPane JSConsolidado;
    private JScrollPane JSDetalle;
    private JTable JTConsolidado;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Datos;
    private Metodos xmt = new Metodos();
    private boolean xllenoc = false;

    public JIFInformeNovedadesRegistradas() {
        initComponents();
        this.periodoNomina = (IRhPeriodoNominaService) Principal.contexto.getBean(IRhPeriodoNominaService.class);
        this.novedadesService = (RhNominaNovedadesService) Principal.contexto.getBean(RhNominaNovedadesService.class);
        nuevo();
    }

    public void nuevo() {
        this.listPeriodoNomina = new ArrayList();
        this.listPeriodoNomina = this.periodoNomina.listarFiltroEstado(true);
        if (!this.listPeriodoNomina.isEmpty()) {
            this.listPeriodoNomina.forEach(item -> {
                this.JCBPeriodo.addItem(item.getNombre());
            });
        }
        crearModeloTableDetalle();
        crearModeloTableConsolidado();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    public void buscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            cargarDatosTablas();
        }
    }

    private void crearModeloTableDetalle() {
        this.modeloDetalle = new DefaultTableModel((Object[][]) null, new String[]{"No. Documento", "Nombre Empleado", "Nombre Concepto", "Fecha Inicial", "Hora Inicio", "Fecha Final", "Hora Final", "Cantidad"}) { // from class: com.genoma.plus.controller.rrhh.JIFInformeNovedadesRegistradas.1
            Class[] types = {String.class, String.class, String.class, Date.class, String.class, Date.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modeloDetalle);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void crearModeloTableConsolidado() {
        this.modeloConsolidado = new DefaultTableModel((Object[][]) null, new String[]{"No. Documento", "Nombre Empleado", "Nombre Concepto", "Cantidad"}) { // from class: com.genoma.plus.controller.rrhh.JIFInformeNovedadesRegistradas.2
            Class[] types = {String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTConsolidado.setAutoResizeMode(0);
        this.JTConsolidado.doLayout();
        this.JTConsolidado.setModel(this.modeloConsolidado);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTConsolidado.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    public void cargarDatosTablas() {
        new ArrayList();
        List<INominaConsolidadoItemsNovedades> detalleNovedades = this.novedadesService.listarNovedadesRegistradaPorPeriodoOrderEmpleadoConcepto(this.listPeriodoNomina.get(this.JCBPeriodo.getSelectedIndex()).getId(), 2022);
        new ArrayList();
        List<INominaConsolidadoItemsNovedades> consolidadoNovedades = this.novedadesService.listarNovedadesConsolidadaPorPeriodoOrderEmpleadoConcepto(this.listPeriodoNomina.get(this.JCBPeriodo.getSelectedIndex()).getId(), 2022);
        if (!detalleNovedades.isEmpty()) {
            detalleNovedades.forEach(e -> {
                this.modeloDetalle.addRow(this.datos);
                this.modeloDetalle.setValueAt(e.getDocumento(), this.JTDetalle.getRowCount() - 1, 0);
                this.modeloDetalle.setValueAt(e.getNombreEmpleado(), this.JTDetalle.getRowCount() - 1, 1);
                this.modeloDetalle.setValueAt(e.getNombreConcepto(), this.JTDetalle.getRowCount() - 1, 2);
                this.modeloDetalle.setValueAt(e.getFechaInicio(), this.JTDetalle.getRowCount() - 1, 3);
                this.modeloDetalle.setValueAt(e.getHoraInicio(), this.JTDetalle.getRowCount() - 1, 4);
                this.modeloDetalle.setValueAt(e.getFechaFin(), this.JTDetalle.getRowCount() - 1, 5);
                this.modeloDetalle.setValueAt(e.getHoraFin(), this.JTDetalle.getRowCount() - 1, 6);
                this.modeloDetalle.setValueAt(e.getCantidad(), this.JTDetalle.getRowCount() - 1, 7);
            });
        }
        if (!consolidadoNovedades.isEmpty()) {
            consolidadoNovedades.forEach(e2 -> {
                this.modeloConsolidado.addRow(this.datos);
                this.modeloConsolidado.setValueAt(e2.getDocumento(), this.JTConsolidado.getRowCount() - 1, 0);
                this.modeloConsolidado.setValueAt(e2.getNombreEmpleado(), this.JTConsolidado.getRowCount() - 1, 1);
                this.modeloConsolidado.setValueAt(e2.getNombreConcepto(), this.JTConsolidado.getRowCount() - 1, 2);
                this.modeloConsolidado.setValueAt(e2.getCantidad(), this.JTConsolidado.getRowCount() - 1, 3);
            });
        }
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPFiltroPro = new JPanel();
        this.JCBPeriodo = new JComboBox<>();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTP_Datos = new JTabbedPane();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME REGISTROS DE NOVEDADES");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifinformeregistronovedades");
        this.JPFiltroPro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPFiltroProLayout = new GroupLayout(this.JPFiltroPro);
        this.JPFiltroPro.setLayout(JPFiltroProLayout);
        JPFiltroProLayout.setHorizontalGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroProLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JCBPeriodo, -2, 412, -2).addContainerGap(-1, 32767)));
        JPFiltroProLayout.setVerticalGroup(JPFiltroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroProLayout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 50, -2).addContainerGap()));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.JIFInformeNovedadesRegistradas.3
            public void mouseClicked(MouseEvent evt) {
                JIFInformeNovedadesRegistradas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFInformeNovedadesRegistradas.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformeNovedadesRegistradas.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JSDetalle.setBorder((Border) null);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSDetalle.setViewportView(this.JTDetalle);
        this.JTP_Datos.addTab("DETALLE", this.JSDetalle);
        this.JSConsolidado.setBorder((Border) null);
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(Color.red);
        this.JSConsolidado.setViewportView(this.JTConsolidado);
        this.JTP_Datos.addTab("CONSOLIDADO", this.JSConsolidado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPFiltroPro, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 178, -2)).addComponent(this.JTP_Datos, -1, 1072, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPFiltroPro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTP_Datos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        pack();
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
        if (this.JTDetalle.getRowCount() > -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.JTP_Datos.getSelectedIndex() == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                } else {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTConsolidado, this.JTFRuta.getText(), getTitle());
                    return;
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }
}
