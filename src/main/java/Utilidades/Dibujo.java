package Utilidades;

import java.awt.Color;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Dibujo.class */
public class Dibujo {
    public int xInicial;
    public int xFinal;
    public int yInicial;
    public int yFinal;
    public int tipo;
    public Color color;

    public Dibujo() {
        this.xInicial = 0;
        this.xFinal = 0;
        this.yInicial = 0;
        this.yFinal = 0;
        this.tipo = 0;
    }

    public Dibujo(int x1, int x2, int y1, int y2, Color c, int tip) {
        this.xInicial = 0;
        this.xFinal = 0;
        this.yInicial = 0;
        this.yFinal = 0;
        this.tipo = 0;
        this.xInicial = x1;
        this.xFinal = x2;
        this.yInicial = y1;
        this.yFinal = y2;
        this.color = c;
        this.tipo = tip;
    }
}
