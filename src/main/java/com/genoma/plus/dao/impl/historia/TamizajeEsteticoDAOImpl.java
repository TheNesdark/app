package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.TamizajeEsteticoDAO;
import com.genoma.plus.dto.historia.TamizajeEsteticoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/TamizajeEsteticoDAOImpl.class */
public class TamizajeEsteticoDAOImpl implements TamizajeEsteticoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.TamizajeEsteticoDAO
    public String mCreate(final TamizajeEsteticoDTO xTamiEst) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.TamizajeEsteticoDAOImpl.1
            final String SQL_INSERT = "INSERT INTO `h_tamizaje_estetico` (`Id_Atencion`,`BrazoD`,`BrazoI`,`GluteoD`,`GluteoI`,`MusloD`,\n             `MusloI`,`Torax`,`Cintura`,`Cadera`,`AbdomenA`,`AdomenM`,`AbdomenB`,`Estrias`,\n             `Celulitis`,`Flacidez`,`Observacion`,`Estado`,`UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_tamizaje_estetico` (`Id_Atencion`,`BrazoD`,`BrazoI`,`GluteoD`,`GluteoI`,`MusloD`,\n             `MusloI`,`Torax`,`Cintura`,`Cadera`,`AbdomenA`,`AdomenM`,`AbdomenB`,`Estrias`,\n             `Celulitis`,`Flacidez`,`Observacion`,`Estado`,`UsuarioS`)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setLong(1, xTamiEst.getXId_Atencion());
                ps.setDouble(2, xTamiEst.getXBrazoD());
                ps.setDouble(3, xTamiEst.getXBrazoI());
                ps.setDouble(4, xTamiEst.getXGluteoD());
                ps.setDouble(5, xTamiEst.getXGluteoI());
                ps.setDouble(6, xTamiEst.getXMusloD());
                ps.setDouble(7, xTamiEst.getXMusloI());
                ps.setDouble(8, xTamiEst.getXTorax());
                ps.setDouble(9, xTamiEst.getXCintura());
                ps.setDouble(10, xTamiEst.getXCadera());
                ps.setDouble(11, xTamiEst.getXAbdomenA());
                ps.setDouble(12, xTamiEst.getXAbdomenM());
                ps.setDouble(13, xTamiEst.getXAbdomenB());
                ps.setInt(14, xTamiEst.getXEstrias());
                ps.setInt(15, xTamiEst.getXCelulitis());
                ps.setInt(16, xTamiEst.getXFlacidez());
                ps.setString(17, xTamiEst.getXObservacion());
                ps.setInt(18, xTamiEst.getXEstado());
                ps.setString(19, xTamiEst.getXUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdTamiEs = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("Tamizaje Estetica  --> " + xIdTamiEs);
        return xIdTamiEs;
    }

    @Override // com.genoma.plus.dao.historia.TamizajeEsteticoDAO
    public List<TamizajeEsteticoDTO> listTamizajeEstetico(Long idUsuario) {
        String SQL_READALL = "SELECT `h_tamizaje_estetico`.`Id`\n    , `h_tamizaje_estetico`.`Id_Atencion`\n    , `h_tamizaje_estetico`.`BrazoD`\n    , `h_tamizaje_estetico`.`BrazoI`\n    , `h_tamizaje_estetico`.`GluteoD`\n    , `h_tamizaje_estetico`.`GluteoI`\n    , `h_tamizaje_estetico`.`MusloD`\n    , `h_tamizaje_estetico`.`MusloI`\n    , `h_tamizaje_estetico`.`Torax`\n    , `h_tamizaje_estetico`.`Cintura`\n    , `h_tamizaje_estetico`.`Cadera`\n    , `h_tamizaje_estetico`.`AbdomenA`\n    , `h_tamizaje_estetico`.`AdomenM`\n    , `h_tamizaje_estetico`.`AbdomenB`\n    , `h_tamizaje_estetico`.`Estrias`\n    , `h_tamizaje_estetico`.`Celulitis`\n    , `h_tamizaje_estetico`.`Flacidez`\n    , `h_tamizaje_estetico`.`Observacion`\n    , `h_tamizaje_estetico`.`Estado`\nFROM\n    `baseserver`.`h_tamizaje_estetico`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_tamizaje_estetico`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE ( `ingreso`.`Id_Usuario` ='" + idUsuario + "')";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.TamizajeEsteticoDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TamizajeEsteticoDTO xTamiEst = new TamizajeEsteticoDTO();
                xTamiEst.setXId(rs.getLong("Id"));
                xTamiEst.setXId_Atencion(rs.getLong("Id_Atencion"));
                xTamiEst.setXBrazoD(rs.getDouble("BrazoD"));
                xTamiEst.setXBrazoI(rs.getDouble("BrazoI"));
                xTamiEst.setXGluteoD(rs.getDouble("GluteoD"));
                xTamiEst.setXGluteoI(rs.getDouble("GluteoI"));
                xTamiEst.setXMusloD(rs.getDouble("MusloD"));
                xTamiEst.setXMusloI(rs.getDouble("MusloI"));
                xTamiEst.setXTorax(rs.getDouble("Torax"));
                xTamiEst.setXCintura(rs.getDouble("Cintura"));
                xTamiEst.setXCadera(rs.getDouble("Cadera"));
                xTamiEst.setXAbdomenA(rs.getDouble("AbdomenA"));
                xTamiEst.setXAbdomenM(rs.getDouble("AdomenM"));
                xTamiEst.setXAbdomenB(rs.getDouble("AbdomenB"));
                xTamiEst.setXEstrias(rs.getInt("Estrias"));
                xTamiEst.setXCelulitis(rs.getInt("Celulitis"));
                xTamiEst.setXFlacidez(rs.getInt("Flacidez"));
                xTamiEst.setXObservacion(rs.getString("Observacion"));
                xTamiEst.setXEstado(rs.getInt("Estado"));
                return xTamiEst;
            }
        };
        List<TamizajeEsteticoDTO> lsAntReuma = this.jdbcTemplate.query(SQL_READALL, rowMapper);
        return lsAntReuma;
    }

    @Override // com.genoma.plus.dao.historia.TamizajeEsteticoDAO
    public String mUpdate(TamizajeEsteticoDTO xTamiEst) {
        String resultado = "Se actualizÓ Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_tamizaje_estetico`\nSET `BrazoD` = ?,\n  `BrazoI` = ?,\n  `GluteoD` = ?,\n  `GluteoI` = ?,\n  `MusloD` = ?,\n  `MusloI` = ?,\n  `Torax` = ?,\n  `Cintura` = ?,\n  `Cadera` = ?,\n  `AbdomenA` = ?,\n  `AdomenM` = ?,\n  `AbdomenB` = ?,\n  `Estrias` = ?,\n  `Celulitis` = ?,\n  `Flacidez` = ?,\n  `Observacion` = ?,\n  `Estado` = ?,\n  `UsuarioS` = ?\nWHERE `Id` = ? AND `Id_Atencion`=? ", new Object[]{Double.valueOf(xTamiEst.getXBrazoD()), Double.valueOf(xTamiEst.getXBrazoI()), Double.valueOf(xTamiEst.getXGluteoD()), Double.valueOf(xTamiEst.getXGluteoI()), Double.valueOf(xTamiEst.getXMusloD()), Double.valueOf(xTamiEst.getXMusloI()), Double.valueOf(xTamiEst.getXTorax()), Double.valueOf(xTamiEst.getXCintura()), Double.valueOf(xTamiEst.getXCadera()), Double.valueOf(xTamiEst.getXAbdomenA()), Double.valueOf(xTamiEst.getXAbdomenB()), Double.valueOf(xTamiEst.getXAbdomenB()), Integer.valueOf(xTamiEst.getXEstrias()), Integer.valueOf(xTamiEst.getXCelulitis()), Integer.valueOf(xTamiEst.getXFlacidez()), xTamiEst.getXObservacion(), Integer.valueOf(xTamiEst.getXEstado()), xTamiEst.getXUsuarioS(), Long.valueOf(xTamiEst.getXId()), Long.valueOf(xTamiEst.getXId_Atencion())});
        if (ctos == 0) {
            resultado = "No se actualizó";
        }
        return resultado;
    }
}
