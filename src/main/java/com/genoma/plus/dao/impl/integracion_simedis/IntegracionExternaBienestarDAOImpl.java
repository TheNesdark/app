package com.genoma.plus.dao.impl.integracion_simedis;

import Utilidades.ConsultasMySQL;
import Utilidades.ConsultasPostgresSql;
import Utilidades.ConsultasSqlServer;
import com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/integracion_simedis/IntegracionExternaBienestarDAOImpl.class */
public class IntegracionExternaBienestarDAOImpl implements IntegracionExternaBienestarDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public List<Object[]> listadoProcedimientoItems(String idItemsOrdenExterna, Integer tipoConsulta) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaBienestarDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Nbre"), Integer.valueOf(rs.getInt("idCodigoPadre"))};
                return fila;
            }
        };
        String xSql = null;
        if (tipoConsulta.intValue() == 0) {
            xSql = "SELECT\n    g_procedimiento.Id\n    , g_procedimiento.Nbre\n    , l_homologacion_items_externos.idCodigoPadre\nFROM\n    l_homologacion_items_externos\n    INNER JOIN g_procedimiento \n        ON (l_homologacion_items_externos.idProcedimiento = g_procedimiento.Id)\nWHERE (l_homologacion_items_externos.idCodigoPadre IN(" + idItemsOrdenExterna + "))";
        } else if (tipoConsulta.intValue() == 1) {
            xSql = "SELECT\n  (IFNULL(g_procedimiento.Id, 0)+IFNULL(g_procedimiento_1.Id,0)) Id\n    , IF(g_procedimiento.Nbre IS NULL,IF(g_procedimiento_1.Nbre IS NULL, '',g_procedimiento_1.Nbre) , g_procedimiento.Nbre) Nbre\n    , l_sifas_orden_examen_detalle.detalleOrdenOid as idCodigoPadre\n \nFROM\n    l_sifas_orden_examen_detalle\n    INNER JOIN l_sifas_orden_examen \n        ON (l_sifas_orden_examen_detalle.idOrdenExamen = l_sifas_orden_examen.id)\n    LEFT JOIN g_procedimiento \n        ON (g_procedimiento.Id = l_sifas_orden_examen_detalle.codigoExamen)\n    LEFT JOIN g_procedimiento AS g_procedimiento_1 \n        ON (g_procedimiento_1.C_Real = l_sifas_orden_examen_detalle.codigoExamen)\n  WHERE (ordenConsecutivo='" + idItemsOrdenExterna + "')\nGROUP BY l_sifas_orden_examen_detalle.codigoExamen, l_sifas_orden_examen_detalle.detalleOrdenOid, l_sifas_orden_examen.admisionHAVING Id<>0";
        }
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public List<Object[]> listadoProcedimientoItemsDinamica(String idOrdenDinamica) {
        ConsultasMySQL cm = new ConsultasMySQL();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = "SELECT id, solicitud_id, \ncodigoExamen AS SIPCODCUP, \n'' AS SIPNOMBRE, \ndetalleOrdenOid AS SIPCODIGO \nFROM l_dgl_solicitud_examenes_detalle  WHERE ordenId = '" + idOrdenDinamica + "'";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    Object[] fila = {rs2.getString("SIPCODCUP"), rs2.getString("SIPNOMBRE"), rs2.getString("SIPCODIGO")};
                    e.add(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public List<Object[]> listadoProcedimientoItemsGIIS(String idOrdenDinamica) {
        ConsultasPostgresSql cm = new ConsultasPostgresSql();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = "select\n    codigo_examen,\n    '' as nombre ,\n    orden15 , hc10 \nfrom\n    public.interface_datalab_solicitudes ids\nwhere\n    orden14 ='" + idOrdenDinamica + "' and hc10='0'";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    Object[] fila = {rs2.getString("codigo_examen"), rs2.getString("nombre"), rs2.getString("orden15")};
                    e.add(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public List<Object[]> listadoProcedimientoItemsCNT(String idOrdenCnt, String tabla) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = "SELECT\n\tCOD_EXAMEN,\n\tCANTIDAD,\n\tFACTURA, ORDENADMIN \n\t\nFROM\n\t" + tabla + "\nWHERE FACTURA='" + idOrdenCnt + "' AND ESTADO='0'";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    Object[] fila = {rs2.getString("COD_EXAMEN"), rs2.getString("CANTIDAD"), rs2.getString("FACTURA"), rs2.getString("ORDENADMIN")};
                    e.add(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public List<Object[]> listadoProcedimientoHomologadosCNT(String idProcedimeintoCnt) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaBienestarDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id"))};
                return fila;
            }
        };
        String xSql = "SELECT\n    g_procedimiento.Id\nFROM\n    baseserver.g_procedimiento\n    INNER JOIN baseserver.g_procedimientoxcnt \n        ON (g_procedimiento.Id = g_procedimientoxcnt.idprocedimiento)\nWHERE (g_procedimientoxcnt.codigocnt ='" + idProcedimeintoCnt + "');";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public List<Object[]> listadoProcedimientoItemsBS1(String idOrdenDinamica) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        ConsultasMySQL cx = new ConsultasMySQL();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = "SELECT HIST.HCli_ID ID,\n\t\t  HISTEXA.EPa_ID,\n\t\t  HISTEXA.EPa_Nombre,\n\t\t  EMPL.zLab_ID IDLAB,\n\t\t  HIST.HCli_HistoriaOk HistCerrada ,\n\t\t  HISTPARA.PCli_ID,\n\t\t  EMPL.zEmpr_ID,\n\t\t  HISTPARA.PCli_Cantidad\n\t      FROM Persona PER INNER JOIN\n\t\t  Persona_Documento PERDOC ON PER.zDoc_ID = PERDOC.Doc_ID INNER JOIN\n\t\t  Persona_TipoDocumento TICDOC ON PERDOC.zTDoc_ID = TICDOC.TDoc_ID INNER JOIN\n\t\t  Empresa_Empleado EMPL ON PER.Per_ID = EMPL.zPer_ID INNER JOIN\n\t\t  General_Contacto GENCON ON PER.zCon_ID = GENCON.Con_ID INNER JOIN\n\t\t  General_Ubicacion GUBIC ON GUBIC.zCon_ID = GENCON.Con_ID INNER JOIN\n\t\t  General_Municipio GMUN ON GMUN.Mun_ID = GUBIC.zMun_ID INNER JOIN\n\t\t  General_Telefono TEL ON TEL.zCon_ID = GENCON.Con_ID INNER JOIN\n\t\t  Persona_Genero GEN ON GEN.Gen_ID = PER.zGen_ID  LEFT JOIN\n\t\t  Laboratorio LAB ON LAB.Lab_ID = EMPL.zLab_ID LEFT JOIN\n\t\t  HistoriaClinica HIST  ON HIST.HCli_ID = EMPL.zHCli_ID LEFT JOIN\n\t\t  HistoriaClinica_Paraclinicos HISTPARA ON HIST.HCli_ID = HISTPARA.zHCli_ID LEFT JOIN\n\t\t  HistoriaClinica_ExamenParaclinico HISTEXA ON HISTEXA.EPa_ID = HISTPARA.zEpa_ID LEFT JOIN\n\t\t  HistoriaClinica_TipoExamen TIPOEXA ON TIPOEXA.TExa_ID = HIST.zTExa_ID\n\t\t  \n\t\t   WHERE  HIST.HCli_ID ='" + idOrdenDinamica + "' \n GROUP BY HIST.HCli_ID, HISTEXA.EPa_ID, HISTEXA.EPa_Nombre, EMPL.zLab_ID , HIST.HCli_HistoriaOk, \n\t\t  HISTPARA.PCli_ID, EMPL.zEmpr_ID, HISTPARA.PCli_Cantidad";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    Object[] fila = {rs2.getString("EPa_ID"), rs2.getString("EPa_Nombre"), rs2.getString("ID"), rs2.getString("PCli_ID")};
                    e.add(fila);
                    String SqlValidarSiExiste = "SELECT  COUNT(ii.HCli_ID) AS 'Existe'FROM i_interfazprocedimientosbs1 ii \nWHERE ii.HCli_ID  ='" + rs2.getString("ID") + "' AND ii.PCli_ID ='" + rs2.getString("PCli_ID") + "'";
                    int dato = Integer.valueOf(cx.traerDato(SqlValidarSiExiste)).intValue();
                    if (dato == 0) {
                        String SqlxD = "INSERT INTO i_interfazprocedimientosbs1 (HCli_ID,EPa_ID,EPa_Nombre,IDLAB,HistCerrada,PCli_ID, zEmpr_ID, PCli_Cantidad ) VALUES ('" + rs2.getString("ID") + "','" + rs2.getString("EPa_ID") + "','" + rs2.getString("EPa_Nombre") + "','" + rs2.getString("IDLAB") + "','" + rs2.getString("HistCerrada") + "','" + rs2.getString("PCli_ID") + "','" + rs2.getString("zEmpr_ID") + "','" + rs2.getString("PCli_Cantidad") + "')";
                        cx.ejecutarSQL(SqlxD);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        cm.cerrarConexionBd();
        cx.cerrarConexionBd();
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public List<Object[]> listadoProcedimientoEncabezadoBS1(String idOrdenbs1, int idConvenio) {
        ConsultasMySQL cx = new ConsultasMySQL();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = "SELECT  \t\t\n            f_tiposervtipoproced.Idtiposervicio , \n            g_procedimiento.Nbre AS Procedimiento,\n\t    SUM(IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND)) AS Valor , i_interfazprocedimientosbs1.`PCli_ID` \n           \t\n            FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n            INNER JOIN g_procedimientoxcnt ON g_procedimientoxcnt.idprocedimiento=g_procedimiento.Id\n            INNER JOIN i_interfazprocedimientosbs1 ON i_interfazprocedimientosbs1.EPa_ID=g_procedimientoxcnt.codigocnt\n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN g_homologacion_convenio ON g_homologacion_convenio.idConvenioGenoma=f_empresacontxconvenio.Id\n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.Idtiposervicio= f_servicioempresaconv.Id_TipoServicio)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) AND (f_procedempresaconvenio.Estado=0) \n            WHERE  idConvenioGenoma='" + idConvenio + "' \n            -- AND g_procedimiento.Estado=0\n            AND i_interfazprocedimientosbs1.HCli_ID='" + idOrdenbs1 + "'\n            GROUP BY  f_tiposervtipoproced.Idtiposervicio\n            ORDER BY Procedimiento ASC;\n            ";
            ResultSet rs2 = cx.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    Object[] fila = {rs2.getString("Idtiposervicio"), rs2.getString("Procedimiento"), rs2.getString("Valor"), rs2.getString("PCli_ID")};
                    e.add(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public void insertEmcabezadoOrdenBs1(String PCli_ID, String PCli_Fecha, String PCli_Resultado, String zEpa_ID, String zHCli_ID) {
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public List<Object[]> listadoProcedimientoItemsColgenes(String idOrdenColgenes) {
        ConsultasMySQL cm = new ConsultasMySQL();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = "SELECT\n    codigoItems\n    , '1' as cantidad \n    , factura\n    , identificacion\nFROM\n    baseserver.il_interfaz\nWHERE (factura ='" + idOrdenColgenes + "' AND estadoRecepcion=0);";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    Object[] fila = {rs2.getString("codigoItems"), rs2.getString("cantidad"), rs2.getString("factura"), rs2.getString("identificacion")};
                    e.add(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public List<Object[]> listadoProcedimientosBS1(int idConvenio, String idHistoriaBs1, String idTipoServicio) {
        ConsultasMySQL cm = new ConsultasMySQL();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = "SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            f_tarifaprocedimiento.CodCUPS, \n            g_procedimiento.Nbre AS Procedimiento,\n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor\n\t    , f_tiposervtipoproced.Idtiposervicio , i_interfazprocedimientosbs1.HCli_ID  \n            , f_tipofinprocedimiento.Id as IdTipoFinProcedimiento , g_procedimientoxcnt.codigocnt,  i_interfazprocedimientosbs1.`PCli_ID`\t\n            FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n            INNER JOIN f_tipofinprocedimiento ON f_tipofinprocedimiento.Id=g_procedimiento.Id_TipoFinProced\n            INNER JOIN g_procedimientoxcnt ON g_procedimientoxcnt.idprocedimiento=g_procedimiento.Id\n            INNER JOIN i_interfazprocedimientosbs1 ON i_interfazprocedimientosbs1.EPa_ID=g_procedimientoxcnt.codigocnt\n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN g_homologacion_convenio ON g_homologacion_convenio.idConvenioGenoma=f_empresacontxconvenio.Id\n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.Idtiposervicio= f_servicioempresaconv.Id_TipoServicio)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) AND (f_procedempresaconvenio.Estado=0) \n            WHERE  idConvenioGenoma='" + idConvenio + "' \n            AND f_tiposervtipoproced.Idtiposervicio='" + idTipoServicio + "'\n            -- AND g_procedimiento.Estado=0\n            AND i_interfazprocedimientosbs1.HCli_ID='" + idHistoriaBs1 + "' group by Procedimiento   \n            ORDER BY Procedimiento ASC;";
            System.out.println("" + sql);
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    Object[] fila = {rs2.getString("Id"), rs2.getString("CodCUPS"), rs2.getString("Procedimiento"), rs2.getString("Valor"), rs2.getString("Idtiposervicio"), rs2.getString("IdTipoFinProcedimiento"), rs2.getString("codigocnt"), rs2.getString("HCli_ID"), rs2.getString("PCli_ID")};
                    e.add(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO
    public void actualizarHistoriaBS1(String HistoriaClinica) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        String sql = "update Empresa_Empleado set EstadoGenoma = 1 where zHCli_ID= '" + HistoriaClinica + "'";
        System.out.println("validacion " + sql);
        cm.ejecutarSQL(sql);
        cm.ejecutaSQLUpdate("UPDATE HistoriaClinica SET CambioEnParaclinicos = '0' WHERE HCli_ID = '" + HistoriaClinica + "'");
        cm.cerrarConexionBd();
    }
}
