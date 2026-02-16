package Utilidades.Interceptores;

import Acceso.Principal;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.trazabilidad.DetalleProcesoDTO;
import com.genoma.plus.dto.trazabilidad.TrazabilidadProcesoDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Interceptores/InterceptorManager.class */
public class InterceptorManager {
    public static void interceptarAccion(Long idIngreso, DetalleProcesoDTO detalleProcesoDTO) {
        Metodos metodos = new Metodos();
        MetodosGenericos<Long> metodosGenericos = new MetodosGenericos<>();
        new TrazabilidadProcesoDTO();
        RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("100", "findByIdIngresoTrazabilidad");
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(idIngreso);
        System.out.println("fullurl --- " + fullUrl);
        Response response = metodos.getResteasyClient().target(fullUrl).request().get();
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                TrazabilidadProcesoDTO trazabilidadProcesoDTO = (TrazabilidadProcesoDTO) metodos.getMapper().readValue(metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<TrazabilidadProcesoDTO>() { // from class: Utilidades.Interceptores.InterceptorManager.1
                });
                response.close();
                metodos.getResteasyClient().close();
                if (trazabilidadProcesoDTO.getId() != null) {
                    trazabilidadProcesoDTO.getDetalleProcesos().add(detalleProcesoDTO);
                    grabar(trazabilidadProcesoDTO);
                } else {
                    List<DetalleProcesoDTO> list = new ArrayList<>();
                    list.add(detalleProcesoDTO);
                    trazabilidadProcesoDTO = TrazabilidadProcesoDTO.builder().fecha(LocalDateTime.now()).idIngreso(idIngreso).idModulo(Principal.informacionGeneralPrincipalDTO.getIdModulo()).detalleProcesos(list).build();
                    grabar(trazabilidadProcesoDTO);
                }
                System.out.println("printer : " + metodos.getMapper().writeValueAsString(trazabilidadProcesoDTO));
            } catch (JsonProcessingException e) {
                Logger.getLogger(InterceptorManager.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    protected static void grabar(TrazabilidadProcesoDTO trazabilidadProcesoDTO) {
        try {
            Metodos metodos = new Metodos();
            RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("100", "saveInterceptor");
            Response response = metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(metodos.getMapper().writeValueAsString(trazabilidadProcesoDTO)));
            response.close();
            metodos.getResteasyClient().close();
        } catch (JsonProcessingException e) {
            Logger.getLogger(InterceptorManager.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public static TrazabilidadProcesoDTO getTrazabilidadProcesoDTO(Long idIngreso) {
        Metodos metodos = new Metodos();
        MetodosGenericos<Long> metodosGenericos = new MetodosGenericos<>();
        TrazabilidadProcesoDTO trazabilidadProcesoDTO = new TrazabilidadProcesoDTO();
        RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("100", "findByIdIngresoTrazabilidad");
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(idIngreso);
        System.out.println("fullurl --- " + fullUrl);
        Response response = metodos.getResteasyClient().target(fullUrl).request().get();
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                trazabilidadProcesoDTO = (TrazabilidadProcesoDTO) metodos.getMapper().readValue(metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<TrazabilidadProcesoDTO>() { // from class: Utilidades.Interceptores.InterceptorManager.2
                });
                response.close();
                metodos.getResteasyClient().close();
            } catch (JsonProcessingException e) {
                Logger.getLogger(InterceptorManager.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
        return trazabilidadProcesoDTO;
    }
}
