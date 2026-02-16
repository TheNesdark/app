package Utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/PanelRenderer.class */
public class PanelRenderer implements ListCellRenderer<JPanel> {
    public /* bridge */ /* synthetic */ Component getListCellRendererComponent(JList jList, Object obj, int i, boolean z, boolean z2) {
        return getListCellRendererComponent((JList<? extends JPanel>) jList, (JPanel) obj, i, z, z2);
    }

    public Component getListCellRendererComponent(JList<? extends JPanel> list, JPanel panel, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            panel.setBackground(Color.cyan);
        } else {
            panel.setBackground(Color.WHITE);
        }
        return panel;
    }
}
