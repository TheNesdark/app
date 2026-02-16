package com.genoma.plus.dao.impl.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.ExamenFisicoDAO;
import com.genoma.plus.dto.historia.ExamenFisicoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ExamenFisicoDAOImpl.class */
public class ExamenFisicoDAOImpl implements ExamenFisicoDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ExamenFisicoDAO
    public List<Object[]> listConfDetalleExamenFisico(String idTipoHistoria, String idAtencion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ExamenFisicoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Nbre"), rs.getString("Observacion"), Long.valueOf(rs.getLong("idDetalleExamen")), rs.getString("DatosPredefinidos")};
                return fila;
            }
        };
        String xsql = "SELECT\n    `h_grupoexamenfisico`.`Id`\n    , `h_grupoexamenfisico`.`Nbre`\n    , IFNULL(`d`.`Observacion`,'')Observacion, h_grupoexamenfisico.`DatosPredefinidos`, IFNULL(d.`Id`, 0)idDetalleExamen\nFROM\n     `h_grupoexamenfisico_tipohc`\n    INNER JOIN  `h_grupoexamenfisico` \n        ON (`h_grupoexamenfisico_tipohc`.`Id_GrupoExamenFisico` = `h_grupoexamenfisico`.`Id`)\n   LEFT JOIN(SELECT\n    `h_examenfisico_detalle`.`Id_GrupoExamenF`\n    , `h_examenfisico_detalle`.`Observacion`\n    , `h_examenfisico_detalle`.`Id`\nFROM\n    `h_examenfisico_detalle`\n    INNER JOIN `h_examenfisico` \n        ON (`h_examenfisico_detalle`.`Id_ExamenFisico` = `h_examenfisico`.`Id`)\nWHERE (`h_examenfisico`.`Id_Atencion` ='" + idAtencion + "'))\td ON \t(`h_grupoexamenfisico`.`Id`= `d`.`Id_GrupoExamenF`)\nWHERE (`h_grupoexamenfisico_tipohc`.`Id_TipoHc` ='" + idTipoHistoria + "')\nORDER BY `h_grupoexamenfisico`.`Orden` ASC";
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.ExamenFisicoDAO
    public Long mCrear(final ExamenFisicoDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.ExamenFisicoDAOImpl.2
            final String sql = "INSERT INTO `h_examenfisico` (`Id_Atencion` , `EstadoGeneral`  , `TArtSentadoD` , `TArtSentadoS` , `FCardiaca` , `FRespiratoria` , `Talla` , `Peso` , `Temperatura` , `Ps2`, PerimetroAbdominal, IMC , TAMedia , `Fecha` , `UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_examenfisico` (`Id_Atencion` , `EstadoGeneral`  , `TArtSentadoD` , `TArtSentadoS` , `FCardiaca` , `FRespiratoria` , `Talla` , `Peso` , `Temperatura` , `Ps2`, PerimetroAbdominal, IMC , TAMedia , `Fecha` , `UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, e.getIdAtencion().longValue());
                ps.setString(2, e.getEstadoGeneral());
                ps.setDouble(3, e.getTArtSentadoD().longValue());
                ps.setDouble(4, e.getTArtSentadoS().longValue());
                ps.setDouble(5, e.getFrecuenciaCardiaca().longValue());
                ps.setDouble(6, e.getFrecuenciaRespiratoria().longValue());
                ps.setDouble(7, e.getTalla().doubleValue());
                ps.setDouble(8, e.getPeso().doubleValue());
                ps.setDouble(9, e.getTemperatura().doubleValue());
                ps.setDouble(10, e.getPresionOxigeno().longValue());
                ps.setDouble(11, e.getPAbdominal().doubleValue());
                ps.setDouble(12, e.getImc().doubleValue());
                ps.setDouble(13, e.getTAMedia().doubleValue());
                ps.setString(14, ExamenFisicoDAOImpl.this.xmt.formatoAMDH24.format(ExamenFisicoDAOImpl.this.xmt.getFechaActual()));
                ps.setLong(15, Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idExamenFisico = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idExamenFisico;
    }

    @Override // com.genoma.plus.dao.historia.ExamenFisicoDAO
    public void mActualizar(ExamenFisicoDTO e) {
        this.jdbcTemplate.update("Update h_examenfisico set `EstadoGeneral`=?\n    , `TArtSentadoD`=?\n    , `TArtSentadoS`=?\n    , `FCardiaca`=?\n    , `FRespiratoria`=?\n    , `Talla`=?\n    , `Peso`=?\n    , `Temperatura`=?\n    , `Ps2`=?\n    , PerimetroAbdominal =?\n    , IMC =?\n    , `TAMedia`=?\n    , `Fecha`=? , UsuarioS=? where Id=?", new Object[]{e.getEstadoGeneral(), e.getTArtSentadoD(), e.getTArtSentadoS(), e.getFrecuenciaCardiaca(), e.getFrecuenciaRespiratoria(), e.getTalla(), e.getPeso(), e.getTemperatura(), e.getPresionOxigeno(), e.getPAbdominal(), e.getImc(), e.getTAMedia(), this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()), Principal.usuarioSistemaDTO.getLogin(), e.getId()});
    }

    @Override // com.genoma.plus.dao.historia.ExamenFisicoDAO
    public List<ExamenFisicoDTO> listExamenFisico(String idAtencion) {
        String xsql = "SELECT\n Id,   `Id_Atencion`\n    , `EstadoGeneral`\n    , `EstadoConciencia`\n    , `TArtSentadoD`\n    , `TArtSentadoS`\n    , `FCardiaca`\n    , `FRespiratoria`\n    , `Talla`\n    , `Peso`\n    , `Temperatura`\n    , `Ps2`\n    ,  PerimetroAbdominal\n    ,  IMC\n    , `TAMedia`\n    , `Fecha`\n    , `UsuarioS`\nFROM\n    `h_examenfisico`\nWHERE (`Id_Atencion` ='" + idAtencion + "')";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ExamenFisicoDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ExamenFisicoDTO e = new ExamenFisicoDTO();
                e.setIdAtencion(Long.valueOf(rs.getLong("Id_Atencion")));
                e.setId(Long.valueOf(rs.getLong("Id")));
                e.setEstadoGeneral(rs.getString("EstadoGeneral"));
                e.setEstadoConciencia(rs.getString("EstadoConciencia"));
                e.setTArtSentadoD(Long.valueOf(rs.getLong("TArtSentadoD")));
                e.setTArtSentadoS(Long.valueOf(rs.getLong("TArtSentadoS")));
                e.setFrecuenciaCardiaca(Long.valueOf(rs.getLong("FCardiaca")));
                e.setFrecuenciaRespiratoria(Long.valueOf(rs.getLong("FRespiratoria")));
                e.setTalla(Double.valueOf(rs.getDouble("Talla")));
                e.setPeso(Double.valueOf(rs.getDouble("Peso")));
                e.setTemperatura(Double.valueOf(rs.getDouble("Temperatura")));
                e.setPresionOxigeno(Long.valueOf(rs.getLong("Ps2")));
                e.setTAMedia(Double.valueOf(rs.getDouble("TAMedia")));
                e.setPAbdominal(Double.valueOf(rs.getDouble("PerimetroAbdominal")));
                e.setImc(Double.valueOf(rs.getDouble("IMC")));
                return e;
            }
        };
        List<ExamenFisicoDTO> lsExamenFisico = this.jdbcTemplate.query(xsql, rowMapper);
        return lsExamenFisico;
    }

    @Override // com.genoma.plus.dao.historia.ExamenFisicoDAO
    public List<Object[]> listInformacionTriage(String idIngreso) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ExamenFisicoDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), Long.valueOf(rs.getLong("TArtSentadoD")), Long.valueOf(rs.getLong("TArtSentadoS")), Long.valueOf(rs.getLong("Clasificacion")), rs.getString("FechaTriage"), rs.getString("HoraTriage"), rs.getString("MotivoConsulta"), Long.valueOf(rs.getLong("FCardiaca")), Long.valueOf(rs.getLong("FRespiratoria")), Double.valueOf(rs.getDouble("Talla")), Double.valueOf(rs.getDouble("Peso")), Double.valueOf(rs.getDouble("IMC")), Long.valueOf(rs.getLong("Ps2")), Long.valueOf(rs.getLong("Temperatura")), Double.valueOf(rs.getDouble("TAMedia"))};
                return fila;
            }
        };
        String xsql = "SELECT `Id`, `TArtSentadoD`, `TArtSentadoS`, `Clasificacion`, `FechaTriage`, `HoraTriage`, `MotivoConsulta`, `FCardiaca`, `FRespiratoria`, `Talla`, `Peso`, `IMC`, `Temperatura`, `Ps2`, TAMedia \n FROM  `h_triage` WHERE (`Estado` =0 AND `IdIngreso` ='" + idIngreso + "')";
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.ExamenFisicoDAO
    public Integer consultarEdadUsuario(String fechaNacimiento) {
        String sql = "select Devuelve_Edad('" + fechaNacimiento + "') edad";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ExamenFisicoDAOImpl.5
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Integer res = Integer.valueOf(rs.getInt("edad"));
                return res;
            }
        };
        Integer resultado = Integer.valueOf(this.jdbcTemplate.query(sql, mapper).get(0).toString());
        return resultado;
    }
}
