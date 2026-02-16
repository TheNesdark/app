package Utilidades;

import Acceso.Principal;
import Historia.CorreoListener;
import com.genoma.plus.jpa.entities.GModuloCorreo;
import com.genoma.plus.jpa.entities.GServidorCorreo;
import com.genoma.plus.jpa.service.GServidorCorreoService;
import com.genoma.plus.jpa.service.IGModuloCorreoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Enviar_Correo_Electronico.class */
public class Enviar_Correo_Electronico {
    private String xcorreoenvio;
    private String xcontrasena;
    private String xsevidor;
    private String xpuerto;
    private String xseguridad;
    private String xautenticacion;
    String mailReceptor;
    String htmlText;
    String asunto;
    String cuerpo;
    private final GServidorCorreoService correoService;
    private final IGModuloCorreoService iCorreoService;
    private GModuloCorreo moduloCorreo;
    private List<GServidorCorreo> servidorCorreo;
    private Metodos metodos;
    private List<Object[]> listaPdf;
    private List<Object[]> listaCorreos;
    private CorreoListener listener;

    public Enviar_Correo_Electronico() {
        this.xcorreoenvio = "laayalai@fundacionpanzenu.org.co";
        this.xcontrasena = "Valentina1";
        this.xsevidor = "mail.fundacionpanzenu.org.co";
        this.xpuerto = "25";
        this.xseguridad = "false";
        this.xautenticacion = "false";
        this.mailReceptor = null;
        this.htmlText = "";
        this.asunto = null;
        this.cuerpo = null;
        this.correoService = (GServidorCorreoService) Principal.contexto.getBean(GServidorCorreoService.class);
        this.iCorreoService = (IGModuloCorreoService) Principal.contexto.getBean(IGModuloCorreoService.class);
        this.metodos = new Metodos();
        this.servidorCorreo = new ArrayList();
    }

    public Enviar_Correo_Electronico(String xcorreoenvio, String xcontrasena, String xsevidor, String xpuerto, String xseguridad, String xautenticacion, String xasunto, String xcuerpo, String xadjunto, String xnadjunto, String xpara, String xcc) {
        this.xcorreoenvio = "laayalai@fundacionpanzenu.org.co";
        this.xcontrasena = "Valentina1";
        this.xsevidor = "mail.fundacionpanzenu.org.co";
        this.xpuerto = "25";
        this.xseguridad = "false";
        this.xautenticacion = "false";
        this.mailReceptor = null;
        this.htmlText = "";
        this.asunto = null;
        this.cuerpo = null;
        this.correoService = (GServidorCorreoService) Principal.contexto.getBean(GServidorCorreoService.class);
        this.iCorreoService = (IGModuloCorreoService) Principal.contexto.getBean(IGModuloCorreoService.class);
        this.metodos = new Metodos();
        this.xcorreoenvio = xcorreoenvio;
        this.xcontrasena = xcontrasena;
        this.xsevidor = xsevidor;
        this.xpuerto = xpuerto;
        try {
            Properties props = new Properties();
            props.put("mail.smtp.user", xcorreoenvio);
            props.put("mail.smtp.host", xsevidor);
            props.put("mail.smtp.port", xpuerto);
            props.put("mail.smtp.starttls.enable", xseguridad);
            props.put("mail.smtp.auth", xautenticacion);
            props.put("mail.smtp.socketFactory.port", xpuerto);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            System.getSecurityManager();
            Authenticator auth = new autentificadorSMTP();
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setSubject(xasunto);
            msg.setFrom(new InternetAddress(xcorreoenvio));
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart.setText(xcuerpo);
            if (!xadjunto.equals("")) {
                mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(xadjunto)));
                mimeBodyPart2.setFileName(xnadjunto);
            }
            if (!xpara.equals("")) {
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(xpara));
            }
            if (!xcc.equals("")) {
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(xcc));
            }
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(mimeBodyPart);
            multiParte.addBodyPart(mimeBodyPart2);
            msg.setContent(multiParte);
            Transport.send(msg);
        } catch (MessagingException e) {
            Logger.getLogger(Enviar_Correo_Electronico.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public Enviar_Correo_Electronico(String xcorreoenvio, String xasunto, String xcuerpo, String xadjunto, String xnadjunto, String xpara, String xcc) {
        this.xcorreoenvio = "laayalai@fundacionpanzenu.org.co";
        this.xcontrasena = "Valentina1";
        this.xsevidor = "mail.fundacionpanzenu.org.co";
        this.xpuerto = "25";
        this.xseguridad = "false";
        this.xautenticacion = "false";
        this.mailReceptor = null;
        this.htmlText = "";
        this.asunto = null;
        this.cuerpo = null;
        this.correoService = (GServidorCorreoService) Principal.contexto.getBean(GServidorCorreoService.class);
        this.iCorreoService = (IGModuloCorreoService) Principal.contexto.getBean(IGModuloCorreoService.class);
        this.metodos = new Metodos();
        this.servidorCorreo = new ArrayList();
        System.err.println("xasunto" + xasunto);
        System.err.println("xcuerpo" + xcuerpo);
        System.err.println("modulo" + xadjunto);
        System.err.println("xnadjunto" + xnadjunto);
        System.err.println("xpara" + xpara);
        System.err.println("xcc" + xcc);
        this.moduloCorreo = this.iCorreoService.getCorreoModuloPorIdModulo(Principal.informacionGeneralPrincipalDTO.getIdModulo());
        Email xenviar = new Email();
        List<String> xdestino = new ArrayList<>();
        xdestino.add(xpara);
        if (!xcc.isEmpty()) {
            xdestino.add(xcc);
        }
        if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
            this.htmlText = "<p><strong>Estimado(a)</strong> ,</p>\n<p>Espero que este mensaje lo encuentre bien. " + Principal.informacionIps.getNombreIps() + ", nos complace poder compartir con usted los resultados de su reciente visita en Nuestra entidad.</p>\n<p><strong>" + Principal.usuarioSistemaDTO.getNombreUsuario() + "</strong></p>\n<p><strong>Cargo:" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "</strong></p>";
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS")) {
            this.htmlText = "<p><strong>Estimado Usuario(a):</strong> ,</p>\n<p>Para mayor comodidad,la" + Principal.informacionIps.getNombreIps() + ",pone a su disposición el servicio de entrega de resultados por correo electrónico.</p>\n<p>Se adjuntan resultados de exámenes de laboratorio, recuerde que estos deben ser revisados e interpretados por su médico.</p>\n<p>Este es un correo informativo por favor no responder.</p>\n<p><strong>" + Principal.usuarioSistemaDTO.getNombreUsuario() + "</strong></p>\n<p><strong>Cargo:" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "</strong></p>";
        } else if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
            this.htmlText = "<html><font color='black'>" + xcuerpo + "<br><br><br> </font></html>";
        } else if (Principal.informacionIps.getIdentificacion().equals("900304530")) {
            this.htmlText = "<html><font color='black'>" + xcuerpo + "</font></html>";
        } else {
            this.htmlText = "<html><font color='black'>" + xcuerpo + "<br><br><br>" + Principal.usuarioSistemaDTO.getNombreUsuario() + "<br>" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "</font></html>";
        }
        xenviar.enviarAdjuntoGenerico(xdestino, this.htmlText, xasunto, xnadjunto, xnadjunto, this.moduloCorreo);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.mail.FolderNotFoundException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.mail.internet.AddressException */
    public Enviar_Correo_Electronico(String xasunto, List<Object[]> listaPdf, List<Object[]> listaCorreos, CorreoListener listener) throws AddressException, FolderNotFoundException {
        this.xcorreoenvio = "laayalai@fundacionpanzenu.org.co";
        this.xcontrasena = "Valentina1";
        this.xsevidor = "mail.fundacionpanzenu.org.co";
        this.xpuerto = "25";
        this.xseguridad = "false";
        this.xautenticacion = "false";
        this.mailReceptor = null;
        this.htmlText = "";
        this.asunto = null;
        this.cuerpo = null;
        this.correoService = (GServidorCorreoService) Principal.contexto.getBean(GServidorCorreoService.class);
        this.iCorreoService = (IGModuloCorreoService) Principal.contexto.getBean(IGModuloCorreoService.class);
        this.metodos = new Metodos();
        this.listener = listener;
        System.err.println("modulo" + Principal.informacionGeneralPrincipalDTO.getIdModulo());
        this.moduloCorreo = this.iCorreoService.getCorreoModuloPorIdModulo(Principal.informacionGeneralPrincipalDTO.getIdModulo());
        System.out.println("moduloCorreo" + this.moduloCorreo.getNombre());
        Email xenviar = new Email();
        new ArrayList();
        this.listaCorreos = listaCorreos;
        this.listaPdf = listaPdf;
        switch (Principal.informacionIps.getNombreIps()) {
            case "BIOMED VIDA IPS S.A.S":
                this.htmlText = "<p><strong>Estimado(a)</strong> ,</p>\n<p>Espero que este mensaje lo encuentre bien. " + Principal.informacionIps.getNombreIps() + ", nos complace poder compartir con usted los resultados de su reciente visita en Nuestra entidad.</p>\n<p><strong>" + Principal.usuarioSistemaDTO.getNombreUsuario() + "</strong></p>\n<p><strong>Cargo:" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "</strong></p>";
                break;
            case "CLINICA SANTA CLARA SAS":
                this.htmlText = "<p><strong>Estimado Usuario(a):</strong> ,</p>\n<p>Para mayor comodidad,la" + Principal.informacionIps.getNombreIps() + ",pone a su disposición el servicio de entrega de resultados por correo electrónico.</p>\n<p>Se adjuntan resultados de exámenes de laboratorio, recuerde que estos deben ser revisados e interpretados por su médico.</p>\n<p>Este es un correo informativo por favor no responder.</p>\n<p><strong>" + Principal.usuarioSistemaDTO.getNombreUsuario() + "</strong></p>\n<p><strong>Cargo:" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "</strong></p>";
                break;
            case "CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S":
                this.htmlText = "<p><strong>Cordial saludo:</strong> ,</p>\n<p>Solicito autorización del servicio prestado.</p>\n<p>Quedamos atentos a su pronta respuesta.</p>\n<p><strong>" + Principal.usuarioSistemaDTO.getNombreUsuario() + "</strong></p>\n<p><strong>Cargo:" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "</strong></p>";
                break;
            default:
                this.htmlText = "<html><font color='black'><br><br><br>" + Principal.usuarioSistemaDTO.getNombreUsuario() + "<br>" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "</font></html>";
                if (Principal.informacionIps.getIdentificacion().equals("900304530")) {
                    this.htmlText = "<html><font color='black'></font></html>";
                    break;
                }
                break;
        }
        xenviar.enviarAdjuntoGenerico(this.htmlText, xasunto, this.moduloCorreo, listaPdf, listaCorreos, this.listener);
    }

    public Enviar_Correo_Electronico(String xndestinatario, String asunto, String cuerpo, String xurlarchivo, String xnombrearchivo) {
        this.xcorreoenvio = "laayalai@fundacionpanzenu.org.co";
        this.xcontrasena = "Valentina1";
        this.xsevidor = "mail.fundacionpanzenu.org.co";
        this.xpuerto = "25";
        this.xseguridad = "false";
        this.xautenticacion = "false";
        this.mailReceptor = null;
        this.htmlText = "";
        this.asunto = null;
        this.cuerpo = null;
        this.correoService = (GServidorCorreoService) Principal.contexto.getBean(GServidorCorreoService.class);
        this.iCorreoService = (IGModuloCorreoService) Principal.contexto.getBean(IGModuloCorreoService.class);
        this.metodos = new Metodos();
        try {
            this.mailReceptor = xndestinatario;
            this.asunto = asunto;
            this.cuerpo = cuerpo;
            Properties props = new Properties();
            props.put("mail.smtp.user", this.xcorreoenvio);
            props.put("mail.smtp.host", this.xsevidor);
            props.put("mail.smtp.port", this.xpuerto);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.socketFactory.port", this.xpuerto);
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
            System.getSecurityManager();
            Authenticator auth = new autentificadorSMTP();
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setSubject(asunto);
            msg.setFrom(new InternetAddress(this.xcorreoenvio));
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart.setText(cuerpo);
            System.out.println(xurlarchivo);
            System.out.println(xnombrearchivo);
            mimeBodyPart2.setDataHandler(new DataHandler(new FileDataSource(xurlarchivo)));
            mimeBodyPart2.setFileName(xnombrearchivo);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(xndestinatario));
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(mimeBodyPart);
            multiParte.addBodyPart(mimeBodyPart2);
            msg.setContent(multiParte);
            Transport.send(msg);
        } catch (MessagingException e) {
            Logger.getLogger(Enviar_Correo_Electronico.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/Enviar_Correo_Electronico$autentificadorSMTP.class */
    private class autentificadorSMTP extends Authenticator {
        private autentificadorSMTP() {
        }

        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(Enviar_Correo_Electronico.this.xcorreoenvio, Enviar_Correo_Electronico.this.xcontrasena);
        }
    }
}
