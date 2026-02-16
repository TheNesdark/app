package com.genoma.plus.dao.impl.presupuesto;

import com.genoma.plus.dao.presupuesto.TipoDestinacionDAO;
import com.genoma.plus.dto.presupuesto.TipoDestinacionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/TipoDestinacionDAOImpl.class */
public class TipoDestinacionDAOImpl implements TipoDestinacionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.TipoDestinacionDAO
    public List<Object[]> listaTipoDestinacion() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.TipoDestinacionDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), Boolean.valueOf(rs.getBoolean(4))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query("SELECT `Id`,`Codigo`,`Nombre`,`Estado` FROM `pp_tipo_destinacion`;", mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.presupuesto.TipoDestinacionDAO
    public String mCreate(TipoDestinacionDTO xTipoDestinacionDTO) {
        String result = "se Inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `pp_tipo_destinacion` (`Codigo`,`Nombre`,`Estado`,`Id_UsuarioS`) VALUES (?,?,?,?);", new Object[]{xTipoDestinacionDTO.getCodigo(), xTipoDestinacionDTO.getNombre(), Boolean.valueOf(xTipoDestinacionDTO.isEstado()), xTipoDestinacionDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.TipoDestinacionDAO
    public String mUpdate(TipoDestinacionDTO xTipoDestinacionDTO) {
        String result = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `pp_tipo_destinacion` SET `Codigo`=?,`Nombre`=?,`Estado`=?,`Id_UsuarioS`=? WHERE `Id`=?;", new Object[]{xTipoDestinacionDTO.getCodigo(), xTipoDestinacionDTO.getNombre(), Boolean.valueOf(xTipoDestinacionDTO.isEstado()), xTipoDestinacionDTO.getIdUsuario(), Integer.valueOf(xTipoDestinacionDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }
}
