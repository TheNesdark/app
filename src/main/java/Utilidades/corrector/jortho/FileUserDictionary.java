package Utilidades.corrector.jortho;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/FileUserDictionary.class */
public class FileUserDictionary implements UserDictionaryProvider {
    private final String fileBase;
    private File file;

    public FileUserDictionary() {
        this("");
    }

    public FileUserDictionary(String fileBase) {
        String fileBase2 = (fileBase == null ? "" : fileBase).trim().replace('\\', '/');
        if (fileBase2.length() > 0 && !fileBase2.endsWith("/")) {
            fileBase2 = fileBase2 + "/";
        }
        this.fileBase = fileBase2;
    }

    @Override // Utilidades.corrector.jortho.UserDictionaryProvider
    public void addWord(String word) {
        try {
            FileOutputStream output = new FileOutputStream(this.file, true);
            Writer writer = new OutputStreamWriter(output, "UTF8");
            if (this.file.length() > 0) {
                writer.write("\n");
            }
            writer.write(word);
            writer.close();
        } catch (Exception ex) {
            SpellChecker.getMessageHandler().handleException(ex);
        }
    }

    @Override // Utilidades.corrector.jortho.CustomDictionaryProvider
    public Iterator<String> getWords(Locale locale) {
        this.file = new File(this.fileBase + "UserDictionary_" + locale + ".txt");
        try {
            FileInputStream input = new FileInputStream(this.file);
            return new WordIterator(input, "UTF8");
        } catch (IOException e) {
            return null;
        }
    }

    @Override // Utilidades.corrector.jortho.UserDictionaryProvider
    public void setUserWords(String wordList) {
        try {
            FileOutputStream output = new FileOutputStream(this.file);
            Writer writer = new OutputStreamWriter(output, "UTF8");
            writer.write(wordList);
            writer.close();
        } catch (Exception ex) {
            SpellChecker.getMessageHandler().handleException(ex);
        }
    }
}
