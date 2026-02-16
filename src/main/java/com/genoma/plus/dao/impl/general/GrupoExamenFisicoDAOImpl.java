package com.genoma.plus.dao.impl.general;

import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.GrupoExamenFisicoDAO;
import com.genoma.plus.dto.general.GrupoExamenFisicoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/GrupoExamenFisicoDAOImpl.class */
public class GrupoExamenFisicoDAOImpl implements GrupoExamenFisicoDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.GrupoExamenFisicoDAO
    public List<GrupoExamenFisicoDTO> listExamenesFisicos() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.GrupoExamenFisicoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GrupoExamenFisicoDTO grupoExamen = new GrupoExamenFisicoDTO();
                grupoExamen.setId(rs.getInt("Id"));
                grupoExamen.setNombre(rs.getString("Nbre"));
                grupoExamen.setEstado(rs.getBoolean("Estado"));
                grupoExamen.setOrden(rs.getInt("Orden"));
                grupoExamen.setFiltroSexo(rs.getBoolean("FiltroSexo"));
                grupoExamen.setNivel(rs.getInt("Nivel"));
                grupoExamen.setDatosPredefinidos(rs.getString("DatosPredefinidos"));
                return grupoExamen;
            }
        };
        List<GrupoExamenFisicoDTO> listGrupo = this.jdbcTemplate.query("SELECT `id`, `Nbre`, `Estado`, `Orden`, `FiltroSexo`, `Nivel`, ifnull(`DatosPredefinidos`,'') as DatosPredefinidos  FROM `h_grupoexamenfisico`", rowMapper);
        return listGrupo;
    }

    @Override // com.genoma.plus.dao.general.GrupoExamenFisicoDAO
    public String mCreate(GrupoExamenFisicoDTO xgrupos) {
        String result = " Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_grupoexamenfisico`(`Nbre`, `Estado`, `Orden`, `FiltroSexo`, `Nivel`, `DatosPredefinidos`, `Fecha`, `UsuarioS`) VALUES (?,?,?,?,?,?,?,?)", new Object[]{xgrupos.getNombre(), Boolean.valueOf(xgrupos.isEstado()), Integer.valueOf(xgrupos.getOrden()), Boolean.valueOf(xgrupos.isFiltroSexo()), Integer.valueOf(xgrupos.getNivel()), xgrupos.getDatosPredefinidos(), xgrupos.getFecha(), xgrupos.getUsuario()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.GrupoExamenFisicoDAO
    public String mUpdate(GrupoExamenFisicoDTO xgrupos) {
        String sql = "UPDATE `h_grupoexamenfisico` SET `Nbre`= ?,`Estado`= ?,`Orden`= ?,`FiltroSexo`= ?,`Nivel`= ?,`DatosPredefinidos`= ?,`Fecha`= ?,`UsuarioS`= ? WHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xgrupos.getNombre(), Boolean.valueOf(xgrupos.isEstado()), Integer.valueOf(xgrupos.getOrden()), Boolean.valueOf(xgrupos.isFiltroSexo()), Integer.valueOf(xgrupos.getNivel()), xgrupos.getDatosPredefinidos(), xgrupos.getFecha(), xgrupos.getUsuario(), Integer.valueOf(xgrupos.getId())});
        if (ctos == 0) {
            sql = " 0 filas afectadas";
        }
        return sql;
    }
}
