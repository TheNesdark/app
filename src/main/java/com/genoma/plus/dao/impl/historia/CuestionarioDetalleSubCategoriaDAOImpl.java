package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.CuestionarioDetalleSubCategoriaDAO;
import com.genoma.plus.dto.historia.CuestionarioDetalleSubCategoriaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/CuestionarioDetalleSubCategoriaDAOImpl.class */
public class CuestionarioDetalleSubCategoriaDAOImpl implements CuestionarioDetalleSubCategoriaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioDetalleSubCategoriaDAO
    public void mCrear(CuestionarioDetalleSubCategoriaDTO e) {
        this.jdbcTemplate.update("INSERT INTO `h_so_cuestionario_detalle_subcategoria` (`Id_CDetalle`, `Id_SubCategoria`, `Observacion`, `Estado`, `UsuarioS`)\nVALUES (?,?,?,?,?);", new Object[]{e.getIdCDetalle(), e.getIdSubCategoria(), e.getObservacion(), Boolean.valueOf(e.isEstado()), e.getUsuarioS()});
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioDetalleSubCategoriaDAO
    public List<CuestionarioDetalleSubCategoriaDTO> mListCuestionario(Long idGenerico, int opc) {
        String sql;
        if (opc == 0) {
            sql = "SELECT\n  `so_tipo_subcategoria`.`Id`,\n  `so_tipo_subcategoria`.`Nbre`,\n  '' AS Observacion,\n  false AS Aplica\nFROM\n  `so_tipo_pregunta_subcategoria`\n  INNER JOIN `so_tipo_preguntas` ON (`so_tipo_pregunta_subcategoria`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\n  INNER JOIN `so_tipo_subcategoria` ON (`so_tipo_pregunta_subcategoria`.`Id_Subcategoria` = `so_tipo_subcategoria`.`Id`)\nWHERE (\n    `so_tipo_pregunta_subcategoria`.`Estado` = 1\n    AND `so_tipo_preguntas`.`Id` = '" + idGenerico + "'\n  )\nORDER BY `so_tipo_pregunta_subcategoria`.`NOrden` ASC";
        } else {
            sql = "SELECT\n    `so_tipo_subcategoria`.`Id`\n    , `so_tipo_subcategoria`.`Nbre`\n    , IFNULL(`h_so_cuestionario_detalle_subcategoria`.`Observacion`,'') Observacion\n    , true AS Aplica\nFROM\n    `h_so_cuestionario_detalle_subcategoria`\n    INNER JOIN `so_tipo_subcategoria` \n        ON (`h_so_cuestionario_detalle_subcategoria`.`Id_SubCategoria` = `so_tipo_subcategoria`.`Id`)\nWHERE (`h_so_cuestionario_detalle_subcategoria`.`Id_CDetalle` ='" + idGenerico + "'\n    AND `h_so_cuestionario_detalle_subcategoria`.`Estado` =1);";
        }
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.CuestionarioDetalleSubCategoriaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                CuestionarioDetalleSubCategoriaDTO subCategoria = new CuestionarioDetalleSubCategoriaDTO();
                subCategoria.setIdSubCategoria(Long.valueOf(rs.getLong("Id")));
                subCategoria.setNbreSubCategoria(rs.getString("Nbre"));
                subCategoria.setObservacion(rs.getString("Observacion"));
                subCategoria.setAplica(rs.getBoolean("Aplica"));
                return subCategoria;
            }
        };
        List<CuestionarioDetalleSubCategoriaDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }
}
