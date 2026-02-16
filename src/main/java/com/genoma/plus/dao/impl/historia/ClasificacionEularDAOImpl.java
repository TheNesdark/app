package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ClasificacionEularDAO;
import com.genoma.plus.dto.historia.ClasificacionEularDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ClasificacionEularDAOImpl.class */
public class ClasificacionEularDAOImpl implements ClasificacionEularDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ClasificacionEularDAO
    public String mCreate(final ClasificacionEularDTO xClasifEular) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.ClasificacionEularDAOImpl.1
            final String SQL_INSERT = "INSERT INTO h_clasificacion_eular (`Id_Atencion`,`Id_Usuario`,`Id_Profesional`,`Id_Especialidad`,`Fecha_Registro`,\n`Articulacion`,`Serologia`,`Reactante`,`Duracion`,`Resultado`,`Clasificacion`,`UsuarioS`)VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO h_clasificacion_eular (`Id_Atencion`,`Id_Usuario`,`Id_Profesional`,`Id_Especialidad`,`Fecha_Registro`,\n`Articulacion`,`Serologia`,`Reactante`,`Duracion`,`Resultado`,`Clasificacion`,`UsuarioS`)VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", 1);
                ps.setLong(1, xClasifEular.getIdAtencion());
                ps.setLong(2, xClasifEular.getIdUsuario());
                ps.setString(3, xClasifEular.getIdProfesional());
                ps.setString(4, xClasifEular.getIdEspecialidad());
                ps.setString(5, xClasifEular.getFechaRegistro());
                ps.setInt(6, xClasifEular.getArticulacion());
                ps.setInt(7, xClasifEular.getSerologia());
                ps.setInt(8, xClasifEular.getReactante());
                ps.setInt(9, xClasifEular.getDuracion());
                ps.setInt(10, xClasifEular.getResultado());
                ps.setString(11, xClasifEular.getClasificacion());
                ps.setString(12, xClasifEular.getUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdClasifEular = String.valueOf(generatedKeyHolder.getKey().longValue());
        return xIdClasifEular;
    }

    @Override // com.genoma.plus.dao.historia.ClasificacionEularDAO
    public List<ClasificacionEularDTO> listClasificacionEular(Long idUsuario) {
        String SQL_READALL = "SELECT `h_clasificacion_eular`.`Id`\n    , `h_clasificacion_eular`.`Id_Atencion`\n    , CONCAT(`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`,' ', `g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`) AS Profesional\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `h_clasificacion_eular`.`Fecha_Registro`\n    , `h_clasificacion_eular`.`Articulacion`\n    , `h_clasificacion_eular`.`Serologia`\n    , `h_clasificacion_eular`.`Reactante`\n    , `h_clasificacion_eular`.`Duracion`\n    , `h_clasificacion_eular`.`Resultado`\n    , `h_clasificacion_eular`.`Clasificacion`\nFROM `baseserver`.`h_clasificacion_eular`\n    INNER JOIN `baseserver`.`h_atencion` ON (`h_clasificacion_eular`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` ON (`h_clasificacion_eular`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`g_profesional` ON (`h_clasificacion_eular`.`Id_Profesional` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`g_persona` ON (`g_profesional`.`Id_Persona` = `g_persona`.`Id`)\nWHERE (`h_clasificacion_eular`.`Id_Usuario` ='" + idUsuario + "') ORDER BY `h_clasificacion_eular`.`Fecha_Registro` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ClasificacionEularDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ClasificacionEularDTO ce = new ClasificacionEularDTO();
                ce.setId(rs.getInt("Id"));
                ce.setIdAtencion(rs.getInt("Id_Atencion"));
                ce.setIdProfesional(rs.getString("Profesional"));
                ce.setIdEspecialidad(rs.getString("Especialidad"));
                ce.setFechaRegistro(rs.getString("Fecha_Registro"));
                ce.setArticulacion(rs.getInt("Articulacion"));
                ce.setSerologia(rs.getInt("Serologia"));
                ce.setReactante(rs.getInt("Reactante"));
                ce.setDuracion(rs.getInt("Duracion"));
                ce.setResultado(rs.getInt("Resultado"));
                ce.setClasificacion(rs.getString("Clasificacion"));
                return ce;
            }
        };
        List<ClasificacionEularDTO> lsClasEular = this.jdbcTemplate.query(SQL_READALL, rowMapper);
        return lsClasEular;
    }
}
