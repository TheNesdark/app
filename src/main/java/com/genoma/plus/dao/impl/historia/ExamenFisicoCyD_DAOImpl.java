package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ExamenFisicoCyD_DAO;
import com.genoma.plus.dto.historia.ExamenFisicoCyD_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ExamenFisicoCyD_DAOImpl.class */
public class ExamenFisicoCyD_DAOImpl implements ExamenFisicoCyD_DAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ExamenFisicoCyD_DAO
    public List<ExamenFisicoCyD_DTO> listaDetalleExamenFisico(int idUsuarioPrograma, String fechaMesNac) {
        System.out.println("--------------IMPL listaDetalleExamenFisico--------------");
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ExamenFisicoCyD_DAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                ExamenFisicoCyD_DTO e = new ExamenFisicoCyD_DTO();
                e.setFecha(rs.getString("Fecha_Atencion"));
                e.setFc(Double.valueOf(rs.getDouble("FCardiaca")));
                e.setFr(Double.valueOf(rs.getDouble("FRespiratoria")));
                e.setTemperatura(Double.valueOf(rs.getDouble("Temperatura")));
                e.setPresion(rs.getString("TArterial"));
                e.setEdad(rs.getInt("edad_actual_mes"));
                e.setTalla(rs.getDouble("Talla"));
                e.setPeso(rs.getDouble("Peso"));
                e.setImc(rs.getDouble("IMC"));
                e.setPerimetroCefalico(rs.getDouble("PerimetroCefalico"));
                e.setPerimetroBrazo(rs.getDouble("PerimetroBrazo"));
                return e;
            }
        };
        List<ExamenFisicoCyD_DTO> lsExamenFisico = this.jdbcTemplate.query("SELECT `h_atencion`.`Fecha_Atencion` , `h_examenfisico`.`FCardiaca` , `h_examenfisico`.`Temperatura`  , \nIF(h_examenfisico.`TArtSentadoD` =0,'',\n CONCAT(h_examenfisico.`TArtSentadoD` ,'/', h_examenfisico.`TArtSentadoS`)) TArterial  , \n `h_examenfisico`.`Talla` , `h_examenfisico`.`Peso` , `h_examenfisico`.`IMC`,\n DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%Y%m') AS FecAtencion ,PerimetroCefalico,\n IF(Observacion IS NULL, '',Observacion) AS Observacion, h_examenfisico.`FRespiratoria`, \n h_examenfisico.PerimetroBrazo, PERIOD_DIFF(DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%Y%m'),?) AS edad_actual_mes   \n FROM `h_examenfisico` \n INNER JOIN  `h_atencion`   ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)  \n WHERE (`h_examenfisico`.`Id_Usuario_Programa` =?) \n GROUP BY `h_atencion`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC ", rowMapper, new Object[]{fechaMesNac, Integer.valueOf(idUsuarioPrograma)});
        return lsExamenFisico;
    }

    @Override // com.genoma.plus.dao.historia.ExamenFisicoCyD_DAO
    public List<Object[]> listaGraficasGuardadas_IdUsuarioPrograma(long idUsuarioPrograma) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.ExamenFisicoCyD_DAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), Integer.valueOf(rs.getInt(4)), Integer.valueOf(rs.getInt(5)), rs.getString(6)};
                return fila;
            }
        };
        List<Object[]> list = this.jdbcTemplate.query("SELECT p_usuario_grafica.`IdGrafica`,p_tipo_grafica.`Nbre`,p_tipo_grafica.`imagen`\n,p_tipo_grafica.`columnaOrigen_X`,p_tipo_grafica.`columnaOrigen_Y`, p_tipo_grafica.`sexo`\nFROM p_usuario_grafica \nINNER JOIN `p_tipo_grafica` ON p_usuario_grafica.`IdGrafica`=p_tipo_grafica.`Id`\nWHERE p_usuario_grafica.`IdUsuarioPrograma`=?", mapper, new Object[]{Long.valueOf(idUsuarioPrograma)});
        return list;
    }
}
