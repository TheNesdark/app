package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoDocumentoFiltroSoporteDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.TipoDocumentoFiltroSoporteDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoDocumentoFiltroSoporteDAOImpl.class */
public class TipoDocumentoFiltroSoporteDAOImpl implements TipoDocumentoFiltroSoporteDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoFiltroSoporteDAO
    public List<TipoDocumentoFiltroSoporteDTO> list() {
        String sql = "SELECT `cc_tipo_documentos_soporte`.`Nbre`, `cc_tipo_documento_filtro_soporte`.`NOrden`, `cc_tipo_documento_filtro_soporte`.`Estado`\nFROM `cc_tipo_documento_filtro_soporte` INNER JOIN `cc_tipo_documentos_soporte` ON (`cc_tipo_documento_filtro_soporte`.`Id_TipoDocSoporte` = `cc_tipo_documentos_soporte`.`Id`)\nWHERE (`cc_tipo_documento_filtro_soporte`.`Id_TipoDoc` ='" + Principal.txtNo.getText() + "') ORDER BY `cc_tipo_documento_filtro_soporte`.`NOrden` ASC;";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoDocumentoFiltroSoporteDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoDocumentoFiltroSoporteDTO gen = new TipoDocumentoFiltroSoporteDTO();
                gen.setIdTipoDocS(rs.getString("Nbre"));
                gen.setNOrden(rs.getInt("NOrden"));
                gen.setEstado(rs.getInt("Estado"));
                return gen;
            }
        };
        List<TipoDocumentoFiltroSoporteDTO> lsGen = this.jdbcTemplate.query(sql, rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoFiltroSoporteDAO
    public String create(TipoDocumentoFiltroSoporteDTO gen) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `cc_tipo_documento_filtro_soporte`(`Id_TipoDoc`,`Id_TipoDocSoporte`,`NOrden`,`Estado`,`Id_UsuariosRh`)\nVALUES (?,?,?,?,?);", new Object[]{Integer.valueOf(gen.getIdTipoDocF()), gen.getIdTipoDocS(), Integer.valueOf(gen.getNOrden()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoFiltroSoporteDAO
    public String update(TipoDocumentoFiltroSoporteDTO gen) {
        String sql = "UPDATE `cc_tipo_documento_filtro_soporte`\nSET `NOrden` = ?,\n  `Estado` = ?,\n  `Id_UsuariosRh` = ?\nWHERE `Id_TipoDoc` = ?\n    AND `Id_TipoDocSoporte` = ?;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{Integer.valueOf(gen.getNOrden()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdPersonaCargo(), Integer.valueOf(gen.getIdTipoDocF()), gen.getIdTipoDocS()});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoFiltroSoporteDAO
    public String delete(TipoDocumentoFiltroSoporteDTO gen) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoFiltroSoporteDAO
    public List<GCGenericoDTO> listaSoporte() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoDocumentoFiltroSoporteDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query("SELECT `Id`, `Nbre` FROM `cc_tipo_documentos_soporte` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;", mapper);
        return list;
    }
}
