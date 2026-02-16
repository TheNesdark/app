package Utilidades.corrector.jortho;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/LanguageBundle.class */
public class LanguageBundle extends ResourceBundle {
    static LanguageBundle get(Locale locale) {
        return (LanguageBundle) ResourceBundle.getBundle(LanguageBundle.class.getName(), locale);
    }

    boolean existInDictionary(String word, Dictionary dictionary, SpellCheckerOptions options, boolean isFirstWordInSentence) {
        boolean exist = dictionary.exist(word);
        if (!exist && !options.isCaseSensitive()) {
            exist = dictionary.exist(Utils.getInvertedCapitalizion(word));
        } else if (!exist && ((isFirstWordInSentence || options.getIgnoreCapitalization()) && Character.isUpperCase(word.charAt(0)))) {
            String capitalizeWord = word.substring(0, 1).toLowerCase() + word.substring(1);
            exist = dictionary.exist(capitalizeWord);
        }
        return exist;
    }

    @Override // java.util.ResourceBundle
    protected Object handleGetObject(String key) {
        return null;
    }

    @Override // java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        return null;
    }
}
