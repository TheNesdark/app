package Utilidades.corrector.jortho;

import java.util.Locale;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/LanguageChangeEvent.class */
public class LanguageChangeEvent {
    private final Locale currentLocale;
    private final Locale oldLocale;

    public LanguageChangeEvent(Locale currentLocale, Locale oldLocale) {
        this.currentLocale = currentLocale;
        this.oldLocale = oldLocale;
    }

    public Locale getOldLocale() {
        return this.oldLocale;
    }

    public Locale getCurrentLocale() {
        return this.currentLocale;
    }
}
