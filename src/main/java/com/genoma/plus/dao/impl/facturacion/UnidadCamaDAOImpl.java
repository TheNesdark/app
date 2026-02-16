package com.genoma.plus.dao.impl.facturacion;

import com.genoma.plus.dao.facturacion.UnidadCamaDAO;
import com.genoma.plus.dto.facturacion.UnidadCamaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/UnidadCamaDAOImpl.class */
public class UnidadCamaDAOImpl implements UnidadCamaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.UnidadCamaDAO
    public List<Object[]> listaUnidadCama() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.UnidadCamaDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), Boolean.valueOf(rs.getBoolean(3)), Integer.valueOf(rs.getInt(4)), rs.getString(5), Boolean.valueOf(rs.getBoolean(6))};
                return fila;
            }
        };
        List<Object[]> listaUnidadCama = this.jdbcTemplate.query("SELECT\n    `f_unidadcama`.`Id`\n    , `f_unidadcama`.`Nbre`\n    , `f_unidadcama`.`EsHosp`\n    , `f_unidadcama`.`idTipoAtencion`\n    , `g_tipoatencion`.`Nbre`\n    , `f_unidadcama`.`Estado`\nFROM\n    `baseserver`.`g_tipoatencion`\n    INNER JOIN `baseserver`.`f_unidadcama` \n        ON (`g_tipoatencion`.`Id` = `f_unidadcama`.`idTipoAtencion`);", rowMapper);
        return listaUnidadCama;
    }

    @Override // com.genoma.plus.dao.facturacion.UnidadCamaDAO
    public String mCreate(UnidadCamaDTO unidadCamadDTO) {
        String resultado = "Se inserto correctamente ";
        int ctos = this.jdbcTemplate.update("INSERT INTO `f_unidadcama` (`Nbre`,`EsHosp`,`idTipoAtencion`,`Estado`,`UsuarioS`) VALUES(?,?,?,?,?);", new Object[]{unidadCamadDTO.getNombre(), Boolean.valueOf(unidadCamadDTO.isEsHospitalizacion()), Integer.valueOf(unidadCamadDTO.getTipoAtencion()), Boolean.valueOf(unidadCamadDTO.isEstado()), unidadCamadDTO.getUsuario()});
        if (ctos == 0) {
            resultado = "No se pudo Insertar Correctamente";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.facturacion.UnidadCamaDAO
    public String mUpdate(UnidadCamaDTO unidadCamaDTO) {
        String resultado = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `f_unidadcama` SET `Nbre`=?,`EsHosp`=?,`idTipoAtencion`=?,`Estado`=?,`UsuarioS`=? WHERE `Id`=?;", new Object[]{unidadCamaDTO.getNombre(), Boolean.valueOf(unidadCamaDTO.isEsHospitalizacion()), Integer.valueOf(unidadCamaDTO.getTipoAtencion()), Boolean.valueOf(unidadCamaDTO.isEstado()), unidadCamaDTO.getUsuario(), Integer.valueOf(unidadCamaDTO.getId())});
        if (ctos == 0) {
            resultado = "No se actualizo correctamente";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.facturacion.UnidadCamaDAO
    public List<Object[]> listaTipoAtencion() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.UnidadCamaDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = new Object[6];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                return fila;
            }
        };
        List<Object[]> listaTipoAtencion = this.jdbcTemplate.query("SELECT `Id`,`Nbre` FROM `g_tipoatencion` ;", rowMapper);
        return listaTipoAtencion;
    }
}
