package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.ConfiguracionItemsDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.ConfiguracionItems;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/ConfiguracionItemsDAOImpl.class */
public class ConfiguracionItemsDAOImpl implements ConfiguracionItemsDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.ConfiguracionItemsDAO
    public List<Object[]> listConfiguracionItems(String item) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ConfiguracionItemsDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("id")), rs.getString("nombre"), rs.getString("NPadre"), rs.getString("Sexo"), Double.valueOf(rs.getDouble("edadDiasInicio")), Double.valueOf(rs.getDouble("edadDiasFin")), Integer.valueOf(rs.getInt("numeroOrden")), rs.getString("valorPorDefecto"), Boolean.valueOf(rs.getBoolean("ultimoNivel")), Boolean.valueOf(rs.getBoolean("validable")), Boolean.valueOf(rs.getBoolean("estado")), rs.getString("nombreFormulario")};
                return fila;
            }
        };
        String sql = "SELECT\n    `h_configuracion_items`.`id`\n    , `h_configuracion_items`.`nombre`\n    , IFNULL(`h_configuracion_items_1`.`nombre`,'') AS `NPadre`\n    , IF(`h_configuracion_items`.`idSexo`='A','Ambos',IF(`h_configuracion_items`.`idSexo`='F','Femenino','Masculino')) AS Sexo\n    , `h_configuracion_items`.`edadDiasInicio`\n    , `h_configuracion_items`.`edadDiasFin`\n    , `h_configuracion_items`.`numeroOrden`\n    , IFNULL(`h_configuracion_items`.`valorPorDefecto`,'') AS valorPorDefecto\n    , `h_configuracion_items`.`ultimoNivel`\n    , `h_configuracion_items`.`validable`\n    , `h_configuracion_items`.`estado`\n    , `h_configuracion_items`.nombreFormulario\nFROM\n    `h_configuracion_items`\n    LEFT JOIN `h_configuracion_items` AS `h_configuracion_items_1` \n        ON (`h_configuracion_items`.`idPadre` = `h_configuracion_items_1`.`id`)\nWHERE(`h_configuracion_items`.`nombre` LIKE '%" + item + "%')ORDER BY `h_configuracion_items`.`idPadre` ASC, `h_configuracion_items`.`numeroOrden` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.ConfiguracionItemsDAO
    public List<GCGenericoDTO> listCarpetaPadre() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ConfiguracionItemsDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setIdString(rs.getString("Id"));
                g.setNombre(rs.getString("nombre"));
                return g;
            }
        };
        List<GCGenericoDTO> lsTipo = this.jdbcTemplate.query("SELECT `id` , `nombre` FROM `h_configuracion_items` WHERE (`estado` =1) ORDER BY `nombre` ASC;", rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.ConfiguracionItemsDAO
    public String mCreate(ConfiguracionItems xConfiguracion) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `baseserver`.`h_configuracion_items` (`idPadre`, `nombre`, nombreFormulario, `ultimoNivel`, `validable`, `idSexo`, `edadDiasInicio`, `edadDiasFin`, `numeroOrden`, `valorPorDefecto`, `estado`, `idUsuarioSistemas`)\nVALUES(?,?,?,?,?,?,?,?,?,?,?,?);", new Object[]{xConfiguracion.getIdPadre(), xConfiguracion.getNombre(), xConfiguracion.getNombreFormulario(), xConfiguracion.getUltimoNivel(), xConfiguracion.getValidable(), xConfiguracion.getIdSexo(), xConfiguracion.getEdadDiasInicio(), xConfiguracion.getEdadDiasFin(), xConfiguracion.getNumeroOrden(), xConfiguracion.getValorPorDefecto(), xConfiguracion.getEstado(), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ConfiguracionItemsDAO
    public String mUpdate(ConfiguracionItems xConfiguracion) {
        String sql = "UPDATE `h_configuracion_items` SET `idPadre`=?,\n`nombre`=?,\n`nombreFormulario`=?,\n`ultimoNivel`=?,\n`validable`=?,\n`idSexo`=?,\n`edadDiasInicio`=?,\n`edadDiasFin`=?,\n`numeroOrden`=?,\n`valorPorDefecto`=?,\n`estado`=?,\n`idUsuarioSistemas`=?\nWHERE id=?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xConfiguracion.getIdPadre(), xConfiguracion.getNombre(), xConfiguracion.getNombreFormulario(), xConfiguracion.getUltimoNivel(), xConfiguracion.getValidable(), xConfiguracion.getIdSexo(), xConfiguracion.getEdadDiasInicio(), xConfiguracion.getEdadDiasFin(), xConfiguracion.getNumeroOrden(), xConfiguracion.getValorPorDefecto(), xConfiguracion.getEstado(), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), xConfiguracion.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
