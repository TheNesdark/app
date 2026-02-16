package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.PEADConversionPDPTDAO;
import com.genoma.plus.dto.historia.PEADConversionPDPTDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/PEADConversionPDPTDAOImpl.class */
public class PEADConversionPDPTDAOImpl implements PEADConversionPDPTDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.PEADConversionPDPTDAO
    public List<Object[]> listaConversionPDPT() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.PEADConversionPDPTDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), Integer.valueOf(rs.getInt(4)), rs.getString(5), Integer.valueOf(rs.getInt(6)), rs.getString(7), Boolean.valueOf(rs.getBoolean(8))};
                return fila;
            }
        };
        List<Object[]> listaConversionPDPT = this.jdbcTemplate.query("SELECT\n    `p_ead_conversion_pd_pt`.`id`\n    , `p_ead_conversion_pd_pt`.`puntuacionDirecta`\n    , `p_ead_conversion_pd_pt`.`puntuacionTipica`\n    , `p_ead_conversion_pd_pt`.`rango_id`\n    , `p_ead_area`.`nombre`\n    , `p_ead_conversion_pd_pt`.`area_id`\n    , `p_ead_rango_edad`.`nombre`\n    , `p_ead_conversion_pd_pt`.`estado`\nFROM\n    `baseserver`.`p_ead_conversion_pd_pt`\n    INNER JOIN `baseserver`.`p_ead_rango_edad` \n        ON (`p_ead_conversion_pd_pt`.`rango_id` = `p_ead_rango_edad`.`id`)\n    INNER JOIN `baseserver`.`p_ead_area` \n        ON (`p_ead_conversion_pd_pt`.`area_id` = `p_ead_area`.`id`);", mapper);
        return listaConversionPDPT;
    }

    @Override // com.genoma.plus.dao.historia.PEADConversionPDPTDAO
    public String mCreate(PEADConversionPDPTDTO conversionPDPT) {
        String resultado = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO  `p_ead_conversion_pd_pt` (`puntuacionDirecta`,`puntuacionTipica`,`rango_id`,`area_id`,`estado`,`usuarioS`) VALUES (?,?,?,?,?,?);", new Object[]{Integer.valueOf(conversionPDPT.getPuntuacionDirecta()), Integer.valueOf(conversionPDPT.getPuntuacionTipicas()), Integer.valueOf(conversionPDPT.getRangoId()), Integer.valueOf(conversionPDPT.getAreaId()), Boolean.valueOf(conversionPDPT.isEstado()), conversionPDPT.getUsuario()});
        if (ctos == 0) {
            resultado = "No se inserto correctamente";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.PEADConversionPDPTDAO
    public String mUpdate(PEADConversionPDPTDTO conversionPDPT) {
        String resultado = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `p_ead_conversion_pd_pt` SET `puntuacionDirecta`=?,`puntuacionTipica`=?,`rango_id`=?,`area_id`=?,`estado`=? WHERE `id` =?;", new Object[]{Integer.valueOf(conversionPDPT.getPuntuacionDirecta()), Integer.valueOf(conversionPDPT.getPuntuacionTipicas()), Integer.valueOf(conversionPDPT.getRangoId()), Integer.valueOf(conversionPDPT.getAreaId()), Boolean.valueOf(conversionPDPT.isEstado()), Integer.valueOf(conversionPDPT.getId())});
        if (ctos == 0) {
            resultado = "No se actualizo correctamente";
        }
        return resultado;
    }
}
