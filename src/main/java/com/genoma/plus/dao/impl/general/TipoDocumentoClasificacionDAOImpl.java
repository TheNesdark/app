package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.TipoDocumentoClasificacionDAO;
import com.genoma.plus.dto.general.TipoDocumentoClasificacionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoDocumentoClasificacionDAOImpl.class */
public class TipoDocumentoClasificacionDAOImpl implements TipoDocumentoClasificacionDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoClasificacionDAO
    public List<TipoDocumentoClasificacionDTO> listTipoDocumentoClasificacion() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoDocumentoClasificacionDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoDocumentoClasificacionDTO Clasificacion = new TipoDocumentoClasificacionDTO();
                Clasificacion.setId(Long.valueOf(rs.getLong("Id")));
                Clasificacion.setNombre(rs.getString("Nbre"));
                Clasificacion.setOperacion(rs.getString("Operacion"));
                Clasificacion.setEstado(rs.getInt("Estado"));
                return Clasificacion;
            }
        };
        List<TipoDocumentoClasificacionDTO> lsEstrato = this.jdbcTemplate.query("SELECT\n    `Id`\n    , `Nbre`\n    , IF(`Operacion`=0,'SUMA',IF(`Operacion`=1,'RESTA','NO APLICA')) AS Operacion\n    , `Estado`\nFROM\n    `cc_tipo_documento_clasificacion`\nORDER BY `Nbre` ASC;", rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoClasificacionDAO
    public String mCreate(TipoDocumentoClasificacionDTO xClasificacion) {
        String sql = "insert into `cc_tipo_documento_clasificacion` (`Nbre`,`Operacion`,`Estado`,`Id_UsuarioRh`)\nvalues(?,?,?,?);";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xClasificacion.getNombre(), xClasificacion.getOperacion(), Integer.valueOf(xClasificacion.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            sql = "No se inserto";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoClasificacionDAO
    public String mUpdate(TipoDocumentoClasificacionDTO xClasificacion) {
        String sql = "UPDATE\n  `cc_tipo_documento_clasificacion`\nSET\n  `Nbre` = ?,\n  `Operacion` = ?,\n  `Estado` = ?,\n  `Id_UsuarioRh` = ?\nWHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xClasificacion.getNombre(), xClasificacion.getOperacion(), Integer.valueOf(xClasificacion.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), xClasificacion.getId()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
