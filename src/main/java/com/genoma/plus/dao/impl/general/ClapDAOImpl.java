package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.ClapDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/ClapDAOImpl.class */
public class ClapDAOImpl implements ClapDAO {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.ClapDAO
    public List<Object[]> listEncabezado(Long idUsuario) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ClapDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Id"), rs.getString("IdPersona"), rs.getString("Id_Atencion"), rs.getString("NoDocumento"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Domicilio"), rs.getString("Municipio"), rs.getString("Telefono"), rs.getString("FechaNac"), rs.getString("Edad"), rs.getString("FiltroEdad"), rs.getString("NEducativo"), rs.getString("Etnia"), rs.getString("EstadoCivil"), rs.getString("Fecha_Atencion"), rs.getString("Familiar"), rs.getString("Nembarazos"), rs.getString("NparotsVaginales"), rs.getString("Ncesareas"), rs.getString("Nabortos"), rs.getString("Neptopicos"), rs.getString("NMortinatos"), rs.getString("NNacidosVivos"), rs.getString("UltimaMestruacion"), rs.getString("PartoProbable"), rs.getString("UltimoParto"), Integer.valueOf(rs.getInt("Gemelar")), rs.getString("Alcohol"), rs.getString("FUMA"), rs.getString("DROGAS"), rs.getString("Trimestre")};
                return fila;
            }
        };
        this.sql = "SELECT\n      g_usuarioxprograma.`Id`\n    , `g_persona`.`Id` AS IdPersona\n    , `g_usuarioxprograma`.Id_Atencion\n    , RPAD(`g_persona`.`NoDocumento`,11,' ') AS NoDocumento\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS Nombre\n    ,  CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`) AS Apellido\n    ,  CONCAT(`g_barrio`.`Nbre`  ,' - ', `g_persona`.`Direccion`) AS Domicilio\n    , `g_municipio`.`Nbre` AS `Municipio`\n    ,  IF(`g_persona`.`Telefono`='',`g_persona`.`Movil`, `g_persona`.`Telefono` ) AS Telefono\n    , `g_persona`.`FechaNac`\n    , YEAR(CURDATE())-YEAR(`g_persona`.`FechaNac`) AS Edad\n    , IF (YEAR(CURDATE())-YEAR(`g_persona`.`FechaNac`)<15,1,IF(YEAR(CURDATE())-YEAR(`g_persona`.`FechaNac`)>35,2,0))AS FiltroEdad\n    , LOWER(`g_usuario`.`NEducativo`) AS NEducativo\n    , LOWER(`g_usuario`.`Etnia`) AS Etnia\n    , `g_estadocivil`.`Nbre` AS `EstadoCivil`\n    , `h_atencion`.`Fecha_Atencion`\n    , GROUP_CONCAT( IF(`h_antecedentefamiliar`.`CIE10`IN ('O240','O241','O242','O243','O244','O249'),2\n    , IF(`h_antecedentefamiliar`.`CIE10` IN ('I10X','I119'),3\n    , IF(`h_antecedentefamiliar`.`CIE10` IN ('O140','O141','O149','O150','O151','O152','O159'),4,0))) ) AS Familiar\n    , LPAD(IFNULL(`h_antecedenteginecologico`.`No_G`, '0'),2,0)AS Nembarazos\n    , LPAD(IFNULL(`h_antecedenteginecologico`.`No_P`, '0'),2,0) AS NparotsVaginales\n    , IFNULL(`h_antecedenteginecologico`.`No_C`, '0')AS Ncesareas\n    , LPAD(IFNULL(`h_antecedenteginecologico`.`No_A`, '0'),2,0)AS Nabortos \n    , IFNULL(`h_antecedenteginecologico`.`No_E`, '0')AS Neptopicos\n    , IFNULL(`h_antecedenteginecologico`.`No_M`, '0')AS NMortinatos\n    , LPAD(IFNULL(`h_antecedenteginecologico`.`No_V`, '0'),2,0) AS NNacidosVivos\n    , `g_usuarioxprograma`.`UltimaMestruacion`\n    , `g_usuarioxprograma`.`PartoProbable`\n    , IFNULL(IF(h_antecedenteginecologico.`UltimoParto`=0 OR h_antecedenteginecologico.`UltimoParto`='','          ',h_antecedenteginecologico.`UltimoParto`), '          ') AS UltimoParto\n    , IF(h_antecedenteginecologico.`Gemelar`=1,1,0) AS Gemelar\n    , IF(h_habitos.`Habito_Alcohol`=1,1,0) AS Alcohol\n    , IF(IFNULL(h_habitos.`Id_TipoCantCigarro`,1)=1,0,1) AS FUMA\n    , IF(h_habitos.`Sicoactivas`=0,0,1) AS DROGAS  \n    , g_usuarioxprograma.`Trimestre` \nFROM\n    `baseserver`.`g_usuario`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_usuarioxprograma` \n        ON (`g_usuario`.`Id_persona` = `g_usuarioxprograma`.`Id_Usuario`)\n    INNER JOIN `baseserver`.`g_barrio` \n        ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n    INNER JOIN `baseserver`.`g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `baseserver`.`g_estadocivil` \n        ON (`g_persona`.`Id_EstadoCivil` = `g_estadocivil`.`Id`)\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_atencion`.`IdUsuarioPrograma` = `g_usuarioxprograma`.`Id`)\n    LEFT JOIN `baseserver`.`h_antecedentefamiliar` \n        ON (`h_antecedentefamiliar`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN `baseserver`.`h_habitos` \n        ON (`h_habitos`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN `baseserver`.`h_antecedenteginecologico` \n        ON (`h_antecedenteginecologico`.`Id_Atencion` = `h_atencion`.`Id`)\n         WHERE (`g_usuarioxprograma`.`Id_Programa` =3 AND g_usuarioxprograma.`Id`= '" + idUsuario + "')GROUP BY `g_persona`.`Id`";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.ClapDAO
    public List<Object[]> listAtenciones(Long idUsuario) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.ClapDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("IdPersona"), rs.getString("Id"), rs.getString("Fecha_Atencion"), rs.getString("ClaseCita"), rs.getString("SGestacion"), rs.getString("AlturaUterina"), rs.getString("Peso"), rs.getString("FCFh1"), rs.getString("MovFetalH1"), rs.getString("NProfesional"), rs.getString("Presion"), rs.getString("Talla"), rs.getString("PesoAnterior")};
                return fila;
            }
        };
        this.sql = "SELECT\n    `g_persona`.`Id` AS IdPersona\n    , `g_usuarioxprograma`.`Id`\n    , `h_atencion`.`Fecha_Atencion`\n    , `c_clasecita`.`Nbre` AS ClaseCita\n    , `h_examenfisico`.`SGestacion`\n    , `h_examenfisico`.`AlturaUterina`\n    , `h_examenfisico`.`Peso`\n    , `h_examenfisico`.`FCFh1`\n    , `h_examenfisico`.`MovFetalH1`\n    , `profesional1`.`NProfesional`\n    , CONCAT(`h_examenfisico`.`TArtSentadoS`,'/',`h_examenfisico`.`TArtSentadoD`) AS Presion\n    , right(ROUND(`h_examenfisico`.`Talla`),2) as Talla\n    , lpad(Round(`h_examenfisico`.`Peso`),3,' ') as PesoAnterior\n    \nFROM\n    `baseserver`.`g_usuario`\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`g_usuarioxprograma` \n        ON (`g_usuarioxprograma`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_atencion`.`IdUsuarioPrograma` = `g_usuarioxprograma`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`h_examenfisico` \n        ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN baseserver.`profesional1` \n        ON (`profesional1`.`Id_Persona`= `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad`= `h_atencion`.`Id_Especialidad`)\n    WHERE (g_usuarioxprograma.`Id`='" + idUsuario + "')    ORDER BY h_atencion.`Id`DESC \n    LIMIT 5";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.ClapDAO
    public List<Object[]> listlaboratorios(Long idUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
