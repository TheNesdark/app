package Utilidades.corrector.jortho;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/LanguageBundle_fr.class */
public class LanguageBundle_fr extends LanguageBundle {
    @Override // Utilidades.corrector.jortho.LanguageBundle
    boolean existInDictionary(String word, Dictionary dictionary, SpellCheckerOptions options, boolean isFirstWordInSentence) {
        if (super.existInDictionary(word, dictionary, options, isFirstWordInSentence)) {
            return true;
        }
        int idx = word.indexOf(39);
        if (idx > 0 && idx < word.length() - 1) {
            char ch = word.charAt(idx + 1);
            switch (ch) {
                case 'a':
                case 'e':
                case 'h':
                case 'i':
                case 'o':
                case 'u':
                    String word1 = word.substring(0, idx + 1);
                    String word2 = word.substring(idx + 1);
                    return super.existInDictionary(word1, dictionary, options, isFirstWordInSentence) && super.existInDictionary(word2, dictionary, options, isFirstWordInSentence);
                default:
                    return false;
            }
        }
        return false;
    }
}
