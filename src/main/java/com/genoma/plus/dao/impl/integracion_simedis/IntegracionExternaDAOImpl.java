package com.genoma.plus.dao.impl.integracion_simedis;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.ConsultasPostgresSql;
import Utilidades.ConsultasSqlServer;
import com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/integracion_simedis/IntegracionExternaDAOImpl.class */
public class IntegracionExternaDAOImpl implements IntegracionExternaDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
    public List<Object[]> listadoProcedimientoItems(String idItemsOrdenExterna, Integer tipoConsulta) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Nbre"), Integer.valueOf(rs.getInt("idCodigoPadre"))};
                return fila;
            }
        };
        String xSql = null;
        if (tipoConsulta.intValue() == 0) {
            xSql = "SELECT\n    `g_procedimiento`.`Id`\n    , g_procedimiento.`Nbre`\n    , 0 as `idCodigoPadre`\nFROM\n    `g_procedimientoxcnt`\n    INNER JOIN `g_procedimiento` \n        ON (`g_procedimientoxcnt`.`idProcedimiento` = `g_procedimiento`.`Id`)\nWHERE (`g_procedimientoxcnt`.`codigocnt` IN(" + idItemsOrdenExterna + ") AND `g_procedimientoxcnt`.estado =1)";
        } else if (tipoConsulta.intValue() == 1) {
            xSql = "SELECT\n  (IFNULL(`g_procedimiento`.`Id`, 0)+IFNULL(`g_procedimiento_1`.`Id`,0)) Id\n    , IF(`g_procedimiento`.`Nbre` IS NULL,IF(`g_procedimiento_1`.`Nbre` IS NULL, '',`g_procedimiento_1`.`Nbre`) , `g_procedimiento`.`Nbre`) Nbre\n    , `l_sifas_orden_examen_detalle`.`detalleOrdenOid` as idCodigoPadre\n \nFROM\n    `l_sifas_orden_examen_detalle`\n    INNER JOIN `l_sifas_orden_examen` \n        ON (`l_sifas_orden_examen_detalle`.`idOrdenExamen` = `l_sifas_orden_examen`.`id`)\n    LEFT JOIN `g_procedimiento` \n        ON (`g_procedimiento`.`Id` = `l_sifas_orden_examen_detalle`.`codigoExamen`)\n    LEFT JOIN `g_procedimiento` AS `g_procedimiento_1` \n        ON (`g_procedimiento_1`.`C_Real` = `l_sifas_orden_examen_detalle`.`codigoExamen`)\n  WHERE (`ordenConsecutivo`='" + idItemsOrdenExterna + "')\nGROUP BY `l_sifas_orden_examen_detalle`.`codigoExamen`, `l_sifas_orden_examen_detalle`.`detalleOrdenOid`, `l_sifas_orden_examen`.`admision`HAVING Id<>0";
        }
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
    public List<Object[]> listadoProcedimientoItemsSifas(String idItemsOrdenExterna, String idCodigoInternoInterface) {
        String xSql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Nbre"), Integer.valueOf(rs.getInt("idCodigoPadre"))};
                return fila;
            }
        };
        if (!idCodigoInternoInterface.isEmpty()) {
            xSql = "select\n\tgp2.Id,\n\tgp2.Nbre,\n\tlsoed.detalleOrdenOid as idCodigoPadre\nfrom\n\tl_sifas_orden_examen_detalle lsoed\ninner join l_sifas_orden_examen lsoe on\n\t(lsoe.id = lsoed.idOrdenExamen)\ninner join g_procedimientoxcnt gp on\n\t(gp.codigocnt = lsoed.codigoExamen)\ninner join g_procedimiento gp2 on\n\t(gp2.Id = gp.idprocedimiento)\nwhere\n\t(lsoe.ordenConsecutivo = '" + idItemsOrdenExterna + "' AND lsoed.idOrdenExamen = '" + idCodigoInternoInterface + "'\n\t\tand gp.estado = 1);";
        } else {
            xSql = "select\n\tgp2.Id,\n\tgp2.Nbre,\n\tlsoed.detalleOrdenOid as idCodigoPadre\nfrom\n\tl_sifas_orden_examen_detalle lsoed\ninner join l_sifas_orden_examen lsoe on\n\t(lsoe.id = lsoed.idOrdenExamen)\ninner join g_procedimientoxcnt gp on\n\t(gp.codigocnt = lsoed.codigoExamen)\ninner join g_procedimiento gp2 on\n\t(gp2.Id = gp.idprocedimiento)\nwhere\n\t(lsoe.ordenConsecutivo = '" + idItemsOrdenExterna + "'\n\t\tand gp.estado = 1);";
        }
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
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

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
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

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
    public List<Object[]> listadoProcedimientoItemsCNT(String idOrdenCnt, String fecha, String tabla, String noDocumento) {
        String sql;
        ConsultasSqlServer cm = new ConsultasSqlServer();
        List<Object[]> e = new ArrayList<>();
        try {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                sql = "SELECT\n\tCOD_EXAMEN,\n\tCANTIDAD,\n\tFACTURA, ORDENADMIN\n\tFROM " + tabla + "\n\tWHERE NUM_PETICION='" + idOrdenCnt + "' AND DOCUMENTO = '" + noDocumento + "' AND convert(varchar(10),FECHA,103)='" + fecha + "' AND ESTADO='0'";
            } else {
                sql = "SELECT\n\tCOD_EXAMEN,\n\tCANTIDAD,\n\tFACTURA, ORDENADMIN \n\t\nFROM\n\t" + tabla + "\nWHERE FACTURA='" + idOrdenCnt + "' -- AND ESTADO='0'";
            }
            ResultSet rs2 = cm.traerRs(sql);
            System.out.println("Procedimiento--> " + sql);
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
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
    public List<Object[]> listadoProcedimientoHomologadosCNT(String idProcedimeintoCnt) {
        String xSql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id"))};
                return fila;
            }
        };
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
            xSql = "SELECT\n    `g_procedimiento`.`Id`\nFROM\n    `g_procedimiento`\n    INNER JOIN `g_procedimientoxcnt` \n        ON (`g_procedimiento`.`Id` = `g_procedimientoxcnt`.`idprocedimiento`)\nWHERE (`g_procedimientoxcnt`.`codigocnt`= TRIM('" + idProcedimeintoCnt + "') AND g_procedimientoxcnt.estado=1)\nGroup By `g_procedimiento`.`Id`;";
        } else {
            xSql = "SELECT\n    `g_procedimiento`.`Id`\nFROM\n    `g_procedimiento`\n    INNER JOIN `g_procedimientoxcnt` \n        ON (`g_procedimiento`.`Id` = `g_procedimientoxcnt`.`idprocedimiento`)\nWHERE (`g_procedimientoxcnt`.`codigocnt` ='" + idProcedimeintoCnt + "')Group By `g_procedimiento`.`Id`;";
            System.out.println("xsql-->" + xSql);
        }
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
    public List<Object[]> listadoProcedimientoItemsBS1(String idOrdenDinamica) {
        ConsultasSqlServer cm = new ConsultasSqlServer();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = " SELECT HIST.HCli_ID ID,\n\t\t  HISTEXA.EPa_ID,\n\t\t  HISTEXA.EPa_Nombre,\n\t\t  EMPL.zLab_ID IDLAB,\n\t\t  HIST.HCli_HistoriaOk HistCerrada ,\n\t\t  HISTPARA.PCli_ID,\n\t\t  TOMA.Toma_Realizado,\n\t      TOMA.Toma_ValGenoma\t\t \n\n     FROM Persona PER INNER JOIN\n\t\t  Persona_Documento PERDOC ON PER.zDoc_ID = PERDOC.Doc_ID INNER JOIN\n\t\t  Persona_TipoDocumento TICDOC ON PERDOC.zTDoc_ID = TICDOC.TDoc_ID INNER JOIN\n\t\t  Empresa_Empleado EMPL ON PER.Per_ID = EMPL.zPer_ID INNER JOIN\n\t\t  General_Contacto GENCON ON PER.zCon_ID = GENCON.Con_ID INNER JOIN\n\t\t  General_Ubicacion GUBIC ON GUBIC.zCon_ID = GENCON.Con_ID INNER JOIN\n\t\t  General_Municipio GMUN ON GMUN.Mun_ID = GUBIC.zMun_ID INNER JOIN\n\t\t  General_Telefono TEL ON TEL.zCon_ID = GENCON.Con_ID INNER JOIN\n\t\t  Persona_Genero GEN ON GEN.Gen_ID = PER.zGen_ID  INNER JOIN\n\t\t  Laboratorio LAB ON LAB.Lab_ID = EMPL.zLab_ID INNER JOIN\n\t\t  HistoriaClinica HIST  ON HIST.HCli_ID = EMPL.zHCli_ID INNER JOIN\n\t\t  HistoriaClinica_Paraclinicos HISTPARA ON HIST.HCli_ID = HISTPARA.zHCli_ID INNER JOIN\n\t\t  HistoriaClinica_ExamenParaclinico HISTEXA ON HISTEXA.EPa_ID = HISTPARA.zEpa_ID INNER JOIN\n\t\t  HistoriaClinica_TipoExamen TIPOEXA ON TIPOEXA.TExa_ID = HIST.zTExa_ID INNER JOIN\n\t\t  Laboratorio_TomaMuestra TOMA ON HIST.HCli_ID = TOMA.zHcli_ID \n\n   WHERE  HIST.HCli_ID ='" + idOrdenDinamica + "' AND \n\t\t  TOMA.Toma_ValGenoma = 0 AND \n\t\t  TOMA.Toma_Realizado = 1 AND \n\t\t  TOMA.zEpa_ID = HISTEXA.EPa_ID\n GROUP BY HIST.HCli_ID, HISTEXA.EPa_ID, HISTEXA.EPa_Nombre, EMPL.zLab_ID , HIST.HCli_HistoriaOk, \n\t\t  HISTPARA.PCli_ID, TOMA.Toma_Realizado, TOMA.Toma_ValGenoma";
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    Object[] fila = {rs2.getString("EPa_ID"), rs2.getString("EPa_Nombre"), rs2.getString("ID"), rs2.getString("PCli_ID")};
                    e.add(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
    public List<Object[]> listadoProcedimientoEncabezadoBS1(String idOrdenbs1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
    public void insertEmcabezadoOrdenBs1(String PCli_ID, String PCli_Fecha, String PCli_Resultado, String zEpa_ID, String zHCli_ID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
    public List<Object[]> listadoProcedimientoItemsColgenes(String idOrdenColgenes) {
        ConsultasMySQL cm = new ConsultasMySQL();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = "SELECT\n    `codigoItems`\n    , '1' as cantidad \n    , `factura`\n    , `identificacion`\nFROM\n    `il_interfaz`\nWHERE (`factura` ='" + idOrdenColgenes + "' AND `estadoRecepcion`=0);";
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

    @Override // com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO
    public List<Object[]> listadoProcedimientoItemsXenco(String idOrdenXenco) {
        ConsultasMySQL cm = new ConsultasMySQL();
        List<Object[]> e = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT\n    `Articulo`,\n    `NumeroDocumentoGestion`\nFROM\n    `i_interfaz_xenco_orden`\nWHERE (`NumeroDocumentoGestion` IN (" + idOrdenXenco + ")\n    AND `EstadoGenoma` =0)";
            System.out.println(sql);
            ResultSet rs2 = cm.traerRs(sql);
            if (rs2.next()) {
                rs2.beforeFirst();
                while (rs2.next()) {
                    Object[] fila = {rs2.getString("Articulo"), rs2.getString("NumeroDocumentoGestion")};
                    e.add(fila);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaboratorioDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return e;
    }
}
