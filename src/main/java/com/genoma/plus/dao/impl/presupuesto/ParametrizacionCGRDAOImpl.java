package com.genoma.plus.dao.impl.presupuesto;

import com.genoma.plus.dao.presupuesto.ParametrizacionCGRDAO;
import com.genoma.plus.dto.presupuesto.ParametrizacionCGRDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/ParametrizacionCGRDAOImpl.class */
public class ParametrizacionCGRDAOImpl implements ParametrizacionCGRDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.ParametrizacionCGRDAO
    public List<Object[]> listaParametrizacionCGR(String idRubro, String idEncabezado) {
        String sql = "SELECT\n     `pp_parametrizacion_cgr`.`id`   \n    ,`pp_parametrizacion_cgr`.`idRubro`\n    , `pp_rubros`.`Nbre`\n    , `pp_parametrizacion_cgr`.`idRubro_Contraloria`\n    , `pp_rubros_contraloria`.`Nombre`\n    , `pp_parametrizacion_cgr`.`idTipoRecurso`\n    , `pp_tipo_recursos`.`Codigo`\n    , `pp_tipo_recursos`.`Nombre`\n    , `pp_parametrizacion_cgr`.`IdOrigienIngreso`\n    , `pp_origen_ingreso`.`Codigo`\n    , `pp_origen_ingreso`.`Nombre`\n    , `pp_parametrizacion_cgr`.`idFinGasto`\n    , `pp_finalidad_gasto`.`Codigo`\n    , `pp_finalidad_gasto`.`Nombre`\n    , `pp_parametrizacion_cgr`.`idTipoDestino`\n    , `pp_tipo_destinacion`.`Codigo`\n    , `pp_tipo_destinacion`.`Nombre`\n    , `pp_parametrizacion_cgr`.`idTipoSituacion`\n    , `pp_tipo_situacion`.`Codigo`\n    , `pp_tipo_situacion`.`Nombre`\n    , `pp_parametrizacion_cgr`.`idTipoVigencia`\n    , `pp_tipo_vigencia`.`Codigo`\n    , `pp_tipo_vigencia`.`Nombre`\n    , `pp_parametrizacion_cgr`.`Estado`\nFROM\n    `pp_parametrizacion_cgr`\n    INNER JOIN `baseserver`.`pp_rubros` \n        ON (`pp_parametrizacion_cgr`.`idRubro` = `pp_rubros`.`Id`)\n    INNER JOIN `baseserver`.`pp_rubros_contraloria` \n        ON (`pp_parametrizacion_cgr`.`idRubro_Contraloria` = `pp_rubros_contraloria`.`Codigo`)\n    INNER JOIN `baseserver`.`pp_tipo_recursos` \n        ON (`pp_parametrizacion_cgr`.`idTipoRecurso` = `pp_tipo_recursos`.`Id`)\n    INNER JOIN `baseserver`.`pp_origen_ingreso` \n        ON (`pp_parametrizacion_cgr`.`IdOrigienIngreso` = `pp_origen_ingreso`.`Id`)\n    INNER JOIN `baseserver`.`pp_finalidad_gasto` \n        ON (`pp_parametrizacion_cgr`.`idFinGasto` = `pp_finalidad_gasto`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_destinacion` \n        ON (`pp_parametrizacion_cgr`.`idTipoDestino` = `pp_tipo_destinacion`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_situacion` \n        ON (`pp_parametrizacion_cgr`.`idTipoSituacion` = `pp_tipo_situacion`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_vigencia` \n        ON (`pp_parametrizacion_cgr`.`idTipoVigencia` = `pp_tipo_vigencia`.`Id`)\n        WHERE (`idRubro` = '" + idRubro + "' AND `pp_rubros`.`idEncabezadoRubro`= " + idEncabezado + " ) ;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.ParametrizacionCGRDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), Integer.valueOf(rs.getInt(6)), rs.getString(7), rs.getString(8), Integer.valueOf(rs.getInt(9)), rs.getString(10), rs.getString(11), Integer.valueOf(rs.getInt(12)), rs.getString(13), rs.getString(14), Integer.valueOf(rs.getInt(15)), rs.getString(16), rs.getString(17), Integer.valueOf(rs.getInt(18)), rs.getString(19), rs.getString(20), Integer.valueOf(rs.getInt(21)), rs.getString(22), rs.getString(23), Boolean.valueOf(rs.getBoolean(24))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.presupuesto.ParametrizacionCGRDAO
    public String mCreate(ParametrizacionCGRDTO xParametrizacionCGRDTO) {
        String result = "se Inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO`pp_parametrizacion_cgr`(`idRubro`,`idRubro_Contraloria`,`idTipoRecurso`,`IdOrigienIngreso`,`idFinGasto`,`idTipoDestino`,`idTipoSituacion`,`idTipoVigencia`,`Estado`,`IdUsuarioS`) VALUES (?,?,?,?,?,?,?,?,?,?);", new Object[]{xParametrizacionCGRDTO.getIdRubro(), xParametrizacionCGRDTO.getIdRubroContraloria(), Integer.valueOf(xParametrizacionCGRDTO.getIdTipoRecurso()), Integer.valueOf(xParametrizacionCGRDTO.getIdOrigenIngreso()), Integer.valueOf(xParametrizacionCGRDTO.getIdFinGasto()), Integer.valueOf(xParametrizacionCGRDTO.getIdTipoDestinacion()), Integer.valueOf(xParametrizacionCGRDTO.getIdTipoSituacion()), Integer.valueOf(xParametrizacionCGRDTO.getIdTipoVigencia()), Boolean.valueOf(xParametrizacionCGRDTO.isEstado()), xParametrizacionCGRDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.ParametrizacionCGRDAO
    public String mUpdate(ParametrizacionCGRDTO xParametrizacionCGRDTO) {
        String result = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `pp_parametrizacion_cgr` SET                  `idRubro`=?,                `idRubro_Contraloria`=?,                `idTipoRecurso`=?,                `IdOrigienIngreso`=?,                `idFinGasto`=?,                `idTipoDestino`=?,               `idTipoSituacion`=?,                `idTipoVigencia`=?,                `Estado`=?,                `IdUsuarioS`=?                 WHERE (`id` = ?)", new Object[]{xParametrizacionCGRDTO.getIdRubro(), xParametrizacionCGRDTO.getIdRubroContraloria(), Integer.valueOf(xParametrizacionCGRDTO.getIdTipoRecurso()), Integer.valueOf(xParametrizacionCGRDTO.getIdOrigenIngreso()), Integer.valueOf(xParametrizacionCGRDTO.getIdFinGasto()), Integer.valueOf(xParametrizacionCGRDTO.getIdTipoDestinacion()), Integer.valueOf(xParametrizacionCGRDTO.getIdTipoSituacion()), Integer.valueOf(xParametrizacionCGRDTO.getIdTipoVigencia()), Boolean.valueOf(xParametrizacionCGRDTO.isEstado()), xParametrizacionCGRDTO.getIdUsuario(), Integer.valueOf(xParametrizacionCGRDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.ParametrizacionCGRDAO
    public List<Object[]> listaCombo(String sql) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.ParametrizacionCGRDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }
}
