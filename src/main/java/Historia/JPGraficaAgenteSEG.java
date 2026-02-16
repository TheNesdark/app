package Historia;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.ShapeUtilities;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficaAgenteSEG.class */
public class JPGraficaAgenteSEG extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloAg;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Object[] xdatos;
    private JTable JTAgente;
    private JTable JTSeg;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;

    public JPGraficaAgenteSEG() {
        initComponents();
        mBuscaSEG();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTSeg = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.JTAgente = new JTable();
        this.jScrollPane3 = new JScrollPane();
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO DE SEG", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTSeg.setFont(new Font("Arial", 1, 12));
        this.JTSeg.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSeg.setSelectionBackground(new Color(255, 255, 255));
        this.JTSeg.setSelectionForeground(Color.red);
        this.JTSeg.addMouseListener(new MouseAdapter() { // from class: Historia.JPGraficaAgenteSEG.1
            public void mouseClicked(MouseEvent evt) {
                JPGraficaAgenteSEG.this.JTSegMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTSeg);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "AGENTES", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAgente.setFont(new Font("Arial", 1, 12));
        this.JTAgente.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTAgente.setSelectionBackground(new Color(255, 255, 255));
        this.JTAgente.setSelectionForeground(Color.red);
        this.JTAgente.addMouseListener(new MouseAdapter() { // from class: Historia.JPGraficaAgenteSEG.2
            public void mouseClicked(MouseEvent evt) {
                JPGraficaAgenteSEG.this.JTAgenteMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTAgente);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jScrollPane3.setMaximumSize(new Dimension(658, 334));
        this.jScrollPane3.setMinimumSize(new Dimension(658, 334));
        this.jScrollPane3.setPreferredSize(new Dimension(658, 334));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 681, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane2, -1, 248, 32767).addComponent(this.jScrollPane1, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSegMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTSeg.getSelectedRow() > -1) {
            this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "AGENTES " + this.xmodelo.getValueAt(this.JTSeg.getSelectedRow(), 1).toString().toUpperCase(), 2, 0, new Font("Arial", 1, 12), Color.blue));
            mBuscaAgentes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgenteMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTAgente.getSelectedRow() > -1) {
            this.jScrollPane3.getViewport().add(createDemoPanel(this.xmodeloAg.getValueAt(this.JTAgente.getSelectedRow(), 0).toString(), this.xmodelo.getValueAt(this.JTSeg.getSelectedRow(), 1).toString().toUpperCase() + " - " + this.xmodeloAg.getValueAt(this.JTAgente.getSelectedRow(), 1).toString().toUpperCase() + "(" + this.xmodeloAg.getValueAt(this.JTAgente.getSelectedRow(), 3).toString() + ")"));
            this.jScrollPane3.updateUI();
        }
    }

    public static JPanel createDemoPanel(String x, String xTitle) {
        JFreeChart localJFreeChart = createChart(createDataset(x), xTitle);
        return new ChartPanel(localJFreeChart);
    }

    private static CategoryDataset createDataset(String x) {
        DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();
        String sql = "SELECT `so_pe_edetalle`.`TLV`,     `cc_periodo_financiero`.`Nbre` AS Periodo  ,DATE_FORMAT(`cc_periodo_financiero`.`FechaI`,'%Y') AS Fecha FROM `so_pe_edetalle` INNER JOIN  `so_pe_encabezado`   ON (`so_pe_edetalle`.`Id_PEncabezado` = `so_pe_encabezado`.`Id`)     INNER JOIN  `cc_periodo_financiero`   ON (`so_pe_encabezado`.`Id_PeriodoF` = `cc_periodo_financiero`.`Id`) WHERE (`so_pe_edetalle`.`Id_Seg_Agente` ='" + x + "' AND `so_pe_edetalle`.`TLV`<>0) ORDER BY DATE_FORMAT(`cc_periodo_financiero`.`FechaI`,'%Y-%m') ASC;";
        ConsultasMySQL xctt = new ConsultasMySQL();
        ResultSet xrs = xctt.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    localDefaultCategoryDataset.addValue(xrs.getDouble("TLV"), "TLV", xrs.getString("Periodo"));
                }
            }
            xrs.close();
            xctt.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficaAgenteSEG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return localDefaultCategoryDataset;
    }

    private static JFreeChart createChart(CategoryDataset paramCategoryDataset, String xTitle) {
        JFreeChart localJFreeChart = ChartFactory.createLineChart(xTitle, "Periodo", "", paramCategoryDataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot localCategoryPlot = localJFreeChart.getPlot();
        NumberAxis localNumberAxis = localCategoryPlot.getRangeAxis();
        localNumberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer localLineAndShapeRenderer = localCategoryPlot.getRenderer();
        localLineAndShapeRenderer.setSeriesShapesVisible(0, true);
        localLineAndShapeRenderer.setSeriesShapesVisible(1, false);
        localLineAndShapeRenderer.setSeriesShapesVisible(2, true);
        localLineAndShapeRenderer.setSeriesLinesVisible(2, false);
        localLineAndShapeRenderer.setSeriesShape(2, ShapeUtilities.createDiamond(4.0f));
        localLineAndShapeRenderer.setDrawOutlines(true);
        localLineAndShapeRenderer.setUseFillPaint(true);
        localLineAndShapeRenderer.setBaseFillPaint(Color.white);
        return localJFreeChart;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloSeg() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: Historia.JPGraficaAgenteSEG.3
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTSeg.setModel(this.xmodelo);
        this.JTSeg.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTSeg.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTSeg.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTSeg.getColumnModel().getColumn(1).setPreferredWidth(250);
    }

    private void mBuscaSEG() {
        mModeloSeg();
        String sql = "SELECT ingreso.`Id` , ingreso.`Id_Usuario`  , ingreso.`SO_SEG`, so_tipo_segmento.`Id` AS IdSEG FROM `ingreso` \n INNER JOIN `so_tipo_segmento`  ON (`ingreso`.`SO_SEG` = `so_tipo_segmento`.`Nbre`)\nWHERE (ingreso.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND ingreso.SO_SEG<>'' AND ingreso.SO_SEG <> 'NO APLICA') GROUP BY ingreso.SO_SEG;";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("IdSEG"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("SO_SEG"), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficaAgenteSEG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle() {
        this.xmodeloAg = new DefaultTableModel(new Object[0], new String[]{"Id", "Agente", "Valor", "UMed"}) { // from class: Historia.JPGraficaAgenteSEG.4
            Class[] types = {Integer.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAgente.setModel(this.xmodeloAg);
        this.JTAgente.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTAgente.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTAgente.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTAgente.getColumnModel().getColumn(1).setPreferredWidth(180);
        this.JTAgente.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTAgente.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTAgente.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTAgente.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTAgente.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTAgente.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mBuscaAgentes() {
        mCrearModeloDetalle();
        String sql = "SELECT `so_tipo_seg_tipogente`.`Id`, `so_tipo_agentes`.`Nbre`, so_tipo_agentes.UnidadMedida FROM `so_tipo_seg_tipogente`\n    INNER JOIN `so_tipo_agentes`  ON (`so_tipo_seg_tipogente`.`Id_TipoAgente` = `so_tipo_agentes`.`Id`) WHERE (`so_tipo_seg_tipogente`.`Id_Seg` ='" + this.xmodelo.getValueAt(this.JTSeg.getSelectedRow(), 0) + "'\n    AND `so_tipo_seg_tipogente`.`Estado` =1) ORDER BY `so_tipo_agentes`.`Nbre` asc";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodeloAg.addRow(this.xdatos);
                    this.xmodeloAg.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloAg.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloAg.setValueAt(Integer.valueOf(mExisteValorAgente(xrs.getInt(1))), n, 2);
                    this.JTAgente.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodeloAg.setValueAt(xrs.getString("UnidadMedida"), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficaAgenteSEG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int mExisteValorAgente(int xA) {
        int x = 0;
        String sql = "SELECT `so_pe_edetalle`.`TLV`,     `cc_periodo_financiero`.`Nbre` AS Periodo  ,DATE_FORMAT(`cc_periodo_financiero`.`FechaI`,'%Y') AS Fecha FROM `so_pe_edetalle` INNER JOIN  `so_pe_encabezado`   ON (`so_pe_edetalle`.`Id_PEncabezado` = `so_pe_encabezado`.`Id`)     INNER JOIN  `cc_periodo_financiero`   ON (`so_pe_encabezado`.`Id_PeriodoF` = `cc_periodo_financiero`.`Id`) WHERE (`so_pe_edetalle`.`Id_Seg_Agente` ='" + xA + "' AND `so_pe_edetalle`.`TLV`<>0) ORDER BY DATE_FORMAT(`cc_periodo_financiero`.`FechaI`,'%Y-%m') ASC;";
        ConsultasMySQL xctt = new ConsultasMySQL();
        ResultSet xrs = xctt.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                if (xrs.next()) {
                    x = 1;
                }
            }
            xrs.close();
            xctt.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficaAgenteSEG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return x;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficaAgenteSEG$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xestado = Long.valueOf(table.getValueAt(row, 2).toString()).longValue();
            if (xestado == 1) {
                cell.setBackground(new Color(51, 102, 255));
                cell.setForeground(Color.WHITE);
                table.setSelectionForeground(Color.YELLOW);
            } else if (xestado == 0) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
                table.setSelectionForeground(Color.RED);
            }
            return cell;
        }
    }
}
