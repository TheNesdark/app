package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/Seguimiento_Mantenimiento.class */
public class Seguimiento_Mantenimiento extends JInternalFrame {
    private String[] xidrepuesto;
    private String[] xiunidad;
    private String[] xidpatron;
    public Object[] dato;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo2;
    public DefaultTableModel xmodelo3;
    public DefaultTableModel xmodelo4;
    public String sql;
    public String sql1;
    public String sql2;
    public String sql3;
    public String sql4;
    public String sql5;
    private JButton Anular;
    private JTable Tablasegcalibracion;
    private JButton cargar;
    private JComboBox combopatron;
    private JComboBox comborepuesto;
    private JComboBox combounidad;
    private JDateChooser fecha;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    public JLabel nombre;
    private JTable tablahistorico;
    private JTable tablarepuesto;
    private JTable tablaservicio;
    private JFormattedTextField txtcantidad;
    private JTextArea txtfalla1;
    private JTextArea txtobservaciongeneral;
    private JTextArea txtobservacionrepuesto;
    private JTextField txtreporte;
    private JTextField txtseguimiento;
    private JFormattedTextField txtvalor1;
    private JFormattedTextField txtvalor2;
    private JFormattedTextField txtvalor3;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;
    private Metodos xmetodo = new Metodos();

    public Seguimiento_Mantenimiento(String nombre) {
        initComponents();
        this.fecha.setDate(this.metodos.getFechaActual());
        this.nombre.setText(nombre);
        crearGridrepuesto();
        crearGridpatron();
        crearGridservicio();
        llenatablaservicio();
        crearGridhistorico();
        llenatablahistorico();
        this.xidrepuesto = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tiporespuesto WHERE (Estado =1) ORDER BY Nbre ASC", this.xidrepuesto, this.comborepuesto);
        this.comborepuesto.setSelectedIndex(-1);
        this.xiunidad = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_unidadmedida WHERE (Estado =0) ORDER BY Nbre ASC", this.xiunidad, this.combounidad);
        this.combounidad.setSelectedIndex(-1);
        this.xidpatron = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tipopatron WHERE (Estado =1) ORDER BY Nbre ASC", this.xidpatron, this.combopatron);
        this.combopatron.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridservicio() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Servicio", "Activo"}) { // from class: Mantenimiento.Seguimiento_Mantenimiento.1
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaservicio.setModel(this.xmodelo2);
        this.tablaservicio.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablaservicio.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.tablaservicio.getColumnModel().getColumn(2).setPreferredWidth(15);
    }

    public final void cargarDatosservicio(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo2.addRow(this.dato);
                this.xmodelo2.setValueAt(rs.getString(1), n, 0);
                this.xmodelo2.setValueAt(rs.getString(2), n, 1);
                this.xmodelo2.setValueAt(false, n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    public final void cargarDatosservicio1(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo2.addRow(this.dato);
                this.xmodelo2.setValueAt(rs.getString(1), n, 0);
                this.xmodelo2.setValueAt(rs.getString(2), n, 1);
                this.xmodelo2.setValueAt(true, n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    private void llenatablaservicio() {
        this.sql1 = "SELECT `Id` , `Nbre` FROM `baseserver`.`m_tiposervicio` WHERE Estado = '1'";
        crearGridservicio();
        cargarDatosservicio(this.sql1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridhistorico() {
        this.xmodelo3 = new DefaultTableModel(new Object[0], new String[]{"Id", "Equipo", "falla", "observacion"}) { // from class: Mantenimiento.Seguimiento_Mantenimiento.2
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablahistorico.setModel(this.xmodelo3);
        this.tablahistorico.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablahistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.tablahistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.tablahistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
    }

    public final void cargarDatoshistorico(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo3.addRow(this.dato);
                this.xmodelo3.setValueAt(rs.getString(1), n, 0);
                this.xmodelo3.setValueAt(rs.getString(2), n, 1);
                this.xmodelo3.setValueAt(rs.getString(3), n, 2);
                this.xmodelo3.setValueAt(rs.getString(4), n, 3);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    private void llenatablahistorico() {
        this.sql3 = "SELECT  `m_reporteservicio`.`Id`, `m_equipos`.`Nombre`, `m_reporteservicio`.`Falla`, `m_reporteservicio`.`Observacion` FROM `baseserver`.`m_reporteservicio` INNER JOIN `baseserver`.`m_equipos` ON (`m_reporteservicio`.`Id_Equipo` = `m_equipos`.`Id`) WHERE `Id_Equipo` = '" + Principal.txtNo.getText() + "' AND `m_reporteservicio`.`Estado`= 1 ";
        System.out.println(this.sql3);
        cargarDatoshistorico(this.sql3);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridpatron() {
        this.xmodelo4 = new DefaultTableModel(new Object[0], new String[]{"Id", "Medida", "Equipo", "Patron", "Serie-Patron"}) { // from class: Mantenimiento.Seguimiento_Mantenimiento.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.Tablasegcalibracion.setModel(this.xmodelo4);
        this.Tablasegcalibracion.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.Tablasegcalibracion.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.Tablasegcalibracion.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.Tablasegcalibracion.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.Tablasegcalibracion.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    public final void cargarDatospatron(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo4.addRow(this.dato);
                this.xmodelo4.setValueAt(rs.getString(1), n, 0);
                this.xmodelo4.setValueAt(rs.getString(2), n, 1);
                this.xmodelo4.setValueAt(rs.getString(3), n, 2);
                this.xmodelo4.setValueAt(rs.getString(4), n, 3);
                this.xmodelo4.setValueAt(rs.getString(5), n, 4);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    private void llenatablapatron() {
        this.sql3 = "SELECT m_patron_calibraciones.Id , i_unidadmedida.Nbre , m_patron_calibraciones.Datos_equipo , m_patron_calibraciones.Datos_patron , m_tipopatron.Nbre FROM  baseserver.m_patron_calibraciones INNER JOIN baseserver.m_tipopatron ON (m_patron_calibraciones.Id_serie_patron = m_tipopatron.Id)INNER JOIN baseserver.i_unidadmedida ON (m_patron_calibraciones.Id_unidad = i_unidadmedida.Id) WHERE m_patron_calibraciones.Estado=0 ";
        System.out.println(this.sql3);
        crearGridpatron();
        cargarDatospatron(this.sql3);
    }

    private void llenatablapatron2() {
        crearGridpatron();
        this.sql3 = "SELECT m_patron_calibraciones.Id , i_unidadmedida.Nbre , m_patron_calibraciones.Datos_equipo , m_patron_calibraciones.Datos_patron , m_tipopatron.Nbre FROM  baseserver.m_patron_calibraciones INNER JOIN baseserver.m_tipopatron ON (m_patron_calibraciones.Id_serie_patron = m_tipopatron.Id)INNER JOIN baseserver.i_unidadmedida ON (m_patron_calibraciones.Id_unidad = i_unidadmedida.Id) WHERE m_patron_calibraciones.Id_Reporte='" + this.txtreporte.getText() + "' ";
        System.out.println(this.sql3);
        cargarDatospatron(this.sql3);
    }

    private void bloqueado() {
        this.txtseguimiento.setEnabled(false);
        this.txtvalor2.setEnabled(false);
        this.txtvalor3.setEnabled(false);
        this.combounidad.setEnabled(false);
        this.combopatron.setEnabled(false);
        this.cargar.setEnabled(false);
    }

    private void desbloqueado() {
        this.txtseguimiento.setEnabled(true);
        this.txtvalor2.setEnabled(true);
        this.txtvalor3.setEnabled(true);
        this.combounidad.setEnabled(true);
        this.combopatron.setEnabled(true);
        this.cargar.setEnabled(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridrepuesto() {
        this.nfila = 0;
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "nombre", "Cantidad", "Valor", "Observacion"}) { // from class: Mantenimiento.Seguimiento_Mantenimiento.4
            Class[] types = {String.class, String.class, Integer.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablarepuesto.setModel(this.xmodelo1);
        this.tablarepuesto.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablarepuesto.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.tablarepuesto.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.tablarepuesto.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.tablarepuesto.getColumnModel().getColumn(4).setPreferredWidth(150);
    }

    public final void cargarDatosrepuestos(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo1.addRow(this.dato);
                this.xmodelo1.setValueAt(rs.getString(1), n, 0);
                this.xmodelo1.setValueAt(rs.getString(2), n, 1);
                this.xmodelo1.setValueAt(Integer.valueOf(rs.getInt(3)), n, 2);
                this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(4)), n, 3);
                this.xmodelo1.setValueAt(rs.getString(5), n, 4);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    private void llenatablarepuesto() {
        this.xmodelo1.addRow(this.dato);
        this.xmodelo1.setValueAt(this.xidrepuesto[this.comborepuesto.getSelectedIndex()], this.nfila, 0);
        this.xmodelo1.setValueAt(this.comborepuesto.getSelectedItem().toString(), this.nfila, 1);
        this.xmodelo1.setValueAt(this.txtcantidad.getValue(), this.nfila, 2);
        this.xmodelo1.setValueAt(this.txtvalor1.getValue(), this.nfila, 3);
        this.xmodelo1.setValueAt(this.txtobservacionrepuesto.getText(), this.nfila, 4);
        this.nfila++;
    }

    /* JADX WARN: Type inference failed for: r3v123, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.tablahistorico = new JTable();
        this.jPanel2 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.tablarepuesto = new JTable();
        this.jPanel4 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.tablaservicio = new JTable();
        this.jScrollPane6 = new JScrollPane();
        this.txtfalla1 = new JTextArea();
        this.jScrollPane7 = new JScrollPane();
        this.txtobservacionrepuesto = new JTextArea();
        this.jButton2 = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.txtobservaciongeneral = new JTextArea();
        this.txtcantidad = new JFormattedTextField();
        this.fecha = new JDateChooser();
        this.comborepuesto = new JComboBox();
        this.nombre = new JLabel();
        this.txtvalor1 = new JFormattedTextField();
        this.jPanel3 = new JPanel();
        this.jPanel5 = new JPanel();
        this.combopatron = new JComboBox();
        this.txtvalor2 = new JFormattedTextField();
        this.txtvalor3 = new JFormattedTextField();
        this.cargar = new JButton();
        this.combounidad = new JComboBox();
        this.Anular = new JButton();
        this.jScrollPane8 = new JScrollPane();
        this.Tablasegcalibracion = new JTable();
        this.txtreporte = new JTextField();
        this.jButton1 = new JButton();
        this.txtseguimiento = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("SEGUIMIENTO Y CONTROL DE MANTENIMIENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1023, 675));
        setMinimumSize(new Dimension(1023, 675));
        setName("Seguimiento_Mantenimiento");
        addInternalFrameListener(new InternalFrameListener() { // from class: Mantenimiento.Seguimiento_Mantenimiento.5
            public void internalFrameClosed(InternalFrameEvent evt) {
                Seguimiento_Mantenimiento.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                Seguimiento_Mantenimiento.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.tablahistorico.setFont(new Font("Arial", 1, 12));
        this.tablahistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablahistorico.setRowHeight(25);
        this.tablahistorico.setSelectionBackground(new Color(255, 255, 255));
        this.tablahistorico.setSelectionForeground(new Color(255, 0, 0));
        this.tablahistorico.setSelectionMode(0);
        this.tablahistorico.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.Seguimiento_Mantenimiento.6
            public void mouseClicked(MouseEvent evt) {
                Seguimiento_Mantenimiento.this.tablahistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.tablahistorico);
        this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(10, 20, 570, 270));
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(270, 460, 590, 300));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLES REPUESTOS", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.tablarepuesto.setFont(new Font("Arial", 1, 12));
        this.tablarepuesto.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablarepuesto.setRowHeight(25);
        this.tablarepuesto.setSelectionBackground(new Color(255, 255, 255));
        this.tablarepuesto.setSelectionForeground(Color.red);
        this.tablarepuesto.setSelectionMode(0);
        this.jScrollPane3.setViewportView(this.tablarepuesto);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 559, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 116, 32767));
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(270, 250, 580, 140));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE SERVICIOS A REALIZAR", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.jPanel4.setLayout(new AbsoluteLayout());
        this.tablaservicio.setFont(new Font("Arial", 1, 12));
        this.tablaservicio.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaservicio.setRowHeight(25);
        this.tablaservicio.setSelectionBackground(new Color(255, 255, 255));
        this.tablaservicio.setSelectionForeground(new Color(255, 0, 0));
        this.tablaservicio.setSelectionMode(0);
        this.jScrollPane5.setViewportView(this.tablaservicio);
        this.jPanel4.add(this.jScrollPane5, new AbsoluteConstraints(10, 30, 230, 470));
        getContentPane().add(this.jPanel4, new AbsoluteConstraints(10, 250, 260, 510));
        this.txtfalla1.setColumns(20);
        this.txtfalla1.setFont(new Font("Arial", 1, 12));
        this.txtfalla1.setLineWrap(true);
        this.txtfalla1.setRows(1);
        this.txtfalla1.setTabSize(3);
        this.txtfalla1.setBorder(BorderFactory.createTitledBorder((Border) null, "Falla Reportada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane6.setViewportView(this.txtfalla1);
        getContentPane().add(this.jScrollPane6, new AbsoluteConstraints(20, 70, 580, 60));
        this.txtobservacionrepuesto.setColumns(20);
        this.txtobservacionrepuesto.setFont(new Font("Arial", 1, 12));
        this.txtobservacionrepuesto.setRows(1);
        this.txtobservacionrepuesto.setTabSize(5);
        this.txtobservacionrepuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación en repuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane7.setViewportView(this.txtobservacionrepuesto);
        getContentPane().add(this.jScrollPane7, new AbsoluteConstraints(610, 140, 240, 60));
        this.jButton2.setBackground(new Color(255, 255, 255));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton2.setText(" Cargar");
        this.jButton2.setHorizontalTextPosition(4);
        this.jButton2.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento_Mantenimiento.7
            public void actionPerformed(ActionEvent evt) {
                Seguimiento_Mantenimiento.this.jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jButton2, new AbsoluteConstraints(20, 210, 830, 30));
        this.txtobservaciongeneral.setColumns(20);
        this.txtobservaciongeneral.setFont(new Font("Arial", 1, 12));
        this.txtobservaciongeneral.setRows(1);
        this.txtobservaciongeneral.setText("\n");
        this.txtobservaciongeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSERVACIÓN GENERAL", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jScrollPane2.setViewportView(this.txtobservaciongeneral);
        getContentPane().add(this.jScrollPane2, new AbsoluteConstraints(280, 400, 570, 60));
        this.txtcantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtcantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtcantidad.setFont(new Font("Arial", 1, 12));
        this.txtcantidad.setValue(new Integer(0));
        getContentPane().add(this.txtcantidad, new AbsoluteConstraints(360, 140, 80, 60));
        this.fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.fecha.setFont(new Font("Arial", 1, 12));
        getContentPane().add(this.fecha, new AbsoluteConstraints(610, 70, 240, 60));
        this.comborepuesto.setFont(new Font("Arial", 1, 12));
        this.comborepuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Repuestos instalados", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.comborepuesto.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento_Mantenimiento.8
            public void actionPerformed(ActionEvent evt) {
                Seguimiento_Mantenimiento.this.comborepuestoActionPerformed(evt);
            }
        });
        getContentPane().add(this.comborepuesto, new AbsoluteConstraints(20, 140, 330, 60));
        this.nombre.setBackground(new Color(0, 51, 204));
        this.nombre.setFont(new Font("Arial", 1, 18));
        this.nombre.setForeground(new Color(0, 102, 0));
        this.nombre.setText("NOMBRE DEL EQUIPO AQUI");
        getContentPane().add(this.nombre, new AbsoluteConstraints(20, 20, 820, -1));
        this.txtvalor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtvalor1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtvalor1.setFont(new Font("Arial", 1, 12));
        this.txtvalor1.setValue(new Integer(0));
        getContentPane().add(this.txtvalor1, new AbsoluteConstraints(450, 140, 150, 60));
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel5.setBorder(BorderFactory.createEtchedBorder());
        this.combopatron.setFont(new Font("Arial", 1, 12));
        this.combopatron.setBorder(BorderFactory.createTitledBorder((Border) null, "Serie del Patron", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.combopatron.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento_Mantenimiento.9
            public void actionPerformed(ActionEvent evt) {
                Seguimiento_Mantenimiento.this.combopatronActionPerformed(evt);
            }
        });
        this.txtvalor2.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos Patron", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtvalor2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtvalor2.setFont(new Font("Arial", 1, 12));
        this.txtvalor2.setValue(new Integer(0));
        this.txtvalor3.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos Equipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtvalor3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtvalor3.setFont(new Font("Arial", 1, 12));
        this.txtvalor3.setValue(new Integer(0));
        this.cargar.setBackground(new Color(255, 255, 255));
        this.cargar.setFont(new Font("Arial", 1, 12));
        this.cargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.cargar.setText(" Cargar");
        this.cargar.setHorizontalTextPosition(4);
        this.cargar.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento_Mantenimiento.10
            public void actionPerformed(ActionEvent evt) {
                Seguimiento_Mantenimiento.this.cargarActionPerformed(evt);
            }
        });
        this.combounidad.setFont(new Font("Arial", 1, 12));
        this.combounidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Patron y Equipo", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.combounidad.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento_Mantenimiento.11
            public void actionPerformed(ActionEvent evt) {
                Seguimiento_Mantenimiento.this.combounidadActionPerformed(evt);
            }
        });
        this.Anular.setBackground(new Color(255, 255, 255));
        this.Anular.setFont(new Font("Arial", 1, 12));
        this.Anular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cancelar30x30.png")));
        this.Anular.setText("Anular");
        this.Anular.setHorizontalTextPosition(4);
        this.Anular.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento_Mantenimiento.12
            public void actionPerformed(ActionEvent evt) {
                Seguimiento_Mantenimiento.this.AnularActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtvalor2, -1, 282, 32767).addComponent(this.txtvalor3, -1, 282, 32767).addComponent(this.combopatron, 0, 282, 32767).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.cargar, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Anular, -1, 111, 32767)).addComponent(this.combounidad, GroupLayout.Alignment.TRAILING, 0, 282, 32767)).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.combounidad, -2, 60, -2).addGap(7, 7, 7).addComponent(this.txtvalor2, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtvalor3, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.combopatron, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cargar, -2, 51, -2).addComponent(this.Anular, -2, 49, -2)).addContainerGap(-1, 32767)));
        this.jScrollPane8.setBorder(BorderFactory.createTitledBorder((Border) null, "Seguimiento Calibración", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 102, 0)));
        this.Tablasegcalibracion.setFont(new Font("Arial", 1, 12));
        this.Tablasegcalibracion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.Tablasegcalibracion.setRowHeight(25);
        this.Tablasegcalibracion.setSelectionBackground(new Color(255, 255, 255));
        this.Tablasegcalibracion.setSelectionForeground(Color.red);
        this.Tablasegcalibracion.setSelectionMode(0);
        this.Tablasegcalibracion.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.Seguimiento_Mantenimiento.13
            public void mouseClicked(MouseEvent evt) {
                Seguimiento_Mantenimiento.this.TablasegcalibracionMouseClicked(evt);
            }
        });
        this.jScrollPane8.setViewportView(this.Tablasegcalibracion);
        this.txtreporte.setFont(new Font("Arial", 1, 18));
        this.txtreporte.setForeground(new Color(0, 102, 0));
        this.txtreporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº REPORTE", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.txtreporte.setEnabled(false);
        this.jButton1.setBackground(new Color(255, 255, 255));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.jButton1.setEnabled(false);
        this.jButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.Seguimiento_Mantenimiento.14
            public void actionPerformed(ActionEvent evt) {
                Seguimiento_Mantenimiento.this.jButton1ActionPerformed(evt);
            }
        });
        this.txtseguimiento.setFont(new Font("Arial", 1, 18));
        this.txtseguimiento.setForeground(new Color(0, 102, 0));
        this.txtseguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Seguimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.txtseguimiento.setEnabled(false);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane8, -1, 306, 32767).addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(this.txtseguimiento, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addComponent(this.txtreporte, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 30, -2))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtreporte, -2, -1, -2).addComponent(this.txtseguimiento, -2, -1, -2)).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jButton1))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 49, 32767).addComponent(this.jPanel5, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jScrollPane8, -2, 280, -2).addContainerGap()));
        getContentPane().add(this.jPanel3, new AbsoluteConstraints(860, 10, 330, 750));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (this.txtcantidad.getText().equals("0") || this.txtvalor1.getText().equals("0")) {
            JOptionPane.showInternalMessageDialog(this, " Faltan Datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        llenatablarepuesto();
        this.txtcantidad.setValue(new Integer(0));
        this.txtvalor1.setValue(new Integer(0));
        this.txtobservacionrepuesto.setText("");
        this.comborepuesto.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablahistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablahistorico.getSelectedRow() != -1) {
            llenatablahistorico2(this.xmodelo3.getValueAt(this.tablahistorico.getSelectedRow(), 0).toString());
            this.txtreporte.setText(this.xmodelo3.getValueAt(this.tablahistorico.getSelectedRow(), 0).toString());
            llenarservicio2();
            this.tablaservicio.setEnabled(false);
            this.jButton2.setEnabled(false);
            this.jButton1.setEnabled(true);
            llenatablapatron2();
            bloqueado();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void comborepuestoActionPerformed(ActionEvent evt) {
        this.jButton2.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (!this.txtreporte.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta Seguro de Anular Este Servicio", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql11 = " update m_reporteservicio set Estado= 0 WHERE m_reporteservicio.Id = '" + this.txtreporte.getText() + "'";
                this.xconsulta.ejecutarSQL(sql11);
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Registro Anulado Correctamente", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridrepuesto();
                llenatablarepuesto();
                crearGridhistorico();
                llenatablahistorico();
                crearGridservicio();
                llenatablaservicio();
                this.txtreporte.setText("");
                this.jButton1.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combopatronActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarActionPerformed(ActionEvent evt) {
        Metodos xmt = new Metodos();
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql13 = "insert into   m_patron_calibraciones ( Id_unidad, Datos_patron, Datos_equipo, Id_serie_patron, Estado, Usuario, Fecha) values('" + this.xiunidad[this.combounidad.getSelectedIndex()] + "','" + this.txtvalor2.getText() + "','" + this.txtvalor3.getText() + "','" + this.xidpatron[this.combopatron.getSelectedIndex()] + "','0', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            System.out.println(sql13);
            this.xconsulta.ejecutarSQL(sql13);
            this.xconsulta.cerrarConexionBd();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            llenatablapatron();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combounidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AnularActionPerformed(ActionEvent evt) {
        new Metodos();
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro Eliminar el registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql13 = "DELETE from m_patron_calibraciones WHERE Id = '" + this.txtseguimiento.getText() + "' ";
            System.out.println(sql13);
            this.xconsulta.ejecutarSQL(sql13);
            this.xconsulta.cerrarConexionBd();
            this.txtseguimiento.setText("");
            this.txtvalor2.setText("");
            this.txtvalor3.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro Eliminado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            llenatablapatron();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TablasegcalibracionMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.Tablasegcalibracion.getSelectedRow() != -1) {
            this.txtseguimiento.setText(this.xmodelo4.getValueAt(this.Tablasegcalibracion.getSelectedRow(), 0).toString());
            this.combounidad.setSelectedItem(this.xmodelo4.getValueAt(this.Tablasegcalibracion.getSelectedRow(), 1).toString());
            this.txtvalor2.setText(this.xmodelo4.getValueAt(this.Tablasegcalibracion.getSelectedRow(), 2).toString());
            this.txtvalor3.setText(this.xmodelo4.getValueAt(this.Tablasegcalibracion.getSelectedRow(), 3).toString());
            this.combopatron.setSelectedItem(this.xmodelo4.getValueAt(this.Tablasegcalibracion.getSelectedRow(), 4).toString());
        }
    }

    private void llenatablahistorico2(String idregistro) {
        this.sql4 = "SELECT `m_detalle_repuesto`.`Id_Reporte`, `m_tiporespuesto`.`Nbre`, `m_detalle_repuesto`.`Cantidad` , `m_detalle_repuesto`.`Valor` , `m_detalle_repuesto`.`Observacion` FROM `baseserver`.`m_detalle_repuesto` INNER JOIN `baseserver`.`m_tiporespuesto` ON (`m_detalle_repuesto`.`Id_Repuesto` = `m_tiporespuesto`.`Id`) WHERE `Id_Reporte` = '" + idregistro + "' ";
        System.out.println(this.sql4);
        crearGridrepuesto();
        cargarDatosrepuestos(this.sql4);
    }

    private void llenarservicio2() {
        this.sql5 = "SELECT `m_tiposervicio`.`Id`, `m_tiposervicio`.`Nbre` FROM `baseserver`.`m_detalle_servicio` INNER JOIN `baseserver`.`m_tiposervicio`  ON (`m_detalle_servicio`.`Id_Servicio` = `m_tiposervicio`.`Id`)WHERE `Id_Reporte` = '" + this.txtreporte.getText() + "'";
        crearGridservicio();
        cargarDatosservicio1(this.sql5);
    }

    private void borrarFilas() {
        for (int i = 0; i < this.nfila; i++) {
            this.xmodelo.removeRow(0);
        }
        this.nfila = 0;
    }

    public void grabar() {
        mVerificarDatosTablaTrue();
        if (this.txtreporte.getText().equals("")) {
            if (mVerificarDatosTablaTrue()) {
                if (Principal.txtNo.getText() != null) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar ...?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        Metodos xmt = new Metodos();
                        String sql11 = " insert into m_reporteservicio (Id_Equipo, Falla, Observacion, Fecha_R, UsuarioS, Fecha) values ('" + Principal.txtNo.getText() + "', '" + this.txtfalla1.getText() + "', '" + this.txtobservaciongeneral.getText() + "', '" + this.metodos.formatoAMD.format(this.fecha.getDate()) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
                        System.out.println(sql11);
                        String nomrepor = this.xconsulta.ejecutarSQLId(sql11);
                        this.txtreporte.setText(nomrepor);
                        this.xconsulta.cerrarConexionBd();
                        if (this.tablarepuesto.getRowCount() != -1) {
                            for (int x = 0; x < this.tablarepuesto.getRowCount(); x++) {
                                String sql12 = " insert into m_detalle_repuesto (`Id_Reporte` , `Id_Repuesto`,`Cantidad`, `Valor`, `Observacion`) values ('" + nomrepor + "', '" + this.xmodelo1.getValueAt(x, 0) + "', '" + this.xmodelo1.getValueAt(x, 2) + "', '" + this.xmodelo1.getValueAt(x, 3) + "', '" + this.xmodelo1.getValueAt(x, 4) + "')";
                                System.out.println(sql12);
                                this.xconsulta.ejecutarSQL(sql12);
                                this.xconsulta.cerrarConexionBd();
                            }
                        }
                        if (this.tablaservicio.getRowCount() != -1) {
                            for (int x2 = 0; x2 < this.tablaservicio.getRowCount(); x2++) {
                                if (Boolean.valueOf(this.xmodelo2.getValueAt(x2, 2).toString()).booleanValue()) {
                                    String sql13 = " insert into m_detalle_servicio (`Id_Reporte` , `Id_Servicio`) values ('" + nomrepor + "', '" + this.xmodelo2.getValueAt(x2, 0) + "')";
                                    System.out.println(sql13);
                                    this.xconsulta.ejecutarSQL(sql13);
                                    this.xconsulta.cerrarConexionBd();
                                    this.txtfalla1.setText("");
                                    this.txtobservaciongeneral.setText("");
                                    this.txtreporte.setText("");
                                    this.txtreporte.setText(nomrepor);
                                }
                            }
                        }
                        actualiza();
                        this.xconsulta.cerrarConexionBd();
                        JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        imprimir();
                        return;
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar al menos un Servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Solo Puede Visualizar Los Datos; Modo Historial, Presione el Boton Nuevo", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void actualiza() {
        new Metodos();
        String sql13 = "UPDATE baseserver.m_patron_calibraciones SET Id_Reporte = '" + this.txtreporte.getText() + "', Estado = 1 WHERE Estado= 0";
        System.out.println(sql13);
        this.xconsulta.ejecutarSQL(sql13);
        this.xconsulta.cerrarConexionBd();
    }

    public void nuevo() {
        crearGridrepuesto();
        crearGridservicio();
        llenatablaservicio();
        crearGridhistorico();
        this.txtreporte.setText("");
        this.txtseguimiento.setText("");
        this.txtvalor2.setText("");
        this.txtvalor3.setText("");
        this.txtcantidad.setValue(0);
        this.txtvalor1.setValue(0);
        this.txtobservacionrepuesto.setText("");
        this.fecha.setDate(this.metodos.getFechaActual());
        this.tablaservicio.setEnabled(true);
        this.txtfalla1.setText("");
        this.txtobservaciongeneral.setText("");
        this.jButton2.setEnabled(true);
        desbloqueado();
    }

    public void imprimir() {
        if (!this.txtreporte.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.txtreporte.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            if (n == 0) {
                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_Informe_Mantenimiento.jasper", mparametros);
            } else if (n == 1) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_Informe_Mantenimiento", mparametros);
            }
        }
    }

    private boolean mVerificarDatosTablaTrue() {
        boolean estado = false;
        if (this.tablaservicio.getRowCount() > 1) {
            int i = 0;
            while (true) {
                if (i >= this.tablaservicio.getRowCount() - 1) {
                    break;
                }
                if (!this.tablaservicio.getValueAt(i, 2).toString().equals("true")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }
}
