package Utilidades.corrector.jortho;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/SpellCheckerOptions.class */
public class SpellCheckerOptions {
    private int suggestionsLimitMenu = 15;
    private int suggestionsLimitDialog = 15;
    private boolean caseSensitive = true;
    private boolean ignoreCapitalization = false;
    private boolean ignoreAllCaps = true;
    private boolean ignoreNumbers = false;
    private boolean languageDisableVisible = false;

    public void setSuggestionsLimitMenu(int count) {
        this.suggestionsLimitMenu = count;
    }

    public int getSuggestionsLimitMenu() {
        return this.suggestionsLimitMenu;
    }

    public void setSuggestionsLimitDialog(int count) {
        this.suggestionsLimitDialog = count;
    }

    public int getSuggestionsLimitDialog() {
        return this.suggestionsLimitDialog;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    public void setIgnoreCapitalization(boolean ignore) {
        this.ignoreCapitalization = ignore;
    }

    public boolean getIgnoreCapitalization() {
        return this.ignoreCapitalization;
    }

    public void setIgnoreAllCapsWords(boolean ignore) {
        this.ignoreAllCaps = ignore;
    }

    public boolean isIgnoreAllCapsWords() {
        return this.ignoreAllCaps;
    }

    public void setIgnoreWordsWithNumbers(boolean ignore) {
        this.ignoreNumbers = ignore;
    }

    public boolean isIgnoreWordsWithNumbers() {
        return this.ignoreNumbers;
    }

    public void setLanguageDisableVisible(boolean visible) {
        this.languageDisableVisible = visible;
    }

    public boolean isLanguageDisableVisible() {
        return this.languageDisableVisible;
    }
}
