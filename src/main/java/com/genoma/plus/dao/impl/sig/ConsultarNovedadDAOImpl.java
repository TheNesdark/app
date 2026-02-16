package com.genoma.plus.dao.impl.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.sig.ConsultarNovedadDAO;
import com.genoma.plus.dto.sig.ConsultarNovedadDTO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.io.BufferedWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/ConsultarNovedadDAOImpl.class */
public class ConsultarNovedadDAOImpl implements ConsultarNovedadDAO {
    private JdbcTemplate jdbcTemplate;
    private String fechaI;
    private String fechaF;
    private JRadioButton xjrButton;
    private JTable xTabla;
    DefaultTableModel xModelo;
    private Metodos xmt = new Metodos();
    BufferedWriter bw = null;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.ConsultarNovedadDAO
    public List<GenericoComboDTO> comboNovedad() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarNovedadDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoComboDTO g = new GenericoComboDTO();
                g.setId(rs.getLong("Id"));
                g.setNombre(rs.getString("Nbre"));
                return g;
            }
        };
        List<GenericoComboDTO> list = this.jdbcTemplate.query("SELECT  `Id` , `Nbre` FROM  `g_tiponovedad` WHERE (`Tipo` =1   AND `Estado` =1);", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultarNovedadDAO
    public List<ConsultarNovedadDTO> list(String fechaI, String fechaF) {
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        String sql = "SELECT    CONCAT (`g_persona`.`Apellido1`, ' ',`g_persona`.`Apellido2` , ' ',`g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2` ) AS Nombre    , `g_persona`.`Id_Sexo`    , `g_persona`.`Direccion`    , `g_persona`.`Telefono`    , `g_persona_novedades`.`FechaR`    , `g_tiponovedad`.`Nbre` AS `TipoNovedad`    , `g_persona_novedades`.`Observacion`FROM    `baseserver`.`g_persona_novedades`    INNER JOIN `baseserver`.`g_persona`         ON (`g_persona_novedades`.`Id_Persona` = `g_persona`.`Id`)    INNER JOIN `baseserver`.`g_tiponovedad`         ON (`g_persona_novedades`.`Id_TipoNovedad` = `g_tiponovedad`.`Id`)WHERE (`g_persona_novedades`.`Estado` =1    AND `g_tiponovedad`.`Tipo` =1     AND `g_persona_novedades`.`FechaR` >='" + this.fechaI + "'    AND `g_persona_novedades`.`FechaR` <= '" + this.fechaF + "' ); ";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarNovedadDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ConsultarNovedadDTO Dato = new ConsultarNovedadDTO();
                Dato.setXNombre(rs.getString("Nombre"));
                Dato.setXSexo(rs.getString("Id_Sexo"));
                Dato.setXDirreccion(rs.getString("Direccion"));
                Dato.setXTelefono(rs.getString("Telefono"));
                Dato.setXFecha(rs.getString("FechaR"));
                Dato.setXTnovedad(rs.getString("TipoNovedad"));
                Dato.setXObservacion(rs.getString("Observacion"));
                return Dato;
            }
        };
        List<ConsultarNovedadDTO> CargarNovedad = this.jdbcTemplate.query(sql, rowMapper);
        return CargarNovedad;
    }

    @Override // com.genoma.plus.dao.sig.ConsultarNovedadDAO
    public List<ConsultarNovedadDTO> listF(String fechaI, String fechaF, String xId) {
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        String sql = "SELECT    CONCAT (`g_persona`.`Apellido1`, ' ',`g_persona`.`Apellido2` , ' ',`g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2` ) AS Nombre    , `g_persona`.`Id_Sexo`    , `g_persona`.`Direccion`    , `g_persona`.`Telefono`    , `g_persona_novedades`.`FechaR`    , `g_tiponovedad`.`Nbre` AS `TipoNovedad`    , `g_persona_novedades`.`Observacion`FROM    `baseserver`.`g_persona_novedades`    INNER JOIN `baseserver`.`g_persona`         ON (`g_persona_novedades`.`Id_Persona` = `g_persona`.`Id`)    INNER JOIN `baseserver`.`g_tiponovedad`         ON (`g_persona_novedades`.`Id_TipoNovedad` = `g_tiponovedad`.`Id`)WHERE (`g_tiponovedad`.`Id`='" + xId + "'    AND `g_persona_novedades`.`Estado` =1    AND `g_tiponovedad`.`Tipo` =1     AND `g_persona_novedades`.`FechaR` >='" + this.fechaI + "'    AND `g_persona_novedades`.`FechaR` <='" + this.fechaF + "');";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarNovedadDAOImpl.3
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ConsultarNovedadDTO Dato = new ConsultarNovedadDTO();
                Dato.setXNombre(rs.getString("Nombre"));
                Dato.setXSexo(rs.getString("Id_Sexo"));
                Dato.setXDirreccion(rs.getString("Direccion"));
                Dato.setXTelefono(rs.getString("Telefono"));
                Dato.setXFecha(rs.getString("FechaR"));
                Dato.setXTnovedad(rs.getString("TipoNovedad"));
                Dato.setXObservacion(rs.getString("Observacion"));
                return Dato;
            }
        };
        List<ConsultarNovedadDTO> CargarNovedad = this.jdbcTemplate.query(sql, rowMapper);
        return CargarNovedad;
    }
}
