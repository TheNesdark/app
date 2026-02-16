package Utilidades;

import java.io.FileOutputStream;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Creguard_XML.class */
public class Creguard_XML {
    public void GuardarXML(String nomArchivo, String NombBD, String DriverMBDJ, String DirIP, String UsuMBD, String PasswMBD) {
        EnDesCrip Kriptonita = new EnDesCrip();
        Element config = new Element("ConfigurarConexcion");
        config.addContent(new Element("baseDatos").setText(Kriptonita.encripta(NombBD)));
        config.addContent(new Element("driver").setText(Kriptonita.encripta(DriverMBDJ)));
        config.addContent(new Element("dirIP").setText(Kriptonita.encripta(DirIP)));
        config.addContent(new Element("usuario").setText(Kriptonita.encripta(UsuMBD)));
        config.addContent(new Element("contraseña").setText(Kriptonita.encripta(PasswMBD)));
        Document docXml = new Document(config);
        try {
            XMLOutputter out = new XMLOutputter();
            FileOutputStream archivo = new FileOutputStream(nomArchivo);
            out.output(docXml, archivo);
            archivo.flush();
            archivo.close();
            out.output(docXml, System.out);
        } catch (Exception e) {
        }
    }

    public String leerXML(String nomArchivo, String etiqueta, boolean encri) {
        String texto = null;
        EnDesCrip Kriptonita = new EnDesCrip();
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document documentoXML = builder.build(nomArchivo);
            Element root = documentoXML.getRootElement();
            Element valor = root.getChild(etiqueta);
            String texto2 = new String(valor.getText());
            if (encri) {
                texto = Kriptonita.desencripta(texto2);
            } else {
                texto = texto2;
            }
        } catch (Exception e) {
        }
        return texto;
    }
}
