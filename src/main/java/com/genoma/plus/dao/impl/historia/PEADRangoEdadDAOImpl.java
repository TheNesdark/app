package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.PEADRangoEdadDAO;
import com.genoma.plus.dto.historia.PEADRangoEdadDTO;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/PEADRangoEdadDAOImpl.class */
public class PEADRangoEdadDAOImpl implements PEADRangoEdadDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.PEADRangoEdadDAO
    public List<PEADRangoEdadDTO> listaRangoEdad() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.historia.PEADRangoEdadDAO
    public String mCreate(PEADRangoEdadDTO rangoedad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.historia.PEADRangoEdadDAO
    public String mUpdate(PEADRangoEdadDTO rangoedad) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
