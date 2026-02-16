package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.laboratorio.dto.InfoAlertaTiempoRecepcionesDTO;
import com.genoma.plus.controller.laboratorio.dto.infoAlertaRececion;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.ws.rs.core.Response;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/TareaOrdenesPendientePorValidar.class */
public class TareaOrdenesPendientePorValidar implements Job {
    ConsultasMySQL xct = new ConsultasMySQL();
    Metodos metodos = new Metodos();
    long miVariableLong = 0;

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue() && getCantidadOrdenes() > 0) {
            Principal.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/campana_alerta.gif")));
            Principal.btnCancelar.setVisible(true);
            Principal.btnCancelar.setText("" + getCantidadOrdenes());
        }
    }

    private int getCantidadOrdenes() {
        int nRegistros = 0;
        try {
            Metodos metodos = new Metodos();
            MetodosGenericos<infoAlertaRececion> metodosGenericos = new MetodosGenericos<>();
            new ArrayList();
            RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("24", "TareaOrdenesPendientePorValidar");
            Date fechaActual = metodos.getFechaActual();
            if (fechaActual == null) {
                fechaActual = new Date();
            }
            infoAlertaRececion date = infoAlertaRececion.builder().fechaRecepcion(metodos.formatoAMD.format(fechaActual)).fechaRecepcionFinal("").nombreUsuario("").documento("").idRecepcion(Long.valueOf(this.miVariableLong)).diferenciaTiempo("").sexo("").procedimiento("").documento("").build();
            if (microserviciosDomain == null) {
                Logger.getLogger(TareaOrdenesPendientePorValidar.class.getName()).log(Level.SEVERE, "microserviciosDomain es null");
                return 0;
            }
            String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(date);
            System.out.println("fullurlSql --- " + fullUrl);
            Response response = metodos.getResteasyClient().target(fullUrl).request().get();
            int statusCode = response.getStatus();
            if (statusCode == 200) {
                try {
                    CustomPresenter presenter = (CustomPresenter) metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    List<InfoAlertaTiempoRecepcionesDTO> recepcionesDTOs = (List) metodos.getMapper().readValue(metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<InfoAlertaTiempoRecepcionesDTO>>() { // from class: Laboratorio.TareaOrdenesPendientePorValidar.1
                    });
                    nRegistros = recepcionesDTOs.size();
                } catch (JsonProcessingException e) {
                    Logger.getLogger(TareaOrdenesPendientePorValidar.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e);
                }
            } else {
                Logger.getLogger(TareaOrdenesPendientePorValidar.class.getName()).log(Level.WARNING, "HTTP Response Code: " + statusCode);
            }
        } catch (Exception ex) {
            Logger.getLogger(TareaOrdenesPendientePorValidar.class.getName()).log(Level.SEVERE, "Error en getCantidadOrdenes", (Throwable) ex);
        }
        return nRegistros;
    }
}
