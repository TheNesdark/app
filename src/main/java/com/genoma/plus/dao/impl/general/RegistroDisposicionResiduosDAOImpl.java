package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.general.RegistroDisposicionResiduosDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.RegistroDisposicionResiduosDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/RegistroDisposicionResiduosDAOImpl.class */
public class RegistroDisposicionResiduosDAOImpl implements RegistroDisposicionResiduosDAO {
    private JdbcTemplate jdbcTemplate;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.RegistroDisposicionResiduosDAO
    public List<RegistroDisposicionResiduosDTO> listaRegistroDisposicionResiduos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.general.RegistroDisposicionResiduosDAO
    public List<RegistroDisposicionResiduosDTO> listaRegistroDetalleResiduos(int xidRegistroResiduo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.general.RegistroDisposicionResiduosDAO
    public String create_return_id(final RegistroDisposicionResiduosDTO xResiduo) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.general.RegistroDisposicionResiduosDAOImpl.1
            final String sql = "INSERT INTO `s_sgc_r_registro_disposicion_residuos` (`FechaR`,`IdTercero`,`Observacion`,`IdTerceroRh`, `IdUsuarioS`)\nVALUES (?,?,?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `s_sgc_r_registro_disposicion_residuos` (`FechaR`,`IdTercero`,`Observacion`,`IdTerceroRh`, `IdUsuarioS`)\nVALUES (?,?,?,?,?);", 1);
                ps.setString(1, xResiduo.getFecha());
                ps.setString(2, xResiduo.getIdTercero());
                ps.setString(3, xResiduo.getObservacion());
                ps.setLong(4, Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue());
                ps.setString(5, Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdRegistroResiduo = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdRegistroResiduo-->" + xIdRegistroResiduo);
        return xIdRegistroResiduo;
    }

    @Override // com.genoma.plus.dao.general.RegistroDisposicionResiduosDAO
    public String createDetalleResiduo(RegistroDisposicionResiduosDTO xResiduo) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_r_registro_detalle_disposicion_residuos` (`Id_RDisposicion`,`Id_TipoClasificacion`,`Cantidad`)\nVALUES(?,?,?);", new Object[]{xResiduo.getIdRDisposicion(), xResiduo.getIdTipoClasificacion(), Integer.valueOf(xResiduo.getCantidad())});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.RegistroDisposicionResiduosDAO
    public List<GCGenericoDTO> listaClasificacionResiduos() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.RegistroDisposicionResiduosDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `s_sgc_r_tipo_clasificacion` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.general.RegistroDisposicionResiduosDAO
    public List<GCGenericoDTO> listaTerceros() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.RegistroDisposicionResiduosDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("RazonSocialCompleta"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, IF((`g_empresa`.`Id_TipoIdentificacion` = 'NI'),`g_empresa`.`Nbre`,CONCAT(`g_empresa`.`Apellido1`,' ',`g_empresa`.`Apellido2`,' ',`g_empresa`.`Nombre1`,' ',`g_empresa`.`Nombre2`)) AS `RazonSocialCompleta` FROM `g_empresa` WHERE (`Estado` =1 AND EsManejoResiduos=1) ORDER BY `RazonSocialCompleta` ASC;", mapper);
        return list;
    }
}
