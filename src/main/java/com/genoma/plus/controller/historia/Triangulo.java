package com.genoma.plus.controller.historia;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/Triangulo.class */
public class Triangulo {
    int base = 45;
    int alto = 40;
    int x;
    int y;
    Persona p;

    public Triangulo(int x, int y, Persona p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public void paint(Graphics2D g) {
        this.x = this.x;
        this.y = this.y;
        g.getFont();
        g.setFont(new Font("Arial", 1, 12));
        if (this.p.getEsPaciente()) {
            g.getStroke();
            g.setStroke(new BasicStroke(6.0f));
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(this.x, this.y, this.x + (this.base / 2), this.y + this.alto);
            g.drawLine(this.x + (this.base / 2), this.y + this.alto, this.x - (this.base / 2), this.y + this.alto);
            g.drawLine(this.x, this.y, this.x - (this.base / 2), this.y + this.alto);
        } else {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(this.x, this.y, this.x + (this.base / 2), this.y + this.alto);
            g.drawLine(this.x + (this.base / 2), this.y + this.alto, this.x - (this.base / 2), this.y + this.alto);
            g.drawLine(this.x, this.y, this.x - (this.base / 2), this.y + this.alto);
        }
        g.setColor(Color.BLACK);
        if (Integer.parseInt(getP().getEdad()) < 10) {
            g.drawString(getP().getEdad(), getX() - 5, getY() + 27);
        } else {
            g.drawString(getP().getEdad(), getX() - 7, getY() + 27);
        }
        g.drawString(getP().getPrimerNom(), this.x - 18, this.y + 55);
        g.setFont(new Font("Arial", 1, 10));
        if (getP().getOcupacion().length() < 10) {
            g.drawString(getP().getOcupacion(), this.x - 20, this.y + 65);
        } else {
            g.drawString(getP().getOcupacion(), this.x - 30, this.y + 65);
        }
        if (this.p.isEsAdoptado() && !this.p.isEsGemelo()) {
            g.drawString("Adoptado", getX() - 20, getY() + 83);
        }
        if (this.p.isEsGemelo() && !this.p.isEsAdoptado()) {
            g.drawString("Gemelo", getX() - 20, getY() + 83);
        }
        if (this.p.isEsGemelo() && this.p.isEsAdoptado()) {
            g.drawString("Gemelo", getX() - 20, getY() + 83);
            g.drawString("Adoptado", getX() - 20, getY() + 93);
        }
    }

    public int getBase() {
        return this.base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAlto() {
        return this.alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Persona getP() {
        return this.p;
    }

    public void setP(Persona p) {
        this.p = p;
    }
}
