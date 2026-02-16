package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.DetalleExamenFisicoDAO;
import com.genoma.plus.dto.historia.DetalleExamenFisicoNDTO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/DetalleExamenFisicoDAOImpl.class */
public class DetalleExamenFisicoDAOImpl implements DetalleExamenFisicoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.DetalleExamenFisicoDAO
    public void mCrear(DetalleExamenFisicoNDTO e) {
        this.jdbcTemplate.update("INSERT INTO `h_examenfisico_detalle` (`Id_ExamenFisico` , `Id_GrupoExamenF` , `Observacion` , `Estado` , `Fecha`)\nVALUES (?,?,?,?,?);", new Object[]{e.getIdExamenFisico(), e.getIdGrupoExamen(), e.getObservacion(), Boolean.valueOf(e.isEstado()), e.getFecha()});
    }

    @Override // com.genoma.plus.dao.historia.DetalleExamenFisicoDAO
    public void mActualizar(DetalleExamenFisicoNDTO e) {
        this.jdbcTemplate.update("Update h_examenfisico_detalle set `Observacion`=?\n   where Id=?", new Object[]{e.getObservacion(), e.getId()});
    }
}
