package Utilidades;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/MetodosGenericos.class */
public class MetodosGenericos<T> {
    Metodos metodos = new Metodos();

    public String getParametrosEncryptado(T t) {
        String parameter = "";
        try {
            String json1 = this.metodos.getMapper().writeValueAsString(t);
            parameter = Base64.getEncoder().encodeToString(json1.getBytes());
            return parameter;
        } catch (JsonProcessingException e) {
            Logger.getLogger(MetodosGenericos.class.getName()).log(Level.SEVERE, (String) null, e);
            return parameter;
        }
    }

    public String getParametrosEncryptadoDatoUnico(long valor) {
        String parameter = "";
        try {
            String valorString = String.valueOf(valor);
            parameter = Base64.getEncoder().encodeToString(valorString.getBytes());
            return parameter;
        } catch (Exception ex) {
            Logger.getLogger(MetodosGenericos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            return parameter;
        }
    }
}
