package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.TipoHistoriaDAO;
import com.genoma.plus.dto.historia.TipoHistoriaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/TipoHistoriaDAOImpl.class */
public class TipoHistoriaDAOImpl implements TipoHistoriaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.TipoHistoriaDAO
    public List<Object[]> listaTHistoria() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.TipoHistoriaDAOImpl.1
            public Object mapRow(ResultSet rs, int row) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), Boolean.valueOf(rs.getBoolean(3)), Boolean.valueOf(rs.getBoolean(4)), Boolean.valueOf(rs.getBoolean(5)), rs.getString(6), Boolean.valueOf(rs.getBoolean(7))};
                return fila;
            }
        };
        List<Object[]> listaTHistoria = this.jdbcTemplate.query("SELECT `Id`,`Nbre`,`Aplica`,`Estado`,`Expandir`,`Reporte`, Forma FROM `h_tipohistoria` ORDER BY Nbre ASC", mapper);
        return listaTHistoria;
    }

    @Override // com.genoma.plus.dao.historia.TipoHistoriaDAO
    public String mCreate(TipoHistoriaDTO xTipoHistoriaDTO) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `h_tipohistoria` (`Nbre`,`Aplica`,`Estado`,`Expandir`,`Reporte`,Forma,`UsuarioS`) VALUES (?,?,?,?,?,?,?);", new Object[]{xTipoHistoriaDTO.getNombre(), Boolean.valueOf(xTipoHistoriaDTO.isAplica()), Boolean.valueOf(xTipoHistoriaDTO.isEstado()), Boolean.valueOf(xTipoHistoriaDTO.isExpandir()), xTipoHistoriaDTO.getReporte(), Boolean.valueOf(xTipoHistoriaDTO.isForma()), xTipoHistoriaDTO.getUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.historia.TipoHistoriaDAO
    public String mUpdate(TipoHistoriaDTO xTipoHistoriaDTO) {
        String result = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `h_tipohistoria` SET `Nbre`=?,`Aplica`=?,`Estado`=?,`Expandir`=?,`Reporte`=?,`Forma`=?,`UsuarioS`=? WHERE `Id`=?;", new Object[]{xTipoHistoriaDTO.getNombre(), Boolean.valueOf(xTipoHistoriaDTO.isAplica()), Boolean.valueOf(xTipoHistoriaDTO.isEstado()), Boolean.valueOf(xTipoHistoriaDTO.isExpandir()), xTipoHistoriaDTO.getReporte(), Boolean.valueOf(xTipoHistoriaDTO.isForma()), xTipoHistoriaDTO.getUsuario(), Integer.valueOf(xTipoHistoriaDTO.getId())});
        if (ctos == 0) {
            result = "0 filas afectadas";
        }
        return result;
    }
}
