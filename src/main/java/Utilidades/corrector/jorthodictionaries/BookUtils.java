package Utilidades.corrector.jorthodictionaries;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jorthodictionaries/BookUtils.class */
public class BookUtils {
    static Properties parseRule(String wikiText, String tempalateName, int fromIndex) {
        int start = findTemplate(wikiText, tempalateName, fromIndex);
        if (start > 0) {
            int length = wikiText.length();
            int braces = 2;
            for (int end = start; end < length; end++) {
                switch (wikiText.charAt(end)) {
                    case '{':
                        braces++;
                        break;
                    case '}':
                        braces--;
                        if (braces == 0) {
                            return parseRule(wikiText, start, end - 1);
                        }
                        break;
                        break;
                }
            }
            return null;
        }
        return null;
    }

    static Properties parseRule(String wikiText, int idxStart, int idxEnd) {
        Properties props = new Properties();
        int idxName = 1;
        int bracket = 0;
        int valueStart = idxStart;
        while (idxStart < idxEnd) {
            char ch = wikiText.charAt(idxStart);
            switch (ch) {
                case '[':
                    bracket++;
                    break;
                case ']':
                    bracket--;
                    break;
                case '|':
                    if (bracket == 0) {
                        String value = wikiText.substring(valueStart, idxStart).trim();
                        int idx = value.indexOf(61);
                        if (idx > 0) {
                            String name = value.substring(0, idx);
                            props.setProperty(name.trim(), value.substring(idx + 1).trim());
                        } else {
                            int i = idxName;
                            idxName++;
                            props.setProperty(Integer.toString(i), value.trim());
                        }
                        valueStart = idxStart + 1;
                    }
                    break;
            }
            idxStart++;
        }
        String value2 = wikiText.substring(valueStart, idxEnd).trim();
        int idx2 = value2.indexOf(61);
        if (idx2 > 0) {
            String name2 = value2.substring(0, idx2);
            props.setProperty(name2.trim(), value2.substring(idx2 + 1).trim());
        } else {
            int i2 = idxName;
            int i3 = idxName + 1;
            props.setProperty(Integer.toString(i2), value2.trim());
        }
        return props;
    }

    static int findTemplate(String wikiText, String tempalateName, int fromIndex) {
        Pattern pattern = Pattern.compile("\\{\\{\\s*\\Q" + tempalateName.replace(" ", "\\E\\s+\\Q") + "\\E\\s*\\|");
        Matcher matcher = pattern.matcher(wikiText);
        if (matcher.find(fromIndex)) {
            return matcher.end();
        }
        return -1;
    }

    public static int calcDiff(String word1, String word2) {
        int diff = 0;
        int j = 0;
        int i = 0;
        while (i < word1.length()) {
            char ch1 = word1.charAt(i);
            if (word2.length() <= j) {
                diff++;
            } else {
                int i2 = j;
                j++;
                char ch2 = word2.charAt(i2);
                if (ch1 != ch2) {
                    diff++;
                    if (word2.length() > j && word2.charAt(j) == ch1) {
                        j++;
                    } else if (word1.length() > i + 1 && word1.charAt(i + 1) == ch2) {
                        i++;
                    }
                }
            }
            i++;
        }
        return diff + (word2.length() - j);
    }
}
