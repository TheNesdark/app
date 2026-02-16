package Utilidades.corrector.jortho;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/DictionaryFactory.class */
class DictionaryFactory {
    private final Node root = new Node(0);
    private char[] tree;
    private int size;

    public void loadWordList(URL filename) throws IOException {
        loadWords(new WordIterator(filename));
    }

    public void loadWords(Iterator<String> words) {
        while (words.hasNext()) {
            String word = words.next();
            if (word != null && word.length() > 1) {
                add(word);
            }
        }
    }

    public void add(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node entry = node.searchCharOrAdd(c);
            if (i != word.length() - 1) {
                node = entry;
            } else {
                entry.isWord = true;
                return;
            }
        }
    }

    public Dictionary create() {
        this.tree = new char[10000];
        this.root.save(this);
        char[] temp = new char[this.size];
        System.arraycopy(this.tree, 0, temp, 0, this.size);
        this.tree = temp;
        return new Dictionary(this.tree);
    }

    final void checkSize(int newSize) {
        if (newSize > this.tree.length) {
            char[] puffer = new char[Math.max(newSize, 2 * this.tree.length)];
            System.arraycopy(this.tree, 0, puffer, 0, this.size);
            this.tree = puffer;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/DictionaryFactory$Node.class */
    private static final class Node extends LowMemoryArrayList<Node> {
        private final char c;
        private boolean isWord;

        Node(char c) {
            this.c = c;
        }

        Node searchCharOrAdd(char c) {
            for (int i = 0; i < size(); i++) {
                Node entry = get(i);
                if (entry.c >= c) {
                    if (entry.c == c) {
                        return entry;
                    }
                    Node entry2 = new Node(c);
                    add(i, entry2);
                    return entry2;
                }
            }
            Node entry3 = new Node(c);
            add(entry3);
            return entry3;
        }

        int save(DictionaryFactory factory) {
            int start = factory.size;
            int idx = start;
            int newSize = factory.size + (size() * 3) + 1;
            factory.checkSize(newSize);
            factory.size = newSize;
            for (int i = 0; i < size(); i++) {
                Node entry = get(i);
                int i2 = idx;
                int idx2 = idx + 1;
                factory.tree[i2] = entry.c;
                int offset = 0;
                if (entry.size() != 0) {
                    offset = entry.save(factory);
                }
                if (entry.isWord) {
                    offset |= Integer.MIN_VALUE;
                }
                int idx3 = idx2 + 1;
                factory.tree[idx2] = (char) (offset >> 16);
                idx = idx3 + 1;
                factory.tree[idx3] = (char) offset;
            }
            factory.tree[idx] = 65535;
            return start;
        }
    }
}
