package Sig;

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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultarInfR4505.class */
public class JIFConsultarInfR4505 extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    public String resolucion;
    private String[][] xidempresa;
    private String[] xIdMunicipio;
    private File xfile;
    private ButtonGroup JBGForma;
    private ButtonGroup JBGOpciones;
    private ButtonGroup JBG_Filtro;
    private JButton JBTGenerar;
    private JComboBox JCBEmpresa;
    private JComboBox JCB_MUnicipio;
    private JCheckBox JCHEstado;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDetalle;
    private JPanel JPIForma;
    private JPanel JPIPreparacion;
    private JPanel JPI_Filtro;
    private JRadioButton JRBFormaA;
    private JRadioButton JRBFormaB;
    private JRadioButton JRB_Departamento;
    private JRadioButton JRB_Municipio;
    private JRadioButton JRB_NoAplica;
    private JRadioButton JRB_V100;
    private JRadioButton JRB_V101;
    private JRadioButton JRB_V102;
    private JRadioButton JRB_V103;
    private JRadioButton JRB_V104;
    private JRadioButton JRB_V105;
    private JRadioButton JRB_V106;
    private JRadioButton JRB_V107;
    private JRadioButton JRB_V108;
    private JRadioButton JRB_V109;
    private JRadioButton JRB_V110;
    private JRadioButton JRB_V111;
    private JRadioButton JRB_V112;
    private JRadioButton JRB_V113;
    private JRadioButton JRB_V114;
    private JRadioButton JRB_V115;
    private JRadioButton JRB_V116;
    private JRadioButton JRB_V117;
    private JRadioButton JRB_V118;
    private JRadioButton JRB_V14;
    private JRadioButton JRB_V15;
    private JRadioButton JRB_V16;
    private JRadioButton JRB_V17;
    private JRadioButton JRB_V18;
    private JRadioButton JRB_V19;
    private JRadioButton JRB_V20;
    private JRadioButton JRB_V21;
    private JRadioButton JRB_V22;
    private JRadioButton JRB_V23;
    private JRadioButton JRB_V24;
    private JRadioButton JRB_V25;
    private JRadioButton JRB_V26;
    private JRadioButton JRB_V27;
    private JRadioButton JRB_V28;
    private JRadioButton JRB_V29;
    private JRadioButton JRB_V30;
    private JRadioButton JRB_V31;
    private JRadioButton JRB_V32;
    private JRadioButton JRB_V33;
    private JRadioButton JRB_V34;
    private JRadioButton JRB_V35;
    private JRadioButton JRB_V36;
    private JRadioButton JRB_V37;
    private JRadioButton JRB_V38;
    private JRadioButton JRB_V39;
    private JRadioButton JRB_V40;
    private JRadioButton JRB_V41;
    private JRadioButton JRB_V42;
    private JRadioButton JRB_V43;
    private JRadioButton JRB_V44;
    private JRadioButton JRB_V45;
    private JRadioButton JRB_V46;
    private JRadioButton JRB_V47;
    private JRadioButton JRB_V48;
    private JRadioButton JRB_V49;
    private JRadioButton JRB_V50;
    private JRadioButton JRB_V51;
    private JRadioButton JRB_V52;
    private JRadioButton JRB_V53;
    private JRadioButton JRB_V54;
    private JRadioButton JRB_V55;
    private JRadioButton JRB_V56;
    private JRadioButton JRB_V57;
    private JRadioButton JRB_V58;
    private JRadioButton JRB_V59;
    private JRadioButton JRB_V60;
    private JRadioButton JRB_V61;
    private JRadioButton JRB_V62;
    private JRadioButton JRB_V63;
    private JRadioButton JRB_V64;
    private JRadioButton JRB_V65;
    private JRadioButton JRB_V66;
    private JRadioButton JRB_V67;
    private JRadioButton JRB_V68;
    private JRadioButton JRB_V69;
    private JRadioButton JRB_V70;
    private JRadioButton JRB_V71;
    private JRadioButton JRB_V72;
    private JRadioButton JRB_V73;
    private JRadioButton JRB_V74;
    private JRadioButton JRB_V75;
    private JRadioButton JRB_V76;
    private JRadioButton JRB_V77;
    private JRadioButton JRB_V78;
    private JRadioButton JRB_V79;
    private JRadioButton JRB_V80;
    private JRadioButton JRB_V81;
    private JRadioButton JRB_V82;
    private JRadioButton JRB_V83;
    private JRadioButton JRB_V84;
    private JRadioButton JRB_V85;
    private JRadioButton JRB_V86;
    private JRadioButton JRB_V87;
    private JRadioButton JRB_V88;
    private JRadioButton JRB_V89;
    private JRadioButton JRB_V90;
    private JRadioButton JRB_V91;
    private JRadioButton JRB_V92;
    private JRadioButton JRB_V93;
    private JRadioButton JRB_V94;
    private JRadioButton JRB_V95;
    private JRadioButton JRB_V96;
    private JRadioButton JRB_V97;
    private JRadioButton JRB_V98;
    private JRadioButton JRB_V99;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JButton jButton1;
    private JButton jButton2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xNombre = "";
    private int xEstado = 0;
    private long xnregistro = 0;
    private boolean xlleno = false;

    public JIFConsultarInfR4505(String resolucion) {
        initComponents();
        setTitle("INFORME RESOLUCIÓN " + resolucion);
        this.resolucion = resolucion;
        mNuevo();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        mCrearTabla();
        mLlenarComboEmpresa();
        mLlenarComboFiltro();
        this.xEstado = 0;
        this.JCHEstado.setSelected(false);
        this.xNombre = "";
    }

    public void mBuscar() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.JRBFormaA.isSelected()) {
                mCargarDatosTabla();
                return;
            } else if (this.resolucion.equals("4505")) {
                mCargarDatosTabla_FB();
                return;
            } else {
                if (this.resolucion.equals("202")) {
                    mCargarDatosTabla_FB_202();
                    return;
                }
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBEmpresa.requestFocus();
    }

    private void mLlenarComboEmpresa() {
        this.xlleno = false;
        this.JCBEmpresa.removeAllItems();
        if (this.xEstado == 1) {
            this.xsql = "SELECT `f_empresacontxconvenio`.`Id` , `f_empresacontxconvenio`.`Nbre` , `f_empresacontxconvenio`.`CRips`  ,   f_tiporegimen.`Id_R2463`\n    FROM `baseserver`.`f_ordenes`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`f_tiporegimen` \n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    WHERE (`f_empresacontxconvenio`.`Aplica4505` =1 \n    AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  \n    AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  \n    GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre`;";
        } else {
            this.xsql = "SELECT cc_terceros.`Id`, cc_terceros.RazonSocialCompleta, g_empresacont.Codigo , 0 FROM  `f_ordenes` INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `g_persona`ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`) \nINNER JOIN `g_usuario`ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)  \nINNER JOIN  `g_empresacont`  ON (`g_empresacont`.`Id_empresa` = `g_usuario`.`Id_EmpresaCont`) \nINNER JOIN  cc_terceros  ON (`g_empresacont`.`Id_empresa` = cc_terceros.`Id`) \n INNER JOIN  `g_empresa`  ON (`g_empresa`.`Id` = g_empresacont.`Id_empresa`) WHERE (g_empresa.Estado = 1 AND`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY cc_terceros.`Id` order by cc_terceros.RazonSocialCompleta ";
        }
        this.xidempresa = this.xct.llenarComboyLista(this.xsql, this.xidempresa, this.JCBEmpresa, 4);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mCrearTabla();
        this.xlleno = true;
    }

    private void mLlenarComboFiltro() {
        this.JCB_MUnicipio.removeAllItems();
        if (this.JRB_NoAplica.isSelected() || this.JRB_Municipio.isSelected()) {
            this.JCB_MUnicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xsql = "SELECT g_municipio.`Id`, g_municipio.`Nbre`\nFROM  `f_ordenes` INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `g_persona`ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`) \nINNER JOIN `g_usuario`ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN `g_municipio` ON  (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nINNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)  \nINNER JOIN  `g_empresacont`  ON (`g_empresacont`.`Id_empresa` = `g_usuario`.`Id_EmpresaCont`) \nINNER JOIN  cc_terceros  ON (`g_empresacont`.`Id_empresa` = cc_terceros.`Id`) \n INNER JOIN  `g_empresa`  ON (`g_empresa`.`Id` = g_empresacont.`Id_empresa`)\nWHERE (g_empresa.Estado = 1 AND`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  GROUP BY g_municipio.`Id` ORDER BY g_municipio.`Nbre`";
        } else {
            this.JCB_MUnicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xsql = "SELECT g_departamento.`Id`, UCASE(g_departamento.`Nbre`) Nbre\nFROM  `f_ordenes` INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `g_persona`ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`) \nINNER JOIN `g_usuario`ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN `g_municipio` ON  (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nINNER JOIN g_departamento ON  (g_departamento.`Id` = `g_municipio`.`Id_Dpto`)  \nINNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)  \nINNER JOIN  `g_empresacont`  ON (`g_empresacont`.`Id_empresa` = `g_usuario`.`Id_EmpresaCont`) \nINNER JOIN  cc_terceros  ON (`g_empresacont`.`Id_empresa` = cc_terceros.`Id`) \n INNER JOIN  `g_empresa`  ON (`g_empresa`.`Id` = g_empresacont.`Id_empresa`)\nWHERE (g_empresa.Estado = 1 AND`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')  GROUP BY g_departamento.`Id` ORDER BY  g_departamento.`Nbre`";
        }
        this.xIdMunicipio = this.xct.llenarCombo(this.xsql, this.xIdMunicipio, this.JCB_MUnicipio);
        this.JCB_MUnicipio.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Tipo", "C", "CodOrganismo", "TD", "NDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "FechaNac", "Sexo", "CEtnia", "COcupacion", "CNivelEstudio", "IdUsuario"}) { // from class: Sig.JIFConsultarInfR4505.1
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(2);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            this.xsql = "DELETE FROM `p_res_4505`";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "ALTER TABLE p_res_4505 AUTO_INCREMENT=1";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V64') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V26') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V27') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V20') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V21') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V19') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V17') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V16') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V15') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT  `persona`.`Id_persona`  FROM  `g_ips`,   `f_ordenes` INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `persona`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `p_demanda_inducida`.`Id_Procedimiento`) WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `f_ordenes`.`Estado` =0 and `persona`.`IdEmpresaCont`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' and  `persona`.`Edad`>=`p_demanda_inducida`.`EdadI`  AND `persona`.`Edad`<=`p_demanda_inducida`.`EdadF` ) GROUP BY `persona`.`Id_persona` ORDER BY `persona`.`NUsuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V22') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = " insert ignore into p_res_4505 (Id_persona) SELECT `ingreso`.`Id_Usuario`   FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V23') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            mCrearTabla();
            this.xnregistro = 0L;
            this.xsql = "SELECT 1 AS `Tipo`, 1 AS `Consecutivo`, `g_ips`.`CodigoOrganismo`, `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento`, `persona`.`Apellido1`, `persona`.`Apellido2`, `persona`.`Nombre1`, `persona`.`Nombre2`, `persona`.`FechaNac` , `persona`.`IdSexo` , `persona`.`IdEtnia` , `ingreso`.`Id_Ocupacion` , `ingreso`.`Id_NivelEstudio` , `persona`.`Id_persona`  FROM  `g_ips`,   `f_ordenes` INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `persona`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `p_demanda_inducida`.`Id_Procedimiento`) WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `f_ordenes`.`Estado` =0 and `persona`.`IdEmpresaCont`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' ) GROUP BY `persona`.`Id_persona` ORDER BY `persona`.`NUsuario` ASC ";
            System.out.println("Uno   " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(Integer.valueOf(i + 1), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(this.xmt.removerAcentos(rs.getString(6)), i, 5);
                    this.xmodelo.setValueAt(this.xmt.removerAcentos(rs.getString(7)), i, 6);
                    this.xmodelo.setValueAt(this.xmt.removerAcentos(rs.getString(8)), i, 7);
                    this.xmodelo.setValueAt(this.xmt.removerAcentos(rs.getString(9)), i, 8);
                    this.xmodelo.setValueAt(rs.getString(10), i, 9);
                    this.xmodelo.setValueAt(rs.getString(11), i, 10);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(12)), i, 11);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(13)), i, 12);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(14)), i, 13);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(15)), i, 14);
                    i++;
                }
                this.xnregistro = i + 1;
            }
            rs.close();
            this.xct.cerrarConexionBd();
            mConsultarActualizacionCampos();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfR4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarActualizacionCampos() {
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , count(`ingreso`.`FechaIngreso`) AS `Dato`, 1 as Dato1 FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`f_ordenes`.`Estado`=0 AND `p_demanda_inducida`.`NVariable` ='V58' AND `f_ordenes`.`Estado` =0 AND `persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET  p_res_4505.v14=v_r_tmp.Dato1 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0].equals("407")) {
            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<10)   ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v14=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<=49 and  `persona`.`IdSexo` ='F' and `p_res_4505`.v14<>1)   ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v14=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
            this.xct.cerrarConexionBd();
        }
        this.xsql = "update `p_res_4505` set p_res_4505.v15=3 where p_res_4505.v14=1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , IF( `persona`.`Edad`<18,2, IF(`persona`.`Edad`>18 AND `persona`.`IdSexo`='M',0,1) ) AS Dato   FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V15') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v15=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0].equals("407")) {
            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (`persona`.`IdSexo` ='F')   ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v15=3 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona and p_res_4505.v15=0");
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( (DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))>90  and p_res_4505.v15=2)   ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v15=3 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
            this.xct.cerrarConexionBd();
        }
        this.xsql = "update `p_res_4505` set p_res_4505.v16=2 where p_res_4505.v14=1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , 1 AS Dato  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V16') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v16=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario and p_res_4505.v14=1");
        this.xct.cerrarConexionBd();
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0].equals("407")) {
            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (  `persona`.`IdSexo` ='F' and `p_res_4505`.v16=0)   ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v16=2 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
            this.xct.cerrarConexionBd();
        }
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , 1 AS Dato  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V17') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v17=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0].equals("407")) {
            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<=2 and `p_res_4505`.v17=0)   ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v17=2 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
            this.xct.cerrarConexionBd();
        }
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , 1 AS Dato  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V19') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v19=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , 1 AS Dato  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V20') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v20=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , 1 AS Dato1,round(`h_examenfisico`.`Peso`) as Peso, `h_examenfisico`.`Talla`, `h_atencion`.`Fecha_Atencion`   FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_examenfisico`  ON (`h_atencion`.`Id` = `h_examenfisico`.`Id_Atencion`)  INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_examenfisico`.`IMC`>=30  AND  `h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V21') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v21=v_r_tmp.Dato1, p_res_4505.v29=Fecha_Atencion, p_res_4505.v30=Peso, p_res_4505.v31=Fecha_Atencion , p_res_4505.v32=Talla WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<3 )   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v25=21 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (`persona`.`IdSexo` ='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v26=2 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , 1 AS Dato  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V26') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v26=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , 1 AS Dato  FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V27') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v27=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario`, Round(`h_examenfisico`.`Peso`) as Peso , `h_atencion`.`Fecha_Atencion`  FROM `h_examenfisico` INNER JOIN `h_atencion`  ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `c_clasecita`.`Id_Procedimiento`)  INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`)  AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`)  WHERE ( `h_examenfisico`.`Peso`<>0 and `p_demanda_inducida`.`Tipo`=0 AND `ingreso`.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and `persona`.`IdEmpresaCont`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v30=v_r_tmp.Peso, p_res_4505.v29=v_r_tmp.Fecha_Atencion WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario`, `h_examenfisico`.`Talla`, `h_atencion`.`Fecha_Atencion`  FROM `h_examenfisico` INNER JOIN `h_atencion`  ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)  INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `c_clasecita`.`Id_Procedimiento`)  INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`)  AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`)  WHERE (`h_examenfisico`.`Talla`<>0 and `p_demanda_inducida`.`Tipo`=0 AND `ingreso`.`FechaIngreso`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and `persona`.`IdEmpresaCont`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v31=v_r_tmp.Fecha_Atencion, p_res_4505.v32=v_r_tmp.Talla WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v33='1800-01-01' WHERE p_res_4505.V14=1");
        this.xct.cerrarConexionBd();
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0].equals("407")) {
            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<6)   ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v34=99 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
            this.xct.cerrarConexionBd();
        }
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente` , 1 AS `Dato` FROM  `p_vacunacion_esquema` INNER JOIN `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V35' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente`, `p_vacunacion_carnet`.`IdEsquema` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v35=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=6 )   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v35=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente` , 1 AS `Dato` FROM  `p_vacunacion_esquema` INNER JOIN `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V36' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente`, `p_vacunacion_carnet`.`IdEsquema` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v36=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>1)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v36=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and `p_vacunacion_dosis`.`Id`<=3 AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `p_vacunacion_vacunas`.`Id`IN(8,9,10)) GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v37=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>2)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v37=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V38' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v38=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=6)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v38=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, IF(`p_vacunacion_dosis`.`Id`=5,4,5) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V39' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `p_vacunacion_dosis`.`Id`>=5 ) GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        System.out.println(" Vacunacion Penta " + this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v39=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=6)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v39=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V40' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v40=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>0.8)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v40=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V41' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v41=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>3)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v41=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V42' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v42=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>3)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v42=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V43' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v43=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>2)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v43=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V44' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v44=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=2)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v44=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V45' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v45=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (persona.`Edad`>=6 AND persona.tipoedad=1)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v45=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v45=3 WHERE p_res_4505.v45=4");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V46' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v46=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (persona.`IdSexo`='M')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v46=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`  SET p_res_4505.v46=3 WHERE p_res_4505.v46=4");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_vacunacion_carnet`.`IdPaciente`, MAX(p_vacunacion_dosis.`Id_Res4505`) AS `Dato` FROM `p_vacunacion_esquema` INNER JOIN  `p_vacunacion_carnet`  ON (`p_vacunacion_esquema`.`Id` = `p_vacunacion_carnet`.`IdEsquema`) INNER JOIN  `p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`) INNER JOIN  `p_vacunacion_dosis`  ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `p_vacunacion_vacunas`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `p_vacunacion_carnet`.`IdPaciente`) WHERE (`p_vacunacion_carnet`.`FechaVacuna` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_vacunacion_carnet`.`FechaVacuna` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `p_demanda_inducida`.`NVariable` ='V47' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_vacunacion_carnet`.`IdPaciente` ORDER BY `p_vacunacion_carnet`.`IdPaciente` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v47=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.IdPaciente");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (persona.`IdSexo`='M')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v47=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (persona.`Edad`>=2 and persona.tipoedad=1)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v48=22 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario`, IF(COUNT(`ingreso`.`Id_Usuario`)=1,1,2) AS `Resultado` FROM `f_ordenes`  INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) WHERE (DATE_FORMAT(`ingreso`.`FechaIngreso`,'%Y') ='" + this.xmt.formatoANO.format(this.JDFechaI.getDate()) + "' AND `p_demanda_inducida`.`Tipo` =1 AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `ingreso`.`Id_Usuario` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v48=v_r_tmp.Resultado WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`  SET p_res_4505.v49='1800-01-01' WHERE p_res_4505.v14=1");
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`  SET p_res_4505.v50='1800-01-01' WHERE p_res_4505.v14=1");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE ( `p_demanda_inducida`.`NVariable` ='V52' AND `f_ordenes`.`Estado` =0   AND `h_atencion`.`Id_ClaseCita`=197 AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v52=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( (DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))>30 )   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v52='1845-01-01' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<=50 )   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v53='1800-01-01', p_res_4505.v54=21 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`f_ordenes`.`Estado`=0 AND `p_demanda_inducida`.`NVariable` ='V56' AND `f_ordenes`.`Estado` =0 AND `persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v56=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "update `p_res_4505` set p_res_4505.v57=999 where p_res_4505.v14=1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , count(`ingreso`.`FechaIngreso`) AS `Dato`, 1 as Dato1 FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`f_ordenes`.`Estado`=0 AND `p_demanda_inducida`.`NVariable` ='V58' AND `f_ordenes`.`Estado` =0 AND `persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v57=v_r_tmp.Dato, p_res_4505.v14=v_r_tmp.Dato1 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "update `p_res_4505` set p_res_4505.v58='1800-01-01' where p_res_4505.v14=1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`f_ordenes`.`Estado`=0 AND `p_demanda_inducida`.`NVariable` ='V58' AND `f_ordenes`.`Estado` =0 AND `persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v58=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=4 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<5  || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=11 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<12 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=16 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<17 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=45 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)< 46 )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v62='1800-01-01' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`p_demanda_inducida`.`NVariable` ='V62' AND `f_ordenes`.`Estado` =0 AND ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365) >=`p_demanda_inducida`.`EdadI` AND ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365) <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v62=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=55 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<56  || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=60 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<61 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=65 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<66 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=70 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<71 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=75 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<76 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=80 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<81 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=85 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<86 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=90 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<91 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=95 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<96 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=100 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)< 101 )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v63='1800-01-01' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`p_demanda_inducida`.`NVariable` ='V63' AND `f_ordenes`.`Estado` =0 AND `persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v63=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , `h_atencion`.`Fecha_Atencion` AS Dato, 2 AS Dato1   FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V64' and persona.`Edad`<10 ) GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v64=v_r_tmp.Dato, p_res_4505.v21=v_r_tmp.Dato1 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (`persona`.`IdSexo` ='M' and persona.`Edad`>=18 AND persona.`tipoedad`=1)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v21=3 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (`persona`.`IdSexo` ='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v22=3 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (persona.`Edad`<=18 and  `persona`.`IdSexo` ='M')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v22=21 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (persona.`Edad`>18 and  `persona`.`IdSexo` ='M' and persona.tipoedad=1)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v22=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , `h_atencion`.`Fecha_Atencion` AS Dato,IF( `persona`.`Edad`<18,2, IF(`persona`.`Edad`>18 AND `persona`.`IdSexo`='M',0,1) ) AS Dato1   FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V22') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v65=v_r_tmp.Dato, p_res_4505.v22=v_r_tmp.Dato1 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , `h_atencion`.`Fecha_Atencion` AS Dato, 1 AS Dato1   FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN  `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_atenciondx`  ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `r_patologiasreporte`  ON (`r_patologiasreporte`.`Id_Patologia` = `h_atenciondx`.`Id_Dx`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `r_patologiasreporte`.`NVariable` ='V23') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v66=v_r_tmp.Dato, p_res_4505.v23=v_r_tmp.Dato1 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`p_demanda_inducida`.`NVariable` ='V68' AND `f_ordenes`.`Estado` =0  AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v67=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`p_demanda_inducida`.`NVariable` ='V68' AND `f_ordenes`.`Estado` =0  AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v68=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`p_demanda_inducida`.`NVariable` ='V69' AND `h_atencion`.`Id_ClaseCita`=72 AND `f_ordenes`.`Estado` =0  AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v69=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 )   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v69='1845-01-01' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<10 )   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v70=21 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<10 )   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v71=21 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`p_demanda_inducida`.`NVariable` ='V72' AND `f_ordenes`.`Estado` =0 AND `persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v72=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10  AND ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<30 )   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v72='1800-01-01' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=45 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<46  || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=50 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<51 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=55 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<56 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=60 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<61 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=65 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<66 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=70 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<71 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=75 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<76 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=80 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<81 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=85 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<86 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=90 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<91 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=95 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<96 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=100 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)< 101 )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v73='1800-01-01' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario` , MAX(`ingreso`.`FechaIngreso`) AS `Dato` FROM `h_atencion`  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) AND (`persona`.`IdSexo` = `p_demanda_inducida`.`Id_Sexo`) WHERE (`p_demanda_inducida`.`NVariable` ='V73' AND `f_ordenes`.`Estado` =0 AND `persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v73=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `ingreso`.`Id_Usuario`, `h_atencion`.`Fecha_Atencion` AS Dato FROM `h_ordenes` INNER JOIN  `h_atencion`   ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)  INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `h_itemordenesproced`  ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'' AND `h_itemordenesproced`.`Id_Procedimiento` IN(906255,906249) AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v75=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT   `ingreso`.`Id_Usuario` , `h_atencion`.`Fecha_Atencion` AS Dato FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)  INNER JOIN `h_atencion`  ON (`h_atencion`.`Id` = `l_detallerecepcion`.`Id_Atencion`) INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) WHERE (`l_detallerecepcion`.`Id_Procedim` IN(906255,906249) AND `l_recepcion`.`Estado` =0 AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp` <>'') GROUP BY `ingreso`.`Id_Usuario` ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v75=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Usuario");
        this.xct.cerrarConexionBd();
        this.xsql = "update `p_res_4505` set p_res_4505.v78='1800-01-01' where p_res_4505.v14=1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) AS `Dato` , IF(`l_tiporesultado`.`Nbre`='Negativo',0,1) AS Dato1 FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V79' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v78=v_r_tmp.Dato, p_res_4505.v79=v_r_tmp.Dato1 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona and p_res_4505.v14=1");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) AS Dato , IF(`l_tiporesultado`.`Nbre`='No Reactiva' || `l_tiporesultado`.`Nbre`='Numerico',1,2) AS Dato1 FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V81' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v80=v_r_tmp.Dato, p_res_4505.v81=v_r_tmp.Dato1 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.Id_Persona FROM `p_res_4505` WHERE `p_res_4505`.V81=2 and `p_res_4505`.V14=1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v15=1 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) AS Dato , IF(`l_tiporesultado`.`Nbre`='Negativo',1,2) AS Dato1 FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V82' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v82=v_r_tmp.Dato, p_res_4505.v83=v_r_tmp.Dato1  WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  `persona`.`IdSexo`='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v86=22 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  `persona`.`IdSexo`='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v87='1800-01-01' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  `persona`.`IdSexo`='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v88='999' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  `persona`.`IdSexo`='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v89='999' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  `persona`.`IdSexo`='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v90='999' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona` , MAX(`ingreso`.`FechaIngreso`) AS `Dato1` , `g_ips`.`CodigoOrganismo` AS `Dato2` FROM `g_ips`,  `f_itemordenesproced` INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) WHERE (`p_demanda_inducida`.`NVariable` ='V87' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `f_ordenes`.`Estado` =0 AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `persona`.`Id_persona` HAVING (`Dato1` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "') ORDER BY `persona`.`Id_persona` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET  p_res_4505.v86=1 , p_res_4505.v87=v_r_tmp.Dato1, p_res_4505.v90=v_r_tmp.Dato2  WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  `persona`.`IdSexo`='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v91='1800-01-01' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  `persona`.`IdSexo`='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v92='999' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=10 and  `persona`.`IdSexo`='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v93='1800-01-01', p_res_4505.v94='999', p_res_4505.v95='999' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=35 and  `persona`.`IdSexo`='F')   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v96='1800-01-01', p_res_4505.v97='999', p_res_4505.v98='999' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0].equals("407")) {
            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=30 and  `persona`.`IdSexo`='F')   ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v99='1800-01-01', p_res_4505.v100='1800-01-01', p_res_4505.v101='999', p_res_4505.v102='999' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
            this.xct.cerrarConexionBd();
        }
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d'))  as Dato, `l_detalleresultado`.`VrNumerico`  as Dato1 FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V104' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `l_detalleresultado`.`Id_ProtocolProcedim` IN(1,2,439,440) and `l_detalleresultado`.`VrNumerico`>=5 ) order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v103=v_r_tmp.Dato, p_res_4505.v104=v_r_tmp.Dato1  WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<11  and p_res_4505.v14<>1)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v103='1845-01-01', p_res_4505.v104=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>14  and p_res_4505.v14<>1)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v103='1845-01-01', p_res_4505.v104=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( `persona`.`IdSexo`='M' )   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v103='1845-01-01', p_res_4505.v104=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        if (this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0].equals("407")) {
            this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE (((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<=10 and ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=49 and  `persona`.`IdSexo`='F')   ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET  p_res_4505.v103='1845-01-01', p_res_4505.v104=0 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
            this.xct.cerrarConexionBd();
        }
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `p_res_4505`.`Id_Persona` FROM  `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) WHERE ( ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=45 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<46  || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=50 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<51 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=55 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<56 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=60 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<61 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=65 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<66 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=70 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<71 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=75 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<76 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=80 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<81 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=85 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<86 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=90 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<91 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=95 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)<96 || ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)>=100 and  ((DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',persona.FechaNac))/365)< 101 )";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v105='1800-01-01', p_res_4505.v106='1800-01-01', p_res_4505.v111='1800-01-01' WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_Persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) AS `Dato` FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V105' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v105=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) AS `Dato` FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V107' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v106=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona` , `l_detalleresultado`.`VrNumerico` AS `Dato` FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V107' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v107=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) AS `Dato` FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V109' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v108=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona` , `l_detalleresultado`.`VrNumerico` AS `Dato` FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V109' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and `l_detalleresultado`.`VrNumerico`>=5) order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v109=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) AS `Dato` FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V110' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v110=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) AS `Dato` FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V111' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `l_detalleresultado`.`Id_ProtocolProcedim` =31) order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v111=v_r_tmp.Dato WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_r_tmp`  AS SELECT `persona`.`Id_persona`, DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) AS Dato,IF(`l_tiporesultado`.`Nbre`='Positiva',1,0) AS Resultado, 1 as Dato1   FROM `l_detallerecepcion` INNER JOIN  `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`) INNER JOIN  `g_procedimiento`  ON (`g_procedimiento`.`Id` = `l_detallerecepcion`.`Id_Procedim`) INNER JOIN `p_demanda_inducida`  ON (`p_demanda_inducida`.`Id_Sexo` = `persona`.`IdSexo`) AND (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `l_resultados`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_detalleresultado` ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN `l_tiporesultado`  ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`) WHERE (`persona`.`Edad` >=`p_demanda_inducida`.`EdadI` AND `persona`.`Edad` <=`p_demanda_inducida`.`EdadF` AND `persona`.`IdEmpresaCont` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND `l_recepcion`.`Estado` =0 AND `p_demanda_inducida`.`NVariable` ='V112' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE(DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y/%m/%d')) <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `l_detalleresultado`.`Id_ProtocolProcedim` =31) order by `persona`.`Id_persona` ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `p_res_4505`, `v_r_tmp`  SET p_res_4505.v112=v_r_tmp.Dato, p_res_4505.v113=v_r_tmp.Resultado, p_res_4505.v18=v_r_tmp.Dato1 WHERE p_res_4505.`Id_Persona`=v_r_tmp.Id_persona");
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JBGForma = new ButtonGroup();
        this.JBG_Filtro = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIDetalle = new JPanel();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCB_MUnicipio = new JComboBox();
        this.JPI_Filtro = new JPanel();
        this.JRB_NoAplica = new JRadioButton();
        this.JRB_Municipio = new JRadioButton();
        this.JRB_Departamento = new JRadioButton();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        this.JPIForma = new JPanel();
        this.JRBFormaA = new JRadioButton();
        this.JRBFormaB = new JRadioButton();
        this.JPIPreparacion = new JPanel();
        this.JRB_V14 = new JRadioButton();
        this.JRB_V15 = new JRadioButton();
        this.JRB_V16 = new JRadioButton();
        this.JRB_V17 = new JRadioButton();
        this.JRB_V18 = new JRadioButton();
        this.JRB_V19 = new JRadioButton();
        this.JRB_V20 = new JRadioButton();
        this.JRB_V21 = new JRadioButton();
        this.JRB_V22 = new JRadioButton();
        this.JRB_V23 = new JRadioButton();
        this.JRB_V24 = new JRadioButton();
        this.JRB_V25 = new JRadioButton();
        this.JRB_V26 = new JRadioButton();
        this.JRB_V27 = new JRadioButton();
        this.JRB_V28 = new JRadioButton();
        this.JRB_V29 = new JRadioButton();
        this.JRB_V30 = new JRadioButton();
        this.JRB_V31 = new JRadioButton();
        this.JRB_V32 = new JRadioButton();
        this.JRB_V33 = new JRadioButton();
        this.JRB_V34 = new JRadioButton();
        this.JRB_V35 = new JRadioButton();
        this.JRB_V36 = new JRadioButton();
        this.JRB_V37 = new JRadioButton();
        this.JRB_V38 = new JRadioButton();
        this.JRB_V39 = new JRadioButton();
        this.JRB_V40 = new JRadioButton();
        this.JRB_V41 = new JRadioButton();
        this.JRB_V42 = new JRadioButton();
        this.JRB_V43 = new JRadioButton();
        this.JRB_V44 = new JRadioButton();
        this.JRB_V45 = new JRadioButton();
        this.JRB_V46 = new JRadioButton();
        this.JRB_V47 = new JRadioButton();
        this.JRB_V48 = new JRadioButton();
        this.JRB_V49 = new JRadioButton();
        this.JRB_V50 = new JRadioButton();
        this.JRB_V51 = new JRadioButton();
        this.JRB_V52 = new JRadioButton();
        this.JRB_V53 = new JRadioButton();
        this.JRB_V54 = new JRadioButton();
        this.JRB_V55 = new JRadioButton();
        this.JRB_V56 = new JRadioButton();
        this.JRB_V57 = new JRadioButton();
        this.JRB_V58 = new JRadioButton();
        this.JRB_V59 = new JRadioButton();
        this.JRB_V60 = new JRadioButton();
        this.JRB_V61 = new JRadioButton();
        this.JRB_V62 = new JRadioButton();
        this.JRB_V63 = new JRadioButton();
        this.JRB_V64 = new JRadioButton();
        this.JRB_V65 = new JRadioButton();
        this.JRB_V66 = new JRadioButton();
        this.JRB_V67 = new JRadioButton();
        this.JRB_V68 = new JRadioButton();
        this.JRB_V69 = new JRadioButton();
        this.JRB_V70 = new JRadioButton();
        this.JRB_V71 = new JRadioButton();
        this.JRB_V72 = new JRadioButton();
        this.JRB_V73 = new JRadioButton();
        this.JRB_V74 = new JRadioButton();
        this.JRB_V75 = new JRadioButton();
        this.JRB_V76 = new JRadioButton();
        this.JRB_V77 = new JRadioButton();
        this.JRB_V78 = new JRadioButton();
        this.JRB_V79 = new JRadioButton();
        this.JRB_V80 = new JRadioButton();
        this.JRB_V81 = new JRadioButton();
        this.JRB_V82 = new JRadioButton();
        this.JRB_V83 = new JRadioButton();
        this.JRB_V84 = new JRadioButton();
        this.JRB_V85 = new JRadioButton();
        this.JRB_V86 = new JRadioButton();
        this.JRB_V87 = new JRadioButton();
        this.JRB_V88 = new JRadioButton();
        this.JRB_V89 = new JRadioButton();
        this.JRB_V90 = new JRadioButton();
        this.JRB_V91 = new JRadioButton();
        this.JRB_V92 = new JRadioButton();
        this.JRB_V93 = new JRadioButton();
        this.JRB_V94 = new JRadioButton();
        this.JRB_V95 = new JRadioButton();
        this.JRB_V96 = new JRadioButton();
        this.JRB_V97 = new JRadioButton();
        this.JRB_V98 = new JRadioButton();
        this.JRB_V99 = new JRadioButton();
        this.JRB_V100 = new JRadioButton();
        this.JRB_V101 = new JRadioButton();
        this.JRB_V102 = new JRadioButton();
        this.JRB_V103 = new JRadioButton();
        this.JRB_V104 = new JRadioButton();
        this.JRB_V105 = new JRadioButton();
        this.JRB_V106 = new JRadioButton();
        this.JRB_V107 = new JRadioButton();
        this.JRB_V108 = new JRadioButton();
        this.JRB_V109 = new JRadioButton();
        this.JRB_V110 = new JRadioButton();
        this.JRB_V111 = new JRadioButton();
        this.JRB_V112 = new JRadioButton();
        this.JRB_V113 = new JRadioButton();
        this.JRB_V114 = new JRadioButton();
        this.JRB_V115 = new JRadioButton();
        this.JRB_V116 = new JRadioButton();
        this.JRB_V117 = new JRadioButton();
        this.JRB_V118 = new JRadioButton();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMACIÓN PYP");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformacionr4505");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFConsultarInfR4505.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInfR4505.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFConsultarInfR4505.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInfR4505.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_MUnicipio.setFont(new Font("Arial", 1, 12));
        this.JCB_MUnicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Filtro.add(this.JRB_NoAplica);
        this.JRB_NoAplica.setFont(new Font("Arial", 1, 12));
        this.JRB_NoAplica.setSelected(true);
        this.JRB_NoAplica.setText("No Aplica");
        this.JRB_NoAplica.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_NoAplicaActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Municipio);
        this.JRB_Municipio.setFont(new Font("Arial", 1, 12));
        this.JRB_Municipio.setText("Por Municipio");
        this.JRB_Municipio.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_MunicipioActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Departamento);
        this.JRB_Departamento.setFont(new Font("Arial", 1, 12));
        this.JRB_Departamento.setText("Por Departamento");
        this.JRB_Departamento.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_DepartamentoActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_NoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Municipio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Departamento).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_NoAplica).addComponent(this.JRB_Municipio).addComponent(this.JRB_Departamento)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Filtro Por convenio ? ");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 645, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCB_MUnicipio, -2, 520, -2).addGap(38, 38, 38).addComponent(this.JPI_Filtro, -2, -1, -2))).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa).addComponent(this.JCHEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCB_MUnicipio, -2, 50, -2).addComponent(this.JPI_Filtro, -2, -1, -2)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.8
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JPIForma.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGForma.add(this.JRBFormaA);
        this.JRBFormaA.setFont(new Font("Arial", 1, 12));
        this.JRBFormaA.setText("Forma A");
        this.JBGForma.add(this.JRBFormaB);
        this.JRBFormaB.setFont(new Font("Arial", 1, 12));
        this.JRBFormaB.setSelected(true);
        this.JRBFormaB.setText("Forma B");
        GroupLayout JPIFormaLayout = new GroupLayout(this.JPIForma);
        this.JPIForma.setLayout(JPIFormaLayout);
        JPIFormaLayout.setHorizontalGroup(JPIFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFormaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFormaA).addGap(18, 18, 18).addComponent(this.JRBFormaB).addContainerGap(119, 32767)));
        JPIFormaLayout.setVerticalGroup(JPIFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFormaLayout.createSequentialGroup().addGroup(JPIFormaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFormaA).addComponent(this.JRBFormaB)).addGap(0, 7, 32767)));
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JPIForma, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 464, -2).addGap(26, 26, 26).addComponent(this.JBTGenerar, -2, 230, -2).addGap(0, 0, 32767)).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 384, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIForma, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 53, -2).addComponent(this.JBTGenerar, GroupLayout.Alignment.TRAILING, -2, 53, -2)).addContainerGap()));
        this.JTPDatos.addTab("DETALLE", this.JPIDetalle);
        this.JBGOpciones.add(this.JRB_V14);
        this.JRB_V14.setFont(new Font("Arial", 1, 12));
        this.JRB_V14.setText("V14");
        this.JRB_V14.setMaximumSize(new Dimension(55, 23));
        this.JRB_V14.setMinimumSize(new Dimension(55, 23));
        this.JRB_V14.setPreferredSize(new Dimension(55, 23));
        this.JRB_V14.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.10
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V14MouseClicked(evt);
            }
        });
        this.JRB_V14.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.11
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V14ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V15);
        this.JRB_V15.setFont(new Font("Arial", 1, 12));
        this.JRB_V15.setText("V15");
        this.JRB_V15.setMaximumSize(new Dimension(55, 23));
        this.JRB_V15.setMinimumSize(new Dimension(55, 23));
        this.JRB_V15.setPreferredSize(new Dimension(55, 23));
        this.JRB_V15.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.12
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V15MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V16);
        this.JRB_V16.setFont(new Font("Arial", 1, 12));
        this.JRB_V16.setText("V16");
        this.JRB_V16.setMaximumSize(new Dimension(55, 23));
        this.JRB_V16.setMinimumSize(new Dimension(55, 23));
        this.JRB_V16.setPreferredSize(new Dimension(55, 23));
        this.JRB_V16.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.13
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V16MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V17);
        this.JRB_V17.setFont(new Font("Arial", 1, 12));
        this.JRB_V17.setText("V17");
        this.JRB_V17.setMaximumSize(new Dimension(55, 23));
        this.JRB_V17.setMinimumSize(new Dimension(55, 23));
        this.JRB_V17.setPreferredSize(new Dimension(55, 23));
        this.JRB_V17.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.14
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V17MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V18);
        this.JRB_V18.setFont(new Font("Arial", 1, 12));
        this.JRB_V18.setText("V18");
        this.JRB_V18.setMaximumSize(new Dimension(55, 23));
        this.JRB_V18.setMinimumSize(new Dimension(55, 23));
        this.JRB_V18.setPreferredSize(new Dimension(55, 23));
        this.JRB_V18.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.15
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V18MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V19);
        this.JRB_V19.setFont(new Font("Arial", 1, 12));
        this.JRB_V19.setText("V19");
        this.JRB_V19.setMaximumSize(new Dimension(55, 23));
        this.JRB_V19.setMinimumSize(new Dimension(55, 23));
        this.JRB_V19.setPreferredSize(new Dimension(55, 23));
        this.JRB_V19.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.16
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V19MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V20);
        this.JRB_V20.setFont(new Font("Arial", 1, 12));
        this.JRB_V20.setText("V20");
        this.JRB_V20.setMaximumSize(new Dimension(55, 23));
        this.JRB_V20.setMinimumSize(new Dimension(55, 23));
        this.JRB_V20.setPreferredSize(new Dimension(55, 23));
        this.JRB_V20.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.17
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V20MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V21);
        this.JRB_V21.setFont(new Font("Arial", 1, 12));
        this.JRB_V21.setText("V21");
        this.JRB_V21.setMaximumSize(new Dimension(55, 23));
        this.JRB_V21.setMinimumSize(new Dimension(55, 23));
        this.JRB_V21.setPreferredSize(new Dimension(55, 23));
        this.JRB_V21.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.18
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V21MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V22);
        this.JRB_V22.setFont(new Font("Arial", 1, 12));
        this.JRB_V22.setText("V22");
        this.JRB_V22.setMaximumSize(new Dimension(55, 23));
        this.JRB_V22.setMinimumSize(new Dimension(55, 23));
        this.JRB_V22.setPreferredSize(new Dimension(55, 23));
        this.JRB_V22.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.19
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V22MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V23);
        this.JRB_V23.setFont(new Font("Arial", 1, 12));
        this.JRB_V23.setText("V23");
        this.JRB_V23.setMaximumSize(new Dimension(55, 23));
        this.JRB_V23.setMinimumSize(new Dimension(55, 23));
        this.JRB_V23.setPreferredSize(new Dimension(55, 23));
        this.JRB_V23.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.20
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V23MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V24);
        this.JRB_V24.setFont(new Font("Arial", 1, 12));
        this.JRB_V24.setText("V24");
        this.JRB_V24.setMaximumSize(new Dimension(55, 23));
        this.JRB_V24.setMinimumSize(new Dimension(55, 23));
        this.JRB_V24.setPreferredSize(new Dimension(55, 23));
        this.JRB_V24.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.21
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V24MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V25);
        this.JRB_V25.setFont(new Font("Arial", 1, 12));
        this.JRB_V25.setText("V25");
        this.JRB_V25.setMaximumSize(new Dimension(55, 23));
        this.JRB_V25.setMinimumSize(new Dimension(55, 23));
        this.JRB_V25.setPreferredSize(new Dimension(55, 23));
        this.JRB_V25.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.22
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V25MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V26);
        this.JRB_V26.setFont(new Font("Arial", 1, 12));
        this.JRB_V26.setText("V26");
        this.JRB_V26.setMaximumSize(new Dimension(55, 23));
        this.JRB_V26.setMinimumSize(new Dimension(55, 23));
        this.JRB_V26.setPreferredSize(new Dimension(55, 23));
        this.JRB_V26.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.23
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V26MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V27);
        this.JRB_V27.setFont(new Font("Arial", 1, 12));
        this.JRB_V27.setText("V27");
        this.JRB_V27.setMaximumSize(new Dimension(55, 23));
        this.JRB_V27.setMinimumSize(new Dimension(55, 23));
        this.JRB_V27.setPreferredSize(new Dimension(55, 23));
        this.JRB_V27.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.24
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V27MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V28);
        this.JRB_V28.setFont(new Font("Arial", 1, 12));
        this.JRB_V28.setText("V28");
        this.JRB_V28.setMaximumSize(new Dimension(55, 23));
        this.JRB_V28.setMinimumSize(new Dimension(55, 23));
        this.JRB_V28.setPreferredSize(new Dimension(55, 23));
        this.JRB_V28.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.25
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V28MouseClicked(evt);
            }
        });
        this.JRB_V28.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.26
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V28ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V29);
        this.JRB_V29.setFont(new Font("Arial", 1, 12));
        this.JRB_V29.setText("V29");
        this.JRB_V29.setMaximumSize(new Dimension(55, 23));
        this.JRB_V29.setMinimumSize(new Dimension(55, 23));
        this.JRB_V29.setPreferredSize(new Dimension(55, 23));
        this.JRB_V29.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.27
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V29MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V30);
        this.JRB_V30.setFont(new Font("Arial", 1, 12));
        this.JRB_V30.setText("V30");
        this.JRB_V30.setMaximumSize(new Dimension(55, 23));
        this.JRB_V30.setMinimumSize(new Dimension(55, 23));
        this.JRB_V30.setPreferredSize(new Dimension(55, 23));
        this.JRB_V30.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.28
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V30MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V31);
        this.JRB_V31.setFont(new Font("Arial", 1, 12));
        this.JRB_V31.setText("V31");
        this.JRB_V31.setMaximumSize(new Dimension(55, 23));
        this.JRB_V31.setMinimumSize(new Dimension(55, 23));
        this.JRB_V31.setPreferredSize(new Dimension(55, 23));
        this.JRB_V31.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.29
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V31MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V32);
        this.JRB_V32.setFont(new Font("Arial", 1, 12));
        this.JRB_V32.setText("V32");
        this.JRB_V32.setMaximumSize(new Dimension(55, 23));
        this.JRB_V32.setMinimumSize(new Dimension(55, 23));
        this.JRB_V32.setPreferredSize(new Dimension(55, 23));
        this.JRB_V32.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.30
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V32MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V33);
        this.JRB_V33.setFont(new Font("Arial", 1, 12));
        this.JRB_V33.setText("V33");
        this.JRB_V33.setMaximumSize(new Dimension(55, 23));
        this.JRB_V33.setMinimumSize(new Dimension(55, 23));
        this.JRB_V33.setPreferredSize(new Dimension(55, 23));
        this.JRB_V33.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.31
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V33MouseClicked(evt);
            }
        });
        this.JRB_V33.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.32
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V33ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V34);
        this.JRB_V34.setFont(new Font("Arial", 1, 12));
        this.JRB_V34.setText("V34");
        this.JRB_V34.setMaximumSize(new Dimension(55, 23));
        this.JRB_V34.setMinimumSize(new Dimension(55, 23));
        this.JRB_V34.setPreferredSize(new Dimension(55, 23));
        this.JRB_V34.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.33
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V34MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V35);
        this.JRB_V35.setFont(new Font("Arial", 1, 12));
        this.JRB_V35.setText("V35");
        this.JRB_V35.setMaximumSize(new Dimension(55, 23));
        this.JRB_V35.setMinimumSize(new Dimension(55, 23));
        this.JRB_V35.setPreferredSize(new Dimension(55, 23));
        this.JRB_V35.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.34
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V35MouseClicked(evt);
            }
        });
        this.JRB_V35.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.35
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V35ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V36);
        this.JRB_V36.setFont(new Font("Arial", 1, 12));
        this.JRB_V36.setText("V36");
        this.JRB_V36.setMaximumSize(new Dimension(55, 23));
        this.JRB_V36.setMinimumSize(new Dimension(55, 23));
        this.JRB_V36.setPreferredSize(new Dimension(55, 23));
        this.JRB_V36.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.36
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V36MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V37);
        this.JRB_V37.setFont(new Font("Arial", 1, 12));
        this.JRB_V37.setText("V37");
        this.JRB_V37.setMaximumSize(new Dimension(55, 23));
        this.JRB_V37.setMinimumSize(new Dimension(55, 23));
        this.JRB_V37.setPreferredSize(new Dimension(55, 23));
        this.JRB_V37.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.37
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V37MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V38);
        this.JRB_V38.setFont(new Font("Arial", 1, 12));
        this.JRB_V38.setText("V38");
        this.JRB_V38.setMaximumSize(new Dimension(55, 23));
        this.JRB_V38.setMinimumSize(new Dimension(55, 23));
        this.JRB_V38.setPreferredSize(new Dimension(55, 23));
        this.JRB_V38.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.38
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V38MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V39);
        this.JRB_V39.setFont(new Font("Arial", 1, 12));
        this.JRB_V39.setText("V39");
        this.JRB_V39.setMaximumSize(new Dimension(55, 23));
        this.JRB_V39.setMinimumSize(new Dimension(55, 23));
        this.JRB_V39.setPreferredSize(new Dimension(55, 23));
        this.JRB_V39.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.39
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V39MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V40);
        this.JRB_V40.setFont(new Font("Arial", 1, 12));
        this.JRB_V40.setText("V40");
        this.JRB_V40.setMaximumSize(new Dimension(55, 23));
        this.JRB_V40.setMinimumSize(new Dimension(55, 23));
        this.JRB_V40.setPreferredSize(new Dimension(55, 23));
        this.JRB_V40.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.40
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V40MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V41);
        this.JRB_V41.setFont(new Font("Arial", 1, 12));
        this.JRB_V41.setText("V41");
        this.JRB_V41.setMaximumSize(new Dimension(55, 23));
        this.JRB_V41.setMinimumSize(new Dimension(55, 23));
        this.JRB_V41.setPreferredSize(new Dimension(55, 23));
        this.JRB_V41.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.41
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V41MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V42);
        this.JRB_V42.setFont(new Font("Arial", 1, 12));
        this.JRB_V42.setText("V42");
        this.JRB_V42.setMaximumSize(new Dimension(55, 23));
        this.JRB_V42.setMinimumSize(new Dimension(55, 23));
        this.JRB_V42.setPreferredSize(new Dimension(55, 23));
        this.JRB_V42.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.42
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V42MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V43);
        this.JRB_V43.setFont(new Font("Arial", 1, 12));
        this.JRB_V43.setText("V43");
        this.JRB_V43.setMaximumSize(new Dimension(55, 23));
        this.JRB_V43.setMinimumSize(new Dimension(55, 23));
        this.JRB_V43.setPreferredSize(new Dimension(55, 23));
        this.JRB_V43.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.43
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V43MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V44);
        this.JRB_V44.setFont(new Font("Arial", 1, 12));
        this.JRB_V44.setText("V44");
        this.JRB_V44.setMaximumSize(new Dimension(55, 23));
        this.JRB_V44.setMinimumSize(new Dimension(55, 23));
        this.JRB_V44.setPreferredSize(new Dimension(55, 23));
        this.JRB_V44.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.44
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V44MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V45);
        this.JRB_V45.setFont(new Font("Arial", 1, 12));
        this.JRB_V45.setText("V45");
        this.JRB_V45.setMaximumSize(new Dimension(55, 23));
        this.JRB_V45.setMinimumSize(new Dimension(55, 23));
        this.JRB_V45.setPreferredSize(new Dimension(55, 23));
        this.JRB_V45.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.45
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V45MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V46);
        this.JRB_V46.setFont(new Font("Arial", 1, 12));
        this.JRB_V46.setText("V46");
        this.JRB_V46.setMaximumSize(new Dimension(55, 23));
        this.JRB_V46.setMinimumSize(new Dimension(55, 23));
        this.JRB_V46.setPreferredSize(new Dimension(55, 23));
        this.JRB_V46.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.46
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V46MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V47);
        this.JRB_V47.setFont(new Font("Arial", 1, 12));
        this.JRB_V47.setText("V47");
        this.JRB_V47.setMaximumSize(new Dimension(55, 23));
        this.JRB_V47.setMinimumSize(new Dimension(55, 23));
        this.JRB_V47.setPreferredSize(new Dimension(55, 23));
        this.JRB_V47.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.47
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V47MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V48);
        this.JRB_V48.setFont(new Font("Arial", 1, 12));
        this.JRB_V48.setText("V48");
        this.JRB_V48.setMaximumSize(new Dimension(55, 23));
        this.JRB_V48.setMinimumSize(new Dimension(55, 23));
        this.JRB_V48.setPreferredSize(new Dimension(55, 23));
        this.JRB_V48.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.48
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V48MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V49);
        this.JRB_V49.setFont(new Font("Arial", 1, 12));
        this.JRB_V49.setText("V49");
        this.JRB_V49.setMaximumSize(new Dimension(55, 23));
        this.JRB_V49.setMinimumSize(new Dimension(55, 23));
        this.JRB_V49.setPreferredSize(new Dimension(55, 23));
        this.JRB_V49.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.49
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V49MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V50);
        this.JRB_V50.setFont(new Font("Arial", 1, 12));
        this.JRB_V50.setText("V50");
        this.JRB_V50.setMaximumSize(new Dimension(55, 23));
        this.JRB_V50.setMinimumSize(new Dimension(55, 23));
        this.JRB_V50.setPreferredSize(new Dimension(55, 23));
        this.JRB_V50.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.50
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V50MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V51);
        this.JRB_V51.setFont(new Font("Arial", 1, 12));
        this.JRB_V51.setText("V51");
        this.JRB_V51.setMaximumSize(new Dimension(55, 23));
        this.JRB_V51.setMinimumSize(new Dimension(55, 23));
        this.JRB_V51.setPreferredSize(new Dimension(55, 23));
        this.JRB_V51.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.51
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V51MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V52);
        this.JRB_V52.setFont(new Font("Arial", 1, 12));
        this.JRB_V52.setText("V52");
        this.JRB_V52.setMaximumSize(new Dimension(55, 23));
        this.JRB_V52.setMinimumSize(new Dimension(55, 23));
        this.JRB_V52.setPreferredSize(new Dimension(55, 23));
        this.JRB_V52.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.52
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V52MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V53);
        this.JRB_V53.setFont(new Font("Arial", 1, 12));
        this.JRB_V53.setText("V53");
        this.JRB_V53.setMaximumSize(new Dimension(55, 23));
        this.JRB_V53.setMinimumSize(new Dimension(55, 23));
        this.JRB_V53.setPreferredSize(new Dimension(55, 23));
        this.JRB_V53.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.53
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V53MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V54);
        this.JRB_V54.setFont(new Font("Arial", 1, 12));
        this.JRB_V54.setText("V54");
        this.JRB_V54.setMaximumSize(new Dimension(55, 23));
        this.JRB_V54.setMinimumSize(new Dimension(55, 23));
        this.JRB_V54.setPreferredSize(new Dimension(55, 23));
        this.JRB_V54.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.54
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V54MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V55);
        this.JRB_V55.setFont(new Font("Arial", 1, 12));
        this.JRB_V55.setText("V55");
        this.JRB_V55.setMaximumSize(new Dimension(55, 23));
        this.JRB_V55.setMinimumSize(new Dimension(55, 23));
        this.JRB_V55.setPreferredSize(new Dimension(55, 23));
        this.JRB_V55.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.55
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V55MouseClicked(evt);
            }
        });
        this.JRB_V55.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.56
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V55ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V56);
        this.JRB_V56.setFont(new Font("Arial", 1, 12));
        this.JRB_V56.setText("V56");
        this.JRB_V56.setMaximumSize(new Dimension(55, 23));
        this.JRB_V56.setMinimumSize(new Dimension(55, 23));
        this.JRB_V56.setPreferredSize(new Dimension(55, 23));
        this.JRB_V56.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.57
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V56MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V57);
        this.JRB_V57.setFont(new Font("Arial", 1, 12));
        this.JRB_V57.setText("V57");
        this.JRB_V57.setMaximumSize(new Dimension(55, 23));
        this.JRB_V57.setMinimumSize(new Dimension(55, 23));
        this.JRB_V57.setPreferredSize(new Dimension(55, 23));
        this.JRB_V57.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.58
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V57MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V58);
        this.JRB_V58.setFont(new Font("Arial", 1, 12));
        this.JRB_V58.setText("V58");
        this.JRB_V58.setMaximumSize(new Dimension(55, 23));
        this.JRB_V58.setMinimumSize(new Dimension(55, 23));
        this.JRB_V58.setPreferredSize(new Dimension(55, 23));
        this.JRB_V58.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.59
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V58MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V59);
        this.JRB_V59.setFont(new Font("Arial", 1, 12));
        this.JRB_V59.setText("V59");
        this.JRB_V59.setMaximumSize(new Dimension(55, 23));
        this.JRB_V59.setMinimumSize(new Dimension(55, 23));
        this.JRB_V59.setPreferredSize(new Dimension(55, 23));
        this.JRB_V59.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.60
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V59MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V60);
        this.JRB_V60.setFont(new Font("Arial", 1, 12));
        this.JRB_V60.setText("V60");
        this.JRB_V60.setMaximumSize(new Dimension(55, 23));
        this.JRB_V60.setMinimumSize(new Dimension(55, 23));
        this.JRB_V60.setPreferredSize(new Dimension(55, 23));
        this.JRB_V60.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.61
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V60MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V61);
        this.JRB_V61.setFont(new Font("Arial", 1, 12));
        this.JRB_V61.setText("V61");
        this.JRB_V61.setMaximumSize(new Dimension(55, 23));
        this.JRB_V61.setMinimumSize(new Dimension(55, 23));
        this.JRB_V61.setPreferredSize(new Dimension(55, 23));
        this.JRB_V61.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.62
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V61MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V62);
        this.JRB_V62.setFont(new Font("Arial", 1, 12));
        this.JRB_V62.setText("V62");
        this.JRB_V62.setMaximumSize(new Dimension(55, 23));
        this.JRB_V62.setMinimumSize(new Dimension(55, 23));
        this.JRB_V62.setPreferredSize(new Dimension(55, 23));
        this.JRB_V62.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.63
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V62MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V63);
        this.JRB_V63.setFont(new Font("Arial", 1, 12));
        this.JRB_V63.setText("V63");
        this.JRB_V63.setMaximumSize(new Dimension(55, 23));
        this.JRB_V63.setMinimumSize(new Dimension(55, 23));
        this.JRB_V63.setPreferredSize(new Dimension(55, 23));
        this.JRB_V63.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.64
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V63MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V64);
        this.JRB_V64.setFont(new Font("Arial", 1, 12));
        this.JRB_V64.setText("V64");
        this.JRB_V64.setMaximumSize(new Dimension(55, 23));
        this.JRB_V64.setMinimumSize(new Dimension(55, 23));
        this.JRB_V64.setPreferredSize(new Dimension(55, 23));
        this.JRB_V64.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.65
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V64MouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V65);
        this.JRB_V65.setFont(new Font("Arial", 1, 12));
        this.JRB_V65.setText("V65");
        this.JRB_V65.setMaximumSize(new Dimension(55, 23));
        this.JRB_V65.setMinimumSize(new Dimension(55, 23));
        this.JRB_V65.setPreferredSize(new Dimension(55, 23));
        this.JRB_V65.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.66
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V65MouseClicked(evt);
            }
        });
        this.JRB_V65.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.67
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V65ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V66);
        this.JRB_V66.setFont(new Font("Arial", 1, 12));
        this.JRB_V66.setText("V66");
        this.JRB_V66.setMaximumSize(new Dimension(55, 23));
        this.JRB_V66.setMinimumSize(new Dimension(55, 23));
        this.JRB_V66.setPreferredSize(new Dimension(55, 23));
        this.JRB_V66.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.68
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V66MouseClicked(evt);
            }
        });
        this.JRB_V66.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.69
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V66ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V67);
        this.JRB_V67.setFont(new Font("Arial", 1, 12));
        this.JRB_V67.setText("V67");
        this.JRB_V67.setMaximumSize(new Dimension(55, 23));
        this.JRB_V67.setMinimumSize(new Dimension(55, 23));
        this.JRB_V67.setPreferredSize(new Dimension(55, 23));
        this.JRB_V67.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.70
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V67MouseClicked(evt);
            }
        });
        this.JRB_V67.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.71
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V67ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V68);
        this.JRB_V68.setFont(new Font("Arial", 1, 12));
        this.JRB_V68.setText("V68");
        this.JRB_V68.setMaximumSize(new Dimension(55, 23));
        this.JRB_V68.setMinimumSize(new Dimension(55, 23));
        this.JRB_V68.setPreferredSize(new Dimension(55, 23));
        this.JRB_V68.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.72
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V68MouseClicked(evt);
            }
        });
        this.JRB_V68.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.73
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V68ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V69);
        this.JRB_V69.setFont(new Font("Arial", 1, 12));
        this.JRB_V69.setText("V69");
        this.JRB_V69.setMaximumSize(new Dimension(55, 23));
        this.JRB_V69.setMinimumSize(new Dimension(55, 23));
        this.JRB_V69.setPreferredSize(new Dimension(55, 23));
        this.JRB_V69.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.74
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V69MouseClicked(evt);
            }
        });
        this.JRB_V69.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.75
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V69ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V70);
        this.JRB_V70.setFont(new Font("Arial", 1, 12));
        this.JRB_V70.setText("V70");
        this.JRB_V70.setMaximumSize(new Dimension(55, 23));
        this.JRB_V70.setMinimumSize(new Dimension(55, 23));
        this.JRB_V70.setPreferredSize(new Dimension(55, 23));
        this.JRB_V70.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.76
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V70MouseClicked(evt);
            }
        });
        this.JRB_V70.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.77
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V70ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V71);
        this.JRB_V71.setFont(new Font("Arial", 1, 12));
        this.JRB_V71.setText("V71");
        this.JRB_V71.setMaximumSize(new Dimension(55, 23));
        this.JRB_V71.setMinimumSize(new Dimension(55, 23));
        this.JRB_V71.setPreferredSize(new Dimension(55, 23));
        this.JRB_V71.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.78
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V71MouseClicked(evt);
            }
        });
        this.JRB_V71.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.79
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V71ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V72);
        this.JRB_V72.setFont(new Font("Arial", 1, 12));
        this.JRB_V72.setText("V72");
        this.JRB_V72.setMaximumSize(new Dimension(55, 23));
        this.JRB_V72.setMinimumSize(new Dimension(55, 23));
        this.JRB_V72.setPreferredSize(new Dimension(55, 23));
        this.JRB_V72.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.80
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V72MouseClicked(evt);
            }
        });
        this.JRB_V72.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.81
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V72ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V73);
        this.JRB_V73.setFont(new Font("Arial", 1, 12));
        this.JRB_V73.setText("V73");
        this.JRB_V73.setMaximumSize(new Dimension(55, 23));
        this.JRB_V73.setMinimumSize(new Dimension(55, 23));
        this.JRB_V73.setPreferredSize(new Dimension(55, 23));
        this.JRB_V73.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.82
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V73MouseClicked(evt);
            }
        });
        this.JRB_V73.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.83
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V73ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V74);
        this.JRB_V74.setFont(new Font("Arial", 1, 12));
        this.JRB_V74.setText("V74");
        this.JRB_V74.setMaximumSize(new Dimension(55, 23));
        this.JRB_V74.setMinimumSize(new Dimension(55, 23));
        this.JRB_V74.setPreferredSize(new Dimension(55, 23));
        this.JRB_V74.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.84
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V74MouseClicked(evt);
            }
        });
        this.JRB_V74.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.85
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V74ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V75);
        this.JRB_V75.setFont(new Font("Arial", 1, 12));
        this.JRB_V75.setText("V75");
        this.JRB_V75.setMaximumSize(new Dimension(55, 23));
        this.JRB_V75.setMinimumSize(new Dimension(55, 23));
        this.JRB_V75.setPreferredSize(new Dimension(55, 23));
        this.JRB_V75.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.86
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V75MouseClicked(evt);
            }
        });
        this.JRB_V75.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.87
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V75ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V76);
        this.JRB_V76.setFont(new Font("Arial", 1, 12));
        this.JRB_V76.setText("V76");
        this.JRB_V76.setMaximumSize(new Dimension(55, 23));
        this.JRB_V76.setMinimumSize(new Dimension(55, 23));
        this.JRB_V76.setPreferredSize(new Dimension(55, 23));
        this.JRB_V76.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.88
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V76MouseClicked(evt);
            }
        });
        this.JRB_V76.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.89
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V76ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V77);
        this.JRB_V77.setFont(new Font("Arial", 1, 12));
        this.JRB_V77.setText("V77");
        this.JRB_V77.setMaximumSize(new Dimension(55, 23));
        this.JRB_V77.setMinimumSize(new Dimension(55, 23));
        this.JRB_V77.setPreferredSize(new Dimension(55, 23));
        this.JRB_V77.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.90
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V77MouseClicked(evt);
            }
        });
        this.JRB_V77.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.91
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V77ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V78);
        this.JRB_V78.setFont(new Font("Arial", 1, 12));
        this.JRB_V78.setText("V78");
        this.JRB_V78.setMaximumSize(new Dimension(55, 23));
        this.JRB_V78.setMinimumSize(new Dimension(55, 23));
        this.JRB_V78.setPreferredSize(new Dimension(55, 23));
        this.JRB_V78.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.92
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V78MouseClicked(evt);
            }
        });
        this.JRB_V78.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.93
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V78ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V79);
        this.JRB_V79.setFont(new Font("Arial", 1, 12));
        this.JRB_V79.setText("V79");
        this.JRB_V79.setMaximumSize(new Dimension(55, 23));
        this.JRB_V79.setMinimumSize(new Dimension(55, 23));
        this.JRB_V79.setPreferredSize(new Dimension(55, 23));
        this.JRB_V79.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.94
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V79MouseClicked(evt);
            }
        });
        this.JRB_V79.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.95
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V79ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V80);
        this.JRB_V80.setFont(new Font("Arial", 1, 12));
        this.JRB_V80.setText("V80");
        this.JRB_V80.setMaximumSize(new Dimension(55, 23));
        this.JRB_V80.setMinimumSize(new Dimension(55, 23));
        this.JRB_V80.setPreferredSize(new Dimension(55, 23));
        this.JRB_V80.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.96
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V80MouseClicked(evt);
            }
        });
        this.JRB_V80.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.97
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V80ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V81);
        this.JRB_V81.setFont(new Font("Arial", 1, 12));
        this.JRB_V81.setText("V81");
        this.JRB_V81.setMaximumSize(new Dimension(55, 23));
        this.JRB_V81.setMinimumSize(new Dimension(55, 23));
        this.JRB_V81.setPreferredSize(new Dimension(55, 23));
        this.JRB_V81.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.98
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V81MouseClicked(evt);
            }
        });
        this.JRB_V81.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.99
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V81ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V82);
        this.JRB_V82.setFont(new Font("Arial", 1, 12));
        this.JRB_V82.setText("V82");
        this.JRB_V82.setMaximumSize(new Dimension(55, 23));
        this.JRB_V82.setMinimumSize(new Dimension(55, 23));
        this.JRB_V82.setPreferredSize(new Dimension(55, 23));
        this.JRB_V82.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.100
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V82MouseClicked(evt);
            }
        });
        this.JRB_V82.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.101
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V82ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V83);
        this.JRB_V83.setFont(new Font("Arial", 1, 12));
        this.JRB_V83.setText("V83");
        this.JRB_V83.setMaximumSize(new Dimension(55, 23));
        this.JRB_V83.setMinimumSize(new Dimension(55, 23));
        this.JRB_V83.setPreferredSize(new Dimension(55, 23));
        this.JRB_V83.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.102
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V83MouseClicked(evt);
            }
        });
        this.JRB_V83.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.103
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V83ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V84);
        this.JRB_V84.setFont(new Font("Arial", 1, 12));
        this.JRB_V84.setText("V84");
        this.JRB_V84.setMaximumSize(new Dimension(55, 23));
        this.JRB_V84.setMinimumSize(new Dimension(55, 23));
        this.JRB_V84.setPreferredSize(new Dimension(55, 23));
        this.JRB_V84.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.104
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V84MouseClicked(evt);
            }
        });
        this.JRB_V84.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.105
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V84ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V85);
        this.JRB_V85.setFont(new Font("Arial", 1, 12));
        this.JRB_V85.setText("V85");
        this.JRB_V85.setMaximumSize(new Dimension(55, 23));
        this.JRB_V85.setMinimumSize(new Dimension(55, 23));
        this.JRB_V85.setPreferredSize(new Dimension(55, 23));
        this.JRB_V85.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.106
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V85MouseClicked(evt);
            }
        });
        this.JRB_V85.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.107
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V85ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V86);
        this.JRB_V86.setFont(new Font("Arial", 1, 12));
        this.JRB_V86.setText("V86");
        this.JRB_V86.setMaximumSize(new Dimension(55, 23));
        this.JRB_V86.setMinimumSize(new Dimension(55, 23));
        this.JRB_V86.setPreferredSize(new Dimension(55, 23));
        this.JRB_V86.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.108
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V86MouseClicked(evt);
            }
        });
        this.JRB_V86.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.109
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V86ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V87);
        this.JRB_V87.setFont(new Font("Arial", 1, 12));
        this.JRB_V87.setText("V87");
        this.JRB_V87.setMaximumSize(new Dimension(55, 23));
        this.JRB_V87.setMinimumSize(new Dimension(55, 23));
        this.JRB_V87.setPreferredSize(new Dimension(55, 23));
        this.JRB_V87.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.110
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V87MouseClicked(evt);
            }
        });
        this.JRB_V87.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.111
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V87ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V88);
        this.JRB_V88.setFont(new Font("Arial", 1, 12));
        this.JRB_V88.setText("V88");
        this.JRB_V88.setMaximumSize(new Dimension(55, 23));
        this.JRB_V88.setMinimumSize(new Dimension(55, 23));
        this.JRB_V88.setPreferredSize(new Dimension(55, 23));
        this.JRB_V88.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.112
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V88MouseClicked(evt);
            }
        });
        this.JRB_V88.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.113
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V88ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V89);
        this.JRB_V89.setFont(new Font("Arial", 1, 12));
        this.JRB_V89.setText("V89");
        this.JRB_V89.setMaximumSize(new Dimension(55, 23));
        this.JRB_V89.setMinimumSize(new Dimension(55, 23));
        this.JRB_V89.setPreferredSize(new Dimension(55, 23));
        this.JRB_V89.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.114
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V89MouseClicked(evt);
            }
        });
        this.JRB_V89.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.115
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V89ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V90);
        this.JRB_V90.setFont(new Font("Arial", 1, 12));
        this.JRB_V90.setText("V90");
        this.JRB_V90.setMaximumSize(new Dimension(55, 23));
        this.JRB_V90.setMinimumSize(new Dimension(55, 23));
        this.JRB_V90.setPreferredSize(new Dimension(55, 23));
        this.JRB_V90.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.116
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V90MouseClicked(evt);
            }
        });
        this.JRB_V90.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.117
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V90ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V91);
        this.JRB_V91.setFont(new Font("Arial", 1, 12));
        this.JRB_V91.setText("V91");
        this.JRB_V91.setMaximumSize(new Dimension(55, 23));
        this.JRB_V91.setMinimumSize(new Dimension(55, 23));
        this.JRB_V91.setPreferredSize(new Dimension(55, 23));
        this.JRB_V91.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.118
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V91MouseClicked(evt);
            }
        });
        this.JRB_V91.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.119
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V91ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V92);
        this.JRB_V92.setFont(new Font("Arial", 1, 12));
        this.JRB_V92.setText("V92");
        this.JRB_V92.setMaximumSize(new Dimension(55, 23));
        this.JRB_V92.setMinimumSize(new Dimension(55, 23));
        this.JRB_V92.setPreferredSize(new Dimension(55, 23));
        this.JRB_V92.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.120
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V92MouseClicked(evt);
            }
        });
        this.JRB_V92.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.121
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V92ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V93);
        this.JRB_V93.setFont(new Font("Arial", 1, 12));
        this.JRB_V93.setText("V93");
        this.JRB_V93.setMaximumSize(new Dimension(55, 23));
        this.JRB_V93.setMinimumSize(new Dimension(55, 23));
        this.JRB_V93.setPreferredSize(new Dimension(55, 23));
        this.JRB_V93.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.122
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V93MouseClicked(evt);
            }
        });
        this.JRB_V93.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.123
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V93ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V94);
        this.JRB_V94.setFont(new Font("Arial", 1, 12));
        this.JRB_V94.setText("V94");
        this.JRB_V94.setMaximumSize(new Dimension(55, 23));
        this.JRB_V94.setMinimumSize(new Dimension(55, 23));
        this.JRB_V94.setPreferredSize(new Dimension(55, 23));
        this.JRB_V94.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.124
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V94MouseClicked(evt);
            }
        });
        this.JRB_V94.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.125
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V94ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V95);
        this.JRB_V95.setFont(new Font("Arial", 1, 12));
        this.JRB_V95.setText("V95");
        this.JRB_V95.setMaximumSize(new Dimension(55, 23));
        this.JRB_V95.setMinimumSize(new Dimension(55, 23));
        this.JRB_V95.setPreferredSize(new Dimension(55, 23));
        this.JRB_V95.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.126
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V95MouseClicked(evt);
            }
        });
        this.JRB_V95.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.127
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V95ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V96);
        this.JRB_V96.setFont(new Font("Arial", 1, 12));
        this.JRB_V96.setText("V96");
        this.JRB_V96.setMaximumSize(new Dimension(55, 23));
        this.JRB_V96.setMinimumSize(new Dimension(55, 23));
        this.JRB_V96.setPreferredSize(new Dimension(55, 23));
        this.JRB_V96.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.128
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V96MouseClicked(evt);
            }
        });
        this.JRB_V96.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.129
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V96ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V97);
        this.JRB_V97.setFont(new Font("Arial", 1, 12));
        this.JRB_V97.setText("V97");
        this.JRB_V97.setMaximumSize(new Dimension(55, 23));
        this.JRB_V97.setMinimumSize(new Dimension(55, 23));
        this.JRB_V97.setPreferredSize(new Dimension(55, 23));
        this.JRB_V97.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.130
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V97MouseClicked(evt);
            }
        });
        this.JRB_V97.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.131
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V97ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V98);
        this.JRB_V98.setFont(new Font("Arial", 1, 12));
        this.JRB_V98.setText("V98");
        this.JRB_V98.setMaximumSize(new Dimension(55, 23));
        this.JRB_V98.setMinimumSize(new Dimension(55, 23));
        this.JRB_V98.setPreferredSize(new Dimension(55, 23));
        this.JRB_V98.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.132
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V98MouseClicked(evt);
            }
        });
        this.JRB_V98.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.133
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V98ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V99);
        this.JRB_V99.setFont(new Font("Arial", 1, 12));
        this.JRB_V99.setText("V99");
        this.JRB_V99.setMaximumSize(new Dimension(55, 23));
        this.JRB_V99.setMinimumSize(new Dimension(55, 23));
        this.JRB_V99.setPreferredSize(new Dimension(55, 23));
        this.JRB_V99.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.134
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V99MouseClicked(evt);
            }
        });
        this.JRB_V99.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.135
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V99ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V100);
        this.JRB_V100.setFont(new Font("Arial", 1, 12));
        this.JRB_V100.setText("V100");
        this.JRB_V100.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.136
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V100MouseClicked(evt);
            }
        });
        this.JRB_V100.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.137
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V100ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V101);
        this.JRB_V101.setFont(new Font("Arial", 1, 12));
        this.JRB_V101.setText("V101");
        this.JRB_V101.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.138
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V101MouseClicked(evt);
            }
        });
        this.JRB_V101.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.139
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V101ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V102);
        this.JRB_V102.setFont(new Font("Arial", 1, 12));
        this.JRB_V102.setText("V102");
        this.JRB_V102.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.140
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V102MouseClicked(evt);
            }
        });
        this.JRB_V102.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.141
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V102ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V103);
        this.JRB_V103.setFont(new Font("Arial", 1, 12));
        this.JRB_V103.setText("V103");
        this.JRB_V103.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.142
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V103MouseClicked(evt);
            }
        });
        this.JRB_V103.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.143
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V103ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V104);
        this.JRB_V104.setFont(new Font("Arial", 1, 12));
        this.JRB_V104.setText("V104");
        this.JRB_V104.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.144
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V104MouseClicked(evt);
            }
        });
        this.JRB_V104.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.145
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V104ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V105);
        this.JRB_V105.setFont(new Font("Arial", 1, 12));
        this.JRB_V105.setText("V105");
        this.JRB_V105.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.146
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V105MouseClicked(evt);
            }
        });
        this.JRB_V105.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.147
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V105ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V106);
        this.JRB_V106.setFont(new Font("Arial", 1, 12));
        this.JRB_V106.setText("V106");
        this.JRB_V106.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.148
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V106MouseClicked(evt);
            }
        });
        this.JRB_V106.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.149
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V106ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V107);
        this.JRB_V107.setFont(new Font("Arial", 1, 12));
        this.JRB_V107.setText("V107");
        this.JRB_V107.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.150
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V107MouseClicked(evt);
            }
        });
        this.JRB_V107.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.151
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V107ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V108);
        this.JRB_V108.setFont(new Font("Arial", 1, 12));
        this.JRB_V108.setText("V108");
        this.JRB_V108.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.152
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V108MouseClicked(evt);
            }
        });
        this.JRB_V108.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.153
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V108ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V109);
        this.JRB_V109.setFont(new Font("Arial", 1, 12));
        this.JRB_V109.setText("V109");
        this.JRB_V109.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.154
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V109MouseClicked(evt);
            }
        });
        this.JRB_V109.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.155
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V109ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V110);
        this.JRB_V110.setFont(new Font("Arial", 1, 12));
        this.JRB_V110.setText("V110");
        this.JRB_V110.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.156
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V110MouseClicked(evt);
            }
        });
        this.JRB_V110.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.157
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V110ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V111);
        this.JRB_V111.setFont(new Font("Arial", 1, 12));
        this.JRB_V111.setText("V111");
        this.JRB_V111.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.158
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V111MouseClicked(evt);
            }
        });
        this.JRB_V111.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.159
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V111ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V112);
        this.JRB_V112.setFont(new Font("Arial", 1, 12));
        this.JRB_V112.setText("V112");
        this.JRB_V112.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.160
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V112MouseClicked(evt);
            }
        });
        this.JRB_V112.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.161
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V112ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V113);
        this.JRB_V113.setFont(new Font("Arial", 1, 12));
        this.JRB_V113.setText("V113");
        this.JRB_V113.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.162
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V113MouseClicked(evt);
            }
        });
        this.JRB_V113.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.163
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V113ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V114);
        this.JRB_V114.setFont(new Font("Arial", 1, 12));
        this.JRB_V114.setText("V114");
        this.JRB_V114.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.164
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V114MouseClicked(evt);
            }
        });
        this.JRB_V114.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.165
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V114ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V115);
        this.JRB_V115.setFont(new Font("Arial", 1, 12));
        this.JRB_V115.setText("V115");
        this.JRB_V115.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.166
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V115MouseClicked(evt);
            }
        });
        this.JRB_V115.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.167
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V115ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V116);
        this.JRB_V116.setFont(new Font("Arial", 1, 12));
        this.JRB_V116.setText("V116");
        this.JRB_V116.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.168
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V116MouseClicked(evt);
            }
        });
        this.JRB_V116.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.169
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V116ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V117);
        this.JRB_V117.setFont(new Font("Arial", 1, 12));
        this.JRB_V117.setText("V117");
        this.JRB_V117.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.170
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V117MouseClicked(evt);
            }
        });
        this.JRB_V117.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.171
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V117ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRB_V118);
        this.JRB_V118.setFont(new Font("Arial", 1, 12));
        this.JRB_V118.setText("V118");
        this.JRB_V118.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInfR4505.172
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInfR4505.this.JRB_V118MouseClicked(evt);
            }
        });
        this.JRB_V118.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.173
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.JRB_V118ActionPerformed(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton1.setText("Actualizar por lotes");
        this.jButton1.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.174
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton2.setText("Limpiar tabla");
        this.jButton2.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInfR4505.175
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInfR4505.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout JPIPreparacionLayout = new GroupLayout(this.JPIPreparacion);
        this.JPIPreparacion.setLayout(JPIPreparacionLayout);
        JPIPreparacionLayout.setHorizontalGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreparacionLayout.createSequentialGroup().addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreparacionLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jButton1, -2, 445, -2).addGap(484, 484, 484).addComponent(this.jButton2, -2, 369, -2)).addGroup(JPIPreparacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_V14, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V15, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V16, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V17, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V18, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V19, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V20, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V21, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V22, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V23, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V24, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V25, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V26, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V27, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V28, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V29, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V30, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V31, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V32, -2, 55, -2)).addGroup(JPIPreparacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_V33, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V34, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V35, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V36, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V37, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V38, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V39, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V40, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V41, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V42, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V43, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V44, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V45, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V46, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V47, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V48, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V49, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V50, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V51, -2, 55, -2)).addGroup(JPIPreparacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_V52, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V53, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V54, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V55, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V56, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V57, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V58, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V59, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V60, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V61, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V62, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V63, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V64, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V65, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V66, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V67, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V68, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V69, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V70, -2, 55, -2)).addGroup(JPIPreparacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_V71, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V72, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V73, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V74, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V75, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V76, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V77, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V78, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V79, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V80, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V81, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V82, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V83, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V84, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V85, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V86, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V87, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V88, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V89, -2, 55, -2)).addGroup(JPIPreparacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_V90, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V91, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V92, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V93, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V94, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V95, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V96, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V97, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V98, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V99, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V100, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V101, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V102, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V103, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V104, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V105, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V106, -2, 55, -2)).addGroup(JPIPreparacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_V107, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V108, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V109, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V110, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V111, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V112, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V113, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V114, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V115, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V116, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V117, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_V118, -2, 55, -2))).addGap(24, 24, 24)));
        JPIPreparacionLayout.setVerticalGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreparacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V14, -2, -1, -2).addComponent(this.JRB_V15, -2, -1, -2).addComponent(this.JRB_V16, -2, -1, -2).addComponent(this.JRB_V17, -2, -1, -2).addComponent(this.JRB_V18, -2, -1, -2).addComponent(this.JRB_V19, -2, -1, -2).addComponent(this.JRB_V20, -2, -1, -2).addComponent(this.JRB_V21, -2, -1, -2).addComponent(this.JRB_V22, -2, -1, -2).addComponent(this.JRB_V23, -2, -1, -2).addComponent(this.JRB_V24, -2, -1, -2).addComponent(this.JRB_V25, -2, -1, -2).addComponent(this.JRB_V26, -2, -1, -2).addComponent(this.JRB_V27, -2, -1, -2).addComponent(this.JRB_V28, -2, -1, -2).addComponent(this.JRB_V29, -2, -1, -2).addComponent(this.JRB_V30, -2, -1, -2).addComponent(this.JRB_V31, -2, -1, -2).addComponent(this.JRB_V32, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V33, -2, -1, -2).addComponent(this.JRB_V34, -2, -1, -2).addComponent(this.JRB_V35, -2, -1, -2).addComponent(this.JRB_V36, -2, -1, -2).addComponent(this.JRB_V37, -2, -1, -2).addComponent(this.JRB_V38, -2, -1, -2).addComponent(this.JRB_V39, -2, -1, -2).addComponent(this.JRB_V40, -2, -1, -2).addComponent(this.JRB_V41, -2, -1, -2).addComponent(this.JRB_V42, -2, -1, -2).addComponent(this.JRB_V43, -2, -1, -2).addComponent(this.JRB_V44, -2, -1, -2).addComponent(this.JRB_V45, -2, -1, -2).addComponent(this.JRB_V46, -2, -1, -2).addComponent(this.JRB_V47, -2, -1, -2).addComponent(this.JRB_V48, -2, -1, -2).addComponent(this.JRB_V49, -2, -1, -2).addComponent(this.JRB_V50, -2, -1, -2).addComponent(this.JRB_V51, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V52, -2, -1, -2).addComponent(this.JRB_V53, -2, -1, -2).addComponent(this.JRB_V54, -2, -1, -2).addComponent(this.JRB_V55, -2, -1, -2).addComponent(this.JRB_V56, -2, -1, -2).addComponent(this.JRB_V57, -2, -1, -2).addComponent(this.JRB_V58, -2, -1, -2).addComponent(this.JRB_V59, -2, -1, -2).addComponent(this.JRB_V60, -2, -1, -2).addComponent(this.JRB_V61, -2, -1, -2).addComponent(this.JRB_V62, -2, -1, -2).addComponent(this.JRB_V63, -2, -1, -2).addComponent(this.JRB_V64, -2, -1, -2).addComponent(this.JRB_V65, -2, -1, -2).addComponent(this.JRB_V66, -2, -1, -2).addComponent(this.JRB_V67, -2, -1, -2).addComponent(this.JRB_V68, -2, -1, -2).addComponent(this.JRB_V69, -2, -1, -2).addComponent(this.JRB_V70, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V71, -2, -1, -2).addComponent(this.JRB_V72, -2, -1, -2).addComponent(this.JRB_V73, -2, -1, -2).addComponent(this.JRB_V74, -2, -1, -2).addComponent(this.JRB_V75, -2, -1, -2).addComponent(this.JRB_V76, -2, -1, -2).addComponent(this.JRB_V77, -2, -1, -2).addComponent(this.JRB_V78, -2, -1, -2).addComponent(this.JRB_V79, -2, -1, -2).addComponent(this.JRB_V80, -2, -1, -2).addComponent(this.JRB_V81, -2, -1, -2).addComponent(this.JRB_V82, -2, -1, -2).addComponent(this.JRB_V83, -2, -1, -2).addComponent(this.JRB_V84, -2, -1, -2).addComponent(this.JRB_V85, -2, -1, -2).addComponent(this.JRB_V86, -2, -1, -2).addComponent(this.JRB_V87, -2, -1, -2).addComponent(this.JRB_V88, -2, -1, -2).addComponent(this.JRB_V89, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V90, -2, -1, -2).addComponent(this.JRB_V91, -2, -1, -2).addComponent(this.JRB_V92, -2, -1, -2).addComponent(this.JRB_V93, -2, -1, -2).addComponent(this.JRB_V94, -2, -1, -2).addComponent(this.JRB_V95, -2, -1, -2).addComponent(this.JRB_V96, -2, -1, -2).addComponent(this.JRB_V97, -2, -1, -2).addComponent(this.JRB_V98, -2, -1, -2).addComponent(this.JRB_V99, -2, -1, -2).addComponent(this.JRB_V100).addComponent(this.JRB_V101).addComponent(this.JRB_V102).addComponent(this.JRB_V103).addComponent(this.JRB_V104).addComponent(this.JRB_V105).addComponent(this.JRB_V106)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_V107).addComponent(this.JRB_V108).addComponent(this.JRB_V109).addComponent(this.JRB_V110).addComponent(this.JRB_V111).addComponent(this.JRB_V112).addComponent(this.JRB_V113).addComponent(this.JRB_V114).addComponent(this.JRB_V115).addComponent(this.JRB_V116).addComponent(this.JRB_V117).addComponent(this.JRB_V118)).addGap(48, 48, 48).addGroup(JPIPreparacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 48, -2).addComponent(this.jButton2, -2, 48, -2)).addGap(334, 334, 334)));
        this.JTPDatos.addTab("PREPARACIÓN", this.JPIPreparacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        mGenerarNit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V15MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V15.getText(), this, this.JRB_V15);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V16MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V16.getText(), this, this.JRB_V16);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V17MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V17.getText(), this, this.JRB_V17);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V18MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V18.getText(), this, this.JRB_V18);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V19MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V19.getText(), this, this.JRB_V19);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V20MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V20.getText(), this, this.JRB_V20);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V21MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V21.getText(), this, this.JRB_V21);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V22MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V22.getText(), this, this.JRB_V22);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V23MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V23.getText(), this, this.JRB_V23);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V24MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V24.getText(), this, this.JRB_V24);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V25MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V25.getText(), this, this.JRB_V25);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V26MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V26.getText(), this, this.JRB_V26);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V27MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V27.getText(), this, this.JRB_V27);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V28MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V28.getText(), this, this.JRB_V28);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V29MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V29.getText(), this, this.JRB_V29);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V30MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V30.getText(), this, this.JRB_V30);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V31MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V31.getText(), this, this.JRB_V31);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V32MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V32.getText(), this, this.JRB_V32);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V33MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V33.getText(), this, this.JRB_V33);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V34MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V34.getText(), this, this.JRB_V34);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V35MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V35.getText(), this, this.JRB_V35);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V36MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V36.getText(), this, this.JRB_V36);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V37MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V37.getText(), this, this.JRB_V37);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V38MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V38.getText(), this, this.JRB_V38);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V39MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V39.getText(), this, this.JRB_V39);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V40MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V40.getText(), this, this.JRB_V40);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V41MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V41.getText(), this, this.JRB_V41);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V42MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V42.getText(), this, this.JRB_V42);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V43MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V43.getText(), this, this.JRB_V43);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V44MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V44.getText(), this, this.JRB_V44);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V45MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V45.getText(), this, this.JRB_V45);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V46MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V46.getText(), this, this.JRB_V46);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V47MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V47.getText(), this, this.JRB_V47);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V48MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V48.getText(), this, this.JRB_V48);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V49MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V49.getText(), this, this.JRB_V49);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V50MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V50.getText(), this, this.JRB_V50);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V51MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V51.getText(), this, this.JRB_V51);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V52MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V52.getText(), this, this.JRB_V52);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V53MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V53.getText(), this, this.JRB_V53);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V54MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V54.getText(), this, this.JRB_V54);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V55MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V55.getText(), this, this.JRB_V55);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V56MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V56.getText(), this, this.JRB_V56);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V57MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V57.getText(), this, this.JRB_V57);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V58MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V58.getText(), this, this.JRB_V58);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V59MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V59.getText(), this, this.JRB_V59);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V60MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V60.getText(), this, this.JRB_V60);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V61MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V61.getText(), this, this.JRB_V61);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V62MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V62.getText(), this, this.JRB_V62);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V63MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V63.getText(), this, this.JRB_V63);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V64MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V64.getText(), this, this.JRB_V64);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V65MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V65.getText(), this, this.JRB_V65);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V65ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V65.getText(), this, this.JRB_V65);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V66MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V66.getText(), this, this.JRB_V66);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V66ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V66.getText(), this, this.JRB_V66);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V67MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V67.getText(), this, this.JRB_V67);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V67ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V67.getText(), this, this.JRB_V67);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V68MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V68.getText(), this, this.JRB_V68);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V68ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V68.getText(), this, this.JRB_V68);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V69.getText(), this, this.JRB_V69);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V69ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V69.getText(), this, this.JRB_V69);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V70.getText(), this, this.JRB_V70);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V70ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V70.getText(), this, this.JRB_V70);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V71MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V71.getText(), this, this.JRB_V71);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V71ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V71.getText(), this, this.JRB_V71);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V72MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V72.getText(), this, this.JRB_V72);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V72ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V72.getText(), this, this.JRB_V72);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V73MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V73.getText(), this, this.JRB_V73);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V73ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V73.getText(), this, this.JRB_V73);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V74MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V74.getText(), this, this.JRB_V74);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V74ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V74.getText(), this, this.JRB_V74);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V75MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V75.getText(), this, this.JRB_V75);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V75ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V75.getText(), this, this.JRB_V75);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V76MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V76.getText(), this, this.JRB_V76);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V76ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V76.getText(), this, this.JRB_V76);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V77MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V77.getText(), this, this.JRB_V77);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V77ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V77.getText(), this, this.JRB_V77);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V78MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V78.getText(), this, this.JRB_V78);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V78ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V78.getText(), this, this.JRB_V78);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V79MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V79.getText(), this, this.JRB_V79);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V79ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V79.getText(), this, this.JRB_V79);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V80MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V80.getText(), this, this.JRB_V80);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V80ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V80.getText(), this, this.JRB_V80);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V81MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V81.getText(), this, this.JRB_V81);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V81ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V81.getText(), this, this.JRB_V81);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V82MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V82.getText(), this, this.JRB_V82);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V82ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V82.getText(), this, this.JRB_V82);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V83MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V83.getText(), this, this.JRB_V83);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V83ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V83.getText(), this, this.JRB_V83);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V84MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V84.getText(), this, this.JRB_V84);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V84ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V84.getText(), this, this.JRB_V84);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V85MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V85.getText(), this, this.JRB_V85);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V85ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V85.getText(), this, this.JRB_V85);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V86MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V86.getText(), this, this.JRB_V86);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V86ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V86.getText(), this, this.JRB_V86);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V87MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V87.getText(), this, this.JRB_V87);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V87ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V87.getText(), this, this.JRB_V87);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V88MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V88.getText(), this, this.JRB_V88);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V88ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V88.getText(), this, this.JRB_V88);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V89MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V89.getText(), this, this.JRB_V89);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V89ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V89.getText(), this, this.JRB_V89);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V90MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V90.getText(), this, this.JRB_V90);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V90ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V90.getText(), this, this.JRB_V90);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V91MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V91.getText(), this, this.JRB_V91);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V91ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V91.getText(), this, this.JRB_V91);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V92MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V92.getText(), this, this.JRB_V92);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V92ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V92.getText(), this, this.JRB_V92);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V93MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V93.getText(), this, this.JRB_V93);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V93ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V93.getText(), this, this.JRB_V93);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V94MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V94.getText(), this, this.JRB_V94);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V94ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V94.getText(), this, this.JRB_V94);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V95MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V95.getText(), this, this.JRB_V95);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V95ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V95.getText(), this, this.JRB_V95);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V96MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V96.getText(), this, this.JRB_V96);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V96ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V96.getText(), this, this.JRB_V96);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V97MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V97.getText(), this, this.JRB_V97);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V97ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V97.getText(), this, this.JRB_V97);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V98MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V98.getText(), this, this.JRB_V98);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V98ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V98.getText(), this, this.JRB_V98);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V99MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V99.getText(), this, this.JRB_V99);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V99ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V99.getText(), this, this.JRB_V99);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V100MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V100.getText(), this, this.JRB_V100);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V100ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V100.getText(), this, this.JRB_V100);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V101MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V101.getText(), this, this.JRB_V101);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V101ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V101.getText(), this, this.JRB_V101);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V102MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V102.getText(), this, this.JRB_V102);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V102ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V102.getText(), this, this.JRB_V102);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V103MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V103.getText(), this, this.JRB_V103);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V103ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V103.getText(), this, this.JRB_V103);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V104MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V104.getText(), this, this.JRB_V104);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V104ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V104.getText(), this, this.JRB_V104);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V105MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V105.getText(), this, this.JRB_V105);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V105ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V105.getText(), this, this.JRB_V105);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V106MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V106.getText(), this, this.JRB_V106);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V106ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V106.getText(), this, this.JRB_V106);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V107MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V107.getText(), this, this.JRB_V107);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V107ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V107.getText(), this, this.JRB_V107);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V108MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V108.getText(), this, this.JRB_V108);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V108ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V108.getText(), this, this.JRB_V108);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V109MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V109.getText(), this, this.JRB_V109);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V109ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V109.getText(), this, this.JRB_V109);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V110MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V110.getText(), this, this.JRB_V110);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V110ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V110.getText(), this, this.JRB_V110);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V111MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V111.getText(), this, this.JRB_V111);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V111ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V111.getText(), this, this.JRB_V111);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V112MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V112.getText(), this, this.JRB_V112);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V112ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V112.getText(), this, this.JRB_V112);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V113MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V113.getText(), this, this.JRB_V113);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V113ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V113.getText(), this, this.JRB_V113);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V114MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V114.getText(), this, this.JRB_V114);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V114ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V114.getText(), this, this.JRB_V114);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V115MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V115.getText(), this, this.JRB_V115);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V115ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V115.getText(), this, this.JRB_V115);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V116MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V116.getText(), this, this.JRB_V116);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V116ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V116.getText(), this, this.JRB_V116);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V117MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V117.getText(), this, this.JRB_V117);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V117ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V117.getText(), this, this.JRB_V117);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V118MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V118.getText(), this, this.JRB_V118);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V118ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V118.getText(), this, this.JRB_V118);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V14MouseClicked(MouseEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V14.getText(), this, this.JRB_V14);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V28ActionPerformed(ActionEvent evt) {
        JDR_Variables_4505 dialog = new JDR_Variables_4505(null, true, this.JRB_V28.getText(), this, this.JRB_V28);
        dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
        dialog.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V35ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V14ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        for (int x = 0; x < this.JPIPreparacion.getComponentCount(); x++) {
            System.out.println(this.JPIPreparacion.getComponent(x).getClass().toString());
            if (this.JPIPreparacion.getComponent(x).getClass().toString().equals("class javax.swing.JRadioButton")) {
                try {
                    JRadioButton xbt = this.JPIPreparacion.getComponent(x);
                    System.out.println(">>>>>" + xbt.getText());
                    if (this.resolucion.equals("4505")) {
                        this.xsql = "SELECT `Descripcion` , `NSql`, `NParametros`, `Tipo` FROM `p_res_4505_sql` WHERE (`NVariable` ='" + xbt.getText() + "' AND Estado=1) ORDER BY ORDEN ASC ";
                    } else if (this.resolucion.equals("202")) {
                        this.xsql = "SELECT `Descripcion` , `NSql`, `NParametros`, `Tipo` FROM `p_res_4505_sql_nueva` WHERE (`NVariable` ='" + xbt.getText() + "' AND Estado=1) ORDER BY ORDEN ASC ";
                    }
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    ResultSet xrs = xct1.traerRs(this.xsql);
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            PreparedStatement xpt = this.xct.establecerConexionBd().prepareStatement(xrs.getString(2));
                            if (xrs.getInt(3) == 1) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 2) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 3) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 4) {
                                xpt.setString(1, this.xmt.formatoANO.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 5) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 6) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 7) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 8) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 9) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 10) {
                                xpt.setString(1, this.xmt.formatoANO.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 11) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 12) {
                                xpt.setString(1, this.xmt.formatoANO.format(this.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 13) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                            } else if (xrs.getInt(3) == 14) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 15) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 16) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                            } else if (xrs.getInt(3) == 17) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                            } else if (xrs.getInt(3) == 18) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 19) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 20) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 21) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(9, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(10, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 22) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(9, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(10, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(11, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(12, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 23) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(9, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 24) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 25) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(8, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(9, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(10, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(11, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(12, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 26) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 27) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 28) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 27) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(5, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(7, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(6, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            } else if (xrs.getInt(3) == 29) {
                                xpt.setString(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(2, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                                xpt.setString(3, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
                                xpt.setString(4, this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                            }
                            if (xrs.getInt(4) == 1) {
                                String xSql_Vista = xpt.toString().substring(44, xpt.toString().length());
                                System.out.println(xSql_Vista);
                                xpt.close();
                                this.xct.cerrarConexionBd();
                                this.xsql = "DROP VIEW IF EXISTS v_r_tmp";
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                                this.xsql = "CREATE VIEW  `v_r_tmp`  AS " + xSql_Vista;
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                                if (this.resolucion.equals("4505")) {
                                    this.xsql = "UPDATE `p_res_4505_set_datos`, `v_r_tmp`  SET p_res_4505_set_datos." + xbt.getText() + "=v_r_tmp.Valor WHERE p_res_4505_R.`Id_Persona`=v_r_tmp.Id_Persona ";
                                } else if (this.resolucion.equals("202")) {
                                    this.xsql = "UPDATE `p_res_4505_202_set_datos`, `v_r_tmp`  SET p_res_4505_202_set_datos." + xbt.getText() + "=v_r_tmp.Valor WHERE p_res_4505_R.`Id_Persona`=v_r_tmp.Id_Persona ";
                                }
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                                xbt.setForeground(Color.red);
                            } else if (xrs.getInt(4) == 0) {
                                System.out.println(xpt);
                                System.out.println(xpt.toString().substring(44, xpt.toString().length()));
                                xpt.execute();
                                xpt.close();
                                this.xct.cerrarConexionBd();
                                xbt.setForeground(Color.red);
                            } else if (xrs.getInt(4) == 3) {
                                String xSql_Vista2 = xrs.getString("NSql");
                                System.out.println("consula impre" + xSql_Vista2);
                                this.xct.ejecutarSQL(xSql_Vista2);
                                this.xct.cerrarConexionBd();
                                xbt.setForeground(Color.red);
                            } else if (xrs.getInt(4) == 4) {
                                System.out.println(xpt);
                                System.out.println(xpt.toString().substring(44, xpt.toString().length()));
                                xpt.execute();
                                xpt.close();
                                this.xct.cerrarConexionBd();
                                xbt.setForeground(Color.red);
                            }
                        }
                    }
                    xrs.close();
                    xct1.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFConsultarInfR4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (this.resolucion.equals("4505")) {
            this.xsql = "delete from p_res_4505_set_datos ";
        } else if (this.resolucion.equals("202")) {
            this.xsql = "delete from p_res_4505_202_set_datos ";
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V33ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_MunicipioActionPerformed(ActionEvent evt) {
        if (this.xlleno) {
            mLlenarComboFiltro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_DepartamentoActionPerformed(ActionEvent evt) {
        if (this.xlleno) {
            mLlenarComboFiltro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_NoAplicaActionPerformed(ActionEvent evt) {
        if (this.xlleno) {
            mLlenarComboFiltro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_V55ActionPerformed(ActionEvent evt) {
    }

    private void mCargarDatosTabla_FB() {
        try {
            mCrearTabla();
            this.xnregistro = 0L;
            if (Principal.informacionIps.getIdentificacion().equals("812001219")) {
                if (this.JCHEstado.isSelected()) {
                    this.xsql = "SELECT  `g_ips`.`CodigoOrganismo`,`persona`.`Id_TipoIdentificacion`,`persona`.`NoDocumento`,TRIM(`persona`.`Apellido1`),TRIM(`persona`.`Apellido2`),TRIM(`persona`.`Nombre1`),TRIM(`persona`.`Nombre2`),`persona`.`FechaNac` ,`persona`.`IdSexo` ,    \n`persona`.`IdEtnia` , ifnull(`ingreso`.`Id_Ocupacion`,9999) Id_Ocupacion,ifnull(`ingreso`.`Id_NivelEstudio`,2) Id_NivelEstudio,p_res_4505_set_datos.`Id_Persona`    \n FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`) left JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)     \n WHERE (`p_res_4505_set_datos`.`Id_Convenio`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' ) GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id ASC ";
                    System.out.println("Uno   " + this.xsql);
                } else {
                    this.xsql = "SELECT  `g_ips`.`CodigoOrganismo`,`persona`.`Id_TipoIdentificacion`,`persona`.`NoDocumento`,TRIM(`persona`.`Apellido1`),TRIM(`persona`.`Apellido2`),TRIM(`persona`.`Nombre1`),TRIM(`persona`.`Nombre2`),`persona`.`FechaNac` ,`persona`.`IdSexo` , `persona`.`IdEtnia` , `ingreso`.`Id_Ocupacion`,`ingreso`.`Id_NivelEstudio`,p_res_4505_set_datos.`Id_Persona` FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND p_res_4505_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id asc  ";
                    System.out.println("Uno   " + this.xsql);
                }
            } else if (this.xEstado == 1) {
                this.xsql = "SELECT  `g_ips`.`CodigoOrganismo`,`persona`.`Id_TipoIdentificacion`,`persona`.`NoDocumento`,TRIM(`persona`.`Apellido1`),TRIM(`persona`.`Apellido2`),TRIM(`persona`.`Nombre1`),TRIM(`persona`.`Nombre2`),`persona`.`FechaNac` ,`persona`.`IdSexo` ,    \n`persona`.`IdEtnia` , `ingreso`.`Id_Ocupacion`,`ingreso`.`Id_NivelEstudio`,p_res_4505_set_datos.`Id_Persona`    \n FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)     \n WHERE (`p_res_4505_set_datos`.`Id_Convenio`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND  p_res_4505_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id ASC ";
                System.out.println("Uno   " + this.xsql);
            } else {
                this.xsql = "SELECT  `g_ips`.`CodigoOrganismo`,`persona`.`Id_TipoIdentificacion`,`persona`.`NoDocumento`,TRIM(`persona`.`Apellido1`),TRIM(`persona`.`Apellido2`),TRIM(`persona`.`Nombre1`),TRIM(`persona`.`Nombre2`),`persona`.`FechaNac` ,`persona`.`IdSexo` , `persona`.`IdEtnia` , `ingreso`.`Id_Ocupacion`,`ingreso`.`Id_NivelEstudio`,p_res_4505_set_datos.`Id_Persona` FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND p_res_4505_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id asc  ";
                System.out.println("Uno   " + this.xsql);
            }
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(Integer.valueOf(i + 1), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo.setValueAt(rs.getString(10), i, 9);
                    this.xmodelo.setValueAt(rs.getString(11), i, 10);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(12)), i, 11);
                    i++;
                }
                this.xnregistro = i + 1;
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfR4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla_FB_202() {
        try {
            mCrearTabla();
            this.xnregistro = 0L;
            if (Principal.informacionIps.getIdentificacion().equals("812001219")) {
                if (this.JCHEstado.isSelected()) {
                    this.xsql = "SELECT  `g_ips`.`CodigoOrganismo`,`persona`.`Id_TipoIdentificacion`,`persona`.`NoDocumento`,TRIM(`persona`.`Apellido1`),TRIM(`persona`.`Apellido2`),TRIM(`persona`.`Nombre1`),TRIM(`persona`.`Nombre2`),`persona`.`FechaNac` ,`persona`.`IdSexo` ,    \n`persona`.`IdEtnia` , ifnull(`ingreso`.`Id_Ocupacion`,9999) Id_Ocupacion,ifnull(`ingreso`.`Id_NivelEstudio`,2) Id_NivelEstudio,p_res_4505_202_set_datos.`Id_Persona`    \n FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`) left JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)     \n WHERE (`p_res_4505_202_set_datos`.`Id_Convenio`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id ASC ";
                    System.out.println("Uno   " + this.xsql);
                } else {
                    this.xsql = "SELECT  `g_ips`.`CodigoOrganismo`,`persona`.`Id_TipoIdentificacion`,`persona`.`NoDocumento`,TRIM(`persona`.`Apellido1`),TRIM(`persona`.`Apellido2`),TRIM(`persona`.`Nombre1`),TRIM(`persona`.`Nombre2`),`persona`.`FechaNac` ,`persona`.`IdSexo` , `persona`.`IdEtnia` , `ingreso`.`Id_Ocupacion`,`ingreso`.`Id_NivelEstudio`,p_res_4505_202_set_datos.`Id_Persona` FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   inner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) WHERE (fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                    System.out.println("Uno   " + this.xsql);
                }
            } else if (this.xEstado == 1) {
                this.xsql = "SELECT  `g_ips`.`CodigoOrganismo`,`persona`.`Id_TipoIdentificacion`,`persona`.`NoDocumento`,TRIM(`persona`.`Apellido1`),TRIM(`persona`.`Apellido2`),TRIM(`persona`.`Nombre1`),TRIM(`persona`.`Nombre2`),`persona`.`FechaNac` ,`persona`.`IdSexo` ,    \n`persona`.`IdEtnia` , `ingreso`.`Id_Ocupacion`,`ingreso`.`Id_NivelEstudio`,p_res_4505_202_set_datos.`Id_Persona`    \n FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)     \n WHERE (`p_res_4505_202_set_datos`.`Id_Convenio`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' AND  p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id ASC ";
                System.out.println("Uno   " + this.xsql);
            } else {
                this.xsql = "  SELECT\n  `g_ips`.`CodigoOrganismo`,`persona`.`Id_TipoIdentificacion`,`persona`.`NoDocumento`,TRIM(`persona`.`Apellido1`),TRIM(`persona`.`Apellido2`),TRIM(`persona`.`Nombre1`),\n  TRIM(`persona`.`Nombre2`),`persona`.`FechaNac`,`persona`.`IdSexo`,`persona`.`IdEtnia`,`ingreso`.`Id_Ocupacion`,`ingreso`.`Id_NivelEstudio`,p_res_4505_202_set_datos.`Id_Persona`\nFROM `g_ips`,`persona`\nINNER JOIN `p_res_4505_202_set_datos`  ON (    `persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona` )\nINNER JOIN `ingreso`  ON ( `ingreso`.`Id_Usuario` = `persona`.`Id_persona` )\nWHERE ( `persona`.IdEmpresaCont = '" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'  AND p_res_4505_202_set_datos.`Actualizado` = 1)\nGROUP BY `p_res_4505_202_set_datos`.`Id_Persona`\nORDER BY p_res_4505_202_set_datos.Id ASC";
                System.out.println("Uno   " + this.xsql);
            }
            ResultSet rs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int i = 0;
                    while (rs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(rs.getString(1), i, 0);
                        this.xmodelo.setValueAt(Integer.valueOf(i + 1), i, 1);
                        this.xmodelo.setValueAt(rs.getString(3), i, 2);
                        this.xmodelo.setValueAt(rs.getString(4), i, 3);
                        this.xmodelo.setValueAt(rs.getString(5), i, 4);
                        this.xmodelo.setValueAt(rs.getString(6), i, 5);
                        this.xmodelo.setValueAt(rs.getString(7), i, 6);
                        this.xmodelo.setValueAt(rs.getString(8), i, 7);
                        this.xmodelo.setValueAt(rs.getString(9), i, 8);
                        this.xmodelo.setValueAt(rs.getString(10), i, 9);
                        this.xmodelo.setValueAt(rs.getString(11), i, 10);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(12)), i, 11);
                        i++;
                    }
                    this.xnregistro = i + 1;
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarInfR4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGenerarNit() {
        System.err.println("entrA");
        int con = 0;
        for (int x = 1; x < Principal.informacionIps.getIdentificacion().length() + 1; x++) {
            con = x;
            System.err.println("cuenta" + con);
        }
        String P = Principal.informacionIps.getIdentificacion();
        int resul = 12 - con;
        System.err.println("sale" + resul);
        switch (resul) {
            case 1:
                this.xNombre = "0" + P;
                System.err.println("nombre" + this.xNombre);
                if (this.resolucion.equals("4505")) {
                    mCrearArchivo(this.xNombre);
                } else if (this.resolucion.equals("202")) {
                    mCrearArchivo_202(this.xNombre);
                }
                break;
            case 2:
                this.xNombre = "00" + P;
                System.err.println("nombre" + this.xNombre);
                if (this.resolucion.equals("4505")) {
                    mCrearArchivo(this.xNombre);
                } else if (this.resolucion.equals("202")) {
                    mCrearArchivo_202(this.xNombre);
                }
                break;
            case 3:
                this.xNombre = "000" + P;
                System.err.println("nombre" + this.xNombre);
                if (this.resolucion.equals("4505")) {
                    mCrearArchivo(this.xNombre);
                } else if (this.resolucion.equals("202")) {
                    mCrearArchivo_202(this.xNombre);
                }
                break;
            case 4:
                this.xNombre = "0000" + P;
                System.err.println("nombre" + this.xNombre);
                if (this.resolucion.equals("4505")) {
                    mCrearArchivo(this.xNombre);
                } else if (this.resolucion.equals("202")) {
                    mCrearArchivo_202(this.xNombre);
                }
                break;
            default:
                this.xNombre = P;
                System.err.println("nombre" + this.xNombre);
                if (this.resolucion.equals("4505")) {
                    mCrearArchivo(this.xNombre);
                } else if (this.resolucion.equals("202")) {
                    mCrearArchivo_202(this.xNombre);
                }
                break;
        }
    }

    private void mCrearArchivo(String xNit) {
        String xregimen;
        System.err.println("dentro del metodo" + xNit);
        if (this.xEstado == 1) {
            System.out.println("combo" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2]);
            xregimen = this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2];
        } else {
            xregimen = "S";
        }
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "SGD280RPED" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate()) + Principal.informacionIps.getIdTipoIdentificacion() + xNit + xregimen + "01.txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            if (Principal.informacionIps.getIdentificacion().equals("812001219")) {
                if (this.JCHEstado.isSelected()) {
                    this.xsql = "SELECT   CONCAT(`g_ips`.`CodigoOrganismo`,'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', TRIM(`persona`.`Apellido1`),'|', TRIM(`persona`.`Apellido2`),'|', TRIM(`persona`.`Nombre1`),'|', TRIM(`persona`.`Nombre2`),'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|',ifnull(`ingreso`.`Id_Ocupacion`,9999),'|',ifnull(`ingreso`.`Id_NivelEstudio`,2),'|', `p_res_4505_set_datos`.`V14`,'|', `p_res_4505_set_datos`.`V15`,'|', `p_res_4505_set_datos`.`V16`,'|', `p_res_4505_set_datos`.`V17`,'|', `p_res_4505_set_datos`.`V18`,'|', `p_res_4505_set_datos`.`V19`,'|', `p_res_4505_set_datos`.`V20`,'|', `p_res_4505_set_datos`.`V21`,'|', `p_res_4505_set_datos`.`V22` ,'|', `p_res_4505_set_datos`.`V23`,'|', `p_res_4505_set_datos`.`V24`,'|', `p_res_4505_set_datos`.`V25`,'|', `p_res_4505_set_datos`.`V26`,'|', `p_res_4505_set_datos`.`V27`,'|', `p_res_4505_set_datos`.`V28`,'|', `p_res_4505_set_datos`.`V29`,'|', `p_res_4505_set_datos`.`V30`,'|', `p_res_4505_set_datos`.`V31`,'|', `p_res_4505_set_datos`.`V32`,'|', `p_res_4505_set_datos`.`V33`,'|', `p_res_4505_set_datos`.`V34`,'|', `p_res_4505_set_datos`.`V35` ,'|', `p_res_4505_set_datos`.`V36`,'|', `p_res_4505_set_datos`.`V37`,'|', `p_res_4505_set_datos`.`V38`,'|', `p_res_4505_set_datos`.`V39`,'|', `p_res_4505_set_datos`.`V40`,'|', `p_res_4505_set_datos`.`V41`,'|', `p_res_4505_set_datos`.`V42`,'|', `p_res_4505_set_datos`.`V43`,'|', `p_res_4505_set_datos`.`V44`,'|', `p_res_4505_set_datos`.`V45`,'|', `p_res_4505_set_datos`.`V46`,'|', `p_res_4505_set_datos`.`V47`,'|', `p_res_4505_set_datos`.`V48`,'|', `p_res_4505_set_datos`.`V49` ,'|', `p_res_4505_set_datos`.`V50`,'|', `p_res_4505_set_datos`.`V51`,'|', `p_res_4505_set_datos`.`V52`,'|', `p_res_4505_set_datos`.`V53`,'|', `p_res_4505_set_datos`.`V54`,'|', `p_res_4505_set_datos`.`V55`,'|', `p_res_4505_set_datos`.`V56`,'|', `p_res_4505_set_datos`.`V57`,'|', `p_res_4505_set_datos`.`V58`,'|', `p_res_4505_set_datos`.`V59`,'|', `p_res_4505_set_datos`.`V60`,'|', `p_res_4505_set_datos`.`V61`,'|', `p_res_4505_set_datos`.`V62`,'|', `p_res_4505_set_datos`.`V63` ,'|', `p_res_4505_set_datos`.`V64`,'|', `p_res_4505_set_datos`.`V65`,'|', `p_res_4505_set_datos`.`V66`,'|',`p_res_4505_set_datos`.`V67`,'|', `p_res_4505_set_datos`.`V68`,'|', `p_res_4505_set_datos`.`V69`,'|', `p_res_4505_set_datos`.`V70`,'|', `p_res_4505_set_datos`.`V71`,'|', `p_res_4505_set_datos`.`V72`,'|', `p_res_4505_set_datos`.`V73`,'|', `p_res_4505_set_datos`.`V74`,'|', `p_res_4505_set_datos`.`V75`,'|', `p_res_4505_set_datos`.`V76`,'|', `p_res_4505_set_datos`.`V77`,'|', `p_res_4505_set_datos`.`V78` ,'|',`p_res_4505_set_datos`.`V79`,'|',`p_res_4505_set_datos`.`V80`,'|', `p_res_4505_set_datos`.`V81`,'|',`p_res_4505_set_datos`.`V82`,'|', `p_res_4505_set_datos`.`V83`,'|', `p_res_4505_set_datos`.`V84`,'|', `p_res_4505_set_datos`.`V85`,'|', `p_res_4505_set_datos`.`V86`,'|', `p_res_4505_set_datos`.`V87`,'|', `p_res_4505_set_datos`.`V88`,'|', `p_res_4505_set_datos`.`V89`,'|', `p_res_4505_set_datos`.`V90`,'|', `p_res_4505_set_datos`.`V91`,'|', `p_res_4505_set_datos`.`V92`,'|', `p_res_4505_set_datos`.`V93` ,'|',`p_res_4505_set_datos`.`V94`,'|', `p_res_4505_set_datos`.`V95`,'|',`p_res_4505_set_datos`.`V96`,'|',`p_res_4505_set_datos`.`V97`,'|', `p_res_4505_set_datos`.`V98`,'|',`p_res_4505_set_datos`.`V99`,'|', `p_res_4505_set_datos`.`V100`,'|', `p_res_4505_set_datos`.`V101`,'|', `p_res_4505_set_datos`.`V102`,'|', `p_res_4505_set_datos`.`V103`,'|', `p_res_4505_set_datos`.`V104`,'|', `p_res_4505_set_datos`.`V105`,'|', `p_res_4505_set_datos`.`V106`,'|', if(`p_res_4505_set_datos`.`V107`=1,'1.0',if(`p_res_4505_set_datos`.`V107`=2,'2.0',`p_res_4505_set_datos`.`V107`)) ,'|',`p_res_4505_set_datos`.`V108`,'|', `p_res_4505_set_datos`.`V109`,'|', `p_res_4505_set_datos`.`V110`,'|', `p_res_4505_set_datos`.`V111`,'|', `p_res_4505_set_datos`.`V112`,'|', `p_res_4505_set_datos`.`V113`,'|', `p_res_4505_set_datos`.`V114`,'|', `p_res_4505_set_datos`.`V115`,'|', `p_res_4505_set_datos`.`V116`,'|', `p_res_4505_set_datos`.`V117`,'|', `p_res_4505_set_datos`.`V118` ) AS Linea FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`) left JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' and persona.CodNMunicipio='" + this.xIdMunicipio[this.JCB_MUnicipio.getSelectedIndex()] + "') GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id asc  ";
                } else {
                    this.xsql = "SELECT   CONCAT(`g_ips`.`CodigoOrganismo`,'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', TRIM(`persona`.`Apellido1`),'|', TRIM(`persona`.`Apellido2`),'|', TRIM(`persona`.`Nombre1`),'|', TRIM(`persona`.`Nombre2`),'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_set_datos`.`V14`,'|', `p_res_4505_set_datos`.`V15`,'|', `p_res_4505_set_datos`.`V16`,'|', `p_res_4505_set_datos`.`V17`,'|', `p_res_4505_set_datos`.`V18`,'|', `p_res_4505_set_datos`.`V19`,'|', `p_res_4505_set_datos`.`V20`,'|', `p_res_4505_set_datos`.`V21`,'|', `p_res_4505_set_datos`.`V22` ,'|', `p_res_4505_set_datos`.`V23`,'|', `p_res_4505_set_datos`.`V24`,'|', `p_res_4505_set_datos`.`V25`,'|', `p_res_4505_set_datos`.`V26`,'|', `p_res_4505_set_datos`.`V27`,'|', `p_res_4505_set_datos`.`V28`,'|', `p_res_4505_set_datos`.`V29`,'|', `p_res_4505_set_datos`.`V30`,'|', `p_res_4505_set_datos`.`V31`,'|', `p_res_4505_set_datos`.`V32`,'|', `p_res_4505_set_datos`.`V33`,'|', `p_res_4505_set_datos`.`V34`,'|', `p_res_4505_set_datos`.`V35` ,'|', `p_res_4505_set_datos`.`V36`,'|', `p_res_4505_set_datos`.`V37`,'|', `p_res_4505_set_datos`.`V38`,'|', `p_res_4505_set_datos`.`V39`,'|', `p_res_4505_set_datos`.`V40`,'|', `p_res_4505_set_datos`.`V41`,'|', `p_res_4505_set_datos`.`V42`,'|', `p_res_4505_set_datos`.`V43`,'|', `p_res_4505_set_datos`.`V44`,'|', `p_res_4505_set_datos`.`V45`,'|', `p_res_4505_set_datos`.`V46`,'|', `p_res_4505_set_datos`.`V47`,'|', `p_res_4505_set_datos`.`V48`,'|', `p_res_4505_set_datos`.`V49` ,'|', `p_res_4505_set_datos`.`V50`,'|', `p_res_4505_set_datos`.`V51`,'|', `p_res_4505_set_datos`.`V52`,'|', `p_res_4505_set_datos`.`V53`,'|', `p_res_4505_set_datos`.`V54`,'|', `p_res_4505_set_datos`.`V55`,'|', `p_res_4505_set_datos`.`V56`,'|', `p_res_4505_set_datos`.`V57`,'|', `p_res_4505_set_datos`.`V58`,'|', `p_res_4505_set_datos`.`V59`,'|', `p_res_4505_set_datos`.`V60`,'|', `p_res_4505_set_datos`.`V61`,'|', `p_res_4505_set_datos`.`V62`,'|', `p_res_4505_set_datos`.`V63` ,'|', `p_res_4505_set_datos`.`V64`,'|', `p_res_4505_set_datos`.`V65`,'|', `p_res_4505_set_datos`.`V66`,'|',`p_res_4505_set_datos`.`V67`,'|', `p_res_4505_set_datos`.`V68`,'|', `p_res_4505_set_datos`.`V69`,'|', `p_res_4505_set_datos`.`V70`,'|', `p_res_4505_set_datos`.`V71`,'|', `p_res_4505_set_datos`.`V72`,'|', `p_res_4505_set_datos`.`V73`,'|', `p_res_4505_set_datos`.`V74`,'|', `p_res_4505_set_datos`.`V75`,'|', `p_res_4505_set_datos`.`V76`,'|', `p_res_4505_set_datos`.`V77`,'|', `p_res_4505_set_datos`.`V78` ,'|',`p_res_4505_set_datos`.`V79`,'|',`p_res_4505_set_datos`.`V80`,'|', `p_res_4505_set_datos`.`V81`,'|',`p_res_4505_set_datos`.`V82`,'|', `p_res_4505_set_datos`.`V83`,'|', `p_res_4505_set_datos`.`V84`,'|', `p_res_4505_set_datos`.`V85`,'|', `p_res_4505_set_datos`.`V86`,'|', `p_res_4505_set_datos`.`V87`,'|', `p_res_4505_set_datos`.`V88`,'|', `p_res_4505_set_datos`.`V89`,'|', `p_res_4505_set_datos`.`V90`,'|', `p_res_4505_set_datos`.`V91`,'|', `p_res_4505_set_datos`.`V92`,'|', `p_res_4505_set_datos`.`V93` ,'|',`p_res_4505_set_datos`.`V94`,'|', `p_res_4505_set_datos`.`V95`,'|',`p_res_4505_set_datos`.`V96`,'|',`p_res_4505_set_datos`.`V97`,'|', `p_res_4505_set_datos`.`V98`,'|',`p_res_4505_set_datos`.`V99`,'|', `p_res_4505_set_datos`.`V100`,'|', `p_res_4505_set_datos`.`V101`,'|', `p_res_4505_set_datos`.`V102`,'|', `p_res_4505_set_datos`.`V103`,'|', `p_res_4505_set_datos`.`V104`,'|', `p_res_4505_set_datos`.`V105`,'|', `p_res_4505_set_datos`.`V106`,'|', if(`p_res_4505_set_datos`.`V107`=1,'1.0',if(`p_res_4505_set_datos`.`V107`=2,'2.0',`p_res_4505_set_datos`.`V107`)) ,'|',`p_res_4505_set_datos`.`V108`,'|', `p_res_4505_set_datos`.`V109`,'|', `p_res_4505_set_datos`.`V110`,'|', `p_res_4505_set_datos`.`V111`,'|', `p_res_4505_set_datos`.`V112`,'|', `p_res_4505_set_datos`.`V113`,'|', `p_res_4505_set_datos`.`V114`,'|', `p_res_4505_set_datos`.`V115`,'|', `p_res_4505_set_datos`.`V116`,'|', `p_res_4505_set_datos`.`V117`,'|', `p_res_4505_set_datos`.`V118` ) AS Linea FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`AND p_res_4505_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id asc  ";
                    System.out.println("Formato B eps" + this.xsql);
                }
            } else if (this.JRBFormaA.isSelected()) {
                this.xsql = "SELECT   CONCAT(`g_ips`.`CodigoOrganismo`,'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505`.`V14`,'|', `p_res_4505`.`V15`,'|', `p_res_4505`.`V16`,'|', `p_res_4505`.`V17`,'|', `p_res_4505`.`V18`,'|', `p_res_4505`.`V19`,'|', `p_res_4505`.`V20`,'|', `p_res_4505`.`V21`,'|', `p_res_4505`.`V22` ,'|', `p_res_4505`.`V23`,'|', `p_res_4505`.`V24`,'|', `p_res_4505`.`V25`,'|', `p_res_4505`.`V26`,'|', `p_res_4505`.`V27`,'|', `p_res_4505`.`V28`,'|', `p_res_4505`.`V29`,'|', `p_res_4505`.`V30`,'|', `p_res_4505`.`V31`,'|', `p_res_4505`.`V32`,'|', `p_res_4505`.`V33`,'|', `p_res_4505`.`V34`,'|', `p_res_4505`.`V35` ,'|', `p_res_4505`.`V36`,'|', `p_res_4505`.`V37`,'|', `p_res_4505`.`V38`,'|', `p_res_4505`.`V39`,'|', `p_res_4505`.`V40`,'|', `p_res_4505`.`V41`,'|', `p_res_4505`.`V42`,'|', `p_res_4505`.`V43`,'|', `p_res_4505`.`V44`,'|', `p_res_4505`.`V45`,'|', `p_res_4505`.`V46`,'|', `p_res_4505`.`V47`,'|', `p_res_4505`.`V48`,'|', `p_res_4505`.`V49` ,'|', `p_res_4505`.`V50`,'|', `p_res_4505`.`V51`,'|', `p_res_4505`.`V52`,'|', `p_res_4505`.`V53`,'|', `p_res_4505`.`V54`,'|', `p_res_4505`.`V55`,'|', `p_res_4505`.`V56`,'|', `p_res_4505`.`V57`,'|', `p_res_4505`.`V58`,'|', `p_res_4505`.`V59`,'|', `p_res_4505`.`V60`,'|', `p_res_4505`.`V61`,'|', `p_res_4505`.`V62`,'|', `p_res_4505`.`V63` ,'|', `p_res_4505`.`V64`,'|', `p_res_4505`.`V65`,'|', `p_res_4505`.`V66`,'|',`p_res_4505`.`V67`,'|', `p_res_4505`.`V68`,'|', `p_res_4505`.`V69`,'|', `p_res_4505`.`V70`,'|', `p_res_4505`.`V71`,'|', `p_res_4505`.`V72`,'|', `p_res_4505`.`V73`,'|', `p_res_4505`.`V74`,'|', `p_res_4505`.`V75`,'|', `p_res_4505`.`V76`,'|', `p_res_4505`.`V77`,'|', `p_res_4505`.`V78` ,'|',`p_res_4505`.`V79`,'|',`p_res_4505`.`V80`,'|', `p_res_4505`.`V81`,'|',`p_res_4505`.`V82`,'|', `p_res_4505`.`V83`,'|', `p_res_4505`.`V84`,'|', `p_res_4505`.`V85`,'|', `p_res_4505`.`V86`,'|', `p_res_4505`.`V87`,'|', `p_res_4505`.`V88`,'|', `p_res_4505`.`V89`,'|', `p_res_4505`.`V90`,'|', `p_res_4505`.`V91`,'|', `p_res_4505`.`V92`,'|', `p_res_4505`.`V93` ,'|',`p_res_4505`.`V94`,'|', `p_res_4505`.`V95`,'|',`p_res_4505`.`V96`,'|',`p_res_4505`.`V97`,'|', `p_res_4505`.`V98`,'|',`p_res_4505`.`V99`,'|', `p_res_4505`.`V100`,'|', `p_res_4505`.`V101`,'|', `p_res_4505`.`V102`,'|', `p_res_4505`.`V103`,'|', `p_res_4505`.`V104`,'|', `p_res_4505`.`V105`,'|', `p_res_4505`.`V106`,'|', if(`p_res_4505`.`V107`=1,'1.0',if(`p_res_4505`.`V107`=2,'2.0',`p_res_4505`.`V107`))   ,'|',`p_res_4505`.`V108`,'|', `p_res_4505`.`V109`,'|', `p_res_4505`.`V110`,'|', `p_res_4505`.`V111`,'|', `p_res_4505`.`V112`,'|', `p_res_4505`.`V113`,'|', `p_res_4505`.`V114`,'|', `p_res_4505`.`V115`,'|', `p_res_4505`.`V116`,'|', `p_res_4505`.`V117`,'|', `p_res_4505`.`V118` ) AS Linea FROM `g_ips`, `persona` INNER JOIN  `p_res_4505`  ON (`persona`.`Id_persona` = `p_res_4505`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'AND p_res_4505_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505`.`Id_Persona`  ORDER BY p_res_4505.Id asc  ";
                System.out.println("FormatoA  " + this.xsql);
            } else if (this.JRBFormaB.isSelected()) {
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getIdentificacion().equals("812003382")) {
                    this.xsql = "SELECT   CONCAT(`g_ips`.`CodigoOrganismo`,'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_set_datos`.`V14`,'|', `p_res_4505_set_datos`.`V15`,'|', `p_res_4505_set_datos`.`V16`,'|', `p_res_4505_set_datos`.`V17`,'|', `p_res_4505_set_datos`.`V18`,'|', `p_res_4505_set_datos`.`V19`,'|', `p_res_4505_set_datos`.`V20`,'|', `p_res_4505_set_datos`.`V21`,'|', `p_res_4505_set_datos`.`V22` ,'|', `p_res_4505_set_datos`.`V23`,'|', `p_res_4505_set_datos`.`V24`,'|', `p_res_4505_set_datos`.`V25`,'|', `p_res_4505_set_datos`.`V26`,'|', `p_res_4505_set_datos`.`V27`,'|', `p_res_4505_set_datos`.`V28`,'|', `p_res_4505_set_datos`.`V29`,'|', `p_res_4505_set_datos`.`V30`,'|', `p_res_4505_set_datos`.`V31`,'|', `p_res_4505_set_datos`.`V32`,'|', `p_res_4505_set_datos`.`V33`,'|', `p_res_4505_set_datos`.`V34`,'|', `p_res_4505_set_datos`.`V35` ,'|', `p_res_4505_set_datos`.`V36`,'|', `p_res_4505_set_datos`.`V37`,'|', `p_res_4505_set_datos`.`V38`,'|', `p_res_4505_set_datos`.`V39`,'|', `p_res_4505_set_datos`.`V40`,'|', `p_res_4505_set_datos`.`V41`,'|', `p_res_4505_set_datos`.`V42`,'|', `p_res_4505_set_datos`.`V43`,'|', `p_res_4505_set_datos`.`V44`,'|', `p_res_4505_set_datos`.`V45`,'|', `p_res_4505_set_datos`.`V46`,'|', `p_res_4505_set_datos`.`V47`,'|', `p_res_4505_set_datos`.`V48`,'|', `p_res_4505_set_datos`.`V49` ,'|', `p_res_4505_set_datos`.`V50`,'|', `p_res_4505_set_datos`.`V51`,'|', `p_res_4505_set_datos`.`V52`,'|', `p_res_4505_set_datos`.`V53`,'|', `p_res_4505_set_datos`.`V54`,'|', `p_res_4505_set_datos`.`V55`,'|', `p_res_4505_set_datos`.`V56`,'|', `p_res_4505_set_datos`.`V57`,'|', `p_res_4505_set_datos`.`V58`,'|', `p_res_4505_set_datos`.`V59`,'|', `p_res_4505_set_datos`.`V60`,'|', `p_res_4505_set_datos`.`V61`,'|', `p_res_4505_set_datos`.`V62`,'|', `p_res_4505_set_datos`.`V63` ,'|', `p_res_4505_set_datos`.`V64`,'|', `p_res_4505_set_datos`.`V65`,'|', `p_res_4505_set_datos`.`V66`,'|',`p_res_4505_set_datos`.`V67`,'|', `p_res_4505_set_datos`.`V68`,'|', `p_res_4505_set_datos`.`V69`,'|', `p_res_4505_set_datos`.`V70`,'|', `p_res_4505_set_datos`.`V71`,'|', `p_res_4505_set_datos`.`V72`,'|', `p_res_4505_set_datos`.`V73`,'|', `p_res_4505_set_datos`.`V74`,'|', `p_res_4505_set_datos`.`V75`,'|', `p_res_4505_set_datos`.`V76`,'|', `p_res_4505_set_datos`.`V77`,'|', `p_res_4505_set_datos`.`V78` ,'|',`p_res_4505_set_datos`.`V79`,'|',`p_res_4505_set_datos`.`V80`,'|', `p_res_4505_set_datos`.`V81`,'|',`p_res_4505_set_datos`.`V82`,'|', `p_res_4505_set_datos`.`V83`,'|', `p_res_4505_set_datos`.`V84`,'|', `p_res_4505_set_datos`.`V85`,'|', `p_res_4505_set_datos`.`V86`,'|', `p_res_4505_set_datos`.`V87`,'|', `p_res_4505_set_datos`.`V88`,'|', `p_res_4505_set_datos`.`V89`,'|', `p_res_4505_set_datos`.`V90`,'|', `p_res_4505_set_datos`.`V91`,'|', `p_res_4505_set_datos`.`V92`,'|', `p_res_4505_set_datos`.`V93` ,'|',`p_res_4505_set_datos`.`V94`,'|', `p_res_4505_set_datos`.`V95`,'|',`p_res_4505_set_datos`.`V96`,'|',`p_res_4505_set_datos`.`V97`,'|', `p_res_4505_set_datos`.`V98`,'|',`p_res_4505_set_datos`.`V99`,'|', `p_res_4505_set_datos`.`V100`,'|', `p_res_4505_set_datos`.`V101`,'|', `p_res_4505_set_datos`.`V102`,'|', `p_res_4505_set_datos`.`V103`,'|', `p_res_4505_set_datos`.`V104`,'|', `p_res_4505_set_datos`.`V105`,'|', `p_res_4505_set_datos`.`V106`,'|', if(`p_res_4505_set_datos`.`V107`=1,'1.0',if(`p_res_4505_set_datos`.`V107`=2,'2.0',`p_res_4505_set_datos`.`V107`)) ,'|',`p_res_4505_set_datos`.`V108`,'|', `p_res_4505_set_datos`.`V109`,'|', `p_res_4505_set_datos`.`V110`,'|', `p_res_4505_set_datos`.`V111`,'|', `p_res_4505_set_datos`.`V112`,'|', `p_res_4505_set_datos`.`V113`,'|', `p_res_4505_set_datos`.`V114`,'|', `p_res_4505_set_datos`.`V115`,'|', `p_res_4505_set_datos`.`V116`,'|', `p_res_4505_set_datos`.`V117`,'|', `p_res_4505_set_datos`.`V118` ) AS Linea FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'AND p_res_4505_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id asc  ";
                    System.out.println("Formato B pz   " + this.xsql);
                } else if (this.JRB_Municipio.isSelected()) {
                    this.xsql = "SELECT   CONCAT(`g_ips`.`CodigoOrganismo`,'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_set_datos`.`V14`,'|', `p_res_4505_set_datos`.`V15`,'|', `p_res_4505_set_datos`.`V16`,'|', `p_res_4505_set_datos`.`V17`,'|', `p_res_4505_set_datos`.`V18`,'|', `p_res_4505_set_datos`.`V19`,'|', `p_res_4505_set_datos`.`V20`,'|', `p_res_4505_set_datos`.`V21`,'|', `p_res_4505_set_datos`.`V22` ,'|', `p_res_4505_set_datos`.`V23`,'|', `p_res_4505_set_datos`.`V24`,'|', `p_res_4505_set_datos`.`V25`,'|', `p_res_4505_set_datos`.`V26`,'|', `p_res_4505_set_datos`.`V27`,'|', `p_res_4505_set_datos`.`V28`,'|', `p_res_4505_set_datos`.`V29`,'|', `p_res_4505_set_datos`.`V30`,'|', `p_res_4505_set_datos`.`V31`,'|', `p_res_4505_set_datos`.`V32`,'|', `p_res_4505_set_datos`.`V33`,'|', `p_res_4505_set_datos`.`V34`,'|', `p_res_4505_set_datos`.`V35` ,'|', `p_res_4505_set_datos`.`V36`,'|', `p_res_4505_set_datos`.`V37`,'|', `p_res_4505_set_datos`.`V38`,'|', `p_res_4505_set_datos`.`V39`,'|', `p_res_4505_set_datos`.`V40`,'|', `p_res_4505_set_datos`.`V41`,'|', `p_res_4505_set_datos`.`V42`,'|', `p_res_4505_set_datos`.`V43`,'|', `p_res_4505_set_datos`.`V44`,'|', `p_res_4505_set_datos`.`V45`,'|', `p_res_4505_set_datos`.`V46`,'|', `p_res_4505_set_datos`.`V47`,'|', `p_res_4505_set_datos`.`V48`,'|', `p_res_4505_set_datos`.`V49` ,'|', `p_res_4505_set_datos`.`V50`,'|', `p_res_4505_set_datos`.`V51`,'|', `p_res_4505_set_datos`.`V52`,'|', `p_res_4505_set_datos`.`V53`,'|', `p_res_4505_set_datos`.`V54`,'|', `p_res_4505_set_datos`.`V55`,'|', `p_res_4505_set_datos`.`V56`,'|', `p_res_4505_set_datos`.`V57`,'|', `p_res_4505_set_datos`.`V58`,'|', `p_res_4505_set_datos`.`V59`,'|', `p_res_4505_set_datos`.`V60`,'|', `p_res_4505_set_datos`.`V61`,'|', `p_res_4505_set_datos`.`V62`,'|', `p_res_4505_set_datos`.`V63` ,'|', `p_res_4505_set_datos`.`V64`,'|', `p_res_4505_set_datos`.`V65`,'|', `p_res_4505_set_datos`.`V66`,'|',`p_res_4505_set_datos`.`V67`,'|', `p_res_4505_set_datos`.`V68`,'|', `p_res_4505_set_datos`.`V69`,'|', `p_res_4505_set_datos`.`V70`,'|', `p_res_4505_set_datos`.`V71`,'|', `p_res_4505_set_datos`.`V72`,'|', `p_res_4505_set_datos`.`V73`,'|', `p_res_4505_set_datos`.`V74`,'|', `p_res_4505_set_datos`.`V75`,'|', `p_res_4505_set_datos`.`V76`,'|', `p_res_4505_set_datos`.`V77`,'|', `p_res_4505_set_datos`.`V78` ,'|',`p_res_4505_set_datos`.`V79`,'|',`p_res_4505_set_datos`.`V80`,'|', `p_res_4505_set_datos`.`V81`,'|',`p_res_4505_set_datos`.`V82`,'|', `p_res_4505_set_datos`.`V83`,'|', `p_res_4505_set_datos`.`V84`,'|', `p_res_4505_set_datos`.`V85`,'|', `p_res_4505_set_datos`.`V86`,'|', `p_res_4505_set_datos`.`V87`,'|', `p_res_4505_set_datos`.`V88`,'|', `p_res_4505_set_datos`.`V89`,'|', `p_res_4505_set_datos`.`V90`,'|', `p_res_4505_set_datos`.`V91`,'|', `p_res_4505_set_datos`.`V92`,'|', `p_res_4505_set_datos`.`V93` ,'|',`p_res_4505_set_datos`.`V94`,'|', `p_res_4505_set_datos`.`V95`,'|',`p_res_4505_set_datos`.`V96`,'|',`p_res_4505_set_datos`.`V97`,'|', `p_res_4505_set_datos`.`V98`,'|',`p_res_4505_set_datos`.`V99`,'|', `p_res_4505_set_datos`.`V100`,'|', `p_res_4505_set_datos`.`V101`,'|', `p_res_4505_set_datos`.`V102`,'|', `p_res_4505_set_datos`.`V103`,'|', `p_res_4505_set_datos`.`V104`,'|', `p_res_4505_set_datos`.`V105`,'|', `p_res_4505_set_datos`.`V106`,'|', if(`p_res_4505_set_datos`.`V107`=1,'1.0',if(`p_res_4505_set_datos`.`V107`=2,'2.0',`p_res_4505_set_datos`.`V107`)) ,'|',`p_res_4505_set_datos`.`V108`,'|', `p_res_4505_set_datos`.`V109`,'|', `p_res_4505_set_datos`.`V110`,'|', `p_res_4505_set_datos`.`V111`,'|', `p_res_4505_set_datos`.`V112`,'|', `p_res_4505_set_datos`.`V113`,'|', `p_res_4505_set_datos`.`V114`,'|', `p_res_4505_set_datos`.`V115`,'|', `p_res_4505_set_datos`.`V116`,'|', `p_res_4505_set_datos`.`V117`,'|', `p_res_4505_set_datos`.`V118` ) AS Linea FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' and persona.CodNMunicipio='" + this.xIdMunicipio[this.JCB_MUnicipio.getSelectedIndex()] + "'AND p_res_4505_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id asc  ";
                } else if (this.JRB_Departamento.isSelected()) {
                    this.xsql = "SELECT   CONCAT(`g_ips`.`CodigoOrganismo`,'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_set_datos`.`V14`,'|', `p_res_4505_set_datos`.`V15`,'|', `p_res_4505_set_datos`.`V16`,'|', `p_res_4505_set_datos`.`V17`,'|', `p_res_4505_set_datos`.`V18`,'|', `p_res_4505_set_datos`.`V19`,'|', `p_res_4505_set_datos`.`V20`,'|', `p_res_4505_set_datos`.`V21`,'|', `p_res_4505_set_datos`.`V22` ,'|', `p_res_4505_set_datos`.`V23`,'|', `p_res_4505_set_datos`.`V24`,'|', `p_res_4505_set_datos`.`V25`,'|', `p_res_4505_set_datos`.`V26`,'|', `p_res_4505_set_datos`.`V27`,'|', `p_res_4505_set_datos`.`V28`,'|', `p_res_4505_set_datos`.`V29`,'|', `p_res_4505_set_datos`.`V30`,'|', `p_res_4505_set_datos`.`V31`,'|', `p_res_4505_set_datos`.`V32`,'|', `p_res_4505_set_datos`.`V33`,'|', `p_res_4505_set_datos`.`V34`,'|', `p_res_4505_set_datos`.`V35` ,'|', `p_res_4505_set_datos`.`V36`,'|', `p_res_4505_set_datos`.`V37`,'|', `p_res_4505_set_datos`.`V38`,'|', `p_res_4505_set_datos`.`V39`,'|', `p_res_4505_set_datos`.`V40`,'|', `p_res_4505_set_datos`.`V41`,'|', `p_res_4505_set_datos`.`V42`,'|', `p_res_4505_set_datos`.`V43`,'|', `p_res_4505_set_datos`.`V44`,'|', `p_res_4505_set_datos`.`V45`,'|', `p_res_4505_set_datos`.`V46`,'|', `p_res_4505_set_datos`.`V47`,'|', `p_res_4505_set_datos`.`V48`,'|', `p_res_4505_set_datos`.`V49` ,'|', `p_res_4505_set_datos`.`V50`,'|', `p_res_4505_set_datos`.`V51`,'|', `p_res_4505_set_datos`.`V52`,'|', `p_res_4505_set_datos`.`V53`,'|', `p_res_4505_set_datos`.`V54`,'|', `p_res_4505_set_datos`.`V55`,'|', `p_res_4505_set_datos`.`V56`,'|', `p_res_4505_set_datos`.`V57`,'|', `p_res_4505_set_datos`.`V58`,'|', `p_res_4505_set_datos`.`V59`,'|', `p_res_4505_set_datos`.`V60`,'|', `p_res_4505_set_datos`.`V61`,'|', `p_res_4505_set_datos`.`V62`,'|', `p_res_4505_set_datos`.`V63` ,'|', `p_res_4505_set_datos`.`V64`,'|', `p_res_4505_set_datos`.`V65`,'|', `p_res_4505_set_datos`.`V66`,'|',`p_res_4505_set_datos`.`V67`,'|', `p_res_4505_set_datos`.`V68`,'|', `p_res_4505_set_datos`.`V69`,'|', `p_res_4505_set_datos`.`V70`,'|', `p_res_4505_set_datos`.`V71`,'|', `p_res_4505_set_datos`.`V72`,'|', `p_res_4505_set_datos`.`V73`,'|', `p_res_4505_set_datos`.`V74`,'|', `p_res_4505_set_datos`.`V75`,'|', `p_res_4505_set_datos`.`V76`,'|', `p_res_4505_set_datos`.`V77`,'|', `p_res_4505_set_datos`.`V78` ,'|',`p_res_4505_set_datos`.`V79`,'|',`p_res_4505_set_datos`.`V80`,'|', `p_res_4505_set_datos`.`V81`,'|',`p_res_4505_set_datos`.`V82`,'|', `p_res_4505_set_datos`.`V83`,'|', `p_res_4505_set_datos`.`V84`,'|', `p_res_4505_set_datos`.`V85`,'|', `p_res_4505_set_datos`.`V86`,'|', `p_res_4505_set_datos`.`V87`,'|', `p_res_4505_set_datos`.`V88`,'|', `p_res_4505_set_datos`.`V89`,'|', `p_res_4505_set_datos`.`V90`,'|', `p_res_4505_set_datos`.`V91`,'|', `p_res_4505_set_datos`.`V92`,'|', `p_res_4505_set_datos`.`V93` ,'|',`p_res_4505_set_datos`.`V94`,'|', `p_res_4505_set_datos`.`V95`,'|',`p_res_4505_set_datos`.`V96`,'|',`p_res_4505_set_datos`.`V97`,'|', `p_res_4505_set_datos`.`V98`,'|',`p_res_4505_set_datos`.`V99`,'|', `p_res_4505_set_datos`.`V100`,'|', `p_res_4505_set_datos`.`V101`,'|', `p_res_4505_set_datos`.`V102`,'|', `p_res_4505_set_datos`.`V103`,'|', `p_res_4505_set_datos`.`V104`,'|', `p_res_4505_set_datos`.`V105`,'|', `p_res_4505_set_datos`.`V106`,'|', if(`p_res_4505_set_datos`.`V107`=1,'1.0',if(`p_res_4505_set_datos`.`V107`=2,'2.0',`p_res_4505_set_datos`.`V107`)) ,'|',`p_res_4505_set_datos`.`V108`,'|', `p_res_4505_set_datos`.`V109`,'|', `p_res_4505_set_datos`.`V110`,'|', `p_res_4505_set_datos`.`V111`,'|', `p_res_4505_set_datos`.`V112`,'|', `p_res_4505_set_datos`.`V113`,'|', `p_res_4505_set_datos`.`V114`,'|', `p_res_4505_set_datos`.`V115`,'|', `p_res_4505_set_datos`.`V116`,'|', `p_res_4505_set_datos`.`V117`,'|', `p_res_4505_set_datos`.`V118` ) AS Linea FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' and persona.IdDpto='" + this.xIdMunicipio[this.JCB_MUnicipio.getSelectedIndex()] + "'AND p_res_4505_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id asc  ";
                } else if (this.xEstado == 1) {
                    this.xsql = "SELECT   CONCAT(`g_ips`.`CodigoOrganismo`,'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|',    \n `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_set_datos`.`V14`,'|', `p_res_4505_set_datos`.`V15`,'|', `p_res_4505_set_datos`.`V16`,'|', `p_res_4505_set_datos`.`V17`,'|', `p_res_4505_set_datos`.`V18`,'|', `p_res_4505_set_datos`.`V19`,'|', `p_res_4505_set_datos`.`V20`,'|', `p_res_4505_set_datos`.`V21`,'|', `p_res_4505_set_datos`.`V22`    \n   ,'|', `p_res_4505_set_datos`.`V23`,'|', `p_res_4505_set_datos`.`V24`,'|', `p_res_4505_set_datos`.`V25`,'|', `p_res_4505_set_datos`.`V26`,'|', `p_res_4505_set_datos`.`V27`,'|', `p_res_4505_set_datos`.`V28`,'|', `p_res_4505_set_datos`.`V29`,'|', `p_res_4505_set_datos`.`V30`,'|', `p_res_4505_set_datos`.`V31`,'|', `p_res_4505_set_datos`.`V32`,'|', `p_res_4505_set_datos`.`V33`,'|', `p_res_4505_set_datos`.`V34`,'|', `p_res_4505_set_datos`.`V35`    \n   ,'|', `p_res_4505_set_datos`.`V36`,'|', `p_res_4505_set_datos`.`V37`,'|', `p_res_4505_set_datos`.`V38`,'|', `p_res_4505_set_datos`.`V39`,'|', `p_res_4505_set_datos`.`V40`,'|', `p_res_4505_set_datos`.`V41`,'|', `p_res_4505_set_datos`.`V42`,'|', `p_res_4505_set_datos`.`V43`,'|', `p_res_4505_set_datos`.`V44`,'|', `p_res_4505_set_datos`.`V45`,'|', `p_res_4505_set_datos`.`V46`,'|', `p_res_4505_set_datos`.`V47`,'|', `p_res_4505_set_datos`.`V48`,'|', `p_res_4505_set_datos`.`V49`    \n   ,'|', `p_res_4505_set_datos`.`V50`,'|', `p_res_4505_set_datos`.`V51`,'|', `p_res_4505_set_datos`.`V52`,'|', `p_res_4505_set_datos`.`V53`,'|', `p_res_4505_set_datos`.`V54`,'|', `p_res_4505_set_datos`.`V55`,'|', `p_res_4505_set_datos`.`V56`,'|', `p_res_4505_set_datos`.`V57`,'|', `p_res_4505_set_datos`.`V58`,'|', `p_res_4505_set_datos`.`V59`,'|', `p_res_4505_set_datos`.`V60`,'|', `p_res_4505_set_datos`.`V61`,'|', `p_res_4505_set_datos`.`V62`,'|', `p_res_4505_set_datos`.`V63`    \n   ,'|', `p_res_4505_set_datos`.`V64`,'|', `p_res_4505_set_datos`.`V65`,'|', `p_res_4505_set_datos`.`V66`,'|',`p_res_4505_set_datos`.`V67`,'|', `p_res_4505_set_datos`.`V68`,'|', `p_res_4505_set_datos`.`V69`,'|', `p_res_4505_set_datos`.`V70`,'|', `p_res_4505_set_datos`.`V71`,'|', `p_res_4505_set_datos`.`V72`,'|', `p_res_4505_set_datos`.`V73`,'|', `p_res_4505_set_datos`.`V74`,'|', `p_res_4505_set_datos`.`V75`,'|', `p_res_4505_set_datos`.`V76`,'|', `p_res_4505_set_datos`.`V77`,'|', `p_res_4505_set_datos`.`V78`    \n   ,'|',`p_res_4505_set_datos`.`V79`,'|',`p_res_4505_set_datos`.`V80`,'|', `p_res_4505_set_datos`.`V81`,'|',`p_res_4505_set_datos`.`V82`,'|', `p_res_4505_set_datos`.`V83`,'|', `p_res_4505_set_datos`.`V84`,'|', `p_res_4505_set_datos`.`V85`,'|', `p_res_4505_set_datos`.`V86`,'|', `p_res_4505_set_datos`.`V87`,'|', `p_res_4505_set_datos`.`V88`,'|', `p_res_4505_set_datos`.`V89`,'|', `p_res_4505_set_datos`.`V90`,'|', `p_res_4505_set_datos`.`V91`,'|', `p_res_4505_set_datos`.`V92`,'|', `p_res_4505_set_datos`.`V93`    \n   ,'|',`p_res_4505_set_datos`.`V94`,'|', `p_res_4505_set_datos`.`V95`,'|',`p_res_4505_set_datos`.`V96`,'|',`p_res_4505_set_datos`.`V97`,'|', `p_res_4505_set_datos`.`V98`,'|',`p_res_4505_set_datos`.`V99`,'|', `p_res_4505_set_datos`.`V100`,'|', `p_res_4505_set_datos`.`V101`,'|', `p_res_4505_set_datos`.`V102`,'|', `p_res_4505_set_datos`.`V103`,'|', `p_res_4505_set_datos`.`V104`,'|', `p_res_4505_set_datos`.`V105`,'|', `p_res_4505_set_datos`.`V106`,'|', IF(`p_res_4505_set_datos`.`V107`=1,'1.0',IF(`p_res_4505_set_datos`.`V107`=2,'2.0',`p_res_4505_set_datos`.`V107`))    \n   ,'|',`p_res_4505_set_datos`.`V108`,'|', `p_res_4505_set_datos`.`V109`,'|', `p_res_4505_set_datos`.`V110`,'|', `p_res_4505_set_datos`.`V111`,'|', `p_res_4505_set_datos`.`V112`,'|', `p_res_4505_set_datos`.`V113`,'|', `p_res_4505_set_datos`.`V114`,'|', `p_res_4505_set_datos`.`V115`,'|', `p_res_4505_set_datos`.`V116`,'|', `p_res_4505_set_datos`.`V117`,'|', `p_res_4505_set_datos`.`V118` ) AS Linea    \n   FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)     \n   WHERE ( p_res_4505_set_datos.`Id_Convenio`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'AND p_res_4505_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id ASC  ";
                    System.out.println("Formato B Cv" + this.xsql);
                } else {
                    this.xsql = "SELECT   CONCAT(`g_ips`.`CodigoOrganismo`,'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_set_datos`.`V14`,'|', `p_res_4505_set_datos`.`V15`,'|', `p_res_4505_set_datos`.`V16`,'|', `p_res_4505_set_datos`.`V17`,'|', `p_res_4505_set_datos`.`V18`,'|', `p_res_4505_set_datos`.`V19`,'|', `p_res_4505_set_datos`.`V20`,'|', `p_res_4505_set_datos`.`V21`,'|', `p_res_4505_set_datos`.`V22` ,'|', `p_res_4505_set_datos`.`V23`,'|', `p_res_4505_set_datos`.`V24`,'|', `p_res_4505_set_datos`.`V25`,'|', `p_res_4505_set_datos`.`V26`,'|', `p_res_4505_set_datos`.`V27`,'|', `p_res_4505_set_datos`.`V28`,'|', `p_res_4505_set_datos`.`V29`,'|', `p_res_4505_set_datos`.`V30`,'|', `p_res_4505_set_datos`.`V31`,'|', `p_res_4505_set_datos`.`V32`,'|', `p_res_4505_set_datos`.`V33`,'|', `p_res_4505_set_datos`.`V34`,'|', `p_res_4505_set_datos`.`V35` ,'|', `p_res_4505_set_datos`.`V36`,'|', `p_res_4505_set_datos`.`V37`,'|', `p_res_4505_set_datos`.`V38`,'|', `p_res_4505_set_datos`.`V39`,'|', `p_res_4505_set_datos`.`V40`,'|', `p_res_4505_set_datos`.`V41`,'|', `p_res_4505_set_datos`.`V42`,'|', `p_res_4505_set_datos`.`V43`,'|', `p_res_4505_set_datos`.`V44`,'|', `p_res_4505_set_datos`.`V45`,'|', `p_res_4505_set_datos`.`V46`,'|', `p_res_4505_set_datos`.`V47`,'|', `p_res_4505_set_datos`.`V48`,'|', `p_res_4505_set_datos`.`V49` ,'|', `p_res_4505_set_datos`.`V50`,'|', `p_res_4505_set_datos`.`V51`,'|', `p_res_4505_set_datos`.`V52`,'|', `p_res_4505_set_datos`.`V53`,'|', `p_res_4505_set_datos`.`V54`,'|', `p_res_4505_set_datos`.`V55`,'|', `p_res_4505_set_datos`.`V56`,'|', `p_res_4505_set_datos`.`V57`,'|', `p_res_4505_set_datos`.`V58`,'|', `p_res_4505_set_datos`.`V59`,'|', `p_res_4505_set_datos`.`V60`,'|', `p_res_4505_set_datos`.`V61`,'|', `p_res_4505_set_datos`.`V62`,'|', `p_res_4505_set_datos`.`V63` ,'|', `p_res_4505_set_datos`.`V64`,'|', `p_res_4505_set_datos`.`V65`,'|', `p_res_4505_set_datos`.`V66`,'|',`p_res_4505_set_datos`.`V67`,'|', `p_res_4505_set_datos`.`V68`,'|', `p_res_4505_set_datos`.`V69`,'|', `p_res_4505_set_datos`.`V70`,'|', `p_res_4505_set_datos`.`V71`,'|', `p_res_4505_set_datos`.`V72`,'|', `p_res_4505_set_datos`.`V73`,'|', `p_res_4505_set_datos`.`V74`,'|', `p_res_4505_set_datos`.`V75`,'|', `p_res_4505_set_datos`.`V76`,'|', `p_res_4505_set_datos`.`V77`,'|', `p_res_4505_set_datos`.`V78` ,'|',`p_res_4505_set_datos`.`V79`,'|',`p_res_4505_set_datos`.`V80`,'|', `p_res_4505_set_datos`.`V81`,'|',`p_res_4505_set_datos`.`V82`,'|', `p_res_4505_set_datos`.`V83`,'|', `p_res_4505_set_datos`.`V84`,'|', `p_res_4505_set_datos`.`V85`,'|', `p_res_4505_set_datos`.`V86`,'|', `p_res_4505_set_datos`.`V87`,'|', `p_res_4505_set_datos`.`V88`,'|', `p_res_4505_set_datos`.`V89`,'|', `p_res_4505_set_datos`.`V90`,'|', `p_res_4505_set_datos`.`V91`,'|', `p_res_4505_set_datos`.`V92`,'|', `p_res_4505_set_datos`.`V93` ,'|',`p_res_4505_set_datos`.`V94`,'|', `p_res_4505_set_datos`.`V95`,'|',`p_res_4505_set_datos`.`V96`,'|',`p_res_4505_set_datos`.`V97`,'|', `p_res_4505_set_datos`.`V98`,'|',`p_res_4505_set_datos`.`V99`,'|', `p_res_4505_set_datos`.`V100`,'|', `p_res_4505_set_datos`.`V101`,'|', `p_res_4505_set_datos`.`V102`,'|', `p_res_4505_set_datos`.`V103`,'|', `p_res_4505_set_datos`.`V104`,'|', `p_res_4505_set_datos`.`V105`,'|', `p_res_4505_set_datos`.`V106`,'|', if(`p_res_4505_set_datos`.`V107`=1,'1.0',if(`p_res_4505_set_datos`.`V107`=2,'2.0',`p_res_4505_set_datos`.`V107`)) ,'|',`p_res_4505_set_datos`.`V108`,'|', `p_res_4505_set_datos`.`V109`,'|', `p_res_4505_set_datos`.`V110`,'|', `p_res_4505_set_datos`.`V111`,'|', `p_res_4505_set_datos`.`V112`,'|', `p_res_4505_set_datos`.`V113`,'|', `p_res_4505_set_datos`.`V114`,'|', `p_res_4505_set_datos`.`V115`,'|', `p_res_4505_set_datos`.`V116`,'|', `p_res_4505_set_datos`.`V117`,'|', `p_res_4505_set_datos`.`V118` ) AS Linea FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_set_datos`.`Id_Persona`AND p_res_4505_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)   WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_res_4505_set_datos`.`Id_Persona`  ORDER BY p_res_4505_set_datos.Id asc  ";
                    System.out.println("Formato B eps" + this.xsql);
                }
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.last();
                bw.write("1|" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1] + "|" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "|" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "|" + xrs.getRow());
                bw.newLine();
                xrs.beforeFirst();
                int x = 1;
                while (xrs.next()) {
                    bw.write("2|" + x + "|" + xrs.getString(1));
                    bw.newLine();
                    x++;
                }
            }
            bw.close();
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (IOException ex) {
            Logger.getLogger(JIFConsultarInfR4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFConsultarInfR4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_202(String xNit) {
        String xregimen;
        System.err.println("dentro del metodo" + xNit);
        if (this.xEstado == 1) {
            System.out.println("combo" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2]);
            xregimen = this.xidempresa[this.JCBEmpresa.getSelectedIndex()][2];
        } else {
            xregimen = "S";
        }
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "SGD280RPED" + this.xmt.formatoANO.format(this.JDFechaF.getDate()) + this.xmt.formatoMes.format(this.JDFechaF.getDate()) + this.xmt.formatoDia.format(this.JDFechaF.getDate()) + Principal.informacionIps.getIdTipoIdentificacion() + xNit + xregimen + "01.txt";
            if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + Principal.sedeUsuarioSeleccionadaDTO.getCodigoOrganismo() + "_" + this.xmt.formatoAMD_r202.format(this.JDFechaF.getDate()) + ".txt";
            }
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            if (Principal.informacionIps.getIdentificacion().equals("812001219")) {
                if (this.JCHEstado.isSelected()) {
                    this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|',ifnull(`ingreso`.`Id_Ocupacion`,9999),'|',ifnull(`ingreso`.`Id_NivelEstudio`,2),'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22` ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35` ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49` ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63` ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78` ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93` ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', if(`p_res_4505_202_set_datos`.`V107`=1,'1.0',if(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`)) ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea FROM `g_ips`, `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`) left JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)  inner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv)  WHERE (`persona`.IdEmpresaCont='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' and persona.CodNMunicipio='" + this.xIdMunicipio[this.JCB_MUnicipio.getSelectedIndex()] + "') GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                } else {
                    this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22` ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35` ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49` ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63` ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78` ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93` ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', if(`p_res_4505_202_set_datos`.`V107`=1,'1.0',if(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`)) ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE (fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                    System.out.println("Formato B eps" + this.xsql);
                }
            } else if (this.JRBFormaA.isSelected()) {
                if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                    this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505`.`V14`,'|', `p_res_4505`.`V15`,'|', `p_res_4505`.`V16`,'|', `p_res_4505`.`V17`,'|', `p_res_4505`.`V18`,'|', `p_res_4505`.`V19`,'|', `p_res_4505`.`V20`,'|', `p_res_4505`.`V21`,'|', `p_res_4505`.`V22` ,'|', `p_res_4505`.`V23`,'|', `p_res_4505`.`V24`,'|', `p_res_4505`.`V25`,'|', `p_res_4505`.`V26`,'|', `p_res_4505`.`V27`,'|', `p_res_4505`.`V28`,'|', `p_res_4505`.`V29`,'|', `p_res_4505`.`V30`,'|', `p_res_4505`.`V31`,'|', `p_res_4505`.`V32`,'|', `p_res_4505`.`V33`,'|', `p_res_4505`.`V34`,'|', `p_res_4505`.`V35` ,'|', `p_res_4505`.`V36`,'|', `p_res_4505`.`V37`,'|', `p_res_4505`.`V38`,'|', `p_res_4505`.`V39`,'|', `p_res_4505`.`V40`,'|', `p_res_4505`.`V41`,'|', `p_res_4505`.`V42`,'|', `p_res_4505`.`V43`,'|', `p_res_4505`.`V44`,'|', `p_res_4505`.`V45`,'|', `p_res_4505`.`V46`,'|', `p_res_4505`.`V47`,'|', `p_res_4505`.`V48`,'|', `p_res_4505`.`V49` ,'|', `p_res_4505`.`V50`,'|', `p_res_4505`.`V51`,'|', `p_res_4505`.`V52`,'|', `p_res_4505`.`V53`,'|', `p_res_4505`.`V54`,'|', `p_res_4505`.`V55`,'|', `p_res_4505`.`V56`,'|', `p_res_4505`.`V57`,'|', `p_res_4505`.`V58`,'|', `p_res_4505`.`V59`,'|', `p_res_4505`.`V60`,'|', `p_res_4505`.`V61`,'|', `p_res_4505`.`V62`,'|', `p_res_4505`.`V63` ,'|', `p_res_4505`.`V64`,'|', `p_res_4505`.`V65`,'|', `p_res_4505`.`V66`,'|',`p_res_4505`.`V67`,'|', `p_res_4505`.`V68`,'|', `p_res_4505`.`V69`,'|', `p_res_4505`.`V70`,'|', `p_res_4505`.`V71`,'|', `p_res_4505`.`V72`,'|', `p_res_4505`.`V73`,'|', `p_res_4505`.`V74`,'|', `p_res_4505`.`V75`,'|', `p_res_4505`.`V76`,'|', `p_res_4505`.`V77`,'|', `p_res_4505`.`V78` ,'|',`p_res_4505`.`V79`,'|',`p_res_4505`.`V80`,'|', `p_res_4505`.`V81`,'|',`p_res_4505`.`V82`,'|', `p_res_4505`.`V83`,'|', `p_res_4505`.`V84`,'|', `p_res_4505`.`V85`,'|', `p_res_4505`.`V86`,'|', `p_res_4505`.`V87`,'|', `p_res_4505`.`V88`,'|', `p_res_4505`.`V89`,'|', `p_res_4505`.`V90`,'|', `p_res_4505`.`V91`,'|', `p_res_4505`.`V92`,'|', `p_res_4505`.`V93` ,'|',`p_res_4505`.`V94`,'|', `p_res_4505`.`V95`,'|',`p_res_4505`.`V96`,'|',`p_res_4505`.`V97`,'|', `p_res_4505`.`V98`,'|',`p_res_4505`.`V99`,'|', `p_res_4505`.`V100`,'|', `p_res_4505`.`V101`,'|', `p_res_4505`.`V102`,'|', `p_res_4505`.`V103`,'|', `p_res_4505`.`V104`,'|', `p_res_4505`.`V105`,'|', `p_res_4505`.`V106`,'|', if(`p_res_4505`.`V107`=1,'1.0',if(`p_res_4505`.`V107`=2,'2.0',`p_res_4505`.`V107`))   ,'|',`p_res_4505`.`V108`,'|', `p_res_4505`.`V109`,'|', `p_res_4505`.`V110`,'|', `p_res_4505`.`V111`,'|', `p_res_4505`.`V112`,'|', `p_res_4505`.`V113`,'|', `p_res_4505`.`V114`,'|', `p_res_4505`.`V115`,'|', `p_res_4505`.`V116`,'|', `p_res_4505`.`V117`,'|', `p_res_4505`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE (ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`) ='" + Principal.sedeUsuarioSeleccionadaDTO.getCodigoOrganismo() + "' and fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505`.`Id_Persona`  ORDER BY p_res_4505.Id asc  ";
                } else {
                    this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505`.`V14`,'|', `p_res_4505`.`V15`,'|', `p_res_4505`.`V16`,'|', `p_res_4505`.`V17`,'|', `p_res_4505`.`V18`,'|', `p_res_4505`.`V19`,'|', `p_res_4505`.`V20`,'|', `p_res_4505`.`V21`,'|', `p_res_4505`.`V22` ,'|', `p_res_4505`.`V23`,'|', `p_res_4505`.`V24`,'|', `p_res_4505`.`V25`,'|', `p_res_4505`.`V26`,'|', `p_res_4505`.`V27`,'|', `p_res_4505`.`V28`,'|', `p_res_4505`.`V29`,'|', `p_res_4505`.`V30`,'|', `p_res_4505`.`V31`,'|', `p_res_4505`.`V32`,'|', `p_res_4505`.`V33`,'|', `p_res_4505`.`V34`,'|', `p_res_4505`.`V35` ,'|', `p_res_4505`.`V36`,'|', `p_res_4505`.`V37`,'|', `p_res_4505`.`V38`,'|', `p_res_4505`.`V39`,'|', `p_res_4505`.`V40`,'|', `p_res_4505`.`V41`,'|', `p_res_4505`.`V42`,'|', `p_res_4505`.`V43`,'|', `p_res_4505`.`V44`,'|', `p_res_4505`.`V45`,'|', `p_res_4505`.`V46`,'|', `p_res_4505`.`V47`,'|', `p_res_4505`.`V48`,'|', `p_res_4505`.`V49` ,'|', `p_res_4505`.`V50`,'|', `p_res_4505`.`V51`,'|', `p_res_4505`.`V52`,'|', `p_res_4505`.`V53`,'|', `p_res_4505`.`V54`,'|', `p_res_4505`.`V55`,'|', `p_res_4505`.`V56`,'|', `p_res_4505`.`V57`,'|', `p_res_4505`.`V58`,'|', `p_res_4505`.`V59`,'|', `p_res_4505`.`V60`,'|', `p_res_4505`.`V61`,'|', `p_res_4505`.`V62`,'|', `p_res_4505`.`V63` ,'|', `p_res_4505`.`V64`,'|', `p_res_4505`.`V65`,'|', `p_res_4505`.`V66`,'|',`p_res_4505`.`V67`,'|', `p_res_4505`.`V68`,'|', `p_res_4505`.`V69`,'|', `p_res_4505`.`V70`,'|', `p_res_4505`.`V71`,'|', `p_res_4505`.`V72`,'|', `p_res_4505`.`V73`,'|', `p_res_4505`.`V74`,'|', `p_res_4505`.`V75`,'|', `p_res_4505`.`V76`,'|', `p_res_4505`.`V77`,'|', `p_res_4505`.`V78` ,'|',`p_res_4505`.`V79`,'|',`p_res_4505`.`V80`,'|', `p_res_4505`.`V81`,'|',`p_res_4505`.`V82`,'|', `p_res_4505`.`V83`,'|', `p_res_4505`.`V84`,'|', `p_res_4505`.`V85`,'|', `p_res_4505`.`V86`,'|', `p_res_4505`.`V87`,'|', `p_res_4505`.`V88`,'|', `p_res_4505`.`V89`,'|', `p_res_4505`.`V90`,'|', `p_res_4505`.`V91`,'|', `p_res_4505`.`V92`,'|', `p_res_4505`.`V93` ,'|',`p_res_4505`.`V94`,'|', `p_res_4505`.`V95`,'|',`p_res_4505`.`V96`,'|',`p_res_4505`.`V97`,'|', `p_res_4505`.`V98`,'|',`p_res_4505`.`V99`,'|', `p_res_4505`.`V100`,'|', `p_res_4505`.`V101`,'|', `p_res_4505`.`V102`,'|', `p_res_4505`.`V103`,'|', `p_res_4505`.`V104`,'|', `p_res_4505`.`V105`,'|', `p_res_4505`.`V106`,'|', if(`p_res_4505`.`V107`=1,'1.0',if(`p_res_4505`.`V107`=2,'2.0',`p_res_4505`.`V107`))   ,'|',`p_res_4505`.`V108`,'|', `p_res_4505`.`V109`,'|', `p_res_4505`.`V110`,'|', `p_res_4505`.`V111`,'|', `p_res_4505`.`V112`,'|', `p_res_4505`.`V113`,'|', `p_res_4505`.`V114`,'|', `p_res_4505`.`V115`,'|', `p_res_4505`.`V116`,'|', `p_res_4505`.`V117`,'|', `p_res_4505`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE (fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505`.`Id_Persona`  ORDER BY p_res_4505.Id asc  ";
                }
                System.out.println("FormatoA  " + this.xsql);
            } else if (this.JRBFormaB.isSelected()) {
                if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getIdentificacion().equals("812004010") || Principal.informacionIps.getIdentificacion().equals("812003382")) {
                    this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22` ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35` ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49` ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63` ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78` ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93` ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', if(`p_res_4505_202_set_datos`.`V107`=1,'1.0',if(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`)) ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE (persona.IdEmpresaCont = '" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                    System.out.println("Formato B pz   " + this.xsql);
                } else if (this.JRB_Municipio.isSelected()) {
                    if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                        this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22` ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35` ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49` ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63` ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78` ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93` ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', if(`p_res_4505_202_set_datos`.`V107`=1,'1.0',if(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`)) ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE ( ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`) ='" + Principal.sedeUsuarioSeleccionadaDTO.getCodigoOrganismo() + "' and fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' and persona.CodNMunicipio='" + this.xIdMunicipio[this.JCB_MUnicipio.getSelectedIndex()] + "'AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                    } else {
                        this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22` ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35` ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49` ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63` ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78` ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93` ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', if(`p_res_4505_202_set_datos`.`V107`=1,'1.0',if(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`)) ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE (fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' and persona.CodNMunicipio='" + this.xIdMunicipio[this.JCB_MUnicipio.getSelectedIndex()] + "'AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                    }
                } else if (this.JRB_Departamento.isSelected()) {
                    if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                        this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22` ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35` ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49` ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63` ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78` ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93` ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', if(`p_res_4505_202_set_datos`.`V107`=1,'1.0',if(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`)) ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE (ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`) ='" + Principal.sedeUsuarioSeleccionadaDTO.getCodigoOrganismo() + "' and  fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' and persona.IdDpto='" + this.xIdMunicipio[this.JCB_MUnicipio.getSelectedIndex()] + "'AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                    } else {
                        this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22` ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35` ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49` ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63` ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78` ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93` ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', if(`p_res_4505_202_set_datos`.`V107`=1,'1.0',if(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`)) ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE (fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "' and persona.IdDpto='" + this.xIdMunicipio[this.JCB_MUnicipio.getSelectedIndex()] + "'AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                    }
                } else if (this.xEstado == 1) {
                    if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                        this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|',    \n `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22`    \n   ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35`    \n   ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49`    \n   ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63`    \n   ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78`    \n   ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93`    \n   ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', IF(`p_res_4505_202_set_datos`.`V107`=1,'1.0',IF(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`))    \n   ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea    \nFROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede )   WHERE (ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`) ='" + Principal.sedeUsuarioSeleccionadaDTO.getCodigoOrganismo() + "' and  p_res_4505_202_set_datos.`Id_Convenio`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id ASC  ";
                    } else {
                        this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|',    \n `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22`    \n   ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35`    \n   ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49`    \n   ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63`    \n   ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78`    \n   ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93`    \n   ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', IF(`p_res_4505_202_set_datos`.`V107`=1,'1.0',IF(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`))    \n   ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea    \nFROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede )   WHERE ( p_res_4505_202_set_datos.`Id_Convenio`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "'AND p_res_4505_202_set_datos.`Actualizado`=1 ) GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id ASC  ";
                    }
                    System.out.println("Formato B Cv" + this.xsql);
                } else {
                    if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                        this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22` ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35` ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49` ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63` ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78` ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93` ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', if(`p_res_4505_202_set_datos`.`V107`=1,'1.0',if(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`)) ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE (ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`) ='" + Principal.sedeUsuarioSeleccionadaDTO.getCodigoOrganismo() + "' and  fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                    } else {
                        this.xsql = "SELECT   CONCAT(ifnull(gs.CodigoOrganismo, `g_ips`.`CodigoOrganismo`),'|',`persona`.`Id_TipoIdentificacion`,'|', `persona`.`NoDocumento`,'|', `persona`.`Apellido1`,'|', `persona`.`Apellido2`,'|', `persona`.`Nombre1`,'|', `persona`.`Nombre2`,'|',`persona`.`FechaNac` ,'|',`persona`.`IdSexo` ,'|', `persona`.`IdEtnia` ,'|', `ingreso`.`Id_Ocupacion`,'|',`ingreso`.`Id_NivelEstudio`,'|', `p_res_4505_202_set_datos`.`V14`,'|', `p_res_4505_202_set_datos`.`V15`,'|', `p_res_4505_202_set_datos`.`V16`,'|', `p_res_4505_202_set_datos`.`V17`,'|', `p_res_4505_202_set_datos`.`V18`,'|', `p_res_4505_202_set_datos`.`V19`,'|', `p_res_4505_202_set_datos`.`V20`,'|', `p_res_4505_202_set_datos`.`V21`,'|', `p_res_4505_202_set_datos`.`V22` ,'|', `p_res_4505_202_set_datos`.`V23`,'|', `p_res_4505_202_set_datos`.`V24`,'|', `p_res_4505_202_set_datos`.`V25`,'|', `p_res_4505_202_set_datos`.`V26`,'|', `p_res_4505_202_set_datos`.`V27`,'|', `p_res_4505_202_set_datos`.`V28`,'|', `p_res_4505_202_set_datos`.`V29`,'|', `p_res_4505_202_set_datos`.`V30`,'|', `p_res_4505_202_set_datos`.`V31`,'|', `p_res_4505_202_set_datos`.`V32`,'|', `p_res_4505_202_set_datos`.`V33`,'|', `p_res_4505_202_set_datos`.`V34`,'|', `p_res_4505_202_set_datos`.`V35` ,'|', `p_res_4505_202_set_datos`.`V36`,'|', `p_res_4505_202_set_datos`.`V37`,'|', `p_res_4505_202_set_datos`.`V38`,'|', `p_res_4505_202_set_datos`.`V39`,'|', `p_res_4505_202_set_datos`.`V40`,'|', `p_res_4505_202_set_datos`.`V41`,'|', `p_res_4505_202_set_datos`.`V42`,'|', `p_res_4505_202_set_datos`.`V43`,'|', `p_res_4505_202_set_datos`.`V44`,'|', `p_res_4505_202_set_datos`.`V45`,'|', `p_res_4505_202_set_datos`.`V46`,'|', `p_res_4505_202_set_datos`.`V47`,'|', `p_res_4505_202_set_datos`.`V48`,'|', `p_res_4505_202_set_datos`.`V49` ,'|', `p_res_4505_202_set_datos`.`V50`,'|', `p_res_4505_202_set_datos`.`V51`,'|', `p_res_4505_202_set_datos`.`V52`,'|', `p_res_4505_202_set_datos`.`V53`,'|', `p_res_4505_202_set_datos`.`V54`,'|', `p_res_4505_202_set_datos`.`V55`,'|', `p_res_4505_202_set_datos`.`V56`,'|', `p_res_4505_202_set_datos`.`V57`,'|', `p_res_4505_202_set_datos`.`V58`,'|', `p_res_4505_202_set_datos`.`V59`,'|', `p_res_4505_202_set_datos`.`V60`,'|', `p_res_4505_202_set_datos`.`V61`,'|', `p_res_4505_202_set_datos`.`V62`,'|', `p_res_4505_202_set_datos`.`V63` ,'|', `p_res_4505_202_set_datos`.`V64`,'|', `p_res_4505_202_set_datos`.`V65`,'|', `p_res_4505_202_set_datos`.`V66`,'|',`p_res_4505_202_set_datos`.`V67`,'|', `p_res_4505_202_set_datos`.`V68`,'|', `p_res_4505_202_set_datos`.`V69`,'|', `p_res_4505_202_set_datos`.`V70`,'|', `p_res_4505_202_set_datos`.`V71`,'|', `p_res_4505_202_set_datos`.`V72`,'|', `p_res_4505_202_set_datos`.`V73`,'|', `p_res_4505_202_set_datos`.`V74`,'|', `p_res_4505_202_set_datos`.`V75`,'|', `p_res_4505_202_set_datos`.`V76`,'|', `p_res_4505_202_set_datos`.`V77`,'|', `p_res_4505_202_set_datos`.`V78` ,'|',`p_res_4505_202_set_datos`.`V79`,'|',`p_res_4505_202_set_datos`.`V80`,'|', `p_res_4505_202_set_datos`.`V81`,'|',`p_res_4505_202_set_datos`.`V82`,'|', `p_res_4505_202_set_datos`.`V83`,'|', `p_res_4505_202_set_datos`.`V84`,'|', `p_res_4505_202_set_datos`.`V85`,'|', `p_res_4505_202_set_datos`.`V86`,'|', `p_res_4505_202_set_datos`.`V87`,'|', `p_res_4505_202_set_datos`.`V88`,'|', `p_res_4505_202_set_datos`.`V89`,'|', `p_res_4505_202_set_datos`.`V90`,'|', `p_res_4505_202_set_datos`.`V91`,'|', `p_res_4505_202_set_datos`.`V92`,'|', `p_res_4505_202_set_datos`.`V93` ,'|',`p_res_4505_202_set_datos`.`V94`,'|', `p_res_4505_202_set_datos`.`V95`,'|',`p_res_4505_202_set_datos`.`V96`,'|',`p_res_4505_202_set_datos`.`V97`,'|', `p_res_4505_202_set_datos`.`V98`,'|',`p_res_4505_202_set_datos`.`V99`,'|', `p_res_4505_202_set_datos`.`V100`,'|', `p_res_4505_202_set_datos`.`V101`,'|', `p_res_4505_202_set_datos`.`V102`,'|', `p_res_4505_202_set_datos`.`V103`,'|', `p_res_4505_202_set_datos`.`V104`,'|', `p_res_4505_202_set_datos`.`V105`,'|', `p_res_4505_202_set_datos`.`V106`,'|', if(`p_res_4505_202_set_datos`.`V107`=1,'1.0',if(`p_res_4505_202_set_datos`.`V107`=2,'2.0',`p_res_4505_202_set_datos`.`V107`)) ,'|',`p_res_4505_202_set_datos`.`V108`,'|', `p_res_4505_202_set_datos`.`V109`,'|', `p_res_4505_202_set_datos`.`V110`,'|', `p_res_4505_202_set_datos`.`V111`,'|', `p_res_4505_202_set_datos`.`V112`,'|', `p_res_4505_202_set_datos`.`V113`,'|', `p_res_4505_202_set_datos`.`V114`,'|', `p_res_4505_202_set_datos`.`V115`,'|', `p_res_4505_202_set_datos`.`V116`,'|', `p_res_4505_202_set_datos`.`V117`,'|', `p_res_4505_202_set_datos`.`V118` ) AS Linea FROM  `persona` INNER JOIN  `p_res_4505_202_set_datos`  ON (`persona`.`Id_persona` = `p_res_4505_202_set_datos`.`Id_Persona`AND p_res_4505_202_set_datos.`Actualizado`=1 ) INNER JOIN  `ingreso`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) \ninner join f_empresacontxconvenio fe on (fe.Id=ingreso.Id_EmpresaContxConv) \ninner join g_ips on (g_ips.Id =fe.Id_GIps )\nleft  join g_sedes gs on (gs.Id =ingreso.Id_Sede ) WHERE (fe.Id_EmpresaCont ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][0] + "') GROUP BY `p_res_4505_202_set_datos`.`Id_Persona`  ORDER BY p_res_4505_202_set_datos.Id asc  ";
                    }
                    System.out.println("Formato B eps" + this.xsql);
                }
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.last();
                bw.write("1|" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()][1] + "|" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "|" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "|" + xrs.getRow());
                bw.newLine();
                xrs.beforeFirst();
                int x = 1;
                while (xrs.next()) {
                    bw.write("2|" + x + "|" + xrs.getString(1));
                    bw.newLine();
                    x++;
                }
            }
            bw.close();
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (IOException ex) {
            Logger.getLogger(JIFConsultarInfR4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFConsultarInfR4505.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }
}
