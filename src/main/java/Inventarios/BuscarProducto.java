package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/BuscarProducto.class */
public class BuscarProducto extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private DefaultTableModel modelo;
    private String pantalla;
    private String sql;
    private String idBodega;
    private Object[] datos;
    private int filaGrid;
    private int sueno;
    private int forma;
    private Despachos frmDespacho;
    private Entradas frmEntrada;
    private Salidas frmSalida;
    private ITraslados frmTraslado;
    private Faltantes frmFaltante;
    private claseInventario claseInv;
    private String sqlAdicional;
    private ButtonGroup JBGFiltro;
    private JCheckBox JCHEsProducto;
    private JCheckBox JCHFiltro;
    private JPanel JPFiltroE;
    private JRadioButton JRBExistencia;
    private JRadioButton JRBSinExistencia;
    private JRadioButton JRBTodo;
    private JTable grid;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JTextField txtProducto;

    public BuscarProducto(Frame parent, boolean modal, JInternalFrame frm, String IdBodega, claseInventario clase) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        this.sueno = 0;
        this.forma = 0;
        this.sqlAdicional = "1";
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.claseInv = clase;
        casting(frm);
        this.idBodega = IdBodega;
        setLocationRelativeTo(null);
        crearGrid();
    }

    public BuscarProducto(Frame parent, boolean modal, JInternalFrame frm, String IdBodega, claseInventario clase, int forma) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.filaGrid = 0;
        this.sueno = 0;
        this.forma = 0;
        this.sqlAdicional = "1";
        initComponents();
        this.forma = forma;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.claseInv = clase;
        casting(frm);
        this.idBodega = IdBodega;
        this.JCHFiltro.setVisible(false);
        this.JCHEsProducto.setVisible(false);
        crearGrid();
    }

    private void casting(JInternalFrame frm) {
        if (frm.getName().equals("Entradas")) {
            this.frmEntrada = (Entradas) frm;
            this.pantalla = "Entradas";
            return;
        }
        if (frm.getName().equals("Salidas")) {
            this.frmSalida = (Salidas) frm;
            this.pantalla = "Salidas";
            return;
        }
        if (frm.getName().equals("Despachos")) {
            this.frmDespacho = (Despachos) frm;
            this.pantalla = "Despachos";
        } else if (frm.getName().equals("ITraslados")) {
            this.frmTraslado = (ITraslados) frm;
            this.pantalla = "ITraslados";
        } else if (frm.getName().equals("Faltantes")) {
            this.frmFaltante = (Faltantes) frm;
            this.pantalla = "Faltantes";
        }
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código", "Producto", "Cantidad", "Costo", "P.Activo", "Cant x Unidad", "Sueño", "idProbodega", "Iva", "codigoa", "Codigo CUM", "Codigo ATC", "Concentracion", "Principio Activo", "Invima", "Fecha Vecimiento Invima"}) { // from class: Inventarios.BuscarProducto.1
            Class[] types = {String.class, String.class, String.class, Integer.class, Double.class, String.class, Integer.class, Boolean.class, Integer.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(5).setMinWidth(0);
        this.grid.getColumnModel().getColumn(5).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(6).setMinWidth(0);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(0);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(9).setMinWidth(0);
        this.grid.getColumnModel().getColumn(9).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(10).setMinWidth(0);
        this.grid.getColumnModel().getColumn(10).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(11).setMinWidth(0);
        this.grid.getColumnModel().getColumn(11).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(12).setMinWidth(0);
        this.grid.getColumnModel().getColumn(12).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.filaGrid = 0;
    }

    private void crearGridNuevo() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Código", "Producto", "Cantidad", "Costo", "Lote", "FechaVecimiento", "P.Activo", "Cant x Unidad", "Sueño", "idProbodega", "Iva", "codigoa", "Codigo CUM", "Codigo ATC", "Concentracion", "Principio Activo", "Invima", "Fecha Vecimiento Invima"}) { // from class: Inventarios.BuscarProducto.2
            Class[] types = {String.class, String.class, String.class, Integer.class, Double.class, String.class, Date.class, String.class, Integer.class, Boolean.class, Integer.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(7).setMinWidth(0);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(0);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(10).setMinWidth(0);
        this.grid.getColumnModel().getColumn(10).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(11).setMinWidth(0);
        this.grid.getColumnModel().getColumn(11).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(12).setMinWidth(0);
        this.grid.getColumnModel().getColumn(12).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(13).setMinWidth(0);
        this.grid.getColumnModel().getColumn(13).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(14).setMinWidth(0);
        this.grid.getColumnModel().getColumn(14).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(18).setPreferredWidth(100);
    }

    private void cargarDatosTabla() {
        new ArrayList();
        List<IInformacionInventario> informacionInventarios = this.claseInv.listInventarioGeneral(this.metodos.getFechaActual(), this.claseInv.getListaIdBodega(), 0, 3, this.txtProducto.getText(), this.sqlAdicional);
        crearGridNuevo();
        if (!informacionInventarios.isEmpty()) {
            this.metodos.mEstablecerTextEditor(this.grid, 2);
            this.metodos.mEstablecerTextEditor(this.grid, 15);
            this.metodos.mEstablecerTextEditor(this.grid, 14);
            informacionInventarios.forEach(item -> {
                this.modelo.addRow(this.datos);
                this.modelo.setValueAt(item.getIdSuministro(), this.grid.getRowCount() - 1, 0);
                this.modelo.setValueAt(item.getCodigoBarra(), this.grid.getRowCount() - 1, 1);
                this.modelo.setValueAt(item.getNombreSuministro() + " " + item.getNombreConcentracion() + " " + item.getNombrePresentacionFarmaceutica() + " " + item.getNombrePresentacionComercial() + " " + item.getNombreLaboratorio(), this.grid.getRowCount() - 1, 2);
                this.modelo.setValueAt(item.getTotalInventario(), this.grid.getRowCount() - 1, 3);
                this.modelo.setValueAt(item.getValorUnitario(), this.grid.getRowCount() - 1, 4);
                this.modelo.setValueAt(item.getLote(), this.grid.getRowCount() - 1, 5);
                this.modelo.setValueAt(item.getFechaVencimiento(), this.grid.getRowCount() - 1, 6);
                this.modelo.setValueAt(item.getIdPrincipioActivo(), this.grid.getRowCount() - 1, 7);
                this.modelo.setValueAt(item.getCantidadUnidad(), this.grid.getRowCount() - 1, 8);
                this.modelo.setValueAt(item.getAplicaLogoSueno(), this.grid.getRowCount() - 1, 9);
                this.modelo.setValueAt(item.getIdSUministroBodega(), this.grid.getRowCount() - 1, 10);
                this.modelo.setValueAt(item.getIva(), this.grid.getRowCount() - 1, 11);
                this.modelo.setValueAt(item.getCodigoAgruacion(), this.grid.getRowCount() - 1, 12);
                this.modelo.setValueAt(item.getCodigoCum(), this.grid.getRowCount() - 1, 13);
                this.modelo.setValueAt(item.getCodigoAtc(), this.grid.getRowCount() - 1, 14);
                this.modelo.setValueAt(item.getNombreConcentracion(), this.grid.getRowCount() - 1, 15);
                this.modelo.setValueAt(item.getNombrePrincipioActivo(), this.grid.getRowCount() - 1, 16);
                this.modelo.setValueAt(item.getRegistroInvima(), this.grid.getRowCount() - 1, 17);
                this.modelo.setValueAt(item.getFechaVencimientoInvima(), this.grid.getRowCount() - 1, 18);
            });
        }
    }

    private void buscar() {
        if (!this.txtProducto.getText().isEmpty()) {
            crearGrid();
            if (this.forma == 1) {
                cargarDatosTabla();
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                buscarPajonal();
            } else {
                buscarOtrasIPS();
            }
        }
    }

    private void buscarPajonal() {
        if (this.pantalla.equals("Despachos")) {
            if (Principal.clasecaja == null) {
                if (this.JCHEsProducto.isSelected()) {
                    this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio,if(" + Principal.informacionIps.getEsFpz() + "=0, round(i_suministroxbodega.Costo),i_suministroxbodega.VVenta)  as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND (i_suministro.Nbre like'" + this.txtProducto.getText() + "%' or `i_principioactivo`.`Nbre` like'" + this.txtProducto.getText() + "%' ) AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
                } else {
                    this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio,if(" + Principal.informacionIps.getEsFpz() + "=0, round(i_suministroxbodega.Costo),i_suministroxbodega.VVenta) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND  i_suministro.CodBarraUnidad like'" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
                }
            } else if (this.JCHEsProducto.isSelected()) {
                this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.VVenta) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND (i_suministro.Nbre like'" + this.txtProducto.getText() + "%' or `i_principioactivo`.`Nbre` like'" + this.txtProducto.getText() + "%' ) AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad,i_suministro.Nbre ";
            } else {
                this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.VVenta) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND  i_suministro.CodBarraUnidad like'" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad,i_suministro.Nbre ";
            }
        } else if (this.JCHEsProducto.isSelected()) {
            if (this.JCHFiltro.isSelected()) {
                this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.Costo) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND (i_suministro.Nbre like'" + this.txtProducto.getText() + "%' or `i_principioactivo`.`Nbre` like'" + this.txtProducto.getText() + "%' ) AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
            } else {
                this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.Costo) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND (i_suministro.Nbre like'%" + this.txtProducto.getText() + "%' or `i_principioactivo`.`Nbre` like'" + this.txtProducto.getText() + "%' ) AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
            }
        } else if (this.JCHFiltro.isSelected()) {
            this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.Costo) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND i_suministro.CodBarraUnidad like'" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
        } else {
            this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.Costo) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND i_suministro.CodBarraUnidad like'%" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
        }
        System.out.println("sueno " + this.sql);
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                this.metodos.mEstablecerTextEditor(this.grid, 2);
                this.metodos.mEstablecerTextEditor(this.grid, 14);
                this.metodos.mEstablecerTextEditor(this.grid, 13);
                while (rs.next()) {
                    this.modelo.addRow(this.datos);
                    this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                    this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                    this.modelo.setValueAt(rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5), this.filaGrid, 2);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt(7)), this.filaGrid, 3);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(6)), this.filaGrid, 4);
                    this.modelo.setValueAt(rs.getString(8), this.filaGrid, 5);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt(9)), this.filaGrid, 6);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt(11)), this.filaGrid, 8);
                    this.modelo.setValueAt(Double.valueOf(rs.getDouble(12)), this.filaGrid, 9);
                    this.modelo.setValueAt(rs.getString(13), this.filaGrid, 10);
                    this.modelo.setValueAt(Boolean.valueOf(rs.getBoolean(10)), this.filaGrid, 7);
                    this.modelo.setValueAt(rs.getString("CodigoCUM"), this.filaGrid, 11);
                    this.modelo.setValueAt(rs.getString("CodigoAtc"), this.filaGrid, 12);
                    this.modelo.setValueAt(rs.getString("Concentracion"), this.filaGrid, 13);
                    this.modelo.setValueAt(rs.getString("PActivo"), this.filaGrid, 14);
                    this.modelo.setValueAt(rs.getString("RegistroInvima"), this.filaGrid, 15);
                    this.modelo.setValueAt(rs.getString("FechaVInvima"), this.filaGrid, 16);
                    this.filaGrid++;
                }
                rs.close();
                this.consultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void buscarOtrasIPS() {
        if (this.pantalla.equals("Despachos")) {
            if (Principal.clasecaja == null) {
                if (this.JCHEsProducto.isSelected()) {
                    this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio,if(" + Principal.informacionIps.getEsFpz() + "=0, round(i_suministroxbodega.Costo),i_suministroxbodega.VVenta)  as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND (i_suministro.Nbre like'" + this.txtProducto.getText() + "%' ) AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
                } else {
                    this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio,if(" + Principal.informacionIps.getEsFpz() + "=0, round(i_suministroxbodega.Costo),i_suministroxbodega.VVenta) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND  i_suministro.CodBarraUnidad like'" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
                }
            } else if (this.JCHEsProducto.isSelected()) {
                this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.VVenta) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND (i_suministro.Nbre like'" + this.txtProducto.getText() + "%' ) AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad,i_suministro.Nbre ";
            } else {
                this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.VVenta) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND  i_suministro.CodBarraUnidad like'" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad,i_suministro.Nbre ";
            }
        } else if (this.JCHEsProducto.isSelected()) {
            if (this.JCHFiltro.isSelected()) {
                this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.Costo) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND (i_suministro.Nbre like'" + this.txtProducto.getText() + "%' ) AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
            } else {
                this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.Costo) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo ,i_suministro.RegistroInvima , i_suministro.FechaVInvima FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND (i_suministro.Nbre like'%" + this.txtProducto.getText() + "%' ) AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
            }
        } else if (this.JCHFiltro.isSelected()) {
            this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.Costo) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND i_suministro.CodBarraUnidad like'" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
        } else {
            this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, CONCAT(`i_suministro`.`Nbre`, ' ' ,  `i_concentracion`.`Nbre`, ' ' ,  `i_presentacionfarmaceutica`.`Nbre`) as Producto, i_presentacioncomercial.Nbre as Presentacion, i_laboratorio.Nbre as Laboratorio, round(i_suministroxbodega.Costo) as Costo, SUM(i_suministroxlotexbodega.Cantidad) as Cantidad, i_suministro.IdPrincipioActivo, i_suministro.CantidadUnidad, IF(i_suministro.DLogo IS NULL,FALSE,IF( i_suministro.DLogo='',FALSE,IF( i_suministro.DLogo='0',FALSE,IF( i_suministro.DLogo='(NULL)',FALSE,TRUE)))) AS DLogo, i_suministroxbodega.Id, i_suministro.Iva, i_suministro.CodigoAgrupacion,`i_suministro`.`CodigoCUM`, `i_suministro`.`CodigoAtc`,`i_concentracion`.`Nbre` AS `Concentracion`,`i_principioactivo`.`Nbre` AS PActivo,i_suministro.RegistroInvima , i_suministro.FechaVInvima  FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministroxbodega ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN `i_concentracion` ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)  INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) WHERE (i_suministro.EstaActivo=1 AND i_suministro.CodBarraUnidad like'%" + this.txtProducto.getText() + "%' AND i_suministroxbodega.IdBodega='" + this.claseInv.getIdBodega() + "') GROUP BY i_suministroxbodega.IdSuministro order by i_suministro.CodBarraUnidad, i_suministro.Nbre ";
        }
        System.out.println("\n sueno " + this.sql);
        try {
            ResultSet rs = this.consultas.traerRs(this.sql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    this.metodos.mEstablecerTextEditor(this.grid, 2);
                    this.metodos.mEstablecerTextEditor(this.grid, 14);
                    this.metodos.mEstablecerTextEditor(this.grid, 13);
                    while (rs.next()) {
                        this.modelo.addRow(this.datos);
                        this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                        this.modelo.setValueAt(rs.getString(2), this.filaGrid, 1);
                        this.modelo.setValueAt(rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5), this.filaGrid, 2);
                        this.modelo.setValueAt(Integer.valueOf(rs.getInt(7)), this.filaGrid, 3);
                        this.modelo.setValueAt(Double.valueOf(rs.getDouble(6)), this.filaGrid, 4);
                        this.modelo.setValueAt(rs.getString(8), this.filaGrid, 5);
                        this.modelo.setValueAt(Integer.valueOf(rs.getInt(9)), this.filaGrid, 6);
                        this.modelo.setValueAt(Integer.valueOf(rs.getInt(11)), this.filaGrid, 8);
                        this.modelo.setValueAt(Double.valueOf(rs.getDouble(12)), this.filaGrid, 9);
                        this.modelo.setValueAt(rs.getString(13), this.filaGrid, 10);
                        this.modelo.setValueAt(Boolean.valueOf(rs.getBoolean(10)), this.filaGrid, 7);
                        this.modelo.setValueAt(rs.getString("CodigoCUM"), this.filaGrid, 11);
                        this.modelo.setValueAt(rs.getString("CodigoAtc"), this.filaGrid, 12);
                        this.modelo.setValueAt(rs.getString("Concentracion"), this.filaGrid, 13);
                        this.modelo.setValueAt(rs.getString("PActivo"), this.filaGrid, 14);
                        this.modelo.setValueAt(rs.getString("RegistroInvima"), this.filaGrid, 15);
                        this.modelo.setValueAt(rs.getString("FechaVInvima"), this.filaGrid, 16);
                        this.filaGrid++;
                    }
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
            } finally {
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void entregarDatos() {
        if (this.pantalla.equals("Entradas")) {
            this.frmEntrada.txtCodigo.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
            dispose();
            this.frmEntrada.buscarProducto(1);
            return;
        }
        if (this.pantalla.equals("Despachos")) {
            this.frmDespacho.txtCodigo.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
            dispose();
            this.frmDespacho.buscarProducto(1);
        } else if (this.pantalla.equals("Salidas")) {
            this.frmSalida.txtCodigo.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
            dispose();
            this.frmSalida.buscarProducto(1);
        } else if (this.pantalla.equals("ITraslados")) {
            this.frmTraslado.txtCodigo.setText(this.modelo.getValueAt(this.grid.getSelectedRow(), 1).toString());
            dispose();
            this.frmTraslado.buscarProducto(1);
        }
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.txtProducto = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jLabel3 = new JLabel();
        this.JCHEsProducto = new JCheckBox();
        this.JCHFiltro = new JCheckBox();
        this.JPFiltroE = new JPanel();
        this.JRBTodo = new JRadioButton();
        this.JRBExistencia = new JRadioButton();
        this.JRBSinExistencia = new JRadioButton();
        setDefaultCloseOperation(2);
        setTitle("BUSQUEDA DE PRODUCTO");
        setMinimumSize(null);
        setModal(true);
        setName("BuscarProducto");
        setResizable(false);
        this.txtProducto.setFont(new Font("Arial", 1, 12));
        this.txtProducto.setToolTipText("Finalizar con la tecla enter");
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro de Búsqueda(Nombre, Codigo Barra, Principio Activo)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtProducto.addActionListener(new ActionListener() { // from class: Inventarios.BuscarProducto.3
            public void actionPerformed(ActionEvent evt) {
                BuscarProducto.this.txtProductoActionPerformed(evt);
            }
        });
        this.txtProducto.addKeyListener(new KeyAdapter() { // from class: Inventarios.BuscarProducto.4
            public void keyTyped(KeyEvent evt) {
                BuscarProducto.this.txtProductoKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                BuscarProducto.this.txtProductoKeyPressed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.grid.setToolTipText("Doble Click para cargar el Producto");
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Inventarios.BuscarProducto.5
            public void mouseClicked(MouseEvent evt) {
                BuscarProducto.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.jLabel3.setBackground(new Color(255, 255, 255));
        this.jLabel3.setFont(new Font("Arial", 1, 14));
        this.jLabel3.setForeground(new Color(255, 0, 0));
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("Haga doble Click para cargar el Producto");
        this.JCHEsProducto.setFont(new Font("Arial", 1, 12));
        this.JCHEsProducto.setSelected(true);
        this.JCHEsProducto.setText("Es Producto?");
        this.JCHEsProducto.addActionListener(new ActionListener() { // from class: Inventarios.BuscarProducto.6
            public void actionPerformed(ActionEvent evt) {
                BuscarProducto.this.JCHEsProductoActionPerformed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Comienza?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Inventarios.BuscarProducto.7
            public void actionPerformed(ActionEvent evt) {
                BuscarProducto.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JPFiltroE.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro existencia", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGFiltro.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setText("Todo");
        this.JRBTodo.addActionListener(new ActionListener() { // from class: Inventarios.BuscarProducto.8
            public void actionPerformed(ActionEvent evt) {
                BuscarProducto.this.JRBTodoActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBExistencia);
        this.JRBExistencia.setFont(new Font("Arial", 1, 12));
        this.JRBExistencia.setSelected(true);
        this.JRBExistencia.setText("Con Existencia");
        this.JRBExistencia.addActionListener(new ActionListener() { // from class: Inventarios.BuscarProducto.9
            public void actionPerformed(ActionEvent evt) {
                BuscarProducto.this.JRBExistenciaActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBSinExistencia);
        this.JRBSinExistencia.setFont(new Font("Arial", 1, 12));
        this.JRBSinExistencia.setText("Sin Existencia");
        this.JRBSinExistencia.addActionListener(new ActionListener() { // from class: Inventarios.BuscarProducto.10
            public void actionPerformed(ActionEvent evt) {
                BuscarProducto.this.JRBSinExistenciaActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroELayout = new GroupLayout(this.JPFiltroE);
        this.JPFiltroE.setLayout(JPFiltroELayout);
        JPFiltroELayout.setHorizontalGroup(JPFiltroELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroELayout.createSequentialGroup().addComponent(this.JRBTodo).addGap(18, 18, 18).addComponent(this.JRBExistencia).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSinExistencia).addGap(0, 6, 32767)));
        JPFiltroELayout.setVerticalGroup(JPFiltroELayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroELayout.createSequentialGroup().addGroup(JPFiltroELayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBExistencia).addComponent(this.JRBSinExistencia)).addGap(0, 10, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 890, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.txtProducto).addGap(18, 18, 18).addComponent(this.JCHFiltro).addGap(18, 18, 18).addComponent(this.JCHEsProducto).addGap(11, 11, 11)).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JPFiltroE, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel3, -2, 511, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtProducto, -2, 50, -2).addComponent(this.JCHEsProducto).addComponent(this.JCHFiltro)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 286, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPFiltroE, -1, -1, 32767).addComponent(this.jLabel3, -1, -1, 32767)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsProductoActionPerformed(ActionEvent evt) {
        if (this.JCHEsProducto.isSelected()) {
            this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else {
            this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Referencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.JCHFiltro.setText("Comienza?");
        } else {
            this.JCHFiltro.setText("Contiene?");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            entregarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodoActionPerformed(ActionEvent evt) {
        this.sqlAdicional = "0";
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBExistenciaActionPerformed(ActionEvent evt) {
        this.sqlAdicional = "1";
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinExistenciaActionPerformed(ActionEvent evt) {
        this.sqlAdicional = "2";
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtProductoActionPerformed(ActionEvent evt) {
    }
}
