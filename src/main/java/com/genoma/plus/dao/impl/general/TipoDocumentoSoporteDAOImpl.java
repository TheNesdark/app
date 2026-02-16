package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoDocumentoSoporteDAO;
import com.genoma.plus.dto.general.TipoDocumentoSoporteDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoDocumentoSoporteDAOImpl.class */
public class TipoDocumentoSoporteDAOImpl implements TipoDocumentoSoporteDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoSoporteDAO
    public List<TipoDocumentoSoporteDTO> list() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoDocumentoSoporteDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoDocumentoSoporteDTO gen = new TipoDocumentoSoporteDTO();
                gen.setId(rs.getInt("Id"));
                gen.setNombre(rs.getString("Nbre"));
                gen.setNDias(rs.getInt("NDias"));
                gen.setEsEntregable(rs.getInt("Tipo"));
                gen.setEsContable(rs.getInt("EsContable"));
                gen.setEstado(rs.getInt("Estado"));
                return gen;
            }
        };
        List<TipoDocumentoSoporteDTO> lsGen = this.jdbcTemplate.query("SELECT `Id`, `Nbre`, `NDias`, `Tipo`, `EsContable`, `Estado` FROM `cc_tipo_documentos_soporte` ORDER BY `Nbre` ASC;", rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoSoporteDAO
    public String create(TipoDocumentoSoporteDTO gen) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `cc_tipo_documentos_soporte`(`Nbre`,`Tipo`,`EsContable`,`NDias`,`Estado`,`Id_UsuarioS`)\nVALUES (?,?,?,?,?,?);", new Object[]{gen.getNombre(), Integer.valueOf(gen.getEsEntregable()), Integer.valueOf(gen.getEsContable()), Integer.valueOf(gen.getNDias()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoSoporteDAO
    public String update(TipoDocumentoSoporteDTO gen) {
        String sql = "UPDATE cc_tipo_documentos_soporte SET `Nbre` = ?, `Tipo` = ?, `EsContable` = ?, `NDias` = ? , `Estado` = ?, `Id_UsuarioS` = ?  WHERE `Id` = ? ;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{gen.getNombre(), Integer.valueOf(gen.getEsEntregable()), Integer.valueOf(gen.getEsContable()), Integer.valueOf(gen.getNDias()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(gen.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoSoporteDAO
    public String delete(TipoDocumentoSoporteDTO gen) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoSoporteDAO
    public List<TipoDocumentoSoporteDTO> listaFiltradaTipo(Integer tipo) {
        String sql = "SELECT `Id`, `Nbre`, `NDias`, `Tipo`, `EsContable`, `Estado` FROM `cc_tipo_documentos_soporte` where Tipo=" + tipo + " ORDER BY `Nbre` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoDocumentoSoporteDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoDocumentoSoporteDTO gen = new TipoDocumentoSoporteDTO();
                gen.setId(rs.getInt("Id"));
                gen.setNombre(rs.getString("Nbre"));
                gen.setNDias(rs.getInt("NDias"));
                gen.setEsEntregable(rs.getInt("Tipo"));
                gen.setEsContable(rs.getInt("EsContable"));
                gen.setEstado(rs.getInt("Estado"));
                return gen;
            }
        };
        List<TipoDocumentoSoporteDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }
}
