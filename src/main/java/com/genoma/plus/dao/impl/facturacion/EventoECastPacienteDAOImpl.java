package com.genoma.plus.dao.impl.facturacion;

import com.genoma.plus.dao.facturacion.EventoECatPacienteGastoDAO;
import com.genoma.plus.dto.facturacion.EventoECastPacienteGastoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/facturacion/EventoECastPacienteDAOImpl.class */
public class EventoECastPacienteDAOImpl implements EventoECatPacienteGastoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.facturacion.EventoECatPacienteGastoDAO
    public List<Object[]> listaEventoECatPacienteGasto(Long idEvento, Long idUsuario) {
        String sql = "SELECT `id`,`fechaGasto`,`numeroFactura`,`entidadGeneraGasto`,`valorTotalFactura`,`estado`,`soporteFactura` \nFROM `a_eventoecat_paciente_gastos` WHERE (`idEventoEcat` =" + idEvento + " AND `idPersona` =" + idUsuario + " AND `estado` =1) \n";
        RowMapper mapper = (rs, i) -> {
            Object[] fila = {Integer.valueOf(rs.getInt(1)), rs.getString(2), rs.getString(3), rs.getString(4), Double.valueOf(rs.getDouble(5)), Boolean.valueOf(rs.getBoolean(6)), rs.getBytes(7)};
            return fila;
        };
        System.out.println("sql" + sql);
        List<Object[]> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }

    @Override // com.genoma.plus.dao.facturacion.EventoECatPacienteGastoDAO
    public String create(EventoECastPacienteGastoDTO eventoECastPacienteGasto) {
        String resultado = "Se inserto correctamente";
        int ctos = this.jdbcTemplate.update("INSERT INTO `a_eventoecat_paciente_gastos` ( `idEventoEcat` , `idPersona` , `fechaGasto` , `numeroFactura` , `entidadGeneraGasto` , `valorTotalFactura` , `soporteFactura` , `estado` , `idUsuarioRh` ) \n   VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{Integer.valueOf(eventoECastPacienteGasto.getIdEventoEcast()), Long.valueOf(eventoECastPacienteGasto.getIdPersona()), eventoECastPacienteGasto.getFechaGasto(), eventoECastPacienteGasto.getNumeroFactura(), eventoECastPacienteGasto.getEntidadGeneraGasto(), Double.valueOf(eventoECastPacienteGasto.getValorTotalFactura()), eventoECastPacienteGasto.getSoporteFactura(), Boolean.valueOf(eventoECastPacienteGasto.isEstado()), Long.valueOf(eventoECastPacienteGasto.getIdUsario())});
        if (ctos == 0) {
            resultado = "No se pudo insertar";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.facturacion.EventoECatPacienteGastoDAO
    public String updtade(EventoECastPacienteGastoDTO eventoECastPacienteGastoDTO) {
        String resultado = "Se actualizo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE  `a_eventoecat_paciente_gastos` SET (`idEventoEcat`= ?,`idPersona` =?,`fechaGasto`=?,`numeroFactura`=?,`entidadGeneraGasto`=?,`valorTotalFactura`=?, `soporteFactura`=?,`estado`=?,`idUsuarioRh`=?) WHERE(`id`=?);", new Object[]{Integer.valueOf(eventoECastPacienteGastoDTO.getIdEventoEcast()), Long.valueOf(eventoECastPacienteGastoDTO.getIdPersona()), eventoECastPacienteGastoDTO.getFechaGasto(), eventoECastPacienteGastoDTO.getNumeroFactura(), eventoECastPacienteGastoDTO.getEntidadGeneraGasto(), Double.valueOf(eventoECastPacienteGastoDTO.getValorTotalFactura()), eventoECastPacienteGastoDTO.getSoporteFactura(), Boolean.valueOf(eventoECastPacienteGastoDTO.isEstado()), Long.valueOf(eventoECastPacienteGastoDTO.getIdUsario()), Integer.valueOf(eventoECastPacienteGastoDTO.getId())});
        if (ctos == 0) {
            resultado = "No se pudo actualizar";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.facturacion.EventoECatPacienteGastoDAO
    public List<Object[]> obtenerEventoCast(String idIngreso) {
        String sql = "SELECT\n    `a_eventoecat`.`Id`\n    , `a_eventoecat_paciente`.`Id_Ingreso`\nFROM\n    `baseserver`.`a_eventoecat_paciente`\n    INNER JOIN `baseserver`.`a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n        WHERE(`a_eventoecat_paciente`.`Id_Ingreso` =" + idIngreso + ");";
        RowMapper mapper = new RowMapper() { // from class: com.genoma.plus.dao.impl.facturacion.EventoECastPacienteDAOImpl.1
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                Object[] fila = {rs.getString(1), rs.getString(2)};
                return fila;
            }
        };
        List<Object[]> listaEventoCat = this.jdbcTemplate.query(sql, mapper);
        return listaEventoCat;
    }

    @Override // com.genoma.plus.dao.facturacion.EventoECatPacienteGastoDAO
    public String anulacion(Object[] datos) {
        String resultado = "Se anulo correctamente";
        int ctos = this.jdbcTemplate.update("UPDATE `a_eventoecat_paciente_gastos` SET `estado`=0, `idUsuarioAnulacion`=?,`fechaAnulacion`=?,`idMotivoAnulacion`=?,`motivoAnulacion`=? WHERE `id`=?;", new Object[]{datos[0].toString(), datos[1].toString(), datos[2].toString(), datos[3].toString(), datos[4].toString()});
        if (ctos == 0) {
            resultado = "No se pudo Anular";
        }
        return resultado;
    }

    @Override // com.genoma.plus.dao.facturacion.EventoECatPacienteGastoDAO
    public List<Object[]> listaEventoECatPacienteGastoInternos(Long idEvento, Long idUsuario) {
        String sql = "SELECT ingreso.`FechaIngreso`, \n    `f_factura_evento`.`Fecha_FacturaEvento`\n    , `f_factura_evento`.`No_FacturaEvento`\n    , `f_liquidacion`.`TotalEps`, IF(`f_factura_evento`.`EstaArmada`=0,'GENERADA', IF(`f_factura_evento`.`EstaArmada`=1,'ARMADA' , 'PRESENTADA')) estado,  ingreso.`Id` idIngreso\nFROM\n     `f_liquidacion`\n    INNER JOIN  `ingreso` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_factura_evento` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN  `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\nWHERE (`a_eventoecat`.`Id` =" + idEvento + "  AND ingreso.`Id_Usuario`=" + idUsuario + "\n    AND `ingreso`.`Estado` =0 AND f_liquidacion.`Estado`=0)\nORDER BY `f_factura_evento`.`Fecha_FacturaEvento` DESC";
        RowMapper mapper = (rs, i) -> {
            Object[] fila = {rs.getString(1), rs.getString(2), rs.getString(3), Double.valueOf(rs.getDouble(4)), rs.getString(5), Long.valueOf(rs.getLong(6))};
            return fila;
        };
        System.out.println("sql" + sql);
        List<Object[]> lista = this.jdbcTemplate.query(sql, mapper);
        return lista;
    }
}
