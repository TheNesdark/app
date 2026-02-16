package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.FamiliogramaDetalleRelacionDAO;
import com.genoma.plus.dto.historia.FamiliogramaDetalleRelacionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/FamiliogramaDetalleRelacionDAOImpl.class */
public class FamiliogramaDetalleRelacionDAOImpl implements FamiliogramaDetalleRelacionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleRelacionDAO
    public List<Object[]> listadoDRelacion(int idFamiliograma) {
        String sql = "SELECT\n    `h_familiograma_detalle_relacion`.`Id`\n    , `h_familiograma_detalle_relacion`.`Id_FamiliogramaD`\n    , `h_familiograma_detalle_relacion`.`Id_FamiliogramaD1`\n    , `h_familiograma_detalle_relacion`.`Id_TipoRelacion`\n    , `h_familiograma_detalle_relacion`.`Abreviatura`\n    , `h_familiograma_detalle_relacion`.`Estado`\n    , `h_familiograma_detalle_relacion`.`Fecha`\n    , `h_familiograma_detalle_relacion`.`Id_Usuario`\n    , `h_familiogrma_detalle`.`Id_Familiograma`\n    , `g_relaciones_medicina_familar`.`Nbre`\nFROM\n    `h_familiograma_detalle_relacion`\n    INNER JOIN `h_familiogrma_detalle` \n        ON (`h_familiograma_detalle_relacion`.`Id_FamiliogramaD1` = `h_familiogrma_detalle`.`Id`)\n    INNER JOIN `h_familiogrma_detalle` AS `h_familiogrma_detalle_1`\n        ON (`h_familiograma_detalle_relacion`.`Id_FamiliogramaD` = `h_familiogrma_detalle_1`.`Id`)\n    INNER JOIN `g_relaciones_medicina_familar` \n        ON (`h_familiograma_detalle_relacion`.`Id_TipoRelacion` = `g_relaciones_medicina_familar`.`Id`)\nWHERE (`h_familiograma_detalle_relacion`.`Estado`= 1 AND `h_familiogrma_detalle`.`Id_Familiograma` = " + idFamiliograma + ");";
        System.out.println("consulta f" + sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaDetalleRelacionDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), Integer.valueOf(rs.getInt(2)), Integer.valueOf(rs.getInt(3)), Integer.valueOf(rs.getInt(4)), rs.getString(5), Boolean.valueOf(rs.getBoolean(6)), rs.getString(10)};
                return fila;
            }
        };
        List<Object[]> listDRelacion = this.jdbcTemplate.query(sql, mapper);
        return listDRelacion;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleRelacionDAO
    public String mCreate(FamiliogramaDetalleRelacionDTO xDetalleRelacion) {
        String result = "Datos insertados correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_familiograma_detalle_relacion` (`Id_FamiliogramaD`,`Id_FamiliogramaD1`,`Id_TipoRelacion`,`Abreviatura`,`Estado`,`id_usuario`,`id_familiograma`) VALUES (?,?,?,?,?,?,?);", new Object[]{xDetalleRelacion.getIdFamiliogramaD(), xDetalleRelacion.getIdFamiliogramaD1(), xDetalleRelacion.getIdTipoRelacion(), xDetalleRelacion.getAbreviatura(), Boolean.valueOf(xDetalleRelacion.isEstado()), xDetalleRelacion.getIdIUsuario(), Integer.valueOf(xDetalleRelacion.getIdFamiliograma())});
        if (ctos == 0) {
            result = "No se pudo insertar los datos";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleRelacionDAO
    public String mUpdate(FamiliogramaDetalleRelacionDTO xDetalleRelacion) {
        String sql = "UPDATE `h_familiograma_detalle_relacion` SET `Id_FamiliogramaD`=?,`Id_FamiliogramaD1`=?,`Id_TipoRelacion`=?,`Estado`=?,`id_usuario`= ? ,`id_familiograma`= ? WHERE `Id`=?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xDetalleRelacion.getIdFamiliogramaD(), xDetalleRelacion.getIdFamiliogramaD1(), xDetalleRelacion.getIdTipoRelacion(), Boolean.valueOf(xDetalleRelacion.isEstado()), xDetalleRelacion.getIdIUsuario(), Integer.valueOf(xDetalleRelacion.getIdFamiliograma()), xDetalleRelacion.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas ";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleRelacionDAO
    public String mAnularDetalle(int idFamiliograma) {
        String sql = "UPDATE `h_familiograma_detalle_relacion` SET `Estado` =0 WHERE `id_familiograma` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(idFamiliograma)});
        if (ctos == 0) {
            sql = "0 filas afectadas ";
        }
        return sql;
    }
}
