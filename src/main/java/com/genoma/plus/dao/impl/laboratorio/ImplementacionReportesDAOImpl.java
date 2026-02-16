package com.genoma.plus.dao.impl.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO;
import com.genoma.plus.dto.laboratorio.RDetalleExamenesPendientes;
import com.genoma.plus.dto.laboratorio.RDetalleResultadoComentarioProcedimiento;
import com.genoma.plus.dto.laboratorio.RDetalleResultadoDTO;
import com.genoma.plus.dto.laboratorio.RDetalleResultadoHistoricoDTO;
import com.genoma.plus.dto.laboratorio.REncabezadoResultadoDTO;
import com.genoma.plus.dto.parametrizacion.resourceDTO;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/laboratorio/ImplementacionReportesDAOImpl.class */
public class ImplementacionReportesDAOImpl implements ImplementacionReportesDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos metodos = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO
    public List<RDetalleResultadoDTO> detalleResultado(String idRecepcion, String idProcedimientos) {
        String xsql;
        if (idProcedimientos.equals("")) {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                xsql = "SELECT\n\t`l_resultados`.`Id_Recepcion` AS idRecepcion,\n\t`l_areas`.`Id` AS `idArea`,\n\t`l_areas`.`Nbre` AS `nArea`,\n\t`g_procedimiento`.`Id` AS `idProcedimiento`,\n\t`g_procedimiento`.`Nbre` AS `nProcedimiento`,\n\t`l_protocolos`.`Id` AS `idProtocolo`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_protocolos`.`Nbre`,\tNULL) AS `nProtocolo`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_detalleresultado`.`VrNumerico`,\tNULL) AS `vResultado`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_detalleresultado`.`Unidad`,\tNULL) AS `vUnidad`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_detalleresultado`.`VReferencia1`,NULL) AS `vMinimo`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_detalleresultado`.`VReferencia2`,NULL) AS `vMaximo`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,NULL,CONCAT(`l_protocolos`.`Nbre`, '', `l_detalleresultado`.`VrNumerico`)) as vResultadoUnificado,\n\tIF(l_detalleresultado.`Observacion` = '',NULL,CONCAT('OBSERVACIÓN : ', l_detalleresultado.`Observacion`)) AS `observacionProtocolo`,\n\tIF(l_detalleresultado.`Alterado` = 1,\n\tcase\n\t\twhen CAST(`l_detalleresultado`.`VrNumerico` AS DOUBLE) < CAST(`l_detalleresultado`.`VReferencia1` AS DOUBLE) then '↓'\n\t\twhen CAST(`l_detalleresultado`.`VrNumerico` AS DOUBLE) > CAST(`l_detalleresultado`.`VReferencia2` AS DOUBLE) then '↑'\n\t\telse '!'\n\tend, '') AS `rAlterado`,\n\t`l_tipo_metodo`.`Nbre` AS `nMetodo`    ,\n\tCONCAT(`Persona_ProfesionalGraba`.`Apellido1` , ' ', `Persona_ProfesionalGraba`.`Apellido2`, ' ', `Persona_ProfesionalGraba`.`Nombre1`, ' ', `Persona_ProfesionalGraba`.`Nombre2`) AS `profesional_Graba`,\n\t`Especialidad_Graba`.`Nbre` AS `especialidad_Graba`,\n\t`Profesional_Graba`.`DireccionF` AS `url_FirmaGraba`,\n\tProfesional_Graba.`Tarjeta` AS `tajetaProfesionalGraba`,\n\tCONCAT(`Persona_Profesional_Valida`.`Apellido1` , ' ', `Persona_Profesional_Valida`.`Apellido2`, ' ', `Persona_Profesional_Valida`.`Nombre1`, ' ', `Persona_Profesional_Valida`.`Nombre2`) AS `profesional_Valida`,\n\t`g_especialidad_1`.`Nbre` AS `especialidad_Valida`,\n\tProfesional_Valida.`DireccionF` AS `url_FirmaValida`,\n\tProfesional_Valida.`Tarjeta` AS `tajetaProfesionalValida`,\n\tl_resultados.`Fecha` as `fechaResult`,\n\tIF(l_tipo_encabezado.Nbre = 'NO APLICA',NULL,l_tipo_encabezado.Nbre) AS encabezado_Protocolo,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,IF(`l_detalleresultado`.`Unidad` = '',`l_detalleresultado`.`VrNumerico`,CONCAT(`l_detalleresultado`.`VrNumerico`, ' ', l_detalleresultado.`Unidad`)),NULL) valorResultadoConcatenado,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,\n\tIF((`l_detalleresultado`.`VReferencia1` = '' AND `l_detalleresultado`.`VReferencia2` = ''),NULL,\n\tIF((`l_detalleresultado`.`VReferencia1` <> '' \n\tAND `l_detalleresultado`.`VReferencia2` <> ''),\n\tCONCAT (`l_detalleresultado`.`VReferencia1`,\n\t' - ' ,\n\t`l_detalleresultado`.`VReferencia2`),\n\tIF((`l_detalleresultado`.`VReferencia1` <> ''\n\tAND `l_detalleresultado`.`VReferencia2` = ''),\n\t`l_detalleresultado`.`VReferencia1`,\n\t`l_detalleresultado`.`VReferencia2`))),\n\tNULL) valorRefenciaConcatenado ,\n\t`l_protocoloxprocedimiento`.`Id` AS idProtocoloxProcedimiento,\n\tld.fechaMuestra, ld.FechaValidado as fechaValidado\nFROM\n\t`l_resultados`\nINNER JOIN `l_detalleresultado`\n        ON\n\t(`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\ninner join l_detallerecepcion ld on\n\t(ld.Id_Recepcion = l_resultados.Id_Recepcion)\n\tand (ld.Id_Procedim = l_detalleresultado.Id_Procedimiento)\nINNER JOIN `g_procedimiento` \n        ON\n\t(`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nINNER JOIN `l_protocoloxprocedimiento` \n        ON\n\t(`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nINNER JOIN `g_profesional` AS `Profesional_Graba` \n        ON\n\t(`Profesional_Graba`.`Id_Persona` = `l_detalleresultado`.`Bacteriologo`)\nINNER JOIN `g_especialidad` AS `Especialidad_Graba` \n        ON\n\t(`Especialidad_Graba`.`Id` = `l_detalleresultado`.`Id_Especialidad`)\nLEFT JOIN `g_profesional` AS `Profesional_Valida`\n        ON\n\t(`l_detalleresultado`.`IdProfesionalV` = `Profesional_Valida`.`Id_Persona`)\nLEFT JOIN `g_especialidad` AS `g_especialidad_1`\n        ON\n\t(`l_detalleresultado`.`IdEspecialidadV` = `g_especialidad_1`.`Id`)\nINNER JOIN `l_protocolos` \n        ON\n\t(`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\nINNER JOIN `l_areas` \n        ON\n\t(`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `l_tipo_encabezado` \n         ON\n\t(`l_tipo_encabezado`.`Id` = `l_protocolos`.`Id_tencabezado`)\nINNER JOIN `l_tipo_metodo` \n        ON\n\t(`g_procedimiento`.`Id_TipoMetodo` = `l_tipo_metodo`.`Id`)\nINNER JOIN `g_persona` AS `Persona_ProfesionalGraba` \n        ON\n\t(`Persona_ProfesionalGraba`.`Id` = `Profesional_Graba`.`Id_Persona`)\nLEFT JOIN `g_persona` AS `Persona_Profesional_Valida` \n        ON\n\t(`Persona_Profesional_Valida`.`Id` = `Profesional_Valida`.`Id_Persona`)\nWHERE\n\t(`l_resultados`.`Id_Recepcion` = '" + idRecepcion + "'\n\t\tAND l_resultados.Estado = 0\n\t\tAND `l_detalleresultado`.`Validado` = 1\n\t\tAND l_detalleresultado.Estado = 1 \n    )\nORDER BY\n\tg_procedimiento.`NOrdenI` ASC,\n\tl_protocoloxprocedimiento.`Orden` ASC";
            } else {
                xsql = "SELECT\n    `l_resultados`.`Id_Recepcion` AS idRecepcion\n    , `l_areas`.`Id` AS `idArea`\n    , `l_areas`.`Nbre` AS `nArea`\n    , `g_procedimiento`.`Id` AS `idProcedimiento`\n    , `g_procedimiento`.`Nbre` AS `nProcedimiento`\n    , `l_protocolos`.`Id` AS `idProtocolo`\n    ,  IF(l_protocolos.`ResultadoUnificado`=0, `l_protocolos`.`Nbre`, NULL) AS `nProtocolo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VrNumerico`, NULL) AS `vResultado`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`Unidad`, NULL) AS `vUnidad`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VReferencia1`, NULL) AS `vMinimo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VReferencia2`, NULL) AS `vMaximo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,NULL, CONCAT(`l_protocolos`.`Nbre`, '\n', `l_detalleresultado`.`VrNumerico`))vResultadoUnificado\n    ,  IF(l_detalleresultado.`Observacion`='',NULL,CONCAT('OBSERVACIÓN : ',l_detalleresultado.`Observacion`)) AS `observacionProtocolo`\n    , IF(l_detalleresultado.`Alterado`=1, '*','') AS `rAlterado`\n    , `l_tipo_metodo`.`Nbre` AS `nMetodo`\n    , CONCAT(`Persona_ProfesionalGraba`.`Apellido1` ,' ', `Persona_ProfesionalGraba`.`Apellido2`,' ',`Persona_ProfesionalGraba`.`Nombre1`,' ',`Persona_ProfesionalGraba`.`Nombre2`) AS `profesional_Graba`\n    , `Especialidad_Graba`.`Nbre` AS `especialidad_Graba`\n    , `Profesional_Graba`.`DireccionF` AS `url_FirmaGraba`\n    , Profesional_Graba.`Tarjeta` AS `tajetaProfesionalGraba`\n    , CONCAT(`Persona_Profesional_Valida`.`Apellido1` ,' ', `Persona_Profesional_Valida`.`Apellido2`,' ',`Persona_Profesional_Valida`.`Nombre1`,' ',`Persona_Profesional_Valida`.`Nombre2`) AS `profesional_Valida`\n    , `g_especialidad_1`.`Nbre` AS `especialidad_Valida`\n    , Profesional_Valida.`DireccionF` AS `url_FirmaValida`\n    , Profesional_Valida.`Tarjeta` AS `tajetaProfesionalValida`\n    , l_resultados.`Fecha`   as  `fechaResult` , IF(l_tipo_encabezado.Nbre='NO APLICA',NULL,l_tipo_encabezado.Nbre) AS encabezado_Protocolo\n,IF(l_protocolos.`ResultadoUnificado`=0,IF(`l_detalleresultado`.`Unidad`='',`l_detalleresultado`.`VrNumerico`, CONCAT(`l_detalleresultado`.`VrNumerico`,' ', l_detalleresultado.`Unidad`)), NULL) valorResultadoConcatenado\n    ,IF(l_protocolos.`ResultadoUnificado`=0,IF((`l_detalleresultado`.`VReferencia1`='' AND `l_detalleresultado`.`VReferencia2`=''),NULL,\n     IF((`l_detalleresultado`.`VReferencia1`<>'' AND `l_detalleresultado`.`VReferencia2`<>''), CONCAT (`l_detalleresultado`.`VReferencia1`, ' - ' ,`l_detalleresultado`.`VReferencia2`),\n     IF((`l_detalleresultado`.`VReferencia1`<>'' AND `l_detalleresultado`.`VReferencia2`=''), `l_detalleresultado`.`VReferencia1`, `l_detalleresultado`.`VReferencia2`))), NULL) valorRefenciaConcatenado \n   ,`l_protocoloxprocedimiento`.`Id` AS idProtocoloxProcedimiento\n   , ld.fechaMuestra, ld.FechaValidado as fechaValidado \nFROM\n     `l_resultados` \n    INNER JOIN  `l_detalleresultado`\n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    inner join l_detallerecepcion ld on (ld.Id_Recepcion=l_resultados.Id_Recepcion) and (ld.Id_Procedim=l_detalleresultado.Id_Procedimiento)  \n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `g_profesional` AS `Profesional_Graba` \n        ON (`Profesional_Graba`.`Id_Persona` = `l_detalleresultado`.`Bacteriologo`)\n    INNER JOIN  `g_especialidad` AS `Especialidad_Graba` \n        ON (`Especialidad_Graba`.`Id` = `l_detalleresultado`.`Id_Especialidad`)\n    LEFT JOIN  `g_profesional` AS `Profesional_Valida`\n        ON (`l_detalleresultado`.`IdProfesionalV` = `Profesional_Valida`.`Id_Persona`)\n    LEFT JOIN  `g_especialidad` AS `g_especialidad_1`\n        ON (`l_detalleresultado`.`IdEspecialidadV` = `g_especialidad_1`.`Id`)\n    INNER JOIN  `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN  `l_areas` \n        ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\n INNER JOIN `l_tipo_encabezado` \n         ON (`l_tipo_encabezado`.`Id` = `l_protocolos`.`Id_tencabezado`)\n    INNER JOIN  `l_tipo_metodo` \n        ON (`g_procedimiento`.`Id_TipoMetodo` = `l_tipo_metodo`.`Id`)\n    INNER JOIN  `g_persona` AS `Persona_ProfesionalGraba` \n        ON (`Persona_ProfesionalGraba`.`Id` = `Profesional_Graba`.`Id_Persona`)\n    LEFT JOIN  `g_persona` AS `Persona_Profesional_Valida` \n        ON (`Persona_Profesional_Valida`.`Id` = `Profesional_Valida`.`Id_Persona`)\nWHERE (`l_resultados`.`Id_Recepcion` ='" + idRecepcion + "' \n AND l_resultados.Estado =0 AND `l_detalleresultado`.`Validado` =1\n    AND  l_detalleresultado.Estado=1 \n    )\nORDER BY  g_procedimiento.`NOrdenI` ASC, l_protocoloxprocedimiento.`Orden` ASC";
            }
            System.out.print((char) 8679);
        } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
            xsql = "SELECT\n\t`l_resultados`.`Id_Recepcion` AS idRecepcion,\n\t`l_areas`.`Id` AS `idArea`,\n\t`l_areas`.`Nbre` AS `nArea`,\n\t`g_procedimiento`.`Id` AS `idProcedimiento`,\n\t`g_procedimiento`.`Nbre` AS `nProcedimiento`,\n\t`l_protocolos`.`Id` AS `idProtocolo`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_protocolos`.`Nbre`,\tNULL) AS `nProtocolo`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_detalleresultado`.`VrNumerico`,\tNULL) AS `vResultado`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_detalleresultado`.`Unidad`,\tNULL) AS `vUnidad`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_detalleresultado`.`VReferencia1`,NULL) AS `vMinimo`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,`l_detalleresultado`.`VReferencia2`,NULL) AS `vMaximo`,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,NULL,CONCAT(`l_protocolos`.`Nbre`, '', `l_detalleresultado`.`VrNumerico`)) as vResultadoUnificado,\n\tIF(l_detalleresultado.`Observacion` = '',NULL,CONCAT('OBSERVACIÓN : ', l_detalleresultado.`Observacion`)) AS `observacionProtocolo`,\n\tIF(l_detalleresultado.`Alterado` = 1,\n\tcase\n\t\twhen CAST(`l_detalleresultado`.`VrNumerico` AS DOUBLE) < CAST(`l_detalleresultado`.`VReferencia1` AS DOUBLE) then '↓'\n\t\twhen CAST(`l_detalleresultado`.`VrNumerico` AS DOUBLE) > CAST(`l_detalleresultado`.`VReferencia2` AS DOUBLE) then '↑'\n\t\telse '!'\n\tend, '') AS `rAlterado`,\n\t`l_tipo_metodo`.`Nbre` AS `nMetodo`    ,\n\tCONCAT(`Persona_ProfesionalGraba`.`Apellido1` , ' ', `Persona_ProfesionalGraba`.`Apellido2`, ' ', `Persona_ProfesionalGraba`.`Nombre1`, ' ', `Persona_ProfesionalGraba`.`Nombre2`) AS `profesional_Graba`,\n\t`Especialidad_Graba`.`Nbre` AS `especialidad_Graba`,\n\t`Profesional_Graba`.`DireccionF` AS `url_FirmaGraba`,\n\tProfesional_Graba.`Tarjeta` AS `tajetaProfesionalGraba`,\n\tCONCAT(`Persona_Profesional_Valida`.`Apellido1` , ' ', `Persona_Profesional_Valida`.`Apellido2`, ' ', `Persona_Profesional_Valida`.`Nombre1`, ' ', `Persona_Profesional_Valida`.`Nombre2`) AS `profesional_Valida`,\n\t`g_especialidad_1`.`Nbre` AS `especialidad_Valida`,\n\tProfesional_Valida.`DireccionF` AS `url_FirmaValida`,\n\tProfesional_Valida.`Tarjeta` AS `tajetaProfesionalValida`,\n\tl_resultados.`Fecha` as `fechaResult`,\n\tIF(l_tipo_encabezado.Nbre = 'NO APLICA',NULL,l_tipo_encabezado.Nbre) AS encabezado_Protocolo,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,IF(`l_detalleresultado`.`Unidad` = '',`l_detalleresultado`.`VrNumerico`,CONCAT(`l_detalleresultado`.`VrNumerico`, ' ', l_detalleresultado.`Unidad`)),NULL) valorResultadoConcatenado,\n\tIF(l_protocolos.`ResultadoUnificado` = 0,\n\tIF((`l_detalleresultado`.`VReferencia1` = '' AND `l_detalleresultado`.`VReferencia2` = ''),NULL,\n\tIF((`l_detalleresultado`.`VReferencia1` <> '' \n\tAND `l_detalleresultado`.`VReferencia2` <> ''),\n\tCONCAT (`l_detalleresultado`.`VReferencia1`,\n\t' - ' ,\n\t`l_detalleresultado`.`VReferencia2`),\n\tIF((`l_detalleresultado`.`VReferencia1` <> ''\n\tAND `l_detalleresultado`.`VReferencia2` = ''),\n\t`l_detalleresultado`.`VReferencia1`,\n\t`l_detalleresultado`.`VReferencia2`))),\n\tNULL) valorRefenciaConcatenado ,\n\t`l_protocoloxprocedimiento`.`Id` AS idProtocoloxProcedimiento,\n\tld.fechaMuestra, ld.FechaValidado as fechaValidado\nFROM\n\t`l_resultados`\nINNER JOIN `l_detalleresultado`\n        ON\n\t(`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\ninner join l_detallerecepcion ld on\n\t(ld.Id_Recepcion = l_resultados.Id_Recepcion)\n\tand (ld.Id_Procedim = l_detalleresultado.Id_Procedimiento)\nINNER JOIN `g_procedimiento` \n        ON\n\t(`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\nINNER JOIN `l_protocoloxprocedimiento` \n        ON\n\t(`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\nINNER JOIN `g_profesional` AS `Profesional_Graba` \n        ON\n\t(`Profesional_Graba`.`Id_Persona` = `l_detalleresultado`.`Bacteriologo`)\nINNER JOIN `g_especialidad` AS `Especialidad_Graba` \n        ON\n\t(`Especialidad_Graba`.`Id` = `l_detalleresultado`.`Id_Especialidad`)\nLEFT JOIN `g_profesional` AS `Profesional_Valida`\n        ON\n\t(`l_detalleresultado`.`IdProfesionalV` = `Profesional_Valida`.`Id_Persona`)\nLEFT JOIN `g_especialidad` AS `g_especialidad_1`\n        ON\n\t(`l_detalleresultado`.`IdEspecialidadV` = `g_especialidad_1`.`Id`)\nINNER JOIN `l_protocolos` \n        ON\n\t(`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\nINNER JOIN `l_areas` \n        ON\n\t(`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `l_tipo_encabezado` \n         ON\n\t(`l_tipo_encabezado`.`Id` = `l_protocolos`.`Id_tencabezado`)\nINNER JOIN `l_tipo_metodo` \n        ON\n\t(`g_procedimiento`.`Id_TipoMetodo` = `l_tipo_metodo`.`Id`)\nINNER JOIN `g_persona` AS `Persona_ProfesionalGraba` \n        ON\n\t(`Persona_ProfesionalGraba`.`Id` = `Profesional_Graba`.`Id_Persona`)\nLEFT JOIN `g_persona` AS `Persona_Profesional_Valida` \n        ON\n\t(`Persona_Profesional_Valida`.`Id` = `Profesional_Valida`.`Id_Persona`)\nWHERE\n\t(`l_resultados`.`Id_Recepcion` = '" + idRecepcion + "'\n             AND `g_procedimiento`.`Id` IN(" + idProcedimientos + "\t\tAND l_resultados.Estado = 0\n\t\tAND `l_detalleresultado`.`Validado` = 1\n\t\tAND l_detalleresultado.Estado = 1 \n    )\nORDER BY\n\tg_procedimiento.`NOrdenI` ASC,\n\tl_protocoloxprocedimiento.`Orden` ASC";
        } else {
            xsql = "SELECT\n    `l_resultados`.`Id_Recepcion` AS idRecepcion\n    , `l_areas`.`Id` AS `idArea`\n    , `l_areas`.`Nbre` AS `nArea`\n    , `g_procedimiento`.`Id` AS `idProcedimiento`\n    , `g_procedimiento`.`Nbre` AS `nProcedimiento`\n    , `l_protocolos`.`Id` AS `idProtocolo`\n    ,  IF(l_protocolos.`ResultadoUnificado`=0, `l_protocolos`.`Nbre`, NULL) AS `nProtocolo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VrNumerico`, NULL) AS `vResultado`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`Unidad`, NULL) AS `vUnidad`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VReferencia1`, NULL) AS `vMinimo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VReferencia2`, NULL) AS `vMaximo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,NULL, CONCAT(`l_protocolos`.`Nbre`, '\n', `l_detalleresultado`.`VrNumerico`))vResultadoUnificado\n    ,  IF(l_detalleresultado.`Observacion`='',NULL,CONCAT('OBSERVACIÓN : ',l_detalleresultado.`Observacion`)) AS `observacionProtocolo`\n    , IF(l_detalleresultado.`Alterado`=1, '***','') AS `rAlterado`\n    , `l_tipo_metodo`.`Nbre` AS `nMetodo`\n    , CONCAT(`Persona_ProfesionalGraba`.`Apellido1` ,' ', `Persona_ProfesionalGraba`.`Apellido2`,' ',`Persona_ProfesionalGraba`.`Nombre1`,' ',`Persona_ProfesionalGraba`.`Nombre2`) AS `profesional_Graba`\n    , `Especialidad_Graba`.`Nbre` AS `especialidad_Graba`\n    , `Profesional_Graba`.`DireccionF` AS `url_FirmaGraba`\n    , Profesional_Graba.`Tarjeta` AS `tajetaProfesionalGraba`\n    , CONCAT(`Persona_Profesional_Valida`.`Apellido1` ,' ', `Persona_Profesional_Valida`.`Apellido2`,' ',`Persona_Profesional_Valida`.`Nombre1`,' ',`Persona_Profesional_Valida`.`Nombre2`) AS `profesional_Valida`\n    , `g_especialidad_1`.`Nbre` AS `especialidad_Valida`\n    , Profesional_Valida.`DireccionF` AS `url_FirmaValida`\n    , Profesional_Valida.`Tarjeta` AS `tajetaProfesionalValida`\n    , l_resultados.`Fecha`   as  `fechaResult` , IF(l_tipo_encabezado.Nbre='NO APLICA',NULL,l_tipo_encabezado.Nbre) AS encabezado_Protocolo\n,IF(l_protocolos.`ResultadoUnificado`=0,IF(`l_detalleresultado`.`Unidad`='',`l_detalleresultado`.`VrNumerico`, CONCAT(`l_detalleresultado`.`VrNumerico`,' ', l_detalleresultado.`Unidad`)), NULL) valorResultadoConcatenado\n    ,IF(l_protocolos.`ResultadoUnificado`=0,IF((`l_detalleresultado`.`VReferencia1`='' AND `l_detalleresultado`.`VReferencia2`=''),NULL,\n     IF((`l_detalleresultado`.`VReferencia1`<>'' AND `l_detalleresultado`.`VReferencia2`<>''), CONCAT (`l_detalleresultado`.`VReferencia1`, ' - ' ,`l_detalleresultado`.`VReferencia2`),\n     IF((`l_detalleresultado`.`VReferencia1`<>'' AND `l_detalleresultado`.`VReferencia2`=''), `l_detalleresultado`.`VReferencia1`, `l_detalleresultado`.`VReferencia2`))), NULL) valorRefenciaConcatenado    ,`l_protocoloxprocedimiento`.`Id` AS idProtocoloxProcedimiento\n   , ld.fechaMuestra, ld.FechaValidado as fechaValidado \nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    inner join l_detallerecepcion ld on (ld.Id_Recepcion=l_resultados.Id_Recepcion) and (ld.Id_Procedim=l_detalleresultado.Id_Procedimiento)  \n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `g_profesional` AS `Profesional_Graba` \n        ON (`Profesional_Graba`.`Id_Persona` = `l_detalleresultado`.`Bacteriologo`)\n    INNER JOIN  `g_especialidad` AS `Especialidad_Graba` \n        ON (`Especialidad_Graba`.`Id` = `l_detalleresultado`.`Id_Especialidad`)\n    LEFT JOIN  `g_profesional` AS `Profesional_Valida`\n        ON (`l_detalleresultado`.`IdProfesionalV` = `Profesional_Valida`.`Id_Persona`)\n    LEFT JOIN  `g_especialidad` AS `g_especialidad_1`\n        ON (`l_detalleresultado`.`IdEspecialidadV` = `g_especialidad_1`.`Id`)\n    INNER JOIN  `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN  `l_areas` \n        ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\n INNER JOIN `l_tipo_encabezado` \n         ON (`l_tipo_encabezado`.`Id` = `l_protocolos`.`Id_tencabezado`)\n    INNER JOIN  `l_tipo_metodo` \n        ON (`g_procedimiento`.`Id_TipoMetodo` = `l_tipo_metodo`.`Id`)\n    INNER JOIN  `g_persona` AS `Persona_ProfesionalGraba` \n        ON (`Persona_ProfesionalGraba`.`Id` = `Profesional_Graba`.`Id_Persona`)\n    LEFT JOIN  `g_persona` AS `Persona_Profesional_Valida` \n        ON (`Persona_Profesional_Valida`.`Id` = `Profesional_Valida`.`Id_Persona`)\nWHERE ((`l_resultados`.`Id_Recepcion` ='" + idRecepcion + "' AND `g_procedimiento`.`Id` IN(" + idProcedimientos + "))\n AND l_resultados.Estado =0 AND `l_detalleresultado`.`Validado` =1\n    AND  l_detalleresultado.Estado=1 \n    )\nORDER BY  g_procedimiento.`NOrdenI` ASC, l_protocoloxprocedimiento.`Orden` ASC";
        }
        System.out.println("" + xsql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ImplementacionReportesDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                RDetalleResultadoDTO g = new RDetalleResultadoDTO();
                g.setIdRecepcion(Long.valueOf(rs.getLong("idRecepcion")));
                g.setIdArea(Long.valueOf(rs.getLong("idArea")));
                g.setNombreArea(rs.getString("nArea"));
                g.setIdProcedimiento(Long.valueOf(rs.getLong("idProcedimiento")));
                g.setNombreProcedimiento(rs.getString("nProcedimiento"));
                g.setIdProtocolo(Long.valueOf(rs.getLong("idProtocolo")));
                g.setNombreProtocolo(rs.getString("nProtocolo"));
                g.setValorResultado(rs.getString("vResultado"));
                g.setResultadoUnificado(rs.getString("vResultadoUnificado"));
                g.setValorUnidad(rs.getString("vUnidad"));
                g.setValorMinimo(rs.getString("vMinimo"));
                g.setValorMaximo(rs.getString("vMaximo"));
                g.setObservacionProtocolo(rs.getString("observacionProtocolo"));
                g.setResultadoAlterado(rs.getString("rAlterado"));
                g.setNombreMetodo(rs.getString("nMetodo"));
                g.setProfesional_Graba(rs.getString("profesional_Graba"));
                g.setEspecialidad_Graba(rs.getString("especialidad_Graba"));
                g.setUrl_FirmaGraba(rs.getString("url_FirmaGraba"));
                g.setTajetaProfesionalGraba(rs.getString("tajetaProfesionalGraba"));
                g.setProfesional_Valida(rs.getString("profesional_Valida"));
                g.setEspecialidad_Valida(rs.getString("especialidad_Valida"));
                g.setUrl_FirmaValida(rs.getString("url_FirmaValida"));
                g.setTajetaProfesionalValida(rs.getString("tajetaProfesionalValida"));
                g.setFechaResultado(rs.getString("fechaResult"));
                g.setEncabezadoProtocolo(rs.getString("encabezado_Protocolo"));
                g.setValorRefenciaConcatenado(rs.getString("valorRefenciaConcatenado"));
                g.setValorResultadoConcatenado(rs.getString("valorResultadoConcatenado"));
                g.setDetalleHistorico(ImplementacionReportesDAOImpl.this.detalleHistoricoProtocolo(rs.getString("idRecepcion"), rs.getString("idProtocoloxProcedimiento")));
                g.setDetalleComentarioProcedimiento(ImplementacionReportesDAOImpl.this.detalleComentarioProcedimento(rs.getString("idProcedimiento"), rs.getString("idRecepcion")));
                g.setFechaMuestra(rs.getString("fechaMuestra"));
                g.setFechaValidado(rs.getString("fechaValidado"));
                String idProcedimiento = rs.getString("idProcedimiento");
                String idRecepcion2 = rs.getString("idRecepcion");
                g.setListHistogramasSupplier(() -> {
                    return ImplementacionReportesDAOImpl.this.detalleHistograma(idProcedimiento, idRecepcion2);
                });
                return g;
            }
        };
        List<RDetalleResultadoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO
    public REncabezadoResultadoDTO detalleEncabezadoResultado(String idRecepcion) {
        String xsql;
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
            xsql = "SELECT\n    `l_recepcion`.`Id` AS idRecepcion\n    , CAST(LPAD(l_resultados.Id_Recepcion,10,'0') AS CHAR) AS `nRecepcion`\n    , DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS fechaRecep\n    , DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%h:%i:%s %p') AS horaRecep\n    , `g_usuario`.`NoHistoria` AS nHistoria\n    , CONCAT(g_persona.Id_TipoIdentificacion,'-', g_persona.NoDocumento) AS `nDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1` ,' ',`g_persona`.`Nombre2`) AS `nUsuario`\n    , CONCAT(`Devuelve_Edad_2F`(g_persona.`FechaNac`,`l_recepcion`.`FechaRecep`), ' ', `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`,`l_recepcion`.`FechaRecep`) ) AS `edad`\n    , `g_persona`.`Id_Sexo` AS idSexo, DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y') AS fechaNacimiento\n    , IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`=''), NULL, IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`=''), `g_persona`.`Telefono`, IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>''), `g_persona`.`Movil`, IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`<>''), CONCAT(`g_persona`.`Movil`, ' - ',`g_persona`.`Telefono`), NULL)))) AS `telefono`\n    , `g_empresa`.`Nbre` AS `nEmpresa`\n    , `f_empresacontxconvenio`.`Nbre` AS `nEmpresaConvenio`,\n    IFNULL(d_ips.`NEmpresa`,'') AS nIps,\nIFNULL(d_ips.`Telefono`,'') AS nTelefonoIps,\nIF(d_ips.`Direccion` IS NULL,'',d_ips.`Direccion`) AS direccionIps,\nIF(d_ips.`Direccion2` IS NULL,'',d_ips.`Direccion2`) AS direccionIps2,\nIFNULL(d_ips.`TipoIdEmpresa`,'') AS tipoDocIps,\nIFNULL(d_ips.`IdConcatenado`,'') AS documentoIps,\nIF(d_ips.`Eslogan` IS NULL,'',d_ips.`Eslogan`)  AS esloganIps,\nIFNULL(d_ips.`Logo`,'') AS logoIps,\nIFNULL(d_ips.`LogoC`,'') AS logoCIps\n, g_sedes.`Nbre` AS sede\n,IF(d_ips.UrlLogoSuperS ='', NULL,d_ips.UrlLogoSuperS) AS urlLogoSuperS\n , `l_recepcion`.`medicoTratante` AS `profesional_Envia`\n, IF(l_recepcion.`Peso`=0,NULL, CONCAT('Peso : ',l_recepcion.`Peso`)) AS Peso, IF(l_recepcion.`Talla`=0,NULL, CONCAT('Talla : ',l_recepcion.`Talla`)) AS Talla, IF(l_recepcion.`Imc`=0,NULL, CONCAT('Imc : ',l_recepcion.`Imc`)) AS Imc, IF(l_recepcion.`PAbdominal`=0,NULL, CONCAT('Perímetro Abdominal : ',l_recepcion.`PAbdominal`)) AS PAbdominal, IF(l_recepcion.`SCorporal`=0,NULL, CONCAT('Superficie Corporal : ',l_recepcion.`SCorporal`)) AS SCorporal\n, `d_ips`.`NMunicipio` , `d_ips`.`NDepartamento`, `g_municipio`.`Nbre` AS `MunicipioU`, `ingreso`.`NoAutorizacion`, g_tipoatencion.Nbre AS tipoServicio\n, empresaEps.`Nbre`  nombreEps\n, d_ips.`labCoord`\n, d_ips.`firmaLabCoord`\nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `f_ordenes` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_tipoatencion` \n        ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`) \nINNER JOIN  `g_empresa` empresaEps\n        ON (`empresaEps`.`Id` = `g_usuario`.Id_EmpresaCont ) \n    INNER JOIN  `d_ips` \n        ON (`d_ips`.`Id` = `f_empresacontxconvenio`.`Id_GIps`)\n    INNER JOIN  `g_sedes`\n        ON (`g_sedes`.`Id` = `ingreso`.`Id_Sede`)\n    INNER JOIN  `g_persona` profesional_envia\n        ON (ingreso.`Id_Profesional` = `profesional_envia`.`Id`) \nWHERE (l_resultados.Id_Recepcion ='" + idRecepcion + "'\n    AND l_resultados.Estado =0 AND l_detalleresultado.`Validado`=1 \n    AND  l_detalleresultado.Estado=1\n      )\nGROUP BY `l_recepcion`.`Id`;";
            System.out.println("" + xsql);
        } else {
            xsql = "SELECT\n    `l_recepcion`.`Id` AS idRecepcion\n    , CAST(LPAD(l_resultados.Id_Recepcion,10,'0') AS CHAR) AS `nRecepcion`\n    , date_format(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS fechaRecep\n    , DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%h:%i:%s %p') AS horaRecep\n    , `g_usuario`.`NoHistoria` AS nHistoria\n    , CONCAT(g_persona.Id_TipoIdentificacion,'-', g_persona.NoDocumento) AS `nDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1` ,' ',`g_persona`.`Nombre2`) AS `nUsuario`\n    , CONCAT(`Devuelve_Edad_2F`(g_persona.`FechaNac`,`l_recepcion`.`FechaRecep`), ' ', `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`,`l_recepcion`.`FechaRecep`) ) AS `edad`\n    , `g_persona`.`Id_Sexo` AS idSexo, date_format(g_persona.FechaNac,'%d-%m-%Y') as fechaNacimiento\n    , IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`=''), NULL, IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`=''), `g_persona`.`Telefono`, IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>''), `g_persona`.`Movil`, IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`<>''), CONCAT(`g_persona`.`Movil`, ' - ',`g_persona`.`Telefono`), NULL)))) AS `telefono`\n    , `g_empresa`.`Nbre` AS `nEmpresa`\n    , `f_empresacontxconvenio`.`Nbre` AS `nEmpresaConvenio`,\n    IFNULL(d_ips.`NEmpresa`,'') AS nIps,\nIFNULL(d_ips.`Telefono`,'') AS nTelefonoIps,\nIF(d_ips.`Direccion` IS NULL,'',d_ips.`Direccion`) AS direccionIps,\nIF(d_ips.`Direccion2` IS NULL,'',d_ips.`Direccion2`) AS direccionIps2,\nIFNULL(d_ips.`TipoIdEmpresa`,'') AS tipoDocIps,\nIFNULL(d_ips.`IdConcatenado`,'') AS documentoIps,\nIF(d_ips.`Eslogan` IS NULL,'',d_ips.`Eslogan`)  AS esloganIps,\nIFNULL(d_ips.`Logo`,'') AS logoIps,\nIFNULL(d_ips.`LogoC`,'') AS logoCIps\n, g_sedes.`Nbre` AS sede\n,IF(d_ips.UrlLogoSuperS ='', NULL,d_ips.UrlLogoSuperS) AS urlLogoSuperS\n , CONCAT(`profesional_envia`.`Apellido1` ,' ', `profesional_envia`.`Apellido2` ,' ',`profesional_envia`.`Nombre1` ,' ',`profesional_envia`.`Nombre2`) AS `profesional_Envia`\n, IF(l_recepcion.`Peso`=0,NULL, CONCAT('Peso : ',l_recepcion.`Peso`)) AS Peso, IF(l_recepcion.`Talla`=0,NULL, CONCAT('Talla : ',l_recepcion.`Talla`)) AS Talla, IF(l_recepcion.`Imc`=0,NULL, CONCAT('Imc : ',l_recepcion.`Imc`)) AS Imc, IF(l_recepcion.`PAbdominal`=0,NULL, CONCAT('Perímetro Abdominal : ',l_recepcion.`PAbdominal`)) AS PAbdominal, IF(l_recepcion.`SCorporal`=0,NULL, CONCAT('Superficie Corporal : ',l_recepcion.`SCorporal`)) AS SCorporal\n, `d_ips`.`NMunicipio` , `d_ips`.`NDepartamento`, `g_municipio`.`Nbre` AS `MunicipioU`, `ingreso`.`NoAutorizacion`, g_tipoatencion.Nbre as tipoServicio, empresaEps.`Nbre`  nombreEps\n, d_ips.`labCoord`\n, d_ips.`firmaLabCoord`\nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `f_ordenes` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_tipoatencion` \n        ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`) INNER JOIN  `g_empresa` empresaEps\n        ON (`empresaEps`.`Id` = `g_usuario`.Id_EmpresaCont ) \n    INNER JOIN  `d_ips` \n        ON (`d_ips`.`Id` = `f_empresacontxconvenio`.`Id_GIps`)\n    INNER JOIN  `g_sedes`\n        ON (`g_sedes`.`Id` = `ingreso`.`Id_Sede`)\n    INNER JOIN  `g_persona` profesional_envia\n        ON (ingreso.`Id_Profesional` = `profesional_envia`.`Id`) \nWHERE (l_resultados.Id_Recepcion ='" + idRecepcion + "'\n    AND l_resultados.Estado =0 AND l_detalleresultado.`Validado`=1 \n    AND  l_detalleresultado.Estado=1\n  \n    )\nGROUP BY `l_recepcion`.`Id`;";
            System.out.println("" + xsql);
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ImplementacionReportesDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                REncabezadoResultadoDTO g = new REncabezadoResultadoDTO();
                g.setNombreEps(rs.getString("nombreEps"));
                g.setIdRecepcion(rs.getString("idRecepcion"));
                g.setNumeroRecepcionT(rs.getString("nRecepcion"));
                g.setFechaRecep(rs.getString("fechaRecep"));
                g.setHoraRecep(rs.getString("horaRecep"));
                g.setNumeroHistoria(rs.getString("nHistoria"));
                g.setNumeroDocumento(rs.getString("nDocumento"));
                g.setNombreUsuario(rs.getString("nUsuario"));
                g.setEdad(rs.getString("edad"));
                g.setIdSexo(rs.getString("idSexo"));
                g.setTelefono(rs.getString("telefono"));
                g.setNombreEmpresa(rs.getString("nEmpresa"));
                g.setNombreEmpresaConvenio(rs.getString("nEmpresaConvenio"));
                g.setNombreIps(rs.getString("nIps"));
                g.setNumeroTelefonoIps(rs.getString("nTelefonoIps"));
                g.setDireccionIps(rs.getString("direccionIps"));
                g.setDireccionIps2(rs.getString("direccionIps2"));
                g.setTipoDocIps(rs.getString("tipoDocIps"));
                g.setDocumentoIps(rs.getString("documentoIps"));
                g.setEsloganIps(rs.getString("esloganIps"));
                g.setLogoIps(rs.getString("logoIps"));
                g.setLogoCIps(rs.getString("logoCIps"));
                g.setSede(rs.getString("sede"));
                g.setUrlLogoSuperS(rs.getString("urlLogoSuperS"));
                g.setProfesional_Solicita(rs.getString("profesional_Envia"));
                g.setPeso(rs.getString("Peso"));
                g.setTalla(rs.getString("Talla"));
                g.setImc(rs.getString("Imc"));
                g.setPerimetroAbdominal(rs.getString("PAbdominal"));
                g.setSuperficieCorporal(rs.getString("SCorporal"));
                g.setMunicipioIps(rs.getString("NMunicipio"));
                g.setDepartamentoIps(rs.getString("NDepartamento"));
                g.setMunicipioUsuario(rs.getString("MunicipioU"));
                g.setNumeroAutorizacion(rs.getString("NoAutorizacion"));
                g.setTipoServicio(rs.getString("tipoServicio"));
                g.setFechaNacimiento(rs.getString("fechaNacimiento"));
                g.setUsuarioImprime(Principal.usuarioSistemaDTO.getNombreUsuario());
                g.setLabCoord(rs.getString("labCoord"));
                g.setFirmaLabCoord(rs.getString("firmaLabCoord"));
                g.setListDetalle((List) null);
                return g;
            }
        };
        List<REncabezadoResultadoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override // com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO
    public List<RDetalleResultadoHistoricoDTO> detalleHistoricoProtocolo(String idRecepcion, String idProtocolo) {
        String xsql = "SELECT `l_protocolos`.`Nbre` AS NProtocolo\n    , DATE_FORMAT(`l_resultados`.`FechaResult`,'%d-%m-%Y') AS Fecha\n    , CAST(`l_detalleresultado`.`VrNumerico` AS DECIMAL(5,2)) AS `Resultado`\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_detalleresultado_historico`\n        ON (`l_detalleresultado`.`Id_Resultado` = `l_detalleresultado_historico`.`Id_Resultado`)\n        AND (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_detalleresultado_historico`.`Id_Protocolo_Proc`)\n    INNER JOIN `l_resultados`\n        ON (`l_detalleresultado_historico`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento`\n        ON (`l_detalleresultado_historico`.`Id_Protocolo_Proc` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN `l_protocolos`\n        ON (`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nWHERE (`l_detalleresultado_historico`.`Id_Recepcion` ='" + idRecepcion + "'\n    AND `l_detalleresultado_historico`.`Id_Protocolo_Proc` ='" + idProtocolo + "')\nORDER BY `l_resultados`.`FechaResult` ASC";
        System.out.println("" + xsql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ImplementacionReportesDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                RDetalleResultadoHistoricoDTO g = new RDetalleResultadoHistoricoDTO();
                g.setNombreProtocolo(rs.getString("NProtocolo"));
                g.setFechaResultado(rs.getString("Fecha"));
                g.setValorResultado(Double.valueOf(rs.getDouble("Resultado")));
                return g;
            }
        };
        List<RDetalleResultadoHistoricoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO
    public List<RDetalleResultadoComentarioProcedimiento> detalleComentarioProcedimento(String idProcedimiento, String idRecepcion) {
        String xsql = "SELECT  DISTINCT IF((l_protocoloxtabla.`Descripcion` IS NULL OR l_protocoloxtabla.`Descripcion`='DESCRIPCIÓN'), l_detalleresultado_comentario.`Descripcion` ,\nCONCAT(l_protocoloxtabla.`Nbre`, ' : ',l_detalleresultado_comentario.`Descripcion` ))Descripcion\nFROM `l_detalleresultado_comentario`\nLEFT JOIN l_protocoloxtabla\n        ON (`l_protocoloxtabla`.`Id` = `l_detalleresultado_comentario`.`Id_Tipo_TProtocolo`)\nWHERE (l_detalleresultado_comentario.`Id_Recepcion` ='" + idRecepcion + "' AND `Id_Procedimiento` ='" + idProcedimiento + "' AND l_detalleresultado_comentario.`Estado`=1\n) ORDER BY l_detalleresultado_comentario.`Orden` ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ImplementacionReportesDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                RDetalleResultadoComentarioProcedimiento g = new RDetalleResultadoComentarioProcedimiento();
                g.setDescripcionComentrario(rs.getString("Descripcion"));
                return g;
            }
        };
        List<RDetalleResultadoComentarioProcedimiento> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO
    public List<RDetalleExamenesPendientes> detallePendientes(String idRecepcion) {
        String xsql = "SELECT\n\t`g_procedimiento`.`Nbre` ,\n\tDATE_FORMAT(`l_recepcion`.`FechaRecep` , '%d-%m-%Y') AS NFechaR,\n\tDATE_FORMAT(ADDDATE(`l_recepcion`.`FechaRecep` , INTERVAL `g_procedimiento`.`NDiasR` DAY), '%d-%m-%Y') AS NFecha\nFROM\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n\t(`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nWHERE\n\t(`l_recepcion`.`Id` = " + idRecepcion + "\n\t\tAND `l_detallerecepcion`.`Resultado` = 0)\nORDER BY\n\t`g_procedimiento`.`Nbre`;";
        System.out.println("" + xsql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ImplementacionReportesDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                RDetalleExamenesPendientes g = new RDetalleExamenesPendientes();
                g.setNombreProcedimiento(rs.getString("Nbre"));
                g.setNFechaRecepcion(rs.getString("NFechaR"));
                g.setNFechaEntrega(rs.getString("NFecha"));
                return g;
            }
        };
        List<RDetalleExamenesPendientes> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO
    public REncabezadoResultadoDTO detalleEncabezadoResultadoCorreo(String idRecepcion) {
        String xsql = "SELECT\n    `l_recepcion`.`Id` AS idRecepcion\n    , CAST(LPAD(l_resultados.Id_Recepcion,10,'0') AS CHAR) AS `nRecepcion`\n    , date_format(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') AS fechaRecep\n    , DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%h:%i:%s %p') AS horaRecep\n    , `g_usuario`.`NoHistoria` AS nHistoria \n    , CONCAT(g_persona.Id_TipoIdentificacion,'-', g_persona.NoDocumento) AS `nDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ',`g_persona`.`Nombre1` ,' ',`g_persona`.`Nombre2`) AS `nUsuario`\n    , CONCAT(`Devuelve_Edad_2F`(g_persona.`FechaNac`,`l_recepcion`.`FechaRecep`), ' ', `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`,`l_recepcion`.`FechaRecep`) ) AS `edad`\n    , `g_persona`.`Id_Sexo` AS idSexo, date_format(g_persona.FechaNac,'%d-%m-%Y') as fechaNacimiento\n    , IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`=''), NULL, IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`=''), `g_persona`.`Telefono`, IF((`g_persona`.`Telefono`='' && `g_persona`.`Movil`<>''), `g_persona`.`Movil`, IF((`g_persona`.`Telefono`<>'' && `g_persona`.`Movil`<>''), CONCAT(`g_persona`.`Movil`, ' - ',`g_persona`.`Telefono`), NULL)))) AS `telefono`\n    , `g_empresa`.`Nbre` AS `nEmpresa`\n    , `f_empresacontxconvenio`.`Nbre` AS `nEmpresaConvenio`,\n    IFNULL(d_ips.`NEmpresa`,'') AS nIps,\nIFNULL(d_ips.`Telefono`,'') AS nTelefonoIps,\nIF(d_ips.`Direccion` IS NULL,'',d_ips.`Direccion`) AS direccionIps,\nIF(d_ips.`Direccion2` IS NULL,'',d_ips.`Direccion2`) AS direccionIps2,\nIFNULL(d_ips.`TipoIdEmpresa`,'') AS tipoDocIps,\nIFNULL(d_ips.`IdConcatenado`,'') AS documentoIps,\nIF(d_ips.`Eslogan` IS NULL,'',d_ips.`Eslogan`)  AS esloganIps,\nIFNULL(d_ips.`Logo`,'') AS logoIps,\nIFNULL(d_ips.`LogoC`,'') AS logoCIps\n, g_sedes.`Nbre` AS sede\n,IF(d_ips.UrlLogoSuperS ='', NULL,d_ips.UrlLogoSuperS) AS urlLogoSuperS\n , CONCAT(`profesional_envia`.`Apellido1` ,' ', `profesional_envia`.`Apellido2` ,' ',`profesional_envia`.`Nombre1` ,' ',`profesional_envia`.`Nombre2`) AS `profesional_Envia`\n, IF(l_recepcion.`Peso`=0,NULL, CONCAT('Peso : ',l_recepcion.`Peso`)) AS Peso, IF(l_recepcion.`Talla`=0,NULL, CONCAT('Talla : ',l_recepcion.`Talla`)) AS Talla, IF(l_recepcion.`Imc`=0,NULL, CONCAT('Imc : ',l_recepcion.`Imc`)) AS Imc, IF(l_recepcion.`PAbdominal`=0,NULL, CONCAT('Perímetro Abdominal : ',l_recepcion.`PAbdominal`)) AS PAbdominal, IF(l_recepcion.`SCorporal`=0,NULL, CONCAT('Superficie Corporal : ',l_recepcion.`SCorporal`)) AS SCorporal\n, `d_ips`.`NMunicipio` , `d_ips`.`NDepartamento`, `g_municipio`.`Nbre` AS `MunicipioU`, `ingreso`.`NoAutorizacion`, g_tipoatencion.Nbre as tipoServicio, empresaEps.`Nbre`  nombreEps\n, d_ips.`labCoord`\n, d_ips.`firmaLabCoord`\nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `f_ordenes` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_tipoatencion` \n        ON (`g_tipoatencion`.`Id` = `ingreso`.`Id_TipoAtencion`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`) INNER JOIN  `g_empresa` empresaEps\n        ON (`empresaEps`.`Id` = `g_usuario`.Id_EmpresaCont ) \n    INNER JOIN  `d_ips` \n        ON (`d_ips`.`Id` = `f_empresacontxconvenio`.`Id_GIps`)\n    INNER JOIN  `g_sedes`\n        ON (`g_sedes`.`Id` = `ingreso`.`Id_Sede`)\n    INNER JOIN  `g_persona` profesional_envia\n        ON (ingreso.`Id_Profesional` = `profesional_envia`.`Id`) \nWHERE (l_resultados.Id_Recepcion ='" + idRecepcion + "'\n    AND l_resultados.Estado =0 AND l_detalleresultado.`Validado`=1 \n    AND  l_detalleresultado.Estado=1 and g_procedimiento.`exportablePorCorreo`=1 \n  \n    )\nGROUP BY `l_recepcion`.`Id`;";
        System.out.println("" + xsql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ImplementacionReportesDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                REncabezadoResultadoDTO g = new REncabezadoResultadoDTO();
                g.setNombreEps(rs.getString("nombreEps"));
                g.setIdRecepcion(rs.getString("idRecepcion"));
                g.setNumeroRecepcionT(rs.getString("nRecepcion"));
                g.setFechaRecep(rs.getString("fechaRecep"));
                g.setHoraRecep(rs.getString("horaRecep"));
                g.setNumeroHistoria(rs.getString("nHistoria"));
                g.setNumeroDocumento(rs.getString("nDocumento"));
                g.setNombreUsuario(rs.getString("nUsuario"));
                g.setEdad(rs.getString("edad"));
                g.setIdSexo(rs.getString("idSexo"));
                g.setTelefono(rs.getString("telefono"));
                g.setNombreEmpresa(rs.getString("nEmpresa"));
                g.setNombreEmpresaConvenio(rs.getString("nEmpresaConvenio"));
                g.setNombreIps(rs.getString("nIps"));
                g.setNumeroTelefonoIps(rs.getString("nTelefonoIps"));
                g.setDireccionIps(rs.getString("direccionIps"));
                g.setDireccionIps2(rs.getString("direccionIps2"));
                g.setTipoDocIps(rs.getString("tipoDocIps"));
                g.setDocumentoIps(rs.getString("documentoIps"));
                g.setEsloganIps(rs.getString("esloganIps"));
                g.setLogoIps(rs.getString("logoIps"));
                g.setLogoCIps(rs.getString("logoCIps"));
                g.setSede(rs.getString("sede"));
                g.setUrlLogoSuperS(rs.getString("urlLogoSuperS"));
                g.setProfesional_Solicita(rs.getString("profesional_Envia"));
                g.setPeso(rs.getString("Peso"));
                g.setTalla(rs.getString("Talla"));
                g.setImc(rs.getString("Imc"));
                g.setPerimetroAbdominal(rs.getString("PAbdominal"));
                g.setSuperficieCorporal(rs.getString("SCorporal"));
                g.setMunicipioIps(rs.getString("NMunicipio"));
                g.setDepartamentoIps(rs.getString("NDepartamento"));
                g.setMunicipioUsuario(rs.getString("MunicipioU"));
                g.setNumeroAutorizacion(rs.getString("NoAutorizacion"));
                g.setTipoServicio(rs.getString("tipoServicio"));
                g.setFechaNacimiento(rs.getString("fechaNacimiento"));
                g.setUsuarioImprime(Principal.usuarioSistemaDTO.getNombreUsuario());
                g.setLabCoord(rs.getString("labCoord"));
                g.setFirmaLabCoord(rs.getString("firmaLabCoord"));
                g.setListDetalle((List) null);
                return g;
            }
        };
        List<REncabezadoResultadoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override // com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO
    public List<RDetalleResultadoDTO> detalleResultadoCorreo(String idRecepcion, String idProcedimientos) {
        String xsql;
        if (idProcedimientos.equals("")) {
            xsql = "SELECT\n    `l_resultados`.`Id_Recepcion` AS idRecepcion\n    , `l_areas`.`Id` AS `idArea`\n    , `l_areas`.`Nbre` AS `nArea`\n    , `g_procedimiento`.`Id` AS `idProcedimiento`\n    , `g_procedimiento`.`Nbre` AS `nProcedimiento`\n    , `l_protocolos`.`Id` AS `idProtocolo`\n    ,  IF(l_protocolos.`ResultadoUnificado`=0, `l_protocolos`.`Nbre`, NULL) AS `nProtocolo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VrNumerico`, NULL) AS `vResultado`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`Unidad`, NULL) AS `vUnidad`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VReferencia1`, NULL) AS `vMinimo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VReferencia2`, NULL) AS `vMaximo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,NULL, CONCAT(`l_protocolos`.`Nbre`, '\n', `l_detalleresultado`.`VrNumerico`))vResultadoUnificado\n    ,  IF(l_detalleresultado.`Observacion`='',NULL,CONCAT('OBSERVACIÓN : ',l_detalleresultado.`Observacion`)) AS `observacionProtocolo`\n    , IF(l_detalleresultado.`Alterado`=1, '*','') AS `rAlterado`\n    , `l_tipo_metodo`.`Nbre` AS `nMetodo`\n    , CONCAT(`Persona_ProfesionalGraba`.`Apellido1` ,' ', `Persona_ProfesionalGraba`.`Apellido2`,' ',`Persona_ProfesionalGraba`.`Nombre1`,' ',`Persona_ProfesionalGraba`.`Nombre2`) AS `profesional_Graba`\n    , `Especialidad_Graba`.`Nbre` AS `especialidad_Graba`\n    , `Profesional_Graba`.`DireccionF` AS `url_FirmaGraba`\n    , Profesional_Graba.`Tarjeta` AS `tajetaProfesionalGraba`\n    , CONCAT(`Persona_Profesional_Valida`.`Apellido1` ,' ', `Persona_Profesional_Valida`.`Apellido2`,' ',`Persona_Profesional_Valida`.`Nombre1`,' ',`Persona_Profesional_Valida`.`Nombre2`) AS `profesional_Valida`\n    , `g_especialidad_1`.`Nbre` AS `especialidad_Valida`\n    , Profesional_Valida.`DireccionF` AS `url_FirmaValida`\n    , Profesional_Valida.`Tarjeta` AS `tajetaProfesionalValida`\n    , l_resultados.`Fecha`   as  `fechaResult` , IF(l_tipo_encabezado.Nbre='NO APLICA',NULL,l_tipo_encabezado.Nbre) AS encabezado_Protocolo\n,IF(l_protocolos.`ResultadoUnificado`=0,IF(`l_detalleresultado`.`Unidad`='',`l_detalleresultado`.`VrNumerico`, CONCAT(`l_detalleresultado`.`VrNumerico`,' ', l_detalleresultado.`Unidad`)), NULL) valorResultadoConcatenado\n    ,IF(l_protocolos.`ResultadoUnificado`=0,IF((`l_detalleresultado`.`VReferencia1`='' AND `l_detalleresultado`.`VReferencia2`=''),NULL,\n     IF((`l_detalleresultado`.`VReferencia1`<>'' AND `l_detalleresultado`.`VReferencia2`<>''), CONCAT (`l_detalleresultado`.`VReferencia1`, ' - ' ,`l_detalleresultado`.`VReferencia2`),\n     IF((`l_detalleresultado`.`VReferencia1`<>'' AND `l_detalleresultado`.`VReferencia2`=''), `l_detalleresultado`.`VReferencia1`, `l_detalleresultado`.`VReferencia2`))), NULL) valorRefenciaConcatenado \n   ,`l_protocoloxprocedimiento`.`Id` AS idProtocoloxProcedimiento\n   , l_detallerecepcion.fechaMuestra, l_detallerecepcion.FechaValidado as fechaValidado \nFROM\n     `l_resultados` \n    INNER JOIN  `l_detalleresultado`\n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    inner join l_detallerecepcion  on (l_detallerecepcion.Id_Recepcion=l_resultados.Id_Recepcion) and (l_detallerecepcion.Id_Procedim=l_detalleresultado.Id_Procedimiento)  \n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `g_profesional` AS `Profesional_Graba` \n        ON (`Profesional_Graba`.`Id_Persona` = `l_detalleresultado`.`Bacteriologo`)\n    INNER JOIN  `g_especialidad` AS `Especialidad_Graba` \n        ON (`Especialidad_Graba`.`Id` = `l_detalleresultado`.`Id_Especialidad`)\n    LEFT JOIN  `g_profesional` AS `Profesional_Valida`\n        ON (`l_detalleresultado`.`IdProfesionalV` = `Profesional_Valida`.`Id_Persona`)\n    LEFT JOIN  `g_especialidad` AS `g_especialidad_1`\n        ON (`l_detalleresultado`.`IdEspecialidadV` = `g_especialidad_1`.`Id`)\n    INNER JOIN  `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN  `l_areas` \n        ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\n INNER JOIN `l_tipo_encabezado` \n         ON (`l_tipo_encabezado`.`Id` = `l_protocolos`.`Id_tencabezado`)\n    INNER JOIN  `l_tipo_metodo` \n        ON (`g_procedimiento`.`Id_TipoMetodo` = `l_tipo_metodo`.`Id`)\n    INNER JOIN  `g_persona` AS `Persona_ProfesionalGraba` \n        ON (`Persona_ProfesionalGraba`.`Id` = `Profesional_Graba`.`Id_Persona`)\n    LEFT JOIN  `g_persona` AS `Persona_Profesional_Valida` \n        ON (`Persona_Profesional_Valida`.`Id` = `Profesional_Valida`.`Id_Persona`)\nWHERE (`l_resultados`.`Id_Recepcion` ='" + idRecepcion + "' \n AND l_resultados.Estado =0 AND `l_detalleresultado`.`Validado` =1 AND g_procedimiento.`exportablePorCorreo`=1 \n    AND  l_detalleresultado.Estado=1 \n    )\nORDER BY  g_procedimiento.`NOrdenI` ASC, l_protocoloxprocedimiento.`Orden` ASC";
        } else {
            xsql = "SELECT\n    `l_resultados`.`Id_Recepcion` AS idRecepcion\n    , `l_areas`.`Id` AS `idArea`\n    , `l_areas`.`Nbre` AS `nArea`\n    , `g_procedimiento`.`Id` AS `idProcedimiento`\n    , `g_procedimiento`.`Nbre` AS `nProcedimiento`\n    , `l_protocolos`.`Id` AS `idProtocolo`\n    ,  IF(l_protocolos.`ResultadoUnificado`=0, `l_protocolos`.`Nbre`, NULL) AS `nProtocolo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VrNumerico`, NULL) AS `vResultado`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`Unidad`, NULL) AS `vUnidad`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VReferencia1`, NULL) AS `vMinimo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,`l_detalleresultado`.`VReferencia2`, NULL) AS `vMaximo`\n    , IF(l_protocolos.`ResultadoUnificado`=0,NULL, CONCAT(`l_protocolos`.`Nbre`, '\n', `l_detalleresultado`.`VrNumerico`))vResultadoUnificado\n    ,  IF(l_detalleresultado.`Observacion`='',NULL,CONCAT('OBSERVACIÓN : ',l_detalleresultado.`Observacion`)) AS `observacionProtocolo`\n    , IF(l_detalleresultado.`Alterado`=1, '***','') AS `rAlterado`\n    , `l_tipo_metodo`.`Nbre` AS `nMetodo`\n    , CONCAT(`Persona_ProfesionalGraba`.`Apellido1` ,' ', `Persona_ProfesionalGraba`.`Apellido2`,' ',`Persona_ProfesionalGraba`.`Nombre1`,' ',`Persona_ProfesionalGraba`.`Nombre2`) AS `profesional_Graba`\n    , `Especialidad_Graba`.`Nbre` AS `especialidad_Graba`\n    , `Profesional_Graba`.`DireccionF` AS `url_FirmaGraba`\n    , Profesional_Graba.`Tarjeta` AS `tajetaProfesionalGraba`\n    , CONCAT(`Persona_Profesional_Valida`.`Apellido1` ,' ', `Persona_Profesional_Valida`.`Apellido2`,' ',`Persona_Profesional_Valida`.`Nombre1`,' ',`Persona_Profesional_Valida`.`Nombre2`) AS `profesional_Valida`\n    , `g_especialidad_1`.`Nbre` AS `especialidad_Valida`\n    , Profesional_Valida.`DireccionF` AS `url_FirmaValida`\n    , Profesional_Valida.`Tarjeta` AS `tajetaProfesionalValida`\n    , l_resultados.`Fecha`   as  `fechaResult` , IF(l_tipo_encabezado.Nbre='NO APLICA',NULL,l_tipo_encabezado.Nbre) AS encabezado_Protocolo\n,IF(l_protocolos.`ResultadoUnificado`=0,IF(`l_detalleresultado`.`Unidad`='',`l_detalleresultado`.`VrNumerico`, CONCAT(`l_detalleresultado`.`VrNumerico`,' ', l_detalleresultado.`Unidad`)), NULL) valorResultadoConcatenado\n    ,IF(l_protocolos.`ResultadoUnificado`=0,IF((`l_detalleresultado`.`VReferencia1`='' AND `l_detalleresultado`.`VReferencia2`=''),NULL,\n     IF((`l_detalleresultado`.`VReferencia1`<>'' AND `l_detalleresultado`.`VReferencia2`<>''), CONCAT (`l_detalleresultado`.`VReferencia1`, ' - ' ,`l_detalleresultado`.`VReferencia2`),\n     IF((`l_detalleresultado`.`VReferencia1`<>'' AND `l_detalleresultado`.`VReferencia2`=''), `l_detalleresultado`.`VReferencia1`, `l_detalleresultado`.`VReferencia2`))), NULL) valorRefenciaConcatenado    ,`l_protocoloxprocedimiento`.`Id` AS idProtocoloxProcedimiento\n   , l_detallerecepcion.fechaMuestra, l_detallerecepcion.FechaValidado as fechaValidado \nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    inner join l_detallerecepcion  on (l_detallerecepcion.Id_Recepcion=l_resultados.Id_Recepcion) and (l_detallerecepcion.Id_Procedim=l_detalleresultado.Id_Procedimiento)  \n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `g_profesional` AS `Profesional_Graba` \n        ON (`Profesional_Graba`.`Id_Persona` = `l_detalleresultado`.`Bacteriologo`)\n    INNER JOIN  `g_especialidad` AS `Especialidad_Graba` \n        ON (`Especialidad_Graba`.`Id` = `l_detalleresultado`.`Id_Especialidad`)\n    LEFT JOIN  `g_profesional` AS `Profesional_Valida`\n        ON (`l_detalleresultado`.`IdProfesionalV` = `Profesional_Valida`.`Id_Persona`)\n    LEFT JOIN  `g_especialidad` AS `g_especialidad_1`\n        ON (`l_detalleresultado`.`IdEspecialidadV` = `g_especialidad_1`.`Id`)\n    INNER JOIN  `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN  `l_areas` \n        ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\n INNER JOIN `l_tipo_encabezado` \n         ON (`l_tipo_encabezado`.`Id` = `l_protocolos`.`Id_tencabezado`)\n    INNER JOIN  `l_tipo_metodo` \n        ON (`g_procedimiento`.`Id_TipoMetodo` = `l_tipo_metodo`.`Id`)\n    INNER JOIN  `g_persona` AS `Persona_ProfesionalGraba` \n        ON (`Persona_ProfesionalGraba`.`Id` = `Profesional_Graba`.`Id_Persona`)\n    LEFT JOIN  `g_persona` AS `Persona_Profesional_Valida` \n        ON (`Persona_Profesional_Valida`.`Id` = `Profesional_Valida`.`Id_Persona`)\nWHERE ((`l_resultados`.`Id_Recepcion` ='" + idRecepcion + "' AND `g_procedimiento`.`Id` IN(" + idProcedimientos + "))\n AND l_resultados.Estado =0 AND `l_detalleresultado`.`Validado` =1\n    AND  l_detalleresultado.Estado=1 AND g_procedimiento.`exportablePorCorreo`=1 \n    )\nORDER BY  g_procedimiento.`NOrdenI` ASC, l_protocoloxprocedimiento.`Orden` ASC";
        }
        System.out.println("" + xsql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ImplementacionReportesDAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                RDetalleResultadoDTO g = new RDetalleResultadoDTO();
                g.setIdRecepcion(Long.valueOf(rs.getLong("idRecepcion")));
                g.setIdArea(Long.valueOf(rs.getLong("idArea")));
                g.setNombreArea(rs.getString("nArea"));
                g.setIdProcedimiento(Long.valueOf(rs.getLong("idProcedimiento")));
                g.setNombreProcedimiento(rs.getString("nProcedimiento"));
                g.setIdProtocolo(Long.valueOf(rs.getLong("idProtocolo")));
                g.setNombreProtocolo(rs.getString("nProtocolo"));
                g.setValorResultado(rs.getString("vResultado"));
                g.setResultadoUnificado(rs.getString("vResultadoUnificado"));
                g.setValorUnidad(rs.getString("vUnidad"));
                g.setValorMinimo(rs.getString("vMinimo"));
                g.setValorMaximo(rs.getString("vMaximo"));
                g.setObservacionProtocolo(rs.getString("observacionProtocolo"));
                g.setResultadoAlterado(rs.getString("rAlterado"));
                g.setNombreMetodo(rs.getString("nMetodo"));
                g.setProfesional_Graba(rs.getString("profesional_Graba"));
                g.setEspecialidad_Graba(rs.getString("especialidad_Graba"));
                g.setUrl_FirmaGraba(rs.getString("url_FirmaGraba"));
                g.setTajetaProfesionalGraba(rs.getString("tajetaProfesionalGraba"));
                g.setProfesional_Valida(rs.getString("profesional_Valida"));
                g.setEspecialidad_Valida(rs.getString("especialidad_Valida"));
                g.setUrl_FirmaValida(rs.getString("url_FirmaValida"));
                g.setTajetaProfesionalValida(rs.getString("tajetaProfesionalValida"));
                g.setFechaResultado(rs.getString("fechaResult"));
                g.setEncabezadoProtocolo(rs.getString("encabezado_Protocolo"));
                g.setValorRefenciaConcatenado(rs.getString("valorRefenciaConcatenado"));
                g.setValorResultadoConcatenado(rs.getString("valorResultadoConcatenado"));
                g.setDetalleHistorico(ImplementacionReportesDAOImpl.this.detalleHistoricoProtocolo(rs.getString("idRecepcion"), rs.getString("idProtocoloxProcedimiento")));
                g.setDetalleComentarioProcedimiento(ImplementacionReportesDAOImpl.this.detalleComentarioProcedimento(rs.getString("idProcedimiento"), rs.getString("idRecepcion")));
                g.setFechaMuestra(rs.getString("fechaMuestra"));
                return g;
            }
        };
        List<RDetalleResultadoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO
    public List<resourceDTO> detalleHistograma(String idProcedimiento, String idRecepcion) {
        List<resourceDTO> list = new ArrayList<>();
        String ubicacion = this.metodos.mRutaSoporte("histograma");
        if (ubicacion == null || ubicacion.isEmpty()) {
            return Collections.emptyList();
        }
        File folder = new File(ubicacion + idRecepcion + this.metodos.getBarra() + idProcedimiento + this.metodos.getBarra());
        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile() && !file.isHidden() && isImage(file.getName())) {
                    System.out.println(file.getAbsolutePath());
                    resourceDTO dTO = new resourceDTO();
                    dTO.setValue(file.getAbsolutePath());
                    list.add(dTO);
                }
            }
        }
        return list;
    }

    private boolean isImage(String fileName) {
        return fileName.matches(".*\\.(jpg|jpeg|png|gif|bmp)$");
    }
}
