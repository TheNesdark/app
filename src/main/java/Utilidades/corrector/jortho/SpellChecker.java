package Utilidades.corrector.jortho;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/SpellChecker.class */
public class SpellChecker {
    private static Dictionary currentDictionary;
    private static Locale currentLocale;
    private static UserDictionaryProvider userDictionaryProvider;
    private static CustomDictionaryProvider customDictionaryProvider;
    private static String applicationName;
    private static CustomUIProvider customUIProvider;
    static final String SELECTED_KEY = "SwingSelectedKey";
    private static final ArrayList<LanguageAction> languages = new ArrayList<>();
    private static final Map<LanguageChangeListener, Object> listeners = Collections.synchronizedMap(new WeakHashMap());
    private static final SpellCheckerOptions globalOptions = new SpellCheckerOptions();
    private static MessageHandler messageHandler = new DefaultMessageHandler(null);

    private SpellChecker() {
    }

    public static void setUserDictionaryProvider(UserDictionaryProvider userDictionaryProvider2) {
        userDictionaryProvider = userDictionaryProvider2;
    }

    public static UserDictionaryProvider getUserDictionaryProvider() {
        return userDictionaryProvider;
    }

    public static void setCustomDictionaryProvider(CustomDictionaryProvider customDictionaryProvider2) {
        customDictionaryProvider = customDictionaryProvider2;
    }

    public static CustomDictionaryProvider getCustomDictionaryProvider() {
        return customDictionaryProvider;
    }

    public static void setMessageHandler(MessageHandler messageHandler2) {
        if (messageHandler2 == null) {
            throw new IllegalArgumentException();
        }
        messageHandler = messageHandler2;
    }

    public static MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public static void setCustomUIProvider(CustomUIProvider customUIProvider2) {
        customUIProvider = customUIProvider2;
    }

    public static CustomUIProvider getCustomUIProvider() {
        return customUIProvider;
    }

    public static void registerDictionaries(URL baseURL, String activeLocale) {
        InputStream input;
        if (baseURL == null) {
            try {
                URL baseURL2 = SpellChecker.class.getResource("/corrector/dictionaries.cnf");
                if (baseURL2 != null) {
                    baseURL = new URL(baseURL2, ".");
                } else {
                    baseURL = new URL("file", (String) null, "");
                }
            } catch (MalformedURLException e) {
                getMessageHandler().handleException(e);
            }
        }
        try {
            input = new URL(baseURL, "dictionaries.cnf").openStream();
        } catch (Exception e1) {
            try {
                input = new URL(baseURL, "dictionaries.properties").openStream();
            } catch (Exception e2) {
                try {
                    input = new URL(baseURL, "dictionaries.txt").openStream();
                } catch (Exception e3) {
                    System.err.println("JOrtho configuration file not found!");
                    getMessageHandler().handleException(e1);
                    getMessageHandler().handleException(e2);
                    getMessageHandler().handleException(e3);
                    return;
                }
            }
        }
        Properties props = new Properties();
        try {
            props.load(input);
            String availableLocales = props.getProperty("languages");
            String extension = props.getProperty("extension", ".ortho");
            registerDictionaries(baseURL, availableLocales, activeLocale, extension);
        } catch (IOException e4) {
            getMessageHandler().handleException(e4);
        }
    }

    public static void registerDictionaries(URL baseURL, String availableLocales, String activeLocale) {
        registerDictionaries(baseURL, availableLocales, activeLocale, ".ortho");
    }

    public static void registerDictionaries(URL baseURL, String availableLocales, String activeLocale, String extension) {
        if (baseURL == null) {
            try {
                baseURL = new URL("file", (String) null, "");
            } catch (MalformedURLException e) {
                getMessageHandler().handleException(e);
            }
        }
        if (activeLocale == null) {
            activeLocale = "";
        }
        String activeLocale2 = activeLocale.trim();
        if (activeLocale2.length() == 0) {
            activeLocale2 = Locale.getDefault().getLanguage();
        }
        boolean activeSelected = false;
        for (String str : availableLocales.split(",")) {
            String locale = str.trim().toLowerCase();
            if (locale.length() > 0) {
                LanguageAction action = new LanguageAction(baseURL, new Locale(locale), extension);
                languages.remove(action);
                languages.add(action);
                if (locale.equals(activeLocale2)) {
                    action.actionPerformed(null);
                    activeSelected = true;
                }
            }
        }
        if (!activeSelected && languages.size() > 0) {
            languages.get(0).actionPerformed(null);
        }
        Collections.sort(languages);
    }

    public static void register(JTextComponent text) throws NullPointerException {
        register(text, true, true, true, true);
    }

    public static void register(JTextComponent text, boolean hasPopup, boolean submenu, boolean hasShortKey, boolean hasAutoSpell) throws NullPointerException {
        if (hasPopup) {
            enablePopup(text, true, submenu);
        }
        if (hasShortKey) {
            enableShortKey(text, true);
        }
        if (hasAutoSpell) {
            enableAutoSpell(text, true);
        }
    }

    public static void unregister(JTextComponent text) {
        enableShortKey(text, false);
        enablePopup(text, false, false);
        enableAutoSpell(text, false);
    }

    public static void enableShortKey(JTextComponent text, boolean enable) {
        enableShortKey(text, enable, null);
    }

    public static void enableShortKey(final JTextComponent text, boolean enable, final SpellCheckerOptions options) {
        if (enable) {
            text.getInputMap().put(KeyStroke.getKeyStroke(118, 0), "spell-checking");
            text.getActionMap().put("spell-checking", new AbstractAction() { // from class: Utilidades.corrector.jortho.SpellChecker.1
                public void actionPerformed(ActionEvent e) {
                    SpellChecker.showSpellCheckerDialog(text, options);
                }
            });
        } else {
            text.getActionMap().remove("spell-checking");
        }
    }

    public static void showSpellCheckerDialog(JTextComponent text, SpellCheckerOptions options) {
        Dictionary dictionary;
        SpellCheckerDialog dialog;
        if (text.isEditable() && (dictionary = currentDictionary) != null) {
            Frame windowAncestor = SwingUtilities.getWindowAncestor(text);
            if (windowAncestor instanceof Frame) {
                dialog = new SpellCheckerDialog(windowAncestor, true, options);
            } else {
                dialog = new SpellCheckerDialog((Dialog) windowAncestor, true, options);
            }
            dialog.show(text, dictionary, currentLocale);
        }
    }

    public static void enablePopup(JTextComponent text, boolean enable, boolean submenu) {
        JPopupMenu menu;
        if (enable) {
            if (submenu) {
                menu = new JPopupMenu();
                menu.add(createCheckerMenu());
                menu.add(createLanguagesMenu());
            } else {
                menu = createCheckerPopup();
            }
            text.addMouseListener(new PopupListener(menu));
            return;
        }
        for (MouseListener listener : text.getMouseListeners()) {
            if (listener instanceof PopupListener) {
                text.removeMouseListener(listener);
            }
        }
    }

    public static void enableAutoSpell(JTextComponent text, boolean enable) {
        enableAutoSpell(text, enable, null);
    }

    public static void enableAutoSpell(JTextComponent text, boolean enable, SpellCheckerOptions options) {
        if (enable) {
            new AutoSpellChecker(text, options);
        } else {
            AutoSpellChecker.disable(text);
        }
    }

    public static void addLanguageChangeLister(LanguageChangeListener listener) {
        listeners.put(listener, null);
    }

    public static void removeLanguageChangeLister(LanguageChangeListener listener) {
        listeners.remove(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fireLanguageChanged(Locale oldLocale) {
        Object[] list;
        LanguageChangeEvent ev = new LanguageChangeEvent(currentLocale, oldLocale);
        synchronized (listeners) {
            list = listeners.keySet().toArray();
        }
        for (Object listener : list) {
            ((LanguageChangeListener) listener).languageChanged(ev);
        }
    }

    public static JMenu createCheckerMenu() {
        return createCheckerMenu(null);
    }

    public static JMenu createCheckerMenu(SpellCheckerOptions options) {
        return new CheckerMenu(options);
    }

    public static JPopupMenu createCheckerPopup() {
        return createCheckerPopup(null);
    }

    public static JPopupMenu createCheckerPopup(SpellCheckerOptions options) {
        return new CheckerPopup(options);
    }

    public static JMenu createLanguagesMenu() {
        return createLanguagesMenu(null);
    }

    public static JMenu createLanguagesMenu(SpellCheckerOptions options) {
        JMenu menu = new JMenu(Utils.getResource("languages"));
        ButtonGroup group = new ButtonGroup();
        menu.setEnabled(languages.size() > 0);
        for (LanguageAction action : languages) {
            JRadioButtonMenuItem item = new JRadioButtonMenuItem(action);
            item.setModel(new ActionToggleButtonModel(action));
            menu.add(item);
            group.add(item);
        }
        if (options == null) {
            options = getOptions();
        }
        if (languages.size() > 0 && options.isLanguageDisableVisible()) {
            menu.addSeparator();
            JRadioButtonMenuItem item2 = new JRadioButtonMenuItem(DisableLanguageAction.instance);
            item2.setModel(new ActionToggleButtonModel(DisableLanguageAction.instance));
            menu.add(item2);
            group.add(item2);
        }
        return menu;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/SpellChecker$ActionToggleButtonModel.class */
    private static class ActionToggleButtonModel extends JToggleButton.ToggleButtonModel {
        private final AbtsractLanguageAction action;

        ActionToggleButtonModel(AbtsractLanguageAction action) {
            this.action = action;
        }

        public boolean isSelected() {
            return Boolean.TRUE.equals(this.action.getValue(SpellChecker.SELECTED_KEY));
        }

        public void setSelected(boolean b) {
            ButtonGroup group = getGroup();
            if (group != null) {
                group.setSelected(this, b);
                b = group.isSelected(this);
            }
            if (isSelected() == b) {
                return;
            }
            this.action.setSelected(b);
            fireStateChanged();
            fireItemStateChanged(new ItemEvent(this, 701, this, isSelected() ? 1 : 2));
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/SpellChecker$AbtsractLanguageAction.class */
    private static abstract class AbtsractLanguageAction extends AbstractAction {
        private static AbtsractLanguageAction currentAction;

        public AbtsractLanguageAction(String name) {
            super(name);
        }

        public void setSelected(boolean b) {
            if (b) {
                if (currentAction != null && currentAction != this) {
                    currentAction.setSelected(false);
                }
                currentAction = this;
            }
            putValue(SpellChecker.SELECTED_KEY, Boolean.valueOf(b));
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/SpellChecker$DisableLanguageAction.class */
    private static class DisableLanguageAction extends AbtsractLanguageAction {
        static DisableLanguageAction instance = new DisableLanguageAction();

        private DisableLanguageAction() {
            super(Utils.getResource("disable"));
        }

        public void actionPerformed(ActionEvent ev) {
            if (!isEnabled()) {
                return;
            }
            setEnabled(false);
            setSelected(true);
            try {
                Dictionary unused = SpellChecker.currentDictionary = null;
                Locale oldLocale = SpellChecker.currentLocale;
                Locale unused2 = SpellChecker.currentLocale = null;
                SpellChecker.fireLanguageChanged(oldLocale);
            } finally {
                setEnabled(true);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/SpellChecker$LanguageAction.class */
    private static class LanguageAction extends AbtsractLanguageAction implements Comparable<LanguageAction> {
        private final URL baseURL;
        private final Locale locale;
        private String extension;

        LanguageAction(URL baseURL, Locale locale, String extension) {
            super(locale.getDisplayLanguage());
            this.baseURL = baseURL;
            this.locale = locale;
            this.extension = extension;
        }

        public void actionPerformed(ActionEvent ev) {
            if (!isEnabled()) {
                return;
            }
            setEnabled(false);
            setSelected(true);
            Thread thread = new Thread(new Runnable() { // from class: Utilidades.corrector.jortho.SpellChecker.LanguageAction.1
                @Override // java.lang.Runnable
                public void run() {
                    Iterator<String> userWords;
                    Iterator<String> userWords2;
                    try {
                        DictionaryFactory factory = new DictionaryFactory();
                        try {
                            factory.loadWordList(new URL(LanguageAction.this.baseURL, "dictionary_" + LanguageAction.this.locale + LanguageAction.this.extension));
                        } catch (Exception ex) {
                            SpellChecker.getMessageHandler().handleError(ex.toString(), "Error", ex);
                        }
                        try {
                            CustomDictionaryProvider provider = SpellChecker.userDictionaryProvider;
                            if (provider != null && (userWords2 = provider.getWords(LanguageAction.this.locale)) != null) {
                                factory.loadWords(userWords2);
                            }
                            CustomDictionaryProvider provider2 = SpellChecker.customDictionaryProvider;
                            if (provider2 != null && (userWords = provider2.getWords(LanguageAction.this.locale)) != null) {
                                factory.loadWords(userWords);
                            }
                        } catch (Exception ex2) {
                            SpellChecker.getMessageHandler().handleError(ex2.toString(), "Error", ex2);
                        }
                        Locale oldLocale = LanguageAction.this.locale;
                        Dictionary unused = SpellChecker.currentDictionary = factory.create();
                        Locale unused2 = SpellChecker.currentLocale = LanguageAction.this.locale;
                        SpellChecker.fireLanguageChanged(oldLocale);
                        LanguageAction.this.setEnabled(true);
                    } catch (Throwable th) {
                        LanguageAction.this.setEnabled(true);
                        throw th;
                    }
                }
            });
            thread.setPriority(5);
            thread.setDaemon(true);
            thread.start();
        }

        public boolean equals(Object obj) {
            if (obj instanceof LanguageAction) {
                return this.locale.equals(((LanguageAction) obj).locale);
            }
            return false;
        }

        public int hashCode() {
            return this.locale.hashCode();
        }

        @Override // java.lang.Comparable
        public int compareTo(LanguageAction obj) {
            return toString().compareTo(obj.toString());
        }
    }

    static Dictionary getCurrentDictionary() {
        return currentDictionary;
    }

    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    public static void setCurrentLocale(Locale locale) throws IllegalArgumentException {
        if (locale.equals(currentLocale)) {
            return;
        }
        for (LanguageAction language : languages) {
            if (language.locale.equals(locale)) {
                language.actionPerformed(null);
                return;
            }
        }
        throw new IllegalArgumentException("Not registered locale: " + locale);
    }

    public static boolean isDictionaryLoaded() {
        return currentDictionary != null && currentDictionary.getDataSize() > 1;
    }

    public static void setApplicationName(String name) {
        applicationName = name;
    }

    public static String getApplicationName() {
        return applicationName;
    }

    public static SpellCheckerOptions getOptions() {
        return globalOptions;
    }
}
