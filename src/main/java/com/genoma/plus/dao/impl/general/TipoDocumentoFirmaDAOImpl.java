package com.genoma.plus.dao.impl.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoDocumentoFirmaDAO;
import com.genoma.plus.dto.general.TipoDocumentoFirmaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/TipoDocumentoFirmaDAOImpl.class */
public class TipoDocumentoFirmaDAOImpl implements TipoDocumentoFirmaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoFirmaDAO
    public List<TipoDocumentoFirmaDTO> list() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.TipoDocumentoFirmaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                TipoDocumentoFirmaDTO gen = new TipoDocumentoFirmaDTO();
                gen.setId(rs.getInt("Id"));
                gen.setNombre(rs.getString("Nbre"));
                gen.setTipo(rs.getString("Tipo"));
                gen.setPrefijo(rs.getString("Prefijo"));
                gen.setNDias(rs.getInt("NDias"));
                gen.setEstado(rs.getInt("Estado"));
                return gen;
            }
        };
        List<TipoDocumentoFirmaDTO> lsGen = this.jdbcTemplate.query("SELECT `Id`,`Nbre`,IF(`Tipo`=4,'OTROSI',IF(`Tipo`=3,'CONTRATO',IF(`Tipo`=2,'SERVICIO','COMPRA'))) AS Tipo,`Prefijo`,`NDias`,`Estado` FROM `cc_tipo_documentof` ORDER BY Nbre ASC", rowMapper);
        return lsGen;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoFirmaDAO
    public String create(TipoDocumentoFirmaDTO gen) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `cc_tipo_documentof`(`Nbre`,`Prefijo`,`Tipo`, NDias,`Estado`,`UsuarioS`) VALUES (?, ?, ?, ?, ?, ?);", new Object[]{gen.getNombre(), gen.getPrefijo(), gen.getTipo(), Integer.valueOf(gen.getNDias()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema()});
        if (ctos == 0) {
            result = "No se inserto";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoFirmaDAO
    public String update(TipoDocumentoFirmaDTO gen) {
        String sql = "UPDATE cc_tipo_documentof SET `Nbre` = ?, `Prefijo` = ?, `Tipo` = ?, `NDias` = ? , `Estado` = ?, `UsuarioS` = ?  WHERE `Id` = ? ;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{gen.getNombre(), gen.getPrefijo(), gen.getTipo(), Integer.valueOf(gen.getNDias()), Integer.valueOf(gen.getEstado()), Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Integer.valueOf(gen.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }

    @Override // com.genoma.plus.dao.general.TipoDocumentoFirmaDAO
    public String delete(TipoDocumentoFirmaDTO gen) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
