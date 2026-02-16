package com.genoma.plus.dao.impl.comprabs;

import Acceso.Principal;
import com.genoma.plus.dao.comprabs.AdicionContratoDAO;
import com.genoma.plus.dto.comprabs.AdicionContratoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/comprabs/AdicionContratoDAOImpl.class */
public class AdicionContratoDAOImpl implements AdicionContratoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.comprabs.AdicionContratoDAO
    public List<AdicionContratoDTO> list(String idcontrato) {
        String xsql = "SELECT `cc_orden_compra_adicion`.`Id`\n, IF(`cc_orden_compra_adicion`.`Tipo`=0,'TIEMPO','VALOR') AS Tipo\n, `cc_tipo_documentof`.`Nbre` AS `TipoDocumento`\n, IFNULL(`cc_orden_compra_adicion`.`FechaP`,'') AS FechaP\n, IFNULL(`cc_orden_compra_adicion`.`Valor`,'') AS Valor\n, `cc_orden_compra_adicion`.`Observacion`\n, `cc_orden_compra_adicion`.`Estado`\nFROM\n`cc_orden_compra_adicion`\nINNER JOIN `cc_tipo_documentof` \nON (`cc_orden_compra_adicion`.`Id_TipoDocF` = `cc_tipo_documentof`.`Id`)\nWHERE (`cc_orden_compra_adicion`.`Id_OrdenCompra` ='" + idcontrato + "')";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.comprabs.AdicionContratoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                AdicionContratoDTO g = new AdicionContratoDTO();
                g.setId(Long.valueOf(rs.getLong("Id")));
                g.setTipo(rs.getString("Tipo"));
                g.setIdTipoDocF(rs.getString("TipoDocumento"));
                g.setFechaP(rs.getString("FechaP"));
                g.setValor(Double.valueOf(rs.getDouble("Valor")));
                g.setObservacion(rs.getString("Observacion"));
                g.setEstado(rs.getInt("estado"));
                return g;
            }
        };
        List<AdicionContratoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.comprabs.AdicionContratoDAO
    public String create(AdicionContratoDTO gen) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `cc_orden_compra_adicion` (`Id_OrdenCompra`,`Tipo`,`Id_TipoDocF`,`FechaP`,`Valor`,`Observacion`,`Estado`,`Id_UsuarioS`) VALUES (?,?,?,?,?,?,?,?);", new Object[]{gen.getIdContrato(), gen.getTipo(), gen.getIdTipoDocF(), gen.getFechaP(), gen.getValor(), gen.getObservacion(), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.comprabs.AdicionContratoDAO
    public String update(AdicionContratoDTO gen) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `cc_orden_compra_adicion`\nSET `Id_OrdenCompra` = ?,\n  `Tipo` = ?,\n  `Id_TipoDocF` = ?,\n  `FechaP` = ?,\n  `Valor` = ?,\n  `Observacion` = ?,\n  `Estado` = ?,  \n  `Id_UsuarioS` = ?\nWHERE `Id` = ?;", new Object[]{gen.getIdContrato(), gen.getTipo(), gen.getIdTipoDocF(), gen.getFechaP(), gen.getValor(), gen.getObservacion(), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), gen.getId()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.comprabs.AdicionContratoDAO
    public String delete(AdicionContratoDTO gen) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
