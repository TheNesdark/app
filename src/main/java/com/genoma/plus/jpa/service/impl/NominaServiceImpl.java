package com.genoma.plus.jpa.service.impl;

import Acceso.Principal;
import co.com.genomaempresarial.ankara.dto.NominaIndividual;
import co.com.genomaempresarial.ankara.dto.NominaIndividualDeAjuste;
import co.com.genomaempresarial.ankara.dto.NotificacionResponse;
import com.genoma.plus.jpa.entities.NotificacionResponseDTO;
import com.genoma.plus.jpa.entity.ConceptoPorEmpleado;
import com.genoma.plus.jpa.entity.EmpleadoPagoProyection;
import com.genoma.plus.jpa.entity.EmpleadoPorNomina;
import com.genoma.plus.jpa.entity.EmpleadorProyection;
import com.genoma.plus.jpa.entity.EmpleadosNomina;
import com.genoma.plus.jpa.entity.IEliminandoPredecesor;
import com.genoma.plus.jpa.entity.INumeroSecuenciaXML;
import com.genoma.plus.jpa.entity.IProveedorXml;
import com.genoma.plus.jpa.entity.LugarDeGeneracion;
import com.genoma.plus.jpa.entity.NovedadesNomina;
import com.genoma.plus.jpa.entity.TRM;
import com.genoma.plus.jpa.repository.NominaRepository;
import com.genoma.plus.jpa.service.NominaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/jpa/service/impl/NominaServiceImpl.class */
@Service("nominaService")
public class NominaServiceImpl implements NominaService {

    @Autowired
    private NominaRepository nominaRepository;
    RestTemplate restTemplate = new RestTemplate();
    private String END_POINT;

    @Override // com.genoma.plus.jpa.service.NominaService
    public List<EmpleadoPorNomina> listaEmpleadosPorNomina(Integer id) {
        return this.nominaRepository.listaEmpleados(id);
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public List<ConceptoPorEmpleado> listaConceptoEmpleado(Integer id, Integer idPersona) {
        System.out.println("id " + id + "idPersona " + idPersona);
        return this.nominaRepository.nominaPorEmpleado(id, idPersona);
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public LugarDeGeneracion lugarDeGeneracion() {
        return this.nominaRepository.lugarDeGeneracion();
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public EmpleadorProyection getEmpleador() {
        return this.nominaRepository.getEmpleador();
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public EmpleadoPagoProyection getEmpleadoPagoNomina(Integer idPersona) {
        return this.nominaRepository.getEmpleadoPago(idPersona);
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public List<EmpleadosNomina> obtenerEmpleados(String filtro) {
        return this.nominaRepository.obtenerEmpleados(filtro);
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public List<NovedadesNomina> obtenerNovedadesNomina(Integer idTercero, Integer periodo) {
        System.out.println("" + idTercero + " id " + periodo);
        return this.nominaRepository.obtenerNovedadesNomina(idTercero, periodo);
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public String enviarNomina(NominaIndividual nominaIndividual, String idLiquidacion, String idPersona) {
        this.END_POINT = Principal.informacionIps.getEndPointFacturaElectronica() + "/nomina/";
        System.out.println("prueba " + this.END_POINT);
        new NotificacionResponse();
        NotificacionResponse response = (NotificacionResponse) this.restTemplate.postForObject(this.END_POINT, nominaIndividual, NotificacionResponse.class, new Object[0]);
        if (response != null) {
            saveResponse(response, idLiquidacion, idPersona);
            System.out.println("Mensaje " + response.getMensaje());
            return response.getMensaje();
        }
        return "ocurrio un error al transmitir";
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public INumeroSecuenciaXML numeroSecuenciaXML(Integer idPersona, Integer liquidacion) {
        System.err.println("idPersona" + idPersona + " " + liquidacion);
        return this.nominaRepository.obtenerNumeroSecuenciaXML(idPersona, liquidacion);
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public IProveedorXml ObtenerProvedorXML() {
        return this.nominaRepository.obtenerProveedorXML();
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public List<EmpleadoPorNomina> listaEmpleadosPorNominaEnviadas(int id) {
        return this.nominaRepository.listaEmpleadosReportados(Integer.valueOf(id));
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public TRM getTMR(String fecha) {
        return this.nominaRepository.getTMR(fecha);
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public IEliminandoPredecesor getPredecesor(Integer idPersona, Integer liquidacion) {
        System.out.println("idPersona" + idPersona + " liquidacion " + liquidacion);
        return this.nominaRepository.getPredecesor(idPersona, liquidacion);
    }

    @Override // com.genoma.plus.jpa.service.NominaService
    public String enviarNota(NominaIndividualDeAjuste nominaIndividualDeAjuste) {
        this.END_POINT = Principal.informacionIps.getEndPointFacturaElectronica() + "/nomina-ajuste/";
        System.out.println("prueba " + this.END_POINT);
        new NotificacionResponseDTO();
        NotificacionResponseDTO response = (NotificacionResponseDTO) this.restTemplate.postForObject(this.END_POINT, nominaIndividualDeAjuste, NotificacionResponseDTO.class, new Object[0]);
        if (response != null) {
            return response.getMensaje();
        }
        return "ocurrio un error al transmitir";
    }

    private void saveResponse(NotificacionResponse response, String idLiquidacion, String idPersona) {
        this.nominaRepository.actualizarDatos(idLiquidacion, idPersona, response.getInformacionNomina().getCune(), response.getInformacionNomina().getDianKey());
    }
}
