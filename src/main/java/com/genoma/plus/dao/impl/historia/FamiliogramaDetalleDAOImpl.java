package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.FamiliogramaDetalleDAO;
import com.genoma.plus.dto.historia.FamiliogramaDetalleDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/FamiliogramaDetalleDAOImpl.class */
public class FamiliogramaDetalleDAOImpl implements FamiliogramaDetalleDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleDAO
    public List<Object[]> lisdatoFDetalle(int idFamiliograma) {
        String sql = "SELECT\n                    `h_familiogrma_detalle`.`Id`\n                    , `h_familiogrma_detalle`.`Id_Familiograma`\n                    , `h_familiogrma_detalle`.`Nombre`\n                    , `h_familiogrma_detalle`.`Id_Parentesco`\n                    , `g_parentesco`.`Nbre`\n                    , `h_familiogrma_detalle`.`Id_Sexo`\n                    , `g_sexo`.`Nbre`\n                    , `h_familiogrma_detalle`.`Edad`\n                    , `h_familiogrma_detalle`.`Vive`\n                    , `h_familiogrma_detalle`.`Ocupacion`\n                    , `h_familiogrma_detalle`.`esPaciente`\n                    , `h_familiogrma_detalle`.`esEmbarazada`\n                    , `h_familiogrma_detalle`.`IdEstadoCivil` \n                    , `g_estadocivil`.`Nbre`\n                    , `h_familiogrma_detalle`.`esEmbarazada`\n                    , `h_familiogrma_detalle`.`esAdoptado`                    , `h_familiogrma_detalle`.`esGemelo`                    , `h_familiogrma_detalle`.`Estado`                    , `h_familiogrma_detalle`.`TipoDeTiempo`\n                FROM\n                    `h_familiogrma_detalle`\n                    INNER JOIN `g_sexo` \n                        ON (`h_familiogrma_detalle`.`Id_Sexo` = `g_sexo`.`Id`)\n                    INNER JOIN `g_parentesco` \n                        ON (`h_familiogrma_detalle`.`Id_Parentesco` = `g_parentesco`.`Id`) \n                    INNER JOIN `g_estadocivil`\n                    ON  (`h_familiogrma_detalle`.`IdEstadoCivil` = `g_estadocivil`.`Id`)\n                        WHERE `h_familiogrma_detalle`.`Estado` = 1 AND `h_familiogrma_detalle`.`Id_Familiograma` = " + idFamiliograma + ";";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaDetalleDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), rs.getString(3), Integer.valueOf(rs.getInt(4)), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), Boolean.valueOf(rs.getBoolean(9)), rs.getString(10), Boolean.valueOf(rs.getBoolean(11)), Boolean.valueOf(rs.getBoolean(12)), Integer.valueOf(rs.getInt(13)), rs.getString(14), Boolean.valueOf(rs.getBoolean(15)), Boolean.valueOf(rs.getBoolean(16)), Boolean.valueOf(rs.getBoolean(17)), Boolean.valueOf(rs.getBoolean(18)), rs.getString(19)};
                return fila;
            }
        };
        List<Object[]> listadoDetalle = this.jdbcTemplate.query(sql, mapper);
        return listadoDetalle;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleDAO
    public int mCreate(final FamiliogramaDetalleDTO xFDetalle) {
        PreparedStatementCreator psc = new PreparedStatementCreator() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaDetalleDAOImpl.2
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO `h_familiogrma_detalle` (`Id_Familiograma`,`Nombre`,`Id_Parentesco`,`Id_Sexo`,`Edad`,`Vive`,`Ocupacion`,`IdEstadoCivil`,`esPaciente`,`esEmbarazada`,`Estado`,`esAdoptado`,`esGemelo`,`idUsuario`,`TipoDeTiempo`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", 1);
                ps.setInt(1, xFDetalle.getIdFamiliograma());
                ps.setString(2, xFDetalle.getNombre());
                ps.setInt(3, xFDetalle.getIdParentesco());
                ps.setString(4, xFDetalle.getIdSexo());
                ps.setString(5, xFDetalle.getEdad());
                ps.setBoolean(6, xFDetalle.isVive());
                ps.setString(7, xFDetalle.getOcupacion());
                ps.setInt(8, xFDetalle.getIdestadoCivil());
                ps.setBoolean(9, xFDetalle.isEsPaciente());
                ps.setBoolean(10, xFDetalle.isEsEmbarazada());
                ps.setBoolean(11, xFDetalle.isEstado());
                ps.setBoolean(12, xFDetalle.isEsAdoptado());
                ps.setBoolean(13, xFDetalle.isEsGemelo());
                ps.setString(14, xFDetalle.getUsuario());
                ps.setString(15, xFDetalle.getTipoTiempoEdad());
                return ps;
            }
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(psc, generatedKeyHolder);
        int idDetalle = generatedKeyHolder.getKey().intValue();
        return idDetalle;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleDAO
    public String mUpdate(FamiliogramaDetalleDTO xFDetalle) {
        String sql = "UPDATE `h_familiogrma_detalle` SET `Id_Familiograma`= ?,`Nombre`= ?,`Id_Parentesco`= ?,`Id_Sexo`= ?,`Edad`= ?,`Vive`= ?,`Ocupacion`= ?,`IdEstadoCivil` = ?,`Estado`= ?,`Fecha`= ?,`idUsuario`= ? WHERE `Id`= ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(xFDetalle.getIdFamiliograma()), xFDetalle.getNombre(), Integer.valueOf(xFDetalle.getIdParentesco()), xFDetalle.getIdSexo(), xFDetalle.getEdad(), Boolean.valueOf(xFDetalle.isVive()), xFDetalle.getOcupacion(), Integer.valueOf(xFDetalle.getIdestadoCivil()), Boolean.valueOf(xFDetalle.isEstado()), xFDetalle.getFecha(), xFDetalle.getUsuario(), Integer.valueOf(xFDetalle.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas ";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleDAO
    public List<Object[]> TraerIds(String sql) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaDetalleDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> ids = this.jdbcTemplate.query(sql, mapper);
        return ids;
    }

    public int traerId(int idAtencion) {
        String str = "SELECT `Id`  FROM `h_familiograma_encabezado` WHERE `Id_Atencion` = " + idAtencion;
        return 0;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleDAO
    public List<Object[]> traerfamilia(int id) {
        String sql = "SELECT     `h_familiogrma_detalle`.`Id`     , `h_familiogrma_detalle`.`Id_Familiograma`, `h_familiogrma_detalle`.`Nombre`,`h_familiogrma_detalle`.`Id_Parentesco` ,`g_parentesco`.`Nbre`,`h_familiogrma_detalle`.`Id_Sexo`,`g_sexo`.`Nbre`,`h_familiogrma_detalle`.`Edad` ,`h_familiogrma_detalle`.`Vive`,`h_familiogrma_detalle`.`Ocupacion`, `h_familiogrma_detalle`.`IdEstadoCivil`,`h_familiograma_encabezado`.`esPaciente`, `h_familiograma_encabezado`.`esEmbarazada`,`h_familiogrma_detalle`.`Estado`,`h_familiogrma_detalle`.`esAdoptado`,`h_familiogrma_detalle`.`esGemelo`FROM     `h_familiogrma_detalle` INNER JOIN `g_sexo` ON (`h_familiogrma_detalle`.`Id_Sexo` = `g_sexo`.`Id`)INNER JOIN `g_parentesco` ON (`h_familiogrma_detalle`.`Id_Parentesco` = `g_parentesco`.`Id`)WHERE `h_familiogrma_detalle`.`Id_Familiograma` = " + id + ";";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaDetalleDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), rs.getString(3), Integer.valueOf(rs.getInt(4)), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), Boolean.valueOf(rs.getBoolean(9)), rs.getString(10), rs.getString(11), Boolean.valueOf(rs.getBoolean(12)), Boolean.valueOf(rs.getBoolean(13)), Boolean.valueOf(rs.getBoolean(14)), Boolean.valueOf(rs.getBoolean(15)), Boolean.valueOf(rs.getBoolean(16))};
                return fila;
            }
        };
        List<Object[]> listadoFamilia = this.jdbcTemplate.query(sql, mapper);
        return listadoFamilia;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleDAO
    public List<Object[]> DatosPaciente(long idPaciente) {
        String sql = "SELECT\n                     `g_persona`.`Id`\n                    ,`g_persona`.`Nombre1`\n                    ,`g_persona`.`Id_Sexo`\n                    ,`g_persona`.`Edad`\n                    , `g_persona`.`Id_EstadoCivil`\n                    , `g_usuario`.`IdPoblacionEspecial`                     , g_tipoedad.`Nbre` as tipoEdad \n                FROM\n                    `g_usuario`\n                    INNER JOIN `g_persona` \n                         ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n                    INNER JOIN g_tipoedad                           ON (g_tipoedad.`Id` = `g_persona`.`Id_TipoEdad`)                  WHERE (`g_persona`.`Id` =" + idPaciente + ");";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.FamiliogramaDetalleDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), Integer.valueOf(rs.getInt(5)), Integer.valueOf(rs.getInt(6)), rs.getString(7)};
                return fila;
            }
        };
        System.out.println("ffff" + sql);
        List<Object[]> Paciente = this.jdbcTemplate.query(sql, mapper);
        return Paciente;
    }

    @Override // com.genoma.plus.dao.historia.FamiliogramaDetalleDAO
    public String anularDetalle(int idFamiliograma) {
        String sql = "UPDATE `h_familiogrma_detalle` SET `Estado` = 0 WHERE `Id_Familiograma` = ?; ";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(idFamiliograma)});
        if (ctos == 0) {
            sql = "0 filas afectadas ";
        }
        return sql;
    }
}
