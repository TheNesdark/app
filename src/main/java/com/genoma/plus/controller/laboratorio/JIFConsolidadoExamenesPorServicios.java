package com.genoma.plus.controller.laboratorio;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.InformesLaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.InformesLaboratorioDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFConsolidadoExamenesPorServicios.class */
public class JIFConsolidadoExamenesPorServicios extends JInternalFrame {
    private InformesLaboratorioDAO xInformesLaboratorioDAO;
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private Object[] xdatos1;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDetalleA;
    private JPanel JPDetalleS;
    private JPanel JPExportar;
    private JScrollPane JSPDetalle3;
    private JScrollPane JSPDetalle4;
    private JTable JTDetalle;
    private JTable JTDetalleServicios;
    private JTabbedPane JTExport;
    private JTextField JTFRuta;

    public JIFConsolidadoExamenesPorServicios() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformesLaboratorioDAO = (InformesLaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesLaboratorioDAO");
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        mCrearModeloDatos();
        mCrearModeloDatosServicio();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JPExportar = new JPanel();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JTExport = new JTabbedPane();
        this.JPDetalleA = new JPanel();
        this.JSPDetalle3 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPDetalleS = new JPanel();
        this.JSPDetalle4 = new JScrollPane();
        this.JTDetalleServicios = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSOLIDADO DE EXAMENES POR SERVICIO");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjConsolidoExamenesPorServicio");
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFConsolidadoExamenesPorServicios.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoExamenesPorServicios.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFConsolidadoExamenesPorServicios.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoExamenesPorServicios.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 161, -2).addContainerGap()));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -1, 50, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        this.JTExport.setForeground(Color.red);
        this.JTExport.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFConsolidadoExamenesPorServicios.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoExamenesPorServicios.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle3.setViewportView(this.JTDetalle);
        GroupLayout JPDetalleALayout = new GroupLayout(this.JPDetalleA);
        this.JPDetalleA.setLayout(JPDetalleALayout);
        JPDetalleALayout.setHorizontalGroup(JPDetalleALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle3, -1, 849, 32767));
        JPDetalleALayout.setVerticalGroup(JPDetalleALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalleALayout.createSequentialGroup().addComponent(this.JSPDetalle3, -2, 271, -2).addGap(0, 0, 32767)));
        this.JTExport.addTab("AMBULATORIO", this.JPDetalleA);
        this.JTDetalleServicios.setFont(new Font("Arial", 1, 12));
        this.JTDetalleServicios.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleServicios.setRowHeight(25);
        this.JTDetalleServicios.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleServicios.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleServicios.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFConsolidadoExamenesPorServicios.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoExamenesPorServicios.this.JTDetalleServiciosMouseClicked(evt);
            }
        });
        this.JSPDetalle4.setViewportView(this.JTDetalleServicios);
        GroupLayout JPDetalleSLayout = new GroupLayout(this.JPDetalleS);
        this.JPDetalleS.setLayout(JPDetalleSLayout);
        JPDetalleSLayout.setHorizontalGroup(JPDetalleSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle4, -1, 849, 32767));
        JPDetalleSLayout.setVerticalGroup(JPDetalleSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalleSLayout.createSequentialGroup().addComponent(this.JSPDetalle4, -2, 271, -2).addGap(0, 0, 32767)));
        this.JTExport.addTab("URGENCIA-HOSPITALIZACION", this.JPDetalleS);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JDFechaF, -2, 120, -2)).addComponent(this.JPExportar, -1, -1, 32767).addComponent(this.JTExport)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -2, -1, -2).addComponent(this.JDFechaI, -1, -1, 32767)).addGap(10, 10, 10).addComponent(this.JTExport, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPExportar, -2, -1, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTExport.getSelectedIndex() == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        } else {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleServicios, this.JTFRuta.getText(), getTitle());
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleServiciosMouseClicked(MouseEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Entidad", "Codigo", "Procedimiento", "Cantidad"}) { // from class: com.genoma.plus.controller.laboratorio.JIFConsolidadoExamenesPorServicios.5
            Class[] types = {String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    public void mCargarDatosTabla() {
        List<Object[]> list = this.xInformesLaboratorioDAO.informeEstadisticaExamenesPorServiciosAmbulatoria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        mCrearModeloDatos();
        if (list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(list.get(x)[0], x, 0);
                this.xmodelo.setValueAt(list.get(x)[1], x, 1);
                this.xmodelo.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list.get(x)[3], x, 3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosServicio() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Entidad", "Servicio", "Codigo", "Procedimiento", "Cantidad"}) { // from class: com.genoma.plus.controller.laboratorio.JIFConsolidadoExamenesPorServicios.6
            Class[] types = {String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleServicios;
        JTable jTable2 = this.JTDetalleServicios;
        jTable.setAutoResizeMode(0);
        this.JTDetalleServicios.doLayout();
        this.JTDetalleServicios.setModel(this.xmodelo1);
        this.JTDetalleServicios.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleServicios.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleServicios.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleServicios.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalleServicios.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    public void mCargarDatosTablaServicio() {
        List<Object[]> list = this.xInformesLaboratorioDAO.informeEstadisticaExamenesPorServicios(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        mCrearModeloDatosServicio();
        if (list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo1.addRow(this.xdatos1);
                this.xmodelo1.setValueAt(list.get(x)[0], x, 0);
                this.xmodelo1.setValueAt(list.get(x)[1], x, 1);
                this.xmodelo1.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo1.setValueAt(list.get(x)[3], x, 3);
                this.xmodelo1.setValueAt(list.get(x)[4], x, 4);
            }
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
        mCargarDatosTablaServicio();
    }
}
