package Utilidades;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/* JADX INFO: compiled from: Email.java */
/* JADX INFO: loaded from: GenomaP.jar:Utilidades/SMTPAuthentication.class */
class SMTPAuthentication extends Authenticator {
    SMTPAuthentication() {
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("nombre_de_usuario", "clave");
    }
}
