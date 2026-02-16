package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ValeEstructurasDAO;
import com.genoma.plus.dto.historia.ValeEstructurasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ValeEstructurasDAOImpl.class */
public class ValeEstructurasDAOImpl implements ValeEstructurasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ValeEstructurasDAO
    public List<Object[]> listaValeEstructuras() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ValeEstructurasDAOImpl.1
            public Object mapRow(ResultSet rs, int row) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), Boolean.valueOf(rs.getBoolean(3))};
                return fila;
            }
        };
        List<Object[]> listaValeEstructuras = this.jdbcTemplate.query("SELECT `id`,`condicion_estructurales`,`estado` FROM `h_p_vale_estructuras`", mapper);
        return listaValeEstructuras;
    }

    @Override // com.genoma.plus.dao.historia.ValeEstructurasDAO
    public String mCreate(ValeEstructurasDTO valeEstructurasDTO) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_p_vale_estructuras` (`condicion_estructurales`,`estado`,`id_usuario`) VALUES (?,?,?);", new Object[]{valeEstructurasDTO.getCondicionEstructurales(), Boolean.valueOf(valeEstructurasDTO.isEstado()), Integer.valueOf(valeEstructurasDTO.getIdUsuario())});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.historia.ValeEstructurasDAO
    public String mUpdate(ValeEstructurasDTO valeEstructurasDTO) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_p_vale_estructuras` SET `condicion_estructurales`=?,`estado`=?,`id_usuario`=?,`fecha`=?, WHERE `id`=?", new Object[]{valeEstructurasDTO.getCondicionEstructurales(), Boolean.valueOf(valeEstructurasDTO.isEstado()), Integer.valueOf(valeEstructurasDTO.getIdUsuario()), valeEstructurasDTO.getFecha(), Integer.valueOf(valeEstructurasDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }
}
