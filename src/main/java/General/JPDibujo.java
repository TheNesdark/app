package General;

import Utilidades.Dibujo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.Serializable;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.layout.GroupLayout;

/* JADX INFO: loaded from: GenomaP.jar:General/JPDibujo.class */
public class JPDibujo extends JPanel implements Serializable {
    int x1;
    int x2;
    int y1;
    int y2;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JFrame frmColor;
    private JColorChooser selecColor;
    int linea = 0;
    int lapiz = 1;
    int circulo = 0;
    int rectangulo = 0;
    int rectanguloRed = 0;
    Color fondo = new Color(255, 255, 255);
    Color seleccion = new Color(0, 0, 0);
    Vector<Dibujo> lista = new Vector<>();
    Dibujo aux = null;
    BufferedImage backingImage = null;
    boolean relleno = false;

    public JPDibujo() {
        initComponents();
        setBackground(this.fondo);
        this.frmColor.pack();
    }

    public void limpiar() {
        paintComponent(getGraphics());
    }

    private void initComponents() {
        this.frmColor = new JFrame();
        this.selecColor = new JColorChooser();
        this.btnAceptar = new JButton();
        this.btnCancelar = new JButton();
        this.frmColor.getContentPane().setLayout((LayoutManager) null);
        this.frmColor.getContentPane().add(this.selecColor);
        this.selecColor.setBounds(10, 0, 650, 344);
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: General.JPDibujo.1
            public void actionPerformed(ActionEvent evt) {
                JPDibujo.this.btnAceptarActionPerformed(evt);
            }
        });
        this.frmColor.getContentPane().add(this.btnAceptar);
        this.btnAceptar.setBounds(80, 350, 90, 25);
        this.btnCancelar.setText("Cancelar");
        this.btnCancelar.addActionListener(new ActionListener() { // from class: General.JPDibujo.2
            public void actionPerformed(ActionEvent evt) {
                JPDibujo.this.btnCancelarActionPerformed(evt);
            }
        });
        this.frmColor.getContentPane().add(this.btnCancelar);
        this.btnCancelar.setBounds(210, 350, 90, 25);
        setBackground(new Color(255, 255, 255));
        setCursor(new Cursor(0));
        addMouseMotionListener(new MouseMotionAdapter() { // from class: General.JPDibujo.3
            public void mouseDragged(MouseEvent evt) {
                JPDibujo.this.formMouseDragged(evt);
            }
        });
        addMouseListener(new MouseAdapter() { // from class: General.JPDibujo.4
            public void mouseClicked(MouseEvent evt) {
                JPDibujo.this.formMouseClicked(evt);
            }

            public void mousePressed(MouseEvent evt) {
                JPDibujo.this.formMousePressed(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                JPDibujo.this.formMouseReleased(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(1).add(0, 499, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(1).add(0, 283, 32767));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMousePressed(MouseEvent evt) {
        this.x1 = evt.getX();
        this.y1 = evt.getY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseReleased(MouseEvent evt) {
        int agrega;
        int agrega2;
        int agrega3;
        this.x2 = evt.getX();
        this.y2 = evt.getY();
        if (this.linea == 1) {
            this.aux = new Dibujo(this.x1, this.x2, this.y1, this.y2, this.seleccion, 0);
        } else if (this.circulo == 1) {
            if (this.relleno) {
                agrega3 = 3;
            } else {
                agrega3 = 1;
            }
            if (this.x1 > this.x2 || this.y1 > this.y2) {
                this.aux = new Dibujo(this.x2, this.x1, this.y2, this.y1, this.seleccion, agrega3);
            } else {
                this.aux = new Dibujo(this.x1, this.x2, this.y1, this.y2, this.seleccion, agrega3);
            }
        } else if (this.rectangulo == 1) {
            if (this.relleno) {
                agrega2 = 5;
            } else {
                agrega2 = 4;
            }
            if (this.x1 > this.x2 || this.y1 > this.y2) {
                this.aux = new Dibujo(this.x2, this.x1, this.y2, this.y1, this.seleccion, agrega2);
            } else {
                this.aux = new Dibujo(this.x1, this.x2, this.y1, this.y2, this.seleccion, agrega2);
            }
        } else if (this.rectanguloRed == 1) {
            if (this.relleno) {
                agrega = 7;
            } else {
                agrega = 6;
            }
            if (this.x1 > this.x2 || this.y1 > this.y2) {
                this.aux = new Dibujo(this.x2, this.x1, this.y2, this.y1, this.seleccion, agrega);
            } else {
                this.aux = new Dibujo(this.x1, this.x2, this.y1, this.y2, this.seleccion, agrega);
            }
        } else if (this.lapiz == 1) {
            this.aux = new Dibujo(this.x1, this.x2, this.y1, this.y2, this.seleccion, 2);
        }
        this.lista.add(this.aux);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseDragged(MouseEvent evt) {
        this.x2 = evt.getX();
        this.y2 = evt.getY();
        if (this.lapiz == 1) {
            Dibujo a = new Dibujo(this.x1, this.x2, this.y1, this.y2, this.seleccion, 2);
            this.x1 = this.x2;
            this.y1 = this.y2;
            this.lista.add(a);
        }
        repaint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        this.seleccion = this.selecColor.getColor();
        this.frmColor.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCancelarActionPerformed(ActionEvent evt) {
        this.frmColor.setVisible(false);
    }

    public RenderedImage getImage() {
        int width = getWidth();
        int height = getHeight();
        this.backingImage = new BufferedImage(width, height, 1);
        Graphics2D graphics2DCreateGraphics = this.backingImage.createGraphics();
        graphics2DCreateGraphics.setColor(this.fondo);
        graphics2DCreateGraphics.fillRect(0, 0, width, height);
        volverADibujar(graphics2DCreateGraphics);
        graphics2DCreateGraphics.dispose();
        return this.backingImage;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5.0f));
        super.paintComponent(g);
        volverADibujar(g);
        setBackground(this.fondo);
        g.setColor(this.seleccion);
        if (this.linea == 1) {
            g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
            return;
        }
        if (this.circulo == 1) {
            if (this.relleno) {
                if (this.x1 > this.x2 || this.y1 > this.y2) {
                    g.fillOval(this.x2, this.y2, this.x1 - this.x2, this.y1 - this.y2);
                    return;
                } else {
                    g.fillOval(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
                    return;
                }
            }
            if (this.x1 > this.x2 || this.y1 > this.y2) {
                g.drawOval(this.x2, this.y2, this.x1 - this.x2, this.y1 - this.y2);
                return;
            } else {
                g.drawOval(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
                return;
            }
        }
        if (this.rectangulo == 1) {
            if (this.relleno) {
                if (this.x1 > this.x2 || this.y1 > this.y2) {
                    g.fillRect(this.x1, this.y1, this.x1 - this.x2, this.y1 - this.y2);
                    return;
                } else {
                    g.fillRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
                    return;
                }
            }
            if (this.x1 > this.x2 || this.y1 > this.y2) {
                g.drawRect(this.x2, this.y2, this.x1 - this.x2, this.y1 - this.y2);
                return;
            } else {
                g.drawRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1);
                return;
            }
        }
        if (this.rectanguloRed == 1) {
            if (this.relleno) {
                if (this.x1 > this.x2 || this.y1 > this.y2) {
                    g.fillRoundRect(this.x1, this.y1, this.x1 - this.x2, this.y1 - this.y2, 5, 5);
                    return;
                } else {
                    g.fillRoundRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1, 5, 5);
                    return;
                }
            }
            if (this.x1 > this.x2 || this.y1 > this.y2) {
                g.drawRoundRect(this.x2, this.y2, this.x1 - this.x2, this.y1 - this.y2, 5, 5);
                return;
            } else {
                g.drawRoundRect(this.x1, this.y1, this.x2 - this.x1, this.y2 - this.y1, 5, 5);
                return;
            }
        }
        if (this.lapiz == 1) {
            g2d.drawLine(this.x1, this.y1, this.x2, this.y2);
            return;
        }
        this.lista = new Vector<>();
        g2d.setColor(Color.white);
        g2d.fillRect(-10, -10, getWidth(), getHeight());
    }

    private void volverADibujar(Graphics g) {
        if (this.lista.size() > 0) {
            for (int i = 0; i < this.lista.size(); i++) {
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5.0f));
                Dibujo var = this.lista.get(i);
                g.setColor(var.color);
                if (var.tipo == 0) {
                    g2d.drawLine(var.xInicial, var.yInicial, var.xFinal, var.yFinal);
                } else if (var.tipo == 1) {
                    if (var.xInicial > var.xFinal || var.yInicial > var.yFinal) {
                        g.drawOval(var.xFinal, var.yFinal, var.xInicial - var.xFinal, var.yInicial - var.yFinal);
                    } else {
                        g.drawOval(var.xInicial, var.yInicial, var.xFinal - var.xInicial, var.yFinal - var.yInicial);
                    }
                } else if (var.tipo == 2) {
                    g2d.drawLine(var.xInicial, var.yInicial, var.xFinal, var.yFinal);
                } else if (var.tipo == 3) {
                    if (var.xInicial > var.xFinal || var.yInicial > var.yFinal) {
                        g.fillOval(var.xFinal, var.yFinal, var.xInicial - var.xFinal, var.yInicial - var.yFinal);
                    } else {
                        g.fillOval(var.xInicial, var.yInicial, var.xFinal - var.xInicial, var.yFinal - var.yInicial);
                    }
                } else if (var.tipo == 4) {
                    if (var.xInicial > var.xFinal || var.yInicial > var.yFinal) {
                        g.drawRect(var.xFinal, var.yFinal, var.xInicial - var.xFinal, var.yInicial - var.yFinal);
                    } else {
                        g.drawRect(var.xInicial, var.yInicial, var.xFinal - var.xInicial, var.yFinal - var.yInicial);
                    }
                } else if (var.tipo == 5) {
                    if (var.xInicial > var.xFinal || var.yInicial > var.yFinal) {
                        g.fillRect(var.xFinal, var.yFinal, var.xInicial - var.xFinal, var.yInicial - var.yFinal);
                    } else {
                        g.fillRect(var.xInicial, var.yInicial, var.xFinal - var.xInicial, var.yFinal - var.yInicial);
                    }
                } else if (var.tipo == 6) {
                    if (var.xInicial > var.xFinal || var.yInicial > var.yFinal) {
                        g.drawRoundRect(var.xFinal, var.yFinal, var.xInicial - var.xFinal, var.yInicial - var.yFinal, 5, 5);
                    } else {
                        g.drawRoundRect(var.xInicial, var.yInicial, var.xFinal - var.xInicial, var.yFinal - var.yInicial, 5, 5);
                    }
                } else if (var.tipo == 7) {
                    if (var.xInicial > var.xFinal || var.yInicial > var.yFinal) {
                        g.fillRoundRect(var.xFinal, var.yFinal, var.xInicial - var.xFinal, var.yInicial - var.yFinal, 5, 5);
                    } else {
                        g.fillRoundRect(var.xInicial, var.yInicial, var.xFinal - var.xInicial, var.yFinal - var.yInicial, 5, 5);
                    }
                }
            }
        }
    }
}
