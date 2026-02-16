package com.genoma.plus.dao.impl.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.HSignosVitalesDAO;
import com.genoma.plus.dto.historia.HSignosVitalesDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/HSignosVitalesDAOImpl.class */
public class HSignosVitalesDAOImpl implements HSignosVitalesDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.HSignosVitalesDAO
    public Long mCrear(final HSignosVitalesDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.HSignosVitalesDAOImpl.1
            final String sql = "INSERT INTO `h_au_rsignos_vitales` ( `Id_Atencion` , `FechaR` , `Hora` , `TArterialD` , `TArterialS` , `FCardiaca` , `FRespiratoria` , `Talla`\n    , `Peso` , `IMC` , `Temperatura` , `Ps2` , `PerimetroAbdominal` , `Observacion` , `Id_Profesional`\n    , `Id_Especialidad` , `Estado` , `IdNotaClinica`, TAMedia , `Fecha` , `UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_au_rsignos_vitales` ( `Id_Atencion` , `FechaR` , `Hora` , `TArterialD` , `TArterialS` , `FCardiaca` , `FRespiratoria` , `Talla`\n    , `Peso` , `IMC` , `Temperatura` , `Ps2` , `PerimetroAbdominal` , `Observacion` , `Id_Profesional`\n    , `Id_Especialidad` , `Estado` , `IdNotaClinica`, TAMedia , `Fecha` , `UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, e.getIdAtencion().longValue());
                ps.setString(2, e.getFecha());
                ps.setString(3, e.getHora());
                ps.setLong(4, e.getTArtSentadoD().longValue());
                ps.setLong(5, e.getTArtSentadoS().longValue());
                ps.setLong(6, e.getFrecuenciaCardiaca().longValue());
                ps.setLong(7, e.getFrecuenciaRespiratoria().longValue());
                ps.setDouble(8, e.getTalla().doubleValue());
                ps.setDouble(9, e.getPeso().doubleValue());
                ps.setDouble(10, e.getImc().doubleValue());
                ps.setDouble(11, e.getTemperatura().doubleValue());
                ps.setLong(12, e.getPresionOxigeno().longValue());
                ps.setDouble(13, e.getPAbdominal().doubleValue());
                ps.setString(14, e.getObservacion());
                ps.setLong(15, e.getIdProfesional().longValue());
                ps.setLong(16, e.getIdEspecialidad().longValue());
                ps.setBoolean(17, e.isEstado());
                ps.setLong(18, e.getIdNotaClinica().longValue());
                ps.setDouble(19, e.getTAMedia().doubleValue());
                ps.setString(20, HSignosVitalesDAOImpl.this.xmt.formatoAMDH24.format(HSignosVitalesDAOImpl.this.xmt.getFechaActual()));
                ps.setString(21, Principal.usuarioSistemaDTO.getLogin());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idSignosVitales = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idSignosVitales;
    }

    @Override // com.genoma.plus.dao.historia.HSignosVitalesDAO
    public List<HSignosVitalesDTO> listSignosVitalesIdNota(String idNotaClinica) {
        String sql = "SELECT\n    `TArterialD`\n    , `TArterialS`\n    , `FCardiaca`\n    , `FRespiratoria`\n    , `Temperatura`\n    , `Ps2`\n    , `Talla`\n    , `Peso`\n    , `Observacion`\n    , `TAMedia`\nFROM\n    `h_au_rsignos_vitales`\nWHERE (`IdNotaClinica` =" + idNotaClinica + " AND `Estado`=1)";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.HSignosVitalesDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                HSignosVitalesDTO e = new HSignosVitalesDTO();
                e.setTArtSentadoD(Long.valueOf(rs.getLong("TArterialD")));
                e.setTArtSentadoS(Long.valueOf(rs.getLong("TArterialS")));
                e.setFrecuenciaCardiaca(Long.valueOf(rs.getLong("FCardiaca")));
                e.setFrecuenciaRespiratoria(Long.valueOf(rs.getLong("FRespiratoria")));
                e.setTemperatura(Double.valueOf(rs.getDouble("Temperatura")));
                e.setPresionOxigeno(Long.valueOf(rs.getLong("Ps2")));
                e.setTalla(Double.valueOf(rs.getDouble("Talla")));
                e.setPeso(Double.valueOf(rs.getDouble("Peso")));
                e.setObservacion(rs.getString("Observacion"));
                e.setTAMedia(Double.valueOf(rs.getDouble("TAMedia")));
                return e;
            }
        };
        List<HSignosVitalesDTO> listaSignosVitales = this.jdbcTemplate.query(sql, mapper);
        return listaSignosVitales;
    }
}
