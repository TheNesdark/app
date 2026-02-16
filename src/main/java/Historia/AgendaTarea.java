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

/* JADX INFO: loaded from: GenomaP.jar:Historia/AgendaTarea.class */
public class AgendaTarea {
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
        crearProgramacion();
        JobDetail job = new JobDetail("TareaBuscarPacienteAgenda", (String) null, AgendaTarea_Implementacion.class);
        Trigger trigger = TriggerUtils.makeSecondlyTrigger(30);
        trigger.setStartTime(new Date());
        trigger.setName("AgendaCadaSeisSegundos");
        try {
            this.horario.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
        }
    }
}
