package com.genoma.plus.controller.tipoDocumentoEmpresa;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/* JADX INFO: compiled from: NotificacionEmail.java */
/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/tipoDocumentoEmpresa/SMTPAuthentication.class */
class SMTPAuthentication extends Authenticator {
    SMTPAuthentication() {
    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("nombre_de_usuario", "clave");
    }
}
