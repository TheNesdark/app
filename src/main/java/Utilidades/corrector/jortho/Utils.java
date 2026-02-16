package Utilidades.corrector.jortho;

import java.awt.Dialog;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/Utils.class */
public class Utils {
    static String getResource(String value) {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("corrector.jortho.i18n.resource");
            return resource.getString(value);
        } catch (Exception e) {
            if (!value.endsWith(".tooltip")) {
                SpellChecker.getMessageHandler().handleException(e);
            }
            return value;
        }
    }

    static JButton getButton(String resource) {
        JButton button;
        CustomUIProvider customProvider = SpellChecker.getCustomUIProvider();
        if (customProvider != null) {
            button = customProvider.getButton(resource);
        } else {
            button = new JButton(getResource(resource));
            String tooltipKey = resource + ".tooltip";
            String tooltip = getResource(tooltipKey);
            if (tooltip != tooltipKey) {
                button.setToolTipText(tooltip);
            }
        }
        return button;
    }

    static JTextField getTextField() {
        JTextField textField;
        CustomUIProvider customProvider = SpellChecker.getCustomUIProvider();
        if (customProvider != null) {
            textField = customProvider.getTextField();
        } else {
            textField = new JTextField();
        }
        return textField;
    }

    static JLabel getLabel(String text) {
        JLabel label;
        CustomUIProvider customProvider = SpellChecker.getCustomUIProvider();
        if (customProvider != null) {
            label = customProvider.getLabel(text);
        } else {
            label = new JLabel(text);
        }
        return label;
    }

    static JList getList() {
        CustomUIProvider customProvider = SpellChecker.getCustomUIProvider();
        if (customProvider != null) {
            return customProvider.getList();
        }
        return new JList();
    }

    static void setDialogIcon(JDialog dlg) {
        try {
            BufferedImage bufferedImage = ImageIO.read(dlg.getClass().getResource("/Imagenes/genomap.png"));
            Method m = Dialog.class.getMethod("setIconImage", Image.class);
            m.invoke(dlg, bufferedImage);
        } catch (Throwable th) {
        }
    }

    static String getCapitalized(String word) {
        if (word.length() > 0 && Character.isLowerCase(word.charAt(0))) {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
        return word;
    }

    static String getInvertedCapitalizion(String word) {
        if (word.length() > 0) {
            if (Character.isLowerCase(word.charAt(0))) {
                return word.substring(0, 1).toUpperCase() + word.substring(1);
            }
            if (Character.isUpperCase(word.charAt(0))) {
                return word.substring(0, 1).toLowerCase() + word.substring(1);
            }
        }
        return word;
    }

    static boolean isFirstCapitalized(String word) {
        return word.length() > 0 && Character.isUpperCase(word.charAt(0));
    }

    static boolean isAllCapitalized(String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetter(ch) && !Character.isUpperCase(ch)) {
                return false;
            }
        }
        return true;
    }

    static boolean isIncludeNumbers(String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    public static String replaceUnicodeQuotation(String word) {
        char[] newWord = null;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            switch (ch) {
                case '`':
                case 180:
                case 8216:
                case 8217:
                case 8218:
                case 8219:
                    if (newWord == null) {
                        newWord = word.toCharArray();
                    }
                    newWord[i] = '\'';
                    break;
                case 8209:
                case 8210:
                case 8211:
                case 8212:
                case 8213:
                    if (newWord == null) {
                        newWord = word.toCharArray();
                    }
                    newWord[i] = '-';
                    break;
            }
        }
        return newWord == null ? word : new String(newWord);
    }
}
