package com.genoma.plus.dao.impl.gestiondoc;

import com.genoma.plus.dao.gestiondoc.AtencionesManualesDAO;
import com.genoma.plus.dto.gestiondoc.AtencionesManualesDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/gestiondoc/AtencionManualesDAOImpl.class */
public class AtencionManualesDAOImpl implements AtencionesManualesDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.gestiondoc.AtencionesManualesDAO
    public String mCreate(AtencionesManualesDTO xAtencionesManualesDTO) {
        String result = "registro insertado correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_atencionesmanuales` (`Id_Usuario`,`Fecha_Atencion`,`Id_TipoDoc`,`Id_Especialidad`,`Id_Profesional`,`Url`,`Estado`,`UsuarioS`)VALUES (?,?,?,?,?,?,?,?);", new Object[]{xAtencionesManualesDTO.getIdUsuario(), xAtencionesManualesDTO.getFechaAtencion(), xAtencionesManualesDTO.getIdTipoDoc(), xAtencionesManualesDTO.getIdEspecialidad(), xAtencionesManualesDTO.getIdProfesional(), xAtencionesManualesDTO.getUrl(), Boolean.valueOf(xAtencionesManualesDTO.isEstado()), xAtencionesManualesDTO.getUsuarioS()});
        System.out.println("ejercicio INSERT INTO `h_atencionesmanuales` (`Id_Usuario`,`Fecha_Atencion`,`Id_TipoDoc`,`Id_Especialidad`,`Id_Profesional`,`Url`,`Estado`,`UsuarioS`)VALUES (?,?,?,?,?,?,?,?);");
        if (ctos == 0) {
            result = " No se pudo insertar el registro";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.gestiondoc.AtencionesManualesDAO
    public String mUpdate(AtencionesManualesDTO xAtencionesManualesDTO) {
        String sql = "UPDATE `h_atencionesmanuales` SET `Id_Usuario` =?,`Fecha_Atencion`=?,`Id_TipoDoc`=?,`Id_Especialidad`=?,`Id_Profesional`=?,`Url`=?,`Estado`=?,`UsuarioS`=?WHERE `Id` =?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xAtencionesManualesDTO.getIdUsuario(), xAtencionesManualesDTO.getFechaAtencion(), xAtencionesManualesDTO.getIdTipoDoc(), xAtencionesManualesDTO.getIdEspecialidad(), xAtencionesManualesDTO.getIdProfesional(), xAtencionesManualesDTO.getUrl(), Boolean.valueOf(xAtencionesManualesDTO.isEstado()), xAtencionesManualesDTO.getUsuarioS(), xAtencionesManualesDTO.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.gestiondoc.AtencionesManualesDAO
    public List<Object[]> validacion(String xidAtencion) {
        String sql = "SELECT\n    `ingreso`.`Id_Usuario`\n    , `h_atencion`.`Fecha_Atencion`\n    , `h_atencion`.`Id_Profesional`\n    , `h_atencion`.`Id_Especialidad`\n    , 1 AS `TidoDocuemtno`\nFROM\n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Id` =" + xidAtencion + ");";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.gestiondoc.AtencionManualesDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), Long.valueOf(rs.getLong(3)), Long.valueOf(rs.getLong(4)), Integer.valueOf(rs.getInt(5))};
                return fila;
            }
        };
        List<Object[]> listadoValidacion = this.jdbcTemplate.query(sql, mapper);
        return listadoValidacion;
    }
}
