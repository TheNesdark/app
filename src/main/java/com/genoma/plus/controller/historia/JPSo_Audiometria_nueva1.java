package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.JCBRenderImagen;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.JPADiagnostico;
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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Base64;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPSo_Audiometria_nueva1.class */
public class JPSo_Audiometria_nueva1 extends JPanel {
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
    private ButtonGroup GroupSarampion;
    private ButtonGroup JBAutoscopia;
    private ButtonGroup JBElementos;
    private ButtonGroup JBGTipoIncapacidad;
    private JButton JBGrabarOtoscopia;
    private JButton JBGrabarRes;
    private JButton JBGrabarTestWeber;
    private JButton JBGrabarViaOsea;
    private ButtonGroup JBRetest;
    private JCheckBox JCAcufenosNO;
    private JCheckBox JCAcufenosSI;
    private JCheckBox JCAlergiasNO;
    private JCheckBox JCAlergiasSI;
    private JCheckBox JCAmigdalitisNO;
    private JCheckBox JCAmigdalitisSI;
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
    private JCheckBox JCCirugiasOidoNO;
    private JCheckBox JCCirugiasOidoSI;
    private JCheckBox JCDiabetesNO;
    private JCheckBox JCDiabetesSI;
    private JCheckBox JCDrogastoxicasNO;
    private JCheckBox JCDrogastoxicasSI;
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
    private JCheckBox JCHBDiscotecas;
    private JCheckBox JCHBLineaB;
    private JCheckBox JCHBPromedio;
    private JCheckBox JCHBRudioAmbiental;
    private JCheckBox JCHBServicioMilitar;
    private JCheckBox JCHBTejo;
    private JCheckBox JCHBTiroCaza;
    private JCheckBox JCHBUsoAudifonos;
    private JCheckBox JCHBUsoDeMoto;
    private JCheckBox JCHipertencionArterialNO;
    private JCheckBox JCHipertencionArterialSI;
    private JCheckBox JCHipoacusiaNO;
    private JCheckBox JCHipoacusiaSI;
    private JCheckBox JCMareoNO;
    private JCheckBox JCMareoSI;
    private JCheckBox JCOtalgiaNO;
    private JCheckBox JCOtalgiaSI;
    private JCheckBox JCOtitisNO;
    private JCheckBox JCOtitisSI;
    private JCheckBox JCOtorreaNO;
    private JCheckBox JCOtorreaSI;
    private JCheckBox JCPaperasNO;
    private JCheckBox JCPaperasSI;
    private JCheckBox JCPolioNO;
    private JCheckBox JCPolioSI;
    private JComboBox JCResultado;
    private JCheckBox JCSarampionNO;
    private JCheckBox JCSarampionSI;
    private JCheckBox JCSifilisNO;
    private JCheckBox JCSifilisSI;
    private JCheckBox JCSordelaFamiliarNO;
    private JCheckBox JCSordelaFamiliarSI;
    private JCheckBox JCTBCNO;
    private JCheckBox JCTBCSI;
    private JCheckBox JCTraumaDeCraneoNO;
    private JCheckBox JCTraumaDeCraneoSI;
    private JCheckBox JCVertigoNO;
    private JCheckBox JCVertigoSI;
    private JFormattedTextField JFTFPromedioODer;
    private JFormattedTextField JFTFPromedioOIzq;
    private JPanel JPDatosAudio;
    private JPanel JPHistorico;
    private JPanel JPInformacion;
    private JPanel JPInterpretacion;
    private JSpinner JPODer1000;
    private JSpinner JPODer2000;
    private JSpinner JPODer250;
    private JSpinner JPODer3000;
    private JSpinner JPODer4000;
    private JSpinner JPODer500;
    private JSpinner JPODer6000;
    private JSpinner JPODer8000;
    private JSpinner JPOIzq1000;
    private JSpinner JPOIzq2000;
    private JSpinner JPOIzq250;
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
    private JTextArea JTORecomendacionesPresbiacusia;
    private JTextArea JTObservaciones;
    private JTextArea JTObservacionesPresbiacusia;
    private JTabbedPane JTP_DatosG;
    private ButtonGroup groupAcufenos;
    private ButtonGroup groupAlergias;
    private ButtonGroup groupAmigdalitis;
    private ButtonGroup groupCirugiasdeOido;
    private ButtonGroup groupDiabetes;
    private ButtonGroup groupDrogasToxicas;
    private ButtonGroup groupHipertencion;
    private ButtonGroup groupHipoacusia;
    private ButtonGroup groupMareo;
    private ButtonGroup groupOtalgia;
    private ButtonGroup groupOtitis;
    private ButtonGroup groupOtorrea;
    private ButtonGroup groupPaperas;
    private ButtonGroup groupPolio;
    private ButtonGroup groupSifilis;
    private ButtonGroup groupSorderaFamiliar;
    private ButtonGroup groupTBC;
    private ButtonGroup groupTraumaCreaneo;
    private ButtonGroup groupVertigo;
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
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel4;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JLabel jLabel49;
    private JLabel jLabel5;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel52;
    private JLabel jLabel53;
    private JLabel jLabel54;
    private JLabel jLabel55;
    private JLabel jLabel56;
    private JLabel jLabel57;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JLabel jLbImg1;
    private JLabel jLbImg2;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JTextField jTEliOd;
    private JTextField jTEliOi;
    private JTextField jTGatiso;
    private JTextField jTLarsenOd;
    private JTextField jTLarsenOi;
    private JTextField jTSalOd;
    private JTextField jTSalOi;
    private JTabbedPane jTabbedPane1;
    private JPanel jpDiagnostico;
    Runtime obj = Runtime.getRuntime();
    private final ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private final Metodos xmetodo = new Metodos();
    private double xpromedioD = 0.0d;
    private double xpromedioI = 0.0d;
    public long xelemento = 0;
    public long xidatencion = 0;
    public long xidAdiometria = 0;
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
    private String ImgIzquierda = "";
    private String ImgDerecha = "";
    public JPADiagnostico aDiagnostico = null;
    private double promedioBinauralTotal = 0.0d;

    public JPSo_Audiometria_nueva1() {
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
        cargarDiagnostico();
        this.JCHBPromedio.setVisible(false);
        this.JPInterpretacion.setVisible(true);
        mNuevo();
        this.JCBLobulo.setVisible(false);
    }

    private void cargarDiagnostico() {
        if (this.aDiagnostico == null) {
            this.aDiagnostico = new JPADiagnostico(this);
        }
        this.aDiagnostico.setBounds(1, 1, 780, 250);
        this.jpDiagnostico.add(this.aDiagnostico);
        this.aDiagnostico.setVisible(true);
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
                this.JBGrabarViaOsea.setEnabled(false);
                this.JBGrabarOtoscopia.setEnabled(false);
                this.JBGrabarRes.setEnabled(false);
                this.JBGrabarTestWeber.setEnabled(false);
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
        System.out.println(x1 + "," + x2 + "," + x3);
        if (this.xoido == 0) {
            this.xpromedioD = ((x1 + x2) + x3) / 3.0d;
            return this.xpromedioD;
        }
        this.xpromedioI = ((x1 + x2) + x3) / 3.0d;
        return this.xpromedioI;
    }

    private double mCalcularPromedio2(double x1, double x2, double x3, double x4, long oido) {
        this.xoido = oido;
        System.out.println(x1 + "," + x2 + "," + x3 + "," + x4 + ",");
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
            }
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = idAtencion;
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_Audiometria1", mparametros);
                return;
            } else {
                mparametros[0][0] = "ID_AUDIOMETRIA";
                mparametros[0][1] = idAtencion;
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
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = idAtencion;
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_Audiometria2", mparametros);
        } else {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = idAtencion;
                this.xmetodo.GenerarPDFAudimetriaBienestar(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria1_Bienestar", mparametros, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), true);
                return;
            }
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria1", mparametros);
        }
    }

    public void mImprimir2() {
        mGenerarGrafico();
        String[][] mparametros = new String[4][2];
        String idAtencion = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
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
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = idAtencion;
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_Audiometria1", mparametros);
                return;
            } else {
                mparametros[0][0] = "ID_AUDIOMETRIA";
                mparametros[0][1] = idAtencion;
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria1", mparametros);
                return;
            }
        }
        mparametros[0][0] = "ID_AUDIOMETRIA";
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        mparametros[3][0] = "RESOURCE_DIR";
        mparametros[3][1] = this.xmetodo.getDirectorioExportacion() + "resource" + this.xmetodo.getBarra() + "so" + this.xmetodo.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = idAtencion;
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO_HistoriaClinica_Audiometria2", mparametros);
        } else {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                mparametros[0][0] = "idatencion1";
                mparametros[0][1] = idAtencion;
                this.xmetodo.GenerarPDFAudimetriaBienestar(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria1_Bienestar", mparametros, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), false);
                return;
            }
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "SO2_HistoriaClinica_Audiometria1", mparametros);
        }
    }

    /* JADX WARN: Type inference failed for: r3v545, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoIncapacidad = new ButtonGroup();
        this.JBElementos = new ButtonGroup();
        this.JBAutoscopia = new ButtonGroup();
        this.JBRetest = new ButtonGroup();
        this.GroupSarampion = new ButtonGroup();
        this.groupPaperas = new ButtonGroup();
        this.groupSifilis = new ButtonGroup();
        this.groupTBC = new ButtonGroup();
        this.groupPolio = new ButtonGroup();
        this.groupTraumaCreaneo = new ButtonGroup();
        this.groupHipertencion = new ButtonGroup();
        this.groupDiabetes = new ButtonGroup();
        this.groupDrogasToxicas = new ButtonGroup();
        this.groupMareo = new ButtonGroup();
        this.groupAmigdalitis = new ButtonGroup();
        this.groupOtitis = new ButtonGroup();
        this.groupOtalgia = new ButtonGroup();
        this.groupAlergias = new ButtonGroup();
        this.groupOtorrea = new ButtonGroup();
        this.groupAcufenos = new ButtonGroup();
        this.groupVertigo = new ButtonGroup();
        this.groupHipoacusia = new ButtonGroup();
        this.groupSorderaFamiliar = new ButtonGroup();
        this.groupCirugiasdeOido = new ButtonGroup();
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
        this.JPODer250 = new JSpinner();
        this.JPOIzq250 = new JSpinner();
        this.jLabel28 = new JLabel();
        this.jLabel57 = new JLabel();
        this.jPanel7 = new JPanel();
        this.JCHBTiroCaza = new JCheckBox();
        this.JCHBRudioAmbiental = new JCheckBox();
        this.JCHBUsoAudifonos = new JCheckBox();
        this.JCHBTejo = new JCheckBox();
        this.JCHBDiscotecas = new JCheckBox();
        this.JCHBServicioMilitar = new JCheckBox();
        this.JCHBUsoDeMoto = new JCheckBox();
        this.JTP_DatosG = new JTabbedPane();
        this.jPanel9 = new JPanel();
        this.jLabel22 = new JLabel();
        this.jLabel23 = new JLabel();
        this.jLabel25 = new JLabel();
        this.jLabel24 = new JLabel();
        this.jLabel27 = new JLabel();
        this.jLabel29 = new JLabel();
        this.jLabel30 = new JLabel();
        this.JCSarampionSI = new JCheckBox();
        this.JCSarampionNO = new JCheckBox();
        this.JCPaperasNO = new JCheckBox();
        this.JCPaperasSI = new JCheckBox();
        this.JCSifilisSI = new JCheckBox();
        this.JCSifilisNO = new JCheckBox();
        this.JCTBCNO = new JCheckBox();
        this.JCTBCSI = new JCheckBox();
        this.JCPolioSI = new JCheckBox();
        this.JCPolioNO = new JCheckBox();
        this.jLabel34 = new JLabel();
        this.jLabel33 = new JLabel();
        this.jLabel32 = new JLabel();
        this.jLabel26 = new JLabel();
        this.jLabel31 = new JLabel();
        this.jLabel36 = new JLabel();
        this.jLabel35 = new JLabel();
        this.JCTraumaDeCraneoSI = new JCheckBox();
        this.JCTraumaDeCraneoNO = new JCheckBox();
        this.JCHipertencionArterialNO = new JCheckBox();
        this.JCHipertencionArterialSI = new JCheckBox();
        this.JCDiabetesSI = new JCheckBox();
        this.JCDiabetesNO = new JCheckBox();
        this.JCDrogastoxicasNO = new JCheckBox();
        this.JCDrogastoxicasSI = new JCheckBox();
        this.JCMareoSI = new JCheckBox();
        this.JCMareoNO = new JCheckBox();
        this.jLabel37 = new JLabel();
        this.jLabel38 = new JLabel();
        this.jLabel39 = new JLabel();
        this.jLabel40 = new JLabel();
        this.jLabel41 = new JLabel();
        this.jLabel42 = new JLabel();
        this.jLabel43 = new JLabel();
        this.JCAmigdalitisSI = new JCheckBox();
        this.JCAmigdalitisNO = new JCheckBox();
        this.JCOtitisNO = new JCheckBox();
        this.JCOtitisSI = new JCheckBox();
        this.JCOtalgiaSI = new JCheckBox();
        this.JCOtalgiaNO = new JCheckBox();
        this.JCAlergiasNO = new JCheckBox();
        this.JCAlergiasSI = new JCheckBox();
        this.JCOtorreaSI = new JCheckBox();
        this.JCOtorreaNO = new JCheckBox();
        this.jLabel44 = new JLabel();
        this.jLabel45 = new JLabel();
        this.jLabel46 = new JLabel();
        this.jLabel47 = new JLabel();
        this.jLabel48 = new JLabel();
        this.jLabel49 = new JLabel();
        this.jLabel50 = new JLabel();
        this.JCAcufenosNO = new JCheckBox();
        this.JCAcufenosSI = new JCheckBox();
        this.JCVertigoSI = new JCheckBox();
        this.JCHipoacusiaSI = new JCheckBox();
        this.JCVertigoNO = new JCheckBox();
        this.JCHipoacusiaNO = new JCheckBox();
        this.JCSordelaFamiliarSI = new JCheckBox();
        this.JCSordelaFamiliarNO = new JCheckBox();
        this.JCCirugiasOidoNO = new JCheckBox();
        this.JCCirugiasOidoSI = new JCheckBox();
        this.jScrollPane6 = new JScrollPane();
        this.JTObservaciones = new JTextArea();
        this.jPanel10 = new JPanel();
        this.jPanel11 = new JPanel();
        this.jScrollPane7 = new JScrollPane();
        this.JTObservacionesPresbiacusia = new JTextArea();
        this.jPanel12 = new JPanel();
        this.jLabel51 = new JLabel();
        this.jLabel52 = new JLabel();
        this.jLabel53 = new JLabel();
        this.jLabel54 = new JLabel();
        this.jLabel55 = new JLabel();
        this.jLabel56 = new JLabel();
        this.jTEliOi = new JTextField();
        this.jTLarsenOi = new JTextField();
        this.jTSalOi = new JTextField();
        this.jTGatiso = new JTextField();
        this.jTEliOd = new JTextField();
        this.jTLarsenOd = new JTextField();
        this.jTSalOd = new JTextField();
        this.jScrollPane8 = new JScrollPane();
        this.JTORecomendacionesPresbiacusia = new JTextArea();
        this.jpDiagnostico = new JPanel();
        this.jPanel8 = new JPanel();
        this.jLbImg2 = new JLabel();
        this.jLbImg1 = new JLabel();
        this.JPInterpretacion = new JPanel();
        this.JCResultado = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
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
        setBorder(BorderFactory.createTitledBorder((Border) null, "EXAMEN DE AUDIOMETRÍA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setAutoscrolls(true);
        setName("jifaudiometria_so_nuevo");
        this.jTabbedPane1.setForeground(new Color(255, 0, 0));
        this.jTabbedPane1.setAutoscrolls(true);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setAutoscrolls(true);
        this.JPDatosAudio.setBorder(BorderFactory.createTitledBorder(""));
        this.JPODer500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer500.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.1
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPODer500StateChanged(evt);
            }
        });
        this.JPODer1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer1000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.2
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPODer1000StateChanged(evt);
            }
        });
        this.JPODer2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer2000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.3
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPODer2000StateChanged(evt);
            }
        });
        this.JPODer3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer3000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.4
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPODer3000StateChanged(evt);
            }
        });
        this.JPODer4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer4000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.5
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPODer4000StateChanged(evt);
            }
        });
        this.JPODer6000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer6000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.6
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPODer6000StateChanged(evt);
            }
        });
        this.JPODer8000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq500.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.7
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPOIzq500StateChanged(evt);
            }
        });
        this.JPOIzq1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq1000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.8
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPOIzq1000StateChanged(evt);
            }
        });
        this.JPOIzq2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq2000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.9
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPOIzq2000StateChanged(evt);
            }
        });
        this.JPOIzq3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq3000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.10
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPOIzq3000StateChanged(evt);
            }
        });
        this.JPOIzq4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq4000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.11
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPOIzq4000StateChanged(evt);
            }
        });
        this.JPOIzq6000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq6000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.12
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPOIzq6000StateChanged(evt);
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
        this.JBGrabarRes.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.13
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JBGrabarResActionPerformed(evt);
            }
        });
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("Utiliza elementos de protección auditiva? ");
        this.JBElementos.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 11));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.14
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JRBNoActionPerformed(evt);
            }
        });
        this.JBElementos.add(this.JRBInsercion);
        this.JRBInsercion.setFont(new Font("Arial", 1, 11));
        this.JRBInsercion.setText("Inserción");
        this.JRBInsercion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.15
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JRBInsercionActionPerformed(evt);
            }
        });
        this.JBElementos.add(this.JRBCopa);
        this.JRBCopa.setFont(new Font("Arial", 1, 11));
        this.JRBCopa.setText("Copa");
        this.JRBCopa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.16
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JRBCopaActionPerformed(evt);
            }
        });
        this.JBElementos.add(this.JRBOtro);
        this.JRBOtro.setFont(new Font("Arial", 1, 11));
        this.JRBOtro.setText("Otro");
        this.JRBOtro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.17
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JRBOtroActionPerformed(evt);
            }
        });
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("En la otoscopia se observa tapon auditivo:");
        this.JBAutoscopia.add(this.JRBSi_Autoscopia);
        this.JRBSi_Autoscopia.setFont(new Font("Arial", 1, 11));
        this.JRBSi_Autoscopia.setText("Si");
        this.JRBSi_Autoscopia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.18
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JRBSi_AutoscopiaActionPerformed(evt);
            }
        });
        this.JBAutoscopia.add(this.JRBNo_Autoscopia);
        this.JRBNo_Autoscopia.setFont(new Font("Arial", 1, 11));
        this.JRBNo_Autoscopia.setSelected(true);
        this.JRBNo_Autoscopia.setText("No");
        this.JRBNo_Autoscopia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.19
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JRBNo_AutoscopiaActionPerformed(evt);
            }
        });
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setText("Retest?");
        this.JBRetest.add(this.JRBSi_Retest);
        this.JRBSi_Retest.setFont(new Font("Arial", 1, 11));
        this.JRBSi_Retest.setText("Si");
        this.JRBSi_Retest.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.20
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JRBSi_RetestActionPerformed(evt);
            }
        });
        this.JBRetest.add(this.JRBNo_Retest);
        this.JRBNo_Retest.setFont(new Font("Arial", 1, 11));
        this.JRBNo_Retest.setSelected(true);
        this.JRBNo_Retest.setText("No");
        this.JRBNo_Retest.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.21
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JRBNo_RetestActionPerformed(evt);
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
        this.JCHBPromedio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.22
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHBPromedioActionPerformed(evt);
            }
        });
        this.JCHBLineaB.setFont(new Font("Arial", 1, 11));
        this.JCHBLineaB.setText("Línea base?");
        this.JCHBLineaB.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.23
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHBLineaBActionPerformed(evt);
            }
        });
        this.JPODer250.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPODer250.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.24
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPODer250StateChanged(evt);
            }
        });
        this.JPOIzq250.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JPOIzq250.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.25
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JPOIzq250StateChanged(evt);
            }
        });
        this.jLabel28.setFont(new Font("Arial", 1, 12));
        this.jLabel28.setForeground(new Color(255, 51, 255));
        this.jLabel28.setText("250");
        this.jLabel57.setFont(new Font("Arial", 1, 12));
        this.jLabel57.setForeground(new Color(0, 0, 255));
        this.jLabel57.setText("Promedio Binaural :");
        GroupLayout JPDatosAudioLayout = new GroupLayout(this.JPDatosAudio);
        this.JPDatosAudio.setLayout(JPDatosAudioLayout);
        JPDatosAudioLayout.setHorizontalGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPODer250, -2, 55, -2).addComponent(this.jLabel28).addComponent(this.JPOIzq250, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPODer500, -2, 55, -2).addComponent(this.jLabel3).addComponent(this.JPOIzq500, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, -2, 43, -2).addComponent(this.JPODer1000, -2, 55, -2).addComponent(this.JPOIzq1000, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPOIzq2000, -2, 55, -2).addComponent(this.JPODer2000, -2, 55, -2).addComponent(this.jLabel5, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPOIzq3000, -2, 55, -2).addComponent(this.JPODer3000, -2, 55, -2).addComponent(this.jLabel6, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPOIzq4000, -2, 55, -2).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7, -2, 43, -2).addComponent(this.JPODer4000, -2, 55, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8, -2, 43, -2).addComponent(this.JPODer6000, -2, 55, -2).addComponent(this.JPOIzq6000, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9, -2, 43, -2).addComponent(this.JPODer8000, -2, 55, -2).addComponent(this.JPOIzq8000, -2, 55, -2)).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel10, -2, 71, -2).addGap(12, 12, 12)).addGroup(JPDatosAudioLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTFPromedioOIzq, -2, 56, -2).addComponent(this.JFTFPromedioODer, -2, 56, -2))))).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel13, -2, 54, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi_Retest).addGap(10, 10, 10).addComponent(this.JRBNo_Retest).addGap(18, 18, 18).addComponent(this.JCHBLineaB).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBPromedio)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel11).addGap(10, 10, 10).addComponent(this.JRBNo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBOtro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBInsercion))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBCopa)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel57, -2, 193, -2).addGap(21, 21, 21))).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel12, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSi_Autoscopia).addGap(12, 12, 12).addComponent(this.JRBNo_Autoscopia))).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGrabarRes, GroupLayout.Alignment.TRAILING, -2, 180, -2).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -2, 180, -2)).addGap(0, 0, 0)));
        JPDatosAudioLayout.setVerticalGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.JRBSi_Retest).addComponent(this.JRBNo_Retest).addComponent(this.JCHBLineaB).addComponent(this.JCHBPromedio)).addGap(6, 6, 6).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo).addComponent(this.JRBOtro).addComponent(this.JRBInsercion).addComponent(this.JRBCopa))).addGap(8, 8, 8)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addContainerGap().addComponent(this.JBGrabarRes, -2, 45, -2).addGap(12, 12, 12))).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -2, 108, -2).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabel5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPODer2000, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPOIzq2000, -2, 31, -2)).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosAudioLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPODer4000, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPOIzq4000, -2, 31, -2)).addGroup(GroupLayout.Alignment.LEADING, JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPODer8000, -2, 31, -2).addComponent(this.JFTFPromedioODer, -2, 34, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFPromedioOIzq, -2, 28, -2)).addGroup(GroupLayout.Alignment.LEADING, JPDatosAudioLayout.createSequentialGroup().addComponent(this.JPODer6000, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPOIzq6000, -2, 31, -2).addComponent(this.JPOIzq8000, -2, 31, -2))))).addGroup(JPDatosAudioLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JPODer1000, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPOIzq1000, -2, 31, -2)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPODer500, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPOIzq500, -2, 31, -2)).addGroup(JPDatosAudioLayout.createSequentialGroup().addComponent(this.jLabel28).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPODer250, -2, 31, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JPOIzq250, -2, 31, -2).addComponent(this.jLabel1)))).addGap(11, 11, 11)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosAudioLayout.createSequentialGroup().addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jLabel7).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel10)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPODer3000, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPOIzq3000, -2, 31, -2).addGap(12, 12, 12))).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel57).addGroup(JPDatosAudioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.JRBSi_Autoscopia).addComponent(this.JRBNo_Autoscopia))))).addGap(0, 0, 32767)));
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "Exposición a Ruido No Industrial", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JCHBTiroCaza.setFont(new Font("Arial", 1, 11));
        this.JCHBTiroCaza.setText("Tiro o Caza");
        this.JCHBTiroCaza.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.26
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHBTiroCazaActionPerformed(evt);
            }
        });
        this.JCHBRudioAmbiental.setFont(new Font("Arial", 1, 11));
        this.JCHBRudioAmbiental.setText("Ruido Ambiental");
        this.JCHBRudioAmbiental.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.27
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHBRudioAmbientalActionPerformed(evt);
            }
        });
        this.JCHBUsoAudifonos.setFont(new Font("Arial", 1, 11));
        this.JCHBUsoAudifonos.setText("Uso de Audifonos");
        this.JCHBUsoAudifonos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.28
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHBUsoAudifonosActionPerformed(evt);
            }
        });
        this.JCHBTejo.setFont(new Font("Arial", 1, 11));
        this.JCHBTejo.setText("Tejo");
        this.JCHBTejo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.29
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHBTejoActionPerformed(evt);
            }
        });
        this.JCHBDiscotecas.setFont(new Font("Arial", 1, 11));
        this.JCHBDiscotecas.setText("Discotecas");
        this.JCHBDiscotecas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.30
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHBDiscotecasActionPerformed(evt);
            }
        });
        this.JCHBServicioMilitar.setFont(new Font("Arial", 1, 11));
        this.JCHBServicioMilitar.setText("Servicio Militar");
        this.JCHBServicioMilitar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.31
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHBServicioMilitarActionPerformed(evt);
            }
        });
        this.JCHBUsoDeMoto.setFont(new Font("Arial", 1, 11));
        this.JCHBUsoDeMoto.setText("Uso de Moto");
        this.JCHBUsoDeMoto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.32
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHBUsoDeMotoActionPerformed(evt);
            }
        });
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHBTiroCaza).addGap(12, 12, 12).addComponent(this.JCHBRudioAmbiental).addGap(12, 12, 12).addComponent(this.JCHBTejo).addGap(12, 12, 12).addComponent(this.JCHBUsoAudifonos).addGap(12, 12, 12).addComponent(this.JCHBDiscotecas).addGap(12, 12, 12).addComponent(this.JCHBServicioMilitar).addGap(12, 12, 12).addComponent(this.JCHBUsoDeMoto).addGap(0, 0, 0)));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHBTiroCaza).addComponent(this.JCHBRudioAmbiental).addComponent(this.JCHBUsoAudifonos).addComponent(this.JCHBTejo).addComponent(this.JCHBDiscotecas).addComponent(this.JCHBServicioMilitar).addComponent(this.JCHBUsoDeMoto)).addContainerGap(-1, 32767)));
        this.JTP_DatosG.setForeground(Color.red);
        this.JTP_DatosG.setFont(new Font("Arial", 1, 14));
        this.jPanel9.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));
        this.jLabel22.setFont(new Font("Arial", 1, 12));
        this.jLabel22.setForeground(new Color(0, 51, 255));
        this.jLabel22.setText("Sarampión");
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setForeground(new Color(0, 51, 255));
        this.jLabel23.setText("Paperas");
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setForeground(new Color(0, 51, 255));
        this.jLabel25.setText("Sífilis");
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setForeground(new Color(0, 51, 255));
        this.jLabel24.setText(".T.B.C");
        this.jLabel27.setFont(new Font("Arial", 1, 12));
        this.jLabel27.setForeground(new Color(0, 51, 255));
        this.jLabel27.setText("Polio");
        this.jLabel29.setFont(new Font("Arial", 1, 12));
        this.jLabel29.setForeground(new Color(255, 51, 51));
        this.jLabel29.setText("SI:");
        this.jLabel30.setFont(new Font("Arial", 1, 12));
        this.jLabel30.setForeground(new Color(255, 51, 51));
        this.jLabel30.setText("NO:");
        this.GroupSarampion.add(this.JCSarampionSI);
        this.JCSarampionSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.33
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCSarampionSIActionPerformed(evt);
            }
        });
        this.GroupSarampion.add(this.JCSarampionNO);
        this.JCSarampionNO.setSelected(true);
        this.JCSarampionNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.34
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCSarampionNOActionPerformed(evt);
            }
        });
        this.groupPaperas.add(this.JCPaperasNO);
        this.JCPaperasNO.setSelected(true);
        this.JCPaperasNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.35
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCPaperasNOActionPerformed(evt);
            }
        });
        this.groupPaperas.add(this.JCPaperasSI);
        this.JCPaperasSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.36
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCPaperasSIActionPerformed(evt);
            }
        });
        this.groupSifilis.add(this.JCSifilisSI);
        this.JCSifilisSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.37
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCSifilisSIActionPerformed(evt);
            }
        });
        this.groupSifilis.add(this.JCSifilisNO);
        this.JCSifilisNO.setSelected(true);
        this.JCSifilisNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.38
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCSifilisNOActionPerformed(evt);
            }
        });
        this.groupTBC.add(this.JCTBCNO);
        this.JCTBCNO.setSelected(true);
        this.JCTBCNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.39
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCTBCNOActionPerformed(evt);
            }
        });
        this.groupTBC.add(this.JCTBCSI);
        this.JCTBCSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.40
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCTBCSIActionPerformed(evt);
            }
        });
        this.groupPolio.add(this.JCPolioSI);
        this.JCPolioSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.41
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCPolioSIActionPerformed(evt);
            }
        });
        this.groupPolio.add(this.JCPolioNO);
        this.JCPolioNO.setSelected(true);
        this.JCPolioNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.42
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCPolioNOActionPerformed(evt);
            }
        });
        this.jLabel34.setFont(new Font("Arial", 1, 12));
        this.jLabel34.setForeground(new Color(0, 51, 255));
        this.jLabel34.setText("Trauma de Créaneo");
        this.jLabel33.setFont(new Font("Arial", 1, 12));
        this.jLabel33.setForeground(new Color(0, 51, 255));
        this.jLabel33.setText("Hipertención Arterial");
        this.jLabel32.setFont(new Font("Arial", 1, 12));
        this.jLabel32.setForeground(new Color(0, 51, 255));
        this.jLabel32.setText("Diabetes");
        this.jLabel26.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setForeground(new Color(0, 51, 255));
        this.jLabel26.setText("Drogas Ototóxicas");
        this.jLabel31.setFont(new Font("Arial", 1, 12));
        this.jLabel31.setForeground(new Color(0, 51, 255));
        this.jLabel31.setText("Mareo");
        this.jLabel36.setFont(new Font("Arial", 1, 12));
        this.jLabel36.setForeground(new Color(255, 51, 51));
        this.jLabel36.setText("SI:");
        this.jLabel35.setFont(new Font("Arial", 1, 12));
        this.jLabel35.setForeground(new Color(255, 51, 51));
        this.jLabel35.setText("NO:");
        this.groupTraumaCreaneo.add(this.JCTraumaDeCraneoSI);
        this.JCTraumaDeCraneoSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.43
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCTraumaDeCraneoSIActionPerformed(evt);
            }
        });
        this.groupTraumaCreaneo.add(this.JCTraumaDeCraneoNO);
        this.JCTraumaDeCraneoNO.setSelected(true);
        this.JCTraumaDeCraneoNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.44
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCTraumaDeCraneoNOActionPerformed(evt);
            }
        });
        this.groupHipertencion.add(this.JCHipertencionArterialNO);
        this.JCHipertencionArterialNO.setSelected(true);
        this.JCHipertencionArterialNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.45
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHipertencionArterialNOActionPerformed(evt);
            }
        });
        this.groupHipertencion.add(this.JCHipertencionArterialSI);
        this.JCHipertencionArterialSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.46
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHipertencionArterialSIActionPerformed(evt);
            }
        });
        this.groupDiabetes.add(this.JCDiabetesSI);
        this.JCDiabetesSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.47
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCDiabetesSIActionPerformed(evt);
            }
        });
        this.groupDiabetes.add(this.JCDiabetesNO);
        this.JCDiabetesNO.setSelected(true);
        this.JCDiabetesNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.48
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCDiabetesNOActionPerformed(evt);
            }
        });
        this.groupDrogasToxicas.add(this.JCDrogastoxicasNO);
        this.JCDrogastoxicasNO.setSelected(true);
        this.JCDrogastoxicasNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.49
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCDrogastoxicasNOActionPerformed(evt);
            }
        });
        this.groupDrogasToxicas.add(this.JCDrogastoxicasSI);
        this.JCDrogastoxicasSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.50
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCDrogastoxicasSIActionPerformed(evt);
            }
        });
        this.groupMareo.add(this.JCMareoSI);
        this.JCMareoSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.51
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCMareoSIActionPerformed(evt);
            }
        });
        this.groupMareo.add(this.JCMareoNO);
        this.JCMareoNO.setSelected(true);
        this.JCMareoNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.52
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCMareoNOActionPerformed(evt);
            }
        });
        this.jLabel37.setFont(new Font("Arial", 1, 12));
        this.jLabel37.setForeground(new Color(0, 51, 255));
        this.jLabel37.setText("Amigdalitis");
        this.jLabel38.setFont(new Font("Arial", 1, 12));
        this.jLabel38.setForeground(new Color(0, 51, 255));
        this.jLabel38.setText("Otitis");
        this.jLabel39.setFont(new Font("Arial", 1, 12));
        this.jLabel39.setForeground(new Color(0, 51, 255));
        this.jLabel39.setText("Otalgia");
        this.jLabel40.setFont(new Font("Arial", 1, 12));
        this.jLabel40.setForeground(new Color(0, 51, 255));
        this.jLabel40.setText("Alergias");
        this.jLabel41.setFont(new Font("Arial", 1, 12));
        this.jLabel41.setForeground(new Color(0, 51, 255));
        this.jLabel41.setText("Otorrea");
        this.jLabel42.setFont(new Font("Arial", 1, 12));
        this.jLabel42.setForeground(new Color(255, 51, 51));
        this.jLabel42.setText("SI:");
        this.jLabel43.setFont(new Font("Arial", 1, 12));
        this.jLabel43.setForeground(new Color(255, 51, 51));
        this.jLabel43.setText("NO:");
        this.groupAmigdalitis.add(this.JCAmigdalitisSI);
        this.JCAmigdalitisSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.53
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCAmigdalitisSIActionPerformed(evt);
            }
        });
        this.groupAmigdalitis.add(this.JCAmigdalitisNO);
        this.JCAmigdalitisNO.setSelected(true);
        this.JCAmigdalitisNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.54
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCAmigdalitisNOActionPerformed(evt);
            }
        });
        this.groupOtitis.add(this.JCOtitisNO);
        this.JCOtitisNO.setSelected(true);
        this.JCOtitisNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.55
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCOtitisNOActionPerformed(evt);
            }
        });
        this.groupOtitis.add(this.JCOtitisSI);
        this.JCOtitisSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.56
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCOtitisSIActionPerformed(evt);
            }
        });
        this.groupOtalgia.add(this.JCOtalgiaSI);
        this.JCOtalgiaSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.57
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCOtalgiaSIActionPerformed(evt);
            }
        });
        this.groupOtalgia.add(this.JCOtalgiaNO);
        this.JCOtalgiaNO.setSelected(true);
        this.JCOtalgiaNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.58
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCOtalgiaNOActionPerformed(evt);
            }
        });
        this.groupAlergias.add(this.JCAlergiasNO);
        this.JCAlergiasNO.setSelected(true);
        this.JCAlergiasNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.59
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCAlergiasNOActionPerformed(evt);
            }
        });
        this.groupAlergias.add(this.JCAlergiasSI);
        this.JCAlergiasSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.60
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCAlergiasSIActionPerformed(evt);
            }
        });
        this.groupOtorrea.add(this.JCOtorreaSI);
        this.JCOtorreaSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.61
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCOtorreaSIActionPerformed(evt);
            }
        });
        this.groupOtorrea.add(this.JCOtorreaNO);
        this.JCOtorreaNO.setSelected(true);
        this.JCOtorreaNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.62
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCOtorreaNOActionPerformed(evt);
            }
        });
        this.jLabel44.setFont(new Font("Arial", 1, 12));
        this.jLabel44.setForeground(new Color(0, 51, 255));
        this.jLabel44.setText("Acúfenos");
        this.jLabel45.setFont(new Font("Arial", 1, 12));
        this.jLabel45.setForeground(new Color(0, 51, 255));
        this.jLabel45.setText("Vértigo");
        this.jLabel46.setFont(new Font("Arial", 1, 12));
        this.jLabel46.setForeground(new Color(0, 51, 255));
        this.jLabel46.setText("Hipoacusia");
        this.jLabel47.setFont(new Font("Arial", 1, 12));
        this.jLabel47.setForeground(new Color(0, 51, 255));
        this.jLabel47.setText("Sordera Familiar");
        this.jLabel48.setFont(new Font("Arial", 1, 12));
        this.jLabel48.setForeground(new Color(0, 51, 255));
        this.jLabel48.setText("Cirugías de Oído");
        this.jLabel49.setFont(new Font("Arial", 1, 12));
        this.jLabel49.setForeground(new Color(255, 51, 51));
        this.jLabel49.setText("SI:");
        this.jLabel50.setFont(new Font("Arial", 1, 12));
        this.jLabel50.setForeground(new Color(255, 51, 51));
        this.jLabel50.setText("NO:");
        this.groupAcufenos.add(this.JCAcufenosNO);
        this.JCAcufenosNO.setSelected(true);
        this.JCAcufenosNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.63
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCAcufenosNOActionPerformed(evt);
            }
        });
        this.groupAcufenos.add(this.JCAcufenosSI);
        this.JCAcufenosSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.64
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCAcufenosSIActionPerformed(evt);
            }
        });
        this.groupVertigo.add(this.JCVertigoSI);
        this.JCVertigoSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.65
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCVertigoSIActionPerformed(evt);
            }
        });
        this.groupHipoacusia.add(this.JCHipoacusiaSI);
        this.JCHipoacusiaSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.66
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHipoacusiaSIActionPerformed(evt);
            }
        });
        this.groupVertigo.add(this.JCVertigoNO);
        this.JCVertigoNO.setSelected(true);
        this.JCVertigoNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.67
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCVertigoNOActionPerformed(evt);
            }
        });
        this.groupHipoacusia.add(this.JCHipoacusiaNO);
        this.JCHipoacusiaNO.setSelected(true);
        this.JCHipoacusiaNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.68
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCHipoacusiaNOActionPerformed(evt);
            }
        });
        this.groupSorderaFamiliar.add(this.JCSordelaFamiliarSI);
        this.JCSordelaFamiliarSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.69
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCSordelaFamiliarSIActionPerformed(evt);
            }
        });
        this.groupSorderaFamiliar.add(this.JCSordelaFamiliarNO);
        this.JCSordelaFamiliarNO.setSelected(true);
        this.JCSordelaFamiliarNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.70
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCSordelaFamiliarNOActionPerformed(evt);
            }
        });
        this.groupCirugiasdeOido.add(this.JCCirugiasOidoNO);
        this.JCCirugiasOidoNO.setSelected(true);
        this.JCCirugiasOidoNO.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.71
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCCirugiasOidoNOActionPerformed(evt);
            }
        });
        this.groupCirugiasdeOido.add(this.JCCirugiasOidoSI);
        this.JCCirugiasOidoSI.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.72
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JCCirugiasOidoSIActionPerformed(evt);
            }
        });
        this.JTObservaciones.setColumns(20);
        this.JTObservaciones.setRows(5);
        this.JTObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.jScrollPane6.setViewportView(this.JTObservaciones);
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane6, -2, 679, -2).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel22, -1, -1, 32767).addComponent(this.jLabel23, -1, -1, 32767))).addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel25, GroupLayout.Alignment.TRAILING, -2, 61, -2).addComponent(this.jLabel24, GroupLayout.Alignment.TRAILING, -2, 61, -2).addComponent(this.jLabel27, GroupLayout.Alignment.TRAILING, -2, 61, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCTBCSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCTBCNO)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCSifilisSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCSifilisNO)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCPaperasSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCPaperasNO)).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel29, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCSarampionSI, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCSarampionNO).addComponent(this.jLabel30)))).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCPolioSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCPolioNO))).addGap(18, 18, 18).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel34).addComponent(this.jLabel33).addComponent(this.jLabel32, GroupLayout.Alignment.TRAILING, -2, 116, -2)).addComponent(this.jLabel26, GroupLayout.Alignment.TRAILING, -2, 116, -2)).addComponent(this.jLabel31, GroupLayout.Alignment.TRAILING, -2, 117, -2)).addGap(18, 18, 18).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCDrogastoxicasSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCDrogastoxicasNO)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCDiabetesSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCDiabetesNO)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCHipertencionArterialSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHipertencionArterialNO)).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel36, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCTraumaDeCraneoSI, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCTraumaDeCraneoNO).addComponent(this.jLabel35)))).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCMareoSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCMareoNO))).addGap(18, 18, 18).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel39, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel38, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel37, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel40, -1, -1, 32767).addComponent(this.jLabel41, -1, -1, 32767)).addGap(33, 33, 33).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCAlergiasSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCAlergiasNO)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCOtalgiaSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCOtalgiaNO)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCOtitisSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCOtitisNO)).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel42, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCAmigdalitisSI, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCAmigdalitisNO).addComponent(this.jLabel43)))).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCOtorreaSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCOtorreaNO))).addGap(18, 18, 18).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel48, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel47, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addComponent(this.jLabel44, -2, 94, -2).addComponent(this.jLabel45, -2, 94, -2).addComponent(this.jLabel46, -2, 93, -2)).addGap(29, 29, 29).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCSordelaFamiliarSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCSordelaFamiliarNO)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCHipoacusiaSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHipoacusiaNO)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCVertigoSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCVertigoNO)).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel49, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCAcufenosSI, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCAcufenosNO).addComponent(this.jLabel50)))).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCCirugiasOidoSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCCirugiasOidoNO))))).addContainerGap(-1, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel30).addComponent(this.jLabel29, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCSarampionSI).addComponent(this.JCSarampionNO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCPaperasSI).addComponent(this.JCPaperasNO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCSifilisSI).addComponent(this.JCSifilisNO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCTBCSI).addComponent(this.JCTBCNO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCPolioSI).addComponent(this.JCPolioNO))).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.jLabel22).addGap(11, 11, 11).addComponent(this.jLabel23).addGap(11, 11, 11).addComponent(this.jLabel25).addGap(11, 11, 11).addComponent(this.jLabel24).addGap(11, 11, 11).addComponent(this.jLabel27)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.jLabel34).addGap(11, 11, 11).addComponent(this.jLabel33).addGap(11, 11, 11).addComponent(this.jLabel32).addGap(11, 11, 11).addComponent(this.jLabel26).addGap(11, 11, 11).addComponent(this.jLabel31)))).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel35).addComponent(this.jLabel36, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel37, -1, -1, 32767).addComponent(this.JCTraumaDeCraneoSI, -1, -1, 32767).addComponent(this.JCTraumaDeCraneoNO, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel38, -1, -1, 32767).addComponent(this.JCHipertencionArterialSI, -1, -1, 32767).addComponent(this.JCHipertencionArterialNO, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel39, -1, -1, 32767).addComponent(this.JCDiabetesSI, -1, -1, 32767).addComponent(this.JCDiabetesNO, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel40, -1, -1, 32767).addComponent(this.JCDrogastoxicasSI, -1, -1, 32767).addComponent(this.JCDrogastoxicasNO, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCMareoSI, -1, -1, 32767).addComponent(this.JCMareoNO, -1, -1, 32767).addComponent(this.jLabel41, -1, -1, 32767))).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel43).addComponent(this.jLabel42, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCAmigdalitisSI, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JCAmigdalitisNO, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jLabel44, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCOtitisSI, -1, -1, 32767).addComponent(this.JCOtitisNO, -1, -1, 32767).addComponent(this.jLabel45, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCOtalgiaSI, -1, -1, 32767).addComponent(this.JCOtalgiaNO, -1, -1, 32767).addComponent(this.jLabel46, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel47, -1, -1, 32767).addComponent(this.JCAlergiasSI, -1, -1, 32767).addComponent(this.JCAlergiasNO, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCOtorreaSI, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JCOtorreaNO, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jLabel48, -1, -1, 32767))).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel50).addComponent(this.jLabel49, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCAcufenosSI).addComponent(this.JCAcufenosNO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCVertigoSI).addComponent(this.JCVertigoNO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHipoacusiaSI).addComponent(this.JCHipoacusiaNO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCSordelaFamiliarSI).addComponent(this.JCSordelaFamiliarNO)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCCirugiasOidoSI).addComponent(this.JCCirugiasOidoNO)))).addGap(18, 18, 18).addComponent(this.jScrollPane6, -2, 58, -2).addContainerGap(-1, 32767)));
        this.JTP_DatosG.addTab("ANTECEDENTES PERSONALES", this.jPanel9);
        this.jPanel11.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        this.JTObservacionesPresbiacusia.setColumns(20);
        this.JTObservacionesPresbiacusia.setRows(5);
        this.JTObservacionesPresbiacusia.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane7.setViewportView(this.JTObservacionesPresbiacusia);
        this.jPanel12.setBorder(new LineBorder(new Color(204, 204, 204), 1, true));
        this.jLabel51.setFont(new Font("Arial", 1, 12));
        this.jLabel51.setForeground(new Color(0, 51, 255));
        this.jLabel51.setText("ELI:");
        this.jLabel52.setFont(new Font("Arial", 1, 12));
        this.jLabel52.setForeground(new Color(0, 51, 255));
        this.jLabel52.setText("LARSEN:");
        this.jLabel53.setFont(new Font("Arial", 1, 12));
        this.jLabel53.setForeground(new Color(0, 51, 255));
        this.jLabel53.setText("SAL:");
        this.jLabel54.setFont(new Font("Arial", 1, 12));
        this.jLabel54.setForeground(new Color(0, 51, 255));
        this.jLabel54.setText("CAOCH - GATISO");
        this.jLabel55.setFont(new Font("Arial", 1, 12));
        this.jLabel55.setForeground(Color.red);
        this.jLabel55.setText("O.I.");
        this.jLabel56.setFont(new Font("Arial", 1, 12));
        this.jLabel56.setForeground(Color.red);
        this.jLabel56.setText("O.D.");
        this.jTLarsenOi.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.73
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.jTLarsenOiActionPerformed(evt);
            }
        });
        this.jTGatiso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.74
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.jTGatisoActionPerformed(evt);
            }
        });
        GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
        this.jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel12Layout.createSequentialGroup().addGap(134, 134, 134).addComponent(this.jLabel55, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel56, -1, 150, 32767).addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTEliOd, -2, 92, -2).addComponent(this.jTLarsenOd, -2, 92, -2).addComponent(this.jTSalOd, -2, 92, -2)).addGap(0, 0, 32767))).addContainerGap()).addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel51, -1, -1, 32767).addComponent(this.jLabel54, -1, 102, 32767).addComponent(this.jLabel53, -1, 102, 32767).addComponent(this.jLabel52, -1, 102, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTEliOi, GroupLayout.Alignment.TRAILING, -2, 92, -2).addComponent(this.jTLarsenOi, GroupLayout.Alignment.TRAILING, -2, 92, -2).addComponent(this.jTSalOi, GroupLayout.Alignment.TRAILING, -2, 92, -2)).addComponent(this.jTGatiso, -2, 187, -2)).addContainerGap(65, 32767)))));
        jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup().addGap(9, 9, 9).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel55).addComponent(this.jLabel56)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel51, -2, 23, -2).addGroup(jPanel12Layout.createSequentialGroup().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTEliOi, -2, 23, -2).addComponent(this.jTEliOd, -2, 23, -2)).addGap(1, 1, 1))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel52, -2, 23, -2).addComponent(this.jTLarsenOi, -2, 23, -2).addComponent(this.jTLarsenOd, -2, 23, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel53, -2, 23, -2).addComponent(this.jTSalOi, -2, 23, -2).addComponent(this.jTSalOd, -2, 23, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel54, -2, 23, -2).addComponent(this.jTGatiso, -2, 23, -2)).addContainerGap()));
        this.JTORecomendacionesPresbiacusia.setColumns(20);
        this.JTORecomendacionesPresbiacusia.setRows(5);
        this.JTORecomendacionesPresbiacusia.setBorder(BorderFactory.createTitledBorder((Border) null, "Recomendaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane8.setViewportView(this.JTORecomendacionesPresbiacusia);
        GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
        this.jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane8).addGroup(jPanel11Layout.createSequentialGroup().addComponent(this.jPanel12, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane7, -1, 420, 32767))).addContainerGap()));
        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel12, -2, 148, -2).addComponent(this.jScrollPane7)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane8, -1, 88, 32767).addContainerGap()));
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel11, -1, -1, 32767).addContainerGap()));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jPanel11, -1, -1, 32767).addContainerGap()));
        this.JTP_DatosG.addTab("PRESBIACUSIA", this.jPanel10);
        GroupLayout jpDiagnosticoLayout = new GroupLayout(this.jpDiagnostico);
        this.jpDiagnostico.setLayout(jpDiagnosticoLayout);
        jpDiagnosticoLayout.setHorizontalGroup(jpDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        jpDiagnosticoLayout.setVerticalGroup(jpDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        this.JTP_DatosG.addTab("DIAGNÓSTICO", this.jpDiagnostico);
        this.jPanel8.setForeground(new Color(204, 204, 204));
        this.jLbImg2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/imgfondo359x215.png")));
        this.jLbImg1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/imgfondo359x215.png")));
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLbImg1, -2, 374, -2).addGap(18, 18, 18).addComponent(this.jLbImg2, -2, 379, -2).addContainerGap()));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLbImg2, -1, 234, 32767).addComponent(this.jLbImg1, -1, -1, 32767)).addContainerGap(37, 32767)));
        this.JTP_DatosG.addTab("GRAFICA", this.jPanel8);
        this.JPInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INTERPRETACIÓN MÉDICA", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCResultado.setFont(new Font("Arial", 1, 12));
        this.JCResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADOS", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        GroupLayout JPInterpretacionLayout = new GroupLayout(this.JPInterpretacion);
        this.JPInterpretacion.setLayout(JPInterpretacionLayout);
        JPInterpretacionLayout.setHorizontalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInterpretacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCResultado, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1).addContainerGap()));
        JPInterpretacionLayout.setVerticalGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInterpretacionLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPInterpretacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1).addComponent(this.JCResultado, -1, 47, 32767)).addContainerGap(-1, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTP_DatosG, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.jPanel7, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPDatosAudio, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPInterpretacion, -1, -1, 32767)).addGap(140, 140, 140)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel7, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPDatosAudio, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_DatosG, -2, 310, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPInterpretacion, -2, -1, -2).addGap(129, 129, 129)));
        this.jTabbedPane1.addTab("DATOS", this.jPanel1);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "EVALUACIÓN DE LA AUDICIÓN VÍA ÓSEA", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(0, 102, 0));
        this.jLabel14.setText("Oido Derecho");
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(0, 102, 0));
        this.jLabel15.setText("Oido Izquierdo");
        this.JSPIzquierdo250.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo250.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.75
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPIzquierdo250StateChanged(evt);
            }
        });
        this.JSPDerecho500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho500.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.76
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPDerecho500StateChanged(evt);
            }
        });
        this.JSPIzquierdo500.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo500.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.77
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPIzquierdo500StateChanged(evt);
            }
        });
        this.JSPDerecho1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho1000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.78
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPDerecho1000StateChanged(evt);
            }
        });
        this.JSPIzquierdo1000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo1000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.79
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPIzquierdo1000StateChanged(evt);
            }
        });
        this.JSPDerecho2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho2000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.80
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPDerecho2000StateChanged(evt);
            }
        });
        this.JSPIzquierdo2000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo2000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.81
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPIzquierdo2000StateChanged(evt);
            }
        });
        this.JSPDerecho3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho3000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.82
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPDerecho3000StateChanged(evt);
            }
        });
        this.JSPIzquierdo3000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo3000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.83
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPIzquierdo3000StateChanged(evt);
            }
        });
        this.JSPDerecho4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho4000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.84
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPDerecho4000StateChanged(evt);
            }
        });
        this.JSPIzquierdo4000.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPIzquierdo4000.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.85
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPIzquierdo4000StateChanged(evt);
            }
        });
        this.JSPDerecho250.setModel(new SpinnerNumberModel(0, (Comparable) null, 100, 5));
        this.JSPDerecho250.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.86
            public void stateChanged(ChangeEvent evt) {
                JPSo_Audiometria_nueva1.this.JSPDerecho250StateChanged(evt);
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
        this.JBGrabarViaOsea.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.87
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JBGrabarViaOseaActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(604, 604, 604).addComponent(this.JBGrabarViaOsea, -2, 180, -2).addGap(0, 0, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14, GroupLayout.Alignment.TRAILING).addComponent(this.jLabel15, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel21, -2, 43, -2).addComponent(this.JSPDerecho250, -2, 55, -2)).addComponent(this.JSPIzquierdo250, -2, 55, -2)).addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDerecho500, -2, 55, -2).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel16).addGap(16, 16, 16))).addComponent(this.JSPIzquierdo500, GroupLayout.Alignment.LEADING, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDerecho1000, -2, 55, -2).addComponent(this.jLabel17, -2, 43, -2)).addComponent(this.JSPIzquierdo1000, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDerecho2000, GroupLayout.Alignment.TRAILING, -2, 55, -2).addComponent(this.jLabel18, GroupLayout.Alignment.TRAILING, -2, 43, -2)).addComponent(this.JSPIzquierdo2000, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel19, -2, 43, -2).addComponent(this.JSPDerecho3000, -2, 55, -2)).addComponent(this.JSPIzquierdo3000, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel20, -2, 43, -2).addComponent(this.JSPDerecho4000, -2, 55, -2).addComponent(this.JSPIzquierdo4000, -2, 55, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3))).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.jLabel17).addComponent(this.jLabel18).addComponent(this.jLabel19).addComponent(this.jLabel20).addComponent(this.jLabel21)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPDerecho500, -2, 31, -2).addComponent(this.JSPDerecho1000, -2, 31, -2).addComponent(this.JSPDerecho2000, -2, 31, -2).addComponent(this.JSPDerecho3000, -2, 31, -2).addComponent(this.JSPDerecho4000, -2, 31, -2).addComponent(this.JSPDerecho250, -2, 31, -2).addComponent(this.jLabel14)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPIzquierdo500, -2, 31, -2).addComponent(this.JSPIzquierdo250, -2, 31, -2).addComponent(this.JSPIzquierdo1000, -2, 31, -2).addComponent(this.JSPIzquierdo2000, -2, 31, -2).addComponent(this.JSPIzquierdo3000, -2, 31, -2).addComponent(this.JSPIzquierdo4000, -2, 31, -2).addComponent(this.jLabel15))).addComponent(this.jScrollPane3, -2, 88, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabarViaOsea, -2, 45, -2).addContainerGap()));
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
        this.JTAObservacionTestWeber.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionTestWeber.setRows(5);
        this.JTAObservacionTestWeber.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSERVACIÓN", 1, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.jScrollPane5.setViewportView(this.JTAObservacionTestWeber);
        this.JBGrabarTestWeber.setFont(new Font("Arial", 1, 12));
        this.JBGrabarTestWeber.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarTestWeber.setText("Grabar");
        this.JBGrabarTestWeber.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.88
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JBGrabarTestWeberActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane5).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.JCBWeber250, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBWeber500, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBWeber1000, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBWeber2000, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBWeber3000, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBWeber4000, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBGrabarTestWeber, -1, -1, 32767))).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBWeber250, -2, 45, -2).addComponent(this.JCBWeber500, -2, 45, -2).addComponent(this.JCBWeber1000, -2, 45, -2).addComponent(this.JCBWeber2000, -2, 45, -2).addComponent(this.JCBWeber3000, -2, 45, -2).addComponent(this.JCBWeber4000, -2, 45, -2)).addComponent(this.JBGrabarTestWeber, -2, 45, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane5, -2, 61, -2).addContainerGap()));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel6, -1, -1, 32767)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addContainerGap()));
        this.jTabbedPane1.addTab("VIA OSEA", this.jPanel2);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "EVALUACIÓN DEL OÍDO Y OTOSCOPIA", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE (AMPLIACIÓN DE HALLAZGO)", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTAObservacionOtoscopia.setColumns(20);
        this.JTAObservacionOtoscopia.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionOtoscopia.setRows(5);
        this.jScrollPane4.setViewportView(this.JTAObservacionOtoscopia);
        this.JBGrabarOtoscopia.setFont(new Font("Arial", 1, 12));
        this.JBGrabarOtoscopia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarOtoscopia.setText("Grabar");
        this.JBGrabarOtoscopia.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.89
            public void actionPerformed(ActionEvent evt) {
                JPSo_Audiometria_nueva1.this.JBGrabarOtoscopiaActionPerformed(evt);
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
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBPabellon, 0, -1, 32767).addComponent(this.JCBConductos, -2, 288, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTimpano, 0, -1, 32767).addComponent(this.JCBLobulo, -2, 288, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBGrabarOtoscopia, -1, -1, 32767).addComponent(this.jScrollPane4, -2, 261, -2)).addContainerGap(112, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPabellon, -2, -1, -2).addComponent(this.JCBTimpano, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConductos, -2, -1, -2).addComponent(this.JCBLobulo, -2, -1, -2))).addComponent(this.jScrollPane4, -2, 0, 32767)).addGap(18, 18, 18).addComponent(this.JBGrabarOtoscopia, -2, 45, -2).addContainerGap(-1, 32767)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -1, -1, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel5, -2, -1, -2).addContainerGap(586, 32767)));
        this.jTabbedPane1.addTab("OTOSCOPIA", this.jPanel3);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.90
            public void mouseClicked(MouseEvent evt) {
                JPSo_Audiometria_nueva1.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 868, -2)));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 609, -2).addContainerGap()));
        this.jTabbedPane1.addTab("HISTÓRICO", this.JPHistorico);
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
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBoshaOD, -2, 193, -2).addComponent(this.JCBoshaOI, -2, 193, -2).addComponent(this.JCGatODC1, -2, 193, -2).addComponent(this.JCGatOIC1, -2, 193, -2)).addGap(84, 84, 84).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCGatODC2, -2, 193, -2).addComponent(this.JCGatOIC2, -2, 193, -2).addComponent(this.JCGatOIC3, -2, 193, -2).addComponent(this.JCGatODC3, -2, 193, -2)).addGap(62, 62, 62).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCGatOIC5, -2, 193, -2).addComponent(this.JCGatODC5, -2, 193, -2).addComponent(this.JCGatOIC4, -2, 193, -2).addComponent(this.JCGatODC4, -2, 193, -2)).addContainerGap(118, 32767)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBoshaOD, -2, 43, -2).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCGatODC2, -2, -1, -2).addComponent(this.JCGatODC4, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBoshaOI, -2, -1, -2).addComponent(this.JCGatOIC2, -2, -1, -2).addComponent(this.JCGatOIC4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCGatODC1, -2, -1, -2).addComponent(this.JCGatOIC3, -2, -1, -2).addComponent(this.JCGatODC5, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCGatOIC1, -2, -1, -2).addComponent(this.JCGatODC3, -2, -1, -2).addComponent(this.JCGatOIC5, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JPInformacion, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JPInformacion, -2, 1, -2).addContainerGap()));
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
        if (!this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioODer.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPODer500.getValue().toString()), Integer.parseInt(this.JPODer1000.getValue().toString()), Integer.parseInt(this.JPODer2000.getValue().toString()), Integer.parseInt(this.JPODer3000.getValue().toString()), 0L)));
            if (Double.parseDouble(this.JFTFPromedioODer.getValue().toString()) > 25.0d) {
                this.JCBoshaOD.setSelectedItem("CASO PARA ESTUDIO");
            } else {
                this.JCBoshaOD.setSelectedItem("NORMAL");
            }
            mVariableC3OD(this.JCGatODC3);
            mVariableC3OI(this.JCGatOIC3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPODer4000StateChanged(ChangeEvent evt) {
        if (this.JCHBPromedio.isSelected()) {
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
        if (!this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioOIzq.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPOIzq500.getValue().toString()), Integer.parseInt(this.JPOIzq1000.getValue().toString()), Integer.parseInt(this.JPOIzq2000.getValue().toString()), Integer.parseInt(this.JPOIzq3000.getValue().toString()), 1L)));
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
        if (this.JCHBPromedio.isSelected()) {
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
        if (Double.parseDouble(this.JPOIzq250.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq2000.getValue().toString()) >= 25.0d) {
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
        if (!this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioOIzq.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPOIzq500.getValue().toString()), Integer.parseInt(this.JPOIzq1000.getValue().toString()), Integer.parseInt(this.JPOIzq2000.getValue().toString()), Integer.parseInt(this.JPOIzq3000.getValue().toString()), 1L)));
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
        if (Double.parseDouble(this.JPODer250.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer2000.getValue().toString()) >= 25.0d) {
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
        if (Double.parseDouble(this.JPODer250.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer2000.getValue().toString()) >= 25.0d) {
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
        if (Double.parseDouble(this.JPODer250.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer2000.getValue().toString()) >= 25.0d) {
            this.JCGatODC1.setSelectedItem("CASO DE REMISION");
        } else {
            this.JCGatODC1.setSelectedItem("NORMAL");
        }
        mVariableC2OD(this.JCGatODC2);
        mVariableC2OI(this.JCGatOIC2);
        if (this.JCHBPromedio.isSelected()) {
            this.JFTFPromedioODer.setValue(Double.valueOf(mCalcularPromedio2(Integer.parseInt(this.JPODer500.getValue().toString()), Integer.parseInt(this.JPODer1000.getValue().toString()), Integer.parseInt(this.JPODer2000.getValue().toString()), Integer.parseInt(this.JPODer3000.getValue().toString()), 0L)));
        }
        if (Double.parseDouble(this.JPODer250.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer2000.getValue().toString()) >= 25.0d) {
            this.JCGatODC1.setSelectedItem("CASO DE REMISION");
        } else {
            this.JCGatODC1.setSelectedItem("NORMAL");
        }
        mVariableC2OD(this.JCGatODC2);
        mVariableC2OI(this.JCGatOIC2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarResActionPerformed(ActionEvent evt) {
        if (this.JCResultado.getSelectedIndex() > -1) {
            mGuardar();
        } else {
            JOptionPane.showMessageDialog((Component) null, "Seleccione un resultado en la interpretación médica y agregue una observación preferiblemente", "Error", 0);
        }
        mCargarDatosTablaHistorico();
    }

    private void CalcularPromedioBinaural() {
        double I500 = Double.parseDouble(this.JPOIzq500.getValue().toString());
        double I1000 = Double.parseDouble(this.JPOIzq1000.getValue().toString());
        double I2000 = Double.parseDouble(this.JPOIzq2000.getValue().toString());
        double I3000 = Double.parseDouble(this.JPOIzq3000.getValue().toString());
        double D500 = Double.parseDouble(this.JPODer500.getValue().toString());
        double D1000 = Double.parseDouble(this.JPODer1000.getValue().toString());
        double D2000 = Double.parseDouble(this.JPODer2000.getValue().toString());
        double D3000 = Double.parseDouble(this.JPODer3000.getValue().toString());
        double SubtotalI = (((I500 + I1000) + I2000) + I3000) / 3.0d;
        double SubtotalD = (((D500 + D1000) + D2000) + D3000) / 3.0d;
        this.promedioBinauralTotal = (SubtotalI + SubtotalD) / 2.0d;
        this.jLabel57.setText("Promedio Binaural : " + this.promedioBinauralTotal);
    }

    private void GrabarAntecedentesAudiometria() {
        this.sql = "INSERT INTO h_so_audiometria_antecedentes (idAtencion,idAudiometria,sarampion,papera,sifilis,tbc,polio,traumaCreaneo,hipertencionAtertial,\ndiabetes,drogasMareo,mareo,amigdalitis,otitis,otalgia,alergias,otorrea,acufenos,vertigo,hipoacusia,sorderaFamiliar,cirugiasOido,observacion)\nVALUES( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xidAdiometria + "','" + boolToInt(this.JCSarampionSI.isSelected()) + "','" + boolToInt(this.JCPaperasSI.isSelected()) + "','" + boolToInt(this.JCSifilisSI.isSelected()) + "','" + boolToInt(this.JCTBCSI.isSelected()) + "','" + boolToInt(this.JCPolioSI.isSelected()) + "','" + boolToInt(this.JCTraumaDeCraneoSI.isSelected()) + "','" + boolToInt(this.JCHipertencionArterialSI.isSelected()) + "','" + boolToInt(this.JCDiabetesSI.isSelected()) + "','" + boolToInt(this.JCDrogastoxicasSI.isSelected()) + "','" + boolToInt(this.JCMareoSI.isSelected()) + "','" + boolToInt(this.JCAmigdalitisSI.isSelected()) + "','" + boolToInt(this.JCOtitisSI.isSelected()) + "','" + boolToInt(this.JCOtalgiaSI.isSelected()) + "','" + boolToInt(this.JCAlergiasSI.isSelected()) + "','" + boolToInt(this.JCOtorreaSI.isSelected()) + "','" + boolToInt(this.JCAcufenosSI.isSelected()) + "','" + boolToInt(this.JCVertigoSI.isSelected()) + "','" + boolToInt(this.JCHipoacusiaSI.isSelected()) + "','" + boolToInt(this.JCSordelaFamiliarSI.isSelected()) + "','" + boolToInt(this.JCCirugiasOidoSI.isSelected()) + "','" + this.JTObservaciones.getText().toString() + "')";
        this.xconsultasbd.ejecutarSQLId(this.sql);
        this.xconsultasbd.cerrarConexionBd();
        System.out.println("se grabó antecendes de audiometria");
    }

    private void GrabarInterpretacionMedica() {
        String sql = "UPDATE h_so_audiometria SET h_so_audiometria.`ResultadoM`='" + this.JCResultado.getSelectedItem() + "' , h_so_audiometria.`ObservacionM`='" + this.JTAObservacion.getText() + "', h_so_audiometria.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' WHERE (h_so_audiometria.`Id`='" + this.xidAdiometria + "')";
        System.out.println("Guardado de Interpretacion Medica : " + sql);
        this.xconsultasbd.ejecutarSQL(sql);
        this.xconsultasbd.cerrarConexionBd();
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() == 1) {
            Principal.clasehistoriace.mActualizarVariable_ManPower("RAudiometria", this.JCResultado.getSelectedItem().toString(), "Observacion_Aud", this.JTAObservacion.getText());
            if (!this.JCResultado.getSelectedItem().equals("NORMAL")) {
                Principal.clasehistoriace.mActualizarAlterado_ManPower();
            }
        }
        Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento(2);
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
    public void JCHBTiroCazaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBRudioAmbientalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBUsoAudifonosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBTejoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBDiscotecasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBServicioMilitarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBUsoDeMotoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPODer250StateChanged(ChangeEvent evt) {
        if (Double.parseDouble(this.JPODer250.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPODer2000.getValue().toString()) >= 25.0d) {
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
    public void JPOIzq250StateChanged(ChangeEvent evt) {
        if (Double.parseDouble(this.JPOIzq250.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq500.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq1000.getValue().toString()) >= 25.0d || Double.parseDouble(this.JPOIzq2000.getValue().toString()) >= 25.0d) {
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
    public void JCCirugiasOidoNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCCirugiasOidoSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCSordelaFamiliarSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCSordelaFamiliarNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHipoacusiaNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHipoacusiaSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCVertigoSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCVertigoNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCAcufenosNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCAcufenosSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCOtorreaNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCOtorreaSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCAlergiasSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCAlergiasNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCOtalgiaNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCOtalgiaSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCOtitisSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCOtitisNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCAmigdalitisNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCAmigdalitisSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCTraumaDeCraneoNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCTraumaDeCraneoSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHipertencionArterialSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHipertencionArterialNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCDiabetesNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCDiabetesSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCDrogastoxicasSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCDrogastoxicasNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCMareoNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCMareoSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCPolioNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCPolioSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCTBCSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCTBCNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCSifilisNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCSifilisSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCPaperasNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCSarampionNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCPaperasSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCSarampionSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTLarsenOiActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTGatisoActionPerformed(ActionEvent evt) {
    }

    private void mGrabarViaOsea() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar Via Osea?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
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
                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar Test de Weber?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
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
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "OI250", "OI500", "OI1000", "OI2000", "OI3000", "OI4000", "OI6000", "OI8000", "OD250", "OD500", "OD1000", "OD2000", "OD3000", "OD4000", "OD6000", "OD8000", "IdAudio", " Vía Ósea: ", "OI500", "OI1000", "OI2000", "OI3000", "OI4000", "OD250", "OD500", "OD1000", "OD2000", "OD3000", "OD4000", " Otoscopia: ", "Pabellón", "Conducto", "Timpanos"}) { // from class: com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1.91
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
        this.JTDetalleHistorico.getColumnModel().getColumn(30).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(31).setPreferredWidth(70);
        this.JTDetalleHistorico.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(33).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(34).setPreferredWidth(200);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT h_so_audiometria.Id_Atencion, h_so_audiometria.Fecha_R, h_so_audiometria.I250, h_so_audiometria.I500, h_so_audiometria.I1000, h_so_audiometria.I2000,\n  h_so_audiometria.I3000, h_so_audiometria.I4000, h_so_audiometria.I6000, h_so_audiometria.I8000, h_so_audiometria.D250, h_so_audiometria.D500, h_so_audiometria.D1000,\n  h_so_audiometria.D2000, h_so_audiometria.D3000, h_so_audiometria.D4000, h_so_audiometria.D6000, h_so_audiometria.D8000, h_so_audiometria.Id,\n  ' Vía Ósea: ' AS 'Via Osea', so.i250,  so.i500,  so.i1000,  so.i2000, so.i3000,  so.i4000,  so.d250,  so.d500,  so.d1000,  so.d2000,  so.d3000,  so.d4000\n,' Otoscopia: ' AS 'Otoscopia', pabellonR.nombre AS pabellon,  conductoR.nombre AS conducto,  timpanosR.nombre AS timpanos\nFROM h_so_audiometria\n  LEFT JOIN  h_so_audiometria_via_osea so  ON(h_so_audiometria.Id_Atencion = so.idAtencion)\n  LEFT JOIN  h_so_evalucion_oido_otoscopia otoscopia ON(h_so_audiometria.Id_Atencion = otoscopia.idAtencion)\n  LEFT JOIN h_tiporespuestaotoscopia pabellonR ON(pabellonR.id = otoscopia.pabellon)\n  LEFT JOIN h_tiporespuestaotoscopia conductoR ON(conductoR.id = otoscopia.conducto)\n  LEFT JOIN h_tiporespuestaotoscopia timpanosR ON(timpanosR.id = otoscopia.timpanos)\n  LEFT JOIN h_tiporespuestaotoscopia lobulosR ON(lobulosR.id = otoscopia.lobulos)\nWHERE (h_so_audiometria.Id_Usuario = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND h_so_audiometria.Estado = 1) ORDER BY h_so_audiometria.Id_Atencion DESC;";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloh.addRow(this.xdatos);
                    this.xmodeloh.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloh.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloh.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloh.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloh.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloh.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloh.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloh.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloh.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloh.setValueAt(xrs.getString(10), n, 9);
                    this.xmodeloh.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloh.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloh.setValueAt(xrs.getString(13), n, 12);
                    this.xmodeloh.setValueAt(xrs.getString(14), n, 13);
                    this.xmodeloh.setValueAt(xrs.getString(15), n, 14);
                    this.xmodeloh.setValueAt(xrs.getString(16), n, 15);
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
            Logger.getLogger(JPSo_Audiometria_nueva1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int boolToInt(boolean b) {
        return b ? 1 : 0;
    }

    private void mGuardar() {
        CalcularPromedioBinaural();
        String archivo1 = null;
        String archivo2 = null;
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (!this.xmetodo.esIPSMineros()) {
                String sql = "INSERT INTO h_so_audiometria (`Id_Atencion` , `Fecha_R` , `I250`, `I500`  , `I1000`  , `I2000`  , `I3000` , `I4000` , `I6000`  , `I8000` , `D250` ,`D500` , `D1000` , `D2000`  , `D3000`,`D4000` , `D6000`  , `D8000` , `POI` , `POD` , `COI_OSHAS` , `COD_OSHAS` , `C1_OI_GATISO`  , `C1_OD_GATISO`  , `C2_OI_GATISO` , `C2_OD_GATISO` , `C3_OI_GATISO` , `C3_OD_GATISO`  , `Id_Profesional`  , `Id_Especialidad`,Id_Usuario, ElementosAudio, Autoscopia, Retest, ObservacionAudio,TFormula, LineaBase, TiroCaza, RuidoAmbiental, Tejo, UsoAudifonos, Discotecas, ServicioMilitar, UsoMoto, `UsuarioS`,PBinaural)values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.JPOIzq250.getValue() + "','" + this.JPOIzq500.getValue() + "','" + this.JPOIzq1000.getValue() + "','" + this.JPOIzq2000.getValue() + "','" + this.JPOIzq3000.getValue() + "','" + this.JPOIzq4000.getValue() + "','" + this.JPOIzq6000.getValue() + "','" + this.JPOIzq8000.getValue() + "','" + this.JPODer250.getValue() + "','" + this.JPODer500.getValue() + "','" + this.JPODer1000.getValue() + "','" + this.JPODer2000.getValue() + "','" + this.JPODer3000.getValue() + "','" + this.JPODer4000.getValue() + "','" + this.JPODer6000.getValue() + "','" + this.JPODer8000.getValue() + "','" + this.JFTFPromedioOIzq.getValue() + "','" + this.JFTFPromedioODer.getValue() + "','" + this.JCBoshaOI.getSelectedItem() + "','" + this.JCBoshaOD.getSelectedItem() + "','" + this.JCGatOIC1.getSelectedItem() + "','" + this.JCGatODC1.getSelectedItem() + "','" + this.JCGatOIC2.getSelectedItem() + "','" + this.JCGatODC2.getSelectedItem() + "','" + this.JCGatOIC3.getSelectedItem() + "','" + this.JCGatODC3.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xelemento + "','" + this.xautoscopia + "','" + this.xretest + "','" + this.JTAObservacionAudio.getText() + "','" + this.xtformula + "','" + this.xlineabase + "','" + boolToInt(this.JCHBTiroCaza.isSelected()) + "','" + boolToInt(this.JCHBRudioAmbiental.isSelected()) + "','" + boolToInt(this.JCHBTejo.isSelected()) + "','" + boolToInt(this.JCHBUsoAudifonos.isSelected()) + "','" + boolToInt(this.JCHBDiscotecas.isSelected()) + "','" + boolToInt(this.JCHBServicioMilitar.isSelected()) + "','" + boolToInt(this.JCHBUsoDeMoto.isSelected()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.promedioBinauralTotal + "')";
                this.xidAdiometria = Long.valueOf(this.xconsultasbd.ejecutarSQLId(sql)).longValue();
                this.xconsultasbd.cerrarConexionBd();
                this.aDiagnostico.grabar();
                this.JBGrabarRes.setEnabled(false);
                mCargarDatosTablaHistorico();
                if (this.JTDetalleHistorico.getRowCount() > 0) {
                    this.JTDetalleHistorico.setRowSelectionInterval(0, 0);
                    mGenerarGrafico();
                    try {
                        archivo1 = Metodos.encodeFileToBase64Binary(this.xmetodo.getRutaRep() + "OidoIzq.jpg");
                        archivo2 = Metodos.encodeFileToBase64Binary(this.xmetodo.getRutaRep() + "OidoDer.jpg");
                        redibujar(archivo1, "OidoIzq.jpg", this.jLbImg1);
                        redibujar(archivo2, "OidoDer.jpg", this.jLbImg2);
                    } catch (Exception e) {
                    }
                }
                String sql2 = "UPDATE\n\th_so_audiometria\nSET\n\tId_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Fecha_R = '" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', ImgOI = '" + archivo1 + "', ImgOD = '" + archivo2 + "' \nWHERE \t\n\th_so_audiometria.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                this.xconsultasbd.ejecutarSQL(sql2);
                this.xconsultasbd.cerrarConexionBd();
            } else if (this.xidAdiometria == 0) {
                String sql3 = "INSERT INTO h_so_audiometria (`Id_Atencion` , `Fecha_R` , `I250`, `I500`  , `I1000`  , `I2000`  , `I3000` , `I4000` , `I6000`  , `I8000` , `D250` ,`D500` , `D1000` , `D2000`  , `D3000`,`D4000` , `D6000`  , `D8000` , `POI` , `POD` , `COI_OSHAS` , `COD_OSHAS` , `C1_OI_GATISO`  , `C1_OD_GATISO`  , `C2_OI_GATISO` , `C2_OD_GATISO` , `C3_OI_GATISO` , `C3_OD_GATISO`  , `Id_Profesional`  , `Id_Especialidad`,Id_Usuario, ElementosAudio, Autoscopia, Retest, ObservacionAudio,TFormula, LineaBase, TiroCaza, RuidoAmbiental, Tejo, UsoAudifonos, Discotecas, ServicioMilitar, UsoMoto, `UsuarioS`,PBinaural)values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "','" + this.JPOIzq250.getValue() + "','" + this.JPOIzq500.getValue() + "','" + this.JPOIzq1000.getValue() + "','" + this.JPOIzq2000.getValue() + "','" + this.JPOIzq3000.getValue() + "','" + this.JPOIzq4000.getValue() + "','" + this.JPOIzq6000.getValue() + "','" + this.JPOIzq8000.getValue() + "','" + this.JPODer250.getValue() + "','" + this.JPODer500.getValue() + "','" + this.JPODer1000.getValue() + "','" + this.JPODer2000.getValue() + "','" + this.JPODer3000.getValue() + "','" + this.JPODer4000.getValue() + "','" + this.JPODer6000.getValue() + "','" + this.JPODer8000.getValue() + "','" + this.JFTFPromedioOIzq.getValue() + "','" + this.JFTFPromedioODer.getValue() + "','" + this.JCBoshaOI.getSelectedItem() + "','" + this.JCBoshaOD.getSelectedItem() + "','" + this.JCGatOIC1.getSelectedItem() + "','" + this.JCGatODC1.getSelectedItem() + "','" + this.JCGatOIC2.getSelectedItem() + "','" + this.JCGatODC2.getSelectedItem() + "','" + this.JCGatOIC3.getSelectedItem() + "','" + this.JCGatODC3.getSelectedItem() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xelemento + "','" + this.xautoscopia + "','" + this.xretest + "','" + this.JTAObservacionAudio.getText() + "','" + this.xtformula + "','" + this.xlineabase + "','" + boolToInt(this.JCHBTiroCaza.isSelected()) + "','" + boolToInt(this.JCHBRudioAmbiental.isSelected()) + "','" + boolToInt(this.JCHBTejo.isSelected()) + "','" + boolToInt(this.JCHBUsoAudifonos.isSelected()) + "','" + boolToInt(this.JCHBDiscotecas.isSelected()) + "','" + boolToInt(this.JCHBServicioMilitar.isSelected()) + "','" + boolToInt(this.JCHBUsoDeMoto.isSelected()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.promedioBinauralTotal + "')";
                this.xidAdiometria = Long.valueOf(this.xconsultasbd.ejecutarSQLId(sql3)).longValue();
                this.xconsultasbd.cerrarConexionBd();
                this.aDiagnostico.grabar();
                mCargarDatosTablaHistorico();
                if (this.JTDetalleHistorico.getRowCount() > 0) {
                    this.JTDetalleHistorico.setRowSelectionInterval(0, 0);
                    mGenerarGrafico();
                    try {
                        archivo1 = Metodos.encodeFileToBase64Binary(this.xmetodo.getRutaRep() + "OidoIzq.jpg");
                        archivo2 = Metodos.encodeFileToBase64Binary(this.xmetodo.getRutaRep() + "OidoDer.jpg");
                        redibujar(archivo1, "OidoIzq.jpg", this.jLbImg1);
                        redibujar(archivo2, "OidoDer.jpg", this.jLbImg2);
                    } catch (Exception e2) {
                    }
                }
                String sql4 = "UPDATE\n\th_so_audiometria\nSET\n\tId_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Fecha_R = '" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', ImgOI = '" + archivo1 + "', ImgOD = '" + archivo2 + "' \nWHERE \t\n\th_so_audiometria.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                this.xconsultasbd.ejecutarSQL(sql4);
                this.xconsultasbd.cerrarConexionBd();
            } else {
                String sql5 = "UPDATE\n\th_so_audiometria\nSET\n\tId_Atencion = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', Fecha_R = '" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', I250 = '" + this.JPOIzq250.getValue() + "', I500 = '" + this.JPOIzq500.getValue() + "', I1000 = '" + this.JPOIzq1000.getValue() + "', I2000 = '" + this.JPOIzq2000.getValue() + "', I3000 = '" + this.JPOIzq3000.getValue() + "', I4000 = '" + this.JPOIzq4000.getValue() + "', I6000 = '" + this.JPOIzq6000.getValue() + "', I8000 = '" + this.JPOIzq8000.getValue() + "', D250 = '" + this.JPODer250.getValue() + "', D500 = '" + this.JPODer500.getValue() + "', D1000 = '" + this.JPODer1000.getValue() + "', D2000 = '" + this.JPODer2000.getValue() + "', D3000 = '" + this.JPODer3000.getValue() + "', D4000 = '" + this.JPODer4000.getValue() + "', D6000 = '" + this.JPODer6000.getValue() + "', D8000 = '" + this.JPODer8000.getValue() + "', POI = '" + this.JFTFPromedioOIzq.getValue() + "', POD = '" + this.JFTFPromedioODer.getValue() + "', COI_OSHAS = '" + this.JCBoshaOI.getSelectedItem() + "', COD_OSHAS = '" + this.JCBoshaOD.getSelectedItem() + "', C1_OI_GATISO = '" + this.JCGatOIC1.getSelectedItem() + "', C1_OD_GATISO = '" + this.JCGatODC1.getSelectedItem() + "', C2_OI_GATISO = '" + this.JCGatOIC2.getSelectedItem() + "', C2_OD_GATISO = '" + this.JCGatODC2.getSelectedItem() + "', C3_OI_GATISO = '" + this.JCGatOIC3.getSelectedItem() + "', C3_OD_GATISO = '" + this.JCGatODC3.getSelectedItem() + "', Id_Profesional = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Id_Especialidad = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', Id_Usuario = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', ElementosAudio = \t'" + this.xelemento + "', Autoscopia = '" + this.xautoscopia + "', Retest = '" + this.xretest + "', ObservacionAudio = '" + this.JTAObservacionAudio.getText() + "', TFormula = '" + this.xtformula + "', LineaBase = '" + this.xlineabase + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' \nWHERE \t\n\th_so_audiometria.`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                this.xconsultasbd.ejecutarSQL(sql5);
                this.xconsultasbd.cerrarConexionBd();
            }
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento(2);
            mCargarDatosTablaHistorico();
            if (this.JTDetalleHistorico.getRowCount() > 0) {
                this.JTDetalleHistorico.setRowSelectionInterval(0, 0);
                GrabarAntecedentesAudiometria();
                GrabarPresbiacusia();
                GrabarInterpretacionMedica();
                mGenerarGrafico();
                System.out.println(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
                mImprimir(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            }
        }
    }

    private void GrabarPresbiacusia() {
        String sqlx = "INSERT INTO h_so_audiometria_presbiacusia(idAudiometria,idAtencion,eliOi,eliOd,larsenOi,larsenOd,salOi,salOd,gatiso,observaciones,recomendaciones)\nVALUES('" + this.xidAdiometria + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.jTEliOi.getText() + "','" + this.jTEliOd.getText() + "','" + this.jTLarsenOi.getText() + "','" + this.jTLarsenOd.getText() + "','" + this.jTSalOi.getText() + "','" + this.jTSalOd.getText() + "','" + this.jTGatiso.getText() + "','" + this.JTObservaciones.getText() + "','" + this.JTORecomendacionesPresbiacusia.getText() + "')";
        this.xconsultasbd.ejecutarSQLId(sqlx);
        this.xconsultasbd.cerrarConexionBd();
    }

    private void mBuscarAdiometriaAtencion() {
        try {
            String sql = "SELECT h_so_audiometria.`I250`  ,h_so_audiometria.`I500`  , h_so_audiometria.`I1000`  , h_so_audiometria.`I2000`  , h_so_audiometria.`I3000` , h_so_audiometria.`I4000` , h_so_audiometria.`I6000`  , h_so_audiometria.`I8000` , h_so_audiometria.`D250` ,h_so_audiometria.`D500` , h_so_audiometria.`D1000` , h_so_audiometria.`D2000`  , h_so_audiometria.`D3000`, h_so_audiometria.`D4000` , h_so_audiometria.`D6000`  , h_so_audiometria.`D8000` , h_so_audiometria.`POI` , h_so_audiometria.`POD` , h_so_audiometria.`COI_OSHAS` , h_so_audiometria.`COD_OSHAS` , h_so_audiometria.`C1_OI_GATISO`  , h_so_audiometria.`C1_OD_GATISO`  , h_so_audiometria.`C2_OI_GATISO` , h_so_audiometria.`C2_OD_GATISO` , h_so_audiometria.`C3_OI_GATISO` , h_so_audiometria.`C3_OD_GATISO` , h_so_audiometria.`ResultadoM`  , h_so_audiometria.`ObservacionM`, `h_atencion`.`TipoGuardado`, h_so_audiometria.ElementosAudio, h_so_audiometria.Autoscopia, h_so_audiometria.Retest, IF(ObservacionAudio IS NULL,'',ObservacionAudio)AS ObservacionAudio, h_so_audiometria.TFormula, h_so_audiometria.Id_Atencion, h_so_audiometria.Id, h_so_audiometria.LineaBase, h_so_audiometria.TiroCaza, h_so_audiometria.RuidoAmbiental, h_so_audiometria.Tejo, h_so_audiometria.UsoAudifonos, h_so_audiometria.Discotecas, h_so_audiometria.ServicioMilitar, h_so_audiometria.UsoMoto, h_so_audiometria.ImgOI, h_so_audiometria.ImgOD ,if(h_so_audiometria.`ResultadoM` IS NULL || h_so_audiometria.`ResultadoM`='', 0, 1) AS Grabado    FROM `h_so_audiometria` INNER JOIN `h_atencion`   ON (`h_so_audiometria`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`Id_Atencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' and h_so_audiometria.Estado=1)";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                this.xid = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                xrs.first();
                if (xrs.getLong("TFormula") == 1) {
                    this.JCHBPromedio.setSelected(true);
                } else {
                    this.JCHBPromedio.setSelected(false);
                }
                this.JPOIzq250.setValue(Integer.valueOf(xrs.getInt("I250")));
                this.JPOIzq500.setValue(Integer.valueOf(xrs.getInt("I500")));
                this.JPOIzq1000.setValue(Integer.valueOf(xrs.getInt("I1000")));
                this.JPOIzq2000.setValue(Integer.valueOf(xrs.getInt("I2000")));
                this.JPOIzq3000.setValue(Integer.valueOf(xrs.getInt("I3000")));
                this.JPOIzq4000.setValue(Integer.valueOf(xrs.getInt("I4000")));
                this.JPOIzq6000.setValue(Integer.valueOf(xrs.getInt("I6000")));
                this.JPOIzq8000.setValue(Integer.valueOf(xrs.getInt("I8000")));
                this.JPODer500.setValue(Integer.valueOf(xrs.getInt("D250")));
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
                if (xrs.getInt("TiroCaza") == 0) {
                    this.JCHBTiroCaza.setSelected(false);
                } else {
                    this.JCHBTiroCaza.setSelected(true);
                }
                if (xrs.getInt("RuidoAmbiental") == 0) {
                    this.JCHBRudioAmbiental.setSelected(false);
                } else {
                    this.JCHBRudioAmbiental.setSelected(true);
                }
                if (xrs.getInt("Tejo") == 0) {
                    this.JCHBTejo.setSelected(false);
                } else {
                    this.JCHBTejo.setSelected(true);
                }
                if (xrs.getInt("UsoAudifonos") == 0) {
                    this.JCHBUsoAudifonos.setSelected(false);
                } else {
                    this.JCHBUsoAudifonos.setSelected(true);
                }
                if (xrs.getInt("Discotecas") == 0) {
                    this.JCHBDiscotecas.setSelected(false);
                } else {
                    this.JCHBDiscotecas.setSelected(true);
                }
                if (xrs.getInt("ServicioMilitar") == 0) {
                    this.JCHBServicioMilitar.setSelected(false);
                } else {
                    this.JCHBServicioMilitar.setSelected(true);
                }
                if (xrs.getInt("UsoMoto") == 0) {
                    this.JCHBUsoDeMoto.setSelected(false);
                } else {
                    this.JCHBUsoDeMoto.setSelected(true);
                }
                this.ImgIzquierda = xrs.getString("ImgOI");
                this.ImgDerecha = xrs.getString("ImgOD");
                redibujar(this.ImgIzquierda, "OidoIzq.jpg", this.jLbImg1);
                redibujar(this.ImgDerecha, "OidoDer.jpg", this.jLbImg2);
                if (xrs.getBoolean("Grabado")) {
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
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Audiometria_nueva1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        CargarAntecendetes();
        CargarPresbiacusia();
        CalcularPromedioBinaural();
    }

    private void CargarAntecendetes() {
        try {
            String sqlx = "SELECT sarampion,papera,sifilis,tbc,polio,traumaCreaneo,hipertencionAtertial,diabetes,drogasMareo,mareo,\namigdalitis,otitis,otalgia,alergias,otorrea,acufenos,vertigo,hipoacusia,sorderaFamiliar,cirugiasOido,observacion\nFROM h_so_audiometria_antecedentes \n    INNER JOIN h_so_audiometria ON (h_so_audiometria_antecedentes.idAudiometria = h_so_audiometria.Id)\n   where h_so_audiometria_antecedentes.idAudiometria ='" + this.xidAdiometria + "'";
            System.out.println(sqlx);
            ResultSet xrs = this.xconsultasbd.traerRs(sqlx);
            if (xrs.next()) {
                if (xrs.getInt("sarampion") == 1) {
                    this.JCSarampionSI.setSelected(true);
                } else {
                    this.JCSarampionSI.setSelected(false);
                }
                if (xrs.getInt("papera") == 1) {
                    this.JCPaperasSI.setSelected(true);
                } else {
                    this.JCPaperasSI.setSelected(false);
                }
                if (xrs.getInt("sifilis") == 1) {
                    this.JCSifilisSI.setSelected(true);
                } else {
                    this.JCSifilisSI.setSelected(false);
                }
                if (xrs.getInt("tbc") == 1) {
                    this.JCTBCSI.setSelected(true);
                } else {
                    this.JCTBCSI.setSelected(false);
                }
                if (xrs.getInt("polio") == 1) {
                    this.JCPolioSI.setSelected(true);
                } else {
                    this.JCPolioSI.setSelected(false);
                }
                if (xrs.getInt("traumaCreaneo") == 1) {
                    this.JCTraumaDeCraneoSI.setSelected(true);
                } else {
                    this.JCTraumaDeCraneoSI.setSelected(false);
                }
                if (xrs.getInt("hipertencionAtertial") == 1) {
                    this.JCHipertencionArterialSI.setSelected(true);
                } else {
                    this.JCHipertencionArterialSI.setSelected(false);
                }
                if (xrs.getInt("diabetes") == 1) {
                    this.JCDiabetesSI.setSelected(true);
                } else {
                    this.JCDiabetesSI.setSelected(false);
                }
                if (xrs.getInt("drogasMareo") == 1) {
                    this.JCDrogastoxicasSI.setSelected(true);
                } else {
                    this.JCDrogastoxicasSI.setSelected(false);
                }
                if (xrs.getInt("mareo") == 1) {
                    this.JCMareoSI.setSelected(true);
                } else {
                    this.JCMareoSI.setSelected(false);
                }
                if (xrs.getInt("amigdalitis") == 1) {
                    this.JCAmigdalitisSI.setSelected(true);
                } else {
                    this.JCAmigdalitisSI.setSelected(false);
                }
                if (xrs.getInt("otitis") == 1) {
                    this.JCOtitisSI.setSelected(true);
                } else {
                    this.JCOtitisSI.setSelected(false);
                }
                if (xrs.getInt("otalgia") == 1) {
                    this.JCOtalgiaSI.setSelected(true);
                } else {
                    this.JCOtalgiaSI.setSelected(false);
                }
                if (xrs.getInt("alergias") == 1) {
                    this.JCAlergiasSI.setSelected(true);
                } else {
                    this.JCAlergiasSI.setSelected(false);
                }
                if (xrs.getInt("otorrea") == 1) {
                    this.JCOtorreaSI.setSelected(true);
                } else {
                    this.JCOtorreaSI.setSelected(false);
                }
                if (xrs.getInt("acufenos") == 1) {
                    this.JCAcufenosSI.setSelected(true);
                } else {
                    this.JCAcufenosSI.setSelected(false);
                }
                if (xrs.getInt("vertigo") == 1) {
                    this.JCVertigoSI.setSelected(true);
                } else {
                    this.JCVertigoSI.setSelected(false);
                }
                if (xrs.getInt("hipoacusia") == 1) {
                    this.JCHipoacusiaSI.setSelected(true);
                } else {
                    this.JCHipoacusiaSI.setSelected(false);
                }
                if (xrs.getInt("sorderaFamiliar") == 1) {
                    this.JCSordelaFamiliarSI.setSelected(true);
                } else {
                    this.JCSordelaFamiliarSI.setSelected(false);
                }
                if (xrs.getInt("cirugiasOido") == 1) {
                    this.JCCirugiasOidoSI.setSelected(true);
                } else {
                    this.JCCirugiasOidoSI.setSelected(false);
                }
                this.JTObservaciones.setText(xrs.getString("observacion"));
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
            System.out.println("se cargó antecendes de audiometria");
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Audiometria_nueva1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void CargarPresbiacusia() {
        String sqlx = "SELECT eliOi,eliOd,larsenOi,larsenOd,salOi,salOd,gatiso,observaciones,recomendaciones\nFROM h_so_audiometria_presbiacusia\nWHERE h_so_audiometria_presbiacusia.idAudiometria ='" + this.xidAdiometria + "'";
        try {
            System.out.println(sqlx);
            ResultSet xrs = this.xconsultasbd.traerRs(sqlx);
            if (xrs.next()) {
                if (xrs.getString("eliOi").isEmpty()) {
                    this.jTEliOi.setText("");
                } else {
                    this.jTEliOi.setText(xrs.getString("eliOi"));
                }
                if (xrs.getString("eliOd").isEmpty()) {
                    this.jTEliOd.setText("");
                } else {
                    this.jTEliOd.setText(xrs.getString("eliOd"));
                }
                if (xrs.getString("larsenOi").isEmpty()) {
                    this.jTLarsenOi.setText("");
                } else {
                    this.jTLarsenOi.setText(xrs.getString("larsenOi"));
                }
                if (xrs.getString("larsenOd").isEmpty()) {
                    this.jTLarsenOd.setText("");
                } else {
                    this.jTLarsenOd.setText(xrs.getString("larsenOd"));
                }
                if (xrs.getString("salOi").isEmpty()) {
                    this.jTSalOi.setText("");
                } else {
                    this.jTSalOi.setText(xrs.getString("salOi"));
                }
                if (xrs.getString("salOd").isEmpty()) {
                    this.jTSalOd.setText("");
                } else {
                    this.jTSalOd.setText(xrs.getString("salOd"));
                }
                if (xrs.getString("gatiso").isEmpty()) {
                    this.jTGatiso.setText("");
                } else {
                    this.jTGatiso.setText(xrs.getString("gatiso"));
                }
                if (xrs.getString("observaciones").isEmpty()) {
                    this.JTObservacionesPresbiacusia.setText("");
                } else {
                    this.JTObservacionesPresbiacusia.setText(xrs.getString("observaciones"));
                }
                if (xrs.getString("recomendaciones").isEmpty()) {
                    this.JTORecomendacionesPresbiacusia.setText("");
                } else {
                    this.JTORecomendacionesPresbiacusia.setText(xrs.getString("recomendaciones"));
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
            System.out.println("se cargó antecendes de audiometria");
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Audiometria_nueva1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void redibujar(String base64, String imgNombre, JLabel label) {
        OutputStream stream;
        Throwable th;
        try {
            byte[] data = Base64.getDecoder().decode(base64);
            try {
                stream = new FileOutputStream(imgNombre);
                th = null;
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                try {
                    stream.write(data);
                    label.setIcon(new ImageIcon(imgNombre));
                    if (stream != null) {
                        if (0 != 0) {
                            try {
                                stream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            stream.close();
                        }
                    }
                } catch (Throwable th3) {
                    if (stream != null) {
                        if (th != null) {
                            try {
                                stream.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        } else {
                            stream.close();
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                th = th5;
                throw th5;
            }
        } catch (Exception e2) {
        }
    }

    public void mGenerarGrafico() {
        try {
            XYDataset xydataset = xyDataset();
            XYDataset xydataseti = xyDatasetI();
            JFreeChart jfreechart = ChartFactory.createScatterPlot("Oido Derecho", "", "Resultado", xydataset, PlotOrientation.VERTICAL, true, true, false);
            JFreeChart jfreecharti = ChartFactory.createScatterPlot("Oido Izquierdo", "", "Resultado", xydataseti, PlotOrientation.VERTICAL, true, true, false);
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
            ChartUtilities.saveChartAsJPEG(new File(this.xmetodo.getRutaRep() + "OidoDer.jpg"), jfreechart, 700, 400);
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
            ChartUtilities.saveChartAsJPEG(new File(this.xmetodo.getRutaRep() + "OidoIzq.jpg"), jfreecharti, 700, 400);
        } catch (IOException e) {
        }
    }

    private XYDataset xyDataset() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Oido Derecho");
        series1.addOrUpdate(250.0d, Integer.parseInt(this.JPOIzq250.getValue().toString()));
        series1.addOrUpdate(500.0d, Integer.parseInt(this.JPOIzq500.getValue().toString()));
        series1.addOrUpdate(1000.0d, Integer.parseInt(this.JPOIzq1000.getValue().toString()));
        series1.addOrUpdate(2000.0d, Integer.parseInt(this.JPOIzq2000.getValue().toString()));
        series1.addOrUpdate(3000.0d, Integer.parseInt(this.JPOIzq3000.getValue().toString()));
        series1.addOrUpdate(4000.0d, Integer.parseInt(this.JPOIzq4000.getValue().toString()));
        series1.addOrUpdate(6000.0d, Integer.parseInt(this.JPOIzq6000.getValue().toString()));
        series1.addOrUpdate(8000.0d, Integer.parseInt(this.JPOIzq8000.getValue().toString()));
        xyseriescollection.addSeries(series1);
        return xyseriescollection;
    }

    private XYDataset xyDatasetI() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Oido Izquierdo");
        series1.add(250.0d, Integer.parseInt(this.JPODer250.getValue().toString()));
        series1.add(500.0d, Integer.parseInt(this.JPODer500.getValue().toString()));
        series1.add(1000.0d, Integer.parseInt(this.JPODer1000.getValue().toString()));
        series1.add(2000.0d, Integer.parseInt(this.JPODer2000.getValue().toString()));
        series1.add(3000.0d, Integer.parseInt(this.JPODer3000.getValue().toString()));
        series1.add(4000.0d, Integer.parseInt(this.JPODer4000.getValue().toString()));
        series1.add(6000.0d, Integer.parseInt(this.JPODer6000.getValue().toString()));
        series1.add(8000.0d, Integer.parseInt(this.JPODer8000.getValue().toString()));
        xyseriescollection.addSeries(series1);
        return xyseriescollection;
    }
}
