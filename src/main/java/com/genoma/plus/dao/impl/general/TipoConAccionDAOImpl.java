package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoConAccionDAO;
import com.genoma.plus.dto.general.TipoConAccionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoConAccionDAOImpl.class */
public class TipoConAccionDAOImpl implements TipoConAccionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoConAccionDAO
    public List<TipoConAccionDTO> list() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoConAccionDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoConAccionDTO estr = new TipoConAccionDTO();
                estr.setId(rs.getInt("Id"));
                estr.setNombre(rs.getString("Nbre"));
                estr.setTipo(rs.getInt("Tipo"));
                estr.setNTipo(rs.getString("NTipo"));
                estr.setEstado(rs.getInt("Estado"));
                return estr;
            }
        };
        List<TipoConAccionDTO> lsEstrato = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `Tipo`, IF(`Tipo`=0,'CONSECUENCIAS',IF(`Tipo`=1,'CORRECTIVO INMEDIATO',IF(`Tipo`=2,'ACCIONES PREVENTIVAS',''))) AS NTipo, `Estado` FROM `s_sgc_sc_tipocosecuencia_acciones` ORDER BY `Nbre` ASC, `Tipo` ASC;", rowMapper);
        return lsEstrato;
    }

    @Override // com.genoma.plus.dao.general.TipoConAccionDAO
    public String create(TipoConAccionDTO tipo) {
        String result = "Se inserto correctamente";
        System.out.println(" Nbre-->" + tipo.getNombre() + " Tipo-->" + tipo.getTipo() + " est-->" + tipo.getEstado() + " UserS-->" + Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        int ctos = this.jdbcTemplate.update("INSERT INTO `s_sgc_sc_tipocosecuencia_acciones`(`Nbre`,`Tipo`,`Estado`,`Id_UsuarioS`) VALUES (?,?,?,?);", new Object[]{tipo.getNombre(), Integer.valueOf(tipo.getTipo()), Integer.valueOf(tipo.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.TipoConAccionDAO
    public String update(TipoConAccionDTO tipo) {
        String sql = "UPDATE `s_sgc_sc_tipocosecuencia_acciones` SET `Nbre` = ?,`Tipo` = ?,`Estado` = ?,`Id_UsuarioS` = ? WHERE `Id` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{tipo.getNombre(), Integer.valueOf(tipo.getTipo()), Integer.valueOf(tipo.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(tipo.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.TipoConAccionDAO
    public List<TipoConAccionDTO> listFiltroAcciones(String xBusqueda, int xTipo, String xidTriesgoE) {
        String sql;
        if (xTipo == 0) {
            sql = "SELECT `s_sgc_sc_tipocosecuencia_acciones`.`Nbre`, IF(`Tipo`=0,'CONSECUENCIAS',IF(`Tipo`=1,'ACCIONES CORRECTIVAS',IF(`Tipo`=2,'ACCIONES PREVENTIVAS',''))) AS `NTipo` FROM `s_sgc_sc_tipoevento_tipoca` INNER JOIN `s_sgc_sc_tipocosecuencia_acciones` ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`) INNER JOIN `s_sgc_sc_tipoevento` ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`) INNER JOIN `s_sgc_sc_triesgo_tevento`  ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`) WHERE (`s_sgc_sc_tipocosecuencia_acciones`.`Nbre` LIKE '%" + xBusqueda + "%' AND `s_sgc_sc_triesgo_tevento`.`Id` ='" + xidTriesgoE + "' AND `s_sgc_sc_tipocosecuencia_acciones`.`Estado` =1 AND `s_sgc_sc_tipocosecuencia_acciones`.`Tipo` =1) ORDER BY `NTipo` ASC;";
        } else {
            sql = "SELECT `s_sgc_sc_tipocosecuencia_acciones`.`Nbre`, IF(`Tipo`=0,'CONSECUENCIAS',IF(`Tipo`=1,'ACCIONES CORRECTIVAS',IF(`Tipo`=2,'ACCIONES PREVENTIVAS',''))) AS `NTipo` FROM `s_sgc_sc_tipoevento_tipoca` INNER JOIN `s_sgc_sc_tipocosecuencia_acciones` ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoCAccion` = `s_sgc_sc_tipocosecuencia_acciones`.`Id`) INNER JOIN `s_sgc_sc_tipoevento` ON (`s_sgc_sc_tipoevento_tipoca`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`) INNER JOIN `s_sgc_sc_triesgo_tevento`  ON (`s_sgc_sc_triesgo_tevento`.`Id_TipoEvento` = `s_sgc_sc_tipoevento`.`Id`) WHERE (`s_sgc_sc_tipocosecuencia_acciones`.`Nbre` LIKE '%" + xBusqueda + "%' AND `s_sgc_sc_triesgo_tevento`.`Id` ='" + xidTriesgoE + "' AND `s_sgc_sc_tipocosecuencia_acciones`.`Estado` =1 AND `s_sgc_sc_tipocosecuencia_acciones`.`Tipo`=" + xTipo + ") ORDER BY `NTipo` ASC;";
        }
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoConAccionDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoConAccionDTO estr = new TipoConAccionDTO();
                estr.setNombre(rs.getString("Nbre"));
                estr.setNTipo(rs.getString("NTipo"));
                return estr;
            }
        };
        List<TipoConAccionDTO> lsEstrato = this.jdbcTemplate.query(sql, rowMapper);
        return lsEstrato;
    }
}
