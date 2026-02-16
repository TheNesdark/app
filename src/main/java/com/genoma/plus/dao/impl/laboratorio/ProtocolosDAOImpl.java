package com.genoma.plus.dao.impl.laboratorio;

import Acceso.Principal;
import com.genoma.plus.dao.laboratorio.ProtocolosDAO;
import com.genoma.plus.dto.laboratorio.ProtocolosDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/laboratorio/ProtocolosDAOImpl.class */
public class ProtocolosDAOImpl implements ProtocolosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.laboratorio.ProtocolosDAO
    public ProtocolosDTO findById(Long id) {
        RowMapper<ProtocolosDTO> rowMapper = new RowMapper<ProtocolosDTO>() { // from class: com.genoma.plus.dao.impl.laboratorio.ProtocolosDAOImpl.1
            /* JADX INFO: renamed from: mapRow, reason: merged with bridge method [inline-methods] */
            public ProtocolosDTO m81mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProtocolosDTO protocolos = new ProtocolosDTO();
                protocolos.setId(Long.valueOf(rs.getLong("Id")));
                protocolos.setNbre(rs.getString("Protocolo"));
                protocolos.setVrMinM(rs.getString("VrMinM"));
                protocolos.setVrMaxM(rs.getString("VrMaxM"));
                protocolos.setVrMinF(rs.getString("VrMinF"));
                protocolos.setVrMaxF(rs.getString("VrMaxF"));
                protocolos.setEdadIni(rs.getInt("EdadIni"));
                protocolos.setEdadFin(rs.getInt("EdadFin"));
                protocolos.setUnidad(rs.getString("Unidad"));
                protocolos.setAbreviatura(rs.getString("Abreviatura"));
                protocolos.setOrden(rs.getInt("Orden"));
                protocolos.setEstado(rs.getInt("Estado"));
                protocolos.setAResultado(rs.getInt("AResultado"));
                protocolos.setAplicaFormula(rs.getInt("AplicaFormula"));
                protocolos.setIdTEncabezado(rs.getString("NTipoEncabezado"));
                protocolos.setIdSql(rs.getString("Id_Sql"));
                protocolos.setIdTipoResultado(rs.getString("NTipoResultado"));
                protocolos.setIdTipoMuestra(rs.getString("NTipoMuestra"));
                protocolos.setExportable(rs.getInt("Exportable"));
                protocolos.setVCostante(rs.getDouble("VCostante"));
                protocolos.setV4505(rs.getString("V4505"));
                protocolos.setV2463(rs.getString("V2463"));
                protocolos.setResultadoUnificado(rs.getInt("ResultadoUnificado"));
                protocolos.setComentario(rs.getString("Comentario"));
                return protocolos;
            }
        };
        return (ProtocolosDTO) this.jdbcTemplate.queryForObject("SELECT\n  l_protocolos.Id,\n  l_protocolos.Nbre AS Protocolo,\n  l_protocolos.VrMinM,\n  l_protocolos.VrMaxM,\n  l_protocolos.VrMinF,\n  l_protocolos.VrMaxF,\n  l_protocolos.EdadIni,\n  l_protocolos.EdadFin,\n  l_protocolos.Unidad,\n  l_protocolos.Abreviatura,\n  l_protocolos.Orden,\n  l_protocolos.Estado,\n  l_protocolos.AResultado,\n  l_protocolos.Id_TipoResultado,\n  l_protocolos.AplicaFormula,\n  l_tipo_encabezado.Nbre AS NTipoEncabezado,\n  l_protocolos.Id_Sql,\n  l_tiporesultado.Nbre AS NTipoResultado,\n  l_tipomuestra.Nbre AS NTipoMuestra,\n  l_protocolos.Exportable,\n  l_protocolos.VCostante,\n  l_protocolos.V4505,\n  l_protocolos.V2463,\n  l_protocolos.ResultadoUnificado,\n  IFNULL(l_protocolos.Comentario, '') AS Comentario\nFROM l_protocolos\n  INNER JOIN l_tipo_encabezado ON (l_protocolos.Id_tencabezado = l_tipo_encabezado.Id)\n  INNER JOIN l_tiporesultado ON (l_tiporesultado.Id = l_protocolos.Id_TipoResultado)\n  INNER JOIN l_tipomuestra ON (l_protocolos.Id_Tipo_Muestra = l_tipomuestra.Id)\nWHERE l_protocolos.Id = ?\nORDER BY l_protocolos.Nbre ASC", rowMapper, new Object[]{id});
    }

    @Override // com.genoma.plus.dao.laboratorio.ProtocolosDAO
    public List<ProtocolosDTO> listProtocolos(boolean opc, String xBusqueda) {
        String sql;
        if (!opc) {
            sql = "SELECT\n  `l_protocolos`.Id,\n  `l_protocolos`.Nbre AS Protocolo,\n  `l_protocolos`.VrMinM,\n  `l_protocolos`.VrMaxM,\n  `l_protocolos`.VrMinF,\n  `l_protocolos`.VrMaxF,\n  `l_protocolos`.EdadIni,\n  `l_protocolos`.EdadFin,\n  `l_protocolos`.Unidad,\n  `l_protocolos`.Abreviatura,\n  `l_protocolos`.Orden,\n  `l_protocolos`.Estado,\n  `l_protocolos`.AResultado,\n  `l_protocolos`.Id_TipoResultado,\n  `l_protocolos`.AplicaFormula,\n  `l_tipo_encabezado`.`Nbre` AS NTipoEncabezado,\n  `l_protocolos`.Id_Sql,\n  `l_tiporesultado`.`Nbre` AS NTipoResultado,\n  `l_tipomuestra`.`Nbre` AS NTipoMuestra,\n  `l_protocolos`.Exportable,\n  `l_protocolos`.VCostante,\n  `l_protocolos`.V4505,\n  `l_protocolos`.V2463,\n  `l_protocolos`.`ResultadoUnificado`,\n   ifnull(l_protocolos.Comentario,'') as Comentario \n FROM\n  `l_protocolos`\n  INNER JOIN `l_tipo_encabezado`\n      ON (`l_protocolos`.`Id_tencabezado` = `l_tipo_encabezado`.`Id`)\n  INNER JOIN `l_tiporesultado`\n      ON (`l_tiporesultado`.`Id` = `l_protocolos`.`Id_TipoResultado`)\n  INNER JOIN `l_tipomuestra`\n      ON (`l_protocolos`.`Id_Tipo_Muestra` = `l_tipomuestra`.`Id`)\nORDER BY `l_protocolos`.Nbre ASC";
        } else {
            sql = "SELECT\n  `l_protocolos`.Id,\n  `l_protocolos`.Nbre AS Protocolo,\n  `l_protocolos`.VrMinM,\n  `l_protocolos`.VrMaxM,\n  `l_protocolos`.VrMinF,\n  `l_protocolos`.VrMaxF,\n  `l_protocolos`.EdadIni,\n  `l_protocolos`.EdadFin,\n  `l_protocolos`.Unidad,\n  `l_protocolos`.Abreviatura,\n  `l_protocolos`.Orden,\n  `l_protocolos`.Estado,\n  `l_protocolos`.AResultado,\n  `l_protocolos`.Id_TipoResultado,\n  `l_protocolos`.AplicaFormula,\n  `l_tipo_encabezado`.`Nbre` AS NTipoEncabezado,\n  `l_protocolos`.Id_Sql,\n  `l_tiporesultado`.`Nbre` AS NTipoResultado,\n  `l_tipomuestra`.`Nbre` AS NTipoMuestra,\n  `l_protocolos`.Exportable,\n  `l_protocolos`.VCostante,\n  `l_protocolos`.V4505,\n  `l_protocolos`.V2463,\n  `l_protocolos`.`ResultadoUnificado`,\n   ifnull(l_protocolos.Comentario,'') as Comentario \n FROM\n  `l_protocolos`\n  INNER JOIN `l_tipo_encabezado`\n      ON (`l_protocolos`.`Id_tencabezado` = `l_tipo_encabezado`.`Id`)\n  INNER JOIN `l_tiporesultado`\n      ON (`l_tiporesultado`.`Id` = `l_protocolos`.`Id_TipoResultado`)\n  INNER JOIN `l_tipomuestra`\n      ON (`l_protocolos`.`Id_Tipo_Muestra` = `l_tipomuestra`.`Id`)\nWHERE (`l_protocolos`.Nbre like'" + xBusqueda + "%')\nORDER BY `l_protocolos`.Nbre ASC";
        }
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ProtocolosDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ProtocolosDTO protocolos = new ProtocolosDTO();
                protocolos.setId(Long.valueOf(rs.getLong("Id")));
                protocolos.setNbre(rs.getString("Protocolo"));
                protocolos.setVrMinM(rs.getString("VrMinM"));
                protocolos.setVrMaxM(rs.getString("VrMaxM"));
                protocolos.setVrMinF(rs.getString("VrMinF"));
                protocolos.setVrMaxF(rs.getString("VrMaxF"));
                protocolos.setEdadIni(rs.getInt("EdadIni"));
                protocolos.setEdadFin(rs.getInt("EdadFin"));
                protocolos.setUnidad(rs.getString("Unidad"));
                protocolos.setAbreviatura(rs.getString("Abreviatura"));
                protocolos.setOrden(rs.getInt("Orden"));
                protocolos.setEstado(rs.getInt("Estado"));
                protocolos.setAResultado(rs.getInt("AResultado"));
                protocolos.setAplicaFormula(rs.getInt("AplicaFormula"));
                protocolos.setIdTEncabezado(rs.getString("NTipoEncabezado"));
                protocolos.setIdSql(rs.getString("Id_Sql"));
                protocolos.setIdTipoResultado(rs.getString("NTipoResultado"));
                protocolos.setIdTipoMuestra(rs.getString("NTipoMuestra"));
                protocolos.setExportable(rs.getInt("Exportable"));
                protocolos.setVCostante(rs.getDouble("VCostante"));
                protocolos.setV4505(rs.getString("V4505"));
                protocolos.setV2463(rs.getString("V2463"));
                protocolos.setResultadoUnificado(rs.getInt("ResultadoUnificado"));
                protocolos.setComentario(rs.getString("Comentario"));
                return protocolos;
            }
        };
        List<ProtocolosDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.laboratorio.ProtocolosDAO
    public String mUpdate(ProtocolosDTO xProtocolo) {
        String sql = "UPDATE\n  `l_protocolos`\nSET\n  `Nbre` = ?,\n  `VrMinM` = ?,\n  `VrMaxM` = ?,\n  `VrMinF` = ?,\n  `VrMaxF` = ?,\n  `EdadIni` = ?,\n  `EdadFin` = ?,\n  `Unidad` = ?,\n  `Abreviatura` = ?,\n  `Orden` = ?,\n  `Estado` = ?,\n  `AResultado` = ?,\n  `Id_TipoResultado` = ?,\n  `AplicaFormula` = ?,\n  `Id_Sql` = ?,\n  `Id_tencabezado` = ?,\n  `Id_Tipo_Muestra` = ?,\n  `VCostante` = ?,\n  `V4505` = ?,\n  `V2463` = ?,\n  `ResultadoUnificado` = ?,\n  `Comentario` = ?,\n  `Fecha` = ?,\n  `UsuarioS` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xProtocolo.getNbre(), xProtocolo.getVrMinM(), xProtocolo.getVrMaxM(), xProtocolo.getVrMinF(), xProtocolo.getVrMaxF(), Integer.valueOf(xProtocolo.getEdadIni()), Integer.valueOf(xProtocolo.getEdadFin()), xProtocolo.getUnidad(), xProtocolo.getAbreviatura(), Integer.valueOf(xProtocolo.getOrden()), Integer.valueOf(xProtocolo.getEstado()), Integer.valueOf(xProtocolo.getAResultado()), xProtocolo.getIdTipoResultado(), Integer.valueOf(xProtocolo.getAplicaFormula()), xProtocolo.getIdSql(), xProtocolo.getIdTEncabezado(), xProtocolo.getIdTipoMuestra(), Double.valueOf(xProtocolo.getVCostante()), xProtocolo.getV4505(), xProtocolo.getV2463(), Integer.valueOf(xProtocolo.getResultadoUnificado()), xProtocolo.getComentario(), xProtocolo.getFecha(), Principal.usuarioSistemaDTO.getLogin(), xProtocolo.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.laboratorio.ProtocolosDAO
    public String mcreate_return_id(final ProtocolosDTO xProtocolo) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.laboratorio.ProtocolosDAOImpl.3
            final String sql = "INSERT INTO `l_protocolos` (`Nbre`,`VrMinM`,`VrMaxM`,`VrMinF`,`VrMaxF`,`EdadIni`,`EdadFin`,`Unidad`,`Abreviatura`,`Orden`,`Estado`,`AResultado`,`Id_TipoResultado`,`AplicaFormula`,`Id_Sql`,`Id_tencabezado`,`Id_Tipo_Muestra`,`VCostante`,`V4505`,`V2463`,`ResultadoUnificado`,`Fecha`,`UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `l_protocolos` (`Nbre`,`VrMinM`,`VrMaxM`,`VrMinF`,`VrMaxF`,`EdadIni`,`EdadFin`,`Unidad`,`Abreviatura`,`Orden`,`Estado`,`AResultado`,`Id_TipoResultado`,`AplicaFormula`,`Id_Sql`,`Id_tencabezado`,`Id_Tipo_Muestra`,`VCostante`,`V4505`,`V2463`,`ResultadoUnificado`,`Fecha`,`UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setString(1, xProtocolo.getNbre());
                ps.setString(2, xProtocolo.getVrMinM());
                ps.setString(3, xProtocolo.getVrMaxM());
                ps.setString(4, xProtocolo.getVrMinF());
                ps.setString(5, xProtocolo.getVrMaxF());
                ps.setInt(6, xProtocolo.getEdadIni());
                ps.setInt(7, xProtocolo.getEdadFin());
                ps.setString(8, xProtocolo.getUnidad());
                ps.setString(9, xProtocolo.getAbreviatura());
                ps.setInt(10, xProtocolo.getOrden());
                ps.setInt(11, xProtocolo.getEstado());
                ps.setInt(12, xProtocolo.getAResultado());
                ps.setString(13, xProtocolo.getIdTipoResultado());
                ps.setInt(14, xProtocolo.getAplicaFormula());
                ps.setString(15, xProtocolo.getIdSql());
                ps.setString(16, xProtocolo.getIdTEncabezado());
                ps.setString(17, xProtocolo.getIdTipoMuestra());
                ps.setDouble(18, xProtocolo.getVCostante());
                ps.setString(19, xProtocolo.getV4505());
                ps.setString(20, xProtocolo.getV2463());
                ps.setInt(21, xProtocolo.getResultadoUnificado());
                ps.setString(22, xProtocolo.getFecha());
                ps.setString(23, Principal.usuarioSistemaDTO.getLogin());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdProtocolo = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdProtocolo-->" + xIdProtocolo);
        return xIdProtocolo;
    }
}
