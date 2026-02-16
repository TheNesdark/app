package Sgc;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFFConsultasPyP.class */
public class JIFFConsultasPyP extends JInternalFrame {
    private String xNombre;
    private String xsql;
    private String xNombreCombo;
    private DefaultTableModel xModelo;
    private String[] xIdGenerico;
    private Object[] xDato;
    private JButton JBTExportar;
    private JComboBox JCBGenerico;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private boolean xLleno = false;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFFConsultasPyP(String xNombre, String xTitulo) {
        initComponents();
        setName(xNombre);
        this.xNombre = xNombre;
        setTitle(xTitulo.toUpperCase());
        mNuevo();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCBGenerico.setSelectedIndex(-1);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        switch (this.xNombre) {
            case "agudezaVisual":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
                mCrearModeloAgudezaVisual();
                this.xNombreCombo = "Empresa";
                break;
            case "planificacionFamiliar":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
                mCrearModeloPlanificacionFamiliar();
                this.xNombreCombo = "Empresa";
                break;
            case "jovenSano":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
                mCrearModeloJovenSano();
                this.xNombreCombo = "Empresa";
                break;
            case "adultoSano":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
                mCrearModeloAdultoSano();
                this.xNombreCombo = "Empresa";
                break;
            case "crecimientoYDesarrollo":
                this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
                mCrearModeloCrecimientoYDesarrollo();
                this.xNombreCombo = "Empresa";
                break;
        }
    }

    private void mLlenarCombo() {
        this.JCBGenerico.removeAllItems();
        switch (this.xNombre) {
            case "agudezaVisual":
                this.xIdGenerico = this.xct.llenarCombo("SELECT\nf_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre`\nFROM baseserver.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`h_atencion_test_agudezavisual`\n        ON (`h_atencion_test_agudezavisual`.`Id_Atencion` = `h_atencion`.`Id`)\n     INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n   \nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='08' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n     GROUP BY f_empresacontxconvenio.`Id`  ORDER BY f_empresacontxconvenio.`Nbre` ASC;", this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
                break;
            case "planificacionFamiliar":
                this.xIdGenerico = this.xct.llenarCombo("SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre`\n    \nFROM \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n     INNER JOIN `baseserver`.`h_tipometplanifica`\n        ON (`h_planificacion_fliar`.`IdMetodo` = h_tipometplanifica.`Id`)   \n        INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n     WHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n     GROUP BY f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre` ASC;", this.xIdGenerico, this.JCBGenerico);
                System.out.println("SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre`\n    \nFROM \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n     INNER JOIN `baseserver`.`h_tipometplanifica`\n        ON (`h_planificacion_fliar`.`IdMetodo` = h_tipometplanifica.`Id`)   \n        INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n     WHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n     GROUP BY f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre` ASC;");
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
                break;
            case "jovenSano":
                this.xIdGenerico = this.xct.llenarCombo("SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre`\nFROM baseserver.`g_ips`, `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='05' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n     GROUP BY f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre` ASC", this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
                break;
            case "adultoSano":
                this.xIdGenerico = this.xct.llenarCombo("SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre`\nFROM baseserver.`g_ips`, `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n WHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='07' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n    GROUP BY f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre` ASC", this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
                break;
            case "crecimientoYDesarrollo":
                this.xIdGenerico = this.xct.llenarCombo("SELECT `f_empresacontxconvenio`.`Id`,f_empresacontxconvenio.`Nbre` AS Empresa\n    \nFROM baseserver.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`g_nivelestudio`\n        ON (`g_nivelestudio`.`Id`= `ingreso`.`Id_NivelEstudio`)             \n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n     INNER JOIN `baseserver`.`h_examenfisico`\n        ON (`h_atencion`.`Id` = `h_examenfisico`.`Id_Atencion`)        \n WHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='04' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by Empresa ASC", this.xIdGenerico, this.JCBGenerico);
                this.JCBGenerico.setSelectedIndex(-1);
                this.xct.cerrarConexionBd();
                break;
        }
    }

    public void mBuscar() {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBGenerico.getSelectedIndex() != -1) {
                switch (this.xNombre) {
                    case "agudezaVisual":
                        mCargarDatosAgudezaVisual();
                        break;
                    case "planificacionFamiliar":
                        mCargarDatosPlanificacionFamiliar();
                        break;
                    case "jovenSano":
                        mCargarDatosJovenSano();
                        break;
                    case "adultoSano":
                        mCargarDatosAdultoSano();
                        break;
                    case "crecimientoYDesarrollo":
                        mCargarDatosCrecimientoYDesarrollo();
                        break;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar " + this.xNombreCombo, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBGenerico.requestFocus();
            return;
        }
        switch (this.xNombre) {
            case "agudezaVisual":
                mCargarDatosAgudezaVisual();
                break;
            case "planificacionFamiliar":
                mCargarDatosPlanificacionFamiliar();
                break;
            case "jovenSano":
                mCargarDatosJovenSano();
                break;
            case "adultoSano":
                mCargarDatosAdultoSano();
                break;
            case "crecimientoYDesarrollo":
                mCargarDatosCrecimientoYDesarrollo();
                break;
        }
    }

    private void mCrearModeloAgudezaVisual() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Regimen", "Departamento", "Municipio", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_TipoIdentificacion", "NoDocumento", "FechaNac", "Direccion", "Telefono", "FControl", "Msa_ODer", "Msa_OIzq", "Msa_AmbosO", "Mca_ODer", "Mca_OIzq", "Mca_AmbosO", "FIPlanificacionF", "FIngesoJovenSano", "FTomaCitologia", "FResultadoCitologia", "Tel_IPS", "EmpresaFacturo"}) { // from class: Sgc.JIFFConsultasPyP.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(50);
    }

    private void mCargarDatosAgudezaVisual() {
        mCrearModeloAgudezaVisual();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT\n     UCASE(`f_tiporegimen`.`Nbre`) AS `Regimen`\n    , UCASE(`g_departamento`.`Nbre`) AS `Departamento`\n    , `g_municipio`.`Nbre` AS `Municipio`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n  --  , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `g_persona`.`Direccion`\n    , IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`='', 'NO TIENE',  IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`=''), `g_persona`.`Telefono`, IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>''), `g_persona`.`Movil`, CONCAT(`g_persona`.`Telefono`, ' - ', `g_persona`.`Movil`))))  Telefono\n    , h_atencion.`Fecha_Atencion` FControl\n    , h_atencion_test_agudezavisual.`Msa_ODer`\n    , h_atencion_test_agudezavisual.`Msa_OIzq`\n    , h_atencion_test_agudezavisual.`Msa_AmbosO`\n    , h_atencion_test_agudezavisual.`Mca_ODer`\n    , h_atencion_test_agudezavisual.`Mca_OIzq`\n    , h_atencion_test_agudezavisual.`Mca_AmbosO`\n    -- informacion de ingreso al porgrama de planificacion familiar\n    , IFNULL((SELECT\n    MIN(`ingreso`.`FechaIngreso`) \nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n-- GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FIPlanificacionF\n\n-- informacion de joven sano\n\n, IFNULL((SELECT\n    MIN(`ingreso`.`FechaIngreso`) \nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='05' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n-- GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FIngesoJovenSano \n\n, IFNULL(ct.FToma, '') FTomaCitologia\n,  IFNULL(ct.FResultado, '') FResultadoCitologia, g_ips.`Telefono` AS Tel_IPS, f_empresacontxconvenio.`Nbre` AS EmpresaFacturo\n    \nFROM baseserver.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`h_atencion_test_agudezavisual`\n        ON (`h_atencion_test_agudezavisual`.`Id_Atencion` = `h_atencion`.`Id`)\n     \n        \n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n        -- CONSULTA DE PLANIFICACION FAMILIAR\n      LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03')\nGROUP BY `ingreso`.`Id_Usuario`) nc ON (nc.Id_Usuario=`g_usuario`.`Id_persona`)\n-- CONSULTA DE ADULTO JOVEN\n     LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='05')\nGROUP BY `ingreso`.`Id_Usuario`) ads ON (ads.Id_Usuario=`g_usuario`.`Id_persona`)\n\n-- DATOS DE CITOLOGIA        \n LEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , IFNULL(`l_resultados`.`FechaResult`, '') FResultado\n    , `l_recepcion`.`Id_Paciente`\n    , MAX(`l_recepcion_citologia`.`Id_Recepcion`)\nFROM\n    `baseserver`.`l_recepcion_citologia`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    LEFT JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0)\nGROUP BY `l_recepcion`.`Id_Paciente`)   ct ON(ct.Id_Paciente=`g_usuario`.`Id_persona`)    \n        \nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='08' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) \n    AND f_empresacontxconvenio.`Id`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "'\n    -- group by `g_usuario`.`Id_persona`;";
            } else {
                this.xsql = "SELECT\n     UCASE(`f_tiporegimen`.`Nbre`) AS `Regimen`\n    , UCASE(`g_departamento`.`Nbre`) AS `Departamento`\n    , `g_municipio`.`Nbre` AS `Municipio`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n  --  , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `g_persona`.`Direccion`\n    , IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`='', 'NO TIENE',  IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`=''), `g_persona`.`Telefono`, IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>''), `g_persona`.`Movil`, CONCAT(`g_persona`.`Telefono`, ' - ', `g_persona`.`Movil`))))  Telefono\n    , h_atencion.`Fecha_Atencion` FControl\n    , h_atencion_test_agudezavisual.`Msa_ODer`\n    , h_atencion_test_agudezavisual.`Msa_OIzq`\n    , h_atencion_test_agudezavisual.`Msa_AmbosO`\n    , h_atencion_test_agudezavisual.`Mca_ODer`\n    , h_atencion_test_agudezavisual.`Mca_OIzq`\n    , h_atencion_test_agudezavisual.`Mca_AmbosO`\n    -- informacion de ingreso al porgrama de planificacion familiar\n    , IFNULL((SELECT\n    MIN(`ingreso`.`FechaIngreso`) \nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n-- GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FIPlanificacionF\n\n-- informacion de joven sano\n\n, IFNULL((SELECT\n    MIN(`ingreso`.`FechaIngreso`) \nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='05' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n-- GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FIngesoJovenSano \n\n, IFNULL(ct.FToma, '') FTomaCitologia\n,  IFNULL(ct.FResultado, '') FResultadoCitologia, g_ips.`Telefono` as Tel_IPS, f_empresacontxconvenio.`Nbre` AS EmpresaFacturo\n    \nFROM baseserver.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`h_atencion_test_agudezavisual`\n        ON (`h_atencion_test_agudezavisual`.`Id_Atencion` = `h_atencion`.`Id`)\n     \n        \n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n        -- CONSULTA DE PLANIFICACION FAMILIAR\n      LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03')\nGROUP BY `ingreso`.`Id_Usuario`) nc ON (nc.Id_Usuario=`g_usuario`.`Id_persona`)\n-- CONSULTA DE ADULTO JOVEN\n     LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='05')\nGROUP BY `ingreso`.`Id_Usuario`) ads ON (ads.Id_Usuario=`g_usuario`.`Id_persona`)\n\n-- DATOS DE CITOLOGIA        \n LEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , IFNULL(`l_resultados`.`FechaResult`, '') FResultado\n    , `l_recepcion`.`Id_Paciente`\n    , MAX(`l_recepcion_citologia`.`Id_Recepcion`)\nFROM\n    `baseserver`.`l_recepcion_citologia`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    LEFT JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0)\nGROUP BY `l_recepcion`.`Id_Paciente`)   ct ON(ct.Id_Paciente=`g_usuario`.`Id_persona`)    \n        \nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='08' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n    -- group by `g_usuario`.`Id_persona`;";
            }
            System.out.println("Agudeza Visual   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloPlanificacionFamiliar() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Regimen", "Departamento", "NoDocumento", "Id_TipoIdentificacion", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "FechaNac", "Edad", "Municipio", "Barrio", "Zona", "Etnia", "EstadoCivil", "Telefono", "Direccion", "FUM", "No_G", "No_P", "No_A", "No_C", "No_V", "No_M", "NControles", "FUltimoControl", "MetodoPlanificacion", "NControlesJovenSano", "FIngesoJovenSano", "FTomaCitologia", "FResultadoCitologia", "EmpresaFacturo", "Clase Cita", "Especialidad", "Profesional", "Peso", "Talla", "Imc", "AutoExamenSeno", "EPS"}) { // from class: Sgc.JIFFConsultasPyP.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
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
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(100);
    }

    private void mCargarDatosPlanificacionFamiliar() {
        mCrearModeloPlanificacionFamiliar();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT\n     UCASE(`f_tiporegimen`.`Nbre`) AS `Regimen`\n    , UCASE(`g_departamento`.`Nbre`) AS `Departamento`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`FechaNac`\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `g_municipio`.`Nbre` AS `Municipio`\n    , `g_barrio`.`Nbre` AS `Barrio`\n    , `g_barrio`.`Zona`\n    , `g_tipo_etnia`.`Nbre` AS `Etnia`\n    ,`g_estadocivil`.`Nbre` AS `estadoCivil`\n    , IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`='', 'NO TIENE',  IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`=''), `g_persona`.`Telefono`, IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>''), `g_persona`.`Movil`, CONCAT(`g_persona`.`Telefono`, ' - ', `g_persona`.`Movil`))))  Telefono\n    , `g_persona`.`Direccion`\n    , IFNULL(`h_antecedenteginecologico`.`FUM`, '1800-01-01') FUM\n    , `h_antecedenteginecologico`.`No_G`\n    , `h_antecedenteginecologico`.`No_P`\n    , `h_antecedenteginecologico`.`No_A`\n    , `h_antecedenteginecologico`.`No_C`\n    , `h_antecedenteginecologico`.`No_V`\n    , `h_antecedenteginecologico`.`No_M`\n    , IFNULL(nc.Cantidad,0) NControles\n    , (SELECT\n    MAX(`ingreso`.`FechaIngreso`) \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n-- GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` DESC) FUltimoControl\n, h_tipometplanifica.`Nbre` MetodoPlanificacion\n-- informacion de joven sano\n,  IFNULL(ads.Cantidad,0) NControlesJovenSano\n, IFNULL((SELECT\n    MIN(`ingreso`.`FechaIngreso`) \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='05' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n-- GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FIngesoJovenSano \n\n, IFNULL(ct.FToma, '') FTomaCitologia\n,  IFNULL(ct.FResultado, '') FResultadoCitologia, g_ips.`Telefono` AS Tel_IPS, f_empresacontxconvenio.`Nbre` AS EmpresaFacturo\n,     c_clasecita.`Nbre` ClaseCita\n, g_especialidad.`Nbre` Especialidad\n, CONCAT(profesional.`Apellido1`, ' ', profesional.`Apellido2`, ' ',profesional.`Nombre1`, ' ',profesional.`Nombre2`) Profesional\n, IFNULL(h_examenfisico.`Peso`, 0) Peso\n, IFNULL(h_examenfisico.`Talla`,0) Talla\n, IFNULL(h_examenfisico.`IMC`,0) IMC,IFNULL(h_examenfisico.`AutoExamenSeno`,'NO') AutoExamenseno\n, `f_empresacontxconvenio`.Nbre\nFROM baseserver.`g_ips`, \n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `g_barrio` \n        ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n    INNER JOIN  `g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n     INNER JOIN  `h_tipometplanifica`\n        ON (`h_planificacion_fliar`.`IdMetodo` = h_tipometplanifica.`Id`)   \n        \n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n        INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\n     INNER JOIN  `g_persona` profesional\n        ON (`profesional`.`Id`= `h_atencion`.`Id_Profesional`)\n        LEFT JOIN `h_examenfisico` ON (h_examenfisico.`Id_Atencion`=`h_atencion`.`Id`)\n     LEFT JOIN `g_tipo_etnia`\n         ON (`g_persona`.`Id_Etnia` = `g_tipo_etnia`.`Id`)\n     LEFT JOIN `g_estadocivil`\n         ON (`g_persona`.`Id_EstadoCivil` = `g_estadocivil`.`Id`)\n     LEFT JOIN `h_antecedenteginecologico`\n        ON (`h_atencion`.`Id` = `h_antecedenteginecologico`.`Id_Atencion`)\n      LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03')\nGROUP BY `ingreso`.`Id_Usuario`) nc ON (nc.Id_Usuario=`g_usuario`.`Id_persona`)\n\n     LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='05')\nGROUP BY `ingreso`.`Id_Usuario`) ads ON (ads.Id_Usuario=`g_usuario`.`Id_persona`)\n        \n LEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , IFNULL(`l_resultados`.`FechaResult`, '') FResultado\n    , `l_recepcion`.`Id_Paciente`\n    , MAX(`l_recepcion_citologia`.`Id_Recepcion`)\nFROM\n     `l_recepcion_citologia`\n    INNER JOIN  `l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    LEFT JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0)\nGROUP BY `l_recepcion`.`Id_Paciente`)   ct ON(ct.Id_Paciente=`g_usuario`.`Id_persona`)    WHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03' \n    AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) \n    AND f_empresacontxconvenio.`Id`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "'\n     GROUP BY `g_usuario`.`Id_persona`;";
            } else {
                this.xsql = "SELECT\n     UCASE(`f_tiporegimen`.`Nbre`) AS `Regimen`\n    , UCASE(`g_departamento`.`Nbre`) AS `Departamento`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`FechaNac`\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `g_municipio`.`Nbre` AS `Municipio`\n    , `g_barrio`.`Nbre` AS `Barrio`\n    , `f_empresacontxconvenio`.`Nbre` AS EPS\n    , `g_tipo_etnia`.`Nbre` AS `Etnia`\n    , `g_estadocivil`.`Nbre` AS `estadoCivil`\n    , IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`='', 'NO TIENE',  IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`=''), `g_persona`.`Telefono`, IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>''), `g_persona`.`Movil`, CONCAT(`g_persona`.`Telefono`, ' - ', `g_persona`.`Movil`))))  Telefono\n    , `g_persona`.`Direccion`\n    , IFNULL(`h_antecedenteginecologico`.`FUM`, '1800-01-01') FUM\n    , `h_antecedenteginecologico`.`No_G`\n    , `h_antecedenteginecologico`.`No_P`\n    , `h_antecedenteginecologico`.`No_A`\n    , `h_antecedenteginecologico`.`No_C`\n    , `h_antecedenteginecologico`.`No_V`\n    , `h_antecedenteginecologico`.`No_M`\n    , IFNULL(nc.Cantidad,0) NControles\n    , (SELECT\n    MAX(`ingreso`.`FechaIngreso`) \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n-- GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` DESC) FUltimoControl\n, h_tipometplanifica.`Nbre` MetodoPlanificacion\n-- informacion de joven sano\n,  IFNULL(ads.Cantidad,0) NControlesJovenSano\n, IFNULL((SELECT\n    MIN(`ingreso`.`FechaIngreso`) \nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='05' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n-- GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FIngesoJovenSano \n\n, IFNULL(ct.FToma, '') FTomaCitologia\n,  IFNULL(ct.FResultado, '') FResultadoCitologia, g_ips.`Telefono` AS Tel_IPS, f_empresacontxconvenio.`Nbre` AS EmpresaFacturo\n,     c_clasecita.`Nbre` ClaseCita\n, g_especialidad.`Nbre` Especialidad\n, CONCAT(profesional.`Apellido1`, ' ', profesional.`Apellido2`, ' ',profesional.`Nombre1`, ' ',profesional.`Nombre2`) Profesional\n, IFNULL(h_examenfisico.`Peso`, 0) Peso\n, IFNULL(h_examenfisico.`Talla`,0) Talla\n, IFNULL(h_examenfisico.`IMC`,0) IMC,IFNULL(h_examenfisico.`AutoExamenSeno`,'NO') AutoExamenseno\nFROM baseserver.`g_ips`, \n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `g_barrio` \n        ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n    INNER JOIN  `g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN  `f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n     INNER JOIN  `h_tipometplanifica`\n        ON (`h_planificacion_fliar`.`IdMetodo` = h_tipometplanifica.`Id`)   \n        \n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n        INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\n     INNER JOIN  `g_persona` profesional\n        ON (`profesional`.`Id`= `h_atencion`.`Id_Profesional`)\n        LEFT JOIN `h_examenfisico` ON (h_examenfisico.`Id_Atencion`=`h_atencion`.`Id`)\n     LEFT JOIN `g_tipo_etnia`\n         ON (`g_persona`.`Id_Etnia` = `g_tipo_etnia`.`Id`)\n     LEFT JOIN `g_estadocivil`\n         ON (`g_persona`.`Id_EstadoCivil` = `g_estadocivil`.`Id`)\n     LEFT JOIN `h_antecedenteginecologico`\n        ON (`h_atencion`.`Id` = `h_antecedenteginecologico`.`Id_Atencion`)\n      LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03')\nGROUP BY `ingreso`.`Id_Usuario`) nc ON (nc.Id_Usuario=`g_usuario`.`Id_persona`)\n\n     LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='05')\nGROUP BY `ingreso`.`Id_Usuario`) ads ON (ads.Id_Usuario=`g_usuario`.`Id_persona`)\n        \n LEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , IFNULL(`l_resultados`.`FechaResult`, '') FResultado\n    , `l_recepcion`.`Id_Paciente`\n    , MAX(`l_recepcion_citologia`.`Id_Recepcion`)\nFROM\n     `l_recepcion_citologia`\n    INNER JOIN  `l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    LEFT JOIN  `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0)\nGROUP BY `l_recepcion`.`Id_Paciente`)   ct ON(ct.Id_Paciente=`g_usuario`.`Id_persona`)    WHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03' \n    AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' \n    ) GROUP BY `g_usuario`.`Id_persona`;";
            }
            System.out.println("Planificación Familiar  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    this.xModelo.setValueAt(rs.getString(27), n, 26);
                    this.xModelo.setValueAt(rs.getString(28), n, 27);
                    this.xModelo.setValueAt(rs.getString(29), n, 28);
                    this.xModelo.setValueAt(rs.getString(30), n, 29);
                    this.xModelo.setValueAt(rs.getString(31), n, 30);
                    this.xModelo.setValueAt(rs.getString(32), n, 31);
                    this.xModelo.setValueAt(rs.getString("ClaseCita"), n, 32);
                    this.xModelo.setValueAt(rs.getString("Especialidad"), n, 33);
                    this.xModelo.setValueAt(rs.getString("Profesional"), n, 34);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Peso")), n, 35);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Talla")), n, 36);
                    this.xModelo.setValueAt(Double.valueOf(rs.getDouble("IMC")), n, 37);
                    this.xModelo.setValueAt(rs.getString("AutoExamenseno"), n, 38);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloJovenSano() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Regimen", "Departamento", "Municipio", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_TipoIdentificacion", "NoDocumento", "FechaNac", "Edad", "Direccion", "Telefono", "Movil", "FControl", "FechaHemoglobina", "ResultadoHemoglobina", "FechaColesterolHDL", "ResultadoColesterolHDL", "Fechahematocritos", "Resultadohematocritos", "FechaSerologia", "ResultadoSerologia", "FIPlanificacionF", "FIngesoJovenSano", "FTomaCitologia", "FResultadoCitologia", "Tel_IPS", "EmpresaFacturo"}) { // from class: Sgc.JIFFConsultasPyP.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(150);
    }

    private void mCargarDatosJovenSano() {
        mCrearModeloJovenSano();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT\n  UCASE(f_tiporegimen.Nbre) AS Regimen,\n  UCASE(g_departamento.Nbre) AS Departamento,\n  g_municipio.Nbre AS Municipio,\n  g_persona.Nombre1,\n  g_persona.Nombre2,\n  g_persona.Apellido1,\n  g_persona.Apellido2,\n  g_persona.Id_TipoIdentificacion,\n  g_persona.NoDocumento,\n  g_persona.FechaNac,\n  Devuelve_Edad_2F (g_persona.FechaNac,h_atencion.Fecha_Atencion) AS Edad,\n  g_persona.Direccion,\n  IF(g_persona.Telefono = '','NO TIENE',IFNULL(g_persona.Telefono,'NO TIENE')) AS Telefono,\n  IF(g_persona.Movil = '','NO TIENE',IFNULL(g_persona.Movil,'NO TIENE')) AS Movil,\n  -- IF(g_persona.Telefono = '' && g_persona.Movil = '','NO TIENE',IF((g_persona.Telefono <> '' && g_persona.Movil = ''),g_persona.Telefono,IF((g_persona.Telefono = '' && g_persona.Movil <> ''),g_persona.Movil,CONCAT(g_persona.Telefono,' - ',g_persona.Movil)))) Telefono,\n   h_atencion.Fecha_Atencion FControl,\n  IFNULL(hb.FToma,'') AS FechaHemoglobina,\n  IFNULL(hb.VrNumerico,'') AS ResultadoHemoglobina,-- informacion de ingreso al porgrama de planificacion familiar\n  IFNULL(hdl.FToma,'') AS FechaColesterolHDL,\n  IFNULL(hdl.VrNumerico,'') AS ResultadoColesterolHDL,\n  IFNULL(hematocritos.FToma,'') AS Fechahematocritos,\n  IFNULL(hematocritos.VrNumerico,'') AS Resultadohematocritos,\n  IFNULL(vdlr.FToma,'') AS FechaSerologia,\n  IFNULL(vdlr.VrNumerico,'') AS ResultadoSerologia,\n  IFNULL((SELECT MIN(ingreso.FechaIngreso)\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN h_planificacion_fliar ON (h_planificacion_fliar.IdAtencion = h_atencion.Id)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> ''\n AND c_clasecita.Id_Finalidad = '03'\n AND ingreso.Id_Usuario = g_persona.Id) -- GROUP BY ingreso.Id_Usuario\n     ORDER BY ingreso.FechaIngreso ASC),'') FIPlanificacionF,-- informacion de joven sano\n  IFNULL((SELECT\n      MIN(ingreso.FechaIngreso)\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN h_planificacion_fliar ON (h_planificacion_fliar.IdAtencion = h_atencion.Id)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> ''\n AND c_clasecita.Id_Finalidad = '05'\n AND ingreso.Id_Usuario = g_persona.Id) -- GROUP BY ingreso.Id_Usuario\n     ORDER BY ingreso.FechaIngreso ASC),'') FIngesoJovenSano,\n  IFNULL(ct.FToma,'') FTomaCitologia,\n  IFNULL(ct.FResultado,'') FResultadoCitologia,\n  g_ips.Telefono AS Tel_IPS,\n  f_empresacontxconvenio.Nbre AS EmpresaFacturo\nFROM  g_ips,h_atencion\n  INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n  INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n  INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n  INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id)\n  INNER JOIN g_municipio ON (g_persona.Id_Municipio = g_municipio.Id)\n  INNER JOIN g_departamento ON (g_municipio.Id_Dpto = g_departamento.Id)\n  INNER JOIN f_tiporegimen ON (f_empresacontxconvenio.Id_TipoRegimen = f_tiporegimen.Id)\n  INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id) -- CONSULTA DE PLANIFICACION FAMILIAR\n   LEFT JOIN    (SELECT ingreso.Id_Usuario,\n      COUNT(ingreso.Id) AS Cantidad\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN h_planificacion_fliar ON (h_planificacion_fliar.IdAtencion = h_atencion.Id)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> '' AND c_clasecita.Id_Finalidad = '03')\n    GROUP BY ingreso.Id_Usuario) nc ON (nc.Id_Usuario = g_usuario.Id_persona) -- CONSULTA DE ADULTO JOVEN\n   LEFT JOIN    (SELECT ingreso.Id_Usuario,\n      COUNT(ingreso.Id) AS Cantidad\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN h_planificacion_fliar ON (h_planificacion_fliar.IdAtencion = h_atencion.Id)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> '' AND c_clasecita.Id_Finalidad = '05')\n    GROUP BY ingreso.Id_Usuario) ads ON (ads.Id_Usuario = g_usuario.Id_persona)\n  LEFT JOIN    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (1,2))\n    GROUP BY l_recepcion.Id_Paciente) hb ON (hb.Id_Paciente = g_usuario.Id_persona) -- hdl 56\n   LEFT JOIN    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (56))\n    GROUP BY l_recepcion.Id_Paciente) hdl ON (hdl.Id_Paciente = g_usuario.Id_persona) -- hematocritos 3\n   LEFT JOIN    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (3))\n    GROUP BY l_recepcion.Id_Paciente) hematocritos ON (hematocritos.Id_Paciente = g_usuario.Id_persona) -- vdlr serologia 276\n   LEFT JOIN    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (276))\n    GROUP BY l_recepcion.Id_Paciente) vdlr ON (vdlr.Id_Paciente = g_usuario.Id_persona) -- DATOS DE CITOLOGIA        \n   LEFT JOIN\n    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      IFNULL(l_resultados.FechaResult,'') FResultado,\n      l_recepcion.Id_Paciente,\n      MAX(l_recepcion_citologia.Id_Recepcion)\n    FROM l_recepcion_citologia\n      INNER JOIN l_recepcion ON (l_recepcion_citologia.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detallerecepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      LEFT JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n    WHERE (l_recepcion.Estado = 0)\n    GROUP BY l_recepcion.Id_Paciente) ct ON (ct.Id_Paciente = g_usuario.Id_persona)\nWHERE (h_atencion.Codigo_Dxp <> ''\n    AND c_clasecita.Id_Finalidad = '05'\n    AND ingreso.FechaIngreso >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND ingreso.FechaIngreso <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND f_empresacontxconvenio.Id = '" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "'); ";
            } else {
                this.xsql = "SELECT\n  UCASE(f_tiporegimen.Nbre) AS Regimen,\n  UCASE(g_departamento.Nbre) AS Departamento,\n  g_municipio.Nbre AS Municipio,\n  g_persona.Nombre1,\n  g_persona.Nombre2,\n  g_persona.Apellido1,\n  g_persona.Apellido2,\n  g_persona.Id_TipoIdentificacion,\n  g_persona.NoDocumento,\n  g_persona.FechaNac,\n  Devuelve_Edad_2F (g_persona.FechaNac,h_atencion.Fecha_Atencion) AS Edad,\n  g_persona.Direccion,\n  IF(g_persona.Telefono = '','NO TIENE',IFNULL(g_persona.Telefono,'NO TIENE')) AS Telefono,\n  IF(g_persona.Movil = '','NO TIENE',IFNULL(g_persona.Movil,'NO TIENE')) AS Movil,\n  -- IF(g_persona.Telefono = '' && g_persona.Movil = '','NO TIENE',IF((g_persona.Telefono <> '' && g_persona.Movil = ''),g_persona.Telefono,IF((g_persona.Telefono = '' && g_persona.Movil <> ''),g_persona.Movil,CONCAT(g_persona.Telefono,' - ',g_persona.Movil)))) Telefono,\n   h_atencion.Fecha_Atencion FControl,\n  IFNULL(hb.FToma,'') AS FechaHemoglobina,\n  IFNULL(hb.VrNumerico,'') AS ResultadoHemoglobina,-- informacion de ingreso al porgrama de planificacion familiar\n  IFNULL(hdl.FToma,'') AS FechaColesterolHDL,\n  IFNULL(hdl.VrNumerico,'') AS ResultadoColesterolHDL,\n  IFNULL(hematocritos.FToma,'') AS Fechahematocritos,\n  IFNULL(hematocritos.VrNumerico,'') AS Resultadohematocritos,\n  IFNULL(vdlr.FToma,'') AS FechaSerologia,\n  IFNULL(vdlr.VrNumerico,'') AS ResultadoSerologia,\n  IFNULL((SELECT MIN(ingreso.FechaIngreso)\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN h_planificacion_fliar ON (h_planificacion_fliar.IdAtencion = h_atencion.Id)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> ''\n AND c_clasecita.Id_Finalidad = '03'\n AND ingreso.Id_Usuario = g_persona.Id) -- GROUP BY ingreso.Id_Usuario\n     ORDER BY ingreso.FechaIngreso ASC),'') FIPlanificacionF,-- informacion de joven sano\n  IFNULL((SELECT\n      MIN(ingreso.FechaIngreso)\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN h_planificacion_fliar ON (h_planificacion_fliar.IdAtencion = h_atencion.Id)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> ''\n AND c_clasecita.Id_Finalidad = '05'\n AND ingreso.Id_Usuario = g_persona.Id) -- GROUP BY ingreso.Id_Usuario\n     ORDER BY ingreso.FechaIngreso ASC),'') FIngesoJovenSano,\n  IFNULL(ct.FToma,'') FTomaCitologia,\n  IFNULL(ct.FResultado,'') FResultadoCitologia,\n  g_ips.Telefono AS Tel_IPS,\n  f_empresacontxconvenio.Nbre AS EmpresaFacturo\nFROM  g_ips,h_atencion\n  INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n  INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n  INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n  INNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id)\n  INNER JOIN g_municipio ON (g_persona.Id_Municipio = g_municipio.Id)\n  INNER JOIN g_departamento ON (g_municipio.Id_Dpto = g_departamento.Id)\n  INNER JOIN f_tiporegimen ON (f_empresacontxconvenio.Id_TipoRegimen = f_tiporegimen.Id)\n  INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id) -- CONSULTA DE PLANIFICACION FAMILIAR\n   LEFT JOIN    (SELECT ingreso.Id_Usuario,\n      COUNT(ingreso.Id) AS Cantidad\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN h_planificacion_fliar ON (h_planificacion_fliar.IdAtencion = h_atencion.Id)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> '' AND c_clasecita.Id_Finalidad = '03')\n    GROUP BY ingreso.Id_Usuario) nc ON (nc.Id_Usuario = g_usuario.Id_persona) -- CONSULTA DE ADULTO JOVEN\n   LEFT JOIN    (SELECT ingreso.Id_Usuario,\n      COUNT(ingreso.Id) AS Cantidad\n    FROM h_atencion\n      INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id)\n      INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n      INNER JOIN h_planificacion_fliar ON (h_planificacion_fliar.IdAtencion = h_atencion.Id)\n      INNER JOIN c_clasecita ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\n    WHERE (h_atencion.Codigo_Dxp <> '' AND c_clasecita.Id_Finalidad = '05')\n    GROUP BY ingreso.Id_Usuario) ads ON (ads.Id_Usuario = g_usuario.Id_persona)\n  LEFT JOIN    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (1,2))\n    GROUP BY l_recepcion.Id_Paciente) hb ON (hb.Id_Paciente = g_usuario.Id_persona) -- hdl 56\n   LEFT JOIN    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (56))\n    GROUP BY l_recepcion.Id_Paciente) hdl ON (hdl.Id_Paciente = g_usuario.Id_persona) -- hematocritos 3\n   LEFT JOIN    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (3))\n    GROUP BY l_recepcion.Id_Paciente) hematocritos ON (hematocritos.Id_Paciente = g_usuario.Id_persona) -- vdlr serologia 276\n   LEFT JOIN    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      l_recepcion.Id_Paciente,\n      l_detalleresultado.VrNumerico,\n      MAX(l_recepcion.Id)\n    FROM l_detallerecepcion\n      INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detalleresultado ON (l_detalleresultado.Id_Procedimiento = l_detallerecepcion.Id_Procedim) AND (l_detalleresultado.Id_Resultado = l_resultados.Id)\n      INNER JOIN l_protocoloxprocedimiento ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id)\n    WHERE (l_recepcion.Estado = 0 AND l_protocoloxprocedimiento.Id_Protocolo IN (276))\n    GROUP BY l_recepcion.Id_Paciente) vdlr ON (vdlr.Id_Paciente = g_usuario.Id_persona) -- DATOS DE CITOLOGIA        \n   LEFT JOIN\n    (SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%Y-%m-%d') AS FToma,\n      IFNULL(l_resultados.FechaResult,'') FResultado,\n      l_recepcion.Id_Paciente,\n      MAX(l_recepcion_citologia.Id_Recepcion)\n    FROM l_recepcion_citologia\n      INNER JOIN l_recepcion ON (l_recepcion_citologia.Id_Recepcion = l_recepcion.Id)\n      INNER JOIN l_detallerecepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id)\n      LEFT JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id)\n    WHERE (l_recepcion.Estado = 0)\n    GROUP BY l_recepcion.Id_Paciente) ct ON (ct.Id_Paciente = g_usuario.Id_persona)\nWHERE (h_atencion.Codigo_Dxp <> ''\n    AND c_clasecita.Id_Finalidad = '05'\n    AND ingreso.FechaIngreso >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND ingreso.FechaIngreso <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ); ";
            }
            System.out.println("Joven Sano  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 21);
                    this.xModelo.setValueAt(rs.getString(24), n, 21);
                    this.xModelo.setValueAt(rs.getString(25), n, 21);
                    this.xModelo.setValueAt(rs.getString(26), n, 21);
                    this.xModelo.setValueAt(rs.getString(27), n, 21);
                    this.xModelo.setValueAt(rs.getString(28), n, 21);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloAdultoSano() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Regimen", "Departamento", "Municipio", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_TipoIdentificacion", "NoDocumento", "FechaNac", "Direccion", "Telefono", "FControl", "FechaTColesterolT", "ResultadoColesterolT", "FechaTColesterolHDL", "ResultadoColesterolHDL", "FechaTColesterolLDL", "ResultadoColesterolLDL", "FechaCreatinina", "ResultadoCreatinina", "FechaGlicemia", "ResultadoGlicemia", "FTomaCitologia", "FResultadoCitologia", "NIps", "DireccionIps", "Tel_IPS", "EmpresaFacturo"}) { // from class: Sgc.JIFFConsultasPyP.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(50);
    }

    private void mCargarDatosAdultoSano() {
        mCrearModeloAdultoSano();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT\n     UCASE(`f_tiporegimen`.`Nbre`) AS `Regimen`\n    , UCASE(`g_departamento`.`Nbre`) AS `Departamento`\n    , `g_municipio`.`Nbre` AS `Municipio`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n  --  , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `g_persona`.`Direccion`\n    , IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`='', 'NO TIENE',  IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`=''), `g_persona`.`Telefono`, IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>''), `g_persona`.`Movil`, CONCAT(`g_persona`.`Telefono`, ' - ', `g_persona`.`Movil`))))  Telefono\n    , h_atencion.`Fecha_Atencion` FControl\n   , IFNULL(ColT.FToma,'') AS FechaTColesterolT\n   , IFNULL(ColT.VrNumerico ,'') AS ResultadoColesterolT\n   , IFNULL(CTH.FToma,'') AS FechaTColesterolHDL\n   , IFNULL(CTH.VrNumerico ,'') AS ResultadoColesterolHDL\n, IFNULL(CTL.FToma,'') AS FechaTColesterolLDL\n   , IFNULL(CTL.VrNumerico ,'') AS ResultadoColesterolLDL\n      , IFNULL(CRE.FToma,'') AS FechaCreatinina\n   , IFNULL(CRE.VrNumerico ,'') AS ResultadoCreatinina\n      , IFNULL(GLI.FToma,'') AS FechaGlicemia\n   , IFNULL(GLI.VrNumerico ,'') AS ResultadoGlicemia        \n, IFNULL(ct.FToma, '') FTomaCitologia\n,  IFNULL(ct.FResultado, '') FResultadoCitologia,g_ips.`Nbre` AS NIps, g_ips.`Direccion` DireccionIps, g_ips.`Telefono` as Tel_IPS, f_empresacontxconvenio.`Nbre` AS EmpresaFacturo\n    \nFROM baseserver.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n     \n        \n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n        -- CONSULTA DE PLANIFICACION FAMILIAR\n      LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03')\nGROUP BY `ingreso`.`Id_Usuario`) nc ON (nc.Id_Usuario=`g_usuario`.`Id_persona`)\n\n-- DATOS DE COLESTEROL TOTAL \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(55))\nGROUP BY `l_recepcion`.`Id_Paciente`)  ColT ON(ColT.Id_Paciente=`g_usuario`.`Id_persona`)    \n\n-- DATOS DE COLESTEROL HDL \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(56))\nGROUP BY `l_recepcion`.`Id_Paciente`)  CTH ON(CTH.Id_Paciente=`g_usuario`.`Id_persona`)   \n\n-- DATOS DE COLESTEROL LDL \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(57))\nGROUP BY `l_recepcion`.`Id_Paciente`)  CTL ON(CTL.Id_Paciente=`g_usuario`.`Id_persona`)   \n\n-- DATOS DE COLESTEROL CREATININA \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(241))\nGROUP BY `l_recepcion`.`Id_Paciente`)  CRE ON(CRE.Id_Paciente=`g_usuario`.`Id_persona`)  \n\n-- DATOS DE COLESTEROL GLICEMIA \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(283))\nGROUP BY `l_recepcion`.`Id_Paciente`)  GLI ON(GLI.Id_Paciente=`g_usuario`.`Id_persona`)  \n\n-- DATOS DE CITOLOGIA        \n LEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , IFNULL(`l_resultados`.`FechaResult`, '') FResultado\n    , `l_recepcion`.`Id_Paciente`\n    , MAX(`l_recepcion_citologia`.`Id_Recepcion`)\nFROM\n    `baseserver`.`l_recepcion_citologia`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    LEFT JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0)\nGROUP BY `l_recepcion`.`Id_Paciente`)   ct ON(ct.Id_Paciente=`g_usuario`.`Id_persona`)    \n        \n        \n        \nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='07' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n    AND f_empresacontxconvenio.`Id`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "'\n    -- group by `g_usuario`.`Id_persona`;";
            } else {
                this.xsql = "SELECT\n     UCASE(`f_tiporegimen`.`Nbre`) AS `Regimen`\n    , UCASE(`g_departamento`.`Nbre`) AS `Departamento`\n    , `g_municipio`.`Nbre` AS `Municipio`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n  --  , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    , `g_persona`.`Direccion`\n    , IF(`g_persona`.`Telefono`='' && `g_persona`.`Movil`='', 'NO TIENE',  IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`=''), `g_persona`.`Telefono`, IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>''), `g_persona`.`Movil`, CONCAT(`g_persona`.`Telefono`, ' - ', `g_persona`.`Movil`))))  Telefono\n    , h_atencion.`Fecha_Atencion` FControl\n   , IFNULL(ColT.FToma,'') AS FechaTColesterolT\n   , IFNULL(ColT.VrNumerico ,'') AS ResultadoColesterolT\n   , IFNULL(CTH.FToma,'') AS FechaTColesterolHDL\n   , IFNULL(CTH.VrNumerico ,'') AS ResultadoColesterolHDL\n, IFNULL(CTL.FToma,'') AS FechaTColesterolLDL\n   , IFNULL(CTL.VrNumerico ,'') AS ResultadoColesterolLDL\n      , IFNULL(CRE.FToma,'') AS FechaCreatinina\n   , IFNULL(CRE.VrNumerico ,'') AS ResultadoCreatinina\n      , IFNULL(GLI.FToma,'') AS FechaGlicemia\n   , IFNULL(GLI.VrNumerico ,'') AS ResultadoGlicemia        \n, IFNULL(ct.FToma, '') FTomaCitologia\n,  IFNULL(ct.FResultado, '') FResultadoCitologia,g_ips.`Nbre` AS NIps, g_ips.`Direccion` DireccionIps, g_ips.`Telefono` as Tel_IPS, f_empresacontxconvenio.`Nbre` AS EmpresaFacturo\n    \nFROM baseserver.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n     \n        \n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n        -- CONSULTA DE PLANIFICACION FAMILIAR\n      LEFT JOIN (SELECT\n    `ingreso`.`Id_Usuario`\n    , COUNT(`ingreso`.`Id`) AS `Cantidad`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_planificacion_fliar` \n        ON (`h_planificacion_fliar`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='03')\nGROUP BY `ingreso`.`Id_Usuario`) nc ON (nc.Id_Usuario=`g_usuario`.`Id_persona`)\n\n-- DATOS DE COLESTEROL TOTAL \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(55))\nGROUP BY `l_recepcion`.`Id_Paciente`)  ColT ON(ColT.Id_Paciente=`g_usuario`.`Id_persona`)    \n\n-- DATOS DE COLESTEROL HDL \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(56))\nGROUP BY `l_recepcion`.`Id_Paciente`)  CTH ON(CTH.Id_Paciente=`g_usuario`.`Id_persona`)   \n\n-- DATOS DE COLESTEROL LDL \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(57))\nGROUP BY `l_recepcion`.`Id_Paciente`)  CTL ON(CTL.Id_Paciente=`g_usuario`.`Id_persona`)   \n\n-- DATOS DE COLESTEROL CREATININA \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(241))\nGROUP BY `l_recepcion`.`Id_Paciente`)  CRE ON(CRE.Id_Paciente=`g_usuario`.`Id_persona`)  \n\n-- DATOS DE COLESTEROL GLICEMIA \nLEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , `l_recepcion`.`Id_Paciente`\n    , `l_detalleresultado`.`VrNumerico`, MAX(l_recepcion.`Id`)\nFROM\n    `baseserver`.`l_detallerecepcion`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Procedimiento` = `l_detallerecepcion`.`Id_Procedim`) AND (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `baseserver`.`l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocoloxprocedimiento`.`Id_Protocolo` IN(283))\nGROUP BY `l_recepcion`.`Id_Paciente`)  GLI ON(GLI.Id_Paciente=`g_usuario`.`Id_persona`)  \n\n-- DATOS DE CITOLOGIA        \n LEFT JOIN (SELECT\n    DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS `FToma`\n    , IFNULL(`l_resultados`.`FechaResult`, '') FResultado\n    , `l_recepcion`.`Id_Paciente`\n    , MAX(`l_recepcion_citologia`.`Id_Recepcion`)\nFROM\n    `baseserver`.`l_recepcion_citologia`\n    INNER JOIN `baseserver`.`l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `baseserver`.`l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    LEFT JOIN `baseserver`.`l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0)\nGROUP BY `l_recepcion`.`Id_Paciente`)   ct ON(ct.Id_Paciente=`g_usuario`.`Id_persona`)    \n        \n        \n        \nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='07' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n    -- group by `g_usuario`.`Id_persona`;";
            }
            System.out.println("Adulto Sano  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    this.xModelo.setValueAt(rs.getString(27), n, 26);
                    this.xModelo.setValueAt(rs.getString(28), n, 27);
                    this.xModelo.setValueAt(rs.getString(29), n, 28);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloCrecimientoYDesarrollo() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"CodigoOrganismo", "Id", "Id_Dpto", "Departamento", "Regimen", "Municipio", "EmpresaFacturo", "FIngreso", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Id_TIden", "NoDocumento", "FechaNac", "Edad", "Tipo_Edad", "Id_Sexo", "Nbre", "Direccion", "Telefono", "Celular", "I_Peso", "I_Talla", "FUControl", "FPControl", "Desparasitante", "Micronutriente", "VitaminaA", "FHigieOral", "NIps", "DireccionIps", "Tel_IPS", "Clase de Cita"}) { // from class: Sgc.JIFFConsultasPyP.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(500);
    }

    private void mCargarDatosCrecimientoYDesarrollo() {
        mCrearModeloCrecimientoYDesarrollo();
        try {
            this.xsql = null;
            if (this.JCHFiltro.isSelected() && this.xLleno) {
                this.xsql = "SELECT g_ips.`CodigoOrganismo`, g_municipio.`Id`, g_municipio.`Id_Dpto`, UCASE(`g_departamento`.`Nbre`) AS `Departamento`,\n     UCASE(`f_tiporegimen`.`Nbre`) AS `Regimen`    \n    , `g_municipio`.`Nbre` AS `Municipio`\n    , f_empresacontxconvenio.`Nbre` AS EmpresaFacturo\n  , IFNULL((SELECT\n    MIN(`ingreso`.`FechaIngreso`) \nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='04' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FIngreso\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`    \n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    \n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n    -- ,`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, FIngreso) Edad_Ingreso\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS Edad_Actual\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS TipoEdad\n    , g_persona.`Id_Sexo`\n    , g_nivelestudio.`Nbre` \n    , `g_persona`.`Direccion`,`g_persona`.`Telefono`, `g_persona`.`Movil`  Celular  \n    , h_examenfisico.`Peso` I_Peso\n    , h_examenfisico.`Talla` I_Talla\n    , IFNULL((SELECT\n    MAX(`ingreso`.`FechaIngreso`) \nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='04' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FUControl\n,IFNULL((SELECT\n    MAX(`c_citas`.`Fecha_Cita`)   \nFROM\n    `baseserver`.`c_citas`\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`c_citas`.`Fecha_Cita` >`ingreso`.`FechaIngreso`\n    AND `c_citas`.`Id_Usuario` =ingreso.`Id_Usuario`\n    AND `c_citas`.`Id_MotivoDesistida` =1\n    AND `c_clasecita`.`Id_Finalidad` ='04') GROUP BY `c_citas`.`Id_Usuario` ),'') FPControl  \n    \n-- DESPARASITANTE\n, IFNULL((SELECT\n    `h_ordenes`.`FechaOrden`\nFROM\n    `baseserver`.`h_ordenes`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `baseserver`.`i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcgrupofarmacologico` \n        ON (`i_atcsubgrupofarmacologico`.`IdGrupoFarmacologico` = `i_atcgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_clasecita`.`Id_Finalidad` ='04'\n    AND `i_atcgrupofarmacologico`.`Id` ='B03'\n    AND `ingreso`.`Id_Usuario` =`g_usuario`.`Id_persona`\n    AND `h_ordenes`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`),'') Desparasitante\n\n-- MICRONUTIENTE\n, IFNULL((SELECT\n    `h_ordenes`.`FechaOrden`\nFROM\n    `baseserver`.`h_ordenes`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `baseserver`.`i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcgrupofarmacologico` \n        ON (`i_atcsubgrupofarmacologico`.`IdGrupoFarmacologico` = `i_atcgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_clasecita`.`Id_Finalidad` ='04'\n    AND `i_atcgrupofarmacologico`.`Id` ='P02'\n    AND `ingreso`.`Id_Usuario` =`g_usuario`.`Id_persona`\n    AND `h_ordenes`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`),'') Micronutriente\n\n-- vITAMINA A\n, IFNULL((SELECT\n    `h_ordenes`.`FechaOrden`\nFROM\n    `baseserver`.`h_ordenes`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `baseserver`.`i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcgrupofarmacologico` \n        ON (`i_atcsubgrupofarmacologico`.`IdGrupoFarmacologico` = `i_atcgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_clasecita`.`Id_Finalidad` ='04'\n    AND `i_atcgrupofarmacologico`.`Id` ='A11'\n    AND `ingreso`.`Id_Usuario` =`g_usuario`.`Id_persona`\n    AND `h_ordenes`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`),'') VitaminaA\n    \n, IFNULL((SELECT\nMAX(`ingreso`.`FechaIngreso`) Fecha\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    \n    \n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (\n `h_atencion`.`Codigo_Dxp` <>''  AND\n\n (h_atencion.`Id_Especialidad`=1023 or h_atencion.`Id_Especialidad`=1032)  \n AND ingreso.`Id_Usuario`=`g_usuario`.`Id_persona`\n )\n GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` DESC     ) , '') FHigieOral\n    \n  ,g_ips.`Nbre` AS NIps, g_ips.`Direccion` DireccionIps, g_ips.`Telefono` as Tel_IPS\n  , c_clasecita.`Nbre` AS clasecita\n\n    \nFROM baseserver.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`g_nivelestudio`\n        ON (`g_nivelestudio`.`Id`= `ingreso`.`Id_NivelEstudio`)             \n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n     INNER JOIN `baseserver`.`h_examenfisico`\n        ON (`h_atencion`.`Id` = `h_examenfisico`.`Id_Atencion`)        \n \nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='04' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n    AND  f_empresacontxconvenio.`Id`='" + this.xIdGenerico[this.JCBGenerico.getSelectedIndex()] + "'\n    -- group by `g_usuario`.`Id_persona`;";
            } else {
                this.xsql = "SELECT g_ips.`CodigoOrganismo`, g_municipio.`Id`, g_municipio.`Id_Dpto`, UCASE(`g_departamento`.`Nbre`) AS `Departamento`,\n     UCASE(`f_tiporegimen`.`Nbre`) AS `Regimen`    \n    , `g_municipio`.`Nbre` AS `Municipio`\n    , f_empresacontxconvenio.`Nbre` AS EmpresaFacturo\n  , IFNULL((SELECT\n    MIN(`ingreso`.`FechaIngreso`) \nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='04' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FIngreso\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`    \n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    \n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n    -- ,`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, FIngreso) Edad_Ingreso\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS Edad_Actual\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS TipoEdad\n    , g_persona.`Id_Sexo`\n    , g_nivelestudio.`Nbre` \n    , `g_persona`.`Direccion`,`g_persona`.`Telefono`, `g_persona`.`Movil`  Celular  \n    , h_examenfisico.`Peso` I_Peso\n    , h_examenfisico.`Talla` I_Talla\n    , IFNULL((SELECT\n    MAX(`ingreso`.`FechaIngreso`) \nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='04' AND ingreso.`Id_Usuario`=g_persona.`Id`)\n GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` ASC),'') FUControl\n,IFNULL((SELECT\n    MAX(`c_citas`.`Fecha_Cita`)   \nFROM\n    `baseserver`.`c_citas`\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`c_citas`.`Fecha_Cita` >`ingreso`.`FechaIngreso`\n    AND `c_citas`.`Id_Usuario` =ingreso.`Id_Usuario`\n    AND `c_citas`.`Id_MotivoDesistida` =1\n    AND `c_clasecita`.`Id_Finalidad` ='04') GROUP BY `c_citas`.`Id_Usuario` ),'') FPControl  \n    \n-- DESPARASITANTE\n, IFNULL((SELECT\n    `h_ordenes`.`FechaOrden`\nFROM\n    `baseserver`.`h_ordenes`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `baseserver`.`i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcgrupofarmacologico` \n        ON (`i_atcsubgrupofarmacologico`.`IdGrupoFarmacologico` = `i_atcgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_clasecita`.`Id_Finalidad` ='04'\n    AND `i_atcgrupofarmacologico`.`Id` ='B03'\n    AND `ingreso`.`Id_Usuario` =`g_usuario`.`Id_persona`\n    AND `h_ordenes`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`),'') Desparasitante\n\n-- MICRONUTIENTE\n, IFNULL((SELECT\n    `h_ordenes`.`FechaOrden`\nFROM\n    `baseserver`.`h_ordenes`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `baseserver`.`i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcgrupofarmacologico` \n        ON (`i_atcsubgrupofarmacologico`.`IdGrupoFarmacologico` = `i_atcgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_clasecita`.`Id_Finalidad` ='04'\n    AND `i_atcgrupofarmacologico`.`Id` ='P02'\n    AND `ingreso`.`Id_Usuario` =`g_usuario`.`Id_persona`\n    AND `h_ordenes`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`),'') Micronutriente\n\n-- vITAMINA A\n, IFNULL((SELECT\n    `h_ordenes`.`FechaOrden`\nFROM\n    `baseserver`.`h_ordenes`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `baseserver`.`i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`i_atcgrupofarmacologico` \n        ON (`i_atcsubgrupofarmacologico`.`IdGrupoFarmacologico` = `i_atcgrupofarmacologico`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_clasecita`.`Id_Finalidad` ='04'\n    AND `i_atcgrupofarmacologico`.`Id` ='A11'\n    AND `ingreso`.`Id_Usuario` =`g_usuario`.`Id_persona`\n    AND `h_ordenes`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`),'') VitaminaA\n    \n, IFNULL((SELECT\nMAX(`ingreso`.`FechaIngreso`) Fecha\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    \n    \n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (\n `h_atencion`.`Codigo_Dxp` <>''  AND\n\n (h_atencion.`Id_Especialidad`=1023 or h_atencion.`Id_Especialidad`=1032 ) \n AND ingreso.`Id_Usuario`=`g_usuario`.`Id_persona`\n )\n GROUP BY `ingreso`.`Id_Usuario`\nORDER  BY  `ingreso`.`FechaIngreso` DESC     ) , '') FHigieOral\n    \n  ,g_ips.`Nbre` AS NIps, g_ips.`Direccion` DireccionIps, g_ips.`Telefono` as Tel_IPS\n  , c_clasecita.`Nbre` AS clasecita\n    \nFROM baseserver.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `baseserver`.`g_nivelestudio`\n        ON (`g_nivelestudio`.`Id`= `ingreso`.`Id_NivelEstudio`)             \n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n     INNER JOIN `baseserver`.`h_examenfisico`\n        ON (`h_atencion`.`Id` = `h_examenfisico`.`Id_Atencion`)        \nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `c_clasecita`.`Id_Finalidad` ='04' \n      AND ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND ingreso.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') \n    -- group by `g_usuario`.`Id_persona`;";
            }
            System.out.println("Crecimiento y Desarrollo  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(rs.getString(1), n, 0);
                    this.xModelo.setValueAt(rs.getString(2), n, 1);
                    this.xModelo.setValueAt(rs.getString(3), n, 2);
                    this.xModelo.setValueAt(rs.getString(4), n, 3);
                    this.xModelo.setValueAt(rs.getString(5), n, 4);
                    this.xModelo.setValueAt(rs.getString(6), n, 5);
                    this.xModelo.setValueAt(rs.getString(7), n, 6);
                    this.xModelo.setValueAt(rs.getString(8), n, 7);
                    this.xModelo.setValueAt(rs.getString(9), n, 8);
                    this.xModelo.setValueAt(rs.getString(10), n, 9);
                    this.xModelo.setValueAt(rs.getString(11), n, 10);
                    this.xModelo.setValueAt(rs.getString(12), n, 11);
                    this.xModelo.setValueAt(rs.getString(13), n, 12);
                    this.xModelo.setValueAt(rs.getString(14), n, 13);
                    this.xModelo.setValueAt(rs.getString(15), n, 14);
                    this.xModelo.setValueAt(rs.getString(16), n, 15);
                    this.xModelo.setValueAt(rs.getString(17), n, 16);
                    this.xModelo.setValueAt(rs.getString(18), n, 17);
                    this.xModelo.setValueAt(rs.getString(19), n, 18);
                    this.xModelo.setValueAt(rs.getString(20), n, 19);
                    this.xModelo.setValueAt(rs.getString(21), n, 20);
                    this.xModelo.setValueAt(rs.getString(22), n, 21);
                    this.xModelo.setValueAt(rs.getString(23), n, 22);
                    this.xModelo.setValueAt(rs.getString(24), n, 23);
                    this.xModelo.setValueAt(rs.getString(25), n, 24);
                    this.xModelo.setValueAt(rs.getString(26), n, 25);
                    this.xModelo.setValueAt(rs.getString(27), n, 26);
                    this.xModelo.setValueAt(rs.getString(28), n, 27);
                    this.xModelo.setValueAt(rs.getString(29), n, 28);
                    this.xModelo.setValueAt(rs.getString(30), n, 29);
                    this.xModelo.setValueAt(rs.getString(31), n, 30);
                    this.xModelo.setValueAt(rs.getString(32), n, 31);
                    this.xModelo.setValueAt(rs.getString(33), n, 32);
                    this.xModelo.setValueAt(rs.getString(34), n, 33);
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConsultasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBGenerico = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFFConsultasPyP.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFConsultasPyP.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFFConsultasPyP.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFConsultasPyP.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setToolTipText("");
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Generico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.blue);
        this.JCHFiltro.setText("Aplicar Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Sgc.JIFFConsultasPyP.8
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultasPyP.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGenerico, -2, 715, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap(-1, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGroup(JPDatosLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltro).addComponent(this.JCBGenerico, -2, 50, -2)))).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFFConsultasPyP.9
            public void mouseClicked(MouseEvent evt) {
                JIFFConsultasPyP.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Sgc.JIFFConsultasPyP.10
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultasPyP.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sgc.JIFFConsultasPyP.11
            public void actionPerformed(ActionEvent evt) {
                JIFFConsultasPyP.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 599, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -1, 319, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -1, 53, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addGap(0, 10, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPExportar, -2, -1, -2).addComponent(this.JSPDetalle).addComponent(this.JPDatos, -2, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 344, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPExportar, -2, -1, -2).addGap(0, 1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xLleno) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xLleno) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        this.xLleno = this.JCHFiltro.isSelected();
        mLlenarCombo();
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), "CONSULTAS");
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }
}
