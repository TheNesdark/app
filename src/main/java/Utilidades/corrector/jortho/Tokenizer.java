package Utilidades.corrector.jortho;

import java.text.BreakIterator;
import java.util.Locale;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/Tokenizer.class */
class Tokenizer {
    private final Document doc;
    private final SpellCheckerOptions options;
    private final LanguageBundle bundle;
    private int paragraphOffset;
    private int endOffset;
    private String phrase;
    private final Dictionary dictionary;
    private BreakIterator sentences;
    private int startSentence;
    private int endSentence;
    private int startWord;
    private int endWord;
    private String sentence;
    private BreakIterator words;
    private int wordOffset;
    private boolean isFirstWordInSentence;

    Tokenizer(JTextComponent jText, Dictionary dictionary, Locale locale, SpellCheckerOptions options) {
        this(jText, dictionary, locale, 0, jText.getDocument().getLength(), options);
    }

    Tokenizer(JTextComponent jText, Dictionary dictionary, Locale locale, int offset, SpellCheckerOptions options) {
        this(jText, dictionary, locale, Utilities.getParagraphElement(jText, offset).getStartOffset(), Utilities.getParagraphElement(jText, offset).getEndOffset(), options);
    }

    Tokenizer(JTextComponent jText, Dictionary dictionary, Locale locale, int startOffset, int endOffset, SpellCheckerOptions options) {
        this.dictionary = dictionary;
        this.doc = jText.getDocument();
        this.bundle = LanguageBundle.get(locale);
        this.options = options == null ? SpellChecker.getOptions() : options;
        this.sentences = BreakIterator.getSentenceInstance(locale);
        this.words = BreakIterator.getWordInstance(locale);
        this.paragraphOffset = startOffset;
        this.endOffset = endOffset;
        setSentencesText();
        this.endSentence = this.sentences.first();
        this.endWord = -1;
    }

    String nextInvalidWord() {
        this.isFirstWordInSentence = false;
        while (true) {
            if (this.endWord == -1) {
                this.startSentence = this.endSentence;
                this.endSentence = this.sentences.next();
                if (this.endSentence == -1) {
                    if (!nextParagraph()) {
                        return null;
                    }
                } else {
                    nextSentence();
                }
            }
            while (this.endWord != -1) {
                String word = this.sentence.substring(this.startWord, this.endWord).trim();
                this.wordOffset = this.startSentence + this.startWord;
                this.startWord = this.endWord;
                this.endWord = this.words.next();
                if (word.length() > 1 && Character.isLetter(word.charAt(0))) {
                    boolean exist = this.bundle.existInDictionary(word, this.dictionary, this.options, this.isFirstWordInSentence);
                    if (!exist && this.options.isIgnoreAllCapsWords() && Utils.isAllCapitalized(word)) {
                        exist = true;
                    }
                    if (!exist && this.options.isIgnoreWordsWithNumbers() && Utils.isIncludeNumbers(word)) {
                        exist = true;
                    }
                    if (!exist && this.startWord + 1 == this.endWord) {
                        char nextChar = this.sentence.charAt(this.startWord);
                        switch (nextChar) {
                            case '\'':
                            case '.':
                                exist = this.bundle.existInDictionary(word + nextChar, this.dictionary, this.options, this.isFirstWordInSentence);
                                break;
                        }
                    }
                    if (!exist && !isWebAddress(word)) {
                        return word;
                    }
                    this.isFirstWordInSentence = false;
                } else if (":".equals(word) || "(".equals(word)) {
                    this.isFirstWordInSentence = true;
                }
            }
        }
    }

    private boolean isWebAddress(String word) {
        if (this.startWord >= this.sentence.length()) {
            return false;
        }
        if (this.sentence.charAt(this.startWord) == '@') {
            String str = word + '@';
            this.startWord = this.endWord;
            this.endWord = this.words.next();
            String domaine = this.sentence.substring(this.startWord, this.endWord).trim();
            if (domaine.length() > 3 && domaine.indexOf(46) > 0) {
                this.startWord = this.endWord;
                this.endWord = this.words.next();
                return true;
            }
            return false;
        }
        if (this.startWord + 3 < this.sentence.length() && this.sentence.charAt(this.startWord) == ':' && this.sentence.charAt(this.startWord + 1) == '/' && this.sentence.charAt(this.startWord + 2) == '/') {
            while (this.startWord < this.endWord) {
                String next = this.sentence.substring(this.startWord, this.endWord).trim();
                if (next.length() > 0) {
                    word = word + next;
                    this.startWord = this.endWord;
                    this.endWord = this.words.next();
                } else {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    boolean isFirstWordInSentence() {
        return this.isFirstWordInSentence;
    }

    private boolean nextParagraph() {
        if (this.doc instanceof AbstractDocument) {
            this.paragraphOffset = this.doc.getParagraphElement(this.paragraphOffset).getEndOffset();
            if (this.paragraphOffset >= this.endOffset) {
                return false;
            }
            loadSentences();
            return true;
        }
        return false;
    }

    private void loadSentences() {
        setSentencesText();
        this.startSentence = this.sentences.first();
        this.endSentence = this.sentences.next();
        nextSentence();
    }

    private void setSentencesText() {
        int end = this.endOffset;
        if (this.doc instanceof AbstractDocument) {
            end = this.doc.getParagraphElement(this.paragraphOffset).getEndOffset();
        }
        try {
            this.phrase = this.doc.getText(this.paragraphOffset, end - this.paragraphOffset);
            this.phrase = Utils.replaceUnicodeQuotation(this.phrase);
        } catch (BadLocationException e) {
            SpellChecker.getMessageHandler().handleException(e);
        }
        this.sentences.setText(this.phrase);
    }

    private void nextSentence() {
        this.sentence = this.phrase.substring(this.startSentence, this.endSentence);
        this.words.setText(this.sentence);
        this.startWord = this.words.first();
        this.endWord = this.words.next();
        this.isFirstWordInSentence = true;
    }

    int getWordOffset() {
        return this.paragraphOffset + this.wordOffset;
    }

    void updatePhrase() {
        this.endOffset = this.doc.getLength();
        setSentencesText();
        this.endSentence = this.sentences.following(this.startSentence);
        this.sentence = this.phrase.substring(this.startSentence, this.endSentence);
        this.words.setText(this.sentence);
        this.startWord = this.words.following(this.wordOffset - this.startSentence);
        this.endWord = this.words.next();
    }
}
