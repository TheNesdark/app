package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/AgendaTarea_ImplementacionEnfermeria.class */
public class AgendaTarea_ImplementacionEnfermeria implements Job {
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (Principal.claseenfer.agendaServicioEnfermeria != null) {
            Principal.claseenfer.agendaServicioEnfermeria.cargarDatos();
        }
    }
}
