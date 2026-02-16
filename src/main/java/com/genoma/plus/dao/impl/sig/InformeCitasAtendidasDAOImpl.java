package com.genoma.plus.dao.impl.sig;

import Acceso.Principal;
import com.genoma.plus.dao.sig.InformeCitasAtendidasDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/InformeCitasAtendidasDAOImpl.class */
public class InformeCitasAtendidasDAOImpl implements InformeCitasAtendidasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.InformeCitasAtendidasDAO
    public List<Object[]> mListarCitasProgramas(String fechaI, String fechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeCitasAtendidasDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString("telefono")};
                return fila;
            }
        };
        String xSql = "SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`\n    , `g_ips`.`Nbre` AS `NEntidadF`\n    , `c_citas`.`Fecha_Cita` AS `FechaI`\n    , `c_citas`.`HoraInicial` AS `HoraA`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    , CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `NProfesional`\n    , IF(c_citas.Asistida=0,'ASIGNADA', IF(c_citas.Asistida=1,'FACTURADA',IF(c_citas.Asistida=2,'EN ATENCION', 'ATENDIDA'))) Estado\n    , IFNULL(ingreso.`Id`, '') NIngreso\t\n    ,IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n    ,IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio \n    ,IFNULL(`h_atencion`.`Codigo_Dxp`,'') AS DxP\n    ,IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico, if(g_persona.Telefono = '' and g_persona.Movil ='', 'NO REGISTRA',  \nif((g_persona.Telefono <> '' and g_persona.Movil =''),g_persona.Telefono,\nif((g_persona.Telefono = '' and g_persona.Movil <>''),g_persona.Movil, CONCAT(g_persona.Movil, ' - ', g_persona.Telefono)))) telefono\nFROM\n     `g_persona`\n    INNER JOIN  `c_citas`\n        ON (`g_persona`.`Id` = `c_citas`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio`\n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita`\n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_ips`\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    LEFT JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)\n    LEFT JOIN  `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `g_patologia`\n        ON (`h_atencion`.`Codigo_Dxp`=`g_patologia`.`Id`)\n    INNER JOIN  `g_persona` AS `g_persona_1`\n        ON (`g_persona_1`.`Id` = `c_citas`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`)\n    LEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`)\n WHERE (`c_citas`.`Fecha_Cita` >='" + fechaI + "' \n AND `c_citas`.`Fecha_Cita` <='" + fechaF + "' \n -- AND `c_citas`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' \n AND c_citas.Id_MotivoDesistida=1)\nORDER BY `FechaI` ASC, `HoraA` ASC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.InformeCitasAtendidasDAO
    public List<Object[]> mListarCitasNoProgramas(String fechaI, String fechaF) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.InformeCitasAtendidasDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString("telefono")};
                return fila;
            }
        };
        String xSql = " SELECT\n      CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`\n    , `g_ips`.`Nbre` AS `NEntidadF`\n    , `c_citasnp`.`Fecha_Cita` AS `FechaI`\n    , `c_citasnp`.`HoraInicial` AS `HoraA`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    , CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `NProfesional`\n    , IF(c_citasnp.Asistida=0,'POR ATENCION', IF(c_citasnp.Asistida=1,'FACTURADA','ATENDIDA')) EstadoC\n    , IFNULL(ingreso.`Id`, '') NIngreso\t\n    , IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n    , IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio \n    , IFNULL(`h_atencion`.`Codigo_Dxp`,'') AS DxP\n    , IFNULL(`g_patologia`.`Nbre`,'') AS Diagnostico,if(g_persona.Telefono = '' and g_persona.Movil ='', 'NO REGISTRA',  \nif((g_persona.Telefono <> '' and g_persona.Movil =''),g_persona.Telefono,\nif((g_persona.Telefono = '' and g_persona.Movil <>''),g_persona.Movil, CONCAT(g_persona.Movil, ' - ', g_persona.Telefono)))) telefono\nFROM\n     `g_persona`\n    INNER JOIN  `c_citasnp`\n        ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio`\n        ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita`\n        ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_ips`\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)\n    INNER JOIN  `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `g_patologia`\n        ON (`h_atencion`.`Codigo_Dxp`=`g_patologia`.`Id`)\n    INNER JOIN  `g_persona` AS `g_persona_1`\n        ON (`g_persona_1`.`Id` = `c_citasnp`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `c_citasnp`.`Id_Especialidad`)\n    LEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`) \nWHERE (`c_citasnp`.`Fecha_Cita` >='" + fechaI + "'\n    AND `c_citasnp`.`Fecha_Cita` <='" + fechaF + "'\n    -- AND `c_citasnp`.`Id_Profesional` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'\n)\nORDER BY EstadoC ASC, `FechaI` ASC, `HoraA` ASC;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }
}
