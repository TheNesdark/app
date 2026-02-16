package Citas;

/* JADX INFO: compiled from: CitaTerapia.java */
/* JADX INFO: loaded from: GenomaP.jar:Citas/hiloCitasT.class */
class hiloCitasT extends Thread {
    CitaTerapia frmCitasT;

    public hiloCitasT(CitaTerapia frm) {
        this.frmCitasT = frm;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            this.frmCitasT.revisarCita();
            try {
                Thread.sleep(800000L);
            } catch (InterruptedException e) {
            }
        }
    }
}
