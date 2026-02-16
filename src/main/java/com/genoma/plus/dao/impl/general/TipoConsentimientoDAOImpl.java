package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.dao.general.TipoConsentimientoDAO;
import com.genoma.plus.dto.general.InfoCalidadReportes;
import com.genoma.plus.dto.general.TipoConcentimientoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoConsentimientoDAOImpl.class */
public class TipoConsentimientoDAOImpl implements TipoConsentimientoDAO {
    private JdbcTemplate jdbcTemplate;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos metodos = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoConsentimientoDAO
    public List<TipoConcentimientoDTO> listTipoConcentimiento() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoConsentimientoDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoConcentimientoDTO Complicacion = new TipoConcentimientoDTO();
                Complicacion.setId(rs.getInt("Id"));
                Complicacion.setNombre(rs.getString("Nbre"));
                Complicacion.setEncabezado(rs.getString("Encabezado"));
                Complicacion.setNota(rs.getString("Nota1"));
                Complicacion.setPiePagina(rs.getString("PiePagina"));
                Complicacion.setEstado(rs.getInt("Estado"));
                Complicacion.setRequiereFirma(Boolean.valueOf(rs.getBoolean("requiereFirma")));
                InfoCalidadReportes calidadReportes = InfoCalidadReportes.builder().build();
                if (rs.getString("metaData") != null) {
                    calidadReportes = (InfoCalidadReportes) TipoConsentimientoDAOImpl.this.metodos.getDeserializeJson(rs.getString("metaData"), InfoCalidadReportes.class);
                }
                Complicacion.setInfoCalidadReportes(calidadReportes);
                return Complicacion;
            }
        };
        List<TipoConcentimientoDTO> lsEstrato = this.jdbcTemplate.query("SELECT\n    `Id`\n    , `Nbre`\n    , IFNULL(`Encabezado`,'') Encabezado\n    , IFNULL(`Nota1`,'') Nota1\n    , IFNULL(`PiePagina`,'') PiePagina\n    , `Estado`, metaData, requiereFirma\nFROM\n    `h_tipoconsentimiento`\nORDER BY `Nbre` ASC;", rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.general.TipoConsentimientoDAO
    public String mCreatetipoConcentimiento(TipoConcentimientoDTO xConcentimiento) {
        String sql = "INSERT INTO `h_tipoconsentimiento` (`Nbre`,`Encabezado`,`Nota1`,`PiePagina`,`Estado`,`UsuarioS`, metaData, requiereFirma)\nVALUES(?,?,?,?,?,?, ?, ?);";
        try {
            String metaData = this.metodos.getMapper().writeValueAsString(xConcentimiento.getInfoCalidadReportes());
            int ctos = this.jdbcTemplate.update(sql, new Object[]{xConcentimiento.getNombre(), xConcentimiento.getEncabezado(), xConcentimiento.getNota(), xConcentimiento.getPiePagina(), Integer.valueOf(xConcentimiento.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), metaData, xConcentimiento.getRequiereFirma()});
            if (ctos == 0) {
                sql = "No se inserto";
            }
            return sql;
        } catch (JsonProcessingException e) {
            Logger.getLogger(TipoConsentimientoDAOImpl.class.getName()).log(Level.SEVERE, (String) null, e);
            return sql;
        }
    }

    @Override // com.genoma.plus.dao.general.TipoConsentimientoDAO
    public String mUpdatetipoConcentimiento(TipoConcentimientoDTO xConcentimiento) {
        String sql = null;
        try {
            String metaData = this.metodos.getMapper().writeValueAsString(xConcentimiento.getInfoCalidadReportes());
            sql = "UPDATE\n  `h_tipoconsentimiento`\nSET\n  `Nbre` = ?,\n  `Encabezado` = ?,\n  `Nota1` = ?,\n  `PiePagina` = ?,\n  `Estado` = ?,\n  `metaData` = ?,\n  `requiereFirma` = ?,\n  `UsuarioS` = ?\nWHERE `Id` = ?;";
            int ctos = this.jdbcTemplate.update(sql, new Object[]{xConcentimiento.getNombre(), xConcentimiento.getEncabezado(), xConcentimiento.getNota(), xConcentimiento.getPiePagina(), Integer.valueOf(xConcentimiento.getEstado()), metaData, xConcentimiento.getRequiereFirma(), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Long.valueOf(xConcentimiento.getId())});
            if (ctos == 0) {
                sql = "0 filas afectadas";
            }
        } catch (JsonProcessingException e) {
            Logger.getLogger(TipoConsentimientoDAOImpl.class.getName()).log(Level.SEVERE, (String) null, e);
        }
        return sql;
    }
}
