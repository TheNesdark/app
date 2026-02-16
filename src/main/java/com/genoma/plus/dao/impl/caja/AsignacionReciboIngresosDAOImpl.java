package com.genoma.plus.dao.impl.caja;

import Acceso.Principal;
import com.genoma.plus.dao.caja.AsignacionReciboIngresosDAO;
import com.genoma.plus.dto.caja.AsignacionReciboIngresosDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/caja/AsignacionReciboIngresosDAOImpl.class */
public class AsignacionReciboIngresosDAOImpl implements AsignacionReciboIngresosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.caja.AsignacionReciboIngresosDAO
    public List<AsignacionReciboIngresosDTO> ListRecibosUsuario(String documento) {
        String sql = "SELECT\n    `k_recibos`.`Id`\n    , `k_caja`.`Nbre` AS NCaja\n    , `k_recibos`.`NoRecibo`\n    , `k_recibos`.`Fecha_Recibo`\n    , `k_conceptos`.`Nbre` AS Concepto\n    , `k_itemrecibos`.`Cantidad`\n    , `k_itemrecibos`.`VrUnitario`\n    , (`k_itemrecibos`.`Cantidad`*`k_itemrecibos`.`VrUnitario`) AS VTotal\n    , `k_recibos`.`Id_Ingreso`\n    , `k_recibos`.`NoFactura`\nFROM\n    `k_itemrecibos`\n    INNER JOIN `k_recibos` \n        ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`)\n    INNER JOIN `k_conceptos` \n        ON (`k_itemrecibos`.`Id_Concepto` = `k_conceptos`.`Id`)\n    INNER JOIN `k_caja` \n        ON (`k_recibos`.`Id_Caja` = `k_caja`.`Id`)\nWHERE (`k_recibos`.`Estado` =0\n    AND CONCAT(`k_recibos`.`Id_TipoDocumento`,' ',`k_recibos`.`Identificacion`) ='" + documento + "')\nORDER BY `k_recibos`.`Id` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.caja.AsignacionReciboIngresosDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                AsignacionReciboIngresosDTO Lista = new AsignacionReciboIngresosDTO();
                Lista.setId(Long.valueOf(rs.getLong("Id")));
                Lista.setCaja(rs.getString("NCaja"));
                Lista.setNRecibo(rs.getString("NoRecibo"));
                Lista.setFecha(rs.getString("Fecha_Recibo"));
                Lista.setConcepto(rs.getString("Concepto"));
                Lista.setCantidad(rs.getInt("Cantidad"));
                Lista.setVUnitario(Double.valueOf(rs.getDouble("VrUnitario")));
                Lista.setVTotal(Double.valueOf(rs.getDouble("VTotal")));
                Lista.setIdIngreso(Long.valueOf(rs.getLong("Id_Ingreso")));
                Lista.setNFactura(rs.getString("NoFactura"));
                return Lista;
            }
        };
        List<AsignacionReciboIngresosDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.caja.AsignacionReciboIngresosDAO
    public List<GCGenericoDTO> listaComboIngresos(String xidPersona) {
        String sql = "SELECT `Id`, CONCAT(`Id`,' - ',`FechaIngreso`,' ', `HoraIngreso`) AS Ingreso\nFROM `ingreso` WHERE (`Estado` =0 AND `Id_Usuario` ='" + xidPersona + "') ORDER BY `Id` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.caja.AsignacionReciboIngresosDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GCGenericoDTO Lista = new GCGenericoDTO();
                Lista.setId(rs.getLong("Id"));
                Lista.setNombre(rs.getString("Ingreso"));
                return Lista;
            }
        };
        List<GCGenericoDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.caja.AsignacionReciboIngresosDAO
    public String updateReciboxIngreso(AsignacionReciboIngresosDTO xAsignacion) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `k_recibos`\nSET `Id_Ingreso` = ?,\n  `UsuarioS` = ?\nWHERE `Id` = ?;", new Object[]{xAsignacion.getIdIngreso(), Principal.usuarioSistemaDTO.getLogin(), xAsignacion.getId()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }
}
