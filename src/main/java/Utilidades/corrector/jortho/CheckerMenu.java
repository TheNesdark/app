package Utilidades.corrector.jortho;

import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/CheckerMenu.class */
class CheckerMenu extends JMenu implements HierarchyListener {
    private final CheckerListener listener;

    CheckerMenu(SpellCheckerOptions options) {
        super(Utils.getResource("spelling"));
        this.listener = new CheckerListener(this, options);
        super.addHierarchyListener(this);
    }

    public void hierarchyChanged(HierarchyEvent ev) {
        if (ev.getChangeFlags() == 1 && ev.getChanged() == this) {
            JPopupMenu parent = getParent();
            if (parent != null) {
                parent.addPopupMenuListener(this.listener);
            } else {
                ev.getChangedParent().removePopupMenuListener(this.listener);
            }
        }
    }
}
