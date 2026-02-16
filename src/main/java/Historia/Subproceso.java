package Historia;

import Acceso.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: JIFAgendaMedico.java */
/* JADX INFO: loaded from: GenomaP.jar:Historia/Subproceso.class */
class Subproceso implements Runnable {
    public static int numero = 0;
    private boolean activo = true;

    @Override // java.lang.Runnable
    public void run() {
        while (isActivo()) {
            try {
                JIFAgendaMedico.mCargarDatos();
                JIFAgendaMedico.mCargarDatosCNP();
                JIFAgendaMedico.mEStadoAtenciones();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    Thread.sleep(4000L);
                } else {
                    Thread.sleep(6000L);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Subproceso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public boolean isActivo() {
        return this.activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setStop() {
        this.activo = false;
    }

    public void mostrar() {
    }
}
