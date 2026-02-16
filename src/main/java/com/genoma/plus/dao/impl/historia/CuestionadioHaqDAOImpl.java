package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.CuestionarioHaqDAO;
import com.genoma.plus.dto.historia.CuestionarioHaqDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/CuestionadioHaqDAOImpl.class */
public class CuestionadioHaqDAOImpl implements CuestionarioHaqDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioHaqDAO
    public String mCreate(final CuestionarioHaqDTO xCuesHAQ) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.CuestionadioHaqDAOImpl.1
            final String SQL_INSERT = "INSERT INTO `h_cuestionario_haq` (`Id_Atencion`,`Id_Usuario`,`Id_Profesional`,`Id_Especialidad`,`Fecha_Registro`,\n  `Preg_1`,`Preg_2`,`Preg_3`,`Preg_4`,`Preg_5`,`Preg_6`,`Preg_7`,`Preg_8`,`Preg_9`,`Preg_10`,`Preg_11`,`Preg_12`,`Preg_13`,\n  `Preg_14`,`Preg_15`,`Preg_16`,`Preg_17`,`Preg_18`,`Preg_19`,`Preg_20`,`Grup1_Vestirse_Asearse`,`Grup2_Levantarse`,`Grup3_Comer`,\n  `Grup4_Caminar`,`Grup5_Higiene`,`Grup6_Alcanzar`,`Grup7_Prension`,`Grup8_Otras`,`Act_1`,`Act_2`,`Act_3`,`Act_4`,`Act_5`,`Act_6`,\n  `Act_7`,`Act_8`,`Uten_1`,`Uten_2`,`Uten_3`,`Uten_4`,`Uten_5`,`Clasificacion`,`Observacion`,`UsuarioS`\n)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_cuestionario_haq` (`Id_Atencion`,`Id_Usuario`,`Id_Profesional`,`Id_Especialidad`,`Fecha_Registro`,\n  `Preg_1`,`Preg_2`,`Preg_3`,`Preg_4`,`Preg_5`,`Preg_6`,`Preg_7`,`Preg_8`,`Preg_9`,`Preg_10`,`Preg_11`,`Preg_12`,`Preg_13`,\n  `Preg_14`,`Preg_15`,`Preg_16`,`Preg_17`,`Preg_18`,`Preg_19`,`Preg_20`,`Grup1_Vestirse_Asearse`,`Grup2_Levantarse`,`Grup3_Comer`,\n  `Grup4_Caminar`,`Grup5_Higiene`,`Grup6_Alcanzar`,`Grup7_Prension`,`Grup8_Otras`,`Act_1`,`Act_2`,`Act_3`,`Act_4`,`Act_5`,`Act_6`,\n  `Act_7`,`Act_8`,`Uten_1`,`Uten_2`,`Uten_3`,`Uten_4`,`Uten_5`,`Clasificacion`,`Observacion`,`UsuarioS`\n)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", 1);
                ps.setLong(1, xCuesHAQ.getId_Atencion());
                ps.setLong(2, xCuesHAQ.getId_Usuario());
                ps.setString(3, xCuesHAQ.getId_Profesional());
                ps.setString(4, xCuesHAQ.getId_Especialidad());
                ps.setString(5, xCuesHAQ.getFecha_Registro());
                ps.setInt(6, xCuesHAQ.getPreg_1());
                ps.setInt(7, xCuesHAQ.getPreg_2());
                ps.setInt(8, xCuesHAQ.getPreg_3());
                ps.setInt(9, xCuesHAQ.getPreg_4());
                ps.setInt(10, xCuesHAQ.getPreg_5());
                ps.setInt(11, xCuesHAQ.getPreg_6());
                ps.setInt(12, xCuesHAQ.getPreg_7());
                ps.setInt(13, xCuesHAQ.getPreg_8());
                ps.setInt(14, xCuesHAQ.getPreg_9());
                ps.setInt(15, xCuesHAQ.getPreg_10());
                ps.setInt(16, xCuesHAQ.getPreg_11());
                ps.setInt(17, xCuesHAQ.getPreg_12());
                ps.setInt(18, xCuesHAQ.getPreg_13());
                ps.setInt(19, xCuesHAQ.getPreg_14());
                ps.setInt(20, xCuesHAQ.getPreg_15());
                ps.setInt(21, xCuesHAQ.getPreg_16());
                ps.setInt(22, xCuesHAQ.getPreg_17());
                ps.setInt(23, xCuesHAQ.getPreg_18());
                ps.setInt(24, xCuesHAQ.getPreg_19());
                ps.setInt(25, xCuesHAQ.getPreg_20());
                ps.setInt(26, xCuesHAQ.getGrup1_Vestirse_Asearse());
                ps.setInt(27, xCuesHAQ.getGrup2_Levantarse());
                ps.setInt(28, xCuesHAQ.getGrup3_Comer());
                ps.setInt(29, xCuesHAQ.getGrup4_Caminar());
                ps.setInt(30, xCuesHAQ.getGrup5_Higiene());
                ps.setInt(31, xCuesHAQ.getGrup6_Alcanzar());
                ps.setInt(32, xCuesHAQ.getGrup7_Prension());
                ps.setInt(33, xCuesHAQ.getGrup8_Otras());
                ps.setDouble(34, xCuesHAQ.getAct_1());
                ps.setDouble(35, xCuesHAQ.getAct_2());
                ps.setDouble(36, xCuesHAQ.getAct_3());
                ps.setDouble(37, xCuesHAQ.getAct_4());
                ps.setDouble(38, xCuesHAQ.getAct_5());
                ps.setDouble(39, xCuesHAQ.getAct_6());
                ps.setDouble(40, xCuesHAQ.getAct_7());
                ps.setDouble(41, xCuesHAQ.getAct_8());
                ps.setDouble(42, xCuesHAQ.getUten_1());
                ps.setDouble(43, xCuesHAQ.getUten_2());
                ps.setDouble(44, xCuesHAQ.getUten_3());
                ps.setDouble(45, xCuesHAQ.getUten_4());
                ps.setDouble(46, xCuesHAQ.getUten_5());
                ps.setDouble(47, xCuesHAQ.getClasificacion());
                ps.setString(48, xCuesHAQ.getObservacion());
                ps.setString(49, xCuesHAQ.getUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdCuestioHAQ = String.valueOf(generatedKeyHolder.getKey().longValue());
        return xIdCuestioHAQ;
    }

    @Override // com.genoma.plus.dao.historia.CuestionarioHaqDAO
    public List<CuestionarioHaqDTO> listCuestionarioHAQ(Long idUsuario) {
        String SQL_READALL = "SELECT `h_cuestionario_haq`.`Id`\n    , `h_cuestionario_haq`.`Id_Atencion`\n    , CONCAT(`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`,' ', `g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`) AS Profesional\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `h_cuestionario_haq`.`Fecha_Registro`\n    , `h_cuestionario_haq`.`Preg_1`\n    , `h_cuestionario_haq`.`Preg_2`\n    , `h_cuestionario_haq`.`Preg_3`\n    , `h_cuestionario_haq`.`Preg_4`\n    , `h_cuestionario_haq`.`Preg_5`\n    , `h_cuestionario_haq`.`Preg_6`\n    , `h_cuestionario_haq`.`Preg_7`\n    , `h_cuestionario_haq`.`Preg_8`\n    , `h_cuestionario_haq`.`Preg_9`\n    , `h_cuestionario_haq`.`Preg_10`\n    , `h_cuestionario_haq`.`Preg_11`\n    , `h_cuestionario_haq`.`Preg_12`\n    , `h_cuestionario_haq`.`Preg_13`\n    , `h_cuestionario_haq`.`Preg_14`\n    , `h_cuestionario_haq`.`Preg_15`\n    , `h_cuestionario_haq`.`Preg_16`\n    , `h_cuestionario_haq`.`Preg_17`\n    , `h_cuestionario_haq`.`Preg_18`\n    , `h_cuestionario_haq`.`Preg_19`\n    , `h_cuestionario_haq`.`Preg_20`\n    , `h_cuestionario_haq`.`Grup1_Vestirse_Asearse`\n    , `h_cuestionario_haq`.`Grup2_Levantarse`\n    , `h_cuestionario_haq`.`Grup3_Comer`\n    , `h_cuestionario_haq`.`Grup4_Caminar`\n    , `h_cuestionario_haq`.`Grup5_Higiene`\n    , `h_cuestionario_haq`.`Grup6_Alcanzar`\n    , `h_cuestionario_haq`.`Grup7_Prension`\n    , `h_cuestionario_haq`.`Grup8_Otras`\n    , `h_cuestionario_haq`.`Act_1`\n    , `h_cuestionario_haq`.`Act_2`\n    , `h_cuestionario_haq`.`Act_3`\n    , `h_cuestionario_haq`.`Act_4`\n    , `h_cuestionario_haq`.`Act_5`\n    , `h_cuestionario_haq`.`Act_6`\n    , `h_cuestionario_haq`.`Act_7`\n    , `h_cuestionario_haq`.`Act_8`\n    , `h_cuestionario_haq`.`Uten_1`\n    , `h_cuestionario_haq`.`Uten_2`\n    , `h_cuestionario_haq`.`Uten_3`\n    , `h_cuestionario_haq`.`Uten_4`\n    , `h_cuestionario_haq`.`Uten_5`\n    , ROUND(`h_cuestionario_haq`.`Clasificacion`,2)AS Clasificacion\n    , `h_cuestionario_haq`.`Observacion`\nFROM `baseserver`.`h_cuestionario_haq`\n    INNER JOIN `baseserver`.`h_atencion` ON (`h_cuestionario_haq`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` ON (`h_cuestionario_haq`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN `baseserver`.`g_profesional` ON (`h_cuestionario_haq`.`Id_Profesional` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`g_persona` ON (`g_profesional`.`Id_Persona` = `g_persona`.`Id`)\nWHERE (`h_cuestionario_haq`.`Id_Usuario` ='" + idUsuario + "') ORDER BY `h_cuestionario_haq`.`Fecha_Registro` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.CuestionadioHaqDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                CuestionarioHaqDTO cHAQ = new CuestionarioHaqDTO();
                cHAQ.setId(rs.getInt("Id"));
                cHAQ.setId_Atencion(rs.getInt("Id_Atencion"));
                cHAQ.setId_Profesional(rs.getString("Profesional"));
                cHAQ.setId_Especialidad(rs.getString("Especialidad"));
                cHAQ.setFecha_Registro(rs.getString("Fecha_Registro"));
                cHAQ.setPreg_1(rs.getInt("Preg_1"));
                cHAQ.setPreg_2(rs.getInt("Preg_2"));
                cHAQ.setPreg_3(rs.getInt("Preg_3"));
                cHAQ.setPreg_4(rs.getInt("Preg_4"));
                cHAQ.setPreg_5(rs.getInt("Preg_5"));
                cHAQ.setPreg_6(rs.getInt("Preg_6"));
                cHAQ.setPreg_7(rs.getInt("Preg_7"));
                cHAQ.setPreg_8(rs.getInt("Preg_8"));
                cHAQ.setPreg_9(rs.getInt("Preg_9"));
                cHAQ.setPreg_10(rs.getInt("Preg_10"));
                cHAQ.setPreg_11(rs.getInt("Preg_11"));
                cHAQ.setPreg_12(rs.getInt("Preg_12"));
                cHAQ.setPreg_13(rs.getInt("Preg_13"));
                cHAQ.setPreg_14(rs.getInt("Preg_14"));
                cHAQ.setPreg_15(rs.getInt("Preg_15"));
                cHAQ.setPreg_16(rs.getInt("Preg_16"));
                cHAQ.setPreg_17(rs.getInt("Preg_17"));
                cHAQ.setPreg_18(rs.getInt("Preg_18"));
                cHAQ.setPreg_19(rs.getInt("Preg_19"));
                cHAQ.setPreg_20(rs.getInt("Preg_20"));
                cHAQ.setGrup1_Vestirse_Asearse(rs.getInt("Grup1_Vestirse_Asearse"));
                cHAQ.setGrup2_Levantarse(rs.getInt("Grup2_Levantarse"));
                cHAQ.setGrup3_Comer(rs.getInt("Grup3_Comer"));
                cHAQ.setGrup4_Caminar(rs.getInt("Grup4_Caminar"));
                cHAQ.setGrup5_Higiene(rs.getInt("Grup5_Higiene"));
                cHAQ.setGrup6_Alcanzar(rs.getInt("Grup6_Alcanzar"));
                cHAQ.setGrup7_Prension(rs.getInt("Grup7_Prension"));
                cHAQ.setGrup8_Otras(rs.getInt("Grup8_Otras"));
                cHAQ.setAct_1(rs.getInt("Act_1"));
                cHAQ.setAct_2(rs.getInt("Act_2"));
                cHAQ.setAct_3(rs.getInt("Act_3"));
                cHAQ.setAct_4(rs.getInt("Act_4"));
                cHAQ.setAct_5(rs.getInt("Act_5"));
                cHAQ.setAct_6(rs.getInt("Act_6"));
                cHAQ.setAct_7(rs.getInt("Act_7"));
                cHAQ.setAct_8(rs.getInt("Act_8"));
                cHAQ.setUten_1(rs.getInt("Uten_1"));
                cHAQ.setUten_2(rs.getInt("Uten_2"));
                cHAQ.setUten_3(rs.getInt("Uten_3"));
                cHAQ.setUten_4(rs.getInt("Uten_4"));
                cHAQ.setUten_5(rs.getInt("Uten_5"));
                cHAQ.setClasificacion(rs.getDouble("Clasificacion"));
                cHAQ.setObservacion(rs.getString("Observacion"));
                return cHAQ;
            }
        };
        List<CuestionarioHaqDTO> lsCuestioHAQ = this.jdbcTemplate.query(SQL_READALL, rowMapper);
        return lsCuestioHAQ;
    }
}
