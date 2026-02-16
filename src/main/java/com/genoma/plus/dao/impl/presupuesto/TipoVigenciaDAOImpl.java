package com.genoma.plus.dao.impl.presupuesto;

import com.genoma.plus.dao.presupuesto.TipoVigenciaDAO;
import com.genoma.plus.dto.presupuesto.TipoVigenciaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/TipoVigenciaDAOImpl.class */
public class TipoVigenciaDAOImpl implements TipoVigenciaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.TipoVigenciaDAO
    public List<Object[]> listaTipoVigencia() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.TipoVigenciaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), Boolean.valueOf(rs.getBoolean(4))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query("SELECT `Id`,`Codigo`,`Nombre`,`Estado` FROM `pp_tipo_vigencia`;", mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.presupuesto.TipoVigenciaDAO
    public String mCreate(TipoVigenciaDTO xTipoVigenciaDTO) {
        String result = "se Inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `pp_tipo_vigencia` (`Codigo`,`Nombre`,`Estado`,`IdUsuarioS`) VALUES (?,?,?,?);", new Object[]{xTipoVigenciaDTO.getCodigo(), xTipoVigenciaDTO.getNombre(), Boolean.valueOf(xTipoVigenciaDTO.isEstado()), xTipoVigenciaDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.TipoVigenciaDAO
    public String mUpdate(TipoVigenciaDTO xTipoVigenciaDTO) {
        String result = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `pp_tipo_vigencia` SET `Codigo`=?,`Nombre`=?,`Estado`=?,`IdUsuarioS`=? WHERE `Id`=?;", new Object[]{xTipoVigenciaDTO.getCodigo(), xTipoVigenciaDTO.getNombre(), Boolean.valueOf(xTipoVigenciaDTO.isEstado()), xTipoVigenciaDTO.getIdUsuario(), Integer.valueOf(xTipoVigenciaDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }
}
