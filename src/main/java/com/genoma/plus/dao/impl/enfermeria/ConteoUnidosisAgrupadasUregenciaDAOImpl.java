package com.genoma.plus.dao.impl.enfermeria;

import com.genoma.plus.dao.enfermeria.ConteoUnidosisAgrupadaUrgenciaDAO;
import com.genoma.plus.dto.enfermeria.ConteoUnidosisAgrupadaUrgenciaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/enfermeria/ConteoUnidosisAgrupadasUregenciaDAOImpl.class */
public class ConteoUnidosisAgrupadasUregenciaDAOImpl implements ConteoUnidosisAgrupadaUrgenciaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.enfermeria.ConteoUnidosisAgrupadaUrgenciaDAO
    public List<ConteoUnidosisAgrupadaUrgenciaDTO> CantidadUnidosisAplicada(String FechaI, String FechaF) {
        String sql = "SELECT  \n  h_ordenes_unidosis.`Id`\n   , `g_persona`.`Id_TipoIdentificacion`\n   , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) usuario\n    , `g_persona`.`Id_Sexo`\n    , `f_empresacontxconvenio`.`Nbre` AS `Convenio`\n    ,`h_ordenes_unidosis_aplicacion`.`Fecha_A`\n    , `h_ordenes_unidosis_aplicacion`.`Hora`\n    , `i_suministro`.`Id` AS IdSuministro\n    , `i_suministro`.`Nbre` AS `NombreSuministro`\n    , `h_ordenes_unidosis_aplicacion_detalle`.`Cantidad` AS `Cantidad`\nFROM\n    `baseserver`.`h_ordenes_unidosis_aplicacion`\n    INNER JOIN `baseserver`.`h_ordenes_unidosis` \n        ON (`h_ordenes_unidosis_aplicacion`.`Id_Unidosis` = `h_ordenes_unidosis`.`Id`)\n    INNER JOIN `baseserver`.`g_tipoatencion` \n        ON (`h_ordenes_unidosis`.`Tipo` = `g_tipoatencion`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_ordenes_unidosis`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`h_ordenes_unidosis_aplicacion_detalle` \n        ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Ordenes_Aplicacion` = `h_ordenes_unidosis_aplicacion`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`h_ordenes_unidosis_aplicacion`.`Fecha_A` >='" + FechaI + "'\n    AND `h_ordenes_unidosis_aplicacion`.`Fecha_A` <='" + FechaF + "'\n    AND `h_ordenes_unidosis_aplicacion_detalle`.`Estado` =1\n    AND `h_ordenes_unidosis_aplicacion`.`Estado` =1)\nORDER BY  h_ordenes_unidosis.`Id`ASC , `NombreSuministro` ASC;";
        System.err.println("sql" + sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.enfermeria.ConteoUnidosisAgrupadasUregenciaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConteoUnidosisAgrupadaUrgenciaDTO g = new ConteoUnidosisAgrupadaUrgenciaDTO();
                g.setIdOrdenUnidosis(rs.getInt("Id"));
                g.setIdTipoDocumento(rs.getString("Id_TipoIdentificacion"));
                g.setNumeroDocumento(rs.getString("NoDocumento"));
                g.setNombreCompleto(rs.getString("usuario"));
                g.setIdSexo(rs.getString("Id_Sexo"));
                g.setNombreConvenio(rs.getString("Convenio"));
                g.setFechaAplicacionUnidosis(rs.getString("Fecha_A"));
                g.setHoraaPlicacionUnidosis(rs.getString("Hora"));
                g.setIdSuministro(rs.getInt("IdSuministro"));
                g.setNombreSuministro(rs.getString("NombreSuministro"));
                g.setCantidadAplicada(rs.getInt("Cantidad"));
                return g;
            }
        };
        List<ConteoUnidosisAgrupadaUrgenciaDTO> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.enfermeria.ConteoUnidosisAgrupadaUrgenciaDAO
    public List<ConteoUnidosisAgrupadaUrgenciaDTO> CantidadUnidosisAplicadaAgrupada(String FechaI, String FechaF) {
        String Sql = "SELECT\n    `h_ordenes_unidosis_aplicacion`.`Fecha_A`\n    ,`h_ordenes_unidosis_aplicacion`.`Hora`\n    , `i_suministro`.`Id` AS IdSuministro \n    , `i_suministro`.`Nbre` AS `NombreSuministro`\n    , SUM(`h_ordenes_unidosis_aplicacion_detalle`.`Cantidad`) AS `Cantidad`\nFROM\n    `baseserver`.`h_ordenes_unidosis_aplicacion`\n    INNER JOIN `baseserver`.`h_ordenes_unidosis` \n        ON (`h_ordenes_unidosis_aplicacion`.`Id_Unidosis` = `h_ordenes_unidosis`.`Id`)\n    INNER JOIN `baseserver`.`g_tipoatencion` \n        ON (`h_ordenes_unidosis`.`Tipo` = `g_tipoatencion`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_ordenes_unidosis`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`h_ordenes_unidosis_aplicacion_detalle` \n        ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Ordenes_Aplicacion` = `h_ordenes_unidosis_aplicacion`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`h_ordenes_unidosis_aplicacion_detalle`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`h_ordenes_unidosis_aplicacion`.`Fecha_A` >='" + FechaI + "'\n    AND `h_ordenes_unidosis_aplicacion`.`Fecha_A` <='" + FechaF + "'\n    AND `h_ordenes_unidosis_aplicacion_detalle`.`Estado` =1\n    AND `h_ordenes_unidosis_aplicacion`.`Estado` =1)\nGROUP BY `i_suministro`.`Id`\nORDER BY `NombreSuministro` ASC;";
        System.err.println("sql" + Sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.enfermeria.ConteoUnidosisAgrupadasUregenciaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConteoUnidosisAgrupadaUrgenciaDTO g = new ConteoUnidosisAgrupadaUrgenciaDTO();
                g.setFechaAplicacionUnidosis(rs.getString("Fecha_A"));
                g.setHoraaPlicacionUnidosis(rs.getString("Hora"));
                g.setIdSuministro(rs.getInt("IdSuministro"));
                g.setNombreSuministro(rs.getString("NombreSuministro"));
                g.setCantidadAplicada(rs.getInt("Cantidad"));
                return g;
            }
        };
        List<ConteoUnidosisAgrupadaUrgenciaDTO> lista = this.jdbcTemplate.query(Sql, mapper);
        return lista;
    }
}
