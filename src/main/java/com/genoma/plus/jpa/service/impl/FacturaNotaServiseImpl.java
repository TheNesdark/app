package com.genoma.plus.jpa.service.impl;

import Acceso.Principal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.jpa.entities.DetalleNota;
import com.genoma.plus.jpa.entities.DiscrepanceResponse;
import com.genoma.plus.jpa.entities.FENote;
import com.genoma.plus.jpa.entities.FacturaNota;
import com.genoma.plus.jpa.entities.FacturaNotaDetalle;
import com.genoma.plus.jpa.entities.Impuesto;
import com.genoma.plus.jpa.entities.ImpuestoNotaC;
import com.genoma.plus.jpa.entities.InfoAdicionalNotasDTO;
import com.genoma.plus.jpa.entities.Note;
import com.genoma.plus.jpa.entities.NotificacionResponseDTO;
import com.genoma.plus.jpa.entities.TerceroDto;
import com.genoma.plus.jpa.projection.EmisorNC;
import com.genoma.plus.jpa.projection.ImpuestoNota;
import com.genoma.plus.jpa.projection.NotasElectronicas;
import com.genoma.plus.jpa.projection.Tercero;
import com.genoma.plus.jpa.repository.FacturaNotaDetalleRepository;
import com.genoma.plus.jpa.repository.FacturaNotasRepository;
import com.genoma.plus.jpa.service.FacturaNotasService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/service/impl/FacturaNotaServiseImpl.class */
@Service
public class FacturaNotaServiseImpl implements FacturaNotasService {

    @Autowired
    private FacturaNotasRepository facturaNotaRepository;

    @Autowired
    private FacturaNotaDetalleRepository facturaNotaDetalleRepository;
    private String END_POINT;
    RestTemplate restTemplate = new RestTemplate();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public FacturaNota save(FacturaNota facturaNota) {
        return (FacturaNota) this.facturaNotaRepository.save(facturaNota);
    }

    public List<NotasElectronicas> listadoNotasPorEnviar(Integer enviado, String numero, String fechaI, String fechaF) {
        return this.facturaNotaRepository.findByEnviada(enviado, numero, fechaI, fechaF);
    }

    public String generarNotasDebitoCredito(Integer idNota, String factura, String tipoNota) {
        System.out.println("id Nota " + idNota + "No factura " + factura);
        this.END_POINT = Principal.informacionIps.getEndPointFacturaElectronica() + "/note/";
        System.out.println("Nota debito llego aqui");
        try {
            System.out.println("Nota debito llego aqui1");
            FacturaNota nota = (FacturaNota) this.facturaNotaRepository.findById(idNota).get();
            DiscrepanceResponse discrepanceResponse = DiscrepanceResponse.builder().description(nota.getDescripcionGeneral()).responseCode(nota.getIdConceptoNota().toString()).referenceId(factura).build();
            List<DetalleNota> detalle = getDetalleNota(idNota);
            Note note = Note.builder().tipo(tipoNota).numeroNota(nota.getNumeroConsecutivo()).prefijo(nota.getPrefijo()).discrepanceResponse(discrepanceResponse).detalle(detalle).fechaPeriodoInicial(this.dateFormat.format(nota.getFechaPeriodoInicial())).fechaPeriodoFinal(this.dateFormat.format(nota.getFechaPeriodoFinal())).build();
            System.out.println("paso el detalle");
            EmisorNC emisor = getEmisor();
            FENote feNote = new FENote();
            feNote.setEmisor(emisor);
            feNote.setNote(note);
            InfoAdicionalNotasDTO infoAdicional = new InfoAdicionalNotasDTO();
            infoAdicional.setObservacion(discrepanceResponse.getDescription());
            feNote.setTercero(obtenerTercero(idNota));
            if (tipoNota.equals("CREDIT_NOTE") || tipoNota.equals("CREDIT_NOTE_WBR")) {
                feNote.setNombreReporte("NOTA_CREDITO");
            } else {
                feNote.setNombreReporte("NOTA_DEBITO");
            }
            feNote.setInfoAdicional(infoAdicional);
            System.out.println("Nota debito llego aqui2");
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("entra a imprimir objetMapper");
            System.out.println(mapper.writeValueAsString(feNote));
            System.out.println("");
            new NotificacionResponseDTO();
            NotificacionResponseDTO response = (NotificacionResponseDTO) this.restTemplate.postForObject(this.END_POINT, feNote, NotificacionResponseDTO.class, new Object[0]);
            System.out.println("mensaje-->" + response.getMensaje());
            System.out.println("estado-->" + response.getEstado());
            if (response != null) {
                System.out.println("actualiza estado nota");
                nota.setResponse(response.getMensaje());
                nota.setResponseEstado(response.getEstado());
                nota.setEnviada(true);
                this.facturaNotaRepository.save(nota);
                return "";
            }
            return "";
        } catch (Exception ex) {
            System.out.println("dio error " + ex.toString());
            return "Ocurrio un error";
        }
    }

    public EmisorNC getEmisor() {
        return this.facturaNotaRepository.obtenerEmisor();
    }

    public List<DetalleNota> getDetalleNota(Integer idNota) {
        List<FacturaNotaDetalle> detalleFactura = this.facturaNotaDetalleRepository.findByIdFacturaNota(idNota);
        List<DetalleNota> listaDetalle = new ArrayList<>();
        new Impuesto();
        System.out.println("size " + detalleFactura.size());
        for (int j = 0; j < detalleFactura.size(); j++) {
            DetalleNota detalle = new DetalleNota();
            detalle.setCantidad(detalleFactura.get(j).getCantidad());
            detalle.setCodigo(detalleFactura.get(j).getIdCodigo());
            detalle.setDescripcion(detalleFactura.get(j).getNombreItem());
            detalle.setValorUnitario(detalleFactura.get(j).getValorUnitario());
            detalle.setDescuento(0);
            List<ImpuestoNotaC> listImpu = new ArrayList<>();
            if (detalleFactura.get(j).getPorcentajeImpuesto().doubleValue() == 19.0d || detalleFactura.get(j).getPorcentajeImpuesto().doubleValue() == 16.0d) {
                ImpuestoNotaC i = new ImpuestoNotaC();
                i.setPorcentajeImpuesto(Integer.valueOf(detalleFactura.get(j).getPorcentajeImpuesto().intValue()));
                i.setTipoImpuesto("01");
                listImpu.add(i);
            } else if (detalleFactura.get(j).getPorcentajeImpuesto().doubleValue() == 8.0d) {
                ImpuestoNotaC i2 = new ImpuestoNotaC();
                i2.setPorcentajeImpuesto(Integer.valueOf(detalleFactura.get(j).getPorcentajeImpuesto().intValue()));
                i2.setTipoImpuesto("02");
                listImpu.add(i2);
            } else {
                ImpuestoNotaC i3 = new ImpuestoNotaC();
                i3.setPorcentajeImpuesto(Integer.valueOf(detalleFactura.get(j).getPorcentajeImpuesto().intValue()));
                i3.setTipoImpuesto("01");
                listImpu.add(i3);
            }
            detalle.setImpuestos(listImpu);
            listaDetalle.add(detalle);
        }
        return listaDetalle;
    }

    public String obtenerFactura(Integer idNota) {
        return this.facturaNotaRepository.obtenerFactura(idNota);
    }

    public List<ImpuestoNota> obtenerImpuestoItems(Long codigo, String factura) {
        return this.facturaNotaRepository.obtenerImpuesto(codigo, factura);
    }

    public TerceroDto obtenerTercero(Integer idNota) {
        Tercero terceroI = this.facturaNotaRepository.obtenerTercero(idNota);
        TerceroDto tercero = TerceroDto.builder().tipoIdentificacion(terceroI.getTipoIdentificacion()).identificacion(terceroI.getIdentificacion()).tipoPersona(terceroI.getTipoPersona()).tipoObligacion(terceroI.getTipoObligacion()).razonSocial(terceroI.getRazonSocial()).nombre(terceroI.getNombre()).apellido(terceroI.getApellido()).codigoPais(terceroI.getCodigoPais()).departamento(terceroI.getDepartamento()).ciudad(terceroI.getCiudad()).direccion(terceroI.getDireccion()).telefono(terceroI.getTelefono()).email(terceroI.getEmail()).build();
        return tercero;
    }

    public List<ImpuestoNota> obtenerImpuestoNotaSumProc(Long codigo) {
        return this.facturaNotaDetalleRepository.obtenerImpuestoSumProc(codigo);
    }

    public List<ImpuestoNota> obtenerImpuestoNotaTarifas(Long codigo) {
        return this.facturaNotaDetalleRepository.obtenerImpuestoNotatarifas(codigo);
    }

    public List<NotasElectronicas> listadoNotasAll(String numero, String fechaI, String fechaF) {
        return this.facturaNotaRepository.findAllNotas(numero, fechaI, fechaF);
    }

    public List<NotasElectronicas> listadoNotasErrorSuccess(String numero, String fechaI, String fechaF, String responseEstado) {
        return this.facturaNotaRepository.findByErrorSuccess(numero, fechaI, fechaF, responseEstado);
    }
}
