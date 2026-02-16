package com.genoma.plus.dao.impl.integracion_simedis;

import Acceso.Principal;
import Utilidades.ConsultasFirebird;
import Utilidades.ConsultasMySQL;
import Utilidades.ConsultasPostgresSql;
import Utilidades.ConsultasSqlServer;
import Utilidades.Metodos;
import com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO;
import com.genoma.plus.dto.integracion_simedis.DGLEnvioResultadosDTO;
import com.genoma.plus.dto.integracion_simedis.LaboratoriosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/integracion_simedis/LaboratorioBienestarDAOImpl.class */
public class LaboratorioBienestarDAOImpl implements LaboratorioBienestarDAO {
    String maximoIdResultado = "";
    private Metodos xmetodos = new Metodos();

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaSede(String fecha, Long idSede, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasFirebird cm = new ConsultasFirebird();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (filtro.booleanValue()) {
                sql = "SELECT \n DISTINCT\nNORDEN\n,FECHAORDEN, HORAORDEN\n, ID_TIPOIDENTIFICACION\n, NODOCUMENTO\n, APELLIDO1\n, APELLIDO2\n, NOMBRE1\n, NOMBRE2\n, ID_SEXO\n, NOMBREEMPRESA\n, FECHANAC\n, DIRECCION\n, MOVIL\n, iif(IDRECEPCION IS NULL, 0, IDRECEPCION) as IDRECEPCION\n, IIF(IDRECEPCION IS NULL,0,1) estadoRecepcion\n, IIF(SEDE=1,1,2) AS SEDE\n, IIF(SEDE=1,'PRINCIPAL','AGUCATALA') AS nombreSede\n FROM LABORATORIOS\nWHERE (SEDE IS NOT NULL  AND FECHAORDEN='" + fecha + "' AND (TRIM(APELLIDO1) ||' '||TRIM( APELLIDO2)||' '||TRIM(NOMBRE1)||' '||TRIM(NOMBRE2) LIKE UPPER('%" + valorFiltro + "%') OR TRIM(NODOCUMENTO) LIKE '" + valorFiltro + "%') AND SEDE =" + idSede + "  AND IIF(IDRECEPCION IS NULL,0,1) IN(" + estado + ")) \nORDER BY NORDEN asc";
            } else {
                sql = "SELECT \n DISTINCT\nNORDEN\n,FECHAORDEN, HORAORDEN\n, ID_TIPOIDENTIFICACION\n, NODOCUMENTO\n, APELLIDO1\n, APELLIDO2\n, NOMBRE1\n, NOMBRE2\n, ID_SEXO\n, NOMBREEMPRESA\n, FECHANAC\n, DIRECCION\n, MOVIL\n, iif(IDRECEPCION IS NULL, 0, IDRECEPCION) as IDRECEPCION\n, IIF(IDRECEPCION IS NULL,0,1) estadoRecepcion\n, IIF(SEDE=1,1,2) AS SEDE\n, IIF(SEDE=1,'PRINCIPAL','AGUCATALA') AS nombreSede\n FROM LABORATORIOS\nWHERE SEDE IS NOT NULL AND FECHAORDEN='" + fecha + "' and SEDE =" + idSede + "  AND IIF(IDRECEPCION IS NULL,0,1) IN(" + estado + ") \nORDER BY NORDEN asc";
            }
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("NORDEN"));
                    e.setFechaOrden(rs2.getString("FECHAORDEN"));
                    e.setTipoDocumento(rs2.getString("ID_TIPOIDENTIFICACION"));
                    e.setDocumento(rs2.getString("NODOCUMENTO"));
                    e.setApellido1(rs2.getString("APELLIDO1"));
                    e.setApellido2(rs2.getString("APELLIDO2"));
                    e.setNombre1(rs2.getString("NOMBRE1"));
                    e.setNombre2(rs2.getString("NOMBRE2"));
                    e.setIdSexo(rs2.getString("ID_SEXO"));
                    e.setNombreEmpresa(rs2.getString("NOMBREEMPRESA"));
                    e.setFechaNacimiento(rs2.getString("FECHANAC"));
                    e.setDireccion(rs2.getString("DIRECCION"));
                    e.setMovil(rs2.getString("MOVIL"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("IDRECEPCION")));
                    e.setHoraOrden(rs2.getString("HORAORDEN"));
                    e.setNombreSede(rs2.getString("nombreSede"));
                    e.setNumeroAdmision("");
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public LaboratoriosDTO recepcionIdOrde(String idOrdenSimendis) {
        ConsultasFirebird cm = new ConsultasFirebird();
        LaboratoriosDTO e = new LaboratoriosDTO();
        try {
            String sql = "SELECT \nNORDEN, FECHAORDEN, HORAORDEN , ID_TIPOIDENTIFICACION, NODOCUMENTO , APELLIDO1 , \nAPELLIDO2 , NOMBRE1 , NOMBRE2 , iif(ID_SEXO='F', 'FEMENINO', 'MASCULINO') idSexo\n, NOMBREEMPRESA , FECHANAC , DIRECCION , MOVIL\n, iif(IDRECEPCION IS NULL, 0, IDRECEPCION) as IDRECEPCION , IIF(IDRECEPCION IS NULL,0,1) estadoRecepcion , IIF(SEDE=1,1,2) AS SEDE\n,  LIST(DISTINCT CODSERVICIO, ',') idServicios\nFROM LABORATORIOS\nWHERE NORDEN=" + idOrdenSimendis + " AND IIF(SEDE=1,1,2) =" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "\nGROUP BY NORDEN, FECHAORDEN, HORAORDEN , ID_TIPOIDENTIFICACION, NODOCUMENTO , APELLIDO1 , APELLIDO2 , NOMBRE1 ,\nNOMBRE2 , iif(ID_SEXO='F', 'FEMENINO', 'MASCULINO'), NOMBREEMPRESA \n\t, FECHANAC , DIRECCION , MOVIL\n\t, iif(IDRECEPCION IS NULL, 0, IDRECEPCION) , IIF(IDRECEPCION IS NULL,0,1), IIF(SEDE=1,1,2)";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    e.setNumeroOrden(rs2.getString("NORDEN"));
                    e.setFechaOrden(rs2.getString("FECHAORDEN"));
                    e.setTipoDocumento(rs2.getString("ID_TIPOIDENTIFICACION"));
                    e.setDocumento(rs2.getString("NODOCUMENTO"));
                    e.setApellido1(rs2.getString("APELLIDO1"));
                    e.setApellido2(rs2.getString("APELLIDO2"));
                    e.setNombre1(rs2.getString("NOMBRE1"));
                    e.setNombre2(rs2.getString("NOMBRE2"));
                    e.setIdSexo(rs2.getString("idSexo"));
                    e.setNombreEmpresa(rs2.getString("NOMBREEMPRESA"));
                    e.setFechaNacimiento(rs2.getString("FECHANAC"));
                    e.setDireccion(rs2.getString("DIRECCION"));
                    e.setMovil(rs2.getString("MOVIL"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("IDRECEPCION")));
                    e.setHoraOrden(rs2.getString("HORAORDEN"));
                    e.setCodigoServicio(rs2.getString("idServicios"));
                    e.setNumeroAdmision("");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarDatosRecepcion(String idOrdenSimedis, Long numeroRecepcion, String fechaRecepcion) {
        ConsultasFirebird cm = new ConsultasFirebird();
        String sql = "update LABORATORIOS set  FECHAPROC='" + fechaRecepcion + "', IDRECEPCION='" + numeroRecepcion + "' WHERE NORDEN=" + idOrdenSimedis + "";
        cm.ejecutaSQLUpdate(sql);
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarResultadoSimedis(Long idRecepcion, String fechaResultado, String valorResultado, Long idProtocoloSimedis) {
        ConsultasFirebird cm = new ConsultasFirebird();
        String sql = "update LABORATORIOS set  RESULTADO='" + valorResultado + "', FECHARES='" + fechaResultado + "', PROCESADOLAB='S', ENTREGADORES='S', USUARIORES='" + Principal.usuarioSistemaDTO.getLogin().trim() + "' WHERE IDRECEPCION=" + idRecepcion + " and CODANALITO=" + idProtocoloSimedis + "";
        int ctos = cm.ejecutaSQLUpdate(sql);
        if (ctos == 0) {
            String sql2 = "update LABORATORIOS set  RESULTADO='" + valorResultado + "', FECHARES='" + fechaResultado + "', PROCESADOLAB='S', ENTREGADORES='S', USUARIORES='" + Principal.usuarioSistemaDTO.getLogin().trim() + "' WHERE IDRECEPCION=" + idRecepcion + " and CODSERVICIO= " + idProtocoloSimedis + " AND CODANALITO=0";
            cm.ejecutaSQLUpdate(sql2);
        }
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaSedeSifa(String fecha, Long idSede, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasMySQL cm = new ConsultasMySQL();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (filtro.booleanValue()) {
                sql = "SELECT\n   `ordenConsecutivo` AS `numeroOrden`\n    , MID(`ordenFechaIngreso`,1,10) AS `fechaOrden`\n    , MID(`ordenFechaIngreso`,12,8) AS `horaOrden`\n    , `pacienteTipoDocumento` AS `tipoIdentificacion`\n    , `pacienteIdentificacion` AS `numeroIdentificacion`\n    , `pacientePrimerApellido`\n    , `pacienteSegundoApellido`\n    , `pacientePrimerNombre`\n    , `pacienteSegundoNombre`\n    , `pacienteSexo`\n    , `convenioNombre`\n    , MID(`pacienteFechaNacimiento`,1,10) AS `fechaNacimieto`\n    , `pacienteDireccion`\n    , `pacienteTelefono`\n    , IFNULL(`idRcepcion`,0) AS `idRecepcion`\n    , IF(`idRcepcion` IS NULL,0, 1) AS `estadoRecepcion`\n    , 1 AS `sede`\n    , 'PRINCIPAL' AS `nombreSede`, l_sifas_orden_examen.`admision`\nFROM\n    `l_sifas_orden_examen`\n  WHERE (ordenConsecutivo LIKE '" + valorFiltro + "%' OR `pacientePrimerApellido` LIKE '%" + valorFiltro + "%' OR pacienteIdentificacion LIKE '" + valorFiltro + "%')\n GROUP BY   `ordenConsecutivo`   ORDER BY `fechaOrden` DESC, `horaOrden` DESC";
            } else {
                sql = "SELECT\n    `ordenConsecutivo`  AS `numeroOrden`\n    , MID(`ordenFechaIngreso`,1,10) AS `fechaOrden`\n    , MID(`ordenFechaIngreso`,12,8) AS `horaOrden`\n    , `pacienteTipoDocumento` AS `tipoIdentificacion`\n    , `pacienteIdentificacion` AS `numeroIdentificacion`\n    , `pacientePrimerApellido`\n    , `pacienteSegundoApellido`\n    , `pacientePrimerNombre`\n    , `pacienteSegundoNombre`\n    , `pacienteSexo`\n    , `convenioNombre`\n    , MID(`pacienteFechaNacimiento`,1,10) AS `fechaNacimieto`\n    , `pacienteDireccion`\n    , `pacienteTelefono`\n    , IFNULL(`idRcepcion`,0) AS `idRecepcion`\n    , IF(`idRcepcion` IS NULL,0, 1) AS `estadoRecepcion`\n    , 1 AS `sede`\n    , 'PRINCIPAL' AS `nombreSede`, l_sifas_orden_examen.`admision`\nFROM\n    `l_sifas_orden_examen`    \n  WHERE (MID(`ordenFechaIngreso`,1,10)='" + fecha + "' AND IF(`idRcepcion` IS NULL,0, 1) IN(" + estado + ") )  \n group by   `ordenConsecutivo`  ORDER BY `fechaOrden` ASC, `horaOrden` ASC";
            }
            ResultSet rs2 = cm.traerRs(sql);
            System.out.println("" + sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("numeroOrden"));
                    e.setFechaOrden(rs2.getString("fechaOrden"));
                    e.setTipoDocumento(rs2.getString("tipoIdentificacion"));
                    e.setDocumento(rs2.getString("numeroIdentificacion"));
                    e.setApellido1(rs2.getString("pacientePrimerApellido"));
                    e.setApellido2(rs2.getString("pacienteSegundoApellido"));
                    e.setNombre1(rs2.getString("pacientePrimerNombre"));
                    e.setNombre2(rs2.getString("pacienteSegundoNombre"));
                    e.setIdSexo(rs2.getString("pacienteSexo"));
                    e.setNombreEmpresa(rs2.getString("convenioNombre"));
                    e.setFechaNacimiento(rs2.getString("fechaNacimieto"));
                    e.setDireccion(rs2.getString("pacienteDireccion"));
                    e.setMovil(rs2.getString("pacienteTelefono"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("idRecepcion")));
                    e.setHoraOrden(rs2.getString("horaOrden"));
                    e.setNombreSede(rs2.getString("nombreSede"));
                    e.setNumeroAdmision(rs2.getString("admision"));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public LaboratoriosDTO recepcionIdOrden(String idOrdenSifas) {
        ConsultasMySQL cm = new ConsultasMySQL();
        LaboratoriosDTO e = new LaboratoriosDTO();
        try {
            String sql = "SELECT\n    `ordenConsecutivo` AS `numeroOrden`\n    , MID(`ordenFechaIngreso`,1,10) AS `fechaOrden`\n    , MID(`ordenFechaIngreso`,12,8) AS `horaOrden`\n    , `pacienteTipoDocumento` AS `tipoIdentificacion`\n    , `pacienteIdentificacion` AS `numeroIdentificacion`\n    , `pacientePrimerApellido`\n    , `pacienteSegundoApellido`\n    , `pacientePrimerNombre`\n    , `pacienteSegundoNombre`\n    , if(`pacienteSexo`='M', 'MASCULINO', 'FEMENINO') AS pacienteSexo\n    , `convenioNombre`\n    , MID(`pacienteFechaNacimiento`,1,10) AS `fechaNacimieto`\n    , `pacienteDireccion`\n    , `pacienteTelefono`\n    , IFNULL(`idRcepcion`,0) AS `idRecepcion`\n    , IF(`idRcepcion` IS NULL,0, 1) AS `estadoRecepcion`\n    , 1 AS `sede`\n    , 'PRINCIPAL' AS `nombreSede`, l_sifas_orden_examen.`admision`\nFROM\n    `l_sifas_orden_examen`    \n  WHERE (ordenConsecutivo='" + idOrdenSifas + "' )  \n  group by ordenConsecutivo \nORDER BY `fechaOrden` ASC, `horaOrden` ASC";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    e.setNumeroOrden(rs2.getString("numeroOrden"));
                    e.setFechaOrden(rs2.getString("fechaOrden"));
                    e.setTipoDocumento(rs2.getString("tipoIdentificacion"));
                    e.setDocumento(rs2.getString("numeroIdentificacion"));
                    e.setApellido1(rs2.getString("pacientePrimerApellido"));
                    e.setApellido2(rs2.getString("pacienteSegundoApellido"));
                    e.setNombre1(rs2.getString("pacientePrimerNombre"));
                    e.setNombre2(rs2.getString("pacienteSegundoNombre"));
                    e.setIdSexo(rs2.getString("pacienteSexo"));
                    e.setNombreEmpresa(rs2.getString("convenioNombre"));
                    e.setFechaNacimiento(rs2.getString("fechaNacimieto"));
                    e.setDireccion(rs2.getString("pacienteDireccion"));
                    e.setMovil(rs2.getString("pacienteTelefono"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("idRecepcion")));
                    e.setHoraOrden(rs2.getString("horaOrden"));
                    e.setNombreSede(rs2.getString("nombreSede"));
                    e.setNumeroAdmision(rs2.getString("admision"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarDatosRecepcionSifas(String idOrdenSifas, Long numeroRecepcion, String fechaRecepcion) {
        ConsultasMySQL cm = new ConsultasMySQL();
        String sql = "update l_sifas_orden_examen set  fechaRecepcion='" + fechaRecepcion + "', idRcepcion='" + numeroRecepcion + "' WHERE (`ordenConsecutivo`='" + idOrdenSifas + "' )";
        cm.ejecutaSQLUpdate(sql);
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaSedeIndigo(String fecha, Long idSede, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasMySQL cm = new ConsultasMySQL();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (filtro.booleanValue()) {
                sql = "SELECT \nl_dgl_solicitud_examenes.`consecutivoOrden` AS numeroOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%Y-%m-%d') fechaOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%H:%i:%s') horaOrden,\nIF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Cédula de ciudadanía', 'CC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Registro civil','RC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Tarjeta de identidad','PE', 'NU'))) tipoIdentificacion,\n l_dgl_solicitud_examenes.`pacienteIdentificacion` numeroIdentificacion,\n l_dgl_solicitud_examenes.`pacientePrimerApellido` AS pacientePrimerApellido,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoApellido`,'') AS pacienteSegundoApellido,\n l_dgl_solicitud_examenes.`pacientePrimerNombre` AS pacientePrimerNombre,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoNombre`,'') AS pacienteSegundoNombre,\n l_dgl_solicitud_examenes.`pacienteSexo` pacienteSexo,\n '-' AS convenioNombre,\n DATE_FORMAT(l_dgl_solicitud_examenes.`pacienteFechaNacimiento`,'%Y-%m-%d') AS  fechaNacimieto, \n IFNULL(l_dgl_solicitud_examenes.`pacienteDireccion`,'') AS pacienteDireccion,\n IFNULL(l_dgl_solicitud_examenes.`pacienteTelofono`,'') AS pacienteTelefono,\n IFNULL(d.Id,0) AS idRecepcion,\n IF(d.Id IS NULL,0,1) AS estadoRecepcion,\n1 AS sede,\nl_dgl_solicitud_examenes.`areaServicioNombre` AS nombreSede,\nl_dgl_solicitud_examenes.`entroUrgencia` AS admision \nFROM l_dgl_solicitud_examenes\nLEFT JOIN (SELECT l_recepcion.Id, ingreso.NoAutorizacion FROM ingreso \n INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso=ingreso.Id)\n INNER JOIN l_recepcion ON(f_ordenes.Id=l_recepcion.Id_OrdenFacturac)\n WHERE ingreso.Estado=0\n GROUP BY ingreso.NoAutorizacion) d ON (d.NoAutorizacion = l_dgl_solicitud_examenes.`consecutivoOrden`)\nWHERE (areaServicioCodigo IN ('18','16') AND estado = 1 AND (l_dgl_solicitud_examenes.consecutivoOrden like '" + valorFiltro + "%' or CONCAT(l_dgl_solicitud_examenes.`pacientePrimerApellido`,' ', l_dgl_solicitud_examenes.`pacienteSegundoApellido`,' ',l_dgl_solicitud_examenes.`pacientePrimerNombre`,' ',l_dgl_solicitud_examenes.`pacienteSegundoNombre`) LIKE '%" + valorFiltro + "%' or l_dgl_solicitud_examenes.`pacienteIdentificacion` like '%" + valorFiltro + "%'))";
            } else {
                sql = "SELECT \nl_dgl_solicitud_examenes.`consecutivoOrden` AS numeroOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%Y-%m-%d') fechaOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%H:%i:%s') horaOrden,\nIF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Cédula de ciudadanía', 'CC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Registro civil','RC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Tarjeta de identidad','PE', 'NU'))) tipoIdentificacion,\n l_dgl_solicitud_examenes.`pacienteIdentificacion` numeroIdentificacion,\n l_dgl_solicitud_examenes.`pacientePrimerApellido` AS pacientePrimerApellido,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoApellido`,'') AS pacienteSegundoApellido,\n l_dgl_solicitud_examenes.`pacientePrimerNombre` AS pacientePrimerNombre,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoNombre`,'') AS pacienteSegundoNombre,\n l_dgl_solicitud_examenes.`pacienteSexo` pacienteSexo,\n '-' AS convenioNombre,\n DATE_FORMAT(l_dgl_solicitud_examenes.`pacienteFechaNacimiento`,'%Y-%m-%d') AS  fechaNacimieto, \n IFNULL(l_dgl_solicitud_examenes.`pacienteDireccion`,'') AS pacienteDireccion,\n IFNULL(l_dgl_solicitud_examenes.`pacienteTelofono`,'')  AS pacienteTelefono,\nIFNULL(d.Id,0) AS idRecepcion,\nIF(d.Id IS NULL,0,1) AS estadoRecepcion,\n1 AS sede,\nl_dgl_solicitud_examenes.`areaServicioNombre` AS nombreSede,\nl_dgl_solicitud_examenes.`entroUrgencia` AS admision \nFROM l_dgl_solicitud_examenes\nLEFT JOIN (SELECT l_recepcion.Id, ingreso.NoAutorizacion FROM ingreso \n INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso=ingreso.Id)\n INNER JOIN l_recepcion ON(f_ordenes.Id=l_recepcion.Id_OrdenFacturac)\n WHERE ingreso.Estado=0\n GROUP BY ingreso.NoAutorizacion) d ON (d.NoAutorizacion = l_dgl_solicitud_examenes.`consecutivoOrden`)\nWHERE (areaServicioCodigo IN ('18','16') AND estado = 1 AND IF(d.Id IS NULL,0,1) IN (" + estado + ") AND DATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%Y-%m-%d') = '" + fecha + "')";
            }
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("numeroOrden"));
                    e.setFechaOrden(rs2.getString("fechaOrden"));
                    e.setTipoDocumento(rs2.getString("tipoIdentificacion"));
                    e.setDocumento(rs2.getString("numeroIdentificacion"));
                    e.setApellido1(rs2.getString("pacientePrimerApellido"));
                    e.setApellido2(rs2.getString("pacienteSegundoApellido"));
                    e.setNombre1(rs2.getString("pacientePrimerNombre"));
                    e.setNombre2(rs2.getString("pacienteSegundoNombre"));
                    e.setIdSexo(rs2.getString("pacienteSexo"));
                    e.setNombreEmpresa(rs2.getString("convenioNombre"));
                    e.setFechaNacimiento(rs2.getString("fechaNacimieto"));
                    e.setDireccion(rs2.getString("pacienteDireccion"));
                    e.setMovil(rs2.getString("pacienteTelefono"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("idRecepcion")));
                    e.setHoraOrden(rs2.getString("horaOrden"));
                    e.setNombreSede(rs2.getString("nombreSede"));
                    e.setNumeroAdmision(rs2.getString("admision"));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaSedeIndigoServicios(String fecha, Long idSede, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasMySQL cm = new ConsultasMySQL();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (filtro.booleanValue()) {
                sql = "SELECT \nl_dgl_solicitud_examenes.`consecutivoOrden` AS numeroOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%Y-%m-%d') fechaOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%H:%i:%s') horaOrden,\nIF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Cédula de ciudadanía', 'CC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Registro civil','RC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Tarjeta de identidad','PE', 'NU'))) tipoIdentificacion,\n l_dgl_solicitud_examenes.`pacienteIdentificacion` numeroIdentificacion,\n l_dgl_solicitud_examenes.`pacientePrimerApellido` AS pacientePrimerApellido,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoApellido`,'') AS pacienteSegundoApellido,\n l_dgl_solicitud_examenes.`pacientePrimerNombre` AS pacientePrimerNombre,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoNombre`,'') AS pacienteSegundoNombre,\n l_dgl_solicitud_examenes.`pacienteSexo` pacienteSexo,\n '-' AS convenioNombre,\n DATE_FORMAT(l_dgl_solicitud_examenes.`pacienteFechaNacimiento`,'%Y-%m-%d') AS  fechaNacimieto, \n IFNULL(l_dgl_solicitud_examenes.`pacienteDireccion`,'') AS pacienteDireccion,\n IFNULL(l_dgl_solicitud_examenes.`pacienteTelofono`,'')  AS pacienteTelefono,\n IFNULL(d.Id,0) AS idRecepcion,\n IF(d.Id IS NULL,0,1) AS estadoRecepcion,\n1 AS sede,\nl_dgl_solicitud_examenes.`areaServicioNombre` AS nombreSede,\nl_dgl_solicitud_examenes.`entroUrgencia` AS admision \nFROM l_dgl_solicitud_examenes\nLEFT JOIN (SELECT l_recepcion.Id, ingreso.NoAutorizacion FROM ingreso \n INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso=ingreso.Id)\n INNER JOIN l_recepcion ON(f_ordenes.Id=l_recepcion.Id_OrdenFacturac)\n WHERE ingreso.Estado=0\n GROUP BY ingreso.NoAutorizacion) d ON (d.NoAutorizacion = l_dgl_solicitud_examenes.`consecutivoOrden`)\nWHERE (areaServicioCodigo NOT IN ('18','16') AND estado = 1 AND (l_dgl_solicitud_examenes.consecutivoOrden like '" + valorFiltro + "%' or CONCAT(l_dgl_solicitud_examenes.`pacientePrimerApellido`,' ', l_dgl_solicitud_examenes.`pacienteSegundoApellido`,' ',l_dgl_solicitud_examenes.`pacientePrimerNombre`,' ',l_dgl_solicitud_examenes.`pacienteSegundoNombre`) LIKE '%" + valorFiltro + "%' or l_dgl_solicitud_examenes.`pacienteIdentificacion` like '" + valorFiltro + "%'))";
            } else {
                sql = "SELECT \nl_dgl_solicitud_examenes.`consecutivoOrden` AS numeroOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%Y-%m-%d') fechaOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%H:%i:%s') horaOrden,\nIF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Cédula de ciudadanía', 'CC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Registro civil','RC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Tarjeta de identidad','PE', 'NU'))) tipoIdentificacion,\n l_dgl_solicitud_examenes.`pacienteIdentificacion` numeroIdentificacion,\n l_dgl_solicitud_examenes.`pacientePrimerApellido` AS pacientePrimerApellido,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoApellido`,'') AS pacienteSegundoApellido,\n l_dgl_solicitud_examenes.`pacientePrimerNombre` AS pacientePrimerNombre,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoNombre`,'') AS pacienteSegundoNombre,\n l_dgl_solicitud_examenes.`pacienteSexo` pacienteSexo,\n '-' AS convenioNombre,\n DATE_FORMAT(l_dgl_solicitud_examenes.`pacienteFechaNacimiento`,'%Y-%m-%d') AS  fechaNacimieto, \n IFNULL(l_dgl_solicitud_examenes.`pacienteDireccion`,'') AS pacienteDireccion,\n IFNULL(l_dgl_solicitud_examenes.`pacienteTelofono`,'')  AS pacienteTelefono,\n IFNULL(d.Id,0) AS idRecepcion,\n IF(d.Id IS NULL,0,1) AS estadoRecepcion,\n1 AS sede,\nl_dgl_solicitud_examenes.`areaServicioNombre` AS nombreSede,\nl_dgl_solicitud_examenes.`entroUrgencia` AS admision \nFROM l_dgl_solicitud_examenes\nLEFT JOIN (SELECT l_recepcion.Id, ingreso.NoAutorizacion FROM ingreso \n INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso=ingreso.Id)\n INNER JOIN l_recepcion ON(f_ordenes.Id=l_recepcion.Id_OrdenFacturac)\n WHERE ingreso.Estado=0\n GROUP BY ingreso.NoAutorizacion) d ON (d.NoAutorizacion = l_dgl_solicitud_examenes.`consecutivoOrden`)WHERE (areaServicioCodigo NOT IN ('18','16') AND estado = 1 AND IF(d.Id IS NULL,0,1) IN (" + estado + ") AND DATE_FORMAT(l_dgl_solicitud_examenes.`fecha`, '%Y-%m-%d') = '" + fecha + "')";
            }
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("numeroOrden"));
                    e.setFechaOrden(rs2.getString("fechaOrden"));
                    e.setTipoDocumento(rs2.getString("tipoIdentificacion"));
                    e.setDocumento(rs2.getString("numeroIdentificacion"));
                    e.setApellido1(rs2.getString("pacientePrimerApellido"));
                    e.setApellido2(rs2.getString("pacienteSegundoApellido"));
                    e.setNombre1(rs2.getString("pacientePrimerNombre"));
                    e.setNombre2(rs2.getString("pacienteSegundoNombre"));
                    e.setIdSexo(rs2.getString("pacienteSexo"));
                    e.setNombreEmpresa(rs2.getString("convenioNombre"));
                    e.setFechaNacimiento(rs2.getString("fechaNacimieto"));
                    e.setDireccion(rs2.getString("pacienteDireccion"));
                    e.setMovil(rs2.getString("pacienteTelefono"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("idRecepcion")));
                    e.setHoraOrden(rs2.getString("horaOrden"));
                    e.setNombreSede(rs2.getString("nombreSede"));
                    e.setNumeroAdmision(rs2.getString("admision"));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaSedeDinamicaGerencial(String fecha, Long idSede, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasMySQL cm = new ConsultasMySQL();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (filtro.booleanValue()) {
                sql = "SELECT \nl_dgl_solicitud_examenes.`consecutivoOrden` AS numeroOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%Y-%m-%d') fechaOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%H:%i:%s') horaOrden,\nIF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Cédula de ciudadanía', 'CC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Registro civil','RC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Tarjeta de identidad','PE', 'NU'))) tipoIdentificacion,\n l_dgl_solicitud_examenes.`pacienteIdentificacion` numeroIdentificacion,\n l_dgl_solicitud_examenes.`pacientePrimerApellido` AS pacientePrimerApellido,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoApellido`,'') AS pacienteSegundoApellido,\n l_dgl_solicitud_examenes.`pacientePrimerNombre` AS pacientePrimerNombre,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoNombre`,'') AS pacienteSegundoNombre,\n l_dgl_solicitud_examenes.`pacienteSexo` pacienteSexo,\n '-' AS convenioNombre,\n DATE_FORMAT(l_dgl_solicitud_examenes.`pacienteFechaNacimiento`,'%Y-%m-%d') AS  fechaNacimieto, \n IFNULL(l_dgl_solicitud_examenes.`pacienteDireccion`,'') AS pacienteDireccion,\n IFNULL(l_dgl_solicitud_examenes.`pacienteTelofono`,'') AS pacienteTelefono,\n IFNULL(d.Id,0) AS idRecepcion,\n IF(d.Id IS NULL,0,1) AS estadoRecepcion,\n1 AS sede,\nIF(l_dgl_solicitud_examenes.`entroUrgencia`=1, 'URGENCIA' , 'CONSULTA EXTERNA') AS nombreSede,\nl_dgl_solicitud_examenes.`entroUrgencia` AS admision \nFROM l_dgl_solicitud_examenes\nLEFT JOIN (SELECT l_recepcion.Id, ingreso.NoAutorizacion FROM ingreso \n INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso=ingreso.Id)\n INNER JOIN l_recepcion ON(f_ordenes.Id=l_recepcion.Id_OrdenFacturac)\n WHERE ingreso.Estado=0\n GROUP BY ingreso.NoAutorizacion) d ON (d.NoAutorizacion = l_dgl_solicitud_examenes.`consecutivoOrden`)\nWHERE (entroUrgencia = 0 AND (l_dgl_solicitud_examenes.consecutivoOrden like '" + valorFiltro + "%' or CONCAT(l_dgl_solicitud_examenes.`pacientePrimerApellido`,' ', l_dgl_solicitud_examenes.`pacienteSegundoApellido`,' ',l_dgl_solicitud_examenes.`pacientePrimerNombre`,' ',l_dgl_solicitud_examenes.`pacienteSegundoNombre`) LIKE '%" + valorFiltro + "%' or l_dgl_solicitud_examenes.`pacienteIdentificacion` like '%" + valorFiltro + "%'))";
            } else {
                sql = "SELECT \nl_dgl_solicitud_examenes.`consecutivoOrden` AS numeroOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%Y-%m-%d') fechaOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%H:%i:%s') horaOrden,\nIF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Cédula de ciudadanía', 'CC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Registro civil','RC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Tarjeta de identidad','PE', 'NU'))) tipoIdentificacion,\n l_dgl_solicitud_examenes.`pacienteIdentificacion` numeroIdentificacion,\n l_dgl_solicitud_examenes.`pacientePrimerApellido` AS pacientePrimerApellido,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoApellido`,'') AS pacienteSegundoApellido,\n l_dgl_solicitud_examenes.`pacientePrimerNombre` AS pacientePrimerNombre,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoNombre`,'') AS pacienteSegundoNombre,\n l_dgl_solicitud_examenes.`pacienteSexo` pacienteSexo,\n '-' AS convenioNombre,\n DATE_FORMAT(l_dgl_solicitud_examenes.`pacienteFechaNacimiento`,'%Y-%m-%d') AS  fechaNacimieto, \n IFNULL(l_dgl_solicitud_examenes.`pacienteDireccion`,'') AS pacienteDireccion,\n IFNULL(l_dgl_solicitud_examenes.`pacienteTelofono`,'')  AS pacienteTelefono,\nIFNULL(d.Id,0) AS idRecepcion,\nIF(d.Id IS NULL,0,1) AS estadoRecepcion,\n1 AS sede,\nIF(l_dgl_solicitud_examenes.`entroUrgencia`=1, 'URGENCIA' , 'CONSULTA EXTERNA') AS nombreSede,\nl_dgl_solicitud_examenes.`entroUrgencia` AS admision \nFROM l_dgl_solicitud_examenes\nLEFT JOIN (SELECT l_recepcion.Id, ingreso.NoAutorizacion FROM ingreso \n INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso=ingreso.Id)\n INNER JOIN l_recepcion ON(f_ordenes.Id=l_recepcion.Id_OrdenFacturac)\n WHERE ingreso.Estado=0\n GROUP BY ingreso.NoAutorizacion) d ON (d.NoAutorizacion = l_dgl_solicitud_examenes.`consecutivoOrden`)\nWHERE (entroUrgencia = 0 AND IF(d.Id IS NULL,0,1) IN (" + estado + ") AND DATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%Y-%m-%d') = '" + fecha + "')";
            }
            System.out.println(sql);
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("numeroOrden"));
                    e.setFechaOrden(rs2.getString("fechaOrden"));
                    e.setTipoDocumento(rs2.getString("tipoIdentificacion"));
                    e.setDocumento(rs2.getString("numeroIdentificacion"));
                    e.setApellido1(rs2.getString("pacientePrimerApellido"));
                    e.setApellido2(rs2.getString("pacienteSegundoApellido"));
                    e.setNombre1(rs2.getString("pacientePrimerNombre"));
                    e.setNombre2(rs2.getString("pacienteSegundoNombre"));
                    e.setIdSexo(rs2.getString("pacienteSexo"));
                    e.setNombreEmpresa(rs2.getString("convenioNombre"));
                    e.setFechaNacimiento(rs2.getString("fechaNacimieto"));
                    e.setDireccion(rs2.getString("pacienteDireccion"));
                    e.setMovil(rs2.getString("pacienteTelefono"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("idRecepcion")));
                    e.setHoraOrden(rs2.getString("horaOrden"));
                    e.setNombreSede(rs2.getString("nombreSede"));
                    e.setNumeroAdmision(rs2.getString("admision"));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaSedeDinamicaGerencialServicios(String fecha, Long idSede, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasMySQL cm = new ConsultasMySQL();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (filtro.booleanValue()) {
                sql = "SELECT \nl_dgl_solicitud_examenes.`consecutivoOrden` AS numeroOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%Y-%m-%d') fechaOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%H:%i:%s') horaOrden,\nIF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Cédula de ciudadanía', 'CC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Registro civil','RC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Tarjeta de identidad','PE', 'NU'))) tipoIdentificacion,\n l_dgl_solicitud_examenes.`pacienteIdentificacion` numeroIdentificacion,\n l_dgl_solicitud_examenes.`pacientePrimerApellido` AS pacientePrimerApellido,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoApellido`,'') AS pacienteSegundoApellido,\n l_dgl_solicitud_examenes.`pacientePrimerNombre` AS pacientePrimerNombre,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoNombre`,'') AS pacienteSegundoNombre,\n l_dgl_solicitud_examenes.`pacienteSexo` pacienteSexo,\n '-' AS convenioNombre,\n DATE_FORMAT(l_dgl_solicitud_examenes.`pacienteFechaNacimiento`,'%Y-%m-%d') AS  fechaNacimieto, \n IFNULL(l_dgl_solicitud_examenes.`pacienteDireccion`,'') AS pacienteDireccion,\n IFNULL(l_dgl_solicitud_examenes.`pacienteTelofono`,'')  AS pacienteTelefono,\n IFNULL(d.Id,0) AS idRecepcion,\n IF(d.Id IS NULL,0,1) AS estadoRecepcion,\n1 AS sede,\nIF(l_dgl_solicitud_examenes.`entroUrgencia`=1, 'URGENCIA' , 'CONSULTA EXTERNA') AS nombreSede,\nl_dgl_solicitud_examenes.`entroUrgencia` AS admision \nFROM l_dgl_solicitud_examenes\nLEFT JOIN (SELECT l_recepcion.Id, ingreso.NoAutorizacion FROM ingreso \n INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso=ingreso.Id)\n INNER JOIN l_recepcion ON(f_ordenes.Id=l_recepcion.Id_OrdenFacturac)\n WHERE ingreso.Estado=0\n GROUP BY ingreso.NoAutorizacion) d ON (d.NoAutorizacion = l_dgl_solicitud_examenes.`consecutivoOrden`)\nWHERE (entroUrgencia = 1 AND estado = 1 AND (l_dgl_solicitud_examenes.consecutivoOrden like '" + valorFiltro + "%' or CONCAT(l_dgl_solicitud_examenes.`pacientePrimerApellido`,' ', l_dgl_solicitud_examenes.`pacienteSegundoApellido`,' ',l_dgl_solicitud_examenes.`pacientePrimerNombre`,' ',l_dgl_solicitud_examenes.`pacienteSegundoNombre`) LIKE '%" + valorFiltro + "%' or l_dgl_solicitud_examenes.`pacienteIdentificacion` like '" + valorFiltro + "%'))";
            } else {
                sql = "SELECT \nl_dgl_solicitud_examenes.`consecutivoOrden` AS numeroOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%Y-%m-%d') fechaOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%H:%i:%s') horaOrden,\nIF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Cédula de ciudadanía', 'CC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Registro civil','RC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Tarjeta de identidad','PE', 'NU'))) tipoIdentificacion,\n l_dgl_solicitud_examenes.`pacienteIdentificacion` numeroIdentificacion,\n l_dgl_solicitud_examenes.`pacientePrimerApellido` AS pacientePrimerApellido,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoApellido`,'') AS pacienteSegundoApellido,\n l_dgl_solicitud_examenes.`pacientePrimerNombre` AS pacientePrimerNombre,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoNombre`,'') AS pacienteSegundoNombre,\n l_dgl_solicitud_examenes.`pacienteSexo` pacienteSexo,\n '-' AS convenioNombre,\n DATE_FORMAT(l_dgl_solicitud_examenes.`pacienteFechaNacimiento`,'%Y-%m-%d') AS  fechaNacimieto, \n IFNULL(l_dgl_solicitud_examenes.`pacienteDireccion`,'') AS pacienteDireccion,\n IFNULL(l_dgl_solicitud_examenes.`pacienteTelofono`,'')  AS pacienteTelefono,\n IFNULL(d.Id,0) AS idRecepcion,\n IF(d.Id IS NULL,0,1) AS estadoRecepcion,\n1 AS sede,\nIF(l_dgl_solicitud_examenes.`entroUrgencia`=1, 'URGENCIA' , 'CONSULTA EXTERNA') AS nombreSede,\nl_dgl_solicitud_examenes.`entroUrgencia` AS admision \nFROM l_dgl_solicitud_examenes\nLEFT JOIN (SELECT l_recepcion.Id, ingreso.NoAutorizacion FROM ingreso \n INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso=ingreso.Id)\n INNER JOIN l_recepcion ON(f_ordenes.Id=l_recepcion.Id_OrdenFacturac)\n WHERE ingreso.Estado=0\n GROUP BY ingreso.NoAutorizacion) d ON (d.NoAutorizacion = l_dgl_solicitud_examenes.`consecutivoOrden`)WHERE (entroUrgencia = 1 AND estado = 1 AND IF(d.Id IS NULL,0,1) IN (" + estado + ") AND DATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%Y-%m-%d') = '" + fecha + "')";
            }
            System.out.println(sql);
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("numeroOrden"));
                    e.setFechaOrden(rs2.getString("fechaOrden"));
                    e.setTipoDocumento(rs2.getString("tipoIdentificacion"));
                    e.setDocumento(rs2.getString("numeroIdentificacion"));
                    e.setApellido1(rs2.getString("pacientePrimerApellido"));
                    e.setApellido2(rs2.getString("pacienteSegundoApellido"));
                    e.setNombre1(rs2.getString("pacientePrimerNombre"));
                    e.setNombre2(rs2.getString("pacienteSegundoNombre"));
                    e.setIdSexo(rs2.getString("pacienteSexo"));
                    e.setNombreEmpresa(rs2.getString("convenioNombre"));
                    e.setFechaNacimiento(rs2.getString("fechaNacimieto"));
                    e.setDireccion(rs2.getString("pacienteDireccion"));
                    e.setMovil(rs2.getString("pacienteTelefono"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("idRecepcion")));
                    e.setHoraOrden(rs2.getString("horaOrden"));
                    e.setNombreSede(rs2.getString("nombreSede"));
                    e.setNumeroAdmision(rs2.getString("admision"));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public LaboratoriosDTO recepcionIdOrdenDinamica(String idOrdenDinamica) {
        ConsultasMySQL cm = new ConsultasMySQL();
        LaboratoriosDTO e = new LaboratoriosDTO();
        try {
            String sql = "SELECT \nl_dgl_solicitud_examenes.`consecutivoOrden` AS numeroOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%Y-%m-%d') fechaOrden,\nDATE_FORMAT(l_dgl_solicitud_examenes.`fechaCreacionOrden`, '%H:%i:%s') horaOrden,\nIF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Cédula de ciudadanía', 'CC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Registro civil','RC'\n, IF(l_dgl_solicitud_examenes.`pacienteTipoDocumento`='Tarjeta de identidad','PE', 'NU'))) tipoIdentificacion,\n l_dgl_solicitud_examenes.`pacienteIdentificacion` numeroIdentificacion,\n l_dgl_solicitud_examenes.`pacientePrimerApellido` AS pacientePrimerApellido,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoApellido`,'') AS pacienteSegundoApellido,\n l_dgl_solicitud_examenes.`pacientePrimerNombre` AS pacientePrimerNombre,\n IFNULL(l_dgl_solicitud_examenes.`pacienteSegundoNombre`,'') AS pacienteSegundoNombre,\n l_dgl_solicitud_examenes.`pacienteSexo` pacienteSexo,\n '-' AS convenioNombre,\n DATE_FORMAT(l_dgl_solicitud_examenes.`pacienteFechaNacimiento`,'%Y-%m-%d') AS  fechaNacimieto, \n IFNULL(l_dgl_solicitud_examenes.`pacienteDireccion`,'') AS pacienteDireccion,\n IFNULL(l_dgl_solicitud_examenes.`pacienteTelofono`,'')  AS pacienteTelefono,\n0 AS idRecepcion,\n0 AS estadoRecepcion,\n1 AS sede,\n-- if(ADNINGRESO.AINURGCON=0, 'URGENCIAS' ,iif(ADNINGRESO.AINURGCON=1,'CONSULTA EXTERNA', 'HOSPITALIZACION')) AS nombreSede\nIF(l_dgl_solicitud_examenes.`entroUrgencia`=1, 'URGENCIA' , 'CONSULTA EXTERNA') AS nombreSede,\nl_dgl_solicitud_examenes.`entroUrgencia` AS admision \nFROM l_dgl_solicitud_examenes\nWHERE (l_dgl_solicitud_examenes.`consecutivoOrden` = '" + idOrdenDinamica + "')";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    e.setNumeroOrden(rs2.getString("numeroOrden"));
                    e.setFechaOrden(rs2.getString("fechaOrden"));
                    e.setTipoDocumento(rs2.getString("tipoIdentificacion"));
                    e.setDocumento(rs2.getString("numeroIdentificacion"));
                    e.setApellido1(rs2.getString("pacientePrimerApellido"));
                    e.setApellido2(rs2.getString("pacienteSegundoApellido"));
                    e.setNombre1(rs2.getString("pacientePrimerNombre"));
                    e.setNombre2(rs2.getString("pacienteSegundoNombre"));
                    e.setIdSexo(rs2.getString("pacienteSexo"));
                    e.setNombreEmpresa(rs2.getString("convenioNombre"));
                    e.setFechaNacimiento(rs2.getString("fechaNacimieto"));
                    e.setDireccion(rs2.getString("pacienteDireccion"));
                    e.setMovil(rs2.getString("pacienteTelefono"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("idRecepcion")));
                    e.setHoraOrden(rs2.getString("horaOrden"));
                    e.setNombreSede(rs2.getString("nombreSede"));
                    e.setNumeroAdmision(rs2.getString("admision"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public Long consultarIdRecepcionPorIdOrdenDinamica(String idRecepcionDinamica, String fecha) {
        ConsultasMySQL cm = new ConsultasMySQL();
        Long idRecepcion = new Long(0L);
        try {
            String sql = "select l_recepcion.Id from ingreso \n inner join f_ordenes on (f_ordenes.Id_Ingreso=ingreso.Id)\n inner join l_recepcion on(f_ordenes.Id=l_recepcion.Id_OrdenFacturac)\n where ingreso.NoAutorizacion='" + idRecepcionDinamica + "' and ingreso.Estado=0 AND ingreso.`FechaIngreso`='" + fecha + "'\n group by ingreso.NoAutorizacion";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.first();
                idRecepcion = Long.valueOf(rs2.getLong("Id"));
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return idRecepcion;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public Object[] consultarParametrosParaInsertarOrdenDinamicaGerencial(String idRecepcionDinamica, String codigoCups, String idProtocoloDinamica) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        Object[] datos = null;
        try {
            String sql = "SELECT  LBNORDDET.OID idDetalleOrden, LBNPAREXA.OID as idProtocolo, LBNBASCOM.BCNOMBRE as nombreProtocolo, ISNULL(LBNREFVAL.OID,NULL) as valorRef\n,  GENSERIPS.SIPCODCUP\nfrom    LBNORDCAB        \nINNER JOIN  LBNORDDET ON LBNORDDET.LBNORDCAB = LBNORDCAB.OID\nINNER JOIN  LBNEXAMEN ON LBNORDDET.LBNEXAMEN = LBNEXAMEN.OID  \nINNER JOIN  GENSERIPS ON LBNEXAMEN.GENSERIPS = GENSERIPS.OID \nINNER JOIN  LBNPAREXA ON LBNPAREXA.EXACODIGO = LBNEXAMEN.OID\ninner join LBNBASCOM on (LBNBASCOM.OID=LBNPAREXA.PARCOMPON)\nleft join LBNREFVAL on (LBNREFVAL.PARCODIGO=LBNBASCOM.OID)\nwhere LBNORDCAB.ORDCONSEC='" + idRecepcionDinamica + "' and GENSERIPS.SIPCODCUP='" + codigoCups + "' and LBNBASCOM.OID='" + idProtocoloDinamica + "'";
            ResultSet rs2 = cm.traerRs(sql);
            System.out.println("Busqueda : " + sql);
            if (rs2.next()) {
                rs2.last();
                datos = new Object[3];
                rs2.beforeFirst();
                while (rs2.next()) {
                    datos[0] = rs2.getString("idDetalleOrden");
                    datos[1] = rs2.getString("valorRef");
                    datos[2] = rs2.getString("idProtocolo");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return datos;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public String insertarEncabezadoResultadoDinamica(String idDetalleOrden, Date fechaValidado, String idUsuarioValidado) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sql = "insert into LBNRESULT(LBORDDETN, RESFDIAPA, USUVALIDA, OptimisticLockField, ObjectType ) values(" + idDetalleOrden + ",GETDATE()," + idUsuarioValidado + ", 2, 677)";
        System.out.println("encabezado : " + sql);
        String idEncabezado = cm.ejecutarSQLId(sql);
        System.out.println("IdEncabezado : " + idEncabezado);
        cm.cerrarConexionBd();
        return idEncabezado;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void insertarDetalleResultadoDinamica(String idEncabezado, String idProtocolo, String resultado, String idRefencia) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sql = "insert into LBNDATPAR(OID, RLCOMBAS, RLRESULT, LBNREFVAL)  values(" + idEncabezado + ",'" + idProtocolo + "','" + resultado + "'," + idRefencia + ")";
        System.out.println("detalle :  " + sql);
        cm.ejecutarSQL(sql);
        cm.cerrarConexionBd();
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<DGLEnvioResultadosDTO> enviarDetalleResultadoDinamica(Long idProcedimiento, Long idRecepcion) {
        ConsultasMySQL cm = new ConsultasMySQL();
        List<DGLEnvioResultadosDTO> envios = new ArrayList<>();
        try {
            String sql = "SELECT\n\tldsed.id AS detalleId,\n\t0 AS estado,    \n\t0 AS factura,\n\tldse.consecutivoOrden,\n\tDATE_FORMAT(lr2.Fecha, '%Y-%m-%d') AS fechaValidacion,\n\tDATE_FORMAT(lr2.Fecha, '%H-%m-%s') AS horaValidacion,\n\tgp3.NoDocumento AS codigoProfesional,\n\tldse.pacienteIdentificacion AS pacienteCodigo,\n\tldsed.codigoExamen AS examenCodigo,\n\tlp.IdInfinity AS analitoCodigo,\n\tlp2.Nbre AS analitoNombre,\n\tif(ld2.codigoExterno <> '',\tld2.codigoExterno,ld2.VrNumerico) as resultado,\n\tld2.Unidad AS unidadMedida,\n\tld2.VReferencia1 AS minimo,\n\tld2.VReferencia2 AS maximo,\n\tldsed.detalleOrdenOid AS examenIdentificacion,\n\t99 as maquinaProcesaCodigo,\n\tld2.Observacion AS observacion,\n\tldse.pacienteTipoDocumentoGenoma AS pacienteTipoDocumento,\n\t0 AS camaCodigo,\n\tldsed.tipoIngreso AS tipoIngreso,\n\tldse.entroUrgencia AS entroPorUrgencias,\n\tldse.procedenciaCodigo AS entidadCodigo,\n\tldse.procedenciaNombre AS entidadNombre\nFROM\n\tl_dgl_solicitud_examenes_detalle ldsed\nINNER JOIN l_dgl_solicitud_examenes ldse ON\n\tldsed.ordenId = ldse.consecutivoOrden\nINNER JOIN g_procedimientoxcnt gp ON\n\tldsed.codigoExamen = gp.codigocnt\nINNER JOIN ingreso i ON\n\tldse.consecutivoOrden = i.NoAutorizacion\nINNER JOIN f_ordenes fo ON\n\ti.Id = fo.Id_Ingreso\nINNER JOIN l_recepcion lr ON\n\tfo.Id = lr.Id_OrdenFacturac\nINNER JOIN l_detallerecepcion ld ON\n\tgp.idprocedimiento = ld.Id_Procedim\n\tAND lr.Id = ld.Id_Recepcion\nINNER JOIN l_resultados lr2 ON\n\tlr.Id = lr2.Id_Recepcion\nINNER JOIN l_detalleresultado ld2 ON\n\t ld.Id_Procedim = ld2.Id_Procedimiento\n\tAND lr2.Id = ld2.Id_Resultado\nINNER JOIN g_profesionalespecial gp2 ON \n\tld2.IdProfesionalV = gp2.Id_Profesional\n\tAND ld2.IdEspecialidadV = gp2.Id_Especialidad\nINNER JOIN g_persona gp3 ON\n\tgp2.Id_Profesional = gp3.Id\nINNER JOIN l_protocoloxprocedimiento lp ON\n\tld2.Id_ProtocolProcedim = lp.Id\nINNER JOIN l_protocolos lp2 ON\n\tlp.Id_Protocolo = lp2.Id\nWHERE\n\t(lp.Id_Procedim =" + idProcedimiento + "\n\t\tAND lr2.Id_Recepcion =" + idRecepcion + "\n\t\tAND lp.Estado = 0\n\t\tAND lp.IdInfinity <> ''\n\t\tAND ld2.Enviado = 0\n\t\tAND ld2.Estado = 1)\ngroup by\n\tlp.Id";
            ResultSet rs2 = cm.traerRs(sql);
            System.out.println("" + sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    DGLEnvioResultadosDTO e = new DGLEnvioResultadosDTO();
                    e.setDetalleId(Long.valueOf(rs2.getLong("detalleId")));
                    e.setEstado(rs2.getString("estado"));
                    e.setFactura(rs2.getString("factura"));
                    e.setConsecutivoOrden(rs2.getString("consecutivoOrden"));
                    e.setFechaValidacion(rs2.getString("fechaValidacion"));
                    e.setHoraValidacion(rs2.getString("horaValidacion"));
                    e.setCodigoProfesional(rs2.getString("codigoProfesional"));
                    e.setPacienteCodigo(rs2.getString("pacienteCodigo"));
                    e.setExamenCodigo(rs2.getString("examenCodigo"));
                    e.setAnalitoCodigo(rs2.getString("analitoCodigo"));
                    e.setAnalitoNombre(rs2.getString("analitoNombre"));
                    e.setResultado(rs2.getString("resultado"));
                    e.setUnidadMedida(rs2.getString("unidadMedida"));
                    e.setMinimo(rs2.getString("minimo"));
                    e.setMaximo(rs2.getString("maximo"));
                    e.setExamenIdentificacion(rs2.getString("examenIdentificacion"));
                    e.setMaquinaProcesaCodigo(rs2.getString("maquinaProcesaCodigo"));
                    e.setObservacion(rs2.getString("observacion"));
                    e.setPacienteTipoDocumento(rs2.getString("pacienteTipoDocumento"));
                    e.setCamaCodigo(rs2.getString("camaCodigo"));
                    e.setTipoIngreso(rs2.getString("tipoIngreso"));
                    e.setEntroPorUrgencias(rs2.getString("entroPorUrgencias"));
                    e.setEntidadCodigo(rs2.getString("entidadCodigo"));
                    e.setEntidadNombre(rs2.getString("entidadNombre"));
                    envios.add(e);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return envios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void validacionResultadosDinamica(String idDetalleResultadoDinamica) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sql = "update LBNORDDET set LBNORDDET.FECVALIDA=GETDATE(), LBNORDDET.EXAESTADO=2, LBNORDDET.USUVALIDA=" + Principal.informacionGeneralPrincipalDTO.getIdUsuarioExterno() + ", LBNORDDET.LBNANALRES='-' where LBNORDDET.OID=" + idDetalleResultadoDinamica + "";
        System.out.println("validacion " + sql);
        cm.ejecutarSQL(sql);
        cm.cerrarConexionBd();
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void validacionResultadosDinamica(String consecutivoOrdenDinamica, String examenCodigoDinamica) {
        if (!Principal.informacionGeneralPrincipalDTO.getIdUsuarioExterno().isEmpty()) {
            ConsultasSqlServer cm = new ConsultasSqlServer();
            String sql = "UPDATE LBNORDDET \nSET LBNORDDET.USUVALIDA = " + Principal.informacionGeneralPrincipalDTO.getIdUsuarioExterno() + "\nFROM ( select l.OID from LBNORDDET l\ninner join LBNORDCAB l2 on (l.LBNORDCAB = l2.OID)\ninner join LBNEXAMEN l3 on (l.LBNEXAMEN = l3.OID)\nwhere l2.ORDCONSEC='" + consecutivoOrdenDinamica + "' and l3.EXACODIGO ='" + examenCodigoDinamica + "') subquery\nWHERE LBNORDDET.OID = subquery.OID";
            System.out.println("validacion " + sql);
            cm.ejecutarSQL(sql);
            String sql2 = "UPDATE LBNRESULT\nset LBNRESULT.USUVALIDA=" + Principal.informacionGeneralPrincipalDTO.getIdUsuarioExterno() + "\nFROM (\nselect l.OID as OIDResultado from LBNRESULT l  \ninner join LBNORDDET l5 on (l5.OID = l.LBORDDETN) \ninner join LBNORDCAB l2 on (l5.LBNORDCAB = l2.OID)\ninner join LBNEXAMEN l3 on (l5.LBNEXAMEN = l3.OID)\nwhere l2.ORDCONSEC='" + consecutivoOrdenDinamica + "' and l3.EXACODIGO ='" + examenCodigoDinamica + "') subquery\nWHERE LBNRESULT.OID =subquery.OIDResultado";
            System.out.println("validacion " + sql2);
            cm.ejecutarSQL(sql2);
            cm.cerrarConexionBd();
        }
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaSedeCNT(String fecha, Long idSede, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasSqlServer cm = new ConsultasSqlServer();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (filtro.booleanValue()) {
                sql = "SELECT       \nLBNORDCAB.ORDCONSEC AS numeroOrden, \n FORMAT(LBNORDCAB.ORDFECING,'yyyy-MM-dd') fechaOrden,\nFORMAT(LBNORDCAB.ORDFECING,'HH:mm:ss') horaOrden,\nIIF(GENPACIEN.PACTIPDOC=1, 'CC'\n, IIF(GENPACIEN.PACTIPDOC=2,'CE'\n, IIF(GENPACIEN.PACTIPDOC=3,'TI'\n, IIF(GENPACIEN.PACTIPDOC=4,'RC'\n, IIF(GENPACIEN.PACTIPDOC=5,'PA'\n, IIF(GENPACIEN.PACTIPDOC=6,'AS'\n, IIF(GENPACIEN.PACTIPDOC=7,'MS', 'NU'))))))) tipoIdentificacion,\n GENPACIEN.PACNUMDOC AS numeroIdentificacion,\n GENPACIEN.PACPRIAPE AS pacientePrimerApellido,\n GENPACIEN.PACSEGAPE AS pacienteSegundoApellido,\n GENPACIEN.PACPRINOM AS pacientePrimerNombre,\n GENPACIEN.PACSEGNOM AS pacienteSegundoNombre, \n IIF(GENPACIEN.GPASEXPAC=1, 'MASCULINO', IIF(GENPACIEN.GPASEXPAC=2,'FEMENINO', 'INDETERMINADO')) pacienteSexo , \n '-' AS convenioNombre, \n FORMAT(GENPACIEN.GPAFECNAC,'yyyy-MM-dd') AS  fechaNacimieto, \n GENPACIEND.PACDIRECCION AS pacienteDireccion, \nGENPACIENT.PACTELEFONO  AS pacienteTelefono,\n0 AS idRecepcion,\n0 AS estadoRecepcion,\n1 AS sede,\n iif(ADNINGRESO.AINURGCON=0, 'URGENCIAS' ,iif(ADNINGRESO.AINURGCON=1,'CONSULTA EXTERNA', 'HOSPITALIZACION')) AS nombreSede,\n LBNORDCAB.AINCONSEC AS admision \n-- ,iif(ADNINGRESO.AINURGCON=0, 'URGENCIAS' ,iif(ADNINGRESO.AINURGCON=1,'CONSULTA EXTERNA', 'HOSPITALIZACION')) tipoAtencion\n-- GENSERIPS.SIPCODIGO, \n-- GENSERIPS.SIPNOMBRE, \n-- GENSERIPS.SIPCODCUP\nFROM            LBNORDDET INNER JOIN\n                         LBNEXAMEN ON LBNORDDET.LBNEXAMEN = LBNEXAMEN.OID INNER JOIN\n                         LBNORDCAB ON LBNORDDET.LBNORDCAB = LBNORDCAB.OID INNER JOIN\n                         GENSERIPS ON LBNEXAMEN.GENSERIPS = GENSERIPS.OID INNER JOIN\n                         GENPACIEN ON LBNORDCAB.GPACODIGO = GENPACIEN.OID LEFT OUTER JOIN\n                         GENPACIENT ON GENPACIEN.OID = GENPACIENT.GENPACIEN LEFT OUTER JOIN\n                         GENPACIEND ON GENPACIEN.OID = GENPACIEND.GENPACIEN\n                         inner  join ADNINGRESO on (ADNINGRESO.OID=LBNORDCAB.AINCONSEC)\n                        \nWHERE        ((LBNORDCAB.ORDCONSEC like '" + valorFiltro + "%' or CONCAT(GENPACIEN.PACPRIAPE,' ',GENPACIEN.PACSEGAPE,' ',GENPACIEN.PACPRINOM,' ',GENPACIEN.PACSEGNOM) LIKE '%" + valorFiltro + "%' or GENPACIEN.PACNUMDOC like '" + valorFiltro + "%') and LBNORDCAB.ORDESTADO<>3)\nGROUP BY LBNORDCAB.ORDCONSEC, LBNORDCAB.ORDFECING, GENPACIEN.PACTIPDOC, GENPACIEN.PACNUMDOC,\nGENPACIEN.PACPRIAPE, GENPACIEN.PACSEGAPE, GENPACIEN.PACPRINOM, GENPACIEN.PACSEGNOM, GENPACIEN.GPASEXPAC,\nGENPACIEN.GPAFECNAC, GENPACIEND.PACDIRECCION, GENPACIENT.PACTELEFONO, LBNORDCAB.AINCONSEC,   ADNINGRESO.AINTIPING, ADNINGRESO.AINURGCON";
            } else {
                sql = "SELECT       \nLBNORDCAB.ORDCONSEC AS numeroOrden, \n FORMAT(LBNORDCAB.ORDFECING,'yyyy-MM-dd') fechaOrden,\nFORMAT(LBNORDCAB.ORDFECING,'HH:mm:ss') horaOrden,\nIIF(GENPACIEN.PACTIPDOC=1, 'CC'\n, IIF(GENPACIEN.PACTIPDOC=2,'CE'\n, IIF(GENPACIEN.PACTIPDOC=3,'TI'\n, IIF(GENPACIEN.PACTIPDOC=4,'RC'\n, IIF(GENPACIEN.PACTIPDOC=5,'PA'\n, IIF(GENPACIEN.PACTIPDOC=6,'AS'\n, IIF(GENPACIEN.PACTIPDOC=7,'MS', 'NU'))))))) tipoIdentificacion,\n GENPACIEN.PACNUMDOC AS numeroIdentificacion,\n GENPACIEN.PACPRIAPE AS pacientePrimerApellido,\n GENPACIEN.PACSEGAPE AS pacienteSegundoApellido,\n GENPACIEN.PACPRINOM AS pacientePrimerNombre,\n GENPACIEN.PACSEGNOM AS pacienteSegundoNombre, \n IIF(GENPACIEN.GPASEXPAC=1, 'MASCULINO', IIF(GENPACIEN.GPASEXPAC=2,'FEMENINO', 'INDETERMINADO')) pacienteSexo , \n '-' AS convenioNombre, \n FORMAT(GENPACIEN.GPAFECNAC,'yyyy-MM-dd') AS  fechaNacimieto, \n GENPACIEND.PACDIRECCION AS pacienteDireccion, \nGENPACIENT.PACTELEFONO  AS pacienteTelefono,\n0 AS idRecepcion,\n0 AS estadoRecepcion,\n1 AS sede,\n iif(ADNINGRESO.AINURGCON=0, 'URGENCIAS' ,iif(ADNINGRESO.AINURGCON=1,'CONSULTA EXTERNA', 'HOSPITALIZACION')) AS nombreSede,\n LBNORDCAB.AINCONSEC AS admision \n-- ,iif(ADNINGRESO.AINURGCON=0, 'URGENCIAS' ,iif(ADNINGRESO.AINURGCON=1,'CONSULTA EXTERNA', 'HOSPITALIZACION')) tipoAtencion\n-- GENSERIPS.SIPCODIGO, \n-- GENSERIPS.SIPNOMBRE, \n-- GENSERIPS.SIPCODCUP\nFROM            LBNORDDET INNER JOIN\n                         LBNEXAMEN ON LBNORDDET.LBNEXAMEN = LBNEXAMEN.OID INNER JOIN\n                         LBNORDCAB ON LBNORDDET.LBNORDCAB = LBNORDCAB.OID INNER JOIN\n                         GENSERIPS ON LBNEXAMEN.GENSERIPS = GENSERIPS.OID INNER JOIN\n                         GENPACIEN ON LBNORDCAB.GPACODIGO = GENPACIEN.OID LEFT OUTER JOIN\n                         GENPACIENT ON GENPACIEN.OID = GENPACIENT.GENPACIEN LEFT OUTER JOIN\n                         GENPACIEND ON GENPACIEN.OID = GENPACIEND.GENPACIEN\n                         inner  join ADNINGRESO on (ADNINGRESO.OID=LBNORDCAB.AINCONSEC)\n                        \nWHERE        (FORMAT(LBNORDCAB.ORDFECING,'yyyy-MM-dd') = '" + fecha + "' and LBNORDCAB.ORDESTADO<>3)\nGROUP BY LBNORDCAB.ORDCONSEC, LBNORDCAB.ORDFECING, GENPACIEN.PACTIPDOC, GENPACIEN.PACNUMDOC,\nGENPACIEN.PACPRIAPE, GENPACIEN.PACSEGAPE, GENPACIEN.PACPRINOM, GENPACIEN.PACSEGNOM, GENPACIEN.GPASEXPAC,\nGENPACIEN.GPAFECNAC, GENPACIEND.PACDIRECCION, GENPACIENT.PACTELEFONO, LBNORDCAB.AINCONSEC,   ADNINGRESO.AINTIPING, ADNINGRESO.AINURGCON";
            }
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("ORDENADMIN"));
                    e.setFechaOrden(rs2.getString("FECHA"));
                    e.setTipoDocumento(rs2.getString("TIPODOC"));
                    e.setDocumento(rs2.getString("DOCUMENTO"));
                    e.setApellido1(rs2.getString("APELLIDO1"));
                    e.setApellido2(rs2.getString("APELLIDO2"));
                    e.setNombre1(rs2.getString("NOMBRE1"));
                    e.setNombre2(rs2.getString("NOMBRE2"));
                    e.setIdSexo(rs2.getString("SEXO"));
                    e.setNombreEmpresa(rs2.getString("convenioNombre"));
                    e.setFechaNacimiento(rs2.getString("FECHANAC"));
                    e.setDireccion(rs2.getString("DIRECCION"));
                    e.setMovil(rs2.getString("TELEFONO"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("idRecepcion")));
                    e.setHoraOrden(rs2.getString("horaOrden"));
                    e.setNombreSede(rs2.getString("nombreSede"));
                    e.setNumeroAdmision(rs2.getString("admision"));
                    e.setIdRecepcion(consultarIdRecepcionPorIdOrdenDinamica(rs2.getString("numeroOrden"), fecha));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public Long consultarOrdenGenoma(Long idRecepcion) {
        ConsultasMySQL cm = new ConsultasMySQL();
        Long idOrden = new Long(0L);
        try {
            String sql = "select Id_OrdenFacturac from l_recepcion where Id=" + idRecepcion;
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.first();
                idOrden = Long.valueOf(rs2.getLong("Id_OrdenFacturac"));
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return idOrden;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaSedeGIIS(String fecha, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasPostgresSql cm = new ConsultasPostgresSql();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (estado.equals("0")) {
                if (filtro.booleanValue()) {
                    sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'FACTURADO'AS estado,\n\tapellido,\n\t''as apellido2,\n\tnombre ,\n\t''as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char  \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\t(apellido like '" + valorFiltro + "%' or nombre like '" + valorFiltro + "%'  or  hc like '" + valorFiltro + "%' ) \n\tand to_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 ='010301'     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2 ";
                } else {
                    sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'FACTURADO'AS estado ,\n\tapellido,\n\t' 'as apellido2,\n\tnombre ,\n\t' 'as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\tto_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 IN('010301', '010601')     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2 ";
                }
            } else if (estado.equals("1")) {
                if (filtro.booleanValue()) {
                    sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'ATENDIDO'AS estado,\n\tapellido,\n\t''as apellido2,\n\tnombre ,\n\t''as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\t(apellido like '" + valorFiltro + "%' or nombre like '" + valorFiltro + "%'  or  hc like '" + valorFiltro + "%' )\n\tand to_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 =IN('010301', '010601')     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2  ";
                } else {
                    sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'ATENDIDO'AS estado ,\n\tapellido,\n\t' 'as apellido2,\n\tnombre ,\n\t' 'as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\tto_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 IN('010301', '010601')     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2 ";
                }
            } else if (filtro.booleanValue()) {
                sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'ANULADO'AS estado,\n\tapellido,\n\t''as apellido2,\n\tnombre ,\n\t''as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n(apellido like '" + valorFiltro + "%' or nombre like '" + valorFiltro + "%'  or  hc like '" + valorFiltro + "%' )\n\tand to_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 IN('010301', '010601')     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2  ";
            } else {
                sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'ANULADO'AS estado ,\n\tapellido,\n\t' 'as apellido2,\n\tnombre ,\n\t' 'as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\tto_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 IN('010301', '010601')     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char, orden2  ";
            }
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("orden14"));
                    e.setFechaOrden(rs2.getString("fecha_orden"));
                    e.setApellido1(rs2.getString("apellido"));
                    e.setApellido2(rs2.getString("apellido2"));
                    e.setNombre1(rs2.getString("nombre"));
                    e.setNombre2(rs2.getString("nombre2"));
                    e.setIdSexo(rs2.getString("sexo1"));
                    e.setNombreEmpresa(rs2.getString("orden2_char"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("orden14")));
                    e.setHoraOrden(rs2.getString("orden2"));
                    e.setNombreSede(rs2.getString("orden1_char"));
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                        e.setNumeroAdmision(rs2.getString("estado"));
                    } else {
                        e.setNumeroAdmision("estado");
                    }
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public LaboratoriosDTO recepcionIdOrdenGIIS(String idOrdenDinamica) {
        ConsultasPostgresSql cm = new ConsultasPostgresSql();
        LaboratoriosDTO e = new LaboratoriosDTO();
        try {
            String sql = "select\n    orden14,\n    to_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n    'CC'as tipodc,\n    hc,\n    apellido,\n    '' as apellido2,\n    nombre,\n    '' as nombre2,\n    sexo, \n\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1,\n    orden3_char,\n    fecha_nacimiento,\n    hc4,\n    hc5,\n    orden14 ,\n    to_char (fecha_hora_envio, 'HH12: MI: SS') as hora_Orden ,\n    orden5_char, '' as admision , orden2_char \nfrom\n   interface_datalab_solicitudes ids\nwhere\n    orden14 ='" + idOrdenDinamica + "'";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    e.setNumeroOrden(rs2.getString("orden14"));
                    e.setFechaOrden(rs2.getString("fecha_orden"));
                    e.setTipoDocumento(rs2.getString("tipodc"));
                    e.setDocumento(rs2.getString("hc"));
                    e.setApellido1(rs2.getString("apellido"));
                    e.setApellido2(rs2.getString("apellido2"));
                    e.setNombre1(rs2.getString("nombre"));
                    e.setNombre2(rs2.getString("nombre2"));
                    e.setIdSexo(rs2.getString("sexo1"));
                    e.setNombreEmpresa(rs2.getString("orden3_char"));
                    e.setFechaNacimiento(rs2.getString("fecha_nacimiento"));
                    e.setDireccion(rs2.getString("hc4"));
                    e.setMovil(rs2.getString("hc5"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("orden14")));
                    e.setHoraOrden(rs2.getString("hora_Orden"));
                    e.setNombreSede(rs2.getString("orden5_char"));
                    e.setNumeroAdmision(rs2.getString("admision"));
                    e.setTipoServicio(rs2.getString("orden2_char"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public LaboratoriosDTO recepcionIdOrdenCNT(String idOrdenDinamica) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        LaboratoriosDTO e = new LaboratoriosDTO();
        try {
            String sql = "SELECT        LABOBIOSYSTEM.FACTURA,SUBSTRING(LABOBIOSYSTEM.FECHA, 1, 8) AS FECHA1,LABOBIOSYSTEM.DOCUMENTO, LABOBIOSYSTEM.APELLIDO1, LABOBIOSYSTEM.APELLIDO2, LABOBIOSYSTEM.NOMBRE1, \nLABOBIOSYSTEM.NOMBRE2, LABOBIOSYSTEM.SEXO, FORMAT(LABOBIOSYSTEM.FECHANAC, 'yyyy-MM-dd') AS FECHANAC1, LABOBIOSYSTEM.EDAD, \nLABOBIOSYSTEM.DIRECCION, LABOBIOSYSTEM.TELEFONO, LABOBIOSYSTEM.FACTURA AS Expr1, \nSUBSTRING(LABOBIOSYSTEM.FECHA, 9, 16) AS HORA1, LABOBIOSYSTEM.TIPOAT, TIPO_DOCUMENTO.TX_NOMB_TDOC\nFROM LABOBIOSYSTEM INNER JOIN  TIPO_DOCUMENTO ON LABOBIOSYSTEM.TIPODOC = TIPO_DOCUMENTO.NU_CODIGO_TDOC\nWHERE (LABOBIOSYSTEM.FACTURA = '" + idOrdenDinamica + "')";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    e.setNumeroOrden(rs2.getString("FACTURA"));
                    e.setFechaOrden(rs2.getString("FECHA1"));
                    e.setDocumento(rs2.getString("DOCUMENTO"));
                    e.setApellido1(rs2.getString("APELLIDO1"));
                    e.setApellido2(rs2.getString("APELLIDO2"));
                    e.setNombre1(rs2.getString("NOMBRE1"));
                    e.setNombre2(rs2.getString("NOMBRE2"));
                    e.setIdSexo(rs2.getString("SEXO"));
                    e.setFechaNacimiento(rs2.getString("FECHANAC1"));
                    e.setEdad(rs2.getString("EDAD"));
                    e.setDireccion(rs2.getString("DIRECCION"));
                    e.setMovil(rs2.getString("TELEFONO"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("FACTURA")));
                    e.setHoraOrden(rs2.getString("HORA1"));
                    e.setTipoServicio(rs2.getString("TIPOAT"));
                    e.setTipoDocumento(rs2.getString("TX_NOMB_TDOC"));
                }
            }
            cm.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarDatosRecepcionGIIS(String numeroRecepcion, String estado) {
        ConsultasPostgresSql cm = new ConsultasPostgresSql();
        String sql = "UPDATE interface_datalab_solicitudes SET  hc10='" + estado + "' where interface_datalab_solicitudes.orden14='" + numeroRecepcion + "';";
        System.out.println("validacion " + sql);
        cm.ejecutarSQL(sql);
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarResultadoGIIS(String numeroOrdenId, String codigoExamen, String abreviatura, String resultado, String unidades, String normalMinima, String normalMaxima, String patologico, String bacteriologo, String bacteriologoNombre, String ordenServicio, String estadoGIIS, String idResultado, Long idProtocolo, String observacion, String toma) {
        ConsultasPostgresSql cm = new ConsultasPostgresSql();
        int valida = 0;
        while (valida == 0) {
            System.out.println("Maximo idSELECT  (COALESCE(max( indice_automatico),0)+ 1) as maximo \nFROM public.interface_datalab_resultados;");
            ResultSet rs = cm.traerRs("SELECT  (COALESCE(max( indice_automatico),0)+ 1) as maximo \nFROM public.interface_datalab_resultados;");
            try {
                if (rs.next()) {
                    rs.first();
                    this.maximoIdResultado = rs.getString("maximo");
                }
            } catch (SQLException ex) {
                Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            String sql1 = "select indice_automatico FROM public.interface_datalab_resultados group by indice_automatico having indice_automatico =" + this.maximoIdResultado;
            System.out.println("Consultando duplicado" + sql1);
            try {
                if (!cm.traerRs(sql1).next()) {
                    valida = 1;
                }
            } catch (SQLException ex2) {
                Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
        if (estadoGIIS.equals("0")) {
            String sql = "INSERT INTO public.interface_datalab_resultados\n(numero_orden_id, codigo_seccion,\nnombre_seccion, codigo_examen,\ncodigo_datalab, codigo_perfil,\nabreviatura, nombre_examen,\nresultado, unidades, normal_minima,normal_maxima, \npatologico, comentario,\nmuestra_microbiologia, microorganismo,\nantibiotico, resultado_antibiotico,\nbacteriologo, bacteriologo_nombre,\nfecha_resultado,indice_automatico , \norden_servicio, indice_automatico_solicitud,\nresultado_id, fecha_muestra, usuario_muestra)\nVALUES('" + numeroOrdenId + "', 0, '', '" + codigoExamen + "', 0, 0, '" + abreviatura + "', '', '" + resultado + "', '" + unidades + "', '" + normalMinima + "', '" + normalMaxima + "', '" + patologico + "', '" + observacion + "', '', '', '', '', '" + bacteriologo + "', '" + bacteriologoNombre + "', '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', '" + this.maximoIdResultado + "' , '" + ordenServicio + "', 0, 0, '" + toma + "', '" + bacteriologo + "');";
            System.out.println("INSERT GIIS : " + sql);
            cm.ejecutarSQL(sql);
            mActualizaEstadoEnviadoGIIS(idResultado, idProtocolo);
            return;
        }
        System.out.println("registro ya enviado GIIS");
    }

    private void mActualizaEstadoEnviadoGIIS(String idResultado, Long idProtocolo) {
        ConsultasMySQL cm = new ConsultasMySQL();
        String sql = "UPDATE `l_detalleresultado` SET   `EstadoGIIS` = '1'  WHERE `Id_Resultado` = '" + idResultado + "'   AND `Id_ProtocolProcedim` = '" + idProtocolo + "'";
        cm.ejecutarSQL(sql);
        System.err.println("xsql" + sql);
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaSedeGIISServicios(String fecha, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasPostgresSql cm = new ConsultasPostgresSql();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (estado.equals("0")) {
                if (filtro.booleanValue()) {
                    sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'FACTURADO'AS estado,\n\tapellido,\n\t''as apellido2,\n\tnombre ,\n\t''as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\t(apellido like '" + valorFiltro + "%' or nombre like '" + valorFiltro + "%'  or  hc like '" + valorFiltro + "%' )\n\tand to_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "' and orden2 in ('010101', '010405','010404', '010406', '010410', '010901', '010201', '010604', '010401' , '010402' , '010403' , '010501', '010702', '010603', '010607', '010602'  )     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2 ";
                } else {
                    sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'FACTURADO'AS estado ,\n\tapellido,\n\t' 'as apellido2,\n\tnombre ,\n\t' 'as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\tto_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 in ('010101', '010405','010404', '010406', '010410', '010901', '010201', '010604', '010401' , '010402' , '010403' , '010501', '010702', '010603', '010607', '010602'  )     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2 ";
                }
            } else if (estado.equals("1")) {
                if (filtro.booleanValue()) {
                    sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'ATENDIDO'AS estado,\n\tapellido,\n\t''as apellido2,\n\tnombre ,\n\t''as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\t(apellido like '" + valorFiltro + "%' or nombre like '" + valorFiltro + "%'  or  hc like '" + valorFiltro + "%' )\n\tand to_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 in ('010101', '010405','010404', '010406', '010410', '010901', '010201', '010604', '010401' , '010402' , '010403' , '010501', '010702', '010603', '010607', '010602'  )     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2 ";
                } else {
                    sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'ATENDIDO'AS estado ,\n\tapellido,\n\t' 'as apellido2,\n\tnombre ,\n\t' 'as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\tto_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 in ('010101', '010405','010404', '010406', '010410', '010901', '010201', '010604', '010401' , '010402' , '010403' , '010501', '010702', '010603', '010607', '010602'  )     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2 ";
                }
            } else if (filtro.booleanValue()) {
                sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'ANULADO'AS estado,\n\tapellido,\n\t''as apellido2,\n\tnombre ,\n\t''as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2 \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\t(apellido like '" + valorFiltro + "%' or nombre like '" + valorFiltro + "%'  or  hc like '" + valorFiltro + "%' ) \n\tand to_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 in ('010101', '010405','010404', '010406', '010410', '010901', '010201', '010604', '010401' , '010402' , '010403' , '010501', '010702', '010603', '010607', '010602'  )     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2 ";
            } else {
                sql = "select  \n\torden14 ,\n\tto_char( fecha_hora_envio, 'DD-MM-YYYY') as fecha_orden,\n\t'ANULADO'AS estado ,\n\tapellido,\n\t' 'as apellido2,\n\tnombre ,\n\t' 'as nombre2 ,\n\tsexo,\tcase when sexo = '1' then 'M'\n\t\telse 'F'end as sexo1, \n\torden2_char ,\n\torden14 ,\n\torden1_char ,\n\torden6_char , orden2  \nfrom\n\tpublic.interface_datalab_solicitudes\nwhere\n\tto_char( fecha_hora_envio, 'YYYY-MM-DD')= '" + fecha + "'and hc10='" + estado + "'and orden2 in ('010101', '010405','010404', '010406', '010410', '010901', '010201', '010604', '010401' , '010402' , '010403' , '010501', '010702', '010603', '010607', '010602'  )     GROUP BY         orden14, fecha_orden, apellido, apellido2, nombre, nombre2,\n         sexo, sexo1,orden2_char , orden1_char , orden6_char , orden2  ";
            }
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("orden14"));
                    e.setFechaOrden(rs2.getString("fecha_orden"));
                    e.setApellido1(rs2.getString("apellido"));
                    e.setApellido2(rs2.getString("apellido2"));
                    e.setNombre1(rs2.getString("nombre"));
                    e.setNombre2(rs2.getString("nombre2"));
                    e.setIdSexo(rs2.getString("sexo1"));
                    e.setNombreEmpresa(rs2.getString("orden2_char"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("orden14")));
                    e.setHoraOrden(rs2.getString("orden2"));
                    e.setNombreSede(rs2.getString("orden1_char"));
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                        e.setNumeroAdmision(rs2.getString("estado"));
                    } else {
                        e.setNumeroAdmision("estado");
                    }
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaCNT(String fecha, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasSqlServer cm = new ConsultasSqlServer();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (estado.equals("0")) {
                sql = "SELECT\n\tNUM_PETICION,\n\tSUBSTRING(FECHA, 1, 10) as FECHA1,\n\tSUBSTRING(FECHA, 11, 16) AS HORA1,\n\tAPELLIDO1,  APELLIDO2 , NOMBRE1, NOMBRE2,\n\tSEXO,\n\tUPPER(TIPOAT) AS TIPOAT ,\n\tFACTURA \nFROM\n\tLABOBIOSYSTEM\nWHERE ESTADO='" + estado + "' AND ( CONCAT(APELLIDO1, ' ', APELLIDO2 , ' ', NOMBRE1, ' ', NOMBRE2 ) LIKE  '%" + valorFiltro + "%' OR  DOCUMENTO LIKE  '%" + valorFiltro + "%' ) AND TIPOAT IN('Ambulatorio')\n  AND SUBSTRING(FECHA, 1, 10)='" + fecha + "' \nGROUP BY\n\tNUM_PETICION ,\n\tFECHA ,\n\tAPELLIDO1,\n\tAPELLIDO2,\n\tNOMBRE1 ,\n\tNOMBRE2 ,\n\tSEXO ,\n\tTIPOAT,\n\tFACTURA";
            } else {
                sql = "SELECT\n\tNUM_PETICION,\n\tSUBSTRING(FECHA, 1, 8) as FECHA1,\n\tSUBSTRING(FECHA, 9, 16) AS HORA1,\n\tAPELLIDO1, APELLIDO2 ,  NOMBRE1,  NOMBRE2  ,\n\tSEXO,\n\tUPPER(TIPOAT) AS TIPOAT,\n\tFACTURA \nFROM\n\tLABOBIOSYSTEM\nWHERE ESTADO='" + estado + "' AND (CONCAT(APELLIDO1, ' ', APELLIDO2 , ' ', NOMBRE1, ' ', NOMBRE2 ) LIKE  '%" + valorFiltro + "%' OR  DOCUMENTO LIKE  '%" + valorFiltro + "%') AND TIPOAT IN('Ambulatorio')\n  AND SUBSTRING(FECHA, 1, 10)='" + fecha + "' \nGROUP BY\n\tNUM_PETICION ,\n\tFECHA ,\n\tAPELLIDO1,\n\tAPELLIDO2,\n\tNOMBRE1 ,\n\tNOMBRE2 ,\n\tSEXO ,\n\tTIPOAT,\n\tFACTURA";
            }
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("NUM_PETICION"));
                    e.setFechaOrden(rs2.getString("FECHA1"));
                    e.setHoraOrden(rs2.getString("HORA1"));
                    e.setApellido1(rs2.getString("APELLIDO1"));
                    e.setApellido2(rs2.getString("APELLIDO2"));
                    e.setNombre1(rs2.getString("NOMBRE1"));
                    e.setNombre2(rs2.getString("NOMBRE2"));
                    e.setIdSexo(rs2.getString("SEXO"));
                    e.setNombreEmpresa(rs2.getString("TIPOAT"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("FACTURA")));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
            cm.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaCNTServicios(String fecha, String estado, Boolean filtro, String valorFiltro) {
        String sql;
        ConsultasSqlServer cm = new ConsultasSqlServer();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            if (estado.equals("0")) {
                sql = "SELECT\n\tNUM_PETICION,\n\tSUBSTRING(FECHA, 1, 8) as FECHA1,\n\tSUBSTRING(FECHA, 9, 16) AS HORA1,\n\tAPELLIDO1,  APELLIDO2 , NOMBRE1, NOMBRE2,\n\tSEXO,\n\tUPPER(TIPOAT) AS TIPOAT ,\n\tFACTURA \nFROM\n\tLABOBIOSYSTEM\nWHERE ESTADO='" + estado + "' AND (CONCAT(APELLIDO1, ' ', APELLIDO2 , ' ', NOMBRE1, ' ', NOMBRE2 ) LIKE  '%" + valorFiltro + "%' OR  DOCUMENTO LIKE  '%" + valorFiltro + "%') AND TIPOAT IN('Urgencias' , 'Hospitalizacion')\n  AND SUBSTRING(FECHA, 1, 10)='" + fecha + "' \nGROUP BY\n\tNUM_PETICION ,\n\tFECHA ,\n\tAPELLIDO1,\n\tAPELLIDO2,\n\tNOMBRE1 ,\n\tNOMBRE2 ,\n\tSEXO ,\n\tTIPOAT,\n\tFACTURA";
            } else {
                sql = "SELECT\n\tNUM_PETICION,\n\tSUBSTRING(FECHA, 1, 8) as FECHA1,\n\tSUBSTRING(FECHA, 9, 16) AS HORA1,\n\tAPELLIDO1, APELLIDO2 ,  NOMBRE1,  NOMBRE2  ,\n\tSEXO,\n\tUPPER(TIPOAT) AS TIPOAT,\n\tFACTURA\nFROM\n\tLABOBIOSYSTEM\nWHERE ESTADO='" + estado + "' AND (CONCAT(APELLIDO1, ' ', APELLIDO2 , ' ', NOMBRE1, ' ', NOMBRE2 ) LIKE  '%" + valorFiltro + "%' OR  DOCUMENTO LIKE  '%" + valorFiltro + "%') TIPOAT IN('Urgencias' , 'Hospitalizacion')\n  AND SUBSTRING(FECHA, 1, 10)='" + fecha + "' \nGROUP BY\n\tNUM_PETICION ,\n\tFECHA ,\n\tAPELLIDO1,\n\tAPELLIDO2,\n\tNOMBRE1 ,\n\tNOMBRE2 ,\n\tSEXO ,\n\tTIPOAT,\n\tFACTURA";
            }
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("NUM_PETICION"));
                    e.setFechaOrden(rs2.getString("FECHA1"));
                    e.setHoraOrden(rs2.getString("HORA1"));
                    e.setApellido1(rs2.getString("APELLIDO1"));
                    e.setApellido2(rs2.getString("APELLIDO2"));
                    e.setNombre1(rs2.getString("NOMBRE1"));
                    e.setNombre2(rs2.getString("NOMBRE2"));
                    e.setIdSexo(rs2.getString("SEXO"));
                    e.setNombreEmpresa(rs2.getString("TIPOAT"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("FACTURA")));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
            cm.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaCNTBiomed(String fecha, String estado, Boolean filtro, String valorFiltro) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            String sql = "SELECT \nlr.FACTURA,\nSUBSTRING(lr.FECHA, 1, 10) AS FECHA1,\nSUBSTRING(lr.FECHA, 12, 16) AS HORA1,\nlr.APELLIDO1,  lr.APELLIDO2 , lr.NOMBRE1,lr.NOMBRE2,\nlr.SEXO ,\nUPPER(lr.TIPOAT) AS TIPOAT ,\nlr.NUM_PETICION, \ne.CD_NIT_EPS ,\ne.NO_NOMB_EPS , lr.TIPOAT  \nFROM \nLABOROCHE lr\nINNER JOIN EPS e ON  (lr.NIT=e.CD_NIT_EPS)\nWHERE ESTADO='" + estado + "' AND ( CONCAT(APELLIDO1, ' ', APELLIDO2 , ' ', NOMBRE1, ' ', NOMBRE2 ) LIKE  '%" + valorFiltro + "%' OR  DOCUMENTO LIKE  '%" + valorFiltro + "%' ) \nAND TIPOAT IN('Ambulatorio')  AND SUBSTRING(FECHA, 1, 10)='" + fecha + "'\nGROUP BY CD_NIT_EPS, NO_NOMB_EPS , NUM_PETICION\n, FECHA,APELLIDO1 , APELLIDO2 , NOMBRE1, NOMBRE2,SEXO , TIPOAT , FACTURA";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("FACTURA"));
                    e.setFechaOrden(rs2.getString("FECHA1"));
                    e.setHoraOrden(rs2.getString("HORA1"));
                    e.setApellido1(rs2.getString("APELLIDO1"));
                    e.setApellido2(rs2.getString("APELLIDO2"));
                    e.setNombre1(rs2.getString("NOMBRE1"));
                    e.setNombre2(rs2.getString("NOMBRE2"));
                    e.setIdSexo(rs2.getString("SEXO"));
                    e.setNombreEmpresa(rs2.getString("NO_NOMB_EPS"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("NUM_PETICION")));
                    e.setNombreSede(rs2.getString("TIPOAT"));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
            cm.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaCNTServiciosBiomed(String fecha, String estado, Boolean filtro, String valorFiltro) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            String sql = "SELECT \nlr.FACTURA,\nSUBSTRING(lr.FECHA, 1, 10) AS FECHA1,\nSUBSTRING(lr.FECHA, 12, 16) AS HORA1,\nlr.APELLIDO1,  lr.APELLIDO2 , lr.NOMBRE1,lr.NOMBRE2,\nlr.SEXO ,\nUPPER(lr.TIPOAT) AS TIPOAT ,\nlr.NUM_PETICION, \ne.CD_NIT_EPS ,\ne.NO_NOMB_EPS ,\nlr.TIPOAT \nFROM \nLABOROCHE lr\nINNER JOIN EPS e ON  (lr.NIT=e.CD_NIT_EPS)\nWHERE ESTADO='" + estado + "' AND ( CONCAT(APELLIDO1, ' ', APELLIDO2 , ' ', NOMBRE1, ' ', NOMBRE2 ) LIKE  '%" + valorFiltro + "%' OR  DOCUMENTO LIKE  '%" + valorFiltro + "%' ) \nAND TIPOAT IN('Urgencias', 'Hospitalizacion')  AND SUBSTRING(FECHA, 1, 10)='" + fecha + "'\nGROUP BY CD_NIT_EPS, NO_NOMB_EPS, NUM_PETICION\n, FECHA,APELLIDO1 , APELLIDO2 , NOMBRE1, NOMBRE2,SEXO , TIPOAT , FACTURA";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("FACTURA"));
                    e.setFechaOrden(rs2.getString("FECHA1"));
                    e.setHoraOrden(rs2.getString("HORA1"));
                    e.setApellido1(rs2.getString("APELLIDO1"));
                    e.setApellido2(rs2.getString("APELLIDO2"));
                    e.setNombre1(rs2.getString("NOMBRE1"));
                    e.setNombre2(rs2.getString("NOMBRE2"));
                    e.setIdSexo(rs2.getString("SEXO"));
                    e.setNombreEmpresa(rs2.getString("NO_NOMB_EPS"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("NUM_PETICION")));
                    e.setNombreSede(rs2.getString("TIPOAT"));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarDatosRecepcionCNT(String numeroOrdenCnt, String estado, String tabla) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sql = "UPDATE\n\t" + tabla + " \nSET\n\tESTADO = '1'\n\tWHERE FACTURA ='" + numeroOrdenCnt + "';";
        System.out.println("validacion " + sql);
        cm.ejecutarSQL(sql);
        cm.cerrarConexionBd();
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarResultadoCNT(String NumerodeOrden, String Ndocumento, String codigoExamen, String NombreAnalito, String codigoAnalito, String resultado, String normalMinima, String normalMaxima, String unidades, String observacion, String estadoCNT, String UsuarioSistema, String alterado, String idResultado, Long idProtocolo, String tabla) {
        System.err.println("estado" + estadoCNT);
        ConsultasSqlServer cm = new ConsultasSqlServer();
        if (estadoCNT.equals("0")) {
            String sql = "INSERT\n\tINTO\n\t" + tabla + " ( NU_NUMMOV_LABI, FE_RESULT_LABI,  TX_HISPAC_LABI, TX_CODSER_LABI, TX_NOMANA_LABI, TX_CODANA_LABI,  TX_VALRES_LABI, TX_REFMIN_LABI, TX_REFMAX_LABI, TX_UNIDAD_LABI,  TX_OBSERV_LABI, TX_USUARIO_LABI, NU_ESTADO_LABI)\nVALUES('" + NumerodeOrden + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', '" + Ndocumento + "','" + codigoExamen + "', '" + NombreAnalito + "', '" + codigoAnalito + "', '" + resultado + "','" + normalMinima + "','" + normalMaxima + "', '" + unidades + "', '" + observacion + "', '" + UsuarioSistema + "', '" + estadoCNT + "');";
            System.out.println("INSERT CNT : " + sql);
            cm.ejecutarSQL(sql);
            mActualizaEstadoEnviadoGIIS(idResultado, idProtocolo);
            return;
        }
        System.out.println("registro ya enviado CNT");
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public LaboratoriosDTO recepcionIdOrdenCNTBiomed(String idOrdenDinamica) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        LaboratoriosDTO e = new LaboratoriosDTO();
        try {
            String sql = " SELECT\n    FACTURA,\n    SUBSTRING(FECHA, 1, 10) as FECHA1,\n\tDOCUMENTO,\n    APELLIDO1,\n\tAPELLIDO2,\n\tNOMBRE1,\n\tNOMBRE2,\n\tSEXO,\n\tFORMAT (FECHANAC, 'yyyy-MM-dd') as FECHANAC1 ,\n\tEDAD,\n\tDIRECCION,\n\tTELEFONO,\n\tFACTURA,\n\tSUBSTRING(FECHA, 9, 16) AS HORA1,\n\tTIPOAT \n\tFROM\n\tLABOROCHE lr\n\tINNER JOIN EPS e ON  (lr.NIT=e.CD_NIT_EPS) \n\twhere FACTURA='" + idOrdenDinamica + "'";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    e.setNumeroOrden(rs2.getString("FACTURA"));
                    e.setFechaOrden(rs2.getString("FECHA1"));
                    e.setDocumento(rs2.getString("DOCUMENTO"));
                    e.setApellido1(rs2.getString("APELLIDO1"));
                    e.setApellido2(rs2.getString("APELLIDO2"));
                    e.setNombre1(rs2.getString("NOMBRE1"));
                    e.setNombre2(rs2.getString("NOMBRE2"));
                    e.setIdSexo(rs2.getString("SEXO"));
                    e.setFechaNacimiento(rs2.getString("FECHANAC1"));
                    e.setEdad(rs2.getString("EDAD"));
                    e.setDireccion(rs2.getString("DIRECCION"));
                    e.setMovil(rs2.getString("TELEFONO"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("FACTURA")));
                    e.setHoraOrden(rs2.getString("HORA1"));
                    e.setTipoServicio(rs2.getString("TIPOAT"));
                    e.setNombreConvenio(rs2.getString("CD_CODI_CONV"));
                    e.setNombreEmpresa(rs2.getString("NO_NOMB_EPS"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarResultadoCNTBiomed(String NumerodeOrden, String Ndocumento, String codigoExamen, String NombreAnalito, String codigoAnalito, String resultado, String normalMinima, String normalMaxima, String unidades, String observacion, String estadoCNT, String UsuarioSistema, String idResultado, String alterado, Long idProtocolo, String tabla) {
        System.err.println("estado" + estadoCNT);
        ConsultasSqlServer cm = new ConsultasSqlServer();
        if (estadoCNT.equals("0")) {
            String sql = "INSERT\n\tINTO\n\t" + tabla + " ( NU_NUMMOV_LARO, FE_RESULT_LARO,  TX_HISPAC_LARO, TX_CODSER_LARO, TX_NOMANA_LARO, TX_CODANA_LARO,  TX_VALRES_LARO, TX_REFMIN_LARO, TX_REFMAX_LARO, TX_UNIDAD_LARO,  TX_OBSERV_LARO, TX_USUARIO_LARO, NU_ESTADO_LARO)\nVALUES('" + NumerodeOrden + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', '" + Ndocumento + "','" + codigoExamen + "', '" + NombreAnalito + "', '" + codigoAnalito + "', '" + resultado + "','" + normalMinima + "','" + normalMaxima + "', '" + unidades + "', '" + observacion + "', '" + UsuarioSistema + "', '" + estadoCNT + "');";
            System.out.println("INSERT CNT : " + sql);
            cm.ejecutarSQL(sql);
            mActualizaEstadoEnviadoGIIS(idResultado, idProtocolo);
            return;
        }
        System.out.println("registro ya enviado CNT");
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaSedeBienEstarIps(String fecha, String estado, Boolean filtro, String valorFiltro, String NombrePaciente) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            String sql = "SELECT\n           FORMAT(HIST.HCli_Fecha,'yyyy-MM-dd') as fecha,\n           FORMAT(CAST(HIST.HCli_Fecha AS datetime2), N'HH:mm') as hora  ,\n           TIPOEXA.TExa_Nombre Tipo_de_Evaluacion,\n           PER.Per_NombreFull Nombre,\n           PERDOC.Doc_Numero,\n           HIST.HCli_ID,\n           isnull(EMPL.zLab_ID,'00000000-0000-0000-0000-000000000000') as zLab_ID ,\n           GEN.Gen_Descripcion,\n           HIST.HCli_HistoriaOk,\n\t\t   isnull (HIST.HCli_MotivoConsulta,' ') as motivoc,\n\t\t   Empresa.Empr_RazonSocial,\n\t\t   Empresa.Empr_ID,\n            GECONT.Con_CorreoElectronico\nFROM   Persona PER LEFT JOIN\n           Persona_Documento PERDOC ON PER.zDoc_ID = PERDOC.Doc_ID LEFT JOIN\n       Empresa_Empleado EMPL ON PER.Per_ID = EMPL.zPer_ID LEFT JOIN\n\t   Empresa on EMPL.zEmpr_ID = Empresa.Empr_ID LEFT join\n       Persona_Genero GEN ON GEN.Gen_ID = PER.zGen_ID  LEFT JOIN\n           Laboratorio LAB ON LAB.Lab_ID = EMPL.zLab_ID LEFT JOIN\n       HistoriaClinica HIST  ON HIST.HCli_ID = EMPL.zHCli_ID LEFT JOIN\n       HistoriaClinica_Paraclinicos HISTPARA ON HIST.HCli_ID = HISTPARA.zHCli_ID LEFT JOIN\n       HistoriaClinica_ExamenParaclinico HISTEXA ON HISTEXA.EPa_ID = HISTPARA.zEpa_ID LEFT JOIN\n       HistoriaClinica_TipoExamen TIPOEXA ON TIPOEXA.TExa_ID = HIST.zTExa_ID  LEFT JOIN\n       General_Contacto GECONT ON GECONT.Con_ID =PER.zCon_ID\t   \nWHERE FORMAT(HIST.HCli_Fecha ,'dd/MM/yyyy' ) >='" + fecha + "' and FORMAT(HIST.HCli_Fecha ,'dd/MM/yyyy' ) <='" + fecha + "'\n  and EMPL.EstadoGenoma='" + estado + "' and HIST.CambioEnParaclinicos = '1' and PER.Per_NombreFull like '%" + NombrePaciente + "%' \ngroup by   HIST.HCli_Fecha,\n           TIPOEXA.TExa_Nombre,\n           PER.Per_NombreFull,\n           PERDOC.Doc_Numero,\n           HIST.HCli_ID,\n           GEN.Gen_Descripcion,\n           EMPL.zLab_ID,\n           HIST.HCli_HistoriaOk,\n\t\t   HIST.HCli_MotivoConsulta ,\n\t\t    Empresa.Empr_RazonSocial,\n\t\t   Empresa.Empr_ID,\n\t\t   GECONT.Con_CorreoElectronico\norder by HIST.HCli_Fecha asc";
            ResultSet rs2 = cm.traerRs(sql);
            System.out.println("" + sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("HCli_ID"));
                    e.setFechaOrden(rs2.getString("fecha"));
                    e.setHoraOrden(rs2.getString("hora"));
                    e.setApellido1(rs2.getString("Nombre"));
                    e.setIdSexo(rs2.getString("Gen_Descripcion"));
                    e.setNombreEmpresa(rs2.getString("motivoc"));
                    e.setNumeroAdmision(rs2.getString("zLab_ID"));
                    e.setNombreExterno(rs2.getString("Empr_RazonSocial"));
                    e.setIdConvenioExterno(rs2.getString("Empr_ID"));
                    e.setDireccion(rs2.getString("Con_CorreoElectronico"));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public LaboratoriosDTO recepcionIdOrdenBs1(String idOrdenBs1) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        LaboratoriosDTO e = new LaboratoriosDTO();
        try {
            String sql = "SELECT  HIST.HCli_ID ID,\t\t   \n           FORMAT(HIST.HCli_Fecha,'yyyy-MM-dd') Fecha,\n\t\t   FORMAT(CAST(HIST.HCli_Fecha AS datetime2), N'HH:mm') Hora,\n\t\t   TICDOC.TDoc_Abreviatura TipoDocumento,\n\t\t   PERDOC.Doc_Numero NumeroDoc,\t\t   \t \n\t\t   PER.Per_Apellido1 Apellido1,\n\t\t   ISNULL(PER.Per_Apellido2, ' ') Apellido2,\n\t\t   PER.Per_Nombre1 Nombre1,\n\t\t   ISNULL(PER.Per_Nombre2, ' ')Nombre2,\n\t\t    GEN.Gen_Letra Genero,\n\t\t   FORMAT(PER.Per_FechaNacimiento,'yyyy-MM-dd') FechaNacimiento,\n\t\t   CONVERT(varchar(10),DATEDIFF(year,PER.Per_FechaNacimiento,GETDATE())) Edad,\n\t\t   GUBIC.Ubc_Direccion +' '+ GUBIC.Ubc_Barrio +' '+ GMUN.Mun_Nombre Direccion,\n\t\t   TEL.Tel_Numero,\t          \n           EMPL.zLab_ID IDLAB,           \n           HIST.HCli_HistoriaOk HistCerrada,\n\t\t   TOMA.Toma_Realizado\t   \nFROM\t   Persona PER FULL JOIN\n\t\t   Persona_Documento PERDOC ON PER.zDoc_ID = PERDOC.Doc_ID FULL JOIN\n\t\t   Persona_TipoDocumento TICDOC ON PERDOC.zTDoc_ID = TICDOC.TDoc_ID FULL JOIN\n\t\t   Empresa_Empleado EMPL ON PER.Per_ID = EMPL.zPer_ID FULL JOIN\t  \n\t\t   General_Contacto GENCON ON PER.zCon_ID = GENCON.Con_ID INNER JOIN\t \n\t\t   General_Ubicacion GUBIC ON GUBIC.zCon_ID = GENCON.Con_ID INNER JOIN\t \n\t\t   General_Municipio GMUN ON GMUN.Mun_ID = GUBIC.zMun_ID INNER JOIN\n\t\t   General_Telefono TEL ON TEL.zCon_ID = GENCON.Con_ID FULL JOIN  \n\t\t   Persona_Genero GEN ON GEN.Gen_ID = PER.zGen_ID  FULL JOIN\n\t\t   Laboratorio LAB ON LAB.Lab_ID = EMPL.zLab_ID FULL JOIN\n\t\t   HistoriaClinica HIST  ON HIST.HCli_ID = EMPL.zHCli_ID FULL JOIN\n\t\t   HistoriaClinica_Paraclinicos HISTPARA ON HIST.HCli_ID = HISTPARA.zHCli_ID FULL JOIN\n\t\t   HistoriaClinica_ExamenParaclinico HISTEXA ON HISTEXA.EPa_ID = HISTPARA.zEpa_ID FULL JOIN\n\t\t   HistoriaClinica_TipoExamen TIPOEXA ON TIPOEXA.TExa_ID = HIST.zTExa_ID FULL JOIN\n\t\t   Laboratorio_TomaMuestra TOMA ON HIST.HCli_ID = TOMA.zHcli_ID\n\nWHERE       HIST.HCli_ID ='" + idOrdenBs1 + "'\nGROUP BY\n           HIST.HCli_ID, HIST.HCli_Fecha, TICDOC.TDoc_Abreviatura, PERDOC.Doc_Numero,\t\t   \t \n\t\t   PER.Per_Apellido1, PER.Per_Apellido2, PER.Per_Nombre1, PER.Per_Nombre2,\n\t\t    GEN.Gen_Letra, PER.Per_FechaNacimiento, GUBIC.Ubc_Direccion,\n\t\t   GUBIC.Ubc_Barrio, GMUN.Mun_Nombre, TEL.Tel_Numero, EMPL.zLab_ID,           \n           HIST.HCli_HistoriaOk, TOMA.Toma_Realizado";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    e.setNumeroOrden(rs2.getString("ID"));
                    e.setFechaOrden(rs2.getString("fecha"));
                    e.setDocumento(rs2.getString("NumeroDoc"));
                    String tipoDocumento = rs2.getString("TipoDocumento");
                    if (tipoDocumento.equals("C.C.")) {
                        e.setTipoDocumento("CC");
                    } else if (tipoDocumento.equals("TI")) {
                        e.setTipoDocumento("TI");
                    } else if (tipoDocumento.equals("R.C.")) {
                        e.setTipoDocumento("RC");
                    } else if (tipoDocumento.equals("NUIP.")) {
                        e.setTipoDocumento("NU");
                    } else if (tipoDocumento.equals("C.E")) {
                        e.setTipoDocumento("CE");
                    } else if (tipoDocumento.equals("NIT.")) {
                        e.setTipoDocumento("NI");
                    } else if (tipoDocumento.equals("D.E.")) {
                        e.setTipoDocumento("DE");
                    } else if (tipoDocumento.equals("C.M.")) {
                        e.setTipoDocumento("CM");
                    } else if (tipoDocumento.equals("P.A.")) {
                        e.setTipoDocumento("PA");
                    } else if (tipoDocumento.equals("C.D.")) {
                        e.setTipoDocumento("CD");
                    } else if (tipoDocumento.equals("P.E.P")) {
                        e.setTipoDocumento("PE");
                    } else {
                        e.setTipoDocumento("CC");
                    }
                    e.setApellido1(rs2.getString("Apellido1"));
                    e.setApellido2(rs2.getString("Apellido2"));
                    e.setNombre1(rs2.getString("Nombre1"));
                    e.setNombre2(rs2.getString("Nombre2"));
                    e.setIdSexo(rs2.getString("Genero"));
                    e.setFechaNacimiento(rs2.getString("FechaNacimiento"));
                    e.setEdad(rs2.getString("Edad"));
                    e.setMovil(rs2.getString("Tel_Numero"));
                    e.setDireccion(rs2.getString("Direccion"));
                    e.setIdRecepcion2(rs2.getString("IDLAB"));
                    e.setHoraOrden(rs2.getString("hora"));
                }
            }
            cm.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public List<LaboratoriosDTO> listadoAgendaFechaColgenes(String fecha, String estado, Boolean filtro, String valorFiltro) {
        ConsultasMySQL cm = new ConsultasMySQL();
        List<LaboratoriosDTO> listaLaboratorios = new ArrayList<>();
        try {
            String sql = "SELECT\n    `factura`\n    , `fecha`, identificacion \n    , `hora`\n    ,CONCAT( `nombre1`,' ',nombre2 ,' ', `apellido1` ,' ', `apellido2`) AS nombres \n    , `sexo`\n    , `convenio`\nFROM `il_interfaz`\n    WHERE ( il_interfaz.`fecha`='" + fecha + "' AND CONCAT( `nombre1`,' ',nombre2 ,' ', `apellido1` ,' ', `apellido2`) LIKE'%" + valorFiltro + "%' and  estadoRecepcion = '" + estado + "')\nGROUP BY `factura`, `identificacion`;";
            ResultSet rs2 = cm.traerRs(sql);
            System.out.println("" + sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    LaboratoriosDTO e = new LaboratoriosDTO();
                    e.setNumeroOrden(rs2.getString("factura"));
                    e.setFechaOrden(rs2.getString("fecha"));
                    e.setHoraOrden(rs2.getString("hora"));
                    e.setApellido1(rs2.getString("nombres"));
                    e.setNumeroAdmision(rs2.getString("identificacion"));
                    e.setIdSexo(rs2.getString("sexo"));
                    e.setNombreEmpresa(rs2.getString("convenio"));
                    listaLaboratorios.add(e);
                }
            }
            rs2.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return listaLaboratorios;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarDatosRecepcionBS1(String numeroRecepcion, String estado, String idProcedimiento) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sql = "UPDATE Laboratorio_TomaMuestra\n   SET Toma_ValGenoma = 1\n WHERE Laboratorio_TomaMuestra.zHcli_ID='" + numeroRecepcion + "' and Toma_ValGenoma='0' and Toma_Realizado=1 \n  and Laboratorio_TomaMuestra.zEpa_ID='" + idProcedimiento + "' \n";
        System.out.println("validacion " + sql);
        cm.ejecutarSQL(sql);
        cm.cerrarConexionBd();
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarResultadoBs1(String codigoIdResultadoBs1, String valorRseultado, String idValoresReferencia, String isResultado, Long idProtocolo) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sql = "INSERT INTO [dbo].[Laboratorio_ResultadoObtenido]\n           ([LRob_ID]\n           ,[LRob_Valor]\n           ,[zLRes_ID]\n           ,[zLEpra_ID])\n     VALUES\n           ('" + UUID.randomUUID().toString() + "'\n           ,'" + valorRseultado + "'\n           ,'" + idValoresReferencia + "'\n           ,'" + codigoIdResultadoBs1 + "') ";
        System.out.println("INSERT bs1 : " + sql);
        cm.ejecutarSQL(sql);
        cm.cerrarConexionBd();
        mActualizaEstadoEnviadoGIIS(isResultado, idProtocolo);
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void insertCabezeraResultadosBS1(String LEpra_ID, String zPCli_ID, String zLab_ID) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sqlValidarExamenPrac = "select count(zPCli_ID) as registro from  Laboratorio_ExamenPracticado\nwhere zPCli_ID='" + zPCli_ID + "' and zLab_ID ='" + zLab_ID + "'";
        int resultado = Integer.valueOf(cm.traerDato(sqlValidarExamenPrac)).intValue();
        if (resultado == 0) {
            String sql = "INSERT INTO Laboratorio_ExamenPracticado\n   ([LEpra_ID] \n           ,[zPCli_ID] \n           ,[zLab_ID]) \n     VALUES\n ( '" + LEpra_ID + "'\n,'" + zPCli_ID + "' \n,'" + zLab_ID + "') ";
            System.out.println("INSERT bs1 : " + sql);
            cm.ejecutarSQL(sql);
        }
        cm.cerrarConexionBd();
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarMedicoBs1(String zLab_ID, String idMedico) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sql = "UPDATE [dbo].[Laboratorio]\n   SET [zEmp_ID_Medico] = '" + idMedico + "'        \n      ,[Lab_FechaCie] = CONVERT(DATE,'" + this.xmetodos.formatoDMAH24_2.format(this.xmetodos.getFechaActual()) + "')\n WHERE [Lab_ID] ='" + zLab_ID + "' \n";
        System.out.println("validacion " + sql);
        cm.ejecutarSQL(sql);
        cm.cerrarConexionBd();
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public void actualizarObservacionBs1(String zLab_ID, String observacionBs1) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sql = "UPDATE [dbo].[Laboratorio]\n   SET Lab_Observacion = '" + observacionBs1 + "'\n      \n WHERE Lab_ID ='" + zLab_ID + "'";
        System.out.println("validacion " + sql);
        cm.ejecutarSQL(sql);
        cm.cerrarConexionBd();
    }

    @Override // com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO
    public LaboratoriosDTO recepcionIdOrdenColgenes(String idOrdenPsl) {
        ConsultasMySQL cm = new ConsultasMySQL();
        LaboratoriosDTO e = new LaboratoriosDTO();
        try {
            String sql = "SELECT\n    `factura`\n    , `fecha`\n    , `hora`\n    , `tipoIdentificacion`\n    , `identificacion`\n    , `nombre1` , nombre2 \n    , `apellido1`\n    , `apellido2`\n    , `sexo`\n    , `fechaNacimiento`\n    , `direccion`\n    , `telefono`\n    , `email`\nFROM\n    `baseserver`.`il_interfaz`\nWHERE (`factura` ='" + idOrdenPsl + "')\nGROUP BY `factura`, `fecha`;";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    e.setNumeroOrden(rs2.getString("factura"));
                    e.setFechaOrden(rs2.getString("fecha"));
                    e.setTipoDocumento(rs2.getString("tipoIdentificacion"));
                    e.setDocumento(rs2.getString("identificacion"));
                    e.setApellido1(rs2.getString("apellido1"));
                    e.setApellido2(rs2.getString("apellido2"));
                    e.setNombre1(rs2.getString("nombre1"));
                    e.setNombre2(rs2.getString("nombre2"));
                    e.setIdSexo(rs2.getString("sexo"));
                    e.setFechaNacimiento(rs2.getString("fechaNacimiento"));
                    e.setDireccion(rs2.getString("direccion"));
                    e.setMovil(rs2.getString("telefono"));
                    e.setIdRecepcion(Long.valueOf(rs2.getLong("factura")));
                    e.setHoraOrden(rs2.getString("hora"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioBienestarDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }
}
