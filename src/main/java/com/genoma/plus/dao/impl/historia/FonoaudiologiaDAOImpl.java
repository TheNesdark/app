package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.FonoaudiologiaDAO;
import com.genoma.plus.dto.historia.FonoaudiologiaDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/FonoaudiologiaDAOImpl.class */
public class FonoaudiologiaDAOImpl implements FonoaudiologiaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.FonoaudiologiaDAO
    public String mCreate(final FonoaudiologiaDTO xFono) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.FonoaudiologiaDAOImpl.1
            final String SQL_INSERT = "INSERT IGNORE INTO `h_fonoaudiologia` (`Id_Atencion`,`Audicion`,`Explor_AnatomicaOFA`,`Proces_Motores_Bas`,`Lecto_Escritura`,`ExploracionFCS`,`ExploracionDBA`,`UsuarioS`) \nVALUES (?,?,?,?,?,?,?,?)";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT IGNORE INTO `h_fonoaudiologia` (`Id_Atencion`,`Audicion`,`Explor_AnatomicaOFA`,`Proces_Motores_Bas`,`Lecto_Escritura`,`ExploracionFCS`,`ExploracionDBA`,`UsuarioS`) \nVALUES (?,?,?,?,?,?,?,?)", 1);
                ps.setLong(1, xFono.getIdAtencion());
                ps.setString(2, xFono.getOrganosSentidos());
                ps.setString(3, xFono.getExploracionOFA());
                ps.setString(4, xFono.getProcesosMotBasicos());
                ps.setString(5, xFono.getFonacion());
                ps.setString(6, xFono.getExploracionFCS());
                ps.setString(7, xFono.getExploracionDBA());
                ps.setString(8, xFono.getUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdFonoDoc = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xfonoaudilogía --> " + xIdFonoDoc);
        return xIdFonoDoc;
    }

    @Override // com.genoma.plus.dao.historia.FonoaudiologiaDAO
    public List<FonoaudiologiaDTO> listFonoaudiologia(Long idUsuario) {
        String SQL_READALL = "SELECT\n`h_fonoaudiologia`.`Id`\n    ,`h_atencion`.`Fecha_Atencion`\n    , `h_fonoaudiologia`.`Id_Atencion`\n    , `h_fonoaudiologia`.`Audicion`\n    , `h_fonoaudiologia`.`Explor_AnatomicaOFA`\n    , `h_fonoaudiologia`.`Proces_Motores_Bas`\n    , `h_fonoaudiologia`.`Lecto_Escritura`\n    , `h_fonoaudiologia`.`ExploracionFCS`\n    , `h_fonoaudiologia`.`ExploracionDBA`\nFROM\n    `baseserver`.`h_fonoaudiologia`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_fonoaudiologia`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nWHERE (`g_usuario`.`Id_persona` ='" + idUsuario + "')\nORDER BY `h_atencion`.`Fecha_Atencion` DESC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FonoaudiologiaDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                FonoaudiologiaDTO fono = new FonoaudiologiaDTO();
                fono.setId(rs.getInt("Id"));
                fono.setFechaAtencion(rs.getString("Fecha_Atencion"));
                fono.setIdAtencion(rs.getInt("Id_Atencion"));
                fono.setOrganosSentidos(rs.getString("Audicion"));
                fono.setExploracionOFA(rs.getString("Explor_AnatomicaOFA"));
                fono.setProcesosMotBasicos(rs.getString("Proces_Motores_Bas"));
                fono.setFonacion(rs.getString("Lecto_Escritura"));
                fono.setExploracionFCS(rs.getString("ExploracionFCS"));
                fono.setExploracionDBA(rs.getString("ExploracionDBA"));
                return fono;
            }
        };
        List<FonoaudiologiaDTO> lsFono = this.jdbcTemplate.query(SQL_READALL, rowMapper);
        return lsFono;
    }

    @Override // com.genoma.plus.dao.historia.FonoaudiologiaDAO
    public String mUpdate(FonoaudiologiaDTO xFono) {
        String resultado = "Se actualizÓ Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_fonoaudiologia` SET `Audicion` = ?,`Explor_AnatomicaOFA` = ?,`Proces_Motores_Bas` = ?,`Lecto_Escritura` = ?,`ExploracionFCS` = ?,`ExploracionDBA` = ?,`UsuarioS` = ? WHERE `Id` = ? AND `Id_Atencion` = ? ", new Object[]{xFono.getOrganosSentidos(), xFono.getExploracionOFA(), xFono.getProcesosMotBasicos(), xFono.getFonacion(), xFono.getExploracionFCS(), xFono.getExploracionDBA(), xFono.getUsuarioS(), Integer.valueOf(xFono.getId()), Integer.valueOf(xFono.getIdAtencion())});
        if (ctos == 0) {
            resultado = "No se actualizó";
        }
        return resultado;
    }
}
