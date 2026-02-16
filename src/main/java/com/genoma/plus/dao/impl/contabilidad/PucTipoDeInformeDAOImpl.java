package com.genoma.plus.dao.impl.contabilidad;

import com.genoma.plus.dao.contabilidad.PucTipoDeInformesDAO;
import com.genoma.plus.dto.contabilidad.PucTipoDeInformeDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/contabilidad/PucTipoDeInformeDAOImpl.class */
public class PucTipoDeInformeDAOImpl implements PucTipoDeInformesDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.contabilidad.PucTipoDeInformesDAO
    public List<Object[]> listaPucTdeInforme() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.PucTipoDeInformeDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), Integer.valueOf(rs.getInt(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), Boolean.valueOf(rs.getBoolean(8))};
                return fila;
            }
        };
        List<Object[]> listaPucDInforme = this.jdbcTemplate.query("SELECT\n    `cc_puc_niif_tipo_informe`.`Id`\n    , `cc_puc_niif_tipo_informe`.`Id_TipoInforme`\n    , `cc_tipo_informes`.`Nbre`\n    , `cc_puc_niif_tipo_informe`.`CodigoPuc`\n    , `cc_puc_niif_tipo_informe`.`Codigo_Concepto`\n    , `cc_puc_niif_tipo_informe`.`Nombre_Concepto`\n    , `cc_puc_niif_tipo_informe`.`Consulta_SQL`\n    , `cc_puc_niif_tipo_informe`.`Estado`\nFROM\n    `baseserver`.`cc_puc_niif_tipo_informe`\n    INNER JOIN `baseserver`.`cc_tipo_informes` \n        ON (`cc_puc_niif_tipo_informe`.`Id_TipoInforme` = `cc_tipo_informes`.`Id`);", mapper);
        return listaPucDInforme;
    }

    @Override // com.genoma.plus.dao.contabilidad.PucTipoDeInformesDAO
    public String mCreate(PucTipoDeInformeDTO xPucTipoDeInformeDTO) {
        String result = " Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `cc_puc_niif_tipo_informe` (`Id_TipoInforme`,`CodigoPuc`,`Codigo_Concepto`,`Nombre_Concepto`,`Consulta_SQL`,`Estado`,`Id_UsuarioS`) VALUES (?,?,?,?,?,?,?);", new Object[]{Integer.valueOf(xPucTipoDeInformeDTO.getIdtipoinforme()), xPucTipoDeInformeDTO.getCodigoPuc(), xPucTipoDeInformeDTO.getCodigoConcepto(), xPucTipoDeInformeDTO.getNombreConcepto(), xPucTipoDeInformeDTO.getConsultaSQL(), Boolean.valueOf(xPucTipoDeInformeDTO.isEstado()), xPucTipoDeInformeDTO.getIdUsuario()});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.contabilidad.PucTipoDeInformesDAO
    public String mUpdate(PucTipoDeInformeDTO xPucTipoDeInformeDTO) {
        String result = " Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `cc_puc_niif_tipo_informe` SET  `Id_TipoInforme` = ?,`CodigoPuc`= ?,`Codigo_Concepto` =?,`Nombre_Concepto`= ?,`Consulta_SQL`= ?,`Estado`= ?,`Id_UsuarioS`= ? WHERE `Id` = ?;", new Object[]{Integer.valueOf(xPucTipoDeInformeDTO.getIdtipoinforme()), xPucTipoDeInformeDTO.getCodigoPuc(), xPucTipoDeInformeDTO.getCodigoConcepto(), xPucTipoDeInformeDTO.getNombreConcepto(), xPucTipoDeInformeDTO.getConsultaSQL(), Boolean.valueOf(xPucTipoDeInformeDTO.isEstado()), xPucTipoDeInformeDTO.getIdUsuario(), Integer.valueOf(xPucTipoDeInformeDTO.getId())});
        if (ctos == 0) {
            result = "No se pudo insertar";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.contabilidad.PucTipoDeInformesDAO
    public List<Object[]> listaTipoInformes() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.PucTipoDeInformeDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> lista = this.jdbcTemplate.query("SELECT `Id`,`Nbre` FROM `cc_tipo_informes` ;", mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.contabilidad.PucTipoDeInformesDAO
    public List<Object[]> listaTipoInformesFiltrado(Integer tipo) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.PucTipoDeInformeDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[3];
                fila[0] = rs.getString("Id");
                fila[1] = rs.getString("Nbre");
                return fila;
            }
        };
        String sql = "SELECT\n    `cc_tipo_informes`.`Id`\n    , `cc_tipo_informes`.`Nbre`\nFROM\n    `cc_puc_niif_tipo_informe`\n    INNER JOIN `cc_tipo_informes` \n        ON (`cc_puc_niif_tipo_informe`.`Id_TipoInforme` = `cc_tipo_informes`.`Id`)\nWHERE (`cc_puc_niif_tipo_informe`.`Estado` =1 and `cc_tipo_informes`.`Tipo`='" + tipo + "')\nGROUP BY `cc_tipo_informes`.`Id`\nORDER BY `cc_tipo_informes`.`Nbre` ASC";
        System.out.println("" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
