package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.PEADAreaDAO;
import com.genoma.plus.dto.historia.PEADAreaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/PEADAreaDAOImpl.class */
public class PEADAreaDAOImpl implements PEADAreaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.PEADAreaDAO
    public List<PEADAreaDTO> listaArea() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.PEADAreaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                PEADAreaDTO fila = new PEADAreaDTO();
                fila.setId(rs.getInt(1));
                fila.setCodigo(rs.getString(2));
                fila.setNombre(rs.getString(3));
                fila.setOrden(rs.getInt(4));
                fila.setEstado(rs.getBoolean(5));
                return fila;
            }
        };
        List<PEADAreaDTO> listaArea = this.jdbcTemplate.query("SELECT `id`,`codigo`,`nombre`,`orden`,`estado` FROM `p_ead_area`;", mapper);
        return listaArea;
    }

    @Override // com.genoma.plus.dao.historia.PEADAreaDAO
    public String mCreate(PEADAreaDTO areadto) {
        String resultado = "se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `codigo`,`nombre`,`orden`,`estado`,`usuarioS` VALUES (?,?,?,?,?);", new Object[]{areadto.getCodigo(), areadto.getNombre(), Integer.valueOf(areadto.getOrden()), Boolean.valueOf(areadto.isEstado()), areadto.getUsuarioS()});
        if (ctos == 0) {
            resultado = "no se pudo insertar correctamente";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.PEADAreaDAO
    public String mUpdate(PEADAreaDTO areadto) {
        String resultado = "se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE SET `codigo`= ?,`nombre`= ?,`orden`= ?,`estado`= ?,`usuarioS`= ? WHERE `id`= ?;", new Object[]{areadto.getCodigo(), areadto.getNombre(), Integer.valueOf(areadto.getOrden()), Boolean.valueOf(areadto.isEstado()), areadto.getUsuarioS(), Integer.valueOf(areadto.getId())});
        if (ctos == 0) {
            resultado = "No se pudo actualizar correctamente";
        }
        return resultado;
    }
}
