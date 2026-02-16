package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/JIFCalibrar.class */
public class JIFCalibrar extends JInternalFrame {
    private String[] xidmarca;
    private String[] xidmarca1;
    private String[] xidrepuesto;
    private String[] xidarea;
    private String[] xidprovedor;
    private String[] xidinvima;
    private String[] xidRegtecnico;
    private String[] xidfrecuencia;
    private String[] xidmanual;
    private String[] xidcalibracion;
    private String[][] xidcomponente;
    private String[][] xidnormalidad;
    private String[][] xidprocedimiento;
    private File xfile;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelocomponente;
    public DefaultTableModel xmodelonormalidad;
    public DefaultTableModel xmodelomanual;
    public DefaultTableModel xmodeloproce;
    public DefaultTableModel xmodelocalibra;
    public DefaultTableModel xmodelorepuesto;
    public DefaultTableModel xmodeloregistrotecnico;
    public Object[] dato;
    public Object[] datocomponente;
    public Object[] datosnormalidad;
    public Object[] datosmanual;
    public Object[] datosproce;
    public Object[] datoscalibra;
    public Object[] datosrepuesto;
    public Object[] datoscomponente;
    public Object[] datosregistrotecnico;
    public boolean lleno;
    public String sql;
    public String sqlnormalidad;
    public String sqlmanual;
    public String sqlproce;
    public String sqlcalibra;
    public String sqlrepuesto;
    public String sql16;
    public String sqlregistrotecnico;
    public String ruta;
    public String dato1;
    public String dato2;
    public claseMantenimiento Cmantenimiento;
    public String sql1;
    public String sql2;
    private JTextField JTFRuta;
    private JComboBox combocentrocosto;
    private JComboBox comboinvima;
    private JComboBox combomarca;
    private JComboBox comboproveedor;
    private JPanel datosequipo;
    private JDateChooser fecharegistro;
    private JButton jButton4;
    private JDateChooser jDateChooser1;
    private JDateChooser jDateChooser2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane12;
    private JScrollPane jScrollPane4;
    private JTable tablacalibracion;
    private JTextArea txtdes;
    private JTextField txtmodelo;
    private JTextField txtnombre;
    private JTextField txtserie;
    private JTextField txtvalor;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta5 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta6 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta7 = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JIFCalibrar() {
        this.lleno = false;
        initComponents();
        this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC", this.xidarea, this.combocentrocosto);
        this.combocentrocosto.setSelectedIndex(-1);
        this.xidinvima = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_clasificacion WHERE (Estado =0) ORDER BY Nbre ASC", this.xidinvima, this.comboinvima);
        this.comboinvima.setSelectedIndex(-1);
        this.xidprovedor = this.xconsulta.llenarCombo("SELECT Id, RazonSocialCompleta FROM cc_terceros WHERE (Estado =1) ORDER BY RazonSocialCompleta ASC", this.xidprovedor, this.comboproveedor);
        this.comboproveedor.setSelectedIndex(-1);
        this.xidmarca = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_laboratorio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmarca, this.combomarca);
        this.combomarca.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.lleno = true;
        consultar();
        crearGridcalibracion();
        llenatablacalibracion();
        this.jDateChooser2.setDate(this.metodos.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.datosequipo = new JPanel();
        this.txtnombre = new JTextField();
        this.txtmodelo = new JTextField();
        this.txtserie = new JTextField();
        this.fecharegistro = new JDateChooser();
        this.jDateChooser1 = new JDateChooser();
        this.comboproveedor = new JComboBox();
        this.combocentrocosto = new JComboBox();
        this.txtvalor = new JTextField();
        this.comboinvima = new JComboBox();
        this.combomarca = new JComboBox();
        this.jPanel1 = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.tablacalibracion = new JTable();
        this.jButton4 = new JButton();
        this.JTFRuta = new JTextField();
        this.jScrollPane12 = new JScrollPane();
        this.txtdes = new JTextArea();
        this.jDateChooser2 = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SOPORTE CALIBRACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(937, 825));
        setMinimumSize(new Dimension(937, 825));
        getContentPane().setLayout(new AbsoluteLayout());
        this.datosequipo.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS EQUIPOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.datosequipo.setEnabled(false);
        this.datosequipo.setLayout((LayoutManager) null);
        this.txtnombre.setFont(new Font("Arial", 1, 12));
        this.txtnombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Equipo", 0, 0, new Font("Arial", 1, 12)));
        this.txtnombre.setEnabled(false);
        this.datosequipo.add(this.txtnombre);
        this.txtnombre.setBounds(180, 20, 360, 50);
        this.txtmodelo.setFont(new Font("Arial", 1, 12));
        this.txtmodelo.setBorder(BorderFactory.createTitledBorder((Border) null, "Modelo", 0, 0, new Font("Arial", 1, 12)));
        this.txtmodelo.setEnabled(false);
        this.txtmodelo.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFCalibrar.1
            public void actionPerformed(ActionEvent evt) {
                JIFCalibrar.this.txtmodeloActionPerformed(evt);
            }
        });
        this.datosequipo.add(this.txtmodelo);
        this.txtmodelo.setBounds(550, 20, 140, 41);
        this.txtserie.setFont(new Font("Arial", 1, 12));
        this.txtserie.setBorder(BorderFactory.createTitledBorder((Border) null, "# Serie", 0, 0, new Font("Arial", 1, 12)));
        this.txtserie.setEnabled(false);
        this.txtserie.addCaretListener(new CaretListener() { // from class: Mantenimiento.JIFCalibrar.2
            public void caretUpdate(CaretEvent evt) {
                JIFCalibrar.this.txtserieCaretUpdate(evt);
            }
        });
        this.txtserie.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFCalibrar.3
            public void actionPerformed(ActionEvent evt) {
                JIFCalibrar.this.txtserieActionPerformed(evt);
            }
        });
        this.txtserie.addFocusListener(new FocusAdapter() { // from class: Mantenimiento.JIFCalibrar.4
            public void focusGained(FocusEvent evt) {
                JIFCalibrar.this.txtserieFocusGained(evt);
            }
        });
        this.datosequipo.add(this.txtserie);
        this.txtserie.setBounds(10, 20, 160, 50);
        this.fecharegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Registro", 0, 0, new Font("Arial", 1, 12)));
        this.fecharegistro.setDateFormatString("dd/MM/yyyy");
        this.fecharegistro.setEnabled(false);
        this.fecharegistro.setFont(new Font("Arial", 1, 12));
        this.fecharegistro.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFCalibrar.5
            public void mouseClicked(MouseEvent evt) {
                JIFCalibrar.this.fecharegistroMouseClicked(evt);
            }
        });
        this.datosequipo.add(this.fecharegistro);
        this.fecharegistro.setBounds(490, 80, 200, 44);
        this.jDateChooser1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Adquisiciòn", 0, 0, new Font("Arial", 1, 12)));
        this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
        this.jDateChooser1.setDoubleBuffered(false);
        this.jDateChooser1.setEnabled(false);
        this.jDateChooser1.setFont(new Font("Arial", 1, 12));
        this.jDateChooser1.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFCalibrar.6
            public void mouseClicked(MouseEvent evt) {
                JIFCalibrar.this.jDateChooser1MouseClicked(evt);
            }
        });
        this.jDateChooser1.addKeyListener(new KeyAdapter() { // from class: Mantenimiento.JIFCalibrar.7
            public void keyPressed(KeyEvent evt) {
                JIFCalibrar.this.jDateChooser1KeyPressed(evt);
            }
        });
        this.datosequipo.add(this.jDateChooser1);
        this.jDateChooser1.setBounds(290, 80, 190, 44);
        this.comboproveedor.setFont(new Font("Arial", 1, 12));
        this.comboproveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12)));
        this.comboproveedor.setEnabled(false);
        this.datosequipo.add(this.comboproveedor);
        this.comboproveedor.setBounds(10, 140, 430, 43);
        this.combocentrocosto.setFont(new Font("Arial", 1, 12));
        this.combocentrocosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12)));
        this.combocentrocosto.setEnabled(false);
        this.datosequipo.add(this.combocentrocosto);
        this.combocentrocosto.setBounds(10, 80, 270, 43);
        this.txtvalor.setFont(new Font("Arial", 1, 12));
        this.txtvalor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Equipo", 0, 0, new Font("Arial", 1, 12)));
        this.txtvalor.setEnabled(false);
        this.txtvalor.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFCalibrar.8
            public void actionPerformed(ActionEvent evt) {
                JIFCalibrar.this.txtvalorActionPerformed(evt);
            }
        });
        this.datosequipo.add(this.txtvalor);
        this.txtvalor.setBounds(460, 140, 400, 50);
        this.comboinvima.setFont(new Font("Arial", 1, 12));
        this.comboinvima.setBorder(BorderFactory.createTitledBorder((Border) null, "Invima", 0, 0, new Font("Arial", 1, 12)));
        this.comboinvima.setEnabled(false);
        this.datosequipo.add(this.comboinvima);
        this.comboinvima.setBounds(700, 80, 160, 43);
        this.combomarca.setFont(new Font("Arial", 1, 12));
        this.combomarca.setBorder(BorderFactory.createTitledBorder((Border) null, "Marca", 0, 0, new Font("Arial", 1, 12)));
        this.combomarca.setEnabled(false);
        this.datosequipo.add(this.combomarca);
        this.combomarca.setBounds(700, 20, 160, 43);
        getContentPane().add(this.datosequipo, new AbsoluteConstraints(10, 11, 880, 200));
        this.jScrollPane4.setBorder(new SoftBevelBorder(0));
        this.jScrollPane4.setFont(new Font("Arial", 1, 12));
        this.tablacalibracion.setBorder(BorderFactory.createEtchedBorder());
        this.tablacalibracion.setFont(new Font("Arial", 1, 12));
        this.tablacalibracion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablacalibracion.setRowHeight(25);
        this.tablacalibracion.setSelectionBackground(new Color(255, 255, 255));
        this.tablacalibracion.setSelectionForeground(new Color(255, 0, 0));
        this.tablacalibracion.setSelectionMode(0);
        this.tablacalibracion.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFCalibrar.9
            public void mouseClicked(MouseEvent evt) {
                JIFCalibrar.this.tablacalibracionMouseClicked(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.tablacalibracion);
        this.jButton4.setFont(new Font("Arial", 1, 12));
        this.jButton4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton4.setText("Agregar");
        this.jButton4.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFCalibrar.10
            public void actionPerformed(ActionEvent evt) {
                JIFCalibrar.this.jButton4ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFCalibrar.11
            public void mouseClicked(MouseEvent evt) {
                JIFCalibrar.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFCalibrar.12
            public void actionPerformed(ActionEvent evt) {
                JIFCalibrar.this.JTFRutaActionPerformed(evt);
            }
        });
        this.txtdes.setColumns(7);
        this.txtdes.setFont(new Font("Arial", 1, 12));
        this.txtdes.setRows(3);
        this.txtdes.setText(" ");
        this.txtdes.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane12.setViewportView(this.txtdes);
        this.jDateChooser2.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Calibración", 0, 0, new Font("Arial", 1, 12)));
        this.jDateChooser2.setDateFormatString("dd/MM/yyyy");
        this.jDateChooser2.setDoubleBuffered(false);
        this.jDateChooser2.setFont(new Font("Arial", 1, 12));
        this.jDateChooser2.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFCalibrar.13
            public void mouseClicked(MouseEvent evt) {
                JIFCalibrar.this.jDateChooser2MouseClicked(evt);
            }
        });
        this.jDateChooser2.addKeyListener(new KeyAdapter() { // from class: Mantenimiento.JIFCalibrar.14
            public void keyPressed(KeyEvent evt) {
                JIFCalibrar.this.jDateChooser2KeyPressed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane4, GroupLayout.Alignment.LEADING, -1, 860, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane12, -1, 620, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -1, 620, 32767)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jDateChooser2, -1, 222, 32767).addComponent(this.jButton4, -1, 222, 32767)))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton4, -1, -1, 32767).addComponent(this.JTFRuta)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane12, -2, 52, -2).addComponent(this.jDateChooser2, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jScrollPane4, -1, 421, 32767).addContainerGap()));
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(10, 222, 880, 560));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtmodeloActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtserieCaretUpdate(CaretEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtserieActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtserieFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fecharegistroMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jDateChooser1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jDateChooser1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtvalorActionPerformed(ActionEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridcalibracion() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Descripcion ", "Ruta ", "Fecha Calibracion", "Fecha Registro"}) { // from class: Mantenimiento.JIFCalibrar.15
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablacalibracion.setModel(this.xmodelo);
        this.tablacalibracion.getColumnModel().getColumn(0).setPreferredWidth(110);
        this.tablacalibracion.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.tablacalibracion.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.tablacalibracion.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    public final void cargarDatoscalibracion(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(rs.getString(1), n, 0);
                this.xmodelo.setValueAt(rs.getString(2), n, 1);
                this.xmodelo.setValueAt(rs.getString(3), n, 2);
                this.xmodelo.setValueAt(rs.getString(4), n, 3);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    private void llenatablacalibracion() {
        this.sql16 = "SELECT Descripcion, Ruta, Fecha, FechaRegistro FROM m_soportecalibracion WHERE (Id_Equipo = '" + Principal.txtNo.getText() + "')";
        cargarDatoscalibracion(this.sql16);
    }

    private void consultar() {
        String sql1 = "SELECT  `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Estado`, `m_equipos`.`Id` FROM `m_equipos` INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN `baseserver`.cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)WHERE `m_equipos`.`Estado` = 1 AND `m_equipos`.`Id`= '" + Principal.txtNo.getText() + "'  ORDER BY `m_equipos`.`Nombre` ASC";
        ResultSet Rf = this.xconsulta.traerRs(sql1);
        System.out.print(sql1);
        try {
            if (Rf.next()) {
                Rf.first();
                this.txtnombre.setText(Rf.getString(1));
                this.txtvalor.setText(Rf.getString(2));
                this.txtserie.setText(Rf.getString(3));
                this.txtmodelo.setText(Rf.getString(4));
                this.combomarca.setSelectedItem(Rf.getString(5));
                this.comboinvima.setSelectedItem(Rf.getString(6));
                this.combocentrocosto.setSelectedItem(Rf.getString(7));
                this.comboproveedor.setSelectedItem(Rf.getString(8));
                this.jDateChooser1.setDate(Rf.getDate(9));
                this.fecharegistro.setDate(Rf.getDate(10));
            }
            Rf.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCalibrar.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                Metodos xmt = new Metodos();
                String sql01 = "insert into m_soportecalibracion (Id_Equipo, Descripcion, Ruta, Fecha, FechaRegistro, Estado, UsuarioSis) values('" + Principal.txtNo.getText() + "', '" + this.txtdes.getText() + "', '" + this.JTFRuta.getText() + "','" + this.metodos.formatoAMD.format(this.jDateChooser2.getDate()) + "','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "','1','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xconsulta.ejecutarSQL(sql01);
                System.out.println(sql01);
                crearGridcalibracion();
                llenatablacalibracion();
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton4ActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\SoporteCalibracion\\");
            xfilec.setFileSelectionMode(0);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.metodos.mTraerUrlBD(this.xfile.getPath()));
            }
            String[] ficheros = this.xfile.list();
            if (ficheros == null) {
                System.out.println("No hay ficheros en el directorio especificado");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablacalibracionMouseClicked(MouseEvent evt) {
        if (this.tablacalibracion.getSelectedRow() != -1 && this.tablacalibracion.getValueAt(this.tablacalibracion.getSelectedRow(), 1) != null) {
            this.xmetodo.mostrarPdf(this.xmodelo.getValueAt(this.tablacalibracion.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jDateChooser2MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jDateChooser2KeyPressed(KeyEvent evt) {
    }
}
