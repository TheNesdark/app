package Utilidades.corrector.jortho;

import javax.swing.JPopupMenu;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/CheckerPopup.class */
class CheckerPopup extends JPopupMenu {
    CheckerPopup(SpellCheckerOptions options) {
        CheckerListener listener = new CheckerListener(this, options);
        super.addPopupMenuListener(listener);
    }
}
