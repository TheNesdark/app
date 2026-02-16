package com.genoma.plus.controller.rrhh;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.rrhh.ConsolidadoPersonalDAOImpl;
import com.genoma.plus.dao.rrhh.ConsolidadoPersonalDAO;
import com.genoma.plus.dto.rrhh.ConsolidadoPersonalDTO;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JIFConsolidadoPersonal.class */
public class JIFConsolidadoPersonal extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodeloD;
    private DefaultTableModel xmodelo2193;
    private Object[] xdatos;
    private ConsolidadoPersonalDAO xConsolidadoPersonalDAO;
    private JButton JBTExportar;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JScrollPane JSP2193;
    private JScrollPane JSPDetalle;
    private JTable JT2193;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPOpciones;

    public JIFConsolidadoPersonal() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xConsolidadoPersonalDAO = (ConsolidadoPersonalDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consolidadoPersonalDAO");
    }

    public void mNuevo() {
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloTablaDetalle();
        mCrearModeloTabla2193();
    }

    public void mBuscar() {
        mCargarDatosTablaDetalle();
        mCargarDatosTabla2193();
    }

    private void mCrearModeloTablaDetalle() {
        this.xmodeloD = new DefaultTableModel((Object[][]) null, new String[]{"Codigo", "Grado", "Nombre Funcionario", "Salario Basico"}) { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoPersonal.1
            Class[] types = {String.class, String.class, String.class, Double.class};
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
        this.JTDetalle.setModel(this.xmodeloD);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
    }

    public void mCargarDatosTablaDetalle() {
        mCrearModeloTablaDetalle();
        List<ConsolidadoPersonalDTO> list = this.xConsolidadoPersonalDAO.listConsolidadoPersonal(this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()), this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()));
        for (int x = 0; x < list.size(); x++) {
            this.xmodeloD.addRow(this.xdatos);
            this.xmodeloD.setValueAt(list.get(x).getCodigo(), x, 0);
            this.xmodeloD.setValueAt(list.get(x).getGrado(), x, 1);
            this.xmodeloD.setValueAt(list.get(x).getUsuario(), x, 2);
            this.xmodeloD.setValueAt(list.get(x).getSalarioB(), x, 3);
        }
    }

    private void mCrearModeloTabla2193() {
        this.xmodelo2193 = new DefaultTableModel((Object[][]) null, new String[]{"Codigo", "Grado", "Nombre Funcionario", "Salario Basico", "Salario Anual"}) { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoPersonal.2
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JT2193;
        JTable jTable2 = this.JT2193;
        jTable.setAutoResizeMode(0);
        this.JT2193.doLayout();
        this.JT2193.setModel(this.xmodelo2193);
        this.JT2193.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JT2193.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JT2193.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JT2193.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JT2193.getColumnModel().getColumn(4).setPreferredWidth(150);
    }

    public void mCargarDatosTabla2193() {
        mCrearModeloTabla2193();
        List<ConsolidadoPersonalDTO> list = this.xConsolidadoPersonalDAO.listInformePersonal2193(this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()), this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()));
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo2193.addRow(this.xdatos);
            this.xmodelo2193.setValueAt(list.get(x).getCodigo(), x, 0);
            this.xmodelo2193.setValueAt(list.get(x).getGrado(), x, 1);
            this.xmodelo2193.setValueAt(list.get(x).getUsuario(), x, 2);
            this.xmodelo2193.setValueAt(list.get(x).getSalarioB(), x, 3);
            this.xmodelo2193.setValueAt(list.get(x).getSalarioT(), x, 4);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPOpciones = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSP2193 = new JScrollPane();
        this.JT2193 = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO PERSONAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsolidadopersonal");
        this.JTPOpciones.setForeground(Color.red);
        this.JTPOpciones.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPOpciones.addTab("DATOS", this.JSPDetalle);
        this.JT2193.setFont(new Font("Arial", 1, 12));
        this.JT2193.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JT2193.setSelectionBackground(Color.white);
        this.JT2193.setSelectionForeground(Color.red);
        this.JSP2193.setViewportView(this.JT2193);
        this.JTPOpciones.addTab("INFORME 2193", this.JSP2193);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoPersonal.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoPersonal.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoPersonal.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoPersonal.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoPersonal.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsolidadoPersonal.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.rrhh.JIFConsolidadoPersonal.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsolidadoPersonal.this.JDCFechaFinPropertyChange(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPOpciones, -1, 772, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 178, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JDCFechaInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDCFechaFin, -2, 120, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 50, -2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 50, -2).addComponent(this.JDCFechaFin, -2, 50, -2)).addGap(10, 10, 10).addComponent(this.JTPOpciones, -2, 326, -2).addGap(10, 10, 10).addComponent(this.JTFRuta, -2, 50, -2))).addGap(15, 15, 15)));
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
                if (this.JTPOpciones.getSelectedIndex() == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle() + " - " + this.JTPOpciones.getTitleAt(0));
                    return;
                } else {
                    if (this.JTPOpciones.getSelectedIndex() == 1) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JT2193, this.JTFRuta.getText(), getTitle() + " - " + this.JTPOpciones.getTitleAt(1));
                        return;
                    }
                    return;
                }
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
