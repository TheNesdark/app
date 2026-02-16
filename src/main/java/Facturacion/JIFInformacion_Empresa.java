package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
import javax.swing.JFormattedTextField;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFInformacion_Empresa.class */
public class JIFInformacion_Empresa extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private Object[] xdatos;
    private String[][] xidempresa;
    private String[] xidServicio;
    private String xsql;
    private String xnombre;
    private String filtro;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JButton JBTExportar;
    private JComboBox JCBTercero;
    private JCheckBox JCH_Anulada;
    private JCheckBox JCH_Filtro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPFiltro;
    private JPanel JPIDatos;
    private JPanel JPI_Interfaz;
    private JRadioButton JRBNormal;
    private JRadioButton JRBNuevaMuestra;
    private JRadioButton JRBTodo;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTable JTDetalle2;
    private JFormattedTextField JTFF_ValorT;
    private JFormattedTextField JTFNRegistro;
    private JTextField JTFRuta;
    private JTextField JTF_NFactura;
    private JTabbedPane JTPDatosC;
    private JPanel jPanel1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFInformacion_Empresa(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mNuevo();
        if (xnombre.equals("xjifconsulta_informacion_Hosp") || xnombre.equals("xjifconsulta_informacion_Hosp1")) {
            this.JCH_Anulada.setText("En Atención?");
            this.JCH_Anulada.setSelected(true);
            this.JTPDatosC.remove(2);
        }
    }

    /* JADX WARN: Type inference failed for: r3v68, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v88, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JBGFiltro = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTercero = new JComboBox();
        this.JCH_Filtro = new JCheckBox();
        this.JCH_Anulada = new JCheckBox();
        this.JTFNRegistro = new JFormattedTextField();
        this.JTFF_ValorT = new JFormattedTextField();
        this.jPanel1 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTPDatosC = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Interfaz = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JSPDetalle2 = new JScrollPane();
        this.JTDetalle2 = new JTable();
        this.JTF_NFactura = new JTextField();
        this.JPFiltro = new JPanel();
        this.JRBNuevaMuestra = new JRadioButton();
        this.JRBNormal = new JRadioButton();
        this.JRBTodo = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("EXÁMENES OCUPACIONALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("xjifconsulta_informacion_proc");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFInformacion_Empresa.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformacion_Empresa.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFInformacion_Empresa.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformacion_Empresa.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.setName("xjifconsultar_inf_empresa");
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Filtro");
        this.JCH_Anulada.setFont(new Font("Arial", 1, 12));
        this.JCH_Anulada.setForeground(Color.red);
        this.JCH_Anulada.setText("Anuladas?");
        this.JTFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNRegistro.setHorizontalAlignment(4);
        this.JTFNRegistro.setFont(new Font("Arial", 1, 12));
        this.JTFF_ValorT.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_ValorT.setHorizontalAlignment(4);
        this.JTFF_ValorT.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBTercero, -2, 438, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Filtro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Anulada).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNRegistro, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_ValorT, -2, 122, -2).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTercero, -2, 50, -2).addComponent(this.JCH_Filtro).addComponent(this.JCH_Anulada).addComponent(this.JTFNRegistro, -2, 50, -2).addComponent(this.JTFF_ValorT, -2, 50, -2)).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -1, -1, 32767)).addContainerGap()));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFInformacion_Empresa.3
            public void mouseClicked(MouseEvent evt) {
                JIFInformacion_Empresa.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Facturacion.JIFInformacion_Empresa.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformacion_Empresa.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 382, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 198, -2).addContainerGap(47, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addGap(0, 11, 32767)));
        this.JTPDatosC.setForeground(new Color(0, 103, 0));
        this.JTPDatosC.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFInformacion_Empresa.5
            public void mouseClicked(MouseEvent evt) {
                JIFInformacion_Empresa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatosC.addTab("DETALLADO POR GRUPO DE FACTURA", this.JSPDetalle);
        this.JSPDetalle1.setBorder((Border) null);
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFInformacion_Empresa.6
            public void mouseClicked(MouseEvent evt) {
                JIFInformacion_Empresa.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        GroupLayout JPI_InterfazLayout = new GroupLayout(this.JPI_Interfaz);
        this.JPI_Interfaz.setLayout(JPI_InterfazLayout);
        JPI_InterfazLayout.setHorizontalGroup(JPI_InterfazLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1100, 32767).addGroup(JPI_InterfazLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InterfazLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 1080, 32767).addContainerGap())));
        JPI_InterfazLayout.setVerticalGroup(JPI_InterfazLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 377, 32767).addGroup(JPI_InterfazLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_InterfazLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 355, 32767).addContainerGap())));
        this.JTPDatosC.addTab("INTERFAZ CONTABLE", this.JPI_Interfaz);
        this.JSPDetalle2.setBorder((Border) null);
        this.JTDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle2.setRowHeight(25);
        this.JTDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle2.setSelectionForeground(Color.red);
        this.JSPDetalle2.setViewportView(this.JTDetalle2);
        this.JTPDatosC.addTab("CONSOLIDADO POR EMPRESA", this.JSPDetalle2);
        this.JTF_NFactura.setFont(new Font("Arial", 1, 14));
        this.JTF_NFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTF_NFactura.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFInformacion_Empresa.7
            public void keyPressed(KeyEvent evt) {
                JIFInformacion_Empresa.this.JTF_NFacturaKeyPressed(evt);
            }
        });
        this.JPFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Muestra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGFiltro.add(this.JRBNuevaMuestra);
        this.JRBNuevaMuestra.setFont(new Font("Arial", 1, 12));
        this.JRBNuevaMuestra.setText("Nueva Muestra");
        this.JBGFiltro.add(this.JRBNormal);
        this.JRBNormal.setFont(new Font("Arial", 1, 12));
        this.JRBNormal.setText("Normal");
        this.JBGFiltro.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setText("Todos");
        GroupLayout JPFiltroLayout = new GroupLayout(this.JPFiltro);
        this.JPFiltro.setLayout(JPFiltroLayout);
        JPFiltroLayout.setHorizontalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNuevaMuestra).addGroup(JPFiltroLayout.createSequentialGroup().addComponent(this.JRBTodo).addGap(34, 34, 34).addComponent(this.JRBNormal))).addContainerGap(36, 32767)));
        JPFiltroLayout.setVerticalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFiltroLayout.createSequentialGroup().addGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBNormal)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNuevaMuestra).addGap(6, 6, 6)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosC).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_NFactura, -2, 168, -2)).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosC, -1, 414, 32767).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.JTF_NFactura, -2, 50, -2))).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPFiltro, -2, -1, -2))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportar();
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
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if ((this.xnombre.equals("xjifconsulta_informacion_proc") || this.xnombre.equals("xjif_procedimientos_Fac") || this.xnombre.equals("xjifconsulta_informacion_Hosp") || this.xnombre.equals("xjifconsulta_informacion_Hosp1")) && this.xlleno) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if ((this.xnombre.equals("xjifconsulta_informacion_proc") || this.xnombre.equals("xjif_procedimientos_Fac") || this.xnombre.equals("xjifconsulta_informacion_Hosp") || this.xnombre.equals("xjifconsulta_informacion_Hosp1")) && this.xlleno) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NFacturaKeyPressed(KeyEvent evt) {
        if (!this.JTF_NFactura.getText().isEmpty()) {
            if (this.JTPDatosC.getSelectedIndex() == 1) {
                mCargarDatosTabla_Interfaz(1);
            } else if (this.JTPDatosC.getSelectedIndex() == 0) {
                mCargarDatosTabla_3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1 && evt.getClickCount() == 2 && this.xnombre.equals("xjifconsulta_informacion_3")) {
            Principal.clasefacturacion.mImprimir_Factura_Relacion(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 11).toString(), this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 12).toString(), this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 20).toString(), this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 13).toString(), this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 10).toString(), this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 14).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            if (this.xnombre.equals("xjifconsulta_informacion_3")) {
                Principal.clasefacturacion.mImprimir_Factura_Relacion(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString());
            } else if (this.xnombre.equals("xjifconsulta_informacion_1")) {
                Principal.clasefacturacion.imprimir_FacturayOrden(1, this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 19).toString(), Principal.usuarioSistemaDTO.getLogin(), 0, 1, 1);
            }
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la información", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JTPDatosC.getSelectedIndex() == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(0));
            } else if (this.JTPDatosC.getSelectedIndex() == 1) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle1, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(1));
            } else {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle2, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(2));
            }
        }
    }

    private void mLlenarCombo() {
        this.xlleno = false;
        this.JCBTercero.removeAllItems();
        switch (this.xnombre) {
            case "xjifconsulta_informacion_1":
            case "xjifconsulta_informacion_2":
            case "xjifconsulta_informacion_3":
            case "xjif_recepcion_entidad_municipio":
            case "xjif_recepcion_entidad_municipio_proc":
            case "xjif_recepcion_municipio":
            case "xjif_recepcion_municipio_valor":
                this.JCBTercero.setVisible(false);
                this.JTPDatosC.setTitleAt(0, "DETALLE");
                break;
            case "xjifconsulta_informacion_Hosp":
            case "xjifconsulta_informacion_Hosp1":
                this.JTPDatosC.setTitleAt(0, "DETALLE");
                this.JTPDatosC.setTitleAt(1, "CONSOLIDADO");
                this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xsql = "SELECT\n  `g_tipoatencion`.`Id`,\n  `g_tipoatencion`.`Nbre` AS `Servicio`\nFROM\n  `h_atencion`\n  INNER JOIN `ingreso`\n    ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `profesional1`\n    ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `g_tipoedad`\n    ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n  INNER JOIN `g_tipoatencion`\n    ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\nWHERE (\n    `h_atencion`.`Codigo_Dxp` <> ''\n    AND `g_tipoatencion`.`Id_TipoAmbito` = 2\n    AND `ingreso`.`FechaIngreso` >= '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `ingreso`.`FechaIngreso` <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `ingreso`.`Estado` = 0\n  )\nGROUP BY `g_tipoatencion`.`Id`\nORDER BY `Servicio` ASC";
                this.xidServicio = this.xct.llenarCombo(this.xsql, this.xidServicio, this.JCBTercero);
                this.JCBTercero.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
                this.xlleno = true;
                break;
            default:
                this.xsql = "SELECT `f_empresacontxconvenio`.`Id`, `f_empresacontxconvenio`.`Nbre`, `f_empresacontxconvenio`.`EsCapitado` FROM `f_ordenes` INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `f_ordenes`.`Estado` =0) GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ";
                this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBTercero, 3);
                this.JCBTercero.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
                this.xlleno = true;
                break;
        }
    }

    public void mImprimir() {
        if (this.xnombre.equals("xjifconsulta_informacion_3")) {
            String[][] parametros1 = new String[5][2];
            parametros1[0][0] = "fechai";
            parametros1[0][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate());
            parametros1[1][0] = "fechaf";
            parametros1[1][1] = this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
            parametros1[2][0] = "Periodo";
            parametros1[2][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + " al " + this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
            parametros1[3][0] = "SUBREPORT_DIR";
            parametros1[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros1[4][0] = "SUBREPORTFIRMA_DIR";
            parametros1[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_ListadodeFacturasdeVentaR3878", parametros1);
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_ListadodeFacturasdeVentaR3878_Agrupado", parametros1);
        }
    }

    public void mBuscar() {
        if (this.JRBTodo.isSelected()) {
            this.filtro = "IN(0,1)";
        } else if (this.JRBNormal.isSelected()) {
            this.filtro = "IN(0)";
        } else if (this.JRBNuevaMuestra.isSelected()) {
            this.filtro = "IN(1)";
        }
        switch (this.xnombre) {
            case "xjifconsulta_informacion_proc":
                if (this.JCH_Filtro.isSelected()) {
                    if (this.JCBTercero.getSelectedIndex() != -1) {
                        if (this.xidempresa[this.JCBTercero.getSelectedIndex()][1].equals("0") || this.xidempresa[this.JCBTercero.getSelectedIndex()][1].equals("1")) {
                            this.xsql = "SELECT f_gruposervicio.`Nbre`,  `f_subgruposervicio`.`Nbre` AS `NSubgrupo`, `f_tiposervicio`.`Nbre` AS `NServicio`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, SUM(`f_itemordenesproced`.`Cantidad`) AS `Cantidad`, `f_itemordenesproced`.`ValorUnitario` AS `VUnitario`, ROUND(((SUM(`f_itemordenesproced`.`Cantidad`)*`f_itemordenesproced`.`ValorUnitario`)+f_itemordenesproced.valorImpuesto)) AS `VTotal`, f_empresacontxconvenio.Nbre as NEmpresa, `g_sedes`.`Nbre` AS NSede FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_tiposervicio`  ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `f_liquidacion`  ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_gruposervicio`.`Id_GrupoServicio` = `f_subgruposervicio`.`Id_GrupoServicio`) INNER JOIN  `g_sedes` ON (`g_sedes`.`Id` = `ingreso`.`Id_Sede`)  WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `ingreso`.`Id_EmpresaContxConv` ='" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "' AND `f_liquidacion`.`Estado` =0 AND `f_factura_capita`.`Estado` =0) GROUP BY f_gruposervicio.Id_GrupoServicio, `f_subgruposervicio`.Id_SubgrupoServicio, `g_procedimiento`.`Id`, `VUnitario` ORDER BY f_gruposervicio.`Nbre`, `NSubgrupo` ASC, `NProcedimiento` ASC ";
                        } else {
                            this.xsql = "SELECT f_gruposervicio.`Nbre`,  `f_subgruposervicio`.`Nbre` AS `NSubgrupo`, `f_tiposervicio`.`Nbre` AS `NServicio`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, SUM(`f_itemordenesproced`.`Cantidad`) AS `Cantidad`, `f_itemordenesproced`.`ValorUnitario` AS `VUnitario`, ROUND(((SUM(`f_itemordenesproced`.`Cantidad`)*`f_itemordenesproced`.`ValorUnitario`)+f_itemordenesproced.valorImpuesto)) AS `VTotal`, f_empresacontxconvenio.Nbre as NEmpresa, `g_sedes`.`Nbre` AS NSede  FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_tiposervicio`  ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `f_liquidacion`  ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_gruposervicio`.`Id_GrupoServicio` = `f_subgruposervicio`.`Id_GrupoServicio`)  INNER JOIN  `g_sedes` ON (`g_sedes`.`Id` = `ingreso`.`Id_Sede`) WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `ingreso`.`Id_EmpresaContxConv` ='" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "' AND `f_liquidacion`.`Estado` =0 ) GROUP BY f_gruposervicio.Id_GrupoServicio, `f_subgruposervicio`.Id_SubgrupoServicio, `g_procedimiento`.`Id`, `VUnitario` ORDER BY f_gruposervicio.`Nbre`, `NSubgrupo` ASC, `NProcedimiento` ASC ";
                        }
                        this.xct.llenarTabla(this.xsql, this.JTDetalle, this.xmodelo);
                    }
                    break;
                } else {
                    this.xsql = "SELECT f_gruposervicio.`Nbre`,  `f_subgruposervicio`.`Nbre` AS `NSubgrupo`, `f_tiposervicio`.`Nbre` AS `NServicio`, `g_procedimiento`.`Nbre` AS `NProcedimiento`, SUM(`f_itemordenesproced`.`Cantidad`) AS `Cantidad`, `f_itemordenesproced`.`ValorUnitario` AS `VUnitario`, ROUND(((SUM(`f_itemordenesproced`.`Cantidad`)*`f_itemordenesproced`.`ValorUnitario`)+f_itemordenesproced.valorImpuesto)) AS `VTotal`, f_empresacontxconvenio.Nbre as NEmpresa, `g_sedes`.`Nbre` AS NSede FROM `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_tiposervicio`  ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) INNER JOIN `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `f_liquidacion`  ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_gruposervicio`  ON (`f_gruposervicio`.`Id_GrupoServicio` = `f_subgruposervicio`.`Id_GrupoServicio`)  INNER JOIN  `g_sedes` ON (`g_sedes`.`Id` = `ingreso`.`Id_Sede`) WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'  AND `f_liquidacion`.`Estado` =0 ) GROUP BY f_gruposervicio.Id_GrupoServicio, `f_subgruposervicio`.Id_SubgrupoServicio, `g_procedimiento`.`Id`, `VUnitario` ORDER BY f_gruposervicio.`Nbre`, `NSubgrupo` ASC, `NProcedimiento` ASC ";
                    this.xct.llenarTabla(this.xsql, this.JTDetalle, this.xmodelo);
                    break;
                }
                break;
            case "xjifconsulta_informacion_1":
                mCargarDatosTabla();
                break;
            case "xjifconsulta_informacion_2":
                mCargarDatosTabla_2();
                break;
            case "xjifconsulta_informacion_3":
                if (this.JTPDatosC.getSelectedIndex() == 0) {
                    mCargarDatosTabla_3();
                    break;
                } else {
                    mCargarDatosTabla_Interfaz(0);
                    break;
                }
                break;
            case "xjif_recepcion_municipio":
                mCargarDatosTabla_4();
                break;
            case "xjif_recepcion_entidad_municipio":
                mCargarDatosTabla_5();
                break;
            case "xjif_recepcion_entidad_municipio_proc":
                mCargarDatosTabla_6();
                break;
            case "xjif_recepcion_municipio_valor":
                mCargarDatosTabla_7();
                break;
            case "xjif_procedimientos_Fac":
                mCargarDatosTabla_8();
                break;
            case "xjifconsulta_informacion_Hosp":
            case "xjifconsulta_informacion_Hosp1":
                mCargarDatosTabla_HP();
                mCargarDatosTabla_HP_1();
                break;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mLlenarCombo();
        this.JPFiltro.setVisible(false);
        switch (this.xnombre) {
            case "xjifconsulta_informacion_proc":
                mCrearModeloDatos_9();
                break;
            case "xjifconsulta_informacion_1":
                this.JTPDatosC.remove(1);
                mCrearModeloDatos_1();
                mCrearModeloDatos_CEmprsa();
                break;
            case "xjifconsulta_informacion_2":
                mCrearModeloDatos_2();
                break;
            case "xjifconsulta_informacion_3":
                this.JTFF_ValorT.setValue(0);
                this.JTFNRegistro.setValue(0);
                mCrearModeloDatos_3();
                mCrearModeloDatos_Interfaz();
                break;
            case "xjif_recepcion_municipio":
                this.JPFiltro.setVisible(true);
                this.JRBTodo.setSelected(true);
                mCrearModeloDatos_4();
                break;
            case "xjif_recepcion_entidad_municipio":
                this.JPFiltro.setVisible(true);
                this.JRBTodo.setSelected(true);
                mCrearModeloDatos_5();
                break;
            case "xjif_recepcion_entidad_municipio_proc":
                this.JPFiltro.setVisible(true);
                this.JRBTodo.setSelected(true);
                mCrearModeloDatos_6();
                break;
            case "xjif_recepcion_municipio_valor":
                this.JPFiltro.setVisible(true);
                this.JRBTodo.setSelected(true);
                mCrearModeloDatos_7();
                break;
            case "xjif_procedimientos_Fac":
                this.JPFiltro.setVisible(true);
                this.JRBTodo.setSelected(true);
                mCrearModeloDatos_8();
                break;
            case "xjifconsulta_informacion_Hosp":
            case "xjifconsulta_informacion_Hosp1":
                mCrearModeloDatos_HP();
                mCrearModeloDatos_HP1();
                break;
        }
        this.JDFechaI.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_HP() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha Ingreso", "Hora Ingreso", "Servicio Ingreso", "Fecha Egreso", "Hora  Egreso", "Servicio Egreso", "Documento", "Usuario", "Sexo", "Edad", "Dx", "Especialidad", "Profesional", "Empresa", "NAutorización", "Id_Ingreso", "Id_Usuario", "Cama", "Unidad Cama", "No  Dias", "Especialidad Egreso", "Profesional Egreso", "Diagnostico Egreso"}) { // from class: Facturacion.JIFInformacion_Empresa.8
            Class[] types = {Date.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class, String.class, Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(400);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_HP1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "Cantidad"}) { // from class: Facturacion.JIFInformacion_Empresa.9
            Class[] types = {Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "N°", "Historia", "Documento", "Usuario", "Empresa", "Servicio", "Estado", "V/Orden", "Copago", "CModeradora", "V/Total", "F_Evento", "UsuarioS", "Armada", "Concepto Anulación", "Fecha Anulación", "Usuario Anulación", "Observación Anulación", "Id_Ingreso", "Id_CCobro", "Id_Factura", "Id_CC_Cotanble", "NIps", "Regimen", "Sede", "Tipo de Atencion"}) { // from class: Facturacion.JIFInformacion_Empresa.10
            Class[] types = {String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_CEmprsa() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Empresa", "Nº Usuarios", "Valor"}) { // from class: Facturacion.JIFInformacion_Empresa.11
            Class[] types = {String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle2.setModel(this.xmodelo2);
        this.JTDetalle2.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle2.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle2.getColumnModel().getColumn(2).setPreferredWidth(40);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_2() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Especialidad", "Profesional", "Tiempo Atención", "Tiempo Inasistencia", "Total"}) { // from class: Facturacion.JIFInformacion_Empresa.12
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_3() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha_Factura", "N° Factura", "Tercero", "Concepto", "Valor", "Estado", "UsuarioS", "Armada", "Concepto Anulación", "Fecha Anulación", "Usuario Anulación", "Observación Anulación", "FVencimiento", "Id_Ingreso", "Id_CCobro", "Id_Factura", "Id_CC_Cotanble", "NIps", "Regimen", "Periodo", "Nit", "Sede", "Copago", "C/Moderadora", "Descuento", "NUsuario", "NDocumento"}) { // from class: Facturacion.JIFInformacion_Empresa.13
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
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
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_4() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Empresa", "N° Recepciones", "N° Examenes", "P_Rcepcion_Examen"}) { // from class: Facturacion.JIFInformacion_Empresa.14
            Class[] types = {String.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_5() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Empresa", "Municipio", "N° Recepciones", "N° Examenes", "P_Rcepcion_Examen"}) { // from class: Facturacion.JIFInformacion_Empresa.15
            Class[] types = {String.class, String.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_6() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Empresa", "Municipio", "Cups", "Nombre Procedimiento", "Cantidad"}) { // from class: Facturacion.JIFInformacion_Empresa.16
            Class[] types = {String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_7() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Municipio", "Valor"}) { // from class: Facturacion.JIFInformacion_Empresa.17
            Class[] types = {String.class, Double.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_8() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Documento", "Usuario", "Cup", "Nombre Procedimiento", "Cantidad", "Valor", "Municipio", "Remitido"}) { // from class: Facturacion.JIFInformacion_Empresa.18
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Long.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_9() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Grupo", "Subgrupo", "Servicio", "Nombre Procedimiento", "Cantidad", "V/Unitario", "V/Total", "Empresa", "Sede"}) { // from class: Facturacion.JIFInformacion_Empresa.19
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos_Interfaz() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"TipoDoc", "Numero", "Fecha", "CtaPUC", "Concepto", "Valor", "Naturaleza", "Id_Tercero", "NEmpresa", "Estado", "Tercero", "Id_Ingreso", "Id_CCobro", "Id_Factura", "Id_CC_Cotanble", "Armada", "Concepto Anulación", "Fecha Anulación", "Usuario Anulación", "Observación Anulación", "ValorL"}) { // from class: Facturacion.JIFInformacion_Empresa.20
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(5);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(20).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(20).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos_1();
            this.xsql = "SELECT `f_factura_capita`.`Fecha_FacturaCapita`, `f_factura_capita`.`No_FacturaCapita`, `g_usuario`.`NoHistoria`, CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`, CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`,\n`f_subgruposervicio`.`Nbre` AS `NServicio`, IF(`f_factura_capita`.`Estado`=0,'ACTIVA', 'ANULADA') AS `Estado`, f_liquidacion.`TotalServicio`, f_liquidacion.`Copago`, f_liquidacion.`CuotaModeradora`,(f_liquidacion.`TotalServicio`-(f_liquidacion.`Copago`+f_liquidacion.`CuotaModeradora`)) AS TotalOrden,   \nIFNULL(IF(f_factura_capita.`No_FacturaEvento`=0,0, IF((`f_factura_evento`.`Prefijo` =  ''),IF(((`g_ips`.`Nbre` =  'CLINICA OFTALMOLOGICA DAJUD SAS') OR (`g_ips`.`Nbre` =  'COD-OPTICA UT') OR (`g_ips`.`Nbre` =  'JAIME CESAR DAJUD FERNANDEZ')),`f_factura_evento`.`No_FacturaEvento_M`,`f_factura_evento`.`No_FacturaEvento_M`),CONCAT(`f_factura_evento`.`Prefijo`,_utf8'-',`f_factura_evento`.`No_FacturaEvento`))), '') AS FV\n,  `f_liquidacion`.`UsuarioS` \n, `f_factura_capita`.EstaArmada , f_factura_capita.`Motivo_Anulacion`,IF(f_factura_capita.`Fecha_Anulacion` IS NULL, '',f_factura_capita.`Fecha_Anulacion`) AS FAnulacion , f_factura_capita.`Usuario_Anulacion`,IF(f_factura_capita.`Observacion_Anulacion` IS NULL, '',f_factura_capita.`Observacion_Anulacion`) AS ObservacionAnulacion,\nf_liquidacion.`Id_Ingreso`, IF(f_factura_evento.`No_CuentaCobro` IS NULL, 0, f_factura_evento.`No_CuentaCobro`) AS Cuenta_Cobro, IF(f_factura_evento.`No_FacturaEvento` IS NULL, 0, f_factura_evento.`No_FacturaEvento`) AS `No_FacturaEvento`, IF(cc_cuentacobro.`Id` IS NULL, 0,cc_cuentacobro.`Id`)  AS Id_CContabilidad , g_ips.`Nbre` AS NEmpresa_G, f_tiporegimen.`Nbre` AS Regimen  , `g_sedes`.`Nbre` AS NSede, `g_tipoatencion`.`Nbre` TipoAtencion  \nFROM `f_factura_capita`  INNER JOIN `f_liquidacion`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN `g_tipoatencion`  ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`) INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`)  INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)  INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) \nINNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`)  LEFT JOIN `f_factura_evento`  ON (f_factura_capita.`No_FacturaEvento` = `f_factura_evento`.`No_FacturaEvento`)  LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`)  INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) \nINNER JOIN `f_tiporegimen`  ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)   INNER JOIN  `g_sedes` ON (`g_sedes`.`Id` = `ingreso`.`Id_Sede`) WHERE (`f_factura_capita`.`Fecha_FacturaCapita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' and f_empresacontxconvenio.Id_GIps='" + Principal.informacionIps.getId() + "' and `f_factura_capita`.`Fecha_FacturaCapita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') ORDER BY `f_factura_capita`.`No_FacturaCapita` ASC, `f_factura_capita`.`Fecha_FacturaCapita` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                double xvalor = 0.0d;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(10)), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 10);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(12)), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(15)), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(20)), n, 19);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(21)), n, 20);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(22)), n, 21);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(23)), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelo.setValueAt(xrs.getString("NSede"), n, 25);
                    this.xmodelo.setValueAt(xrs.getString("TipoAtencion"), n, 26);
                    xvalor += xrs.getDouble(12);
                    n++;
                }
                this.JTFNRegistro.setValue(Integer.valueOf(n + 1));
                this.JTFF_ValorT.setValue(Double.valueOf(xvalor));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_CEmpresa() {
        try {
            mCrearModeloDatos_CEmprsa();
            this.xsql = "`f_empresacontxconvenio`.`Nbre` AS `NEmpresa`, COUNT(g_persona.`Id`) NPersona, SUM(f_liquidacion.`TotalServicio`-(f_liquidacion.`Copago`+f_liquidacion.`CuotaModeradora`)) AS TotalOrden  FROM `f_factura_capita`  INNER JOIN `f_liquidacion`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`)  INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)  INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) \nINNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`)  LEFT JOIN `f_factura_evento`  ON (f_factura_capita.`No_FacturaEvento` = `f_factura_evento`.`No_FacturaEvento`)  LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`)  INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) \nINNER JOIN `f_tiporegimen`  ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)   INNER JOIN  `g_sedes` ON (`g_sedes`.`Id` = `ingreso`.`Id_Sede`) WHERE (`f_factura_capita`.`Fecha_FacturaCapita` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' and f_empresacontxconvenio.Id_GIps='" + Principal.informacionIps.getId() + "' and `f_factura_capita`.`Fecha_FacturaCapita` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')  GROUP BY f_empresacontxconvenio.`Id` ORDER BY `f_factura_capita`.`No_FacturaCapita` ASC, `f_factura_capita`.`Fecha_FacturaCapita` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_2() {
        try {
            mCrearModeloDatos_2();
            this.xsql = "SELECT  DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS Fecha , `profesional1`.`Especialidad`, `profesional1`.`NProfesional` , ROUND((SUM(`c_clasecita`.`Duracion`)/60),2) AS TAtencion , IF(`v_c_citas_tiempo_inasistencia`.`Tiempo` IS NULL, 0,`v_c_citas_tiempo_inasistencia`.`Tiempo`)  AS TInasistencia, (ROUND((SUM(`c_clasecita`.`Duracion`)/60),2)+IF(`v_c_citas_tiempo_inasistencia`.`Tiempo` IS NULL, 0,`v_c_citas_tiempo_inasistencia`.`Tiempo`)) AS Total FROM  `h_atencion` INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_especialidad`  ON (`c_clasecita`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) LEFT JOIN `v_c_citas_tiempo_inasistencia`  ON (`v_c_citas_tiempo_inasistencia`.`Fecha_Cita` = `h_atencion`.`Fecha_Atencion`) AND (`v_c_citas_tiempo_inasistencia`.`Id_Profesional` = `h_atencion`.`Id_Profesional`) AND (`v_c_citas_tiempo_inasistencia`.`Id_Especialidad` = `h_atencion`.`Id_Especialidad`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `g_especialidad`.`EsOdontologia` =0 AND `g_especialidad`.`EsPyP` =0) GROUP BY `h_atencion`.`Fecha_Atencion`, `profesional1`.`NProfesional` ORDER BY `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC, `h_atencion`.`Fecha_Atencion` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_3() {
        try {
            mCrearModeloDatos_3();
            double xtotal = 0.0d;
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT")) {
                if (this.JCH_Anulada.isSelected()) {
                    this.xsql = "SELECT  DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d-%m-%Y') AS fecha , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`)) AS `NFactura` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , IF((`f_factura_evento`.`ConceptoCobro` IS NULL OR `f_factura_evento`.`ConceptoCobro`=''), `f_subgruposervicio`.`Nbre`,`f_factura_evento`.`ConceptoCobro`) AS `ConceptoC` , IF(`f_liquidacion`.`TotalEps`=0, `f_liquidacion`.`TotalServicio`,`f_liquidacion`.`TotalEps`) AS `TotalFactura` , IF(`f_factura_evento`.`Estado`=0,'ACTIVA', 'ANULADA') AS ESTADO,  `f_liquidacion`.`UsuarioS`, IF(`f_factura_evento`.EstaArmada=0,'PENDIENTE',IF(`f_factura_evento`.EstaArmada=1,'ARMADA', 'PRESENTADA')) EstaArmada   , f_factura_evento.`Motivo_Anulacion`,IF(f_factura_evento.`Fecha_Anulacion` IS NULL, '',f_factura_evento.`Fecha_Anulacion`) AS FAnulacion , f_factura_evento.`Usuario_Anulacion`,IF(f_factura_evento.`Observacion_Anulacion` IS NULL, '',f_factura_evento.`Observacion_Anulacion`) AS ObservacionAnulacion, DATE_FORMAT(ADDDATE(`f_factura_evento`.`Fecha_FacturaEvento`, INTERVAL f_empresacontxconvenio.`NDiasP` DAY),'%d-%m-%Y') AS NFechaV    ,f_liquidacion.`Id_Ingreso`,   f_factura_evento.`No_CuentaCobro`, f_factura_evento.`No_FacturaEvento`, IF(cc_cuentacobro.`Id` IS NULL, 0,cc_cuentacobro.`Id`)  AS Id_CContabilidad , g_ips.`Nbre` AS NEmpresa_G, f_tiporegimen.`Nbre` AS Regimen,  if(cc_periodo_contable.`Nbre` is null, '',cc_periodo_contable.`Nbre`) AS Periodo   , cc_terceros.`No_identificacion`, f_liquidacion.`Copago`, f_liquidacion.`CuotaModeradora`, f_liquidacion.`TotalDescuento`,ifnull(persona.NUsuario, '') NUsuario, ifnull(persona.NoDocumento, '') NoDocumento FROM  `f_factura_evento` INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`) LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`) INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN `f_tiporegimen`  ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)    LEFT JOIN `f_cuentacobro`  ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)  LEFT JOIN `cc_periodo_contable`  ON (`f_cuentacobro`.`Id_PeriodoC`= `cc_periodo_contable`.`Id`) INNER JOIN `cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`) \n left JOIN  ingreso  ON (ingreso.id = `f_liquidacion`.`Id_Ingreso`)\nleft JOIN  persona  ON (ingreso.Id_Usuario = `persona`.`Id_persona`)\nWHERE (IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`))<>0 and f_empresacontxconvenio.Id_GIps='" + Principal.informacionIps.getId() + "' and DATE_FORMAT(`f_factura_evento`.`Fecha_Anulacion`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`f_factura_evento`.`Fecha_Anulacion`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') ORDER BY `NFactura` ASC ";
                } else {
                    this.xsql = "SELECT  DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d-%m-%Y') AS fecha , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`)) AS `NFactura` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , IF((`f_factura_evento`.`ConceptoCobro` IS NULL OR `f_factura_evento`.`ConceptoCobro`=''), `f_subgruposervicio`.`Nbre`,`f_factura_evento`.`ConceptoCobro`) AS `ConceptoC` , IF(`f_liquidacion`.`TotalEps`=0, `f_liquidacion`.`TotalServicio`,`f_liquidacion`.`TotalEps`) AS `TotalFactura` , IF(`f_factura_evento`.`Estado`=0,'ACTIVA', 'ANULADA') AS ESTADO,  `f_liquidacion`.`UsuarioS`,  IF(`f_factura_evento`.EstaArmada=0,'PENDIENTE',IF(`f_factura_evento`.EstaArmada=1,'ARMADA', 'PRESENTADA')) EstaArmada   , f_factura_evento.`Motivo_Anulacion`,IF(f_factura_evento.`Fecha_Anulacion` IS NULL, '',f_factura_evento.`Fecha_Anulacion`) AS FAnulacion , f_factura_evento.`Usuario_Anulacion`,IF(f_factura_evento.`Observacion_Anulacion` IS NULL, '',f_factura_evento.`Observacion_Anulacion`) AS ObservacionAnulacion, DATE_FORMAT(ADDDATE(`f_factura_evento`.`Fecha_FacturaEvento`, INTERVAL f_empresacontxconvenio.`NDiasP` DAY),'%d-%m-%Y') AS NFechaV    ,f_liquidacion.`Id_Ingreso`,   f_factura_evento.`No_CuentaCobro`, f_factura_evento.`No_FacturaEvento`, IF(cc_cuentacobro.`Id` IS NULL, 0,cc_cuentacobro.`Id`)  AS Id_CContabilidad , g_ips.`Nbre` AS NEmpresa_G, f_tiporegimen.`Nbre` AS Regimen, if(cc_periodo_contable.`Nbre` is null, '',cc_periodo_contable.`Nbre`)  AS Periodo   , cc_terceros.`No_identificacion`, f_liquidacion.`Copago`, f_liquidacion.`CuotaModeradora`, f_liquidacion.`TotalDescuento`,ifnull(persona.NUsuario, '') NUsuario, ifnull(persona.NoDocumento, '') NoDocumento FROM  `f_factura_evento` INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`) LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`) INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN `f_tiporegimen`  ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)    LEFT JOIN `f_cuentacobro`  ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)  LEFT JOIN `cc_periodo_contable`  ON (`f_cuentacobro`.`Id_PeriodoC`= `cc_periodo_contable`.`Id`) INNER JOIN `cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`)  \n left JOIN  ingreso  ON (ingreso.id = `f_liquidacion`.`Id_Ingreso`)\nleft JOIN  persona  ON (ingreso.Id_Usuario = `persona`.`Id_persona`)\nWHERE (IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`))<>0 and `f_factura_evento`.`Fecha_FacturaEvento` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' and f_empresacontxconvenio.Id_GIps='" + Principal.informacionIps.getId() + "' AND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "') ORDER BY `NFactura` ASC ";
                }
            } else if (this.JTF_NFactura.getText().isEmpty()) {
                if (this.JCH_Anulada.isSelected()) {
                    this.xsql = "SELECT  DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d-%m-%Y') AS fecha , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento`)) AS `NFactura` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , IF((`f_factura_evento`.`ConceptoCobro` IS NULL OR `f_factura_evento`.`ConceptoCobro`=''), `f_subgruposervicio`.`Nbre`,`f_factura_evento`.`ConceptoCobro`) AS `ConceptoC` , IF(`f_liquidacion`.`TotalEps`=0, `f_liquidacion`.`TotalServicio`,`f_liquidacion`.`TotalEps`) AS `TotalFactura` , IF(`f_factura_evento`.`Estado`=0,'ACTIVA', 'ANULADA') AS ESTADO,  `f_liquidacion`.`UsuarioS`, IF(`f_factura_evento`.EstaArmada=0,'PENDIENTE',IF(`f_factura_evento`.EstaArmada=1,'ARMADA', 'PRESENTADA')) EstaArmada   , f_factura_evento.`Motivo_Anulacion`,IF(f_factura_evento.`Fecha_Anulacion` IS NULL, '',f_factura_evento.`Fecha_Anulacion`) AS FAnulacion , f_factura_evento.`Usuario_Anulacion`,IF(f_factura_evento.`Observacion_Anulacion` IS NULL, '',f_factura_evento.`Observacion_Anulacion`) AS ObservacionAnulacion, DATE_FORMAT(ADDDATE(`f_factura_evento`.`Fecha_FacturaEvento`, INTERVAL f_empresacontxconvenio.`NDiasP` DAY),'%d-%m-%Y') AS NFechaV    ,f_liquidacion.`Id_Ingreso`,   f_factura_evento.`No_CuentaCobro`, f_factura_evento.`No_FacturaEvento`, IF(cc_cuentacobro.`Id` IS NULL, 0,cc_cuentacobro.`Id`)  AS Id_CContabilidad , g_ips.`Nbre` AS NEmpresa_G, f_tiporegimen.`Nbre` AS Regimen,  if(cc_periodo_contable.`Nbre` is null, '',cc_periodo_contable.`Nbre`) AS Periodo  , cc_terceros.`No_identificacion`, f_liquidacion.`Copago`, f_liquidacion.`CuotaModeradora`, f_liquidacion.`TotalDescuento`,ifnull(persona.NUsuario, '') NUsuario, ifnull(persona.NoDocumento, '') NoDocumento FROM  `f_factura_evento` INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`) LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`) INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN `f_tiporegimen`  ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)    LEFT JOIN `f_cuentacobro`  ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)  LEFT JOIN `cc_periodo_contable`  ON (`f_cuentacobro`.`Id_PeriodoC`= `cc_periodo_contable`.`Id`)INNER JOIN `cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`) \n  left JOIN  ingreso  ON (ingreso.id = `f_liquidacion`.`Id_Ingreso`)\nleft JOIN  persona  ON (ingreso.Id_Usuario = `persona`.`Id_persona`)\nWHERE (`f_factura_evento`.`Fecha_FacturaEvento` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `f_factura_evento`.`Estado`=1) ORDER BY `NFactura` ASC ";
                } else {
                    this.xsql = "SELECT  DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d-%m-%Y') AS fecha , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento`)) AS `NFactura` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , IF((`f_factura_evento`.`ConceptoCobro` IS NULL OR `f_factura_evento`.`ConceptoCobro`=''), `f_subgruposervicio`.`Nbre`,`f_factura_evento`.`ConceptoCobro`) AS `ConceptoC` , IF(`f_liquidacion`.`TotalEps`=0, `f_liquidacion`.`TotalServicio`,`f_liquidacion`.`TotalEps`) AS `TotalFactura` , IF(`f_factura_evento`.`Estado`=0,'ACTIVA', 'ANULADA') AS ESTADO,  `f_liquidacion`.`UsuarioS`, IF(`f_factura_evento`.EstaArmada=0,'PENDIENTE',IF(`f_factura_evento`.EstaArmada=1,'ARMADA', 'PRESENTADA')) EstaArmada   , f_factura_evento.`Motivo_Anulacion`,IF(f_factura_evento.`Fecha_Anulacion` IS NULL, '',f_factura_evento.`Fecha_Anulacion`) AS FAnulacion , f_factura_evento.`Usuario_Anulacion`,IF(f_factura_evento.`Observacion_Anulacion` IS NULL, '',f_factura_evento.`Observacion_Anulacion`) AS ObservacionAnulacion, DATE_FORMAT(ADDDATE(`f_factura_evento`.`Fecha_FacturaEvento`, INTERVAL f_empresacontxconvenio.`NDiasP` DAY),'%d-%m-%Y') AS NFechaV    ,f_liquidacion.`Id_Ingreso`,   f_factura_evento.`No_CuentaCobro`, f_factura_evento.`No_FacturaEvento`, IF(cc_cuentacobro.`Id` IS NULL, 0,cc_cuentacobro.`Id`)  AS Id_CContabilidad , g_ips.`Nbre` AS NEmpresa_G, f_tiporegimen.`Nbre` AS Regimen,  if(cc_periodo_contable.`Nbre` is null, '',cc_periodo_contable.`Nbre`) AS Periodo  , cc_terceros.`No_identificacion`, f_liquidacion.`Copago`, f_liquidacion.`CuotaModeradora`, f_liquidacion.`TotalDescuento`,ifnull(persona.NUsuario, '') NUsuario, ifnull(persona.NoDocumento, '') NoDocumento FROM  `f_factura_evento` INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`) LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`) INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN `f_tiporegimen`  ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)    LEFT JOIN `f_cuentacobro`  ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)  LEFT JOIN `cc_periodo_contable`  ON (`f_cuentacobro`.`Id_PeriodoC`= `cc_periodo_contable`.`Id`)INNER JOIN `cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`) \n  left JOIN  ingreso  ON (ingreso.id = `f_liquidacion`.`Id_Ingreso`)\nleft JOIN  persona  ON (ingreso.Id_Usuario = `persona`.`Id_persona`)\nWHERE (`f_factura_evento`.`Fecha_FacturaEvento` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `f_factura_evento`.`Estado`=0) ORDER BY `NFactura` ASC ";
                }
            } else {
                this.xsql = "SELECT  DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d-%m-%Y') AS fecha , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento`)) AS `NFactura` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , IF((`f_factura_evento`.`ConceptoCobro` IS NULL OR `f_factura_evento`.`ConceptoCobro`=''), `f_subgruposervicio`.`Nbre`,`f_factura_evento`.`ConceptoCobro`) AS `ConceptoC` , IF(`f_liquidacion`.`TotalEps`=0, `f_liquidacion`.`TotalServicio`,`f_liquidacion`.`TotalEps`) AS `TotalFactura` , IF(`f_factura_evento`.`Estado`=0,'ACTIVA', 'ANULADA') AS ESTADO,  `f_liquidacion`.`UsuarioS`, IF(`f_factura_evento`.EstaArmada=0,'PENDIENTE',IF(`f_factura_evento`.EstaArmada=1,'ARMADA', 'PRESENTADA')) EstaArmada    , f_factura_evento.`Motivo_Anulacion`,IF(f_factura_evento.`Fecha_Anulacion` IS NULL, '',f_factura_evento.`Fecha_Anulacion`) AS FAnulacion , f_factura_evento.`Usuario_Anulacion`,IF(f_factura_evento.`Observacion_Anulacion` IS NULL, '',f_factura_evento.`Observacion_Anulacion`) AS ObservacionAnulacion, DATE_FORMAT(ADDDATE(`f_factura_evento`.`Fecha_FacturaEvento`, INTERVAL f_empresacontxconvenio.`NDiasP` DAY),'%d-%m-%Y') AS NFechaV    ,f_liquidacion.`Id_Ingreso`,   f_factura_evento.`No_CuentaCobro`, f_factura_evento.`No_FacturaEvento`, IF(cc_cuentacobro.`Id` IS NULL, 0,cc_cuentacobro.`Id`)  AS Id_CContabilidad , g_ips.`Nbre` AS NEmpresa_G, f_tiporegimen.`Nbre` AS Regimen,  if(cc_periodo_contable.`Nbre` is null, '',cc_periodo_contable.`Nbre`) AS Periodo  , cc_terceros.`No_identificacion`, f_liquidacion.`Copago`, f_liquidacion.`CuotaModeradora`, f_liquidacion.`TotalDescuento`,ifnull(persona.NUsuario, '') NUsuario, ifnull(persona.NoDocumento, '') NoDocumento FROM  `f_factura_evento` INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`) LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`) INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) INNER JOIN `f_tiporegimen`  ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)    LEFT JOIN `f_cuentacobro`  ON (`f_cuentacobro`.`NoCuenta` = `f_factura_evento`.`No_CuentaCobro`)  LEFT JOIN `cc_periodo_contable`  ON (`f_cuentacobro`.`Id_PeriodoC`= `cc_periodo_contable`.`Id`)INNER JOIN `cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`) \n  left JOIN  ingreso  ON (ingreso.id = `f_liquidacion`.`Id_Ingreso`)\nleft JOIN  persona  ON (ingreso.Id_Usuario = `persona`.`Id_persona`)\n having NFactura like '%" + this.JTF_NFactura.getText() + "%' ORDER BY `NFactura` ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(14)), n, 13);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(15)), n, 14);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(16)), n, 15);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(17)), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(xrs.getString("Periodo"), n, 19);
                    this.xmodelo.setValueAt(xrs.getString("No_identificacion"), n, 20);
                    this.xmodelo.setValueAt("", n, 21);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Copago")), n, 22);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("CuotaModeradora")), n, 23);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("TotalDescuento")), n, 24);
                    this.xmodelo.setValueAt(xrs.getString("NUsuario"), n, 25);
                    this.xmodelo.setValueAt(xrs.getString("NoDocumento"), n, 26);
                    n++;
                    xtotal += xrs.getDouble(5);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.JTFF_ValorT.setValue(Double.valueOf(xtotal));
            this.JTFNRegistro.setValue(Integer.valueOf(this.JTDetalle.getRowCount()));
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_4() {
        try {
            mCrearModeloDatos_4();
            this.xsql = "SELECT  `f_empresacontxconvenio`.`Nbre` , COUNT(DISTINCT(`l_recepcion`.`Id`)) , COUNT(`l_detallerecepcion`.`Id_Recepcion`) AS `NExamenes`, (COUNT(`l_detallerecepcion`.`Id_Recepcion`)/COUNT(DISTINCT(`l_recepcion`.`Id`))) as PM FROM `f_empresacontxconvenio` INNER JOIN  `l_recepcion`   ON (`f_empresacontxconvenio`.`Id` = `l_recepcion`.`Id_EmpresaConv`) INNER JOIN `baseserver`.`l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)INNER JOIN   `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) INNER JOIN   `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = ingreso.`Id`) WHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `l_recepcion`.`Estado` =0 AND ingreso.`NMuestra` " + this.filtro + ") GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_5() {
        try {
            mCrearModeloDatos_5();
            this.xsql = "SELECT `f_empresacontxconvenio`.`Nbre` , `g_municipio`.`Nbre` AS `NMunicipio`,  COUNT(DISTINCT(`l_recepcion`.`Id`)) AS `NRecepciones` , COUNT(`l_detallerecepcion`.`Id_Recepcion`) AS `NExamenes` , (COUNT(`l_detallerecepcion`.`Id_Recepcion`)/COUNT(DISTINCT(`l_recepcion`.`Id`))) AS `Promedio` FROM `f_empresacontxconvenio` INNER JOIN `l_recepcion`   ON (`f_empresacontxconvenio`.`Id` = `l_recepcion`.`Id_EmpresaConv`) INNER JOIN `l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`) INNER JOIN `g_municipio`  ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)INNER JOIN   `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) INNER JOIN   `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = ingreso.`Id`)  WHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `l_recepcion`.`Estado` =0 AND ingreso.`NMuestra` " + this.filtro + " )GROUP BY `f_empresacontxconvenio`.`Id`, `g_municipio`.`Id`  ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, `NMunicipio` ASC";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_6() {
        try {
            mCrearModeloDatos_6();
            this.xsql = "SELECT `f_empresacontxconvenio`.`Nbre` , `g_municipio`.`Nbre` AS `NMunicipio` , `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre` , COUNT(`g_procedimiento`.`Id`) AS `Cantidad` FROM `f_empresacontxconvenio`  INNER JOIN `l_recepcion`  ON (`f_empresacontxconvenio`.`Id` = `l_recepcion`.`Id_EmpresaConv`)INNER JOIN `l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`)  INNER JOIN `g_municipio`   ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)INNER JOIN   `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)INNER JOIN   `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = ingreso.`Id`)  WHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `l_recepcion`.`Estado` =0  AND ingreso.`NMuestra` " + this.filtro + ") GROUP BY `f_empresacontxconvenio`.`Id`, `g_municipio`.`Id`, `g_procedimiento`.`Id`  ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, `NMunicipio` ASC, `g_procedimiento`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_7() {
        try {
            mCrearModeloDatos_7();
            this.xsql = "SELECT  `g_municipio`.`Nbre` , SUM(((`f_itemordenesproced`.`Cantidad`* `f_itemordenesproced`.`ValorUnitario`)+f_itemordenesproced.valorImpuesto)) AS `Valor` FROM `l_detallerecepcion` INNER JOIN   `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN   `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) INNER JOIN   `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN   `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)INNER JOIN   `g_persona`  ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`) INNER JOIN   `g_municipio`  ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)INNER JOIN   `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = ingreso.`Id`)WHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `l_recepcion`.`Estado` =0 AND `f_ordenes`.`Estado` =0  AND ingreso.`NMuestra` " + this.filtro + ") GROUP BY `g_municipio`.`Id` ORDER BY `g_municipio`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_8() {
        try {
            mCrearModeloDatos_8();
            this.xsql = "SELECT `ingreso`.`FechaIngreso` , CONCAT(`persona`.`Id_TipoIdentificacion`,' ',`persona`.`NoDocumento`) AS Documento , `persona`.`NUsuario`, `g_procedimiento`.`Id` AS CUP , `g_procedimiento`.`Nbre` , `f_itemordenesproced`.`Cantidad` , `f_itemordenesproced`.`ValorUnitario` , `persona`.`NMunicipio`, IF(`g_procedimiento`.`EsRemitido`=0, 'NO', 'SI') AS remitido FROM `f_ordenes` INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`)WHERE (`f_ordenes`.`Estado` =0 AND `ingreso`.`Id_EmpresaContxConv` ='" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "' AND  `ingreso`.`FechaIngreso`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'  AND  `ingreso`.`FechaIngreso`<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'  AND ingreso.`NMuestra` " + this.filtro + ")ORDER BY `ingreso`.`FechaIngreso` ASC, `persona`.`NUsuario` ASC, `g_procedimiento`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_HP() {
        try {
            mCrearModeloDatos_HP();
            if (this.JCH_Filtro.isSelected()) {
                if (this.JCH_Anulada.isSelected()) {
                    this.xsql = "SELECT\n `ingreso`.`FechaIngreso`,\n  ingreso.HoraIngreso ,\n  g_tipoatencion.`Nbre` AS servicioIngreso ,\n   ifnull(hea.FechaSO ,'') AS `FEgresoH`,\n   ifnull(hea.HoraSO,'')   horaEgreso,\n   ifnull(gt.Nbre,'')  servicioEgreso,\n  CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-',`g_persona`.`NoDocumento`) AS `Documento`,\n  CONCAT(`g_persona`.`Apellido1`,'  ',`g_persona`.`Apellido2`,'  ',`g_persona`.`Nombre1`,'  ',`g_persona`.`Nombre2`) AS `NUsuario`,\n  `g_persona`.`Id_Sexo`,\n  CONCAT(`g_persona`.`Edad`,' ',`g_tipoedad`.`Nbre`,'(S)') AS `Edad`,\n  `h_atencion`.`Codigo_Dxp`,\n  `profesional1`.`Especialidad`,\n  `profesional1`.`NProfesional`,\n  `f_empresacontxconvenio`.`Nbre`,\n  `ingreso`.`NoAutorizacion`,\n  `ingreso`.`Id`,\n  `ingreso`.`Id_Usuario`,\n    ifnull(fc.Nbre, '') cama, fu.Nbre  unidadCama,  TIMESTAMPDIFF(DAY , `ingreso`.`FechaIngreso`,  ifnull(hea.FechaSO ,CURDATE())) AS dias\n    , ifnull(`profesional2`.`Especialidad`,'') especialidadEgreso,\n  ifnull(`profesional2`.`NProfesional`,'') profesionalEgreso\n  ,ifnull(concat(gp.Id, '_', gp.Nbre), '') diagnosticoEgreso\nFROM\n  `h_atencion`\n  INNER JOIN `ingreso`\n    ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `profesional1`\n    ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `g_tipoedad`\n    ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n  INNER JOIN `g_tipoatencion`\n    ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\n left join h_egreso_atencion hea  on (hea.Id_Atencion=h_atencion.Id) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) \n left  JOIN `profesional1` profesional2\n    ON (`profesional2`.`IdEspecialidad` = hea.Id_Especialidad ) AND (`profesional2`.`Id_Persona` = hea.Id_Profesional )\n left join g_patologia gp on (gp.Id =hea.DxP )   \n  left join f_camas fc on (fc.Id=ingreso.Cama)  LEFT JOIN f_unidadcama fu ON (fc.Id_UnidadCamas=fu.Id)\n  left join g_tipoatencion gt on (gt.Id=hea.Id_Tipo)\nWHERE (\n    `h_atencion`.`Codigo_Dxp` <> ''\n    AND `g_tipoatencion`.`Id` = '" + this.xidServicio[this.JCBTercero.getSelectedIndex()] + "'\n    AND `g_tipoatencion`.`Id_TipoAmbito` = 2\n    AND `ingreso`.`Estado` = 0\n  )\nHAVING FEgresoH='' ORDER BY `ingreso`.`FechaIngreso` ASC,\n  `NUsuario` ASC";
                } else {
                    this.xsql = "SELECT\n `ingreso`.`FechaIngreso`,\n  ingreso.HoraIngreso ,\n  g_tipoatencion.`Nbre` AS servicioIngreso ,\n   ifnull(hea.FechaSO ,'') AS `FEgresoH`,\n   ifnull(hea.HoraSO,'')   horaEgreso,\n   ifnull(gt.Nbre,'')  servicioEgreso,\n  CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-',`g_persona`.`NoDocumento`) AS `Documento`,\n  CONCAT(`g_persona`.`Apellido1`,'  ',`g_persona`.`Apellido2`,'  ',`g_persona`.`Nombre1`,'  ',`g_persona`.`Nombre2`) AS `NUsuario`,\n  `g_persona`.`Id_Sexo`,\n  CONCAT(`g_persona`.`Edad`,' ',`g_tipoedad`.`Nbre`,'(S)') AS `Edad`,\n  `h_atencion`.`Codigo_Dxp`,\n  `profesional1`.`Especialidad`,\n  `profesional1`.`NProfesional`,\n  `f_empresacontxconvenio`.`Nbre`,\n  `ingreso`.`NoAutorizacion`,\n  `ingreso`.`Id`,\n  `ingreso`.`Id_Usuario`,\n    ifnull(fc.Nbre, '') cama, fu.Nbre  unidadCama,  TIMESTAMPDIFF(DAY , `ingreso`.`FechaIngreso`,  ifnull(hea.FechaSO ,CURDATE())) AS dias\n    , ifnull(`profesional2`.`Especialidad`,'') especialidadEgreso,\n  ifnull(`profesional2`.`NProfesional`,'') profesionalEgreso\n  ,ifnull(concat(gp.Id, '_', gp.Nbre), '') diagnosticoEgreso\nFROM\n  `h_atencion`\n  INNER JOIN `ingreso`\n    ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `profesional1`\n    ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `g_tipoedad`\n    ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n  INNER JOIN `g_tipoatencion`\n    ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\n left join h_egreso_atencion hea  on (hea.Id_Atencion=h_atencion.Id) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) \n left  JOIN `profesional1` profesional2\n    ON (`profesional2`.`IdEspecialidad` = hea.Id_Especialidad ) AND (`profesional2`.`Id_Persona` = hea.Id_Profesional )\n left join g_patologia gp on (gp.Id =hea.DxP )   \n  left join f_camas fc on (fc.Id=ingreso.Cama)  LEFT JOIN f_unidadcama fu ON (fc.Id_UnidadCamas=fu.Id)\n  left join g_tipoatencion gt on (gt.Id=hea.Id_Tipo)\nWHERE (\n    `h_atencion`.`Codigo_Dxp` <> ''\n    AND `g_tipoatencion`.`Id` = '" + this.xidServicio[this.JCBTercero.getSelectedIndex()] + "'\n    AND `g_tipoatencion`.`Id_TipoAmbito` = 2\n    AND `ingreso`.`FechaIngreso` >= '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `ingreso`.`FechaIngreso` <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `ingreso`.`Estado` = 0\n  )\nORDER BY `ingreso`.`FechaIngreso` ASC,\n  `NUsuario` ASC";
                }
            } else if (this.JCH_Filtro.isSelected()) {
                this.xsql = "SELECT\n `ingreso`.`FechaIngreso`,\n  ingreso.HoraIngreso ,\n  g_tipoatencion.`Nbre` AS servicioIngreso ,\n   ifnull(hea.FechaSO ,'') AS `FEgresoH`,\n   ifnull(hea.HoraSO,'')   horaEgreso,\n   ifnull(gt.Nbre,'')  servicioEgreso,\n  CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-',`g_persona`.`NoDocumento`) AS `Documento`,\n  CONCAT(`g_persona`.`Apellido1`,'  ',`g_persona`.`Apellido2`,'  ',`g_persona`.`Nombre1`,'  ',`g_persona`.`Nombre2`) AS `NUsuario`,\n  `g_persona`.`Id_Sexo`,\n  CONCAT(`g_persona`.`Edad`,' ',`g_tipoedad`.`Nbre`,'(S)') AS `Edad`,\n  `h_atencion`.`Codigo_Dxp`,\n  `profesional1`.`Especialidad`,\n  `profesional1`.`NProfesional`,\n  `f_empresacontxconvenio`.`Nbre`,\n  `ingreso`.`NoAutorizacion`,\n  `ingreso`.`Id`,\n  `ingreso`.`Id_Usuario`,\n    ifnull(fc.Nbre, '') cama, fu.Nbre  unidadCama,  TIMESTAMPDIFF(DAY , `ingreso`.`FechaIngreso`,  ifnull(hea.FechaSO ,CURDATE())) AS dias\n    , ifnull(`profesional2`.`Especialidad`,'') especialidadEgreso,\n  ifnull(`profesional2`.`NProfesional`,'') profesionalEgreso\n  ,ifnull(concat(gp.Id, '_', gp.Nbre), '') diagnosticoEgreso\nFROM\n  `h_atencion`\n  INNER JOIN `ingreso`\n    ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `profesional1`\n    ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `g_tipoedad`\n    ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n  INNER JOIN `g_tipoatencion`\n    ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\n left join h_egreso_atencion hea  on (hea.Id_Atencion=h_atencion.Id) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) \n left  JOIN `profesional1` profesional2\n    ON (`profesional2`.`IdEspecialidad` = hea.Id_Especialidad ) AND (`profesional2`.`Id_Persona` = hea.Id_Profesional )\n left join g_patologia gp on (gp.Id =hea.DxP )   \n  left join f_camas fc on (fc.Id=ingreso.Cama)  LEFT JOIN f_unidadcama fu ON (fc.Id_UnidadCamas=fu.Id)\n  left join g_tipoatencion gt on (gt.Id=hea.Id_Tipo)\nWHERE (\n    `h_atencion`.`Codigo_Dxp` <> ''\n    AND `g_tipoatencion`.`Id_TipoAmbito` = 2\n    AND `ingreso`.`Estado` = 0\n  )\nHAVING FEgresoH='' ORDER BY `ingreso`.`FechaIngreso` ASC,\n  `NUsuario` ASC";
            } else {
                this.xsql = "SELECT\n `ingreso`.`FechaIngreso`,\n  ingreso.HoraIngreso ,\n  g_tipoatencion.`Nbre` AS servicioIngreso ,\n   ifnull(hea.FechaSO ,'') AS `FEgresoH`,\n   ifnull(hea.HoraSO,'')   horaEgreso,\n   ifnull(gt.Nbre,'')  servicioEgreso,\n  CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-',`g_persona`.`NoDocumento`) AS `Documento`,\n  CONCAT(`g_persona`.`Apellido1`,'  ',`g_persona`.`Apellido2`,'  ',`g_persona`.`Nombre1`,'  ',`g_persona`.`Nombre2`) AS `NUsuario`,\n  `g_persona`.`Id_Sexo`,\n  CONCAT(`g_persona`.`Edad`,' ',`g_tipoedad`.`Nbre`,'(S)') AS `Edad`,\n  `h_atencion`.`Codigo_Dxp`,\n  `profesional1`.`Especialidad`,\n  `profesional1`.`NProfesional`,\n  `f_empresacontxconvenio`.`Nbre`,\n  `ingreso`.`NoAutorizacion`,\n  `ingreso`.`Id`,\n  `ingreso`.`Id_Usuario`,\n    ifnull(fc.Nbre, '') cama, fu.Nbre  unidadCama,  TIMESTAMPDIFF(DAY , `ingreso`.`FechaIngreso`,  ifnull(hea.FechaSO ,CURDATE())) AS dias\n    , ifnull(`profesional2`.`Especialidad`,'') especialidadEgreso,\n  ifnull(`profesional2`.`NProfesional`,'') profesionalEgreso\n  ,ifnull(concat(gp.Id, '_', gp.Nbre), '') diagnosticoEgreso\nFROM\n  `h_atencion`\n  INNER JOIN `ingreso`\n    ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `profesional1`\n    ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `g_tipoedad`\n    ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n  INNER JOIN `g_tipoatencion`\n    ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\n left join h_egreso_atencion hea  on (hea.Id_Atencion=h_atencion.Id) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) \n left  JOIN `profesional1` profesional2\n    ON (`profesional2`.`IdEspecialidad` = hea.Id_Especialidad ) AND (`profesional2`.`Id_Persona` = hea.Id_Profesional )\n left join g_patologia gp on (gp.Id =hea.DxP )   \n  left join f_camas fc on (fc.Id=ingreso.Cama)  LEFT JOIN f_unidadcama fu ON (fc.Id_UnidadCamas=fu.Id)\n  left join g_tipoatencion gt on (gt.Id=hea.Id_Tipo)\nWHERE (\n    `h_atencion`.`Codigo_Dxp` <> ''\n    AND `g_tipoatencion`.`Id_TipoAmbito` = 2\n    AND `ingreso`.`FechaIngreso` >= '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `ingreso`.`FechaIngreso` <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `ingreso`.`Estado` = 0\n  )\nORDER BY `ingreso`.`FechaIngreso` ASC,\n  `NUsuario` ASC";
            }
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n = 0;
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdatos);
                        this.xmodelo.setValueAt(xrs.getDate("FechaIngreso"), n, 0);
                        this.xmodelo.setValueAt(xrs.getString("HoraIngreso"), n, 1);
                        this.xmodelo.setValueAt(xrs.getString("servicioIngreso"), n, 2);
                        this.xmodelo.setValueAt(xrs.getString("FEgresoH"), n, 3);
                        this.xmodelo.setValueAt(xrs.getString("horaEgreso"), n, 4);
                        this.xmodelo.setValueAt(xrs.getString("servicioEgreso"), n, 5);
                        this.xmodelo.setValueAt(xrs.getString("Documento"), n, 6);
                        this.xmodelo.setValueAt(xrs.getString("NUsuario"), n, 7);
                        this.xmodelo.setValueAt(xrs.getString("Id_Sexo"), n, 8);
                        this.xmodelo.setValueAt(xrs.getString("Edad"), n, 9);
                        this.xmodelo.setValueAt(xrs.getString("Codigo_Dxp"), n, 10);
                        this.xmodelo.setValueAt(xrs.getString("Especialidad"), n, 11);
                        this.xmodelo.setValueAt(xrs.getString("NProfesional"), n, 12);
                        this.xmodelo.setValueAt(xrs.getString("Nbre"), n, 13);
                        this.xmodelo.setValueAt(xrs.getString("NoAutorizacion"), n, 14);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id")), n, 15);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id_Usuario")), n, 16);
                        this.xmodelo.setValueAt(xrs.getString("cama"), n, 17);
                        this.xmodelo.setValueAt(xrs.getString("unidadCama"), n, 18);
                        this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("dias")), n, 19);
                        this.xmodelo.setValueAt(xrs.getString("especialidadEgreso"), n, 20);
                        this.xmodelo.setValueAt(xrs.getString("profesionalEgreso"), n, 21);
                        this.xmodelo.setValueAt(xrs.getString("diagnosticoEgreso"), n, 22);
                        n++;
                    }
                }
                this.JTFNRegistro.setText("" + this.xmodelo.getRowCount());
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_HP_1() {
        try {
            mCrearModeloDatos_HP1();
            if (this.JCH_Filtro.isSelected()) {
                if (this.JCH_Anulada.isSelected()) {
                    this.xsql = "SELECT\n  `f_empresacontxconvenio`.`Id`,\n  `f_empresacontxconvenio`.`Nbre` AS `Nempresa`,\n  COUNT(`h_atencion`.`Id`) AS `Cantidad`,ifnull(hea.FechaSO ,'') AS `FEgresoH`\nFROM\n  `h_atencion`\n  INNER JOIN `ingreso`\n    ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `profesional1`\n    ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `g_tipoedad`\n    ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n  INNER JOIN `g_tipoatencion`\n    ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\n  left join h_egreso_atencion hea  on (hea.Id_Atencion=h_atencion.Id) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) \n  WHERE (\n    `h_atencion`.`Codigo_Dxp` <> ''\n    AND `g_tipoatencion`.`Id_TipoAmbito` = 2\n    AND `g_tipoatencion`.`Id` = '" + this.xidServicio[this.JCBTercero.getSelectedIndex()] + "'\n  and ifnull(hea.FechaSO ,'') =''  AND `ingreso`.`Estado` = 0\n  )\nGROUP BY `f_empresacontxconvenio`.`Id`\n ORDER BY `Nempresa` ASC";
                } else {
                    this.xsql = "SELECT\n  `f_empresacontxconvenio`.`Id`,\n  `f_empresacontxconvenio`.`Nbre` AS `Nempresa`,\n  COUNT(`h_atencion`.`Id`) AS `Cantidad`\nFROM\n  `h_atencion`\n  INNER JOIN `ingreso`\n    ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `profesional1`\n    ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `g_tipoedad`\n    ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n  INNER JOIN `g_tipoatencion`\n    ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\nWHERE (\n    `h_atencion`.`Codigo_Dxp` <> ''\n    AND `g_tipoatencion`.`Id_TipoAmbito` = 2\n    AND `g_tipoatencion`.`Id` = '" + this.xidServicio[this.JCBTercero.getSelectedIndex()] + "'\n    AND `ingreso`.`FechaIngreso` >= '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `ingreso`.`FechaIngreso` <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `ingreso`.`Estado` = 0\n  )\nGROUP BY `f_empresacontxconvenio`.`Id`\nORDER BY `Nempresa` ASC";
                }
            } else if (this.JCH_Anulada.isSelected()) {
                this.xsql = "SELECT\n  `f_empresacontxconvenio`.`Id`,\n  `f_empresacontxconvenio`.`Nbre` AS `Nempresa`,\n  COUNT(`h_atencion`.`Id`) AS `Cantidad`, ifnull(hea.FechaSO ,'') AS `FEgresoH`\nFROM\n  `h_atencion`\n  INNER JOIN `ingreso`\n    ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `profesional1`\n    ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `g_tipoedad`\n    ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n  INNER JOIN `g_tipoatencion`\n    ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\n   left join h_egreso_atencion hea  on (hea.Id_Atencion=h_atencion.Id) and (hea.Id_Tipo=ingreso.Id_TipoAtencion) \n  WHERE (\n    `h_atencion`.`Codigo_Dxp` <> ''\n    AND `g_tipoatencion`.`Id_TipoAmbito` = 2\n  and ifnull(hea.FechaSO ,'') =''  AND `ingreso`.`Estado` = 0\n  )\nGROUP BY `f_empresacontxconvenio`.`Id`\n ORDER BY `Nempresa` ASC";
            } else {
                this.xsql = "SELECT\n  `f_empresacontxconvenio`.`Id`,\n  `f_empresacontxconvenio`.`Nbre` AS `Nempresa`,\n  COUNT(`h_atencion`.`Id`) AS `Cantidad`\nFROM\n  `h_atencion`\n  INNER JOIN `ingreso`\n    ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `profesional1`\n    ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n  INNER JOIN `f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `g_tipoedad`\n    ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n  INNER JOIN `g_tipoatencion`\n    ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\nWHERE (\n    `h_atencion`.`Codigo_Dxp` <> ''\n    AND `g_tipoatencion`.`Id_TipoAmbito` = 2\n    AND `ingreso`.`FechaIngreso` >= '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'\n    AND `ingreso`.`FechaIngreso` <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND `ingreso`.`Estado` = 0\n  )\nGROUP BY `f_empresacontxconvenio`.`Id`\nORDER BY `Nempresa` ASC";
            }
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_Interfaz(int xforma) {
        try {
            mCrearModeloDatos_Interfaz();
            if (xforma == 0) {
                this.xsql = "SELECT  'FV' , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`)) AS `NFactura` ,DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d/%m/%Y') AS fecha , IF((`f_factura_evento`.`ConceptoCobro` IS NULL OR `f_factura_evento`.`ConceptoCobro`=''), `f_subgruposervicio`.`Nbre`,`f_factura_evento`.`ConceptoCobro`) AS `ConceptoC`, IF(`f_factura_evento`.`Estado`=0,IF(`f_liquidacion`.`TotalEps`=0, `f_liquidacion`.`TotalServicio`,`f_liquidacion`.`TotalEps`),0) AS `TotalFactura`, IF(`f_factura_evento`.`Estado`=0,(`f_liquidacion`.`Copago`+ `f_liquidacion`.`CuotaModeradora`),0) AS PagoCompartido, IF(`f_factura_evento`.`Estado`=0,`f_liquidacion`.`TotalServicio`,0)  AS Subtotal  ,  IF(`f_factura_evento`.`Estado`=0,ROUND((`f_liquidacion`.`TotalServicio`*0.008),0),0)  AS ARCree, cc_terceros.`No_identificacion`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`   , IF(`f_factura_evento`.`Estado`=0,'ACTIVA', 'ANULADA') AS ESTADO, g_ips.`Nbre` AS NEmpresa_G,f_liquidacion.`Id_Ingreso`,   f_factura_evento.`No_CuentaCobro`, f_factura_evento.`No_FacturaEvento`, IF(cc_cuentacobro.`Id` IS NULL, 0,cc_cuentacobro.`Id`)  AS Id_CContabilidad, `f_factura_evento`.EstaArmada    , f_factura_evento.`Motivo_Anulacion`,IF(f_factura_evento.`Fecha_Anulacion` IS NULL, '',f_factura_evento.`Fecha_Anulacion`) AS FAnulacion , f_factura_evento.`Usuario_Anulacion`,IF(f_factura_evento.`Observacion_Anulacion` IS NULL, '',f_factura_evento.`Observacion_Anulacion`) AS ObservacionAnulacion, f_subgrupo_empresa.`CPuc_Debito`, f_subgrupo_empresa.`CPuc_Credito`  FROM  `f_factura_evento`  INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)  INNER JOIN `cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`)  INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`) WHERE (IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`)) <>0  and f_empresacontxconvenio.Id_GIps='" + Principal.informacionIps.getId() + "' and `f_factura_evento`.`Fecha_FacturaEvento` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "')  ORDER BY   g_ips.`Nbre`  ASC, `NFactura` ASC ";
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                this.xsql = "SELECT  'FV' , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`)) AS `NFactura` ,DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d/%m/%Y') AS fecha , IF((`f_factura_evento`.`ConceptoCobro` IS NULL OR `f_factura_evento`.`ConceptoCobro`=''), `f_subgruposervicio`.`Nbre`,`f_factura_evento`.`ConceptoCobro`) AS `ConceptoC`, IF(`f_factura_evento`.`Estado`=0,IF(`f_liquidacion`.`TotalEps`=0, `f_liquidacion`.`TotalServicio`,`f_liquidacion`.`TotalEps`),0) AS `TotalFactura`, IF(`f_factura_evento`.`Estado`=0,(`f_liquidacion`.`Copago`+ `f_liquidacion`.`CuotaModeradora`),0) AS PagoCompartido, IF(`f_factura_evento`.`Estado`=0,`f_liquidacion`.`TotalServicio`,0)  AS Subtotal  ,  IF(`f_factura_evento`.`Estado`=0,ROUND((`f_liquidacion`.`TotalServicio`*0.008),0),0)  AS ARCree, cc_terceros.`No_identificacion`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`   , IF(`f_factura_evento`.`Estado`=0,'ACTIVA', 'ANULADA') AS ESTADO, g_ips.`Nbre` AS NEmpresa_G,f_liquidacion.`Id_Ingreso`,   f_factura_evento.`No_CuentaCobro`, f_factura_evento.`No_FacturaEvento`, IF(cc_cuentacobro.`Id` IS NULL, 0,cc_cuentacobro.`Id`)  AS Id_CContabilidad, `f_factura_evento`.EstaArmada    , f_factura_evento.`Motivo_Anulacion`,IF(f_factura_evento.`Fecha_Anulacion` IS NULL, '',f_factura_evento.`Fecha_Anulacion`) AS FAnulacion , f_factura_evento.`Usuario_Anulacion`,IF(f_factura_evento.`Observacion_Anulacion` IS NULL, '',f_factura_evento.`Observacion_Anulacion`) AS ObservacionAnulacion, f_subgrupo_empresa.`CPuc_Debito`, f_subgrupo_empresa.`CPuc_Credito`  FROM  `f_factura_evento`  INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)  INNER JOIN `cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`)  INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`) WHERE (IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`)) <>0  and f_empresacontxconvenio.Id_GIps='" + Principal.informacionIps.getId() + "' and  IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento_M`))Like'" + this.JTF_NFactura.getText() + "%')  ORDER BY   g_ips.`Nbre`  ASC, `NFactura` ASC ";
            } else {
                this.xsql = "SELECT  'FV' , IF(`f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`,CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento`)) AS `NFactura` ,DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d/%m/%Y') AS fecha , IF((`f_factura_evento`.`ConceptoCobro` IS NULL OR `f_factura_evento`.`ConceptoCobro`=''), `f_subgruposervicio`.`Nbre`,`f_factura_evento`.`ConceptoCobro`) AS `ConceptoC`, IF(`f_factura_evento`.`Estado`=0,IF(`f_liquidacion`.`TotalEps`=0, `f_liquidacion`.`TotalServicio`,`f_liquidacion`.`TotalEps`),0) AS `TotalFactura`, IF(`f_factura_evento`.`Estado`=0,(`f_liquidacion`.`Copago`+ `f_liquidacion`.`CuotaModeradora`),0) AS PagoCompartido, IF(`f_factura_evento`.`Estado`=0,`f_liquidacion`.`TotalServicio`,0)  AS Subtotal  ,  IF(`f_factura_evento`.`Estado`=0,ROUND((`f_liquidacion`.`TotalServicio`*0.008),0),0)  AS ARCree, cc_terceros.`No_identificacion`, `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`   , IF(`f_factura_evento`.`Estado`=0,'ACTIVA', 'ANULADA') AS ESTADO, g_ips.`Nbre` AS NEmpresa_G,f_liquidacion.`Id_Ingreso`,   f_factura_evento.`No_CuentaCobro`, f_factura_evento.`No_FacturaEvento`, IF(cc_cuentacobro.`Id` IS NULL, 0,cc_cuentacobro.`Id`)  AS Id_CContabilidad, `f_factura_evento`.EstaArmada    , f_factura_evento.`Motivo_Anulacion`,IF(f_factura_evento.`Fecha_Anulacion` IS NULL, '',f_factura_evento.`Fecha_Anulacion`) AS FAnulacion , f_factura_evento.`Usuario_Anulacion`,IF(f_factura_evento.`Observacion_Anulacion` IS NULL, '',f_factura_evento.`Observacion_Anulacion`) AS ObservacionAnulacion, f_subgrupo_empresa.`CPuc_Debito`, f_subgrupo_empresa.`CPuc_Credito`  FROM  `f_factura_evento`  INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  INNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`)  INNER JOIN `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`)  INNER JOIN `f_empresacontxconvenio`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`)  INNER JOIN `cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`)  INNER JOIN `g_ips`  ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`) LEFT JOIN `cc_cuentacobro`  ON (`cc_cuentacobro`.`NFactura_Evento` = `f_factura_evento`.`No_FacturaEvento`)  INNER JOIN `rh_tipo_persona_cargon`ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `rh_tipo_cargo` ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) INNER JOIN `g_persona` AS `g_persona_u`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona_u`.`Id`)  HAVING NFactura LIKE '%" + this.JTF_NFactura.getText() + "%'  ORDER BY   g_ips.`Nbre`  ASC, `NFactura` ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                        for (int x = 0; x < 5; x++) {
                            if (x == 0) {
                                this.xmodelo1.addRow(this.xdatos);
                                this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                                this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                                this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                                this.xmodelo1.setValueAt(xrs.getString("CPuc_Debito"), n, 3);
                                this.xmodelo1.setValueAt(xrs.getString(4), n, 4);
                                this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 5);
                                this.xmodelo1.setValueAt("D", n, 6);
                                this.xmodelo1.setValueAt(xrs.getString(9), n, 7);
                                this.xmodelo1.setValueAt(xrs.getString(10), n, 8);
                                this.xmodelo1.setValueAt(xrs.getString(11), n, 9);
                                this.xmodelo1.setValueAt(xrs.getString(12), n, 10);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(13)), n, 11);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(14)), n, 12);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(15)), n, 13);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(16)), n, 14);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(17)), n, 15);
                                this.xmodelo1.setValueAt(xrs.getString(18), n, 16);
                                this.xmodelo1.setValueAt(xrs.getString(19), n, 17);
                                this.xmodelo1.setValueAt(xrs.getString(20), n, 18);
                                this.xmodelo1.setValueAt(xrs.getString(21), n, 19);
                                this.xmodelo1.setValueAt(xrs.getString(5), n, 20);
                                this.JTDetalle1.setDefaultRenderer(Object.class, new MiRender());
                                n++;
                            } else if (x == 1) {
                                if (xrs.getDouble(6) != 0.0d && xrs.getString(11).equals("ACTIVA")) {
                                    this.xmodelo1.addRow(this.xdatos);
                                    this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                                    if (xrs.getString("NEmpresa_G").equals("CLINICA OFTALMOLOGICA DAJUD SAS")) {
                                        this.xmodelo1.setValueAt("280505", n, 3);
                                    } else {
                                        this.xmodelo1.setValueAt("28050501", n, 3);
                                    }
                                    this.xmodelo1.setValueAt(xrs.getString(4), n, 4);
                                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                                    this.xmodelo1.setValueAt("D", n, 6);
                                    this.xmodelo1.setValueAt(xrs.getString(9), n, 7);
                                    this.xmodelo1.setValueAt(xrs.getString(10), n, 8);
                                    this.xmodelo1.setValueAt(xrs.getString(11), n, 9);
                                    this.xmodelo1.setValueAt(xrs.getString(12), n, 10);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(13)), n, 11);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(14)), n, 12);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(15)), n, 13);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(16)), n, 14);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(17)), n, 15);
                                    this.xmodelo1.setValueAt(xrs.getString(18), n, 16);
                                    this.xmodelo1.setValueAt(xrs.getString(19), n, 17);
                                    this.xmodelo1.setValueAt(xrs.getString(20), n, 18);
                                    this.xmodelo1.setValueAt(xrs.getString(21), n, 19);
                                    this.xmodelo1.setValueAt(xrs.getString(5), n, 20);
                                    this.JTDetalle1.setDefaultRenderer(Object.class, new MiRender());
                                    n++;
                                }
                            } else if (x == 2) {
                                this.xmodelo1.addRow(this.xdatos);
                                this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                                this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                                this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                                this.xmodelo1.setValueAt(xrs.getString("CPuc_Credito"), n, 3);
                                this.xmodelo1.setValueAt(xrs.getString(4), n, 4);
                                this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 5);
                                this.xmodelo1.setValueAt("C", n, 6);
                                this.xmodelo1.setValueAt(xrs.getString(9), n, 7);
                                this.xmodelo1.setValueAt(xrs.getString(10), n, 8);
                                this.xmodelo1.setValueAt(xrs.getString(11), n, 9);
                                this.xmodelo1.setValueAt(xrs.getString(12), n, 10);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(13)), n, 11);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(14)), n, 12);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(15)), n, 13);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(16)), n, 14);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(17)), n, 15);
                                this.xmodelo1.setValueAt(xrs.getString(18), n, 16);
                                this.xmodelo1.setValueAt(xrs.getString(19), n, 17);
                                this.xmodelo1.setValueAt(xrs.getString(20), n, 18);
                                this.xmodelo1.setValueAt(xrs.getString(21), n, 19);
                                this.xmodelo1.setValueAt(xrs.getString(5), n, 20);
                                this.JTDetalle1.setDefaultRenderer(Object.class, new MiRender());
                                n++;
                            } else if (x == 3) {
                                if (xrs.getString("NEmpresa_G").equals("CLINICA OFTALMOLOGICA DAJUD SAS") && xrs.getDouble(8) != 0.0d && xrs.getString(11).equals("ACTIVA")) {
                                    this.xmodelo1.addRow(this.xdatos);
                                    this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                                    this.xmodelo1.setValueAt("13552520", n, 3);
                                    this.xmodelo1.setValueAt("Autocree 0.80%", n, 4);
                                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 5);
                                    this.xmodelo1.setValueAt("D", n, 6);
                                    this.xmodelo1.setValueAt(xrs.getString(9), n, 7);
                                    this.xmodelo1.setValueAt(xrs.getString(10), n, 8);
                                    this.xmodelo1.setValueAt(xrs.getString(11), n, 9);
                                    this.xmodelo1.setValueAt(xrs.getString(12), n, 10);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(13)), n, 11);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(14)), n, 12);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(15)), n, 13);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(16)), n, 14);
                                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(17)), n, 15);
                                    this.xmodelo1.setValueAt(xrs.getString(18), n, 16);
                                    this.xmodelo1.setValueAt(xrs.getString(19), n, 17);
                                    this.xmodelo1.setValueAt(xrs.getString(20), n, 18);
                                    this.xmodelo1.setValueAt(xrs.getString(21), n, 19);
                                    this.xmodelo1.setValueAt(xrs.getString(5), n, 20);
                                    this.JTDetalle1.setDefaultRenderer(Object.class, new MiRender());
                                    n++;
                                }
                            } else if (x == 4 && xrs.getString("NEmpresa_G").equals("CLINICA OFTALMOLOGICA DAJUD SAS") && xrs.getDouble(8) != 0.0d && xrs.getString(11).equals("ACTIVA")) {
                                this.xmodelo1.addRow(this.xdatos);
                                this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                                this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                                this.xmodelo1.setValueAt("23657503", n, 3);
                                this.xmodelo1.setValueAt("Autocree 0.80%", n, 4);
                                this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 5);
                                this.xmodelo1.setValueAt("C", n, 6);
                                this.xmodelo1.setValueAt(xrs.getString(9), n, 7);
                                this.xmodelo1.setValueAt(xrs.getString(10), n, 8);
                                this.xmodelo1.setValueAt(xrs.getString(11), n, 9);
                                this.xmodelo1.setValueAt(xrs.getString(12), n, 10);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(13)), n, 11);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(14)), n, 12);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(15)), n, 13);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(16)), n, 14);
                                this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(17)), n, 15);
                                this.xmodelo1.setValueAt(xrs.getString(18), n, 16);
                                this.xmodelo1.setValueAt(xrs.getString(19), n, 17);
                                this.xmodelo1.setValueAt(xrs.getString(20), n, 18);
                                this.xmodelo1.setValueAt(xrs.getString(21), n, 19);
                                this.xmodelo1.setValueAt(xrs.getString(5), n, 20);
                                this.JTDetalle1.setDefaultRenderer(Object.class, new MiRender());
                                n++;
                            }
                        }
                    } else {
                        this.xmodelo1.addRow(this.xdatos);
                        this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                        this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                        this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                        this.xmodelo1.setValueAt(xrs.getString("CPuc_Debito"), n, 3);
                        this.xmodelo1.setValueAt(xrs.getString(4), n, 4);
                        this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 5);
                        this.xmodelo1.setValueAt("D", n, 6);
                        this.xmodelo1.setValueAt(xrs.getString(9), n, 7);
                        this.xmodelo1.setValueAt(xrs.getString(10), n, 8);
                        this.xmodelo1.setValueAt(xrs.getString(11), n, 9);
                        this.xmodelo1.setValueAt(xrs.getString(12), n, 10);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(13)), n, 11);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(14)), n, 12);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(15)), n, 13);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(16)), n, 14);
                        this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(17)), n, 15);
                        this.xmodelo1.setValueAt(xrs.getString(18), n, 16);
                        this.xmodelo1.setValueAt(xrs.getString(19), n, 17);
                        this.xmodelo1.setValueAt(xrs.getString(20), n, 18);
                        this.xmodelo1.setValueAt(xrs.getString(21), n, 19);
                        this.xmodelo1.setValueAt(xrs.getString(5), n, 20);
                        this.JTDetalle1.setDefaultRenderer(Object.class, new MiRender());
                        n++;
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformacion_Empresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFInformacion_Empresa$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.valueOf(table.getValueAt(row, 15).toString()).intValue() == 2) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
