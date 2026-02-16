package Utilidades.corrector.jortho;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/Dictionary.class */
final class Dictionary extends DictionaryBase {
    public Dictionary() {
        this.tree = new char[10000];
        char[] cArr = this.tree;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = 65535;
    }

    public Dictionary(char[] tree) {
        super(tree);
    }

    public long save(String filename) throws IOException {
        File file = new File(filename);
        FileOutputStream fos = new FileOutputStream(file);
        save(fos);
        return file.length();
    }

    public void save(OutputStream stream) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setLevel(9);
        DeflaterOutputStream zip = new DeflaterOutputStream(stream, deflater);
        for (int i = 0; i < this.size; i++) {
            zip.write(this.tree[i]);
            zip.write(this.tree[i] >> '\b');
        }
        zip.flush();
        zip.close();
    }

    public void load(String filename) throws IOException {
        FileInputStream fos = new FileInputStream(filename);
        load(fos);
    }

    public void load(InputStream stream) throws IOException {
        InputStream zip = new BufferedInputStream(new InflaterInputStream(stream));
        this.size = 0;
        while (zip.available() > 0) {
            char c = (char) (zip.read() + (zip.read() << 8));
            checkSize(this.size + 1);
            char[] cArr = this.tree;
            int i = this.size;
            this.size = i + 1;
            cArr[i] = c;
        }
        zip.close();
        trimToSize();
    }

    void trimToSize() {
        char[] temp = new char[this.size];
        System.arraycopy(this.tree, 0, temp, 0, this.size);
        this.tree = temp;
    }

    public void add(String word) {
        this.idx = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            searchCharOrAdd(c);
            if (i == word.length() - 1) {
                char[] cArr = this.tree;
                int i2 = this.idx + 1;
                cArr[i2] = (char) (cArr[i2] | 32768);
                return;
            } else {
                int nextIdx = readIndex();
                if (nextIdx == 0) {
                    this.idx = createNewNode();
                } else {
                    this.idx = nextIdx;
                }
            }
        }
    }

    public char[] toArray() {
        char[] puffer = new char[this.size];
        System.arraycopy(this.tree, 0, puffer, 0, this.size);
        return puffer;
    }

    public int getDataSize() {
        return this.size;
    }

    private void searchCharOrAdd(char c) {
        if (c == 65535) {
            throw new RuntimeException("Invalid Character");
        }
        while (this.idx < this.size && this.tree[this.idx] < c) {
            this.idx += 3;
        }
        if (this.idx >= this.size) {
            throw new RuntimeException("Internal Error");
        }
        if (this.tree[this.idx] == c) {
            return;
        }
        insertChar(c);
    }

    private void insertChar(char c) {
        checkSize(this.size + 3);
        System.arraycopy(this.tree, this.idx, this.tree, this.idx + 3, this.size - this.idx);
        this.tree[this.idx] = c;
        this.tree[this.idx + 1] = 0;
        this.tree[this.idx + 2] = 0;
        this.size += 3;
        int i = 0;
        while (i < this.size) {
            if (this.tree[i] == 65535) {
                i++;
            } else {
                int index = (this.tree[i + 1] << 16) + this.tree[i + 2];
                int indexValue = index & Integer.MAX_VALUE;
                if (indexValue > this.idx) {
                    int index2 = index + 3;
                    this.tree[i + 1] = (char) (index2 >> 16);
                    this.tree[i + 2] = (char) index2;
                }
                i += 3;
            }
        }
    }

    private final int createNewNode() {
        checkSize(this.size + 1);
        char[] cArr = this.tree;
        int i = this.idx + 1;
        cArr[i] = (char) (cArr[i] | ((char) (this.size >> 16)));
        char[] cArr2 = this.tree;
        int i2 = this.idx + 2;
        cArr2[i2] = (char) (cArr2[i2] | ((char) this.size));
        this.idx = this.size;
        this.tree[this.idx] = 65535;
        this.size++;
        return this.idx;
    }

    private final void checkSize(int newSize) {
        if (newSize > this.tree.length) {
            char[] puffer = new char[Math.max(newSize, 2 * this.tree.length)];
            System.arraycopy(this.tree, 0, puffer, 0, this.size);
            this.tree = puffer;
        }
    }
}
