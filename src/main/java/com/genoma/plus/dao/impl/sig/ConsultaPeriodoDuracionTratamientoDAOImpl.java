package com.genoma.plus.dao.impl.sig;

import com.genoma.plus.dao.sig.ConsultaPeriodoDuracionTratamientoDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/ConsultaPeriodoDuracionTratamientoDAOImpl.class */
public class ConsultaPeriodoDuracionTratamientoDAOImpl implements ConsultaPeriodoDuracionTratamientoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.ConsultaPeriodoDuracionTratamientoDAO
    public List<Object[]> listaInformacion(String fechaInicio, String fechaFin, String idEmpresa, Boolean filtro) {
        String xSql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultaPeriodoDuracionTratamientoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Identificacion"), rs.getString("CodigoOrganismo"), rs.getString("NEntidad"), rs.getString("Id_TipoIdentificacion"), rs.getString("NoDocumento"), rs.getString("Apellido1"), rs.getString("Apellido2"), rs.getString("Nombre1"), rs.getString("Nombre2"), rs.getString("CodigoCUM"), rs.getString("NSuministro"), rs.getString("FechaOrden"), Long.valueOf(rs.getLong("Duracion"))};
                return fila;
            }
        };
        if (filtro.booleanValue()) {
            xSql = "SELECT\n    `g_ips`.`Identificacion`\n    , `g_ips`.`CodigoOrganismo`\n    , `g_ips`.`Nbre` NEntidad\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `i_suministro`.`CodigoCUM`\n    , `i_suministro`.`Nbre` AS `NSuministro`\n    , `h_ordenes`.`FechaOrden`\n    , `h_itemordenessum`.`Duracion`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\nWHERE (`h_ordenes`.`Estado` =0\n    AND `h_ordenes`.`FechaOrden` >='" + fechaInicio + "'\n    AND `h_ordenes`.`FechaOrden` <='" + fechaFin + "'\n    AND `g_empresa`.`Id` ='" + idEmpresa + "')\nORDER BY `h_ordenes`.`FechaOrden` ASC, concat(`g_persona`.`Apellido1`, ' ',`g_persona`.`Apellido2`, ' ',`g_persona`.`Nombre1`, ' ',`g_persona`.`Nombre2`) asc ";
        } else {
            xSql = "SELECT\n    `g_ips`.`Identificacion`\n    , `g_ips`.`CodigoOrganismo`\n    , `g_ips`.`Nbre` NEntidad\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `i_suministro`.`CodigoCUM`\n    , `i_suministro`.`Nbre` AS `NSuministro`\n    , `h_ordenes`.`FechaOrden`\n    , `h_itemordenessum`.`Duracion`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\nWHERE (`h_ordenes`.`Estado` =0\n    AND `h_ordenes`.`FechaOrden` >='" + fechaInicio + "'\n    AND `h_ordenes`.`FechaOrden` <='" + fechaFin + "'\n   )\nORDER BY `h_ordenes`.`FechaOrden` ASC, concat(`g_persona`.`Apellido1`, ' ',`g_persona`.`Apellido2`, ' ',`g_persona`.`Nombre1`, ' ',`g_persona`.`Nombre2`) asc ";
        }
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaPeriodoDuracionTratamientoDAO
    public List<Object[]> listaEmpresa(String fechaInicio, String fechaFin) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultaPeriodoDuracionTratamientoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[3];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                return fila;
            }
        };
        String xSql = "SELECT\n    `g_empresa`.`Id`\n    , `g_empresa`.`Nbre`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN  `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN  `h_ordenes` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `h_itemordenessum` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN  `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN  `g_empresa` \n        ON (`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\nWHERE (h_ordenes.`Estado` =0\n    AND `h_ordenes`.`FechaOrden` >='" + fechaInicio + "'\n    AND `h_ordenes`.`FechaOrden` <='" + fechaFin + "')\nGROUP BY `g_empresa`.`Id`\nORDER BY `g_empresa`.`Nbre` ASC;\n";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaPeriodoDuracionTratamientoDAO
    public List<Object[]> listaInformacion2(String fechaInicio, String fechaFin, String idEmpresa, Boolean filtro) {
        String xSql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultaPeriodoDuracionTratamientoDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Identificacion"), rs.getString("CodigoOrganismo"), rs.getString("NEntidad"), rs.getString("Id_TipoIdentificacion"), rs.getString("NoDocumento"), rs.getString("Apellido1"), rs.getString("Apellido2"), rs.getString("Nombre1"), rs.getString("Nombre2"), rs.getString("FechaNacimiento"), rs.getString("Edad"), rs.getString("Sexo"), rs.getString("Direccion"), rs.getString("MunicipioProcedencia"), rs.getString("Telefono"), rs.getString("tipoAtencion"), rs.getString("fechaDx"), rs.getString("diagnostico"), rs.getString("CodigoCUM"), rs.getString("NSuministro"), rs.getString("FechaOrden"), Long.valueOf(rs.getLong("Duracion")), rs.getString("municipioIps"), rs.getString("dxSaludMental"), rs.getString("fechaIncioT"), rs.getString("suministroMedicamento"), rs.getString("tratamiento"), rs.getString("EnfoqueDiferencial"), rs.getString("Sin_Tratamiento"), rs.getString("Evaluacion_Proc_Ingreso"), rs.getString("Dx_Temprano")};
                return fila;
            }
        };
        if (filtro.booleanValue()) {
            xSql = "select\n\t`g_ips`.`Identificacion` ,\n\t`g_ips`.`CodigoOrganismo` ,\n\t`g_ips`.`Nbre` NEntidad ,\n\t`g_persona`.`Id_TipoIdentificacion` ,\n\t`g_persona`.`NoDocumento` ,\n\t`g_persona`.`Apellido1` ,\n\t`g_persona`.`Apellido2` ,\n\t`g_persona`.`Nombre1` ,\n\t`g_persona`.`Nombre2` ,\n\t g_persona.FechaNac FechaNacimiento,\n\t g_persona.Edad Edad,\n\t g_persona.Id_Sexo Sexo,\n\t g_persona.Direccion,\n\t gm.Nbre MunicipioProcedencia,\n\t g_persona.Telefono,\n\t gt.Nbre  tipoAtencion,\n\t h_atencion.Fecha_Atencion  fechaDx,\n\t gp.Nbre diagnostico,\n\t gmIps.Nbre municipioIps,\n\t`i_suministro`.`CodigoCUM` ,\n\t`i_suministro`.`Nbre` as `NSuministro` ,\n\t`h_ordenes`.`FechaOrden` ,\n\t`h_itemordenessum`.`Duracion`,\n\t'' dxSaludMental,\n\th_atencion.Fecha_Atencion  fechaIncioT,\n\t'' suministroMedicamento,\n\t'' tratamiento,\n\t'' EnfoqueDiferencial,\n\t'' Sin_Tratamiento,\n\t''Evaluacion_Proc_Ingreso,\n\t''Dx_Temprano\nfrom\n\t`h_atencion`\ninner join `ingreso` on\n\t(`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n\tinner join g_tipoatencion gt on\n     (gt.Id= ingreso.Id_TipoAtencion)\n inner join g_patologia gp on \n     (gp.Id = h_atencion.Codigo_Dxp)\ninner join `g_usuario` on\n\t(`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\ninner join `f_empresacontxconvenio` on\n\t(`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\ninner join `g_persona` on\n\t(`g_usuario`.`Id_persona` = `g_persona`.`Id`)\ninner join `g_ips` on\n\t(`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\ninner join `h_ordenes` on\n\t(`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\ninner join `h_itemordenessum` on\n\t(`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\ninner join `i_suministro` on\n\t(`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\ninner join `i_principioactivo` on\n\t(`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n\tinner join g_municipio gm on\n\t(`gm`.`Id` = `g_persona`.Id_Municipio)\ninner join g_municipio gmIps on\n\t(`gmIps`.`Id` = `g_ips`.Id_Municipio)\t\ninner join `g_empresa` on\n\t(`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\nwhere\n\t(`h_ordenes`.`Estado` = 0\n\tand `h_ordenes`.`FechaOrden` >= '" + fechaInicio + "'\n\tand `h_ordenes`.`FechaOrden` <= '" + fechaFin + "'\n\tand `g_empresa`.`Id` = '" + idEmpresa + "')\norder by\n\t`h_ordenes`.`FechaOrden` asc,\n\tconcat(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`, ' ', `g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`) asc";
        } else {
            xSql = "select\n\t`g_ips`.`Identificacion` ,\n\t`g_ips`.`CodigoOrganismo` ,\n\t`g_ips`.`Nbre` NEntidad ,\n\t`g_persona`.`Id_TipoIdentificacion` ,\n\t`g_persona`.`NoDocumento` ,\n\t`g_persona`.`Apellido1` ,\n\t`g_persona`.`Apellido2` ,\n\t`g_persona`.`Nombre1` ,\n\t`g_persona`.`Nombre2` ,\n\t g_persona.FechaNac FechaNacimiento,\n\t g_persona.Edad Edad,\n\t g_persona.Id_Sexo Sexo,\n\t g_persona.Direccion,\n\t gm.Nbre MunicipioProcedencia,\n\t g_persona.Telefono,\n\t gt.Nbre  tipoAtencion,\n\t h_atencion.Fecha_Atencion  fechaDx,\n\t gp.Nbre diagnostico,\n\t gmIps.Nbre municipioIps,\n\t`i_suministro`.`CodigoCUM` ,\n\t`i_suministro`.`Nbre` as `NSuministro` ,\n\t`h_ordenes`.`FechaOrden` ,\n\t`h_itemordenessum`.`Duracion`,\n\t'' dxSaludMental,\n\th_atencion.Fecha_Atencion  fechaIncioT,\n\t'' suministroMedicamento,\n\t'' tratamiento,\n\t'' EnfoqueDiferencial,\n\t'' Sin_Tratamiento,\n\t''Evaluacion_Proc_Ingreso,\n\t''Dx_Temprano\n\t\nfrom\n\t`h_atencion`\ninner join `ingreso` on\n\t(`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\ninner join g_tipoatencion gt on\n     (gt.Id= ingreso.Id_TipoAtencion)\n inner join g_patologia gp on \n     (gp.Id = h_atencion.Codigo_Dxp)\ninner join `g_usuario` on\n\t(`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\ninner join `f_empresacontxconvenio` on\n\t(`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\ninner join `g_persona` on\n\t(`g_usuario`.`Id_persona` = `g_persona`.`Id`)\ninner join `g_ips` on\n\t(`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\ninner join `h_ordenes` on\n\t(`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\ninner join `h_itemordenessum` on\n\t(`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\ninner join `i_suministro` on\n\t(`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\ninner join `i_principioactivo` on\n\t(`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\ninner join g_municipio gm on\n\t(`gm`.`Id` = `g_persona`.Id_Municipio)\n\tinner join g_municipio gmIps on\n\t(`gmIps`.`Id` = `g_ips`.Id_Municipio)\n\tinner join `g_empresa` on\n\t(`g_empresa`.`Id` = `f_empresacontxconvenio`.`Id_EmpresaCont`)\nwhere\n\t(`h_ordenes`.`Estado` = 0\n\tand `h_ordenes`.`FechaOrden` >= '" + fechaInicio + "'\n\tand `h_ordenes`.`FechaOrden` <= '" + fechaFin + "' )\norder by\n\t`h_ordenes`.`FechaOrden` asc,\n\tconcat(`g_persona`.`Apellido1`, ' ', `g_persona`.`Apellido2`, ' ', `g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`) asc";
        }
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
