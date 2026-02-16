package com.genoma.plus.controller.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.sgc.SC_EstaditicadeConsulta;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFEstadisticaCitas.class */
public class JIFEstadisticaCitas extends JInternalFrame {
    public SC_EstaditicadeConsulta xSC_EstaditicadeConsulta;
    private Metodos xmt = new Metodos();
    private DefaultTableModel xModeloE;
    private DefaultTableModel xModeloC;
    private DefaultTableModel xModeloConsolidado;
    private Object[] xDatoC;
    private Object[] xDatoE;
    private Object[] xDatosConsolidado;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalleConsolidado;
    private JScrollPane JSPDetalleConsolidado1;
    private JScrollPane JSPDetalleEspecialidad;
    private JTable JTDetalleC;
    private JTable JTDetalleConsolidado;
    private JTable JTDetalleE;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTable jTable1;

    public JIFEstadisticaCitas() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v100, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v84, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.JSPDetalleConsolidado1 = new JScrollPane();
        this.JTDetalleConsolidado = new JTable();
        this.jPanel2 = new JPanel();
        this.JSPDetalleConsolidado = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.jPanel1 = new JPanel();
        this.JSPDetalleEspecialidad = new JScrollPane();
        this.JTDetalleE = new JTable();
        this.jPanel4 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        setClosable(true);
        setTitle("Estadistica De Citas");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFEstadisticaCitas");
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFEstadisticaCitas.1
            public void mouseClicked(MouseEvent evt) {
                JIFEstadisticaCitas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFEstadisticaCitas.2
            public void actionPerformed(ActionEvent evt) {
                JIFEstadisticaCitas.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 462, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 225, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING)).addGap(0, 10, 32767)));
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
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addContainerGap(26, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGap(10, 10, 10)));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleConsolidado1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleConsolidado1.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalleConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTDetalleConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleConsolidado.setAutoResizeMode(0);
        this.JSPDetalleConsolidado1.setViewportView(this.JTDetalleConsolidado);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1039, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleConsolidado1, -2, 0, 32767).addContainerGap())));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 472, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleConsolidado1, -1, 448, 32767).addContainerGap())));
        this.jTabbedPane1.addTab("CONSOLIDADO", this.jPanel3);
        this.jPanel2.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleConsolidado.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setAutoResizeMode(0);
        this.JSPDetalleConsolidado.setViewportView(this.JTDetalleC);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1039, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleConsolidado, -2, 0, 32767).addContainerGap())));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 472, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleConsolidado, -1, 448, 32767).addContainerGap())));
        this.jTabbedPane1.addTab("ESPECIALIDADES", this.jPanel2);
        this.JSPDetalleEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleEspecialidad.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalleE.setFont(new Font("Arial", 1, 12));
        this.JTDetalleE.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleE.setAutoResizeMode(0);
        this.JSPDetalleEspecialidad.setViewportView(this.JTDetalleE);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1039, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleEspecialidad, -2, 0, 32767).addContainerGap())));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 515, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleEspecialidad, -2, 491, -2).addContainerGap(-1, 32767))));
        this.jTabbedPane1.addTab("CLASES DE CITAS", this.jPanel1);
        this.jTable1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane1.setViewportView(this.jTable1);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(117, 117, 117).addComponent(this.jScrollPane1, -2, -1, -2).addContainerGap(470, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jScrollPane1, -2, -1, -2).addGap(32, 32, 32)));
        this.jTabbedPane1.addTab("tab4", this.jPanel4);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 314, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPExportar, -1, -1, 32767))).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPExportar, -1, -1, 32767).addComponent(this.JPDatos, -2, 84, 32767)).addGap(5, 5, 5).addComponent(this.jTabbedPane1, -2, 506, -2).addGap(5, 5, 5)));
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
        if (this.JTDetalleC.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3);
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleC, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    private void springStart() {
        this.xSC_EstaditicadeConsulta = (SC_EstaditicadeConsulta) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sC_EstaditicadeConsultaDAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloConsolidado();
        mCrearModeloEspecialidad();
    }

    public void mBuscar() {
        mBUscarConsolidadoCita();
        mBUscarConsolidadoCitaEpecialidad();
        mBUscarConsolidadoCitaGlobal();
    }

    private void mCrearModeloConsolidado() {
        this.xModeloC = new DefaultTableModel((Object[][]) null, new String[]{"Empresa", "Especialidad", "Cantidad"}) { // from class: com.genoma.plus.controller.sgc.JIFEstadisticaCitas.3
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleC.setModel(this.xModeloC);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(400);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void mBUscarConsolidadoCita() {
        mCrearModeloConsolidado();
        List<Object[]> list = this.xSC_EstaditicadeConsulta.informeConsolidadoCitasPyP(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        for (int x = 0; x < list.size(); x++) {
            this.xModeloC.addRow(this.xDatoC);
            this.xModeloC.setValueAt(list.get(x)[0], x, 0);
            this.xModeloC.setValueAt(list.get(x)[1], x, 1);
            this.xModeloC.setValueAt(list.get(x)[2], x, 2);
        }
    }

    private void mCrearModeloEspecialidad() {
        this.xModeloE = new DefaultTableModel((Object[][]) null, new String[]{"Empresa", "Cita", "Cantidad"}) { // from class: com.genoma.plus.controller.sgc.JIFEstadisticaCitas.4
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleE.setModel(this.xModeloE);
        this.JTDetalleE.getColumnModel().getColumn(0).setPreferredWidth(400);
        this.JTDetalleE.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalleE.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void mBUscarConsolidadoCitaEpecialidad() {
        mCrearModeloEspecialidad();
        List<Object[]> list = this.xSC_EstaditicadeConsulta.informeConsolidadoCitaEspecialidad(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        for (int x = 0; x < list.size(); x++) {
            this.xModeloE.addRow(this.xDatoE);
            this.xModeloE.setValueAt(list.get(x)[0], x, 0);
            this.xModeloE.setValueAt(list.get(x)[1], x, 1);
            this.xModeloE.setValueAt(list.get(x)[2], x, 2);
        }
    }

    private void mCrearModeloConsolidadoCitas() {
        this.xModeloConsolidado = new DefaultTableModel((Object[][]) null, new String[]{"Empresa", "Cantidad"}) { // from class: com.genoma.plus.controller.sgc.JIFEstadisticaCitas.5
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleConsolidado.setModel(this.xModeloConsolidado);
        this.JTDetalleConsolidado.getColumnModel().getColumn(0).setPreferredWidth(400);
        this.JTDetalleConsolidado.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    private void mBUscarConsolidadoCitaGlobal() {
        mCrearModeloConsolidadoCitas();
        List<Object[]> list = this.xSC_EstaditicadeConsulta.informeConsolidadoCitaConsolidados(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        for (int x = 0; x < list.size(); x++) {
            this.xModeloConsolidado.addRow(this.xDatosConsolidado);
            this.xModeloConsolidado.setValueAt(list.get(x)[0], x, 0);
            this.xModeloConsolidado.setValueAt(list.get(x)[1], x, 1);
        }
    }
}
