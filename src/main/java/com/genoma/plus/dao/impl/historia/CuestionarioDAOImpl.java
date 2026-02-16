package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.CuestionarioDAO;
import com.genoma.plus.dto.historia.CuestionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/CuestionarioDAOImpl.class */
public class CuestionarioDAOImpl implements CuestionarioDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioDAO
    public Long mCrear(final CuestionarioDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.CuestionarioDAOImpl.1
            final String SQL_INSERT = "INSERT INTO `h_so_cuestionarios_encabezado` (`Id_Usuario`, `Id_Atencion`, `FechaR`, `Id_Cuestionario`, `Observacion`, `Id_Especialidad`, `Id_Profesional`, `Cerrado`, `ResultadoTexto`, `ResultadoValor`, `UsuarioS`)  VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                System.out.println("INSERT INTO `h_so_cuestionarios_encabezado` (`Id_Usuario`, `Id_Atencion`, `FechaR`, `Id_Cuestionario`, `Observacion`, `Id_Especialidad`, `Id_Profesional`, `Cerrado`, `ResultadoTexto`, `ResultadoValor`, `UsuarioS`)  VALUES (?,?,?,?,?,?,?,?,?,?,?)");
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_so_cuestionarios_encabezado` (`Id_Usuario`, `Id_Atencion`, `FechaR`, `Id_Cuestionario`, `Observacion`, `Id_Especialidad`, `Id_Profesional`, `Cerrado`, `ResultadoTexto`, `ResultadoValor`, `UsuarioS`)  VALUES (?,?,?,?,?,?,?,?,?,?,?)", 1);
                ps.setLong(1, e.getIdUsuario().longValue());
                ps.setLong(2, e.getIdAtencion().longValue());
                ps.setString(3, e.getFechaR());
                ps.setLong(4, e.getIdCuestionario().longValue());
                ps.setString(5, e.getObservacion());
                ps.setLong(6, e.getIdEspecialidad().longValue());
                ps.setLong(7, e.getIdProfesional().longValue());
                ps.setBoolean(8, e.isCerrado());
                ps.setString(9, e.getResultadoTexto());
                ps.setString(10, e.getResultadoValor());
                ps.setString(11, e.getUUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long xIdCuestionario = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return xIdCuestionario;
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioDAO
    public CuestionarioDTO mCuestionarioIdAtencion(Long idAtencion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioDAO
    public List<Object[]> mListCuestionario(String IdAtencion, int IdCuestionario, final int opc) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.CuestionarioDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila;
                if (opc == 0) {
                    fila = new Object[]{Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString("Encabezado")};
                } else {
                    fila = new Object[]{Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), Long.valueOf(rs.getLong(6)), rs.getString(7), Boolean.valueOf(rs.getBoolean(8)), Long.valueOf(rs.getLong(9)), Long.valueOf(rs.getLong(10)), Long.valueOf(rs.getLong(11)), Long.valueOf(rs.getLong(12)), rs.getString("Encabezado")};
                }
                return fila;
            }
        };
        if (opc == 0) {
            sql = "SELECT so_tipo_preguntas.`Id`,`Categoria`,so_tipo_preguntas.`Nbre`, so_tipo_cuestionario.Encabezado FROM `so_tipo_preguntas`   INNER JOIN `so_tipo_cuestionario` ON (`so_tipo_cuestionario`.`Id` = `so_tipo_preguntas`.`Id_TipoC`)\nWHERE (so_tipo_preguntas.`Id_TipoC` ='" + IdCuestionario + "' AND so_tipo_preguntas.`Estado` =1) ORDER BY so_tipo_preguntas.`Orden` ASC ";
        } else {
            sql = "SELECT\n  `so_tipo_preguntas`.`Id`,`so_tipo_preguntas`.`Categoria`,\n  `so_tipo_preguntas`.`Nbre`,\n  `h_so_cuestionario_detalle`.`ValorR`,\n  IF(`h_so_cuestionario_detalle`.`Observacion` IS NULL,'',`h_so_cuestionario_detalle`.`Observacion`) AS ObsP,\n  `h_so_cuestionario_detalle`.`Id`,\n  IF(`h_so_cuestionarios_encabezado`.`Observacion` IS NULL,'',`h_so_cuestionarios_encabezado`.`Observacion`) AS ObsP,\n  `h_so_cuestionarios_encabezado`.`Cerrado`,\n  h_so_cuestionario_detalle.Id_Cuestionario,\n  h_so_cuestionario_detalle.ValorC,\n  h_so_cuestionario_detalle.Id_Respuesta,\n  IFNULL(h_so_cuestionario_detalle_subcategoria.`Id_CDetalle`,0) Id_CDetalle, so_tipo_cuestionario.Encabezado\nFROM\n  `h_so_cuestionario_detalle`\n  INNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)\n  INNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\n  INNER JOIN `so_tipo_cuestionario` ON (`so_tipo_cuestionario`.`Id` = `so_tipo_preguntas`.`Id_TipoC`)\n  LEFT JOIN `h_so_cuestionario_detalle_subcategoria` ON (h_so_cuestionario_detalle.`Id`= h_so_cuestionario_detalle_subcategoria.`Id_CDetalle`) AND (h_so_cuestionario_detalle_subcategoria.`Estado`=1)\nWHERE (\n    `h_so_cuestionarios_encabezado`.`Id_Atencion` = '" + IdAtencion + "'\n    AND `h_so_cuestionarios_encabezado`.`Id_Cuestionario` = '" + IdCuestionario + "'\n    AND `h_so_cuestionarios_encabezado`.`Estado` = 1\n  )\n  GROUP BY h_so_cuestionario_detalle.`Id`\nORDER BY `so_tipo_preguntas`.`Orden` ASC";
        }
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioDAO
    public List<Object[]> mListHistoricoCuestionario(String IdAtencion, int IdCuestionario, String IdUsuario) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.CuestionarioDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
                return fila;
            }
        };
        String sql = "SELECT \n  h_so_cuestionarios_encabezado.FechaR,\n  so_tipo_preguntas.Nbre,\n  h_so_cuestionario_detalle.ValorR,\n  IF(h_so_cuestionario_detalle.Observacion IS NULL,'',h_so_cuestionario_detalle.Observacion) AS ObsP,\n  IF(h_so_cuestionarios_encabezado.Observacion IS NULL,'',h_so_cuestionarios_encabezado.Observacion) AS ObsGeneral\nFROM\n  h_so_cuestionario_detalle\n  INNER JOIN h_so_cuestionarios_encabezado ON (h_so_cuestionario_detalle.Id_Cuestionario = h_so_cuestionarios_encabezado.Id)\n  INNER JOIN so_tipo_preguntas ON (h_so_cuestionario_detalle.Id_Pregunta = so_tipo_preguntas.Id)\n  LEFT JOIN h_so_cuestionario_detalle_subcategoria ON (h_so_cuestionario_detalle.Id= h_so_cuestionario_detalle_subcategoria.Id_CDetalle) AND (h_so_cuestionario_detalle_subcategoria.Estado=1)\nWHERE (\n    h_so_cuestionarios_encabezado.Id_Atencion <= '" + IdAtencion + "'\n    AND h_so_cuestionarios_encabezado.Id_Cuestionario = '" + IdCuestionario + "'\n    AND h_so_cuestionarios_encabezado.Estado = 1\n    AND h_so_cuestionarios_encabezado.Id_Usuario = '" + IdUsuario + "'\n  )  GROUP BY h_so_cuestionario_detalle.Id\nORDER BY h_so_cuestionarios_encabezado.Id_Atencion DESC,so_tipo_preguntas.Orden ASC";
        System.out.println("Historico Cuestionario: " + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioDAO
    public List<Object[]> mListCuestionarioSmoking(String IdAtencion, int IdCuestionario, final int opc) {
        String sql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.CuestionarioDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila;
                if (opc == 0) {
                    fila = new Object[]{Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), Integer.valueOf(rs.getInt(4))};
                } else {
                    fila = new Object[]{Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), Long.valueOf(rs.getLong(6)), rs.getString(7), Boolean.valueOf(rs.getBoolean(8)), Long.valueOf(rs.getLong(9)), Long.valueOf(rs.getLong(10)), Long.valueOf(rs.getLong(11)), Long.valueOf(rs.getLong(12)), Integer.valueOf(rs.getInt(13))};
                }
                return fila;
            }
        };
        if (opc == 0) {
            sql = "SELECT `Id`,`Categoria`,`Nbre`,`Orden` FROM `so_tipo_preguntas` WHERE (`Id_TipoC` ='" + IdCuestionario + "' AND `Estado` =1) ORDER BY `Id` ASC ";
        } else {
            sql = "SELECT\n  `so_tipo_preguntas`.`Id`,`so_tipo_preguntas`.`Categoria`,\n  `so_tipo_preguntas`.`Nbre`,\n  `h_so_cuestionario_detalle`.`ValorR`,\n  IF(`h_so_cuestionario_detalle`.`Observacion` IS NULL,'',`h_so_cuestionario_detalle`.`Observacion`) AS ObsP,\n  `h_so_cuestionario_detalle`.`Id`,\n  IF(`h_so_cuestionarios_encabezado`.`Observacion` IS NULL,'',`h_so_cuestionarios_encabezado`.`Observacion`) AS ObsP,\n  `h_so_cuestionarios_encabezado`.`Cerrado`,\n  h_so_cuestionario_detalle.Id_Cuestionario,\n  h_so_cuestionario_detalle.ValorC,\n  h_so_cuestionario_detalle.Id_Respuesta,\n  IFNULL(h_so_cuestionario_detalle_subcategoria.`Id_CDetalle`,0) Id_CDetalle, `so_tipo_preguntas`.`Orden`\nFROM\n  `h_so_cuestionario_detalle`\n  INNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)\n  INNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\n  INNER JOIN `so_tipo_cuestionario` ON (`so_tipo_cuestionario`.`Id` = `so_tipo_preguntas`.`Id_TipoC`)\n  LEFT JOIN `h_so_cuestionario_detalle_subcategoria` ON (h_so_cuestionario_detalle.`Id`= h_so_cuestionario_detalle_subcategoria.`Id_CDetalle`) AND (h_so_cuestionario_detalle_subcategoria.`Estado`=1)\nWHERE (\n    `h_so_cuestionarios_encabezado`.`Id_Atencion` = '" + IdAtencion + "'\n    AND `h_so_cuestionarios_encabezado`.`Id_Cuestionario` = '" + IdCuestionario + "'\n    AND `h_so_cuestionarios_encabezado`.`Estado` = 1\n  )\n  GROUP BY h_so_cuestionario_detalle.`Id`\nORDER BY `so_tipo_preguntas`.`Id` ASC";
        }
        System.out.println("resultado " + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioDAO
    public List<Object[]> mResultadoPorItems(int idCategoria, double valor) {
        String sql = "SELECT\n    `p_items_test_smoking`.`id`\n    , `p_items_test_smoking`.`nombre`\n    , `so_tipo_cuestionario_valoracion`.`VMinimo`\n    , `so_tipo_cuestionario_valoracion`.`VMaximo`\n    , `so_tipo_cuestionario_valoracion`.`Nbre`\n    , IF(( " + ((int) valor) + ">=VMinimo AND " + ((int) valor) + "<=VMaximo), 1, 0)\nFROM\n    `baseserver`.`so_tipo_cuestionario_valoracion`\n    INNER JOIN `baseserver`.`p_items_test_smoking` \n        ON (`so_tipo_cuestionario_valoracion`.`Id_Interno` = `p_items_test_smoking`.`categoria_id`)\n    WHERE(`p_items_test_smoking`.`id` = " + idCategoria + ")\n     ORDER BY `p_items_test_smoking`.`id`";
        RowMapper rowMapper = (rs, arg1) -> {
            Object[] fila = new Object[8];
            fila[0] = Integer.valueOf(rs.getInt(1));
            fila[1] = rs.getString(2);
            fila[2] = Integer.valueOf(rs.getInt(3));
            fila[3] = Integer.valueOf(rs.getInt(4));
            fila[4] = rs.getString(5);
            fila[5] = Boolean.valueOf(rs.getBoolean(6));
            return fila;
        };
        List<Object[]> listaResultado = this.jdbcTemplate.query(sql, rowMapper);
        return listaResultado;
    }
}
