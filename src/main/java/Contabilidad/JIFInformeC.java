package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFInformeC.class */
public class JIFInformeC extends JInternalFrame {
    private String xnombre;
    private String xsql;
    private String[][] xid;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JComboBox JCBPeriodo;
    private JCheckBox JCHActivo;
    private JCheckBox JCHDetalle;
    private JCheckBox JCHFiltro;
    private JPanel JPIDatos;
    private JPanel JPIDatosC;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFBusqueda;
    private JYearChooser JYCAno;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xcodigopro = "";

    public JIFInformeC(String xnombre) {
        initComponents();
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JYCAno = new JYearChooser();
        this.JCBPeriodo = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JPIDatosC = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFBusqueda = new JTextField();
        this.JCHFiltro = new JCheckBox();
        this.JCHDetalle = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformescontables");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFInformeC.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeC.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFInformeC.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformeC.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "AUXILIAR", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Puc", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFBusqueda.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFInformeC.3
            public void keyPressed(KeyEvent evt) {
                JIFInformeC.this.JTFBusquedaKeyPressed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 13));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Filtro");
        this.JCHDetalle.setFont(new Font("Arial", 1, 13));
        this.JCHDetalle.setText("Detalle");
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JTFBusqueda, -2, 266, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro, -1, -1, 32767).addGap(48, 48, 48).addComponent(this.JCHDetalle, -1, -1, 32767).addGap(21, 21, 21))).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addGap(26, 26, 26).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFBusqueda, -2, 40, -2).addComponent(this.JCHFiltro).addComponent(this.JCHDetalle)).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 183, 32767).addContainerGap()));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 95, -2).addGap(10, 10, 10).addComponent(this.JCBPeriodo, -2, 300, -2).addGap(18, 18, 18).addComponent(this.JCHActivo, -1, 78, 32767).addContainerGap()).addComponent(this.JPIDatosC, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo, -2, -1, -2).addComponent(this.JCHActivo))).addComponent(this.JYCAno, GroupLayout.Alignment.TRAILING, -2, 44, -2)).addGap(18, 18, 18).addComponent(this.JPIDatosC, -1, -1, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(14, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBusquedaKeyPressed(KeyEvent evt) {
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Auxiliar", "Consultar?"}) { // from class: Contabilidad.JIFInformeC.4
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
    }

    private void mCargarDatos() {
        if (this.JCHFiltro.isSelected()) {
            this.xsql = "SELECT `Id` , `Nbre` FROM `cc_puc` WHERE (`Id_Nivel`=5 and  `Id` like '" + this.JTFBusqueda.getText() + "%')";
        } else {
            this.xsql = "SELECT `Id` , `Nbre` FROM `cc_puc` WHERE (`Id_Nivel` =5)";
        }
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(false, x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mNuevo() {
        this.JTFBusqueda.setText("");
        mCrearModeloDatos();
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

    private void mInicarValoresPuc() {
        this.xsql = "update cc_puc set SaldoAnterior=0, VDebito=0, VCredito=0, SaldoActual=0";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    public void mBuscar() {
        this.xct.ejecutarSQL("delete from cc_tmp_balance_tercero");
        this.xct.cerrarConexionBd();
        mCrearVistaMovimientoTercero();
        mImprimir();
    }

    private void mCrearVistaMovimientoTercero() {
        mCrearVistaMovimiento();
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.JTDetalle.getValueAt(x, 2).toString()).booleanValue()) {
                this.xcodigopro += "," + this.xmodelo.getValueAt(x, 0).toString();
            }
        }
        String sqle = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SaldoAnterior`, IdDoc, Comentario) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total, `cc_documentoc`.`Id`, `cc_detalle_documentoc`.Concepto   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "'  AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` in(" + this.xcodigopro.substring(1, this.xcodigopro.length()) + " )) GROUP BY `Puc`, `cc_terceros`.`Id`, `cc_documentoc`.`Id` ";
        this.xct.ejecutarSQL(sqle);
        this.xct.cerrarConexionBd();
        String sqle2 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `VDebito`, `VCredito`, IdDoc, Comentario) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`, `cc_documentoc`.`Id`, `cc_detalle_documentoc`.Concepto   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "'  AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc`  in(" + this.xcodigopro.substring(1, this.xcodigopro.length()) + " )) GROUP BY `Puc`, `cc_terceros`.`Id`, `cc_documentoc`.`Id` ";
        this.xct.ejecutarSQL(sqle2);
        this.xct.cerrarConexionBd();
        String sqle3 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SActual`, IdDoc, Comentario) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total , `cc_documentoc`.`Id`, `cc_detalle_documentoc`.Concepto  FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "'  AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc`  in(" + this.xcodigopro.substring(1, this.xcodigopro.length()) + " )) GROUP BY `Puc`, `cc_terceros`.`Id`, `cc_documentoc`.`Id` ";
        this.xct.ejecutarSQL(sqle3);
        this.xct.cerrarConexionBd();
        this.xsql = "SELECT `cc_puc_clasep`.`Id` AS `IdClase`, `cc_puc_clasep`.`Nbre` AS `NClase`, `cc_puc_clasep`.`SaldoAnterior` AS `CSaldoAnterior`, `cc_puc_clasep`.`VDebito` AS `CDebito`, `cc_puc_clasep`.`VCredito` AS `CCredito`, `cc_puc_clasep`.`SaldoActual` AS `CSaldoActual`, `cc_puc_grupo`.`Id` AS `IdGrupo` , `cc_puc_grupo`.`Nbre` AS `NGrupo`, `cc_puc_grupop`.`SaldoAnterior` AS `GSaldoAnterior`, `cc_puc_grupop`.`VDebito` AS `GDebito`, `cc_puc_grupop`.`VCredito` AS `GCredito`, `cc_puc_grupop`.`SaldoActual` AS `GSaldoActual`, `cc_puc_cuenta`.`Id` AS `IdCuenta`, `cc_puc_cuenta`.`Nbre` AS `NCuenta`, `cc_puc_cuentap`.`SaldoAnterior` AS `CCSaldoAnterior` , `cc_puc_cuentap`.`VDebito` AS `CCDebito`, `cc_puc_cuentap`.`VCredito` AS `CCCredito`, `cc_puc_cuentap`.`SaldoActual` AS `CCSaldoActual`, `cc_puc_subcuenta`.`Id` AS `IdSubcuenta`, `cc_puc_subcuenta`.`Nbre` AS `NSubCuenta`, `cc_puc_subcuentap`.`SaldoAnterior` AS `SSaldoAnterior`, `cc_puc_subcuentap`.`VDebito` AS `SDebito`, `cc_puc_subcuentap`.`VCredito` AS `SCredito` , `cc_puc_subcuentap`.`SaldoActual` AS `SSaldoActual`, `cc_puc_auxiliar`.`Id` AS `IdAuxiliar`, `cc_puc_auxiliar`.`Nbre` AS `NAuxiliar`, `cc_puc`.`SaldoAnterior` AS `ASaldoAnterior`, `cc_puc`.`VDebito` AS `ADebito`, `cc_puc`.`VCredito` AS `ACredito`, `cc_puc`.`SaldoActual` AS `ASandoActual`, `cc_puc`.`Id_Tercero`, IF(`cc_puc`.`Id_Tercero`=0,NULL,`cc_terceros`.`Id`) AS Id , IF(`cc_puc`.`Id_Tercero`=0,NULL, `cc_terceros`.`TDCompleto1`)AS TDCompleto, IF(`cc_puc`.`Id_Tercero`=0,NULL, `cc_terceros`.`RazonSocialCompleta`) AS RazonSocialCompleta, IF(`cc_puc`.`Id_Tercero`=0,NULL,`cc_tmp_balance_tercero`.`Id_Puc`) AS Id_Puc, IF(`cc_puc`.`Id_Tercero`=0,NULL,SUM(`cc_tmp_balance_tercero`.`SaldoAnterior`)) AS SDAnterior, IF(`cc_puc`.`Id_Tercero`=0,NULL,SUM(`cc_tmp_balance_tercero`.`VDebito`)) AS SDDebito , IF(`cc_puc`.`Id_Tercero`=0,NULL, SUM(`cc_tmp_balance_tercero`.`VCredito`)) AS SDCredito, IF(`cc_puc`.`Id_Tercero`=0,NULL, SUM(`cc_tmp_balance_tercero`.`SActual`)) AS SDSaldoA FROM  `cc_terceros`INNER JOIN `cc_tmp_balance_tercero` ON (`cc_terceros`.`Id` = `cc_tmp_balance_tercero`.`Id_Tercero`) INNER JOIN `cc_puc_auxiliar` ON (`cc_puc_auxiliar`.`Id` = `cc_tmp_balance_tercero`.`Id_Puc`) INNER JOIN `cc_puc` ON (`cc_puc`.`Id` = `cc_puc_auxiliar`.`Id`) INNER JOIN `cc_puc_subcuenta` ON (`cc_puc_subcuenta`.`Id` = `cc_puc_auxiliar`.`Id_subcuenta`) INNER JOIN `cc_puc` AS `cc_puc_subcuentap` ON (`cc_puc_subcuentap`.`Id` = `cc_puc_subcuenta`.`Id`) INNER JOIN `cc_puc_cuenta` ON (`cc_puc_cuenta`.`Id` = `cc_puc_subcuenta`.`Id_cuenta`) INNER JOIN `cc_puc` AS `cc_puc_cuentap` ON (`cc_puc_cuentap`.`Id` = `cc_puc_cuenta`.`Id`) INNER JOIN `cc_puc_grupo` ON (`cc_puc_cuenta`.`Id_Grupo` = `cc_puc_grupo`.`Id`) INNER JOIN `cc_puc` AS `cc_puc_grupop` ON (`cc_puc_grupop`.`Id` = `cc_puc_grupo`.`Id`) INNER JOIN `cc_puc_clase` ON (`cc_puc_grupo`.`Id_clase` = `cc_puc_clase`.`Id`) INNER JOIN `cc_puc` AS `cc_puc_clasep` ON (`cc_puc_clasep`.`Id` = `cc_puc_clase`.`Id`) where `cc_puc_auxiliar`.`Id`  in(" + this.xcodigopro.substring(1, this.xcodigopro.length()) + ")GROUP BY `cc_terceros`.`Id`, `cc_tmp_balance_tercero`.`Id_Puc` ORDER BY `cc_tmp_balance_tercero`.`Id_Puc` ASC, `cc_terceros`.`RazonSocialCompleta` ASC ";
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos1");
        this.xct.cerrarConexionBd();
        String sqlw = "CREATE VIEW cc_v_tmp_datos1 AS " + this.xsql;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
    }

    private void mCrearVistaMovimiento() {
        mInicarValoresPuc();
        for (int x = 1; x < 14; x++) {
            this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos");
            this.xct.cerrarConexionBd();
            this.xsql = "";
            this.xsql = "SELECT MID(cc_detalle_documentoc.`Id_Puc`,1," + x + ") AS `Puc`, SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`, ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total    FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1 ) GROUP BY `Puc`  ";
            String sqlw = "CREATE VIEW cc_v_tmp_datos AS " + this.xsql;
            this.xct.ejecutarSQL(sqlw);
            this.xct.cerrarConexionBd();
            this.xsql = "UPDATE `cc_puc`, `cc_v_tmp_datos` SET cc_puc.`SaldoAnterior`= `cc_v_tmp_datos`.`Total` WHERE `cc_puc`.`Id`=`cc_v_tmp_datos`.`Puc`";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos");
            this.xct.cerrarConexionBd();
            this.xsql = "";
            this.xsql = "SELECT MID(cc_detalle_documentoc.`Id_Puc`,1," + x + ") AS `Puc`, SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`, ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total    FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1 ) GROUP BY `Puc`  ";
            String sqlw2 = "CREATE VIEW cc_v_tmp_datos AS " + this.xsql;
            this.xct.ejecutarSQL(sqlw2);
            this.xct.cerrarConexionBd();
            this.xsql = "UPDATE `cc_puc`, `cc_v_tmp_datos` SET cc_puc.`VDebito`= `cc_v_tmp_datos`.`VDebito`,cc_puc.`VCredito`= `cc_v_tmp_datos`.`VCredito`  WHERE `cc_puc`.`Id`=`cc_v_tmp_datos`.`Puc`";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos  ");
            this.xct.cerrarConexionBd();
            this.xsql = "";
            this.xsql = "SELECT MID(cc_detalle_documentoc.`Id_Puc`,1," + x + ") AS `Puc`, SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`, ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total    FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  WHERE (`cc_documentoc`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1 ) GROUP BY `Puc`  ";
            String sqlw3 = "CREATE VIEW cc_v_tmp_datos AS " + this.xsql;
            this.xct.ejecutarSQL(sqlw3);
            this.xct.cerrarConexionBd();
            this.xsql = "UPDATE `cc_puc`, `cc_v_tmp_datos` SET `cc_puc`.`SaldoActual`= `cc_v_tmp_datos`.`Total` WHERE `cc_puc`.`Id`=`cc_v_tmp_datos`.`Puc`";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    public void mImprimir() {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "periodo";
        parametros[1][1] = this.JCBPeriodo.getSelectedItem().toString();
        parametros[2][0] = "p1";
        parametros[2][1] = this.xcodigopro.substring(1, this.xcodigopro.length());
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.xnombre.equals("Informe Libro Auxiliar")) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_BalancePrueba_Tercero_Auxiliar", parametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_BalancePrueba_Tercero_Auxiliar_1", parametros);
                return;
            }
        }
        if (this.xnombre.equals("Informe Libro Auxiliar Tercero")) {
            if (this.JCHDetalle.isSelected()) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Saldos_Terceros_Auxiliares", parametros);
                    return;
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Saldos_Terceros_Auxiliares_2", parametros);
                    return;
                }
            }
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Saldos_Terceros_Auxiliares_1", parametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Saldos_Terceros_Auxiliares_1_1", parametros);
                return;
            }
        }
        if (this.xnombre.equals("Informe Libro Auxiliar Banco")) {
            if (!this.JCHDetalle.isSelected()) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Auxiliar_Bancos", parametros);
                    return;
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Auxiliar_Bancos_1", parametros);
                    return;
                }
            }
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Auxiliar_Bancos_Detalle", parametros);
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Auxiliar_Bancos_Detalle_1", parametros);
            }
        }
    }
}
