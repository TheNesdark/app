package com.genoma.plus.dao.impl.presupuesto;

import com.genoma.plus.dao.presupuesto.RubrosContraloriaDAO;
import com.genoma.plus.dto.presupuesto.RubrosContraloriaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/presupuesto/RubrosContraloriaDAOImpl.class */
public class RubrosContraloriaDAOImpl implements RubrosContraloriaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.presupuesto.RubrosContraloriaDAO
    public List<Object[]> listaRubroContraloria() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.RubrosContraloriaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), Boolean.valueOf(rs.getBoolean(3)), rs.getString(4), Boolean.valueOf(rs.getBoolean(5))};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query("SELECT `Codigo`,`Nombre`,`UltimoNivel`,`IdPadre`,`Estado` FROM `pp_rubros_contraloria`", mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.presupuesto.RubrosContraloriaDAO
    public String mCreate(RubrosContraloriaDTO xRubrosContraloriaDTO) {
        String result = "se Inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `pp_rubros_contraloria` (`Codigo`,`Nombre`,`UltimoNivel`,`IdPadre`,`Estado`,`IdUsuarioS`) VALUES (?,?,?,?,?,?,?);", new Object[]{xRubrosContraloriaDTO.getCodigo(), xRubrosContraloriaDTO.getNombre(), xRubrosContraloriaDTO.getTipo(), Integer.valueOf(xRubrosContraloriaDTO.getUltimoNivel()), xRubrosContraloriaDTO.getIdPadre(), Boolean.valueOf(xRubrosContraloriaDTO.isEstado()), xRubrosContraloriaDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.RubrosContraloriaDAO
    public String mUpdate(RubrosContraloriaDTO xRubrosContraloriaDTO) {
        String result = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `pp_rubros_contraloria` SET `Nombre`=?,`UltimoNivel`=?,`IdPadre`=?,`Estado`=?,`IdUsuarioS`=? WHERE `Codigo`=?;", new Object[]{xRubrosContraloriaDTO.getNombre(), Integer.valueOf(xRubrosContraloriaDTO.getUltimoNivel()), xRubrosContraloriaDTO.getIdPadre(), Boolean.valueOf(xRubrosContraloriaDTO.isEstado()), xRubrosContraloriaDTO.getIdUsuario(), xRubrosContraloriaDTO.getCodigo()});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.presupuesto.RubrosContraloriaDAO
    public boolean ValidarExistencia(String codigo) {
        String sql = "SELECT `Codigo` FROM `pp_rubros_contraloria` WHERE `Codigo` = '" + codigo + "';";
        boolean resul = false;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.RubrosContraloriaDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object res = rs.getString(1);
                return res;
            }
        };
        List<Object> lista = this.jdbcTemplate.query(sql, mapper);
        if (lista.size() > 0) {
            resul = true;
        }
        return resul;
    }

    @Override // com.genoma.plus.dao.presupuesto.RubrosContraloriaDAO
    public List<Object[]> filtroRubrosContraloria(String filtro) {
        String sql = "SELECT `Codigo`,`Nombre` FROM `pp_rubros_contraloria` WHERE (`UltimoNivel`= 1\n AND ((`Codigo` LIKE '%" + filtro + "%') OR \n(`Nombre` LIKE '%" + filtro + "%')));";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.presupuesto.RubrosContraloriaDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> listaF = this.jdbcTemplate.query(sql, mapper);
        return listaF;
    }
}
