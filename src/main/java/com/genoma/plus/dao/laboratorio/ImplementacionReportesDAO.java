package com.genoma.plus.dao.laboratorio;

import com.genoma.plus.dto.laboratorio.RDetalleExamenesPendientes;
import com.genoma.plus.dto.laboratorio.RDetalleResultadoComentarioProcedimiento;
import com.genoma.plus.dto.laboratorio.RDetalleResultadoDTO;
import com.genoma.plus.dto.laboratorio.RDetalleResultadoHistoricoDTO;
import com.genoma.plus.dto.laboratorio.REncabezadoResultadoDTO;
import com.genoma.plus.dto.parametrizacion.resourceDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/laboratorio/ImplementacionReportesDAO.class */
public interface ImplementacionReportesDAO {
    List<RDetalleResultadoDTO> detalleResultado(String str, String str2);

    List<RDetalleResultadoDTO> detalleResultadoCorreo(String str, String str2);

    REncabezadoResultadoDTO detalleEncabezadoResultado(String str);

    REncabezadoResultadoDTO detalleEncabezadoResultadoCorreo(String str);

    List<RDetalleResultadoHistoricoDTO> detalleHistoricoProtocolo(String str, String str2);

    List<RDetalleResultadoComentarioProcedimiento> detalleComentarioProcedimento(String str, String str2);

    List<RDetalleExamenesPendientes> detallePendientes(String str);

    List<resourceDTO> detalleHistograma(String str, String str2);
}
