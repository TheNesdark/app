package com.genoma.plus.jpa.service;

import Acceso.Principal;
import Utilidades.Constantes;
import Utilidades.Metodos;
import co.com.genomaempresarial.ankara.dto.Adjunto;
import co.com.genomaempresarial.ankara.dto.Resolucion;
import co.com.genomaempresarial.ankara.dto.SiifNacion;
import co.com.genomaempresarial.ankara.dto.TipoResolucion;
import co.com.genomaempresarial.ankara.enums.BillingType;
import co.com.genomaempresarial.healthbilladapter.domain.entities.HealthMetadataValue;
import co.com.genomaempresarial.healthbilladapter.domain.enums.HealthContractPaymentType;
import co.com.genomaempresarial.healthbilladapter.domain.enums.HealthCoverageBenefitPlanType;
import co.com.genomaempresarial.healthbilladapter.domain.enums.HealthMetadataType;
import co.com.genomaempresarial.healthbilladapter.usecase.HealthAdditionalMetadata;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.dto.general.GenomaResponse;
import com.genoma.plus.jpa.entities.CargoDescuentoDTO;
import com.genoma.plus.jpa.entities.Detalle;
import com.genoma.plus.jpa.entities.FacturacionElectronicaDTO;
import com.genoma.plus.jpa.entities.FacturacionElectronicaSaludDTO;
import com.genoma.plus.jpa.entities.Impuesto;
import com.genoma.plus.jpa.entities.InfoAdicionalDTO;
import com.genoma.plus.jpa.entities.NotificacionResponseDTO;
import com.genoma.plus.jpa.projection.Emisor;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.ICargoDescuento;
import com.genoma.plus.jpa.projection.IDetalle;
import com.genoma.plus.jpa.projection.IDetalleProcedimientosEmpresa;
import com.genoma.plus.jpa.projection.IFacturaElectronica;
import com.genoma.plus.jpa.projection.IInformacionAdicionalFacturaElectronica084;
import com.genoma.plus.jpa.projection.IInformacionSaludDTO;
import com.genoma.plus.jpa.projection.IInformacionSaludQuirugicoDTO;
import com.genoma.plus.jpa.projection.ImpuestoNota;
import com.genoma.plus.jpa.projection.InfoFactura;
import com.genoma.plus.jpa.projection.InformacionResolucionDianFactura;
import com.genoma.plus.jpa.projection.Pago;
import com.genoma.plus.jpa.projection.Tercero;
import com.genoma.plus.jpa.repository.IFacturaElectronicaRespository;
import java.awt.Component;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/service/FacturaElectronicaDAOImpl.class */
@Transactional
@Service
public class FacturaElectronicaDAOImpl implements IFacturaElectronicaDAO {

    @Autowired
    private IFacturaElectronicaRespository repository;
    private String end_point;
    private String end_point_reenvio;
    private String end_point_resource;
    RestTemplate restTemplate = new RestTemplate();
    private AtomicReference<Double> valorTotalImpuestoRetencion = new AtomicReference<>(Double.valueOf(0.0d));
    private AtomicReference<Double> valorTotalImpuestoIva = new AtomicReference<>(Double.valueOf(0.0d));
    private AtomicReference<Double> valorSubTotal = new AtomicReference<>(Double.valueOf(0.0d));
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public List<ICargarCombo> consultarConvenios(String fechaInicio, String fechaFin) {
        return this.repository.consultarConveniosFacturaElectronica(fechaInicio, fechaFin);
    }

    public List<ICargarCombo> consultarTerceros(String fechaInicio, String fechaFin) {
        return this.repository.consultarTercerosFacturaElectronica(fechaInicio, fechaFin);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaTodo(String fechaInicio, String fechaFin) {
        return this.repository.facturaElectronicaTodo(fechaInicio, fechaFin);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaSuccess(String fechaInicio, String fechaFin) {
        return this.repository.facturaElectronicaSucces(fechaInicio, fechaFin);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaError(String fechaInicio, String fechaFin) {
        return this.repository.facturaElectronicaError(fechaInicio, fechaFin);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaPorEnviar(String fechaInicio, String fechaFin) {
        return this.repository.facturaElectronicaPorEnviar(fechaInicio, fechaFin);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaTodoConvenios(String fechaInicio, String fechaFin, Long idConvenio) {
        return this.repository.facturaElectronicaTodoConvenio(fechaInicio, fechaFin, idConvenio);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaSuccessConvenios(String fechaInicio, String fechaFin, Long idConvenio) {
        return this.repository.facturaElectronicaSuccesConvenio(fechaInicio, fechaFin, idConvenio);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaErrorConvenios(String fechaInicio, String fechaFin, Long idConvenio) {
        return this.repository.facturaElectronicaErrorConvenio(fechaInicio, fechaFin, idConvenio);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaPorEnviarConvenios(String fechaInicio, String fechaFin, Long idConvenio) {
        return this.repository.facturaElectronicaPorEnviarConvenio(fechaInicio, fechaFin, idConvenio);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaTodoTerceros(String fechaInicio, String fechaFin, Long idTercero) {
        return this.repository.facturaElectronicaTodoTercero(fechaInicio, fechaFin, idTercero);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaSuccessTerceros(String fechaInicio, String fechaFin, Long idTercero) {
        return this.repository.facturaElectronicaSuccesTercero(fechaInicio, fechaFin, idTercero);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaErrorTerceros(String fechaInicio, String fechaFin, Long idTercero) {
        return this.repository.facturaElectronicaErrorTercero(fechaInicio, fechaFin, idTercero);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaPorEnviarTerceros(String fechaInicio, String fechaFin, Long idTercero) {
        return this.repository.facturaElectronicaPorEnviarTercero(fechaInicio, fechaFin, idTercero);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoTodo(String fechaInicio, String fechaFin) {
        return this.repository.facturaElectronicaConceptoTodo(fechaInicio, fechaFin);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoSuccess(String fechaInicio, String fechaFin) {
        return this.repository.facturaElectronicaConceptoSucces(fechaInicio, fechaFin);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoError(String fechaInicio, String fechaFin) {
        return this.repository.facturaElectronicaConceptoError(fechaInicio, fechaFin);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoPorEnviar(String fechaInicio, String fechaFin) {
        return this.repository.facturaElectronicaConceptoPorEnviar(fechaInicio, fechaFin);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoTodoConvenio(String fechaInicio, String fechaFin, Long idConvenio) {
        return this.repository.facturaElectronicaConceptoTodoConvenio(fechaInicio, fechaFin, idConvenio);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoSuccessConvenio(String fechaInicio, String fechaFin, Long idConvenio) {
        return this.repository.facturaElectronicaConceptoSuccesConvenio(fechaInicio, fechaFin, idConvenio);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoErrorConvenio(String fechaInicio, String fechaFin, Long idConvenio) {
        return this.repository.facturaElectronicaConceptoErrorConvenio(fechaInicio, fechaFin, idConvenio);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoPorEnviarConvenio(String fechaInicio, String fechaFin, Long idConvenio) {
        return this.repository.facturaElectronicaConceptoPorEnviarConvenio(fechaInicio, fechaFin, idConvenio);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoTodoTercero(String fechaInicio, String fechaFin, Long idTercero) {
        return this.repository.facturaElectronicaConceptoTodoTercero(fechaInicio, fechaFin, idTercero);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoSuccessTercero(String fechaInicio, String fechaFin, Long idTercero) {
        return this.repository.facturaElectronicaConceptoSuccesTercero(fechaInicio, fechaFin, idTercero);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoErrorTercero(String fechaInicio, String fechaFin, Long idTercero) {
        return this.repository.facturaElectronicaConceptoErrorTercero(fechaInicio, fechaFin, idTercero);
    }

    public List<IFacturaElectronica> ConsultarfacturaElectronicaConceptoPorEnviarTercero(String fechaInicio, String fechaFin, Long idTercero) {
        return this.repository.facturaElectronicaConceptoPorEnviarTercero(fechaInicio, fechaFin, idTercero);
    }

    public String mGenerarFacturaElectronica(String nFactura, Integer forma, Boolean reenviado, List<Adjunto> list) {
        List<IDetalle> detalleFac;
        this.end_point = Principal.informacionIps.getEndPointFacturaElectronica() + "/factura/";
        this.end_point_reenvio = Principal.informacionIps.getEndPointFacturaElectronica() + "/factura/pdf/";
        this.end_point_resource = Principal.informacionIps.getEndPointFacturaElectronica() + "/recursos/";
        Metodos metodo = new Metodos();
        String status = "";
        try {
            System.out.println("entra a service Impl mGenerarFactura-->" + Principal.informacionIps.getEndPointFacturaElectronica());
            Pattern pattern = Pattern.compile(Constantes.EMAILPARTTERN);
            FacturacionElectronicaDTO infoFacturacion = new FacturacionElectronicaDTO();
            FacturacionElectronicaSaludDTO infoFacturacionSalud = new FacturacionElectronicaSaludDTO();
            infoFacturacion.setAdjuntos(list);
            Emisor emisor = (Emisor) this.repository.emisor(nFactura).get(0);
            Tercero tercero = (Tercero) this.repository.tercero(nFactura).get(0);
            InformacionResolucionDianFactura getResolucionDian = this.repository.getResolucionDian(nFactura);
            Resolucion resolucion = new Resolucion(TipoResolucion.FACTURA_ELECTRONICA_VENTA, getResolucionDian.getPrefijo(), getResolucionDian.getNumeroResolucion(), getResolucionDian.getFechaI(), getResolucionDian.getFechaF(), getResolucionDian.getNumeroI(), getResolucionDian.getNumeroF(), getResolucionDian.getClaveTecnica());
            ObjectMapper res = new ObjectMapper();
            System.out.println("entra a imprimir Resolucion");
            System.out.println(res.writeValueAsString(resolucion));
            List<IDetalle> detalleFacSinFiltroValorCero = null;
            List<IDetalleProcedimientosEmpresa> detalleProcedimientosEmpresa = null;
            List<CargoDescuentoDTO> cargoDescuento = new ArrayList<>();
            InfoAdicionalDTO infoAdicionalDTO = new InfoAdicionalDTO();
            this.valorTotalImpuestoRetencion = new AtomicReference<>(Double.valueOf(0.0d));
            this.valorTotalImpuestoIva = new AtomicReference<>(Double.valueOf(0.0d));
            this.valorSubTotal = new AtomicReference<>(Double.valueOf(0.0d));
            SiifNacion siifNacion = null;
            HealthAdditionalMetadata healthAdditionalMetadata = new HealthAdditionalMetadata();
            HashMap<HealthMetadataType, HealthMetadataValue> map = new HashMap<>();
            IInformacionAdicionalFacturaElectronica084 electronica084 = informacionAdicionalFacturaElectronica084(nFactura);
            if (electronica084 != null) {
                map.put(HealthMetadataType.CODIGO_PRESTADOR, HealthMetadataValue.builder().value(electronica084.getCodigoOrganismo()).build());
                infoAdicionalDTO.setTipoAfiliacion(electronica084.getNombreTipoAfiliacion());
                System.out.println("" + electronica084.getAplicaCodigoMaterial());
                infoAdicionalDTO.setAplicaCodigoMaterial(electronica084.getAplicaCodigoMaterial());
                infoAdicionalDTO.setModalidadContratacionPago(electronica084.getNombreTipoContratacion());
                map.put(HealthMetadataType.COBERTURA_PLAN_BENEFICIOS, HealthMetadataValue.builder().key(HealthCoverageBenefitPlanType.valueKey(electronica084.getTipoPlan()).getName()).build());
                infoAdicionalDTO.setCoberturaPlanBeneficio(electronica084.getNombreTipoPlan());
                if (electronica084.getFirmaUsuario() != null) {
                    Base64 codec = new Base64();
                    String imagen = codec.encodeAsString(electronica084.getFirmaUsuario());
                    System.out.println("" + imagen);
                    infoAdicionalDTO.setFirmaUsuario(imagen);
                }
                infoAdicionalDTO.setNumeroPoliza(electronica084.getNumeroPoliza());
                map.put(HealthMetadataType.NUMERO_CONTRATO, HealthMetadataValue.builder().value(electronica084.getNumeroContrato()).build());
                map.put(HealthMetadataType.NUMERO_POLIZA, HealthMetadataValue.builder().value(electronica084.getNumeroPoliza()).build());
                if (electronica084.getIdSiifNacion() != null) {
                    siifNacion = new SiifNacion(electronica084.getIdSiifNacion(), electronica084.getNumeroContrato(), electronica084.getCorreoSiifNacion());
                }
            }
            healthAdditionalMetadata.setMap(map);
            infoFacturacionSalud.setMetadataAdicional(healthAdditionalMetadata);
            if (forma.intValue() == 0) {
                this.end_point = Principal.informacionIps.getEndPointFacturaElectronica() + "/factura/salud/";
                detalleFac = this.repository.detalle(nFactura);
                detalleFacSinFiltroValorCero = this.repository.detalleSinFiltroValorCero(nFactura);
                infoFacturacionSalud.setNombreReporte("FACTU_SALUD");
                List<Detalle> detalleFactura = new ArrayList<>();
                for (int i = 0; i < detalleFac.size(); i++) {
                    List<Impuesto> listaImpuesto = new ArrayList<>();
                    Detalle detall = new Detalle();
                    Impuesto impuesto = new Impuesto();
                    detall.setCantidad(detalleFac.get(i).getCantidad());
                    detall.setCodigo(detalleFac.get(i).getCodigo());
                    detall.setDescripcion(detalleFac.get(i).getDescripcion());
                    detall.setDescuento(detalleFac.get(i).getDescuento());
                    impuesto.setPorcentajeImpuesto(detalleFac.get(i).getPorcentajeImpuesto());
                    impuesto.setTipoImpuesto(detalleFac.get(i).getTipoImpuesto());
                    listaImpuesto.add(impuesto);
                    detall.setImpuestos(listaImpuesto);
                    detall.setValorUnitario(detalleFac.get(i).getValorUnitario());
                    detalleFactura.add(i, detall);
                    if (detalleFac.get(i).getIdDetalleCuentaCobro() != null) {
                        detall.setRetenciones(getImpuestosDetalleCuentaCobro(detalleFac.get(i)));
                    }
                }
            } else {
                infoFacturacion.setNombreReporte("EBILLREPORT");
                IInformacionAdicionalFacturaElectronica084 electronica084C = informacionAdicionalFacturaElectronica084Concepto(nFactura);
                if (electronica084C != null) {
                    infoFacturacion.setFechaPeriodoInicial(electronica084C.getFechaPeriodoInicial());
                    infoFacturacion.setFechaPeriodoFinal(electronica084C.getFechaPeriodoFinal());
                    map.put(HealthMetadataType.CODIGO_PRESTADOR, HealthMetadataValue.builder().value(electronica084C.getCodigoOrganismo()).build());
                    map.put(HealthMetadataType.COBERTURA_PLAN_BENEFICIOS, HealthMetadataValue.builder().key(HealthCoverageBenefitPlanType.valueKey(electronica084C.getTipoPlan()).getName()).build());
                    map.put(HealthMetadataType.NUMERO_CONTRATO, HealthMetadataValue.builder().value(electronica084C.getNumeroContrato()).build());
                    map.put(HealthMetadataType.NUMERO_POLIZA, HealthMetadataValue.builder().value(electronica084C.getNumeroPoliza()).build());
                    map.put(HealthMetadataType.MODALIDAD_PAGO, HealthMetadataValue.builder().key(HealthContractPaymentType.valueKey(electronica084C.getTipoContratacion()).getName()).build());
                }
                healthAdditionalMetadata.setMap(map);
                infoFacturacion.setMetadataAdicional(healthAdditionalMetadata);
                infoFacturacion.setBillingType(BillingType.SS_SIN_APORTE);
                if ("BIEN ESTAR SALUD BS S.A.S.".equals(Principal.informacionIps.getNombreIps())) {
                    detalleFac = this.repository.detalleFacturaConceptoBienestar(nFactura);
                } else {
                    this.repository.detalleFacturaConceptoBienestar(nFactura);
                    detalleFac = this.repository.detalleFacturaConcepto(nFactura);
                }
                if (!detalleFac.isEmpty()) {
                    infoAdicionalDTO.setResolucionDian(detalleFac.get(0).getResolucionDian());
                    infoAdicionalDTO.setConceptoGeneral(detalleFac.get(0).getConceptoGeneral());
                    System.out.println(">>>>>>>>>>>>>");
                    infoAdicionalDTO.setObservacionCuentaCobro(detalleFac.get(0).getObservacion());
                }
                if ("IPS SU SALUD INTEGRAL S.A.S".equals(Principal.informacionIps.getNombreIps()) || "BIEN ESTAR SALUD BS S.A.S.".equals(Principal.informacionIps.getNombreIps())) {
                    List<IDetalle> detalleFacRelacionCapitacion = this.repository.detalleFacturaCapitacion(nFactura);
                    if (!detalleFacRelacionCapitacion.isEmpty()) {
                        detalleFac = this.repository.detalleFacturaCapitacion(nFactura);
                        detalleProcedimientosEmpresa = this.repository.detallesProcedimientosPorEmpresa(nFactura);
                        infoAdicionalDTO.setDetallesProcedimientosEmpresa(detalleProcedimientosEmpresa);
                        List<ICargoDescuento> iCargoDescuento = this.repository.detalleDescuento(nFactura);
                        for (ICargoDescuento iCargoDescuento1 : iCargoDescuento) {
                            CargoDescuentoDTO c = new CargoDescuentoDTO();
                            c.setCodigo(iCargoDescuento1.getCodigo());
                            c.setIndicador(false);
                            c.setMotivo(iCargoDescuento1.getMotivo());
                            c.setPorcentaje(iCargoDescuento1.getPorcentaje());
                            c.setValor(iCargoDescuento1.getValor());
                            cargoDescuento.add(c);
                        }
                    }
                } else {
                    List<ICargoDescuento> iCargoDescuento2 = this.repository.detalleDescuento(nFactura);
                    for (ICargoDescuento iCargoDescuento12 : iCargoDescuento2) {
                        CargoDescuentoDTO c2 = new CargoDescuentoDTO();
                        c2.setCodigo(iCargoDescuento12.getCodigo());
                        c2.setIndicador(false);
                        c2.setMotivo(iCargoDescuento12.getMotivo());
                        c2.setPorcentaje(iCargoDescuento12.getPorcentaje());
                        c2.setValor(iCargoDescuento12.getValor());
                        cargoDescuento.add(c2);
                    }
                }
                if (Principal.informacionIps.getIdentificacion().equals("900304530")) {
                    if (detalleProcedimientosEmpresa == null) {
                        infoFacturacion.setNombreReporte("FACTURA_CONCEPTO");
                    } else {
                        infoFacturacion.setNombreReporte("EBILLREPORT");
                    }
                }
            }
            Pago pago = (Pago) this.repository.getPago(nFactura).get(0);
            Pago pagoInfo = this.repository.getPagoDetalle(nFactura);
            List<Detalle> detalleFactura2 = new ArrayList<>();
            List<IInformacionSaludQuirugicoDTO> listadoLiquidacionCirugia = this.repository.listadoLiquidacionCirugia(nFactura);
            infoAdicionalDTO.setInfoPiePagina1(Principal.informacionIps.getPiePaginaIps());
            infoAdicionalDTO.setInfoPiePagina2(Principal.informacionIps.getPiePagina2Ips());
            infoAdicionalDTO.setDireccionIps(Principal.informacionIps.getDireccion1Ips());
            infoAdicionalDTO.setTelefonoIps(Principal.informacionIps.getTelefonoIps());
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                infoAdicionalDTO.setInfoLiquidacionOtrosServicios(detalleFac);
            } else {
                infoAdicionalDTO.setInfoLiquidacionOtrosServicios(detalleFacSinFiltroValorCero);
            }
            infoAdicionalDTO.setMedioDePago(pagoInfo.getMedio());
            infoAdicionalDTO.setFormaPago(pagoInfo.getMetodo());
            infoAdicionalDTO.setNombreCiudad(tercero.getNombreCiudad());
            IInformacionSaludDTO informacionSaludDTO = this.repository.informacionSaludAdicional(nFactura);
            if (informacionSaludDTO != null && (informacionSaludDTO.getValorCopago().doubleValue() != 0.0d || informacionSaludDTO.getValorCuotaModeradora().doubleValue() != 0.0d || informacionSaludDTO.getValorDescuento().doubleValue() != 0.0d)) {
                CargoDescuentoDTO descuentoDTO = new CargoDescuentoDTO();
                descuentoDTO.setCodigo("11");
                descuentoDTO.setIndicador(false);
                descuentoDTO.setPorcentaje(new Double(0.0d));
                if (informacionSaludDTO.getValorCopago().doubleValue() != 0.0d) {
                    descuentoDTO.setMotivo("DESCUENTO DE COPAGO");
                    descuentoDTO.setValor(informacionSaludDTO.getValorCopago());
                } else if (informacionSaludDTO.getValorCuotaModeradora().doubleValue() != 0.0d) {
                    descuentoDTO.setMotivo("DESCUENTO CUOTA MODERADORA");
                    descuentoDTO.setValor(informacionSaludDTO.getValorCuotaModeradora());
                } else if (informacionSaludDTO.getValorDescuento().doubleValue() != 0.0d) {
                    descuentoDTO.setMotivo("DESCUENTO");
                    descuentoDTO.setValor(informacionSaludDTO.getValorDescuento());
                }
                cargoDescuento.add(descuentoDTO);
            }
            if (!Principal.informacionIps.getUrlLogoSuperSsalud().isEmpty() || Principal.informacionIps.getUrlLogoSuperSsalud() != null) {
                infoAdicionalDTO.setImagenSuperSalud(Metodos.encodeFileToBase64Binary(metodo.getRutaRep() + Principal.informacionIps.getUrlLogoSuperSsalud()));
            }
            if (forma.intValue() == 0 && !informacionSaludDTO.getUrlFirmaPersonaGenera().isEmpty() && informacionSaludDTO.getUrlFirmaPersonaGenera() != null) {
                infoAdicionalDTO.setFirmaUsuarioResponsable(Metodos.encodeFileToBase64Binary(metodo.mRutaSoporte("SUBREPORTFIRMA_DIR") + informacionSaludDTO.getUrlFirmaPersonaGenera()));
            }
            infoAdicionalDTO.setInfoSalud(informacionSaludDTO);
            infoAdicionalDTO.setInfoLiquidacionCirugias(listadoLiquidacionCirugia);
            for (int i2 = 0; i2 < detalleFac.size(); i2++) {
                List<Impuesto> listaImpuesto2 = new ArrayList<>();
                List<Impuesto> impuestoX = new ArrayList();
                if (detalleFac.get(i2).getIdDetalleCuentaCobro() != null) {
                    impuestoX = getImpuestosDetalleCuentaCobro(detalleFac.get(i2));
                }
                Detalle detall2 = new Detalle();
                Impuesto impuesto2 = new Impuesto();
                detall2.setCantidad(detalleFac.get(i2).getCantidad());
                detall2.setCodigo(detalleFac.get(i2).getCodigo());
                detall2.setDescripcion(detalleFac.get(i2).getDescripcion());
                detall2.setDescuento(detalleFac.get(i2).getDescuento());
                impuesto2.setPorcentajeImpuesto(detalleFac.get(i2).getPorcentajeImpuesto());
                impuesto2.setTipoImpuesto(detalleFac.get(i2).getTipoImpuesto());
                listaImpuesto2.add(impuesto2);
                detall2.setImpuestos(listaImpuesto2);
                detall2.setValorUnitario(detalleFac.get(i2).getValorUnitario());
                detall2.setRetenciones(impuestoX);
                detalleFactura2.add(i2, detall2);
            }
            System.out.println("info adicional " + infoAdicionalDTO);
            for (IInformacionSaludQuirugicoDTO listadoLiquidacionCirugia1 : listadoLiquidacionCirugia) {
                List<Impuesto> listaImpuesto3 = new ArrayList<>();
                Detalle detall3 = new Detalle();
                Impuesto impuesto3 = new Impuesto();
                detall3.setCantidad(new Double(1.0d));
                detall3.setCodigo(listadoLiquidacionCirugia1.getCodigoProcedimientoDetalle());
                detall3.setDescripcion(listadoLiquidacionCirugia1.getNombreProcedimientoDetalle());
                detall3.setDescuento(new Double(0.0d));
                impuesto3.setPorcentajeImpuesto(new Double(0.0d));
                impuesto3.setTipoImpuesto("01");
                listaImpuesto3.add(impuesto3);
                detall3.setImpuestos(listaImpuesto3);
                detall3.setValorUnitario(listadoLiquidacionCirugia1.getValorTotal());
                detalleFactura2.add(detall3);
            }
            Boolean ValidarVacios = false;
            try {
                if (!emisor.getTipoIdentificacion().isEmpty()) {
                    if (!emisor.getIdentificacion().isEmpty()) {
                        if (!emisor.getNombreAutorizado().isEmpty()) {
                            if (!emisor.getFirmaAutorizada().isEmpty()) {
                                if (!emisor.getCargoAutorizado().isEmpty()) {
                                    if (!tercero.getTipoPersona().isEmpty()) {
                                        if (!tercero.getTipoIdentificacion().isEmpty()) {
                                            if (!tercero.getIdentificacion().isEmpty()) {
                                                if (!tercero.getCodigoPais().isEmpty()) {
                                                    if (!tercero.getDepartamento().isEmpty()) {
                                                        if (!tercero.getCiudad().isEmpty()) {
                                                            if (!tercero.getDireccion().isEmpty()) {
                                                                if (!tercero.getEmail().isEmpty()) {
                                                                    if (!pago.getMetodo().isEmpty()) {
                                                                        if (!pago.getMedio().isEmpty()) {
                                                                            if (!pago.getFecha().isEmpty()) {
                                                                                ValidarVacios = true;
                                                                            } else {
                                                                                JOptionPane.showMessageDialog((Component) null, "El pago no tiene Fecha de Vencimiento asignado.", "Error", 0);
                                                                            }
                                                                        } else {
                                                                            JOptionPane.showMessageDialog((Component) null, "El pago no tiene Medio de Pago asignado.", "Error", 0);
                                                                        }
                                                                    } else {
                                                                        JOptionPane.showMessageDialog((Component) null, "El pago no tiene Metodo de Pago asignado.", "Error", 0);
                                                                    }
                                                                } else {
                                                                    JOptionPane.showMessageDialog((Component) null, "El tercero no tiene email", "Error", 0);
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog((Component) null, "El tercero no tiene Dirección asignado.", "Error", 0);
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog((Component) null, "El tercero no tiene Codigo Municipio asignado.", "Error", 0);
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog((Component) null, "El tercero no tiene Codigo Departamento asignado.", "Error", 0);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog((Component) null, "El tercero no tiene Codigo Pais asignado.", "Error", 0);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog((Component) null, "El tercero no tiene Identificacion asignado.", "Error", 0);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog((Component) null, "El tercero no tiene Tipo Identificacion asignado.", "Error", 0);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog((Component) null, "El tercero no tiene Tipo de Persona asignado.", "Error", 0);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog((Component) null, "El emisor no tiene Cargo Autoridado asignado.", "Error", 0);
                                }
                            } else {
                                JOptionPane.showMessageDialog((Component) null, "El emisor no tiene Firma Autorizado asignado.", "Error", 0);
                            }
                        } else {
                            JOptionPane.showMessageDialog((Component) null, "El emisor no tiene Nombre Autorizado asignado.", "Error", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component) null, "El emisor no tiene Identificación asignado.", "Error", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog((Component) null, "El emisor no tiene Tipo Identificación Dian asignado.", "Error", 0);
                }
            } catch (Exception e) {
                System.err.println("Error: " + e);
            }
            System.out.println("" + detalleFac.size());
            int i3 = 0;
            while (true) {
                try {
                    if (i3 >= detalleFac.size()) {
                        break;
                    }
                    if (!detalleFac.get(i3).getCodigo().isEmpty()) {
                        if (!detalleFac.get(i3).getDescripcion().isEmpty()) {
                            if (!detalleFac.get(i3).getCantidad().toString().isEmpty()) {
                                if (!detalleFac.get(i3).getValorUnitario().toString().isEmpty()) {
                                    if (!detalleFac.get(i3).getDescuento().toString().isEmpty()) {
                                        if (!detalleFac.get(i3).getPorcentajeImpuesto().toString().isEmpty()) {
                                            if (!detalleFac.get(i3).getTipoImpuesto().isEmpty()) {
                                                i3++;
                                            } else {
                                                JOptionPane.showMessageDialog((Component) null, "El detalle de factura no tiene Tipo Impuesto asignado.", "Error", 0);
                                                break;
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog((Component) null, "El detalle de factura no tiene Porcentaje Impuesto asignado.", "Error", 0);
                                            break;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog((Component) null, "El detalle de factura no tiene Descuento asignado.", "Error", 0);
                                        break;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog((Component) null, "El detalle de factura no tiene Valor Unitario asignado.", "Error", 0);
                                    break;
                                }
                            } else {
                                JOptionPane.showMessageDialog((Component) null, "El detalle de factura no tiene Cantidad asignado.", "Error", 0);
                                break;
                            }
                        } else {
                            JOptionPane.showMessageDialog((Component) null, "El detalle de factura no tiene Descripción asignado.", "Error", 0);
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component) null, "El detalle de factura no tiene Codigo asignado.", "Error", 0);
                        break;
                    }
                } catch (Exception e2) {
                    System.err.println("Error: " + e2);
                }
            }
            InfoFactura infoFactura = (InfoFactura) this.repository.infoFactura(nFactura).get(0);
            Boolean infoFac = false;
            try {
                if (!infoFactura.getTipoFactura().isEmpty()) {
                    if (!infoFactura.getNConsecutivo().isEmpty()) {
                        if (!infoFactura.getFechaFactura().isEmpty()) {
                            if (!infoFactura.getFechaVencimiento().isEmpty()) {
                                if (!infoFactura.getMoneda().isEmpty()) {
                                    infoFac = true;
                                } else {
                                    JOptionPane.showMessageDialog((Component) null, "La información de factura no tiene Moneda asignado.", "Error", 0);
                                }
                            } else {
                                JOptionPane.showMessageDialog((Component) null, "La información de factura no tiene Fecha Vencimiento asignado.", "Error", 0);
                            }
                        } else {
                            JOptionPane.showMessageDialog((Component) null, "La información de factura no tiene Fecha Factura asignado.", "Error", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog((Component) null, "La información de factura no tiene Numero de Consecutivo asignado.", "Error", 0);
                    }
                } else {
                    JOptionPane.showMessageDialog((Component) null, "La información de factura no tiene Tipo Factura asignado.", "Error", 0);
                }
            } catch (Exception e3) {
                System.err.println("Error: " + e3);
            }
            Boolean validarEmail = false;
            if (!tercero.getEmail().isEmpty()) {
                Matcher matcher = pattern.matcher(tercero.getEmail());
                System.out.println(tercero.getEmail());
                if (matcher.matches()) {
                    validarEmail = true;
                } else {
                    JOptionPane.showMessageDialog((Component) null, "El Email del tercero no es valido.\nEmail: " + tercero.getEmail(), "Error", 0);
                }
            } else {
                JOptionPane.showMessageDialog((Component) null, "El tercero no tiene Email asignado.", "Error", 0);
            }
            infoFacturacion.setTipoFactura(infoFactura.getTipoFactura());
            infoFacturacion.setNumeroFactura(infoFactura.getNConsecutivo());
            infoFacturacion.setPrefijo(infoFactura.getPrefijo());
            infoFacturacion.setFechaEmision(infoFactura.getFechaFactura());
            infoFacturacion.setFechaVencimiento(infoFactura.getFechaVencimiento());
            infoFacturacion.setEmisor(emisor);
            infoFacturacion.setTercero(tercero);
            infoFacturacion.setSiifNacion(siifNacion);
            infoFacturacion.setInfoAdicional(infoAdicionalDTO);
            infoFacturacion.setDetalle(detalleFactura2);
            infoFacturacion.setPago(pago);
            infoFacturacion.setCargoDescuento(cargoDescuento);
            infoFacturacion.setOrderReference(infoFactura.getOrderReference());
            infoFacturacion.setResolucion(resolucion);
            infoFacturacionSalud.setTipoFactura(infoFactura.getTipoFactura());
            infoFacturacionSalud.setNumeroFactura(infoFactura.getNConsecutivo());
            infoFacturacionSalud.setPrefijo(infoFactura.getPrefijo());
            infoFacturacionSalud.setFechaEmision(infoFactura.getFechaFactura());
            infoFacturacionSalud.setFechaVencimiento(infoFactura.getFechaVencimiento());
            infoFacturacionSalud.setEmisor(emisor);
            infoFacturacionSalud.setTercero(tercero);
            infoFacturacionSalud.setSiifNacion(siifNacion);
            infoFacturacionSalud.setInfoAdicional(infoAdicionalDTO);
            infoFacturacionSalud.setDetalle(detalleFactura2);
            infoFacturacionSalud.setPago(pago);
            infoFacturacionSalud.setCargoDescuento(cargoDescuento);
            infoFacturacionSalud.setResolucion(resolucion);
            infoAdicionalDTO.setFechaVencimiento(infoFacturacion.getFechaVencimiento());
            infoAdicionalDTO.setFechaFactura(infoFacturacion.getFechaEmision());
            infoAdicionalDTO.setValorImpuestoRetencion(this.valorTotalImpuestoRetencion.get());
            infoAdicionalDTO.setSubTotal(this.valorSubTotal.get());
            Double netoP = Double.valueOf(this.valorSubTotal.get().doubleValue() - this.valorTotalImpuestoRetencion.get().doubleValue());
            infoAdicionalDTO.setNetoPagar(netoP);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("entra a imprimir objetMapper");
            System.out.println(mapper.writeValueAsString(infoFacturacion));
            NotificacionResponseDTO response = new NotificacionResponseDTO();
            GenomaResponse genomaResponse = new GenomaResponse();
            if (validarEmail.booleanValue() && infoFac.booleanValue() && ValidarVacios.booleanValue()) {
                System.out.println("ENTRA A IF EJCUCION");
                try {
                    if (forma.intValue() == 0) {
                        response = (NotificacionResponseDTO) this.restTemplate.postForObject(this.end_point, infoFacturacionSalud, NotificacionResponseDTO.class, new Object[0]);
                    } else if (forma.intValue() == 1) {
                        response = (NotificacionResponseDTO) this.restTemplate.postForObject(this.end_point, infoFacturacion, NotificacionResponseDTO.class, new Object[0]);
                    }
                    System.out.println("---RESPONSE--->" + response);
                    System.out.println("---STATUS--->" + response.getEstado());
                } catch (Exception ex) {
                    System.out.println("response exception " + genomaResponse);
                    System.out.println("response exception " + response);
                    System.out.println("excepcion" + ex.toString());
                }
            }
            if (response != null) {
                System.out.println("---entra a condición de response---");
                if (response.getEstado() != null) {
                    System.out.println("---entra a condición de estado SUCCESS");
                    new NotificacionResponseDTO();
                    System.out.println("mensaje-->" + response.getMensaje());
                    System.out.println("estado-->" + response.getEstado());
                    System.out.println("actualiza estado factura");
                    if (forma.intValue() == 0) {
                        System.out.println("MENSAJE: " + response.getMensaje().toString() + " ESTADO: " + response.getEstado().toString() + " NFACTURA: " + nFactura.toString() + " RESPUESTA: " + response.getRespuesta().toString());
                        this.repository.updateEstadoFactura(response.getMensaje(), response.getEstado(), nFactura, response.getRespuesta().toString());
                    } else {
                        this.repository.updateEstadoFacturaCapita(response.getMensaje(), response.getEstado(), nFactura, response.getRespuesta().toString());
                    }
                    status = response.getEstado();
                }
            }
            System.out.println(emisor.toString());
        } catch (IOException ex2) {
            Logger.getLogger(FacturaElectronicaDAOImpl.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        return status;
    }

    public IInformacionAdicionalFacturaElectronica084 informacionAdicionalFacturaElectronica084(String string) {
        return this.repository.informacionAdicionalFacturaElectronica084(string);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.genoma.plus.jpa.service.FacturaElectronicaDAOImpl$1] */
    List<Impuesto> getImpuestosDetalleCuentaCobro(IDetalle detalle) {
        List<Impuesto> listImpuesto = new ArrayList<>();
        List<String> impuestos = new ArrayList<>();
        List<String> retenciones = new ArrayList<>();
        retenciones.add("05");
        retenciones.add("06");
        impuestos.add("01");
        ModelMapper mapper = new ModelMapper();
        System.out.println("id Detalle Cuenta cobro >>>>>>" + detalle.getIdDetalleCuentaCobro() + "   retenciones >>>>" + retenciones.listIterator());
        List<ImpuestoNota> retencionesProjection = this.repository.getRetencionesImpuestos(detalle.getIdDetalleCuentaCobro(), retenciones);
        this.valorSubTotal.updateAndGet(v -> {
            return Double.valueOf(v.doubleValue() + (detalle.getValorUnitario().doubleValue() * detalle.getCantidad().doubleValue()));
        });
        if (!retencionesProjection.isEmpty()) {
            mapper.map(retencionesProjection, new TypeToken<List<Impuesto>>() { // from class: com.genoma.plus.jpa.service.FacturaElectronicaDAOImpl.1
            }.getType());
            retencionesProjection.forEach(e -> {
                this.valorTotalImpuestoRetencion.updateAndGet(v2 -> {
                    return Double.valueOf(v2.doubleValue() + e.getValorImpuesto().doubleValue());
                });
            });
        }
        retencionesProjection.forEach(e2 -> {
            Impuesto impuesto = new Impuesto();
            impuesto.setPorcentajeImpuesto(e2.getPorcentajeImpuesto());
            impuesto.setTipoImpuesto(e2.getTipoImpuesto());
            impuesto.setValorImpuesto(e2.getValorImpuesto());
            listImpuesto.add(impuesto);
        });
        return listImpuesto;
    }

    public List<ICargarCombo> consultarConveniosSaludIntegral(String fechaInicio, String fechaFin) {
        return this.repository.consultarConveniosFacturaElectronicaSaludIntegral(fechaInicio, fechaFin);
    }

    public List<ICargarCombo> consultarTercerosSaludIntegral(String fechaInicio, String fechaFin) {
        return this.repository.consultarTercerosFacturaElectronicaSaludIntegral(fechaInicio, fechaFin);
    }

    public void actualizarFechaHoraFacturaEvento(List<Long> list) {
        this.repository.getActualizarFechaHoraFactura(list);
    }

    public IInformacionAdicionalFacturaElectronica084 informacionAdicionalFacturaElectronica084Concepto(String string) {
        return this.repository.informacionAdicionalFacturaElectronica084Concepto(string);
    }
}
