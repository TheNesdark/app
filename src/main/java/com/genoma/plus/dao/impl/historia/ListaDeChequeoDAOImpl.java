package com.genoma.plus.dao.impl.historia;

import com.genoma.plus.dao.historia.ListaDeChequeoDAO;
import com.genoma.plus.dto.historia.ListaDeChequeoDTO;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/historia/ListaDeChequeoDAOImpl.class */
public class ListaDeChequeoDAOImpl implements ListaDeChequeoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.historia.ListaDeChequeoDAO
    public List<Object[]> obtenerListaDeChequeo(int idAtencion, String nombre, String tipoHistoria) {
        String sql = "SELECT\n                       `h_configuracion_items`.`id` AS Id\n                       , `h_configuracion_items`.`nombre` AS Nbre\n                       ,IFNULL(d.aplica,0) AS aplica\n                       , IFNULL(d.observacion, ifnull(`h_configuracion_items`.`valorPorDefecto`,'')) Detalle\n                       , IFNULL(d.Id, 0) IdTabla                       , ifnull(`h_configuracion_items`.`valorPorDefecto`,'') AS VDefecto\n                       \n                        FROM\n                        `h_configuracion_items` \n                       INNER JOIN  `h_configuracion_items_tipohistoria`\n                           ON (`h_configuracion_items_tipohistoria`.`idConfiguracion` = `h_configuracion_items`.`idPadre`)\n                       INNER JOIN  `h_configuracion_items` AS `h_configuracion_items_1` \n                           ON (`h_configuracion_items_1`.`id` = `h_configuracion_items`.`idPadre`)\n                           LEFT JOIN (SELECT\n                          `nombre`\n                       , IFNULL(`observacion`,'') observacion, Id, aplica\n                        FROM\n                        `h_lista_de_chequeo`\n                       WHERE (`Estado` =1\n                       AND `Id_Atencion` = " + idAtencion + "))d ON (d.nombre=`h_configuracion_items`.`nombre`)\n                       WHERE (`h_configuracion_items_tipohistoria`.`idTipoHistoria` ='" + tipoHistoria + "'\n                       AND `h_configuracion_items_1`.`nombre` ='" + nombre + "'\n                       AND `h_configuracion_items_tipohistoria`.`Estado` =1)\n                    ORDER BY `h_configuracion_items_tipohistoria`.`orden` ASC";
        System.out.println(" sql " + sql);
        RowMapper mapper = (rs, rowNum) -> {
            Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), Boolean.valueOf(rs.getBoolean(3)), rs.getString(4), Integer.valueOf(rs.getInt(5)), rs.getString(6)};
            return fila;
        };
        List<Object[]> listaDeChequeo = this.jdbcTemplate.query(sql, mapper);
        return listaDeChequeo;
    }

    @Override // com.genoma.plus.dao.historia.ListaDeChequeoDAO
    public List<Object[]> obtenerListaDeChequeoH(int idAtencion, String nombre, String tipoHistoria, String idUsuario) {
        String sql = "SELECT d.Fecha_Atencion,\n  h_configuracion_items.nombre AS Nbre,\n  IFNULL(d.aplica, 0) AS aplica,\n  IFNULL(d.observacion,IFNULL(h_configuracion_items.valorPorDefecto,'')) AS Detalle\nFROM h_configuracion_items\n  INNER JOIN h_configuracion_items_tipohistoria ON (h_configuracion_items_tipohistoria.idConfiguracion = h_configuracion_items.idPadre)\n  INNER JOIN h_configuracion_items AS h_configuracion_items_1 ON (h_configuracion_items_1.id = h_configuracion_items.idPadre)\n  LEFT JOIN (SELECT h_atencion.Fecha_Atencion,h_lista_de_chequeo.nombre,IFNULL(h_lista_de_chequeo.observacion, '') AS observacion,h_lista_de_chequeo.aplica,ingreso.Id_Usuario\n    FROM h_lista_de_chequeo\n    INNER JOIN h_atencion ON (h_atencion.Id = h_lista_de_chequeo.id_atencion)\n    INNER JOIN ingreso ON (ingreso.Id = h_atencion.Id_Ingreso)\n    WHERE (h_lista_de_chequeo.Estado = 1 AND h_lista_de_chequeo.Id_Atencion <= '" + idAtencion + "'   AND ingreso.Id_Usuario = '" + idUsuario + "')) d ON (d.nombre = h_configuracion_items.nombre)\nWHERE (h_configuracion_items_tipohistoria.idTipoHistoria = '" + tipoHistoria + "'\n    AND h_configuracion_items_1.nombre = '" + nombre + "'\n    AND h_configuracion_items_tipohistoria.Estado = 1\n  ) ORDER BY d.Fecha_Atencion DESC,h_configuracion_items_tipohistoria.orden ASC";
        System.out.println(" sql " + sql);
        RowMapper mapper = (rs, rowNum) -> {
            Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
            return fila;
        };
        List<Object[]> listaDeChequeo = this.jdbcTemplate.query(sql, mapper);
        return listaDeChequeo;
    }

    @Override // com.genoma.plus.dao.historia.ListaDeChequeoDAO
    public void crearLista(ListaDeChequeoDTO listaDeChequeoDTO) {
        this.jdbcTemplate.update("INSERT INTO `h_lista_de_chequeo` (`id_atencion`,`id_lista`,`nombre`,`aplica`,`observacion`,`estado`)\n           VALUES(?,?,?,?,?,?);", new Object[]{Integer.valueOf(listaDeChequeoDTO.getIdAtencion()), Integer.valueOf(listaDeChequeoDTO.getIdLista()), listaDeChequeoDTO.getNombre(), Boolean.valueOf(listaDeChequeoDTO.isAplica()), listaDeChequeoDTO.getObservacion(), Boolean.valueOf(listaDeChequeoDTO.isEstado())});
    }

    @Override // com.genoma.plus.dao.historia.ListaDeChequeoDAO
    public void updateLista(ListaDeChequeoDTO listaDeChequeoDTO) {
        this.jdbcTemplate.update("UPDATE `h_lista_de_chequeo` SET \n `id_atencion`=?\n,`id_lista`=?\n,`nombre`=?\n,`aplica`=?\n,`observacion`=?\n,`estado`=?\nWHERE(`Id`=?);", new Object[]{Integer.valueOf(listaDeChequeoDTO.getIdAtencion()), Integer.valueOf(listaDeChequeoDTO.getIdLista()), listaDeChequeoDTO.getNombre(), Boolean.valueOf(listaDeChequeoDTO.isAplica()), listaDeChequeoDTO.getObservacion(), Boolean.valueOf(listaDeChequeoDTO.isEstado()), Integer.valueOf(listaDeChequeoDTO.getId())});
    }
}
