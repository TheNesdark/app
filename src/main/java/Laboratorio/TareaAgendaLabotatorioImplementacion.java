package Laboratorio;

import Acceso.Principal;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/TareaAgendaLabotatorioImplementacion.class */
public class TareaAgendaLabotatorioImplementacion implements Job {
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (Principal.claselab.xjifagenda != null && Principal.claselab.xjifagenda.txtFecha.getDate() != null && !Principal.claselab.xjifagenda.txtFecha.getDate().toString().isEmpty()) {
            if (Principal.claselab.xjifagenda.xmodelo != null) {
                Principal.claselab.xjifagenda.mAgendaAmbulatoria();
            }
            if (Principal.claselab.xjifagenda.xmodelo1 != null) {
                Principal.claselab.xjifagenda.mAgendaUrgencias_Hospitalizacion();
            }
        }
    }
}
