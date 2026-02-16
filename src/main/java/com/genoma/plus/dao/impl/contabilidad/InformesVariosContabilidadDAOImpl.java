package com.genoma.plus.dao.impl.contabilidad;

import com.genoma.plus.dao.contabilidad.InformesVariosContabilidadDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/contabilidad/InformesVariosContabilidadDAOImpl.class */
public class InformesVariosContabilidadDAOImpl implements InformesVariosContabilidadDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.contabilidad.InformesVariosContabilidadDAO
    public List<Object[]> listadoInformeContraloria(final String anno, final String mes, final String condigoPrestador, final String idPeriodo, String idInforme) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.InformesVariosContabilidadDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[6];
                fila[0] = anno;
                fila[1] = mes;
                fila[2] = condigoPrestador;
                fila[3] = rs.getString("Codigo_Concepto");
                fila[4] = rs.getString("Nombre_Concepto");
                if (!rs.getString("Consulta_SQL").isEmpty()) {
                    fila[5] = InformesVariosContabilidadDAOImpl.this.valorCuenta(rs.getString("Consulta_SQL"), idPeriodo);
                } else {
                    fila[5] = new Double(0.0d);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `Codigo_Concepto`\n    , `Nombre_Concepto`\n    , `Consulta_SQL`\nFROM\n    `cc_puc_niif_tipo_informe`\nWHERE (`Estado` =1\n    AND `Id_TipoInforme` ='" + idInforme + "')";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.contabilidad.InformesVariosContabilidadDAO
    public final Double valorCuenta(String sql, String idPeriodoN) {
        Double valor = (Double) this.jdbcTemplate.queryForObject(sql, Double.class, new Object[]{idPeriodoN});
        return valor;
    }

    @Override // com.genoma.plus.dao.contabilidad.InformesVariosContabilidadDAO
    public List<Object[]> listadoEstadosFinancieros(String idInforme, final String fechaInicial, final String fechaFinal) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.contabilidad.InformesVariosContabilidadDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[6];
                fila[0] = rs.getString("Nombre_Concepto");
                fila[1] = "";
                if (!rs.getString("Consulta_SQL").isEmpty()) {
                    fila[2] = InformesVariosContabilidadDAOImpl.this.valorCuenta(rs.getString("Consulta_SQL"), fechaInicial);
                } else {
                    fila[2] = new Double(0.0d);
                }
                if (!rs.getString("Consulta_SQL").isEmpty()) {
                    fila[3] = InformesVariosContabilidadDAOImpl.this.valorCuenta(rs.getString("Consulta_SQL"), fechaFinal);
                } else {
                    fila[3] = new Double(0.0d);
                }
                return fila;
            }
        };
        String sql = "SELECT\n    `Codigo_Concepto`\n    , `Nombre_Concepto`\n    , `Consulta_SQL`\nFROM\n    `cc_puc_niif_tipo_informe`\nWHERE (`Estado` =1\n    AND `Id_TipoInforme` ='" + idInforme + "')";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
