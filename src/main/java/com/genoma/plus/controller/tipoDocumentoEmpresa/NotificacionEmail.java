package com.genoma.plus.controller.tipoDocumentoEmpresa;

import Acceso.Principal;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/tipoDocumentoEmpresa/NotificacionEmail.class */
public class NotificacionEmail {
    private String host;
    private String from;
    private String to;
    private Properties prop = new Properties();
    private SMTPAuthentication auth = new SMTPAuthentication();
    private Session session = Session.getInstance(this.prop, this.auth);
    private Message msg;

    public void enviarAdjunto(String destino, String cuerpo, String remite, String asunto, String ruta, String documento) {
        try {
            System.out.println("destino : " + destino);
            System.out.println("cuerpo : " + cuerpo);
            System.out.println("remite  : " + remite);
            System.out.println("asunto  : " + asunto);
            System.out.println("ruta  : " + ruta);
            System.out.println("documento  : " + documento);
            Properties datos = new Properties();
            datos.setProperty("mail.smtp.host", "mail.fundacionpanzenu.org.co");
            datos.setProperty("mail.smtp.starttls.enable", "false");
            datos.setProperty("mail.smtp.port", "25");
            datos.setProperty("mail.smtp.user", "sistemas");
            datos.setProperty("mail.smtps.auth", "false");
            Session session1 = Session.getDefaultInstance(datos, (Authenticator) null);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(cuerpo);
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(documento)));
            mimeBodyPart2.setFileName(ruta);
            MimeMultipart correo = new MimeMultipart();
            correo.addBodyPart(mimeBodyPart);
            correo.addBodyPart(mimeBodyPart2);
            MimeMessage mensaje = new MimeMessage(session1);
            mensaje.setFrom(new InternetAddress(remite));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            mensaje.setSubject(asunto);
            mensaje.setContent(correo);
            Transport t = session1.getTransport("smtp");
            t.connect("sistemas", "Panzenu1");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            Logger.getLogger(NotificacionEmail.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void enviarAdjunto(String[] destino, String cuerpo, String remite, String asunto, String ruta, String documento) {
        try {
            Properties datos = new Properties();
            datos.setProperty("mail.smtp.host", "mail.fundacionpanzenu.org.co");
            datos.setProperty("mail.smtp.starttls.enable", "false");
            datos.setProperty("mail.smtp.port", "25");
            datos.setProperty("mail.smtp.user", "noresponder");
            datos.setProperty("mail.smtps.auth", "false");
            Session session1 = Session.getDefaultInstance(datos, (Authenticator) null);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(cuerpo);
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(documento)));
            mimeBodyPart2.setFileName(ruta);
            MimeMultipart correo = new MimeMultipart();
            correo.addBodyPart(mimeBodyPart);
            correo.addBodyPart(mimeBodyPart2);
            MimeMessage mensaje = new MimeMessage(session1);
            mensaje.setFrom(new InternetAddress(remite));
            InternetAddress[] addressTo = new InternetAddress[destino.length];
            for (int x = 0; x < destino.length; x++) {
                addressTo[x] = new InternetAddress(destino[x]);
            }
            mensaje.setRecipients(Message.RecipientType.TO, addressTo);
            mensaje.setSubject(asunto);
            mensaje.setContent(correo);
            Transport t = session1.getTransport("smtp");
            t.connect("noresponder", "Panzenu1*");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            Logger.getLogger(NotificacionEmail.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void enviarAdjuntoPajonal(String[] destino, String cuerpo, String remite, String asunto, String ruta, String documento) {
        try {
            Properties datos = new Properties();
            datos.setProperty("mail.smtp.host", "smtp.gmail.com");
            datos.setProperty("mail.smtp.starttls.enable", "true");
            datos.setProperty("mail.smtp.port", "587");
            datos.setProperty("mail.smtp.user", "noresponder@clinicapajonal.com");
            datos.setProperty("mail.smtps.auth", "true");
            datos.setProperty("mail.smtp.password", "GenomaPlus1!");
            Session session1 = Session.getDefaultInstance(datos, (Authenticator) null);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(cuerpo);
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(documento)));
            mimeBodyPart2.setFileName(ruta);
            MimeMultipart correo = new MimeMultipart();
            correo.addBodyPart(mimeBodyPart);
            correo.addBodyPart(mimeBodyPart2);
            MimeMessage mensaje = new MimeMessage(session1);
            mensaje.setFrom(new InternetAddress(remite));
            InternetAddress[] addressTo = new InternetAddress[destino.length];
            for (int x = 0; x < destino.length; x++) {
                addressTo[x] = new InternetAddress(destino[x]);
            }
            mensaje.setRecipients(Message.RecipientType.TO, addressTo);
            mensaje.setSubject(asunto);
            mensaje.setContent(correo);
            Transport t = session1.getTransport("smtp");
            t.connect("noresponder@clinicapajonal.com", "GenomaPlus1!");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            Logger.getLogger(NotificacionEmail.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void enviarAdjunto(String destino, String cuerpo, String remite, String asunto, String ruta, String documento, String xvarios) {
        try {
            Properties datos = new Properties();
            datos.setProperty("mail.smtp.host", "mail.fundacionpanzenu.org.co");
            datos.setProperty("mail.smtp.starttls.enable", "false");
            datos.setProperty("mail.smtp.port", "25");
            datos.setProperty("mail.smtp.user", "sistemas");
            datos.setProperty("mail.smtps.auth", "false");
            Session session1 = Session.getDefaultInstance(datos, (Authenticator) null);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(cuerpo);
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(documento)));
            mimeBodyPart2.setFileName(ruta);
            System.out.println("Ruta : " + ruta);
            System.out.println(documento);
            MimeMultipart correo = new MimeMultipart();
            correo.addBodyPart(mimeBodyPart);
            correo.addBodyPart(mimeBodyPart2);
            MimeMessage mensaje = new MimeMessage(session1);
            mensaje.setFrom(new InternetAddress(remite));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            mensaje.setSubject(asunto);
            mensaje.setContent(correo);
            Transport t = session1.getTransport("smtp");
            t.connect("sistemas", "Panzenu1");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            Logger.getLogger(NotificacionEmail.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public boolean Send(String para, String mensaje, String correo, String asunto) {
        boolean rpta = true;
        try {
            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                this.host = "mail.fundacionpanzenu.org.co";
                this.from = para;
                this.to = correo;
                this.prop.put("mail.smtp.host", this.host);
                this.prop.put("mail.smtp.auth", "false");
                this.msg = getMessage(this.session, this.from, this.to, mensaje);
                this.msg.setSubject(asunto);
                Transport.send(this.msg);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                this.host = "mail.hospitalmontelibano.gov.co";
                this.from = para;
                this.to = correo;
                this.prop.put("mail.smtp.host", this.host);
                this.prop.put("mail.smtp.user", "calidadhlm");
                this.prop.put("mail.smtp.auth", "true");
                this.msg = getMessage(this.session, this.from, this.to, mensaje);
                this.msg.setSubject(asunto);
                Transport t = this.session.getTransport("smtp");
                t.connect("calidadhlm@hospitalmontelibano.gov.co", "calidad2016");
                t.sendMessage(this.msg, this.msg.getAllRecipients());
            } else if (Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
                this.host = "smtp.gmail.com";
                this.from = para;
                this.to = correo;
                this.prop.put("mail.smtp.host", this.host);
                this.prop.put("mail.smtp.user", "cambiatuvidaw51h@gmail.com");
                this.prop.put("mail.smtp.auth", "true");
                this.msg = getMessage(this.session, this.from, this.to, mensaje);
                this.msg.setSubject(asunto);
                Transport t2 = this.session.getTransport("smtp");
                t2.connect("cambiatuvidaw51h@gmail.com", "Cambiatuvida2017");
                t2.sendMessage(this.msg, this.msg.getAllRecipients());
            } else if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
                this.host = "smtp.gmail.com";
                this.from = para;
                this.to = correo;
                this.prop.put("mail.smtp.host", this.host);
                this.prop.put("mail.smtp.user", "calidadsoaips@gmail.com");
                this.prop.put("mail.smtp.auth", "true");
                this.msg = getMessage(this.session, this.from, this.to, mensaje);
                this.msg.setSubject(asunto);
                Transport t3 = this.session.getTransport("smtp");
                t3.connect("calidadsoaips@gmail.com", "soaips2017");
                t3.sendMessage(this.msg, this.msg.getAllRecipients());
            } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S")) {
                rpta = enviarConGMail(correo, asunto, mensaje, "lidercalidad.labvy@gmail.com", "lidercalidad");
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
                rpta = enviarConGMail(para, asunto, mensaje, "noresponder@clinicapajonal.com", "GenomaPlus1!");
            }
        } catch (Exception e) {
            ExceptionManager.ManageException(e);
            rpta = false;
        }
        return rpta;
    }

    private boolean enviarConGMail(String destinatario, String asunto, String cuerpo, String remitente, String contrasena) {
        try {
            System.out.println("Para: " + destinatario);
            System.out.println("from: " + remitente);
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.password", contrasena);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", "587");
            Session n = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(n);
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = n.getTransport("smtp");
            Throwable th = null;
            try {
                transport.connect("smtp.gmail.com", remitente, contrasena);
                transport.sendMessage(message, message.getAllRecipients());
                if (transport != null) {
                    if (0 != 0) {
                        try {
                            transport.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        transport.close();
                    }
                }
                return true;
            } finally {
            }
        } catch (AddressException e) {
            Logger.getLogger(NotificacionEmail.class.getName()).log(Level.SEVERE, (String) null, e);
            return false;
        } catch (MessagingException e2) {
            Logger.getLogger(NotificacionEmail.class.getName()).log(Level.SEVERE, (String) null, e2);
            return false;
        }
    }

    public boolean Send(String para, String mensaje, String correo, String tipo, String adjunto) {
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            this.host = "mail.fundacionpanzenu.org.co";
            this.from = para;
            this.to = correo;
            this.prop.put("mail.smtp.host", this.host);
            this.prop.put("mail.smtp.auth", "false");
        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.host = "mail.hospitalmontelibano.gov.co";
            this.from = para;
            this.to = correo;
            this.prop.put("mail.smtp.host", this.host);
            this.prop.put("mail.smtp.auth", "false");
        } else {
            this.from = para;
            this.to = correo;
            this.prop.put("mail.smtp.host", this.host);
            this.prop.put("mail.smtp.auth", "true");
        }
        try {
            this.msg = getMessage(this.session, this.from, this.to, mensaje);
            this.msg.setSubject(tipo);
            Transport.send(this.msg);
            return true;
        } catch (Exception e) {
            ExceptionManager.ManageException(e);
            return false;
        }
    }

    private static MimeMessage getMessage(Session session, String from, String to, String xmensajee) {
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setText(xmensajee);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setFrom(new InternetAddress(from, from));
            return msg;
        } catch (MessagingException ex) {
            ExceptionManager.ManageException(ex);
            return null;
        } catch (UnsupportedEncodingException ex2) {
            ExceptionManager.ManageException(ex2);
            return null;
        }
    }
}
