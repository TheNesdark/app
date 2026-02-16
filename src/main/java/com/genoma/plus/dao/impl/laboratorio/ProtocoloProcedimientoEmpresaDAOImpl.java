package com.genoma.plus.dao.impl.laboratorio;

import Acceso.Principal;
import com.genoma.plus.dao.laboratorio.ProtocoloProcedimientoEmpresaDAO;
import com.genoma.plus.dto.laboratorio.ProtocoloProcedimientoEmpresaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/laboratorio/ProtocoloProcedimientoEmpresaDAOImpl.class */
public class ProtocoloProcedimientoEmpresaDAOImpl implements ProtocoloProcedimientoEmpresaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.laboratorio.ProtocoloProcedimientoEmpresaDAO
    public List<Object[]> listaProtocolosProcedimientoEmpresa(String idProcedimiento, String idEmpresa) {
        String Sql = "SELECT\n  IFNULL(d.id, 0) AS Id,\n  l_protocoloxprocedimiento.Id AS IdProtocoloProcedimiento,\n  l_protocolos.Nbre AS Protocolo,\n  IFNULL(d.codigoExtero, '') AS Codigo,\n  IFNULL(d.estado, 0) AS Estado,\n  IF(d.id IS NULL, 0, 1) AS Grabado\nFROM\n  l_protocoloxprocedimiento\n  INNER JOIN l_protocolos\n    ON (\n      l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id\n    )\n  LEFT JOIN\n    (SELECT\n      id,\n      `codigoExtero`,\n      `idProtocoloProcedi`,\n      `idEmpresa`,\n      estado\n    FROM\n      `l_protocoloprocedimiento_empresa`) d\n    ON d.idProtocoloProcedi = l_protocoloxprocedimiento.Id\n    AND d.idEmpresa = " + idEmpresa + "\nWHERE (\n    l_protocoloxprocedimiento.Estado = 0\n    AND l_protocoloxprocedimiento.Id_Procedim = " + idProcedimiento + "\n  )\nGROUP BY l_protocoloxprocedimiento.Id\nORDER BY l_protocoloxprocedimiento.Orden ASC,\n  l_protocolos.Nbre ASC";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ProtocoloProcedimientoEmpresaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), Long.valueOf(rs.getLong("IdProtocoloProcedimiento")), rs.getString("Protocolo"), rs.getString("Codigo"), Boolean.valueOf(rs.getBoolean("Estado")), Boolean.valueOf(rs.getBoolean("Grabado"))};
                return fila;
            }
        };
        List<Object[]> listaConsulta = this.jdbcTemplate.query(Sql, rowMapper);
        return listaConsulta;
    }

    @Override // com.genoma.plus.dao.laboratorio.ProtocoloProcedimientoEmpresaDAO
    public String create(ProtocoloProcedimientoEmpresaDTO e) {
        String result = "Datos insertados Satisfactoriamente ";
        int ctos = this.jdbcTemplate.update("INSERT INTO l_protocoloprocedimiento_empresa (idProtocoloProcedi, idEmpresa, codigoExtero, estado, idUsuarioRh)\nVALUES(?,?,?,?,?);", new Object[]{Long.valueOf(e.getIdProtocoloProcedimiento()), Long.valueOf(e.getIdEmpresa()), Long.valueOf(e.getCodigoExterno()), Boolean.valueOf(e.isEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            result = "No se inserto ";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.laboratorio.ProtocoloProcedimientoEmpresaDAO
    public String update(ProtocoloProcedimientoEmpresaDTO e) {
        String sql = "UPDATE\n\tl_protocoloprocedimiento_empresa\nSET\n\tidEmpresa = ?,\n\tcodigoExtero = ?,\n\testado = ?,\t\n\tidUsuarioRh = ?\nWHERE\n\tid = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Long.valueOf(e.getIdEmpresa()), Long.valueOf(e.getCodigoExterno()), Boolean.valueOf(e.isEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Long.valueOf(e.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas ";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.laboratorio.ProtocoloProcedimientoEmpresaDAO
    public List<Object[]> ListaEmpresa() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ProtocoloProcedimientoEmpresaDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = new Object[10];
                fila[0] = Integer.valueOf(rs.getInt(1));
                fila[1] = rs.getString(2);
                return fila;
            }
        };
        List<Object[]> listaProtocolos = this.jdbcTemplate.query("SELECT `Id`,`RazonSocialCompleta` FROM `cc_terceros` WHERE estado=1 ORDER BY `RazonSocialCompleta` ASC;", rowMapper);
        return listaProtocolos;
    }
}
