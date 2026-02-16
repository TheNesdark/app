package Utilidades;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboPopup;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/CustomPopupMenuListener.class */
public class CustomPopupMenuListener implements PopupMenuListener {
    private boolean scrollBarRequired;
    private boolean popupWider;
    private int maximumWidth;
    private boolean popupAbove;
    private JScrollPane scrollPane;

    public CustomPopupMenuListener() {
        this(true, false, -1, false);
    }

    public CustomPopupMenuListener(boolean popupWider, boolean popupAbove) {
        this(false, popupWider, -1, popupAbove);
    }

    public CustomPopupMenuListener(int maximumWidth) {
        this(true, true, maximumWidth, false);
    }

    public CustomPopupMenuListener(boolean scrollBarRequired, boolean popupWider, int maximumWidth, boolean popupAbove) {
        this.scrollBarRequired = true;
        this.maximumWidth = -1;
        setScrollBarRequired(scrollBarRequired);
        setPopupWider(popupWider);
        setMaximumWidth(maximumWidth);
        setPopupAbove(popupAbove);
    }

    public int getMaximumWidth() {
        return this.maximumWidth;
    }

    public void setMaximumWidth(int maximumWidth) {
        this.maximumWidth = maximumWidth;
    }

    public boolean isPopupAbove() {
        return this.popupAbove;
    }

    public void setPopupAbove(boolean popupAbove) {
        this.popupAbove = popupAbove;
    }

    public boolean isPopupWider() {
        return this.popupWider;
    }

    public void setPopupWider(boolean popupWider) {
        this.popupWider = popupWider;
    }

    public boolean isScrollBarRequired() {
        return this.scrollBarRequired;
    }

    public void setScrollBarRequired(boolean scrollBarRequired) {
        this.scrollBarRequired = scrollBarRequired;
    }

    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        if (comboBox.getItemCount() == 0) {
            return;
        }
        final Object child = comboBox.getAccessibleContext().getAccessibleChild(0);
        if (child instanceof BasicComboPopup) {
            SwingUtilities.invokeLater(new Runnable() { // from class: Utilidades.CustomPopupMenuListener.1
                @Override // java.lang.Runnable
                public void run() {
                    CustomPopupMenuListener.this.customizePopup((BasicComboPopup) child);
                }
            });
        }
    }

    protected void customizePopup(BasicComboPopup popup) {
        this.scrollPane = getScrollPane(popup);
        if (this.popupWider) {
            popupWider(popup);
        }
        checkHorizontalScrollBar(popup);
        Component comboBox = popup.getInvoker();
        Point location = comboBox.getLocationOnScreen();
        if (this.popupAbove) {
            popup.setLocation(location.x, location.y - popup.getPreferredSize().height);
        } else {
            int height = comboBox.getPreferredSize().height;
            popup.setLocation(location.x, (location.y + height) - 1);
            popup.setLocation(location.x, location.y + height);
        }
    }

    protected void popupWider(BasicComboPopup popup) {
        JList list = popup.getList();
        int popupWidth = list.getPreferredSize().width + 5 + getScrollBarWidth(popup, this.scrollPane);
        if (this.maximumWidth != -1) {
            popupWidth = Math.min(popupWidth, this.maximumWidth);
        }
        Dimension scrollPaneSize = this.scrollPane.getPreferredSize();
        scrollPaneSize.width = Math.max(popupWidth, scrollPaneSize.width);
        this.scrollPane.setPreferredSize(scrollPaneSize);
        this.scrollPane.setMaximumSize(scrollPaneSize);
    }

    private void checkHorizontalScrollBar(BasicComboPopup popup) {
        JViewport viewport = this.scrollPane.getViewport();
        Point p = viewport.getViewPosition();
        p.x = 0;
        viewport.setViewPosition(p);
        if (!this.scrollBarRequired) {
            this.scrollPane.setHorizontalScrollBar((JScrollBar) null);
            return;
        }
        JScrollBar horizontal = this.scrollPane.getHorizontalScrollBar();
        if (horizontal == null) {
            horizontal = new JScrollBar(0);
            this.scrollPane.setHorizontalScrollBar(horizontal);
            this.scrollPane.setHorizontalScrollBarPolicy(30);
        }
        if (horizontalScrollBarWillBeVisible(popup, this.scrollPane)) {
            Dimension scrollPaneSize = this.scrollPane.getPreferredSize();
            scrollPaneSize.height += horizontal.getPreferredSize().height;
            this.scrollPane.setPreferredSize(scrollPaneSize);
            this.scrollPane.setMaximumSize(scrollPaneSize);
            this.scrollPane.revalidate();
        }
    }

    protected JScrollPane getScrollPane(BasicComboPopup popup) {
        JList list = popup.getList();
        return SwingUtilities.getAncestorOfClass(JScrollPane.class, list);
    }

    protected int getScrollBarWidth(BasicComboPopup popup, JScrollPane scrollPane) {
        int scrollBarWidth = 0;
        JComboBox comboBox = popup.getInvoker();
        if (comboBox.getItemCount() > comboBox.getMaximumRowCount()) {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            scrollBarWidth = vertical.getPreferredSize().width;
        }
        return scrollBarWidth;
    }

    protected boolean horizontalScrollBarWillBeVisible(BasicComboPopup popup, JScrollPane scrollPane) {
        JList list = popup.getList();
        int scrollBarWidth = getScrollBarWidth(popup, scrollPane);
        int popupWidth = list.getPreferredSize().width + scrollBarWidth;
        return popupWidth > scrollPane.getPreferredSize().width;
    }

    public void popupMenuCanceled(PopupMenuEvent e) {
    }

    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        if (this.scrollPane != null) {
            this.scrollPane.setHorizontalScrollBar((JScrollBar) null);
        }
    }
}
