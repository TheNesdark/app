package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO;
import com.genoma.plus.dto.historia.AnexoDosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/InformacionAtencionAnexo2DAOImpl.class */
public class InformacionAtencionAnexo2DAOImpl implements InformacionAtencionAnexo2DAO {
    private JdbcTemplate jdbcTemplate;
    RowMapper<Object[]> mapper = new RowMapper<Object[]>() { // from class: com.genoma.plus.dao.impl.historia.InformacionAtencionAnexo2DAOImpl.5
        /* JADX INFO: renamed from: mapRow, reason: merged with bridge method [inline-methods] */
        public Object[] m80mapRow(ResultSet rs, int rowNum) throws SQLException {
            Object[] fila = new Object[25];
            fila[0] = rs.getString("NAcompanante");
            fila[1] = rs.getString("TelefonoAcomp");
            return fila;
        }
    };

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO
    public List<Object[]> informacionAtencionAnexo2FiltradaIdIngreso(String idIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.InformacionAtencionAnexo2DAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[25];
                fila[0] = Long.valueOf(rs.getLong("Id"));
                fila[1] = rs.getString("IdAteAnexo2");
                fila[2] = rs.getString("FechaR");
                fila[3] = rs.getString("HoraR");
                fila[4] = Boolean.valueOf(rs.getBoolean("Remitido"));
                fila[5] = rs.getString("departamento");
                fila[6] = rs.getString("municipio");
                fila[7] = rs.getString("Nombre_Prestador_Remite");
                fila[8] = rs.getString("Codigo_Prestador_Remite");
                fila[9] = Integer.valueOf(rs.getInt("Triage"));
                fila[10] = rs.getString("MovitoConsulta");
                fila[11] = rs.getString("CodigoDxP");
                fila[12] = rs.getString("diagnosticoPrincipal");
                fila[13] = rs.getString("CodigoDxR1");
                fila[14] = rs.getString("diagnosticoRelacionado1");
                fila[15] = rs.getString("CodigoDxR2");
                fila[16] = rs.getString("diagnosticoRelacionado2");
                fila[17] = rs.getString("CodigoDxR3");
                fila[18] = rs.getString("diagnosticoRelacionado3");
                fila[19] = rs.getString("Destino");
                fila[20] = Long.valueOf(rs.getLong("IdIngreso"));
                fila[21] = Long.valueOf(rs.getLong("IdAtencion"));
                fila[22] = rs.getString("NProfesional");
                fila[23] = rs.getString("Especialidad");
                return fila;
            }
        };
        String xsql = "SELECT\n    `h_atencion_anexo_dos`.`Id`\n    , `h_atencion_anexo_dos`.`IdIngreso`\n    , `h_atencion_anexo_dos`.`IdAtencion`\n    , `h_atencion_anexo_dos`.`IdAteAnexo2`\n    , `h_atencion_anexo_dos`.`FechaR`\n    , `h_atencion_anexo_dos`.`HoraR`\n    , `h_atencion_anexo_dos`.`Remitido`\n    , IFNULL(UCASE(`g_departamento`.`Nbre`),'') AS `departamento`\n    , IFNULL(`g_municipio`.`Nbre`,'') AS `municipio`\n    , `h_atencion_anexo_dos`.`Nombre_Prestador_Remite`\n    , `h_atencion_anexo_dos`.`Codigo_Prestador_Remite`\n    , `h_atencion_anexo_dos`.`Triage`\n    , `h_atencion_anexo_dos`.`MovitoConsulta`\n    , `h_atencion_anexo_dos`.`CodigoDxP`\n    , ifnull(`g_patologia`.`Nbre`,'') AS `diagnosticoPrincipal`\n    , `h_atencion_anexo_dos`.`CodigoDxR1`\n    , IFNULL(`g_patologia_1`.`Nbre`,'') AS `diagnosticoRelacionado1`\n    ,  IFNULL(`h_atencion_anexo_dos`.`CodigoDxR2`, '') CodigoDxR2\n    , IFNULL(`g_patologia_2`.`Nbre`,'') AS `diagnosticoRelacionado2`\n    ,  IFNULL(`h_atencion_anexo_dos`.`CodigoDxR3`, '') CodigoDxR3\n    , IFNULL(`g_patologia_3`.`Nbre`,'') AS `diagnosticoRelacionado3`\n    , `h_atencion_anexo_dos`.`Destino`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\nFROM\n   `h_atencion_anexo_dos` \n    LEFT JOIN  `g_departamento` \n       ON (`g_departamento`.`Id` = `h_atencion_anexo_dos`.`Id_Departamento`)\n    LEFT JOIN  `g_municipio` \n        ON (`g_municipio`.`Id` = `h_atencion_anexo_dos`.`Id_Municipio`)\n    LEFT JOIN  `g_patologia` \n        ON (`g_patologia`.`Id` = `h_atencion_anexo_dos`.`CodigoDxP`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_1` \n        ON (`g_patologia_1`.`Id` = `h_atencion_anexo_dos`.`CodigoDxR1`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_2` \n        ON (`g_patologia_2`.`Id` = `h_atencion_anexo_dos`.`CodigoDxR2`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_3` \n        ON (`g_patologia_3`.`Id` = `h_atencion_anexo_dos`.`CodigoDxR3`)\n    INNER JOIN `profesional1`\n        ON (`h_atencion_anexo_dos`.`idProfesional` = `profesional1`.`Id_Persona`) AND (`h_atencion_anexo_dos`.`idEspecialidad` = `profesional1`.`IdEspecialidad`)\nWHERE (`h_atencion_anexo_dos`.`Estado` =1\n    AND `h_atencion_anexo_dos`.`IdIngreso` ='" + idIngreso + "');";
        System.out.println("Seleccion : " + xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO
    public List<Object[]> informacionHistoriaAtencionAnexo2FiltradaIdIngreso(String idIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.InformacionAtencionAnexo2DAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Fecha_Atencion"), rs.getString("Hora_Atencion"), Integer.valueOf(rs.getInt("Clasificacion")), rs.getString("Motivo_Atencion"), rs.getString("Codigo_DxP"), rs.getString("diagnosticoPrincipal"), rs.getString("Codigo_DxR1"), rs.getString("diagnosticoRelacionado1"), rs.getString("Codigo_DxR2"), rs.getString("diagnosticoRelacionado2"), rs.getString("Codigo_DxR3"), rs.getString("diagnosticoRelacionado3"), rs.getString("Destino"), rs.getString("NProfesional"), rs.getString("Especialidad"), rs.getString("EActual")};
                return fila;
            }
        };
        String xsql = "SELECT\n     `h_atencion`.`Fecha_Atencion`\n    , `h_atencion`.`Hora_Atencion`\n    , ifnull(`h_atencion`.`Motivo_Atencion`,'') AS Motivo_Atencion\n    , ifnull(`h_atencion`.`EActual`,'') AS EActual\n    , `h_triage`.`Clasificacion`   \n    , `h_atencion`.`Codigo_DxP`\n    , ifnull(`g_patologia`.`Nbre`,'') AS `diagnosticoPrincipal`\n    , ifnull(`h_atencion`.`Codigo_DxR1`, '') Codigo_DxR1\n    , ifnull(`g_patologia_1`.`Nbre`,'') AS `diagnosticoRelacionado1`\n    , ifnull(`h_atencion`.`Codigo_DxR2`, '')Codigo_DxR2\n    , ifnull(`g_patologia_2`.`Nbre`,'') AS `diagnosticoRelacionado2`\n    , ifnull(`h_atencion`.`Codigo_DxR3`, '') Codigo_DxR3\n    , ifnull(`g_patologia_3`.`Nbre`,'') AS `diagnosticoRelacionado3`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`,  IFNULL(h_atencion_anexo_dos.`Destino`, '') Destino\nFROM\n    `h_triage`\n    INNER JOIN  `h_atencion` \n        ON (`h_triage`.`IdIngreso` = `h_atencion`.`Id_Ingreso`)\n    LEFT JOIN  `g_patologia` \n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_1` \n        ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_2` \n        ON (`g_patologia_2`.`Id` = `h_atencion`.`Codigo_DxR2`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_3` \n        ON (`g_patologia_3`.`Id` = `h_atencion`.`Codigo_DxR3`)\n    INNER JOIN `profesional1`\n        ON (`h_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_atencion`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)\n LEFT JOIN h_atencion_anexo_dos ON (h_atencion_anexo_dos.`IdAtencion`=h_atencion.`Id`) \nWHERE (`h_atencion`.`Id_Ingreso` ='" + idIngreso + "' AND h_atencion.`Estado`=0)";
        System.out.println("Seleccion : " + xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO
    public Long crear(final AnexoDosDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.InformacionAtencionAnexo2DAOImpl.3
            final String sql = "INSERT INTO `h_atencion_anexo_dos` (`IdAtencion`  , `IdAteAnexo2` , `IdUsuarioS` , `FechaR` , `HoraR` , `Remitido` , `Id_Departamento`, `Id_Municipio`\n    , `Nombre_Prestador_Remite` , `Codigo_Prestador_Remite` , `Triage` , `MovitoConsulta` , `CodigoDxP` , `CodigoDxR1`\n    , `CodigoDxR2` , `CodigoDxR3` , `Destino` , `Fecha` , `Estado` , `Id_Remoto` , `UsuarioS`,`IdIngreso`, `idProfesional`, `IdEspecialidad`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_atencion_anexo_dos` (`IdAtencion`  , `IdAteAnexo2` , `IdUsuarioS` , `FechaR` , `HoraR` , `Remitido` , `Id_Departamento`, `Id_Municipio`\n    , `Nombre_Prestador_Remite` , `Codigo_Prestador_Remite` , `Triage` , `MovitoConsulta` , `CodigoDxP` , `CodigoDxR1`\n    , `CodigoDxR2` , `CodigoDxR3` , `Destino` , `Fecha` , `Estado` , `Id_Remoto` , `UsuarioS`,`IdIngreso`, `idProfesional`, `IdEspecialidad`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, e.getIdAtencion().longValue());
                ps.setLong(2, e.getIdAteAnexo2().longValue());
                ps.setLong(3, e.getIdUsuarioRecursoHumano().longValue());
                ps.setString(4, e.getFechaReporte());
                ps.setString(5, e.getHoraReporte());
                ps.setBoolean(6, e.getEsRemitido().booleanValue());
                ps.setString(7, e.getIdDepartamento());
                ps.setString(8, e.getIdMunicipio());
                ps.setString(9, e.getNombrePrestadorRemite());
                ps.setString(10, e.getCodigoPrestadorRemite());
                ps.setInt(11, e.getClasificacionTriage().intValue());
                ps.setString(12, e.getMovitoConsulta());
                ps.setString(13, e.getCodigoDxP());
                ps.setString(14, e.getCodigoDxR1());
                ps.setString(15, e.getCodigoDxR2());
                ps.setString(16, e.getCodigoDxR3());
                ps.setString(17, e.getDestino());
                ps.setString(18, e.getFecha());
                ps.setBoolean(19, e.getEstado().booleanValue());
                ps.setString(21, e.getUsuarioSistema());
                ps.setLong(20, e.getIdRemoto().longValue());
                ps.setLong(22, e.getIdIngreso().longValue());
                ps.setLong(23, e.getIdProfesional().longValue());
                ps.setLong(24, e.getIdEspecialidad().longValue());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idExamenFisico = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idExamenFisico;
    }

    @Override // com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO
    public Long consultarConsecutivoFecha(String fecha) {
        String sql1 = "SELECT IFNULL(MAX(`IdAteAnexo2`),1) AS `Consecutivo` FROM  `h_atencion_anexo_dos` WHERE (`FechaR` ='" + fecha + "')";
        System.out.println("" + sql1);
        try {
            return (Long) this.jdbcTemplate.queryForObject(sql1, Long.class);
        } catch (EmptyResultDataAccessException e) {
            return 1L;
        }
    }

    @Override // com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO
    public List<Object[]> informacionIngresoAnexo2Res2335(String idIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.InformacionAtencionAnexo2DAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("anexoInformacionIpsDto"), rs.getString("anexoDatoUsuarioDto"), rs.getString("causaExterna"), rs.getString("modalidadAtencion"), rs.getString("codigo_rips_homologado"), rs.getString("fechaIngreso")};
                return fila;
            }
        };
        String xsql = "WITH maestra AS (\nSELECT\ni.Id ,\nfe.CRips codigoEntidadPagadora,\ngp2.Apellido1 primerApellido,\ngp2.Apellido2 segundoApellido,\ngp2.Nombre1 primerNombre,\ngp2.Nombre2 segundoNombre,\ngp2.Id_TipoIdentificacion tipoDocumento,\ngp2.NoDocumento numeroDocumento,\ngp2.FechaNac fechaNacimiento,\ngp2.Direccion direccion,\nIF(gp2.Telefono='',gp2.Movil,gp2.Telefono) telefono,\ngp2.Id_Municipio municipio,\n'' as  correo,\ngc.codigo causaAtencion,\nha.Codigo_Dxp diagnostico,\nha.Codigo_DxR1 diagnosticoRelacionado1,\nha.Codigo_DxR2 diagnosticoRelacionado2,\nha.Codigo_DxR3 diagnosticoRelacionado3,\ng_ips.`Identificacion` ,\ng_ips.`CodigoOrganismo` ,\n' ' as `NPersonaResp` ,\n' ' as `TelefonoAcomp` ,\ngma.`codigo` AS modalidadAtencion,\ngc.`codigo` AS causaExterna,\n'' AS numeroAutorizacion ,\ngom.codigo_rips_homologado,  CONCAT(i.`FechaIngreso`,' ',i.HoraIngreso) fechaIngreso, \nCASE\n    WHEN gp2.Correo REGEXP '^[a-zA-Z0-9._%-]@[a-zA-Z0-9.-]\\\\\\\\.[a-zA-Z]{2,}$' THEN 'Válido'\n        ELSE 'No válido'\n    END AS estado_correo\nFROM `g_ips` , ingreso i\nINNER JOIN h_atencion ha ON (i.`Id`=ha.`Id_Ingreso`)\nINNER JOIN g_causaexterna gc ON (i.Id_CausaExterna=gc.Id)\nINNER JOIN f_empresacontxconvenio fe ON (fe.Id=i.Id_EmpresaContxConv)\nINNER JOIN g_persona gp2 ON (gp2.Id=i.Id_Usuario)\nINNER JOIN g_usuario gu ON (gu.Id_persona=gp2.Id)\nINNER JOIN g_modalidad_atencion gma  ON (`i`.`idModalidad` = `gma`.`id`)\nINNER JOIN `g_origenadmision` gom ON i.`Id_OrigenAdmision`=gom.`Id`\nWHERE i.Id ='" + idIngreso + "'\n)\nSELECT \n JSON_OBJECT(\n      \n            'primerApellido', m.primerApellido,\n            'segundoApellido', m.segundoApellido,\n            'primerNombre', m.primerNombre,\n            'segundoNombre', m.segundoNombre,\n            'tipoDocumento', m.tipoDocumento,\n            'numeroDocumento', m.numeroDocumento,\n            'fechaNacimiento', m.fechaNacimiento,\n            'direccion', m.direccion,\n            'telefono', m.telefono,\n            'municipio', m.municipio,\n            'correo', m.correo,\n            'direccionAlternativa' ,m.direccion,\n            'nombreContactoEmergencia',m.NPersonaResp,\n\t       'telefonoContactoEmergencia',m.TelefonoAcomp\n           \n     \n\n ) AS anexoDatoUsuarioDto,\n  JSON_OBJECT(\n      'numeroAutorizacion',m.numeroAutorizacion,  \n            'codigoEntidadPagadora', m.codigoEntidadPagadora,\n            'codigoPrestador', m.CodigoOrganismo,\n            'numeroIdentificacionIps', m.Identificacion\n    ) AS anexoInformacionIpsDto\n    ,m.modalidadAtencion\n    ,m.causaExterna\n    ,m.codigo_rips_homologado ,m.fechaIngreso \nFROM maestra m\nGROUP BY m.Id ";
        System.out.println("Seleccion : " + xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO
    public List<Object[]> informacionAtencionAnexo2FiltradaIdIngresoAnexonuevo(String idIngreso) {
        RowMapper mapper = (rs, rowNum) -> {
            Object[] fila = {rs.getString("FechaTriage"), rs.getString("HoraTriage"), Integer.valueOf(rs.getInt("Clasificacion")), rs.getString("Patologias"), rs.getString("NProfesional"), rs.getString("Especialidad"), Long.valueOf(rs.getLong("Id")), rs.getString("codgoDxP"), rs.getString("nombreDxP"), rs.getString("codgoDxR1"), rs.getString("nombreDxR1"), rs.getString("codgoDxR2"), rs.getString("nombreDxR2"), rs.getString("codgoDxR3"), rs.getString("nombreDxR3")};
            return fila;
        };
        String xsql = "SELECT\n     `h_triage`.FechaTriage \n    , `h_triage`.HoraTriage \n    , `h_triage`.`Clasificacion`   \n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    -- ,  IFNULL(h_atencion_anexo_dos.`Destino`, '') Destino\n    ,  GROUP_CONCAT(concat(htd.Id_Patologia,'_',gp.Nbre) ORDER BY htd.NOrden ASC SEPARATOR ',') AS Patologias, h_triage.Id \n    , ifnull(gp2.Id, '') codgoDxP\n    , ifnull(gp2.Nbre, '')  nombreDxP\n    , ifnull(gp3.Id, '') codgoDxR1\n    , ifnull(gp3.Nbre, '')  nombreDxR1\n    , ifnull(gp4.Id, '') codgoDxR2\n    , ifnull(gp4.Nbre, '')  nombreDxR2\n    , ifnull(gp5.Id, '') codgoDxR3\n    , ifnull(gp5.Nbre, '')  nombreDxR3\nFROM\n    `h_triage`\n\tleft join h_triage_diagnostico htd\n\ton (htd.Id_Triage=h_triage.Id)\n\tleft join g_patologia gp\n\ton (gp.Id=htd.Id_Patologia)    \n\tleft join h_atencion ha on (ha.Id_Ingreso =`h_triage`.IdIngreso )\n\tleft join g_patologia gp2 on (gp2.Id =ha.Codigo_Dxp )\n\tleft join g_patologia gp3 on (gp3.Id =ha.Codigo_DxR1 )\n\tleft join g_patologia gp4 on (gp4.Id =ha.Codigo_DxR2 )\n\tleft join g_patologia gp5 on (gp5.Id =ha.Codigo_DxR3 )\n    INNER JOIN `profesional1`\n        ON (`h_triage`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`h_triage`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) \nWHERE (`h_triage`.IdIngreso  =" + idIngreso + " AND h_triage.`Estado`=0)\nGROUP by h_triage.Id ";
        System.out.println("Seleccion : " + xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.InformacionAtencionAnexo2DAO
    public Optional<List<Object[]>> obtenerInformacionIngresoAnexo2Res2335(Long idIngreso) {
        List<Object[]> resultList = this.jdbcTemplate.query("SELECT     `NAcompanante`     , `TelefonoAcomp` FROM  `ingreso` WHERE ingreso.`Id` = ?", new Object[]{idIngreso}, this.mapper);
        return Optional.of(resultList);
    }
}
