package Utilidades.corrector.jorthodictionaries;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jorthodictionaries/BookGenerator.class */
public abstract class BookGenerator {
    private final Book book;

    abstract boolean isValidLanguage(String str, String str2);

    public static void main(String[] args) throws Exception {
        String languagesList = args.length > 0 ? args[0] : "en";
        String dirName = args.length > 1 ? args[1].replace('\\', '/') : "";
        if (dirName.length() > 0 && !dirName.endsWith("/")) {
            dirName = dirName + '/';
        }
        String[] languages = languagesList.split(",");
        for (String language : languages) {
            String filename = dirName + language + "wiktionary-latest-pages-articles.xml";
            File file = new File(filename);
            BookGenerator generator = (BookGenerator) Class.forName(BookGenerator.class.getName() + "_" + language).newInstance();
            generator.start(file);
            generator.save(language);
            generator.createPackage(language);
        }
    }

    BookGenerator() {
        this(new Book());
    }

    BookGenerator(Book book) {
        this.book = book;
    }

    void start(File file) throws Exception {
        InputStream stream = new FileInputStream(file);
        System.out.println("=== Start Parsing XML stream ===");
        new Parser(this, stream);
        stream.close();
    }

    final void save(String language) throws Exception {
        File dictFile = new File("dictionary_" + language + ".ortho");
        OutputStream dict = new FileOutputStream(dictFile);
        OutputStream dict2 = new BufferedOutputStream(dict);
        Deflater deflater = new Deflater();
        deflater.setLevel(9);
        PrintStream dictPs = new PrintStream(new BufferedOutputStream(new DeflaterOutputStream(dict2, deflater)), false, "UTF8");
        OutputStream txt = new FileOutputStream("IncludedWords.txt");
        PrintStream ps = new PrintStream(new BufferedOutputStream(txt), false, "UTF8");
        String[] words = this.book.getWords();
        Arrays.sort(words);
        for (int i = 0; i < words.length; i++) {
            ps.print(words[i] + '\n');
            dictPs.print(words[i] + '\n');
        }
        ps.close();
        dictPs.close();
        saveStatistics(dictFile);
    }

    private final void saveStatistics(File dictFile) throws Exception {
        String statistics = "Total Wiktionary Title count: " + this.book.getTitleCount() + "\r\n";
        String statistics2 = (((statistics + "Language Title count: " + this.book.getLanguageTitleCount() + "\r\n") + "Word count in dictionary: " + this.book.getWordCount() + "\r\n") + "Char count in dictionary: " + this.book.getCharCount() + "\r\n") + "Dictionary size on disk (bytes): " + dictFile.length() + "\r\n";
        Class<?> cls = Class.forName("com.inet.jortho.DictionaryFactory");
        Constructor<?> constructor = cls.getConstructor(new Class[0]);
        constructor.setAccessible(true);
        Object factory = constructor.newInstance(new Object[0]);
        Method loadWordList = cls.getDeclaredMethod("loadWordList", URL.class);
        loadWordList.setAccessible(true);
        loadWordList.invoke(factory, dictFile.toURL());
        Method create = cls.getDeclaredMethod("create", new Class[0]);
        create.setAccessible(true);
        Object dictionary = create.invoke(factory, new Object[0]);
        Method getDataSize = dictionary.getClass().getDeclaredMethod("getDataSize", new Class[0]);
        getDataSize.setAccessible(true);
        Integer size = (Integer) getDataSize.invoke(dictionary, new Object[0]);
        String statistics3 = statistics2 + "Dictionary size in memory (bytes): " + size + "\r\n";
        System.out.println(statistics3);
        FileOutputStream out = new FileOutputStream("statistics.txt");
        out.write(statistics3.getBytes());
        out.close();
    }

    private final void createPackage(String language) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("dictionary_" + language + "_" + new SimpleDateFormat("yyyy_MM").format(new Date()) + ".zip"));
        out.setLevel(9);
        addFileToZip(out, "license.txt", false);
        addFileToZip(out, "dictionary_" + language + ".ortho", true);
        addFileToZip(out, "statistics.txt", true);
        addFileToZip(out, "IncludedWords.txt", true);
        out.close();
    }

    private final void addFileToZip(ZipOutputStream out, String filename, boolean delete) throws Exception {
        File file = new File(filename);
        FileInputStream fin = new FileInputStream(file);
        ZipEntry entry = new ZipEntry(filename);
        entry.setTime(file.lastModified());
        out.putNextEntry(entry);
        byte[] buffer = new byte[16384];
        while (true) {
            int count = fin.read(buffer);
            if (count <= 0) {
                break;
            } else {
                out.write(buffer, 0, count);
            }
        }
        out.closeEntry();
        fin.close();
        if (delete) {
            file.delete();
        }
    }

    protected final int indexOf(String string, char[] chars, int fromIndex) {
        while (fromIndex < string.length()) {
            char c = string.charAt(fromIndex);
            for (char c2 : chars) {
                if (c == c2) {
                    return fromIndex;
                }
            }
            fromIndex++;
        }
        return -1;
    }

    protected boolean isValidWord(String word) {
        int length;
        if (word == null || (length = word.length()) <= 1) {
            return false;
        }
        int last = length - 1;
        for (int i = last; i >= 0; i--) {
            char ch = word.charAt(i);
            if (!Character.isLetter(ch)) {
                if (ch == '\'') {
                    if (i == last && word.charAt(0) == '\'') {
                        return false;
                    }
                    if (i > 0 && word.charAt(i - 1) == '\'') {
                        return false;
                    }
                } else if ((ch != '.' || i != last) && (ch != '-' || i == 0 || i == last)) {
                    return false;
                }
            }
        }
        return true;
    }

    protected final void addWord(String word) {
        this.book.addWord(word);
    }

    Book getBook() {
        return this.book;
    }
}
