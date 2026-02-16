package com.genoma.plus.dao.impl.presupuesto;

import com.genoma.plus.dao.presupuesto.OrigenIngresoDAO;
import com.genoma.plus.dto.presupuesto.OrigenIngresoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/OrigenIngresoDAOImpl.class */
public class OrigenIngresoDAOImpl implements OrigenIngresoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.OrigenIngresoDAO
    public List<Object[]> listaOrigenIngreso() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.OrigenIngresoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), Boolean.valueOf(rs.getBoolean(4))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query("SELECT `Id`,`Codigo`,`Nombre`,`Estado` FROM `pp_origen_ingreso`;", mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.presupuesto.OrigenIngresoDAO
    public String mCreate(OrigenIngresoDTO xOrigenIngresoDTO) {
        String result = "se Inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `pp_origen_ingreso` (`Codigo`,`Nombre`,`Estado`,`IdUsuarioS`) VALUES (?,?,?,?);", new Object[]{xOrigenIngresoDTO.getCodigo(), xOrigenIngresoDTO.getNombre(), Boolean.valueOf(xOrigenIngresoDTO.isEstado()), xOrigenIngresoDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.OrigenIngresoDAO
    public String mUpdate(OrigenIngresoDTO xOrigenIngresoDTO) {
        String result = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `pp_origen_ingreso` SET`Codigo`=?,`Nombre`=?,`Estado`=?,`IdUsuarioS`=? WHERE `Id`=?;", new Object[]{xOrigenIngresoDTO.getCodigo(), xOrigenIngresoDTO.getNombre(), Boolean.valueOf(xOrigenIngresoDTO.isEstado()), xOrigenIngresoDTO.getIdUsuario(), Integer.valueOf(xOrigenIngresoDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.OrigenIngresoDAO
    public List<Object[]> listaFiltro(String filtro, String tabla) {
        String sql = "SELECT `Id`,`Codigo`,`Nombre` FROM " + tabla + " WHERE ((`Codigo` LIKE '%" + filtro + "%' OR `Nombre` LIKE '%" + filtro + "%' ) AND `Estado`=1)";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.OrigenIngresoDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3)};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }
}
