package Utilidades.corrector.jorthodictionaries;

import java.util.HashSet;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jorthodictionaries/Book.class */
class Book {
    private int charCount;
    private HashSet list = new HashSet();
    private int titleCount;
    private int titleCountLanguage;

    Book() {
    }

    protected final void addWord(String word) {
        if (this.list.add(word)) {
            if (this.list.size() % 1000 == 0) {
                System.out.println("Word count:" + this.list.size());
            }
            this.charCount += word.length();
        }
    }

    void incTitleCount() {
        this.titleCount++;
    }

    void incLanguageTitleCount() {
        this.titleCountLanguage++;
    }

    int getTitleCount() {
        return this.titleCount;
    }

    int getLanguageTitleCount() {
        return this.titleCountLanguage;
    }

    int getWordCount() {
        return this.list.size();
    }

    int getCharCount() {
        return this.charCount;
    }

    String[] getWords() {
        return (String[]) this.list.toArray(new String[this.list.size()]);
    }
}
