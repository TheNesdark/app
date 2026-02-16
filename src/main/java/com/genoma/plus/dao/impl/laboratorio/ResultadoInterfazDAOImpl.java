package com.genoma.plus.dao.impl.laboratorio;

import Utilidades.Metodos;
import com.genoma.plus.dao.laboratorio.ResultadosInterfazDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/laboratorio/ResultadoInterfazDAOImpl.class */
public class ResultadoInterfazDAOImpl implements ResultadosInterfazDAO {
    public Metodos xmt = new Metodos();
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.laboratorio.ResultadosInterfazDAO
    public List<Object[]> listadoResultados(String xfechai, String xfechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.ResultadoInterfazDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), Long.valueOf(rs.getLong(6)), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), Boolean.valueOf(rs.getBoolean(13)), rs.getString(14), Long.valueOf(rs.getLong(15))};
                return fila;
            }
        };
        String sql = "SELECT \nconcat(`f`.`Id_TipoIdentificacion`, ' ',`f`.`NoDocumento`) Documento \n    , f.`NUsuario`\n    , `f`.`Id_Sexo`\n    ,f.`IdProcedimiento`\n    , f.`NProcedimiento`\n    ,f.IdProtocoloProc\n    , f.`NProtocolo`\n    , f.`FechaResultado`\n    , `f`.`RESULTADO`\n    , f.`Minimo`\n    , f.`Maximo`, `f`.`Unidad`    \n    ,IF(( f.`Minimo`<>'' && f.`Maximo` <>''), IF((`f`.`RESULTADO`<f.`Minimo` OR `f`.`RESULTADO`>f.`Maximo`),1,0),0)Alterado\n, DATE_FORMAT(`f`.`FechaResultado`, '%Y-%m-%d') FechaC\n    , f.IdRecepcion    \nFROM (\nSELECT\n`g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    ,`g_procedimiento`.`Id` AS `IdProcedimiento`\n    , `g_procedimiento`.`Nbre` AS `NProcedimiento`\n    , `l_protocoloxprocedimiento`.`Id` IdProtocoloProc\n    , `l_protocolos`.`Nbre` AS `NProtocolo`\n    , `l_resultados_analizador`.`FECHA_CARGA` FechaResultado\n    , `l_resultados_analizador`.`RESULTADO`, `g_persona`.`Id_Sexo`\n    , IF(`g_persona`.`Id_Sexo`='F', `l_protocolos`.`VrMinF`, `l_protocolos`.`VrMinM`)  AS `Minimo`\n    , IF(`g_persona`.`Id_Sexo`='F', `l_protocolos`.`VrMaxF`, `l_protocolos`.`VrMaxM`) AS `Maximo`\n    , `l_protocolos`.`Unidad`, IF(d.Id_Recepcion IS NULL, 0, 1) Esta \n    , `l_recepcion`.`Id` IdRecepcion\n    \nFROM\n    `l_resultados_analizador`\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_resultados_analizador`.`ID_EXAMEN` = `l_protocoloxprocedimiento`.`IdInfinity`)\n    INNER JOIN `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_protocoloxprocedimiento`.`Id_Procedim`)\n    INNER JOIN `l_recepcion` \n        ON (`l_recepcion`.`Id` = `l_resultados_analizador`.`ID_ORDEN`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`)\n   LEFT JOIN (SELECT\n    `l_resultados`.`Id_Recepcion`\n    , `l_detalleresultado`.`Id_Procedimiento`\n    , `l_detalleresultado`.`Id_ProtocolProcedim`\n   -- , `l_resultados`.`Estado`\n   -- , `l_detalleresultado`.`Estado`\nFROM\n    `l_detalleresultado`\n    INNER JOIN `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\nWHERE (`l_resultados`.`Estado` =0\n    AND `l_detalleresultado`.`Estado` =1))  d ON (d.Id_Recepcion=`l_recepcion`.`Id`)   \n     AND (d.Id_Procedimiento=g_procedimiento.`Id`) AND (d.Id_ProtocolProcedim=`l_protocoloxprocedimiento`.`Id`)\n        \nWHERE (DATE_FORMAT(`l_resultados_analizador`.`FECHA_CARGA`, '%Y-%m-%d') >='" + xfechai + "'\n    AND DATE_FORMAT(`l_resultados_analizador`.`FECHA_CARGA`, '%Y-%m-%d') <='" + xfechaf + "')\n    HAVING Esta=0\nORDER BY `l_recepcion`.`Id` ASC, `NProcedimiento` ASC, `l_protocoloxprocedimiento`.`Orden` ASC\n) f\n";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
