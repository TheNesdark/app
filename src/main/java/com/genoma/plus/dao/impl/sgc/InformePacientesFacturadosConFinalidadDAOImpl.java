package com.genoma.plus.dao.impl.sgc;

import com.genoma.plus.dao.sgc.InformePacientesFacturadosConFinalidadDAO;
import com.genoma.plus.dto.sgc.InformePacientesFacturadosConFinalidadDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/InformePacientesFacturadosConFinalidadDAOImpl.class */
public class InformePacientesFacturadosConFinalidadDAOImpl implements InformePacientesFacturadosConFinalidadDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.InformePacientesFacturadosConFinalidadDAO
    public List<Object[]> mInformePacientesFacturadosConFinalidadTodos(InformePacientesFacturadosConFinalidadDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformePacientesFacturadosConFinalidadDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[21];
                for (int i = 0; i < 21; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n  `g_persona`.`Id_TipoIdentificacion`,\n  `g_persona`.`NoDocumento`,\n  CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `nombreUsuario`,\n  `g_persona`.`FechaNac`,\n  `CalculaTiempo_AMD_2Fechas` (`g_persona`.`FechaNac`,`ingreso`.`FechaIngreso`) edad,\n  `g_persona`.`Id_Sexo`,\n  f_empresacontxconvenio.`Id` idConvenio,\n  `f_empresacontxconvenio`.`Nbre` AS `nombreEmpresaConvenio`,\n  `ingreso`.`FechaIngreso`,\n  `f_tiposervicio`.`Nbre` AS `NombreServicio`,\n  `g_procedimiento`.`Id` AS `idCodigo`,\n  `g_procedimiento`.`Nbre` AS `nombreProcedimiento`,\n  `f_tipofinprocedimiento`.`Id`,\n  `f_tipofinprocedimiento`.`Nbre` AS `finProcedimiento`,\n  `f_itemordenesproced`.`Cantidad`,\n  IFNULL(c_clasecita.`Nbre`,'SIN ATENCION') claseCita,\n  IFNULL(g_tipoprograma.`Nbre`,'NO APLICA') tipoPrograma,\n  `g_tipoatencion`.`Nbre` AS `tipoATencion`,\n  IFNULL(`f_factura_evento`.`No_FacturaEvento`,0) numeroFactura,\n  IFNULL(`f_factura_capita`.`No_FacturaCapita`,0) numeroOrden,\n  (IFNULL(`f_factura_capita`.`EstaArmada`,0) + IFNULL(`f_factura_evento`.`EstaArmada`,0)) estadoArmada\nFROM\n  `baseserver`.`ingreso`\n  INNER JOIN `baseserver`.`g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `baseserver`.`f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `baseserver`.`g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `baseserver`.`f_ordenes`\n    ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`f_itemordenesproced`\n    ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n  INNER JOIN `baseserver`.`g_procedimiento`\n    ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_tipofinprocedimiento`\n    ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_liquidacion`\n    ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`g_tipoatencion`\n    ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n  INNER JOIN `baseserver`.`f_tiposervicio`\n    ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_evento`\n    ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`h_atencion`\n    ON (h_atencion.`Id_Ingreso` = ingreso.`Id`)\n  LEFT JOIN `c_clasecita`\n    ON (h_atencion.`Id_ClaseCita` = c_clasecita.`Id`)\n  LEFT JOIN `g_tipoprograma`\n    ON (g_tipoprograma.`Id_TipoPrograma` = c_clasecita.`Id_Programa`)\nWHERE (\n    `f_ordenes`.`Estado` = 0\n    AND `ingreso`.`Estado` = 0\n    AND g_tipoatencion.`Id` = '" + dto.getFiltroComboTipoAtencion() + "'\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`FechaIngreso` >= '" + dto.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso` <= '" + dto.getFechaFinal() + "'\n    AND f_empresacontxconvenio.`Id` = '" + dto.getFiltroComboConvenio() + "')\nHAVING estadoArmada = 2;";
        System.out.println("TODOS: ------------------\n" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformePacientesFacturadosConFinalidadDAO
    public List<Object[]> mInformePacientesFacturadosConFinalidadConvenio(InformePacientesFacturadosConFinalidadDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformePacientesFacturadosConFinalidadDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[21];
                for (int i = 0; i < 21; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n  `g_persona`.`Id_TipoIdentificacion`,\n  `g_persona`.`NoDocumento`,\n  CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `nombreUsuario`,\n  `g_persona`.`FechaNac`,\n  `CalculaTiempo_AMD_2Fechas` (`g_persona`.`FechaNac`,`ingreso`.`FechaIngreso`) edad,\n  `g_persona`.`Id_Sexo`,\n  f_empresacontxconvenio.`Id` idConvenio,\n  `f_empresacontxconvenio`.`Nbre` AS `nombreEmpresaConvenio`,\n  `ingreso`.`FechaIngreso`,\n  `f_tiposervicio`.`Nbre` AS `NombreServicio`,\n  `g_procedimiento`.`Id` AS `idCodigo`,\n  `g_procedimiento`.`Nbre` AS `nombreProcedimiento`,\n  `f_tipofinprocedimiento`.`Id`,\n  `f_tipofinprocedimiento`.`Nbre` AS `finProcedimiento`,\n  `f_itemordenesproced`.`Cantidad`,\n  IFNULL(c_clasecita.`Nbre`,'SIN ATENCION') claseCita,\n  IFNULL(g_tipoprograma.`Nbre`,'NO APLICA') tipoPrograma,\n  `g_tipoatencion`.`Nbre` AS `tipoATencion`,\n  IFNULL(`f_factura_evento`.`No_FacturaEvento`,0) numeroFactura,\n  IFNULL(`f_factura_capita`.`No_FacturaCapita`,0) numeroOrden,\n  (IFNULL(`f_factura_capita`.`EstaArmada`,0) + IFNULL(`f_factura_evento`.`EstaArmada`,0)) estadoArmada\nFROM\n  `baseserver`.`ingreso`\n  INNER JOIN `baseserver`.`g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `baseserver`.`f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `baseserver`.`g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `baseserver`.`f_ordenes`\n    ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`f_itemordenesproced`\n    ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n  INNER JOIN `baseserver`.`g_procedimiento`\n    ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_tipofinprocedimiento`\n    ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_liquidacion`\n    ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`g_tipoatencion`\n    ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n  INNER JOIN `baseserver`.`f_tiposervicio`\n    ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_evento`\n    ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`h_atencion`\n    ON (h_atencion.`Id_Ingreso` = ingreso.`Id`)\n  LEFT JOIN `c_clasecita`\n    ON (h_atencion.`Id_ClaseCita` = c_clasecita.`Id`)\n  LEFT JOIN `g_tipoprograma`\n    ON (g_tipoprograma.`Id_TipoPrograma` = c_clasecita.`Id_Programa`)\nWHERE (\n    `f_ordenes`.`Estado` = 0\n    AND `ingreso`.`Estado` = 0\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`FechaIngreso` >= '" + dto.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso` <= '" + dto.getFechaFinal() + "'\n    AND f_empresacontxconvenio.`Id` = '" + dto.getFiltroComboConvenio() + "')\nHAVING estadoArmada = 2;";
        System.out.println("CONVENIO: ------------------\n" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformePacientesFacturadosConFinalidadDAO
    public List<Object[]> mInformePacientesFacturadosConFinalidadTipoAtencion(InformePacientesFacturadosConFinalidadDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformePacientesFacturadosConFinalidadDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[21];
                for (int i = 0; i < 21; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n  `g_persona`.`Id_TipoIdentificacion`,\n  `g_persona`.`NoDocumento`,\n  CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `nombreUsuario`,\n  `g_persona`.`FechaNac`,\n  `CalculaTiempo_AMD_2Fechas` (`g_persona`.`FechaNac`,`ingreso`.`FechaIngreso`) edad,\n  `g_persona`.`Id_Sexo`,\n  f_empresacontxconvenio.`Id` idConvenio,\n  `f_empresacontxconvenio`.`Nbre` AS `nombreEmpresaConvenio`,\n  `ingreso`.`FechaIngreso`,\n  `f_tiposervicio`.`Nbre` AS `NombreServicio`,\n  `g_procedimiento`.`Id` AS `idCodigo`,\n  `g_procedimiento`.`Nbre` AS `nombreProcedimiento`,\n  `f_tipofinprocedimiento`.`Id`,\n  `f_tipofinprocedimiento`.`Nbre` AS `finProcedimiento`,\n  `f_itemordenesproced`.`Cantidad`,\n  IFNULL(c_clasecita.`Nbre`,'SIN ATENCION') claseCita,\n  IFNULL(g_tipoprograma.`Nbre`,'NO APLICA') tipoPrograma,\n  `g_tipoatencion`.`Nbre` AS `tipoATencion`,\n  IFNULL(`f_factura_evento`.`No_FacturaEvento`,0) numeroFactura,\n  IFNULL(`f_factura_capita`.`No_FacturaCapita`,0) numeroOrden,\n  (IFNULL(`f_factura_capita`.`EstaArmada`,0) + IFNULL(`f_factura_evento`.`EstaArmada`,0)) estadoArmada\nFROM\n  `baseserver`.`ingreso`\n  INNER JOIN `baseserver`.`g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `baseserver`.`f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `baseserver`.`g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `baseserver`.`f_ordenes`\n    ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`f_itemordenesproced`\n    ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n  INNER JOIN `baseserver`.`g_procedimiento`\n    ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_tipofinprocedimiento`\n    ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_liquidacion`\n    ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`g_tipoatencion`\n    ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n  INNER JOIN `baseserver`.`f_tiposervicio`\n    ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_evento`\n    ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`h_atencion`\n    ON (h_atencion.`Id_Ingreso` = ingreso.`Id`)\n  LEFT JOIN `c_clasecita`\n    ON (h_atencion.`Id_ClaseCita` = c_clasecita.`Id`)\n  LEFT JOIN `g_tipoprograma`\n    ON (g_tipoprograma.`Id_TipoPrograma` = c_clasecita.`Id_Programa`)\nWHERE (\n    `f_ordenes`.`Estado` = 0\n    AND `ingreso`.`Estado` = 0\n    AND g_tipoatencion.`Id` = '" + dto.getFiltroComboTipoAtencion() + "'\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`FechaIngreso` >= '" + dto.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso` <= '" + dto.getFechaFinal() + "')\nHAVING estadoArmada = 2;";
        System.out.println("TIPO ATENCION: ------------------\n" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformePacientesFacturadosConFinalidadDAO
    public List<Object[]> mInformePacientesFacturadosConFinalidadFecha(InformePacientesFacturadosConFinalidadDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformePacientesFacturadosConFinalidadDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[21];
                for (int i = 0; i < 21; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n  `g_persona`.`Id_TipoIdentificacion`,\n  `g_persona`.`NoDocumento`,\n  CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `nombreUsuario`,\n  `g_persona`.`FechaNac`,\n  `CalculaTiempo_AMD_2Fechas` (`g_persona`.`FechaNac`,`ingreso`.`FechaIngreso`) edad,\n  `g_persona`.`Id_Sexo`,\n  f_empresacontxconvenio.`Id` idConvenio,\n  `f_empresacontxconvenio`.`Nbre` AS `nombreEmpresaConvenio`,\n  `ingreso`.`FechaIngreso`,\n  `f_tiposervicio`.`Nbre` AS `NombreServicio`,\n  `g_procedimiento`.`Id` AS `idCodigo`,\n  `g_procedimiento`.`Nbre` AS `nombreProcedimiento`,\n  `f_tipofinprocedimiento`.`Id`,\n  `f_tipofinprocedimiento`.`Nbre` AS `finProcedimiento`,\n  `f_itemordenesproced`.`Cantidad`,\n  IFNULL(c_clasecita.`Nbre`,'SIN ATENCION') claseCita,\n  IFNULL(g_tipoprograma.`Nbre`,'NO APLICA') tipoPrograma,\n  `g_tipoatencion`.`Nbre` AS `tipoATencion`,\n  IFNULL(`f_factura_evento`.`No_FacturaEvento`,0) numeroFactura,\n  IFNULL(`f_factura_capita`.`No_FacturaCapita`,0) numeroOrden,\n  (IFNULL(`f_factura_capita`.`EstaArmada`,0) + IFNULL(`f_factura_evento`.`EstaArmada`,0)) estadoArmada\nFROM\n  `baseserver`.`ingreso`\n  INNER JOIN `baseserver`.`g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `baseserver`.`f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `baseserver`.`g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `baseserver`.`f_ordenes`\n    ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`f_itemordenesproced`\n    ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n  INNER JOIN `baseserver`.`g_procedimiento`\n    ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_tipofinprocedimiento`\n    ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_liquidacion`\n    ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`g_tipoatencion`\n    ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n  INNER JOIN `baseserver`.`f_tiposervicio`\n    ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_evento`\n    ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`h_atencion`\n    ON (h_atencion.`Id_Ingreso` = ingreso.`Id`)\n  LEFT JOIN `c_clasecita`\n    ON (h_atencion.`Id_ClaseCita` = c_clasecita.`Id`)\n  LEFT JOIN `g_tipoprograma`\n    ON (g_tipoprograma.`Id_TipoPrograma` = c_clasecita.`Id_Programa`)\nWHERE (\n    `f_ordenes`.`Estado` = 0\n    AND `ingreso`.`Estado` = 0\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`FechaIngreso` >= '" + dto.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso` <= '" + dto.getFechaFinal() + "')\nHAVING estadoArmada = 2;";
        System.out.println("FECHA: ------------------\n" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformePacientesFacturadosConFinalidadDAO
    public List<Object[]> mCargarComboConvenio(InformePacientesFacturadosConFinalidadDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformePacientesFacturadosConFinalidadDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[3];
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n  f_empresacontxconvenio.`Id` idConvenio,\n  `f_empresacontxconvenio`.`Nbre` AS `nombreEmpresaConvenio`,\n   (IFNULL(`f_factura_capita`.`EstaArmada`,0) + IFNULL(`f_factura_evento`.`EstaArmada`,0)) estadoArmada\nFROM\n  `baseserver`.`ingreso`\n  INNER JOIN `baseserver`.`g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `baseserver`.`f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `baseserver`.`g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `baseserver`.`f_ordenes`\n    ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`f_itemordenesproced`\n    ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n  INNER JOIN `baseserver`.`g_procedimiento`\n    ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_tipofinprocedimiento`\n    ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_liquidacion`\n    ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`g_tipoatencion`\n    ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n  INNER JOIN `baseserver`.`f_tiposervicio`\n    ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_evento`\n    ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`h_atencion`\n    ON (h_atencion.`Id_Ingreso` = ingreso.`Id`)\n  LEFT JOIN `c_clasecita`\n    ON (h_atencion.`Id_ClaseCita` = c_clasecita.`Id`)\n  LEFT JOIN `g_tipoprograma`\n    ON (g_tipoprograma.`Id_TipoPrograma` = c_clasecita.`Id_Programa`)\nWHERE (\n    `f_ordenes`.`Estado` = 0\n    AND `ingreso`.`Estado` = 0\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`FechaIngreso` >= '" + dto.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso` <= '" + dto.getFechaFinal() + "')\n    GROUP BY f_empresacontxconvenio.`Id`, estadoArmada\n HAVING estadoArmada = 2  ORDER BY `f_empresacontxconvenio`.`Nbre` ASC;";
        System.out.println("cARCAR COMBO CONVENIO: ------------------\n" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.InformePacientesFacturadosConFinalidadDAO
    public List<Object[]> mCargarComboTipoAtencion(InformePacientesFacturadosConFinalidadDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.InformePacientesFacturadosConFinalidadDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[3];
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                return fila;
            }
        };
        String sql = "SELECT\n  `g_tipoatencion`.`Id`,\n  `g_tipoatencion`.`Nbre` AS `tipoATencion`,\n   (IFNULL(`f_factura_capita`.`EstaArmada`,0) + IFNULL(`f_factura_evento`.`EstaArmada`,0)) estadoArmada\nFROM\n  `baseserver`.`ingreso`\n  INNER JOIN `baseserver`.`g_usuario`\n    ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n  INNER JOIN `baseserver`.`f_empresacontxconvenio`\n    ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n  INNER JOIN `baseserver`.`g_persona`\n    ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  INNER JOIN `baseserver`.`f_ordenes`\n    ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`f_itemordenesproced`\n    ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n  INNER JOIN `baseserver`.`g_procedimiento`\n    ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_tipofinprocedimiento`\n    ON (`f_itemordenesproced`.`Id_TipofinProc` = `f_tipofinprocedimiento`.`Id`)\n  INNER JOIN `baseserver`.`f_liquidacion`\n    ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n  INNER JOIN `baseserver`.`g_tipoatencion`\n    ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\n  INNER JOIN `baseserver`.`f_tiposervicio`\n    ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_evento`\n    ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`f_factura_capita`\n    ON (`f_factura_capita`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n  LEFT JOIN `baseserver`.`h_atencion`\n    ON (h_atencion.`Id_Ingreso` = ingreso.`Id`)\n  LEFT JOIN `c_clasecita`\n    ON (h_atencion.`Id_ClaseCita` = c_clasecita.`Id`)\n  LEFT JOIN `g_tipoprograma`\n    ON (g_tipoprograma.`Id_TipoPrograma` = c_clasecita.`Id_Programa`)\nWHERE (\n    `f_ordenes`.`Estado` = 0\n    AND `ingreso`.`Estado` = 0\n    AND `f_liquidacion`.`Estado` = 0\n    AND `ingreso`.`FechaIngreso` >= '" + dto.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso` <= '" + dto.getFechaFinal() + "')\n    GROUP BY `g_tipoatencion`.`Id`, estadoArmada\n   HAVING estadoArmada = 2\n ORDER BY `g_tipoatencion`.`Nbre` ASC;";
        System.out.println("CARGAR COMBO TIPO ATENCION: ------------------\n" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
