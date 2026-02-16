package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.ConsultarNovedadDAOImpl;
import com.genoma.plus.dao.sig.ConsultarNovedadDAO;
import com.genoma.plus.dto.sig.ConsultarNovedadDTO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFConsultarNovedad.class */
public class JIFConsultarNovedad extends JInternalFrame {
    private DefaultTableModel xmodeloP;
    private DefaultTableModel xmodeloNP;
    private Object[] xDato;
    private String[] xComboNovedad;
    private ConsultarNovedadDAO xConsultarNovedadDAO;
    private JButton JBTExportar;
    private JComboBox JCBNovedad;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private int xtipo = 0;
    private Metodos xmt = new Metodos();
    private int xfiltro = 0;
    private boolean xlleno = false;

    public JIFConsultarNovedad() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xConsultarNovedadDAO = (ConsultarNovedadDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consultarNovedadDAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBNovedad.removeAllItems();
        this.xfiltro = 0;
        mLlenarCb();
    }

    private void mLlenarCb() {
        List<GenericoComboDTO> list = this.xConsultarNovedadDAO.comboNovedad();
        this.xComboNovedad = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xComboNovedad[x] = String.valueOf(list.get(x).getId());
            this.JCBNovedad.addItem(list.get(x).getNombre());
            System.out.println("Consulta " + list.get(x).getId());
            System.out.println("" + list.get(x).getNombre());
        }
        this.JCBNovedad.setSelectedIndex(-1);
        this.xlleno = true;
    }

    public void mBuscar() {
        System.out.println("entrs ");
        if (this.xfiltro == 1) {
            mBuscaDatosConFiltro();
            System.out.println("entrs1 ");
        } else {
            mBuscaDatosSinFiltro();
            System.out.println("entrs2 ");
        }
    }

    private void mBuscaDatosSinFiltro() {
        List<ConsultarNovedadDTO> list = this.xConsultarNovedadDAO.list(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        mCrearTablaNovedad();
        for (int x = 0; x < list.size(); x++) {
            this.xmodeloP.addRow(this.xDato);
            this.xmodeloP.setValueAt(list.get(x).getXNombre(), x, 0);
            this.xmodeloP.setValueAt(list.get(x).getXSexo(), x, 1);
            this.xmodeloP.setValueAt(list.get(x).getXDirreccion(), x, 2);
            this.xmodeloP.setValueAt(list.get(x).getXTelefono(), x, 3);
            this.xmodeloP.setValueAt(list.get(x).getXFecha(), x, 4);
            this.xmodeloP.setValueAt(list.get(x).getXTnovedad(), x, 5);
            this.xmodeloP.setValueAt(list.get(x).getXObservacion(), x, 6);
        }
    }

    private void mBuscaDatosConFiltro() {
        List<ConsultarNovedadDTO> list = this.xConsultarNovedadDAO.listF(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xComboNovedad[this.JCBNovedad.getSelectedIndex()]);
        mCrearTablaNovedad();
        for (int x = 0; x < list.size(); x++) {
            this.xmodeloP.addRow(this.xDato);
            this.xmodeloP.setValueAt(list.get(x).getXNombre(), x, 0);
            this.xmodeloP.setValueAt(list.get(x).getXSexo(), x, 1);
            this.xmodeloP.setValueAt(list.get(x).getXDirreccion(), x, 2);
            this.xmodeloP.setValueAt(list.get(x).getXTelefono(), x, 3);
            this.xmodeloP.setValueAt(list.get(x).getXFecha(), x, 4);
            this.xmodeloP.setValueAt(list.get(x).getXTnovedad(), x, 5);
            this.xmodeloP.setValueAt(list.get(x).getXObservacion(), x, 6);
        }
    }

    private void mCrearTablaNovedad() {
        this.xmodeloP = new DefaultTableModel() { // from class: com.genoma.plus.controller.sig.JIFConsultarNovedad.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodeloP.addColumn("Nombre Usuario");
        this.xmodeloP.addColumn("Sexo");
        this.xmodeloP.addColumn("Direccion");
        this.xmodeloP.addColumn("Telefono");
        this.xmodeloP.addColumn("Fecha Novedad");
        this.xmodeloP.addColumn("Tipo");
        this.xmodeloP.addColumn("Obsevacion");
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodeloP);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.setModel(this.xmodeloP);
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.JCHFiltro = new JCheckBox();
        this.JCBNovedad = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("Cita No Asignada");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFConsultarNovedad");
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro ?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarNovedad.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarNovedad.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCBNovedad.setFont(new Font("Arial", 1, 12));
        this.JCBNovedad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Novedad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNovedad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarNovedad.3
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarNovedad.this.JCBNovedadItemStateChanged(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarNovedad.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarNovedad.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarNovedad.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarNovedad.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JCBNovedad, -2, 304, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBNovedad, -2, -1, -2).addComponent(this.JCHFiltro))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2))).addGap(15, 15, 15)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFConsultarNovedad.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarNovedad.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFConsultarNovedad.7
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarNovedad.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarNovedad.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarNovedad.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 561, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, 32767).addComponent(this.JBTExportar, -2, 171, -2)).addComponent(this.jScrollPane1).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 302, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addGap(20, 20, 20)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.xfiltro = 1;
        } else {
            this.xfiltro = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNovedadItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
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
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }
}
