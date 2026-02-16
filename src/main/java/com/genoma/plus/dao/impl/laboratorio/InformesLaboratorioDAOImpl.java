package com.genoma.plus.dao.impl.laboratorio;

import com.genoma.plus.dao.laboratorio.InformesLaboratorioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/laboratorio/InformesLaboratorioDAOImpl.class */
public class InformesLaboratorioDAOImpl implements InformesLaboratorioDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.laboratorio.InformesLaboratorioDAO
    public List<Object[]> informeEstadisticamuestraNuevas(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.InformesLaboratorioDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), Long.valueOf(rs.getLong(2)), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)};
                return fila;
            }
        };
        String sql = "SELECT `l_recepcion`.`FechaRecep`  , `l_recepcion`.`Id` , CONCAT(`g_persona`.`Id_TipoIdentificacion`,' ', `g_persona`.`NoDocumento`) AS `Documento` ,\n CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) , `g_persona`.`Telefono` , \n  CONCAT(`Devuelve_Edad_2F`(g_persona.`FechaNac`, DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d')),' ', `Devuelve_Tipo_Edad_2F`(g_persona.`FechaNac`, DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d'))) AS `Edad` , `g_persona`.`Id_Sexo` , \nf_empresacontxconvenio.`Nbre` `EPS` , `profesional1`.`NProfesional` , IF(`ingreso`.`DxIngreso`='0000', '', `ingreso`.`DxIngreso`) AS DxIngreso , \n  GROUP_CONCAT(`g_procedimiento`.`Nbre` ORDER BY `g_procedimiento`.`Nbre` ASC SEPARATOR '') AS `Procedimiento` \n  ,  GROUP_CONCAT(`g_procedimiento`.`Ref` ORDER BY `g_procedimiento`.`Ref` ASC SEPARATOR ',') AS `Abreviatura` , \ng_municipio.`Nbre` AS `NMunicipioU`, IF(l_recepcion.Tipo=1, 'SI', 'NO') EsUrgente, ingreso.Observacion \nFROM    `l_recepcion` \nINNER JOIN  `l_detallerecepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`) \nINNER JOIN `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) \nINNER JOIN `g_persona`  ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`) \nINNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `l_recepcion`.`Id_Profesional`) \nAND (`profesional1`.`IdEspecialidad` = `l_recepcion`.`Id_Especialidad`)\n INNER JOIN `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\n  INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) \n  INNER JOIN `g_municipio`  ON (g_municipio.`Id` = `g_persona`.`Id_Municipio`) \n  INNER JOIN `f_empresacontxconvenio`  ON (f_empresacontxconvenio.`Id` = `ingreso`.`Id_EmpresaContxConv`)  \nWHERE (DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') >='" + xFechai + "' AND DATE_FORMAT(`l_recepcion`.`FechaRecep`,'%Y-%m-%d') <='" + xFechaf + "' AND `l_recepcion`.`Estado` =0 AND ingreso.`NMuestra`= 1) \nGROUP BY `l_recepcion`.`Id` \nORDER BY `l_recepcion`.`FechaRecep` ASC, `l_recepcion`.`Id` ASC ";
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.laboratorio.InformesLaboratorioDAO
    public List<Object[]> informeEstadisticaExamenesPorServicios(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.InformesLaboratorioDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), Integer.valueOf(rs.getInt(5))};
                return fila;
            }
        };
        String sql = "SELECT  gt.Nbre servicio , f_empresacontxconvenio.Nbre nombreConvenio\n    ,g_procedimiento.C_Homologado codigoCups\n    , g_procedimiento.Nbre nombreProcedimiento, COUNT(l_detallerecepcion.Id_Recepcion) AS cantidad\nFROM l_recepcion\nINNER JOIN l_detallerecepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) \nINNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) \nINNER JOIN `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) \nINNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = ingreso.`Id`) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nINNER JOIN g_empresa  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresa.Id)\n inner join g_tipoatencion gt  on (gt.Id=l_recepcion.Id_TipoA) WHERE  (DATE_FORMAT(FechaRecep,'%Y-%m-%d') BETWEEN '" + xFechai + "' and '" + xFechaf + "' AND l_recepcion.Estado =0 \nand ingreso.Id_TipoAtencion<>1) \nGROUP BY f_empresacontxconvenio.Id ,  g_procedimiento.Id\nORDER BY f_empresacontxconvenio.Nbre , g_procedimiento.Nbre ASC";
        System.err.println("sql1" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.laboratorio.InformesLaboratorioDAO
    public List<Object[]> informeEstadisticaExamenesPorServiciosAmbulatoria(String xFechai, String xFechaf) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.laboratorio.InformesLaboratorioDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), Integer.valueOf(rs.getInt(4))};
                return fila;
            }
        };
        String sql = "SELECT  f_empresacontxconvenio.Nbre nombreConvenio\n    ,g_procedimiento.C_Homologado codigoCups\n    , g_procedimiento.Nbre nombreProcedimiento, COUNT(l_detallerecepcion.Id_Recepcion) AS cantidad\nFROM l_recepcion\nINNER JOIN l_detallerecepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) \nINNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) \nINNER JOIN `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) \nINNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = ingreso.`Id`) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nINNER JOIN g_empresa  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresa.Id)\nWHERE  (DATE_FORMAT(FechaRecep,'%Y-%m-%d') BETWEEN '" + xFechai + "' and '" + xFechaf + "' AND l_recepcion.Estado =0 \nand ingreso.Id_TipoAtencion=1) \nGROUP BY f_empresacontxconvenio.Id ,  g_procedimiento.Id\nORDER BY f_empresacontxconvenio.Nbre , g_procedimiento.Nbre ASC";
        System.err.println("sql" + sql);
        List<Object[]> list = this.jdbcTemplate.query(sql, mapper);
        return list;
    }
}
