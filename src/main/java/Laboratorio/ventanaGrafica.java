package Laboratorio;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/ventanaGrafica.class */
public class ventanaGrafica extends Frame {
    BufferedImage grafica = null;

    public ventanaGrafica() {
        initComponents();
    }

    private void initComponents() {
        addWindowListener(new WindowAdapter() { // from class: Laboratorio.ventanaGrafica.1
            public void windowClosing(WindowEvent evt) {
                ventanaGrafica.this.exitForm(evt);
            }
        });
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitForm(WindowEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {
        ventanaGrafica miventana = new ventanaGrafica();
        miventana.setSize(400, 400);
        miventana.show();
    }

    public BufferedImage creaImagen() {
        XYSeries series = new XYSeries("Evolucion");
        series.add(1.0d, 23.0d);
        series.add(2.0d, 34.0d);
        series.add(3.0d, 51.0d);
        series.add(4.0d, 67.0d);
        series.add(5.0d, 89.0d);
        series.add(6.0d, 121.0d);
        series.add(7.0d, 137.0d);
        JFreeChart chart = ChartFactory.createXYLineChart("Sesiones en Adictos al Trabajo", "Meses", "Sesiones", new XYSeriesCollection(series), PlotOrientation.VERTICAL, false, false, true);
        BufferedImage image = chart.createBufferedImage(300, 300);
        return image;
    }

    public void paint(Graphics g) {
        if (this.grafica == null) {
            this.grafica = creaImagen();
        }
        g.drawImage(this.grafica, 30, 30, (ImageObserver) null);
    }
}
