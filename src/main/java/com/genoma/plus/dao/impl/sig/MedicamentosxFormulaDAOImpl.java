package com.genoma.plus.dao.impl.sig;

import com.genoma.plus.dao.sig.MedicamentosxFormulaDAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/MedicamentosxFormulaDAOImpl.class */
public class MedicamentosxFormulaDAOImpl implements MedicamentosxFormulaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.MedicamentosxFormulaDAO
    public List<Object[]> mListarMedicamentos(String xidTipoFormula, String xEstado) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.MedicamentosxFormulaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[120];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                return fila;
            }
        };
        String xSql = "SELECT\n    `i_suministro`.`Id`\n    , `i_suministro`.`Nbre` AS `NSuministro`\n    , `i_principioactivo`.`Nbre` AS `NPrincipioActivo`\n    , `i_presentacionfarmaceutica`.`Nbre` AS `NPresentacionFarmaceutica`\n    , `i_presentacioncomercial`.`Nbre` AS `NPresentacionComercial`\n    , `i_laboratorio`.`Nbre` AS `NLaboratoiro`\n    , IF(`h_tipoformula_suministro`.`Estado`=0, 'INACTIVO', 'ACTIVO') AS `Estado`\nFROM\n    `h_tipoformula_suministro`\n    INNER JOIN `h_tipoformula` \n        ON (`h_tipoformula_suministro`.`Id_TipoFormula` = `h_tipoformula`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`h_tipoformula_suministro`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n    INNER JOIN `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\nWHERE (`h_tipoformula`.`Id` ='" + xidTipoFormula + "' AND `h_tipoformula_suministro`.`Estado` IN (" + xEstado + "))\nORDER BY `NSuministro` ASC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.MedicamentosxFormulaDAO
    public List<GenericoComboDTO> mListarTipoFormula() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.MedicamentosxFormulaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoComboDTO g = new GenericoComboDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        System.out.println("sql combo--> SELECT\n    `h_tipoformula`.`Id`\n    , `h_tipoformula`.`Nbre`\nFROM\n    `h_tipoformula_suministro`\n    INNER JOIN `h_tipoformula` \n        ON (`h_tipoformula_suministro`.`Id_TipoFormula` = `h_tipoformula`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`h_tipoformula_suministro`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n    INNER JOIN `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\nWHERE (`h_tipoformula_suministro`.`Estado` =1)\nGROUP BY `h_tipoformula`.`Id`\nORDER BY `h_tipoformula`.`Nbre` ASC;");
        List<GenericoComboDTO> list = this.jdbcTemplate.query("SELECT\n    `h_tipoformula`.`Id`\n    , `h_tipoformula`.`Nbre`\nFROM\n    `h_tipoformula_suministro`\n    INNER JOIN `h_tipoformula` \n        ON (`h_tipoformula_suministro`.`Id_TipoFormula` = `h_tipoformula`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`h_tipoformula_suministro`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n    INNER JOIN `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\nWHERE (`h_tipoformula_suministro`.`Estado` =1)\nGROUP BY `h_tipoformula`.`Id`\nORDER BY `h_tipoformula`.`Nbre` ASC;", mapper);
        return list;
    }
}
