package com.genoma.plus.dao.impl.historia;

import Utilidades.Metodos;
import com.genoma.plus.dao.historia.RevisionSistemasDAO;
import com.genoma.plus.dto.historia.RevisionSistemasDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/RevisionSistemasDAOImpl.class */
public class RevisionSistemasDAOImpl implements RevisionSistemasDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.RevisionSistemasDAO
    public List<Object[]> listRevisionSistemas(String xIdAtencion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.RevisionSistemasDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Nbre"), rs.getString("Descripcion"), rs.getString("Id_TipoSistemas"), rs.getString("Id_RevisionSistemas"), rs.getString("VDefecto"), Boolean.valueOf(rs.getBoolean("Valor")), rs.getString("Observacion")};
                return fila;
            }
        };
        String xsql = "SELECT\n    `h_tiposistemas`.`Nbre`\n    , ifnull(`h_detallerevisionsistemas`.`Descripcion`, '')Descripcion   \n    , `h_detallerevisionsistemas`.`Id_TipoSistemas`\n    , `h_detallerevisionsistemas`.`Id_RevisionSistemas`, `h_tiposistemas`.`VDefecto`\n    , `Valor`    , IFNULL(`h_revisionsistemas`.`Observacion`,'') Observacion\n FROM\n     `h_detallerevisionsistemas`\n    INNER JOIN  `h_revisionsistemas` \n        ON (`h_detallerevisionsistemas`.`Id_RevisionSistemas` = `h_revisionsistemas`.`Id`)\n    INNER JOIN  `h_tiposistemas` \n        ON (`h_detallerevisionsistemas`.`Id_TipoSistemas` = `h_tiposistemas`.`Id`)\n    INNER JOIN  `h_gruposistemas` \n        ON (`h_tiposistemas`.`Id_GrupoSistemas` = `h_gruposistemas`.`Id`)\nWHERE (`h_revisionsistemas`.`Id_Atencion` ='" + xIdAtencion + "')\nORDER BY `h_tiposistemas`.`Orden` ASC";
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.RevisionSistemasDAO
    public void mUpdate(String[] xDato) {
        System.out.println("uno " + xDato[1]);
        System.out.println("dos " + xDato[2]);
        System.out.println("tres " + xDato[3]);
        this.jdbcTemplate.update("UPDATE h_detallerevisionsistemas SET `Descripcion`=?, `Valor` =?  WHERE (`Id_RevisionSistemas` =? AND `Id_TipoSistemas` =?)", new Object[]{xDato[1], xDato[4], xDato[2], xDato[3]});
    }

    @Override // com.genoma.plus.dao.historia.RevisionSistemasDAO
    public List<Object[]> listConfRevisionSistemas(String idTipoHistoria, String idAtencion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.RevisionSistemasDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Nbre"), rs.getString("Descripcion"), rs.getString("Id_TipoSistemas"), Long.valueOf(rs.getLong("Id_RevisionSistemas")), rs.getString("Observacion")};
                return fila;
            }
        };
        String xsql = "SELECT\n    `h_tiposistemas`.`Nbre`\n    , IF(D.Descripcion IS NULL, '', D.Descripcion) AS `Descripcion`\n    , `h_tiposistemas`.`Id` Id_TipoSistemas, ifnull(D.Id_RevisionSistemas,0) Id_RevisionSistemas\n    , `h_tiposistemas`.`VDefecto`\n,     IFNULL(D.`Observacion`,'') Observacion   \nFROM\n    `h_csistemaxtipohc`\n    INNER JOIN `h_tiposistemas` \n        ON (`h_csistemaxtipohc`.`Id_TipoSistema` = `h_tiposistemas`.`Id`)\n    INNER JOIN `h_gruposistemas` \n        ON (`h_tiposistemas`.`Id_GrupoSistemas` = `h_gruposistemas`.`Id`)\n    LEFT JOIN (SELECT\n     `h_detallerevisionsistemas`.`Descripcion`   \n    , `h_detallerevisionsistemas`.`Id_TipoSistemas`\n    , `h_detallerevisionsistemas`.`Id_RevisionSistemas`    , `h_revisionsistemas`.`Observacion`\nFROM\n     `h_detallerevisionsistemas`\n    INNER JOIN  `h_revisionsistemas` \n        ON (`h_detallerevisionsistemas`.`Id_RevisionSistemas` = `h_revisionsistemas`.`Id`)\nWHERE (`h_revisionsistemas`.`Id_Atencion` ='" + idAtencion + "')) D ON (D.Id_TipoSistemas=`h_tiposistemas`.`Id`)\t\t\n        \nWHERE (`h_csistemaxtipohc`.`Id_TipoHc` ='" + idTipoHistoria + "')\nORDER BY `h_tiposistemas`.`Orden` ASC;";
        System.out.println("revision sistemas : " + xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.RevisionSistemasDAO
    public Long mCrear(final RevisionSistemasDTO e) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.RevisionSistemasDAOImpl.3
            final String SQL_INSERT = "INSERT INTO `h_revisionsistemas` (`Id_Atencion` , `Fecha` , `UsuarioS`)\nVALUES (?,?,?);";

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_revisionsistemas` (`Id_Atencion` , `Fecha` , `UsuarioS`)\nVALUES (?,?,?);", 1);
                ps.setLong(1, e.getIdAtencion().longValue());
                ps.setString(2, e.getFecha());
                ps.setString(3, e.getNUsuario());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        Long idRevision = Long.valueOf(generatedKeyHolder.getKey().longValue());
        return idRevision;
    }

    @Override // com.genoma.plus.dao.historia.RevisionSistemasDAO
    public void mCrearObservacion(String observacion, long idRevision) {
        System.out.println("Actualizo la observacion a:" + observacion);
        this.jdbcTemplate.update("UPDATE `h_revisionsistemas` SET `Observacion` = ? WHERE `Id`=?;", new Object[]{observacion, Long.valueOf(idRevision)});
    }
}
