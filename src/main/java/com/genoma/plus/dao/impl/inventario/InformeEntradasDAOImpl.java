package com.genoma.plus.dao.impl.inventario;

import Acceso.Principal;
import com.genoma.plus.dao.inventario.InformeEntradasDAO;
import com.genoma.plus.dto.inventario.InformeEntradasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/inventario/InformeEntradasDAOImpl.class */
public class InformeEntradasDAOImpl implements InformeEntradasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.inventario.InformeEntradasDAO
    public List<InformeEntradasDTO> list(String fechaI, String fechaF) {
        String xsql = "SELECT\n    `i_entradas`.`Id`\n    , `i_entradas`.`FechaEntrada`\n    , `cc_terceros`.`RazonSocialCompleta`\n    , `i_tiposmovimientos`.`Nbre` AS `NTipoMovimiento`\n    , SUM(((((`i_detalleentrada`.`ValorUnitario`*`i_detalleentrada`.`Cantidad`)* `i_detalleentrada`.`Iva`)/100)+(`i_detalleentrada`.`ValorUnitario`*`i_detalleentrada`.`Cantidad`))) AS `Valor`\n    , `i_entradas`.`Estado`\nFROM\n    `cc_terceros`\n    INNER JOIN `i_entradas` \n        ON (`cc_terceros`.`Id` = `i_entradas`.`IdProveedor`)\n    INNER JOIN `i_periodo` \n        ON (`i_entradas`.`Id_Periodo` = `i_periodo`.`Id`)\n    INNER JOIN `i_tiposmovimientos` \n        ON (`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `i_detalleentrada` \n        ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`)\nWHERE (`i_entradas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "' AND  `i_entradas`.`FechaEntrada`>='" + fechaI + "' AND  `i_entradas`.`FechaEntrada`<='" + fechaF + "')\nGROUP BY `i_entradas`.`Id` ORDER BY  `i_entradas`.`FechaEntrada` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.inventario.InformeEntradasDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                InformeEntradasDTO g = new InformeEntradasDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setFecha(rs.getString("FechaEntrada"));
                g.setEmpresa(rs.getString("RazonSocialCompleta"));
                g.setTipoMovimiento(rs.getString("NTipoMovimiento"));
                g.setValor(rs.getDouble("Valor"));
                g.setEstado(rs.getInt("Estado"));
                return g;
            }
        };
        List<InformeEntradasDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
