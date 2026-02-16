package com.genoma.plus.dao.impl.caja;

import com.genoma.plus.dao.caja.ReciboIngresoDAO;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/caja/ReciboIngresoDAOImpl.class */
public class ReciboIngresoDAOImpl implements ReciboIngresoDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // com.genoma.plus.dao.caja.ReciboIngresoDAO
    public void anularRecibo(String idRecibo, String motivo, String observacion, String usuarioRh) {
        String sql = "update  k_cierre set   `Estado`=0 , `MotivoAnulacion`='" + motivo + "'  , `observacionAnulacion`='" + observacion + "' , `Usuario_Anulacion`='" + usuarioRh + "' , `Fecha_Anulacion`= now() where Id=" + idRecibo + " ";
        this.jdbcTemplate.execute(sql);
    }

    @Override // com.genoma.plus.dao.caja.ReciboIngresoDAO
    public void actualizarDatosReciboCajaIdCierre(String idCierre) {
        String sql = "update  k_recibos set   `Id_cierre`=0 where Id_cierre=" + idCierre + " ";
        this.jdbcTemplate.execute(sql);
    }

    @Override // com.genoma.plus.dao.caja.ReciboIngresoDAO
    public void anularCierreReciboEgreso(String idCierre, String motivo, String observacion, String usuarioRh) {
        String sql = "update  k_cierre_egresos set   `estado`=0 , `Detalle_Anulacion`='" + motivo + "' , `Usuario_Anulacion`='" + usuarioRh + "' , `Fecha_Anulacion`= now() where Id=" + idCierre + " ";
        this.jdbcTemplate.execute(sql);
    }

    @Override // com.genoma.plus.dao.caja.ReciboIngresoDAO
    public void actualizarDatosReciboCajaIdCierreEgreso(String idCierre) {
        String sql = "update  k_recibos_egresos set   `IdCierre`=0 where IdCierre=" + idCierre + " ";
        this.jdbcTemplate.execute(sql);
    }
}
