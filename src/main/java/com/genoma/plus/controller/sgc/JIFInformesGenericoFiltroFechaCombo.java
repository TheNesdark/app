package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.jpa.projection.IInformeAtencionPorServicio;
import com.genoma.plus.jpa.service.EstadoAtencionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFInformesGenericoFiltroFechaCombo.class */
public class JIFInformesGenericoFiltroFechaCombo extends JInternalFrame {
    private DefaultTableModel modelo;
    private Object[] dato;
    private WorkerSQL xWorkerSQL;
    private String[] xidEmpresa;
    private String titulo;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos3;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;
    private JFormattedTextField JTFFNRegistro;
    private JTextField JTFRuta;
    private Metodos metodo = new Metodos();
    private final EstadoAtencionService estadoAtencionService = (EstadoAtencionService) Principal.contexto.getBean(EstadoAtencionService.class);
    private int xlleno = 0;

    public JIFInformesGenericoFiltroFechaCombo(String titulo, String nombre) {
        initComponents();
        setTitle(titulo.toUpperCase());
        setName(nombre);
        this.titulo = titulo;
        nuevo();
    }

    public void nuevo() {
        this.JDFechaI.setDate(this.metodo.getFechaActual());
        this.JDFechaF.setDate(this.metodo.getFechaActual());
        this.JTFRuta.setText(this.metodo.getDirectorioExportacion() + "Planilla");
        creaModeloTablaInformeAtencionServicio();
        this.JCBEmpresa.setVisible(false);
        this.JCHFiltro.setVisible(false);
        this.JTFFNRegistro.setText("0");
    }

    private void mCastModeloTabla() {
        creaModeloTablaInformeAtencionServicio();
    }

    private void creaModeloTablaInformeAtencionServicio() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Servicio", "Especialidad", "Profesional", "Cantidad"}) { // from class: com.genoma.plus.controller.sgc.JIFInformesGenericoFiltroFechaCombo.1
            Class[] types = {String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    public void buscar() {
        cargarDatosInformeAtencionServicio();
    }

    public void cargarDatosInformeAtencionServicio() {
        List<IInformeAtencionPorServicio> list;
        if (this.JCHFiltro.isSelected()) {
            list = this.estadoAtencionService.listaInformeAtencionesPorServicios(this.metodo.formatoAMD1.format(this.JDFechaI.getDate()), this.metodo.formatoAMD1.format(this.JDFechaF.getDate()));
        } else {
            list = this.estadoAtencionService.listaInformeAtencionesPorServicios(this.metodo.formatoAMD1.format(this.JDFechaI.getDate()), this.metodo.formatoAMD1.format(this.JDFechaF.getDate()));
        }
        creaModeloTablaInformeAtencionServicio();
        for (int x = 0; x < list.size(); x++) {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(list.get(x).getServicio(), x, 0);
            this.modelo.setValueAt(list.get(x).getEspecialidad(), x, 1);
            this.modelo.setValueAt(list.get(x).getProfesional(), x, 2);
            this.modelo.setValueAt(list.get(x).getCantidad(), x, 3);
        }
        this.JTFFNRegistro.setText(String.valueOf(list.size()));
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos3 = new JPanel();
        this.JCBEmpresa = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFFNRegistro = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifinformegenericofechas");
        this.JPIDatos3.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Filtrar?");
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatos3Layout = new GroupLayout(this.JPIDatos3);
        this.JPIDatos3.setLayout(JPIDatos3Layout);
        JPIDatos3Layout.setHorizontalGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos3Layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, 0, 686, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addGap(26, 26, 26)));
        JPIDatos3Layout.setVerticalGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatos3Layout.createSequentialGroup().addGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEmpresa, GroupLayout.Alignment.LEADING, -2, 52, -2).addComponent(this.JCHFiltro))).addGap(17, 17, 17)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setAutoscrolls(true);
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setCellSelectionEnabled(true);
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFFNRegistro.setEditable(false);
        this.JTFFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JTFFNRegistro.setHorizontalAlignment(0);
        this.JTFFNRegistro.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFInformesGenericoFiltroFechaCombo.2
            public void mouseClicked(MouseEvent evt) {
                JIFInformesGenericoFiltroFechaCombo.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFInformesGenericoFiltroFechaCombo.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformesGenericoFiltroFechaCombo.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIDatos3, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFFNRegistro, -2, 152, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 543, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 199, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos3, -2, -1, -2).addGap(1, 1, 1).addComponent(this.JSPDetalle, -2, 417, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFFNRegistro, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodo.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }
}
