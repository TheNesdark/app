package Utilidades.corrector.jortho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/Suggestions.class */
class Suggestions {
    private final int maxDiff;
    private final HashMap<Suggestion, Suggestion> map = new HashMap<>();

    Suggestions(int maxDiff) {
        this.maxDiff = maxDiff;
    }

    void add(Suggestion suggestion) {
        if (suggestion.getDissimilarity() > this.maxDiff) {
            return;
        }
        Suggestion oldSuggestion = this.map.get(suggestion);
        if (oldSuggestion != null && oldSuggestion.getDissimilarity() <= suggestion.getDissimilarity()) {
            return;
        }
        this.map.put(suggestion, suggestion);
    }

    List<Suggestion> getlist() {
        ArrayList<Suggestion> list = new ArrayList<>();
        for (Suggestion sugg : this.map.values()) {
            list.add(sugg);
        }
        return list;
    }

    int getMaxDissimilarity() {
        return this.maxDiff;
    }
}
