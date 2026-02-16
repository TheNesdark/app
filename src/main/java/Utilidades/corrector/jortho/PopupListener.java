package Utilidades.corrector.jortho;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/PopupListener.class */
public class PopupListener extends MouseAdapter {
    private final JPopupMenu menu;

    public PopupListener(JPopupMenu menu) {
        this.menu = menu;
    }

    public void mousePressed(MouseEvent ev) {
        maybeShowPopup(ev);
    }

    public void mouseReleased(MouseEvent ev) {
        maybeShowPopup(ev);
    }

    private void maybeShowPopup(MouseEvent ev) {
        if (ev.isPopupTrigger()) {
            this.menu.show(ev.getComponent(), ev.getX(), ev.getY());
        }
    }
}
