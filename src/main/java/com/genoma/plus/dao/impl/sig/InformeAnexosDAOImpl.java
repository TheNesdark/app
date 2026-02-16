package com.genoma.plus.dao.impl.sig;

import com.genoma.plus.dao.sig.InformeAnexosDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/InformeAnexosDAOImpl.class */
public class InformeAnexosDAOImpl implements InformeAnexosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.InformeAnexosDAO
    public List<Object[]> mListadoCompleto(String fechaI, String fechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeAnexosDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Long.valueOf(rs.getLong(5)), rs.getString(6), Integer.valueOf(rs.getInt(7)), rs.getString(8), rs.getString(9), Integer.valueOf(rs.getInt(10)), Long.valueOf(rs.getLong(11))};
                return fila;
            }
        };
        String xSql = "SELECT\n    `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `h_ordenes`.`FechaOrden`\n    , `g_ips`.`Identificacion`\n    , `ingreso`.`Id_CausaExterna`\n    , `g_procedimiento`.`C_Homologado` AS `cups`\n    , `h_itemordenesproced`.`Cantidad`\n    , `h_ordenes`.`NotaHc` AS `justificacion`\n    , `h_atencion`.`Codigo_Dxp` AS `dxPrincipal`\n    , `h_ordenes`.`Estado`\n    , `ingreso`.`Id_TipoAtencion`\nFROM\n    `h_ordenes`\n    INNER JOIN `h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `h_itemordenesproced` \n        ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_procedimiento` \n        ON (`h_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_tipoatencion` \n        ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + fechaI + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + fechaF + "'\n    AND `h_ordenes`.`Estado` =0\n    AND `ingreso`.`Id_TipoAtencion` =1)\nORDER BY `h_ordenes`.`FechaOrden` ASC, `g_persona`.`NoDocumento` ASC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
