package com.genoma.plus.dao.impl.historia;

import Utilidades.Metodos;
import com.genoma.plus.dao.historia.HNotaClinicaDiagnosticoDAO;
import com.genoma.plus.dto.historia.HNotaClinicaDiagnosticoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/HNotaClinicaDiagnosticoDAOImpl.class */
public class HNotaClinicaDiagnosticoDAOImpl implements HNotaClinicaDiagnosticoDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.HNotaClinicaDiagnosticoDAO
    public void mCrear(HNotaClinicaDiagnosticoDTO e) {
        this.jdbcTemplate.update("INSERT INTO `h_notaclinica_diagnostico` (`Id_NClinica` , `Id_Patologia` , `NOrden` , `Estado` , `Id_UsuarioS` , `Fecha`)\nVALUES (?,?,?,?,?,?);", new Object[]{e.getIdNClinica(), e.getIdPatologia(), e.getNOrden(), e.getEstado(), e.getIdUsuarioS(), e.getFecha()});
    }

    @Override // com.genoma.plus.dao.historia.HNotaClinicaDiagnosticoDAO
    public List<Object[]> listDiagnosticoNotaClinica(String idNotaClinica) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.HNotaClinicaDiagnosticoDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Id"), rs.getString("Nbre"), rs.getString("NOrden")};
                return fila;
            }
        };
        String xsql = "SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\n    , `h_notaclinica_diagnostico`.`NOrden`\nFROM\n     .`h_notaclinica_diagnostico`\n    INNER JOIN  `g_patologia` \n        ON (`h_notaclinica_diagnostico`.`Id_Patologia` = `g_patologia`.`Id`)\nWHERE (`h_notaclinica_diagnostico`.`Estado` =1\n    AND `h_notaclinica_diagnostico`.`Id_NClinica` =" + idNotaClinica + ")\nORDER BY `h_notaclinica_diagnostico`.`NOrden` ASC";
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.HNotaClinicaDiagnosticoDAO
    public List<Object[]> listDiagnosticosIngreso(Long idAtencion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.HNotaClinicaDiagnosticoDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Codigo_DxR3"), rs.getString("NDx3"), rs.getString("Codigo_DxR2"), rs.getString("NDx2"), rs.getString("Codigo_DxR1"), rs.getString("NDx1"), rs.getString("Codigo_DxP"), rs.getString("NDxP")};
                return fila;
            }
        };
        String xsql = "SELECT\n      IFNULL(`h_atencion`.`Codigo_DxR3`,'') AS Codigo_DxR3\n    , IFNULL(`g_patologia_3`.`Nbre`,'') AS `NDx3`\n    , IFNULL(`h_atencion`.`Codigo_DxR2`,'') AS Codigo_DxR2\n    , IFNULL(`g_patologia_2`.`Nbre`,'') AS `NDx2`\n    , IFNULL(`h_atencion`.`Codigo_DxR1`,'') AS Codigo_DxR1\n    , IFNULL(`g_patologia_1`.`Nbre`,'') AS `NDx1`\n    , IFNULL(`h_atencion`.`Codigo_Dxp`,'') AS Codigo_DxP\n    , IFNULL(`g_patologia`.`Nbre`,'') AS `NDxP`\nFROM\n     `g_patologia`\n    LEFT JOIN `h_atencion` \n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\n    LEFT JOIN `g_patologia` AS `g_patologia_1` \n        ON (`g_patologia_1`.`Id` = `h_atencion`.`Codigo_DxR1`)\n    LEFT JOIN `g_patologia` AS `g_patologia_2` \n        ON (`g_patologia_2`.`Id` = `h_atencion`.`Codigo_DxR2`)\n    LEFT JOIN `g_patologia` AS `g_patologia_3` \n        ON (`g_patologia_3`.`Id` = `h_atencion`.`Codigo_DxR3`)\nWHERE (`h_atencion`.`Id` =" + idAtencion + ");";
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.HNotaClinicaDiagnosticoDAO
    public List<Object[]> listUltimaNotaEspecialista(Long idAtencion, Long idEspecialidad) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.HNotaClinicaDiagnosticoDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("idNota")};
                return fila;
            }
        };
        String xsql = " SELECT\n   IFNULL(MAX(`h_notasclinicas`.`Id`),'0') AS `idNota`\nFROM\n   `h_notaclinica_diagnostico`\n   INNER JOIN `h_notasclinicas`\n       ON (`h_notaclinica_diagnostico`.`Id_NClinica` = `h_notasclinicas`.`Id`)\nWHERE (`h_notasclinicas`.`Id_Especialidad` =" + idEspecialidad + "\n   AND `h_notasclinicas`.`Id_Atencion` =" + idAtencion + "\n   AND `h_notasclinicas`.`Estado` =1);";
        System.out.println("Ultima noda: " + xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.HNotaClinicaDiagnosticoDAO
    public List<Object[]> listDiagnosticosEspecialidadAnterior(Long idAtencion, Long idEspecialidad, String idUltimaNota) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.HNotaClinicaDiagnosticoDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Id"), rs.getString("Nbre"), rs.getString("NOrden")};
                return fila;
            }
        };
        String xsql = "SELECT\n `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\n    , `h_notaclinica_diagnostico`.`NOrden`\nFROM\n   `h_notaclinica_diagnostico`\n   INNER JOIN `baseserver`.`h_notasclinicas`\n       ON (`h_notaclinica_diagnostico`.`Id_NClinica` = `h_notasclinicas`.`Id`)\n   INNER JOIN `g_patologia` \n        ON (`h_notaclinica_diagnostico`.`Id_Patologia` = `g_patologia`.`Id`)    \nWHERE (`h_notasclinicas`.`Id_Especialidad` =" + idEspecialidad + "\n   AND `h_notasclinicas`.`Id_Atencion` =" + idAtencion + "\n   AND `h_notasclinicas`.`Estado` =1\n   AND `h_notasclinicas`.`Id`=" + idUltimaNota + ")\n   ORDER BY `h_notaclinica_diagnostico`.`NOrden` DESC , `g_patologia`.`Nbre` ASC;";
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
