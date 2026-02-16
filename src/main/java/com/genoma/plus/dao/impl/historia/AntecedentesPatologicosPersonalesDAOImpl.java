package com.genoma.plus.dao.impl.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.AntecedentesPatologicosPersonalesDAO;
import com.genoma.plus.dto.historia.AntecedentesPatologicosPersonalesDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/AntecedentesPatologicosPersonalesDAOImpl.class */
public class AntecedentesPatologicosPersonalesDAOImpl implements AntecedentesPatologicosPersonalesDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesPatologicosPersonalesDAO
    public List<AntecedentesPatologicosPersonalesDTO> listaAntecedentesAtencion(String idAtencion, String idUsuario, String idTipoHistoria, String sexo, String fechaAtencion, String fechaNacimiento) {
        String sql = "SELECT `h_tipoantecpatologico`.`Id` , `h_tipoantecpatologico`.`Nbre` , IFNULL(`f`.`Observacion`, '')Observacion , IFNULL(`f`.`Id`,0 ) IdAtecedente , IF((" + idAtencion + "=IFNULL(`f`.`Id_Atencion`,0))," + idAtencion + ",0) IdAtencion, h_tipoantecpatologico.`NOrden`, h_tipoantecpatologico.VDefecto FROM `h_tipoantecpatologico` INNER JOIN h_tipoantecpatologicos_historia ON (`h_tipoantecpatologicos_historia`.`Id_TipoAntecedentesP` = `h_tipoantecpatologico`.`Id`) LEFT JOIN ( SELECT h_antecedentepatologico.`Id`, h_antecedentepatologico.`Id_Atencion`, h_antecedentepatologico.`Id_tipoantecpatologico`, h_antecedentepatologico.`Id_Usuario` , h_antecedentepatologico.`Observacion` FROM `h_antecedentepatologico` WHERE (h_antecedentepatologico.`Id_Atencion`=" + idAtencion + ") ) f ON (f.Id_tipoantecpatologico=h_tipoantecpatologico.`Id`) WHERE h_tipoantecpatologico.Estado=0 and `h_tipoantecpatologicos_historia`.`IdTipoHistoria` =" + idTipoHistoria + "     AND `h_tipoantecpatologico`.`idSexo` IN('A','" + sexo + "')\n    AND DATEDIFF('" + fechaAtencion + "', '" + fechaNacimiento + "')>=`h_tipoantecpatologico`.`edadDiasInicio` \n    AND  DATEDIFF('" + fechaAtencion + "', '" + fechaNacimiento + "')<=`h_tipoantecpatologico`.`edadDiasFin`\nORDER BY `h_tipoantecpatologico`.`NOrden` ASC, `h_tipoantecpatologico`.`Nbre` ASC";
        System.out.println("antecedente : " + sql);
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.AntecedentesPatologicosPersonalesDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                AntecedentesPatologicosPersonalesDTO g = new AntecedentesPatologicosPersonalesDTO();
                g.setIdTipoAntecedente(Long.valueOf(rs.getLong("Id")));
                g.setNombreAntecedente(rs.getString("Nbre"));
                g.setObservacion(rs.getString("Observacion"));
                g.setId(Long.valueOf(rs.getLong("IdAtecedente")));
                g.setIdAtencion(Long.valueOf(rs.getLong("IdAtencion")));
                g.setValorDefecto(rs.getString("VDefecto"));
                return g;
            }
        };
        List<AntecedentesPatologicosPersonalesDTO> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesPatologicosPersonalesDAO
    public String mCreate(final AntecedentesPatologicosPersonalesDTO antecedentePPersonales) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.AntecedentesPatologicosPersonalesDAOImpl.2
            final String SQL_INSERT = "INSERT INTO `h_antecedentepatologico` (\n  `Id_Usuario` , `Id_tipoantecpatologico` , `Id_Atencion` , `Observacion` , `Fecha` , `UsuarioS`\n) VALUES (?,?,?,?,?,?) ;";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_antecedentepatologico` (\n  `Id_Usuario` , `Id_tipoantecpatologico` , `Id_Atencion` , `Observacion` , `Fecha` , `UsuarioS`\n) VALUES (?,?,?,?,?,?) ;", 1);
                ps.setLong(1, antecedentePPersonales.getIdUsuario().longValue());
                ps.setLong(2, antecedentePPersonales.getIdTipoAntecedente().longValue());
                ps.setLong(3, antecedentePPersonales.getIdAtencion().longValue());
                ps.setString(4, antecedentePPersonales.getObservacion());
                ps.setString(5, AntecedentesPatologicosPersonalesDAOImpl.this.xmt.formatoAMDH24.format(AntecedentesPatologicosPersonalesDAOImpl.this.xmt.getFechaActual()));
                ps.setString(6, Principal.usuarioSistemaDTO.getLogin());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        String xIdAntReuma = String.valueOf(generatedKeyHolder.getKey().longValue());
        System.out.println("xIdAntReuma --> " + xIdAntReuma);
        return xIdAntReuma;
    }

    @Override // com.genoma.plus.dao.historia.AntecedentesPatologicosPersonalesDAO
    public String mUpdate(AntecedentesPatologicosPersonalesDTO antecedentePPersonales) {
        String resultado = "Se actualizÓ Correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_antecedentepatologico` SET `Observacion` = ?, Fecha=? WHERE `Id` = ? ;", new Object[]{antecedentePPersonales.getObservacion(), this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()), antecedentePPersonales.getId()});
        if (ctos == 0) {
            resultado = "No se actualizó";
        }
        return resultado;
    }
}
