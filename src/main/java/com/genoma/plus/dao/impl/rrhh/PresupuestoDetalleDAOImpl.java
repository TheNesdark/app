package com.genoma.plus.dao.impl.rrhh;

import com.genoma.plus.dao.rrhh.PresupuestoDetalleDAO;
import com.genoma.plus.dto.rrhh.PresupuestoDetalleDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/rrhh/PresupuestoDetalleDAOImpl.class */
public class PresupuestoDetalleDAOImpl implements PresupuestoDetalleDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.rrhh.PresupuestoDetalleDAO
    public List<PresupuestoDetalleDTO> listaPresupuestoDetalle(int idEncabezado) {
        String sql = "SELECT `Id`,`idEncabezado`,`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,`Valor`,`Tipo`,`Observacion`,`NCCobro`,`NFactura`,`Id_ConceptoN`,`Estado` \nFROM `pp_detalle_movimiento` WHERE (`idEncabezado` = " + idEncabezado + " AND `Estado`=1);";
        RowMapper row = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.PresupuestoDetalleDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                PresupuestoDetalleDTO fila = PresupuestoDetalleDTO.builder().id(rs.getInt(1)).idEncabezado(rs.getInt(2)).idMovimiento(rs.getInt(3)).idRubro(rs.getInt(4)).idTercero(rs.getInt(5)).valor(rs.getDouble(6)).tipo(rs.getInt(7)).observacion(rs.getString(8)).nCCObro(rs.getInt(9)).nFactura(rs.getString(10)).idConceptoN(rs.getInt(11)).estado(rs.getBoolean(12)).build();
                return fila;
            }
        };
        List<PresupuestoDetalleDTO> listaDetallePresupuesto = this.jdbcTemplate.query(sql, row);
        return listaDetallePresupuesto;
    }

    @Override // com.genoma.plus.dao.rrhh.PresupuestoDetalleDAO
    public String crearPresupuestoDetalle(PresupuestoDetalleDTO presupuestoDetalleDTO) {
        String resultado = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `pp_detalle_movimiento`( `idEncabezado`,`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,`Valor`,`Tipo`,`Observacion`,`NCCobro`,`NFactura`,`Id_ConceptoN`,`Estado`) \nVALUES (?,?,?,?,?,?, ?,?,?,?,?);", new Object[]{Integer.valueOf(presupuestoDetalleDTO.getIdEncabezado()), Integer.valueOf(presupuestoDetalleDTO.getIdMovimiento()), Integer.valueOf(presupuestoDetalleDTO.getIdRubro()), Integer.valueOf(presupuestoDetalleDTO.getIdTercero()), Double.valueOf(presupuestoDetalleDTO.getValor()), Integer.valueOf(presupuestoDetalleDTO.getTipo()), presupuestoDetalleDTO.getObservacion(), Integer.valueOf(presupuestoDetalleDTO.getNCCObro()), presupuestoDetalleDTO.getNFactura(), Integer.valueOf(presupuestoDetalleDTO.getIdConceptoN()), Boolean.valueOf(presupuestoDetalleDTO.isEstado())});
        if (ctos == 0) {
            resultado = "No se pudo insertar";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.rrhh.PresupuestoDetalleDAO
    public String updatePresupuestoDetalle(PresupuestoDetalleDTO presupuestoDetalleDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
