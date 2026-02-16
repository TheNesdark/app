package com.genoma.plus.dao.impl.pyp;

import com.genoma.plus.dao.pyp.AgendaVacunacionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/pyp/AgendaVacunacionDAOImpl.class */
public class AgendaVacunacionDAOImpl implements AgendaVacunacionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.pyp.AgendaVacunacionDAO
    public List<Object[]> listadoAgenda(String xFecha, String tipo) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.pyp.AgendaVacunacionDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), Integer.valueOf(rs.getInt(8)), rs.getString(9), Long.valueOf(rs.getLong(10)), Long.valueOf(rs.getLong(11)), Long.valueOf(rs.getLong(12)), rs.getString(13)};
                return fila;
            }
        };
        String sql = "SELECT\n    `g_usuario`.`NoHistoria`\n    ,CONCAT(`g_persona`.`Id_TipoIdentificacion` ,'-', `g_persona`.`NoDocumento`) Documento \n    , CONCAT(`g_persona`.`Apellido1` , ' ',`g_persona`.`Apellido2`, ' ', `g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`) AS `NUsuario`\n, CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `ingreso`.`FechaIngreso`)  ,' ',  `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `ingreso`.`FechaIngreso`)) AS `Edad`    \n    , `g_persona`.`Id_Sexo`    \n    , `f_empresacontxconvenio`.`Nbre` AS `NCOnvenio`\n    , GROUP_CONCAT(`g_procedimiento`.`Nbre` ORDER BY `g_procedimiento`.`Nbre` ASC SEPARATOR '\\n'  ) AS `NProcedimiento`\n    , `ingreso`.`CEspecial`\n    , IF(`f_ordenes`.`EstadoRecep`=0, 'POR ATENDER', 'ATENDIDO') Estado, f_ordenes.Id, ingreso.Id as IdIngreso , ingreso.`Id_Profesional`\n    ,  profesional1.`NProfesional` \nFROM\n     `ingreso`\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `f_ordenes` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  INNER JOIN `baseserver`.`profesional1` \n                               ON (`ingreso`.`Id_Profesional` = `profesional1`.`Id_Persona`)\nWHERE (`g_procedimiento`.`Id_tipoprocedimiento` =10\n    AND `g_procedimiento`.`EsAgenda` =1\n    AND `ingreso`.`FechaIngreso` ='" + xFecha + "'   \n    AND `ingreso`.`Estado` =0\n    AND `f_ordenes`.`Estado` =0 AND `f_ordenes`.`EstadoRecep`IN (" + tipo + ")) GROUP BY ingreso.`Id`";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
