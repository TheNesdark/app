package com.genoma.plus.controller.integracion_simedis;

import Acceso.Principal;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/AgendaTarea_ImplementacionSimedis.class */
public class AgendaTarea_ImplementacionSimedis implements Job {
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (Principal.clasefacturacion.agendaSimedis != null) {
            if (!Principal.clasefacturacion.agendaSimedis.JTFNombre.getText().isEmpty()) {
                Principal.clasefacturacion.agendaSimedis.cargarDatos(true);
            } else {
                Principal.clasefacturacion.agendaSimedis.cargarDatos(false);
            }
        }
    }
}
