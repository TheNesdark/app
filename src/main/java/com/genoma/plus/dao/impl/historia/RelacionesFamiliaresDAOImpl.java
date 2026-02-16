package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.RelacionesFamiliaresDAO;
import com.genoma.plus.dto.historia.RelacionesFamiliaresDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/RelacionesFamiliaresDAOImpl.class */
public class RelacionesFamiliaresDAOImpl implements RelacionesFamiliaresDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.RelacionesFamiliaresDAO
    public List<RelacionesFamiliaresDTO> listadoRelaciones() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.RelacionesFamiliaresDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                RelacionesFamiliaresDTO fila = new RelacionesFamiliaresDTO();
                fila.setId(rs.getInt(1));
                fila.setNombre(rs.getString(2));
                fila.setAbreviatura(rs.getString(3));
                fila.setTipoLinea(rs.getInt(4));
                fila.setTipo(rs.getInt(5));
                fila.setEstado(rs.getBoolean(6));
                return fila;
            }
        };
        List<RelacionesFamiliaresDTO> listadoRelacionesF = this.jdbcTemplate.query("SELECT `Id`,`Nbre`,`Abreviatura`,`TipoLinea`,`Tipo`,`Estado` FROM `g_relaciones_medicina_familar`", mapper);
        return listadoRelacionesF;
    }

    @Override // com.genoma.plus.dao.historia.RelacionesFamiliaresDAO
    public String mCreate(RelacionesFamiliaresDTO xRelacionesF) {
        String result = "Datos insertados correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `g_relaciones_medicina_familar` (`Nbre`,`Abreviatura`,`TipoLinea`,`Tipo`,`Estado`,`Id_UsuarioS`) VALUES (?,?,?,?,?,?);", new Object[]{xRelacionesF.getNombre(), xRelacionesF.getAbreviatura(), Integer.valueOf(xRelacionesF.getTipoLinea()), Integer.valueOf(xRelacionesF.getTipo()), Boolean.valueOf(xRelacionesF.isEstado()), xRelacionesF.getIdUsuario()});
        if (ctos == 0) {
            result = "error al insertar el registro";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.historia.RelacionesFamiliaresDAO
    public String mUpdate(RelacionesFamiliaresDTO xRelacionesF) {
        String sql = "UPDATE `g_relaciones_medicina_familar` SET`Nbre` = ? ,`Abreviatura`= ?,`TipoLinea`= ? , `Tipo`= ? ,`Estado`= ? ,`Id_UsuarioS` = ? WHERE  `id`= ? ;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xRelacionesF.getNombre(), xRelacionesF.getAbreviatura(), Integer.valueOf(xRelacionesF.getTipoLinea()), Integer.valueOf(xRelacionesF.getTipo()), Boolean.valueOf(xRelacionesF.isEstado()), xRelacionesF.getIdUsuario(), Integer.valueOf(xRelacionesF.getId())});
        if (ctos == 0) {
            sql = "0 filas Afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.historia.RelacionesFamiliaresDAO
    public boolean existeAbreviatura(String abreviatura) {
        String sql = "SELECT `Abreviatura` FROM `g_relaciones_medicina_familar` WHERE `Abreviatura` = '" + abreviatura + "';";
        System.err.println(sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.RelacionesFamiliaresDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1)};
                return fila;
            }
        };
        List<Object[]> listadoRelacionesF = this.jdbcTemplate.query(sql, mapper);
        return listadoRelacionesF.size() > 0;
    }
}
