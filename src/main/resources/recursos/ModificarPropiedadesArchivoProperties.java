package recursos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class ModificarPropiedadesArchivoProperties {

    Properties prop = new Properties();
    InputStream is = null;
    String urlD = getClass().getResource("/recursos/jdbc.properties").getPath();

    public ModificarPropiedadesArchivoProperties() {
        
        
    }        
    public void mCambiarValores() {
        try {
            is = new FileInputStream(urlD);
            prop.load(is);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void mVerificarDatos(String[][] idDatosIps) {
        this.mCambiarValores();
        for (Enumeration e = prop.keys(); e.hasMoreElements();) {
            // Obtenemos el objeto
            Object obj = e.nextElement();
            System.out.println(obj + ": " + prop.getProperty(obj.toString()));
        }

        prop.setProperty("jdbc.url", idDatosIps[0][2]);
        prop.setProperty("jdbc.username", idDatosIps[0][3]);
        prop.setProperty("jdbc.password", idDatosIps[0][4]);
        
        for (Enumeration e = prop.keys(); e.hasMoreElements();) {
            // Obtenemos el objeto
            Object obj = e.nextElement();
            System.out.println(obj + ": " + prop.getProperty(obj.toString()));
        }
    }

    

}
