package com.genoma.plus.controller.rrhh;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.rrhh.InformeCgrDAOImpl;
import com.genoma.plus.dao.rrhh.InformeCgrDAO;
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
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JIFNominaInformeCgr.class */
public class JIFNominaInformeCgr extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private InformeCgrDAO xInformeCgrDAO;
    private JButton JBTExportar;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JScrollPane JSDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;

    public JIFNominaInformeCgr() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformeCgrDAO = (InformeCgrDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informeCgrDAO");
    }

    public void mNuevo() {
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloTablaDetalle();
    }

    public void mBuscar() {
        mCargarDatosTablaDetalle();
    }

    private void mCrearModeloTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Identificacion", "No. Documento", "Empleado", "Cargo", "Nombre D758", "Codigo", "Grado", "Nombre Columna", "ColumnaI", "ColumnaJ", "ColumnaK", "ColumnaL", "ColumnaM", "ColumnaN", "ColumnaO", "ColumnaP", "ColumnaQ", "ColumnaR", "ColumnaS", "ColumnaT", "ColumnaU", "ColumnaV", "ColumnaW", "ColumnaX", "ColumnaY", "ColumnaZ", "ColumnaAA", "ColumnaAB", "ColumnaAC"}) { // from class: com.genoma.plus.controller.rrhh.JIFNominaInformeCgr.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(120);
    }

    public void mCargarDatosTablaDetalle() {
        mCrearModeloTablaDetalle();
        List<Object[]> list = this.xInformeCgrDAO.mListaNomina(this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()), this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()));
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
            this.xmodelo.setValueAt(list.get(x)[15], x, 15);
            this.xmodelo.setValueAt(list.get(x)[16], x, 16);
            this.xmodelo.setValueAt(list.get(x)[17], x, 17);
            this.xmodelo.setValueAt(list.get(x)[18], x, 18);
            this.xmodelo.setValueAt(list.get(x)[19], x, 19);
            this.xmodelo.setValueAt(list.get(x)[20], x, 20);
            this.xmodelo.setValueAt(list.get(x)[21], x, 21);
            this.xmodelo.setValueAt(list.get(x)[22], x, 22);
            this.xmodelo.setValueAt(list.get(x)[23], x, 23);
            this.xmodelo.setValueAt(list.get(x)[24], x, 24);
            this.xmodelo.setValueAt(list.get(x)[25], x, 25);
            this.xmodelo.setValueAt(list.get(x)[26], x, 26);
            this.xmodelo.setValueAt(list.get(x)[27], x, 27);
            this.xmodelo.setValueAt(list.get(x)[28], x, 28);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME CGR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifnominainformecgr");
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.JIFNominaInformeCgr.2
            public void mouseClicked(MouseEvent evt) {
                JIFNominaInformeCgr.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFNominaInformeCgr.3
            public void actionPerformed(ActionEvent evt) {
                JIFNominaInformeCgr.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.rrhh.JIFNominaInformeCgr.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFNominaInformeCgr.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.rrhh.JIFNominaInformeCgr.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFNominaInformeCgr.this.JDCFechaFinPropertyChange(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 120, -2).addGap(0, 738, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 178, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 50, -2).addComponent(this.JDCFechaFin, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -2, 460, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(11, 32767)));
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
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
    }
}
