package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ValeReportePadresEncabezadoDAO;
import com.genoma.plus.dto.historia.ValeReportePadresEncabezadoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ValeReportePadresEncabezadoDAOImpl.class */
public class ValeReportePadresEncabezadoDAOImpl implements ValeReportePadresEncabezadoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ValeReportePadresEncabezadoDAO
    public List<Object[]> listaReportePadresEncabezado(int idAtencion) {
        String sql = "SELECT `puntaje_compresion`,`puntaje_expresion`,`puntaje_interacion`,`puntaje_vestibular`,`puntaje_total` \nFROM `h_vale_reporte_padres_encabezado` WHERE `id_atencion` = " + idAtencion + ";";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ValeReportePadresEncabezadoDAOImpl.1
            public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), Integer.valueOf(rs.getInt(3)), Integer.valueOf(rs.getInt(4)), Integer.valueOf(rs.getInt(5))};
                return fila;
            }
        };
        List<Object[]> listaReportePadreEncabezado = this.jdbcTemplate.query(sql, mapper);
        return listaReportePadreEncabezado;
    }

    @Override // com.genoma.plus.dao.historia.ValeReportePadresEncabezadoDAO
    public int create(final ValeReportePadresEncabezadoDTO valeReportePadresEncabezadoDTO) {
        final String sql = "INSERT INTO `h_vale_reporte_padres_encabezado` (`id_atencion`,`id_usuario_atendido`,`id_profesional`\n,`id_especialidad`,`puntaje_compresion`,`puntaje_expresion`,`puntaje_interacion`,\n`puntaje_vestibular`,`puntaje_total`,`id_usuario`,`fecha_registro`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.ValeReportePadresEncabezadoDAOImpl.2
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, 1);
                ps.setInt(1, (int) valeReportePadresEncabezadoDTO.getIdAtencion());
                ps.setInt(2, (int) valeReportePadresEncabezadoDTO.getIdUsuarioAtendido());
                ps.setInt(3, (int) valeReportePadresEncabezadoDTO.getIdProfesional());
                ps.setInt(4, valeReportePadresEncabezadoDTO.getIdEspecialidad());
                ps.setInt(5, valeReportePadresEncabezadoDTO.getPuntajeCompresion());
                ps.setInt(6, valeReportePadresEncabezadoDTO.getPuntajeExpresion());
                ps.setInt(7, valeReportePadresEncabezadoDTO.getPuntajeInteracion());
                ps.setInt(8, valeReportePadresEncabezadoDTO.getPuntajeVestibular());
                ps.setInt(9, valeReportePadresEncabezadoDTO.getPuntajeTotal());
                ps.setInt(10, (int) valeReportePadresEncabezadoDTO.getIdUsuario());
                ps.setString(11, valeReportePadresEncabezadoDTO.getFechaRegistro());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        int idReportePadresEncabezado = generatedKeyHolder.getKey().intValue();
        return idReportePadresEncabezado;
    }

    @Override // com.genoma.plus.dao.historia.ValeReportePadresEncabezadoDAO
    public void update(ValeReportePadresEncabezadoDTO valeReportePadresEncabezadoDTO) {
        this.jdbcTemplate.update("UPDATE `h_vale_reporte_padres_encabezado` SET `id_atencion`=?,`id_usuario_atendido`=?,`id_profesional`=?,\n`id_especialidad`=?,`puntaje_compresion`=?,`puntaje_expresion`=?,`puntaje_interacion`=?,`puntaje_vestibular`=?,\n`puntaje_total`=?,`id_usuario`=? WHERE `id`=?;", new Object[]{Long.valueOf(valeReportePadresEncabezadoDTO.getIdAtencion()), Long.valueOf(valeReportePadresEncabezadoDTO.getIdUsuarioAtendido()), Long.valueOf(valeReportePadresEncabezadoDTO.getIdProfesional()), Integer.valueOf(valeReportePadresEncabezadoDTO.getIdEspecialidad()), Integer.valueOf(valeReportePadresEncabezadoDTO.getPuntajeCompresion()), Integer.valueOf(valeReportePadresEncabezadoDTO.getPuntajeExpresion()), Integer.valueOf(valeReportePadresEncabezadoDTO.getPuntajeInteracion()), Integer.valueOf(valeReportePadresEncabezadoDTO.getPuntajeVestibular()), Integer.valueOf(valeReportePadresEncabezadoDTO.getPuntajeTotal()), Long.valueOf(valeReportePadresEncabezadoDTO.getIdUsuario()), Integer.valueOf(valeReportePadresEncabezadoDTO.getId())});
    }
}
