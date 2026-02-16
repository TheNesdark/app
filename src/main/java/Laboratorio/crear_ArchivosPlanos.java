package Laboratorio;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/crear_ArchivosPlanos.class */
public class crear_ArchivosPlanos {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xsql;

    public void mCrear_Planos(String xruta, String xnarchivo, String xtipo) {
        try {
            String sFichero = xruta + xnarchivo + ".astm";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            String xparte1 = "H|\\^&|||GENOMA|||||||INFINITY||P||" + this.xmt.formatoDMAH24_Unida.format(this.xmt.getFechaActual());
            bw.write(xparte1);
            bw.newLine();
            int x = 0;
            this.xsql = "SELECT  CONCAT('P|1|' , `l_recepcion`.`Id`,'|' , CONCAT(`g_persona`.`Id_TipoIdentificacion`,'^',`g_persona`.`NoDocumento`),'||' ,  CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`  ,'^', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`),'||' , DATE_FORMAT(`g_persona`.`FechaNac`,'%Y%m%d') ,'|' , `g_persona`.`Id_Sexo`,'||' , CONCAT(  `f_empresacontxconvenio`.`Id`,'^',`f_empresacontxconvenio`.`Nbre`),'|' , `g_empresa_1`.`Correo` ,'|' , CONCAT(cc_terceros.`Id`,'^', cc_terceros.RazonSocialCompleta) ,'||' ,'" + xtipo + "','|', IF(l_recepcion_citologia.`Id_Consecutivo` IS NULL, '', CONCAT(MID(l_recepcion_citologia.`Ano`,3,2),'-',l_recepcion_citologia.`Id_Consecutivo`)) ,'|',IF(l_recepcion_citologia.`Id_Consecutivo` IS NULL, '',  DATE_FORMAT(l_recepcion.Fecha_Toma,'%d/%m/%Y') ),'||' ,if(`g_persona`.`Telefono`='', `g_persona`.`Movil`,`g_persona`.`Telefono` ),'|' , `g_persona`.`Correo`,'||||' , DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y%m%d%H%i%s') ,'||||||||||')  FROM `g_persona`  INNER JOIN   `l_recepcion`  ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`) INNER JOIN   `l_detallerecepcion`   ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN   `f_empresacontxconvenio`   ON (`f_empresacontxconvenio`.`Id` = `l_recepcion`.`Id_EmpresaConv`) INNER JOIN   `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN   `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN   cc_terceros  ON (`g_usuario`.`Id_EmpresaCont` = cc_terceros.`Id`) INNER JOIN   cc_terceros AS `g_empresa_1` ON (`g_empresacont`.`Id_empresa` = `g_empresa_1`.`Id`) LEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)WHERE (`l_recepcion`.`Id` ='" + xnarchivo + "') GROUP BY `l_recepcion`.`Id` ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
            }
            this.xsql = "SELECT  CONCAT('O','|' , '1','|' , `l_recepcion`.`Id`,'|' , `g_procedimiento`.`Id`,'|' , 'R','|' , DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y%m%d%H%m%s'),'|||||' , 'A','|||||||||||||||' ) FROM `l_detallerecepcion` INNER JOIN    `l_recepcion` ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)  INNER JOIN    `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) WHERE (`l_recepcion`.`Id` ='" + xnarchivo + "') ";
            ResultSet xrs1 = this.xct.traerRs(this.xsql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                while (xrs1.next()) {
                    bw.write(xrs1.getString(1));
                    bw.newLine();
                    x++;
                }
            }
            xrs.close();
            xrs1.close();
            this.xct.cerrarConexionBd();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(crear_ArchivosPlanos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(crear_ArchivosPlanos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }
}
