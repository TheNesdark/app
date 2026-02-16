package Enfermeria;

import Acceso.Principal;

/* JADX INFO: compiled from: JIFAgenda_UH.java */
/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/mRefrescarAgenda.class */
class mRefrescarAgenda implements Runnable {
    private JIFAgenda_UH frmAgenda;
    public boolean xvalor = true;

    public mRefrescarAgenda(JIFAgenda_UH agenda) {
        this.frmAgenda = agenda;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.xvalor) {
            if (this.frmAgenda.xmodelo != null && this.frmAgenda.JDCFecha.getDate() != null && Principal.claseenfer.xjifagenda_UH != null) {
                this.frmAgenda.mCargarDatos();
                this.frmAgenda.mCargarDatos_Cx();
            }
            try {
                Thread.sleep(20000L);
            } catch (InterruptedException e) {
            }
        }
    }
}
