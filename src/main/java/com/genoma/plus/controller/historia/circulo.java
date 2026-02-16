package com.genoma.plus.controller.historia;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/circulo.class */
public class circulo {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private boolean selecionado;
    private Persona p;

    public circulo(int x, int y, Persona p) {
        this.dx = 45;
        this.dy = 45;
        this.selecionado = false;
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public circulo(int x, int y, int d) {
        this.dx = 45;
        this.dy = 45;
        this.selecionado = false;
        this.x = x;
        this.y = y;
        this.dx = d;
        this.dy = d;
    }

    public circulo(int x, int y, int dx, int dy, String ca) {
        this.dx = 45;
        this.dy = 45;
        this.selecionado = false;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void pintar(Graphics2D g, Color c) {
        String tipoEdad;
        if (!this.p.getVive()) {
            g.setColor(Color.red);
            g.drawLine(getX() + 5, getY() + 5, getX() + 37, getY() + 37);
            g.drawLine(getX() + 35, getY() + 5, getX() + 5, getY() + 37);
        }
        tipoEdad = "";
        switch (getP().getTipoEdad()) {
            case "MES":
                tipoEdad = Integer.parseInt(getP().getEdad()) > 1 ? "MESES" : getP().getTipoEdad();
                break;
            case "AÑO":
                tipoEdad = Integer.parseInt(getP().getEdad()) > 1 ? "AÑOS" : getP().getTipoEdad();
                break;
            case "DIA":
                tipoEdad = Integer.parseInt(getP().getEdad()) > 1 ? "DIAS" : getP().getTipoEdad();
                break;
            case "ANO":
                tipoEdad = Integer.parseInt(getP().getEdad()) > 1 ? "AÑOS" : getP().getTipoEdad();
                break;
        }
        if (this.p.getEsPaciente()) {
            Stroke oldStroke = g.getStroke();
            g.setStroke(new BasicStroke(6.0f));
            g.setColor(c);
            g.drawOval(getX(), getY(), this.dx, this.dy);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", 1, 12));
            if (Integer.parseInt(getP().getEdad()) < 10) {
                g.drawString(getP().getEdad(), getX() + 7, getY() + 27);
                g.drawString(tipoEdad, getX() + 18, getY() + 27);
            } else {
                g.drawString(getP().getEdad(), getX() + 7, getY() + 27);
                g.drawString(tipoEdad, getX() + 18, getY() + 27);
            }
            g.setStroke(oldStroke);
        } else {
            g.setColor(c);
            g.drawOval(getX(), getY(), this.dx, this.dy);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", 1, 11));
            if (Integer.parseInt(getP().getEdad()) < 10) {
                g.drawString(getP().getEdad(), getX() + 10, getY() + 27);
                g.drawString(tipoEdad, getX() + 19, getY() + 27);
            } else {
                g.drawString(getP().getEdad(), getX() + 3, getY() + 27);
                g.drawString(tipoEdad, getX() + 19, getY() + 27);
            }
        }
        g.drawString(getP().getPrimerNom(), getX() + 12, getY() + 55);
        g.setFont(new Font("Arial", 1, 11));
        if (getP().getOcupacion().length() > 10) {
            g.drawString(getP().getOcupacion().substring(0, 8), getX(), getY() + 65);
            g.drawString("-" + getP().getOcupacion().substring(8, getP().getOcupacion().length()), getX(), getY() + 73);
        } else {
            g.drawString(getP().getOcupacion(), getX(), getY() + 65);
        }
        if (this.p.isEsAdoptado() && !this.p.isEsGemelo()) {
            g.drawString("Adoptado", getX(), getY() + 83);
        }
        if (this.p.isEsGemelo() && !this.p.isEsAdoptado()) {
            g.drawString("Gemelo", getX(), getY() + 83);
        }
        if (this.p.isEsGemelo() && this.p.isEsAdoptado()) {
            g.drawString("Adoptado", getX(), getY() + 83);
            g.drawString("Gemelo", getX(), getY() + 93);
        }
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

    public int getDx() {
        return this.dx;
    }

    public void setDx(int dimension) {
        this.dx = dimension;
    }

    public int getDy() {
        return this.dy;
    }

    public void setDy(int dimension) {
        this.dy = dimension;
    }

    public boolean isSelecionado() {
        return this.selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public Persona getP() {
        return this.p;
    }

    public void setP(Persona p) {
        this.p = p;
    }
}
