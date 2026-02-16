package com.genoma.plus.dao.impl.pyp;

import com.genoma.plus.dao.pyp.TomaMuestraCitologiaDAO;
import com.genoma.plus.dto.pyp.CitologiaSeguimientoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/pyp/TomaMuestraCitologiaDAOImpl.class */
public class TomaMuestraCitologiaDAOImpl implements TomaMuestraCitologiaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.pyp.TomaMuestraCitologiaDAO
    public List<Object[]> listaTomaMuestra(Long xIdToma) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.pyp.TomaMuestraCitologiaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[21];
                fila[0] = Long.valueOf(rs.getLong(1));
                fila[1] = Boolean.valueOf(rs.getBoolean(2));
                fila[2] = Boolean.valueOf(rs.getBoolean(3));
                fila[3] = Boolean.valueOf(rs.getBoolean(4));
                fila[4] = Boolean.valueOf(rs.getBoolean(5));
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                fila[8] = rs.getString(9);
                fila[9] = rs.getString(10);
                fila[10] = rs.getString(11);
                fila[11] = rs.getString(12);
                fila[12] = rs.getString(13);
                fila[13] = rs.getString(14);
                fila[14] = Boolean.valueOf(rs.getBoolean(15));
                fila[15] = Boolean.valueOf(rs.getBoolean(16));
                fila[16] = Boolean.valueOf(rs.getBoolean(17));
                fila[17] = rs.getString(18);
                fila[18] = rs.getString(19);
                fila[19] = rs.getString(20);
                fila[21] = Long.valueOf(rs.getLong("idRecepcion"));
                return fila;
            }
        };
        String sql = "SELECT\n    `p_citologia`.`Id`\n    , `p_citologia`.`R_Pregunta1`\n    , `p_citologia`.`R_Pregunta2`\n    , `p_citologia`.`R_Pregunta3`\n    , `p_citologia`.`Tomada`\n    , IFNULL(`p_citologia`.`Observacion`, '')Observacion\n    , `FactorRiesgo`.`Nbre` AS `FRiesgo`\n    , `AntecedentePatologicos`.`Nbre` AS `AntecedentesPatologicos`\n    , `CVaCervix`.`Nbre` AS `VaCervix`\n    , `VGardacil`.`Nbre` AS `VGardacil`\n    , `p_citologiaesquema`.`Nbre` AS `Esquema`\n    , IFNULL(`p_citologia`.`AspectoCuello`, '')AspectoCuello\n    , IFNULL(`p_citologia`.`TtoHormanales`, '')TtoHormanales\n    , IFNULL(`p_citologia`.`Detalle`, '')Detalle\n    , `p_citologia`.`PrimerVez`\n    , `p_citologia`.`Lactancia`\n    , `p_citologia`.`Embarazada`\n    , `p_citologia`.`NombreQuienTomaCitologia`\n    , `p_citologia`.`CargoQuienTomaCitologia`\n    ,`p_citologia`.`FechaToma`, p_citologia.Id_Recepcion  idRecepcion\nFROM\n     `p_citologia`\n    INNER JOIN  `p_tipo_respuestas_c` AS `FactorRiesgo` \n        ON (`p_citologia`.`Id_FRiesgo` = `FactorRiesgo`.`Id`)\n    INNER JOIN  `p_tipo_respuestas_c` AS `AntecedentePatologicos` \n        ON (`AntecedentePatologicos`.`Id` = `p_citologia`.`Id_APatologicos`)\n    INNER JOIN  `p_tipo_respuestas_c` AS `CVaCervix` \n        ON (`CVaCervix`.`Id` = `p_citologia`.`Id_VCaCervix`)\n    INNER JOIN  `p_tipo_respuestas_c` AS `VGardacil` \n        ON (`VGardacil`.`Id` = `p_citologia`.`Id_VGardasil`)\n    INNER JOIN  `p_citologiaesquema` \n        ON (`p_citologia`.`Id_Esquema` = `p_citologiaesquema`.`Id`)\nWHERE (`p_citologia`.`Id` ='" + xIdToma + "' AND p_citologia.`Estado`=0);";
        System.out.println("sql : " + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.pyp.TomaMuestraCitologiaDAO
    public List<Object[]> listaSeguimiento(Long xIdToma) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.pyp.TomaMuestraCitologiaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Fecha"), rs.getString("TipoSeguimiento"), rs.getString("Observacion"), rs.getString("NCargo"), rs.getString("NResponsable")};
                return fila;
            }
        };
        String sql = "SELECT\n    `p_citologia_seguimiento`.`Id`\n    , `p_citologia_seguimiento`.`Fecha`\n    , `p_citologia_tiposeguimiento`.`Nbre` TipoSeguimiento\n    , `p_citologia_seguimiento`.`Observacion`\n    , `rh_tipo_cargo`.`Nbre` NCargo\n    , CONCAT(`g_persona`.`Apellido1` , ' ',`g_persona`.`Apellido2`, ' ',`g_persona`.`Nombre1`, ' ',`g_persona`.`Nombre2`) NResponsable\nFROM\n     `p_citologia_seguimiento`\n    INNER JOIN  `p_citologia_tiposeguimiento` \n        ON (`p_citologia_seguimiento`.`Id_TipoSeguimiento` = `p_citologia_tiposeguimiento`.`Id`)\n    INNER JOIN  `rh_tipo_persona_cargon` \n        ON (`rh_tipo_persona_cargon`.`Id` = `p_citologia_seguimiento`.`IdUsuarioRh`)\n    INNER JOIN  `g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN  `rh_unidadf_cargo` \n        ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)\n    INNER JOIN  `rh_tipo_cargo` \n        ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`)\n        WHERE (p_citologia_seguimiento.Id_Citologia='" + xIdToma + "' AND p_citologia_seguimiento.`Estado`=1)";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.pyp.TomaMuestraCitologiaDAO
    public String createSeguimiento(CitologiaSeguimientoDTO e) {
        String result = "Se Insertó Correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `p_citologia_seguimiento`(`Id_Citologia` , `Id_TipoSeguimiento` , `Fecha` , `Observacion` , `IdUsuarioRh`)\nVALUES (?,?,?,?,?);", new Object[]{Long.valueOf(e.getIdCitologia()), Long.valueOf(e.getIdTipoSeguimiento()), e.getFecha(), e.getObservacion(), Long.valueOf(e.getIdUsuarioRh())});
        if (ctos == 0) {
            result = "No se insertó";
        }
        return result;
    }
}
