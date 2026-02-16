package com.genoma.plus.dao.impl.contabilidad;

import com.genoma.plus.dao.contabilidad.TipodeInformesDAO;
import com.genoma.plus.dto.contabilidad.TipoDeInformeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/contabilidad/TipodeInformesDAOImpl.class */
public class TipodeInformesDAOImpl implements TipodeInformesDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.contabilidad.TipodeInformesDAO
    public List<TipoDeInformeDTO> listaTInformes() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.TipodeInformesDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                TipoDeInformeDTO fila = new TipoDeInformeDTO();
                fila.setId(rs.getInt(1));
                fila.setNombre(rs.getString(2));
                fila.setXtipo(rs.getInt(3));
                fila.setEstado(rs.getBoolean(4));
                return fila;
            }
        };
        List<TipoDeInformeDTO> listaPucDInforme = this.jdbcTemplate.query("SELECT `Id`,`Nbre`,`Tipo`,`Estado` FROM `cc_tipo_informes`;", mapper);
        return listaPucDInforme;
    }

    @Override // com.genoma.plus.dao.contabilidad.TipodeInformesDAO
    public String mCreate(TipoDeInformeDTO xInformeDTO) {
        String result = " Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `cc_tipo_informes` (`Nbre`,`Tipo`,`Estado`,`IdUsuario`) VALUES (?,?,?,?);", new Object[]{xInformeDTO.getNombre(), Boolean.valueOf(xInformeDTO.isEstado()), xInformeDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.contabilidad.TipodeInformesDAO
    public String mUpdate(TipoDeInformeDTO xInformeDTO) {
        String result = " Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `cc_tipo_informes` SET `Nbre` =?,`Tipo`= ?,`Estado` = ?,`IdUsuario` = ? WHERE `Id` =?;", new Object[]{xInformeDTO.getNombre(), Boolean.valueOf(xInformeDTO.isEstado()), Integer.valueOf(xInformeDTO.getXtipo()), xInformeDTO.getIdUsuario(), Long.valueOf(xInformeDTO.getId())});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }
}
