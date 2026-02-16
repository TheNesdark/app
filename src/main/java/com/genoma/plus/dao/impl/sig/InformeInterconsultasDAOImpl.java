package com.genoma.plus.dao.impl.sig;

import Acceso.Principal;
import com.genoma.plus.dao.sig.InformeInterconsultasDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/InformeInterconsultasDAOImpl.class */
public class InformeInterconsultasDAOImpl implements InformeInterconsultasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.InformeInterconsultasDAO
    public List<Object[]> mListarInterconsultas(String fechaI, String fechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeInterconsultasDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), Long.valueOf(rs.getLong(9)), rs.getString(10), rs.getString(11), Long.valueOf(rs.getLong(12)), rs.getString(13), rs.getString(14)};
                return fila;
            }
        };
        String xSql = "SELECT\n    `ingreso`.`Id`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `h_notasclinicas`.`FechaNota`\n    , COUNT(`h_notasclinicas`.`FechaNota`) AS `cantidad`\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\n    , `h_tiponota`.`Id`\n    , `h_tiponota`.`Nbre`\n    , `g_tipoatencion`.`Nbre`\nFROM\n    `baseserver`.`h_notasclinicas`\n    INNER JOIN `baseserver`.`h_atencion` \n        ON (`h_notasclinicas`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `baseserver`.`profesional1` \n        ON (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`)\n    INNER JOIN `baseserver`.`h_tiponota` \n        ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`)\n    INNER JOIN `baseserver`.`g_tipoatencion` \n        ON (`h_notasclinicas`.`Id_Tipo_Atencion` = `g_tipoatencion`.`Id`)\nWHERE (`h_notasclinicas`.`FechaNota` >='" + fechaI + "'\n    AND `h_tiponota`.`Id` =7\n    AND `profesional1`.`Id_Persona` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'\n    AND `profesional1`.`IdEspecialidad` ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'\n    AND `h_notasclinicas`.`Estado` =1\n    AND `h_notasclinicas`.`FechaNota` <='" + fechaF + "'\n    AND `g_tipoatencion`.`Id` <>1)\nGROUP BY `ingreso`.`Id`, `h_notasclinicas`.`FechaNota`\nORDER BY `h_notasclinicas`.`FechaNota` ASC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
