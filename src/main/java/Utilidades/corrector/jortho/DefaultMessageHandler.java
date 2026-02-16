package Utilidades.corrector.jortho;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/DefaultMessageHandler.class */
public class DefaultMessageHandler implements MessageHandler {
    private JFrame ownerFrame;

    public DefaultMessageHandler(JFrame ownerFrame) {
        this.ownerFrame = ownerFrame;
    }

    @Override // Utilidades.corrector.jortho.MessageHandler
    public void handleError(String title, String errorText, Throwable throwable) {
        throwable.printStackTrace();
        JOptionPane.showMessageDialog(this.ownerFrame, throwable.toString(), title, 0);
    }

    @Override // Utilidades.corrector.jortho.MessageHandler
    public void handleException(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override // Utilidades.corrector.jortho.MessageHandler
    public void handleInformation(Container parent, String title, String info) {
        JOptionPane.showMessageDialog(parent, info, title, 1);
    }
}
