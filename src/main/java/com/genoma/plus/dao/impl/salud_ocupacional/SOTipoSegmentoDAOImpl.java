package com.genoma.plus.dao.impl.salud_ocupacional;

import com.genoma.plus.dao.salud_ocupacional.SOTipoSegmentoDAO;
import com.genoma.plus.dto.salud_ocupacional.SOTipoSegmentoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/salud_ocupacional/SOTipoSegmentoDAOImpl.class */
public class SOTipoSegmentoDAOImpl implements SOTipoSegmentoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.SOTipoSegmentoDAO
    public List<Object[]> listaTSegmentos() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.SOTipoSegmentoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), Integer.valueOf(rs.getInt(4)), Integer.valueOf(rs.getInt(5)), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), Integer.valueOf(rs.getInt(11)), Boolean.valueOf(rs.getBoolean(12))};
                return fila;
            }
        };
        List<Object[]> listaTsegmentos = this.jdbcTemplate.query("SELECT\n    `so_tipo_segmento`.`Id`\n    , `so_tipo_segmento`.`Nbre`\n    , `so_tipo_segmento`.`Descripcion`\n    , `so_tipo_segmento`.`Tipo`\n    , `so_tipo_segmento`.`IdTipoEmpresa`\n    , `g_tipoempresa`.`Nbre`\n    , IFNULL(`so_tipo_segmento`.`Unidad`,'') AS Unidad\n    , IFNULL(`so_tipo_segmento`.`Cargo_Asociado`,'') AS Cargo_Asociado \n    , `so_tipo_segmento`.`Sede`\n    , `so_tipo_segmento`.`TipoSeg`\n    , `so_tipo_segmento`.`NumeroTrabajadores`\n    , `so_tipo_segmento`.`Estado`\nFROM\n    `so_tipo_segmento`\n    INNER JOIN `g_tipoempresa` \n        ON (`so_tipo_segmento`.`IdTipoEmpresa` = `g_tipoempresa`.`Id`);", mapper);
        return listaTsegmentos;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.SOTipoSegmentoDAO
    public String mCreate(SOTipoSegmentoDTO xTSegmentoDTO) {
        String result = "Se inserto correctamente ";
        int ctos = this.jdbcTemplate.update("INSERT INTO `so_tipo_segmento` (`Nbre`,`Descripcion`,`Tipo`,`IdTipoEmpresa`,`Unidad`,`Cargo_Asociado`,\n`Sede`,`TipoSeg`,`NumeroTrabajadores`,`Estado`,`UsuarioS`) VALUES (?,?,?,?,?,?,?,?,?,?,?);", new Object[]{xTSegmentoDTO.getNombre(), xTSegmentoDTO.getDescripcion(), Integer.valueOf(xTSegmentoDTO.getTipo()), xTSegmentoDTO.getIdTipoEmpresa(), xTSegmentoDTO.getUnidad(), xTSegmentoDTO.getCargoAsociado(), xTSegmentoDTO.getSede(), xTSegmentoDTO.getTiposeg(), Integer.valueOf(xTSegmentoDTO.getNumTrabajadores()), Boolean.valueOf(xTSegmentoDTO.isEstado()), xTSegmentoDTO.getUsuario()});
        if (ctos == 0) {
            result = "No se pudo Insertar correctamente";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.SOTipoSegmentoDAO
    public String mUpdate(SOTipoSegmentoDTO xTSegmentoDTO) {
        String result = "Se inserto correctamente ";
        int ctos = this.jdbcTemplate.update("UPDATE `so_tipo_segmento` SET  `Nbre`= ?,`Descripcion`= ?,`Tipo`= ?,`IdTipoEmpresa`= ?,`Unidad`= ?,`Cargo_Asociado`= ?,\n`Sede`= ?,`TipoSeg`= ?,`NumeroTrabajadores`= ?,`Estado`= ?,`UsuarioS`= ? WHERE `Id` = ?;", new Object[]{xTSegmentoDTO.getNombre(), xTSegmentoDTO.getDescripcion(), Integer.valueOf(xTSegmentoDTO.getTipo()), xTSegmentoDTO.getIdTipoEmpresa(), xTSegmentoDTO.getUnidad(), xTSegmentoDTO.getCargoAsociado(), xTSegmentoDTO.getSede(), xTSegmentoDTO.getTiposeg(), Integer.valueOf(xTSegmentoDTO.getNumTrabajadores()), Boolean.valueOf(xTSegmentoDTO.isEstado()), xTSegmentoDTO.getUsuario(), Long.valueOf(xTSegmentoDTO.getId())});
        if (ctos == 0) {
            result = "No se pudo Insertar correctamente";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.SOTipoSegmentoDAO
    public List<Object[]> listaCombo(String sql) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.SOTipoSegmentoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> listaTEmpresas = this.jdbcTemplate.query(sql, mapper);
        return listaTEmpresas;
    }
}
