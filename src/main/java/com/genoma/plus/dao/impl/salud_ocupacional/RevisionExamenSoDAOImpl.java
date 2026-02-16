package com.genoma.plus.dao.impl.salud_ocupacional;

import com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.salud_ocupacional.RevisionExamenSoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/salud_ocupacional/RevisionExamenSoDAOImpl.class */
public class RevisionExamenSoDAOImpl implements RevisionExamenSoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO
    public List<RevisionExamenSoDTO> listRevisionExamen(String xingreso) {
        String sql = "SELECT\n\tf_itemordenesproced.`Id_Ordenes`\n\t,f_itemordenesproced.`Id_Procedimiento`\n    ,`g_procedimiento`.`Nbre` AS procedimiento\n    , IFNULL(f_itemordenesproced.`Observacion`,'') AS Observacion\n    , f_itemordenesproced.`ResultadoTexto`\n    , IF(f_itemordenesproced.Soporte IS NULL, 0, 1) existeSoporte\n\nFROM \n    `f_ordenes`\n    INNER JOIN `ingreso`\n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_itemordenesproced`\n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `g_procedimiento`\n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `g_procedimiento_resultado`\n        ON (`g_procedimiento_resultado`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    WHERE (`ingreso`.`Id` ='" + xingreso + "')GROUP BY f_itemordenesproced.`Id_Procedimiento`;";
        System.out.println(sql);
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.RevisionExamenSoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                RevisionExamenSoDTO Lista = new RevisionExamenSoDTO();
                Lista.setIdOrdenes(Long.valueOf(rs.getLong("Id_Ordenes")));
                Lista.setIdProcedimiento(Long.valueOf(rs.getLong("Id_Procedimiento")));
                Lista.setNProcedimiento(rs.getString("procedimiento"));
                Lista.setObservacion(rs.getString("Observacion"));
                Lista.setResultadoTexto(rs.getString("ResultadoTexto"));
                return Lista;
            }
        };
        List<RevisionExamenSoDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO
    public List<Object[]> listRevisionExamen2(String xingreso) {
        String xsql = "SELECT\n    `f_itemordenesproced`.`Id_Ordenes`\n    , `f_itemordenesproced`.`Id_Procedimiento`\n    , `g_procedimiento`.`Nbre` AS `Procedimiento`\n    , `f_itemordenesproced`.`Observacion`\n    , `f_itemordenesproced`.`ResultadoTexto`\n    , `f_itemordenesproced`.`Soporte`\n    , IFNULL(`h_tipohistoria`.`Nbre`,'') AS `TipoHistoria`\n    , `f_tipoprocedimiento`.`Nbre` AS `TipoProcedimiento`\n    , IF(IFNULL(`l_detallerecepcion`.`ValidadoLab`,'0')=0,0,`f_ordenes`.`Id_OrdenRecep`) AS Id_OrdenRecep\nFROM\n    `f_ordenes`\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `g_procedimiento` \n        ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    LEFT JOIN `h_tipohistoria` \n        ON (`h_tipohistoria`.`Id` = `g_procedimiento`.`Id_Hc`)\n    INNER JOIN `f_tipoprocedimiento` \n        ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\n    LEFT JOIN `l_recepcion` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`) AND l_recepcion.`Estado`=0\n    LEFT JOIN `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) AND (`l_detallerecepcion`.`Id_Procedim` = `f_itemordenesproced`.`Id_Procedimiento`)\nWHERE (`ingreso`.`Id` ='" + xingreso + "') GROUP BY f_itemordenesproced.`Id_Procedimiento`;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.RevisionExamenSoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id_Ordenes")), Long.valueOf(rs.getLong("Id_Procedimiento")), rs.getString("procedimiento"), rs.getString("ResultadoTexto"), rs.getString("Observacion"), rs.getBytes("Soporte"), rs.getString("TipoHistoria"), rs.getString("TipoProcedimiento"), Long.valueOf(rs.getLong("Id_OrdenRecep"))};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO
    public List<Object[]> listaSoportes(String tabla, Long idIngreso) {
        String xsql = "SELECT archivo FROM " + tabla + " WHERE idIngreso=" + idIngreso + ";";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.RevisionExamenSoDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("archivo")};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO
    public String updateRevisionExamen(RevisionExamenSoDTO Revision) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `f_itemordenesproced`\nSET `ResultadoTexto` = ?,\n  `Observacion` = ?\nWHERE `Id_Ordenes` = ?\nAND `Id_Procedimiento` = ?;", new Object[]{Revision.getResultadoTexto(), Revision.getObservacion(), Revision.getIdOrdenes(), Revision.getIdProcedimiento()});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO
    public List<GCGenericoDTO> listaResultados(String xidProcedimiento) {
        String sql = "SELECT `Id_Procedimiento`, `NResultado` FROM `g_procedimiento_resultado` WHERE (`Id_Procedimiento` ='" + xidProcedimiento + "' AND `Estado` =1) ORDER BY `NResultado` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.salud_ocupacional.RevisionExamenSoDAOImpl.4
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GCGenericoDTO Lista = new GCGenericoDTO();
                Lista.setId(rs.getLong("Id_Procedimiento"));
                Lista.setNombre(rs.getString("NResultado"));
                return Lista;
            }
        };
        List<GCGenericoDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO
    public void cargarArchivosDeResultados(RevisionExamenSoDTO Revision) {
        int ctos = this.jdbcTemplate.update("UPDATE `f_itemordenesproced`\nSET `soporte` = ?\nWHERE `Id_Ordenes` = ?\nAND `Id_Procedimiento` = ?;", new Object[]{Revision.getSoporte(), Revision.getIdOrdenes(), Revision.getIdProcedimiento()});
        if (ctos == 0) {
        }
    }
}
