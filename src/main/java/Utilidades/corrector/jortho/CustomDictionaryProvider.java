package Utilidades.corrector.jortho;

import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/CustomDictionaryProvider.class */
public interface CustomDictionaryProvider {
    Iterator<String> getWords(Locale locale);
}
