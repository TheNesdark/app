package com.genoma.plus.controller.facturacion;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/MultiSelectComboBoxExample.class */
public class MultiSelectComboBoxExample extends JFrame {
    public MultiSelectComboBoxExample() {
        setTitle("Multi-Select ComboBox Example");
        setSize(300, 200);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        final DefaultComboBoxModel<CheckableItem> model = new DefaultComboBoxModel<>();
        model.addElement(new CheckableItem("Elemento 1"));
        model.addElement(new CheckableItem("Elemento 2"));
        model.addElement(new CheckableItem("Elemento 3"));
        model.addElement(new CheckableItem("Elemento 4"));
        JComboBox<CheckableItem> comboBox = new JComboBox<>(model);
        comboBox.setRenderer(new CheckBoxRenderer());
        comboBox.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.MultiSelectComboBoxExample.1
            public void actionPerformed(ActionEvent e) {
                JComboBox<CheckableItem> combo = (JComboBox) e.getSource();
                CheckableItem item = (CheckableItem) combo.getSelectedItem();
                if (item != null) {
                    item.setSelected(!item.isSelected());
                    combo.repaint();
                }
            }
        });
        JButton getSelectedButton = new JButton("Obtener seleccionados");
        getSelectedButton.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.MultiSelectComboBoxExample.2
            public void actionPerformed(ActionEvent e) {
                List<String> selectedItems = new ArrayList<>();
                for (int i = 0; i < model.getSize(); i++) {
                    CheckableItem item = (CheckableItem) model.getElementAt(i);
                    if (item.isSelected()) {
                        selectedItems.add(item.getText());
                    }
                }
                System.out.println("Elementos seleccionados: " + selectedItems);
            }
        });
        JPanel panel = new JPanel();
        panel.add(comboBox);
        panel.add(getSelectedButton);
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // from class: com.genoma.plus.controller.facturacion.MultiSelectComboBoxExample.3
            @Override // java.lang.Runnable
            public void run() {
                new MultiSelectComboBoxExample().setVisible(true);
            }
        });
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/MultiSelectComboBoxExample$CheckableItem.class */
    class CheckableItem {
        private String text;
        private boolean isSelected = false;

        public CheckableItem(String text) {
            this.text = text;
        }

        public String getText() {
            return this.text;
        }

        public boolean isSelected() {
            return this.isSelected;
        }

        public void setSelected(boolean isSelected) {
            this.isSelected = isSelected;
        }

        public String toString() {
            return this.text;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/MultiSelectComboBoxExample$CheckBoxRenderer.class */
    class CheckBoxRenderer implements ListCellRenderer<CheckableItem> {
        private JCheckBox checkBox = new JCheckBox();

        public /* bridge */ /* synthetic */ Component getListCellRendererComponent(JList jList, Object obj, int i, boolean z, boolean z2) {
            return getListCellRendererComponent((JList<? extends CheckableItem>) jList, (CheckableItem) obj, i, z, z2);
        }

        public CheckBoxRenderer() {
        }

        public Component getListCellRendererComponent(JList<? extends CheckableItem> list, CheckableItem value, int index, boolean isSelected, boolean cellHasFocus) {
            this.checkBox.setText(value.getText());
            this.checkBox.setSelected(value.isSelected());
            if (isSelected) {
                this.checkBox.setBackground(list.getSelectionBackground());
                this.checkBox.setForeground(list.getSelectionForeground());
            } else {
                this.checkBox.setBackground(list.getBackground());
                this.checkBox.setForeground(list.getForeground());
            }
            this.checkBox.setEnabled(list.isEnabled());
            this.checkBox.setFont(list.getFont());
            return this.checkBox;
        }
    }
}
