package Utilidades;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/ConvertirBytesArrayAArchivo.class */
public class ConvertirBytesArrayAArchivo {
    private Metodos metodos = new Metodos();

    public boolean crearArchivo(byte[] fileArray, String ruta) {
        boolean rpta;
        try {
            byte[] pdfbytes = fileArray;
            InputStream pdf = new ByteArrayInputStream(pdfbytes);
            int peso = pdf.available();
            byte[] pdfb = new byte[peso];
            pdf.read(pdfb, 0, peso);
            OutputStream salida = new FileOutputStream(this.metodos.getDirectorioExportacion() + "soporte.pdf");
            salida.write(pdfb);
            System.out.println("//home//cristian//NetBeansProjects//GenomaP//soporte.pdf");
            rpta = true;
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            rpta = false;
        }
        return rpta;
    }
}
