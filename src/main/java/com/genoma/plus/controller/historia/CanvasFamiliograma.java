package com.genoma.plus.controller.historia;

import java.awt.AWTEvent;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/CanvasFamiliograma.class */
public class CanvasFamiliograma extends Canvas {
    List<Object> listaObjetos;
    Cuadrado c;
    circulo cir;
    Linea r;
    Triangulo t;
    Rectangulo rec;
    int madrex;
    int madrey;
    int padrex;
    int padrey;
    int personax;
    int personay;

    protected AWTEvent coalesceEvents(AWTEvent existingEvent, AWTEvent newEvent) {
        return super.coalesceEvents(existingEvent, newEvent);
    }

    public CanvasFamiliograma() {
        this.listaObjetos = null;
        this.listaObjetos = new ArrayList();
        setBackground(Color.white);
        setSize(900, 650);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        if (0 == 0) {
            g.setColor(Color.black);
            g.setFont(new Font("Arial", 1, 12));
            g.drawString("Guia de relaciones", 370, 515);
            g.drawString("Abrev", 300, 515);
            g.drawString("Abrev", 630, 515);
            this.listaObjetos.add(new Linea(50, 535, 100, 535, 14, 0, ""));
            g.drawString("Cercana", 107, 535);
            g.drawString("CR", 307, 535);
            this.listaObjetos.add(new Linea(50, 550, 100, 550, 11, 0, ""));
            g.drawString("Muy estrecha", 107, 550);
            g.drawString("ME", 307, 550);
            this.listaObjetos.add(new Linea(50, 565, 100, 565, 12, 0, ""));
            g.drawString("Conflictiva", 107, 565);
            g.drawString("CN", 307, 565);
            this.listaObjetos.add(new Linea(50, 580, 100, 580, 13, 0, ""));
            g.drawString("muy Estrecha y conflictiva", 107, 580);
            g.drawString("MC", 307, 580);
            this.listaObjetos.add(new Linea(50, 595, 100, 595, 10, 0, ""));
            g.drawString("Distante", 107, 595);
            g.drawString("DS", 307, 595);
            this.listaObjetos.add(new Linea(50, 610, 100, 610, 15, 0, ""));
            g.drawString("Quiebre", 107, 610);
            g.drawString("QB", 307, 610);
            this.listaObjetos.add(new Linea(500, 545, 540, 545, 1, 1, ""));
            g.drawString("Casados", 545, 545);
            g.drawString("CS", 637, 545);
            this.listaObjetos.add(new Linea(500, 560, 540, 560, 4, 1, ""));
            g.drawString("Separado", 545, 560);
            g.drawString("SP", 637, 560);
            this.listaObjetos.add(new Linea(500, 575, 540, 575, 8, 1, ""));
            g.drawString("Union Libre", 545, 575);
            g.drawString("UL", 637, 575);
            this.listaObjetos.add(new Linea(500, 590, 540, 590, 6, 1, ""));
            g.drawString("Divorciado", 545, 590);
            g.drawString("DV", 637, 590);
            int i = 0 + 1;
        }
        for (int x = 0; x < this.listaObjetos.size(); x++) {
            if (this.listaObjetos.get(x).getClass().equals(Cuadrado.class)) {
                this.c = (Cuadrado) this.listaObjetos.get(x);
                this.c.pintar(g2d);
            }
            if (this.listaObjetos.get(x).getClass().equals(circulo.class)) {
                this.cir = (circulo) this.listaObjetos.get(x);
                this.cir.pintar(g2d, Color.CYAN);
            }
            if (this.listaObjetos.get(x).getClass().equals(Linea.class)) {
                this.r = (Linea) this.listaObjetos.get(x);
                this.r.dibujarRelacion(g2d);
            }
            if (this.listaObjetos.get(x).getClass().equals(Triangulo.class)) {
                this.t = (Triangulo) this.listaObjetos.get(x);
                this.t.paint(g2d);
            }
            if (this.listaObjetos.get(x).getClass().equals(Rectangulo.class)) {
                this.rec = (Rectangulo) this.listaObjetos.get(x);
                this.rec.paint(g2d, Color.black);
            }
        }
    }

    public void dibujarAbuelosP(Persona[] abuelos) {
        if (abuelos[0].getSexo().equals("M")) {
            this.listaObjetos.add(new Cuadrado(70, 140, abuelos[0]));
            this.listaObjetos.add(new circulo(190, 140, abuelos[1]));
        } else {
            this.listaObjetos.add(new Cuadrado(70, 140, abuelos[1]));
            this.listaObjetos.add(new circulo(190, 140, abuelos[0]));
        }
        this.listaObjetos.add(new Linea(90, 215, 90, 225, 0, 0, ""));
        this.listaObjetos.add(new Linea(212, 215, 212, 225, 0, 0, ""));
        this.listaObjetos.add(new Linea(145, 230, 145, 255, 0, 0, ""));
        if (abuelos[0].getIdEstadocivil() == abuelos[1].getIdEstadocivil()) {
            this.listaObjetos.add(new Linea(90, 225, 212, 225, abuelos[0].getIdEstadocivil(), 1, getAbreviatura(abuelos[0].getIdEstadocivil())));
        }
    }

    public String getAbreviatura(int id) {
        String abrev = "";
        switch (id) {
            case 1:
                abrev = "CS";
                break;
            case 4:
                abrev = "SP";
                break;
            case 6:
                abrev = "UL";
                break;
            case 8:
                abrev = "DV";
                break;
        }
        return abrev;
    }

    public void dibujarAbuelosM(Persona[] abuelos) {
        if (abuelos[0].getSexo().equals("M")) {
            this.listaObjetos.add(new Cuadrado(550, 140, abuelos[0]));
            this.listaObjetos.add(new circulo(670, 140, abuelos[1]));
        } else {
            this.listaObjetos.add(new Cuadrado(550, 140, abuelos[1]));
            this.listaObjetos.add(new circulo(670, 140, abuelos[0]));
        }
        if (abuelos[0].getIdEstadocivil() == abuelos[0].getIdEstadocivil()) {
            this.listaObjetos.add(new Linea(570, 225, 692, 225, abuelos[0].getIdEstadocivil(), 1, getAbreviatura(abuelos[0].getIdEstadocivil())));
        }
        this.listaObjetos.add(new Linea(570, 215, 570, 225, 0, 0, ""));
        this.listaObjetos.add(new Linea(692, 215, 692, 225, 0, 0, ""));
        this.listaObjetos.add(new Linea(630, 230, 630, 255, 0, 0, ""));
    }

    public void dibujarHijosAbueloP(Persona[] HijosAP) {
        if (HijosAP.length == 1) {
            if (HijosAP[0].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(120, 260, HijosAP[0]));
            }
        } else if (HijosAP.length % 2 == 0) {
            dibujarPares(HijosAP.length / 2, HijosAP, 100, 150, 260);
        } else {
            dibujarImpares(HijosAP.length / 2, HijosAP, 70, 190, 260);
        }
    }

    public void dibujarPares(int num, Persona[] per, int posxizq, int posxder, int posy) {
        int moverizq = num - 1;
        int moverder = num;
        for (int x = 0; x < num; x++) {
            if (per[moverizq].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(posxizq, posy, per[moverizq]));
                this.listaObjetos.add(new Linea(posxizq + 20, posy - 5, posxizq + 20, posy, 0, 0, ""));
                moverizq--;
            } else {
                if (per[moverizq].isEmbarazo()) {
                    this.listaObjetos.add(new Triangulo(posxizq + 20, posy, per[moverizq]));
                } else {
                    this.listaObjetos.add(new circulo(posxizq, posy, per[moverizq]));
                }
                this.listaObjetos.add(new Linea(posxizq + 20, posy - 5, posxizq + 20, posy, 0, 0, ""));
                moverizq--;
            }
            if (per[moverder].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(posxder, posy, per[moverder]));
                this.listaObjetos.add(new Linea(posxder + 20, posy - 5, posxder + 20, posy, 0, 0, ""));
            } else {
                if (per[moverder].isEmbarazo()) {
                    this.listaObjetos.add(new Triangulo(posxder + 20, posy, per[moverder]));
                } else {
                    this.listaObjetos.add(new circulo(posxder, posy, per[moverder]));
                }
                this.listaObjetos.add(new Linea(posxder + 20, posy - 5, posxder + 20, posy, 0, 0, ""));
            }
            moverder++;
            posxder += 70;
            posxizq -= 70;
        }
        this.listaObjetos.add(new Linea(posxizq + 90, posy - 5, posxder - 50, posy - 5, 0, 0, ""));
    }

    public void dibujarImpares(int num, Persona[] per, int posxizq, int posxder, int posy) {
        int moverizq = num - 1;
        int moverder = num + 1;
        if (per[num].getSexo().equals("M")) {
            this.listaObjetos.add(new Cuadrado(posxizq + 60, posy, per[num]));
            this.listaObjetos.add(new Linea(posxizq + 80, posy - 5, posxizq + 80, posy, 0, 0, ""));
        } else if (per[num].getSexo().equals("F")) {
            if (per[num].isEmbarazo()) {
                this.listaObjetos.add(new Triangulo(posxizq + 80, posy, per[num]));
            } else {
                this.listaObjetos.add(new circulo(posxizq + 60, posy, per[num]));
            }
            this.listaObjetos.add(new Linea(posxizq + 80, posy - 5, posxizq + 80, posy, 0, 0, ""));
        }
        for (int x = 0; x < num; x++) {
            if (per[moverizq].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(posxizq, posy, per[moverizq]));
                this.listaObjetos.add(new Linea(posxizq + 20, posy - 5, posxizq + 20, posy, 0, 0, ""));
                moverizq--;
            } else {
                if (per[moverizq].isEmbarazo()) {
                    this.listaObjetos.add(new Triangulo(posxizq + 20, posy, per[x]));
                } else {
                    this.listaObjetos.add(new circulo(posxizq, posy, per[x]));
                }
                this.listaObjetos.add(new Linea(posxizq + 21, posy - 5, posxizq + 21, posy, 0, 0, ""));
                moverizq--;
            }
            if (per[moverder].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(posxder, posy, per[moverder]));
                this.listaObjetos.add(new Linea(posxder + 20, posy - 5, posxder + 20, posy, 0, 0, ""));
            } else {
                if (per[moverder].isEmbarazo()) {
                    this.listaObjetos.add(new Triangulo(posxder + 20, posy, per[moverder]));
                } else {
                    this.listaObjetos.add(new circulo(posxder, posy, per[moverder]));
                }
                this.listaObjetos.add(new Linea(posxder + 21, posy - 5, posxder + 21, posy, 0, 0, ""));
            }
            moverder++;
            posxder += 70;
            posxizq -= 70;
        }
        this.listaObjetos.add(new Linea(posxizq + 90, posy - 5, posxder - 50, posy - 5, 0, 0, ""));
    }

    public void dibujarHijosAbueloM(Persona[] HijosAM) {
        if (HijosAM.length == 1) {
            if (HijosAM[0].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(610, 260, HijosAM[0]));
                return;
            } else if (HijosAM[0].isEmbarazo()) {
                this.listaObjetos.add(new Triangulo(630, 260, HijosAM[0]));
                return;
            } else {
                this.listaObjetos.add(new circulo(610, 260, HijosAM[0]));
                return;
            }
        }
        if (HijosAM.length % 2 == 0) {
            dibujarPares(HijosAM.length / 2, HijosAM, 585, 635, 260);
        } else {
            dibujarImpares(HijosAM.length / 2, HijosAM, 545, 695, 260);
        }
    }

    public void dibujarHijos(Persona[] hijos) {
        int relaM = BuscarMadre();
        int relaP = BuscarPadre();
        if (relaM == relaP) {
            String abre = "";
            switch (relaM) {
                case 1:
                    abre = "CS";
                    break;
                case 2:
                    abre = "";
                    break;
                case 4:
                    abre = "SP";
                    break;
                case 6:
                    abre = "DV";
                    break;
                case 8:
                    abre = "UL";
                    break;
            }
            DibujarLineaHijos(relaM, abre);
        }
        if (hijos.length == 1) {
            if (hijos[0].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(360, 405, hijos[0]));
                return;
            } else if (hijos[0].isEmbarazo()) {
                this.listaObjetos.add(new Triangulo(358, 405, hijos[0]));
                return;
            } else {
                this.listaObjetos.add(new circulo(358, 405, hijos[0]));
                return;
            }
        }
        if (hijos.length % 2 == 0) {
            dibujarPares(hijos.length / 2, hijos, 325, 395, 405);
        } else {
            dibujarImpares(hijos.length / 2, hijos, 300, 425, 405);
        }
    }

    public Persona[] obtenerPersonas(Persona[] familia, int par) {
        Persona[] Personas = new Persona[familia.length];
        int pos = 0;
        for (Persona persona : familia) {
            if (persona.getRol() == par) {
                Personas[pos] = persona;
                pos++;
            }
        }
        Persona[] p = new Persona[pos];
        for (int j = 0; j < pos; j++) {
            p[j] = Personas[j];
        }
        return p;
    }

    public Persona[] fusionarArray(Persona[] p, Persona p1) {
        Persona[] res = new Persona[p.length + 1];
        res[0] = p1;
        for (int j = 1; j <= p.length; j++) {
            res[j] = p[j - 1];
        }
        return ordenarPorEdades(res);
    }

    public Persona[] ordenarPorEdades(Persona[] res) {
        for (int j = 0; j < res.length; j++) {
            for (int x = 0; x < res.length - 1; x++) {
                if (Integer.parseInt(res[x].getEdad()) < Integer.parseInt(res[x + 1].getEdad())) {
                    Persona tem = res[x];
                    res[x] = res[x + 1];
                    res[x + 1] = tem;
                }
            }
        }
        return res;
    }

    public int BuscarPadre() {
        int rela = 0;
        for (int j = 0; j < this.listaObjetos.size(); j++) {
            if (this.listaObjetos.get(j).getClass().equals(Cuadrado.class)) {
                Cuadrado lc = (Cuadrado) this.listaObjetos.get(j);
                if (lc.getP().getRol() == 4) {
                    this.padrex = lc.getX();
                    this.padrey = lc.getY();
                    rela = lc.getP().getIdEstadocivil();
                }
            }
        }
        return rela;
    }

    public void DibujarLineaHijos(int rela, String abre) {
        BuscarMadre();
        BuscarPadre();
        this.listaObjetos.add(new Linea(this.padrex + 20, this.padrey + 70, this.padrex + 20, this.padrey + 90, 0, 0, ""));
        this.listaObjetos.add(new Linea(this.madrex + 20, this.madrey + 70, this.madrex + 20, this.madrey + 90, 0, 0, ""));
        this.listaObjetos.add(new Linea(this.madrex + 20, this.madrey + 90, this.padrex + 20, this.padrey + 90, rela, 1, abre));
        this.listaObjetos.add(new Linea(380, 350, 380, 400, 0, 0, ""));
    }

    public int BuscarMadre() {
        int rela = 0;
        for (int j = 0; j < this.listaObjetos.size(); j++) {
            if (this.listaObjetos.get(j).getClass().equals(circulo.class)) {
                circulo c = (circulo) this.listaObjetos.get(j);
                if (c.getP().getRol() == 4) {
                    this.madrex = c.getX();
                    this.madrey = c.getY();
                    rela = c.getP().getIdEstadocivil();
                }
            }
            if (this.listaObjetos.get(j).getClass().equals(Triangulo.class)) {
                Triangulo t = (Triangulo) this.listaObjetos.get(j);
                if (t.getP().getRol() == 4) {
                    this.madrex = t.getX();
                    this.madrey = t.getY();
                    rela = t.getP().getIdEstadocivil();
                }
            }
        }
        return rela;
    }

    public void dibujarRelaciones(Relaciones[] R) {
        for (int x = 0; x < R.length; x++) {
            coordenadas p1 = BuscarPersona(R[x].getIdPersona());
            coordenadas p2 = BuscarPersona(R[x].getIdEntorno());
            if (p2.getY() > p1.getY()) {
                this.listaObjetos.add(new Linea(p1.getX() + 20, p1.getY() + 32, p2.getX() + 20, p2.getY() + 10, R[x].getTipoDeRelacion(), 0, R[x].getAbreviatura()));
            } else if (p1.getY() == p2.getY()) {
                if (p2.getX() > p1.getX()) {
                    this.listaObjetos.add(new Linea(p1.getX() + 28, p1.getY() + 20, p2.getX() + 10, p2.getY() + 20, R[x].getTipoDeRelacion(), 0, R[x].getAbreviatura()));
                } else {
                    this.listaObjetos.add(new Linea(p1.getX() + 10, p1.getY() + 20, p2.getX() + 28, p2.getY() + 20, R[x].getTipoDeRelacion(), 0, R[x].getAbreviatura()));
                }
            } else {
                this.listaObjetos.add(new Linea(p1.getX() + 20, p1.getY() + 10, p2.getX() + 20, p2.getY() + 28, R[x].getTipoDeRelacion(), 0, R[x].getAbreviatura()));
            }
        }
    }

    public void dibujarGuia() {
        this.listaObjetos.add(new Rectangulo(20, 500, 730, 120, null));
    }

    public coordenadas BuscarPersona(int pos) {
        coordenadas c = null;
        for (int j = 0; j < this.listaObjetos.size(); j++) {
            if (this.listaObjetos.get(j).getClass().equals(circulo.class)) {
                circulo xcirculo = (circulo) this.listaObjetos.get(j);
                if (xcirculo.getP().getIdPos() == pos) {
                    c = new coordenadas(xcirculo.getX(), xcirculo.getY());
                    System.out.println(xcirculo.getP().getPrimerNom());
                }
            } else if (this.listaObjetos.get(j).getClass().equals(Cuadrado.class)) {
                Cuadrado xcuadrado = (Cuadrado) this.listaObjetos.get(j);
                if (xcuadrado.getP().getIdPos() == pos) {
                    c = new coordenadas(xcuadrado.getX(), xcuadrado.getY());
                }
            } else if (this.listaObjetos.get(j).getClass().equals(Triangulo.class)) {
                Triangulo xTriangulo = (Triangulo) this.listaObjetos.get(j);
                if (xTriangulo.getP().getIdPos() == pos) {
                    c = new coordenadas(xTriangulo.getX(), xTriangulo.getY());
                }
            }
        }
        return c;
    }
}
