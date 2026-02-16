package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.Resolucion2463_DAOImpl;
import com.genoma.plus.dao.sig.Resolucion2463_DAO;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFFConsultarInfoRes2463.class */
public class JIFFConsultarInfoRes2463 extends JInternalFrame {
    private File xfile;
    private Resolucion2463_DAO xResolucion2463_DAO;
    private String[][] xComboEmpresa;
    private DefaultTableModel xModelo;
    private Object[] xDatos;
    private JRadioButton xjrButton;
    private JButton JBTExportar;
    private JButton JBTGenerar;
    private JComboBox JCBEmpresa;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDetalle;
    private JPanel JPIPreparacion;
    private JRadioButton JRB_V17;
    private JRadioButton JRB_V18;
    private JRadioButton JRB_V19;
    private JRadioButton JRB_V19_1;
    private JRadioButton JRB_V20;
    private JRadioButton JRB_V21;
    private JRadioButton JRB_V21_1;
    private JRadioButton JRB_V22;
    private JRadioButton JRB_V23;
    private JRadioButton JRB_V24;
    private JRadioButton JRB_V25;
    private JRadioButton JRB_V26;
    private JRadioButton JRB_V27;
    private JRadioButton JRB_V27_1;
    private JRadioButton JRB_V28;
    private JRadioButton JRB_V28_1;
    private JRadioButton JRB_V29;
    private JRadioButton JRB_V29_1;
    private JRadioButton JRB_V30;
    private JRadioButton JRB_V30_1;
    private JRadioButton JRB_V31;
    private JRadioButton JRB_V31_1;
    private JRadioButton JRB_V32;
    private JRadioButton JRB_V32_1;
    private JRadioButton JRB_V33;
    private JRadioButton JRB_V34;
    private JRadioButton JRB_V34_1;
    private JRadioButton JRB_V35;
    private JRadioButton JRB_V36;
    private JRadioButton JRB_V37;
    private JRadioButton JRB_V38;
    private JRadioButton JRB_V39;
    private JRadioButton JRB_V40;
    private JRadioButton JRB_V41;
    private JRadioButton JRB_V42;
    private JRadioButton JRB_V43;
    private JRadioButton JRB_V44;
    private JRadioButton JRB_V45;
    private JRadioButton JRB_V46;
    private JRadioButton JRB_V47;
    private JRadioButton JRB_V48;
    private JRadioButton JRB_V49;
    private JRadioButton JRB_V50;
    private JRadioButton JRB_V51;
    private JRadioButton JRB_V52;
    private JRadioButton JRB_V53;
    private JRadioButton JRB_V54;
    private JRadioButton JRB_V55;
    private JRadioButton JRB_V56;
    private JRadioButton JRB_V57;
    private JRadioButton JRB_V58;
    private JRadioButton JRB_V59;
    private JRadioButton JRB_V60;
    private JRadioButton JRB_V61;
    private JRadioButton JRB_V62;
    private JRadioButton JRB_V62_1;
    private JRadioButton JRB_V62_10;
    private JRadioButton JRB_V62_11;
    private JRadioButton JRB_V62_2;
    private JRadioButton JRB_V62_3;
    private JRadioButton JRB_V62_4;
    private JRadioButton JRB_V62_5;
    private JRadioButton JRB_V62_6;
    private JRadioButton JRB_V62_7;
    private JRadioButton JRB_V62_8;
    private JRadioButton JRB_V62_9;
    private JRadioButton JRB_V63;
    private JRadioButton JRB_V63_1;
    private JRadioButton JRB_V64;
    private JRadioButton JRB_V65;
    private JRadioButton JRB_V66;
    private JRadioButton JRB_V67;
    private JRadioButton JRB_V68;
    private JRadioButton JRB_V69;
    private JRadioButton JRB_V69_1;
    private JRadioButton JRB_V69_2;
    private JRadioButton JRB_V69_3;
    private JRadioButton JRB_V69_4;
    private JRadioButton JRB_V69_5;
    private JRadioButton JRB_V69_6;
    private JRadioButton JRB_V69_7;
    private JRadioButton JRB_V70;
    private JRadioButton JRB_V70_1;
    private JRadioButton JRB_V70_2;
    private JRadioButton JRB_V70_3;
    private JRadioButton JRB_V70_4;
    private JRadioButton JRB_V70_5;
    private JRadioButton JRB_V70_6;
    private JRadioButton JRB_V70_7;
    private JRadioButton JRB_V70_8;
    private JRadioButton JRB_V70_9;
    private JRadioButton JRB_V71;
    private JRadioButton JRB_V72;
    private JRadioButton JRB_V73;
    private JRadioButton JRB_V74;
    private JRadioButton JRB_V75;
    private JRadioButton JRB_V76;
    private JRadioButton JRB_V77;
    private JRadioButton JRB_V78;
    private JRadioButton JRB_V79;
    private JRadioButton JRB_V80;
    private JRadioButton JRB_V80_1;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JButton jButton1;
    private JButton jButton2;
    private ButtonGroup jbgVariable;
    private JCheckBox jchFiltro;
    private JTextField jtfTotalRegistro;
    private JPanel xjpInformacionGeneral;
    private JPanel xjpInformacionRelacionadaDX;
    private Metodos xmt = new Metodos();
    private boolean xlleno = true;
    String sFichero = "";
    private long xnregistro = 0;

    public JIFFConsultarInfoRes2463() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xResolucion2463_DAO = (Resolucion2463_DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("resolucion2463DAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCBEmpresa.setSelectedIndex(-1);
        mCreaModelo();
    }

    public void mBuscar() {
        mVerListadoCompleto();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jbgVariable = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIDetalle = new JPanel();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.jchFiltro = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        this.jtfTotalRegistro = new JTextField();
        this.JBTExportar = new JButton();
        this.JPIPreparacion = new JPanel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.xjpInformacionGeneral = new JPanel();
        this.JRB_V17 = new JRadioButton();
        this.JRB_V18 = new JRadioButton();
        this.JRB_V19 = new JRadioButton();
        this.JRB_V19_1 = new JRadioButton();
        this.JRB_V20 = new JRadioButton();
        this.JRB_V21 = new JRadioButton();
        this.JRB_V21_1 = new JRadioButton();
        this.JRB_V22 = new JRadioButton();
        this.JRB_V23 = new JRadioButton();
        this.JRB_V24 = new JRadioButton();
        this.JRB_V25 = new JRadioButton();
        this.JRB_V26 = new JRadioButton();
        this.JRB_V27 = new JRadioButton();
        this.JRB_V27_1 = new JRadioButton();
        this.JRB_V28 = new JRadioButton();
        this.JRB_V28_1 = new JRadioButton();
        this.JRB_V29 = new JRadioButton();
        this.JRB_V29_1 = new JRadioButton();
        this.JRB_V30 = new JRadioButton();
        this.JRB_V30_1 = new JRadioButton();
        this.JRB_V31 = new JRadioButton();
        this.JRB_V31_1 = new JRadioButton();
        this.JRB_V32 = new JRadioButton();
        this.JRB_V32_1 = new JRadioButton();
        this.JRB_V33 = new JRadioButton();
        this.JRB_V34 = new JRadioButton();
        this.JRB_V34_1 = new JRadioButton();
        this.JRB_V35 = new JRadioButton();
        this.JRB_V36 = new JRadioButton();
        this.JRB_V37 = new JRadioButton();
        this.xjpInformacionRelacionadaDX = new JPanel();
        this.JRB_V38 = new JRadioButton();
        this.JRB_V39 = new JRadioButton();
        this.JRB_V40 = new JRadioButton();
        this.JRB_V41 = new JRadioButton();
        this.JRB_V42 = new JRadioButton();
        this.JRB_V43 = new JRadioButton();
        this.JRB_V44 = new JRadioButton();
        this.JRB_V45 = new JRadioButton();
        this.JRB_V46 = new JRadioButton();
        this.JRB_V47 = new JRadioButton();
        this.JRB_V48 = new JRadioButton();
        this.JRB_V49 = new JRadioButton();
        this.JRB_V50 = new JRadioButton();
        this.JRB_V51 = new JRadioButton();
        this.JRB_V52 = new JRadioButton();
        this.JRB_V53 = new JRadioButton();
        this.JRB_V54 = new JRadioButton();
        this.JRB_V55 = new JRadioButton();
        this.JRB_V56 = new JRadioButton();
        this.JRB_V57 = new JRadioButton();
        this.JRB_V58 = new JRadioButton();
        this.JRB_V59 = new JRadioButton();
        this.JRB_V60 = new JRadioButton();
        this.JRB_V61 = new JRadioButton();
        this.JRB_V62 = new JRadioButton();
        this.JRB_V63 = new JRadioButton();
        this.JRB_V63_1 = new JRadioButton();
        this.JRB_V64 = new JRadioButton();
        this.JRB_V65 = new JRadioButton();
        this.JRB_V66 = new JRadioButton();
        this.JRB_V67 = new JRadioButton();
        this.JRB_V68 = new JRadioButton();
        this.JRB_V69 = new JRadioButton();
        this.JRB_V70 = new JRadioButton();
        this.JRB_V71 = new JRadioButton();
        this.JRB_V72 = new JRadioButton();
        this.JRB_V73 = new JRadioButton();
        this.JRB_V74 = new JRadioButton();
        this.JRB_V75 = new JRadioButton();
        this.JRB_V76 = new JRadioButton();
        this.JRB_V77 = new JRadioButton();
        this.JRB_V78 = new JRadioButton();
        this.JRB_V79 = new JRadioButton();
        this.JRB_V80 = new JRadioButton();
        this.JRB_V62_1 = new JRadioButton();
        this.JRB_V62_2 = new JRadioButton();
        this.JRB_V62_3 = new JRadioButton();
        this.JRB_V62_4 = new JRadioButton();
        this.JRB_V62_5 = new JRadioButton();
        this.JRB_V62_6 = new JRadioButton();
        this.JRB_V62_7 = new JRadioButton();
        this.JRB_V62_8 = new JRadioButton();
        this.JRB_V62_9 = new JRadioButton();
        this.JRB_V62_10 = new JRadioButton();
        this.JRB_V62_11 = new JRadioButton();
        this.JRB_V69_1 = new JRadioButton();
        this.JRB_V69_2 = new JRadioButton();
        this.JRB_V69_3 = new JRadioButton();
        this.JRB_V69_4 = new JRadioButton();
        this.JRB_V69_5 = new JRadioButton();
        this.JRB_V69_6 = new JRadioButton();
        this.JRB_V69_7 = new JRadioButton();
        this.JRB_V70_1 = new JRadioButton();
        this.JRB_V70_2 = new JRadioButton();
        this.JRB_V70_3 = new JRadioButton();
        this.JRB_V70_4 = new JRadioButton();
        this.JRB_V70_5 = new JRadioButton();
        this.JRB_V70_6 = new JRadioButton();
        this.JRB_V70_7 = new JRadioButton();
        this.JRB_V70_8 = new JRadioButton();
        this.JRB_V70_9 = new JRadioButton();
        this.JRB_V80_1 = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME RESOLUCIÓN 2463");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("informeRes2463");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFConsultarInfoRes2463.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFConsultarInfoRes2463.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jchFiltro.setFont(new Font("Arial", 1, 12));
        this.jchFiltro.setText("Filtro");
        this.jchFiltro.setToolTipText("");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, -2, 808, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jchFiltro).addContainerGap(22, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, -1, -2).addComponent(this.jchFiltro))).addContainerGap(22, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.3
            public void keyPressed(KeyEvent evt) {
                JIFFConsultarInfoRes2463.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.4
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.5
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultarInfoRes2463.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.jtfTotalRegistro.setFont(new Font("Arial", 1, 12));
        this.jtfTotalRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Registros ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar a Excel");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.6
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultarInfoRes2463.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jtfTotalRegistro, -2, 166, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGenerar, -2, 230, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 230, -2)).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 378, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 56, -2).addComponent(this.jtfTotalRegistro, -2, 56, -2)).addComponent(this.JBTExportar, -2, 58, -2).addComponent(this.JBTGenerar, -1, -1, 32767)).addContainerGap(13, 32767)));
        this.JTPDatos.addTab("DETALLE", this.JPIDetalle);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton1.setText("Actualizar por lotes");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.7
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultarInfoRes2463.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton2.setText("Limpiar tabla");
        this.jButton2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.8
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultarInfoRes2463.this.jButton2ActionPerformed(evt);
            }
        });
        this.xjpInformacionGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN GENERAL RELACIONADA CON LAS VARIABLES CLÍNICAS Y PARACLÍNICAS DE LAS ENFERMEDADES PRECURSORAS ", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jbgVariable.add(this.JRB_V17);
        this.JRB_V17.setFont(new Font("Arial", 1, 12));
        this.JRB_V17.setText("V17");
        this.JRB_V17.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.9
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V17MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V18);
        this.JRB_V18.setFont(new Font("Arial", 1, 12));
        this.JRB_V18.setText("V18");
        this.JRB_V18.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.10
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V18MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V19);
        this.JRB_V19.setFont(new Font("Arial", 1, 12));
        this.JRB_V19.setText("V19");
        this.JRB_V19.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.11
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V19MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V19_1);
        this.JRB_V19_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V19_1.setText("V19_1");
        this.JRB_V19_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.12
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V19_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V20);
        this.JRB_V20.setFont(new Font("Arial", 1, 12));
        this.JRB_V20.setText("V20");
        this.JRB_V20.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.13
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V20MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V21);
        this.JRB_V21.setFont(new Font("Arial", 1, 12));
        this.JRB_V21.setText("V21");
        this.JRB_V21.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.14
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V21MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V21_1);
        this.JRB_V21_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V21_1.setText("V21_1");
        this.JRB_V21_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.15
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V21_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V22);
        this.JRB_V22.setFont(new Font("Arial", 1, 12));
        this.JRB_V22.setText("V22");
        this.JRB_V22.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.16
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V22MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V23);
        this.JRB_V23.setFont(new Font("Arial", 1, 12));
        this.JRB_V23.setText("V23");
        this.JRB_V23.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.17
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V23MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V24);
        this.JRB_V24.setFont(new Font("Arial", 1, 12));
        this.JRB_V24.setText("V24");
        this.JRB_V24.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.18
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V24MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V25);
        this.JRB_V25.setFont(new Font("Arial", 1, 12));
        this.JRB_V25.setText("V25");
        this.JRB_V25.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.19
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V25MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V26);
        this.JRB_V26.setFont(new Font("Arial", 1, 12));
        this.JRB_V26.setText("V26");
        this.JRB_V26.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.20
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V26MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V27);
        this.JRB_V27.setFont(new Font("Arial", 1, 12));
        this.JRB_V27.setText("V27");
        this.JRB_V27.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.21
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V27MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V27_1);
        this.JRB_V27_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V27_1.setText("V27_1");
        this.JRB_V27_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.22
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V27_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V28);
        this.JRB_V28.setFont(new Font("Arial", 1, 12));
        this.JRB_V28.setText("V28");
        this.JRB_V28.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.23
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V28MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V28_1);
        this.JRB_V28_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V28_1.setText("V28_1");
        this.JRB_V28_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.24
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V28_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V29);
        this.JRB_V29.setFont(new Font("Arial", 1, 12));
        this.JRB_V29.setText("V29");
        this.JRB_V29.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.25
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V29MouseClicked(evt);
            }
        });
        this.JRB_V29_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V29_1.setText("V29_1");
        this.jbgVariable.add(this.JRB_V30);
        this.JRB_V30.setFont(new Font("Arial", 1, 12));
        this.JRB_V30.setText("V30");
        this.JRB_V30.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.26
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V30MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V30_1);
        this.JRB_V30_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V30_1.setText("V30_1");
        this.JRB_V30_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.27
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V30_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V31);
        this.JRB_V31.setFont(new Font("Arial", 1, 12));
        this.JRB_V31.setText("V31");
        this.JRB_V31.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.28
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V31MouseClicked(evt);
            }
        });
        this.JRB_V31_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V31_1.setText("V31_1");
        this.jbgVariable.add(this.JRB_V32);
        this.JRB_V32.setFont(new Font("Arial", 1, 12));
        this.JRB_V32.setText("V32");
        this.JRB_V32.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.29
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V32MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V32_1);
        this.JRB_V32_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V32_1.setText("V32_1");
        this.JRB_V32_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.30
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V32_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V33);
        this.JRB_V33.setFont(new Font("Arial", 1, 12));
        this.JRB_V33.setText("V33");
        this.JRB_V33.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.31
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V33MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V34);
        this.JRB_V34.setFont(new Font("Arial", 1, 12));
        this.JRB_V34.setText("V34");
        this.JRB_V34.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.32
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V34MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V34_1);
        this.JRB_V34_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V34_1.setText("V34_1");
        this.JRB_V34_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.33
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V34_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V35);
        this.JRB_V35.setFont(new Font("Arial", 1, 12));
        this.JRB_V35.setText("V35");
        this.JRB_V35.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.34
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V35MouseClicked(evt);
            }
        });
        this.JRB_V35.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.35
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V35ActionPerformed(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V36);
        this.JRB_V36.setFont(new Font("Arial", 1, 12));
        this.JRB_V36.setText("V36");
        this.JRB_V36.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.36
            public void mouseEntered(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V36MouseEntered(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V37);
        this.JRB_V37.setFont(new Font("Arial", 1, 12));
        this.JRB_V37.setText("V37");
        this.JRB_V37.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.37
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V37MouseClicked(evt);
            }
        });
        GroupLayout xjpInformacionGeneralLayout = new GroupLayout(this.xjpInformacionGeneral);
        this.xjpInformacionGeneral.setLayout(xjpInformacionGeneralLayout);
        xjpInformacionGeneralLayout.setHorizontalGroup(xjpInformacionGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionGeneralLayout.createSequentialGroup().addContainerGap().addGroup(xjpInformacionGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionGeneralLayout.createSequentialGroup().addComponent(this.JRB_V17, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V18, -2, 80, -2).addGap(4, 4, 4).addComponent(this.JRB_V19, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V19_1, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V20, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V21, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V21_1, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V22, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V23, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V24, -2, 80, -2)).addGroup(xjpInformacionGeneralLayout.createSequentialGroup().addComponent(this.JRB_V28, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V28_1, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V29, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V30, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V30_1, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V31, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V32, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V32_1, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V33, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V34, -2, 80, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionGeneralLayout.createSequentialGroup().addComponent(this.JRB_V34_1, -2, 80, -2).addGap(4, 4, 4).addComponent(this.JRB_V35, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V36, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V37, -2, 80, -2)).addGroup(xjpInformacionGeneralLayout.createSequentialGroup().addComponent(this.JRB_V25, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V26, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V27, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V27_1, -2, 80, -2).addGap(378, 378, 378).addComponent(this.JRB_V29_1, -2, 80, -2).addGap(256, 256, 256).addComponent(this.JRB_V31_1, -2, 80, -2))).addContainerGap(-1, 32767)));
        xjpInformacionGeneralLayout.setVerticalGroup(xjpInformacionGeneralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionGeneralLayout.createSequentialGroup().addContainerGap().addGroup(xjpInformacionGeneralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V17, -2, 30, -2).addComponent(this.JRB_V18, -2, 30, -2).addComponent(this.JRB_V19, -2, 30, -2).addComponent(this.JRB_V20, -2, 30, -2).addComponent(this.JRB_V21, -2, 30, -2).addComponent(this.JRB_V22, -2, 30, -2).addComponent(this.JRB_V23, -2, 30, -2).addComponent(this.JRB_V24, -2, 30, -2).addComponent(this.JRB_V25, -2, 30, -2).addComponent(this.JRB_V19_1, -2, 30, -2).addComponent(this.JRB_V21_1, -2, 30, -2).addComponent(this.JRB_V26, -2, 30, -2).addComponent(this.JRB_V27, -2, 30, -2).addComponent(this.JRB_V27_1, -2, 30, -2).addComponent(this.JRB_V29_1, -2, 30, -2).addComponent(this.JRB_V31_1, -2, 30, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(xjpInformacionGeneralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V28, -2, 30, -2).addComponent(this.JRB_V28_1, -2, 30, -2).addComponent(this.JRB_V29, -2, 30, -2).addComponent(this.JRB_V30, -2, 30, -2).addComponent(this.JRB_V31, -2, 30, -2).addComponent(this.JRB_V30_1, -2, 30, -2).addComponent(this.JRB_V32, -2, 30, -2).addComponent(this.JRB_V32_1, -2, 30, -2).addComponent(this.JRB_V33, -2, 30, -2).addComponent(this.JRB_V34, -2, 30, -2).addComponent(this.JRB_V34_1, -2, 30, -2).addComponent(this.JRB_V35, -2, 30, -2).addComponent(this.JRB_V36, -2, 30, -2).addComponent(this.JRB_V37, -2, 30, -2)).addGap(20, 20, 20)));
        this.xjpInformacionRelacionadaDX.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN RELACIONADA CON DIAGNÓNISCO Y TRATAMIENTO DE LA ENFERMEDAD RENAL CRÓNICA  ", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jbgVariable.add(this.JRB_V38);
        this.JRB_V38.setFont(new Font("Arial", 1, 12));
        this.JRB_V38.setText("V38");
        this.JRB_V38.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.38
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V38MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V39);
        this.JRB_V39.setFont(new Font("Arial", 1, 12));
        this.JRB_V39.setText("V39");
        this.JRB_V39.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.39
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V39MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V40);
        this.JRB_V40.setFont(new Font("Arial", 1, 12));
        this.JRB_V40.setText("V40");
        this.JRB_V40.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.40
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V40MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V41);
        this.JRB_V41.setFont(new Font("Arial", 1, 12));
        this.JRB_V41.setText("V41");
        this.JRB_V41.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.41
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V41MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V42);
        this.JRB_V42.setFont(new Font("Arial", 1, 12));
        this.JRB_V42.setText("V42");
        this.JRB_V42.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.42
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V42MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V43);
        this.JRB_V43.setFont(new Font("Arial", 1, 12));
        this.JRB_V43.setText("V43");
        this.JRB_V43.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.43
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V43MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V44);
        this.JRB_V44.setFont(new Font("Arial", 1, 12));
        this.JRB_V44.setText("V44");
        this.JRB_V44.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.44
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V44MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V45);
        this.JRB_V45.setFont(new Font("Arial", 1, 12));
        this.JRB_V45.setText("V45");
        this.JRB_V45.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.45
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V45MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V46);
        this.JRB_V46.setFont(new Font("Arial", 1, 12));
        this.JRB_V46.setText("V46");
        this.JRB_V46.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.46
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V46MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V47);
        this.JRB_V47.setFont(new Font("Arial", 1, 12));
        this.JRB_V47.setText("V47");
        this.JRB_V47.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.47
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V47MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V48);
        this.JRB_V48.setFont(new Font("Arial", 1, 12));
        this.JRB_V48.setText("V48");
        this.JRB_V48.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.48
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V48MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V49);
        this.JRB_V49.setFont(new Font("Arial", 1, 12));
        this.JRB_V49.setText("V49");
        this.JRB_V49.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.49
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V49MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V50);
        this.JRB_V50.setFont(new Font("Arial", 1, 12));
        this.JRB_V50.setText("V50");
        this.JRB_V50.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.50
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V50MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V51);
        this.JRB_V51.setFont(new Font("Arial", 1, 12));
        this.JRB_V51.setText("V51");
        this.JRB_V51.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.51
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V51MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V52);
        this.JRB_V52.setFont(new Font("Arial", 1, 12));
        this.JRB_V52.setText("V52");
        this.JRB_V52.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.52
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V52MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V53);
        this.JRB_V53.setFont(new Font("Arial", 1, 12));
        this.JRB_V53.setText("V53");
        this.JRB_V53.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.53
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V53MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V54);
        this.JRB_V54.setFont(new Font("Arial", 1, 12));
        this.JRB_V54.setText("V54");
        this.JRB_V54.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.54
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V54MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V55);
        this.JRB_V55.setFont(new Font("Arial", 1, 12));
        this.JRB_V55.setText("V55");
        this.JRB_V55.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.55
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V55MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V56);
        this.JRB_V56.setFont(new Font("Arial", 1, 12));
        this.JRB_V56.setText("V56");
        this.JRB_V56.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.56
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V56MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V57);
        this.JRB_V57.setFont(new Font("Arial", 1, 12));
        this.JRB_V57.setText("V57");
        this.JRB_V57.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.57
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V57MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V58);
        this.JRB_V58.setFont(new Font("Arial", 1, 12));
        this.JRB_V58.setText("V58");
        this.JRB_V58.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.58
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V58MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V59);
        this.JRB_V59.setFont(new Font("Arial", 1, 12));
        this.JRB_V59.setText("V59");
        this.JRB_V59.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.59
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V59MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V60);
        this.JRB_V60.setFont(new Font("Arial", 1, 12));
        this.JRB_V60.setText("V60");
        this.JRB_V60.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.60
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V60MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V61);
        this.JRB_V61.setFont(new Font("Arial", 1, 12));
        this.JRB_V61.setText("V61");
        this.JRB_V61.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.61
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V61MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62);
        this.JRB_V62.setFont(new Font("Arial", 1, 12));
        this.JRB_V62.setText("V62");
        this.JRB_V62.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.62
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V63);
        this.JRB_V63.setFont(new Font("Arial", 1, 12));
        this.JRB_V63.setText("V63");
        this.JRB_V63.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.63
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V63MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V63_1);
        this.JRB_V63_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V63_1.setText("V63_1");
        this.JRB_V63_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.64
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V63_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V64);
        this.JRB_V64.setFont(new Font("Arial", 1, 12));
        this.JRB_V64.setText("V64");
        this.JRB_V64.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.65
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V64MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V65);
        this.JRB_V65.setFont(new Font("Arial", 1, 12));
        this.JRB_V65.setText("V65");
        this.JRB_V65.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.66
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V65MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V66);
        this.JRB_V66.setFont(new Font("Arial", 1, 12));
        this.JRB_V66.setText("V66");
        this.JRB_V66.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.67
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V66MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V67);
        this.JRB_V67.setFont(new Font("Arial", 1, 12));
        this.JRB_V67.setText("V67");
        this.JRB_V67.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.68
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V67MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V68);
        this.JRB_V68.setFont(new Font("Arial", 1, 12));
        this.JRB_V68.setText("V68");
        this.JRB_V68.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.69
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V68MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V69);
        this.JRB_V69.setFont(new Font("Arial", 1, 12));
        this.JRB_V69.setText("V69");
        this.JRB_V69.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.70
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V69MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70);
        this.JRB_V70.setFont(new Font("Arial", 1, 12));
        this.JRB_V70.setText("V70");
        this.JRB_V70.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.71
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V71);
        this.JRB_V71.setFont(new Font("Arial", 1, 12));
        this.JRB_V71.setText("V71");
        this.JRB_V71.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.72
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V71MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V72);
        this.JRB_V72.setFont(new Font("Arial", 1, 12));
        this.JRB_V72.setText("V72");
        this.JRB_V72.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.73
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V72MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V73);
        this.JRB_V73.setFont(new Font("Arial", 1, 12));
        this.JRB_V73.setText("V73");
        this.JRB_V73.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.74
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V73MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V74);
        this.JRB_V74.setFont(new Font("Arial", 1, 12));
        this.JRB_V74.setText("V74");
        this.JRB_V74.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.75
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V74MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V75);
        this.JRB_V75.setFont(new Font("Arial", 1, 12));
        this.JRB_V75.setText("V75");
        this.JRB_V75.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.76
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V75MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V76);
        this.JRB_V76.setFont(new Font("Arial", 1, 12));
        this.JRB_V76.setText("V76");
        this.JRB_V76.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.77
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V76MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V77);
        this.JRB_V77.setFont(new Font("Arial", 1, 12));
        this.JRB_V77.setText("V77");
        this.JRB_V77.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.78
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V77MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V78);
        this.JRB_V78.setFont(new Font("Arial", 1, 12));
        this.JRB_V78.setText("V78");
        this.JRB_V78.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.79
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V78MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V79);
        this.JRB_V79.setFont(new Font("Arial", 1, 12));
        this.JRB_V79.setText("V79");
        this.JRB_V79.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.80
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V79MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V80);
        this.JRB_V80.setFont(new Font("Arial", 1, 12));
        this.JRB_V80.setText("V80");
        this.JRB_V80.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.81
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V80MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_1);
        this.JRB_V62_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_1.setText("V62_1");
        this.JRB_V62_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.82
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_2);
        this.JRB_V62_2.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_2.setText("V62_2");
        this.JRB_V62_2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.83
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_2MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_3);
        this.JRB_V62_3.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_3.setText("V62_3");
        this.JRB_V62_3.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.84
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_3MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_4);
        this.JRB_V62_4.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_4.setText("V62_4");
        this.JRB_V62_4.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.85
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_4MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_5);
        this.JRB_V62_5.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_5.setText("V62_5");
        this.JRB_V62_5.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.86
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_5MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_6);
        this.JRB_V62_6.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_6.setText("V62_6");
        this.JRB_V62_6.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.87
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_6MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_7);
        this.JRB_V62_7.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_7.setText("V62_7");
        this.JRB_V62_7.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.88
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_7MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_8);
        this.JRB_V62_8.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_8.setText("V62_8");
        this.JRB_V62_8.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.89
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_8MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_9);
        this.JRB_V62_9.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_9.setText("V62_9");
        this.JRB_V62_9.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.90
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_9MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_10);
        this.JRB_V62_10.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_10.setText("V62_10");
        this.JRB_V62_10.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.91
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_10MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V62_11);
        this.JRB_V62_11.setFont(new Font("Arial", 1, 12));
        this.JRB_V62_11.setText("V62_11");
        this.JRB_V62_11.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.92
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V62_11MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V69_1);
        this.JRB_V69_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V69_1.setText("V69_1");
        this.JRB_V69_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.93
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V69_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V69_2);
        this.JRB_V69_2.setFont(new Font("Arial", 1, 12));
        this.JRB_V69_2.setText("V69_2");
        this.JRB_V69_2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.94
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V69_2MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V69_3);
        this.JRB_V69_3.setFont(new Font("Arial", 1, 12));
        this.JRB_V69_3.setText("V69_3");
        this.JRB_V69_3.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.95
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V69_3MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V69_4);
        this.JRB_V69_4.setFont(new Font("Arial", 1, 12));
        this.JRB_V69_4.setText("V69_4");
        this.JRB_V69_4.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.96
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V69_4MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V69_5);
        this.JRB_V69_5.setFont(new Font("Arial", 1, 12));
        this.JRB_V69_5.setText("V69_5");
        this.JRB_V69_5.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.97
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V69_5MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V69_6);
        this.JRB_V69_6.setFont(new Font("Arial", 1, 12));
        this.JRB_V69_6.setText("V69_6");
        this.JRB_V69_6.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.98
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V69_6MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V69_7);
        this.JRB_V69_7.setFont(new Font("Arial", 1, 12));
        this.JRB_V69_7.setText("V69_7");
        this.JRB_V69_7.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.99
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V69_7MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70_1);
        this.JRB_V70_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V70_1.setText("V70_1");
        this.JRB_V70_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.100
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70_1MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70_2);
        this.JRB_V70_2.setFont(new Font("Arial", 1, 12));
        this.JRB_V70_2.setText("V70_2");
        this.JRB_V70_2.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.101
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70_2MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70_3);
        this.JRB_V70_3.setFont(new Font("Arial", 1, 12));
        this.JRB_V70_3.setText("V70_3");
        this.JRB_V70_3.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.102
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70_3MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70_4);
        this.JRB_V70_4.setFont(new Font("Arial", 1, 12));
        this.JRB_V70_4.setText("V70_4");
        this.JRB_V70_4.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.103
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70_4MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70_5);
        this.JRB_V70_5.setFont(new Font("Arial", 1, 12));
        this.JRB_V70_5.setText("V70_5");
        this.JRB_V70_5.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.104
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70_5MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70_6);
        this.JRB_V70_6.setFont(new Font("Arial", 1, 12));
        this.JRB_V70_6.setText("V70_6");
        this.JRB_V70_6.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.105
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70_6MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70_7);
        this.JRB_V70_7.setFont(new Font("Arial", 1, 12));
        this.JRB_V70_7.setText("V70_7");
        this.JRB_V70_7.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.106
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70_7MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70_8);
        this.JRB_V70_8.setFont(new Font("Arial", 1, 12));
        this.JRB_V70_8.setText("V70_8");
        this.JRB_V70_8.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.107
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70_8MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V70_9);
        this.JRB_V70_9.setFont(new Font("Arial", 1, 12));
        this.JRB_V70_9.setText("V70_9");
        this.JRB_V70_9.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.108
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V70_9MouseClicked(evt);
            }
        });
        this.jbgVariable.add(this.JRB_V80_1);
        this.JRB_V80_1.setFont(new Font("Arial", 1, 12));
        this.JRB_V80_1.setText("V80_1");
        this.JRB_V80_1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.109
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultarInfoRes2463.this.JRB_V80_1MouseClicked(evt);
            }
        });
        GroupLayout xjpInformacionRelacionadaDXLayout = new GroupLayout(this.xjpInformacionRelacionadaDX);
        this.xjpInformacionRelacionadaDX.setLayout(xjpInformacionRelacionadaDXLayout);
        xjpInformacionRelacionadaDXLayout.setHorizontalGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addContainerGap().addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V38, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V39, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V40, -2, 80, -2)).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V53, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V54, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V55, -2, 80, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V41, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V42, -2, 80, -2)).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V56, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V57, -2, 80, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V58, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V59, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V60, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V61, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V62, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V62_1, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V62_2, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V62_3, -2, 80, -2)).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V43, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V44, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V45, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V46, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V47, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V48, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V49, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V50, -2, 80, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V51, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V52, -2, 80, -2)).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V62_4, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V62_5, -2, 80, -2)))).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V62_6, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V62_7, -2, 80, -2)).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V69_2, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V69_3, -2, 80, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V69_4, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V69_5, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V69_6, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V69_7, -2, 80, -2)).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V62_8, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V62_9, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRB_V62_10, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V62_11, -2, 80, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V63, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V63_1, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V64, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V65, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V66, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V67, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V68, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V69, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V69_1, -2, 80, -2)).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V70, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V70_1, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V70_2, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V70_3, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V70_4, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V70_5, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V70_6, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V70_7, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V70_8, -2, 80, -2)))).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addComponent(this.JRB_V70_9, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V71, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V72, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V73, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V74, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V75, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V76, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V77, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V78, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V79, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V80, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_V80_1, -2, 80, -2))).addContainerGap(17, 32767)));
        xjpInformacionRelacionadaDXLayout.setVerticalGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(xjpInformacionRelacionadaDXLayout.createSequentialGroup().addContainerGap().addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V39, -2, 30, -2).addComponent(this.JRB_V38, -2, 30, -2).addComponent(this.JRB_V40, -2, 30, -2).addComponent(this.JRB_V41, -2, 30, -2).addComponent(this.JRB_V42, -2, 30, -2).addComponent(this.JRB_V43, -2, 30, -2).addComponent(this.JRB_V44, -2, 30, -2).addComponent(this.JRB_V45, -2, 30, -2).addComponent(this.JRB_V46, -2, 30, -2).addComponent(this.JRB_V47, -2, 30, -2).addComponent(this.JRB_V48, -2, 30, -2).addComponent(this.JRB_V49, -2, 30, -2).addComponent(this.JRB_V50, -2, 30, -2).addComponent(this.JRB_V51, -2, 30, -2).addComponent(this.JRB_V52, -2, 30, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V53, -2, 30, -2).addComponent(this.JRB_V54, -2, 30, -2).addComponent(this.JRB_V55, -2, 30, -2).addComponent(this.JRB_V56, -2, 30, -2).addComponent(this.JRB_V57, -2, 30, -2).addComponent(this.JRB_V58, -2, 30, -2).addComponent(this.JRB_V59, -2, 30, -2).addComponent(this.JRB_V60, -2, 30, -2).addComponent(this.JRB_V61, -2, 30, -2).addComponent(this.JRB_V62, -2, 30, -2).addComponent(this.JRB_V62_1, -2, 30, -2).addComponent(this.JRB_V62_2, -2, 30, -2).addComponent(this.JRB_V62_3, -2, 30, -2).addComponent(this.JRB_V62_4, -2, 30, -2).addComponent(this.JRB_V62_5, -2, 30, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V63, -2, 30, -2).addComponent(this.JRB_V63_1, -2, 30, -2).addComponent(this.JRB_V64, -2, 30, -2).addComponent(this.JRB_V65, -2, 30, -2).addComponent(this.JRB_V66, -2, 30, -2).addComponent(this.JRB_V62_9, -2, 30, -2).addComponent(this.JRB_V67, -2, 30, -2).addComponent(this.JRB_V68, -2, 30, -2).addComponent(this.JRB_V69, -2, 30, -2).addComponent(this.JRB_V62_6, -2, 30, -2).addComponent(this.JRB_V62_7, -2, 30, -2).addComponent(this.JRB_V62_8, -2, 30, -2).addComponent(this.JRB_V69_1, -2, 30, -2).addComponent(this.JRB_V62_10, -2, 30, -2).addComponent(this.JRB_V62_11, -2, 30, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V69_4, -2, 30, -2).addComponent(this.JRB_V69_5, -2, 30, -2).addComponent(this.JRB_V69_6, -2, 30, -2).addComponent(this.JRB_V69_7, -2, 30, -2).addComponent(this.JRB_V70, -2, 30, -2).addComponent(this.JRB_V69_2, -2, 30, -2).addComponent(this.JRB_V69_3, -2, 30, -2).addComponent(this.JRB_V70_1).addComponent(this.JRB_V70_2).addComponent(this.JRB_V70_3).addComponent(this.JRB_V70_4).addComponent(this.JRB_V70_5, -2, 30, -2).addComponent(this.JRB_V70_6, -2, 30, -2).addComponent(this.JRB_V70_7, -2, 30, -2).addComponent(this.JRB_V70_8, -2, 30, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(xjpInformacionRelacionadaDXLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V71, -2, 30, -2).addComponent(this.JRB_V72, -2, 30, -2).addComponent(this.JRB_V73, -2, 30, -2).addComponent(this.JRB_V74, -2, 30, -2).addComponent(this.JRB_V75, -2, 30, -2).addComponent(this.JRB_V76, -2, 30, -2).addComponent(this.JRB_V77, -2, 30, -2).addComponent(this.JRB_V78, -2, 30, -2).addComponent(this.JRB_V70_9, -2, 30, -2).addComponent(this.JRB_V79, -2, 30, -2).addComponent(this.JRB_V80, -2, 30, -2).addComponent(this.JRB_V80_1, -2, 30, -2)).addContainerGap(19, 32767)));
        GroupLayout JPIPreparacionLayout = new GroupLayout(this.JPIPreparacion);
        this.JPIPreparacion.setLayout(JPIPreparacionLayout);
        JPIPreparacionLayout.setHorizontalGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreparacionLayout.createSequentialGroup().addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIPreparacionLayout.createSequentialGroup().addContainerGap().addComponent(this.xjpInformacionGeneral, -2, 1231, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPIPreparacionLayout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jButton1, -2, 427, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 412, 32767).addComponent(this.jButton2, -2, 369, -2))).addGroup(JPIPreparacionLayout.createSequentialGroup().addContainerGap().addComponent(this.xjpInformacionRelacionadaDX, -2, -1, -2))).addGap(18, 18, 18)));
        JPIPreparacionLayout.setVerticalGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreparacionLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.xjpInformacionGeneral, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.xjpInformacionRelacionadaDX, -2, -1, -2).addGap(44, 44, 44).addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 48, -2).addComponent(this.jButton2, -2, 48, -2)).addGap(214, 214, 214)));
        this.JTPDatos.addTab("PREPARACIÓN", this.JPIPreparacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 1252, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos, -2, 622, -2));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog((Component) null, "Confirma generar el archivo? ", "Generar Archivo", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                mCrearArchivo();
                JOptionPane.showMessageDialog((Component) null, "Se generó el archivo en la ruta :  " + this.sFichero, "Generar Archivo", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "No hay información para generar archivo", "Generar Archivo", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea limpiar la tabla?", "Limpiar la Tabla Resultados", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
            this.xResolucion2463_DAO.eliminarTablaReso2463();
            JOptionPane.showMessageDialog((Component) null, "La información se ha eliminado", "Información Eliminada", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else {
            JOptionPane.showMessageDialog((Component) null, "No se eliminó la información", "Información Eliminada", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V17MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V17;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog((Component) null, "Recuerde seleccionar rango de fecha", "Información", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea actualizar por lotes?", "Actualizar por Lotes", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
            mActualizarLotes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V18MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V18;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V19MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V19;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V20MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V20;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V24MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V24;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V27MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V27;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V19_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V19;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V21MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V21;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V21_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V21_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V22MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V22;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V23MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V23;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V25MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V25;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V26MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V26;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V27_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V27_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V28MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V28;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V28_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V28_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V29MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V29;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V30MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V30;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V30_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V30_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V31MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V31;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V32MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V32;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V32_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V32_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V33MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V33;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V34MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V34;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V34_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V34_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V35MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V35;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V36MouseEntered(MouseEvent evt) {
        this.xjrButton = this.JRB_V36;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V37MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V37;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V38MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V38;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V41MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V41;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V44MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V44;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V54MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V54;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V55MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V55;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V39MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V39;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V40MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V40;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V42MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V42;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V43MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V43;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V45MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V45;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V46MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V46;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V47MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V47;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V48MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V48;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V49MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V49;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V50MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V50;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V51MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V51;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V52MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V52;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V53MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V53;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V56MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V56;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V57MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V57;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V58MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V58;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V59MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V59;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V60MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V60;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V61MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V61;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_2MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_2;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_3MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_3;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_4MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_4;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_5MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V65;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_6MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_6;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_7MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_7;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_8MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_8;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_9MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_9;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_10MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_10;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62_11MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V62_11;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V63MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V63;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V63_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V63_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V64MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V64;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V65MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V65;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V66MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V66;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V67MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V67;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V68MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V68;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V69;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V69_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69_2MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V69_2;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69_3MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V69_3;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69_4MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V69_4;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69_5MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V69_5;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69_6MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V69_6;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69_7MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V69_7;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70_2MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70_2;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70_3MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70_3;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70_4MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70_4;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70_5MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70_5;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70_6MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70_6;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70_7MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70_7;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70_8MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70_8;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70_9MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V70_9;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V71MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V71;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V72MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V72;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V73MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V73;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V74MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V74;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V75MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V75;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V76MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V76;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V77MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V77;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V78MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V78;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V79MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V79;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V80MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V80;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V80_1MouseClicked(MouseEvent evt) {
        this.xjrButton = this.JRB_V80_1;
        JDVariablesResolucion2463 dialog = new JDVariablesResolucion2463(null, true, this.xjrButton.getText(), this, this.xjrButton);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1 && JOptionPane.showConfirmDialog((Component) null, "Seguro que desea eliminar el registro?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
            this.xModelo.removeRow(this.JTDetalle.getSelectedRow());
            mReorganizarConsecutivo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > 0) {
                JOptionPane.showMessageDialog((Component) null, "Cantidad de Filas : " + this.JTDetalle.getRowCount());
                if (JOptionPane.showConfirmDialog((Component) null, "Esta seguro de exportar la infomación? ", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                    mExportar();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "No existe información para exportar", "VERIFICAR", 2, new ImageIcon("src/Imagenes/Warning.png"));
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Seleccionar Ruta Válida", "VERIFICAR", 2, new ImageIcon("src/Imagenes/Warning.png"));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V35ActionPerformed(ActionEvent evt) {
    }

    private void mReorganizarConsecutivo() {
        this.xnregistro = 0L;
        if (this.JTDetalle.getRowCount() != -1) {
            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                this.xnregistro++;
                this.xModelo.setValueAt(Long.valueOf(this.xnregistro), y, 0);
            }
        }
        this.jtfTotalRegistro.setText("" + this.xnregistro);
    }

    private void mActualizarLotes() {
        this.xResolucion2463_DAO.mActualizarLotes(this.xjpInformacionGeneral, this.xjpInformacionRelacionadaDX, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
    }

    private void mCrearArchivo() {
        try {
            if (this.JCBEmpresa.getSelectedIndex() > -1) {
                this.sFichero = this.JTFRuta.getText() + "\\" + this.xComboEmpresa[this.JCBEmpresa.getSelectedIndex()][1] + "-AC-ERC-" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate()) + ".txt";
            } else {
                this.sFichero = this.JTFRuta.getText() + "\\AC-ERC-" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate()) + ".txt";
            }
            this.xmt.mEliminarArchivo(new File(this.sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.sFichero));
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                String xValor = "";
                for (int y = 0; y < this.JTDetalle.getColumnCount(); y++) {
                    if (y == this.JTDetalle.getColumnCount() - 1) {
                        xValor = xValor + this.xModelo.getValueAt(i, y).toString();
                    } else {
                        xValor = xValor + this.xModelo.getValueAt(i, y).toString() + "|";
                    }
                }
                bw.write(xValor);
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFFConsultarInfoRes2463.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        System.out.println(this.JTDetalle.getRowCount());
        System.out.println(this.xModelo.getValueAt(0, 0).toString());
    }

    private void mLlenarComboEmpresa() {
        this.JCBEmpresa.removeAllItems();
        List<GenericoComboDTO> list = this.xResolucion2463_DAO.comboEmpresa();
        this.xComboEmpresa = new String[list.size()][3];
        for (int x = 0; x < list.size(); x++) {
            this.xComboEmpresa[x][0] = String.valueOf(list.get(x).getId());
            this.xComboEmpresa[x][1] = String.valueOf(list.get(x).getNit());
            this.xComboEmpresa[x][2] = String.valueOf(list.get(x).getCodigo());
            this.JCBEmpresa.addItem(list.get(x).getNombre());
        }
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id_Registro", "V1_Nombre1", "V2_Nombre2", "V3_Apellido1", "V4_Apellido2", "V5_TipoDoc", "V6_NoDcomento", "V7_FechaNac", "V8_Sexo", "V9_TRegimen", "V10_CodEPS", "V11_IdEtnia", "V12_IdGruPobl", "V13_CodMpio", "V14_Telefono", "V15", "V16_CodIPS", "V17", "V18", "V19", "V19_1", "V20", "V21", "V21_1", "V22", "V23", "V24", "V25", "V26", "V27", "V27_1", "V28", "V28_1", "V29", "V29_1", "V30", "V30_1", "V31", "V31_1", "V32", "V32_1", "V33", "V33_1", "V34", "V34_1", "V35", "V36", "V37", "V38", "V39", "V40", "V41", "V42", "V43", "V44", "V45", "V46", "V47", "V48", "V49", "V50", "V51", "V52", "V53", "V54", "V55", "V56", "V57", "V58", "V59", "V60", "V61", "V62", "V62_1", "V62_2", "V62_3", "V62_4", "V62_5", "V62_6", "V62_7", "V62_8", "V62_9", "V62_10", "V62_11", "V63", "V63_1", "V64", "V65", "V66", "V67", "V68", "V69", "V69_1", "V69_2", "V69_3", "V69_4", "V69_5", "V69_6", "V69_7", "V70", "V70_1", "V70_2", "V70_3", "V70_4", "V70_5", "V70_6", "V70_7", "V70_8", "V70_9", "V71", "V72", "V73", "V74", "V75", "V76", "V77", "V78", "V79", "V80", "V80_1", "V81", "V81_1", "V82", "V82_1", "V83", "V83_1", "V84", "V84_1"}) { // from class: com.genoma.plus.controller.sig.JIFFConsultarInfoRes2463.110
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(53).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(54).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(55).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(56).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(57).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(58).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(59).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(60).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(61).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(62).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(63).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(64).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(65).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(66).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(67).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(68).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(69).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(70).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(71).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(72).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(73).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(74).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(75).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(76).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(77).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(78).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(79).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(80).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(81).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(82).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(83).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(84).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(85).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(86).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(87).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(88).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(89).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(90).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(91).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(92).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(93).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(94).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(95).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(96).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(97).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(98).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(99).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(100).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(101).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(102).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(103).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(104).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(105).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(106).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(107).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(108).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(109).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(110).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(111).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(112).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(113).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(114).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(115).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(116).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(117).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(118).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(119).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(120).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(121).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(122).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(123).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(124).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(125).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(126).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(127).setPreferredWidth(50);
    }

    private void mVerListadoCompleto() {
        if (this.jchFiltro.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                List<Object[]> list = this.xResolucion2463_DAO.mListadoCompleto(Integer.valueOf(this.xComboEmpresa[this.JCBEmpresa.getSelectedIndex()][0]).intValue());
                mCreaModelo();
                this.xnregistro = 0L;
                int cont = 0;
                for (int x = 0; x < list.size(); x++) {
                    this.xnregistro++;
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Long.valueOf(this.xnregistro), x, 0);
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
                    this.xModelo.setValueAt(list.get(x)[21], x, 21);
                    this.xModelo.setValueAt(list.get(x)[22], x, 22);
                    this.xModelo.setValueAt(list.get(x)[23], x, 23);
                    this.xModelo.setValueAt(list.get(x)[24], x, 24);
                    this.xModelo.setValueAt(list.get(x)[25], x, 25);
                    this.xModelo.setValueAt(list.get(x)[26], x, 26);
                    this.xModelo.setValueAt(list.get(x)[27], x, 27);
                    this.xModelo.setValueAt(list.get(x)[28], x, 28);
                    this.xModelo.setValueAt(list.get(x)[29], x, 29);
                    this.xModelo.setValueAt(list.get(x)[30], x, 30);
                    this.xModelo.setValueAt(list.get(x)[31], x, 31);
                    this.xModelo.setValueAt(list.get(x)[32], x, 32);
                    this.xModelo.setValueAt(list.get(x)[33], x, 33);
                    this.xModelo.setValueAt(list.get(x)[34], x, 34);
                    this.xModelo.setValueAt(list.get(x)[35], x, 35);
                    this.xModelo.setValueAt(list.get(x)[36], x, 36);
                    this.xModelo.setValueAt(list.get(x)[37], x, 37);
                    this.xModelo.setValueAt(list.get(x)[38], x, 38);
                    this.xModelo.setValueAt(list.get(x)[39], x, 39);
                    this.xModelo.setValueAt(list.get(x)[40], x, 40);
                    this.xModelo.setValueAt(list.get(x)[41], x, 41);
                    this.xModelo.setValueAt(list.get(x)[42], x, 42);
                    this.xModelo.setValueAt(list.get(x)[43], x, 43);
                    this.xModelo.setValueAt(list.get(x)[44], x, 44);
                    this.xModelo.setValueAt(list.get(x)[45], x, 45);
                    this.xModelo.setValueAt(list.get(x)[46], x, 46);
                    this.xModelo.setValueAt(list.get(x)[47], x, 47);
                    this.xModelo.setValueAt(list.get(x)[48], x, 48);
                    this.xModelo.setValueAt(list.get(x)[49], x, 49);
                    this.xModelo.setValueAt(list.get(x)[50], x, 50);
                    this.xModelo.setValueAt(list.get(x)[51], x, 51);
                    this.xModelo.setValueAt(list.get(x)[52], x, 52);
                    this.xModelo.setValueAt(list.get(x)[53], x, 53);
                    this.xModelo.setValueAt(list.get(x)[54], x, 54);
                    this.xModelo.setValueAt(list.get(x)[55], x, 55);
                    this.xModelo.setValueAt(list.get(x)[56], x, 56);
                    this.xModelo.setValueAt(list.get(x)[57], x, 57);
                    this.xModelo.setValueAt(list.get(x)[58], x, 58);
                    this.xModelo.setValueAt(list.get(x)[59], x, 59);
                    this.xModelo.setValueAt(list.get(x)[60], x, 60);
                    this.xModelo.setValueAt(list.get(x)[61], x, 61);
                    this.xModelo.setValueAt(list.get(x)[62], x, 62);
                    this.xModelo.setValueAt(list.get(x)[63], x, 63);
                    this.xModelo.setValueAt(list.get(x)[64], x, 64);
                    this.xModelo.setValueAt(list.get(x)[65], x, 65);
                    this.xModelo.setValueAt(list.get(x)[66], x, 66);
                    this.xModelo.setValueAt(list.get(x)[67], x, 67);
                    this.xModelo.setValueAt(list.get(x)[68], x, 68);
                    this.xModelo.setValueAt(list.get(x)[69], x, 69);
                    this.xModelo.setValueAt(list.get(x)[70], x, 70);
                    this.xModelo.setValueAt(list.get(x)[71], x, 71);
                    this.xModelo.setValueAt(list.get(x)[72], x, 72);
                    this.xModelo.setValueAt(list.get(x)[73], x, 73);
                    this.xModelo.setValueAt(list.get(x)[74], x, 74);
                    this.xModelo.setValueAt(list.get(x)[75], x, 75);
                    this.xModelo.setValueAt(list.get(x)[76], x, 76);
                    this.xModelo.setValueAt(list.get(x)[77], x, 77);
                    this.xModelo.setValueAt(list.get(x)[78], x, 78);
                    this.xModelo.setValueAt(list.get(x)[79], x, 79);
                    this.xModelo.setValueAt(list.get(x)[80], x, 80);
                    this.xModelo.setValueAt(list.get(x)[81], x, 81);
                    this.xModelo.setValueAt(list.get(x)[82], x, 82);
                    this.xModelo.setValueAt(list.get(x)[83], x, 83);
                    this.xModelo.setValueAt(list.get(x)[84], x, 84);
                    this.xModelo.setValueAt(list.get(x)[85], x, 85);
                    this.xModelo.setValueAt(list.get(x)[86], x, 86);
                    this.xModelo.setValueAt(list.get(x)[87], x, 87);
                    this.xModelo.setValueAt(list.get(x)[88], x, 88);
                    this.xModelo.setValueAt(list.get(x)[89], x, 89);
                    this.xModelo.setValueAt(list.get(x)[90], x, 90);
                    this.xModelo.setValueAt(list.get(x)[91], x, 91);
                    this.xModelo.setValueAt(list.get(x)[92], x, 92);
                    this.xModelo.setValueAt(list.get(x)[93], x, 93);
                    this.xModelo.setValueAt(list.get(x)[94], x, 94);
                    this.xModelo.setValueAt(list.get(x)[95], x, 95);
                    this.xModelo.setValueAt(list.get(x)[96], x, 96);
                    this.xModelo.setValueAt(list.get(x)[97], x, 97);
                    this.xModelo.setValueAt(list.get(x)[98], x, 98);
                    this.xModelo.setValueAt(list.get(x)[99], x, 99);
                    this.xModelo.setValueAt(list.get(x)[100], x, 100);
                    this.xModelo.setValueAt(list.get(x)[101], x, 101);
                    this.xModelo.setValueAt(list.get(x)[102], x, 102);
                    this.xModelo.setValueAt(list.get(x)[103], x, 103);
                    this.xModelo.setValueAt(list.get(x)[104], x, 104);
                    this.xModelo.setValueAt(list.get(x)[105], x, 105);
                    this.xModelo.setValueAt(list.get(x)[106], x, 106);
                    this.xModelo.setValueAt(list.get(x)[107], x, 107);
                    this.xModelo.setValueAt(list.get(x)[108], x, 108);
                    this.xModelo.setValueAt(list.get(x)[109], x, 109);
                    this.xModelo.setValueAt(list.get(x)[110], x, 110);
                    this.xModelo.setValueAt(list.get(x)[111], x, 111);
                    this.xModelo.setValueAt(list.get(x)[112], x, 112);
                    this.xModelo.setValueAt(list.get(x)[113], x, 113);
                    this.xModelo.setValueAt(list.get(x)[114], x, 114);
                    this.xModelo.setValueAt(list.get(x)[115], x, 115);
                    this.xModelo.setValueAt(list.get(x)[116], x, 116);
                    this.xModelo.setValueAt(list.get(x)[117], x, 117);
                    this.xModelo.setValueAt(list.get(x)[118], x, 118);
                    this.xModelo.setValueAt(list.get(x)[119], x, 119);
                    this.xModelo.setValueAt(list.get(x)[120], x, 120);
                    this.xModelo.setValueAt(list.get(x)[121], x, 121);
                    this.xModelo.setValueAt(list.get(x)[122], x, 122);
                    this.xModelo.setValueAt(list.get(x)[123], x, 123);
                    this.xModelo.setValueAt(list.get(x)[124], x, 124);
                    this.xModelo.setValueAt(list.get(x)[125], x, 125);
                    this.xModelo.setValueAt(list.get(x)[126], x, 126);
                    this.xModelo.setValueAt(list.get(x)[127], x, 127);
                    cont++;
                }
                this.jtfTotalRegistro.setText("" + this.xnregistro);
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "Seleccione una empresa", "Empresa", 0, new ImageIcon("src/Imagenes/Warning.png"));
            this.JCBEmpresa.requestFocus();
            return;
        }
        List<Object[]> list2 = this.xResolucion2463_DAO.mListadoCompleto1();
        mCreaModelo();
        this.xnregistro = 0L;
        int cont2 = 0;
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.xnregistro++;
            this.xModelo.addRow(this.xDatos);
            this.xModelo.setValueAt(Long.valueOf(this.xnregistro), x2, 0);
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
            this.xModelo.setValueAt(list2.get(x2)[21], x2, 21);
            this.xModelo.setValueAt(list2.get(x2)[22], x2, 22);
            this.xModelo.setValueAt(list2.get(x2)[23], x2, 23);
            this.xModelo.setValueAt(list2.get(x2)[24], x2, 24);
            this.xModelo.setValueAt(list2.get(x2)[25], x2, 25);
            this.xModelo.setValueAt(list2.get(x2)[26], x2, 26);
            this.xModelo.setValueAt(list2.get(x2)[27], x2, 27);
            this.xModelo.setValueAt(list2.get(x2)[28], x2, 28);
            this.xModelo.setValueAt(list2.get(x2)[29], x2, 29);
            this.xModelo.setValueAt(list2.get(x2)[30], x2, 30);
            this.xModelo.setValueAt(list2.get(x2)[31], x2, 31);
            this.xModelo.setValueAt(list2.get(x2)[32], x2, 32);
            this.xModelo.setValueAt(list2.get(x2)[33], x2, 33);
            this.xModelo.setValueAt(list2.get(x2)[34], x2, 34);
            this.xModelo.setValueAt(list2.get(x2)[35], x2, 35);
            this.xModelo.setValueAt(list2.get(x2)[36], x2, 36);
            this.xModelo.setValueAt(list2.get(x2)[37], x2, 37);
            this.xModelo.setValueAt(list2.get(x2)[38], x2, 38);
            this.xModelo.setValueAt(list2.get(x2)[39], x2, 39);
            this.xModelo.setValueAt(list2.get(x2)[40], x2, 40);
            this.xModelo.setValueAt(list2.get(x2)[41], x2, 41);
            this.xModelo.setValueAt(list2.get(x2)[42], x2, 42);
            this.xModelo.setValueAt(list2.get(x2)[43], x2, 43);
            this.xModelo.setValueAt(list2.get(x2)[44], x2, 44);
            this.xModelo.setValueAt(list2.get(x2)[45], x2, 45);
            this.xModelo.setValueAt(list2.get(x2)[46], x2, 46);
            this.xModelo.setValueAt(list2.get(x2)[47], x2, 47);
            this.xModelo.setValueAt(list2.get(x2)[48], x2, 48);
            this.xModelo.setValueAt(list2.get(x2)[49], x2, 49);
            this.xModelo.setValueAt(list2.get(x2)[50], x2, 50);
            this.xModelo.setValueAt(list2.get(x2)[51], x2, 51);
            this.xModelo.setValueAt(list2.get(x2)[52], x2, 52);
            this.xModelo.setValueAt(list2.get(x2)[53], x2, 53);
            this.xModelo.setValueAt(list2.get(x2)[54], x2, 54);
            this.xModelo.setValueAt(list2.get(x2)[55], x2, 55);
            this.xModelo.setValueAt(list2.get(x2)[56], x2, 56);
            this.xModelo.setValueAt(list2.get(x2)[57], x2, 57);
            this.xModelo.setValueAt(list2.get(x2)[58], x2, 58);
            this.xModelo.setValueAt(list2.get(x2)[59], x2, 59);
            this.xModelo.setValueAt(list2.get(x2)[60], x2, 60);
            this.xModelo.setValueAt(list2.get(x2)[61], x2, 61);
            this.xModelo.setValueAt(list2.get(x2)[62], x2, 62);
            this.xModelo.setValueAt(list2.get(x2)[63], x2, 63);
            this.xModelo.setValueAt(list2.get(x2)[64], x2, 64);
            this.xModelo.setValueAt(list2.get(x2)[65], x2, 65);
            this.xModelo.setValueAt(list2.get(x2)[66], x2, 66);
            this.xModelo.setValueAt(list2.get(x2)[67], x2, 67);
            this.xModelo.setValueAt(list2.get(x2)[68], x2, 68);
            this.xModelo.setValueAt(list2.get(x2)[69], x2, 69);
            this.xModelo.setValueAt(list2.get(x2)[70], x2, 70);
            this.xModelo.setValueAt(list2.get(x2)[71], x2, 71);
            this.xModelo.setValueAt(list2.get(x2)[72], x2, 72);
            this.xModelo.setValueAt(list2.get(x2)[73], x2, 73);
            this.xModelo.setValueAt(list2.get(x2)[74], x2, 74);
            this.xModelo.setValueAt(list2.get(x2)[75], x2, 75);
            this.xModelo.setValueAt(list2.get(x2)[76], x2, 76);
            this.xModelo.setValueAt(list2.get(x2)[77], x2, 77);
            this.xModelo.setValueAt(list2.get(x2)[78], x2, 78);
            this.xModelo.setValueAt(list2.get(x2)[79], x2, 79);
            this.xModelo.setValueAt(list2.get(x2)[80], x2, 80);
            this.xModelo.setValueAt(list2.get(x2)[81], x2, 81);
            this.xModelo.setValueAt(list2.get(x2)[82], x2, 82);
            this.xModelo.setValueAt(list2.get(x2)[83], x2, 83);
            this.xModelo.setValueAt(list2.get(x2)[84], x2, 84);
            this.xModelo.setValueAt(list2.get(x2)[85], x2, 85);
            this.xModelo.setValueAt(list2.get(x2)[86], x2, 86);
            this.xModelo.setValueAt(list2.get(x2)[87], x2, 87);
            this.xModelo.setValueAt(list2.get(x2)[88], x2, 88);
            this.xModelo.setValueAt(list2.get(x2)[89], x2, 89);
            this.xModelo.setValueAt(list2.get(x2)[90], x2, 90);
            this.xModelo.setValueAt(list2.get(x2)[91], x2, 91);
            this.xModelo.setValueAt(list2.get(x2)[92], x2, 92);
            this.xModelo.setValueAt(list2.get(x2)[93], x2, 93);
            this.xModelo.setValueAt(list2.get(x2)[94], x2, 94);
            this.xModelo.setValueAt(list2.get(x2)[95], x2, 95);
            this.xModelo.setValueAt(list2.get(x2)[96], x2, 96);
            this.xModelo.setValueAt(list2.get(x2)[97], x2, 97);
            this.xModelo.setValueAt(list2.get(x2)[98], x2, 98);
            this.xModelo.setValueAt(list2.get(x2)[99], x2, 99);
            this.xModelo.setValueAt(list2.get(x2)[100], x2, 100);
            this.xModelo.setValueAt(list2.get(x2)[101], x2, 101);
            this.xModelo.setValueAt(list2.get(x2)[102], x2, 102);
            this.xModelo.setValueAt(list2.get(x2)[103], x2, 103);
            this.xModelo.setValueAt(list2.get(x2)[104], x2, 104);
            this.xModelo.setValueAt(list2.get(x2)[105], x2, 105);
            this.xModelo.setValueAt(list2.get(x2)[106], x2, 106);
            this.xModelo.setValueAt(list2.get(x2)[107], x2, 107);
            this.xModelo.setValueAt(list2.get(x2)[108], x2, 108);
            this.xModelo.setValueAt(list2.get(x2)[109], x2, 109);
            this.xModelo.setValueAt(list2.get(x2)[110], x2, 110);
            this.xModelo.setValueAt(list2.get(x2)[111], x2, 111);
            this.xModelo.setValueAt(list2.get(x2)[112], x2, 112);
            this.xModelo.setValueAt(list2.get(x2)[113], x2, 113);
            this.xModelo.setValueAt(list2.get(x2)[114], x2, 114);
            this.xModelo.setValueAt(list2.get(x2)[115], x2, 115);
            this.xModelo.setValueAt(list2.get(x2)[116], x2, 116);
            this.xModelo.setValueAt(list2.get(x2)[117], x2, 117);
            this.xModelo.setValueAt(list2.get(x2)[118], x2, 118);
            this.xModelo.setValueAt(list2.get(x2)[119], x2, 119);
            this.xModelo.setValueAt(list2.get(x2)[120], x2, 120);
            this.xModelo.setValueAt(list2.get(x2)[121], x2, 121);
            this.xModelo.setValueAt(list2.get(x2)[122], x2, 122);
            this.xModelo.setValueAt(list2.get(x2)[123], x2, 123);
            this.xModelo.setValueAt(list2.get(x2)[124], x2, 124);
            this.xModelo.setValueAt(list2.get(x2)[125], x2, 125);
            this.xModelo.setValueAt(list2.get(x2)[126], x2, 126);
            this.xModelo.setValueAt(list2.get(x2)[127], x2, 127);
            cont2++;
        }
        this.jtfTotalRegistro.setText("" + this.xnregistro);
    }

    private void mExportar() {
        if (this.JCBEmpresa.getSelectedIndex() > -1) {
            this.sFichero = this.JTFRuta.getText() + "\\" + this.xComboEmpresa[this.JCBEmpresa.getSelectedIndex()][1] + "-AC-ERC-" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate());
        } else {
            this.sFichero = this.JTFRuta.getText() + "\\AC-ERC-" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate());
        }
        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.sFichero, getTitle());
    }
}
