package com.genoma.plus.controller.historia;

import Acceso.Principal;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Stroke;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/Linea.class */
public class Linea {
    private int xini;
    private int yini;
    private int xfin;
    private int yfin;
    private final int tipoRelacion;
    private final int auxrelacion;
    private String abreviatura;

    public Linea(int xini, int yini, int xfin, int yfin, int rel, int aux, String Abreviatura) {
        this.xini = xini;
        this.yini = yini;
        this.xfin = xfin;
        this.yfin = yfin;
        this.tipoRelacion = rel;
        this.auxrelacion = aux;
        this.abreviatura = Abreviatura;
    }

    public int getXini() {
        return this.xini;
    }

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public void setXini(int xini) {
        this.xini = xini;
    }

    public int getYini() {
        return this.yini;
    }

    public void setYini(int yini) {
        this.yini = yini;
    }

    public int getXfin() {
        return this.xfin;
    }

    public void setXfin(int xfin) {
        this.xfin = xfin;
    }

    public int getYfin() {
        return this.yfin;
    }

    public void setYfin(int yfin) {
        this.yfin = yfin;
    }

    public void linea(Graphics2D g) {
        float[] dash = {1.0f};
        Stroke antigu = g.getStroke();
        g.setStroke(new BasicStroke(2.0f, 2, 0, 5.0f, dash, 0.0f));
        g.setColor(Color.GRAY);
        g.drawLine(this.xini, this.yini, this.xfin, this.yfin);
        if (this.auxrelacion == 2 && this.xini > this.xfin) {
            int longitud = (this.xini - this.xfin) / 2;
            if (longitud * 2 < 30) {
                g.drawString(this.abreviatura, this.xini, this.yini);
            } else {
                g.drawString(this.abreviatura, this.xini + 10, this.yini + 5);
            }
        }
        g.setStroke(antigu);
    }

    public void Normal(Graphics2D g) {
        float[] dash = {1.0f};
        Stroke antigu = g.getStroke();
        g.setStroke(new BasicStroke(2.0f, 2, 0, 5.0f, dash, 0.0f));
        g.setColor(Color.GRAY);
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            switch (this.tipoRelacion) {
                case 1:
                    g.setColor(Color.RED);
                    break;
                case 2:
                    g.setColor(Color.BLUE);
                    break;
                case 3:
                    g.setColor(Color.GREEN);
                    break;
                case 4:
                    g.setColor(Color.MAGENTA);
                    break;
                case 5:
                    g.setColor(Color.ORANGE);
                    break;
            }
        }
        g.drawLine(this.xini, this.yini, this.xfin, this.yfin);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", 1, 12));
        if (this.auxrelacion == 2) {
            if (this.yini < this.yfin) {
                if (this.xini < this.xfin) {
                    g.drawString(this.abreviatura, this.xini + 8, this.yini - 8);
                } else {
                    g.drawString(this.abreviatura, this.xini - 15, this.yini - 8);
                }
            } else if (this.yini == this.yfin) {
                if (this.xini < this.xfin) {
                    g.drawString(this.abreviatura, this.xini + 8, this.yini - 8);
                } else {
                    g.drawString(this.abreviatura, this.xini - 15, this.yini - 8);
                }
            } else if (this.xini < this.xfin) {
                g.drawString(this.abreviatura, this.xini + 5, this.yini - 15);
            } else {
                g.drawString(this.abreviatura, this.xini - 20, this.yini + 8);
            }
        } else if (this.auxrelacion == 0) {
            if (this.yini < this.yfin) {
                if (this.xfin > this.xini && this.yini > this.xfin) {
                    g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
                } else {
                    g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
                }
            } else if (this.yfin == this.yini) {
                g.drawString(this.abreviatura, this.xini - 10, this.yini - 10);
            } else {
                g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
            }
        }
        g.setStroke(antigu);
    }

    public void lineaSeparacion(Graphics2D g) {
        float[] dash = {1.0f};
        Stroke antigu = g.getStroke();
        g.setStroke(new BasicStroke(2.0f, 2, 0, 5.0f, dash, 0.0f));
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(this.xini, this.yini, this.xfin, this.yfin);
        g.setFont(new Font("Arial", 1, 12));
        if (this.yini == this.yini) {
            if (this.xini > this.xfin) {
                int longitud = (this.xini - this.xfin) / 2;
                g.drawLine((this.xini - longitud) - 10, this.yini - 5, (this.xini - longitud) + 10, this.yini + 5);
                g.setColor(Color.BLACK);
                g.drawString(getAbreviatura(), this.xini - longitud, this.yini - 10);
            } else {
                int longitud2 = (this.xfin - this.xini) / 2;
                g.drawLine((this.xfin - longitud2) - 10, this.yini - 5, (this.xfin - longitud2) + 10, this.yini + 5);
                g.setColor(Color.BLACK);
                g.drawString(getAbreviatura(), this.xfin - longitud2, this.yini - 10);
            }
            g.setStroke(antigu);
        }
    }

    public void lineaDivorciados(Graphics2D g) {
        float[] dash = {1.0f};
        Stroke antigu = g.getStroke();
        g.setStroke(new BasicStroke(2.0f, 2, 0, 5.0f, dash, 0.0f));
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(this.xini, this.yini, this.xfin, this.yfin);
        g.setFont(new Font("Arial", 1, 12));
        if (this.xini > this.xfin) {
            int longitud = (this.xini - this.xfin) / 2;
            g.drawLine((this.xini - longitud) - 10, this.yini - 5, (this.xini - longitud) + 10, this.yini + 5);
            g.drawLine((this.xini - longitud) - 15, this.yini - 5, (this.xini - longitud) + 5, this.yini + 5);
            g.setColor(Color.BLACK);
            g.drawString(getAbreviatura(), this.xini - longitud, this.yini - 10);
        } else {
            int longitud2 = (this.xfin - this.xini) / 2;
            g.drawLine((this.xfin - longitud2) - 10, this.yini - 5, (this.xfin - longitud2) + 10, this.yini + 5);
            g.drawLine((this.xfin - longitud2) - 18, this.yini - 5, (this.xfin - longitud2) + 2, this.yini + 5);
            g.setColor(Color.BLACK);
            g.drawString(getAbreviatura(), this.xfin - longitud2, this.yini - 10);
        }
        g.setStroke(antigu);
    }

    public void lineaPunteada(Graphics2D g) {
        float[] dash = {5.0f};
        Stroke antigu = g.getStroke();
        g.setStroke(new BasicStroke(2.0f, 0, 0, 5.0f, dash, 0.0f));
        g.setColor(Color.GRAY);
        g.drawLine(this.xini, this.yini, this.xfin, this.yfin);
        g.setFont(new Font("Arial", 1, 12));
        g.setColor(Color.BLACK);
        if (this.auxrelacion == 2) {
            if (this.yini < this.yfin) {
                if (this.xini < this.xfin) {
                    g.drawString(this.abreviatura, this.xini + 8, this.yini - 8);
                } else {
                    g.drawString(this.abreviatura, this.xini - 15, this.yini - 8);
                }
            } else if (this.yini == this.yfin) {
                if (this.xini < this.xfin) {
                    g.drawString(this.abreviatura, this.xini + 8, this.yini - 8);
                } else {
                    g.drawString(this.abreviatura, this.xini - 15, this.yini - 8);
                }
            } else if (this.xini < this.xfin) {
                g.drawString(this.abreviatura, this.xini + 5, this.yini - 15);
            } else {
                g.drawString(this.abreviatura, this.xini - 20, this.yini + 8);
            }
        } else if (this.auxrelacion == 0) {
            if (this.yini < this.yfin) {
                if (this.xfin > this.xini && this.yini > this.xfin) {
                    g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
                } else {
                    g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
                }
            } else if (this.yfin == this.yini) {
                g.drawString(this.abreviatura, this.xini - 10, this.yini - 10);
            } else {
                g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
            }
        } else if (this.xini > this.xfin) {
            int l = this.xini - this.xfin;
            g.drawString(this.abreviatura, this.xini - (l / 2), this.yini - 10);
        } else {
            int l2 = this.xfin - this.xini;
            g.drawString(this.abreviatura, this.xfin - (l2 / 2), this.yini - 10);
        }
        g.setStroke(antigu);
    }

    public void lineGruesa(Graphics2D g, Color c) {
        float[] dash = {1.0f};
        g.setFont(new Font("Arial", 1, 12));
        Stroke antigu = g.getStroke();
        g.setStroke(new BasicStroke(5.0f, 2, 0, 5.0f, dash, 0.0f));
        g.setColor(Color.GRAY);
        g.drawLine(this.xini, this.yini, this.xfin, this.yfin);
        g.setColor(Color.BLACK);
        if (this.auxrelacion == 2) {
            if (this.yini < this.yfin) {
                if (this.xini < this.xfin) {
                    g.drawString(this.abreviatura, this.xini + 8, this.yini - 8);
                } else {
                    g.drawString(this.abreviatura, this.xini - 15, this.yini - 8);
                }
            } else if (this.yini == this.yfin) {
                if (this.xini < this.xfin) {
                    g.drawString(this.abreviatura, this.xini + 8, this.yini - 8);
                } else {
                    g.drawString(this.abreviatura, this.xini - 15, this.yini - 8);
                }
            } else if (this.xini < this.xfin) {
                g.drawString(this.abreviatura, this.xini + 5, this.yini - 15);
            } else {
                g.drawString(this.abreviatura, this.xini - 20, this.yini + 8);
            }
        } else if (this.auxrelacion == 0) {
            if (this.yini < this.yfin) {
                if (this.xfin > this.xini && this.yini > this.xfin) {
                    g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
                } else {
                    g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
                }
            } else if (this.yfin == this.yini) {
                g.drawString(this.abreviatura, this.xini - 10, this.yini - 10);
            } else {
                g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
            }
        } else if (this.xini > this.xfin) {
            int l = this.xini - this.xfin;
            g.drawString(this.abreviatura, this.xini - (l / 2), this.yini - 10);
        } else {
            int l2 = this.xfin - this.xini;
            g.drawString(this.abreviatura, this.xfin - (l2 / 2), this.yini - 10);
        }
        g.setStroke(antigu);
    }

    public void linesemiGruesa(Graphics2D g) {
        float[] dash = {1.0f};
        Stroke antigu = g.getStroke();
        g.setStroke(new BasicStroke(3.0f, 2, 0, 5.0f, dash, 0.0f));
        g.setColor(Color.GRAY);
        g.drawLine(this.xini - 5, this.yini - 5, this.xfin - 5, this.yfin - 5);
        g.setColor(Color.BLACK);
        if (this.auxrelacion == 2) {
            if (this.yini < this.yfin) {
                if (this.xini < this.xfin) {
                    g.drawString(this.abreviatura, this.xini + 8, this.yini - 8);
                } else {
                    g.drawString(this.abreviatura, this.xini - 15, this.yini - 8);
                }
            } else if (this.yini == this.yfin) {
                if (this.xini < this.xfin) {
                    g.drawString(this.abreviatura, this.xini + 8, this.yini - 8);
                } else {
                    g.drawString(this.abreviatura, this.xini - 15, this.yini - 8);
                }
            } else if (this.xini < this.xfin) {
                g.drawString(this.abreviatura, this.xini + 5, this.yini - 15);
            } else {
                g.drawString(this.abreviatura, this.xini - 20, this.yini + 8);
            }
        } else if (this.auxrelacion == 0) {
            if (this.yini < this.yfin) {
                if (this.xfin > this.xini && this.yini > this.xfin) {
                    g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
                } else {
                    g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
                }
            } else if (this.yfin == this.yini) {
                g.drawString(this.abreviatura, this.xini - 10, this.yini - 10);
            } else {
                g.drawString(this.abreviatura, this.xini - 10, this.yini - 15);
            }
        }
        g.setStroke(antigu);
    }

    public void dibujarRelacion(Graphics2D g) {
        if (this.auxrelacion == 0) {
            switch (this.tipoRelacion) {
                case 0:
                    linea(g);
                    break;
                case 10:
                    Normal(g);
                    break;
                case 11:
                    Normal(g);
                    break;
                case 12:
                    Normal(g);
                    break;
                case 13:
                    Normal(g);
                    break;
                case 14:
                    Normal(g);
                    break;
                case 15:
                    Normal(g);
                    break;
            }
        }
        if (this.auxrelacion == 1) {
            switch (this.tipoRelacion) {
                case 1:
                    lineGruesa(g, Color.LIGHT_GRAY);
                    break;
                case 4:
                    lineaSeparacion(g);
                    break;
                case 6:
                    lineaPunteada(g);
                    break;
                case 8:
                    lineaDivorciados(g);
                    break;
            }
        }
        if (this.auxrelacion == 2) {
            if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
                switch (this.tipoRelacion) {
                    case 1:
                        Normal(g);
                        break;
                    case 2:
                        Normal(g);
                        break;
                    case 3:
                        Normal(g);
                        break;
                    case 4:
                        Normal(g);
                        break;
                    case 5:
                        Normal(g);
                        break;
                }
            }
            switch (this.tipoRelacion) {
                case 1:
                    Normal(g);
                    break;
                case 2:
                    Normal(g);
                    break;
                case 3:
                    Normal(g);
                    break;
                case 4:
                    Normal(g);
                    break;
                case 5:
                    Normal(g);
                    break;
            }
        }
    }
}
