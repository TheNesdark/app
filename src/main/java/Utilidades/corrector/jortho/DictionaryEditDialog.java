package Utilidades.corrector.jortho;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ListModel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/DictionaryEditDialog.class */
class DictionaryEditDialog extends JDialog {
    private final JList list;
    private final JButton delete;
    private boolean isModify;

    DictionaryEditDialog(JDialog parent) {
        super(parent, Utils.getResource("userDictionary"), true);
        setDefaultCloseOperation(2);
        Container content = getContentPane();
        content.setLayout(new GridBagLayout());
        DefaultListModel data = new DefaultListModel();
        loadWordList(data);
        this.list = new JList(data);
        content.add(new JScrollPane(this.list), new GridBagConstraints(1, 1, 1, 1, 1.0d, 1.0d, 11, 1, new Insets(8, 8, 8, 8), 0, 0));
        this.delete = Utils.getButton("delete");
        content.add(this.delete, new GridBagConstraints(1, 2, 1, 1, 1.0d, 0.0d, 11, 1, new Insets(0, 8, 8, 8), 0, 0));
        DeleteAction deleteAction = new DeleteAction();
        this.delete.addActionListener(deleteAction);
        getRootPane().getInputMap(2).put(KeyStroke.getKeyStroke(127, 0, false), "DELETE");
        getRootPane().getActionMap().put("DELETE", deleteAction);
        getRootPane().getInputMap(2).put(KeyStroke.getKeyStroke(27, 0, false), "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", new AbstractAction() { // from class: Utilidades.corrector.jortho.DictionaryEditDialog.1
            public void actionPerformed(ActionEvent e) {
                DictionaryEditDialog.this.dispose();
            }
        });
        pack();
        setLocationRelativeTo(parent);
    }

    public Dimension getPreferredSize() {
        Dimension dim = super.getPreferredSize();
        String title = getTitle();
        int titleWidth = getFontMetrics(getFont()).stringWidth(title) + 80;
        if (dim.width < titleWidth) {
            dim.width = titleWidth;
        }
        return dim;
    }

    private void loadWordList(DefaultListModel data) {
        Iterator<String> userWords;
        UserDictionaryProvider provider = SpellChecker.getUserDictionaryProvider();
        if (provider != null && (userWords = provider.getWords(SpellChecker.getCurrentLocale())) != null) {
            ArrayList<String> wordList = new ArrayList<>();
            while (userWords.hasNext()) {
                String word = userWords.next();
                if (word != null && word.length() > 1) {
                    wordList.add(word);
                }
            }
            Collections.sort(wordList, Collator.getInstance());
            for (String str : wordList) {
                data.addElement(str);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/DictionaryEditDialog$DeleteAction.class */
    private class DeleteAction extends AbstractAction {
        private DeleteAction() {
        }

        public void actionPerformed(ActionEvent e) {
            int[] selected = DictionaryEditDialog.this.list.getSelectedIndices();
            Arrays.sort(selected);
            for (int i = selected.length - 1; i >= 0; i--) {
                DictionaryEditDialog.this.list.getModel().remove(selected[i]);
                DictionaryEditDialog.this.isModify = true;
            }
        }
    }

    public void dispose() {
        super.dispose();
        if (this.isModify) {
            UserDictionaryProvider provider = SpellChecker.getUserDictionaryProvider();
            if (provider != null) {
                ListModel model = this.list.getModel();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < model.getSize(); i++) {
                    if (builder.length() != 0) {
                        builder.append('\n');
                    }
                    builder.append(model.getElementAt(i));
                }
                provider.setUserWords(builder.toString());
            }
            JMenu menu = SpellChecker.createLanguagesMenu(null);
            for (JRadioButtonMenuItem jRadioButtonMenuItem : menu.getMenuComponents()) {
                if (jRadioButtonMenuItem instanceof JRadioButtonMenuItem) {
                    JRadioButtonMenuItem item = jRadioButtonMenuItem;
                    if (item.isSelected()) {
                        item.doClick();
                    }
                }
            }
        }
    }
}
