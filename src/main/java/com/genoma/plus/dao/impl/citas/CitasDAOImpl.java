package com.genoma.plus.dao.impl.citas;

import com.genoma.plus.dao.citas.CitasDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/citas/CitasDAOImpl.class */
public class CitasDAOImpl implements CitasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.citas.CitasDAO
    public List<Object[]> consultarIngreso(int xFiltro, String xIdUsuario, String xAnno, String xIdEspecialidad) {
        String xSql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.citas.CitasDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString("nClaseCita")};
                return fila;
            }
        };
        if (xFiltro == 0) {
            xSql = "SELECT\n    `ingreso`.`Id`\n    , `ingreso`.`FechaIngreso`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1` ,' ',`g_persona`.`Nombre2`) AS `NProfesional`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresConvenio`\n    , `ingreso`.`Id_Usuario`, c_clasecita.`Nbre` nClaseCita\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n INNER JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n    INNER JOIN  `g_profesional` \n        ON (`g_profesional`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad` \n        ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_profesional`.`Id_Persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`ingreso`.`Id_Usuario` ='" + xIdUsuario + "' AND c_clasecita.`EsP`=1 and h_atencion.TipoGuardado=2  and h_atencion.Codigo_Dxp<>'' AND ingreso.`Estado`=0 and `g_especialidad`.`Id`='" + xIdEspecialidad + "')\nORDER BY `ingreso`.`FechaIngreso` DESC";
        } else {
            xSql = "SELECT\n    `ingreso`.`Id`\n    , `ingreso`.`FechaIngreso`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1` ,' ',`g_persona`.`Nombre2`) AS `NProfesional`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresConvenio`\n    , `ingreso`.`Id_Usuario`, c_clasecita.`Nbre` nClaseCita\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n INNER JOIN `c_clasecita` ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n    INNER JOIN  `g_profesional` \n        ON (`g_profesional`.`Id_Persona` = `h_atencion`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad` \n        ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_profesional`.`Id_Persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`ingreso`.`Id_Usuario` ='" + xIdUsuario + "' AND c_clasecita.`EsP`=1 and h_atencion.TipoGuardado=2  and h_atencion.Codigo_Dxp<>'' AND ingreso.`Estado`=0 and date_format( `ingreso`.`FechaIngreso`, '%Y')='" + xAnno + "' and `g_especialidad`.`Id`='" + xIdEspecialidad + "')\nORDER BY `ingreso`.`FechaIngreso` DESC";
        }
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
