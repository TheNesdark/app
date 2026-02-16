package com.genoma.plus.dao.impl.sig;

import com.genoma.plus.dao.sig.ReporteExamenOcupacionalDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/ReporteExamenOcupacionalDAOImpl.class */
public class ReporteExamenOcupacionalDAOImpl implements ReporteExamenOcupacionalDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.ReporteExamenOcupacionalDAO
    public List<Object[]> ListadoExamenOcupacional(String xFechaI, String xFechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ReporteExamenOcupacionalDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[120];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                fila[8] = rs.getString(9);
                fila[9] = rs.getString(10);
                return fila;
            }
        };
        String xSql = "SELECT\n\th_so_concepto_laboral.`Id` AS IdConcepto,\n    `ingreso`.`FechaIngreso`\n    , CONCAT(`g_persona`.`Id_TipoIdentificacion` ,' ', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`\n    , `so_tipo_concepto`.`Nbre` AS `TipoExamen`\n    , `c_clasecita`.`Nbre` AS `TipoExamen`\n    , `h_tipohistoria`.`Reporte`, IF(so_tipo_concepto.`Tipo`=0, 'INGRESO', IF(so_tipo_concepto.`Tipo`=0, 'PERIODICO','OTROS' )) Tipo\nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n         INNER JOIN  `h_so_concepto_laboral` \n        ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `so_tipo_concepto` \n        ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`)\nWHERE (`ingreso`.`FechaIngreso` >='" + xFechaI + "'\n    AND `ingreso`.`FechaIngreso` <='" + xFechaF + "')\nORDER BY `ingreso`.`FechaIngreso` ASC, `NUsuario` ASC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ReporteExamenOcupacionalDAO
    public List<Object[]> ListadoExamenOcupacionalFiltrado(String datoFiltro) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ReporteExamenOcupacionalDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[120];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                fila[8] = rs.getString(9);
                fila[9] = rs.getString(10);
                return fila;
            }
        };
        String xSql = "SELECT\n\th_so_concepto_laboral.`Id` AS IdConcepto,\n    `ingreso`.`FechaIngreso`\n    , CONCAT(`g_persona`.`Id_TipoIdentificacion` ,' ', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa`\n    , `so_tipo_concepto`.`Nbre` AS `TipoExamen`\n    , `c_clasecita`.`Nbre` AS `TipoExamen`\n    , `h_tipohistoria`.`Reporte`, IF(so_tipo_concepto.`Tipo`=0, 'INGRESO', IF(so_tipo_concepto.`Tipo`=0, 'PERIODICO','OTROS' )) Tipo\nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `h_tipohistoria` \n        ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n         INNER JOIN  `h_so_concepto_laboral` \n        ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `so_tipo_concepto` \n        ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`)\nhaving(  Documento  like'%" + datoFiltro + "%'\n    OR NUsuario like'%" + datoFiltro + "%')\nORDER BY `ingreso`.`FechaIngreso` ASC, `NUsuario` ASC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
