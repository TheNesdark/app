package com.genoma.plus.dao.impl.parametrizacion;

import com.genoma.plus.dao.parametrizacion.ProcedimientoPorCentroDeCostoDAO;
import com.genoma.plus.dto.parametrizacion.ProcedimientoPorCentroDeCostoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/parametrizacion/ProcedimientoPorCentroDeCostoDAOImpl.class */
public class ProcedimientoPorCentroDeCostoDAOImpl implements ProcedimientoPorCentroDeCostoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.parametrizacion.ProcedimientoPorCentroDeCostoDAO
    public List<Object[]> listProcedimientoPorCentroCosto(String filtro) {
        String xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, f_centrocosto.`Id` , f_centrocosto.Nbre,f_procedimcentrocosto.CDebito, f_procedimcentrocosto.CCredito,  f_procedimcentrocosto.Estado FROM baseserver.f_procedimcentrocosto \nINNER JOIN baseserver.f_centrocosto \nON (f_procedimcentrocosto.Id_CentroCosto = f_centrocosto.Id)\nINNER JOIN baseserver.`g_procedimiento`\nON (f_procedimcentrocosto.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nWHERE (f_procedimcentrocosto.Id_Procedimiento ='" + filtro + "') \nORDER BY f_centrocosto.Nbre ASC ";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.ProcedimientoPorCentroDeCostoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), Boolean.valueOf(rs.getBoolean(7))};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.parametrizacion.ProcedimientoPorCentroDeCostoDAO
    public void addProcedimientoPorCentroCosto(ProcedimientoPorCentroDeCostoDTO procedimientoPorCentroDeCostoDTO) {
        this.jdbcTemplate.update(" INSERT INTO `f_procedimcentrocosto`(`Id_Procedimiento`,`Id_CentroCosto`,`CDebito`,`CCredito`,`Estado`,`UsuarioS`) VALUES (?,?,?,?,?,?)", new Object[]{Integer.valueOf(procedimientoPorCentroDeCostoDTO.getId_Procedimiento()), Integer.valueOf(procedimientoPorCentroDeCostoDTO.getId_CentroCosto()), procedimientoPorCentroDeCostoDTO.getCDebito(), procedimientoPorCentroDeCostoDTO.getCCredito(), Boolean.valueOf(procedimientoPorCentroDeCostoDTO.isEstado()), procedimientoPorCentroDeCostoDTO.getUsuarioS()});
    }

    @Override // com.genoma.plus.dao.parametrizacion.ProcedimientoPorCentroDeCostoDAO
    public void updateProcedimientoPorCentroCosto(ProcedimientoPorCentroDeCostoDTO procedimientoPorCentroDeCostoDTO) {
        this.jdbcTemplate.update(" UPDATE `f_procedimcentrocosto` SET `CDebito` = ?,`CCredito` = ?,`Estado` = ?,`UsuarioS`= ? WHERE (`Id_Procedimiento` = ? AND `Id_CentroCosto` = ? )", new Object[]{procedimientoPorCentroDeCostoDTO.getCDebito(), procedimientoPorCentroDeCostoDTO.getCCredito(), Boolean.valueOf(procedimientoPorCentroDeCostoDTO.isEstado()), procedimientoPorCentroDeCostoDTO.getUsuarioS(), Integer.valueOf(procedimientoPorCentroDeCostoDTO.getId_Procedimiento()), Integer.valueOf(procedimientoPorCentroDeCostoDTO.getId_CentroCosto())});
    }

    @Override // com.genoma.plus.dao.parametrizacion.ProcedimientoPorCentroDeCostoDAO
    public List<Object[]> listCentroDeCosto() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.ProcedimientoPorCentroDeCostoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT `Id`,`Nbre` FROM `baseserver`.`f_centrocosto`", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.parametrizacion.ProcedimientoPorCentroDeCostoDAO
    public List<Object[]> listProcedimientoEnCentroCosto(String idProcedimiento, String idCentroCosto) {
        String xsql = "SELECT `g_procedimiento`.`Id`, `g_procedimiento`.`Nbre`, f_centrocosto.`Id` , f_centrocosto.Nbre,f_procedimcentrocosto.CDebito, f_procedimcentrocosto.CCredito,f_procedimcentrocosto.Estado FROM baseserver.f_procedimcentrocosto INNER JOIN baseserver.f_centrocosto ON (f_procedimcentrocosto.Id_CentroCosto = f_centrocosto.Id)INNER JOIN baseserver.`g_procedimiento`ON (f_procedimcentrocosto.`Id_Procedimiento` = `g_procedimiento`.`Id`)WHERE (f_procedimcentrocosto.Id_Procedimiento ='" + idProcedimiento + "' AND `f_procedimcentrocosto`.`Id_CentroCosto`='" + idCentroCosto + "' ) ORDER BY f_centrocosto.Nbre ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.ProcedimientoPorCentroDeCostoDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), Boolean.valueOf(rs.getBoolean(7))};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
