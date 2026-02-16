package Utilidades;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/ConnectionManager.class */
public class ConnectionManager {
    private static Connection conexion;

    private ConnectionManager() {
    }

    /* JADX WARN: Finally extract failed */
    public static Connection iniciarConexionBaseDatos() {
        try {
            InputStream input = ConsultasMySQL.class.getClassLoader().getResourceAsStream("recursos/jdbc.properties");
            Throwable th = null;
            try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                if (conexion == null || conexion.isClosed()) {
                    Properties prop = new Properties();
                    prop.load(input);
                    conexion = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"), prop.getProperty("jdbc.password"));
                }
                if (input != null) {
                    if (0 != 0) {
                        try {
                            input.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        input.close();
                    }
                }
            } catch (Throwable th3) {
                if (input != null) {
                    if (0 != 0) {
                        try {
                            input.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        input.close();
                    }
                }
                throw th3;
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            Logger.getLogger(ConsultasMySQL.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return conexion;
    }

    public static void cerrarConexionBaseDatos() {
        try {
            if (conexion != null || !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
