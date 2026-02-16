package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl;
import com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO;
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
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFConsultarInformacionCronicos.class */
public class JIFConsultarInformacionCronicos extends JInternalFrame {
    private ConsultaInformacionCronicosDAO xConsultarInfomacionCronicosDAO;
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodeloP;
    private Object[] xDato;
    private String[] xIdConvenio;
    private boolean xLlenoC;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDetalle;
    private JPanel JPIPreparacion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JCheckBox jchFiltro;
    private JTextField jtfTotalRegistro;

    public JIFConsultarInformacionCronicos() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
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
        this.jtfTotalRegistro = new JTextField();
        this.JBTExportar = new JButton();
        this.JPIPreparacion = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN CRONICOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultarinformacioncronicos");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarInformacionCronicos.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInformacionCronicos.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarInformacionCronicos.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInformacionCronicos.this.JDFechaFPropertyChange(evt);
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
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sig.JIFConsultarInformacionCronicos.3
            public void keyPressed(KeyEvent evt) {
                JIFConsultarInformacionCronicos.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFConsultarInformacionCronicos.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInformacionCronicos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jtfTotalRegistro.setFont(new Font("Arial", 1, 12));
        this.jtfTotalRegistro.setHorizontalAlignment(0);
        this.jtfTotalRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Registros ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar a Excel");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarInformacionCronicos.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInformacionCronicos.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jtfTotalRegistro, -2, 166, -2).addGap(260, 260, 260).addComponent(this.JBTExportar, -2, 230, -2)).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 378, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 56, -2).addComponent(this.JBTExportar, -2, 68, -2).addComponent(this.jtfTotalRegistro, -2, 56, -2)).addContainerGap(17, 32767)));
        this.JPIDatos.getAccessibleContext().setAccessibleDescription("");
        this.JTPDatos.addTab("DETALLE", this.JPIDetalle);
        GroupLayout JPIPreparacionLayout = new GroupLayout(this.JPIPreparacion);
        this.JPIPreparacion.setLayout(JPIPreparacionLayout);
        JPIPreparacionLayout.setHorizontalGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1231, 32767));
        JPIPreparacionLayout.setVerticalGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 590, 32767));
        this.JTPDatos.addTab("PREPARACIÓN", this.JPIPreparacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatos, -2, 1252, -2).addGap(0, 12, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 636, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xLlenoC) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xLlenoC) {
            mLLenarCombo();
        }
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
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > 0) {
                if (JOptionPane.showConfirmDialog((Component) null, "Esta seguro de exportar la infomación? ", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle() + " - " + this.JCBEmpresa.getSelectedItem());
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

    private void springStart() {
        this.xConsultarInfomacionCronicosDAO = (ConsultarInformacionCronicosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consultarInformacionCronicosDAOImpl");
    }

    public void mNuevo() {
        this.xLlenoC = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        mLLenarCombo();
        mCreaModeloTabla();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xLlenoC = true;
    }

    private void mLLenarCombo() {
        this.JCBEmpresa.removeAllItems();
        List<Object[]> list = this.xConsultarInfomacionCronicosDAO.listaConvenios(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        if (!list.isEmpty()) {
            this.xIdConvenio = new String[list.size()];
            for (int x = 0; x < list.size(); x++) {
                this.xIdConvenio[x] = list.get(x)[0].toString();
                this.JCBEmpresa.addItem(list.get(x)[1].toString());
            }
            this.JCBEmpresa.setSelectedIndex(-1);
            this.xLlenoC = true;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xmodeloP = new DefaultTableModel(new Object[0], new String[]{"TipoDocIps", "Nit", "Entidad", "Codigo Organismo", "FechaAtencion", "TipoDocU", "IdentificacionU", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Sexo", "FechaNac", "Telefono", "Movil", "Dm", "HTA", "V3", "V6", "V7", "V8", "V9", "V10", "V11", "V12", "V13", "V14", "V15", "V16", "V17", "V18", "V19", "V20", "V21", "V22", "V23", "V24", "V25", "V26", "V27", "V28", "V29", "V30", "V31", "V32", "V33", "V34", "V35", "V36", "V37", "V38", "V39", "V40", "V41", "V42", "V43", "V44", "V45", "V46", "V47", "V48", "V49", "V50", "V51", "V52", "V53", "V54", "V55", "V56", "V57", "V58", "V59", "V60", "V61", "V62", "V63", "V64", "V65", "V66", "V67", "V68", "V69", "V70", "V71", "V72", "V73", "V74", "V75", "V76", "V77", "V78", "V79", "V80", "V81"}) { // from class: com.genoma.plus.controller.sig.JIFConsultarInformacionCronicos.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodeloP);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(53).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(54).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(55).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(56).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(57).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(58).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(59).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(60).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(61).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(62).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(63).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(64).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(65).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(66).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(67).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(68).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(69).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(70).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(71).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(72).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(73).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(74).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(75).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(76).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(77).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(78).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(79).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(80).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(81).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(82).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(83).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(84).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(85).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(86).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(87).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(88).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(89).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(90).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(91).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(92).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(93).setPreferredWidth(100);
    }

    public void mCargarDatosTabla() {
        List<Object[]> list = this.xConsultarInfomacionCronicosDAO.listaDatos();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodeloP.addRow(this.xDato);
                for (int i = 0; i < this.JTDetalle.getColumnCount(); i++) {
                    this.xmodeloP.setValueAt(list.get(x)[i], x, i);
                }
            }
            this.jtfTotalRegistro.setText("" + this.JTDetalle.getColumnCount());
        }
    }

    public void mBuscar() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            this.xConsultarInfomacionCronicosDAO.mEliminarDatosTabla();
            List<Object[]> list = this.xConsultarInfomacionCronicosDAO.listaConsultasSql();
            if (!list.isEmpty()) {
                for (int x = 0; x < list.size(); x++) {
                    if (Long.valueOf(list.get(x)[5].toString()).longValue() == 0) {
                        this.xConsultarInfomacionCronicosDAO.EjecutarConsultas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdConvenio[this.JCBEmpresa.getSelectedIndex()], list.get(x)[2].toString(), Long.valueOf(list.get(x)[4].toString()));
                    } else if (Long.valueOf(list.get(x)[5].toString()).longValue() == 1) {
                        List<Object[]> listc = this.xConsultarInfomacionCronicosDAO.listaAtencionesEspecialidad(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdConvenio[this.JCBEmpresa.getSelectedIndex()], list.get(x)[7].toString());
                        if (!list.isEmpty()) {
                            long xidUsuario = 0;
                            Long xValorVariable = Long.valueOf(list.get(x)[8].toString());
                            Long xLimite = Long.valueOf(list.get(x)[6].toString());
                            for (int y = 0; y < listc.size(); y++) {
                                System.out.println("" + listc.get(y)[0]);
                                if (xidUsuario != Long.valueOf(listc.get(y)[0].toString()).longValue()) {
                                    xValorVariable = Long.valueOf(list.get(x)[8].toString());
                                    xLimite = Long.valueOf(list.get(x)[6].toString());
                                    xidUsuario = Long.valueOf(listc.get(y)[0].toString()).longValue();
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable, listc.get(y)[1].toString(), listc.get(y)[0].toString());
                                } else if (xLimite.longValue() > 0) {
                                    xValorVariable = Long.valueOf(xValorVariable.longValue() + 1);
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable, listc.get(y)[1].toString(), listc.get(y)[0].toString());
                                    xidUsuario = Long.valueOf(listc.get(y)[0].toString()).longValue();
                                }
                                xLimite = Long.valueOf(xLimite.longValue() - 1);
                            }
                        }
                    } else if (Long.valueOf(list.get(x)[5].toString()).longValue() == 2) {
                        List<Object[]> listc2 = this.xConsultarInfomacionCronicosDAO.listaResultadoExamenProtocoloOrdenDES(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdConvenio[this.JCBEmpresa.getSelectedIndex()], list.get(x)[10].toString(), list.get(x)[9].toString());
                        if (!list.isEmpty()) {
                            long xidUsuario2 = 0;
                            Long xValorVariable2 = Long.valueOf(list.get(x)[8].toString());
                            Long xLimite2 = Long.valueOf(list.get(x)[6].toString());
                            for (int y2 = 0; y2 < listc2.size(); y2++) {
                                System.out.println("" + listc2.get(y2)[0]);
                                if (xidUsuario2 != Long.valueOf(listc2.get(y2)[0].toString()).longValue()) {
                                    xValorVariable2 = Long.valueOf(list.get(x)[8].toString());
                                    xLimite2 = Long.valueOf(list.get(x)[6].toString());
                                    xidUsuario2 = Long.valueOf(listc2.get(y2)[0].toString()).longValue();
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable2, listc2.get(y2)[1].toString(), listc2.get(y2)[0].toString());
                                } else if (xLimite2.longValue() > 0) {
                                    xValorVariable2 = Long.valueOf(xValorVariable2.longValue() + 1);
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable2, listc2.get(y2)[1].toString(), listc2.get(y2)[0].toString());
                                    xidUsuario2 = Long.valueOf(listc2.get(y2)[0].toString()).longValue();
                                }
                                xLimite2 = Long.valueOf(xLimite2.longValue() - 1);
                            }
                        }
                    } else if (Long.valueOf(list.get(x)[5].toString()).longValue() == 3) {
                        List<Object[]> listc3 = this.xConsultarInfomacionCronicosDAO.listaResultadoExamenProtocoloOrdenASC(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdConvenio[this.JCBEmpresa.getSelectedIndex()], list.get(x)[10].toString(), list.get(x)[9].toString());
                        if (!list.isEmpty()) {
                            long xidUsuario3 = 0;
                            Long xValorVariable3 = Long.valueOf(list.get(x)[8].toString());
                            Long xLimite3 = Long.valueOf(list.get(x)[6].toString());
                            for (int y3 = 0; y3 < listc3.size(); y3++) {
                                System.out.println("" + listc3.get(y3)[0]);
                                if (xidUsuario3 != Long.valueOf(listc3.get(y3)[0].toString()).longValue()) {
                                    xValorVariable3 = Long.valueOf(list.get(x)[8].toString());
                                    xLimite3 = Long.valueOf(list.get(x)[6].toString());
                                    xidUsuario3 = Long.valueOf(listc3.get(y3)[0].toString()).longValue();
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable3, listc3.get(y3)[1].toString(), listc3.get(y3)[0].toString());
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + (xValorVariable3.longValue() + 1), listc3.get(y3)[2].toString(), listc3.get(y3)[0].toString());
                                } else if (xLimite3.longValue() > 0) {
                                    xValorVariable3 = Long.valueOf(xValorVariable3.longValue() + 2);
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable3, listc3.get(y3)[1].toString(), listc3.get(y3)[0].toString());
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + (xValorVariable3.longValue() + 1), listc3.get(y3)[2].toString(), listc3.get(y3)[0].toString());
                                    xidUsuario3 = Long.valueOf(listc3.get(y3)[0].toString()).longValue();
                                }
                                xLimite3 = Long.valueOf(xLimite3.longValue() - 1);
                            }
                        }
                    } else if (Long.valueOf(list.get(x)[5].toString()).longValue() == 4) {
                        List<Object[]> listc4 = this.xConsultarInfomacionCronicosDAO.listaUltimaFechaRelizacionProcedimiento(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdConvenio[this.JCBEmpresa.getSelectedIndex()], list.get(x)[10].toString());
                        if (!list.isEmpty()) {
                            long xidUsuario4 = 0;
                            Long xValorVariable4 = Long.valueOf(list.get(x)[8].toString());
                            Long xLimite4 = Long.valueOf(list.get(x)[6].toString());
                            for (int y4 = 0; y4 < listc4.size(); y4++) {
                                System.out.println("" + listc4.get(y4)[0]);
                                if (xidUsuario4 != Long.valueOf(listc4.get(y4)[0].toString()).longValue()) {
                                    xValorVariable4 = Long.valueOf(list.get(x)[8].toString());
                                    xLimite4 = Long.valueOf(list.get(x)[6].toString());
                                    xidUsuario4 = Long.valueOf(listc4.get(y4)[0].toString()).longValue();
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable4, listc4.get(y4)[1].toString(), listc4.get(y4)[0].toString());
                                } else if (xLimite4.longValue() > 0) {
                                    xValorVariable4 = Long.valueOf(xValorVariable4.longValue() + 2);
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable4, listc4.get(y4)[1].toString(), listc4.get(y4)[0].toString());
                                    xidUsuario4 = Long.valueOf(listc4.get(y4)[0].toString()).longValue();
                                }
                                xLimite4 = Long.valueOf(xLimite4.longValue() - 1);
                            }
                        }
                    } else if (Long.valueOf(list.get(x)[5].toString()).longValue() == 5) {
                        List<Object[]> listc5 = this.xConsultarInfomacionCronicosDAO.listaUltimaEntregaMedicamentosInventario(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), list.get(x)[11].toString());
                        if (!list.isEmpty()) {
                            long xidUsuario5 = 0;
                            Long xValorVariable5 = Long.valueOf(list.get(x)[8].toString());
                            Long xLimite5 = Long.valueOf(list.get(x)[6].toString());
                            for (int y5 = 0; y5 < listc5.size(); y5++) {
                                System.out.println("" + listc5.get(y5)[0]);
                                if (xidUsuario5 != Long.valueOf(listc5.get(y5)[0].toString()).longValue()) {
                                    xValorVariable5 = Long.valueOf(list.get(x)[8].toString());
                                    xLimite5 = Long.valueOf(list.get(x)[6].toString());
                                    xidUsuario5 = Long.valueOf(listc5.get(y5)[0].toString()).longValue();
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable5, listc5.get(y5)[1].toString(), listc5.get(y5)[0].toString());
                                } else if (xLimite5.longValue() > 0) {
                                    xValorVariable5 = Long.valueOf(xValorVariable5.longValue() + 2);
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable5, listc5.get(y5)[1].toString(), listc5.get(y5)[0].toString());
                                    xidUsuario5 = Long.valueOf(listc5.get(y5)[0].toString()).longValue();
                                }
                                xLimite5 = Long.valueOf(xLimite5.longValue() - 1);
                            }
                        }
                    } else if (Long.valueOf(list.get(x)[5].toString()).longValue() == 6) {
                        List<Object[]> listc6 = this.xConsultarInfomacionCronicosDAO.listaUltimaFormulacionMedicamentosHistoria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), list.get(x)[11].toString());
                        if (!list.isEmpty()) {
                            long xidUsuario6 = 0;
                            Long xValorVariable6 = Long.valueOf(list.get(x)[8].toString());
                            Long xLimite6 = Long.valueOf(list.get(x)[6].toString());
                            for (int y6 = 0; y6 < listc6.size(); y6++) {
                                System.out.println("" + listc6.get(y6)[0]);
                                if (xidUsuario6 != Long.valueOf(listc6.get(y6)[0].toString()).longValue()) {
                                    xValorVariable6 = Long.valueOf(list.get(x)[8].toString());
                                    xLimite6 = Long.valueOf(list.get(x)[6].toString());
                                    xidUsuario6 = Long.valueOf(listc6.get(y6)[0].toString()).longValue();
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable6, listc6.get(y6)[2].toString(), listc6.get(y6)[0].toString());
                                } else if (xLimite6.longValue() > 0) {
                                    xValorVariable6 = Long.valueOf(xValorVariable6.longValue() + 2);
                                    this.xConsultarInfomacionCronicosDAO.actualizarVariableenTabla("V" + xValorVariable6, listc6.get(y6)[2].toString(), listc6.get(y6)[0].toString());
                                    xidUsuario6 = Long.valueOf(listc6.get(y6)[0].toString()).longValue();
                                }
                                xLimite6 = Long.valueOf(xLimite6.longValue() - 1);
                            }
                        }
                    }
                }
            }
            mCargarDatosTabla();
        }
    }
}
