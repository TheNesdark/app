package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Paquetes.class */
public class Paquetes extends JDialog {
    private ConsultasMySQL consultas;
    private int fila;
    private int xidseg;
    private double xedad;
    private long xidpersona;
    private long xIdEmpresa;
    private String sql;
    private String id;
    private String idPaquete;
    public DefaultTableModel modelo;
    public DefaultTableModel xmodelo;
    private ResultSet rs;
    private Object[] dato;
    private Ordenes frmOrden;
    private Metodos xmt;
    private boolean xtipo;
    private String fechaNacimiento;
    private String sexo;
    private ButtonGroup JBGSeleccion;
    private JCheckBox JCHFiltro_Edad;
    private JCheckBox JCHMSLaboratorio;
    private JCheckBox JCHMSNinguno;
    private JCheckBox JCHMSTodos;
    private JCheckBox JCHNoVencidos;
    private JCheckBox JCHVencidos;
    private JLabel JLBTLaboral;
    private JPanel JPIConvenciones;
    private JPanel JPIMSeleccion;
    private JPanel JPINSeg;
    private JPanel JPIPaquete;
    private JScrollPane JSPConsolidado;
    private JTable JTBDetalle_Seg;
    private JTabbedPane JTPDatos;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JTable grid;
    private JScrollPane jScrollPane1;
    private JTextField txtPaquete;

    public Paquetes(Frame parent, boolean modal, String Id, String Nbre, Ordenes orden, String idpaquete, boolean xtipo, String fechaNacimiento, String sexo) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.fila = 0;
        this.xidseg = 0;
        this.xedad = 0.0d;
        this.xidpersona = 0L;
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.frmOrden = orden;
        this.id = Id;
        this.txtPaquete.setText(Nbre);
        this.idPaquete = idpaquete;
        this.xtipo = xtipo;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        if (xtipo) {
            cargarDatos();
            this.JTPDatos.setSelectedIndex(0);
        } else {
            this.JTPDatos.setSelectedIndex(1);
        }
    }

    public Paquetes(Frame parent, boolean modal, boolean xtipo, int xidseg, long xidpersona, long xIdEmpresa, Ordenes orden, String Id, String fechaNacimiento, String sexo) {
        super(parent, modal);
        this.consultas = new ConsultasMySQL();
        this.fila = 0;
        this.xidseg = 0;
        this.xedad = 0.0d;
        this.xidpersona = 0L;
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.xtipo = xtipo;
        this.xidseg = xidseg;
        this.xidpersona = xidpersona;
        this.xIdEmpresa = xIdEmpresa;
        this.frmOrden = orden;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.id = Id;
        cargarDatos();
        mCargarDatos_Seg();
        mTraerTLaboral();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.JTPDatos.setSelectedIndex(1);
        } else {
            this.JTPDatos.setSelectedIndex(0);
        }
    }

    private void cargarDatos() {
        crearGrid();
        if (this.frmOrden != null) {
            if (this.frmOrden.getFiltroProcxEmp().equals("0")) {
                this.sql = "SELECT g_procedimxpaquete.Id_Procedim AS Id, g_procedimiento.Nbre, g_procedimiento.Id_TipoFinProced AS CodFinal, f_procedimcentrocosto.Id_CentroCosto AS codCC, f_tiposervicio.Id AS IdServicio, f_tiposervicio.Nbre AS nbreServicio, f_tarifaprocedimiento.Id_TipoPlan AS tipoPlan, IF(0=" + this.frmOrden.getCualValor() + ",if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMinimo,f_procedempresaconvenio.Valor), if(f_procedempresaconvenio.Valor=0, f_tarifaprocedimiento.VrMaximo,f_procedempresaconvenio.Valor)) AS Valor, f_empresacontxconvenio.Id AS IdEmpresa, g_procedimxpaquete.Id_Especial, g_procedimiento.EsCita, g_procedimxpaquete.Fijo, g_procedimxpaquete.Observacion , g_procedimiento.`EsRemitido`, g_procedimiento.porcentajeImpuesto, CONCAT(f_tipofinprocedimiento.`Id`, '-',f_tipofinprocedimiento.`Nbre`) AS finProcedimiento FROM g_procedimiento INNER JOIN g_procedimxpaquete ON (g_procedimiento.Id = g_procedimxpaquete.Id_Procedim) INNER JOIN f_procedimcentrocosto ON (f_procedimcentrocosto.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) INNER JOIN f_tarifaprocedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_empresacontxconvenio ON (f_tarifaprocedimiento.Id_Manual = f_empresacontxconvenio.Id_Manual) INNER JOIN `f_procedempresaconvenio` ON (f_procedempresaconvenio.`Id_EmpresacontxConv`= f_empresacontxconvenio.`Id`)\nINNER JOIN `f_tipofinprocedimiento` ON (f_tipofinprocedimiento.`Id` = g_procedimxpaquete.`idFinProcedimiento`)\n    AND (f_procedempresaconvenio.`Id_Procedimiento`=g_procedimiento.`Id`)WHERE (g_procedimxpaquete.Id_Paquete ='" + this.id + "' AND g_procedimiento.Paquete=0 AND g_procedimxpaquete.Estado =1 AND f_empresacontxconvenio.Id ='" + Principal.clasefacturacion.frmFacturac.frmIngreso.listConvenio.get(Principal.clasefacturacion.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId() + "' AND g_procedimiento.`Sexo` IN ('A', '" + this.sexo + "') \nAND ( DATEDIFF(NOW(),'" + this.fechaNacimiento + "') >= g_procedimiento.EdadI  \nAND DATEDIFF(NOW(),'" + this.fechaNacimiento + "') <= g_procedimiento.EdadM)) GROUP BY g_procedimxpaquete.Id_Procedim   ORDER BY f_tiposervicio.Nbre ASC ";
            } else {
                this.sql = "select g_procedimxpaquete.Id_Procedim AS Id, g_procedimiento.Nbre, g_procedimiento.Id_TipoFinProced AS CodFinal\n, f_procedimcentrocosto.Id_CentroCosto AS codCC,\n f_tiposervicio.Id AS IdServicio, f_tiposervicio.Nbre AS nbreServicio, f_tarifaprocedimiento.Id_TipoPlan AS tipoPlan, IF(0=0,f_tarifaprocedimiento.VrMinimo, \n f_tarifaprocedimiento.VrMaximo) AS Valor, \n fs.Id_EmpresaConvenio AS IdEmpresa, g_procedimxpaquete.Id_Especial, g_procedimiento.EsCita, g_procedimxpaquete.Fijo, g_procedimxpaquete.Observacion\n ,  g_procedimiento.`EsRemitido`, g_procedimiento.porcentajeImpuesto, CONCAT(f_tipofinprocedimiento.`Id`, '-',f_tipofinprocedimiento.`Nbre`)  AS finProcedimiento\nfrom g_procedimxpaquete  \ninner join g_procedimiento  on (g_procedimiento.Id =g_procedimxpaquete.Id_Procedim )\ninner join f_procedimcentrocosto   on (f_procedimcentrocosto.Id_Procedimiento =g_procedimiento.Id )\nINNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id) \n INNER JOIN f_servicioempresaconv fs on (fs.Id_TipoServicio=f_tiposervtipoproced.Idtiposervicio ) \n INNER JOIN f_tarifaprocedimiento ON (f_tarifaprocedimiento.Id_Manual  = fs.Id_Manual_n ) \n LEFT JOIN `f_tipofinprocedimiento` ON (f_tipofinprocedimiento.`Id` = g_procedimxpaquete.`idFinProcedimiento`)\nwhere g_procedimxpaquete.Id_Paquete =" + this.id + " and fs.Id_EmpresaConvenio =" + Principal.clasefacturacion.frmFacturac.frmIngreso.listConvenio.get(Principal.clasefacturacion.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId() + "\nAND g_procedimiento.Paquete=0 \nAND g_procedimxpaquete.Estado =1 \n AND g_procedimiento.`Sexo` IN ('A', '" + this.sexo + "') \n AND ( DATEDIFF(NOW(),'" + this.fechaNacimiento + "') >= g_procedimiento.EdadI  \nAND DATEDIFF(NOW(),'" + this.fechaNacimiento + "') <= g_procedimiento.EdadM)\nGROUP BY g_procedimxpaquete.Id_Procedim   \nORDER BY f_tiposervicio.Nbre ASC ";
            }
            System.out.println("PAQUETE " + this.sql);
            this.rs = this.consultas.traerRs(this.sql);
            this.xmt.mEstablecerTextEditor(this.grid, 1);
            this.xmt.mEstablecerTextEditor(this.grid, 15);
            while (this.rs.next()) {
                try {
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(this.rs.getString("Id"), this.fila, 0);
                    this.modelo.setValueAt(this.rs.getString("Nbre"), this.fila, 1);
                    this.modelo.setValueAt(this.rs.getString("codFinal"), this.fila, 2);
                    this.modelo.setValueAt(this.rs.getString("codCC"), this.fila, 3);
                    this.modelo.setValueAt(this.rs.getString("IdServicio"), this.fila, 4);
                    this.modelo.setValueAt(this.rs.getString("nbreServicio"), this.fila, 5);
                    this.modelo.setValueAt("Es_Proc", this.fila, 6);
                    this.modelo.setValueAt(this.rs.getString("tipoPlan"), this.fila, 7);
                    this.modelo.setValueAt(1, this.fila, 8);
                    this.modelo.setValueAt(this.rs.getString("Valor"), this.fila, 9);
                    this.modelo.setValueAt(false, this.fila, 10);
                    this.modelo.setValueAt(Boolean.valueOf(this.rs.getBoolean("Fijo")), this.fila, 11);
                    this.modelo.setValueAt(0, this.fila, 12);
                    this.modelo.setValueAt(this.rs.getString("Id_Especial"), this.fila, 13);
                    this.modelo.setValueAt(this.rs.getString("EsCita"), this.fila, 14);
                    this.modelo.setValueAt(this.rs.getString("Observacion"), this.fila, 15);
                    this.modelo.setValueAt(Integer.valueOf(this.rs.getInt("EsRemitido")), this.fila, 16);
                    this.modelo.setValueAt(Double.valueOf(this.rs.getDouble("porcentajeImpuesto")), this.fila, 17);
                    this.modelo.setValueAt(this.rs.getString("finProcedimiento"), this.fila, 18);
                    this.grid.setDefaultRenderer(Object.class, new MiRender());
                    this.fila++;
                } catch (SQLException ex) {
                    this.consultas.mostrarErrorSQL(ex);
                    return;
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/Paquetes$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 16).toString().equals("1")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "CodFinalidad", "CodCC", "IdServicio", "Nbre Servicio", "TipoServicio", "Tipo Plan", "Cantidad", "Valor", "Descuento", "Realizar", "VrDescuento", "IdEspecial", "EsCita", "Observación", "EsRemitido", "% Impuesto", "Finalidad"}) { // from class: Facturacion.Paquetes.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Boolean.class, Boolean.class, Integer.class, String.class, String.class, String.class, Integer.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false, true, true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(1).setMinWidth(400);
        this.grid.getColumnModel().getColumn(1).setMaxWidth(400);
        this.grid.getColumnModel().getColumn(2).setMinWidth(0);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(3).setMinWidth(0);
        this.grid.getColumnModel().getColumn(3).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(4).setMinWidth(0);
        this.grid.getColumnModel().getColumn(4).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(6).setMinWidth(0);
        this.grid.getColumnModel().getColumn(6).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(7).setMinWidth(0);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(10).setMinWidth(0);
        this.grid.getColumnModel().getColumn(10).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(12).setMinWidth(0);
        this.grid.getColumnModel().getColumn(12).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(13).setMinWidth(0);
        this.grid.getColumnModel().getColumn(13).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(14).setMinWidth(0);
        this.grid.getColumnModel().getColumn(14).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(16).setMinWidth(0);
        this.grid.getColumnModel().getColumn(16).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(17).setMinWidth(80);
        this.grid.getColumnModel().getColumn(17).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(18).setMinWidth(100);
        this.grid.getColumnModel().getColumn(18).setMaxWidth(100);
        this.fila = 0;
    }

    private void entregarDatos() {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            for (int f = 0; f < this.modelo.getRowCount(); f++) {
                if (this.modelo.getValueAt(f, 11).toString().equals("true")) {
                    this.frmOrden.cboServicio.setSelectedItem(this.modelo.getValueAt(f, 5).toString());
                    this.frmOrden.txtCodigo.setText(this.modelo.getValueAt(f, 0).toString());
                    this.frmOrden.cboProcedSuministro.setSelectedItem(this.modelo.getValueAt(f, 1).toString());
                    this.frmOrden.cboFinProcedimiento.setSelectedItem(this.modelo.getValueAt(f, 18).toString());
                    this.frmOrden.bajarTabla("");
                }
            }
        } else {
            for (int f2 = 0; f2 < this.xmodelo.getRowCount(); f2++) {
                if (this.xmodelo.getValueAt(f2, 11).toString().equals("true")) {
                    Principal.clasefacturacion.frmFacturac.frmOrdenes.adicionarDetallePaquete(this.xmodelo.getValueAt(f2, 0).toString(), this.xmodelo.getValueAt(f2, 1).toString(), this.xmodelo.getValueAt(f2, 2).toString(), this.xmodelo.getValueAt(f2, 3).toString(), this.xmodelo.getValueAt(f2, 4).toString(), this.xmodelo.getValueAt(f2, 5).toString(), this.xmodelo.getValueAt(f2, 6).toString(), this.xmodelo.getValueAt(f2, 7).toString(), Integer.parseInt(this.xmodelo.getValueAt(f2, 8).toString()), Integer.parseInt(this.xmodelo.getValueAt(f2, 9).toString()), Integer.parseInt(this.xmodelo.getValueAt(f2, 12).toString()), this.idPaquete, this.xmodelo.getValueAt(f2, 13).toString(), this.xmodelo.getValueAt(f2, 14).toString(), Double.valueOf(0.0d).doubleValue(), Boolean.valueOf(this.xmodelo.getValueAt(f2, 21).toString()).booleanValue());
                }
            }
        }
        dispose();
    }

    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.btnCancelar = new JButton();
        this.btnAceptar = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JPIPaquete = new JPanel();
        this.txtPaquete = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.JPINSeg = new JPanel();
        this.JSPConsolidado = new JScrollPane();
        this.JTBDetalle_Seg = new JTable();
        this.JCHFiltro_Edad = new JCheckBox();
        this.JPIConvenciones = new JPanel();
        this.JCHVencidos = new JCheckBox();
        this.JCHNoVencidos = new JCheckBox();
        this.JLBTLaboral = new JLabel();
        this.JPIMSeleccion = new JPanel();
        this.JCHMSTodos = new JCheckBox();
        this.JCHMSNinguno = new JCheckBox();
        this.JCHMSLaboratorio = new JCheckBox();
        setDefaultCloseOperation(2);
        setTitle("PROCEDIMIENTO X PAQUETE");
        setName("Paquetes");
        setResizable(false);
        this.btnCancelar.setFont(new Font("Arial", 1, 12));
        this.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCancelar.setText("Salir");
        this.btnCancelar.addActionListener(new ActionListener() { // from class: Facturacion.Paquetes.2
            public void actionPerformed(ActionEvent evt) {
                Paquetes.this.btnCancelarActionPerformed(evt);
            }
        });
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Facturacion.Paquetes.3
            public void actionPerformed(ActionEvent evt) {
                Paquetes.this.btnAceptarActionPerformed(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.txtPaquete.setFont(new Font("Arial", 1, 12));
        this.txtPaquete.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtPaquete.setDisabledTextColor(new Color(51, 51, 51));
        this.txtPaquete.setEnabled(false);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.grid.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(Color.red);
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        GroupLayout JPIPaqueteLayout = new GroupLayout(this.JPIPaquete);
        this.JPIPaquete.setLayout(JPIPaqueteLayout);
        JPIPaqueteLayout.setHorizontalGroup(JPIPaqueteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPaqueteLayout.createSequentialGroup().addContainerGap().addGroup(JPIPaqueteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPaqueteLayout.createSequentialGroup().addComponent(this.txtPaquete, -2, 829, -2).addGap(0, 24, 32767)).addComponent(this.jScrollPane1)).addContainerGap()));
        JPIPaqueteLayout.setVerticalGroup(JPIPaqueteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPaqueteLayout.createSequentialGroup().addContainerGap().addComponent(this.txtPaquete, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 412, 32767).addContainerGap()));
        this.JTPDatos.addTab("PAQUETE", this.JPIPaquete);
        this.JSPConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTBDetalle_Seg.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle_Seg.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle_Seg.setRowHeight(25);
        this.JTBDetalle_Seg.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle_Seg.setSelectionForeground(new Color(255, 0, 0));
        this.JSPConsolidado.setViewportView(this.JTBDetalle_Seg);
        this.JCHFiltro_Edad.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro_Edad.setForeground(new Color(255, 0, 0));
        this.JCHFiltro_Edad.setSelected(true);
        this.JCHFiltro_Edad.setText("Filtro por Edad");
        this.JCHFiltro_Edad.addActionListener(new ActionListener() { // from class: Facturacion.Paquetes.4
            public void actionPerformed(ActionEvent evt) {
                Paquetes.this.JCHFiltro_EdadActionPerformed(evt);
            }
        });
        this.JPIConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCHVencidos.setBackground(new Color(251, 54, 54));
        this.JCHVencidos.setFont(new Font("Arial", 1, 12));
        this.JCHVencidos.setSelected(true);
        this.JCHVencidos.setText("Vencido");
        this.JCHNoVencidos.setBackground(new Color(133, 218, 160));
        this.JCHNoVencidos.setFont(new Font("Arial", 1, 12));
        this.JCHNoVencidos.setSelected(true);
        this.JCHNoVencidos.setText("No Vencidos");
        GroupLayout JPIConvencionesLayout = new GroupLayout(this.JPIConvenciones);
        this.JPIConvenciones.setLayout(JPIConvencionesLayout);
        JPIConvencionesLayout.setHorizontalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHVencidos, -2, 88, -2).addGap(18, 18, 18).addComponent(this.JCHNoVencidos).addContainerGap(-1, 32767)));
        JPIConvencionesLayout.setVerticalGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHVencidos).addComponent(this.JCHNoVencidos)));
        this.JLBTLaboral.setBackground(new Color(255, 0, 0));
        this.JLBTLaboral.setFont(new Font("Arial", 1, 16));
        this.JLBTLaboral.setForeground(new Color(255, 255, 255));
        this.JLBTLaboral.setHorizontalAlignment(0);
        this.JLBTLaboral.setBorder(BorderFactory.createTitledBorder((Border) null, "TLaboral", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 0)));
        this.JLBTLaboral.setOpaque(true);
        GroupLayout JPINSegLayout = new GroupLayout(this.JPINSeg);
        this.JPINSeg.setLayout(JPINSegLayout);
        JPINSegLayout.setHorizontalGroup(JPINSegLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINSegLayout.createSequentialGroup().addContainerGap().addComponent(this.JLBTLaboral, -2, 210, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, 32767).addComponent(this.JCHFiltro_Edad).addGap(259, 259, 259).addComponent(this.JPIConvenciones, -2, -1, -2).addGap(22, 22, 22)).addGroup(JPINSegLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPINSegLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPConsolidado, -2, 846, -2).addContainerGap(17, 32767))));
        JPINSegLayout.setVerticalGroup(JPINSegLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPINSegLayout.createSequentialGroup().addContainerGap(432, 32767).addGroup(JPINSegLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIConvenciones, -1, -1, 32767).addComponent(this.JCHFiltro_Edad, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLBTLaboral, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()).addGroup(JPINSegLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINSegLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPConsolidado, -2, 417, -2).addContainerGap(62, 32767))));
        this.JTPDatos.addTab("PROCEDIMIENTOS POR #SEG", this.JPINSeg);
        this.JPIMSeleccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Selección", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JPIMSeleccion.setForeground(new Color(0, 153, 51));
        this.JBGSeleccion.add(this.JCHMSTodos);
        this.JCHMSTodos.setFont(new Font("Arial", 1, 12));
        this.JCHMSTodos.setSelected(true);
        this.JCHMSTodos.setText("Todos");
        this.JCHMSTodos.addActionListener(new ActionListener() { // from class: Facturacion.Paquetes.5
            public void actionPerformed(ActionEvent evt) {
                Paquetes.this.JCHMSTodosActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JCHMSNinguno);
        this.JCHMSNinguno.setFont(new Font("Arial", 1, 12));
        this.JCHMSNinguno.setText("Ninguno");
        this.JCHMSNinguno.addActionListener(new ActionListener() { // from class: Facturacion.Paquetes.6
            public void actionPerformed(ActionEvent evt) {
                Paquetes.this.JCHMSNingunoActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JCHMSLaboratorio);
        this.JCHMSLaboratorio.setFont(new Font("Arial", 1, 12));
        this.JCHMSLaboratorio.setText("Laboratorio");
        this.JCHMSLaboratorio.addActionListener(new ActionListener() { // from class: Facturacion.Paquetes.7
            public void actionPerformed(ActionEvent evt) {
                Paquetes.this.JCHMSLaboratorioActionPerformed(evt);
            }
        });
        GroupLayout JPIMSeleccionLayout = new GroupLayout(this.JPIMSeleccion);
        this.JPIMSeleccion.setLayout(JPIMSeleccionLayout);
        JPIMSeleccionLayout.setHorizontalGroup(JPIMSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMSeleccionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHMSTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHMSNinguno).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHMSLaboratorio).addContainerGap(-1, 32767)));
        JPIMSeleccionLayout.setVerticalGroup(JPIMSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIMSeleccionLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIMSeleccionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHMSTodos).addComponent(this.JCHMSNinguno, -2, 23, -2).addComponent(this.JCHMSLaboratorio, -2, 23, -2))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatos, -2, 878, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPIMSeleccion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnAceptar, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnCancelar, -2, 300, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnCancelar, -2, 47, -2).addComponent(this.btnAceptar, -2, 46, -2)).addComponent(this.JPIMSeleccion, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCancelarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        entregarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltro_EdadActionPerformed(ActionEvent evt) {
        mCargarDatos_Seg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMSTodosActionPerformed(ActionEvent evt) {
        mSeleccionarDatos(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMSNingunoActionPerformed(ActionEvent evt) {
        mSeleccionarDatos(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMSLaboratorioActionPerformed(ActionEvent evt) {
        mSeleccionarDatos(2);
    }

    private void mSeleccionarDatos(int xftipo) {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            for (int x = 0; x < this.modelo.getRowCount(); x++) {
                if (xftipo == 0) {
                    this.modelo.setValueAt(true, x, 11);
                } else if (xftipo == 1) {
                    this.modelo.setValueAt(false, x, 11);
                } else if (xftipo == 2) {
                    if (Integer.valueOf(this.modelo.getValueAt(x, 4).toString()).intValue() == 2) {
                        this.modelo.setValueAt(true, x, 11);
                    } else {
                        this.modelo.setValueAt(false, x, 11);
                    }
                }
            }
            return;
        }
        for (int x2 = 0; x2 < this.xmodelo.getRowCount(); x2++) {
            if (xftipo == 0) {
                this.xmodelo.setValueAt(true, x2, 11);
            } else if (xftipo == 1) {
                this.xmodelo.setValueAt(false, x2, 11);
            } else if (xftipo == 2) {
                if (Integer.valueOf(this.xmodelo.getValueAt(x2, 4).toString()).intValue() == 2) {
                    this.xmodelo.setValueAt(true, x2, 11);
                } else {
                    this.xmodelo.setValueAt(false, x2, 11);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrear_DetalleSeg() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "CodFinalidad", "CodCC", "IdServicio", "Nbre Servicio", "TipoServicio", "Tipo Plan", "Cantidad", "Valor", "Descuento", "Realizar", "VrDescuento", "IdEspecial", "EsCita", "Observación", "EsRemitido", "UFecha", "N°Días", "PFecha", "V", "Es_Prioritario"}) { // from class: Facturacion.Paquetes.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Boolean.class, Boolean.class, Integer.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false, true, true, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle_Seg.setModel(this.xmodelo);
        this.JTBDetalle_Seg.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTBDetalle_Seg.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(11).setPreferredWidth(5);
        this.JTBDetalle_Seg.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(15).setPreferredWidth(110);
        this.JTBDetalle_Seg.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(17).setPreferredWidth(20);
        this.JTBDetalle_Seg.getColumnModel().getColumn(18).setPreferredWidth(5);
        this.JTBDetalle_Seg.getColumnModel().getColumn(19).setPreferredWidth(20);
        this.JTBDetalle_Seg.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBDetalle_Seg.getColumnModel().getColumn(21).setMaxWidth(0);
    }

    private void mCargarDatos_Seg() {
        mTraerTLaboral();
        if (this.JCHFiltro_Edad.isSelected()) {
            this.sql = "SELECT g_procedimiento.Id AS Id, g_procedimiento.Nbre, g_procedimiento.Id_TipoFinProced AS CodFinal,  f_procedimcentrocosto.Id_CentroCosto AS codCC, f_tiposervicio.Id AS IdServicio, f_tiposervicio.Nbre AS nbreServicio,  f_tarifaprocedimiento.Id_TipoPlan AS tipoPlan,  IF(0=0,f_tarifaprocedimiento.VrMinimo, f_tarifaprocedimiento.VrMaximo) AS Valor, f_empresacontxconvenio.Id AS IdEmpresa, 690 AS  Id_Especial, g_procedimiento.EsCita, TRUE AS Fijo, so_seg_procedimiento.`Observacion` , g_procedimiento.`EsRemitido`  , so_seg_procedimiento.`IPeriodo` , `g_procedimiento`.`Es_Prioritario` FROM g_procedimiento  INNER JOIN so_seg_procedimiento ON (g_procedimiento.Id = so_seg_procedimiento.`Id_Procedimiento`)  INNER JOIN f_procedimcentrocosto ON (f_procedimcentrocosto.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)  INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)  INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id)  INNER JOIN f_tarifaprocedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN f_empresacontxconvenio ON (f_tarifaprocedimiento.Id_Manual = f_empresacontxconvenio.Id_Manual)   INNER JOIN so_seg_procedimiento_encabezado ON (so_seg_procedimiento.`IdEncabezado`=so_seg_procedimiento_encabezado.`id`) WHERE (so_seg_procedimiento.`Id_TSegmento` ='" + this.xidseg + "' AND " + this.xedad + ">=so_seg_procedimiento.`EInicio` AND " + this.xedad + "<=so_seg_procedimiento.`EFinal` AND so_seg_procedimiento.Estado =1 AND f_empresacontxconvenio.Id ='" + this.xIdEmpresa + "' AND so_seg_procedimiento_encabezado.`Estado`=1)    ORDER BY f_tiposervicio.Nbre ASC, g_procedimiento.Nbre ASC ";
        } else {
            this.sql = "SELECT g_procedimiento.Id AS Id, g_procedimiento.Nbre, g_procedimiento.Id_TipoFinProced AS CodFinal,  f_procedimcentrocosto.Id_CentroCosto AS codCC, f_tiposervicio.Id AS IdServicio, f_tiposervicio.Nbre AS nbreServicio,  f_tarifaprocedimiento.Id_TipoPlan AS tipoPlan,  IF(0=0,f_tarifaprocedimiento.VrMinimo, f_tarifaprocedimiento.VrMaximo) AS Valor, f_empresacontxconvenio.Id AS IdEmpresa, 690 AS  Id_Especial, g_procedimiento.EsCita, TRUE AS Fijo, so_seg_procedimiento.`Observacion` , g_procedimiento.`EsRemitido`  , so_seg_procedimiento.`IPeriodo` , `g_procedimiento`.`Es_Prioritario` FROM g_procedimiento  INNER JOIN so_seg_procedimiento ON (g_procedimiento.Id = so_seg_procedimiento.`Id_Procedimiento`)  INNER JOIN f_procedimcentrocosto ON (f_procedimcentrocosto.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)  INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)  INNER JOIN f_tiposervicio ON (f_tiposervtipoproced.Idtiposervicio = f_tiposervicio.Id)  INNER JOIN f_tarifaprocedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN f_empresacontxconvenio ON (f_tarifaprocedimiento.Id_Manual = f_empresacontxconvenio.Id_Manual)   INNER JOIN so_seg_procedimiento_encabezado ON (so_seg_procedimiento.`IdEncabezado`=so_seg_procedimiento_encabezado.`id`) WHERE (so_seg_procedimiento.`Id_TSegmento` ='" + this.xidseg + "' AND so_seg_procedimiento.Estado =1 AND f_empresacontxconvenio.Id ='" + this.xIdEmpresa + "' AND so_seg_procedimiento_encabezado.`Estado`=1)    ORDER BY f_tiposervicio.Nbre ASC, g_procedimiento.Nbre ASC ";
        }
        mCrear_DetalleSeg();
        ResultSet xrs = this.consultas.traerRs(this.sql);
        this.xmt.mEstablecerTextEditor(this.JTBDetalle_Seg, 15);
        int xnfila = 0;
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(xrs.getString("Id"), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString("Nbre"), xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString("codFinal"), xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString("codCC"), xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString("IdServicio"), xnfila, 4);
                    this.xmodelo.setValueAt(xrs.getString("nbreServicio"), xnfila, 5);
                    this.xmodelo.setValueAt("Es_Proc", xnfila, 6);
                    this.xmodelo.setValueAt(xrs.getString("tipoPlan"), xnfila, 7);
                    this.xmodelo.setValueAt(1, xnfila, 8);
                    this.xmodelo.setValueAt(xrs.getString("Valor"), xnfila, 9);
                    this.xmodelo.setValueAt(false, xnfila, 10);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Fijo")), xnfila, 11);
                    this.xmodelo.setValueAt(0, xnfila, 12);
                    this.xmodelo.setValueAt(xrs.getString("Id_Especial"), xnfila, 13);
                    this.xmodelo.setValueAt(xrs.getString("EsCita"), xnfila, 14);
                    this.xmodelo.setValueAt(xrs.getString("Observacion"), xnfila, 15);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("EsRemitido")), xnfila, 16);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("IPeriodo")), xnfila, 18);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Es_prioritario")), xnfila, 21);
                    mCargarDatos_FechaE(xnfila, xrs.getString("Id"), xrs.getInt("IPeriodo"), xrs.getInt("IdServicio"));
                    this.JTBDetalle_Seg.setDefaultRenderer(Object.class, new MiRender1());
                    xnfila++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos_FechaE(int xnfila1, String id_procedimiento, int xperiodo, int xtiposervicio) {
        try {
            if (xtiposervicio == 2) {
                this.sql = "SELECT DATE(`l_recepcion`.`FechaRecep`) AS Fecha, ADDDATE(DATE(`l_recepcion`.`FechaRecep`), INTERVAL " + xperiodo + " DAY) AS NFecha , IF(DATEDIFF(ADDDATE(DATE(`l_recepcion`.`FechaRecep`), INTERVAL " + xperiodo + " DAY), NOW())>0,0,1) AS V  FROM  `l_detallerecepcion` INNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) WHERE (`l_detallerecepcion`.`Id_Procedim` ='" + id_procedimiento + "' AND `l_recepcion`.`Estado` =0 AND `l_recepcion`.`Id_Paciente`='" + this.xidpersona + "') ORDER BY DATE(`l_recepcion`.`FechaRecep`) DESC LIMIT 1 ";
            } else {
                this.sql = "SELECT `f_ordenes`.`FechaOrden`, ADDDATE(`f_ordenes`.`FechaOrden`, INTERVAL " + xperiodo + " DAY) AS NFecha , IF(DATEDIFF(ADDDATE(`f_ordenes`.`FechaOrden`, INTERVAL " + xperiodo + " DAY), NOW())>0,0,1) AS V FROM    `f_itemordenesproced` INNER JOIN `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`f_itemordenesproced`.`Id_Procedimiento` ='" + id_procedimiento + "' AND `ingreso`.`Id_Usuario` ='" + this.xidpersona + "' AND `f_ordenes`.`Estado` =0) ORDER BY `f_ordenes`.`FechaOrden` DESC ";
            }
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs1 = xct.traerRs(this.sql);
            if (xrs1.next()) {
                xrs1.first();
                this.xmodelo.setValueAt(xrs1.getString(1), xnfila1, 17);
                this.xmodelo.setValueAt(xrs1.getString(2), xnfila1, 19);
                this.xmodelo.setValueAt(Boolean.valueOf(xrs1.getBoolean(3)), xnfila1, 20);
            } else {
                this.xmodelo.setValueAt("NO TIENE", xnfila1, 17);
                this.xmodelo.setValueAt("NO TIENE", xnfila1, 19);
                this.xmodelo.setValueAt(true, xnfila1, 20);
            }
            xrs1.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Paquetes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Facturacion/Paquetes$MiRender1.class */
    public class MiRender1 extends DefaultTableCellRenderer {
        public MiRender1() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!Boolean.valueOf(Paquetes.this.JTBDetalle_Seg.getValueAt(row, 20).toString()).booleanValue()) {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mTraerTLaboral() {
        try {
            this.sql = "SELECT IF(`FechaIngreso` IS NULL, '', `CalculaTiempo_AMD`(`FechaIngreso`)) AS Fecha , `Calcula_Edad`( g_persona.`FechaNac`) AS Edad FROM `g_usuario` INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  WHERE (`Id_persona` ='" + this.xidpersona + "')  ";
            ResultSet xrs = this.consultas.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                this.JLBTLaboral.setText(xrs.getString(1));
                this.xedad = xrs.getDouble(2);
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Paquetes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
