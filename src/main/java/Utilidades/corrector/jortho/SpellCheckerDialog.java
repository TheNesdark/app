package Utilidades.corrector.jortho;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/SpellCheckerDialog.class */
class SpellCheckerDialog extends JDialog implements ActionListener {
    private JTextComponent jText;
    private Dictionary dictionary;
    private Tokenizer tok;
    private boolean isDictionaryModify;
    private final SpellCheckerOptions options;
    private final JLabel notFound;
    private final JTextField word;
    private final JList suggestionsList;
    private final JButton ignore;
    private final JButton ignoreAll;
    private final JButton addToDic;
    private final JButton editDic;
    private final JButton change;
    private final JButton changeAll;
    private final JButton close;
    private final ArrayList<String> ignoreWords;
    private final HashMap<String, String> changeWords;

    SpellCheckerDialog(Dialog owner) throws HeadlessException {
        this(owner, false, (SpellCheckerOptions) null);
    }

    SpellCheckerDialog(Dialog owner, boolean modal, SpellCheckerOptions options) {
        super(owner, modal);
        this.notFound = Utils.getLabel(null);
        this.word = Utils.getTextField();
        this.suggestionsList = Utils.getList();
        this.ignore = Utils.getButton("ignore");
        this.ignoreAll = Utils.getButton("ignoreAll");
        this.addToDic = Utils.getButton("addToDictionary");
        this.editDic = Utils.getButton("editDictionary");
        this.change = Utils.getButton("change");
        this.changeAll = Utils.getButton("changeAll");
        this.close = Utils.getButton("close");
        this.ignoreWords = new ArrayList<>();
        this.changeWords = new HashMap<>();
        this.options = options == null ? SpellChecker.getOptions() : options;
        init();
    }

    SpellCheckerDialog(Frame owner) {
        this(owner, false, (SpellCheckerOptions) null);
    }

    SpellCheckerDialog(Frame owner, boolean modal, SpellCheckerOptions options) {
        super(owner, modal);
        this.notFound = Utils.getLabel(null);
        this.word = Utils.getTextField();
        this.suggestionsList = Utils.getList();
        this.ignore = Utils.getButton("ignore");
        this.ignoreAll = Utils.getButton("ignoreAll");
        this.addToDic = Utils.getButton("addToDictionary");
        this.editDic = Utils.getButton("editDictionary");
        this.change = Utils.getButton("change");
        this.changeAll = Utils.getButton("changeAll");
        this.close = Utils.getButton("close");
        this.ignoreWords = new ArrayList<>();
        this.changeWords = new HashMap<>();
        this.options = options == null ? SpellChecker.getOptions() : options;
        init();
    }

    private final void init() {
        Utils.setDialogIcon(this);
        setDefaultCloseOperation(2);
        Container cont = getContentPane();
        cont.setLayout(new GridBagLayout());
        Insets insetL = new Insets(8, 8, 0, 8);
        Insets insetR = new Insets(8, 0, 0, 8);
        cont.add(Utils.getLabel(Utils.getResource("notInDictionary") + ":"), new GridBagConstraints(1, 1, 1, 1, 0.0d, 0.0d, 16, 0, insetL, 0, 0));
        this.notFound.setForeground(Color.RED);
        this.notFound.setText("xxxxxxxxxx");
        cont.add(this.notFound, new GridBagConstraints(2, 1, 1, 1, 0.0d, 0.0d, 16, 0, insetL, 0, 0));
        cont.add(this.word, new GridBagConstraints(1, 2, 2, 1, 1.0d, 0.0d, 18, 2, insetL, 0, 0));
        cont.add(Utils.getLabel(Utils.getResource("suggestions") + ":"), new GridBagConstraints(1, 3, 2, 1, 0.0d, 0.0d, 16, 0, insetL, 0, 0));
        JScrollPane scrollPane = new JScrollPane(this.suggestionsList);
        cont.add(scrollPane, new GridBagConstraints(1, 4, 2, 6, 1.0d, 1.0d, 18, 1, new Insets(8, 8, 8, 8), 0, 0));
        cont.add(this.ignore, new GridBagConstraints(3, 1, 1, 1, 0.0d, 0.0d, 18, 2, insetR, 0, 0));
        cont.add(this.ignoreAll, new GridBagConstraints(3, 2, 1, 1, 0.0d, 0.0d, 18, 2, insetR, 0, 0));
        cont.add(this.addToDic, new GridBagConstraints(3, 3, 1, 1, 0.0d, 0.0d, 18, 2, insetR, 0, 0));
        cont.add(this.editDic, new GridBagConstraints(3, 4, 1, 1, 0.0d, 0.0d, 18, 2, insetR, 0, 0));
        cont.add(this.change, new GridBagConstraints(3, 5, 1, 1, 0.0d, 0.0d, 18, 2, insetR, 0, 0));
        cont.add(this.changeAll, new GridBagConstraints(3, 6, 1, 1, 0.0d, 0.0d, 18, 2, insetR, 0, 0));
        cont.add(this.close, new GridBagConstraints(3, 7, 1, 1, 0.0d, 0.0d, 18, 2, insetR, 0, 0));
        cont.add(Utils.getLabel(null), new GridBagConstraints(3, 8, 1, 1, 0.0d, 1.0d, 18, 2, insetR, 0, 0));
        this.ignore.addActionListener(this);
        this.ignoreAll.addActionListener(this);
        this.addToDic.addActionListener(this);
        this.editDic.addActionListener(this);
        this.change.addActionListener(this);
        this.changeAll.addActionListener(this);
        this.close.addActionListener(this);
        this.close.getInputMap(2).put(KeyStroke.getKeyStroke(27, 0, false), "ESCAPE");
        this.close.getActionMap().put("ESCAPE", new AbstractAction() { // from class: Utilidades.corrector.jortho.SpellCheckerDialog.1
            public void actionPerformed(ActionEvent e) {
                SpellCheckerDialog.this.dispose();
            }
        });
        this.word.getDocument().addDocumentListener(new DocumentListener() { // from class: Utilidades.corrector.jortho.SpellCheckerDialog.2
            public void changedUpdate(DocumentEvent ev) {
                SpellCheckerDialog.this.addToDic.setEnabled(false);
            }

            public void insertUpdate(DocumentEvent ev) {
                SpellCheckerDialog.this.addToDic.setEnabled(false);
            }

            public void removeUpdate(DocumentEvent ev) {
                SpellCheckerDialog.this.addToDic.setEnabled(false);
            }
        });
        this.suggestionsList.addListSelectionListener(new ListSelectionListener() { // from class: Utilidades.corrector.jortho.SpellCheckerDialog.3
            public void valueChanged(ListSelectionEvent ev) {
                if (!ev.getValueIsAdjusting() && SpellCheckerDialog.this.suggestionsList.getSelectedIndex() >= 0) {
                    SpellCheckerDialog.this.word.setText((String) SpellCheckerDialog.this.suggestionsList.getSelectedValue());
                    SpellCheckerDialog.this.addToDic.setEnabled(true);
                }
            }
        });
        this.suggestionsList.addMouseListener(new MouseAdapter() { // from class: Utilidades.corrector.jortho.SpellCheckerDialog.4
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == 1 && SpellCheckerDialog.this.suggestionsList.getSelectedIndex() >= 0) {
                    SpellCheckerDialog.this.word.setText((String) SpellCheckerDialog.this.suggestionsList.getSelectedValue());
                    SpellCheckerDialog.this.actionPerformed(new ActionEvent(SpellCheckerDialog.this.suggestionsList, 0, (String) null));
                }
            }
        });
        boolean isUserDictionary = SpellChecker.getUserDictionaryProvider() != null;
        this.addToDic.setEnabled(isUserDictionary);
        this.editDic.setEnabled(isUserDictionary);
        pack();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void show(javax.swing.text.JTextComponent r9, Utilidades.corrector.jortho.Dictionary r10, java.util.Locale r11) {
        /*
            r8 = this;
            r0 = r8
            r1 = r9
            r0.jText = r1
            r0 = r8
            r1 = r10
            r0.dictionary = r1
            r0 = r8
            javax.swing.JButton r0 = r0.change
            r0.requestFocus()
            r0 = r8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.String r2 = "spelling"
            java.lang.String r2 = Utilidades.corrector.jortho.Utils.getResource(r2)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ": "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r11
            java.lang.String r2 = r2.getDisplayLanguage()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.setTitle(r1)
            r0 = r8
            Utilidades.corrector.jortho.Tokenizer r1 = new Utilidades.corrector.jortho.Tokenizer
            r2 = r1
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r8
            Utilidades.corrector.jortho.SpellCheckerOptions r6 = r6.options
            r2.<init>(r3, r4, r5, r6)
            r0.tok = r1
            r0 = r8
            boolean r0 = r0.searchNext()
            if (r0 == 0) goto L9e
            r0 = r9
            r12 = r0
        L4f:
            r0 = r12
            if (r0 == 0) goto L93
            r0 = r12
            boolean r0 = r0 instanceof javax.swing.JScrollPane
            if (r0 != 0) goto L93
            r0 = r12
            boolean r0 = r0 instanceof javax.swing.JComponent
            if (r0 == 0) goto L81
            r0 = r12
            javax.swing.JComponent r0 = (javax.swing.JComponent) r0
            r13 = r0
            r0 = r13
            java.awt.Rectangle r0 = r0.getVisibleRect()
            int r0 = r0.height
            r1 = r13
            java.awt.Rectangle r1 = r1.getBounds()
            int r1 = r1.height
            if (r0 != r1) goto L81
            goto L93
        L81:
            r0 = r12
            java.awt.Container r0 = r0.getParent()
            if (r0 == 0) goto L93
            r0 = r12
            java.awt.Container r0 = r0.getParent()
            r12 = r0
            goto L4f
        L93:
            r0 = r8
            r1 = r12
            r0.setLocationRelativeTo(r1)
            r0 = r8
            r1 = 1
            r0.setVisible(r1)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Utilidades.corrector.jortho.SpellCheckerDialog.show(javax.swing.text.JTextComponent, Utilidades.corrector.jortho.Dictionary, java.util.Locale):void");
    }

    private boolean searchNext() {
        while (true) {
            String wordStr = this.tok.nextInvalidWord();
            if (wordStr == null) {
                dispose();
                String title = SpellChecker.getApplicationName();
                if (title == null) {
                    title = getTitle();
                }
                SpellChecker.getMessageHandler().handleInformation(getParent(), title, Utils.getResource("msgFinish"));
                return false;
            }
            if (!this.ignoreWords.contains(wordStr)) {
                String changeTo = this.changeWords.get(wordStr);
                if (changeTo != null) {
                    replaceWord(wordStr, changeTo);
                } else {
                    this.word.setText(wordStr);
                    this.notFound.setText(wordStr);
                    List<Suggestion> list = this.dictionary.searchSuggestions(wordStr);
                    boolean needCapitalization = this.tok.isFirstWordInSentence() && Utils.isFirstCapitalized(wordStr);
                    Vector<String> suggestionsVector = new Vector<>();
                    for (int i = 0; i < list.size() && i < this.options.getSuggestionsLimitDialog(); i++) {
                        Suggestion sugestion = list.get(i);
                        String newWord = sugestion.getWord();
                        if (needCapitalization) {
                            newWord = Utils.getCapitalized(newWord);
                        }
                        if (i == 0) {
                            this.word.setText(newWord);
                        }
                        suggestionsVector.add(newWord);
                    }
                    this.suggestionsList.setListData(suggestionsVector);
                    this.addToDic.setEnabled(true);
                    return true;
                }
            }
        }
    }

    public void actionPerformed(ActionEvent ev) {
        Object source = ev.getSource();
        if (source == this.ignore) {
            searchNext();
            return;
        }
        if (source == this.close) {
            dispose();
            return;
        }
        String newWord = this.word.getText();
        String oldWord = this.notFound.getText();
        if (source == this.ignoreAll) {
            this.ignoreWords.add(oldWord);
            searchNext();
            return;
        }
        if (source == this.addToDic) {
            UserDictionaryProvider provider = SpellChecker.getUserDictionaryProvider();
            if (provider != null) {
                provider.addWord(oldWord);
            }
            this.dictionary.add(oldWord);
            this.dictionary.trimToSize();
            this.isDictionaryModify = true;
            searchNext();
            return;
        }
        if (source == this.editDic) {
            new DictionaryEditDialog(this).setVisible(true);
            return;
        }
        if (source == this.change || source == this.suggestionsList) {
            replaceWord(oldWord, newWord);
            searchNext();
        } else if (source == this.changeAll) {
            this.changeWords.put(oldWord, newWord);
            replaceWord(oldWord, newWord);
            searchNext();
        }
    }

    private void replaceWord(String oldWord, String newWord) {
        this.jText.setSelectionStart(this.tok.getWordOffset());
        this.jText.setSelectionEnd(this.tok.getWordOffset() + oldWord.length());
        this.jText.replaceSelection(newWord);
        this.tok.updatePhrase();
    }

    public void dispose() {
        super.dispose();
        if (this.isDictionaryModify) {
            AutoSpellChecker.refresh(this.jText);
        }
    }
}
