package com.genoma.plus.dao.impl.facturacion;

import Acceso.Principal;
import com.genoma.plus.dao.facturacion.OrdenAnexo3DAO;
import com.genoma.plus.dto.facturacion.OrdenAnexo3DTO;
import com.genoma.plus.dto.facturacion.OrdenesAnexo3DetalleDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/OrdenAnexo3DAOImpl.class */
public class OrdenAnexo3DAOImpl implements OrdenAnexo3DAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.OrdenAnexo3DAO
    public String create_return_id_Anexo3(final OrdenAnexo3DTO anexo) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.facturacion.OrdenAnexo3DAOImpl.1
            final String sql = "INSERT INTO `f_ordene_anexo_tres` (`IdIngreso`,`IdOrden`,`IdAteAnexo3`,`IdUsuarioS`,`FechaR`,`HoraR`,`justificacion`,`idProfesional`,`idEspecialidad`,`Estado`,`UsuarioS`, dxP, dxR1, dxR2, tipoPrioridad, tipoAtencion)\nVALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `f_ordene_anexo_tres` (`IdIngreso`,`IdOrden`,`IdAteAnexo3`,`IdUsuarioS`,`FechaR`,`HoraR`,`justificacion`,`idProfesional`,`idEspecialidad`,`Estado`,`UsuarioS`, dxP, dxR1, dxR2, tipoPrioridad, tipoAtencion)\nVALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, anexo.getIdIngreso().longValue());
                ps.setLong(2, anexo.getIdOrden().longValue());
                ps.setLong(3, anexo.getIdAteAnexo3().longValue());
                ps.setLong(4, Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue());
                ps.setString(5, anexo.getFechaR());
                ps.setString(6, anexo.getHoraR());
                ps.setString(7, anexo.getJustificacion());
                ps.setLong(8, anexo.getIdProfesional().longValue());
                ps.setLong(9, anexo.getIdEspecialidad().longValue());
                ps.setInt(10, 1);
                ps.setString(11, Principal.usuarioSistemaDTO.getLogin());
                ps.setString(12, anexo.getDxP());
                ps.setString(13, anexo.getDxR1());
                ps.setString(14, anexo.getDxR2());
                ps.setInt(15, anexo.getTipoPrioridad());
                ps.setInt(16, anexo.getTipoAtencion());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdAnexo = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xAnexno-->" + xIdAnexo);
        return xIdAnexo;
    }

    @Override // com.genoma.plus.dao.facturacion.OrdenAnexo3DAO
    public String mcreate(OrdenesAnexo3DetalleDTO anexoDetalle) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `f_orden_anexo_tres_detalle` (`idOrdenAnexo`,`IdProcedimiento`,`cantidad`,`numeroAutorizacion`)\nVALUES (?,?,?,?);", new Object[]{anexoDetalle.getIdOrdenAnexo(), anexoDetalle.getIdProcedimiento(), Integer.valueOf(anexoDetalle.getCantidad()), anexoDetalle.getNumeroAutorizacion()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.facturacion.OrdenAnexo3DAO
    public List<Object[]> listadoDeProcedimientosAnexo(String idOrdenAnexo) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.OrdenAnexo3DAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("procedimiento"), Integer.valueOf(rs.getInt("cantidad"))};
                return fila;
            }
        };
        String xSql = "SELECT\n    `g_procedimiento`.`Id`\n    , `g_procedimiento`.`Nbre` AS `procedimiento`\n    , `f_orden_anexo_tres_detalle`.`cantidad`\nFROM\n    `g_procedimiento`\n    INNER JOIN `f_orden_anexo_tres_detalle` \n        ON (`g_procedimiento`.`Id` = `f_orden_anexo_tres_detalle`.`IdProcedimiento`)\nWHERE (`f_orden_anexo_tres_detalle`.`idOrdenAnexo` ='" + idOrdenAnexo + "');";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.OrdenAnexo3DAO
    public List<Object[]> listadoDeAnexos(String idIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.OrdenAnexo3DAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), Long.valueOf(rs.getLong("IdIngreso")), Long.valueOf(rs.getLong("IdAteAnexo3")), rs.getString("FechaR"), rs.getString("HoraR"), rs.getString("justificacion"), rs.getString("NProfesional"), rs.getString("Especialidad"), rs.getString("dxP"), rs.getString("dxR1"), rs.getString("dxR2"), rs.getString("numeroAutorizacion"), rs.getString("idOrdenDetalle")};
                return fila;
            }
        };
        String xSql = "SELECT\n    `f_ordene_anexo_tres`.`Id`\n    , `f_ordene_anexo_tres`.`IdIngreso`\n    , `f_ordene_anexo_tres`.`IdAteAnexo3`\n    , `f_ordene_anexo_tres`.`FechaR`\n    , `f_ordene_anexo_tres`.`HoraR`\n    , `f_ordene_anexo_tres`.`justificacion`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , `f_ordene_anexo_tres`.`dxP`\n    , `f_ordene_anexo_tres`.`dxR1`\n    , `f_ordene_anexo_tres`.`dxR2`\n    , f_orden_anexo_tres_detalle.`numeroAutorizacion` \n    , f_orden_anexo_tres_detalle.Id AS idOrdenDetalle \nFROM\n    `profesional1`\n    INNER JOIN `f_ordene_anexo_tres` \n        ON (`profesional1`.`IdEspecialidad` = `f_ordene_anexo_tres`.`idEspecialidad`) AND (`profesional1`.`Id_Persona` = `f_ordene_anexo_tres`.`idProfesional`)\n    LEFT JOIN `f_orden_anexo_tres_detalle`\n    ON ( `f_orden_anexo_tres_detalle`.`idOrdenAnexo` = `f_ordene_anexo_tres`.`Id`) \nWHERE (`f_ordene_anexo_tres`.`IdIngreso` ='" + idIngreso + "' AND `f_ordene_anexo_tres`.`Estado` =1) group by  `f_ordene_anexo_tres`.`Id`\nORDER BY `f_ordene_anexo_tres`.`Id` DESC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.OrdenAnexo3DAO
    public List<OrdenAnexo3DTO> obtieneElConsecutivoDelDia(String fecha) {
        String sql = "SELECT\n    (IFNULL(MAX(`IdAteAnexo3`),0)+1) AS consecutivo\nFROM\n    `f_ordene_anexo_tres`\nWHERE (`FechaR` ='" + fecha + "');";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.OrdenAnexo3DAOImpl.4
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                OrdenAnexo3DTO evidencia = new OrdenAnexo3DTO();
                evidencia.setIdAteAnexo3(Long.valueOf(rs.getLong("consecutivo")));
                return evidencia;
            }
        };
        List<OrdenAnexo3DTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.facturacion.OrdenAnexo3DAO
    public List<Object[]> listadoDeDatosDeLaAtencion(String idIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.OrdenAnexo3DAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Fecha_Atencion"), rs.getString("Hora_Atencion"), rs.getString("EActual"), rs.getString("Codigo_DxP"), rs.getString("diagnosticoPrincipal"), rs.getString("Codigo_DxR1"), rs.getString("diagnosticoRelacionado1"), rs.getString("Codigo_DxR2"), rs.getString("diagnosticoRelacionado2"), rs.getString("NProfesional"), rs.getString("Especialidad")};
                return fila;
            }
        };
        String xSql = "SELECT\n     DATE_FORMAT(`h_atencion`.`Fecha_Atencion`, '%d-%m-%Y') Fecha_Atencion \n    , `h_atencion`.`Hora_Atencion`\n    , IFNULL(`h_atencion`.`EActual`,'') AS EActual\n    , `h_atencion`.`Codigo_DxP`\n    , IFNULL(`g_patologia`.`Nbre`,'') AS `diagnosticoPrincipal`\n    , `h_atencion`.`Codigo_DxR1`\n    , IFNULL(`g_patologia_1`.`Nbre`,'') AS `diagnosticoRelacionado1`\n    , `h_atencion`.`Codigo_DxR2`\n    , IFNULL(`g_patologia_2`.`Nbre`,'') AS `diagnosticoRelacionado2`    \n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\nFROM\n    h_atencion    \n    LEFT JOIN  `g_patologia` \n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_1` \n        ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_2` \n        ON (`g_patologia_2`.`Id` = `h_atencion`.`Codigo_DxR2`)    \n    INNER JOIN `profesional1`\n        ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)\nWHERE (`h_atencion`.`Id_Ingreso` ='" + idIngreso + "' AND h_atencion.`Estado`=0)";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.OrdenAnexo3DAO
    public String mUpdateAnexo3(OrdenesAnexo3DetalleDTO anexoDetalle) {
        String result = "";
        int ctos = this.jdbcTemplate.update(" UPDATE\n  `baseserver`.`f_orden_anexo_tres_detalle`\nSET \n  `numeroAutorizacion` = ?\nWHERE `idOrdenAnexo` = ?;", new Object[]{anexoDetalle.getNumeroAutorizacion(), anexoDetalle.getIdOrdenAnexo()});
        if (ctos == 0) {
            result = "0";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.facturacion.OrdenAnexo3DAO
    public List<Object[]> informacionIngresoAnexo3Res2335(String idIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.OrdenAnexo3DAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("anexoInformacionIpsDto"), rs.getString("anexoDatoUsuarioDto"), rs.getString("causaExterna"), rs.getString("modalidadAtencion")};
                return fila;
            }
        };
        String xsql = "WITH maestra AS (\nSELECT\ni.Id ,\nfe.CRips codigoEntidadPagadora,\ngp2.Apellido1 primerApellido,\ngp2.Apellido2 segundoApellido,\ngp2.Nombre1 primerNombre,\ngp2.Nombre2 segundoNombre,\ngp2.Id_TipoIdentificacion tipoDocumento,\ngp2.NoDocumento numeroDocumento,\ngp2.FechaNac fechaNacimiento,\ngp2.Direccion direccion,\nIF(gp2.Telefono='',gp2.Movil,gp2.Telefono) telefono,\ngp2.Id_Municipio municipio,\ngp2.Correo as  correo,\ngc.codigo causaAtencion,\nha.Codigo_Dxp diagnostico,\nha.Codigo_DxR1 diagnosticoRelacionado1,\nha.Codigo_DxR2 diagnosticoRelacionado2,\nha.Codigo_DxR3 diagnosticoRelacionado3,\ng_ips.`Identificacion` ,\ng_ips.`CodigoOrganismo` ,\n' ' as `NPersonaResp` ,\n' ' as `TelefonoAcomp` ,\ngma.`codigo` AS modalidadAtencion,\ngc.`codigo` AS causaExterna,\n'' AS numeroAutorizacion ,\ngom.codigoRes1936,  CONCAT(i.`FechaIngreso`,' ',i.HoraIngreso) fechaIngreso, \nCASE\n    WHEN gp2.Correo REGEXP '^[a-zA-Z0-9._%-]@[a-zA-Z0-9.-]\\\\\\\\.[a-zA-Z]{2,}$' THEN 'Válido'\n        ELSE 'No válido'\n    END AS estado_correo\nFROM `g_ips` , ingreso i\nINNER JOIN h_atencion ha ON (i.`Id`=ha.`Id_Ingreso`)\nINNER JOIN g_causaexterna gc ON (i.Id_CausaExterna=gc.Id)\nINNER JOIN f_empresacontxconvenio fe ON (fe.Id=i.Id_EmpresaContxConv)\nINNER JOIN g_persona gp2 ON (gp2.Id=i.Id_Usuario)\nINNER JOIN g_usuario gu ON (gu.Id_persona=gp2.Id)\nINNER JOIN g_modalidad_atencion gma  ON (`i`.`idModalidad` = `gma`.`id`)\nINNER JOIN `g_origenadmision` gom ON i.`Id_OrigenAdmision`=gom.`Id`\nWHERE i.Id ='" + idIngreso + "'\n)\nSELECT \n JSON_OBJECT(\n      \n            'primerApellido', m.primerApellido,\n            'segundoApellido', m.segundoApellido,\n            'primerNombre', m.primerNombre,\n            'segundoNombre', m.segundoNombre,\n            'tipoDocumento', m.tipoDocumento,\n            'numeroDocumento', m.numeroDocumento,\n            'fechaNacimiento', m.fechaNacimiento,\n            'direccion', m.direccion,\n            'telefono', m.telefono,\n            'municipio', m.municipio,\n            'correo', m.correo,\n            'direccionAlternativa' ,m.direccion,\n            'nombreContactoEmergencia',m.NPersonaResp,\n\t       'telefonoContactoEmergencia',m.TelefonoAcomp\n           \n     \n\n ) AS anexoDatoUsuarioDto,\n  JSON_OBJECT(\n      'numeroAutorizacion',m.numeroAutorizacion,  \n            'codigoEntidadPagadora', m.codigoEntidadPagadora,\n            'codigoPrestador', m.CodigoOrganismo,\n            'numeroIdentificacionIps', m.Identificacion\n    ) AS anexoInformacionIpsDto\n    ,m.modalidadAtencion\n    ,m.causaExterna\n    ,m.codigoRes1936 ,m.fechaIngreso \nFROM maestra m\nGROUP BY m.Id ";
        System.out.println("Seleccion : " + xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.OrdenAnexo3DAO
    public List<Object[]> historicoAnexo3Res2335(String idIngreso, String tipo) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.OrdenAnexo3DAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("idIngreso"), rs.getString("idEnexo"), rs.getString("fechaRegistro"), rs.getString("tipoAnexo"), rs.getString("NProfesional"), rs.getString("Especialidad")};
                return fila;
            }
        };
        String xsql = "SELECT\n    `ingreso`.`Id` AS `idIngreso`\n    , `h_anexo_resolucion_2335`.`id` AS `idEnexo`\n    , `h_anexo_resolucion_2335`.`fechaRegistro`\n    , `h_anexo_resolucion_2335`.`tipoAnexo`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\nFROM\n    `baseserver`.`h_anexo_resolucion_2335`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_anexo_resolucion_2335`.`ingresoId` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`profesional1` \n        ON (`h_anexo_resolucion_2335`.`profesionalId` = `profesional1`.`Id_Persona`)\n         AND (`h_anexo_resolucion_2335`.`especialidadId` = `profesional1`.`IdEspecialidad`)\n         where `ingreso`.`Id`='" + idIngreso + "' \n         and h_anexo_resolucion_2335.`tipoAnexo`='" + tipo + "'";
        System.out.println("Seleccion : " + xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
