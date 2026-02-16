package Inventarios;

/* JADX INFO: compiled from: JIFIAgenda_Cirugia.java */
/* JADX INFO: loaded from: GenomaP.jar:Inventarios/mRefrescarAgenda2.class */
class mRefrescarAgenda2 implements Runnable {
    private JIFIAgenda_Cirugia frmAgenda;
    public boolean xvalor = true;

    public mRefrescarAgenda2(JIFIAgenda_Cirugia agenda) {
        this.frmAgenda = agenda;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.xvalor) {
            if (this.frmAgenda.xmodelo != null && this.frmAgenda.JDCFechaI.getDate() != null) {
                this.frmAgenda.mCargarDatos();
            }
            try {
                Thread.sleep(20000L);
            } catch (InterruptedException e) {
            }
        }
    }
}
