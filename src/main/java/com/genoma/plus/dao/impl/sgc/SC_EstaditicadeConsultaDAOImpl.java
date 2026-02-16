package com.genoma.plus.dao.impl.sgc;

import com.genoma.plus.dao.sgc.SC_EstaditicadeConsulta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/SC_EstaditicadeConsultaDAOImpl.class */
public class SC_EstaditicadeConsultaDAOImpl implements SC_EstaditicadeConsulta {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.SC_EstaditicadeConsulta
    public List<Object[]> informeConsolidadoCitasPyP(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EstaditicadeConsultaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3)};
                return fila;
            }
        };
        String sql = "SELECT\n      `g_empresa`.`Nbre` AS `EPS`\n    , IF(g_especialidad.`Id`=2,g_especialidad.`Nbre`,g_especialidad.`Nbre`) AS especialidad\n    ,SUM(1) AS Cantidad\n    \n      FROM\n    `baseserver`.`g_usuario`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`ingreso`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`g_especialidad`.`Id` IN('1022', '2', '382','3') AND c_clasecita.`Estado`=0 \nAND ingreso.`FechaIngreso`>='" + xFechai + "' AND ingreso.`FechaIngreso`<='" + xFechaf + "'  )GROUP BY `g_empresa`.`Id`,  `g_especialidad`.`Id` ;";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EstaditicadeConsulta
    public List<Object[]> informeConsolidadoCitaEspecialidad(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EstaditicadeConsultaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3)};
                return fila;
            }
        };
        String sql = "SELECT\n      `g_empresa`.`Nbre` AS `EPS`\n    , c_clasecita.Nbre AS Cita\n    , SUM(1) AS Cantidad\nFROM\n    `baseserver`.`g_usuario`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`ingreso`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`g_especialidad`.`Id`IN('1022', '2')AND ingreso.`FechaIngreso`>='" + xFechai + "' AND ingreso.`FechaIngreso`<='" + xFechaf + "' )\n GROUP BY `g_empresa`.`Id` ,  c_clasecita.`Id` ORDER BY `g_empresa`.`Nbre` ASC  ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sgc.SC_EstaditicadeConsulta
    public List<Object[]> informeConsolidadoCitaConsolidados(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SC_EstaditicadeConsultaDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        String sql = "SELECT\n    `g_empresa`.`Nbre`\n    , SUM(1) AS VALOR \nFROM\n    `baseserver`.`c_citas`\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_empresa` \n        ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresa`.`Id`)\nWHERE (`c_citas`.`Asistida` =3 AND c_citas.`Fecha`>='" + xFechai + "' AND c_citas.`Fecha_Cita`<='" + xFechaf + "' ) GROUP BY `g_empresa`.`Id`";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
