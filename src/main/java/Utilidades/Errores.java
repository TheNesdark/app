package Utilidades;

import Acceso.VentanaConfig;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Errores.class */
public class Errores {
    public void Manejo_errores(int err, String mensaje) {
        switch (err) {
            case 0:
                JOptionPane.showMessageDialog((Component) null, "Servicio de BD abajo o el archivo de configuraci�n no existe.\nDigite la informaci�n nuevamente.", "Error Grave", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                new VentanaConfig().setVisible(true);
                break;
            case 1045:
                JOptionPane.showMessageDialog((Component) null, "Usuario o Contrase�a de BD invalida, o el archivo de configuraci�n no existe.\nDigite la informaci�n nuevamente.", "Error Grave", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                new VentanaConfig().setVisible(true);
                break;
            case 1049:
                JOptionPane.showMessageDialog((Component) null, "Base de Datos desconocida o el archivo de configuraci�n no existe.\nDigite la informaci�n nuevamente.", "Error Grave", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                new VentanaConfig().setVisible(true);
                break;
            case 1216:
                JOptionPane.showMessageDialog((Component) null, "Llave foranea no existe.", "Error Grave", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                break;
            case 1582:
                JOptionPane.showMessageDialog((Component) null, "Llave primaria duplicada.", "Error Grave", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                break;
            case 12460888:
                JOptionPane.showMessageDialog((Component) null, "Cadena demasiado larga o incmpatible.", "Error Grave", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                break;
            default:
                JOptionPane.showMessageDialog((Component) null, "Error desconocido 1.\n " + mensaje, "Error Grave", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                break;
        }
    }
}
