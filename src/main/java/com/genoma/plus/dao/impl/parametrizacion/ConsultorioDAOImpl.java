package com.genoma.plus.dao.impl.parametrizacion;

import com.genoma.plus.dao.parametrizacion.ConsultorioDAO;
import com.genoma.plus.dto.parametrizacion.ConsultorioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/parametrizacion/ConsultorioDAOImpl.class */
public class ConsultorioDAOImpl implements ConsultorioDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.parametrizacion.ConsultorioDAO
    public List<Object[]> listConsultorios() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.ConsultorioDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[7];
                fila[0] = Integer.valueOf(rs.getInt(1));
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = Boolean.valueOf(!rs.getBoolean(6));
                fila[6] = rs.getString("sede");
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT c_consultorio.Id, c_claseconsultorio.Nbre, c_consultorio.Nbre, IFNULL(`c_consultorio`.`Ubicacion`, '') AS Ubicacion, IFNULL(`c_consultorio`.`Observacion`, '') AS Observacion, c_consultorio.Estado, g_sedes.Nbre sede FROM c_consultorio INNER JOIN c_claseconsultorio ON (c_consultorio.Id_ClaseCons = c_claseconsultorio.Id) INNER JOIN g_sedes ON (c_consultorio.idSede = g_sedes.Id) ORDER BY c_claseconsultorio.Nbre ASC, c_consultorio.Nbre ASC ", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.parametrizacion.ConsultorioDAO
    public List<Object[]> listClaseConsultorios() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.ConsultorioDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT `c_claseconsultorio`.`Id`, `c_claseconsultorio`.`Nbre` FROM `c_claseconsultorio`", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.parametrizacion.ConsultorioDAO
    public void addConsultorio(ConsultorioDTO consultorioDTO) {
        this.jdbcTemplate.update(" Insert into `c_consultorio`(`Nbre`, `Ubicacion`, `Id_ClaseCons`,`Observacion`, `Estado`, `Fecha`, `UsuarioS`, idSede) VALUES (?,?,?,?,?,?,?, ?)", new Object[]{consultorioDTO.getNbre(), consultorioDTO.getUbicacion(), Integer.valueOf(consultorioDTO.getId_ClaseCons()), consultorioDTO.getObservacion(), Integer.valueOf(consultorioDTO.getEstado()), consultorioDTO.getFecha(), consultorioDTO.getUsuarioS(), consultorioDTO.getIdSede()});
    }

    @Override // com.genoma.plus.dao.parametrizacion.ConsultorioDAO
    public void updateConsultorio(ConsultorioDTO consultorioDTO) {
        this.jdbcTemplate.update(" update c_consultorio set Nbre = ? , Ubicacion = ? , Id_ClaseCons = ? , Observacion = ?,Estado = ?, Fecha = ?, UsuarioS=?, idSede=? Where Id = ?", new Object[]{consultorioDTO.getNbre(), consultorioDTO.getUbicacion(), Integer.valueOf(consultorioDTO.getId_ClaseCons()), consultorioDTO.getObservacion(), Integer.valueOf(consultorioDTO.getEstado()), consultorioDTO.getFecha(), consultorioDTO.getUsuarioS(), consultorioDTO.getIdSede(), Integer.valueOf(consultorioDTO.getId())});
    }
}
