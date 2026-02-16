package com.genoma.plus.dao.impl.presupuesto;

import com.genoma.plus.dao.presupuesto.EntidadesContraloriaDAO;
import com.genoma.plus.dto.presupuesto.EntidadesContraloriaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/EntidadesContraloriaDAOImpl.class */
public class EntidadesContraloriaDAOImpl implements EntidadesContraloriaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.EntidadesContraloriaDAO
    public List<Object[]> listaEntidadesContraloria() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.EntidadesContraloriaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), Boolean.valueOf(rs.getBoolean(4))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query("SELECT `Id`,`Codigo`,`Nombre`,`Estado` FROM `pp_entidades_contraloria`;", mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.presupuesto.EntidadesContraloriaDAO
    public String mCreate(EntidadesContraloriaDTO xEntidadesContraloriaDTO) {
        String result = "se Inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `pp_entidades_contraloria` (`Codigo`,`Nombre`,`Estado`,`IdUsuarioS`) VALUES (?,?,?,?);", new Object[]{xEntidadesContraloriaDTO.getCodigo(), xEntidadesContraloriaDTO.getNombre(), Boolean.valueOf(xEntidadesContraloriaDTO.isEstado()), xEntidadesContraloriaDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.EntidadesContraloriaDAO
    public String mUpdate(EntidadesContraloriaDTO xEntidadesContraloriaDTO) {
        String result = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `pp_entidades_contraloria` SET `Codigo`=?,`Nombre`=?,`Estado`=?,`IdUsuarioS`=? WHERE `Id`=?;", new Object[]{xEntidadesContraloriaDTO.getCodigo(), xEntidadesContraloriaDTO.getNombre(), Boolean.valueOf(xEntidadesContraloriaDTO.isEstado()), xEntidadesContraloriaDTO.getIdUsuario(), Integer.valueOf(xEntidadesContraloriaDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }
}
