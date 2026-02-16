package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.JCBRenderImagen;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.AudiometriaViaOseaEntity;
import com.genoma.plus.jpa.entities.OtoscopiaEntity;
import com.genoma.plus.jpa.entities.TestWeberEntity;
import com.genoma.plus.jpa.projection.IAudiometriaViaOsea;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IOtoscopia;
import com.genoma.plus.jpa.projection.ITestWeber;
import com.genoma.plus.jpa.service.AudiometriaViaOseaService;
import com.genoma.plus.jpa.service.OtoscopiaService;
import com.genoma.plus.jpa.service.TestWeberService;
import java.awt.Color;
import java.awt.Dimension;
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
import java.util.List;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPSo_Audiometria_nueva.class */
public class JPSo_Audiometria_nueva extends JPanel {
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
    private List<ICargarCombo> listaRespuestaPabellon;
    private List<ICargarCombo> listaRespuestaTimpano;
    private List<ICargarCombo> listaRespuestaConducto;
    private List<ICargarCombo> listaRespuestaLobulo;
    private List<IAudiometriaViaOsea> listaHitoriaAtencionViaOsea;
    private List<IOtoscopia> listaHistoriaAtencionOtostopia;
    private List<ITestWeber> listaHistoriaAtencionTestWeber;
    private JButton JBActualizar;
    private ButtonGroup JBAutoscopia;
    private ButtonGroup JBElementos;
    private ButtonGroup JBGTipoIncapacidad;
    private JButton JBGrabaInterp1;
    private JButton JBGrabarOtoscopia;
    private JButton JBGrabarRes;
    private JButton JBGrabarTestWeber;
    private JButton JBGrabarViaOsea;
    private ButtonGroup JBRetest;
    private JComboBox<String> JCBConductos;
    private JComboBox<String> JCBLobulo;
    private JComboBox<String> JCBPabellon;
    private JComboBox<String> JCBTimpano;
    private JComboBox<String> JCBWeber1000;
    private JComboBox<String> JCBWeber2000;
    private JComboBox<String> JCBWeber250;
    private JComboBox<String> JCBWeber3000;
    private JComboBox<String> JCBWeber4000;
    private JComboBox<String> JCBWeber500;
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
    private JSpinner JSPDerecho1000;
    private JSpinner JSPDerecho2000;
    private JSpinner JSPDerecho250;
    private JSpinner JSPDerecho3000;
    private JSpinner JSPDerecho4000;
    private JSpinner JSPDerecho500;
    private JScrollPane JSPHistorico;
    private JSpinner JSPIzquierdo1000;
    private JSpinner JSPIzquierdo2000;
    private JSpinner JSPIzquierdo250;
    private JSpinner JSPIzquierdo3000;
    private JSpinner JSPIzquierdo4000;
    private JSpinner JSPIzquierdo500;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionAudio;
    private JTextArea JTAObservacionOtoscopia;
    private JTextArea JTAObservacionTestWeber;
    private JTextArea JTAObservacionViaOsea;
    public JTable JTDetalleHistorico;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JTabbedPane jTabbedPane1;
    Runtime obj = Runtime.getRuntime();
    private final ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private final Metodos xmetodo = new Metodos();
    private double xpromedioD = 0.0d;
    private double xpromedioI = 0.0d;
    private long xelemento = 0;
    private long xidatencion = 0;
    private long xidAdiometria = 0;
    private long xautoscopia = 0;
    private long xretest = 0;
    private long xtformula = 0;
    private long xlineabase = 0;
    private final AudiometriaViaOseaService viaOseaService = (AudiometriaViaOseaService) Principal.contexto.getBean(AudiometriaViaOseaService.class);
    private final OtoscopiaService otoscopiaService = (OtoscopiaService) Principal.contexto.getBean(OtoscopiaService.class);
    private final TestWeberService testWeberService = (TestWeberService) Principal.contexto.getBean(TestWeberService.class);
    private AudiometriaViaOseaEntity ViaOseaEntity = new AudiometriaViaOseaEntity();
    private OtoscopiaEntity otoscopiaEntity = new OtoscopiaEntity();
    private TestWeberEntity testWeberEntity = new TestWeberEntity();
    private ImageIcon[] img = {new ImageIcon(""), new ImageIcon(getClass().getResource("/Imagenes/FD.png")), new ImageIcon(getClass().getResource("/Imagenes/FI.png")), new ImageIcon(getClass().getResource("/Imagenes/IG.png"))};
    private String[] nombre = {"", "FD", "FI", "IG"};

    public JPSo_Audiometria_nueva() {
        initComponents();
        this.xidResultado = this.xconsultasbd.llenarCombo("SELECT `Id`, `Nbre` FROM `h_so_resultado` WHERE (`Estado` =1 AND TipoExamen=2) ORDER BY `Nbre` ASC;", this.xidResultado, this.JCResultado);
        this.JCResultado.setSelectedIndex(-1);
        this.JFTFPromedioODer.setValue(0);
        this.JFTFPromedioOIzq.setValue(0);
        mCargarDatosTablaHistorico();
        mBuscarAdiometriaAtencion();
        mCargarCombo();
        mRenderCombo();
        mAtencion();
        mNuevo();
        this.JCBLobulo.setVisible(false);
    }

    private void mRenderCombo() {
        for (int i = 0; i < this.nombre.length; i++) {
            this.JCBWeber250.addItem(this.nombre[i]);
            this.JCBWeber500.addItem(this.nombre[i]);
            this.JCBWeber1000.addItem(this.nombre[i]);
            this.JCBWeber2000.addItem(this.nombre[i]);
            this.JCBWeber3000.addItem(this.nombre[i]);
            this.JCBWeber4000.addItem(this.nombre[i]);
        }
        this.JCBWeber250.setRenderer(new JCBRenderImagen(this.nombre, this.img));
        this.JCBWeber500.setRenderer(new JCBRenderImagen(this.nombre, this.img));
        this.JCBWeber1000.setRenderer(new JCBRenderImagen(this.nombre, this.img));
        this.JCBWeber2000.setRenderer(new JCBRenderImagen(this.nombre, this.img));
        this.JCBWeber3000.setRenderer(new JCBRenderImagen(this.nombre, this.img));
        this.JCBWeber4000.setRenderer(new JCBRenderImagen(this.nombre, this.img));
        this.JCBWeber250.setSelectedIndex(-1);
        this.JCBWeber500.setSelectedIndex(-1);
        this.JCBWeber1000.setSelectedIndex(-1);
        this.JCBWeber2000.setSelectedIndex(-1);
        this.JCBWeber3000.setSelectedIndex(-1);
        this.JCBWeber4000.setSelectedIndex(-1);
    }

    public void mNuevo() {
        try {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() == 1) {
                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                    this.JBGrabarViaOsea.setEnabled(true);
                    this.JBGrabarOtoscopia.setEnabled(true);
                    this.JBGrabarRes.setEnabled(false);
                    this.JBGrabarTestWeber.setEnabled(true);
                } else {
                    this.JBGrabarViaOsea.setEnabled(false);
                    this.JBGrabarOtoscopia.setEnabled(false);
                    this.JBGrabarRes.setEnabled(false);
                    this.JBGrabarTestWeber.setEnabled(false);
                }
            } else {
                this.JBGrabarViaOsea.setEnabled(true);
                this.JBGrabarOtoscopia.setEnabled(true);
                this.JBGrabarRes.setEnabled(true);
                this.JBGrabarTestWeber.setEnabled(true);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    private void mAtencion() {
        this.listaHitoriaAtencionViaOsea = this.viaOseaService.mBuscarDatosAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        for (int i = 0; i < this.listaHitoriaAtencionViaOsea.size(); i++) {
            this.JSPDerecho250.setValue(this.listaHitoriaAtencionViaOsea.get(i).getD250());
            this.JSPDerecho500.setValue(this.listaHitoriaAtencionViaOsea.get(i).getD500());
            this.JSPDerecho1000.setValue(this.listaHitoriaAtencionViaOsea.get(i).getD1000());
            this.JSPDerecho2000.setValue(this.listaHitoriaAtencionViaOsea.get(i).getD2000());
            this.JSPDerecho3000.setValue(this.listaHitoriaAtencionViaOsea.get(i).getD3000());
            this.JSPDerecho4000.setValue(this.listaHitoriaAtencionViaOsea.get(i).getD4000());
            this.JSPIzquierdo250.setValue(this.listaHitoriaAtencionViaOsea.get(i).getI250());
            this.JSPIzquierdo500.setValue(this.listaHitoriaAtencionViaOsea.get(i).getI500());
            this.JSPIzquierdo1000.setValue(this.listaHitoriaAtencionViaOsea.get(i).getI1000());
            this.JSPIzquierdo2000.setValue(this.listaHitoriaAtencionViaOsea.get(i).getI2000());
            this.JSPIzquierdo3000.setValue(this.listaHitoriaAtencionViaOsea.get(i).getI3000());
            this.JSPIzquierdo4000.setValue(this.listaHitoriaAtencionViaOsea.get(i).getI4000());
            this.JTAObservacionViaOsea.setText(this.listaHitoriaAtencionViaOsea.get(i).getObservacion());
            this.ViaOseaEntity.setId(this.listaHitoriaAtencionViaOsea.get(i).getId());
        }
        this.listaHistoriaAtencionOtostopia = this.otoscopiaService.mBuscarDatosAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        for (int i2 = 0; i2 < this.listaHistoriaAtencionOtostopia.size(); i2++) {
            this.JCBConductos.setSelectedItem(this.listaHistoriaAtencionOtostopia.get(i2).getConducto());
            this.JCBLobulo.setSelectedItem(this.listaHistoriaAtencionOtostopia.get(i2).getLobulos());
            this.JCBPabellon.setSelectedItem(this.listaHistoriaAtencionOtostopia.get(i2).getPabellon());
            this.JCBTimpano.setSelectedItem(this.listaHistoriaAtencionOtostopia.get(i2).getTimpanos());
            this.JTAObservacionOtoscopia.setText(this.listaHistoriaAtencionOtostopia.get(i2).getObservacion());
            this.otoscopiaEntity.setId(this.listaHistoriaAtencionOtostopia.get(i2).getId());
        }
        this.listaHistoriaAtencionTestWeber = this.testWeberService.mCargarAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        for (int i3 = 0; i3 < this.listaHistoriaAtencionTestWeber.size(); i3++) {
            this.JCBWeber250.setSelectedItem(this.listaHistoriaAtencionTestWeber.get(i3).getT250());
            this.JCBWeber500.setSelectedItem(this.listaHistoriaAtencionTestWeber.get(i3).getT500());
            this.JCBWeber1000.setSelectedItem(this.listaHistoriaAtencionTestWeber.get(i3).getT1000());
            this.JCBWeber2000.setSelectedItem(this.listaHistoriaAtencionTestWeber.get(i3).getT2000());
            this.JCBWeber3000.setSelectedItem(this.listaHistoriaAtencionTestWeber.get(i3).getT3000());
            this.JCBWeber4000.setSelectedItem(this.listaHistoriaAtencionTestWeber.get(i3).getT4000());
            this.JTAObservacionTestWeber.setText(this.listaHistoriaAtencionTestWeber.get(i3).getObservacion());
            this.testWeberEntity.setId(this.listaHistoriaAtencionTestWeber.get(i3).getId());
        }
    }

    private void mCargarCombo() {
        this.JCBConductos.removeAllItems();
        this.JCBLobulo.removeAllItems();
        this.JCBPabellon.removeAllItems();
        this.JCBTimpano.removeAllItems();
        this.listaRespuestaPabellon = this.otoscopiaService.mCargarCombo(1);
        for (int i = 0; i < this.listaRespuestaPabellon.size(); i++) {
            this.JCBPabellon.addItem(this.listaRespuestaPabellon.get(i).getNombre());
        }
        this.listaRespuestaTimpano = this.otoscopiaService.mCargarCombo(2);
        for (int i2 = 0; i2 < this.listaRespuestaTimpano.size(); i2++) {
            this.JCBTimpano.addItem(this.listaRespuestaTimpano.get(i2).getNombre());
        }
        this.listaRespuestaConducto = this.otoscopiaService.mCargarCombo(3);
        for (int i3 = 0; i3 < this.listaRespuestaConducto.size(); i3++) {
            this.JCBConductos.addItem(this.listaRespuestaConducto.get(i3).getNombre());
        }
        this.JCBConductos.setSelectedIndex(-1);
        this.JCBLobulo.setSelectedIndex(-1);
        this.JCBPabellon.setSelectedIndex(-1);
        this.JCBTimpano.setSelectedIndex(-1);
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
        String[][] mparametros = new String[4][2];
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
            } else {
                if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                    mparametros[0][0] = "idatencion1";
                    mparametros[0][1] = idAtencion;
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_Audiometria1", mparametros);
                    return;
                }
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria1", mparametros);
                return;
            }
        }
        mparametros[0][0] = "ID_AUDIOMETRIA";
        mparametros[0][1] = this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 16).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        mparametros[3][0] = "RESOURCE_DIR";
        mparametros[3][1] = this.xmetodo.getDirectorioExportacion() + "resource" + this.xmetodo.getBarra() + "so" + this.xmetodo.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria", mparametros);
        } else {
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = idAtencion;
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_Audiometria2", mparametros);
                return;
            }
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria1", mparametros);
        }
    }

    /* JADX WARN: Type inference failed for: r3v504, types: [java.lang.Object[], java.lang.Object[][]] */
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
        this.JBGrabaInterp1 = new JButton();
        this.jPanel2 = new JPanel();
        this.jPanel4 = new JPanel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.JSPIzquierdo250 = new JSpinner();
        this.JSPDerecho500 = new JSpinner();
        this.JSPIzquierdo500 = new JSpinner();
        this.JSPDerecho1000 = new JSpinner();
        this.JSPIzquierdo1000 = new JSpinner();
        this.JSPDerecho2000 = new JSpinner();
        this.JSPIzquierdo2000 = new JSpinner();
        this.JSPDerecho3000 = new JSpinner();
        this.JSPIzquierdo3000 = new JSpinner();
        this.JSPDerecho4000 = new JSpinner();
        this.JSPIzquierdo4000 = new JSpinner();
        this.JSPDerecho250 = new JSpinner();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jLabel21 = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.JTAObservacionViaOsea = new JTextArea();
        this.JBGrabarViaOsea = new JButton();
        this.jLabel22 = new JLabel();
        this.jLabel23 = new JLabel();
        this.jLabel24 = new JLabel();
        this.jLabel25 = new JLabel();
        this.jLabel26 = new JLabel();
        this.jLabel27 = new JLabel();
        this.jPanel6 = new JPanel();
        this.JCBWeber250 = new JComboBox<>();
        this.JCBWeber500 = new JComboBox<>();
        this.JCBWeber1000 = new JComboBox<>();
        this.JCBWeber2000 = new JComboBox<>();
        this.JCBWeber3000 = new JComboBox<>();
        this.JCBWeber4000 = new JComboBox<>();
        this.jScrollPane5 = new JScrollPane();
        this.JTAObservacionTestWeber = new JTextArea();
        this.JBGrabarTestWeber = new JButton();
        this.jPanel3 = new JPanel();
        this.jPanel5 = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.JTAObservacionOtoscopia = new JTextArea();
        this.JBGrabarOtoscopia = new JButton();
        this.JCBPabellon = new JComboBox<>();
        this.JCBTimpano = new JComboBox<>();
        this.JCBConductos = new JComboBox<>();
        this.JCBLobulo = new JComboBox<>();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "EXAMEN DE AUDIOMETRÍA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jifaudiometria_so2");
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPDatosAudio.setBorder(BorderFactory.createTitledBorder(""));
        this.JPODer500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer500.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.1
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPODer500StateChanged(evt);
            }
        });
        this.JPODer1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer1000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.2
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPODer1000StateChanged(evt);
            }
        });
        this.JPODer2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer2000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.3
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPODer2000StateChanged(evt);
            }
        });
        this.JPODer3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer3000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.4
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPODer3000StateChanged(evt);
            }
        });
        this.JPODer4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer4000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.5
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPODer4000StateChanged(evt);
            }
        });
        this.JPODer6000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer6000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.6
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPODer6000StateChanged(evt);
            }
        });
        this.JPODer8000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq500.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.7
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPOIzq500StateChanged(evt);
            }
        });
        this.JPOIzq1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq1000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.8
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPOIzq1000StateChanged(evt);
            }
        });
        this.JPOIzq2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq2000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.9
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPOIzq2000StateChanged(evt);
            }
        });
        this.JPOIzq3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq3000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.10
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPOIzq3000StateChanged(evt);
            }
        });
        this.JPOIzq4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq4000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.11
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPOIzq4000StateChanged(evt);
            }
        });
        this.JPOIzq6000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq6000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.12
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JPOIzq6000StateChanged(evt);
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
        this.JBGrabarRes.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.13
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JBGrabarResActionPerformed(evt);
            }
        });
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("Utiliza elementos de protección auditiva? ");
        this.JBElementos.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 11));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.14
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JRBNoActionPerformed(evt);
            }
        });
        this.JBElementos.add(this.JRBInsercion);
        this.JRBInsercion.setFont(new Font("Arial", 1, 11));
        this.JRBInsercion.setText("Inserción");
        this.JRBInsercion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.15
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JRBInsercionActionPerformed(evt);
            }
        });
        this.JBElementos.add(this.JRBCopa);
        this.JRBCopa.setFont(new Font("Arial", 1, 11));
        this.JRBCopa.setText("Copa");
        this.JRBCopa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.16
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JRBCopaActionPerformed(evt);
            }
        });
        this.JBElementos.add(this.JRBOtro);
        this.JRBOtro.setFont(new Font("Arial", 1, 11));
        this.JRBOtro.setText("Otro");
        this.JRBOtro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.17
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JRBOtroActionPerformed(evt);
            }
        });
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("En la otoscopia se observa tapon auditivo:");
        this.JBAutoscopia.add(this.JRBSi_Autoscopia);
        this.JRBSi_Autoscopia.setFont(new Font("Arial", 1, 11));
        this.JRBSi_Autoscopia.setText("Si");
        this.JRBSi_Autoscopia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.18
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JRBSi_AutoscopiaActionPerformed(evt);
            }
        });
        this.JBAutoscopia.add(this.JRBNo_Autoscopia);
        this.JRBNo_Autoscopia.setFont(new Font("Arial", 1, 11));
        this.JRBNo_Autoscopia.setSelected(true);
        this.JRBNo_Autoscopia.setText("No");
        this.JRBNo_Autoscopia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.19
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JRBNo_AutoscopiaActionPerformed(evt);
            }
        });
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setText("Retest?");
        this.JBRetest.add(this.JRBSi_Retest);
        this.JRBSi_Retest.setFont(new Font("Arial", 1, 11));
        this.JRBSi_Retest.setText("Si");
        this.JRBSi_Retest.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.20
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JRBSi_RetestActionPerformed(evt);
            }
        });
        this.JBRetest.add(this.JRBNo_Retest);
        this.JRBNo_Retest.setFont(new Font("Arial", 1, 11));
        this.JRBNo_Retest.setSelected(true);
        this.JRBNo_Retest.setText("No");
        this.JRBNo_Retest.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.21
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JRBNo_RetestActionPerformed(evt);
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
        this.JCHBPromedio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.22
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JCHBPromedioActionPerformed(evt);
            }
        });
        this.JCHBLineaB.setFont(new Font("Arial", 1, 11));
        this.JCHBLineaB.setText("Línea base?");
        this.JCHBLineaB.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.23
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JCHBLineaBActionPerformed(evt);
            }
        });
        this.JBActualizar.setFont(new Font("Arial", 1, 12));
        this.JBActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBActualizar.setText("Actualizar");
        this.JBActualizar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.24
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JBActualizarActionPerformed(evt);
            }
        });
        GroupLayout JPDatosAudioLayout = new GroupLayout(this.JPDatosAudio);
        this.JPDatosAudio.setLayout(JPDatosAudioLayout);
        JPDatosAudioLayout.setHorizontalGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel1)).addGap(10, 10, 10).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPODer500, -2, 55, -2).addGap(7, 7, 7)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel3).addGap(27, 27, 27))).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, -2, 43, -2).addComponent(this.JPODer1000, -2, 55, -2)).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPOIzq2000, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPOIzq3000, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPOIzq4000, -2, 55, -2)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPODer2000, -2, 55, -2).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPODer3000, -2, 55, -2).addComponent(this.jLabel6, -2, 43, -2)).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7, -2, 43, -2).addComponent(this.JPODer4000, -2, 55, -2)))).addComponent(this.jLabel5, -2, 43, -2)).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel8, -2, 43, -2).addGap(18, 18, 18).addComponent(this.jLabel9, -2, 43, -2)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPODer6000, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPODer8000, -2, 55, -2)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPOIzq6000, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPOIzq8000, -2, 55, -2)))).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPOIzq500, -2, 55, -2).addGap(7, 7, 7).addComponent(this.JPOIzq1000, -2, 55, -2))).addGap(7, 7, 7).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTFPromedioOIzq, -2, 56, -2).addComponent(this.jLabel10, -2, 71, -2).addComponent(this.JFTFPromedioODer, -2, 56, -2))).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel12, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi_Autoscopia).addGap(18, 18, 18).addComponent(this.JRBNo_Autoscopia)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel11).addGap(18, 18, 18).addComponent(this.JRBNo).addGap(18, 18, 18).addComponent(this.JRBInsercion)).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGap(401, 401, 401).addComponent(this.JRBCopa)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel13, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi_Retest).addGap(18, 18, 18).addComponent(this.JRBNo_Retest).addGap(26, 26, 26).addComponent(this.JCHBLineaB))).addGap(9, 9, 9).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBPromedio).addComponent(this.JRBOtro)))).addGap(2, 2, 2).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBGrabarRes, -1, 180, 32767).addComponent(this.jScrollPane2).addComponent(this.JBActualizar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPDatosAudioLayout.setVerticalGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.JRBSi_Retest).addComponent(this.JRBNo_Retest).addComponent(this.JCHBLineaB)).addGap(3, 3, 3)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHBPromedio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo).addComponent(this.JRBInsercion).addComponent(this.JRBCopa).addComponent(this.JRBOtro))).addGap(8, 8, 8).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jLabel7).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPODer500, -2, 31, -2).addComponent(this.JPODer1000, -2, 31, -2).addComponent(this.JPODer2000, -2, 31, -2).addComponent(this.JPODer3000, -2, 31, -2).addComponent(this.JPODer4000, -2, 31, -2).addComponent(this.JPODer6000, -2, 31, -2).addComponent(this.JPODer8000, -2, 31, -2).addComponent(this.jLabel1).addComponent(this.JFTFPromedioODer, -2, 29, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPOIzq500, -2, 31, -2).addComponent(this.JPOIzq1000, -2, 31, -2).addComponent(this.jLabel2).addComponent(this.JFTFPromedioOIzq, -2, 28, -2).addComponent(this.JPOIzq2000, -2, 31, -2)).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPOIzq4000, -2, 31, -2).addComponent(this.JPOIzq3000, -2, 31, -2).addComponent(this.JPOIzq6000, -2, 31, -2).addComponent(this.JPOIzq8000, -2, 31, -2))).addGap(6, 6, 6).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.JRBSi_Autoscopia).addComponent(this.JRBNo_Autoscopia)).addContainerGap(-1, 32767)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.JBGrabarRes, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBActualizar).addGap(18, 18, 18).addComponent(this.jScrollPane2)));
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
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBoshaOD, -2, 193, -2).addComponent(this.JCBoshaOI, -2, 193, -2).addComponent(this.JCGatODC1, -2, 193, -2).addComponent(this.JCGatOIC1, -2, 193, -2)).addGap(84, 84, 84).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCGatODC2, -2, 193, -2).addComponent(this.JCGatOIC2, -2, 193, -2).addComponent(this.JCGatOIC3, -2, 193, -2).addComponent(this.JCGatODC3, -2, 193, -2)).addGap(62, 62, 62).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCGatOIC5, -2, 193, -2).addComponent(this.JCGatODC5, -2, 193, -2).addComponent(this.JCGatOIC4, -2, 193, -2).addComponent(this.JCGatODC4, -2, 193, -2)).addContainerGap(66, 32767)));
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
        this.JBGrabaInterp1.setFont(new Font("Arial", 1, 14));
        this.JBGrabaInterp1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabaInterp1.setText("Grabar");
        this.JBGrabaInterp1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.25
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JBGrabaInterp1ActionPerformed(evt);
            }
        });
        GroupLayout JPInterpretacionLayout = new GroupLayout(this.JPInterpretacion);
        this.JPInterpretacion.setLayout(JPInterpretacionLayout);
        JPInterpretacionLayout.setHorizontalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCResultado, -2, 193, -2).addGap(48, 48, 48).addComponent(this.jScrollPane1, -2, 247, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBGrabaInterp1, -2, 149, -2).addGap(67, 67, 67)));
        JPInterpretacionLayout.setVerticalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInterpretacionLayout.createSequentialGroup().addContainerGap(16, 32767).addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGrabaInterp1, -2, 62, -2).addComponent(this.JCResultado, -2, -1, -2).addComponent(this.jScrollPane1, -2, 62, -2)).addContainerGap()));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPInformacion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPDatosAudio, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPInterpretacion, -1, -1, 32767)).addContainerGap(23, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosAudio, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPInformacion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPInterpretacion, -2, -1, -2).addContainerGap(79, 32767)));
        this.jTabbedPane1.addTab("DATOS", this.jPanel1);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "EVALUACIÓN DE LA AUDICIÓN VÍA ÓSEA", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(0, 102, 0));
        this.jLabel14.setText("Oido Derecho");
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(0, 102, 0));
        this.jLabel15.setText("Oido Izquierdo");
        this.JSPIzquierdo250.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo250.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.26
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPIzquierdo250StateChanged(evt);
            }
        });
        this.JSPDerecho500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho500.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.27
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPDerecho500StateChanged(evt);
            }
        });
        this.JSPIzquierdo500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo500.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.28
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPIzquierdo500StateChanged(evt);
            }
        });
        this.JSPDerecho1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho1000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.29
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPDerecho1000StateChanged(evt);
            }
        });
        this.JSPIzquierdo1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo1000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.30
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPIzquierdo1000StateChanged(evt);
            }
        });
        this.JSPDerecho2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho2000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.31
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPDerecho2000StateChanged(evt);
            }
        });
        this.JSPIzquierdo2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo2000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.32
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPIzquierdo2000StateChanged(evt);
            }
        });
        this.JSPDerecho3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho3000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.33
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPDerecho3000StateChanged(evt);
            }
        });
        this.JSPIzquierdo3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo3000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.34
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPIzquierdo3000StateChanged(evt);
            }
        });
        this.JSPDerecho4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho4000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.35
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPDerecho4000StateChanged(evt);
            }
        });
        this.JSPIzquierdo4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo4000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.36
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPIzquierdo4000StateChanged(evt);
            }
        });
        this.JSPDerecho250.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho250.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.37
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva.this.JSPDerecho250StateChanged(evt);
            }
        });
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setForeground(new Color(0, 0, 255));
        this.jLabel16.setText("500");
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setForeground(new Color(0, 0, 255));
        this.jLabel17.setText("1000");
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setForeground(new Color(0, 0, 255));
        this.jLabel18.setText("2000");
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setForeground(new Color(0, 0, 255));
        this.jLabel19.setText("3000");
        this.jLabel20.setFont(new Font("Arial", 1, 12));
        this.jLabel20.setForeground(new Color(0, 0, 255));
        this.jLabel20.setText("4000");
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setForeground(new Color(0, 0, 255));
        this.jLabel21.setText("250");
        this.JTAObservacionViaOsea.setColumns(1);
        this.JTAObservacionViaOsea.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionViaOsea.setLineWrap(true);
        this.JTAObservacionViaOsea.setRows(1);
        this.JTAObservacionViaOsea.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSERVACIÓN", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.jScrollPane3.setViewportView(this.JTAObservacionViaOsea);
        this.JBGrabarViaOsea.setFont(new Font("Arial", 1, 12));
        this.JBGrabarViaOsea.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarViaOsea.setText("Grabar");
        this.JBGrabarViaOsea.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.38
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JBGrabarViaOseaActionPerformed(evt);
            }
        });
        this.jLabel22.setFont(new Font("Arial", 1, 12));
        this.jLabel22.setForeground(new Color(0, 0, 255));
        this.jLabel22.setText("250");
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setForeground(new Color(0, 0, 255));
        this.jLabel23.setText("500");
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setForeground(new Color(0, 0, 255));
        this.jLabel24.setText("1000");
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setForeground(new Color(0, 0, 255));
        this.jLabel25.setText("2000");
        this.jLabel26.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setForeground(new Color(0, 0, 255));
        this.jLabel26.setText("3000");
        this.jLabel27.setFont(new Font("Arial", 1, 12));
        this.jLabel27.setForeground(new Color(0, 0, 255));
        this.jLabel27.setText("4000");
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(25, 25, 25).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel15, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel21, -2, 43, -2).addComponent(this.JSPDerecho250, -2, 55, -2)).addGap(40, 40, 40).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JSPDerecho500, -2, 55, -2).addGap(40, 40, 40).addComponent(this.JSPDerecho1000, -2, 55, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel16).addGap(68, 68, 68).addComponent(this.jLabel17, -2, 43, -2))).addGap(40, 40, 40).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDerecho2000, GroupLayout.Alignment.TRAILING, -2, 55, -2).addComponent(this.jLabel18, GroupLayout.Alignment.TRAILING, -2, 43, -2)).addGap(40, 40, 40).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel19, -2, 43, -2).addComponent(this.JSPDerecho3000, -2, 55, -2)).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.JSPDerecho4000, -2, 55, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addGap(52, 52, 52).addComponent(this.jLabel20, -2, 43, -2)))).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel22, -2, 43, -2).addComponent(this.JSPIzquierdo250, -2, 55, -2)).addGap(40, 40, 40).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JSPIzquierdo500, -2, 55, -2).addGap(40, 40, 40).addComponent(this.JSPIzquierdo1000, -2, 55, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel23).addGap(71, 71, 71).addComponent(this.jLabel24, -2, 43, -2))).addGap(40, 40, 40).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPIzquierdo2000, -2, 55, -2).addComponent(this.jLabel25, -2, 43, -2)).addGap(40, 40, 40).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPIzquierdo3000, -2, 55, -2).addComponent(this.jLabel26, -2, 43, -2)).addGap(40, 40, 40).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPIzquierdo4000, -2, 55, -2).addComponent(this.jLabel27, -2, 43, -2))))).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 580, -2).addGap(18, 18, 18).addComponent(this.JBGrabarViaOsea, -2, 180, -2))).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(40, 40, 40).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.jLabel17).addComponent(this.jLabel18).addComponent(this.jLabel19).addComponent(this.jLabel20).addComponent(this.jLabel21).addComponent(this.jLabel14)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPDerecho500, -2, 31, -2).addComponent(this.JSPDerecho1000, -2, 31, -2).addComponent(this.JSPDerecho2000, -2, 31, -2).addComponent(this.JSPDerecho3000, -2, 31, -2).addComponent(this.JSPDerecho4000, -2, 31, -2).addComponent(this.JSPDerecho250, -2, 31, -2)).addGap(25, 25, 25).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.jLabel22).addComponent(this.jLabel23).addComponent(this.jLabel24).addComponent(this.jLabel25).addComponent(this.jLabel26).addComponent(this.jLabel27)).addGap(4, 4, 4).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPIzquierdo500, -2, 31, -2).addComponent(this.JSPIzquierdo250, -2, 31, -2).addComponent(this.JSPIzquierdo1000, -2, 31, -2).addComponent(this.JSPIzquierdo2000, -2, 31, -2).addComponent(this.JSPIzquierdo3000, -2, 31, -2).addComponent(this.JSPIzquierdo4000, -2, 31, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 112, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.JBGrabarViaOsea, -2, 45, -2).addGap(48, 48, 48)))));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "TEST DE WEBER", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBWeber250.setBorder(BorderFactory.createTitledBorder((Border) null, "250", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBWeber250.setMinimumSize(new Dimension(50, 30));
        this.JCBWeber500.setBorder(BorderFactory.createTitledBorder((Border) null, "500", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBWeber500.setMinimumSize(new Dimension(50, 30));
        this.JCBWeber1000.setBorder(BorderFactory.createTitledBorder((Border) null, "1000", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBWeber1000.setMinimumSize(new Dimension(50, 30));
        this.JCBWeber2000.setBorder(BorderFactory.createTitledBorder((Border) null, "2000", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBWeber2000.setMinimumSize(new Dimension(50, 30));
        this.JCBWeber3000.setBorder(BorderFactory.createTitledBorder((Border) null, "3000", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBWeber3000.setMinimumSize(new Dimension(50, 30));
        this.JCBWeber4000.setBorder(BorderFactory.createTitledBorder((Border) null, "4000", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBWeber4000.setMinimumSize(new Dimension(50, 30));
        this.JTAObservacionTestWeber.setColumns(20);
        this.JTAObservacionTestWeber.setRows(5);
        this.JTAObservacionTestWeber.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSERVACIÓN", 1, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.jScrollPane5.setViewportView(this.JTAObservacionTestWeber);
        this.JBGrabarTestWeber.setFont(new Font("Arial", 1, 12));
        this.JBGrabarTestWeber.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarTestWeber.setText("Grabar");
        this.JBGrabarTestWeber.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.39
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JBGrabarTestWeberActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -2, 585, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabarTestWeber, -2, 180, -2)).addGroup(jPanel6Layout.createSequentialGroup().addGap(60, 60, 60).addComponent(this.JCBWeber250, -2, 90, -2).addGap(30, 30, 30).addComponent(this.JCBWeber500, -2, 90, -2).addGap(30, 30, 30).addComponent(this.JCBWeber1000, -2, 90, -2).addGap(30, 30, 30).addComponent(this.JCBWeber2000, -2, 90, -2).addGap(30, 30, 30).addComponent(this.JCBWeber3000, -2, 90, -2).addGap(30, 30, 30).addComponent(this.JCBWeber4000, -2, 90, -2))).addContainerGap(-1, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBWeber250, -2, 45, -2).addComponent(this.JCBWeber500, -2, 45, -2).addComponent(this.JCBWeber1000, -2, 45, -2).addComponent(this.JCBWeber2000, -2, 45, -2).addComponent(this.JCBWeber3000, -2, 45, -2).addComponent(this.JCBWeber4000, -2, 45, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addComponent(this.jScrollPane5, -2, 100, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addComponent(this.JBGrabarTestWeber, -2, 45, -2).addGap(44, 44, 44)))));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("VIA OSEA", this.jPanel2);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "EVALUACIÓN DEL OÍDO Y OTOSCOPIA", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE (AMPLIACIÓN DE HALLAZGO)", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTAObservacionOtoscopia.setColumns(20);
        this.JTAObservacionOtoscopia.setRows(5);
        this.jScrollPane4.setViewportView(this.JTAObservacionOtoscopia);
        this.JBGrabarOtoscopia.setFont(new Font("Arial", 1, 12));
        this.JBGrabarOtoscopia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarOtoscopia.setText("Grabar");
        this.JBGrabarOtoscopia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.40
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva.this.JBGrabarOtoscopiaActionPerformed(evt);
            }
        });
        this.JCBPabellon.setFont(new Font("Arial", 1, 12));
        this.JCBPabellon.setBorder(BorderFactory.createTitledBorder((Border) null, "PABELLÓN", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBTimpano.setFont(new Font("Arial", 1, 12));
        this.JCBTimpano.setBorder(BorderFactory.createTitledBorder((Border) null, "TÍMPANO", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBConductos.setFont(new Font("Arial", 1, 12));
        this.JCBConductos.setBorder(BorderFactory.createTitledBorder((Border) null, "CONDUCTOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBLobulo.setFont(new Font("Arial", 1, 12));
        this.JCBLobulo.setBorder(BorderFactory.createTitledBorder((Border) null, "LÓBULO", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jScrollPane4).addGap(18, 18, 18).addComponent(this.JBGrabarOtoscopia, -2, 180, -2).addGap(32, 32, 32)).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGap(33, 33, 33).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBPabellon, -2, 325, -2).addComponent(this.JCBConductos, -2, 325, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 73, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTimpano, GroupLayout.Alignment.TRAILING, -2, 325, -2).addComponent(this.JCBLobulo, GroupLayout.Alignment.TRAILING, -2, 325, -2)).addGap(44, 44, 44)))));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPabellon, -2, 53, -2).addComponent(this.JCBTimpano, -2, 53, -2)).addGap(26, 26, 26).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConductos, -2, 53, -2).addComponent(this.JCBLobulo, -2, 53, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addComponent(this.jScrollPane4, -2, 122, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addComponent(this.JBGrabarOtoscopia, -2, 45, -2).addGap(50, 50, 50)))));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -1, -1, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -2, -1, -2).addContainerGap(250, 32767)));
        this.jTabbedPane1.addTab("OTOSCOPIA", this.jPanel3);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.41
            public void mouseClicked(MouseEvent evt) {
                JPSo_Audiometria_nueva.this.JTDetalleHistoricoMouseClicked(evt);
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
        getAccessibleContext().setAccessibleName("ExamenAudiometria2");
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
    public void JSPIzquierdo250StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDerecho500StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPIzquierdo500StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDerecho1000StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPIzquierdo1000StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDerecho2000StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPIzquierdo2000StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDerecho3000StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPIzquierdo3000StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDerecho4000StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPIzquierdo4000StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDerecho250StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarViaOseaActionPerformed(ActionEvent evt) {
        mGrabarViaOsea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarOtoscopiaActionPerformed(ActionEvent evt) {
        mGrabarOtoscopia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarTestWeberActionPerformed(ActionEvent evt) {
        mGrabarTestWeber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabaInterp1ActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "UPDATE h_so_audiometria SET h_so_audiometria.`ResultadoM`='" + this.JCResultado.getSelectedItem() + "' , h_so_audiometria.`ObservacionM`='" + this.JTAObservacion.getText() + "', h_so_audiometria.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' WHERE (h_so_audiometria.`Id`='" + this.xidAdiometria + "')";
            System.out.println(sql);
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() == 1) {
                Principal.clasehistoriace.mActualizarVariable_ManPower("RAudiometria", this.JCResultado.getSelectedItem().toString(), "Observacion_Aud", this.JTAObservacion.getText());
                if (!this.JCResultado.getSelectedItem().equals("NORMAL")) {
                    Principal.clasehistoriace.mActualizarAlterado_ManPower();
                }
            }
            if (!Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                this.JBGrabaInterp1.setEnabled(false);
            }
            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBActualizarActionPerformed(ActionEvent evt) {
        actualizar();
    }

    private void actualizar() {
        String sql = null;
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            sql = "UPDATE \th_so_audiometria SET \tId_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Fecha_R = '" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', I500 = '" + this.JPOIzq500.getValue() + "', I1000 = '" + this.JPOIzq1000.getValue() + "', I2000 = '" + this.JPOIzq2000.getValue() + "', I3000 = '" + this.JPOIzq3000.getValue() + "', I4000 = '" + this.JPOIzq4000.getValue() + "', I6000 = '" + this.JPOIzq6000.getValue() + "', I8000 = '" + this.JPOIzq8000.getValue() + "', D500 = '" + this.JPODer500.getValue() + "', D1000 = '" + this.JPODer1000.getValue() + "', D2000 = '" + this.JPODer2000.getValue() + "', D3000 = '" + this.JPODer3000.getValue() + "', D4000 = '" + this.JPODer4000.getValue() + "', D6000 = '" + this.JPODer6000.getValue() + "', D8000 = '" + this.JPODer8000.getValue() + "', POI = '" + this.JFTFPromedioOIzq.getValue() + "', POD = '" + this.JFTFPromedioODer.getValue() + "', COI_OSHAS = '" + this.JCBoshaOI.getSelectedItem() + "', COD_OSHAS = '" + this.JCBoshaOD.getSelectedItem() + "', C1_OI_GATISO = '" + this.JCGatOIC1.getSelectedItem() + "', C1_OD_GATISO = '" + this.JCGatODC1.getSelectedItem() + "', C2_OI_GATISO = '" + this.JCGatOIC2.getSelectedItem() + "', C2_OD_GATISO = '" + this.JCGatODC2.getSelectedItem() + "', C3_OI_GATISO = '" + this.JCGatOIC3.getSelectedItem() + "', C3_OD_GATISO = '" + this.JCGatODC3.getSelectedItem() + "', Id_Especialidad = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', Id_Usuario = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', ElementosAudio = \t'" + this.xelemento + "', Autoscopia = '" + this.xautoscopia + "', Retest = '" + this.xretest + "', ObservacionAudio = '" + this.JTAObservacionAudio.getText() + "', TFormula = '" + this.xtformula + "', LineaBase = '" + this.xlineabase + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE \t\th_so_audiometria.`Id`='" + this.xidAdiometria + "'";
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

    private void mGrabarViaOsea() {
        int n = JOptionPane.showInternalConfirmDialog(this, "¿Esta seguro de grabar Via Osea?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.ViaOseaEntity.setIdAtencion(Long.valueOf(Long.parseLong(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())));
            this.ViaOseaEntity.setFechaRegistro(this.xmetodo.getFechaActual());
            this.ViaOseaEntity.setI250(Integer.valueOf(Integer.parseInt(this.JSPIzquierdo250.getValue().toString())));
            this.ViaOseaEntity.setI500(Integer.valueOf(Integer.parseInt(this.JSPIzquierdo500.getValue().toString())));
            this.ViaOseaEntity.setI1000(Integer.valueOf(Integer.parseInt(this.JSPIzquierdo1000.getValue().toString())));
            this.ViaOseaEntity.setI2000(Integer.valueOf(Integer.parseInt(this.JSPIzquierdo2000.getValue().toString())));
            this.ViaOseaEntity.setI3000(Integer.valueOf(Integer.parseInt(this.JSPIzquierdo3000.getValue().toString())));
            this.ViaOseaEntity.setI4000(Integer.valueOf(Integer.parseInt(this.JSPIzquierdo4000.getValue().toString())));
            this.ViaOseaEntity.setD250(Integer.valueOf(Integer.parseInt(this.JSPDerecho250.getValue().toString())));
            this.ViaOseaEntity.setD500(Integer.valueOf(Integer.parseInt(this.JSPDerecho500.getValue().toString())));
            this.ViaOseaEntity.setD1000(Integer.valueOf(Integer.parseInt(this.JSPDerecho1000.getValue().toString())));
            this.ViaOseaEntity.setD2000(Integer.valueOf(Integer.parseInt(this.JSPDerecho2000.getValue().toString())));
            this.ViaOseaEntity.setD3000(Integer.valueOf(Integer.parseInt(this.JSPDerecho3000.getValue().toString())));
            this.ViaOseaEntity.setD4000(Integer.valueOf(Integer.parseInt(this.JSPDerecho4000.getValue().toString())));
            this.ViaOseaEntity.setObservacion(this.JTAObservacionViaOsea.getText());
            this.ViaOseaEntity.setIdProfesional(Integer.valueOf(Integer.parseInt(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString())));
            this.ViaOseaEntity.setIdEspecialidad(Integer.valueOf(Integer.parseInt(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString())));
            this.ViaOseaEntity.setEstado(1);
            this.ViaOseaEntity.setFecha(this.xmetodo.getFechaActual());
            this.ViaOseaEntity.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo().toString());
            this.viaOseaService.mGrabarViaOsea(this.ViaOseaEntity).getId();
        }
    }

    private void mGrabarOtoscopia() {
        if (this.JCBPabellon.getSelectedIndex() != -1) {
            if (this.JCBConductos.getSelectedIndex() != -1) {
                if (this.JCBTimpano.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar Otoscopia?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.otoscopiaEntity.setIdAtencion(Long.valueOf(Long.parseLong(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())));
                        this.otoscopiaEntity.setFechaRegistro(this.xmetodo.getFechaActual());
                        this.otoscopiaEntity.setPabellon(Integer.valueOf(Integer.parseInt(this.listaRespuestaPabellon.get(this.JCBPabellon.getSelectedIndex()).getId().toString())));
                        this.otoscopiaEntity.setConducto(Integer.valueOf(Integer.parseInt(this.listaRespuestaConducto.get(this.JCBConductos.getSelectedIndex()).getId().toString())));
                        this.otoscopiaEntity.setTimpanos(Integer.valueOf(Integer.parseInt(this.listaRespuestaTimpano.get(this.JCBTimpano.getSelectedIndex()).getId().toString())));
                        this.otoscopiaEntity.setLobulos(Integer.valueOf(Integer.parseInt(this.listaRespuestaPabellon.get(this.JCBPabellon.getSelectedIndex()).getId().toString())));
                        this.otoscopiaEntity.setObservacion(this.JTAObservacionOtoscopia.getText());
                        this.otoscopiaEntity.setIdProfesional(Integer.valueOf(Integer.parseInt(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString())));
                        this.otoscopiaEntity.setIdEspecialidad(Integer.valueOf(Integer.parseInt(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString())));
                        this.otoscopiaEntity.setEstado(1);
                        this.otoscopiaEntity.setFecha(this.xmetodo.getFechaActual());
                        this.otoscopiaEntity.setIdUsuarioRh(Long.valueOf(Long.parseLong(Principal.usuarioSistemaDTO.getIdPersonaCargo().toString())));
                        this.otoscopiaService.mGrabarOtoscopia(this.otoscopiaEntity).getId();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion para Tímpano.");
                this.JCBTimpano.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion para Conductos.");
            this.JCBConductos.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion para Pabellón.");
        this.JCBPabellon.requestFocus();
    }

    private void mGrabarTestWeber() {
        if (this.JCBWeber250.getSelectedIndex() != -1) {
            if (this.JCBWeber500.getSelectedIndex() != -1) {
                if (this.JCBWeber1000.getSelectedIndex() != -1) {
                    if (this.JCBWeber2000.getSelectedIndex() != -1) {
                        if (this.JCBWeber3000.getSelectedIndex() != -1) {
                            if (this.JCBWeber4000.getSelectedIndex() != -1) {
                                int n = JOptionPane.showInternalConfirmDialog(this, "¿Esta seguro de grabar test de Weber?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    this.testWeberEntity.setIdAtencion(Long.valueOf(Long.parseLong(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())));
                                    this.testWeberEntity.setFechaRegistro(this.xmetodo.getFechaActual());
                                    this.testWeberEntity.setT250(this.nombre[this.JCBWeber250.getSelectedIndex()]);
                                    this.testWeberEntity.setT500(this.nombre[this.JCBWeber500.getSelectedIndex()]);
                                    this.testWeberEntity.setT1000(this.nombre[this.JCBWeber1000.getSelectedIndex()]);
                                    this.testWeberEntity.setT2000(this.nombre[this.JCBWeber2000.getSelectedIndex()]);
                                    this.testWeberEntity.setT3000(this.nombre[this.JCBWeber3000.getSelectedIndex()]);
                                    this.testWeberEntity.setT4000(this.nombre[this.JCBWeber4000.getSelectedIndex()]);
                                    this.testWeberEntity.setObservacion(this.JTAObservacionTestWeber.getText());
                                    this.testWeberEntity.setIdProfesional(Integer.valueOf(Integer.parseInt(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString())));
                                    this.testWeberEntity.setIdEspecialidad(Integer.valueOf(Integer.parseInt(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString())));
                                    this.testWeberEntity.setEstado(1);
                                    this.testWeberEntity.setFecha(this.xmetodo.getFechaActual());
                                    this.testWeberEntity.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                                    this.testWeberService.mGrabarTestWeber(this.testWeberEntity);
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion para 4000.");
                            this.JCBWeber4000.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion para 3000.");
                        this.JCBWeber3000.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion para 2000.");
                    this.JCBWeber2000.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion para 1000.");
                this.JCBWeber1000.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion para 500.");
            this.JCBWeber500.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opcion para 250.");
        this.JCBWeber250.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "OD500", "OD1000", "OD2000", "OD3000", "OD4000", "OD6000", "OD8000", "OI500", "OI1000", "OI2000", "OI3000", "OI4000", "OI6000", "OI8000", "IdAudio", " Vía Ósea: ", "OI250", "OI500", "OI1000", "OI2000", "OI3000", "OI4000", "OD250", "OD500", "OD1000", "OD2000", "OD3000", "OD4000", " Otoscopia: ", "Pabellón", "Conducto", "Timpanos"}) { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva.42
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleHistorico;
        JTable jTable2 = this.JTDetalleHistorico;
        jTable.setAutoResizeMode(0);
        this.JTDetalleHistorico.setModel(this.xmodeloh);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(7).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(8).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(9).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(10).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(11).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(12).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(13).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(14).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(15).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalleHistorico.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(18).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(19).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(20).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(21).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(22).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(23).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(24).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(25).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(26).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(27).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(28).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(29).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(31).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(32).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(33).setPreferredWidth(200);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT h_so_audiometria.Id_Atencion, h_so_audiometria.Fecha_R, h_so_audiometria.I500, h_so_audiometria.I1000, h_so_audiometria.I2000,\n  h_so_audiometria.I3000, h_so_audiometria.I4000, h_so_audiometria.I6000, h_so_audiometria.I8000, h_so_audiometria.D500, h_so_audiometria.D1000,\n  h_so_audiometria.D2000, h_so_audiometria.D3000, h_so_audiometria.D4000, h_so_audiometria.D6000, h_so_audiometria.D8000, h_so_audiometria.Id,\n  ' Vía Ósea: ' AS 'Via Osea', so.i250,  so.i500,  so.i1000,  so.i2000, so.i3000,  so.i4000,  so.d250,  so.d500,  so.d1000,  so.d2000,  so.d3000,  so.d4000\n,' Otoscopia: ' AS 'Otoscopia', pabellonR.nombre AS pabellon,  conductoR.nombre AS conducto,  timpanosR.nombre AS timpanos\nFROM h_so_audiometria\n  LEFT JOIN  h_so_audiometria_via_osea so  ON(h_so_audiometria.Id_Atencion = so.idAtencion)\n  LEFT JOIN  h_so_evalucion_oido_otoscopia otoscopia ON(h_so_audiometria.Id_Atencion = otoscopia.idAtencion)\n  LEFT JOIN h_tiporespuestaotoscopia pabellonR ON(pabellonR.id = otoscopia.pabellon)\n  LEFT JOIN h_tiporespuestaotoscopia conductoR ON(conductoR.id = otoscopia.conducto)\n  LEFT JOIN h_tiporespuestaotoscopia timpanosR ON(timpanosR.id = otoscopia.timpanos)\n  LEFT JOIN h_tiporespuestaotoscopia lobulosR ON(lobulosR.id = otoscopia.lobulos)\nWHERE (h_so_audiometria.Id_Usuario = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND h_so_audiometria.Estado = 1) ORDER BY h_so_audiometria.Id_Atencion DESC;";
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
                    this.xmodeloh.setValueAt(xrs.getString(18), n, 17);
                    this.xmodeloh.setValueAt(xrs.getString(19), n, 18);
                    this.xmodeloh.setValueAt(xrs.getString(20), n, 19);
                    this.xmodeloh.setValueAt(xrs.getString(21), n, 20);
                    this.xmodeloh.setValueAt(xrs.getString(22), n, 21);
                    this.xmodeloh.setValueAt(xrs.getString(23), n, 22);
                    this.xmodeloh.setValueAt(xrs.getString(24), n, 23);
                    this.xmodeloh.setValueAt(xrs.getString(25), n, 24);
                    this.xmodeloh.setValueAt(xrs.getString(26), n, 25);
                    this.xmodeloh.setValueAt(xrs.getString(27), n, 26);
                    this.xmodeloh.setValueAt(xrs.getString(28), n, 27);
                    this.xmodeloh.setValueAt(xrs.getString(29), n, 28);
                    this.xmodeloh.setValueAt(xrs.getString(30), n, 29);
                    this.xmodeloh.setValueAt(xrs.getString(31), n, 30);
                    this.xmodeloh.setValueAt(xrs.getString(32), n, 31);
                    this.xmodeloh.setValueAt(xrs.getString(33), n, 32);
                    this.xmodeloh.setValueAt(xrs.getString(34), n, 33);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Audiometria_nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
        }
    }

    private void mBuscarAdiometriaAtencion() {
        try {
            String sql = "SELECT h_so_audiometria.`I500`  , h_so_audiometria.`I1000`  , h_so_audiometria.`I2000`  , h_so_audiometria.`I3000` , h_so_audiometria.`I4000` , h_so_audiometria.`I6000`  , h_so_audiometria.`I8000` , h_so_audiometria.`D500` , h_so_audiometria.`D1000` , h_so_audiometria.`D2000`  , h_so_audiometria.`D3000`, h_so_audiometria.`D4000` , h_so_audiometria.`D6000`  , h_so_audiometria.`D8000` , h_so_audiometria.`POI` , h_so_audiometria.`POD` , h_so_audiometria.`COI_OSHAS` , h_so_audiometria.`COD_OSHAS` , h_so_audiometria.`C1_OI_GATISO`  , h_so_audiometria.`C1_OD_GATISO`  , h_so_audiometria.`C2_OI_GATISO` , h_so_audiometria.`C2_OD_GATISO` , h_so_audiometria.`C3_OI_GATISO` , h_so_audiometria.`C3_OD_GATISO` , h_so_audiometria.`ResultadoM`  , h_so_audiometria.`ObservacionM`, `h_atencion`.`TipoGuardado`, h_so_audiometria.ElementosAudio, h_so_audiometria.Autoscopia, h_so_audiometria.Retest, IF(ObservacionAudio IS NULL,'',ObservacionAudio)AS ObservacionAudio, h_so_audiometria.TFormula, h_so_audiometria.Id_Atencion, h_so_audiometria.Id, h_so_audiometria.LineaBase, if(h_so_audiometria.`ResultadoM` IS NULL || h_so_audiometria.`ResultadoM`='', 0, 1) AS Grabado    FROM `h_so_audiometria` INNER JOIN `h_atencion`   ON (`h_so_audiometria`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and h_so_audiometria.Estado=1)";
            System.out.println("Buscar audiometria atencion -> " + sql);
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
                System.out.println("------> " + this.xidAdiometria);
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
            } else {
                this.xid = "0";
            }
            if (this.xmetodo.esIPSMineros()) {
                if (this.xatenciong != 0) {
                    this.JBGrabarRes.setEnabled(false);
                } else {
                    this.JBGrabarRes.setEnabled(true);
                }
            } else if (xrs.getBoolean("Grabado")) {
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Audiometria_nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
            Logger.getLogger(JPSo_Audiometria_nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
