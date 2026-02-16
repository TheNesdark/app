package Laboratorio;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerUtils;
import org.quartz.impl.StdSchedulerFactory;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/TareaAgendaLaboratorio.class */
public class TareaAgendaLaboratorio {
    private Scheduler horario;

    private void crearProgramacion() {
        try {
            this.horario = new StdSchedulerFactory().getScheduler();
            this.horario.start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void FinalizaTarea() {
        try {
            System.out.println("------------Tarea Agenda Finalizada------------");
            this.horario.standby();
        } catch (SchedulerException e) {
            Logger.getLogger(TareaAgendaLaboratorio.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void iniciarTarea() {
        System.out.println("------------iniciarTarea------------");
        crearProgramacion();
        JobDetail job = new JobDetail("TareaBuscarPacienteAgendaEnfermeria", (String) null, TareaAgendaLabotatorioImplementacion.class);
        Trigger trigger = TriggerUtils.makeSecondlyTrigger(30);
        trigger.setStartTime(new Date());
        trigger.setName("AgendaCadaSeisSegundosEnf");
        try {
            this.horario.scheduleJob(job, trigger);
        } catch (SchedulerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
