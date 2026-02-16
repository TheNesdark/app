package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.GlasgowDAO;
import com.genoma.plus.dto.historia.GlasgowAntencionDTO;
import com.genoma.plus.dto.historia.GlasgowAtencionDetalleDTO;
import com.genoma.plus.dto.historia.GlasgowItemsDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/GlasgowDAOImpl.class */
public class GlasgowDAOImpl implements GlasgowDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.GlasgowDAO
    public Long guardaAntencion(final GlasgowAntencionDTO atencion) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.GlasgowDAOImpl.1
            final String SQL_INSERT = "INSERT INTO h_glasgow_atencion\n(idatencion, fechar, idusuarioa, observacion, idprofesional, idespecialidad, clasificacion, puntajetotal, usuarios)\nVALUES(?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                System.out.println("INSERT INTO h_glasgow_atencion\n(idatencion, fechar, idusuarioa, observacion, idprofesional, idespecialidad, clasificacion, puntajetotal, usuarios)\nVALUES(?,?,?,?,?,?,?,?,?);");
                PreparedStatement ps = connection.prepareStatement("INSERT INTO h_glasgow_atencion\n(idatencion, fechar, idusuarioa, observacion, idprofesional, idespecialidad, clasificacion, puntajetotal, usuarios)\nVALUES(?,?,?,?,?,?,?,?,?);", 1);
                ps.setInt(1, atencion.getIdatencion());
                ps.setString(2, atencion.getFechar());
                ps.setLong(3, atencion.getIdusuarioa().longValue());
                ps.setString(4, atencion.getObservacion());
                ps.setLong(5, atencion.getIdprofesional().longValue());
                ps.setLong(6, atencion.getIdespecialidad().longValue());
                ps.setString(7, atencion.getClasificacion());
                ps.setInt(8, atencion.getPuntajetotal());
                ps.setString(9, atencion.getUsuarios());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long xidGlasgowAtencion = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return xidGlasgowAtencion;
    }

    @Override // com.genoma.plus.dao.historia.GlasgowDAO
    public void guardaDetalle(GlasgowAtencionDetalleDTO detalle) {
        this.jdbcTemplate.update("INSERT INTO h_glasgow_atencion_detalle\n(id_glasgow_atencion, id_item_glasgow, puntaje)\nVALUES(?, ?, ?)", new Object[]{detalle.getId_glasgow_atencion(), Integer.valueOf(detalle.getId_item_glasgow()), Integer.valueOf(detalle.getPuntaje())});
    }

    @Override // com.genoma.plus.dao.historia.GlasgowDAO
    public List<Object[]> getHistorico(int idAtencion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.GlasgowDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("select ga.fechar, ga.puntajetotal, ga.clasificacion, ga.observacion,\np.NProfesional\nfrom h_glasgow_atencion ga\ninner join profesional1 p on (ga.idprofesional=p.Id_Persona) and (ga.idespecialidad=p.IdEspecialidad)\nwhere ga.idatencion=? and ga.estado=1\norder by fechar desc", mapper, new Object[]{Integer.valueOf(idAtencion)});
        return list;
    }

    @Override // com.genoma.plus.dao.historia.GlasgowDAO
    public List<GlasgowItemsDTO> getGlasgowItems() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.GlasgowDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                GlasgowItemsDTO item = new GlasgowItemsDTO();
                item.setId(rs.getInt("id"));
                item.setNombre(rs.getString("nombre"));
                item.setId_grupoglasgow(rs.getInt("id_grupoglasgow"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setPuntos(rs.getInt("puntos"));
                return item;
            }
        };
        List<GlasgowItemsDTO> lsTipo = this.jdbcTemplate.query("SELECT id, nombre, id_grupoglasgow, descripcion, puntos, estado, fecha, usuarios\nFROM h_glasgow_items WHERE estado=1 ", rowMapper);
        return lsTipo;
    }
}
