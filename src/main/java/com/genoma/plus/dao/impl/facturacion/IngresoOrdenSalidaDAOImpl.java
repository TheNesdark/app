package com.genoma.plus.dao.impl.facturacion;

import com.genoma.plus.dao.facturacion.IngresoOrdenSalidaDAO;
import com.genoma.plus.dto.facturacion.IngresoOrdenSalidaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/IngresoOrdenSalidaDAOImpl.class */
public class IngresoOrdenSalidaDAOImpl implements IngresoOrdenSalidaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoOrdenSalidaDAO
    public List<IngresoOrdenSalidaDTO> mListarOrdenSalida(Long xidingreso) {
        String sql = "SELECT `Id`, `FechaS`, `HoraS`, `Observacion`, IdUsuarioRH FROM `ingreso_orden_salida` WHERE (`Id_Ingreso` ='" + xidingreso + "' AND `Estado` =1);";
        System.out.println("listarorden salida -> " + sql);
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoOrdenSalidaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                IngresoOrdenSalidaDTO orden = new IngresoOrdenSalidaDTO();
                orden.setId(Long.valueOf(rs.getLong("Id")));
                orden.setFechaS(rs.getString("FechaS"));
                orden.setHoraS(rs.getString("HoraS"));
                orden.setObservacion(rs.getString("Observacion"));
                orden.setIdUsuarioRH(Long.valueOf(rs.getLong("IdUsuarioRH")));
                return orden;
            }
        };
        List<IngresoOrdenSalidaDTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoOrdenSalidaDAO
    public String create_return_id(final IngresoOrdenSalidaDTO Orden) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoOrdenSalidaDAOImpl.2
            final String sql = "INSERT INTO `ingreso_orden_salida` (`Id_Ingreso`, `FechaS`, `HoraS`, `IdUsuarioRH`, `Observacion`)\nVALUES (?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `ingreso_orden_salida` (`Id_Ingreso`, `FechaS`, `HoraS`, `IdUsuarioRH`, `Observacion`)\nVALUES (?,?,?,?,?);", 1);
                ps.setLong(1, Orden.getIdIngreso().longValue());
                ps.setString(2, Orden.getFechaS());
                ps.setString(3, Orden.getHoraS());
                ps.setLong(4, Orden.getIdUsuarioRH().longValue());
                ps.setString(5, Orden.getObservacion());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdDoc = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIngresoOrdenSalida-->" + xIdDoc);
        return xIdDoc;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoOrdenSalidaDAO
    public IngresoOrdenSalidaDTO consultarEstadoLiquidacion(long idIngreso) {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoOrdenSalidaDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                IngresoOrdenSalidaDTO orden = new IngresoOrdenSalidaDTO();
                orden.setIdIngreso(Long.valueOf(rs.getLong("Id_Ingreso")));
                orden.setNumFactura(rs.getString("NFactura"));
                orden.setFechaFactura(rs.getString("FechaFac"));
                orden.setEstado(rs.getInt("Estado"));
                orden.setFechaFacturaEvento(rs.getString("Fecha_FacturaEvento"));
                return orden;
            }
        };
        return (IngresoOrdenSalidaDTO) this.jdbcTemplate.queryForObject("SELECT  `f_liquidacion`.`Id_Ingreso` , \nIF(`f_empresacontxconvenio`.`EsCapitado`=2, IF(`f_factura_evento`.`Prefijo`='',`f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,'-',`f_factura_evento`.`No_FacturaEvento`)), `f_factura_capita`.`No_FacturaCapita`) AS `NFactura` , \nIF(`f_empresacontxconvenio`.`EsCapitado`=2,DATE_FORMAT(`f_factura_evento`.`Fecha_FacturaEvento`,'%d-%m-%Y'), \nDATE_FORMAT(`f_factura_capita`.`Fecha_FacturaCapita`,'%d-%m-%Y')) AS `FechaFac` , \nIF(`f_empresacontxconvenio`.`EsCapitado`=2,`f_factura_evento`.`EstaArmada`,  `f_factura_capita`.`EstaArmada`) AS `Estado` \n,f_factura_evento.Fecha_FacturaEvento\nFROM `f_liquidacion`  \nLEFT JOIN `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) \nLEFT JOIN `f_factura_capita`  ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`) \nINNER JOIN `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) \nINNER JOIN `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) \nINNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN `g_ips`  ON (`g_ips`.`Id` = `f_empresacontxconvenio`.`Id_GIps`) \nWHERE (`f_liquidacion`.`Id_Ingreso` =? AND `f_liquidacion`.`Estado` =0)", rowMapper, new Object[]{Long.valueOf(idIngreso)});
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoOrdenSalidaDAO
    public String anular(IngresoOrdenSalidaDTO xIngresoOrdenSalidaDTO) {
        String sql = "UPDATE `ingreso_orden_salida` SET Estado=?,`DetalleAnulacion`=?,`UsuarioAnulacion`=?, `FechaAnulacion`=? WHERE Id=?";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xIngresoOrdenSalidaDTO.getEstado()), xIngresoOrdenSalidaDTO.getDetalleAnulacion(), xIngresoOrdenSalidaDTO.getUsuarioAnulacion(), xIngresoOrdenSalidaDTO.getFechaAnulacion(), xIngresoOrdenSalidaDTO.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoOrdenSalidaDAO
    public void actualizar(IngresoOrdenSalidaDTO xIngresoOrdenSalidaDTO) {
        String xsql = "update ingreso_orden_salida set `FechaS`='" + xIngresoOrdenSalidaDTO.getFechaS() + "', `HoraS`='" + xIngresoOrdenSalidaDTO.getHoraS() + "', `Observacion`='" + xIngresoOrdenSalidaDTO.getObservacion() + "' where Id='" + xIngresoOrdenSalidaDTO.getId() + "'";
        this.jdbcTemplate.update(xsql);
    }
}
