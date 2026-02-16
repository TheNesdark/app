package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/PatologiaCie10DAOImpl.class */
public class PatologiaCie10DAOImpl implements PatologiaCie10DAO {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.PatologiaCie10DAO
    public List<PatologiaCie10DTO> listPatologiaFiltrada(String codigo, String idPrograma) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                PatologiaCie10DTO e = new PatologiaCie10DTO();
                e.setId(rs.getString("Id"));
                e.setNombre(rs.getString("Nbre"));
                e.setV4505(rs.getString("V4505"));
                e.setSexo(rs.getString("Sexo"));
                e.setLimiteInferior(Long.valueOf(rs.getLong("LimInf")));
                e.setLimiteSuperior(Long.valueOf(rs.getLong("LimSup")));
                e.setCapitulo(rs.getString("Capitulo"));
                e.setIdSubgrupo(Long.valueOf(rs.getLong("Id_SubGrupo")));
                return e;
            }
        };
        this.sql = "SELECT\n    `Id`\n    , `Nbre`\n    , `V4505`\n    , `Sexo`\n    , `LimInf`\n    , `LimSup`\n    , `Capitulo`\n    , `Id_SubGrupo`\n    , `Usuario`\n    , `Fecha`\nFROM\n    `g_patologia`\nWHERE (`Id` ='" + codigo + "' and Estado=1)";
        List<PatologiaCie10DTO> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.PatologiaCie10DAO
    public Integer patologiaFiltradaEdad(String fechaNacimiento, String idSexo, String codigoPatologia) {
        Integer valor;
        try {
            this.sql = "SELECT IF(((Sexo='A' OR Sexo='M') AND LimInf='0' AND LimSup='0'),1,\n               IF(Sexo='A' AND Devuelve_Tipo_Edad_CIE10('" + fechaNacimiento + "')>=LimInf AND Devuelve_Tipo_Edad_CIE10('" + fechaNacimiento + "')<=LimSup,1,\n   IF(Sexo='" + idSexo + "' AND Devuelve_Tipo_Edad_CIE10('" + fechaNacimiento + "')>=LimInf AND Devuelve_Tipo_Edad_CIE10('" + fechaNacimiento + "')<=LimSup,1,\n    IF(Sexo='" + idSexo + "' AND Devuelve_Tipo_Edad_CIE10('" + fechaNacimiento + "')>=LimInf AND Devuelve_Tipo_Edad_CIE10('" + fechaNacimiento + "')<=LimSup,1,0\n    )\n   )\n      )\n          ) AS DATO\n FROM `g_patologia` WHERE (`Id` ='" + codigoPatologia + "' and Estado=1)";
            System.out.println("" + this.sql);
            valor = (Integer) this.jdbcTemplate.queryForObject(this.sql, Integer.class);
        } catch (Exception e) {
            valor = -1;
        }
        return valor;
    }

    @Override // com.genoma.plus.dao.general.PatologiaCie10DAO
    public PatologiaCie10DTO patologiaFiltrada(String codigo, Integer idPrograma) {
        PatologiaCie10DTO cie10DTO = new PatologiaCie10DTO();
        if (idPrograma.intValue() == -1) {
            this.sql = "SELECT\n    g_patologia.`Id`\n    ,  g_patologia.`Nbre`\n    ,  g_patologia.`V4505`\n    ,  g_patologia.`Sexo`\n    ,  g_patologia.`LimInf`\n    ,  g_patologia.`LimSup`\n    ,  g_patologia.`Capitulo`\n    ,  g_patologia.`Id_SubGrupo`\n    ,  g_patologia.`Usuario`\n    ,  g_patologia.`Fecha`\n    ,  IFNULL(`h_patologiaxguiamanejo`.`PathGuia`, '')PathGuia\n    ,  IF(g_patologia_recomedaciones.`Id` IS NULL,0, 1) esRecomendaciones\nFROM\n    `g_patologia`  \n LEFT JOIN `h_patologiaxguiamanejo`\n        ON (`h_patologiaxguiamanejo`.`Id_Patologia` = `g_patologia`.`Id`)\nLEFT JOIN `g_patologia_recomedaciones`\n        ON (`g_patologia_recomedaciones`.`Id_Patologia` = `g_patologia`.`Id`)   AND (g_patologia_recomedaciones.`Estado`=1) \nWHERE ( g_patologia.`Id` =?)";
            System.out.println("" + this.sql);
            try {
                return (PatologiaCie10DTO) this.jdbcTemplate.queryForObject(this.sql, new Object[]{codigo}, new PatologiaFiltro());
            } catch (EmptyResultDataAccessException e) {
                return cie10DTO;
            }
        }
        this.sql = "SELECT\n    g_patologia.`Id`\n    ,  g_patologia.`Nbre`\n    ,  g_patologia.`V4505`\n    ,  g_patologia.`Sexo`\n    ,  g_patologia.`LimInf`\n    ,  g_patologia.`LimSup`\n    ,  g_patologia.`Capitulo`\n    ,  g_patologia.`Id_SubGrupo`\n    ,  g_patologia.`Usuario`\n    ,  g_patologia.`Fecha`\n    ,  IFNULL(`h_patologiaxguiamanejo`.`PathGuia`, '')PathGuia\n    ,  IF(g_patologia_recomedaciones.`Id` IS NULL,0, 1) esRecomendaciones\nFROM\n    `g_patologia_programa`\n    INNER JOIN `g_patologia` \n        ON (`g_patologia_programa`.`Id_Patologia` = `g_patologia`.`Id`) \n  LEFT JOIN `h_patologiaxguiamanejo`\n        ON (`h_patologiaxguiamanejo`.`Id_Patologia` = `g_patologia`.`Id`)\nLEFT JOIN `g_patologia_recomedaciones`\n        ON (`g_patologia_recomedaciones`.`Id_Patologia` = `g_patologia`.`Id`)   AND (g_patologia_recomedaciones.`Estado`=1) \nWHERE (`g_patologia`.`Id` =?\n    AND `g_patologia_programa`.`Id_Programa` =?\n    AND `g_patologia_programa`.`Estado` =1)";
        try {
            System.out.println("" + codigo + " id " + idPrograma);
            System.out.println("" + this.sql);
            return (PatologiaCie10DTO) this.jdbcTemplate.queryForObject(this.sql, new Object[]{codigo, idPrograma}, new PatologiaFiltro());
        } catch (EmptyResultDataAccessException e2) {
            return cie10DTO;
        }
    }

    @Override // com.genoma.plus.dao.general.PatologiaCie10DAO
    public List<Object[]> listPatologiaFichaSivigila(String codigoPatologia) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("IdPatologia"), rs.getString("Nbre"), rs.getString("Descripcion"), rs.getString("Url_Encabezado"), rs.getString("Url"), rs.getBytes("ArchivoSivigila"), rs.getString("Codigo"), Integer.valueOf(rs.getInt("forma"))};
                return fila;
            }
        };
        this.sql = "SELECT\n    `g_patologia_ficha_sivigila`.`IdPatologia`\n    , `g_fichas_notificacion_sivigila`.`Nbre`\n    , `g_fichas_notificacion_sivigila`.`Descripcion`\n    , `g_fichas_notificacion_sivigila`.`Url_Encabezado`\n    , `g_fichas_notificacion_sivigila`.`Url`\n    , `g_fichas_notificacion_sivigila`.`ArchivoSivigila`\n    , `g_fichas_notificacion_sivigila`.`Codigo`\n    , `g_fichas_notificacion_sivigila`.`forma`\nFROM\n      `g_patologia_ficha_sivigila`\n    INNER JOIN   `g_fichas_notificacion_sivigila` \n        ON (`g_patologia_ficha_sivigila`.`IdFichaNotificcion` = `g_fichas_notificacion_sivigila`.`Id`)\nWHERE (`g_patologia_ficha_sivigila`.`IdPatologia` ='" + codigoPatologia + "'  AND `g_fichas_notificacion_sivigila`.`Estado` =1)";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.PatologiaCie10DAO
    public List<Object[]> informacionGeneracionFichaSivigila(String idAtencion, String codigoPatologia) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("CHabilitacion"), rs.getString("NIps"), rs.getString("CodigoEvento"), rs.getString("NEvento"), rs.getString("Fecha_Atencion"), rs.getString("Id_TipoIdentificacion"), rs.getString("NoDocumento"), rs.getString("NUsuario"), rs.getString("FechaNac"), rs.getString("Edad"), rs.getString("TipoEdad"), rs.getString("Id_Sexo"), rs.getString("NacionalidadCodigo"), rs.getString("Nacionalidad"), rs.getString("CodPaisOcurrencia"), rs.getString("PaisOcurrencia"), rs.getString("IdMunicDeptOcurrencia"), rs.getString("MunicDeptOcurrencia"), rs.getString("Zona"), rs.getString("Barrio"), rs.getString("Id_Ocupacion"), rs.getString("Id_Rips"), rs.getString("NRegimen"), rs.getString("CRips"), rs.getString("IdEtnias"), rs.getString("NEtnias"), rs.getString("IdPoblacionE"), rs.getString("NPoblacionE"), rs.getString("Direccion"), rs.getString("NProfesional"), rs.getString("Telefono"), rs.getString("UTelefono"), rs.getString("Nacionalidad"), rs.getString("CodigoRecidencia"), rs.getString("MunicDeptRecidencia"), rs.getString("Egreso_H"), rs.getString("FechaHospitalizacion"), rs.getString("DxMuerte"), rs.getString("EstaMuerte"), rs.getString("NacionalidadCodigoNumero"), rs.getString("codPaisNumeroOcurrencia"), rs.getString("codPaisNumeroResidencia"), rs.getString("identidadGenero")};
                return fila;
            }
        };
        this.sql = "SELECT\n    `g_ips`.`CodigoOrganismo` AS `CHabilitacion`\n    , `g_ips`.`Nbre` AS `NIps`\n    , LPAD(p.`Codigo`, 3, ' ') AS `CodigoEvento`\n    , p.`Nbre` AS `NEvento`\n    , DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d%m%Y') AS Fecha_Atencion\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuario`\n    , DATE_FORMAT(`g_persona`.`FechaNac`,'%d%m%Y') AS FechaNac\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `Edad`\n    ,  `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `h_atencion`.`Fecha_Atencion`) AS `TipoEdad`\n    , `g_persona`.`Id_Sexo`\n    , LPAD(IFNULL(Nacionalidad.Codigo,''), 3, ' ') AS NacionalidadCodigo\n    , LPAD(IFNULL(Nacionalidad.codPaisNumero,''), 3, ' ') AS NacionalidadCodigoNumero\n    , IFNULL(Nacionalidad.Nbre,'') AS `Nacionalidad`\n    , LPAD(IFNULL(Ocurrencia.Codigo,''), 4, ' ') AS CodPaisOcurrencia\n    , LPAD(IFNULL(Ocurrencia.codPaisNumeroOcurrencia,''), 4, ' ') AS codPaisNumeroOcurrencia\n    , IFNULL(Ocurrencia.Pais,'') AS PaisOcurrencia\n    , IFNULL(Ocurrencia.Id,'') AS IdMunicDeptOcurrencia\n    , IFNULL(Ocurrencia.MunicDept,'') AS MunicDeptOcurrencia    \n    , `g_barrio`.`Zona`\n    , `g_barrio`.`Nbre` AS `Barrio`\n    , LPAD(`ingreso`.`Id_Ocupacion`, 4, ' ') AS `Id_Ocupacion`\n    , `f_tiporegimen`.`Id_Rips`\n    , `f_tiporegimen`.`Nbre` AS `NRegimen`\n    , LPAD(`f_empresacontxconvenio`.`CRips`, 6, ' ') AS `CRips`\n    , `g_tipo_etnia`.`Id` AS `IdEtnias`\n    , `g_tipo_etnia`.`Nbre` AS `NEtnias`\n    , `g_poblacion_especial`.`Id` AS `IdPoblacionE`\n    , `g_poblacion_especial`.`Nbre` AS `NPoblacionE`\n    , `g_persona`.`Direccion`   \t\n    , CONCAT(`Profesional`.`Apellido1` ,' ', `Profesional`.`Apellido2`,' ',  `Profesional`.`Nombre1` ,' ',  `Profesional`.`Nombre2`) NProfesional\t\n    , LEFT(Profesional.`Movil`,10) AS Telefono\t\n    , IF(`g_persona`.`Movil`='',LEFT(`g_persona`.`Telefono`,10), LEFT(`g_persona`.Movil,10)) AS UTelefono\t\n    , Recidencia.Id AS CodigoRecidencia\n    , Recidencia.MunicDept AS MunicDeptRecidencia\n    , LPAD(IFNULL(Recidencia.codPaisNumeroResidencia,''), 4, ' ') AS codPaisNumeroResidencia\n    , `ingreso`.`Egreso_H`\n    , IF(ingreso.`Egreso_H`=1, LPAD(IFNULL(DATE_FORMAT(ingreso.`FEgreso`,'%d%m%Y'),''),8,' '),'        ') AS FechaHospitalizacion\n    , LPAD(IFNULL(`h_egreso_atencion`.`DxMuerte`,''),4,' ') AS DxMuerte\n    , IFNULL(`h_egreso_atencion`.`EstodoS`,'1') AS EstaMuerte , ingreso.idIdentidadG  identidadGenero \nFROM  \n(SELECT g_fichas_notificacion_sivigila.`Codigo`, g_fichas_notificacion_sivigila.`Nbre`\nFROM  `g_patologia_ficha_sivigila` \t\nINNER JOIN `g_fichas_notificacion_sivigila` \t\n        ON (`g_patologia_ficha_sivigila`.`IdFichaNotificcion` = `g_fichas_notificacion_sivigila`.`Id`)\nWHERE (`g_patologia_ficha_sivigila`.`IdPatologia` ='T630')) p,\t\n    `ingreso`\n    INNER JOIN `f_empresacontxconvenio` \t\n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_usuario` \t\n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_ips` \t\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\t\n    INNER JOIN `f_tiporegimen` \t\n        ON (`f_empresacontxconvenio`.`Id_TipoRegimen` = `f_tiporegimen`.`Id`)\n    INNER JOIN `h_atencion` \t\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `h_atenciondx` \t\n        ON (`h_atenciondx`.`Id_Atencion` = `h_atencion`.`Id`)\t\n    INNER JOIN `g_persona` AS `Profesional`\t\n        ON (`h_atencion`.`Id_Profesional` = `Profesional`.`Id`)\n    LEFT JOIN `g_patologia` \t\n        ON (`h_atenciondx`.`Id_Dx` = `g_patologia`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\t\n    INNER JOIN `g_poblacion_especial` \t\n        ON (`g_usuario`.`IdPoblacionEspecial` = `g_poblacion_especial`.`Id`)    \n    INNER JOIN `g_barrio` \t\n        ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n    INNER JOIN `g_tipo_etnia` \t\n        ON (`g_tipo_etnia`.`Id` = `g_persona`.`Id_Etnia`)\t\n    LEFT JOIN (SELECT g_municipio.`Id`, `g_pais`.`Nbre`, `g_pais`.`Codigo`, g_pais.Cod_ISO3166 codPaisNumero FROM  `g_municipio`\n        INNER JOIN `g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n        INNER JOIN `g_pais` \n        ON (`g_pais`.`Id` = `g_departamento`.`CodPais`)) Nacionalidad ON Nacionalidad.Id = `g_persona`.`Id_MunicipioNac`\n    LEFT JOIN (SELECT g_municipio.`Id`, CONCAT(`g_departamento`.`Nbre`,' - ',`g_municipio`.`Nbre`) AS MunicDept, g_pais.Cod_ISO3166 codPaisNumeroResidencia FROM  `g_municipio`\n        INNER JOIN `g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n        INNER JOIN `g_pais` \n        ON (`g_pais`.`Id` = `g_departamento`.`CodPais`)) Recidencia ON Recidencia.Id = `g_persona`.`Id_Municipio`    \n    LEFT JOIN (SELECT g_municipio.`Id`, `g_pais`.`Codigo`,  g_pais.Cod_ISO3166 codPaisNumeroOcurrencia , `g_pais`.`Nbre` AS Pais, CONCAT(`g_departamento`.`Nbre`,' - ',`g_municipio`.`Nbre`) AS MunicDept FROM  `g_municipio`\n        INNER JOIN `g_departamento` \n        ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n        INNER JOIN `g_pais` \n        ON (`g_pais`.`Id` = `g_departamento`.`CodPais`)) Ocurrencia ON Ocurrencia.Id = `g_ips`.`Id_Municipio`        \n    LEFT JOIN `h_egreso_atencion`\n       ON (`h_atencion`.`Id`= `h_egreso_atencion`.`Id_Atencion`) AND (`h_egreso_atencion`.`Estado`=1)  WHERE (`h_atencion`.`Id` =" + idAtencion + ");";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.PatologiaCie10DAO
    public List<Object[]> listReporteFichaSivigila(String nReporte) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Id"), rs.getString("Nbre"), rs.getString("Descripcion"), rs.getString("Url_Encabezado"), rs.getString("Url"), rs.getBytes("ArchivoSivigila"), rs.getString("Codigo")};
                return fila;
            }
        };
        this.sql = "SELECT\n      `g_fichas_notificacion_sivigila`.`Id`\n    , `g_fichas_notificacion_sivigila`.`Nbre`\n    , `g_fichas_notificacion_sivigila`.`Descripcion`\n    , `g_fichas_notificacion_sivigila`.`Url_Encabezado`\n    , `g_fichas_notificacion_sivigila`.`Url`\n    , `g_fichas_notificacion_sivigila`.`ArchivoSivigila`\n    , `g_fichas_notificacion_sivigila`.`Estado`\n    , `g_fichas_notificacion_sivigila`.`Codigo`\nFROM\n      `g_fichas_notificacion_sivigila`\nWHERE `g_fichas_notificacion_sivigila`.`Nbre` ='" + nReporte + "'";
        List<Object[]> list = this.jdbcTemplate.query(this.sql, mapper);
        return list;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/PatologiaCie10DAOImpl$PatologiaFiltro.class */
    private static final class PatologiaFiltro implements RowMapper<PatologiaCie10DTO> {
        private PatologiaFiltro() {
        }

        /* JADX INFO: renamed from: mapRow, reason: merged with bridge method [inline-methods] */
        public PatologiaCie10DTO m79mapRow(ResultSet rs, int rowNum) throws SQLException {
            PatologiaCie10DTO e = new PatologiaCie10DTO();
            e.setId(rs.getString("Id"));
            e.setNombre(rs.getString("Nbre"));
            e.setV4505(rs.getString("V4505"));
            e.setSexo(rs.getString("Sexo"));
            e.setLimiteInferior(Long.valueOf(rs.getLong("LimInf")));
            e.setLimiteSuperior(Long.valueOf(rs.getLong("LimSup")));
            e.setCapitulo(rs.getString("Capitulo"));
            e.setIdSubgrupo(Long.valueOf(rs.getLong("Id_SubGrupo")));
            e.setPathGuiaManejo(rs.getString("PathGuia"));
            e.setEsRecomendaciones(Boolean.valueOf(rs.getBoolean("esRecomendaciones")));
            return e;
        }
    }
}
