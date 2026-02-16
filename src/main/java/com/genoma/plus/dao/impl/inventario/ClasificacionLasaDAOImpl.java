package com.genoma.plus.dao.impl.inventario;

import com.genoma.plus.dao.inventario.ClasificacionLasaDAO;
import com.genoma.plus.dto.inventario.ClasificacionLasaDTO;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/inventario/ClasificacionLasaDAOImpl.class */
public class ClasificacionLasaDAOImpl implements ClasificacionLasaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.inventario.ClasificacionLasaDAO
    public List<ClasificacionLasaDTO> listaClasificacionLasa() {
        BeanPropertyRowMapper bprm = new BeanPropertyRowMapper(ClasificacionLasaDTO.class);
        List<ClasificacionLasaDTO> listaClasificacionesLasa = this.jdbcTemplate.query("SELECT `Id`,`Nombre`,`Observacion`,`MAlerta`,`color`,`Estado` FROM `i_clasif_lasa`", bprm);
        return listaClasificacionesLasa;
    }

    @Override // com.genoma.plus.dao.inventario.ClasificacionLasaDAO
    public String crearClasificacionLasa(ClasificacionLasaDTO clasificacionLasaDTO) {
        String resultado = "Se inserto correctamente ";
        int conteo = this.jdbcTemplate.update("INSERT INTO `i_clasif_lasa` (`Nombre`,`Observacion`,`MAlerta`,`color`,`Estado`,`UsuarioS`) VALUES (?,?,?,?,?,?);", new Object[]{clasificacionLasaDTO.getNombre(), clasificacionLasaDTO.getObservacion(), clasificacionLasaDTO.getMAlerta(), clasificacionLasaDTO.getColor(), Boolean.valueOf(clasificacionLasaDTO.isEstado()), clasificacionLasaDTO.getUsuarioSistema()});
        if (conteo == 0) {
            resultado = "No se pudo insertar correctamente ";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.inventario.ClasificacionLasaDAO
    public String actualizarClasificacionLasa(ClasificacionLasaDTO clasificacionLasaDTO) {
        String resultado = "Se actualizo correctamente ";
        int conteo = this.jdbcTemplate.update("UPDATE `i_clasif_lasa` SET `Nombre`= ?,`Observacion`=?,`MAlerta`=?,`color`=?,`Estado`=?,`UsuarioS`=? WHERE `Id`=?;", new Object[]{clasificacionLasaDTO.getNombre(), clasificacionLasaDTO.getObservacion(), clasificacionLasaDTO.getMAlerta(), clasificacionLasaDTO.getColor(), Boolean.valueOf(clasificacionLasaDTO.isEstado()), clasificacionLasaDTO.getUsuarioSistema(), Integer.valueOf(clasificacionLasaDTO.getId())});
        if (conteo == 0) {
            resultado = "No se pudo actualizar correctamente ";
        }
        return resultado;
    }
}
