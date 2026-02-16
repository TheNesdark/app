package com.genoma.plus.dao.impl.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.sgc.InformesSgcDAO;
import com.genoma.plus.dto.sgc.CantidadCitasOdontDTO;
import com.genoma.plus.dto.sgc.CantidadProcedimientosOdontDTO;
import com.genoma.plus.dto.sgc.ConNominaxUsuarioDTO;
import com.genoma.plus.dto.sgc.InasistenciaOdontDTO;
import com.genoma.plus.dto.sgc.ProcedimientosPacienteOdontDTO;
import com.genoma.plus.dto.sgc.RegistroDiarioOdontologiaDTO;
import com.genoma.plus.dto.sgc.SGC_ConsultarPanoramaEventoDTO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/InformesSgcDAOImpl.class */
public class InformesSgcDAOImpl implements InformesSgcDAO {
    private Metodos xmt = new Metodos();
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<ConNominaxUsuarioDTO> list() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ConNominaxUsuarioDTO Nomina = new ConNominaxUsuarioDTO();
                Nomina.setId(rs.getInt("Id"));
                Nomina.setFechaD(rs.getString("FechaD"));
                Nomina.setId_PersonaDescuento(rs.getInt("Id_PersonaDescuento"));
                Nomina.setNoHistoria(rs.getString("NoHistoria"));
                Nomina.setCodigo1Sap(rs.getString("Codigo1Sap"));
                Nomina.setNUsuarios(rs.getString("NUsuarios"));
                Nomina.setVDescontado(rs.getString("VDescontado"));
                Nomina.setValor(rs.getString("Valor"));
                Nomina.setDebe(rs.getString("Debe"));
                Nomina.setRLaboral(rs.getString("RLaboral"));
                return Nomina;
            }
        };
        List<ConNominaxUsuarioDTO> lsEstrato = this.jdbcTemplate.query("SELECT d_descuento.`Id`, d_descuento.`FechaD`, `d_descuento`.`Id_PersonaDescuento` ,`g_usuario`.`NoHistoria` , `g_persona`.`Codigo1Sap` , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuarios` ,  `d_descuento`.`VDescontado`,`d_descuento`.`Valor`, (`d_descuento`.`Valor`-`d_descuento`.VDescontado) Debe ,g_relacionlaboral.`Nbre` AS RLaboral   FROM  `g_persona` INNER JOIN  `d_descuento`  ON (`g_persona`.`Id` = `d_descuento`.`Id_PersonaDescuento`)  INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  INNER JOIN  `g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)  INNER JOIN  `g_tipoempresa`  ON (`g_usuario_fpz`.`Id_Empresa` = `g_tipoempresa`.`Id`)  INNER JOIN  `g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`) WHERE (`d_descuento`.`Valor` <>`d_descuento`.`VDescontado` AND `d_descuento`.`Estado` =0) GROUP BY d_descuento.`Id`, `d_descuento`.`Id_PersonaDescuento` ORDER BY `g_tipoempresa`.id, NUsuarios ASC", rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<SGC_ConsultarPanoramaEventoDTO> listPanoramaProceso(String xidTipoProceso) {
        String sql = "SELECT\n    `s_sgc_tipoproceso`.`Nbre` AS `NProceso`\n    , `s_sgc_sc_tiporiesgo`.`Nbre` AS `NRiesgo`\n    , `s_sgc_sc_tipoevento`.`Nbre` AS `NEvento`\n    , IFNULL(c.NConsecuencia, '') NCOnsecuencias\n    , IFNULL(a.NAccionInmediata, '') NAccionInmediata\n     , IFNULL(d.NAccionCorrectiva, '') NAccionCorrectiva\nFROM `s_sgc_sc_triesgo_tevento`\n    INNER JOIN  `s_sgc_sc_tipoevento`\n        ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`)\n    INNER JOIN  `s_sgc_sc_tiporiesgo`\n        ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoRiesgo` = `s_sgc_sc_tiporiesgo`.`Id`)\n    INNER JOIN  `s_sgc_sc_tproceso_triesgo`\n        ON (`s_sgc_sc_tproceso_triesgo`.`Id_TRiesgo_TEvento` = `s_sgc_sc_triesgo_tevento`.`Id`)\n    INNER JOIN  `s_sgc_tipoproceso`\n        ON (`s_sgc_sc_tproceso_triesgo`.`Id_TProceso` = `s_sgc_tipoproceso`.`Id`)\n-- CONSECUENCIAS\n    LEFT JOIN(SELECT\n    GROUP_CONCAT(CONCAT('- ',`s_sgc_sc_tipocosecuencia_acciones`.`Nbre`) SEPARATOR '\\n') NConsecuencia, `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nFROM\n     `s_sgc_sc_tipoevento_tipoca`\n    INNER JOIN  `s_sgc_sc_tipocosecuencia_acciones`\n        ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`)\nWHERE ( `s_sgc_sc_tipocosecuencia_acciones`.`Tipo` =0 AND s_sgc_sc_tipocosecuencia_acciones.`Estado`=1)\nGROUP BY `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nORDER BY `s_sgc_sc_tipoevento_tipoca`.`NOrden` ASC) c ON (s_sgc_sc_tipoevento.`Id`=c.Id_TipoEvento)\n-- ACCION INMEDIATA\nLEFT JOIN(SELECT\n    GROUP_CONCAT(CONCAT('- ',`s_sgc_sc_tipocosecuencia_acciones`.`Nbre`) SEPARATOR '\\n') NAccionInmediata, `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nFROM\n     `s_sgc_sc_tipoevento_tipoca`\n    INNER JOIN  `s_sgc_sc_tipocosecuencia_acciones`\n        ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`)\nWHERE ( `s_sgc_sc_tipocosecuencia_acciones`.`Tipo` =1 AND s_sgc_sc_tipocosecuencia_acciones.`Estado`=1)\nGROUP BY `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nORDER BY `s_sgc_sc_tipoevento_tipoca`.`NOrden` ASC) a ON (s_sgc_sc_tipoevento.`Id`=a.Id_TipoEvento)\n\n-- ACCION CORRECTIVA\nLEFT JOIN(SELECT\n    GROUP_CONCAT(CONCAT('- ',`s_sgc_sc_tipocosecuencia_acciones`.`Nbre`) SEPARATOR '\\n') NAccionCorrectiva, `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nFROM\n     `s_sgc_sc_tipoevento_tipoca`\n    INNER JOIN  `s_sgc_sc_tipocosecuencia_acciones`\n        ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`)\nWHERE ( `s_sgc_sc_tipocosecuencia_acciones`.`Tipo` =2 AND s_sgc_sc_tipocosecuencia_acciones.`Estado`=1)\nGROUP BY `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nORDER BY `s_sgc_sc_tipoevento_tipoca`.`NOrden` ASC) d ON (s_sgc_sc_tipoevento.`Id`=d.Id_TipoEvento)\n\n WHERE (s_sgc_tipoproceso.`Id`='" + xidTipoProceso + "')\nORDER BY `s_sgc_sc_tproceso_triesgo`.`Norden` ASC, `s_sgc_sc_triesgo_tevento`.`NOrden` ASC;  ";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_ConsultarPanoramaEventoDTO Panorama = new SGC_ConsultarPanoramaEventoDTO();
                Panorama.setNProceso(rs.getString("NProceso"));
                Panorama.setNRiesgo(rs.getString("NRiesgo"));
                Panorama.setNEvento(rs.getString("NEvento"));
                Panorama.setNConsecuencias(rs.getString("NCOnsecuencias"));
                Panorama.setNAccionInmediata(rs.getString("NAccionInmediata"));
                Panorama.setNAccionCorrectiva(rs.getString("NAccionCorrectiva"));
                return Panorama;
            }
        };
        List<SGC_ConsultarPanoramaEventoDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<SGC_ConsultarPanoramaEventoDTO> listPanoramaEvento(String xidTipoProceso, String xidTipoEvento) {
        String sql = "SELECT\n    `s_sgc_tipoproceso`.`Id`\n    , `s_sgc_tipoproceso`.`Nbre` AS `NProceso`\n    , `s_sgc_sc_tiporiesgo`.`Nbre` AS `NRiesgo`\n    , `s_sgc_sc_tipoevento`.`Nbre` AS `NEvento`\n    , IFNULL(c.NConsecuencia, '') NCOnsecuencias\n    , IFNULL(a.NAccionInmediata, '') NAccionInmediata\n     , IFNULL(d.NAccionCorrectiva, '') NAccionCorrectiva\n      ,  CONCAT(`d_ips`.`TipoIdEmpresa`,' ', `d_ips`.`IdConcatenado`) AS NitEmpresa\n    , `d_ips`.`NEmpresa`\n    , `d_ips`.`Direccion`\n    , `d_ips`.`Telefono`\n    , `d_ips`.`Fax`\n    , `d_ips`.`Correo`\n    , `d_ips`.`NMunicipio`\n    , `d_ips`.`NDepartamento`\n    , `d_ips`.`Logo`\n    , `d_ips`.`LogoC`\n, `d_ips`.`UrlLogoSuperS`\nFROM d_ips,\n     `s_sgc_sc_triesgo_tevento`\n    INNER JOIN  `s_sgc_sc_tipoevento`\n        ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`)\n    INNER JOIN  `s_sgc_sc_tiporiesgo`\n        ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoRiesgo` = `s_sgc_sc_tiporiesgo`.`Id`)\n    INNER JOIN  `s_sgc_sc_tproceso_triesgo`\n        ON (`s_sgc_sc_tproceso_triesgo`.`Id_TRiesgo_TEvento` = `s_sgc_sc_triesgo_tevento`.`Id`)\n    INNER JOIN  `s_sgc_tipoproceso`\n        ON (`s_sgc_sc_tproceso_triesgo`.`Id_TProceso` = `s_sgc_tipoproceso`.`Id`)\n-- CONSECUENCIAS\n    LEFT JOIN(SELECT\n    GROUP_CONCAT(CONCAT('- ',`s_sgc_sc_tipocosecuencia_acciones`.`Nbre`) SEPARATOR '\\n') NConsecuencia, `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nFROM\n     `s_sgc_sc_tipoevento_tipoca`\n    INNER JOIN  `s_sgc_sc_tipocosecuencia_acciones`\n        ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`)\nWHERE ( `s_sgc_sc_tipocosecuencia_acciones`.`Tipo` =0 AND s_sgc_sc_tipocosecuencia_acciones.`Estado`=1)\nGROUP BY `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nORDER BY `s_sgc_sc_tipoevento_tipoca`.`NOrden` ASC) c ON (s_sgc_sc_tipoevento.`Id`=c.Id_TipoEvento)\n-- ACCION INMEDIATA\nLEFT JOIN(SELECT\n    GROUP_CONCAT(CONCAT('- ',`s_sgc_sc_tipocosecuencia_acciones`.`Nbre`) SEPARATOR '\\n') NAccionInmediata, `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nFROM\n     `s_sgc_sc_tipoevento_tipoca`\n    INNER JOIN  `s_sgc_sc_tipocosecuencia_acciones`\n        ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`)\nWHERE ( `s_sgc_sc_tipocosecuencia_acciones`.`Tipo` =1 AND s_sgc_sc_tipocosecuencia_acciones.`Estado`=1)\nGROUP BY `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nORDER BY `s_sgc_sc_tipoevento_tipoca`.`NOrden` ASC) a ON (s_sgc_sc_tipoevento.`Id`=a.Id_TipoEvento)\n\n-- ACCION CORRECTIVA\nLEFT JOIN(SELECT\n    GROUP_CONCAT(CONCAT('- ',`s_sgc_sc_tipocosecuencia_acciones`.`Nbre`) SEPARATOR '\\n') NAccionCorrectiva, `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nFROM\n     `s_sgc_sc_tipoevento_tipoca`\n    INNER JOIN  `s_sgc_sc_tipocosecuencia_acciones`\n        ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`)\nWHERE ( `s_sgc_sc_tipocosecuencia_acciones`.`Tipo` =2 AND s_sgc_sc_tipocosecuencia_acciones.`Estado`=1)\nGROUP BY `s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento`\nORDER BY `s_sgc_sc_tipoevento_tipoca`.`NOrden` ASC) d ON (s_sgc_sc_tipoevento.`Id`=d.Id_TipoEvento)\n\n WHERE (s_sgc_tipoproceso.`Id`='" + xidTipoProceso + "' AND s_sgc_sc_triesgo_tevento.`Id`='" + xidTipoEvento + "')\nORDER BY `s_sgc_sc_tproceso_triesgo`.`Norden` ASC, `s_sgc_sc_triesgo_tevento`.`NOrden` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_ConsultarPanoramaEventoDTO Panorama = new SGC_ConsultarPanoramaEventoDTO();
                Panorama.setNProceso(rs.getString("NProceso"));
                Panorama.setNRiesgo(rs.getString("NRiesgo"));
                Panorama.setNEvento(rs.getString("NEvento"));
                Panorama.setNConsecuencias(rs.getString("NCOnsecuencias"));
                Panorama.setNAccionInmediata(rs.getString("NAccionInmediata"));
                Panorama.setNAccionCorrectiva(rs.getString("NAccionCorrectiva"));
                return Panorama;
            }
        };
        List<SGC_ConsultarPanoramaEventoDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeAtencionPrioritaria(String xFechai, String xFechaf, String xFiltro) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), Integer.valueOf(rs.getInt(12)), rs.getString(13), rs.getString(14)};
                return fila;
            }
        };
        String sql = "SELECT\n    TIMESTAMP(CONCAT( `ingreso`.`FechaIngreso`, ' ', `ingreso`.`HoraIngreso`)) AS `FIngreso`\n    , TIMESTAMP(CONCAT(`h_atencion`.`Fecha_Atencion`,' ', `h_atencion`.`Hora_Atencion`)) AS `FAtencion`\n    , CONVERT(TIME(TIMEDIFF(TIMESTAMP(CONCAT(`h_atencion`.`Fecha_Atencion`,' ', `h_atencion`.`Hora_Atencion`)),TIMESTAMP(CONCAT( `ingreso`.`FechaIngreso`, ' ', `ingreso`.`HoraIngreso`)))), CHAR(15)) AS `DifTiempo`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    ,  CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `h_atencion`.`Codigo_Dxp`\n    , `h_atencion`.`Codigo_DxR1`\n    , `h_atencion`.`Codigo_DxR2`\n    , `h_atencion`.`Codigo_DxR3`\n    , `h_triage`.`Clasificacion`\n    , `c_clasecita`.`Nbre`\n    , IF(`ingreso`.`CEspecial`=0,'NORMAL',IF(`ingreso`.`CEspecial`=1,'DISCAPACITADO',IF(`ingreso`.`CEspecial`=2,'EMBARAZADA',IF(`ingreso`.`CEspecial`=3,'TERCERA EDAD','NIÑO')))) AS CEspecial\nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `h_triage` \n        ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `ingreso`.`CEspecial` IN (" + xFiltro + ")\n    AND `ingreso`.`FechaIngreso` >='" + xFechai + "'\n    AND `ingreso`.`FechaIngreso` <='" + xFechaf + "'    AND TIME(TIMEDIFF(TIMESTAMP(CONCAT(`h_atencion`.`Fecha_Atencion`,' ', `h_atencion`.`Hora_Atencion`)),TIMESTAMP(CONCAT( `ingreso`.`FechaIngreso`, ' ', `ingreso`.`HoraIngreso`))))>='00:00:00')\nORDER BY `FIngreso` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeAtencionPrioritariTriage(String xFechai, String xFechaf, String xFiltro) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), Integer.valueOf(rs.getInt(2))};
                return fila;
            }
        };
        String sql = "SELECT\n    IF(`h_triage`.`Clasificacion`=1,'Triage 1', IF(`h_triage`.`Clasificacion`=2,'Triage 2',IF(`h_triage`.`Clasificacion`=3,'Triage 3',IF(`h_triage`.`Clasificacion`=4,'Triage 4','Triage 5')))) CTiage\n    , COUNT(`h_triage`.`Clasificacion`) AS `Cantidad`\nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `h_triage` \n        ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `ingreso`.`CEspecial` IN (" + xFiltro + ")\n    AND `ingreso`.`FechaIngreso` >='" + xFechai + "'\n    AND `ingreso`.`FechaIngreso` <='" + xFechaf + "')\nGROUP BY `h_triage`.`Clasificacion`\nORDER BY `h_triage`.`Clasificacion` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeAtencionPrioritariPromedio(String xFechai, String xFechaf, String xFiltro) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3)};
                return fila;
            }
        };
        String sql = "SELECT\n    CONVERT(SEC_TO_TIME(AVG(TIME_TO_SEC(TIME_TO_SEC(TIME(TIMEDIFF(TIMESTAMP(CONCAT(`h_atencion`.`Fecha_Atencion`,' ', `h_atencion`.`Hora_Atencion`)),TIMESTAMP(CONCAT( `ingreso`.`FechaIngreso`, ' ', `ingreso`.`HoraIngreso`)))))))), CHAR(15)) AS `Promedio`\n    , CONVERT(MAX(TIME(TIMEDIFF(TIMESTAMP(CONCAT(`h_atencion`.`Fecha_Atencion`,' ', `h_atencion`.`Hora_Atencion`)),TIMESTAMP(CONCAT( `ingreso`.`FechaIngreso`, ' ', `ingreso`.`HoraIngreso`))))), CHAR(15)) AS `Max`\n    , CONVERT(MIN(TIME(TIMEDIFF(TIMESTAMP(CONCAT(`h_atencion`.`Fecha_Atencion`,' ', `h_atencion`.`Hora_Atencion`)),TIMESTAMP(CONCAT( `ingreso`.`FechaIngreso`, ' ', `ingreso`.`HoraIngreso`))))), CHAR(15)) AS `Min`\n    \n\nFROM\n    `h_atencion`\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `h_triage` \n        ON (`h_triage`.`IdIngreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `ingreso`.`CEspecial` IN (" + xFiltro + ")\n    AND `ingreso`.`FechaIngreso` >='" + xFechai + "'\n    AND `ingreso`.`FechaIngreso` <='" + xFechaf + "'    AND TIME(TIMEDIFF(TIMESTAMP(CONCAT(`h_atencion`.`Fecha_Atencion`,' ', `h_atencion`.`Hora_Atencion`)),TIMESTAMP(CONCAT( `ingreso`.`FechaIngreso`, ' ', `ingreso`.`HoraIngreso`))))>='00:00:00');";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeDiagnosticoSaludSO(String xFechai, String xFechaf, String xidEmpresa) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32), rs.getString(33), rs.getString(34), rs.getString(35), rs.getString(36), rs.getString(37), rs.getString(38), rs.getString(39), rs.getString(40), rs.getString(41), rs.getString(42), rs.getString(43), rs.getString(44), rs.getString(45), rs.getString(46), rs.getString(47), rs.getString(48), rs.getString(49), rs.getString(50), rs.getString(51), rs.getString(52), rs.getString(53), rs.getString(54), rs.getString(55), rs.getString(56), rs.getString(57), rs.getString(58), rs.getString(59), rs.getString(60), rs.getString(61), rs.getString(62), rs.getString(63), rs.getString(64), rs.getString(65), rs.getString(66), rs.getString(67), rs.getString(68), rs.getString(69), rs.getString(70), rs.getString(71)};
                return fila;
            }
        };
        String sql = "WITH maestra AS \n(SELECT\n\th_atencion.Id,\n\th_atencion.Fecha_Atencion,\n\tc_clasecita.Nbre ClaseCita,\n\tg_persona.Id_TipoIdentificacion,\n\tg_persona.NoDocumento,\n\tCONCAT(g_persona.Nombre1 , ' ', g_persona.Nombre2 , ' ', g_persona.Apellido1 , ' ', g_persona.Apellido2) AS NUsuario,\n    Devuelve_Edad_2F(g_persona.FechaNac,\n\th_atencion.Fecha_Atencion) AS Edad,\n\tg_persona.Id_Sexo,\n\tg_nivelestudio.Nbre AS Escolaridad,\n\tg_estadocivil.Nbre AS EstadoCivil,\n\th_atencion.Recomendaciones,\n\tf_empresacontxconvenio.Nbre AS NEmpresa,\n\tingreso.Id AS idIngreso\nFROM\n\th_atencion\nINNER JOIN ingreso                         ON (h_atencion.Id_Ingreso = ingreso.Id)\nINNER JOIN c_clasecita                     ON (h_atencion.Id_ClaseCita = c_clasecita.Id)\nINNER JOIN f_empresacontxconvenio          ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nINNER JOIN g_persona                       ON (g_persona.Id = ingreso.Id_Usuario)\nINNER JOIN g_usuario                       ON (g_usuario.Id_persona = g_persona.Id)\nINNER JOIN g_estadocivil                   ON (g_persona.Id_EstadoCivil = g_estadocivil.Id)\nINNER JOIN g_nivelestudio                  ON (g_nivelestudio.Id = ingreso.Id_NivelEstudio)\n\nWHERE\n\t(h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'\n\t\tAND f_empresacontxconvenio.Id = '" + xidEmpresa + "')\nGROUP BY h_atencion.Id),\ndatosOcupacionales AS (\nSELECT h_atencion.Id idAtencionOcup, h_so_datos_ocupacionales.Eps AS NEps, \tg_cargos.Nbre AS Cargo\nFROM h_atencion \nINNER JOIN h_so_datos_ocupacionales ON (h_so_datos_ocupacionales.Id_Atencion = h_atencion.Id)\nINNER JOIN g_cargos                        ON (h_so_datos_ocupacionales.IdCargo = g_cargos.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\naccidentesTrabajo AS (\nSELECT h_atencion.Id idAtencionAccidente,\nIFNULL(GROUP_CONCAT(CONCAT(h_so_accidentes_trabajo.Empresa, ' A—O: ', h_so_accidentes_trabajo.Fecha_AT) SEPARATOR '\\n'), '') AS AccidenteTrabajo\nFROM h_atencion \nINNER JOIN h_so_accidentes_trabajo ON (h_so_accidentes_trabajo.Id_Atencion = h_atencion.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\nenfermedadProfesional AS (\nSELECT h_atencion.Id idAtencionEnfermedadP,\nIFNULL(GROUP_CONCAT(CONCAT(h_so_enfermedad_profesional.Empresa, ' A—O: ', h_so_enfermedad_profesional.FechaEP) SEPARATOR '\\n'), '') AS EnfermedadProfesional\n\nFROM h_atencion \nINNER JOIN h_so_enfermedad_profesional ON (h_so_enfermedad_profesional.Id_Atencion = h_atencion.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\nhabitos AS (\nSELECT h_atencion.Id idAtencionHabitos,\nIF(h_habitos.Habito_Deporte IS NULL, 'NO REGISTRA', IF(h_habitos.Habito_Deporte = 1, 'SI', 'NO')) AS PDeporte,\n\tIFNULL(h_habitos.Cual_Deporte, '') AS CDeporte,\n\tIF(h_habitos.Id_TipoCantCigarro IS NULL, 'NO REGISTRA', IF(h_habitos.Id_TipoCantCigarro = 1, 'NO', 'SI')) AS Fuma,\n\tIFNULL(h_habitos.ObserFuma, '') AS ObsFuma,\n\tIF(h_habitos.Habito_Alcohol IS NULL, 'NO REGISTRA', IF(h_habitos.Habito_Alcohol = 1, 'SI', 'NO')) AS CAlcohol,\n\tIFNULL (h_habitos.Cual_Alcohol, '') AS CualAlcohol,\n\tIFNULL (h_habitos.ObserALcohol, '') AS ObsAlcohol\nFROM h_atencion \nINNER JOIN h_habitos ON (h_habitos.Id_Atencion = h_atencion.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\nvisiometria AS (\nSELECT h_atencion.Id idAtencionVisio,\nh_so_visiometria.R_VLAmbosO_V,\n\th_so_visiometria.R_VLODerecho_V,\n\th_so_visiometria.R_VLOIzquierdo_V,\n\th_so_visiometria.R_VCAmbosO_V,\n\th_so_visiometria.R_VCODerecho_V,\n\th_so_visiometria.R_VCOIzquierdo_V,\n\tIFNULL(h_so_visiometria.Resultado, '') AS RVisiometia,\n\tIFNULL(h_so_visiometria.ObservacionVisio, '') AS RVObservacion\nFROM h_atencion \nINNER JOIN h_so_visiometria ON (h_so_visiometria.Id_Atencion = h_atencion.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\naudiometria AS (\nSELECT h_atencion.Id idAtencionAudio,\nIFNULL(h_so_audiometria.ResultadoM, '') AS RAudiometria,\n\tIFNULL(h_so_audiometria.ObservacionM, '') AS RAObservacion\nFROM h_atencion \nINNER JOIN h_so_audiometria ON (h_so_audiometria.Id_Atencion = h_atencion.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\nespirometria AS (\nSELECT h_atencion.Id idAtencionEspiro,\nh_so_espirometria_g.FVC,\n\th_so_espirometria_g.FV1,\n\th_so_espirometria_g.FEF2575,\n\th_so_espirometria_g.FEV1_FVC,\n\tIFNULL(h_so_espirometria_g.ResultadoM, '') AS REspirometria,\n\tIFNULL(h_so_espirometria_g.Observacion, '') AS REObservacion\nFROM h_atencion \nINNER JOIN h_so_espirometria_g ON (h_so_espirometria_g.Id_Atencion = h_atencion.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\nosteomuscular AS (\nSELECT h_atencion.Id idAtencionOsteo,\nIFNULL(h_so_examen_osteomuscular.Resultado, '') AS ROsteomuscular\nFROM h_atencion \nINNER JOIN h_so_examen_osteomuscular ON (h_so_examen_osteomuscular.Id_Atencion = h_atencion.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\nconcepto AS (\nSELECT h_atencion.Id idAtencionConcepto,\n\tso_tipo_concepto.Nbre AS Concepto,\n\th_so_concepto_laboral.Observacion\n\nFROM h_atencion \nINNER JOIN h_so_concepto_laboral ON (h_so_concepto_laboral.Id_Atencion = h_atencion.Id)\nINNER JOIN so_tipo_concepto                 ON (h_so_concepto_laboral.Id_TipoC = so_tipo_concepto.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\npatologia AS (\nSELECT h_atencion.Id idAtencionPatologia,\n\tg_patologia.Id AS DxP,\n\tg_patologia.Nbre AS NDxP,\n\tg_patologia_1.Id AS DxR1,\n\tg_patologia_1.Nbre AS NDxR1,\n\tg_patologia_2.Id AS DxR2,\n\tg_patologia_2.Nbre AS NDxR2,\n\tg_patologia_3.Id AS DxR3,\n\tg_patologia_3.Nbre AS NDxR3\n\nFROM h_atencion \nINNER JOIN g_patologia                     ON (g_patologia.Id = h_atencion.Codigo_Dxp) \nLEFT JOIN g_patologia AS g_patologia_1     ON (g_patologia_1.Id = h_atencion.Codigo_DxR1) \nLEFT JOIN g_patologia AS g_patologia_2     ON (g_patologia_2.Id = h_atencion.Codigo_DxR2) \nLEFT JOIN g_patologia AS g_patologia_3     ON (g_patologia_3.Id = h_atencion.Codigo_DxR3) \nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\nexamenFisico AS (\nSELECT h_atencion.Id idAtencionFisico,\nIFNULL (h_examenfisico.TArtSentadoD, '') TArtSentadoD,\n\tIFNULL (h_examenfisico.TArtSentadoS, '') TArtSentadoS,\n\tIFNULL (h_examenfisico.Peso, '') Peso,\n\tIFNULL (h_examenfisico.Talla, '') Talla,\n\tIFNULL (h_examenfisico.IMC, '') IMC,\n\th_examenfisico.IMC AS IMC2\nFROM h_atencion \nINNER JOIN h_examenfisico                     ON (h_examenfisico.Id_Atencion = h_atencion.Id)\nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\nantecedentes AS (\nSELECT \nh_atencion.Id idAtencionAntecedentes,\nIFNULL (h_tmp_antecedentes_familiares.AntFamiliares, '') AS AntFamiliares,\n\tIFNULL (h_tmp_antecedentes_personales.AntPersonales, '') AS AntPersonales,\n\tIFNULL (h_tmp_antecedentes_ppatologicos.Ant_Qx, '') AS Ant_Qx\nFROM  h_atencion \nINNER JOIN ingreso                         ON (h_atencion.Id_Ingreso = ingreso.Id)\nINNER JOIN g_usuario ON ingreso.Id_Usuario=g_usuario.id\nLEFT JOIN h_tmp_antecedentes_familiares    ON (h_tmp_antecedentes_familiares.Id_Usuario = g_usuario.Id_persona) \nLEFT JOIN h_tmp_antecedentes_personales    ON (h_tmp_antecedentes_personales.Id_Usuario = g_usuario.Id_persona) \nLEFT JOIN h_tmp_antecedentes_ppatologicos  ON (h_tmp_antecedentes_ppatologicos.Id_Usuario = g_usuario.Id_persona) \nWHERE h_atencion.Fecha_Atencion >= '" + xFechai + "'\n\t\tAND h_atencion.Fecha_Atencion <= '" + xFechaf + "'),\n\tprocedimientosRadiologias AS (\n\tSELECT\n\ti.Id AS idIngereso,\n\tfi.Id_Procedimiento AS codigoProcedimiento,\n\tgp.Nbre AS nombreProcedimiento,\n\tfi.Observacion AS observacionRadiologias,\n\tfi.ResultadoTexto AS resultadoRadiologias\nFROM\n\tf_itemordenesproced fi\nINNER JOIN g_procedimiento gp ON\n\t(fi.Id_Procedimiento = gp.Id)\nINNER JOIN f_ordenes fo ON\n\t(fi.Id_Ordenes = fo.Id)\nINNER JOIN ingreso i ON\n\t(fo.Id_Ingreso = i.Id)\nINNER JOIN h_atencion ha ON\n\t(ha.Id_Ingreso = i.Id)\nWHERE\n\tha.Fecha_Atencion >= '" + xFechai + "'\n\tAND ha.Fecha_Atencion <= '" + xFechaf + "'\n\tAND fi.Id_Procedimiento IN (16, 871030, 871040, 871121, 873313, 873422)),\n\tprocedimientosPsicologias AS (\n\tSELECT\n\ti.Id AS idIngereso,\n\tfi.Id_Procedimiento AS codigoProcedimiento,\n\tgp.Nbre AS nombreProcedimiento,\n\tfi.Observacion AS observacionPsicologias,\n\tfi.ResultadoTexto AS resultadoPsicologias\nFROM\n\tf_itemordenesproced fi\nINNER JOIN g_procedimiento gp ON\n\t(fi.Id_Procedimiento = gp.Id)\nINNER JOIN f_ordenes fo ON\n\t(fi.Id_Ordenes = fo.Id)\nINNER JOIN ingreso i ON\n\t(fo.Id_Ingreso = i.Id)\nINNER JOIN h_atencion ha ON\n\t(ha.Id_Ingreso = i.Id)\nWHERE\n\tha.Fecha_Atencion >= '" + xFechai + "'\n\tAND ha.Fecha_Atencion <= '" + xFechaf + "'\n\tAND fi.Id_Procedimiento IN (940700, 1965128, 19651281, 19651282, 19651283)),\n\tprocedimientosOptometrias AS (SELECT\n\ti.Id AS idIngereso,\n\tfi.Id_Procedimiento AS codigoProcedimiento,\n\tgp.Nbre AS nombreProcedimiento,\n\tfi.Observacion AS observacionOptometrias,\n\tfi.ResultadoTexto AS resultadoOptometrias\nFROM\n\tf_itemordenesproced fi\nINNER JOIN g_procedimiento gp ON\n\t(fi.Id_Procedimiento = gp.Id)\nINNER JOIN f_ordenes fo ON\n\t(fi.Id_Ordenes = fo.Id)\nINNER JOIN ingreso i ON\n\t(fo.Id_Ingreso = i.Id)\nINNER JOIN h_atencion ha ON\n\t(ha.Id_Ingreso = i.Id)\nWHERE\n\tha.Fecha_Atencion >= '" + xFechai + "'\n\tAND ha.Fecha_Atencion <= '" + xFechaf + "'\n\tAND fi.Id_Procedimiento IN (66, 890207, 890307, 1965129)),\n\tprocedimientosLaboratorio AS (SELECT\n\ti.Id AS idIngereso,\n\tfi.Id_Procedimiento AS codigoProcedimiento,\n\tgp.Nbre AS nombreProcedimiento,\n\tfi.Observacion AS observacionLaboratorios,\n\tfi.ResultadoTexto AS resultadoLaboratorios\nFROM\n\tf_itemordenesproced fi\nINNER JOIN g_procedimiento gp ON\n\t(fi.Id_Procedimiento = gp.Id)\nINNER JOIN f_ordenes fo ON\n\t(fi.Id_Ordenes = fo.Id)\nINNER JOIN ingreso i ON\n\t(fo.Id_Ingreso = i.Id)\nINNER JOIN h_atencion ha ON\n\t(ha.Id_Ingreso = i.Id)\nWHERE\n\tha.Fecha_Atencion >= '" + xFechai + "'\n\tAND ha.Fecha_Atencion <= '" + xFechaf + "'\n\tAND fi.Id_Procedimiento = '895100')\n\tSELECT \n\tm.Id,\n\tm.Fecha_Atencion,\n\tm.ClaseCita,\n\tm.Id_TipoIdentificacion,\n\tm.NoDocumento,\n\tm.NUsuario,\n\tm.Edad,\n\tm.Id_Sexo,\n\tm.Escolaridad,\n\tdatosOcupacionales.Cargo,\n\tm.EstadoCivil,\n\tdatosOcupacionales.NEps,\n\tIFNULL(accidentesTrabajo.AccidenteTrabajo, '') AccidenteTrabajo,\n\tIFNULL(enfermedadProfesional.EnfermedadProfesional, '') EnfermedadProfesional,\n\thabitos.PDeporte,\n\tIFNULL(habitos.CDeporte, '') CDeporte,\n\thabitos.Fuma,\n\tIFNULL(habitos.ObsFuma, '') ObsFuma,\n\thabitos.CAlcohol,\n\tIFNULL(habitos.CualAlcohol, '') CualAlcohol,\n\tIFNULL(habitos.ObsAlcohol, '') ObsAlcohol,\n\tIFNULL(antecedentes.AntFamiliares, '') AntFamiliares,\n\tIFNULL(antecedentes.AntPersonales, '') AntPersonales,\n\tIFNULL(antecedentes.Ant_Qx, '') Ant_Qx,\n\tIFNULL(examenFisico.TArtSentadoD, '') TArtSentadoD,\n\tIFNULL(examenFisico.TArtSentadoS, '') TArtSentadoS,\n\tIFNULL(examenFisico.Peso, '') Peso,\n\tIFNULL(examenFisico.Talla, '') Talla,\n\tIFNULL(examenFisico.IMC, '') IMC,\n\tvisiometria.R_VLAmbosO_V,\n\tvisiometria.R_VLODerecho_V,\n\tvisiometria.R_VLOIzquierdo_V,\n\tvisiometria.R_VCAmbosO_V,\n\tvisiometria.R_VCODerecho_V,\n\tvisiometria.R_VCOIzquierdo_V,\n\tIFNULL(visiometria.RVisiometia, '') RVisiometia,\n\tIFNULL(visiometria.RVObservacion, '') RVObservacion,\n\tespirometria.FVC,\n\tespirometria.FV1,\n\tespirometria.FEF2575,\n\tespirometria.FEV1_FVC,\n\tIFNULL(audiometria.RAudiometria, '') RAudiometria,\n\tIFNULL(audiometria.RAObservacion, '') RAObservacion,\n\tIFNULL(espirometria.REspirometria, '') REspirometria,\n\tIFNULL(espirometria.REObservacion, '') REObservacion,\n\tIFNULL(osteomuscular.ROsteomuscular, '') ROsteomuscular,\n\tconcepto.Concepto,\n\tpatologia.DxP,\n\tpatologia.NDxP,\n\tpatologia.DxR1,\n\tpatologia.NDxR1,\n\tpatologia.DxR2,\n\tpatologia.NDxR2,\n\tpatologia.DxR3,\n\tpatologia.NDxR3,\n\texamenFisico.IMC2,\n\tm.Recomendaciones,\n\tconcepto.Observacion,\n\tm.NEmpresa,\n\tIFNULL(procedimientosRadiologias.codigoProcedimiento, '') AS codigoRadiologias,\n\tIFNULL(procedimientosRadiologias.nombreProcedimiento, '') AS nombreRadiologias,\n\tIFNULL(procedimientosRadiologias.resultadoRadiologias, '') AS resultadoRadiologia,\n\tIFNULL(procedimientosPsicologias.codigoProcedimiento, '') AS CodigoPsicologia,\n\tIFNULL(procedimientosPsicologias.nombreProcedimiento, '') AS nombrePsicologias,\n\tIFNULL(procedimientosPsicologias.resultadoPsicologias, '') AS resultadoPsicologia,\n\tIFNULL(procedimientosOptometrias.codigoProcedimiento, '') AS codigoOptometrias,\n\tIFNULL(procedimientosOptometrias.nombreProcedimiento, '') AS nombreOptometrias,\n\tIFNULL(procedimientosOptometrias.resultadoOptometrias, '') AS resultadoOptometrias,\n     IFNULL(procedimientosLaboratorio.codigoProcedimiento, '') AS codigoElectroCardiograma,\n     IFNULL(procedimientosLaboratorio.nombreProcedimiento, '') AS nombreElectrocardiograma,\n     IFNULL(procedimientosLaboratorio.resultadoLaboratorios, '') AS resultadoElectrocardiograma\n\tFROM \n\tmaestra m \n\tleft join datosOcupacionales          on m.id= datosOcupacionales.idAtencionOcup\n\tleft join accidentesTrabajo           on m.id= accidentesTrabajo.idAtencionAccidente\n\tleft join enfermedadProfesional       on m.id=enfermedadProfesional.idAtencionEnfermedadP\n\tleft join habitos                     ON m.id=habitos.idAtencionHabitos\n\tleft join visiometria                 ON m.id=visiometria.idAtencionVisio\n\tleft join audiometria                 ON m.id=audiometria.idAtencionAudio\n\tleft join espirometria                ON m.id=espirometria.idAtencionEspiro\n\tleft join osteomuscular               ON m.id=osteomuscular.idAtencionOsteo\n\tleft join examenFisico                on m.id=examenFisico.idAtencionFisico\n\tleft join concepto                    ON m.id=concepto.idAtencionConcepto\n\tleft join patologia                   ON m.id=patologia.idAtencionPatologia\n\tleft join antecedentes                ON m.id=antecedentes.idAtencionAntecedentes\n\tleft join procedimientosRadiologias   on m.idIngreso=procedimientosRadiologias.idIngereso\n\tleft join procedimientosPsicologias   ON m.idIngreso=procedimientosPsicologias.idIngereso\n\tleft join procedimientosOptometrias   ON m.idIngreso=procedimientosOptometrias.idIngereso\n     left JOIN procedimientosLaboratorio   ON m.idIngreso=procedimientosLaboratorio.idIngereso\n        where m.Fecha_Atencion >= '" + xFechai + "'\n\tAND m.Fecha_Atencion <= '" + xFechaf + "'\n\torder by m.Fecha_Atencion ASC";
        System.out.println("CONSULTA: " + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<GenericoComboDTO> cargarCombo(String sql) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.8
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoComboDTO g = new GenericoComboDTO();
                g.setId(rs.getLong(1));
                g.setNombre(rs.getString(2));
                return g;
            }
        };
        System.out.println("sql combo--> " + sql);
        List<GenericoComboDTO> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public void mCrearTmpAntecedentesFamiliares() {
        this.jdbcTemplate.update("TRUNCATE TABLE h_tmp_antecedentes_familiares");
        this.jdbcTemplate.update("INSERT INTO h_tmp_antecedentes_familiares SELECT\n    `h_antecedentefamiliar`.`Id_Usuario`\n    ,GROUP_CONCAT(CONCAT('PARENTESCO: ',`h_tipoparantec`.`Nbre`, ' VIVE: ', IF(`h_antecedentefamiliar`.`Vive`,'SI', 'NO')\n    , ' PATOLOGIA:' , `h_antecedentefamiliar`.`CIE10`,'-', `g_patologia`.`Nbre`\n    ) SEPARATOR '\\n') AntFamiliares\nFROM\n    `baseserver`.`h_antecedentefamiliar`\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`h_antecedentefamiliar`.`CIE10` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`h_tipoparantec` \n        ON (`h_antecedentefamiliar`.`Id_TipoParAntec` = `h_tipoparantec`.`Id`)\nGROUP BY `h_antecedentefamiliar`.`Id_Usuario`");
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public void mCrearTmpAntecedentesPersonales() {
        this.jdbcTemplate.update("TRUNCATE TABLE `h_tmp_antecedentes_personales`");
        this.jdbcTemplate.update("INSERT INTO h_tmp_antecedentes_personales SELECT\n    `h_patologiaasociadas`.`Id_Usuario`\n    , GROUP_CONCAT(CONCAT(`g_patologia`.`Id` ,' ', `g_patologia`.`Nbre`) SEPARATOR '\\n') AntPersonales\nFROM\n    `baseserver`.`h_patologiaasociadas`\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`h_patologiaasociadas`.`Id_Patologia` = `g_patologia`.`Id`)\nWHERE (`h_patologiaasociadas`.`Estado` =1)\nGROUP BY `h_patologiaasociadas`.`Id_Usuario`");
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public void mCrearTmpAntecedentesPPatologicos() {
        this.jdbcTemplate.update("TRUNCATE TABLE `h_tmp_antecedentes_ppatologicos`");
        this.jdbcTemplate.update("INSERT INTO h_tmp_antecedentes_ppatologicos SELECT\n    `h_antecedentepatologico`.`Id_Usuario`\n    , GROUP_CONCAT(`h_antecedentepatologico`.`Observacion` SEPARATOR '\\n') Ant_Qx\nFROM\n    `h_antecedentepatologico`\n    INNER JOIN `h_tipoantecpatologico` \n        ON (`h_antecedentepatologico`.`Id_tipoantecpatologico` = `h_tipoantecpatologico`.`Id`)\nWHERE (`h_antecedentepatologico`.`Id_tipoantecpatologico` =4\n    AND `h_antecedentepatologico`.`Estado` =1)\nGROUP BY `h_antecedentepatologico`.`Id_Usuario`");
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeNOMA(String xFechai, String xFechaf, String xidEmpresa, int xtipo) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.9
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21)};
                return fila;
            }
        };
        if (xtipo == 0) {
            sql = "SELECT  `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento` , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario`  ,\n `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo` , `ingreso`.`SO_Cargo` , `ingreso`.`SO_UNegocio`  , `ingreso`.`SO_SEG`\n    ,  h_so_examen_osteomuscular.`FechaE` AS FechaEvaluacion ,  h_so_examen_osteomuscular.`Id` AS CodEvaluacion , `c_clasecita`.`Nbre` AS `ClaseCita`\n    , IF(`so_tipo_concepto`.`Nbre` IS NULL,'',`so_tipo_concepto`.`Nbre`) AS `Concepto`  , IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',GROUP_CONCAT(`so_tipo_restriccion`.`Nbre` SEPARATOR '\\n')) AS `Restriccion` \n    , IF(`h_so_examen_osteomuscular`.`Resultado` IS NULL,'',`h_so_examen_osteomuscular`.`Resultado`) AS Hallazgo\n    , IF(`h_so_examen_osteomuscular`.`Interpretacion` IS NULL,'',`h_so_examen_osteomuscular`.`Interpretacion` ) AS Observacion\n    , ROUND(`h_so_examen_osteomuscular`.`IMC`,2) AS IMC, `f_empresacontxconvenio`.`Nbre` AS EmpresaF\n    , h_so_examen_osteomuscular.`HallazgoOMA`\n    , h_so_examen_osteomuscular.`Hallazgo` AS Hallazgos    \n    , IFNULL(d.`Recomendaciones`,'') AS Recomendaciones\nFROM `h_so_examen_osteomuscular` \n INNER JOIN  `g_persona`  ON (`h_so_examen_osteomuscular`.`Id_Usuario` = `g_persona`.`Id`)\n     INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_atencion`   ON (`h_so_examen_osteomuscular`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `c_clasecita`   ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    LEFT JOIN(SELECT h_so_exa_osteo_recomendacion.`Id_Atencion`,GROUP_CONCAT(CONCAT('_',`so_recomendaciones`.`Nbre`,': ',`h_so_exa_osteo_recomendacion`.`Observacion`) ORDER BY `so_recomendaciones`.`Nbre` SEPARATOR '\\n' ) AS Recomendaciones\nFROM `h_so_exa_osteo_recomendacion` INNER JOIN `so_recomendaciones`  ON (`h_so_exa_osteo_recomendacion`.`Id_Recomendacion` = `so_recomendaciones`.`Id`)\nGROUP BY `h_so_exa_osteo_recomendacion`.`Id_Atencion`\n    ) d ON  (d.`Id_Atencion` =IFNULL(`h_so_examen_osteomuscular`.`Id_Atencion`,0))\n    LEFT JOIN  `h_so_concepto_laboral`   ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `so_tipo_concepto`   ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`)\n    LEFT JOIN  `h_so_concepto_laboral_restricciones`   ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`)\n    LEFT JOIN  `so_tipo_restriccion`    ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`)\n WHERE (`h_so_examen_osteomuscular`.`Estado` =1 AND h_so_examen_osteomuscular.`FechaE`>='" + xFechai + "' AND h_so_examen_osteomuscular.`FechaE`<='" + xFechaf + "')\nGROUP BY h_so_examen_osteomuscular.`Id`\nORDER BY CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) ASC;";
        } else {
            sql = "SELECT  `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento` , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario`  ,\n `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo` , `ingreso`.`SO_Cargo` , `ingreso`.`SO_UNegocio`  , `ingreso`.`SO_SEG`\n    ,  h_so_examen_osteomuscular.`FechaE` AS FechaEvaluacion ,  h_so_examen_osteomuscular.`Id` AS CodEvaluacion , `c_clasecita`.`Nbre` AS `ClaseCita`\n    , IF(`so_tipo_concepto`.`Nbre` IS NULL,'',`so_tipo_concepto`.`Nbre`) AS `Concepto`  , IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',GROUP_CONCAT(`so_tipo_restriccion`.`Nbre` SEPARATOR '\\n')) AS `Restriccion` \n    , IF(`h_so_examen_osteomuscular`.`Resultado` IS NULL,'',`h_so_examen_osteomuscular`.`Resultado`) AS Hallazgo\n    , IF(`h_so_examen_osteomuscular`.`Interpretacion` IS NULL,'',`h_so_examen_osteomuscular`.`Interpretacion` ) AS Observacion\n    , ROUND(`h_so_examen_osteomuscular`.`IMC`,2) AS IMC, `f_empresacontxconvenio`.`Nbre` AS EmpresaF\n    , h_so_examen_osteomuscular.`HallazgoOMA`\n    , h_so_examen_osteomuscular.`Hallazgo` AS Hallazgos    \n    , IFNULL(d.`Recomendaciones`,'') AS Recomendaciones\nFROM `h_so_examen_osteomuscular` \n INNER JOIN  `g_persona`  ON (`h_so_examen_osteomuscular`.`Id_Usuario` = `g_persona`.`Id`)\n     INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_atencion`   ON (`h_so_examen_osteomuscular`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `c_clasecita`   ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    LEFT JOIN(SELECT h_so_exa_osteo_recomendacion.`Id_Atencion`,GROUP_CONCAT(CONCAT('_',`so_recomendaciones`.`Nbre`,': ',`h_so_exa_osteo_recomendacion`.`Observacion`) ORDER BY `so_recomendaciones`.`Nbre` SEPARATOR '\\n' ) AS Recomendaciones\nFROM `h_so_exa_osteo_recomendacion` INNER JOIN `so_recomendaciones`  ON (`h_so_exa_osteo_recomendacion`.`Id_Recomendacion` = `so_recomendaciones`.`Id`)\nGROUP BY `h_so_exa_osteo_recomendacion`.`Id_Atencion`\n    ) d ON  (d.`Id_Atencion` =IFNULL(`h_so_examen_osteomuscular`.`Id_Atencion`,0))\n    LEFT JOIN  `h_so_concepto_laboral`   ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN  `so_tipo_concepto`   ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`)\n    LEFT JOIN  `h_so_concepto_laboral_restricciones`   ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`)\n    LEFT JOIN  `so_tipo_restriccion`    ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`)\n WHERE (`h_so_examen_osteomuscular`.`Estado` =1 AND h_so_examen_osteomuscular.`FechaE`>='" + xFechai + "' AND h_so_examen_osteomuscular.`FechaE`<='" + xFechaf + "' AND f_empresacontxconvenio.`Id`='" + xidEmpresa + "')\nGROUP BY h_so_examen_osteomuscular.`Id`\nORDER BY CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) ASC;";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeAudiometria(String xFechai, String xFechaf, String xidEmpresa, int xtipo) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.10
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila;
                if (InformesSgcDAOImpl.this.xmt.esIPSMineros()) {
                    fila = new Object[30];
                } else {
                    fila = new Object[28];
                }
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                fila[8] = rs.getString(9);
                fila[9] = rs.getString(10);
                fila[10] = rs.getString(11);
                fila[11] = rs.getString(12);
                fila[12] = rs.getString(13);
                fila[13] = rs.getString(14);
                fila[14] = rs.getString(15);
                fila[15] = rs.getString(16);
                fila[16] = rs.getString(17);
                fila[17] = rs.getString(18);
                fila[18] = rs.getString(19);
                fila[19] = rs.getString(20);
                fila[20] = rs.getString(21);
                fila[21] = rs.getString(22);
                fila[22] = rs.getString(23);
                fila[23] = rs.getString(24);
                fila[24] = rs.getString(25);
                fila[25] = rs.getString(26);
                fila[26] = rs.getString(27);
                fila[27] = rs.getString(28);
                if (InformesSgcDAOImpl.this.xmt.esIPSMineros()) {
                    fila[28] = rs.getString(29);
                    fila[29] = rs.getString(30);
                }
                return fila;
            }
        };
        String validacionMineros = "";
        String relacionMineros = "";
        if (this.xmt.esIPSMineros()) {
            validacionMineros = " ,`g_cargos`.`Nbre` AS Cargo  \n ,IFNULL(so_manporwer_detalle.`Gerencia`,'') Gerencia";
            relacionMineros = " INNER JOIN  `g_cargos` ON (g_cargos.`Id`=`g_usuario`.`Id_Cargo`)\nINNER JOIN so_manporwer_detalle ON (`g_persona`.`Id`=so_manporwer_detalle.`Id_Persona`) ";
        }
        if (xtipo == 0) {
            sql = "SELECT DISTINCT `h_so_audiometria`.`Fecha_R`,\n    `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario`\n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n        , IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN\n    , `h_so_audiometria`.`D500`\n    , `h_so_audiometria`.`D1000`\n    , `h_so_audiometria`.`D2000`\n    , `h_so_audiometria`.`D3000`\n    , `h_so_audiometria`.`D4000`\n    , `h_so_audiometria`.`D6000`\n    , `h_so_audiometria`.`D8000`\n    , `h_so_audiometria`.`POD`\n    ,`h_so_audiometria`.`I500`\n    , `h_so_audiometria`.`I1000`\n    , `h_so_audiometria`.`I2000`\n    , `h_so_audiometria`.`I3000`\n    , `h_so_audiometria`.`I4000`\n    , `h_so_audiometria`.`I6000`\n    , `h_so_audiometria`.`I8000`\n    , `h_so_audiometria`.`POI`\n    , IF(`h_so_audiometria`.`ResultadoM` IS NULL, '',`h_so_audiometria`.`ResultadoM`) AS ResultadoM      , `c_clasecita`.`Nbre` AS ClaseCita, IF(`h_so_audiometria`.`ObservacionAudio` IS NULL, '',`h_so_audiometria`.`ObservacionAudio`) AS ObservacionAudio, `f_empresacontxconvenio`.`Nbre` AS EmpresaF  " + validacionMineros + " FROM     `h_so_audiometria`\n    INNER JOIN  `g_persona`  ON (`h_so_audiometria`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)\n INNER JOIN  `h_atencion`  ON (`h_so_audiometria`.`Id_Atencion` = `h_atencion`.`Id`)     INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  " + relacionMineros + "  WHERE (`h_so_audiometria`.`Fecha_R` >='" + xFechai + "' AND `h_so_audiometria`.`Fecha_R` <='" + xFechaf + "'\n AND `h_so_audiometria`.`Estado` =1) ORDER BY  CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) asc ";
        } else {
            sql = "SELECT DISTINCT `h_so_audiometria`.`Fecha_R`,\n    `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario`\n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n        , IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN\n    , `h_so_audiometria`.`D500`\n    , `h_so_audiometria`.`D1000`\n    , `h_so_audiometria`.`D2000`\n    , `h_so_audiometria`.`D3000`\n    , `h_so_audiometria`.`D4000`\n    , `h_so_audiometria`.`D6000`\n    , `h_so_audiometria`.`D8000`\n    , `h_so_audiometria`.`POD`\n    ,`h_so_audiometria`.`I500`\n    , `h_so_audiometria`.`I1000`\n    , `h_so_audiometria`.`I2000`\n    , `h_so_audiometria`.`I3000`\n    , `h_so_audiometria`.`I4000`\n    , `h_so_audiometria`.`I6000`\n    , `h_so_audiometria`.`I8000`\n    , `h_so_audiometria`.`POI`\n    , IF(`h_so_audiometria`.`ResultadoM` IS NULL, '',`h_so_audiometria`.`ResultadoM`) AS ResultadoM      , `c_clasecita`.`Nbre` AS ClaseCita, IF(`h_so_audiometria`.`ObservacionAudio` IS NULL, '',`h_so_audiometria`.`ObservacionAudio`) AS ObservacionAudio, `f_empresacontxconvenio`.`Nbre` AS EmpresaF  " + validacionMineros + " FROM     `h_so_audiometria`\n    INNER JOIN  `g_persona`  ON (`h_so_audiometria`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)\n INNER JOIN  `h_atencion`  ON (`h_so_audiometria`.`Id_Atencion` = `h_atencion`.`Id`)     INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  " + relacionMineros + "  WHERE (`h_so_audiometria`.`Fecha_R` >='" + xFechai + "' AND `h_so_audiometria`.`Fecha_R` <='" + xFechaf + "' AND f_empresacontxconvenio.`Id`='" + xidEmpresa + "'\n AND `h_so_audiometria`.`Estado` =1) ORDER BY  CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) asc ";
        }
        System.out.println("Informe audiometria -> " + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeEspirometria(String xFechai, String xFechaf, String xidEmpresa, int xtipo) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.11
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[28];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                fila[8] = Double.valueOf(rs.getDouble(9));
                fila[9] = Double.valueOf(rs.getDouble(10));
                fila[10] = Double.valueOf(rs.getDouble(11));
                fila[11] = Double.valueOf(rs.getDouble(12));
                fila[12] = Double.valueOf(rs.getDouble(13));
                fila[13] = Double.valueOf(rs.getDouble(14));
                fila[14] = Double.valueOf(rs.getDouble(15));
                fila[15] = rs.getString(16);
                fila[16] = rs.getString(17);
                fila[17] = rs.getString(18);
                fila[18] = rs.getString(19);
                return fila;
            }
        };
        if (xtipo == 0) {
            sql = "SELECT\nh_so_espirometria.`Fecha_R`,\n    `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario` \n    , IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN\n    , `h_so_espirometria`.`FVCM`\n    , `h_so_espirometria`.`FVCP`\n    , `h_so_espirometria`.`VEF1M`\n    , `h_so_espirometria`.`VEF1P`\n    , `h_so_espirometria`.`DVEF1`\n    , `h_so_espirometria`.`DFVC`\n    , `h_so_espirometria`.`IndicT`\n    , `h_so_espirometria`.`Resultado`\n    , IF(`h_so_espirometria`.`ResultadoM` IS NULL, '', `h_so_espirometria`.`ResultadoM`) AS ResultadoM \n  ,`c_clasecita`.`Nbre` AS ClaseCita, `f_empresacontxconvenio`.`Nbre` AS EmpresaF    \nFROM\n     `h_so_espirometria`\n    INNER JOIN  `h_atencion` \n        ON (`h_so_espirometria`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` \n        ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`) \n WHERE (`h_so_espirometria`.`Estado` =1\n    AND `h_so_espirometria`.`Fecha_R`>='" + xFechai + "' and `h_so_espirometria`.`Fecha_R`<='" + xFechaf + "') order by CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` );";
        } else {
            sql = "SELECT\nh_so_espirometria.`Fecha_R`,\n    `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario` \n    , IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN\n    , `h_so_espirometria`.`FVCM`\n    , `h_so_espirometria`.`FVCP`\n    , `h_so_espirometria`.`VEF1M`\n    , `h_so_espirometria`.`VEF1P`\n    , `h_so_espirometria`.`DVEF1`\n    , `h_so_espirometria`.`DFVC`\n    , `h_so_espirometria`.`IndicT`\n    , `h_so_espirometria`.`Resultado`\n    , IF(`h_so_espirometria`.`ResultadoM` IS NULL, '', `h_so_espirometria`.`ResultadoM`) AS ResultadoM \n  ,`c_clasecita`.`Nbre` AS ClaseCita, `f_empresacontxconvenio`.`Nbre` AS EmpresaF    \nFROM\n     `h_so_espirometria`\n    INNER JOIN  `h_atencion` \n        ON (`h_so_espirometria`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` \n        ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`) \n WHERE (`h_so_espirometria`.`Estado` =1\n    AND `h_so_espirometria`.`Fecha_R`>='" + xFechai + "' and `h_so_espirometria`.`Fecha_R`<='" + xFechaf + "' AND f_empresacontxconvenio.`Id`='" + xidEmpresa + "') order by CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` );";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeEspirometria1(String xFechai, String xFechaf, String xidEmpresa, int xtipo) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.12
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[28];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                fila[8] = Double.valueOf(rs.getDouble(9));
                fila[9] = Double.valueOf(rs.getDouble(10));
                fila[10] = Double.valueOf(rs.getDouble(11));
                fila[11] = Double.valueOf(rs.getDouble(12));
                fila[12] = Double.valueOf(rs.getDouble(13));
                fila[13] = Double.valueOf(rs.getDouble(14));
                fila[14] = Double.valueOf(rs.getDouble(15));
                fila[15] = rs.getString(16);
                fila[16] = rs.getString(17);
                fila[17] = rs.getString(18);
                fila[18] = rs.getString(19);
                return fila;
            }
        };
        if (xtipo == 0) {
            sql = " select  h_so_espirometria_g.`Fecha_R`,\n    `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario` \n    , IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN\n    , `h_so_espirometria_g`.`FEV1_FVC`\n    , `h_so_espirometria_g`.`FEF2575`\n    , `h_so_espirometria_g`.`FV1`\n    , `h_so_espirometria_g`.`FVC`\n    , `h_so_espirometria_g`.`PEF`\n    , 0\n    , 0\n    , `h_so_espirometria_g`.`Resultado`\n    , IF(`h_so_espirometria_g`.`ResultadoM` IS NULL, '', `h_so_espirometria_g`.`ResultadoM`) AS ResultadoM \n  ,`c_clasecita`.`Nbre` AS ClaseCita, `f_empresacontxconvenio`.`Nbre` AS EmpresaF    \nFROM\n     `h_so_espirometria_g`\n    INNER JOIN  `h_atencion` \n        ON (`h_so_espirometria_g`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` \n        ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)  \n WHERE (`h_so_espirometria_g`.`Estado` =1\n    AND `h_so_espirometria_g`.`Fecha_R`>='" + xFechai + "' and `h_so_espirometria_g`.`Fecha_R`<='" + xFechaf + "') order by CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` );";
        } else {
            sql = " select  h_so_espirometria_g.`Fecha_R`,\n    `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario` \n    , IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN\n    , `h_so_espirometria_g`.`FEV1_FVC`\n    , `h_so_espirometria_g`.`FEF2575`\n    , `h_so_espirometria_g`.`FV1`\n    , `h_so_espirometria_g`.`FVC`\n    , `h_so_espirometria_g`.`PEF`\n    , 0\n    , 0\n    , `h_so_espirometria_g`.`Resultado`\n    , IF(`h_so_espirometria_g`.`ResultadoM` IS NULL, '', `h_so_espirometria_g`.`ResultadoM`) AS ResultadoM \n  ,`c_clasecita`.`Nbre` AS ClaseCita, `f_empresacontxconvenio`.`Nbre` AS EmpresaF    \nFROM\n     `h_so_espirometria_g`\n    INNER JOIN  `h_atencion` \n        ON (`h_so_espirometria_g`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` \n        ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)  \n WHERE (`h_so_espirometria_g`.`Estado` =1\n    AND `h_so_espirometria_g`.`Fecha_R`>='" + xFechai + "' and `h_so_espirometria_g`.`Fecha_R`<='" + xFechaf + "' AND f_empresacontxconvenio.`Id`='" + xidEmpresa + "') order by CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` );";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeVisiometria(String xFechai, String xFechaf, String xidEmpresa, int xtipo) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.13
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23), rs.getString(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getString(28), rs.getString(29), rs.getString(30), rs.getString(31), rs.getString(32), rs.getString(33), rs.getString(34), rs.getString(35), rs.getString(36), rs.getString(37), rs.getString(38), rs.getString(39), rs.getString(40), rs.getString(41), rs.getString(42), rs.getString(43), rs.getString(44), rs.getString(45), rs.getString(46), rs.getString(47), rs.getString(48), rs.getString(49), rs.getString(50), rs.getString(51)};
                return fila;
            }
        };
        if (xtipo == 0) {
            sql = "SELECT  `h_so_visiometria`.`FechaR`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    ,  CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario` \n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`    \n    , `ingreso`.`SO_Cargo`\n    ,  IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN    \n    , IF(`LContacto`=0,'NO', 'SI') AS LContacto\n    , `TLenteC`\n    , `RLFormulado`\n    , `Tipo_Gafas`\n    , `UCorreccion`\n    , IF(`Tipo_Correcion`=1,'NINGUNA',IF(`Tipo_Correcion`=2,'CERCA',IF(`Tipo_Correcion`=3,'AMBAS','NINGUNA'))) AS TipoCorrecion\n    , `R_VLAmbosO`\n    , `R_VLAmbosO_V`\n    , `R_VLAmbosO_T`\n    , `R_VLODerecho`\n    , `R_VLODerecho_V`\n    , `R_VLODerecho_T`\n    , `R_VLOIzquierdo`\n    , `R_VLOIzquierdo_V`\n    , `R_VLOIzquierdo_T`\n    , `R_VLEstereopsi`\n    , `R_VLEstereopsi_T`\n    , `R_VLPercepcion`\n    , `R_VLColor`\n    , `R_VLColor_T`\n    , `R_VLFVertical`\n    , `R_VLFVertical_T`\n    , `R_VLFLateral`\n    , `R_VLFLateral_T`\n    , `R_VCAmbosO`\n    , `R_VCAmbosO_V`\n    , `R_VCAmbosO_T`\n    , `R_VCODerecho`\n    , `R_VCODerecho_V`\n    , `R_VCODerecho_T`\n    , `R_VCOIzquierdo`\n    , `R_VCOIzquierdo_V`\n    , `R_VCOIzquierdo_T`\n    , `R_VCFVertical`\n    , `R_VCFVertical_T`\n    , `R_VCFLateral`\n    , `R_VCFLateral_T`\n    , `Interpretacion`\n    , `ObservacionVisio`\n    ,  IF(`h_so_visiometria`.`Resultado` IS NULL, '', `h_so_visiometria`.`Resultado`) AS ResultadoM \n    , `c_clasecita`.`Nbre` AS ClaseCita\n    , `f_empresacontxconvenio`.`Nbre` AS EmpresaF    \nFROM\n     `h_so_visiometria`\n    INNER JOIN  `h_atencion` \n        ON (`h_so_visiometria`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` \n        ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)  \n WHERE (`h_so_visiometria`.`Estado` =1\n    AND `h_so_visiometria`.`FechaR`>='" + xFechai + "' AND `h_so_visiometria`.`FechaR`<='" + xFechaf + "') ORDER BY CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` );";
        } else {
            sql = "SELECT  `h_so_visiometria`.`FechaR`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    ,  CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario` \n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`    \n    , `ingreso`.`SO_Cargo`\n    ,  IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN    \n    , IF(`LContacto`=0,'NO', 'SI') AS LContacto\n    , `TLenteC`\n    , `RLFormulado`\n    , `Tipo_Gafas`\n    , `UCorreccion`\n    , IF(`Tipo_Correcion`=1,'NINGUNA',IF(`Tipo_Correcion`=2,'CERCA',IF(`Tipo_Correcion`=3,'AMBAS','NINGUNA'))) AS TipoCorrecion\n    , `R_VLAmbosO`\n    , `R_VLAmbosO_V`\n    , `R_VLAmbosO_T`\n    , `R_VLODerecho`\n    , `R_VLODerecho_V`\n    , `R_VLODerecho_T`\n    , `R_VLOIzquierdo`\n    , `R_VLOIzquierdo_V`\n    , `R_VLOIzquierdo_T`\n    , `R_VLEstereopsi`\n    , `R_VLEstereopsi_T`\n    , `R_VLPercepcion`\n    , `R_VLColor`\n    , `R_VLColor_T`\n    , `R_VLFVertical`\n    , `R_VLFVertical_T`\n    , `R_VLFLateral`\n    , `R_VLFLateral_T`\n    , `R_VCAmbosO`\n    , `R_VCAmbosO_V`\n    , `R_VCAmbosO_T`\n    , `R_VCODerecho`\n    , `R_VCODerecho_V`\n    , `R_VCODerecho_T`\n    , `R_VCOIzquierdo`\n    , `R_VCOIzquierdo_V`\n    , `R_VCOIzquierdo_T`\n    , `R_VCFVertical`\n    , `R_VCFVertical_T`\n    , `R_VCFLateral`\n    , `R_VCFLateral_T`\n    , `Interpretacion`\n    , `ObservacionVisio`\n    ,  IF(`h_so_visiometria`.`Resultado` IS NULL, '', `h_so_visiometria`.`Resultado`) AS ResultadoM \n    , `c_clasecita`.`Nbre` AS ClaseCita\n    , `f_empresacontxconvenio`.`Nbre` AS EmpresaF    \nFROM\n     `h_so_visiometria`\n    INNER JOIN  `h_atencion` \n        ON (`h_so_visiometria`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` \n        ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)  \n WHERE (`h_so_visiometria`.`Estado` =1\n    AND `h_so_visiometria`.`FechaR`>='" + xFechai + "' AND `h_so_visiometria`.`FechaR`<='" + xFechaf + "' AND f_empresacontxconvenio.`Id`='" + xidEmpresa + "') ORDER BY CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` );";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<Object[]> ListInformeAccidenteTransito(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.14
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Id_TipoIdentificacion"), rs.getString("NoDocumento"), rs.getString("Apellido1"), rs.getString("Apellido2"), rs.getString("Nombre1"), rs.getString("Nombre2"), rs.getString("Edad"), rs.getString("FechaIngreso"), rs.getString("Fechaeventoecat"), rs.getString("deptartamento"), rs.getString("Municipio"), rs.getString("Zona"), rs.getString("Descripcion"), rs.getString("tipoVehiculo"), rs.getString("marcaVehiculo"), rs.getString("tipoAtencion")};
                return fila;
            }
        };
        String sql = "SELECT\n  g_persona.Id_TipoIdentificacion,\n  g_persona.NoDocumento,\n  g_persona.Apellido1,\n  g_persona.Apellido2,\n  g_persona.Nombre1,\n  g_persona.Nombre2,\n  CONCAT(Devuelve_Edad_2F (g_persona.FechaNac,ingreso.FechaIngreso),' ',Devuelve_Tipo_Edad_2F (g_persona.FechaNac,ingreso.FechaIngreso)) AS Edad,\n  ingreso.FechaIngreso,\n  a_eventoecat.Fechaeventoecat,\n  g_departamento.Nbre AS deptartamento,\n  g_municipio.Nbre AS Municipio,\n  a_eventoecat.Zona,\n  a_eventoecat.Descripcion,\n  a_tipovehiculo.Nbre AS tipoVehiculo,\n  a_marcavehiculo.Nbre AS marcaVehiculo,\n  g_tipoatencion.Nbre AS tipoAtencion\nFROM\n  a_eventoecat_paciente\n  INNER JOIN a_eventoecat\n    ON (a_eventoecat_paciente.Id_Eventoecat = a_eventoecat.Id)\n  INNER JOIN ingreso\n    ON (ingreso.Id = a_eventoecat_paciente.Id_Ingreso)\n  INNER JOIN g_usuario\n    ON (ingreso.Id_Usuario = g_usuario.Id_persona)\n  INNER JOIN f_empresacontxconvenio\n    ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n  INNER JOIN g_persona\n    ON (g_usuario.Id_persona = g_persona.Id)\n  INNER JOIN g_departamento\n    ON (g_departamento.Id = a_eventoecat.Id_Departamento)\n  INNER JOIN g_municipio\n    ON (g_municipio.Id = a_eventoecat.Id_Munucipio)\n  INNER JOIN a_accidentetransito\n    ON (a_accidentetransito.Id_eventoecat = a_eventoecat.Id)\n  INNER JOIN a_tipovehiculo\n    ON (a_accidentetransito.Id_tipovehiculo = a_tipovehiculo.Id)\n  INNER JOIN a_marcavehiculo\n    ON (a_accidentetransito.Id_marcavehiculo = a_marcavehiculo.Id)\n  INNER JOIN g_tipoatencion\n    ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)\nWHERE (\n    ingreso.FechaIngreso >= '" + xFechai + "'\n    AND ingreso.FechaIngreso <= '" + xFechaf + "'\n    AND ingreso.Estado = 0\n  )\nGROUP BY ingreso.Id\nORDER BY ingreso.FechaIngreso ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<CantidadCitasOdontDTO> getCantidadCitasOdont(String fechaI, String fechaF, Integer idProfesional) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.15
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                CantidadCitasOdontDTO g = new CantidadCitasOdontDTO();
                g.setTipoCita(rs.getString(1));
                g.setClasificacionCita(rs.getString(2));
                g.setCantidad(Integer.valueOf(rs.getInt(3)));
                return g;
            }
        };
        List<CantidadCitasOdontDTO> list = this.jdbcTemplate.query("select \nif(clc.`EsControl`=1,'CONTROL','PRIMER VEZ') as  tipoCita\n,clc.`Nbre` as clasificacionCita\n,count(cc.`Id`) cantidad\nfrom c_citas as cc\ninner join c_clasecita clc on (cc.`Id_ClaseCita`=clc.`Id`)\nwhere cc.`Id_Especialidad`IN(461,1032,1023,1024,1035,250) and cc.`Asistida`=3 and cc.`Fecha_Cita`>=? \nand cc.`Fecha_Cita`<=?\nand `Id_MotivoDesistida`=1 and cc.Id_Profesional=?\ngroup by clc.`Id` \norder by if(clc.`EsControl`=1,'CONTROL','PRIMER VEZ') asc, clc.`Nbre` asc", mapper, new Object[]{fechaI, fechaF, idProfesional});
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<CantidadProcedimientosOdontDTO> getCantidadProcedimientosOdont(String fechaI, String fechaF, Integer idProfesional) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.16
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                CantidadProcedimientosOdontDTO g = new CantidadProcedimientosOdontDTO();
                g.setGrupo(rs.getString(1));
                g.setProcedimiento(rs.getString(2));
                g.setTotalProcedimiento(Integer.valueOf(rs.getInt(3)));
                g.setUsuario(rs.getString(4));
                return g;
            }
        };
        List<CantidadProcedimientosOdontDTO> list = this.jdbcTemplate.query("select gpc.`Nbre` as grupo, pr.`Nbre` as procedimiento, sum(ohtp.`Cantidad`) as totalProcedimiento,\nus.Login as usuario\nfrom o_hc_tratamiento_procedimiento ohtp\ninner join g_procedimiento pr on (ohtp.`IdProcedimiento`=pr.`Id`)\ninner join o_proced_x_grupo pg on (pr.`Id`=pg.`IdProcedimiento`)\ninner join o_grupo_pro_cup gpc on (pg.`IdGrupo`=gpc.`Id`)\ninner join g_usuario_sist us on (ohtp.UsuarioS=us.Login) \nwhere ohtp.`FechaR`>=? and ohtp.`FechaR`<=?\nand ohtp.`Estado`=1 and us.Id_Persona=?\ngroup by pg.`IdProcedimiento`", mapper, new Object[]{fechaI, fechaF, idProfesional});
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<InasistenciaOdontDTO> getInasistenciaOdont(String fechaI, String fechaF, Integer idProfesional) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.17
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                InasistenciaOdontDTO g = new InasistenciaOdontDTO();
                g.setClasificacionCita(rs.getString(1));
                g.setTipoCita(rs.getString(2));
                g.setMotivoAnulacion(rs.getString(3));
                g.setCantidad(Integer.valueOf(rs.getInt(4)));
                return g;
            }
        };
        List<InasistenciaOdontDTO> list = this.jdbcTemplate.query("select \nif(clc.`EsControl`=1,'CONTROL','PRIMER VEZ') as  clasificacionCita\n,clc.`Nbre` as tipoCita\n,ma.`Nbre` as motivoAnulacion\n,count(cc.`Id`) cantidad\nfrom c_citas as cc\ninner join c_clasecita clc on (cc.`Id_ClaseCita`=clc.`Id`)\ninner join g_motivoanulacion ma on (cc.`Id_MotivoDesistida`=ma.`Id`)\nwhere cc.`Id_Especialidad`IN(461,1032,1023,1024,1035,250) and cc.`Asistida`=0 and cc.`Fecha_Cita`>=? \nand cc.`Fecha_Cita`<=? and cc.Id_Profesional=?\nand `Id_MotivoDesistida`<>1\ngroup by cc.`Id_MotivoDesistida` \nunion all \nselect \nif(clc.`EsControl`=1,'CONTROL','PRIMER VEZ') as  tipoCitaC\n,clc.`Nbre` as tipoCita\n,ma.`Nbre` as motivoAnulacion\n,count(cc.`Id`) cantidad\nfrom c_citas as cc\ninner join c_clasecita clc on (cc.`Id_ClaseCita`=clc.`Id`)\ninner join g_motivoanulacion ma on (cc.`Id_MotivoDesistida`=ma.`Id`)\nwhere cc.`Id_Especialidad`IN(461,1032,1023,1024,1035,250) and cc.`Asistida`=0 and cc.`Fecha_Cita`>=? \nand cc.`Fecha_Cita`<=now() \nand `Id_MotivoDesistida`=1 and cc.Id_Profesional=?\ngroup by cc.`Id_MotivoDesistida`", mapper, new Object[]{fechaI, fechaF, idProfesional, fechaI, idProfesional});
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<ProcedimientosPacienteOdontDTO> getProcedimientosPacienteOdont(String fechaI, String fechaF, Integer idProfesional) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.18
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ProcedimientosPacienteOdontDTO g = new ProcedimientosPacienteOdontDTO();
                g.setCodCita(rs.getString(1));
                g.setFecha_Cita(rs.getString(2));
                g.setTipoIdentificacion(rs.getString(3));
                g.setNoDocumento(rs.getString(4));
                g.setPaciente(rs.getString(5));
                g.setSexo(rs.getString(6));
                g.setFechaNac(rs.getString(7));
                g.setEdad(rs.getString(8));
                g.setClasificacionCita(rs.getString(9));
                g.setTipoCita(rs.getString(10));
                g.setEps(rs.getString(11));
                g.setCodigoTratamiento(rs.getString(12));
                g.setFechaInicioTratamiento(rs.getString(13));
                g.setFechaFinTratamiento(rs.getString(14));
                g.setEstadoTratamiento(rs.getString(15));
                g.setCodIngreso(rs.getString(16));
                g.setProfesional(rs.getString(17));
                g.setCodigo_Dxp(rs.getString(18));
                g.setGrupoProcedimiento(rs.getString(19));
                g.setProcedimiento(rs.getString(20));
                g.setCantidad(Integer.valueOf(rs.getInt(21)));
                return g;
            }
        };
        List<ProcedimientosPacienteOdontDTO> list = this.jdbcTemplate.query("select cc.id codCita, cc.`Fecha_Cita` \n,p.`Id_TipoIdentificacion` tipoIdentificacion\n, p.`NoDocumento`\n, concat(p.`Apellido1`,' ', p.`Apellido2`,' ',p.`Nombre1`,' ',p.`Nombre2`) as paciente\n,p.`Id_Sexo` sexo\n,p.`FechaNac`\n,`Devuelve_Edad_2F`(p.`FechaNac`,cc.`Fecha_Cita`) edad\n,clc.`Nbre` as clasificacionCita\n,if(clc.`EsControl`=1,'CONTROL','PRIMER VEZ') as  tipoCita\n,em.`Nbre` as EPS\n,cc.`Id_TratamientoO` codigoTratamiento\n,ot.`FInicio` fechaInicioTratamiento\n,ifnull(ot.`FPFin`,'') fechaFinTratamiento\n,if(ot.`Estado`=1,'ACTIVO','CERRADO') estadoTratamiento\n,cc.`Id_ingreso` codIngreso\n,concat(e.`Apellido1`,' ', e.`Apellido2`,' ',e.`Nombre1`,' ',e.`Nombre2`) as profesional\n,ha.`Codigo_Dxp`\n,ifnull(gpc.`Nbre`,'') as grupoProcedimiento, \nifnull(pr.`Nbre`,'') as procedimiento,\nifnull(otp.`Cantidad`,0) cantidad\nfrom c_citas as cc\ninner join c_clasecita clc on (cc.`Id_ClaseCita`=clc.`Id`)\ninner join g_persona p on (cc.`Id_Usuario`=p.`Id`)\ninner join g_persona e on (cc.`Id_Profesional`=e.`Id`)\ninner join o_hc_tratamiento ot on (cc.`Id_TratamientoO`=ot.`Id`)\ninner join h_atencion ha on (ot.`Id_Atencion`=ha.`Id`)\ninner join g_usuario gu on (p.`Id`=gu.`Id_persona`)\ninner join g_empresacont gec on (gu.`Id_EmpresaCont`=gec.`Id_empresa`)\ninner join g_empresa em on (gec.`Id_empresa`=em.`Id`)\nleft join o_hc_tratamiento_procedimiento otp on (cc.`Id`=otp.idcita)\nleft join g_procedimiento pr on (otp.`IdProcedimiento`=pr.`Id`)\nleft join o_proced_x_grupo pg on (pr.`Id`=pg.`IdProcedimiento`)\nleft join o_grupo_pro_cup gpc on (pg.`IdGrupo`=gpc.`Id`)\nwhere cc.`Id_Especialidad` IN(461,1032,1023,1024,1035,250) and cc.`Asistida`=3 and cc.`Fecha_Cita`>=? \nand cc.`Fecha_Cita`<=?\nand `Id_MotivoDesistida`=1 and cc.Id_Profesional=?\norder by cc.`Fecha_Cita` desc", mapper, new Object[]{fechaI, fechaF, idProfesional});
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformesSgcDAO
    public List<RegistroDiarioOdontologiaDTO> getRegistroDiarioOdontologia(String fechaI, String fechaF, Integer idProfesional) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl.19
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                RegistroDiarioOdontologiaDTO g = new RegistroDiarioOdontologiaDTO();
                g.setCodCita(rs.getString(1));
                g.setFecha_Cita(rs.getString(2));
                g.setTipoIdentificacion(rs.getString(3));
                g.setNoDocumento(rs.getString(4));
                g.setPaciente(rs.getString(5));
                g.setSexo(rs.getString(6));
                g.setFechaNac(rs.getString(7));
                g.setEdad(rs.getString(8));
                g.setClasificacionCita(rs.getString(9));
                g.setTipoCita(rs.getString(10));
                g.setEps(rs.getString(11));
                g.setCodigoTratamiento(rs.getString(12));
                g.setFechaInicioTratamiento(rs.getString(13));
                g.setFechaFinalTratamiento(rs.getString(14));
                g.setEstadoTratamiento(rs.getString(15));
                g.setCodigoIngreso(rs.getString(16));
                g.setProfesional(rs.getString(17));
                g.setCodigo_Dxp(rs.getString(18));
                g.setCodigo_DxR1(rs.getString(19));
                g.setCodigo_DxR2(rs.getString(20));
                g.setCodigo_DxR3(rs.getString(21));
                return g;
            }
        };
        List<RegistroDiarioOdontologiaDTO> list = this.jdbcTemplate.query("select cc.id codCita, cc.`Fecha_Cita` \n,p.`Id_TipoIdentificacion` as tipoIdentificacion\n, p.`NoDocumento`\n, concat(p.`Apellido1`,' ', p.`Apellido2`,' ',p.`Nombre1`,' ',p.`Nombre2`) as paciente\n,p.`Id_Sexo` as sexo\n,p.`FechaNac`\n,`Devuelve_Edad_2F`(p.`FechaNac`,cc.`Fecha_Cita`) edad\n,clc.`Nbre` as clasificacionCita\n,if(clc.`EsControl`=1,'CONTROL','PRIMER VEZ') as  tipoCita\n,em.`Nbre` as EPS\n,cc.`Id_TratamientoO` codigoTratamiento\n,ot.`FInicio` fechaInicioTratamiento\n,ifnull(ot.`FPFin`,'') fechaFinalTratamiento\n,if(ot.`Estado`=1,'ACTIVO','CERRADO') estadoTratamiento\n,cc.`Id_ingreso` codigoIngreso\n,concat(e.`Apellido1`,' ', e.`Apellido2`,' ',e.`Nombre1`,' ',e.`Nombre2`) as profesional\n,ha.`Codigo_Dxp`\n,ha.`Codigo_DxR1`\n,ha.`Codigo_DxR2`\n,ha.`Codigo_DxR3`\nfrom c_citas as cc\ninner join c_clasecita clc on (cc.`Id_ClaseCita`=clc.`Id`)\ninner join g_persona p on (cc.`Id_Usuario`=p.`Id`)\ninner join g_persona e on (cc.`Id_Profesional`=e.`Id`)\ninner join o_hc_tratamiento ot on (cc.`Id_TratamientoO`=ot.`Id`)\ninner join h_atencion ha on (ot.`Id_Atencion`=ha.`Id`)\ninner join g_usuario gu on (p.`Id`=gu.`Id_persona`)\ninner join g_empresacont gec on (gu.`Id_EmpresaCont`=gec.`Id_empresa`)\ninner join g_empresa em on (gec.`Id_empresa`=em.`Id`)\nwhere cc.`Id_Especialidad` IN(461,1032,1023,1024,1035,250) and cc.`Asistida`=3 and cc.`Fecha_Cita`>=? \nand cc.`Fecha_Cita`<=? and cc.Id_Profesional=?\nand `Id_MotivoDesistida`=1\norder by cc.`Fecha_Cita` desc", mapper, new Object[]{fechaI, fechaF, idProfesional});
        return list;
    }
}
