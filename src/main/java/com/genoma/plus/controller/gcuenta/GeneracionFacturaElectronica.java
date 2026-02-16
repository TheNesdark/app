package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Laboratorio.TareaOrdenesPendientePorValidar;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import co.com.genomaempresarial.healthbilladapter.usecase.HealthBillingRequester;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.jpa.entities.NotificacionResponseDTO;
import com.genoma.plus.jpa.repository.IFacturaElectronicaRespository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/GeneracionFacturaElectronica.class */
@Transactional
@Service
public class GeneracionFacturaElectronica {

    @Autowired
    private IFacturaElectronicaRespository repository;

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consulta = new ConsultasMySQL();

    public void generacionFacturaEventoSalud(String numeroFactura, Integer forma, Boolean reenvio, List<Adjunto> adjuntos) {
        String end_point = Principal.informacionIps.getEndPointFacturaElectronica() + "/factura/salud/";
        String str = Principal.informacionIps.getEndPointFacturaElectronica() + "/factura/pdf/";
        String str2 = Principal.informacionIps.getEndPointFacturaElectronica() + "/recursos/";
        ParametrosFacturaElectronica electronica = ParametrosFacturaElectronica.builder().numeroFactura(numeroFactura).reenviado(false).build();
        MetodosGenericos<ParametrosFacturaElectronica> metodosGenericos = new MetodosGenericos<>();
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "facturaElectronica");
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(electronica);
        System.out.println("fullurlSql --- " + fullUrl);
        Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                HealthBillingRequester requester = (HealthBillingRequester) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), HealthBillingRequester.class);
                System.out.println("date : " + this.metodos.getMapper().writeValueAsString(requester));
                new NotificacionResponseDTO();
                NotificacionResponseDTO response1 = (NotificacionResponseDTO) this.restTemplate.postForObject(end_point, requester, NotificacionResponseDTO.class, new Object[0]);
                updateEstadoFacturaEvento(response1, numeroFactura);
            } catch (JsonProcessingException e) {
                Logger.getLogger(TareaOrdenesPendientePorValidar.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e);
            }
        }
    }

    private void updateEstadoFacturaEvento(NotificacionResponseDTO response1, String numeroFactura) {
        String sql = "UPDATE\n  f_factura_evento\nSET\n  responseMensaje =IF(responseMensaje  IS NULL,'" + response1.getMensaje() + "', IF(responseMensaje<>'La factura ha sido registrada con éxito.', '" + response1.getMensaje() + "' , responseMensaje))\n  ,EstaArmada = IF(EstaArmada=2, 2, 1),\n  responseEstado = IF(responseEstado IS NULL,'" + response1.getEstado() + "', IF(responseEstado<>'SUCCESS','" + response1.getEstado() + "',responseEstado)) , pdf= '" + response1.getRespuesta().toString() + "'\nWHERE No_FacturaEvento = '" + numeroFactura + "'";
        System.out.println("" + sql);
        this.consulta.ejecutaSQLUpdate(sql);
        this.consulta.cerrarConexionBd();
    }
}
