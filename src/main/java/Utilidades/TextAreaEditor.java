package Utilidades;

import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/TextAreaEditor.class */
public class TextAreaEditor extends DefaultCellEditor {
    public TextAreaEditor() {
        super(new JTextField());
        final JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder((Border) null);
        this.editorComponent = scrollPane;
        this.delegate = new DefaultCellEditor.EditorDelegate() { // from class: Utilidades.TextAreaEditor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(TextAreaEditor.this);
            }

            public void setValue(Object value) {
                textArea.setText(value != null ? value.toString() : "");
            }

            public Object getCellEditorValue() {
                return textArea.getText();
            }
        };
    }
}
