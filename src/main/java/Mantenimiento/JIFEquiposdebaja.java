package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/JIFEquiposdebaja.class */
public class JIFEquiposdebaja extends JInternalFrame {
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
    private JRadioButton Activo;
    private JRadioButton Inactivo;
    private JRadioButton Rbnombre;
    private JRadioButton Rbproveedor;
    private JRadioButton Rbserie;
    private JRadioButton Rbunidad;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel20;
    private JScrollPane jScrollPane8;
    private JTable tablaequipos;
    private JTextField total;
    private JTextField txtDato;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta5 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta6 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta7 = new ConsultasMySQL();
    public boolean lleno = false;
    private Metodos xmetodo = new Metodos();

    public JIFEquiposdebaja() {
        initComponents();
        crearGrid();
        llenatabla();
        consultar();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Valor", "Serie", "Codigo", "Modelo", "Marca", "Imvima", "Centro_costo", "Proveedor", "Fecha", "Adquisicion", "Registro", "Util", "Tipo"}) { // from class: Mantenimiento.JIFEquiposdebaja.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.tablaequipos.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.tablaequipos.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.tablaequipos.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.tablaequipos.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.tablaequipos.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(11).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.tablaequipos.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.tablaequipos.getColumnModel().getColumn(14).setPreferredWidth(15);
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
        if (this.Activo.isSelected()) {
            if (this.txtDato.getText().equals("")) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbnombre.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND (`m_equipos`.`Nombre` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbserie.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND (`m_equipos`.`Serie` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbserie.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND (`m_equipos`.`Serie` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbunidad.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND ( `f_centrocosto`.`Nbre` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbproveedor.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 1 AND ( cc_terceros.RazonSocialCompleta like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
        }
        if (this.Inactivo.isSelected()) {
            if (this.txtDato.getText().equals("")) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 0 ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbnombre.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 0 AND (`m_equipos`.`Nombre` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbserie.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 0 AND (`m_equipos`.`Serie` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbserie.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 0 AND (`m_equipos`.`Serie` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbunidad.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 0 AND ( `f_centrocosto`.`Nbre` like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.Rbproveedor.isSelected()) {
                this.sql = "SELECT`m_equipos`.`Id`, `m_equipos`.`Nombre`, `m_equipos`.`ValorEquipo`, `m_equipos`.`Serie`, `m_equipos`.`Codigo`, `m_equipos`.`Modelo`, `i_laboratorio`.`Nbre`, `i_clasificacion`.`Nbre`, `f_centrocosto`.`Nbre`, cc_terceros.RazonSocialCompleta, `m_equipos`.`Fecha`, date_format(`m_equipos`.`Fecha_Adquisicion`,'%Y/%m/%d'), date_format(`m_equipos`.`Fecha_Registro`,'%Y/%m/%d'), `m_equipos`.`Vida`, `g_tipoedad`.`Nbre`, `m_equipos`.`Estado`FROM`m_equipos`INNER JOIN `i_laboratorio` ON (`m_equipos`.`Id_Laboratorio` = `i_laboratorio`.`Id`)INNER JOIN `f_centrocosto` ON (`m_equipos`.`Id_CentroCosto` = `f_centrocosto`.`Id`)INNER JOIN cc_terceros ON (`m_equipos`.`Id_Proveedor` = cc_terceros.`Id`)INNER JOIN `i_clasificacion` ON (`m_equipos`.`Id_ClasificacionI` = `i_clasificacion`.`Id`)INNER JOIN `g_tipoedad` ON (`m_equipos`.`Id_tipoedad` = `g_tipoedad`.`Id`) WHERE `m_equipos`.`Estado` = 0 AND ( cc_terceros.RazonSocialCompleta like '" + this.txtDato.getText() + "%') ORDER BY `m_equipos`.`Nombre` ASC";
                crearGrid();
                cargarDatos(this.sql);
            }
        }
    }

    public void grabar() {
        if (this.Inactivo.isSelected() && Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea Activar el equipo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `m_equipos` SET `Estado`='1' WHERE `m_equipos`.`Id`='" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                Principal.txtNo.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGrid();
                llenatabla();
            }
        }
        if (this.Activo.isSelected() && Principal.txtNo.getText() != null) {
            int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja el equipo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n2 == 0) {
                String sqlup2 = "UPDATE `m_equipos` SET `Estado`='0' WHERE `m_equipos`.`Id`='" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(sqlup2);
                this.xconsulta.cerrarConexionBd();
                Principal.txtNo.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGrid();
                llenatabla();
            }
        }
    }

    private void consultar() {
        if (this.Activo.isSelected()) {
            ResultSet Rf = this.xconsulta.traerRs("SELECT  COUNT(*)  AS total FROM m_equipos WHERE Estado='1'");
            try {
                if (Rf.next()) {
                    Rf.first();
                    this.total.setText(Rf.getString(1));
                }
                Rf.close();
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCalibrar.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        if (this.Inactivo.isSelected()) {
            ResultSet Rf2 = this.xconsulta.traerRs("SELECT  COUNT(*)  AS total FROM m_equipos WHERE Estado='0'");
            System.out.print(this.sql1);
            try {
                if (Rf2.next()) {
                    Rf2.first();
                    this.total.setText(Rf2.getString(1));
                }
                Rf2.close();
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException ex2) {
                Logger.getLogger(JIFCalibrar.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    public void imprimir() {
        if (this.Activo.isSelected()) {
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
                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_Activo.jasper", mparametros);
            } else if (n == 1) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_Activo", mparametros);
            }
        }
        if (this.Inactivo.isSelected()) {
            String[][] mparametros2 = new String[3][2];
            Object[] botones2 = {"Impresion", "Vista PDF", "Cerrar"};
            int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
            mparametros2[0][0] = "Id";
            mparametros2[0][1] = Principal.txtNo.getText();
            mparametros2[1][0] = "SUBREPORT_DIR";
            mparametros2[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            mparametros2[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros2[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            if (n2 == 0) {
                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_Inactivo.jasper", mparametros2);
            } else if (n2 == 1) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_Inactivo", mparametros2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.jPanel20 = new JPanel();
        this.jScrollPane8 = new JScrollPane();
        this.tablaequipos = new JTable();
        this.txtDato = new JTextField();
        this.jPanel1 = new JPanel();
        this.Rbproveedor = new JRadioButton();
        this.Rbunidad = new JRadioButton();
        this.Rbnombre = new JRadioButton();
        this.Rbserie = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.Activo = new JRadioButton();
        this.Inactivo = new JRadioButton();
        this.total = new JTextField();
        this.jLabel1 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("EQUIPOS DE BAJA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFEquiposdebaja");
        this.jPanel20.setLayout(new AbsoluteLayout());
        this.tablaequipos.setFont(new Font("Arial", 1, 12));
        this.tablaequipos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaequipos.setRowHeight(25);
        this.tablaequipos.setSelectionBackground(new Color(255, 255, 255));
        this.tablaequipos.setSelectionForeground(new Color(255, 0, 0));
        this.tablaequipos.setSelectionMode(0);
        this.tablaequipos.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFEquiposdebaja.2
            public void mouseClicked(MouseEvent evt) {
                JIFEquiposdebaja.this.tablaequiposMouseClicked(evt);
            }
        });
        this.jScrollPane8.setViewportView(this.tablaequipos);
        this.jPanel20.add(this.jScrollPane8, new AbsoluteConstraints(0, 92, 1070, 530));
        this.txtDato.setFont(new Font("Arial", 1, 12));
        this.txtDato.setBorder(BorderFactory.createTitledBorder((Border) null, "Dato", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtDato.addCaretListener(new CaretListener() { // from class: Mantenimiento.JIFEquiposdebaja.3
            public void caretUpdate(CaretEvent evt) {
                JIFEquiposdebaja.this.txtDatoCaretUpdate(evt);
            }
        });
        this.txtDato.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFEquiposdebaja.4
            public void actionPerformed(ActionEvent evt) {
                JIFEquiposdebaja.this.txtDatoActionPerformed(evt);
            }
        });
        this.txtDato.addFocusListener(new FocusAdapter() { // from class: Mantenimiento.JIFEquiposdebaja.5
            public void focusGained(FocusEvent evt) {
                JIFEquiposdebaja.this.txtDatoFocusGained(evt);
            }
        });
        this.txtDato.addKeyListener(new KeyAdapter() { // from class: Mantenimiento.JIFEquiposdebaja.6
            public void keyReleased(KeyEvent evt) {
                JIFEquiposdebaja.this.txtDatoKeyReleased(evt);
            }
        });
        this.jPanel20.add(this.txtDato, new AbsoluteConstraints(10, 20, 620, 50));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Filtro", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.buttonGroup2.add(this.Rbproveedor);
        this.Rbproveedor.setFont(new Font("Arial", 1, 12));
        this.Rbproveedor.setText("Proveedor");
        this.buttonGroup2.add(this.Rbunidad);
        this.Rbunidad.setFont(new Font("Arial", 1, 12));
        this.Rbunidad.setText("Unidad Funcional");
        this.buttonGroup2.add(this.Rbnombre);
        this.Rbnombre.setFont(new Font("Arial", 1, 12));
        this.Rbnombre.setSelected(true);
        this.Rbnombre.setText("Nombre Equipo");
        this.buttonGroup2.add(this.Rbserie);
        this.Rbserie.setFont(new Font("Arial", 1, 12));
        this.Rbserie.setText("# Serie");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(12, 32767).addComponent(this.Rbserie).addGap(68, 68, 68).addComponent(this.Rbproveedor).addGap(46, 46, 46)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.Rbnombre).addGap(18, 18, 18).addComponent(this.Rbunidad)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Rbnombre).addComponent(this.Rbunidad)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Rbproveedor).addComponent(this.Rbserie)).addContainerGap()));
        this.jPanel20.add(this.jPanel1, new AbsoluteConstraints(780, 10, 288, 74));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.buttonGroup1.add(this.Activo);
        this.Activo.setFont(new Font("Arial", 1, 12));
        this.Activo.setText("Activos");
        this.Activo.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFEquiposdebaja.7
            public void mouseClicked(MouseEvent evt) {
                JIFEquiposdebaja.this.ActivoMouseClicked(evt);
            }
        });
        this.Activo.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFEquiposdebaja.8
            public void actionPerformed(ActionEvent evt) {
                JIFEquiposdebaja.this.ActivoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.Inactivo);
        this.Inactivo.setFont(new Font("Arial", 1, 12));
        this.Inactivo.setSelected(true);
        this.Inactivo.setText("Inactivos");
        this.Inactivo.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFEquiposdebaja.9
            public void mouseClicked(MouseEvent evt) {
                JIFEquiposdebaja.this.InactivoMouseClicked(evt);
            }
        });
        this.Inactivo.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFEquiposdebaja.10
            public void actionPerformed(ActionEvent evt) {
                JIFEquiposdebaja.this.InactivoActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.Inactivo).addComponent(this.Activo)).addContainerGap(46, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.Inactivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Activo).addContainerGap()));
        this.jPanel20.add(this.jPanel2, new AbsoluteConstraints(630, 10, 141, 74));
        this.total.setBackground(new Color(0, 0, 0));
        this.total.setFont(new Font("Arial", 1, 18));
        this.total.setForeground(new Color(255, 255, 255));
        this.total.setBorder(BorderFactory.createTitledBorder((Border) null, "Dato", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.total.setCaretColor(new Color(255, 255, 255));
        this.total.addCaretListener(new CaretListener() { // from class: Mantenimiento.JIFEquiposdebaja.11
            public void caretUpdate(CaretEvent evt) {
                JIFEquiposdebaja.this.totalCaretUpdate(evt);
            }
        });
        this.total.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFEquiposdebaja.12
            public void actionPerformed(ActionEvent evt) {
                JIFEquiposdebaja.this.totalActionPerformed(evt);
            }
        });
        this.total.addFocusListener(new FocusAdapter() { // from class: Mantenimiento.JIFEquiposdebaja.13
            public void focusGained(FocusEvent evt) {
                JIFEquiposdebaja.this.totalFocusGained(evt);
            }
        });
        this.total.addKeyListener(new KeyAdapter() { // from class: Mantenimiento.JIFEquiposdebaja.14
            public void keyReleased(KeyEvent evt) {
                JIFEquiposdebaja.this.totalKeyReleased(evt);
            }
        });
        this.jPanel20.add(this.total, new AbsoluteConstraints(940, 630, 120, 50));
        this.jLabel1.setFont(new Font("Arial", 1, 18));
        this.jLabel1.setText("Total Equipos Inactivos");
        this.jPanel20.add(this.jLabel1, new AbsoluteConstraints(720, 650, -1, -1));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel20, -1, 1077, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel20, -1, 698, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaequiposMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablaequipos.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablaequipos.getSelectedRow(), 0).toString());
        }
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
    public void InactivoMouseClicked(MouseEvent evt) {
        crearGrid();
        cargarDatos(this.sql);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ActivoMouseClicked(MouseEvent evt) {
        crearGrid();
        cargarDatos(this.sql);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void InactivoActionPerformed(ActionEvent evt) {
        this.jLabel1.setText("Total Equipos Inactivos");
        crearGrid();
        cargarDatos(this.sql);
        consultar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ActivoActionPerformed(ActionEvent evt) {
        this.jLabel1.setText("Total Equipos Activos");
        crearGrid();
        cargarDatos(this.sql);
        consultar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void totalCaretUpdate(CaretEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void totalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void totalFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void totalKeyReleased(KeyEvent evt) {
    }
}
