package com.genoma.plus.dao.impl.caja;

import Acceso.Principal;
import com.genoma.plus.dao.caja.ReciboEgresosDAO;
import com.genoma.plus.dto.caja.ReciboEgresosDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/caja/ReciboEgresosDAOImpl.class */
public class ReciboEgresosDAOImpl implements ReciboEgresosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.caja.ReciboEgresosDAO
    public List<ReciboEgresosDTO> listaHistoricoReciboEgresos(String xFechaI, String xFechaF, String xidGenerico, int opc) {
        String xsql = "SELECT\n    `k_recibos_egresos`.`Id`\n    , `k_recibos_egresos`.`FechaR`\n    , `k_caja`.`Nbre` AS Caja\n    , `cc_terceros`.`RazonSocialCompleta`\n    , `k_recibos_egresos`.`Observacion`\n    , `k_recibos_egresos`.`IdCierre`\n    , `k_recibos_egresos`.`Estado`\n    , SUM(`k_recibos_egreso_detalle`.`Valor`) AS Total\nFROM\n    `k_recibos_egresos`\n    INNER JOIN `k_caja` \n        ON (`k_recibos_egresos`.`IdCaja` = `k_caja`.`Id`)\n    INNER JOIN `cc_terceros` \n        ON (`cc_terceros`.`Id` = `k_recibos_egresos`.`Id_Tercero`)\n    INNER JOIN `k_recibos_egreso_detalle` \n        ON (`k_recibos_egreso_detalle`.`Id_Recibo` = `k_recibos_egresos`.`Id`)\nWHERE (DATE_FORMAT(`k_recibos_egresos`.`FechaR`, '%Y-%m-%d') >='" + xFechaI + "' AND DATE_FORMAT(`k_recibos_egresos`.`FechaR`, '%Y-%m-%d') <='" + xFechaF + "' AND `k_recibos_egresos`.`IdCaja` ='" + Principal.clasecaja.getIdCaja() + "' AND `k_recibos_egresos`.`Estado`=0) \nGROUP BY `k_recibos_egresos`.`Id` ORDER BY `k_recibos_egresos`.`Id` DESC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.caja.ReciboEgresosDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ReciboEgresosDTO g = new ReciboEgresosDTO();
                g.setIdRecibo(Long.valueOf(rs.getLong("Id")));
                g.setFecha(rs.getString("FechaR"));
                g.setIdCaja(rs.getString("Caja"));
                g.setIdTercero(rs.getString("RazonSocialCompleta"));
                g.setObservacion(rs.getString("Observacion"));
                g.setIdCierre(Long.valueOf(rs.getLong("IdCierre")));
                g.setEstado(rs.getInt("Estado"));
                g.setValor(Double.valueOf(rs.getDouble("Total")));
                return g;
            }
        };
        List<ReciboEgresosDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.caja.ReciboEgresosDAO
    public List<GCGenericoDTO> listaConceptos(int xidCaja) {
        String xsql = "SELECT  `k_conceptos`.`Id` , `k_conceptos`.`Nbre` , `k_conceptos`.`Valor`\nFROM `k_cajaxconceptos` INNER JOIN `k_conceptos`   ON (`k_cajaxconceptos`.`Id_Concepto` = `k_conceptos`.`Id`)\nWHERE (`k_cajaxconceptos`.`Id_Caja` ='" + xidCaja + "' AND `k_cajaxconceptos`.`Estado` =1 AND `k_conceptos`.`Tipo`=1) ORDER BY `k_conceptos`.`Nbre` ";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.caja.ReciboEgresosDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.caja.ReciboEgresosDAO
    public List<GCGenericoDTO> listaTerceros() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.caja.ReciboEgresosDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("RazonSocialCompleta"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `RazonSocialCompleta` FROM `cc_terceros` WHERE (`Estado` =1) ORDER BY `RazonSocialCompleta` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.caja.ReciboEgresosDAO
    public String create_return_id(final ReciboEgresosDTO xRecibos) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.caja.ReciboEgresosDAOImpl.4
            final String sql = "INSERT INTO `k_recibos_egresos` (`FechaR`,`IdCaja`,`Id_Tercero`,`Observacion`,`Estado`,`Id_UsuarioS`, numeroFactura)\nVALUES (?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `k_recibos_egresos` (`FechaR`,`IdCaja`,`Id_Tercero`,`Observacion`,`Estado`,`Id_UsuarioS`, numeroFactura)\nVALUES (?,?,?,?,?,?,?);", 1);
                ps.setString(1, xRecibos.getFecha());
                ps.setString(2, xRecibos.getIdCaja());
                ps.setString(3, xRecibos.getIdTercero());
                ps.setString(4, xRecibos.getObservacion());
                ps.setInt(5, xRecibos.getEstado());
                ps.setString(6, Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                ps.setString(7, xRecibos.getNumeroFactura());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdRecibo = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdRecibo-->" + xIdRecibo);
        return xIdRecibo;
    }

    @Override // com.genoma.plus.dao.caja.ReciboEgresosDAO
    public String createDetalleRecibo(ReciboEgresosDTO xRecibos) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `k_recibos_egreso_detalle` (`Id_Recibo`,`IdConcepto`,`Valor`)\nVALUES (?,?,?);", new Object[]{xRecibos.getIdRecibo(), xRecibos.getIdConcepto(), xRecibos.getValor()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.caja.ReciboEgresosDAO
    public List<ReciboEgresosDTO> listaReciboEgresos(String xid) {
        String xsql = "SELECT\n    `k_recibos_egresos`.`Id`\n    , DATE_FORMAT(`k_recibos_egresos`.`FechaR`, '%Y-%m-%d') AS FechaR\n    , `cc_terceros`.`RazonSocialCompleta`\n    , `k_recibos_egresos`.`Observacion`\n    , `k_recibos_egresos`.`Estado`\n    , `k_conceptos`.`Id` AS `IdConcepto`\n    , `k_conceptos`.`Nbre` AS `Concepto`\n    , `k_recibos_egreso_detalle`.`Valor`\n    , `k_recibos_egresos`.`IdCierre`\n    , `k_recibos_egresos`.`numeroFactura`\nFROM\n    `cc_terceros`\n    INNER JOIN `k_recibos_egresos` \n        ON (`cc_terceros`.`Id` = `k_recibos_egresos`.`Id_Tercero`)\n    INNER JOIN `k_recibos_egreso_detalle` \n        ON (`k_recibos_egreso_detalle`.`Id_Recibo` = `k_recibos_egresos`.`Id`)\n    INNER JOIN `k_conceptos` \n        ON (`k_recibos_egreso_detalle`.`IdConcepto` = `k_conceptos`.`Id`)\nWHERE (`k_recibos_egresos`.`Id` ='" + xid + "');";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.caja.ReciboEgresosDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ReciboEgresosDTO g = new ReciboEgresosDTO();
                g.setIdRecibo(Long.valueOf(rs.getLong("Id")));
                g.setFecha(rs.getString("FechaR"));
                g.setIdTercero(rs.getString("RazonSocialCompleta"));
                g.setObservacion(rs.getString("Observacion"));
                g.setEstado(rs.getInt("Estado"));
                g.setIdConcepto(Long.valueOf(rs.getLong("IdConcepto")));
                g.setNConcepto(rs.getString("Concepto"));
                g.setValor(Double.valueOf(rs.getDouble("Valor")));
                g.setIdCierre(Long.valueOf(rs.getLong("IdCierre")));
                g.setNumeroFactura(rs.getString("numeroFactura"));
                return g;
            }
        };
        List<ReciboEgresosDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.caja.ReciboEgresosDAO
    public void anularRecibo(String idRecibo, String motivo, String observacion, Long idUsuarioRh) {
        String sql = "update  k_recibos_egresos set   `Estado`=1 , `motivoAnulacion`='" + motivo + "'  , `observacionAnulacion`='" + observacion + "' , `idUsuarioRhAnulacion`=" + idUsuarioRh + " , `fechaAnulado`= now() where Id=" + idRecibo + " ";
        this.jdbcTemplate.execute(sql);
    }

    @Override // com.genoma.plus.dao.caja.ReciboEgresosDAO
    public Integer validarNumeroFactura(Long idTercero, String numeroFactura) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.caja.ReciboEgresosDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id"))};
                return fila;
            }
        };
        String sql = "  SELECT kre.Id \nfrom  k_recibos_egresos kre \nwhere  kre.Id_Tercero=" + idTercero + " and kre.numeroFactura='" + numeroFactura + "'\nand kre.Estado =1";
        System.err.println("sql" + sql);
        Integer id = Integer.valueOf(this.jdbcTemplate.query(sql, mapper).size());
        System.err.println("numero de filas : " + id);
        return id;
    }
}
