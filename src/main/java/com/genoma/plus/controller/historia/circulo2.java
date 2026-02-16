package com.genoma.plus.controller.historia;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/circulo2.class */
public class circulo2 extends circulo {
    public circulo2(int x, int y, int d) {
        super(x, y, d);
    }

    public void paint(Graphics2D g, Color c) {
        float[] dash = {1.0f};
        g.setStroke(new BasicStroke(2.0f, 2, 0, 5.0f, dash, 0.0f));
        g.setColor(c);
        g.drawOval(getX(), getY(), getDx(), getDy());
    }
}
