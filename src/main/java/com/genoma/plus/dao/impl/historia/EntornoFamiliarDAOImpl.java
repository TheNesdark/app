package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.EntornoFamiliarDAO;
import com.genoma.plus.dto.historia.EntornoFamiliarDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/EntornoFamiliarDAOImpl.class */
public class EntornoFamiliarDAOImpl implements EntornoFamiliarDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.EntornoFamiliarDAO
    public List<EntornoFamiliarDTO> listadoEntorno() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.EntornoFamiliarDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                EntornoFamiliarDTO fila = new EntornoFamiliarDTO();
                fila.setId(rs.getInt(1));
                fila.setNombre(rs.getString(2));
                fila.setEstado(rs.getBoolean(3));
                fila.setFecha(rs.getString(4));
                fila.setIdUsuario(Long.valueOf(rs.getLong(5)));
                return fila;
            }
        };
        List<EntornoFamiliarDTO> listadoEntorno = this.jdbcTemplate.query("SELECT `Id`,`Nbre`,`Estado`,`Fecha`,`Id_UsuarioS` FROM `g_entorno_familiar`", mapper);
        return listadoEntorno;
    }

    @Override // com.genoma.plus.dao.historia.EntornoFamiliarDAO
    public String mCrear(EntornoFamiliarDTO xEntornoF) {
        String result = "Datos insertado";
        int ctos = this.jdbcTemplate.update("INSERT INTO `g_entorno_familiar` (`Nbre`,`Estado`,`Id_UsuarioS`) VALUES (?,?,?)", new Object[]{xEntornoF.getNombre(), Boolean.valueOf(xEntornoF.isEstado()), xEntornoF.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo Insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.historia.EntornoFamiliarDAO
    public String mUpdate(EntornoFamiliarDTO xEntornoF) {
        String sql = "UPDATE `g_entorno_familiar` SET `Nbre` =?,`Estado`=?,`Id_UsuarioS`=? WHERE `Id`=?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xEntornoF.getNombre(), Boolean.valueOf(xEntornoF.isEstado()), xEntornoF.getIdUsuario(), Integer.valueOf(xEntornoF.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
