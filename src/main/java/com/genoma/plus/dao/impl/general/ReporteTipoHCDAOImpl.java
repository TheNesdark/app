package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.ReporteTipoHCDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.ReporteTipoHCDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/ReporteTipoHCDAOImpl.class */
public class ReporteTipoHCDAOImpl implements ReporteTipoHCDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.ReporteTipoHCDAO
    public List<ReporteTipoHCDTO> listReportesTipoHC(String idTipoHC) {
        String sql = "SELECT\n    grt.id,\n    gr.Nbre AS Reportes,\n    grt.Estado,\n    grt.esVisible\nFROM\n    baseserver.g_reportes_tipohistoria grt\nINNER JOIN baseserver.g_reportes gr ON\n    grt.idReporte = gr.Id\nWHERE\n    grt.idTipoHistoria = '" + idTipoHC + "'\nORDER BY\n    gr.Nbre";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ReporteTipoHCDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ReporteTipoHCDTO e = new ReporteTipoHCDTO();
                e.setId(rs.getLong("id"));
                e.setNReporte(rs.getString("Reportes"));
                e.setEsVisible(rs.getInt("esVisible"));
                e.setEstado(rs.getInt("Estado"));
                return e;
            }
        };
        List<ReporteTipoHCDTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.general.ReporteTipoHCDAO
    public List<GCGenericoDTO> listReportes() {
        String xsql = "SELECT `Id`, `Nbre` FROM `g_reportes` WHERE (`Estado` = 1 AND `Tipo` = '" + Principal.informacionIps.getEsFpz() + "') ORDER BY `Nbre` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ReporteTipoHCDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.ReporteTipoHCDAO
    public String mCreate(ReporteTipoHCDTO xreportetipohc) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO .g_reportes_tipohistoria (idReporte, idTipoHistoria, esVisible, Estado, idusuarioRh)\nVALUES(?,?,?,?,?);", new Object[]{Long.valueOf(xreportetipohc.getIdReporte()), Long.valueOf(xreportetipohc.getIdTipoHistoria()), Integer.valueOf(xreportetipohc.getEsVisible()), Integer.valueOf(xreportetipohc.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.ReporteTipoHCDAO
    public String mUpdate(ReporteTipoHCDTO xreportetipohc) {
        String sql = "UPDATE\n\tg_reportes_tipohistoria\nSET\n\tEstado = ?,\n\tesVisible = ?,\n\tidusuarioRh = ?\nWHERE\n\tid = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xreportetipohc.getEstado()), Integer.valueOf(xreportetipohc.getEsVisible()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Long.valueOf(xreportetipohc.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
