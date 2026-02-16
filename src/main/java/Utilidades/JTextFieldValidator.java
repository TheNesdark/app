package Utilidades;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JTextField;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JTextFieldValidator.class */
public class JTextFieldValidator extends JTextField {
    private BufferedImage bien;
    private BufferedImage mal;
    private String exprecionRegular = ".*";

    public JTextFieldValidator() {
        try {
            this.bien = ImageIO.read(getClass().getResource("/Imagenes/Bueno.png"));
            this.mal = ImageIO.read(getClass().getResource("/Imagenes/Error.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setMargin(new Insets(super.getMargin().top, super.getMargin().left, super.getMargin().bottom, super.getMargin().right + 10));
        addKeyListener(new KeyAdapter() { // from class: Utilidades.JTextFieldValidator.1
            public void keyReleased(KeyEvent e2) {
                JTextFieldValidator.this.repaint();
            }
        });
    }

    public void setMargin(Insets ins) {
        super.setMargin(new Insets(ins.top, ins.left, ins.bottom, ins.right + 10));
    }

    public Insets getMargin() {
        try {
            Insets a = new Insets(super.getMargin().top, super.getMargin().left, super.getMargin().bottom, super.getMargin().right - 10);
            return a;
        } catch (Exception e) {
            return null;
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = (getHeight() - this.bien.getHeight()) / 2;
        g.drawImage(isTextoValido() ? this.bien : this.mal, getWidth() - 20, y, this);
    }

    public boolean isTextoValido() {
        return getText().matches(getExprecionRegular());
    }

    public String getExprecionRegular() {
        return this.exprecionRegular;
    }

    public void setExprecionRegular(String exprecionRegular) {
        this.exprecionRegular = exprecionRegular;
    }
}
