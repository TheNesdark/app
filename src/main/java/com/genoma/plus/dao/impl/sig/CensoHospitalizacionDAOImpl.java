package com.genoma.plus.dao.impl.sig;

import com.genoma.plus.dao.sig.CensoHospitalizacionDAO;
import com.genoma.plus.dto.sig.CensoHospitalizacionDTO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/CensoHospitalizacionDAOImpl.class */
public class CensoHospitalizacionDAOImpl implements CensoHospitalizacionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.CensoHospitalizacionDAO
    public List<CensoHospitalizacionDTO> cargarBusqueda(String fechaI, String fechaF) {
        String sql = "SELECT  `ingreso`.`FechaIngreso` `FechaIngreso`, ingreso.`HoraIngreso` \n, CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-',`g_persona`.`NoDocumento`) AS `Documento` , \nCONCAT(`g_persona`.`Apellido1`, '  ',`g_persona`.`Apellido2`, '  ',`g_persona`.`Nombre1`, '  ', `g_persona`.`Nombre2`) AS `NUsuario` \n, `g_persona`.`Id_Sexo` , CONCAT(`g_persona`.`Edad` ,' ', `g_tipoedad`.`Nbre`,'(S)') AS `Edad` \n, `h_atencion`.`Codigo_Dxp`, IFNULL(g_patologia.`Nbre`, '') NPatologia ,\n `profesional1`.`Especialidad` , `profesional1`.`NProfesional` , `f_empresacontxconvenio`.`Nbre` nEmpresaConvenio\n,g_tipoatencion.`Nbre` AS tipoAtencion \n, IFNULL(h_egreso_atencion.`FechaSO` , '') Fecha_Egreso\n, IFNULL(h_egreso_atencion.`HoraSO` , '') Hora_Egreso\n, gi.Nbre  nombreIps\n, g_persona.Id_TipoIdentificacion tipoDocumento\n, g_persona.NoDocumento numeroDocumento\n, g_persona.FechaNac fechaNacimiento\n,`g_persona`.`Apellido1` primerApellido\n,`g_persona`.`Apellido2` segundoApellido\n,`g_persona`.`Nombre1` primerNombre\n,`g_persona`.`Nombre2` segundoNombre\n, TIMESTAMPDIFF(YEAR , g_persona.FechaNac, `ingreso`.FechaIngreso)edadNumerica\n, gs.Nbre sexo\n,ucase(gn.Nbre) escolaridad\n,gm.Nbre municipioResidencia\n, '' regional\n, ft.Nbre nombreRegimen\n, g_persona.Telefono  telefono\n, g_persona.Movil celular\n, TIMESTAMPDIFF(DAY , `ingreso`.FechaIngreso, IF(h_egreso_atencion.`FechaSO` IS NULL, '" + fechaF + "', h_egreso_atencion.`FechaSO`)) diasEstancia\n, ifnull(dxRealacionado1.Id,'') codigoDxRelacionado1\n, ifnull(dxRealacionado1.Nbre,'')  nombreDxRelacionado1\nFROM `h_atencion` \nINNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n INNER JOIN `g_tipoatencion` ON (`g_tipoatencion`.`Id`=`ingreso`.`Id_TipoAtencion`) \nINNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) \nAND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) \nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \ninner join g_ips gi  on (gi.Id=f_empresacontxconvenio.Id_GIps)\ninner join f_tiporegimen ft on (ft.Id=f_empresacontxconvenio.Id_TipoRegimen)\nINNER JOIN  `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \ninner join g_sexo gs  on (gs.Id=g_persona.Id_Sexo)\n  inner join g_nivelestudio gn   on (gn.Id=ingreso.Id_NivelEstudio)\n   inner join g_municipio gm   on (gm.Id=g_persona.Id_Municipio)\nINNER JOIN  `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) \nLEFT JOIN  `h_egreso_atencion`  ON (h_egreso_atencion.`Id_Atencion` = `h_atencion`.`Id`) AND (h_egreso_atencion.`Estado`=1)\nLEFT JOIN  `g_patologia`  ON (g_patologia.`Id` = `h_atencion`.`Codigo_Dxp`) \nLEFT JOIN  `g_patologia` dxRealacionado1  ON (dxRealacionado1.`Id` = `h_atencion`.Codigo_DxR1 )  \nWHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `ingreso`.`Id_TipoAtencion` >1  AND ((h_egreso_atencion.`FechaSO` IS NULL) \n OR IF(h_egreso_atencion.`FechaSO` IS NULL, `ingreso`.`FechaIngreso`, h_egreso_atencion.`FechaSO`) >='" + fechaI + "' \nAND IF(`ingreso`.`FechaIngreso` IS NULL, h_egreso_atencion.`FechaSO`, `ingreso`.`FechaIngreso`)<='" + fechaF + "')  \nAND `ingreso`.`Estado` =0) ORDER BY `ingreso`.`FechaIngreso` ASC, `NUsuario` ASC";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.CensoHospitalizacionDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                CensoHospitalizacionDTO censoHosp = new CensoHospitalizacionDTO();
                censoHosp.setFechaIngreso(rs.getDate("FechaIngreso"));
                censoHosp.setHoraIngreso(rs.getString("HoraIngreso"));
                censoHosp.setDocumento(rs.getString("Documento"));
                censoHosp.setNUsuario(rs.getString("NUsuario"));
                censoHosp.setId_Sexo(rs.getString("Id_Sexo"));
                censoHosp.setEdad(rs.getString("Edad"));
                censoHosp.setCodigo_Dxp(rs.getString("Codigo_Dxp"));
                censoHosp.setNPatologia(rs.getString("NPatologia"));
                censoHosp.setEspecialidad(rs.getString("Especialidad"));
                censoHosp.setNProfesional(rs.getString("NProfesional"));
                censoHosp.setNEmpresaConvenio(rs.getString("nEmpresaConvenio"));
                censoHosp.setTipoAtencion(rs.getString("tipoAtencion"));
                censoHosp.setFecha_Egreso(rs.getString("Fecha_Egreso"));
                censoHosp.setHora_Egreso(rs.getString("Hora_Egreso"));
                censoHosp.setCodigoDxRelacionado1(rs.getString("codigoDxRelacionado1"));
                censoHosp.setNombreDxRelacionado1(rs.getString("nombreDxRelacionado1"));
                censoHosp.setDiasEstancia(Integer.valueOf(rs.getInt("diasEstancia")));
                censoHosp.setEscolaridad(rs.getString("escolaridad"));
                censoHosp.setMunicipioResidencia(rs.getString("municipioResidencia"));
                censoHosp.setRegional(rs.getString("regional"));
                censoHosp.setNombreRegimen(rs.getString("nombreRegimen"));
                censoHosp.setTelefono(rs.getString("telefono"));
                censoHosp.setCelular(rs.getString("celular"));
                censoHosp.setSexo(rs.getString("sexo"));
                censoHosp.setPrimerApellido(rs.getString("primerApellido"));
                censoHosp.setSegundoApellido(rs.getString("segundoApellido"));
                censoHosp.setPrimerNombre(rs.getString("primerNombre"));
                censoHosp.setSegundoNombre(rs.getString("segundoNombre"));
                censoHosp.setNombreIps(rs.getString("nombreIps"));
                censoHosp.setTipoDocumento(rs.getString("tipoDocumento"));
                censoHosp.setNumeroDocumento(rs.getString("numeroDocumento"));
                censoHosp.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                censoHosp.setEdadNumerica(Integer.valueOf(rs.getInt("edadNumerica")));
                return censoHosp;
            }
        };
        List<CensoHospitalizacionDTO> lstSesiones = this.jdbcTemplate.query(sql, rowMapper);
        return lstSesiones;
    }

    @Override // com.genoma.plus.dao.sig.CensoHospitalizacionDAO
    public List<CensoHospitalizacionDTO> cargarBusquedaConvenio(int idCOnvenio, String fechaI, String fechaF) {
        String sql = "SELECT  `ingreso`.`FechaIngreso` AS `FechaIngreso`, ingreso.`HoraIngreso` \n, CONCAT(`g_persona`.`Id_TipoIdentificacion`,'-',`g_persona`.`NoDocumento`) AS `Documento` , \nCONCAT(`g_persona`.`Apellido1`, '  ',`g_persona`.`Apellido2`, '  ',`g_persona`.`Nombre1`, '  ', `g_persona`.`Nombre2`) AS `NUsuario` \n, `g_persona`.`Id_Sexo` , CONCAT(`g_persona`.`Edad` ,' ', `g_tipoedad`.`Nbre`,'(S)') AS `Edad` \n, `h_atencion`.`Codigo_Dxp`, IFNULL(g_patologia.`Nbre`, '') NPatologia ,\n `profesional1`.`Especialidad` , `profesional1`.`NProfesional` , `f_empresacontxconvenio`.`Nbre` nEmpresaConvenio\n,g_tipoatencion.`Nbre` AS tipoAtencion \n, IFNULL(h_egreso_atencion.`FechaSO` , '') Fecha_Egreso\n, IFNULL(h_egreso_atencion.`HoraSO` , '') Hora_Egreso\n, gi.Nbre  nombreIps\n, g_persona.Id_TipoIdentificacion tipoDocumento\n, g_persona.NoDocumento numeroDocumento\n, g_persona.FechaNac fechaNacimiento\n,`g_persona`.`Apellido1` primerApellido\n,`g_persona`.`Apellido2` segundoApellido\n,`g_persona`.`Nombre1` primerNombre\n,`g_persona`.`Nombre2` segundoNombre\n, TIMESTAMPDIFF(YEAR , g_persona.FechaNac, `ingreso`.FechaIngreso)edadNumerica\n, gs.Nbre sexo\n,ucase(gn.Nbre) escolaridad\n,gm.Nbre municipioResidencia\n, '' regional\n, ft.Nbre nombreRegimen\n, g_persona.Telefono  telefono\n, g_persona.Movil celular\n, TIMESTAMPDIFF(DAY , `ingreso`.FechaIngreso, IF(h_egreso_atencion.`FechaSO` IS NULL, '" + fechaF + "', h_egreso_atencion.`FechaSO`)) diasEstancia\n, ifnull(dxRealacionado1.Id,'') codigoDxRelacionado1\n, ifnull(dxRealacionado1.Nbre,'')  nombreDxRelacionado1\nFROM `h_atencion` \nINNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n INNER JOIN `g_tipoatencion` ON (`g_tipoatencion`.`Id`=`ingreso`.`Id_TipoAtencion`) \nINNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) \nAND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) \nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \ninner join g_ips gi  on (gi.Id=f_empresacontxconvenio.Id_GIps)\ninner join f_tiporegimen ft on (ft.Id=f_empresacontxconvenio.Id_TipoRegimen)\nINNER JOIN  `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \ninner join g_sexo gs  on (gs.Id=g_persona.Id_Sexo)\n  inner join g_nivelestudio gn   on (gn.Id=ingreso.Id_NivelEstudio)\n   inner join g_municipio gm   on (gm.Id=g_persona.Id_Municipio)\nINNER JOIN  `g_tipoedad`  ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`) \nLEFT JOIN  `h_egreso_atencion`  ON (h_egreso_atencion.`Id_Atencion` = `h_atencion`.`Id`) AND (h_egreso_atencion.`Estado`=1)\nLEFT JOIN  `g_patologia`  ON (g_patologia.`Id` = `h_atencion`.`Codigo_Dxp`) \nLEFT JOIN  `g_patologia` dxRealacionado1  ON (dxRealacionado1.`Id` = `h_atencion`.Codigo_DxR1 ) \nWHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `ingreso`.`Id_TipoAtencion` >1  AND ((h_egreso_atencion.`FechaSO` IS NULL) \n OR IF(h_egreso_atencion.`FechaSO` IS NULL, `ingreso`.`FechaIngreso`, h_egreso_atencion.`FechaSO`) >='" + fechaI + "'  \nAND IF(`ingreso`.`FechaIngreso` IS NULL, h_egreso_atencion.`FechaSO`, `ingreso`.`FechaIngreso`)<='" + fechaF + "')  \nAND `f_empresacontxconvenio`.`Id`= '" + idCOnvenio + "' AND `ingreso`.`Estado` =0) ORDER BY `ingreso`.`FechaIngreso` ASC, `NUsuario` ASC";
        RowMapper rowMapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.CensoHospitalizacionDAOImpl.2
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                CensoHospitalizacionDTO censoHosp = new CensoHospitalizacionDTO();
                censoHosp.setFechaIngreso(rs.getDate("FechaIngreso"));
                censoHosp.setHoraIngreso(rs.getString("HoraIngreso"));
                censoHosp.setDocumento(rs.getString("Documento"));
                censoHosp.setNUsuario(rs.getString("NUsuario"));
                censoHosp.setId_Sexo(rs.getString("Id_Sexo"));
                censoHosp.setEdad(rs.getString("Edad"));
                censoHosp.setCodigo_Dxp(rs.getString("Codigo_Dxp"));
                censoHosp.setNPatologia(rs.getString("NPatologia"));
                censoHosp.setEspecialidad(rs.getString("Especialidad"));
                censoHosp.setNProfesional(rs.getString("NProfesional"));
                censoHosp.setNEmpresaConvenio(rs.getString("nEmpresaConvenio"));
                censoHosp.setTipoAtencion(rs.getString("tipoAtencion"));
                censoHosp.setFecha_Egreso(rs.getString("Fecha_Egreso"));
                censoHosp.setHora_Egreso(rs.getString("Hora_Egreso"));
                censoHosp.setCodigoDxRelacionado1(rs.getString("codigoDxRelacionado1"));
                censoHosp.setDiasEstancia(Integer.valueOf(rs.getInt("diasEstancia")));
                censoHosp.setEscolaridad(rs.getString("escolaridad"));
                censoHosp.setMunicipioResidencia(rs.getString("municipioResidencia"));
                censoHosp.setRegional(rs.getString("regional"));
                censoHosp.setNombreRegimen(rs.getString("nombreRegimen"));
                censoHosp.setTelefono(rs.getString("telefono"));
                censoHosp.setCelular(rs.getString("celular"));
                censoHosp.setSexo(rs.getString("sexo"));
                censoHosp.setPrimerApellido(rs.getString("primerApellido"));
                censoHosp.setSegundoApellido(rs.getString("segundoApellido"));
                censoHosp.setPrimerNombre(rs.getString("primerNombre"));
                censoHosp.setSegundoNombre(rs.getString("segundoNombre"));
                censoHosp.setNombreIps(rs.getString("nombreIps"));
                censoHosp.setTipoDocumento(rs.getString("tipoDocumento"));
                censoHosp.setNumeroDocumento(rs.getString("numeroDocumento"));
                censoHosp.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                censoHosp.setEdadNumerica(Integer.valueOf(rs.getInt("edadNumerica")));
                return censoHosp;
            }
        };
        List<CensoHospitalizacionDTO> lstSesiones = this.jdbcTemplate.query(sql, rowMapper);
        return lstSesiones;
    }

    @Override // com.genoma.plus.dao.sig.CensoHospitalizacionDAO
    public List<GenericoComboDTO> cargarCombo(String fechaI, String fechaF) {
        String xsql = "SELECT  `f_empresacontxconvenio`.`Id` AS Id_Conv\n, `f_empresacontxconvenio`.`Nbre` AS nEmpresaConvenio\nFROM `h_atencion` \nINNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nLEFT JOIN  `h_egreso_atencion`  ON (h_egreso_atencion.`Id_Atencion` = `h_atencion`.`Id`) AND (h_egreso_atencion.`Estado`=1)\nWHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `ingreso`.`Id_TipoAtencion` >=2  AND ((h_egreso_atencion.`FechaSO` IS NULL) \n OR IF(h_egreso_atencion.`FechaSO` IS NULL, `ingreso`.`FechaIngreso`, h_egreso_atencion.`FechaSO`) >='" + fechaI + "' \nAND IF(`ingreso`.`FechaIngreso` IS NULL, h_egreso_atencion.`FechaSO`, `ingreso`.`FechaIngreso`)<='" + fechaF + "')  \nAND `ingreso`.`Estado` =0) GROUP BY nEmpresaConvenio ORDER BY nEmpresaConvenio ASC";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.CensoHospitalizacionDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                GenericoComboDTO g = new GenericoComboDTO();
                g.setId(rs.getLong("Id_Conv"));
                g.setNombre(rs.getString("nEmpresaConvenio"));
                return g;
            }
        };
        System.out.println("sql combo--> " + xsql);
        List<GenericoComboDTO> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
