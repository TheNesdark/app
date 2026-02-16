package com.genoma.plus.dao.impl.facturacion;

import com.genoma.plus.dao.facturacion.ConsultarIngresoSoatDAO;
import com.genoma.plus.dto.facturacion.ConsultarIngresoSoatDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/ConsultarIngresoSoatDAOImpl.class */
public class ConsultarIngresoSoatDAOImpl implements ConsultarIngresoSoatDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.ConsultarIngresoSoatDAO
    public List<ConsultarIngresoSoatDTO> listConsultarIngresoSoat(String xFechaI, String xFechaF, String xIdGenerico, int xtipo) {
        String xsql = "";
        switch (xtipo) {
            case 0:
                xsql = "SELECT\n    `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `f_empresacontxconvenio`.`Nbre`\n    , `ingreso`.`FechaIngreso`\n    , `ingreso`.`Id`\n    , IFNULL(`a_eventoecat_paciente`.`Id_Eventoecat`, 'NO TIENE') NEvento\n    , IF(`f_factura_evento`.`EstaArmada`=0, 'PENDIENTE', IF(`f_factura_evento`.`EstaArmada`=1,'ARMADA', 'PRESENTADA')) Estado\n    , IFNULL(d.Seguimiento, 'SIN SEGUIMIENTO') Seguimiento\n    ,CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`) NFactura\n    , IFNULL(e.NUsuario,'') AS NRegistro\nFROM\n    `ingreso`\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `f_liquidacion` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `g_empresacont` \n        ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `f_tipoempresacont` \n        ON (`g_empresacont`.`Id_TipoEmprCont` = `f_tipoempresacont`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    LEFT JOIN `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN (SELECT `Id`, GROUP_CONCAT(CONCAT(`FechaD`, ' ',`Observacion`) ORDER BY FechaD SEPARATOR '\\n' ) Seguimiento,\n        `Estado`, `GAlerta`, Id_Ingreso\n        FROM `ingreso_seguimiento` GROUP BY Id_Ingreso ORDER BY `FechaD` DESC)\n        d  ON (d.Id_Ingreso =`ingreso`.`Id` AND d.Estado=1 AND d.GAlerta=1)\n    LEFT JOIN (SELECT\n     `persona`.`NUsuario`\n     ,a_eventoecat.`Estado`\n     ,`a_eventoecat_paciente`.`Id_Ingreso`\n    FROM\n    `a_eventoecat_paciente`\n    INNER JOIN `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n    INNER JOIN `g_usuario_sist` \n        ON (`a_eventoecat`.`UsuarioS` = `g_usuario_sist`.`Login`)\n    INNER JOIN `persona` \n        ON (`g_usuario_sist`.`Id_Persona` = `persona`.`Id_persona`) GROUP BY `a_eventoecat_paciente`.`Id_Ingreso`) e ON (e.Id_Ingreso=`ingreso`.`Id` AND e.Estado=1) \nWHERE (`f_tipoempresacont`.`Id` ='" + xIdGenerico + "'\nAND `ingreso`.`FechaIngreso`>='" + xFechaI + "' AND `ingreso`.`FechaIngreso`<='" + xFechaF + "'\n    AND `f_liquidacion`.`Estado` =0);";
                break;
            case 1:
                xsql = "SELECT\n    `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `f_empresacontxconvenio`.`Nbre`\n    , `ingreso`.`FechaIngreso`\n    , `ingreso`.`Id`\n    , IFNULL(`a_eventoecat_paciente`.`Id_Eventoecat`, 'NO TIENE') NEvento\n    , IF(`f_factura_evento`.`EstaArmada`=0, 'PENDIENTE', IF(`f_factura_evento`.`EstaArmada`=1,'ARMADA', 'PRESENTADA')) Estado\n    , IFNULL(d.Seguimiento, 'SIN SEGUIMIENTO') Seguimiento\n    , CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`) NFactura\n    , IFNULL(e.NUsuario,'') AS NRegistro\nFROM\n    `ingreso`\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `f_liquidacion` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `g_empresacont` \n        ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `f_tipoempresacont` \n        ON (`g_empresacont`.`Id_TipoEmprCont` = `f_tipoempresacont`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    LEFT JOIN `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN (SELECT `Id`, GROUP_CONCAT(CONCAT(`FechaD`, ' ',`Observacion`) ORDER BY FechaD SEPARATOR '\\n' ) Seguimiento,\n        `Estado`, `GAlerta`, Id_Ingreso\n        FROM `ingreso_seguimiento` GROUP BY Id_Ingreso ORDER BY `FechaD` DESC)\n        d  ON (d.Id_Ingreso =`ingreso`.`Id` AND d.Estado=1 AND d.GAlerta=1)\n    LEFT JOIN (SELECT\n     `persona`.`NUsuario`\n     ,a_eventoecat.`Estado`\n     ,`a_eventoecat_paciente`.`Id_Ingreso`\n    FROM\n    `a_eventoecat_paciente`\n    INNER JOIN `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n    INNER JOIN `g_usuario_sist` \n        ON (`a_eventoecat`.`UsuarioS` = `g_usuario_sist`.`Login`)\n    INNER JOIN `persona` \n        ON (`g_usuario_sist`.`Id_Persona` = `persona`.`Id_persona`) GROUP BY `a_eventoecat_paciente`.`Id_Ingreso`) e ON (e.Id_Ingreso=`ingreso`.`Id` AND e.Estado=1) \nWHERE (`f_tipoempresacont`.`Id` ='" + xIdGenerico + "'\nAND `ingreso`.`FechaIngreso`>='" + xFechaI + "' AND `ingreso`.`FechaIngreso`<='" + xFechaF + "'\nAND IFNULL(`a_eventoecat_paciente`.`Id_Eventoecat`, 'NO TIENE') != 'NO TIENE'\n    AND `f_liquidacion`.`Estado` =0);";
                break;
            case 2:
                xsql = "SELECT\n    `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `f_empresacontxconvenio`.`Nbre`\n    , `ingreso`.`FechaIngreso`\n    , `ingreso`.`Id`\n    , IFNULL(`a_eventoecat_paciente`.`Id_Eventoecat`, 'NO TIENE') NEvento\n    , IF(`f_factura_evento`.`EstaArmada`=0, 'PENDIENTE', IF(`f_factura_evento`.`EstaArmada`=1,'ARMADA', 'PRESENTADA')) Estado\n    , IFNULL(d.Seguimiento, 'SIN SEGUIMIENTO') Seguimiento\n    , CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`) NFactura\n    , IFNULL(e.NUsuario,'') AS NRegistro\nFROM\n    `ingreso`\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `f_liquidacion` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `g_empresacont` \n        ON (`g_empresacont`.`Id_empresa` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `f_tipoempresacont` \n        ON (`g_empresacont`.`Id_TipoEmprCont` = `f_tipoempresacont`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    LEFT JOIN `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN (SELECT `Id`, GROUP_CONCAT(CONCAT(`FechaD`, ' ',`Observacion`) ORDER BY FechaD SEPARATOR '\\n' ) Seguimiento,\n        `Estado`, `GAlerta`, Id_Ingreso\n        FROM `ingreso_seguimiento` GROUP BY Id_Ingreso ORDER BY `FechaD` DESC)\n        d  ON (d.Id_Ingreso =`ingreso`.`Id` AND d.Estado=1 AND d.GAlerta=1)\n    LEFT JOIN (SELECT\n     `persona`.`NUsuario`\n     ,a_eventoecat.`Estado`\n     ,`a_eventoecat_paciente`.`Id_Ingreso`\n    FROM\n    `a_eventoecat_paciente`\n    INNER JOIN `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n    INNER JOIN `g_usuario_sist` \n        ON (`a_eventoecat`.`UsuarioS` = `g_usuario_sist`.`Login`)\n    INNER JOIN `persona` \n        ON (`g_usuario_sist`.`Id_Persona` = `persona`.`Id_persona`) GROUP BY `a_eventoecat_paciente`.`Id_Ingreso`) e ON (e.Id_Ingreso=`ingreso`.`Id` AND e.Estado=1) \nWHERE (`f_tipoempresacont`.`Id` ='" + xIdGenerico + "'\nAND `ingreso`.`FechaIngreso`>='" + xFechaI + "' AND `ingreso`.`FechaIngreso`<='" + xFechaF + "'\nAND IFNULL(`a_eventoecat_paciente`.`Id_Eventoecat`, 'NO TIENE') = 'NO TIENE'\n    AND `f_liquidacion`.`Estado` =0);";
                break;
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.ConsultarIngresoSoatDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsultarIngresoSoatDTO g = new ConsultarIngresoSoatDTO();
                g.setIdTipoIdentificacion(rs.getString("Id_TipoIdentificacion"));
                g.setNDocumento(rs.getString("NoDocumento"));
                g.setNUsuario(rs.getString("NUsuario"));
                g.setIdSexo(rs.getString("Id_Sexo"));
                g.setTercero(rs.getString("Nbre"));
                g.setFechaIngreso(rs.getString("FechaIngreso"));
                g.setIdIngreso(Long.valueOf(rs.getLong("Id")));
                g.setNEvento(rs.getString("NEvento"));
                g.setEstado(rs.getString("Estado"));
                g.setSeguimiento(rs.getString("Seguimiento"));
                g.setNFactura(rs.getString("NFactura"));
                g.setURegistra(rs.getString("NRegistro"));
                return g;
            }
        };
        List<ConsultarIngresoSoatDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.ConsultarIngresoSoatDAO
    public List<GCGenericoDTO> listTipoEmpresa(String xFechaI, String xFechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.ConsultarIngresoSoatDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `f_tipoempresacont` WHERE (`Estado` =0) ORDER BY `Nbre` ASC;", mapper);
        return list;
    }
}
