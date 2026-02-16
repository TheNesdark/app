package com.genoma.plus.controller.facturacion;

import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.facturacion.ConsultarIngresoSoatDAO;
import com.genoma.plus.dao.impl.facturacion.ConsultarIngresoSoatDAOImpl;
import com.genoma.plus.dto.facturacion.ConsultarIngresoSoatDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIFConsultarIngresoSoat.class */
public class JIFConsultarIngresoSoat extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private String[] xIdGenerico;
    private ConsultarIngresoSoatDAO xConsultarIngresoSoatDAO;
    private WorkerSQL xWorkerSQL;
    private ButtonGroup BGFiltro;
    private JButton JBTExportar;
    private JComboBox JCBGenerico;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JRadioButton JRBEvento;
    private JRadioButton JRBSinEvento;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private int xtipo = 0;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFConsultarIngresoSoat() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xConsultarIngresoSoatDAO = (ConsultarIngresoSoatDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consultarIngresoSoatDAO");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBGenerico.removeAllItems();
        List<GCGenericoDTO> list1 = this.xConsultarIngresoSoatDAO.listTipoEmpresa(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xIdGenerico = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xIdGenerico[x] = String.valueOf(list1.get(x).getId());
            this.JCBGenerico.addItem(list1.get(x).getNombre());
        }
        this.JCBGenerico.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBGenerico.setSelectedIndex(-1);
        this.JRBTodos.setSelected(true);
        this.xtipo = 0;
        mCrearTabla();
    }

    public void mBuscar() {
        if (this.JCBGenerico.getSelectedIndex() != -1) {
            this.xWorkerSQL = new WorkerSQL("Cargando la Informacion", this);
            this.xWorkerSQL.execute();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa contratante", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBGenerico.requestFocus();
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("Identificacion");
        this.xmodelo.addColumn("No. Documento");
        this.xmodelo.addColumn("Usuario");
        this.xmodelo.addColumn("Sexo");
        this.xmodelo.addColumn("Convenio");
        this.xmodelo.addColumn("Fecha Ingreso");
        this.xmodelo.addColumn("IdIngreso");
        this.xmodelo.addColumn("No. Evento");
        this.xmodelo.addColumn("Estado");
        this.xmodelo.addColumn("Seguimiento");
        this.xmodelo.addColumn("No. Factura");
        this.xmodelo.addColumn("Registrado");
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
    }

    public void mBuscaDatos() {
        List<ConsultarIngresoSoatDTO> list = this.xConsultarIngresoSoatDAO.listConsultarIngresoSoat(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdGenerico[this.JCBGenerico.getSelectedIndex()], this.xtipo);
        mCrearTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 9);
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getIdTipoIdentificacion(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNDocumento(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getNUsuario(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getIdSexo(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getTercero(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getFechaIngreso(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getIdIngreso(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getNEvento(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getEstado(), x, 8);
            this.xmodelo.setValueAt(list.get(x).getSeguimiento(), x, 9);
            this.xmodelo.setValueAt(list.get(x).getNFactura(), x, 10);
            this.xmodelo.setValueAt(list.get(x).getURegistra(), x, 11);
        }
    }

    /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.BGFiltro = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBGenerico = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBEvento = new JRadioButton();
        this.JRBSinEvento = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INGRESOS CON EVENTO SOAT");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultaringresossoat");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.2
            public void focusLost(FocusEvent evt) {
                JIFConsultarIngresoSoat.this.JDFechaIFocusLost(evt);
            }
        });
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarIngresoSoat.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarIngresoSoat.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Empresa Contratante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.5
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarIngresoSoat.this.JCBGenericoItemStateChanged(evt);
            }
        });
        this.JCBGenerico.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarIngresoSoat.this.JCBGenericoActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.BGFiltro.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarIngresoSoat.this.JRBTodosActionPerformed(evt);
            }
        });
        this.BGFiltro.add(this.JRBEvento);
        this.JRBEvento.setFont(new Font("Arial", 1, 12));
        this.JRBEvento.setSelected(true);
        this.JRBEvento.setText("Evento");
        this.JRBEvento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarIngresoSoat.this.JRBEventoActionPerformed(evt);
            }
        });
        this.BGFiltro.add(this.JRBSinEvento);
        this.JRBSinEvento.setFont(new Font("Arial", 1, 12));
        this.JRBSinEvento.setText("Sin Evento");
        this.JRBSinEvento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarIngresoSoat.this.JRBSinEventoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRBTodos).addGap(18, 18, 18).addComponent(this.JRBEvento).addGap(18, 18, 18).addComponent(this.JRBSinEvento).addGap(0, 15, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBEvento).addComponent(this.JRBSinEvento)).addContainerGap(11, 32767)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBGenerico, -2, 497, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCBGenerico, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HÎstorico", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.10
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarIngresoSoat.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFConsultarIngresoSoat.11
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarIngresoSoat.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 211, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 332, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -1, 48, 32767).addComponent(this.JTFRuta, -1, 48, 32767)).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenericoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenericoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEventoActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinEventoActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
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
}
