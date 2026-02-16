package Laboratorio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/XYLineChart.class */
public class XYLineChart extends ImageIcon {
    private JTable xtabla;

    public XYLineChart(Dimension d, JTable xtabla) {
        this.xtabla = xtabla;
        XYDataset xydataset = xyDataset();
        JFreeChart jfreechart = ChartFactory.createXYLineChart("HISTÓRICO", "Fecha Resultado", "VResultado", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.white);
        xyplot.setDomainGridlinePaint(Color.BLACK);
        xyplot.setRangeGridlinePaint(Color.BLACK);
        XYLineAndShapeRenderer xylineandshaperenderer = xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        xylineandshaperenderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        xylineandshaperenderer.setBaseItemLabelsVisible(true);
        xylineandshaperenderer.setBaseLinesVisible(true);
        xylineandshaperenderer.setBaseItemLabelsVisible(true);
        BufferedImage bufferedImage = jfreechart.createBufferedImage(d.width, d.height);
        setImage(bufferedImage);
    }

    private XYDataset xyDataset() {
        XYSeries sIngresos = new XYSeries("Resultado");
        for (int x = 0; x < this.xtabla.getRowCount(); x++) {
            sIngresos.add(x + 1, Double.valueOf(this.xtabla.getValueAt(x, 5).toString()));
        }
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(sIngresos);
        return xyseriescollection;
    }
}
