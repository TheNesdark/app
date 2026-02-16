package Historia;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/TareaSeguimiento.class */
public class TareaSeguimiento {
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
            Logger.getLogger(TareaSeguimiento.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void iniciarTarea() {
        if (this.horario == null) {
            crearProgramacion();
        }
        JobDetail job = new JobDetail("TareaBuscarSeguimientos", (String) null, TareaSeguimientos_Implementacion.class);
        Trigger trigger = TriggerUtils.makeMinutelyTrigger(5);
        trigger.setStartTime(new Date());
        trigger.setName("CadaCincoSegundos");
        try {
            this.horario.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
        }
    }
}
