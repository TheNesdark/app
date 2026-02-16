package Utilidades.corrector.jortho;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/WordIterator.class */
public class WordIterator implements Iterator<String> {
    private BufferedReader input;
    private String word;

    public WordIterator(URL filename) throws IOException {
        this(createInflaterStream(filename), "UTF8");
    }

    public WordIterator(InputStream stream, String charsetName) throws IOException {
        this(new InputStreamReader(stream, charsetName));
    }

    public WordIterator(Reader reader) throws IOException {
        this.input = new BufferedReader(reader);
        this.word = this.input.readLine();
    }

    private static InputStream createInflaterStream(URL filename) throws IOException {
        URLConnection conn = filename.openConnection();
        conn.setReadTimeout(5000);
        InputStream input = conn.getInputStream();
        return new BufferedInputStream(new InflaterInputStream(input));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.word != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String next = this.word;
        try {
            this.word = this.input.readLine();
            if (this.word == null) {
                this.input.close();
            }
        } catch (IOException e) {
            this.word = null;
            SpellChecker.getMessageHandler().handleException(e);
        }
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
