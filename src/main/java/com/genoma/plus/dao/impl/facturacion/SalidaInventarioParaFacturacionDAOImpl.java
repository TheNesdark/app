package com.genoma.plus.dao.impl.facturacion;

import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.SalidaInventarioParaFacturacionDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/SalidaInventarioParaFacturacionDAOImpl.class */
public class SalidaInventarioParaFacturacionDAOImpl implements SalidaInventarioParaFacturacionDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.SalidaInventarioParaFacturacionDAO
    public List<Object[]> listadoSalidaInventario(String idSalida) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.SalidaInventarioParaFacturacionDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("FechaSalida"), rs.getString("entidad"), rs.getString("especialidad"), rs.getString("profesional"), rs.getString("idSuministro"), rs.getString("nombreSuministro"), Long.valueOf(rs.getLong("cantidad")), rs.getString("diagnostico"), rs.getString("causaExterna"), rs.getString("estrato")};
                return fila;
            }
        };
        String xSql = "SELECT\n    `i_salidas`.`Id`\n    , `i_salidas`.`FechaSalida`\n    , `f_empresacontxconvenio`.`Nbre` AS `entidad`\n    , `g_especialidad`.`Nbre` AS `especialidad`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `profesional`\n    , `i_suministro`.`Id` idSuministro\n    , `i_suministro`.`Nbre` nombreSuministro, sum(`i_detallesalida`.`CantidadDespachada`) cantidad \n     , IFNULL(ha.Codigo_Dxp, '0000') diagnostico, IFNULL(gc.Nbre, 'Enfermedad General') causaExterna, IFNULL(fe.Nbre,'') estrato\n  \nFROM\n     `i_detallesalida`\n    INNER JOIN  `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    LEFT JOIN  `f_empresacontxconvenio` \n        ON (`f_empresacontxconvenio`.`Id` = `i_salidas`.`Eps`)\n    INNER JOIN  `g_especialidad` \n        ON (`g_especialidad`.`Id` = `i_salidas`.`IdEspecialidad`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `i_salidas`.`IdProfesional`)\n    INNER JOIN  `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    left join h_ordenes ho on (ho.Id=i_salidas.OrdenH) \n    left join h_atencion ha on (ha.Id=ho.Id_Atencion)\n left join ingreso i2 on (i2.Id=ha.Id_Ingreso)\n    left  join g_causaexterna gc on (gc.Id=i2.Id_CausaExterna)\n left join f_estrato fe on (fe.Id=i2.Id_Estrato)\nWHERE (`i_salidas`.`Id` ='" + idSalida + "') group by `i_detallesalida`.`IdSuministro`";
        System.out.println("xsql suministro despachado-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
