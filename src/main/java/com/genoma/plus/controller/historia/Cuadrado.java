package com.genoma.plus.controller.historia;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/Cuadrado.class */
public class Cuadrado {
    private int x;
    private int y;
    private int dx;
    private int dy;
    private String cadena;
    private Persona p;
    private Entorno entorno;

    public Cuadrado(int x, int y, Persona p) {
        this.cadena = "";
        this.x = x;
        this.y = y;
        this.dx = 40;
        this.dy = 40;
        this.p = p;
    }

    public Cuadrado(int x, int y, int dx, int dy, Entorno entorno) {
        this.cadena = "";
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.entorno = entorno;
    }

    public Cuadrado(int x, int y, int dx, int dy) {
        this.cadena = "";
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void pintar(Graphics2D g) {
        String tipoEdad;
        if (!this.p.getVive()) {
            g.setColor(Color.red);
            g.drawLine(getX(), getY(), getX() + 40, getY() + 40);
            g.drawLine(getX() + 40, getY(), getX(), getY() + 40);
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
                tipoEdad = Integer.parseInt(getP().getEdad()) > 1 ? "AÑOS" : "AÑO";
                break;
        }
        if (this.p.getEsPaciente()) {
            Stroke oldStroke = g.getStroke();
            g.setStroke(new BasicStroke(6.0f));
            g.setColor(Color.blue);
            g.drawRect(getX(), getY(), this.dx, this.dy);
            g.setColor(Color.black);
            g.setFont(new Font("Arial", 1, 11));
            if (Integer.parseInt(getP().getEdad()) < 10) {
                g.drawString(getP().getEdad(), getX() + 5, getY() + 27);
                g.drawString(tipoEdad, getX() + 18, getY() + 27);
            } else {
                g.drawString(getP().getEdad(), getX() + 5, getY() + 27);
                g.drawString(tipoEdad, getX() + 18, getY() + 27);
            }
            g.setStroke(oldStroke);
        } else {
            float[] dash = {1.0f};
            g.setStroke(new BasicStroke(2.0f, 2, 0, 5.0f, dash, 0.0f));
            g.setColor(Color.blue);
            g.drawRect(getX(), getY(), this.dx, this.dy);
            g.setColor(Color.black);
            g.setFont(new Font("Arial", 1, 11));
            if (Integer.parseInt(getP().getEdad()) < 10) {
                g.drawString(getP().getEdad(), getX() + 5, getY() + 27);
                g.drawString(tipoEdad, getX() + 18, getY() + 27);
            } else {
                g.drawString(getP().getEdad(), getX() + 5, getY() + 27);
                g.drawString(tipoEdad, getX() + 18, getY() + 27);
            }
        }
        g.drawString(getP().getPrimerNom(), getX() + 8, getY() + 55);
        g.setFont(new Font("Arial", 1, 10));
        if (getP().getOcupacion().length() > 8) {
            g.drawString(getP().getOcupacion().substring(0, 8), getX(), getY() + 65);
            g.drawString("-" + getP().getOcupacion().substring(8, getP().getOcupacion().length()), getX(), getY() + 73);
        } else {
            g.drawString(getP().getOcupacion(), getX(), getY() + 65);
        }
        if (this.p.isEsAdoptado() && !this.p.isEsGemelo()) {
            g.drawString("adoptado", getX(), getY() + 83);
        }
        if (this.p.isEsGemelo() && !this.p.isEsAdoptado()) {
            g.drawString("gemelo", getX(), getY() + 83);
        }
        if (this.p.isEsGemelo() && this.p.isEsAdoptado()) {
            g.drawString("gemelo", getX(), getY() + 83);
            g.drawString("Adoptado", getX(), getY() + 93);
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

    public String getCadena() {
        return this.cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getDx() {
        return this.dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return this.dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Persona getP() {
        return this.p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public Entorno getEntorno() {
        return this.entorno;
    }

    public void setEntorno(Entorno entorno) {
        this.entorno = entorno;
    }
}
