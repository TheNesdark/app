package com.genoma.plus.controller.facturacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.InformesFacturadosDAO;
import com.genoma.plus.dto.facturacion.InformesFacturadosDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIFInformesFacturadosController.class */
public class JIFInformesFacturadosController extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private String[] xIdGenerico;
    private InformesFacturadosDAO xInformesFacturadosDAO;
    private JButton JBTExportar;
    private JComboBox JCBGenerico;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JRadioButton JRBConvenio;
    private JRadioButton JRBNoAplica;
    private JRadioButton JRBServicios;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private int xtipo = 0;
    private String xNombre = "";
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;

    public JIFInformesFacturadosController(String xNombre) {
        initComponents();
        setTitle(xNombre.toUpperCase());
        setName(xNombre);
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformesFacturadosDAO = (InformesFacturadosDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesFacturadosDAO");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        if (getName().equals("Informe de Procedimientos Facturados")) {
            this.xNombre = "Procedimientos";
        }
        if (getName().equals("Informe de Insumos Facturados")) {
            this.xNombre = "Suministros";
        }
        this.JRBNoAplica.setSelected(true);
        JRBNoAplicaActionPerformed(null);
        mCrearTabla();
    }

    public void mBuscar() {
        mBuscaDatos();
    }

    private void mBuscaDatos() {
        List<InformesFacturadosDTO> list = null;
        if (getName().equals("Informe de Procedimientos Facturados")) {
            if (this.xtipo == 0) {
                list = this.xInformesFacturadosDAO.listProcedimientoFacturado(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "0", this.xtipo);
            } else {
                list = this.xInformesFacturadosDAO.listProcedimientoFacturado(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdGenerico[this.JCBGenerico.getSelectedIndex()], this.xtipo);
            }
        }
        if (getName().equals("Informe de Insumos Facturados")) {
            if (this.xtipo == 0) {
                list = this.xInformesFacturadosDAO.listSuministroFacturado(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "0", this.xtipo);
            } else {
                list = this.xInformesFacturadosDAO.listSuministroFacturado(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdGenerico[this.JCBGenerico.getSelectedIndex()], this.xtipo);
            }
        }
        mCrearTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getXId_identificacion(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getXNoDocumento(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getXApellido1(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getXApellido2(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getXNombre1(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getXNombre2(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getXIdsexo(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getXEdad(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getXTEdad(), x, 8);
            this.xmodelo.setValueAt(list.get(x).getXMunicipio(), x, 9);
            this.xmodelo.setValueAt(list.get(x).getXTelefono(), x, 10);
            this.xmodelo.setValueAt(list.get(x).getXMovil(), x, 11);
            this.xmodelo.setValueAt(list.get(x).getXNServicio(), x, 12);
            this.xmodelo.setValueAt(list.get(x).getXNEspecialidad(), x, 13);
            this.xmodelo.setValueAt(list.get(x).getXIdGenerico(), x, 14);
            this.xmodelo.setValueAt(list.get(x).getXNGenerico(), x, 15);
            this.xmodelo.setValueAt(list.get(x).getXFechaIngreso(), x, 16);
            this.xmodelo.setValueAt(list.get(x).getXNEmpresaConvenio(), x, 17);
            this.xmodelo.setValueAt(list.get(x).getXFechaOrden(), x, 18);
            this.xmodelo.setValueAt(list.get(x).getXHoraOrden(), x, 19);
            this.xmodelo.setValueAt(list.get(x).getXFacturador(), x, 20);
            this.xmodelo.setValueAt(list.get(x).getXValor(), x, 21);
            this.xmodelo.setValueAt(list.get(x).getXProfesional(), x, 22);
        }
    }

    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBGenerico = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JRBNoAplica = new JRadioButton();
        this.JRBConvenio = new JRadioButton();
        this.JRBServicios = new JRadioButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.1
            public void focusLost(FocusEvent evt) {
                JIFInformesFacturadosController.this.JDFechaIFocusLost(evt);
            }
        });
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesFacturadosController.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesFacturadosController.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.4
            public void itemStateChanged(ItemEvent evt) {
                JIFInformesFacturadosController.this.JCBGenericoItemStateChanged(evt);
            }
        });
        this.JCBGenerico.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.5
            public void actionPerformed(ActionEvent evt) {
                JIFInformesFacturadosController.this.JCBGenericoActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.buttonGroup1.add(this.JRBNoAplica);
        this.JRBNoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBNoAplica.setText("No Aplica");
        this.JRBNoAplica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformesFacturadosController.this.JRBNoAplicaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBConvenio);
        this.JRBConvenio.setFont(new Font("Arial", 1, 12));
        this.JRBConvenio.setText("Convenio");
        this.JRBConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.7
            public void actionPerformed(ActionEvent evt) {
                JIFInformesFacturadosController.this.JRBConvenioActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBServicios);
        this.JRBServicios.setFont(new Font("Arial", 1, 12));
        this.JRBServicios.setText("Servicio");
        this.JRBServicios.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.8
            public void actionPerformed(ActionEvent evt) {
                JIFInformesFacturadosController.this.JRBServiciosActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRBNoAplica).addGap(18, 18, 18).addComponent(this.JRBConvenio).addGap(18, 18, 18).addComponent(this.JRBServicios).addGap(0, 15, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNoAplica).addComponent(this.JRBConvenio).addComponent(this.JRBServicios)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBGenerico, -2, 497, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBGenerico).addContainerGap()).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addComponent(this.jPanel1, -2, -1, -2)).addGap(0, 0, 32767)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.9
            public void mouseClicked(MouseEvent evt) {
                JIFInformesFacturadosController.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.10
            public void actionPerformed(ActionEvent evt) {
                JIFInformesFacturadosController.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HÍSTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 211, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 332, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBTExportar, -1, -1, 32767)).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
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
    public void JRBNoAplicaActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico.setEnabled(false);
        this.JCBGenerico.removeAllItems();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConvenioActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico.setEnabled(true);
        mLLenarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBServiciosActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico.setEnabled(true);
        mLLenarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenericoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenericoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        mLLenarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        mLLenarCombo();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel() { // from class: com.genoma.plus.controller.facturacion.JIFInformesFacturadosController.11
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("CC");
        this.xmodelo.addColumn("NDocumento");
        this.xmodelo.addColumn("Apellido1");
        this.xmodelo.addColumn("Apellido2");
        this.xmodelo.addColumn("Nombre1");
        this.xmodelo.addColumn("Nombre2");
        this.xmodelo.addColumn("Sexo");
        this.xmodelo.addColumn("Edad");
        this.xmodelo.addColumn("TEdad");
        this.xmodelo.addColumn("Municipio");
        this.xmodelo.addColumn("Telefono");
        this.xmodelo.addColumn("Movil");
        this.xmodelo.addColumn("Servicio");
        this.xmodelo.addColumn("Especialidad");
        this.xmodelo.addColumn("Id");
        this.xmodelo.addColumn(this.xNombre);
        this.xmodelo.addColumn("FechaIngreso");
        this.xmodelo.addColumn("Convenio");
        this.xmodelo.addColumn("FechaOrden");
        this.xmodelo.addColumn("HoraOrden");
        this.xmodelo.addColumn("Facturador");
        this.xmodelo.addColumn("Valor");
        this.xmodelo.addColumn("Profesional");
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(120);
        if (getName().equals("Informe de Procedimientos Facturados")) {
            this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(300);
        } else {
            this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        }
        this.JTDetalle.setModel(this.xmodelo);
    }

    private void mLLenarCombo() {
        this.xlleno = false;
        this.JCBGenerico.removeAllItems();
        if (getName().equals("Informe de Procedimientos Facturados")) {
            if (this.xtipo == 1) {
                this.xIdGenerico = this.xct.llenarCombo("SELECT `f_empresacontxconvenio`.`Id` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConvenio` FROM `f_ordenes` INNER JOIN `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `g_persona` ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `f_itemordenesproced` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `f_tiposervicio` ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\nINNER JOIN `g_especialidad` ON (`f_ordenes`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN `g_procedimiento` ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nINNER JOIN `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN `f_liquidacion` ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `f_ordenes`.`Estado` =0 AND `f_liquidacion`.`Estado` =0) GROUP BY `f_empresacontxconvenio`.`Id`\nORDER BY `NEmpresaConvenio` ASC;", this.xIdGenerico, this.JCBGenerico);
            } else if (this.xtipo == 2) {
                this.xIdGenerico = this.xct.llenarCombo("SELECT `f_tiposervicio`.`Id` , `f_tiposervicio`.`Nbre` AS `NServicio` FROM `f_ordenes` INNER JOIN `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `g_persona` ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `f_itemordenesproced` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `f_tiposervicio` ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\nINNER JOIN `g_especialidad` ON (`f_ordenes`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN `g_procedimiento` ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nINNER JOIN `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN `f_liquidacion` ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `f_ordenes`.`Estado` =0 AND `f_liquidacion`.`Estado` =0) GROUP BY `f_tiposervicio`.`Id`\nORDER BY `NServicio` ASC ;", this.xIdGenerico, this.JCBGenerico);
            }
        }
        if (getName().equals("Informe de Insumos Facturados")) {
            if (this.xtipo == 1) {
                this.xIdGenerico = this.xct.llenarCombo("SELECT `f_empresacontxconvenio`.`Id` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConvenio` FROM `f_ordenes` INNER JOIN `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `g_persona` ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `f_itemordenessum` ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `f_tiposervicio` ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\nINNER JOIN `g_especialidad` ON (`f_ordenes`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN `i_suministro` ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nINNER JOIN `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN `f_liquidacion` ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `f_ordenes`.`Estado` =0 AND `f_liquidacion`.`Estado` =0) GROUP BY `f_empresacontxconvenio`.`Id`\nORDER BY `NEmpresaConvenio` ASC;", this.xIdGenerico, this.JCBGenerico);
            } else if (this.xtipo == 2) {
                this.xIdGenerico = this.xct.llenarCombo("SELECT `f_tiposervicio`.`Id`, `f_tiposervicio`.`Nbre` AS `NServicio` FROM `f_ordenes` INNER JOIN `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `g_persona` ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`) INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `f_itemordenessum` ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `f_tiposervicio` ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\nINNER JOIN `g_especialidad` ON (`f_ordenes`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN `i_suministro` ON (`f_itemordenessum`.`Id_Suministro`= `i_suministro`.`Id`)\nINNER JOIN `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN `f_liquidacion` ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `f_ordenes`.`Estado` =0 AND `f_liquidacion`.`Estado` =0)  GROUP BY `f_tiposervicio`.`Id`\nORDER BY `NServicio` ASC ;", this.xIdGenerico, this.JCBGenerico);
            }
            this.JCBGenerico.setSelectedIndex(-1);
            this.xlleno = true;
        }
    }
}
