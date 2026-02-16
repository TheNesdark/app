package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.InformacionProfesionalDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/InformacionProfesionalDAOImpl.class */
public class InformacionProfesionalDAOImpl implements InformacionProfesionalDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.InformacionProfesionalDAO
    public List<Object[]> listadoEspecialidadConProfesional() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.InformacionProfesionalDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Nbre")};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n    `g_especialidad`.`Id`\n    , `g_especialidad`.`Nbre`\nFROM\n    .`g_profesionalespecial`\n    INNER JOIN `g_especialidad` \n        ON (`g_profesionalespecial`.`Id_Especialidad` = `g_especialidad`.`Id`)\nWHERE (`g_profesionalespecial`.`Estado` =0)\nGROUP BY `g_especialidad`.`Id`\nORDER BY `g_especialidad`.`Nbre` ASC", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.InformacionProfesionalDAO
    public List<Object[]> listadoProfesionalFiltradoPorEspecialidad(String idEspecialidad) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.InformacionProfesionalDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id_Persona")), rs.getString("profesional")};
                return fila;
            }
        };
        String sql = "SELECT\n    `g_profesional`.`Id_Persona`\n    , CONCAT(`g_persona`.`Apellido1`, ' ',`g_persona`.`Apellido2`, ' ', `g_persona`.`Nombre1`, ' ',`g_persona`.`Nombre2`) AS `profesional`\nFROM\n     `g_profesional`\n    INNER JOIN  `g_profesionalespecial` \n        ON (`g_profesional`.`Id_Persona` = `g_profesionalespecial`.`Id_Profesional`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_profesional`.`Id_Persona`)\nWHERE (`g_profesionalespecial`.`Id_Especialidad` ='" + idEspecialidad + "'\n    AND `g_profesional`.`Estado` =0\n    AND `g_profesionalespecial`.`Estado` =0)\nORDER BY `profesional` ASC;";
        System.out.println("sql-->" + sql);
        System.out.println("idEspecialidad-->" + idEspecialidad);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
