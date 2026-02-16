package Utilidades;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Autocomplete.class */
public class Autocomplete extends PlainDocument {
    JComboBox comboBox;
    ComboBoxModel model;
    JTextComponent editor;
    boolean selecting = false;

    public Autocomplete(JComboBox comboBox) {
        this.comboBox = comboBox;
        this.model = comboBox.getModel();
        this.editor = comboBox.getEditor().getEditorComponent();
    }

    public void remove(int offs, int len) throws BadLocationException {
        if (this.selecting) {
            return;
        }
        super.remove(offs, len);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.swing.text.BadLocationException */
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (this.selecting) {
            return;
        }
        super.insertString(offs, str, a);
        Object item = lookupItem(getText(0, getLength()));
        if (item != null) {
            setSelectedItem(item);
        } else {
            item = this.comboBox.getSelectedItem();
            offs -= str.length();
            this.comboBox.getToolkit().beep();
        }
        setText(item.toString());
        highlightCompletedText(offs + str.length());
    }

    private void setText(String text) throws BadLocationException {
        super.remove(0, getLength());
        super.insertString(0, text, (AttributeSet) null);
    }

    private void highlightCompletedText(int start) {
        this.editor.setSelectionStart(start);
        this.editor.setSelectionEnd(getLength());
    }

    private void setSelectedItem(Object item) {
        this.selecting = true;
        this.model.setSelectedItem(item);
        this.selecting = false;
    }

    private Object lookupItem(String pattern) {
        Object selectedItem = this.model.getSelectedItem();
        if (selectedItem != null && startsWithIgnoreCase(selectedItem.toString(), pattern)) {
            return selectedItem;
        }
        int n = this.model.getSize();
        for (int i = 0; i < n; i++) {
            Object currentItem = this.model.getElementAt(i);
            if (startsWithIgnoreCase(currentItem.toString(), pattern)) {
                return currentItem;
            }
        }
        System.out.println("No item matches pattern '" + pattern + "'");
        return null;
    }

    private boolean startsWithIgnoreCase(String str1, String str2) {
        return str1.toUpperCase().startsWith(str2.toUpperCase());
    }
}
