package com.genoma.plus.dao.impl.rrhh;

import com.genoma.plus.dao.rrhh.IContratosPorTrabajadorDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/rrhh/ContratosPorEmpleadoDAOImpl.class */
public class ContratosPorEmpleadoDAOImpl implements IContratosPorTrabajadorDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.rrhh.IContratosPorTrabajadorDAO
    public List<Object[]> listaDeContratosPorTrabajador(String documento) {
        String sql = "SELECT `cc_orden_compra`.`Id`,`g_empresa`.`No_identificacion`, `g_empresa`.`Nbre`, `cc_orden_compra`.`ObjetivoG`,`cc_tipo_documentof`.`Nbre`\n ,`FechaC`,`FechaFin` FROM `cc_orden_compra`\n INNER JOIN `g_empresa` \n ON (`g_empresa`.`Id` = `cc_orden_compra`.`Id_Tercero`) \n INNER JOIN  `cc_tipo_documentof`\n   ON( `cc_tipo_documentof`.`Id` = `cc_orden_compra`.`Id_TipoDocF`)\n WHERE(`g_empresa`.`No_identificacion` = " + documento + " AND `Id_TipoDocF` IN(9,10))";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.rrhh.ContratosPorEmpleadoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)};
                return fila;
            }
        };
        List<Object[]> listaDeContratos = this.jdbcTemplate.query(sql, rowMapper);
        return listaDeContratos;
    }
}
