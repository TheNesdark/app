package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.PyP_EAD_DAO;
import com.genoma.plus.dto.historia.EADRangoColoresDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/PyP_EAD_DAOImpl.class */
public class PyP_EAD_DAOImpl implements PyP_EAD_DAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.PyP_EAD_DAO
    public List<EADRangoColoresDTO> getRangoColores(int idRango) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.PyP_EAD_DAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                EADRangoColoresDTO rc = new EADRangoColoresDTO();
                rc.setId(rs.getInt("id"));
                rc.setRangoId(rs.getInt("rango_id"));
                rc.setAreaId(rs.getInt("area_id"));
                rc.setColorId(rs.getInt("color_id"));
                rc.setRangoInicio(rs.getInt("rangoInicio"));
                rc.setRangoFinal(rs.getInt("rangoFin"));
                rc.setColor(rs.getString("color"));
                rc.setCodigoArea(rs.getString("codigoArea"));
                return rc;
            }
        };
        List<EADRangoColoresDTO> listadoRelacionesF = this.jdbcTemplate.query("select  p_ead_grafica_color_rango_area.*,p_ead_grafica_color.color,p_ead_area.codigo as codigoArea from p_ead_grafica_color_rango_area\ninner join p_ead_area on (p_ead_grafica_color_rango_area.area_id=p_ead_area.id)\ninner join p_ead_grafica_color on (p_ead_grafica_color_rango_area.color_id=p_ead_grafica_color.id)\nwhere p_ead_grafica_color_rango_area.rango_id=? and p_ead_grafica_color_rango_area.estado=1\norder by p_ead_area.orden asc", mapper, new Object[]{Integer.valueOf(idRango)});
        return listadoRelacionesF;
    }
}
