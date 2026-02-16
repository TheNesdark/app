package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.PEADGraficaColorRangoAreaDAO;
import com.genoma.plus.dto.historia.PEADGraficaColorRangoAreaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/PEADGraficaColorRangoAreaDAOImpl.class */
public class PEADGraficaColorRangoAreaDAOImpl implements PEADGraficaColorRangoAreaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.PEADGraficaColorRangoAreaDAO
    public List<Object[]> listaGraficaColorRangoArea() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.PEADGraficaColorRangoAreaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), rs.getString(3), Integer.valueOf(rs.getInt(4)), rs.getString(5), Integer.valueOf(rs.getInt(6)), rs.getString(7), Integer.valueOf(rs.getInt(8)), Integer.valueOf(rs.getInt(9)), Boolean.valueOf(rs.getBoolean(10))};
                return fila;
            }
        };
        List<Object[]> listaGraficaColorRangoArea = this.jdbcTemplate.query("SELECT\n    `p_ead_grafica_color_rango_area`.`id`\n    , `p_ead_grafica_color_rango_area`.`rango_id`\n    , `p_ead_rango_edad`.`nombre`\n    , `p_ead_grafica_color_rango_area`.`area_id`\n    , `p_ead_area`.`nombre`\n    , `p_ead_grafica_color_rango_area`.`color_id`\n    , `p_ead_grafica_color`.`nombre`\n    , `p_ead_grafica_color_rango_area`.`rangoInicio`\n    , `p_ead_grafica_color_rango_area`.`rangoFin`\n    , `p_ead_grafica_color_rango_area`.`estado`\nFROM\n    `baseserver`.`p_ead_grafica_color_rango_area`\n    INNER JOIN `baseserver`.`p_ead_area` \n        ON (`p_ead_grafica_color_rango_area`.`area_id` = `p_ead_area`.`id`)\n    INNER JOIN `baseserver`.`p_ead_grafica_color` \n        ON (`p_ead_grafica_color_rango_area`.`color_id` = `p_ead_grafica_color`.`id`)\n    INNER JOIN `baseserver`.`p_ead_rango_edad` \n        ON (`p_ead_grafica_color_rango_area`.`rango_id` = `p_ead_rango_edad`.`id`);", mapper);
        return listaGraficaColorRangoArea;
    }

    @Override // com.genoma.plus.dao.historia.PEADGraficaColorRangoAreaDAO
    public String mCreate(PEADGraficaColorRangoAreaDTO graficoColorRangoArea) {
        String resultado = "Se inserto correctamente ";
        int ctos = this.jdbcTemplate.update("INSERT INTO `p_ead_grafica_color_rango_area` (`rango_id`,`area_id`,`color_id`,`rangoInicio`,`rangoFin`,`estado`,`usuarioS`) VALUES (?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(graficoColorRangoArea.getRangoId()), Integer.valueOf(graficoColorRangoArea.getAreaId()), Integer.valueOf(graficoColorRangoArea.getColorId()), Integer.valueOf(graficoColorRangoArea.getRangoInicio()), Integer.valueOf(graficoColorRangoArea.getRangoFin()), Boolean.valueOf(graficoColorRangoArea.isEstado()), graficoColorRangoArea.getUsuarioS()});
        if (ctos == 0) {
            resultado = "No se inserto correctamente";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.PEADGraficaColorRangoAreaDAO
    public String mUpdate(PEADGraficaColorRangoAreaDTO graficoColorRangoArea) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
