package com.genoma.plus.dao.impl.sig;

import com.genoma.plus.dao.sig.InformeMedicamentosSivigiliaDAO;
import com.genoma.plus.dto.sig.InformeMedicamentosSivigiliaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/InformeMedicamentosSivigilaDAOImpl.class */
public class InformeMedicamentosSivigilaDAOImpl implements InformeMedicamentosSivigiliaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.InformeMedicamentosSivigiliaDAO
    public List<Object[]> listaMedicamentosSivigila(InformeMedicamentosSivigiliaDTO sivigilaPajonalDTO) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeMedicamentosSivigilaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[18];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = Integer.valueOf(rs.getInt(4));
                fila[4] = Integer.valueOf(rs.getInt(5));
                return fila;
            }
        };
        String sql = "SELECT\n    `i_salidas`.`FechaSalida`\n    , `i_principioactivo`.`Nbre`\n    , `i_tiposmovimientos`.`Nbre` AS Servicio\n    , SUM(`i_detallesalida`.`CantidadSolicitada`) Cantidad\n    , SUM(`i_detallesalida`.`CantidadDespachada`) Despacho\nFROM\n    `baseserver`.`i_salidas`\n    INNER JOIN `baseserver`.`i_tiposmovimientos` \n        ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`)\n    INNER JOIN `baseserver`.`i_detallesalida` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `baseserver`.`i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `baseserver`.`i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\nWHERE (`i_suministro`.`Id` IN(15419,15355,15473,13238,14751,15263,10619,10053,14401)\nAND `i_salidas`.`FechaSalida` >='" + sivigilaPajonalDTO.getFechaInicio() + "'\nAND `i_salidas`.`FechaSalida` <='" + sivigilaPajonalDTO.getFechaFin() + "')\nGROUP BY `i_tiposmovimientos`.`Id`";
        List<Object[]> listaMedicamentosSivigila = this.jdbcTemplate.query(sql, mapper);
        return listaMedicamentosSivigila;
    }
}
