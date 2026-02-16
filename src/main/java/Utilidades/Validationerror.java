package Utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Validationerror.class */
public class Validationerror extends JTextField {
    private final JOptionPane x = new JOptionPane();

    public void valExis() {
        JOptionPane.showMessageDialog((Component) null, "Ese n�mero de indentidad ya existe", "Informaci�n", 1);
    }

    public void valVacio() {
        JOptionPane.showMessageDialog((Component) null, "Diligencie todos los campos", "Error", 0);
    }

    public void valContra() {
        JOptionPane.showMessageDialog((Component) null, "Las contrase�as no coinciden", "Error", 0);
    }

    public void valCadena(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ' && c != '\b' && c != 127) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }

    public void valEntero(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '\b' && c != 127) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }

    public void valBlanco(JTextField cad) {
        if (cad.getText().equals("")) {
            cad.requestFocus();
        }
    }

    public void cuentaData(JTextField cad) {
        String a = cad.getText();
        if (a.length() > 10) {
            JOptionPane.showMessageDialog((Component) null, "Informaci�n, El n�mero de dato es muy larga", "Informaci�n", 1);
            cad.requestFocus();
            cad.setText("");
        }
    }

    public void valUsuario() {
        JOptionPane.showMessageDialog((Component) null, "Ese # de indentidad ya existe", "Informaci�n", 1);
    }

    public void cColor(JTextField tf) {
        tf.setBackground(new Color(105, 160, 235));
        textoMayuscula(tf);
    }

    public void textoMayuscula(final JTextField jt) {
        jt.addKeyListener(new KeyAdapter() { // from class: Utilidades.Validationerror.1
            public void keyReleased(KeyEvent e) {
                char c = e.getKeyChar();
                int posicionCursor = jt.getCaretPosition();
                if (Character.isLetterOrDigit(c)) {
                    String texto = jt.getText().toUpperCase();
                    jt.setText(texto);
                    jt.setCaretPosition(posicionCursor);
                }
            }
        });
        jt.addFocusListener(new FocusAdapter() { // from class: Utilidades.Validationerror.2
            public void focusLost(FocusEvent e) {
                jt.setBackground(Color.white);
            }
        });
    }

    public void cuentaData2(JTextField cad, int tam, KeyEvent evt) {
        int a = cad.getText().length();
        if (a > tam - 1 && evt.getKeyCode() != 38 && evt.getKeyCode() != 39 && evt.getKeyCode() != 37 && evt.getKeyCode() != 40 && evt.getKeyCode() != 10 && evt.getKeyCode() != 8) {
            System.out.println(evt.getKeyCode());
            JOptionPane.showMessageDialog((Component) null, "Informaci�n, El n�mero de dato es muy larga.\nMaximo de digitos es " + tam, "Informaci�n", 1);
            cad.setText("");
            cad.requestFocus();
        }
    }

    public void valIp(JTextField cadactual, int val, JTextField cadSig, KeyEvent evt, JTextField cadAnte) {
        int b;
        String str = cadactual.getText();
        int a = cadactual.getText().length();
        if (a > 2) {
            if (evt.getKeyChar() == '.') {
                b = Integer.parseInt(str.substring(0, 1));
            } else {
                b = Integer.parseInt(str.trim());
            }
            if (223 < b && val == 1) {
                JOptionPane.showMessageDialog((Component) null, cadactual.getText() + " no es una entrada valida. especifique un valor entre 1 y 223", "Informaci�n", 1);
                cadactual.setText("223");
                cadactual.requestFocus();
            } else if (255 < b && val != 1) {
                JOptionPane.showMessageDialog((Component) null, cadactual.getText() + " no es una entrada valida. especifique un valor entre 0 y 255", "Informaci�n", 1);
                cadactual.setText("255");
                cadactual.requestFocus();
            } else if (evt.getKeyChar() == '.') {
                if (val == 1) {
                    cadactual.setText(str.substring(0, a));
                    cadSig.requestFocus();
                } else {
                    cadactual.setText(str.substring(0, a - 1));
                    cadSig.requestFocus();
                }
            } else {
                if (evt.getKeyCode() == 39) {
                    cadactual.setText(str.substring(0, a));
                }
                cadSig.requestFocus();
            }
        } else if (evt.getKeyChar() == '.' || evt.getKeyCode() == 39) {
            cadactual.setText(str.substring(0, a));
            cadSig.requestFocus();
        }
        if (evt.getKeyCode() == 37 && val != 1) {
            cadAnte.requestFocus();
        }
    }
}
