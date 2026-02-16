package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.sig.Resolucion4725_DAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFComsultarResolucion_4725.class */
public class JIFComsultarResolucion_4725 extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Resolucion4725_DAO xResolucion4725_DAO;
    private Object[] xDatos;
    private String[] xEmpresa;
    private File xfile;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JRadioButton JRB_V19;
    private JRadioButton JRB_V20;
    private JRadioButton JRB_V28_2;
    private JRadioButton JRB_V29;
    private JRadioButton JRB_V29_2;
    private JRadioButton JRB_V31_2;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup btnGrupo;
    private JButton jButton3;
    private JButton jButton4;
    private JCheckBox jchFiltro;
    private JPanel xjpInformacionGeneral;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    String sFichero = "";

    public JIFComsultarResolucion_4725() {
        initComponents();
        springStart();
        mNuevo();
        mCreaModelo();
    }

    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.btnGrupo = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.jchFiltro = new JCheckBox();
        this.xjpInformacionGeneral = new JPanel();
        this.JRB_V19 = new JRadioButton();
        this.JRB_V20 = new JRadioButton();
        this.JRB_V29 = new JRadioButton();
        this.JRB_V28_2 = new JRadioButton();
        this.JRB_V29_2 = new JRadioButton();
        this.JRB_V31_2 = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jButton4 = new JButton();
        this.jButton3 = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Informe Resolucion 4725");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFComsultarResolucion_4725.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFComsultarResolucion_4725.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jchFiltro.setFont(new Font("Arial", 1, 12));
        this.jchFiltro.setText("Filtro");
        this.jchFiltro.setToolTipText("");
        this.jchFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.3
            public void actionPerformed(ActionEvent evt) {
                JIFComsultarResolucion_4725.this.jchFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JDFechaI, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, -2, 348, -2).addGap(39, 39, 39).addComponent(this.jchFiltro).addGap(210, 210, 210)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, -1, -2).addComponent(this.jchFiltro))).addContainerGap(22, 32767)));
        this.xjpInformacionGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "VARIABLES DE INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.btnGrupo.add(this.JRB_V19);
        this.JRB_V19.setFont(new Font("Arial", 1, 12));
        this.JRB_V19.setText("PPGestante");
        this.JRB_V19.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.4
            public void mouseClicked(MouseEvent evt) {
                JIFComsultarResolucion_4725.this.JRB_V19MouseClicked(evt);
            }
        });
        this.btnGrupo.add(this.JRB_V20);
        this.JRB_V20.setFont(new Font("Arial", 1, 12));
        this.JRB_V20.setText("TTuberculosis ");
        this.JRB_V20.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.5
            public void mouseClicked(MouseEvent evt) {
                JIFComsultarResolucion_4725.this.JRB_V20MouseClicked(evt);
            }
        });
        this.btnGrupo.add(this.JRB_V29);
        this.JRB_V29.setFont(new Font("Arial", 1, 12));
        this.JRB_V29.setText("Fecha VIH");
        this.JRB_V29.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.6
            public void mouseClicked(MouseEvent evt) {
                JIFComsultarResolucion_4725.this.JRB_V29MouseClicked(evt);
            }
        });
        this.btnGrupo.add(this.JRB_V28_2);
        this.JRB_V28_2.setFont(new Font("Arial", 1, 12));
        this.JRB_V28_2.setText("Resultado VDRL");
        this.JRB_V28_2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.7
            public void mouseClicked(MouseEvent evt) {
                JIFComsultarResolucion_4725.this.JRB_V28_2MouseClicked(evt);
            }
        });
        this.JRB_V29_2.setFont(new Font("Arial", 1, 12));
        this.JRB_V29_2.setText("V29_1");
        this.JRB_V31_2.setFont(new Font("Arial", 1, 12));
        this.JRB_V31_2.setText("V31_1");
        GroupLayout xjpInformacionGeneralLayout = new GroupLayout(this.xjpInformacionGeneral);
        this.xjpInformacionGeneral.setLayout(xjpInformacionGeneralLayout);
        xjpInformacionGeneralLayout.setHorizontalGroup(xjpInformacionGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionGeneralLayout.createSequentialGroup().addComponent(this.JRB_V19, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V29, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V28_2, -2, 135, -2).addGap(1102, 1102, 1102).addComponent(this.JRB_V29_2, -2, 80, -2).addGap(256, 256, 256).addComponent(this.JRB_V31_2, -2, 80, -2).addContainerGap(-1, 32767)));
        xjpInformacionGeneralLayout.setVerticalGroup(xjpInformacionGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionGeneralLayout.createSequentialGroup().addContainerGap().addGroup(xjpInformacionGeneralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V19, -2, 30, -2).addComponent(this.JRB_V20, -2, 30, -2).addComponent(this.JRB_V29_2, -2, 30, -2).addComponent(this.JRB_V31_2, -2, 30, -2).addComponent(this.JRB_V29, -2, 30, -2).addComponent(this.JRB_V28_2, -2, 30, -2))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.8
            public void keyPressed(KeyEvent evt) {
                JIFComsultarResolucion_4725.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jButton4.setFont(new Font("Arial", 1, 12));
        this.jButton4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton4.setText("Limpiar tabla");
        this.jButton4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.9
            public void actionPerformed(ActionEvent evt) {
                JIFComsultarResolucion_4725.this.jButton4ActionPerformed(evt);
            }
        });
        this.jButton3.setFont(new Font("Arial", 1, 12));
        this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton3.setText("Actualizar por lotes");
        this.jButton3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.10
            public void actionPerformed(ActionEvent evt) {
                JIFComsultarResolucion_4725.this.jButton3ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.11
            public void mouseClicked(MouseEvent evt) {
                JIFComsultarResolucion_4725.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.12
            public void actionPerformed(ActionEvent evt) {
                JIFComsultarResolucion_4725.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 882, -2).addComponent(this.JPIDatos, -2, 882, -2).addGroup(layout.createSequentialGroup().addComponent(this.xjpInformacionGeneral, -2, 467, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton4, -2, 152, -2))).addGap(0, 12, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 512, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTExportar, -2, 225, -2).addGap(72, 72, 72)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.xjpInformacionGeneral, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton3, -2, 48, -2).addComponent(this.jButton4, -2, 48, -2)))).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 230, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -1, 53, 32767)).addContainerGap(21, 32767)));
        pack();
    }

    private void springStart() {
        this.xResolucion4725_DAO = (Resolucion4725_DAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("resolucion4725_DAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xlleno = true;
        mCreaModelo();
        this.JRB_V19.setForeground(Color.BLACK);
        this.JRB_V20.setForeground(Color.BLACK);
        this.JRB_V29.setForeground(Color.BLACK);
        this.JRB_V28_2.setForeground(Color.BLACK);
        this.jchFiltro.setSelected(false);
    }

    private void mLlenarCb() {
        List<GenericoComboDTO> list = this.xResolucion4725_DAO.comboEmpresa();
        this.xEmpresa = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xEmpresa[x] = String.valueOf(list.get(x).getId());
            this.JCBEmpresa.addItem(list.get(x).getNombre());
            System.out.println("Consulta " + list.get(x).getId());
            System.out.println("" + list.get(x).getNombre());
        }
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"TipoPrograma", "Eps", "Regimen", "pablacionEspecial", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "TipoDoc", "NoDcomento", "FechaN", "Sexo", "Etnia", "Direccion", "Telefono", "municipio", "PPGestante", "TTuberculosis", "FVIH", "CLPruebaVIH", "VDRL"}) { // from class: com.genoma.plus.controller.sig.JIFComsultarResolucion_4725.13
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(200);
    }

    private void mVerListadoCompleto() {
        if (this.jchFiltro.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                List<Object[]> list = this.xResolucion4725_DAO.mListadoCompleto(Integer.valueOf(this.xEmpresa[this.JCBEmpresa.getSelectedIndex()]).intValue());
                mCreaModelo();
                int cont = 0;
                for (int x = 0; x < list.size(); x++) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(list.get(x)[0], x, 0);
                    this.xModelo.setValueAt(list.get(x)[1], x, 1);
                    this.xModelo.setValueAt(list.get(x)[2], x, 2);
                    this.xModelo.setValueAt(list.get(x)[3], x, 3);
                    this.xModelo.setValueAt(list.get(x)[4], x, 4);
                    this.xModelo.setValueAt(list.get(x)[5], x, 5);
                    this.xModelo.setValueAt(list.get(x)[6], x, 6);
                    this.xModelo.setValueAt(list.get(x)[7], x, 7);
                    this.xModelo.setValueAt(list.get(x)[8], x, 8);
                    this.xModelo.setValueAt(list.get(x)[9], x, 9);
                    this.xModelo.setValueAt(list.get(x)[10], x, 10);
                    this.xModelo.setValueAt(list.get(x)[11], x, 11);
                    this.xModelo.setValueAt(list.get(x)[12], x, 12);
                    this.xModelo.setValueAt(list.get(x)[13], x, 13);
                    this.xModelo.setValueAt(list.get(x)[14], x, 14);
                    this.xModelo.setValueAt(list.get(x)[15], x, 15);
                    this.xModelo.setValueAt(list.get(x)[16], x, 16);
                    this.xModelo.setValueAt(list.get(x)[17], x, 17);
                    this.xModelo.setValueAt(list.get(x)[18], x, 18);
                    this.xModelo.setValueAt(list.get(x)[19], x, 19);
                    this.xModelo.setValueAt(list.get(x)[20], x, 20);
                    cont++;
                }
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "Seleccione una empresa", "Empresa", 0, new ImageIcon("src/Imagenes/Warning.png"));
            this.JCBEmpresa.requestFocus();
            return;
        }
        List<Object[]> list2 = this.xResolucion4725_DAO.mListadoCompleto1();
        mCreaModelo();
        int cont2 = 0;
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.xModelo.addRow(this.xDatos);
            this.xModelo.setValueAt(list2.get(x2)[0], x2, 0);
            this.xModelo.setValueAt(list2.get(x2)[1], x2, 1);
            this.xModelo.setValueAt(list2.get(x2)[2], x2, 2);
            this.xModelo.setValueAt(list2.get(x2)[3], x2, 3);
            this.xModelo.setValueAt(list2.get(x2)[4], x2, 4);
            this.xModelo.setValueAt(list2.get(x2)[5], x2, 5);
            this.xModelo.setValueAt(list2.get(x2)[6], x2, 6);
            this.xModelo.setValueAt(list2.get(x2)[7], x2, 7);
            this.xModelo.setValueAt(list2.get(x2)[8], x2, 8);
            this.xModelo.setValueAt(list2.get(x2)[9], x2, 9);
            this.xModelo.setValueAt(list2.get(x2)[10], x2, 10);
            this.xModelo.setValueAt(list2.get(x2)[11], x2, 11);
            this.xModelo.setValueAt(list2.get(x2)[12], x2, 12);
            this.xModelo.setValueAt(list2.get(x2)[13], x2, 13);
            this.xModelo.setValueAt(list2.get(x2)[14], x2, 14);
            this.xModelo.setValueAt(list2.get(x2)[15], x2, 15);
            this.xModelo.setValueAt(list2.get(x2)[16], x2, 16);
            this.xModelo.setValueAt(list2.get(x2)[17], x2, 17);
            this.xModelo.setValueAt(list2.get(x2)[18], x2, 18);
            this.xModelo.setValueAt(list2.get(x2)[19], x2, 19);
            this.xModelo.setValueAt(list2.get(x2)[20], x2, 20);
            cont2++;
        }
    }

    public void mBuscar() {
        mVerListadoCompleto();
    }

    private void mActualizarLotes() {
        this.xResolucion4725_DAO.mActualizarLotes(this.xjpInformacionGeneral, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la información", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarCb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarCb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V19MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V20MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V29MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V28_2MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton3ActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog((Component) null, "Recuerde seleccionar rango de fecha", "Información", 0, new ImageIcon("src/Imagenes/Information.png"));
        if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea actualizar por lotes?", "Actualizar por Lotes", 0, 3, new ImageIcon("src/Imagenes/Question.png")) == 0) {
            mActualizarLotes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton4ActionPerformed(ActionEvent evt) {
        this.xResolucion4725_DAO.eliminarTablaReso4725();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
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
    public void jchFiltroActionPerformed(ActionEvent evt) {
    }
}
