package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.MetodosAlertasGenerales;
import javax.swing.ImageIcon;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/* JADX INFO: loaded from: GenomaP.jar:Historia/TareaSeguimientos_Implementacion.class */
public class TareaSeguimientos_Implementacion implements Job {
    private int i = 0;
    ConsultasMySQL xct = new ConsultasMySQL();

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        if (mNumeroSeguimiento().longValue() > 0) {
            Principal.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/campana_alerta.gif")));
            Principal.btnCancelar.setText("" + mNumeroSeguimiento());
            Principal.btnCancelar.setToolTipText("Seguimientos pendientes");
        } else {
            Principal.btnCancelar.setText("0");
            Principal.btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/campana.png")));
            Principal.btnCancelar.setToolTipText("Seguimientos pendientes");
        }
    }

    private Long mNumeroSeguimiento() {
        MetodosAlertasGenerales xmetodo = new MetodosAlertasGenerales();
        return xmetodo.mNumeroSeguimientoPendientes();
    }
}
