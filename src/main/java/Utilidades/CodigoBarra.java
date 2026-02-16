package Utilidades;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.sourceforge.jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Interleaved25;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/CodigoBarra.class */
public class CodigoBarra {
    public void mCrearCodigo(String Ruta, JLabel xlabel, String xcodigo) {
        try {
            Metodos xmtd = new Metodos();
            JBarcodeBean barcode = new JBarcodeBean();
            barcode.setCodeType(new Interleaved25());
            barcode.setCode(xcodigo);
            barcode.setHorizontalAlignment(2);
            barcode.setBarcodeHeight(30);
            barcode.setCheckDigit(true);
            BufferedImage bufferedImage = barcode.draw(new BufferedImage(100, 70, 11));
            xmtd.mEliminarArchivo(new File(Ruta));
            File file = new File(Ruta);
            System.out.println(Ruta);
            ImageIO.write(bufferedImage, "png", file);
            xlabel.setIcon(new ImageIcon(Ruta));
        } catch (IOException ex) {
            Logger.getLogger(CodigoBarra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCrearCodigo(String Ruta, String xcodigo) {
        try {
            Metodos xmtd = new Metodos();
            JBarcodeBean barcode = new JBarcodeBean();
            barcode.setCodeType(new Interleaved25());
            barcode.setCode(xcodigo);
            barcode.setCheckDigit(true);
            barcode.setBarcodeHeight(30);
            BufferedImage bufferedImage = barcode.draw(new BufferedImage(100, 70, 11));
            xmtd.mEliminarArchivo(new File(Ruta));
            File file = new File(Ruta);
            System.out.println(Ruta);
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException ex) {
            Logger.getLogger(CodigoBarra.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
