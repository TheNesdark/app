package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ValeCondicionesEstructuralesDAO;
import com.genoma.plus.dto.historia.ValeCondicionesEstructuralesDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ValeCondicionesEstructuralesDAOImpl.class */
public class ValeCondicionesEstructuralesDAOImpl implements ValeCondicionesEstructuralesDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ValeCondicionesEstructuralesDAO
    public List<Object[]> listaValeCondicionesEstructurales(int idAtencion) {
        String sql;
        if (idAtencion == 0) {
            sql = "SELECT\n    `h_vale_condiciones_estructurales`.`id`\n    , `h_vale_condiciones_estructurales`.`id_atencion`\n    , `h_p_vale_estructuras`.`id`\n    , `h_p_vale_estructuras`.`condicion_estructurales`\n    , IFNULL(`h_vale_condiciones_estructurales`.`presencia`,1) AS presencia\n    , IFNULL(`h_vale_condiciones_estructurales`.`integridad`,1) AS integridad\nFROM\n    `baseserver`.`h_p_vale_estructuras`\n    LEFT JOIN `baseserver`.`h_vale_condiciones_estructurales` \n        ON (`h_p_vale_estructuras`.`id` = `h_vale_condiciones_estructurales`.`id_estructura`)        AND(`h_vale_condiciones_estructurales`.`id_atencion` = " + idAtencion + ")";
        } else {
            sql = "SELECT\n    `h_vale_condiciones_estructurales`.`id`\n    , `h_vale_condiciones_estructurales`.`id_atencion`\n    , `h_p_vale_estructuras`.`id`\n    , `h_p_vale_estructuras`.`condicion_estructurales`\n    , IFNULL(`h_vale_condiciones_estructurales`.`presencia`,0) AS presencia\n    , IFNULL(`h_vale_condiciones_estructurales`.`integridad`,0) AS integridad\nFROM\n    `baseserver`.`h_p_vale_estructuras`\n    LEFT JOIN `baseserver`.`h_vale_condiciones_estructurales` \n        ON (`h_p_vale_estructuras`.`id` = `h_vale_condiciones_estructurales`.`id_estructura`)\n        WHERE(`h_vale_condiciones_estructurales`.`id_atencion` =" + idAtencion + ");";
        }
        System.out.println("este es el listado --------------------------------------------------------------------------------------------> " + sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ValeCondicionesEstructuralesDAOImpl.1
            public Object mapRow(ResultSet rs, int row) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), Integer.valueOf(rs.getInt(3)), rs.getString(4), Boolean.valueOf(rs.getBoolean(5)), Boolean.valueOf(rs.getBoolean(6))};
                return fila;
            }
        };
        List<Object[]> listaValeCondicionesEstructurales = this.jdbcTemplate.query(sql, mapper);
        return listaValeCondicionesEstructurales;
    }

    @Override // com.genoma.plus.dao.historia.ValeCondicionesEstructuralesDAO
    public String mCreate(ValeCondicionesEstructuralesDTO valeCondicionesEstructuralesDTO) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_vale_condiciones_estructurales` (`id_atencion`,`id_estructura`,`presencia`,`integridad`,`estado`,`id_usuario`) VALUES (?,?,?,?,?,?);", new Object[]{Integer.valueOf(valeCondicionesEstructuralesDTO.getIdAtencion()), Integer.valueOf(valeCondicionesEstructuralesDTO.getIdEstructura()), Boolean.valueOf(valeCondicionesEstructuralesDTO.isPresencia()), Boolean.valueOf(valeCondicionesEstructuralesDTO.isIntegridad()), Boolean.valueOf(valeCondicionesEstructuralesDTO.isEstado()), Long.valueOf(valeCondicionesEstructuralesDTO.getIdUsuario())});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------> INSERT INTO `h_vale_condiciones_estructurales` (`id_atencion`,`id_estructura`,`presencia`,`integridad`,`estado`,`id_usuario`) VALUES (?,?,?,?,?,?);");
        return result;
    }

    @Override // com.genoma.plus.dao.historia.ValeCondicionesEstructuralesDAO
    public String mUpdate(ValeCondicionesEstructuralesDTO valeCondicionesEstructuralesDTO) {
        String result = "Se Actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_vale_condiciones_estructurales` SET `id_atencion`= ?,`id_estructura`= ?,`presencia`= ?,`integridad`= ?,`id_usuario`= ?,`estado`= ?,`fecha`= ? WHERE `id`= ?", new Object[]{Integer.valueOf(valeCondicionesEstructuralesDTO.getIdAtencion()), Integer.valueOf(valeCondicionesEstructuralesDTO.getIdEstructura()), Boolean.valueOf(valeCondicionesEstructuralesDTO.isPresencia()), Boolean.valueOf(valeCondicionesEstructuralesDTO.isIntegridad()), Long.valueOf(valeCondicionesEstructuralesDTO.getIdUsuario()), Boolean.valueOf(valeCondicionesEstructuralesDTO.isEstado()), valeCondicionesEstructuralesDTO.getFecha(), Integer.valueOf(valeCondicionesEstructuralesDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }
}
