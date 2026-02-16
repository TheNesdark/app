package com.genoma.plus.dao.impl.sgc;

import com.genoma.plus.dao.sgc.MedicamentosEntregadosPorEPSDAO;
import com.genoma.plus.dto.sgc.MedicamentosEntregadosPorEPSDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/MedicamentosEntregadosPorEPSDAOImpl.class */
public class MedicamentosEntregadosPorEPSDAOImpl implements MedicamentosEntregadosPorEPSDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.MedicamentosEntregadosPorEPSDAO
    public List<Object[]> medicamentosEntregadosPorEPS(MedicamentosEntregadosPorEPSDTO dto) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.MedicamentosEntregadosPorEPSDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), Long.valueOf(rs.getLong(8)), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), Long.valueOf(rs.getLong(20)), rs.getString(21), rs.getString(22)};
                return fila;
            }
        };
        if (dto.idIPS == 0) {
            sql = "SELECT\n    `g_municipio`.`Nbre` AS `Municipio`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , TIMESTAMPDIFF(YEAR,`g_persona`.`FechaNac`,  `ingreso`.`FechaIngreso`) AS edad\n    , `g_persona`.`Direccion`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Movil`\n    , `g_empresa`.`Nbre` AS `Empresa`\n    , `g_patologia`.`Nbre` AS `Diagnostico`\n    , ' ' AS  Programa_riesgo\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `ingreso`.`FechaIngreso`\n    , CONCAT(`g_ips`.`Identificacion`, ' - ', `g_ips`.`DigitoVerificacion`) AS Nit\n    , `g_ips`.`Nbre` AS `IPS`\n    , `i_suministro`.`Nbre` AS `Medicamento`\n    , `f_itemordenessum`.`Cantidad`\n    , `i_suministro`.`CodigoCUM`\n     , `ingreso`.`Id_TipoAtencion`\nFROM\n    `baseserver`.`g_ips`, \n    `baseserver`.`ingreso`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`ingreso`.`DxIngreso` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`ingreso`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\n    INNER JOIN `baseserver`.`f_ordenes` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`f_itemordenessum` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\nWHERE ( `ingreso`.`FechaIngreso` >='" + dto.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso`<='" + dto.getFechaFin() + "'\n    AND `ingreso`.`Id_TipoAtencion`= 1)\n    GROUP BY  ingreso.`Id`,`f_itemordenessum`.`Id_Suministro`;";
        } else {
            sql = "SELECT\n    `g_municipio`.`Nbre` AS `Municipio`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , TIMESTAMPDIFF(YEAR,`g_persona`.`FechaNac`,  `ingreso`.`FechaIngreso`) AS edad\n    , `g_persona`.`Direccion`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Movil`\n    , `g_empresa`.`Nbre` AS `Empresa`\n    , `g_patologia`.`Nbre` AS `Diagnostico`\n    , ' ' AS  Programa_riesgo\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `ingreso`.`FechaIngreso`\n    , CONCAT(`g_ips`.`Identificacion`, ' - ', `g_ips`.`DigitoVerificacion`) AS Nit\n    , `g_ips`.`Nbre` AS `IPS`\n    , `i_suministro`.`Nbre` AS `Medicamento`\n    , `f_itemordenessum`.`Cantidad`\n    , `i_suministro`.`CodigoCUM`\n     , `ingreso`.`Id_TipoAtencion`\nFROM\n    `baseserver`.`g_ips`, \n    `baseserver`.`ingreso`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`ingreso`.`DxIngreso` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`ingreso`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\n    INNER JOIN `baseserver`.`f_ordenes` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`f_itemordenessum` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\nWHERE ( `ingreso`.`FechaIngreso` >='" + dto.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso`<='" + dto.getFechaFin() + "'\n    AND `g_empresa`.`Id`='" + dto.getIdIPS() + "'\n    AND `ingreso`.`Id_TipoAtencion`= 1)\n    GROUP BY  ingreso.`Id`,`f_itemordenessum`.`Id_Suministro`;";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.MedicamentosEntregadosPorEPSDAO
    public List<Object[]> listarEPS(MedicamentosEntregadosPorEPSDTO dto) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.MedicamentosEntregadosPorEPSDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[22];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                return fila;
            }
        };
        String sql = "SELECT\n    `g_empresa`.`Id`\n    , `g_empresa`.`Nbre` AS `Empresa`\nFROM\n    `baseserver`.`g_ips`, \n    `baseserver`.`ingreso`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`ingreso`.`DxIngreso` = `g_patologia`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`ingreso`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\n    INNER JOIN `baseserver`.`f_ordenes` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`f_itemordenessum` \n        ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\nWHERE ( `ingreso`.`FechaIngreso` >='" + dto.getFechaInicio() + "'\n    AND `ingreso`.`FechaIngreso`<='" + dto.getFechaFin() + "'\n    AND `ingreso`.`Id_TipoAtencion`= 1)\n    GROUP BY `g_empresa`.`Id`;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
