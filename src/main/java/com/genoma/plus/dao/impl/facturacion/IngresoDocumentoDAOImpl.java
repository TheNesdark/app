package com.genoma.plus.dao.impl.facturacion;

import Acceso.Principal;
import com.genoma.plus.dao.facturacion.IngresoDocumentoDAO;
import com.genoma.plus.dto.facturacion.IngresoDocumentoDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/IngresoDocumentoDAOImpl.class */
public class IngresoDocumentoDAOImpl implements IngresoDocumentoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoDocumentoDAO
    public List<IngresoDocumentoDTO> mListar(Long xidingreso) {
        String sql = "SELECT     `ingreso_documento`.`Id`     , `g_tipo_documento_soporte`.`Nbre`     , `ingreso_documento`.`Ruta`     , `ingreso_documento`.`Estado` FROM     `ingreso_documento`     INNER JOIN `g_tipo_documento_soporte`          ON (`ingreso_documento`.`IdTipoDoc` = `g_tipo_documento_soporte`.`Id`) WHERE (`ingreso_documento`.`Id_Ingreso` ='" + xidingreso + "') ORDER BY `ingreso_documento`.`Id` DESC;";
        System.out.println("listar sopotes -> " + sql);
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoDocumentoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                IngresoDocumentoDTO evidencia = new IngresoDocumentoDTO();
                evidencia.setId(rs.getInt("Id"));
                evidencia.setIdTipoDoc(rs.getString("Nbre"));
                evidencia.setRuta(rs.getString("Ruta"));
                evidencia.setEstado(rs.getInt("Estado"));
                return evidencia;
            }
        };
        List<IngresoDocumentoDTO> lsTipo = this.jdbcTemplate.query(sql, rowMapper);
        return lsTipo;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoDocumentoDAO
    public List<GCGenericoDTO> mTipoDocumento() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoDocumentoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `g_tipo_documento_soporte` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoDocumentoDAO
    public String create_return_id(final IngresoDocumentoDTO evidencia) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.facturacion.IngresoDocumentoDAOImpl.3
            final String sql = "INSERT INTO `ingreso_documento`  (`Id_Ingreso`,   `IdTipoDoc`,   `Estado`,   `UsuarioS`) VALUES (?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `ingreso_documento`  (`Id_Ingreso`,   `IdTipoDoc`,   `Estado`,   `UsuarioS`) VALUES (?,?,?,?);", 1);
                ps.setLong(1, evidencia.getIdIngreso().longValue());
                ps.setString(2, evidencia.getIdTipoDoc());
                ps.setInt(3, evidencia.getEstado());
                ps.setString(4, Principal.usuarioSistemaDTO.getLogin());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdIngresoDoc = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xEvidencia-->" + xIdIngresoDoc);
        return xIdIngresoDoc;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoDocumentoDAO
    public String mUpdate(IngresoDocumentoDTO xevidencia) {
        String sql = "UPDATE `ingreso_documento`\nSET `Estado` = ?,  `UsuarioS` = ? WHERE `Id` = ?";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xevidencia.getEstado()), Principal.usuarioSistemaDTO.getLogin(), Integer.valueOf(xevidencia.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoDocumentoDAO
    public String mUpdateRuta(IngresoDocumentoDTO xevidencia) {
        String sql = "UPDATE ingreso_documento set Ruta= ? WHERE Id= ? ";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xevidencia.getRuta(), Integer.valueOf(xevidencia.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.facturacion.IngresoDocumentoDAO
    public String mDelete(IngresoDocumentoDTO xevidencia) {
        String sql = "DELETE\nFROM\n  `baseserver`.`ingreso_documento`\nWHERE `Id` = ?";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xevidencia.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
