package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JDMovimiento_Inventario.class */
public class JDMovimiento_Inventario extends JDialog {
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Object[] xdatos;
    private String[] xid_movimiento;
    private String xsql;
    public int filaGrid;
    private JComboBox JCBMovimiento;
    private JPanel JPIEncabezado;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;

    public JDMovimiento_Inventario(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.filaGrid = 0;
        initComponents();
        mNuevo();
        mCargaSuministros();
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIEncabezado = new JPanel();
        this.JCBMovimiento = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.JPIEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBMovimiento.setFont(new Font("Arial", 1, 12));
        this.JCBMovimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIEncabezadoLayout = new GroupLayout(this.JPIEncabezado);
        this.JPIEncabezado.setLayout(JPIEncabezadoLayout);
        JPIEncabezadoLayout.setHorizontalGroup(JPIEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncabezadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBMovimiento, -2, 260, -2).addContainerGap(596, 32767)));
        JPIEncabezadoLayout.setVerticalGroup(JPIEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEncabezadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBMovimiento, -2, 50, -2).addContainerGap(22, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIEncabezado, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JSPDetalle, -1, 879, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIEncabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 247, -2).addContainerGap(111, 32767)));
        pack();
    }

    private void mNuevo() {
        this.xsql = "SELECT `Id`, `Nbre` FROM `i_tiposmovimientos` WHERE (`TipoMovimiento` =1 AND `Despacho` =1 AND `Estado` =0 AND `Bodega` =2) ORDER BY `Nbre` ASC ";
        this.xid_movimiento = this.xct.llenarCombo(this.xsql, this.xid_movimiento, this.JCBMovimiento);
        this.JCBMovimiento.setSelectedIndex(1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdSum", "Cod. Barra", "Nombre", "Lote", "FechaV", "Cantidad", "CantidadS", "Cantidad Entregada", "Valor Unitario", "Valor Total", "Cant.Unidad", "IdSumxLotxBod", "CPendiente"}) { // from class: Facturacion.JDMovimiento_Inventario.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Double.class, Double.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(30);
    }

    private void mCargaSuministros() {
        mCrearModelo();
        String sql = "SELECT  `ingreso`.`Id_Especialidad` , `ingreso`.`Id_Profesional`  , `f_itemordenessum`.`Id_Suministro`  , `i_suministro`.`Nbre`,'',''  , `f_itemordenessum`.`Cantidad` , `f_itemordenessum`.`ValorUnit`,''  FROM `f_itemordenessum`  INNER JOIN `baseserver`.`f_ordenes`  ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)  INNER JOIN `baseserver`.`ingreso`   ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `baseserver`.`i_suministro`   ON (`f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)  WHERE (`ingreso`.`Id` ='" + Principal.txtNo.getText() + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                this.filaGrid = 0;
                while (xrs.next()) {
                    long xcantidad = xrs.getLong(5);
                    ConsultasMySQL xct2 = new ConsultasMySQL();
                    this.xsql = "  SELECT `i_suministroxbodega`.`IdSuministro`, `i_suministro`.`CodBarraUnidad`, CONCAT(`i_suministro`.`Nbre`,' ',`i_presentacionfarmaceutica`.`Nbre`,' ', `i_laboratorio`.`Nbre`) AS `NProducto` , `i_suministroxlotexbodega`.`Lote` , `i_suministroxlotexbodega`.`FechaVencimiento` , `i_suministroxlotexbodega`.`Cantidad` , " + xcantidad + " AS `CSolicitada` , IF(" + xcantidad + "<=`i_suministroxlotexbodega`.`Cantidad`, " + xcantidad + ", `i_suministroxlotexbodega`.`Cantidad`) AS `CEntregada` , `i_suministroxbodega`.`Costo` AS `VUnitario` ,  round((`i_suministroxbodega`.`Costo`*IF(" + xcantidad + "<=`i_suministroxlotexbodega`.`Cantidad`, " + xcantidad + ", `i_suministroxlotexbodega`.`Cantidad`))) AS `VTotal` ,  `i_suministro`.`CantidadUnidad` ,  `i_suministroxlotexbodega`.`Id` AS SB, 0 AS `CPendiente` FROM  `i_suministroxbodega` INNER JOIN `i_suministro`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) INNER JOIN `i_laboratorio`  ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) WHERE (`i_suministroxbodega`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "' AND `i_suministroxbodega`.`IdSuministro` ='" + xrs.getLong(3) + "' AND `i_suministroxlotexbodega`.`Cantidad` <>0) ORDER BY `i_suministroxlotexbodega`.`FechaVencimiento` asc ";
                    ResultSet xrs1 = xct2.traerRs(this.xsql);
                    if (xrs1.next()) {
                        xrs1.beforeFirst();
                        while (xrs1.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(Long.valueOf(xrs1.getLong(1)), this.filaGrid, 0);
                            this.xmodelo.setValueAt(xrs1.getString(2), this.filaGrid, 1);
                            this.xmodelo.setValueAt(xrs1.getString(3), this.filaGrid, 2);
                            this.xmodelo.setValueAt(xrs1.getString(4), this.filaGrid, 3);
                            this.xmodelo.setValueAt(xrs1.getString(5), this.filaGrid, 4);
                            this.xmodelo.setValueAt(Long.valueOf(xrs1.getLong(6)), this.filaGrid, 5);
                            this.xmodelo.setValueAt(Long.valueOf(xcantidad), this.filaGrid, 6);
                            if (xrs1.getLong(6) >= xcantidad) {
                                this.xmodelo.setValueAt(Long.valueOf(xcantidad), this.filaGrid, 7);
                            } else {
                                this.xmodelo.setValueAt(Long.valueOf(xrs1.getLong(6)), this.filaGrid, 7);
                            }
                            this.xmodelo.setValueAt(Double.valueOf(xrs1.getDouble(9)), this.filaGrid, 8);
                            this.xmodelo.setValueAt(Double.valueOf(xrs1.getDouble(9) * Double.valueOf(this.xmodelo.getValueAt(this.filaGrid, 7).toString()).doubleValue()), this.filaGrid, 9);
                            this.xmodelo.setValueAt(Long.valueOf(xrs1.getLong(11)), this.filaGrid, 10);
                            this.xmodelo.setValueAt(Long.valueOf(xrs1.getLong(12)), this.filaGrid, 11);
                            this.xmodelo.setValueAt(Long.valueOf(xrs1.getLong(13)), this.filaGrid, 12);
                            this.filaGrid++;
                            if (xrs1.getLong(8) == xcantidad) {
                                break;
                            } else {
                                xcantidad -= xrs1.getLong(8);
                            }
                        }
                    }
                    xrs1.close();
                    xct2.cerrarConexionBd();
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDMovimiento_Inventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
