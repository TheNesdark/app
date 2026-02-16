package Utilidades;

import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/SSLUtil.class */
public class SSLUtil {
    public static CloseableHttpClient createHttpClientWithoutSSLVerification() throws Exception {
        SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial((chain, authType) -> {
            return true;
        }).build();
        return HttpClientBuilder.create().setSSLContext(sslContext).setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();
    }
}
