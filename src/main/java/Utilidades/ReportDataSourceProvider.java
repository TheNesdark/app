package Utilidades;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JsonDataSource;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/ReportDataSourceProvider.class */
public class ReportDataSourceProvider {
    public static JRDataSource getDataSource(String apiUrl) throws Exception {
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        if (connection.getResponseCode() == 200) {
            InputStream inputStream = connection.getInputStream();
            return new JsonDataSource(inputStream);
        }
        throw new RuntimeException("Error al obtener datos de la API: " + connection.getResponseCode());
    }
}
