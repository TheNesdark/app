package com.genoma.plus.controller.historia;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/Rectangulo.class */
public class Rectangulo extends Cuadrado {
    public Rectangulo(int x, int y, int dx, int dy, Entorno entorno) {
        super(x, y, dx, dy, entorno);
    }

    public Rectangulo(int x, int y, int dx, int dy) {
        super(x, y, dx, dy);
    }

    public void paint(Graphics2D g, Color c) {
        g.setColor(c);
        g.getStroke();
        g.setStroke(new BasicStroke(3.0f));
        g.drawRect(getX(), getY(), getDx(), getDy());
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", 1, 12));
        if (getEntorno() != null) {
            if (getEntorno().getDato().length() < 6) {
                g.drawString(getEntorno().getDato(), getX() + 60, getY() + 15);
                return;
            }
            if (getEntorno().getDato().length() < 11 && getEntorno().getDato().length() > 5) {
                g.drawString(getEntorno().getDato(), getX() + 45, getY() + 15);
            } else if (getEntorno().getDato().length() > 10 && getEntorno().getDato().length() < 20) {
                g.drawString(getEntorno().getDato(), getX() + 25, getY() + 15);
            } else {
                g.drawString(getEntorno().getDato(), getX() + 5, getY() + 15);
            }
        }
    }
}
