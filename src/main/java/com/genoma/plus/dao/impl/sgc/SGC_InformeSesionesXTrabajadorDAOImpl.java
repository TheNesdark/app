package com.genoma.plus.dao.impl.sgc;

import com.genoma.plus.dao.sgc.SGC_InformeSesionesXTrabajadorDAO;
import com.genoma.plus.dto.sgc.SGC_InformeSesionesXTrabajadorDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sgc/SGC_InformeSesionesXTrabajadorDAOImpl.class */
public class SGC_InformeSesionesXTrabajadorDAOImpl implements SGC_InformeSesionesXTrabajadorDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sgc.SGC_InformeSesionesXTrabajadorDAO
    public List<SGC_InformeSesionesXTrabajadorDTO> cargarBusqueda(String fechaI, String fechaF) {
        String sql = "SELECT  `h_atencionf`.`Id` AS Id_Atencion\n    , `h_atencionf`.`FechaHc`\n    , `h_atencionf`.`Cie10`\n    , `g_patologia`.`Nbre` AS Patologia\n    , `g_persona`.`NoDocumento`\n    ,CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS Persona\n    , COUNT(h_seguimientof.`Id`) AS CantidadSesiones\n    , c_clasecita.`Nbre` AS ClaseCita \nFROM\n   `h_atencionf`\n    INNER JOIN`g_usuario` \n        ON (`h_atencionf`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN`c_clasecita` \n        ON (`h_atencionf`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN`profesional1` \n        ON (`profesional1`.`Id_Persona` = `h_atencionf`.`Id_Profesional`) \n        AND (`profesional1`.`IdEspecialidad` = `h_atencionf`.`Id_Especialidad`)\n    INNER JOIN`h_seguimientof` \n        ON (`h_seguimientof`.`Id_AtencionF` = `h_atencionf`.`Id`)\n    INNER JOIN`g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN`g_patologia` \n        ON (`h_atencionf`.`Cie10` = `g_patologia`.`Id`)\nWHERE (`g_usuario_fpz`.`Id_Parentesco` =1 AND h_seguimientof.`FechaS`>='" + fechaI + "' \nAND h_seguimientof.`FechaS`<='" + fechaF + "' AND  g_usuario_fpz.`Id_Empresa`=1)\nGROUP BY h_seguimientof.`Id_AtencionF`;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sgc.SGC_InformeSesionesXTrabajadorDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                SGC_InformeSesionesXTrabajadorDTO SesionTrab = new SGC_InformeSesionesXTrabajadorDTO();
                SesionTrab.setId_Atencion(rs.getString("Id_Atencion"));
                SesionTrab.setFechaHc(rs.getString("FechaHc"));
                SesionTrab.setCie10(rs.getString("Cie10"));
                SesionTrab.setPatologia(rs.getString("Patologia"));
                SesionTrab.setNoDocumento(rs.getString("NoDocumento"));
                SesionTrab.setPersona(rs.getString("Persona"));
                SesionTrab.setCant_Sesiones(rs.getString("CantidadSesiones"));
                SesionTrab.setClaseCita(rs.getString("ClaseCita"));
                return SesionTrab;
            }
        };
        List<SGC_InformeSesionesXTrabajadorDTO> lstSesiones = this.jdbcTemplate.query(sql, rowMapper);
        return lstSesiones;
    }
}
