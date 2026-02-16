package Utilidades;

import Acceso.Principal;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.flexdock.docking.DockingConstants;
import org.flexdock.util.SwingUtility;
import org.flexdock.view.Titlebar;
import org.flexdock.view.View;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/VistaAcoplar.class */
public class VistaAcoplar extends JFrame implements DockingConstants {
    public VistaAcoplar(Principal frm) {
        super("Viewport Demo");
        SwingUtility.setPlaf("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        EventQueue.invokeLater(new Runnable() { // from class: Utilidades.VistaAcoplar.1
            @Override // java.lang.Runnable
            public void run() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        JOptionPane.showMessageDialog((Component) null, "ok entro");
        frm.setVisible(true);
    }

    private View createView(String id, String text) {
        View view = new View(id, text);
        view.addAction("pin");
        return view;
    }

    private View createStartPage(JDesktopPane panel) {
        View view = new View("StarPage", (String) null, (String) null);
        view.setTerritoryBlocked("CENTER", true);
        view.setTitlebar((Titlebar) null);
        view.setContentPane(panel);
        return view;
    }
}
