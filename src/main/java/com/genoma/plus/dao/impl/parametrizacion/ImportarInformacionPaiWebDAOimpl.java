package com.genoma.plus.dao.impl.parametrizacion;

import Utilidades.ConsultasMySQL;
import com.genoma.plus.dao.parametrizacion.ImportarInfomacionPaiWebDAO;
import com.genoma.plus.dto.parametrizacion.ImportPaiWebDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/parametrizacion/ImportarInformacionPaiWebDAOimpl.class */
public class ImportarInformacionPaiWebDAOimpl implements ImportarInfomacionPaiWebDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.parametrizacion.ImportarInfomacionPaiWebDAO
    public void InsertPaiWeb(ImportPaiWebDTO importPaiWebDTO) {
        this.jdbcTemplate.update("INSERT INTO `baseserver`.`p_vacunacion_import_paiweb` (  fechaAplicacion,  `identificacion`,  `bcg`,  `hepatitisb`,\n  `polioVop`,  `polioVip`,  `pentavalente`,  `dpt`,  `rotavirus`,  `neumococo`,  `neumococoPolisacarido`,  `tripleviral`,  `hepatitisa`,\n  `fiebreAmarilla`,  `ttd`,  `influenza`,  `td`,  `sarampeonRubiola`,  `vph`,  `rabicaHumana`,  `acelularPediatrica`,  `acelularGestante`,\n  `suerioAntirabico`,  `antihepatitisb`,  `antiToxinaTetanica`,  `varicela`,  `rabiacaHumana`,  `hepatitisbAdultos`,  `hepatitisaAdultos`)\nVALUES   (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? );", new Object[]{importPaiWebDTO.getFechaAplicacion(), importPaiWebDTO.getIdentificacion(), importPaiWebDTO.getBcg(), importPaiWebDTO.getHepatitisb(), importPaiWebDTO.getPolioVop(), importPaiWebDTO.getPolioVip(), importPaiWebDTO.getPentavalente(), importPaiWebDTO.getDpt(), importPaiWebDTO.getRotavirus(), importPaiWebDTO.getNeumococo(), importPaiWebDTO.getNeumococoPolisacarido(), importPaiWebDTO.getTripleviral(), importPaiWebDTO.getHepatitisa(), importPaiWebDTO.getFiebreAmarilla(), importPaiWebDTO.getTdp(), importPaiWebDTO.getInfluenza(), importPaiWebDTO.getTda(), importPaiWebDTO.getSarampeonRubiola(), importPaiWebDTO.getVph(), importPaiWebDTO.getRabicaHumana(), importPaiWebDTO.getAcelularPediatrica(), importPaiWebDTO.getAcelularGestante(), importPaiWebDTO.getSueroAntirabico(), importPaiWebDTO.getAntihepatitisb(), importPaiWebDTO.getAntiToxinaTetanica(), importPaiWebDTO.getVaricela(), importPaiWebDTO.getRabiacaHumana(), importPaiWebDTO.getHepatitisbAdultos(), importPaiWebDTO.getHepatitisaAdultos()});
    }

    @Override // com.genoma.plus.dao.parametrizacion.ImportarInfomacionPaiWebDAO
    public void VerificarExistenciaUsuarios() {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs("UPDATE `p_vacunacion_import_paiweb`,(SELECT `Id` , `NoDocumento` FROM    `baseserver`.`g_persona`\nINNER JOIN ( SELECT `id_persona`  , `identificacion` FROM  `baseserver`.`p_vacunacion_import_paiweb` )\nd ON ( d.identificacion=g_persona.NoDocumento)) k SET p_vacunacion_import_paiweb.`id_persona`=k.Id \nWHERE ( k.NoDocumento=p_vacunacion_import_paiweb.`identificacion`);");
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                this.jdbcTemplate.update("UPDATE `p_vacunacion_import_paiweb`,(SELECT `Id` , `NoDocumento` FROM    `baseserver`.`g_persona`\nINNER JOIN ( SELECT `id_persona`  , `identificacion` FROM  `baseserver`.`p_vacunacion_import_paiweb` )\nd ON ( d.identificacion=g_persona.NoDocumento)) k SET p_vacunacion_import_paiweb.`id_persona`=k.Id \nWHERE ( k.NoDocumento=p_vacunacion_import_paiweb.`identificacion`);");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportarInformacionPaiWebDAOimpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    @Override // com.genoma.plus.dao.parametrizacion.ImportarInfomacionPaiWebDAO
    public List<Object[]> ListadoPacientesInexistentes() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.ImportarInformacionPaiWebDAOimpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3)};
                return fila;
            }
        };
        System.err.println("SELECT   `id` , `id_persona` , `identificacion`FROM `baseserver`.`p_vacunacion_import_paiweb` WHERE (p_vacunacion_import_paiweb.`id_persona`=0);");
        List<Object[]> list = this.jdbcTemplate.query("SELECT   `id` , `id_persona` , `identificacion`FROM `baseserver`.`p_vacunacion_import_paiweb` WHERE (p_vacunacion_import_paiweb.`id_persona`=0);", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.parametrizacion.ImportarInfomacionPaiWebDAO
    public void ejecutarSql() {
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.parametrizacion.ImportarInformacionPaiWebDAOimpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ImportPaiWebDTO importPaiWebDTO = new ImportPaiWebDTO();
                importPaiWebDTO.setId(rs.getString(1));
                importPaiWebDTO.setConsultaSql(rs.getString(2));
                importPaiWebDTO.setNParametros(rs.getString(3));
                importPaiWebDTO.setOrden(rs.getString(4));
                System.out.println("SQL Parametros - -->" + rs.getInt(3));
                System.out.println("SQL Orden  - -->" + rs.getInt(4));
                String xSql_Vista = rs.getString("consultaSql");
                int fila = ImportarInformacionPaiWebDAOimpl.this.jdbcTemplate.update(xSql_Vista);
                System.out.println(fila);
                System.out.println("Consulta SqlVista Impresa --> " + xSql_Vista);
                return importPaiWebDTO;
            }
        };
        this.jdbcTemplate.query("SELECT `id` , `consultaSql` , `parametros` , `orden` FROM `baseserver`.`p_vacunas_importar_sql` WHERE (`estado` =1)ORDER BY `orden` ASC", rowMapper);
    }
}
