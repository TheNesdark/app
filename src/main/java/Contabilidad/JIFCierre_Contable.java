package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFCierre_Contable.class */
public class JIFCierre_Contable extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xsql;
    private String[][] xid;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xidtipodoc;
    private String[] xidempresa;
    private String[] xidauxiliar;
    private JComboBox JCBPeriodo;
    private JComboBox JCBPucAuxiliar;
    private JComboBox JCBTDocumento;
    private JComboBox JCBTercero;
    private JCheckBox JCHActivo;
    private JDateChooser JDFFechaC;
    private JPanel JPIDetalle;
    private JScrollPane JSPConceptC;
    private JScrollPane JSPDetalle;
    private JTextPane JTAConceptoC;
    private JTable JTDetalle;
    private JTextField JTFCuenta;
    private JYearChooser JYCAno;
    private JCheckBox jCheckBox1;
    private JPanel jPanel1;

    public JIFCierre_Contable() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JYCAno = new JYearChooser();
        this.JCBPeriodo = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JTFCuenta = new JTextField();
        this.JPIDetalle = new JPanel();
        this.JCBTDocumento = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JCBPucAuxiliar = new JComboBox();
        this.JSPConceptC = new JScrollPane();
        this.JTAConceptoC = new JTextPane();
        this.JDFFechaC = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jCheckBox1 = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CIERRE CONTABLE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifcierrecontable");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFCierre_Contable.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCierre_Contable.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCierre_Contable.2
            public void actionPerformed(ActionEvent evt) {
                JIFCierre_Contable.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JTFCuenta.setFont(new Font("Arial", 1, 12));
        this.JTFCuenta.setHorizontalAlignment(4);
        this.JTFCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Puc", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 95, -2).addGap(10, 10, 10).addComponent(this.JCBPeriodo, -2, 300, -2).addGap(18, 18, 18).addComponent(this.JCHActivo).addGap(18, 18, 18).addComponent(this.JTFCuenta, -1, 139, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JYCAno, -2, 50, -2).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo, -2, 50, -2).addComponent(this.JCHActivo).addComponent(this.JTFCuenta, -2, 50, -2)).addGap(0, 0, 32767)))));
        this.JPIDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA MOVIMIENTO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JCBTDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPucAuxiliar.setFont(new Font("Arial", 1, 12));
        this.JCBPucAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPConceptC.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPConceptC.setViewportView(this.JTAConceptoC);
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JCBPucAuxiliar, -2, 433, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPConceptC)).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBTDocumento, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTercero, -2, 409, -2))).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTercero, -2, 50, -2).addComponent(this.JCBTDocumento, -2, 50, -2)).addComponent(this.JDFFechaC, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JCBPucAuxiliar).addGap(27, 27, 27)).addGroup(JPIDetalleLayout.createSequentialGroup().addComponent(this.JSPConceptC, -2, 67, -2).addContainerGap()))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jCheckBox1.setFont(new Font("Arial", 1, 10));
        this.jCheckBox1.setText("C,G e I");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIDetalle, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(28, 28, 28).addComponent(this.jCheckBox1).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.jCheckBox1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 376, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDetalle, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mCargarCombo();
    }

    public void mBuscar() {
        mCrearVistaMovimientoTercero();
        mCargarDatos();
        mEliminarFilasCero();
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCBTDocumento.removeAllItems();
        this.JCBTercero.removeAllItems();
        this.JCBPucAuxiliar.removeAllItems();
        this.xidtipodoc = this.xct.llenarCombo("SELECT Id, Nbre, NReporte FROM cc_tipo_documentoc WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipodoc, this.JCBTDocumento);
        this.JCBTDocumento.setSelectedIndex(-1);
        this.xidempresa = this.xct.llenarCombo("SELECT `Id`, `RazonSocialCompleta` FROM  `cc_terceros` WHERE (`RazonSocialCompleta` <>'') ORDER BY `RazonSocialCompleta` ASC", this.xidempresa, this.JCBTercero);
        this.JCBTercero.setSelectedIndex(-1);
        this.xidauxiliar = this.xct.llenarCombo("SELECT `Id`  , CONCAT(`Id`,' - ',`Nbre`) AS Puc FROM `cc_puc` WHERE (`Id_Nivel` =5) ORDER BY `Id`", this.xidauxiliar, this.JCBPucAuxiliar);
        this.JCBPucAuxiliar.setSelectedIndex(-1);
        this.JTFCuenta.setText("");
        this.xct.cerrarConexionBd();
        mCrearModeloDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "Puc", "NPuc", "Debito", "Credito", "Aplica"}) { // from class: Contabilidad.JIFCierre_Contable.3
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(5);
    }

    private void mCargarDatos() {
        this.xsql = "SELECT  `cc_tmp_balance_tercero`.`Id_Tercero`, `cc_terceros`.`RazonSocialCompleta`, `cc_puc`.`Id`, `cc_puc`.`Nbre`,IF(cc_puc.`CEspecialC`=0,IF(SUM(`cc_tmp_balance_tercero`.`SActual`)>0,SUM(`cc_tmp_balance_tercero`.`SActual`),0),0) AS `Debito`, IF(cc_puc.`CEspecialC`=0,IF(SUM(`cc_tmp_balance_tercero`.`SActual`)<0,ABS(SUM(`cc_tmp_balance_tercero`.`SActual`)),0),ABS(SUM(`cc_tmp_balance_tercero`.`SActual`)))  AS `Credito` , cc_puc.`CEspecialC`\nFROM   `cc_terceros` INNER JOIN  `cc_tmp_balance_tercero`  ON (`cc_terceros`.`Id` = `cc_tmp_balance_tercero`.`Id_Tercero`) \nINNER JOIN  `cc_puc`  ON (`cc_puc`.`Id` = `cc_tmp_balance_tercero`.`Id_Puc`) WHERE (`cc_puc`.`Id` LIKE '" + this.JTFCuenta.getText() + "%') GROUP BY `cc_tmp_balance_tercero`.`Id_Tercero`, `cc_puc`.`Id` ";
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    if (this.jCheckBox1.isSelected()) {
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 4);
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 5);
                    } else {
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    }
                    this.xmodelo.setValueAt(true, x, 6);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarCombo() {
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "' AND Activo=1 ORDER BY Id DESC; ";
        } else {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "'  ORDER BY Id DESC; ";
        }
        this.xid = this.xct.llenarComboyLista(this.xsql, this.xid, this.JCBPeriodo, 6);
        this.xct.cerrarConexionBd();
    }

    private void mCrearVistaMovimientoTercero() {
        this.xct.ejecutarSQL("delete from cc_tmp_balance_tercero");
        this.xct.cerrarConexionBd();
        String sqle = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SaldoAnterior`, IdDoc, Comentario) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total, `cc_documentoc`.`Id`, `cc_detalle_documentoc`.Concepto   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "'  AND `cc_documentoc`.`Estado` =1  ) GROUP BY `Puc`, `cc_terceros`.`Id`, `cc_documentoc`.`Id` ";
        System.out.println(" ANterior : " + sqle);
        this.xct.ejecutarSQL(sqle);
        this.xct.cerrarConexionBd();
        String sqle2 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `VDebito`, `VCredito`, IdDoc, Comentario) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`, `cc_documentoc`.`Id`, `cc_detalle_documentoc`.Concepto   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "'  AND `cc_documentoc`.`Estado` =1  ) GROUP BY `Puc`, `cc_terceros`.`Id`, `cc_documentoc`.`Id` ";
        System.out.println(" MOvimiento : " + sqle2);
        this.xct.ejecutarSQL(sqle2);
        this.xct.cerrarConexionBd();
        String sqle3 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SActual`, IdDoc, Comentario) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total , `cc_documentoc`.`Id`, `cc_detalle_documentoc`.Concepto  FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "'  AND `cc_documentoc`.`Estado` =1  ) GROUP BY `Puc`, `cc_terceros`.`Id`, `cc_documentoc`.`Id` ";
        System.out.println(" Actual : " + sqle3);
        this.xct.ejecutarSQL(sqle3);
        this.xct.cerrarConexionBd();
        this.xsql = "SELECT `cc_puc_clasep`.`Id` AS `IdClase`, `cc_puc_clasep`.`Nbre` AS `NClase`, `cc_puc_clasep`.`SaldoAnterior` AS `CSaldoAnterior`, `cc_puc_clasep`.`VDebito` AS `CDebito`, `cc_puc_clasep`.`VCredito` AS `CCredito`, `cc_puc_clasep`.`SaldoActual` AS `CSaldoActual`, `cc_puc_grupo`.`Id` AS `IdGrupo` , `cc_puc_grupo`.`Nbre` AS `NGrupo`, `cc_puc_grupop`.`SaldoAnterior` AS `GSaldoAnterior`, `cc_puc_grupop`.`VDebito` AS `GDebito`, `cc_puc_grupop`.`VCredito` AS `GCredito`, `cc_puc_grupop`.`SaldoActual` AS `GSaldoActual`, `cc_puc_cuenta`.`Id` AS `IdCuenta`, `cc_puc_cuenta`.`Nbre` AS `NCuenta`, `cc_puc_cuentap`.`SaldoAnterior` AS `CCSaldoAnterior` , `cc_puc_cuentap`.`VDebito` AS `CCDebito`, `cc_puc_cuentap`.`VCredito` AS `CCCredito`, `cc_puc_cuentap`.`SaldoActual` AS `CCSaldoActual`, `cc_puc_subcuenta`.`Id` AS `IdSubcuenta`, `cc_puc_subcuenta`.`Nbre` AS `NSubCuenta`, `cc_puc_subcuentap`.`SaldoAnterior` AS `SSaldoAnterior`, `cc_puc_subcuentap`.`VDebito` AS `SDebito`, `cc_puc_subcuentap`.`VCredito` AS `SCredito` , `cc_puc_subcuentap`.`SaldoActual` AS `SSaldoActual`, `cc_puc_auxiliar`.`Id` AS `IdAuxiliar`, `cc_puc_auxiliar`.`Nbre` AS `NAuxiliar`, `cc_puc`.`SaldoAnterior` AS `ASaldoAnterior`, `cc_puc`.`VDebito` AS `ADebito`, `cc_puc`.`VCredito` AS `ACredito`, `cc_puc`.`SaldoActual` AS `ASandoActual`, `cc_puc`.`Id_Tercero`, IF(`cc_puc`.`Id_Tercero`=0,NULL,`cc_terceros`.`Id`) AS Id , IF(`cc_puc`.`Id_Tercero`=0,NULL, `cc_terceros`.`TDCompleto1`)AS TDCompleto, IF(`cc_puc`.`Id_Tercero`=0,NULL, `cc_terceros`.`RazonSocialCompleta`) AS RazonSocialCompleta, IF(`cc_puc`.`Id_Tercero`=0,NULL,`cc_tmp_balance_tercero`.`Id_Puc`) AS Id_Puc, IF(`cc_puc`.`Id_Tercero`=0,NULL,SUM(`cc_tmp_balance_tercero`.`SaldoAnterior`)) AS SDAnterior, IF(`cc_puc`.`Id_Tercero`=0,NULL,SUM(`cc_tmp_balance_tercero`.`VDebito`)) AS SDDebito , IF(`cc_puc`.`Id_Tercero`=0,NULL, SUM(`cc_tmp_balance_tercero`.`VCredito`)) AS SDCredito, IF(`cc_puc`.`Id_Tercero`=0,NULL, SUM(`cc_tmp_balance_tercero`.`SActual`)) AS SDSaldoA FROM  `cc_terceros`INNER JOIN `cc_tmp_balance_tercero` ON (`cc_terceros`.`Id` = `cc_tmp_balance_tercero`.`Id_Tercero`) INNER JOIN `cc_puc_auxiliar` ON (`cc_puc_auxiliar`.`Id` = `cc_tmp_balance_tercero`.`Id_Puc`) INNER JOIN `cc_puc` ON (`cc_puc`.`Id` = `cc_puc_auxiliar`.`Id`) INNER JOIN `cc_puc_subcuenta` ON (`cc_puc_subcuenta`.`Id` = `cc_puc_auxiliar`.`Id_subcuenta`) INNER JOIN `cc_puc` AS `cc_puc_subcuentap` ON (`cc_puc_subcuentap`.`Id` = `cc_puc_subcuenta`.`Id`) INNER JOIN `cc_puc_cuenta` ON (`cc_puc_cuenta`.`Id` = `cc_puc_subcuenta`.`Id_cuenta`) INNER JOIN `cc_puc` AS `cc_puc_cuentap` ON (`cc_puc_cuentap`.`Id` = `cc_puc_cuenta`.`Id`) INNER JOIN `cc_puc_grupo` ON (`cc_puc_cuenta`.`Id_Grupo` = `cc_puc_grupo`.`Id`) INNER JOIN `cc_puc` AS `cc_puc_grupop` ON (`cc_puc_grupop`.`Id` = `cc_puc_grupo`.`Id`) INNER JOIN `cc_puc_clase` ON (`cc_puc_grupo`.`Id_clase` = `cc_puc_clase`.`Id`) INNER JOIN `cc_puc` AS `cc_puc_clasep` ON (`cc_puc_clasep`.`Id` = `cc_puc_clase`.`Id`) GROUP BY `cc_terceros`.`Id`, `cc_tmp_balance_tercero`.`Id_Puc` ORDER BY `cc_tmp_balance_tercero`.`Id_Puc` ASC, `cc_terceros`.`RazonSocialCompleta` ASC ";
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos1");
        this.xct.cerrarConexionBd();
        String sqlw = "CREATE VIEW cc_v_tmp_datos1 AS " + this.xsql;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
    }

    public void mGrabar() {
        if (Principal.xclase.getXidperiodoc() != -1) {
            if (Principal.xclase.isXestadop()) {
                if (Principal.xclase.mValidarFechasDoc(this.JDFFechaC.getDate())) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        if (this.JCBTDocumento.getSelectedIndex() != -1) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC,  Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTDocumento.getSelectedIndex()] + "','" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "','" + this.JTAConceptoC.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                                Principal.txtEstado.setText("ACTIVO");
                                this.xct.cerrarConexionBd();
                                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                                    ConsultasMySQL xct1 = new ConsultasMySQL();
                                    if (Boolean.valueOf(this.xmodelo.getValueAt(y, 6).toString()).booleanValue()) {
                                        if (Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue() != 0.0d) {
                                            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 2) + "','0','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 4) + "','0','" + this.JTAConceptoC.getText() + "' )";
                                            xct1.ejecutarSQL(this.xsql);
                                            xct1.cerrarConexionBd();
                                            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xidauxiliar[this.JCBPucAuxiliar.getSelectedIndex()] + "','1','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','0','" + this.xmodelo.getValueAt(y, 4) + "','" + this.JTAConceptoC.getText() + "' )";
                                            xct1.ejecutarSQL(this.xsql);
                                            xct1.cerrarConexionBd();
                                        } else {
                                            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 2) + "','1','" + this.xmodelo.getValueAt(y, 0) + "','0','" + this.xmodelo.getValueAt(y, 5) + "','" + this.JTAConceptoC.getText() + "' )";
                                            xct1.ejecutarSQL(this.xsql);
                                            xct1.cerrarConexionBd();
                                            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xidauxiliar[this.JCBPucAuxiliar.getSelectedIndex()] + "','0','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(y, 5) + "','0','" + this.JTAConceptoC.getText() + "' )";
                                            xct1.ejecutarSQL(this.xsql);
                                            xct1.cerrarConexionBd();
                                        }
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTDocumento.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JDFFechaC.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Perido cerrado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Existen mas de un periodo abierto, \nFavor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void mEliminarFilasCero() {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue() == 0.0d && Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()).doubleValue() == 0.0d) {
                this.xmodelo.removeRow(x);
            }
        }
    }
}
