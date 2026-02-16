package Historia;

import Acceso.Principal;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* JADX INFO: loaded from: GenomaP.jar:Historia/AgendaTarea_Implementacion.class */
public class AgendaTarea_Implementacion implements Job {
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (Principal.clasehistoriace.historia_Clinica_v2 != null) {
            Principal.clasehistoriace.historia_Clinica_v2.cargarDatos();
        }
    }
}
