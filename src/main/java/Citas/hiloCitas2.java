package Citas;

/* JADX INFO: compiled from: CitasGral.java */
/* JADX INFO: loaded from: GenomaP.jar:Citas/hiloCitas2.class */
class hiloCitas2 extends Thread {
    CitasGral frmCitas;

    public hiloCitas2(CitasGral frm) {
        this.frmCitas = frm;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            this.frmCitas.revisarCita();
            try {
                Thread.sleep(800000L);
            } catch (InterruptedException e) {
            }
        }
    }
}
