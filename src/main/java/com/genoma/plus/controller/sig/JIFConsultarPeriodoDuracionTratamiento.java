package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.ConsultaPeriodoDuracionTratamientoDAOImpl;
import com.genoma.plus.dao.sig.ConsultaPeriodoDuracionTratamientoDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFConsultarPeriodoDuracionTratamiento.class */
public class JIFConsultarPeriodoDuracionTratamiento extends JInternalFrame {
    private ConsultaPeriodoDuracionTratamientoDAO xConsultarDuracionTratamientoDAO;
    private DefaultTableModel xmodeloP;
    private DefaultTableModel xmodeloP1;
    private Object[] xDato;
    private String[] xIdConvenio;
    private boolean xLlenoC;
    private ButtonGroup JBGFiltro;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHTabla1;
    private JCheckBox JCHTabla2;
    private JCheckBox JCH_Filtro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDetalle;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JTextField jtfTotalRegistro;
    private Metodos xmt = new Metodos();
    private boolean xFiltro = false;
    private String xIdEmpresa = "";

    public JIFConsultarPeriodoDuracionTratamiento() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIDetalle = new JPanel();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCH_Filtro = new JCheckBox();
        this.JCHTabla1 = new JCheckBox();
        this.JCHTabla2 = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.jtfTotalRegistro = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN DURACIÓN DE TRATAMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultarperiododuraciontratamiento");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarPeriodoDuracionTratamiento.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarPeriodoDuracionTratamiento.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarPeriodoDuracionTratamiento.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarPeriodoDuracionTratamiento.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarPeriodoDuracionTratamiento.3
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarPeriodoDuracionTratamiento.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Filtro");
        this.JCH_Filtro.setToolTipText("");
        this.JCH_Filtro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarPeriodoDuracionTratamiento.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarPeriodoDuracionTratamiento.this.JCH_FiltroActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JCHTabla1);
        this.JCHTabla1.setFont(new Font("Arial", 1, 12));
        this.JCHTabla1.setForeground(new Color(51, 0, 255));
        this.JCHTabla1.setSelected(true);
        this.JCHTabla1.setText("Fomato 1");
        this.JBGFiltro.add(this.JCHTabla2);
        this.JCHTabla2.setFont(new Font("Arial", 1, 12));
        this.JCHTabla2.setForeground(new Color(0, 0, 255));
        this.JCHTabla2.setText("Formato 2");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, 0, 740, 32767).addGap(18, 18, 18).addComponent(this.JCH_Filtro).addGap(22, 22, 22)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHTabla1).addGap(18, 18, 18).addComponent(this.JCHTabla2).addContainerGap(-1, 32767)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, -1, -2).addComponent(this.JCH_Filtro))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHTabla1).addComponent(this.JCHTabla2)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFConsultarPeriodoDuracionTratamiento.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarPeriodoDuracionTratamiento.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jtfTotalRegistro.setFont(new Font("Arial", 1, 12));
        this.jtfTotalRegistro.setHorizontalAlignment(0);
        this.jtfTotalRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Registros ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar a Excel");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFConsultarPeriodoDuracionTratamiento.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarPeriodoDuracionTratamiento.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JTFRuta, -1, 656, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jtfTotalRegistro, -2, 166, -2).addGap(134, 134, 134).addComponent(this.JBTExportar, -2, 211, -2)).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap(-1, 32767)));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 378, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 56, -2).addComponent(this.jtfTotalRegistro, -2, 56, -2).addComponent(this.JBTExportar, -2, 68, -2)).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("DETALLE", this.JPIDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatos, -2, 1205, -2).addGap(0, 19, 32767)));
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
            if (this.JTDetalle.getRowCount() > 0) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
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
    public void JCH_FiltroActionPerformed(ActionEvent evt) {
        if (this.JCH_Filtro.isSelected()) {
            this.xFiltro = true;
            mLLenarCombo();
        } else {
            this.xFiltro = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xLlenoC && this.JCBEmpresa.getSelectedIndex() != -1) {
            this.xIdEmpresa = this.xIdConvenio[this.JCBEmpresa.getSelectedIndex()];
        }
    }

    private void springStart() {
        this.xConsultarDuracionTratamientoDAO = (ConsultaPeriodoDuracionTratamientoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consultarPeriodoDuracionTratamientoDAOImpl");
    }

    public void mNuevo() {
        this.xLlenoC = false;
        this.xFiltro = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        mCreaModeloTabla();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "plantilla");
        this.jtfTotalRegistro.setText("0");
    }

    private void mLLenarCombo() {
        this.JCBEmpresa.removeAllItems();
        List<Object[]> list = this.xConsultarDuracionTratamientoDAO.listaEmpresa(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
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

    public void mBuscar() {
        if (this.JCH_Filtro.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                if (this.JCHTabla1.isSelected()) {
                    mCargarDatosT();
                    return;
                } else {
                    mCargarDatosForma2();
                    return;
                }
            }
            return;
        }
        if (this.JCHTabla1.isSelected()) {
            mCargarDatosT();
        } else {
            mCargarDatosForma2();
        }
    }

    private void mCargarDatosT() {
        System.out.println("" + this.xIdEmpresa);
        List<Object[]> list = this.xConsultarDuracionTratamientoDAO.listaInformacion(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdEmpresa, Boolean.valueOf(this.xFiltro));
        long xNfila = 0;
        mCreaModeloTabla();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodeloP.addRow(this.xDato);
                for (int i = 0; i < this.JTDetalle.getColumnCount(); i++) {
                    this.xmodeloP.setValueAt(list.get(x)[i], x, i);
                }
                xNfila++;
            }
        }
        this.jtfTotalRegistro.setText("" + xNfila);
    }

    private void mCargarDatosForma2() {
        System.out.println("" + this.xIdEmpresa);
        List<Object[]> list = this.xConsultarDuracionTratamientoDAO.listaInformacion2(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdEmpresa, Boolean.valueOf(this.xFiltro));
        long xNfila = 0;
        mCreaModeloTabla1();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodeloP1.addRow(this.xDato);
                for (int i = 0; i < this.JTDetalle.getColumnCount(); i++) {
                    this.xmodeloP1.setValueAt(list.get(x)[i], x, i);
                }
                xNfila++;
            }
        }
        this.jtfTotalRegistro.setText("" + xNfila);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xmodeloP = new DefaultTableModel(new Object[0], new String[]{"Identificacion", "Codigo Organismo", "Entidad", "IdentifiacionU", "DocumentoU", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "CodigoCum", "Nombre Suministro", "FechaOrden", "Duracion"}) { // from class: com.genoma.plus.controller.sig.JIFConsultarPeriodoDuracionTratamiento.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla1() {
        this.xmodeloP1 = new DefaultTableModel(new Object[0], new String[]{"Identificacion", "Codigo Organismo", "IpsAtencion", "IdentifiacionU", "DocumentoU", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "FechNacimiento", "Edad", "Sexo", "Direccion", "McipioProcedencia", "Telefono", "TipoAtencion", "Fecha_Dx", "Diagnostico", "CodigoCum", "Tratamiento_Formulado", "FechaOrden", "Duracion", "Municipio", "Dx_SaludMental", "Fech_Inicio_Tratamiento", "Suministro_Medicamento", "Tratamiento", "EnfoqueDiferencial", "Sin_Tratamiento", "Evaluacion_Proc_Ingreso", "Dx_Temprano"}) { // from class: com.genoma.plus.controller.sig.JIFConsultarPeriodoDuracionTratamiento.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodeloP1);
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
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(300);
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
    }
}
