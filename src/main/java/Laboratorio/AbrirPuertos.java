package Laboratorio;

/* JADX INFO: compiled from: JIFImportacion.java */
/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/AbrirPuertos.class */
class AbrirPuertos implements Runnable {
    private JIFImportacion xjifimporta;

    public AbrirPuertos(JIFImportacion jifimport) {
        this.xjifimporta = jifimport;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (JIFImportacion.xestado) {
            JIFImportacion.mAbirPuerto();
            try {
                Thread.sleep(20000L);
                System.out.println("Desperto");
            } catch (InterruptedException e) {
                System.out.println("Ocurrio un error en el hilo");
            }
        }
    }
}
