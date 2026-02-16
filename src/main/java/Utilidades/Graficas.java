package Utilidades;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Graficas.class */
public class Graficas {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();

    public void edadTallaNinos0_5(String idPaciente) {
        String[][] strArr = new String[1][3];
        String sql = "SELECT ingreso.FechaIngreso, h_examenfisico.Talla FROM baseserver.ingreso INNER JOIN baseserver.g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN baseserver.h_atencion ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.h_examenfisico ON (h_examenfisico.Id_Atencion = h_atencion.Id) WHERE (g_usuario.Id_persona ='" + idPaciente + "') ORDER BY ingreso.FechaIngreso ASC";
        ResultSet rs = this.consultas.traerRs(sql);
        try {
            rs.last();
            if (rs.getRow() > 0) {
                XYSeries series = new XYSeries("Evolución de Crecimiento");
                XYSeries p3 = new XYSeries("P 3");
                XYSeries p15 = new XYSeries("P 15");
                XYSeries p50 = new XYSeries("P 50");
                XYSeries p85 = new XYSeries("P 85");
                XYSeries p97 = new XYSeries("P 97");
                int fila = 0;
                rs.beforeFirst();
                while (rs.next()) {
                    String[][] edad = this.metodos.getEdad(rs.getString(1));
                    System.out.println("Edad " + edad[0][0]);
                    series.add(Integer.parseInt(edad[0][0]), rs.getInt(2));
                    fila++;
                }
                rs.close();
                ResultSet rs2 = this.consultas.traerRs("SELECT Id, Sexo, Edad, RangoEdad, P3, P15, P50, P85, P97 FROM p_valorespercentiles WHERE (Sexo ='M' AND RangoEdad =1)");
                while (rs2.next()) {
                    p3.add(rs2.getInt(3), rs2.getInt(5));
                    p15.add(rs2.getInt(3), rs2.getInt(6));
                    p50.add(rs2.getInt(3), rs2.getInt(7));
                    p85.add(rs2.getInt(3), rs2.getInt(8));
                    p97.add(rs2.getInt(3), rs2.getInt(9));
                }
                rs2.close();
                this.consultas.cerrarConexionBd();
                XYSeriesCollection juegoDatos = new XYSeriesCollection();
                juegoDatos.addSeries(series);
                juegoDatos.addSeries(p3);
                juegoDatos.addSeries(p15);
                juegoDatos.addSeries(p50);
                juegoDatos.addSeries(p85);
                juegoDatos.addSeries(p97);
                JFreeChart chart = ChartFactory.createXYLineChart("Escala de Crecimiento y Desarrollo \nTalla para la Edad en Niños de 0 a 5 Años", "Edad en Meses Cumplidos", "Longuitud / Talla en Cm", juegoDatos, PlotOrientation.VERTICAL, true, true, true);
                try {
                    ChartUtilities.saveChartAsJPEG(new File("c:\\Genoma\\Graficas\\EdadTallaNinos05.jpg"), chart, 800, 500);
                    this.metodos.mostrarPdf("C:\\Genoma\\Graficas\\EdadTallaNinos05.jpg");
                } catch (IOException e) {
                    this.metodos.mostrarMensaje("Se produjo un Error mientras se creaba el Gráfico");
                }
            } else {
                this.metodos.mostrarMensaje("No hay datos para Gráficar");
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorE(ex);
        }
    }
}
