package com.genoma.plus.controller.historia;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/MiObjetoImagen.class */
public class MiObjetoImagen extends JLabel implements MouseListener, MouseMotionListener {
    private String key;
    private Point start_loc;
    private Point start_drag;
    private Point offset;
    private Point posicion = new Point(0, 0);
    private Dimension d = new Dimension(124, 150);
    private int nuevo_X = 1;
    private int nuevo_Y = 1;

    public MiObjetoImagen(String key) {
        this.key = "";
        this.key = key;
        setToolTipText(key);
        setCursor(Cursor.getPredefinedCursor(12));
        setSize(16, 16);
        setPreferredSize(this.d);
        setText("");
        setVisible(true);
        setLocation(this.posicion);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 3) {
            setVisible(false);
        }
    }

    public void mousePressed(MouseEvent e) {
        this.start_drag = getScreenLocation(e);
        this.start_loc = getLocation();
    }

    public void mouseReleased(MouseEvent e) {
        this.nuevo_X = getLocation().x;
        this.nuevo_Y = getLocation().y;
        setLocation(this.nuevo_X, this.nuevo_Y);
    }

    public void mouseEntered(MouseEvent e) {
        setBorder(BorderFactory.createLineBorder(new Color(204, 0, 51), 1));
    }

    public void mouseExited(MouseEvent e) {
        setBorder(null);
    }

    public void mouseDragged(MouseEvent e) {
        Point current = getScreenLocation(e);
        this.offset = new Point(((int) current.getX()) - ((int) this.start_drag.getX()), ((int) current.getY()) - ((int) this.start_drag.getY()));
        Point new_location = new Point((int) (this.start_loc.getX() + this.offset.getX()), (int) (this.start_loc.getY() + this.offset.getY()));
        setLocation(new_location);
    }

    public void mouseMoved(MouseEvent e) {
    }

    private Point getScreenLocation(MouseEvent evt) {
        Point cursor = evt.getPoint();
        Point target_location = getLocationOnScreen();
        return new Point((int) (target_location.getX() + cursor.getX()), (int) (target_location.getY() + cursor.getY()));
    }
}
