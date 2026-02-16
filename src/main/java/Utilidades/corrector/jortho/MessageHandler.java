package Utilidades.corrector.jortho;

import java.awt.Container;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/MessageHandler.class */
public interface MessageHandler {
    void handleError(String str, String str2, Throwable th);

    void handleException(Throwable th);

    void handleInformation(Container container, String str, String str2);
}
