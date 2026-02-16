package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformeConsolidadoEgresosEdadesProjection;
import com.genoma.plus.jpa.projection.IInformeDeProduccion2193Projection;
import com.genoma.plus.jpa.service.IngresoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_RProduccionRes2193_V1.class */
public class JIF_RProduccionRes2193_V1 extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private Object[] xDatoF;
    private List<Object[]> listConvenio;
    private String nombre;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBLCont;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JPanel jPanel3;
    private Metodos xmt = new Metodos();
    private Boolean xy = false;
    private final IngresoService ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);

    public JIF_RProduccionRes2193_V1(String titulo) {
        initComponents();
        setTitle(titulo.toUpperCase());
        nuevo();
    }

    public void nuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        if (getTitle().equals("Producción (Resolución 2193)".toUpperCase()) || getTitle().equals("Producción (Resolución 2193) Entidad Privada".toUpperCase())) {
            crearModeloTotalConsulta();
        } else if (getTitle().equals("Consolidado Egresos por Edades".toUpperCase())) {
            crearModeloConsolidadoEgresoEdades();
        }
        this.JLBLCont.setText("0");
    }

    private void crearModeloTotalConsulta() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Concepto", "Pobre", "No_POSS", "Subsidiado", "Contributivo", "Otros"}) { // from class: com.genoma.plus.controller.sgc.JIF_RProduccionRes2193_V1.1
            Class[] types = {String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(650);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void crearModeloConsolidadoEgresoEdades() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Grupo Población", "Estancia_Pobre", "Egreso_Pobre", "Estancia_Subsidiado", "Egreso_Subsidiado", "Estancia_Contributivo", "Egreso_Contributivo", "Estancia_Otro", "Egreso_Otro"}) { // from class: com.genoma.plus.controller.sgc.JIF_RProduccionRes2193_V1.2
            Class[] types = {String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
    }

    private void cargarDatosTabla() {
        List<IInformeDeProduccion2193Projection> list;
        new ArrayList();
        crearModeloTotalConsulta();
        if (getTitle().equals("Producción (Resolución 2193) Entidad Privada".toUpperCase())) {
            list = this.ingresoService.informeProduccion2193EntidadPrivada(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        } else {
            list = this.ingresoService.informeProduccion2193(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        }
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 0);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getVariable(), x, 0);
            this.xModelo.setValueAt(list.get(x).getPobre(), x, 1);
            this.xModelo.setValueAt(list.get(x).getNo_POSS(), x, 2);
            this.xModelo.setValueAt(list.get(x).getSubsidiado(), x, 3);
            this.xModelo.setValueAt(list.get(x).getContributivo(), x, 4);
            this.xModelo.setValueAt(list.get(x).getOtro(), x, 5);
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void cargarDatosTablaConsolidadoEgresoEdades() {
        crearModeloConsolidadoEgresoEdades();
        List<IInformeConsolidadoEgresosEdadesProjection> list = this.ingresoService.informeConsolidadoEgresoPorEdades(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 0);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getGrupo_Poblacion(), x, 0);
            this.xModelo.setValueAt(list.get(x).getEstancia_Pobre(), x, 1);
            this.xModelo.setValueAt(list.get(x).getEgreso_Pobre(), x, 2);
            this.xModelo.setValueAt(list.get(x).getEstancia_Subsidiado(), x, 3);
            this.xModelo.setValueAt(list.get(x).getEgreso_Subsidiado(), x, 4);
            this.xModelo.setValueAt(list.get(x).getEstancia_Contributivo(), x, 5);
            this.xModelo.setValueAt(list.get(x).getEgreso_Contributivo(), x, 6);
            this.xModelo.setValueAt(list.get(x).getEstancia_Otro(), x, 7);
            this.xModelo.setValueAt(list.get(x).getEgreso_Otro(), x, 8);
        }
        this.JLBLCont.setText(list.size() + "");
    }

    public void buscar() {
        if (getTitle().equals("Producción (Resolución 2193)".toUpperCase()) || getTitle().equals("Producción (Resolución 2193) Entidad Privada".toUpperCase())) {
            cargarDatosTabla();
        } else if (getTitle().equals("Consolidado Egresos por Edades".toUpperCase())) {
            cargarDatosTablaConsolidadoEgresoEdades();
        }
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel3 = new JPanel();
        this.JLBLCont = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE PRODUCCIÓN (Resolución 2193)");
        setToolTipText("");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_ReporteProduccion2193_V1");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addContainerGap(16, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_RProduccionRes2193_V1.3
            public void mouseClicked(MouseEvent evt) {
                JIF_RProduccionRes2193_V1.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_RProduccionRes2193_V1.4
            public void actionPerformed(ActionEvent evt) {
                JIF_RProduccionRes2193_V1.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_RProduccionRes2193_V1.5
            public void actionPerformed(ActionEvent evt) {
                JIF_RProduccionRes2193_V1.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 467, -2).addGap(0, 0, 0).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2)).addContainerGap(16, 32767)));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Total de registros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBLCont.setFont(new Font("Arial", 1, 36));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JLBLCont, -2, 197, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBLCont).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 0, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 312, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPExportar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -2, 87, -2).addComponent(this.JPExportar, -2, -1, -2).addComponent(this.jPanel3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 472, -2).addContainerGap(-1, 32767)));
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFRuta.requestFocus();
    }
}
