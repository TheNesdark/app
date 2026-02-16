package com.genoma.plus.dao.impl.pyp;

import com.genoma.plus.dao.pyp.ItemProcedimientoSeguimientoDAO;
import com.genoma.plus.dto.pyp.ItemProcedimientoSeguimientoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/pyp/ItemProcedimientoSeguimientoDAOImpl.class */
public class ItemProcedimientoSeguimientoDAOImpl implements ItemProcedimientoSeguimientoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.pyp.ItemProcedimientoSeguimientoDAO
    public String createSeguimiento(ItemProcedimientoSeguimientoDTO e) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_itemordenproced_seguimiento`(`Id_ItemsOrden` , `FechaS` , `Id_TipoSeguimiento` , `Observacion` , `Id_UsuarioRH`)\nVALUES (?,?,?,?,?);", new Object[]{Long.valueOf(e.getIdItemsOrden()), e.getFecha(), Integer.valueOf(e.getIdTipoSeguimiento()), e.getObservacion(), Long.valueOf(e.getIdUsuarioRh())});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.pyp.ItemProcedimientoSeguimientoDAO
    public List<Object[]> listaSeguimientoItems(Long xIdItems) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.pyp.ItemProcedimientoSeguimientoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("FechaS"), rs.getString("TipoSeguimiento"), rs.getString("Observacion"), rs.getString("Cargo"), rs.getString("Responsable")};
                return fila;
            }
        };
        String sql = "SELECT\n    `h_itemordenproced_seguimiento`.`Id`\n    , `h_itemordenproced_seguimiento`.`FechaS`\n    , `p_citologia_tiposeguimiento`.`Nbre` AS `TipoSeguimiento`\n    , `h_itemordenproced_seguimiento`.`Observacion`\n    , `rh_tipo_cargo`.`Nbre` AS `Cargo`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) Responsable\nFROM\n     `h_itemordenproced_seguimiento`\n    INNER JOIN  `p_citologia_tiposeguimiento` \n        ON (`h_itemordenproced_seguimiento`.`Id_TipoSeguimiento` = `p_citologia_tiposeguimiento`.`Id`)\n    INNER JOIN  `rh_tipo_persona_cargon` \n        ON (`rh_tipo_persona_cargon`.`Id` = `h_itemordenproced_seguimiento`.`Id_UsuarioRH`)\n    INNER JOIN  `rh_unidadf_cargo` \n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN  `rh_tipo_cargo` \n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\nWHERE (`h_itemordenproced_seguimiento`.`Estado` =1\n    AND `h_itemordenproced_seguimiento`.`Id_ItemsOrden` ='" + xIdItems + "')\n    ORDER BY `h_itemordenproced_seguimiento`.`FechaS` DESC";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
