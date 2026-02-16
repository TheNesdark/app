package Informes;

import Sgc.JIFFicha5w1H;
import Sgc.JIFResultadoEncuesta;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JFGrafico.class */
public class JFGrafico extends JFrame {
    JIFResultadoEncuesta xjif;
    JIFFicha5w1H xjifficha;
    String xnombreBoton;

    public JFGrafico(JIFResultadoEncuesta xjif) {
        initComponents();
        this.xjif = xjif;
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, this.xjif.JTPreguntas.getValueAt(this.xjif.JTPreguntas.getSelectedRow(), 1).toString());
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 300));
        setContentPane(chartPanel);
    }

    private void initComponents() {
        setDefaultCloseOperation(2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 838, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 541, 32767));
        pack();
    }

    private PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        for (int x = 0; x < this.xjif.JTRespuesta.getRowCount(); x++) {
            result.setValue(this.xjif.xmodelo1.getValueAt(x, 1).toString(), Integer.valueOf(this.xjif.xmodelo1.getValueAt(x, 2).toString()));
        }
        return result;
    }

    private JFreeChart createChart(PieDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
        PiePlot3D plot = chart.getPlot();
        plot.setStartAngle(290.0d);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.6f);
        return chart;
    }
}
