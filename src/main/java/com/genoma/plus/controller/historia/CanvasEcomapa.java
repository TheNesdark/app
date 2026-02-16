package com.genoma.plus.controller.historia;

import Acceso.Principal;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/CanvasEcomapa.class */
public class CanvasEcomapa extends Canvas {
    ArrayList<Object> listaObjetos;
    private int guia;
    int xini;
    int xfin;
    int yini;
    int yfin;
    Cuadrado c;
    circulo cir;
    Linea r;
    circulo2 cir2;
    Rectangulo R;
    Triangulo T;
    ArrayList<circulo> liscirculos = null;
    ArrayList<Cuadrado> ListCuadrado = null;
    ArrayList<Linea> ListRelaciones = null;
    int pintado = 0;
    int estado = 0;
    int click = 0;

    public ArrayList<Object> getListaObjetos() {
        return this.listaObjetos;
    }

    public void setListaObjetos(ArrayList<Object> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public void dibujarPadres(Persona[] per) {
        if (this.pintado == 0) {
            this.listaObjetos.add(new circulo2(410, 210, 350));
            this.listaObjetos.add(new Rectangulo(20, 300, 50, 200));
            this.pintado++;
        }
        if (per[0].getSexo().equals("F")) {
            if (per[0].isEmbarazo()) {
                this.listaObjetos.add(new Triangulo(450, 240, per[0]));
            } else {
                this.listaObjetos.add(new circulo(430, 240, per[0]));
            }
        } else {
            this.listaObjetos.add(new Cuadrado(300, 240, per[0]));
        }
        if (per[1].getSexo().equals("F")) {
            if (per[1].isEmbarazo()) {
                this.listaObjetos.add(new Triangulo(450, 240, per[1]));
            } else {
                this.listaObjetos.add(new circulo(430, 240, per[1]));
            }
        } else {
            this.listaObjetos.add(new Cuadrado(300, 240, per[1]));
        }
        this.listaObjetos.add(new Linea(320, 325, 320, 311, 0, 0, ""));
        this.listaObjetos.add(new Linea(450, 325, 450, 311, 0, 0, ""));
        this.listaObjetos.add(new Linea(380, 325, 380, 360, 0, 0, ""));
        if (per[0].getIdEstadocivil() == per[1].getIdEstadocivil()) {
            this.listaObjetos.add(new Linea(320, 325, 450, 325, per[0].getIdEstadocivil(), 1, getAbreviatura(per[0].getIdEstadocivil())));
            System.out.println("relacion " + per[0].getIdEstadocivil());
        } else {
            if (per[0].getIdEstadocivil() != per[1].getIdEstadocivil()) {
            }
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
                abrev = "DV";
                break;
            case 8:
                abrev = "UL";
                break;
        }
        return abrev;
    }

    public CanvasEcomapa() {
        this.listaObjetos = null;
        this.listaObjetos = new ArrayList<>();
        setBackground(Color.white);
        setSize(900, 620);
    }

    public Persona BuscarPersona(Persona[] per, String rol) {
        return per[0];
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        if (this.guia == 0) {
            if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
                g2d.setColor(Color.black);
                g2d.setFont(new Font("Arial", 1, 12));
                this.listaObjetos.add(new Rectangulo(600, 280, 230, 100));
                g2d.drawString("Guia lineas", 620, 295);
                g2d.drawString("Abrev", 790, 295);
                this.listaObjetos.add(new Linea(620, 310, 660, 310, 1, 2, ""));
                g2d.drawString("Interacion Fuerte", 665, 310);
                g2d.drawString("IF", 800, 310);
                this.listaObjetos.add(new Linea(620, 325, 660, 325, 2, 2, ""));
                g2d.drawString("Interacion debil", 665, 325);
                g2d.drawString("ID", 800, 325);
                this.listaObjetos.add(new Linea(620, 340, 660, 340, 3, 2, ""));
                g2d.drawString("Estresante", 665, 340);
                g2d.drawString("ES", 800, 340);
                this.listaObjetos.add(new Linea(620, 355, 660, 355, 4, 2, ""));
                g2d.drawString("Sin Relacion", 665, 355);
                g2d.drawString("SR", 800, 355);
                this.listaObjetos.add(new Linea(620, 370, 660, 370, 5, 2, ""));
                g2d.drawString("Flujo de Recurso", 665, 370);
                g2d.drawString("FR", 800, 370);
            }
        } else {
            g2d.setColor(Color.black);
            g2d.setFont(new Font("Arial", 1, 12));
            this.listaObjetos.add(new Rectangulo(600, 280, 230, 160));
            g2d.drawString("Guia lineas", 620, 295);
            g2d.drawString("Abrev", 790, 295);
            this.listaObjetos.add(new Linea(620, 310, 660, 310, 1, 1, ""));
            g2d.drawString("Casado", 665, 310);
            g2d.drawString("CS", 800, 310);
            this.listaObjetos.add(new Linea(620, 325, 660, 325, 4, 1, ""));
            g2d.drawString("Separado", 665, 325);
            g2d.drawString("SP", 800, 325);
            this.listaObjetos.add(new Linea(620, 340, 660, 340, 8, 1, ""));
            g2d.drawString("Union Libre", 665, 340);
            g2d.drawString("UL", 800, 340);
            this.listaObjetos.add(new Linea(620, 355, 660, 355, 6, 1, ""));
            g2d.drawString("Divorciado", 665, 355);
            g2d.drawString("DV", 800, 355);
            this.listaObjetos.add(new Linea(620, 370, 660, 370, 1, 2, ""));
            g2d.drawString("Interacion fuerte", 665, 370);
            g2d.drawString("IF", 800, 370);
            this.listaObjetos.add(new Linea(625, 385, 660, 385, 2, 2, ""));
            g2d.drawString("Interacion Debil", 665, 385);
            g2d.drawString("ID", 800, 385);
            this.listaObjetos.add(new Linea(620, 400, 660, 400, 3, 2, ""));
            g2d.drawString("Interacion Estresante", 665, 400);
            g2d.drawString("IE", 800, 400);
            this.listaObjetos.add(new Linea(620, 415, 660, 415, 4, 2, ""));
            g2d.drawString("Sin Relacion ", 665, 415);
            g2d.drawString("SR", 800, 415);
            this.listaObjetos.add(new Linea(620, 430, 660, 430, 5, 2, ""));
            g2d.drawString("flujo de recursos ", 665, 430);
            g2d.drawString("FR", 800, 430);
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
            if (this.listaObjetos.get(x).getClass().equals(circulo2.class)) {
                this.cir2 = (circulo2) this.listaObjetos.get(x);
                this.cir2.paint(g2d, Color.DARK_GRAY);
            }
            if (this.listaObjetos.get(x).getClass().equals(Rectangulo.class)) {
                this.R = (Rectangulo) this.listaObjetos.get(x);
                this.R.paint(g2d, Color.DARK_GRAY);
            }
            if (this.listaObjetos.get(x).getClass().equals(Triangulo.class)) {
                this.T = (Triangulo) this.listaObjetos.get(x);
                this.T.paint(g2d);
            }
        }
    }

    public void dibujarHijos(Persona[] per) {
        int length = per.length;
        if (length == 1) {
            if (per[0].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(360, 365, per[0]));
                return;
            } else if (per[0].isEmbarazo()) {
                this.listaObjetos.add(new Triangulo(360, 365, per[0]));
                return;
            } else {
                this.listaObjetos.add(new circulo(360, 365, per[0]));
                return;
            }
        }
        if (length % 2 == 0) {
            dibujarPares(length / 2, per);
        } else {
            dibujarImpares(length / 2, per);
        }
    }

    public Persona[] getHijos(Persona[] per) {
        int hijos = 0;
        Persona[] aux = new Persona[per.length];
        for (int x = 0; x < per.length; x++) {
            if (per[x].getRol() == 3) {
                aux[hijos] = per[x];
                hijos++;
            }
        }
        Persona[] Hijos = new Persona[hijos];
        for (int j = 0; j < hijos; j++) {
            Hijos[j] = aux[j];
        }
        return Hijos;
    }

    public Persona[] getPadres(Persona[] per) {
        int padres = 0;
        Persona[] aux = new Persona[per.length];
        for (int x = 0; x < per.length; x++) {
            if (per[x].getRol() == 4) {
                aux[padres] = per[x];
                padres++;
            }
        }
        Persona[] p = new Persona[padres];
        for (int j = 0; j < padres; j++) {
            p[j] = aux[j];
        }
        return p;
    }

    public void dibujarPares(int num, Persona[] per) {
        int posxizq = 320;
        int posxder = 380;
        for (int x = 0; x < num; x++) {
            if (per[x].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(posxizq, 365, per[x]));
                this.listaObjetos.add(new Linea(posxizq + 20, 360, posxizq + 20, 365, 0, 0, ""));
            } else {
                if (per[x].isEmbarazo()) {
                    this.listaObjetos.add(new Triangulo(posxizq + 20, 365, per[x]));
                } else {
                    this.listaObjetos.add(new circulo(posxizq, 365, per[x]));
                }
                this.listaObjetos.add(new Linea(posxizq + 20, 360, posxizq + 20, 365, 0, 0, ""));
            }
            if (per[(num * 2) - (x + 1)].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(posxder, 365, per[(num * 2) - (x + 1)]));
                this.listaObjetos.add(new Linea(posxder + 20, 360, posxder + 20, 365, 0, 0, ""));
            } else {
                if (per[(num * 2) - (x + 1)].isEmbarazo()) {
                    this.listaObjetos.add(new Triangulo(posxder + 20, 365, per[(num * 2) - (x + 1)]));
                } else {
                    this.listaObjetos.add(new circulo(posxder, 365, per[(num * 2) - (x + 1)]));
                }
                this.listaObjetos.add(new Linea(posxder + 20, 360, posxder + 20, 365, 0, 0, ""));
            }
            posxder += 60;
            posxizq -= 60;
        }
        this.listaObjetos.add(new Linea(posxizq + 80, 360, posxder - 40, 360, 0, 0, ""));
    }

    public void dibujarImpares(int num, Persona[] per) {
        int posxizq = 296;
        int posxder = 425;
        if (per[num].getSexo().equals("M")) {
            this.listaObjetos.add(new Triangulo(360, 365, per[num]));
            this.listaObjetos.add(new Linea(380, 360, 380, 365, 0, 0, ""));
        } else {
            if (per[num].isEmbarazo()) {
                this.listaObjetos.add(new Triangulo(360, 365, per[num]));
            } else {
                this.listaObjetos.add(new circulo(360, 365, per[num]));
            }
            this.listaObjetos.add(new Linea(355, 210, 355, 215, 0, 0, ""));
        }
        for (int x = 0; x < num; x++) {
            if (per[x].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(posxizq, 365, per[x]));
                this.listaObjetos.add(new Linea(posxizq + 20, 360, posxizq + 20, 365, 0, 0, ""));
            } else {
                if (per[x].isEmbarazo()) {
                    this.listaObjetos.add(new Triangulo(posxizq + 20, 365, per[x]));
                } else {
                    this.listaObjetos.add(new circulo(posxizq, 365, per[x]));
                }
                this.listaObjetos.add(new Linea(posxizq + 21, 360, posxizq + 21, 365, 0, 0, ""));
            }
            if (per[(num * 2) - x].getSexo().equals("M")) {
                this.listaObjetos.add(new Cuadrado(posxder, 365, per[(num * 2) - x]));
                this.listaObjetos.add(new Linea(posxder + 20, 360, posxder + 20, 365, 0, 0, ""));
            } else {
                if (per[(num * 2) - x].isEmbarazo()) {
                    this.listaObjetos.add(new Triangulo(posxder + 20, 365, per[(num * 2) - x]));
                } else {
                    this.listaObjetos.add(new circulo(posxder, 365, per[(num * 2) - x]));
                }
                this.listaObjetos.add(new Linea(posxder + 21, 360, posxder + 21, 365, 0, 0, ""));
            }
            posxder += 60;
            posxizq -= 60;
        }
        this.listaObjetos.add(new Linea(posxizq + 80, 360, posxder - 40, 360, 0, 0, ""));
    }

    public void dibujarEntorno(List<Object[]> entorno) {
        if (this.pintado == 0) {
            this.listaObjetos.add(new circulo2(210, 160, 350));
            this.pintado++;
        }
        int residuo = entorno.size() % 4;
        int tomar = entorno.size() / 4;
        System.out.println("residuo" + residuo);
        switch (residuo) {
            case 0:
                dibIzqSuperior(partir(entorno, tomar, 0));
                dibIzqInferior(partir(entorno, tomar, 0 + (tomar * 1)));
                dibDerInferior(partir(entorno, tomar, 0 + (tomar * 2)));
                dibDerSuperior(partir(entorno, tomar, 0 + (tomar * 3)));
                break;
            case 1:
                dibIzqSuperior(partir(entorno, tomar + 1, 0));
                dibIzqInferior(partir(entorno, tomar, 0 + (tomar * 1) + 1));
                dibDerInferior(partir(entorno, tomar, 0 + (tomar * 2) + 1));
                dibDerSuperior(partir(entorno, tomar, 0 + (tomar * 3) + 1));
                break;
            case 2:
                dibIzqSuperior(partir(entorno, tomar + 1, 0));
                dibIzqInferior(partir(entorno, tomar + 1, 0 + (tomar * 1) + 1));
                dibDerInferior(partir(entorno, tomar, 0 + (tomar * 2) + 2));
                dibDerSuperior(partir(entorno, tomar, 0 + (tomar * 3) + 2));
                break;
            case 3:
                dibIzqSuperior(partir(entorno, tomar + 1, 0));
                dibIzqInferior(partir(entorno, tomar + 1, 0 + (tomar * 1) + 1));
                dibDerInferior(partir(entorno, tomar + 1, 0 + (tomar * 2) + 2));
                dibDerSuperior(partir(entorno, tomar, 0 + (tomar * 3) + 3));
                break;
        }
    }

    public Entorno[] partir(List<Object[]> Entorno, int num, int pos) {
        Entorno[] entorno = new Entorno[num];
        int j = 0;
        for (int x = pos; x < num + pos; x++) {
            entorno[j] = new Entorno(Integer.parseInt(Entorno.get(x)[0].toString()), Entorno.get(x)[1].toString());
            j++;
        }
        return entorno;
    }

    public void dibIzqSuperior(Entorno[] entorno) {
        int posx = 20;
        int posy = 230;
        for (Entorno entorno2 : entorno) {
            this.listaObjetos.add(new Rectangulo(posx, posy, 150, 30, entorno2));
            posx += 30;
            posy -= 60;
        }
    }

    public void dibIzqInferior(Entorno[] entorno) {
        int posx = 20;
        int posy = 450;
        for (Entorno entorno2 : entorno) {
            this.listaObjetos.add(new Rectangulo(posx, posy, 150, 30, entorno2));
            posx += 30;
            posy += 60;
        }
    }

    public void dibDerSuperior(Entorno[] entorno) {
        int posx = 600;
        int posy = 230;
        for (Entorno entorno2 : entorno) {
            this.listaObjetos.add(new Rectangulo(posx, posy, 150, 30, entorno2));
            posx -= 30;
            posy -= 60;
        }
    }

    public void dibDerInferior(Entorno[] entorno) {
        int posx = 600;
        int posy = 450;
        for (Entorno entorno2 : entorno) {
            this.listaObjetos.add(new Rectangulo(posx, posy, 150, 30, entorno2));
            posx -= 30;
            posy += 60;
        }
    }

    public void dibRelaciones(Relaciones[] xRelaciones, Persona[] per) {
        coordenadas cP = null;
        for (Relaciones xRelacione : xRelaciones) {
            if (getSexo(per, xRelacione.getIdPersona()).equals("M")) {
                cP = buscarCuadrado(per, xRelacione.getIdPersona());
            } else if (getSexo(per, xRelacione.getIdPersona()).equals("F")) {
                cP = buscarCirculo(per, xRelacione.getIdPersona());
                if (cP == null) {
                    cP = buscarTriangulo(per, xRelacione.getIdPersona());
                }
            }
            coordenadas cE = buscarEntorno(xRelacione.getIdEntorno());
            if (cE.getX() < 500 && cE.getY() < 320) {
                this.listaObjetos.add(new Linea(cE.getX() + 150, cE.getY() + 15, cP.getX(), cP.getY(), xRelacione.getTipoDeRelacion(), 2, xRelacione.getAbreviatura()));
            } else if (cE.getX() > 500 && cE.getY() < 320) {
                this.listaObjetos.add(new Linea(cE.getX(), cE.getY() + 15, cP.getX() + 35, cP.getY() + 15, xRelacione.getTipoDeRelacion(), 2, xRelacione.getAbreviatura()));
            } else if (cE.getX() < 500 && cE.getY() > 320) {
                this.listaObjetos.add(new Linea(cE.getX() + 150, cE.getY() + 15, cP.getX(), cP.getY() + 15, xRelacione.getTipoDeRelacion(), 2, xRelacione.getAbreviatura()));
            } else if (cE.getX() > 500 && cE.getY() > 320) {
                this.listaObjetos.add(new Linea(cE.getX(), cE.getY() + 15, cP.getX() + 35, cP.getY() + 15, xRelacione.getTipoDeRelacion(), 2, xRelacione.getAbreviatura()));
            }
        }
    }

    public String getSexo(Persona[] per, int idPos) {
        String sexo = "";
        for (Persona persona : per) {
            if (persona.getIdPos() == idPos) {
                sexo = persona.getSexo();
            }
        }
        return sexo;
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

    public coordenadas buscarCuadrado(Persona[] per, int idPos) {
        coordenadas c = null;
        for (Object listaObjeto : this.listaObjetos) {
            if (listaObjeto.getClass().equals(Cuadrado.class)) {
                Cuadrado xcuadrado = (Cuadrado) listaObjeto;
                if (xcuadrado.getP().getIdPos() == idPos) {
                    c = new coordenadas(xcuadrado.getX(), xcuadrado.getY());
                }
            }
        }
        return c;
    }

    public coordenadas buscarCirculo(Persona[] per, int idPos) {
        coordenadas c = null;
        for (Object listaObjeto : this.listaObjetos) {
            if (listaObjeto.getClass().equals(circulo.class)) {
                circulo xcirculo = (circulo) listaObjeto;
                if (xcirculo.getP().getIdPos() == idPos) {
                    c = new coordenadas(xcirculo.getX(), xcirculo.getY());
                }
            }
        }
        return c;
    }

    public coordenadas buscarTriangulo(Persona[] per, int idPos) {
        coordenadas c = null;
        for (Object listaObjeto : this.listaObjetos) {
            if (listaObjeto.getClass().equals(Triangulo.class)) {
                Triangulo xTriangulo = (Triangulo) listaObjeto;
                if (xTriangulo.getP().getIdPos() == idPos) {
                    c = new coordenadas(xTriangulo.getX() + 5, xTriangulo.getY() + 5);
                }
            }
        }
        return c;
    }

    public coordenadas buscarEntorno(int idEntorno) {
        coordenadas c = null;
        for (Object listaObjeto : this.listaObjetos) {
            if (listaObjeto.getClass().equals(Rectangulo.class)) {
                Rectangulo R = (Rectangulo) listaObjeto;
                if (R.getEntorno().getIdPosEntorno() == idEntorno) {
                    c = new coordenadas(R.getX(), R.getY());
                }
            }
        }
        return c;
    }

    public void setGuia(int g) {
        this.guia = g;
    }
}
