package Utilidades.Interceptores;

import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Interceptores/InteceptorOrdenamientoMedico.class */
public class InteceptorOrdenamientoMedico {
    public static void grabar(OrdenamientoMedico medico) {
        try {
            Metodos metodos = new Metodos();
            System.out.println("DATA::\n\n" + metodos.getMapper().writeValueAsString(medico));
            RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("100", "registroOrdenameintoMedico");
            Response response = metodos.getResteasyClient().target(microserviciosDomain.getUrlRecurso()).request().post(Entity.json(metodos.getMapper().writeValueAsString(medico)));
            response.close();
            metodos.getResteasyClient().close();
        } catch (JsonProcessingException e) {
            Logger.getLogger(InteceptorOrdenamientoMedico.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }
}
