package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/JIFConfigurar.class */
public class JIFConfigurar extends JInternalFrame {
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
    public String sqlcomponente;
    public String sqlregistrotecnico;
    public String ruta;
    public String dato1;
    public String dato2;
    public claseMantenimiento Cmantenimiento;
    public String sql1;
    public String sql2;
    public String util;
    public Integer edad;
    private JButton BtnSeguimiento1;
    private JButton Calibra;
    private JTabbedPane Datosconfiguraciones;
    private JRadioButton Dos;
    private JInternalFrame Equipos;
    private JTextField JTFRuta;
    private JTextField JTFRuta1;
    private JRadioButton Rbnombre;
    private JRadioButton Rbproveedor;
    private JRadioButton Rbserie;
    private JRadioButton Rbunidad;
    private JRadioButton Tres;
    private JRadioButton Uno;
    private JSpinner Vida;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private JComboBox combocalibracion;
    private JComboBox combocentrocosto;
    private JComboBox combocomponentes;
    private JComboBox combofrecuencia;
    private JComboBox combomanual;
    private JComboBox combomarca;
    private JComboBox combomarcacomp;
    private JComboBox combonormalidad;
    private JComboBox comboprocedimiento;
    private JComboBox comboproveedor;
    private JComboBox comborepuesto;
    private JComboBox combotiporegistro;
    private JComboBox combotiporiesgo;
    private JPanel datosequipo;
    private JDateChooser fecharegistro;
    private JButton jButton1;
    private JButton jButton11;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JDateChooser jDateChooser1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel13;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel19;
    private JPanel jPanel2;
    private JPanel jPanel20;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane10;
    private JScrollPane jScrollPane11;
    private JScrollPane jScrollPane12;
    private JScrollPane jScrollPane13;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JScrollPane jScrollPane9;
    private JTextArea jTextField9;
    private JTable tablacomponente;
    private JTable tablaequipos;
    private JTable tablamanual;
    private JTable tablanormalidad;
    private JTable tablaproce;
    private JTable tablaproce1;
    private JTable tablaregistrotecnico;
    private JTable tablarepuesto;
    private JTextField txtDato;
    private JTextField txtcodigo;
    private JTextArea txtdato;
    private JTextField txtdatos2;
    private JTextField txtdatos3;
    private JTextArea txtdatos4;
    private JTextArea txtinfo;
    private JTextField txtinvima;
    private JTextField txtmax;
    private JTextField txtmin;
    private JTextField txtmodelo;
    private JTextField txtnombre;
    private JTextField txtnor;
    private JTextArea txtobservacion;
    private JTextField txtpermisocomercial;
    private JTextField txtserie;
    private JTextField txtunidad;
    private JTextField txtutil;
    private JTextField txtvalor;
    private JTextField txtvalor1;
    private JTextField txtvalorcom;
    private JTextField valor;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta5 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta6 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta7 = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JIFConfigurar(claseMantenimiento Cmantenimiento) {
        this.lleno = false;
        this.Cmantenimiento = Cmantenimiento;
        initComponents();
        this.fecharegistro.setDate(this.metodos.getFechaActual());
        this.jDateChooser1.setDate(this.metodos.getFechaActual());
        this.sql = "SELECT `m_tipocomponente`.`Id` , `m_tipocomponente`.`Nbre`FROM `m_tipocomponente` WHERE (`m_tipocomponente`.`Estado` =1) ORDER BY `m_tipocomponente`.`Nbre` ASC";
        this.sql1 = "SELECT `m_tipovariables`.`Id`, CONCAT(`m_tipovariables`.`Nbre` ,' ',`m_tipovariables`.`VNormal` ,' ',`m_tipovariables`.`VMinimo`,' ',`m_tipovariables`.`VMaximo` ) AS nOMBRE,`m_tipovariables`.`VNormal` ,`m_tipovariables`.`VMinimo`,`m_tipovariables`.`VMaximo`, `i_unidadmedida`.`Nbre` FROM `m_tipovariables` INNER JOIN `i_unidadmedida` ON (`m_tipovariables`.`Id_UnidadMedida` = `i_unidadmedida`.`Id`) ORDER BY `m_tipovariables`.`Nbre` ASC";
        this.sql2 = "SELECT `m_tipoprocedimientos`.`Id` , concat(`m_tipoprocedimientos`.`Nbre`  , ' ', `m_tipofrecuencia`.`Nbre`), `m_tipofrecuencia`.`Nbre`FROM `m_tipoprocedimientos` INNER JOIN `m_tipofrecuencia`  ON (`m_tipoprocedimientos`.`Id_Frecuencia` = `m_tipofrecuencia`.`Id`)ORDER BY concat(`m_tipoprocedimientos`.`Nbre`  , ' ', `m_tipofrecuencia`.`Nbre`) ASC ;";
        this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC", this.xidarea, this.combocentrocosto);
        this.combocentrocosto.setSelectedIndex(-1);
        this.xidinvima = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_clasificacion WHERE (Estado =0) ORDER BY Nbre ASC", this.xidinvima, this.combotiporiesgo);
        this.combotiporiesgo.setSelectedIndex(-1);
        this.xidprovedor = this.xconsulta.llenarCombo("SELECT Id, RazonSocialCompleta FROM cc_terceros WHERE (Estado =1) ORDER BY RazonSocialCompleta ASC", this.xidprovedor, this.comboproveedor);
        this.comboproveedor.setSelectedIndex(-1);
        this.xidRegtecnico = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM m_tiporegistrotecnico WHERE (Estado =1) ORDER BY Nbre ASC", this.xidRegtecnico, this.combotiporegistro);
        this.combotiporegistro.setSelectedIndex(-1);
        this.xidcomponente = this.xconsulta.llenarComboyLista(this.sql, this.xidcomponente, this.combocomponentes, 2);
        this.combocomponentes.setSelectedIndex(-1);
        this.xidnormalidad = this.xconsulta.llenarComboyLista(this.sql1, this.xidnormalidad, this.combonormalidad, 6);
        this.combonormalidad.setSelectedIndex(-1);
        this.xidfrecuencia = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM m_tipofrecuencia WHERE (Estado =1) ORDER BY Nbre ASC", this.xidfrecuencia, this.combofrecuencia);
        this.combofrecuencia.setSelectedIndex(-1);
        this.xidmanual = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM m_tipomanual WHERE (Estado =1) ORDER BY Nbre ASC", this.xidmanual, this.combomanual);
        this.combomanual.setSelectedIndex(-1);
        this.xidprocedimiento = this.xconsulta.llenarComboyLista(this.sql2, this.xidprocedimiento, this.comboprocedimiento, 3);
        this.comboprocedimiento.setSelectedIndex(-1);
        this.xidcalibracion = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM m_tipoprocedimientos WHERE (tipo = 'Calibracion') ORDER BY Nbre ASC", this.xidcalibracion, this.combocalibracion);
        this.combocalibracion.setSelectedIndex(-1);
        this.xidmarca = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_laboratorio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmarca, this.combomarca);
        this.combomarca.setSelectedIndex(-1);
        this.xidmarca1 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM i_laboratorio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmarca1, this.combomarcacomp);
        this.combomarcacomp.setSelectedIndex(-1);
        this.xidrepuesto = this.xconsulta.llenarCombo("SELECT  m_tiporespuesto.Id, CONCAT(m_tiporespuesto.Nbre,' ' ,i_laboratorio.Nbre) FROM m_tiporespuesto INNER JOIN i_laboratorio  ON (m_tiporespuesto.Id_Laboratorio = i_laboratorio.Id) WHERE (m_tiporespuesto.Estado =1) ORDER BY m_tiporespuesto.Nbre ASC", this.xidrepuesto, this.comborepuesto);
        this.comborepuesto.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.lleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Valor", "Avaluo", "Serie", "Codigo", "Modelo", "Marca", "Tipo_Riesgo", "Centro_costo", "Proveedor", "Fecha", "Adquisicion", "Registro", "Util", "Tipo", "invima", "permisocomercial"}) { // from class: Mantenimiento.JIFConfigurar.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaequipos.setModel(this.xmodelo);
        this.tablaequipos.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.tablaequipos.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.tablaequipos.getColumnModel().getColumn(2).setPreferredWidth(25);
        this.tablaequipos.getColumnModel().getColumn(3).setPreferredWidth(25);
        this.tablaequipos.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.tablaequipos.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.tablaequipos.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.tablaequipos.getColumnModel().getColumn(10).setPreferredWidth(30);
        this.tablaequipos.getColumnModel().getColumn(11).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(13).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(14).setPreferredWidth(10);
        this.tablaequipos.getColumnModel().getColumn(15).setPreferredWidth(15);
        this.tablaequipos.getColumnModel().getColumn(16).setPreferredWidth(30);
        this.tablaequipos.getColumnModel().getColumn(17).setPreferredWidth(30);
    }

    public final void cargarDatos(String dat) {
        ResultSet rs = this.xconsulta5.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(rs.getString(1), n, 0);
                this.xmodelo.setValueAt(rs.getString(2), n, 1);
                this.xmodelo.setValueAt(rs.getString(3), n, 2);
                this.xmodelo.setValueAt(rs.getString(4), n, 3);
                this.xmodelo.setValueAt(rs.getString(5), n, 4);
                this.xmodelo.setValueAt(rs.getString(6), n, 5);
                this.xmodelo.setValueAt(rs.getString(7), n, 6);
                this.xmodelo.setValueAt(rs.getString(8), n, 7);
                this.xmodelo.setValueAt(rs.getString(9), n, 8);
                this.xmodelo.setValueAt(rs.getString(10), n, 9);
                this.xmodelo.setValueAt(rs.getString(11), n, 10);
                this.xmodelo.setValueAt(rs.getString(12), n, 11);
                this.xmodelo.setValueAt(rs.getString(13), n, 12);
                this.xmodelo.setValueAt(rs.getString(14), n, 13);
                this.xmodelo.setValueAt(rs.getString(15), n, 14);
                this.xmodelo.setValueAt(rs.getString(16), n, 15);
                this.xmodelo.setValueAt(rs.getString(18), n, 16);
                this.xmodelo.setValueAt(rs.getString(19), n, 17);
                n++;
            } catch (SQLException ex) {
                this.xconsulta5.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta5.cerrarConexionBd();
    }

    private void llenatabla() {
        if (this.txtdato.getText().equals("")) {
            this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Avaluo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`, `m_equipos`.`invima`, `m_equipos`.`permisocomercial`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 ORDER BY `m_equipos`.`Nombre` ASC";
            crearGrid();
            cargarDatos(this.sql);
        }
        if (this.Rbnombre.isSelected()) {
            this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Avaluo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`, `m_equipos`.`invima`, `m_equipos`.`permisocomercial`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND (`m_equipos`.`Nombre` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
            crearGrid();
            cargarDatos(this.sql);
        }
        if (this.Rbserie.isSelected()) {
            this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Avaluo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`, `m_equipos`.`invima`, `m_equipos`.`permisocomercial`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND (`m_equipos`.`Serie` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
            crearGrid();
            cargarDatos(this.sql);
        }
        if (this.Rbserie.isSelected()) {
            this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Avaluo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`, `m_equipos`.`invima`, `m_equipos`.`permisocomercial`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND (`m_equipos`.`Serie` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
            crearGrid();
            cargarDatos(this.sql);
        }
        if (this.Rbunidad.isSelected()) {
            this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Avaluo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`, `m_equipos`.`invima`, `m_equipos`.`permisocomercial`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND ( `f_centrocosto`.`Nbre` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
            crearGrid();
            cargarDatos(this.sql);
        }
        if (this.Rbproveedor.isSelected()) {
            this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Avaluo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`, `m_equipos`.`invima`, `m_equipos`.`permisocomercial`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND ( cc_terceros.RazonSocialCompleta like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
            crearGrid();
            cargarDatos(this.sql);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridnormalidad() {
        this.xmodelonormalidad = new DefaultTableModel(new Object[0], new String[]{"Nombre", "Normal", "Maximo", "Minimo", "U. Medida"}) { // from class: Mantenimiento.JIFConfigurar.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablanormalidad.setModel(this.xmodelonormalidad);
        this.tablanormalidad.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.tablanormalidad.getColumnModel().getColumn(1).setPreferredWidth(90);
        this.tablanormalidad.getColumnModel().getColumn(2).setPreferredWidth(90);
        this.tablanormalidad.getColumnModel().getColumn(3).setPreferredWidth(90);
        this.tablanormalidad.getColumnModel().getColumn(4).setPreferredWidth(90);
    }

    public final void cargarDatosnormalidad(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelonormalidad.addRow(this.datosnormalidad);
                this.xmodelonormalidad.setValueAt(rs.getString(1), n, 0);
                this.xmodelonormalidad.setValueAt(rs.getString(2), n, 1);
                this.xmodelonormalidad.setValueAt(rs.getString(3), n, 2);
                this.xmodelonormalidad.setValueAt(rs.getString(4), n, 3);
                this.xmodelonormalidad.setValueAt(rs.getString(5), n, 4);
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
        this.sqlnormalidad = "SELECT `m_tipovariables`.`Nbre`, `m_tipovariables`.`VNormal`, `m_tipovariables`.`VMinimo`, `m_tipovariables`.`VMaximo`, `i_unidadmedida`.`Nbre` , `m_tablanormalidadxequipo`.`Id`FROM `m_tablanormalidadxequipo` INNER JOIN `m_tipovariables`ON (`m_tablanormalidadxequipo`.`Id_TipoVariable` = `m_tipovariables`.`Id`)INNER JOIN `i_unidadmedida` ON (`m_tipovariables`.`Id_UnidadMedida` = `i_unidadmedida`.`Id`) WHERE m_tablanormalidadxequipo.Id_Equipo = '" + Principal.txtNo.getText() + "'";
        cargarDatosnormalidad(this.sqlnormalidad);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridmanual() {
        this.xmodelomanual = new DefaultTableModel(new Object[0], new String[]{"Tipo_Manual", "Ruta"}) { // from class: Mantenimiento.JIFConfigurar.3
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablamanual.setModel(this.xmodelomanual);
        this.tablamanual.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.tablamanual.getColumnModel().getColumn(1).setPreferredWidth(70);
    }

    public final void cargarDatosmanual(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelomanual.addRow(this.datosmanual);
                this.xmodelomanual.setValueAt(rs.getString(1), n, 0);
                this.xmodelomanual.setValueAt(rs.getString(2), n, 1);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablamanual() {
        this.sqlmanual = "SELECT `m_tipomanual`.`Nbre` , `m_manualxequipo`.`Url`, `m_manualxequipo`.`Id_Equipo`FROM `m_manualxequipo` INNER JOIN `m_tipomanual`ON (`m_manualxequipo`.`Id_TipoManual` = `m_tipomanual`.`Id`) WHERE m_manualxequipo.Id_Equipo = '" + Principal.txtNo.getText() + "'; ";
        cargarDatosmanual(this.sqlmanual);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridproce() {
        this.xmodeloproce = new DefaultTableModel(new Object[0], new String[]{"Procedimiento", "Frecuencia", "Fecha"}) { // from class: Mantenimiento.JIFConfigurar.4
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaproce.setModel(this.xmodeloproce);
        this.tablaproce.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.tablaproce.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.tablaproce.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    public final void cargarDatosproce(String dat) {
        crearGridproce();
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodeloproce.addRow(this.datosproce);
                this.xmodeloproce.setValueAt(rs.getString(1), n, 0);
                this.xmodeloproce.setValueAt(rs.getString(2), n, 1);
                this.xmodeloproce.setValueAt(rs.getString(3), n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablaproce() {
        this.sqlproce = "SELECT `m_tipoprocedimientos`.`Nbre` , `m_tipofrecuencia`.`Nbre`, `m_procedimientoxequipo`.`Fecha`, `m_procedimientoxequipo`.`Id_Equipo`FROM `m_procedimientoxequipo`  INNER JOIN `m_tipoprocedimientos`ON (`m_procedimientoxequipo`.`Id_TipoProcedimiento` = `m_tipoprocedimientos`.`Id`)INNER JOIN `m_tipofrecuencia` ON (`m_tipoprocedimientos`.`Id_Frecuencia` = `m_tipofrecuencia`.`Id`) WHERE m_procedimientoxequipo.Id_Equipo = '" + Principal.txtNo.getText() + "' AND m_tipoprocedimientos.Tipo = 'Mantenimiento'; ";
        cargarDatosproce(this.sqlproce);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridcalibra() {
        this.xmodelocalibra = new DefaultTableModel(new Object[0], new String[]{"Procedimiento", "Frecuencia", "Fecha"}) { // from class: Mantenimiento.JIFConfigurar.5
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaproce1.setModel(this.xmodelocalibra);
        this.tablaproce1.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.tablaproce1.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.tablaproce1.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    public final void cargarDatoscalibra(String dat) {
        crearGridcalibra();
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelocalibra.addRow(this.datoscalibra);
                this.xmodelocalibra.setValueAt(rs.getString(1), n, 0);
                this.xmodelocalibra.setValueAt(rs.getString(2), n, 1);
                this.xmodelocalibra.setValueAt(rs.getString(3), n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablacalibra() {
        this.sqlcalibra = "SELECT `m_tipoprocedimientos`.`Nbre` , `m_tipofrecuencia`.`Nbre`, `m_procedimientoxequipo`.`Fecha`, `m_procedimientoxequipo`.`Id_Equipo`FROM `m_procedimientoxequipo`  INNER JOIN `m_tipoprocedimientos`ON (`m_procedimientoxequipo`.`Id_TipoProcedimiento` = `m_tipoprocedimientos`.`Id`)INNER JOIN `m_tipofrecuencia` ON (`m_tipoprocedimientos`.`Id_Frecuencia` = `m_tipofrecuencia`.`Id`) WHERE m_procedimientoxequipo.Id_Equipo = '" + Principal.txtNo.getText() + "'  AND m_tipoprocedimientos.Tipo = 'Calibracion' ; ";
        cargarDatoscalibra(this.sqlcalibra);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridrepuesto() {
        this.xmodelorepuesto = new DefaultTableModel(new Object[0], new String[]{"Repuesto", "Laboratorio", "Valor", "Observacion"}) { // from class: Mantenimiento.JIFConfigurar.6
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablarepuesto.setModel(this.xmodelorepuesto);
        this.tablarepuesto.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.tablarepuesto.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.tablarepuesto.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.tablarepuesto.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    public final void cargarDatosrepuesto(String dat) {
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelorepuesto.addRow(this.datosrepuesto);
                this.xmodelorepuesto.setValueAt(rs.getString(1), n, 0);
                this.xmodelorepuesto.setValueAt(rs.getString(2), n, 1);
                this.xmodelorepuesto.setValueAt(rs.getString(3), n, 2);
                this.xmodelorepuesto.setValueAt(rs.getString(4), n, 3);
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
        this.sqlrepuesto = "SELECT `m_tiporespuesto`.`Nbre`, `m_tiporespuesto`.`Id_Laboratorio`, `m_repuestoxequipo`.`Valor`, `m_repuestoxequipo`.`Observacion`, `m_repuestoxequipo`.`Id_Equipo`FROM  `m_repuestoxequipo`INNER JOIN `m_tiporespuesto` ON (`m_repuestoxequipo`.`Id_TipoRepuesto` = `m_tiporespuesto`.`Id`) WHERE `m_repuestoxequipo`.`Id_Equipo` = '" + Principal.txtNo.getText() + "'";
        cargarDatosrepuesto(this.sqlrepuesto);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridcomponente() {
        this.xmodelocomponente = new DefaultTableModel(new Object[0], new String[]{"Componente", "Marca", "Valor", "Observacion"}) { // from class: Mantenimiento.JIFConfigurar.7
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablacomponente.setModel(this.xmodelocomponente);
        this.tablacomponente.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.tablacomponente.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.tablacomponente.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.tablacomponente.getColumnModel().getColumn(3).setPreferredWidth(120);
    }

    public final void cargarDatoscomponente(String dat) {
        ResultSet rs = this.xconsulta7.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelocomponente.addRow(this.datoscomponente);
                this.xmodelocomponente.setValueAt(rs.getString(1), n, 0);
                this.xmodelocomponente.setValueAt(rs.getString(2), n, 1);
                this.xmodelocomponente.setValueAt(rs.getString(3), n, 2);
                this.xmodelocomponente.setValueAt(rs.getString(4), n, 3);
                n++;
            } catch (SQLException ex) {
                this.xconsulta7.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta7.cerrarConexionBd();
    }

    private void llenatablacomponente() {
        this.sqlcomponente = "SELECT `m_tipocomponente`.`Nbre` , `i_laboratorio`.`Nbre` , `m_componentexequipo`.`Valor` , `m_componentexequipo`.`Observacion` FROM `m_componentexequipo` INNER JOIN `m_tipocomponente`    ON (`m_componentexequipo`.`Id_TipoComponente` = `m_tipocomponente`.`Id`) INNER JOIN `i_laboratorio`  ON (`m_componentexequipo`.`Id_Marca` = `i_laboratorio`.`Id`) WHERE `m_componentexequipo`.`Id_Equipo` = '" + Principal.txtNo.getText() + "' ;";
        cargarDatoscomponente(this.sqlcomponente);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridregistrotecnico() {
        this.xmodeloregistrotecnico = new DefaultTableModel(new Object[0], new String[]{"Registro", "Dato", "Observacion"}) { // from class: Mantenimiento.JIFConfigurar.8
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaregistrotecnico.setModel(this.xmodeloregistrotecnico);
        this.tablaregistrotecnico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.tablaregistrotecnico.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.tablaregistrotecnico.getColumnModel().getColumn(2).setPreferredWidth(120);
    }

    public final void cargarDatosregistrotecnico(String dat) {
        crearGridregistrotecnico();
        ResultSet rs = this.xconsulta6.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodeloregistrotecnico.addRow(this.datosregistrotecnico);
                this.xmodeloregistrotecnico.setValueAt(rs.getString(1), n, 0);
                this.xmodeloregistrotecnico.setValueAt(rs.getString(2), n, 1);
                this.xmodeloregistrotecnico.setValueAt(rs.getString(3), n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta6.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta6.cerrarConexionBd();
    }

    private void llenatablaregistrotecnico() {
        this.sqlregistrotecnico = "SELECT `m_tiporegistrotecnico`.`Nbre`, `m_registrotecnico`.`Dato`, `m_registrotecnico`.`Observacion`, `m_registrotecnico`.`Id_Equipo`FROM `m_registrotecnico`INNER JOIN `m_tiporegistrotecnico` ON (`m_registrotecnico`.`Id_TipoRegistro` = `m_tiporegistrotecnico`.`Id`)WHERE `m_registrotecnico`.`Id_Equipo` = '" + Principal.txtNo.getText() + "' ;";
        cargarDatosregistrotecnico(this.sqlregistrotecnico);
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v146, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v188, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v213, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v254, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v284, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v316, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v359, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.Equipos = new JInternalFrame();
        this.jPanel20 = new JPanel();
        this.jScrollPane8 = new JScrollPane();
        this.tablaequipos = new JTable();
        this.txtDato = new JTextField();
        this.jPanel1 = new JPanel();
        this.Rbproveedor = new JRadioButton();
        this.Rbunidad = new JRadioButton();
        this.Rbnombre = new JRadioButton();
        this.Rbserie = new JRadioButton();
        this.datosequipo = new JPanel();
        this.txtnombre = new JTextField();
        this.txtmodelo = new JTextField();
        this.txtserie = new JTextField();
        this.fecharegistro = new JDateChooser();
        this.jDateChooser1 = new JDateChooser();
        this.comboproveedor = new JComboBox();
        this.combocentrocosto = new JComboBox();
        this.txtvalor = new JTextField();
        this.combotiporiesgo = new JComboBox();
        this.combomarca = new JComboBox();
        this.jButton9 = new JButton();
        this.jPanel11 = new JPanel();
        this.Vida = new JSpinner();
        this.Tres = new JRadioButton();
        this.Uno = new JRadioButton();
        this.Dos = new JRadioButton();
        this.txtcodigo = new JTextField();
        this.txtvalor1 = new JTextField();
        this.txtinvima = new JTextField();
        this.txtpermisocomercial = new JTextField();
        this.Datosconfiguraciones = new JTabbedPane();
        this.jPanel4 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.tablanormalidad = new JTable();
        this.combonormalidad = new JComboBox();
        this.txtmax = new JTextField();
        this.txtmin = new JTextField();
        this.txtnor = new JTextField();
        this.txtunidad = new JTextField();
        this.jButton3 = new JButton();
        this.jScrollPane11 = new JScrollPane();
        this.txtobservacion = new JTextArea();
        this.txtutil = new JTextField();
        this.jPanel6 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.tablaproce = new JTable();
        this.combofrecuencia = new JComboBox();
        this.txtdatos3 = new JTextField();
        this.comboprocedimiento = new JComboBox();
        this.jButton5 = new JButton();
        this.jPanel8 = new JPanel();
        this.jPanel16 = new JPanel();
        this.jScrollPane7 = new JScrollPane();
        this.tablarepuesto = new JTable();
        this.jPanel17 = new JPanel();
        this.comborepuesto = new JComboBox();
        this.jButton7 = new JButton();
        this.txtvalorcom = new JTextField();
        this.jScrollPane12 = new JScrollPane();
        this.txtdatos4 = new JTextArea();
        this.jPanel3 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.tablacomponente = new JTable();
        this.jButton2 = new JButton();
        this.txtdatos2 = new JTextField();
        this.valor = new JTextField();
        this.combomarcacomp = new JComboBox();
        this.combocomponentes = new JComboBox();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.tablaregistrotecnico = new JTable();
        this.jButton1 = new JButton();
        this.combotiporegistro = new JComboBox();
        this.jScrollPane9 = new JScrollPane();
        this.txtdato = new JTextArea();
        this.jScrollPane10 = new JScrollPane();
        this.txtinfo = new JTextArea();
        this.jPanel7 = new JPanel();
        this.jPanel15 = new JPanel();
        this.combocalibracion = new JComboBox();
        this.jButton6 = new JButton();
        this.jScrollPane13 = new JScrollPane();
        this.jTextField9 = new JTextArea();
        this.jScrollPane6 = new JScrollPane();
        this.tablaproce1 = new JTable();
        this.jPanel5 = new JPanel();
        this.jPanel13 = new JPanel();
        this.combomanual = new JComboBox();
        this.jButton4 = new JButton();
        this.JTFRuta = new JTextField();
        this.jScrollPane4 = new JScrollPane();
        this.tablamanual = new JTable();
        this.jPanel9 = new JPanel();
        this.jPanel19 = new JPanel();
        this.jLabel1 = new JLabel();
        this.JTFRuta1 = new JTextField();
        this.jButton8 = new JButton();
        this.jPanel10 = new JPanel();
        this.Calibra = new JButton();
        this.jButton11 = new JButton();
        this.BtnSeguimiento1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("HOJA DE VIDA DE EQUIPOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1069, 765));
        setMinimumSize(new Dimension(1069, 765));
        setName("JIFConfigurar");
        setPreferredSize(new Dimension(817, 560));
        addInternalFrameListener(new InternalFrameListener() { // from class: Mantenimiento.JIFConfigurar.9
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFConfigurar.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFConfigurar.10
            public void mouseClicked(MouseEvent evt) {
                JIFConfigurar.this.formMouseClicked(evt);
            }
        });
        getContentPane().setLayout((LayoutManager) null);
        this.Equipos.setTitle("Equipos");
        this.Equipos.setNormalBounds(new Rectangle(280, 220, 550, 340));
        this.Equipos.setOpaque(true);
        this.tablaequipos.setForeground(new Color(0, 51, 255));
        this.tablaequipos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaequipos.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFConfigurar.11
            public void mouseClicked(MouseEvent evt) {
                JIFConfigurar.this.tablaequiposMouseClicked(evt);
            }
        });
        this.jScrollPane8.setViewportView(this.tablaequipos);
        this.txtDato.setFont(new Font("Arial", 1, 13));
        this.txtDato.setBorder(BorderFactory.createTitledBorder((Border) null, "Dato", 0, 0, new Font("Arial", 1, 12)));
        this.txtDato.addCaretListener(new CaretListener() { // from class: Mantenimiento.JIFConfigurar.12
            public void caretUpdate(CaretEvent evt) {
                JIFConfigurar.this.txtDatoCaretUpdate(evt);
            }
        });
        this.txtDato.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.13
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtDatoActionPerformed(evt);
            }
        });
        this.txtDato.addFocusListener(new FocusAdapter() { // from class: Mantenimiento.JIFConfigurar.14
            public void focusGained(FocusEvent evt) {
                JIFConfigurar.this.txtDatoFocusGained(evt);
            }
        });
        this.txtDato.addKeyListener(new KeyAdapter() { // from class: Mantenimiento.JIFConfigurar.15
            public void keyReleased(KeyEvent evt) {
                JIFConfigurar.this.txtDatoKeyReleased(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder("Tipo de Filtro"));
        this.buttonGroup2.add(this.Rbproveedor);
        this.Rbproveedor.setFont(new Font("Tahoma", 1, 12));
        this.Rbproveedor.setText("Proveedor");
        this.buttonGroup2.add(this.Rbunidad);
        this.Rbunidad.setFont(new Font("Tahoma", 1, 12));
        this.Rbunidad.setText("Unidad Funcional");
        this.buttonGroup2.add(this.Rbnombre);
        this.Rbnombre.setFont(new Font("Tahoma", 1, 12));
        this.Rbnombre.setSelected(true);
        this.Rbnombre.setText("Nombre Equipo");
        this.buttonGroup2.add(this.Rbserie);
        this.Rbserie.setFont(new Font("Tahoma", 1, 12));
        this.Rbserie.setText("# Serie");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.Rbnombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Rbserie).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Rbunidad).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.Rbproveedor).addContainerGap(13, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Rbnombre).addComponent(this.Rbserie).addComponent(this.Rbunidad).addComponent(this.Rbproveedor)).addContainerGap(-1, 32767)));
        GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
        this.jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel20Layout.createSequentialGroup().addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane8, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.txtDato, -2, 570, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2))).addContainerGap()));
        jPanel20Layout.setVerticalGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup().addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel20Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.txtDato, -2, -1, -2).addGap(12, 12, 12)).addComponent(this.jPanel1, -2, -1, -2)).addComponent(this.jScrollPane8, -1, 377, 32767).addContainerGap()));
        GroupLayout EquiposLayout = new GroupLayout(this.Equipos.getContentPane());
        this.Equipos.getContentPane().setLayout(EquiposLayout);
        EquiposLayout.setHorizontalGroup(EquiposLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(EquiposLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel20, -2, -1, -2).addContainerGap(-1, 32767)));
        EquiposLayout.setVerticalGroup(EquiposLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(EquiposLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel20, -1, -1, 32767)));
        getContentPane().add(this.Equipos);
        this.Equipos.setBounds(0, 240, 1050, 500);
        this.datosequipo.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS EQUIPOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.datosequipo.setLayout((LayoutManager) null);
        this.txtnombre.setFont(new Font("Arial", 1, 12));
        this.txtnombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Equipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.datosequipo.add(this.txtnombre);
        this.txtnombre.setBounds(190, 20, 360, 50);
        this.txtmodelo.setFont(new Font("Arial", 1, 12));
        this.txtmodelo.setBorder(BorderFactory.createTitledBorder((Border) null, "Modelo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtmodelo.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.16
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtmodeloActionPerformed(evt);
            }
        });
        this.datosequipo.add(this.txtmodelo);
        this.txtmodelo.setBounds(560, 20, 160, 37);
        this.txtserie.setBackground(new Color(153, 153, 255));
        this.txtserie.setFont(new Font("Arial", 1, 12));
        this.txtserie.setBorder(BorderFactory.createTitledBorder((Border) null, "# Serie", 0, 0, new Font("Arial", 1, 12)));
        this.txtserie.addCaretListener(new CaretListener() { // from class: Mantenimiento.JIFConfigurar.17
            public void caretUpdate(CaretEvent evt) {
                JIFConfigurar.this.txtserieCaretUpdate(evt);
            }
        });
        this.txtserie.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.18
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtserieActionPerformed(evt);
            }
        });
        this.txtserie.addFocusListener(new FocusAdapter() { // from class: Mantenimiento.JIFConfigurar.19
            public void focusGained(FocusEvent evt) {
                JIFConfigurar.this.txtserieFocusGained(evt);
            }
        });
        this.datosequipo.add(this.txtserie);
        this.txtserie.setBounds(10, 20, 170, 50);
        this.fecharegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Registro", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.fecharegistro.setDateFormatString("dd/MM/yyyy");
        this.fecharegistro.setFont(new Font("Arial", 1, 12));
        this.fecharegistro.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFConfigurar.20
            public void mouseClicked(MouseEvent evt) {
                JIFConfigurar.this.fecharegistroMouseClicked(evt);
            }
        });
        this.datosequipo.add(this.fecharegistro);
        this.fecharegistro.setBounds(340, 110, 200, 44);
        this.jDateChooser1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Adquisiciòn", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
        this.jDateChooser1.setDoubleBuffered(false);
        this.jDateChooser1.setFont(new Font("Arial", 1, 12));
        this.jDateChooser1.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFConfigurar.21
            public void mouseClicked(MouseEvent evt) {
                JIFConfigurar.this.jDateChooser1MouseClicked(evt);
            }
        });
        this.jDateChooser1.addKeyListener(new KeyAdapter() { // from class: Mantenimiento.JIFConfigurar.22
            public void keyPressed(KeyEvent evt) {
                JIFConfigurar.this.jDateChooser1KeyPressed(evt);
            }
        });
        this.datosequipo.add(this.jDateChooser1);
        this.jDateChooser1.setBounds(340, 70, 200, 44);
        this.comboproveedor.setFont(new Font("Arial", 1, 12));
        this.comboproveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.datosequipo.add(this.comboproveedor);
        this.comboproveedor.setBounds(10, 160, 300, 41);
        this.combocentrocosto.setFont(new Font("Arial", 1, 12));
        this.combocentrocosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.datosequipo.add(this.combocentrocosto);
        this.combocentrocosto.setBounds(10, 100, 300, 41);
        this.txtvalor.setFont(new Font("Arial", 1, 12));
        this.txtvalor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Equipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtvalor.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.23
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtvalorActionPerformed(evt);
            }
        });
        this.datosequipo.add(this.txtvalor);
        this.txtvalor.setBounds(320, 170, 200, 50);
        this.combotiporiesgo.setFont(new Font("Arial", 1, 12));
        this.combotiporiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Riesgo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.datosequipo.add(this.combotiporiesgo);
        this.combotiporiesgo.setBounds(900, 20, 130, 41);
        this.combomarca.setFont(new Font("Arial", 1, 12));
        this.combomarca.setBorder(BorderFactory.createTitledBorder((Border) null, "Marca", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.datosequipo.add(this.combomarca);
        this.combomarca.setBounds(730, 20, 160, 41);
        this.jButton9.setFont(new Font("Arial", 1, 12));
        this.jButton9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Movimiento29x27.png")));
        this.jButton9.setText("ACTUALIZAR ");
        this.jButton9.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.24
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton9ActionPerformed(evt);
            }
        });
        this.datosequipo.add(this.jButton9);
        this.jButton9.setBounds(879, 140, 138, 50);
        this.jPanel11.setBorder(BorderFactory.createTitledBorder((Border) null, "Vida Util", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel11.setLayout(new AbsoluteLayout());
        this.Vida.setFont(new Font("Arial", 1, 12));
        this.Vida.setModel(new SpinnerNumberModel());
        this.Vida.setEditor(new JSpinner.NumberEditor(this.Vida, ""));
        this.jPanel11.add(this.Vida, new AbsoluteConstraints(70, 10, 49, 40));
        this.buttonGroup3.add(this.Tres);
        this.Tres.setFont(new Font("Arial", 1, 12));
        this.Tres.setForeground(new Color(0, 0, 255));
        this.Tres.setText("Dias");
        this.jPanel11.add(this.Tres, new AbsoluteConstraints(240, 20, -1, -1));
        this.buttonGroup3.add(this.Uno);
        this.Uno.setFont(new Font("Arial", 1, 12));
        this.Uno.setForeground(new Color(0, 0, 255));
        this.Uno.setSelected(true);
        this.Uno.setText("Años");
        this.Uno.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.25
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.UnoActionPerformed(evt);
            }
        });
        this.jPanel11.add(this.Uno, new AbsoluteConstraints(130, 20, -1, -1));
        this.buttonGroup3.add(this.Dos);
        this.Dos.setFont(new Font("Arial", 1, 12));
        this.Dos.setForeground(new Color(0, 0, 255));
        this.Dos.setText("Meses");
        this.jPanel11.add(this.Dos, new AbsoluteConstraints(180, 20, -1, -1));
        this.datosequipo.add(this.jPanel11);
        this.jPanel11.setBounds(730, 70, 300, 60);
        this.txtcodigo.setBackground(new Color(153, 153, 255));
        this.txtcodigo.setFont(new Font("Arial", 1, 12));
        this.txtcodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Interno", 0, 0, new Font("Arial", 1, 12)));
        this.txtcodigo.addCaretListener(new CaretListener() { // from class: Mantenimiento.JIFConfigurar.26
            public void caretUpdate(CaretEvent evt) {
                JIFConfigurar.this.txtcodigoCaretUpdate(evt);
            }
        });
        this.txtcodigo.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.27
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtcodigoActionPerformed(evt);
            }
        });
        this.txtcodigo.addFocusListener(new FocusAdapter() { // from class: Mantenimiento.JIFConfigurar.28
            public void focusGained(FocusEvent evt) {
                JIFConfigurar.this.txtcodigoFocusGained(evt);
            }
        });
        this.datosequipo.add(this.txtcodigo);
        this.txtcodigo.setBounds(750, 140, 120, 50);
        this.txtvalor1.setFont(new Font("Arial", 1, 12));
        this.txtvalor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Avalúo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtvalor1.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.29
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtvalor1ActionPerformed(evt);
            }
        });
        this.datosequipo.add(this.txtvalor1);
        this.txtvalor1.setBounds(530, 170, 200, 50);
        this.txtinvima.setFont(new Font("Arial", 1, 12));
        this.txtinvima.setBorder(BorderFactory.createTitledBorder((Border) null, "Invima", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtinvima.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.30
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtinvimaActionPerformed(evt);
            }
        });
        this.datosequipo.add(this.txtinvima);
        this.txtinvima.setBounds(560, 70, 160, 37);
        this.txtpermisocomercial.setFont(new Font("Arial", 1, 12));
        this.txtpermisocomercial.setBorder(BorderFactory.createTitledBorder((Border) null, "Permiso Comercial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtpermisocomercial.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.31
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtpermisocomercialActionPerformed(evt);
            }
        });
        this.datosequipo.add(this.txtpermisocomercial);
        this.txtpermisocomercial.setBounds(560, 120, 160, 37);
        getContentPane().add(this.datosequipo);
        this.datosequipo.setBounds(10, 0, 1040, 230);
        this.Datosconfiguraciones.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONFIGURACION EQUIPO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.Datosconfiguraciones.setForeground(new Color(255, 0, 0));
        this.Datosconfiguraciones.setTabLayoutPolicy(1);
        this.Datosconfiguraciones.setAutoscrolls(true);
        this.Datosconfiguraciones.setEnabled(false);
        this.Datosconfiguraciones.setFont(new Font("Arial", 1, 12));
        this.Datosconfiguraciones.addChangeListener(new ChangeListener() { // from class: Mantenimiento.JIFConfigurar.32
            public void stateChanged(ChangeEvent evt) {
                JIFConfigurar.this.DatosconfiguracionesStateChanged(evt);
            }
        });
        this.jPanel4.setLayout(new AbsoluteLayout());
        this.jScrollPane3.setBorder(new SoftBevelBorder(0));
        this.tablanormalidad.setBorder(BorderFactory.createEtchedBorder());
        this.tablanormalidad.setFont(new Font("Arial", 1, 12));
        this.tablanormalidad.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablanormalidad.setAutoResizeMode(0);
        this.tablanormalidad.setRowHeight(25);
        this.tablanormalidad.setSelectionBackground(new Color(255, 255, 255));
        this.tablanormalidad.setSelectionForeground(new Color(255, 0, 0));
        this.tablanormalidad.setSelectionMode(0);
        this.jScrollPane3.setViewportView(this.tablanormalidad);
        this.jPanel4.add(this.jScrollPane3, new AbsoluteConstraints(280, 70, 640, 270));
        this.combonormalidad.setFont(new Font("Arial", 1, 12));
        this.combonormalidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12)));
        this.combonormalidad.addItemListener(new ItemListener() { // from class: Mantenimiento.JIFConfigurar.33
            public void itemStateChanged(ItemEvent evt) {
                JIFConfigurar.this.combonormalidadItemStateChanged(evt);
            }
        });
        this.jPanel4.add(this.combonormalidad, new AbsoluteConstraints(10, 10, 900, -1));
        this.txtmax.setFont(new Font("Arial", 1, 12));
        this.txtmax.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Máximo", 0, 0, new Font("Arial", 1, 12)));
        this.txtmax.setEnabled(false);
        this.txtmax.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.34
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtmaxActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.txtmax, new AbsoluteConstraints(10, 80, 101, 50));
        this.txtmin.setFont(new Font("Arial", 1, 12));
        this.txtmin.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Mínimo", 0, 0, new Font("Arial", 1, 12)));
        this.txtmin.setEnabled(false);
        this.txtmin.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.35
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtminActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.txtmin, new AbsoluteConstraints(10, 150, 101, 50));
        this.txtnor.setFont(new Font("Arial", 1, 12));
        this.txtnor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Normal", 0, 0, new Font("Arial", 1, 12)));
        this.txtnor.setEnabled(false);
        this.txtnor.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.36
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtnorActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.txtnor, new AbsoluteConstraints(10, 220, 100, 50));
        this.txtunidad.setFont(new Font("Arial", 1, 12));
        this.txtunidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Medida", 0, 0, new Font("Arial", 1, 12)));
        this.txtunidad.setEnabled(false);
        this.txtunidad.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.37
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtunidadActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.txtunidad, new AbsoluteConstraints(10, 280, 100, 50));
        this.jButton3.setFont(new Font("Arial", 1, 12));
        this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton3.setText("Agregar");
        this.jButton3.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.38
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.jButton3, new AbsoluteConstraints(130, 290, 130, 30));
        this.txtobservacion.setColumns(15);
        this.txtobservacion.setFont(new Font("Arial", 1, 12));
        this.txtobservacion.setRows(5);
        this.txtobservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane11.setViewportView(this.txtobservacion);
        this.jPanel4.add(this.jScrollPane11, new AbsoluteConstraints(120, 70, 150, 210));
        this.txtutil.setFont(new Font("Arial", 1, 13));
        this.txtutil.setBorder(BorderFactory.createTitledBorder((Border) null, "# Serie", 0, 0, new Font("Arial", 1, 12)));
        this.txtutil.addCaretListener(new CaretListener() { // from class: Mantenimiento.JIFConfigurar.39
            public void caretUpdate(CaretEvent evt) {
                JIFConfigurar.this.txtutilCaretUpdate(evt);
            }
        });
        this.txtutil.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.40
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtutilActionPerformed(evt);
            }
        });
        this.txtutil.addFocusListener(new FocusAdapter() { // from class: Mantenimiento.JIFConfigurar.41
            public void focusGained(FocusEvent evt) {
                JIFConfigurar.this.txtutilFocusGained(evt);
            }
        });
        this.jPanel4.add(this.txtutil, new AbsoluteConstraints(440, 130, 50, -1));
        this.Datosconfiguraciones.addTab("T. NORMALIDAD", this.jPanel4);
        this.jPanel6.setLayout(new AbsoluteLayout());
        this.jScrollPane5.setBorder(new SoftBevelBorder(0));
        this.tablaproce.setBorder(BorderFactory.createEtchedBorder());
        this.tablaproce.setFont(new Font("Arial", 1, 12));
        this.tablaproce.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaproce.setRowHeight(25);
        this.tablaproce.setSelectionBackground(new Color(255, 255, 255));
        this.tablaproce.setSelectionForeground(new Color(255, 0, 0));
        this.tablaproce.setSelectionMode(0);
        this.jScrollPane5.setViewportView(this.tablaproce);
        this.jPanel6.add(this.jScrollPane5, new AbsoluteConstraints(10, 130, 900, 210));
        this.combofrecuencia.setFont(new Font("Arial", 1, 12));
        this.combofrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 0, 0, new Font("Arial", 1, 12)));
        this.combofrecuencia.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.42
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.combofrecuenciaActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.combofrecuencia, new AbsoluteConstraints(10, 70, 290, -1));
        this.txtdatos3.setFont(new Font("Arial", 1, 12));
        this.txtdatos3.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12)));
        this.txtdatos3.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.43
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtdatos3ActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.txtdatos3, new AbsoluteConstraints(310, 70, 460, 50));
        this.comboprocedimiento.setFont(new Font("Arial", 1, 12));
        this.comboprocedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Item de Procedimiento", 0, 0, new Font("Arial", 1, 12)));
        this.comboprocedimiento.addItemListener(new ItemListener() { // from class: Mantenimiento.JIFConfigurar.44
            public void itemStateChanged(ItemEvent evt) {
                JIFConfigurar.this.comboprocedimientoItemStateChanged(evt);
            }
        });
        this.jPanel6.add(this.comboprocedimiento, new AbsoluteConstraints(10, 17, 900, -1));
        this.jButton5.setFont(new Font("Arial", 1, 12));
        this.jButton5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton5.setText("Agregar");
        this.jButton5.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.45
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton5ActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.jButton5, new AbsoluteConstraints(779, 80, 130, 40));
        this.Datosconfiguraciones.addTab("MANTENIMIENTO PREV", this.jPanel6);
        this.jPanel16.setLayout(new AbsoluteLayout());
        this.jScrollPane7.setBorder(new SoftBevelBorder(0));
        this.tablarepuesto.setBorder(BorderFactory.createEtchedBorder());
        this.tablarepuesto.setFont(new Font("Arial", 1, 12));
        this.tablarepuesto.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablarepuesto.setRowHeight(25);
        this.tablarepuesto.setSelectionBackground(new Color(255, 255, 255));
        this.tablarepuesto.setSelectionForeground(new Color(255, 0, 0));
        this.tablarepuesto.setSelectionMode(0);
        this.jScrollPane7.setViewportView(this.tablarepuesto);
        this.jPanel16.add(this.jScrollPane7, new AbsoluteConstraints(282, 11, 610, 310));
        this.jPanel17.setBorder(BorderFactory.createBevelBorder(0));
        this.comborepuesto.setFont(new Font("Arial", 1, 12));
        this.comborepuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Repuesto", 0, 0, new Font("Arial", 1, 12)));
        this.jButton7.setFont(new Font("Arial", 1, 12));
        this.jButton7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton7.setText("Agregar");
        this.jButton7.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.46
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton7ActionPerformed(evt);
            }
        });
        this.txtvalorcom.setFont(new Font("Arial", 1, 14));
        this.txtvalorcom.setHorizontalAlignment(4);
        this.txtvalorcom.setText("0");
        this.txtvalorcom.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12)));
        this.txtvalorcom.addCaretListener(new CaretListener() { // from class: Mantenimiento.JIFConfigurar.47
            public void caretUpdate(CaretEvent evt) {
                JIFConfigurar.this.txtvalorcomCaretUpdate(evt);
            }
        });
        this.txtvalorcom.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.48
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtvalorcomActionPerformed(evt);
            }
        });
        this.txtvalorcom.addFocusListener(new FocusAdapter() { // from class: Mantenimiento.JIFConfigurar.49
            public void focusGained(FocusEvent evt) {
                JIFConfigurar.this.txtvalorcomFocusGained(evt);
            }
        });
        this.txtdatos4.setColumns(7);
        this.txtdatos4.setFont(new Font("Arial", 1, 12));
        this.txtdatos4.setRows(3);
        this.txtdatos4.setText(" ");
        this.txtdatos4.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane12.setViewportView(this.txtdatos4);
        GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
        this.jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton7, -1, 246, 32767)).addGroup(jPanel17Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane12, GroupLayout.Alignment.TRAILING, -1, 250, 32767).addComponent(this.txtvalorcom, -1, 250, 32767).addComponent(this.comborepuesto, 0, 250, 32767)))).addContainerGap()));
        jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup().addContainerGap().addComponent(this.comborepuesto, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtvalorcom, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane12, -1, 130, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton7, -2, 33, -2).addContainerGap()));
        this.jPanel16.add(this.jPanel17, new AbsoluteConstraints(0, 11, 270, 310));
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel16, -1, 913, 32767).addContainerGap()));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel16, -1, 333, 32767).addContainerGap()));
        this.Datosconfiguraciones.addTab("REPUESTOS", this.jPanel8);
        this.jPanel3.setLayout(new AbsoluteLayout());
        this.jScrollPane2.setBorder(new SoftBevelBorder(0));
        this.tablacomponente.setBorder(BorderFactory.createEtchedBorder());
        this.tablacomponente.setFont(new Font("Arial", 1, 12));
        this.tablacomponente.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablacomponente.setAutoResizeMode(4);
        this.tablacomponente.setRowHeight(25);
        this.tablacomponente.setSelectionBackground(new Color(255, 255, 255));
        this.tablacomponente.setSelectionForeground(new Color(255, 0, 0));
        this.tablacomponente.setSelectionMode(0);
        this.jScrollPane2.setViewportView(this.tablacomponente);
        this.jPanel3.add(this.jScrollPane2, new AbsoluteConstraints(10, 130, 900, 210));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton2.setText("Agregar");
        this.jButton2.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.50
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton2ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.jButton2, new AbsoluteConstraints(770, 80, 140, 40));
        this.txtdatos2.setFont(new Font("Arial", 1, 12));
        this.txtdatos2.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12)));
        this.txtdatos2.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.51
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.txtdatos2ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.txtdatos2, new AbsoluteConstraints(340, 70, 420, 50));
        this.valor.setFont(new Font("Arial", 1, 12));
        this.valor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12)));
        this.valor.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.52
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.valorActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.valor, new AbsoluteConstraints(10, 70, 160, -1));
        this.combomarcacomp.setFont(new Font("Arial", 1, 12));
        this.combomarcacomp.setBorder(BorderFactory.createTitledBorder((Border) null, "Marca", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel3.add(this.combomarcacomp, new AbsoluteConstraints(180, 70, 150, -1));
        this.combocomponentes.setFont(new Font("Arial", 1, 12));
        this.combocomponentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Componentes y Accesorios", 0, 0, new Font("Arial", 1, 12)));
        this.combocomponentes.addItemListener(new ItemListener() { // from class: Mantenimiento.JIFConfigurar.53
            public void itemStateChanged(ItemEvent evt) {
                JIFConfigurar.this.combocomponentesItemStateChanged(evt);
            }
        });
        this.combocomponentes.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.54
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.combocomponentesActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.combocomponentes, new AbsoluteConstraints(10, 13, 900, -1));
        this.Datosconfiguraciones.addTab("COMPONENTES", this.jPanel3);
        this.jPanel2.setBorder(new SoftBevelBorder(0));
        this.jPanel2.setLayout(new AbsoluteLayout());
        this.jScrollPane1.setBorder(new SoftBevelBorder(0));
        this.tablaregistrotecnico.setBorder(BorderFactory.createEtchedBorder());
        this.tablaregistrotecnico.setFont(new Font("Arial", 1, 12));
        this.tablaregistrotecnico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaregistrotecnico.setRowHeight(25);
        this.tablaregistrotecnico.setSelectionBackground(new Color(255, 255, 255));
        this.tablaregistrotecnico.setSelectionForeground(Color.red);
        this.tablaregistrotecnico.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.tablaregistrotecnico);
        this.jPanel2.add(this.jScrollPane1, new AbsoluteConstraints(10, 130, 900, 210));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton1.setText("Agregar");
        this.jButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.55
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jButton1, new AbsoluteConstraints(680, 20, 220, -1));
        this.combotiporegistro.setFont(new Font("Arial", 1, 12));
        this.combotiporegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Registro", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel2.add(this.combotiporegistro, new AbsoluteConstraints(10, 10, 330, -1));
        this.txtdato.setColumns(5);
        this.txtdato.setRows(1);
        this.txtdato.setTabSize(1);
        this.txtdato.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane9.setViewportView(this.txtdato);
        this.jPanel2.add(this.jScrollPane9, new AbsoluteConstraints(350, 10, 320, 50));
        this.txtinfo.setColumns(5);
        this.txtinfo.setFont(new Font("Arial", 1, 12));
        this.txtinfo.setRows(1);
        this.txtinfo.setTabSize(1);
        this.txtinfo.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane10.setViewportView(this.txtinfo);
        this.jPanel2.add(this.jScrollPane10, new AbsoluteConstraints(10, 70, 890, 50));
        this.Datosconfiguraciones.addTab("REG. TECNICO", this.jPanel2);
        this.jPanel15.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel15.setLayout(new AbsoluteLayout());
        this.combocalibracion.setFont(new Font("Arial", 1, 12));
        this.combocalibracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Calibración", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel15.add(this.combocalibracion, new AbsoluteConstraints(10, 10, 870, 50));
        this.jButton6.setFont(new Font("Arial", 1, 12));
        this.jButton6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton6.setText("Agregar");
        this.jButton6.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.56
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton6ActionPerformed(evt);
            }
        });
        this.jPanel15.add(this.jButton6, new AbsoluteConstraints(760, 70, 120, 40));
        this.jTextField9.setColumns(20);
        this.jTextField9.setFont(new Font("Arial", 1, 12));
        this.jTextField9.setRows(2);
        this.jTextField9.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane13.setViewportView(this.jTextField9);
        this.jPanel15.add(this.jScrollPane13, new AbsoluteConstraints(10, 70, 740, 50));
        this.jScrollPane6.setBorder(new SoftBevelBorder(0));
        this.tablaproce1.setBorder(BorderFactory.createEtchedBorder());
        this.tablaproce1.setFont(new Font("Arial", 1, 12));
        this.tablaproce1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaproce1.setRowHeight(25);
        this.tablaproce1.setSelectionBackground(new Color(255, 255, 255));
        this.tablaproce1.setSelectionForeground(new Color(255, 0, 0));
        this.tablaproce1.setSelectionMode(0);
        this.jScrollPane6.setViewportView(this.tablaproce1);
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING, -1, 909, 32767).addComponent(this.jPanel15, GroupLayout.Alignment.LEADING, -1, 913, 32767)).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel15, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane6, -1, 189, 32767).addContainerGap()));
        this.Datosconfiguraciones.addTab("CALIBRACION", this.jPanel7);
        this.jPanel13.setBorder(BorderFactory.createBevelBorder(0));
        this.combomanual.setFont(new Font("Arial", 1, 12));
        this.combomanual.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Manual", 0, 0, new Font("Arial", 1, 12)));
        this.combomanual.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.57
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.combomanualActionPerformed(evt);
            }
        });
        this.jButton4.setFont(new Font("Arial", 1, 12));
        this.jButton4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton4.setText("Agregar");
        this.jButton4.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.58
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton4ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFConfigurar.59
            public void mouseClicked(MouseEvent evt) {
                JIFConfigurar.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.60
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.JTFRutaActionPerformed(evt);
            }
        });
        GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
        this.jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup().addContainerGap().addComponent(this.combomanual, 0, 460, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 304, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton4).addContainerGap()));
        jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton4, -1, -1, 32767).addComponent(this.JTFRuta).addComponent(this.combomanual)).addContainerGap(-1, 32767)));
        this.jScrollPane4.setBorder(new SoftBevelBorder(0));
        this.tablamanual.setBorder(BorderFactory.createEtchedBorder());
        this.tablamanual.setFont(new Font("Arial", 1, 12));
        this.tablamanual.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablamanual.setRowHeight(25);
        this.tablamanual.setSelectionBackground(new Color(255, 255, 255));
        this.tablamanual.setSelectionForeground(new Color(255, 0, 0));
        this.tablamanual.setSelectionMode(0);
        this.tablamanual.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFConfigurar.61
            public void mouseClicked(MouseEvent evt) {
                JIFConfigurar.this.tablamanualMouseClicked(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.tablamanual);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel13, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane4, GroupLayout.Alignment.LEADING, -1, 909, 32767)).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel13, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jScrollPane4, -1, 245, 32767).addContainerGap()));
        this.Datosconfiguraciones.addTab("MANUALES", this.jPanel5);
        this.jPanel19.setBorder(BorderFactory.createTitledBorder((Border) null, "Fotografia Equipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel19.setMaximumSize(new Dimension(431, 238));
        this.jPanel19.setMinimumSize(new Dimension(431, 238));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFConfigurar.62
            public void mouseClicked(MouseEvent evt) {
                JIFConfigurar.this.jLabel1MouseClicked(evt);
            }
        });
        GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
        this.jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -1, 849, 32767).addContainerGap()));
        jPanel19Layout.setVerticalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel19Layout.createSequentialGroup().addComponent(this.jLabel1, -1, 249, 32767).addContainerGap()));
        this.JTFRuta1.setFont(new Font("Arial", 1, 12));
        this.JTFRuta1.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta1.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFConfigurar.63
            public void mouseClicked(MouseEvent evt) {
                JIFConfigurar.this.JTFRuta1MouseClicked(evt);
            }
        });
        this.jButton8.setFont(new Font("Arial", 1, 12));
        this.jButton8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton8.setText("Agregar");
        this.jButton8.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.64
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton8ActionPerformed(evt);
            }
        });
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JTFRuta1, -2, 692, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton8, -1, 191, 32767)).addComponent(this.jPanel19, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGap(34, 34, 34)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta1, -2, -1, -2).addComponent(this.jButton8, -2, 49, -2)).addGap(11, 11, 11).addComponent(this.jPanel19, -1, -1, 32767)));
        this.Datosconfiguraciones.addTab("FOTOGRAFIA", this.jPanel9);
        getContentPane().add(this.Datosconfiguraciones);
        this.Datosconfiguraciones.setBounds(50, 310, 950, 410);
        this.Datosconfiguraciones.getAccessibleContext().setAccessibleName("Registro Tecnico");
        this.jPanel10.setBorder(BorderFactory.createTitledBorder(new SoftBevelBorder(0, Color.white, Color.lightGray, (Color) null, Color.white), "INGRESAR DATOS A EQUIPOS EXISTENTES", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel10.setLayout((LayoutManager) null);
        this.Calibra.setFont(new Font("Arial", 1, 12));
        this.Calibra.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Generar.png")));
        this.Calibra.setText("Soporte Calibracion");
        this.Calibra.setEnabled(false);
        this.Calibra.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.65
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.CalibraActionPerformed(evt);
            }
        });
        this.jPanel10.add(this.Calibra);
        this.Calibra.setBounds(640, 20, 280, 30);
        this.jButton11.setFont(new Font("Arial", 1, 12));
        this.jButton11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.jButton11.setText("Ver Equipos");
        this.jButton11.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.jButton11.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.66
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.jButton11ActionPerformed(evt);
            }
        });
        this.jPanel10.add(this.jButton11);
        this.jButton11.setBounds(20, 20, 280, 30);
        this.BtnSeguimiento1.setFont(new Font("Arial", 1, 12));
        this.BtnSeguimiento1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        this.BtnSeguimiento1.setText("Realizar Seguimiento");
        this.BtnSeguimiento1.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.BtnSeguimiento1.setEnabled(false);
        this.BtnSeguimiento1.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFConfigurar.67
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurar.this.BtnSeguimiento1ActionPerformed(evt);
            }
        });
        this.jPanel10.add(this.BtnSeguimiento1);
        this.BtnSeguimiento1.setBounds(310, 20, 320, 30);
        getContentPane().add(this.jPanel10);
        this.jPanel10.setBounds(50, 240, 940, 60);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtmodeloActionPerformed(ActionEvent evt) {
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja el equipo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `m_equipos` SET `Estado`='0' WHERE `m_equipos`.`Id`='" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                Principal.txtNo.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGrid();
                llenatabla();
            }
        }
    }

    public void grabar() {
        if (Principal.txtNo.getText().equals("")) {
            if (this.Uno.isSelected()) {
                this.edad = 1;
            }
            if (this.Dos.isSelected()) {
                this.edad = 2;
            }
            if (this.Tres.isSelected()) {
                this.edad = 3;
            }
            if (Principal.txtNo.getText() != null) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    Metodos xmt = new Metodos();
                    String sql100 = "INSERT INTO m_equipos (Nombre, Serie, Codigo, Fecha_Adquisicion, Fecha_Registro, Vida, Id_tipoedad, Id_CentroCosto, Id_Laboratorio, Modelo, Id_Proveedor, Id_ClasificacionI, ValorEquipo, Avaluo, UsuarioS, fecha, invima, permisocomercial) VALUES('" + this.txtnombre.getText() + "', '" + this.txtserie.getText() + "','" + this.txtcodigo.getText() + "','" + this.metodos.formatoAMD.format(this.jDateChooser1.getDate()) + "','" + this.metodos.formatoAMD.format(this.fecharegistro.getDate()) + "', '" + this.Vida.getValue() + "', '" + this.edad + "','" + this.xidarea[this.combocentrocosto.getSelectedIndex()] + "','" + this.xidmarca[this.combomarca.getSelectedIndex()] + "', '" + this.txtmodelo.getText() + "', '" + this.xidprovedor[this.comboproveedor.getSelectedIndex()] + "', '" + this.xidinvima[this.combotiporiesgo.getSelectedIndex()] + "', '" + this.txtvalor.getText() + "', '" + this.txtvalor1.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "', '" + this.txtinvima.getText() + "', '" + this.txtpermisocomercial.getText() + "')";
                    Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql100));
                    this.xconsulta.cerrarConexionBd();
                    JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.Datosconfiguraciones.setEnabled(true);
                    this.Calibra.setEnabled(true);
                    this.BtnSeguimiento1.setEnabled(true);
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El registro ya existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void nuevo() {
        Principal.txtNo.setText("");
        this.txtserie.setText("");
        this.txtcodigo.setText("");
        this.txtmodelo.setText("");
        this.txtnombre.setText("");
        this.txtvalor.setText("");
        this.txtvalor1.setText("");
        this.combotiporiesgo.setSelectedIndex(-1);
        this.combocentrocosto.setSelectedIndex(-1);
        this.comboproveedor.setSelectedIndex(-1);
        this.txtinvima.setText("");
        this.txtpermisocomercial.setText("");
        this.txtserie.requestFocus();
        this.Calibra.setEnabled(false);
        crearGridcomponente();
        crearGridregistrotecnico();
        crearGridnormalidad();
        crearGridcalibra();
        crearGridrepuesto();
        crearGridproce();
        crearGridmanual();
    }

    public void imprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            if (n == 0) {
                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_Matenimiento_Equipo.jasper", mparametros);
            } else if (n == 1) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_Matenimiento_Equipo", mparametros);
            }
        }
    }

    private void mCargarImagen() {
        String xsql = "SELECT Url  FROM m_equipos WHERE (Id ='" + Principal.txtNo.getText() + "') ";
        String xvalor = this.xconsulta.traerDato(xsql);
        String Imagen = this.xconsulta.traerDato("SELECT Url FROM m_equipos WHERE (Serie ='NULO') ");
        if (xvalor.equals("")) {
            this.jLabel1.setIcon(new ImageIcon(Imagen));
            this.JTFRuta1.setText("");
        } else {
            this.JTFRuta1.setText(this.metodos.mTraerUrlBD(xvalor));
            this.xconsulta.cerrarConexionBd();
            this.jLabel1.setIcon(new ImageIcon(xvalor));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtserieActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtvalorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton9ActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText() != null) {
            if (this.Uno.isSelected()) {
                this.edad = 1;
            }
            if (this.Dos.isSelected()) {
                this.edad = 2;
            }
            if (this.Tres.isSelected()) {
                this.edad = 3;
            }
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar los datos de este equipo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                new Metodos();
                String sql100 = "UPDATE m_equipos SET Nombre = '" + this.txtnombre.getText() + "', Serie = '" + this.txtserie.getText() + "',Codigo = '" + this.txtcodigo.getText() + "', Fecha_Adquisicion = '" + this.metodos.formatoAMD.format(this.jDateChooser1.getDate()) + "', Fecha_Registro = '" + this.metodos.formatoAMD.format(this.fecharegistro.getDate()) + "' ,Vida = '" + this.Vida.getValue() + "', Id_tipoedad = '" + this.edad + "', Id_CentroCosto = '" + this.xidarea[this.combocentrocosto.getSelectedIndex()] + "', Id_Laboratorio ='" + this.xidmarca[this.combomarca.getSelectedIndex()] + "', Modelo = '" + this.txtmodelo.getText() + "', Id_Proveedor = '" + this.xidprovedor[this.comboproveedor.getSelectedIndex()] + "', Id_ClasificacionI = '" + this.xidinvima[this.combotiporiesgo.getSelectedIndex()] + "' , ValorEquipo = '" + this.txtvalor.getText() + "', Avaluo = '" + this.txtvalor1.getText() + "', invima = '" + this.txtinvima.getText() + "', permisocomercial = '" + this.txtpermisocomercial.getText() + "' WHERE m_equipos.Id = '" + Principal.txtNo.getText() + "'";
                System.out.println(sql100);
                this.xconsulta.ejecutarSQL(sql100);
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Registro Actualizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\HDV-Equipos\\Ima-Equipos\\");
            xfilec.setFileSelectionMode(0);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta1.setText(this.metodos.mTraerUrlBD(this.xfile.getPath()));
                this.jLabel1.setIcon(new ImageIcon(this.xfile.getPath()));
            }
            String[] ficheros = this.xfile.list();
            if (ficheros == null) {
                System.out.println("No hay ficheros en el directorio especificado");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Necesita llenar el campo # serie para poder guardar los datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.txtserie.requestFocus();
            return;
        }
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql0 = "insert into m_registrotecnico (Id_Equipo, Id_TipoRegistro, Dato, Observacion) values('" + Principal.txtNo.getText() + "','" + this.xidRegtecnico[this.combotiporegistro.getSelectedIndex()] + "','" + this.txtdato.getText() + "', '" + this.txtinfo.getText() + "')";
            this.xconsulta.ejecutarSQL(sql0);
            this.xconsulta.cerrarConexionBd();
            crearGridregistrotecnico();
            llenatablaregistrotecnico();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton7ActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un equipo para porder ingresar los datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        Metodos xmt = new Metodos();
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql13 = "insert into   m_repuestoxequipo (Id_Equipo, Id_TipoRepuesto, valor, Observacion, Estado, UsuarioS, Fecha) values('" + Principal.txtNo.getText() + "','" + this.xidrepuesto[this.comborepuesto.getSelectedIndex()] + "','" + this.txtvalorcom.getText() + "','" + this.txtdatos4.getText() + "','1', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            System.out.println(sql13);
            this.xconsulta.ejecutarSQL(sql13);
            this.xconsulta.cerrarConexionBd();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            crearGridrepuesto();
            llenatablarepuesto();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton6ActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un equipo para porder ingresar los datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        Metodos xmt = new Metodos();
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql12 = "insert into m_procedimientoxequipo (Id_Equipo, Id_TipoProcedimiento, Observacion, Estado, UsuarioS, Fecha) values('" + Principal.txtNo.getText() + "','" + this.xidcalibracion[this.combocalibracion.getSelectedIndex()] + "','" + this.txtdatos3.getText() + "','1', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql12);
            this.xconsulta.cerrarConexionBd();
            crearGridcalibra();
            llenatablacalibra();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combofrecuenciaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtdatos3ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton5ActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un equipo para porder ingresar los datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        new Metodos();
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql12 = "insert into m_procedimientoxequipo (Id_Equipo, Id_TipoProcedimiento, Observacion, Estado, UsuarioS, Fecha) values('" + Principal.txtNo.getText() + "','" + this.xidprocedimiento[this.comboprocedimiento.getSelectedIndex()][0] + "','" + this.txtdatos3.getText() + "','1', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "')";
            System.out.println(sql12);
            this.xconsulta.ejecutarSQL(sql12);
            this.xconsulta.cerrarConexionBd();
            crearGridproce();
            llenatablaproce();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\HDV-Equipos\\Man-Equipo\\");
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
    public void combomanualActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtminActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtunidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtmaxActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton3ActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Necesita llenar el campo # serie para poder guardar los datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        Metodos xmt = new Metodos();
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql10 = "insert into m_tablanormalidadxequipo (Id_Equipo, Id_TipoVariable, Observacion, Estado, UsuarioS, Fecha) values('" + Principal.txtNo.getText() + "','" + this.xidnormalidad[this.combonormalidad.getSelectedIndex()][0] + "','" + this.txtobservacion.getText() + "', '1', '" + Principal.usuarioSistemaDTO.getLogin() + "','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql10);
            this.xconsulta.cerrarConexionBd();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            crearGridnormalidad();
            llenatablanormalidad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void valorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtdatos2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un equipo para porder ingresar los datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        Metodos xmt = new Metodos();
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql12 = "insert into m_componentexequipo (Id_Equipo, Id_TipoComponente,  id_marca, Valor, Observacion, Estado, UsuarioS, Fecha) values('" + Principal.txtNo.getText() + "','" + this.xidcomponente[this.combocomponentes.getSelectedIndex()][0] + "', '" + this.xidmarca[this.combomarcacomp.getSelectedIndex()] + "','" + this.valor.getText() + "','" + this.txtdatos2.getText() + "','1', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            System.out.println(sql12);
            this.xconsulta.ejecutarSQL(sql12);
            this.xconsulta.cerrarConexionBd();
            crearGridcomponente();
            llenatablacomponente();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combocomponentesActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CalibraActionPerformed(ActionEvent evt) {
        this.Cmantenimiento.cargarPantalla("Soporte Calibracion", Principal.txtNo.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaequiposMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablaequipos.getSelectedRow() != -1) {
            this.Equipos.setVisible(false);
            this.Calibra.setEnabled(true);
            this.BtnSeguimiento1.setEnabled(true);
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 0).toString());
            this.txtnombre.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 1).toString());
            this.txtvalor.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 2).toString());
            this.txtvalor1.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 3).toString());
            this.txtserie.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 4).toString());
            this.txtcodigo.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 5).toString());
            this.txtmodelo.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 6).toString());
            this.combomarca.setSelectedItem(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 7).toString());
            this.combotiporiesgo.setSelectedItem(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 8).toString());
            this.combocentrocosto.setSelectedItem(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 9).toString());
            this.comboproveedor.setSelectedItem(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 10).toString());
            this.Vida.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 14).toString()));
            if (this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 15).toString().equals("DIA")) {
                this.Tres.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 15).toString().equals("MES")) {
                this.Dos.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 15).toString().equals("AÑO")) {
                this.Uno.setSelected(true);
            }
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/MM/dd");
            try {
                this.jDateChooser1.setDate(formatoDelTexto.parse(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 12).toString()));
                this.fecharegistro.setDate(formatoDelTexto.parse(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 13).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(JIFConfigurar.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            this.txtinvima.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 16).toString());
            this.txtpermisocomercial.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 17).toString());
            this.Datosconfiguraciones.setEnabled(true);
            crearGridcomponente();
            crearGridregistrotecnico();
            crearGridnormalidad();
            crearGridcalibra();
            crearGridrepuesto();
            crearGridproce();
            crearGridmanual();
            llenatablanormalidad();
            llenatablamanual();
            llenatablaproce();
            llenatablacalibra();
            llenatablacomponente();
            llenatablaregistrotecnico();
            llenatablarepuesto();
            mCargarImagen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtserieCaretUpdate(CaretEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtserieFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton4ActionPerformed(ActionEvent evt) {
        if (Principal.txtNo.getText().equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un equipo para porder ingresar los datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        Metodos xmt = new Metodos();
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql12 = "insert into m_manualxequipo (Id_Equipo, Id_TipoManual, Url, UsuarioS, Fecha) values('" + Principal.txtNo.getText() + "','" + this.xidmanual[this.combomanual.getSelectedIndex()] + "','" + this.JTFRuta.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql12);
            this.xconsulta.cerrarConexionBd();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            crearGridmanual();
            llenatablamanual();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton8ActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta1.getText().isEmpty()) {
            String sql = "update m_equipos set Url='" + this.JTFRuta1.getText() + "' where id='" + Principal.txtNo.getText() + "'";
            JOptionPane.showInternalMessageDialog(this, "Ruta Guardada exitosamente", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.xconsulta.ejecutarSQL(sql);
            this.xconsulta.cerrarConexionBd();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe selecionar una imagen valida", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTFRuta1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combocomponentesItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void combonormalidadItemStateChanged(ItemEvent evt) {
        if (this.lleno) {
            this.txtmax.setText(this.xidnormalidad[this.combonormalidad.getSelectedIndex()][3]);
            this.txtmin.setText(this.xidnormalidad[this.combonormalidad.getSelectedIndex()][2]);
            this.txtnor.setText(this.xidnormalidad[this.combonormalidad.getSelectedIndex()][1]);
            this.txtunidad.setText(this.xidnormalidad[this.combonormalidad.getSelectedIndex()][4]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void comboprocedimientoItemStateChanged(ItemEvent evt) {
        if (this.lleno) {
            this.combofrecuencia.setSelectedItem(this.xidprocedimiento[this.comboprocedimiento.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtvalorcomCaretUpdate(CaretEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtvalorcomActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtvalorcomFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablamanualMouseClicked(MouseEvent evt) {
        if (this.tablamanual.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.metodos.mostrarPdf(this.xmodelomanual.getValueAt(this.tablamanual.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jLabel1MouseClicked(MouseEvent evt) {
        mAbrirArchivo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jDateChooser1MouseClicked(MouseEvent evt) {
        this.jDateChooser1.setDate(this.metodos.getFechaActual());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fecharegistroMouseClicked(MouseEvent evt) {
        this.fecharegistro.setDate(this.metodos.getFechaActual());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jDateChooser1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton11ActionPerformed(ActionEvent evt) {
        this.Equipos.setVisible(true);
        crearGrid();
        llenatabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseClicked(MouseEvent evt) {
        this.Equipos.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.txtNo.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BtnSeguimiento1ActionPerformed(ActionEvent evt) {
        this.Cmantenimiento.cargarPantalla("Seguimientos", this.txtnombre.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDatoCaretUpdate(CaretEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDatoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDatoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDatoKeyReleased(KeyEvent evt) {
        llenatabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtutilCaretUpdate(CaretEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtutilActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtutilFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtcodigoCaretUpdate(CaretEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtcodigoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtcodigoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UnoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtvalor1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DatosconfiguracionesStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtinvimaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtpermisocomercialActionPerformed(ActionEvent evt) {
    }

    private void formWindowActivated(WindowEvent evt) {
    }

    public void mAbrirArchivo() {
        try {
            Runtime.getRuntime().exec("C:\\windows\\system32\\mspaint.exe " + this.JTFRuta1.getText());
        } catch (IOException ex) {
            Logger.getLogger(JIFConfigurar.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void paintComponent(JPanel jPanel19) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
