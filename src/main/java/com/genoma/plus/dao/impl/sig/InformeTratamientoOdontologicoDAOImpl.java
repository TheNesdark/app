package com.genoma.plus.dao.impl.sig;

import com.genoma.plus.dao.sig.InformeTratamientosOdontologicosDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/InformeTratamientoOdontologicoDAOImpl.class */
public class InformeTratamientoOdontologicoDAOImpl implements InformeTratamientosOdontologicosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.InformeTratamientosOdontologicosDAO
    public List<Object[]> mListadoTratamientosOdontologicos(String fechaI, String fechaf, String filtro) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeTratamientoOdontologicoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Documento"), rs.getString("NUsuario"), rs.getString("Id_Sexo"), rs.getString("Edad"), rs.getString("NConvenio"), rs.getString("IdProcedimento"), rs.getString("NProcedimiento"), Long.valueOf(rs.getLong("Cantidad")), rs.getString("FInicio"), rs.getString("Fecha")};
                return fila;
            }
        };
        String xSql = "SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion` ,' ', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(`Devuelve_Edad_2F`(`g_persona`.`FechaNac`,`o_hc_tratamiento`.`FInicio`), ' ', `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`,`o_hc_tratamiento`.`FInicio`)) Edad\n    , `f_empresacontxconvenio`.`Nbre` AS `NConvenio`\n    , `g_procedimiento`.`Id` AS `IdProcedimento`\n    , `g_procedimiento`.`Nbre` AS `NProcedimiento`\n    , `o_hc_tratamiento_procedimiento`.`Cantidad`\n    , `o_hc_tratamiento`.`FInicio`\n    , `o_hc_tratamiento_procedimiento`.`Fecha`, IFNULL(f_liquidacion.`Id`, 0) NLiquidacion\nFROM\n     `o_hc_tratamiento`\n    INNER JOIN  `h_atencion` \n        ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `ingreso`.`Id_Usuario`)\n    INNER JOIN  `o_hc_tratamiento_procedimiento` \n        ON (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` = `o_hc_tratamiento`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `o_hc_tratamiento_procedimiento`.`IdProcedimiento`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    LEFT JOIN  `f_liquidacion`\n        ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) AND (f_liquidacion.`Estado`=0) \nWHERE (`o_hc_tratamiento_procedimiento`.`Id_Ingreso` =0\n    AND `o_hc_tratamiento`.`FInicio` >='" + fechaI + "'\n    AND `o_hc_tratamiento`.`FInicio` <='" + fechaf + "') HAVING NLiquidacion =0";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
