package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.EspecialidadProfesionalDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/EspecialidadProfesionalDAOImpl.class */
public class EspecialidadProfesionalDAOImpl implements EspecialidadProfesionalDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.EspecialidadProfesionalDAO
    public List<Object[]> listadoEspecialidadProfesional(Long idPersona) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EspecialidadProfesionalDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt("Id")), rs.getString("Nbre")};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT `g_especialidad`.`Id` , `g_especialidad`.`Nbre` FROM `g_profesionalespecial` INNER JOIN `g_especialidad` ON (`g_profesionalespecial`.`Id_Especialidad` = `g_especialidad`.`Id`) WHERE (`g_profesionalespecial`.`Id_Profesional` =? AND `g_profesionalespecial`.`Estado` =0) ORDER BY `g_especialidad`.`Nbre` ASC", mapper, new Object[]{idPersona});
        return list;
    }
}
