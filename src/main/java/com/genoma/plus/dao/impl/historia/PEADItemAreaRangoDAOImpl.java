package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.PEADItemAreaRangoDAO;
import com.genoma.plus.dto.historia.PEADItemAreaRangoDTO;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/PEADItemAreaRangoDAOImpl.class */
public class PEADItemAreaRangoDAOImpl implements PEADItemAreaRangoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.PEADItemAreaRangoDAO
    public List<PEADItemAreaRangoDTO> listaItemAreasRango() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.historia.PEADItemAreaRangoDAO
    public String mCreate(PEADItemAreaRangoDTO itemAreaRango) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.historia.PEADItemAreaRangoDAO
    public String mUpdate(PEADItemAreaRangoDTO itemAreaRango) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
