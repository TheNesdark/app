package Utilidades.corrector.jortho;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.text.JTextComponent;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/AddWordAction.class */
public class AddWordAction extends AbstractAction {
    private String word;
    private JTextComponent jText;

    public AddWordAction(JTextComponent jText, String word) {
        this(jText, word, Utils.getResource("addToDictionary"));
    }

    public AddWordAction(JTextComponent jText, String word, String label) {
        super(label);
        this.word = word;
        this.jText = jText;
    }

    public void actionPerformed(ActionEvent arg0) {
        UserDictionaryProvider provider = SpellChecker.getUserDictionaryProvider();
        if (provider != null) {
            provider.addWord(this.word);
        }
        Dictionary dictionary = SpellChecker.getCurrentDictionary();
        dictionary.add(this.word);
        dictionary.trimToSize();
        AutoSpellChecker.refresh(this.jText);
    }
}
