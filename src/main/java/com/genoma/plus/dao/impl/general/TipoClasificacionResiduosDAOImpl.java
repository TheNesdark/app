package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoClasificacionResiduosDAO;
import com.genoma.plus.dto.general.TipoClasificacionResiduosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoClasificacionResiduosDAOImpl.class */
public class TipoClasificacionResiduosDAOImpl implements TipoClasificacionResiduosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoClasificacionResiduosDAO
    public List<TipoClasificacionResiduosDTO> listClasificacionResiduos() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoClasificacionResiduosDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoClasificacionResiduosDTO xresiduos = new TipoClasificacionResiduosDTO();
                xresiduos.setId(Long.valueOf(rs.getLong("Id")));
                xresiduos.setNombre(rs.getString("Nbre"));
                xresiduos.setEncabezado(rs.getString("NEncabezado"));
                xresiduos.setClasificacion(rs.getString("NClasificacion"));
                xresiduos.setOrden(rs.getInt("NOrden"));
                xresiduos.setEstado(rs.getInt("Estado"));
                return xresiduos;
            }
        };
        List<TipoClasificacionResiduosDTO> lsTipo = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `NEncabezado`, `NClasificacion`, `NOrden`, `Estado` FROM `s_sgc_r_tipo_clasificacion`", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.TipoClasificacionResiduosDAO
    public String mCreate(TipoClasificacionResiduosDTO xresiduos) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_r_tipo_clasificacion` (`Nbre`,`NEncabezado`,`NClasificacion`,`NOrden`,`Estado`,`Id_UsuarioS`)\nVALUES(?,?,?,?,?,?);", new Object[]{xresiduos.getNombre(), xresiduos.getEncabezado(), xresiduos.getClasificacion(), Integer.valueOf(xresiduos.getOrden()), Integer.valueOf(xresiduos.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.TipoClasificacionResiduosDAO
    public String mUpdate(TipoClasificacionResiduosDTO xresiduos) {
        String result = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE\n  `s_sgc_r_tipo_clasificacion`\nSET\n  `Nbre` = ?,\n  `NEncabezado` = ?,\n  `NClasificacion` = ?,\n  `NOrden` = ?,\n  `Estado` = ?,\n  `Id_UsuarioS` = ?\nWHERE `Id` = ?;", new Object[]{xresiduos.getNombre(), xresiduos.getEncabezado(), xresiduos.getClasificacion(), Integer.valueOf(xresiduos.getOrden()), Integer.valueOf(xresiduos.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), xresiduos.getId()});
        if (ctos == 0) {
            result = "No se actualizo";
        }
        return result;
    }
}
