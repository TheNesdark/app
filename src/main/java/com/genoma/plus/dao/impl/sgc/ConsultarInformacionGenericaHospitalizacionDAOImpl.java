package com.genoma.plus.dao.impl.sgc;

import com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO;
import com.genoma.plus.dto.sgc.ConsultarInformacionGenericaHospitalizacionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/ConsultarInformacionGenericaHospitalizacionDAOImpl.class */
public class ConsultarInformacionGenericaHospitalizacionDAOImpl implements ConsultarInformacionGenericaHospitalizacionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mTotalDiasHospitalizado(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[20];
                for (int i = 0; i < 20; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `ingreso`.`Id` AS `idIngreso`\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdent`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo` AS `sexo`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `ingreso`.`DxIngreso`\n    , `ingreso`.`FechaIngreso` \n    , `ingreso`.`HoraIngreso`\n    , `h_egreso_atencion`.`FechaSO` AS fechaEgreso\n    , `h_egreso_atencion`.`HoraSO` AS horaEgreso\n    , DATEDIFF(`h_egreso_atencion`.`FechaSO` , `ingreso`.`FechaIngreso`) AS totalDiasHospitalizado\n    , TIMESTAMPDIFF(HOUR,CONCAT(`ingreso`.`FechaIngreso` ,' ',`ingreso`.`HoraIngreso`),CONCAT(`h_egreso_atencion`.`FechaSO`,' ',`h_egreso_atencion`.`HoraSO`)) AS totalHorasHospitalizacion\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n     , `f_empresacontxconvenio`.`Nbre` AS `convenio`\n    , `h_egreso_atencion`.`Id_Atencion`\n    FROM  `ingreso`\n    INNER JOIN  `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_egreso_atencion` ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `profesional1` ON (`profesional1`.`Id_Persona` = `h_egreso_atencion`.`Id_Profesional`)\nWHERE (`ingreso`.`Id_MotivoAnulacion` =1\n    AND `ingreso`.`Id_TipoAtencion` =2\n    AND `ingreso`.`Egreso_H` =1\n    AND `h_egreso_atencion`.`Id_Atencion`>0\n    AND  `ingreso`.`FechaIngreso` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso`<='" + consultarInformacion.getFechaFinal() + "'\n    ) ORDER BY `ingreso`.`FechaIngreso` ASC;";
        System.out.println("fecha inicio: " + consultarInformacion.getFechaInicio() + " DAOIMPL");
        System.out.println("fecha final: " + consultarInformacion.getFechaFinal() + " DAOIMPL");
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mTotalDiasHospitalizadoFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[19];
                for (int i = 0; i < 19; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `ingreso`.`Id` AS `idIngreso`\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdent`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo` AS `sexo`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `ingreso`.`DxIngreso`\n    , `ingreso`.`FechaIngreso` \n    , `ingreso`.`HoraIngreso`\n    , `h_egreso_atencion`.`FechaSO` AS fechaEgreso\n    , `h_egreso_atencion`.`HoraSO` AS horaEgreso\n    , DATEDIFF(`h_egreso_atencion`.`FechaSO` , `ingreso`.`FechaIngreso`) AS totalDiasHospitalizado\n    , TIMESTAMPDIFF(HOUR,CONCAT(`ingreso`.`FechaIngreso` ,' ',`ingreso`.`HoraIngreso`),CONCAT(`h_egreso_atencion`.`FechaSO`,' ',`h_egreso_atencion`.`HoraSO`)) AS totalHorasHospitalizacion\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , `h_egreso_atencion`.`Id_Atencion`\n    FROM  `ingreso`\n    INNER JOIN  `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_egreso_atencion` ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `profesional1` ON (`profesional1`.`Id_Persona` = `h_egreso_atencion`.`Id_Profesional`)\nWHERE (`ingreso`.`Id_MotivoAnulacion` =1\n    AND `ingreso`.`Id_TipoAtencion` =2\n    AND `ingreso`.`Egreso_H` =1\n    AND `h_egreso_atencion`.`Id_Atencion`>0\n    AND  `ingreso`.`FechaIngreso` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso`<='" + consultarInformacion.getFechaFinal() + "'\n     AND f_empresacontxconvenio.`Id`='" + consultarInformacion.getFiltroCombo() + "'\n    ) ORDER BY `ingreso`.`FechaIngreso` ASC;";
        System.out.println("fecha inicio: " + consultarInformacion.getFechaInicio() + " DAOIMPL");
        System.out.println("fecha final: " + consultarInformacion.getFechaFinal() + " DAOIMPL");
        System.out.println("filto: " + consultarInformacion.getFiltroCombo() + " DAOIMPL");
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mCargarComboTotalDiasHospitalizado(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        String sql = "SELECT \n     `f_empresacontxconvenio`.`Id`\n     , `f_empresacontxconvenio`.`Nbre` AS `convenio`\n \n    FROM  `ingreso`\n    INNER JOIN  `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `h_egreso_atencion` ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `profesional1` ON (`profesional1`.`Id_Persona` = `h_egreso_atencion`.`Id_Profesional`)\nWHERE (`ingreso`.`Id_MotivoAnulacion` =1\n    AND `ingreso`.`Id_TipoAtencion` =2\n    AND `ingreso`.`Egreso_H` =1\n    AND `h_egreso_atencion`.`Id_Atencion`>0\n    AND  `ingreso`.`FechaIngreso` >='" + consultarInformacion.getFechaInicio() + "'\n   AND `ingreso`.`FechaIngreso`<='" + consultarInformacion.getFechaFinal() + "'\n    ) GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre`  ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mInformeDeCamas(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[6];
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = " SELECT \n     `f_camas`.`Id` AS `idCama`\n    ,UCASE(`f_unidadcama`.`Nbre`) AS `unidadCama`\n    ,UCASE(`f_camas`.`Nbre`) AS `cama`\n    , SUM(TIMESTAMPDIFF(HOUR,IF(c.fechaIngresoCama>='" + consultarInformacion.getFechaInicio() + "',c.fechaIngresoCama,'" + consultarInformacion.getFechaInicio() + " 00:00:00'),IF(c.fechaEgresoCama<='" + consultarInformacion.getFechaFinal() + "',c.fechaEgresoCama,'" + consultarInformacion.getFechaFinal() + " 23:59:59'))) AS horasOcu\n    , (TIMESTAMPDIFF(HOUR,'" + consultarInformacion.getFechaInicio() + " 00:00:00','" + consultarInformacion.getFechaFinal() + " 23:59:59')+1)- SUM(TIMESTAMPDIFF(HOUR,IF(c.fechaIngresoCama>='" + consultarInformacion.getFechaInicio() + "',c.fechaIngresoCama,'" + consultarInformacion.getFechaInicio() + " 00:00:00'),IF(c.fechaEgresoCama<='" + consultarInformacion.getFechaFinal() + "',c.fechaEgresoCama,'" + consultarInformacion.getFechaFinal() + " 23:59:59'))) AS horasDeso\n    , IF(f_camas.`Disponible`=0,'DISPONILBE','OCUPADA') AS estadoActual\n    \n FROM\n    `f_camas`\n INNER JOIN `f_unidadcama` ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`)\n LEFT JOIN (SELECT   \n    `h_orden_hospitalizacion_traslado`.`Id` AS `idTraslado`\n    , `h_orden_hospitalizacion_traslado`.`IdOrdenHosp`\n    , `f_camas`.`Id` AS `idCama`\n    , `f_camas`.`Nbre` AS `cama`\n    , `h_orden_hospitalizacion_traslado`.`Fecha_Ingreso` AS `fechaIngresoCama`\n    , `h_orden_hospitalizacion_traslado`.`Fecha_Egreso`\n    , `h_egreso_atencion`.`FechaSO`\n    , `h_egreso_atencion`.`HoraSO`\n    , `ingreso`.`Id` AS `idIngreso`\n    , `ingreso`.`FechaIngreso`\n    , `ingreso`.`Egreso_H`    \n    , IFNULL(`h_orden_hospitalizacion_traslado`.`Fecha_Egreso`,IF(`h_egreso_atencion`.`FechaSO` IS NOT NULL,CONCAT(`h_egreso_atencion`.`FechaSO`,' ',`h_egreso_atencion`.`HoraSO`),NOW())) AS fechaEgresoCama\n   FROM\n    `h_orden_hospitalizacion_traslado`\n   INNER JOIN `h_orden_hospitalizacion` ON (`h_orden_hospitalizacion_traslado`.`IdOrdenHosp` = `h_orden_hospitalizacion`.`Id`)\n   INNER JOIN `f_camas` ON (`h_orden_hospitalizacion_traslado`.`Id_CamaOrigen` = `f_camas`.`Id`)\n   INNER JOIN `h_atencion` ON (`h_orden_hospitalizacion_traslado`.`Id_Atencion` = `h_atencion`.`Id`)\n   INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n   LEFT JOIN `h_egreso_atencion` ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n   WHERE (`ingreso`.`Id_MotivoAnulacion` =1 ) GROUP BY `idTraslado`) c ON ( c.`idCama`=`f_camas`.`Id`)\n WHERE \n     ( c.fechaIngresoCama >='" + consultarInformacion.getFechaInicio() + "' AND c.fechaIngresoCama <='" + consultarInformacion.getFechaFinal() + "' )\n OR  ( c.fechaEgresoCama >='" + consultarInformacion.getFechaInicio() + "' AND c.fechaEgresoCama <='" + consultarInformacion.getFechaFinal() + "')\n GROUP BY `f_camas`.`Id` ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mPacientesIngresados(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[16];
                for (int i = 0; i < 16; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `ingreso`.`Id` AS `idIngreso`\n    , `ingreso`.`FechaIngreso`\n    , `ingreso`.`HoraIngreso`\n    , `ingreso`.`Id_Usuario`\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdent`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , `f_empresacontxconvenio`.`Nbre` AS `Convenio`\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\n    , `g_tipoatencion`.`Nbre` AS `tipoAtencion`\nFROM\n    `ingreso`\n    INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `ingreso`.`Id_Profesional`)\n    INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\nWHERE (`ingreso`.`FechaIngreso` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso` <='" + consultarInformacion.getFechaFinal() + "'\n    AND `ingreso`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`\nORDER BY `ingreso`.`FechaIngreso` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mPacientesIngresadosFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[17];
                for (int i = 0; i < 17; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `ingreso`.`Id` AS `idIngreso`\n    , `ingreso`.`FechaIngreso`\n    , `ingreso`.`HoraIngreso`\n    , `ingreso`.`Id_Usuario`\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdent`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    ,`f_empresacontxconvenio`.`Id`\n    , `f_empresacontxconvenio`.`Nbre` AS `Convenio`\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\n    , `g_tipoatencion`.`Nbre` AS `tipoAtencion`\nFROM\n    `ingreso`\n    INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `ingreso`.`Id_Profesional`)\n    INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\nWHERE (`ingreso`.`FechaIngreso` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso` <='" + consultarInformacion.getFechaFinal() + "'\n    AND `f_empresacontxconvenio`.`Id`='" + consultarInformacion.getFiltroCombo() + "'\n    AND `ingreso`.`Estado` =0)\nGROUP BY `ingreso`.`Id_Usuario`\nORDER BY `ingreso`.`FechaIngreso` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mCargarComboPacientesIngresados(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[2];
                for (int i = 0; i < 2; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n      `f_empresacontxconvenio`.`Id`\n    , `f_empresacontxconvenio`.`Nbre` AS `Convenio`\n  FROM    `ingreso`\n    INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `ingreso`.`Id_Profesional`)\n    INNER JOIN `g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\nWHERE (`ingreso`.`FechaIngreso` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso` <='" + consultarInformacion.getFechaFinal() + "'\n    AND `ingreso`.`Estado` =0)\nGROUP BY  `f_empresacontxconvenio`.`Id`\nORDER BY `f_empresacontxconvenio`.`Nbre`  ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mPacientesEgresados(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.8
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[19];
                for (int i = 0; i < 19; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `h_egreso_atencion`.`Id` AS `idEgreso`\n    , `h_egreso_atencion`.`FechaSO` AS fechaEgreso\n    , `h_egreso_atencion`.`HoraSO` AS horaEgreso\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdent`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Id_Sexo` AS `sexo`\n    , `g_persona`.`FechaNac`\n    , `h_egreso_atencion`.`Id_Ingreso`\n    , `h_egreso_atencion`.`Id_Atencion`\n    , `h_egreso_atencion`.`DxP`\n    , `h_egreso_atencion`.`NDxP`\n    , `h_egreso_atencion`.`ObservacionG1`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , f_empresacontxconvenio.`Nbre` AS convenio\nFROM\n    `h_egreso_atencion`\n    INNER JOIN `ingreso` ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `profesional1` ON (`h_egreso_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`)\n    INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN f_empresacontxconvenio ON(ingreso.`Id_EmpresaContxConv`=f_empresacontxconvenio.`Id`)\nWHERE (`h_egreso_atencion`.`Id_MotivoAnulacion` =1\n    AND `h_egreso_atencion`.`FechaSO` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `h_egreso_atencion`.`FechaSO` <='" + consultarInformacion.getFechaFinal() + "')\nGROUP BY `h_egreso_atencion`.`Id_Ingreso` ORDER BY `h_egreso_atencion`.`FechaSO`  ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mPacientesEgresadosFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.9
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[19];
                for (int i = 0; i < 19; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT \n    `h_egreso_atencion`.`Id` AS `idEgreso`\n    , `h_egreso_atencion`.`FechaSO` AS fechaEgreso\n    , `h_egreso_atencion`.`HoraSO` AS horaEgreso\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdent`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Id_Sexo` AS `sexo`\n    , `g_persona`.`FechaNac`\n    , `h_egreso_atencion`.`Id_Ingreso`\n    , `h_egreso_atencion`.`Id_Atencion`\n    , `h_egreso_atencion`.`DxP`\n    , `h_egreso_atencion`.`NDxP`\n    , `h_egreso_atencion`.`ObservacionG1`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , f_empresacontxconvenio.`Nbre` AS convenio\nFROM\n    `h_egreso_atencion`\n    INNER JOIN `ingreso` ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `profesional1` ON (`h_egreso_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`)\n    INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN f_empresacontxconvenio ON(ingreso.`Id_EmpresaContxConv`=f_empresacontxconvenio.`Id`)\nWHERE (`h_egreso_atencion`.`Id_MotivoAnulacion` =1\n    AND `h_egreso_atencion`.`FechaSO` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `h_egreso_atencion`.`FechaSO` <='" + consultarInformacion.getFechaFinal() + "'\n    AND f_empresacontxconvenio.`Id`='" + consultarInformacion.getFiltroCombo() + "'\n    )\nGROUP BY `h_egreso_atencion`.`Id_Ingreso` ORDER BY `h_egreso_atencion`.`FechaSO`  ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mCargarComboPacientesEgresados(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.10
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[2];
                for (int i = 0; i < 2; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    f_empresacontxconvenio.`Id`\n    , f_empresacontxconvenio.`Nbre` AS convenio\nFROM\n    `h_egreso_atencion`\n    INNER JOIN `ingreso` ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `profesional1` ON (`h_egreso_atencion`.`Id_Profesional` = `profesional1`.`Id_Persona`)\n    INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN f_empresacontxconvenio ON(ingreso.`Id_EmpresaContxConv`=f_empresacontxconvenio.`Id`)\nWHERE (`h_egreso_atencion`.`Id_MotivoAnulacion` =1\n    AND `h_egreso_atencion`.`FechaSO` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `h_egreso_atencion`.`FechaSO` <='" + consultarInformacion.getFechaFinal() + "'\n   )\nGROUP BY f_empresacontxconvenio.`Id`ORDER BY f_empresacontxconvenio.`Nbre` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mCitasNoProgramadasConsultaExterna(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.11
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[16];
                for (int i = 0; i < 16; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `c_citasnp`.`Id` AS `idCita`\n    ,`ingreso`.id AS idIngreso\n    , `c_citasnp`.`Fecha_Cita`\n    , `c_citasnp`.`HoraInicial` AS horaCita\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdent`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Id_Sexo` AS `sexo`\n    , `g_persona`.`FechaNac`\n    , `c_clasecita`.`Nbre` AS claseCita\n    , `f_empresacontxconvenio`.`Nbre` AS `convenio`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n FROM  `profesional1`\n    INNER JOIN`c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)\n    INNER JOIN`g_usuario` ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN`c_clasecita` ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN`ingreso` ON (`c_citasnp`.`Id_ingreso` = `ingreso`.`Id`)\n    INNER JOIN`g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN`f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN`g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n WHERE (`c_citasnp`.`Id_Anulada`=0 \n    AND `c_citasnp`.`Fecha_Cita` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `c_citasnp`.`Fecha_Cita` <='" + consultarInformacion.getFechaFinal() + "'\n       )\nORDER BY `c_citasnp`.`Fecha_Cita` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mCitasNoProgramadasConsultaExternaFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.12
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[16];
                for (int i = 0; i < 16; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `c_citasnp`.`Id` AS `idCita`\n    ,`ingreso`.id AS idIngreso\n    , `c_citasnp`.`Fecha_Cita`\n    , `c_citasnp`.`HoraInicial` AS horaCita\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdent`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Id_Sexo` AS `sexo`\n    , `g_persona`.`FechaNac`\n    , `c_clasecita`.`Nbre` AS claseCita\n    , `f_empresacontxconvenio`.`Nbre` AS `convenio`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n FROM  `profesional1`\n    INNER JOIN`c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)\n    INNER JOIN`g_usuario` ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN`c_clasecita` ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN`ingreso` ON (`c_citasnp`.`Id_ingreso` = `ingreso`.`Id`)\n    INNER JOIN`g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN`f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN`g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n WHERE (`c_citasnp`.`Id_Anulada`=0 \n    AND `c_citasnp`.`Fecha_Cita` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `c_citasnp`.`Fecha_Cita` <='" + consultarInformacion.getFechaFinal() + "'\n    AND `f_empresacontxconvenio`.`Id`='" + consultarInformacion.getFiltroCombo() + "'\n       )\nORDER BY `c_citasnp`.`Fecha_Cita` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mCargarComboCitasNoProgramadasConsultaExterna(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.13
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[2];
                for (int i = 0; i < 2; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `f_empresacontxconvenio`.`Id`\n    , `f_empresacontxconvenio`.`Nbre` AS `convenio`\nFROM  `profesional1`\n    INNER JOIN`c_citasnp` ON (`profesional1`.`Id_Persona` = `c_citasnp`.`Id_Profesional`)\n    INNER JOIN`g_usuario` ON (`c_citasnp`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN`c_clasecita` ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN`ingreso` ON (`c_citasnp`.`Id_ingreso` = `ingreso`.`Id`)\n    INNER JOIN`g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN`f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN`g_tipoatencion` ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n WHERE (`c_citasnp`.`Id_Anulada`=0 \n    AND `c_citasnp`.`Fecha_Cita` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `c_citasnp`.`Fecha_Cita` <='" + consultarInformacion.getFechaFinal() + "'\n    )\nGROUP BY  `f_empresacontxconvenio`.`Id`\nORDER BY `f_empresacontxconvenio`.`Nbre` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mCitasProgramadas(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.14
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[15];
                for (int i = 0; i < 15; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n      `c_citas`.`Id` AS `idCita`\n    , `c_citas`.`Fecha_Cita`\n    , `c_clasecita`.`Nbre` AS `claseCita`\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdenti`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo` AS `sexo`\n    , `f_empresacontxconvenio`.`Nbre` AS `convenio`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , `c_citas`.`Id_ingreso`\nFROM `c_citas`\n    INNER JOIN `g_usuario` ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`)\n    INNER JOIN `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`c_citas`.`Fecha_Cita` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `c_citas`.`Fecha_Cita` <='" + consultarInformacion.getFechaFinal() + "'\n    AND `c_citas`.`Id_MotivoDesistida` =1\n    AND `c_citas`.`Id_ingreso`<>0) ORDER BY `c_citas`.`Fecha_Cita` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mCitasProgramadasFiltro(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.15
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[15];
                for (int i = 0; i < 15; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n      `c_citas`.`Id` AS `idCita`\n    , `c_citas`.`Fecha_Cita`\n    , `c_clasecita`.`Nbre` AS `claseCita`\n    , `g_persona`.`Id_TipoIdentificacion` AS `tipoIdenti`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo` AS `sexo`\n    , `f_empresacontxconvenio`.`Nbre` AS `convenio`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\n    , `c_citas`.`Id_ingreso`\n      \nFROM `c_citas`\n    INNER JOIN `g_usuario` ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`)\n    INNER JOIN `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`c_citas`.`Fecha_Cita` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `c_citas`.`Fecha_Cita` <='" + consultarInformacion.getFechaFinal() + "'\n    AND `f_empresacontxconvenio`.`Id`='" + consultarInformacion.getFiltroCombo() + "'\n    AND `c_citas`.`Id_MotivoDesistida` =1\n    AND `c_citas`.`Id_ingreso`<>0) ORDER BY `c_citas`.`Fecha_Cita` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO
    public List<Object[]> mCargarComboCitasProgramadas(ConsultarInformacionGenericaHospitalizacionDTO consultarInformacion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.ConsultarInformacionGenericaHospitalizacionDAOImpl.16
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[2];
                for (int i = 0; i < 2; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `f_empresacontxconvenio`.`Id`\n    , `f_empresacontxconvenio`.`Nbre` \n FROM `c_citas`\n    INNER JOIN `g_usuario` ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`)\n    INNER JOIN `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`c_citas`.`Fecha_Cita` >='" + consultarInformacion.getFechaInicio() + "'\n    AND `c_citas`.`Fecha_Cita` <='" + consultarInformacion.getFechaFinal() + "'\n    AND `c_citas`.`Id_MotivoDesistida` =1\n    AND `c_citas`.`Id_ingreso`<>0) GROUP BY   `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre`  ASC;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
