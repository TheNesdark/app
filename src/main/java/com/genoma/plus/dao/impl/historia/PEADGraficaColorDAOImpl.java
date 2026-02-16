package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.PEADGraficaColorDAO;
import com.genoma.plus.dto.historia.PEADGraficaColorDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/PEADGraficaColorDAOImpl.class */
public class PEADGraficaColorDAOImpl implements PEADGraficaColorDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.PEADGraficaColorDAO
    public List<PEADGraficaColorDTO> listaGraficaColor() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.PEADGraficaColorDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                PEADGraficaColorDTO fila = new PEADGraficaColorDTO();
                fila.setId(rs.getInt(1));
                fila.setNombre(rs.getString(2));
                fila.setColor(rs.getString(3).charAt(1));
                fila.setEstado(rs.getBoolean(4));
                return fila;
            }
        };
        List<PEADGraficaColorDTO> listaGraficoC = this.jdbcTemplate.query("SELECT `id`,`nombre`,`color`,`estado` WHERE `p_ead_grafica_color`;", mapper);
        return listaGraficoC;
    }

    @Override // com.genoma.plus.dao.historia.PEADGraficaColorDAO
    public String mCreate(PEADGraficaColorDTO graficaColor) {
        String resultado = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `p_ead_grafica_color` ( `nombre`,`color`,`estado`,`usuarioS`) VALUES (?,?,?,?);", new Object[]{graficaColor.getNombre(), Character.valueOf(graficaColor.getColor()), Boolean.valueOf(graficaColor.isEstado()), graficaColor.getUsuarioS()});
        if (ctos == 0) {
            resultado = "No se inserto correctamente";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.PEADGraficaColorDAO
    public String mUpdate(PEADGraficaColorDTO graficacolor) {
        String resultado = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `p_ead_grafica_color` SET `nombre`= ? ,`color`=?,`estado`=?, `usuarioS`=? WHERE `id`=?;", new Object[]{graficacolor.getNombre(), Character.valueOf(graficacolor.getColor()), Boolean.valueOf(graficacolor.isEstado()), graficacolor.getUsuarioS(), Integer.valueOf(graficacolor.getId())});
        if (ctos == 0) {
            resultado = "No se actualizo correctamente";
        }
        return resultado;
    }
}
