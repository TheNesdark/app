package com.genoma.plus.dao.impl.sgc;

import com.genoma.plus.dao.sgc.SGC_Informe015OportunidadAtencioDAO;
import com.genoma.plus.dto.sgc.SGC_Informe015OportunidadAtencionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/SGC_Informe015OportunidadAtencionDAOImpl.class */
public class SGC_Informe015OportunidadAtencionDAOImpl implements SGC_Informe015OportunidadAtencioDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.SGC_Informe015OportunidadAtencioDAO
    public List<Object[]> list(SGC_Informe015OportunidadAtencionDTO sGC_Informe015OportunidadAtencionDTO) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_Informe015OportunidadAtencionDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18)};
                return fila;
            }
        };
        String sql = "SELECT\n    `c_citas`.`Id`\n    , CONCAT(`g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`) AS Nombres\n    , CONCAT( `g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`) AS apellidos\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_Sexo`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Direccion`\n    , `g_tipoafiliado`.`Nbre` AS `tipo_afiliado`\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `c_clasecita`.`Nbre` AS `clase de cita`\n    , DATE_FORMAT(`c_citas`.`Fecha`,'%Y-%m-%d') AS FechaAsignacion\n    , `c_citas`.`Fecha_SUsuario`\n    , `c_citas`.`Fecha_Cita`\n    ,  TIMESTAMPDIFF(DAY, `c_citas`.`Fecha`, `c_citas`.`Fecha_Cita`) AS 14_asig_Vs_fecita\n    ,  TIMESTAMPDIFF(DAY, `c_citas`.`Fecha_SUsuario`, `c_citas`.`Fecha_Cita`) AS 15_usuario_Vs_fecita\n    , `g_empresa`.`Nbre`\n    , CONCAT(`g_persona_1`.`Nombre1`, ' ', `g_persona_1`.`Nombre2`, ' ', `g_persona_1`.`Apellido1`, ' ', `g_persona_1`.`Apellido2`) AS NombresMedico\n    \nFROM\n    `baseserver`.`g_usuario`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`c_citas` \n        ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_tipoafiliado` \n        ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`c_citas`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_profesional` \n        ON (`c_citas`.`Id_Profesional` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `baseserver`.`g_persona` AS `g_persona_1`\n        ON (`g_profesional`.`Id_Persona` = `g_persona_1`.`Id`)\nWHERE (`c_citas`.`Fecha_Cita` >= '" + sGC_Informe015OportunidadAtencionDTO.getInicioRangoCita() + "' AND `c_citas`.`Fecha_Cita` <= '" + sGC_Informe015OportunidadAtencionDTO.getFinRangoCita() + "' ) GROUP BY `c_citas`.`Id`;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        System.err.println("SQL: " + sql);
        System.err.println("tamaño lista dentro de impl: " + list.size());
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_Informe015OportunidadAtencioDAO
    public List<Object[]> listarComboEmpresas() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_Informe015OportunidadAtencionDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT    DISTINCT\n`g_empresa`.`Id`,\n`g_empresa`.`Nbre`\nFROM\n    `baseserver`.`g_usuario`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`c_citas` \n        ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_tipoafiliado` \n        ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`c_citas`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_profesional` \n        ON (`c_citas`.`Id_Profesional` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `baseserver`.`g_persona` AS `g_persona_1`\n        ON (`g_profesional`.`Id_Persona` = `g_persona_1`.`Id`)\n  ORDER BY  `g_empresa`.`Nbre`;", mapper);
        System.err.println("SQL combo: SELECT    DISTINCT\n`g_empresa`.`Id`,\n`g_empresa`.`Nbre`\nFROM\n    `baseserver`.`g_usuario`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`c_citas` \n        ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_tipoafiliado` \n        ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`c_citas`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_profesional` \n        ON (`c_citas`.`Id_Profesional` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `baseserver`.`g_persona` AS `g_persona_1`\n        ON (`g_profesional`.`Id_Persona` = `g_persona_1`.`Id`)\n  ORDER BY  `g_empresa`.`Nbre`;");
        System.err.println("tamaño lista dentro de impl combo: " + list.size());
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SGC_Informe015OportunidadAtencioDAO
    public List<Object[]> listarporEmpresa(SGC_Informe015OportunidadAtencionDTO sGC_Informe015OportunidadAtencionDTO) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_Informe015OportunidadAtencionDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18)};
                return fila;
            }
        };
        String sql = "SELECT\n    `c_citas`.`Id`\n    , CONCAT(`g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`) AS Nombres\n    , CONCAT( `g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`) AS apellidos\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_Sexo`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Direccion`\n    , `g_tipoafiliado`.`Nbre` AS `tipo_afiliado`\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `c_clasecita`.`Nbre` AS `clase de cita`\n    , DATE_FORMAT(`c_citas`.`Fecha`,'%Y-%m-%d') AS FechaAsignacion\n    , `c_citas`.`Fecha_SUsuario`\n    , `c_citas`.`Fecha_Cita`\n    ,  TIMESTAMPDIFF(DAY, `c_citas`.`Fecha`, `c_citas`.`Fecha_Cita`) AS 14_asig_Vs_fecita\n    ,  TIMESTAMPDIFF(DAY, `c_citas`.`Fecha_SUsuario`, `c_citas`.`Fecha_Cita`) AS 15_usuario_Vs_fecita\n    , `g_empresa`.`Nbre`\n    , CONCAT(`g_persona_1`.`Nombre1`, ' ', `g_persona_1`.`Nombre2`, ' ', `g_persona_1`.`Apellido1`, ' ', `g_persona_1`.`Apellido2`) AS NombresMedico\n    \nFROM\n    `baseserver`.`g_usuario`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`c_citas` \n        ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_tipoafiliado` \n        ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`c_citas`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_profesional` \n        ON (`c_citas`.`Id_Profesional` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\n    INNER JOIN `baseserver`.`g_persona` AS `g_persona_1`\n        ON (`g_profesional`.`Id_Persona` = `g_persona_1`.`Id`)\nWHERE (`c_citas`.`Fecha_Cita` >= '" + sGC_Informe015OportunidadAtencionDTO.getInicioRangoCita() + "' AND `c_citas`.`Fecha_Cita` <= '" + sGC_Informe015OportunidadAtencionDTO.getFinRangoCita() + "' ) AND `g_empresa`.`Id` = " + sGC_Informe015OportunidadAtencionDTO.getIdEmpresa() + " GROUP BY `c_citas`.`Id`;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        System.err.println("inicio " + sGC_Informe015OportunidadAtencionDTO.getInicioRangoCita() + " fin " + sGC_Informe015OportunidadAtencionDTO.getFinRangoCita() + " idempresa " + sGC_Informe015OportunidadAtencionDTO.getIdEmpresa());
        System.err.println("SQL: " + sql);
        System.err.println("tamaño lista dentro de impl: " + list.size());
        return list;
    }
}
