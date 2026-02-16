package com.genoma.plus.dao.facturacion;

import com.genoma.plus.dto.facturacion.OrdenAnexo3DTO;
import com.genoma.plus.dto.facturacion.OrdenesAnexo3DetalleDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/facturacion/OrdenAnexo3DAO.class */
public interface OrdenAnexo3DAO {
    List<Object[]> listadoDeAnexos(String str);

    List<Object[]> listadoDeProcedimientosAnexo(String str);

    List<Object[]> listadoDeDatosDeLaAtencion(String str);

    List<OrdenAnexo3DTO> obtieneElConsecutivoDelDia(String str);

    String create_return_id_Anexo3(OrdenAnexo3DTO ordenAnexo3DTO);

    String mcreate(OrdenesAnexo3DetalleDTO ordenesAnexo3DetalleDTO);

    String mUpdateAnexo3(OrdenesAnexo3DetalleDTO ordenesAnexo3DetalleDTO);

    List<Object[]> informacionIngresoAnexo3Res2335(String str);

    List<Object[]> historicoAnexo3Res2335(String str, String str2);
}
