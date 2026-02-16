package Utilidades;

import Acceso.Principal;
import Historia.CorreoListener;
import com.genoma.plus.jpa.entities.GModuloCorreo;
import com.genoma.plus.jpa.entities.GServidorCorreo;
import com.genoma.plus.jpa.service.GServidorCorreoService;
import java.awt.Component;
import java.awt.Toolkit;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Email.class */
public class Email {
    private String host;
    private String from;
    private String to;
    private Message msg;
    private Properties prop = new Properties();
    private SMTPAuthentication auth = new SMTPAuthentication();
    private Session session = Session.getInstance(this.prop, this.auth);
    private final GServidorCorreoService correoService = (GServidorCorreoService) Principal.contexto.getBean(GServidorCorreoService.class);
    private List<GServidorCorreo> servidorCorreo = new ArrayList();

    public void enviarAdjunto(List<String> destino, String cuerpo, String remite, String asunto, String ruta, String documento) {
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
            MimeMultipart correo = new MimeMultipart();
            correo.addBodyPart(mimeBodyPart);
            correo.addBodyPart(mimeBodyPart2);
            MimeMessage mensaje = new MimeMessage(session1);
            mensaje.setFrom(new InternetAddress(remite));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino.get(0)));
            mensaje.setSubject(asunto);
            mensaje.setContent(correo);
            Transport t = session1.getTransport("smtp");
            t.connect("sistemas", "Panzenu1");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e);
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
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void enviarAdjuntoPajonal(List<String> destino, String cuerpo, String remite, String asunto, String ruta, String documento) {
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
            InternetAddress[] addressTo = new InternetAddress[destino.size()];
            for (int x = 0; x < destino.size(); x++) {
                addressTo[x] = new InternetAddress(destino.get(x));
            }
            mensaje.setRecipients(Message.RecipientType.TO, addressTo);
            mensaje.setSubject(asunto);
            mensaje.setContent(correo);
            Transport t = session1.getTransport("smtp");
            t.connect("noresponder@clinicapajonal.com", "GenomaPlus1!");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
        } catch (MessagingException e) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void enviarAdjuntoGenerico(List<String> destino, String cuerpo, String remite, String asunto, String ruta, String documento) {
        this.servidorCorreo = this.correoService.listaServidorCorreo(true);
        if (this.servidorCorreo != null || !this.servidorCorreo.isEmpty()) {
            try {
                Properties datos = new Properties();
                datos.setProperty("mail.smtp.host", this.servidorCorreo.get(0).getServidor());
                datos.setProperty("mail.smtp.starttls.enable", this.servidorCorreo.get(0).getRequiereSeguridad().toString());
                datos.setProperty("mail.smtp.port", this.servidorCorreo.get(0).getPuerto());
                datos.setProperty("mail.smtp.user", this.servidorCorreo.get(0).getUsuario());
                datos.setProperty("mail.smtps.auth", this.servidorCorreo.get(0).getRequiereAutenticacion().toString());
                datos.setProperty("mail.smtp.password", this.servidorCorreo.get(0).getContrasena());
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
                InternetAddress[] addressTo = new InternetAddress[destino.size()];
                for (int x = 0; x < destino.size(); x++) {
                    addressTo[x] = new InternetAddress(destino.get(x));
                }
                mensaje.setRecipients(Message.RecipientType.TO, addressTo);
                mensaje.setSubject(asunto);
                mensaje.setContent(correo);
                Transport t = session1.getTransport("smtp");
                Throwable th = null;
                try {
                    try {
                        t.connect("noresponder@clinicapajonal.com", "GenomaPlus1!");
                        t.sendMessage(mensaje, mensaje.getAllRecipients());
                        if (t != null) {
                            if (0 != 0) {
                                try {
                                    t.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                t.close();
                            }
                        }
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (MessagingException e) {
                Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.mail.FolderNotFoundException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.mail.MessagingException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.mail.internet.AddressException */
    public void enviarAdjuntoGenerico(String cuerpo, String asunto, GModuloCorreo moduloCorreo, List<Object[]> listaPdf, List<Object[]> listaCorreos, CorreoListener listener) throws AddressException, FolderNotFoundException {
        try {
            Integer idServidor = moduloCorreo.getIdServidorSmtp();
            this.servidorCorreo = this.correoService.listaServidorCorreoById(true, idServidor);
            System.err.println("servidorCorreo" + this.servidorCorreo.get(0).getServidor());
            if (this.servidorCorreo != null && !this.servidorCorreo.isEmpty()) {
                Properties datos = new Properties();
                datos.setProperty("mail.smtp.host", this.servidorCorreo.get(0).getServidor());
                datos.setProperty("mail.smtp.starttls.enable", this.servidorCorreo.get(0).getRequiereSeguridad().toString());
                datos.setProperty("mail.smtp.port", this.servidorCorreo.get(0).getPuerto());
                datos.setProperty("mail.smtp.user", moduloCorreo.getNombre());
                datos.setProperty("mail.smtp.auth", this.servidorCorreo.get(0).getRequiereAutenticacion().toString());
                datos.setProperty("mail.smtp.password", moduloCorreo.getContrasena());
                datos.put("mail.smtp.ssl.enable", this.servidorCorreo.get(0).getSsl().toString());
                Session session1 = Session.getDefaultInstance(datos, (Authenticator) null);
                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setContent(cuerpo, "text/html");
                MimeMultipart correo = new MimeMultipart();
                correo.addBodyPart(mimeBodyPart);
                for (int x = 0; x < listaPdf.size(); x++) {
                    if (listaPdf.get(x) != null && listaPdf.get(x).length > 0) {
                        String rutaArchivo = listaPdf.get(x)[0].toString();
                        System.out.println("Ruta del archivo adjunto: " + rutaArchivo);
                        File archivoAdjunto = new File(rutaArchivo);
                        if (archivoAdjunto.exists() && archivoAdjunto.canRead()) {
                            System.out.println("Adjuntando archivo: " + rutaArchivo);
                            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
                            mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(archivoAdjunto)));
                            mimeBodyPart2.setFileName(archivoAdjunto.getName());
                            correo.addBodyPart(mimeBodyPart2);
                        } else {
                            System.err.println("El archivo no existe o no se puede leer: " + rutaArchivo);
                        }
                    }
                }
                MimeMessage mensaje = new MimeMessage(session1);
                mensaje.setFrom(new InternetAddress(moduloCorreo.getNombre()));
                InternetAddress[] addressTo = new InternetAddress[listaCorreos.size()];
                for (int x2 = 0; x2 < listaCorreos.size(); x2++) {
                    if (listaCorreos.get(x2) != null && listaCorreos.get(x2).length > 0) {
                        String email = listaCorreos.get(x2)[0].toString();
                        System.err.println("email: " + email);
                        addressTo[x2] = new InternetAddress(email);
                    } else {
                        throw new AddressException("El Object[] en la posición " + x2 + " no contiene una dirección de correo válida.");
                    }
                }
                mensaje.setRecipients(Message.RecipientType.TO, addressTo);
                mensaje.setSubject(asunto);
                mensaje.setContent(correo);
                Transport t = session1.getTransport("smtp");
                t.connect(moduloCorreo.getNombre(), moduloCorreo.getContrasena());
                t.sendMessage(mensaje, mensaje.getAllRecipients());
                t.close();
                guardarEnviados(mensaje, datos, moduloCorreo, this.servidorCorreo);
                if (listener != null) {
                    listener.onCorreoEnviadoExitosamente();
                }
                return;
            }
            throw new MessagingException("No se encontraron servidores de correo configurados.");
        } catch (MessagingException e) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e);
            if (listener != null) {
                listener.onCorreoError(e.getMessage());
            }
        }
    }

    public void enviarAdjuntoGenerico(List<String> destino, String cuerpo, String asunto, String ruta, String documento, GModuloCorreo moduloCorreo) {
        try {
            this.servidorCorreo = this.correoService.listaServidorCorreo(true);
            if (this.servidorCorreo != null || !this.servidorCorreo.isEmpty()) {
                Properties datos = new Properties();
                datos.setProperty("mail.smtp.host", this.servidorCorreo.get(0).getServidor());
                datos.setProperty("mail.smtp.starttls.enable", this.servidorCorreo.get(0).getRequiereSeguridad().toString());
                datos.setProperty("mail.smtp.port", this.servidorCorreo.get(0).getPuerto());
                datos.setProperty("mail.smtp.user", moduloCorreo.getNombre());
                datos.setProperty("mail.smtps.auth", this.servidorCorreo.get(0).getRequiereAutenticacion().toString());
                datos.setProperty("mail.smtp.password", moduloCorreo.getContrasena());
                datos.put("mail.smtp.ssl.enable", this.servidorCorreo.get(0).getSsl().toString());
                Session session1 = Session.getDefaultInstance(datos, (Authenticator) null);
                MimeBodyPart mimeBodyPart = new MimeBodyPart();
                mimeBodyPart.setContent(cuerpo, "text/html");
                MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
                mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(documento)));
                mimeBodyPart2.setFileName(ruta);
                MimeMultipart correo = new MimeMultipart();
                correo.addBodyPart(mimeBodyPart);
                correo.addBodyPart(mimeBodyPart2);
                MimeMessage mensaje = new MimeMessage(session1);
                mensaje.setFrom(new InternetAddress(moduloCorreo.getNombre()));
                InternetAddress[] addressTo = new InternetAddress[destino.size()];
                for (int x = 0; x < destino.size(); x++) {
                    addressTo[x] = new InternetAddress(destino.get(x));
                }
                mensaje.setRecipients(Message.RecipientType.TO, addressTo);
                mensaje.setSubject(asunto);
                mensaje.setContent(correo);
                Transport t = session1.getTransport("smtp");
                t.connect(moduloCorreo.getNombre(), moduloCorreo.getContrasena());
                t.sendMessage(mensaje, mensaje.getAllRecipients());
                t.close();
                guardarEnviados(mensaje, datos, moduloCorreo, this.servidorCorreo);
            }
        } catch (MessagingException e) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.mail.FolderNotFoundException */
    /* JADX WARN: Multi-variable type inference failed */
    private void guardarEnviados(MimeMessage mensaje, Properties datos, GModuloCorreo moduloCorreo, List<GServidorCorreo> servidorCorreo) throws FolderNotFoundException {
        try {
            datos.setProperty("mail.store.protocol", "imaps");
            Session session2 = Session.getInstance(datos);
            Store store = session2.getStore("imaps");
            store.connect(servidorCorreo.get(0).getServidor(), moduloCorreo.getNombre(), moduloCorreo.getContrasena());
            String[] folders = {"Sent", "INBOX.Sent", "[Gmail]/Sent Mail", "Sent Items", "Enviados"};
            Folder sentFolder = null;
            for (String nameFolder : folders) {
                try {
                    sentFolder = store.getFolder(nameFolder);
                } catch (MessagingException e) {
                }
                if (sentFolder.exists()) {
                    break;
                }
            }
            if (sentFolder == null || !sentFolder.exists()) {
                throw new FolderNotFoundException(sentFolder, "No se encontró la carpeta de enviados.");
            }
            sentFolder.open(2);
            sentFolder.appendMessages(new Message[]{mensaje});
            sentFolder.close(false);
            store.close();
        } catch (MessagingException e2) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e2);
        }
    }

    public void enviarAdjuntoPsiquiatras(List<String> destino, String cuerpo, String remite, String asunto, String ruta, String documento) {
        Properties datos;
        String remitente = remite;
        try {
            datos = new Properties();
            datos.setProperty("mail.smtp.host", "smtp.gmail.com");
            datos.setProperty("mail.smtp.starttls.enable", "true");
            datos.setProperty("mail.smtp.port", "587");
            datos.setProperty("mail.smtps.auth", "true");
            switch (Principal.informacionIps.getNombreIps()) {
                case "CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.":
                case "UNION TEMPORAL CLINICA LAURELES":
                    remitente = "hcsoportes@clinicalaureles.com";
                    destino.add(remitente);
                    datos.setProperty("mail.smtp.host", "mail.clinicalaureles.com");
                    datos.setProperty("mail.smtp.port", "465");
                    datos.setProperty("mail.smtp.starttls.enable", "true");
                    datos.setProperty("mail.smtp.ssl.enable", "true");
                    datos.setProperty("mail.smtp.user", remitente);
                    datos.setProperty("mail.smtp.password", "Entrada0728*");
                    break;
                case "MEDICAL HOMECARE S.A.S.":
                    remitente = "sistemasmedicalhomecare@gmail.com";
                    datos.setProperty("mail.smtp.user", remitente);
                    datos.setProperty("mail.smtp.password", "900368327");
                    break;
                case "LABORATORIO CLÍNICO LABVY S.A.S":
                    remitente = "notificacionlabvy@gmail.com";
                    datos.setProperty("mail.smtp.user", remitente);
                    datos.setProperty("mail.smtp.password", "notificacion01.");
                    break;
            }
            Session session1 = Session.getDefaultInstance(datos, (Authenticator) null);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(cuerpo, "text/html");
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(documento)));
            mimeBodyPart2.setFileName(ruta);
            MimeMultipart correo = new MimeMultipart();
            correo.addBodyPart(mimeBodyPart);
            correo.addBodyPart(mimeBodyPart2);
            MimeMessage mensaje = new MimeMessage(session1);
            mensaje.setFrom(new InternetAddress(remitente));
            InternetAddress[] addressTo = new InternetAddress[destino.size()];
            for (int x = 0; x < destino.size(); x++) {
                addressTo[x] = new InternetAddress(destino.get(x));
            }
            mensaje.setRecipients(Message.RecipientType.TO, addressTo);
            mensaje.setSubject(asunto);
            mensaje.setContent(correo);
            Transport t = session1.getTransport("smtp");
            if (Principal.informacionIps.getNombreIps().equals("GENOMA EMPRESARIAL CONSULTORES S.A.S") || Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                t.connect("hcsoportes@clinicalaureles.com", "Entrada0728*");
            } else if (Principal.informacionIps.getNombreIps().equals("MEDICAL HOMECARE S.A.S.")) {
                t.connect("sistemasmedicalhomecare@gmail.com", "900368327");
            }
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog((Component) null, "Se ha finalizado el proceso de envio por correo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } catch (MessagingException e) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e);
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
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void Send(String para, String mensaje, String correo, String asunto) {
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
                enviarConGMail(correo, asunto, mensaje, "lidercalidad.labvy@gmail.com", "lidercalidad");
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
                enviarConGMail(para, asunto, mensaje, "noresponder@clinicapajonal.com", "GenomaPlus1!");
            }
        } catch (Exception e) {
            ExceptionManager.ManageException(e);
        }
    }

    private void enviarConGMail(String destinatario, String asunto, String cuerpo, String remitente, String contrasena) {
        try {
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
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (AddressException e) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (MessagingException e2) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, (String) null, e2);
        }
    }

    public void Send(String para, String mensaje, String correo, String tipo, String adjunto) {
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
        } catch (Exception e) {
            ExceptionManager.ManageException(e);
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
