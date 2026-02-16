package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.DetalleRevisionSistemasDAO;
import com.genoma.plus.dto.historia.DetalleRevisionSistemasDTO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/DetalleRevisionSistemasDAOImpl.class */
public class DetalleRevisionSistemasDAOImpl implements DetalleRevisionSistemasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.DetalleRevisionSistemasDAO
    public void mCrear(DetalleRevisionSistemasDTO e) {
        this.jdbcTemplate.update("INSERT INTO `h_detallerevisionsistemas` (`Id_RevisionSistemas` , `Id_TipoSistemas` , `Valor` , `Descripcion`)\nVALUES (?,?,?,?);", new Object[]{e.getIdRevisionSIstemas(), e.getIdTipoSistemas(), e.getValor(), e.getDescripcion()});
    }
}
