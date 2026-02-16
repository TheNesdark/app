package com.genoma.plus.dao.impl.auditoria_medica;

import com.genoma.plus.dao.auditoria_medica.CierreSeguimientoDAO;
import com.genoma.plus.dto.auditoria_medica.CierreSeguimientoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/auditoria_medica/CierreSeguimientoDAOImpl.class */
public class CierreSeguimientoDAOImpl implements CierreSeguimientoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.auditoria_medica.CierreSeguimientoDAO
    public String create(CierreSeguimientoDTO en) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `ingreso_seguimiento_cierre`(`Id_Segumiento` , `FechaC` , `Observacion` , `IdPersonaRhC`)\nVALUES (?,?,?,?)", new Object[]{Long.valueOf(en.getIdSeguimiento()), en.getFecha(), en.getObservacion(), Long.valueOf(en.getIdPersonaRh())});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.auditoria_medica.CierreSeguimientoDAO
    public List<CierreSeguimientoDTO> listCierreSeguiento(Long xIdSeguimiento) {
        String sql = "SELECT\n    `Id`\n    , `Id_Segumiento`\n    , `FechaC`\n    , `Observacion`\n    , `IdPersonaRhC`\nFROM\n     `ingreso_seguimiento_cierre`\nWHERE (`Id_Segumiento` ='" + xIdSeguimiento + "'\n    AND `Estado` =1)";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.auditoria_medica.CierreSeguimientoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                CierreSeguimientoDTO e = new CierreSeguimientoDTO();
                e.setId(rs.getLong("Id"));
                e.setIdSeguimiento(rs.getLong("Id_Segumiento"));
                e.setFecha(rs.getString("FechaC"));
                e.setObservacion(rs.getString("Observacion"));
                return e;
            }
        };
        List<CierreSeguimientoDTO> lsCierreSguimiento = this.jdbcTemplate.query(sql, rowMapper);
        return lsCierreSguimiento;
    }
}
