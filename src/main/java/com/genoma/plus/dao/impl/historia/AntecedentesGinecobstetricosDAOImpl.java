package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.AntecedentesGinecobstetricosDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.AntecedentesGinecobstetricosDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/AntecedentesGinecobstetricosDAOImpl.class */
public class AntecedentesGinecobstetricosDAOImpl implements AntecedentesGinecobstetricosDAO {
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_INSERT = "insert into `h_antecedenteginecologico` (`Id_Usuario`,`Id_Atencion`,`Id_Citologia`,`FUM`,`FUC`,\n  `FUEM`,`Enf_Mama`,`Desc_Mama`,`Id_MetPlanifica`,`TiempoEnPlanifica`,`No_G`,`No_P`,\n  `No_C`,`No_A`,`UltimoParto`,`UltimoAborto`,`No_E`,`No_M`,`No_V`,\n  `Menarquia`,`EdadInicioRel`,`CauterizacionCuello`,`RadioterapiaUtero`,`Histerectomia`,`ConizacionCuello`,`Ciclos`,`Biopsia`,\n  `FPParto`,`SemanaG`,`Legrado`,`Gemelar`,`Fecha`,`UsuarioS`)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SQL_UPDATE = "update `baseserver` set  `FUM`=?,`FUC`=?,`FUEM`=?,`Enf_Mama`=?,\n  `Desc_Mama`=?,`Id_MetPlanifica`=?,`TiempoEnPlanifica`=?,`No_G`=?,`No_P`=?,`No_C`=?,`No_A`=?,\n  `UltimoParto`=?,`UltimoAborto`=?,`No_E`=?,`No_M`=?,`No_V`=?,`Menarquia`=?,`EdadInicioRel`=?,`CauterizacionCuello`=?,\n  `RadioterapiaUtero`=?,`Histerectomia`=?,`ConizacionCuello`=?,`Ciclos`=?,`Biopsia`=?,`FPParto`=?,`SemanaG`=?,`Legrado`=?,\n  `Gemelar`=?,`Fecha`=?,`UsuarioS`=? where `Id_Usuario`=?  and `Id_Atencion`=?;";
    private static final String SQL_READLL_MP = "SELECT Id, Nbre FROM h_tipometplanifica WHERE (Estado =0) ORDER BY Nbre ASC";

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesGinecobstetricosDAO
    public String mCreate(final AntecedentesGinecobstetricosDTO xAnteGineco) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.AntecedentesGinecobstetricosDAOImpl.1
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(AntecedentesGinecobstetricosDAOImpl.SQL_INSERT, 1);
                ps.setLong(1, xAnteGineco.getIdUsuario());
                ps.setLong(2, xAnteGineco.getIdAtencion());
                ps.setLong(3, xAnteGineco.getIdCitologia());
                ps.setString(4, xAnteGineco.getFum());
                ps.setString(5, xAnteGineco.getFuC());
                ps.setString(6, xAnteGineco.getFueM());
                ps.setLong(7, xAnteGineco.getEnfMama());
                ps.setString(8, xAnteGineco.getDescMama());
                ps.setLong(9, xAnteGineco.getIdMetPlanifica());
                ps.setLong(10, xAnteGineco.getTiempoEnPlanifica());
                ps.setLong(11, xAnteGineco.getNoG());
                ps.setLong(12, xAnteGineco.getNoP());
                ps.setLong(13, xAnteGineco.getNoC());
                ps.setLong(14, xAnteGineco.getNoA());
                ps.setString(15, xAnteGineco.getUltimoParto());
                ps.setString(16, xAnteGineco.getUltimoAborto());
                ps.setLong(17, xAnteGineco.getNoE());
                ps.setLong(18, xAnteGineco.getNoM());
                ps.setLong(19, xAnteGineco.getNoV());
                ps.setString(20, xAnteGineco.getMenarquia());
                ps.setLong(21, xAnteGineco.getEdadInicioRel());
                ps.setString(22, xAnteGineco.getCauterizacionCuello());
                ps.setString(23, xAnteGineco.getRadioterapiaUtero());
                ps.setString(24, xAnteGineco.getHisterectomia());
                ps.setString(25, xAnteGineco.getConizacionCuello());
                ps.setString(26, xAnteGineco.getCiclos());
                ps.setString(27, xAnteGineco.getBiopsia());
                ps.setString(28, xAnteGineco.getFpParto());
                ps.setString(29, xAnteGineco.getSemanaG());
                ps.setString(30, xAnteGineco.getLegrado());
                ps.setLong(31, xAnteGineco.getGemelar());
                ps.setString(32, xAnteGineco.getFecha());
                ps.setString(33, xAnteGineco.getUsuarioS());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdAnteGinecO = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdAnteGinecO --> " + xIdAnteGinecO);
        return xIdAnteGinecO;
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesGinecobstetricosDAO
    public String mUpdate(AntecedentesGinecobstetricosDTO xAnteGineco) {
        String resultado = "Se actualizó Correctamente";
        int ctos = this.jdbcTemplate.update(SQL_UPDATE, new Object[]{xAnteGineco.getFum(), xAnteGineco.getFuC(), xAnteGineco.getFueM(), Integer.valueOf(xAnteGineco.getEnfMama()), xAnteGineco.getDescMama(), Integer.valueOf(xAnteGineco.getIdMetPlanifica()), Integer.valueOf(xAnteGineco.getTiempoEnPlanifica()), Integer.valueOf(xAnteGineco.getNoG()), Integer.valueOf(xAnteGineco.getNoP()), Integer.valueOf(xAnteGineco.getNoC()), Integer.valueOf(xAnteGineco.getNoA()), xAnteGineco.getUltimoParto(), xAnteGineco.getUltimoAborto(), Integer.valueOf(xAnteGineco.getNoE()), Integer.valueOf(xAnteGineco.getNoM()), Integer.valueOf(xAnteGineco.getNoV()), xAnteGineco.getMenarquia(), Integer.valueOf(xAnteGineco.getEdadInicioRel()), xAnteGineco.getCauterizacionCuello(), xAnteGineco.getRadioterapiaUtero(), xAnteGineco.getHisterectomia(), xAnteGineco.getConizacionCuello(), xAnteGineco.getCiclos(), xAnteGineco.getBiopsia(), xAnteGineco.getFpParto(), xAnteGineco.getSemanaG(), xAnteGineco.getLegrado(), Integer.valueOf(xAnteGineco.getGemelar()), xAnteGineco.getFecha(), xAnteGineco.getUsuarioS(), Integer.valueOf(xAnteGineco.getIdUsuario()), Integer.valueOf(xAnteGineco.getIdAtencion())});
        if (ctos == 0) {
            resultado = "No se actualizó";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesGinecobstetricosDAO
    public List<GCGenericoDTO> listMetodosPlanificar() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedentesGinecobstetricosDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(SQL_READLL_MP, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesGinecobstetricosDAO
    public List<AntecedentesGinecobstetricosDTO> listAnteGinecoobstetrico(int idUsuario) {
        String SQL_READALL = "SELECT `h_antecedenteginecologico`.`Id`, `h_antecedenteginecologico`.`Id_Usuario`, MAX(`h_antecedenteginecologico`.`Id_Atencion`) AS Id_Atencion, `h_antecedenteginecologico`.`Id_Citologia`\n    , `h_antecedenteginecologico`.`FUM`, `h_antecedenteginecologico`.`FUC`\n    , `h_antecedenteginecologico`.`FUEM`, `h_antecedenteginecologico`.`Enf_Mama`, `h_antecedenteginecologico`.`Desc_Mama`, `h_antecedenteginecologico`.`Id_MetPlanifica`\n    , `h_antecedenteginecologico`.`TiempoEnPlanifica`, `h_antecedenteginecologico`.`No_G`, `h_antecedenteginecologico`.`No_P`, `h_antecedenteginecologico`.`No_C`, `h_antecedenteginecologico`.`No_A`\n    , `h_antecedenteginecologico`.`UltimoParto`, `h_antecedenteginecologico`.`UltimoAborto`, `h_antecedenteginecologico`.`No_E`, `h_antecedenteginecologico`.`No_M`\n    , `h_antecedenteginecologico`.`No_V`, `h_antecedenteginecologico`.`Menarquia`, `h_antecedenteginecologico`.`EdadInicioRel`, `h_antecedenteginecologico`.`CauterizacionCuello`, `h_antecedenteginecologico`.`RadioterapiaUtero`\n    , `h_antecedenteginecologico`.`Histerectomia`, `h_antecedenteginecologico`.`ConizacionCuello`, `h_antecedenteginecologico`.`Ciclos`, `h_antecedenteginecologico`.`Biopsia`, `h_antecedenteginecologico`.`FPParto`\n    , `h_antecedenteginecologico`.`SemanaG`, `h_antecedenteginecologico`.`Legrado`, `h_antecedenteginecologico`.`Gemelar`\nFROM `baseserver`.`h_antecedenteginecologico`\n    INNER JOIN `baseserver`.`h_atencion` ON (`h_antecedenteginecologico`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` ON (`h_antecedenteginecologico`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_tipometplanifica` ON (`h_antecedenteginecologico`.`Id_MetPlanifica` = `h_tipometplanifica`.`Id`)\nWHERE (`h_antecedenteginecologico`.`Id_Usuario` =" + idUsuario + ")";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedentesGinecobstetricosDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                AntecedentesGinecobstetricosDTO xAnteGineco = new AntecedentesGinecobstetricosDTO();
                xAnteGineco.setId(rs.getInt("Id"));
                xAnteGineco.setIdUsuario(rs.getInt("Id_Usuario"));
                xAnteGineco.setIdAtencion(rs.getInt("Id_Atencion"));
                xAnteGineco.setIdCitologia(rs.getInt("Id_Citologia"));
                xAnteGineco.setFum(rs.getString("FUM"));
                xAnteGineco.setFuC(rs.getString("FUC"));
                xAnteGineco.setFueM(rs.getString("FUEM"));
                xAnteGineco.setEnfMama(rs.getInt("Enf_Mama"));
                xAnteGineco.setDescMama(rs.getString("Desc_Mama"));
                xAnteGineco.setIdMetPlanifica(rs.getInt("Id_MetPlanifica"));
                xAnteGineco.setTiempoEnPlanifica(rs.getInt("TiempoEnPlanifica"));
                xAnteGineco.setNoG(rs.getInt("No_G"));
                xAnteGineco.setNoP(rs.getInt("No_P"));
                xAnteGineco.setNoC(rs.getInt("No_C"));
                xAnteGineco.setNoA(rs.getInt("No_A"));
                xAnteGineco.setUltimoParto(rs.getString("UltimoParto"));
                xAnteGineco.setUltimoAborto(rs.getString("UltimoAborto"));
                xAnteGineco.setNoE(rs.getInt("No_E"));
                xAnteGineco.setNoM(rs.getInt("No_M"));
                xAnteGineco.setNoV(rs.getInt("No_V"));
                xAnteGineco.setMenarquia(rs.getString("Menarquia"));
                xAnteGineco.setEdadInicioRel(rs.getInt("EdadInicioRel"));
                xAnteGineco.setCauterizacionCuello(rs.getString("CauterizacionCuello"));
                xAnteGineco.setRadioterapiaUtero(rs.getString("RadioterapiaUtero"));
                xAnteGineco.setHisterectomia(rs.getString("Histerectomia"));
                xAnteGineco.setConizacionCuello(rs.getString("ConizacionCuello"));
                xAnteGineco.setCiclos(rs.getString("Ciclos"));
                xAnteGineco.setBiopsia(rs.getString("Biopsia"));
                xAnteGineco.setFpParto(rs.getString("FPParto"));
                xAnteGineco.setSemanaG(rs.getString("SemanaG"));
                xAnteGineco.setLegrado(rs.getString("Legrado"));
                xAnteGineco.setGemelar(rs.getInt("Gemelar"));
                return xAnteGineco;
            }
        };
        List<AntecedentesGinecobstetricosDTO> list = this.jdbcTemplate.query(SQL_READALL, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesGinecobstetricosDAO
    public boolean validarAtencion(int idUsuario, int idAtencion) {
        boolean id_Atencion = false;
        String SQL_ATENCION = "SELECT `Id_Usuario`,`Id_Atencion` FROM `h_antecedenteginecologico` WHERE `Id_Usuario`=" + idUsuario + " AND`Id_Atencion`=" + idAtencion + "";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedentesGinecobstetricosDAOImpl.4
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                AntecedentesGinecobstetricosDTO xAnteGineco = new AntecedentesGinecobstetricosDTO();
                xAnteGineco.setIdUsuario(rs.getInt("Id_Usuario"));
                xAnteGineco.setIdAtencion(rs.getInt("Id_Atencion"));
                return xAnteGineco;
            }
        };
        if (!this.jdbcTemplate.query(SQL_ATENCION, rowMapper).isEmpty()) {
            id_Atencion = true;
        }
        System.out.println("id_Atencion --> " + id_Atencion);
        return id_Atencion;
    }
}
