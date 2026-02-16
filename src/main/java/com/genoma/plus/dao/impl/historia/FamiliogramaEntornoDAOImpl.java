package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.FamiliogramaEntornoDAO;
import com.genoma.plus.dto.historia.FamiliogramaEntornoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/FamiliogramaEntornoDAOImpl.class */
public class FamiliogramaEntornoDAOImpl implements FamiliogramaEntornoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaEntornoDAO
    public List<Object[]> listadoFEntorno(int idFamiliograma) {
        String sql = "SELECT\n    `h_familiograma_entorno`.`Id`\n    , `h_familiograma_entorno`.`Id_Familiograma`\n    , `h_familiograma_entorno`.`Id_Entorno`\n    , `g_entorno_familiar`.`Nbre`\n    , `h_familiograma_entorno`.`Id_TipoRelacion`\n    , `g_relaciones_medicina_familar`.`Nbre`\n    , `h_familiograma_entorno`.`Estado`\nFROM\n    `h_familiograma_entorno`\n    INNER JOIN `g_entorno_familiar` \n        ON (`h_familiograma_entorno`.`Id_Entorno` = `g_entorno_familiar`.`Id`)\n    INNER JOIN `g_relaciones_medicina_familar` \n        ON (`h_familiograma_entorno`.`Id_TipoRelacion` = `g_relaciones_medicina_familar`.`Id`)\nWHERE (`h_familiograma_entorno`.`Id_Familiograma` =" + idFamiliograma + ");";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaEntornoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), Integer.valueOf(rs.getInt(3)), rs.getString(4), Integer.valueOf(rs.getInt(5)), rs.getString(6), Boolean.valueOf(rs.getBoolean(7))};
                return fila;
            }
        };
        List<Object[]> listadoFEntornos = this.jdbcTemplate.query(sql, mapper);
        return listadoFEntornos;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaEntornoDAO
    public String mCreate(FamiliogramaEntornoDTO xFEntornoDTO) {
        String result = "Se ha insertado correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_familiograma_entorno` (`Id_Familiograma`,`Id_Entorno`,`Id_TipoRelacion`,`Estado`,`Id_UsuarioS`)VALUES (?,?,?,?,?);", new Object[]{Integer.valueOf(xFEntornoDTO.getIdfamiliograma()), Integer.valueOf(xFEntornoDTO.getIdEntorno()), Integer.valueOf(xFEntornoDTO.getIdTipoRelacion()), Boolean.valueOf(xFEntornoDTO.isEstado()), Integer.valueOf(xFEntornoDTO.getIdUsuario())});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaEntornoDAO
    public String mUpdate(FamiliogramaEntornoDTO xFEntornoDTO) {
        String sql = "UPDATE `h_familiograma_entorno` SET `Id_Familiograma = ?,`Id_Entorno`= ?,`Id_TipoRelacion`= ?,`Estado` = ?,`Id_UsuarioS`= ? WHERE `Id`= ? ;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xFEntornoDTO.getIdfamiliograma()), Integer.valueOf(xFEntornoDTO.getIdEntorno()), Integer.valueOf(xFEntornoDTO.getIdTipoRelacion()), Boolean.valueOf(xFEntornoDTO.isEstado()), Integer.valueOf(xFEntornoDTO.getIdUsuario()), Integer.valueOf(xFEntornoDTO.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
