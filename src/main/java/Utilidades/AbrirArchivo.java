package Utilidades;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/AbrirArchivo.class */
public class AbrirArchivo {
    private Metodos metodos;

    public boolean abrirArchivo(String nombreArchivo) {
        boolean rpta;
        try {
            System.out.println(this.metodos.getDirectorioExportacion());
            File path = new File(this.metodos.getDirectorioExportacion() + nombreArchivo);
            Desktop.getDesktop().open(path);
            rpta = true;
        } catch (IOException ex) {
            rpta = false;
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            System.out.println(ex);
        }
        return rpta;
    }
}
