package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/AgendaProcedimientoTarea_ImplementacionEnfermeria.class */
public class AgendaProcedimientoTarea_ImplementacionEnfermeria implements Job {
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (Principal.claseenfer.agendProcedimiento != null) {
            Principal.claseenfer.agendProcedimiento.cargarDatos();
        }
    }
}
