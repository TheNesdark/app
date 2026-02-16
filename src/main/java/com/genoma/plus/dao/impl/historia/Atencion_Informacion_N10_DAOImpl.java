package com.genoma.plus.dao.impl.historia;

import Utilidades.Metodos;
import com.genoma.plus.dao.historia.Atencion_Informacion_N10DAO;
import com.genoma.plus.dto.historia.Atencion_Informacion_n10DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/Atencion_Informacion_N10_DAOImpl.class */
public class Atencion_Informacion_N10_DAOImpl implements Atencion_Informacion_N10DAO {
    Atencion_Informacion_n10DTO e;
    private JdbcTemplate jdbcTemplate;
    private Metodos xmt = new Metodos();

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.Atencion_Informacion_N10DAO
    public void mCreate(Atencion_Informacion_n10DTO e) {
        this.jdbcTemplate.update("INSERT INTO `h_atencion_informacion_n10` (`Id_Atencion`, `IdItems`, `nombre`, `Detalle`, `Estado`, `Fecha`, `Id_UsuarioS`) VALUES (?,?,?,?,?,?,?)", new Object[]{e.getIdAtencion(), e.getIdItems(), e.getNombre(), e.getDetalle(), Boolean.valueOf(e.isEstado()), e.getFecha(), e.getId_UsuarioS()});
    }

    @Override // com.genoma.plus.dao.historia.Atencion_Informacion_N10DAO
    public List<Object[]> listAtencionFiltradaNombreItems(Long idAtencion, String nombeItems, String idTipoHc, Integer formaHistoria, String sexo, String fechaAtencion, String fechaNacimiento) {
        String xsql;
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.Atencion_Informacion_N10_DAOImpl.1
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Nbre"), rs.getString("Detalle"), Long.valueOf(rs.getLong("IdTabla")), rs.getString("VDefecto")};
                return fila;
            }
        };
        if (formaHistoria.intValue() == 0) {
            this.e = new Atencion_Informacion_n10DTO();
            xsql = "SELECT\n    `h_cniveluno`.`Id`\n    , `h_cniveluno`.`Nbre`, IFNULL(d.Detalle, `h_cniveluno`.`VDefecto`) Detalle\n    , IFNULL(d.Id, 0) IdTabla, `h_cniveluno`.`VDefecto`\nFROM\n    `h_cniveluno`\n    INNER JOIN `h_chistoria` \n        ON (`h_cniveluno`.`id_chistoria` = `h_chistoria`.`Id`)\n    INNER JOIN `h_ctipohcxdhistoria` \n        ON (`h_ctipohcxdhistoria`.`Id_CHhistoria` = `h_chistoria`.`Id`)\n        LEFT JOIN (SELECT\n    `Id_CnivelUno`\n    , `Detalle`, Id\nFROM\n    `h_atencion_informacion_n10`\nWHERE (`Estado` =1\n    AND `Id_Atencion` = " + idAtencion + "))d ON (d.Id_CnivelUno=`h_cniveluno`.`Id`)\nWHERE (`h_ctipohcxdhistoria`.`Id_TipoHistoria` = " + idTipoHc + "\n    AND `h_chistoria`.`Nbre` = '" + nombeItems + "'\n    AND `h_cniveluno`.`Estado` =1    AND `h_configuracion_items`.`idSexo` IN('A','" + sexo + "')\n    AND (DATEDIFF('" + fechaAtencion + "', '" + fechaNacimiento + "')>=`h_configuracion_items`.`edadDiasInicio` \n    AND  DATEDIFF('" + fechaAtencion + "', '" + fechaNacimiento + "')<=`h_configuracion_items`.`edadDiasFin`)\n)\nORDER BY `h_cniveluno`.`Orden` ASC; ";
        } else {
            xsql = "WITH setDatos AS(\nSELECT\n     `h_configuracion_items`.`id` AS IdItemsSetdatos\n     , h_atencion_informacion_n10.`Id`\n     , h_atencion_informacion_n10.`Id_Atencion`\n     , `h_configuracion_items`.`nombre` AS Nbre\n     , `h_configuracion_items`.`valorPorDefecto` Detalle\n     , `h_configuracion_items`.`valorPorDefecto` AS VDefecto\nFROM\n     h_configuracion_items\n     INNER JOIN  `h_configuracion_items_tipohistoria`\n         ON (`h_configuracion_items_tipohistoria`.`idConfiguracion` = `h_configuracion_items`.`idPadre`)\n     LEFT JOIN h_atencion_informacion_n10\n         ON (h_atencion_informacion_n10.`IdItems` = h_configuracion_items.`id`)\n     INNER JOIN  `h_configuracion_items` AS `h_configuracion_items_1`\n         ON (`h_configuracion_items_1`.`id` = `h_configuracion_items`.`idPadre`)\n     WHERE (`h_configuracion_items_tipohistoria`.`idTipoHistoria` = " + idTipoHc + "\n         AND `h_configuracion_items_1`.`nombre` = '" + nombeItems + "'\n         AND `h_configuracion_items_tipohistoria`.`Estado` =1\n         AND `h_configuracion_items`.`idSexo` IN('A','" + sexo + "')\n         AND (DATEDIFF('" + fechaAtencion + "', '" + fechaNacimiento + "')>=`h_configuracion_items`.`edadDiasInicio`\n         AND  DATEDIFF('" + fechaAtencion + "', '" + fechaNacimiento + "')<=`h_configuracion_items`.`edadDiasFin`))\n GROUP BY  `h_configuracion_items`.`id`\n ORDER BY `h_configuracion_items_tipohistoria`.`orden` ASC\n)\n, setRespuesta AS (\n SELECT\n    `nombre`\n    , `Detalle`, Id idConfiAtencion , IdItems\n FROM\n     `h_atencion_informacion_n10`\n WHERE (`Estado` =1 AND `Id_Atencion` = " + idAtencion + ")\n)\n SELECT\n setDatos.IdItemsSetdatos AS Id\n , `setDatos`.Nbre\n , IFNULL(setRespuesta.Detalle,setDatos.Detalle) Detalle\n , IFNULL(setRespuesta.idConfiAtencion,0) IdTabla\n , setDatos.VDefecto\n FROM setDatos\nLEFT JOIN setRespuesta ON setRespuesta.IdItems=setDatos.IdItemsSetdatos;";
        }
        System.out.println("" + xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }

    @Override // com.genoma.plus.dao.historia.Atencion_Informacion_N10DAO
    public void mUpdate(Atencion_Informacion_n10DTO e) {
        this.jdbcTemplate.update("UPDATE `h_atencion_informacion_n10` SET `Detalle` = ?, Fecha=? WHERE `Id` = ? ;", new Object[]{e.getDetalle(), e.getFecha(), e.getId()});
    }

    @Override // com.genoma.plus.dao.historia.Atencion_Informacion_N10DAO
    public List<Object[]> listHistoricoAtenciones(Long idAtencion, String nombeItems, Long idUsuarioAtendido) {
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.historia.Atencion_Informacion_N10_DAOImpl.2
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Object[] fila = {Long.valueOf(rs.getLong("Id")), rs.getString("Fecha_Atencion"), rs.getString("nombre"), rs.getString("Detalle"), rs.getString("nombreEspecialidad"), rs.getString("nombreProfesional")};
                return fila;
            }
        };
        String xsql = "SELECT \n  h_atencion.Id,\n  h_atencion.Fecha_Atencion,\n  h_atencion_informacion_n10.nombre,\n  h_atencion_informacion_n10.Detalle,\n  g_especialidad.Nbre AS nombreEspecialidad,\n  CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS nombreProfesional\nFROM\n  h_atencion_informacion_n10\n  INNER JOIN h_configuracion_items ON (h_configuracion_items.id = h_atencion_informacion_n10.IdItems)\n  INNER JOIN h_configuracion_items idPadre ON (h_configuracion_items.idPadre = idPadre.id)\n  INNER JOIN h_atencion ON (h_atencion_informacion_n10.Id_Atencion = h_atencion.Id)\n  INNER JOIN g_especialidad ON (g_especialidad.Id = h_atencion.Id_Especialidad)\n  INNER JOIN g_profesional ON (g_profesional.Id_Persona = h_atencion.Id_Profesional)\n  INNER JOIN g_persona ON (g_persona.Id = g_profesional.Id_Persona    )\n  INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso)\nWHERE (\n    h_atencion_informacion_n10.Id_Atencion <= " + idAtencion + "\n    AND idPadre.nombre = '" + nombeItems + "'\n    AND h_atencion_informacion_n10.Estado = 1\n    AND ingreso.Id_Usuario = " + idUsuarioAtendido + "\n  ) ORDER BY h_atencion.Fecha_Atencion DESC";
        System.out.println(xsql);
        List<Object[]> list = this.jdbcTemplate.query(xsql, mapper);
        return list;
    }
}
