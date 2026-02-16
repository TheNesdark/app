package Inventarios;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: JIFFormulacionMedica.java */
/* JADX INFO: loaded from: GenomaP.jar:Inventarios/Subproceso.class */
class Subproceso implements Runnable {
    public static int numero = 0;
    private boolean activo = true;

    @Override // java.lang.Runnable
    public void run() {
        while (isActivo()) {
            try {
                JIFFormulacionMedica.mCargarDatosTabla();
                Thread.sleep(4000L);
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

    public void mostrar() {
    }
}
