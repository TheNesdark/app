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
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFEstadisticaMuestrasNuevas.class */
public class JIFEstadisticaMuestrasNuevas extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private InformesLaboratorioDAO xInformesLaboratorioDAO;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JScrollPane JSPDetalle3;
    private JTable JTDetalle;
    private JFormattedTextField JTFFNRegistro;
    private JTextField JTFRuta;
    private JPanel jPanel1;

    public JIFEstadisticaMuestrasNuevas() {
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
        this.JTFFNRegistro.setText("0");
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha y Hora", "N° Recepción", "Documento", "Usuario", "Tèlefono", "Edad", "Sexo", "Eps", "Profesional", "Dx", "Procedimientos", "Abreviatura", "Municipio", "Urgente?", "Observacion"}) { // from class: com.genoma.plus.controller.laboratorio.JIFEstadisticaMuestrasNuevas.1
            Class[] types = {String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
    }

    public void mCargarDatosTabla() {
        List<Object[]> list = this.xInformesLaboratorioDAO.informeEstadisticamuestraNuevas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        mCrearModeloDatos();
        if (list.size() > 0) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(list.get(x)[0], x, 0);
                this.xmodelo.setValueAt(list.get(x)[1], x, 1);
                this.xmodelo.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list.get(x)[3], x, 3);
                this.xmodelo.setValueAt(list.get(x)[4], x, 4);
                this.xmodelo.setValueAt(list.get(x)[5], x, 5);
                this.xmodelo.setValueAt(list.get(x)[6], x, 6);
                this.xmodelo.setValueAt(list.get(x)[7], x, 7);
                this.xmodelo.setValueAt(list.get(x)[8], x, 8);
                this.xmodelo.setValueAt(list.get(x)[9], x, 9);
                this.xmodelo.setValueAt(list.get(x)[10], x, 10);
                this.xmodelo.setValueAt(list.get(x)[11], x, 11);
                this.xmodelo.setValueAt(list.get(x)[12], x, 12);
                this.xmodelo.setValueAt(list.get(x)[13], x, 13);
                this.xmodelo.setValueAt(list.get(x)[14], x, 14);
            }
            this.JTFFNRegistro.setText(String.valueOf(list.size()));
        }
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSPDetalle3 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JTFFNRegistro = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("Estadística de Muestras Nuevas");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifestadisticamuestrasnuevas");
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFEstadisticaMuestrasNuevas.2
            public void mouseClicked(MouseEvent evt) {
                JIFEstadisticaMuestrasNuevas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle3.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFEstadisticaMuestrasNuevas.3
            public void actionPerformed(ActionEvent evt) {
                JIFEstadisticaMuestrasNuevas.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFEstadisticaMuestrasNuevas.4
            public void mouseClicked(MouseEvent evt) {
                JIFEstadisticaMuestrasNuevas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFFNRegistro.setEditable(false);
        this.JTFFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Dialog", 1, 12), new Color(0, 103, 0)));
        this.JTFFNRegistro.setFont(new Font("Arial", 1, 12));
        this.JTFFNRegistro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFEstadisticaMuestrasNuevas.5
            public void actionPerformed(ActionEvent evt) {
                JIFEstadisticaMuestrasNuevas.this.JTFFNRegistroActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JTFFNRegistro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 486, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 161, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFNRegistro, -2, 50, -2).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(0, 0, 32767)).addComponent(this.JSPDetalle3, GroupLayout.Alignment.TRAILING, -1, 847, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle3, -2, 312, -2).addGap(7, 7, 7).addComponent(this.jPanel1, -2, -1, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
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
    public void JTFFNRegistroActionPerformed(ActionEvent evt) {
    }
}
