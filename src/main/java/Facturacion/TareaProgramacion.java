package Facturacion;

import Citas.tareaCitasSinFacturar;
import Laboratorio.TareaOrdenesPendientePorValidar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/TareaProgramacion.class */
public class TareaProgramacion {
    private Scheduler horario;

    private void crearProgramacion() {
        try {
            this.horario = new StdSchedulerFactory().getScheduler();
            this.horario.start();
        } catch (Exception e) {
        }
    }

    public void FinalizaTarea() {
        try {
            this.horario.standby();
        } catch (SchedulerException e) {
            Logger.getLogger(TareaProgramacion.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void iniciarTarea(String nombre) {
        JobDetail job;
        if (this.horario == null) {
            crearProgramacion();
        }
        job = null;
        switch (nombre) {
            case "TareaBuscarLiquidaciones":
                job = new JobDetail(nombre, (String) null, TareaLiquidacion.class);
                break;
            case "formularioCitas":
                job = new JobDetail(nombre, (String) null, tareaCitasSinFacturar.class);
                break;
            case "formularioLaboratorio":
                job = new JobDetail(nombre, (String) null, TareaOrdenesPendientePorValidar.class);
                break;
        }
        Trigger trigger = TriggerUtils.makeMinutelyTrigger(5);
        trigger.setStartTime(new Date());
        trigger.setName("CadaCincoSegundos");
        try {
            this.horario.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
        }
    }
}
