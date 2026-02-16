package com.genoma.plus.dao.impl.presupuesto;

import com.genoma.plus.dao.presupuesto.FinalidadGastoDAO;
import com.genoma.plus.dto.presupuesto.FinalidadGastoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/FinalidadGastoDAOImpl.class */
public class FinalidadGastoDAOImpl implements FinalidadGastoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.FinalidadGastoDAO
    public List<Object[]> listaFinalidadGasto() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.FinalidadGastoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), Boolean.valueOf(rs.getBoolean(5))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query("SELECT `Id`,`Codigo`,`Nombre`,`Observacion`,`Estado` FROM `pp_finalidad_gasto`", mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.presupuesto.FinalidadGastoDAO
    public String mCreate(FinalidadGastoDTO xFinalidadGastoDTO) {
        String result = "se Inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `pp_finalidad_gasto` (`Codigo`,`Nombre`,`Observacion`,`Estado`,`IdUsuarioS`) VALUES (?,?,?,?,?)", new Object[]{xFinalidadGastoDTO.getCodigo(), xFinalidadGastoDTO.getNombre(), xFinalidadGastoDTO.getObservacion(), Boolean.valueOf(xFinalidadGastoDTO.isEstado()), xFinalidadGastoDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.FinalidadGastoDAO
    public String mUpdate(FinalidadGastoDTO xFinalidadGastoDTO) {
        String result = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `pp_finalidad_gasto` SET `Codigo`=?,`Nombre`=?,`Observacion`=?,`Estado`=?,`IdUsuarioS`=?  WHERE `Id` =?;", new Object[]{xFinalidadGastoDTO.getCodigo(), xFinalidadGastoDTO.getNombre(), xFinalidadGastoDTO.getObservacion(), Boolean.valueOf(xFinalidadGastoDTO.isEstado()), xFinalidadGastoDTO.getIdUsuario(), Integer.valueOf(xFinalidadGastoDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }
}
