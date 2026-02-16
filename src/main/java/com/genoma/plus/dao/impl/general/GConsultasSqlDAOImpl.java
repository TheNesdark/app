package com.genoma.plus.dao.impl.general;

import com.genoma.plus.dao.general.GConsultasSqlDAO;
import com.genoma.plus.dto.general.LogUsuariosDuplicadosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/general/GConsultasSqlDAOImpl.class */
public class GConsultasSqlDAOImpl implements GConsultasSqlDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.general.GConsultasSqlDAO
    public List<Object[]> ListaDeConsultas(int idmodulo) {
        String Sql = "SELECT `Id` ,`Nbre`, `CSql`, `NParametros`, `NOrden`, TRUE , `Tipo`, `IdModulo` \n  FROM `g_consultas_sql` WHERE estado =1 AND IdModulo =" + idmodulo + " ORDER BY `NOrden` ASC";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.general.GConsultasSqlDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = new Object[10];
                fila[0] = Integer.valueOf(rs.getInt(1));
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = Integer.valueOf(rs.getInt(4));
                fila[4] = Integer.valueOf(rs.getInt(5));
                fila[5] = Boolean.valueOf(rs.getBoolean(6));
                fila[6] = Integer.valueOf(rs.getInt(7));
                fila[7] = Integer.valueOf(rs.getInt(8));
                return fila;
            }
        };
        List<Object[]> listaConsulta = this.jdbcTemplate.query(Sql, rowMapper);
        return listaConsulta;
    }

    @Override // com.genoma.plus.dao.general.GConsultasSqlDAO
    public String ejecuarSql1(String sql, String parm) {
        String result = "Consulta satisfactoria ";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{parm});
        if (ctos == 0) {
            result = "ha fallado la consulta ";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.GConsultasSqlDAO
    public String ejecutarSql2(String sql, String parm1, String parm2) {
        String result = "Consulta satisfactoria ";
        int ctos = this.jdbcTemplate.update(sql, new Object[]{parm1, parm2});
        if (ctos == 0) {
            result = "ha fallado la consulta ";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.GConsultasSqlDAO
    public String InsertarDuplicados(LogUsuariosDuplicadosDTO lUDuplicados) {
        String result = "Registro insertado con exito";
        int ctos = this.jdbcTemplate.update("insert into v_log_cusuarios_duplicados (`Id_Persona_N`, `NHistoria_N`, `NUsuario_N`, `Id_Persona_A`, `NHistoria_A`, `NUsuario_A`,`Id_UsuarioR`)VALUES (?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(lUDuplicados.getIdPersonaA()), Integer.valueOf(lUDuplicados.getNHistoriaN()), lUDuplicados.getNomUsuarioN(), Integer.valueOf(lUDuplicados.getIdPersonaA()), Integer.valueOf(lUDuplicados.getNHistoriaA()), lUDuplicados.getNomUsuarioA(), Integer.valueOf(lUDuplicados.getIdUsuario())});
        if (ctos == 0) {
            result = "No se pudo Insertar Registro";
        }
        return result;
    }

    @Override // com.genoma.plus.dao.general.GConsultasSqlDAO
    public String devolverEdadDosFechas(String fechaNacimiento, String fechaActualIngreso) {
        String sql = "SELECT `CalculaTiempo_AMD_2Fechas`('" + fechaNacimiento + "', '" + fechaActualIngreso + "')";
        String valor = (String) this.jdbcTemplate.queryForObject(sql, String.class);
        return valor;
    }
}
