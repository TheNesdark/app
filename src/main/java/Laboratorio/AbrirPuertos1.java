package Laboratorio;

/* JADX INFO: compiled from: JIFImportacionCombilyzer13.java */
/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/AbrirPuertos1.class */
class AbrirPuertos1 implements Runnable {
    private JIFImportacionCombilyzer13 xjifimporta;

    public AbrirPuertos1(JIFImportacionCombilyzer13 jifimport) {
        this.xjifimporta = jifimport;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (JIFImportacionCombilyzer13.xestado) {
            JIFImportacionCombilyzer13.mAbirPuerto();
            try {
                Thread.sleep(20000L);
                System.out.println("Desperto");
            } catch (InterruptedException e) {
                System.out.println("Ocurrio un error en el hilo");
            }
        }
    }
}
