package com.genoma.plus.dao.impl.parametrizacion;

import Acceso.Principal;
import com.genoma.plus.dao.parametrizacion.listadosubgrupofacturaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/parametrizacion/listadosubgrupofacturaDAOImpl.class */
public class listadosubgrupofacturaDAOImpl implements listadosubgrupofacturaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.parametrizacion.listadosubgrupofacturaDAO
    public List<Object[]> listadosubgrupofacturaempresaDAO(Long idEmpresa, String nombre, int grabado) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.listadosubgrupofacturaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Boolean.valueOf(rs.getBoolean(1)), Long.valueOf(rs.getLong(2)), rs.getString(3), Long.valueOf(rs.getLong(4)), rs.getString(5), Integer.valueOf(rs.getInt(6)), Integer.valueOf(rs.getInt(7))};
                return fila;
            }
        };
        String sql = "SELECT\n  FALSE,\n  d.Id_GrupoServicio,\n  d.Servicio,\n  f_subgruposervicio.Id_SubgrupoServicio,\n  f_subgruposervicio.Nbre AS subgrupo,\n  f_subgrupo_empresa.`Estado`,\n  IF(f_subgrupo_empresa.`Id` IS NULL,0,1) grabado\nFROM\n  f_subgruposervicio\n  LEFT JOIN f_subgrupo_empresa\n    ON (f_subgruposervicio.Id_SubgrupoServicio = f_subgrupo_empresa.`Id_SubGrupo` AND Id_Empresa = " + idEmpresa + ")\n  LEFT JOIN\n    (SELECT\n      Id_GrupoServicio,\n      Nbre AS Servicio,\n      Estado\n    FROM\n      f_gruposervicio\n    WHERE (Estado = 0)\n    ORDER BY Nbre ASC) d ON (d.Id_GrupoServicio = f_subgruposervicio.Id_GrupoServicio)\nWHERE IF(f_subgrupo_empresa.`Id` IS NULL,0,1) IN (" + grabado + ") AND CONCAT(Servicio,'',f_subgruposervicio.Nbre) LIKE '%" + nombre + "%'\nORDER BY grabado DESC,d.Servicio ASC,subgrupo ASC";
        System.out.println("Tab detalle de factura : " + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.parametrizacion.listadosubgrupofacturaDAO
    public void crear(Long idSubGrupo, Long idEmpresa) {
        int ctos = this.jdbcTemplate.update("INSERT INTO `f_subgrupo_empresa` (`Id_SubGrupo`,`Id_Empresa`, UsuarioS)\nVALUES (?,?,?);", new Object[]{idSubGrupo, idEmpresa, Principal.usuarioSistemaDTO.getLogin()});
        if (ctos == 0) {
        }
    }
}
