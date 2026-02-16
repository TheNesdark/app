package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.DetalleContenidoHCDAO;
import com.genoma.plus.dto.general.DetalleContenidoHCDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/DetalleContenidoHCDAOImpl.class */
public class DetalleContenidoHCDAOImpl implements DetalleContenidoHCDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.DetalleContenidoHCDAO
    public List<Object[]> listadoDetalleCHC() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.DetalleContenidoHCDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), Integer.valueOf(rs.getInt(4)), Boolean.valueOf(rs.getBoolean(5)), Integer.valueOf(rs.getInt(6)), rs.getString(7), Integer.valueOf(rs.getInt(8)), Integer.valueOf(rs.getInt(9)), Boolean.valueOf(rs.getBoolean(10))};
                return fila;
            }
        };
        List<Object[]> listadoDContenidoHC = this.jdbcTemplate.query("SELECT h_cniveluno.Id, h_cniveluno.Nbre, h_chistoria.Nbre, h_cniveluno.Orden, h_cniveluno.Sexo, h_cniveluno.Programa, IFNULL(`VDefecto`,'') AS VDefecto,`EdadI`,`EdadF`, h_cniveluno.Estado \n   FROM h_cniveluno INNER JOIN h_chistoria  ON (h_cniveluno.id_chistoria = h_chistoria.Id) ORDER BY h_chistoria.Nbre ASC, h_cniveluno.Orden ASC ", mapper);
        return listadoDContenidoHC;
    }

    @Override // com.genoma.plus.dao.general.DetalleContenidoHCDAO
    public String mCreate(DetalleContenidoHCDTO xDContenidoHC) {
        int ctos = this.jdbcTemplate.update("INSERT INTO  h_cniveluno(Nbre, id_chistoria, Orden, Sexo, Programa, `VDefecto`,`EdadI`,`EdadF`,Estado, UsuarioS) VALUES (?,?,?,?,?,?,?,?,?,?);", new Object[]{xDContenidoHC.getNombre(), Integer.valueOf(xDContenidoHC.getIdCHistoria()), Integer.valueOf(xDContenidoHC.getOrden()), Integer.valueOf(xDContenidoHC.getSexo()), Integer.valueOf(xDContenidoHC.getPrograma()), xDContenidoHC.getVPorDefecto(), Integer.valueOf(xDContenidoHC.getEdadI()), Integer.valueOf(xDContenidoHC.getEdadF()), Boolean.valueOf(xDContenidoHC.isEstado()), xDContenidoHC.getUsuario()});
        if (ctos == 0) {
        }
        return "Datos insertados";
    }

    @Override // com.genoma.plus.dao.general.DetalleContenidoHCDAO
    public String mUpdate(DetalleContenidoHCDTO xDContenidoHC) {
        String sql = "UPDATE `h_cniveluno` SET `Nbre` = ? ,`id_chistoria`= ? ,`Orden`= ? ,`Sexo`= ? ,`Programa`= ? ,`VDefecto`= ? ,`EdadI`= ? ,`EdadF`= ? ,`Estado`= ? ,`UsuarioS`= ? WHERE `Id`= ? ;";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{xDContenidoHC.getNombre(), Integer.valueOf(xDContenidoHC.getIdCHistoria()), Integer.valueOf(xDContenidoHC.getOrden()), Integer.valueOf(xDContenidoHC.getSexo()), Integer.valueOf(xDContenidoHC.getPrograma()), xDContenidoHC.getVPorDefecto(), Integer.valueOf(xDContenidoHC.getEdadI()), Integer.valueOf(xDContenidoHC.getEdadF()), Boolean.valueOf(xDContenidoHC.isEstado()), xDContenidoHC.getUsuario(), Integer.valueOf(xDContenidoHC.getId())});
        if (ctos == 0) {
            sql = "0 filas afectadas";
        }
        return sql;
    }
}
