package com.genoma.plus.controller.sig;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.InformeCitasAtendidasDAOImpl;
import com.genoma.plus.dao.sig.InformeCitasAtendidasDAO;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFInformeCitasAtendidas.class */
public class JIFInformeCitasAtendidas extends JInternalFrame {
    private DefaultTableModel xmodeloP;
    private DefaultTableModel xmodeloNP;
    private Object[] xdatos;
    private InformeCitasAtendidasDAO xInformeCitasAtendidasDAO;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JScrollPane JSPNoProgramadas;
    private JScrollPane JSPProgramadas;
    private JTextField JTFRuta;
    private JTable JTNoProgramadas;
    private JTabbedPane JTPMenu;
    private JTable JTProgramadas;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private String xEstado = "0";

    public JIFInformeCitasAtendidas() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformeCitasAtendidasDAO = (InformeCitasAtendidasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informeCitasAtendidasDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloDatosProgramadas();
        mCrearModeloDatosNoProgramadas();
        this.JDFechaI.requestFocus();
    }

    public void mBuscar() {
        mCargarDatosTablaProgramadas();
        mCargarDatosTablaNoProgramadas();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosProgramadas() {
        this.xmodeloP = new DefaultTableModel(new Object[0], new String[]{"Documento", "Usuario", "Sexo", "Clase de Cita", "Convenio", "IPS", "Fecha", "Hora", "Especialidad", "Profesional", "Estado", "No. Ingreso", "No. Factura", "No. Servicio", "DxP", "Diagnostico", "Teléfono"}) { // from class: com.genoma.plus.controller.sig.JIFInformeCitasAtendidas.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTProgramadas;
        JTable jTable2 = this.JTProgramadas;
        jTable.setAutoResizeMode(0);
        this.JTProgramadas.doLayout();
        this.JTProgramadas.setModel(this.xmodeloP);
        this.JTProgramadas.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTProgramadas.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTProgramadas.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTProgramadas.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTProgramadas.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTProgramadas.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTProgramadas.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTProgramadas.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTProgramadas.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTProgramadas.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTProgramadas.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTProgramadas.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTProgramadas.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTProgramadas.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTProgramadas.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTProgramadas.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTProgramadas.getColumnModel().getColumn(16).setPreferredWidth(200);
    }

    private void mCargarDatosTablaProgramadas() {
        List<Object[]> list = this.xInformeCitasAtendidasDAO.mListarCitasProgramas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        mCrearModeloDatosProgramadas();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodeloP.addRow(this.xdatos);
                this.xmodeloP.setValueAt(list.get(x)[0], x, 0);
                this.xmodeloP.setValueAt(list.get(x)[1], x, 1);
                this.xmodeloP.setValueAt(list.get(x)[2], x, 2);
                this.xmodeloP.setValueAt(list.get(x)[3], x, 3);
                this.xmodeloP.setValueAt(list.get(x)[4], x, 4);
                this.xmodeloP.setValueAt(list.get(x)[5], x, 5);
                this.xmodeloP.setValueAt(list.get(x)[6], x, 6);
                this.xmodeloP.setValueAt(list.get(x)[7], x, 7);
                this.xmodeloP.setValueAt(list.get(x)[8], x, 8);
                this.xmodeloP.setValueAt(list.get(x)[9], x, 9);
                this.xmodeloP.setValueAt(list.get(x)[10], x, 10);
                this.xmodeloP.setValueAt(list.get(x)[11], x, 11);
                this.xmodeloP.setValueAt(list.get(x)[12], x, 12);
                this.xmodeloP.setValueAt(list.get(x)[13], x, 13);
                this.xmodeloP.setValueAt(list.get(x)[14], x, 14);
                this.xmodeloP.setValueAt(list.get(x)[15], x, 15);
                this.xmodeloP.setValueAt(list.get(x)[16], x, 16);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosNoProgramadas() {
        this.xmodeloNP = new DefaultTableModel(new Object[0], new String[]{"Documento", "Usuario", "Sexo", "Clase de Cita", "Convenio", "IPS", "Fecha", "Hora", "Especialidad", "Profesional", "Estado", "No. Ingreso", "No. Factura", "No. Servicio", "DxP", "Diagnostico", "Teléfono"}) { // from class: com.genoma.plus.controller.sig.JIFInformeCitasAtendidas.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTNoProgramadas;
        JTable jTable2 = this.JTNoProgramadas;
        jTable.setAutoResizeMode(0);
        this.JTNoProgramadas.doLayout();
        this.JTNoProgramadas.setModel(this.xmodeloNP);
        this.JTNoProgramadas.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTNoProgramadas.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTNoProgramadas.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTNoProgramadas.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTNoProgramadas.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTNoProgramadas.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTNoProgramadas.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTNoProgramadas.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTNoProgramadas.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTNoProgramadas.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTNoProgramadas.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTNoProgramadas.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTNoProgramadas.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTNoProgramadas.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTNoProgramadas.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTNoProgramadas.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTNoProgramadas.getColumnModel().getColumn(16).setPreferredWidth(200);
    }

    private void mCargarDatosTablaNoProgramadas() {
        List<Object[]> list = this.xInformeCitasAtendidasDAO.mListarCitasNoProgramas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        mCrearModeloDatosNoProgramadas();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodeloNP.addRow(this.xdatos);
                this.xmodeloNP.setValueAt(list.get(x)[0], x, 0);
                this.xmodeloNP.setValueAt(list.get(x)[1], x, 1);
                this.xmodeloNP.setValueAt(list.get(x)[2], x, 2);
                this.xmodeloNP.setValueAt(list.get(x)[3], x, 3);
                this.xmodeloNP.setValueAt(list.get(x)[4], x, 4);
                this.xmodeloNP.setValueAt(list.get(x)[5], x, 5);
                this.xmodeloNP.setValueAt(list.get(x)[6], x, 6);
                this.xmodeloNP.setValueAt(list.get(x)[7], x, 7);
                this.xmodeloNP.setValueAt(list.get(x)[8], x, 8);
                this.xmodeloNP.setValueAt(list.get(x)[9], x, 9);
                this.xmodeloNP.setValueAt(list.get(x)[10], x, 10);
                this.xmodeloNP.setValueAt(list.get(x)[11], x, 11);
                this.xmodeloNP.setValueAt(list.get(x)[12], x, 12);
                this.xmodeloNP.setValueAt(list.get(x)[13], x, 13);
                this.xmodeloNP.setValueAt(list.get(x)[14], x, 14);
                this.xmodeloNP.setValueAt(list.get(x)[15], x, 15);
                this.xmodeloNP.setValueAt(list.get(x)[16], x, 16);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jPanel1 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTPMenu = new JTabbedPane();
        this.JSPProgramadas = new JScrollPane();
        this.JTProgramadas = new JTable();
        this.JSPNoProgramadas = new JScrollPane();
        this.JTNoProgramadas = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE CITAS ATENDIDAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformedecitasatendidas");
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFInformeCitasAtendidas.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeCitasAtendidas.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFInformeCitasAtendidas.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeCitasAtendidas.this.JDFechaFPropertyChange(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformeCitasAtendidas.5
            public void mouseClicked(MouseEvent evt) {
                JIFInformeCitasAtendidas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformeCitasAtendidas.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformeCitasAtendidas.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 198, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(0, 16, 32767)));
        this.JTPMenu.setForeground(Color.red);
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JTProgramadas.setFont(new Font("Arial", 1, 12));
        this.JTProgramadas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTProgramadas.setRowHeight(25);
        this.JTProgramadas.setSelectionBackground(new Color(255, 255, 255));
        this.JTProgramadas.setSelectionForeground(Color.red);
        this.JTProgramadas.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformeCitasAtendidas.7
            public void mouseClicked(MouseEvent evt) {
                JIFInformeCitasAtendidas.this.JTProgramadasMouseClicked(evt);
            }
        });
        this.JSPProgramadas.setViewportView(this.JTProgramadas);
        this.JTPMenu.addTab("PROGRAMADAS", this.JSPProgramadas);
        this.JTNoProgramadas.setFont(new Font("Arial", 1, 12));
        this.JTNoProgramadas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTNoProgramadas.setSelectionBackground(Color.white);
        this.JTNoProgramadas.setSelectionForeground(Color.red);
        this.JSPNoProgramadas.setViewportView(this.JTNoProgramadas);
        this.JTPMenu.addTab("NO PROGRAMADAS", this.JSPNoProgramadas);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPMenu, -1, 983, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(0, 0, 32767)).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPMenu, -1, 339, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProgramadasMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
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
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JTPMenu.getSelectedIndex() == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTProgramadas, this.JTFRuta.getText(), this.title + " - " + this.JTPMenu.getTitleAt(0));
            } else {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTNoProgramadas, this.JTFRuta.getText(), this.title + " - " + this.JTPMenu.getTitleAt(1));
            }
        }
    }
}
