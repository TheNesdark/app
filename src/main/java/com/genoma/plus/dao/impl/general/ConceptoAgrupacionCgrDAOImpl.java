package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.ConceptoAgrupacionCgrDAO;
import com.genoma.plus.dto.general.ConceptoAgrupacionCgrDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/ConceptoAgrupacionCgrDAOImpl.class */
public class ConceptoAgrupacionCgrDAOImpl implements ConceptoAgrupacionCgrDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.ConceptoAgrupacionCgrDAO
    public List<ConceptoAgrupacionCgrDTO> list() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ConceptoAgrupacionCgrDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ConceptoAgrupacionCgrDTO gen = new ConceptoAgrupacionCgrDTO();
                gen.setId(rs.getLong("Id"));
                gen.setNombre(rs.getString("Nbre"));
                gen.setAbreviatura(rs.getString("NCorto"));
                gen.setEstado(rs.getInt("Estado"));
                return gen;
            }
        };
        List<ConceptoAgrupacionCgrDTO> lsGen = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `NCorto`, `Estado` FROM `rh_concepto_agrupacion_informe_cgr` ORDER BY `Nbre` ASC;", rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.ConceptoAgrupacionCgrDAO
    public String create(ConceptoAgrupacionCgrDTO gen) {
        String result = "Se insertó correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `rh_concepto_agrupacion_informe_cgr` (`Nbre`,`NCorto`,`Estado`,`IdUsuarioS`)\nVALUES(?,?,?,?);", new Object[]{gen.getNombre(), gen.getAbreviatura(), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ConceptoAgrupacionCgrDAO
    public String update(ConceptoAgrupacionCgrDTO gen) {
        String sql = "update\n  `rh_concepto_agrupacion_informe_cgr`\nset\n  `Nbre` = ?,\n  `NCorto` = ?,\n  `Estado` = ?,\n  `IdUsuarioS` = ?\nwhere `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{gen.getNombre(), gen.getAbreviatura(), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Long.valueOf(gen.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.ConceptoAgrupacionCgrDAO
    public String delete(ConceptoAgrupacionCgrDTO gen) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
