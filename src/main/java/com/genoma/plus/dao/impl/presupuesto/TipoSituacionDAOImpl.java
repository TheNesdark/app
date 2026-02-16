package com.genoma.plus.dao.impl.presupuesto;

import com.genoma.plus.dao.presupuesto.TipoSituacionDAO;
import com.genoma.plus.dto.presupuesto.TipoSituacionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/TipoSituacionDAOImpl.class */
public class TipoSituacionDAOImpl implements TipoSituacionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.TipoSituacionDAO
    public List<Object[]> listaTipoSituacion() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.TipoSituacionDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), Boolean.valueOf(rs.getBoolean(4))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query("SELECT `Id`,`Codigo`,`Nombre`,`Estado` FROM `pp_tipo_situacion`;", mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.presupuesto.TipoSituacionDAO
    public String mCreate(TipoSituacionDTO xTipoSituacionDTO) {
        String result = "se Inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `pp_tipo_situacion` (`Codigo`,`Nombre`,`Estado`,`IdUsuarioS`) VALUES (?,?,?,?);", new Object[]{xTipoSituacionDTO.getCodigo(), xTipoSituacionDTO.getNombre(), Boolean.valueOf(xTipoSituacionDTO.isEstado()), xTipoSituacionDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.TipoSituacionDAO
    public String mUpdate(TipoSituacionDTO xTipoSituacionDTO) {
        String result = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `pp_tipo_situacion` SET`Codigo`=?,`Nombre`=?,`Estado`=?,`IdUsuarioS`=? WHERE `Id`=?;", new Object[]{xTipoSituacionDTO.getCodigo(), xTipoSituacionDTO.getNombre(), Boolean.valueOf(xTipoSituacionDTO.isEstado()), xTipoSituacionDTO.getIdUsuario(), Integer.valueOf(xTipoSituacionDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }
}
