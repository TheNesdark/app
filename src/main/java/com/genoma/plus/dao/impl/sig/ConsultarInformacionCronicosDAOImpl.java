package com.genoma.plus.dao.impl.sig;

import com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/sig/ConsultarInformacionCronicosDAOImpl.class */
public class ConsultarInformacionCronicosDAOImpl implements ConsultaInformacionCronicosDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public List<Object[]> listaConvenios(String fechaInicial, String fechaFinal) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = new Object[3];
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                return fila;
            }
        };
        String xSql = "SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  \n        WHERE (`h_atencion`.`Codigo_Dxp` <>''    \n    AND `h_atencion`.`Fecha_Atencion` >='" + fechaInicial + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + fechaFinal + "')   \n    \n    GROUP BY  f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre` ASC\n";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public void mEliminarDatosTabla() {
        this.jdbcTemplate.update("DELETE FROM  `cronicos_comfacor_res`");
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public List<Object[]> listaConsultasSql() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), Long.valueOf(rs.getLong(4)), Long.valueOf(rs.getLong(5)), Long.valueOf(rs.getLong(6)), Long.valueOf(rs.getLong(7)), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)};
                return fila;
            }
        };
        System.out.println("xsql-->SELECT\n    `Id`\n    , `Nombre`\n    , `Sql`\n    , `Orden`\n    , `NParametro`\n    , `Tipo`\n    , `Iteracciones`,`IdEspecialidad`, `VInicialC`, `IdProtocolo`  , `Cups`, IdSubgrupoF\nFROM\n    `cronicos_comfacor_sql`\nWHERE (`Estado` =1)\nORDER BY `Orden` ASC");
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n    `Id`\n    , `Nombre`\n    , `Sql`\n    , `Orden`\n    , `NParametro`\n    , `Tipo`\n    , `Iteracciones`,`IdEspecialidad`, `VInicialC`, `IdProtocolo`  , `Cups`, IdSubgrupoF\nFROM\n    `cronicos_comfacor_sql`\nWHERE (`Estado` =1)\nORDER BY `Orden` ASC", mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public void EjecutarConsultas(String fechaInicial, String fechaFinal, String idConvenio, String sql, Long nParametros) {
        if (nParametros.longValue() == 3) {
            this.jdbcTemplate.update(sql, new Object[]{idConvenio, fechaInicial, fechaFinal});
        } else if (nParametros.longValue() == 6) {
            this.jdbcTemplate.update(sql, new Object[]{idConvenio, fechaInicial, fechaFinal, idConvenio, fechaInicial, fechaFinal});
        }
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public List<Object[]> listaAtencionesEspecialidad(String fechaInicial, String fechaFinal, String idConvenio, String idEspecialidad) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), Long.valueOf(rs.getLong(3))};
                return fila;
            }
        };
        String xSql = "SELECT \nd.Id_Usuario, d.Fecha_Atencion, f.NAtencion\nFROM (\nSELECT\n    `h_atencion`.`Fecha_Atencion`\n    , `ingreso`.`Id_Usuario`\nFROM\n     `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + fechaInicial + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + fechaFinal + "'\n    AND `ingreso`.`Id_EmpresaContxConv` ='" + idConvenio + "'\n    AND `h_atencion`.`Codigo_Dxp` <>''\n    AND `h_atencion`.`Id_Especialidad` in(" + idEspecialidad + "))\nORDER BY `ingreso`.`Id_Usuario` ASC, `h_atencion`.`Fecha_Atencion` ASC\n) d INNER JOIN (\nSELECT\n   COUNT(h_atencion.`Id`) NAtencion, ingreso.`Id_Usuario`\nFROM\n    `h_atencion`\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nWHERE (`h_atencion`.`Codigo_Dxp` <>''\n    AND `f_empresacontxconvenio`.`Id` ='" + idConvenio + "'\n    AND `h_atencion`.`Fecha_Atencion` >='" + fechaInicial + "'\n    AND `h_atencion`.`Fecha_Atencion` <='" + fechaFinal + "'\n    AND `h_atencion`.`Id_Especialidad` in(" + idEspecialidad + "))\nGROUP BY `ingreso`.`Id_Usuario`) f\n   ON (d.Id_Usuario = f.Id_Usuario) order by f.NAtencion desc";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public void actualizarVariableenTabla(String variable, String datoVariable, String idUsuario) {
        String sql = "update cronicos_comfacor_res SET " + variable + "='" + datoVariable + "' WHERE Id_persona=" + idUsuario + "";
        System.out.println("xsql-->" + sql);
        this.jdbcTemplate.update(sql);
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public List<Object[]> listaResultadoExamenProtocoloOrdenASC(String fechaInicial, String fechaFinal, String idConvenio, String idProcedimiento, String idProcolo) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4)};
                return fila;
            }
        };
        String xSql = "SELECT \n `d`.`Id_Paciente`\n    , `d`.`FechaResult`\n    , `d`.`VrNumerico`, f.Cant\nFROM (\nSELECT\n    `l_recepcion`.`Id_Paciente`\n    , `l_resultados`.`FechaResult`\n    , `l_detalleresultado`.`VrNumerico`   \nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocolos`.`Id` ='" + idProcolo + "'\n    AND `l_resultados`.`FechaResult` <='" + fechaFinal + "'\n    AND `l_protocoloxprocedimiento`.`Id_Procedim` ='" + idProcedimiento + "')\nGROUP BY `l_recepcion`.`Id_Paciente`, `l_protocolos`.`Id`, `l_resultados`.`Id`) d\nINNER JOIN (\nSELECT\n    `l_recepcion`.`Id_Paciente`   \n    , COUNT(`l_resultados`.`Id`) Cant\nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocolos`.`Id` ='" + idProcolo + "'\n    AND `l_resultados`.`FechaResult` <='" + fechaFinal + "'\n    AND `l_protocoloxprocedimiento`.`Id_Procedim` ='" + idProcedimiento + "')\nGROUP BY `l_recepcion`.`Id_Paciente`, `l_protocolos`.`Id`\n) f ON (d.Id_Paciente=f.Id_Paciente)\n\nORDER BY f.Cant DESC, `d`.`Id_Paciente` ASC, `d`.`FechaResult` asc ";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public List<Object[]> listaResultadoExamenProtocoloOrdenDES(String fechaInicial, String fechaFinal, String idConvenio, String idProcedimiento, String idProcolo) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4)};
                return fila;
            }
        };
        String xSql = "SELECT \n `d`.`Id_Paciente`\n    , `d`.`FechaResult`\n    , `d`.`VrNumerico`, f.Cant\nFROM (\nSELECT\n    `l_recepcion`.`Id_Paciente`\n    , `l_resultados`.`FechaResult`\n    , `l_detalleresultado`.`VrNumerico`   \nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocolos`.`Id` ='" + idProcolo + "'\n    AND `l_resultados`.`FechaResult` >='" + fechaInicial + "'\n    AND `l_resultados`.`FechaResult` <='" + fechaFinal + "'\n    AND `l_protocoloxprocedimiento`.`Id_Procedim` ='" + idProcedimiento + "')\nGROUP BY `l_recepcion`.`Id_Paciente`, `l_protocolos`.`Id`, `l_resultados`.`Id`) d\nINNER JOIN (\nSELECT\n    `l_recepcion`.`Id_Paciente`   \n    , COUNT(`l_resultados`.`Id`) Cant\nFROM\n     `l_detalleresultado`\n    INNER JOIN  `l_resultados` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN  `l_recepcion` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN  `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN  `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\nWHERE (`l_recepcion`.`Estado` =0\n    AND `l_protocolos`.`Id` ='" + idProcolo + "'\n    AND `l_resultados`.`FechaResult` >='" + fechaInicial + "'\n    AND `l_resultados`.`FechaResult` <='" + fechaFinal + "'\n    AND `l_protocoloxprocedimiento`.`Id_Procedim` ='" + idProcedimiento + "')\nGROUP BY `l_recepcion`.`Id_Paciente`, `l_protocolos`.`Id`\n) f ON (d.Id_Paciente=f.Id_Paciente)\n\nORDER BY f.Cant DESC, `d`.`Id_Paciente` ASC, `d`.`FechaResult` desc ";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public List<Object[]> listaUltimaFechaRelizacionProcedimiento(String fechaInicial, String fechaFinal, String idConvenio, String idProcedimiento) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl.6
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), rs.getString(2), rs.getString(3), rs.getString(4)};
                return fila;
            }
        };
        String xSql = "SELECT d.Id_Usuario, f.FechaOrden, f.ResultadoTexto, d.NExamenes\nFROM \n(SELECT\n    `ingreso`.`Id_Usuario`\n    , MAX(`f_ordenes`.`Id`) AS `IdOrden`\n    , COUNT(`f_ordenes`.`Id`) AS `NExamenes`\nFROM\n    `f_ordenes`\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE (`f_itemordenesproced`.`Id_Procedimiento` ='" + idProcedimiento + "'\n    AND `ingreso`.`Id_EmpresaContxConv` ='" + idConvenio + "'\n    AND `f_ordenes`.`FechaOrden` >='" + fechaInicial + "'\n    AND `f_ordenes`.`FechaOrden` <='" + fechaFinal + "' AND f_ordenes.`Estado`=0)\nGROUP BY `ingreso`.`Id_Usuario`) d INNER JOIN\n(SELECT\n    `f_ordenes`.`Id` AS `IdOrden`\n    , `f_ordenes`.`FechaOrden`\n    , `f_itemordenesproced`.`ResultadoTexto`\n    , `ingreso`.`Id_Usuario`\nFROM\n    `f_ordenes`\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_itemordenesproced` \n        ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\nWHERE (`f_itemordenesproced`.`Id_Procedimiento`in(" + idProcedimiento + ")\n    AND `ingreso`.`Id_EmpresaContxConv` ='" + idConvenio + "'\n    AND `f_ordenes`.`Estado` =0)) f\n        ON (d.IdOrden=f.IdOrden)\n;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public List<Object[]> listaUltimaEntregaMedicamentosInventario(String fechaInicial, String fechaFinal, String idSUbGrupoFarmacologico) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl.7
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), Long.valueOf(rs.getLong(2)), rs.getString(3)};
                return fila;
            }
        };
        String xSql = "SELECT\n    MAX(`i_salidas`.`Id`) AS `IdSalida`, i_salidas.`IdDestino`\n    , 'SI' Respuesta\nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN `i_atcgrupofarmacologico` \n        ON (`i_atcsubgrupofarmacologico`.`IdGrupoFarmacologico` = `i_atcgrupofarmacologico`.`Id`)\nWHERE (`i_salidas`.`FechaSalida` >='" + fechaInicial + "'\n    AND `i_salidas`.`FechaSalida` <='" + fechaFinal + "'\n    AND `i_atcgrupofarmacologico`.`Id` IN(" + idSUbGrupoFarmacologico + "))\nGROUP BY `i_salidas`.`IdDestino`;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public List<Object[]> listaUltimaFormulacionMedicamentosHistoria(String fechaInicial, String fechaFinal, String idSUbGrupoFarmacologico) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl.8
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong(1)), Long.valueOf(rs.getLong(2)), rs.getString(3)};
                return fila;
            }
        };
        String xSql = "SELECT\n    MAX(`h_ordenes`.`Id`) AS `IdOrden`\n    , `ingreso`.`Id_Usuario`\n    , 'SI' AS `RESPUESTA`\nFROM\n    `h_itemordenessum`\n    INNER JOIN `h_ordenes` \n        ON (`h_itemordenessum`.`Id_HOrdenes` = `h_ordenes`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`h_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`)\n    INNER JOIN `i_principioactivo` \n        ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`)\n    INNER JOIN `i_atcsubgrupoquimico` \n        ON (`i_principioactivo`.`IdSubGrupoQuimico` = `i_atcsubgrupoquimico`.`Id`)\n    INNER JOIN `i_atcsubgrupofarmacologico` \n        ON (`i_atcsubgrupoquimico`.`IdSubGrupoFarmacologico` = `i_atcsubgrupofarmacologico`.`Id`)\n    INNER JOIN `i_atcgrupofarmacologico` \n        ON (`i_atcsubgrupofarmacologico`.`IdGrupoFarmacologico` = `i_atcgrupofarmacologico`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`h_ordenes`.`Estado` =0\n    AND `i_atcgrupofarmacologico`.`Id` IN(" + idSUbGrupoFarmacologico + ")\n    AND `h_ordenes`.`FechaOrden` >='" + fechaInicial + "'\n    AND `h_ordenes`.`FechaOrden` <='" + fechaFinal + "')\nGROUP BY `ingreso`.`Id_Usuario`";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.sig.ConsultaInformacionCronicosDAO
    public List<Object[]> listaDatos() {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.sig.ConsultarInformacionCronicosDAOImpl.9
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Id_TipoIdentificacion"), rs.getString("NIT"), rs.getString("Nbre"), rs.getString("CodigoOrganismo"), rs.getString("Fecha_Atencion"), rs.getString("Id_TipoIdentificacion"), rs.getString("NoDocumento"), rs.getString("Apellido1"), rs.getString("Apellido2"), rs.getString("Nombre1"), rs.getString("Nombre2"), rs.getString("Id_Sexo"), rs.getString("FechaNac"), rs.getString("Telefono"), rs.getString("Movil"), Integer.valueOf(rs.getInt("Dm")), Integer.valueOf(rs.getInt("Hta")), rs.getString("V3"), rs.getString("V6"), rs.getString("V7"), rs.getString("V8"), rs.getString("V9"), rs.getString("V10"), rs.getString("V11"), rs.getString("V12"), rs.getString("V13"), rs.getString("V14"), rs.getString("V15"), rs.getString("V16"), rs.getString("V17"), rs.getString("V18"), rs.getString("V19"), rs.getString("V20"), rs.getString("V21"), rs.getString("V22"), rs.getString("V23"), rs.getString("V24"), rs.getString("V25"), rs.getString("V26"), rs.getString("V27"), rs.getString("V28"), rs.getString("V29"), rs.getString("V30"), rs.getString("V31"), rs.getString("V32"), rs.getString("V33"), rs.getString("V34"), rs.getString("V35"), rs.getString("V36"), rs.getString("V37"), rs.getString("V38"), rs.getString("V39"), rs.getString("V40"), rs.getString("V41"), rs.getString("V42"), rs.getString("V43"), rs.getString("V44"), rs.getString("V45"), rs.getString("V46"), rs.getString("V47"), rs.getString("V48"), rs.getString("V49"), rs.getString("V50"), rs.getString("V51"), rs.getString("V52"), rs.getString("V53"), rs.getString("V54"), rs.getString("V55"), rs.getString("V56"), rs.getString("V57"), rs.getString("V58"), rs.getString("V59"), rs.getString("V60"), rs.getString("V61"), rs.getString("V62"), rs.getString("V63"), rs.getString("V64"), rs.getString("V65"), rs.getString("V66"), rs.getString("V67"), rs.getString("V68"), rs.getString("V69"), rs.getString("V70"), rs.getString("V71"), rs.getString("V72"), rs.getString("V73"), rs.getString("V74"), rs.getString("V75"), rs.getString("V76"), rs.getString("V77"), rs.getString("V78"), rs.getString("V79"), rs.getString("V80"), rs.getString("V81")};
                return fila;
            }
        };
        System.out.println("xsql-->SELECT\n    `g_ips`.`Id_TipoIdentificacion`\n    , CONCAT(`g_ips`.`Identificacion`,'-', `g_ips`.`DigitoVerificacion`) NIT\n    , `g_ips`.`Nbre`\n    , `g_ips`.`CodigoOrganismo`\n    , `h_atencion`.`Fecha_Atencion`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Id_Sexo`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Movil`\n    , `cronicos_comfacor_res`.`Dm`\n    , IFNULL(`cronicos_comfacor_res`.`Hta`,'') AS Hta\n    , IFNULL(`cronicos_comfacor_res`.`V3`,'') AS V3\n    ,IFNULL( `cronicos_comfacor_res`.`V6`,'') AS V6\n,IFNULL( `cronicos_comfacor_res`.`V7`,'') AS V7\n,IFNULL( `cronicos_comfacor_res`.`V8`,'') AS V8\n,IFNULL( `cronicos_comfacor_res`.`V9`,'') AS V9\n,IFNULL( `cronicos_comfacor_res`.`V10`,'') AS V10\n,IFNULL( `cronicos_comfacor_res`.`V11`,'') AS V11\n,IFNULL( `cronicos_comfacor_res`.`V12`,'') AS V12\n,IFNULL( `cronicos_comfacor_res`.`V13`,'') AS V13\n,IFNULL( `cronicos_comfacor_res`.`V14`,'') AS V14\n,IFNULL( `cronicos_comfacor_res`.`V15`,'') AS V15\n,IFNULL( `cronicos_comfacor_res`.`V16`,'') AS V16\n,IFNULL( `cronicos_comfacor_res`.`V17`,'') AS V17\n,IFNULL( `cronicos_comfacor_res`.`V18`,'') AS V18\n,IFNULL( `cronicos_comfacor_res`.`V19`,'') AS V19\n,IFNULL( `cronicos_comfacor_res`.`V20`,'') AS V20\n,IFNULL( `cronicos_comfacor_res`.`V21`,'') AS V21\n,IFNULL( `cronicos_comfacor_res`.`V22`,'') AS V22\n,IFNULL( `cronicos_comfacor_res`.`V23`,'') AS V23\n,IFNULL( `cronicos_comfacor_res`.`V24`,'') AS V24\n,IFNULL( `cronicos_comfacor_res`.`V25`,'') AS V25\n,IFNULL( `cronicos_comfacor_res`.`V26`,'') AS V26\n,IFNULL( `cronicos_comfacor_res`.`V27`,'') AS V27\n,IFNULL( `cronicos_comfacor_res`.`V28`,'') AS V28\n,IFNULL( `cronicos_comfacor_res`.`V29`,'') AS V29\n,IFNULL( `cronicos_comfacor_res`.`V30`,'') AS V30\n,IFNULL( `cronicos_comfacor_res`.`V31`,'') AS V31\n,IFNULL( `cronicos_comfacor_res`.`V32`,'') AS V32\n,IFNULL( `cronicos_comfacor_res`.`V33`,'') AS V33\n,IFNULL( `cronicos_comfacor_res`.`V34`,'') AS V34\n,IFNULL( `cronicos_comfacor_res`.`V35`,'') AS V35\n,IFNULL( `cronicos_comfacor_res`.`V36`,'') AS V36\n,IFNULL( `cronicos_comfacor_res`.`V37`,'') AS V37\n,IFNULL( `cronicos_comfacor_res`.`V38`,'') AS V38\n,IFNULL( `cronicos_comfacor_res`.`V39`,'') AS V39\n,IFNULL( `cronicos_comfacor_res`.`V40`,'') AS V40\n,IFNULL( `cronicos_comfacor_res`.`V41`,'') AS V41\n,IFNULL( `cronicos_comfacor_res`.`V42`,'') AS V42\n,IFNULL( `cronicos_comfacor_res`.`V43`,'') AS V43\n,IFNULL( `cronicos_comfacor_res`.`V44`,'') AS V44\n,IFNULL( `cronicos_comfacor_res`.`V45`,'') AS V45\n,IFNULL( `cronicos_comfacor_res`.`V46`,'') AS V46\n,IFNULL( `cronicos_comfacor_res`.`V47`,'') AS V47\n,IFNULL( `cronicos_comfacor_res`.`V48`,'') AS V48\n,IFNULL( `cronicos_comfacor_res`.`V49`,'') AS V49\n,IFNULL( `cronicos_comfacor_res`.`V50`,'') AS V50\n,IFNULL( `cronicos_comfacor_res`.`V51`,'') AS V51\n,IFNULL( `cronicos_comfacor_res`.`V52`,'') AS V52\n,IFNULL( `cronicos_comfacor_res`.`V53`,'') AS V53\n,IFNULL( `cronicos_comfacor_res`.`V54`,'') AS V54\n,IFNULL( `cronicos_comfacor_res`.`V55`,'') AS V55\n,IFNULL( `cronicos_comfacor_res`.`V56`,'') AS V56\n,IFNULL( `cronicos_comfacor_res`.`V57`,'') AS V57\n,IFNULL( `cronicos_comfacor_res`.`V58`,'') AS V58\n,IFNULL( `cronicos_comfacor_res`.`V59`,'') AS V59\n,IFNULL( `cronicos_comfacor_res`.`V60`,'') AS V60\n,IFNULL( `cronicos_comfacor_res`.`V61`,'') AS V61\n,IFNULL( `cronicos_comfacor_res`.`V62`,'') AS V62\n,IFNULL( `cronicos_comfacor_res`.`V63`,'') AS V63\n,IFNULL( `cronicos_comfacor_res`.`V64`,'') AS V64\n,IFNULL( `cronicos_comfacor_res`.`V65`,'') AS V65\n,IFNULL( `cronicos_comfacor_res`.`V66`,'') AS V66\n,IFNULL( `cronicos_comfacor_res`.`V67`,'') AS V67\n,IFNULL( `cronicos_comfacor_res`.`V68`,'') AS V68\n,IFNULL( `cronicos_comfacor_res`.`V69`,'') AS V69\n,IFNULL( `cronicos_comfacor_res`.`V70`,'') AS V70\n,IFNULL( `cronicos_comfacor_res`.`V71`,'') AS V71\n,IFNULL( `cronicos_comfacor_res`.`V72`,'') AS V72\n,IFNULL( `cronicos_comfacor_res`.`V73`,'') AS V73\n,IFNULL( `cronicos_comfacor_res`.`V74`,'') AS V74\n,IFNULL( `cronicos_comfacor_res`.`V75`,'') AS V75\n,IFNULL( `cronicos_comfacor_res`.`V76`,'') AS V76\n,IFNULL( `cronicos_comfacor_res`.`V77`,'') AS V77\n,IFNULL( `cronicos_comfacor_res`.`V78`,'') AS V78\n,IFNULL( `cronicos_comfacor_res`.`V79`,'') AS V79\n,IFNULL( `cronicos_comfacor_res`.`V80`,'') AS V80\n,IFNULL( `cronicos_comfacor_res`.`V81`,'') AS V81\nFROM\n    `ingreso`\n    INNER JOIN `cronicos_comfacor_res` \n        ON (`ingreso`.`Id` = `cronicos_comfacor_res`.`Id_Ingreso`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `cronicos_comfacor_res`.`Id_persona`)\n    INNER JOIN `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)");
        List<Object[]> list = this.jdbcTemplate.query("SELECT\n    `g_ips`.`Id_TipoIdentificacion`\n    , CONCAT(`g_ips`.`Identificacion`,'-', `g_ips`.`DigitoVerificacion`) NIT\n    , `g_ips`.`Nbre`\n    , `g_ips`.`CodigoOrganismo`\n    , `h_atencion`.`Fecha_Atencion`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    , `g_persona`.`Apellido1`\n    , `g_persona`.`Apellido2`\n    , `g_persona`.`Nombre1`\n    , `g_persona`.`Nombre2`\n    , `g_persona`.`Id_Sexo`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Movil`\n    , `cronicos_comfacor_res`.`Dm`\n    , IFNULL(`cronicos_comfacor_res`.`Hta`,'') AS Hta\n    , IFNULL(`cronicos_comfacor_res`.`V3`,'') AS V3\n    ,IFNULL( `cronicos_comfacor_res`.`V6`,'') AS V6\n,IFNULL( `cronicos_comfacor_res`.`V7`,'') AS V7\n,IFNULL( `cronicos_comfacor_res`.`V8`,'') AS V8\n,IFNULL( `cronicos_comfacor_res`.`V9`,'') AS V9\n,IFNULL( `cronicos_comfacor_res`.`V10`,'') AS V10\n,IFNULL( `cronicos_comfacor_res`.`V11`,'') AS V11\n,IFNULL( `cronicos_comfacor_res`.`V12`,'') AS V12\n,IFNULL( `cronicos_comfacor_res`.`V13`,'') AS V13\n,IFNULL( `cronicos_comfacor_res`.`V14`,'') AS V14\n,IFNULL( `cronicos_comfacor_res`.`V15`,'') AS V15\n,IFNULL( `cronicos_comfacor_res`.`V16`,'') AS V16\n,IFNULL( `cronicos_comfacor_res`.`V17`,'') AS V17\n,IFNULL( `cronicos_comfacor_res`.`V18`,'') AS V18\n,IFNULL( `cronicos_comfacor_res`.`V19`,'') AS V19\n,IFNULL( `cronicos_comfacor_res`.`V20`,'') AS V20\n,IFNULL( `cronicos_comfacor_res`.`V21`,'') AS V21\n,IFNULL( `cronicos_comfacor_res`.`V22`,'') AS V22\n,IFNULL( `cronicos_comfacor_res`.`V23`,'') AS V23\n,IFNULL( `cronicos_comfacor_res`.`V24`,'') AS V24\n,IFNULL( `cronicos_comfacor_res`.`V25`,'') AS V25\n,IFNULL( `cronicos_comfacor_res`.`V26`,'') AS V26\n,IFNULL( `cronicos_comfacor_res`.`V27`,'') AS V27\n,IFNULL( `cronicos_comfacor_res`.`V28`,'') AS V28\n,IFNULL( `cronicos_comfacor_res`.`V29`,'') AS V29\n,IFNULL( `cronicos_comfacor_res`.`V30`,'') AS V30\n,IFNULL( `cronicos_comfacor_res`.`V31`,'') AS V31\n,IFNULL( `cronicos_comfacor_res`.`V32`,'') AS V32\n,IFNULL( `cronicos_comfacor_res`.`V33`,'') AS V33\n,IFNULL( `cronicos_comfacor_res`.`V34`,'') AS V34\n,IFNULL( `cronicos_comfacor_res`.`V35`,'') AS V35\n,IFNULL( `cronicos_comfacor_res`.`V36`,'') AS V36\n,IFNULL( `cronicos_comfacor_res`.`V37`,'') AS V37\n,IFNULL( `cronicos_comfacor_res`.`V38`,'') AS V38\n,IFNULL( `cronicos_comfacor_res`.`V39`,'') AS V39\n,IFNULL( `cronicos_comfacor_res`.`V40`,'') AS V40\n,IFNULL( `cronicos_comfacor_res`.`V41`,'') AS V41\n,IFNULL( `cronicos_comfacor_res`.`V42`,'') AS V42\n,IFNULL( `cronicos_comfacor_res`.`V43`,'') AS V43\n,IFNULL( `cronicos_comfacor_res`.`V44`,'') AS V44\n,IFNULL( `cronicos_comfacor_res`.`V45`,'') AS V45\n,IFNULL( `cronicos_comfacor_res`.`V46`,'') AS V46\n,IFNULL( `cronicos_comfacor_res`.`V47`,'') AS V47\n,IFNULL( `cronicos_comfacor_res`.`V48`,'') AS V48\n,IFNULL( `cronicos_comfacor_res`.`V49`,'') AS V49\n,IFNULL( `cronicos_comfacor_res`.`V50`,'') AS V50\n,IFNULL( `cronicos_comfacor_res`.`V51`,'') AS V51\n,IFNULL( `cronicos_comfacor_res`.`V52`,'') AS V52\n,IFNULL( `cronicos_comfacor_res`.`V53`,'') AS V53\n,IFNULL( `cronicos_comfacor_res`.`V54`,'') AS V54\n,IFNULL( `cronicos_comfacor_res`.`V55`,'') AS V55\n,IFNULL( `cronicos_comfacor_res`.`V56`,'') AS V56\n,IFNULL( `cronicos_comfacor_res`.`V57`,'') AS V57\n,IFNULL( `cronicos_comfacor_res`.`V58`,'') AS V58\n,IFNULL( `cronicos_comfacor_res`.`V59`,'') AS V59\n,IFNULL( `cronicos_comfacor_res`.`V60`,'') AS V60\n,IFNULL( `cronicos_comfacor_res`.`V61`,'') AS V61\n,IFNULL( `cronicos_comfacor_res`.`V62`,'') AS V62\n,IFNULL( `cronicos_comfacor_res`.`V63`,'') AS V63\n,IFNULL( `cronicos_comfacor_res`.`V64`,'') AS V64\n,IFNULL( `cronicos_comfacor_res`.`V65`,'') AS V65\n,IFNULL( `cronicos_comfacor_res`.`V66`,'') AS V66\n,IFNULL( `cronicos_comfacor_res`.`V67`,'') AS V67\n,IFNULL( `cronicos_comfacor_res`.`V68`,'') AS V68\n,IFNULL( `cronicos_comfacor_res`.`V69`,'') AS V69\n,IFNULL( `cronicos_comfacor_res`.`V70`,'') AS V70\n,IFNULL( `cronicos_comfacor_res`.`V71`,'') AS V71\n,IFNULL( `cronicos_comfacor_res`.`V72`,'') AS V72\n,IFNULL( `cronicos_comfacor_res`.`V73`,'') AS V73\n,IFNULL( `cronicos_comfacor_res`.`V74`,'') AS V74\n,IFNULL( `cronicos_comfacor_res`.`V75`,'') AS V75\n,IFNULL( `cronicos_comfacor_res`.`V76`,'') AS V76\n,IFNULL( `cronicos_comfacor_res`.`V77`,'') AS V77\n,IFNULL( `cronicos_comfacor_res`.`V78`,'') AS V78\n,IFNULL( `cronicos_comfacor_res`.`V79`,'') AS V79\n,IFNULL( `cronicos_comfacor_res`.`V80`,'') AS V80\n,IFNULL( `cronicos_comfacor_res`.`V81`,'') AS V81\nFROM\n    `ingreso`\n    INNER JOIN `cronicos_comfacor_res` \n        ON (`ingreso`.`Id` = `cronicos_comfacor_res`.`Id_Ingreso`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `cronicos_comfacor_res`.`Id_persona`)\n    INNER JOIN `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)", mapper);
        return list;
    }
}
