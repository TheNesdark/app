package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFPrueba.class */
public class JIFPrueba extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JButton jButton1;

    public JIFPrueba() {
        initComponents();
    }

    private void initComponents() {
        this.jButton1 = new JButton();
        this.jButton1.setText("jButton1");
        this.jButton1.addActionListener(new ActionListener() { // from class: Inventarios.JIFPrueba.1
            public void actionPerformed(ActionEvent evt) {
                JIFPrueba.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(101, 101, 101).addComponent(this.jButton1).addContainerGap(335, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(177, 32767).addComponent(this.jButton1).addGap(82, 82, 82)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        String sql = "UPDATE `i_suministroxbodega`  SET `i_suministroxbodega`.`CExistencia`=0,  `i_suministroxbodega`.`CEntrada`=0, `i_suministroxbodega`.`CSalida`=0    WHERE `i_suministroxbodega`.`IdBodega`='" + Principal.xClaseInventario.getIdBodega() + "' ";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle = "SELECT `i_detalleentrada`.`IdSuministro` AS `Id`, SUM(`i_detalleentrada`.`Cantidad`) AS `Cantidad` FROM  `i_detalleentrada` INNER JOIN  `i_entradas`  ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`) INNER JOIN  `i_tiposmovimientos`  ON (`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) WHERE (`i_entradas`.`Id_Periodo` >=27 AND `i_entradas`.`Id_Periodo` <='" + Principal.xClaseInventario.getXidperiodoc() + "' AND `i_entradas`.`Estado` =0 AND `i_entradas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "') GROUP BY `Id` HAVING (`Cantidad` <>0) ORDER BY `Id` ASC";
        String sqlw = "CREATE VIEW i_tmp_datos AS " + sqle;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
        String sql2 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`CEntrada`=i_tmp_datos.Cantidad WHERE i_tmp_datos.Id=i_suministroxbodega.`IdSuministro` AND i_suministroxbodega.`IdBodega`='" + Principal.xClaseInventario.getIdBodega() + "'";
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle2 = "SELECT `i_detallesalida`.`IdSuministro` AS `Id` , SUM(`i_detallesalida`.`CantidadDespachada`) AS `Cantidad` FROM  `i_detallesalida` INNER JOIN  `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN `i_tiposmovimientos`  ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) WHERE (`i_salidas`.`Id_Periodo` >=27 AND `i_salidas`.`Id_Periodo` <='" + Principal.xClaseInventario.getXidperiodoc() + "' AND `i_salidas`.`Estado` =0 AND `i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "') GROUP BY `Id` HAVING (`Cantidad` <>0) ORDER BY `Id` ASC ";
        String sqlw2 = "CREATE VIEW i_tmp_datos AS " + sqle2;
        this.xct.ejecutarSQL(sqlw2);
        this.xct.cerrarConexionBd();
        String sql3 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`CSalida`=i_tmp_datos.Cantidad WHERE i_tmp_datos.Id=i_suministroxbodega.`IdSuministro` AND i_suministroxbodega.`IdBodega`='" + Principal.xClaseInventario.getIdBodega() + "'";
        this.xct.ejecutarSQL(sql3);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle3 = "SELECT `i_suministroxbodega`.`IdSuministro` AS `Id`, SUM(`i_suministroxlotexbodega`.`Cantidad`) AS `Cantidad` FROM `i_suministroxlotexbodega` INNER JOIN  `i_suministroxbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) WHERE (`i_suministroxbodega`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "') GROUP BY `Id` HAVING (`Cantidad` <>0) ORDER BY `Id` ASC ";
        String sqlw3 = "CREATE VIEW i_tmp_datos AS " + sqle3;
        this.xct.ejecutarSQL(sqlw3);
        this.xct.cerrarConexionBd();
        String sql4 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`CExistencia`=i_tmp_datos.Cantidad WHERE i_tmp_datos.Id=i_suministroxbodega.`IdSuministro` AND i_suministroxbodega.`IdBodega`='" + Principal.xClaseInventario.getIdBodega() + "'";
        this.xct.ejecutarSQL(sql4);
        this.xct.cerrarConexionBd();
    }
}
