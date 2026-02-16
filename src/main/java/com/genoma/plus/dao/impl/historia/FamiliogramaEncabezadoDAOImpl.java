package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.FamiliogramaEncabezadoDAO;
import com.genoma.plus.dto.historia.FamiliogramaEncabezadoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/FamiliogramaEncabezadoDAOImpl.class */
public class FamiliogramaEncabezadoDAOImpl implements FamiliogramaEncabezadoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaEncabezadoDAO
    public List<FamiliogramaEncabezadoDTO> ListadoFEncabezado(int idAtencion) {
        String sql = "SELECT `Id`,`Id_Atencion`,`Fecha_R`,`Id_Profesional`,`Id_Especialidad`,`Estado`,\n                `Id_UsuarioS`,`Fecha` FROM `h_familiograma_encabezado` WHERE `Estado`= 1 AND `Id_Atencion` = " + idAtencion;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaEncabezadoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                FamiliogramaEncabezadoDTO fila = new FamiliogramaEncabezadoDTO();
                fila.setId(rs.getInt(1));
                fila.setIdAtencion(rs.getInt(2));
                fila.setFechaR(rs.getString(3));
                fila.setIdProfesional(rs.getInt(4));
                fila.setIdEspecialidad(rs.getInt(5));
                fila.setEstado(rs.getBoolean(6));
                fila.setIdUsuario(rs.getInt(7));
                fila.setFecha(rs.getString(8));
                return fila;
            }
        };
        List<FamiliogramaEncabezadoDTO> listadoEncabezado = this.jdbcTemplate.query(sql, mapper);
        return listadoEncabezado;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaEncabezadoDAO
    public int mCreate(final FamiliogramaEncabezadoDTO xFEncabezadoDTO) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaEncabezadoDAOImpl.2
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_familiograma_encabezado` (`Id_Atencion`,`Fecha_R`,`Id_Profesional`,`Id_Especialidad`,`Estado`,`Id_UsuarioS`) VALUES (?,?,?,?,?,?);", 1);
                ps.setInt(1, xFEncabezadoDTO.getIdAtencion());
                ps.setString(2, xFEncabezadoDTO.getFechaR());
                ps.setInt(3, xFEncabezadoDTO.getIdProfesional());
                ps.setInt(4, xFEncabezadoDTO.getIdEspecialidad());
                ps.setBoolean(5, xFEncabezadoDTO.isEstado());
                ps.setInt(6, xFEncabezadoDTO.getIdUsuario());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        int idExamenFisico = generatedKeyHolder.getKey().intValue();
        return idExamenFisico;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaEncabezadoDAO
    public String mUpdate(FamiliogramaEncabezadoDTO xFEncabezadoDTO) {
        String sql = "UPDATE `h_familiograma_encabezado` SET `Id_Atencion`=?,`Fecha_R`=?,`Id_Profesional`=?,`Id_Especialidad`=?,`Estado`=?,`Id_UsuarioS`=? WHERE `Id`=?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xFEncabezadoDTO.getIdAtencion()), xFEncabezadoDTO.getFechaR(), Integer.valueOf(xFEncabezadoDTO.getIdProfesional()), Integer.valueOf(xFEncabezadoDTO.getIdEspecialidad()), Boolean.valueOf(xFEncabezadoDTO.isEstado()), Integer.valueOf(xFEncabezadoDTO.getIdUsuario()), Integer.valueOf(xFEncabezadoDTO.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaEncabezadoDAO
    public List<Object[]> traerFamiliogramas(long idPaciente) {
        String sql = "SELECT\n      `h_familiograma_encabezado`.`Id`\n    , `h_familiograma_encabezado`.`Fecha_R`\n    , `h_familiograma_encabezado`.`Id_Atencion`    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    , CONCAT(`g_persona`.`Apellido1`, ' ',  `g_persona`.`Apellido2`, ' ',`g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`) AS `Profesional`\nFROM\n    `baseserver`.`h_familiograma_encabezado`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_familiograma_encabezado`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`h_familiograma_encabezado`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`g_profesional` \n        ON (`h_familiograma_encabezado`.`Id_Profesional` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_persona`.`Id` = `g_profesional`.`Id_Persona`)\nWHERE (`ingreso`.`Id_Usuario` = " + idPaciente + ")\nORDER BY `h_familiograma_encabezado`.`Fecha_R` DESC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaEncabezadoDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), Integer.valueOf(rs.getInt(3)), rs.getString(4), rs.getString(5)};
                return fila;
            }
        };
        List<Object[]> listadoFamiliogramas = this.jdbcTemplate.query(sql, mapper);
        return listadoFamiliogramas;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaEncabezadoDAO
    public List<Object[]> datosHC(String idAtencion) {
        String sql = "SELECT\n    `ingreso`.`Id_Usuario`\n    , `ingreso`.`FechaIngreso`\n    , `h_atencion`.`Id`\nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Id` =" + idAtencion + ");";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaEncabezadoDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), Integer.valueOf(rs.getInt(3))};
                return fila;
            }
        };
        List<Object[]> listado = this.jdbcTemplate.query(sql, mapper);
        return listado;
    }
}
