package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Audiometria.class */
public class JPSo_Audiometria extends JPanel {
    public ResultSet rsi;
    public String sql;
    public String xnombre;
    public String xid;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloh;
    private Object[] xdatos;
    private clasesHistoriaCE xclase;
    private long xoido;
    private long xatenciong;
    private String[] xidResultado;
    private JButton JBActualizar;
    private ButtonGroup JBAutoscopia;
    private ButtonGroup JBElementos;
    private ButtonGroup JBGTipoIncapacidad;
    private JButton JBGrabaInterp;
    private JButton JBGrabarRes;
    private ButtonGroup JBRetest;
    private JComboBox JCBoshaOD;
    private JComboBox JCBoshaOI;
    private JComboBox JCGatODC1;
    private JComboBox JCGatODC2;
    private JComboBox JCGatODC3;
    private JComboBox JCGatODC4;
    private JComboBox JCGatODC5;
    private JComboBox JCGatOIC1;
    private JComboBox JCGatOIC2;
    private JComboBox JCGatOIC3;
    private JComboBox JCGatOIC4;
    private JComboBox JCGatOIC5;
    private JCheckBox JCHBLineaB;
    private JCheckBox JCHBPromedio;
    private JComboBox JCResultado;
    private JFormattedTextField JFTFPromedioODer;
    private JFormattedTextField JFTFPromedioOIzq;
    private JPanel JPDatosAudio;
    private JPanel JPHistorico;
    private JPanel JPInformacion;
    private JPanel JPInterpretacion;
    private JSpinner JPODer1000;
    private JSpinner JPODer2000;
    private JSpinner JPODer3000;
    private JSpinner JPODer4000;
    private JSpinner JPODer500;
    private JSpinner JPODer6000;
    private JSpinner JPODer8000;
    private JSpinner JPOIzq1000;
    private JSpinner JPOIzq2000;
    private JSpinner JPOIzq3000;
    private JSpinner JPOIzq4000;
    private JSpinner JPOIzq500;
    private JSpinner JPOIzq6000;
    private JSpinner JPOIzq8000;
    private JRadioButton JRBCopa;
    private JRadioButton JRBInsercion;
    private JRadioButton JRBNo;
    private JRadioButton JRBNo_Autoscopia;
    private JRadioButton JRBNo_Retest;
    private JRadioButton JRBOtro;
    private JRadioButton JRBSi_Autoscopia;
    private JRadioButton JRBSi_Retest;
    private JScrollPane JSPHistorico;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionAudio;
    public JTable JTDetalleHistorico;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    Runtime obj = Runtime.getRuntime();
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private double xpromedioD = 0.0d;
    private double xpromedioI = 0.0d;
    private long xelemento = 0;
    private long xidatencion = 0;
    private long xidAdiometria = 0;
    private long xautoscopia = 0;
    private long xretest = 0;
    private long xtformula = 0;
    private long xlineabase = 0;

    public JPSo_Audiometria() {
        initComponents();
        this.xidResultado = this.xconsultasbd.llenarCombo("SELECT `Id`, `Nbre` FROM `h_so_resultado` WHERE (`Estado` =1 AND TipoExamen=2) ORDER BY `Nbre` ASC;", this.xidResultado, this.JCResultado);
        this.JCResultado.setSelectedIndex(-1);
        this.JFTFPromedioODer.setValue(0);
        this.JFTFPromedioOIzq.setValue(0);
        mCargarDatosTablaHistorico();
        mBuscarAdiometriaAtencion();
    }

    private double mCalcularPromedio(double x1, double x2, double x3, long oido) {
        this.xoido = oido;
        if (this.xoido == 0) {
            this.xpromedioD = ((x1 + x2) + x3) / 3.0d;
            return this.xpromedioD;
        }
        this.xpromedioI = ((x1 + x2) + x3) / 3.0d;
        return this.xpromedioI;
    }

    private double mCalcularPromedio2(double x1, double x2, double x3, double x4, long oido) {
        this.xoido = oido;
        if (this.xoido == 0) {
            this.xpromedioD = (((x1 + x2) + x3) + x4) / 4.0d;
            return this.xpromedioD;
        }
        this.xpromedioI = (((x1 + x2) + x3) + x4) / 4.0d;
        return this.xpromedioI;
    }

    public void mImprimir(String idAtencion) {
        String[][] mparametros = new String[3][2];
        if (idAtencion.equals("0")) {
            mparametros[0][0] = "ID_AUDIOMETRIA";
            mparametros[0][1] = this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 16).toString();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria", mparametros);
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = idAtencion;
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_Audiometria1", mparametros);
                return;
            }
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria1", mparametros);
            return;
        }
        mparametros[0][0] = "ID_AUDIOMETRIA";
        mparametros[0][1] = this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 16).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = idAtencion;
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_Audiometria1", mparametros);
            return;
        }
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria1", mparametros);
    }

    /* JADX WARN: Type inference failed for: r3v257, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoIncapacidad = new ButtonGroup();
        this.JBElementos = new ButtonGroup();
        this.JBAutoscopia = new ButtonGroup();
        this.JBRetest = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JPDatosAudio = new JPanel();
        this.JPODer500 = new JSpinner();
        this.JPODer1000 = new JSpinner();
        this.JPODer2000 = new JSpinner();
        this.JPODer3000 = new JSpinner();
        this.JPODer4000 = new JSpinner();
        this.JPODer6000 = new JSpinner();
        this.JPODer8000 = new JSpinner();
        this.JPOIzq500 = new JSpinner();
        this.JPOIzq1000 = new JSpinner();
        this.JPOIzq2000 = new JSpinner();
        this.JPOIzq3000 = new JSpinner();
        this.JPOIzq4000 = new JSpinner();
        this.JPOIzq6000 = new JSpinner();
        this.JPOIzq8000 = new JSpinner();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.JFTFPromedioODer = new JFormattedTextField();
        this.JFTFPromedioOIzq = new JFormattedTextField();
        this.jLabel10 = new JLabel();
        this.JBGrabarRes = new JButton();
        this.jLabel11 = new JLabel();
        this.JRBNo = new JRadioButton();
        this.JRBInsercion = new JRadioButton();
        this.JRBCopa = new JRadioButton();
        this.JRBOtro = new JRadioButton();
        this.jLabel12 = new JLabel();
        this.JRBSi_Autoscopia = new JRadioButton();
        this.JRBNo_Autoscopia = new JRadioButton();
        this.jLabel13 = new JLabel();
        this.JRBSi_Retest = new JRadioButton();
        this.JRBNo_Retest = new JRadioButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacionAudio = new JTextArea();
        this.JCHBPromedio = new JCheckBox();
        this.JCHBLineaB = new JCheckBox();
        this.JBActualizar = new JButton();
        this.JPInformacion = new JPanel();
        this.JCBoshaOD = new JComboBox();
        this.JCBoshaOI = new JComboBox();
        this.JCGatODC1 = new JComboBox();
        this.JCGatOIC1 = new JComboBox();
        this.JCGatODC2 = new JComboBox();
        this.JCGatOIC2 = new JComboBox();
        this.JCGatOIC3 = new JComboBox();
        this.JCGatODC3 = new JComboBox();
        this.JCGatODC4 = new JComboBox();
        this.JCGatOIC4 = new JComboBox();
        this.JCGatODC5 = new JComboBox();
        this.JCGatOIC5 = new JComboBox();
        this.JPInterpretacion = new JPanel();
        this.JCResultado = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBGrabaInterp = new JButton();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "EXAMEN DE AUDIOMETRÍA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jifaudiometria_so");
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPDatosAudio.setBorder(BorderFactory.createTitledBorder(""));
        this.JPODer500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer500.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.1
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPODer500StateChanged(evt);
            }
        });
        this.JPODer1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer1000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.2
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPODer1000StateChanged(evt);
            }
        });
        this.JPODer2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer2000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.3
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPODer2000StateChanged(evt);
            }
        });
        this.JPODer3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer3000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.4
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPODer3000StateChanged(evt);
            }
        });
        this.JPODer4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer4000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.5
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPODer4000StateChanged(evt);
            }
        });
        this.JPODer6000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer6000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.6
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPODer6000StateChanged(evt);
            }
        });
        this.JPODer8000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq500.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.7
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPOIzq500StateChanged(evt);
            }
        });
        this.JPOIzq1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq1000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.8
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPOIzq1000StateChanged(evt);
            }
        });
        this.JPOIzq2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq2000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.9
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPOIzq2000StateChanged(evt);
            }
        });
        this.JPOIzq3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq3000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.10
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPOIzq3000StateChanged(evt);
            }
        });
        this.JPOIzq4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq4000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.11
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPOIzq4000StateChanged(evt);
            }
        });
        this.JPOIzq6000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq6000.addChangeListener(new ChangeListener() { // from class: Historia.JPSo_Audiometria.12
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria.this.JPOIzq6000StateChanged(evt);
            }
        });
        this.JPOIzq8000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Oido Derecho");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Oido Izquierdo");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 255));
        this.jLabel3.setText("500");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 0, 255));
        this.jLabel4.setText("1000");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 255));
        this.jLabel5.setText("2000");
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 0, 255));
        this.jLabel6.setText("3000");
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 255));
        this.jLabel7.setText("4000");
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(new Color(0, 0, 255));
        this.jLabel8.setText("6000");
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setForeground(new Color(0, 0, 255));
        this.jLabel9.setText("8000");
        this.JFTFPromedioODer.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFPromedioODer.setHorizontalAlignment(4);
        this.JFTFPromedioODer.setText("0");
        this.JFTFPromedioODer.setFont(new Font("Arial", 1, 12));
        this.JFTFPromedioOIzq.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFPromedioOIzq.setHorizontalAlignment(4);
        this.JFTFPromedioOIzq.setText("0");
        this.JFTFPromedioOIzq.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(0, 0, 255));
        this.jLabel10.setText("Promedio");
        this.JBGrabarRes.setFont(new Font("Arial", 1, 12));
        this.JBGrabarRes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarRes.setText("Grabar");
        this.JBGrabarRes.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.13
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JBGrabarResActionPerformed(evt);
            }
        });
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("Utiliza elementos de protección auditiva? ");
        this.JBElementos.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 11));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.14
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JRBNoActionPerformed(evt);
            }
        });
        this.JBElementos.add(this.JRBInsercion);
        this.JRBInsercion.setFont(new Font("Arial", 1, 11));
        this.JRBInsercion.setText("Inserción");
        this.JRBInsercion.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.15
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JRBInsercionActionPerformed(evt);
            }
        });
        this.JBElementos.add(this.JRBCopa);
        this.JRBCopa.setFont(new Font("Arial", 1, 11));
        this.JRBCopa.setText("Copa");
        this.JRBCopa.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.16
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JRBCopaActionPerformed(evt);
            }
        });
        this.JBElementos.add(this.JRBOtro);
        this.JRBOtro.setFont(new Font("Arial", 1, 11));
        this.JRBOtro.setText("Otro");
        this.JRBOtro.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.17
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JRBOtroActionPerformed(evt);
            }
        });
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("En la otoscopia se observa tapon auditivo:");
        this.JBAutoscopia.add(this.JRBSi_Autoscopia);
        this.JRBSi_Autoscopia.setFont(new Font("Arial", 1, 11));
        this.JRBSi_Autoscopia.setText("Si");
        this.JRBSi_Autoscopia.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.18
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JRBSi_AutoscopiaActionPerformed(evt);
            }
        });
        this.JBAutoscopia.add(this.JRBNo_Autoscopia);
        this.JRBNo_Autoscopia.setFont(new Font("Arial", 1, 11));
        this.JRBNo_Autoscopia.setSelected(true);
        this.JRBNo_Autoscopia.setText("No");
        this.JRBNo_Autoscopia.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.19
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JRBNo_AutoscopiaActionPerformed(evt);
            }
        });
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setText("Retest?");
        this.JBRetest.add(this.JRBSi_Retest);
        this.JRBSi_Retest.setFont(new Font("Arial", 1, 11));
        this.JRBSi_Retest.setText("Si");
        this.JRBSi_Retest.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.20
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JRBSi_RetestActionPerformed(evt);
            }
        });
        this.JBRetest.add(this.JRBNo_Retest);
        this.JRBNo_Retest.setFont(new Font("Arial", 1, 11));
        this.JRBNo_Retest.setSelected(true);
        this.JRBNo_Retest.setText("No");
        this.JRBNo_Retest.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.21
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JRBNo_RetestActionPerformed(evt);
            }
        });
        this.JTAObservacionAudio.setColumns(1);
        this.JTAObservacionAudio.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionAudio.setLineWrap(true);
        this.JTAObservacionAudio.setRows(1);
        this.JTAObservacionAudio.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTAObservacionAudio);
        this.JCHBPromedio.setFont(new Font("Arial", 1, 11));
        this.JCHBPromedio.setText("Promedio (5,1,2,3)?");
        this.JCHBPromedio.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.22
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JCHBPromedioActionPerformed(evt);
            }
        });
        this.JCHBLineaB.setFont(new Font("Arial", 1, 11));
        this.JCHBLineaB.setText("Línea base?");
        this.JCHBLineaB.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.23
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JCHBLineaBActionPerformed(evt);
            }
        });
        this.JBActualizar.setFont(new Font("Arial", 1, 12));
        this.JBActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBActualizar.setText("Actualizar");
        this.JBActualizar.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.24
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JBActualizarActionPerformed(evt);
            }
        });
        GroupLayout JPDatosAudioLayout = new GroupLayout(this.JPDatosAudio);
        this.JPDatosAudio.setLayout(JPDatosAudioLayout);
        JPDatosAudioLayout.setHorizontalGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1)).addGap(10, 10, 10).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPODer500, -2, 55, -2).addGap(7, 7, 7)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel3).addGap(27, 27, 27))).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, -2, 43, -2).addComponent(this.JPODer1000, -2, 55, -2)).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPOIzq2000, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPOIzq3000, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPOIzq4000, -2, 55, -2)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPODer2000, -2, 55, -2).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPODer3000, -2, 55, -2).addComponent(this.jLabel6, -2, 43, -2)).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7, -2, 43, -2).addComponent(this.JPODer4000, -2, 55, -2)))).addComponent(this.jLabel5, -2, 43, -2)).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel8, -2, 43, -2).addGap(18, 18, 18).addComponent(this.jLabel9, -2, 43, -2)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPODer6000, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPODer8000, -2, 55, -2)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPOIzq6000, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPOIzq8000, -2, 55, -2)))).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPOIzq500, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPOIzq1000, -2, 55, -2))).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTFPromedioOIzq, -2, 56, -2).addComponent(this.jLabel10, -2, 71, -2).addComponent(this.JFTFPromedioODer, -2, 56, -2))).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel12, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi_Autoscopia).addGap(18, 18, 18).addComponent(this.JRBNo_Autoscopia)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel11).addGap(18, 18, 18).addComponent(this.JRBNo).addGap(18, 18, 18).addComponent(this.JRBInsercion)).addGroup(JPDatosAudioLayout.createSequentialGroup().addGap(401, 401, 401).addComponent(this.JRBCopa).addGap(9, 9, 9).addComponent(this.JRBOtro)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel13, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi_Retest).addGap(18, 18, 18).addComponent(this.JRBNo_Retest).addGap(26, 26, 26).addComponent(this.JCHBLineaB).addGap(83, 83, 83).addComponent(this.JCHBPromedio))).addGap(9, 9, 9).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane2, -1, 180, 32767).addComponent(this.JBActualizar, -1, -1, 32767).addComponent(this.JBGrabarRes, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPDatosAudioLayout.setVerticalGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.JRBSi_Retest).addComponent(this.JRBNo_Retest).addComponent(this.JCHBLineaB)).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHBPromedio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo).addComponent(this.JRBInsercion).addComponent(this.JRBCopa).addComponent(this.JRBOtro))).addGap(8, 8, 8).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jLabel7).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel10))).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JBGrabarRes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBActualizar))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPODer500, -2, 31, -2).addComponent(this.JPODer1000, -2, 31, -2).addComponent(this.JPODer2000, -2, 31, -2).addComponent(this.JPODer3000, -2, 31, -2).addComponent(this.JPODer4000, -2, 31, -2).addComponent(this.JPODer6000, -2, 31, -2).addComponent(this.JPODer8000, -2, 31, -2).addComponent(this.jLabel1).addComponent(this.JFTFPromedioODer, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPOIzq500, -2, 31, -2).addComponent(this.JPOIzq1000, -2, 31, -2).addComponent(this.jLabel2).addComponent(this.JFTFPromedioOIzq, -2, 28, -2).addComponent(this.JPOIzq2000, -2, 31, -2)).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPOIzq4000, -2, 31, -2).addComponent(this.JPOIzq3000, -2, 31, -2).addComponent(this.JPOIzq6000, -2, 31, -2).addComponent(this.JPOIzq8000, -2, 31, -2))).addGap(6, 6, 6).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.JRBSi_Autoscopia).addComponent(this.JRBNo_Autoscopia)).addGap(0, 0, 32767)).addComponent(this.jScrollPane2)).addContainerGap()));
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder(""));
        this.JCBoshaOD.setFont(new Font("Arial", 1, 12));
        this.JCBoshaOD.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO PARA ESTUDIO"}));
        this.JCBoshaOD.setBorder(BorderFactory.createTitledBorder((Border) null, "OSHA 25 LOSS OD", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBoshaOI.setFont(new Font("Arial", 1, 12));
        this.JCBoshaOI.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO PARA ESTUDIO"}));
        this.JCBoshaOI.setBorder(BorderFactory.createTitledBorder((Border) null, "OSHA 25 LOSS OI", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatODC1.setFont(new Font("Arial", 1, 12));
        this.JCGatODC1.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatODC1.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OD C1", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatOIC1.setFont(new Font("Arial", 1, 12));
        this.JCGatOIC1.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatOIC1.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OI C1", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatODC2.setFont(new Font("Arial", 1, 12));
        this.JCGatODC2.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatODC2.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OD C2", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatOIC2.setFont(new Font("Arial", 1, 12));
        this.JCGatOIC2.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatOIC2.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OI C2", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatOIC3.setFont(new Font("Arial", 1, 12));
        this.JCGatOIC3.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatOIC3.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OI C3", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatODC3.setFont(new Font("Arial", 1, 12));
        this.JCGatODC3.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatODC3.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OD C3", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatODC4.setFont(new Font("Arial", 1, 12));
        this.JCGatODC4.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatODC4.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OD C4", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatOIC4.setFont(new Font("Arial", 1, 12));
        this.JCGatOIC4.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatOIC4.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OI C4", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatODC5.setFont(new Font("Arial", 1, 12));
        this.JCGatODC5.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatODC5.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OD C5", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCGatOIC5.setFont(new Font("Arial", 1, 12));
        this.JCGatOIC5.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "CASO DE REMISION"}));
        this.JCGatOIC5.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIF GATISO OI C5", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBoshaOD, -2, 193, -2).addComponent(this.JCBoshaOI, -2, 193, -2).addComponent(this.JCGatODC1, -2, 193, -2).addComponent(this.JCGatOIC1, -2, 193, -2)).addGap(84, 84, 84).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCGatODC2, -2, 193, -2).addComponent(this.JCGatOIC2, -2, 193, -2).addComponent(this.JCGatOIC3, -2, 193, -2).addComponent(this.JCGatODC3, -2, 193, -2)).addGap(62, 62, 62).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCGatOIC5, -2, 193, -2).addComponent(this.JCGatODC5, -2, 193, -2).addComponent(this.JCGatOIC4, -2, 193, -2).addComponent(this.JCGatODC4, -2, 193, -2)).addContainerGap(-1, 32767)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBoshaOD, -2, 43, -2).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCGatODC2, -2, -1, -2).addComponent(this.JCGatODC4, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBoshaOI, -2, -1, -2).addComponent(this.JCGatOIC2, -2, -1, -2).addComponent(this.JCGatOIC4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCGatODC1, -2, -1, -2).addComponent(this.JCGatOIC3, -2, -1, -2).addComponent(this.JCGatODC5, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCGatOIC1, -2, -1, -2).addComponent(this.JCGatODC3, -2, -1, -2).addComponent(this.JCGatOIC5, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JPInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INTERPRETACIÓN MÉDICA", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCResultado.setFont(new Font("Arial", 1, 12));
        this.JCResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JBGrabaInterp.setFont(new Font("Arial", 1, 14));
        this.JBGrabaInterp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabaInterp.setText("Grabar");
        this.JBGrabaInterp.addActionListener(new ActionListener() { // from class: Historia.JPSo_Audiometria.25
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria.this.JBGrabaInterpActionPerformed(evt);
            }
        });
        GroupLayout JPInterpretacionLayout = new GroupLayout(this.JPInterpretacion);
        this.JPInterpretacion.setLayout(JPInterpretacionLayout);
        JPInterpretacionLayout.setHorizontalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCResultado, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, 32767).addComponent(this.jScrollPane1, -2, 333, -2).addGap(41, 41, 41).addComponent(this.JBGrabaInterp, -2, 149, -2).addGap(31, 31, 31)));
        JPInterpretacionLayout.setVerticalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInterpretacionLayout.createSequentialGroup().addContainerGap(16, 32767).addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCResultado, -2, -1, -2).addComponent(this.jScrollPane1).addComponent(this.JBGrabaInterp, -2, 62, -2)).addContainerGap()));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPDatosAudio, -1, -1, 32767).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JPInterpretacion, -1, -1, 32767)).addContainerGap(22, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosAudio, -2, 199, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPInterpretacion, -2, -1, -2).addContainerGap(44, 32767)));
        this.jTabbedPane1.addTab("DATOS", this.jPanel1);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Audiometria.26
            public void mouseClicked(MouseEvent evt) {
                JPSo_Audiometria.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 816, -2).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 559, -2).addContainerGap()));
        this.jTabbedPane1.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jTabbedPane1).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mGenerarGrafico();
            mImprimir(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPODer3000StateChanged(ChangeEvent evt) {
        if (this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioODer.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPODer500.getValue().toString()), Integer.parseInt(this.JPODer1000.getValue().toString()), Integer.parseInt(this.JPODer2000.getValue().toString()), Integer.parseInt(this.JPODer3000.getValue().toString()), 0L)));
        } else {
            this.JFTFPromedioODer.setValue(Double.valueOf(mCalcularPromedio(Integer.parseInt(this.JPODer2000.getValue().toString()), Integer.parseInt(this.JPODer3000.getValue().toString()), Integer.parseInt(this.JPODer4000.getValue().toString()), 0L)));
        }
        if (Double.parseDouble(this.JFTFPromedioODer.getValue().toString()) > 25.0d) {
            this.JCBoshaOD.setSelectedItem("CASO PARA ESTUDIO");
        } else {
            this.JCBoshaOD.setSelectedItem("NORMAL");
        }
        mVariableC3OD(this.JCGatODC3);
        mVariableC3OI(this.JCGatOIC3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPODer4000StateChanged(ChangeEvent evt) {
        if (!this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioODer.setValue(Double.valueOf(mCalcularPromedio(Integer.parseInt(this.JPODer2000.getValue().toString()), Integer.parseInt(this.JPODer3000.getValue().toString()), Integer.parseInt(this.JPODer4000.getValue().toString()), 0L)));
        }
        if (Double.parseDouble(this.JFTFPromedioODer.getValue().toString()) > 25.0d) {
            this.JCBoshaOD.setSelectedItem("CASO PARA ESTUDIO");
        } else {
            this.JCBoshaOD.setSelectedItem("NORMAL");
        }
        mVariableC3OD(this.JCGatODC3);
        mVariableC3OI(this.JCGatOIC3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPODer6000StateChanged(ChangeEvent evt) {
        mVariableC3OD(this.JCGatODC3);
        mVariableC3OI(this.JCGatOIC3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPOIzq3000StateChanged(ChangeEvent evt) {
        if (this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioOIzq.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPOIzq500.getValue().toString()), Integer.parseInt(this.JPOIzq1000.getValue().toString()), Integer.parseInt(this.JPOIzq2000.getValue().toString()), Integer.parseInt(this.JPOIzq3000.getValue().toString()), 1L)));
        } else {
            this.JFTFPromedioOIzq.setValue(Double.valueOf(mCalcularPromedio(Integer.parseInt(this.JPOIzq2000.getValue().toString()), Integer.parseInt(this.JPOIzq3000.getValue().toString()), Integer.parseInt(this.JPOIzq4000.getValue().toString()), 1L)));
        }
        if (Double.parseDouble(this.JFTFPromedioOIzq.getValue().toString()) > 25.0d) {
            this.JCBoshaOI.setSelectedItem("CASO PARA ESTUDIO");
        } else {
            this.JCBoshaOI.setSelectedItem("NORMAL");
        }
        mVariableC3OI(this.JCGatOIC3);
        mVariableC3OD(this.JCGatODC3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPOIzq4000StateChanged(ChangeEvent evt) {
        if (!this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioOIzq.setValue(Double.valueOf(mCalcularPromedio(Integer.parseInt(this.JPOIzq2000.getValue().toString()), Integer.parseInt(this.JPOIzq3000.getValue().toString()), Integer.parseInt(this.JPOIzq4000.getValue().toString()), 1L)));
        }
        if (Double.parseDouble(this.JFTFPromedioOIzq.getValue().toString()) > 25.0d) {
            this.JCBoshaOI.setSelectedItem("CASO PARA ESTUDIO");
        } else {
            this.JCBoshaOI.setSelectedItem("NORMAL");
        }
        mVariableC3OI(this.JCGatOIC3);
        mVariableC3OD(this.JCGatODC3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPOIzq6000StateChanged(ChangeEvent evt) {
        mVariableC3OI(this.JCGatOIC3);
        mVariableC3OD(this.JCGatODC3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPOIzq500StateChanged(ChangeEvent evt) {
        if (Double.parseDouble(this.JPOIzq500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq2000.getValue().toString()) >= 25.0d) {
            this.JCGatOIC1.setSelectedItem("CASO DE REMISION");
        } else {
            this.JCGatOIC1.setSelectedItem("NORMAL");
        }
        mVariableC2OI(this.JCGatOIC2);
        mVariableC2OD(this.JCGatODC2);
        if (this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioOIzq.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPOIzq500.getValue().toString()), Integer.parseInt(this.JPOIzq1000.getValue().toString()), Integer.parseInt(this.JPOIzq2000.getValue().toString()), Integer.parseInt(this.JPOIzq3000.getValue().toString()), 1L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPOIzq1000StateChanged(ChangeEvent evt) {
        if (Double.parseDouble(this.JPOIzq500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq2000.getValue().toString()) >= 25.0d) {
            this.JCGatOIC1.setSelectedItem("CASO DE REMISION");
        } else {
            this.JCGatOIC1.setSelectedItem("NORMAL");
        }
        mVariableC2OI(this.JCGatOIC2);
        mVariableC2OD(this.JCGatODC2);
        if (this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioOIzq.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPOIzq500.getValue().toString()), Integer.parseInt(this.JPOIzq1000.getValue().toString()), Integer.parseInt(this.JPOIzq2000.getValue().toString()), Integer.parseInt(this.JPOIzq3000.getValue().toString()), 1L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPOIzq2000StateChanged(ChangeEvent evt) {
        if (this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioOIzq.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPOIzq500.getValue().toString()), Integer.parseInt(this.JPOIzq1000.getValue().toString()), Integer.parseInt(this.JPOIzq2000.getValue().toString()), Integer.parseInt(this.JPOIzq3000.getValue().toString()), 1L)));
        } else {
            this.JFTFPromedioOIzq.setValue(Double.valueOf(mCalcularPromedio(Integer.parseInt(this.JPOIzq2000.getValue().toString()), Integer.parseInt(this.JPOIzq3000.getValue().toString()), Integer.parseInt(this.JPOIzq4000.getValue().toString()), 1L)));
        }
        if (Double.parseDouble(this.JPOIzq500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq2000.getValue().toString()) >= 25.0d) {
            this.JCGatOIC1.setSelectedItem("CASO DE REMISION");
        } else {
            this.JCGatOIC1.setSelectedItem("NORMAL");
        }
        if (Double.parseDouble(this.JFTFPromedioOIzq.getValue().toString()) > 25.0d) {
            this.JCBoshaOI.setSelectedItem("CASO PARA ESTUDIO");
        } else {
            this.JCBoshaOI.setSelectedItem("NORMAL");
        }
        mVariableC2OI(this.JCGatOIC2);
        mVariableC2OD(this.JCGatODC2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPODer500StateChanged(ChangeEvent evt) {
        if (Double.parseDouble(this.JPODer500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer2000.getValue().toString()) >= 25.0d) {
            this.JCGatODC1.setSelectedItem("CASO DE REMISION");
        } else {
            this.JCGatODC1.setSelectedItem("NORMAL");
        }
        mVariableC2OD(this.JCGatODC2);
        mVariableC2OI(this.JCGatOIC2);
        if (this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioODer.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPODer500.getValue().toString()), Integer.parseInt(this.JPODer1000.getValue().toString()), Integer.parseInt(this.JPODer2000.getValue().toString()), Integer.parseInt(this.JPODer3000.getValue().toString()), 0L)));
        }
    }

    private void mVariableC2OI(JComboBox xcombo) {
        if (Double.parseDouble(this.JPOIzq500.getValue().toString()) - Double.parseDouble(this.JPODer500.getValue().toString()) >= 15.0d || Double.parseDouble(this.JPOIzq1000.getValue().toString()) - Double.parseDouble(this.JPODer1000.getValue().toString()) >= 15.0d || Double.parseDouble(this.JPOIzq2000.getValue().toString()) - Double.parseDouble(this.JPODer2000.getValue().toString()) >= 15.0d) {
            xcombo.setSelectedItem("CASO DE REMISION");
        } else {
            xcombo.setSelectedItem("NORMAL");
        }
    }

    private void mVariableC2OD(JComboBox xcombo) {
        if (Double.parseDouble(this.JPODer500.getValue().toString()) - Double.parseDouble(this.JPOIzq500.getValue().toString()) >= 15.0d || Double.parseDouble(this.JPODer1000.getValue().toString()) - Double.parseDouble(this.JPOIzq1000.getValue().toString()) >= 15.0d || Double.parseDouble(this.JPODer2000.getValue().toString()) - Double.parseDouble(this.JPOIzq2000.getValue().toString()) >= 15.0d) {
            xcombo.setSelectedItem("CASO DE REMISION");
        } else {
            xcombo.setSelectedItem("NORMAL");
        }
    }

    private void mVariableC3OI(JComboBox xcombo) {
        if (Double.parseDouble(this.JPOIzq3000.getValue().toString()) - Double.parseDouble(this.JPODer3000.getValue().toString()) >= 30.0d || Double.parseDouble(this.JPOIzq4000.getValue().toString()) - Double.parseDouble(this.JPODer4000.getValue().toString()) >= 30.0d || Double.parseDouble(this.JPOIzq6000.getValue().toString()) - Double.parseDouble(this.JPODer6000.getValue().toString()) >= 30.0d) {
            xcombo.setSelectedItem("CASO DE REMISION");
        } else {
            xcombo.setSelectedItem("NORMAL");
        }
    }

    private void mVariableC3OD(JComboBox xcombo) {
        if (Double.parseDouble(this.JPODer3000.getValue().toString()) - Double.parseDouble(this.JPOIzq3000.getValue().toString()) >= 30.0d || Double.parseDouble(this.JPODer4000.getValue().toString()) - Double.parseDouble(this.JPOIzq4000.getValue().toString()) >= 30.0d || Double.parseDouble(this.JPODer6000.getValue().toString()) - Double.parseDouble(this.JPOIzq6000.getValue().toString()) >= 30.0d) {
            xcombo.setSelectedItem("CASO DE REMISION");
        } else {
            xcombo.setSelectedItem("NORMAL");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPODer1000StateChanged(ChangeEvent evt) {
        if (Double.parseDouble(this.JPODer500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer2000.getValue().toString()) >= 25.0d) {
            this.JCGatODC1.setSelectedItem("CASO DE REMISION");
        } else {
            this.JCGatODC1.setSelectedItem("NORMAL");
        }
        mVariableC2OD(this.JCGatODC2);
        mVariableC2OI(this.JCGatOIC2);
        if (this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioODer.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPODer500.getValue().toString()), Integer.parseInt(this.JPODer1000.getValue().toString()), Integer.parseInt(this.JPODer2000.getValue().toString()), Integer.parseInt(this.JPODer3000.getValue().toString()), 0L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPODer2000StateChanged(ChangeEvent evt) {
        if (this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioODer.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPODer500.getValue().toString()), Integer.parseInt(this.JPODer1000.getValue().toString()), Integer.parseInt(this.JPODer2000.getValue().toString()), Integer.parseInt(this.JPODer3000.getValue().toString()), 0L)));
        } else {
            this.JFTFPromedioODer.setValue(Double.valueOf(mCalcularPromedio(Integer.parseInt(this.JPODer2000.getValue().toString()), Integer.parseInt(this.JPODer3000.getValue().toString()), Integer.parseInt(this.JPODer4000.getValue().toString()), 0L)));
        }
        if (Double.parseDouble(this.JFTFPromedioODer.getValue().toString()) > 25.0d) {
            this.JCBoshaOD.setSelectedItem("CASO PARA ESTUDIO");
        } else {
            this.JCBoshaOD.setSelectedItem("NORMAL");
        }
        if (Double.parseDouble(this.JPODer500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer2000.getValue().toString()) >= 25.0d) {
            this.JCGatODC1.setSelectedItem("CASO DE REMISION");
        } else {
            this.JCGatODC1.setSelectedItem("NORMAL");
        }
        mVariableC2OD(this.JCGatODC2);
        mVariableC2OI(this.JCGatOIC2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarResActionPerformed(ActionEvent evt) {
        mGuardar();
        mCargarDatosTablaHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabaInterpActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "UPDATE h_so_audiometria SET h_so_audiometria.`ResultadoM`='" + this.JCResultado.getSelectedItem() + "' , h_so_audiometria.`ObservacionM`='" + this.JTAObservacion.getText() + "', h_so_audiometria.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' WHERE (h_so_audiometria.`Id`='" + this.xidAdiometria + "')";
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() == 1) {
                Principal.clasehistoriace.mActualizarVariable_ManPower("RAudiometria", this.JCResultado.getSelectedItem().toString(), "Observacion_Aud", this.JTAObservacion.getText());
                if (!this.JCResultado.getSelectedItem().equals("NORMAL")) {
                    Principal.clasehistoriace.mActualizarAlterado_ManPower();
                }
            }
            this.JBGrabaInterp.setEnabled(true);
            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xelemento = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBInsercionActionPerformed(ActionEvent evt) {
        this.xelemento = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCopaActionPerformed(ActionEvent evt) {
        this.xelemento = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOtroActionPerformed(ActionEvent evt) {
        this.xelemento = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi_AutoscopiaActionPerformed(ActionEvent evt) {
        this.xautoscopia = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo_AutoscopiaActionPerformed(ActionEvent evt) {
        this.xautoscopia = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi_RetestActionPerformed(ActionEvent evt) {
        this.xretest = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo_RetestActionPerformed(ActionEvent evt) {
        this.xretest = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBPromedioActionPerformed(ActionEvent evt) {
        if (this.JCHBPromedio.isSelected()) {
            this.xtformula = 1L;
        } else {
            this.xtformula = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBLineaBActionPerformed(ActionEvent evt) {
        if (this.JCHBLineaB.isSelected()) {
            this.xlineabase = 1L;
        } else {
            this.xlineabase = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBActualizarActionPerformed(ActionEvent evt) {
        actualizar();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "OD500", "OD1000", "OD2000", "OD3000", "OD4000", "OD6000", "OD8000", "OI500", "OI1000", "OI2000", "OI3000", "OI4000", "OI6000", "OI8000", "IdAudio"}) { // from class: Historia.JPSo_Audiometria.27
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodeloh);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(16);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(4);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(6).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(7).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(8).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(9).setPreferredWidth(4);
        this.JTDetalleHistorico.getColumnModel().getColumn(10).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(11).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(12).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(13).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(14).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(15).setPreferredWidth(6);
        this.JTDetalleHistorico.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(16).setMaxWidth(0);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT h_so_audiometria.`Id_Atencion`, h_so_audiometria.`Fecha_R`, h_so_audiometria.`I500`  , h_so_audiometria.`I1000`  , h_so_audiometria.`I2000`  , h_so_audiometria.`I3000` , h_so_audiometria.`I4000` , h_so_audiometria.`I6000`  , h_so_audiometria.`I8000` , h_so_audiometria.`D500` , h_so_audiometria.`D1000` , h_so_audiometria.`D2000`  , h_so_audiometria.`D3000`, h_so_audiometria.`D4000` , h_so_audiometria.`D6000`  , h_so_audiometria.`D8000`, h_so_audiometria.Id  FROM `h_so_audiometria` WHERE (Id_Usuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and Estado =1) ORDER BY h_so_audiometria.`Id_Atencion` DESC";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloh.addRow(this.xdatos);
                    this.xmodeloh.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloh.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloh.setValueAt(xrs.getString(10), n, 2);
                    this.xmodeloh.setValueAt(xrs.getString(11), n, 3);
                    this.xmodeloh.setValueAt(xrs.getString(12), n, 4);
                    this.xmodeloh.setValueAt(xrs.getString(13), n, 5);
                    this.xmodeloh.setValueAt(xrs.getString(14), n, 6);
                    this.xmodeloh.setValueAt(xrs.getString(15), n, 7);
                    this.xmodeloh.setValueAt(xrs.getString(16), n, 8);
                    this.xmodeloh.setValueAt(xrs.getString(3), n, 9);
                    this.xmodeloh.setValueAt(xrs.getString(4), n, 10);
                    this.xmodeloh.setValueAt(xrs.getString(5), n, 11);
                    this.xmodeloh.setValueAt(xrs.getString(6), n, 12);
                    this.xmodeloh.setValueAt(xrs.getString(7), n, 13);
                    this.xmodeloh.setValueAt(xrs.getString(8), n, 14);
                    this.xmodeloh.setValueAt(xrs.getString(9), n, 15);
                    this.xmodeloh.setValueAt(xrs.getString(17), n, 16);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Audiometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGuardar() {
        String sql;
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (!this.xmetodo.esIPSMineros()) {
                sql = "INSERT INTO h_so_audiometria (`Id_Atencion` , `Fecha_R` , `I500`  , `I1000`  , `I2000`  , `I3000` , `I4000` , `I6000`  , `I8000` , `D500` , `D1000` , `D2000`  , `D3000`,`D4000` , `D6000`  , `D8000` , `POI` , `POD` , `COI_OSHAS` , `COD_OSHAS` , `C1_OI_GATISO`  , `C1_OD_GATISO`  , `C2_OI_GATISO` , `C2_OD_GATISO` , `C3_OI_GATISO` , `C3_OD_GATISO`  , `Id_Profesional`  , `Id_Especialidad`,Id_Usuario, ElementosAudio, Autoscopia, Retest, ObservacionAudio,TFormula, LineaBase, `UsuarioS`)values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.JPOIzq500.getValue() + "','" + this.JPOIzq1000.getValue() + "','" + this.JPOIzq2000.getValue() + "','" + this.JPOIzq3000.getValue() + "','" + this.JPOIzq4000.getValue() + "','" + this.JPOIzq6000.getValue() + "','" + this.JPOIzq8000.getValue() + "','" + this.JPODer500.getValue() + "','" + this.JPODer1000.getValue() + "','" + this.JPODer2000.getValue() + "','" + this.JPODer3000.getValue() + "','" + this.JPODer4000.getValue() + "','" + this.JPODer6000.getValue() + "','" + this.JPODer8000.getValue() + "','" + this.JFTFPromedioOIzq.getValue() + "','" + this.JFTFPromedioODer.getValue() + "','" + this.JCBoshaOI.getSelectedItem() + "','" + this.JCBoshaOD.getSelectedItem() + "','" + this.JCGatOIC1.getSelectedItem() + "','" + this.JCGatODC1.getSelectedItem() + "','" + this.JCGatOIC2.getSelectedItem() + "','" + this.JCGatODC2.getSelectedItem() + "','" + this.JCGatOIC3.getSelectedItem() + "','" + this.JCGatODC3.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xelemento + "','" + this.xautoscopia + "','" + this.xretest + "','" + this.JTAObservacionAudio.getText() + "','" + this.xtformula + "','" + this.xlineabase + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.JBGrabarRes.setEnabled(false);
            } else if (this.xidAdiometria == 0) {
                sql = "INSERT INTO h_so_audiometria (`Id_Atencion` , `Fecha_R` , `I500`  , `I1000`  , `I2000`  , `I3000` , `I4000` , `I6000`  , `I8000` , `D500` , `D1000` , `D2000`  , `D3000`,`D4000` , `D6000`  , `D8000` , `POI` , `POD` , `COI_OSHAS` , `COD_OSHAS` , `C1_OI_GATISO`  , `C1_OD_GATISO`  , `C2_OI_GATISO` , `C2_OD_GATISO` , `C3_OI_GATISO` , `C3_OD_GATISO`  , `Id_Profesional`  , `Id_Especialidad`,Id_Usuario, ElementosAudio, Autoscopia, Retest, ObservacionAudio,TFormula, LineaBase, `UsuarioS`)values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.JPOIzq500.getValue() + "','" + this.JPOIzq1000.getValue() + "','" + this.JPOIzq2000.getValue() + "','" + this.JPOIzq3000.getValue() + "','" + this.JPOIzq4000.getValue() + "','" + this.JPOIzq6000.getValue() + "','" + this.JPOIzq8000.getValue() + "','" + this.JPODer500.getValue() + "','" + this.JPODer1000.getValue() + "','" + this.JPODer2000.getValue() + "','" + this.JPODer3000.getValue() + "','" + this.JPODer4000.getValue() + "','" + this.JPODer6000.getValue() + "','" + this.JPODer8000.getValue() + "','" + this.JFTFPromedioOIzq.getValue() + "','" + this.JFTFPromedioODer.getValue() + "','" + this.JCBoshaOI.getSelectedItem() + "','" + this.JCBoshaOD.getSelectedItem() + "','" + this.JCGatOIC1.getSelectedItem() + "','" + this.JCGatODC1.getSelectedItem() + "','" + this.JCGatOIC2.getSelectedItem() + "','" + this.JCGatODC2.getSelectedItem() + "','" + this.JCGatOIC3.getSelectedItem() + "','" + this.JCGatODC3.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xelemento + "','" + this.xautoscopia + "','" + this.xretest + "','" + this.JTAObservacionAudio.getText() + "','" + this.xtformula + "','" + this.xlineabase + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            } else {
                sql = "UPDATE\n\th_so_audiometria\nSET\n\tId_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Fecha_R = '" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', I500 = '" + this.JPOIzq500.getValue() + "', I1000 = '" + this.JPOIzq1000.getValue() + "', I2000 = '" + this.JPOIzq2000.getValue() + "', I3000 = '" + this.JPOIzq3000.getValue() + "', I4000 = '" + this.JPOIzq4000.getValue() + "', I6000 = '" + this.JPOIzq6000.getValue() + "', I8000 = '" + this.JPOIzq8000.getValue() + "', D500 = '" + this.JPODer500.getValue() + "', D1000 = '" + this.JPODer1000.getValue() + "', D2000 = '" + this.JPODer2000.getValue() + "', D3000 = '" + this.JPODer3000.getValue() + "', D4000 = '" + this.JPODer4000.getValue() + "', D6000 = '" + this.JPODer6000.getValue() + "', D8000 = '" + this.JPODer8000.getValue() + "', POI = '" + this.JFTFPromedioOIzq.getValue() + "', POD = '" + this.JFTFPromedioODer.getValue() + "', COI_OSHAS = '" + this.JCBoshaOI.getSelectedItem() + "', COD_OSHAS = '" + this.JCBoshaOD.getSelectedItem() + "', C1_OI_GATISO = '" + this.JCGatOIC1.getSelectedItem() + "', C1_OD_GATISO = '" + this.JCGatODC1.getSelectedItem() + "', C2_OI_GATISO = '" + this.JCGatOIC2.getSelectedItem() + "', C2_OD_GATISO = '" + this.JCGatODC2.getSelectedItem() + "', C3_OI_GATISO = '" + this.JCGatOIC3.getSelectedItem() + "', C3_OD_GATISO = '" + this.JCGatODC3.getSelectedItem() + "', Id_Profesional = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Id_Especialidad = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', Id_Usuario = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', ElementosAudio = \t'" + this.xelemento + "', Autoscopia = '" + this.xautoscopia + "', Retest = '" + this.xretest + "', ObservacionAudio = '" + this.JTAObservacionAudio.getText() + "', TFormula = '" + this.xtformula + "', LineaBase = '" + this.xlineabase + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' \nWHERE \t\n\th_so_audiometria.`Id`='" + this.xidAdiometria + "'";
            }
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
            mCargarDatosTablaHistorico();
            if (this.JTDetalleHistorico.getRowCount() > 0) {
                this.JTDetalleHistorico.setRowSelectionInterval(0, 0);
                mGenerarGrafico();
                mImprimir(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            }
            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    private void actualizar() {
        String sql = null;
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            sql = "UPDATE \th_so_audiometria SET \tId_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Fecha_R = '" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', I500 = '" + this.JPOIzq500.getValue() + "', I1000 = '" + this.JPOIzq1000.getValue() + "', I2000 = '" + this.JPOIzq2000.getValue() + "', I3000 = '" + this.JPOIzq3000.getValue() + "', I4000 = '" + this.JPOIzq4000.getValue() + "', I6000 = '" + this.JPOIzq6000.getValue() + "', I8000 = '" + this.JPOIzq8000.getValue() + "', D500 = '" + this.JPODer500.getValue() + "', D1000 = '" + this.JPODer1000.getValue() + "', D2000 = '" + this.JPODer2000.getValue() + "', D3000 = '" + this.JPODer3000.getValue() + "', D4000 = '" + this.JPODer4000.getValue() + "', D6000 = '" + this.JPODer6000.getValue() + "', D8000 = '" + this.JPODer8000.getValue() + "', POI = '" + this.JFTFPromedioOIzq.getValue() + "', POD = '" + this.JFTFPromedioODer.getValue() + "', COI_OSHAS = '" + this.JCBoshaOI.getSelectedItem() + "', COD_OSHAS = '" + this.JCBoshaOD.getSelectedItem() + "', C1_OI_GATISO = '" + this.JCGatOIC1.getSelectedItem() + "', C1_OD_GATISO = '" + this.JCGatODC1.getSelectedItem() + "', C2_OI_GATISO = '" + this.JCGatOIC2.getSelectedItem() + "', C2_OD_GATISO = '" + this.JCGatODC2.getSelectedItem() + "', C3_OI_GATISO = '" + this.JCGatOIC3.getSelectedItem() + "', C3_OD_GATISO = '" + this.JCGatODC3.getSelectedItem() + "', Id_Profesional = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Id_Especialidad = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', Id_Usuario = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', ElementosAudio = \t'" + this.xelemento + "', Autoscopia = '" + this.xautoscopia + "', Retest = '" + this.xretest + "', ObservacionAudio = '" + this.JTAObservacionAudio.getText() + "', TFormula = '" + this.xtformula + "', LineaBase = '" + this.xlineabase + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE \t\th_so_audiometria.`Id`='" + this.xidAdiometria + "'";
        }
        System.out.println("actualizar audiometria " + sql);
        this.xconsultasbd.ejecutarSQL(sql);
        this.xconsultasbd.cerrarConexionBd();
        Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
        mCargarDatosTablaHistorico();
        if (this.JTDetalleHistorico.getRowCount() > 0) {
            this.JTDetalleHistorico.setRowSelectionInterval(0, 0);
            mGenerarGrafico();
            mImprimir(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    private void mBuscarAdiometriaAtencion() {
        try {
            String sql = "SELECT h_so_audiometria.`I500`  , h_so_audiometria.`I1000`  , h_so_audiometria.`I2000`  , h_so_audiometria.`I3000` , h_so_audiometria.`I4000` , h_so_audiometria.`I6000`  , h_so_audiometria.`I8000` , h_so_audiometria.`D500` , h_so_audiometria.`D1000` , h_so_audiometria.`D2000`  , h_so_audiometria.`D3000`, h_so_audiometria.`D4000` , h_so_audiometria.`D6000`  , h_so_audiometria.`D8000` , h_so_audiometria.`POI` , h_so_audiometria.`POD` , h_so_audiometria.`COI_OSHAS` , h_so_audiometria.`COD_OSHAS` , h_so_audiometria.`C1_OI_GATISO`  , h_so_audiometria.`C1_OD_GATISO`  , h_so_audiometria.`C2_OI_GATISO` , h_so_audiometria.`C2_OD_GATISO` , h_so_audiometria.`C3_OI_GATISO` , h_so_audiometria.`C3_OD_GATISO` , h_so_audiometria.`ResultadoM`  , h_so_audiometria.`ObservacionM`, `h_atencion`.`TipoGuardado`, h_so_audiometria.ElementosAudio, h_so_audiometria.Autoscopia, h_so_audiometria.Retest, IF(ObservacionAudio IS NULL,'',ObservacionAudio)AS ObservacionAudio, h_so_audiometria.TFormula, h_so_audiometria.Id_Atencion, h_so_audiometria.Id, h_so_audiometria.LineaBase, if(h_so_audiometria.`ResultadoM` IS NULL || h_so_audiometria.`ResultadoM`='', 0, 1) AS Grabado    FROM `h_so_audiometria` INNER JOIN `h_atencion`   ON (`h_so_audiometria`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and h_so_audiometria.Estado=1)";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                this.xid = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                xrs.first();
                if (xrs.getLong("TFormula") == 1) {
                    this.JCHBPromedio.setSelected(true);
                } else {
                    this.JCHBPromedio.setSelected(false);
                }
                this.JPOIzq500.setValue(Integer.valueOf(xrs.getInt("I500")));
                this.JPOIzq1000.setValue(Integer.valueOf(xrs.getInt("I1000")));
                this.JPOIzq2000.setValue(Integer.valueOf(xrs.getInt("I2000")));
                this.JPOIzq3000.setValue(Integer.valueOf(xrs.getInt("I3000")));
                this.JPOIzq4000.setValue(Integer.valueOf(xrs.getInt("I4000")));
                this.JPOIzq6000.setValue(Integer.valueOf(xrs.getInt("I6000")));
                this.JPOIzq8000.setValue(Integer.valueOf(xrs.getInt("I8000")));
                this.JPODer500.setValue(Integer.valueOf(xrs.getInt("D500")));
                this.JPODer1000.setValue(Integer.valueOf(xrs.getInt("D1000")));
                this.JPODer2000.setValue(Integer.valueOf(xrs.getInt("D2000")));
                this.JPODer3000.setValue(Integer.valueOf(xrs.getInt("D3000")));
                this.JPODer4000.setValue(Integer.valueOf(xrs.getInt("D4000")));
                this.JPODer6000.setValue(Integer.valueOf(xrs.getInt("D6000")));
                this.JPODer8000.setValue(Integer.valueOf(xrs.getInt("D8000")));
                this.JCBoshaOI.setSelectedItem(xrs.getString("COI_OSHAS"));
                this.JCBoshaOD.setSelectedItem(xrs.getString("COD_OSHAS"));
                this.JCGatOIC1.setSelectedItem(xrs.getString("C1_OI_GATISO"));
                this.JCGatODC1.setSelectedItem(xrs.getString("C1_OD_GATISO"));
                this.JCGatOIC2.setSelectedItem(xrs.getString("C2_OI_GATISO"));
                this.JCGatODC2.setSelectedItem(xrs.getString("C2_OD_GATISO"));
                this.JCGatOIC3.setSelectedItem(xrs.getString("C3_OI_GATISO"));
                this.JCGatODC3.setSelectedItem(xrs.getString("C3_OD_GATISO"));
                this.JCResultado.setSelectedItem(xrs.getString("ResultadoM"));
                this.JTAObservacion.setText(xrs.getString("ObservacionM"));
                this.xidatencion = xrs.getLong("Id_Atencion");
                this.xidAdiometria = xrs.getLong("Id");
                this.xatenciong = Long.parseLong(xrs.getString("TipoGuardado").toString());
                if (xrs.getInt("ElementosAudio") == 0) {
                    this.JRBNo.setSelected(true);
                } else if (xrs.getInt("ElementosAudio") == 1) {
                    this.JRBInsercion.setSelected(true);
                } else if (xrs.getInt("ElementosAudio") == 2) {
                    this.JRBCopa.setSelected(true);
                } else if (xrs.getInt("ElementosAudio") == 3) {
                    this.JRBOtro.setSelected(true);
                }
                this.JBGrabarRes.setEnabled(false);
                if (xrs.getInt("Autoscopia") == 0) {
                    this.JRBNo_Autoscopia.setSelected(true);
                } else {
                    this.JRBSi_Autoscopia.setSelected(true);
                }
                if (xrs.getInt("Retest") == 0) {
                    this.JRBNo_Retest.setSelected(true);
                } else {
                    this.JRBSi_Retest.setSelected(true);
                }
                this.JTAObservacionAudio.setText(xrs.getString("ObservacionAudio"));
                if (xrs.getLong("LineaBase") == 0) {
                    this.JCHBLineaB.setSelected(false);
                } else {
                    this.JCHBLineaB.setSelected(true);
                }
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
            } else {
                this.xid = "0";
            }
            if (this.xmetodo.esIPSMineros()) {
                if (this.xatenciong != 0) {
                    this.JBGrabarRes.setEnabled(false);
                    this.JBGrabaInterp.setEnabled(false);
                } else {
                    this.JBGrabarRes.setEnabled(true);
                    this.JBGrabaInterp.setEnabled(true);
                }
            } else if (xrs.getBoolean("Grabado")) {
                if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                    this.JBGrabaInterp.setEnabled(false);
                }
            } else {
                this.JBGrabaInterp.setEnabled(true);
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Audiometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGenerarGrafico() {
        try {
            XYDataset xydataset = xyDataset();
            XYDataset xydataseti = xyDatasetI();
            JFreeChart jfreechart = ChartFactory.createXYLineChart("Oido Derecho", "", "Resultado", xydataset, PlotOrientation.VERTICAL, true, true, false);
            JFreeChart jfreecharti = ChartFactory.createXYLineChart("Oido Izquierdo", "", "Resultado", xydataseti, PlotOrientation.VERTICAL, true, true, false);
            XYPlot xyplot = jfreechart.getPlot();
            xyplot.setBackgroundPaint(Color.lightGray);
            xyplot.setDomainGridlinePaint(Color.BLACK);
            xyplot.setRangeGridlinePaint(Color.BLACK);
            xyplot.getRenderer().setSeriesPaint(0, Color.RED);
            xyplot.getDomainAxisLocation();
            xyplot.setDomainAxisLocation(AxisLocation.TOP_OR_LEFT);
            NumberAxis rangeAxis = xyplot.getRangeAxis();
            rangeAxis.setInverted(true);
            xyplot.getRangeAxis().setRange(0.0d, 125.0d);
            XYLineAndShapeRenderer xylineandshaperenderer = xyplot.getRenderer();
            xylineandshaperenderer.setBaseShapesVisible(true);
            ChartUtilities.saveChartAsJPEG(new File(this.xmetodo.getRutaRep() + "OidoDer.jpg"), jfreechart, 450, 260);
            XYPlot xyploti = jfreecharti.getPlot();
            xyploti.setBackgroundPaint(Color.lightGray);
            xyploti.setDomainGridlinePaint(Color.BLACK);
            xyploti.setRangeGridlinePaint(Color.BLACK);
            xyploti.getRenderer().setSeriesPaint(0, Color.BLUE);
            xyploti.setDomainAxisLocation(AxisLocation.TOP_OR_LEFT);
            NumberAxis rangeAxisY = xyploti.getRangeAxis();
            rangeAxisY.setInverted(true);
            xyploti.getRangeAxis().setRange(0.0d, 125.0d);
            XYLineAndShapeRenderer xylineandshaperendereri = xyploti.getRenderer();
            xylineandshaperendereri.setBaseShapesVisible(true);
            ChartUtilities.saveChartAsJPEG(new File(this.xmetodo.getRutaRep() + "OidoIzq.jpg"), jfreecharti, 450, 260);
        } catch (IOException ex) {
            Logger.getLogger(JPSo_Audiometria.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private XYDataset xyDataset() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Oido Derecho");
        series1.add(500.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 2).toString()));
        series1.add(1000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 3).toString()));
        series1.add(2000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 4).toString()));
        series1.add(3000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 5).toString()));
        series1.add(4000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 6).toString()));
        series1.add(6000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 7).toString()));
        series1.add(8000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 8).toString()));
        xyseriescollection.addSeries(series1);
        return xyseriescollection;
    }

    private XYDataset xyDatasetI() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Oido Izquierdo");
        series1.add(500.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 9).toString()));
        series1.add(1000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 10).toString()));
        series1.add(2000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 11).toString()));
        series1.add(3000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 12).toString()));
        series1.add(4000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 13).toString()));
        series1.add(6000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 14).toString()));
        series1.add(8000.0d, Integer.parseInt(this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 15).toString()));
        xyseriescollection.addSeries(series1);
        return xyseriescollection;
    }
}
