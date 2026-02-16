package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl;
import com.genoma.plus.dao.sgc.InformesSgcDAO;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFInfoAtencionPrioritariaxClasificacion.class */
public class JIFInfoAtencionPrioritariaxClasificacion extends JInternalFrame {
    private InformesSgcDAO xInformesSgcDAO;
    private DefaultTableModel xModelo1;
    private DefaultTableModel xModelo2;
    private Object[] xdatos;
    private String xtipo;
    private WorkerSQL xWorkerSQL;
    private ButtonGroup JBGClasificacion;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JRadioButton JRBDiscapacitado;
    private JRadioButton JRBEnbarazadas;
    private JRadioButton JRBNino;
    private JRadioButton JRBNormal;
    private JRadioButton JRBTerceraEdad;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTextField JTFRuta;
    private JTextField JTF_MayorT;
    private JTextField JTF_MenorT;
    private JTextField JTF_NEventos;
    private JTextField JTF_Promedio;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private Metodos xmt = new Metodos();
    private int xlleno = 0;

    public JIFInfoAtencionPrioritariaxClasificacion() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformesSgcDAO = (InformesSgcDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesSgcDAO");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTF_Promedio.setText("00:00:00");
        this.JTF_MenorT.setText("00:00:00");
        this.JTF_MayorT.setText("00:00:00");
        this.JTF_NEventos.setText("0");
        mCreaModeloTabla();
        mCreaModeloTablaTriage();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Fecha Ingreso", "Fecha Atencion", "Diferencia de Tiempo", "Tipo Identificacion", "No Documento", "Usuario", "Sexo", "DX Principal", "DXR1", "DXR2", "DXR3", "Triage", "Clase de Citas", "Clasificacion"}) { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mVerificarFitro();
        List<Object[]> list = this.xInformesSgcDAO.ListInformeAtencionPrioritaria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xtipo);
        mCreaModeloTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x)[0], x, 0);
            this.xModelo1.setValueAt(list.get(x)[1], x, 1);
            this.xModelo1.setValueAt(list.get(x)[2], x, 2);
            this.xModelo1.setValueAt(list.get(x)[3], x, 3);
            this.xModelo1.setValueAt(list.get(x)[4], x, 4);
            this.xModelo1.setValueAt(list.get(x)[5], x, 5);
            this.xModelo1.setValueAt(list.get(x)[6], x, 6);
            this.xModelo1.setValueAt(list.get(x)[7], x, 7);
            this.xModelo1.setValueAt(list.get(x)[8], x, 8);
            this.xModelo1.setValueAt(list.get(x)[9], x, 9);
            this.xModelo1.setValueAt(list.get(x)[10], x, 10);
            this.xModelo1.setValueAt(list.get(x)[11], x, 11);
            this.xModelo1.setValueAt(list.get(x)[12], x, 12);
            this.xModelo1.setValueAt(list.get(x)[13], x, 13);
        }
        this.JTF_NEventos.setText(String.valueOf(list.size()));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTablaTriage() {
        this.xModelo2 = new DefaultTableModel(new Object[0], new String[]{"Triage", "No Registros"}) { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.2
            Class[] types = {String.class, Integer.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xModelo2);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(80);
    }

    private void mCargarDatosTablaTriage() {
        mVerificarFitro();
        List<Object[]> list = this.xInformesSgcDAO.ListInformeAtencionPrioritariTriage(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xtipo);
        mCreaModeloTablaTriage();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo2.addRow(this.xdatos);
            this.xModelo2.setValueAt(list.get(x)[0], x, 0);
            this.xModelo2.setValueAt(list.get(x)[1], x, 1);
        }
    }

    private void mCargarDatosPromedio() {
        mVerificarFitro();
        List<Object[]> list = this.xInformesSgcDAO.ListInformeAtencionPrioritariPromedio(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xtipo);
        mCreaModeloTablaTriage();
        if (list.size() > -1) {
            this.JTF_Promedio.setText((String) list.get(0)[0]);
            this.JTF_MayorT.setText((String) list.get(0)[1]);
            this.JTF_MenorT.setText((String) list.get(0)[2]);
        }
    }

    private void mVerificarFitro() {
        if (this.JRBTodos.isSelected()) {
            this.xtipo = "0,1,2,3,4";
            return;
        }
        if (this.JRBNormal.isSelected()) {
            this.xtipo = "0";
            return;
        }
        if (this.JRBDiscapacitado.isSelected()) {
            this.xtipo = "1";
            return;
        }
        if (this.JRBEnbarazadas.isSelected()) {
            this.xtipo = "2";
        } else if (this.JRBTerceraEdad.isSelected()) {
            this.xtipo = "3";
        } else if (this.JRBNino.isSelected()) {
            this.xtipo = "4";
        }
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la información", this);
        this.xWorkerSQL.execute();
    }

    public void mCargarDatos() {
        mCargarDatosTabla();
        mCargarDatosPromedio();
        mCargarDatosTablaTriage();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v79, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGClasificacion = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jPanel2 = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBDiscapacitado = new JRadioButton();
        this.JRBEnbarazadas = new JRadioButton();
        this.JRBTerceraEdad = new JRadioButton();
        this.JRBNino = new JRadioButton();
        this.JRBNormal = new JRadioButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JTF_Promedio = new JTextField();
        this.JTF_MenorT = new JTextField();
        this.JTF_MayorT = new JTextField();
        this.JTF_NEventos = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMACIÓN DE ATENCIÓN PRIORITARIA POR CLASIFICACIÓN PREFERENCIAL");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinfoantencionprioritariaxclasificacion");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JDFechaFPropertyChange(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGClasificacion.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.5
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JBGClasificacion.add(this.JRBDiscapacitado);
        this.JRBDiscapacitado.setFont(new Font("Arial", 1, 12));
        this.JRBDiscapacitado.setText("Discapacitado");
        this.JRBDiscapacitado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.6
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JRBDiscapacitadoActionPerformed(evt);
            }
        });
        this.JBGClasificacion.add(this.JRBEnbarazadas);
        this.JRBEnbarazadas.setFont(new Font("Arial", 1, 12));
        this.JRBEnbarazadas.setText("Embarazadas");
        this.JRBEnbarazadas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.7
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JRBEnbarazadasActionPerformed(evt);
            }
        });
        this.JBGClasificacion.add(this.JRBTerceraEdad);
        this.JRBTerceraEdad.setFont(new Font("Arial", 1, 12));
        this.JRBTerceraEdad.setText("Tercera Edad");
        this.JRBTerceraEdad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.8
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JRBTerceraEdadActionPerformed(evt);
            }
        });
        this.JBGClasificacion.add(this.JRBNino);
        this.JRBNino.setFont(new Font("Arial", 1, 12));
        this.JRBNino.setText("Niño");
        this.JRBNino.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.9
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JRBNinoActionPerformed(evt);
            }
        });
        this.JBGClasificacion.add(this.JRBNormal);
        this.JRBNormal.setFont(new Font("Arial", 1, 12));
        this.JRBNormal.setText("Normal");
        this.JRBNormal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.10
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JRBNormalActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNormal).addGap(0, 0, 0).addComponent(this.JRBDiscapacitado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEnbarazadas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBTerceraEdad).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNino).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBDiscapacitado).addComponent(this.JRBEnbarazadas).addComponent(this.JRBTerceraEdad).addComponent(this.JRBNino).addComponent(this.JRBNormal)).addGap(0, 0, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.jPanel2, -2, -1, -2)).addGap(0, 0, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.11
            public void mouseClicked(MouseEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.12
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "TRIAGE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setSelectionBackground(Color.white);
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTF_Promedio.setFont(new Font("Arial", 1, 16));
        this.JTF_Promedio.setHorizontalAlignment(0);
        this.JTF_Promedio.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiempo Promedio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Promedio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.13
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JTF_PromedioActionPerformed(evt);
            }
        });
        this.JTF_MenorT.setFont(new Font("Arial", 1, 16));
        this.JTF_MenorT.setHorizontalAlignment(0);
        this.JTF_MenorT.setBorder(BorderFactory.createTitledBorder((Border) null, "Menor Tiempo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_MenorT.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.14
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JTF_MenorTActionPerformed(evt);
            }
        });
        this.JTF_MayorT.setFont(new Font("Arial", 1, 16));
        this.JTF_MayorT.setHorizontalAlignment(0);
        this.JTF_MayorT.setBorder(BorderFactory.createTitledBorder((Border) null, "Mayor Tiempo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_MayorT.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.15
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JTF_MayorTActionPerformed(evt);
            }
        });
        this.JTF_NEventos.setFont(new Font("Arial", 1, 16));
        this.JTF_NEventos.setHorizontalAlignment(0);
        this.JTF_NEventos.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NEventos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInfoAtencionPrioritariaxClasificacion.16
            public void actionPerformed(ActionEvent evt) {
                JIFInfoAtencionPrioritariaxClasificacion.this.JTF_NEventosActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 685, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -1, -1, 32767)).addComponent(this.jPanel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JSPDetalle, -2, 654, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTF_Promedio).addComponent(this.JSPDetalle1, -2, 0, 32767).addComponent(this.JTF_MenorT).addComponent(this.JTF_MayorT).addComponent(this.JTF_NEventos, GroupLayout.Alignment.TRAILING)))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 403, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JSPDetalle1, -2, 0, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_Promedio, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_MenorT, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_MayorT, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_NEventos, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -1, 41, 32767).addComponent(this.JTFRuta)).addGap(16, 16, 16)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NEventosActionPerformed(ActionEvent evt) {
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
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNormalActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDiscapacitadoActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnbarazadasActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTerceraEdadActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNinoActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_PromedioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_MenorTActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_MayorTActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }
}
