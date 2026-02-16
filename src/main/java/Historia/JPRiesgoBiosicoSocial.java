package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPRiesgoBiosicoSocial.class */
public class JPRiesgoBiosicoSocial extends JPanel {
    private double xregistro;
    private JP_CP_DatosPyP xvalsemEmbarazo;
    private ButtonGroup JBGHRDinero1;
    private ButtonGroup JBGHRDinero2;
    private ButtonGroup JBGHRDinero3;
    private ButtonGroup JBGHREdad;
    private ButtonGroup JBGHREltiempo1;
    private ButtonGroup JBGHREltiempo2;
    private ButtonGroup JBGHREltiempo3;
    private ButtonGroup JBGHREspacio1;
    private ButtonGroup JBGHREspacio2;
    private ButtonGroup JBGHREspacio3;
    private ButtonGroup JBGHRInsomnio1;
    private ButtonGroup JBGHRInsomnio2;
    private ButtonGroup JBGHRInsomnio3;
    private ButtonGroup JBGHRParidad;
    private ButtonGroup JBGHRSemana14_27;
    private ButtonGroup JBGHRSemana27_32;
    private ButtonGroup JBGHRTraspiracion1;
    private ButtonGroup JBGHRTraspiracion2;
    private ButtonGroup JBGHRTraspiracion3;
    private ButtonGroup JBGHRllanto1;
    private ButtonGroup JBGHRllanto2;
    private ButtonGroup JBGHRllanto3;
    private JButton JBGrabar;
    private JComboBox JCBAnemia1;
    private JComboBox JCBAnemia2;
    private JComboBox JCBAnemia3;
    private JComboBox JCBDiabetesG1;
    private JComboBox JCBDiabetesG2;
    private JComboBox JCBDiabetesG3;
    private JComboBox JCBDiabetesM1;
    private JComboBox JCBDiabetesM2;
    private JComboBox JCBDiabetesM3;
    private JComboBox JCBEAuto1;
    private JComboBox JCBEAuto2;
    private JComboBox JCBEAuto3;
    private JComboBox JCBECardiaca1;
    private JComboBox JCBECardiaca2;
    private JComboBox JCBECardiaca3;
    private JComboBox JCBEInfecciosa1;
    private JComboBox JCBEInfecciosa2;
    private JComboBox JCBEInfecciosa3;
    private JComboBox JCBHTA1;
    private JComboBox JCBHTA2;
    private JComboBox JCBHTA3;
    private JComboBox JCBHemorragia1;
    private JComboBox JCBHemorragia2;
    private JComboBox JCBHemorragia3;
    private JComboBox JCBIsoInm1;
    private JComboBox JCBIsoInm2;
    private JComboBox JCBIsoInm3;
    private JComboBox JCBMPresentacion;
    private JComboBox JCBPolih1;
    private JComboBox JCBPolih2;
    private JComboBox JCBPolih3;
    private JComboBox JCBProlongado;
    private JComboBox JCBQx1;
    private JComboBox JCBQx2;
    private JComboBox JCBQx3;
    private JComboBox JCBRCIU1;
    private JComboBox JCBRCIU13;
    private JComboBox JCBRCIU2;
    private JComboBox JCBREmb1;
    private JComboBox JCBREmb2;
    private JComboBox JCBREmb3;
    private JComboBox JCBRPM1;
    private JComboBox JCBRPM2;
    private JComboBox JCBRPM3;
    private JComboBox JCBRenal1;
    private JComboBox JCBRenal2;
    private JComboBox JCBRenal3;
    private JComboBox JCBVaginal1;
    private JComboBox JCBVaginal2;
    private JComboBox JCBVaginal3;
    private JCheckBox JCHBAborto;
    private JCheckBox JCHBEmbGemelar;
    private JCheckBox JCHBHTAInducida;
    private JCheckBox JCHBMortinato;
    private JCheckBox JCHBProlongado;
    private JCheckBox JCHBRecienNacido2500;
    private JCheckBox JCHBRecienNacido4000;
    private JCheckBox JCHBRetPlacenta;
    private JLabel JLDinero;
    private JLabel JLDinero1;
    private JLabel JLDinero2;
    private JLabel JLEspacio;
    private JLabel JLEspacio1;
    private JLabel JLEspacio2;
    private JLabel JLSemana24_27;
    private JLabel JLSemana28_32;
    private JLabel JLSemana33_48;
    private JLabel JLTiempo;
    private JLabel JLTiempo1;
    private JLabel JLTiempo2;
    private JLabel JLTotal1;
    private JLabel JLTotal2;
    private JLabel JLTotal3;
    private JPanel JPCondiAsociadas;
    private JPanel JPDetalles;
    private JPanel JPDetalles1;
    private JPanel JPDetalles2;
    private JPanel JPEdad;
    private JPanel JPEmbarazoActual;
    private JPanel JPHisReproductiva;
    private JPanel JPParidad;
    private JPanel JPRSicosocial;
    private JPanel JPResultado1;
    private JPanel JPResultado2;
    private JPanel JPTotal14_27;
    private JPanel JPTotal28_38;
    private JPanel JPTotal33_42;
    private JRadioButton JRBAusente1;
    private JRadioButton JRBAusente2;
    private JRadioButton JRBAusente3;
    private JRadioButton JRBAusente4;
    private JRadioButton JRBAusente5;
    private JRadioButton JRBAusente6;
    private JRadioButton JRBAusente7;
    private JRadioButton JRBAusente8;
    private JRadioButton JRBAusente9;
    private JRadioButton JRBCasiDinero;
    private JRadioButton JRBCasiDinero1;
    private JRadioButton JRBCasiDinero2;
    private JRadioButton JRBCasiEspacio;
    private JRadioButton JRBCasiEspacio1;
    private JRadioButton JRBCasiEspacio2;
    private JRadioButton JRBCasiTiempo;
    private JRadioButton JRBCasiTiempo1;
    private JRadioButton JRBCasiTiempo2;
    private JRadioButton JRBCero;
    private JRadioButton JRBEntre16_35;
    private JRadioButton JRBEntreMas_35;
    private JRadioButton JRBIntenso1;
    private JRadioButton JRBIntenso2;
    private JRadioButton JRBIntenso3;
    private JRadioButton JRBIntenso4;
    private JRadioButton JRBIntenso5;
    private JRadioButton JRBIntenso6;
    private JRadioButton JRBIntenso7;
    private JRadioButton JRBIntenso8;
    private JRadioButton JRBIntenso9;
    private JRadioButton JRBMenor_16;
    private JRadioButton JRBNuncaDinero;
    private JRadioButton JRBNuncaDinero1;
    private JRadioButton JRBNuncaDinero2;
    private JRadioButton JRBNuncaEspacio;
    private JRadioButton JRBNuncaEspacio1;
    private JRadioButton JRBNuncaEspacio2;
    private JRadioButton JRBNuncaTiempo;
    private JRadioButton JRBNuncaTiempo1;
    private JRadioButton JRBNuncaTiempo2;
    private JRadioButton JRBParidad1_4;
    private JRadioButton JRBParidad5;
    private JRadioButton JRBVecesDinero;
    private JRadioButton JRBVecesDinero1;
    private JRadioButton JRBVecesDinero2;
    private JRadioButton JRBVecesEspacio;
    private JRadioButton JRBVecesEspacio1;
    private JRadioButton JRBVecesEspacio2;
    private JRadioButton JRBVecesTiempo;
    private JRadioButton JRBVecesTiempo1;
    private JRadioButton JRBVecesTiempo2;
    private JTextField JTFR1Valor1;
    private JTextField JTFR1Valor2;
    private JTextField JTFR1Valor3;
    private JTextField JTFR2Valor1;
    private JTextField JTFR2Valor2;
    private JTextField JTFR2Valor3;
    private JFormattedTextField JTFSubtotal1;
    private JFormattedTextField JTFSubtotal2;
    private JFormattedTextField JTFSubtotal3;
    private JFormattedTextField JTFSubtotal4;
    private JFormattedTextField JTFSubtotal5;
    private JFormattedTextField JTFSubtotal6;
    private JTextField JTFTotal1;
    private JTextField JTFTotal2;
    private JTextField JTFTotal3;
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
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JTabbedPane jTabbedPane1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xidEncabezado = 0;
    private int xedad = 0;
    private int xparidad = 1;
    private int xaborto = 0;
    private int xretPlacentaria = 0;
    private int xrNacidoM = 0;
    private int xrNacidom = 0;
    private int xHTA = 0;
    private int xgemelar = 0;
    private int xmortinato = 0;
    private int xprolongado = 0;
    private int xQx1 = 0;
    private int xRenal1 = 0;
    private int xGestacional1 = 0;
    private int xMellitus1 = 0;
    private int xCardiaca1 = 0;
    private int xInfecciosa1 = 0;
    private int xAutoinmune1 = 0;
    private int xAnemia1 = 0;
    private int xHemorragia1 = 0;
    private int xVaginal1 = 0;
    private int xProlongado1 = 0;
    private int xHTAc1 = 0;
    private int xRPM1 = 0;
    private int xPolihidramnios1 = 0;
    private int xRCIU1 = 0;
    private int xMultiple1 = 0;
    private int xMPresentacion1 = 0;
    private int xIsoInmunizacion = 0;
    private int xllanto = 0;
    private int xinsonmnio = 0;
    private int xtraspiracion = 0;
    private int xtiempo = 0;
    private int xespacio = 0;
    private int xdinero = 0;
    private int stotal1 = 0;
    private int stotal2 = 0;
    private int stotal3 = 0;
    private int stotal4 = 0;
    private int totalg = 0;
    private boolean xlleno = false;

    public JPRiesgoBiosicoSocial() {
        this.xregistro = 0.0d;
        initComponents();
        this.xregistro = mVerificaRegistro();
        mConsultaEdad();
        mIniciarComponentes();
        mCargarDatosEncabezado();
        mCargarDatosRespuestas();
        mIniciarTotales();
        setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS SEMANA: " + this.xregistro, 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
    }

    private void initComponents() {
        this.JBGHREdad = new ButtonGroup();
        this.JBGHRParidad = new ButtonGroup();
        this.JBGHRllanto1 = new ButtonGroup();
        this.JBGHRllanto2 = new ButtonGroup();
        this.JBGHRllanto3 = new ButtonGroup();
        this.JBGHRInsomnio1 = new ButtonGroup();
        this.JBGHRInsomnio2 = new ButtonGroup();
        this.JBGHRInsomnio3 = new ButtonGroup();
        this.JBGHRTraspiracion1 = new ButtonGroup();
        this.JBGHRTraspiracion2 = new ButtonGroup();
        this.JBGHRTraspiracion3 = new ButtonGroup();
        this.JBGHREltiempo1 = new ButtonGroup();
        this.JBGHREltiempo2 = new ButtonGroup();
        this.JBGHREltiempo3 = new ButtonGroup();
        this.JBGHREspacio1 = new ButtonGroup();
        this.JBGHREspacio2 = new ButtonGroup();
        this.JBGHREspacio3 = new ButtonGroup();
        this.JBGHRDinero1 = new ButtonGroup();
        this.JBGHRDinero2 = new ButtonGroup();
        this.JBGHRDinero3 = new ButtonGroup();
        this.JBGHRSemana14_27 = new ButtonGroup();
        this.JBGHRSemana27_32 = new ButtonGroup();
        this.JPHisReproductiva = new JPanel();
        this.JPEdad = new JPanel();
        this.JRBMenor_16 = new JRadioButton();
        this.JRBEntre16_35 = new JRadioButton();
        this.JRBEntreMas_35 = new JRadioButton();
        this.JPParidad = new JPanel();
        this.JRBCero = new JRadioButton();
        this.JRBParidad1_4 = new JRadioButton();
        this.JRBParidad5 = new JRadioButton();
        this.JCHBAborto = new JCheckBox();
        this.JCHBRetPlacenta = new JCheckBox();
        this.JCHBRecienNacido4000 = new JCheckBox();
        this.JCHBRecienNacido2500 = new JCheckBox();
        this.JCHBHTAInducida = new JCheckBox();
        this.JCHBEmbGemelar = new JCheckBox();
        this.JCHBMortinato = new JCheckBox();
        this.JCHBProlongado = new JCheckBox();
        this.JBGrabar = new JButton();
        this.JPCondiAsociadas = new JPanel();
        this.jLabel1 = new JLabel();
        this.JCBQx1 = new JComboBox();
        this.JCBQx2 = new JComboBox();
        this.JCBQx3 = new JComboBox();
        this.jLabel2 = new JLabel();
        this.JCBRenal1 = new JComboBox();
        this.JCBRenal2 = new JComboBox();
        this.JCBRenal3 = new JComboBox();
        this.jLabel3 = new JLabel();
        this.JCBDiabetesG1 = new JComboBox();
        this.JCBDiabetesG2 = new JComboBox();
        this.JCBDiabetesG3 = new JComboBox();
        this.jLabel4 = new JLabel();
        this.JCBDiabetesM1 = new JComboBox();
        this.JCBDiabetesM2 = new JComboBox();
        this.JCBDiabetesM3 = new JComboBox();
        this.jLabel5 = new JLabel();
        this.JCBECardiaca1 = new JComboBox();
        this.JCBECardiaca2 = new JComboBox();
        this.JCBECardiaca3 = new JComboBox();
        this.jLabel6 = new JLabel();
        this.JCBEInfecciosa1 = new JComboBox();
        this.JCBEInfecciosa2 = new JComboBox();
        this.JCBEInfecciosa3 = new JComboBox();
        this.jLabel8 = new JLabel();
        this.JCBEAuto1 = new JComboBox();
        this.JCBEAuto2 = new JComboBox();
        this.JCBEAuto3 = new JComboBox();
        this.jLabel9 = new JLabel();
        this.JCBAnemia1 = new JComboBox();
        this.JCBAnemia2 = new JComboBox();
        this.JCBAnemia3 = new JComboBox();
        this.jLabel10 = new JLabel();
        this.JTFSubtotal1 = new JFormattedTextField();
        this.JTFSubtotal2 = new JFormattedTextField();
        this.JTFSubtotal3 = new JFormattedTextField();
        this.JPEmbarazoActual = new JPanel();
        this.jLabel15 = new JLabel();
        this.JCBHemorragia1 = new JComboBox();
        this.JCBHemorragia2 = new JComboBox();
        this.JCBHemorragia3 = new JComboBox();
        this.jLabel16 = new JLabel();
        this.JCBVaginal1 = new JComboBox();
        this.JCBVaginal2 = new JComboBox();
        this.JCBVaginal3 = new JComboBox();
        this.jLabel17 = new JLabel();
        this.JCBProlongado = new JComboBox();
        this.jLabel18 = new JLabel();
        this.JCBHTA1 = new JComboBox();
        this.JCBHTA2 = new JComboBox();
        this.JCBHTA3 = new JComboBox();
        this.jLabel19 = new JLabel();
        this.JCBRPM1 = new JComboBox();
        this.JCBRPM2 = new JComboBox();
        this.JCBRPM3 = new JComboBox();
        this.jLabel20 = new JLabel();
        this.JCBPolih1 = new JComboBox();
        this.JCBPolih2 = new JComboBox();
        this.JCBPolih3 = new JComboBox();
        this.jLabel21 = new JLabel();
        this.JCBRCIU1 = new JComboBox();
        this.JCBRCIU2 = new JComboBox();
        this.JCBRCIU13 = new JComboBox();
        this.jLabel22 = new JLabel();
        this.JCBREmb1 = new JComboBox();
        this.JCBREmb2 = new JComboBox();
        this.JCBREmb3 = new JComboBox();
        this.jLabel23 = new JLabel();
        this.JCBMPresentacion = new JComboBox();
        this.jLabel24 = new JLabel();
        this.JCBIsoInm1 = new JComboBox();
        this.JCBIsoInm2 = new JComboBox();
        this.JCBIsoInm3 = new JComboBox();
        this.JTFSubtotal4 = new JFormattedTextField();
        this.JTFSubtotal5 = new JFormattedTextField();
        this.JTFSubtotal6 = new JFormattedTextField();
        this.jLabel25 = new JLabel();
        this.JPRSicosocial = new JPanel();
        this.JPResultado1 = new JPanel();
        this.JTFR1Valor1 = new JTextField();
        this.JTFR1Valor2 = new JTextField();
        this.JTFR1Valor3 = new JTextField();
        this.jLabel13 = new JLabel();
        this.JPResultado2 = new JPanel();
        this.jLabel14 = new JLabel();
        this.JTFR2Valor1 = new JTextField();
        this.JTFR2Valor2 = new JTextField();
        this.JTFR2Valor3 = new JTextField();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPDetalles = new JPanel();
        this.jLabel7 = new JLabel();
        this.JRBAusente1 = new JRadioButton();
        this.JRBIntenso1 = new JRadioButton();
        this.jLabel11 = new JLabel();
        this.JRBAusente2 = new JRadioButton();
        this.JRBIntenso2 = new JRadioButton();
        this.jLabel12 = new JLabel();
        this.JRBAusente3 = new JRadioButton();
        this.JRBIntenso3 = new JRadioButton();
        this.JLTiempo = new JLabel();
        this.JRBCasiTiempo = new JRadioButton();
        this.JRBVecesTiempo = new JRadioButton();
        this.JRBNuncaTiempo = new JRadioButton();
        this.JLEspacio = new JLabel();
        this.JRBCasiEspacio = new JRadioButton();
        this.JRBVecesEspacio = new JRadioButton();
        this.JRBNuncaEspacio = new JRadioButton();
        this.JLDinero = new JLabel();
        this.JRBCasiDinero = new JRadioButton();
        this.JRBVecesDinero = new JRadioButton();
        this.JRBNuncaDinero = new JRadioButton();
        this.jLabel26 = new JLabel();
        this.JPDetalles1 = new JPanel();
        this.jLabel27 = new JLabel();
        this.JRBAusente4 = new JRadioButton();
        this.JRBIntenso4 = new JRadioButton();
        this.jLabel28 = new JLabel();
        this.JRBAusente5 = new JRadioButton();
        this.JRBIntenso5 = new JRadioButton();
        this.jLabel29 = new JLabel();
        this.JRBAusente6 = new JRadioButton();
        this.JRBIntenso6 = new JRadioButton();
        this.JLTiempo1 = new JLabel();
        this.JRBCasiTiempo1 = new JRadioButton();
        this.JRBVecesTiempo1 = new JRadioButton();
        this.JRBNuncaTiempo1 = new JRadioButton();
        this.JLEspacio1 = new JLabel();
        this.JRBCasiEspacio1 = new JRadioButton();
        this.JRBVecesEspacio1 = new JRadioButton();
        this.JRBNuncaEspacio1 = new JRadioButton();
        this.JLDinero1 = new JLabel();
        this.JRBCasiDinero1 = new JRadioButton();
        this.JRBVecesDinero1 = new JRadioButton();
        this.JRBNuncaDinero1 = new JRadioButton();
        this.jLabel30 = new JLabel();
        this.JPDetalles2 = new JPanel();
        this.jLabel31 = new JLabel();
        this.JRBAusente7 = new JRadioButton();
        this.JRBIntenso7 = new JRadioButton();
        this.jLabel32 = new JLabel();
        this.JRBAusente8 = new JRadioButton();
        this.JRBIntenso8 = new JRadioButton();
        this.jLabel33 = new JLabel();
        this.JRBAusente9 = new JRadioButton();
        this.JRBIntenso9 = new JRadioButton();
        this.JLTiempo2 = new JLabel();
        this.JRBCasiTiempo2 = new JRadioButton();
        this.JRBVecesTiempo2 = new JRadioButton();
        this.JRBNuncaTiempo2 = new JRadioButton();
        this.JLEspacio2 = new JLabel();
        this.JRBCasiEspacio2 = new JRadioButton();
        this.JRBVecesEspacio2 = new JRadioButton();
        this.JRBNuncaEspacio2 = new JRadioButton();
        this.JLDinero2 = new JLabel();
        this.JRBCasiDinero2 = new JRadioButton();
        this.JRBVecesDinero2 = new JRadioButton();
        this.JRBNuncaDinero2 = new JRadioButton();
        this.jLabel34 = new JLabel();
        this.jPanel1 = new JPanel();
        this.JPTotal14_27 = new JPanel();
        this.JLSemana24_27 = new JLabel();
        this.JTFTotal1 = new JTextField();
        this.JLTotal1 = new JLabel();
        this.JPTotal28_38 = new JPanel();
        this.JLSemana28_32 = new JLabel();
        this.JTFTotal2 = new JTextField();
        this.JLTotal2 = new JLabel();
        this.JPTotal33_42 = new JPanel();
        this.JLSemana33_48 = new JLabel();
        this.JTFTotal3 = new JTextField();
        this.JLTotal3 = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpriesgobiosicosocial");
        this.JPHisReproductiva.setBorder(BorderFactory.createTitledBorder((Border) null, "I. HISTORIA REPRODUCTIVA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "EDAD", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGHREdad.add(this.JRBMenor_16);
        this.JRBMenor_16.setFont(new Font("Arial", 1, 12));
        this.JRBMenor_16.setForeground(new Color(0, 0, 255));
        this.JRBMenor_16.setText("Menos de 16           =1");
        this.JRBMenor_16.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.1
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBMenor_16ActionPerformed(evt);
            }
        });
        this.JBGHREdad.add(this.JRBEntre16_35);
        this.JRBEntre16_35.setFont(new Font("Arial", 1, 12));
        this.JRBEntre16_35.setForeground(new Color(0, 0, 255));
        this.JRBEntre16_35.setSelected(true);
        this.JRBEntre16_35.setText("Entre 16 y 35          =0");
        this.JRBEntre16_35.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.2
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBEntre16_35ActionPerformed(evt);
            }
        });
        this.JBGHREdad.add(this.JRBEntreMas_35);
        this.JRBEntreMas_35.setFont(new Font("Arial", 1, 12));
        this.JRBEntreMas_35.setForeground(new Color(0, 0, 255));
        this.JRBEntreMas_35.setText("Mas de 35               =2");
        this.JRBEntreMas_35.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.3
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBEntreMas_35ActionPerformed(evt);
            }
        });
        GroupLayout JPEdadLayout = new GroupLayout(this.JPEdad);
        this.JPEdad.setLayout(JPEdadLayout);
        JPEdadLayout.setHorizontalGroup(JPEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEdadLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBMenor_16).addComponent(this.JRBEntre16_35).addComponent(this.JRBEntreMas_35))));
        JPEdadLayout.setVerticalGroup(JPEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEdadLayout.createSequentialGroup().addComponent(this.JRBMenor_16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBEntre16_35).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBEntreMas_35).addContainerGap()));
        this.JPParidad.setBorder(BorderFactory.createTitledBorder((Border) null, "PARIDAD", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGHRParidad.add(this.JRBCero);
        this.JRBCero.setFont(new Font("Arial", 1, 12));
        this.JRBCero.setForeground(new Color(0, 0, 255));
        this.JRBCero.setSelected(true);
        this.JRBCero.setText("0                        =1");
        this.JRBCero.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.4
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCeroActionPerformed(evt);
            }
        });
        this.JBGHRParidad.add(this.JRBParidad1_4);
        this.JRBParidad1_4.setFont(new Font("Arial", 1, 12));
        this.JRBParidad1_4.setForeground(new Color(0, 0, 255));
        this.JRBParidad1_4.setText("1 - 4                   =0");
        this.JRBParidad1_4.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.5
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBParidad1_4ActionPerformed(evt);
            }
        });
        this.JBGHRParidad.add(this.JRBParidad5);
        this.JRBParidad5.setFont(new Font("Arial", 1, 12));
        this.JRBParidad5.setForeground(new Color(0, 0, 255));
        this.JRBParidad5.setText("5 ó más            =2");
        this.JRBParidad5.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.6
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBParidad5ActionPerformed(evt);
            }
        });
        GroupLayout JPParidadLayout = new GroupLayout(this.JPParidad);
        this.JPParidad.setLayout(JPParidadLayout);
        JPParidadLayout.setHorizontalGroup(JPParidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParidadLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPParidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBCero).addComponent(this.JRBParidad1_4).addComponent(this.JRBParidad5))));
        JPParidadLayout.setVerticalGroup(JPParidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParidadLayout.createSequentialGroup().addComponent(this.JRBCero).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBParidad1_4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBParidad5).addContainerGap()));
        this.JCHBAborto.setFont(new Font("Arial", 1, 12));
        this.JCHBAborto.setForeground(new Color(0, 0, 255));
        this.JCHBAborto.setText("Aborto habitual/Infertilidad =1");
        this.JCHBAborto.setHorizontalTextPosition(2);
        this.JCHBAborto.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.7
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JCHBAbortoActionPerformed(evt);
            }
        });
        this.JCHBRetPlacenta.setFont(new Font("Arial", 1, 12));
        this.JCHBRetPlacenta.setForeground(new Color(0, 0, 255));
        this.JCHBRetPlacenta.setText("Retención Placentaria         =1");
        this.JCHBRetPlacenta.setHorizontalTextPosition(2);
        this.JCHBRetPlacenta.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.8
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JCHBRetPlacentaActionPerformed(evt);
            }
        });
        this.JCHBRecienNacido4000.setFont(new Font("Arial", 1, 12));
        this.JCHBRecienNacido4000.setForeground(new Color(0, 0, 255));
        this.JCHBRecienNacido4000.setText("Recien Nacido > 4000gr      =1");
        this.JCHBRecienNacido4000.setHorizontalTextPosition(2);
        this.JCHBRecienNacido4000.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.9
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JCHBRecienNacido4000ActionPerformed(evt);
            }
        });
        this.JCHBRecienNacido2500.setFont(new Font("Arial", 1, 12));
        this.JCHBRecienNacido2500.setForeground(new Color(0, 0, 255));
        this.JCHBRecienNacido2500.setText("Recien Nacido <2500gr       =1");
        this.JCHBRecienNacido2500.setHorizontalTextPosition(2);
        this.JCHBRecienNacido2500.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.10
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JCHBRecienNacido2500ActionPerformed(evt);
            }
        });
        this.JCHBHTAInducida.setFont(new Font("Arial", 1, 12));
        this.JCHBHTAInducida.setForeground(new Color(0, 0, 255));
        this.JCHBHTAInducida.setText("HTA Inducida por Embarazo      =1");
        this.JCHBHTAInducida.setHorizontalTextPosition(2);
        this.JCHBHTAInducida.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.11
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JCHBHTAInducidaActionPerformed(evt);
            }
        });
        this.JCHBEmbGemelar.setFont(new Font("Arial", 1, 12));
        this.JCHBEmbGemelar.setForeground(new Color(0, 0, 255));
        this.JCHBEmbGemelar.setText("Emb.Gemelar/Cesarea Previa   =1");
        this.JCHBEmbGemelar.setHorizontalTextPosition(2);
        this.JCHBEmbGemelar.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.12
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JCHBEmbGemelarActionPerformed(evt);
            }
        });
        this.JCHBMortinato.setFont(new Font("Arial", 1, 12));
        this.JCHBMortinato.setForeground(new Color(0, 0, 255));
        this.JCHBMortinato.setText("Mortinato/Muerte Neonatal        =1");
        this.JCHBMortinato.setHorizontalTextPosition(2);
        this.JCHBMortinato.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.13
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JCHBMortinatoActionPerformed(evt);
            }
        });
        this.JCHBProlongado.setFont(new Font("Arial", 1, 12));
        this.JCHBProlongado.setForeground(new Color(0, 0, 255));
        this.JCHBProlongado.setText("T.P. Prolongado/Parto Dificil      =1");
        this.JCHBProlongado.setHorizontalTextPosition(2);
        this.JCHBProlongado.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.14
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JCHBProlongadoActionPerformed(evt);
            }
        });
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.15
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout JPHisReproductivaLayout = new GroupLayout(this.JPHisReproductiva);
        this.JPHisReproductiva.setLayout(JPHisReproductivaLayout);
        JPHisReproductivaLayout.setHorizontalGroup(JPHisReproductivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHisReproductivaLayout.createSequentialGroup().addComponent(this.JPEdad, -2, -1, -2).addGap(6, 6, 6).addComponent(this.JPParidad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPHisReproductivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBAborto).addComponent(this.JCHBRetPlacenta).addComponent(this.JCHBRecienNacido4000).addComponent(this.JCHBRecienNacido2500)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPHisReproductivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHBEmbGemelar).addComponent(this.JCHBHTAInducida).addComponent(this.JCHBProlongado).addComponent(this.JCHBMortinato)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBGrabar).addContainerGap()));
        JPHisReproductivaLayout.setVerticalGroup(JPHisReproductivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPParidad, -1, -1, 32767).addGroup(JPHisReproductivaLayout.createSequentialGroup().addGroup(JPHisReproductivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPHisReproductivaLayout.createSequentialGroup().addGroup(JPHisReproductivaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHBAborto).addComponent(this.JCHBHTAInducida)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPHisReproductivaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHBRetPlacenta).addComponent(this.JCHBEmbGemelar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPHisReproductivaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHBRecienNacido4000).addComponent(this.JCHBMortinato))).addGroup(JPHisReproductivaLayout.createSequentialGroup().addContainerGap().addComponent(this.JBGrabar, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPHisReproductivaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHBRecienNacido2500).addComponent(this.JCHBProlongado))).addComponent(this.JPEdad, -1, -1, 32767));
        this.JPCondiAsociadas.setBorder(BorderFactory.createTitledBorder((Border) null, "II. CONDICIONES ASOCIADAS", 0, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.jLabel1.setFont(new Font("Arial", 1, 11));
        this.jLabel1.setForeground(new Color(0, 0, 255));
        this.jLabel1.setText("Qx Ginecología Previo/Eptópico   =1");
        this.JCBQx1.setFont(new Font("Arial", 1, 12));
        this.JCBQx1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBQx1.setEnabled(false);
        this.JCBQx1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.16
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBQx1ItemStateChanged(evt);
            }
        });
        this.JCBQx2.setFont(new Font("Arial", 1, 12));
        this.JCBQx2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBQx2.setEnabled(false);
        this.JCBQx2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.17
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBQx2ItemStateChanged(evt);
            }
        });
        this.JCBQx3.setFont(new Font("Arial", 1, 12));
        this.JCBQx3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBQx3.setEnabled(false);
        this.JCBQx3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.18
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBQx3ItemStateChanged(evt);
            }
        });
        this.jLabel2.setFont(new Font("Arial", 1, 11));
        this.jLabel2.setForeground(new Color(0, 0, 255));
        this.jLabel2.setText("Enf. Renal Crónica                           =1");
        this.JCBRenal1.setFont(new Font("Arial", 1, 12));
        this.JCBRenal1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBRenal1.setEnabled(false);
        this.JCBRenal1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.19
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBRenal1ItemStateChanged(evt);
            }
        });
        this.JCBRenal2.setFont(new Font("Arial", 1, 12));
        this.JCBRenal2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBRenal2.setEnabled(false);
        this.JCBRenal2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.20
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBRenal2ItemStateChanged(evt);
            }
        });
        this.JCBRenal3.setFont(new Font("Arial", 1, 12));
        this.JCBRenal3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBRenal3.setEnabled(false);
        this.JCBRenal3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.21
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBRenal3ItemStateChanged(evt);
            }
        });
        this.jLabel3.setFont(new Font("Arial", 1, 11));
        this.jLabel3.setForeground(new Color(0, 0, 255));
        this.jLabel3.setText("Diabetes Gestacional                     =2");
        this.JCBDiabetesG1.setFont(new Font("Arial", 1, 12));
        this.JCBDiabetesG1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBDiabetesG1.setEnabled(false);
        this.JCBDiabetesG1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.22
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBDiabetesG1ItemStateChanged(evt);
            }
        });
        this.JCBDiabetesG2.setFont(new Font("Arial", 1, 12));
        this.JCBDiabetesG2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBDiabetesG2.setEnabled(false);
        this.JCBDiabetesG2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.23
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBDiabetesG2ItemStateChanged(evt);
            }
        });
        this.JCBDiabetesG3.setFont(new Font("Arial", 1, 12));
        this.JCBDiabetesG3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBDiabetesG3.setEnabled(false);
        this.JCBDiabetesG3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.24
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBDiabetesG3ItemStateChanged(evt);
            }
        });
        this.jLabel4.setFont(new Font("Arial", 1, 11));
        this.jLabel4.setForeground(new Color(0, 0, 255));
        this.jLabel4.setText("Diabetes Mellitus                            =3");
        this.JCBDiabetesM1.setFont(new Font("Arial", 1, 12));
        this.JCBDiabetesM1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBDiabetesM1.setEnabled(false);
        this.JCBDiabetesM1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.25
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBDiabetesM1ItemStateChanged(evt);
            }
        });
        this.JCBDiabetesM2.setFont(new Font("Arial", 1, 12));
        this.JCBDiabetesM2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBDiabetesM2.setEnabled(false);
        this.JCBDiabetesM2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.26
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBDiabetesM2ItemStateChanged(evt);
            }
        });
        this.JCBDiabetesM3.setFont(new Font("Arial", 1, 12));
        this.JCBDiabetesM3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBDiabetesM3.setEnabled(false);
        this.JCBDiabetesM3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.27
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBDiabetesM3ItemStateChanged(evt);
            }
        });
        this.jLabel5.setFont(new Font("Arial", 1, 11));
        this.jLabel5.setForeground(new Color(0, 0, 255));
        this.jLabel5.setText("Enf. Cardiaca                                    =3");
        this.JCBECardiaca1.setFont(new Font("Arial", 1, 12));
        this.JCBECardiaca1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBECardiaca1.setEnabled(false);
        this.JCBECardiaca1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.28
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBECardiaca1ItemStateChanged(evt);
            }
        });
        this.JCBECardiaca2.setFont(new Font("Arial", 1, 12));
        this.JCBECardiaca2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBECardiaca2.setEnabled(false);
        this.JCBECardiaca2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.29
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBECardiaca2ItemStateChanged(evt);
            }
        });
        this.JCBECardiaca3.setFont(new Font("Arial", 1, 12));
        this.JCBECardiaca3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBECardiaca3.setEnabled(false);
        this.JCBECardiaca3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.30
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBECardiaca3ItemStateChanged(evt);
            }
        });
        this.jLabel6.setFont(new Font("Arial", 1, 11));
        this.jLabel6.setForeground(new Color(0, 0, 255));
        this.jLabel6.setText("Enf. Infecciosa Aguda                     =1");
        this.JCBEInfecciosa1.setFont(new Font("Arial", 1, 12));
        this.JCBEInfecciosa1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBEInfecciosa1.setEnabled(false);
        this.JCBEInfecciosa1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.31
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBEInfecciosa1ItemStateChanged(evt);
            }
        });
        this.JCBEInfecciosa2.setFont(new Font("Arial", 1, 12));
        this.JCBEInfecciosa2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBEInfecciosa2.setEnabled(false);
        this.JCBEInfecciosa2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.32
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBEInfecciosa2ItemStateChanged(evt);
            }
        });
        this.JCBEInfecciosa3.setFont(new Font("Arial", 1, 12));
        this.JCBEInfecciosa3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBEInfecciosa3.setEnabled(false);
        this.JCBEInfecciosa3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.33
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBEInfecciosa3ItemStateChanged(evt);
            }
        });
        this.jLabel8.setFont(new Font("Arial", 1, 11));
        this.jLabel8.setForeground(new Color(0, 0, 255));
        this.jLabel8.setText("Enf. Autoinmune                             =3");
        this.JCBEAuto1.setFont(new Font("Arial", 1, 12));
        this.JCBEAuto1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBEAuto1.setEnabled(false);
        this.JCBEAuto1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.34
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBEAuto1ItemStateChanged(evt);
            }
        });
        this.JCBEAuto2.setFont(new Font("Arial", 1, 12));
        this.JCBEAuto2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBEAuto2.setEnabled(false);
        this.JCBEAuto2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.35
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBEAuto2ItemStateChanged(evt);
            }
        });
        this.JCBEAuto3.setFont(new Font("Arial", 1, 12));
        this.JCBEAuto3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBEAuto3.setEnabled(false);
        this.JCBEAuto3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.36
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBEAuto3ItemStateChanged(evt);
            }
        });
        this.jLabel9.setFont(new Font("Arial", 1, 11));
        this.jLabel9.setForeground(new Color(0, 0, 255));
        this.jLabel9.setText("Anemia (Hb < 10g /L)                       =1");
        this.JCBAnemia1.setFont(new Font("Arial", 1, 12));
        this.JCBAnemia1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBAnemia1.setEnabled(false);
        this.JCBAnemia1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.37
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBAnemia1ItemStateChanged(evt);
            }
        });
        this.JCBAnemia2.setFont(new Font("Arial", 1, 12));
        this.JCBAnemia2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBAnemia2.setEnabled(false);
        this.JCBAnemia2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.38
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBAnemia2ItemStateChanged(evt);
            }
        });
        this.JCBAnemia3.setFont(new Font("Arial", 1, 12));
        this.JCBAnemia3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBAnemia3.setEnabled(false);
        this.JCBAnemia3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.39
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBAnemia3ItemStateChanged(evt);
            }
        });
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(0, 0, 255));
        this.jLabel10.setText("Sub. Total");
        this.JTFSubtotal1.setBorder(BorderFactory.createTitledBorder((Border) null, "14-27", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFSubtotal1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JTFSubtotal1.setHorizontalAlignment(4);
        this.JTFSubtotal1.setText("0");
        this.JTFSubtotal1.setToolTipText("");
        this.JTFSubtotal1.setFont(new Font("Arial", 1, 12));
        this.JTFSubtotal2.setBorder(BorderFactory.createTitledBorder((Border) null, "28-32", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFSubtotal2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JTFSubtotal2.setHorizontalAlignment(4);
        this.JTFSubtotal2.setText("0");
        this.JTFSubtotal2.setToolTipText("");
        this.JTFSubtotal2.setFont(new Font("Arial", 1, 12));
        this.JTFSubtotal3.setBorder(BorderFactory.createTitledBorder((Border) null, "33-42", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFSubtotal3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JTFSubtotal3.setHorizontalAlignment(4);
        this.JTFSubtotal3.setText("0");
        this.JTFSubtotal3.setToolTipText("");
        this.JTFSubtotal3.setFont(new Font("Arial", 1, 12));
        GroupLayout JPCondiAsociadasLayout = new GroupLayout(this.JPCondiAsociadas);
        this.JPCondiAsociadas.setLayout(JPCondiAsociadasLayout);
        JPCondiAsociadasLayout.setHorizontalGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPCondiAsociadasLayout.createSequentialGroup().addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel4, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel8, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel6, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel9, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addComponent(this.JCBQx1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBQx2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBQx3, -2, -1, -2)).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addComponent(this.JCBRenal1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBRenal2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBRenal3, -2, -1, -2)).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addComponent(this.JCBDiabetesG1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDiabetesG2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDiabetesG3, -2, -1, -2)).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addComponent(this.JCBDiabetesM1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDiabetesM2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDiabetesM3, -2, -1, -2)).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addComponent(this.JCBECardiaca1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBECardiaca2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBECardiaca3, -2, -1, -2)).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addComponent(this.JCBEInfecciosa1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEInfecciosa2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEInfecciosa3, -2, -1, -2)).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addComponent(this.JCBEAuto1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEAuto2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEAuto3, -2, -1, -2)).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addComponent(this.JCBAnemia1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBAnemia2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBAnemia3, -2, -1, -2)))).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel10, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFSubtotal1, -2, 55, -2).addGap(18, 18, 18).addComponent(this.JTFSubtotal2, -2, 55, -2).addGap(18, 18, 18).addComponent(this.JTFSubtotal3, -2, 55, -2).addGap(96, 96, 96))).addContainerGap()));
        JPCondiAsociadasLayout.setVerticalGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCondiAsociadasLayout.createSequentialGroup().addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.JCBQx1, -2, -1, -2).addComponent(this.JCBQx2, -2, -1, -2).addComponent(this.JCBQx3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.JCBRenal1, -2, -1, -2).addComponent(this.JCBRenal2, -2, -1, -2).addComponent(this.JCBRenal3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.JCBDiabetesG1, -2, -1, -2).addComponent(this.JCBDiabetesG2, -2, -1, -2).addComponent(this.JCBDiabetesG3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.JCBDiabetesM1, -2, -1, -2).addComponent(this.JCBDiabetesM2, -2, -1, -2).addComponent(this.JCBDiabetesM3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.JCBECardiaca1, -2, -1, -2).addComponent(this.JCBECardiaca2, -2, -1, -2).addComponent(this.JCBECardiaca3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.JCBEInfecciosa1, -2, -1, -2).addComponent(this.JCBEInfecciosa2, -2, -1, -2).addComponent(this.JCBEInfecciosa3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.JCBEAuto1, -2, -1, -2).addComponent(this.JCBEAuto2, -2, -1, -2).addComponent(this.JCBEAuto3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.JCBAnemia1, -2, -1, -2).addComponent(this.JCBAnemia2, -2, -1, -2).addComponent(this.JCBAnemia3, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCondiAsociadasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFSubtotal1, -2, 36, -2).addComponent(this.JTFSubtotal2, -2, 36, -2).addComponent(this.JTFSubtotal3, -2, 36, -2)).addComponent(this.jLabel10, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        this.JPEmbarazoActual.setBorder(BorderFactory.createTitledBorder((Border) null, "III. EMBARAZO ACTUAL ", 0, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.jLabel15.setFont(new Font("Arial", 1, 11));
        this.jLabel15.setForeground(new Color(0, 0, 255));
        this.jLabel15.setText("Hemorragia <= 20 Sem                      =1");
        this.JCBHemorragia1.setFont(new Font("Arial", 1, 12));
        this.JCBHemorragia1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBHemorragia1.setEnabled(false);
        this.JCBHemorragia1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.40
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBHemorragia1ItemStateChanged(evt);
            }
        });
        this.JCBHemorragia2.setFont(new Font("Arial", 1, 12));
        this.JCBHemorragia2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBHemorragia2.setEnabled(false);
        this.JCBHemorragia2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.41
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBHemorragia2ItemStateChanged(evt);
            }
        });
        this.JCBHemorragia3.setFont(new Font("Arial", 1, 12));
        this.JCBHemorragia3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBHemorragia3.setEnabled(false);
        this.JCBHemorragia3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.42
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBHemorragia3ItemStateChanged(evt);
            }
        });
        this.jLabel16.setFont(new Font("Arial", 1, 11));
        this.jLabel16.setForeground(new Color(0, 0, 255));
        this.jLabel16.setText("Vaginal > 20 Sem                                =3");
        this.JCBVaginal1.setFont(new Font("Arial", 1, 12));
        this.JCBVaginal1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBVaginal1.setEnabled(false);
        this.JCBVaginal1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.43
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBVaginal1ItemStateChanged(evt);
            }
        });
        this.JCBVaginal2.setFont(new Font("Arial", 1, 12));
        this.JCBVaginal2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBVaginal2.setEnabled(false);
        this.JCBVaginal2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.44
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBVaginal2ItemStateChanged(evt);
            }
        });
        this.JCBVaginal3.setFont(new Font("Arial", 1, 12));
        this.JCBVaginal3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBVaginal3.setEnabled(false);
        this.JCBVaginal3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.45
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBVaginal3ItemStateChanged(evt);
            }
        });
        this.jLabel17.setFont(new Font("Arial", 1, 11));
        this.jLabel17.setForeground(new Color(0, 0, 255));
        this.jLabel17.setText("E. Prolongado  (42 Sem)                    =1");
        this.JCBProlongado.setFont(new Font("Arial", 1, 12));
        this.JCBProlongado.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBProlongado.setEnabled(false);
        this.JCBProlongado.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.46
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBProlongadoItemStateChanged(evt);
            }
        });
        this.jLabel18.setFont(new Font("Arial", 1, 11));
        this.jLabel18.setForeground(new Color(0, 0, 255));
        this.jLabel18.setText("HTA                                                       =2");
        this.JCBHTA1.setFont(new Font("Arial", 1, 12));
        this.JCBHTA1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBHTA1.setEnabled(false);
        this.JCBHTA1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.47
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBHTA1ItemStateChanged(evt);
            }
        });
        this.JCBHTA2.setFont(new Font("Arial", 1, 12));
        this.JCBHTA2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBHTA2.setEnabled(false);
        this.JCBHTA2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.48
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBHTA2ItemStateChanged(evt);
            }
        });
        this.JCBHTA3.setFont(new Font("Arial", 1, 12));
        this.JCBHTA3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBHTA3.setEnabled(false);
        this.JCBHTA3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.49
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBHTA3ItemStateChanged(evt);
            }
        });
        this.jLabel19.setFont(new Font("Arial", 1, 11));
        this.jLabel19.setForeground(new Color(0, 0, 255));
        this.jLabel19.setText("RPM                                                      =2");
        this.JCBRPM1.setFont(new Font("Arial", 1, 12));
        this.JCBRPM1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBRPM1.setEnabled(false);
        this.JCBRPM1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.50
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBRPM1ItemStateChanged(evt);
            }
        });
        this.JCBRPM2.setFont(new Font("Arial", 1, 12));
        this.JCBRPM2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBRPM2.setEnabled(false);
        this.JCBRPM2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.51
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBRPM2ItemStateChanged(evt);
            }
        });
        this.JCBRPM3.setFont(new Font("Arial", 1, 12));
        this.JCBRPM3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBRPM3.setEnabled(false);
        this.JCBRPM3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.52
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBRPM3ItemStateChanged(evt);
            }
        });
        this.jLabel20.setFont(new Font("Arial", 1, 11));
        this.jLabel20.setForeground(new Color(0, 0, 255));
        this.jLabel20.setText("Polihidramnios                                  =2");
        this.JCBPolih1.setFont(new Font("Arial", 1, 12));
        this.JCBPolih1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBPolih1.setEnabled(false);
        this.JCBPolih1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.53
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBPolih1ItemStateChanged(evt);
            }
        });
        this.JCBPolih2.setFont(new Font("Arial", 1, 12));
        this.JCBPolih2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBPolih2.setEnabled(false);
        this.JCBPolih2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.54
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBPolih2ItemStateChanged(evt);
            }
        });
        this.JCBPolih3.setFont(new Font("Arial", 1, 12));
        this.JCBPolih3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBPolih3.setEnabled(false);
        this.JCBPolih3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.55
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBPolih3ItemStateChanged(evt);
            }
        });
        this.jLabel21.setFont(new Font("Arial", 1, 11));
        this.jLabel21.setForeground(new Color(0, 0, 255));
        this.jLabel21.setText("RCIU                                                     =3");
        this.JCBRCIU1.setFont(new Font("Arial", 1, 12));
        this.JCBRCIU1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBRCIU1.setEnabled(false);
        this.JCBRCIU1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.56
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBRCIU1ItemStateChanged(evt);
            }
        });
        this.JCBRCIU2.setFont(new Font("Arial", 1, 12));
        this.JCBRCIU2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBRCIU2.setEnabled(false);
        this.JCBRCIU2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.57
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBRCIU2ItemStateChanged(evt);
            }
        });
        this.JCBRCIU13.setFont(new Font("Arial", 1, 12));
        this.JCBRCIU13.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBRCIU13.setEnabled(false);
        this.JCBRCIU13.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.58
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBRCIU13ItemStateChanged(evt);
            }
        });
        this.jLabel22.setFont(new Font("Arial", 1, 11));
        this.jLabel22.setForeground(new Color(0, 0, 255));
        this.jLabel22.setText("Emb. Multiple                                    =3");
        this.JCBREmb1.setFont(new Font("Arial", 1, 12));
        this.JCBREmb1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBREmb1.setEnabled(false);
        this.JCBREmb1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.59
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBREmb1ItemStateChanged(evt);
            }
        });
        this.JCBREmb2.setFont(new Font("Arial", 1, 12));
        this.JCBREmb2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBREmb2.setEnabled(false);
        this.JCBREmb2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.60
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBREmb2ItemStateChanged(evt);
            }
        });
        this.JCBREmb3.setFont(new Font("Arial", 1, 12));
        this.JCBREmb3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBREmb3.setEnabled(false);
        this.JCBREmb3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.61
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBREmb3ItemStateChanged(evt);
            }
        });
        this.jLabel23.setFont(new Font("Arial", 1, 11));
        this.jLabel23.setForeground(new Color(0, 0, 255));
        this.jLabel23.setText("Mala Presentacion                           =3");
        this.JCBMPresentacion.setFont(new Font("Arial", 1, 12));
        this.JCBMPresentacion.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBMPresentacion.setEnabled(false);
        this.JCBMPresentacion.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.62
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBMPresentacionItemStateChanged(evt);
            }
        });
        this.jLabel24.setFont(new Font("Arial", 1, 11));
        this.jLabel24.setForeground(new Color(0, 0, 255));
        this.jLabel24.setText("IsoInmunización  RH                        =3");
        this.JCBIsoInm1.setFont(new Font("Arial", 1, 12));
        this.JCBIsoInm1.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBIsoInm1.setEnabled(false);
        this.JCBIsoInm1.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.63
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBIsoInm1ItemStateChanged(evt);
            }
        });
        this.JCBIsoInm2.setFont(new Font("Arial", 1, 12));
        this.JCBIsoInm2.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBIsoInm2.setEnabled(false);
        this.JCBIsoInm2.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.64
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBIsoInm2ItemStateChanged(evt);
            }
        });
        this.JCBIsoInm3.setFont(new Font("Arial", 1, 12));
        this.JCBIsoInm3.setModel(new DefaultComboBoxModel(new String[]{"-", "No", "Sí"}));
        this.JCBIsoInm3.setEnabled(false);
        this.JCBIsoInm3.addItemListener(new ItemListener() { // from class: Historia.JPRiesgoBiosicoSocial.65
            public void itemStateChanged(ItemEvent evt) {
                JPRiesgoBiosicoSocial.this.JCBIsoInm3ItemStateChanged(evt);
            }
        });
        this.JTFSubtotal4.setBorder(BorderFactory.createTitledBorder((Border) null, "14-27", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFSubtotal4.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JTFSubtotal4.setHorizontalAlignment(4);
        this.JTFSubtotal4.setText("0");
        this.JTFSubtotal4.setToolTipText("");
        this.JTFSubtotal4.setFont(new Font("Arial", 1, 12));
        this.JTFSubtotal5.setBorder(BorderFactory.createTitledBorder((Border) null, "28-32", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTFSubtotal5.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JTFSubtotal5.setHorizontalAlignment(4);
        this.JTFSubtotal5.setText("0");
        this.JTFSubtotal5.setToolTipText("");
        this.JTFSubtotal5.setFont(new Font("Arial", 1, 12));
        this.JTFSubtotal6.setBorder(BorderFactory.createTitledBorder((Border) null, "33-42", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFSubtotal6.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JTFSubtotal6.setHorizontalAlignment(4);
        this.JTFSubtotal6.setText("0");
        this.JTFSubtotal6.setToolTipText("");
        this.JTFSubtotal6.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setForeground(new Color(0, 0, 255));
        this.jLabel25.setText("Sub. Total");
        GroupLayout JPEmbarazoActualLayout = new GroupLayout(this.JPEmbarazoActual);
        this.JPEmbarazoActual.setLayout(JPEmbarazoActualLayout);
        JPEmbarazoActualLayout.setHorizontalGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.jLabel21, -1, -1, 32767).addGap(175, 175, 175)).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createSequentialGroup().addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel17, -1, -1, 32767).addComponent(this.jLabel22, -2, 198, -2).addComponent(this.jLabel23, -2, 198, -2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel20, -1, -1, 32767).addComponent(this.jLabel19, -1, -1, 32767).addComponent(this.jLabel18, -1, 201, 32767)).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel15, -1, -1, 32767).addComponent(this.jLabel16, -1, -1, 32767)).addComponent(this.jLabel24, -2, 198, -2)).addGap(10, 10, 10).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.JCBREmb1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBREmb2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBREmb3, -2, -1, -2)).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.JCBHTA1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBHTA2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBHTA3, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.JCBRPM1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBRPM2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBRPM3, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.JCBPolih1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPolih2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPolih3, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.JCBRCIU1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBRCIU2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBRCIU13, -2, -1, -2))).addGroup(JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.JCBIsoInm1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBIsoInm2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMPresentacion, -2, -1, -2).addComponent(this.JCBIsoInm3, -2, -1, -2))).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProlongado, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.JCBVaginal1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBVaginal2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBVaginal3, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.JCBHemorragia1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBHemorragia2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBHemorragia3, -2, -1, -2)))).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel25, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFSubtotal4, -2, 55, -2).addGap(18, 18, 18).addComponent(this.JTFSubtotal5, -2, 55, -2).addGap(18, 18, 18).addComponent(this.JTFSubtotal6, -2, 55, -2).addGap(63, 63, 63)));
        JPEmbarazoActualLayout.setVerticalGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEmbarazoActualLayout.createSequentialGroup().addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.JCBHemorragia1, -2, -1, -2).addComponent(this.JCBHemorragia2, -2, -1, -2).addComponent(this.JCBHemorragia3, -2, -1, -2)).addGap(2, 2, 2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.JCBVaginal1, -2, -1, -2).addComponent(this.JCBVaginal2, -2, -1, -2).addComponent(this.JCBVaginal3, -2, -1, -2)).addGap(2, 2, 2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.JCBProlongado, -2, -1, -2)).addGap(2, 2, 2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel18).addComponent(this.JCBHTA1, -2, -1, -2).addComponent(this.JCBHTA2, -2, -1, -2).addComponent(this.JCBHTA3, -2, -1, -2)).addGap(2, 2, 2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel19).addComponent(this.JCBRPM1, -2, -1, -2).addComponent(this.JCBRPM2, -2, -1, -2).addComponent(this.JCBRPM3, -2, -1, -2)).addGap(2, 2, 2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel20).addComponent(this.JCBPolih1, -2, -1, -2).addComponent(this.JCBPolih2, -2, -1, -2).addComponent(this.JCBPolih3, -2, -1, -2)).addGap(2, 2, 2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel21).addComponent(this.JCBRCIU1, -2, -1, -2).addComponent(this.JCBRCIU2, -2, -1, -2).addComponent(this.JCBRCIU13, -2, -1, -2)).addGap(2, 2, 2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.JCBREmb1, -2, -1, -2).addComponent(this.JCBREmb2, -2, -1, -2).addComponent(this.JCBREmb3, -2, -1, -2)).addGap(2, 2, 2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel23).addComponent(this.JCBMPresentacion, -2, -1, -2)).addGap(2, 2, 2).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel24).addComponent(this.JCBIsoInm1, -2, -1, -2).addComponent(this.JCBIsoInm2, -2, -1, -2).addComponent(this.JCBIsoInm3, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFSubtotal4, -2, 36, -2).addComponent(this.JTFSubtotal5, -2, 36, -2).addComponent(this.JTFSubtotal6, -2, 36, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPEmbarazoActualLayout.createSequentialGroup().addComponent(this.jLabel25).addContainerGap()))));
        this.JPRSicosocial.setBorder(BorderFactory.createTitledBorder((Border) null, "IV. RIESGO PSICOSOCIAL ", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPResultado1.setBorder(BorderFactory.createTitledBorder(""));
        this.JTFR1Valor1.setFont(new Font("Arial", 1, 12));
        this.JTFR1Valor1.setHorizontalAlignment(4);
        this.JTFR1Valor1.setText("0");
        this.JTFR1Valor2.setFont(new Font("Arial", 1, 12));
        this.JTFR1Valor2.setHorizontalAlignment(4);
        this.JTFR1Valor2.setText("0");
        this.JTFR1Valor3.setFont(new Font("Arial", 1, 12));
        this.JTFR1Valor3.setHorizontalAlignment(4);
        this.JTFR1Valor3.setText("0");
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(0, 0, 255));
        this.jLabel13.setText("2 o más items con Intenso = 1");
        GroupLayout JPResultado1Layout = new GroupLayout(this.JPResultado1);
        this.JPResultado1.setLayout(JPResultado1Layout);
        JPResultado1Layout.setHorizontalGroup(JPResultado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPResultado1Layout.createSequentialGroup().addContainerGap().addGroup(JPResultado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPResultado1Layout.createSequentialGroup().addComponent(this.JTFR1Valor1, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFR1Valor2, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFR1Valor3, -2, 38, -2)).addComponent(this.jLabel13)).addContainerGap(-1, 32767)));
        JPResultado1Layout.setVerticalGroup(JPResultado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPResultado1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel13).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPResultado1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFR1Valor1, -2, -1, -2).addComponent(this.JTFR1Valor2, -2, -1, -2).addComponent(this.JTFR1Valor3, -2, -1, -2)).addGap(18, 18, 18)));
        this.JPResultado2.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(Color.blue);
        this.jLabel14.setText("2 o más items con Nunca = 1");
        this.JTFR2Valor1.setFont(new Font("Arial", 1, 12));
        this.JTFR2Valor1.setHorizontalAlignment(4);
        this.JTFR2Valor1.setText("0");
        this.JTFR2Valor2.setFont(new Font("Arial", 1, 12));
        this.JTFR2Valor2.setHorizontalAlignment(4);
        this.JTFR2Valor2.setText("0");
        this.JTFR2Valor3.setFont(new Font("Arial", 1, 12));
        this.JTFR2Valor3.setHorizontalAlignment(4);
        this.JTFR2Valor3.setText("0");
        GroupLayout JPResultado2Layout = new GroupLayout(this.JPResultado2);
        this.JPResultado2.setLayout(JPResultado2Layout);
        JPResultado2Layout.setHorizontalGroup(JPResultado2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPResultado2Layout.createSequentialGroup().addContainerGap().addGroup(JPResultado2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPResultado2Layout.createSequentialGroup().addComponent(this.JTFR2Valor1, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFR2Valor2, -2, 38, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFR2Valor3, -2, 38, -2)).addComponent(this.jLabel14)).addContainerGap(-1, 32767)));
        JPResultado2Layout.setVerticalGroup(JPResultado2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPResultado2Layout.createSequentialGroup().addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPResultado2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFR2Valor1, -2, -1, -2).addComponent(this.JTFR2Valor2, -2, -1, -2).addComponent(this.JTFR2Valor3, -2, -1, -2)).addContainerGap(67, 32767)));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPDetalles.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("Llanto fácil, tensión muscular, sobresalto, temblor, no poder quedarse quieta");
        this.JBGHRllanto1.add(this.JRBAusente1);
        this.JRBAusente1.setFont(new Font("Arial", 1, 12));
        this.JRBAusente1.setForeground(new Color(0, 0, 255));
        this.JRBAusente1.setSelected(true);
        this.JRBAusente1.setText("Ausente");
        this.JRBAusente1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.66
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBAusente1ActionPerformed(evt);
            }
        });
        this.JBGHRllanto1.add(this.JRBIntenso1);
        this.JRBIntenso1.setFont(new Font("Arial", 1, 12));
        this.JRBIntenso1.setForeground(new Color(0, 0, 255));
        this.JRBIntenso1.setText("Intenso");
        this.JRBIntenso1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.67
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBIntenso1ActionPerformed(evt);
            }
        });
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("Insomnio, falta de interés, no disfruta pasatiempos, depresión, mal genio");
        this.JBGHRInsomnio1.add(this.JRBAusente2);
        this.JRBAusente2.setFont(new Font("Arial", 1, 12));
        this.JRBAusente2.setForeground(new Color(0, 0, 255));
        this.JRBAusente2.setSelected(true);
        this.JRBAusente2.setText("Ausente");
        this.JRBAusente2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.68
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBAusente2ActionPerformed(evt);
            }
        });
        this.JBGHRInsomnio1.add(this.JRBIntenso2);
        this.JRBIntenso2.setFont(new Font("Arial", 1, 12));
        this.JRBIntenso2.setForeground(new Color(0, 0, 255));
        this.JRBIntenso2.setText("Intenso");
        this.JRBIntenso2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.69
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBIntenso2ActionPerformed(evt);
            }
        });
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("Traspiración manos, boca seca, accesos a rubor, palidez, cefalea de tensión");
        this.JBGHRTraspiracion1.add(this.JRBAusente3);
        this.JRBAusente3.setFont(new Font("Arial", 1, 12));
        this.JRBAusente3.setForeground(new Color(0, 0, 255));
        this.JRBAusente3.setSelected(true);
        this.JRBAusente3.setText("Ausente");
        this.JRBAusente3.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.70
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBAusente3ActionPerformed(evt);
            }
        });
        this.JBGHRTraspiracion1.add(this.JRBIntenso3);
        this.JRBIntenso3.setFont(new Font("Arial", 1, 12));
        this.JRBIntenso3.setForeground(new Color(0, 0, 255));
        this.JRBIntenso3.setText("Intenso");
        this.JRBIntenso3.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.71
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBIntenso3ActionPerformed(evt);
            }
        });
        this.JLTiempo.setFont(new Font("Arial", 1, 12));
        this.JLTiempo.setText("El tiempo");
        this.JBGHREltiempo1.add(this.JRBCasiTiempo);
        this.JRBCasiTiempo.setFont(new Font("Arial", 1, 12));
        this.JRBCasiTiempo.setForeground(new Color(0, 0, 255));
        this.JRBCasiTiempo.setSelected(true);
        this.JRBCasiTiempo.setText("Casi siempre");
        this.JRBCasiTiempo.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.72
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCasiTiempoActionPerformed(evt);
            }
        });
        this.JBGHREltiempo1.add(this.JRBVecesTiempo);
        this.JRBVecesTiempo.setFont(new Font("Arial", 1, 12));
        this.JRBVecesTiempo.setForeground(new Color(0, 0, 255));
        this.JRBVecesTiempo.setText("A veces");
        this.JRBVecesTiempo.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.73
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBVecesTiempoActionPerformed(evt);
            }
        });
        this.JBGHREltiempo1.add(this.JRBNuncaTiempo);
        this.JRBNuncaTiempo.setFont(new Font("Arial", 1, 12));
        this.JRBNuncaTiempo.setForeground(new Color(0, 0, 255));
        this.JRBNuncaTiempo.setText("Nunca");
        this.JRBNuncaTiempo.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.74
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBNuncaTiempoActionPerformed(evt);
            }
        });
        this.JLEspacio.setFont(new Font("Arial", 1, 12));
        this.JLEspacio.setText("El Espacio");
        this.JBGHREspacio1.add(this.JRBCasiEspacio);
        this.JRBCasiEspacio.setFont(new Font("Arial", 1, 12));
        this.JRBCasiEspacio.setForeground(new Color(0, 0, 255));
        this.JRBCasiEspacio.setSelected(true);
        this.JRBCasiEspacio.setText("Casi siempre");
        this.JRBCasiEspacio.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.75
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCasiEspacioActionPerformed(evt);
            }
        });
        this.JBGHREspacio1.add(this.JRBVecesEspacio);
        this.JRBVecesEspacio.setFont(new Font("Arial", 1, 12));
        this.JRBVecesEspacio.setForeground(new Color(0, 0, 255));
        this.JRBVecesEspacio.setText("A veces");
        this.JRBVecesEspacio.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.76
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBVecesEspacioActionPerformed(evt);
            }
        });
        this.JBGHREspacio1.add(this.JRBNuncaEspacio);
        this.JRBNuncaEspacio.setFont(new Font("Arial", 1, 12));
        this.JRBNuncaEspacio.setForeground(new Color(0, 0, 255));
        this.JRBNuncaEspacio.setText("Nunca");
        this.JRBNuncaEspacio.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.77
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBNuncaEspacioActionPerformed(evt);
            }
        });
        this.JLDinero.setFont(new Font("Arial", 1, 12));
        this.JLDinero.setText("El Dinero?");
        this.JBGHRDinero1.add(this.JRBCasiDinero);
        this.JRBCasiDinero.setFont(new Font("Arial", 1, 12));
        this.JRBCasiDinero.setForeground(new Color(0, 0, 255));
        this.JRBCasiDinero.setSelected(true);
        this.JRBCasiDinero.setText("Casi siempre");
        this.JRBCasiDinero.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.78
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCasiDineroActionPerformed(evt);
            }
        });
        this.JBGHRDinero1.add(this.JRBVecesDinero);
        this.JRBVecesDinero.setFont(new Font("Arial", 1, 12));
        this.JRBVecesDinero.setForeground(new Color(0, 0, 255));
        this.JRBVecesDinero.setText("A veces");
        this.JRBVecesDinero.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.79
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBVecesDineroActionPerformed(evt);
            }
        });
        this.JBGHRDinero1.add(this.JRBNuncaDinero);
        this.JRBNuncaDinero.setFont(new Font("Arial", 1, 12));
        this.JRBNuncaDinero.setForeground(new Color(0, 0, 255));
        this.JRBNuncaDinero.setText("Nunca");
        this.JRBNuncaDinero.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.80
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBNuncaDineroActionPerformed(evt);
            }
        });
        this.jLabel26.setFont(new Font("Arial", 0, 11));
        this.jLabel26.setText("<html><b>SOPORTE FAMILIAR</b><br>Satisfecha con la forma como usted comparte con su familia y/o compañero</html>");
        GroupLayout JPDetallesLayout = new GroupLayout(this.JPDetalles);
        this.JPDetalles.setLayout(JPDetallesLayout);
        JPDetallesLayout.setHorizontalGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetallesLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetallesLayout.createSequentialGroup().addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetallesLayout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAusente1)).addGroup(JPDetallesLayout.createSequentialGroup().addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11).addComponent(this.jLabel12)).addGap(10, 10, 10).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBAusente3).addComponent(this.JRBAusente2)))).addGap(18, 18, 18).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBIntenso1).addComponent(this.JRBIntenso3).addComponent(this.JRBIntenso2))).addGroup(JPDetallesLayout.createSequentialGroup().addComponent(this.jLabel26, -2, 224, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLTiempo, -2, 66, -2).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLEspacio, -2, 66, -2).addComponent(this.JLDinero, -2, 66, -2))).addGap(12, 12, 12).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDetallesLayout.createSequentialGroup().addComponent(this.JRBCasiDinero).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVecesDinero)).addGroup(GroupLayout.Alignment.TRAILING, JPDetallesLayout.createSequentialGroup().addComponent(this.JRBCasiEspacio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVecesEspacio)).addGroup(GroupLayout.Alignment.TRAILING, JPDetallesLayout.createSequentialGroup().addComponent(this.JRBCasiTiempo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVecesTiempo))).addGap(10, 10, 10).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNuncaDinero).addComponent(this.JRBNuncaEspacio).addComponent(this.JRBNuncaTiempo))))));
        JPDetallesLayout.setVerticalGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetallesLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.JRBAusente1).addComponent(this.JRBIntenso1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.JRBAusente2).addComponent(this.JRBIntenso2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.JRBAusente3).addComponent(this.JRBIntenso3)).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetallesLayout.createSequentialGroup().addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLTiempo).addComponent(this.JRBCasiTiempo).addComponent(this.JRBVecesTiempo).addComponent(this.JRBNuncaTiempo)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLEspacio).addComponent(this.JRBCasiEspacio).addComponent(this.JRBVecesEspacio).addComponent(this.JRBNuncaEspacio)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetallesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCasiDinero).addComponent(this.JRBVecesDinero).addComponent(this.JRBNuncaDinero)).addComponent(this.JLDinero)).addGap(0, 0, 32767)).addGroup(JPDetallesLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jLabel26).addContainerGap()))));
        this.jTabbedPane1.addTab("SEMANA 14-27", this.JPDetalles);
        this.JPDetalles1.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel27.setFont(new Font("Arial", 1, 12));
        this.jLabel27.setText("Llanto fácil, tensión muscular, sobresalto, temblor, no poder quedarse quieta");
        this.JBGHRllanto2.add(this.JRBAusente4);
        this.JRBAusente4.setFont(new Font("Arial", 1, 12));
        this.JRBAusente4.setForeground(new Color(0, 0, 255));
        this.JRBAusente4.setSelected(true);
        this.JRBAusente4.setText("Ausente");
        this.JRBAusente4.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.81
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBAusente4ActionPerformed(evt);
            }
        });
        this.JBGHRllanto2.add(this.JRBIntenso4);
        this.JRBIntenso4.setFont(new Font("Arial", 1, 12));
        this.JRBIntenso4.setForeground(new Color(0, 0, 255));
        this.JRBIntenso4.setText("Intenso");
        this.JRBIntenso4.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.82
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBIntenso4ActionPerformed(evt);
            }
        });
        this.jLabel28.setFont(new Font("Arial", 1, 12));
        this.jLabel28.setText("Insomnio, falta de interés, no disfruta pasatiempos, depresión, mal genio");
        this.JBGHRInsomnio2.add(this.JRBAusente5);
        this.JRBAusente5.setFont(new Font("Arial", 1, 12));
        this.JRBAusente5.setForeground(new Color(0, 0, 255));
        this.JRBAusente5.setSelected(true);
        this.JRBAusente5.setText("Ausente");
        this.JRBAusente5.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.83
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBAusente5ActionPerformed(evt);
            }
        });
        this.JBGHRInsomnio2.add(this.JRBIntenso5);
        this.JRBIntenso5.setFont(new Font("Arial", 1, 12));
        this.JRBIntenso5.setForeground(new Color(0, 0, 255));
        this.JRBIntenso5.setText("Intenso");
        this.JRBIntenso5.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.84
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBIntenso5ActionPerformed(evt);
            }
        });
        this.jLabel29.setFont(new Font("Arial", 1, 12));
        this.jLabel29.setText("Traspiración manos, boca seca, accesos a rubor, palidez, cefalea de tensión");
        this.JBGHRTraspiracion2.add(this.JRBAusente6);
        this.JRBAusente6.setFont(new Font("Arial", 1, 12));
        this.JRBAusente6.setForeground(new Color(0, 0, 255));
        this.JRBAusente6.setSelected(true);
        this.JRBAusente6.setText("Ausente");
        this.JRBAusente6.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.85
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBAusente6ActionPerformed(evt);
            }
        });
        this.JBGHRTraspiracion2.add(this.JRBIntenso6);
        this.JRBIntenso6.setFont(new Font("Arial", 1, 12));
        this.JRBIntenso6.setForeground(new Color(0, 0, 255));
        this.JRBIntenso6.setText("Intenso");
        this.JRBIntenso6.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.86
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBIntenso6ActionPerformed(evt);
            }
        });
        this.JLTiempo1.setFont(new Font("Arial", 1, 12));
        this.JLTiempo1.setText("El tiempo");
        this.JBGHREltiempo2.add(this.JRBCasiTiempo1);
        this.JRBCasiTiempo1.setFont(new Font("Arial", 1, 12));
        this.JRBCasiTiempo1.setForeground(new Color(0, 0, 255));
        this.JRBCasiTiempo1.setSelected(true);
        this.JRBCasiTiempo1.setText("Casi siempre");
        this.JRBCasiTiempo1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.87
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCasiTiempo1ActionPerformed(evt);
            }
        });
        this.JBGHREltiempo2.add(this.JRBVecesTiempo1);
        this.JRBVecesTiempo1.setFont(new Font("Arial", 1, 12));
        this.JRBVecesTiempo1.setForeground(new Color(0, 0, 255));
        this.JRBVecesTiempo1.setText("A veces");
        this.JRBVecesTiempo1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.88
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBVecesTiempo1ActionPerformed(evt);
            }
        });
        this.JBGHREltiempo2.add(this.JRBNuncaTiempo1);
        this.JRBNuncaTiempo1.setFont(new Font("Arial", 1, 12));
        this.JRBNuncaTiempo1.setForeground(new Color(0, 0, 255));
        this.JRBNuncaTiempo1.setText("Nunca");
        this.JRBNuncaTiempo1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.89
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBNuncaTiempo1ActionPerformed(evt);
            }
        });
        this.JLEspacio1.setFont(new Font("Arial", 1, 12));
        this.JLEspacio1.setText("El Espacio");
        this.JBGHREspacio2.add(this.JRBCasiEspacio1);
        this.JRBCasiEspacio1.setFont(new Font("Arial", 1, 12));
        this.JRBCasiEspacio1.setForeground(new Color(0, 0, 255));
        this.JRBCasiEspacio1.setSelected(true);
        this.JRBCasiEspacio1.setText("Casi siempre");
        this.JRBCasiEspacio1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.90
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCasiEspacio1ActionPerformed(evt);
            }
        });
        this.JBGHREspacio2.add(this.JRBVecesEspacio1);
        this.JRBVecesEspacio1.setFont(new Font("Arial", 1, 12));
        this.JRBVecesEspacio1.setForeground(new Color(0, 0, 255));
        this.JRBVecesEspacio1.setText("A veces");
        this.JRBVecesEspacio1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.91
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBVecesEspacio1ActionPerformed(evt);
            }
        });
        this.JBGHREspacio2.add(this.JRBNuncaEspacio1);
        this.JRBNuncaEspacio1.setFont(new Font("Arial", 1, 12));
        this.JRBNuncaEspacio1.setForeground(new Color(0, 0, 255));
        this.JRBNuncaEspacio1.setText("Nunca");
        this.JRBNuncaEspacio1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.92
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBNuncaEspacio1ActionPerformed(evt);
            }
        });
        this.JLDinero1.setFont(new Font("Arial", 1, 12));
        this.JLDinero1.setText("El Dinero?");
        this.JBGHRDinero2.add(this.JRBCasiDinero1);
        this.JRBCasiDinero1.setFont(new Font("Arial", 1, 12));
        this.JRBCasiDinero1.setForeground(new Color(0, 0, 255));
        this.JRBCasiDinero1.setSelected(true);
        this.JRBCasiDinero1.setText("Casi siempre");
        this.JRBCasiDinero1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.93
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCasiDinero1ActionPerformed(evt);
            }
        });
        this.JBGHRDinero2.add(this.JRBVecesDinero1);
        this.JRBVecesDinero1.setFont(new Font("Arial", 1, 12));
        this.JRBVecesDinero1.setForeground(new Color(0, 0, 255));
        this.JRBVecesDinero1.setText("A veces");
        this.JRBVecesDinero1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.94
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBVecesDinero1ActionPerformed(evt);
            }
        });
        this.JBGHRDinero2.add(this.JRBNuncaDinero1);
        this.JRBNuncaDinero1.setFont(new Font("Arial", 1, 12));
        this.JRBNuncaDinero1.setForeground(new Color(0, 0, 255));
        this.JRBNuncaDinero1.setText("Nunca");
        this.JRBNuncaDinero1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.95
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBNuncaDinero1ActionPerformed(evt);
            }
        });
        this.jLabel30.setFont(new Font("Arial", 0, 11));
        this.jLabel30.setText("<html><b>SOPORTE FAMILIAR</b><br>Satisfecha con la forma como usted comparte con su familia y/o compañero</html>");
        GroupLayout JPDetalles1Layout = new GroupLayout(this.JPDetalles1);
        this.JPDetalles1.setLayout(JPDetalles1Layout);
        JPDetalles1Layout.setHorizontalGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles1Layout.createSequentialGroup().addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles1Layout.createSequentialGroup().addComponent(this.jLabel27).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAusente4)).addGroup(JPDetalles1Layout.createSequentialGroup().addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel28).addComponent(this.jLabel29)).addGap(10, 10, 10).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBAusente6).addComponent(this.JRBAusente5)))).addGap(18, 18, 18).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBIntenso4).addComponent(this.JRBIntenso6).addComponent(this.JRBIntenso5))).addGroup(JPDetalles1Layout.createSequentialGroup().addComponent(this.jLabel30, -2, 224, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDetalles1Layout.createSequentialGroup().addComponent(this.JLDinero1, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCasiDinero1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVecesDinero1)).addGroup(JPDetalles1Layout.createSequentialGroup().addComponent(this.JLEspacio1, -2, 66, -2).addGap(12, 12, 12).addComponent(this.JRBCasiEspacio1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVecesEspacio1)).addGroup(JPDetalles1Layout.createSequentialGroup().addComponent(this.JLTiempo1, -2, 66, -2).addGap(12, 12, 12).addComponent(this.JRBCasiTiempo1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVecesTiempo1))).addGap(10, 10, 10).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNuncaDinero1).addComponent(this.JRBNuncaEspacio1).addComponent(this.JRBNuncaTiempo1))))));
        JPDetalles1Layout.setVerticalGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles1Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel27).addComponent(this.JRBAusente4).addComponent(this.JRBIntenso4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel28).addComponent(this.JRBAusente5).addComponent(this.JRBIntenso5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel29).addComponent(this.JRBAusente6).addComponent(this.JRBIntenso6)).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles1Layout.createSequentialGroup().addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLTiempo1).addComponent(this.JRBCasiTiempo1).addComponent(this.JRBVecesTiempo1).addComponent(this.JRBNuncaTiempo1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLEspacio1).addComponent(this.JRBCasiEspacio1).addComponent(this.JRBVecesEspacio1).addComponent(this.JRBNuncaEspacio1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCasiDinero1).addComponent(this.JRBVecesDinero1).addComponent(this.JRBNuncaDinero1)).addComponent(this.JLDinero1)).addGap(0, 0, 32767)).addGroup(JPDetalles1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jLabel30).addContainerGap()))));
        this.jTabbedPane1.addTab("SEMANA 28-32", this.JPDetalles1);
        this.JPDetalles2.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel31.setFont(new Font("Arial", 1, 12));
        this.jLabel31.setText("Llanto fácil, tensión muscular, sobresalto, temblor, no poder quedarse quieta");
        this.JBGHRllanto3.add(this.JRBAusente7);
        this.JRBAusente7.setFont(new Font("Arial", 1, 12));
        this.JRBAusente7.setForeground(new Color(0, 0, 255));
        this.JRBAusente7.setSelected(true);
        this.JRBAusente7.setText("Ausente");
        this.JRBAusente7.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.96
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBAusente7ActionPerformed(evt);
            }
        });
        this.JBGHRllanto3.add(this.JRBIntenso7);
        this.JRBIntenso7.setFont(new Font("Arial", 1, 12));
        this.JRBIntenso7.setForeground(new Color(0, 0, 255));
        this.JRBIntenso7.setText("Intenso");
        this.JRBIntenso7.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.97
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBIntenso7ActionPerformed(evt);
            }
        });
        this.jLabel32.setFont(new Font("Arial", 1, 12));
        this.jLabel32.setText("Insomnio, falta de interés, no disfruta pasatiempos, depresión, mal genio");
        this.JBGHRInsomnio3.add(this.JRBAusente8);
        this.JRBAusente8.setFont(new Font("Arial", 1, 12));
        this.JRBAusente8.setForeground(new Color(0, 0, 255));
        this.JRBAusente8.setSelected(true);
        this.JRBAusente8.setText("Ausente");
        this.JRBAusente8.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.98
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBAusente8ActionPerformed(evt);
            }
        });
        this.JBGHRInsomnio3.add(this.JRBIntenso8);
        this.JRBIntenso8.setFont(new Font("Arial", 1, 12));
        this.JRBIntenso8.setForeground(new Color(0, 0, 255));
        this.JRBIntenso8.setText("Intenso");
        this.JRBIntenso8.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.99
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBIntenso8ActionPerformed(evt);
            }
        });
        this.jLabel33.setFont(new Font("Arial", 1, 12));
        this.jLabel33.setText("Traspiración manos, boca seca, accesos a rubor, palidez, cefalea de tensión");
        this.JBGHRTraspiracion3.add(this.JRBAusente9);
        this.JRBAusente9.setFont(new Font("Arial", 1, 12));
        this.JRBAusente9.setForeground(new Color(0, 0, 255));
        this.JRBAusente9.setSelected(true);
        this.JRBAusente9.setText("Ausente");
        this.JRBAusente9.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.100
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBAusente9ActionPerformed(evt);
            }
        });
        this.JBGHRTraspiracion3.add(this.JRBIntenso9);
        this.JRBIntenso9.setFont(new Font("Arial", 1, 12));
        this.JRBIntenso9.setForeground(new Color(0, 0, 255));
        this.JRBIntenso9.setText("Intenso");
        this.JRBIntenso9.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.101
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBIntenso9ActionPerformed(evt);
            }
        });
        this.JLTiempo2.setFont(new Font("Arial", 1, 12));
        this.JLTiempo2.setText("El tiempo");
        this.JBGHREltiempo3.add(this.JRBCasiTiempo2);
        this.JRBCasiTiempo2.setFont(new Font("Arial", 1, 12));
        this.JRBCasiTiempo2.setForeground(new Color(0, 0, 255));
        this.JRBCasiTiempo2.setSelected(true);
        this.JRBCasiTiempo2.setText("Casi siempre");
        this.JRBCasiTiempo2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.102
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCasiTiempo2ActionPerformed(evt);
            }
        });
        this.JBGHREltiempo3.add(this.JRBVecesTiempo2);
        this.JRBVecesTiempo2.setFont(new Font("Arial", 1, 12));
        this.JRBVecesTiempo2.setForeground(new Color(0, 0, 255));
        this.JRBVecesTiempo2.setText("A veces");
        this.JRBVecesTiempo2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.103
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBVecesTiempo2ActionPerformed(evt);
            }
        });
        this.JBGHREltiempo3.add(this.JRBNuncaTiempo2);
        this.JRBNuncaTiempo2.setFont(new Font("Arial", 1, 12));
        this.JRBNuncaTiempo2.setForeground(new Color(0, 0, 255));
        this.JRBNuncaTiempo2.setText("Nunca");
        this.JRBNuncaTiempo2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.104
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBNuncaTiempo2ActionPerformed(evt);
            }
        });
        this.JLEspacio2.setFont(new Font("Arial", 1, 12));
        this.JLEspacio2.setText("El Espacio");
        this.JBGHREspacio3.add(this.JRBCasiEspacio2);
        this.JRBCasiEspacio2.setFont(new Font("Arial", 1, 12));
        this.JRBCasiEspacio2.setForeground(new Color(0, 0, 255));
        this.JRBCasiEspacio2.setSelected(true);
        this.JRBCasiEspacio2.setText("Casi siempre");
        this.JRBCasiEspacio2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.105
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCasiEspacio2ActionPerformed(evt);
            }
        });
        this.JBGHREspacio3.add(this.JRBVecesEspacio2);
        this.JRBVecesEspacio2.setFont(new Font("Arial", 1, 12));
        this.JRBVecesEspacio2.setForeground(new Color(0, 0, 255));
        this.JRBVecesEspacio2.setText("A veces");
        this.JRBVecesEspacio2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.106
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBVecesEspacio2ActionPerformed(evt);
            }
        });
        this.JBGHREspacio3.add(this.JRBNuncaEspacio2);
        this.JRBNuncaEspacio2.setFont(new Font("Arial", 1, 12));
        this.JRBNuncaEspacio2.setForeground(new Color(0, 0, 255));
        this.JRBNuncaEspacio2.setText("Nunca");
        this.JRBNuncaEspacio2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.107
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBNuncaEspacio2ActionPerformed(evt);
            }
        });
        this.JLDinero2.setFont(new Font("Arial", 1, 12));
        this.JLDinero2.setText("El Dinero?");
        this.JBGHRDinero3.add(this.JRBCasiDinero2);
        this.JRBCasiDinero2.setFont(new Font("Arial", 1, 12));
        this.JRBCasiDinero2.setForeground(new Color(0, 0, 255));
        this.JRBCasiDinero2.setSelected(true);
        this.JRBCasiDinero2.setText("Casi siempre");
        this.JRBCasiDinero2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.108
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBCasiDinero2ActionPerformed(evt);
            }
        });
        this.JBGHRDinero3.add(this.JRBVecesDinero2);
        this.JRBVecesDinero2.setFont(new Font("Arial", 1, 12));
        this.JRBVecesDinero2.setForeground(new Color(0, 0, 255));
        this.JRBVecesDinero2.setText("A veces");
        this.JRBVecesDinero2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.109
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBVecesDinero2ActionPerformed(evt);
            }
        });
        this.JBGHRDinero3.add(this.JRBNuncaDinero2);
        this.JRBNuncaDinero2.setFont(new Font("Arial", 1, 12));
        this.JRBNuncaDinero2.setForeground(new Color(0, 0, 255));
        this.JRBNuncaDinero2.setText("Nunca");
        this.JRBNuncaDinero2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.110
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JRBNuncaDinero2ActionPerformed(evt);
            }
        });
        this.jLabel34.setFont(new Font("Arial", 0, 11));
        this.jLabel34.setText("<html><b>SOPORTE FAMILIAR</b><br>Satisfecha con la forma como usted comparte con su familia y/o compañero</html>");
        GroupLayout JPDetalles2Layout = new GroupLayout(this.JPDetalles2);
        this.JPDetalles2.setLayout(JPDetalles2Layout);
        JPDetalles2Layout.setHorizontalGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles2Layout.createSequentialGroup().addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles2Layout.createSequentialGroup().addComponent(this.jLabel31).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAusente7)).addGroup(JPDetalles2Layout.createSequentialGroup().addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel32).addComponent(this.jLabel33)).addGap(10, 10, 10).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBAusente9).addComponent(this.JRBAusente8)))).addGap(18, 18, 18).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBIntenso7).addComponent(this.JRBIntenso9).addComponent(this.JRBIntenso8))).addGroup(JPDetalles2Layout.createSequentialGroup().addComponent(this.jLabel34, -2, 224, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDetalles2Layout.createSequentialGroup().addComponent(this.JLDinero2, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCasiDinero2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVecesDinero2)).addGroup(JPDetalles2Layout.createSequentialGroup().addComponent(this.JLEspacio2, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCasiEspacio2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVecesEspacio2)).addGroup(JPDetalles2Layout.createSequentialGroup().addComponent(this.JLTiempo2, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCasiTiempo2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBVecesTiempo2))).addGap(10, 10, 10).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNuncaDinero2).addComponent(this.JRBNuncaEspacio2).addComponent(this.JRBNuncaTiempo2))))));
        JPDetalles2Layout.setVerticalGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles2Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel31).addComponent(this.JRBAusente7).addComponent(this.JRBIntenso7)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel32).addComponent(this.JRBAusente8).addComponent(this.JRBIntenso8)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel33).addComponent(this.JRBAusente9).addComponent(this.JRBIntenso9)).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles2Layout.createSequentialGroup().addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLTiempo2).addComponent(this.JRBCasiTiempo2).addComponent(this.JRBVecesTiempo2).addComponent(this.JRBNuncaTiempo2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLEspacio2).addComponent(this.JRBCasiEspacio2).addComponent(this.JRBVecesEspacio2).addComponent(this.JRBNuncaEspacio2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalles2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCasiDinero2).addComponent(this.JRBVecesDinero2).addComponent(this.JRBNuncaDinero2)).addComponent(this.JLDinero2)).addGap(0, 0, 32767)).addGroup(JPDetalles2Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jLabel34).addContainerGap()))));
        this.jTabbedPane1.addTab("SEMANA 33-42", this.JPDetalles2);
        GroupLayout JPRSicosocialLayout = new GroupLayout(this.JPRSicosocial);
        this.JPRSicosocial.setLayout(JPRSicosocialLayout);
        JPRSicosocialLayout.setHorizontalGroup(JPRSicosocialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRSicosocialLayout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, 653, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPRSicosocialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPResultado1, -1, -1, 32767).addComponent(this.JPResultado2, -1, -1, 32767))));
        JPRSicosocialLayout.setVerticalGroup(JPRSicosocialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRSicosocialLayout.createSequentialGroup().addComponent(this.JPResultado1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPResultado2, -1, -1, 32767)).addComponent(this.jTabbedPane1, -2, 0, 32767));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JPTotal14_27.setBorder(BorderFactory.createTitledBorder(""));
        this.JLSemana24_27.setFont(new Font("Arial", 1, 12));
        this.JLSemana24_27.setForeground(Color.blue);
        this.JLSemana24_27.setText("Semana 14-27 ");
        this.JTFTotal1.setHorizontalAlignment(4);
        this.JTFTotal1.setText("0");
        this.JTFTotal1.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.111
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JTFTotal1ActionPerformed(evt);
            }
        });
        this.JLTotal1.setFont(new Font("Arial", 1, 12));
        this.JLTotal1.setForeground(new Color(255, 0, 0));
        this.JLTotal1.setText("Total");
        GroupLayout JPTotal14_27Layout = new GroupLayout(this.JPTotal14_27);
        this.JPTotal14_27.setLayout(JPTotal14_27Layout);
        JPTotal14_27Layout.setHorizontalGroup(JPTotal14_27Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTotal14_27Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JLSemana24_27).addGap(18, 18, 18).addComponent(this.JLTotal1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTotal1, -2, 56, -2).addContainerGap(-1, 32767)));
        JPTotal14_27Layout.setVerticalGroup(JPTotal14_27Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTotal14_27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLSemana24_27).addComponent(this.JTFTotal1, -2, -1, -2).addComponent(this.JLTotal1)));
        this.JPTotal28_38.setBorder(BorderFactory.createTitledBorder(""));
        this.JLSemana28_32.setFont(new Font("Arial", 1, 12));
        this.JLSemana28_32.setForeground(Color.blue);
        this.JLSemana28_32.setText("Semana 28-32 ");
        this.JTFTotal2.setHorizontalAlignment(4);
        this.JTFTotal2.setText("0");
        this.JTFTotal2.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.112
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JTFTotal2ActionPerformed(evt);
            }
        });
        this.JLTotal2.setFont(new Font("Arial", 1, 12));
        this.JLTotal2.setForeground(new Color(255, 0, 0));
        this.JLTotal2.setText("Total");
        GroupLayout JPTotal28_38Layout = new GroupLayout(this.JPTotal28_38);
        this.JPTotal28_38.setLayout(JPTotal28_38Layout);
        JPTotal28_38Layout.setHorizontalGroup(JPTotal28_38Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTotal28_38Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JLSemana28_32).addGap(30, 30, 30).addComponent(this.JLTotal2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFTotal2, -1, 51, 32767).addContainerGap()));
        JPTotal28_38Layout.setVerticalGroup(JPTotal28_38Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTotal28_38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLSemana28_32).addComponent(this.JTFTotal2, -2, -1, -2).addComponent(this.JLTotal2)));
        this.JPTotal33_42.setBorder(BorderFactory.createTitledBorder(""));
        this.JLSemana33_48.setFont(new Font("Arial", 1, 12));
        this.JLSemana33_48.setForeground(Color.blue);
        this.JLSemana33_48.setText("Semana 33-42");
        this.JTFTotal3.setHorizontalAlignment(4);
        this.JTFTotal3.setText("0");
        this.JTFTotal3.addActionListener(new ActionListener() { // from class: Historia.JPRiesgoBiosicoSocial.113
            public void actionPerformed(ActionEvent evt) {
                JPRiesgoBiosicoSocial.this.JTFTotal3ActionPerformed(evt);
            }
        });
        this.JLTotal3.setFont(new Font("Arial", 1, 12));
        this.JLTotal3.setForeground(new Color(255, 0, 0));
        this.JLTotal3.setText("Total");
        GroupLayout JPTotal33_42Layout = new GroupLayout(this.JPTotal33_42);
        this.JPTotal33_42.setLayout(JPTotal33_42Layout);
        JPTotal33_42Layout.setHorizontalGroup(JPTotal33_42Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTotal33_42Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JLSemana33_48).addGap(30, 30, 30).addComponent(this.JLTotal3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFTotal3, -1, 51, 32767).addContainerGap()));
        JPTotal33_42Layout.setVerticalGroup(JPTotal33_42Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTotal33_42Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLSemana33_48).addComponent(this.JTFTotal3, -2, -1, -2).addComponent(this.JLTotal3)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPTotal14_27, -2, -1, -2).addGap(36, 36, 36).addComponent(this.JPTotal28_38, -2, -1, -2).addGap(39, 39, 39).addComponent(this.JPTotal33_42, -2, -1, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPTotal33_42, -2, -1, -2).addComponent(this.JPTotal28_38, -2, -1, -2).addComponent(this.JPTotal14_27, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPRSicosocial, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JPCondiAsociadas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPEmbarazoActual, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPHisReproductiva, -1, -1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPHisReproductiva, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPEmbarazoActual, -1, -1, 32767).addComponent(this.JPCondiAsociadas, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPRSicosocial, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, 31, -2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTotal1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTotal2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTotal3ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBRetPlacentaActionPerformed(ActionEvent evt) {
        if (this.JCHBRetPlacenta.isSelected()) {
            this.xretPlacentaria = 1;
        } else {
            this.xretPlacentaria = 0;
        }
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMenor_16ActionPerformed(ActionEvent evt) {
        this.xedad = 1;
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEntre16_35ActionPerformed(ActionEvent evt) {
        this.xedad = 0;
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEntreMas_35ActionPerformed(ActionEvent evt) {
        this.xedad = 2;
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCeroActionPerformed(ActionEvent evt) {
        this.xparidad = 1;
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBParidad1_4ActionPerformed(ActionEvent evt) {
        this.xparidad = 0;
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBParidad5ActionPerformed(ActionEvent evt) {
        this.xparidad = 2;
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBAbortoActionPerformed(ActionEvent evt) {
        if (this.JCHBAborto.isSelected()) {
            this.xaborto = 1;
        } else {
            this.xaborto = 0;
        }
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBRecienNacido4000ActionPerformed(ActionEvent evt) {
        if (this.JCHBRecienNacido4000.isSelected()) {
            this.xrNacidoM = 1;
        } else {
            this.xrNacidoM = 0;
        }
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBRecienNacido2500ActionPerformed(ActionEvent evt) {
        if (this.JCHBRecienNacido2500.isSelected()) {
            this.xrNacidom = 1;
        } else {
            this.xrNacidom = 0;
        }
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBHTAInducidaActionPerformed(ActionEvent evt) {
        if (this.JCHBHTAInducida.isSelected()) {
            this.xHTA = 1;
        } else {
            this.xHTA = 0;
        }
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEmbGemelarActionPerformed(ActionEvent evt) {
        if (this.JCHBEmbGemelar.isSelected()) {
            this.xgemelar = 1;
        } else {
            this.xgemelar = 0;
        }
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBMortinatoActionPerformed(ActionEvent evt) {
        if (this.JCHBMortinato.isSelected()) {
            this.xmortinato = 1;
        } else {
            this.xmortinato = 0;
        }
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBProlongadoActionPerformed(ActionEvent evt) {
        if (this.JCHBProlongado.isSelected()) {
            this.xprolongado = 1;
        } else {
            this.xprolongado = 0;
        }
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBQx1ItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBQx1.getSelectedIndex() != -1) {
            if (this.JCBQx1.getSelectedItem().equals("No")) {
                this.xQx1 = 0;
            } else {
                this.xQx1 = 1;
            }
            mCalculaSTotal1(this.xregistro);
            mIniciarTotales();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRenal1ItemStateChanged(ItemEvent evt) {
        if (this.JCBRenal1.getSelectedItem().equals("No")) {
            this.xRenal1 = 0;
        } else {
            this.xRenal1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiabetesG1ItemStateChanged(ItemEvent evt) {
        if (this.JCBDiabetesG1.getSelectedItem().equals("No")) {
            this.xGestacional1 = 0;
        } else {
            this.xGestacional1 = 2;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiabetesM1ItemStateChanged(ItemEvent evt) {
        if (this.JCBDiabetesM1.getSelectedItem().equals("No")) {
            this.xMellitus1 = 0;
        } else {
            this.xMellitus1 = 3;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBECardiaca1ItemStateChanged(ItemEvent evt) {
        if (this.JCBECardiaca1.getSelectedItem().equals("No")) {
            this.xCardiaca1 = 0;
        } else {
            this.xCardiaca1 = 3;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEInfecciosa1ItemStateChanged(ItemEvent evt) {
        if (this.JCBEInfecciosa1.getSelectedItem().equals("No")) {
            this.xInfecciosa1 = 0;
        } else {
            this.xInfecciosa1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEAuto1ItemStateChanged(ItemEvent evt) {
        if (this.JCBEAuto1.getSelectedItem().equals("No")) {
            this.xAutoinmune1 = 0;
        } else {
            this.xAutoinmune1 = 3;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAnemia1ItemStateChanged(ItemEvent evt) {
        if (this.JCBAnemia1.getSelectedItem().equals("No")) {
            this.xAnemia1 = 0;
        } else {
            this.xAnemia1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHemorragia1ItemStateChanged(ItemEvent evt) {
        if (this.JCBHemorragia1.getSelectedItem().equals("No")) {
            this.xHemorragia1 = 0;
        } else {
            this.xHemorragia1 = 1;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBVaginal1ItemStateChanged(ItemEvent evt) {
        if (this.JCBVaginal1.getSelectedItem().equals("No")) {
            this.xVaginal1 = 0;
        } else {
            this.xVaginal1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHTA1ItemStateChanged(ItemEvent evt) {
        if (this.JCBHTA1.getSelectedItem().equals("No")) {
            this.xHTAc1 = 0;
        } else {
            this.xHTAc1 = 2;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRPM1ItemStateChanged(ItemEvent evt) {
        if (this.JCBRPM1.getSelectedItem().equals("No")) {
            this.xRPM1 = 0;
        } else {
            this.xRPM1 = 2;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPolih1ItemStateChanged(ItemEvent evt) {
        if (this.JCBPolih1.getSelectedItem().equals("No")) {
            this.xPolihidramnios1 = 0;
        } else {
            this.xPolihidramnios1 = 2;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRCIU1ItemStateChanged(ItemEvent evt) {
        if (this.JCBRCIU1.getSelectedItem().equals("No")) {
            this.xRCIU1 = 0;
        } else {
            this.xRCIU1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBREmb1ItemStateChanged(ItemEvent evt) {
        if (this.JCBREmb1.getSelectedItem().equals("No")) {
            this.xMultiple1 = 0;
        } else {
            this.xMultiple1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBIsoInm1ItemStateChanged(ItemEvent evt) {
        if (this.JCBIsoInm1.getSelectedItem().equals("No")) {
            this.xIsoInmunizacion = 0;
        } else {
            this.xIsoInmunizacion = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAusente1ActionPerformed(ActionEvent evt) {
        this.xllanto = 0;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIntenso1ActionPerformed(ActionEvent evt) {
        this.xllanto = 1;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAusente2ActionPerformed(ActionEvent evt) {
        this.xinsonmnio = 0;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIntenso2ActionPerformed(ActionEvent evt) {
        this.xinsonmnio = 1;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAusente3ActionPerformed(ActionEvent evt) {
        this.xtraspiracion = 0;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIntenso3ActionPerformed(ActionEvent evt) {
        this.xtraspiracion = 1;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCasiTiempoActionPerformed(ActionEvent evt) {
        this.xtiempo = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVecesTiempoActionPerformed(ActionEvent evt) {
        this.xtiempo = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNuncaTiempoActionPerformed(ActionEvent evt) {
        this.xtiempo = 2;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCasiEspacioActionPerformed(ActionEvent evt) {
        this.xespacio = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVecesEspacioActionPerformed(ActionEvent evt) {
        this.xespacio = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNuncaEspacioActionPerformed(ActionEvent evt) {
        this.xespacio = 2;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCasiDineroActionPerformed(ActionEvent evt) {
        this.xdinero = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVecesDineroActionPerformed(ActionEvent evt) {
        this.xdinero = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNuncaDineroActionPerformed(ActionEvent evt) {
        this.xdinero = 2;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBQx2ItemStateChanged(ItemEvent evt) {
        if (this.JCBQx2.getSelectedItem().equals("No")) {
            this.xQx1 = 0;
        } else {
            this.xQx1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBQx3ItemStateChanged(ItemEvent evt) {
        if (this.JCBQx3.getSelectedItem().equals("No")) {
            this.xQx1 = 0;
        } else {
            this.xQx1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRenal2ItemStateChanged(ItemEvent evt) {
        if (this.JCBRenal2.getSelectedItem().equals("No")) {
            this.xRenal1 = 0;
        } else {
            this.xRenal1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRenal3ItemStateChanged(ItemEvent evt) {
        if (this.JCBRenal3.getSelectedItem().equals("No")) {
            this.xRenal1 = 0;
        } else {
            this.xRenal1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiabetesG2ItemStateChanged(ItemEvent evt) {
        if (this.JCBDiabetesG2.getSelectedItem().equals("No")) {
            this.xGestacional1 = 0;
        } else {
            this.xGestacional1 = 2;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiabetesG3ItemStateChanged(ItemEvent evt) {
        if (this.JCBDiabetesG3.getSelectedItem().equals("No")) {
            this.xGestacional1 = 0;
        } else {
            this.xGestacional1 = 2;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiabetesM2ItemStateChanged(ItemEvent evt) {
        if (this.JCBDiabetesM2.getSelectedItem().equals("No")) {
            this.xMellitus1 = 0;
        } else {
            this.xMellitus1 = 3;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiabetesM3ItemStateChanged(ItemEvent evt) {
        if (this.JCBDiabetesM3.getSelectedItem().equals("No")) {
            this.xMellitus1 = 0;
        } else {
            this.xMellitus1 = 3;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBECardiaca2ItemStateChanged(ItemEvent evt) {
        if (this.JCBECardiaca2.getSelectedItem().equals("No")) {
            this.xCardiaca1 = 0;
        } else {
            this.xCardiaca1 = 3;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBECardiaca3ItemStateChanged(ItemEvent evt) {
        if (this.JCBECardiaca3.getSelectedItem().equals("No")) {
            this.xCardiaca1 = 0;
        } else {
            this.xCardiaca1 = 3;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEInfecciosa2ItemStateChanged(ItemEvent evt) {
        if (this.JCBEInfecciosa2.getSelectedItem().equals("No")) {
            this.xInfecciosa1 = 0;
        } else {
            this.xInfecciosa1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEInfecciosa3ItemStateChanged(ItemEvent evt) {
        if (this.JCBEInfecciosa3.getSelectedItem().equals("No")) {
            this.xInfecciosa1 = 0;
        } else {
            this.xInfecciosa1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEAuto2ItemStateChanged(ItemEvent evt) {
        if (this.JCBEAuto2.getSelectedItem().equals("No")) {
            this.xAutoinmune1 = 0;
        } else {
            this.xAutoinmune1 = 3;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEAuto3ItemStateChanged(ItemEvent evt) {
        if (this.JCBEAuto3.getSelectedItem().equals("No")) {
            this.xAutoinmune1 = 0;
        } else {
            this.xAutoinmune1 = 3;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAnemia2ItemStateChanged(ItemEvent evt) {
        if (this.JCBAnemia2.getSelectedItem().equals("No")) {
            this.xAnemia1 = 0;
        } else {
            this.xAnemia1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAnemia3ItemStateChanged(ItemEvent evt) {
        if (this.JCBAnemia3.getSelectedItem().equals("No")) {
            this.xAnemia1 = 0;
        } else {
            this.xAnemia1 = 1;
        }
        mCalculaSTotal1(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHemorragia2ItemStateChanged(ItemEvent evt) {
        if (this.JCBHemorragia2.getSelectedItem().equals("No")) {
            this.xHemorragia1 = 0;
        } else {
            this.xHemorragia1 = 1;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHemorragia3ItemStateChanged(ItemEvent evt) {
        if (this.JCBHemorragia3.getSelectedItem().equals("No")) {
            this.xHemorragia1 = 0;
        } else {
            this.xHemorragia1 = 1;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBVaginal2ItemStateChanged(ItemEvent evt) {
        if (this.JCBVaginal2.getSelectedItem().equals("No")) {
            this.xVaginal1 = 0;
        } else {
            this.xVaginal1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBVaginal3ItemStateChanged(ItemEvent evt) {
        if (this.JCBVaginal3.getSelectedItem().equals("No")) {
            this.xVaginal1 = 0;
        } else {
            this.xVaginal1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProlongadoItemStateChanged(ItemEvent evt) {
        if (this.JCBProlongado.getSelectedItem().equals("No")) {
            this.xProlongado1 = 0;
        } else {
            this.xProlongado1 = 1;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHTA2ItemStateChanged(ItemEvent evt) {
        if (this.JCBHTA2.getSelectedItem().equals("No")) {
            this.xHTAc1 = 0;
        } else {
            this.xHTAc1 = 2;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBHTA3ItemStateChanged(ItemEvent evt) {
        if (this.JCBHTA3.getSelectedItem().equals("No")) {
            this.xHTAc1 = 0;
        } else {
            this.xHTAc1 = 2;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRPM2ItemStateChanged(ItemEvent evt) {
        if (this.JCBRPM2.getSelectedItem().equals("No")) {
            this.xRPM1 = 0;
        } else {
            this.xRPM1 = 2;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRPM3ItemStateChanged(ItemEvent evt) {
        if (this.JCBRPM3.getSelectedItem().equals("No")) {
            this.xRPM1 = 0;
        } else {
            this.xRPM1 = 2;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPolih2ItemStateChanged(ItemEvent evt) {
        if (this.JCBPolih2.getSelectedItem().equals("No")) {
            this.xPolihidramnios1 = 0;
        } else {
            this.xPolihidramnios1 = 2;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPolih3ItemStateChanged(ItemEvent evt) {
        if (this.JCBPolih3.getSelectedItem().equals("No")) {
            this.xPolihidramnios1 = 0;
        } else {
            this.xPolihidramnios1 = 2;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRCIU2ItemStateChanged(ItemEvent evt) {
        if (this.JCBRCIU2.getSelectedItem().equals("No")) {
            this.xRCIU1 = 0;
        } else {
            this.xRCIU1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRCIU13ItemStateChanged(ItemEvent evt) {
        if (this.JCBRCIU13.getSelectedItem().equals("No")) {
            this.xRCIU1 = 0;
        } else {
            this.xRCIU1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBREmb2ItemStateChanged(ItemEvent evt) {
        if (this.JCBREmb2.getSelectedItem().equals("No")) {
            this.xMultiple1 = 0;
        } else {
            this.xMultiple1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBREmb3ItemStateChanged(ItemEvent evt) {
        if (this.JCBREmb3.getSelectedItem().equals("No")) {
            this.xMultiple1 = 0;
        } else {
            this.xMultiple1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMPresentacionItemStateChanged(ItemEvent evt) {
        if (this.JCBMPresentacion.getSelectedItem().equals("No")) {
            this.xMPresentacion1 = 0;
        } else {
            this.xMPresentacion1 = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBIsoInm2ItemStateChanged(ItemEvent evt) {
        if (this.JCBIsoInm2.getSelectedItem().equals("No")) {
            this.xIsoInmunizacion = 0;
        } else {
            this.xIsoInmunizacion = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBIsoInm3ItemStateChanged(ItemEvent evt) {
        if (this.JCBIsoInm3.getSelectedItem().equals("No")) {
            this.xIsoInmunizacion = 0;
        } else {
            this.xIsoInmunizacion = 3;
        }
        mCalculaSTotal2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAusente4ActionPerformed(ActionEvent evt) {
        this.xllanto = 0;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIntenso4ActionPerformed(ActionEvent evt) {
        this.xllanto = 1;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAusente5ActionPerformed(ActionEvent evt) {
        this.xinsonmnio = 0;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIntenso5ActionPerformed(ActionEvent evt) {
        this.xinsonmnio = 1;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAusente6ActionPerformed(ActionEvent evt) {
        this.xtraspiracion = 0;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIntenso6ActionPerformed(ActionEvent evt) {
        this.xtraspiracion = 1;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCasiTiempo1ActionPerformed(ActionEvent evt) {
        this.xtiempo = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVecesTiempo1ActionPerformed(ActionEvent evt) {
        this.xtiempo = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNuncaTiempo1ActionPerformed(ActionEvent evt) {
        this.xtiempo = 2;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCasiEspacio1ActionPerformed(ActionEvent evt) {
        this.xespacio = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVecesEspacio1ActionPerformed(ActionEvent evt) {
        this.xespacio = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNuncaEspacio1ActionPerformed(ActionEvent evt) {
        this.xespacio = 2;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCasiDinero1ActionPerformed(ActionEvent evt) {
        this.xdinero = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVecesDinero1ActionPerformed(ActionEvent evt) {
        this.xdinero = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNuncaDinero1ActionPerformed(ActionEvent evt) {
        this.xdinero = 2;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAusente7ActionPerformed(ActionEvent evt) {
        this.xllanto = 0;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIntenso7ActionPerformed(ActionEvent evt) {
        this.xllanto = 1;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAusente8ActionPerformed(ActionEvent evt) {
        this.xinsonmnio = 0;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIntenso8ActionPerformed(ActionEvent evt) {
        this.xinsonmnio = 1;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAusente9ActionPerformed(ActionEvent evt) {
        this.xtraspiracion = 0;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIntenso9ActionPerformed(ActionEvent evt) {
        this.xtraspiracion = 1;
        mCalculaCombos(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCasiTiempo2ActionPerformed(ActionEvent evt) {
        this.xtiempo = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVecesTiempo2ActionPerformed(ActionEvent evt) {
        this.xtiempo = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNuncaTiempo2ActionPerformed(ActionEvent evt) {
        this.xtiempo = 2;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCasiEspacio2ActionPerformed(ActionEvent evt) {
        this.xespacio = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVecesEspacio2ActionPerformed(ActionEvent evt) {
        this.xespacio = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNuncaEspacio2ActionPerformed(ActionEvent evt) {
        this.xespacio = 2;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCasiDinero2ActionPerformed(ActionEvent evt) {
        this.xdinero = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBVecesDinero2ActionPerformed(ActionEvent evt) {
        this.xdinero = 0;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNuncaDinero2ActionPerformed(ActionEvent evt) {
        this.xdinero = 2;
        mCalculaCombos2(this.xregistro);
        mIniciarTotales();
    }

    public void mGrabar() {
        mGrabarEncabezado();
        if (this.xregistro >= 14.0d && this.xregistro <= 27.9d) {
            mGrabarP1();
        } else if (this.xregistro >= 28.0d && this.xregistro <= 32.9d) {
            mGrabarP2();
        } else if (this.xregistro >= 33.0d && this.xregistro <= 42.0d) {
            mGrabarP3();
        }
        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    private void mGrabarEncabezado() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0 && !mVerifica()) {
            String sql = "INSERT INTO p_riego_biosicosocial(Id_Atencion, `Id_Usuario_Programa`, `Fecha_Reg`, `Edad`, `Paridad`, `P3`, `P4` , `P5` , `P6`, `P7` , `P8` , `P9`, `P10`, `Fecha`, `UsuarioS`)VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.xedad + "','" + this.xparidad + "','" + this.xaborto + "','" + this.xretPlacentaria + "','" + this.xrNacidoM + "','" + this.xrNacidom + "','" + this.xHTA + "','" + this.xgemelar + "','" + this.xmortinato + "','" + this.xprolongado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xidEncabezado = Integer.parseInt(this.xct.ejecutarSQLId(sql));
            this.xct.cerrarConexionBd();
        }
    }

    private boolean mVerifica() {
        boolean xExiste = false;
        String sql = "SELECT Id FROM `p_riego_biosicosocial` WHERE `Id_Usuario_Programa`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "' ";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPRiesgoBiosicoSocial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    private void mGrabarP1() {
        String sql = "INSERT INTO p_riesgo_biosicosocial_detalle(`Id_Riesgo`, `P11` , `P12`, `P13`, `P14`, `P15` , `P16` , `P17` , `P18`, `P19`, `P20`, `P23` , `P24`, `P25`, `P26`, `P27` , `P29`, `P30` , `P31` , `P32`, `P33`, `P34`, `P35`, `Total`,SubTotal1,SubTotal2,FechaR,SGestacion)VALUES ('" + this.xidEncabezado + "','" + this.xQx1 + "','" + this.xRenal1 + "','" + this.xGestacional1 + "','" + this.xMellitus1 + "','" + this.xCardiaca1 + "','" + this.xInfecciosa1 + "','" + this.xAutoinmune1 + "','" + this.xAnemia1 + "','" + this.xHemorragia1 + "','" + this.xVaginal1 + "','" + this.xHTAc1 + "','" + this.xRPM1 + "','" + this.xPolihidramnios1 + "','" + this.xRCIU1 + "','" + this.xMultiple1 + "','" + this.xIsoInmunizacion + "','" + this.xllanto + "','" + this.xinsonmnio + "','" + this.xtraspiracion + "','" + this.xtiempo + "','" + this.xespacio + "','" + this.xdinero + "','" + this.JTFTotal1.getText() + "','" + this.JTFSubtotal1.getText() + "','" + this.JTFSubtotal4.getText() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xregistro + "')";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    private void mGrabarP2() {
        String sql = "INSERT INTO p_riesgo_biosicosocial_detalle(`Id_Riesgo`, `P11` , `P12`, `P13`, `P14`, `P15` , `P16` , `P17` , `P18`, `P19`, `P20`, `P23` , `P24`, `P25`, `P26`, `P27` , `P29`, `P30` , `P31` , `P32`, `P33`, `P34`, `P35`, `Total`,SubTotal1,SubTotal2,FechaR,SGestacion)VALUES ('" + this.xidEncabezado + "','" + this.xQx1 + "','" + this.xRenal1 + "','" + this.xGestacional1 + "','" + this.xMellitus1 + "','" + this.xCardiaca1 + "','" + this.xInfecciosa1 + "','" + this.xAutoinmune1 + "','" + this.xAnemia1 + "','" + this.xHemorragia1 + "','" + this.xVaginal1 + "','" + this.xHTAc1 + "','" + this.xRPM1 + "','" + this.xPolihidramnios1 + "','" + this.xRCIU1 + "','" + this.xMultiple1 + "','" + this.xIsoInmunizacion + "','" + this.xllanto + "','" + this.xinsonmnio + "','" + this.xtraspiracion + "','" + this.xtiempo + "','" + this.xespacio + "','" + this.xdinero + "','" + this.JTFTotal2.getText() + "','" + this.JTFSubtotal2.getText() + "','" + this.JTFSubtotal5.getText() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xregistro + "')";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    private void mGrabarP3() {
        String sql = "INSERT INTO p_riesgo_biosicosocial_detalle(`Id_Riesgo`, `P11` , `P12`, `P13`, `P14`, `P15` , `P16` , `P17` , `P18`, `P19`, `P20`,`P22`, `P23` , `P24`, `P25`, `P26`, `P27` ,`P28`, `P29`, `P30` , `P31` , `P32`, `P33`, `P34`, `P35`, `Total`,SubTotal1,SubTotal2,FechaR,SGestacion)VALUES ('" + this.xidEncabezado + "','" + this.xQx1 + "','" + this.xRenal1 + "','" + this.xGestacional1 + "','" + this.xMellitus1 + "','" + this.xCardiaca1 + "','" + this.xInfecciosa1 + "','" + this.xAutoinmune1 + "','" + this.xAnemia1 + "','" + this.xHemorragia1 + "','" + this.xVaginal1 + "','" + this.xProlongado1 + "','" + this.xHTAc1 + "','" + this.xRPM1 + "','" + this.xPolihidramnios1 + "','" + this.xRCIU1 + "','" + this.xMultiple1 + "','" + this.xMPresentacion1 + "','" + this.xIsoInmunizacion + "','" + this.xllanto + "','" + this.xinsonmnio + "','" + this.xtraspiracion + "','" + this.xtiempo + "','" + this.xespacio + "','" + this.xdinero + "','" + this.JTFTotal3.getText() + "','" + this.JTFSubtotal3.getText() + "','" + this.JTFSubtotal6.getText() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xregistro + "')";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    private double mVerificaSEmbarazo() {
        double resultado = 0.0d;
        String sql = "SELECT `UltimaMestruacion`, `SemanaGestacion`, Cardinal, Peso_Inicio FROM `g_usuarioxprograma` WHERE (Id ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "' AND `Id_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "' AND `FechaEgreso` IS NULL) ";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                resultado = xrs.getDouble(4);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPRiesgoBiosicoSocial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return resultado;
    }

    private double mVerificaRegistro() {
        double resultado = 0.0d;
        String sql = "SELECT `SGestacion` FROM h_examenfisico WHERE `Id_Atencion` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' ";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                resultado = xrs.getDouble(1);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPRiesgoBiosicoSocial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return resultado;
    }

    private void mIniciarComponentes() {
        this.xlleno = true;
        enableComponents(this.JPDetalles, false);
        enableComponents(this.JPDetalles1, false);
        enableComponents(this.JPDetalles2, false);
        if (this.xregistro >= 14.0d && this.xregistro <= 27.9d) {
            mHabilitaBloque1();
            enableComponents(this.JPDetalles, true);
        } else if (this.xregistro >= 28.0d && this.xregistro <= 32.9d) {
            mHabilitaBloque2();
            enableComponents(this.JPDetalles1, true);
        } else if (this.xregistro >= 33.0d && this.xregistro <= 42.0d) {
            mHabilitaBloque3();
            enableComponents(this.JPDetalles2, true);
        }
    }

    private void mHabilitaBloque1() {
        this.JCBQx1.setEnabled(true);
        this.JCBRenal1.setEnabled(true);
        this.JCBDiabetesG1.setEnabled(true);
        this.JCBDiabetesM1.setEnabled(true);
        this.JCBECardiaca1.setEnabled(true);
        this.JCBEInfecciosa1.setEnabled(true);
        this.JCBEAuto1.setEnabled(true);
        this.JCBAnemia1.setEnabled(true);
        this.JCBHemorragia1.setEnabled(true);
        this.JCBVaginal1.setEnabled(true);
        this.JCBHTA1.setEnabled(true);
        this.JCBRPM1.setEnabled(true);
        this.JCBPolih1.setEnabled(true);
        this.JCBRCIU1.setEnabled(true);
        this.JCBREmb1.setEnabled(true);
        this.JCBIsoInm1.setEnabled(true);
        this.JCBHemorragia1.setEnabled(true);
        this.JCBVaginal1.setEnabled(true);
        this.JCBHTA1.setEnabled(true);
        this.JCBRPM1.setEnabled(true);
        this.JCBPolih1.setEnabled(true);
        this.JCBRCIU1.setEnabled(true);
        this.JCBREmb1.setEnabled(true);
        this.JCBIsoInm1.setEnabled(true);
    }

    private void mHabilitaBloque2() {
        this.JCBQx2.setEnabled(true);
        this.JCBRenal2.setEnabled(true);
        this.JCBDiabetesG2.setEnabled(true);
        this.JCBDiabetesM2.setEnabled(true);
        this.JCBECardiaca2.setEnabled(true);
        this.JCBEInfecciosa2.setEnabled(true);
        this.JCBEAuto2.setEnabled(true);
        this.JCBAnemia2.setEnabled(true);
        this.JCBHemorragia2.setEnabled(true);
        this.JCBVaginal2.setEnabled(true);
        this.JCBHTA2.setEnabled(true);
        this.JCBRPM2.setEnabled(true);
        this.JCBPolih2.setEnabled(true);
        this.JCBRCIU2.setEnabled(true);
        this.JCBREmb2.setEnabled(true);
        this.JCBIsoInm2.setEnabled(true);
        this.JCBHemorragia2.setEnabled(true);
        this.JCBVaginal2.setEnabled(true);
        this.JCBHTA2.setEnabled(true);
        this.JCBRPM2.setEnabled(true);
        this.JCBPolih2.setEnabled(true);
        this.JCBRCIU2.setEnabled(true);
        this.JCBREmb2.setEnabled(true);
        this.JCBIsoInm2.setEnabled(true);
    }

    private void mHabilitaBloque3() {
        this.JCBQx3.setEnabled(true);
        this.JCBRenal3.setEnabled(true);
        this.JCBDiabetesG3.setEnabled(true);
        this.JCBDiabetesM3.setEnabled(true);
        this.JCBECardiaca3.setEnabled(true);
        this.JCBEInfecciosa3.setEnabled(true);
        this.JCBEAuto3.setEnabled(true);
        this.JCBAnemia3.setEnabled(true);
        this.JCBHemorragia3.setEnabled(true);
        this.JCBVaginal3.setEnabled(true);
        this.JCBProlongado.setEnabled(true);
        this.JCBHTA3.setEnabled(true);
        this.JCBRPM3.setEnabled(true);
        this.JCBPolih3.setEnabled(true);
        this.JCBRCIU13.setEnabled(true);
        this.JCBREmb3.setEnabled(true);
        this.JCBMPresentacion.setEnabled(true);
        this.JCBIsoInm3.setEnabled(true);
    }

    private void mCargarDatosEncabezado() {
        String sql = "SELECT `Id` , `Edad` , `Paridad` , `P3`, `P4` , `P5`, `P6`, `P7`, `P8`, `P9` , `P10` FROM `p_riego_biosicosocial` WHERE(`Id_Usuario_Programa`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "')";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.xidEncabezado = xrs.getInt(1);
                this.xedad = xrs.getInt(2);
                if (this.xedad == 0) {
                    this.JRBEntre16_35.setSelected(true);
                } else if (this.xedad == 1) {
                    this.JRBMenor_16.setSelected(true);
                } else {
                    this.JRBEntreMas_35.setSelected(true);
                }
                this.xparidad = xrs.getInt(3);
                if (this.xparidad == 0) {
                    this.JRBParidad1_4.setSelected(true);
                } else if (this.xparidad == 1) {
                    this.JRBCero.setSelected(true);
                } else {
                    this.JRBParidad5.setSelected(true);
                }
                this.xaborto = xrs.getInt(4);
                if (this.xaborto == 1) {
                    this.JCHBAborto.setSelected(true);
                } else {
                    this.JCHBAborto.setSelected(false);
                }
                this.xretPlacentaria = xrs.getInt(5);
                if (this.xretPlacentaria == 1) {
                    this.JCHBRetPlacenta.setSelected(true);
                } else {
                    this.JCHBRetPlacenta.setSelected(false);
                }
                this.xrNacidoM = xrs.getInt(6);
                if (this.xrNacidoM == 1) {
                    this.JCHBRecienNacido4000.setSelected(true);
                } else {
                    this.JCHBRecienNacido4000.setSelected(false);
                }
                this.xrNacidom = xrs.getInt(7);
                if (this.xrNacidom == 1) {
                    this.JCHBRecienNacido2500.setSelected(true);
                } else {
                    this.JCHBRecienNacido2500.setSelected(false);
                }
                this.xHTA = xrs.getInt(8);
                if (this.xHTA == 1) {
                    this.JCHBHTAInducida.setSelected(true);
                } else {
                    this.JCHBHTAInducida.setSelected(false);
                }
                this.xgemelar = xrs.getInt(9);
                if (this.xgemelar == 1) {
                    this.JCHBEmbGemelar.setSelected(true);
                } else {
                    this.JCHBEmbGemelar.setSelected(false);
                }
                this.xmortinato = xrs.getInt(10);
                if (this.xmortinato == 1) {
                    this.JCHBMortinato.setSelected(true);
                } else {
                    this.JCHBMortinato.setSelected(false);
                }
                this.xprolongado = xrs.getInt(11);
                if (this.xprolongado == 1) {
                    this.JCHBProlongado.setSelected(true);
                } else {
                    this.JCHBProlongado.setSelected(false);
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPRiesgoBiosicoSocial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosRespuestas() {
        if (this.xregistro >= 1.0d) {
            String sql = "SELECT `P11`, `P12`, `P13` , `P14`, `P15`, `P16`, `P17` , `P18`, `P19`, `P20`, `P23`, `P24`, `P25` , `P26`, `P27`,  `P29`, P22, P28, `P30`, `P31`, `P32`, `P33`, `P34`, `P35`, `Total`, SGestacion FROM `p_riesgo_biosicosocial_detalle` WHERE(`Id_Riesgo`='" + this.xidEncabezado + "') ORDER BY Id ASC";
            try {
                System.out.println("Respuestas-->" + sql);
                ResultSet xrs = this.xct.traerRs(sql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n = 0;
                    while (xrs.next()) {
                        this.xQx1 = xrs.getInt(1);
                        this.xRenal1 = xrs.getInt(2);
                        this.xGestacional1 = xrs.getInt(3);
                        this.xMellitus1 = xrs.getInt(4);
                        this.xCardiaca1 = xrs.getInt(5);
                        this.xInfecciosa1 = xrs.getInt(6);
                        this.xAutoinmune1 = xrs.getInt(7);
                        this.xAnemia1 = xrs.getInt(8);
                        this.xHemorragia1 = xrs.getInt(9);
                        this.xVaginal1 = xrs.getInt(10);
                        this.xHTAc1 = xrs.getInt(11);
                        this.xRPM1 = xrs.getInt(12);
                        this.xPolihidramnios1 = xrs.getInt(13);
                        this.xRCIU1 = xrs.getInt(14);
                        this.xMultiple1 = xrs.getInt(15);
                        this.xIsoInmunizacion = xrs.getInt(16);
                        this.xProlongado1 = xrs.getInt(17);
                        this.xMPresentacion1 = xrs.getInt(18);
                        this.xllanto = xrs.getInt(19);
                        this.xinsonmnio = xrs.getInt(20);
                        this.xtraspiracion = xrs.getInt(21);
                        this.xtiempo = xrs.getInt(22);
                        this.xespacio = xrs.getInt(23);
                        this.xdinero = xrs.getInt(24);
                        if (xrs.getDouble("SGestacion") >= 14.0d && xrs.getDouble("SGestacion") <= 27.9d) {
                            if (this.xQx1 == 1) {
                                this.JCBQx1.setSelectedItem("Sí");
                            } else {
                                this.JCBQx1.setSelectedItem("No");
                            }
                            if (this.xRenal1 == 1) {
                                this.JCBRenal1.setSelectedItem("Sí");
                            } else {
                                this.JCBRenal1.setSelectedItem("No");
                            }
                            if (this.xGestacional1 == 2) {
                                this.JCBDiabetesG1.setSelectedItem("Sí");
                            } else {
                                this.JCBDiabetesG1.setSelectedItem("No");
                            }
                            if (this.xMellitus1 == 3) {
                                this.JCBDiabetesM1.setSelectedItem("Sí");
                            } else {
                                this.JCBDiabetesM1.setSelectedItem("No");
                            }
                            if (this.xCardiaca1 == 3) {
                                this.JCBECardiaca1.setSelectedItem("Sí");
                            } else {
                                this.JCBECardiaca1.setSelectedItem("No");
                            }
                            if (this.xInfecciosa1 == 1) {
                                this.JCBEInfecciosa1.setSelectedItem("Sí");
                            } else {
                                this.JCBEInfecciosa1.setSelectedItem("No");
                            }
                            if (this.xAutoinmune1 == 3) {
                                this.JCBEAuto1.setSelectedItem("Sí");
                            } else {
                                this.JCBEAuto1.setSelectedItem("No");
                            }
                            if (this.xAnemia1 == 1) {
                                this.JCBAnemia1.setSelectedItem("Sí");
                            } else {
                                this.JCBAnemia1.setSelectedItem("No");
                            }
                            if (this.xHemorragia1 == 1) {
                                this.JCBHemorragia1.setSelectedItem("Sí");
                            } else {
                                this.JCBHemorragia1.setSelectedItem("No");
                            }
                            if (this.xVaginal1 == 3) {
                                this.JCBVaginal1.setSelectedItem("Sí");
                            } else {
                                this.JCBVaginal1.setSelectedItem("No");
                            }
                            if (this.xHTAc1 == 2) {
                                this.JCBHTA1.setSelectedItem("Sí");
                            } else {
                                this.JCBHTA1.setSelectedItem("No");
                            }
                            if (this.xRPM1 == 2) {
                                this.JCBRPM1.setSelectedItem("Sí");
                            } else {
                                this.JCBRPM1.setSelectedItem("No");
                            }
                            if (this.xPolihidramnios1 == 2) {
                                this.JCBPolih1.setSelectedItem("Sí");
                            } else {
                                this.JCBPolih1.setSelectedItem("No");
                            }
                            if (this.xRCIU1 == 3) {
                                this.JCBRCIU1.setSelectedItem("Sí");
                            } else {
                                this.JCBRCIU1.setSelectedItem("No");
                            }
                            if (this.xMultiple1 == 3) {
                                this.JCBREmb1.setSelectedItem("Sí");
                            } else {
                                this.JCBREmb1.setSelectedItem("No");
                            }
                            if (this.xIsoInmunizacion == 3) {
                                this.JCBIsoInm1.setSelectedItem("Sí");
                            } else {
                                this.JCBIsoInm1.setSelectedItem("No");
                            }
                            this.stotal1 = this.xQx1 + this.xRenal1 + this.xGestacional1 + this.xMellitus1 + this.xCardiaca1 + this.xInfecciosa1 + this.xAutoinmune1 + this.xAnemia1;
                            this.stotal2 = this.xHemorragia1 + this.xVaginal1 + this.xHTAc1 + this.xRPM1 + this.xPolihidramnios1 + this.xRCIU1 + this.xMultiple1 + this.xIsoInmunizacion;
                            this.JTFSubtotal1.setValue(Integer.valueOf(this.stotal1));
                            this.JTFSubtotal4.setValue(Integer.valueOf(this.stotal2));
                            this.JTFSubtotal2.setValue(0);
                            this.JTFSubtotal5.setValue(0);
                            if (this.xllanto == 1) {
                                this.JRBIntenso1.setSelected(true);
                            } else {
                                this.JRBAusente1.setSelected(true);
                            }
                            if (this.xinsonmnio == 1) {
                                this.JRBIntenso2.setSelected(true);
                            } else {
                                this.JRBAusente2.setSelected(true);
                            }
                            if (this.xtraspiracion == 1) {
                                this.JRBIntenso3.setSelected(true);
                            } else {
                                this.JRBAusente3.setSelected(true);
                            }
                            this.stotal3 = this.xllanto + this.xinsonmnio + this.xtraspiracion;
                            if (this.stotal3 >= 2) {
                                this.JTFR1Valor1.setText("1");
                            } else {
                                this.JTFR1Valor1.setText("0");
                            }
                            if (this.xtiempo == 2) {
                                this.JRBNuncaTiempo.setSelected(true);
                            } else {
                                this.JRBCasiTiempo.setSelected(true);
                            }
                            if (this.xespacio == 2) {
                                this.JRBNuncaEspacio.setSelected(true);
                            } else {
                                this.JRBCasiEspacio.setSelected(true);
                            }
                            if (this.xdinero == 2) {
                                this.JRBNuncaDinero.setSelected(true);
                            } else {
                                this.JRBCasiDinero.setSelected(true);
                            }
                            this.stotal4 = this.xtiempo + this.xespacio + this.xdinero;
                            if (this.stotal4 >= 4) {
                                this.JTFR2Valor1.setText("1");
                            } else {
                                this.JTFR2Valor1.setText("0");
                            }
                            this.JTFTotal1.setText(xrs.getString("Total"));
                            enableComponents(this.JPDetalles, true);
                        } else if (xrs.getDouble("SGestacion") >= 28.0d && xrs.getDouble("SGestacion") <= 32.9d) {
                            if (this.xQx1 == 1) {
                                this.JCBQx2.setSelectedItem("Sí");
                            } else {
                                this.JCBQx2.setSelectedItem("No");
                            }
                            if (this.xRenal1 == 1) {
                                this.JCBRenal2.setSelectedItem("Sí");
                            } else {
                                this.JCBRenal2.setSelectedItem("No");
                            }
                            if (this.xGestacional1 == 2) {
                                this.JCBDiabetesG2.setSelectedItem("Sí");
                            } else {
                                this.JCBDiabetesG2.setSelectedItem("No");
                            }
                            if (this.xMellitus1 == 3) {
                                this.JCBDiabetesM2.setSelectedItem("Sí");
                            } else {
                                this.JCBDiabetesM2.setSelectedItem("No");
                            }
                            if (this.xCardiaca1 == 3) {
                                this.JCBECardiaca2.setSelectedItem("Sí");
                            } else {
                                this.JCBECardiaca2.setSelectedItem("No");
                            }
                            if (this.xInfecciosa1 == 1) {
                                this.JCBEInfecciosa2.setSelectedItem("Sí");
                            } else {
                                this.JCBEInfecciosa2.setSelectedItem("No");
                            }
                            if (this.xAutoinmune1 == 3) {
                                this.JCBEAuto2.setSelectedItem("Sí");
                            } else {
                                this.JCBEAuto2.setSelectedItem("No");
                            }
                            if (this.xAnemia1 == 1) {
                                this.JCBAnemia2.setSelectedItem("Sí");
                            } else {
                                this.JCBAnemia2.setSelectedItem("No");
                            }
                            if (this.xHemorragia1 == 1) {
                                this.JCBHemorragia2.setSelectedItem("Sí");
                            } else {
                                this.JCBHemorragia2.setSelectedItem("No");
                            }
                            if (this.xVaginal1 == 3) {
                                this.JCBVaginal2.setSelectedItem("Sí");
                            } else {
                                this.JCBVaginal2.setSelectedItem("No");
                            }
                            if (this.xHTAc1 == 2) {
                                this.JCBHTA2.setSelectedItem("Sí");
                            } else {
                                this.JCBHTA2.setSelectedItem("No");
                            }
                            if (this.xRPM1 == 2) {
                                this.JCBRPM2.setSelectedItem("Sí");
                            } else {
                                this.JCBRPM2.setSelectedItem("No");
                            }
                            if (this.xPolihidramnios1 == 2) {
                                this.JCBPolih2.setSelectedItem("Sí");
                            } else {
                                this.JCBPolih2.setSelectedItem("No");
                            }
                            if (this.xRCIU1 == 3) {
                                this.JCBRCIU2.setSelectedItem("Sí");
                            } else {
                                this.JCBRCIU2.setSelectedItem("No");
                            }
                            if (this.xMultiple1 == 3) {
                                this.JCBREmb2.setSelectedItem("Sí");
                            } else {
                                this.JCBREmb2.setSelectedItem("No");
                            }
                            if (this.xIsoInmunizacion == 3) {
                                this.JCBIsoInm2.setSelectedItem("Sí");
                            } else {
                                this.JCBIsoInm2.setSelectedItem("No");
                            }
                            this.stotal1 = this.xQx1 + this.xRenal1 + this.xGestacional1 + this.xMellitus1 + this.xCardiaca1 + this.xInfecciosa1 + this.xAutoinmune1 + this.xAnemia1;
                            this.stotal2 = this.xHemorragia1 + this.xVaginal1 + this.xHTAc1 + this.xRPM1 + this.xPolihidramnios1 + this.xRCIU1 + this.xMultiple1 + this.xIsoInmunizacion;
                            this.JTFSubtotal2.setValue(Integer.valueOf(this.stotal1));
                            this.JTFSubtotal5.setValue(Integer.valueOf(this.stotal2));
                            this.JTFSubtotal3.setValue(0);
                            this.JTFSubtotal6.setValue(0);
                            if (this.xllanto == 1) {
                                this.JRBIntenso4.setSelected(true);
                            } else {
                                this.JRBAusente4.setSelected(true);
                            }
                            if (this.xinsonmnio == 1) {
                                this.JRBIntenso5.setSelected(true);
                            } else {
                                this.JRBAusente5.setSelected(true);
                            }
                            if (this.xtraspiracion == 1) {
                                this.JRBIntenso6.setSelected(true);
                            } else {
                                this.JRBAusente6.setSelected(true);
                            }
                            this.stotal3 = this.xllanto + this.xinsonmnio + this.xtraspiracion;
                            if (this.stotal3 >= 2) {
                                this.JTFR1Valor2.setText("1");
                            } else {
                                this.JTFR1Valor2.setText("0");
                            }
                            if (this.xtiempo == 2) {
                                this.JRBNuncaTiempo1.setSelected(true);
                            } else {
                                this.JRBCasiTiempo1.setSelected(true);
                            }
                            if (this.xespacio == 2) {
                                this.JRBNuncaEspacio1.setSelected(true);
                            } else {
                                this.JRBCasiEspacio1.setSelected(true);
                            }
                            if (this.xdinero == 2) {
                                this.JRBNuncaDinero1.setSelected(true);
                            } else {
                                this.JRBCasiDinero1.setSelected(true);
                            }
                            this.stotal4 = this.xtiempo + this.xespacio + this.xdinero;
                            if (this.stotal4 >= 4) {
                                this.JTFR2Valor2.setText("1");
                            } else {
                                this.JTFR2Valor2.setText("0");
                            }
                            this.JTFTotal2.setText(xrs.getString("Total"));
                            enableComponents(this.JPDetalles1, true);
                        } else if (xrs.getDouble("SGestacion") >= 33.0d && xrs.getDouble("SGestacion") <= 42.0d) {
                            if (this.xQx1 == 1) {
                                this.JCBQx3.setSelectedItem("Sí");
                            } else {
                                this.JCBQx3.setSelectedItem("No");
                            }
                            if (this.xRenal1 == 1) {
                                this.JCBRenal3.setSelectedItem("Sí");
                            } else {
                                this.JCBRenal3.setSelectedItem("No");
                            }
                            if (this.xGestacional1 == 2) {
                                this.JCBDiabetesG3.setSelectedItem("Sí");
                            } else {
                                this.JCBDiabetesG3.setSelectedItem("No");
                            }
                            if (this.xMellitus1 == 3) {
                                this.JCBDiabetesM3.setSelectedItem("Sí");
                            } else {
                                this.JCBDiabetesM3.setSelectedItem("No");
                            }
                            if (this.xCardiaca1 == 3) {
                                this.JCBECardiaca3.setSelectedItem("Sí");
                            } else {
                                this.JCBECardiaca3.setSelectedItem("No");
                            }
                            if (this.xInfecciosa1 == 1) {
                                this.JCBEInfecciosa3.setSelectedItem("Sí");
                            } else {
                                this.JCBEInfecciosa3.setSelectedItem("No");
                            }
                            if (this.xAutoinmune1 == 3) {
                                this.JCBEAuto3.setSelectedItem("Sí");
                            } else {
                                this.JCBEAuto3.setSelectedItem("No");
                            }
                            if (this.xAnemia1 == 1) {
                                this.JCBAnemia3.setSelectedItem("Sí");
                            } else {
                                this.JCBAnemia3.setSelectedItem("No");
                            }
                            if (this.xHemorragia1 == 1) {
                                this.JCBHemorragia3.setSelectedItem("Sí");
                            } else {
                                this.JCBHemorragia3.setSelectedItem("No");
                            }
                            if (this.xVaginal1 == 3) {
                                this.JCBVaginal3.setSelectedItem("Sí");
                            } else {
                                this.JCBVaginal3.setSelectedItem("No");
                            }
                            if (this.xHTAc1 == 2) {
                                this.JCBHTA3.setSelectedItem("Sí");
                            } else {
                                this.JCBHTA3.setSelectedItem("No");
                            }
                            if (this.xRPM1 == 2) {
                                this.JCBRPM3.setSelectedItem("Sí");
                            } else {
                                this.JCBRPM3.setSelectedItem("No");
                            }
                            if (this.xPolihidramnios1 == 2) {
                                this.JCBPolih3.setSelectedItem("Sí");
                            } else {
                                this.JCBPolih3.setSelectedItem("No");
                            }
                            if (this.xRCIU1 == 3) {
                                this.JCBRCIU13.setSelectedItem("Sí");
                            } else {
                                this.JCBRCIU13.setSelectedItem("No");
                            }
                            if (this.xMultiple1 == 3) {
                                this.JCBREmb3.setSelectedItem("Sí");
                            } else {
                                this.JCBREmb3.setSelectedItem("No");
                            }
                            if (this.xIsoInmunizacion == 3) {
                                this.JCBIsoInm3.setSelectedItem("Sí");
                            } else {
                                this.JCBIsoInm3.setSelectedItem("No");
                            }
                            if (this.xProlongado1 == 1) {
                                this.JCBProlongado.setSelectedItem("Sí");
                            } else {
                                this.JCBProlongado.setSelectedItem("No");
                            }
                            if (this.xMPresentacion1 == 3) {
                                this.JCBMPresentacion.setSelectedItem("Sí");
                            } else {
                                this.JCBMPresentacion.setSelectedItem("No");
                            }
                            this.stotal1 = this.xQx1 + this.xRenal1 + this.xGestacional1 + this.xMellitus1 + this.xCardiaca1 + this.xInfecciosa1 + this.xAutoinmune1 + this.xAnemia1;
                            this.stotal2 = this.xHemorragia1 + this.xVaginal1 + this.xHTAc1 + this.xRPM1 + this.xPolihidramnios1 + this.xRCIU1 + this.xMultiple1 + this.xIsoInmunizacion + this.xProlongado1 + this.xMPresentacion1;
                            this.JTFSubtotal3.setValue(Integer.valueOf(this.stotal1));
                            this.JTFSubtotal6.setValue(Integer.valueOf(this.stotal2));
                            if (this.xllanto == 1) {
                                this.JRBIntenso7.setSelected(true);
                            } else {
                                this.JRBAusente7.setSelected(true);
                            }
                            if (this.xinsonmnio == 1) {
                                this.JRBIntenso8.setSelected(true);
                            } else {
                                this.JRBAusente8.setSelected(true);
                            }
                            if (this.xtraspiracion == 1) {
                                this.JRBIntenso9.setSelected(true);
                            } else {
                                this.JRBAusente9.setSelected(true);
                            }
                            this.stotal3 = this.xllanto + this.xinsonmnio + this.xtraspiracion;
                            if (this.stotal3 >= 2) {
                                this.JTFR1Valor3.setText("1");
                            } else {
                                this.JTFR1Valor3.setText("0");
                            }
                            if (this.xtiempo == 2) {
                                this.JRBNuncaTiempo2.setSelected(true);
                            } else {
                                this.JRBCasiTiempo2.setSelected(true);
                            }
                            if (this.xespacio == 2) {
                                this.JRBNuncaEspacio2.setSelected(true);
                            } else {
                                this.JRBCasiEspacio2.setSelected(true);
                            }
                            if (this.xdinero == 2) {
                                this.JRBNuncaDinero2.setSelected(true);
                            } else {
                                this.JRBCasiDinero2.setSelected(true);
                            }
                            this.stotal4 = this.xtiempo + this.xespacio + this.xdinero;
                            if (this.stotal4 >= 4) {
                                this.JTFR2Valor3.setText("1");
                            } else {
                                this.JTFR2Valor3.setText("0");
                            }
                            this.JTFTotal3.setText(xrs.getString("Total"));
                            enableComponents(this.JPDetalles2, true);
                        }
                        n++;
                    }
                }
                mResetearVariables();
                xrs.close();
                this.xct.cerrarConexionBd();
                this.xlleno = true;
            } catch (SQLException ex) {
                Logger.getLogger(JPRiesgoBiosicoSocial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mCalculaSTotal1(double xregistro) {
        this.stotal1 = 0;
        this.stotal1 = this.xQx1 + this.xRenal1 + this.xGestacional1 + this.xMellitus1 + this.xCardiaca1 + this.xInfecciosa1 + this.xAutoinmune1 + this.xAnemia1;
        if (xregistro >= 14.0d && xregistro <= 27.9d) {
            this.JTFSubtotal1.setValue(Integer.valueOf(this.stotal1));
            return;
        }
        if (xregistro >= 28.0d && xregistro <= 32.9d) {
            this.JTFSubtotal2.setValue(Integer.valueOf(this.stotal1));
        } else if (xregistro >= 33.0d && xregistro <= 42.0d) {
            this.JTFSubtotal3.setValue(Integer.valueOf(this.stotal1));
        }
    }

    private void mCalculaSTotal2(double xregistro) {
        this.stotal2 = 0;
        if (xregistro >= 14.0d && xregistro <= 27.9d) {
            this.stotal2 = this.xHemorragia1 + this.xVaginal1 + this.xHTAc1 + this.xRPM1 + this.xPolihidramnios1 + this.xRCIU1 + this.xMultiple1 + this.xIsoInmunizacion;
            this.JTFSubtotal4.setValue(Integer.valueOf(this.stotal2));
        } else if (xregistro >= 28.0d && xregistro <= 32.9d) {
            this.stotal2 = this.xHemorragia1 + this.xVaginal1 + this.xHTAc1 + this.xRPM1 + this.xPolihidramnios1 + this.xRCIU1 + this.xMultiple1 + this.xIsoInmunizacion;
            this.JTFSubtotal5.setValue(Integer.valueOf(this.stotal2));
        } else if (xregistro >= 33.0d && xregistro <= 42.0d) {
            this.stotal2 = this.xHemorragia1 + this.xVaginal1 + this.xHTAc1 + this.xRPM1 + this.xPolihidramnios1 + this.xRCIU1 + this.xMultiple1 + this.xIsoInmunizacion + this.xProlongado1 + this.xMPresentacion1;
            this.JTFSubtotal6.setValue(Integer.valueOf(this.stotal2));
        }
    }

    private void mResetearVariables() {
        this.xQx1 = 0;
        this.xRenal1 = 0;
        this.xGestacional1 = 0;
        this.xMellitus1 = 0;
        this.xCardiaca1 = 0;
        this.xInfecciosa1 = 0;
        this.xAutoinmune1 = 0;
        this.xAnemia1 = 0;
        this.xHemorragia1 = 0;
        this.xVaginal1 = 0;
        this.xProlongado1 = 0;
        this.xHTAc1 = 0;
        this.xRPM1 = 0;
        this.xPolihidramnios1 = 0;
        this.xRCIU1 = 0;
        this.xMultiple1 = 0;
        this.xMPresentacion1 = 0;
        this.xIsoInmunizacion = 0;
        this.xllanto = 0;
        this.xinsonmnio = 0;
        this.xtraspiracion = 0;
        this.xtiempo = 0;
        this.xespacio = 0;
        this.xdinero = 0;
    }

    private void mIniciarTotales() {
        int totalEmcabezado = this.xedad + this.xparidad + this.xaborto + this.xretPlacentaria + this.xrNacidoM + this.xrNacidom + this.xHTA + this.xgemelar + this.xmortinato + this.xprolongado;
        if (this.xregistro >= 14.0d && this.xregistro <= 27.9d) {
            int total1 = Integer.parseInt(this.JTFSubtotal1.getText()) + Integer.parseInt(this.JTFSubtotal4.getText()) + Integer.parseInt(this.JTFR1Valor1.getText()) + Integer.parseInt(this.JTFR2Valor1.getText()) + totalEmcabezado;
            this.JTFTotal1.setText(String.valueOf(total1));
        } else if (this.xregistro >= 28.0d && this.xregistro <= 32.9d) {
            int total2 = Integer.parseInt(this.JTFSubtotal2.getText()) + Integer.parseInt(this.JTFSubtotal5.getText()) + Integer.parseInt(this.JTFR1Valor2.getText()) + Integer.parseInt(this.JTFR2Valor2.getText()) + totalEmcabezado;
            this.JTFTotal2.setText(String.valueOf(total2));
        } else if (this.xregistro >= 33.0d && this.xregistro <= 42.0d) {
            int total3 = Integer.parseInt(this.JTFSubtotal3.getText()) + Integer.parseInt(this.JTFSubtotal6.getText()) + Integer.parseInt(this.JTFR1Valor3.getText()) + Integer.parseInt(this.JTFR2Valor3.getText()) + totalEmcabezado;
            this.JTFTotal3.setText(String.valueOf(total3));
        }
        if (Integer.parseInt(this.JTFTotal1.getText()) >= 3) {
            this.JPTotal14_27.setBackground(Color.red);
            this.JLSemana24_27.setForeground(Color.WHITE);
            this.JLTotal1.setForeground(Color.WHITE);
        } else {
            this.JPTotal14_27.setBackground(new Color(238, 238, 238));
            this.JLSemana24_27.setForeground(Color.BLUE);
            this.JLTotal1.setForeground(Color.RED);
        }
        if (Integer.parseInt(this.JTFTotal2.getText()) >= 3) {
            this.JPTotal28_38.setBackground(Color.red);
            this.JLSemana28_32.setForeground(Color.WHITE);
            this.JLTotal2.setForeground(Color.WHITE);
        } else {
            this.JPTotal28_38.setBackground(new Color(238, 238, 238));
            this.JLSemana28_32.setForeground(Color.BLUE);
            this.JLTotal2.setForeground(Color.RED);
        }
        if (Integer.parseInt(this.JTFTotal3.getText()) >= 3) {
            this.JPTotal33_42.setBackground(Color.red);
            this.JLSemana33_48.setForeground(Color.WHITE);
            this.JLTotal3.setForeground(Color.WHITE);
        } else {
            this.JPTotal33_42.setBackground(new Color(238, 238, 238));
            this.JLSemana33_48.setForeground(Color.BLUE);
            this.JLTotal3.setForeground(Color.RED);
        }
    }

    private void mCalculaCombos(double xregistro) {
        int total = this.xllanto + this.xinsonmnio + this.xtraspiracion;
        if (xregistro >= 14.0d && xregistro <= 27.9d) {
            if (total >= 2) {
                this.JTFR1Valor1.setText("1");
                return;
            } else {
                this.JTFR1Valor1.setText("0");
                return;
            }
        }
        if (xregistro >= 28.0d && xregistro <= 32.9d) {
            if (total >= 2) {
                this.JTFR1Valor2.setText("1");
                return;
            } else {
                this.JTFR1Valor2.setText("0");
                return;
            }
        }
        if (xregistro >= 33.0d && xregistro <= 42.0d) {
            if (total >= 2) {
                this.JTFR1Valor3.setText("1");
            } else {
                this.JTFR1Valor3.setText("0");
            }
        }
    }

    private void mCalculaCombos2(double xregistro) {
        int total = this.xtiempo + this.xespacio + this.xdinero;
        if (xregistro >= 14.0d && xregistro <= 27.9d) {
            if (total >= 4) {
                this.JTFR2Valor1.setText("1");
                return;
            } else {
                this.JTFR2Valor1.setText("0");
                return;
            }
        }
        if (xregistro >= 28.0d && xregistro <= 32.9d) {
            if (total >= 4) {
                this.JTFR2Valor2.setText("1");
                return;
            } else {
                this.JTFR2Valor2.setText("0");
                return;
            }
        }
        if (xregistro >= 33.0d && xregistro <= 42.0d) {
            if (total >= 4) {
                this.JTFR2Valor3.setText("1");
            } else {
                this.JTFR2Valor3.setText("0");
            }
        }
    }

    private void mConsultaEdad() {
        String sql = "SELECT `Edad`FROM `g_persona` WHERE (`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                int xedadUsuario = xrs.getInt(1);
                if (xedadUsuario < 16) {
                    this.JRBMenor_16.setSelected(true);
                    this.xedad = 1;
                    this.JRBMenor_16.setEnabled(false);
                    this.JRBEntre16_35.setEnabled(false);
                    this.JRBEntreMas_35.setEnabled(false);
                } else if (xedadUsuario >= 16 && xedadUsuario <= 35) {
                    this.JRBEntre16_35.setSelected(true);
                    this.xedad = 0;
                    this.JRBMenor_16.setEnabled(false);
                    this.JRBEntre16_35.setEnabled(false);
                    this.JRBEntreMas_35.setEnabled(false);
                } else {
                    this.JRBEntreMas_35.setSelected(true);
                    this.xedad = 2;
                    this.JRBMenor_16.setEnabled(false);
                    this.JRBEntre16_35.setEnabled(false);
                    this.JRBEntreMas_35.setEnabled(false);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPRiesgoBiosicoSocial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            if (component instanceof Container) {
                enableComponents((Container) component, enable);
            }
        }
    }
}
