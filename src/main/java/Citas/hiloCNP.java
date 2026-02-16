package Citas;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: CitaNP.java */
/* JADX INFO: loaded from: GenomaP.jar:Citas/hiloCNP.class */
class hiloCNP extends Thread {
    private CitaNP citanp;

    public hiloCNP(CitaNP cita) {
        this.citanp = cita;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.citanp.hiloEvaluador();
        try {
            Thread.sleep(8000L);
        } catch (InterruptedException ex) {
            Logger.getLogger(hiloCNP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
