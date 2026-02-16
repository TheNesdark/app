package Utilidades.corrector.jortho;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/Suggestion.class */
final class Suggestion implements Comparable<Suggestion> {
    private final String word;
    private final int diff;

    Suggestion(CharSequence word, int diff) {
        this.word = word.toString();
        this.diff = diff;
    }

    public String toString() {
        return this.word;
    }

    public String getWord() {
        return this.word;
    }

    public int getDissimilarity() {
        return this.diff;
    }

    public boolean equals(Object sugg) {
        if (sugg instanceof Suggestion) {
            return this.word.equals(((Suggestion) sugg).word);
        }
        return false;
    }

    public int hashCode() {
        return this.word.hashCode();
    }

    @Override // java.lang.Comparable
    public int compareTo(Suggestion sugg) {
        return this.diff - sugg.diff;
    }
}
