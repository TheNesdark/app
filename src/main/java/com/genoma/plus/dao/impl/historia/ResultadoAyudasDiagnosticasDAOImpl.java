package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ResultadoAyudasDiagnosticasDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ResultadoAyudasDiagnosticasDAOImpl.class */
public class ResultadoAyudasDiagnosticasDAOImpl implements ResultadoAyudasDiagnosticasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ResultadoAyudasDiagnosticasDAO
    public List<Object[]> listadoTipoAyudasDiagnosticasFiltradaPorUsuario(String idUsuario) {
        String sql = "SELECT\n    `h_tipoayudadx`.`Id`\n    , `h_tipoayudadx`.`Nbre`\nFROM\n     `h_resultadoayudasdx`\n    INNER JOIN  `h_tipoayudadx` \n        ON (`h_resultadoayudasdx`.`Id_TipoAyudaDX` = `h_tipoayudadx`.`Id`)\nWHERE (`h_resultadoayudasdx`.`Id_Usuario` ='" + idUsuario + "'\n    AND `h_resultadoayudasdx`.`Estado` =0) group by `h_tipoayudadx`.`Id` \nORDER BY `h_tipoayudadx`.`Nbre` ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ResultadoAyudasDiagnosticasDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> listaTipoAyuda = this.jdbcTemplate.query(sql, mapper);
        return listaTipoAyuda;
    }

    @Override // com.genoma.plus.dao.historia.ResultadoAyudasDiagnosticasDAO
    public List<Object[]> listadoAyudasDiagnosticasFiltradaPorUsuario(String idUsuario, String idTipoDocumento) {
        String sql = "SELECT h_resultadoayudasdx.Id, h_resultadoayudasdx.Fecha_Examen, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ',g_persona.`Nombre1`, ' ',g_persona.`Nombre1`) NProfesional, h_resultadoayudasdx.Estado, ifnull(h_resultadoayudasdx.interpretacion, '') interpretacion, h_resultadoayudasdx.Url \n, IF(h_resultadoayudasdx.interpretacion IS NULL, 'REVISADO', 'NO REVISADO') EstadoR\nFROM h_resultadoayudasdx INNER JOIN h_tipoayudadx ON (h_resultadoayudasdx.Id_TipoAyudaDX = h_tipoayudadx.Id) \nINNER JOIN `g_persona`  ON (g_persona.`Id` = h_resultadoayudasdx.Id_Profesional)  \nWHERE h_resultadoayudasdx.Id_Usuario='" + idUsuario + "'and h_resultadoayudasdx.Anulado=0 and  h_tipoayudadx.Id= '" + idTipoDocumento + "' ORDER BY h_resultadoayudasdx.Fecha_Examen DESC ";
        System.out.println("" + sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ResultadoAyudasDiagnosticasDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Fecha_Examen"), rs.getString("NProfesional"), Boolean.valueOf(rs.getBoolean("Estado")), rs.getString("interpretacion"), rs.getString("Url"), rs.getString("EstadoR")};
                return fila;
            }
        };
        List<Object[]> listaTipoAyuda = this.jdbcTemplate.query(sql, mapper);
        return listaTipoAyuda;
    }

    @Override // com.genoma.plus.dao.historia.ResultadoAyudasDiagnosticasDAO
    public String update(String idAtencion, String interpretacion, String id) {
        String sql = "update h_resultadoayudasdx set IdAtencion=?, Interpretacion=?, Estado=1 where Id=?";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{idAtencion, interpretacion, id});
        if (ctos == 0) {
            sql = "0 filas Afectadas";
        }
        return sql;
    }
}
