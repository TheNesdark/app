package com.genoma.plus.dao.impl.facturacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO;
import com.genoma.plus.dto.facturacion.ItemsRipsNacimientosDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/LiquidacionCirugiaDAOImpl.class */
public class LiquidacionCirugiaDAOImpl implements LiquidacionCirugiaDAO {
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO
    public List<Object[]> listadoCirugiaHistoria(String idAtencion) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.LiquidacionCirugiaDAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Fecha_Inicial"), rs.getString("Hora_Inicla"), rs.getString("Hora_Final"), rs.getString("NTipoAnestesia"), rs.getString("NProcedimiento"), Long.valueOf(rs.getLong("IdOrdenF")), rs.getString("NServicio")};
                return fila;
            }
        };
        String xSql = "SELECT `h_orden_qx`.`Id`,\n    `h_orden_qx`.`Fecha_Inicial`\n    , `h_orden_qx`.`Hora_Inicla`\n    , `h_orden_qx`.`Hora_Final`\n    , `f_tipoanestesia`.`Nbre` NTipoAnestesia\n    , `g_procedimiento`.`Nbre` NProcedimiento\n    , `h_orden_qx`.`IdOrdenF`   \n    , `f_tiposervicio`.`Nbre` NServicio\nFROM\n     `h_orden_qx`\n    INNER JOIN  `h_atencion` \n        ON (`h_orden_qx`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `f_tipoanestesia` \n        ON (`h_orden_qx`.`Id_Tipo_Anestesia` = `f_tipoanestesia`.`Id`)\n    INNER JOIN  `h_orden_qx_integrantes` \n        ON (`h_orden_qx_integrantes`.`Id_OrdenQx` = `h_orden_qx`.`Id`)\n    INNER JOIN  `h_orden_qx_procedimientos` \n        ON (`h_orden_qx_procedimientos`.`Id_Orden_Qx` = `h_orden_qx`.`Id`)\n    INNER JOIN  `g_procedimiento` \n        ON (`h_orden_qx_procedimientos`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `h_orden_qx_integrantes`.`Id_Persona`)\n    INNER JOIN  `f_tipoprocedimiento` \n        ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\n    INNER JOIN  `f_tiposervtipoproced` \n        ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\n    INNER JOIN  `f_tiposervicio` \n        ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`)\nWHERE (`h_orden_qx`.`Id_Atencion` ='" + idAtencion + "'\n  )\nGROUP BY `h_orden_qx`.`Id`;";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO
    public List<Object[]> listadoIntegrantesCirugiaHistoria(String idOrdenCx) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.LiquidacionCirugiaDAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("NProfesional"), rs.getString("NEspecialidad")};
                return fila;
            }
        };
        String xSql = "SELECT\n    CONCAT(`g_persona`.`Apellido1` ,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`)  AS `NProfesional`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\nFROM\n     `h_orden_qx_integrantes`\n    INNER JOIN  `h_orden_qx` \n        ON (`h_orden_qx_integrantes`.`Id_OrdenQx` = `h_orden_qx`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_orden_qx_integrantes`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `h_orden_qx_integrantes`.`Id_Persona`)\nWHERE (`h_orden_qx`.`Id` ='" + idOrdenCx + "')\nORDER BY `h_orden_qx_integrantes`.`Orden` ASC";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO
    public List<Object[]> listadoDiagnosticoCirugiaHistoria(String idOrdenCx) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.LiquidacionCirugiaDAOImpl.3
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Id"), rs.getString("Nbre"), Integer.valueOf(rs.getInt("Tipo"))};
                return fila;
            }
        };
        String xSql = "SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\n    , `h_orden_qx_diagnostico`.`Tipo`\nFROM\n     `h_orden_qx_diagnostico`\n    INNER JOIN  `g_patologia` \n        ON (`h_orden_qx_diagnostico`.`Id_Patologia` = `g_patologia`.`Id`)\nWHERE (`h_orden_qx_diagnostico`.`Id_Orden_Qx` ='" + idOrdenCx + "')\nORDER BY `h_orden_qx_diagnostico`.`Orden` ASC";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO
    public List<Object[]> listadoProcedimientosdeCirugiaHistoria(String idOrdenCx) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.LiquidacionCirugiaDAOImpl.4
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("Id"), rs.getString("NProcedimiento"), rs.getString("NEspecialidad"), Boolean.valueOf(rs.getBoolean("Bilateral")), Boolean.valueOf(rs.getBoolean("Via")), Boolean.valueOf(rs.getBoolean("Contaminado")), Integer.valueOf(rs.getInt("Orden")), rs.getString("NProfesional")};
                return fila;
            }
        };
        String xSql = "SELECT\n    `g_procedimiento`.`Id`\n    , `g_procedimiento`.`Nbre` AS `NProcedimiento`\n    , `g_especialidad`.`Nbre` AS `NEspecialidad`\n    , CONCAT(`g_persona`.`Apellido1` ,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NProfesional`\n    , `h_orden_qx_procedimientos`.`Bilateral`\n    , `h_orden_qx_procedimientos`.`Via`\n    , `h_orden_qx_procedimientos`.`Contaminado`\n    , `h_orden_qx_procedimientos`.`Orden`\nFROM\n     `h_orden_qx_procedimientos`\n    INNER JOIN  `g_procedimiento` \n        ON (`h_orden_qx_procedimientos`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN  `g_especialidad` \n        ON (`h_orden_qx_procedimientos`.`Id_Especialidad` = `g_especialidad`.`Id`)\n    INNER JOIN  `g_persona` \n        ON (`g_persona`.`Id` = `h_orden_qx_procedimientos`.`Id_Profesional`)\nWHERE (`h_orden_qx_procedimientos`.`Id_Orden_Qx` ='" + idOrdenCx + "')";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO
    public List<Object[]> listadoNacimientosCirugiaHistoria(String idOrdenCx) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.LiquidacionCirugiaDAOImpl.5
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {rs.getString("FechaNac"), rs.getString("Hora"), rs.getString("EstadoR"), Boolean.valueOf(rs.getBoolean("CPrenatal")), Integer.valueOf(rs.getInt("SGestacion")), rs.getString("Sexo"), Long.valueOf(rs.getLong("Peso")), Double.valueOf(rs.getDouble("Talla")), Integer.valueOf(rs.getInt("NHijos")), rs.getString("DX"), rs.getString("NPatologia"), rs.getString("IdDxMuerte"), rs.getString("NbreDxMuerte"), rs.getString("FechaMuerte"), rs.getString("HoraMuerte"), rs.getString("Apgar"), rs.getString("TipoParto")};
                return fila;
            }
        };
        String xSql = "SELECT\n    `h_orden_qx_nacidos`.`IdOrdenQx`\n    , `h_orden_qx_nacido_detalle`.`FechaNac`\n    , `h_orden_qx_nacido_detalle`.`Hora`\n    , `h_orden_qx_nacido_detalle`.`EstadoR`\n    , TRUE AS `CPrenatal`\n    , `h_orden_qx_nacidos`.`SGestacion`\n    , `h_orden_qx_nacido_detalle`.`Sexo`\n    , `h_orden_qx_nacido_detalle`.`Peso`\n    , `h_orden_qx_nacido_detalle`.`Talla`\n    , 1 AS `NHijos`\n    , `h_orden_qx_nacido_detalle`.`Apgar`\n    ,  IF(`h_orden_qx_nacidos`.`Cesarea`=0, 'Parto espontane', 'Parto por cesarea') TipoParto\n    , `h_orden_qx_nacido_detalle`.`DX`\n    , `g_patologia`.`Nbre` AS `NPatologia`\n    , IFNULL(`g_patologia_1`.`Id`, '')  AS `IdDxMuerte`\n    , IFNULL(`g_patologia_1`.`Nbre`, '') AS `NbreDxMuerte`\n    , `h_orden_qx_nacido_detalle`.`FechaMuerte`\n    , `h_orden_qx_nacido_detalle`.`HoraMuerte`\nFROM\n     `h_orden_qx_nacido_detalle`\n    INNER JOIN  `h_orden_qx_nacidos` \n        ON (`h_orden_qx_nacido_detalle`.`IdEncabezado` = `h_orden_qx_nacidos`.`Id`)\n    INNER JOIN  `g_patologia` \n        ON (`g_patologia`.`Id` = `h_orden_qx_nacido_detalle`.`DX`)\n    LEFT JOIN  `g_patologia` AS `g_patologia_1` \n        ON (`g_patologia_1`.`Id` = `h_orden_qx_nacido_detalle`.`DXMuerte`)\nWHERE (`h_orden_qx_nacidos`.`IdOrdenQx` ='" + idOrdenCx + "');";
        System.out.println("xsql-->" + xSql);
        List<Object[]> list = this.jdbcTemplate.query(xSql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO
    public void mCreateItemsRipsNacimiento(ItemsRipsNacimientosDTO e) {
        this.jdbcTemplate.update("INSERT INTO `f_itemripsnacido`(Id_Orden, idIngreso, NoHijo , Id_TipoParto , CPrenatal , EdadG , FechaN , HoraN , Id_Sexo , Peso , Talla , Apgar , DxN , DxM , EstadoN , FechaM , HoraM , Fecha , UsuarioS, numeroControles, idDestino)\nVALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[]{e.getIdOrdenQx(), e.getIdIngreso(), Integer.valueOf(e.getNHijo()), Integer.valueOf(e.getIdTipoParto()), Boolean.valueOf(e.isCPrenatal()), Integer.valueOf(e.getEdadGestacional()), e.getFechaNacimiento(), e.getHoraNacimiento(), e.getIdSexo(), Double.valueOf(e.getPeso()), Double.valueOf(e.getTalla()), Integer.valueOf(e.getApgar()), e.getDiagnosticoNacido(), e.getDiagnosticoMuerteN(), Integer.valueOf(e.getEstadoNacido()), e.getFechaMuerte(), e.getHoraMuere(), this.xmt.getFechaActual(), Principal.usuarioSistemaDTO.getIdPersonaCargo(), e.getNumeroControles(), e.getIdDestino()});
    }

    @Override // com.genoma.plus.dao.facturacion.LiquidacionCirugiaDAO
    public void mActualizarIdOrdenQxHistoria(String idOrdenFacturacion, String idOrdenQxHistoria) {
        this.jdbcTemplate.update("UPDATE h_orden_qx SET IdOrdenF=? WHERE Id=?", new Object[]{idOrdenFacturacion, idOrdenQxHistoria});
    }
}
