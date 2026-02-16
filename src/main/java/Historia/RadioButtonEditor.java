package Historia;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;

/* JADX INFO: compiled from: JPAdultoMayor.java */
/* JADX INFO: loaded from: GenomaP.jar:Historia/RadioButtonEditor.class */
class RadioButtonEditor extends DefaultCellEditor implements ItemListener {
    public JRadioButton btn;

    public RadioButtonEditor(JCheckBox checkBox, String xNombre) {
        super(checkBox);
        this.btn = new JRadioButton();
        this.btn.setName(xNombre);
        this.btn.addActionListener(new ActionListener() { // from class: Historia.RadioButtonEditor.1
            public void actionPerformed(ActionEvent e) {
                if (RadioButtonEditor.this.btn.getName().equals("0")) {
                }
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value == null) {
            return null;
        }
        this.btn.addItemListener(this);
        if (((Boolean) value).booleanValue()) {
            this.btn.setSelected(true);
        } else {
            this.btn.setSelected(false);
        }
        return this.btn;
    }

    public Object getCellEditorValue() {
        if (this.btn.isSelected()) {
            return new Boolean(true);
        }
        return new Boolean(false);
    }

    public void itemStateChanged(ItemEvent e) {
        super.fireEditingStopped();
    }
}
