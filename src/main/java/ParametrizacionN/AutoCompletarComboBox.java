package ParametrizacionN;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/AutoCompletarComboBox.class */
public final class AutoCompletarComboBox extends PlainDocument {
    JComboBox comboBox;
    ComboBoxModel model;
    JTextComponent editor;
    boolean hidePopupOnFocusLoss;
    boolean hitBackspaceOnSelection;
    KeyListener editorKeyListener;
    FocusListener editorFocusListener;
    boolean selecting = false;
    boolean hitBackspace = false;

    public AutoCompletarComboBox(final JComboBox comboBox) {
        this.comboBox = comboBox;
        this.model = comboBox.getModel();
        comboBox.addActionListener(new ActionListener() { // from class: ParametrizacionN.AutoCompletarComboBox.1
            public void actionPerformed(ActionEvent e) {
                if (!AutoCompletarComboBox.this.selecting) {
                    AutoCompletarComboBox.this.highlightCompletedText(0);
                }
            }
        });
        comboBox.addPropertyChangeListener(new PropertyChangeListener() { // from class: ParametrizacionN.AutoCompletarComboBox.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent e) {
                if (e.getPropertyName().equals("editor")) {
                    AutoCompletarComboBox.this.configureEditor((ComboBoxEditor) e.getNewValue());
                }
                if (e.getPropertyName().equals("model")) {
                    AutoCompletarComboBox.this.model = (ComboBoxModel) e.getNewValue();
                }
            }
        });
        this.editorKeyListener = new KeyAdapter() { // from class: ParametrizacionN.AutoCompletarComboBox.3
            public void keyPressed(KeyEvent e) {
                if (comboBox.isDisplayable()) {
                    comboBox.setPopupVisible(true);
                }
                AutoCompletarComboBox.this.hitBackspace = false;
                switch (e.getKeyCode()) {
                    case 8:
                        AutoCompletarComboBox.this.hitBackspace = true;
                        AutoCompletarComboBox.this.hitBackspaceOnSelection = AutoCompletarComboBox.this.editor.getSelectionStart() != AutoCompletarComboBox.this.editor.getSelectionEnd();
                        break;
                    case 127:
                        e.consume();
                        comboBox.getToolkit().beep();
                        break;
                }
            }
        };
        this.hidePopupOnFocusLoss = System.getProperty("java.version").startsWith("1.5");
        this.editorFocusListener = new FocusAdapter() { // from class: ParametrizacionN.AutoCompletarComboBox.4
            public void focusGained(FocusEvent e) {
                AutoCompletarComboBox.this.highlightCompletedText(0);
            }

            public void focusLost(FocusEvent e) {
                if (AutoCompletarComboBox.this.hidePopupOnFocusLoss) {
                    comboBox.setPopupVisible(false);
                }
            }
        };
        configureEditor(comboBox.getEditor());
        Object selected = comboBox.getSelectedItem();
        if (selected != null) {
            setText(selected.toString());
        }
        highlightCompletedText(0);
    }

    public static void enable(JComboBox comboBox) {
        comboBox.setEditable(true);
        new AutoCompletarComboBox(comboBox);
    }

    void configureEditor(ComboBoxEditor newEditor) {
        if (this.editor != null) {
            this.editor.removeKeyListener(this.editorKeyListener);
            this.editor.removeFocusListener(this.editorFocusListener);
        }
        if (newEditor != null) {
            this.editor = newEditor.getEditorComponent();
            this.editor.addKeyListener(this.editorKeyListener);
            this.editor.addFocusListener(this.editorFocusListener);
            this.editor.setDocument(this);
        }
    }

    public void remove(int offs, int len) throws BadLocationException {
        if (this.selecting) {
            return;
        }
        if (this.hitBackspace) {
            if (offs > 0) {
                if (this.hitBackspaceOnSelection) {
                    offs--;
                }
            } else {
                this.comboBox.getToolkit().beep();
            }
            highlightCompletedText(offs);
            return;
        }
        super.remove(offs, len);
    }

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

    private void setText(String text) {
        try {
            super.remove(0, getLength());
            super.insertString(0, text, (AttributeSet) null);
        } catch (BadLocationException e) {
            throw new RuntimeException(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void highlightCompletedText(int start) {
        this.editor.setCaretPosition(getLength());
        this.editor.moveCaretPosition(start);
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
            if (currentItem != null && startsWithIgnoreCase(currentItem.toString(), pattern)) {
                return currentItem;
            }
        }
        return null;
    }

    private boolean startsWithIgnoreCase(String str1, String str2) {
        return str1.toUpperCase().startsWith(str2.toUpperCase());
    }
}
