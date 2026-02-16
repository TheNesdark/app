package com.genoma.plus.dao.impl.citas;

import Acceso.Principal;
import com.genoma.plus.dao.citas.InformesCitasDAO;
import com.genoma.plus.dto.citas.ConsultarCitasAtendidasDTO;
import com.genoma.plus.dto.citas.ConsultarCitasNoAtendidasDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/citas/InformesCitasDAOImpl.class */
public class InformesCitasDAOImpl implements InformesCitasDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.citas.InformesCitasDAO
    public List<ConsultarCitasAtendidasDTO> listProgramadas(String xfechaI, String xfechaF, String xidEspecialidad, String xidProfesional) {
        String xsql;
        if (xidProfesional.equals("-1")) {
            System.out.println("entrando en consulta programada id profesional -1 \n ");
            xsql = "SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(`Devuelve_Edad_2F`(g_persona.`FechaNac`, `c_citas`.`Fecha_Cita`), ' ', `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`, `c_citas`.`Fecha_Cita`)) AS Edad\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`\n    , `g_ips`.`Nbre` AS `NEntidadF`\n    , `c_citas`.`Fecha_Cita` AS `FechaI`\n    , `c_citas`.`HoraInicial` AS `HoraA`\n    , `g_especialidad`.`Nbre` AS `especialidad`\n    , CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `profesional`\n    , if(c_citas.Asistida=0,'ASIGNADA', if(c_citas.Asistida=1,'FACTURADA',if(c_citas.Asistida=2,'EN ATENCION', 'ATENDIDA'))) Estado\n  , IFNULL(ingreso.`Id`, '') NIngreso\t\n    ,IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n     ,IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio \nFROM\n     `g_persona`\n    INNER JOIN  `c_citas`\n        ON (`g_persona`.`Id` = `c_citas`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio`\n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita`\n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_ips`\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    left JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)\n    left JOIN  `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` AS `g_persona_1`\n        ON (`g_persona_1`.`Id` = `c_citas`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`)\nLEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`)\t\t\n WHERE (`c_citas`.`Fecha_Cita` >='" + xfechaI + "' AND `c_citas`.`Fecha_Cita` <='" + xfechaF + "' AND `c_citas`.`Id_Especialidad` ='" + xidEspecialidad + "' AND c_citas.Id_MotivoDesistida=1)\nORDER BY `FechaI` ASC, `HoraA` ASC;";
            System.out.println("ando en consulta  programada id profesional -1 \n " + xsql);
        } else {
            System.out.println("entrando en consulta  programada id profesional diferente -1 \n ");
            xsql = "SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(`Devuelve_Edad_2F`(g_persona.`FechaNac`,c_citas.`Fecha_Cita`), ' ', `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`,c_citas.`Fecha_Cita`) ) AS Edad\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`\n    , `g_ips`.`Nbre` AS `NEntidadF`\n    , `c_citas`.`Fecha_Cita` AS `FechaI`\n    , `c_citas`.`HoraInicial` AS `HoraA`\n    , `g_especialidad`.`Nbre` AS `especialidad`\n    , CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `profesional`\n    , if(c_citas.Asistida=0,'ASIGNADA', if(c_citas.Asistida=1,'FACTURADA',if(c_citas.Asistida=2,'EN ATENCION', 'ATENDIDA'))) Estado\n  , IFNULL(ingreso.`Id`, '') NIngreso\t\n    ,IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n     ,IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio \nFROM\n     `g_persona`\n    INNER JOIN  `c_citas`\n        ON (`g_persona`.`Id` = `c_citas`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio`\n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita`\n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_ips`\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    left JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)\n    left JOIN  `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` AS `g_persona_1`\n        ON (`g_persona_1`.`Id` = `c_citas`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`)\nLEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`)\t\t\n WHERE (`c_citas`.`Fecha_Cita` >='" + xfechaI + "' AND `c_citas`.`Fecha_Cita` <='" + xfechaF + "' AND `c_citas`.`Id_Profesional` ='" + xidProfesional + "' AND `c_citas`.`Id_Especialidad` ='" + xidEspecialidad + "' AND c_citas.Id_MotivoDesistida=1)\nORDER BY `FechaI` ASC, `HoraA` ASC;";
            System.out.println("ando en consulta  programada id profesional  diferente -1 \n " + xsql);
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.citas.InformesCitasDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsultarCitasAtendidasDTO g = new ConsultarCitasAtendidasDTO();
                g.setNDocumento(rs.getString("Documento"));
                g.setUsuario(rs.getString("NUsuario"));
                g.setSexo(rs.getString("Id_Sexo"));
                g.setEdad(rs.getString("Edad"));
                g.setTipoCita(rs.getString("NClaseCita"));
                g.setEntidad(rs.getString("NEmpresaC"));
                g.setIps(rs.getString("NEntidadF"));
                g.setHora(rs.getString("HoraA"));
                g.setFecha(rs.getString("FechaI"));
                g.setEstado(rs.getString("Estado"));
                g.setNIngreso(rs.getString("NIngreso"));
                g.setNFactura(rs.getString("NFactura"));
                g.setNOrdenS(rs.getString("NServicio"));
                g.setEspecialidad(rs.getString("especialidad"));
                g.setProfesional(rs.getString("profesional"));
                return g;
            }
        };
        List<ConsultarCitasAtendidasDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.citas.InformesCitasDAO
    public List<ConsultarCitasAtendidasDTO> listNoProgramadas(String xfechaI, String xfechaF, String xidEspecialidad, String xidProfesional) {
        String xsql;
        if (!xidProfesional.equals("-1")) {
            System.out.println("entrando en consulta no programada id profesional diferente -1 \n ");
            xsql = "SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(`Devuelve_Edad_2F`(g_persona.`FechaNac`, `c_citasnp`.`Fecha_Cita`), ' ', `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`, `c_citasnp`.`Fecha_Cita`) ) AS Edad\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`\n    , `g_ips`.`Nbre` AS `NEntidadF`\n    , `c_citasnp`.`Fecha_Cita` AS `FechaI`\n    , `c_citasnp`.`HoraInicial` AS `HoraA`\n    , `g_especialidad`.`Nbre` AS `especialidad`, g_persona_1.`Id`\n    , CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `profesional`\n, IF((h_atencion.Codigo_Dxp ='' or  h_atencion.Codigo_Dxp is null) , 'POR ATENCION', 'ATENDIDA') EstadoC\n, c_citasnp.Asistida\n  , IFNULL(ingreso.`Id`, '') NIngreso\t\n    ,IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n     ,IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio \nFROM\n     `g_persona`\n    INNER JOIN  `c_citasnp`\n        ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio`\n        ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita`\n        ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_ips`\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)\n    INNER JOIN  `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` AS `g_persona_1`\n        ON (`g_persona_1`.`Id` = `h_atencion`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\nLEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`) \nWHERE (`c_citasnp`.`Fecha_Cita` >='" + xfechaI + "'\n    AND `c_citasnp`.`Fecha_Cita` <='" + xfechaF + "'\n    AND `h_atencion`.`Id_Profesional` ='" + xidProfesional + "'\n    AND `h_atencion`.`Id_Especialidad` ='" + xidEspecialidad + "'\n    )\nORDER BY EstadoC ASC, `FechaI` ASC, `HoraA` ASC;";
            System.out.println("ando en consulta no programada id profesional diferente de -1 \n " + xsql);
        } else {
            System.out.println("entrando en consulta no programada id profesional -1 \n ");
            xsql = "SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(`Devuelve_Edad_2F`(g_persona.`FechaNac`, `c_citasnp`.`Fecha_Cita`), ' ', `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`, `c_citasnp`.`Fecha_Cita`) ) AS Edad\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`\n    , `g_ips`.`Nbre` AS `NEntidadF`\n    , `c_citasnp`.`Fecha_Cita` AS `FechaI`\n    , `c_citasnp`.`HoraInicial` AS `HoraA`\n    , `g_especialidad`.`Nbre` AS `especialidad`, g_persona_1.`Id`\n    , CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `profesional`\n, IF((h_atencion.Codigo_Dxp ='' or  h_atencion.Codigo_Dxp is null) , 'POR ATENCION', 'ATENDIDA') EstadoC\n, c_citasnp.Asistida\n  , IFNULL(ingreso.`Id`, '') NIngreso\t\n    ,IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n     ,IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio \nFROM\n     `g_persona`\n    INNER JOIN  `c_citasnp`\n        ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio`\n        ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita`\n        ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_ips`\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)\n    INNER JOIN  `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` AS `g_persona_1`\n        ON (`g_persona_1`.`Id` = `h_atencion`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\nLEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`) \nWHERE (`c_citasnp`.`Fecha_Cita` >='" + xfechaI + "'\n    AND `c_citasnp`.`Fecha_Cita` <='" + xfechaF + "'\n    AND `h_atencion`.`Id_Especialidad` ='" + xidEspecialidad + "')\nORDER BY EstadoC ASC, `FechaI` ASC, `HoraA` ASC;";
            System.out.println("ando en consulta no programada id profesional -1 \n " + xsql);
        }
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.citas.InformesCitasDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsultarCitasAtendidasDTO g = new ConsultarCitasAtendidasDTO();
                g.setNDocumento(rs.getString("Documento"));
                g.setUsuario(rs.getString("NUsuario"));
                g.setSexo(rs.getString("Id_Sexo"));
                g.setEdad(rs.getString("Edad"));
                g.setTipoCita(rs.getString("NClaseCita"));
                g.setEntidad(rs.getString("NEmpresaC"));
                g.setIps(rs.getString("NEntidadF"));
                g.setHora(rs.getString("HoraA"));
                g.setFecha(rs.getString("FechaI"));
                g.setEstado(rs.getString("EstadoC"));
                g.setNIngreso(rs.getString("NIngreso"));
                g.setNFactura(rs.getString("NFactura"));
                g.setNOrdenS(rs.getString("NServicio"));
                g.setEspecialidad(rs.getString("especialidad"));
                g.setProfesional(rs.getString("profesional"));
                return g;
            }
        };
        List<ConsultarCitasAtendidasDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.citas.InformesCitasDAO
    public void addConsolidadoCitasTmp(String xfechaI, String xfechaF, String xidEspecialidad, String xidProfesional, Integer xTipo) {
        String xsql;
        if (xTipo.intValue() == 0) {
            if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                xsql = "INSERT INTO c_tmp_ccitas SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`\n    , `g_ips`.`Nbre` AS `NEntidadF`\n    , `c_citas`.`Fecha_Cita` AS `FechaI`\n    , `c_citas`.`HoraInicial` AS `HoraA`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    , CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `NProfesional`\n    , if(c_citas.Asistida=0,'ASIGNADOS NO FACTURADOS', if(c_citas.Asistida=1,'FACTURADA',if(c_citas.Asistida=2,'EN ATENCION', 'ATENDIDA'))) EstadoC\n  , IFNULL(ingreso.`Id`, '') NIngreso\t\n    ,IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n     ,IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio, 'PROGRAMADA' Tipo \nFROM\n     `g_persona`\n    INNER JOIN  `c_citas`\n        ON (`g_persona`.`Id` = `c_citas`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio`\n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita`\n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_ips`\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    left JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)\n    left JOIN  `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` AS `g_persona_1`\n        ON (`g_persona_1`.`Id` = `c_citas`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`)\nLEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`)\t\t\n WHERE (`c_citas`.`Fecha_Cita` >='" + xfechaI + "' AND `c_citas`.`Fecha_Cita` <='" + xfechaF + "' AND `c_citas`.`Id_Profesional` ='" + xidProfesional + "' AND `c_citas`.`Id_Especialidad` ='" + xidEspecialidad + "' AND c_citas.Id_MotivoDesistida=1)\nORDER BY `FechaI` ASC, `HoraA` ASC;";
            } else {
                xsql = "INSERT INTO c_tmp_ccitas SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`\n    , `g_ips`.`Nbre` AS `NEntidadF`\n    , `c_citas`.`Fecha_Cita` AS `FechaI`\n    , `c_citas`.`HoraInicial` AS `HoraA`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    , CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `NProfesional`\n    , if(c_citas.Asistida=0,'ASIGNADA', if(c_citas.Asistida=1,'FACTURADA',if(c_citas.Asistida=2,'EN ATENCION', 'ATENDIDA'))) EstadoC\n  , IFNULL(ingreso.`Id`, '') NIngreso\t\n    ,IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n     ,IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio, 'PROGRAMADA' Tipo \nFROM\n     `g_persona`\n    INNER JOIN  `c_citas`\n        ON (`g_persona`.`Id` = `c_citas`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio`\n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita`\n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_ips`\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    left JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `c_citas`.`Id_ingreso`)\n    left JOIN  `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` AS `g_persona_1`\n        ON (`g_persona_1`.`Id` = `c_citas`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `c_citas`.`Id_Especialidad`)\nLEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`)\t\t\n WHERE (`c_citas`.`Fecha_Cita` >='" + xfechaI + "' AND `c_citas`.`Fecha_Cita` <='" + xfechaF + "' AND `c_citas`.`Id_Profesional` ='" + xidProfesional + "' AND `c_citas`.`Id_Especialidad` ='" + xidEspecialidad + "' AND c_citas.Id_MotivoDesistida=1)\nORDER BY `FechaI` ASC, `HoraA` ASC;";
            }
        } else {
            xsql = "INSERT INTO c_tmp_ccitas SELECT\n    CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-', `g_persona`.`NoDocumento`) AS `Documento`\n    , CONCAT(`g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaC`\n    , `g_ips`.`Nbre` AS `NEntidadF`\n    , `c_citasnp`.`Fecha_Cita` AS `FechaI`\n    , `c_citasnp`.`HoraInicial` AS `HoraA`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    , CONCAT(`g_persona_1`.`Nombre1`,' ', `g_persona_1`.`Nombre2`,' ',`g_persona_1`.`Apellido1`,' ',`g_persona_1`.`Apellido2`)  AS `NProfesional`\n, IF(c_citasnp.Asistida=0,'POR ATENCION', IF(c_citasnp.Asistida=1,'FACTURADA','ATENDIDA')) EstadoC\n  , IFNULL(ingreso.`Id`, '') NIngreso\t\n    ,IF(f_factura_evento.`No_FacturaEvento` IS NULL, '', CONCAT('FV-', f_factura_evento.`No_FacturaEvento`)) NFactura\n     ,IF(f_factura_capita.`No_FacturaCapita` IS NULL, '', CONCAT('OS-',f_factura_capita.`No_FacturaCapita`)) NServicio, 'NO PROGRAMADA' Tipo \nFROM\n     `g_persona`\n    INNER JOIN  `c_citasnp`\n        ON (`g_persona`.`Id` = `c_citasnp`.`Id_Usuario`)\n    INNER JOIN  `f_empresacontxconvenio`\n        ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita`\n        ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_ips`\n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN  `ingreso`\n        ON (`ingreso`.`Id` = `c_citasnp`.`Id_ingreso`)\n    INNER JOIN  `h_atencion`\n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `g_persona` AS `g_persona_1`\n        ON (`g_persona_1`.`Id` = `h_atencion`.`Id_Profesional`)\n    INNER JOIN  `g_especialidad`\n        ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\nLEFT JOIN  `f_liquidacion`\n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) AND (f_liquidacion.`Estado`=0)\n    LEFT JOIN `f_factura_evento`\n        ON (`f_liquidacion`.`Id` = `f_factura_evento`.`Id_Liquidacion`)\n    LEFT JOIN  `f_factura_capita`\n        ON (`f_liquidacion`.`Id` = `f_factura_capita`.`Id_Liquidacion`) \nWHERE (`c_citasnp`.`Fecha_Cita` >='" + xfechaI + "'\n    AND `c_citasnp`.`Fecha_Cita` <='" + xfechaF + "'\n    AND `h_atencion`.`Id_Profesional` ='" + xidProfesional + "'\n    AND `h_atencion`.`Id_Especialidad` ='" + xidEspecialidad + "'\n    )\nORDER BY EstadoC ASC, `FechaI` ASC, `HoraA` ASC;";
        }
        this.jdbcTemplate.update(xsql);
    }

    @Override // com.genoma.plus.dao.citas.InformesCitasDAO
    public void deleteInformacionConsolidadoCitasTmp() {
        this.jdbcTemplate.update("delete from c_tmp_ccitas");
    }

    @Override // com.genoma.plus.dao.citas.InformesCitasDAO
    public List<ConsultarCitasNoAtendidasDTO> listCitasNoAtendidas(String xfechaI, String xfechaF, String xcondicion) {
        String xsql = "SELECT\n    `c_citas`.`Id` AS `IdCita`\n    , `c_citas`.`Fecha_Cita`\n    , `c_citas`.`HoraInicial`\n    , `g_persona`.`Id_TipoIdentificacion` AS `TipoDoc`\n    , `g_persona`.`NoDocumento`\n    , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo`\n    , `Devuelve_Edad_2F`(`g_persona`.`FechaNac`, `c_citas`.`Fecha_Cita`) AS `Edad`\n    , `Devuelve_Tipo_Edad_2F`(`g_persona`.`FechaNac`, `c_citas`.`Fecha_Cita`)  AS `TipoEdad`\n    , `g_persona`.`Direccion`\n    , `g_barrio`.`Nbre` AS `NBarrio`\n    , `g_municipio`.`Nbre` AS `NMunicipio`\n    , `g_persona`.`Telefono` AS `Telefono`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConvenio`\n    , `c_clasecita`.`Nbre` AS `NClaseCita`\n    , `g_tipoprograma`.`Nbre` AS `NPrograma`\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\nFROM\n     `c_citas`\n    INNER JOIN  `g_usuario` \n        ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_barrio` \n        ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n    INNER JOIN  `g_tipoprograma` \n        ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`)\nWHERE (`c_citas`.`Id_MotivoDesistida` =1\n    AND `c_citas`.`Asistida` =0\n    AND `c_citas`.`Fecha_Cita` >='" + xfechaI + "'\n    AND `c_citas`.`Fecha_Cita` <='" + xfechaF + "'\n" + xcondicion + ");";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.citas.InformesCitasDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsultarCitasNoAtendidasDTO g = new ConsultarCitasNoAtendidasDTO();
                g.setIdCita(Long.valueOf(rs.getLong("IdCita")));
                g.setFecha(rs.getString("Fecha_Cita"));
                g.setHora(rs.getString("HoraInicial"));
                g.setTipoDoc(rs.getString("TipoDoc"));
                g.setNDocumento(rs.getString("NoDocumento"));
                g.setUsuario(rs.getString("NUsuario"));
                g.setSexo(rs.getString("Id_Sexo"));
                g.setEdad(rs.getInt("Edad"));
                g.setTipoEdad(rs.getString("TipoEdad"));
                g.setDireccion(rs.getString("Direccion"));
                g.setBarrio(rs.getString("NBarrio"));
                g.setMunicipio(rs.getString("NMunicipio"));
                g.setTelefono(rs.getString("Telefono"));
                g.setConvenio(rs.getString("NEmpresaConvenio"));
                g.setClaseCita(rs.getString("NClaseCita"));
                g.setPrograma(rs.getString("NPrograma"));
                g.setEspecialidad(rs.getString("Especialidad"));
                g.setProfesional(rs.getString("NProfesional"));
                return g;
            }
        };
        List<ConsultarCitasNoAtendidasDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.citas.InformesCitasDAO
    public List<GCGenericoDTO> listProgramaNoAtendidas(String xfechaI, String xfechaF) {
        String xsql = "SELECT\n    `g_tipoprograma`.`Id_TipoPrograma`\n    , `g_tipoprograma`.`Nbre` AS `NPrograma` \nFROM\n     `c_citas`\n    INNER JOIN  `g_usuario` \n        ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_barrio` \n        ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n    INNER JOIN  `g_tipoprograma` \n        ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`)\nWHERE (`c_citas`.`Id_MotivoDesistida` =1\n    AND `c_citas`.`Asistida` =0\n    AND `c_citas`.`Fecha_Cita` >='" + xfechaI + "'\n    AND `c_citas`.`Fecha_Cita` <='" + xfechaF + "') GROUP BY `g_tipoprograma`.`Id_TipoPrograma` ORDER BY `g_tipoprograma`.`Nbre` ASC;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.citas.InformesCitasDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id_TipoPrograma"));
                g.setNombre(rs.getString("NPrograma"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.citas.InformesCitasDAO
    public List<GCGenericoDTO> listEspecialidadNoAtendidas(String xfechaI, String xfechaF) {
        String xsql = "SELECT\n    profesional1.`IdEspecialidad`\n    , `profesional1`.`Especialidad` \nFROM\n     `c_citas`\n    INNER JOIN  `g_usuario` \n        ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_barrio` \n        ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n    INNER JOIN  `g_tipoprograma` \n        ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`)\nWHERE (`c_citas`.`Id_MotivoDesistida` =1\n    AND `c_citas`.`Asistida` =0\n    AND `c_citas`.`Fecha_Cita` >='" + xfechaI + "'\n    AND `c_citas`.`Fecha_Cita` <='" + xfechaF + "') GROUP BY profesional1.`IdEspecialidad` ORDER BY `profesional1`.`Especialidad`;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.citas.InformesCitasDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("IdEspecialidad"));
                g.setNombre(rs.getString("Especialidad"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.citas.InformesCitasDAO
    public List<GCGenericoDTO> listConvenioNoAtendidas(String xfechaI, String xfechaF) {
        String xsql = "SELECT\n    `f_empresacontxconvenio`.`Id`\n    , `f_empresacontxconvenio`.`Nbre` AS `NEmpresaConvenio`    \nFROM\n     `c_citas`\n    INNER JOIN  `g_usuario` \n        ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_municipio` \n        ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN  `g_barrio` \n        ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n    INNER JOIN  `g_tipoprograma` \n        ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`)\nWHERE (`c_citas`.`Id_MotivoDesistida` =1\n    AND `c_citas`.`Asistida` =0\n    AND `c_citas`.`Fecha_Cita` >='" + xfechaI + "'\n    AND `c_citas`.`Fecha_Cita` <='" + xfechaF + "') GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre`;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.citas.InformesCitasDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id"));
                g.setNombre(rs.getString("NEmpresaConvenio"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.citas.InformesCitasDAO
    public List<GCGenericoDTO> listProfesionalNoAtendidas(String xfechaI, String xfechaF) {
        String xsql = "SELECT\n     `profesional1`.`Id_Persona`\n     , `profesional1`.`NProfesional`\n FROM\n      `c_citas`\n     INNER JOIN  `g_usuario` \n ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n     INNER JOIN  `f_empresacontxconvenio` \n ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n     INNER JOIN  `c_clasecita` \n ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n     INNER JOIN  `g_persona` \n ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)\n     INNER JOIN  `g_municipio` \n ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n     INNER JOIN  `g_barrio` \n ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)\n     INNER JOIN  `g_tipoprograma` \n ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\n     INNER JOIN  `profesional1` \n ON (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`)\n WHERE (`c_citas`.`Id_MotivoDesistida` =1\n     AND `c_citas`.`Asistida` =0\n     AND `c_citas`.`Fecha_Cita` >='" + xfechaI + "'\n     AND `c_citas`.`Fecha_Cita` <='" + xfechaF + "') GROUP BY `profesional1`.`Id_Persona` ORDER BY `profesional1`.`NProfesional`;";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.citas.InformesCitasDAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GCGenericoDTO g = new GCGenericoDTO();
                g.setId(rs.getInt("Id_Persona"));
                g.setNombre(rs.getString("NProfesional"));
                return g;
            }
        };
        List<GCGenericoDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
