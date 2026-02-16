package ImagenesDx;

import Utilidades.Metodos;
import java.io.File;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/RecepcionrxController.class */
public class RecepcionrxController {
    private Metodos xmt = new Metodos();

    public File crearRutaEstudioRX(String urlRX, String anio, String mes, String idOrden) {
        StringBuilder sb = new StringBuilder();
        sb.append(urlRX).append(this.xmt.getBarra()).append(anio).append(this.xmt.getBarra()).append(mes).append(this.xmt.getBarra()).append(idOrden);
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            boolean rutaCreada = file.mkdir();
            if (rutaCreada) {
            }
        }
        return file;
    }

    public File copiarArchivoDicomRutaDestino(File fileEntrada) {
        return null;
    }
}
