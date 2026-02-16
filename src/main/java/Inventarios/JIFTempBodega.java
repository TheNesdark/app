package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFTempBodega.class */
public class JIFTempBodega extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xcombop;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidperiodo;
    private String[] xidmedicion;
    private String[][] xidhorario;
    private String[][] xidgenerico2;
    private claseInventario xclaseinv;
    private int xcolum;
    private JComboBox JCBHorMedicion;
    private JComboBox JCBPeriodo;
    private JComboBox JCBTipMedicion;
    private JCheckBox JCHEstado;
    private JCheckBox JCHHistorico;
    private JDateChooser JDFecha;
    private JLabel JLGrafico;
    private JLabel JLHDesde;
    private JLabel JLHHasta;
    private JPanel JPGrafico;
    private JScrollPane JSPDetalle;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private JTextField JTFValorTemp;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int cboLleno = 0;
    private boolean xestadog = false;
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JIFTempBodega(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mNuevo();
        this.JDFecha.setDate(this.xmetodos.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JCBTipMedicion = new JComboBox();
        this.JLHDesde = new JLabel();
        this.JLHHasta = new JLabel();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JCBHorMedicion = new JComboBox();
        this.JTFValorTemp = new JTextField();
        this.JDFecha = new JDateChooser();
        this.JCHHistorico = new JCheckBox();
        this.JPGrafico = new JPanel();
        this.JLGrafico = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("HORARIO MEDICIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jiftempbodega");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipMedicion.setFont(new Font("Arial", 1, 12));
        this.JCBTipMedicion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Medición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipMedicion.addItemListener(new ItemListener() { // from class: Inventarios.JIFTempBodega.1
            public void itemStateChanged(ItemEvent evt) {
                JIFTempBodega.this.JCBTipMedicionItemStateChanged(evt);
            }
        });
        this.JLHDesde.setFont(new Font("Arial", 1, 12));
        this.JLHDesde.setHorizontalAlignment(0);
        this.JLHDesde.setBorder(BorderFactory.createTitledBorder((Border) null, "Temp. Desde", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLHHasta.setFont(new Font("Arial", 1, 12));
        this.JLHHasta.setHorizontalAlignment(0);
        this.JLHHasta.setBorder(BorderFactory.createTitledBorder((Border) null, "Temp. Hasta", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Inventarios.JIFTempBodega.2
            public void actionPerformed(ActionEvent evt) {
                JIFTempBodega.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE REGISTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(5);
        this.JTAObservacion.setAutoscrolls(false);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setEnabled(false);
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JCBHorMedicion.setFont(new Font("Arial", 1, 12));
        this.JCBHorMedicion.setBorder(BorderFactory.createTitledBorder((Border) null, "Horario Medición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHorMedicion.addItemListener(new ItemListener() { // from class: Inventarios.JIFTempBodega.3
            public void itemStateChanged(ItemEvent evt) {
                JIFTempBodega.this.JCBHorMedicionItemStateChanged(evt);
            }
        });
        this.JTFValorTemp.setFont(new Font("Arial", 1, 12));
        this.JTFValorTemp.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Temp.", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFValorTemp.addFocusListener(new FocusAdapter() { // from class: Inventarios.JIFTempBodega.4
            public void focusLost(FocusEvent evt) {
                JIFTempBodega.this.JTFValorTempFocusLost(evt);
            }
        });
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFecha, -2, 120, -2).addGap(51, 51, 51).addComponent(this.JCBHorMedicion, -2, 324, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFValorTemp, -2, 97, -2).addGap(36, 36, 36).addComponent(this.jScrollPane1, -2, 348, -2).addGap(35, 35, 35)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 93, 32767).addGroup(jPanel2Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBHorMedicion, -2, -1, -2).addComponent(this.JTFValorTemp))).addComponent(this.JDFecha, GroupLayout.Alignment.TRAILING, -2, 45, -2)))).addContainerGap()));
        this.JCHHistorico.setFont(new Font("Arial", 1, 12));
        this.JCHHistorico.setText("Consultar otro Mes");
        this.JCHHistorico.addActionListener(new ActionListener() { // from class: Inventarios.JIFTempBodega.5
            public void actionPerformed(ActionEvent evt) {
                JIFTempBodega.this.JCHHistoricoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 226, -2).addGap(18, 18, 18).addComponent(this.JCBTipMedicion, -2, 311, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLHDesde, -2, 116, -2).addGap(19, 19, 19).addComponent(this.JLHHasta, -2, 116, -2).addGap(81, 81, 81).addComponent(this.JCHEstado).addContainerGap()).addComponent(this.jPanel2, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHHistorico, -2, 154, -2).addComponent(this.JSPDetalle, -2, 1060, -2)).addGap(0, 0, 32767)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo).addComponent(this.JCBTipMedicion, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JLHHasta, -2, 42, -2)).addComponent(this.JLHDesde, GroupLayout.Alignment.TRAILING, -2, 42, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHHistorico).addGap(4, 4, 4).addComponent(this.JSPDetalle, -2, 128, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addGap(83, 83, 83)));
        this.jTabbedPane1.addTab("DATOS", this.jPanel1);
        this.JPGrafico.setBorder(BorderFactory.createTitledBorder((Border) null, "GRÁFICA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPGraficoLayout = new GroupLayout(this.JPGrafico);
        this.JPGrafico.setLayout(JPGraficoLayout);
        JPGraficoLayout.setHorizontalGroup(JPGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGraficoLayout.createSequentialGroup().addContainerGap().addComponent(this.JLGrafico, -1, 1049, 32767).addContainerGap()));
        JPGraficoLayout.setVerticalGroup(JPGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPGraficoLayout.createSequentialGroup().addComponent(this.JLGrafico, -1, 377, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("GRÁFICO", this.JPGrafico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 1086, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 445, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHorMedicionItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBHorMedicion.getSelectedIndex() != -1) {
            this.JLHDesde.setText("");
            this.JLHHasta.setText("");
            this.JLHDesde.setText(this.xidgenerico2[this.JCBHorMedicion.getSelectedIndex()][1]);
            this.JLHHasta.setText(this.xidgenerico2[this.JCBHorMedicion.getSelectedIndex()][2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipMedicionItemStateChanged(ItemEvent evt) {
        this.JLHDesde.setText("");
        this.JLHHasta.setText("");
        this.xlleno1 = false;
        if (this.xlleno && this.JCBTipMedicion.getSelectedIndex() != -1) {
            this.JCBHorMedicion.removeAllItems();
            String xsql = "SELECT  `i_bodegaxhorariomed`.`Id`, CONCAT(`i_jornadamedicion`.`Nbre`,' Desde ',`i_bodegaxhorariomed`.`HoraMimina`,' Hasta ',`i_bodegaxhorariomed`.`HoraMaxima`) AS Horario,`i_bodegaxhorariomed`.`TempMinima`, `i_bodegaxhorariomed`.`TempMaxima` FROM `i_bodegaxhorariomed` INNER JOIN `i_jornadamedicion` ON (`i_bodegaxhorariomed`.`Id_JornadaMed` = `i_jornadamedicion`.`Id`) WHERE (`i_bodegaxhorariomed`.`Estado` =1 AND `i_bodegaxhorariomed`.`Id_bodega` ='" + Principal.xClaseInventario.getIdBodega() + "' AND `i_bodegaxhorariomed`.`Id_tipomedicion` ='" + this.xidmedicion[this.JCBTipMedicion.getSelectedIndex()] + "')";
            this.xidgenerico2 = this.xconsulta.llenarComboyLista(xsql, this.xidgenerico2, this.JCBHorMedicion, 4);
            this.JCBHorMedicion.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
            mGenerarGrafico();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFValorTempFocusLost(FocusEvent evt) {
        if (Double.parseDouble(this.JTFValorTemp.getText().toString()) < Double.parseDouble(this.JLHDesde.getText().toString()) || Double.parseDouble(this.JTFValorTemp.getText().toString()) > Double.parseDouble(this.JLHHasta.getText().toString())) {
            JOptionPane.showInternalMessageDialog(this, "Debe digitar la Observación debido a que\n el valor no esta en el rango establecido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTAObservacion.setEnabled(true);
            this.JTAObservacion.requestFocus();
            return;
        }
        this.JTAObservacion.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHHistoricoActionPerformed(ActionEvent evt) {
        if (this.JCHHistorico.isSelected()) {
            this.JCBPeriodo.removeAllItems();
            this.xidperiodo = this.xconsulta.llenarCombo("SELECT  `Id`, CONCAT(DevuelveMes(`FechaI`),'-',DATE_FORMAT(FechaI,'%Y')) AS fecha FROM `i_periodo` WHERE (`Estado` =0)", this.xidperiodo, this.JCBPeriodo);
            this.JCBPeriodo.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.JCBTipMedicion.setSelectedIndex(-1);
            this.JCBHorMedicion.setSelectedIndex(-1);
            return;
        }
        mIniciarComponentes();
    }

    public void mGenerarGrafico() {
        XYDataset xydataset = xyDataset();
        JFreeChart jfreechart = ChartFactory.createXYLineChart(this.JCBTipMedicion.getSelectedItem() + "", "Días del Mes " + this.JCBPeriodo.getSelectedItem(), "Temp°", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.BLACK);
        xyplot.setRangeGridlinePaint(Color.BLACK);
        XYLineAndShapeRenderer xylineandshaperenderer = xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        BufferedImage bufferedImage = jfreechart.createBufferedImage(1049, 348);
        this.JLGrafico.setIcon(new ImageIcon(bufferedImage));
    }

    private XYDataset xyDataset() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            XYSeries series1 = new XYSeries(this.JTDetalle.getValueAt(i, 1).toString());
            for (int x = 2; x < 63; x++) {
                if (x % 2 == 0) {
                    series1.add(Integer.parseInt(this.JTDetalle.getColumnName(x).toString()), Integer.parseInt(this.JTDetalle.getValueAt(i, x).toString()));
                }
            }
            xyseriescollection.addSeries(series1);
        }
        return xyseriescollection;
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFValorTemp.setText("0");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        mIniciarComponentes();
        this.JTFValorTemp.requestFocus();
    }

    private boolean mValidaRango() {
        boolean xFueraRango = false;
        if (Double.parseDouble(this.JTFValorTemp.getText()) >= Double.parseDouble(this.JLHDesde.getText()) && Double.parseDouble(this.JTFValorTemp.getText()) <= Double.parseDouble(this.JLHHasta.getText())) {
            this.JTAObservacion.setText("");
            this.JTAObservacion.setEnabled(false);
            xFueraRango = false;
        } else if (this.JTAObservacion.getText().trim().isEmpty()) {
            xFueraRango = true;
        }
        return xFueraRango;
    }

    public void mGrabar() {
        String sql;
        if (this.JCBHorMedicion.getSelectedIndex() != -1) {
            if (!this.JTFValorTemp.getText().equals(0)) {
                if (!mValidaRango()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (this.JTAObservacion.isEnabled() && !this.JTAObservacion.getText().equals("")) {
                            sql = " Insert into  i_bodegaxtemperatura(`FechaMedicion`, `Id_Periodo` , `Id_BodxHorario`, `VTemperatura`,Observacion, `Estado`, `Fecha`, `UsuarioS`)  values ('" + this.xmetodos.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBHorMedicion.getSelectedIndex()][0] + "','" + this.JTFValorTemp.getText() + "','" + this.JTAObservacion.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            sql = " Insert into  i_bodegaxtemperatura(`FechaMedicion`, `Id_Periodo` , `Id_BodxHorario`, `VTemperatura`, `Estado`, `Fecha`, `UsuarioS`)  values ('" + this.xmetodos.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBHorMedicion.getSelectedIndex()][0] + "','" + this.JTFValorTemp.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        mGenerarGrafico();
                        this.JTAObservacion.setText("");
                        this.JTAObservacion.setEnabled(false);
                        this.JCBHorMedicion.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar la Observación debido a que\n el valor no esta en el rango establecido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTAObservacion.setEnabled(true);
                this.JTAObservacion.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar el valor de la Temperatura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFValorTemp.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe escoger un horario de Medición", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBHorMedicion.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Jornada", "01", "Obs", "02", "Obs", "03", "Obs", "04", "Obs", "05", "Obs", "06", "Obs", "07", "Obs", "08", "Obs", "09", "Obs", "10", "Obs", "11", "Obs", "12", "Obs", "13", "Obs", "14", "Obs", "15", "Obs", "16", "Obs", "17", "Obs", "18", "Obs", "19", "Obs", "20", "Obs", "21", "Obs", "22", "Obs", "23", "Obs", "24", "Obs", "25", "Obs", "26", "Obs", "27", "Obs", "28", "Obs", "29", "Obs", "30", "Obs", "31", "Obs"}) { // from class: Inventarios.JIFTempBodega.6
            Class[] types = {Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(45).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(45).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(47).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(47).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(49).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(49).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(51).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(51).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(51).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(52).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(53).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(53).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(53).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(54).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(55).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(55).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(55).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(56).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(57).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(57).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(57).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(58).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(59).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(59).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(59).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(60).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(61).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(61).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(61).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(62).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(63).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(63).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(63).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql2 = "SELECT `i_bodegaxhorariomed`.`Id_JornadaMed`, `i_jornadamedicion`.`Nbre` FROM `i_bodegaxhorariomed` INNER JOIN `baseserver`.`i_jornadamedicion`  ON (`i_bodegaxhorariomed`.`Id_JornadaMed` = `i_jornadamedicion`.`Id`)WHERE (`i_bodegaxhorariomed`.`Id_bodega` ='" + Principal.xClaseInventario.getIdBodega() + "') GROUP BY  `i_jornadamedicion`.`Nbre` ORDER BY `i_bodegaxhorariomed`.`Id_JornadaMed`";
            ResultSet xrs = this.xconsulta.traerRs(sql2);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    for (int i = 2; i < 63; i++) {
                        String sql = "SELECT `i_bodegaxtemperatura`.`VTemperatura`, IF(i_bodegaxtemperatura.Observacion IS NULL,'0',i_bodegaxtemperatura.Observacion) AS Observacion  FROM `i_bodegaxtemperatura` INNER JOIN `baseserver`.`i_bodegaxhorariomed`  ON (`i_bodegaxtemperatura`.`Id_BodxHorario` = `i_bodegaxhorariomed`.`Id`) INNER JOIN `i_periodo`  ON (`i_bodegaxtemperatura`.`Id_Periodo` = `i_periodo`.`Id`) WHERE (`i_bodegaxhorariomed`.`Id_bodega` ='" + Principal.xClaseInventario.getIdBodega() + "' AND `i_bodegaxtemperatura`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND `i_bodegaxhorariomed`.`Id_JornadaMed` ='" + xrs.getLong(1) + "' AND `i_bodegaxhorariomed`.`Id_tipomedicion`='" + this.xidmedicion[this.JCBTipMedicion.getSelectedIndex()] + "'  AND DATE_FORMAT(`i_bodegaxtemperatura`.`FechaMedicion`,'%Y-%m%-%d')= CONCAT(DATE_FORMAT(`i_periodo`.`FechaF`,'%Y-%m-'),'" + this.JTDetalle.getColumnName(i) + "') AND i_bodegaxhorariomed.Estado=1)";
                        ConsultasMySQL xct = new ConsultasMySQL();
                        ResultSet xrs2 = xct.traerRs(sql);
                        if (xrs2.next()) {
                            xrs2.first();
                            this.xmodelo.setValueAt(Long.valueOf(xrs2.getLong(1)), n, i);
                            this.xmodelo.setValueAt(xrs2.getString(2), n, i + 1);
                            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                            this.xcolum = i;
                        } else {
                            this.xmodelo.setValueAt(0, n, i);
                        }
                        xrs2.close();
                        xct.cerrarConexionBd();
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFTempBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xlleno = false;
        this.JCBPeriodo.removeAllItems();
        this.xidperiodo = this.xconsulta.llenarCombo("SELECT  `Id`, UPPER(IF(Nbre='',CONCAT(DevuelveMes(`FechaI`),'-',DATE_FORMAT(FechaI,'%Y')),Nbre)) AS fecha FROM `i_periodo` WHERE (`Estado` =1 and Activo=1) order by FechaF desc", this.xidperiodo, this.JCBPeriodo);
        System.err.println("periodo" + this.xconsulta);
        this.JCBPeriodo.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JCBTipMedicion.removeAllItems();
        this.xidmedicion = this.xconsulta.llenarCombo("SELECT `i_tipo_medicion`.`Id`, CONCAT(`i_tipo_medicion`.`Nbre`,' (', `i_unidadmedida`.`Nbre`,')') AS medida FROM `i_tipo_medicion`INNER JOIN `i_unidadmedida` ON (`i_tipo_medicion`.`Id_UMedida` = `i_unidadmedida`.`Id`) INNER JOIN `i_bodegaxhorariomed`  ON (`i_bodegaxhorariomed`.`Id_tipomedicion` = `i_tipo_medicion`.`Id`) WHERE (`i_bodegaxhorariomed`.`Id_bodega` ='" + Principal.xClaseInventario.getIdBodega() + "'  AND `i_bodegaxhorariomed`.`Estado` =1) GROUP BY `i_tipo_medicion`.`Nbre`", this.xidmedicion, this.JCBTipMedicion);
        this.JCBTipMedicion.setSelectedIndex(-1);
        System.err.println("medicion" + this.xconsulta);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }

    public void mImprimir() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            if (this.JCBTipMedicion.getSelectedIndex() != -1) {
                String[][] parametros = new String[4][2];
                parametros[0][0] = "ID_BODEGA";
                parametros[0][1] = Principal.xClaseInventario.getIdBodega();
                parametros[1][0] = "ID_PERIODO";
                parametros[1][1] = this.xidperiodo[this.JCBPeriodo.getSelectedIndex()];
                parametros[2][0] = "ID_TIPO_MED";
                parametros[2][1] = this.xidmedicion[this.JCBTipMedicion.getSelectedIndex()];
                parametros[3][0] = "SUBREPORT_DIR";
                parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RTemperaturaBodega", parametros);
                System.err.println("ruta" + this.xmetodos.getRutaRep());
                System.err.println("bodega" + Principal.xClaseInventario.getIdBodega());
                System.err.println("medicion" + this.xidmedicion[this.JCBTipMedicion.getSelectedIndex()]);
                System.err.println("periodo" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()]);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe escoger el tipo de Medición", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipMedicion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe escoger el Periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPeriodo.requestFocus();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFTempBodega$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xobs = Long.valueOf(table.getValueAt(row, JIFTempBodega.this.xcolum).toString()).longValue();
            if (JIFTempBodega.this.xcolum % 2 != 0) {
                if (xobs != 0) {
                    if (JIFTempBodega.this.isNumber(String.valueOf(table.getValueAt(row, JIFTempBodega.this.xcolum - 1)))) {
                        cell.setBackground(Color.BLUE);
                    }
                } else {
                    cell.setForeground(Color.WHITE);
                }
            }
            return cell;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNumber(String cadena) {
        try {
            Double.parseDouble(cadena.replace(",", ""));
            return true;
        } catch (NumberFormatException e) {
            String newCadena = cadena.replace(".", "").replace(',', '.');
            try {
                Double.parseDouble(newCadena);
                return true;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
    }
}
