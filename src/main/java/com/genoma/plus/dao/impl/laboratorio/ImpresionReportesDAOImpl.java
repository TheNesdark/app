package com.genoma.plus.dao.impl.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.laboratorio.ImplementacionReportesDAO;
import com.genoma.plus.dto.laboratorio.RDetalleExamenesPendientes;
import com.genoma.plus.dto.laboratorio.RDetalleResultadoDTO;
import com.genoma.plus.dto.laboratorio.REncabezadoResultadoDTO;
import java.util.List;
import lombok.Generated;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/impl/laboratorio/ImpresionReportesDAOImpl.class */
public class ImpresionReportesDAOImpl {
    private ImplementacionReportesDAO repotesLaboratorio;
    private Metodos metodos = new Metodos();
    private String nombreReporte;

    @Generated
    public void setRepotesLaboratorio(ImplementacionReportesDAO repotesLaboratorio) {
        this.repotesLaboratorio = repotesLaboratorio;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setNombreReporte(String nombreReporte) {
        this.nombreReporte = nombreReporte;
    }

    @Generated
    public ImplementacionReportesDAO getRepotesLaboratorio() {
        return this.repotesLaboratorio;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public String getNombreReporte() {
        return this.nombreReporte;
    }

    public ImpresionReportesDAOImpl() {
        mIniciarSpring();
    }

    private void mIniciarSpring() {
        this.repotesLaboratorio = (ImplementacionReportesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("implementacionReportesDAOImpl");
    }

    public void mImprimirResultado(String idRecepcion, String idProcedimiento, String rutaSubReportes, String rutaFirmas, boolean tipoForma, String idPersona, boolean abrirPDF) {
        REncabezadoResultadoDTO encabezadoReporte = this.repotesLaboratorio.detalleEncabezadoResultado(idRecepcion);
        if (encabezadoReporte != null) {
            List<RDetalleResultadoDTO> listDetalleReporte = this.repotesLaboratorio.detalleResultado(idRecepcion, idProcedimiento);
            encabezadoReporte.setListDetalle(listDetalleReporte);
            encabezadoReporte.setRutaSubReportes(rutaSubReportes);
            List<RDetalleExamenesPendientes> listProcedimientoPendientes = this.repotesLaboratorio.detallePendientes(idRecepcion);
            encabezadoReporte.setListProcedimientoPendientes(listProcedimientoPendientes);
            String SubReportFirma = this.metodos.mRutaSoporte("SUBREPORTFIRMA_DIR");
            if (!SubReportFirma.isEmpty()) {
                encabezadoReporte.setRutaFirmas(SubReportFirma);
            } else {
                encabezadoReporte.setRutaFirmas(rutaFirmas);
            }
            if (tipoForma) {
                if (Principal.informacionIps.getPrefijoReportes().isEmpty()) {
                    setNombreReporte(this.metodos.getRutaRep() + "L_Reporte_Resultado_Con_Encabezado");
                    this.metodos.GenerarPDF(getNombreReporte(), encabezadoReporte, "L_Reporte_Resultado_Con_Encabezado", abrirPDF);
                    Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", idRecepcion, idPersona);
                    return;
                } else {
                    setNombreReporte(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado");
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado", encabezadoReporte, Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado", abrirPDF);
                    Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", idRecepcion, idPersona);
                    return;
                }
            }
            if (Principal.informacionIps.getPrefijoReportes().isEmpty()) {
                setNombreReporte(this.metodos.getRutaRep() + "L_Reporte_Resultado_Sin_Encabezado");
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_Reporte_Resultado_Sin_Encabezado", encabezadoReporte, "L_Reporte_Resultado_Sin_Encabezado", abrirPDF);
                Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", idRecepcion, idPersona);
            } else {
                setNombreReporte(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Sin_Encabezado");
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Sin_Encabezado", encabezadoReporte, Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Sin_Encabezado", abrirPDF);
                Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", idRecepcion, idPersona);
            }
        }
    }

    public void mEvioResultado(String idRecepcion, String idProcedimiento, String rutaSubReportes, String rutaFirmas, boolean tipoForma, String idPersona, boolean abrirPDF) {
        REncabezadoResultadoDTO encabezadoReporte = this.repotesLaboratorio.detalleEncabezadoResultadoCorreo(idRecepcion);
        if (encabezadoReporte != null) {
            List<RDetalleResultadoDTO> listDetalleReporte = this.repotesLaboratorio.detalleResultadoCorreo(idRecepcion, idProcedimiento);
            encabezadoReporte.setListDetalle(listDetalleReporte);
            encabezadoReporte.setRutaSubReportes(rutaSubReportes);
            List<RDetalleExamenesPendientes> listProcedimientoPendientes = this.repotesLaboratorio.detallePendientes(idRecepcion);
            encabezadoReporte.setListProcedimientoPendientes(listProcedimientoPendientes);
            String SubReportFirma = this.metodos.mRutaSoporte("SUBREPORTFIRMA_DIR");
            if (!SubReportFirma.isEmpty()) {
                encabezadoReporte.setRutaFirmas(SubReportFirma);
            } else {
                encabezadoReporte.setRutaFirmas(rutaFirmas);
            }
            if (tipoForma) {
                if (Principal.informacionIps.getPrefijoReportes().isEmpty()) {
                    setNombreReporte(this.metodos.getRutaRep() + "L_Reporte_Resultado_Con_Encabezado");
                    this.metodos.GenerarPDF(getNombreReporte(), encabezadoReporte, "L_Reporte_Resultado_Con_Encabezado", abrirPDF);
                    Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", idRecepcion, idPersona);
                    return;
                } else {
                    setNombreReporte(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado");
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado", encabezadoReporte, Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Con_Encabezado", abrirPDF);
                    Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", idRecepcion, idPersona);
                    return;
                }
            }
            if (Principal.informacionIps.getPrefijoReportes().isEmpty()) {
                setNombreReporte(this.metodos.getRutaRep() + "L_Reporte_Resultado_Sin_Encabezado");
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_Reporte_Resultado_Sin_Encabezado", encabezadoReporte, "L_Reporte_Resultado_Sin_Encabezado", abrirPDF);
                Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", idRecepcion, idPersona);
            } else {
                setNombreReporte(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Sin_Encabezado");
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Sin_Encabezado", encabezadoReporte, Principal.informacionIps.getPrefijoReportes() + "L_Reporte_Resultado_Sin_Encabezado", abrirPDF);
                Principal.mGrabarLogAtenciones("RESULTADO DE LABORATORIO CLINICO SISTEMATIZA", idRecepcion, idPersona);
            }
        }
    }
}
