package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/ConfigComplementos.class */
public class ConfigComplementos extends JInternalFrame {
    private String[] xidmarca;
    private String[] xidmarca1;
    private String[] xidfrecuencia;
    private String[] xidunidad;
    private String[] xidtipo;
    private int tipo;
    public String sql001;
    private File xfile;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelofrecuencia;
    public DefaultTableModel xmodelocomponente1;
    public DefaultTableModel xmodelonormalidad1;
    public DefaultTableModel xmodelomanual1;
    public DefaultTableModel xmodeloproce1;
    public DefaultTableModel xmodelocalibra1;
    public DefaultTableModel xmodelorepuesto1;
    public DefaultTableModel xmodeloregistrotecnico1;
    public Object[] dato1;
    public Object[] datosfrecuencia;
    public Object[] datocomponente1;
    public Object[] datosnormalidad1;
    public Object[] datosmanual1;
    public Object[] datosproce1;
    public Object[] datoscalibra1;
    public Object[] datosrepuesto1;
    public Object[] datoscomponente1;
    public Object[] datosregistrotecnico1;
    public String sql1;
    public String sqlnormalidad1;
    public String sqlmanual1;
    public String sqlproce1;
    public String sqlcalibra1;
    public String sqlrepuesto1;
    public String sqlcomponente1;
    public String sqlregistrotecnico1;
    public String sqlfrecuencia;
    public String ruta;
    private JComboBox combofrecuencia;
    private JComboBox combolaboratorio;
    private JComboBox combomarca;
    private JComboBox combotipo;
    private JComboBox combounidad;
    private JDateChooser fecha;
    private JButton jButton1;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;
    private JButton jButton15;
    private JButton jButton16;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel18;
    private JPanel jPanel19;
    private JPanel jPanel2;
    private JPanel jPanel21;
    private JPanel jPanel23;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JScrollPane jScrollPane9;
    private JTabbedPane jTabbedPane2;
    private JTable jTable7;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField12;
    private JTextField jTextField14;
    private JTextField jTextField21;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField9;
    private JTable tablacomponente;
    private JTable tablafecuencia;
    private JTable tablamanual;
    private JTable tablanormalidad;
    private JTable tablaproce;
    private JTable tablaregistrotecnico;
    private JTable tablarepuesto1;
    private JTextField txtfrecuencia;
    private JTextField txtmanual;
    private JTextField txtmax;
    private JTextField txtmin;
    private JTextField txtnombre;
    private JTextField txtnomcomponente;
    private JTextField txtnor;
    private JTextField txtprocedimiento;
    private JTextField txtregistro;
    private JTextField txtrepuesto;
    private JTextField txtserie;
    private JTextField txtvalor;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private ConsultasMySQL xconsulta1 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta2 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta5 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta6 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta7 = new ConsultasMySQL();
    public boolean lleno = false;

    public ConfigComplementos() {
        initComponents();
        crearGridregistrotecnico1();
        llenatablaregistrotecnico1();
        crearGridrepuesto1();
        llenatablarepuesto();
        crearGridproce1();
        llenatablaproce1();
        crearGridnormalidad1();
        llenatablanormalidad();
        crearGridblafrecuencia();
        llenatablablafrecuencia();
        crearGridpcomponente1();
        llenatablaponente1();
        crearGridpmanual();
        llenatablamanual1();
        this.fecha.setDate(this.metodos.getFechaActual());
        this.xidmarca = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_laboratorio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmarca, this.combolaboratorio);
        this.combolaboratorio.setSelectedIndex(-1);
        this.xidmarca1 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_laboratorio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmarca1, this.combomarca);
        this.combomarca.setSelectedIndex(-1);
        this.xidfrecuencia = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tipofrecuencia WHERE (Estado =1) ORDER BY Nbre ASC", this.xidfrecuencia, this.combofrecuencia);
        this.combofrecuencia.setSelectedIndex(-1);
        this.xidunidad = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_unidadmedida WHERE (Estado =0) ORDER BY Nbre ASC", this.xidunidad, this.combounidad);
        this.combounidad.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridregistrotecnico1() {
        this.xmodeloregistrotecnico1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Registro", "Fecha"}) { // from class: Mantenimiento.ConfigComplementos.1
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaregistrotecnico.setModel(this.xmodeloregistrotecnico1);
        this.tablaregistrotecnico.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.tablaregistrotecnico.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.tablaregistrotecnico.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    public final void cargarDatosregistrotecnico1(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodeloregistrotecnico1.addRow(this.datosregistrotecnico1);
                this.xmodeloregistrotecnico1.setValueAt(rs.getString(1), n, 0);
                this.xmodeloregistrotecnico1.setValueAt(rs.getString(2), n, 1);
                this.xmodeloregistrotecnico1.setValueAt(rs.getString(3), n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablaregistrotecnico1() {
        this.sqlregistrotecnico1 = "SELECT `Id` , `Nbre` , `Fecha`FROM `baseserver`.`m_tiporegistrotecnico` WHERE Estado ='1';";
        cargarDatosregistrotecnico1(this.sqlregistrotecnico1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridrepuesto1() {
        this.xmodelorepuesto1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Repuesto", "Laboratorio", "Valor"}) { // from class: Mantenimiento.ConfigComplementos.2
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablarepuesto1.setModel(this.xmodelorepuesto1);
        this.tablarepuesto1.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.tablarepuesto1.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.tablarepuesto1.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.tablarepuesto1.getColumnModel().getColumn(3).setPreferredWidth(70);
    }

    public final void cargarDatosrepuesto1(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelorepuesto1.addRow(this.datosrepuesto1);
                this.xmodelorepuesto1.setValueAt(rs.getString(1), n, 0);
                this.xmodelorepuesto1.setValueAt(rs.getString(2), n, 1);
                this.xmodelorepuesto1.setValueAt(rs.getString(3), n, 2);
                this.xmodelorepuesto1.setValueAt(rs.getString(4), n, 3);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablarepuesto() {
        this.sqlrepuesto1 = "SELECT`m_tiporespuesto`.`Id`, `m_tiporespuesto`.`Nbre`, `i_laboratorio`.`Nbre`, `m_tiporespuesto`.`Valor`FROM `baseserver`.`m_tiporespuesto`INNER JOIN `baseserver`.`i_laboratorio` ON (`m_tiporespuesto`.`Id_Laboratorio` = `i_laboratorio`.`Id`)  WHERE `m_tiporespuesto`.`Estado` ='1' ";
        cargarDatosrepuesto1(this.sqlrepuesto1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridnormalidad1() {
        this.xmodelonormalidad1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Valor Normal", "Valor Maximo", "Valor minimo", "U. Medida"}) { // from class: Mantenimiento.ConfigComplementos.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablanormalidad.setModel(this.xmodelonormalidad1);
        this.tablanormalidad.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablanormalidad.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.tablanormalidad.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.tablanormalidad.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.tablanormalidad.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.tablanormalidad.getColumnModel().getColumn(3).setPreferredWidth(70);
    }

    public final void cargarDatosnormalidad1(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelonormalidad1.addRow(this.datosnormalidad1);
                this.xmodelonormalidad1.setValueAt(rs.getString(1), n, 0);
                this.xmodelonormalidad1.setValueAt(rs.getString(2), n, 1);
                this.xmodelonormalidad1.setValueAt(rs.getString(3), n, 2);
                this.xmodelonormalidad1.setValueAt(rs.getString(4), n, 3);
                this.xmodelonormalidad1.setValueAt(rs.getString(5), n, 4);
                this.xmodelonormalidad1.setValueAt(rs.getString(6), n, 5);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablanormalidad() {
        this.sqlnormalidad1 = "SELECT `m_tipovariables`.`Id`,`m_tipovariables`.`Nbre`, `m_tipovariables`.`VNormal`, `m_tipovariables`.`VMinimo`, `m_tipovariables`.`VMaximo`, `i_unidadmedida`.`Nbre`FROM `baseserver`.`m_tipovariables`INNER JOIN `baseserver`.`i_unidadmedida` ON (`m_tipovariables`.`Id_UnidadMedida` = `i_unidadmedida`.`Id`)  WHERE `m_tipovariables`.`Estado` ='1' ;";
        cargarDatosnormalidad1(this.sqlnormalidad1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridproce1() {
        this.xmodeloproce1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimeinto", "Frecuencia"}) { // from class: Mantenimiento.ConfigComplementos.4
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaproce.setModel(this.xmodeloproce1);
        this.tablaproce.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablaproce.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.tablaproce.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    public final void cargarDatosproce1(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodeloproce1.addRow(this.datosproce1);
                this.xmodeloproce1.setValueAt(rs.getString(1), n, 0);
                this.xmodeloproce1.setValueAt(rs.getString(2), n, 1);
                this.xmodeloproce1.setValueAt(rs.getString(3), n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablaproce1() {
        this.sqlproce1 = "SELECT  `m_tipoprocedimientos`.`Id`,`m_tipoprocedimientos`.`Nbre`, `m_tipofrecuencia`.`Nbre`FROM  `baseserver`.`m_tipoprocedimientos`INNER JOIN `baseserver`.`m_tipofrecuencia` ON (`m_tipoprocedimientos`.`Id_Frecuencia` = `m_tipofrecuencia`.`Id`) WHERE `m_tipoprocedimientos`.`Estado` ='1';";
        cargarDatosproce1(this.sqlproce1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridpcomponente1() {
        this.xmodelocomponente1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Componente", "Laboratorio", "# Serie"}) { // from class: Mantenimiento.ConfigComplementos.5
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablacomponente.setModel(this.xmodelocomponente1);
        this.tablacomponente.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablacomponente.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.tablacomponente.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.tablacomponente.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    public final void cargarDatoscomponente1(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelocomponente1.addRow(this.datoscomponente1);
                this.xmodelocomponente1.setValueAt(rs.getString(1), n, 0);
                this.xmodelocomponente1.setValueAt(rs.getString(2), n, 1);
                this.xmodelocomponente1.setValueAt(rs.getString(3), n, 2);
                this.xmodelocomponente1.setValueAt(rs.getString(4), n, 3);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablaponente1() {
        this.sqlcomponente1 = "SELECT`m_tipocomponente`.`Id`,`m_tipocomponente`.`Nbre`, `i_laboratorio`.`Nbre`, `m_tipocomponente`.`Serie`FROM  `baseserver`.`m_tipocomponente`INNER JOIN `baseserver`.`i_laboratorio` ON (`m_tipocomponente`.`Id_Laboratorio` = `i_laboratorio`.`Id`) WHERE `m_tipocomponente`.`Estado` ='1';";
        cargarDatoscomponente1(this.sqlcomponente1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridblafrecuencia() {
        this.xmodelofrecuencia = new DefaultTableModel(new Object[0], new String[]{"Id", "Frecuencia"}) { // from class: Mantenimiento.ConfigComplementos.6
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablafecuencia.setModel(this.xmodelofrecuencia);
        this.tablafecuencia.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablafecuencia.getColumnModel().getColumn(1).setPreferredWidth(70);
    }

    public final void cargarDatosfrecuencia(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelofrecuencia.addRow(this.datosfrecuencia);
                this.xmodelofrecuencia.setValueAt(rs.getString(1), n, 0);
                this.xmodelofrecuencia.setValueAt(rs.getString(2), n, 1);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablablafrecuencia() {
        this.sqlfrecuencia = "SELECT `Id` , `Nbre`FROM `baseserver`.`m_tipofrecuencia` WHERE `m_tipofrecuencia`.`Estado` ='1'";
        cargarDatosfrecuencia(this.sqlfrecuencia);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridpmanual() {
        this.xmodelomanual1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre Manual", "Fecha"}) { // from class: Mantenimiento.ConfigComplementos.7
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablamanual.setModel(this.xmodelomanual1);
        this.tablamanual.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablamanual.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.tablamanual.getColumnModel().getColumn(2).setPreferredWidth(32);
    }

    public final void cargarDatosmanual1(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelomanual1.addRow(this.datosmanual1);
                this.xmodelomanual1.setValueAt(rs.getString(1), n, 0);
                this.xmodelomanual1.setValueAt(rs.getString(2), n, 1);
                this.xmodelomanual1.setValueAt(rs.getString(3), n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablamanual1() {
        this.sqlmanual1 = "SELECT `Id`  , `Nbre` , `Fecha` FROM `baseserver`.`m_tipomanual` WHERE `m_tipomanual`.`Estado` ='1'";
        cargarDatosmanual1(this.sqlmanual1);
    }

    /* JADX WARN: Type inference failed for: r3v131, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v139, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v159, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v186, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v222, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v283, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v83, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane2 = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jTextField3 = new JTextField();
        this.fecha = new JDateChooser();
        this.jPanel11 = new JPanel();
        this.jButton3 = new JButton();
        this.jButton4 = new JButton();
        this.jPanel12 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.tablaregistrotecnico = new JTable();
        this.txtregistro = new JTextField();
        this.jPanel5 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jTextField9 = new JTextField();
        this.jPanel15 = new JPanel();
        this.jButton7 = new JButton();
        this.jButton8 = new JButton();
        this.jPanel16 = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.tablarepuesto1 = new JTable();
        this.txtrepuesto = new JTextField();
        this.combolaboratorio = new JComboBox();
        this.txtvalor = new JTextField();
        this.jPanel4 = new JPanel();
        this.jLabel3 = new JLabel();
        this.jTextField4 = new JTextField();
        this.jPanel13 = new JPanel();
        this.jButton6 = new JButton();
        this.jButton5 = new JButton();
        this.txtserie = new JTextField();
        this.txtnomcomponente = new JTextField();
        this.combomarca = new JComboBox();
        this.jScrollPane3 = new JScrollPane();
        this.tablacomponente = new JTable();
        this.jScrollPane7 = new JScrollPane();
        this.jTable7 = new JTable();
        this.jPanel19 = new JPanel();
        this.jTextField21 = new JTextField();
        this.txtfrecuencia = new JTextField();
        this.jPanel23 = new JPanel();
        this.jButton15 = new JButton();
        this.jButton16 = new JButton();
        this.jScrollPane8 = new JScrollPane();
        this.tablafecuencia = new JTable();
        this.jScrollPane9 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.jPanel7 = new JPanel();
        this.jLabel6 = new JLabel();
        this.jTextField14 = new JTextField();
        this.txtnombre = new JTextField();
        this.txtmax = new JTextField();
        this.txtmin = new JTextField();
        this.jPanel21 = new JPanel();
        this.jScrollPane6 = new JScrollPane();
        this.tablanormalidad = new JTable();
        this.txtnor = new JTextField();
        this.combounidad = new JComboBox();
        this.jButton12 = new JButton();
        this.jButton11 = new JButton();
        this.jPanel6 = new JPanel();
        this.jLabel5 = new JLabel();
        this.jTextField12 = new JTextField();
        this.txtprocedimiento = new JTextField();
        this.jPanel17 = new JPanel();
        this.jButton9 = new JButton();
        this.jButton10 = new JButton();
        this.jPanel18 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.tablaproce = new JTable();
        this.combofrecuencia = new JComboBox();
        this.combotipo = new JComboBox();
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.jTextField1 = new JTextField();
        this.txtmanual = new JTextField();
        this.jPanel9 = new JPanel();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jPanel10 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.tablamanual = new JTable();
        this.jLabel1 = new JLabel();
        setBackground(new Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONFIGURAR COMPLEMENTOS");
        setEnabled(false);
        setFocusCycleRoot(false);
        setFocusable(false);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jTabbedPane2.setForeground(new Color(0, 102, 0));
        this.jTabbedPane2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setFont(new Font("Arial", 0, 18));
        this.jLabel2.setForeground(new Color(255, 0, 0));
        this.jLabel2.setText("Ingresar Registros Tecnicos");
        this.jTextField3.setFont(new Font("Arial", 1, 12));
        this.jTextField3.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12)));
        this.jTextField3.setEnabled(false);
        this.fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.fecha.setFont(new Font("Arial", 1, 12));
        this.jPanel11.setBorder(new SoftBevelBorder(0));
        this.jPanel11.setLayout((LayoutManager) null);
        this.jButton3.setFont(new Font("Arial", 1, 12));
        this.jButton3.setText("Agregar");
        this.jButton3.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.8
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel11.add(this.jButton3);
        this.jButton3.setBounds(10, 10, 90, 29);
        this.jButton4.setFont(new Font("Arial", 1, 12));
        this.jButton4.setText("Dar de Baja");
        this.jButton4.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.9
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton4ActionPerformed(evt);
            }
        });
        this.jPanel11.add(this.jButton4);
        this.jButton4.setBounds(110, 10, 107, 29);
        this.jPanel12.setBorder(BorderFactory.createEtchedBorder());
        this.jScrollPane2.setFont(new Font("Arial", 1, 12));
        this.tablaregistrotecnico.setFont(new Font("Arial", 1, 12));
        this.tablaregistrotecnico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaregistrotecnico.setRowHeight(25);
        this.tablaregistrotecnico.setSelectionBackground(new Color(255, 255, 255));
        this.tablaregistrotecnico.setSelectionForeground(new Color(255, 0, 0));
        this.tablaregistrotecnico.setSelectionMode(0);
        this.tablaregistrotecnico.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.ConfigComplementos.10
            public void mouseClicked(MouseEvent evt) {
                ConfigComplementos.this.tablaregistrotecnicoMouseClicked(evt);
            }
        });
        GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
        this.jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 456, 32767).addContainerGap()).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.tablaregistrotecnico, -2, 454, -2).addGap(0, 0, 32767))));
        jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 236, 32767).addContainerGap()).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.tablaregistrotecnico, -2, -1, -2).addGap(0, 0, 32767))));
        this.txtregistro.setFont(new Font("Arial", 1, 12));
        this.txtregistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtregistro.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.11
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtregistroActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTextField3, -2, 80, -2).addComponent(this.txtregistro, -2, 323, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel11, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.fecha, GroupLayout.Alignment.LEADING, -1, 236, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel12, -2, -1, -2).addGap(24, 24, 24)).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel2).addGap(145, 145, 145)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jTextField3, -2, 40, -2).addGap(18, 18, 18).addComponent(this.txtregistro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.fecha, -2, -1, -2).addGap(33, 33, 33).addComponent(this.jPanel11, -2, 45, -2)).addGroup(jPanel3Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel12, -2, -1, -2))).addContainerGap(17, 32767)));
        this.jTabbedPane2.addTab("REG. TECNICOS", this.jPanel3);
        this.jPanel5.setLayout((LayoutManager) null);
        this.jLabel4.setFont(new Font("Arial", 0, 18));
        this.jLabel4.setForeground(new Color(255, 0, 51));
        this.jLabel4.setText("Ingresar Repuestos");
        this.jPanel5.add(this.jLabel4);
        this.jLabel4.setBounds(540, 0, 156, 22);
        this.jTextField9.setFont(new Font("Arial", 1, 12));
        this.jTextField9.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12)));
        this.jTextField9.setEnabled(false);
        this.jPanel5.add(this.jTextField9);
        this.jTextField9.setBounds(10, 10, 80, 40);
        this.jPanel15.setBorder(new SoftBevelBorder(0));
        this.jPanel15.setLayout((LayoutManager) null);
        this.jButton7.setFont(new Font("Arial", 1, 12));
        this.jButton7.setText("Agregar");
        this.jButton7.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.12
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton7ActionPerformed(evt);
            }
        });
        this.jPanel15.add(this.jButton7);
        this.jButton7.setBounds(10, 10, 90, 29);
        this.jButton8.setFont(new Font("Arial", 1, 12));
        this.jButton8.setText("Dar de Baja");
        this.jButton8.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.13
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton8ActionPerformed(evt);
            }
        });
        this.jPanel15.add(this.jButton8);
        this.jButton8.setBounds(110, 10, 107, 29);
        this.jPanel5.add(this.jPanel15);
        this.jPanel15.setBounds(10, 250, 230, 45);
        this.jPanel16.setBorder(BorderFactory.createEtchedBorder());
        this.jScrollPane4.setFont(new Font("Arial", 1, 12));
        this.tablarepuesto1.setFont(new Font("Arial", 1, 12));
        this.tablarepuesto1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablarepuesto1.setRowHeight(25);
        this.tablarepuesto1.setSelectionBackground(new Color(255, 255, 255));
        this.tablarepuesto1.setSelectionForeground(new Color(255, 0, 0));
        this.tablarepuesto1.setSelectionMode(0);
        this.tablarepuesto1.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.ConfigComplementos.14
            public void mouseClicked(MouseEvent evt) {
                ConfigComplementos.this.tablarepuesto1MouseClicked(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.tablarepuesto1);
        GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
        this.jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -1, 476, 32767).addContainerGap()));
        jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -1, 234, 32767).addContainerGap()));
        this.jPanel5.add(this.jPanel16);
        this.jPanel16.setBounds(340, 30, 500, 260);
        this.txtrepuesto.setFont(new Font("Arial", 1, 12));
        this.txtrepuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Repuesto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtrepuesto.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.15
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtrepuestoActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.txtrepuesto);
        this.txtrepuesto.setBounds(10, 60, 320, 41);
        this.combolaboratorio.setFont(new Font("Arial", 1, 12));
        this.combolaboratorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Marca", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel5.add(this.combolaboratorio);
        this.combolaboratorio.setBounds(10, 120, 320, 50);
        this.txtvalor.setFont(new Font("Arial", 1, 12));
        this.txtvalor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Repuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtvalor.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.16
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtvalorActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.txtvalor);
        this.txtvalor.setBounds(10, 180, 230, 41);
        this.jTabbedPane2.addTab("REPUESTOS", this.jPanel5);
        this.jPanel4.setLayout((LayoutManager) null);
        this.jLabel3.setFont(new Font("Arial", 0, 18));
        this.jLabel3.setForeground(new Color(255, 0, 0));
        this.jLabel3.setText("Ingresar Componentes");
        this.jPanel4.add(this.jLabel3);
        this.jLabel3.setBounds(320, 20, 181, 22);
        this.jTextField4.setFont(new Font("Arial", 1, 12));
        this.jTextField4.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.jTextField4.setEnabled(false);
        this.jPanel4.add(this.jTextField4);
        this.jTextField4.setBounds(10, 11, 80, 40);
        this.jPanel13.setBorder(new SoftBevelBorder(0));
        this.jPanel13.setLayout((LayoutManager) null);
        this.jButton6.setFont(new Font("Arial", 1, 12));
        this.jButton6.setText("Dar de Baja");
        this.jButton6.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.17
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton6ActionPerformed(evt);
            }
        });
        this.jPanel13.add(this.jButton6);
        this.jButton6.setBounds(110, 10, 107, 29);
        this.jButton5.setFont(new Font("Arial", 1, 12));
        this.jButton5.setText("Agregar");
        this.jButton5.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.18
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton5ActionPerformed(evt);
            }
        });
        this.jPanel13.add(this.jButton5);
        this.jButton5.setBounds(10, 10, 90, 29);
        this.jPanel4.add(this.jPanel13);
        this.jPanel13.setBounds(40, 190, 230, 45);
        this.txtserie.setFont(new Font("Arial", 1, 12));
        this.txtserie.setBorder(BorderFactory.createTitledBorder((Border) null, "Serie", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtserie.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.19
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtserieActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.txtserie);
        this.txtserie.setBounds(180, 120, 110, 41);
        this.txtnomcomponente.setFont(new Font("Arial", 1, 12));
        this.txtnomcomponente.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Componente", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtnomcomponente.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.20
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtnomcomponenteActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.txtnomcomponente);
        this.txtnomcomponente.setBounds(10, 60, 280, 41);
        this.combomarca.setFont(new Font("Arial", 1, 12));
        this.combomarca.setBorder(BorderFactory.createTitledBorder((Border) null, "Marca", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel4.add(this.combomarca);
        this.combomarca.setBounds(10, 120, 150, 43);
        this.jScrollPane3.setFont(new Font("Arial", 1, 12));
        this.tablacomponente.setAutoCreateRowSorter(true);
        this.tablacomponente.setFont(new Font("Arial", 1, 12));
        this.tablacomponente.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.tablacomponente.setRowHeight(25);
        this.tablacomponente.setSelectionBackground(new Color(255, 255, 255));
        this.tablacomponente.setSelectionForeground(new Color(255, 0, 0));
        this.tablacomponente.setSelectionMode(0);
        this.tablacomponente.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.ConfigComplementos.21
            public void mouseClicked(MouseEvent evt) {
                ConfigComplementos.this.tablacomponenteMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.tablacomponente);
        this.jPanel4.add(this.jScrollPane3);
        this.jScrollPane3.setBounds(330, 60, 490, 240);
        this.jTable7.setFont(new Font("Arial", 1, 11));
        this.jTable7.setForeground(new Color(0, 0, 255));
        this.jTable7.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0]}, new String[0]));
        this.jTable7.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.ConfigComplementos.22
            public void mouseClicked(MouseEvent evt) {
                ConfigComplementos.this.jTable7MouseClicked(evt);
            }
        });
        this.jScrollPane7.setViewportView(this.jTable7);
        this.jPanel4.add(this.jScrollPane7);
        this.jScrollPane7.setBounds(320, 45, 510, 260);
        this.jTabbedPane2.addTab("COMPONENTES", this.jPanel4);
        this.jPanel19.setLayout(new AbsoluteLayout());
        this.jTextField21.setFont(new Font("Arial", 1, 12));
        this.jTextField21.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jTextField21.setEnabled(false);
        this.jPanel19.add(this.jTextField21, new AbsoluteConstraints(10, 100, 80, 40));
        this.txtfrecuencia.setFont(new Font("Arial", 1, 12));
        this.txtfrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtfrecuencia.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.23
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtfrecuenciaActionPerformed(evt);
            }
        });
        this.jPanel19.add(this.txtfrecuencia, new AbsoluteConstraints(10, 150, 219, -1));
        this.jPanel23.setBorder(new SoftBevelBorder(0));
        this.jPanel23.setLayout((LayoutManager) null);
        this.jButton15.setFont(new Font("Arial", 1, 12));
        this.jButton15.setText("Agregar");
        this.jButton15.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.24
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton15ActionPerformed(evt);
            }
        });
        this.jPanel23.add(this.jButton15);
        this.jButton15.setBounds(10, 10, 90, 29);
        this.jButton16.setFont(new Font("Arial", 1, 12));
        this.jButton16.setText("Dar de Baja");
        this.jButton16.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.25
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton16ActionPerformed(evt);
            }
        });
        this.jPanel23.add(this.jButton16);
        this.jButton16.setBounds(110, 10, 120, 29);
        this.jPanel19.add(this.jPanel23, new AbsoluteConstraints(10, 210, 244, 45));
        this.tablafecuencia.setFont(new Font("Arial", 1, 12));
        this.tablafecuencia.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablafecuencia.setRowHeight(25);
        this.tablafecuencia.setSelectionBackground(new Color(255, 255, 255));
        this.tablafecuencia.setSelectionForeground(new Color(255, 0, 0));
        this.tablafecuencia.setSelectionMode(0);
        this.tablafecuencia.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.ConfigComplementos.26
            public void mouseClicked(MouseEvent evt) {
                ConfigComplementos.this.tablafecuenciaMouseClicked(evt);
            }
        });
        this.jScrollPane8.setViewportView(this.tablafecuencia);
        this.jPanel19.add(this.jScrollPane8, new AbsoluteConstraints(290, 20, 364, 231));
        this.jTextArea1.setColumns(3);
        this.jTextArea1.setFont(new Font("Arial", 1, 12));
        this.jTextArea1.setRows(3);
        this.jTextArea1.setText("Ingrese Las Frecuencias\nCon las que se Realizaran \nlos Mantenimeintos ");
        this.jTextArea1.setAutoscrolls(false);
        this.jTextArea1.setEnabled(false);
        this.jTextArea1.setFocusable(false);
        this.jScrollPane9.setViewportView(this.jTextArea1);
        this.jPanel19.add(this.jScrollPane9, new AbsoluteConstraints(10, 10, 244, 84));
        this.jTabbedPane2.addTab("FRECUENCIA PROC.", this.jPanel19);
        this.jPanel7.setLayout((LayoutManager) null);
        this.jLabel6.setFont(new Font("Arial", 0, 18));
        this.jLabel6.setForeground(new Color(255, 0, 0));
        this.jLabel6.setText("Ingresar Tipo Normalidad");
        this.jPanel7.add(this.jLabel6);
        this.jLabel6.setBounds(310, 0, 202, 22);
        this.jTextField14.setFont(new Font("Arial", 1, 12));
        this.jTextField14.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jTextField14.setEnabled(false);
        this.jPanel7.add(this.jTextField14);
        this.jTextField14.setBounds(10, 0, 80, 40);
        this.txtnombre.setFont(new Font("Arial", 1, 12));
        this.txtnombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtnombre.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.27
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtnombreActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.txtnombre);
        this.txtnombre.setBounds(10, 40, 310, 50);
        this.txtmax.setFont(new Font("Arial", 1, 12));
        this.txtmax.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Máximo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtmax.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.28
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtmaxActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.txtmax);
        this.txtmax.setBounds(10, 100, 140, 41);
        this.txtmin.setFont(new Font("Arial", 1, 12));
        this.txtmin.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Mínimo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtmin.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.29
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtminActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.txtmin);
        this.txtmin.setBounds(160, 100, 160, 41);
        this.jPanel21.setBorder(BorderFactory.createEtchedBorder());
        this.tablanormalidad.setFont(new Font("Arial", 1, 12));
        this.tablanormalidad.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablanormalidad.setRowHeight(25);
        this.tablanormalidad.setSelectionBackground(new Color(255, 255, 255));
        this.tablanormalidad.setSelectionForeground(Color.red);
        this.tablanormalidad.setSelectionMode(0);
        this.tablanormalidad.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.ConfigComplementos.30
            public void mouseClicked(MouseEvent evt) {
                ConfigComplementos.this.tablanormalidadMouseClicked(evt);
            }
        });
        this.jScrollPane6.setViewportView(this.tablanormalidad);
        GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
        this.jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel21Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane6, -1, 496, 32767)));
        jPanel21Layout.setVerticalGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel21Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane6, -1, 244, 32767).addContainerGap()));
        this.jPanel7.add(this.jPanel21);
        this.jPanel21.setBounds(330, 30, 510, 270);
        this.txtnor.setFont(new Font("Arial", 1, 12));
        this.txtnor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Normal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtnor.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.31
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtnorActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.txtnor);
        this.txtnor.setBounds(10, 160, 190, 41);
        this.combounidad.setFont(new Font("Arial", 1, 12));
        this.combounidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad de Medida", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel7.add(this.combounidad);
        this.combounidad.setBounds(200, 160, 120, 43);
        this.jButton12.setFont(new Font("Arial", 1, 12));
        this.jButton12.setText("Dar de Baja");
        this.jButton12.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.32
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton12ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton12);
        this.jButton12.setBounds(160, 230, 140, 40);
        this.jButton11.setFont(new Font("Arial", 1, 12));
        this.jButton11.setText("Agregar");
        this.jButton11.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.33
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton11ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jButton11);
        this.jButton11.setBounds(20, 230, 130, 40);
        this.jTabbedPane2.addTab("TIPO NORMALIDADES", this.jPanel7);
        this.jLabel5.setFont(new Font("Arial", 0, 18));
        this.jLabel5.setForeground(Color.red);
        this.jLabel5.setText("Ingresar Tipo Procedimientos");
        this.jTextField12.setFont(new Font("Arial", 1, 12));
        this.jTextField12.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jTextField12.setEnabled(false);
        this.txtprocedimiento.setFont(new Font("Arial", 1, 12));
        this.txtprocedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Procedimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtprocedimiento.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.34
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtprocedimientoActionPerformed(evt);
            }
        });
        this.jPanel17.setBorder(new SoftBevelBorder(0));
        this.jPanel17.setLayout((LayoutManager) null);
        this.jButton9.setFont(new Font("Arial", 1, 12));
        this.jButton9.setText("Agregar");
        this.jButton9.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.35
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton9ActionPerformed(evt);
            }
        });
        this.jPanel17.add(this.jButton9);
        this.jButton9.setBounds(10, 10, 130, 29);
        this.jButton10.setFont(new Font("Arial", 1, 12));
        this.jButton10.setText("Dar de Baja");
        this.jButton10.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.36
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton10ActionPerformed(evt);
            }
        });
        this.jPanel17.add(this.jButton10);
        this.jButton10.setBounds(160, 10, 110, 29);
        this.jPanel18.setBorder(BorderFactory.createEtchedBorder());
        this.tablaproce.setFont(new Font("Arial", 1, 12));
        this.tablaproce.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaproce.setRowHeight(25);
        this.tablaproce.setSelectionBackground(new Color(255, 255, 255));
        this.tablaproce.setSelectionForeground(new Color(255, 0, 0));
        this.tablaproce.setSelectionMode(0);
        this.tablaproce.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.ConfigComplementos.37
            public void mouseClicked(MouseEvent evt) {
                ConfigComplementos.this.tablaproceMouseClicked(evt);
            }
        });
        this.jScrollPane5.setViewportView(this.tablaproce);
        GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
        this.jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -1, 406, 32767).addContainerGap()));
        jPanel18Layout.setVerticalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -1, 221, 32767).addContainerGap()));
        this.combofrecuencia.setFont(new Font("Arial", 1, 12));
        this.combofrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.combotipo.setFont(new Font("Arial", 1, 12));
        this.combotipo.setModel(new DefaultComboBoxModel(new String[]{"Mantenimiento", "Calibracion"}));
        this.combotipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jTextField12, -2, 80, -2).addComponent(this.txtprocedimiento, -1, 289, 32767)).addComponent(this.combotipo, GroupLayout.Alignment.TRAILING, 0, -1, 32767).addComponent(this.combofrecuencia, 0, -1, 32767).addComponent(this.jPanel17, -2, 289, -2)).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.jLabel5)).addGroup(jPanel6Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jPanel18, -2, -1, -2))).addGap(100, 100, 100)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel18, -1, -1, 32767)).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jTextField12, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtprocedimiento, -2, -1, -2).addGap(18, 18, 18).addComponent(this.combofrecuencia, -2, -1, -2).addGap(15, 15, 15).addComponent(this.combotipo, -2, 44, -2).addGap(18, 18, 18).addComponent(this.jPanel17, -2, 45, -2))).addContainerGap(21, 32767)));
        this.jTabbedPane2.addTab("PROCEDIMIENTO", this.jPanel6);
        this.jPanel2.setLayout((LayoutManager) null);
        this.jPanel1.setBorder(new SoftBevelBorder(0));
        this.jTextField1.setFont(new Font("Arial", 1, 12));
        this.jTextField1.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jTextField1.setEnabled(false);
        this.txtmanual.setFont(new Font("Arial", 1, 12));
        this.txtmanual.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo manual", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtmanual.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.38
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.txtmanualActionPerformed(evt);
            }
        });
        this.jPanel9.setBorder(new SoftBevelBorder(0));
        this.jPanel9.setLayout((LayoutManager) null);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText("Agregar");
        this.jButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.39
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel9.add(this.jButton1);
        this.jButton1.setBounds(10, 10, 80, 29);
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setText("Dar de Baja");
        this.jButton2.addActionListener(new ActionListener() { // from class: Mantenimiento.ConfigComplementos.40
            public void actionPerformed(ActionEvent evt) {
                ConfigComplementos.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel9.add(this.jButton2);
        this.jButton2.setBounds(103, 10, 97, 29);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel9, -2, 210, -2).addComponent(this.txtmanual, -2, 219, -2).addComponent(this.jTextField1, -2, 80, -2)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(21, 32767).addComponent(this.jTextField1, -2, 40, -2).addGap(18, 18, 18).addComponent(this.txtmanual, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel9, -2, 45, -2).addContainerGap()));
        this.jPanel2.add(this.jPanel1);
        this.jPanel1.setBounds(10, 40, 240, 200);
        this.jPanel10.setBorder(BorderFactory.createEtchedBorder());
        this.tablamanual.setFont(new Font("Arial", 1, 12));
        this.tablamanual.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablamanual.setRowHeight(25);
        this.tablamanual.setSelectionBackground(new Color(255, 255, 255));
        this.tablamanual.setSelectionForeground(new Color(255, 0, 0));
        this.tablamanual.setSelectionMode(0);
        this.tablamanual.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.ConfigComplementos.41
            public void mouseClicked(MouseEvent evt) {
                ConfigComplementos.this.tablamanualMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.tablamanual);
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 376, 32767).addContainerGap()));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 184, 32767).addContainerGap()));
        this.jPanel2.add(this.jPanel10);
        this.jPanel10.setBounds(260, 40, 400, 210);
        this.jLabel1.setFont(new Font("Arial", 0, 18));
        this.jLabel1.setForeground(new Color(255, 0, 0));
        this.jLabel1.setText("Ingresar tipo Manuales");
        this.jPanel2.add(this.jLabel1);
        this.jLabel1.setBounds(320, 10, 182, 22);
        this.jTabbedPane2.addTab("MANUALES", this.jPanel2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane2, -2, 852, -2).addContainerGap(35, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jTabbedPane2, -2, 341, -2).addContainerGap(47, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnomcomponenteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtserieActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton6ActionPerformed(ActionEvent evt) {
        if (this.jTextField4.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipocomponente` SET `Estado`='0' WHERE `m_tipocomponente`.`Id`='" + this.jTextField4.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.jTextField4.setText("");
                this.txtnomcomponente.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridpcomponente1();
                llenatablaponente1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton5ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql01 = "insert into m_tipocomponente (Nbre, Id_Laboratorio, Serie, Estado, Usuario, Fecha) values('" + this.txtnomcomponente.getText() + "','" + this.xidmarca1[this.combomarca.getSelectedIndex()] + "','" + this.txtserie.getText() + "',1,'" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            System.out.print(sql01);
            this.xconsulta5.ejecutarSQL(sql01);
            this.xconsulta5.cerrarConexionBd();
            this.txtnomcomponente.setText("");
            this.combomarca.setSelectedItem("");
            this.txtserie.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        crearGridregistrotecnico1();
        llenatablaregistrotecnico1();
        crearGridrepuesto1();
        llenatablarepuesto();
        crearGridproce1();
        llenatablaproce1();
        crearGridnormalidad1();
        llenatablanormalidad();
        crearGridblafrecuencia();
        llenatablablafrecuencia();
        crearGridpcomponente1();
        llenatablaponente1();
        crearGridpmanual();
        llenatablamanual1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton16ActionPerformed(ActionEvent evt) {
        if (this.jTextField21.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipofrecuencia` SET `Estado`='0' WHERE `m_tipofrecuencia`.`Id`='" + this.jTextField21.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.jTextField21.setText("");
                this.txtfrecuencia.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridblafrecuencia();
                llenatablablafrecuencia();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton15ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql5 = "insert into m_tipofrecuencia (Nbre, Estado, UsuarioS, Fecha) values('" + this.txtfrecuencia.getText() + "','1','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta1.ejecutarSQL(sql5);
            this.xconsulta1.cerrarConexionBd();
            this.txtfrecuencia.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        crearGridregistrotecnico1();
        llenatablaregistrotecnico1();
        crearGridrepuesto1();
        llenatablarepuesto();
        crearGridproce1();
        llenatablaproce1();
        crearGridnormalidad1();
        llenatablanormalidad();
        crearGridblafrecuencia();
        llenatablablafrecuencia();
        crearGridpcomponente1();
        llenatablaponente1();
        crearGridpmanual();
        llenatablamanual1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtfrecuenciaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton11ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql4 = "insert into m_tipovariables (Nbre, VNormal, VMinimo, VMaximo, Id_UnidadMedida, Estado, UsuarioS, Fecha) values('" + this.txtnombre.getText() + "','" + this.txtnor.getText() + "','" + this.txtmin.getText() + "','" + this.txtmax.getText() + "', '" + this.xidunidad[this.combounidad.getSelectedIndex()] + "', '1', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta1.ejecutarSQL(sql4);
            this.xconsulta1.cerrarConexionBd();
            this.txtnombre.setText("");
            this.txtmax.setText("");
            this.txtnor.setText("");
            this.txtmin.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        crearGridregistrotecnico1();
        llenatablaregistrotecnico1();
        crearGridrepuesto1();
        llenatablarepuesto();
        crearGridproce1();
        llenatablaproce1();
        crearGridnormalidad1();
        llenatablanormalidad();
        crearGridblafrecuencia();
        llenatablablafrecuencia();
        crearGridpcomponente1();
        llenatablaponente1();
        crearGridpmanual();
        llenatablamanual1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton12ActionPerformed(ActionEvent evt) {
        if (this.jTextField14.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipovariables` SET `Estado`='0' WHERE `m_tipovariables`.`Id`='" + this.jTextField14.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtnombre.setText("");
                this.jTextField14.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridnormalidad1();
                llenatablanormalidad();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtminActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtmaxActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton10ActionPerformed(ActionEvent evt) {
        if (this.jTextField12.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipoprocedimientos` SET `Estado`='0' WHERE `m_tipoprocedimientos`.`Id`='" + this.jTextField12.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtprocedimiento.setText("");
                this.jTextField12.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridproce1();
                llenatablaproce1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton9ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql3 = "insert into m_tipoprocedimientos (Nbre, Id_Frecuencia, tipo, Estado, UsuarioS, Fecha) values('" + this.txtprocedimiento.getText() + "','" + this.xidfrecuencia[this.combofrecuencia.getSelectedIndex()] + "','" + this.combotipo.getSelectedItem() + "','1', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            System.out.print(sql3);
            this.xconsulta1.ejecutarSQL(sql3);
            this.xconsulta1.cerrarConexionBd();
            this.txtprocedimiento.setText("");
            this.combofrecuencia.setSelectedItem("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        crearGridregistrotecnico1();
        llenatablaregistrotecnico1();
        crearGridrepuesto1();
        llenatablarepuesto();
        crearGridproce1();
        llenatablaproce1();
        crearGridnormalidad1();
        llenatablanormalidad();
        crearGridblafrecuencia();
        llenatablablafrecuencia();
        crearGridpcomponente1();
        llenatablaponente1();
        crearGridpmanual();
        llenatablamanual1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtprocedimientoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtrepuestoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton8ActionPerformed(ActionEvent evt) {
        if (this.jTextField9.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tiporespuesto` SET `Estado`='0' WHERE `m_tiporespuesto`.`Id`='" + this.jTextField9.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtrepuesto.setText("");
                this.jTextField9.setText("");
                this.combolaboratorio.setSelectedItem("");
                this.txtvalor.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridrepuesto1();
                llenatablarepuesto();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton7ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql111 = "insert into m_tiporespuesto (Nbre, Id_Laboratorio, Valor, Estado, UsuarioS, Fecha) values('" + this.txtrepuesto.getText() + "','" + this.xidmarca[this.combolaboratorio.getSelectedIndex()] + "','" + this.txtvalor.getText() + "','1', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql111);
            this.xconsulta.cerrarConexionBd();
            this.txtrepuesto.setText("");
            this.combolaboratorio.setSelectedItem("");
            this.txtvalor.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        crearGridregistrotecnico1();
        llenatablaregistrotecnico1();
        crearGridrepuesto1();
        llenatablarepuesto();
        crearGridproce1();
        llenatablaproce1();
        crearGridnormalidad1();
        llenatablanormalidad();
        crearGridblafrecuencia();
        llenatablablafrecuencia();
        crearGridpcomponente1();
        llenatablaponente1();
        crearGridpmanual();
        llenatablamanual1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtregistroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton4ActionPerformed(ActionEvent evt) {
        if (this.jTextField3.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tiporegistrotecnico` SET `Estado`='0' WHERE `m_tiporegistrotecnico`.`Id`='" + this.jTextField3.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtregistro.setText("");
                this.jTextField3.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridregistrotecnico1();
                llenatablaregistrotecnico1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton3ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            new Metodos();
            String sql8 = "insert into m_tiporegistrotecnico (Nbre, Estado, UsuarioS, Fecha) values('" + this.txtregistro.getText() + "','1','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.metodos.formatoAMDH24.format(this.fecha.getDate()) + "')";
            this.xconsulta.ejecutarSQL(sql8);
            this.xconsulta.cerrarConexionBd();
            this.txtregistro.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        crearGridregistrotecnico1();
        llenatablaregistrotecnico1();
        crearGridrepuesto1();
        llenatablarepuesto();
        crearGridproce1();
        llenatablaproce1();
        crearGridnormalidad1();
        llenatablanormalidad();
        crearGridblafrecuencia();
        llenatablablafrecuencia();
        crearGridpcomponente1();
        llenatablaponente1();
        crearGridpmanual();
        llenatablamanual1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTable7MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (this.jTextField1.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipomanual` SET `Estado`='0' WHERE `m_tipomanual`.`Id`='" + this.jTextField1.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtmanual.setText("");
                this.jTextField1.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridpmanual();
                llenatablamanual1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            new Metodos();
            String sql08 = "insert into m_tipomanual (Nbre, Estado, UsuarioS, Fecha) values('" + this.txtmanual.getText() + "','1','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.metodos.formatoAMDH24.format(this.fecha.getDate()) + "')";
            this.xconsulta.ejecutarSQL(sql08);
            this.xconsulta.cerrarConexionBd();
            this.txtmanual.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        crearGridregistrotecnico1();
        llenatablaregistrotecnico1();
        crearGridrepuesto1();
        llenatablarepuesto();
        crearGridproce1();
        llenatablaproce1();
        crearGridnormalidad1();
        llenatablanormalidad();
        crearGridblafrecuencia();
        llenatablablafrecuencia();
        crearGridpcomponente1();
        llenatablaponente1();
        crearGridpmanual();
        llenatablamanual1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtmanualActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtvalorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaregistrotecnicoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablaregistrotecnico.getSelectedRow() != -1) {
            this.jTextField3.setText(this.xmodeloregistrotecnico1.getValueAt(this.tablaregistrotecnico.getSelectedRow(), 0).toString());
            this.txtregistro.setText(this.xmodeloregistrotecnico1.getValueAt(this.tablaregistrotecnico.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablarepuesto1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablarepuesto1.getSelectedRow() != -1) {
            this.jTextField9.setText(this.xmodelorepuesto1.getValueAt(this.tablarepuesto1.getSelectedRow(), 0).toString());
            this.txtrepuesto.setText(this.xmodelorepuesto1.getValueAt(this.tablarepuesto1.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablacomponenteMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablacomponente.getSelectedRow() != -1) {
            this.jTextField4.setText(this.xmodelocomponente1.getValueAt(this.tablacomponente.getSelectedRow(), 0).toString());
            this.txtnomcomponente.setText(this.xmodelocomponente1.getValueAt(this.tablacomponente.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablafecuenciaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablafecuencia.getSelectedRow() != -1) {
            this.jTextField21.setText(this.xmodelofrecuencia.getValueAt(this.tablafecuencia.getSelectedRow(), 0).toString());
            this.txtfrecuencia.setText(this.xmodelofrecuencia.getValueAt(this.tablafecuencia.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablanormalidadMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablanormalidad.getSelectedRow() != -1) {
            this.jTextField14.setText(this.xmodelonormalidad1.getValueAt(this.tablanormalidad.getSelectedRow(), 0).toString());
            this.txtnombre.setText(this.xmodelonormalidad1.getValueAt(this.tablanormalidad.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaproceMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablaproce.getSelectedRow() != -1) {
            this.jTextField12.setText(this.xmodeloproce1.getValueAt(this.tablaproce.getSelectedRow(), 0).toString());
            this.txtprocedimiento.setText(this.xmodeloproce1.getValueAt(this.tablaproce.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablamanualMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablamanual.getSelectedRow() != -1) {
            this.jTextField1.setText(this.xmodelomanual1.getValueAt(this.tablamanual.getSelectedRow(), 0).toString());
            this.txtmanual.setText(this.xmodelomanual1.getValueAt(this.tablamanual.getSelectedRow(), 1).toString());
        }
    }
}
