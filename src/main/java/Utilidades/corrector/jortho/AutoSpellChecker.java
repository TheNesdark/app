package Utilidades.corrector.jortho;

import java.util.Locale;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/AutoSpellChecker.class */
class AutoSpellChecker implements DocumentListener, LanguageChangeListener {
    private static final RedZigZagPainter painter = new RedZigZagPainter();
    private final JTextComponent jText;
    private final SpellCheckerOptions options;
    private Dictionary dictionary;
    private Locale locale;

    public AutoSpellChecker(JTextComponent text, SpellCheckerOptions options) {
        this.jText = text;
        this.options = options == null ? SpellChecker.getOptions() : options;
        this.jText.getDocument().addDocumentListener(this);
        SpellChecker.addLanguageChangeLister(this);
        this.dictionary = SpellChecker.getCurrentDictionary();
        this.locale = SpellChecker.getCurrentLocale();
        checkAll();
    }

    static void disable(JTextComponent text) {
        AbstractDocument doc = text.getDocument();
        for (DocumentListener listener : doc.getDocumentListeners()) {
            if (listener instanceof AutoSpellChecker) {
                AutoSpellChecker autoSpell = (AutoSpellChecker) listener;
                doc.removeDocumentListener(autoSpell);
                removeHighlights(text);
            }
        }
    }

    private static void removeHighlights(JTextComponent text) {
        Highlighter highlighter = text.getHighlighter();
        for (Highlighter.Highlight highlight : highlighter.getHighlights()) {
            if (highlight.getPainter() == painter) {
                highlighter.removeHighlight(highlight);
            }
        }
    }

    static void refresh(JTextComponent text) {
        AbstractDocument doc = text.getDocument();
        for (DocumentListener listener : doc.getDocumentListeners()) {
            if (listener instanceof AutoSpellChecker) {
                AutoSpellChecker autoSpell = (AutoSpellChecker) listener;
                autoSpell.checkAll();
            }
        }
    }

    public void changedUpdate(DocumentEvent ev) {
    }

    public void insertUpdate(DocumentEvent ev) {
        checkElements(ev.getOffset(), ev.getLength());
    }

    public void removeUpdate(DocumentEvent ev) {
        checkElements(ev.getOffset(), 0);
    }

    private void checkElements(int offset, int length) {
        int end = offset + length;
        AbstractDocument document = this.jText.getDocument();
        do {
            try {
                Element element = document.getParagraphElement(offset);
                checkElement(element);
                int endOffset = element.getEndOffset();
                offset = endOffset > offset ? endOffset : offset + 1;
                if (offset > end) {
                    return;
                }
            } catch (Exception e) {
                return;
            }
        } while (offset < document.getLength());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkElement(Element element) {
        try {
            int i = element.getStartOffset();
            int j = element.getEndOffset();
            Highlighter highlighter = this.jText.getHighlighter();
            Highlighter.Highlight[] highlights = highlighter.getHighlights();
            int k = highlights.length;
            while (true) {
                k--;
                if (k < 0) {
                    break;
                }
                Highlighter.Highlight highlight = highlights[k];
                int hlStartOffset = highlight.getStartOffset();
                int hlEndOffset = highlight.getEndOffset();
                if (((i <= hlStartOffset && hlStartOffset <= j) || (i <= hlEndOffset && hlEndOffset <= j)) && highlight.getPainter() == painter) {
                    highlighter.removeHighlight(highlight);
                }
            }
            int l = this.jText.getDocument().getLength();
            int j2 = Math.min(j, l);
            if (i >= j2) {
                return;
            }
            Dictionary dic = this.dictionary;
            Locale loc = this.locale;
            if (dic == null || loc == null) {
                return;
            }
            Tokenizer tok = new Tokenizer(this.jText, dic, loc, i, j2, this.options);
            while (true) {
                String word = tok.nextInvalidWord();
                if (word != null) {
                    int wordOffset = tok.getWordOffset();
                    highlighter.addHighlight(wordOffset, wordOffset + word.length(), painter);
                } else {
                    return;
                }
            }
        } catch (BadLocationException e) {
            SpellChecker.getMessageHandler().handleException(e);
        }
    }

    private void checkAll() {
        if (this.jText == null) {
            return;
        }
        if (this.dictionary == null) {
            removeHighlights(this.jText);
        } else {
            if (this.jText.getDocument().getLength() == 0) {
                return;
            }
            Thread thread = new Thread(new Runnable() { // from class: Utilidades.corrector.jortho.AutoSpellChecker.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractDocument document = AutoSpellChecker.this.jText.getDocument();
                    int i = 0;
                    while (i < document.getLength()) {
                        try {
                            final Element element = document.getParagraphElement(i);
                            i = element.getEndOffset();
                            SwingUtilities.invokeLater(new Runnable() { // from class: Utilidades.corrector.jortho.AutoSpellChecker.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AutoSpellChecker.this.checkElement(element);
                                }
                            });
                        } catch (Exception e) {
                            return;
                        }
                    }
                }
            }, "JOrtho checkall");
            thread.setPriority(4);
            thread.setDaemon(true);
            thread.start();
        }
    }

    @Override // Utilidades.corrector.jortho.LanguageChangeListener
    public void languageChanged(LanguageChangeEvent ev) {
        this.dictionary = SpellChecker.getCurrentDictionary();
        this.locale = SpellChecker.getCurrentLocale();
        checkAll();
    }
}
