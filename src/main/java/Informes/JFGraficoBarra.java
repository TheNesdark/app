package Informes;

import Sgc.JIFFicha5w1H;
import Sgc.JIFRNoConfomidad;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JFGraficoBarra.class */
public class JFGraficoBarra extends JFrame {
    JIFFicha5w1H xjifficha;
    JIFRNoConfomidad xjifNC;
    String xnombreBoton;
    String xLabelx;
    String xLabely;
    String xobjetollamador;
    private static final long serialVersionUID = 1;

    public JFGraficoBarra(String applicationTitle, String chartTitle, String xnombreBoton, JInternalFrame frmI, String xLabelx, String xLabely) {
        super(applicationTitle);
        this.xnombreBoton = xnombreBoton;
        mRealizarCasting(frmI);
        this.xLabelx = xLabelx;
        this.xLabely = xLabely;
        DefaultCategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
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

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset result = new DefaultCategoryDataset();
        if (this.xobjetollamador.equals("xjifficha5w1h")) {
            if (this.xnombreBoton == "BotonAccion") {
                for (int x = 0; x < this.xjifficha.JTDetalleAccion.getRowCount(); x++) {
                    result.setValue(Double.valueOf(this.xjifficha.xmodeloaccion.getValueAt(x, 1).toString()), this.xjifficha.xmodeloaccion.getValueAt(x, 0).toString(), "");
                }
            } else if (this.xnombreBoton == "BotonOrigen") {
                for (int x2 = 0; x2 < this.xjifficha.JTDetalleOrigen.getRowCount(); x2++) {
                    result.setValue(Double.valueOf(this.xjifficha.xmodeloorigen.getValueAt(x2, 1).toString()), this.xjifficha.xmodeloorigen.getValueAt(x2, 0).toString(), "");
                }
            } else if (this.xnombreBoton == "BotonProceso") {
                for (int x3 = 0; x3 < this.xjifficha.JTDetalleProceso.getRowCount(); x3++) {
                    result.setValue(Double.valueOf(this.xjifficha.xmodeloproceso.getValueAt(x3, 2).toString()), this.xjifficha.xmodeloproceso.getValueAt(x3, 0).toString(), "");
                }
            }
        } else if (this.xobjetollamador.equals("xjifreportenc2")) {
            if (this.xnombreBoton == "BotonOrigenNC") {
                for (int x4 = 0; x4 < this.xjifNC.JTDetalleOrigen.getRowCount(); x4++) {
                    result.setValue(Double.valueOf(this.xjifNC.xmodeloorigen.getValueAt(x4, 2).toString()), "Analizadas", this.xjifNC.xmodeloorigen.getValueAt(x4, 1).toString());
                }
                for (int x5 = 0; x5 < this.xjifNC.JTDetalleOrigen.getRowCount(); x5++) {
                    result.setValue(Double.valueOf(this.xjifNC.xmodeloorigen.getValueAt(x5, 3).toString()), "No Analizadas", this.xjifNC.xmodeloorigen.getValueAt(x5, 1).toString());
                }
            } else if (this.xnombreBoton == "BotonProcesoNC") {
                for (int x6 = 0; x6 < this.xjifNC.JTDetallePR.getRowCount(); x6++) {
                    result.setValue(Double.valueOf(this.xjifNC.xmodeloproceso.getValueAt(x6, 3).toString()), "Analizadas", this.xjifNC.xmodeloproceso.getValueAt(x6, 1).toString());
                }
                for (int x7 = 0; x7 < this.xjifNC.JTDetallePR.getRowCount(); x7++) {
                    result.setValue(Double.valueOf(this.xjifNC.xmodeloproceso.getValueAt(x7, 4).toString()), "No Analizadas", this.xjifNC.xmodeloproceso.getValueAt(x7, 1).toString());
                }
            } else if (this.xnombreBoton == "BotonTipoNC") {
                for (int x8 = 0; x8 < this.xjifNC.JTDetalleNC.getRowCount(); x8++) {
                    result.setValue(Double.valueOf(this.xjifNC.xmodeloNC.getValueAt(x8, 2).toString()), "Analizadas", this.xjifNC.xmodeloNC.getValueAt(x8, 1).toString());
                }
                for (int x9 = 0; x9 < this.xjifNC.JTDetalleNC.getRowCount(); x9++) {
                    result.setValue(Double.valueOf(this.xjifNC.xmodeloNC.getValueAt(x9, 3).toString()), "No Analizadas", this.xjifNC.xmodeloNC.getValueAt(x9, 1).toString());
                }
            }
        }
        return result;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createBarChart3D(title, this.xLabelx, this.xLabely, dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = chart.getPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        plot.setBackgroundAlpha(0.5f);
        return chart;
    }

    private void mRealizarCasting(JInternalFrame frmI) {
        if (frmI.getName().equals("xjifficha5w1h")) {
            this.xjifficha = (JIFFicha5w1H) frmI;
            this.xobjetollamador = "xjifficha5w1h";
        } else if (frmI.getName().equals("xjifreportenc2")) {
            this.xjifNC = (JIFRNoConfomidad) frmI;
            this.xobjetollamador = "xjifreportenc2";
        }
    }
}
