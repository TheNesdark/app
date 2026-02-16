package com.genoma.plus.dao.impl.parametrizacion;

import Acceso.Principal;
import com.genoma.plus.dao.parametrizacion.EmpresaServicioDAO;
import com.genoma.plus.dto.parametrizacion.ConvenioServicioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/parametrizacion/EmpresaServicioDAOImpl.class */
public class EmpresaServicioDAOImpl implements EmpresaServicioDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.parametrizacion.EmpresaServicioDAO
    public List<Object[]> listarEmpresaServicio(Long idConvenio, String grabado) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.EmpresaServicioDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), Double.valueOf(rs.getDouble(4)), Integer.valueOf(rs.getInt(5)), Double.valueOf(rs.getDouble(6)), Integer.valueOf(rs.getInt(7)), Boolean.valueOf(rs.getBoolean(8)), Boolean.valueOf(rs.getBoolean(9)), rs.getString(10), Long.valueOf(rs.getLong(11)), Long.valueOf(rs.getLong(12))};
                return fila;
            }
        };
        String sql = "SELECT\n  `f_tiposervicio`.`Id` AS IdServicio,\n  `f_tiposervicio`.`Nbre` Servicio,\n  IFNULL(d.`Nbre`,'') AS Manual,\n  IFNULL(`d`.`Incr_Decrem`,0) Incr_Decrem,\n  IFNULL(`d`.`Anno`, DATE_FORMAT(NOW(),'%Y')) AS Anno,\n  IFNULL(`d`.`Porcentaje_Descuento`,0) Porcentaje_Descuento,\n  IFNULL(`d`.`NCopias`,0) NCopias,\n  IFNULL(d.AplicaFactor,0) AplicaFactor,\n  IFNULL(`d`.`Estado`,1) Estado,\n  IF(`d`.`Estado` IS NULL, 'SIN CONFIGURAR', IF(`d`.`Estado`=0, 'ACTIVO','INACTIVO')) Grabado,\n  IFNULL(d.`Id_Manual_n`,0) AS IdManual,\n  IFNULL(d.`Bloqueo`,0) AS Bloqueo\n  FROM\n`f_tiposervicio`    \n    LEFT JOIN (SELECT `f_servicioempresaconv`.`Id_Manual_n`,  `f_manual`.`Nbre`,\n  `f_manual`.`AplicaFactor` Bloqueo,\n  `f_servicioempresaconv`.`Incr_Decrem`,\n  `f_servicioempresaconv`.`Anno`,\n  `f_servicioempresaconv`.`Porcentaje_Descuento`,\n  `f_servicioempresaconv`.`NCopias`,\n  `f_servicioempresaconv`.`Estado`,\n  f_servicioempresaconv.AplicaFactor,\n  f_servicioempresaconv.`Id_TipoServicio`\n  FROM `f_servicioempresaconv`\n    LEFT JOIN `f_manual`\n    ON (`f_servicioempresaconv`.`Id_Manual_n` = `f_manual`.`Id`)\n    WHERE (`f_servicioempresaconv`.`Id_EmpresaConvenio` = '" + idConvenio + "')) d ON d.Id_TipoServicio=`f_tiposervicio`.`Id`\n WHERE IF(`d`.`Estado` IS NULL, -1, `d`.`Estado`) IN (" + grabado + ")\nORDER BY Grabado ASC ,f_tiposervicio.Nbre ASC";
        System.out.println("Tab detalle de factura : " + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.parametrizacion.EmpresaServicioDAO
    public void create(ConvenioServicioDTO e) {
        this.jdbcTemplate.update("INSERT INTO `baseserver`.`f_servicioempresaconv` (`Id_TipoServicio`,`Id_EmpresaConvenio`,`Id_Manual_n`,`Incr_Decrem`,`Anno`,`AplicaFactor`,`Porcentaje_Descuento`,`NCopias`,`Estado`,`UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?,?);", new Object[]{Long.valueOf(e.getIdTipoServicio()), Long.valueOf(e.getIdEmpresaConvenio()), Long.valueOf(e.getIdManual()), Double.valueOf(e.getIncrementoDecremento()), Integer.valueOf(e.getAnno()), Boolean.valueOf(e.isAplicaFactor()), Double.valueOf(e.getPorcentajeDescuento()), Integer.valueOf(e.getNCopias()), Boolean.valueOf(e.isEstado()), Principal.usuarioSistemaDTO.getLogin()});
    }

    @Override // com.genoma.plus.dao.parametrizacion.EmpresaServicioDAO
    public void update(ConvenioServicioDTO e) {
        this.jdbcTemplate.update("UPDATE\n  `baseserver`.`f_servicioempresaconv`\nSET\n  `Id_Manual_n` = ?,\n  `Incr_Decrem` = ?,\n  `Anno` = ?,\n  `AplicaFactor` = ?,\n  `Porcentaje_Descuento` = ?,\n  `NCopias` = ?,\n  `Estado` = ?,\n  `UsuarioS` = ?\nWHERE `Id_TipoServicio` = ?\n  AND `Id_EmpresaConvenio` = ?;", new Object[]{Long.valueOf(e.getIdManual()), Double.valueOf(e.getIncrementoDecremento()), Integer.valueOf(e.getAnno()), Boolean.valueOf(e.isAplicaFactor()), Double.valueOf(e.getPorcentajeDescuento()), Integer.valueOf(e.getNCopias()), Boolean.valueOf(e.isEstado()), Principal.usuarioSistemaDTO.getLogin(), Long.valueOf(e.getIdTipoServicio()), Long.valueOf(e.getIdEmpresaConvenio())});
    }
}
