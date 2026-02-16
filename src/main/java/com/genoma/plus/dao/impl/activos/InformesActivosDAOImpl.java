package com.genoma.plus.dao.impl.activos;

import com.genoma.plus.dao.activos.InformesActivosDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/activos/InformesActivosDAOImpl.class */
public class InformesActivosDAOImpl implements InformesActivosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.activos.InformesActivosDAO
    public List<Object[]> mListadoInformeActivos(String Estado) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.activos.InformesActivosDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), Double.valueOf(rs.getDouble(11)), Integer.valueOf(rs.getInt(12)), rs.getString(13), rs.getString(14)};
                return fila;
            }
        };
        String xSql = "SELECT\n    `rh_activos`.`Id`\n    , `rh_activos`.`FechaC`\n    , `rh_tipo_categoria`.`Nbre` AS `NCategoria`\n    , `rh_tipo_ubicacion`.`Nbre` AS `NUbicacion`\n    , `rh_activos`.`Descripcion` AS `Nombre`\n    , `rh_tipo_marca`.`Nbre` AS `NMarca`\n    , `rh_activos`.`Modelo`\n    , `rh_activos`.`Referencia`\n    , `rh_activo_contable`.`Nbre`\n    , `rh_activo_contable`.`FechaC`\n    , `rh_activo_contable`.`VCompra`\n    , `rh_activos`.`Estado`\n    , IF(`rh_activos`.`EstadoA`=0,'BUENO',IF(`rh_activos`.`EstadoA`=1,'REGULAR','MALO')) AS EstadoA\n    , `rh_activos`.`Observacion`\nFROM\n    `rh_activos`\n    INNER JOIN `rh_activo_contable` \n        ON (`rh_activos`.`Id_rh_tipoagrupacion` = `rh_activo_contable`.`Id`)\n    INNER JOIN `rh_tipo_categoria` \n        ON (`rh_activos`.`Id_Categoria` = `rh_tipo_categoria`.`Id`)\n    INNER JOIN `rh_tipo_ubicacion` \n        ON (`rh_activos`.`Id_Ubicacion` = `rh_tipo_ubicacion`.`Id`)\n    INNER JOIN `rh_tipo_marca` \n        ON (`rh_activos`.`Id_Marca` = `rh_tipo_marca`.`Id`)\n    WHERE(`rh_activos`.`Estado` IN (" + Estado + "))\nORDER BY `NCategoria` ASC, `NUbicacion` ASC, `Nombre` ASC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
