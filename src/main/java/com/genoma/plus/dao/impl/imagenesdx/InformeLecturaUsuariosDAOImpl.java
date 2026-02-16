package com.genoma.plus.dao.impl.imagenesdx;

import com.genoma.plus.dao.imagenesdx.InformeLecturaUsuariosDAO;
import com.genoma.plus.dto.imagenesdx.InformeLecturaUsuariosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/imagenesdx/InformeLecturaUsuariosDAOImpl.class */
public class InformeLecturaUsuariosDAOImpl implements InformeLecturaUsuariosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.imagenesdx.InformeLecturaUsuariosDAO
    public List<InformeLecturaUsuariosDTO> list(String xidUsuario) {
        String sql = "SELECT `h_radiologia`.`Fecha_Rec` , `g_procedimiento`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `h_radiologia_detalle`.`Id`\nFROM `h_radiologia_detalle` INNER JOIN `h_radiologia` ON (`h_radiologia_detalle`.`Id_radiologia` = `h_radiologia`.`Id`) INNER JOIN `f_ordenes` \nON (`h_radiologia`.`Id_OrdenFac` = `f_ordenes`.`Id`) INNER JOIN `h_radiologia_lectura_encabezado` ON (`h_radiologia_lectura_encabezado`.`Id_Radiologia` = `h_radiologia_detalle`.`Id`)\nINNER JOIN `g_procedimiento` ON (`h_radiologia_detalle`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_radiologia_lectura_encabezado`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_radiologia_lectura_encabezado`.`Id_Especialidad`)\nWHERE (`ingreso`.`Id_Usuario` ='" + xidUsuario + "') ORDER BY `h_radiologia`.`Fecha_Rec` DESC, `g_procedimiento`.`Nbre` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.imagenesdx.InformeLecturaUsuariosDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                InformeLecturaUsuariosDTO Lista = new InformeLecturaUsuariosDTO();
                Lista.setFechaRec(rs.getString("Fecha_Rec"));
                Lista.setNProcedimiento(rs.getString("Nbre"));
                Lista.setEspecialidad(rs.getString("Especialidad"));
                Lista.setNProfesional(rs.getString("NProfesional"));
                Lista.setIdEncabezado(rs.getInt("Id"));
                return Lista;
            }
        };
        List<InformeLecturaUsuariosDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }
}
