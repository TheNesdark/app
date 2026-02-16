package Utilidades.corrector.jortho;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.Position;
import javax.swing.text.View;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/RedZigZagPainter.class */
class RedZigZagPainter extends DefaultHighlighter.DefaultHighlightPainter {
    private static final BasicStroke STROKE1 = new BasicStroke(0.01f, 0, 0, 10.0f, new float[]{1.0f, 3.0f}, 0.0f);
    private static final BasicStroke STROKE2 = new BasicStroke(0.01f, 0, 0, 10.0f, new float[]{1.0f, 1.0f}, 1.0f);
    private static final BasicStroke STROKE3 = new BasicStroke(0.01f, 0, 0, 10.0f, new float[]{1.0f, 3.0f}, 2.0f);

    public RedZigZagPainter() {
        super(Color.red);
    }

    public Shape paintLayer(Graphics g, int i, int j, Shape shape, JTextComponent jtext, View view) {
        if (jtext.isEditable()) {
            g.setColor(Color.red);
            try {
                Shape sh = view.modelToView(i, Position.Bias.Forward, j, Position.Bias.Backward, shape);
                Rectangle rect = sh instanceof Rectangle ? (Rectangle) sh : sh.getBounds();
                drawZigZagLine(g, rect);
                return rect;
            } catch (BadLocationException e) {
                return null;
            }
        }
        return null;
    }

    private void drawZigZagLine(Graphics g, Rectangle rect) {
        int x1 = rect.x;
        int x2 = (x1 + rect.width) - 1;
        int y = (rect.y + rect.height) - 1;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(STROKE1);
        g2.drawLine(x1, y, x2, y);
        int y2 = y - 1;
        g2.setStroke(STROKE2);
        g2.drawLine(x1, y2, x2, y2);
        int y3 = y2 - 1;
        g2.setStroke(STROKE3);
        g2.drawLine(x1, y3, x2, y3);
    }
}
