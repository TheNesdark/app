package UtilidadesMetodosHttp;

import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:UtilidadesMetodosHttp/MetodosHttp.class */
public class MetodosHttp {
    private final Metodos metodos = new Metodos();

    public <T, R> T postRequest(Class<T> cls, R r, String str, String str2) {
        try {
            try {
                Response responsePost = this.metodos.getResteasyClient().target(this.metodos.getParametrosEncriptados(str, str2).getUrlRecurso()).request().post(Entity.json(this.metodos.getMapper().writeValueAsString(r)));
                Throwable th = null;
                try {
                    try {
                        T t = (T) this.metodos.getMapper().convertValue(((CustomPresenter) this.metodos.getMapper().readValue((String) responsePost.readEntity(String.class), CustomPresenter.class)).getData(), cls);
                        if (responsePost != null) {
                            if (0 != 0) {
                                try {
                                    responsePost.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                responsePost.close();
                            }
                        }
                        this.metodos.getResteasyClient().close();
                        return t;
                    } catch (Throwable th3) {
                        if (responsePost != null) {
                            if (th != null) {
                                try {
                                    responsePost.close();
                                } catch (Throwable th4) {
                                    th.addSuppressed(th4);
                                }
                            } else {
                                responsePost.close();
                            }
                        }
                        throw th3;
                    }
                } finally {
                }
            } catch (JsonProcessingException | IllegalArgumentException | NullPointerException e) {
                Logger.getLogger(MetodosHttp.class.getName()).log(Level.SEVERE, "Error en postRequest", e);
                this.metodos.getResteasyClient().close();
                return null;
            }
        } catch (Throwable th5) {
            this.metodos.getResteasyClient().close();
            throw th5;
        }
    }
}
