package Utilidades.corrector.jortho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/DictionaryBase.class */
abstract class DictionaryBase {
    protected char[] tree;
    protected int size;
    protected int idx;
    protected static final char LAST_CHAR = 65535;

    DictionaryBase(char[] tree) {
        this.tree = tree;
        this.size = tree.length;
    }

    protected DictionaryBase() {
    }

    public boolean exist(String word) {
        this.idx = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            while (this.idx < this.size && this.tree[this.idx] < c) {
                this.idx += 3;
            }
            if (this.idx >= this.size || this.tree[this.idx] != c) {
                return false;
            }
            if (i == word.length() - 1 && isWordMatch()) {
                return true;
            }
            this.idx = readIndex();
            if (this.idx <= 0) {
                return false;
            }
        }
        return false;
    }

    public List<Suggestion> searchSuggestions(String word) {
        if (word.length() == 0 || exist(word)) {
            return new ArrayList();
        }
        Suggestions suggesions = new Suggestions(Math.min(20, 4 + word.length()));
        this.idx = 0;
        searchSuggestions(suggesions, word, 0, 0, 0);
        List<Suggestion> list = suggesions.getlist();
        Collections.sort(list);
        return list;
    }

    private void searchSuggestions(Suggestions list, CharSequence chars, int charPosition, int lastIdx, int diff) {
        if (diff > list.getMaxDissimilarity()) {
            return;
        }
        this.idx = lastIdx;
        char currentChar = chars.charAt(charPosition);
        if (searchChar(currentChar)) {
            if (isWordMatch()) {
                if (charPosition + 1 == chars.length()) {
                    list.add(new Suggestion(chars, diff));
                } else {
                    int length = charPosition + 1;
                    CharSequence chars2 = chars.subSequence(0, length);
                    list.add(new Suggestion(chars2, diff + ((chars.length() - length) * 5)));
                }
            }
            this.idx = readIndex();
            if (this.idx > 0) {
                if (charPosition + 1 == chars.length()) {
                    searchSuggestionsLonger(list, chars, this.idx, diff + 5);
                } else {
                    searchSuggestions(list, chars, charPosition + 1, this.idx, diff);
                }
            }
        }
        if (charPosition + 1 < chars.length()) {
            this.idx = lastIdx;
            currentChar = chars.charAt(charPosition + 1);
            if (searchChar(currentChar)) {
                int tempIdx = this.idx;
                this.idx = readIndex();
                if (this.idx > 0) {
                    StringBuilder buffer = new StringBuilder(chars);
                    buffer.setCharAt(charPosition + 1, chars.charAt(charPosition));
                    buffer.setCharAt(charPosition, currentChar);
                    searchSuggestions(list, buffer, charPosition + 1, this.idx, diff + 3);
                }
                this.idx = tempIdx;
                StringBuilder buffer2 = new StringBuilder();
                buffer2.append(chars, 0, charPosition);
                buffer2.append(chars, charPosition + 1, chars.length());
                searchSuggestions(list, buffer2, charPosition, lastIdx, diff + 5);
            }
        }
        this.idx = lastIdx;
        int tempIdx2 = lastIdx;
        while (this.idx < this.size && this.tree[this.idx] < LAST_CHAR) {
            char newChar = this.tree[this.idx];
            this.idx = readIndex();
            if (this.idx > 0 && newChar != currentChar) {
                StringBuilder buffer3 = new StringBuilder(chars);
                buffer3.insert(charPosition, newChar);
                searchSuggestions(list, buffer3, charPosition + 1, this.idx, diff + 5);
            }
            tempIdx2 += 3;
            this.idx = tempIdx2;
        }
        if (charPosition < chars.length()) {
            char currentChar2 = chars.charAt(charPosition);
            this.idx = lastIdx;
            int tempIdx3 = lastIdx;
            while (this.idx < this.size && this.tree[this.idx] < LAST_CHAR) {
                if (isWordMatch()) {
                    StringBuilder buffer4 = new StringBuilder();
                    buffer4.append(chars, 0, charPosition);
                    buffer4.append(this.tree[this.idx]);
                    list.add(new Suggestion(buffer4, diff + 5 + ((chars.length() - buffer4.length()) * 5)));
                }
                if (charPosition + 1 < chars.length()) {
                    char newChar2 = this.tree[this.idx];
                    this.idx = readIndex();
                    if (this.idx > 0 && newChar2 != currentChar2) {
                        StringBuilder buffer5 = new StringBuilder(chars);
                        buffer5.setCharAt(charPosition, newChar2);
                        searchSuggestions(list, buffer5, charPosition + 1, this.idx, diff + charDiff(currentChar2, newChar2));
                    }
                }
                tempIdx3 += 3;
                this.idx = tempIdx3;
            }
        }
    }

    private void searchSuggestionsLonger(Suggestions list, CharSequence chars, int lastIdx, int diff) {
        this.idx = lastIdx;
        int tempIdx = lastIdx;
        while (this.idx < this.size && this.tree[this.idx] < LAST_CHAR) {
            StringBuilder buffer = new StringBuilder();
            buffer.append(chars);
            buffer.append(this.tree[this.idx]);
            searchSuggestions(list, buffer, chars.length(), this.idx, diff);
            tempIdx += 3;
            this.idx = tempIdx;
        }
    }

    private boolean searchChar(char c) {
        while (this.idx < this.size && this.tree[this.idx] < c) {
            this.idx += 3;
        }
        if (this.idx >= this.size || this.tree[this.idx] != c) {
            return false;
        }
        return true;
    }

    private boolean isWordMatch() {
        return (this.tree[this.idx + 1] & 32768) > 0;
    }

    final int readIndex() {
        return ((this.tree[this.idx + 1] & 32767) << 16) + this.tree[this.idx + 2];
    }

    private int charDiff(char a, char b) {
        char a2 = Character.toLowerCase(a);
        char b2 = Character.toLowerCase(b);
        if (a2 == b2) {
            return 1;
        }
        if (Character.getType(a2) != Character.getType(b2)) {
            return 6;
        }
        return 5;
    }
}
