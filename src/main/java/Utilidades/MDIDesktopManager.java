package Utilidades;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.DefaultDesktopManager;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/* JADX INFO: compiled from: MDIDesktopPane.java */
/* JADX INFO: loaded from: GenomaP.jar:Utilidades/MDIDesktopManager.class */
class MDIDesktopManager extends DefaultDesktopManager {
    private final MDIDesktopPane desktop;

    public MDIDesktopManager(MDIDesktopPane desktop) {
        this.desktop = desktop;
    }

    public void endResizingFrame(JComponent f) {
        super.endResizingFrame(f);
        resizeDesktop();
    }

    public void endDraggingFrame(JComponent f) {
        super.endDraggingFrame(f);
        resizeDesktop();
    }

    public void setNormalSize() {
        JScrollPane scrollPane = getScrollPane();
        Insets scrollInsets = getScrollPaneInsets();
        if (scrollPane != null) {
            Dimension d = scrollPane.getVisibleRect().getSize();
            if (scrollPane.getBorder() != null) {
                d.setSize((d.getWidth() - ((double) scrollInsets.left)) - ((double) scrollInsets.right), (d.getHeight() - ((double) scrollInsets.top)) - ((double) scrollInsets.bottom));
            }
            d.setSize(d.getWidth() - 20.0d, d.getHeight() - 20.0d);
            this.desktop.setAllSize(0, 0);
            scrollPane.invalidate();
            scrollPane.validate();
        }
    }

    private Insets getScrollPaneInsets() {
        JScrollPane scrollPane = getScrollPane();
        if (scrollPane == null) {
            return new Insets(0, 0, 0, 0);
        }
        return getScrollPane().getBorder().getBorderInsets(scrollPane);
    }

    private JScrollPane getScrollPane() {
        if (this.desktop.getParent() instanceof JViewport) {
            JViewport viewPort = this.desktop.getParent();
            if (viewPort.getParent() instanceof JScrollPane) {
                return viewPort.getParent();
            }
            return null;
        }
        return null;
    }

    protected void resizeDesktop() {
        int x = 0;
        int y = 0;
        JScrollPane scrollPane = getScrollPane();
        Insets scrollInsets = getScrollPaneInsets();
        if (scrollPane != null) {
            JInternalFrame[] allFrames = this.desktop.getAllFrames();
            for (int i = 0; i < allFrames.length; i++) {
                if (allFrames[i].getX() + allFrames[i].getWidth() > x) {
                    x = allFrames[i].getX() + allFrames[i].getWidth();
                }
                if (allFrames[i].getY() + allFrames[i].getHeight() > y) {
                    y = allFrames[i].getY() + allFrames[i].getHeight();
                }
            }
            Dimension d = scrollPane.getVisibleRect().getSize();
            if (scrollPane.getBorder() != null) {
                d.setSize((d.getWidth() - ((double) scrollInsets.left)) - ((double) scrollInsets.right), (d.getHeight() - ((double) scrollInsets.top)) - ((double) scrollInsets.bottom));
            }
            if (x <= d.getWidth()) {
                x = ((int) d.getWidth()) - 20;
            }
            if (y <= d.getHeight()) {
                y = ((int) d.getHeight()) - 20;
            }
            this.desktop.setAllSize(x, y);
            scrollPane.invalidate();
            scrollPane.validate();
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        }
    }
}
